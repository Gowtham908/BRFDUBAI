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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
/*import com.bornfire.xbrl.entities.BRBS.BRF108_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF108_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF108_DetailRep;*/
import com.bornfire.xbrl.entities.BRBS.BRF108_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF108_ENTITY_REPO;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.ReportBRF108Data;

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
public class BRF108ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF108ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	/*
	 * @Autowired BRF108_DetailRep brf108_DetailRep;
	 */

	@Autowired
	BRF108_ENTITY_REPO brf108_entity_repo;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF108_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF108_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF108View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();

		logger.info("Inside archive: " + currency);

		try {
			// Fetching data from BRF108_SUMMARYTABLE
			List<BRF108_ENTITY> T1Master = hs
					.createNativeQuery("SELECT * FROM BRF108_SUMMARYTABLE a WHERE a.report_date = ?1 ORDER BY r1_s_no",
							BRF108_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			System.out.println("The size is: " + T1Master.size());

			// Setting the view name and adding attributes
			mv.setViewName("RR/BRF108");
			mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
			mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
			mv.addObject("list", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
		} catch (Exception e) {
			logger.error("Error while fetching data for BRF108: ", e);
			mv.setViewName("error");
			mv.addObject("message", "An error occurred while processing the request.");
		}

		return mv;
	}

	/*
	 * public ModelAndView getBRF108currentDtl(String reportId, String fromdate,
	 * String todate, String currency, String dtltype, Pageable pageable, String
	 * filter) {
	 * 
	 * int pageSize = pageable.getPageSize(); int currentPage =
	 * pageable.getPageNumber(); int startItem = currentPage * pageSize;
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * Session hs = sessionFactory.getCurrentSession(); List<Object> T1Dt1 = new
	 * ArrayList<Object>(); Query<Object[]> qr;
	 * 
	 * if (dtltype.equals("report")) { if (!filter.equals("null")) { qr =
	 * hs.createNativeQuery("select * from TRAN_MASTER_DETAIL"); //
	 * qr.setParameter(2, filter); } else { qr =
	 * hs.createNativeQuery("select * from TRAN_MASTER_DETAIL"); } } else { qr = hs.
	 * createNativeQuery("select * from TRAN_MASTER_DETAIL  where report_date = ?1"
	 * ); } List<RBSTransactionMasterEntity> T1Master = new
	 * ArrayList<RBSTransactionMasterEntity>();
	 * 
	 * try { T1Master =
	 * hs.createQuery("from RBSTransactionMasterEntity a where a.report_date = ?1",
	 * RBSTransactionMasterEntity.class).setParameter(1,
	 * df.parse(todate)).getResultList(); } catch (ParseException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * logger.info("Getting Report Detail for : " + reportId + "," + fromdate + ","
	 * + todate + "," + currency); List<Object[]> result = qr.getResultList();
	 * 
	 * for (Object[] a : result) { String cust_id = (String) a[0]; String cust_name
	 * = (String) a[1]; String cust_type = (String) a[2]; String cust_rating =
	 * (String) a[3]; String acct_no = (String) a[4]; String acct_name = (String)
	 * a[5]; String tran_type = (String) a[6]; String tran_sub_type = (String) a[7];
	 * Date tran_date = (Date) a[8]; String tran_id = (String) a[9]; BigDecimal
	 * part_tran_id = (BigDecimal) a[10]; String part_tran_type = (String) a[11];
	 * String tran_crncy = (String) a[12]; BigDecimal tran_amt = (BigDecimal) a[13];
	 * BigDecimal tran_amt_orgin = (BigDecimal) a[14]; String tran_category =
	 * (String) a[15]; Character qtr_flg = (Character) a[16]; Character entity_flg =
	 * (Character) a[17]; Character del_flg = (Character) a[18]; Character
	 * modify_flg = (Character) a[19]; Date entry_date = (Date) a[20]; Date
	 * modify_date = (Date) a[21]; Date verify_date = (Date) a[22]; String
	 * entry_user = (String) a[23]; String modify_user = (String) a[24]; String
	 * verify_user = (String) a[25]; String report_code = (String) a[26]; String
	 * report_name = (String) a[27]; Date report_date = (Date) a[28]; Character
	 * arch_flg = (Character) a[29]; String cell_mapping = (String) a[30]; String
	 * process_owner = (String) a[31]; String bank_id = (String) a[32]; Date
	 * cust_rating_date = (Date) a[33]; String tran_particular = (String) a[34];
	 * String tran_channel = (String) a[35]; String cntry_res = (String) a[36];
	 * String cnty_incorp = (String) a[37]; String cntry_oper = (String) a[38];
	 * String aml_code_1 = (String) a[39]; String aml_code_2 = (String) a[40];
	 * String aml_code_3 = (String) a[41]; String aml_code_4 = (String) a[42];
	 * String aml_code_5 = (String) a[43]; String aml_code_6 = (String) a[44];
	 * String aml_code_7 = (String) a[45]; String aml_code_8 = (String) a[46];
	 * String aml_code_9 = (String) a[47]; String aml_code_10 = (String) a[48];
	 * String t1_report = (String) a[49]; String t2_report = (String) a[50]; String
	 * t4_report = (String) a[51]; String t5_report = (String) a[52]; String
	 * t6_report = (String) a[53]; String t7_report = (String) a[54]; String
	 * t9_report = (String) a[55]; String t12a_report = (String) a[56]; String
	 * t12b_report = (String) a[57]; String t12c_report = (String) a[58]; String
	 * t12d_report = (String) a[59]; String t12e_report = (String) a[60]; String
	 * t12f_report = (String) a[61]; String t12g_report = (String) a[62]; String
	 * t13a_report = (String) a[63]; String t13b_report = (String) a[64]; String
	 * t14a_report = (String) a[65]; String t14b_report = (String) a[66]; String
	 * t15a_report = (String) a[67]; String t15b_report = (String) a[68]; String
	 * t16a_report = (String) a[69]; String t16b_report = (String) a[70]; String
	 * t16c_report = (String) a[71]; String t23_report = (String) a[72]; String
	 * t26_report = (String) a[73]; String t27_report = (String) a[74]; String
	 * t29_report = (String) a[75]; String t32_report = (String) a[76]; BigDecimal
	 * srl_num = (BigDecimal) a[77];
	 * 
	 * RBSTransactionMasterEntity py = new RBSTransactionMasterEntity(cust_id,
	 * cust_name, cust_type, cust_rating, acct_no, acct_name, tran_type,
	 * tran_sub_type, tran_date, tran_id, part_tran_id, part_tran_type, tran_crncy,
	 * tran_amt, tran_amt_orgin, tran_category, qtr_flg, entity_flg, del_flg,
	 * modify_flg, entry_date, modify_date, verify_date, entry_user, modify_user,
	 * verify_user, report_code, report_name, report_date, arch_flg, cell_mapping,
	 * process_owner, bank_id, cust_rating_date, tran_particular, tran_channel,
	 * cntry_res, cnty_incorp, cntry_oper, aml_code_1, aml_code_2, aml_code_3,
	 * aml_code_4, aml_code_5, aml_code_6, aml_code_7, aml_code_8, aml_code_9,
	 * aml_code_10, t1_report, t2_report, t4_report, t5_report, t6_report,
	 * t7_report, t9_report, t12a_report, t12b_report, t12c_report, t12d_report,
	 * t12e_report, t12f_report, t12g_report, t13a_report, t13b_report, t14a_report,
	 * t14b_report, t15a_report, t15b_report, t16a_report, t16b_report, t16c_report,
	 * t23_report, t26_report, t27_report, t29_report, t32_report, srl_num);
	 * 
	 * T1Dt1.add(py);
	 * 
	 * } ;
	 * 
	 * List<Object> pagedlist;
	 * 
	 * if (T1Dt1.size() < startItem) { pagedlist = Collections.emptyList(); } else {
	 * int toIndex = Math.min(startItem + pageSize, T1Dt1.size()); pagedlist =
	 * T1Dt1.subList(startItem, toIndex); }
	 * 
	 * logger.info("Converting to Page"); Page<Object> T1Dt1Page = new
	 * PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
	 * T1Dt1.size());
	 * 
	 * mv.setViewName("RR" + "/" + "ReportBRF108::reportcontent"); //
	 * mv.setViewName("ReportT1"); mv.addObject("reportdetails", T1Dt1Page);
	 * mv.addObject("reportmaster", T1Master); mv.addObject("singledetail", new
	 * T1CurProdDetail()); mv.addObject("reportsflag", "reportsflag");
	 * mv.addObject("menu", reportId); return mv; }
	 */

	public File getFileBRF108(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		System.out.println("inside the path");

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-108-A";
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

							jasperFile = this.getClass()
									.getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/RBS_DETAILS/T1Detail.jasper");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_108_AA.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF108.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF108.jrxml");
						}
					}

					// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
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
				List<BRF108_ENTITY> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				System.out.println(todate);
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = brf108_entity_repo.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-108-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					if (!T1Master1.isEmpty()) {
						int startRow = 8; // Starting row index
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] BRF108 = T1Master1.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							////////// C1///////////
							/*
							 * Cell cell1 = row.getCell(1); if (cell1 == null) { cell1 = row.createCell(1);
							 * } cell1.setCellValue(BRF202[0] == null ? 0 : ((BigDecimal)
							 * BRF202[0]).intValue());
							 */

							///////////// C2//////////
							Cell cell2 = row.getCell(2);
							if (cell2 == null) {
								cell2 = row.createCell(2);
							}
							String value2 = (BRF108[1] == null) ? "0" : BRF108[1].toString();
							cell2.setCellValue(value2);

							///////////// C1//////////
							Cell cell1 = row.getCell(1);
							if (cell1 == null) {
								cell1 = row.createCell(1);
							}
							String value1 = (BRF108[0] == null) ? "0" : BRF108[0].toString();
							cell1.setCellValue(value1);

							///////////// C5//////////
							Cell cell5 = row.getCell(5);
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}
							String value5 = (BRF108[4] == null) ? "0" : BRF108[4].toString();
							cell5.setCellValue(value5);

							///////////// C4//////////
//							Cell cell4 = row.getCell(4);
//							if (cell4 == null) {
//								cell4 = row.createCell(4);
//							}
//							String value4 = (BRF108[3] == null) ? "0" : BRF108[3].toString();
//							cell4.setCellValue(value4);
							Cell cell4 = row.getCell(4);
							if (cell4 == null) {
								cell4 = row.createCell(4);
							}
							Date dateValue1 = (Date) BRF108[3];
							SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate1 = (dateValue1 == null) ? "N/A" : dateFormat1.format(dateValue1);
							cell4.setCellValue(formattedDate1);

							///////////// C6//////////
							Cell cell6 = row.getCell(6);
							if (cell6 == null) {
								cell6 = row.createCell(6);
							}
							String value6 = (BRF108[5] == null) ? "0" : BRF108[5].toString();
							cell6.setCellValue(value6);

							///////////// C10//////////
//							Cell cell10 = row.getCell(10);
//							if (cell10 == null) {
//								cell10 = row.createCell(10);
//							}
//							String value10 = (BRF108[9] == null) ? "0" : BRF108[9].toString();
//							cell10.setCellValue(value10);

							Cell cell10 = row.getCell(10);
							if (cell10 == null) {
								cell10 = row.createCell(10);
							}
							Date dateValue3 = (Date) BRF108[9];
							SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate3 = (dateValue3 == null) ? "N/A" : dateFormat3.format(dateValue3);
							cell10.setCellValue(formattedDate3);

							///////////// C7//////////
							Cell cell7 = row.getCell(7);
							if (cell7 == null) {
								cell7 = row.createCell(7);
							}
							String value7 = (BRF108[6] == null) ? "0" : BRF108[6].toString();
							cell7.setCellValue(value7);

							///////////// C3//////////
							Cell cell3 = row.getCell(3);
							if (cell3 == null) {
								cell3 = row.createCell(3);
							}
							String value3 = (BRF108[2] == null) ? "0" : BRF108[2].toString();
							cell3.setCellValue(value3);

							///////////// C8//////////
							Cell cell8 = row.getCell(8);
							if (cell8 == null) {
								cell8 = row.createCell(8);
							}
							String value8 = (BRF108[7] == null) ? "0" : BRF108[7].toString();
							cell8.setCellValue(value8);

							///////////// C11//////////
							Cell cell11 = row.getCell(11);
							if (cell11 == null) {
								cell11 = row.createCell(11);
							}
							String value11 = (BRF108[10] == null) ? "0" : BRF108[10].toString();
							cell11.setCellValue(value11);

							///////////// C12//////////
//							Cell cell12 = row.getCell(12);
//							if (cell12 == null) {
//								cell12 = row.createCell(12);
//							}
//							String value12 = (BRF108[11] == null) ? "0" : BRF108[11].toString();
//							cell12.setCellValue(value12);

							Cell cell12 = row.getCell(12);
							if (cell12 == null) {
								cell12 = row.createCell(12);
							}
							Date dateValue4 = (Date) BRF108[11];
							SimpleDateFormat dateFormat4 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate4 = (dateValue4 == null) ? "N/A" : dateFormat4.format(dateValue4);
							cell12.setCellValue(formattedDate4);

							///////////// C14//////////
//							Cell cell14 = row.getCell(14);
//							if (cell14 == null) {
//								cell14 = row.createCell(14);
//							}
//							String value14 = (BRF108[13] == null) ? "0" : BRF108[13].toString();
//							cell14.setCellValue(value14);

							Cell cell14 = row.getCell(14);
							if (cell14 == null) {
								cell14 = row.createCell(14);
							}
							Date dateValue5 = (Date) BRF108[13];
							SimpleDateFormat dateFormat5 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate5 = (dateValue5 == null) ? "N/A" : dateFormat5.format(dateValue5);
							cell14.setCellValue(formattedDate5);

							///////////// C9//////////
//							Cell cell9 = row.getCell(9);
//							if (cell9 == null) {
//								cell9 = row.createCell(9);
//							}
//							String value9 = (BRF108[8] == null) ? "0" : BRF108[8].toString();
//							cell9.setCellValue(value9);
							Cell cell9 = row.getCell(9);
							if (cell9 == null) {
								cell9 = row.createCell(9);
							}
							Date dateValue2 = (Date) BRF108[8];
							SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate2 = (dateValue2 == null) ? "N/A" : dateFormat2.format(dateValue2);
							cell9.setCellValue(formattedDate2);

							///////////// C15//////////
//							Cell cell15 = row.getCell(15);
//							if (cell15 == null) {
//								cell15 = row.createCell(15);
//							}
//							String value15 = (BRF108[14] == null) ? "0" : BRF108[14].toString();
//							cell15.setCellValue(value15);
							Cell cell15 = row.getCell(15);
							if (cell15 == null) {
								cell15 = row.createCell(15);
							}
							cell15.setCellValue(BRF108[14] == null ? 0 : ((BigDecimal) BRF108[14]).intValue());

							///////////// C16//////////
//							Cell cell16 = row.getCell(16);
//							if (cell16 == null) {
//								cell16 = row.createCell(16);
//							}
//							String value16 = (BRF108[15] == null) ? "0" : BRF108[15].toString();
//							cell16.setCellValue(value16);

							Cell cell16 = row.getCell(16);
							if (cell16 == null) {
								cell16 = row.createCell(16);
							}
							cell16.setCellValue(BRF108[15] == null ? 0 : ((BigDecimal) BRF108[15]).intValue());

							///////////// C13//////////
//							Cell cell13 = row.getCell(13);
//							if (cell13 == null) {
//								cell13 = row.createCell(13);
//							}
//							String value13 = (BRF108[12] == null) ? "0" : BRF108[12].toString();
//							cell13.setCellValue(value13);

//							Cell cell13 = row.getCell(13);
//							
//							if (cell13 == null) {
//								cell13 = row.createCell(13);
//							}
//							cell13.setCellValue(BRF108[13] == null ? 0 : ((BigDecimal) BRF108[13]).intValue());

							///////////// C17//////////
							Cell cell17 = row.getCell(17);
							if (cell17 == null) {
								cell17 = row.createCell(17);
							}
							String value17 = (BRF108[16] == null) ? "0" : BRF108[16].toString();
							cell17.setCellValue(value17);

						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-108-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-108-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-108-A.xls");

		return outputFile;

	}

	public ModelAndView getArchieveBRF108View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();

		logger.info("Inside archive: " + currency);

		try {
			// Fetching data from BRF108_SUMMARYTABLE
			List<BRF108_ENTITY> T1Master = hs
					.createNativeQuery("SELECT * FROM BRF108_SUMMARYTABLE a WHERE a.report_date = ?1 ORDER BY r1_s_no",
							BRF108_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			System.out.println("The size is: " + T1Master.size());

			// Setting the view name and adding attributes
			mv.setViewName("RR/BRF108ARCH");
			mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
			mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
			mv.addObject("list", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
		} catch (Exception e) {
			logger.error("Error while fetching data for BRF108: ", e);
			mv.setViewName("error");
			mv.addObject("message", "An error occurred while processing the request.");
		}

		return mv;
	}

	public String modifyBrf108(ReportBRF108Data formData, Date asondate, String userId, HttpServletRequest req) {
		String msg = "";

		// Fetch existing reports and user-submitted data
		List<BRF108_ENTITY> existingReports = brf108_entity_repo.getBRF108reportService(formData.getFrom_date());
		List<BRF108_ENTITY> userData = formData.getBrf108_entity();

		List<String> oldValues = new ArrayList<>();
		List<String> newValues = new ArrayList<>();
		List<String> fieldNames = new ArrayList<>();
		List<String> finalOldVal = new ArrayList<>();

		// Identify new records in userData that are not in existingReports
		for (BRF108_ENTITY userdatas : userData) {
			boolean found = false;
			for (BRF108_ENTITY existing : existingReports) {
				if (existing.getR1_s_no().equals(userdatas.getR1_s_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finalOldVal.add(userdatas.toString());
			}
		}

		int editedRowsCount = 0; // Counter for edited rows
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

		// Compare and track changes between existingReports and userData
		for (int i = 0; i < existingReports.size(); i++) {
			BRF108_ENTITY existingReport = existingReports.get(i);
			BRF108_ENTITY userReport = userData.get(i);

			StringBuilder oldChange = new StringBuilder();
			StringBuilder newChange = new StringBuilder();
			boolean rowEdited = false;

			// Field comparisons and change tracking
			if (!Objects.equals(existingReport.getR1_customer_name(), userReport.getR1_customer_name())) {
				fieldNames.add("CUSTOMER NAME");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_customer_name()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_customer_name()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_customer_id(), userReport.getR1_customer_id())) {
				fieldNames.add("CUSTOMER ID");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_customer_id()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_customer_id()).append(" ");
				rowEdited = true;
			}
			if (!sdf.format(existingReport.getR1_exp_date()).equals(sdf.format(userReport.getR1_exp_date()))) {
				fieldNames.add("EXP DATE (dd/MM/yyyy)");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(existingReport.getR1_exp_date()))
						.append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(userReport.getR1_exp_date())).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_act_num(), userReport.getR1_act_num())) {
				fieldNames.add("ACCT NUM");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_act_num()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_act_num()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_customer_add(), userReport.getR1_customer_add())) {
				fieldNames.add("CUSTOMER ADD");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_customer_add()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_customer_add()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_branch_name(), userReport.getR1_branch_name())) {
				fieldNames.add("BRANCH NAME");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_branch_name()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_branch_name()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_act_type(), userReport.getR1_act_type())) {
				fieldNames.add("ACC TYPE");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_act_type()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_act_type()).append(" ");
				rowEdited = true;
			}
			if (!sdf.format(existingReport.getR1_trans_date()).equals(sdf.format(userReport.getR1_trans_date()))) {
				fieldNames.add("TRANS DATE (dd/MM/yyyy)");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(existingReport.getR1_trans_date()))
						.append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(userReport.getR1_trans_date()))
						.append(" ");
				rowEdited = true;
			}
			if (!sdf.format(existingReport.getR1_com_date()).equals(sdf.format(userReport.getR1_com_date()))) {
				fieldNames.add("COM DATE (dd/MM/yyyy)");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(existingReport.getR1_com_date()))
						.append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(userReport.getR1_com_date())).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_dep_no(), userReport.getR1_dep_no())) {
				fieldNames.add("DEP NO");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_dep_no()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_dep_no()).append(" ");
				rowEdited = true;
			}
			if (!sdf.format(existingReport.getR1_safe_date()).equals(sdf.format(userReport.getR1_safe_date()))) {
				fieldNames.add("SAFE DATE (dd/MM/yyyy)");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(existingReport.getR1_safe_date()))
						.append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(userReport.getR1_safe_date())).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_dormant(), userReport.getR1_dormant())) {
				fieldNames.add("DORMANT");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_dormant()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_dormant()).append(" ");
				rowEdited = true;
			}
			if (!sdf.format(existingReport.getR1_drill_date()).equals(sdf.format(userReport.getR1_drill_date()))) {
				fieldNames.add("DRILL DATE (dd/MM/yyyy)");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(existingReport.getR1_drill_date()))
						.append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(sdf.format(userReport.getR1_drill_date()))
						.append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_drill_charge(), userReport.getR1_drill_charge())) {
				fieldNames.add("DRILL CHARGE");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_drill_charge()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_drill_charge()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_total(), userReport.getR1_total())) {
				fieldNames.add("TOTAL");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_total()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_total()).append(" ");
				rowEdited = true;
			}
			if (!Objects.equals(existingReport.getR1_description(), userReport.getR1_description())) {
				fieldNames.add("DESCRIPTION");
				oldChange.append("BRF108_SUMMARYTABLE : ").append(existingReport.getR1_description()).append(" ");
				newChange.append("BRF108_SUMMARYTABLE : ").append(userReport.getR1_description()).append(" ");
				rowEdited = true;
			}

			// Record changes if row was edited
			if (rowEdited) {
				editedRowsCount++;
				String rowIdentifier = "Row " + (i + 1);
				oldValues.add(rowIdentifier + " - " + oldChange.toString().trim());
				newValues.add(rowIdentifier + " - " + newChange.toString().trim());
			}
		}

		// Display the number of rows edited
		System.out.println("Number of rows edited: " + editedRowsCount);

		// Save updated user data to the repository
		if (Objects.nonNull(userData) && !userData.isEmpty()) {
			List<BRF108_ENTITY> updatedReports = new ArrayList<>();
			for (BRF108_ENTITY entity : userData) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(formData.getFrom_date());
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf108_entity_repo.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		// Create audit entry

		String auditID = sequence.generateRequestUUId();
		String user1 = (String) req.getSession().getAttribute("USERID");
		String username = (String) req.getSession().getAttribute("USERNAME");

		if (existingReports.size() == userData.size()) {
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFY");
			audit.setAudit_table("BRF108_SUMMARYTABLE");
			audit.setAudit_screen("MODIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setOld_value(String.join("; ", oldValues));
			audit.setNew_value(String.join("; ", newValues));
			audit.setField_name(String.join("; ", fieldNames));
			audit.setRemarks("Modify Successfully");

			UserProfile userProfile = userProfileRep.getRole(user1);
			audit.setAuth_user(userProfile.getAuth_user());
			audit.setAuth_time(userProfile.getAuth_time());
			audit.setAudit_ref_no(auditID);

			mANUAL_Service_Rep.save(audit);
		} else {
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("ADD");
			audit.setAudit_table("BRF108_SUMMARYTABLE");
			audit.setAudit_screen("ADD");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setNew_value(String.join("; ", finalOldVal));
			audit.setRemarks("Added Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);
			mANUAL_Service_Rep.save(audit);
		}
		return msg;
	}

	public String verifyBRF108Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";
		List<BRF108_ENTITY> existingReports = brf108_entity_repo.getallDetails(asondate);

		if (Objects.nonNull(existingReports) && !existingReports.isEmpty()) {
			List<BRF108_ENTITY> updatedReports = new ArrayList<>();
			for (BRF108_ENTITY entity : existingReports) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf108_entity_repo.saveAll(updatedReports);
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
		audit.setAudit_table("BRF108_SUMMARYTABLE");
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
