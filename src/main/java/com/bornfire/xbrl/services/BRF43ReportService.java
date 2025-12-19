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
import java.util.List;
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

//import com.bornfire.xbrl.entities.BRBS.BRF43_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43A_ENTITY;
//import com.bornfire.xbrl.entities.BRBS.BRF43_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43_DetailRep;
//import com.bornfire.xbrl.entities.BRBS.BRF43_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF43_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF64_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
//import com.bornfire.xbrl.entities.BRBS.BRF43_Entity;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;

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
public class BRF43ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF43ReportService.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	/*
	 * @Autowired BRF43_DetailRep BRF43_DetailRep;
	 */
	@Autowired
	BRF43_DetailRep brf43_detailrepo;

	@Autowired
	BRF43_ENTITY_REP BRF43_ENTITY_REP;

	@Autowired
	Environment env;
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF43A_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF43A_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF43View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF43B_ENTITY> T1rep = new ArrayList<BRF43B_ENTITY>();
		// Query<Object[]> qr;
		List<BRF43A_ENTITY> T1Master1 = new ArrayList<BRF43A_ENTITY>();
		List<Object[]> T1Master = new ArrayList<Object[]>();

		List<BRF43B_ENTITY> CategoryA = new ArrayList<BRF43B_ENTITY>();

		List<BRF43B_ENTITY> CategoryB = new ArrayList<BRF43B_ENTITY>();

		logger.info("Inside archive" + currency);

		// System.out.println(df.parse(todate));

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master1 = hs.createQuery("from BRF43A_ENTITY a where a.report_date = ?1 ", BRF43A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master = BRF43_ENTITY_REP.findllvalues(todate);

			for (Object[] BRF043 : T1Master) {
				System.out.println("Inside loop");
				BRF43B_ENTITY BRF043_ENTITY = new BRF43B_ENTITY();

				/*
				 * BigDecimal funded = (BigDecimal) BRF043[3]; BigDecimal unfunded =
				 * (BigDecimal) BRF043[4]; BigDecimal unusedLimit = (BigDecimal) BRF043[5];
				 */

				/*
				 * if (BRF043[0].equals("Category A (Share broker) ")) { System.out.println("a"
				 * + BRF043[1]); BRF043_ENTITY.setCategorya((String) BRF043[1]);
				 * BRF043_ENTITY.setFunded(((BigDecimal) BRF043[3]));
				 * BRF043_ENTITY.setUnfunded(((BigDecimal) BRF043[4]));
				 * BRF043_ENTITY.setUnused_linmit(((BigDecimal) BRF043[5])); // Calculate total
				 * exposure
				 * 
				 * BigDecimal funded = (BigDecimal) BRF043[3]; BigDecimal unfunded =
				 * (BigDecimal) BRF043[4]; BigDecimal unusedLimit = (BigDecimal) BRF043[5];
				 * 
				 * // Calculate total exposure BigDecimal totalExposure =
				 * funded.add(unfunded).add(unusedLimit);
				 * BRF043_ENTITY.setTotal_exposure(totalExposure);
				 * BRF043_ENTITY.setSecurity_provided((String) BRF043[7]); //
				 * BRF043_ENTITY.setRow_label((String) BRF043[8]); CategoryA.add(BRF043_ENTITY);
				 */
				if (BRF043[0].equals("CATEGORYB")) {
					System.out.println("B" + BRF043[2]);
					BRF043_ENTITY.setCategoryb((String) BRF043[2]);
					BRF043_ENTITY.setFunded((BigDecimal) (BRF043[3] != null ? BRF043[3] : BigDecimal.ZERO));
					BRF043_ENTITY.setUnfunded((BigDecimal) (BRF043[4] != null ? BRF043[4] : BigDecimal.ZERO));
					BRF043_ENTITY.setUnused_limit((BigDecimal) (BRF043[5] != null ? BRF043[5] : BigDecimal.ZERO));
					// Calculate total exposure
					// Ensure you define the funded, unfunded, and unusedLimit variables
					BigDecimal funded = Optional.ofNullable((BigDecimal) BRF043[3]).orElse(BigDecimal.ZERO);
					BigDecimal unfunded = Optional.ofNullable((BigDecimal) BRF043[4]).orElse(BigDecimal.ZERO);
					BigDecimal unusedLimit = Optional.ofNullable((BigDecimal) BRF043[5]).orElse(BigDecimal.ZERO);

					BigDecimal totalExposure = funded.add(unfunded).add(unusedLimit);
					BRF043_ENTITY.setTotal_exposure(totalExposure);
					BRF043_ENTITY.setSecurity_provided((String) (BRF043[7] != null ? BRF043[7] : ""));
					// BRF043_ENTITY.setRow_label((String) BRF043[8]);
					CategoryB.add(BRF043_ENTITY);
				} else {
					System.out.println("Validarion not valid/ values are not present");
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF43");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		// mv.addObject("CategoryA", CategoryA);
		mv.addObject("CategoryB", CategoryB);
		/*
		 * //CAT A mv.addObject("getcatafun", BRF43_ENTITY_REP.getcatafun(todate));
		 * mv.addObject("getcataunfun", BRF43_ENTITY_REP.getcataunfun(todate));
		 * mv.addObject("getcataunlimit", BRF43_ENTITY_REP.getcataunlimit(todate));
		 * mv.addObject("getcatasubtotal", BRF43_ENTITY_REP.getcatasubtotal(todate));
		 */

		// CAT B
		mv.addObject("getcatbfun", BRF43_ENTITY_REP.getcatbfun(todate));
		mv.addObject("getcatbunfun", BRF43_ENTITY_REP.getcatbunfun(todate));
		mv.addObject("getcatbunlimit", BRF43_ENTITY_REP.getcatbunlimit(todate));
		mv.addObject("getcatbsubtotal", BRF43_ENTITY_REP.getcatbsubtotal(todate));

		// GRANT TOTAL
		mv.addObject("getgrandtotalfun", BRF43_ENTITY_REP.getgrandtotalfun(todate));
		mv.addObject("getgrandtotalunfun", BRF43_ENTITY_REP.getgrandtotalunfun(todate));
		mv.addObject("getgrandtotalunlimit", BRF43_ENTITY_REP.getgrandtotalunlimit(todate));
		mv.addObject("getgrandtotal", BRF43_ENTITY_REP.getgrandtotal(todate));
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF043currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF43B_DETAILTABLE  a where report_date = ?1 and report_lable =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF43B_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF43B_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF43_DETAIL_ENTITY> T1Master = new ArrayList<BRF43_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF43_DETAIL_ENTITY a where a.report_date = ?1", BRF43_DETAIL_ENTITY.class)
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

			BRF43_DETAIL_ENTITY py = new BRF43_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF43::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF43(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-043-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF43_DETAIL.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF43_DETAIL.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF43.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF43.jrxml");
						}
					}

					// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

					/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
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
				List<BRF43B_ENTITY> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = BRF43_ENTITY_REP.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-043-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					List<BRF43A_ENTITY> updateSheetRow1To80 = hs
							.createQuery("from BRF43A_ENTITY a where a.report_date = ?1", BRF43A_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (updateSheetRow1To80.size() == 1) {
						for (BRF43A_ENTITY brf206Row1TO471 : updateSheetRow1To80) {

							updateSheetRow1To81(sheet, brf206Row1TO471);

						}
					}

					if (!T1Master1.isEmpty()) {
						int startRow = 16;
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] BRF043 = T1Master1.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							BigDecimal funded = Optional.ofNullable((BigDecimal) BRF043[3]).orElse(BigDecimal.ZERO);
							BigDecimal unfunded = Optional.ofNullable((BigDecimal) BRF043[4]).orElse(BigDecimal.ZERO);
							BigDecimal unusedLimit = Optional.ofNullable((BigDecimal) BRF043[5])
									.orElse(BigDecimal.ZERO);

							BigDecimal totalExposure = funded.add(unfunded).add(unusedLimit);

							// INDENTIFCATION_NUMBER
							Cell cell1 = row.getCell(2);
							if (cell1 == null) {
								cell1 = row.createCell(2);
							}
							cell1.setCellValue(BRF043[2] == null ? "0" : (String) BRF043[2]);

							// ISSUE_NAME
							Cell cell2 = row.getCell(3);
							if (cell2 == null) {
								cell2 = row.createCell(3);
							}
							cell2.setCellValue(BRF043[3] == null ? 0 : ((BigDecimal) BRF043[3]).intValue());

							// ISSUE_TRACKER
							Cell cell3 = row.getCell(4);
							if (cell3 == null) {
								cell3 = row.createCell(4);
							}
							cell3.setCellValue(BRF043[4] == null ? 0 : ((BigDecimal) BRF043[4]).intValue());

							// COUNTRY
							Cell cell4 = row.getCell(5);
							if (cell4 == null) {
								cell4 = row.createCell(5);
							}
							cell4.setCellValue(BRF043[5] == null ? 0 : ((BigDecimal) BRF043[5]).intValue());

							// COUNTRY_PARTY

							Cell cell5 = row.getCell(5); // Assuming column 5 is where you want to place totalExposure
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}
							cell5.setCellValue(totalExposure.doubleValue());

							// AMOUNT
							Cell cell6 = row.getCell(7);
							if (cell6 == null) {
								cell6 = row.createCell(7);
							}
							cell6.setCellValue(BRF043[7] == null ? "0" : (String) BRF043[7]);
						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-043-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-043-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-043-A.xls");

		return outputFile;

	}

	/*
	 * public String detailChanges43(BRF43_DETAIL_ENTITY detail, String foracid,
	 * String report_addl_criteria_1, BigDecimal act_balance_amt_lc, String
	 * report_label_1, String report_name_1) {
	 * 
	 * String msg = "";
	 * 
	 * try {
	 * 
	 * Session hs = sessionFactory.getCurrentSession();
	 * Optional<BRF43_DETAIL_ENTITY> Brf43detail =
	 * BRF43_DetailRep.findById(foracid);
	 * 
	 * if (Brf43detail.isPresent()) { BRF43_DETAIL_ENTITY BRFdetail =
	 * Brf43detail.get(); if (BRFdetail.getReport_label_1().equals(report_label_1)
	 * && BRFdetail.getReport_name_1().equals(report_name_1) &&
	 * BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc) &&
	 * BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)
	 * 
	 * ) { msg = "No modification done"; } else {
	 * 
	 * BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
	 * BRFdetail.setReport_label_1(report_label_1);
	 * BRFdetail.setReport_name_1(report_name_1);
	 * BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
	 * BRF43_DetailRep.save(BRFdetail);
	 * 
	 * // hs.saveOrUpdate(detail); logger.info("Edited Record"); msg =
	 * "Edited Successfully"; } } else { msg = "No data Found"; }
	 * 
	 * } catch (Exception e) {
	 * 
	 * msg = "error occured. Please contact Administrator"; e.printStackTrace(); }
	 * 
	 * return msg; }
	 */
	// TO show thw Archieve values
	public ModelAndView getArchieveBRF043View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF43B_ENTITY> T1rep = new ArrayList<BRF43B_ENTITY>();
		// Query<Object[]> qr;
		List<BRF43A_ENTITY> T1Master1 = new ArrayList<BRF43A_ENTITY>();
		List<Object[]> T1Master = new ArrayList<Object[]>();

		List<BRF43B_ENTITY> CategoryA = new ArrayList<BRF43B_ENTITY>();

		List<BRF43B_ENTITY> CategoryB = new ArrayList<BRF43B_ENTITY>();

		logger.info("Inside archive" + currency);

		// System.out.println(df.parse(todate));

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master1 = hs.createQuery("from BRF43A_ENTITY a where a.report_date = ?1 ", BRF43A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master = BRF43_ENTITY_REP.findllvalues(todate);

			for (Object[] BRF043 : T1Master) {
				System.out.println("Inside loop");
				BRF43B_ENTITY BRF043_ENTITY = new BRF43B_ENTITY();

				/*
				 * BigDecimal funded = (BigDecimal) BRF043[3]; BigDecimal unfunded =
				 * (BigDecimal) BRF043[4]; BigDecimal unusedLimit = (BigDecimal) BRF043[5];
				 */

				/*
				 * if (BRF043[0].equals("Category A (Share broker) ")) { System.out.println("a"
				 * + BRF043[1]); BRF043_ENTITY.setCategorya((String) BRF043[1]);
				 * BRF043_ENTITY.setFunded(((BigDecimal) BRF043[3]));
				 * BRF043_ENTITY.setUnfunded(((BigDecimal) BRF043[4]));
				 * BRF043_ENTITY.setUnused_linmit(((BigDecimal) BRF043[5])); // Calculate total
				 * exposure
				 * 
				 * BigDecimal funded = (BigDecimal) BRF043[3]; BigDecimal unfunded =
				 * (BigDecimal) BRF043[4]; BigDecimal unusedLimit = (BigDecimal) BRF043[5];
				 * 
				 * // Calculate total exposure BigDecimal totalExposure =
				 * funded.add(unfunded).add(unusedLimit);
				 * BRF043_ENTITY.setTotal_exposure(totalExposure);
				 * BRF043_ENTITY.setSecurity_provided((String) BRF043[7]); //
				 * BRF043_ENTITY.setRow_label((String) BRF043[8]); CategoryA.add(BRF043_ENTITY);
				 */
				if (BRF043[0].equals("CATEGORYB")) {
					System.out.println("B" + BRF043[2]);
					BRF043_ENTITY.setCategoryb((String) BRF043[2]);
					BRF043_ENTITY.setFunded((BigDecimal) (BRF043[3] != null ? BRF043[3] : BigDecimal.ZERO));
					BRF043_ENTITY.setUnfunded((BigDecimal) (BRF043[4] != null ? BRF043[4] : BigDecimal.ZERO));
					BRF043_ENTITY.setUnused_limit((BigDecimal) (BRF043[5] != null ? BRF043[5] : BigDecimal.ZERO));
					// Calculate total exposure
					// Ensure you define the funded, unfunded, and unusedLimit variables
					BigDecimal funded = Optional.ofNullable((BigDecimal) BRF043[3]).orElse(BigDecimal.ZERO);
					BigDecimal unfunded = Optional.ofNullable((BigDecimal) BRF043[4]).orElse(BigDecimal.ZERO);
					BigDecimal unusedLimit = Optional.ofNullable((BigDecimal) BRF043[5]).orElse(BigDecimal.ZERO);

					BigDecimal totalExposure = funded.add(unfunded).add(unusedLimit);
					BRF043_ENTITY.setTotal_exposure(totalExposure);
					BRF043_ENTITY.setSecurity_provided((String) (BRF043[7] != null ? BRF043[7] : ""));
					// BRF043_ENTITY.setRow_label((String) BRF043[8]);
					CategoryB.add(BRF043_ENTITY);
				} else {
					System.out.println("Validarion not valid/ values are not present");
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF43ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		// mv.addObject("CategoryA", CategoryA);
		mv.addObject("CategoryB", CategoryB);
		/*
		 * //CAT A mv.addObject("getcatafun", BRF43_ENTITY_REP.getcatafun(todate));
		 * mv.addObject("getcataunfun", BRF43_ENTITY_REP.getcataunfun(todate));
		 * mv.addObject("getcataunlimit", BRF43_ENTITY_REP.getcataunlimit(todate));
		 * mv.addObject("getcatasubtotal", BRF43_ENTITY_REP.getcatasubtotal(todate));
		 */

		// CAT B
		mv.addObject("getcatbfun", BRF43_ENTITY_REP.getcatbfun(todate));
		mv.addObject("getcatbunfun", BRF43_ENTITY_REP.getcatbunfun(todate));
		mv.addObject("getcatbunlimit", BRF43_ENTITY_REP.getcatbunlimit(todate));
		mv.addObject("getcatbsubtotal", BRF43_ENTITY_REP.getcatbsubtotal(todate));

		// GRANT TOTAL
		mv.addObject("getgrandtotalfun", BRF43_ENTITY_REP.getgrandtotalfun(todate));
		mv.addObject("getgrandtotalunfun", BRF43_ENTITY_REP.getgrandtotalunfun(todate));
		mv.addObject("getgrandtotalunlimit", BRF43_ENTITY_REP.getgrandtotalunlimit(todate));
		mv.addObject("getgrandtotal", BRF43_ENTITY_REP.getgrandtotal(todate));
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

	public ModelAndView ARCHgetBRF043currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF43_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF43_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF43_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF43_ARCHIV_ENTITY> T1Master = new ArrayList<BRF43_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF43_ARCHIV_ENTITY a where a.report_date = ?1", BRF43_ARCHIV_ENTITY.class)
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

			BRF43_ARCHIV_ENTITY py = new BRF43_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF43ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges43(BRF43_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {
			// Get the current Hibernate session
			Session hs = sessionFactory.getCurrentSession();

			// Find the BRF43_DETAIL_ENTITY object by its foracid
			Optional<BRF43_DETAIL_ENTITY> brf43DetailOptional = brf43_detailrepo.findById(foracid);

			if (brf43DetailOptional.isPresent()) {
				BRF43_DETAIL_ENTITY brfDetail = brf43DetailOptional.get();
				if (brfDetail != null && report_label_1 != null && report_name_1 != null
						&& report_addl_criteria_1 != null) {
					if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc())
							&& report_label_1.equals(brfDetail.getReport_label_1())
							&& report_name_1.equals(brfDetail.getReport_name_1())
							&& report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
						msg = "No modification done";
					} else {
						// Update the BRF43_DETAIL_ENTITY object with the provided parameters
						brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
						brfDetail.setReport_label_1(report_label_1);
						brfDetail.setReport_name_1(report_name_1);
						brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

						// Save the updated object
						brf43_detailrepo.save(brfDetail);

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

	public void updateSheetRow1To81(Sheet sheet, BRF43A_ENTITY brf96ARow1TO471) {

		Row row9 = sheet.getRow(9);

		Cell row9cell1 = row9.getCell(2);

		if (row9cell1 != null) {
			row9cell1.setCellValue(
					brf96ARow1TO471.getR10_category_a1() == null ? "0" : brf96ARow1TO471.getR10_category_a1());
		}

		Cell row9cell2 = row9.getCell(3);

		if (row9cell2 != null) {
			row9cell2.setCellValue(
					brf96ARow1TO471.getR10_funded() == null ? 0 : brf96ARow1TO471.getR10_funded().intValue());
		}

		Cell row9cell3 = row9.getCell(4);

		if (row9cell3 != null) {
			row9cell3.setCellValue(
					brf96ARow1TO471.getR10_unfunded() == null ? 0 : brf96ARow1TO471.getR10_unfunded().intValue());
		}

		Cell row9cell4 = row9.getCell(5);

		if (row9cell4 != null) {
			row9cell4.setCellValue(brf96ARow1TO471.getR10_unused_limit() == null ? 0
					: brf96ARow1TO471.getR10_unused_limit().intValue());
		}

		Cell row9cell5 = row9.getCell(6);

		if (row9cell5 != null) {
			row9cell4.setCellValue(brf96ARow1TO471.getR10_total_exposure() == null ? 0
					: brf96ARow1TO471.getR10_total_exposure().intValue());
		}

		Cell row9cell6 = row9.getCell(7);

		if (row9cell6 != null) {
			row9cell6.setCellValue(brf96ARow1TO471.getR10_security_provided() == null ? "0"
					: brf96ARow1TO471.getR10_security_provided());
		}

		// Row 10
		Row row10 = sheet.getRow(10);

		Cell row10cell1 = row10.getCell(2);
		if (row10cell1 != null) {
			row10cell1.setCellValue(
					brf96ARow1TO471.getR11_category_a2() == null ? "0" : brf96ARow1TO471.getR11_category_a2());
		}

		Cell row10cell2 = row10.getCell(3);
		if (row10cell2 != null) {
			row10cell2.setCellValue(
					brf96ARow1TO471.getR11_funded() == null ? 0 : brf96ARow1TO471.getR11_funded().intValue());
		}

		Cell row10cell3 = row10.getCell(4);
		if (row10cell3 != null) {
			row10cell3.setCellValue(
					brf96ARow1TO471.getR11_unfunded() == null ? 0 : brf96ARow1TO471.getR11_unfunded().intValue());
		}

		Cell row10cell4 = row10.getCell(5);
		if (row10cell4 != null) {
			row10cell4.setCellValue(brf96ARow1TO471.getR11_unused_limit() == null ? 0
					: brf96ARow1TO471.getR11_unused_limit().intValue());
		}

		Cell row10cell5 = row10.getCell(6);
		if (row10cell5 != null) {
			row10cell5.setCellValue(brf96ARow1TO471.getR11_total_exposure() == null ? 0
					: brf96ARow1TO471.getR11_total_exposure().intValue());
		}

		Cell row10cell6 = row10.getCell(7);
		if (row10cell6 != null) {
			row10cell6.setCellValue(brf96ARow1TO471.getR11_security_provided() == null ? "0"
					: brf96ARow1TO471.getR11_security_provided());
		}

		// Row 11
		Row row11 = sheet.getRow(11);
		if (row11 != null) {
			Cell row11cell1 = row11.getCell(2);
			if (row11cell1 != null) {
				row11cell1.setCellValue(
						brf96ARow1TO471.getR12_category_a3() == null ? "0" : brf96ARow1TO471.getR12_category_a3());
			}

			Cell row11cell2 = row11.getCell(3);
			if (row11cell2 != null) {
				row11cell2.setCellValue(
						brf96ARow1TO471.getR12_funded() == null ? 0 : brf96ARow1TO471.getR12_funded().intValue());
			}

			Cell row11cell3 = row11.getCell(4);
			if (row11cell3 != null) {
				row11cell3.setCellValue(
						brf96ARow1TO471.getR12_unfunded() == null ? 0 : brf96ARow1TO471.getR12_unfunded().intValue());
			}

			Cell row11cell4 = row11.getCell(5);
			if (row11cell4 != null) {
				row11cell4.setCellValue(brf96ARow1TO471.getR12_unused_limit() == null ? 0
						: brf96ARow1TO471.getR12_unused_limit().intValue());
			}

			Cell row11cell5 = row11.getCell(6);
			if (row11cell5 != null) {
				row11cell5.setCellValue(brf96ARow1TO471.getR12_total_exposure() == null ? 0
						: brf96ARow1TO471.getR12_total_exposure().intValue());
			}

			Cell row11cell6 = row11.getCell(7);
			if (row11cell6 != null) {
				row11cell6.setCellValue(brf96ARow1TO471.getR12_security_provided() == null ? "0"
						: brf96ARow1TO471.getR12_security_provided());
			}
		}

		// Row 12
		Row row12 = sheet.getRow(12);
		if (row12 != null) {
			Cell row12cell1 = row12.getCell(2);
			if (row12cell1 != null) {
				row12cell1.setCellValue(
						brf96ARow1TO471.getR12_category_a3() == null ? "0" : brf96ARow1TO471.getR12_category_a3());
			}

			Cell row12cell2 = row12.getCell(3);
			if (row12cell2 != null) {
				row12cell2.setCellValue(
						brf96ARow1TO471.getR12_funded() == null ? 0 : brf96ARow1TO471.getR12_funded().intValue());
			}

			Cell row12cell3 = row12.getCell(4);
			if (row12cell3 != null) {
				row12cell3.setCellValue(
						brf96ARow1TO471.getR12_unfunded() == null ? 0 : brf96ARow1TO471.getR12_unfunded().intValue());
			}

			Cell row12cell4 = row12.getCell(5);
			if (row12cell4 != null) {
				row12cell4.setCellValue(brf96ARow1TO471.getR12_unused_limit() == null ? 0
						: brf96ARow1TO471.getR12_unused_limit().intValue());
			}

			Cell row12cell5 = row12.getCell(6);
			if (row12cell5 != null) {
				row12cell5.setCellValue(brf96ARow1TO471.getR12_total_exposure() == null ? 0
						: brf96ARow1TO471.getR12_total_exposure().intValue());
			}

			Cell row12cell6 = row12.getCell(7);
			if (row12cell6 != null) {
				row12cell6.setCellValue(brf96ARow1TO471.getR12_security_provided() == null ? "0"
						: brf96ARow1TO471.getR12_security_provided());
			}
		}

	}

}
