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
import java.util.Optional;

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

import com.bornfire.xbrl.entities.BRF9_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF12_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF12_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF12_DETAIL_REPO;
import com.bornfire.xbrl.entities.BRBS.BRF12_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF46_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF9_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;

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
public class BRF012ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF012ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */
	@Autowired
	BRF12_DETAIL_REPO brf12_DETAIL_REPO;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheck(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF12_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF12_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF012View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF12_ENTITY> T1rep = new ArrayList<BRF12_ENTITY>();
		// Query<Object[]> qr;

		List<BRF12_ENTITY> T1Master = new ArrayList<BRF12_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF12_ENTITY a where a.report_date = ?1 ", BRF12_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF12");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF012currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF12_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF12_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF12_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF12_DETAIL_ENTITY> T1Master = new ArrayList<BRF12_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF12_DETAIL_ENTITY a where a.report_date = ?1", BRF12_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
			String acct_name = (String) a[4];
			String acct_crncy_code = (String) a[5];
			String gl_code = (String) a[6];
			String gl_sub_head_code = (String) a[7];
			String gl_sub_head_desc = (String) a[8];
			String country_of_incorp = (String) a[9];
			String cust_type = (String) a[10];
			String schm_code = (String) a[11];
			String schm_type = (String) a[12];
			String sol_id = (String) a[13];
			String acid = (String) a[14];
			String segment = (String) a[15];
			String sub_segment = (String) a[16];
			BigDecimal sector = (BigDecimal) a[17];
			String sub_sector = (String) a[18];
			String sector_code = (String) a[19];
			String group_id = (String) a[20];
			String constitution_code = (String) a[21];
			String country = (String) a[22];
			String legal_entity_type = (String) a[23];
			String constitution_desc = (String) a[24];
			String purpose_of_advn = (String) a[25];
			BigDecimal hni_networth = (BigDecimal) a[26];
			String turnover = (String) a[27];
			String bacid = (String) a[28];
			String report_name_1 = (String) a[29];
			String report_label_1 = (String) a[30];
			String report_addl_criteria_1 = (String) a[31];
			String report_addl_criteria_2 = (String) a[32];
			String report_addl_criteria_3 = (String) a[33];
			String create_user = (String) a[34];
			Date create_time = (Date) a[35];
			String modify_user = (String) a[36];
			Date modify_time = (Date) a[37];
			String verify_user = (String) a[38];
			Date verify_time = (Date) a[39];
			Character entity_flg = (Character) a[40];
			Character modify_flg = (Character) a[41];
			Character del_flg = (Character) a[42];
			Character nre_status = (Character) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nre_flag = (Character) a[49];

			String Remarks1;

			if (act_balance_amt_lc != null) {
				if (act_balance_amt_lc.toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}

			BRF12_DETAIL_ENTITY py = new BRF12_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flag);
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

		mv.setViewName("RR" + "/" + "BRF12::reportcontent");
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
		fileName = "011-BRF-012-A";
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

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF12_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF12_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF12.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF12.jrxml");
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

				List<BRF12_ENTITY> T1Master = new ArrayList<BRF12_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF12_ENTITY a where a.report_date = ?1 ", BRF12_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF12_ENTITY BRF12 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-012-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);

							/*
							 * // report_date
							 * 
							 * Row r1row0 = sheet.getRow(4); if (r1row0 != null) { Cell r1cell0 =
							 * r1row0.getCell(2); if (r1cell0 == null) { r1cell0 = r1row0.createCell(2); //
							 * Create the cell if it doesn't exist } if (BRF12.getReport_date() != null) {
							 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
							 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
							 * sdf.format(BRF12.getReport_date()); r1cell0.setCellValue(formattedDate); //
							 * Set the formatted date in the cell } else { r1cell0.setCellValue(""); // Set
							 * an empty value if the report_date is null } }
							 */
							Row row = sheet.getRow(12);
							Cell cell = row.getCell(4);
							if (cell != null) {
								cell.setCellValue(BRF12.getR2_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR2_up_3_mon_aed_resident().intValue());
							}

							Cell cell1 = row.getCell(5);
							if (cell1 != null) {
								cell1.setCellValue(BRF12.getR2_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR2_above_3_up_6_aed_resident().intValue());
							}

							Cell cell2 = row.getCell(6);
							if (cell2 != null) {
								cell2.setCellValue(BRF12.getR2_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR2_above_6_up_12_aed_resident().intValue());
							}

							Cell cell3 = row.getCell(7);
							if (cell3 != null) {
								cell3.setCellValue(BRF12.getR2_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR2_exc_12_mon_aed_resident().intValue());
							}

							Cell cell4 = row.getCell(8);
							if (cell4 != null) {
								cell4.setCellValue(BRF12.getR2_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR2_up_3_mon_fcy_resident().intValue());
							}

							Cell cell5 = row.getCell(9);
							if (cell5 != null) {
								cell5.setCellValue(BRF12.getR2_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR2_above_3_up_6_fcy_resident().intValue());
							}

							Cell cell6 = row.getCell(10);
							if (cell6 != null) {
								cell6.setCellValue(BRF12.getR2_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR2_above_6_up_12_fcy_resident().intValue());
							}

							Cell cell7 = row.getCell(11);
							if (cell7 != null) {
								cell7.setCellValue(BRF12.getR2_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR2_exc_12_mon_fcy_resident().intValue());
							}

							Cell cell8 = row.getCell(13);
							if (cell8 != null) {
								cell8.setCellValue(BRF12.getR2_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR2_up_3_mon_aed_non_resident().intValue());
							}

							Cell cell9 = row.getCell(14);
							if (cell9 != null) {
								cell9.setCellValue(BRF12.getR2_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR2_above_3_up_6_aed_non_resident().intValue());
							}

							Cell cell10 = row.getCell(15);
							if (cell10 != null) {
								cell10.setCellValue(BRF12.getR2_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR2_above_6_up_12_aed_non_resident().intValue());
							}

							Cell cell11 = row.getCell(16);
							if (cell11 != null) {
								cell11.setCellValue(BRF12.getR2_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR2_exc_12_mon_aed_non_resident().intValue());
							}

							Cell cell12 = row.getCell(17);
							if (cell12 != null) {
								cell12.setCellValue(BRF12.getR2_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR2_up_3_mon_fcy_non_resident().intValue());
							}

							Cell cell13 = row.getCell(18);
							if (cell13 != null) {
								cell13.setCellValue(BRF12.getR2_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR2_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell cell14 = row.getCell(19);
							if (cell14 != null) {
								cell14.setCellValue(BRF12.getR2_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR2_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell cell15 = row.getCell(20);
							if (cell15 != null) {
								cell15.setCellValue(BRF12.getR2_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR2_exc_12_mon_fcy_non_resident().intValue());
							}

							/////////////////////////////////////// R3//////////////////////////////////

							Row row1 = sheet.getRow(13);
							Cell R1cell = row1.getCell(4);
							if (R1cell != null) {
								R1cell.setCellValue(BRF12.getR3_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR3_up_3_mon_aed_resident().intValue());
							}

							Cell R1cell1 = row1.getCell(5);
							if (R1cell1 != null) {
								R1cell1.setCellValue(BRF12.getR3_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR3_above_3_up_6_aed_resident().intValue());
							}

							Cell R1cell2 = row1.getCell(6);
							if (R1cell2 != null) {
								R1cell2.setCellValue(BRF12.getR3_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR3_above_6_up_12_aed_resident().intValue());
							}

							Cell R1cell3 = row1.getCell(7);
							if (R1cell3 != null) {
								R1cell3.setCellValue(BRF12.getR3_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR3_exc_12_mon_aed_resident().intValue());
							}

							Cell R1cell4 = row1.getCell(8);
							if (R1cell4 != null) {
								R1cell4.setCellValue(BRF12.getR3_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR3_up_3_mon_fcy_resident().intValue());
							}

							Cell R1cell5 = row1.getCell(9);
							if (R1cell5 != null) {
								R1cell5.setCellValue(BRF12.getR3_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR3_above_3_up_6_fcy_resident().intValue());
							}

							Cell R1cell6 = row1.getCell(10);
							if (R1cell6 != null) {
								R1cell6.setCellValue(BRF12.getR3_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR3_above_6_up_12_fcy_resident().intValue());
							}

							Cell R1cell7 = row1.getCell(11);
							if (R1cell7 != null) {
								R1cell7.setCellValue(BRF12.getR3_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR3_exc_12_mon_fcy_resident().intValue());
							}

							Cell R1cell8 = row1.getCell(13);
							if (R1cell8 != null) {
								R1cell8.setCellValue(BRF12.getR3_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR3_up_3_mon_aed_non_resident().intValue());
							}

							Cell R1cell9 = row1.getCell(14);
							if (R1cell9 != null) {
								R1cell9.setCellValue(BRF12.getR3_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR3_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R1cell10 = row1.getCell(15);
							if (R1cell10 != null) {
								R1cell10.setCellValue(BRF12.getR3_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR3_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R1cell11 = row1.getCell(16);
							if (R1cell11 != null) {
								R1cell11.setCellValue(BRF12.getR3_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR3_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R1cell12 = row1.getCell(17);
							if (R1cell12 != null) {
								R1cell12.setCellValue(BRF12.getR3_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR3_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R1cell13 = row1.getCell(18);
							if (R1cell13 != null) {
								R1cell13.setCellValue(BRF12.getR3_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR3_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R1cell14 = row1.getCell(19);
							if (R1cell14 != null) {
								R1cell14.setCellValue(BRF12.getR3_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR3_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R1cell15 = row1.getCell(20);
							if (R1cell15 != null) {
								R1cell15.setCellValue(BRF12.getR3_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR3_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R5//////////////////////////////

							Row row3 = sheet.getRow(15);
							Cell R3cell = row3.getCell(4);
							if (R3cell != null) {
								R3cell.setCellValue(BRF12.getR5_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR5_up_3_mon_aed_resident().intValue());
							}

							Cell R3cell1 = row3.getCell(5);
							if (R3cell1 != null) {
								R3cell1.setCellValue(BRF12.getR5_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR5_above_3_up_6_aed_resident().intValue());
							}

							Cell R3cell2 = row3.getCell(6);
							if (R3cell2 != null) {
								R3cell2.setCellValue(BRF12.getR5_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR5_above_6_up_12_aed_resident().intValue());
							}

							Cell R3cell3 = row3.getCell(7);
							if (R3cell3 != null) {
								R3cell3.setCellValue(BRF12.getR5_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR5_exc_12_mon_aed_resident().intValue());
							}

							Cell R3cell4 = row3.getCell(8);
							if (R3cell4 != null) {
								R3cell4.setCellValue(BRF12.getR5_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR5_up_3_mon_fcy_resident().intValue());
							}

							Cell R3cell5 = row3.getCell(9);
							if (R3cell5 != null) {
								R3cell5.setCellValue(BRF12.getR5_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR5_above_3_up_6_fcy_resident().intValue());
							}

							Cell R3cell6 = row3.getCell(10);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF12.getR5_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR5_above_6_up_12_fcy_resident().intValue());
							}

							Cell R3cell7 = row3.getCell(11);
							if (R3cell7 != null) {
								R3cell7.setCellValue(BRF12.getR5_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR5_exc_12_mon_fcy_resident().intValue());
							}

							Cell R3cell8 = row3.getCell(13);
							if (R3cell8 != null) {
								R3cell8.setCellValue(BRF12.getR5_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR5_up_3_mon_aed_non_resident().intValue());
							}

							Cell R3cell9 = row3.getCell(14);
							if (R3cell9 != null) {
								R3cell9.setCellValue(BRF12.getR5_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR5_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R3cell10 = row3.getCell(15);
							if (R3cell10 != null) {
								R3cell10.setCellValue(BRF12.getR5_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR5_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R3cell11 = row3.getCell(16);
							if (R3cell11 != null) {
								R3cell11.setCellValue(BRF12.getR5_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR5_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R3cell12 = row3.getCell(17);
							if (R3cell12 != null) {
								R3cell12.setCellValue(BRF12.getR5_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR5_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R3cell13 = row3.getCell(18);
							if (R3cell13 != null) {
								R3cell13.setCellValue(BRF12.getR5_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR5_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R3cell14 = row3.getCell(19);
							if (R3cell14 != null) {
								R3cell14.setCellValue(BRF12.getR5_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR5_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R3cell15 = row3.getCell(20);
							if (R3cell15 != null) {
								R3cell15.setCellValue(BRF12.getR5_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR5_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R6//////////////////////////////

							Row row4 = sheet.getRow(16);
							Cell R4cell = row4.getCell(4);
							if (R4cell != null) {
								R4cell.setCellValue(BRF12.getR6_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR6_up_3_mon_aed_resident().intValue());
							}

							Cell R4cell1 = row4.getCell(5);
							if (R4cell1 != null) {
								R4cell1.setCellValue(BRF12.getR6_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR6_above_3_up_6_aed_resident().intValue());
							}

							Cell R4cell2 = row4.getCell(6);
							if (R4cell2 != null) {
								R4cell2.setCellValue(BRF12.getR6_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR6_above_6_up_12_aed_resident().intValue());
							}

							Cell R4cell3 = row4.getCell(7);
							if (R4cell3 != null) {
								R4cell3.setCellValue(BRF12.getR6_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR6_exc_12_mon_aed_resident().intValue());
							}

							Cell R4cell4 = row4.getCell(8);
							if (R4cell4 != null) {
								R4cell4.setCellValue(BRF12.getR6_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR6_up_3_mon_fcy_resident().intValue());
							}

							Cell R4cell5 = row4.getCell(9);
							if (R4cell5 != null) {
								R4cell5.setCellValue(BRF12.getR6_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR6_above_3_up_6_fcy_resident().intValue());
							}

							Cell R4cell6 = row4.getCell(10);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF12.getR6_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR6_above_6_up_12_fcy_resident().intValue());
							}

							Cell R4cell7 = row4.getCell(11);
							if (R4cell7 != null) {
								R4cell7.setCellValue(BRF12.getR6_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR6_exc_12_mon_fcy_resident().intValue());
							}

							Cell R4cell8 = row4.getCell(13);
							if (R4cell8 != null) {
								R4cell8.setCellValue(BRF12.getR6_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR6_up_3_mon_aed_non_resident().intValue());
							}

							Cell R4cell9 = row4.getCell(14);
							if (R4cell9 != null) {
								R4cell9.setCellValue(BRF12.getR6_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR6_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R4cell10 = row4.getCell(15);
							if (R4cell10 != null) {
								R4cell10.setCellValue(BRF12.getR6_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR6_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R4cell11 = row4.getCell(16);
							if (R4cell11 != null) {
								R4cell11.setCellValue(BRF12.getR6_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR6_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R4cell12 = row4.getCell(17);
							if (R4cell12 != null) {
								R4cell12.setCellValue(BRF12.getR6_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR6_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R4cell13 = row4.getCell(18);
							if (R4cell13 != null) {
								R4cell13.setCellValue(BRF12.getR6_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR6_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R4cell14 = row4.getCell(19);
							if (R4cell14 != null) {
								R4cell14.setCellValue(BRF12.getR6_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR6_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R4cell15 = row4.getCell(20);
							if (R4cell15 != null) {
								R4cell15.setCellValue(BRF12.getR6_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR6_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R8//////////////////////////////

							Row row5 = sheet.getRow(18);
							Cell R5cell = row5.getCell(4);
							if (R5cell != null) {
								R5cell.setCellValue(BRF12.getR8_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR8_up_3_mon_aed_resident().intValue());
							}

							Cell R5cell1 = row5.getCell(5);
							if (R5cell1 != null) {
								R5cell1.setCellValue(BRF12.getR8_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR8_above_3_up_6_aed_resident().intValue());
							}

							Cell R5cell2 = row5.getCell(6);
							if (R5cell2 != null) {
								R5cell2.setCellValue(BRF12.getR8_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR8_above_6_up_12_aed_resident().intValue());
							}

							Cell R5cell3 = row5.getCell(7);
							if (R5cell3 != null) {
								R5cell3.setCellValue(BRF12.getR8_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR8_exc_12_mon_aed_resident().intValue());
							}

							Cell R5cell4 = row5.getCell(8);
							if (R5cell4 != null) {
								R5cell4.setCellValue(BRF12.getR8_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR8_up_3_mon_fcy_resident().intValue());
							}

							Cell R5cell5 = row5.getCell(9);
							if (R5cell5 != null) {
								R5cell5.setCellValue(BRF12.getR8_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR8_above_3_up_6_fcy_resident().intValue());
							}

							Cell R5cell6 = row5.getCell(10);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF12.getR8_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR8_above_6_up_12_fcy_resident().intValue());
							}

							Cell R5cell7 = row5.getCell(11);
							if (R5cell7 != null) {
								R5cell7.setCellValue(BRF12.getR8_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR8_exc_12_mon_fcy_resident().intValue());
							}

							Cell R5cell8 = row5.getCell(13);
							if (R5cell8 != null) {
								R5cell8.setCellValue(BRF12.getR8_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR8_up_3_mon_aed_non_resident().intValue());
							}

							Cell R5cell9 = row5.getCell(14);
							if (R5cell9 != null) {
								R5cell9.setCellValue(BRF12.getR8_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR8_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R5cell10 = row5.getCell(15);
							if (R5cell10 != null) {
								R5cell10.setCellValue(BRF12.getR8_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR8_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R5cell11 = row5.getCell(16);
							if (R5cell11 != null) {
								R5cell11.setCellValue(BRF12.getR8_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR8_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R5cell12 = row5.getCell(17);
							if (R5cell12 != null) {
								R5cell12.setCellValue(BRF12.getR8_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR8_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R5cell13 = row5.getCell(18);
							if (R5cell13 != null) {
								R5cell13.setCellValue(BRF12.getR8_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR8_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R5cell14 = row5.getCell(19);
							if (R5cell14 != null) {
								R5cell14.setCellValue(BRF12.getR8_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR8_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R5cell15 = row5.getCell(20);
							if (R5cell15 != null) {
								R5cell15.setCellValue(BRF12.getR8_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR8_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R9//////////////////////////////

							Row row6 = sheet.getRow(19);
							Cell R6cell = row6.getCell(4);
							if (R6cell != null) {
								R6cell.setCellValue(BRF12.getR9_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR9_up_3_mon_aed_resident().intValue());
							}

							Cell R6cell1 = row6.getCell(5);
							if (R6cell1 != null) {
								R6cell1.setCellValue(BRF12.getR9_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR9_above_3_up_6_aed_resident().intValue());
							}

							Cell R6cell2 = row6.getCell(6);
							if (R6cell2 != null) {
								R6cell2.setCellValue(BRF12.getR9_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR9_above_6_up_12_aed_resident().intValue());
							}

							Cell R6cell3 = row6.getCell(7);
							if (R6cell3 != null) {
								R6cell3.setCellValue(BRF12.getR9_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR9_exc_12_mon_aed_resident().intValue());
							}

							Cell R6cell4 = row6.getCell(8);
							if (R6cell4 != null) {
								R6cell4.setCellValue(BRF12.getR9_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR9_up_3_mon_fcy_resident().intValue());
							}

							Cell R6cell5 = row6.getCell(9);
							if (R6cell5 != null) {
								R6cell5.setCellValue(BRF12.getR9_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR9_above_3_up_6_fcy_resident().intValue());
							}

							Cell R6cell6 = row6.getCell(10);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF12.getR9_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR9_above_6_up_12_fcy_resident().intValue());
							}

							Cell R6cell7 = row6.getCell(11);
							if (R6cell7 != null) {
								R6cell7.setCellValue(BRF12.getR9_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR9_exc_12_mon_fcy_resident().intValue());
							}

							Cell R6cell8 = row6.getCell(13);
							if (R6cell8 != null) {
								R6cell8.setCellValue(BRF12.getR9_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR9_up_3_mon_aed_non_resident().intValue());
							}

							Cell R6cell9 = row6.getCell(14);
							if (R6cell9 != null) {
								R6cell9.setCellValue(BRF12.getR9_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR9_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R6cell10 = row6.getCell(15);
							if (R6cell10 != null) {
								R6cell10.setCellValue(BRF12.getR9_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR9_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R6cell11 = row6.getCell(16);
							if (R6cell11 != null) {
								R6cell11.setCellValue(BRF12.getR9_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR9_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R6cell12 = row6.getCell(17);
							if (R6cell12 != null) {
								R6cell12.setCellValue(BRF12.getR9_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR9_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R6cell13 = row6.getCell(18);
							if (R6cell13 != null) {
								R6cell13.setCellValue(BRF12.getR9_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR9_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R6cell14 = row6.getCell(19);
							if (R6cell14 != null) {
								R6cell14.setCellValue(BRF12.getR9_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR9_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R6cell15 = row6.getCell(20);
							if (R6cell15 != null) {
								R6cell15.setCellValue(BRF12.getR9_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR9_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R11//////////////////////////////

							Row row7 = sheet.getRow(21);
							Cell R7cell = row7.getCell(4);
							if (R7cell != null) {
								R7cell.setCellValue(BRF12.getR11_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR11_up_3_mon_aed_resident().intValue());
							}

							Cell R7cell1 = row7.getCell(5);
							if (R7cell1 != null) {
								R7cell1.setCellValue(BRF12.getR11_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR11_above_3_up_6_aed_resident().intValue());
							}

							Cell R7cell2 = row7.getCell(6);
							if (R7cell2 != null) {
								R7cell2.setCellValue(BRF12.getR11_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR11_above_6_up_12_aed_resident().intValue());
							}

							Cell R7cell3 = row7.getCell(7);
							if (R7cell3 != null) {
								R7cell3.setCellValue(BRF12.getR11_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR11_exc_12_mon_aed_resident().intValue());
							}

							Cell R7cell4 = row7.getCell(8);
							if (R7cell4 != null) {
								R7cell4.setCellValue(BRF12.getR11_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR11_up_3_mon_fcy_resident().intValue());
							}

							Cell R7cell5 = row7.getCell(9);
							if (R7cell5 != null) {
								R7cell5.setCellValue(BRF12.getR11_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR11_above_3_up_6_fcy_resident().intValue());
							}

							Cell R7cell6 = row7.getCell(10);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF12.getR11_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR11_above_6_up_12_fcy_resident().intValue());
							}

							Cell R7cell7 = row7.getCell(11);
							if (R7cell7 != null) {
								R7cell7.setCellValue(BRF12.getR11_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR11_exc_12_mon_fcy_resident().intValue());
							}

							Cell R7cell8 = row7.getCell(13);
							if (R7cell8 != null) {
								R7cell8.setCellValue(BRF12.getR11_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR11_up_3_mon_aed_non_resident().intValue());
							}

							Cell R7cell9 = row7.getCell(14);
							if (R7cell9 != null) {
								R7cell9.setCellValue(BRF12.getR11_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR11_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R7cell10 = row7.getCell(15);
							if (R7cell10 != null) {
								R7cell10.setCellValue(BRF12.getR11_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR11_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R7cell11 = row7.getCell(16);
							if (R7cell11 != null) {
								R7cell11.setCellValue(BRF12.getR11_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR11_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R7cell12 = row7.getCell(17);
							if (R7cell12 != null) {
								R7cell12.setCellValue(BRF12.getR11_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR11_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R7cell13 = row7.getCell(18);
							if (R7cell13 != null) {
								R7cell13.setCellValue(BRF12.getR11_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR11_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R7cell14 = row7.getCell(19);
							if (R7cell14 != null) {
								R7cell14.setCellValue(BRF12.getR11_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR11_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R7cell15 = row7.getCell(20);
							if (R7cell15 != null) {
								R7cell15.setCellValue(BRF12.getR11_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR11_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R12//////////////////////////////

							Row row8 = sheet.getRow(22);
							Cell R8cell = row8.getCell(4);
							if (R8cell != null) {
								R8cell.setCellValue(BRF12.getR12_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR12_up_3_mon_aed_resident().intValue());
							}

							Cell R8cell1 = row8.getCell(5);
							if (R8cell1 != null) {
								R8cell1.setCellValue(BRF12.getR12_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR12_above_3_up_6_aed_resident().intValue());
							}

							Cell R8cell2 = row8.getCell(6);
							if (R8cell2 != null) {
								R8cell2.setCellValue(BRF12.getR12_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR12_above_6_up_12_aed_resident().intValue());
							}

							Cell R8cell3 = row8.getCell(7);
							if (R8cell3 != null) {
								R8cell3.setCellValue(BRF12.getR12_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR12_exc_12_mon_aed_resident().intValue());
							}

							Cell R8cell4 = row8.getCell(8);
							if (R8cell4 != null) {
								R8cell4.setCellValue(BRF12.getR12_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR12_up_3_mon_fcy_resident().intValue());
							}

							Cell R8cell5 = row8.getCell(9);
							if (R8cell5 != null) {
								R8cell5.setCellValue(BRF12.getR12_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR12_above_3_up_6_fcy_resident().intValue());
							}

							Cell R8cell6 = row8.getCell(10);
							if (R8cell6 != null) {
								R8cell6.setCellValue(BRF12.getR12_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR12_above_6_up_12_fcy_resident().intValue());
							}

							Cell R8cell7 = row8.getCell(11);
							if (R8cell7 != null) {
								R8cell7.setCellValue(BRF12.getR12_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR12_exc_12_mon_fcy_resident().intValue());
							}

							Cell R8cell8 = row8.getCell(13);
							if (R8cell8 != null) {
								R8cell8.setCellValue(BRF12.getR12_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR12_up_3_mon_aed_non_resident().intValue());
							}

							Cell R8cell9 = row8.getCell(14);
							if (R8cell9 != null) {
								R8cell9.setCellValue(BRF12.getR12_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR12_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R8cell10 = row8.getCell(15);
							if (R8cell10 != null) {
								R8cell10.setCellValue(BRF12.getR12_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR12_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R8cell11 = row8.getCell(16);
							if (R8cell11 != null) {
								R8cell11.setCellValue(BRF12.getR12_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR12_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R8cell12 = row8.getCell(17);
							if (R8cell12 != null) {
								R8cell12.setCellValue(BRF12.getR12_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR12_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R8cell13 = row8.getCell(18);
							if (R8cell13 != null) {
								R8cell13.setCellValue(BRF12.getR12_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR12_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R8cell14 = row8.getCell(19);
							if (R8cell14 != null) {
								R8cell14.setCellValue(BRF12.getR12_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR12_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R8cell15 = row8.getCell(20);
							if (R8cell15 != null) {
								R8cell15.setCellValue(BRF12.getR12_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR12_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R14//////////////////////////////

							Row row9 = sheet.getRow(24);
							Cell R9cell = row9.getCell(4);
							if (R9cell != null) {
								R9cell.setCellValue(BRF12.getR14_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR14_up_3_mon_aed_resident().intValue());
							}

							Cell R9cell1 = row9.getCell(5);
							if (R9cell1 != null) {
								R9cell1.setCellValue(BRF12.getR14_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR14_above_3_up_6_aed_resident().intValue());
							}

							Cell R9cell2 = row9.getCell(6);
							if (R9cell2 != null) {
								R9cell2.setCellValue(BRF12.getR14_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR14_above_6_up_12_aed_resident().intValue());
							}

							Cell R9cell3 = row9.getCell(7);
							if (R9cell3 != null) {
								R9cell3.setCellValue(BRF12.getR14_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR14_exc_12_mon_aed_resident().intValue());
							}

							Cell R9cell4 = row9.getCell(8);
							if (R9cell4 != null) {
								R9cell4.setCellValue(BRF12.getR14_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR14_up_3_mon_fcy_resident().intValue());
							}

							Cell R9cell5 = row9.getCell(9);
							if (R9cell5 != null) {
								R9cell5.setCellValue(BRF12.getR14_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR14_above_3_up_6_fcy_resident().intValue());
							}

							Cell R9cell6 = row9.getCell(10);
							if (R9cell6 != null) {
								R9cell6.setCellValue(BRF12.getR14_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR14_above_6_up_12_fcy_resident().intValue());
							}

							Cell R9cell7 = row9.getCell(11);
							if (R9cell7 != null) {
								R9cell7.setCellValue(BRF12.getR14_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR14_exc_12_mon_fcy_resident().intValue());
							}

							Cell R9cell8 = row9.getCell(13);
							if (R9cell8 != null) {
								R9cell8.setCellValue(BRF12.getR14_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR14_up_3_mon_aed_non_resident().intValue());
							}

							Cell R9cell9 = row9.getCell(14);
							if (R9cell9 != null) {
								R9cell9.setCellValue(BRF12.getR14_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR14_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R9cell10 = row9.getCell(15);
							if (R9cell10 != null) {
								R9cell10.setCellValue(BRF12.getR14_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR14_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R9cell11 = row9.getCell(16);
							if (R9cell11 != null) {
								R9cell11.setCellValue(BRF12.getR14_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR14_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R9cell12 = row9.getCell(17);
							if (R9cell12 != null) {
								R9cell12.setCellValue(BRF12.getR14_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR14_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R9cell13 = row9.getCell(18);
							if (R9cell13 != null) {
								R9cell13.setCellValue(BRF12.getR14_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR14_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R9cell14 = row9.getCell(19);
							if (R9cell14 != null) {
								R9cell14.setCellValue(BRF12.getR14_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR14_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R9cell15 = row9.getCell(20);
							if (R9cell15 != null) {
								R9cell15.setCellValue(BRF12.getR14_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR14_exc_12_mon_fcy_non_resident().intValue());
							}

//////////////////////////////R15//////////////////////////////

							Row row10 = sheet.getRow(25);
							Cell R10cell = row10.getCell(4);
							if (R10cell != null) {
								R10cell.setCellValue(BRF12.getR15_up_3_mon_aed_resident() == null ? 0
										: BRF12.getR15_up_3_mon_aed_resident().intValue());
							}

							Cell R10cell1 = row10.getCell(5);
							if (R10cell1 != null) {
								R10cell1.setCellValue(BRF12.getR15_above_3_up_6_aed_resident() == null ? 0
										: BRF12.getR15_above_3_up_6_aed_resident().intValue());
							}

							Cell R10cell2 = row10.getCell(6);
							if (R10cell2 != null) {
								R10cell2.setCellValue(BRF12.getR15_above_6_up_12_aed_resident() == null ? 0
										: BRF12.getR15_above_6_up_12_aed_resident().intValue());
							}

							Cell R10cell3 = row10.getCell(7);
							if (R10cell3 != null) {
								R10cell3.setCellValue(BRF12.getR15_exc_12_mon_aed_resident() == null ? 0
										: BRF12.getR15_exc_12_mon_aed_resident().intValue());
							}

							Cell R10cell4 = row10.getCell(8);
							if (R10cell4 != null) {
								R10cell4.setCellValue(BRF12.getR15_up_3_mon_fcy_resident() == null ? 0
										: BRF12.getR15_up_3_mon_fcy_resident().intValue());
							}

							Cell R10cell5 = row10.getCell(9);
							if (R10cell5 != null) {
								R10cell5.setCellValue(BRF12.getR15_above_3_up_6_fcy_resident() == null ? 0
										: BRF12.getR15_above_3_up_6_fcy_resident().intValue());
							}

							Cell R10cell6 = row10.getCell(10);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF12.getR15_above_6_up_12_fcy_resident() == null ? 0
										: BRF12.getR15_above_6_up_12_fcy_resident().intValue());
							}

							Cell R10cell7 = row10.getCell(11);
							if (R10cell7 != null) {
								R10cell7.setCellValue(BRF12.getR15_exc_12_mon_fcy_resident() == null ? 0
										: BRF12.getR15_exc_12_mon_fcy_resident().intValue());
							}

							Cell R10cell8 = row10.getCell(13);
							if (R10cell8 != null) {
								R10cell8.setCellValue(BRF12.getR15_up_3_mon_aed_non_resident() == null ? 0
										: BRF12.getR15_up_3_mon_aed_non_resident().intValue());
							}

							Cell R10cell9 = row10.getCell(14);
							if (R10cell9 != null) {
								R10cell9.setCellValue(BRF12.getR15_above_3_up_6_aed_non_resident() == null ? 0
										: BRF12.getR15_above_3_up_6_aed_non_resident().intValue());
							}

							Cell R10cell10 = row10.getCell(15);
							if (R10cell10 != null) {
								R10cell10.setCellValue(BRF12.getR15_above_6_up_12_aed_non_resident() == null ? 0
										: BRF12.getR15_above_6_up_12_aed_non_resident().intValue());
							}

							Cell R10cell11 = row10.getCell(16);
							if (R10cell11 != null) {
								R10cell11.setCellValue(BRF12.getR15_exc_12_mon_aed_non_resident() == null ? 0
										: BRF12.getR15_exc_12_mon_aed_non_resident().intValue());
							}

							Cell R10cell12 = row10.getCell(17);
							if (R10cell12 != null) {
								R10cell12.setCellValue(BRF12.getR15_up_3_mon_fcy_non_resident() == null ? 0
										: BRF12.getR15_up_3_mon_fcy_non_resident().intValue());
							}

							Cell R10cell13 = row10.getCell(18);
							if (R10cell13 != null) {
								R10cell13.setCellValue(BRF12.getR15_above_3_up_6_fcy_non_resident() == null ? 0
										: BRF12.getR15_above_3_up_6_fcy_non_resident().intValue());
							}

							Cell R10cell14 = row10.getCell(19);
							if (R10cell14 != null) {
								R10cell14.setCellValue(BRF12.getR15_above_6_up_12_fcy_non_resident() == null ? 0
										: BRF12.getR15_above_6_up_12_fcy_non_resident().intValue());
							}

							Cell R10cell15 = row10.getCell(20);
							if (R10cell15 != null) {
								R10cell15.setCellValue(BRF12.getR15_exc_12_mon_fcy_non_resident() == null ? 0
										: BRF12.getR15_exc_12_mon_fcy_non_resident().intValue());
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-012-A.xls");
							workbook.write(fileOut);
							fileOut.close();
							System.out.println(fileOut);
							path = fileOut.toString();
							// Close the workbook
							System.out.println("PATH : " + path);
							workbook.close();
						}

					}

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

			} //// else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-012-A.xls");

		return outputFile;

	}

	public String detailChanges12(BRF12_DETAIL_ENTITY detail, String report_label_1, BigDecimal act_balance_amt_lc,
			String foracid, String report_name_1, String report_addl_criteria_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF12_DETAIL_ENTITY> Brf12detail = brf12_DETAIL_REPO.findById(foracid);

			if (Brf12detail.isPresent()) {
				BRF12_DETAIL_ENTITY BRFdetail = Brf12detail.get();

				if (BRFdetail.getReport_label_1().equals(report_label_1)
						&& BRFdetail.getReport_name_1().equals(report_name_1)
						&& BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc)
						&& BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)

				) {
					msg = "No modification done";
				} else {

					BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
					BRFdetail.setReport_label_1(report_label_1);
					BRFdetail.setReport_name_1(report_name_1);
					BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
					brf12_DETAIL_REPO.save(BRFdetail);

//						hs.saveOrUpdate(detail);
					logger.info("Edited Record");
					msg = "Edited Successfully";
				}
			} else {
				msg = "No data Found";
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	// ARCH
	public ModelAndView getArchieveBRF012View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF12_ENTITY> T1rep = new ArrayList<BRF12_ENTITY>();
		// Query<Object[]> qr;

		List<BRF12_ENTITY> T1Master = new ArrayList<BRF12_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF12_ENTITY a where a.report_date = ?1 ", BRF12_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF12ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
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
	public ModelAndView ARCHgetBRF012currentDtl(String reportId, String fromdate, String todate, String currency,
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
				System.out.println("1");
				qr = hs.createNativeQuery(
						"select * from BRF12_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF12_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF12_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF12_ARCHIVENTITY> T1Master = new ArrayList<BRF12_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF12_ARCHIVENTITY a where a.report_date = ?1", BRF12_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
			String acct_name = (String) a[4];
			String acct_crncy_code = (String) a[5];
			String gl_code = (String) a[6];
			String gl_sub_head_code = (String) a[7];
			String gl_sub_head_desc = (String) a[8];
			String country_of_incorp = (String) a[9];
			String cust_type = (String) a[10];
			String schm_code = (String) a[11];
			String schm_type = (String) a[12];
			String sol_id = (String) a[13];
			String acid = (String) a[14];
			String segment = (String) a[15];
			String sub_segment = (String) a[16];
			BigDecimal sector = (BigDecimal) a[17];
			String sub_sector = (String) a[18];
			String sector_code = (String) a[19];
			String group_id = (String) a[20];
			String constitution_code = (String) a[21];
			String country = (String) a[22];
			String legal_entity_type = (String) a[23];
			String constitution_desc = (String) a[24];
			String purpose_of_advn = (String) a[25];
			BigDecimal hni_networth = (BigDecimal) a[26];
			String turnover = (String) a[27];
			String bacid = (String) a[28];
			String report_name_1 = (String) a[29];
			String report_label_1 = (String) a[30];
			String report_addl_criteria_1 = (String) a[31];
			String report_addl_criteria_2 = (String) a[32];
			String report_addl_criteria_3 = (String) a[33];
			String create_user = (String) a[34];
			Date create_time = (Date) a[35];
			String modify_user = (String) a[36];
			Date modify_time = (Date) a[37];
			String verify_user = (String) a[38];
			Date verify_time = (Date) a[39];
			Character entity_flg = (Character) a[40];
			Character modify_flg = (Character) a[41];
			Character del_flg = (Character) a[42];
			Character nre_status = (Character) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nre_flag = (Character) a[49];

			String Remarks1;

			if (act_balance_amt_lc != null) {
				if (act_balance_amt_lc.toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}

			BRF12_ARCHIVENTITY py = new BRF12_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flag);
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

		mv.setViewName("RR" + "/" + "BRF12ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
