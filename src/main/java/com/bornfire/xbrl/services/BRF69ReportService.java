package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
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

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.BRF069_ARCH_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.BRF69_SUMMARY_A_REP;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_B_REP;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_C_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_C_REP;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_D_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_D_REP;
import com.bornfire.xbrl.entities.BRBS.BRF69_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF69_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF69_SUMMARY_A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;
import com.bornfire.xbrl.entities.BRBS.YourFormData;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
@Transactional
@ConfigurationProperties("output")

public class BRF69ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF69ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;

	@Autowired
	Environment env;

	@Autowired
	BRF69_DetailRepo brf69_detailrepo;

	@Autowired
	BRF069_SUMMARY_B_REP brf069_SUMMARY_B_REP;

	@Autowired
	BRF069_SUMMARY_C_REP brf069_SUMMARY_C_REP;

	@Autowired
	BRF069_SUMMARY_D_REP brf069_SUMMARY_D_REP;

	@Autowired
	BRF69_SUMMARY_A_REP brf69_SUMMARY_A_REP;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF069(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF69_SUMMARY_A_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF69_SUMMARY_A_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF069View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF69_SUMMARY_A_ENTITY> T1rep = new ArrayList<BRF69_SUMMARY_A_ENTITY>();
		// Query<Object[]> qr;

		List<BRF69_SUMMARY_A_ENTITY> T1Master = new ArrayList<BRF69_SUMMARY_A_ENTITY>();
		List<BRF069_SUMMARY_B_ENTITY> T2Master = new ArrayList<BRF069_SUMMARY_B_ENTITY>();
		List<BRF069_SUMMARY_C_ENTITY> T3Master = new ArrayList<BRF069_SUMMARY_C_ENTITY>();
		List<BRF069_SUMMARY_D_ENTITY> T4Master = new ArrayList<BRF069_SUMMARY_D_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF69_SUMMARY_A_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF69_SUMMARY_A_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
			T2Master = hs.createQuery("from BRF069_SUMMARY_B_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF069_SUMMARY_B_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
			T3Master = hs.createQuery("from BRF069_SUMMARY_C_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF069_SUMMARY_C_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
			T4Master = hs.createQuery("from BRF069_SUMMARY_D_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF069_SUMMARY_D_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/ReportBRF069");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary3", T4Master);
		mv.addObject("reportsummary2", T3Master);
		mv.addObject("reportsummary1", T2Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF069Details(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF69_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF69_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF69_DETAILTABLE  where report_date = ?1");
		}
		List<BRF69_DETAIL_ENTITY> T1Master = new ArrayList<BRF69_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF69_DETAIL_ENTITY a where a.report_date = ?1", BRF69_DETAIL_ENTITY.class)
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

			BRF69_DETAIL_ENTITY py = new BRF69_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "ReportBRF069::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF069(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype)
			throws FileNotFoundException, JRException, SQLException, IOException, InvalidFormatException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		File outputFile = null;

		logger.info("Getting Output file :" + reportId);
		fileName = "t" + reportId + "_" + todate;

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile = null;
					logger.info("Getting Jasper file :" + reportId);

					if (dtltype.equals("report") && !(filetype.equals("detailexcel"))) {
						// Add more Jasper files if needed
						System.out.println("22");
						InputStream[] jasperFiles = {
								this.getClass().getResourceAsStream("/static/jasper/BRF069A.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF069B.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF069C.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF069D.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF069E.jrxml"), };

						// Compile JasperReports
						JasperReport[] jasperReports = new JasperReport[jasperFiles.length];
						for (int i = 0; i < jasperFiles.length; i++) {
							jasperReports[i] = JasperCompileManager.compileReport(jasperFiles[i]);
						}

						HashMap<String, Object> map = new HashMap<>();
						map.put("REPORT_DATE", todate);

						// Fill JasperPrint for each report
						JasperPrint[] jasperPrints = new JasperPrint[jasperReports.length];

						for (int i = 0; i < jasperReports.length; i++) {
							try (Connection connection = srcdataSource.getConnection()) {
								jasperPrints[i] = JasperFillManager.fillReport(jasperReports[i], map, connection);
							}
						}

						// Combine JasperPrints
						JasperPrint combinedJasperPrint = new JasperPrint();
						for (JasperPrint jasperPrint : jasperPrints) {
							List<JRPrintPage> pages = jasperPrint.getPages();
							for (JRPrintPage page : pages) {
								combinedJasperPrint.addPage(page);
							}
						}

						if (filetype.equals("pdf")) {
							fileName = "BRF69" + ".pdf"; // Correct file extension for PDF
							path += File.separator + fileName; // Use File.separator for path construction

							JasperExportManager.exportReportToPdfFile(combinedJasperPrint, path);
							logger.info("PDF File exported");
						} else {
							// Export as Excel
							fileName = "BRF69" + ".xlsx";
							path += File.separator + fileName; // Use File.separator for path construction

							SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
							reportConfig.setSheetNames(new String[] { fileName });
							reportConfig.setIgnoreGraphics(true);
							JRXlsxExporter exporter = new JRXlsxExporter();
							exporter.setExporterInput(new SimpleExporterInput(combinedJasperPrint));
							exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
							exporter.setConfiguration(reportConfig); // Set the configuration
							exporter.exportReport();
							logger.info("Excel File exported");
						}

					} else {
						// Your existing code for non-report Jasper files
						if (filetype.equals("detailexcel")) {
							System.out.println("1");
							if (dtltype.equals("report")) {
								jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF69_Detail.jrxml");
							}
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF69_Detail.jrxml");
						}

						JasperReport jr = JasperCompileManager.compileReport(jasperFile);
						HashMap<String, Object> map = new HashMap<>();

						logger.info("Assigning Parameters for Jasper");
						map.put("REPORT_DATE", todate);

						if (filetype.equals("pdf")) {
							fileName = fileName + ".pdf";
							path += fileName;
							JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
							JasperExportManager.exportReportToPdfFile(jp, path);
							logger.info("PDF File exported");
						} else {
							fileName = fileName + ".xlsx";
							path += fileName;
							JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
							JRXlsxExporter exporter = new JRXlsxExporter();
							exporter.setExporterInput(new SimpleExporterInput(jp));
							exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
							exporter.exportReport();
							logger.info("Excel File exported");
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				outputFile = new File(path);
				return outputFile;
			} else {
				List<BRF69_SUMMARY_A_ENTITY> T1Master = new ArrayList<>();
				List<BRF069_SUMMARY_B_ENTITY> T2Master = new ArrayList<>();
				List<BRF069_SUMMARY_C_ENTITY> T3Master = new ArrayList<>();
				List<BRF069_SUMMARY_D_ENTITY> T4Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = dateFormat.parse(todate);
					T1Master = hs.createQuery("from BRF69_SUMMARY_A_ENTITY a where a.report_date = ?1 order by srl_no",
							BRF69_SUMMARY_A_ENTITY.class).setParameter(1, d1).getResultList();
					T2Master = hs.createQuery("from BRF069_SUMMARY_B_ENTITY a where a.report_date = ?1 order by srl_no",
							BRF069_SUMMARY_B_ENTITY.class).setParameter(1, d1).getResultList();
					T3Master = hs.createQuery("from BRF069_SUMMARY_C_ENTITY a where a.report_date = ?1 order by srl_no",
							BRF069_SUMMARY_C_ENTITY.class).setParameter(1, d1).getResultList();
					T4Master = hs.createQuery("from BRF069_SUMMARY_D_ENTITY a where a.report_date = ?1 order by srl_no",
							BRF069_SUMMARY_D_ENTITY.class).setParameter(1, d1).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-069-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					Sheet sheet = workbook.getSheetAt(0);

					updateTable1(sheet, T1Master);
					updateTable2(sheet, T2Master);
					updateTable3(sheet, T3Master);
					updateTable4(sheet, T4Master);

					// Write to final output file
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					try (FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-069-A.xls")) {
						workbook.write(fileOut);
					}
					workbook.close();

					path = env.getProperty("output.exportpathfinal") + "011-BRF-069-A.xls";
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (EncryptedDocumentException | IOException e) {
					e.printStackTrace();
				} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return new File(path);
		}

		return outputFile;
	}

	private void updateTable1(Sheet sheet, List<BRF69_SUMMARY_A_ENTITY> T1Master) {
		int startRow = 8; // Starting row numberb
		for (int index = 0; index < T1Master.size(); index++) {
			BRF69_SUMMARY_A_ENTITY BRF069 = T1Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF069.getR1_col1() == null) ? "0" : BRF069.getR1_col1().toString();
				cell.setCellValue(value);
			}
			Cell cell1 = row.getCell(3);
			if (cell1 != null) {
				String value1 = (BRF069.getR1_col2() == null) ? "0" : BRF069.getR1_col2().toString();
				cell1.setCellValue(value1);
			}
			Cell cell2 = row.getCell(4);
			if (cell2 != null) {
				String value2 = (BRF069.getR1_col3() == null) ? "0" : BRF069.getR1_col3().toString();
				cell2.setCellValue(value2);
			}
			Cell cell3 = row.getCell(5);
			if (cell3 != null) {
				String value3 = (BRF069.getR1_col4() == null) ? "0" : BRF069.getR1_col4().toString();
				cell3.setCellValue(value3);
			}
			Cell cell4 = row.getCell(6);
			if (cell4 != null) {
				String value4 = (BRF069.getR1_col5() == null) ? "0" : BRF069.getR1_col5().toString();
				cell4.setCellValue(value4);
			}

			Date date = BRF069.getR1_col6(); // Get the date value
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Create a date format

			Cell cell5 = row.getCell(7);
			if (cell5 != null) {
				if (date == null) {
					cell5.setCellValue("dd-MM-yyyy"); // Set a default date if null
				} else {
					cell5.setCellValue(dateFormat.format(date)); // Set the formatted date in the cell
				}
			}

			Cell cell6 = row.getCell(8);
			if (cell6 != null) {
				String value6 = (BRF069.getR1_col7() == null) ? "0" : BRF069.getR1_col7().toString();
				cell6.setCellValue(value6);
			}
			Cell cell7 = row.getCell(9);
			if (cell7 != null) {
				String value7 = (BRF069.getR1_col8() == null) ? "0" : BRF069.getR1_col8().toString();
				cell7.setCellValue(value7);
			}
			Cell cell8 = row.getCell(10);
			if (cell8 != null) {
				String value8 = (BRF069.getR1_col9() == null) ? "0" : BRF069.getR1_col9().toString();
				cell8.setCellValue(value8);
			}
			Cell cell9 = row.getCell(11);
			if (cell9 != null) {
				String value9 = (BRF069.getR1_col10() == null) ? "0" : BRF069.getR1_col10().toString();
				cell9.setCellValue(value9);
			}
		}
	}

	private void updateTable2(Sheet sheet, List<BRF069_SUMMARY_B_ENTITY> T2Master) {
		int startRow = 20; // Starting row number
		for (int index = 0; index < T2Master.size(); index++) {
			BRF069_SUMMARY_B_ENTITY BRF069 = T2Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF069.getR2_col1() == null) ? "0" : BRF069.getR2_col1().toString();
				cell.setCellValue(value);
			}
			Cell cell1 = row.getCell(3);
			if (cell1 != null) {
				String value1 = (BRF069.getR2_col2() == null) ? "0" : BRF069.getR2_col2().toString();
				cell1.setCellValue(value1);
			}

			Cell cell2 = row.getCell(4);
			if (cell2 != null) {
				String value2 = (BRF069.getR2_col3() == null) ? "0" : BRF069.getR2_col3().toString();
				cell2.setCellValue(value2);
			}

			Cell cell3 = row.getCell(5);
			if (cell3 != null) {
				String value3 = (BRF069.getR2_col4() == null) ? "0" : BRF069.getR2_col4().toString();
				cell3.setCellValue(value3);
			}

			Cell cell4 = row.getCell(6);
			if (cell4 != null) {
				String value4 = (BRF069.getR2_col5() == null) ? "0" : BRF069.getR2_col5().toString();
				cell4.setCellValue(value4);
			}
			Date date = BRF069.getR2_col6(); // Get the date value
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Create a date format

			Cell cell5 = row.getCell(7);
			if (cell5 != null) {
				if (date == null) {
					cell5.setCellValue("dd-MM-yyyy"); // Set a default date if null
				} else {
					cell5.setCellValue(dateFormat.format(date)); // Set the formatted date in the cell
				}
			}

			Cell cell6 = row.getCell(8);
			if (cell6 != null) {
				String value6 = (BRF069.getR2_col7() == null) ? "0" : BRF069.getR2_col7().toString();
				cell6.setCellValue(value6);
			}

			Cell cell7 = row.getCell(9);
			if (cell7 != null) {
				String value7 = (BRF069.getR2_col8() == null) ? "0" : BRF069.getR2_col8().toString();
				cell7.setCellValue(value7);
			}

			Cell cell8 = row.getCell(10);
			if (cell8 != null) {
				String value8 = (BRF069.getR2_col9() == null) ? "0" : BRF069.getR2_col9().toString();
				cell8.setCellValue(value8);
			}

			Cell cell9 = row.getCell(11);
			if (cell9 != null) {
				String value9 = (BRF069.getR2_col10() == null) ? "0" : BRF069.getR2_col10().toString();
				cell9.setCellValue(value9);
			}
		}
	}

	private void updateTable3(Sheet sheet, List<BRF069_SUMMARY_C_ENTITY> T3Master) {
		int startRow = 32; // Starting row number
		for (int index = 0; index < T3Master.size(); index++) {
			BRF069_SUMMARY_C_ENTITY BRF069 = T3Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF069.getR3_col1() == null) ? "0" : BRF069.getR3_col1().toString();
				cell.setCellValue(value);
			}
			Cell cell1 = row.getCell(3);
			if (cell1 != null) {
				String value1 = (BRF069.getR3_col2() == null) ? "0" : BRF069.getR3_col2().toString();
				cell1.setCellValue(value1);
			}

			Cell cell2 = row.getCell(4);
			if (cell2 != null) {
				String value2 = (BRF069.getR3_col3() == null) ? "0" : BRF069.getR3_col3().toString();
				cell2.setCellValue(value2);
			}

			Cell cell3 = row.getCell(5);
			if (cell3 != null) {
				String value3 = (BRF069.getR3_col4() == null) ? "0" : BRF069.getR3_col4().toString();
				cell3.setCellValue(value3);
			}

			Cell cell4 = row.getCell(6);
			if (cell4 != null) {
				String value4 = (BRF069.getR3_col5() == null) ? "0" : BRF069.getR3_col5().toString();
				cell4.setCellValue(value4);
			}

			Cell cell5 = row.getCell(7);
			if (cell5 != null) {
				String value5 = (BRF069.getR3_col6() == null) ? "0" : BRF069.getR3_col6().toString();
				cell5.setCellValue(value5);
			}

			Cell cell6 = row.getCell(8);
			if (cell6 != null) {
				String value6 = (BRF069.getR3_col7() == null) ? "0" : BRF069.getR3_col7().toString();
				cell6.setCellValue(value6);
			}

			Cell cell7 = row.getCell(9);
			if (cell7 != null) {
				String value7 = (BRF069.getR3_col8() == null) ? "0" : BRF069.getR3_col8().toString();
				cell7.setCellValue(value7);
			}

			Cell cell8 = row.getCell(10);
			if (cell8 != null) {
				String value8 = (BRF069.getR3_col9() == null) ? "0" : BRF069.getR3_col9().toString();
				cell8.setCellValue(value8);
			}

			Cell cell9 = row.getCell(11);
			if (cell9 != null) {
				String value9 = (BRF069.getR3_col10() == null) ? "0" : BRF069.getR3_col10().toString();
				cell9.setCellValue(value9);
			}
		}
	}

	private void updateTable4(Sheet sheet, List<BRF069_SUMMARY_D_ENTITY> T4Master) {
		int startRow = 44; // Starting row number
		for (int index = 0; index < T4Master.size(); index++) {
			BRF069_SUMMARY_D_ENTITY BRF069 = T4Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF069.getR5_col1() == null) ? "0" : BRF069.getR5_col1().toString();
				cell.setCellValue(value);
			}
			Cell cell1 = row.getCell(3);
			if (cell1 != null) {
				String value1 = (BRF069.getR5_col2() == null) ? "0" : BRF069.getR5_col2().toString();
				cell1.setCellValue(value1);
			}

			Cell cell2 = row.getCell(4);
			if (cell2 != null) {
				String value2 = (BRF069.getR5_col3() == null) ? "0" : BRF069.getR5_col3().toString();
				cell2.setCellValue(value2);
			}

			Cell cell3 = row.getCell(5);
			if (cell3 != null) {
				String value3 = (BRF069.getR5_col4() == null) ? "0" : BRF069.getR5_col4().toString();
				cell3.setCellValue(value3);
			}

			Cell cell4 = row.getCell(6);
			if (cell4 != null) {
				String value4 = (BRF069.getR5_col5() == null) ? "0" : BRF069.getR5_col5().toString();
				cell4.setCellValue(value4);
			}

			Date date = BRF069.getR5_col6(); // Get the date value
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Create a date format

			Cell cell5 = row.getCell(7);
			if (cell5 != null) {
				if (date == null) {
					cell5.setCellValue("dd-MM-yyyy"); // Set a default date if null
				} else {
					cell5.setCellValue(dateFormat.format(date)); // Set the formatted date in the cell
				}
			}

			Cell cell6 = row.getCell(8);
			if (cell6 != null) {
				String value6 = (BRF069.getR5_col7() == null) ? "0" : BRF069.getR5_col7().toString();
				cell6.setCellValue(value6);
			}

			Cell cell7 = row.getCell(9);
			if (cell7 != null) {
				String value7 = (BRF069.getR5_col8() == null) ? "0" : BRF069.getR5_col8().toString();
				cell7.setCellValue(value7);
			}

			Cell cell8 = row.getCell(10);
			if (cell8 != null) {
				String value8 = (BRF069.getR5_col9() == null) ? "0" : BRF069.getR5_col9().toString();
				cell8.setCellValue(value8);
			}

			Cell cell9 = row.getCell(11);
			if (cell9 != null) {
				String value9 = (BRF069.getR5_col10() == null) ? "0" : BRF069.getR5_col10().toString();
				cell9.setCellValue(value9);
			}
		}
	}

	public String detailChanges69(BRF69_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF69_DETAIL_ENTITY> Brf69detail = brf69_detailrepo.findById(foracid);

			if (Brf69detail.isPresent()) {
				BRF69_DETAIL_ENTITY BRFdetail = Brf69detail.get();

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
					brf69_detailrepo.save(BRFdetail);

//					hs.saveOrUpdate(detail);
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

	/****
	 * ARCH SUMMARY
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView getArchieveBRF069View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF69_SUMMARY_A_ENTITY> T1rep = new ArrayList<BRF69_SUMMARY_A_ENTITY>();
		// Query<Object[]> qr;

		List<BRF69_SUMMARY_A_ENTITY> T1Master = new ArrayList<BRF69_SUMMARY_A_ENTITY>();
		List<BRF069_SUMMARY_B_ENTITY> T2Master = new ArrayList<BRF069_SUMMARY_B_ENTITY>();
		List<BRF069_SUMMARY_C_ENTITY> T3Master = new ArrayList<BRF069_SUMMARY_C_ENTITY>();
		List<BRF069_SUMMARY_D_ENTITY> T4Master = new ArrayList<BRF069_SUMMARY_D_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF69_SUMMARY_A_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF69_SUMMARY_A_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
			T2Master = hs.createQuery("from BRF069_SUMMARY_B_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF069_SUMMARY_B_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
			T3Master = hs.createQuery("from BRF069_SUMMARY_C_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF069_SUMMARY_C_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
			T4Master = hs.createQuery("from BRF069_SUMMARY_D_ENTITY a where a.report_date = ?1 order by srl_no",
					BRF069_SUMMARY_D_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF69ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary3", T4Master);
		mv.addObject("reportsummary2", T3Master);
		mv.addObject("reportsummary1", T2Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
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

	public ModelAndView ARCHgetBRF069currentDtl(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable, String filter) throws ParseException {

		System.out.println("entering arch detail");
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<Object> T1Dt1 = new ArrayList<Object>();
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			if (!filter.equals("null")) {
				System.out.println("value 1 entered");
				qr = hs.createNativeQuery("select * from BRF069_ARCH_DETAIL");
				// qr.setParameter(2, filter);
			} else {
				System.out.println("value 2 entered");
				qr = hs.createNativeQuery("select * from BRF069_ARCH_DETAIL");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF069_ARCH_DETAIL  where report_date = ?1");
		}
		List<BRF069_ARCH_DETAIL_ENTITY> T1Master = new ArrayList<BRF069_ARCH_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF069_ARCH_DETAIL_ENTITY a where a.report_date = ?1",
					BRF069_ARCH_DETAIL_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();
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

			BRF069_ARCH_DETAIL_ENTITY py = new BRF069_ARCH_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc,
					act_balance_amt_lc, acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp,
					cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector,
					sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
					purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
					modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status,
					report_date, maturity_date, version, remarks);

			T1Dt1.add(py);

		}

		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		System.out.println("value 3 entered");

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("RR" + "/" + "BRF69ARCH::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String ModifyReport(YourFormData formData, String userId, HttpServletRequest req) {
		String msg = "";

		List<BRF69_SUMMARY_A_ENTITY> existingReports = brf69_SUMMARY_A_REP
				.getBRF069reportService(formData.getFrom_date());
		List<BRF69_SUMMARY_A_ENTITY> userData = formData.getBrf69_REPORTENTITY();

		List<BRF069_SUMMARY_B_ENTITY> existingReports1 = brf069_SUMMARY_B_REP
				.getBRF069reportService1(formData.getFrom_date());
		List<BRF069_SUMMARY_B_ENTITY> userData1 = formData.getBrf069_SUMMARY_2_ENTITY();

		List<BRF069_SUMMARY_C_ENTITY> existingReports2 = brf069_SUMMARY_C_REP
				.getBRF069reportService(formData.getFrom_date());
		List<BRF069_SUMMARY_C_ENTITY> userData2 = formData.getBrf069_SUMMARY_3_ENTITY();

		List<BRF069_SUMMARY_D_ENTITY> existingReports3 = brf069_SUMMARY_D_REP
				.getBRF069reportService(formData.getFrom_date());
		List<BRF069_SUMMARY_D_ENTITY> userData3 = formData.getBrf069_SUMMARY_4_ENTITY();

		List<String> oldValues = new ArrayList<>();
		List<String> newValues = new ArrayList<>();
		List<String> fieldNames = new ArrayList<>();

		List<String> finaloldval = new ArrayList<>();

		for (BRF69_SUMMARY_A_ENTITY userdatas : userData) {
		    boolean found = false;
		    for (BRF69_SUMMARY_A_ENTITY exiting : existingReports) {
		        if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
		            found = true;
		            break;
		        }
		    }
		    if (!found) {
		        finaloldval.add(userdatas.toString());
		    }
		}
		
		for (BRF069_SUMMARY_B_ENTITY userdatas : userData1) {
		    boolean found = false;
		    for (BRF069_SUMMARY_B_ENTITY exiting : existingReports1) {
		        if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
		            found = true;
		            break;
		        }
		    }
		    if (!found) {
		        finaloldval.add(userdatas.toString());
		    }
		}
		
		for (BRF069_SUMMARY_C_ENTITY userdatas : userData2) {
		    boolean found = false;
		    for (BRF069_SUMMARY_C_ENTITY exiting : existingReports2) {
		        if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
		            found = true;
		            break;
		        }
		    }
		    if (!found) {
		        finaloldval.add(userdatas.toString());
		    }
		}
		
		for (BRF069_SUMMARY_D_ENTITY userdatas : userData3) {
		    boolean found = false;
		    for (BRF069_SUMMARY_D_ENTITY exiting : existingReports3) {
		        if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
		            found = true;
		            break;
		        }
		    }
		    if (!found) {
		        finaloldval.add(userdatas.toString());
		    }
		}
		
		int editedRowsCount = 0; // Initialize counter for edited rows

		// For BRF69_SUMMARY_A_ENTITY
		for (int i = 0; i < existingReports.size(); i++) {
			BRF69_SUMMARY_A_ENTITY existingReport = existingReports.get(i);
			BRF69_SUMMARY_A_ENTITY userReport = userData.get(i);

			StringBuilder oldChange = new StringBuilder();
			StringBuilder newChange = new StringBuilder();
			boolean rowEdited = false; // Flag to track if the row has any changes

			// Compare each field and record changes for old and new values with field names
			if (!Objects.equals(existingReport.getR1_col1(), userReport.getR1_col1())) {
				fieldNames.add("Title");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col1()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col1()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col2(), userReport.getR1_col2())) {
				fieldNames.add("Gender");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col2()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col2()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col3(), userReport.getR1_col3())) {
				fieldNames.add("1. BOARD OF DIRECTORS - Names");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col3()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col3()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col4(), userReport.getR1_col4())) {
				fieldNames.add("Nominating institution (if applicable)");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col4()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col4()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col5(), userReport.getR1_col5())) {
				fieldNames.add("Nationality");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col5()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col5()).append(" ");
				rowEdited = true;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

			// Convert both date fields to strings in the "yyyy-MM-dd HH:mm:ss.S" format for
			// comparison
			if (!sdf.format(existingReport.getR1_col6()).equals(sdf.format(userReport.getR1_col6()))) {
				fieldNames.add("Date appointed(DD/MM/YYYY)");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(sdf.format(existingReport.getR1_col6())).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(sdf.format(userReport.getR1_col6())).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col7(), userReport.getR1_col7())) {
				fieldNames.add("Number of shares held by Individual or nominating entity");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col7()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col7()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col8(), userReport.getR1_col8())) {
				fieldNames.add("% ownership");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col8()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col8()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col9(), userReport.getR1_col9())) {
				fieldNames.add("Year to date No. of meetings held");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col9()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col9()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_col10(), userReport.getR1_col10())) {
				fieldNames.add("Year to date No. of meetings attended");
				oldChange.append("BRF69_SUMMARYTABLE_A : ").append(existingReport.getR1_col10()).append(" ");
				newChange.append("BRF69_SUMMARYTABLE_A : ").append(userReport.getR1_col10()).append(" ");
				rowEdited = true;
			}

			// If any changes were detected, save the changes with a row identifier
			if (rowEdited) {
				editedRowsCount++;
				String rowIdentifier = "Row " + (i + 1);
				oldValues.add(rowIdentifier + " - " + oldChange.toString().trim());
				newValues.add(rowIdentifier + " - " + newChange.toString().trim());

				// Here, save the updated report for each row in the database
				// Example: yourRepository.save(userReport);
			}
		}

		// Display the number of rows edited
		System.out.println("Number of rows edited: " + editedRowsCount);

		// For BRF069_SUMMARY_B_ENTITY
		for (int i = 0; i < existingReports1.size(); i++) {
			BRF069_SUMMARY_B_ENTITY existingReport = existingReports1.get(i);
			BRF069_SUMMARY_B_ENTITY userReport = userData1.get(i);

			StringBuilder oldChange1 = new StringBuilder();
			StringBuilder newChange1 = new StringBuilder();
			boolean rowEdited = false; // Flag to track if the row has any changes

			// Compare each field and record changes for old and new values along with field
			// names
			if (!Objects.equals(existingReport.getR2_col1(), userReport.getR2_col1())) {
				fieldNames.add("Title");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col1()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col1()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR2_col2(), userReport.getR2_col2())) {
				fieldNames.add("Gender");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col2()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col2()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR2_col3(), userReport.getR2_col3())) {
				fieldNames.add("2. INTERNAL SHARI'A SUPERVISORY COMMITTEE (ISSC) - Names");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col3()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col3()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR2_col5(), userReport.getR2_col5())) {
				fieldNames.add("Nationality");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col5()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col5()).append(" ");
				rowEdited = true;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

			// Convert both date fields to strings in the "yyyy-MM-dd HH:mm:ss.S" format for
			// comparison
			if (!sdf.format(existingReport.getR2_col6()).equals(sdf.format(userReport.getR2_col6()))) {
				fieldNames.add("Date appointed(DD/MM/YYYY)");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(sdf.format(existingReport.getR2_col6()))
						.append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(sdf.format(userReport.getR2_col6())).append(" ");
				rowEdited = true;
			}

			if (!Objects.equals(existingReport.getR2_col7(), userReport.getR2_col7())) {
				fieldNames.add("Age");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col7()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col7()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR2_col9(), userReport.getR2_col9())) {
				fieldNames.add("Year to date No. of meetings held");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col9()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col9()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR2_col10(), userReport.getR2_col10())) {
				fieldNames.add("Year to date No. of meetings attended");
				oldChange1.append("BRF69_SUMMARYTABLE_B : ").append(existingReport.getR2_col10()).append(" ");
				newChange1.append("BRF69_SUMMARYTABLE_B : ").append(userReport.getR2_col10()).append(" ");
				rowEdited = true;
			}

			// If any changes were detected, save the changes with a row identifier
			if (rowEdited) {
				editedRowsCount++;
				String rowIdentifier = "Row " + (i + 1);
				oldValues.add(rowIdentifier + " - " + oldChange1.toString().trim());
				newValues.add(rowIdentifier + " - " + newChange1.toString().trim());

				// Here, save the updated report for each row in the database
				// Example: yourRepository.save(userReport);
			}
		}

		// For BRF069_SUMMARY_C_ENTITY
		for (int i = 0; i < existingReports2.size(); i++) {
			BRF069_SUMMARY_C_ENTITY existingReport = existingReports2.get(i);
			BRF069_SUMMARY_C_ENTITY userReport = userData2.get(i);

			StringBuilder oldChange2 = new StringBuilder();
			StringBuilder newChange2 = new StringBuilder();
			boolean rowEdited = false; // Flag to track if the row has any changes

			// Compare each field and record changes for old and new values along with field
			// names
			if (!Objects.equals(existingReport.getR3_col1(), userReport.getR3_col1())) {
				fieldNames.add("Title");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col1()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col1()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR3_col2(), userReport.getR3_col2())) {
				fieldNames.add("Gender");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col2()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col2()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR3_col3(), userReport.getR3_col3())) {
				fieldNames.add("3. MAJOR SHAREHOLDERS - Name of Individual or group");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col3()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col3()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR3_col4(), userReport.getR3_col4())) {
				fieldNames.add("Face value in AED Mln");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col4()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col4()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR3_col5(), userReport.getR3_col5())) {
				fieldNames.add("Nationality");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col5()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col5()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR3_col6(), userReport.getR3_col6())) {
				fieldNames.add("% age ownership");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col6()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col6()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR3_col7(), userReport.getR3_col7())) {
				fieldNames.add("Specify the names of other group companies holding shares, with % of holding, if any");
				oldChange2.append("BRF69_SUMMARYTABLE_C : ").append(existingReport.getR3_col7()).append(" ");
				newChange2.append("BRF69_SUMMARYTABLE_C : ").append(userReport.getR3_col7()).append(" ");
				rowEdited = true;
			}
			// (Add other columns similarly, if needed)

			// If any changes were detected, save the changes with a row identifier
			if (rowEdited) {
				editedRowsCount++;
				String rowIdentifier = "Row " + (i + 1);
				oldValues.add(rowIdentifier + " - " + oldChange2.toString().trim());
				newValues.add(rowIdentifier + " - " + newChange2.toString().trim());

				// Here, save the updated report for each row in the database
				// Example: yourRepository.save(userReport);
			}
		}

		// For BRF069_SUMMARY_D_ENTITY
		for (int i = 0; i < existingReports3.size(); i++) {
			BRF069_SUMMARY_D_ENTITY existingReport = existingReports3.get(i);
			BRF069_SUMMARY_D_ENTITY userReport = userData3.get(i);

			StringBuilder oldChange3 = new StringBuilder();
			StringBuilder newChange3 = new StringBuilder();
			boolean rowEdited = false; // Flag to track if the row has any changes

			// Compare each field and record changes for old and new values along with field
			// names
			if (!Objects.equals(existingReport.getR5_col1(), userReport.getR5_col1())) {
				fieldNames.add("Title");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col1()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col1()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR5_col2(), userReport.getR5_col2())) {
				fieldNames.add("Gender");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col2()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col2()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR5_col3(), userReport.getR5_col3())) {
				fieldNames.add("4. KEY SENIOR MANAGEMENT");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col3()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col3()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR5_col4(), userReport.getR5_col4())) {
				fieldNames.add("Name");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col4()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col4()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR5_col5(), userReport.getR5_col5())) {
				fieldNames.add("Nationality");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col5()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col5()).append(" ");
				rowEdited = true;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

			// Convert both date fields to strings in the "yyyy-MM-dd HH:mm:ss.S" format for
			// comparison
			if (!sdf.format(existingReport.getR5_col6()).equals(sdf.format(userReport.getR5_col6()))) {
				fieldNames.add("Date appointed(DD/MM/YYYY)");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(sdf.format(existingReport.getR5_col6()))
						.append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(sdf.format(userReport.getR5_col6())).append(" ");
				rowEdited = true;
			}

			if (!Objects.equals(existingReport.getR5_col7(), userReport.getR5_col7())) {
				fieldNames.add("Age");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col7()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col7()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR5_col8(), userReport.getR5_col8())) {
				fieldNames.add("Central Bank Approval Ref No:");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col8()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col8()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR5_col9(), userReport.getR5_col9())) {
				fieldNames.add("Email address");
				oldChange3.append("BRF69_SUMMARYTABLE_D : ").append(existingReport.getR5_col9()).append(" ");
				newChange3.append("BRF69_SUMMARYTABLE_D : ").append(userReport.getR5_col9()).append(" ");
				rowEdited = true;
			}
			// (Add other columns similarly, if needed)

			// If any changes were detected, save the changes with a row identifier
			if (rowEdited) {
				editedRowsCount++;
				String rowIdentifier = "Row " + (i + 1);
				oldValues.add(rowIdentifier + " - " + oldChange3.toString().trim());
				newValues.add(rowIdentifier + " - " + newChange3.toString().trim());

				// Here, save the updated report for each row in the database
				// Example: yourRepository.save(userReport);
			}
		}

		if (Objects.nonNull(userData) && !userData.isEmpty()) {
			List<BRF69_SUMMARY_A_ENTITY> updatedReports = new ArrayList<>();
			for (BRF69_SUMMARY_A_ENTITY entity : userData) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(formData.getFrom_date());
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf69_SUMMARY_A_REP.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData1) && !userData1.isEmpty()) {
			List<BRF069_SUMMARY_B_ENTITY> updatedReports = new ArrayList<>();
			for (BRF069_SUMMARY_B_ENTITY entity : userData1) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(formData.getFrom_date());
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf069_SUMMARY_B_REP.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData2) && !userData2.isEmpty()) {
			List<BRF069_SUMMARY_C_ENTITY> updatedReports = new ArrayList<>();
			for (BRF069_SUMMARY_C_ENTITY entity : userData2) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(formData.getFrom_date());
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf069_SUMMARY_C_REP.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData3) && !userData3.isEmpty()) {
			List<BRF069_SUMMARY_D_ENTITY> updatedReports = new ArrayList<>();
			for (BRF069_SUMMARY_D_ENTITY entity : userData3) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(formData.getFrom_date());
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf069_SUMMARY_D_REP.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		String auditID = sequence.generateRequestUUId();
		String user1 = (String) req.getSession().getAttribute("USERID");
		String username = (String) req.getSession().getAttribute("USERNAME");

		if (existingReports.size() == userData.size() && existingReports1.size() == userData1.size()
				&& existingReports2.size() == userData2.size() && existingReports3.size() == userData3.size()) {
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFY");
			audit.setAudit_table("BRF69_SUMMARYTABLE");
			audit.setAudit_screen("MODIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setOld_value(String.join("; ", oldValues));
			audit.setNew_value(String.join("; ", newValues));
			audit.setField_name(String.join("; ", fieldNames));
			audit.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);
			mANUAL_Service_Rep.save(audit);
		} else {
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("ADD");
			audit.setAudit_table("BRF69_SUMMARYTABLE");
			audit.setAudit_screen("ADD");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setNew_value(String.join("; ", finaloldval));
			audit.setRemarks("Added Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);
			mANUAL_Service_Rep.save(audit);
		}
		return msg;
	}

	public String verify69Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";

		List<BRF69_SUMMARY_A_ENTITY> existingReports = brf69_SUMMARY_A_REP.getBRF069reportService(asondate);
		List<BRF069_SUMMARY_B_ENTITY> existingReports1 = brf069_SUMMARY_B_REP.getBRF069reportService1(asondate);
		List<BRF069_SUMMARY_C_ENTITY> existingReports2 = brf069_SUMMARY_C_REP.getBRF069reportService(asondate);
		List<BRF069_SUMMARY_D_ENTITY> existingReports3 = brf069_SUMMARY_D_REP.getBRF069reportService(asondate);

		if (Objects.nonNull(existingReports) && !existingReports.isEmpty()) {
			List<BRF69_SUMMARY_A_ENTITY> updatedReports = new ArrayList<>();
			for (BRF69_SUMMARY_A_ENTITY entity : existingReports) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf69_SUMMARY_A_REP.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports1) && !existingReports1.isEmpty()) {
			List<BRF069_SUMMARY_B_ENTITY> updatedReports = new ArrayList<>();
			for (BRF069_SUMMARY_B_ENTITY entity : existingReports1) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf069_SUMMARY_B_REP.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports2) && !existingReports2.isEmpty()) {
			List<BRF069_SUMMARY_C_ENTITY> updatedReports = new ArrayList<>();
			for (BRF069_SUMMARY_C_ENTITY entity : existingReports2) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf069_SUMMARY_C_REP.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports3) && !existingReports3.isEmpty()) {
			List<BRF069_SUMMARY_D_ENTITY> updatedReports = new ArrayList<>();
			for (BRF069_SUMMARY_D_ENTITY entity : existingReports3) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf069_SUMMARY_D_REP.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		String auditID = sequence.generateRequestUUId();
		String user1 = (String) req.getSession().getAttribute("USERID");
		String username = (String) req.getSession().getAttribute("USERNAME");

		MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
		audit.setAudit_date(new Date());
		audit.setEntry_time(new Date());
		audit.setEntry_user(user1);
		audit.setFunc_code("VERIFY");
		audit.setAudit_table("BRF69_SUMMARYTABLE");
		audit.setAudit_screen("VERIFY");
		audit.setEvent_id(user1);
		audit.setEvent_name(username);
		audit.setRemarks("Verify Successfully");

		UserProfile values1 = userProfileRep.getRole(user1);
		audit.setAuth_user(values1.getAuth_user());
		audit.setAuth_time(values1.getAuth_time());
		audit.setAudit_ref_no(auditID);
		mANUAL_Service_Rep.save(audit);
		return msg;
	}
}
