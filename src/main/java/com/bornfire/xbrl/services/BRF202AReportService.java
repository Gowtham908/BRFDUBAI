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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.hibernate.transform.Transformers;
import org.joda.time.Years;
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

import com.bornfire.xbrl.entities.BRBS.BRF202_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF202_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF202_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF300_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF69_SUMMARY_A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.BRF202A_entity;
import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.BRF201_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_A;
import com.bornfire.xbrl.entities.BRBS.BRF202A_entity;
import com.bornfire.xbrl.entities.BRBS.BRF202A_entity_repo;
//import com.bornfire.xbrl.entities.BRBS.BRF_202_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
import com.bornfire.xbrl.entities.BRBS.ReportBRF202AData;
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
public class BRF202AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF202AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF202_DetailRep brf202_DetailRep;

	@Autowired
	BRF202A_entity_repo brf202A_entity_repo;

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
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF202A_entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF202A_entity a").getSingleResult();
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

	public ModelAndView getBRF202AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		logger.info("Inside archive" + currency);
		List<BRF202A_entity> T1Master = hs
				.createNativeQuery(" select * from BRF202_SUMMARYTABLE order by r1_s_no", BRF202A_entity.class)
				.getResultList();
		long st_training_hrs = 0;
		long st_training_spent = 0;
		for (int i = 0; i < T1Master.size(); i++) {
			st_training_hrs = st_training_hrs + T1Master.get(i).getR1_training_hours_ytd().intValue();
		}
		for (int i = 0; i < T1Master.size(); i++) {
			st_training_spent = st_training_spent + T1Master.get(i).getR1_training_spent_aed().intValue();
		}
		System.out.println("The size is : " + T1Master.size());

		mv.setViewName("RR/BRF202A");
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		mv.addObject("st_training_hrs", st_training_hrs);
		mv.addObject("st_training_spent", st_training_spent);
		mv.addObject("list", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);

		return mv;
	}

	/*
	 * public ModelAndView getBRF202AcurrentDtl(String reportId, String fromdate,
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
	 * mv.setViewName("RR" + "/" + "ReportBRF202A::reportcontent"); //
	 * mv.setViewName("ReportT1"); mv.addObject("reportdetails", T1Dt1Page);
	 * mv.addObject("reportmaster", T1Master); mv.addObject("singledetail", new
	 * T1CurProdDetail()); mv.addObject("reportsflag", "reportsflag");
	 * mv.addObject("menu", reportId); return mv; }
	 */

	public File getFileBRF202A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		System.out.println("inside the path");

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-202-A";
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
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_202_AA.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_202_AA.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_202_AA.jrxml");
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
			}

			else {
				List<BRF202A_entity> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = brf202A_entity_repo.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-202-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					if (!T1Master1.isEmpty()) {
						int startRow = 15; // Starting row index
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] BRF202 = T1Master1.get(index);
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

							Cell cell1 = row.getCell(1);
							if (cell1 == null) {
								cell1 = row.createCell(1);
							}
							String value1 = (BRF202[0] == null) ? "0" : BRF202[0].toString();
							cell1.setCellValue(value1);

							///////////// C2//////////
							Cell cell2 = row.getCell(2);
							if (cell2 == null) {
								cell2 = row.createCell(2);
							}
							String value2 = (BRF202[1] == null) ? "0" : BRF202[1].toString();
							cell2.setCellValue(value2);

							///////////// C3//////////
							Cell cell3 = row.getCell(3);
							if (cell3 == null) {
								cell3 = row.createCell(3);
							}
							String value3 = (BRF202[2] == null) ? "0" : BRF202[2].toString();
							cell3.setCellValue(value3);

							///////////// C4//////////
							Cell cell4 = row.getCell(4);
							if (cell4 == null) {
								cell4 = row.createCell(4);
							}
							String value4 = (BRF202[3] == null) ? "0" : BRF202[3].toString();
							cell4.setCellValue(value4);

							///////////// C9//////////
							Cell cell9 = row.getCell(9);
							if (cell9 == null) {
								cell9 = row.createCell(9);
							}
							String value9 = (BRF202[8] == null) ? "0" : BRF202[8].toString();
							cell9.setCellValue(value9);

							///////////// C5//////////
							Cell cell5 = row.getCell(5);
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}
							String value5 = (BRF202[4] == null) ? "0" : BRF202[4].toString();
							cell5.setCellValue(value5);

							///////////// C6//////////
							Cell cell6 = row.getCell(6);
							if (cell6 == null) {
								cell6 = row.createCell(6);
							}
							String value6 = (BRF202[5] == null) ? "0" : BRF202[5].toString();
							cell6.setCellValue(value6);

							///////////// C8//////////
							/*
							 * Cell cell8 = row.getCell(8); if (cell8 == null) { cell8 = row.createCell(8);
							 * } String value8 = (BRF202[7] == null) ? "0" : BRF202[7].toString();
							 * cell8.setCellValue(value8);
							 */
							Cell cell8 = row.getCell(8);
							if (cell8 == null) {
								cell8 = row.createCell(8);
							}
							Date dateValue = (Date) BRF202[7];
							SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate = (dateValue == null) ? "N/A" : dateFormat1.format(dateValue);
							cell8.setCellValue(formattedDate);

							///////////// C11//////////
							Cell cell11 = row.getCell(11);
							if (cell11 == null) {
								cell11 = row.createCell(11);
							}
							String value11 = (BRF202[10] == null) ? "0" : BRF202[10].toString();
							cell11.setCellValue(value11);

							///////////// C12//////////
							Cell cell12 = row.getCell(12);
							if (cell12 == null) {
								cell12 = row.createCell(12);
							}
							String value12 = (BRF202[11] == null) ? "0" : BRF202[11].toString();
							cell12.setCellValue(value12);

							///////////// C10//////////
							Cell cell10 = row.getCell(10);
							if (cell10 == null) {
								cell10 = row.createCell(10);
							}
							String value10 = (BRF202[9] == null) ? "0" : BRF202[9].toString();
							cell10.setCellValue(value10);

							///////////// C7//////////
							/*
							 * Cell cell7 = row.getCell(7); if (cell7 == null) { cell7 = row.createCell(7);
							 * } String value7 = (BRF202[6] == null) ? "0" : BRF202[6].toString();
							 * cell7.setCellValue(value7);
							 */
							Cell cell7 = row.getCell(7);
							if (cell7 == null) {
								cell7 = row.createCell(7);
							}
							Date dateValue2 = (Date) BRF202[6];
							SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
							String formattedDate2 = (dateValue == null) ? "N/A" : dateFormat2.format(dateValue2);
							cell8.setCellValue(formattedDate2);

							///////////// C15//////////
							Cell cell15 = row.getCell(15);
							if (cell15 == null) {
								cell15 = row.createCell(15);
							}
							String value15 = (BRF202[14] == null) ? "0" : BRF202[14].toString();
							cell15.setCellValue(value15);

							///////////// C13//////////
							Cell cell13 = row.getCell(13);
							if (cell13 == null) {
								cell13 = row.createCell(13);
							}
							String value13 = (BRF202[12] == null) ? "0" : BRF202[12].toString();
							cell13.setCellValue(value13);

							///////////// C20//////////
							Cell cell20 = row.getCell(20);
							if (cell20 == null) {
								cell20 = row.createCell(20);
							}
							String value20 = (BRF202[19] == null) ? "0" : BRF202[19].toString();
							cell20.setCellValue(value20);

							///////////// C18//////////
							Cell cell18 = row.getCell(18);
							if (cell18 == null) {
								cell18 = row.createCell(18);
							}
							String value18 = (BRF202[17] == null) ? "0" : BRF202[17].toString();
							cell18.setCellValue(value18);

							///////////// C19//////////
							Cell cell19 = row.getCell(19);
							if (cell19 == null) {
								cell19 = row.createCell(19);
							}
							String value19 = (BRF202[18] == null) ? "0" : BRF202[18].toString();
							cell19.setCellValue(value19);

							///////////// C16//////////
							Cell cell16 = row.getCell(16);
							if (cell16 == null) {
								cell16 = row.createCell(16);
							}
							String value16 = (BRF202[15] == null) ? "0" : BRF202[15].toString();
							cell16.setCellValue(value16);

							///////////// C21//////////
							Cell cell21 = row.getCell(21);
							if (cell21 == null) {
								cell21 = row.createCell(21);
							}
							String value21 = (BRF202[20] == null) ? "0" : BRF202[20].toString();
							cell21.setCellValue(value21);

							///////////// C17//////////
							Cell cell17 = row.getCell(17);
							if (cell17 == null) {
								cell17 = row.createCell(17);
							}
							String value17 = (BRF202[16] == null) ? "0" : BRF202[16].toString();
							cell17.setCellValue(value17);

							///////////// C22//////////
							Cell cell22 = row.getCell(22);
							if (cell22 == null) {
								cell22 = row.createCell(22);
							}
							String value22 = (BRF202[21] == null) ? "0" : BRF202[21].toString();
							cell22.setCellValue(value22);

							///////////// C24//////////
							Cell cell24 = row.getCell(24);
							if (cell24 == null) {
								cell24 = row.createCell(24);
							}
							String value24 = (BRF202[23] == null) ? "0" : BRF202[23].toString();
							cell24.setCellValue(value24);

							///////////// C14//////////
							Cell cell14 = row.getCell(14);
							if (cell14 == null) {
								cell14 = row.createCell(14);
							}
							String value14 = (BRF202[13] == null) ? "0" : BRF202[13].toString();
							cell14.setCellValue(value14);

							///////////// C25//////////
							Cell cell25 = row.getCell(25);
							if (cell25 == null) {
								cell25 = row.createCell(25);
							}
							String value25 = (BRF202[24] == null) ? "0" : BRF202[24].toString();
							cell25.setCellValue(value25);

							///////////// C26//////////
							Cell cell26 = row.getCell(26);
							if (cell26 == null) {
								cell26 = row.createCell(26);
							}
							String value26 = (BRF202[25] == null) ? "0" : BRF202[25].toString();
							cell26.setCellValue(value26);

							///////////// C30//////////
							Cell cell30 = row.getCell(30);
							if (cell30 == null) {
								cell30 = row.createCell(30);
							}
							String value30 = (BRF202[29] == null) ? "0" : BRF202[29].toString();
							cell30.setCellValue(value30);

							///////////// C23//////////
							Cell cell23 = row.getCell(23);
							if (cell23 == null) {
								cell23 = row.createCell(23);
							}
							String value23 = (BRF202[22] == null) ? "0" : BRF202[22].toString();
							cell23.setCellValue(value23);

							///////////// C27//////////
							Cell cell27 = row.getCell(27);
							if (cell27 == null) {
								cell27 = row.createCell(27);
							}
							String value27 = (BRF202[26] == null) ? "0" : BRF202[26].toString();
							cell27.setCellValue(value27);

							///////////// C31//////////
							Cell cell31 = row.getCell(31);
							if (cell31 == null) {
								cell31 = row.createCell(31);
							}
							String value31 = (BRF202[30] == null) ? "0" : BRF202[30].toString();
							cell31.setCellValue(value31);

							///////////// C28//////////
							Cell cell28 = row.getCell(28);
							if (cell28 == null) {
								cell28 = row.createCell(28);
							}
							String value28 = (BRF202[27] == null) ? "0" : BRF202[27].toString();
							cell28.setCellValue(value28);

							///////////// C33//////////
							Cell cell33 = row.getCell(33);
							if (cell33 == null) {
								cell33 = row.createCell(33);
							}
							String value33 = (BRF202[32] == null) ? "0" : BRF202[32].toString();
							cell33.setCellValue(value33);

							///////////// C34//////////
							Cell cell34 = row.getCell(34);
							if (cell34 == null) {
								cell34 = row.createCell(34);
							}
							String value34 = (BRF202[33] == null) ? "0" : BRF202[33].toString();
							cell34.setCellValue(value34);

							///////////// C35//////////
							/*
							 * Cell cell35 = row.getCell(35); if (cell35 == null) { cell35 =
							 * row.createCell(35); } String value35 = (BRF202[34] == null) ? "0" :
							 * BRF202[34].toString(); cell35.setCellValue(value35);
							 */
							Cell cell35 = row.getCell(35);
							if (cell35 == null) {
								cell35 = row.createCell(35);
							}
							cell35.setCellValue(BRF202[34] == null ? 0 : ((BigDecimal) BRF202[34]).intValue());

							///////////// C36//////////
							/*
							 * Cell cell36 = row.getCell(36); if (cell36 == null) { cell36 =
							 * row.createCell(36); } String value36 = (BRF202[35] == null) ? "0" :
							 * BRF202[35].toString(); cell36.setCellValue(value36);
							 */
							Cell cell36 = row.getCell(36);
							if (cell36 == null) {
								cell36 = row.createCell(36);
							}
							cell36.setCellValue(BRF202[35] == null ? 0 : ((BigDecimal) BRF202[35]).intValue());

							///////////// C39//////////
							Cell cell39 = row.getCell(39);
							if (cell39 == null) {
								cell39 = row.createCell(39);
							}
							String value39 = (BRF202[38] == null) ? "0" : BRF202[38].toString();
							cell39.setCellValue(value39);

							///////////// C37//////////
							Cell cell37 = row.getCell(37);
							if (cell37 == null) {
								cell37 = row.createCell(37);
							}
							String value37 = (BRF202[36] == null) ? "0" : BRF202[36].toString();
							cell37.setCellValue(value37);

							///////////// C29//////////
							Cell cell29 = row.getCell(29);
							if (cell29 == null) {
								cell29 = row.createCell(29);
							}
							String value29 = (BRF202[28] == null) ? "0" : BRF202[28].toString();
							cell29.setCellValue(value29);

							///////////// C41//////////
							Cell cell41 = row.getCell(41);
							if (cell41 == null) {
								cell41 = row.createCell(41);
							}
							String value41 = (BRF202[40] == null) ? "0" : BRF202[40].toString();
							cell41.setCellValue(value41);

							///////////// C38//////////
							Cell cell38 = row.getCell(38);
							if (cell38 == null) {
								cell38 = row.createCell(38);
							}
							String value38 = (BRF202[37] == null) ? "0" : BRF202[37].toString();
							cell38.setCellValue(value38);

							///////////// C32//////////
							Cell cell32 = row.getCell(32);
							if (cell32 == null) {
								cell32 = row.createCell(32);
							}
							String value32 = (BRF202[31] == null) ? "0" : BRF202[31].toString();
							cell32.setCellValue(value32);
							/*
							 * ///////////// C40////////// Cell cell40 = row.getCell(40); if (cell40 ==
							 * null) { cell40 = row.createCell(40); } String value40 = (BRF202[39] == null)
							 * ? "0" : BRF202[39].toString(); cell40.setCellValue(value40);
							 */

						}

						// Save the changes
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-047-A.xls")) {
							workbook.write(fileOut);
							System.out.println("File saved successfully at: "
									+ env.getProperty("output.exportpathfinal") + "011-BRF-047-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-047-A.xls");

		return outputFile;

	}

	public ModelAndView getBRF202currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF202_DETAILTABLE  a where report_date = ?1 and report_label =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF202_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF202_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF202_DETAIL_ENTITY> T1Master = new ArrayList<BRF202_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF202_DETAIL_ENTITY a where a.report_date = ?1", BRF202_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String acct_crncy_code = (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[3];
			String bacid = (String) a[4];
			String constitution_code = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date) a[9];
			String create_user = (String) a[10];
			String cust_id = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			BigDecimal eab_lc = (BigDecimal) a[14];
			String entity_flg = (String) a[15];
			String foracid = (String) a[16];
			String gender = (String) a[17];
			String gl_code = (String) a[18];
			String gl_sub_head_code = (String) a[19];
			String gl_sub_head_desc = (String) a[20];
			String group_id = (String) a[21];
			BigDecimal hni_networth = (BigDecimal) a[22];
			String legal_entity_type = (String) a[23];
			Date maturity_date = (Date) a[24];
			String modify_flg = (String) a[25];
			Date modify_time = (Date) a[26];
			String modify_user = (String) a[27];
			String nre_flg = (String) a[28];
			String nre_status = (String) a[29];
			String purpose_of_advn = (String) a[30];
			String remarks = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			Date report_date = (Date) a[35];
			String report_label_1 = (String) a[36];
			String report_name_1 = (String) a[37];
			String schm_code = (String) a[38];
			String schm_type = (String) a[39];
			BigDecimal sector = (BigDecimal) a[40];
			String sector_code = (String) a[41];
			String segment = (String) a[42];
			String sol_id = (String) a[43];
			String sub_sector = (String) a[44];
			String sub_segment = (String) a[45];
			String turnover = (String) a[46];
			Date verify_time = (Date) a[47];
			String verify_user = (String) a[48];
			String version = (String) a[49];
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

			BRF202_DETAIL_ENTITY py = new BRF202_DETAIL_ENTITY(acct_crncy_code, acct_name, acid, act_balance_amt_lc,
					bacid, constitution_code, constitution_desc, country, country_of_incorp, create_time, create_user,
					cust_id, cust_type, del_flg, eab_lc, entity_flg, foracid, gender, gl_code, gl_sub_head_code,
					gl_sub_head_desc, group_id, hni_networth, legal_entity_type, maturity_date, modify_flg, modify_time,
					modify_user, nre_flg, nre_status, purpose_of_advn, remarks, report_addl_criteria_1,
					report_addl_criteria_2, report_addl_criteria_3, report_date, report_label_1, report_name_1,
					schm_code, schm_type, sector, sector_code, segment, sol_id, sub_sector, sub_segment, turnover,
					verify_time, verify_user, version);

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

		mv.setViewName("RR" + "/" + "BRF202A::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges202(BRF202_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF202_DETAIL_ENTITY> Brf202detail = brf202_DetailRep.findById(foracid);

			if (Brf202detail.isPresent()) {
				BRF202_DETAIL_ENTITY BRFdetail = Brf202detail.get();

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
					brf202_DetailRep.save(BRFdetail);

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

	public ModelAndView getArchieveBRF202View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		logger.info("Inside archive" + currency);
		List<BRF202A_entity> T1Master = hs
				.createNativeQuery(" select * from BRF202_SUMMARYTABLE order by r1_s_no", BRF202A_entity.class)
				.getResultList();

		long st_training_hrs = 0;
		long st_training_spent = 0;
		for (int i = 0; i < T1Master.size(); i++) {
			st_training_hrs = st_training_hrs + T1Master.get(i).getR1_training_hours_ytd().intValue();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
		for (int i = 0; i < T1Master.size(); i++) {
			st_training_spent = st_training_spent + T1Master.get(i).getR1_training_spent_aed().intValue();
		}
		System.out.println("The size is : " + T1Master.size());

		mv.setViewName("RR/BRF202ARCH");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("list", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);

		return mv;
	}

	/****
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView ARCHgetBRF202currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF202_ARCHIV_ENTITY a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF202_ARCHIV_ENTITY");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF202_ARCHIV_ENTITY  where report_date = ?1");
		}

		List<BRF202_ARCHIV_ENTITY> T1Master = new ArrayList<BRF202_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs
					.createQuery("from BRF202_ARCHIV_ENTITY a where a.report_date = ?1", BRF202_ARCHIV_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {

			BigDecimal act_balance_amt_lc = (BigDecimal) a[0];
			String acct_crncy_code = (String) a[1];
			String acct_name = (String) a[2];
			String acid = (String) a[3];
			String bacid = (String) a[4];
			String constitution_code = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date) a[9];
			String create_user = (String) a[10];
			String cust_id = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			BigDecimal eab_lc = (BigDecimal) a[14];
			String entity_flg = (String) a[15];
			String foracid = (String) a[16];
			String gender = (String) a[17];
			String gl_code = (String) a[18];
			String gl_sub_head_code = (String) a[19];
			String gl_sub_head_desc = (String) a[20];
			String group_id = (String) a[21];
			BigDecimal hni_networth = (BigDecimal) a[22];
			String legal_entity_type = (String) a[23];
			Date maturity_date = (Date) a[24];
			String modify_flg = (String) a[25];
			Date modify_time = (Date) a[26];
			String modify_user = (String) a[27];
			String nre_flg = (String) a[28];
			String nre_status = (String) a[29];
			String purpose_of_advn = (String) a[30];
			String remarks = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			Date report_date = (Date) a[35];
			String report_label_1 = (String) a[36];
			String report_name_1 = (String) a[37];
			String schm_code = (String) a[38];
			String schm_type = (String) a[39];
			BigDecimal sector = (BigDecimal) a[40];
			String sector_code = (String) a[41];
			String segment = (String) a[42];
			String sol_id = (String) a[43];
			String sub_sector = (String) a[44];
			String sub_segment = (String) a[45];
			String turnover = (String) a[46];
			Date verify_time = (Date) a[47];
			String verify_user = (String) a[48];
			String version = (String) a[49];
			// String Remarks1;
			if (act_balance_amt_lc != null) {
				if (act_balance_amt_lc.toString().contains("-")) {
					remarks = "DR";
				} else {
					remarks = "CR";
				}
			} else {
				remarks = "";
			}

			BRF202_ARCHIV_ENTITY py = new BRF202_ARCHIV_ENTITY(acct_crncy_code, acct_name, acid, act_balance_amt_lc,
					bacid, constitution_code, constitution_desc, country, country_of_incorp, create_time, create_user,
					cust_id, cust_type, del_flg, eab_lc, entity_flg, foracid, gender, gl_code, gl_sub_head_code,
					gl_sub_head_desc, group_id, hni_networth, legal_entity_type, maturity_date, modify_flg, modify_time,
					modify_user, nre_flg, nre_status, purpose_of_advn, remarks, report_addl_criteria_1,
					report_addl_criteria_2, report_addl_criteria_3, report_date, report_label_1, report_name_1,
					schm_code, schm_type, sector, sector_code, segment, sol_id, sub_sector, sub_segment, turnover,
					verify_time, verify_user, version);
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
		mv.setViewName("RR" + "/" + "BRF202ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String modifyBrf202A(ReportBRF202AData formData, Date asondate, String userId, HttpServletRequest req) {

		String msg = "";
		List<BRF202A_entity> existingReports = brf202A_entity_repo.getallDetails(asondate);
		List<BRF202A_entity> userData = formData.getBrf202A_entitys();

		List<String> oldValuesList = new ArrayList<>();
		List<String> newValuesList = new ArrayList<>();
		List<String> fieldNames = new ArrayList<>();

		List<String> finaloldval = new ArrayList<>();
		
		
		for (BRF202A_entity userdatas : userData) {
		    boolean found = false;
		    for (BRF202A_entity exiting : existingReports) {
		        if (exiting.getR1_s_no().equals(userdatas.getR1_s_no())) {
		            found = true;
		            break;
		        }
		    }
		    if (!found) {
		        finaloldval.add(userdatas.toString());
		    }
		}
		
		// StringBuilders to capture detailed changes
		StringBuilder oldChange = new StringBuilder();
		StringBuilder newChange = new StringBuilder();

		boolean rowEdited = false;

		for (BRF202A_entity datavalues : userData) {
			for (BRF202A_entity existingReport : existingReports) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getR1_s_no().compareTo(existingReport.getR1_s_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getR1_s_no() + " : ";

					if (datavalues.getR1_s_no().compareTo(existingReport.getR1_s_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getR1_s_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getR1_s_no()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_employee_name().compareTo(existingReport.getR1_employee_name()) != 0) {
						fieldNames.add("Employee Id");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_employee_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_employee_name())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_first_name().compareTo(existingReport.getR1_first_name()) != 0) {
						fieldNames.add("First Name");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_first_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_first_name())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_middle_name().compareTo(existingReport.getR1_middle_name()) != 0) {
						fieldNames.add("Middle Name	");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_middle_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_middle_name())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_last_name().compareTo(existingReport.getR1_last_name()) != 0) {
						fieldNames.add("Last Name");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_last_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_last_name())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_rt_code().compareTo(existingReport.getR1_rt_code()) != 0) {
						fieldNames.add("RT Code (Code)");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_rt_code())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_rt_code()).append("; ");
						rowEdited = true;
					}

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
// Compare "Date Of Joining"
					if (!sdf.format(datavalues.getR1_date_of_joining())
							.equals(sdf.format(existingReport.getR1_date_of_joining()))) {
						fieldNames.add("Date Of Joining (MM/DD/YYYY)");
						oldChange.append(rowPrefix).append("Column 8: ")
								.append(sdf.format(existingReport.getR1_date_of_joining())).append("; ");
						newChange.append(rowPrefix).append("Column 8: ")
								.append(sdf.format(datavalues.getR1_date_of_joining())).append("; ");
						rowEdited = true;
					}

// Compare "Date Of Birth"
					if (!sdf.format(datavalues.getR1_date_of_birth())
							.equals(sdf.format(existingReport.getR1_date_of_birth()))) {
						fieldNames.add("Date Of Birth (MM/DD/YYYY)");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(sdf.format(existingReport.getR1_date_of_birth())).append("; ");
						newChange.append(rowPrefix).append("Column 9: ")
								.append(sdf.format(datavalues.getR1_date_of_birth())).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_age().compareTo(existingReport.getR1_age()) != 0) {
						fieldNames.add("Age");
						oldChange.append(rowPrefix).append("Column 10: ").append(existingReport.getR1_age())
								.append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_age()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_age().compareTo(existingReport.getR1_age()) != 0) {
						fieldNames.add("Emirates ID Number*");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_age())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_age()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_gender().compareTo(existingReport.getR1_gender()) != 0) {
						fieldNames.add("Gender* (Code)");
						oldChange.append(rowPrefix).append("Column 12: ").append(existingReport.getR1_gender())
								.append("; ");
						newChange.append(rowPrefix).append("Column 12: ").append(datavalues.getR1_gender()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_nationality().compareTo(existingReport.getR1_nationality()) != 0) {
						fieldNames.add("Nationality* (Code)");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_nationality())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_nationality())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_if_nationality_is_ae_select_emirate()
							.compareTo(existingReport.getR1_if_nationality_is_ae_select_emirate()) != 0) {
						fieldNames.add("If Nationality is \"AE\", select Emirate(Code)");
						oldChange.append(rowPrefix).append("Column 14: ")
								.append(existingReport.getR1_if_nationality_is_ae_select_emirate()).append("; ");
						newChange.append(rowPrefix).append("Column 14: ")
								.append(datavalues.getR1_if_nationality_is_ae_select_emirate()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_emirate_work_location()
							.compareTo(existingReport.getR1_emirate_work_location()) != 0) {
						fieldNames.add("Emirate - Work Location* (Code)");
						oldChange.append(rowPrefix).append("Column 15: ")
								.append(existingReport.getR1_emirate_work_location()).append("; ");
						newChange.append(rowPrefix).append("Column 15: ")
								.append(datavalues.getR1_emirate_work_location()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_incase_nationality_is_aewhether_they_hold_family_book().compareTo(
							existingReport.getR1_incase_nationality_is_aewhether_they_hold_family_book()) != 0) {
						fieldNames.add("Incase Nationality is \"AE\" whether they hold Family Book*(Code)");
						oldChange.append(rowPrefix).append("Column 16: ")
								.append(existingReport.getR1_incase_nationality_is_aewhether_they_hold_family_book())
								.append("; ");
						newChange.append(rowPrefix).append("Column 16: ")
								.append(datavalues.getR1_incase_nationality_is_aewhether_they_hold_family_book())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_family_book_number()
							.compareTo(existingReport.getR1_family_book_number()) != 0) {
						fieldNames.add("Family Book Number*");
						oldChange.append(rowPrefix).append("Column 17: ")
								.append(existingReport.getR1_family_book_number()).append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_family_book_number())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_marital_status().compareTo(existingReport.getR1_marital_status()) != 0) {
						fieldNames.add("Marital Status (Code)");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_marital_status())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_marital_status())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_position().compareTo(existingReport.getR1_position()) != 0) {
						fieldNames.add("Position*(Code)");
						oldChange.append(rowPrefix).append("Column 19: ").append(existingReport.getR1_position())
								.append("; ");
						newChange.append(rowPrefix).append("Column 19: ").append(datavalues.getR1_position())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_department().compareTo(existingReport.getR1_department()) != 0) {
						fieldNames.add("Department*");
						oldChange.append(rowPrefix).append("Column 20: ").append(existingReport.getR1_department())
								.append("; ");
						newChange.append(rowPrefix).append("Column 20: ").append(datavalues.getR1_department())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_designation().compareTo(existingReport.getR1_designation()) != 0) {
						fieldNames.add("Designation*");
						oldChange.append(rowPrefix).append("Column 21: ").append(existingReport.getR1_designation())
								.append("; ");
						newChange.append(rowPrefix).append("Column 21: ").append(datavalues.getR1_designation())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_number_of_reportees()
							.compareTo(existingReport.getR1_number_of_reportees()) != 0) {
						fieldNames.add("Number of Reportees");
						oldChange.append(rowPrefix).append("Column 22: ")
								.append(existingReport.getR1_number_of_reportees()).append("; ");
						newChange.append(rowPrefix).append("Column 22: ").append(datavalues.getR1_number_of_reportees())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_highest_level_of_education()
							.compareTo(existingReport.getR1_highest_level_of_education()) != 0) {
						fieldNames.add("Highest Level of Education");
						oldChange.append(rowPrefix).append("Column 23: ")
								.append(existingReport.getR1_highest_level_of_education()).append("; ");
						newChange.append(rowPrefix).append("Column 23: ")
								.append(datavalues.getR1_highest_level_of_education()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_professional_certification()
							.compareTo(existingReport.getR1_professional_certification()) != 0) {
						fieldNames.add("Professional Certification");
						oldChange.append(rowPrefix).append("Column 24: ")
								.append(existingReport.getR1_professional_certification()).append("; ");
						newChange.append(rowPrefix).append("Column 24: ")
								.append(datavalues.getR1_professional_certification()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_number_of_years_of_experience()
							.compareTo(existingReport.getR1_number_of_years_of_experience()) != 0) {
						fieldNames.add("Number of Years of Experience (Overall Experience)");
						oldChange.append(rowPrefix).append("Column 25: ")
								.append(existingReport.getR1_number_of_years_of_experience()).append("; ");
						newChange.append(rowPrefix).append("Column 25: ")
								.append(datavalues.getR1_number_of_years_of_experience()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_number_of_dependents()
							.compareTo(existingReport.getR1_number_of_dependents()) != 0) {
						fieldNames.add("No. of Dependents");
						oldChange.append(rowPrefix).append("Column 26: ")
								.append(existingReport.getR1_number_of_dependents()).append("; ");
						newChange.append(rowPrefix).append("Column 26: ").append(datavalues.getR1_number_of_dependents())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_basic_salary_per_month()
							.compareTo(existingReport.getR1_basic_salary_per_month()) != 0) {
						fieldNames.add("Basic Salary per month");
						oldChange.append(rowPrefix).append("Column 27: ")
								.append(existingReport.getR1_basic_salary_per_month()).append("; ");
						newChange.append(rowPrefix).append("Column 27: ")
								.append(datavalues.getR1_basic_salary_per_month()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_monthly_national_allowance()
							.compareTo(existingReport.getR1_monthly_national_allowance()) != 0) {
						fieldNames
								.add("Monthly National Allowance (applicable for UAE Nationals with family book only)");
						oldChange.append(rowPrefix).append("Column 28: ")
								.append(existingReport.getR1_monthly_national_allowance()).append("; ");
						newChange.append(rowPrefix).append("Column 28: ")
								.append(datavalues.getR1_monthly_national_allowance()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_monthly_other_benifits()
							.compareTo(existingReport.getR1_monthly_other_benifits()) != 0) {
						fieldNames.add("Monthly other benefits (applicable for UAE Nationals with family book only");
						oldChange.append(rowPrefix).append("Column 29: ")
								.append(existingReport.getR1_monthly_other_benifits()).append("; ");
						newChange.append(rowPrefix).append("Column 29: ")
								.append(datavalues.getR1_monthly_other_benifits()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_monthly_salary_applicable_for_pention()
							.compareTo(existingReport.getR1_monthly_salary_applicable_for_pention()) != 0) {
						fieldNames.add(
								"Monthly salary applicable for pension (applicable for UAE Nationals with family book only)");
						oldChange.append(rowPrefix).append("Column 30: ")
								.append(existingReport.getR1_monthly_salary_applicable_for_pention()).append("; ");
						newChange.append(rowPrefix).append("Column 30: ")
								.append(datavalues.getR1_monthly_salary_applicable_for_pention()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_gross_salary_per_month()
							.compareTo(existingReport.getR1_gross_salary_per_month()) != 0) {
						fieldNames.add("Gross Salary per month");
						oldChange.append(rowPrefix).append("Column 31: ")
								.append(existingReport.getR1_gross_salary_per_month()).append("; ");
						newChange.append(rowPrefix).append("Column 31: ")
								.append(datavalues.getR1_gross_salary_per_month()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_pension_registration_reference()
							.compareTo(existingReport.getR1_pension_registration_reference()) != 0) {
						fieldNames.add("Pension Registration Reference / Code - for UAE Nationals only");
						oldChange.append(rowPrefix).append("Column 32: ")
								.append(existingReport.getR1_pension_registration_reference()).append("; ");
						newChange.append(rowPrefix).append("Column 32: ")
								.append(datavalues.getR1_pension_registration_reference()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_critical().compareTo(existingReport.getR1_critical()) != 0) {
						fieldNames.add("Critical*(Code)");
						oldChange.append(rowPrefix).append("Column 33: ").append(existingReport.getR1_critical())
								.append("; ");
						newChange.append(rowPrefix).append("Column 33: ").append(datavalues.getR1_critical())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_critical().compareTo(existingReport.getR1_critical()) != 0) {
						fieldNames.add("Type of Contract*(Code)");
						oldChange.append(rowPrefix).append("Column 34: ").append(existingReport.getR1_critical())
								.append("; ");
						newChange.append(rowPrefix).append("Column 34: ").append(datavalues.getR1_critical())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_previously_sponsored_student()
							.compareTo(existingReport.getR1_previously_sponsored_student()) != 0) {
						fieldNames.add("Previously sponsored student*(Code)");
						oldChange.append(rowPrefix).append("Column 35: ")
								.append(existingReport.getR1_previously_sponsored_student()).append("; ");
						newChange.append(rowPrefix).append("Column 35: ")
								.append(datavalues.getR1_previously_sponsored_student()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_training_hours_ytd()
							.compareTo(existingReport.getR1_training_hours_ytd()) != 0) {
						fieldNames.add("Training hours (YTD)");
						oldChange.append(rowPrefix).append("Column 36: ")
								.append(existingReport.getR1_training_hours_ytd()).append("; ");
						newChange.append(rowPrefix).append("Column 36: ").append(datavalues.getR1_training_hours_ytd())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_training_spent_aed()
							.compareTo(existingReport.getR1_training_spent_aed()) != 0) {
						fieldNames.add("Training Spent (AED)");
						oldChange.append(rowPrefix).append("Column 37: ")
								.append(existingReport.getR1_training_spent_aed()).append("; ");
						newChange.append(rowPrefix).append("Column 37: ").append(datavalues.getR1_training_spent_aed())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_emiratization_kpi_included()
							.compareTo(existingReport.getR1_emiratization_kpi_included()) != 0) {
						fieldNames.add("Emiratization KPI included*(Code)");
						oldChange.append(rowPrefix).append("Column 38: ")
								.append(existingReport.getR1_emiratization_kpi_included()).append("; ");
						newChange.append(rowPrefix).append("Column 38: ")
								.append(datavalues.getR1_emiratization_kpi_included()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_percentage_of_kpi().compareTo(existingReport.getR1_percentage_of_kpi()) != 0) {
						fieldNames.add("% of KPI");
						oldChange.append(rowPrefix).append("Column 39: ")
								.append(existingReport.getR1_percentage_of_kpi()).append("; ");
						newChange.append(rowPrefix).append("Column 39: ").append(datavalues.getR1_percentage_of_kpi())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getR1_ceo_and_staff_reporting_directly_to_ceocountry_manager().compareTo(
							existingReport.getR1_ceo_and_staff_reporting_directly_to_ceocountry_manager()) != 0) {
						fieldNames.add("CEO and Staff reporting directly to CEO / Country Manager(Code)");
						oldChange.append(rowPrefix).append("Column 40: ")
								.append(existingReport.getR1_ceo_and_staff_reporting_directly_to_ceocountry_manager())
								.append("; ");
						newChange.append(rowPrefix).append("Column 40: ")
								.append(datavalues.getR1_ceo_and_staff_reporting_directly_to_ceocountry_manager())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getTotal_spending_on_trainings_attended_by_both_emiratis_and_expats()
							.compareTo(existingReport
									.getTotal_spending_on_trainings_attended_by_both_emiratis_and_expats()) != 0) {
						fieldNames.add(
								"Total amount spent during the year on trainings for Emiratis and expats (excluding trainings conducted specifically for Emiratis only)");
						oldChange
								.append(existingReport
										.getTotal_spending_on_trainings_attended_by_both_emiratis_and_expats())
								.append("; ");
						newChange
								.append(datavalues
										.getTotal_spending_on_trainings_attended_by_both_emiratis_and_expats())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getTotal_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats()
							.compareTo(existingReport
									.getTotal_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats()) != 0) {
						fieldNames.add(
								"Total number of participants attended the trainings for Emiratis and expats (excluding trainings conducted specifically for Emiratis only)");
						oldChange.append(existingReport
								.getTotal_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats())
								.append("; ");
						newChange.append(datavalues
								.getTotal_number_of_trainees_on_trainings_attended_by_both_emiratis_and_expats())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getTotal_number_of_emiratis_attended_trainings_for_all_employees().compareTo(
							existingReport.getTotal_number_of_emiratis_attended_trainings_for_all_employees()) != 0) {
						fieldNames.add("Total number of Emiratis participated in the trainings mentioned above");
						oldChange
								.append(existingReport
										.getTotal_number_of_emiratis_attended_trainings_for_all_employees())
								.append("; ");
						newChange.append(datavalues.getTotal_number_of_emiratis_attended_trainings_for_all_employees())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getTotal_number_of_emiratis_in_company()
							.compareTo(existingReport.getTotal_number_of_emiratis_in_company()) != 0) {
						fieldNames.add(
								"Total number of Emiratis in the bank (include the Emirati left during the year and attended the trainings as mentioned above)");
						oldChange.append(existingReport.getTotal_number_of_emiratis_in_company()).append("; ");
						newChange.append(datavalues.getTotal_number_of_emiratis_in_company()).append("; ");
						rowEdited = true;
					}

					if (datavalues.getTotal_spending_on_trainings_attended_by_emiratis_only().compareTo(
							existingReport.getTotal_spending_on_trainings_attended_by_emiratis_only()) != 0) {
						fieldNames.add(
								"Total amount spent during the year on trainings conducted specifically for Emiratis only");
						oldChange
								.append(existingReport
										.getTotal_number_of_emiratis_attended_trainings_for_all_employees())
								.append("; ");
						newChange.append(datavalues.getTotal_number_of_emiratis_attended_trainings_for_all_employees())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getNumber_of_others_left_during_the_reporting_period()
							.compareTo(existingReport.getNumber_of_others_left_during_the_reporting_period()) != 0) {
						fieldNames.add("Number of expats left during the reporting period");
						oldChange.append(existingReport.getNumber_of_others_left_during_the_reporting_period())
								.append("; ");
						newChange.append(datavalues.getNumber_of_others_left_during_the_reporting_period())
								.append("; ");
						rowEdited = true;
					}

					if (datavalues.getNumber_of_emiratis_left_during_the_reporting_period()
							.compareTo(existingReport.getNumber_of_emiratis_left_during_the_reporting_period()) != 0) {
						fieldNames.add("Number of Emiratis left during the reporting period");
						oldChange.append(existingReport.getNumber_of_emiratis_left_during_the_reporting_period())
								.append("; ");
						newChange.append(datavalues.getNumber_of_emiratis_left_during_the_reporting_period())
								.append("; ");
						rowEdited = true;
					}

				}
			}
		}
		if (rowEdited) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
			// Here, save the updated report for each row in the database
			// Example: yourRepository.save(userReport);
		}

		if (Objects.nonNull(userData) && userData.size() > 0) {
			List<BRF202A_entity> docDetails = new ArrayList<>();
			for (BRF202A_entity entity : userData) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				;
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				docDetails.add(entity);
			}
			brf202A_entity_repo.saveAll(docDetails);

			// Fetch all reports for comparison

			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			if (existingReports.size() == userData.size()) {
			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFY");
			audit.setAudit_table("BRF202_SUMMARYTABLE");
			audit.setAudit_screen("MODIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setOld_value(String.join("; ", oldValuesList));
			audit.setNew_value(String.join("; ", newValuesList));
			System.out.println("New Values: " + String.join("; ", newValuesList));
			audit.setField_name(String.join("; ", fieldNames));
			audit.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);

			mANUAL_Service_Rep.save(audit);
			}else {
				MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
				audit.setAudit_date(new Date());
				audit.setEntry_time(new Date());
				audit.setEntry_user(user1);
				audit.setFunc_code("ADD");
				audit.setAudit_table("BRF202_SUMMARYTABLE");
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

			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		return msg;
	}

	public String verifyBRF202Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";
		List<BRF202A_entity> existingReports = brf202A_entity_repo.getallDetails(asondate);

		if (Objects.nonNull(existingReports) && !existingReports.isEmpty()) {
			List<BRF202A_entity> updatedReports = new ArrayList<>();
			for (BRF202A_entity entity : existingReports) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf202A_entity_repo.saveAll(updatedReports);
			msg = "Verify Successfully";

			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
			audit.setAudit_date(new Date());
			audit.setEntry_time(new Date());
			audit.setEntry_user(user1);
			audit.setFunc_code("VERIFY");
			audit.setAudit_table("BRF202_SUMMARYTABLE");
			audit.setAudit_screen("VERIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setRemarks("Verify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			audit.setAuth_user(values1.getAuth_user());
			audit.setAuth_time(values1.getAuth_time());
			audit.setAudit_ref_no(auditID);
			mANUAL_Service_Rep.save(audit);
		} else {
			msg = "Data Not Found";
		}

		return msg;
	}

}
