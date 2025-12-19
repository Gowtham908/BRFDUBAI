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

import com.bornfire.xbrl.entities.BRBS.BRF181BServiceRepo;
 import com.bornfire.xbrl.entities.BRBS.BRF181AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF181DETAIL_Repo;
import com.bornfire.xbrl.entities.BRBS.BRF181_ARCHIVEENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF181_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
/*import com.bornfire.xbrl.entities.BRBS.BRF73_TABLE1;
import com.bornfire.xbrl.entities.BRBS.BRF73_TABLE2;*/
import com.bornfire.xbrl.entities.BRBS.BRF_181_A1_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_181_A2_REPORT_ENTITY;
 import com.bornfire.xbrl.entities.BRBS.ReportBRF181Data;
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
public class BRF181AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF181AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	 
	@Autowired
	BRF181AServiceRepo brf181aServiceRepo;
	@Autowired
	BRF181BServiceRepo brf181bServiceRepo;
	
	@Autowired
	BRF181DETAIL_Repo bRF181DETAIL_Repo;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF181A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF_181_A1_REPORT_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF_181_A1_REPORT_ENTITY a ").getSingleResult();
					if (modcnt > 0) {
						msg = "success";
					}
				} else {
				//	msg = "Data Not available for the Report. Please Contact Administrator";
					msg = "success";

				}

			} catch (Exception e) {
				logger.info(e.getMessage());
				msg = "success";
				e.printStackTrace();

			}

			return msg;

		}


	public ModelAndView getBRF181AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable,String req) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF_181_A1_REPORT_ENTITY> T1rep = new ArrayList<BRF_181_A1_REPORT_ENTITY>();
			// Query<Object[]> qr;

			List<BRF_181_A1_REPORT_ENTITY> T1Master = new ArrayList<BRF_181_A1_REPORT_ENTITY>();
			List<BRF_181_A2_REPORT_ENTITY> T1Master1 = new ArrayList<BRF_181_A2_REPORT_ENTITY>();
			
			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from BRF_181_A1_REPORT_ENTITY a where a.report_date = ?1 ",BRF_181_A1_REPORT_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

				T1Master1 = hs.createQuery("from BRF_181_A2_REPORT_ENTITY a where a.report_date = ?1 ", BRF_181_A2_REPORT_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
			
			} catch (ParseException e)
			{			
				e.printStackTrace();
				}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF181");
			// mv.addObject("currlist", refCodeConfig.currList());
			mv.addObject("reportsummary", T1Master);
			mv.addObject("reportsummary1", T1Master1);
			
			mv.addObject("reportmaster", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			mv.addObject("modify_flg", T1Master1.size() > 0 ? T1Master1.get(0).getModify_flg() : null);
			mv.addObject("modify_user", T1Master1.size() > 0 ? T1Master1.get(0).getModify_user() : null);
			
			 // mv.addObject("operation", "111"); if(req=="BFI0039") {
			  mv.addObject("operation", req);
			  System.out.println("USER ID issssssssssssssssssssssssssss"+req); 
			 
			System.out.println("scv" + mv.getViewName());

			return mv;

		}
	public ModelAndView getBRF181ADetails(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF181_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF181_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF181_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF181_DETAIL_ENTITY> T1Master = new ArrayList<BRF181_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF181_DETAIL_ENTITY a where a.report_date = ?1", BRF181_DETAIL_ENTITY.class)
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
			String entity_flg = (String) a[40];
			String modify_flg = (String) a[41];
			String del_flg = (String) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			String nre_flg = (String) a[49];

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

			BRF181_DETAIL_ENTITY py = new BRF181_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg);
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

		mv.setViewName("RR" + "/" + "BRF181::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	public File getFileBRF181A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName =  "011-BRF-181-A";
		/*try {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
			Date ConDate = dateFormat1.parse(todate);
			System.out.println(ConDate);
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			String strDate1 = formatter1.format(ConDate);
			fileName = "t" + reportId + "_" + strDate1;
			

		} catch (ParseException e1) {

			logger.info(e1.getMessage());
			e1.printStackTrace();
		}*/

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF181_Details.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF181_Details.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF181.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF181.jrxml");
					}
				}

				//JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
				JasperReport jr
				  = JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_DATE", todate);
			/*	try {
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
					Date ConDate = dateFormat1.parse(todate);
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					String strDate1 = formatter1.format(ConDate);

					String today = dateFormat.format(new SimpleDateFormat("dd-MMM-yyyy").parse(strDate1));
					
				} catch (ParseException e1) {

					logger.info(e1.getMessage());
					e1.printStackTrace();
				}
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
			List<BRF_181_A1_REPORT_ENTITY> T1Master = new ArrayList<>();
			List<BRF_181_A2_REPORT_ENTITY> T1Master1 = new ArrayList<>();

			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);

				T1Master = hs.createQuery("from BRF_181_A1_REPORT_ENTITY a where a.report_date = ?1", BRF_181_A1_REPORT_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				T1Master1 = hs.createQuery("from BRF_181_A2_REPORT_ENTITY a where a.report_date = ?1", BRF_181_A2_REPORT_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

				File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-181-AT.xls");
				Workbook workbook = WorkbookFactory.create(responseCamt);
				
				Sheet sheet = workbook.getSheetAt(0);
				
				if (T1Master.size() == 1) {
					for (BRF_181_A1_REPORT_ENTITY brf181 : T1Master) {
					//Corporate Loans - as guidance consider aligning with BRF 1
					Row row = sheet.getRow(10);
					Cell cell = row.getCell(3);
					if (cell != null) {
					cell.setCellValue(brf181.getR1_STANDALONE() == null ? 0 :
						brf181.getR1_STANDALONE().intValue());
					}
					Cell cell1 = row.getCell(4);
					if (cell1 != null) {
					cell1.setCellValue(brf181.getR1_CONSOLIDATED() == null ? 0 :
						brf181.getR1_CONSOLIDATED().intValue());
					}
					Row row1 = sheet.getRow(11);
					Cell cell2 = row1.getCell(3);
					if (cell2 != null) {
					cell2.setCellValue(brf181.getR2_STANDALONE() == null ? 0 :
						brf181.getR2_STANDALONE().intValue());
					}
					Cell cell3 = row1.getCell(4);
					if (cell3 != null) {
					cell3.setCellValue(brf181.getR2_CONSOLIDATED() == null ? 0 :
						brf181.getR2_CONSOLIDATED().intValue());
					}
					Row row2 = sheet.getRow(12);
					Cell cell4 = row2.getCell(3);
					if (cell4 != null) {
					cell4.setCellValue(brf181.getR3_STANDALONE() == null ? 0 :
						brf181.getR3_STANDALONE().intValue());
					}
					Cell cell5 = row2.getCell(4);
					if (cell5 != null) {
					cell5.setCellValue(brf181.getR3_CONSOLIDATED() == null ? 0 :
						brf181.getR3_CONSOLIDATED().intValue());
					}
					Row row3 = sheet.getRow(13);
					Cell cell6 = row3.getCell(3);
					if (cell6 != null) {
					cell6.setCellValue(brf181.getR4_STANDALONE() == null ? 0 :
						brf181.getR4_STANDALONE().intValue());
					}
					Cell cell7 = row3.getCell(4);
					if (cell7 != null) {
					cell7.setCellValue(brf181.getR4_CONSOLIDATED() == null ? 0 :
						brf181.getR4_CONSOLIDATED().intValue());
					}
					Row row4 = sheet.getRow(14);
					Cell cell8 = row4.getCell(3);
					if (cell8 != null) {
					cell8.setCellValue(brf181.getR5_STANDALONE() == null ? 0 :
						brf181.getR5_STANDALONE().intValue());
					}
					Cell cell9 = row4.getCell(4);
					if (cell9 != null) {
					cell9.setCellValue(brf181.getR5_CONSOLIDATED() == null ? 0 :
						brf181.getR5_CONSOLIDATED().intValue());
					}
					Row row5 = sheet.getRow(15);
					Cell cell10 = row5.getCell(3);
					if (cell10 != null) {
					cell10.setCellValue(brf181.getR6_STANDALONE() == null ? 0 :
						brf181.getR6_STANDALONE().intValue());
					}
					Cell cell11 = row5.getCell(4);
					if (cell11 != null) {
					cell11.setCellValue(brf181.getR6_CONSOLIDATED() == null ? 0 :
						brf181.getR6_CONSOLIDATED().intValue());
					}				
					Row row6 = sheet.getRow(16);
					Cell cell12 = row6.getCell(3);
					if (cell12 != null) {
					cell12.setCellValue(brf181.getR7_STANDALONE() == null ? 0 :
						brf181.getR7_STANDALONE().intValue());
					}
					Cell cell13 = row6.getCell(4);
					if (cell13 != null) {
					cell13.setCellValue(brf181.getR7_CONSOLIDATED() == null ? 0 :
						brf181.getR7_CONSOLIDATED().intValue());
					}
					Row row7 = sheet.getRow(17);
					Cell cell14 = row7.getCell(3);
					if (cell14 != null) {
					cell14.setCellValue(brf181.getR8_STANDALONE() == null ? 0 :
						brf181.getR8_STANDALONE().intValue());
					}
					Cell cell15 = row7.getCell(4);
					if (cell15 != null) {
					cell15.setCellValue(brf181.getR8_CONSOLIDATED() == null ? 0 :
						brf181.getR8_CONSOLIDATED().intValue());
					}
					Row row8 = sheet.getRow(18);
					Cell cell16 = row8.getCell(3);
					if (cell16 != null) {
					cell16.setCellValue(brf181.getR9_STANDALONE() == null ? 0 :
						brf181.getR9_STANDALONE().intValue());
					}
					Cell cell17 = row8.getCell(4);
					if (cell17 != null) {
					cell17.setCellValue(brf181.getR9_CONSOLIDATED() == null ? 0 :
						brf181.getR9_CONSOLIDATED().intValue());
					}
					Row row9 = sheet.getRow(19);
					Cell cell18 = row9.getCell(3);
					if (cell18 != null) {
					cell18.setCellValue(brf181.getR10_STANDALONE() == null ? 0 :
						brf181.getR10_STANDALONE().intValue());
					}
					Cell cell19 = row9.getCell(4);
					if (cell19 != null) {
					cell19.setCellValue(brf181.getR10_CONSOLIDATED() == null ? 0 :
						brf181.getR10_CONSOLIDATED().intValue());
					}
					Row row10 = sheet.getRow(20);
					Cell cell20 = row10.getCell(3);
					if (cell20 != null) {
					cell20.setCellValue(brf181.getR11_STANDALONE() == null ? 0 :
						brf181.getR11_STANDALONE().intValue());
					}
					Cell cell21 = row10.getCell(4);
					if (cell21 != null) {
					cell21.setCellValue(brf181.getR11_CONSOLIDATED() == null ? 0 :
						brf181.getR11_CONSOLIDATED().intValue());
					}
					Row row11 = sheet.getRow(21);
					Cell cell22 = row11.getCell(3);
					if (cell22 != null) {
					cell22.setCellValue(brf181.getR12_STANDALONE() == null ? 0 :
						brf181.getR12_STANDALONE().intValue());
					}
					Cell cell23 = row11.getCell(4);
					if (cell23 != null) {
					cell23.setCellValue(brf181.getR12_CONSOLIDATED() == null ? 0 :
						brf181.getR12_CONSOLIDATED().intValue());
					}
					Row row12 = sheet.getRow(22);
					Cell cell24 = row12.getCell(3);
					if (cell24 != null) {
					cell24.setCellValue(brf181.getR13_STANDALONE() == null ? 0 :
						brf181.getR13_STANDALONE().intValue());
					}
					Cell cell25 = row12.getCell(4);
					if (cell25 != null) {
					cell25.setCellValue(brf181.getR13_CONSOLIDATED() == null ? 0 :
						brf181.getR13_CONSOLIDATED().intValue());
					}
					Row row13 = sheet.getRow(23);
					Cell cell26 = row13.getCell(3);
					if (cell26 != null) {
					cell26.setCellValue(brf181.getR14_STANDALONE() == null ? 0 :
						brf181.getR14_STANDALONE().intValue());
					}
					Cell cell27 = row13.getCell(4);
					if (cell27 != null) {
					cell27.setCellValue(brf181.getR14_CONSOLIDATED() == null ? 0 :
						brf181.getR14_CONSOLIDATED().intValue());
					}
					Row row14 = sheet.getRow(24);
					Cell cell28 = row14.getCell(3);
					if (cell28 != null) {
					cell28.setCellValue(brf181.getR15_STANDALONE() == null ? 0 :
						brf181.getR15_STANDALONE().intValue());
					}
					Cell cell29 = row14.getCell(4);
					if (cell29 != null) {
					cell29.setCellValue(brf181.getR15_CONSOLIDATED() == null ? 0 :
						brf181.getR15_CONSOLIDATED().intValue());
					}
					Row row15 = sheet.getRow(25);
					Cell cell30 = row15.getCell(3);
					if (cell30 != null) {
					cell30.setCellValue(brf181.getR16_STANDALONE() == null ? 0 :
						brf181.getR16_STANDALONE().intValue());
					}
					Cell cell31 = row15.getCell(4);
					if (cell31 != null) {
					cell31.setCellValue(brf181.getR16_CONSOLIDATED() == null ? 0 :
						brf181.getR16_CONSOLIDATED().intValue());
					}		
					Row row16 = sheet.getRow(26);
					Cell cell32 = row16.getCell(3);
					if (cell32 != null) {
					cell32.setCellValue(brf181.getR17_STANDALONE() == null ? 0 :
						brf181.getR17_STANDALONE().intValue());
					}
					Cell cell33 = row16.getCell(4);
					if (cell33 != null) {
					cell33.setCellValue(brf181.getR17_CONSOLIDATED() == null ? 0 :
						brf181.getR17_CONSOLIDATED().intValue());
					}
					Row row17 = sheet.getRow(27);
					Cell cell34 = row17.getCell(3);
					if (cell34 != null) {
					cell34.setCellValue(brf181.getR18_STANDALONE() == null ? 0 :
						brf181.getR18_STANDALONE().intValue());
					}
					Cell cell35 = row17.getCell(4);
					if (cell35 != null) {
					cell35.setCellValue(brf181.getR18_CONSOLIDATED() == null ? 0 :
						brf181.getR18_CONSOLIDATED().intValue());
					}
					Row row18 = sheet.getRow(28);
					Cell cell36 = row18.getCell(3);
					if (cell36 != null) {
					cell36.setCellValue(brf181.getR19_STANDALONE() == null ? 0 :
						brf181.getR19_STANDALONE().intValue());
					}
					Cell cell37 = row18.getCell(4);
					if (cell37 != null) {
					cell37.setCellValue(brf181.getR19_CONSOLIDATED() == null ? 0 :
						brf181.getR19_CONSOLIDATED().intValue());
					}
					Row row19 = sheet.getRow(29);
					Cell cell38 = row19.getCell(3);
					if (cell38 != null) {
					cell38.setCellValue(brf181.getR20_STANDALONE() == null ? 0 :
						brf181.getR20_STANDALONE().intValue());
					}
					Cell cell39 = row19.getCell(4);
					if (cell39 != null) {
					cell39.setCellValue(brf181.getR20_CONSOLIDATED() == null ? 0 :
						brf181.getR20_CONSOLIDATED().intValue());
					}
					Row row20 = sheet.getRow(30);
					Cell cell40 = row20.getCell(3);
					if (cell40 != null) {
					cell40.setCellValue(brf181.getR21_STANDALONE() == null ? 0 :
						brf181.getR21_STANDALONE().intValue());
					}
					Cell cell41 = row20.getCell(4);
					if (cell41 != null) {
					cell41.setCellValue(brf181.getR21_CONSOLIDATED() == null ? 0 :
						brf181.getR21_CONSOLIDATED().intValue());
					}
					Row row21 = sheet.getRow(31);
					Cell cell42 = row21.getCell(3);
					if (cell42 != null) {
					cell42.setCellValue(brf181.getR22_STANDALONE() == null ? 0 :
						brf181.getR22_STANDALONE().intValue());
					}
					Cell cell43 = row21.getCell(4);
					if (cell43 != null) {
					cell43.setCellValue(brf181.getR22_CONSOLIDATED() == null ? 0 :
						brf181.getR22_CONSOLIDATED().intValue());
					}
					Row row22 = sheet.getRow(32);
					Cell cell44 = row22.getCell(3);
					if (cell44 != null) {
					cell44.setCellValue(brf181.getR23_STANDALONE() == null ? 0 :
						brf181.getR23_STANDALONE().intValue());
					}
					Cell cell45 = row22.getCell(4);
					if (cell45 != null) {
					cell45.setCellValue(brf181.getR23_CONSOLIDATED() == null ? 0 :
						brf181.getR23_CONSOLIDATED().intValue());
					}
					Row row23 = sheet.getRow(33);
					Cell cell46 = row23.getCell(3);
					if (cell46 != null) {
					cell46.setCellValue(brf181.getR24_STANDALONE() == null ? 0 :
						brf181.getR24_STANDALONE().intValue());
					}
					Cell cell47 = row23.getCell(4);
					if (cell47 != null) {
					cell47.setCellValue(brf181.getR24_CONSOLIDATED() == null ? 0 :
						brf181.getR24_CONSOLIDATED().intValue());
					}
					Row row24 = sheet.getRow(34);
					Cell cell48 = row24.getCell(3);
					if (cell48 != null) {
					cell48.setCellValue(brf181.getR25_STANDALONE() == null ? 0 :
						brf181.getR25_STANDALONE().intValue());
					}
					Cell cell49 = row24.getCell(4);
					if (cell49 != null) {
					cell49.setCellValue(brf181.getR25_CONSOLIDATED() == null ? 0 :
						brf181.getR25_CONSOLIDATED().intValue());
					}
					Row row25 = sheet.getRow(35);
					Cell cell50 = row25.getCell(3);
					if (cell50 != null) {
					cell50.setCellValue(brf181.getR26_STANDALONE() == null ? 0 :
						brf181.getR26_STANDALONE().intValue());
					}
					Cell cell51 = row25.getCell(4);
					if (cell51 != null) {
					cell51.setCellValue(brf181.getR26_CONSOLIDATED() == null ? 0 :
						brf181.getR26_CONSOLIDATED().intValue());
					}
					Row row26 = sheet.getRow(36);
					Cell cell62 = row26.getCell(3);
					if (cell62 != null) {
					cell62.setCellValue(brf181.getR27_STANDALONE() == null ? 0 :
						brf181.getR27_STANDALONE().intValue());
					}
					Cell cell63 = row26.getCell(4);
					if (cell63 != null) {
					cell63.setCellValue(brf181.getR27_CONSOLIDATED() == null ? 0 :
						brf181.getR27_CONSOLIDATED().intValue());
					}
					Row row27 = sheet.getRow(37);
					Cell cell64 = row27.getCell(3);
					if (cell64 != null) {
					cell64.setCellValue(brf181.getR28_STANDALONE() == null ? 0 :
						brf181.getR28_STANDALONE().intValue());
					}
					Cell cell65 = row27.getCell(4);
					if (cell65 != null) {
					cell65.setCellValue(brf181.getR28_CONSOLIDATED() == null ? 0 :
						brf181.getR28_CONSOLIDATED().intValue());
					}
					Row row28 = sheet.getRow(38);
					Cell cell66 = row28.getCell(3);
					if (cell66 != null) {
					cell66.setCellValue(brf181.getR29_STANDALONE() == null ? 0 :
						brf181.getR29_STANDALONE().intValue());
					}
					Cell cell67 = row28.getCell(4);
					if (cell67 != null) {
					cell67.setCellValue(brf181.getR29_CONSOLIDATED() == null ? 0 :
						brf181.getR29_CONSOLIDATED().intValue());
					}
					Row row29 = sheet.getRow(39);
					Cell cell68 = row29.getCell(3);
					if (cell68 != null) {
					cell68.setCellValue(brf181.getR30_STANDALONE() == null ? 0 :
						brf181.getR30_STANDALONE().intValue());
					}
					Cell cell69 = row29.getCell(4);
					if (cell69 != null) {
					cell69.setCellValue(brf181.getR30_CONSOLIDATED() == null ? 0 :
						brf181.getR30_CONSOLIDATED().intValue());
					}
					Row row30 = sheet.getRow(40);
					Cell cell70 = row30.getCell(3);
					if (cell70 != null) {
					cell70.setCellValue(brf181.getR31_STANDALONE() == null ? 0 :
						brf181.getR31_STANDALONE().intValue());
					}
					Cell cell71 = row30.getCell(4);
					if (cell71 != null) {
					cell71.setCellValue(brf181.getR31_CONSOLIDATED() == null ? 0 :
						brf181.getR31_CONSOLIDATED().intValue());
					}
					Row row31 = sheet.getRow(41);
					Cell cell72 = row31.getCell(3);
					if (cell72 != null) {
					cell72.setCellValue(brf181.getR32_STANDALONE() == null ? 0 :
						brf181.getR32_STANDALONE().intValue());
					}
					Cell cell73 = row31.getCell(4);
					if (cell73 != null) {
					cell73.setCellValue(brf181.getR32_CONSOLIDATED() == null ? 0 :
						brf181.getR32_CONSOLIDATED().intValue());
					}
					Row row32 = sheet.getRow(42);
					Cell cell74 = row32.getCell(3);
					if (cell74 != null) {
					cell74.setCellValue(brf181.getR33_STANDALONE() == null ? 0 :
						brf181.getR33_STANDALONE().intValue());
					}
					Cell cell75 = row32.getCell(4);
					if (cell75 != null) {
					cell75.setCellValue(brf181.getR33_CONSOLIDATED() == null ? 0 :
						brf181.getR33_CONSOLIDATED().intValue());
					}
					Row row33 = sheet.getRow(43);
					Cell cell76 = row33.getCell(3);
					if (cell76 != null) {
					cell76.setCellValue(brf181.getR34_STANDALONE() == null ? 0 :
						brf181.getR34_STANDALONE().intValue());
					}
					Cell cell77 = row33.getCell(4);
					if (cell77 != null) {
					cell77.setCellValue(brf181.getR34_CONSOLIDATED() == null ? 0 :
						brf181.getR34_CONSOLIDATED().intValue());
					}
					Row row34 = sheet.getRow(44);
					Cell cell78 = row34.getCell(3);
					if (cell78 != null) {
					cell78.setCellValue(brf181.getR35_STANDALONE() == null ? 0 :
						brf181.getR35_STANDALONE().intValue());
					}
					Cell cell79 = row34.getCell(4);
					if (cell79 != null) {
					cell79.setCellValue(brf181.getR35_CONSOLIDATED() == null ? 0 :
						brf181.getR35_CONSOLIDATED().intValue());
					}
					Row row35 = sheet.getRow(45);
					Cell cell80 = row35.getCell(3);
					if (cell80 != null) {
					cell80.setCellValue(brf181.getR36_STANDALONE() == null ? 0 :
						brf181.getR36_STANDALONE().intValue());
					}
					Cell cell81 = row35.getCell(4);
					if (cell81 != null) {
					cell81.setCellValue(brf181.getR36_CONSOLIDATED() == null ? 0 :
						brf181.getR36_CONSOLIDATED().intValue());
					}
					Row row36 = sheet.getRow(46);
					Cell cell82 = row36.getCell(3);
					if (cell82 != null) {
					cell82.setCellValue(brf181.getR37_STANDALONE() == null ? 0 :
						brf181.getR37_STANDALONE().intValue());
					}
					Cell cell83 = row36.getCell(4);
					if (cell83 != null) {
					cell83.setCellValue(brf181.getR37_CONSOLIDATED() == null ? 0 :
						brf181.getR37_CONSOLIDATED().intValue());
					}
					Row row37 = sheet.getRow(47);
					Cell cell84 = row37.getCell(3);
					if (cell84 != null) {
					cell84.setCellValue(brf181.getR38_STANDALONE() == null ? 0 :
						brf181.getR38_STANDALONE().intValue());
					}
					Cell cell85 = row37.getCell(4);
					if (cell85 != null) {
					cell85.setCellValue(brf181.getR38_CONSOLIDATED() == null ? 0 :
						brf181.getR38_CONSOLIDATED().intValue());
					}
					Row row38 = sheet.getRow(48);
					Cell cell86 = row38.getCell(3);
					if (cell86 != null) {
					cell86.setCellValue(brf181.getR39_STANDALONE() == null ? 0 :
						brf181.getR39_STANDALONE().intValue());
					}
					Cell cell87 = row38.getCell(4);
					if (cell87 != null) {
					cell87.setCellValue(brf181.getR39_CONSOLIDATED() == null ? 0 :
						brf181.getR39_CONSOLIDATED().intValue());
					}
					Row row39 = sheet.getRow(49);
					Cell cell88 = row39.getCell(3);
					if (cell88 != null) {
					cell88.setCellValue(brf181.getR40_STANDALONE() == null ? 0 :
						brf181.getR40_STANDALONE().intValue());
					}
					Cell cell89 = row39.getCell(4);
					if (cell89 != null) {
					cell89.setCellValue(brf181.getR40_CONSOLIDATED() == null ? 0 :
						brf181.getR40_CONSOLIDATED().intValue());
					}
					Row row40 = sheet.getRow(50);
					Cell cell90 = row40.getCell(3);
					if (cell90 != null) {
					cell90.setCellValue(brf181.getR41_STANDALONE() == null ? 0 :
						brf181.getR41_STANDALONE().intValue());
					}
					Cell cell91 = row40.getCell(4);
					if (cell91 != null) {
					cell91.setCellValue(brf181.getR41_CONSOLIDATED() == null ? 0 :
						brf181.getR41_CONSOLIDATED().intValue());
					}
					Row row41 = sheet.getRow(51);
					Cell cell92 = row41.getCell(3);
					if (cell92 != null) {
					cell92.setCellValue(brf181.getR42_STANDALONE() == null ? 0 :
						brf181.getR42_STANDALONE().intValue());
					}
					Cell cell93 = row41.getCell(4);
					if (cell93 != null) {
					cell93.setCellValue(brf181.getR42_CONSOLIDATED() == null ? 0 :
						brf181.getR42_CONSOLIDATED().intValue());
					}
					Row row42 = sheet.getRow(52);
					Cell cell94 = row42.getCell(3);
					if (cell94 != null) {
					cell94.setCellValue(brf181.getR43_STANDALONE() == null ? 0 :
						brf181.getR43_STANDALONE().intValue());
					}
					Cell cell95 = row42.getCell(4);
					if (cell95 != null) {
					cell95.setCellValue(brf181.getR43_CONSOLIDATED() == null ? 0 :
						brf181.getR43_CONSOLIDATED().intValue());
					}
					Row row43 = sheet.getRow(53);
					Cell cell96 = row43.getCell(3);
					if (cell96 != null) {
					cell96.setCellValue(brf181.getR44_STANDALONE() == null ? 0 :
						brf181.getR44_STANDALONE().intValue());
					}
					Cell cell97 = row43.getCell(4);
					if (cell97 != null) {
					cell97.setCellValue(brf181.getR44_CONSOLIDATED() == null ? 0 :
						brf181.getR44_CONSOLIDATED().intValue());
					}
					Row row44 = sheet.getRow(54);
					Cell cell98 = row44.getCell(3);
					if (cell98 != null) {
					cell98.setCellValue(brf181.getR45_STANDALONE() == null ? 0 :
						brf181.getR45_STANDALONE().intValue());
					}
					Cell cell99 = row44.getCell(4);
					if (cell99 != null) {
					cell99.setCellValue(brf181.getR45_CONSOLIDATED() == null ? 0 :
						brf181.getR45_CONSOLIDATED().intValue());
					}
					Row row45 = sheet.getRow(55);
					Cell cell100 = row45.getCell(3);
					if (cell100 != null) {
					cell100.setCellValue(brf181.getR46_STANDALONE() == null ? 0 :
						brf181.getR46_STANDALONE().intValue());
					}
					Cell cell101 = row45.getCell(4);
					if (cell101 != null) {
					cell101.setCellValue(brf181.getR46_CONSOLIDATED() == null ? 0 :
						brf181.getR46_CONSOLIDATED().intValue());
					}
					Row row46 = sheet.getRow(56);
					Cell cell102 = row46.getCell(3);
					if (cell102 != null) {
					cell102.setCellValue(brf181.getR47_STANDALONE() == null ? 0 :
						brf181.getR47_STANDALONE().intValue());
					}
					Cell cell103 = row46.getCell(4);
					if (cell103 != null) {
					cell103.setCellValue(brf181.getR47_CONSOLIDATED() == null ? 0 :
						brf181.getR47_CONSOLIDATED().intValue());
					}
					Row row47 = sheet.getRow(57);
					Cell cell104 = row47.getCell(3);
					if (cell104 != null) {
					cell104.setCellValue(brf181.getR48_STANDALONE() == null ? 0 :
						brf181.getR48_STANDALONE().intValue());
					}
					Cell cell105 = row47.getCell(4);
					if (cell105 != null) {
					cell105.setCellValue(brf181.getR48_CONSOLIDATED() == null ? 0 :
						brf181.getR48_CONSOLIDATED().intValue());
					}
					Row row48 = sheet.getRow(58);
					Cell cell106 = row48.getCell(3);
					if (cell106 != null) {
					cell106.setCellValue(brf181.getR49_STANDALONE() == null ? 0 :
						brf181.getR49_STANDALONE().intValue());
					}
					Cell cell107 = row48.getCell(4);
					if (cell107 != null) {
					cell107.setCellValue(brf181.getR49_CONSOLIDATED() == null ? 0 :
						brf181.getR49_CONSOLIDATED().intValue());
					}
					Row row49 = sheet.getRow(59);
					Cell cell108 = row49.getCell(3);
					if (cell108 != null) {
					cell108.setCellValue(brf181.getR50_STANDALONE() == null ? 0 :
						brf181.getR50_STANDALONE().intValue());
					}
					Cell cell109 = row49.getCell(4);
					if (cell109 != null) {
					cell109.setCellValue(brf181.getR50_CONSOLIDATED() == null ? 0 :
						brf181.getR50_CONSOLIDATED().intValue());
					}
					Row row50 = sheet.getRow(60);
					Cell cell110 = row50.getCell(3);
					if (cell110 != null) {
					cell110.setCellValue(brf181.getR51_STANDALONE() == null ? 0 :
						brf181.getR51_STANDALONE().intValue());
					}
					Cell cell111 = row50.getCell(4);
					if (cell111 != null) {
					cell111.setCellValue(brf181.getR51_CONSOLIDATED() == null ? 0 :
						brf181.getR51_CONSOLIDATED().intValue());
					}
					//Financial Institutions (FI) - as guidance consider aligning with BRF 1 
					/////srl_no -63/////////
			    	Row row52 = sheet.getRow(62);
					Cell R52cell = row52.getCell(3);
			    	if (R52cell != null) {
			    	R52cell.setCellValue(brf181.getR52_STANDALONE() == null ? 0 :
			    	brf181.getR52_STANDALONE().intValue());
			    	}
			    	Cell R52cell1 = row52.getCell(4);
			    	if (R52cell1 != null) {
			    	R52cell1.setCellValue(brf181.getR52_CONSOLIDATED() == null ? 0 :
			    	brf181.getR52_CONSOLIDATED().intValue());
			    	}
					/////srl_no -64/////////
			    	Row row53 = sheet.getRow(63);
					Cell R53cell = row53.getCell(3);
			    	if (R53cell != null) {
			    	R53cell.setCellValue(brf181.getR53_STANDALONE() == null ? 0 :
			    	brf181.getR53_STANDALONE().intValue());
			    	}
			    	Cell R53cell1 = row53.getCell(4);
			    	if (R53cell1 != null) {
			    	R53cell1.setCellValue(brf181.getR53_CONSOLIDATED() == null ? 0 :
			    	brf181.getR53_CONSOLIDATED().intValue());
			    	}
					/////srl_no -65/////////
			    	Row row54 = sheet.getRow(64);
					Cell R54cell = row54.getCell(3);
			    	if (R54cell != null) {
			    	R54cell.setCellValue(brf181.getR54_STANDALONE() == null ? 0 :
			    	brf181.getR54_STANDALONE().intValue());
			    	}
			    	Cell R54cell1 = row54.getCell(4);
			    	if (R54cell1 != null) {
			    	R54cell1.setCellValue(brf181.getR54_CONSOLIDATED() == null ? 0 :
			    	brf181.getR54_CONSOLIDATED().intValue());
			    	}
					/////srl_no -66/////////
			    	Row row55 = sheet.getRow(65);
					Cell R55cell = row55.getCell(3);
			    	if (R55cell != null) {
			    	R55cell.setCellValue(brf181.getR55_STANDALONE() == null ? 0 :
			    	brf181.getR55_STANDALONE().intValue());
			    	}
			    	Cell R55cell1 = row55.getCell(4);
			    	if (R55cell1 != null) {
			    	R55cell1.setCellValue(brf181.getR55_CONSOLIDATED() == null ? 0 :
			    	brf181.getR55_CONSOLIDATED().intValue());
			    	}
					/////srl_no -67/////////
			    	Row row56 = sheet.getRow(66);
					Cell R56cell = row56.getCell(3);
			    	if (R56cell != null) {
			    	R56cell.setCellValue(brf181.getR56_STANDALONE() == null ? 0 :
			    	brf181.getR56_STANDALONE().intValue());
			    	}
			    	Cell R56cell1 = row56.getCell(4);
			    	if (R56cell1 != null) {
			    	R56cell1.setCellValue(brf181.getR56_CONSOLIDATED() == null ? 0 :
			    	brf181.getR56_CONSOLIDATED().intValue());
			    	}
					/////srl_no -68/////////
			    	Row row57 = sheet.getRow(67);
					Cell R57cell = row57.getCell(3);
			    	if (R57cell != null) {
			    	R57cell.setCellValue(brf181.getR57_STANDALONE() == null ? 0 :
			    	brf181.getR57_STANDALONE().intValue());
			    	}
			    	Cell R57cell1 = row57.getCell(4);
			    	if (R57cell1 != null) {
			    	R57cell1.setCellValue(brf181.getR57_CONSOLIDATED() == null ? 0 :
			    	brf181.getR57_CONSOLIDATED().intValue());
			    	}
					/////srl_no -69/////////
			    	Row row58 = sheet.getRow(68);
					Cell R58cell = row58.getCell(3);
			    	if (R58cell != null) {
			    	R58cell.setCellValue(brf181.getR58_STANDALONE() == null ? 0 :
			    	brf181.getR58_STANDALONE().intValue());
			    	}
			    	Cell R58cell1 = row58.getCell(4);
			    	if (R58cell1 != null) {
			    	R58cell1.setCellValue(brf181.getR58_CONSOLIDATED() == null ? 0 :
			    	brf181.getR58_CONSOLIDATED().intValue());
			    	}
					/////srl_no -70/////////
			    	Row row59 = sheet.getRow(69);
					Cell R59cell = row59.getCell(3);
			    	if (R59cell != null) {
			    	R59cell.setCellValue(brf181.getR59_STANDALONE() == null ? 0 :
			    	brf181.getR59_STANDALONE().intValue());
			    	}
			    	Cell R59cell1 = row59.getCell(4);
			    	if (R59cell1 != null) {
			    	R59cell1.setCellValue(brf181.getR59_CONSOLIDATED() == null ? 0 :
			    	brf181.getR59_CONSOLIDATED().intValue());
			    	}
					/////srl_no -71/////////
			    	Row row60 = sheet.getRow(70);
					Cell R60cell = row60.getCell(3);
			    	if (R60cell != null) {
			    	R60cell.setCellValue(brf181.getR60_STANDALONE() == null ? 0 :
			    	brf181.getR60_STANDALONE().intValue());
			    	}
			    	Cell R60cell1 = row60.getCell(4);
			    	if (R60cell1 != null) {
			    	R60cell1.setCellValue(brf181.getR60_CONSOLIDATED() == null ? 0 :
			    	brf181.getR60_CONSOLIDATED().intValue());
			    	}
					/////srl_no -72/////////
			    	Row row61 = sheet.getRow(71);
					Cell R61cell = row61.getCell(3);
			    	if (R61cell != null) {
			    	R61cell.setCellValue(brf181.getR61_STANDALONE() == null ? 0 :
			    	brf181.getR61_STANDALONE().intValue());
			    	}
			    	Cell R61cell1 = row61.getCell(4);
			    	if (R61cell1 != null) {
			    	R61cell1.setCellValue(brf181.getR61_CONSOLIDATED() == null ? 0 :
			    	brf181.getR61_CONSOLIDATED().intValue());
			    	}
					/////srl_no -73/////////
			    	Row row62 = sheet.getRow(72);
					Cell R62cell = row62.getCell(3);
			    	if (R62cell != null) {
			    	R62cell.setCellValue(brf181.getR62_STANDALONE() == null ? 0 :
			    	brf181.getR62_STANDALONE().intValue());
			    	}
			    	Cell R62cell1 = row62.getCell(4);
			    	if (R62cell1 != null) {
			    	R62cell1.setCellValue(brf181.getR62_CONSOLIDATED() == null ? 0 :
			    	brf181.getR62_CONSOLIDATED().intValue());
			    	}
					/////srl_no -74/////////
			    	Row row63 = sheet.getRow(73);
					Cell R63cell = row63.getCell(3);
			    	if (R63cell != null) {
			    	R63cell.setCellValue(brf181.getR63_STANDALONE() == null ? 0 :
			    	brf181.getR63_STANDALONE().intValue());
			    	}
			    	Cell R63cell1 = row63.getCell(4);
			    	if (R63cell1 != null) {
			    	R63cell1.setCellValue(brf181.getR63_CONSOLIDATED() == null ? 0 :
			    	brf181.getR63_CONSOLIDATED().intValue());
			    	}
					/////srl_no -75/////////
			    	Row row64 = sheet.getRow(74);
					Cell R64cell = row64.getCell(3);
			    	if (R64cell != null) {
			    	R64cell.setCellValue(brf181.getR64_STANDALONE() == null ? 0 :
			    	brf181.getR64_STANDALONE().intValue());
			    	}
			    	Cell R64cell1 = row64.getCell(4);
			    	if (R64cell1 != null) {
			    	R64cell1.setCellValue(brf181.getR64_CONSOLIDATED() == null ? 0 :
			    	brf181.getR64_CONSOLIDATED().intValue());
			    	}
					/////srl_no -76/////////
			    	Row row65 = sheet.getRow(75);
					Cell R65cell = row65.getCell(3);
			    	if (R65cell != null) {
			    	R65cell.setCellValue(brf181.getR65_STANDALONE() == null ? 0 :
			    	brf181.getR65_STANDALONE().intValue());
			    	}
			    	Cell R65cell1 = row65.getCell(4);
			    	if (R65cell1 != null) {
			    	R65cell1.setCellValue(brf181.getR65_CONSOLIDATED() == null ? 0 :
			    	brf181.getR65_CONSOLIDATED().intValue());
			    	}
					/////srl_no -77/////////
			    	Row row66 = sheet.getRow(76);
					Cell R66cell = row66.getCell(3);
			    	if (R66cell != null) {
			    	R66cell.setCellValue(brf181.getR66_STANDALONE() == null ? 0 :
			    	brf181.getR66_STANDALONE().intValue());
			    	}
			    	Cell R66cell1 = row66.getCell(4);
			    	if (R66cell1 != null) {
			    	R66cell1.setCellValue(brf181.getR66_CONSOLIDATED() == null ? 0 :
			    	brf181.getR66_CONSOLIDATED().intValue());
			    	}
					/////srl_no -78/////////
			    	Row row67 = sheet.getRow(77);
					Cell R67cell = row67.getCell(3);
			    	if (R67cell != null) {
			    	R67cell.setCellValue(brf181.getR67_STANDALONE() == null ? 0 :
			    	brf181.getR67_STANDALONE().intValue());
			    	}
			    	Cell R67cell1 = row67.getCell(4);
			    	if (R67cell1 != null) {
			    	R67cell1.setCellValue(brf181.getR67_CONSOLIDATED() == null ? 0 :
			    	brf181.getR67_CONSOLIDATED().intValue());
			    	}
					/////srl_no -79/////////
			    	Row row68 = sheet.getRow(78);
					Cell R68cell = row68.getCell(3);
			    	if (R68cell != null) {
			    	R68cell.setCellValue(brf181.getR68_STANDALONE() == null ? 0 :
			    	brf181.getR68_STANDALONE().intValue());
			    	}
			    	Cell R68cell1 = row68.getCell(4);
			    	if (R68cell1 != null) {
			    	R68cell1.setCellValue(brf181.getR68_CONSOLIDATED() == null ? 0 :
			    	brf181.getR68_CONSOLIDATED().intValue());
			    	}
					/////srl_no -80/////////
			    	Row row69 = sheet.getRow(79);
					Cell R69cell = row69.getCell(3);
			    	if (R69cell != null) {
			    	R69cell.setCellValue(brf181.getR69_STANDALONE() == null ? 0 :
			    	brf181.getR69_STANDALONE().intValue());
			    	}
			    	Cell R69cell1 = row69.getCell(4);
			    	if (R69cell1 != null) {
			    	R69cell1.setCellValue(brf181.getR69_CONSOLIDATED() == null ? 0 :
			    	brf181.getR69_CONSOLIDATED().intValue());
			    	}
					/////srl_no -81/////////
			    	Row row70 = sheet.getRow(80);
					Cell R70cell = row70.getCell(3);
			    	if (R70cell != null) {
			    	R70cell.setCellValue(brf181.getR70_STANDALONE() == null ? 0 :
			    	brf181.getR70_STANDALONE().intValue());
			    	}
			    	Cell R70cell1 = row70.getCell(4);
			    	if (R70cell1 != null) {
			    	R70cell1.setCellValue(brf181.getR70_CONSOLIDATED() == null ? 0 :
			    	brf181.getR70_CONSOLIDATED().intValue());
			    	}
					/////srl_no -82/////////
			    	Row row71 = sheet.getRow(81);
					Cell R71cell = row71.getCell(3);
			    	if (R71cell != null) {
			    	R71cell.setCellValue(brf181.getR71_STANDALONE() == null ? 0 :
			    	brf181.getR71_STANDALONE().intValue());
			    	}
			    	Cell R71cell1 = row71.getCell(4);
			    	if (R71cell1 != null) {
			    	R71cell1.setCellValue(brf181.getR71_CONSOLIDATED() == null ? 0 :
			    	brf181.getR71_CONSOLIDATED().intValue());
			    	}
					/////srl_no -83/////////
			    	Row row72 = sheet.getRow(82);
					Cell R72cell = row72.getCell(3);
			    	if (R72cell != null) {
			    	R72cell.setCellValue(brf181.getR72_STANDALONE() == null ? 0 :
			    	brf181.getR72_STANDALONE().intValue());
			    	}
			    	Cell R72cell1 = row72.getCell(4);
			    	if (R72cell1 != null) {
			    	R72cell1.setCellValue(brf181.getR72_CONSOLIDATED() == null ? 0 :
			    	brf181.getR72_CONSOLIDATED().intValue());
			    	}
					//Sovereign, Federal and Emirate GREs
					/////srl_no -85/////////
			    	Row row73 = sheet.getRow(84);
					Cell R73cell = row73.getCell(3);
			    	if (R73cell != null) {
			    	R73cell.setCellValue(brf181.getR73_STANDALONE() == null ? 0 :
			    	brf181.getR73_STANDALONE().intValue());
			    	}
			    	Cell R73cell1 = row73.getCell(4);
			    	if (R73cell1 != null) {
			    	R73cell1.setCellValue(brf181.getR73_CONSOLIDATED() == null ? 0 :
			    	brf181.getR73_CONSOLIDATED().intValue());
			    	}
					/////srl_no -86/////////
			    	Row row74 = sheet.getRow(85);
					Cell R74cell = row74.getCell(3);
			    	if (R74cell != null) {
			    	R74cell.setCellValue(brf181.getR74_STANDALONE() == null ? 0 :
			    	brf181.getR74_STANDALONE().intValue());
			    	}
			    	Cell R74cell1 = row74.getCell(4);
			    	if (R74cell1 != null) {
			    	R74cell1.setCellValue(brf181.getR74_CONSOLIDATED() == null ? 0 :
			    	brf181.getR74_CONSOLIDATED().intValue());
			    	}
					/////srl_no -87/////////
			    	Row row75 = sheet.getRow(86);
					Cell R75cell = row75.getCell(3);
			    	if (R75cell != null) {
			    	R75cell.setCellValue(brf181.getR75_STANDALONE() == null ? 0 :
			    	brf181.getR75_STANDALONE().intValue());
			    	}
			    	Cell R75cell1 = row75.getCell(4);
			    	if (R75cell1 != null) {
			    	R75cell1.setCellValue(brf181.getR75_CONSOLIDATED() == null ? 0 :
			    	brf181.getR75_CONSOLIDATED().intValue());
			    	}
					/////srl_no -88/////////
			    	Row row76 = sheet.getRow(87);
					Cell R76cell = row76.getCell(3);
			    	if (R76cell != null) {
			    	R76cell.setCellValue(brf181.getR76_STANDALONE() == null ? 0 :
			    	brf181.getR76_STANDALONE().intValue());
			    	}
			    	Cell R76cell1 = row76.getCell(4);
			    	if (R76cell1 != null) {
			    	R76cell1.setCellValue(brf181.getR76_CONSOLIDATED() == null ? 0 :
			    	brf181.getR76_CONSOLIDATED().intValue());
			    	}
					/////srl_no -89/////////
			    	Row row77 = sheet.getRow(88);
					Cell R77cell = row77.getCell(3);
			    	if (R77cell != null) {
			    	R77cell.setCellValue(brf181.getR77_STANDALONE() == null ? 0 :
			    	brf181.getR77_STANDALONE().intValue());
			    	}
			    	Cell R77cell1 = row77.getCell(4);
			    	if (R77cell1 != null) {
			    	R77cell1.setCellValue(brf181.getR77_CONSOLIDATED() == null ? 0 :
			    	brf181.getR77_CONSOLIDATED().intValue());
			    	}
					/////srl_no -90/////////
			    	Row row78 = sheet.getRow(89);
					Cell R78cell = row78.getCell(3);
			    	if (R78cell != null) {
			    	R78cell.setCellValue(brf181.getR78_STANDALONE() == null ? 0 :
			    	brf181.getR78_STANDALONE().intValue());
			    	}
			    	Cell R78cell1 = row78.getCell(4);
			    	if (R78cell1 != null) {
			    	R78cell1.setCellValue(brf181.getR78_CONSOLIDATED() == null ? 0 :
			    	brf181.getR78_CONSOLIDATED().intValue());
			    	}
			    	//SME
					/////srl_no -92/////////
			    	Row row79 = sheet.getRow(91);
					Cell R79cell = row79.getCell(3);
			    	if (R79cell != null) {
			    	R79cell.setCellValue(brf181.getR79_STANDALONE() == null ? 0 :
			    	brf181.getR79_STANDALONE().intValue());
			    	}
			    	Cell R79cell1 = row79.getCell(4);
			    	if (R79cell1 != null) {
			    	R79cell1.setCellValue(brf181.getR79_CONSOLIDATED() == null ? 0 :
			    	brf181.getR79_CONSOLIDATED().intValue());
			    	}
					/////srl_no -93/////////
			    	Row row80 = sheet.getRow(92);
					Cell R80cell = row80.getCell(3);
			    	if (R80cell != null) {
			    	R80cell.setCellValue(brf181.getR80_STANDALONE() == null ? 0 :
			    	brf181.getR80_STANDALONE().intValue());
			    	}
			    	Cell R80cell1 = row80.getCell(4);
			    	if (R80cell1 != null) {
			    	R80cell1.setCellValue(brf181.getR80_CONSOLIDATED() == null ? 0 :
			    	brf181.getR80_CONSOLIDATED().intValue());
			    	}
					/////srl_no -94/////////
			    	Row row81 = sheet.getRow(93);
					Cell R81cell = row81.getCell(3);
			    	if (R81cell != null) {
			    	R81cell.setCellValue(brf181.getR81_STANDALONE() == null ? 0 :
			    	brf181.getR81_STANDALONE().intValue());
			    	}
			    	Cell R81cell1 = row81.getCell(4);
			    	if (R81cell1 != null) {
			    	R81cell1.setCellValue(brf181.getR81_CONSOLIDATED() == null ? 0 :
			    	brf181.getR81_CONSOLIDATED().intValue());
			    	}
					/////srl_no -95/////////
			    	Row row82 = sheet.getRow(94);
					Cell R82cell = row82.getCell(3);
			    	if (R82cell != null) {
			    	R82cell.setCellValue(brf181.getR82_STANDALONE() == null ? 0 :
			    	brf181.getR82_STANDALONE().intValue());
			    	}
			    	Cell R82cell1 = row82.getCell(4);
			    	if (R82cell1 != null) {
			    	R82cell1.setCellValue(brf181.getR82_CONSOLIDATED() == null ? 0 :
			    	brf181.getR82_CONSOLIDATED().intValue());
			    	}
					/////srl_no -96/////////
			    	Row row83 = sheet.getRow(95);
					Cell R83cell = row83.getCell(3);
			    	if (R83cell != null) {
			    	R83cell.setCellValue(brf181.getR83_STANDALONE() == null ? 0 :
			    	brf181.getR83_STANDALONE().intValue());
			    	}
			    	Cell R83cell1 = row83.getCell(4);
			    	if (R83cell1 != null) {
			    	R83cell1.setCellValue(brf181.getR83_CONSOLIDATED() == null ? 0 :
			    	brf181.getR83_CONSOLIDATED().intValue());
			    	}
					/////srl_no -97/////////
			    	Row row84 = sheet.getRow(96);
					Cell R84cell = row84.getCell(3);
			    	if (R84cell != null) {
			    	R84cell.setCellValue(brf181.getR84_STANDALONE() == null ? 0 :
			    	brf181.getR84_STANDALONE().intValue());
			    	}
			    	Cell R84cell1 = row84.getCell(4);
			    	if (R84cell1 != null) {
			    	R84cell1.setCellValue(brf181.getR84_CONSOLIDATED() == null ? 0 :
			    	brf181.getR84_CONSOLIDATED().intValue());
			    	}
					/////srl_no -98/////////
			    	Row row85 = sheet.getRow(97);
					Cell R85cell = row85.getCell(3);
			    	if (R85cell != null) {
			    	R85cell.setCellValue(brf181.getR85_STANDALONE() == null ? 0 :
			    	brf181.getR85_STANDALONE().intValue());
			    	}
			    	Cell R85cell1 = row85.getCell(4);
			    	if (R85cell1 != null) {
			    	R85cell1.setCellValue(brf181.getR85_CONSOLIDATED() == null ? 0 :
			    	brf181.getR85_CONSOLIDATED().intValue());
			    	}
					/////srl_no -99/////////
			    	Row row86 = sheet.getRow(98);
					Cell R86cell = row86.getCell(3);
			    	if (R86cell != null) {
			    	R86cell.setCellValue(brf181.getR86_STANDALONE() == null ? 0 :
			    	brf181.getR86_STANDALONE().intValue());
			    	}
			    	Cell R86cell1 = row86.getCell(4);
			    	if (R86cell1 != null) {
			    	R86cell1.setCellValue(brf181.getR86_CONSOLIDATED() == null ? 0 :
			    	brf181.getR86_CONSOLIDATED().intValue());
			    	}
					/////srl_no -100/////////
			    	Row row87 = sheet.getRow(99);
					Cell R87cell = row87.getCell(3);
			    	if (R87cell != null) {
			    	R87cell.setCellValue(brf181.getR87_STANDALONE() == null ? 0 :
			    	brf181.getR87_STANDALONE().intValue());
			    	}
			    	Cell R87cell1 = row87.getCell(4);
			    	if (R87cell1 != null) {
			    	R87cell1.setCellValue(brf181.getR87_CONSOLIDATED() == null ? 0 :
			    	brf181.getR87_CONSOLIDATED().intValue());
			    	}
					/////srl_no -101/////////
			    	Row row88 = sheet.getRow(100);
					Cell R88cell = row88.getCell(3);
			    	if (R88cell != null) {
			    	R88cell.setCellValue(brf181.getR88_STANDALONE() == null ? 0 :
			    	brf181.getR88_STANDALONE().intValue());
			    	}
			    	Cell R88cell1 = row88.getCell(4);
			    	if (R88cell1 != null) {
			    	R88cell1.setCellValue(brf181.getR88_CONSOLIDATED() == null ? 0 :
			    	brf181.getR88_CONSOLIDATED().intValue());
			    	}
					/////srl_no -102/////////
			    	Row row89 = sheet.getRow(101);
					Cell R89cell = row89.getCell(3);
			    	if (R89cell != null) {
			    	R89cell.setCellValue(brf181.getR89_STANDALONE() == null ? 0 :
			    	brf181.getR89_STANDALONE().intValue());
			    	}
			    	Cell R89cell1 = row89.getCell(4);
			    	if (R89cell1 != null) {
			    	R89cell1.setCellValue(brf181.getR89_CONSOLIDATED() == null ? 0 :
			    	brf181.getR89_CONSOLIDATED().intValue());
			    	}
					/////srl_no -103/////////
			    	Row row90 = sheet.getRow(102);
					Cell R90cell = row90.getCell(3);
			    	if (R90cell != null) {
			    	R90cell.setCellValue(brf181.getR90_STANDALONE() == null ? 0 :
			    	brf181.getR90_STANDALONE().intValue());
			    	}
			    	Cell R90cell1 = row90.getCell(4);
			    	if (R90cell1 != null) {
			    	R90cell1.setCellValue(brf181.getR90_CONSOLIDATED() == null ? 0 :
			    	brf181.getR90_CONSOLIDATED().intValue());
			    	}
					/////srl_no -104/////////
			    	Row row91 = sheet.getRow(103);
					Cell R91cell = row91.getCell(3);
			    	if (R91cell != null) {
			    	R91cell.setCellValue(brf181.getR91_STANDALONE() == null ? 0 :
			    	brf181.getR91_STANDALONE().intValue());
			    	}
			    	Cell R91cell1 = row91.getCell(4);
			    	if (R91cell1 != null) {
			    	R91cell1.setCellValue(brf181.getR91_CONSOLIDATED() == null ? 0 :
			    	brf181.getR91_CONSOLIDATED().intValue());
			    	}
					/////srl_no -105/////////
			    	Row row92 = sheet.getRow(104);
					Cell R92cell = row92.getCell(3);
			    	if (R92cell != null) {
			    	R92cell.setCellValue(brf181.getR92_STANDALONE() == null ? 0 :
			    	brf181.getR92_STANDALONE().intValue());
			    	}
			    	Cell R92cell1 = row92.getCell(4);
			    	if (R92cell1 != null) {
			    	R92cell1.setCellValue(brf181.getR92_CONSOLIDATED() == null ? 0 :
			    	brf181.getR92_CONSOLIDATED().intValue());
			    	}
					/////srl_no -106/////////
			    	Row row93 = sheet.getRow(105);
					Cell R93cell = row93.getCell(3);
			    	if (R93cell != null) {
			    	R93cell.setCellValue(brf181.getR93_STANDALONE() == null ? 0 :
			    	brf181.getR93_STANDALONE().intValue());
			    	}
			    	Cell R93cell1 = row93.getCell(4);
			    	if (R93cell1 != null) {
			    	R93cell1.setCellValue(brf181.getR93_CONSOLIDATED() == null ? 0 :
			    	brf181.getR93_CONSOLIDATED().intValue());
			    	}
					/////srl_no -107/////////
			    	Row row94 = sheet.getRow(106);
					Cell R94cell = row94.getCell(3);
			    	if (R94cell != null) {
			    	R94cell.setCellValue(brf181.getR94_STANDALONE() == null ? 0 :
			    	brf181.getR94_STANDALONE().intValue());
			    	}
			    	Cell R94cell1 = row94.getCell(4);
			    	if (R94cell1 != null) {
			    	R94cell1.setCellValue(brf181.getR94_CONSOLIDATED() == null ? 0 :
			    	brf181.getR94_CONSOLIDATED().intValue());
			    	}
					/////srl_no -108/////////
			    	Row row95 = sheet.getRow(107);
					Cell R95cell = row95.getCell(3);
			    	if (R95cell != null) {
			    	R95cell.setCellValue(brf181.getR95_STANDALONE() == null ? 0 :
			    	brf181.getR95_STANDALONE().intValue());
			    	}
			    	Cell R95cell1 = row95.getCell(4);
			    	if (R95cell1 != null) {
			    	R95cell1.setCellValue(brf181.getR95_CONSOLIDATED() == null ? 0 :
			    	brf181.getR95_CONSOLIDATED().intValue());
			    	}
					/////srl_no -109/////////
			    	Row row96 = sheet.getRow(108);
					Cell R96cell = row96.getCell(3);
			    	if (R96cell != null) {
			    	R96cell.setCellValue(brf181.getR96_STANDALONE() == null ? 0 :
			    	brf181.getR96_STANDALONE().intValue());
			    	}
			    	Cell R96cell1 = row96.getCell(4);
			    	if (R96cell1 != null) {
			    	R96cell1.setCellValue(brf181.getR96_CONSOLIDATED() == null ? 0 :
			    	brf181.getR96_CONSOLIDATED().intValue());
			    	}
					/////srl_no -110/////////
			    	Row row97 = sheet.getRow(109);
					Cell R97cell = row97.getCell(3);
			    	if (R97cell != null) {
			    	R97cell.setCellValue(brf181.getR97_STANDALONE() == null ? 0 :
			    	brf181.getR97_STANDALONE().intValue());
			    	}
			    	Cell R97cell1 = row97.getCell(4);
			    	if (R97cell1 != null) {
			    	R97cell1.setCellValue(brf181.getR97_CONSOLIDATED() == null ? 0 :
			    	brf181.getR97_CONSOLIDATED().intValue());
			    	}
					/////srl_no -111/////////
			    	Row row98 = sheet.getRow(110);
					Cell R98cell = row98.getCell(3);
			    	if (R98cell != null) {
			    	R98cell.setCellValue(brf181.getR98_STANDALONE() == null ? 0 :
			    	brf181.getR98_STANDALONE().intValue());
			    	}
			    	Cell R98cell1 = row98.getCell(4);
			    	if (R98cell1 != null) {
			    	R98cell1.setCellValue(brf181.getR98_CONSOLIDATED() == null ? 0 :
			    	brf181.getR98_CONSOLIDATED().intValue());
			    	}
					/////srl_no -112/////////
			    	Row row99 = sheet.getRow(111);
					Cell R99cell = row99.getCell(3);
			    	if (R99cell != null) {
			    	R99cell.setCellValue(brf181.getR99_STANDALONE() == null ? 0 :
			    	brf181.getR99_STANDALONE().intValue());
			    	}
			    	Cell R99cell1 = row99.getCell(4);
			    	if (R99cell1 != null) {
			    	R99cell1.setCellValue(brf181.getR99_CONSOLIDATED() == null ? 0 :
			    	brf181.getR99_CONSOLIDATED().intValue());
			    	}
					/////srl_no -113/////////
			    	Row row100 = sheet.getRow(112);
					Cell R100cell = row100.getCell(3);
			    	if (R100cell != null) {
			    	R100cell.setCellValue(brf181.getR100_STANDALONE() == null ? 0 :
			    	brf181.getR100_STANDALONE().intValue());
			    	}
			    	Cell R100cell1 = row100.getCell(4);
			    	if (R100cell1 != null) {
			    	R100cell1.setCellValue(brf181.getR100_CONSOLIDATED() == null ? 0 :
			    	brf181.getR100_CONSOLIDATED().intValue());
			    	}
					/////srl_no -114/////////
			    	Row row101 = sheet.getRow(113);
					Cell R101cell = row101.getCell(3);
			    	if (R101cell != null) {
			    	R101cell.setCellValue(brf181.getR101_STANDALONE() == null ? 0 :
			    	brf181.getR101_STANDALONE().intValue());
			    	}
			    	Cell R101cell1 = row101.getCell(4);
			    	if (R101cell1 != null) {
			    	R101cell1.setCellValue(brf181.getR101_CONSOLIDATED() == null ? 0 :
			    	brf181.getR101_CONSOLIDATED().intValue());
			    	}
					/////srl_no -115/////////
			    	Row row102 = sheet.getRow(114);
					Cell R102cell = row102.getCell(3);
			    	if (R102cell != null) {
			    	R102cell.setCellValue(brf181.getR102_STANDALONE() == null ? 0 :
			    	brf181.getR102_STANDALONE().intValue());
			    	}
			    	Cell R102cell1 = row102.getCell(4);
			    	if (R102cell1 != null) {
			    	R102cell1.setCellValue(brf181.getR102_CONSOLIDATED() == null ? 0 :
			    	brf181.getR102_CONSOLIDATED().intValue());
			    	}
					/////srl_no -116/////////
			    	Row row103 = sheet.getRow(115);
					Cell R103cell = row103.getCell(3);
			    	if (R103cell != null) {
			    	R103cell.setCellValue(brf181.getR103_STANDALONE() == null ? 0 :
			    	brf181.getR103_STANDALONE().intValue());
			    	}
			    	Cell R103cell1 = row103.getCell(4);
			    	if (R103cell1 != null) {
			    	R103cell1.setCellValue(brf181.getR103_CONSOLIDATED() == null ? 0 :
			    	brf181.getR103_CONSOLIDATED().intValue());
			    	}
					/////srl_no -117/////////
			    	Row row104 = sheet.getRow(116);
					Cell R104cell = row104.getCell(3);
			    	if (R104cell != null) {
			    	R104cell.setCellValue(brf181.getR104_STANDALONE() == null ? 0 :
			    	brf181.getR104_STANDALONE().intValue());
			    	}
			    	Cell R104cell1 = row104.getCell(4);
			    	if (R104cell1 != null) {
			    	R104cell1.setCellValue(brf181.getR104_CONSOLIDATED() == null ? 0 :
			    	brf181.getR104_CONSOLIDATED().intValue());
			    	}
					/////srl_no -118/////////
			    	Row row105 = sheet.getRow(117);
					Cell R105cell = row105.getCell(3);
			    	if (R105cell != null) {
			    	R105cell.setCellValue(brf181.getR105_STANDALONE() == null ? 0 :
			    	brf181.getR105_STANDALONE().intValue());
			    	}
			    	Cell R105cell1 = row105.getCell(4);
			    	if (R105cell1 != null) {
			    	R105cell1.setCellValue(brf181.getR105_CONSOLIDATED() == null ? 0 :
			    	brf181.getR105_CONSOLIDATED().intValue());
			    	}
					/////srl_no -119/////////
			    	Row row106 = sheet.getRow(118);
					Cell R106cell = row106.getCell(3);
			    	if (R106cell != null) {
			    	R106cell.setCellValue(brf181.getR106_STANDALONE() == null ? 0 :
			    	brf181.getR106_STANDALONE().intValue());
			    	}
			    	Cell R106cell1 = row106.getCell(4);
			    	if (R106cell1 != null) {
			    	R106cell1.setCellValue(brf181.getR106_CONSOLIDATED() == null ? 0 :
			    	brf181.getR106_CONSOLIDATED().intValue());
			    	}
					/////srl_no -120/////////
			    	Row row107 = sheet.getRow(119);
					Cell R107cell = row107.getCell(3);
			    	if (R107cell != null) {
			    	R107cell.setCellValue(brf181.getR107_STANDALONE() == null ? 0 :
			    	brf181.getR107_STANDALONE().intValue());
			    	}
			    	Cell R107cell1 = row107.getCell(4);
			    	if (R107cell1 != null) {
			    	R107cell1.setCellValue(brf181.getR107_CONSOLIDATED() == null ? 0 :
			    	brf181.getR107_CONSOLIDATED().intValue());
			    	}
					/////srl_no -121/////////
			    	Row row108 = sheet.getRow(120);
					Cell R108cell = row108.getCell(3);
			    	if (R108cell != null) {
			    	R108cell.setCellValue(brf181.getR108_STANDALONE() == null ? 0 :
			    	brf181.getR108_STANDALONE().intValue());
			    	}
			    	Cell R108cell1 = row108.getCell(4);
			    	if (R108cell1 != null) {
			    	R108cell1.setCellValue(brf181.getR108_CONSOLIDATED() == null ? 0 :
			    	brf181.getR108_CONSOLIDATED().intValue());
			    	}
					/////srl_no -122/////////
			    	Row row109 = sheet.getRow(121);
					Cell R109cell = row109.getCell(3);
			    	if (R109cell != null) {
			    	R109cell.setCellValue(brf181.getR109_STANDALONE() == null ? 0 :
			    	brf181.getR109_STANDALONE().intValue());
			    	}
			    	Cell R109cell1 = row109.getCell(4);
			    	if (R109cell1 != null) {
			    	R109cell1.setCellValue(brf181.getR109_CONSOLIDATED() == null ? 0 :
			    	brf181.getR109_CONSOLIDATED().intValue());
			    	}
					/////srl_no -123/////////
			    	Row row110 = sheet.getRow(122);
					Cell R110cell = row110.getCell(3);
			    	if (R110cell != null) {
			    	R110cell.setCellValue(brf181.getR110_STANDALONE() == null ? 0 :
			    	brf181.getR110_STANDALONE().intValue());
			    	}
			    	Cell R110cell1 = row110.getCell(4);
			    	if (R110cell1 != null) {
			    	R110cell1.setCellValue(brf181.getR110_CONSOLIDATED() == null ? 0 :
			    	brf181.getR110_CONSOLIDATED().intValue());
			    	}
					/////srl_no -124/////////
			    	Row row111 = sheet.getRow(123);
					Cell R111cell = row111.getCell(3);
			    	if (R111cell != null) {
			    	R111cell.setCellValue(brf181.getR111_STANDALONE() == null ? 0 :
			    	brf181.getR111_STANDALONE().intValue());
			    	}
			    	Cell R111cell1 = row111.getCell(4);
			    	if (R111cell1 != null) {
			    	R111cell1.setCellValue(brf181.getR111_CONSOLIDATED() == null ? 0 :
			    	brf181.getR111_CONSOLIDATED().intValue());
			    	}
					/////srl_no -125/////////
			    	Row row112 = sheet.getRow(124);
					Cell R112cell = row112.getCell(3);
			    	if (R112cell != null) {
			    	R112cell.setCellValue(brf181.getR112_STANDALONE() == null ? 0 :
			    	brf181.getR112_STANDALONE().intValue());
			    	}
			    	Cell R112cell1 = row112.getCell(4);
			    	if (R112cell1 != null) {
			    	R112cell1.setCellValue(brf181.getR112_CONSOLIDATED() == null ? 0 :
			    	brf181.getR112_CONSOLIDATED().intValue());
			    	}
					/////srl_no -126/////////
			    	Row row113 = sheet.getRow(125);
					Cell R113cell = row113.getCell(3);
			    	if (R113cell != null) {
			    	R113cell.setCellValue(brf181.getR113_STANDALONE() == null ? 0 :
			    	brf181.getR113_STANDALONE().intValue());
			    	}
			    	Cell R113cell1 = row113.getCell(4);
			    	if (R113cell1 != null) {
			    	R113cell1.setCellValue(brf181.getR113_CONSOLIDATED() == null ? 0 :
			    	brf181.getR113_CONSOLIDATED().intValue());
			    	}
					/////srl_no -127/////////
			    	Row row114 = sheet.getRow(126);
					Cell R114cell = row114.getCell(3);
			    	if (R114cell != null) {
			    	R114cell.setCellValue(brf181.getR114_STANDALONE() == null ? 0 :
			    	brf181.getR114_STANDALONE().intValue());
			    	}
			    	Cell R114cell1 = row114.getCell(4);
			    	if (R114cell1 != null) {
			    	R114cell1.setCellValue(brf181.getR114_CONSOLIDATED() == null ? 0 :
			    	brf181.getR114_CONSOLIDATED().intValue());
			    	}
					/////srl_no -128/////////
			    	Row row115 = sheet.getRow(127);
					Cell R115cell = row115.getCell(3);
			    	if (R115cell != null) {
			    	R115cell.setCellValue(brf181.getR115_STANDALONE() == null ? 0 :
			    	brf181.getR115_STANDALONE().intValue());
			    	}
			    	Cell R115cell1 = row115.getCell(4);
			    	if (R115cell1 != null) {
			    	R115cell1.setCellValue(brf181.getR115_CONSOLIDATED() == null ? 0 :
			    	brf181.getR115_CONSOLIDATED().intValue());
			    	}
					/////srl_no -129/////////
			    	Row row116 = sheet.getRow(128);
					Cell R116cell = row116.getCell(3);
			    	if (R116cell != null) {
			    	R116cell.setCellValue(brf181.getR116_STANDALONE() == null ? 0 :
			    	brf181.getR116_STANDALONE().intValue());
			    	}
			    	Cell R116cell1 = row116.getCell(4);
			    	if (R116cell1 != null) {
			    	R116cell1.setCellValue(brf181.getR116_CONSOLIDATED() == null ? 0 :
			    	brf181.getR116_CONSOLIDATED().intValue());
			    	}
					/////srl_no -130/////////
			    	Row row117 = sheet.getRow(129);
					Cell R117cell = row117.getCell(3);
			    	if (R117cell != null) {
			    	R117cell.setCellValue(brf181.getR117_STANDALONE() == null ? 0 :
			    	brf181.getR117_STANDALONE().intValue());
			    	}
			    	Cell R117cell1 = row117.getCell(4);
			    	if (R117cell1 != null) {
			    	R117cell1.setCellValue(brf181.getR117_CONSOLIDATED() == null ? 0 :
			    	brf181.getR117_CONSOLIDATED().intValue());
			    	}
					/////srl_no -131/////////
			    	Row row118 = sheet.getRow(130);
					Cell R118cell = row118.getCell(3);
			    	if (R118cell != null) {
			    	R118cell.setCellValue(brf181.getR118_STANDALONE() == null ? 0 :
			    	brf181.getR118_STANDALONE().intValue());
			    	}
			    	Cell R118cell1 = row118.getCell(4);
			    	if (R118cell1 != null) {
			    	R118cell1.setCellValue(brf181.getR118_CONSOLIDATED() == null ? 0 :
			    	brf181.getR118_CONSOLIDATED().intValue());
			    	}
			    	//Other Credit risk data points
					/////srl_no -133/////////
			    	Row row119 = sheet.getRow(132);
					Cell R119cell = row119.getCell(3);
			    	if (R119cell != null) {
			    	R119cell.setCellValue(brf181.getR119_STANDALONE() == null ? 0 :
			    	brf181.getR119_STANDALONE().intValue());
			    	}
			    	Cell R119cell1 = row119.getCell(4);
			    	if (R119cell1 != null) {
			    	R119cell1.setCellValue(brf181.getR119_CONSOLIDATED() == null ? 0 :
			    	brf181.getR119_CONSOLIDATED().intValue());
			    	}
					/////srl_no -134/////////
			    	Row row120 = sheet.getRow(133);
					Cell R120cell = row120.getCell(3);
			    	if (R120cell != null) {
			    	R120cell.setCellValue(brf181.getR120_STANDALONE() == null ? 0 :
			    	brf181.getR120_STANDALONE().intValue());
			    	}
			    	Cell R120cell1 = row120.getCell(4);
			    	if (R120cell1 != null) {
			    	R120cell1.setCellValue(brf181.getR120_CONSOLIDATED() == null ? 0 :
			    	brf181.getR120_CONSOLIDATED().intValue());
			    	}
					/////srl_no -135/////////
			    	Row row121 = sheet.getRow(134);
					Cell R121cell = row121.getCell(3);
			    	if (R121cell != null) {
			    	R121cell.setCellValue(brf181.getR121_STANDALONE() == null ? 0 :
			    	brf181.getR121_STANDALONE().intValue());
			    	}
			    	Cell R121cell1 = row121.getCell(4);
			    	if (R121cell1 != null) {
			    	R121cell1.setCellValue(brf181.getR121_CONSOLIDATED() == null ? 0 :
			    	brf181.getR121_CONSOLIDATED().intValue());
			    	}
					/////srl_no -136/////////
			    	Row row122 = sheet.getRow(135);
					Cell R122cell = row122.getCell(3);
			    	if (R122cell != null) {
			    	R122cell.setCellValue(brf181.getR122_STANDALONE() == null ? 0 :
			    	brf181.getR122_STANDALONE().intValue());
			    	}
			    	Cell R122cell1 = row122.getCell(4);
			    	if (R122cell1 != null) {
			    	R122cell1.setCellValue(brf181.getR122_CONSOLIDATED() == null ? 0 :
			    	brf181.getR122_CONSOLIDATED().intValue());
			    	}
					/////srl_no -137/////////
			    	Row row123 = sheet.getRow(136);
					Cell R123cell = row123.getCell(3);
			    	if (R123cell != null) {
			    	R123cell.setCellValue(brf181.getR123_STANDALONE() == null ? 0 :
			    	brf181.getR123_STANDALONE().intValue());
			    	}
			    	Cell R123cell1 = row123.getCell(4);
			    	if (R123cell1 != null) {
			    	R123cell1.setCellValue(brf181.getR123_CONSOLIDATED() == null ? 0 :
			    	brf181.getR123_CONSOLIDATED().intValue());
			    	}
					/////srl_no -138/////////
			    	Row row124 = sheet.getRow(137);
					Cell R124cell = row124.getCell(3);
			    	if (R124cell != null) {
			    	R124cell.setCellValue(brf181.getR124_STANDALONE() == null ? 0 :
			    	brf181.getR124_STANDALONE().intValue());
			    	}
			    	Cell R124cell1 = row124.getCell(4);
			    	if (R124cell1 != null) {
			    	R124cell1.setCellValue(brf181.getR124_CONSOLIDATED() == null ? 0 :
			    	brf181.getR124_CONSOLIDATED().intValue());
			    	}
			    	//Retail Loans (excluding mortgage loans)			
					/////srl_no -140/////////
			    	Row row125 = sheet.getRow(139);
					Cell R125cell = row125.getCell(3);
			    	if (R125cell != null) {
			    	R125cell.setCellValue(brf181.getR125_STANDALONE() == null ? 0 :
			    	brf181.getR125_STANDALONE().intValue());
			    	}
			    	Cell R125cell1 = row125.getCell(4);
			    	if (R125cell1 != null) {
			    	R125cell1.setCellValue(brf181.getR125_CONSOLIDATED() == null ? 0 :
			    	brf181.getR125_CONSOLIDATED().intValue());
			    	}
					/////srl_no -141/////////
			    	Row row126 = sheet.getRow(140);
					Cell R126cell = row126.getCell(3);
			    	if (R126cell != null) {
			    	R126cell.setCellValue(brf181.getR126_STANDALONE() == null ? 0 :
			    	brf181.getR126_STANDALONE().intValue());
			    	}
			    	Cell R126cell1 = row126.getCell(4);
			    	if (R126cell1 != null) {
			    	R126cell1.setCellValue(brf181.getR126_CONSOLIDATED() == null ? 0 :
			    	brf181.getR126_CONSOLIDATED().intValue());
			    	}
					/////srl_no -142/////////
			    	Row row127 = sheet.getRow(141);
					Cell R127cell = row127.getCell(3);
			    	if (R127cell != null) {
			    	R127cell.setCellValue(brf181.getR127_STANDALONE() == null ? 0 :
			    	brf181.getR127_STANDALONE().intValue());
			    	}
			    	Cell R127cell1 = row127.getCell(4);
			    	if (R127cell1 != null) {
			    	R127cell1.setCellValue(brf181.getR127_CONSOLIDATED() == null ? 0 :
			    	brf181.getR127_CONSOLIDATED().intValue());
			    	}
					/////srl_no -143/////////
			    	Row row128 = sheet.getRow(142);
					Cell R128cell = row128.getCell(3);
			    	if (R128cell != null) {
			    	R128cell.setCellValue(brf181.getR128_STANDALONE() == null ? 0 :
			    	brf181.getR128_STANDALONE().intValue());
			    	}
			    	Cell R128cell1 = row128.getCell(4);
			    	if (R128cell1 != null) {
			    	R128cell1.setCellValue(brf181.getR128_CONSOLIDATED() == null ? 0 :
			    	brf181.getR128_CONSOLIDATED().intValue());
			    	}
					/////srl_no -144/////////
			    	Row row129 = sheet.getRow(143);
					Cell R129cell = row129.getCell(3);
			    	if (R129cell != null) {
			    	R129cell.setCellValue(brf181.getR129_STANDALONE() == null ? 0 :
			    	brf181.getR129_STANDALONE().intValue());
			    	}
			    	Cell R129cell1 = row129.getCell(4);
			    	if (R129cell1 != null) {
			    	R129cell1.setCellValue(brf181.getR129_CONSOLIDATED() == null ? 0 :
			    	brf181.getR129_CONSOLIDATED().intValue());
			    	}
					/////srl_no -145/////////
			    	Row row130 = sheet.getRow(144);
					Cell R130cell = row130.getCell(3);
			    	if (R130cell != null) {
			    	R130cell.setCellValue(brf181.getR130_STANDALONE() == null ? 0 :
			    	brf181.getR130_STANDALONE().intValue());
			    	}
			    	Cell R130cell1 = row130.getCell(4);
			    	if (R130cell1 != null) {
			    	R130cell1.setCellValue(brf181.getR130_CONSOLIDATED() == null ? 0 :
			    	brf181.getR130_CONSOLIDATED().intValue());
			    	}
					/////srl_no -146/////////
			    	Row row131 = sheet.getRow(145);
					Cell R131cell = row131.getCell(3);
			    	if (R131cell != null) {
			    	R131cell.setCellValue(brf181.getR131_STANDALONE() == null ? 0 :
			    	brf181.getR131_STANDALONE().intValue());
			    	}
			    	Cell R131cell1 = row131.getCell(4);
			    	if (R131cell1 != null) {
			    	R131cell1.setCellValue(brf181.getR131_CONSOLIDATED() == null ? 0 :
			    	brf181.getR131_CONSOLIDATED().intValue());
			    	}
					/////srl_no -147/////////
			    	Row row132 = sheet.getRow(146);
					Cell R132cell = row132.getCell(3);
			    	if (R132cell != null) {
			    	R132cell.setCellValue(brf181.getR132_STANDALONE() == null ? 0 :
			    	brf181.getR132_STANDALONE().intValue());
			    	}
			    	Cell R132cell1 = row132.getCell(4);
			    	if (R132cell1 != null) {
			    	R132cell1.setCellValue(brf181.getR132_CONSOLIDATED() == null ? 0 :
			    	brf181.getR132_CONSOLIDATED().intValue());
			    	}
					/////srl_no -148/////////
			    	Row row133 = sheet.getRow(147);
					Cell R133cell = row133.getCell(3);
			    	if (R133cell != null) {
			    	R133cell.setCellValue(brf181.getR133_STANDALONE() == null ? 0 :
			    	brf181.getR133_STANDALONE().intValue());
			    	}
			    	Cell R133cell1 = row133.getCell(4);
			    	if (R133cell1 != null) {
			    	R133cell1.setCellValue(brf181.getR133_CONSOLIDATED() == null ? 0 :
			    	brf181.getR133_CONSOLIDATED().intValue());
			    	}
					/////srl_no -149/////////
			    	Row row134 = sheet.getRow(148);
					Cell R134cell = row134.getCell(3);
			    	if (R134cell != null) {
			    	R134cell.setCellValue(brf181.getR134_STANDALONE() == null ? 0 :
			    	brf181.getR134_STANDALONE().intValue());
			    	}
			    	Cell R134cell1 = row134.getCell(4);
			    	if (R134cell1 != null) {
			    	R134cell1.setCellValue(brf181.getR134_CONSOLIDATED() == null ? 0 :
			    	brf181.getR134_CONSOLIDATED().intValue());
			    	}
					/////srl_no -150/////////
			    	Row row135 = sheet.getRow(149);
					Cell R135cell = row135.getCell(3);
			    	if (R135cell != null) {
			    	R135cell.setCellValue(brf181.getR135_STANDALONE() == null ? 0 :
			    	brf181.getR135_STANDALONE().intValue());
			    	}
			    	Cell R135cell1 = row135.getCell(4);
			    	if (R135cell1 != null) {
			    	R135cell1.setCellValue(brf181.getR135_CONSOLIDATED() == null ? 0 :
			    	brf181.getR135_CONSOLIDATED().intValue());
			    	}
					/////srl_no -151/////////
			    	Row row136 = sheet.getRow(150);
					Cell R136cell = row136.getCell(3);
			    	if (R136cell != null) {
			    	R136cell.setCellValue(brf181.getR136_STANDALONE() == null ? 0 :
			    	brf181.getR136_STANDALONE().intValue());
			    	}
			    	Cell R136cell1 = row136.getCell(4);
			    	if (R136cell1 != null) {
			    	R136cell1.setCellValue(brf181.getR136_CONSOLIDATED() == null ? 0 :
			    	brf181.getR136_CONSOLIDATED().intValue());
			    	}
					/////srl_no -152/////////
			    	Row row137 = sheet.getRow(151);
					Cell R137cell = row137.getCell(3);
			    	if (R137cell != null) {
			    	R137cell.setCellValue(brf181.getR137_STANDALONE() == null ? 0 :
			    	brf181.getR137_STANDALONE().intValue());
			    	}
			    	Cell R137cell1 = row137.getCell(4);
			    	if (R137cell1 != null) {
			    	R137cell1.setCellValue(brf181.getR137_CONSOLIDATED() == null ? 0 :
			    	brf181.getR137_CONSOLIDATED().intValue());
			    	}
					/////srl_no -153/////////
			    	Row row138 = sheet.getRow(152);
					Cell R138cell = row138.getCell(3);
			    	if (R138cell != null) {
			    	R138cell.setCellValue(brf181.getR138_STANDALONE() == null ? 0 :
			    	brf181.getR138_STANDALONE().intValue());
			    	}
			    	Cell R138cell1 = row138.getCell(4);
			    	if (R138cell1 != null) {
			    	R138cell1.setCellValue(brf181.getR138_CONSOLIDATED() == null ? 0 :
			    	brf181.getR138_CONSOLIDATED().intValue());
			    	}
					/////srl_no -154/////////
			    	Row row139 = sheet.getRow(153);
					Cell R139cell = row139.getCell(3);
			    	if (R139cell != null) {
			    	R139cell.setCellValue(brf181.getR139_STANDALONE() == null ? 0 :
			    	brf181.getR139_STANDALONE().intValue());
			    	}
			    	Cell R139cell1 = row139.getCell(4);
			    	if (R139cell1 != null) {
			    	R139cell1.setCellValue(brf181.getR139_CONSOLIDATED() == null ? 0 :
			    	brf181.getR139_CONSOLIDATED().intValue());
			    	}
					/////srl_no -155/////////
			    	Row row140 = sheet.getRow(154);
					Cell R140cell = row140.getCell(3);
			    	if (R140cell != null) {
			    	R140cell.setCellValue(brf181.getR140_STANDALONE() == null ? 0 :
			    	brf181.getR140_STANDALONE().intValue());
			    	}
			    	Cell R140cell1 = row140.getCell(4);
			    	if (R140cell1 != null) {
			    	R140cell1.setCellValue(brf181.getR140_CONSOLIDATED() == null ? 0 :
			    	brf181.getR140_CONSOLIDATED().intValue());
			    	}
					/////srl_no -156/////////
			    	Row row141 = sheet.getRow(155);
					Cell R141cell = row141.getCell(3);
			    	if (R141cell != null) {
			    	R141cell.setCellValue(brf181.getR141_STANDALONE() == null ? 0 :
			    	brf181.getR141_STANDALONE().intValue());
			    	}
			    	Cell R141cell1 = row141.getCell(4);
			    	if (R141cell1 != null) {
			    	R141cell1.setCellValue(brf181.getR141_CONSOLIDATED() == null ? 0 :
			    	brf181.getR141_CONSOLIDATED().intValue());
			    	}
					/////srl_no -157/////////
			    	Row row142 = sheet.getRow(156);
					Cell R142cell = row142.getCell(3);
			    	if (R142cell != null) {
			    	R142cell.setCellValue(brf181.getR142_STANDALONE() == null ? 0 :
			    	brf181.getR142_STANDALONE().intValue());
			    	}
			    	Cell R142cell1 = row142.getCell(4);
			    	if (R142cell1 != null) {
			    	R142cell1.setCellValue(brf181.getR142_CONSOLIDATED() == null ? 0 :
			    	brf181.getR142_CONSOLIDATED().intValue());
			    	}
					/////srl_no -158/////////
			    	Row row143 = sheet.getRow(157);
					Cell R143cell = row143.getCell(3);
			    	if (R143cell != null) {
			    	R143cell.setCellValue(brf181.getR143_STANDALONE() == null ? 0 :
			    	brf181.getR143_STANDALONE().intValue());
			    	}
			    	Cell R143cell1 = row143.getCell(4);
			    	if (R143cell1 != null) {
			    	R143cell1.setCellValue(brf181.getR143_CONSOLIDATED() == null ? 0 :
			    	brf181.getR143_CONSOLIDATED().intValue());
			    	}
					/////srl_no -159/////////
			    	Row row144 = sheet.getRow(158);
					Cell R144cell = row144.getCell(3);
			    	if (R144cell != null) {
			    	R144cell.setCellValue(brf181.getR144_STANDALONE() == null ? 0 :
			    	brf181.getR144_STANDALONE().intValue());
			    	}
			    	Cell R144cell1 = row144.getCell(4);
			    	if (R144cell1 != null) {
			    	R144cell1.setCellValue(brf181.getR144_CONSOLIDATED() == null ? 0 :
			    	brf181.getR144_CONSOLIDATED().intValue());
			    	}
					/////srl_no -160/////////
			    	Row row145 = sheet.getRow(159);
					Cell R145cell = row145.getCell(3);
			    	if (R145cell != null) {
			    	R145cell.setCellValue(brf181.getR145_STANDALONE() == null ? 0 :
			    	brf181.getR145_STANDALONE().intValue());
			    	}
			    	Cell R145cell1 = row145.getCell(4);
			    	if (R145cell1 != null) {
			    	R145cell1.setCellValue(brf181.getR145_CONSOLIDATED() == null ? 0 :
			    	brf181.getR145_CONSOLIDATED().intValue());
			    	}
			    	//Mortgage Loans			
					/////srl_no -162/////////
			    	Row row146 = sheet.getRow(161);
					Cell R146cell = row146.getCell(3);
			    	if (R146cell != null) {
			    	R146cell.setCellValue(brf181.getR146_STANDALONE() == null ? 0 :
			    	brf181.getR146_STANDALONE().intValue());
			    	}
			    	Cell R146cell1 = row146.getCell(4);
			    	if (R146cell1 != null) {
			    	R146cell1.setCellValue(brf181.getR146_CONSOLIDATED() == null ? 0 :
			    	brf181.getR146_CONSOLIDATED().intValue());
			    	}
					/////srl_no -163/////////
			    	Row row147 = sheet.getRow(162);
					Cell R147cell = row147.getCell(3);
			    	if (R147cell != null) {
			    	R147cell.setCellValue(brf181.getR147_STANDALONE() == null ? 0 :
			    	brf181.getR147_STANDALONE().intValue());
			    	}
			    	Cell R147cell1 = row147.getCell(4);
			    	if (R147cell1 != null) {
			    	R147cell1.setCellValue(brf181.getR147_CONSOLIDATED() == null ? 0 :
			    	brf181.getR147_CONSOLIDATED().intValue());
			    	}
					/////srl_no -164/////////
			    	Row row148 = sheet.getRow(163);
					Cell R148cell = row148.getCell(3);
			    	if (R148cell != null) {
			    	R148cell.setCellValue(brf181.getR148_STANDALONE() == null ? 0 :
			    	brf181.getR148_STANDALONE().intValue());
			    	}
			    	Cell R148cell1 = row148.getCell(4);
			    	if (R148cell1 != null) {
			    	R148cell1.setCellValue(brf181.getR148_CONSOLIDATED() == null ? 0 :
			    	brf181.getR148_CONSOLIDATED().intValue());
			    	}
					/////srl_no -165/////////
			    	Row row149 = sheet.getRow(164);
					Cell R149cell = row149.getCell(3);
			    	if (R149cell != null) {
			    	R149cell.setCellValue(brf181.getR149_STANDALONE() == null ? 0 :
			    	brf181.getR149_STANDALONE().intValue());
			    	}
			    	Cell R149cell1 = row149.getCell(4);
			    	if (R149cell1 != null) {
			    	R149cell1.setCellValue(brf181.getR149_CONSOLIDATED() == null ? 0 :
			    	brf181.getR149_CONSOLIDATED().intValue());
			    	}
					/////srl_no -166/////////
			    	Row row150 = sheet.getRow(165);
					Cell R150cell = row150.getCell(3);
			    	if (R150cell != null) {
			    	R150cell.setCellValue(brf181.getR150_STANDALONE() == null ? 0 :
			    	brf181.getR150_STANDALONE().intValue());
			    	}
			    	Cell R150cell1 = row150.getCell(4);
			    	if (R150cell1 != null) {
			    	R150cell1.setCellValue(brf181.getR150_CONSOLIDATED() == null ? 0 :
			    	brf181.getR150_CONSOLIDATED().intValue());
			    	}
					/////srl_no -167/////////
			    	Row row151 = sheet.getRow(166);
					Cell R151cell = row151.getCell(3);
			    	if (R151cell != null) {
			    	R151cell.setCellValue(brf181.getR151_STANDALONE() == null ? 0 :
			    	brf181.getR151_STANDALONE().intValue());
			    	}
			    	Cell R151cell1 = row151.getCell(4);
			    	if (R151cell1 != null) {
			    	R151cell1.setCellValue(brf181.getR151_CONSOLIDATED() == null ? 0 :
			    	brf181.getR151_CONSOLIDATED().intValue());
			    	}
					/////srl_no -168/////////
			    	Row row152 = sheet.getRow(167);
					Cell R152cell = row152.getCell(3);
			    	if (R152cell != null) {
			    	R152cell.setCellValue(brf181.getR152_STANDALONE() == null ? 0 :
			    	brf181.getR152_STANDALONE().intValue());
			    	}
			    	Cell R152cell1 = row152.getCell(4);
			    	if (R152cell1 != null) {
			    	R152cell1.setCellValue(brf181.getR152_CONSOLIDATED() == null ? 0 :
			    	brf181.getR152_CONSOLIDATED().intValue());
			    	}
					/////srl_no -169/////////
			    	Row row153 = sheet.getRow(168);
					Cell R153cell = row153.getCell(3);
			    	if (R153cell != null) {
			    	R153cell.setCellValue(brf181.getR153_STANDALONE() == null ? 0 :
			    	brf181.getR153_STANDALONE().intValue());
			    	}
			    	Cell R153cell1 = row153.getCell(4);
			    	if (R153cell1 != null) {
			    	R153cell1.setCellValue(brf181.getR153_CONSOLIDATED() == null ? 0 :
			    	brf181.getR153_CONSOLIDATED().intValue());
			    	}
					/////srl_no -170/////////
			    	Row row154 = sheet.getRow(169);
					Cell R154cell = row154.getCell(3);
			    	if (R154cell != null) {
			    	R154cell.setCellValue(brf181.getR154_STANDALONE() == null ? 0 :
			    	brf181.getR154_STANDALONE().intValue());
			    	}
			    	Cell R154cell1 = row154.getCell(4);
			    	if (R154cell1 != null) {
			    	R154cell1.setCellValue(brf181.getR154_CONSOLIDATED() == null ? 0 :
			    	brf181.getR154_CONSOLIDATED().intValue());
			    	}
					/////srl_no -171/////////
			    	Row row155 = sheet.getRow(170);
					Cell R155cell = row155.getCell(3);
			    	if (R155cell != null) {
			    	R155cell.setCellValue(brf181.getR155_STANDALONE() == null ? 0 :
			    	brf181.getR155_STANDALONE().intValue());
			    	}
			    	Cell R155cell1 = row155.getCell(4);
			    	if (R155cell1 != null) {
			    	R155cell1.setCellValue(brf181.getR155_CONSOLIDATED() == null ? 0 :
			    	brf181.getR155_CONSOLIDATED().intValue());
			    	}
					/////srl_no -172/////////
			    	Row row156 = sheet.getRow(171);
					Cell R156cell = row156.getCell(3);
			    	if (R156cell != null) {
			    	R156cell.setCellValue(brf181.getR156_STANDALONE() == null ? 0 :
			    	brf181.getR156_STANDALONE().intValue());
			    	}
			    	Cell R156cell1 = row156.getCell(4);
			    	if (R156cell1 != null) {
			    	R156cell1.setCellValue(brf181.getR156_CONSOLIDATED() == null ? 0 :
			    	brf181.getR156_CONSOLIDATED().intValue());
			    	}
					/////srl_no -173/////////
			    	Row row157 = sheet.getRow(172);
					Cell R157cell = row157.getCell(3);
			    	if (R157cell != null) {
			    	R157cell.setCellValue(brf181.getR157_STANDALONE() == null ? 0 :
			    	brf181.getR157_STANDALONE().intValue());
			    	}
			    	Cell R157cell1 = row157.getCell(4);
			    	if (R157cell1 != null) {
			    	R157cell1.setCellValue(brf181.getR157_CONSOLIDATED() == null ? 0 :
			    	brf181.getR157_CONSOLIDATED().intValue());
			    	}
					/////srl_no -174/////////
			    	Row row158 = sheet.getRow(173);
					Cell R158cell = row158.getCell(3);
			    	if (R158cell != null) {
			    	R158cell.setCellValue(brf181.getR158_STANDALONE() == null ? 0 :
			    	brf181.getR158_STANDALONE().intValue());
			    	}
			    	Cell R158cell1 = row158.getCell(4);
			    	if (R158cell1 != null) {
			    	R158cell1.setCellValue(brf181.getR158_CONSOLIDATED() == null ? 0 :
			    	brf181.getR158_CONSOLIDATED().intValue());
			    	}
					/////srl_no -175/////////
			    	Row row159 = sheet.getRow(174);
					Cell R159cell = row159.getCell(3);
			    	if (R159cell != null) {
			    	R159cell.setCellValue(brf181.getR159_STANDALONE() == null ? 0 :
			    	brf181.getR159_STANDALONE().intValue());
			    	}
			    	Cell R159cell1 = row159.getCell(4);
			    	if (R159cell1 != null) {
			    	R159cell1.setCellValue(brf181.getR159_CONSOLIDATED() == null ? 0 :
			    	brf181.getR159_CONSOLIDATED().intValue());
			    	}
					/////srl_no -176/////////
			    	Row row160 = sheet.getRow(175);
					Cell R160cell = row160.getCell(3);
			    	if (R160cell != null) {
			    	R160cell.setCellValue(brf181.getR160_STANDALONE() == null ? 0 :
			    	brf181.getR160_STANDALONE().intValue());
			    	}
			    	Cell R160cell1 = row160.getCell(4);
			    	if (R160cell1 != null) {
			    	R160cell1.setCellValue(brf181.getR160_CONSOLIDATED() == null ? 0 :
			    	brf181.getR160_CONSOLIDATED().intValue());
			    	}
					/////srl_no -177/////////
			    	Row row161 = sheet.getRow(176);
					Cell R161cell = row161.getCell(3);
			    	if (R161cell != null) {
			    	R161cell.setCellValue(brf181.getR161_STANDALONE() == null ? 0 :
			    	brf181.getR161_STANDALONE().intValue());
			    	}
			    	Cell R161cell1 = row161.getCell(4);
			    	if (R161cell1 != null) {
			    	R161cell1.setCellValue(brf181.getR161_CONSOLIDATED() == null ? 0 :
			    	brf181.getR161_CONSOLIDATED().intValue());
			    	}
					/////srl_no -178/////////
			    	Row row162 = sheet.getRow(177);
					Cell R162cell = row162.getCell(3);
			    	if (R162cell != null) {
			    	R162cell.setCellValue(brf181.getR162_STANDALONE() == null ? 0 :
			    	brf181.getR162_STANDALONE().intValue());
			    	}
			    	Cell R162cell1 = row162.getCell(4);
			    	if (R162cell1 != null) {
			    	R162cell1.setCellValue(brf181.getR162_CONSOLIDATED() == null ? 0 :
			    	brf181.getR162_CONSOLIDATED().intValue());
			    	}
					/////srl_no -179/////////
			    	Row row163 = sheet.getRow(178);
					Cell R163cell = row163.getCell(3);
			    	if (R163cell != null) {
			    	R163cell.setCellValue(brf181.getR163_STANDALONE() == null ? 0 :
			    	brf181.getR163_STANDALONE().intValue());
			    	}
			    	Cell R163cell1 = row163.getCell(4);
			    	if (R163cell1 != null) {
			    	R163cell1.setCellValue(brf181.getR163_CONSOLIDATED() == null ? 0 :
			    	brf181.getR163_CONSOLIDATED().intValue());
			    	}
					/////srl_no -180/////////
			    	Row row164 = sheet.getRow(179);
					Cell R164cell = row164.getCell(3);
			    	if (R164cell != null) {
			    	R164cell.setCellValue(brf181.getR164_STANDALONE() == null ? 0 :
			    	brf181.getR164_STANDALONE().intValue());
			    	}
			    	Cell R164cell1 = row164.getCell(4);
			    	if (R164cell1 != null) {
			    	R164cell1.setCellValue(brf181.getR164_CONSOLIDATED() == null ? 0 :
			    	brf181.getR164_CONSOLIDATED().intValue());
			    	}
					/////srl_no -181/////////
			    	Row row165 = sheet.getRow(180);
					Cell R165cell = row165.getCell(3);
			    	if (R165cell != null) {
			    	R165cell.setCellValue(brf181.getR165_STANDALONE() == null ? 0 :
			    	brf181.getR165_STANDALONE().intValue());
			    	}
			    	Cell R165cell1 = row165.getCell(4);
			    	if (R165cell1 != null) {
			    	R165cell1.setCellValue(brf181.getR165_CONSOLIDATED() == null ? 0 :
			    	brf181.getR165_CONSOLIDATED().intValue());
			    	}
					/////srl_no -182/////////
			    	Row row166 = sheet.getRow(181);
					Cell R166cell = row166.getCell(3);
			    	if (R166cell != null) {
			    	R166cell.setCellValue(brf181.getR166_STANDALONE() == null ? 0 :
			    	brf181.getR166_STANDALONE().intValue());
			    	}
			    	Cell R166cell1 = row166.getCell(4);
			    	if (R166cell1 != null) {
			    	R166cell1.setCellValue(brf181.getR166_CONSOLIDATED() == null ? 0 :
			    	brf181.getR166_CONSOLIDATED().intValue());
			    	}
					/////srl_no -183/////////
			    	Row row167 = sheet.getRow(182);
					Cell R167cell = row167.getCell(3);
			    	if (R167cell != null) {
			    	R167cell.setCellValue(brf181.getR167_STANDALONE() == null ? 0 :
			    	brf181.getR167_STANDALONE().intValue());
			    	}
			    	Cell R167cell1 = row167.getCell(4);
			    	if (R167cell1 != null) {
			    	R167cell1.setCellValue(brf181.getR167_CONSOLIDATED() == null ? 0 :
			    	brf181.getR167_CONSOLIDATED().intValue());
			    	}
					/////srl_no -184/////////
			    	Row row168 = sheet.getRow(183);
					Cell R168cell = row168.getCell(3);
			    	if (R168cell != null) {
			    	R168cell.setCellValue(brf181.getR168_STANDALONE() == null ? 0 :
			    	brf181.getR168_STANDALONE().intValue());
			    	}
			    	Cell R168cell1 = row168.getCell(4);
			    	if (R168cell1 != null) {
			    	R168cell1.setCellValue(brf181.getR168_CONSOLIDATED() == null ? 0 :
			    	brf181.getR168_CONSOLIDATED().intValue());
			    	}
			    	//Bank Wide		
					/////srl_no -186/////////
			    	Row row169 = sheet.getRow(185);
					Cell R169cell = row169.getCell(3);
			    	if (R169cell != null) {
			    	R169cell.setCellValue(brf181.getR169_STANDALONE() == null ? 0 :
			    	brf181.getR169_STANDALONE().intValue());
			    	}
			    	Cell R169cell1 = row169.getCell(4);
			    	if (R169cell1 != null) {
			    	R169cell1.setCellValue(brf181.getR169_CONSOLIDATED() == null ? 0 :
			    	brf181.getR169_CONSOLIDATED().intValue());
			    	}
					/////srl_no -187/////////
			    	Row row170 = sheet.getRow(186);
					Cell R170cell = row170.getCell(3);
			    	if (R170cell != null) {
			    	R170cell.setCellValue(brf181.getR170_STANDALONE() == null ? 0 :
			    	brf181.getR170_STANDALONE().intValue());
			    	}
			    	Cell R170cell1 = row170.getCell(4);
			    	if (R170cell1 != null) {
			    	R170cell1.setCellValue(brf181.getR170_CONSOLIDATED() == null ? 0 :
			    	brf181.getR170_CONSOLIDATED().intValue());
			    	}
					/////srl_no -188/////////
			    	Row row171 = sheet.getRow(187);
					Cell R171cell = row171.getCell(3);
			    	if (R171cell != null) {
			    	R171cell.setCellValue(brf181.getR171_STANDALONE() == null ? 0 :
			    	brf181.getR171_STANDALONE().intValue());
			    	}
			    	Cell R171cell1 = row171.getCell(4);
			    	if (R171cell1 != null) {
			    	R171cell1.setCellValue(brf181.getR171_CONSOLIDATED() == null ? 0 :
			    	brf181.getR171_CONSOLIDATED().intValue());
			    	}
					/////srl_no -189/////////
			    	Row row172 = sheet.getRow(188);
					Cell R172cell = row172.getCell(3);
			    	if (R172cell != null) {
			    	R172cell.setCellValue(brf181.getR172_STANDALONE() == null ? 0 :
			    	brf181.getR172_STANDALONE().intValue());
			    	}
			    	Cell R172cell1 = row172.getCell(4);
			    	if (R172cell1 != null) {
			    	R172cell1.setCellValue(brf181.getR172_CONSOLIDATED() == null ? 0 :
			    	brf181.getR172_CONSOLIDATED().intValue());
			    	}
					/////srl_no -190/////////
			    	Row row173 = sheet.getRow(189);
					Cell R173cell = row173.getCell(3);
			    	if (R173cell != null) {
			    	R173cell.setCellValue(brf181.getR173_STANDALONE() == null ? 0 :
			    	brf181.getR173_STANDALONE().intValue());
			    	}
			    	Cell R173cell1 = row173.getCell(4);
			    	if (R173cell1 != null) {
			    	R173cell1.setCellValue(brf181.getR173_CONSOLIDATED() == null ? 0 :
			    	brf181.getR173_CONSOLIDATED().intValue());
			    	}
					/////srl_no -191/////////
			    	Row row174 = sheet.getRow(190);
					Cell R174cell = row174.getCell(3);
			    	if (R174cell != null) {
			    	R174cell.setCellValue(brf181.getR174_STANDALONE() == null ? 0 :
			    	brf181.getR174_STANDALONE().intValue());
			    	}
			    	Cell R174cell1 = row174.getCell(4);
			    	if (R174cell1 != null) {
			    	R174cell1.setCellValue(brf181.getR174_CONSOLIDATED() == null ? 0 :
			    	brf181.getR174_CONSOLIDATED().intValue());
			    	}
					/////srl_no -192/////////
			    	Row row175 = sheet.getRow(191);
					Cell R175cell = row175.getCell(3);
			    	if (R175cell != null) {
			    	R175cell.setCellValue(brf181.getR175_STANDALONE() == null ? 0 :
			    	brf181.getR175_STANDALONE().intValue());
			    	}
			    	Cell R175cell1 = row175.getCell(4);
			    	if (R175cell1 != null) {
			    	R175cell1.setCellValue(brf181.getR175_CONSOLIDATED() == null ? 0 :
			    	brf181.getR175_CONSOLIDATED().intValue());
			    	}
					/////srl_no -193/////////
			    	Row row176 = sheet.getRow(192);
					Cell R176cell = row176.getCell(3);
			    	if (R176cell != null) {
			    	R176cell.setCellValue(brf181.getR176_STANDALONE() == null ? 0 :
			    	brf181.getR176_STANDALONE().intValue());
			    	}
			    	Cell R176cell1 = row176.getCell(4);
			    	if (R176cell1 != null) {
			    	R176cell1.setCellValue(brf181.getR176_CONSOLIDATED() == null ? 0 :
			    	brf181.getR176_CONSOLIDATED().intValue());
			    	}
					/////srl_no -194/////////
			    	Row row177 = sheet.getRow(193);
					Cell R177cell = row177.getCell(3);
			    	if (R177cell != null) {
			    	R177cell.setCellValue(brf181.getR177_STANDALONE() == null ? 0 :
			    	brf181.getR177_STANDALONE().intValue());
			    	}
			    	Cell R177cell1 = row177.getCell(4);
			    	if (R177cell1 != null) {
			    	R177cell1.setCellValue(brf181.getR177_CONSOLIDATED() == null ? 0 :
			    	brf181.getR177_CONSOLIDATED().intValue());
			    	}
					/////srl_no -195/////////
			    	Row row178 = sheet.getRow(194);
					Cell R178cell = row178.getCell(3);
			    	if (R178cell != null) {
			    	R178cell.setCellValue(brf181.getR178_STANDALONE() == null ? 0 :
			    	brf181.getR178_STANDALONE().intValue());
			    	}
			    	Cell R178cell1 = row178.getCell(4);
			    	if (R178cell1 != null) {
			    	R178cell1.setCellValue(brf181.getR178_CONSOLIDATED() == null ? 0 :
			    	brf181.getR178_CONSOLIDATED().intValue());
			    	}
					/////srl_no -196/////////
			    	Row row179 = sheet.getRow(195);
					Cell R179cell = row179.getCell(3);
			    	if (R179cell != null) {
			    	R179cell.setCellValue(brf181.getR179_STANDALONE() == null ? 0 :
			    	brf181.getR179_STANDALONE().intValue());
			    	}
			    	Cell R179cell1 = row179.getCell(4);
			    	if (R179cell1 != null) {
			    	R179cell1.setCellValue(brf181.getR179_CONSOLIDATED() == null ? 0 :
			    	brf181.getR179_CONSOLIDATED().intValue());
			    	}
					/////srl_no -197/////////
			    	Row row180 = sheet.getRow(196);
					Cell R180cell = row180.getCell(3);
			    	if (R180cell != null) {
			    	R180cell.setCellValue(brf181.getR180_STANDALONE() == null ? 0 :
			    	brf181.getR180_STANDALONE().intValue());
			    	}
			    	Cell R180cell1 = row180.getCell(4);
			    	if (R180cell1 != null) {
			    	R180cell1.setCellValue(brf181.getR180_CONSOLIDATED() == null ? 0 :
			    	brf181.getR180_CONSOLIDATED().intValue());
			    	}
					/////srl_no -198/////////
			    	Row row181 = sheet.getRow(197);
					Cell R181cell = row181.getCell(3);
			    	if (R181cell != null) {
			    	R181cell.setCellValue(brf181.getR181_STANDALONE() == null ? 0 :
			    	brf181.getR181_STANDALONE().intValue());
			    	}
			    	Cell R181cell1 = row181.getCell(4);
			    	if (R181cell1 != null) {
			    	R181cell1.setCellValue(brf181.getR181_CONSOLIDATED() == null ? 0 :
			    	brf181.getR181_CONSOLIDATED().intValue());
			    	}
			    	//Market and Investment
					/////srl_no -200/////////
			    	Row row182 = sheet.getRow(199);
					Cell R182cell = row182.getCell(3);
			    	if (R182cell != null) {
			    	R182cell.setCellValue(brf181.getR182_STANDALONE() == null ? 0 :
			    	brf181.getR182_STANDALONE().intValue());
			    	}
			    	Cell R182cell1 = row182.getCell(4);
			    	if (R182cell1 != null) {
			    	R182cell1.setCellValue(brf181.getR182_CONSOLIDATED() == null ? 0 :
			    	brf181.getR182_CONSOLIDATED().intValue());
			    	}
					/////srl_no -201/////////
			    	Row row183 = sheet.getRow(200);
					Cell R183cell = row183.getCell(3);
			    	if (R183cell != null) {
			    	R183cell.setCellValue(brf181.getR183_STANDALONE() == null ? 0 :
			    	brf181.getR183_STANDALONE().intValue());
			    	}
			    	Cell R183cell1 = row183.getCell(4);
			    	if (R183cell1 != null) {
			    	R183cell1.setCellValue(brf181.getR183_CONSOLIDATED() == null ? 0 :
			    	brf181.getR183_CONSOLIDATED().intValue());
			    	}
					/////srl_no -202/////////
			    	Row row184 = sheet.getRow(201);
					Cell R184cell = row184.getCell(3);
			    	if (R184cell != null) {
			    	R184cell.setCellValue(brf181.getR184_STANDALONE() == null ? 0 :
			    	brf181.getR184_STANDALONE().intValue());
			    	}
			    	Cell R184cell1 = row184.getCell(4);
			    	if (R184cell1 != null) {
			    	R184cell1.setCellValue(brf181.getR184_CONSOLIDATED() == null ? 0 :
			    	brf181.getR184_CONSOLIDATED().intValue());
			    	}
					/////srl_no -203/////////
			    	Row row185 = sheet.getRow(202);
					Cell R185cell = row185.getCell(3);
			    	if (R185cell != null) {
			    	R185cell.setCellValue(brf181.getR185_STANDALONE() == null ? 0 :
			    	brf181.getR185_STANDALONE().intValue());
			    	}
			    	Cell R185cell1 = row185.getCell(4);
			    	if (R185cell1 != null) {
			    	R185cell1.setCellValue(brf181.getR185_CONSOLIDATED() == null ? 0 :
			    	brf181.getR185_CONSOLIDATED().intValue());
			    	}
					/////srl_no -204/////////
			    	Row row186 = sheet.getRow(203);
					Cell R186cell = row186.getCell(3);
			    	if (R186cell != null) {
			    	R186cell.setCellValue(brf181.getR186_STANDALONE() == null ? 0 :
			    	brf181.getR186_STANDALONE().intValue());
			    	}
			    	Cell R186cell1 = row186.getCell(4);
			    	if (R186cell1 != null) {
			    	R186cell1.setCellValue(brf181.getR186_CONSOLIDATED() == null ? 0 :
			    	brf181.getR186_CONSOLIDATED().intValue());
			    	}
					/////srl_no -205/////////
			    	Row row187 = sheet.getRow(204);
					Cell R187cell = row187.getCell(3);
			    	if (R187cell != null) {
			    	R187cell.setCellValue(brf181.getR187_STANDALONE() == null ? 0 :
			    	brf181.getR187_STANDALONE().intValue());
			    	}
			    	Cell R187cell1 = row187.getCell(4);
			    	if (R187cell1 != null) {
			    	R187cell1.setCellValue(brf181.getR187_CONSOLIDATED() == null ? 0 :
			    	brf181.getR187_CONSOLIDATED().intValue());
			    	}
					/////srl_no -206/////////
			    	Row row188 = sheet.getRow(205);
					Cell R188cell = row188.getCell(3);
			    	if (R188cell != null) {
			    	R188cell.setCellValue(brf181.getR188_STANDALONE() == null ? 0 :
			    	brf181.getR188_STANDALONE().intValue());
			    	}
			    	Cell R188cell1 = row188.getCell(4);
			    	if (R188cell1 != null) {
			    	R188cell1.setCellValue(brf181.getR188_CONSOLIDATED() == null ? 0 :
			    	brf181.getR188_CONSOLIDATED().intValue());
			    	}
					/////srl_no -207/////////
			    	Row row189 = sheet.getRow(206);
					Cell R189cell = row189.getCell(3);
			    	if (R189cell != null) {
			    	R189cell.setCellValue(brf181.getR189_STANDALONE() == null ? 0 :
			    	brf181.getR189_STANDALONE().intValue());
			    	}
			    	Cell R189cell1 = row189.getCell(4);
			    	if (R189cell1 != null) {
			    	R189cell1.setCellValue(brf181.getR189_CONSOLIDATED() == null ? 0 :
			    	brf181.getR189_CONSOLIDATED().intValue());
			    	}
				}
			}
				if (T1Master1.size() == 1) {
					for (BRF_181_A2_REPORT_ENTITY brf181a : T1Master1) {				
						/////srl_no -208/////////
			    	Row row190 = sheet.getRow(207);
					Cell R190cell = row190.getCell(3);
			    	if (R190cell != null) {
			    	R190cell.setCellValue(brf181a.getR190_STANDALONE() == null ? 0 :
			    	brf181a.getR190_STANDALONE().intValue());
			    	}
			    	Cell R190cell0 = row190.getCell(4);
			    	if (R190cell0 != null) {
			    	R190cell0.setCellValue(brf181a.getR190_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR190_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -209/////////
			    	Row row191 = sheet.getRow(208);
					Cell R191cell = row191.getCell(3);
			    	if (R191cell != null) {
			    	R191cell.setCellValue(brf181a.getR191_STANDALONE() == null ? 0 :
			    	brf181a.getR191_STANDALONE().intValue());
			    	}
			    	Cell R191cell0 = row191.getCell(4);
			    	if (R191cell0 != null) {
			    	R191cell0.setCellValue(brf181a.getR191_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR191_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -210/////////
			    	Row row192 = sheet.getRow(209);
					Cell R192cell = row192.getCell(3);
			    	if (R192cell != null) {
			    	R192cell.setCellValue(brf181a.getR192_STANDALONE() == null ? 0 :
			    	brf181a.getR192_STANDALONE().intValue());
			    	}
			    	Cell R192cell0 = row192.getCell(4);
			    	if (R192cell0 != null) {
			    	R192cell0.setCellValue(brf181a.getR192_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR192_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -211/////////
			    	Row row193 = sheet.getRow(210);
					Cell R193cell = row193.getCell(3);
			    	if (R193cell != null) {
			    	R193cell.setCellValue(brf181a.getR193_STANDALONE() == null ? 0 :
			    	brf181a.getR193_STANDALONE().intValue());
			    	}
			    	Cell R193cell0 = row193.getCell(4);
			    	if (R193cell0 != null) {
			    	R193cell0.setCellValue(brf181a.getR193_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR193_CONSOLIDATED().intValue());
			    	}
					
					
			    /////srl_no -212/////////
			    	Row row194 = sheet.getRow(211);
					Cell R194cell = row194.getCell(3);
			    	if (R194cell != null) {
			    	R194cell.setCellValue(brf181a.getR194_STANDALONE() == null ? 0 :
			    	brf181a.getR194_STANDALONE().intValue());
			    	}
			    	Cell R194cell0 = row194.getCell(4);
			    	if (R194cell0 != null) {
			    	R194cell0.setCellValue(brf181a.getR194_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR194_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -213/////////
			    	Row row195 = sheet.getRow(212);
					Cell R195cell = row195.getCell(3);
			    	if (R195cell != null) {
			    	R195cell.setCellValue(brf181a.getR195_STANDALONE() == null ? 0 :
			    	brf181a.getR195_STANDALONE().intValue());
			    	}
			    	Cell R195cell0 = row195.getCell(4);
			    	if (R195cell0 != null) {
			    	R195cell0.setCellValue(brf181a.getR195_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR195_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -214/////////
			    	Row row196 = sheet.getRow(213);
					Cell R196cell = row196.getCell(3);
			    	if (R196cell != null) {
			    	R196cell.setCellValue(brf181a.getR196_STANDALONE() == null ? 0 :
			    	brf181a.getR196_STANDALONE().intValue());
			    	}
			    	Cell R196cell0 = row196.getCell(4);
			    	if (R196cell0 != null) {
			    	R196cell0.setCellValue(brf181a.getR196_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR196_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -215/////////
			    	Row row197 = sheet.getRow(214);
					Cell R197cell = row197.getCell(3);
			    	if (R197cell != null) {
			    	R197cell.setCellValue(brf181a.getR197_STANDALONE() == null ? 0 :
			    	brf181a.getR197_STANDALONE().intValue());
			    	}
			    	Cell R197cell0 = row197.getCell(4);
			    	if (R197cell0 != null) {
			    	R197cell0.setCellValue(brf181a.getR197_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR197_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -216/////////
			    	Row row198 = sheet.getRow(215);
					Cell R198cell = row198.getCell(3);
			    	if (R198cell != null) {
			    	R198cell.setCellValue(brf181a.getR198_STANDALONE() == null ? 0 :
			    	brf181a.getR198_STANDALONE().intValue());
			    	}
			    	Cell R198cell0 = row198.getCell(4);
			    	if (R198cell0 != null) {
			    	R198cell0.setCellValue(brf181a.getR198_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR198_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -217/////////
			    	Row row199 = sheet.getRow(216);
					Cell R199cell = row199.getCell(3);
			    	if (R199cell != null) {
			    	R199cell.setCellValue(brf181a.getR199_STANDALONE() == null ? 0 :
			    	brf181a.getR199_STANDALONE().intValue());
			    	}
			    	Cell R199cell0 = row199.getCell(4);
			    	if (R199cell0 != null) {
			    	R199cell0.setCellValue(brf181a.getR199_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR199_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -218/////////
			    	Row row200 = sheet.getRow(217);
					Cell R200cell = row200.getCell(3);
			    	if (R200cell != null) {
			    	R200cell.setCellValue(brf181a.getR200_STANDALONE() == null ? 0 :
			    	brf181a.getR200_STANDALONE().intValue());
			    	}
			    	Cell R200cell0 = row200.getCell(4);
			    	if (R200cell0 != null) {
			    	R200cell0.setCellValue(brf181a.getR200_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR200_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -219/////////
			    	Row row201 = sheet.getRow(218);
					Cell R201cell = row201.getCell(3);
			    	if (R201cell != null) {
			    	R201cell.setCellValue(brf181a.getR201_STANDALONE() == null ? 0 :
			    	brf181a.getR201_STANDALONE().intValue());
			    	}
			    	Cell R201cell0 = row201.getCell(4);
			    	if (R201cell0 != null) {
			    	R201cell0.setCellValue(brf181a.getR201_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR201_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -221/////////
			    	Row row202 = sheet.getRow(220);
					Cell R202cell = row202.getCell(3);
			    	if (R202cell != null) {
			    	R202cell.setCellValue(brf181a.getR202_STANDALONE() == null ? 0 :
			    	brf181a.getR202_STANDALONE().intValue());
			    	}
			    	Cell R202cell0 = row202.getCell(4);
			    	if (R202cell0 != null) {
			    	R202cell0.setCellValue(brf181a.getR202_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR202_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -222/////////
			    	Row row203 = sheet.getRow(221);
					Cell R203cell = row203.getCell(3);
			    	if (R203cell != null) {
			    	R203cell.setCellValue(brf181a.getR203_STANDALONE() == null ? 0 :
			    	brf181a.getR203_STANDALONE().intValue());
			    	}
			    	Cell R203cell0 = row203.getCell(4);
			    	if (R203cell0 != null) {
			    	R203cell0.setCellValue(brf181a.getR203_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR203_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -223/////////
			    	Row row204 = sheet.getRow(222);
					Cell R204cell = row204.getCell(3);
			    	if (R204cell != null) {
			    	R204cell.setCellValue(brf181a.getR204_STANDALONE() == null ? 0 :
			    	brf181a.getR204_STANDALONE().intValue());
			    	}
			    	Cell R204cell0 = row204.getCell(4);
			    	if (R204cell0 != null) {
			    	R204cell0.setCellValue(brf181a.getR204_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR204_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -224/////////
			    	Row row205 = sheet.getRow(223);
					Cell R205cell = row205.getCell(3);
			    	if (R205cell != null) {
			    	R205cell.setCellValue(brf181a.getR205_STANDALONE() == null ? 0 :
			    	brf181a.getR205_STANDALONE().intValue());
			    	}
			    	Cell R205cell0 = row205.getCell(4);
			    	if (R205cell0 != null) {
			    	R205cell0.setCellValue(brf181a.getR205_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR205_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -225/////////
			    	Row row206 = sheet.getRow(224);
					Cell R206cell = row206.getCell(3);
			    	if (R206cell != null) {
			    	R206cell.setCellValue(brf181a.getR206_STANDALONE() == null ? 0 :
			    	brf181a.getR206_STANDALONE().intValue());
			    	}
			    	Cell R206cell0 = row206.getCell(4);
			    	if (R206cell0 != null) {
			    	R206cell0.setCellValue(brf181a.getR206_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR206_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -226/////////
			    	Row row207 = sheet.getRow(225);
					Cell R207cell = row207.getCell(3);
			    	if (R207cell != null) {
			    	R207cell.setCellValue(brf181a.getR207_STANDALONE() == null ? 0 :
			    	brf181a.getR207_STANDALONE().intValue());
			    	}
			    	Cell R207cell0 = row207.getCell(4);
			    	if (R207cell0 != null) {
			    	R207cell0.setCellValue(brf181a.getR207_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR207_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -227/////////
			    	Row row208 = sheet.getRow(226);
					Cell R208cell = row208.getCell(3);
			    	if (R208cell != null) {
			    	R208cell.setCellValue(brf181a.getR208_STANDALONE() == null ? 0 :
			    	brf181a.getR208_STANDALONE().intValue());
			    	}
			    	Cell R208cell0 = row208.getCell(4);
			    	if (R208cell0 != null) {
			    	R208cell0.setCellValue(brf181a.getR208_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR208_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -228/////////
			    	Row row209 = sheet.getRow(227);
					Cell R209cell = row209.getCell(3);
			    	if (R209cell != null) {
			    	R209cell.setCellValue(brf181a.getR209_STANDALONE() == null ? 0 :
			    	brf181a.getR209_STANDALONE().intValue());
			    	}
			    	Cell R209cell0 = row209.getCell(4);
			    	if (R209cell0 != null) {
			    	R209cell0.setCellValue(brf181a.getR209_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR209_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -229/////////
			    	Row row210 = sheet.getRow(228);
					Cell R210cell = row210.getCell(3);
			    	if (R210cell != null) {
			    	R210cell.setCellValue(brf181a.getR210_STANDALONE() == null ? 0 :
			    	brf181a.getR210_STANDALONE().intValue());
			    	}
			    	Cell R210cell0 = row210.getCell(4);
			    	if (R210cell0 != null) {
			    	R210cell0.setCellValue(brf181a.getR210_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR210_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -230/////////
			    	Row row211 = sheet.getRow(229);
					Cell R211cell = row211.getCell(3);
			    	if (R211cell != null) {
			    	R211cell.setCellValue(brf181a.getR211_STANDALONE() == null ? 0 :
			    	brf181a.getR211_STANDALONE().intValue());
			    	}
			    	Cell R211cell0 = row211.getCell(4);
			    	if (R211cell0 != null) {
			    	R211cell0.setCellValue(brf181a.getR211_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR211_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -231/////////
			    	Row row212 = sheet.getRow(230);
					Cell R212cell = row212.getCell(3);
			    	if (R212cell != null) {
			    	R212cell.setCellValue(brf181a.getR212_STANDALONE() == null ? 0 :
			    	brf181a.getR212_STANDALONE().intValue());
			    	}
			    	Cell R212cell0 = row212.getCell(4);
			    	if (R212cell0 != null) {
			    	R212cell0.setCellValue(brf181a.getR212_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR212_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -232/////////
			    	Row row213 = sheet.getRow(231);
					Cell R213cell = row213.getCell(3);
			    	if (R213cell != null) {
			    	R213cell.setCellValue(brf181a.getR213_STANDALONE() == null ? 0 :
			    	brf181a.getR213_STANDALONE().intValue());
			    	}
			    	Cell R213cell0 = row213.getCell(4);
			    	if (R213cell0 != null) {
			    	R213cell0.setCellValue(brf181a.getR213_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR213_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -233/////////
			    	Row row214 = sheet.getRow(232);
					Cell R214cell = row214.getCell(3);
			    	if (R214cell != null) {
			    	R214cell.setCellValue(brf181a.getR214_STANDALONE() == null ? 0 :
			    	brf181a.getR214_STANDALONE().intValue());
			    	}
			    	Cell R214cell0 = row214.getCell(4);
			    	if (R214cell0 != null) {
			    	R214cell0.setCellValue(brf181a.getR214_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR214_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -234/////////
			    	Row row215 = sheet.getRow(233);
					Cell R215cell = row215.getCell(3);
			    	if (R215cell != null) {
			    	R215cell.setCellValue(brf181a.getR215_STANDALONE() == null ? 0 :
			    	brf181a.getR215_STANDALONE().intValue());
			    	}
			    	Cell R215cell0 = row215.getCell(4);
			    	if (R215cell0 != null) {
			    	R215cell0.setCellValue(brf181a.getR215_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR215_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -235/////////
			    	Row row216 = sheet.getRow(234);
					Cell R216cell = row216.getCell(3);
			    	if (R216cell != null) {
			    	R216cell.setCellValue(brf181a.getR216_STANDALONE() == null ? 0 :
			    	brf181a.getR216_STANDALONE().intValue());
			    	}
			    	Cell R216cell0 = row216.getCell(4);
			    	if (R216cell0 != null) {
			    	R216cell0.setCellValue(brf181a.getR216_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR216_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -236/////////
			    	Row row217 = sheet.getRow(235);
					Cell R217cell = row217.getCell(3);
			    	if (R217cell != null) {
			    	R217cell.setCellValue(brf181a.getR217_STANDALONE() == null ? 0 :
			    	brf181a.getR217_STANDALONE().intValue());
			    	}
			    	Cell R217cell0 = row217.getCell(4);
			    	if (R217cell0 != null) {
			    	R217cell0.setCellValue(brf181a.getR217_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR217_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -237/////////
			    	Row row218 = sheet.getRow(236);
					Cell R218cell = row218.getCell(3);
			    	if (R218cell != null) {
			    	R218cell.setCellValue(brf181a.getR218_STANDALONE() == null ? 0 :
			    	brf181a.getR218_STANDALONE().intValue());
			    	}
			    	Cell R218cell0 = row218.getCell(4);
			    	if (R218cell0 != null) {
			    	R218cell0.setCellValue(brf181a.getR218_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR218_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -238/////////
			    	Row row219 = sheet.getRow(237);
					Cell R219cell = row219.getCell(3);
			    	if (R219cell != null) {
			    	R219cell.setCellValue(brf181a.getR219_STANDALONE() == null ? 0 :
			    	brf181a.getR219_STANDALONE().intValue());
			    	}
			    	Cell R219cell0 = row219.getCell(4);
			    	if (R219cell0 != null) {
			    	R219cell0.setCellValue(brf181a.getR219_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR219_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -239/////////
			    	Row row220 = sheet.getRow(238);
					Cell R220cell = row220.getCell(3);
			    	if (R220cell != null) {
			    	R220cell.setCellValue(brf181a.getR220_STANDALONE() == null ? 0 :
			    	brf181a.getR220_STANDALONE().intValue());
			    	}
			    	Cell R220cell0 = row220.getCell(4);
			    	if (R220cell0 != null) {
			    	R220cell0.setCellValue(brf181a.getR220_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR220_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -240/////////
			    	Row row221 = sheet.getRow(239);
					Cell R221cell = row221.getCell(3);
			    	if (R221cell != null) {
			    	R221cell.setCellValue(brf181a.getR221_STANDALONE() == null ? 0 :
			    	brf181a.getR221_STANDALONE().intValue());
			    	}
			    	Cell R221cell0 = row221.getCell(4);
			    	if (R221cell0 != null) {
			    	R221cell0.setCellValue(brf181a.getR221_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR221_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -241/////////
			    	Row row222 = sheet.getRow(240);
					Cell R222cell = row222.getCell(3);
			    	if (R222cell != null) {
			    	R222cell.setCellValue(brf181a.getR222_STANDALONE() == null ? 0 :
			    	brf181a.getR222_STANDALONE().intValue());
			    	}
			    	Cell R222cell0 = row222.getCell(4);
			    	if (R222cell0 != null) {
			    	R222cell0.setCellValue(brf181a.getR222_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR222_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -242/////////
			    	Row row223 = sheet.getRow(241);
					Cell R223cell = row223.getCell(3);
			    	if (R223cell != null) {
			    	R223cell.setCellValue(brf181a.getR223_STANDALONE() == null ? 0 :
			    	brf181a.getR223_STANDALONE().intValue());
			    	}
			    	Cell R223cell0 = row223.getCell(4);
			    	if (R223cell0 != null) {
			    	R223cell0.setCellValue(brf181a.getR223_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR223_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -243/////////
			    	Row row224 = sheet.getRow(242);
					Cell R224cell = row224.getCell(3);
			    	if (R224cell != null) {
			    	R224cell.setCellValue(brf181a.getR224_STANDALONE() == null ? 0 :
			    	brf181a.getR224_STANDALONE().intValue());
			    	}
			    	Cell R224cell0 = row224.getCell(4);
			    	if (R224cell0 != null) {
			    	R224cell0.setCellValue(brf181a.getR224_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR224_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -244/////////
			    	Row row225 = sheet.getRow(243);
					Cell R225cell = row225.getCell(3);
			    	if (R225cell != null) {
			    	R225cell.setCellValue(brf181a.getR225_STANDALONE() == null ? 0 :
			    	brf181a.getR225_STANDALONE().intValue());
			    	}
			    	Cell R225cell0 = row225.getCell(4);
			    	if (R225cell0 != null) {
			    	R225cell0.setCellValue(brf181a.getR225_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR225_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -246/////////
			    	Row row226 = sheet.getRow(245);
					Cell R226cell = row226.getCell(3);
			    	if (R226cell != null) {
			    	R226cell.setCellValue(brf181a.getR226_STANDALONE() == null ? 0 :
			    	brf181a.getR226_STANDALONE().intValue());
			    	}
			    	Cell R226cell0 = row226.getCell(4);
			    	if (R226cell0 != null) {
			    	R226cell0.setCellValue(brf181a.getR226_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR226_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -247/////////
			    	Row row227 = sheet.getRow(246);
					Cell R227cell = row227.getCell(3);
			    	if (R227cell != null) {
			    	R227cell.setCellValue(brf181a.getR227_STANDALONE() == null ? 0 :
			    	brf181a.getR227_STANDALONE().intValue());
			    	}
			    	Cell R227cell0 = row227.getCell(4);
			    	if (R227cell0 != null) {
			    	R227cell0.setCellValue(brf181a.getR227_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR227_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -248/////////
			    	Row row228 = sheet.getRow(247);
					Cell R228cell = row228.getCell(3);
			    	if (R228cell != null) {
			    	R228cell.setCellValue(brf181a.getR228_STANDALONE() == null ? 0 :
			    	brf181a.getR228_STANDALONE().intValue());
			    	}
			    	Cell R228cell0 = row228.getCell(4);
			    	if (R228cell0 != null) {
			    	R228cell0.setCellValue(brf181a.getR228_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR228_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -249/////////
			    	Row row229 = sheet.getRow(248);
					Cell R229cell = row229.getCell(3);
			    	if (R229cell != null) {
			    	R229cell.setCellValue(brf181a.getR229_STANDALONE() == null ? 0 :
			    	brf181a.getR229_STANDALONE().intValue());
			    	}
			    	Cell R229cell0 = row229.getCell(4);
			    	if (R229cell0 != null) {
			    	R229cell0.setCellValue(brf181a.getR229_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR229_CONSOLIDATED().intValue());
			    	}
			    /////srl_no -250/////////
			    	Row row230 = sheet.getRow(249);
					Cell R230cell = row230.getCell(3);
			    	if (R230cell != null) {
			    	R230cell.setCellValue(brf181a.getR230_STANDALONE() == null ? 0 :
			    	brf181a.getR230_STANDALONE().intValue());
			    	}
			    	Cell R230cell0 = row230.getCell(4);
			    	if (R230cell0 != null) {
			    	R230cell0.setCellValue(brf181a.getR230_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR230_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -251/////////
			    	Row row231 = sheet.getRow(250);
					Cell R231cell = row231.getCell(3);
			    	if (R231cell != null) {
			    	R231cell.setCellValue(brf181a.getR231_STANDALONE() == null ? 0 :
			    	brf181a.getR231_STANDALONE().intValue());
			    	}
			    	Cell R231cell0 = row231.getCell(4);
			    	if (R231cell0 != null) {
			    	R231cell0.setCellValue(brf181a.getR231_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR231_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -252/////////
			    	Row row232 = sheet.getRow(251);
					Cell R232cell = row232.getCell(3);
			    	if (R232cell != null) {
			    	R232cell.setCellValue(brf181a.getR232_STANDALONE() == null ? 0 :
			    	brf181a.getR232_STANDALONE().intValue());
			    	}
			    	Cell R232cell0 = row232.getCell(4);
			    	if (R232cell0 != null) {
			    	R232cell0.setCellValue(brf181a.getR232_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR232_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -253/////////
			    	Row row233 = sheet.getRow(252);
					Cell R233cell = row233.getCell(3);
			    	if (R233cell != null) {
			    	R233cell.setCellValue(brf181a.getR233_STANDALONE() == null ? 0 :
			    	brf181a.getR233_STANDALONE().intValue());
			    	}
			    	Cell R233cell0 = row233.getCell(4);
			    	if (R233cell0 != null) {
			    	R233cell0.setCellValue(brf181a.getR233_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR233_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -254/////////
			    	Row row234 = sheet.getRow(253);
					Cell R234cell = row234.getCell(3);
			    	if (R234cell != null) {
			    	R234cell.setCellValue(brf181a.getR234_STANDALONE() == null ? 0 :
			    	brf181a.getR234_STANDALONE().intValue());
			    	}
			    	Cell R234cell0 = row234.getCell(4);
			    	if (R234cell0 != null) {
			    	R234cell0.setCellValue(brf181a.getR234_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR234_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -255/////////
			    	Row row235 = sheet.getRow(254);
					Cell R235cell = row235.getCell(3);
			    	if (R235cell != null) {
			    	R235cell.setCellValue(brf181a.getR235_STANDALONE() == null ? 0 :
			    	brf181a.getR235_STANDALONE().intValue());
			    	}
			    	Cell R235cell0 = row235.getCell(4);
			    	if (R235cell0 != null) {
			    	R235cell0.setCellValue(brf181a.getR235_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR235_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -256/////////
			    	Row row236 = sheet.getRow(255);
					Cell R236cell = row236.getCell(3);
			    	if (R236cell != null) {
			    	R236cell.setCellValue(brf181a.getR236_STANDALONE() == null ? 0 :
			    	brf181a.getR236_STANDALONE().intValue());
			    	}
			    	Cell R236cell0 = row236.getCell(4);
			    	if (R236cell0 != null) {
			    	R236cell0.setCellValue(brf181a.getR236_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR236_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -257/////////
			    	Row row237 = sheet.getRow(256);
					Cell R237cell = row237.getCell(3);
			    	if (R237cell != null) {
			    	R237cell.setCellValue(brf181a.getR237_STANDALONE() == null ? 0 :
			    	brf181a.getR237_STANDALONE().intValue());
			    	}
			    	Cell R237cell0 = row237.getCell(4);
			    	if (R237cell0 != null) {
			    	R237cell0.setCellValue(brf181a.getR237_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR237_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -258/////////
			    	Row row238 = sheet.getRow(257);
					Cell R238cell = row238.getCell(3);
			    	if (R238cell != null) {
			    	R238cell.setCellValue(brf181a.getR238_STANDALONE() == null ? 0 :
			    	brf181a.getR238_STANDALONE().intValue());
			    	}
			    	Cell R238cell0 = row238.getCell(4);
			    	if (R238cell0 != null) {
			    	R238cell0.setCellValue(brf181a.getR238_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR238_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -259/////////
			    	Row row239 = sheet.getRow(258);
					Cell R239cell = row239.getCell(3);
			    	if (R239cell != null) {
			    	R239cell.setCellValue(brf181a.getR239_STANDALONE() == null ? 0 :
			    	brf181a.getR239_STANDALONE().intValue());
			    	}
			    	Cell R239cell0 = row239.getCell(4);
			    	if (R239cell0 != null) {
			    	R239cell0.setCellValue(brf181a.getR239_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR239_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -260/////////
			    	Row row240 = sheet.getRow(259);
					Cell R240cell = row240.getCell(3);
			    	if (R240cell != null) {
			    	R240cell.setCellValue(brf181a.getR240_STANDALONE() == null ? 0 :
			    	brf181a.getR240_STANDALONE().intValue());
			    	}
			    	Cell R240cell0 = row240.getCell(4);
			    	if (R240cell0 != null) {
			    	R240cell0.setCellValue(brf181a.getR240_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR240_CONSOLIDATED().intValue());
			    	}
			    	
			    	 /////srl_no -262/////////
			    	Row row241 = sheet.getRow(261);
					Cell R241cell = row241.getCell(3);
			    	if (R241cell != null) {
			    	R241cell.setCellValue(brf181a.getR241_STANDALONE() == null ? 0 :
			    	brf181a.getR241_STANDALONE().intValue());
			    	}
			    	Cell R241cell0 = row241.getCell(4);
			    	if (R241cell0 != null) {
			    	R241cell0.setCellValue(brf181a.getR241_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR241_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -263/////////
			    	Row row242 = sheet.getRow(262);
					Cell R242cell = row242.getCell(3);
			    	if (R242cell != null) {
			    	R242cell.setCellValue(brf181a.getR242_STANDALONE() == null ? 0 :
			    	brf181a.getR242_STANDALONE().intValue());
			    	}
			    	Cell R242cell0 = row242.getCell(4);
			    	if (R242cell0 != null) {
			    	R242cell0.setCellValue(brf181a.getR242_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR242_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -264/////////
			    	Row row243 = sheet.getRow(263);
					Cell R243cell = row243.getCell(3);
			    	if (R243cell != null) {
			    	R243cell.setCellValue(brf181a.getR243_STANDALONE() == null ? 0 :
			    	brf181a.getR243_STANDALONE().intValue());
			    	}
			    	Cell R243cell0 = row243.getCell(4);
			    	if (R243cell0 != null) {
			    	R243cell0.setCellValue(brf181a.getR243_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR243_CONSOLIDATED().intValue());
			    	}
			    	
			    	
			    /////srl_no -265/////////
			    	Row row244 = sheet.getRow(264);
					Cell R244cell = row244.getCell(3);
			    	if (R244cell != null) {
			    	R244cell.setCellValue(brf181a.getR244_STANDALONE() == null ? 0 :
			    	brf181a.getR244_STANDALONE().intValue());
			    	}
			    	Cell R244cell0 = row244.getCell(4);
			    	if (R244cell0 != null) {
			    	R244cell0.setCellValue(brf181a.getR244_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR244_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -266/////////
			    	Row row245 = sheet.getRow(265);
					Cell R245cell = row245.getCell(3);
			    	if (R245cell != null) {
			    	R245cell.setCellValue(brf181a.getR245_STANDALONE() == null ? 0 :
			    	brf181a.getR245_STANDALONE().intValue());
			    	}
			    	Cell R245cell0 = row245.getCell(4);
			    	if (R245cell0 != null) {
			    	R245cell0.setCellValue(brf181a.getR245_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR245_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -267/////////
			    	Row row246 = sheet.getRow(266);
					Cell R246cell = row246.getCell(3);
			    	if (R246cell != null) {
			    	R246cell.setCellValue(brf181a.getR246_STANDALONE() == null ? 0 :
			    	brf181a.getR246_STANDALONE().intValue());
			    	}
			    	Cell R246cell0 = row246.getCell(4);
			    	if (R246cell0 != null) {
			    	R246cell0.setCellValue(brf181a.getR246_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR246_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -268/////////
			    	Row row247 = sheet.getRow(267);
					Cell R247cell = row247.getCell(3);
			    	if (R247cell != null) {
			    	R247cell.setCellValue(brf181a.getR247_STANDALONE() == null ? 0 :
			    	brf181a.getR247_STANDALONE().intValue());
			    	}
			    	Cell R247cell0 = row247.getCell(4);
			    	if (R247cell0 != null) {
			    	R247cell0.setCellValue(brf181a.getR247_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR247_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -269/////////
			    	Row row248 = sheet.getRow(268);
					Cell R248cell = row248.getCell(3);
			    	if (R248cell != null) {
			    	R248cell.setCellValue(brf181a.getR248_STANDALONE() == null ? 0 :
			    	brf181a.getR248_STANDALONE().intValue());
			    	}
			    	Cell R248cell0 = row248.getCell(4);
			    	if (R248cell0 != null) {
			    	R248cell0.setCellValue(brf181a.getR248_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR248_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -271/////////
			    	Row row249 = sheet.getRow(270);
					Cell R249cell = row249.getCell(3);
			    	if (R249cell != null) {
			    	R249cell.setCellValue(brf181a.getR249_STANDALONE() == null ? 0 :
			    	brf181a.getR249_STANDALONE().intValue());
			    	}
			    	Cell R249cell0 = row249.getCell(4);
			    	if (R249cell0 != null) {
			    	R249cell0.setCellValue(brf181a.getR249_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR249_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -272/////////
			    	Row row250 = sheet.getRow(271);
					Cell R250cell = row250.getCell(3);
			    	if (R250cell != null) {
			    	R250cell.setCellValue(brf181a.getR250_STANDALONE() == null ? 0 :
			    	brf181a.getR250_STANDALONE().intValue());
			    	}
			    	Cell R250cell0 = row250.getCell(4);
			    	if (R250cell0 != null) {
			    	R250cell0.setCellValue(brf181a.getR250_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR250_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -273/////////
			    	Row row251 = sheet.getRow(272);
					Cell R251cell = row251.getCell(3);
			    	if (R251cell != null) {
			    	R251cell.setCellValue(brf181a.getR251_STANDALONE() == null ? 0 :
			    	brf181a.getR251_STANDALONE().intValue());
			    	}
			    	Cell R251cell0 = row251.getCell(4);
			    	if (R251cell0 != null) {
			    	R251cell0.setCellValue(brf181a.getR251_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR251_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -274/////////
			    	Row row252 = sheet.getRow(273);
					Cell R252cell = row252.getCell(3);
			    	if (R252cell != null) {
			    	R252cell.setCellValue(brf181a.getR252_STANDALONE() == null ? 0 :
			    	brf181a.getR252_STANDALONE().intValue());
			    	}
			    	Cell R252cell0 = row252.getCell(4);
			    	if (R252cell0 != null) {
			    	R252cell0.setCellValue(brf181a.getR252_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR252_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -275/////////
			    	Row row253 = sheet.getRow(274);
					Cell R253cell = row253.getCell(3);
			    	if (R253cell != null) {
			    	R253cell.setCellValue(brf181a.getR253_STANDALONE() == null ? 0 :
			    	brf181a.getR253_STANDALONE().intValue());
			    	}
			    	Cell R253cell0 = row253.getCell(4);
			    	if (R253cell0 != null) {
			    	R253cell0.setCellValue(brf181a.getR253_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR253_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -276/////////
			    	Row row254 = sheet.getRow(275);
					Cell R254cell = row254.getCell(3);
			    	if (R254cell != null) {
			    	R254cell.setCellValue(brf181a.getR254_STANDALONE() == null ? 0 :
			    	brf181a.getR254_STANDALONE().intValue());
			    	}
			    	Cell R254cell0 = row254.getCell(4);
			    	if (R254cell0 != null) {
			    	R254cell0.setCellValue(brf181a.getR254_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR254_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -277/////////
			    	Row row255 = sheet.getRow(276);
					Cell R255cell = row255.getCell(3);
			    	if (R255cell != null) {
			    	R255cell.setCellValue(brf181a.getR255_STANDALONE() == null ? 0 :
			    	brf181a.getR255_STANDALONE().intValue());
			    	}
			    	Cell R255cell0 = row255.getCell(4);
			    	if (R255cell0 != null) {
			    	R255cell0.setCellValue(brf181a.getR255_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR255_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -278/////////
			    	Row row256 = sheet.getRow(277);
					Cell R256cell = row256.getCell(3);
			    	if (R256cell != null) {
			    	R256cell.setCellValue(brf181a.getR256_STANDALONE() == null ? 0 :
			    	brf181a.getR256_STANDALONE().intValue());
			    	}
			    	Cell R256cell0 = row256.getCell(4);
			    	if (R256cell0 != null) {
			    	R256cell0.setCellValue(brf181a.getR256_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR256_CONSOLIDATED().intValue());
			    	}
			    /////srl_no -279/////////
			    	Row row257 = sheet.getRow(278);
					Cell R257cell = row257.getCell(3);
			    	if (R257cell != null) {
			    	R257cell.setCellValue(brf181a.getR257_STANDALONE() == null ? 0 :
			    	brf181a.getR257_STANDALONE().intValue());
			    	}
			    	Cell R257cell0 = row257.getCell(4);
			    	if (R257cell0 != null) {
			    	R257cell0.setCellValue(brf181a.getR257_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR257_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -280/////////
			    	Row row258 = sheet.getRow(279);
					Cell R258cell = row258.getCell(3);
			    	if (R258cell != null) {
			    	R258cell.setCellValue(brf181a.getR258_STANDALONE() == null ? 0 :
			    	brf181a.getR258_STANDALONE().intValue());
			    	}
			    	Cell R258cell0 = row258.getCell(4);
			    	if (R258cell0 != null) {
			    	R258cell0.setCellValue(brf181a.getR258_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR258_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -281/////////
			    	Row row259 = sheet.getRow(280);
					Cell R259cell = row259.getCell(3);
			    	if (R259cell != null) {
			    	R259cell.setCellValue(brf181a.getR259_STANDALONE() == null ? 0 :
			    	brf181a.getR259_STANDALONE().intValue());
			    	}
			    	Cell R259cell0 = row259.getCell(4);
			    	if (R259cell0 != null) {
			    	R259cell0.setCellValue(brf181a.getR259_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR259_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -282/////////
			    	Row row260 = sheet.getRow(281);
					Cell R260cell = row260.getCell(3);
			    	if (R260cell != null) {
			    	R260cell.setCellValue(brf181a.getR260_STANDALONE() == null ? 0 :
			    	brf181a.getR260_STANDALONE().intValue());
			    	}
			    	Cell R260cell0 = row260.getCell(4);
			    	if (R260cell0 != null) {
			    	R260cell0.setCellValue(brf181a.getR260_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR260_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -283/////////
			    	Row row261 = sheet.getRow(282);
					Cell R261cell = row261.getCell(3);
			    	if (R261cell != null) {
			    	R261cell.setCellValue(brf181a.getR261_STANDALONE() == null ? 0 :
			    	brf181a.getR261_STANDALONE().intValue());
			    	}
			    	Cell R261cell0 = row261.getCell(4);
			    	if (R261cell0 != null) {
			    	R261cell0.setCellValue(brf181a.getR261_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR261_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -284/////////
			    	Row row262 = sheet.getRow(283);
					Cell R262cell = row262.getCell(3);
			    	if (R262cell != null) {
			    	R262cell.setCellValue(brf181a.getR262_STANDALONE() == null ? 0 :
			    	brf181a.getR262_STANDALONE().intValue());
			    	}
			    	Cell R262cell0 = row262.getCell(4);
			    	if (R262cell0 != null) {
			    	R262cell0.setCellValue(brf181a.getR262_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR262_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -285/////////
			    	Row row263 = sheet.getRow(284);
					Cell R263cell = row263.getCell(3);
			    	if (R263cell != null) {
			    	R263cell.setCellValue(brf181a.getR263_STANDALONE() == null ? 0 :
			    	brf181a.getR263_STANDALONE().intValue());
			    	}
			    	Cell R263cell0 = row263.getCell(4);
			    	if (R263cell0 != null) {
			    	R263cell0.setCellValue(brf181a.getR263_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR263_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -286/////////
			    	Row row264 = sheet.getRow(285);
					Cell R264cell = row264.getCell(3);
			    	if (R264cell != null) {
			    	R264cell.setCellValue(brf181a.getR264_STANDALONE() == null ? 0 :
			    	brf181a.getR264_STANDALONE().intValue());
			    	}
			    	Cell R264cell0 = row264.getCell(4);
			    	if (R264cell0 != null) {
			    	R264cell0.setCellValue(brf181a.getR264_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR264_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -287/////////
			    	Row row265 = sheet.getRow(286);
					Cell R265cell = row265.getCell(3);
			    	if (R265cell != null) {
			    	R265cell.setCellValue(brf181a.getR265_STANDALONE() == null ? 0 :
			    	brf181a.getR265_STANDALONE().intValue());
			    	}
			    	Cell R265cell0 = row265.getCell(4);
			    	if (R265cell0 != null) {
			    	R265cell0.setCellValue(brf181a.getR265_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR265_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -288/////////
			    	Row row266 = sheet.getRow(287);
					Cell R266cell = row266.getCell(3);
			    	if (R266cell != null) {
			    	R266cell.setCellValue(brf181a.getR266_STANDALONE() == null ? 0 :
			    	brf181a.getR266_STANDALONE().intValue());
			    	}
			    	Cell R266cell0 = row266.getCell(4);
			    	if (R266cell0 != null) {
			    	R266cell0.setCellValue(brf181a.getR266_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR266_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -289/////////
			    	Row row267 = sheet.getRow(288);
					Cell R267cell = row267.getCell(3);
			    	if (R267cell != null) {
			    	R267cell.setCellValue(brf181a.getR267_STANDALONE() == null ? 0 :
			    	brf181a.getR267_STANDALONE().intValue());
			    	}
			    	Cell R267cell0 = row267.getCell(4);
			    	if (R267cell0 != null) {
			    	R267cell0.setCellValue(brf181a.getR267_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR267_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -290/////////
			    	Row row268 = sheet.getRow(289);
					Cell R268cell = row268.getCell(3);
			    	if (R268cell != null) {
			    	R268cell.setCellValue(brf181a.getR268_STANDALONE() == null ? 0 :
			    	brf181a.getR268_STANDALONE().intValue());
			    	}
			    	Cell R268cell0 = row268.getCell(4);
			    	if (R268cell0 != null) {
			    	R268cell0.setCellValue(brf181a.getR268_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR268_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -291/////////
			    	Row row269 = sheet.getRow(290);
					Cell R269cell = row269.getCell(3);
			    	if (R269cell != null) {
			    	R269cell.setCellValue(brf181a.getR269_STANDALONE() == null ? 0 :
			    	brf181a.getR269_STANDALONE().intValue());
			    	}
			    	Cell R269cell0 = row269.getCell(4);
			    	if (R269cell0 != null) {
			    	R269cell0.setCellValue(brf181a.getR269_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR269_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -292/////////
			    	Row row270 = sheet.getRow(291);
					Cell R270cell = row270.getCell(3);
			    	if (R270cell != null) {
			    	R270cell.setCellValue(brf181a.getR270_STANDALONE() == null ? 0 :
			    	brf181a.getR270_STANDALONE().intValue());
			    	}
			    	Cell R270cell0 = row270.getCell(4);
			    	if (R270cell0 != null) {
			    	R270cell0.setCellValue(brf181a.getR270_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR270_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -293/////////
			    	Row row271 = sheet.getRow(292);
					Cell R271cell = row271.getCell(3);
			    	if (R271cell != null) {
			    	R271cell.setCellValue(brf181a.getR271_STANDALONE() == null ? 0 :
			    	brf181a.getR271_STANDALONE().intValue());
			    	}
			    	Cell R271cell0 = row271.getCell(4);
			    	if (R271cell0 != null) {
			    	R271cell0.setCellValue(brf181a.getR271_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR271_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -294/////////
			    	Row row272 = sheet.getRow(293);
					Cell R272cell = row272.getCell(3);
			    	if (R272cell != null) {
			    	R272cell.setCellValue(brf181a.getR272_STANDALONE() == null ? 0 :
			    	brf181a.getR272_STANDALONE().intValue());
			    	}
			    	Cell R272cell0 = row272.getCell(4);
			    	if (R272cell0 != null) {
			    	R272cell0.setCellValue(brf181a.getR272_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR272_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -295/////////
			    	Row row273 = sheet.getRow(294);
					Cell R273cell = row273.getCell(3);
			    	if (R273cell != null) {
			    	R273cell.setCellValue(brf181a.getR273_STANDALONE() == null ? 0 :
			    	brf181a.getR273_STANDALONE().intValue());
			    	}
			    	Cell R273cell0 = row273.getCell(4);
			    	if (R273cell0 != null) {
			    	R273cell0.setCellValue(brf181a.getR273_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR273_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -296/////////
			    	Row row274 = sheet.getRow(295);
					Cell R274cell = row274.getCell(3);
			    	if (R274cell != null) {
			    	R274cell.setCellValue(brf181a.getR274_STANDALONE() == null ? 0 :
			    	brf181a.getR274_STANDALONE().intValue());
			    	}
			    	Cell R274cell0 = row274.getCell(4);
			    	if (R274cell0 != null) {
			    	R274cell0.setCellValue(brf181a.getR274_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR274_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -297/////////
			    	Row row275 = sheet.getRow(296);
					Cell R275cell = row275.getCell(3);
			    	if (R275cell != null) {
			    	R275cell.setCellValue(brf181a.getR275_STANDALONE() == null ? 0 :
			    	brf181a.getR275_STANDALONE().intValue());
			    	}
			    	Cell R275cell0 = row275.getCell(4);
			    	if (R275cell0 != null) {
			    	R275cell0.setCellValue(brf181a.getR275_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR275_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -298/////////
			    	Row row276 = sheet.getRow(297);
					Cell R276cell = row276.getCell(3);
			    	if (R276cell != null) {
			    	R276cell.setCellValue(brf181a.getR276_STANDALONE() == null ? 0 :
			    	brf181a.getR276_STANDALONE().intValue());
			    	}
			    	Cell R276cell0 = row276.getCell(4);
			    	if (R276cell0 != null) {
			    	R276cell0.setCellValue(brf181a.getR276_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR276_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -299/////////
			    	Row row277 = sheet.getRow(298);
					Cell R277cell = row277.getCell(3);
			    	if (R277cell != null) {
			    	R277cell.setCellValue(brf181a.getR277_STANDALONE() == null ? 0 :
			    	brf181a.getR277_STANDALONE().intValue());
			    	}
			    	Cell R277cell0 = row277.getCell(4);
			    	if (R277cell0 != null) {
			    	R277cell0.setCellValue(brf181a.getR277_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR277_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -300/////////
			    	Row row278 = sheet.getRow(299);
					Cell R278cell = row278.getCell(3);
			    	if (R278cell != null) {
			    	R278cell.setCellValue(brf181a.getR278_STANDALONE() == null ? 0 :
			    	brf181a.getR278_STANDALONE().intValue());
			    	}
			    	Cell R278cell0 = row278.getCell(4);
			    	if (R278cell0 != null) {
			    	R278cell0.setCellValue(brf181a.getR278_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR278_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -301/////////
			    	Row row279 = sheet.getRow(300);
					Cell R279cell = row279.getCell(3);
			    	if (R279cell != null) {
			    	R279cell.setCellValue(brf181a.getR279_STANDALONE() == null ? 0 :
			    	brf181a.getR279_STANDALONE().intValue());
			    	}
			    	Cell R279cell0 = row279.getCell(4);
			    	if (R279cell0 != null) {
			    	R279cell0.setCellValue(brf181a.getR279_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR279_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -302/////////
			    	Row row280 = sheet.getRow(301);
					Cell R280cell = row280.getCell(3);
			    	if (R280cell != null) {
			    	R280cell.setCellValue(brf181a.getR280_STANDALONE() == null ? 0 :
			    	brf181a.getR280_STANDALONE().intValue());
			    	}
			    	Cell R280cell0 = row280.getCell(4);
			    	if (R280cell0 != null) {
			    	R280cell0.setCellValue(brf181a.getR280_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR280_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -303/////////
			    	Row row281 = sheet.getRow(302);
					Cell R281cell = row281.getCell(3);
			    	if (R281cell != null) {
			    	R281cell.setCellValue(brf181a.getR281_STANDALONE() == null ? 0 :
			    	brf181a.getR281_STANDALONE().intValue());
			    	}
			    	Cell R281cell0 = row281.getCell(4);
			    	if (R281cell0 != null) {
			    	R281cell0.setCellValue(brf181a.getR281_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR281_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -304/////////
			    	Row row282 = sheet.getRow(303);
					Cell R282cell = row282.getCell(3);
			    	if (R282cell != null) {
			    	R282cell.setCellValue(brf181a.getR282_STANDALONE() == null ? 0 :
			    	brf181a.getR282_STANDALONE().intValue());
			    	}
			    	Cell R282cell0 = row282.getCell(4);
			    	if (R282cell0 != null) {
			    	R282cell0.setCellValue(brf181a.getR282_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR282_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -305/////////
			    	Row row283 = sheet.getRow(304);
					Cell R283cell = row283.getCell(3);
			    	if (R283cell != null) {
			    	R283cell.setCellValue(brf181a.getR283_STANDALONE() == null ? 0 :
			    	brf181a.getR283_STANDALONE().intValue());
			    	}
			    	Cell R283cell0 = row283.getCell(4);
			    	if (R283cell0 != null) {
			    	R283cell0.setCellValue(brf181a.getR283_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR283_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -306/////////
			    	Row row284 = sheet.getRow(305);
					Cell R284cell = row284.getCell(3);
			    	if (R284cell != null) {
			    	R284cell.setCellValue(brf181a.getR284_STANDALONE() == null ? 0 :
			    	brf181a.getR284_STANDALONE().intValue());
			    	}
			    	Cell R284cell0 = row284.getCell(4);
			    	if (R284cell0 != null) {
			    	R284cell0.setCellValue(brf181a.getR284_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR284_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -307/////////
			    	Row row285 = sheet.getRow(306);
					Cell R285cell = row285.getCell(3);
			    	if (R285cell != null) {
			    	R285cell.setCellValue(brf181a.getR285_STANDALONE() == null ? 0 :
			    	brf181a.getR285_STANDALONE().intValue());
			    	}
			    	Cell R285cell0 = row285.getCell(4);
			    	if (R285cell0 != null) {
			    	R285cell0.setCellValue(brf181a.getR285_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR285_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -308/////////
			    	Row row286 = sheet.getRow(307);
					Cell R286cell = row286.getCell(3);
			    	if (R286cell != null) {
			    	R286cell.setCellValue(brf181a.getR286_STANDALONE() == null ? 0 :
			    	brf181a.getR286_STANDALONE().intValue());
			    	}
			    	Cell R286cell0 = row286.getCell(4);
			    	if (R286cell0 != null) {
			    	R286cell0.setCellValue(brf181a.getR286_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR286_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -309/////////
			    	Row row287 = sheet.getRow(308);
					Cell R287cell = row287.getCell(3);
			    	if (R287cell != null) {
			    	R287cell.setCellValue(brf181a.getR287_STANDALONE() == null ? 0 :
			    	brf181a.getR287_STANDALONE().intValue());
			    	}
			    	Cell R287cell0 = row287.getCell(4);
			    	if (R287cell0 != null) {
			    	R287cell0.setCellValue(brf181a.getR287_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR287_CONSOLIDATED().intValue());
			    	}
					
			    	
					
			    /////srl_no -310/////////
			    	Row row288 = sheet.getRow(309);
					Cell R288cell = row288.getCell(3);
			    	if (R288cell != null) {
			    	R288cell.setCellValue(brf181a.getR288_STANDALONE() == null ? 0 :
			    	brf181a.getR288_STANDALONE().intValue());
			    	}
			    	Cell R288cell0 = row288.getCell(4);
			    	if (R288cell0 != null) {
			    	R288cell0.setCellValue(brf181a.getR288_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR288_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -311/////////
			    	Row row289 = sheet.getRow(310);
					Cell R289cell = row289.getCell(3);
			    	if (R289cell != null) {
			    	R289cell.setCellValue(brf181a.getR289_STANDALONE() == null ? 0 :
			    	brf181a.getR289_STANDALONE().intValue());
			    	}
			    	Cell R289cell0 = row289.getCell(4);
			    	if (R289cell0 != null) {
			    	R289cell0.setCellValue(brf181a.getR289_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR289_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -312/////////
			    	Row row290 = sheet.getRow(311);
					Cell R290cell = row290.getCell(3);
			    	if (R290cell != null) {
			    	R290cell.setCellValue(brf181a.getR290_STANDALONE() == null ? 0 :
			    	brf181a.getR290_STANDALONE().intValue());
			    	}
			    	Cell R290cell0 = row290.getCell(4);
			    	if (R290cell0 != null) {
			    	R290cell0.setCellValue(brf181a.getR290_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR290_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -313/////////
			    	Row row291 = sheet.getRow(312);
					Cell R291cell = row291.getCell(3);
			    	if (R291cell != null) {
			    	R291cell.setCellValue(brf181a.getR291_STANDALONE() == null ? 0 :
			    	brf181a.getR291_STANDALONE().intValue());
			    	}
			    	Cell R291cell0 = row291.getCell(4);
			    	if (R291cell0 != null) {
			    	R291cell0.setCellValue(brf181a.getR291_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR291_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -314/////////
			    	Row row292 = sheet.getRow(313);
					Cell R292cell = row292.getCell(3);
			    	if (R292cell != null) {
			    	R292cell.setCellValue(brf181a.getR292_STANDALONE() == null ? 0 :
			    	brf181a.getR292_STANDALONE().intValue());
			    	}
			    	Cell R292cell0 = row292.getCell(4);
			    	if (R292cell0 != null) {
			    	R292cell0.setCellValue(brf181a.getR292_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR292_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -315/////////
			    	Row row293 = sheet.getRow(314);
					Cell R293cell = row293.getCell(3);
			    	if (R293cell != null) {
			    	R293cell.setCellValue(brf181a.getR293_STANDALONE() == null ? 0 :
			    	brf181a.getR293_STANDALONE().intValue());
			    	}
			    	Cell R293cell0 = row293.getCell(4);
			    	if (R293cell0 != null) {
			    	R293cell0.setCellValue(brf181a.getR293_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR293_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -316/////////
			    	Row row294 = sheet.getRow(315);
					Cell R294cell = row294.getCell(3);
			    	if (R294cell != null) {
			    	R294cell.setCellValue(brf181a.getR294_STANDALONE() == null ? 0 :
			    	brf181a.getR294_STANDALONE().intValue());
			    	}
			    	Cell R294cell0 = row294.getCell(4);
			    	if (R294cell0 != null) {
			    	R294cell0.setCellValue(brf181a.getR294_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR294_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -317/////////
			    	Row row295 = sheet.getRow(316);
					Cell R295cell = row295.getCell(3);
			    	if (R295cell != null) {
			    	R295cell.setCellValue(brf181a.getR295_STANDALONE() == null ? 0 :
			    	brf181a.getR295_STANDALONE().intValue());
			    	}
			    	Cell R295cell0 = row295.getCell(4);
			    	if (R295cell0 != null) {
			    	R295cell0.setCellValue(brf181a.getR295_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR295_CONSOLIDATED().intValue());
			    	}
			    /////srl_no -318/////////
			    	Row row296 = sheet.getRow(317);
					Cell R296cell = row296.getCell(3);
			    	if (R296cell != null) {
			    	R296cell.setCellValue(brf181a.getR296_STANDALONE() == null ? 0 :
			    	brf181a.getR296_STANDALONE().intValue());
			    	}
			    	Cell R296cell0 = row296.getCell(4);
			    	if (R296cell0 != null) {
			    	R296cell0.setCellValue(brf181a.getR296_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR296_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -320/////////
			    	Row row297 = sheet.getRow(319);
					Cell R297cell = row297.getCell(3);
			    	if (R297cell != null) {
			    	R297cell.setCellValue(brf181a.getR297_STANDALONE() == null ? 0 :
			    	brf181a.getR297_STANDALONE().intValue());
			    	}
			    	Cell R297cell0 = row297.getCell(4);
			    	if (R297cell0 != null) {
			    	R297cell0.setCellValue(brf181a.getR297_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR297_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -321/////////
			    	Row row298 = sheet.getRow(320);
					Cell R298cell = row298.getCell(3);
			    	if (R298cell != null) {
			    	R298cell.setCellValue(brf181a.getR298_STANDALONE() == null ? 0 :
			    	brf181a.getR298_STANDALONE().intValue());
			    	}
			    	Cell R298cell0 = row298.getCell(4);
			    	if (R298cell0 != null) {
			    	R298cell0.setCellValue(brf181a.getR298_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR298_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -322/////////
			    	Row row299 = sheet.getRow(321);
					Cell R299cell = row299.getCell(3);
			    	if (R299cell != null) {
			    	R299cell.setCellValue(brf181a.getR299_STANDALONE() == null ? 0 :
			    	brf181a.getR299_STANDALONE().intValue());
			    	}
			    	Cell R299cell0 = row299.getCell(4);
			    	if (R299cell0 != null) {
			    	R299cell0.setCellValue(brf181a.getR299_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR299_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -323/////////
			    	Row row300 = sheet.getRow(322);
					Cell R300cell = row300.getCell(3);
			    	if (R300cell != null) {
			    	R300cell.setCellValue(brf181a.getR300_STANDALONE() == null ? 0 :
			    	brf181a.getR300_STANDALONE().intValue());
			    	}
			    	Cell R300cell0 = row300.getCell(4);
			    	if (R300cell0 != null) {
			    	R300cell0.setCellValue(brf181a.getR300_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR300_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -324/////////
			    	Row row301 = sheet.getRow(323);
					Cell R301cell = row301.getCell(3);
			    	if (R301cell != null) {
			    	R301cell.setCellValue(brf181a.getR301_STANDALONE() == null ? 0 :
			    	brf181a.getR301_STANDALONE().intValue());
			    	}
			    	Cell R301cell0 = row301.getCell(4);
			    	if (R301cell0 != null) {
			    	R301cell0.setCellValue(brf181a.getR301_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR301_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -325/////////
			    	Row row302 = sheet.getRow(324);
					Cell R302cell = row302.getCell(3);
			    	if (R302cell != null) {
			    	R302cell.setCellValue(brf181a.getR302_STANDALONE() == null ? 0 :
			    	brf181a.getR302_STANDALONE().intValue());
			    	}
			    	Cell R302cell0 = row302.getCell(4);
			    	if (R302cell0 != null) {
			    	R302cell0.setCellValue(brf181a.getR302_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR302_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -326/////////
			    	Row row303 = sheet.getRow(325);
					Cell R303cell = row303.getCell(3);
			    	if (R303cell != null) {
			    	R303cell.setCellValue(brf181a.getR303_STANDALONE() == null ? 0 :
			    	brf181a.getR303_STANDALONE().intValue());
			    	}
			    	Cell R303cell0 = row303.getCell(4);
			    	if (R303cell0 != null) {
			    	R303cell0.setCellValue(brf181a.getR303_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR303_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -327/////////
			    	Row row304 = sheet.getRow(326);
					Cell R304cell = row304.getCell(3);
			    	if (R304cell != null) {
			    	R304cell.setCellValue(brf181a.getR304_STANDALONE() == null ? 0 :
			    	brf181a.getR304_STANDALONE().intValue());
			    	}
			    	Cell R304cell0 = row304.getCell(4);
			    	if (R304cell0 != null) {
			    	R304cell0.setCellValue(brf181a.getR304_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR304_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -329/////////
			    	Row row305 = sheet.getRow(328);
					Cell R305cell = row305.getCell(3);
			    	if (R305cell != null) {
			    	R305cell.setCellValue(brf181a.getR305_STANDALONE() == null ? 0 :
			    	brf181a.getR305_STANDALONE().intValue());
			    	}
			    	Cell R305cell0 = row305.getCell(4);
			    	if (R305cell0 != null) {
			    	R305cell0.setCellValue(brf181a.getR305_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR305_CONSOLIDATED().intValue());
			    	}
					
			    	
			    /////srl_no -330/////////
			    	Row row306 = sheet.getRow(329);
					Cell R306cell = row306.getCell(3);
			    	if (R306cell != null) {
			    	R306cell.setCellValue(brf181a.getR306_STANDALONE() == null ? 0 :
			    	brf181a.getR306_STANDALONE().intValue());
			    	}
			    	Cell R306cell0 = row306.getCell(4);
			    	if (R306cell0 != null) {
			    	R306cell0.setCellValue(brf181a.getR306_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR306_CONSOLIDATED().intValue());
			    	}
			    	
			    /////srl_no -331/////////
			    	Row row307 = sheet.getRow(330);
					Cell R307cell = row307.getCell(3);
			    	if (R307cell != null) {
			    	R307cell.setCellValue(brf181a.getR307_STANDALONE() == null ? 0 :
			    	brf181a.getR307_STANDALONE().intValue());
			    	}
			    	Cell R307cell0 = row307.getCell(4);
			    	if (R307cell0 != null) {
			    	R307cell0.setCellValue(brf181a.getR307_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR307_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -332/////////
			    	Row row308 = sheet.getRow(331);
					Cell R308cell = row308.getCell(3);
			    	if (R308cell != null) {
			    	R308cell.setCellValue(brf181a.getR308_STANDALONE() == null ? 0 :
			    	brf181a.getR308_STANDALONE().intValue());
			    	}
			    	Cell R308cell0 = row308.getCell(4);
			    	if (R308cell0 != null) {
			    	R308cell0.setCellValue(brf181a.getR308_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR308_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -333/////////
			    	Row row309 = sheet.getRow(332);
					Cell R309cell = row309.getCell(3);
			    	if (R309cell != null) {
			    	R309cell.setCellValue(brf181a.getR309_STANDALONE() == null ? 0 :
			    	brf181a.getR309_STANDALONE().intValue());
			    	}
			    	Cell R309cell0 = row309.getCell(4);
			    	if (R309cell0 != null) {
			    	R309cell0.setCellValue(brf181a.getR309_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR309_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -334/////////
			    	Row row310 = sheet.getRow(333);
					Cell R310cell = row310.getCell(3);
			    	if (R310cell != null) {
			    	R310cell.setCellValue(brf181a.getR310_STANDALONE() == null ? 0 :
			    	brf181a.getR310_STANDALONE().intValue());
			    	}
			    	Cell R310cell0 = row310.getCell(4);
			    	if (R310cell0 != null) {
			    	R310cell0.setCellValue(brf181a.getR310_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR310_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -335/////////
			    	Row row311 = sheet.getRow(334);
					Cell R311cell = row311.getCell(3);
			    	if (R311cell != null) {
			    	R311cell.setCellValue(brf181a.getR311_STANDALONE() == null ? 0 :
			    	brf181a.getR311_STANDALONE().intValue());
			    	}
			    	Cell R311cell0 = row311.getCell(4);
			    	if (R311cell0 != null) {
			    	R311cell0.setCellValue(brf181a.getR311_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR311_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -336/////////
			    	Row row312 = sheet.getRow(335);
					Cell R312cell = row312.getCell(3);
			    	if (R312cell != null) {
			    	R312cell.setCellValue(brf181a.getR312_STANDALONE() == null ? 0 :
			    	brf181a.getR312_STANDALONE().intValue());
			    	}
			    	Cell R312cell0 = row312.getCell(4);
			    	if (R312cell0 != null) {
			    	R312cell0.setCellValue(brf181a.getR312_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR312_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -338/////////
			    	Row row313 = sheet.getRow(337);
					Cell R313cell = row313.getCell(3);
			    	if (R313cell != null) {
			    	R313cell.setCellValue(brf181a.getR313_STANDALONE() == null ? 0 :
			    	brf181a.getR313_STANDALONE().intValue());
			    	}
			    	Cell R313cell0 = row313.getCell(4);
			    	if (R313cell0 != null) {
			    	R313cell0.setCellValue(brf181a.getR313_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR313_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -339/////////
			    	Row row314 = sheet.getRow(338);
					Cell R314cell = row314.getCell(3);
			    	if (R314cell != null) {
			    	R314cell.setCellValue(brf181a.getR314_STANDALONE() == null ? 0 :
			    	brf181a.getR314_STANDALONE().intValue());
			    	}
			    	Cell R314cell0 = row314.getCell(4);
			    	if (R314cell0 != null) {
			    	R314cell0.setCellValue(brf181a.getR314_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR314_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -340/////////
			    	Row row315 = sheet.getRow(339);
					Cell R315cell = row315.getCell(3);
			    	if (R315cell != null) {
			    	R315cell.setCellValue(brf181a.getR315_STANDALONE() == null ? 0 :
			    	brf181a.getR315_STANDALONE().intValue());
			    	}
			    	Cell R315cell0 = row315.getCell(4);
			    	if (R315cell0 != null) {
			    	R315cell0.setCellValue(brf181a.getR315_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR315_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -341/////////
			    	Row row316 = sheet.getRow(340);
					Cell R316cell = row316.getCell(3);
			    	if (R316cell != null) {
			    	R316cell.setCellValue(brf181a.getR316_STANDALONE() == null ? 0 :
			    	brf181a.getR316_STANDALONE().intValue());
			    	}
			    	Cell R316cell0 = row316.getCell(4);
			    	if (R316cell0 != null) {
			    	R316cell0.setCellValue(brf181a.getR316_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR316_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -342/////////
			    	Row row317 = sheet.getRow(341);
					Cell R317cell = row317.getCell(3);
			    	if (R317cell != null) {
			    	R317cell.setCellValue(brf181a.getR317_STANDALONE() == null ? 0 :
			    	brf181a.getR317_STANDALONE().intValue());
			    	}
			    	Cell R317cell0 = row317.getCell(4);
			    	if (R317cell0 != null) {
			    	R317cell0.setCellValue(brf181a.getR317_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR317_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -343/////////
			    	Row row318 = sheet.getRow(342);
					Cell R318cell = row318.getCell(3);
			    	if (R318cell != null) {
			    	R318cell.setCellValue(brf181a.getR318_STANDALONE() == null ? 0 :
			    	brf181a.getR318_STANDALONE().intValue());
			    	}
			    	Cell R318cell0 = row318.getCell(4);
			    	if (R318cell0 != null) {
			    	R318cell0.setCellValue(brf181a.getR318_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR318_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -344/////////
			    	Row row319 = sheet.getRow(343);
					Cell R319cell = row319.getCell(3);
			    	if (R319cell != null) {
			    	R319cell.setCellValue(brf181a.getR319_STANDALONE() == null ? 0 :
			    	brf181a.getR319_STANDALONE().intValue());
			    	}
			    	Cell R319cell0 = row319.getCell(4);
			    	if (R319cell0 != null) {
			    	R319cell0.setCellValue(brf181a.getR319_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR319_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -345/////////
			    	Row row320 = sheet.getRow(344);
					Cell R320cell = row320.getCell(3);
			    	if (R320cell != null) {
			    	R320cell.setCellValue(brf181a.getR320_STANDALONE() == null ? 0 :
			    	brf181a.getR320_STANDALONE().intValue());
			    	}
			    	Cell R320cell0 = row320.getCell(4);
			    	if (R320cell0 != null) {
			    	R320cell0.setCellValue(brf181a.getR320_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR320_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -346/////////
			    	Row row321 = sheet.getRow(345);
					Cell R321cell = row321.getCell(3);
			    	if (R321cell != null) {
			    	R321cell.setCellValue(brf181a.getR321_STANDALONE() == null ? 0 :
			    	brf181a.getR321_STANDALONE().intValue());
			    	}
			    	Cell R321cell0 = row321.getCell(4);
			    	if (R321cell0 != null) {
			    	R321cell0.setCellValue(brf181a.getR321_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR321_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -348/////////
			    	Row row322 = sheet.getRow(347);
					Cell R322cell = row322.getCell(3);
			    	if (R322cell != null) {
			    	R322cell.setCellValue(brf181a.getR322_STANDALONE() == null ? 0 :
			    	brf181a.getR322_STANDALONE().intValue());
			    	}
			    	Cell R322cell0 = row322.getCell(4);
			    	if (R322cell0 != null) {
			    	R322cell0.setCellValue(brf181a.getR322_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR322_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -349/////////
			    	Row row323 = sheet.getRow(348);
					Cell R323cell = row323.getCell(3);
			    	if (R323cell != null) {
			    	R323cell.setCellValue(brf181a.getR323_STANDALONE() == null ? 0 :
			    	brf181a.getR323_STANDALONE().intValue());
			    	}
			    	Cell R323cell0 = row323.getCell(4);
			    	if (R323cell0 != null) {
			    	R323cell0.setCellValue(brf181a.getR323_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR323_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -350/////////
			    	Row row324 = sheet.getRow(349);
					Cell R324cell = row324.getCell(3);
			    	if (R324cell != null) {
			    	R324cell.setCellValue(brf181a.getR324_STANDALONE() == null ? 0 :
			    	brf181a.getR324_STANDALONE().intValue());
			    	}
			    	Cell R324cell0 = row324.getCell(4);
			    	if (R324cell0 != null) {
			    	R324cell0.setCellValue(brf181a.getR324_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR324_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -351/////////
			    	Row row325 = sheet.getRow(350);
					Cell R325cell = row325.getCell(3);
			    	if (R325cell != null) {
			    	R325cell.setCellValue(brf181a.getR325_STANDALONE() == null ? 0 :
			    	brf181a.getR325_STANDALONE().intValue());
			    	}
			    	Cell R325cell0 = row325.getCell(4);
			    	if (R325cell0 != null) {
			    	R325cell0.setCellValue(brf181a.getR325_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR325_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -352/////////
			    	Row row326 = sheet.getRow(351);
					Cell R326cell = row326.getCell(3);
			    	if (R326cell != null) {
			    	R326cell.setCellValue(brf181a.getR326_STANDALONE() == null ? 0 :
			    	brf181a.getR326_STANDALONE().intValue());
			    	}
			    	Cell R326cell0 = row326.getCell(4);
			    	if (R326cell0 != null) {
			    	R326cell0.setCellValue(brf181a.getR326_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR326_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -353/////////
			    	Row row327 = sheet.getRow(352);
					Cell R327cell = row327.getCell(3);
			    	if (R327cell != null) {
			    	R327cell.setCellValue(brf181a.getR327_STANDALONE() == null ? 0 :
			    	brf181a.getR327_STANDALONE().intValue());
			    	}
			    	Cell R327cell0 = row327.getCell(4);
			    	if (R327cell0 != null) {
			    	R327cell0.setCellValue(brf181a.getR327_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR327_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -354/////////
			    	Row row328 = sheet.getRow(353);
					Cell R328cell = row328.getCell(3);
			    	if (R328cell != null) {
			    	R328cell.setCellValue(brf181a.getR328_STANDALONE() == null ? 0 :
			    	brf181a.getR328_STANDALONE().intValue());
			    	}
			    	Cell R328cell0 = row328.getCell(4);
			    	if (R328cell0 != null) {
			    	R328cell0.setCellValue(brf181a.getR328_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR328_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -355/////////
			    	Row row329 = sheet.getRow(354);
					Cell R329cell = row329.getCell(3);
			    	if (R329cell != null) {
			    	R329cell.setCellValue(brf181a.getR329_STANDALONE() == null ? 0 :
			    	brf181a.getR329_STANDALONE().intValue());
			    	}
			    	Cell R329cell0 = row329.getCell(4);
			    	if (R329cell0 != null) {
			    	R329cell0.setCellValue(brf181a.getR329_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR329_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -357/////////
			    	Row row330 = sheet.getRow(356);
					Cell R330cell = row330.getCell(3);
			    	if (R330cell != null) {
			    	R330cell.setCellValue(brf181a.getR330_STANDALONE() == null ? 0 :
			    	brf181a.getR330_STANDALONE().intValue());
			    	}
			    	Cell R330cell0 = row330.getCell(4);
			    	if (R330cell0 != null) {
			    	R330cell0.setCellValue(brf181a.getR330_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR330_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -358/////////
			    	Row row331 = sheet.getRow(357);
					Cell R331cell = row331.getCell(3);
			    	if (R331cell != null) {
			    	R331cell.setCellValue(brf181a.getR331_STANDALONE() == null ? 0 :
			    	brf181a.getR331_STANDALONE().intValue());
			    	}
			    	Cell R331cell0 = row331.getCell(4);
			    	if (R331cell0 != null) {
			    	R331cell0.setCellValue(brf181a.getR331_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR331_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -359/////////
			    	Row row332 = sheet.getRow(358);
					Cell R332cell = row332.getCell(3);
			    	if (R332cell != null) {
			    	R332cell.setCellValue(brf181a.getR332_STANDALONE() == null ? 0 :
			    	brf181a.getR332_STANDALONE().intValue());
			    	}
			    	Cell R332cell0 = row332.getCell(4);
			    	if (R332cell0 != null) {
			    	R332cell0.setCellValue(brf181a.getR332_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR332_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -360/////////
			    	Row row333 = sheet.getRow(359);
					Cell R333cell = row333.getCell(3);
			    	if (R333cell != null) {
			    	R333cell.setCellValue(brf181a.getR333_STANDALONE() == null ? 0 :
			    	brf181a.getR333_STANDALONE().intValue());
			    	}
			    	Cell R333cell0 = row333.getCell(4);
			    	if (R333cell0 != null) {
			    	R333cell0.setCellValue(brf181a.getR333_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR333_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -361/////////
			    	Row row334 = sheet.getRow(360);
					Cell R334cell = row334.getCell(3);
			    	if (R334cell != null) {
			    	R334cell.setCellValue(brf181a.getR334_STANDALONE() == null ? 0 :
			    	brf181a.getR334_STANDALONE().intValue());
			    	}
			    	Cell R334cell0 = row334.getCell(4);
			    	if (R334cell0 != null) {
			    	R334cell0.setCellValue(brf181a.getR334_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR334_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -362/////////
			    	Row row335 = sheet.getRow(361);
					Cell R335cell = row335.getCell(3);
			    	if (R335cell != null) {
			    	R335cell.setCellValue(brf181a.getR335_STANDALONE() == null ? 0 :
			    	brf181a.getR335_STANDALONE().intValue());
			    	}
			    	Cell R335cell0 = row335.getCell(4);
			    	if (R335cell0 != null) {
			    	R335cell0.setCellValue(brf181a.getR335_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR335_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -363/////////
			    	Row row336 = sheet.getRow(362);
					Cell R336cell = row336.getCell(3);
			    	if (R336cell != null) {
			    	R336cell.setCellValue(brf181a.getR336_STANDALONE() == null ? 0 :
			    	brf181a.getR336_STANDALONE().intValue());
			    	}
			    	Cell R336cell0 = row336.getCell(4);
			    	if (R336cell0 != null) {
			    	R336cell0.setCellValue(brf181a.getR336_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR336_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -364/////////
			    	Row row337 = sheet.getRow(363);
					Cell R337cell = row337.getCell(3);
			    	if (R337cell != null) {
			    	R337cell.setCellValue(brf181a.getR337_STANDALONE() == null ? 0 :
			    	brf181a.getR337_STANDALONE().intValue());
			    	}
			    	Cell R337cell0 = row337.getCell(4);
			    	if (R337cell0 != null) {
			    	R337cell0.setCellValue(brf181a.getR337_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR337_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -365/////////
			    	Row row338 = sheet.getRow(364);
					Cell R338cell = row338.getCell(3);
			    	if (R338cell != null) {
			    	R338cell.setCellValue(brf181a.getR338_STANDALONE() == null ? 0 :
			    	brf181a.getR338_STANDALONE().intValue());
			    	}
			    	Cell R338cell0 = row338.getCell(4);
			    	if (R338cell0 != null) {
			    	R338cell0.setCellValue(brf181a.getR338_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR338_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -366/////////
			    	Row row339 = sheet.getRow(365);
					Cell R339cell = row339.getCell(3);
			    	if (R339cell != null) {
			    	R339cell.setCellValue(brf181a.getR339_STANDALONE() == null ? 0 :
			    	brf181a.getR339_STANDALONE().intValue());
			    	}
			    	Cell R339cell0 = row339.getCell(4);
			    	if (R339cell0 != null) {
			    	R339cell0.setCellValue(brf181a.getR339_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR339_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -367/////////
			    	Row row340 = sheet.getRow(366);
					Cell R340cell = row340.getCell(3);
			    	if (R340cell != null) {
			    	R340cell.setCellValue(brf181a.getR340_STANDALONE() == null ? 0 :
			    	brf181a.getR340_STANDALONE().intValue());
			    	}
			    	Cell R340cell0 = row340.getCell(4);
			    	if (R340cell0 != null) {
			    	R340cell0.setCellValue(brf181a.getR340_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR340_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -368/////////
			    	Row row341 = sheet.getRow(367);
					Cell R341cell = row341.getCell(3);
			    	if (R341cell != null) {
			    	R341cell.setCellValue(brf181a.getR341_STANDALONE() == null ? 0 :
			    	brf181a.getR341_STANDALONE().intValue());
			    	}
			    	Cell R341cell0 = row341.getCell(4);
			    	if (R341cell0 != null) {
			    	R341cell0.setCellValue(brf181a.getR341_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR341_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -369/////////
			    	Row row342 = sheet.getRow(368);
					Cell R342cell = row342.getCell(3);
			    	if (R342cell != null) {
			    	R342cell.setCellValue(brf181a.getR342_STANDALONE() == null ? 0 :
			    	brf181a.getR342_STANDALONE().intValue());
			    	}
			    	Cell R342cell0 = row342.getCell(4);
			    	if (R342cell0 != null) {
			    	R342cell0.setCellValue(brf181a.getR342_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR342_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -370/////////
			    	Row row343 = sheet.getRow(369);
					Cell R343cell = row343.getCell(3);
			    	if (R343cell != null) {
			    	R343cell.setCellValue(brf181a.getR343_STANDALONE() == null ? 0 :
			    	brf181a.getR343_STANDALONE().intValue());
			    	}
			    	Cell R343cell0 = row343.getCell(4);
			    	if (R343cell0 != null) {
			    	R343cell0.setCellValue(brf181a.getR343_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR343_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -371/////////
			    	Row row344 = sheet.getRow(370);
					Cell R344cell = row344.getCell(3);
			    	if (R344cell != null) {
			    	R344cell.setCellValue(brf181a.getR344_STANDALONE() == null ? 0 :
			    	brf181a.getR344_STANDALONE().intValue());
			    	}
			    	Cell R344cell0 = row344.getCell(4);
			    	if (R344cell0 != null) {
			    	R344cell0.setCellValue(brf181a.getR344_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR344_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -372/////////
			    	Row row345 = sheet.getRow(371);
					Cell R345cell = row345.getCell(3);
			    	if (R345cell != null) {
			    	R345cell.setCellValue(brf181a.getR345_STANDALONE() == null ? 0 :
			    	brf181a.getR345_STANDALONE().intValue());
			    	}
			    	Cell R345cell0 = row345.getCell(4);
			    	if (R345cell0 != null) {
			    	R345cell0.setCellValue(brf181a.getR345_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR345_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -373/////////
			    	Row row346 = sheet.getRow(372);
					Cell R346cell = row346.getCell(3);
			    	if (R346cell != null) {
			    	R346cell.setCellValue(brf181a.getR346_STANDALONE() == null ? 0 :
			    	brf181a.getR346_STANDALONE().intValue());
			    	}
			    	Cell R346cell0 = row346.getCell(4);
			    	if (R346cell0 != null) {
			    	R346cell0.setCellValue(brf181a.getR346_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR346_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -374/////////
			    	Row row347 = sheet.getRow(373);
					Cell R347cell = row347.getCell(3);
			    	if (R347cell != null) {
			    	R347cell.setCellValue(brf181a.getR347_STANDALONE() == null ? 0 :
			    	brf181a.getR347_STANDALONE().intValue());
			    	}
			    	Cell R347cell0 = row347.getCell(4);
			    	if (R347cell0 != null) {
			    	R347cell0.setCellValue(brf181a.getR347_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR347_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -375/////////
			    	Row row348 = sheet.getRow(374);
					Cell R348cell = row348.getCell(3);
			    	if (R348cell != null) {
			    	R348cell.setCellValue(brf181a.getR348_STANDALONE() == null ? 0 :
			    	brf181a.getR348_STANDALONE().intValue());
			    	}
			    	Cell R348cell0 = row348.getCell(4);
			    	if (R348cell0 != null) {
			    	R348cell0.setCellValue(brf181a.getR348_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR348_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -376/////////
			    	Row row349 = sheet.getRow(375);
					Cell R349cell = row349.getCell(3);
			    	if (R349cell != null) {
			    	R349cell.setCellValue(brf181a.getR349_STANDALONE() == null ? 0 :
			    	brf181a.getR349_STANDALONE().intValue());
			    	}
			    	Cell R349cell0 = row349.getCell(4);
			    	if (R349cell0 != null) {
			    	R349cell0.setCellValue(brf181a.getR349_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR349_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -377/////////
			    	Row row350 = sheet.getRow(376);
					Cell R350cell = row350.getCell(3);
			    	if (R350cell != null) {
			    	R350cell.setCellValue(brf181a.getR350_STANDALONE() == null ? 0 :
			    	brf181a.getR350_STANDALONE().intValue());
			    	}
			    	Cell R350cell0 = row350.getCell(4);
			    	if (R350cell0 != null) {
			    	R350cell0.setCellValue(brf181a.getR350_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR350_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -378/////////
			    	Row row351 = sheet.getRow(377);
					Cell R351cell = row351.getCell(3);
			    	if (R351cell != null) {
			    	R351cell.setCellValue(brf181a.getR351_STANDALONE() == null ? 0 :
			    	brf181a.getR351_STANDALONE().intValue());
			    	}
			    	Cell R351cell0 = row351.getCell(4);
			    	if (R351cell0 != null) {
			    	R351cell0.setCellValue(brf181a.getR351_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR351_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -379/////////
			    	Row row352 = sheet.getRow(378);
					Cell R352cell = row352.getCell(3);
			    	if (R352cell != null) {
			    	R352cell.setCellValue(brf181a.getR352_STANDALONE() == null ? 0 :
			    	brf181a.getR352_STANDALONE().intValue());
			    	}
			    	Cell R352cell0 = row352.getCell(4);
			    	if (R352cell0 != null) {
			    	R352cell0.setCellValue(brf181a.getR352_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR352_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -380/////////
			    	Row row353 = sheet.getRow(379);
					Cell R353cell = row353.getCell(3);
			    	if (R353cell != null) {
			    	R353cell.setCellValue(brf181a.getR353_STANDALONE() == null ? 0 :
			    	brf181a.getR353_STANDALONE().intValue());
			    	}
			    	Cell R353cell0 = row353.getCell(4);
			    	if (R353cell0 != null) {
			    	R353cell0.setCellValue(brf181a.getR353_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR353_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -381/////////
			    	Row row354 = sheet.getRow(380);
					Cell R354cell = row354.getCell(3);
			    	if (R354cell != null) {
			    	R354cell.setCellValue(brf181a.getR354_STANDALONE() == null ? 0 :
			    	brf181a.getR354_STANDALONE().intValue());
			    	}
			    	Cell R354cell0 = row354.getCell(4);
			    	if (R354cell0 != null) {
			    	R354cell0.setCellValue(brf181a.getR354_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR354_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -382/////////
			    	Row row355 = sheet.getRow(381);
					Cell R355cell = row355.getCell(3);
			    	if (R355cell != null) {
			    	R355cell.setCellValue(brf181a.getR355_STANDALONE() == null ? 0 :
			    	brf181a.getR355_STANDALONE().intValue());
			    	}
			    	Cell R355cell0 = row355.getCell(4);
			    	if (R355cell0 != null) {
			    	R355cell0.setCellValue(brf181a.getR355_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR355_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -383/////////
			    	Row row356 = sheet.getRow(382);
					Cell R356cell = row356.getCell(3);
			    	if (R356cell != null) {
			    	R356cell.setCellValue(brf181a.getR356_STANDALONE() == null ? 0 :
			    	brf181a.getR356_STANDALONE().intValue());
			    	}
			    	Cell R356cell0 = row356.getCell(4);
			    	if (R356cell0 != null) {
			    	R356cell0.setCellValue(brf181a.getR356_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR356_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -384/////////
			    	Row row357 = sheet.getRow(383);
					Cell R357cell = row357.getCell(3);
			    	if (R357cell != null) {
			    	R357cell.setCellValue(brf181a.getR357_STANDALONE() == null ? 0 :
			    	brf181a.getR357_STANDALONE().intValue());
			    	}
			    	Cell R357cell0 = row357.getCell(4);
			    	if (R357cell0 != null) {
			    	R357cell0.setCellValue(brf181a.getR357_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR357_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -385/////////
			    	Row row358 = sheet.getRow(384);
					Cell R358cell = row358.getCell(3);
			    	if (R358cell != null) {
			    	R358cell.setCellValue(brf181a.getR358_STANDALONE() == null ? 0 :
			    	brf181a.getR358_STANDALONE().intValue());
			    	}
			    	Cell R358cell0 = row358.getCell(4);
			    	if (R358cell0 != null) {
			    	R358cell0.setCellValue(brf181a.getR358_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR358_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -386/////////
			    	Row row359 = sheet.getRow(385);
					Cell R359cell = row359.getCell(3);
			    	if (R359cell != null) {
			    	R359cell.setCellValue(brf181a.getR359_STANDALONE() == null ? 0 :
			    	brf181a.getR359_STANDALONE().intValue());
			    	}
			    	Cell R359cell0 = row359.getCell(4);
			    	if (R359cell0 != null) {
			    	R359cell0.setCellValue(brf181a.getR359_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR359_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -387/////////
			    	Row row360 = sheet.getRow(386);
					Cell R360cell = row360.getCell(3);
			    	if (R360cell != null) {
			    	R360cell.setCellValue(brf181a.getR360_STANDALONE() == null ? 0 :
			    	brf181a.getR360_STANDALONE().intValue());
			    	}
			    	Cell R360cell0 = row360.getCell(4);
			    	if (R360cell0 != null) {
			    	R360cell0.setCellValue(brf181a.getR360_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR360_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -388/////////
			    	Row row361 = sheet.getRow(387);
					Cell R361cell = row361.getCell(3);
			    	if (R361cell != null) {
			    	R361cell.setCellValue(brf181a.getR361_STANDALONE() == null ? 0 :
			    	brf181a.getR361_STANDALONE().intValue());
			    	}
			    	Cell R361cell0 = row361.getCell(4);
			    	if (R361cell0 != null) {
			    	R361cell0.setCellValue(brf181a.getR361_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR361_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -389/////////
			    	Row row362 = sheet.getRow(388);
					Cell R362cell = row362.getCell(3);
			    	if (R362cell != null) {
			    	R362cell.setCellValue(brf181a.getR362_STANDALONE() == null ? 0 :
			    	brf181a.getR362_STANDALONE().intValue());
			    	}
			    	Cell R362cell0 = row362.getCell(4);
			    	if (R362cell0 != null) {
			    	R362cell0.setCellValue(brf181a.getR362_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR362_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -390/////////
			    	Row row363 = sheet.getRow(389);
					Cell R363cell = row363.getCell(3);
			    	if (R363cell != null) {
			    	R363cell.setCellValue(brf181a.getR363_STANDALONE() == null ? 0 :
			    	brf181a.getR363_STANDALONE().intValue());
			    	}
			    	Cell R363cell0 = row363.getCell(4);
			    	if (R363cell0 != null) {
			    	R363cell0.setCellValue(brf181a.getR363_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR363_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -391/////////
			    	Row row364 = sheet.getRow(390);
					Cell R364cell = row364.getCell(3);
			    	if (R364cell != null) {
			    	R364cell.setCellValue(brf181a.getR364_STANDALONE() == null ? 0 :
			    	brf181a.getR364_STANDALONE().intValue());
			    	}
			    	Cell R364cell0 = row364.getCell(4);
			    	if (R364cell0 != null) {
			    	R364cell0.setCellValue(brf181a.getR364_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR364_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -392/////////
			    	Row row365 = sheet.getRow(391);
					Cell R365cell = row365.getCell(3);
			    	if (R365cell != null) {
			    	R365cell.setCellValue(brf181a.getR365_STANDALONE() == null ? 0 :
			    	brf181a.getR365_STANDALONE().intValue());
			    	}
			    	Cell R365cell0 = row365.getCell(4);
			    	if (R365cell0 != null) {
			    	R365cell0.setCellValue(brf181a.getR365_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR365_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -393/////////
			    	Row row366 = sheet.getRow(392);
					Cell R366cell = row366.getCell(3);
			    	if (R366cell != null) {
			    	R366cell.setCellValue(brf181a.getR366_STANDALONE() == null ? 0 :
			    	brf181a.getR366_STANDALONE().intValue());
			    	}
			    	Cell R366cell0 = row366.getCell(4);
			    	if (R366cell0 != null) {
			    	R366cell0.setCellValue(brf181a.getR366_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR366_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -394/////////
			    	Row row367 = sheet.getRow(393);
					Cell R367cell = row367.getCell(3);
			    	if (R367cell != null) {
			    	R367cell.setCellValue(brf181a.getR367_STANDALONE() == null ? 0 :
			    	brf181a.getR367_STANDALONE().intValue());
			    	}
			    	Cell R367cell0 = row367.getCell(4);
			    	if (R367cell0 != null) {
			    	R367cell0.setCellValue(brf181a.getR367_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR367_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -395/////////
			    	Row row368 = sheet.getRow(394);
					Cell R368cell = row368.getCell(3);
			    	if (R368cell != null) {
			    	R368cell.setCellValue(brf181a.getR368_STANDALONE() == null ? 0 :
			    	brf181a.getR368_STANDALONE().intValue());
			    	}
			    	Cell R368cell0 = row368.getCell(4);
			    	if (R368cell0 != null) {
			    	R368cell0.setCellValue(brf181a.getR368_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR368_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -396/////////
			    	Row row369 = sheet.getRow(395);
					Cell R369cell = row369.getCell(3);
			    	if (R369cell != null) {
			    	R369cell.setCellValue(brf181a.getR369_STANDALONE() == null ? 0 :
			    	brf181a.getR369_STANDALONE().intValue());
			    	}
			    	Cell R369cell0 = row369.getCell(4);
			    	if (R369cell0 != null) {
			    	R369cell0.setCellValue(brf181a.getR369_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR369_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -397/////////
			    	Row row370 = sheet.getRow(396);
					Cell R370cell = row370.getCell(3);
			    	if (R370cell != null) {
			    	R370cell.setCellValue(brf181a.getR370_STANDALONE() == null ? 0 :
			    	brf181a.getR370_STANDALONE().intValue());
			    	}
			    	Cell R370cell0 = row370.getCell(4);
			    	if (R370cell0 != null) {
			    	R370cell0.setCellValue(brf181a.getR370_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR370_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -398/////////
			    	Row row371 = sheet.getRow(397);
					Cell R371cell = row371.getCell(3);
			    	if (R371cell != null) {
			    	R371cell.setCellValue(brf181a.getR371_STANDALONE() == null ? 0 :
			    	brf181a.getR371_STANDALONE().intValue());
			    	}
			    	Cell R371cell0 = row371.getCell(4);
			    	if (R371cell0 != null) {
			    	R371cell0.setCellValue(brf181a.getR371_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR371_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -399/////////
			    	Row row372 = sheet.getRow(398);
					Cell R372cell = row372.getCell(3);
			    	if (R372cell != null) {
			    	R372cell.setCellValue(brf181a.getR372_STANDALONE() == null ? 0 :
			    	brf181a.getR372_STANDALONE().intValue());
			    	}
			    	Cell R372cell0 = row372.getCell(4);
			    	if (R372cell0 != null) {
			    	R372cell0.setCellValue(brf181a.getR372_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR372_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -400/////////
			    	Row row373 = sheet.getRow(399);
					Cell R373cell = row373.getCell(3);
			    	if (R373cell != null) {
			    	R373cell.setCellValue(brf181a.getR373_STANDALONE() == null ? 0 :
			    	brf181a.getR373_STANDALONE().intValue());
			    	}
			    	Cell R373cell0 = row373.getCell(4);
			    	if (R373cell0 != null) {
			    	R373cell0.setCellValue(brf181a.getR373_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR373_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -401/////////
			    	Row row374 = sheet.getRow(400);
					Cell R374cell = row374.getCell(3);
			    	if (R374cell != null) {
			    	R374cell.setCellValue(brf181a.getR374_STANDALONE() == null ? 0 :
			    	brf181a.getR374_STANDALONE().intValue());
			    	}
			    	Cell R374cell0 = row374.getCell(4);
			    	if (R374cell0 != null) {
			    	R374cell0.setCellValue(brf181a.getR374_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR374_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -402/////////
			    	Row row375 = sheet.getRow(401);
					Cell R375cell = row375.getCell(3);
			    	if (R375cell != null) {
			    	R375cell.setCellValue(brf181a.getR375_STANDALONE() == null ? 0 :
			    	brf181a.getR375_STANDALONE().intValue());
			    	}
			    	Cell R375cell0 = row375.getCell(4);
			    	if (R375cell0 != null) {
			    	R375cell0.setCellValue(brf181a.getR375_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR375_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -403/////////
			    	Row row376 = sheet.getRow(402);
					Cell R376cell = row376.getCell(3);
			    	if (R376cell != null) {
			    	R376cell.setCellValue(brf181a.getR376_STANDALONE() == null ? 0 :
			    	brf181a.getR376_STANDALONE().intValue());
			    	}
			    	Cell R376cell0 = row376.getCell(4);
			    	if (R376cell0 != null) {
			    	R376cell0.setCellValue(brf181a.getR376_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR376_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -404/////////
			    	Row row377 = sheet.getRow(403);
					Cell R377cell = row377.getCell(3);
			    	if (R377cell != null) {
			    	R377cell.setCellValue(brf181a.getR377_STANDALONE() == null ? 0 :
			    	brf181a.getR377_STANDALONE().intValue());
			    	}
			    	Cell R377cell0 = row377.getCell(4);
			    	if (R377cell0 != null) {
			    	R377cell0.setCellValue(brf181a.getR377_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR377_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -405/////////
			    	Row row378 = sheet.getRow(404);
					Cell R378cell = row378.getCell(3);
			    	if (R378cell != null) {
			    	R378cell.setCellValue(brf181a.getR378_STANDALONE() == null ? 0 :
			    	brf181a.getR378_STANDALONE().intValue());
			    	}
			    	Cell R378cell0 = row378.getCell(4);
			    	if (R378cell0 != null) {
			    	R378cell0.setCellValue(brf181a.getR378_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR378_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -406/////////
			    	Row row379 = sheet.getRow(405);
					Cell R379cell = row379.getCell(3);
			    	if (R379cell != null) {
			    	R379cell.setCellValue(brf181a.getR379_STANDALONE() == null ? 0 :
			    	brf181a.getR379_STANDALONE().intValue());
			    	}
			    	Cell R379cell0 = row379.getCell(4);
			    	if (R379cell0 != null) {
			    	R379cell0.setCellValue(brf181a.getR379_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR379_CONSOLIDATED().intValue());
			    	}
					
			    /////srl_no -408/////////
			    	Row row380 = sheet.getRow(407);
					Cell R380cell = row380.getCell(3);
			    	if (R380cell != null) {
			    	R380cell.setCellValue(brf181a.getR380_STANDALONE() == null ? 0 :
			    	brf181a.getR380_STANDALONE().intValue());
			    	}
			    	Cell R380cell0 = row380.getCell(4);
			    	if (R380cell0 != null) {
			    	R380cell0.setCellValue(brf181a.getR380_CONSOLIDATED() == null ? 0 :
			    	brf181a.getR380_CONSOLIDATED().intValue());
			    	}
						
					}
				}
				FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-181-A.xls");
	            workbook.write(fileOut);
	            fileOut.close();
	            System.out.println(fileOut);
	            path= fileOut.toString();
	            // Close the workbook
	            System.out.println("PATH : "+path);
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
				
				

				
			}////else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-181-A.xls");

		return outputFile;
	
	
	
	}
	
	
	
	public ModelAndView getArchieveBRF181View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {


		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_181_A1_REPORT_ENTITY> T1rep = new ArrayList<BRF_181_A1_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_181_A1_REPORT_ENTITY> T1Master = new ArrayList<BRF_181_A1_REPORT_ENTITY>();
		List<BRF_181_A2_REPORT_ENTITY> T1Master1 = new ArrayList<BRF_181_A2_REPORT_ENTITY>();
		
		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF_181_A1_REPORT_ENTITY a where a.report_date = ?1 ",BRF_181_A1_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF_181_A2_REPORT_ENTITY a where a.report_date = ?1 ", BRF_181_A2_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
		
		} catch (ParseException e)
		{			
			e.printStackTrace();
			}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF181ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
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

	public ModelAndView ARCHgetBRF181currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF181_ARCHIVETABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF181_ARCHIVETABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF181_ARCHIVETABLE  where report_date = ?1");
		}

		List<BRF181_ARCHIVEENTITY> T1Master = new ArrayList<BRF181_ARCHIVEENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF181_ARCHIVEENTITY a where a.report_date = ?1", BRF181_ARCHIVEENTITY.class)
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
			String entity_flg = (String) a[40];
			String modify_flg = (String) a[41];
			String del_flg = (String) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String)a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			String nreflag = (String) a[49];
			
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

			BRF181_ARCHIVEENTITY py = new BRF181_ARCHIVEENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nreflag);
			T1Dt1.add(py);

		};

		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());
		mv.setViewName("RR" + "/" + "BRF181ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
	public String detailChanges181(BRF181_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF181_DETAIL_ENTITY> Brf181detail = bRF181DETAIL_Repo.findById(foracid);

			if (Brf181detail.isPresent()) {
				BRF181_DETAIL_ENTITY BRFdetail = Brf181detail.get();

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
					bRF181DETAIL_Repo.save(BRFdetail);

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
	public String modifyRecord181(Date asondate,BRF_181_A2_REPORT_ENTITY BRF_181_A2_REPORT_ENTITY,String userId) {
		String msg = "";
		BRF_181_A2_REPORT_ENTITY up = brf181bServiceRepo.getBRF181Report(asondate);
		if(Objects.nonNull(up)) {
			up = BRF_181_A2_REPORT_ENTITY;
			up.setDel_flg("N");
			up.setEntity_flg("Y");
			up.setModify_flg("Y");
			up.setModify_user(userId);
			up.setReport_date(asondate);
			up.setReport_to_date(asondate);
			brf181bServiceRepo.save(up);
			msg = "Updated Successfully";
		}else {
			msg = "Data Not Found";
		}
		return msg;
	}
	
	
	public String verifyBRF181Report(Date asondate, String userId) {
		String msg = "";
		BRF_181_A2_REPORT_ENTITY up = brf181bServiceRepo.getBRF181Report(asondate);
		if (Objects.nonNull(up)) {
			up.setModify_flg("N");
			up.setVerify_time(new Date());
			up.setVerify_user(userId);
			up.setVerify_user(userId);
			up.setVerify_time(asondate);
			brf181bServiceRepo.save(up);
			msg = "Verified Successfully";
		} else {
			msg = "Data Not Found";
		}
		return msg;
	}



		
			}
		

			
		

	
	
	


