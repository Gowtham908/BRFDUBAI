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
import java.util.Objects;
import java.util.Optional;

import javax.sql.DataSource;
import javax.transaction.Transactional;

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
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRF66_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF066AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF300_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF32_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF46_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF66_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF66_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF66_Entity;

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
public class BRF66AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF66AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF066AServiceRepo brf066aServiceRepo;

	@Autowired
	BRF66_DetailRepo brf66_detailrepo;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF066A(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF66_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF66_Entity a ").getSingleResult();
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

	public ModelAndView getBRF066AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF66_Entity> T1rep = new ArrayList<BRF66_Entity>();

		List<BRF66_Entity> T1Master = new ArrayList<BRF66_Entity>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF66_Entity a where a.report_date = ?1 ", BRF66_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("RR/BRF66A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF066ADetails(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF66A_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF66A_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF66A_DETAILTABLE  where report_date = ?1");
		}
		List<BRF66_DETAIL_ENTITY> T1Master = new ArrayList<BRF66_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF66_DETAIL_ENTITY a where a.report_date = ?1", BRF66_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];
			String acct_name = (String) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[4];
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
			String entity_flg = (String) a[40];
			String modify_flg = (String) a[41];
			String del_flg = (String) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			String maturity_date = (String) a[45];
			String version = (String) a[46];
			String remarks = (String) a[47];

			BRF66_DETAIL_ENTITY py = new BRF66_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
					remarks);

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

		mv.setViewName("RR" + "/" + "BRF66A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF066A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-066-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF66_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF66_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF66.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF66.jrxml");
						}
					}

					JasperReport jr = JasperCompileManager.compileReport(jasperFile);
					HashMap<String, Object> map = new HashMap<String, Object>();

					logger.info("Assigning Parameters for Jasper");
					map.put("REPORT_DATE", todate);
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
				}outputFile = new File(path);
				return outputFile;
			} else {

				List<BRF66_Entity> T1Master = new ArrayList<BRF66_Entity>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF66_Entity a where a.report_date = ?1 ", BRF66_Entity.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF66_Entity BRF66 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-066-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);

							///////////////////////////////////// R1/////////////////////////////////////

							Row row = sheet.getRow(9);
							
							Cell cell0 = row.getCell(2);
							if (cell0 != null) {
								String value = (BRF66.getR1_borrowers_name() == null) ? "0" : BRF66.getR1_borrowers_name().toString();
								cell0.setCellValue(value);
							}

							Cell cell = row.getCell(3);
							if (cell != null) {
								String value = (BRF66.getR1_rating() == null) ? "0" : BRF66.getR1_rating().toString();
								cell.setCellValue(value);
							}
							Cell cell1 = row.getCell(4);
							if (cell1 != null) {
								String value = (BRF66.getR1_date_first() == null) ? "0"
										: BRF66.getR1_date_first().toString();
								cell1.setCellValue(value);
							}

							Cell cell2 = row.getCell(5);
							if (cell2 != null) {
								cell2.setCellValue(BRF66.getR1_principal_amount() == null ? 0
										: BRF66.getR1_principal_amount().intValue());
							}
							Cell cell3 = row.getCell(6);
							if (cell3 != null) {
								cell3.setCellValue(BRF66.getR1_original_year() == null ? 0
										: BRF66.getR1_original_year().intValue());
							}

							Cell cell4 = row.getCell(7);
							if (cell4 != null) {
								cell4.setCellValue(
										BRF66.getR1_after_year() == null ? 0 : BRF66.getR1_after_year().intValue());
							}

							Cell cell6 = row.getCell(8);
							if (cell6 != null) {
								cell6.setCellValue(BRF66.getR1_int_profit_pl() == null ? 0
										: BRF66.getR1_int_profit_pl().intValue());
							}

							Cell cell7 = row.getCell(9);
							if (cell7 != null) {
								cell7.setCellValue(BRF66.getR1_int_profit_acc() == null ? 0
										: BRF66.getR1_int_profit_acc().intValue());
							}

							Cell cell8 = row.getCell(10);
							if (cell8 != null) {
								cell8.setCellValue(BRF66.getR1_specific_provision() == null ? 0
										: BRF66.getR1_specific_provision().intValue());
							}

/////////////////////////////////////R2/////////////////////////////////////

							Row row1 = sheet.getRow(10);
							Cell R1cell0 = row1.getCell(2);
							if (R1cell0 != null) {
								String value = (BRF66.getR2_borrowers_name() == null) ? "0" : BRF66.getR2_borrowers_name().toString();
								R1cell0.setCellValue(value);
							}

							Cell R1cell = row1.getCell(3);
							if (R1cell != null) {
								String value = (BRF66.getR2_rating() == null) ? "0" : BRF66.getR2_rating().toString();
								R1cell.setCellValue(value);
							}
							Cell R1cell1 = row1.getCell(4);
							if (R1cell1 != null) {
								String value = (BRF66.getR2_date_first() == null) ? "0"
										: BRF66.getR2_date_first().toString();
								R1cell1.setCellValue(value);
							}

							Cell R1cell2 = row1.getCell(5);
							if (R1cell2 != null) {
								R1cell2.setCellValue(BRF66.getR2_principal_amount() == null ? 0
										: BRF66.getR2_principal_amount().intValue());
							}
							Cell R1cell3 = row1.getCell(6);
							if (R1cell3 != null) {
								R1cell3.setCellValue(BRF66.getR2_original_year() == null ? 0
										: BRF66.getR2_original_year().intValue());
							}

							Cell R1cell4 = row1.getCell(7);
							if (R1cell4 != null) {
								R1cell4.setCellValue(
										BRF66.getR2_after_year() == null ? 0 : BRF66.getR2_after_year().intValue());
							}

							Cell R1cell6 = row1.getCell(8);
							if (R1cell6 != null) {
								R1cell6.setCellValue(BRF66.getR2_int_profit_pl() == null ? 0
										: BRF66.getR2_int_profit_pl().intValue());
							}

							Cell R1cell7 = row1.getCell(9);
							if (R1cell7 != null) {
								R1cell7.setCellValue(BRF66.getR2_int_profit_acc() == null ? 0
										: BRF66.getR2_int_profit_acc().intValue());
							}

							Cell R1cell8 = row1.getCell(10);
							if (R1cell8 != null) {
								R1cell8.setCellValue(BRF66.getR2_specific_provision() == null ? 0
										: BRF66.getR2_specific_provision().intValue());
							}

/////////////////////////////////////R3/////////////////////////////////////

							Row row2 = sheet.getRow(11);
							
							Cell R2cell0 = row2.getCell(2);
							if (R2cell0 != null) {
							String value = (BRF66.getR3_borrowers_name() == null) ? "0" : BRF66.getR3_borrowers_name().toString();
							R2cell0.setCellValue(value);
							}

							Cell R2cell = row2.getCell(3);
							if (R2cell != null) {
								String value = (BRF66.getR3_rating() == null) ? "0" : BRF66.getR3_rating().toString();
								R2cell.setCellValue(value);
							}
							Cell R2cell1 = row2.getCell(4);
							if (R2cell1 != null) {
								String value = (BRF66.getR3_date_first() == null) ? "0"
										: BRF66.getR3_date_first().toString();
								R2cell1.setCellValue(value);
							}

							Cell R2cell2 = row2.getCell(5);
							if (R2cell2 != null) {
								R2cell2.setCellValue(BRF66.getR3_principal_amount() == null ? 0
										: BRF66.getR3_principal_amount().intValue());
							}
							Cell R2cell3 = row2.getCell(6);
							if (R2cell3 != null) {
								R2cell3.setCellValue(BRF66.getR3_original_year() == null ? 0
										: BRF66.getR3_original_year().intValue());
							}

							Cell R2cell4 = row2.getCell(7);
							if (R2cell4 != null) {
								R2cell4.setCellValue(
										BRF66.getR3_after_year() == null ? 0 : BRF66.getR3_after_year().intValue());
							}

							Cell R2cell6 = row2.getCell(8);
							if (R2cell6 != null) {
								R2cell6.setCellValue(BRF66.getR3_int_profit_pl() == null ? 0
										: BRF66.getR3_int_profit_pl().intValue());
							}

							Cell R2cell7 = row2.getCell(9);
							if (R2cell7 != null) {
								R2cell7.setCellValue(BRF66.getR3_int_profit_acc() == null ? 0
										: BRF66.getR3_int_profit_acc().intValue());
							}

							Cell R2cell8 = row2.getCell(10);
							if (R2cell8 != null) {
								R2cell8.setCellValue(BRF66.getR3_specific_provision() == null ? 0
										: BRF66.getR3_specific_provision().intValue());
							}

/////////////////////////////////////R4/////////////////////////////////////

							Row row3 = sheet.getRow(12);
							
							Cell R3cell0 = row3.getCell(2);
							if (R3cell0 != null) {
							String value = (BRF66.getR4_borrowers_name() == null) ? "0" : BRF66.getR4_borrowers_name().toString();
							R3cell0.setCellValue(value);
							}

							Cell R3cell = row3.getCell(3);
							if (R3cell != null) {
								String value = (BRF66.getR4_rating() == null) ? "0" : BRF66.getR4_rating().toString();
								R3cell.setCellValue(value);
							}
							Cell R3cell1 = row3.getCell(4);
							if (R3cell1 != null) {
								String value = (BRF66.getR4_date_first() == null) ? "0"
										: BRF66.getR4_date_first().toString();
								R3cell1.setCellValue(value);
							}

							Cell R3cell2 = row3.getCell(5);
							if (R3cell2 != null) {
								R3cell2.setCellValue(BRF66.getR4_principal_amount() == null ? 0
										: BRF66.getR4_principal_amount().intValue());
							}
							Cell R3cell3 = row3.getCell(6);
							if (R3cell3 != null) {
								R3cell3.setCellValue(BRF66.getR4_original_year() == null ? 0
										: BRF66.getR4_original_year().intValue());
							}

							Cell R3cell4 = row3.getCell(7);
							if (R3cell4 != null) {
								R3cell4.setCellValue(
										BRF66.getR4_after_year() == null ? 0 : BRF66.getR4_after_year().intValue());
							}

							Cell R3cell6 = row3.getCell(8);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF66.getR4_int_profit_pl() == null ? 0
										: BRF66.getR4_int_profit_pl().intValue());
							}

							Cell R3cell7 = row3.getCell(9);
							if (R3cell7 != null) {
								R3cell7.setCellValue(BRF66.getR4_int_profit_acc() == null ? 0
										: BRF66.getR4_int_profit_acc().intValue());
							}

							Cell R3cell8 = row3.getCell(10);
							if (R3cell8 != null) {
								R3cell8.setCellValue(BRF66.getR4_specific_provision() == null ? 0
										: BRF66.getR4_specific_provision().intValue());
							}

/////////////////////////////////////R5/////////////////////////////////////

							Row row4 = sheet.getRow(13);
							
							Cell R4cell0 = row4.getCell(2);
							if (R4cell0 != null) {
							String value = (BRF66.getR5_borrowers_name() == null) ? "0" : BRF66.getR5_borrowers_name().toString();
							R4cell0.setCellValue(value);
							}

							Cell R4cell = row4.getCell(3);
							if (R4cell != null) {
								String value = (BRF66.getR5_rating() == null) ? "0" : BRF66.getR5_rating().toString();
								R4cell.setCellValue(value);
							}
							Cell R4cell1 = row4.getCell(4);
							if (R4cell1 != null) {
								String value = (BRF66.getR5_date_first() == null) ? "0"
										: BRF66.getR5_date_first().toString();
								R4cell1.setCellValue(value);
							}

							Cell R4cell2 = row4.getCell(5);
							if (R4cell2 != null) {
								R4cell2.setCellValue(BRF66.getR5_principal_amount() == null ? 0
										: BRF66.getR5_principal_amount().intValue());
							}
							Cell R4cell3 = row4.getCell(6);
							if (R4cell3 != null) {
								R4cell3.setCellValue(BRF66.getR5_original_year() == null ? 0
										: BRF66.getR5_original_year().intValue());
							}

							Cell R4cell4 = row4.getCell(7);
							if (R4cell4 != null) {
								R4cell4.setCellValue(
										BRF66.getR5_after_year() == null ? 0 : BRF66.getR5_after_year().intValue());
							}

							Cell R4cell6 = row4.getCell(8);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF66.getR5_int_profit_pl() == null ? 0
										: BRF66.getR5_int_profit_pl().intValue());
							}

							Cell R4cell7 = row4.getCell(9);
							if (R4cell7 != null) {
								R4cell7.setCellValue(BRF66.getR5_int_profit_acc() == null ? 0
										: BRF66.getR5_int_profit_acc().intValue());
							}

							Cell R4cell8 = row4.getCell(10);
							if (R4cell8 != null) {
								R4cell8.setCellValue(BRF66.getR5_specific_provision() == null ? 0
										: BRF66.getR5_specific_provision().intValue());
							}

/////////////////////////////////////R6/////////////////////////////////////

							Row row5 = sheet.getRow(14);

							Cell R5cell0 = row5.getCell(2);
							if (R5cell0 != null) {
							String value = (BRF66.getR6_borrowers_name() == null) ? "0" : BRF66.getR6_borrowers_name().toString();
							R5cell0.setCellValue(value);
							}
							
							Cell R5cell = row5.getCell(3);
							if (R5cell != null) {
								String value = (BRF66.getR6_rating() == null) ? "0" : BRF66.getR6_rating().toString();
								R5cell.setCellValue(value);
							}
							Cell R5cell1 = row5.getCell(4);
							if (R5cell1 != null) {
								String value = (BRF66.getR6_date_first() == null) ? "0"
										: BRF66.getR6_date_first().toString();
								R5cell1.setCellValue(value);
							}

							Cell R5cell2 = row5.getCell(5);
							if (R5cell2 != null) {
								R5cell2.setCellValue(BRF66.getR6_principal_amount() == null ? 0
										: BRF66.getR6_principal_amount().intValue());
							}
							Cell R5cell3 = row5.getCell(6);
							if (R5cell3 != null) {
								R5cell3.setCellValue(BRF66.getR6_original_year() == null ? 0
										: BRF66.getR6_original_year().intValue());
							}

							Cell R5cell4 = row5.getCell(7);
							if (R5cell4 != null) {
								R5cell4.setCellValue(
										BRF66.getR6_after_year() == null ? 0 : BRF66.getR6_after_year().intValue());
							}

							Cell R5cell6 = row5.getCell(8);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF66.getR6_int_profit_pl() == null ? 0
										: BRF66.getR6_int_profit_pl().intValue());
							}

							Cell R5cell7 = row5.getCell(9);
							if (R5cell7 != null) {
								R5cell7.setCellValue(BRF66.getR6_int_profit_acc() == null ? 0
										: BRF66.getR6_int_profit_acc().intValue());
							}

							Cell R5cell8 = row5.getCell(10);
							if (R5cell8 != null) {
								R5cell8.setCellValue(BRF66.getR6_specific_provision() == null ? 0
										: BRF66.getR6_specific_provision().intValue());
							}

/////////////////////////////////////R7/////////////////////////////////////

							Row row6 = sheet.getRow(15);
							
							Cell R6cell0 = row6.getCell(2);
							if (R6cell0 != null) {
							String value = (BRF66.getR7_borrowers_name() == null) ? "0" : BRF66.getR7_borrowers_name().toString();
							R6cell0.setCellValue(value);
							}

							Cell R6cell = row6.getCell(3);
							if (R6cell != null) {
								String value = (BRF66.getR7_rating() == null) ? "0" : BRF66.getR7_rating().toString();
								R6cell.setCellValue(value);
							}
							Cell R6cell1 = row6.getCell(4);
							if (R6cell1 != null) {
								String value = (BRF66.getR7_date_first() == null) ? "0"
										: BRF66.getR7_date_first().toString();
								R6cell1.setCellValue(value);
							}

							Cell R6cell2 = row6.getCell(5);
							if (R6cell2 != null) {
								R6cell2.setCellValue(BRF66.getR7_principal_amount() == null ? 0
										: BRF66.getR7_principal_amount().intValue());
							}
							Cell R6cell3 = row6.getCell(6);
							if (R6cell3 != null) {
								R6cell3.setCellValue(BRF66.getR7_original_year() == null ? 0
										: BRF66.getR7_original_year().intValue());
							}

							Cell R6cell4 = row6.getCell(7);
							if (R6cell4 != null) {
								R6cell4.setCellValue(
										BRF66.getR7_after_year() == null ? 0 : BRF66.getR7_after_year().intValue());
							}

							Cell R6cell6 = row6.getCell(8);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF66.getR7_int_profit_pl() == null ? 0
										: BRF66.getR7_int_profit_pl().intValue());
							}

							Cell R6cell7 = row6.getCell(9);
							if (R6cell7 != null) {
								R6cell7.setCellValue(BRF66.getR7_int_profit_acc() == null ? 0
										: BRF66.getR7_int_profit_acc().intValue());
							}

							Cell R6cell8 = row6.getCell(10);
							if (R6cell8 != null) {
								R6cell8.setCellValue(BRF66.getR7_specific_provision() == null ? 0
										: BRF66.getR7_specific_provision().intValue());
							}

/////////////////////////////////////R8/////////////////////////////////////

							Row row7 = sheet.getRow(16);

							Cell R7cell0 = row7.getCell(2);
							if (R7cell0 != null) {
							String value = (BRF66.getR8_borrowers_name() == null) ? "0" : BRF66.getR8_borrowers_name().toString();
							R7cell0.setCellValue(value);
							}
							
							
							Cell R7cell = row7.getCell(3);
							if (R7cell != null) {
								String value = (BRF66.getR8_rating() == null) ? "0" : BRF66.getR8_rating().toString();
								R7cell.setCellValue(value);
							}
							Cell R7cell1 = row7.getCell(4);
							if (R7cell1 != null) {
								String value = (BRF66.getR8_date_first() == null) ? "0"
										: BRF66.getR8_date_first().toString();
								R7cell1.setCellValue(value);
							}

							Cell R7cell2 = row7.getCell(5);
							if (R7cell2 != null) {
								R7cell2.setCellValue(BRF66.getR8_principal_amount() == null ? 0
										: BRF66.getR8_principal_amount().intValue());
							}
							Cell R7cell3 = row7.getCell(6);
							if (R7cell3 != null) {
								R7cell3.setCellValue(BRF66.getR8_original_year() == null ? 0
										: BRF66.getR8_original_year().intValue());
							}

							Cell R7cell4 = row7.getCell(7);
							if (R7cell4 != null) {
								R7cell4.setCellValue(
										BRF66.getR8_after_year() == null ? 0 : BRF66.getR8_after_year().intValue());
							}

							Cell R7cell6 = row7.getCell(8);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF66.getR8_int_profit_pl() == null ? 0
										: BRF66.getR8_int_profit_pl().intValue());
							}

							Cell R7cell7 = row7.getCell(9);
							if (R7cell7 != null) {
								R7cell7.setCellValue(BRF66.getR8_int_profit_acc() == null ? 0
										: BRF66.getR8_int_profit_acc().intValue());
							}

							Cell R7cell8 = row7.getCell(10);
							if (R7cell8 != null) {
								R7cell8.setCellValue(BRF66.getR8_specific_provision() == null ? 0
										: BRF66.getR8_specific_provision().intValue());
							}

/////////////////////////////////////R9/////////////////////////////////////

							Row row8 = sheet.getRow(17);
							
							Cell R8cell0 = row8.getCell(2);
							if (R8cell0 != null) {
							String value = (BRF66.getR9_borrowers_name() == null) ? "0" : BRF66.getR9_borrowers_name().toString();
							R8cell0.setCellValue(value);
							}

							Cell R8cell = row8.getCell(3);
							if (R8cell != null) {
								String value = (BRF66.getR9_rating() == null) ? "0" : BRF66.getR9_rating().toString();
								R8cell.setCellValue(value);
							}
							Cell R8cell1 = row8.getCell(4);
							if (R8cell1 != null) {
								String value = (BRF66.getR9_date_first() == null) ? "0"
										: BRF66.getR9_date_first().toString();
								R8cell1.setCellValue(value);
							}

							Cell R8cell2 = row8.getCell(5);
							if (R8cell2 != null) {
								R8cell2.setCellValue(BRF66.getR9_principal_amount() == null ? 0
										: BRF66.getR9_principal_amount().intValue());
							}
							Cell R8cell3 = row8.getCell(6);
							if (R8cell3 != null) {
								R8cell3.setCellValue(BRF66.getR9_original_year() == null ? 0
										: BRF66.getR9_original_year().intValue());
							}

							Cell R8cell4 = row8.getCell(7);
							if (R8cell4 != null) {
								R8cell4.setCellValue(
										BRF66.getR9_after_year() == null ? 0 : BRF66.getR9_after_year().intValue());
							}

							Cell R8cell6 = row8.getCell(8);
							if (R8cell6 != null) {
								R8cell6.setCellValue(BRF66.getR9_int_profit_pl() == null ? 0
										: BRF66.getR9_int_profit_pl().intValue());
							}

							Cell R8cell7 = row8.getCell(9);
							if (R8cell7 != null) {
								R8cell7.setCellValue(BRF66.getR9_int_profit_acc() == null ? 0
										: BRF66.getR9_int_profit_acc().intValue());
							}

							Cell R8cell8 = row8.getCell(10);
							if (R8cell8 != null) {
								R8cell8.setCellValue(BRF66.getR9_specific_provision() == null ? 0
										: BRF66.getR9_specific_provision().intValue());
							}

/////////////////////////////////////R10/////////////////////////////////////

							Row row9 = sheet.getRow(18);
							
							Cell R9cell0 = row9.getCell(2);
							if (R9cell0 != null) {
							String value = (BRF66.getR10_borrowers_name() == null) ? "0" : BRF66.getR10_borrowers_name().toString();
							R9cell0.setCellValue(value);
							}

							Cell R9cell = row9.getCell(3);
							if (R9cell != null) {
								String value = (BRF66.getR10_rating() == null) ? "0" : BRF66.getR10_rating().toString();
								R9cell.setCellValue(value);
							}
							Cell R9cell1 = row9.getCell(4);
							if (R9cell1 != null) {
								String value = (BRF66.getR10_date_first() == null) ? "0"
										: BRF66.getR10_date_first().toString();
								R9cell1.setCellValue(value);
							}

							Cell R9cell2 = row9.getCell(5);
							if (R9cell2 != null) {
								R9cell2.setCellValue(BRF66.getR10_principal_amount() == null ? 0
										: BRF66.getR10_principal_amount().intValue());
							}
							Cell R9cell3 = row9.getCell(6);
							if (R9cell3 != null) {
								R9cell3.setCellValue(BRF66.getR10_original_year() == null ? 0
										: BRF66.getR10_original_year().intValue());
							}

							Cell R9cell4 = row9.getCell(7);
							if (R9cell4 != null) {
								R9cell4.setCellValue(
										BRF66.getR10_after_year() == null ? 0 : BRF66.getR10_after_year().intValue());
							}

							Cell R9cell6 = row9.getCell(8);
							if (R9cell6 != null) {
								R9cell6.setCellValue(BRF66.getR10_int_profit_pl() == null ? 0
										: BRF66.getR10_int_profit_pl().intValue());
							}

							Cell R9cell7 = row9.getCell(9);
							if (R9cell7 != null) {
								R9cell7.setCellValue(BRF66.getR10_int_profit_acc() == null ? 0
										: BRF66.getR10_int_profit_acc().intValue());
							}

							Cell R9cell8 = row9.getCell(10);
							if (R9cell8 != null) {
								R9cell8.setCellValue(BRF66.getR10_specific_provision() == null ? 0
										: BRF66.getR10_specific_provision().intValue());
							}

//////////////////////////////////////R11/////////////////////////////////////

							Row row10 = sheet.getRow(19);

							Cell R10cell0 = row10.getCell(2);
							if (R10cell0 != null) {
							String value = (BRF66.getR11_borrowers_name() == null) ? "0" : BRF66.getR11_borrowers_name().toString();
							R10cell0.setCellValue(value);
							}
							
							Cell R10cell = row10.getCell(3);
							if (R10cell != null) {
								String value = (BRF66.getR11_rating() == null) ? "0" : BRF66.getR11_rating().toString();
								R10cell.setCellValue(value);
							}
							Cell R10cell1 = row10.getCell(4);
							if (R10cell1 != null) {
								String value = (BRF66.getR11_date_first() == null) ? "0"
										: BRF66.getR11_date_first().toString();
								R10cell1.setCellValue(value);
							}

							Cell R10cell2 = row10.getCell(5);
							if (R10cell2 != null) {
								R10cell2.setCellValue(BRF66.getR11_principal_amount() == null ? 0
										: BRF66.getR11_principal_amount().intValue());
							}
							Cell R10cell3 = row10.getCell(6);
							if (R10cell3 != null) {
								R10cell3.setCellValue(BRF66.getR11_original_year() == null ? 0
										: BRF66.getR11_original_year().intValue());
							}

							Cell R10cell4 = row10.getCell(7);
							if (R10cell4 != null) {
								R10cell4.setCellValue(
										BRF66.getR11_after_year() == null ? 0 : BRF66.getR11_after_year().intValue());
							}

							Cell R10cell6 = row10.getCell(8);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF66.getR11_int_profit_pl() == null ? 0
										: BRF66.getR11_int_profit_pl().intValue());
							}

							Cell R10cell7 = row10.getCell(9);
							if (R10cell7 != null) {
								R10cell7.setCellValue(BRF66.getR11_int_profit_acc() == null ? 0
										: BRF66.getR11_int_profit_acc().intValue());
							}

							Cell R10cell8 = row10.getCell(10);
							if (R10cell8 != null) {
								R10cell8.setCellValue(BRF66.getR11_specific_provision() == null ? 0
										: BRF66.getR11_specific_provision().intValue());
							}

/////////////////////////////////////R12/////////////////////////////////////

							Row row11 = sheet.getRow(20);
							
							Cell R11cell0 = row11.getCell(2);
							if (R11cell0 != null) {
							String value = (BRF66.getR12_borrowers_name() == null) ? "0" : BRF66.getR12_borrowers_name().toString();
							R11cell0.setCellValue(value);
							}

							Cell R11cell = row11.getCell(3);
							if (R11cell != null) {
								String value = (BRF66.getR12_rating() == null) ? "0" : BRF66.getR12_rating().toString();
								R11cell.setCellValue(value);
							}
							Cell R11cell1 = row11.getCell(4);
							if (R11cell1 != null) {
								String value = (BRF66.getR12_date_first() == null) ? "0"
										: BRF66.getR12_date_first().toString();
								R11cell1.setCellValue(value);
							}

							Cell R11cell2 = row11.getCell(5);
							if (R11cell2 != null) {
								R11cell2.setCellValue(BRF66.getR12_principal_amount() == null ? 0
										: BRF66.getR12_principal_amount().intValue());
							}
							Cell R11cell3 = row11.getCell(6);
							if (R11cell3 != null) {
								R11cell3.setCellValue(BRF66.getR12_original_year() == null ? 0
										: BRF66.getR12_original_year().intValue());
							}

							Cell R11cell4 = row11.getCell(7);
							if (R11cell4 != null) {
								R11cell4.setCellValue(
										BRF66.getR12_after_year() == null ? 0 : BRF66.getR12_after_year().intValue());
							}

							Cell R11cell6 = row11.getCell(8);
							if (R11cell6 != null) {
								R11cell6.setCellValue(BRF66.getR12_int_profit_pl() == null ? 0
										: BRF66.getR12_int_profit_pl().intValue());
							}

							Cell R11cell7 = row11.getCell(9);
							if (R11cell7 != null) {
								R11cell7.setCellValue(BRF66.getR12_int_profit_acc() == null ? 0
										: BRF66.getR12_int_profit_acc().intValue());
							}

							Cell R11cell8 = row11.getCell(10);
							if (R11cell8 != null) {
								R11cell8.setCellValue(BRF66.getR12_specific_provision() == null ? 0
										: BRF66.getR12_specific_provision().intValue());
							}

/////////////////////////////////////R13/////////////////////////////////////

							Row row12 = sheet.getRow(21);
							
							Cell R12cell0 = row12.getCell(2);
							if (R12cell0 != null) {
							String value = (BRF66.getR13_borrowers_name() == null) ? "0" : BRF66.getR13_borrowers_name().toString();
							R12cell0.setCellValue(value);
							}

							Cell R12cell = row12.getCell(3);
							if (R12cell != null) {
								String value = (BRF66.getR13_rating() == null) ? "0" : BRF66.getR13_rating().toString();
								R12cell.setCellValue(value);
							}
							Cell R12cell1 = row12.getCell(4);
							if (R12cell1 != null) {
								String value = (BRF66.getR13_date_first() == null) ? "0"
										: BRF66.getR13_date_first().toString();
								R12cell1.setCellValue(value);
							}

							Cell R12cell2 = row12.getCell(5);
							if (R12cell2 != null) {
								R12cell2.setCellValue(BRF66.getR13_principal_amount() == null ? 0
										: BRF66.getR13_principal_amount().intValue());
							}
							Cell R12cell3 = row12.getCell(6);
							if (R12cell3 != null) {
								R12cell3.setCellValue(BRF66.getR13_original_year() == null ? 0
										: BRF66.getR13_original_year().intValue());
							}

							Cell R12cell4 = row12.getCell(7);
							if (R12cell4 != null) {
								R12cell4.setCellValue(
										BRF66.getR13_after_year() == null ? 0 : BRF66.getR13_after_year().intValue());
							}

							Cell R12cell6 = row12.getCell(8);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF66.getR13_int_profit_pl() == null ? 0
										: BRF66.getR13_int_profit_pl().intValue());
							}

							Cell R12cell7 = row12.getCell(9);
							if (R12cell7 != null) {
								R12cell7.setCellValue(BRF66.getR13_int_profit_acc() == null ? 0
										: BRF66.getR13_int_profit_acc().intValue());
							}

							Cell R12cell8 = row12.getCell(10);
							if (R12cell8 != null) {
								R12cell8.setCellValue(BRF66.getR13_specific_provision() == null ? 0
										: BRF66.getR13_specific_provision().intValue());
							}

/////////////////////////////////////R14/////////////////////////////////////

							Row row13 = sheet.getRow(22);
							
							Cell R13cell0 = row13.getCell(2);
							if (R13cell0 != null) {
							String value = (BRF66.getR14_borrowers_name() == null) ? "0" : BRF66.getR14_borrowers_name().toString();
							R13cell0.setCellValue(value);
							}

							Cell R13cell = row13.getCell(3);
							if (R13cell != null) {
								String value = (BRF66.getR14_rating() == null) ? "0" : BRF66.getR14_rating().toString();
								R13cell.setCellValue(value);
							}
							Cell R13cell1 = row13.getCell(4);
							if (R13cell1 != null) {
								String value = (BRF66.getR14_date_first() == null) ? "0"
										: BRF66.getR14_date_first().toString();
								R13cell1.setCellValue(value);
							}

							Cell R13cell2 = row13.getCell(5);
							if (R13cell2 != null) {
								R13cell2.setCellValue(BRF66.getR14_principal_amount() == null ? 0
										: BRF66.getR14_principal_amount().intValue());
							}
							Cell R13cell3 = row13.getCell(6);
							if (R13cell3 != null) {
								R13cell3.setCellValue(BRF66.getR14_original_year() == null ? 0
										: BRF66.getR14_original_year().intValue());
							}

							Cell R13cell4 = row13.getCell(7);
							if (R13cell4 != null) {
								R13cell4.setCellValue(
										BRF66.getR14_after_year() == null ? 0 : BRF66.getR14_after_year().intValue());
							}

							Cell R13cell6 = row13.getCell(8);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF66.getR14_int_profit_pl() == null ? 0
										: BRF66.getR14_int_profit_pl().intValue());
							}

							Cell R13cell7 = row13.getCell(9);
							if (R13cell7 != null) {
								R13cell7.setCellValue(BRF66.getR14_int_profit_acc() == null ? 0
										: BRF66.getR14_int_profit_acc().intValue());
							}

							Cell R13cell8 = row13.getCell(10);
							if (R13cell8 != null) {
								R13cell8.setCellValue(BRF66.getR14_specific_provision() == null ? 0
										: BRF66.getR14_specific_provision().intValue());
							}

/////////////////////////////////////R15/////////////////////////////////////

							Row row14 = sheet.getRow(23);
							
							Cell R14cell0 = row14.getCell(2);
							if (R14cell0 != null) {
							String value = (BRF66.getR15_borrowers_name() == null) ? "0" : BRF66.getR15_borrowers_name().toString();
							R14cell0.setCellValue(value);
							}

							Cell R14cell = row14.getCell(3);
							if (R14cell != null) {
								String value = (BRF66.getR15_rating() == null) ? "0" : BRF66.getR15_rating().toString();
								R14cell.setCellValue(value);
							}
							Cell R14cell1 = row14.getCell(4);
							if (R14cell1 != null) {
								String value = (BRF66.getR15_date_first() == null) ? "0"
										: BRF66.getR15_date_first().toString();
								R14cell1.setCellValue(value);
							}

							Cell R14cell2 = row14.getCell(5);
							if (R14cell2 != null) {
								R14cell2.setCellValue(BRF66.getR15_principal_amount() == null ? 0
										: BRF66.getR15_principal_amount().intValue());
							}
							Cell R14cell3 = row14.getCell(6);
							if (R14cell3 != null) {
								R14cell3.setCellValue(BRF66.getR15_original_year() == null ? 0
										: BRF66.getR15_original_year().intValue());
							}

							Cell R14cell4 = row14.getCell(7);
							if (R14cell4 != null) {
								R14cell4.setCellValue(
										BRF66.getR15_after_year() == null ? 0 : BRF66.getR15_after_year().intValue());
							}

							Cell R14cell6 = row14.getCell(8);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF66.getR15_int_profit_pl() == null ? 0
										: BRF66.getR15_int_profit_pl().intValue());
							}

							Cell R14cell7 = row14.getCell(9);
							if (R14cell7 != null) {
								R14cell7.setCellValue(BRF66.getR15_int_profit_acc() == null ? 0
										: BRF66.getR15_int_profit_acc().intValue());
							}

							Cell R14cell8 = row14.getCell(10);
							if (R14cell8 != null) {
								R14cell8.setCellValue(BRF66.getR15_specific_provision() == null ? 0
										: BRF66.getR15_specific_provision().intValue());
							}

/////////////////////////////////////R16/////////////////////////////////////

							Row row15 = sheet.getRow(24);
							
							Cell R15cell0 = row15.getCell(2);
							if (R15cell0 != null) {
							String value = (BRF66.getR16_borrowers_name() == null) ? "0" : BRF66.getR16_borrowers_name().toString();
							R15cell0.setCellValue(value);
							}

							Cell R15cell = row15.getCell(3);
							if (R15cell != null) {
								String value = (BRF66.getR16_rating() == null) ? "0" : BRF66.getR16_rating().toString();
								R15cell.setCellValue(value);
							}
							Cell R15cell1 = row15.getCell(4);
							if (R15cell1 != null) {
								String value = (BRF66.getR16_date_first() == null) ? "0"
										: BRF66.getR16_date_first().toString();
								R15cell1.setCellValue(value);
							}

							Cell R15cell2 = row15.getCell(5);
							if (R15cell2 != null) {
								R15cell2.setCellValue(BRF66.getR16_principal_amount() == null ? 0
										: BRF66.getR16_principal_amount().intValue());
							}
							Cell R15cell3 = row15.getCell(6);
							if (R15cell3 != null) {
								R15cell3.setCellValue(BRF66.getR16_original_year() == null ? 0
										: BRF66.getR16_original_year().intValue());
							}

							Cell R15cell4 = row15.getCell(7);
							if (R15cell4 != null) {
								R15cell4.setCellValue(
										BRF66.getR16_after_year() == null ? 0 : BRF66.getR16_after_year().intValue());
							}

							Cell R15cell6 = row15.getCell(8);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF66.getR16_int_profit_pl() == null ? 0
										: BRF66.getR16_int_profit_pl().intValue());
							}

							Cell R15cell7 = row15.getCell(9);
							if (R15cell7 != null) {
								R15cell7.setCellValue(BRF66.getR16_int_profit_acc() == null ? 0
										: BRF66.getR16_int_profit_acc().intValue());
							}

							Cell R15cell8 = row15.getCell(10);
							if (R15cell8 != null) {
								R15cell8.setCellValue(BRF66.getR16_specific_provision() == null ? 0
										: BRF66.getR16_specific_provision().intValue());
							}

/////////////////////////////////////R17/////////////////////////////////////

							Row row16 = sheet.getRow(25);
							
							Cell R16cell0 = row16.getCell(2);
							if (R16cell0 != null) {
							String value = (BRF66.getR17_borrowers_name() == null) ? "0" : BRF66.getR17_borrowers_name().toString();
							R16cell0.setCellValue(value);
							}

							Cell R16cell = row16.getCell(3);
							if (R16cell != null) {
								String value = (BRF66.getR17_rating() == null) ? "0" : BRF66.getR17_rating().toString();
								R16cell.setCellValue(value);
							}
							Cell R16cell1 = row16.getCell(4);
							if (R16cell1 != null) {
								String value = (BRF66.getR17_date_first() == null) ? "0"
										: BRF66.getR17_date_first().toString();
								R16cell1.setCellValue(value);
							}

							Cell R16cell2 = row16.getCell(5);
							if (R16cell2 != null) {
								R16cell2.setCellValue(BRF66.getR17_principal_amount() == null ? 0
										: BRF66.getR17_principal_amount().intValue());
							}
							Cell R16cell3 = row16.getCell(6);
							if (R16cell3 != null) {
								R16cell3.setCellValue(BRF66.getR17_original_year() == null ? 0
										: BRF66.getR17_original_year().intValue());
							}

							Cell R16cell4 = row16.getCell(7);
							if (R16cell4 != null) {
								R16cell4.setCellValue(
										BRF66.getR17_after_year() == null ? 0 : BRF66.getR17_after_year().intValue());
							}

							Cell R16cell6 = row16.getCell(8);
							if (R16cell6 != null) {
								R16cell6.setCellValue(BRF66.getR17_int_profit_pl() == null ? 0
										: BRF66.getR17_int_profit_pl().intValue());
							}

							Cell R16cell7 = row16.getCell(9);
							if (R16cell7 != null) {
								R16cell7.setCellValue(BRF66.getR17_int_profit_acc() == null ? 0
										: BRF66.getR17_int_profit_acc().intValue());
							}

							Cell R16cell8 = row16.getCell(10);
							if (R16cell8 != null) {
								R16cell8.setCellValue(BRF66.getR17_specific_provision() == null ? 0
										: BRF66.getR17_specific_provision().intValue());
							}

/////////////////////////////////////R18/////////////////////////////////////

							Row row17 = sheet.getRow(26);

							Cell R17cell0 = row17.getCell(2);
							if (R17cell0 != null) {
							String value = (BRF66.getR18_borrowers_name() == null) ? "0" : BRF66.getR18_borrowers_name().toString();
							R17cell0.setCellValue(value);
							}
							
							Cell R17cell = row17.getCell(3);
							if (R17cell != null) {
								String value = (BRF66.getR18_rating() == null) ? "0" : BRF66.getR18_rating().toString();
								R17cell.setCellValue(value);
							}
							Cell R17cell1 = row17.getCell(4);
							if (R17cell1 != null) {
								String value = (BRF66.getR18_date_first() == null) ? "0"
										: BRF66.getR18_date_first().toString();
								R17cell1.setCellValue(value);
							}

							Cell R17cell2 = row17.getCell(5);
							if (R17cell2 != null) {
								R17cell2.setCellValue(BRF66.getR18_principal_amount() == null ? 0
										: BRF66.getR18_principal_amount().intValue());
							}
							Cell R17cell3 = row17.getCell(6);
							if (R17cell3 != null) {
								R17cell3.setCellValue(BRF66.getR18_original_year() == null ? 0
										: BRF66.getR18_original_year().intValue());
							}

							Cell R17cell4 = row17.getCell(7);
							if (R17cell4 != null) {
								R17cell4.setCellValue(
										BRF66.getR18_after_year() == null ? 0 : BRF66.getR18_after_year().intValue());
							}

							Cell R17cell6 = row17.getCell(8);
							if (R17cell6 != null) {
								R17cell6.setCellValue(BRF66.getR18_int_profit_pl() == null ? 0
										: BRF66.getR18_int_profit_pl().intValue());
							}

							Cell R17cell7 = row17.getCell(9);
							if (R17cell7 != null) {
								R17cell7.setCellValue(BRF66.getR18_int_profit_acc() == null ? 0
										: BRF66.getR18_int_profit_acc().intValue());
							}

							Cell R17cell8 = row17.getCell(10);
							if (R17cell8 != null) {
								R17cell8.setCellValue(BRF66.getR18_specific_provision() == null ? 0
										: BRF66.getR18_specific_provision().intValue());
							}

/////////////////////////////////////R19/////////////////////////////////////

							Row row18 = sheet.getRow(27);
							
							Cell R18cell0 = row18.getCell(2);
							if (R18cell0 != null) {
							String value = (BRF66.getR19_borrowers_name() == null) ? "0" : BRF66.getR19_borrowers_name().toString();
							R18cell0.setCellValue(value);
							}

							Cell R18cell = row18.getCell(3);
							if (R18cell != null) {
								String value = (BRF66.getR19_rating() == null) ? "0" : BRF66.getR19_rating().toString();
								R18cell.setCellValue(value);
							}
							Cell R18cell1 = row18.getCell(4);
							if (R18cell1 != null) {
								String value = (BRF66.getR19_date_first() == null) ? "0"
										: BRF66.getR19_date_first().toString();
								R18cell1.setCellValue(value);
							}

							Cell R18cell2 = row18.getCell(5);
							if (R18cell2 != null) {
								R18cell2.setCellValue(BRF66.getR19_principal_amount() == null ? 0
										: BRF66.getR19_principal_amount().intValue());
							}
							Cell R18cell3 = row18.getCell(6);
							if (R18cell3 != null) {
								R18cell3.setCellValue(BRF66.getR19_original_year() == null ? 0
										: BRF66.getR19_original_year().intValue());
							}

							Cell R18cell4 = row18.getCell(7);
							if (R18cell4 != null) {
								R18cell4.setCellValue(
										BRF66.getR19_after_year() == null ? 0 : BRF66.getR19_after_year().intValue());
							}

							Cell R18cell6 = row18.getCell(8);
							if (R18cell6 != null) {
								R18cell6.setCellValue(BRF66.getR19_int_profit_pl() == null ? 0
										: BRF66.getR19_int_profit_pl().intValue());
							}

							Cell R18cell7 = row18.getCell(9);
							if (R18cell7 != null) {
								R18cell7.setCellValue(BRF66.getR19_int_profit_acc() == null ? 0
										: BRF66.getR19_int_profit_acc().intValue());
							}

							Cell R18cell8 = row18.getCell(10);
							if (R18cell8 != null) {
								R18cell8.setCellValue(BRF66.getR19_specific_provision() == null ? 0
										: BRF66.getR19_specific_provision().intValue());
							}

/////////////////////////////////////R20/////////////////////////////////////

							Row row19 = sheet.getRow(28);
							
							Cell R19cell0 = row19.getCell(2);
							if (R19cell0 != null) {
							String value = (BRF66.getR20_borrowers_name() == null) ? "0" : BRF66.getR20_borrowers_name().toString();
							R19cell0.setCellValue(value);
							}

							Cell R19cell = row19.getCell(3);
							if (R19cell != null) {
								String value = (BRF66.getR20_rating() == null) ? "0" : BRF66.getR20_rating().toString();
								R19cell.setCellValue(value);
							}
							Cell R19cell1 = row19.getCell(4);
							if (R19cell1 != null) {
								String value = (BRF66.getR20_date_first() == null) ? "0"
										: BRF66.getR20_date_first().toString();
								R19cell1.setCellValue(value);
							}

							Cell R19cell2 = row19.getCell(5);
							if (R19cell2 != null) {
								R19cell2.setCellValue(BRF66.getR20_principal_amount() == null ? 0
										: BRF66.getR20_principal_amount().intValue());
							}
							Cell R19cell3 = row19.getCell(6);
							if (R19cell3 != null) {
								R19cell3.setCellValue(BRF66.getR20_original_year() == null ? 0
										: BRF66.getR20_original_year().intValue());
							}

							Cell R19cell4 = row19.getCell(7);
							if (R19cell4 != null) {
								R19cell4.setCellValue(
										BRF66.getR20_after_year() == null ? 0 : BRF66.getR20_after_year().intValue());
							}

							Cell R19cell6 = row19.getCell(8);
							if (R19cell6 != null) {
								R19cell6.setCellValue(BRF66.getR20_int_profit_pl() == null ? 0
										: BRF66.getR20_int_profit_pl().intValue());
							}

							Cell R19cell7 = row19.getCell(9);
							if (R19cell7 != null) {
								R19cell7.setCellValue(BRF66.getR20_int_profit_acc() == null ? 0
										: BRF66.getR20_int_profit_acc().intValue());
							}

							Cell R19cell8 = row19.getCell(10);
							if (R19cell8 != null) {
								R19cell8.setCellValue(BRF66.getR20_specific_provision() == null ? 0
										: BRF66.getR20_specific_provision().intValue());
							}

/////////////////////////////////////R21/////////////////////////////////////

							Row row20 = sheet.getRow(29);
							
							Cell R20cell0 = row20.getCell(2);
							if (R20cell0 != null) {
							String value = (BRF66.getR21_borrowers_name() == null) ? "0" : BRF66.getR21_borrowers_name().toString();
							R20cell0.setCellValue(value);
							}

							Cell R20cell = row20.getCell(3);
							if (R20cell != null) {
								String value = (BRF66.getR21_rating() == null) ? "0" : BRF66.getR21_rating().toString();
								R20cell.setCellValue(value);
							}
							Cell R20cell1 = row20.getCell(4);
							if (R20cell1 != null) {
								String value = (BRF66.getR21_date_first() == null) ? "0"
										: BRF66.getR21_date_first().toString();
								R20cell1.setCellValue(value);
							}

							Cell R20cell2 = row20.getCell(5);
							if (R20cell2 != null) {
								R20cell2.setCellValue(BRF66.getR21_principal_amount() == null ? 0
										: BRF66.getR21_principal_amount().intValue());
							}
							Cell R20cell3 = row20.getCell(6);
							if (R20cell3 != null) {
								R20cell3.setCellValue(BRF66.getR21_original_year() == null ? 0
										: BRF66.getR21_original_year().intValue());
							}

							Cell R20cell4 = row20.getCell(7);
							if (R20cell4 != null) {
								R20cell4.setCellValue(
										BRF66.getR21_after_year() == null ? 0 : BRF66.getR21_after_year().intValue());
							}

							Cell R20cell6 = row20.getCell(8);
							if (R20cell6 != null) {
								R20cell6.setCellValue(BRF66.getR21_int_profit_pl() == null ? 0
										: BRF66.getR21_int_profit_pl().intValue());
							}

							Cell R20cell7 = row20.getCell(9);
							if (R20cell7 != null) {
								R20cell7.setCellValue(BRF66.getR21_int_profit_acc() == null ? 0
										: BRF66.getR21_int_profit_acc().intValue());
							}

							Cell R20cell8 = row20.getCell(10);
							if (R20cell8 != null) {
								R20cell8.setCellValue(BRF66.getR21_specific_provision() == null ? 0
										: BRF66.getR21_specific_provision().intValue());
							}

/////////////////////////////////////R22/////////////////////////////////////

							Row row21 = sheet.getRow(30);
							
							Cell R21cell0 = row21.getCell(2);
							if (R21cell0 != null) {
							String value = (BRF66.getR22_borrowers_name() == null) ? "0" : BRF66.getR22_borrowers_name().toString();
							R21cell0.setCellValue(value);
							}

							Cell R21cell = row21.getCell(3);
							if (R21cell != null) {
								String value = (BRF66.getR22_rating() == null) ? "0" : BRF66.getR22_rating().toString();
								R21cell.setCellValue(value);
							}
							Cell R21cell1 = row21.getCell(4);
							if (R21cell1 != null) {
								String value = (BRF66.getR22_date_first() == null) ? "0"
										: BRF66.getR22_date_first().toString();
								R21cell1.setCellValue(value);
							}

							Cell R21cell2 = row21.getCell(5);
							if (R21cell2 != null) {
								R21cell2.setCellValue(BRF66.getR22_principal_amount() == null ? 0
										: BRF66.getR22_principal_amount().intValue());
							}
							Cell R21cell3 = row21.getCell(6);
							if (R21cell3 != null) {
								R21cell3.setCellValue(BRF66.getR22_original_year() == null ? 0
										: BRF66.getR22_original_year().intValue());
							}

							Cell R21cell4 = row21.getCell(7);
							if (R21cell4 != null) {
								R21cell4.setCellValue(
										BRF66.getR22_after_year() == null ? 0 : BRF66.getR22_after_year().intValue());
							}

							Cell R21cell6 = row21.getCell(8);
							if (R21cell6 != null) {
								R21cell6.setCellValue(BRF66.getR22_int_profit_pl() == null ? 0
										: BRF66.getR22_int_profit_pl().intValue());
							}

							Cell R21cell7 = row21.getCell(9);
							if (R21cell7 != null) {
								R21cell7.setCellValue(BRF66.getR22_int_profit_acc() == null ? 0
										: BRF66.getR22_int_profit_acc().intValue());
							}

							Cell R21cell8 = row21.getCell(10);
							if (R21cell8 != null) {
								R21cell8.setCellValue(BRF66.getR22_specific_provision() == null ? 0
										: BRF66.getR22_specific_provision().intValue());
							}

/////////////////////////////////////R23/////////////////////////////////////

							Row row22 = sheet.getRow(31);
							
							Cell R22cell0 = row22.getCell(2);
							if (R22cell0 != null) {
							String value = (BRF66.getR23_borrowers_name() == null) ? "0" : BRF66.getR23_borrowers_name().toString();
							R22cell0.setCellValue(value);
							}

							Cell R22cell = row22.getCell(3);
							if (R22cell != null) {
								String value = (BRF66.getR23_rating() == null) ? "0" : BRF66.getR23_rating().toString();
								R22cell.setCellValue(value);
							}
							Cell R22cell1 = row22.getCell(4);
							if (R22cell1 != null) {
								String value = (BRF66.getR23_date_first() == null) ? "0"
										: BRF66.getR23_date_first().toString();
								R22cell1.setCellValue(value);
							}

							Cell R22cell2 = row22.getCell(5);
							if (R22cell2 != null) {
								R22cell2.setCellValue(BRF66.getR23_principal_amount() == null ? 0
										: BRF66.getR23_principal_amount().intValue());
							}
							Cell R22cell3 = row22.getCell(6);
							if (R22cell3 != null) {
								R22cell3.setCellValue(BRF66.getR23_original_year() == null ? 0
										: BRF66.getR23_original_year().intValue());
							}

							Cell R22cell4 = row22.getCell(7);
							if (R22cell4 != null) {
								R22cell4.setCellValue(
										BRF66.getR23_after_year() == null ? 0 : BRF66.getR23_after_year().intValue());
							}

							Cell R22cell6 = row22.getCell(8);
							if (R22cell6 != null) {
								R22cell6.setCellValue(BRF66.getR23_int_profit_pl() == null ? 0
										: BRF66.getR23_int_profit_pl().intValue());
							}

							Cell R22cell7 = row22.getCell(9);
							if (R22cell7 != null) {
								R22cell7.setCellValue(BRF66.getR23_int_profit_acc() == null ? 0
										: BRF66.getR23_int_profit_acc().intValue());
							}

							Cell R22cell8 = row22.getCell(10);
							if (R22cell8 != null) {
								R22cell8.setCellValue(BRF66.getR23_specific_provision() == null ? 0
										: BRF66.getR23_specific_provision().intValue());
							}

/////////////////////////////////////R24/////////////////////////////////////

							Row row23 = sheet.getRow(32);
							
							Cell R23cell0 = row23.getCell(2);
							if (R23cell0 != null) {
							String value = (BRF66.getR24_borrowers_name() == null) ? "0" : BRF66.getR24_borrowers_name().toString();
							R23cell0.setCellValue(value);
							}

							Cell R23cell = row23.getCell(3);
							if (R23cell != null) {
								String value = (BRF66.getR24_rating() == null) ? "0" : BRF66.getR24_rating().toString();
								R23cell.setCellValue(value);
							}
							Cell R23cell1 = row23.getCell(4);
							if (R23cell1 != null) {
								String value = (BRF66.getR24_date_first() == null) ? "0"
										: BRF66.getR24_date_first().toString();
								R23cell1.setCellValue(value);
							}

							Cell R23cell2 = row23.getCell(5);
							if (R23cell2 != null) {
								R23cell2.setCellValue(BRF66.getR24_principal_amount() == null ? 0
										: BRF66.getR24_principal_amount().intValue());
							}
							Cell R23cell3 = row23.getCell(6);
							if (R23cell3 != null) {
								R23cell3.setCellValue(BRF66.getR24_original_year() == null ? 0
										: BRF66.getR24_original_year().intValue());
							}

							Cell R23cell4 = row23.getCell(7);
							if (R23cell4 != null) {
								R23cell4.setCellValue(
										BRF66.getR24_after_year() == null ? 0 : BRF66.getR24_after_year().intValue());
							}

							Cell R23cell6 = row23.getCell(8);
							if (R23cell6 != null) {
								R23cell6.setCellValue(BRF66.getR24_int_profit_pl() == null ? 0
										: BRF66.getR24_int_profit_pl().intValue());
							}

							Cell R23cell7 = row23.getCell(9);
							if (R23cell7 != null) {
								R23cell7.setCellValue(BRF66.getR24_int_profit_acc() == null ? 0
										: BRF66.getR24_int_profit_acc().intValue());
							}

							Cell R23cell8 = row23.getCell(10);
							if (R23cell8 != null) {
								R23cell8.setCellValue(BRF66.getR24_specific_provision() == null ? 0
										: BRF66.getR24_specific_provision().intValue());
							}

/////////////////////////////////////R25/////////////////////////////////////

							Row row24 = sheet.getRow(33);
							
							Cell R24cell0 = row24.getCell(2);
							if (R24cell0 != null) {
							String value = (BRF66.getR25_borrowers_name() == null) ? "0" : BRF66.getR25_borrowers_name().toString();
							R24cell0.setCellValue(value);
							}

							Cell R24cell = row24.getCell(3);
							if (R24cell != null) {
								String value = (BRF66.getR25_rating() == null) ? "0" : BRF66.getR25_rating().toString();
								R24cell.setCellValue(value);
							}
							Cell R24cell1 = row24.getCell(4);
							if (R24cell1 != null) {
								String value = (BRF66.getR25_date_first() == null) ? "0"
										: BRF66.getR25_date_first().toString();
								R24cell1.setCellValue(value);
							}

							Cell R24cell2 = row24.getCell(5);
							if (R24cell2 != null) {
								R24cell2.setCellValue(BRF66.getR25_principal_amount() == null ? 0
										: BRF66.getR25_principal_amount().intValue());
							}
							Cell R24cell3 = row24.getCell(6);
							if (R24cell3 != null) {
								R24cell3.setCellValue(BRF66.getR25_original_year() == null ? 0
										: BRF66.getR25_original_year().intValue());
							}

							Cell R24cell4 = row24.getCell(7);
							if (R24cell4 != null) {
								R24cell4.setCellValue(
										BRF66.getR25_after_year() == null ? 0 : BRF66.getR25_after_year().intValue());
							}

							Cell R24cell6 = row24.getCell(8);
							if (R24cell6 != null) {
								R24cell6.setCellValue(BRF66.getR25_int_profit_pl() == null ? 0
										: BRF66.getR25_int_profit_pl().intValue());
							}

							Cell R24cell7 = row24.getCell(9);
							if (R24cell7 != null) {
								R24cell7.setCellValue(BRF66.getR25_int_profit_acc() == null ? 0
										: BRF66.getR25_int_profit_acc().intValue());
							}

							Cell R24cell8 = row24.getCell(10);
							if (R24cell8 != null) {
								R24cell8.setCellValue(BRF66.getR25_specific_provision() == null ? 0
										: BRF66.getR25_specific_provision().intValue());
							}

/////////////////////////////////////R26/////////////////////////////////////

							Row row25 = sheet.getRow(34);
							
							Cell R25cell0 = row25.getCell(2);
							if (R25cell0 != null) {
							String value = (BRF66.getR26_borrowers_name() == null) ? "0" : BRF66.getR26_borrowers_name().toString();
							R25cell0.setCellValue(value);
							}

							Cell R25cell = row25.getCell(3);
							if (R25cell != null) {
								String value = (BRF66.getR26_rating() == null) ? "0" : BRF66.getR26_rating().toString();
								R25cell.setCellValue(value);
							}
							Cell R25cell1 = row25.getCell(4);
							if (R25cell1 != null) {
								String value = (BRF66.getR26_date_first() == null) ? "0"
										: BRF66.getR26_date_first().toString();
								R25cell1.setCellValue(value);
							}

							Cell R25cell2 = row25.getCell(5);
							if (R25cell2 != null) {
								R25cell2.setCellValue(BRF66.getR26_principal_amount() == null ? 0
										: BRF66.getR26_principal_amount().intValue());
							}
							Cell R25cell3 = row25.getCell(6);
							if (R25cell3 != null) {
								R25cell3.setCellValue(BRF66.getR26_original_year() == null ? 0
										: BRF66.getR26_original_year().intValue());
							}

							Cell R25cell4 = row25.getCell(7);
							if (R25cell4 != null) {
								R25cell4.setCellValue(
										BRF66.getR26_after_year() == null ? 0 : BRF66.getR26_after_year().intValue());
							}

							Cell R25cell6 = row25.getCell(8);
							if (R25cell6 != null) {
								R25cell6.setCellValue(BRF66.getR26_int_profit_pl() == null ? 0
										: BRF66.getR26_int_profit_pl().intValue());
							}

							Cell R25cell7 = row25.getCell(9);
							if (R25cell7 != null) {
								R25cell7.setCellValue(BRF66.getR26_int_profit_acc() == null ? 0
										: BRF66.getR26_int_profit_acc().intValue());
							}

							Cell R25cell8 = row25.getCell(10);
							if (R25cell8 != null) {
								R25cell8.setCellValue(BRF66.getR26_specific_provision() == null ? 0
										: BRF66.getR26_specific_provision().intValue());
							}

/////////////////////////////////////R27/////////////////////////////////////

							Row row26 = sheet.getRow(35);

							Cell R26cell0 = row26.getCell(2);
							if (R26cell0 != null) {
							String value = (BRF66.getR27_borrowers_name() == null) ? "0" : BRF66.getR27_borrowers_name().toString();
							R26cell0.setCellValue(value);
							}
							
							Cell R26cell = row26.getCell(3);
							if (R26cell != null) {
								String value = (BRF66.getR27_rating() == null) ? "0" : BRF66.getR27_rating().toString();
								R26cell.setCellValue(value);
							}
							Cell R26cell1 = row26.getCell(4);
							if (R26cell1 != null) {
								String value = (BRF66.getR27_date_first() == null) ? "0"
										: BRF66.getR27_date_first().toString();
								R26cell1.setCellValue(value);
							}

							Cell R26cell2 = row26.getCell(5);
							if (R26cell2 != null) {
								R26cell2.setCellValue(BRF66.getR27_principal_amount() == null ? 0
										: BRF66.getR27_principal_amount().intValue());
							}
							Cell R26cell3 = row26.getCell(6);
							if (R26cell3 != null) {
								R26cell3.setCellValue(BRF66.getR27_original_year() == null ? 0
										: BRF66.getR27_original_year().intValue());
							}

							Cell R26cell4 = row26.getCell(7);
							if (R26cell4 != null) {
								R26cell4.setCellValue(
										BRF66.getR27_after_year() == null ? 0 : BRF66.getR27_after_year().intValue());
							}

							Cell R26cell6 = row26.getCell(8);
							if (R26cell6 != null) {
								R26cell6.setCellValue(BRF66.getR27_int_profit_pl() == null ? 0
										: BRF66.getR27_int_profit_pl().intValue());
							}

							Cell R26cell7 = row26.getCell(9);
							if (R26cell7 != null) {
								R26cell7.setCellValue(BRF66.getR27_int_profit_acc() == null ? 0
										: BRF66.getR27_int_profit_acc().intValue());
							}

							Cell R26cell8 = row26.getCell(10);
							if (R26cell8 != null) {
								R26cell8.setCellValue(BRF66.getR27_specific_provision() == null ? 0
										: BRF66.getR27_specific_provision().intValue());
							}

/////////////////////////////////////R28/////////////////////////////////////

							Row row27 = sheet.getRow(36);
							
							Cell R27cell0 = row27.getCell(2);
							if (R27cell0 != null) {
							String value = (BRF66.getR28_borrowers_name() == null) ? "0" : BRF66.getR28_borrowers_name().toString();
							R27cell0.setCellValue(value);
							}

							Cell R27cell = row27.getCell(3);
							if (R27cell != null) {
								String value = (BRF66.getR28_rating() == null) ? "0" : BRF66.getR28_rating().toString();
								R27cell.setCellValue(value);
							}
							Cell R27cell1 = row27.getCell(4);
							if (R27cell1 != null) {
								String value = (BRF66.getR28_date_first() == null) ? "0"
										: BRF66.getR28_date_first().toString();
								R27cell1.setCellValue(value);
							}

							Cell R27cell2 = row27.getCell(5);
							if (R27cell2 != null) {
								R27cell2.setCellValue(BRF66.getR28_principal_amount() == null ? 0
										: BRF66.getR28_principal_amount().intValue());
							}
							Cell R27cell3 = row27.getCell(6);
							if (R27cell3 != null) {
								R27cell3.setCellValue(BRF66.getR28_original_year() == null ? 0
										: BRF66.getR28_original_year().intValue());
							}

							Cell R27cell4 = row27.getCell(7);
							if (R27cell4 != null) {
								R27cell4.setCellValue(
										BRF66.getR28_after_year() == null ? 0 : BRF66.getR28_after_year().intValue());
							}

							Cell R27cell6 = row27.getCell(8);
							if (R27cell6 != null) {
								R27cell6.setCellValue(BRF66.getR28_int_profit_pl() == null ? 0
										: BRF66.getR28_int_profit_pl().intValue());
							}

							Cell R27cell7 = row27.getCell(9);
							if (R27cell7 != null) {
								R27cell7.setCellValue(BRF66.getR28_int_profit_acc() == null ? 0
										: BRF66.getR28_int_profit_acc().intValue());
							}

							Cell R27cell8 = row27.getCell(10);
							if (R27cell8 != null) {
								R27cell8.setCellValue(BRF66.getR28_specific_provision() == null ? 0
										: BRF66.getR28_specific_provision().intValue());
							}

/////////////////////////////////////R29/////////////////////////////////////

							Row row28 = sheet.getRow(37);
							
							Cell R28cell0 = row28.getCell(2);
							if (R28cell0 != null) {
							String value = (BRF66.getR29_borrowers_name() == null) ? "0" : BRF66.getR29_borrowers_name().toString();
							R28cell0.setCellValue(value);
							}

							Cell R28cell = row28.getCell(3);
							if (R28cell != null) {
								String value = (BRF66.getR29_rating() == null) ? "0" : BRF66.getR29_rating().toString();
								R28cell.setCellValue(value);
							}
							Cell R28cell1 = row28.getCell(4);
							if (R28cell1 != null) {
								String value = (BRF66.getR29_date_first() == null) ? "0"
										: BRF66.getR29_date_first().toString();
								R28cell1.setCellValue(value);
							}

							Cell R28cell2 = row28.getCell(5);
							if (R28cell2 != null) {
								R28cell2.setCellValue(BRF66.getR29_principal_amount() == null ? 0
										: BRF66.getR29_principal_amount().intValue());
							}
							Cell R28cell3 = row28.getCell(6);
							if (R28cell3 != null) {
								R28cell3.setCellValue(BRF66.getR29_original_year() == null ? 0
										: BRF66.getR29_original_year().intValue());
							}

							Cell R28cell4 = row28.getCell(7);
							if (R28cell4 != null) {
								R28cell4.setCellValue(
										BRF66.getR29_after_year() == null ? 0 : BRF66.getR29_after_year().intValue());
							}

							Cell R28cell6 = row28.getCell(8);
							if (R28cell6 != null) {
								R28cell6.setCellValue(BRF66.getR29_int_profit_pl() == null ? 0
										: BRF66.getR29_int_profit_pl().intValue());
							}

							Cell R28cell7 = row28.getCell(9);
							if (R28cell7 != null) {
								R28cell7.setCellValue(BRF66.getR29_int_profit_acc() == null ? 0
										: BRF66.getR29_int_profit_acc().intValue());
							}

							Cell R28cell8 = row28.getCell(10);
							if (R28cell8 != null) {
								R28cell8.setCellValue(BRF66.getR29_specific_provision() == null ? 0
										: BRF66.getR29_specific_provision().intValue());
							}

/////////////////////////////////////R30/////////////////////////////////////

							Row row29 = sheet.getRow(38);
							
							Cell R29cell0 = row29.getCell(2);
							if (R29cell0 != null) {
							String value = (BRF66.getR30_borrowers_name() == null) ? "0" : BRF66.getR30_borrowers_name().toString();
							R29cell0.setCellValue(value);
							}

							Cell R29cell = row29.getCell(3);
							if (R29cell != null) {
								String value = (BRF66.getR30_rating() == null) ? "0" : BRF66.getR30_rating().toString();
								R29cell.setCellValue(value);
							}
							Cell R29cell1 = row29.getCell(4);
							if (R29cell1 != null) {
								String value = (BRF66.getR30_date_first() == null) ? "0"
										: BRF66.getR30_date_first().toString();
								R29cell1.setCellValue(value);
							}
							Cell R29cell2 = row29.getCell(5);
							if (R29cell2 != null) {
								R29cell2.setCellValue(BRF66.getR30_principal_amount() == null ? 0
										: BRF66.getR30_principal_amount().intValue());
							}
							Cell R29cell3 = row29.getCell(6);
							if (R29cell3 != null) {
								R29cell3.setCellValue(BRF66.getR30_original_year() == null ? 0
										: BRF66.getR30_original_year().intValue());
							}

							Cell R29cell4 = row29.getCell(7);
							if (R29cell4 != null) {
								R29cell4.setCellValue(
										BRF66.getR30_after_year() == null ? 0 : BRF66.getR30_after_year().intValue());
							}

							Cell R29cell6 = row29.getCell(8);
							if (R29cell6 != null) {
								R29cell6.setCellValue(BRF66.getR30_int_profit_pl() == null ? 0
										: BRF66.getR30_int_profit_pl().intValue());
							}

							Cell R29cell7 = row29.getCell(9);
							if (R29cell7 != null) {
								R29cell7.setCellValue(BRF66.getR30_int_profit_acc() == null ? 0
										: BRF66.getR30_int_profit_acc().intValue());
							}

							Cell R29cell8 = row29.getCell(10);
							if (R29cell8 != null) {
								R29cell8.setCellValue(BRF66.getR30_specific_provision() == null ? 0
										: BRF66.getR30_specific_provision().intValue());
							}

							
	//////////////////////////R32//////////////////////

							Row row30 = sheet.getRow(43);
							
							Cell R30cell0 = row30.getCell(2);
							if (R30cell0 != null) {
							String value = (BRF66.getR32_borrowers_name() == null) ? "0" : BRF66.getR32_borrowers_name().toString();
							R30cell0.setCellValue(value);
							}
							
							Cell R30cell = row30.getCell(3); if (R30cell != null) { String value =
							(BRF66.getR32_rating() == null) ? "0" : BRF66.getR32_rating().toString();
							R30cell.setCellValue(value); } 

							Cell R30cell1 = row30.getCell(4); if (R30cell1 != null) {
							String value = (BRF66.getR32_date_first() == null) ? "0" :
							BRF66.getR32_date_first().toString(); R30cell1.setCellValue(value); }


							Cell R30cell2 = row30.getCell(5); if (R30cell2 != null) {
							  R30cell2.setCellValue(BRF66.getR32_principal_amount() == null ? 0 :
							  BRF66.getR32_principal_amount().intValue()); }
							  
							Cell R30cell3 = row30.getCell(6); if (R30cell3 != null) {
							  R30cell3.setCellValue(BRF66.getR32_original_year() == null ? 0 :
							  BRF66.getR32_original_year().intValue()); }
							  

							Cell R30cell4 = row30.getCell(7); if (R30cell4 != null) {
							R30cell4.setCellValue(BRF66.getR32_after_year() == null ? 0 :
							BRF66.getR32_after_year().intValue()); }


							Cell R30cell5 = row30.getCell(8); if (R30cell5 != null) {
							R30cell5.setCellValue(BRF66.getR32_length_year() == null ? 0 :
							BRF66.getR32_length_year().intValue()); }

							Cell R30cell6 = row30.getCell(9); if (R30cell6 != null) {
							R30cell6.setCellValue(BRF66.getR32_int_profit_pl() == null ? 0 :
							BRF66.getR32_int_profit_pl().intValue()); }

							Cell R30cell7 = row30.getCell(10); if (R30cell7 != null) {
							R30cell7.setCellValue(BRF66.getR32_int_profit_acc() == null ? 0 :
							BRF66.getR32_int_profit_acc().intValue()); }

							Cell R30cell8 = row30.getCell(11); if (R30cell8 != null) {
							R30cell8.setCellValue(BRF66.getR32_specific_provision() == null ? 0 :
							BRF66.getR32_specific_provision().intValue()); }

							
	//////////////////////////R33//////////////////////

							Row row31 = sheet.getRow(44);
							
							Cell R31cell0 = row31.getCell(2);
							if (R31cell0 != null) {
							String value = (BRF66.getR33_borrowers_name() == null) ? "0" : BRF66.getR33_borrowers_name().toString();
							R31cell0.setCellValue(value);
							}
														  
							Cell R31cell = row31.getCell(3); if (R31cell != null) { String value =
							(BRF66.getR33_rating() == null) ? "0" : BRF66.getR33_rating().toString();
							R31cell.setCellValue(value); } 

							Cell R31cell1 = row31.getCell(4); if (R31cell1 != null) {
							String value = (BRF66.getR33_date_first() == null) ? "0" :
							BRF66.getR33_date_first().toString(); R31cell1.setCellValue(value); }


							Cell R31cell2 = row31.getCell(5); if (R31cell2 != null) {
							  R31cell2.setCellValue(BRF66.getR33_principal_amount() == null ? 0 :
							  BRF66.getR33_principal_amount().intValue()); }
							  
							Cell R31cell3 = row31.getCell(6); if (R31cell3 != null) {
							  R31cell3.setCellValue(BRF66.getR33_original_year() == null ? 0 :
							  BRF66.getR33_original_year().intValue()); }
							  

							Cell R31cell4 = row31.getCell(7); if (R31cell4 != null) {
							R31cell4.setCellValue(BRF66.getR33_after_year() == null ? 0 :
							BRF66.getR33_after_year().intValue()); }


							Cell R31cell5 = row31.getCell(8); if (R31cell5 != null) {
							R31cell5.setCellValue(BRF66.getR33_length_year() == null ? 0 :
							BRF66.getR33_length_year().intValue()); }

							Cell R31cell6 = row31.getCell(9); if (R31cell6 != null) {
							R31cell6.setCellValue(BRF66.getR33_int_profit_pl() == null ? 0 :
							BRF66.getR33_int_profit_pl().intValue()); }

							Cell R31cell7 = row31.getCell(10); if (R31cell7 != null) {
							R31cell7.setCellValue(BRF66.getR33_int_profit_acc() == null ? 0 :
							BRF66.getR33_int_profit_acc().intValue()); }

							Cell R31cell8 = row31.getCell(11); if (R31cell8 != null) {
							R31cell8.setCellValue(BRF66.getR33_specific_provision() == null ? 0 :
							BRF66.getR33_specific_provision().intValue()); }

							
							
							
	//////////////////////////R34//////////////////////

								Row row32 = sheet.getRow(45);
								
								Cell R32cell0 = row32.getCell(2);
								if (R32cell0 != null) {
								String value = (BRF66.getR34_borrowers_name() == null) ? "0" : 
									BRF66.getR34_borrowers_name().toString();
								R32cell0.setCellValue(value);
								}
															  
								Cell R32cell = row32.getCell(3); if (R32cell != null) { String value =
								(BRF66.getR34_rating() == null) ? "0" : BRF66.getR34_rating().toString();
								R32cell.setCellValue(value); } 

								Cell R32cell1 = row32.getCell(4); if (R32cell1 != null) {
								String value = (BRF66.getR34_date_first() == null) ? "0" :
								BRF66.getR34_date_first().toString(); R32cell1.setCellValue(value); }


								Cell R32cell2 = row32.getCell(5); if (R32cell2 != null) {
								  R32cell2.setCellValue(BRF66.getR34_principal_amount() == null ? 0 :
								  BRF66.getR34_principal_amount().intValue()); }
								  
								Cell R32cell3 = row32.getCell(6); if (R32cell3 != null) {
								  R32cell3.setCellValue(BRF66.getR34_original_year() == null ? 0 :
								  BRF66.getR34_original_year().intValue()); }
								  

								Cell R32cell4 = row32.getCell(7); if (R32cell4 != null) {
								R32cell4.setCellValue(BRF66.getR34_after_year() == null ? 0 :
								BRF66.getR34_after_year().intValue()); }


								Cell R32cell5 = row32.getCell(8); if (R32cell5 != null) {
								R32cell5.setCellValue(BRF66.getR34_length_year() == null ? 0 :
								BRF66.getR34_length_year().intValue()); }

								Cell R32cell6 = row32.getCell(9); if (R32cell6 != null) {
								R32cell6.setCellValue(BRF66.getR34_int_profit_pl() == null ? 0 :
								BRF66.getR34_int_profit_pl().intValue()); }

								Cell R32cell7 = row32.getCell(10); if (R32cell7 != null) {
								R32cell7.setCellValue(BRF66.getR34_int_profit_acc() == null ? 0 :
								BRF66.getR34_int_profit_acc().intValue()); }

								Cell R32cell8 = row32.getCell(11); if (R32cell8 != null) {
								R32cell8.setCellValue(BRF66.getR34_specific_provision() == null ? 0 :
								BRF66.getR34_specific_provision().intValue()); }

								
		//////////////////////////R35//////////////////////

								Row row33 = sheet.getRow(46);
								
								Cell R33cell0 = row33.getCell(2);
								if (R33cell0 != null) {
								String value = (BRF66.getR35_borrowers_name() == null) ? "0" : BRF66.getR35_borrowers_name().toString();
								R33cell0.setCellValue(value);
								}
															  
								Cell R33cell = row33.getCell(3); if (R33cell != null) { String value =
								(BRF66.getR35_rating() == null) ? "0" : BRF66.getR35_rating().toString();
								R33cell.setCellValue(value); } 

								Cell R33cell1 = row33.getCell(4); if (R33cell1 != null) {
								String value = (BRF66.getR35_date_first() == null) ? "0" :
								BRF66.getR35_date_first().toString(); R33cell1.setCellValue(value); }


								Cell R33cell2 = row33.getCell(5); if (R33cell2 != null) {
								  R33cell2.setCellValue(BRF66.getR35_principal_amount() == null ? 0 :
								  BRF66.getR35_principal_amount().intValue()); }
								  
								Cell R33cell3 = row33.getCell(6); if (R33cell3 != null) {
								  R33cell3.setCellValue(BRF66.getR35_original_year() == null ? 0 :
								  BRF66.getR35_original_year().intValue()); }
								  

								Cell R33cell4 = row33.getCell(7); if (R33cell4 != null) {
								R33cell4.setCellValue(BRF66.getR35_after_year() == null ? 0 :
								BRF66.getR35_after_year().intValue()); }


								Cell R33cell5 = row33.getCell(8); if (R33cell5 != null) {
								R33cell5.setCellValue(BRF66.getR35_length_year() == null ? 0 :
								BRF66.getR35_length_year().intValue()); }

								Cell R33cell6 = row33.getCell(9); if (R33cell6 != null) {
								R33cell6.setCellValue(BRF66.getR35_int_profit_pl() == null ? 0 :
								BRF66.getR35_int_profit_pl().intValue()); }

								Cell R33cell7 = row33.getCell(10); if (R33cell7 != null) {
								R33cell7.setCellValue(BRF66.getR35_int_profit_acc() == null ? 0 :
								BRF66.getR35_int_profit_acc().intValue()); }

								Cell R33cell8 = row33.getCell(11); if (R33cell8 != null) {
								R33cell8.setCellValue(BRF66.getR35_specific_provision() == null ? 0 :
								BRF66.getR35_specific_provision().intValue()); }

								
		//////////////////////////R36//////////////////////

								Row row34 = sheet.getRow(47);
								
								Cell R34cell0 = row34.getCell(2);
								if (R34cell0 != null) {
								String value = (BRF66.getR36_borrowers_name() == null) ? "0" : BRF66.getR36_borrowers_name().toString();
								R34cell0.setCellValue(value);
								}
								
								
								Cell R34cell = row34.getCell(3); if (R34cell != null) { String value =
								(BRF66.getR36_rating() == null) ? "0" : BRF66.getR36_rating().toString();
								R34cell.setCellValue(value); } 

								Cell R34cell1 = row34.getCell(4); if (R34cell1 != null) {
								String value = (BRF66.getR36_date_first() == null) ? "0" :
								BRF66.getR36_date_first().toString(); R34cell1.setCellValue(value); }


								Cell R34cell2 = row34.getCell(5); if (R34cell2 != null) {
								  R34cell2.setCellValue(BRF66.getR36_principal_amount() == null ? 0 :
								  BRF66.getR36_principal_amount().intValue()); }
								  
								Cell R34cell3 = row34.getCell(6); if (R34cell3 != null) {
								  R34cell3.setCellValue(BRF66.getR36_original_year() == null ? 0 :
								  BRF66.getR36_original_year().intValue()); }
								  

								Cell R34cell4 = row34.getCell(7); if (R34cell4 != null) {
								R34cell4.setCellValue(BRF66.getR36_after_year() == null ? 0 :
								BRF66.getR36_after_year().intValue()); }


								Cell R34cell5 = row34.getCell(8); if (R34cell5 != null) {
								R34cell5.setCellValue(BRF66.getR36_length_year() == null ? 0 :
								BRF66.getR36_length_year().intValue()); }

								Cell R34cell6 = row34.getCell(9); if (R34cell6 != null) {
								R34cell6.setCellValue(BRF66.getR36_int_profit_pl() == null ? 0 :
								BRF66.getR36_int_profit_pl().intValue()); }

								Cell R34cell7 = row34.getCell(10); if (R34cell7 != null) {
								R34cell7.setCellValue(BRF66.getR36_int_profit_acc() == null ? 0 :
								BRF66.getR36_int_profit_acc().intValue()); }

								Cell R34cell8 = row34.getCell(11); if (R34cell8 != null) {
								R34cell8.setCellValue(BRF66.getR36_specific_provision() == null ? 0 :
								BRF66.getR36_specific_provision().intValue()); }

								
		//////////////////////////R37//////////////////////

								Row row35 = sheet.getRow(48);
								
								Cell R35cell0 = row35.getCell(2);
								if (R35cell0 != null) {
								String value = (BRF66.getR37_borrowers_name() == null) ? "0" : BRF66.getR37_borrowers_name().toString();
								R35cell0.setCellValue(value);
								}
															  
								Cell R35cell = row35.getCell(3); if (R35cell != null) { String value =
								(BRF66.getR37_rating() == null) ? "0" : BRF66.getR37_rating().toString();
								R35cell.setCellValue(value); } 

								Cell R35cell1 = row35.getCell(4); if (R35cell1 != null) {
								String value = (BRF66.getR37_date_first() == null) ? "0" :
								BRF66.getR37_date_first().toString(); R35cell1.setCellValue(value); }


								Cell R35cell2 = row35.getCell(5); if (R35cell2 != null) {
								  R35cell2.setCellValue(BRF66.getR37_principal_amount() == null ? 0 :
								  BRF66.getR37_principal_amount().intValue()); }
								  
								Cell R35cell3 = row35.getCell(6); if (R35cell3 != null) {
								  R35cell3.setCellValue(BRF66.getR37_original_year() == null ? 0 :
								  BRF66.getR37_original_year().intValue()); }
								  

								Cell R35cell4 = row35.getCell(7); if (R35cell4 != null) {
								R35cell4.setCellValue(BRF66.getR37_after_year() == null ? 0 :
								BRF66.getR37_after_year().intValue()); }


								Cell R35cell5 = row35.getCell(8); if (R35cell5 != null) {
								R35cell5.setCellValue(BRF66.getR37_length_year() == null ? 0 :
								BRF66.getR37_length_year().intValue()); }

								Cell R35cell6 = row35.getCell(9); if (R35cell6 != null) {
								R35cell6.setCellValue(BRF66.getR37_int_profit_pl() == null ? 0 :
								BRF66.getR37_int_profit_pl().intValue()); }

								Cell R35cell7 = row35.getCell(10); if (R35cell7 != null) {
								R35cell7.setCellValue(BRF66.getR37_int_profit_acc() == null ? 0 :
								BRF66.getR37_int_profit_acc().intValue()); }

								Cell R35cell8 = row35.getCell(11); if (R35cell8 != null) {
								R35cell8.setCellValue(BRF66.getR37_specific_provision() == null ? 0 :
								BRF66.getR37_specific_provision().intValue()); }

								
		//////////////////////////R38//////////////////////

								Row row36 = sheet.getRow(49);
								
								Cell R36cell0 = row36.getCell(2);
								if (R36cell0 != null) {
								String value = (BRF66.getR38_borrowers_name() == null) ? "0" : BRF66.getR38_borrowers_name().toString();
								R36cell0.setCellValue(value);
								}
															  
								Cell R36cell = row36.getCell(3); if (R36cell != null) { String value =
								(BRF66.getR38_rating() == null) ? "0" : BRF66.getR38_rating().toString();
								R36cell.setCellValue(value); } 

								Cell R36cell1 = row36.getCell(4); if (R36cell1 != null) {
								String value = (BRF66.getR38_date_first() == null) ? "0" :
								BRF66.getR38_date_first().toString(); R36cell1.setCellValue(value); }


								Cell R36cell2 = row36.getCell(5); if (R36cell2 != null) {
								  R36cell2.setCellValue(BRF66.getR38_principal_amount() == null ? 0 :
								  BRF66.getR38_principal_amount().intValue()); }
								  
								Cell R36cell3 = row36.getCell(6); if (R36cell3 != null) {
								  R36cell3.setCellValue(BRF66.getR38_original_year() == null ? 0 :
								  BRF66.getR38_original_year().intValue()); }
								  

								Cell R36cell4 = row36.getCell(7); if (R36cell4 != null) {
								R36cell4.setCellValue(BRF66.getR38_after_year() == null ? 0 :
								BRF66.getR38_after_year().intValue()); }


								Cell R36cell5 = row36.getCell(8); if (R36cell5 != null) {
								R36cell5.setCellValue(BRF66.getR38_length_year() == null ? 0 :
								BRF66.getR38_length_year().intValue()); }

								Cell R36cell6 = row36.getCell(9); if (R36cell6 != null) {
								R36cell6.setCellValue(BRF66.getR38_int_profit_pl() == null ? 0 :
								BRF66.getR38_int_profit_pl().intValue()); }

								Cell R36cell7 = row36.getCell(10); if (R36cell7 != null) {
								R36cell7.setCellValue(BRF66.getR38_int_profit_acc() == null ? 0 :
								BRF66.getR38_int_profit_acc().intValue()); }

								Cell R36cell8 = row36.getCell(11); if (R36cell8 != null) {
								R36cell8.setCellValue(BRF66.getR38_specific_provision() == null ? 0 :
								BRF66.getR38_specific_provision().intValue()); }

								
		//////////////////////////R39//////////////////////

								Row row37 = sheet.getRow(50);
								Cell R37cell0 = row37.getCell(2);
								if (R37cell0 != null) {
								String value = (BRF66.getR39_borrowers_name() == null) ? "0" : BRF66.getR39_borrowers_name().toString();
								R37cell0.setCellValue(value);
								}
															  
								Cell R37cell = row37.getCell(3); if (R37cell != null) { String value =
								(BRF66.getR39_rating() == null) ? "0" : BRF66.getR39_rating().toString();
								R37cell.setCellValue(value); } 

								Cell R37cell1 = row37.getCell(4); if (R37cell1 != null) {
								String value = (BRF66.getR39_date_first() == null) ? "0" :
								BRF66.getR39_date_first().toString(); R37cell1.setCellValue(value); }


								Cell R37cell2 = row37.getCell(5); if (R37cell2 != null) {
								  R37cell2.setCellValue(BRF66.getR39_principal_amount() == null ? 0 :
								  BRF66.getR39_principal_amount().intValue()); }
								  
								Cell R37cell3 = row37.getCell(6); if (R37cell3 != null) {
								  R37cell3.setCellValue(BRF66.getR39_original_year() == null ? 0 :
								  BRF66.getR39_original_year().intValue()); }
								  

								Cell R37cell4 = row37.getCell(7); if (R37cell4 != null) {
								R37cell4.setCellValue(BRF66.getR39_after_year() == null ? 0 :
								BRF66.getR39_after_year().intValue()); }


								Cell R37cell5 = row37.getCell(8); if (R37cell5 != null) {
								R37cell5.setCellValue(BRF66.getR39_length_year() == null ? 0 :
								BRF66.getR39_length_year().intValue()); }

								Cell R37cell6 = row37.getCell(9); if (R37cell6 != null) {
								R37cell6.setCellValue(BRF66.getR39_int_profit_pl() == null ? 0 :
								BRF66.getR39_int_profit_pl().intValue()); }

								Cell R37cell7 = row37.getCell(10); if (R37cell7 != null) {
								R37cell7.setCellValue(BRF66.getR39_int_profit_acc() == null ? 0 :
								BRF66.getR39_int_profit_acc().intValue()); }

								Cell R37cell8 = row37.getCell(11); if (R37cell8 != null) {
								R37cell8.setCellValue(BRF66.getR39_specific_provision() == null ? 0 :
								BRF66.getR39_specific_provision().intValue()); }

								
		//////////////////////////R40//////////////////////

								Row row38 = sheet.getRow(51);
								
								Cell R38cell0 = row38.getCell(2);
								if (R38cell0 != null) {
								String value = (BRF66.getR40_borrowers_name() == null) ? "0" : BRF66.getR40_borrowers_name().toString();
								R38cell0.setCellValue(value);
								}
															  
								Cell R38cell = row38.getCell(3); if (R38cell != null) { String value =
								(BRF66.getR40_rating() == null) ? "0" : BRF66.getR40_rating().toString();
								R38cell.setCellValue(value); } 

								Cell R38cell1 = row38.getCell(4); if (R38cell1 != null) {
								String value = (BRF66.getR40_date_first() == null) ? "0" :
								BRF66.getR40_date_first().toString(); R38cell1.setCellValue(value); }


								Cell R38cell2 = row38.getCell(5); if (R38cell2 != null) {
								  R38cell2.setCellValue(BRF66.getR40_principal_amount() == null ? 0 :
								  BRF66.getR40_principal_amount().intValue()); }
								  
								Cell R38cell3 = row38.getCell(6); if (R38cell3 != null) {
								  R38cell3.setCellValue(BRF66.getR40_original_year() == null ? 0 :
								  BRF66.getR40_original_year().intValue()); }
								  

								Cell R38cell4 = row38.getCell(7); if (R38cell4 != null) {
								R38cell4.setCellValue(BRF66.getR40_after_year() == null ? 0 :
								BRF66.getR40_after_year().intValue()); }


								Cell R38cell5 = row38.getCell(8); if (R38cell5 != null) {
								R38cell5.setCellValue(BRF66.getR40_length_year() == null ? 0 :
								BRF66.getR40_length_year().intValue()); }

								Cell R38cell6 = row38.getCell(9); if (R38cell6 != null) {
								R38cell6.setCellValue(BRF66.getR40_int_profit_pl() == null ? 0 :
								BRF66.getR40_int_profit_pl().intValue()); }

								Cell R38cell7 = row38.getCell(10); if (R38cell7 != null) {
								R38cell7.setCellValue(BRF66.getR40_int_profit_acc() == null ? 0 :
								BRF66.getR40_int_profit_acc().intValue()); }

								Cell R38cell8 = row38.getCell(11); if (R38cell8 != null) {
								R38cell8.setCellValue(BRF66.getR40_specific_provision() == null ? 0 :
								BRF66.getR40_specific_provision().intValue()); }

								
		//////////////////////////R41//////////////////////

								Row row39 = sheet.getRow(52);
								Cell R39cell0 = row39.getCell(2);
								if (R39cell0 != null) {
								String value = (BRF66.getR41_borrowers_name() == null) ? "0" : BRF66.getR41_borrowers_name().toString();
								R39cell0.setCellValue(value);
								}
															  
								Cell R39cell = row39.getCell(3); if (R39cell != null) { String value =
								(BRF66.getR41_rating() == null) ? "0" : BRF66.getR41_rating().toString();
								R39cell.setCellValue(value); } 

								Cell R39cell1 = row39.getCell(4); if (R39cell1 != null) {
								String value = (BRF66.getR41_date_first() == null) ? "0" :
								BRF66.getR41_date_first().toString(); R39cell1.setCellValue(value); }


								Cell R39cell2 = row39.getCell(5); if (R39cell2 != null) {
								  R39cell2.setCellValue(BRF66.getR41_principal_amount() == null ? 0 :
								  BRF66.getR41_principal_amount().intValue()); }
								  
								Cell R39cell3 = row39.getCell(6); if (R39cell3 != null) {
								  R39cell3.setCellValue(BRF66.getR41_original_year() == null ? 0 :
								  BRF66.getR41_original_year().intValue()); }
								  

								Cell R39cell4 = row39.getCell(7); if (R39cell4 != null) {
								R39cell4.setCellValue(BRF66.getR41_after_year() == null ? 0 :
								BRF66.getR41_after_year().intValue()); }


								Cell R39cell5 = row39.getCell(8); if (R39cell5 != null) {
								R39cell5.setCellValue(BRF66.getR41_length_year() == null ? 0 :
								BRF66.getR41_length_year().intValue()); }

								Cell R39cell6 = row39.getCell(9); if (R39cell6 != null) {
								R39cell6.setCellValue(BRF66.getR41_int_profit_pl() == null ? 0 :
								BRF66.getR41_int_profit_pl().intValue()); }

								Cell R39cell7 = row39.getCell(10); if (R39cell7 != null) {
								R39cell7.setCellValue(BRF66.getR41_int_profit_acc() == null ? 0 :
								BRF66.getR41_int_profit_acc().intValue()); }

								Cell R39cell8 = row39.getCell(11); if (R39cell8 != null) {
								R39cell8.setCellValue(BRF66.getR41_specific_provision() == null ? 0 :
								BRF66.getR41_specific_provision().intValue()); }

								
		//////////////////////////R42//////////////////////

								Row row40 = sheet.getRow(53);
								
								Cell R40cell0 = row40.getCell(2);
								if (R40cell0 != null) {
								String value = (BRF66.getR42_borrowers_name() == null) ? "0" : BRF66.getR42_borrowers_name().toString();
								R40cell0.setCellValue(value);
								}
															  
								Cell R40cell = row40.getCell(3); if (R40cell != null) { String value =
								(BRF66.getR42_rating() == null) ? "0" : BRF66.getR42_rating().toString();
								R40cell.setCellValue(value); } 

								Cell R40cell1 = row40.getCell(4); if (R40cell1 != null) {
								String value = (BRF66.getR42_date_first() == null) ? "0" :
								BRF66.getR42_date_first().toString(); R40cell1.setCellValue(value); }


								Cell R40cell2 = row40.getCell(5); if (R40cell2 != null) {
								  R40cell2.setCellValue(BRF66.getR42_principal_amount() == null ? 0 :
								  BRF66.getR42_principal_amount().intValue()); }
								  
								Cell R40cell3 = row40.getCell(6); if (R40cell3 != null) {
								  R40cell3.setCellValue(BRF66.getR42_original_year() == null ? 0 :
								  BRF66.getR42_original_year().intValue()); }
								  

								Cell R40cell4 = row40.getCell(7); if (R40cell4 != null) {
								R40cell4.setCellValue(BRF66.getR42_after_year() == null ? 0 :
								BRF66.getR42_after_year().intValue()); }


								Cell R40cell5 = row40.getCell(8); if (R40cell5 != null) {
								R40cell5.setCellValue(BRF66.getR42_length_year() == null ? 0 :
								BRF66.getR42_length_year().intValue()); }

								Cell R40cell6 = row40.getCell(9); if (R40cell6 != null) {
								R40cell6.setCellValue(BRF66.getR42_int_profit_pl() == null ? 0 :
								BRF66.getR42_int_profit_pl().intValue()); }

								Cell R40cell7 = row40.getCell(10); if (R40cell7 != null) {
								R40cell7.setCellValue(BRF66.getR42_int_profit_acc() == null ? 0 :
								BRF66.getR42_int_profit_acc().intValue()); }

								Cell R40cell8 = row40.getCell(11); if (R40cell8 != null) {
								R40cell8.setCellValue(BRF66.getR42_specific_provision() == null ? 0 :
								BRF66.getR42_specific_provision().intValue()); }

								
								
		//////////////////////////R43//////////////////////

								Row row41 = sheet.getRow(54);
								
								Cell R41cell0 = row41.getCell(2);
								if (R41cell0 != null) {
								String value = (BRF66.getR43_borrowers_name() == null) ? "0" : BRF66.getR43_borrowers_name().toString();
								R41cell0.setCellValue(value);
								}
															  
								Cell R41cell = row41.getCell(3); if (R41cell != null) { String value =
								(BRF66.getR43_rating() == null) ? "0" : BRF66.getR43_rating().toString();
								R41cell.setCellValue(value); } 

								Cell R41cell1 = row41.getCell(4); if (R41cell1 != null) {
								String value = (BRF66.getR43_date_first() == null) ? "0" :
								BRF66.getR43_date_first().toString(); R41cell1.setCellValue(value); }


								Cell R41cell2 = row41.getCell(5); if (R41cell2 != null) {
								  R41cell2.setCellValue(BRF66.getR43_principal_amount() == null ? 0 :
								  BRF66.getR43_principal_amount().intValue()); }
								  
								Cell R41cell3 = row41.getCell(6); if (R41cell3 != null) {
								  R41cell3.setCellValue(BRF66.getR43_original_year() == null ? 0 :
								  BRF66.getR43_original_year().intValue()); }
								  

								Cell R41cell4 = row41.getCell(7); if (R41cell4 != null) {
								R41cell4.setCellValue(BRF66.getR43_after_year() == null ? 0 :
								BRF66.getR43_after_year().intValue()); }


								Cell R41cell5 = row41.getCell(8); if (R41cell5 != null) {
								R41cell5.setCellValue(BRF66.getR43_length_year() == null ? 0 :
								BRF66.getR43_length_year().intValue()); }

								Cell R41cell6 = row41.getCell(9); if (R41cell6 != null) {
								R41cell6.setCellValue(BRF66.getR43_int_profit_pl() == null ? 0 :
								BRF66.getR43_int_profit_pl().intValue()); }

								Cell R41cell7 = row41.getCell(10); if (R41cell7 != null) {
								R41cell7.setCellValue(BRF66.getR43_int_profit_acc() == null ? 0 :
								BRF66.getR43_int_profit_acc().intValue()); }

								Cell R41cell8 = row41.getCell(11); if (R41cell8 != null) {
								R41cell8.setCellValue(BRF66.getR43_specific_provision() == null ? 0 :
								BRF66.getR43_specific_provision().intValue()); }

								
		//////////////////////////R44//////////////////////

								Row row42 = sheet.getRow(55);
								
								Cell R42cell0 = row42.getCell(2);
								if (R42cell0 != null) {
								String value = (BRF66.getR44_borrowers_name() == null) ? "0" : BRF66.getR44_borrowers_name().toString();
								R42cell0.setCellValue(value);
								}
															  
								Cell R42cell = row42.getCell(3); if (R42cell != null) { String value =
								(BRF66.getR44_rating() == null) ? "0" : BRF66.getR44_rating().toString();
								R42cell.setCellValue(value); } 

								Cell R42cell1 = row42.getCell(4); if (R42cell1 != null) {
								String value = (BRF66.getR44_date_first() == null) ? "0" :
								BRF66.getR44_date_first().toString(); R42cell1.setCellValue(value); }


								Cell R42cell2 = row42.getCell(5); if (R42cell2 != null) {
								  R42cell2.setCellValue(BRF66.getR44_principal_amount() == null ? 0 :
								  BRF66.getR44_principal_amount().intValue()); }
								  
								Cell R42cell3 = row42.getCell(6); if (R42cell3 != null) {
								  R42cell3.setCellValue(BRF66.getR44_original_year() == null ? 0 :
								  BRF66.getR44_original_year().intValue()); }
								  

								Cell R42cell4 = row42.getCell(7); if (R42cell4 != null) {
								R42cell4.setCellValue(BRF66.getR44_after_year() == null ? 0 :
								BRF66.getR44_after_year().intValue()); }


								Cell R42cell5 = row42.getCell(8); if (R42cell5 != null) {
								R42cell5.setCellValue(BRF66.getR44_length_year() == null ? 0 :
								BRF66.getR44_length_year().intValue()); }

								Cell R42cell6 = row42.getCell(9); if (R42cell6 != null) {
								R42cell6.setCellValue(BRF66.getR44_int_profit_pl() == null ? 0 :
								BRF66.getR44_int_profit_pl().intValue()); }

								Cell R42cell7 = row42.getCell(10); if (R42cell7 != null) {
								R42cell7.setCellValue(BRF66.getR44_int_profit_acc() == null ? 0 :
								BRF66.getR44_int_profit_acc().intValue()); }

								Cell R42cell8 = row42.getCell(11); if (R42cell8 != null) {
								R42cell8.setCellValue(BRF66.getR44_specific_provision() == null ? 0 :
								BRF66.getR44_specific_provision().intValue()); }

								
		//////////////////////////R45//////////////////////

								Row row43 = sheet.getRow(56);
															  
								Cell R43cell0 = row43.getCell(2);
								if (R43cell0 != null) {
								String value = (BRF66.getR45_borrowers_name() == null) ? "0" : BRF66.getR45_borrowers_name().toString();
								R43cell0.setCellValue(value);
								}
								
								Cell R43cell = row43.getCell(3); if (R43cell != null) { String value =
								(BRF66.getR45_rating() == null) ? "0" : BRF66.getR45_rating().toString();
								R43cell.setCellValue(value); } 

								Cell R43cell1 = row43.getCell(4); if (R43cell1 != null) {
								String value = (BRF66.getR45_date_first() == null) ? "0" :
								BRF66.getR45_date_first().toString(); R43cell1.setCellValue(value); }


								Cell R43cell2 = row43.getCell(5); if (R43cell2 != null) {
								  R43cell2.setCellValue(BRF66.getR45_principal_amount() == null ? 0 :
								  BRF66.getR45_principal_amount().intValue()); }
								  
								Cell R43cell3 = row43.getCell(6); if (R43cell3 != null) {
								  R43cell3.setCellValue(BRF66.getR45_original_year() == null ? 0 :
								  BRF66.getR45_original_year().intValue()); }
								  

								Cell R43cell4 = row43.getCell(7); if (R43cell4 != null) {
								R43cell4.setCellValue(BRF66.getR45_after_year() == null ? 0 :
								BRF66.getR45_after_year().intValue()); }


								Cell R43cell5 = row43.getCell(8); if (R43cell5 != null) {
								R43cell5.setCellValue(BRF66.getR45_length_year() == null ? 0 :
								BRF66.getR45_length_year().intValue()); }

								Cell R43cell6 = row43.getCell(9); if (R43cell6 != null) {
								R43cell6.setCellValue(BRF66.getR45_int_profit_pl() == null ? 0 :
								BRF66.getR45_int_profit_pl().intValue()); }

								Cell R43cell7 = row43.getCell(10); if (R43cell7 != null) {
								R43cell7.setCellValue(BRF66.getR45_int_profit_acc() == null ? 0 :
								BRF66.getR45_int_profit_acc().intValue()); }

								Cell R43cell8 = row43.getCell(11); if (R43cell8 != null) {
								R43cell8.setCellValue(BRF66.getR45_specific_provision() == null ? 0 :
								BRF66.getR45_specific_provision().intValue()); }

								
		//////////////////////////R46//////////////////////

								Row row44 = sheet.getRow(57);
															  
								Cell R44cell0 = row44.getCell(2);
								if (R44cell0 != null) {
								String value = (BRF66.getR46_borrowers_name() == null) ? "0" : BRF66.getR46_borrowers_name().toString();
								R44cell0.setCellValue(value);
								}
								
								Cell R44cell = row44.getCell(3); if (R44cell != null) { String value =
								(BRF66.getR46_rating() == null) ? "0" : BRF66.getR46_rating().toString();
								R44cell.setCellValue(value); } 

								Cell R44cell1 = row44.getCell(4); if (R44cell1 != null) {
								String value = (BRF66.getR46_date_first() == null) ? "0" :
								BRF66.getR46_date_first().toString(); R44cell1.setCellValue(value); }


								Cell R44cell2 = row44.getCell(5); if (R44cell2 != null) {
								  R44cell2.setCellValue(BRF66.getR46_principal_amount() == null ? 0 :
								  BRF66.getR46_principal_amount().intValue()); }
								  
								Cell R44cell3 = row44.getCell(6); if (R44cell3 != null) {
								  R44cell3.setCellValue(BRF66.getR46_original_year() == null ? 0 :
								  BRF66.getR46_original_year().intValue()); }
								  

								Cell R44cell4 = row44.getCell(7); if (R44cell4 != null) {
								R44cell4.setCellValue(BRF66.getR46_after_year() == null ? 0 :
								BRF66.getR46_after_year().intValue()); }


								Cell R44cell5 = row44.getCell(8); if (R44cell5 != null) {
								R44cell5.setCellValue(BRF66.getR46_length_year() == null ? 0 :
								BRF66.getR46_length_year().intValue()); }

								Cell R44cell6 = row44.getCell(9); if (R44cell6 != null) {
								R44cell6.setCellValue(BRF66.getR46_int_profit_pl() == null ? 0 :
								BRF66.getR46_int_profit_pl().intValue()); }

								Cell R44cell7 = row44.getCell(10); if (R44cell7 != null) {
								R44cell7.setCellValue(BRF66.getR46_int_profit_acc() == null ? 0 :
								BRF66.getR46_int_profit_acc().intValue()); }

								Cell R44cell8 = row44.getCell(11); if (R44cell8 != null) {
								R44cell8.setCellValue(BRF66.getR46_specific_provision() == null ? 0 :
								BRF66.getR46_specific_provision().intValue()); }

								
		//////////////////////////R47//////////////////////

								Row row45 = sheet.getRow(58);
								
								Cell R45cell0 = row45.getCell(2);
								if (R45cell0 != null) {
								String value = (BRF66.getR47_borrowers_name() == null) ? "0" : BRF66.getR47_borrowers_name().toString();
								R45cell0.setCellValue(value);
								}
															  
								Cell R45cell = row45.getCell(3); if (R45cell != null) { String value =
								(BRF66.getR47_rating() == null) ? "0" : BRF66.getR47_rating().toString();
								R45cell.setCellValue(value); } 

								Cell R45cell1 = row45.getCell(4); if (R45cell1 != null) {
								String value = (BRF66.getR47_date_first() == null) ? "0" :
								BRF66.getR47_date_first().toString(); R45cell1.setCellValue(value); }


								Cell R45cell2 = row45.getCell(5); if (R45cell2 != null) {
								  R45cell2.setCellValue(BRF66.getR47_principal_amount() == null ? 0 :
								  BRF66.getR47_principal_amount().intValue()); }
								  
								Cell R45cell3 = row45.getCell(6); if (R45cell3 != null) {
								  R45cell3.setCellValue(BRF66.getR47_original_year() == null ? 0 :
								  BRF66.getR47_original_year().intValue()); }
								  

								Cell R45cell4 = row45.getCell(7); if (R45cell4 != null) {
								R45cell4.setCellValue(BRF66.getR47_after_year() == null ? 0 :
								BRF66.getR47_after_year().intValue()); }


								Cell R45cell5 = row45.getCell(8); if (R45cell5 != null) {
								R45cell5.setCellValue(BRF66.getR47_length_year() == null ? 0 :
								BRF66.getR47_length_year().intValue()); }

								Cell R45cell6 = row45.getCell(9); if (R45cell6 != null) {
								R45cell6.setCellValue(BRF66.getR47_int_profit_pl() == null ? 0 :
								BRF66.getR47_int_profit_pl().intValue()); }

								Cell R45cell7 = row45.getCell(10); if (R45cell7 != null) {
								R45cell7.setCellValue(BRF66.getR47_int_profit_acc() == null ? 0 :
								BRF66.getR47_int_profit_acc().intValue()); }

								Cell R45cell8 = row45.getCell(11); if (R45cell8 != null) {
								R45cell8.setCellValue(BRF66.getR47_specific_provision() == null ? 0 :
								BRF66.getR47_specific_provision().intValue()); }

								
								
		//////////////////////////R48//////////////////////

										Row row46 = sheet.getRow(59);
										
										Cell R46cell0 = row46.getCell(2);
										if (R46cell0 != null) {
										String value = (BRF66.getR48_borrowers_name() == null) ? "0" : BRF66.getR48_borrowers_name().toString();
										R46cell0.setCellValue(value);
										}
																	  
										Cell R46cell = row46.getCell(3); if (R46cell != null) { String value =
										(BRF66.getR48_rating() == null) ? "0" : BRF66.getR48_rating().toString();
										R46cell.setCellValue(value); } 

										Cell R46cell1 = row46.getCell(4); if (R46cell1 != null) {
										String value = (BRF66.getR48_date_first() == null) ? "0" :
										BRF66.getR48_date_first().toString(); R46cell1.setCellValue(value); }


										Cell R46cell2 = row46.getCell(5); if (R46cell2 != null) {
										  R46cell2.setCellValue(BRF66.getR48_principal_amount() == null ? 0 :
										  BRF66.getR48_principal_amount().intValue()); }
										  
										Cell R46cell3 = row46.getCell(6); if (R46cell3 != null) {
										  R46cell3.setCellValue(BRF66.getR48_original_year() == null ? 0 :
										  BRF66.getR48_original_year().intValue()); }
										  

										Cell R46cell4 = row46.getCell(7); if (R46cell4 != null) {
										R46cell4.setCellValue(BRF66.getR48_after_year() == null ? 0 :
										BRF66.getR48_after_year().intValue()); }


										Cell R46cell5 = row46.getCell(8); if (R46cell5 != null) {
										R46cell5.setCellValue(BRF66.getR48_length_year() == null ? 0 :
										BRF66.getR48_length_year().intValue()); }

										Cell R46cell6 = row46.getCell(9); if (R46cell6 != null) {
										R46cell6.setCellValue(BRF66.getR48_int_profit_pl() == null ? 0 :
										BRF66.getR48_int_profit_pl().intValue()); }

										Cell R46cell7 = row46.getCell(10); if (R46cell7 != null) {
										R46cell7.setCellValue(BRF66.getR48_int_profit_acc() == null ? 0 :
										BRF66.getR48_int_profit_acc().intValue()); }

										Cell R46cell8 = row46.getCell(11); if (R46cell8 != null) {
										R46cell8.setCellValue(BRF66.getR48_specific_provision() == null ? 0 :
										BRF66.getR48_specific_provision().intValue()); }

										
				//////////////////////////R49//////////////////////

										Row row47 = sheet.getRow(60);
										
										Cell R47cell0 = row47.getCell(2);
										if (R47cell0 != null) {
										String value = (BRF66.getR49_borrowers_name() == null) ? "0" : BRF66.getR49_borrowers_name().toString();
										R47cell0.setCellValue(value);
										}
																	  
										Cell R47cell = row47.getCell(3); if (R47cell != null) { String value =
										(BRF66.getR49_rating() == null) ? "0" : BRF66.getR49_rating().toString();
										R47cell.setCellValue(value); } 

										Cell R47cell1 = row47.getCell(4); if (R47cell1 != null) {
										String value = (BRF66.getR49_date_first() == null) ? "0" :
										BRF66.getR49_date_first().toString(); R47cell1.setCellValue(value); }


										Cell R47cell2 = row47.getCell(5); if (R47cell2 != null) {
										  R47cell2.setCellValue(BRF66.getR49_principal_amount() == null ? 0 :
										  BRF66.getR49_principal_amount().intValue()); }
										  
										Cell R47cell3 = row47.getCell(6); if (R47cell3 != null) {
										  R47cell3.setCellValue(BRF66.getR49_original_year() == null ? 0 :
										  BRF66.getR49_original_year().intValue()); }
										  

										Cell R47cell4 = row47.getCell(7); if (R47cell4 != null) {
										R47cell4.setCellValue(BRF66.getR49_after_year() == null ? 0 :
										BRF66.getR49_after_year().intValue()); }


										Cell R47cell5 = row47.getCell(8); if (R47cell5 != null) {
										R47cell5.setCellValue(BRF66.getR49_length_year() == null ? 0 :
										BRF66.getR49_length_year().intValue()); }

										Cell R47cell6 = row47.getCell(9); if (R47cell6 != null) {
										R47cell6.setCellValue(BRF66.getR49_int_profit_pl() == null ? 0 :
										BRF66.getR49_int_profit_pl().intValue()); }

										Cell R47cell7 = row47.getCell(10); if (R47cell7 != null) {
										R47cell7.setCellValue(BRF66.getR49_int_profit_acc() == null ? 0 :
										BRF66.getR49_int_profit_acc().intValue()); }

										Cell R47cell8 = row47.getCell(11); if (R47cell8 != null) {
										R47cell8.setCellValue(BRF66.getR49_specific_provision() == null ? 0 :
										BRF66.getR49_specific_provision().intValue()); }

										
				//////////////////////////R50//////////////////////

										Row row48 = sheet.getRow(61);
										
										Cell R48cell0 = row48.getCell(2);
										if (R48cell0 != null) {
										String value = (BRF66.getR50_borrowers_name() == null) ? "0" : BRF66.getR50_borrowers_name().toString();
										R48cell0.setCellValue(value);
										}
																	  
										Cell R48cell = row48.getCell(3); if (R48cell != null) { String value =
										(BRF66.getR50_rating() == null) ? "0" : BRF66.getR50_rating().toString();
										R48cell.setCellValue(value); } 

										Cell R48cell1 = row48.getCell(4); if (R48cell1 != null) {
										String value = (BRF66.getR50_date_first() == null) ? "0" :
										BRF66.getR50_date_first().toString(); R48cell1.setCellValue(value); }


										Cell R48cell2 = row48.getCell(5); if (R48cell2 != null) {
										  R48cell2.setCellValue(BRF66.getR50_principal_amount() == null ? 0 :
										  BRF66.getR50_principal_amount().intValue()); }
										  
										Cell R48cell3 = row48.getCell(6); if (R48cell3 != null) {
										  R48cell3.setCellValue(BRF66.getR50_original_year() == null ? 0 :
										  BRF66.getR50_original_year().intValue()); }
										  

										Cell R48cell4 = row48.getCell(7); if (R48cell4 != null) {
										R48cell4.setCellValue(BRF66.getR50_after_year() == null ? 0 :
										BRF66.getR50_after_year().intValue()); }


										Cell R48cell5 = row48.getCell(8); if (R48cell5 != null) {
										R48cell5.setCellValue(BRF66.getR50_length_year() == null ? 0 :
										BRF66.getR50_length_year().intValue()); }

										Cell R48cell6 = row48.getCell(9); if (R48cell6 != null) {
										R48cell6.setCellValue(BRF66.getR50_int_profit_pl() == null ? 0 :
										BRF66.getR50_int_profit_pl().intValue()); }

										Cell R48cell7 = row48.getCell(10); if (R48cell7 != null) {
										R48cell7.setCellValue(BRF66.getR50_int_profit_acc() == null ? 0 :
										BRF66.getR50_int_profit_acc().intValue()); }

										Cell R48cell8 = row48.getCell(11); if (R48cell8 != null) {
										R48cell8.setCellValue(BRF66.getR50_specific_provision() == null ? 0 :
										BRF66.getR50_specific_provision().intValue()); }

										
				//////////////////////////R51//////////////////////

										Row row49 = sheet.getRow(62);
																	  
										Cell R49cell0 = row49.getCell(2);
										if (R49cell0 != null) {
										String value = (BRF66.getR51_borrowers_name() == null) ? "0" : BRF66.getR51_borrowers_name().toString();
										R49cell0.setCellValue(value);
										}
										
										Cell R49cell = row49.getCell(3); if (R49cell != null) { String value =
										(BRF66.getR51_rating() == null) ? "0" : BRF66.getR51_rating().toString();
										R49cell.setCellValue(value); } 

										Cell R49cell1 = row49.getCell(4); if (R49cell1 != null) {
										String value = (BRF66.getR51_date_first() == null) ? "0" :
										BRF66.getR51_date_first().toString(); R49cell1.setCellValue(value); }


										Cell R49cell2 = row49.getCell(5); if (R49cell2 != null) {
										  R49cell2.setCellValue(BRF66.getR51_principal_amount() == null ? 0 :
										  BRF66.getR51_principal_amount().intValue()); }
										  
										Cell R49cell3 = row49.getCell(6); if (R49cell3 != null) {
										  R49cell3.setCellValue(BRF66.getR51_original_year() == null ? 0 :
										  BRF66.getR51_original_year().intValue()); }
										  

										Cell R49cell4 = row49.getCell(7); if (R49cell4 != null) {
										R49cell4.setCellValue(BRF66.getR51_after_year() == null ? 0 :
										BRF66.getR51_after_year().intValue()); }


										Cell R49cell5 = row49.getCell(8); if (R49cell5 != null) {
										R49cell5.setCellValue(BRF66.getR51_length_year() == null ? 0 :
										BRF66.getR51_length_year().intValue()); }

										Cell R49cell6 = row49.getCell(9); if (R49cell6 != null) {
										R49cell6.setCellValue(BRF66.getR51_int_profit_pl() == null ? 0 :
										BRF66.getR51_int_profit_pl().intValue()); }

										Cell R49cell7 = row49.getCell(10); if (R49cell7 != null) {
										R49cell7.setCellValue(BRF66.getR51_int_profit_acc() == null ? 0 :
										BRF66.getR51_int_profit_acc().intValue()); }

										Cell R49cell8 = row49.getCell(11); if (R49cell8 != null) {
										R49cell8.setCellValue(BRF66.getR51_specific_provision() == null ? 0 :
										BRF66.getR51_specific_provision().intValue()); }

							
				//////////////////////////R52//////////////////////

										Row row50 = sheet.getRow(63);
																	  
										Cell R50cell0 = row50.getCell(2);
										if (R50cell0 != null) {
										String value = (BRF66.getR52_borrowers_name() == null) ? "0" : BRF66.getR52_borrowers_name().toString();
										R50cell0.setCellValue(value);
										}
										
										Cell R50cell = row50.getCell(3); if (R50cell != null) { String value =
										(BRF66.getR52_rating() == null) ? "0" : BRF66.getR52_rating().toString();
										R50cell.setCellValue(value); } 

										Cell R50cell1 = row50.getCell(4); if (R50cell1 != null) {
										String value = (BRF66.getR52_date_first() == null) ? "0" :
										BRF66.getR52_date_first().toString(); R50cell1.setCellValue(value); }


										Cell R50cell2 = row50.getCell(5); if (R50cell2 != null) {
										  R50cell2.setCellValue(BRF66.getR52_principal_amount() == null ? 0 :
										  BRF66.getR52_principal_amount().intValue()); }
										  
										Cell R50cell3 = row50.getCell(6); if (R50cell3 != null) {
										  R50cell3.setCellValue(BRF66.getR52_original_year() == null ? 0 :
										  BRF66.getR52_original_year().intValue()); }
										  

										Cell R50cell4 = row50.getCell(7); if (R50cell4 != null) {
										R50cell4.setCellValue(BRF66.getR52_after_year() == null ? 0 :
										BRF66.getR52_after_year().intValue()); }


										Cell R50cell5 = row50.getCell(8); if (R50cell5 != null) {
										R50cell5.setCellValue(BRF66.getR52_length_year() == null ? 0 :
										BRF66.getR52_length_year().intValue()); }

										Cell R50cell6 = row50.getCell(9); if (R50cell6 != null) {
										R50cell6.setCellValue(BRF66.getR52_int_profit_pl() == null ? 0 :
										BRF66.getR52_int_profit_pl().intValue()); }

										Cell R50cell7 = row50.getCell(10); if (R50cell7 != null) {
										R50cell7.setCellValue(BRF66.getR52_int_profit_acc() == null ? 0 :
										BRF66.getR52_int_profit_acc().intValue()); }

										Cell R50cell8 = row50.getCell(11); if (R50cell8 != null) {
										R50cell8.setCellValue(BRF66.getR52_specific_provision() == null ? 0 :
										BRF66.getR52_specific_provision().intValue()); }

	
										
										
							
										   //////////////////////////R53//////////////////////

										Row row51 = sheet.getRow(64);
										
										Cell R51cell0 = row51.getCell(2);
										if (R51cell0 != null) {
										String value = (BRF66.getR53_borrowers_name() == null) ? "0" : BRF66.getR53_borrowers_name().toString();
										R51cell0.setCellValue(value);
										}
																	  
										Cell R51cell = row51.getCell(3); if (R51cell != null) { String value =
										(BRF66.getR53_rating() == null) ? "0" : BRF66.getR53_rating().toString();
										R51cell.setCellValue(value); } 

										Cell R51cell1 = row51.getCell(4); if (R51cell1 != null) {
										String value = (BRF66.getR53_date_first() == null) ? "0" :
										BRF66.getR53_date_first().toString(); R51cell1.setCellValue(value); }


										Cell R51cell2 = row51.getCell(5); if (R51cell2 != null) {
										  R51cell2.setCellValue(BRF66.getR53_principal_amount() == null ? 0 :
										  BRF66.getR53_principal_amount().intValue()); }
										  
										Cell R51cell3 = row51.getCell(6); if (R51cell3 != null) {
										  R51cell3.setCellValue(BRF66.getR53_original_year() == null ? 0 :
										  BRF66.getR53_original_year().intValue()); }
										  

										Cell R51cell4 = row51.getCell(7); if (R51cell4 != null) {
										R51cell4.setCellValue(BRF66.getR53_after_year() == null ? 0 :
										BRF66.getR53_after_year().intValue()); }


										Cell R51cell5 = row51.getCell(8); if (R51cell5 != null) {
										R51cell5.setCellValue(BRF66.getR53_length_year() == null ? 0 :
										BRF66.getR53_length_year().intValue()); }

										Cell R51cell6 = row51.getCell(9); if (R51cell6 != null) {
										R51cell6.setCellValue(BRF66.getR53_int_profit_pl() == null ? 0 :
										BRF66.getR53_int_profit_pl().intValue()); }

										Cell R51cell7 = row51.getCell(10); if (R51cell7 != null) {
										R51cell7.setCellValue(BRF66.getR53_int_profit_acc() == null ? 0 :
										BRF66.getR53_int_profit_acc().intValue()); }

										Cell R51cell8 = row51.getCell(11); if (R51cell8 != null) {
										R51cell8.setCellValue(BRF66.getR53_specific_provision() == null ? 0 :
										BRF66.getR53_specific_provision().intValue()); }


										   //////////////////////////R54//////////////////////

										Row row52 = sheet.getRow(65);
										
										Cell R52cell0 = row52.getCell(2);
										if (R52cell0 != null) {
										String value = (BRF66.getR54_borrowers_name() == null) ? "0" : BRF66.getR54_borrowers_name().toString();
										R52cell0.setCellValue(value);
										}
																	  
										Cell R52cell = row52.getCell(3); if (R52cell != null) { String value =
										(BRF66.getR54_rating() == null) ? "0" : BRF66.getR54_rating().toString();
										R52cell.setCellValue(value); } 

										Cell R52cell1 = row52.getCell(4); if (R52cell1 != null) {
										String value = (BRF66.getR54_date_first() == null) ? "0" :
										BRF66.getR54_date_first().toString(); R52cell1.setCellValue(value); }


										Cell R52cell2 = row52.getCell(5); if (R52cell2 != null) {
										  R52cell2.setCellValue(BRF66.getR54_principal_amount() == null ? 0 :
										  BRF66.getR54_principal_amount().intValue()); }
										  
										Cell R52cell3 = row52.getCell(6); if (R52cell3 != null) {
										  R52cell3.setCellValue(BRF66.getR54_original_year() == null ? 0 :
										  BRF66.getR54_original_year().intValue()); }
										  

										Cell R52cell4 = row52.getCell(7); if (R52cell4 != null) {
										R52cell4.setCellValue(BRF66.getR54_after_year() == null ? 0 :
										BRF66.getR54_after_year().intValue()); }


										Cell R52cell5 = row52.getCell(8); if (R52cell5 != null) {
										R52cell5.setCellValue(BRF66.getR54_length_year() == null ? 0 :
										BRF66.getR54_length_year().intValue()); }

										Cell R52cell6 = row52.getCell(9); if (R52cell6 != null) {
										R52cell6.setCellValue(BRF66.getR54_int_profit_pl() == null ? 0 :
										BRF66.getR54_int_profit_pl().intValue()); }

										Cell R52cell7 = row52.getCell(10); if (R52cell7 != null) {
										R52cell7.setCellValue(BRF66.getR54_int_profit_acc() == null ? 0 :
										BRF66.getR54_int_profit_acc().intValue()); }

										Cell R52cell8 = row52.getCell(11); if (R52cell8 != null) {
										R52cell8.setCellValue(BRF66.getR54_specific_provision() == null ? 0 :
										BRF66.getR54_specific_provision().intValue()); }


										
										   //////////////////////////R55//////////////////////

										Row row53 = sheet.getRow(66);
										
										Cell R53cell0 = row53.getCell(2);
										if (R53cell0 != null) {
										String value = (BRF66.getR55_borrowers_name() == null) ? "0" : BRF66.getR55_borrowers_name().toString();
										R53cell0.setCellValue(value);
										}
																	  
										Cell R53cell = row53.getCell(3); if (R53cell != null) { String value =
										(BRF66.getR55_rating() == null) ? "0" : BRF66.getR55_rating().toString();
										R53cell.setCellValue(value); } 

										Cell R53cell1 = row53.getCell(4); if (R53cell1 != null) {
										String value = (BRF66.getR55_date_first() == null) ? "0" :
										BRF66.getR55_date_first().toString(); R53cell1.setCellValue(value); }


										Cell R53cell2 = row53.getCell(5); if (R53cell2 != null) {
										  R53cell2.setCellValue(BRF66.getR55_principal_amount() == null ? 0 :
										  BRF66.getR55_principal_amount().intValue()); }
										  
										Cell R53cell3 = row53.getCell(6); if (R53cell3 != null) {
										  R53cell3.setCellValue(BRF66.getR55_original_year() == null ? 0 :
										  BRF66.getR55_original_year().intValue()); }
										  

										Cell R53cell4 = row53.getCell(7); if (R53cell4 != null) {
										R53cell4.setCellValue(BRF66.getR55_after_year() == null ? 0 :
										BRF66.getR55_after_year().intValue()); }


										Cell R53cell5 = row53.getCell(8); if (R53cell5 != null) {
										R53cell5.setCellValue(BRF66.getR55_length_year() == null ? 0 :
										BRF66.getR55_length_year().intValue()); }

										Cell R53cell6 = row53.getCell(9); if (R53cell6 != null) {
										R53cell6.setCellValue(BRF66.getR55_int_profit_pl() == null ? 0 :
										BRF66.getR55_int_profit_pl().intValue()); }

										Cell R53cell7 = row53.getCell(10); if (R53cell7 != null) {
										R53cell7.setCellValue(BRF66.getR55_int_profit_acc() == null ? 0 :
										BRF66.getR55_int_profit_acc().intValue()); }

										Cell R53cell8 = row53.getCell(11); if (R53cell8 != null) {
										R53cell8.setCellValue(BRF66.getR55_specific_provision() == null ? 0 :
										BRF66.getR55_specific_provision().intValue()); }


										
										   //////////////////////////R56//////////////////////

										Row row54 = sheet.getRow(67);
										
										Cell R54cell0 = row54.getCell(2);
										if (R54cell0 != null) {
										String value = (BRF66.getR56_borrowers_name() == null) ? "0" : BRF66.getR56_borrowers_name().toString();
										R54cell0.setCellValue(value);
										}
																	  
										Cell R54cell = row54.getCell(3); if (R54cell != null) { String value =
										(BRF66.getR56_rating() == null) ? "0" : BRF66.getR56_rating().toString();
										R54cell.setCellValue(value); } 

										Cell R54cell1 = row54.getCell(4); if (R54cell1 != null) {
										String value = (BRF66.getR56_date_first() == null) ? "0" :
										BRF66.getR56_date_first().toString(); R54cell1.setCellValue(value); }


										Cell R54cell2 = row54.getCell(5); if (R54cell2 != null) {
										  R54cell2.setCellValue(BRF66.getR56_principal_amount() == null ? 0 :
										  BRF66.getR56_principal_amount().intValue()); }
										  
										Cell R54cell3 = row54.getCell(6); if (R54cell3 != null) {
										  R54cell3.setCellValue(BRF66.getR56_original_year() == null ? 0 :
										  BRF66.getR56_original_year().intValue()); }
										  

										Cell R54cell4 = row54.getCell(7); if (R54cell4 != null) {
										R54cell4.setCellValue(BRF66.getR56_after_year() == null ? 0 :
										BRF66.getR56_after_year().intValue()); }


										Cell R54cell5 = row54.getCell(8); if (R54cell5 != null) {
										R54cell5.setCellValue(BRF66.getR56_length_year() == null ? 0 :
										BRF66.getR56_length_year().intValue()); }

										Cell R54cell6 = row54.getCell(9); if (R54cell6 != null) {
										R54cell6.setCellValue(BRF66.getR56_int_profit_pl() == null ? 0 :
										BRF66.getR56_int_profit_pl().intValue()); }

										Cell R54cell7 = row54.getCell(10); if (R54cell7 != null) {
										R54cell7.setCellValue(BRF66.getR56_int_profit_acc() == null ? 0 :
										BRF66.getR56_int_profit_acc().intValue()); }

										Cell R54cell8 = row54.getCell(11); if (R54cell8 != null) {
										R54cell8.setCellValue(BRF66.getR56_specific_provision() == null ? 0 :
										BRF66.getR56_specific_provision().intValue()); }


										   //////////////////////////R57//////////////////////

										Row row55 = sheet.getRow(68);
										
										Cell R55cell0 = row55.getCell(2);
										if (R55cell0 != null) {
										String value = (BRF66.getR57_borrowers_name() == null) ? "0" : BRF66.getR57_borrowers_name().toString();
										R55cell0.setCellValue(value);
										}
																	  
										Cell R55cell = row55.getCell(3); if (R55cell != null) { String value =
										(BRF66.getR57_rating() == null) ? "0" : BRF66.getR57_rating().toString();
										R55cell.setCellValue(value); } 

										Cell R55cell1 = row55.getCell(4); if (R55cell1 != null) {
										String value = (BRF66.getR57_date_first() == null) ? "0" :
										BRF66.getR57_date_first().toString(); R55cell1.setCellValue(value); }


										Cell R55cell2 = row55.getCell(5); if (R55cell2 != null) {
										  R55cell2.setCellValue(BRF66.getR57_principal_amount() == null ? 0 :
										  BRF66.getR57_principal_amount().intValue()); }
										  
										Cell R55cell3 = row55.getCell(6); if (R55cell3 != null) {
										  R55cell3.setCellValue(BRF66.getR57_original_year() == null ? 0 :
										  BRF66.getR57_original_year().intValue()); }
										  

										Cell R55cell4 = row55.getCell(7); if (R55cell4 != null) {
										R55cell4.setCellValue(BRF66.getR57_after_year() == null ? 0 :
										BRF66.getR57_after_year().intValue()); }


										Cell R55cell5 = row55.getCell(8); if (R55cell5 != null) {
										R55cell5.setCellValue(BRF66.getR57_length_year() == null ? 0 :
										BRF66.getR57_length_year().intValue()); }

										Cell R55cell6 = row55.getCell(9); if (R55cell6 != null) {
										R55cell6.setCellValue(BRF66.getR57_int_profit_pl() == null ? 0 :
										BRF66.getR57_int_profit_pl().intValue()); }

										Cell R55cell7 = row55.getCell(10); if (R55cell7 != null) {
										R55cell7.setCellValue(BRF66.getR57_int_profit_acc() == null ? 0 :
										BRF66.getR57_int_profit_acc().intValue()); }

										Cell R55cell8 = row55.getCell(11); if (R55cell8 != null) {
										R55cell8.setCellValue(BRF66.getR57_specific_provision() == null ? 0 :
										BRF66.getR57_specific_provision().intValue()); }


										   //////////////////////////R58//////////////////////

										Row row56 = sheet.getRow(69);
										
										Cell R56cell0 = row56.getCell(2);
										if (R56cell0 != null) {
										String value = (BRF66.getR58_borrowers_name() == null) ? "0" : BRF66.getR58_borrowers_name().toString();
										R56cell0.setCellValue(value);
										}
																	  
										Cell R56cell = row56.getCell(3); if (R56cell != null) { String value =
										(BRF66.getR58_rating() == null) ? "0" : BRF66.getR58_rating().toString();
										R56cell.setCellValue(value); } 

										Cell R56cell1 = row56.getCell(4); if (R56cell1 != null) {
										String value = (BRF66.getR58_date_first() == null) ? "0" :
										BRF66.getR58_date_first().toString(); R56cell1.setCellValue(value); }


										Cell R56cell2 = row56.getCell(5); if (R56cell2 != null) {
										  R56cell2.setCellValue(BRF66.getR58_principal_amount() == null ? 0 :
										  BRF66.getR58_principal_amount().intValue()); }
										  
										Cell R56cell3 = row56.getCell(6); if (R56cell3 != null) {
										  R56cell3.setCellValue(BRF66.getR58_original_year() == null ? 0 :
										  BRF66.getR58_original_year().intValue()); }
										  

										Cell R56cell4 = row56.getCell(7); if (R56cell4 != null) {
										R56cell4.setCellValue(BRF66.getR58_after_year() == null ? 0 :
										BRF66.getR58_after_year().intValue()); }


										Cell R56cell5 = row56.getCell(8); if (R56cell5 != null) {
										R56cell5.setCellValue(BRF66.getR58_length_year() == null ? 0 :
										BRF66.getR58_length_year().intValue()); }

										Cell R56cell6 = row56.getCell(9); if (R56cell6 != null) {
										R56cell6.setCellValue(BRF66.getR58_int_profit_pl() == null ? 0 :
										BRF66.getR58_int_profit_pl().intValue()); }

										Cell R56cell7 = row56.getCell(10); if (R56cell7 != null) {
										R56cell7.setCellValue(BRF66.getR58_int_profit_acc() == null ? 0 :
										BRF66.getR58_int_profit_acc().intValue()); }

										Cell R56cell8 = row56.getCell(11); if (R56cell8 != null) {
										R56cell8.setCellValue(BRF66.getR58_specific_provision() == null ? 0 :
										BRF66.getR58_specific_provision().intValue()); }


										
										   //////////////////////////R59//////////////////////

										Row row57 = sheet.getRow(70);
																	  
										Cell R57cell0 = row57.getCell(2);
										if (R57cell0 != null) {
										String value = (BRF66.getR59_borrowers_name() == null) ? "0" : BRF66.getR59_borrowers_name().toString();
										R57cell0.setCellValue(value);
										}
										
										Cell R57cell = row57.getCell(3); if (R57cell != null) { String value =
										(BRF66.getR59_rating() == null) ? "0" : BRF66.getR59_rating().toString();
										R57cell.setCellValue(value); } 

										Cell R57cell1 = row57.getCell(4); if (R57cell1 != null) {
										String value = (BRF66.getR59_date_first() == null) ? "0" :
										BRF66.getR59_date_first().toString(); R57cell1.setCellValue(value); }


										Cell R57cell2 = row57.getCell(5); if (R57cell2 != null) {
										  R57cell2.setCellValue(BRF66.getR59_principal_amount() == null ? 0 :
										  BRF66.getR59_principal_amount().intValue()); }
										  
										Cell R57cell3 = row57.getCell(6); if (R57cell3 != null) {
										  R57cell3.setCellValue(BRF66.getR59_original_year() == null ? 0 :
										  BRF66.getR59_original_year().intValue()); }
										  

										Cell R57cell4 = row57.getCell(7); if (R57cell4 != null) {
										R57cell4.setCellValue(BRF66.getR59_after_year() == null ? 0 :
										BRF66.getR59_after_year().intValue()); }


										Cell R57cell5 = row57.getCell(8); if (R57cell5 != null) {
										R57cell5.setCellValue(BRF66.getR59_length_year() == null ? 0 :
										BRF66.getR59_length_year().intValue()); }

										Cell R57cell6 = row57.getCell(9); if (R57cell6 != null) {
										R57cell6.setCellValue(BRF66.getR59_int_profit_pl() == null ? 0 :
										BRF66.getR59_int_profit_pl().intValue()); }

										Cell R57cell7 = row57.getCell(10); if (R57cell7 != null) {
										R57cell7.setCellValue(BRF66.getR59_int_profit_acc() == null ? 0 :
										BRF66.getR59_int_profit_acc().intValue()); }

										Cell R57cell8 = row57.getCell(11); if (R57cell8 != null) {
										R57cell8.setCellValue(BRF66.getR59_specific_provision() == null ? 0 :
										BRF66.getR59_specific_provision().intValue()); }


										   //////////////////////////R60//////////////////////

										Row row58 = sheet.getRow(71);
																	  
										Cell R58cell0 = row58.getCell(2);
										if (R58cell0 != null) {
										String value = (BRF66.getR60_borrowers_name() == null) ? "0" : BRF66.getR60_borrowers_name().toString();
										R58cell0.setCellValue(value);
										}
										
										Cell R58cell = row58.getCell(3); if (R58cell != null) { String value =
										(BRF66.getR60_rating() == null) ? "0" : BRF66.getR60_rating().toString();
										R58cell.setCellValue(value); } 

										Cell R58cell1 = row58.getCell(4); if (R58cell1 != null) {
										String value = (BRF66.getR60_date_first() == null) ? "0" :
										BRF66.getR60_date_first().toString(); R58cell1.setCellValue(value); }


										Cell R58cell2 = row58.getCell(5); if (R58cell2 != null) {
										  R58cell2.setCellValue(BRF66.getR60_principal_amount() == null ? 0 :
										  BRF66.getR60_principal_amount().intValue()); }
										  
										Cell R58cell3 = row58.getCell(6); if (R58cell3 != null) {
										  R58cell3.setCellValue(BRF66.getR60_original_year() == null ? 0 :
										  BRF66.getR60_original_year().intValue()); }
										  

										Cell R58cell4 = row58.getCell(7); if (R58cell4 != null) {
										R58cell4.setCellValue(BRF66.getR60_after_year() == null ? 0 :
										BRF66.getR60_after_year().intValue()); }


										Cell R58cell5 = row58.getCell(8); if (R58cell5 != null) {
										R58cell5.setCellValue(BRF66.getR60_length_year() == null ? 0 :
										BRF66.getR60_length_year().intValue()); }

										Cell R58cell6 = row58.getCell(9); if (R58cell6 != null) {
										R58cell6.setCellValue(BRF66.getR60_int_profit_pl() == null ? 0 :
										BRF66.getR60_int_profit_pl().intValue()); }

										Cell R58cell7 = row58.getCell(10); if (R58cell7 != null) {
										R58cell7.setCellValue(BRF66.getR60_int_profit_acc() == null ? 0 :
										BRF66.getR60_int_profit_acc().intValue()); }

										Cell R58cell8 = row58.getCell(11); if (R58cell8 != null) {
										R58cell8.setCellValue(BRF66.getR60_specific_provision() == null ? 0 :
										BRF66.getR60_specific_provision().intValue()); }


										   //////////////////////////R61//////////////////////

										Row row59 = sheet.getRow(72);
										
										Cell R59cell0 = row59.getCell(2);
										if (R59cell0 != null) {
										String value = (BRF66.getR61_borrowers_name() == null) ? "0" : BRF66.getR61_borrowers_name().toString();
										R59cell0.setCellValue(value);
										}
																	  
										Cell R59cell = row59.getCell(3); if (R59cell != null) { String value =
										(BRF66.getR61_rating() == null) ? "0" : BRF66.getR61_rating().toString();
										R59cell.setCellValue(value); } 

										Cell R59cell1 = row59.getCell(4); if (R59cell1 != null) {
										String value = (BRF66.getR61_date_first() == null) ? "0" :
										BRF66.getR61_date_first().toString(); R59cell1.setCellValue(value); }


										Cell R59cell2 = row59.getCell(5); if (R59cell2 != null) {
										  R59cell2.setCellValue(BRF66.getR61_principal_amount() == null ? 0 :
										  BRF66.getR61_principal_amount().intValue()); }
										  
										Cell R59cell3 = row59.getCell(6); if (R59cell3 != null) {
										  R59cell3.setCellValue(BRF66.getR61_original_year() == null ? 0 :
										  BRF66.getR61_original_year().intValue()); }
										  

										Cell R59cell4 = row59.getCell(7); if (R59cell4 != null) {
										R59cell4.setCellValue(BRF66.getR61_after_year() == null ? 0 :
										BRF66.getR61_after_year().intValue()); }


										Cell R59cell5 = row59.getCell(8); if (R59cell5 != null) {
										R59cell5.setCellValue(BRF66.getR61_length_year() == null ? 0 :
										BRF66.getR61_length_year().intValue()); }

										Cell R59cell6 = row59.getCell(9); if (R59cell6 != null) {
										R59cell6.setCellValue(BRF66.getR61_int_profit_pl() == null ? 0 :
										BRF66.getR61_int_profit_pl().intValue()); }

										Cell R59cell7 = row59.getCell(10); if (R59cell7 != null) {
										R59cell7.setCellValue(BRF66.getR61_int_profit_acc() == null ? 0 :
										BRF66.getR61_int_profit_acc().intValue()); }

										Cell R59cell8 = row59.getCell(11); if (R59cell8 != null) {
										R59cell8.setCellValue(BRF66.getR61_specific_provision() == null ? 0 :
										BRF66.getR61_specific_provision().intValue()); }


									
							
							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-066-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-066-A.xls");

		return outputFile;

	}

	public String detailChanges66(BRF66_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {
			// Get the current Hibernate session
			Session hs = sessionFactory.getCurrentSession();

			// Find the BRF66_DETAIL_ENTITY object by its foracid
			Optional<BRF66_DETAIL_ENTITY> brf66DetailOptional = brf66_detailrepo.findById(foracid);

			if (brf66DetailOptional.isPresent()) {
				BRF66_DETAIL_ENTITY brfDetail = brf66DetailOptional.get();
				if (brfDetail != null && report_label_1 != null && report_name_1 != null
						&& report_addl_criteria_1 != null) {
					if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc())
							&& report_label_1.equals(brfDetail.getReport_label_1())
							&& report_name_1.equals(brfDetail.getReport_name_1())
							&& report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
						msg = "No modification done";
					} else {
						// Update the BRF66_DETAIL_ENTITY object with the provided parameters
						brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
						brfDetail.setReport_label_1(report_label_1);
						brfDetail.setReport_name_1(report_name_1);
						brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

						// Save the updated object
						brf66_detailrepo.save(brfDetail);

						// Log the action
						logger.info("Edited Record");
						msg = "Edited Successfully";
					}
				} else {
					msg = "Some parameters are null";
				}
			} else {
				msg = "No data Found";
			}

		} catch (Exception e) {
			// Handle any exceptions
			msg = "An error occurred. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public ModelAndView getArchieveBRF066View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF66_Entity> T1rep = new ArrayList<BRF66_Entity>();
		// Query<Object[]> qr;

		List<BRF66_Entity> T1Master = new ArrayList<BRF66_Entity>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF66_Entity a where a.report_date = ?1 ", BRF66_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF066ARCH");
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

	public ModelAndView ARCHgetBRF066currentDtl(String reportId, String fromdate, String todate, String currency,
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
				System.out.println("Filter - " + filter);

				qr = hs.createNativeQuery("select * from BRF66_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF66_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF66_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF66_ARCHIV_ENTITY> T1Master = new ArrayList<BRF66_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF66_ARCHIV_ENTITY a where a.report_date = ?1", BRF66_ARCHIV_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];
			String acct_name = (String) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[4];
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
			String entity_flg = (String) a[40];
			String modify_flg = (String) a[41];
			String del_flg = (String) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			String maturity_date = (String) a[45];
			String version = (String) a[46];
			String remarks = (String) a[47];

			BRF66_ARCHIV_ENTITY py = new BRF66_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
					remarks);

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

		mv.setViewName("RR" + "/" + "BRF066ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String modifyRecord66(Date asondate, BRF66_Entity BRF66_Entity, String userId) {
		String msg = "";
		Optional<BRF66_Entity> up = brf066aServiceRepo.getBRF66AReport(asondate);

		if (up.isPresent()) {
			BRF66_Entity brf66 = up.get();

			/// original
			if (BRF66_Entity.getR32_original_year() != null) {
				brf66.setR32_original_year(BRF66_Entity.getR32_original_year());
			}
			if (BRF66_Entity.getR33_original_year() != null) {
				brf66.setR33_original_year(BRF66_Entity.getR33_original_year());
			}
			if (BRF66_Entity.getR34_original_year() != null) {
				brf66.setR34_original_year(BRF66_Entity.getR34_original_year());
			}
			if (BRF66_Entity.getR35_original_year() != null) {
				brf66.setR35_original_year(BRF66_Entity.getR35_original_year());
			}
			if (BRF66_Entity.getR36_original_year() != null) {
				brf66.setR36_original_year(BRF66_Entity.getR36_original_year());
			}
			if (BRF66_Entity.getR37_original_year() != null) {
				brf66.setR37_original_year(BRF66_Entity.getR37_original_year());
			}
			if (BRF66_Entity.getR38_original_year() != null) {
				brf66.setR38_original_year(BRF66_Entity.getR38_original_year());
			}
			if (BRF66_Entity.getR39_original_year() != null) {
				brf66.setR39_original_year(BRF66_Entity.getR39_original_year());
			}
			if (BRF66_Entity.getR40_original_year() != null) {
				brf66.setR40_original_year(BRF66_Entity.getR40_original_year());
			}
			if (BRF66_Entity.getR41_original_year() != null) {
				brf66.setR41_original_year(BRF66_Entity.getR41_original_year());
			}
			if (BRF66_Entity.getR42_original_year() != null) {
				brf66.setR42_original_year(BRF66_Entity.getR42_original_year());
			}
			if (BRF66_Entity.getR43_original_year() != null) {
				brf66.setR43_original_year(BRF66_Entity.getR43_original_year());
			}
			if (BRF66_Entity.getR44_original_year() != null) {
				brf66.setR44_original_year(BRF66_Entity.getR44_original_year());
			}
			if (BRF66_Entity.getR45_original_year() != null) {
				brf66.setR45_original_year(BRF66_Entity.getR45_original_year());
			}
			if (BRF66_Entity.getR46_original_year() != null) {
				brf66.setR46_original_year(BRF66_Entity.getR46_original_year());
			}
			if (BRF66_Entity.getR47_original_year() != null) {
				brf66.setR47_original_year(BRF66_Entity.getR47_original_year());
			}
			if (BRF66_Entity.getR48_original_year() != null) {
				brf66.setR48_original_year(BRF66_Entity.getR48_original_year());
			}
			if (BRF66_Entity.getR49_original_year() != null) {
				brf66.setR49_original_year(BRF66_Entity.getR49_original_year());
			}
			if (BRF66_Entity.getR50_original_year() != null) {
				brf66.setR50_original_year(BRF66_Entity.getR50_original_year());
			}
			if (BRF66_Entity.getR51_original_year() != null) {
				brf66.setR51_original_year(BRF66_Entity.getR51_original_year());
			}
			if (BRF66_Entity.getR52_original_year() != null) {
				brf66.setR52_original_year(BRF66_Entity.getR52_original_year());
			}
			if (BRF66_Entity.getR53_original_year() != null) {
				brf66.setR53_original_year(BRF66_Entity.getR53_original_year());
			}
			if (BRF66_Entity.getR54_original_year() != null) {
				brf66.setR54_original_year(BRF66_Entity.getR54_original_year());
			}
			if (BRF66_Entity.getR55_original_year() != null) {
				brf66.setR55_original_year(BRF66_Entity.getR55_original_year());
			}
			if (BRF66_Entity.getR56_original_year() != null) {
				brf66.setR56_original_year(BRF66_Entity.getR56_original_year());
			}
			if (BRF66_Entity.getR57_original_year() != null) {
				brf66.setR57_original_year(BRF66_Entity.getR57_original_year());
			}
			if (BRF66_Entity.getR58_original_year() != null) {
				brf66.setR58_original_year(BRF66_Entity.getR58_original_year());
			}
			if (BRF66_Entity.getR59_original_year() != null) {
				brf66.setR59_original_year(BRF66_Entity.getR59_original_year());
			}
			if (BRF66_Entity.getR60_original_year() != null) {
				brf66.setR60_original_year(BRF66_Entity.getR60_original_year());
			}
			if (BRF66_Entity.getR61_original_year() != null) {
				brf66.setR61_original_year(BRF66_Entity.getR61_original_year());
			}
//////
			if (BRF66_Entity.getR32_after_year() != null) {
				brf66.setR32_after_year(BRF66_Entity.getR32_after_year());
			}
			if (BRF66_Entity.getR33_after_year() != null) {
				brf66.setR33_after_year(BRF66_Entity.getR33_after_year());
			}
			if (BRF66_Entity.getR34_after_year() != null) {
				brf66.setR34_after_year(BRF66_Entity.getR34_after_year());
			}
			if (BRF66_Entity.getR35_after_year() != null) {
				brf66.setR35_after_year(BRF66_Entity.getR35_after_year());
			}
			if (BRF66_Entity.getR36_after_year() != null) {
				brf66.setR36_after_year(BRF66_Entity.getR36_after_year());
			}
			if (BRF66_Entity.getR37_after_year() != null) {
				brf66.setR37_after_year(BRF66_Entity.getR37_after_year());
			}
			if (BRF66_Entity.getR38_after_year() != null) {
				brf66.setR38_after_year(BRF66_Entity.getR38_after_year());
			}
			if (BRF66_Entity.getR39_after_year() != null) {
				brf66.setR39_after_year(BRF66_Entity.getR39_after_year());
			}
			if (BRF66_Entity.getR40_after_year() != null) {
				brf66.setR40_after_year(BRF66_Entity.getR40_after_year());
			}
			if (BRF66_Entity.getR41_after_year() != null) {
				brf66.setR41_after_year(BRF66_Entity.getR41_after_year());
			}
			if (BRF66_Entity.getR42_after_year() != null) {
				brf66.setR42_after_year(BRF66_Entity.getR42_after_year());
			}
			if (BRF66_Entity.getR43_after_year() != null) {
				brf66.setR43_after_year(BRF66_Entity.getR43_after_year());
			}
			if (BRF66_Entity.getR44_after_year() != null) {
				brf66.setR44_after_year(BRF66_Entity.getR44_after_year());
			}
			if (BRF66_Entity.getR45_after_year() != null) {
				brf66.setR45_after_year(BRF66_Entity.getR45_after_year());
			}
			if (BRF66_Entity.getR46_after_year() != null) {
				brf66.setR46_after_year(BRF66_Entity.getR46_after_year());
			}
			if (BRF66_Entity.getR47_after_year() != null) {
				brf66.setR47_after_year(BRF66_Entity.getR47_after_year());
			}
			if (BRF66_Entity.getR48_after_year() != null) {
				brf66.setR48_after_year(BRF66_Entity.getR48_after_year());
			}
			if (BRF66_Entity.getR49_after_year() != null) {
				brf66.setR49_after_year(BRF66_Entity.getR49_after_year());
			}
			if (BRF66_Entity.getR50_after_year() != null) {
				brf66.setR50_after_year(BRF66_Entity.getR50_after_year());
			}
			if (BRF66_Entity.getR51_after_year() != null) {
				brf66.setR51_after_year(BRF66_Entity.getR51_after_year());
			}
			if (BRF66_Entity.getR52_after_year() != null) {
				brf66.setR52_after_year(BRF66_Entity.getR52_after_year());
			}
			if (BRF66_Entity.getR53_after_year() != null) {
				brf66.setR53_after_year(BRF66_Entity.getR53_after_year());
			}
			if (BRF66_Entity.getR54_after_year() != null) {
				brf66.setR54_after_year(BRF66_Entity.getR54_after_year());
			}
			if (BRF66_Entity.getR55_after_year() != null) {
				brf66.setR55_after_year(BRF66_Entity.getR55_after_year());
			}
			if (BRF66_Entity.getR56_after_year() != null) {
				brf66.setR56_after_year(BRF66_Entity.getR56_after_year());
			}
			if (BRF66_Entity.getR57_after_year() != null) {
				brf66.setR57_after_year(BRF66_Entity.getR57_after_year());
			}
			if (BRF66_Entity.getR58_after_year() != null) {
				brf66.setR58_after_year(BRF66_Entity.getR58_after_year());
			}
			if (BRF66_Entity.getR59_after_year() != null) {
				brf66.setR59_after_year(BRF66_Entity.getR50_after_year());
			}
			if (BRF66_Entity.getR60_after_year() != null) {
				brf66.setR60_after_year(BRF66_Entity.getR60_after_year());
			}
			if (BRF66_Entity.getR61_after_year() != null) {
				brf66.setR61_after_year(BRF66_Entity.getR61_after_year());
			}
			/////
			if (BRF66_Entity.getR32_length_year() != null) {
				brf66.setR32_length_year(BRF66_Entity.getR32_length_year());
			}
			if (BRF66_Entity.getR33_length_year() != null) {
				brf66.setR33_length_year(BRF66_Entity.getR33_length_year());
			}
			if (BRF66_Entity.getR34_length_year() != null) {
				brf66.setR34_length_year(BRF66_Entity.getR34_length_year());
			}
			if (BRF66_Entity.getR35_length_year() != null) {
				brf66.setR35_length_year(BRF66_Entity.getR35_length_year());
			}
			if (BRF66_Entity.getR36_length_year() != null) {
				brf66.setR36_length_year(BRF66_Entity.getR36_length_year());
			}
			if (BRF66_Entity.getR37_length_year() != null) {
				brf66.setR37_length_year(BRF66_Entity.getR37_length_year());
			}
			if (BRF66_Entity.getR38_length_year() != null) {
				brf66.setR38_length_year(BRF66_Entity.getR38_length_year());
			}
			if (BRF66_Entity.getR39_length_year() != null) {
				brf66.setR39_length_year(BRF66_Entity.getR39_length_year());
			}
			if (BRF66_Entity.getR40_length_year() != null) {
				brf66.setR40_length_year(BRF66_Entity.getR40_length_year());
			}
			if (BRF66_Entity.getR41_length_year() != null) {
				brf66.setR41_length_year(BRF66_Entity.getR41_length_year());
			}
			if (BRF66_Entity.getR42_length_year() != null) {
				brf66.setR42_length_year(BRF66_Entity.getR42_length_year());
			}
			if (BRF66_Entity.getR43_length_year() != null) {
				brf66.setR43_length_year(BRF66_Entity.getR43_length_year());
			}
			if (BRF66_Entity.getR44_length_year() != null) {
				brf66.setR44_length_year(BRF66_Entity.getR44_length_year());
			}
			if (BRF66_Entity.getR45_length_year() != null) {
				brf66.setR45_length_year(BRF66_Entity.getR45_length_year());
			}
			if (BRF66_Entity.getR46_length_year() != null) {
				brf66.setR46_length_year(BRF66_Entity.getR46_length_year());
			}
			if (BRF66_Entity.getR47_length_year() != null) {
				brf66.setR47_length_year(BRF66_Entity.getR47_length_year());
			}
			if (BRF66_Entity.getR48_length_year() != null) {
				brf66.setR48_length_year(BRF66_Entity.getR48_length_year());
			}
			if (BRF66_Entity.getR49_length_year() != null) {
				brf66.setR49_length_year(BRF66_Entity.getR49_length_year());
			}
			if (BRF66_Entity.getR50_length_year() != null) {
				brf66.setR50_length_year(BRF66_Entity.getR50_length_year());
			}
			if (BRF66_Entity.getR51_length_year() != null) {
				brf66.setR51_length_year(BRF66_Entity.getR51_length_year());
			}
			if (BRF66_Entity.getR52_length_year() != null) {
				brf66.setR52_length_year(BRF66_Entity.getR52_length_year());
			}
			if (BRF66_Entity.getR53_length_year() != null) {
				brf66.setR53_length_year(BRF66_Entity.getR53_length_year());
			}
			if (BRF66_Entity.getR54_length_year() != null) {
				brf66.setR54_length_year(BRF66_Entity.getR54_length_year());
			}
			if (BRF66_Entity.getR55_length_year() != null) {
				brf66.setR55_length_year(BRF66_Entity.getR55_length_year());
			}
			if (BRF66_Entity.getR56_length_year() != null) {
				brf66.setR56_length_year(BRF66_Entity.getR56_length_year());
			}
			if (BRF66_Entity.getR57_length_year() != null) {
				brf66.setR57_length_year(BRF66_Entity.getR57_length_year());
			}
			if (BRF66_Entity.getR58_length_year() != null) {
				brf66.setR58_length_year(BRF66_Entity.getR58_length_year());
			}
			if (BRF66_Entity.getR59_length_year() != null) {
				brf66.setR59_length_year(BRF66_Entity.getR59_length_year());
			}
			if (BRF66_Entity.getR60_length_year() != null) {
				brf66.setR60_length_year(BRF66_Entity.getR60_length_year());
			}
			if (BRF66_Entity.getR50_length_year() != null) {
				brf66.setR61_length_year(BRF66_Entity.getR61_length_year());
			}

			brf66.setDel_flg("N");
			brf66.setEntity_flg("Y");
			brf66.setModify_flg("Y");
			brf66.setModify_user(userId);
			brf66.setReport_date(asondate);
			brf66.setReport_to_date(asondate);
			brf066aServiceRepo.save(brf66);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}
		return msg;
	}

	public String verifyBRF66Report(Date asondate, String userId) {
		String msg = "";
		Optional<BRF66_Entity> up = brf066aServiceRepo.getBRF66AReport(asondate);

		if (up.isPresent()) {
			BRF66_Entity brf66 = up.get();
			brf66.setModify_flg("N");
			brf66.setVerify_time(new Date());
			brf66.setVerify_user(userId);
			brf66.setVerify_user(userId);
			brf66.setVerify_time(asondate);
			brf066aServiceRepo.save(brf66);
			msg = "Verified Successfully";
		} else {
			msg = "Data Not Found";
		}
		return msg;
	}
}
