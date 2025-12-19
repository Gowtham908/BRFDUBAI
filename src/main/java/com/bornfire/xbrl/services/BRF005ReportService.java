package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.BRF5B_SUMMARY_ENTITY;
import com.bornfire.xbrl.entities.BRF5_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF05_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF05_ENTITY3;
import com.bornfire.xbrl.entities.BRBS.BRF05_REP1;
import com.bornfire.xbrl.entities.BRBS.BRF05_REP2;
import com.bornfire.xbrl.entities.BRBS.BRF05_REP3;
import com.bornfire.xbrl.entities.BRBS.BRF5_DetaiRep1;
import com.bornfire.xbrl.entities.BRBS.BRF5_Detail_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF5_ENTITY;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.BRF5B_SUMM_REP;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
@Transactional
@ConfigurationProperties("output")
public class BRF005ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF005ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF5_DetaiRep1 BRF5_DetaiRep;

	@Autowired
	BRF5B_SUMM_REP BRF5B_SUMM_REP;

	@Autowired
	BRF05_REP1 brf05_REP1;

	@Autowired
	BRF05_REP2 brf05_REP2;

	@Autowired
	BRF05_REP3 brf05_REP3;
	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheck(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF05_ENTITY1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF05_ENTITY1 a").getSingleResult();
				if (modcnt > 0) {
					msg = "success";
				}
			} else {
				// msg = "Data Not available for the Report. Please Contact Administrator";
				msg = "success";

			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "success";
			e.printStackTrace();

		}

		return msg;

	}

	public ModelAndView getBRF005View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF5_ENTITY> T1rep = new ArrayList<BRF5_ENTITY>();
		// Query<Object[]> qr;

		List<BRF05_ENTITY1> T1Master = new ArrayList<BRF05_ENTITY1>();
		List<BRF5B_SUMMARY_ENTITY> T1Master1 = new ArrayList<BRF5B_SUMMARY_ENTITY>();
		List<BRF05_ENTITY3> T1Master2 = new ArrayList<BRF05_ENTITY3>();
		List<Object[]> myentity2 = new ArrayList<Object[]>();
		List<Object[]> myentity3 = new ArrayList<Object[]>();

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs
					.createQuery("from BRF05_ENTITY1 a where a.report_date = ?1 order by srl_no", BRF05_ENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.
			 * createQuery("from BRF5B_SUMMARY_ENTITY a where a.report_date = ?1 order by srl_no"
			 * , BRF5B_SUMMARY_ENTITY.class).setParameter(1,
			 * df.parse(todate)).getResultList();
			 * 
			 * T1Master2 = hs.
			 * createQuery("from BRF05_ENTITY3 a where a.report_date = ?1 order by srl_no",
			 * BRF05_ENTITY3.class).setParameter(1, df.parse(todate)).getResultList();
			 */

			/*
			 * T1Master = hs.createQuery("from  BRF05_ENTITY1 a where a.report_date = ?1 ",
			 * BRF05_ENTITY1.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

			myentity2 = brf05_REP2.findallvalues(todate);

			System.out.println(myentity2.toString());
			for (Object[] BRF0052 : myentity2) {
				BRF5B_SUMMARY_ENTITY BRF005_ENTITY2 = new BRF5B_SUMMARY_ENTITY();
				BRF005_ENTITY2.setInvestment_types(((String) BRF0052[0])); // Investment Types
				BRF005_ENTITY2.setSecurity_identifier(((String) BRF0052[1])); // Security Identifier
				BRF005_ENTITY2.setUnits_held(((BigDecimal) BRF0052[2])); // Units Held
				BRF005_ENTITY2.setCountry(((String) BRF0052[3])); // Country
				BRF005_ENTITY2.setCcy(((String) BRF0052[4])); // CCY
				BRF005_ENTITY2.setAmount(((BigDecimal) BRF0052[5])); // Amount
				BRF005_ENTITY2.setAed_equivalent(((BigDecimal) BRF0052[6])); // AED Equivalent
				BRF005_ENTITY2.setRating(((BigDecimal) BRF0052[7])); // Rating
				BRF005_ENTITY2.setRating_type(((String) BRF0052[8])); // Rating Type
				BRF005_ENTITY2.setMarket_value(((BigDecimal) BRF0052[9])); // Market Value
				BRF005_ENTITY2.setCounterparty_type(((String) BRF0052[10])); // Counterparty Type
				BRF005_ENTITY2.setSecurity_identifier_validation(((String) BRF0052[11])); // Security Identifier
																							// Validation
				BRF005_ENTITY2.setCountry_validation(((String) BRF0052[12])); // Country Validation
				BRF005_ENTITY2.setRating_validation(((String) BRF0052[13])); // Rating Validation
				BRF005_ENTITY2.setCounterparty_type_validation(((String) BRF0052[14])); // Counterparty Type Validation
				BRF005_ENTITY2.setRow_valid(((String) BRF0052[15])); // Row Valid
				BRF005_ENTITY2.setRow_label(((String) BRF0052[16])); // Row Label
				BRF005_ENTITY2.setReport_date(((Date) BRF0052[17])); // Report Date
				BRF005_ENTITY2.setReport_addl_criteria_1(((String) BRF0052[18])); // Report Additional Criteria 1
				BRF005_ENTITY2.setNominal(((String) BRF0052[19]));
				T1Master1.add(BRF005_ENTITY2);
			}
			myentity3 = brf05_REP3.findallvalues(todate);
			for (Object[] BRF005_3 : myentity3) {
				BRF05_ENTITY3 BRF005_ENTITY3 = new BRF05_ENTITY3();
				BRF005_ENTITY3.setInvestment_types1(((String) BRF005_3[0])); // Investment Types
				BRF005_ENTITY3.setSecurity_identifier1(((String) BRF005_3[1])); // Security Identifier
				BRF005_ENTITY3.setUnits_held1(((BigDecimal) BRF005_3[2])); // Units Held
				BRF005_ENTITY3.setCountry1(((String) BRF005_3[3])); // Country
				BRF005_ENTITY3.setCcy1(((String) BRF005_3[4])); // CCY
				BRF005_ENTITY3.setAmount1(((BigDecimal) BRF005_3[5])); // Amount
				BRF005_ENTITY3.setAed_equivalent1(((BigDecimal) BRF005_3[6])); // AED Equivalent
				BRF005_ENTITY3.setRating1(((BigDecimal) BRF005_3[7])); // Rating
				BRF005_ENTITY3.setRating_type1(((String) BRF005_3[8])); // Rating Type
				BRF005_ENTITY3.setMarket_value1(((BigDecimal) BRF005_3[9])); // Market Value
				BRF005_ENTITY3.setCounterparty_type1(((String) BRF005_3[10])); // Counterparty Type
				BRF005_ENTITY3.setSecurity_identifier_validation1(((String) BRF005_3[11])); // Security Identifier
																							// Validation
				BRF005_ENTITY3.setCountry_validation1(((String) BRF005_3[12])); // Country Validation
				BRF005_ENTITY3.setRating_validation1(((String) BRF005_3[13])); // Rating Validation
				BRF005_ENTITY3.setCounterparty_type_validation1(((String) BRF005_3[14])); // Counterparty Type
																							// Validation
				BRF005_ENTITY3.setRow_valid1(((String) BRF005_3[15])); // Row Valid
				BRF005_ENTITY3.setRow_label1(((String) BRF005_3[16])); // Row Label
				BRF005_ENTITY3.setReport_date(((Date) BRF005_3[17])); // Report Date
				BRF005_ENTITY3.setReport_addl_criteria_11(((String) BRF005_3[18])); // Report Additional Criteria 1
				BRF005_ENTITY3.setNominal1(((String) BRF005_3[19]));
				T1Master2.add(BRF005_ENTITY3);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF5");
		mv.addObject("reportsummary2", T1Master1);
		mv.addObject("reportsummary3", T1Master2);
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary1", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		// mv.addObject("reportsummary2", myentity);
		/* mv.addObject("reportsummary1", T1Master1); */

		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF005currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<Object> T1Dt1 = new ArrayList<Object>();

		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			if (!filter.equals("null")) {
				qr = hs.createNativeQuery(
						"select * from BRF5_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF5_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF5_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF5_Detail_Entity> T1Master = new ArrayList<BRF5_Detail_Entity>();

		try {
			T1Master = hs.createQuery("from BRF5_Detail_Entity a where a.report_date = ?1", BRF5_Detail_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String sol_id = (String) a[0];
			String acid = (String) a[1];
			String foracid = (String) a[2];
			String acct_name = (String) a[3];
			Character nre_flg = (Character) a[4];
			Character del_flg = (Character) a[5];
			String create_user = (String) a[6];
			String modify_user = (String) a[7];
			String report_label_1 = (String) a[8];
			String report_name_1 = (String) a[9];
			Date report_date = (Date) a[10];
			String version_control = (String) a[11];
			String cust_id = (String) a[12];
			String verify_user = (String) a[13];
			Character entity_flg = (Character) a[14];
			String remarks = (String) a[15];
			BigDecimal acct_balance_amt_lc = (BigDecimal) a[16];
			BigDecimal eab_lc = (BigDecimal) a[17];
			String acct_crncy_code = (String) a[18];
			String gl_code = (String) a[19];
			String gl_sub_head_code = (String) a[20];
			String gl_sub_head_desc = (String) a[21];
			String country_of_incorp = (String) a[22];
			String cust_type = (String) a[23];
			String schm_code = (String) a[24];
			String schm_type = (String) a[25];
			String segment = (String) a[26];
			String sub_segment = (String) a[27];
			BigDecimal sector = (BigDecimal) a[28];
			String sub_sector = (String) a[29];
			String sector_code = (String) a[30];
			String group_id = (String) a[31];
			String constitution_code = (String) a[32];
			String country = (String) a[33];
			String legal_entity_type = (String) a[34];
			String constitution_desc = (String) a[35];
			String purpose_of_advn = (String) a[36];
			BigDecimal hni_networth = (BigDecimal) a[37];
			String turnover = (String) a[38];
			String bacid = (String) a[39];
			String report_addl_criteria_1 = (String) a[40];
			String report_addl_criteria_2 = (String) a[41];
			String report_addl_criteria_3 = (String) a[42];
			Date create_time = (Date) a[43];
			Date modify_time = (Date) a[44];
			Date verify_time = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			Character nre_status = (Character) a[48];
			Character modify_flg = (Character) a[49];
			BigDecimal acct_balance_amt_ac = (BigDecimal) a[50];
			String Remarks1;
			if (acct_balance_amt_lc != null) {
				if (acct_balance_amt_lc.toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}
			if (acct_balance_amt_ac != null) {
				if (acct_balance_amt_ac.toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}
			BRF5_Detail_Entity py = new BRF5_Detail_Entity(sol_id, acid, foracid, acct_name, nre_flg, del_flg,
					create_user, modify_user, report_label_1, report_name_1, report_date, version_control, cust_id,
					verify_user, entity_flg, remarks, acct_balance_amt_lc, eab_lc, acct_crncy_code, gl_code,
					gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, segment,
					sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, country,
					legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_time, modify_time,
					verify_time, maturity_date, gender, nre_status, modify_flg, acct_balance_amt_ac);
			T1Dt1.add(py);

		}
		;
		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("RR" + "/" + "BRF5::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFile(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-005-A";
		/*
		 * try { SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); Date
		 * ConDate = dateFormat1.parse(todate); System.out.println(ConDate);
		 * SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy"); String
		 * strDate1 = formatter1.format(ConDate); fileName = "t" + reportId + "_" +
		 * strDate1;
		 * 
		 * 
		 * } catch (ParseException e1) {
		 * 
		 * logger.info(e1.getMessage()); e1.printStackTrace(); }
		 */

		if (!filetype.equals("xbrl")) {

			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF5_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF5_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF5.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF5.jrxml");
						}
					}

					/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
					JasperReport jr = JasperCompileManager.compileReport(jasperFile);
					HashMap<String, Object> map = new HashMap<String, Object>();

					logger.info("Assigning Parameters for Jasper");
					map.put("REPORT_DATE", todate);
					/*
					 * try { SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); Date
					 * ConDate = dateFormat1.parse(todate); SimpleDateFormat formatter1 = new
					 * SimpleDateFormat("dd-MMM-yyyy"); String strDate1 =
					 * formatter1.format(ConDate);
					 * 
					 * String today = dateFormat.format(new
					 * SimpleDateFormat("dd-MMM-yyyy").parse(strDate1));
					 * 
					 * } catch (ParseException e1) {
					 * 
					 * logger.info(e1.getMessage()); e1.printStackTrace(); }
					 */
					if (filetype.equals("pdf")) {
						fileName = fileName + ".pdf";
						path += fileName;
						JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
						JasperExportManager.exportReportToPdfFile(jp, path);
						logger.info("PDF File exported");
					} else {

						System.out.println("EXCEEEEEll");
						fileName = fileName + ".xlsx";
						path += fileName;
						JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
						JRXlsxExporter exporter = new JRXlsxExporter();
						exporter.setExporterInput(new SimpleExporterInput(jp));
						exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
						exporter.exportReport();
						logger.info("Excel File exported");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				outputFile = new File(path);

				return outputFile;

			} else {

				/* file type "BRF" */

				try {

					Session hs = sessionFactory.getCurrentSession();
					Date d1 = df.parse(todate);

					/* Static Values Table */
					List<BRF05_ENTITY1> T1Master = new ArrayList<BRF05_ENTITY1>();

					/* DEPT Securities */
					List<Object[]> T1Master2 = brf05_REP2.findallvalues(todate);

					/* EQUITIES */
					List<BRF05_ENTITY3> T1Master3 = new ArrayList<BRF05_ENTITY3>();

					T1Master = hs.createQuery("from BRF05_ENTITY1 a where a.report_date = ?1", BRF05_ENTITY1.class)
							.setParameter(1, df.parse(todate)).getResultList();

					T1Master3 = hs.createQuery("from BRF05_ENTITY3 a where a.report_date = ?1", BRF05_ENTITY3.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-005-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					/* sheet static values update part */

					if (T1Master.size() == 1) {
						for (BRF05_ENTITY1 brf005 : T1Master) {

							updateSheetStaticValues(sheet, brf005);

						}
					}

					/* Equities */

					if (T1Master3.size() == 1) {
						for (BRF05_ENTITY3 brf005C : T1Master3) {

							updateSheetStaticValues(sheet, brf005C);

						}
					}

					/* Iteration Part */
					/* DEPT SECURITIES */
					if (!T1Master2.isEmpty()) {

						int startRow = 24; // Starting row index
						System.out.println("T1Master2 size: " + T1Master2.size());

						for (int index = 0; index < T1Master2.size(); index++) {
							Object[] brf005 = T1Master2.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							// investment_types
							Cell cell3 = row.getCell(3);
							if (cell3 == null) {
								cell3 = row.createCell(3);
							}

							cell3.setCellValue(brf005[0] == null ? "" : brf005[0].toString());

							// security_identifier
							Cell cell4 = row.getCell(4);
							if (cell4 == null) {
								cell4 = row.createCell(4);
							}
							cell4.setCellValue(brf005[1] == null ? "" : brf005[1].toString());

							// nominal
							Cell cell5 = row.getCell(5);
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}

							cell5.setCellValue(brf005[19] == null ? "" : brf005[19].toString());

							// units_held
							Cell cell6 = row.getCell(6);
							if (cell6 == null) {
								cell6 = row.createCell(6);
							}

							cell6.setCellValue(brf005[2] == null ? 0 : ((BigDecimal) brf005[2]).intValue());

							// country
							Cell cell7 = row.getCell(7);
							if (cell7 == null) {
								cell7 = row.createCell(7);
							}
							cell7.setCellValue(brf005[3] == null ? "" : brf005[3].toString());

							// ccy
							Cell cell8 = row.getCell(8);
							if (cell8 == null) {
								cell8 = row.createCell(8);
							}
							cell8.setCellValue(brf005[4] == null ? "" : brf005[4].toString());

							// amount
							Cell cell9 = row.getCell(9);
							if (cell9 == null) {
								cell9 = row.createCell(9);
							}
							cell9.setCellValue(brf005[5] == null ? 0 : ((BigDecimal) brf005[5]).intValue());

							// aed_equivalent
							Cell cell10 = row.getCell(10);
							if (cell10 == null) {
								cell10 = row.createCell(10);
							}
							cell10.setCellValue(brf005[6] == null ? 0 : ((BigDecimal) brf005[6]).intValue());

							// rating
							Cell cell11 = row.getCell(11);
							if (cell11 == null) {
								cell11 = row.createCell(11);
							}
							cell11.setCellValue(brf005[7] == null ? 0 : ((BigDecimal) brf005[7]).intValue());

							// rating_type
							Cell cell12 = row.getCell(12);
							if (cell12 == null) {
								cell12 = row.createCell(12);
							}
							cell12.setCellValue(brf005[8] == null ? "" : brf005[8].toString());

							// market_value
							Cell cell13 = row.getCell(13);
							if (cell13 == null) {
								cell13 = row.createCell(13);
							}
							cell13.setCellValue(brf005[9] == null ? 0 : ((BigDecimal) brf005[9]).intValue());

							// counterparty_type
							Cell cell14 = row.getCell(14);
							if (cell14 == null) {
								cell14 = row.createCell(14);
							}
							cell14.setCellValue(brf005[10] == null ? "" : brf005[10].toString());
						}
					} else {
						System.out.println("No data found for the specified date.");
					}

					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-005-A.xls");
					workbook.write(fileOut);
					fileOut.close();
					System.out.println(fileOut);
					path = fileOut.toString();
					// Close the workbook
					System.out.println("PATH : " + path);
					workbook.close();

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-005-A.xls");

		return outputFile;

	}

	public String detailChanges5(BRF5_Detail_Entity detail, String report_label_1, BigDecimal acct_balance_amt_lc,
			BigDecimal acct_balance_amt_ac, String report_name_1, String report_addl_criteria_1,
			String report_addl_criteria_2, String foracid) {

		String msg = "";

		try {
			Session hs = sessionFactory.getCurrentSession();

			System.out.println(foracid + "| |" + report_addl_criteria_2);
			BRF5_Detail_Entity Brf05detail = BRF5_DetaiRep.findByCustomCriteria(foracid, report_addl_criteria_2);
			System.out.println(foracid + "| |" + report_addl_criteria_2);
			System.out.println(Brf05detail);

			System.out.println(acct_balance_amt_lc + report_label_1 + report_name_1 + report_addl_criteria_1);
			if (Brf05detail != null) {

				Brf05detail.setAcct_balance_amt_lc(acct_balance_amt_lc);
				Brf05detail.setAcct_balance_amt_ac(acct_balance_amt_ac);
				Brf05detail.setReport_label_1(report_label_1);
				Brf05detail.setReport_name_1(report_name_1);
				Brf05detail.setReport_addl_criteria_1(report_addl_criteria_1);
				Brf05detail.setReport_addl_criteria_2(report_addl_criteria_2);
				BRF5_DetaiRep.save(Brf05detail);

				// hs.saveOrUpdate(detail);
				logger.info("Edited Record");
				msg = "Edited Successfully";

			} else {
				msg = "No data Found";
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public ModelAndView getArchieveBRF005View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF5_ENTITY> T1rep = new ArrayList<BRF5_ENTITY>();
		// Query<Object[]> qr;

		List<BRF05_ENTITY1> T1Master = new ArrayList<BRF05_ENTITY1>();
		List<BRF5B_SUMMARY_ENTITY> T1Master1 = new ArrayList<BRF5B_SUMMARY_ENTITY>();
		List<BRF05_ENTITY3> T1Master2 = new ArrayList<BRF05_ENTITY3>();
		List<Object[]> myentity2 = new ArrayList<Object[]>();
		List<Object[]> myentity3 = new ArrayList<Object[]>();

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs
					.createQuery("from BRF05_ENTITY1 a where a.report_date = ?1 order by srl_no", BRF05_ENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.
			 * createQuery("from BRF5B_SUMMARY_ENTITY a where a.report_date = ?1 order by srl_no"
			 * , BRF5B_SUMMARY_ENTITY.class).setParameter(1,
			 * df.parse(todate)).getResultList();
			 * 
			 * T1Master2 = hs.
			 * createQuery("from BRF05_ENTITY3 a where a.report_date = ?1 order by srl_no",
			 * BRF05_ENTITY3.class).setParameter(1, df.parse(todate)).getResultList();
			 */

			/*
			 * T1Master = hs.createQuery("from  BRF05_ENTITY1 a where a.report_date = ?1 ",
			 * BRF05_ENTITY1.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

			myentity2 = brf05_REP2.findallvalues(todate);

			System.out.println(myentity2.toString());
			for (Object[] BRF0052 : myentity2) {
				BRF5B_SUMMARY_ENTITY BRF005_ENTITY2 = new BRF5B_SUMMARY_ENTITY();
				BRF005_ENTITY2.setInvestment_types(((String) BRF0052[0])); // Investment Types
				BRF005_ENTITY2.setSecurity_identifier(((String) BRF0052[1])); // Security Identifier
				BRF005_ENTITY2.setUnits_held(((BigDecimal) BRF0052[2])); // Units Held
				BRF005_ENTITY2.setCountry(((String) BRF0052[3])); // Country
				BRF005_ENTITY2.setCcy(((String) BRF0052[4])); // CCY
				BRF005_ENTITY2.setAmount(((BigDecimal) BRF0052[5])); // Amount
				BRF005_ENTITY2.setAed_equivalent(((BigDecimal) BRF0052[6])); // AED Equivalent
				BRF005_ENTITY2.setRating(((BigDecimal) BRF0052[7])); // Rating
				BRF005_ENTITY2.setRating_type(((String) BRF0052[8])); // Rating Type
				BRF005_ENTITY2.setMarket_value(((BigDecimal) BRF0052[9])); // Market Value
				BRF005_ENTITY2.setCounterparty_type(((String) BRF0052[10])); // Counterparty Type
				BRF005_ENTITY2.setSecurity_identifier_validation(((String) BRF0052[11])); // Security Identifier
																							// Validation
				BRF005_ENTITY2.setCountry_validation(((String) BRF0052[12])); // Country Validation
				BRF005_ENTITY2.setRating_validation(((String) BRF0052[13])); // Rating Validation
				BRF005_ENTITY2.setCounterparty_type_validation(((String) BRF0052[14])); // Counterparty Type Validation
				BRF005_ENTITY2.setRow_valid(((String) BRF0052[15])); // Row Valid
				BRF005_ENTITY2.setRow_label(((String) BRF0052[16])); // Row Label
				BRF005_ENTITY2.setReport_date(((Date) BRF0052[17])); // Report Date
				BRF005_ENTITY2.setReport_addl_criteria_1(((String) BRF0052[18])); // Report Additional Criteria 1
				BRF005_ENTITY2.setNominal(((String) BRF0052[19]));
				T1Master1.add(BRF005_ENTITY2);
			}
			myentity3 = brf05_REP3.findallvalues(todate);
			for (Object[] BRF005_3 : myentity3) {
				BRF05_ENTITY3 BRF005_ENTITY3 = new BRF05_ENTITY3();
				BRF005_ENTITY3.setInvestment_types1(((String) BRF005_3[0])); // Investment Types
				BRF005_ENTITY3.setSecurity_identifier1(((String) BRF005_3[1])); // Security Identifier
				BRF005_ENTITY3.setUnits_held1(((BigDecimal) BRF005_3[2])); // Units Held
				BRF005_ENTITY3.setCountry1(((String) BRF005_3[3])); // Country
				BRF005_ENTITY3.setCcy1(((String) BRF005_3[4])); // CCY
				BRF005_ENTITY3.setAmount1(((BigDecimal) BRF005_3[5])); // Amount
				BRF005_ENTITY3.setAed_equivalent1(((BigDecimal) BRF005_3[6])); // AED Equivalent
				BRF005_ENTITY3.setRating1(((BigDecimal) BRF005_3[7])); // Rating
				BRF005_ENTITY3.setRating_type1(((String) BRF005_3[8])); // Rating Type
				BRF005_ENTITY3.setMarket_value1(((BigDecimal) BRF005_3[9])); // Market Value
				BRF005_ENTITY3.setCounterparty_type1(((String) BRF005_3[10])); // Counterparty Type
				BRF005_ENTITY3.setSecurity_identifier_validation1(((String) BRF005_3[11])); // Security Identifier
																							// Validation
				BRF005_ENTITY3.setCountry_validation1(((String) BRF005_3[12])); // Country Validation
				BRF005_ENTITY3.setRating_validation1(((String) BRF005_3[13])); // Rating Validation
				BRF005_ENTITY3.setCounterparty_type_validation1(((String) BRF005_3[14])); // Counterparty Type
																							// Validation
				BRF005_ENTITY3.setRow_valid1(((String) BRF005_3[15])); // Row Valid
				BRF005_ENTITY3.setRow_label1(((String) BRF005_3[16])); // Row Label
				BRF005_ENTITY3.setReport_date(((Date) BRF005_3[17])); // Report Date
				BRF005_ENTITY3.setReport_addl_criteria_11(((String) BRF005_3[18])); // Report Additional Criteria 1
				BRF005_ENTITY3.setNominal1(((String) BRF005_3[19]));
				T1Master2.add(BRF005_ENTITY3);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF5ARCH");
		mv.addObject("reportsummary2", T1Master1);
		mv.addObject("reportsummary3", T1Master2);
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary1", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		// mv.addObject("reportsummary2", myentity);
		/* mv.addObject("reportsummary1", T1Master1); */

		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;
	}

	/****
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView ARCHgetBRF005currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) throws ParseException {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<Object> T1Dt1 = new ArrayList<Object>();

		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			if (!filter.equals("null")) {
				qr = hs.createNativeQuery(
						"select * from BRF5_ARCHIVTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF5_ARCHIVTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF5_ARCHIVTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF5_ARCHIVENTITY> T1Master = new ArrayList<BRF5_ARCHIVENTITY>();

		try {
			T1Master = hs.createQuery("from BRF5_ARCHIVENTITY a where a.report_date = ?1", BRF5_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String sol_id = (String) a[0];
			String acid = (String) a[1];
			String foracid = (String) a[2];
			String acct_name = (String) a[3];
			Character nre_flg = (Character) a[4];
			Character del_flg = (Character) a[5];
			String create_user = (String) a[6];
			String modify_user = (String) a[7];
			String report_label_1 = (String) a[8];
			String report_name_1 = (String) a[9];
			Date report_date = (Date) a[10];
			String version_control = (String) a[11];
			String cust_id = (String) a[12];
			String verify_user = (String) a[13];
			Character entity_flg = (Character) a[14];
			String remarks = (String) a[15];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[16];
			BigDecimal eab_lc = (BigDecimal) a[17];
			String acct_crncy_code = (String) a[18];
			String gl_code = (String) a[19];
			String gl_sub_head_code = (String) a[20];
			String gl_sub_head_desc = (String) a[21];
			String country_of_incorp = (String) a[22];
			String cust_type = (String) a[23];
			String schm_code = (String) a[24];
			String schm_type = (String) a[25];
			String segment = (String) a[26];
			String sub_segment = (String) a[27];
			BigDecimal sector = (BigDecimal) a[28];
			String sub_sector = (String) a[29];
			String sector_code = (String) a[30];
			String group_id = (String) a[31];
			String constitution_code = (String) a[32];
			String country = (String) a[33];
			String legal_entity_type = (String) a[34];
			String constitution_desc = (String) a[35];
			String purpose_of_advn = (String) a[36];
			BigDecimal hni_networth = (BigDecimal) a[37];
			String turnover = (String) a[38];
			String bacid = (String) a[39];
			String report_addl_criteria_1 = (String) a[40];
			String report_addl_criteria_2 = (String) a[41];
			String report_addl_criteria_3 = (String) a[42];
			Date create_time = (Date) a[43];
			Date modify_time = (Date) a[44];
			Date verify_time = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			Character nre_status = (Character) a[48];
			Character modify_flg = (Character) a[49];
			BigDecimal acct_balance_amt_ac = (BigDecimal) a[50];
			String Remarks1;
			if (acct_balance_amt_ac != null) {
				if (acct_balance_amt_ac.toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}

			BRF5_ARCHIVENTITY py = new BRF5_ARCHIVENTITY(sol_id, acid, foracid, acct_name, nre_flg, del_flg,
					create_user, modify_user, report_label_1, report_name_1, report_date, version_control, cust_id,
					verify_user, entity_flg, remarks, act_balance_amt_lc, eab_lc, acct_crncy_code, gl_code,
					gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, segment,
					sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, country,
					legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_time, modify_time,
					verify_time, maturity_date, gender, nre_status, modify_flg, acct_balance_amt_ac);
			T1Dt1.add(py);

		}
		;
		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("RR" + "/" + "BRF5ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String editbrf5b(String sec_d, String rating, String ratingtype, String todate) {
		// BRF5B_SUMM_REP

		List<BRF5B_SUMMARY_ENTITY> BRF5B_SUMM = BRF5B_SUMM_REP.EditBRF5data(todate, sec_d);

		for (BRF5B_SUMMARY_ENTITY BRF5B_SUMMARY_ENTITY : BRF5B_SUMM) {
			if (BRF5B_SUMMARY_ENTITY.getSecurity_identifier().equals(sec_d)) {
				// BRF5B_SUMMARY_ENTITY BRF5B_SUMMARY_ENTITY = BRF5B_SUMM.get();

				BRF5B_SUMMARY_ENTITY.setRating(new BigDecimal(rating));
				BRF5B_SUMMARY_ENTITY.setRating_type(ratingtype);
				BRF5B_SUMM_REP.save(BRF5B_SUMMARY_ENTITY);

			} else {
				System.out.println("Data might not invalid");
			}
		}
		return todate;

	}

	public String verifyBRF05Report(Date asondate, String userId) {
		StringBuilder msg = new StringBuilder();

		// Verify BRF5B_SUMMARY_ENTITY
		try {
			List<BRF5B_SUMMARY_ENTITY> reports = BRF5B_SUMM_REP.findByAsondate(asondate);
			if (reports != null && !reports.isEmpty()) {
				for (BRF5B_SUMMARY_ENTITY brf05 : reports) {
					brf05.setModify_flg("N");
					brf05.setVerify_time(new Date());
					brf05.setVerify_user(userId);
					BRF5B_SUMM_REP.save(brf05);
				}
			}
			appendVerificationMessage(msg, "BRF5B_SUMMARY_ENTITY", reports);
		} catch (Exception e) {
			msg.append("An error occurred while verifying BRF5B_SUMMARY_ENTITY: ").append(e.getMessage()).append(". ");
		}

		// Verify BRF05_ENTITY1
		try {
			List<BRF05_ENTITY1> anotherReports1 = brf05_REP1.getBRF005reportService(asondate);
			if (anotherReports1 != null && !anotherReports1.isEmpty()) {
				for (BRF05_ENTITY1 another1 : anotherReports1) {
					another1.setModify_flg("N");
					another1.setVerify_time(new Date());
					another1.setVerify_user(userId);
					brf05_REP1.save(another1);
				}
			}
			appendVerificationMessage(msg, "BRF05_ENTITY1", anotherReports1);
		} catch (Exception e) {
			msg.append("An error occurred while verifying BRF05_ENTITY1: ").append(e.getMessage()).append(". ");
		}
		// Verify BRF05_ENTITY3
		try {
			List<BRF05_ENTITY3> anotherReports3 = brf05_REP3.getBRF005reportService(asondate);
			if (anotherReports3 != null && !anotherReports3.isEmpty()) {
				for (BRF05_ENTITY3 another3 : anotherReports3) {
					another3.setModify_flg("N");
					another3.setVerify_time(new Date());
					another3.setVerify_user(userId);
					brf05_REP3.save(another3);
				}
			}
			appendVerificationMessage(msg, "BRF05_ENTITY3", anotherReports3);
		} catch (Exception e) {
			msg.append("An error occurred while verifying BRF05_ENTITY3: ").append(e.getMessage()).append(". ");
		}
		/*
		 * // Adding final alert message String finalAlertMessage =
		 * "Verification process completed. Summary: " + msg.toString(); return
		 * finalAlertMessage;
		 */
		return msg.toString();
	}

	private <T> void appendVerificationMessage(StringBuilder msg, String entityName, List<T> reports) {
		if (reports != null && !reports.isEmpty()) {
			msg.append(entityName).append(" verified successfully. ");
		} else {
			msg.append(entityName).append(" data not found. ");
		}
	}

	public void updateSheetStaticValues(Sheet sheet, BRF05_ENTITY1 brf005) {

		/*
		 * Row r1row0 = sheet.getRow(4); if (r1row0 != null) { Cell r1cell0 =
		 * r1row0.getCell(2); if (r1cell0 == null) { r1cell0 = r1row0.createCell(2); //
		 * Create the cell if it doesn't exist } if (brf005.getReport_date() != null) {
		 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
		 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
		 * sdf.format(brf005.getReport_date()); r1cell0.setCellValue(formattedDate); //
		 * Set the formatted date in the cell } else { r1cell0.setCellValue(""); // Set
		 * an empty value if the report_date is null } }
		 */

		/* EXCEL ROW 13 - ENTITY ROW 3 */
		Row row13 = sheet.getRow(13);

		Cell row13cell3 = row13.getCell(3);

		if (row13cell3 != null) {
			row13cell3.setCellValue(brf005.getR3_investment() == null ? "" : brf005.getR3_investment());
		}

		Cell row13cell4 = row13.getCell(4);

		if (row13cell4 != null) {
			row13cell4.setCellValue(brf005.getR3_security() == null ? "" : brf005.getR3_security());
		}

		Cell row13cell5 = row13.getCell(5);

		if (row13cell5 != null) {
			row13cell5.setCellValue(brf005.getR3_nominal() == null ? 0 : brf005.getR3_nominal().intValue());
		}

		Cell row13cell6 = row13.getCell(6);

		if (row13cell6 != null) {
			row13cell6.setCellValue(brf005.getR3_units() == null ? 0 : brf005.getR3_units().intValue());
		}

		Cell row13cell7 = row13.getCell(7);

		if (row13cell7 != null) {
			row13cell7.setCellValue(brf005.getR3_country() == null ? "" : brf005.getR3_country());
		}

		Cell row13cell8 = row13.getCell(8);

		if (row13cell8 != null) {
			row13cell8.setCellValue(brf005.getR3_ccy() == null ? "" : brf005.getR3_ccy());
		}

		Cell row13cell9 = row13.getCell(9);

		if (row13cell9 != null) {
			row13cell9.setCellValue(
					brf005.getR3_amt_total_security() == null ? 0 : brf005.getR3_amt_total_security().intValue());
		}

		Cell row13cell10 = row13.getCell(10);

		if (row13cell10 != null) {
			row13cell10
					.setCellValue(brf005.getR3_aed_equivalent() == null ? 0 : brf005.getR3_aed_equivalent().intValue());
		}

		Cell row13cell11 = row13.getCell(11);

		if (row13cell11 != null) {
			row13cell11.setCellValue(brf005.getR3_rating() == null ? 0 : brf005.getR3_rating().intValue());
		}

		Cell row13cell12 = row13.getCell(12);

		if (row13cell12 != null) {
			row13cell12.setCellValue(brf005.getR3_ratingtype() == null ? "" : brf005.getR3_ratingtype());
		}

		Cell row13cell13 = row13.getCell(13);

		if (row13cell13 != null) {
			row13cell13.setCellValue(brf005.getR3_market_value() == null ? 0 : brf005.getR3_market_value().intValue());
		}

		Cell row13cell14 = row13.getCell(14);

		if (row13cell14 != null) {
			row13cell14.setCellValue(brf005.getR3_counterpartytype() == null ? "" : brf005.getR3_counterpartytype());
		}

		/* EXCEL ROW 16 - ENTITY ROW 6 */
		Row row16 = sheet.getRow(16);

		Cell row16cell3 = row16.getCell(3);

		if (row16cell3 != null) {
			row16cell3.setCellValue(brf005.getR6_investment() == null ? "" : brf005.getR6_investment());
		}

		Cell row16cell4 = row16.getCell(4);

		if (row16cell4 != null) {
			row16cell4.setCellValue(brf005.getR6_security() == null ? "" : brf005.getR6_security());
		}

		Cell row16cell5 = row16.getCell(5);

		if (row16cell5 != null) {
			row16cell5.setCellValue(brf005.getR6_nominal() == null ? 0 : brf005.getR6_nominal().intValue());
		}

		Cell row16cell6 = row16.getCell(6);

		if (row16cell6 != null) {
			row16cell6.setCellValue(brf005.getR6_units() == null ? 0 : brf005.getR6_units().intValue());
		}

		Cell row16cell7 = row16.getCell(7);

		if (row16cell7 != null) {
			row16cell7.setCellValue(brf005.getR6_country() == null ? "" : brf005.getR6_country());
		}

		Cell row16cell8 = row16.getCell(8);

		if (row16cell8 != null) {
			row16cell8.setCellValue(brf005.getR6_ccy() == null ? "" : brf005.getR6_ccy());
		}

		Cell row16cell9 = row16.getCell(9);

		if (row16cell9 != null) {
			row16cell9.setCellValue(
					brf005.getR6_amt_total_security() == null ? 0 : brf005.getR6_amt_total_security().intValue());
		}

		Cell row16cell10 = row16.getCell(10);

		if (row16cell10 != null) {
			row16cell10
					.setCellValue(brf005.getR6_aed_equivalent() == null ? 0 : brf005.getR6_aed_equivalent().intValue());
		}

		Cell row16cell13 = row16.getCell(13);

		if (row16cell13 != null) {
			row16cell13.setCellValue(brf005.getR6_market_value() == null ? 0 : brf005.getR6_market_value().intValue());
		}

		Cell row16cell14 = row16.getCell(14);

		if (row16cell14 != null) {
			row16cell14.setCellValue(brf005.getR6_counterpartytype() == null ? "" : brf005.getR6_counterpartytype());
		}

		/* EXCEL ROW 19 - ENTITY ROW 9 */
		Row row19 = sheet.getRow(19);

		Cell row19cell3 = row19.getCell(3);

		if (row19cell3 != null) {
			row19cell3.setCellValue(brf005.getR9_investment() == null ? "" : brf005.getR9_investment());
		}

		Cell row19cell4 = row19.getCell(4);

		if (row19cell4 != null) {
			row19cell4.setCellValue(brf005.getR9_security() == null ? "" : brf005.getR9_security());
		}

		Cell row19cell5 = row19.getCell(5);

		if (row19cell5 != null) {
			row19cell5.setCellValue(brf005.getR9_nominal() == null ? 0 : brf005.getR9_nominal().intValue());
		}

		Cell row19cell6 = row19.getCell(6);

		if (row19cell6 != null) {
			row19cell6.setCellValue(brf005.getR9_units() == null ? 0 : brf005.getR9_units().intValue());
		}

		Cell row19cell7 = row19.getCell(7);

		if (row19cell7 != null) {
			row19cell7.setCellValue(brf005.getR9_country() == null ? "" : brf005.getR9_country());
		}

		Cell row19cell8 = row19.getCell(8);

		if (row19cell8 != null) {
			row19cell8.setCellValue(brf005.getR9_ccy() == null ? "" : brf005.getR9_ccy());
		}

		Cell row19cell9 = row19.getCell(9);

		if (row19cell9 != null) {
			row19cell9.setCellValue(
					brf005.getR9_amt_total_security() == null ? 0 : brf005.getR9_amt_total_security().intValue());
		}

		Cell row19cell10 = row19.getCell(10);

		if (row19cell10 != null) {
			row19cell10
					.setCellValue(brf005.getR9_aed_equivalent() == null ? 0 : brf005.getR9_aed_equivalent().intValue());
		}

		Cell row19cell13 = row19.getCell(13);

		if (row19cell13 != null) {
			row19cell13.setCellValue(brf005.getR9_market_value() == null ? 0 : brf005.getR9_market_value().intValue());
		}

		Cell row19cell14 = row19.getCell(14);

		if (row19cell14 != null) {
			row19cell14.setCellValue(brf005.getR9_counterpartytype() == null ? "" : brf005.getR9_counterpartytype());
		}

		/* EXCEL ROW 44 - ENTITY ROW 39 */
		Row row44 = sheet.getRow(44);

		Cell row44cell3 = row44.getCell(3);

		if (row44cell3 != null) {
			row44cell3.setCellValue(brf005.getR39_investment() == null ? "" : brf005.getR39_investment());
		}

		Cell row44cell4 = row44.getCell(4);

		if (row44cell4 != null) {
			row44cell4.setCellValue(brf005.getR39_security() == null ? "" : brf005.getR39_security());
		}

		Cell row44cell5 = row44.getCell(5);

		if (row44cell5 != null) {
			row44cell5.setCellValue(brf005.getR39_nominal() == null ? 0 : brf005.getR39_nominal().intValue());
		}

		Cell row44cell6 = row44.getCell(6);

		if (row44cell6 != null) {
			row44cell6.setCellValue(brf005.getR39_units() == null ? 0 : brf005.getR39_units().intValue());
		}

		Cell row44cell7 = row44.getCell(7);

		if (row44cell7 != null) {
			row44cell7.setCellValue(brf005.getR39_country() == null ? "" : brf005.getR39_country());
		}

		Cell row44cell8 = row44.getCell(8);

		if (row44cell8 != null) {
			row44cell8.setCellValue(brf005.getR39_ccy() == null ? "" : brf005.getR39_ccy());
		}

		Cell row44cell9 = row44.getCell(9);

		if (row44cell9 != null) {
			row44cell9.setCellValue(
					brf005.getR39_amt_total_security() == null ? 0 : brf005.getR39_amt_total_security().intValue());
		}

		Cell row44cell10 = row44.getCell(10);

		if (row44cell10 != null) {
			row44cell10.setCellValue(
					brf005.getR39_aed_equivalent() == null ? 0 : brf005.getR39_aed_equivalent().intValue());
		}

		Cell row44cell11 = row44.getCell(11);

		if (row44cell11 != null) {
			row44cell11.setCellValue(brf005.getR39_rating() == null ? 0 : brf005.getR39_rating().intValue());
		}

		Cell row44cell12 = row44.getCell(12);

		if (row44cell12 != null) {
			row44cell12.setCellValue(brf005.getR39_ratingtype() == null ? "" : brf005.getR39_ratingtype());
		}

		Cell row44cell13 = row44.getCell(13);

		if (row44cell13 != null) {
			row44cell13
					.setCellValue(brf005.getR39_market_value() == null ? 0 : brf005.getR39_market_value().intValue());
		}

		Cell row44cell14 = row44.getCell(14);

		if (row44cell14 != null) {
			row44cell14.setCellValue(brf005.getR39_counterpartytype() == null ? "" : brf005.getR39_counterpartytype());
		}

		/* EXCEL ROW 48 - ENTITY ROW 43 */
		Row row48 = sheet.getRow(48);

		Cell row48cell3 = row48.getCell(3);

		if (row48cell3 != null) {
			row48cell3.setCellValue(brf005.getR43_investment() == null ? "" : brf005.getR43_investment());
		}

		Cell row48cell4 = row48.getCell(4);

		if (row48cell4 != null) {
			row48cell4.setCellValue(brf005.getR43_security() == null ? "" : brf005.getR43_security());
		}

		Cell row48cell5 = row48.getCell(5);

		if (row48cell5 != null) {
			row48cell5.setCellValue(brf005.getR43_nominal() == null ? 0 : brf005.getR43_nominal().intValue());
		}

		Cell row48cell6 = row48.getCell(6);

		if (row48cell6 != null) {
			row48cell6.setCellValue(brf005.getR43_units() == null ? 0 : brf005.getR43_units().intValue());
		}

		Cell row48cell7 = row48.getCell(7);

		if (row48cell7 != null) {
			row48cell7.setCellValue(brf005.getR43_country() == null ? "" : brf005.getR43_country());
		}

		Cell row48cell8 = row48.getCell(8);

		if (row48cell8 != null) {
			row48cell8.setCellValue(brf005.getR43_ccy() == null ? "" : brf005.getR43_ccy());
		}

		Cell row48cell9 = row48.getCell(9);

		if (row48cell9 != null) {
			row48cell9.setCellValue(
					brf005.getR43_amt_total_security() == null ? 0 : brf005.getR43_amt_total_security().intValue());
		}

		Cell row48cell10 = row48.getCell(10);

		if (row48cell10 != null) {
			row48cell10.setCellValue(
					brf005.getR43_aed_equivalent() == null ? 0 : brf005.getR43_aed_equivalent().intValue());
		}

		Cell row48cell13 = row48.getCell(13);

		if (row48cell13 != null) {
			row48cell13
					.setCellValue(brf005.getR43_market_value() == null ? 0 : brf005.getR43_market_value().intValue());
		}

		Cell row48cell14 = row48.getCell(14);

		if (row48cell14 != null) {
			row48cell14.setCellValue(brf005.getR43_counterpartytype() == null ? "" : brf005.getR43_counterpartytype());
		}

		/* EXCEL ROW 51 - ENTITY ROW 46 */
		Row row51 = sheet.getRow(51);

		Cell row51cell3 = row51.getCell(3);

		if (row51cell3 != null) {
			row51cell3.setCellValue(brf005.getR46_investment() == null ? "" : brf005.getR46_investment());
		}

		Cell row51cell4 = row51.getCell(4);

		if (row51cell4 != null) {
			row51cell4.setCellValue(brf005.getR46_security() == null ? "" : brf005.getR46_security());
		}

		Cell row51cell5 = row51.getCell(5);

		if (row51cell5 != null) {
			row51cell5.setCellValue(brf005.getR46_nominal() == null ? 0 : brf005.getR46_nominal().intValue());
		}

		Cell row51cell6 = row51.getCell(6);

		if (row51cell6 != null) {
			row51cell6.setCellValue(brf005.getR46_units() == null ? 0 : brf005.getR46_units().intValue());
		}

		Cell row51cell7 = row51.getCell(7);

		if (row51cell7 != null) {
			row51cell7.setCellValue(brf005.getR46_country() == null ? "" : brf005.getR46_country());
		}

		Cell row51cell8 = row51.getCell(8);

		if (row51cell8 != null) {
			row51cell8.setCellValue(brf005.getR46_ccy() == null ? "" : brf005.getR46_ccy());
		}

		Cell row51cell9 = row51.getCell(9);

		if (row51cell9 != null) {
			row51cell9.setCellValue(
					brf005.getR46_amt_total_security() == null ? 0 : brf005.getR46_amt_total_security().intValue());
		}

		Cell row51cell10 = row51.getCell(10);

		if (row51cell10 != null) {
			row51cell10.setCellValue(
					brf005.getR46_aed_equivalent() == null ? 0 : brf005.getR46_aed_equivalent().intValue());
		}

		Cell row51cell13 = row51.getCell(13);

		if (row51cell13 != null) {
			row51cell13
					.setCellValue(brf005.getR46_market_value() == null ? 0 : brf005.getR46_market_value().intValue());
		}

		Cell row51cell14 = row51.getCell(14);

		if (row51cell14 != null) {
			row51cell14.setCellValue(brf005.getR46_counterpartytype() == null ? "" : brf005.getR46_counterpartytype());
		}

	}

	public void updateSheetStaticValues(Sheet sheet, BRF05_ENTITY3 brf005C) {

		/* EXCEL ROW 41 */
		Row row41 = sheet.getRow(41);

		Cell row41cell3 = row41.getCell(3);

		if (row41cell3 != null) {
			row41cell3.setCellValue(brf005C.getInvestment_types1() == null ? "" : brf005C.getInvestment_types1());
		}

		Cell row41cell4 = row41.getCell(4);

		if (row41cell4 != null) {
			row41cell4.setCellValue(brf005C.getSecurity_identifier1() == null ? "" : brf005C.getSecurity_identifier1());
		}

		Cell row41cell5 = row41.getCell(5);

		if (row41cell5 != null) {
			row41cell5.setCellValue(brf005C.getNominal1() == null ? "" : brf005C.getNominal1());
		}

		Cell row41cell6 = row41.getCell(6);

		if (row41cell6 != null) {
			row41cell6.setCellValue(brf005C.getUnits_held1() == null ? 0 : brf005C.getUnits_held1().intValue());
		}

		Cell row41cell7 = row41.getCell(7);

		if (row41cell7 != null) {
			row41cell7.setCellValue(brf005C.getCountry1() == null ? "" : brf005C.getCountry1());
		}

		Cell row41cell8 = row41.getCell(8);

		if (row41cell8 != null) {
			row41cell8.setCellValue(brf005C.getCcy1() == null ? "" : brf005C.getCcy1());
		}

		Cell row41cell9 = row41.getCell(9);

		if (row41cell9 != null) {
			row41cell9.setCellValue(brf005C.getAmount1() == null ? 0 : brf005C.getAmount1().intValue());
		}

		Cell row41cell10 = row41.getCell(10);

		if (row41cell10 != null) {
			row41cell10
					.setCellValue(brf005C.getAed_equivalent1() == null ? 0 : brf005C.getAed_equivalent1().intValue());
		}

		Cell row41cell13 = row41.getCell(13);

		if (row41cell13 != null) {
			row41cell13.setCellValue(brf005C.getMarket_value1() == null ? 0 : brf005C.getMarket_value1().intValue());
		}

		Cell row41cell14 = row41.getCell(14);

		if (row41cell14 != null) {
			row41cell14.setCellValue(brf005C.getCounterparty_type1() == null ? "" : brf005C.getCounterparty_type1());
		}

	}
}
