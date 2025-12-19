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

import javax.servlet.http.HttpServletRequest;
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

import com.bornfire.xbrl.entities.BRBS.BRF71_ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.BRF300_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF71_DETAIL_ENTITY;
import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.BRF71_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.BRF71_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF71_ENTITY;

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
public class BRF71ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF71ReportService.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;
	@Autowired
	BRF71_ServiceRepo BRF71_ServiceRepo;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	BRF71_DetailRepo brf71_detailrepo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheck(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF71_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF71_ENTITY a").getSingleResult();
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

	public File getFileBRF71(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-071-A";
		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF71_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF71_Detail.jrxml");
						}
					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF71.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF71.jrxml");
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
				}
				outputFile = new File(path);
				return outputFile;
			} else {

				List<BRF71_ENTITY> T1Master = new ArrayList<BRF71_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF71_ENTITY a where a.report_date = ?1 ", BRF71_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF71_ENTITY BRF71 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-071-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);
							Row row = sheet.getRow(8);

							Cell cell0 = row.getCell(3);
							if (cell0 != null) {
								String value = (BRF71.getR2_visa() == null) ? "0" : BRF71.getR2_visa().toString();
								cell0.setCellValue(value);
							}

							Cell cell1 = row.getCell(4);
							if (cell1 != null) {
								String value = (BRF71.getR2_mastercard() == null) ? "0"
										: BRF71.getR2_mastercard().toString();
								cell1.setCellValue(value);
							}

							Cell cell2 = row.getCell(5);
							if (cell2 != null) {
								String value = (BRF71.getR2_amex() == null) ? "0" : BRF71.getR2_amex().toString();
								cell2.setCellValue(value);
							}

							Cell cell3 = row.getCell(6);
							if (cell3 != null) {
								String value = (BRF71.getR2_jcb() == null) ? "0" : BRF71.getR2_jcb().toString();
								cell3.setCellValue(value);
							}

							Cell cell4 = row.getCell(7);
							if (cell4 != null) {
								String value = (BRF71.getR2_diners() == null) ? "0" : BRF71.getR2_diners().toString();
								cell4.setCellValue(value);
							}

							Cell cell5 = row.getCell(8);
							if (cell5 != null) {
								String value = (BRF71.getR2_unionpay() == null) ? "0"
										: BRF71.getR2_unionpay().toString();
								cell5.setCellValue(value);
							}

///////////////////////R3/////////////////////

							Row R3row = sheet.getRow(9);

							Cell R3cell0 = R3row.getCell(3);
							if (R3cell0 != null) {
								String value = (BRF71.getR3_visa() == null) ? "0" : BRF71.getR3_visa().toString();
								R3cell0.setCellValue(value);
							}

							Cell R3cell1 = R3row.getCell(4);
							if (R3cell1 != null) {
								String value = (BRF71.getR3_mastercard() == null) ? "0"
										: BRF71.getR3_mastercard().toString();
								R3cell1.setCellValue(value);
							}

							Cell R3cell2 = R3row.getCell(5);
							if (R3cell2 != null) {
								String value = (BRF71.getR3_amex() == null) ? "0" : BRF71.getR3_amex().toString();
								R3cell2.setCellValue(value);
							}

							Cell R3cell3 = R3row.getCell(6);
							if (R3cell3 != null) {
								String value = (BRF71.getR3_jcb() == null) ? "0" : BRF71.getR3_jcb().toString();
								R3cell3.setCellValue(value);
							}

							Cell R3cell4 = R3row.getCell(7);
							if (R3cell4 != null) {
								String value = (BRF71.getR3_diners() == null) ? "0" : BRF71.getR3_diners().toString();
								R3cell4.setCellValue(value);
							}

							Cell R3cell5 = R3row.getCell(8);
							if (R3cell5 != null) {
								String value = (BRF71.getR3_unionpay() == null) ? "0"
										: BRF71.getR3_unionpay().toString();
								R3cell5.setCellValue(value);
							}

///////////////////////R5/////////////////////

							Row R5row = sheet.getRow(11);

							Cell R5cell0 = R5row.getCell(3);
							if (R5cell0 != null) {
								String value = (BRF71.getR5_visa() == null) ? "0" : BRF71.getR5_visa().toString();
								R5cell0.setCellValue(value);
							}

							Cell R5cell1 = R5row.getCell(4);
							if (R5cell1 != null) {
								String value = (BRF71.getR5_mastercard() == null) ? "0"
										: BRF71.getR5_mastercard().toString();
								R5cell1.setCellValue(value);
							}

							Cell R5cell2 = R5row.getCell(5);
							if (R5cell2 != null) {
								String value = (BRF71.getR5_amex() == null) ? "0" : BRF71.getR5_amex().toString();
								R5cell2.setCellValue(value);
							}

							Cell R5cell3 = R5row.getCell(6);
							if (R5cell3 != null) {
								String value = (BRF71.getR5_jcb() == null) ? "0" : BRF71.getR5_jcb().toString();
								R5cell3.setCellValue(value);
							}

							Cell R5cell4 = R5row.getCell(7);
							if (R5cell4 != null) {
								String value = (BRF71.getR5_diners() == null) ? "0" : BRF71.getR5_diners().toString();
								R5cell4.setCellValue(value);
							}

							Cell R5cell5 = R5row.getCell(8);
							if (R5cell5 != null) {
								String value = (BRF71.getR5_unionpay() == null) ? "0"
										: BRF71.getR5_unionpay().toString();
								R5cell5.setCellValue(value);
							}

///////////////////////R6/////////////////////

							Row R6row = sheet.getRow(12);

							Cell R6cell0 = R6row.getCell(3);
							if (R6cell0 != null) {
								String value = (BRF71.getR6_visa() == null) ? "0" : BRF71.getR6_visa().toString();
								R6cell0.setCellValue(value);
							}

							Cell R6cell1 = R6row.getCell(4);
							if (R6cell1 != null) {
								String value = (BRF71.getR6_mastercard() == null) ? "0"
										: BRF71.getR6_mastercard().toString();
								R6cell1.setCellValue(value);
							}

							Cell R6cell2 = R6row.getCell(5);
							if (R6cell2 != null) {
								String value = (BRF71.getR6_amex() == null) ? "0" : BRF71.getR6_amex().toString();
								R6cell2.setCellValue(value);
							}

							Cell R6cell3 = R6row.getCell(6);
							if (R6cell3 != null) {
								String value = (BRF71.getR6_jcb() == null) ? "0" : BRF71.getR6_jcb().toString();
								R6cell3.setCellValue(value);
							}

							Cell R6cell4 = R6row.getCell(7);
							if (R6cell4 != null) {
								String value = (BRF71.getR6_diners() == null) ? "0" : BRF71.getR6_diners().toString();
								R6cell4.setCellValue(value);
							}

							Cell R6cell5 = R6row.getCell(8);
							if (R6cell5 != null) {
								String value = (BRF71.getR6_unionpay() == null) ? "0"
										: BRF71.getR6_unionpay().toString();
								R6cell5.setCellValue(value);
							}

///////////////////////R8/////////////////////

							Row R8row = sheet.getRow(14);

							Cell R8cell0 = R8row.getCell(3);
							if (R8cell0 != null) {
								String value = (BRF71.getR8_visa() == null) ? "0" : BRF71.getR8_visa().toString();
								R8cell0.setCellValue(value);
							}

							Cell R8cell1 = R8row.getCell(4);
							if (R8cell1 != null) {
								String value = (BRF71.getR8_mastercard() == null) ? "0"
										: BRF71.getR8_mastercard().toString();
								R8cell1.setCellValue(value);
							}

							Cell R8cell2 = R8row.getCell(5);
							if (R8cell2 != null) {
								String value = (BRF71.getR8_amex() == null) ? "0" : BRF71.getR8_amex().toString();
								R8cell2.setCellValue(value);
							}

							Cell R8cell3 = R8row.getCell(6);
							if (R8cell3 != null) {
								String value = (BRF71.getR8_jcb() == null) ? "0" : BRF71.getR8_jcb().toString();
								R8cell3.setCellValue(value);
							}

							Cell R8cell4 = R8row.getCell(7);
							if (R8cell4 != null) {
								String value = (BRF71.getR8_diners() == null) ? "0" : BRF71.getR8_diners().toString();
								R8cell4.setCellValue(value);
							}

							Cell R8cell5 = R8row.getCell(8);
							if (R8cell5 != null) {
								String value = (BRF71.getR8_unionpay() == null) ? "0"
										: BRF71.getR8_unionpay().toString();
								R8cell5.setCellValue(value);
							}

///////////////////////R9/////////////////////

							Row R9row = sheet.getRow(15);

							Cell R9cell0 = R9row.getCell(3);
							if (R9cell0 != null) {
								String value = (BRF71.getR9_visa() == null) ? "0" : BRF71.getR9_visa().toString();
								R9cell0.setCellValue(value);
							}

							Cell R9cell1 = R9row.getCell(4);
							if (R9cell1 != null) {
								String value = (BRF71.getR9_mastercard() == null) ? "0"
										: BRF71.getR9_mastercard().toString();
								R9cell1.setCellValue(value);
							}

							Cell R9cell2 = R9row.getCell(5);
							if (R9cell2 != null) {
								String value = (BRF71.getR9_amex() == null) ? "0" : BRF71.getR9_amex().toString();
								R9cell2.setCellValue(value);
							}

							Cell R9cell3 = R9row.getCell(6);
							if (R9cell3 != null) {
								String value = (BRF71.getR9_jcb() == null) ? "0" : BRF71.getR9_jcb().toString();
								R9cell3.setCellValue(value);
							}

							Cell R9cell4 = R9row.getCell(7);
							if (R9cell4 != null) {
								String value = (BRF71.getR9_diners() == null) ? "0" : BRF71.getR9_diners().toString();
								R9cell4.setCellValue(value);
							}

							Cell R9cell5 = R9row.getCell(8);
							if (R9cell5 != null) {
								String value = (BRF71.getR9_unionpay() == null) ? "0"
										: BRF71.getR9_unionpay().toString();
								R9cell5.setCellValue(value);
							}

///////////////////////R11/////////////////////

							Row R11row = sheet.getRow(17);

							Cell R11cell0 = R11row.getCell(3);
							if (R11cell0 != null) {
								String value = (BRF71.getR11_visa() == null) ? "0" : BRF71.getR11_visa().toString();
								R11cell0.setCellValue(value);
							}

							Cell R11cell1 = R11row.getCell(4);
							if (R11cell1 != null) {
								String value = (BRF71.getR11_mastercard() == null) ? "0"
										: BRF71.getR11_mastercard().toString();
								R11cell1.setCellValue(value);
							}

							Cell R11cell2 = R11row.getCell(5);
							if (R11cell2 != null) {
								String value = (BRF71.getR11_amex() == null) ? "0" : BRF71.getR11_amex().toString();
								R11cell2.setCellValue(value);
							}

							Cell R11cell3 = R11row.getCell(6);
							if (R11cell3 != null) {
								String value = (BRF71.getR11_jcb() == null) ? "0" : BRF71.getR11_jcb().toString();
								R11cell3.setCellValue(value);
							}

							Cell R11cell4 = R11row.getCell(7);
							if (R11cell4 != null) {
								String value = (BRF71.getR11_diners() == null) ? "0" : BRF71.getR11_diners().toString();
								R11cell4.setCellValue(value);
							}

							Cell R11cell5 = R11row.getCell(8);
							if (R11cell5 != null) {
								String value = (BRF71.getR11_unionpay() == null) ? "0"
										: BRF71.getR11_unionpay().toString();
								R11cell5.setCellValue(value);
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-071-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-071-A.xls");

		return outputFile;

	}

	public ModelAndView getBRF71View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF71_ENTITY> T1rep = new ArrayList<BRF71_ENTITY>();
		// Query<Object[]> qr;

		List<BRF71_ENTITY> T1Master = new ArrayList<BRF71_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF71_ENTITY a where a.report_date = ?1 ", BRF71_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF71");
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

	public ModelAndView getBRF71currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF71_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF71_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF71_DETAILTABLE  where report_date = ?1");
		}
		List<BRF71_DETAIL_ENTITY> T1Master = new ArrayList<BRF71_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF71_DETAIL_ENTITY a where a.report_date = ?1", BRF71_DETAIL_ENTITY.class)
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

			BRF71_DETAIL_ENTITY py = new BRF71_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF71::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges71(BRF71_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF71_DETAIL_ENTITY> Brf71detail = brf71_detailrepo.findById(foracid);

			if (Brf71detail.isPresent()) {
				BRF71_DETAIL_ENTITY BRFdetail = Brf71detail.get();

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
					brf71_detailrepo.save(BRFdetail);

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

	public ModelAndView getArchieveBRF071View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF71_ENTITY> T1rep = new ArrayList<BRF71_ENTITY>();
		// Query<Object[]> qr;

		List<BRF71_ENTITY> T1Master = new ArrayList<BRF71_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF71_ENTITY a where a.report_date = ?1 ", BRF71_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF71ARCH");
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

	public ModelAndView ARCHgetBRF071currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF71_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF71_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF71_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF71_ARCHIV_ENTITY> T1Master = new ArrayList<BRF71_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF71_ARCHIV_ENTITY a where a.report_date = ?1", BRF71_ARCHIV_ENTITY.class)
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

			BRF71_ARCHIV_ENTITY py = new BRF71_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF71ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String verifyBRF71Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";
		BRF71_ENTITY up = BRF71_ServiceRepo.getBRF71AReport(asondate);
		if (Objects.nonNull(up)) {
			up.setModify_flg("N");
			up.setVerify_time(new Date());
			up.setVerify_user(userId);
			up.setVerify_user(userId);
			up.setVerify_time(asondate);
			BRF71_ServiceRepo.save(up);
			msg = "Verified Successfully";
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
		audit.setAudit_table("BRF71_SUMMARYTABLE");
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