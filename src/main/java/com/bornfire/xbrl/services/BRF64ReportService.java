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

import com.bornfire.xbrl.entities.BRF64_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
 import com.bornfire.xbrl.entities.BRBS.BRF64_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF64_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF064ServiceRepo;
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
public class BRF64ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF64ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;

	@Autowired 
	 BRF64_DetailRepo brf64_detailrepo;
	@Autowired
	BRF064ServiceRepo BRF064ServiceRepo;
	
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
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF64_Entity a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF64_Entity a").getSingleResult();
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
	
	public ModelAndView getBRF064View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF64_Entity> T1rep = new ArrayList<BRF64_Entity>();
			// Query<Object[]> qr;

			List<BRF64_Entity> T1Master = new ArrayList<BRF64_Entity>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			

				T1Master = hs.createQuery("from  BRF64_Entity a where a.report_date = ?1 ", BRF64_Entity .class)
						.setParameter(1, df.parse(todate)).getResultList();

			
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF64");
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
	
	public ModelAndView getBRF064currentDtl(String reportId, String fromdate, String todate, String currency,
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
                qr = hs.createNativeQuery("select * from BRF64_DETAILTABLE");
                //qr.setParameter(2, filter);
            } else {
                qr = hs.createNativeQuery("select * from BRF64_DETAILTABLE");
            }
        } else {
            qr = hs.createNativeQuery("select * from BRF64_DETAILTABLE  where report_date = ?1");
        }
        List<BRF64_DETAIL_ENTITY> T1Master = new ArrayList<BRF64_DETAIL_ENTITY>();
 
        try {
            T1Master = hs.createQuery("from BRF64_DETAIL_ENTITY a where a.report_date = ?1", BRF64_DETAIL_ENTITY.class)
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
			

			BRF64_DETAIL_ENTITY py = new BRF64_DETAIL_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
					gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment,
					sub_segment, sector, sub_sector,  sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn,
					hni_networth, turnover, bacid, report_name_1,report_label_1,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
					 modify_user, modify_time, verify_user, verify_time,
					entity_flg, modify_flg, del_flg, nre_status, report_date,
					maturity_date, version, remarks);


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

		mv.setViewName("RR" + "/" + "BRF64::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	public File getFileBRF064(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-064-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF64_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF64_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF64.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF64.jrxml");
					}
				}

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
			}else {
				
				List<BRF64_Entity> T1Master = new ArrayList<BRF64_Entity>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF64_Entity a where a.report_date = ?1 ", BRF64_Entity.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF64_Entity BRF64 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-064-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(8);
	           
	        Cell cell0 = row.getCell(2);
	         if (cell0 != null) {
	   		 String value = (BRF64.getR1_product() == null) ? "0" : 
	   		    	          BRF64.getR1_product().toString();
	   		 cell0.setCellValue(value);
	   		 }
	            
	       	 Cell cell = row.getCell(3);
	       	 if (cell != null) {
	            cell.setCellValue(BRF64.getR1_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR1_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell cell1 = row.getCell(4);
	       	 if (cell1 != null) {
	            cell1.setCellValue(BRF64.getR1_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR1_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell cell2 = row.getCell(5);
	       	 if (cell2 != null) {
	            cell2.setCellValue(BRF64.getR1_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR1_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell cell3 = row.getCell(6);
	       	 if (cell3 != null) {
	            cell3.setCellValue(BRF64.getR1_unfundedos() == null ? 0 :
	       	     	BRF64.getR1_unfundedos().intValue());
	       	 }
	       	 
	       	 /////////////////////R2/////////////////////////
		     	
	       	 Row R2row = sheet.getRow(9);
	       	 
	       	Cell R2cell0 = R2row.getCell(2);
	         if (R2cell0 != null) {
	   		 String value = (BRF64.getR2_product() == null) ? "0" : 
	   		    	         BRF64.getR2_product().toString();
	   		 R2cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R2cell = R2row.getCell(3);
	       	 if (R2cell != null) {
	       	    R2cell.setCellValue(BRF64.getR2_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR2_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R2cell1 = R2row.getCell(4);
	       	 if (R2cell1 != null) {
	       	    R2cell1.setCellValue(BRF64.getR2_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR2_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R2cell2 = R2row.getCell(5);
	       	 if (R2cell2 != null) {
	       	    R2cell2.setCellValue(BRF64.getR2_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR2_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R2cell3 = R2row.getCell(6);
	       	 if (R2cell3 != null) {
	       	    R2cell3.setCellValue(BRF64.getR2_unfundedos() == null ? 0 :
	       	     	BRF64.getR2_unfundedos().intValue());
	       	 }
	       				 
	       		
	         /////////////////////R3/////////////////////////
	     	
	       	 Row R3row = sheet.getRow(10);
	       	Cell R3cell0 = R3row.getCell(2);
	         if (R3cell0 != null) {
	   		 String value = (BRF64.getR3_product() == null) ? "0" : 
	   		    	         BRF64.getR3_product().toString();
	   		 R3cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R3cell = R3row.getCell(3);
	       	 if (R3cell != null) {
	       	    R3cell.setCellValue(BRF64.getR3_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR3_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R3cell1 = R3row.getCell(4);
	       	 if (R3cell1 != null) {
	       	    R3cell1.setCellValue(BRF64.getR3_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR3_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R3cell2 = R3row.getCell(5);
	       	 if (R3cell2 != null) {
	       	    R3cell2.setCellValue(BRF64.getR3_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR3_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R3cell3 = R3row.getCell(6);
	       	 if (R3cell3 != null) {
	       	    R3cell3.setCellValue(BRF64.getR3_unfundedos() == null ? 0 :
	       	     	BRF64.getR3_unfundedos().intValue());
	       	 }
	       				 
	       		
	        
	       	 /////////////////////R4/////////////////////////
		     	
	       	 Row R4row = sheet.getRow(11);
	       	 
	       	Cell R4cell0 = R4row.getCell(2);
	         if (R4cell0 != null) {
	   		 String value = (BRF64.getR4_product() == null) ? "0" : 
	   		    	         BRF64.getR4_product().toString();
	   		 R4cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R4cell = R4row.getCell(3);
	       	 if (R4cell != null) {
	       	    R4cell.setCellValue(BRF64.getR4_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR4_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R4cell1 = R4row.getCell(4);
	       	 if (R4cell1 != null) {
	       	    R4cell1.setCellValue(BRF64.getR4_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR4_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R4cell2 = R4row.getCell(5);
	       	 if (R4cell2 != null) {
	       	    R4cell2.setCellValue(BRF64.getR4_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR4_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R4cell3 = R4row.getCell(6);
	       	 if (R4cell3 != null) {
	       	    R4cell3.setCellValue(BRF64.getR4_unfundedos() == null ? 0 :
	       	     	BRF64.getR4_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R5/////////////////////////
		     	
	       	 Row R5row = sheet.getRow(12);
	       	 
	       	Cell R5cell0 =R5row.getCell(2);
	         if (R5cell0 != null) {
	   		 String value = (BRF64.getR5_product() == null) ? "0" : 
	   		    	         BRF64.getR5_product().toString();
	   		 R5cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R5cell = R5row.getCell(3);
	       	 if (R5cell != null) {
	       	    R5cell.setCellValue(BRF64.getR5_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR5_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R5cell1 = R5row.getCell(4);
	       	 if (R5cell1 != null) {
	       	    R5cell1.setCellValue(BRF64.getR5_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR5_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R5cell2 = R5row.getCell(5);
	       	 if (R5cell2 != null) {
	       	    R5cell2.setCellValue(BRF64.getR5_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR5_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R5cell3 = R5row.getCell(6);
	       	 if (R5cell3 != null) {
	       	    R5cell3.setCellValue(BRF64.getR5_unfundedos() == null ? 0 :
	       	     	BRF64.getR5_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R6/////////////////////////
		     	
	       	 Row R6row = sheet.getRow(13);
	       	 
	       	Cell R6cell0 = R6row.getCell(2);
	         if (R6cell0 != null) {
	   		 String value = (BRF64.getR6_product() == null) ? "0" : 
	   		    	         BRF64.getR6_product().toString();
	   		 R6cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R6cell = R6row.getCell(3);
	       	 if (R6cell != null) {
	       	    R6cell.setCellValue(BRF64.getR6_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR6_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R6cell1 = R6row.getCell(4);
	       	 if (R6cell1 != null) {
	       	    R6cell1.setCellValue(BRF64.getR6_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR6_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R6cell2 = R6row.getCell(5);
	       	 if (R6cell2 != null) {
	       	    R6cell2.setCellValue(BRF64.getR6_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR6_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R6cell3 = R6row.getCell(6);
	       	 if (R6cell3 != null) {
	       	    R6cell3.setCellValue(BRF64.getR6_unfundedos() == null ? 0 :
	       	     	BRF64.getR6_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R7/////////////////////////
		     	
	       	 Row R7row = sheet.getRow(14);
	       	 
	       	Cell R7cell0 = R7row.getCell(2);
	         if (R7cell0 != null) {
	   		 String value = (BRF64.getR7_product() == null) ? "0" : 
	   		    	         BRF64.getR7_product().toString();
	   		 R7cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R7cell = R7row.getCell(3);
	       	 if (R7cell != null) {
	       	    R7cell.setCellValue(BRF64.getR7_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR7_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R7cell1 = R7row.getCell(4);
	       	 if (R7cell1 != null) {
	       	    R7cell1.setCellValue(BRF64.getR7_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR7_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R7cell2 = R7row.getCell(5);
	       	 if (R7cell2 != null) {
	       	    R7cell2.setCellValue(BRF64.getR7_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR7_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R7cell3 = R7row.getCell(6);
	       	 if (R7cell3 != null) {
	       	    R7cell3.setCellValue(BRF64.getR7_unfundedos() == null ? 0 :
	       	     	BRF64.getR7_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R8/////////////////////////
		     	
	       	 Row R8row = sheet.getRow(15);
	       	 
	       	Cell R8cell0 = R8row.getCell(2);
	         if (R8cell0 != null) {
	   		 String value = (BRF64.getR8_product() == null) ? "0" : 
	   		    	         BRF64.getR8_product().toString();
	   		 R8cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R8cell = R8row.getCell(3);
	       	 if (R8cell != null) {
	       	    R8cell.setCellValue(BRF64.getR8_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR8_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R8cell1 = R8row.getCell(4);
	       	 if (R8cell1 != null) {
	       	    R8cell1.setCellValue(BRF64.getR8_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR8_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R8cell2 = R8row.getCell(5);
	       	 if (R8cell2 != null) {
	       	    R8cell2.setCellValue(BRF64.getR8_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR8_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R8cell3 = R8row.getCell(6);
	       	 if (R8cell3 != null) {
	       	    R8cell3.setCellValue(BRF64.getR8_unfundedos() == null ? 0 :
	       	     	BRF64.getR8_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R9/////////////////////////
		     	
	       	 Row R9row = sheet.getRow(16);
	       	 
	       	Cell R9cell0 = R9row.getCell(2);
	         if (R9cell0 != null) {
	   		 String value = (BRF64.getR9_product() == null) ? "0" : 
	   		    	         BRF64.getR9_product().toString();
	   		 R9cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R9cell = R9row.getCell(3);
	       	 if (R9cell != null) {
	       	    R9cell.setCellValue(BRF64.getR9_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR9_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R9cell1 = R9row.getCell(4);
	       	 if (R9cell1 != null) {
	       	    R9cell1.setCellValue(BRF64.getR9_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR9_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R9cell2 = R9row.getCell(5);
	       	 if (R9cell2 != null) {
	       	    R9cell2.setCellValue(BRF64.getR9_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR9_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R9cell3 = R9row.getCell(6);
	       	 if (R9cell3 != null) {
	       	    R9cell3.setCellValue(BRF64.getR9_unfundedos() == null ? 0 :
	       	     	BRF64.getR9_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R10/////////////////////////
		     	
	       	 Row R10row = sheet.getRow(17);
	       	 
	       	Cell R10cell0 = R10row.getCell(2);
	         if (R10cell0 != null) {
	   		 String value = (BRF64.getR10_product() == null) ? "0" : 
	   		    	         BRF64.getR10_product().toString();
	   		 R10cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R10cell = R10row.getCell(3);
	       	 if (R10cell != null) {
	       	    R10cell.setCellValue(BRF64.getR10_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR10_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R10cell1 = R10row.getCell(4);
	       	 if (R10cell1 != null) {
	       	    R10cell1.setCellValue(BRF64.getR10_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR10_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R10cell2 = R10row.getCell(5);
	       	 if (R10cell2 != null) {
	       	    R10cell2.setCellValue(BRF64.getR10_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR10_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R10cell3 = R10row.getCell(6);
	       	 if (R10cell3 != null) {
	       	    R10cell3.setCellValue(BRF64.getR10_unfundedos() == null ? 0 :
	       	     	BRF64.getR10_unfundedos().intValue());
	       	 }
	       				 
	       		
	       	 /////////////////////R11/////////////////////////
		     	
	       	 Row R11row = sheet.getRow(18);
	       	 
	       	Cell R11cell0 = R11row.getCell(2);
	         if (R11cell0 != null) {
	   		 String value = (BRF64.getR11_product() == null) ? "0" : 
	   		    	         BRF64.getR11_product().toString();
	   		 R11cell0.setCellValue(value);
	   		 }
	       	 
	       	 Cell R11cell = R11row.getCell(3);
	       	 if (R11cell != null) {
	       	    R11cell.setCellValue(BRF64.getR11_fundedos_fundedexp() == null ? 0 :
	       	     	BRF64.getR11_fundedos_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R11cell1 = R11row.getCell(4);
	       	 if (R11cell1 != null) {
	       	    R11cell1.setCellValue(BRF64.getR11_pastdue_fundedexp() == null ? 0 :
	       	     	BRF64.getR11_pastdue_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R11cell2 = R11row.getCell(5);
	       	 if (R11cell2 != null) {
	       	    R11cell2.setCellValue(BRF64.getR11_numberdayspast_fundedexp() == null ? 0 :
	       	     	BRF64.getR11_numberdayspast_fundedexp().intValue());
	       	 }
	       	 
	       	 Cell R11cell3 = R11row.getCell(6);
	       	 if (R11cell3 != null) {
	       	    R11cell3.setCellValue(BRF64.getR11_unfundedos() == null ? 0 :
	       	     	BRF64.getR11_unfundedos().intValue());
	       	 }
	       				 
	          /////////////////////R2////////////////////////	     	
		    	 Row R12row = sheet.getRow(19);
		    	 
		    	Cell R12cell0 = R12row.getCell(2);
		      if (R12cell0 != null) {
	 		 String value = (BRF64.getR12_product() == null) ? "0" : 
	 		    	         BRF64.getR12_product().toString();
	 		 R12cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R12cell = R12row.getCell(3);
		    	 if (R12cell != null) {
		    	    R12cell.setCellValue(BRF64.getR12_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR12_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R12cell1 = R12row.getCell(4);
		    	 if (R12cell1 != null) {
		    	    R12cell1.setCellValue(BRF64.getR12_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR12_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R12cell2 = R12row.getCell(5);
		    	 if (R12cell2 != null) {
		    	    R12cell2.setCellValue(BRF64.getR12_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR12_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R12cell3 = R12row.getCell(6);
		    	 if (R12cell3 != null) {
		    	    R12cell3.setCellValue(BRF64.getR12_unfundedos() == null ? 0 :
		    	     	BRF64.getR12_unfundedos().intValue());
		    	 }
	     				 
	     		
		      /////////////////////R13/////////////////////////
		  	
		    	 Row R13row = sheet.getRow(20);
		    	Cell R13cell0 = R13row.getCell(2);
		      if (R13cell0 != null) {
	 		 String value = (BRF64.getR13_product() == null) ? "0" : 
	 		    	         BRF64.getR13_product().toString();
	 		 R13cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R13cell = R13row.getCell(3);
		    	 if (R13cell != null) {
		    	    R13cell.setCellValue(BRF64.getR13_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR13_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R13cell1 = R13row.getCell(4);
		    	 if (R13cell1 != null) {
		    	    R13cell1.setCellValue(BRF64.getR13_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR13_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R13cell2 = R13row.getCell(5);
		    	 if (R13cell2 != null) {
		    	    R13cell2.setCellValue(BRF64.getR13_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR13_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R13cell3 = R13row.getCell(6);
		    	 if (R13cell3 != null) {
		    	    R13cell3.setCellValue(BRF64.getR13_unfundedos() == null ? 0 :
		    	     	BRF64.getR13_unfundedos().intValue());
		    	 }
	     				 
	     		
		     
		    	 /////////////////////R14////////////////////////	     	
		    	 Row R14row = sheet.getRow(21);
		    	 
		    	Cell R14cell0 = R14row.getCell(2);
		      if (R14cell0 != null) {
	 		 String value = (BRF64.getR14_product() == null) ? "0" : 
	 		    	         BRF64.getR14_product().toString();
	 		 R14cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R14cell = R14row.getCell(3);
		    	 if (R14cell != null) {
		    	    R14cell.setCellValue(BRF64.getR14_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR14_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R14cell1 = R14row.getCell(4);
		    	 if (R14cell1 != null) {
		    	    R14cell1.setCellValue(BRF64.getR14_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR14_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R14cell2 = R14row.getCell(5);
		    	 if (R14cell2 != null) {
		    	    R14cell2.setCellValue(BRF64.getR14_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR14_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R14cell3 = R14row.getCell(6);
		    	 if (R14cell3 != null) {
		    	    R14cell3.setCellValue(BRF64.getR14_unfundedos() == null ? 0 :
		    	     	BRF64.getR14_unfundedos().intValue());
		    	 }
	     				 
	     		
		    	 /////////////////////R15////////////////////////	     	
		    	 Row R15row = sheet.getRow(22);
		    	 
		    	Cell R15cell0 = R15row.getCell(2);
		      if (R15cell0 != null) {
	 		 String value = (BRF64.getR15_product() == null) ? "0" : 
	 		    	         BRF64.getR15_product().toString();
	 		 R15cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R15cell = R15row.getCell(3);
		    	 if (R15cell != null) {
		    	    R15cell.setCellValue(BRF64.getR15_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR15_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R15cell1 = R15row.getCell(4);
		    	 if (R15cell1 != null) {
		    	    R15cell1.setCellValue(BRF64.getR15_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR15_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R15cell2 = R15row.getCell(5);
		    	 if (R15cell2 != null) {
		    	    R15cell2.setCellValue(BRF64.getR15_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR15_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R15cell3 = R15row.getCell(6);
		    	 if (R15cell3 != null) {
		    	    R15cell3.setCellValue(BRF64.getR15_unfundedos() == null ? 0 :
		    	     	BRF64.getR15_unfundedos().intValue());
		    	 }
	     				 
	     		
		    	 /////////////////////R16////////////////////////	     	
		    	 Row R16row = sheet.getRow(23);
		    	 
		    	Cell R16cell0 = R16row.getCell(2);
		      if (R16cell0 != null) {
	 		 String value = (BRF64.getR16_product() == null) ? "0" : 
	 		    	         BRF64.getR16_product().toString();
	 		 R16cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R16cell = R16row.getCell(3);
		    	 if (R16cell != null) {
		    	    R16cell.setCellValue(BRF64.getR16_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR16_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R16cell1 = R16row.getCell(4);
		    	 if (R16cell1 != null) {
		    	    R16cell1.setCellValue(BRF64.getR16_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR16_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R16cell2 = R16row.getCell(5);
		    	 if (R16cell2 != null) {
		    	    R16cell2.setCellValue(BRF64.getR16_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR16_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R16cell3 = R16row.getCell(6);
		    	 if (R16cell3 != null) {
		    	    R16cell3.setCellValue(BRF64.getR16_unfundedos() == null ? 0 :
		    	     	BRF64.getR16_unfundedos().intValue());
		    	 }
	     				 
	     		
		    	 /////////////////////R17////////////////////////	     	
		    	 Row R17row = sheet.getRow(24);
		    	 
		    	Cell R17cell0 = R17row.getCell(2);
		      if (R17cell0 != null) {
	 		 String value = (BRF64.getR17_product() == null) ? "0" : 
	 		    	         BRF64.getR17_product().toString();
	 		 R17cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R17cell = R17row.getCell(3);
		    	 if (R17cell != null) {
		    	    R17cell.setCellValue(BRF64.getR17_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR17_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R17cell1 = R17row.getCell(4);
		    	 if (R17cell1 != null) {
		    	    R17cell1.setCellValue(BRF64.getR17_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR17_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R17cell2 = R17row.getCell(5);
		    	 if (R17cell2 != null) {
		    	    R17cell2.setCellValue(BRF64.getR17_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR17_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R17cell3 = R17row.getCell(6);
		    	 if (R17cell3 != null) {
		    	    R17cell3.setCellValue(BRF64.getR17_unfundedos() == null ? 0 :
		    	     	BRF64.getR17_unfundedos().intValue());
		    	 }
	     				 
	     		
		    	 /////////////////////R18////////////////////////	     	
		    	 Row R18row = sheet.getRow(25);
		    	 
		    	Cell R18cell0 = R18row.getCell(2);
		      if (R18cell0 != null) {
	 		 String value = (BRF64.getR18_product() == null) ? "0" : 
	 		    	         BRF64.getR18_product().toString();
	 		 R18cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R18cell = R18row.getCell(3);
		    	 if (R18cell != null) {
		    	    R18cell.setCellValue(BRF64.getR18_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR18_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R18cell1 = R18row.getCell(4);
		    	 if (R18cell1 != null) {
		    	    R18cell1.setCellValue(BRF64.getR18_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR18_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R18cell2 = R18row.getCell(5);
		    	 if (R18cell2 != null) {
		    	    R18cell2.setCellValue(BRF64.getR18_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR18_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R18cell3 = R18row.getCell(6);
		    	 if (R18cell3 != null) {
		    	    R18cell3.setCellValue(BRF64.getR18_unfundedos() == null ? 0 :
		    	     	BRF64.getR18_unfundedos().intValue());
		    	 }
	     				 
	     		
		    	 /////////////////////R19////////////////////////	     	
		    	 Row R19row = sheet.getRow(26);
		    	 
		    	Cell R19cell0 = R19row.getCell(2);
		      if (R19cell0 != null) {
	 		 String value = (BRF64.getR19_product() == null) ? "0" : 
	 		    	         BRF64.getR19_product().toString();
	 		 R19cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R19cell = R19row.getCell(3);
		    	 if (R19cell != null) {
		    	    R19cell.setCellValue(BRF64.getR19_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR19_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R19cell1 = R19row.getCell(4);
		    	 if (R19cell1 != null) {
		    	    R19cell1.setCellValue(BRF64.getR19_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR19_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R19cell2 = R19row.getCell(5);
		    	 if (R19cell2 != null) {
		    	    R19cell2.setCellValue(BRF64.getR19_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR19_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R19cell3 = R19row.getCell(6);
		    	 if (R19cell3 != null) {
		    	    R19cell3.setCellValue(BRF64.getR19_unfundedos() == null ? 0 :
		    	     	BRF64.getR19_unfundedos().intValue());
		    	 }
	     				 
	     		
		    	 /////////////////////R20////////////////////////	     	
		    	 Row R20row = sheet.getRow(27);
		    	 
		    	Cell R20cell0 = R20row.getCell(2);
		      if (R20cell0 != null) {
	 		 String value = (BRF64.getR20_product() == null) ? "0" : 
	 		    	         BRF64.getR20_product().toString();
	 		 R20cell0.setCellValue(value);
	 		 }
		    	 
		    	 Cell R20cell = R20row.getCell(3);
		    	 if (R20cell != null) {
		    	    R20cell.setCellValue(BRF64.getR20_fundedos_fundedexp() == null ? 0 :
		    	     	BRF64.getR20_fundedos_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R20cell1 = R20row.getCell(4);
		    	 if (R20cell1 != null) {
		    	    R20cell1.setCellValue(BRF64.getR20_pastdue_fundedexp() == null ? 0 :
		    	     	BRF64.getR20_pastdue_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R20cell2 = R20row.getCell(5);
		    	 if (R20cell2 != null) {
		    	    R20cell2.setCellValue(BRF64.getR20_numberdayspast_fundedexp() == null ? 0 :
		    	     	BRF64.getR20_numberdayspast_fundedexp().intValue());
		    	 }
		    	 
		    	 Cell R20cell3 = R20row.getCell(6);
		    	 if (R20cell3 != null) {
		    	    R20cell3.setCellValue(BRF64.getR20_unfundedos() == null ? 0 :
		    	     	BRF64.getR20_unfundedos().intValue());
		    	 }
	     				 
	     		
		       	 /////////////////////R21/////////////////////////
			     	
		       	 Row R21row = sheet.getRow(28);
		       	 
		       	Cell R21cell0 = R21row.getCell(2);
		         if (R21cell0 != null) {
		   		 String value = (BRF64.getR21_product() == null) ? "0" : 
		   		    	         BRF64.getR21_product().toString();
		   		 R21cell0.setCellValue(value);
		   		 }
		       	 
		       	 Cell R21cell = R21row.getCell(3);
		       	 if (R21cell != null) {
		       	    R21cell.setCellValue(BRF64.getR21_fundedos_fundedexp() == null ? 0 :
		       	     	BRF64.getR21_fundedos_fundedexp().intValue());
		       	 }
		       	 
		       	 Cell R21cell1 = R21row.getCell(4);
		       	 if (R21cell1 != null) {
		       	    R21cell1.setCellValue(BRF64.getR21_pastdue_fundedexp() == null ? 0 :
		       	     	BRF64.getR21_pastdue_fundedexp().intValue());
		       	 }
		       	 
		       	 Cell R21cell2 = R21row.getCell(5);
		       	 if (R21cell2 != null) {
		       	    R21cell2.setCellValue(BRF64.getR21_numberdayspast_fundedexp() == null ? 0 :
		       	     	BRF64.getR21_numberdayspast_fundedexp().intValue());
		       	 }
		       	 
		       	 Cell R21cell3 = R21row.getCell(6);
		       	 if (R21cell3 != null) {
		       	    R21cell3.setCellValue(BRF64.getR21_unfundedos() == null ? 0 :
		       	     	BRF64.getR21_unfundedos().intValue());
		       	 }
		       				 
		          /////////////////////R3////////////////////////	     	
			    	 Row R22row = sheet.getRow(29);
			    	 
			    	Cell R22cell0 = R22row.getCell(2);
			      if (R22cell0 != null) {
		 		 String value = (BRF64.getR22_product() == null) ? "0" : 
		 		    	         BRF64.getR22_product().toString();
		 		 R22cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R22cell = R22row.getCell(3);
			    	 if (R22cell != null) {
			    	    R22cell.setCellValue(BRF64.getR22_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR22_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R22cell1 = R22row.getCell(4);
			    	 if (R22cell1 != null) {
			    	    R22cell1.setCellValue(BRF64.getR22_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR22_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R22cell2 = R22row.getCell(5);
			    	 if (R22cell2 != null) {
			    	    R22cell2.setCellValue(BRF64.getR22_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR22_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R22cell3 = R22row.getCell(6);
			    	 if (R22cell3 != null) {
			    	    R22cell3.setCellValue(BRF64.getR22_unfundedos() == null ? 0 :
			    	     	BRF64.getR22_unfundedos().intValue());
			    	 }
		     				 
		     		
			      /////////////////////R23/////////////////////////
			  	
			    	 Row R23row = sheet.getRow(30);
			    	Cell R23cell0 = R23row.getCell(2);
			      if (R23cell0 != null) {
		 		 String value = (BRF64.getR23_product() == null) ? "0" : 
		 		    	         BRF64.getR23_product().toString();
		 		 R23cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R23cell = R23row.getCell(3);
			    	 if (R23cell != null) {
			    	    R23cell.setCellValue(BRF64.getR23_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR23_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R23cell1 = R23row.getCell(4);
			    	 if (R23cell1 != null) {
			    	    R23cell1.setCellValue(BRF64.getR23_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR23_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R23cell2 = R23row.getCell(5);
			    	 if (R23cell2 != null) {
			    	    R23cell2.setCellValue(BRF64.getR23_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR23_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R23cell3 = R23row.getCell(6);
			    	 if (R23cell3 != null) {
			    	    R23cell3.setCellValue(BRF64.getR23_unfundedos() == null ? 0 :
			    	     	BRF64.getR23_unfundedos().intValue());
			    	 }
		     				 
		     		
			     
			    	 /////////////////////R24////////////////////////	     	
			    	 Row R24row = sheet.getRow(31);
			    	 
			    	Cell R24cell0 = R24row.getCell(2);
			      if (R24cell0 != null) {
		 		 String value = (BRF64.getR24_product() == null) ? "0" : 
		 		    	         BRF64.getR24_product().toString();
		 		 R24cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R24cell = R24row.getCell(3);
			    	 if (R24cell != null) {
			    	    R24cell.setCellValue(BRF64.getR24_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR24_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R24cell1 = R24row.getCell(4);
			    	 if (R24cell1 != null) {
			    	    R24cell1.setCellValue(BRF64.getR24_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR24_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R24cell2 = R24row.getCell(5);
			    	 if (R24cell2 != null) {
			    	    R24cell2.setCellValue(BRF64.getR24_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR24_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R24cell3 = R24row.getCell(6);
			    	 if (R24cell3 != null) {
			    	    R24cell3.setCellValue(BRF64.getR24_unfundedos() == null ? 0 :
			    	     	BRF64.getR24_unfundedos().intValue());
			    	 }
		     				 
		     		
			    	 /////////////////////R25////////////////////////	     	
			    	 Row R25row = sheet.getRow(32);
			    	 
			    	Cell R25cell0 = R25row.getCell(2);
			      if (R25cell0 != null) {
		 		 String value = (BRF64.getR25_product() == null) ? "0" : 
		 		    	         BRF64.getR25_product().toString();
		 		 R25cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R25cell = R25row.getCell(3);
			    	 if (R25cell != null) {
			    	    R25cell.setCellValue(BRF64.getR25_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR25_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R25cell1 = R25row.getCell(4);
			    	 if (R25cell1 != null) {
			    	    R25cell1.setCellValue(BRF64.getR25_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR25_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R25cell2 = R25row.getCell(5);
			    	 if (R25cell2 != null) {
			    	    R25cell2.setCellValue(BRF64.getR25_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR25_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R25cell3 = R25row.getCell(6);
			    	 if (R25cell3 != null) {
			    	    R25cell3.setCellValue(BRF64.getR25_unfundedos() == null ? 0 :
			    	     	BRF64.getR25_unfundedos().intValue());
			    	 }
		     				 
		     		
			    	 /////////////////////R26////////////////////////	     	
			    	 Row R26row = sheet.getRow(33);
			    	 
			    	Cell R26cell0 = R26row.getCell(2);
			      if (R26cell0 != null) {
		 		 String value = (BRF64.getR26_product() == null) ? "0" : 
		 		    	         BRF64.getR26_product().toString();
		 		 R26cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R26cell = R26row.getCell(3);
			    	 if (R26cell != null) {
			    	    R26cell.setCellValue(BRF64.getR26_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR26_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R26cell1 = R26row.getCell(4);
			    	 if (R26cell1 != null) {
			    	    R26cell1.setCellValue(BRF64.getR26_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR26_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R26cell2 = R26row.getCell(5);
			    	 if (R26cell2 != null) {
			    	    R26cell2.setCellValue(BRF64.getR26_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR26_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R26cell3 = R26row.getCell(6);
			    	 if (R26cell3 != null) {
			    	    R26cell3.setCellValue(BRF64.getR26_unfundedos() == null ? 0 :
			    	     	BRF64.getR26_unfundedos().intValue());
			    	 }
		     				 
		     		
			    	 /////////////////////R27////////////////////////	     	
			    	 Row R27row = sheet.getRow(34);
			    	 
			    	Cell R27cell0 = R27row.getCell(2);
			      if (R27cell0 != null) {
		 		 String value = (BRF64.getR27_product() == null) ? "0" : 
		 		    	         BRF64.getR27_product().toString();
		 		 R27cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R27cell = R27row.getCell(3);
			    	 if (R27cell != null) {
			    	    R27cell.setCellValue(BRF64.getR27_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR27_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R27cell1 = R27row.getCell(4);
			    	 if (R27cell1 != null) {
			    	    R27cell1.setCellValue(BRF64.getR27_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR27_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R27cell2 = R27row.getCell(5);
			    	 if (R27cell2 != null) {
			    	    R27cell2.setCellValue(BRF64.getR27_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR27_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R27cell3 = R27row.getCell(6);
			    	 if (R27cell3 != null) {
			    	    R27cell3.setCellValue(BRF64.getR27_unfundedos() == null ? 0 :
			    	     	BRF64.getR27_unfundedos().intValue());
			    	 }
		     				 
		     		
			    	 /////////////////////R28////////////////////////	     	
			    	 Row R28row = sheet.getRow(35);
			    	 
			    	Cell R28cell0 = R28row.getCell(2);
			      if (R28cell0 != null) {
		 		 String value = (BRF64.getR28_product() == null) ? "0" : 
		 		    	         BRF64.getR28_product().toString();
		 		 R28cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R28cell = R28row.getCell(3);
			    	 if (R28cell != null) {
			    	    R28cell.setCellValue(BRF64.getR28_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR28_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R28cell1 = R28row.getCell(4);
			    	 if (R28cell1 != null) {
			    	    R28cell1.setCellValue(BRF64.getR28_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR28_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R28cell2 = R28row.getCell(5);
			    	 if (R28cell2 != null) {
			    	    R28cell2.setCellValue(BRF64.getR28_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR28_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R28cell3 = R28row.getCell(6);
			    	 if (R28cell3 != null) {
			    	    R28cell3.setCellValue(BRF64.getR28_unfundedos() == null ? 0 :
			    	     	BRF64.getR28_unfundedos().intValue());
			    	 }
		     				 
		     		
			    	 /////////////////////R29////////////////////////	     	
			    	 Row R29row = sheet.getRow(36);
			    	 
			    	Cell R29cell0 = R29row.getCell(2);
			      if (R29cell0 != null) {
		 		 String value = (BRF64.getR29_product() == null) ? "0" : 
		 		    	         BRF64.getR29_product().toString();
		 		 R29cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R29cell = R29row.getCell(3);
			    	 if (R29cell != null) {
			    	    R29cell.setCellValue(BRF64.getR29_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR29_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R29cell1 = R29row.getCell(4);
			    	 if (R29cell1 != null) {
			    	    R29cell1.setCellValue(BRF64.getR29_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR29_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R29cell2 = R29row.getCell(5);
			    	 if (R29cell2 != null) {
			    	    R29cell2.setCellValue(BRF64.getR29_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR29_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R29cell3 = R29row.getCell(6);
			    	 if (R29cell3 != null) {
			    	    R29cell3.setCellValue(BRF64.getR29_unfundedos() == null ? 0 :
			    	     	BRF64.getR29_unfundedos().intValue());
			    	 }
		     				 
		     		
			    	 /////////////////////R30////////////////////////	     	
			    	 Row R30row = sheet.getRow(37);
			    	 
			    	Cell R30cell0 = R30row.getCell(2);
			      if (R30cell0 != null) {
		 		 String value = (BRF64.getR30_product() == null) ? "0" : 
		 		    	         BRF64.getR30_product().toString();
		 		 R30cell0.setCellValue(value);
		 		 }
			    	 
			    	 Cell R30cell = R30row.getCell(3);
			    	 if (R30cell != null) {
			    	    R30cell.setCellValue(BRF64.getR30_fundedos_fundedexp() == null ? 0 :
			    	     	BRF64.getR30_fundedos_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R30cell1 = R30row.getCell(4);
			    	 if (R30cell1 != null) {
			    	    R30cell1.setCellValue(BRF64.getR30_pastdue_fundedexp() == null ? 0 :
			    	     	BRF64.getR30_pastdue_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R30cell2 = R30row.getCell(5);
			    	 if (R30cell2 != null) {
			    	    R30cell2.setCellValue(BRF64.getR30_numberdayspast_fundedexp() == null ? 0 :
			    	     	BRF64.getR30_numberdayspast_fundedexp().intValue());
			    	 }
			    	 
			    	 Cell R30cell3 = R30row.getCell(6);
			    	 if (R30cell3 != null) {
			    	    R30cell3.setCellValue(BRF64.getR30_unfundedos() == null ? 0 :
			    	     	BRF64.getR30_unfundedos().intValue());
			    	 }
		     			
			    	 
			       	 /////////////////////R31/////////////////////////
				     	
			       	 Row R31row = sheet.getRow(38);
			       	 
			       	Cell R31cell0 = R31row.getCell(2);
			         if (R31cell0 != null) {
			   		 String value = (BRF64.getR31_product() == null) ? "0" : 
			   		    	         BRF64.getR31_product().toString();
			   		 R31cell0.setCellValue(value);
			   		 }
			       	 
			       	 Cell R31cell = R31row.getCell(3);
			       	 if (R31cell != null) {
			       	    R31cell.setCellValue(BRF64.getR31_fundedos_fundedexp() == null ? 0 :
			       	     	BRF64.getR31_fundedos_fundedexp().intValue());
			       	 }
			       	 
			       	 Cell R31cell1 = R31row.getCell(4);
			       	 if (R31cell1 != null) {
			       	    R31cell1.setCellValue(BRF64.getR31_pastdue_fundedexp() == null ? 0 :
			       	     	BRF64.getR31_pastdue_fundedexp().intValue());
			       	 }
			       	 
			       	 Cell R31cell2 = R31row.getCell(5);
			       	 if (R31cell2 != null) {
			       	    R31cell2.setCellValue(BRF64.getR31_numberdayspast_fundedexp() == null ? 0 :
			       	     	BRF64.getR31_numberdayspast_fundedexp().intValue());
			       	 }
			       	 
			       	 Cell R31cell3 = R31row.getCell(6);
			       	 if (R31cell3 != null) {
			       	    R31cell3.setCellValue(BRF64.getR31_unfundedos() == null ? 0 :
			       	     	BRF64.getR31_unfundedos().intValue());
			       	 }
			       				 
			          /////////////////////R4////////////////////////	     	
				    	 Row R32row = sheet.getRow(39);
				    	 
				    	Cell R32cell0 = R32row.getCell(2);
				      if (R32cell0 != null) {
			 		 String value = (BRF64.getR32_product() == null) ? "0" : 
			 		    	         BRF64.getR32_product().toString();
			 		 R32cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R32cell = R32row.getCell(3);
				    	 if (R32cell != null) {
				    	    R32cell.setCellValue(BRF64.getR32_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR32_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R32cell1 = R32row.getCell(4);
				    	 if (R32cell1 != null) {
				    	    R32cell1.setCellValue(BRF64.getR32_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR32_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R32cell2 = R32row.getCell(5);
				    	 if (R32cell2 != null) {
				    	    R32cell2.setCellValue(BRF64.getR32_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR32_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R32cell3 = R32row.getCell(6);
				    	 if (R32cell3 != null) {
				    	    R32cell3.setCellValue(BRF64.getR32_unfundedos() == null ? 0 :
				    	     	BRF64.getR32_unfundedos().intValue());
				    	 }
			     				 
			     		
				      /////////////////////R33/////////////////////////
				  	
				    	 Row R33row = sheet.getRow(40);
				    	Cell R33cell0 = R33row.getCell(2);
				      if (R33cell0 != null) {
			 		 String value = (BRF64.getR33_product() == null) ? "0" : 
			 		    	         BRF64.getR33_product().toString();
			 		 R33cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R33cell = R33row.getCell(3);
				    	 if (R33cell != null) {
				    	    R33cell.setCellValue(BRF64.getR33_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR33_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R33cell1 = R33row.getCell(4);
				    	 if (R33cell1 != null) {
				    	    R33cell1.setCellValue(BRF64.getR33_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR33_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R33cell2 = R33row.getCell(5);
				    	 if (R33cell2 != null) {
				    	    R33cell2.setCellValue(BRF64.getR33_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR33_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R33cell3 = R33row.getCell(6);
				    	 if (R33cell3 != null) {
				    	    R33cell3.setCellValue(BRF64.getR33_unfundedos() == null ? 0 :
				    	     	BRF64.getR33_unfundedos().intValue());
				    	 }
			     				 
			     		
				     
				    	 /////////////////////R34////////////////////////	     	
				    	 Row R34row = sheet.getRow(41);
				    	 
				    	Cell R34cell0 = R34row.getCell(2);
				      if (R34cell0 != null) {
			 		 String value = (BRF64.getR34_product() == null) ? "0" : 
			 		    	         BRF64.getR34_product().toString();
			 		 R34cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R34cell = R34row.getCell(3);
				    	 if (R34cell != null) {
				    	    R34cell.setCellValue(BRF64.getR34_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR34_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R34cell1 = R34row.getCell(4);
				    	 if (R34cell1 != null) {
				    	    R34cell1.setCellValue(BRF64.getR34_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR34_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R34cell2 = R34row.getCell(5);
				    	 if (R34cell2 != null) {
				    	    R34cell2.setCellValue(BRF64.getR34_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR34_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R34cell3 = R34row.getCell(6);
				    	 if (R34cell3 != null) {
				    	    R34cell3.setCellValue(BRF64.getR34_unfundedos() == null ? 0 :
				    	     	BRF64.getR34_unfundedos().intValue());
				    	 }
			     				 
			     		
				    	 /////////////////////R35////////////////////////	     	
				    	 Row R35row = sheet.getRow(42);
				    	 
				    	Cell R35cell0 = R35row.getCell(2);
				      if (R35cell0 != null) {
			 		 String value = (BRF64.getR35_product() == null) ? "0" : 
			 		    	         BRF64.getR35_product().toString();
			 		 R35cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R35cell = R35row.getCell(3);
				    	 if (R35cell != null) {
				    	    R35cell.setCellValue(BRF64.getR35_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR35_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R35cell1 = R35row.getCell(4);
				    	 if (R35cell1 != null) {
				    	    R35cell1.setCellValue(BRF64.getR35_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR35_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R35cell2 = R35row.getCell(5);
				    	 if (R35cell2 != null) {
				    	    R35cell2.setCellValue(BRF64.getR35_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR35_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R35cell3 = R35row.getCell(6);
				    	 if (R35cell3 != null) {
				    	    R35cell3.setCellValue(BRF64.getR35_unfundedos() == null ? 0 :
				    	     	BRF64.getR35_unfundedos().intValue());
				    	 }
			     				 
			     		
				    	 /////////////////////R36////////////////////////	     	
				    	 Row R36row = sheet.getRow(43);
				    	 
				    	Cell R36cell0 = R36row.getCell(2);
				      if (R36cell0 != null) {
			 		 String value = (BRF64.getR36_product() == null) ? "0" : 
			 		    	         BRF64.getR36_product().toString();
			 		 R36cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R36cell = R36row.getCell(3);
				    	 if (R36cell != null) {
				    	    R36cell.setCellValue(BRF64.getR36_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR36_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R36cell1 = R36row.getCell(4);
				    	 if (R36cell1 != null) {
				    	    R36cell1.setCellValue(BRF64.getR36_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR36_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R36cell2 = R36row.getCell(5);
				    	 if (R36cell2 != null) {
				    	    R36cell2.setCellValue(BRF64.getR36_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR36_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R36cell3 = R36row.getCell(6);
				    	 if (R36cell3 != null) {
				    	    R36cell3.setCellValue(BRF64.getR36_unfundedos() == null ? 0 :
				    	     	BRF64.getR36_unfundedos().intValue());
				    	 }
			     				 
			     		
				    	 /////////////////////R37////////////////////////	     	
				    	 Row R37row = sheet.getRow(44);
				    	 
				    	Cell R37cell0 = R37row.getCell(2);
				      if (R37cell0 != null) {
			 		 String value = (BRF64.getR37_product() == null) ? "0" : 
			 		    	         BRF64.getR37_product().toString();
			 		 R37cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R37cell = R37row.getCell(3);
				    	 if (R37cell != null) {
				    	    R37cell.setCellValue(BRF64.getR37_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR37_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R37cell1 = R37row.getCell(4);
				    	 if (R37cell1 != null) {
				    	    R37cell1.setCellValue(BRF64.getR37_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR37_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R37cell2 = R37row.getCell(5);
				    	 if (R37cell2 != null) {
				    	    R37cell2.setCellValue(BRF64.getR37_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR37_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R37cell3 = R37row.getCell(6);
				    	 if (R37cell3 != null) {
				    	    R37cell3.setCellValue(BRF64.getR37_unfundedos() == null ? 0 :
				    	     	BRF64.getR37_unfundedos().intValue());
				    	 }
			     				 
			     		
				    	 /////////////////////R38////////////////////////	     	
				    	 Row R38row = sheet.getRow(45);
				    	 
				    	Cell R38cell0 = R38row.getCell(2);
				      if (R38cell0 != null) {
			 		 String value = (BRF64.getR38_product() == null) ? "0" : 
			 		    	         BRF64.getR38_product().toString();
			 		 R38cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R38cell = R38row.getCell(3);
				    	 if (R38cell != null) {
				    	    R38cell.setCellValue(BRF64.getR38_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR38_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R38cell1 = R38row.getCell(4);
				    	 if (R38cell1 != null) {
				    	    R38cell1.setCellValue(BRF64.getR38_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR38_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R38cell2 = R38row.getCell(5);
				    	 if (R38cell2 != null) {
				    	    R38cell2.setCellValue(BRF64.getR38_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR38_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R38cell3 = R38row.getCell(6);
				    	 if (R38cell3 != null) {
				    	    R38cell3.setCellValue(BRF64.getR38_unfundedos() == null ? 0 :
				    	     	BRF64.getR38_unfundedos().intValue());
				    	 }
			     				 
			     		
				    	 /////////////////////R39////////////////////////	     	
				    	 Row R39row = sheet.getRow(46);
				    	 
				    	Cell R39cell0 = R39row.getCell(2);
				      if (R39cell0 != null) {
			 		 String value = (BRF64.getR39_product() == null) ? "0" : 
			 		    	         BRF64.getR39_product().toString();
			 		 R39cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R39cell = R39row.getCell(3);
				    	 if (R39cell != null) {
				    	    R39cell.setCellValue(BRF64.getR39_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR39_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R39cell1 = R39row.getCell(4);
				    	 if (R39cell1 != null) {
				    	    R39cell1.setCellValue(BRF64.getR39_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR39_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R39cell2 = R39row.getCell(5);
				    	 if (R39cell2 != null) {
				    	    R39cell2.setCellValue(BRF64.getR39_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR39_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R39cell3 = R39row.getCell(6);
				    	 if (R39cell3 != null) {
				    	    R39cell3.setCellValue(BRF64.getR39_unfundedos() == null ? 0 :
				    	     	BRF64.getR39_unfundedos().intValue());
				    	 }
			     				 
			     		
				    	 /////////////////////R40////////////////////////	     	
				    	 Row R40row = sheet.getRow(47);
				    	 
				    	Cell R40cell0 = R40row.getCell(2);
				      if (R40cell0 != null) {
			 		 String value = (BRF64.getR40_product() == null) ? "0" : 
			 		    	         BRF64.getR40_product().toString();
			 		 R40cell0.setCellValue(value);
			 		 }
				    	 
				    	 Cell R40cell = R40row.getCell(3);
				    	 if (R40cell != null) {
				    	    R40cell.setCellValue(BRF64.getR40_fundedos_fundedexp() == null ? 0 :
				    	     	BRF64.getR40_fundedos_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R40cell1 = R40row.getCell(4);
				    	 if (R40cell1 != null) {
				    	    R40cell1.setCellValue(BRF64.getR40_pastdue_fundedexp() == null ? 0 :
				    	     	BRF64.getR40_pastdue_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R40cell2 = R40row.getCell(5);
				    	 if (R40cell2 != null) {
				    	    R40cell2.setCellValue(BRF64.getR40_numberdayspast_fundedexp() == null ? 0 :
				    	     	BRF64.getR40_numberdayspast_fundedexp().intValue());
				    	 }
				    	 
				    	 Cell R40cell3 = R40row.getCell(6);
				    	 if (R40cell3 != null) {
				    	    R40cell3.setCellValue(BRF64.getR40_unfundedos() == null ? 0 :
				    	     	BRF64.getR40_unfundedos().intValue());
				    	 }
			     			
				       	 /////////////////////R41/////////////////////////
					     	
				       	 Row R41row = sheet.getRow(48);
				       	 
				       	Cell R41cell0 = R41row.getCell(2);
				         if (R41cell0 != null) {
				   		 String value = (BRF64.getR41_product() == null) ? "0" : 
				   		    	         BRF64.getR41_product().toString();
				   		 R41cell0.setCellValue(value);
				   		 }
				       	 
				       	 Cell R41cell = R41row.getCell(3);
				       	 if (R41cell != null) {
				       	    R41cell.setCellValue(BRF64.getR41_fundedos_fundedexp() == null ? 0 :
				       	     	BRF64.getR41_fundedos_fundedexp().intValue());
				       	 }
				       	 
				       	 Cell R41cell1 = R41row.getCell(4);
				       	 if (R41cell1 != null) {
				       	    R41cell1.setCellValue(BRF64.getR41_pastdue_fundedexp() == null ? 0 :
				       	     	BRF64.getR41_pastdue_fundedexp().intValue());
				       	 }
				       	 
				       	 Cell R41cell2 = R41row.getCell(5);
				       	 if (R41cell2 != null) {
				       	    R41cell2.setCellValue(BRF64.getR41_numberdayspast_fundedexp() == null ? 0 :
				       	     	BRF64.getR41_numberdayspast_fundedexp().intValue());
				       	 }
				       	 
				       	 Cell R41cell3 = R41row.getCell(6);
				       	 if (R41cell3 != null) {
				       	    R41cell3.setCellValue(BRF64.getR41_unfundedos() == null ? 0 :
				       	     	BRF64.getR41_unfundedos().intValue());
				       	 }
				       				 
				          /////////////////////R5////////////////////////	     	
					    	 Row R42row = sheet.getRow(49);
					    	 
					    	Cell R42cell0 = R42row.getCell(2);
					      if (R42cell0 != null) {
				 		 String value = (BRF64.getR42_product() == null) ? "0" : 
				 		    	         BRF64.getR42_product().toString();
				 		 R42cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R42cell = R42row.getCell(3);
					    	 if (R42cell != null) {
					    	    R42cell.setCellValue(BRF64.getR42_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR42_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R42cell1 = R42row.getCell(4);
					    	 if (R42cell1 != null) {
					    	    R42cell1.setCellValue(BRF64.getR42_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR42_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R42cell2 = R42row.getCell(5);
					    	 if (R42cell2 != null) {
					    	    R42cell2.setCellValue(BRF64.getR42_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR42_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R42cell3 = R42row.getCell(6);
					    	 if (R42cell3 != null) {
					    	    R42cell3.setCellValue(BRF64.getR42_unfundedos() == null ? 0 :
					    	     	BRF64.getR42_unfundedos().intValue());
					    	 }
				     				 
				     		
					      /////////////////////R43/////////////////////////
					  	
					    	 Row R43row = sheet.getRow(50);
					    	Cell R43cell0 = R43row.getCell(2);
					      if (R43cell0 != null) {
				 		 String value = (BRF64.getR43_product() == null) ? "0" : 
				 		    	         BRF64.getR43_product().toString();
				 		 R43cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R43cell = R43row.getCell(3);
					    	 if (R43cell != null) {
					    	    R43cell.setCellValue(BRF64.getR43_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR43_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R43cell1 = R43row.getCell(4);
					    	 if (R43cell1 != null) {
					    	    R43cell1.setCellValue(BRF64.getR43_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR43_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R43cell2 = R43row.getCell(5);
					    	 if (R43cell2 != null) {
					    	    R43cell2.setCellValue(BRF64.getR43_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR43_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R43cell3 = R43row.getCell(6);
					    	 if (R43cell3 != null) {
					    	    R43cell3.setCellValue(BRF64.getR43_unfundedos() == null ? 0 :
					    	     	BRF64.getR43_unfundedos().intValue());
					    	 }
				     				 
				     		
					     
					    	 /////////////////////R44////////////////////////	     	
					    	 Row R44row = sheet.getRow(51);
					    	 
					    	Cell R44cell0 = R44row.getCell(2);
					      if (R44cell0 != null) {
				 		 String value = (BRF64.getR44_product() == null) ? "0" : 
				 		    	         BRF64.getR44_product().toString();
				 		 R44cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R44cell = R44row.getCell(3);
					    	 if (R44cell != null) {
					    	    R44cell.setCellValue(BRF64.getR44_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR44_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R44cell1 = R44row.getCell(4);
					    	 if (R44cell1 != null) {
					    	    R44cell1.setCellValue(BRF64.getR44_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR44_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R44cell2 = R44row.getCell(5);
					    	 if (R44cell2 != null) {
					    	    R44cell2.setCellValue(BRF64.getR44_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR44_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R44cell3 = R44row.getCell(6);
					    	 if (R44cell3 != null) {
					    	    R44cell3.setCellValue(BRF64.getR44_unfundedos() == null ? 0 :
					    	     	BRF64.getR44_unfundedos().intValue());
					    	 }
				     				 
				     		
					    	 /////////////////////R45////////////////////////	     	
					    	 Row R45row = sheet.getRow(52);
					    	 
					    	Cell R45cell0 = R45row.getCell(2);
					      if (R45cell0 != null) {
				 		 String value = (BRF64.getR45_product() == null) ? "0" : 
				 		    	         BRF64.getR45_product().toString();
				 		 R45cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R45cell = R45row.getCell(3);
					    	 if (R45cell != null) {
					    	    R45cell.setCellValue(BRF64.getR45_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR45_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R45cell1 = R45row.getCell(4);
					    	 if (R45cell1 != null) {
					    	    R45cell1.setCellValue(BRF64.getR45_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR45_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R45cell2 = R45row.getCell(5);
					    	 if (R45cell2 != null) {
					    	    R45cell2.setCellValue(BRF64.getR45_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR45_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R45cell3 = R45row.getCell(6);
					    	 if (R45cell3 != null) {
					    	    R45cell3.setCellValue(BRF64.getR45_unfundedos() == null ? 0 :
					    	     	BRF64.getR45_unfundedos().intValue());
					    	 }
				     				 
				     		
					    	 /////////////////////R46////////////////////////	     	
					    	 Row R46row = sheet.getRow(53);
					    	 
					    	Cell R46cell0 = R46row.getCell(2);
					      if (R46cell0 != null) {
				 		 String value = (BRF64.getR46_product() == null) ? "0" : 
				 		    	         BRF64.getR46_product().toString();
				 		 R46cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R46cell = R46row.getCell(3);
					    	 if (R46cell != null) {
					    	    R46cell.setCellValue(BRF64.getR46_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR46_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R46cell1 = R46row.getCell(4);
					    	 if (R46cell1 != null) {
					    	    R46cell1.setCellValue(BRF64.getR46_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR46_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R46cell2 = R46row.getCell(5);
					    	 if (R46cell2 != null) {
					    	    R46cell2.setCellValue(BRF64.getR46_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR46_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R46cell3 = R46row.getCell(6);
					    	 if (R46cell3 != null) {
					    	    R46cell3.setCellValue(BRF64.getR46_unfundedos() == null ? 0 :
					    	     	BRF64.getR46_unfundedos().intValue());
					    	 }
				     				 
				     		
					    	 /////////////////////R47////////////////////////	     	
					    	 Row R47row = sheet.getRow(54);
					    	 
					    	Cell R47cell0 = R47row.getCell(2);
					      if (R47cell0 != null) {
				 		 String value = (BRF64.getR47_product() == null) ? "0" : 
				 		    	         BRF64.getR47_product().toString();
				 		 R47cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R47cell = R47row.getCell(3);
					    	 if (R47cell != null) {
					    	    R47cell.setCellValue(BRF64.getR47_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR47_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R47cell1 = R47row.getCell(4);
					    	 if (R47cell1 != null) {
					    	    R47cell1.setCellValue(BRF64.getR47_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR47_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R47cell2 = R47row.getCell(5);
					    	 if (R47cell2 != null) {
					    	    R47cell2.setCellValue(BRF64.getR47_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR47_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R47cell3 = R47row.getCell(6);
					    	 if (R47cell3 != null) {
					    	    R47cell3.setCellValue(BRF64.getR47_unfundedos() == null ? 0 :
					    	     	BRF64.getR47_unfundedos().intValue());
					    	 }
				     				 
				     		
					    	 /////////////////////R48////////////////////////	     	
					    	 Row R48row = sheet.getRow(55);
					    	 
					    	Cell R48cell0 = R48row.getCell(2);
					      if (R48cell0 != null) {
				 		 String value = (BRF64.getR48_product() == null) ? "0" : 
				 		    	         BRF64.getR48_product().toString();
				 		 R48cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R48cell = R48row.getCell(3);
					    	 if (R48cell != null) {
					    	    R48cell.setCellValue(BRF64.getR48_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR48_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R48cell1 = R48row.getCell(4);
					    	 if (R48cell1 != null) {
					    	    R48cell1.setCellValue(BRF64.getR48_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR48_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R48cell2 = R48row.getCell(5);
					    	 if (R48cell2 != null) {
					    	    R48cell2.setCellValue(BRF64.getR48_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR48_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R48cell3 = R48row.getCell(6);
					    	 if (R48cell3 != null) {
					    	    R48cell3.setCellValue(BRF64.getR48_unfundedos() == null ? 0 :
					    	     	BRF64.getR48_unfundedos().intValue());
					    	 }
				     				 
				     		
					    	 /////////////////////R49////////////////////////	     	
					    	 Row R49row = sheet.getRow(56);
					    	 
					    	Cell R49cell0 = R49row.getCell(2);
					      if (R49cell0 != null) {
				 		 String value = (BRF64.getR49_product() == null) ? "0" : 
				 		    	         BRF64.getR49_product().toString();
				 		 R49cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R49cell = R49row.getCell(3);
					    	 if (R49cell != null) {
					    	    R49cell.setCellValue(BRF64.getR49_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR49_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R49cell1 = R49row.getCell(4);
					    	 if (R49cell1 != null) {
					    	    R49cell1.setCellValue(BRF64.getR49_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR49_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R49cell2 = R49row.getCell(5);
					    	 if (R49cell2 != null) {
					    	    R49cell2.setCellValue(BRF64.getR49_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR49_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R49cell3 = R49row.getCell(6);
					    	 if (R49cell3 != null) {
					    	    R49cell3.setCellValue(BRF64.getR49_unfundedos() == null ? 0 :
					    	     	BRF64.getR49_unfundedos().intValue());
					    	 }
				     				 
				     		
					    	 /////////////////////R50////////////////////////	     	
					    	 Row R50row = sheet.getRow(57);
					    	 
					    	Cell R50cell0 = R50row.getCell(2);
					      if (R50cell0 != null) {
				 		 String value = (BRF64.getR50_product() == null) ? "0" : 
				 		    	         BRF64.getR50_product().toString();
				 		 R50cell0.setCellValue(value);
				 		 }
					    	 
					    	 Cell R50cell = R50row.getCell(3);
					    	 if (R50cell != null) {
					    	    R50cell.setCellValue(BRF64.getR50_fundedos_fundedexp() == null ? 0 :
					    	     	BRF64.getR50_fundedos_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R50cell1 = R50row.getCell(4);
					    	 if (R50cell1 != null) {
					    	    R50cell1.setCellValue(BRF64.getR50_pastdue_fundedexp() == null ? 0 :
					    	     	BRF64.getR50_pastdue_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R50cell2 = R50row.getCell(5);
					    	 if (R50cell2 != null) {
					    	    R50cell2.setCellValue(BRF64.getR50_numberdayspast_fundedexp() == null ? 0 :
					    	     	BRF64.getR50_numberdayspast_fundedexp().intValue());
					    	 }
					    	 
					    	 Cell R50cell3 = R50row.getCell(6);
					    	 if (R50cell3 != null) {
					    	    R50cell3.setCellValue(BRF64.getR50_unfundedos() == null ? 0 :
					    	     	BRF64.getR50_unfundedos().intValue());
					    	 }
				     			
	         
	       	 
	       	 
	       	 
	         // Save the changes
	            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-064-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-064-A.xls");

		return outputFile;
	
	
	
	}
	       	 
	       	 
	       	 
	
	public String detailChanges64(BRF64_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF64_DETAIL_ENTITY> Brf64detail = brf64_detailrepo.findById(foracid);

			if (Brf64detail.isPresent()) {
				BRF64_DETAIL_ENTITY BRFdetail = Brf64detail.get();

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
					brf64_detailrepo.save(BRFdetail);

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

public ModelAndView getArchieveBRF064View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF64_Entity> T1rep = new ArrayList<BRF64_Entity>();
	// Query<Object[]> qr;

	List<BRF64_Entity> T1Master = new ArrayList<BRF64_Entity>();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF64_Entity a where a.report_date = ?1 ", BRF64_Entity.class)
				.setParameter(1, df.parse(todate)).getResultList();

		
	} catch (ParseException e) {
		e.printStackTrace();
	}
	mv.setViewName("RR/BRF64ARCH");
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

public ModelAndView ARCHgetBRF064currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF64_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF64_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF64_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF64_ARCHIV_ENTITY> T1Master = new ArrayList<BRF64_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF64_ARCHIV_ENTITY a where a.report_date = ?1", BRF64_ARCHIV_ENTITY.class)
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
		

		BRF64_ARCHIV_ENTITY py = new BRF64_ARCHIV_ENTITY(cust_id, foracid,acct_name, eab_lc, act_balance_amt_lc,  acct_crncy_code, gl_code,
				gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
				schm_code, schm_type, sol_id, acid, segment,
				sub_segment, sector, sub_sector,  sector_code, group_id,
				constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn,
				hni_networth, turnover, bacid, report_name_1,report_label_1,
				report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
				 modify_user, modify_time, verify_user, verify_time,
				entity_flg, modify_flg, del_flg, nre_status, report_date,
				maturity_date, version, remarks);


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

	mv.setViewName("RR" + "/" + "BRF64ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}

}




