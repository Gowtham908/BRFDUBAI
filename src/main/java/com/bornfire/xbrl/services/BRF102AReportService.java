package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
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
import java.io.FileOutputStream;

import javax.sql.DataSource;

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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bornfire.xbrl.entities.BRBS.BRF102AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF102_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF102_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF102_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF102_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF102_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF102_REP;
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
public class BRF102AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF102AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF102AServiceRepo brf102aServiceRepo;

	@Autowired
	BRF102_DetailRep brf102Detailrep;

	@Autowired
	BRF102_ENTITY_REP brf102_entity_rep;

	@Autowired
	BRF102_REP brf102_rep;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF102A(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF102_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF102_Entity a ").getSingleResult();
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

	public ModelAndView getBRF102AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF102_Entity> T1rep = new ArrayList<BRF102_Entity>();
		// Query<Object[]> qr;

		List<BRF102_Entity> T1Master = new ArrayList<BRF102_Entity>();

		try {
			Date d1 = df.parse(todate);
			List<Object[]> T1Master1 = brf102_entity_rep.findllvalues(todate);

			for (Object[] BRF102_Entity : T1Master1) {

				BRF102_Entity BRF102 = new BRF102_Entity();
				System.out.println(BRF102_Entity[0]);

				BRF102.setCustomer_name(BRF102_Entity[0] != null ? String.valueOf(BRF102_Entity[0]) : null);
				BRF102.setAccount_number(BRF102_Entity[1] != null ? String.valueOf(BRF102_Entity[1]) : null);
				BRF102.setCustomer_last(BRF102_Entity[2] != null ? String.valueOf(BRF102_Entity[2]) : null);
				BRF102.setBank_branch_name(BRF102_Entity[3] != null ? String.valueOf(BRF102_Entity[3]) : null);
				BRF102.setAccount_type(BRF102_Entity[4] != null ? String.valueOf(BRF102_Entity[4]) : null);

				Date lastTransactionDate = BRF102_Entity[5] != null ? (Date) BRF102_Entity[5] : null;
				BRF102.setLast_transaction_date(lastTransactionDate);

				Date lastCommunicationDate = BRF102_Entity[6] != null ? (Date) BRF102_Entity[6] : null;
				BRF102.setLast_communication_date(lastCommunicationDate);

				BigDecimal accountBalance = BRF102_Entity[7] != null ? (BigDecimal) BRF102_Entity[7] : BigDecimal.ZERO;
				BRF102.setAccount_balance(accountBalance);

				BRF102.setCurrency(BRF102_Entity[8] != null ? String.valueOf(BRF102_Entity[8]) : null);

				BigDecimal interestRateApplicable = BRF102_Entity[9] != null ? (BigDecimal) BRF102_Entity[9]
						: BigDecimal.ZERO;
				BRF102.setInterest_rate_applicable(interestRateApplicable);

				BRF102.setType_customer_id(BRF102_Entity[10] != null ? String.valueOf(BRF102_Entity[10]) : null);

				Date idExpiryDate = BRF102_Entity[11] != null ? (Date) BRF102_Entity[11] : null;
				BRF102.setId_expiry_date(idExpiryDate);

				T1Master.add(BRF102);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF102");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("modify_flg", T1rep.size() > 0 ? T1rep.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1rep.size() > 0 ? T1rep.get(0).getModify_user() : null);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF102ADetails(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF102_DETAILTABLE a where report_date = ?1 and report_label_1 =?2");
				qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF102_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF102_DETAILTABLE  where report_date = ?1");
		}
		List<BRF102_DETAIL_ENTITY> T1Master = new ArrayList<BRF102_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF102_DETAIL_ENTITY a where a.report_date = ?1", BRF102_DETAIL_ENTITY.class)
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
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];

			BRF102_DETAIL_ENTITY py = new BRF102_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks);

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

		mv.setViewName("RR/BRF102");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF102A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "011-BRF-102-A";
		File outputFile = null;

		logger.info("Getting Output file :" + reportId);

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF102_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF102.jrxml");
					}

					JasperReport jr = JasperCompileManager.compileReport(jasperFile);
					HashMap<String, Object> map = new HashMap<>();
					logger.info("Assigning Parameters for Jasper");
					map.put("REPORT_DATE", todate);

					JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());

					if (filetype.equals("pdf")) {
						fileName += ".pdf";
						path += fileName;
						JasperExportManager.exportReportToPdfFile(jp, path);
						logger.info("PDF File exported");
					} else {
						fileName += ".xlsx";
						path += fileName;
						JRXlsxExporter exporter = new JRXlsxExporter();
						exporter.setExporterInput(new SimpleExporterInput(jp));
						exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
						exporter.exportReport();
						logger.info("Excel File exported");
					}

				} catch (Exception e) {
					logger.error("Error occurred during report generation", e);
					throw new RuntimeException("Error during report generation", e);
				}

				outputFile = new File(path);
				return outputFile;
			} else {
				try {
					List<Object[]> T1Master1 = brf102_entity_rep.findllvalues(todate);

					if (T1Master1.isEmpty()) {
						logger.warn("No data found for the specified date.");
						return null; // Return null or handle this case as per your requirement
					}

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-102-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					int startRow = 7; // Starting row index
					for (int index = 0; index < T1Master1.size(); index++) {
						Object[] brf102 = T1Master1.get(index);
						Row row = sheet.getRow(startRow + index);
						if (row == null) {
							row = sheet.createRow(startRow + index);
						}
						// CUSTOMER NAME
						Cell cell2 = row.getCell(2);
						if (cell2 == null) {
							cell2 = row.createCell(2);
						}
						cell2.setCellValue(brf102[0] == null ? "0" : brf102[0].toString());

						// ACCOUNT NUMBER
						Cell cell3 = row.getCell(3);
						if (cell3 == null) {
							cell3 = row.createCell(3);
						}
						cell3.setCellValue(brf102[1] == null ? "0" : brf102[1].toString());

						// CUSTOMER LAST
						Cell cell4 = row.getCell(4);
						if (cell4 == null) {
							cell4 = row.createCell(4);
						}
						cell4.setCellValue(brf102[2] == null ? "NA" : brf102[2].toString());

						// BANK BRANCH NAME
						Cell cell5 = row.getCell(5);
						if (cell5 == null) {
							cell5 = row.createCell(5);
						}
						cell5.setCellValue(brf102[3] == null ? "NA" : brf102[3].toString());

						// ACCOUNT TYPE
						Cell cell6 = row.getCell(6);
						if (cell6 == null) {
							cell6 = row.createCell(6);
						}
						cell6.setCellValue(brf102[4] == null ? "NA" : brf102[4].toString());

						// LAST TRANSACTION DATE
						Cell cell7 = row.getCell(7);
						if (cell7 == null) {
							cell7 = row.createCell(7);
						}
						cell7.setCellValue(brf102[5] == null ? "NA" : dateFormat.format((Date) brf102[5]));

						// LAST COMM DATE
						Cell cell8 = row.getCell(8);
						if (cell8 == null) {
							cell8 = row.createCell(8);
						}
						cell8.setCellValue(brf102[6] == null ? "NA" : dateFormat.format((Date) brf102[6]));

						// ACCOUNT BALANCE
						Cell cell9 = row.getCell(9);
						if (cell9 == null) {
							cell9 = row.createCell(9);
						}
						cell9.setCellValue(brf102[7] == null ? 0 : ((BigDecimal) brf102[7]).doubleValue());

						// CURRENCY
						Cell cell10 = row.getCell(10);
						if (cell10 == null) {
							cell10 = row.createCell(10);
						}
						cell10.setCellValue(brf102[8] == null ? "NA" : brf102[8].toString());

						// INTEREST RATE APPLICABLE
						Cell cell11 = row.getCell(11);
						if (cell11 == null) {
							cell11 = row.createCell(11);
						}
						cell11.setCellValue(brf102[9] == null ? 0 : ((BigDecimal) brf102[9]).doubleValue());

						// TYPE CUSTOMER ID
						Cell cell12 = row.getCell(12);
						if (cell12 == null) {
							cell12 = row.createCell(12);
						}
						cell12.setCellValue(brf102[10] == null ? "NA" : brf102[10].toString());

						// ID EXPIRY DATE
						Cell cell13 = row.getCell(13);
						if (cell13 == null) {
							cell13 = row.createCell(13);
						}
						cell13.setCellValue(brf102[11] == null ? "NA" : brf102[11].toString());
					}
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					try (FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-102-A.xls")) {
						workbook.write(fileOut);
						logger.info("File saved successfully at: " + env.getProperty("output.exportpathfinal")
								+ "011-BRF-102-A.xls");
					}

					workbook.close();

				} catch (Exception e) {
					logger.error("Error occurred during Excel file processing", e);
					throw new RuntimeException("Error during Excel file processing", e);
				}
			}
		}

		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-102-A.xls");
		return outputFile;
	}

	/*
	 * public File getFileGENERATION(String reportId, String fromdate, String
	 * todate, String currency, String dtltype, String filetype) throws
	 * FileNotFoundException, JRException, SQLException {
	 * 
	 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); DateFormat
	 * dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
	 * logger.info("GET GENERATION"); System.out.println("generation"+todate);
	 * String path = this.env.getProperty("output.exportpath"); String fileName =
	 * ""; String zipFileName = ""; File outputFile; Date master; String NAME; try {
	 * master = dateFormat.parse(todate); NAME = dateFormat1.format(master);
	 * fileName = "T" + reportId + "_" + NAME; } catch (ParseException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * zipFileName = fileName + ".zip";
	 * 
	 * // String filetype="detailexcel"; // dtltype="report"; try { InputStream
	 * jasperFile; HashMap<String, Object> map = new HashMap<String, Object>();
	 * 
	 * jasperFile = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/Report_main.jasper"); //jasperFile =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T1/T1Previous.jasper"); InputStream subrep01
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/INDEX/RBSINDEX.jasper"); InputStream
	 * subrep02 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/INSTRUCTION/RBSINST.jasper"); InputStream
	 * subrep03 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/INDEX/Contact.jasper"); InputStream subrep1
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T1/T1Previous.jasper"); InputStream subrep2
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T1/T1Curr.jasper"); InputStream subrep3 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T2/T2P.jasper"); InputStream subrep4 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T2/T2C.jasper"); InputStream subrep5 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T3/T3P.jasper"); InputStream subrep6 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T3/T3C.jasper"); InputStream subrep7 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4A_PREVIOUS.jasper"); InputStream
	 * subrep8 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4A_CURRENT.jasper"); InputStream subrep9
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4B_PREVIOUS.jasper"); InputStream
	 * subrep10 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4B_CURRENT.jasper"); InputStream
	 * subrep11 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T5A/T5A.jasper"); InputStream subrep12 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T5A/T5B.jasper"); InputStream subrep13 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T6/T6.jasper"); InputStream subrep14 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T7/T7.jasper"); InputStream subrep15 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T8/T8A.jasper"); InputStream subrep16 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T8/T8B.jasper"); InputStream subrep17 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T9/T9.jasper"); InputStream subrep18 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T10/T10.jasper"); InputStream subrep19 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T11/T11.jasper"); InputStream subrep20 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12A.jasper"); InputStream subrep21 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12B.jasper"); InputStream subrep22 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12C.jasper"); InputStream subrep23 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12D.jasper"); InputStream subrep24 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12E.jasper"); InputStream subrep25 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12F.jasper"); InputStream subrep26 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12G.jasper"); InputStream subrep27 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12H.jasper"); InputStream subrep28 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T13/T13A.jasper"); InputStream subrep29 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T13/T13B.jasper"); InputStream subrep30 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T14/T14A.jasper"); InputStream subrep31 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T14/T14B.jasper"); InputStream subrep32 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T15/T15A.jasper"); InputStream subrep33 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T15/T15B.jasper"); InputStream subrep34 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16A.jasper"); InputStream subrep35 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16B.jasper"); InputStream subrep36 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16C.jasper"); InputStream subrep37 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16D.jasper"); InputStream subrep38 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16E.jasper"); InputStream subrep39 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T17/T17.jasper"); InputStream subrep40 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T18/T18.jasper"); InputStream subrep41 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T19/T19.jasper"); InputStream subrep42 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T20/T20.jasper"); InputStream subrep43 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T21/T21.jasper"); InputStream subrep44 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T22/T22.jasper"); InputStream subrep45 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T23/T23.jasper"); InputStream subrep46 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T24/T24.jasper"); InputStream subrep47 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T25/T25.jasper"); InputStream subrep48 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T26/T26.jasper"); InputStream subrep49 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T27/T27.jasper"); InputStream subrep50 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T28/T28.jasper"); InputStream subrep51 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T29/T29.jasper"); InputStream subrep52 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T30/T30.jasper"); InputStream subrep53 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T31/T31.jasper"); InputStream subrep54 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T32/T32.jasper");
	 * 
	 * map.put("INST", subrep02); map.put("INDEX",subrep01);
	 * map.put("CONTACT",subrep03); map.put("T1P", subrep1); map.put("T1C",
	 * subrep2); map.put("T2P", subrep3); map.put("T2C", subrep4); map.put("T3P",
	 * subrep5); map.put("T3C", subrep6); map.put("T4AP", subrep7); map.put("T4AC",
	 * subrep8); map.put("T4BP", subrep9); map.put("T4BC", subrep10); map.put("T5A",
	 * subrep11); map.put("T5B", subrep12); map.put("T6", subrep13); map.put("T7",
	 * subrep14); map.put("T8A", subrep15); map.put("T8B", subrep16); map.put("T9",
	 * subrep17); map.put("T10", subrep18); map.put("T11", subrep19);
	 * map.put("T12A", subrep20); map.put("T12B", subrep21); map.put("T12C",
	 * subrep22); map.put("T12D", subrep23); map.put("T12E", subrep24);
	 * map.put("T12F", subrep25); map.put("T12G", subrep26); map.put("T12H",
	 * subrep27); map.put("T13A", subrep28); map.put("T13B", subrep29);
	 * map.put("T14A", subrep30); map.put("T14B", subrep31); map.put("T15A",
	 * subrep32); map.put("T15B", subrep33); map.put("T16A", subrep34);
	 * map.put("T16B", subrep35); map.put("T16C", subrep36); map.put("T16D",
	 * subrep37); map.put("T16E", subrep38); map.put("T17", subrep39);
	 * map.put("T18", subrep40); map.put("T19", subrep41); map.put("T20", subrep42);
	 * map.put("T21", subrep43); map.put("T22", subrep44); map.put("T23", subrep45);
	 * map.put("T24", subrep46); map.put("T25", subrep47); map.put("T26", subrep48);
	 * map.put("T27", subrep49); map.put("T28", subrep50); map.put("T29", subrep51);
	 * map.put("T30", subrep52); map.put("T31", subrep53); map.put("T32", subrep54);
	 * try { master = dateFormat.parse(todate); NAME = dateFormat1.format(master);
	 * fileName = "T" + reportId + "_" + NAME; map.put("REPORT_DATE", NAME); } catch
	 * (ParseException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); }
	 * 
	 * logger.info("GET GENERATION ASSIGNING PARAMETER"); JasperReport jr =
	 * (JasperReport) JRLoader.loadObject(jasperFile); fileName = fileName +
	 * ".xlsx"; path += fileName; logger.info("PATH :" +path); JasperPrint jp =
	 * JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
	 * JRXlsxExporter exporter = new JRXlsxExporter(); exporter.setExporterInput(new
	 * SimpleExporterInput(jp)); exporter.setExporterOutput(new
	 * SimpleOutputStreamExporterOutput(path)); exporter.exportReport();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * outputFile = new File(path);
	 * 
	 * return outputFile;
	 * 
	 * }
	 */
	public String detailChanges102(BRF102_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {
			// Get the current Hibernate session
			Session hs = sessionFactory.getCurrentSession();

			// Find the BRF102_DETAIL_ENTITY object by its foracid
			Optional<BRF102_DETAIL_ENTITY> brf102DetailOptional = brf102Detailrep.findById(foracid);

			if (brf102DetailOptional.isPresent()) {
				BRF102_DETAIL_ENTITY brfDetail = brf102DetailOptional.get();
				if (brfDetail != null && report_label_1 != null && report_name_1 != null
						&& report_addl_criteria_1 != null) {
					if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc())
							&& report_label_1.equals(brfDetail.getReport_label_1())
							&& report_name_1.equals(brfDetail.getReport_name_1())
							&& report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
						msg = "No modification done";
					} else {
						// Update the BRF102_DETAIL_ENTITY object with the provided parameters
						brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
						brfDetail.setReport_label_1(report_label_1);
						brfDetail.setReport_name_1(report_name_1);
						brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

						// Save the updated object
						brf102Detailrep.save(brfDetail);

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

	/****
	 * ARCH SUMMARY
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView getArchieveBRF102AView(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF102_Entity> T1rep = new ArrayList<BRF102_Entity>();
		// Query<Object[]> qr;

		List<BRF102_Entity> T1Master = new ArrayList<BRF102_Entity>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			List<Object[]> T1Master1 = brf102_entity_rep.findllvalues(todate);

			for (Object[] BRF102_Entity : T1Master1) {

				BRF102_Entity BRF102 = new BRF102_Entity();
				System.out.println(BRF102_Entity[0]);

				BRF102.setCustomer_name(String.valueOf(BRF102_Entity[0]));

				BRF102.setAccount_number(String.valueOf(BRF102_Entity[1]));

				BRF102.setCustomer_last(String.valueOf(BRF102_Entity[2]));

				BRF102.setBank_branch_name(String.valueOf(BRF102_Entity[3]));

				BRF102.setAccount_type(String.valueOf(BRF102_Entity[4]));

				Date lAST_TRANSACTION_DATE = BRF102_Entity[5] != null ? (Date) BRF102_Entity[5] : null;
				BRF102.setLast_transaction_date(lAST_TRANSACTION_DATE);

				Date lAST_COMMUNICATION_DATE = BRF102_Entity[6] != null ? (Date) BRF102_Entity[6] : null;
				BRF102.setLast_communication_date(lAST_COMMUNICATION_DATE);

				BigDecimal aCCOUNT_BALANCE = BRF102_Entity[7] != null ? (BigDecimal) BRF102_Entity[7]
						: new BigDecimal("0");
				BRF102.setAccount_balance(aCCOUNT_BALANCE);

				BRF102.setCurrency(String.valueOf(BRF102_Entity[8]));

				BigDecimal iNTEREST_RATE_APPLICABLE = BRF102_Entity[9] != null ? (BigDecimal) BRF102_Entity[9]
						: new BigDecimal("0");
				BRF102.setInterest_rate_applicable(iNTEREST_RATE_APPLICABLE);

				BRF102.setType_customer_id(String.valueOf(BRF102_Entity[10]));

				Date iD_EXPIRY_DATE = BRF102_Entity[11] != null ? (Date) BRF102_Entity[12] : null;
				BRF102.setId_expiry_date(iD_EXPIRY_DATE);

				T1Master.add(BRF102);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF102ARCH");
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

	public ModelAndView ARCHgetBRF102AcurrentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery(
						"select * from BRF102_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF102_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF102_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF102_ARCHIVENTITY> T1Master = new ArrayList<BRF102_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF102_ARCHIVENTITY a where a.report_date = ?1", BRF102_ARCHIVENTITY.class)
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
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];

			BRF102_ARCHIVENTITY py = new BRF102_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks);

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

		mv.setViewName("RR" + "/" + "BRF102ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String editbrf102(String account_number, String last_communication_date, String todate)
			throws ParseException {

		List<BRF102_Entity> brf102List = brf102_rep.EditBRF102data(todate, account_number);

		for (BRF102_Entity brf102Entity : brf102List) {
			if (brf102Entity.getAccount_number().equals(account_number)) {
				try {
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					Date date = format1.parse(last_communication_date);
					DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
					String formattedDate = format2.format(date);
					brf102Entity.setLast_communication_date(formattedDate);

					// Save the entity with the updated last_communication_date
					brf102_rep.save(brf102Entity);

					System.out.println("BRF102 entity updated successfully.");
					System.out.println(formattedDate);
				} catch (ParseException e) {

					System.out.println("Error parsing date: " + e.getMessage());
					e.printStackTrace();
				}
			} else {
				System.out
						.println("Account numbers don't match for BRF102 entity: " + brf102Entity.getAccount_number());
			}

		}
		return todate;
	}

	public String verifyBRF102Report(Date asondate, String userId) {
		String msg = "";
		try {
			List<BRF102_Entity> reports = brf102aServiceRepo.getBRF102AReportService(asondate);
			if (reports != null && !reports.isEmpty()) {
				for (BRF102_Entity brf102 : reports) {
					brf102.setModify_flg("N");
					brf102.setVerify_time(new Date());
					brf102.setVerify_user(userId);
					brf102aServiceRepo.save(brf102);
				}
				msg = "Verified Successfully";
			} else {
				msg = "Data Not Found";
			}
		} catch (Exception e) {
			msg = "An error occurred: " + e.getMessage();
		}
		return msg;
	}
}
