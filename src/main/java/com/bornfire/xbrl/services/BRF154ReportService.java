
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

import com.bornfire.xbrl.entities.BRBS.BRF154ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF154_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF154_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF154_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF154_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF154_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF47_Entity;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;

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

public class BRF154ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF154ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;

	@Autowired
	Environment env;
	@Autowired
	BRF154_DetailRep BRF154_DetailRep;
	@Autowired
	BRF154_ENTITY_REP BRF154_ENTITY_REP;

	@Autowired
	BRF154ServiceRepo brf154ServiceRepo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF154(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {

			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF154_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF154_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF154View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF154_ENTITY> T1rep = new ArrayList<BRF154_ENTITY>();
		// Query<Object[]> qr;

		List<BRF154_ENTITY> T1Master = new ArrayList<BRF154_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			/*
			 * T1Master = hs.createQuery("from BRF154_ENTITY a where a.report_date = ?1 ",
			 * BRF154_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

			List<Object[]> T1Master1 = BRF154_ENTITY_REP.findllvalues(todate);

			for (Object[] BRF154_ENTITY : T1Master1) {

				BRF154_ENTITY BRF154 = new BRF154_ENTITY();
				System.out.println(BRF154_ENTITY[0]);
				BRF154.setCin_num(BRF154_ENTITY[0] != null ? String.valueOf(BRF154_ENTITY[0]) : "");
				BRF154.setLegal_entity_identifier(BRF154_ENTITY[1] != null ? String.valueOf(BRF154_ENTITY[1]) : "");
				BRF154.setCustomer_name(BRF154_ENTITY[2] != null ? String.valueOf(BRF154_ENTITY[2]) : "");
				BRF154.setCounter_party(BRF154_ENTITY[3] != null ? String.valueOf(BRF154_ENTITY[3]) : "");
				BRF154.setCountry(BRF154_ENTITY[4] != null ? String.valueOf(BRF154_ENTITY[4]) : "");
				BRF154.setCcy1(BRF154_ENTITY[5] != null ? String.valueOf(BRF154_ENTITY[5]) : "");

				BigDecimal os_funded = BRF154_ENTITY[6] != null ? (BigDecimal) BRF154_ENTITY[6] : BigDecimal.ZERO;
				BRF154.setOs_funded(os_funded);

				BRF154.setCcy2(BRF154_ENTITY[7] != null ? String.valueOf(BRF154_ENTITY[7]) : "");

				BigDecimal os_unfunded = BRF154_ENTITY[8] != null ? (BigDecimal) BRF154_ENTITY[8] : BigDecimal.ZERO;
				BRF154.setOs_unfunded(os_unfunded);

				BRF154.setCcy3(BRF154_ENTITY[9] != null ? String.valueOf(BRF154_ENTITY[9]) : "");

				BigDecimal amount = BRF154_ENTITY[10] != null ? (BigDecimal) BRF154_ENTITY[10] : BigDecimal.ZERO;
				BRF154.setAmount(amount);

				BRF154.setType_of_collaterals(BRF154_ENTITY[11] != null ? String.valueOf(BRF154_ENTITY[11]) : "");

				T1Master.add(BRF154);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF154");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF154currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF154B_DETAILTABLE  a where report_date = ?1 and report_label =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF154B_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF154B_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF154_DETAIL_ENTITY> T1Master = new ArrayList<BRF154_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF154_DETAIL_ENTITY a where a.report_date = ?1", BRF154_DETAIL_ENTITY.class)
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

			BRF154_DETAIL_ENTITY py = new BRF154_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF154::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF154(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-154-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF154_DETAIL.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF154_DETAIL.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF154.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF154.jrxml");
						}
					}

					// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

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
				}
				outputFile = new File(path);

				return outputFile;
			} else {
				List<BRF154_ENTITY> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = BRF154_ENTITY_REP.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-154-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					if (!T1Master1.isEmpty()) {
						int startRow = 8; // Starting row index
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] BRF154_ENTITY = T1Master1.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							Cell cell = row.getCell(2);
							if (cell == null) {
								cell = row.createCell(2);
							}

							String value = (BRF154_ENTITY[0] == null) ? "0" : BRF154_ENTITY[0].toString();
							cell.setCellValue(value);

							Cell cell1 = row.getCell(3);
							if (cell1 == null) {
								cell1 = row.createCell(3);
							}
							String value1 = (BRF154_ENTITY[1] == null) ? "0" : BRF154_ENTITY[1].toString();
							cell1.setCellValue(value1);

							Cell cell2 = row.getCell(4);
							if (cell2 == null) {
								cell2 = row.createCell(4);
							}
							String value2 = (BRF154_ENTITY[2] == null) ? "0" : BRF154_ENTITY[1].toString();
							cell2.setCellValue(value2);

							Cell cell3 = row.getCell(5);
							if (cell3 == null) {
								cell3 = row.createCell(5);
							}
							String value3 = (BRF154_ENTITY[3] == null) ? "0" : BRF154_ENTITY[3].toString();
							cell3.setCellValue(value3);

							Cell cell4 = row.getCell(6);
							if (cell4 == null) {
								cell4 = row.createCell(6);
							}
							String value4 = (BRF154_ENTITY[4] == null) ? "0" : BRF154_ENTITY[4].toString();
							cell4.setCellValue(value4);

							Cell cell5 = row.getCell(7);
							if (cell5 == null) {
								cell5 = row.createCell(7);
							}
							String value5 = (BRF154_ENTITY[5] == null) ? "0" : BRF154_ENTITY[5].toString();
							cell5.setCellValue(value5);

							Cell cell6 = row.getCell(8);
							if (cell6 == null) {
								cell6 = row.createCell(8);
							}

							cell6.setCellValue(
									BRF154_ENTITY[6] == null ? 0 : ((BigDecimal) BRF154_ENTITY[6]).intValue());

							Cell cell7 = row.getCell(9);
							if (cell7 == null) {
								cell7 = row.createCell(9);
							}
							String value6 = (BRF154_ENTITY[7] == null) ? "0" : BRF154_ENTITY[7].toString();
							cell7.setCellValue(value6);

							Cell cell8 = row.getCell(10);
							if (cell8 == null) {
								cell8 = row.createCell(10);
							}
							cell8.setCellValue(
									BRF154_ENTITY[8] == null ? 0 : ((BigDecimal) BRF154_ENTITY[8]).intValue());

							Cell cell9 = row.getCell(11);
							if (cell9 == null) {
								cell9 = row.createCell(11);
							}
							String value7 = (BRF154_ENTITY[9] == null) ? "0" : BRF154_ENTITY[9].toString();
							cell9.setCellValue(value7);

							Cell cell10 = row.getCell(12);
							if (cell10 == null) {
								cell10 = row.createCell(12);
							}

							cell10.setCellValue(
									BRF154_ENTITY[10] == null ? 0 : ((BigDecimal) BRF154_ENTITY[10]).intValue());

							Cell cell11 = row.getCell(13);
							if (cell11 == null) {
								cell11 = row.createCell(13);
							}
							String value8 = (BRF154_ENTITY[11] == null) ? "0" : BRF154_ENTITY[11].toString();
							cell11.setCellValue(value8);
						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-154-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-154-A.xls");
						}

						// Close the workbook
						workbook.close();
					} else {
						System.out.println("No data found for the specified date.");
					}

				} catch (ParseException e) {
					e.printStackTrace();
				} catch (EncryptedDocumentException e) {
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-154-A.xls");

		return outputFile;

	}

	public String detailChanges154(BRF154_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {
			// Get the current Hibernate session
			Session hs = sessionFactory.getCurrentSession();

			// Find the BRF154_DETAIL_ENTITY object by its foracid
			Optional<BRF154_DETAIL_ENTITY> brf154DetailOptional = BRF154_DetailRep.findById(foracid);

			if (brf154DetailOptional.isPresent()) {
				BRF154_DETAIL_ENTITY brfDetail = brf154DetailOptional.get();
				if (brfDetail != null && report_label_1 != null && report_name_1 != null
						&& report_addl_criteria_1 != null) {
					if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc())
							&& report_label_1.equals(brfDetail.getReport_label_1())
							&& report_name_1.equals(brfDetail.getReport_name_1())
							&& report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
						msg = "No modification done";
					} else {
						// Update the BRF154_DETAIL_ENTITY object with the provided parameters
						brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
						brfDetail.setReport_label_1(report_label_1);
						brfDetail.setReport_name_1(report_name_1);
						brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

						// Save the updated object
						BRF154_DetailRep.save(brfDetail);

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

	// TO show thw Archieve values
	public ModelAndView getArchieveBRF154View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF154_ENTITY> T1rep = new ArrayList<BRF154_ENTITY>();
		// Query<Object[]> qr;

		List<BRF154_ENTITY> T1Master = new ArrayList<BRF154_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			/*
			 * T1Master = hs.createQuery("from BRF154_ENTITY a where a.report_date = ?1 ",
			 * BRF154_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

			List<Object[]> T1Master1 = BRF154_ENTITY_REP.findllvalues(todate);

			for (Object[] BRF154_ENTITY : T1Master1) {

				BRF154_ENTITY BRF154 = new BRF154_ENTITY();
				System.out.println(BRF154_ENTITY[0]);
				BRF154.setCin_num(BRF154_ENTITY[0] != null ? String.valueOf(BRF154_ENTITY[0]) : "");
				BRF154.setLegal_entity_identifier(BRF154_ENTITY[1] != null ? String.valueOf(BRF154_ENTITY[1]) : "");
				BRF154.setCustomer_name(BRF154_ENTITY[2] != null ? String.valueOf(BRF154_ENTITY[2]) : "");
				BRF154.setCounter_party(BRF154_ENTITY[3] != null ? String.valueOf(BRF154_ENTITY[3]) : "");
				BRF154.setCountry(BRF154_ENTITY[4] != null ? String.valueOf(BRF154_ENTITY[4]) : "");
				BRF154.setCcy1(BRF154_ENTITY[5] != null ? String.valueOf(BRF154_ENTITY[5]) : "");

				BigDecimal os_funded = BRF154_ENTITY[6] != null ? (BigDecimal) BRF154_ENTITY[6] : BigDecimal.ZERO;
				BRF154.setOs_funded(os_funded);

				BRF154.setCcy2(BRF154_ENTITY[7] != null ? String.valueOf(BRF154_ENTITY[7]) : "");

				BigDecimal os_unfunded = BRF154_ENTITY[8] != null ? (BigDecimal) BRF154_ENTITY[8] : BigDecimal.ZERO;
				BRF154.setOs_unfunded(os_unfunded);

				BRF154.setCcy3(BRF154_ENTITY[9] != null ? String.valueOf(BRF154_ENTITY[9]) : "");

				BigDecimal amount = BRF154_ENTITY[10] != null ? (BigDecimal) BRF154_ENTITY[10] : BigDecimal.ZERO;
				BRF154.setAmount(amount);

				BRF154.setType_of_collaterals(BRF154_ENTITY[11] != null ? String.valueOf(BRF154_ENTITY[11]) : "");

				T1Master.add(BRF154);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF154ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
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

	public ModelAndView ARCHgetBRF154currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF154_ARCHIVTABLE a where report_date=?1");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF154_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF154_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF154_ARCHIV_ENTITY> T1Master = new ArrayList<BRF154_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs
					.createQuery("from BRF154_ARCHIV_ENTITY a where a.report_date = ?1", BRF154_ARCHIV_ENTITY.class)
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

			BRF154_ARCHIV_ENTITY py = new BRF154_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF154ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
