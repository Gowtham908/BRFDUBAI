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

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.BRF70_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS. BRF70_ENTITY ;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.BRF070AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF70_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF70_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF70_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


@Service
@Transactional
@ConfigurationProperties("output")
public class BRF70AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF70AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired 
	Environment env;
	
	@Autowired
	BRF70_DetailRepo brf70_Detailrepo;
	@Autowired
	BRF070AServiceRepo BRF070AServiceRepo;
	
	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;
	
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF070A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF70_ENTITY  a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from  BRF70_ENTITY  a").getSingleResult();
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


	public ModelAndView getBRF070AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List< BRF70_ENTITY > T1rep = new ArrayList< BRF70_ENTITY >();
			// Query<Object[]> qr;

			List< BRF70_ENTITY > T1Master = new ArrayList< BRF70_ENTITY >();
			//List<BRF207A_A2_RPT> T1Master1 = new ArrayList<BRF207A_A2_RPT>();

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF70_ENTITY  a where a.report_date = ?1 ",  BRF70_ENTITY .class)
						.setParameter(1, df.parse(todate)).getResultList();
/*
				T1Master1 = hs.createQuery("from BRF207A_A2_RPT a where a.report_date = ?1 ", BRF207A_A2_RPT.class)
						.setParameter(1, df.parse(todate)).getResultList();
*/
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF70A");
			// mv.addObject("currlist", refCodeConfig.currList());
			mv.addObject("reportsummary", T1Master);
			//mv.addObject("reportsummary1", T1Master1);
			mv.addObject("reportmaster", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
			mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
			mv.addObject("menu", reportId);
			System.out.println("scv" + mv.getViewName());

			return mv;

		}
	
	public ModelAndView getBRF070AcurrentDtl(String reportId, String fromdate, String todate, String currency,
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
                qr = hs.createNativeQuery("select * from BRF70_DETAILTABLE");
                //qr.setParameter(2, filter);
            } else {
                qr = hs.createNativeQuery("select * from BRF70_DETAILTABLE");
            }
        } else {
            qr = hs.createNativeQuery("select * from BRF70_DETAILTABLE  where report_date = ?1");
        }
        List<BRF70_DETAIL_ENTITY> T1Master = new ArrayList<BRF70_DETAIL_ENTITY>();
 
        try {
            T1Master = hs.createQuery("from BRF70_DETAIL_ENTITY a where a.report_date = ?1", BRF70_DETAIL_ENTITY.class)
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
			

			BRF70_DETAIL_ENTITY py = new BRF70_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc,
                    acct_name, acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc,
                    country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid,
                    segment, sub_segment, sector, sub_sector, sector_code,
                    group_id, constitution_code, country, legal_entity_type,
                    constitution_desc, purpose_of_advn, hni_networth, turnover, bacid,
                    report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
                    report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
                    verify_user, verify_time, entity_flg, modify_flg, del_flg,
                    nre_status, report_date, maturity_date, gender, version, remarks);



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

		mv.setViewName("RR"+"/"+"BRF70A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	public File getFileBRF070A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName =  "011-BRF-070-A";
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
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF070_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF070_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF70.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF70.jrxml");
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
			}else {
				
				List<BRF70_ENTITY> T1Master = new ArrayList<BRF70_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF70_ENTITY a where a.report_date = ?1 ", BRF70_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF70_ENTITY BRF70 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-070-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(8);
	           
	        Cell cell0 = row.getCell(3);
	         if (cell0 != null) {
	   		 String value = (BRF70.getR1_COL_1() == null) ? "0" : 
	   			             BRF70.getR1_COL_1().toString();
	   		 cell0.setCellValue(value);
	   		 }
	         
	         Cell cell1 = row.getCell(4);
	         if (cell1 != null) {
	   		 String value = (BRF70.getR1_COL_2() == null) ? "0" : 
	   			             BRF70.getR1_COL_2().toString();
	   		 cell1.setCellValue(value);
	   		 }
	         
	         Cell cell2 = row.getCell(5);
	         if (cell2 != null) {
	   		 String value = (BRF70.getR1_COL_3() == null) ? "0" : 
	   			             BRF70.getR1_COL_3().toString();
	   		 cell2.setCellValue(value);
	   		 }
	         
	         Cell cell3 = row.getCell(6);
	         if (cell3 != null) {
	   		 String value = (BRF70.getR1_COL_4() == null) ? "0" : 
	   			             BRF70.getR1_COL_4().toString();
	   		 cell3.setCellValue(value);
	   		 }
	         
	         Cell cell4 = row.getCell(9);
	         if (cell4 != null) {
	   		 String value = (BRF70.getR1_COL_7() == null) ? "0" : 
	   			             BRF70.getR1_COL_7().toString();
	   		 cell4.setCellValue(value);
	   		 }
	         
	         Cell cell5 = row.getCell(10);
	         if (cell5 != null) {
	   		 String value = (BRF70.getR1_COL_8() == null) ? "0" : 
	   			             BRF70.getR1_COL_8().toString();
	   		 cell5.setCellValue(value);
	   		 }
	         
	         Cell cell6 = row.getCell(13);
	         if (cell6 != null) {
	   		 String value = (BRF70.getR1_COL_11() == null) ? "0" : 
	   			             BRF70.getR1_COL_11().toString();
	   		 cell6.setCellValue(value);
	   		 }
	         
	         Cell cell7 = row.getCell(14);
	         if (cell7 != null) {
	   		 String value = (BRF70.getR1_COL_12() == null) ? "0" : 
	   			             BRF70.getR1_COL_12().toString();
	   		 cell7.setCellValue(value);
	   		 }
	         
	         Cell cell8 = row.getCell(15);
	         if (cell8 != null) {
	   		 String value = (BRF70.getR1_COL_13() == null) ? "0" : 
	   			             BRF70.getR1_COL_13().toString();
	   		 cell8.setCellValue(value);
	   		 }
	         
	         Cell cell9 = row.getCell(16);
	         if (cell9 != null) {
	   		 String value = (BRF70.getR1_COL_14() == null) ? "0" : 
	   			             BRF70.getR1_COL_14().toString();
	   		 cell9.setCellValue(value);
	   		 }
	         
	         
////////////////R2////////////////////////////


	         Row R2row = sheet.getRow(9);
	           
	         Cell R2cell0 = R2row.getCell(3);
	         if (R2cell0 != null) {
	   		 String value = (BRF70.getR2_COL_1() == null) ? "0" : 
	   			             BRF70.getR2_COL_1().toString();
	   		 R2cell0.setCellValue(value);
	   		 }
	         
	         Cell R2cell1 = R2row.getCell(4);
	         if (R2cell1 != null) {
	   		 String value = (BRF70.getR2_COL_2() == null) ? "0" : 
	   			             BRF70.getR2_COL_2().toString();
	   		 R2cell1.setCellValue(value);
	   		 }
	         
	         Cell R2cell2 = R2row.getCell(5);
	         if (R2cell2 != null) {
	   		 String value = (BRF70.getR2_COL_3() == null) ? "0" : 
	   			             BRF70.getR2_COL_3().toString();
	   		 R2cell2.setCellValue(value);
	   		 }
	         
	         Cell R2cell3 = R2row.getCell(6);
	         if (R2cell3 != null) {
	   		 String value = (BRF70.getR2_COL_4() == null) ? "0" : 
	   			             BRF70.getR2_COL_4().toString();
	   		 R2cell3.setCellValue(value);
	   		 }
	         
	         Cell R2cell4 = R2row.getCell(9);
	         if (R2cell4 != null) {
	   		 String value = (BRF70.getR2_COL_7() == null) ? "0" : 
	   			             BRF70.getR2_COL_7().toString();
	   		 R2cell4.setCellValue(value);
	   		 }
	         
	         Cell R2cell5 = R2row.getCell(10);
	         if (R2cell5 != null) {
	   		 String value = (BRF70.getR2_COL_8() == null) ? "0" : 
	   			             BRF70.getR2_COL_8().toString();
	   		 R2cell5.setCellValue(value);
	   		 }
	         
	         Cell R2cell6 = R2row.getCell(13);
	         if (R2cell6 != null) {
	   		 String value = (BRF70.getR2_COL_11() == null) ? "0" : 
	   			             BRF70.getR2_COL_11().toString();
	   		 R2cell6.setCellValue(value);
	   		 }
	         
	         Cell R2cell7 = R2row.getCell(14);
	         if (R2cell7 != null) {
	   		 String value = (BRF70.getR2_COL_12() == null) ? "0" : 
	   			             BRF70.getR2_COL_12().toString();
	   		 R2cell7.setCellValue(value);
	   		 }
	         
	         Cell R2cell8 = R2row.getCell(15);
	         if (R2cell8 != null) {
	   		 String value = (BRF70.getR2_COL_13() == null) ? "0" : 
	   			             BRF70.getR2_COL_13().toString();
	   		 R2cell8.setCellValue(value);
	   		 }
	         
	         Cell R2cell9 = R2row.getCell(16);
	         if (R2cell9 != null) {
	   		 String value = (BRF70.getR2_COL_14() == null) ? "0" : 
	   			             BRF70.getR2_COL_14().toString();
	   		 R2cell9.setCellValue(value);
	   		 }
	         
	         
////////////////R3////////////////////////////


	         Row R3row = sheet.getRow(10);
	           
	         Cell R3cell0 = R3row.getCell(3);
	         if (R3cell0 != null) {
	   		 String value = (BRF70.getR3_COL_1() == null) ? "0" : 
	   			             BRF70.getR3_COL_1().toString();
	   		 R3cell0.setCellValue(value);
	   		 }
	         
	         Cell R3cell1 = R3row.getCell(4);
	         if (R3cell1 != null) {
	   		 String value = (BRF70.getR3_COL_2() == null) ? "0" : 
	   			             BRF70.getR3_COL_2().toString();
	   		 R3cell1.setCellValue(value);
	   		 }
	         
	         Cell R3cell2 = R3row.getCell(5);
	         if (R3cell2 != null) {
	   		 String value = (BRF70.getR3_COL_3() == null) ? "0" : 
	   			             BRF70.getR3_COL_3().toString();
	   		 R3cell2.setCellValue(value);
	   		 }
	         
	         Cell R3cell3 = R3row.getCell(6);
	         if (R3cell3 != null) {
	   		 String value = (BRF70.getR3_COL_4() == null) ? "0" : 
	   			             BRF70.getR3_COL_4().toString();
	   		 R3cell3.setCellValue(value);
	   		 }
	         
	         Cell R3cell4 = R3row.getCell(9);
	         if (R3cell4 != null) {
	   		 String value = (BRF70.getR3_COL_7() == null) ? "0" : 
	   			             BRF70.getR3_COL_7().toString();
	   		 R3cell4.setCellValue(value);
	   		 }
	         
	         Cell R3cell5 = R3row.getCell(10);
	         if (R3cell5 != null) {
	   		 String value = (BRF70.getR3_COL_8() == null) ? "0" : 
	   			             BRF70.getR3_COL_8().toString();
	   		 R3cell5.setCellValue(value);
	   		 }
	         
	         Cell R3cell6 = R3row.getCell(13);
	         if (R3cell6 != null) {
	   		 String value = (BRF70.getR3_COL_11() == null) ? "0" : 
	   			             BRF70.getR3_COL_11().toString();
	   		 R3cell6.setCellValue(value);
	   		 }
	         
	         Cell R3cell7 = R3row.getCell(14);
	         if (R3cell7 != null) {
	   		 String value = (BRF70.getR3_COL_12() == null) ? "0" : 
	   			             BRF70.getR3_COL_12().toString();
	   		 R3cell7.setCellValue(value);
	   		 }
	         
	         Cell R3cell8 = R3row.getCell(15);
	         if (R3cell8 != null) {
	   		 String value = (BRF70.getR3_COL_13() == null) ? "0" : 
	   			             BRF70.getR3_COL_13().toString();
	   		 R3cell8.setCellValue(value);
	   		 }
	         
	         Cell R3cell9 = R3row.getCell(16);
	         if (R3cell9 != null) {
	   		 String value = (BRF70.getR3_COL_14() == null) ? "0" : 
	   			             BRF70.getR3_COL_14().toString();
	   		 R3cell9.setCellValue(value);
	   		 }
	         
////////////////R4////////////////////////////


	         Row R4row = sheet.getRow(11);
	           
	         Cell R4cell0 = R4row.getCell(3);
	         if (R4cell0 != null) {
	   		 String value = (BRF70.getR4_COL_1() == null) ? "0" : 
	   			             BRF70.getR4_COL_1().toString();
	   		 R4cell0.setCellValue(value);
	   		 }
	         
	         Cell R4cell1 = R4row.getCell(4);
	         if (R4cell1 != null) {
	   		 String value = (BRF70.getR4_COL_2() == null) ? "0" : 
	   			             BRF70.getR4_COL_2().toString();
	   		 R4cell1.setCellValue(value);
	   		 }
	         
	         Cell R4cell2 = R4row.getCell(5);
	         if (R4cell2 != null) {
	   		 String value = (BRF70.getR4_COL_3() == null) ? "0" : 
	   			             BRF70.getR4_COL_3().toString();
	   		 R4cell2.setCellValue(value);
	   		 }
	         
	         Cell R4cell3 = R4row.getCell(6);
	         if (R4cell3 != null) {
	   		 String value = (BRF70.getR4_COL_4() == null) ? "0" : 
	   			             BRF70.getR4_COL_4().toString();
	   		 R4cell3.setCellValue(value);
	   		 }
	         
	         Cell R4cell4 = R4row.getCell(9);
	         if (R4cell4 != null) {
	   		 String value = (BRF70.getR4_COL_7() == null) ? "0" : 
	   			             BRF70.getR4_COL_7().toString();
	   		 R4cell4.setCellValue(value);
	   		 }
	         
	         Cell R4cell5 = R4row.getCell(10);
	         if (R4cell5 != null) {
	   		 String value = (BRF70.getR4_COL_8() == null) ? "0" : 
	   			             BRF70.getR4_COL_8().toString();
	   		 R4cell5.setCellValue(value);
	   		 }
	         
	         Cell R4cell6 = R4row.getCell(13);
	         if (R4cell6 != null) {
	   		 String value = (BRF70.getR4_COL_11() == null) ? "0" : 
	   			             BRF70.getR4_COL_11().toString();
	   		 R4cell6.setCellValue(value);
	   		 }
	         
	         Cell R4cell7 = R4row.getCell(14);
	         if (R4cell7 != null) {
	   		 String value = (BRF70.getR4_COL_12() == null) ? "0" : 
	   			             BRF70.getR4_COL_12().toString();
	   		 R4cell7.setCellValue(value);
	   		 }
	         
	         Cell R4cell8 = R4row.getCell(15);
	         if (R4cell8 != null) {
	   		 String value = (BRF70.getR4_COL_13() == null) ? "0" : 
	   			             BRF70.getR4_COL_13().toString();
	   		 R4cell8.setCellValue(value);
	   		 }
	         
	         Cell R4cell9 = R4row.getCell(16);
	         if (R4cell9 != null) {
	   		 String value = (BRF70.getR4_COL_14() == null) ? "0" : 
	   			             BRF70.getR4_COL_14().toString();
	   		 R4cell9.setCellValue(value);
	   		 }
	         
////////////////R5////////////////////////////


	         Row R5row = sheet.getRow(12);
	           
	         Cell R5cell0 = R5row.getCell(3);
	         if (R5cell0 != null) {
	   		 String value = (BRF70.getR5_COL_1() == null) ? "0" : 
	   			             BRF70.getR5_COL_1().toString();
	   		 R5cell0.setCellValue(value);
	   		 }
	         
	         Cell R5cell1 = R5row.getCell(4);
	         if (R5cell1 != null) {
	   		 String value = (BRF70.getR5_COL_2() == null) ? "0" : 
	   			             BRF70.getR5_COL_2().toString();
	   		 R5cell1.setCellValue(value);
	   		 }
	         
	         Cell R5cell2 = R5row.getCell(5);
	         if (R5cell2 != null) {
	   		 String value = (BRF70.getR5_COL_3() == null) ? "0" : 
	   			             BRF70.getR5_COL_3().toString();
	   		 R5cell2.setCellValue(value);
	   		 }
	         
	         Cell R5cell3 = R5row.getCell(6);
	         if (R5cell3 != null) {
	   		 String value = (BRF70.getR5_COL_4() == null) ? "0" : 
	   			             BRF70.getR5_COL_4().toString();
	   		 R5cell3.setCellValue(value);
	   		 }
	         
	         Cell R5cell4 = R5row.getCell(9);
	         if (R5cell4 != null) {
	   		 String value = (BRF70.getR5_COL_7() == null) ? "0" : 
	   			             BRF70.getR5_COL_7().toString();
	   		 R5cell4.setCellValue(value);
	   		 }
	         
	         Cell R5cell5 = R5row.getCell(10);
	         if (R5cell5 != null) {
	   		 String value = (BRF70.getR5_COL_8() == null) ? "0" : 
	   			             BRF70.getR5_COL_8().toString();
	   		 R5cell5.setCellValue(value);
	   		 }
	         
	         Cell R5cell6 = R5row.getCell(13);
	         if (R5cell6 != null) {
	   		 String value = (BRF70.getR5_COL_11() == null) ? "0" : 
	   			             BRF70.getR5_COL_11().toString();
	   		 R5cell6.setCellValue(value);
	   		 }
	         
	         Cell R5cell7 = R5row.getCell(14);
	         if (R5cell7 != null) {
	   		 String value = (BRF70.getR5_COL_12() == null) ? "0" : 
	   			             BRF70.getR5_COL_12().toString();
	   		 R5cell7.setCellValue(value);
	   		 }
	         
	         Cell R5cell8 = R5row.getCell(15);
	         if (R5cell8 != null) {
	   		 String value = (BRF70.getR5_COL_13() == null) ? "0" : 
	   			             BRF70.getR5_COL_13().toString();
	   		 R5cell8.setCellValue(value);
	   		 }
	         
	         Cell R5cell9 = R5row.getCell(16);
	         if (R5cell9 != null) {
	   		 String value = (BRF70.getR5_COL_14() == null) ? "0" : 
	   			             BRF70.getR5_COL_14().toString();
	   		 R5cell9.setCellValue(value);
	   		 }
	         
////////////////R6////////////////////////////


	         Row R6row = sheet.getRow(13);
	           
	         Cell R6cell0 = R6row.getCell(3);
	         if (R6cell0 != null) {
	   		 String value = (BRF70.getR6_COL_1() == null) ? "0" : 
	   			             BRF70.getR6_COL_1().toString();
	   		 R6cell0.setCellValue(value);
	   		 }
	         
	         Cell R6cell1 = R6row.getCell(4);
	         if (R6cell1 != null) {
	   		 String value = (BRF70.getR6_COL_2() == null) ? "0" : 
	   			             BRF70.getR6_COL_2().toString();
	   		 R6cell1.setCellValue(value);
	   		 }
	         
	         Cell R6cell2 = R6row.getCell(5);
	         if (R6cell2 != null) {
	   		 String value = (BRF70.getR6_COL_3() == null) ? "0" : 
	   			             BRF70.getR6_COL_3().toString();
	   		 R6cell2.setCellValue(value);
	   		 }
	         
	         Cell R6cell3 = R6row.getCell(6);
	         if (R6cell3 != null) {
	   		 String value = (BRF70.getR6_COL_4() == null) ? "0" : 
	   			             BRF70.getR6_COL_4().toString();
	   		 R6cell3.setCellValue(value);
	   		 }
	         
	         Cell R6cell4 = R6row.getCell(9);
	         if (R6cell4 != null) {
	   		 String value = (BRF70.getR6_COL_7() == null) ? "0" : 
	   			             BRF70.getR6_COL_7().toString();
	   		 R6cell4.setCellValue(value);
	   		 }
	         
	         Cell R6cell5 = R6row.getCell(10);
	         if (R6cell5 != null) {
	   		 String value = (BRF70.getR6_COL_8() == null) ? "0" : 
	   			             BRF70.getR6_COL_8().toString();
	   		 R6cell5.setCellValue(value);
	   		 }
	         
	         Cell R6cell6 = R6row.getCell(13);
	         if (R6cell6 != null) {
	   		 String value = (BRF70.getR6_COL_11() == null) ? "0" : 
	   			             BRF70.getR6_COL_11().toString();
	   		 R6cell6.setCellValue(value);
	   		 }
	         
	         Cell R6cell7 = R6row.getCell(14);
	         if (R6cell7 != null) {
	   		 String value = (BRF70.getR6_COL_12() == null) ? "0" : 
	   			             BRF70.getR6_COL_12().toString();
	   		 R6cell7.setCellValue(value);
	   		 }
	         
	         Cell R6cell8 = R6row.getCell(15);
	         if (R6cell8 != null) {
	   		 String value = (BRF70.getR6_COL_13() == null) ? "0" : 
	   			             BRF70.getR6_COL_13().toString();
	   		 R6cell8.setCellValue(value);
	   		 }
	         
	         Cell R6cell9 = R6row.getCell(16);
	         if (R6cell9 != null) {
	   		 String value = (BRF70.getR6_COL_14() == null) ? "0" : 
	   			             BRF70.getR6_COL_14().toString();
	   		 R6cell9.setCellValue(value);
	   		 }
	         
////////////////R8////////////////////////////


	         Row R8row = sheet.getRow(15);
	           
	         Cell R8cell0 = R8row.getCell(3);
	         if (R8cell0 != null) {
	   		 String value = (BRF70.getR8_COL_1() == null) ? "0" : 
	   			             BRF70.getR8_COL_1().toString();
	   		 R8cell0.setCellValue(value);
	   		 }
	         
	         Cell R8cell1 = R8row.getCell(4);
	         if (R8cell1 != null) {
	   		 String value = (BRF70.getR8_COL_2() == null) ? "0" : 
	   			             BRF70.getR8_COL_2().toString();
	   		 R8cell1.setCellValue(value);
	   		 }
	         
	         Cell R8cell2 = R8row.getCell(5);
	         if (R8cell2 != null) {
	   		 String value = (BRF70.getR8_COL_3() == null) ? "0" : 
	   			             BRF70.getR8_COL_3().toString();
	   		 R8cell2.setCellValue(value);
	   		 }
	         
	         Cell R8cell3 = R8row.getCell(6);
	         if (R8cell3 != null) {
	   		 String value = (BRF70.getR8_COL_4() == null) ? "0" : 
	   			             BRF70.getR8_COL_4().toString();
	   		 R8cell3.setCellValue(value);
	   		 }
	         
////////////////R9////////////////////////////


	         Row R9row = sheet.getRow(16);
	           
	         Cell R9cell0 = R9row.getCell(3);
	         if (R9cell0 != null) {
	   		 String value = (BRF70.getR9_COL_1() == null) ? "0" : 
	   			             BRF70.getR9_COL_1().toString();
	   		 R9cell0.setCellValue(value);
	   		 }
	         
	         Cell R9cell1 = R9row.getCell(4);
	         if (R9cell1 != null) {
	   		 String value = (BRF70.getR9_COL_2() == null) ? "0" : 
	   			             BRF70.getR9_COL_2().toString();
	   		 R9cell1.setCellValue(value);
	   		 }
	         
	         Cell R9cell2 = R9row.getCell(5);
	         if (R9cell2 != null) {
	   		 String value = (BRF70.getR9_COL_3() == null) ? "0" : 
	   			             BRF70.getR9_COL_3().toString();
	   		 R9cell2.setCellValue(value);
	   		 }
	         
	         Cell R9cell3 = R9row.getCell(6);
	         if (R9cell3 != null) {
	   		 String value = (BRF70.getR9_COL_4() == null) ? "0" : 
	   			             BRF70.getR9_COL_4().toString();
	   		 R9cell3.setCellValue(value);
	   		 }
	         
////////////////R10////////////////////////////


	         Row R10row = sheet.getRow(17);
	           
	         Cell R10cell0 = R10row.getCell(3);
	         if (R10cell0 != null) {
	   		 String value = (BRF70.getR10_COL_1() == null) ? "0" : 
	   			             BRF70.getR10_COL_1().toString();
	   		 R10cell0.setCellValue(value);
	   		 }
	         
	         Cell R10cell1 = R10row.getCell(4);
	         if (R10cell1 != null) {
	   		 String value = (BRF70.getR10_COL_2() == null) ? "0" : 
	   			             BRF70.getR10_COL_2().toString();
	   		 R10cell1.setCellValue(value);
	   		 }
	         
	         Cell R10cell2 = R10row.getCell(5);
	         if (R10cell2 != null) {
	   		 String value = (BRF70.getR10_COL_3() == null) ? "0" : 
	   			             BRF70.getR10_COL_3().toString();
	   		 R10cell2.setCellValue(value);
	   		 }
	         
	         Cell R10cell3 = R10row.getCell(6);
	         if (R10cell3 != null) {
	   		 String value = (BRF70.getR10_COL_4() == null) ? "0" : 
	   			             BRF70.getR10_COL_4().toString();
	   		 R10cell3.setCellValue(value);
	   		 }
	         
////////////////R11////////////////////////////


	         Row R11row = sheet.getRow(18);
	           
	         Cell R11cell0 = R11row.getCell(3);
	         if (R11cell0 != null) {
	   		 String value = (BRF70.getR11_COL_1() == null) ? "0" : 
	   			             BRF70.getR11_COL_1().toString();
	   		 R11cell0.setCellValue(value);
	   		 }
	         
	         Cell R11cell1 = R11row.getCell(4);
	         if (R11cell1 != null) {
	   		 String value = (BRF70.getR11_COL_2() == null) ? "0" : 
	   			             BRF70.getR11_COL_2().toString();
	   		 R11cell1.setCellValue(value);
	   		 }
	         
	         Cell R11cell2 = R11row.getCell(5);
	         if (R11cell2 != null) {
	   		 String value = (BRF70.getR11_COL_3() == null) ? "0" : 
	   			             BRF70.getR11_COL_3().toString();
	   		 R11cell2.setCellValue(value);
	   		 }
	         
	         Cell R11cell3 = R11row.getCell(6);
	         if (R11cell3 != null) {
	   		 String value = (BRF70.getR11_COL_4() == null) ? "0" : 
	   			             BRF70.getR11_COL_4().toString();
	   		 R11cell3.setCellValue(value);
	   		 }
	         
	        
////////////////R12////////////////////////////


	         Row R12row = sheet.getRow(19);
	           
	         Cell R12cell0 = R12row.getCell(3);
	         if (R12cell0 != null) {
	   		 String value = (BRF70.getR12_COL_1() == null) ? "0" : 
	   			             BRF70.getR12_COL_1().toString();
	   		 R12cell0.setCellValue(value);
	   		 }
	         
	         Cell R12cell1 = R12row.getCell(4);
	         if (R12cell1 != null) {
	   		 String value = (BRF70.getR12_COL_2() == null) ? "0" : 
	   			             BRF70.getR12_COL_2().toString();
	   		 R12cell1.setCellValue(value);
	   		 }
	         
	         Cell R12cell2 = R12row.getCell(5);
	         if (R12cell2 != null) {
	   		 String value = (BRF70.getR12_COL_3() == null) ? "0" : 
	   			             BRF70.getR12_COL_3().toString();
	   		 R12cell2.setCellValue(value);
	   		 }
	         
	         Cell R12cell3 = R12row.getCell(6);
	         if (R12cell3 != null) {
	   		 String value = (BRF70.getR12_COL_4() == null) ? "0" : 
	   			             BRF70.getR12_COL_4().toString();
	   		 R12cell3.setCellValue(value);
	   		 }
	         
////////////////R13////////////////////////////


	         Row R13row = sheet.getRow(20);
	           
	         Cell R13cell0 = R13row.getCell(3);
	         if (R13cell0 != null) {
	   		 String value = (BRF70.getR13_COL_1() == null) ? "0" : 
	   			             BRF70.getR13_COL_1().toString();
	   		 R13cell0.setCellValue(value);
	   		 }
	         
	         Cell R13cell1 = R13row.getCell(4);
	         if (R13cell1 != null) {
	   		 String value = (BRF70.getR13_COL_2() == null) ? "0" : 
	   			             BRF70.getR13_COL_2().toString();
	   		 R13cell1.setCellValue(value);
	   		 }
	         
	         Cell R13cell2 = R13row.getCell(5);
	         if (R13cell2 != null) {
	   		 String value = (BRF70.getR13_COL_3() == null) ? "0" : 
	   			             BRF70.getR13_COL_3().toString();
	   		 R13cell2.setCellValue(value);
	   		 }
	         
	         Cell R13cell3 = R13row.getCell(6);
	         if (R13cell3 != null) {
	   		 String value = (BRF70.getR13_COL_4() == null) ? "0" : 
	   			             BRF70.getR13_COL_4().toString();
	   		 R13cell3.setCellValue(value);
	   		 }
	         
////////////////R14////////////////////////////


	         Row R14row = sheet.getRow(21);
	           
	         Cell R14cell0 = R14row.getCell(3);
	         if (R14cell0 != null) {
	   		 String value = (BRF70.getR14_COL_1() == null) ? "0" : 
	   			             BRF70.getR14_COL_1().toString();
	   		 R14cell0.setCellValue(value);
	   		 }
	         
	         Cell R14cell1 = R14row.getCell(4);
	         if (R14cell1 != null) {
	   		 String value = (BRF70.getR14_COL_2() == null) ? "0" : 
	   			             BRF70.getR14_COL_2().toString();
	   		 R14cell1.setCellValue(value);
	   		 }
	         
	         Cell R14cell2 = R14row.getCell(5);
	         if (R14cell2 != null) {
	   		 String value = (BRF70.getR14_COL_3() == null) ? "0" : 
	   			             BRF70.getR14_COL_3().toString();
	   		 R14cell2.setCellValue(value);
	   		 }
	         
	         Cell R14cell3 = R14row.getCell(6);
	         if (R14cell3 != null) {
	   		 String value = (BRF70.getR14_COL_4() == null) ? "0" : 
	   			             BRF70.getR14_COL_4().toString();
	   		 R14cell3.setCellValue(value);
	   		 }
	         
	        
	         
			 
	         // Save the changes
	            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-070-A.xls");
	            workbook.write(fileOut);
	            fileOut.close();
	            System.out.println(fileOut);
	            path= fileOut.toString();
	            // Close the workbook
	            System.out.println("PATH : "+path);
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
				
				

				
			}////else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-070-A.xls");

		return outputFile;
	
	
	
	}
	       	 

	public String detailChanges070(BRF70_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF70_DETAIL_ENTITY> Brf70detail = brf70_Detailrepo.findById(foracid);

			if (Brf70detail.isPresent()) {
				BRF70_DETAIL_ENTITY BRFdetail = Brf70detail.get();

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
					brf70_Detailrepo.save(BRFdetail);

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



	/**** ARCH SUMMARY
	 * @throws ParseException ****/

	public ModelAndView getArchieveBRF070View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List< BRF70_ENTITY > T1rep = new ArrayList< BRF70_ENTITY >();
	// Query<Object[]> qr;

	List< BRF70_ENTITY > T1Master = new ArrayList< BRF70_ENTITY >();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from   BRF70_ENTITY  a where a.report_date = ?1 ",  BRF70_ENTITY .class)
				.setParameter(1, df.parse(todate)).getResultList();

		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF70ARCH");
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


	/**** ARCH DETAILS 
	* @throws ParseException ****/

	public ModelAndView ARCHgetBRF070currentDtl(String reportId, String fromdate, String todate, String currency,
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
			System.out.println("Filter - "+filter);
			
			
				qr = hs.createNativeQuery("select * from BRF70_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF70_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF70_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF70_ARCHIV_ENTITY> T1Master = new ArrayList<BRF70_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF70_ARCHIV_ENTITY a where a.report_date = ?1", BRF70_ARCHIV_ENTITY.class)
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
		

		BRF70_ARCHIV_ENTITY py = new BRF70_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc,
                acct_name, acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc,
                country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid,
                segment, sub_segment, sector, sub_sector, sector_code,
                group_id, constitution_code, country, legal_entity_type,
                constitution_desc, purpose_of_advn, hni_networth, turnover, bacid,
                report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
                report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
                verify_user, verify_time, entity_flg, modify_flg, del_flg,
                nre_status, report_date, maturity_date, gender, version, remarks);



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

	mv.setViewName("RR" + "/" + "BRF70ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
	}
	public String verifyBRF70Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";
		BRF70_ENTITY up = BRF070AServiceRepo.getBRF070AReport(asondate);
		if (Objects.nonNull(up)) {
			up.setModify_flg("N");
			up.setVerify_time(new Date());
			up.setVerify_user(userId);
			up.setVerify_user(userId);
			up.setVerify_time(asondate);
			BRF070AServiceRepo.save(up);
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
		audit.setAudit_table("BRF70_SUMMARYTABLE");
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