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

import com.bornfire.xbrl.entities.BRF34_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF34_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF34_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF34_ENTITY;
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
public class BRF034ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF034ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	 @Autowired 
	 BRF34_DetailRepo brf34_detailrepo;
	
	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */
	
    
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheck(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF34_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF34_ENTITY a").getSingleResult();
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
	public ModelAndView getBRF034View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF34_ENTITY> T1rep = new ArrayList<BRF34_ENTITY>();
			// Query<Object[]> qr;

			List<BRF34_ENTITY> T1Master = new ArrayList<BRF34_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF34_ENTITY a where a.report_date = ?1 ", BRF34_ENTITY .class)
						.setParameter(1, df.parse(todate)).getResultList();

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF034A");
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
	
	public ModelAndView getBRF034currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF34_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF34_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF34_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF34_DETAIL_ENTITY> T1Master = new ArrayList<BRF34_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF34_DETAIL_ENTITY a where a.report_date = ?1", BRF34_DETAIL_ENTITY.class)
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
			String maturity_date = (String) a[45];
			String gender = (String)a[46];
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

			BRF34_DETAIL_ENTITY py = new BRF34_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nre_flg);
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


		
		
		mv.setViewName("RR" + "/" + "BRF034A::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	public File getFile(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-034-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF34_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF34_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF034.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF034.jrxml");
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
				
				List<BRF34_ENTITY> T1Master = new ArrayList<BRF34_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF34_ENTITY a where a.report_date = ?1 ", BRF34_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF34_ENTITY BRF34 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-034-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	          //report_date	 
				/*
				 * Row r1row = sheet.getRow(4); if (r1row != null) { Cell r1cell =
				 * r1row.getCell(2); if (r1cell == null) { r1cell = r1row.createCell(2); //
				 * Create the cell if it doesn't exist } if (BRF34.getReport_date() != null) {
				 * // Formatting the date to dd-MM-yyyy SimpleDateFormat sdf = new
				 * SimpleDateFormat("dd-MM-yyyy"); String formattedDate =
				 * sdf.format(BRF34.getReport_date()); r1cell.setCellValue(formattedDate); //
				 * Set the formatted date in the cell } else { r1cell.setCellValue(""); // Set
				 * an empty value if the report_date is null } }
				 */
	            
	            Row row = sheet.getRow(10);
	       	 Cell cell = row.getCell(3);
	       	 if (cell != null) {
	            cell.setCellValue(BRF34.getR1_inter_bank_place() == null ? 0 :
	       	     	BRF34.getR1_inter_bank_place().intValue());
	       	 }
	       	 
	       	Cell cell1 = row.getCell(4);
	       	 if (cell1 != null) {
	            cell1.setCellValue(BRF34.getR1_inter_bank_borrow() == null ? 0 :
	       	     	BRF34.getR1_inter_bank_borrow().intValue());
	       	 }
	       	 
	       	Cell cell2 = row.getCell(5);
	       	 if (cell2 != null) {
	            cell2.setCellValue(BRF34.getR1_other_placement() == null ? 0 :
	       	     	BRF34.getR1_other_placement().intValue());
	       	 }
	       	 
	       	Cell cell3 = row.getCell(6);
	       	 if (cell3 != null) {
	            cell3.setCellValue(BRF34.getR1_other_borrow() == null ? 0 :
	       	     	BRF34.getR1_other_borrow().intValue());
	       	 }
	       	 
	     	Cell cell4 = row.getCell(7);
	       	 if (cell4 != null) {
	            cell4.setCellValue(BRF34.getR1_remani_balance_from() == null ? 0 :
	       	     	BRF34.getR1_remani_balance_from().intValue());
	       	 }
	       	 
	       	Cell cell5 = row.getCell(8);
	       	 if (cell5 != null) {
	            cell5.setCellValue(BRF34.getR1_remani_balance_to() == null ? 0 :
	       	     	BRF34.getR1_remani_balance_to().intValue());
	       	 }
	       	 
	       	 
	       	 
	       	 //////////////////////R2//////////////////////////
	       	 
	       	 Row R1row = sheet.getRow(11);
	       	 Cell R1cell = R1row.getCell(3);
	       		 if (R1cell != null) {
	       	     R1cell.setCellValue(BRF34.getR2_inter_bank_place() == null ? 0 :
	       		     	BRF34.getR2_inter_bank_place().intValue());
	       		 }
	       		 
	       		Cell R1cell1 = R1row.getCell(4);
	       		 if (R1cell1 != null) {
	       	     R1cell1.setCellValue(BRF34.getR2_inter_bank_borrow() == null ? 0 :
	       		     	BRF34.getR2_inter_bank_borrow().intValue());
	       		 }
	       		 
	       		Cell R1cell2 = R1row.getCell(5);
	       		 if (R1cell2 != null) {
	       	     R1cell2.setCellValue(BRF34.getR2_other_placement() == null ? 0 :
	       		     	BRF34.getR2_other_placement().intValue());
	       		 }
	       		 
	       		Cell R1cell3 = R1row.getCell(6);
	       		 if (R1cell3 != null) {
	       	     R1cell3.setCellValue(BRF34.getR2_other_borrow() == null ? 0 :
	       		     	BRF34.getR2_other_borrow().intValue());
	       		 }
	       		 
	       	    Cell R1cell4 = R1row.getCell(7);
	       		 if (R1cell4 != null) {
	       	     R1cell4.setCellValue(BRF34.getR2_remani_balance_from() == null ? 0 :
	       		     	BRF34.getR2_remani_balance_from().intValue());
	       		 }
	       		 
	       		Cell R1cell5 = R1row.getCell(8);
	       		 if (R1cell5 != null) {
	       	     R1cell5.setCellValue(BRF34.getR2_remani_balance_to() == null ? 0 :
	       		     	BRF34.getR2_remani_balance_to().intValue());
	       		 }
	       		 
	       
	       		 //////////////////////R3//////////////////////////
	       		 
	       		 Row R2row = sheet.getRow(12);
	       		 Cell R2cell = R2row.getCell(3);
	       			 if (R2cell != null) {
	       		     R2cell.setCellValue(BRF34.getR3_inter_bank_place() == null ? 0 :
	       			     	BRF34.getR3_inter_bank_place().intValue());
	       			 }
	       			 
	       			Cell R2cell1 = R2row.getCell(4);
	       			 if (R2cell1 != null) {
	       		     R2cell1.setCellValue(BRF34.getR3_inter_bank_borrow() == null ? 0 :
	       			     	BRF34.getR3_inter_bank_borrow().intValue());
	       			 }
	       			 
	       			Cell R2cell2 = R2row.getCell(5);
	       			 if (R2cell2 != null) {
	       		     R2cell2.setCellValue(BRF34.getR3_other_placement() == null ? 0 :
	       			     	BRF34.getR3_other_placement().intValue());
	       			 }
	       			 
	       			Cell R2cell3 = R2row.getCell(6);
	       			 if (R2cell3 != null) {
	       		     R2cell3.setCellValue(BRF34.getR3_other_borrow() == null ? 0 :
	       			     	BRF34.getR3_other_borrow().intValue());
	       			 }
	       			 
	       		    Cell R2cell4 = R2row.getCell(7);
	       			 if (R2cell4 != null) {
	       		     R2cell4.setCellValue(BRF34.getR3_remani_balance_from() == null ? 0 :
	       			     	BRF34.getR3_remani_balance_from().intValue());
	       			 }
	       			 
	       			Cell R2cell5 = R2row.getCell(8);
	       			 if (R2cell5 != null) {
	       		     R2cell5.setCellValue(BRF34.getR3_remani_balance_to() == null ? 0 :
	       			     	BRF34.getR3_remani_balance_to().intValue());
	       			 }
	       			 
	       			 //////////////////////R4//////////////////////////
	       			 
	       			 Row R3row = sheet.getRow(13);
	       			 Cell R3cell = R3row.getCell(3);
	       				 if (R3cell != null) {
	       			     R3cell.setCellValue(BRF34.getR4_inter_bank_place() == null ? 0 :
	       				     	BRF34.getR4_inter_bank_place().intValue());
	       				 }
	       				 
	       				Cell R3cell1 = R3row.getCell(4);
	       				 if (R3cell1 != null) {
	       			     R3cell1.setCellValue(BRF34.getR4_inter_bank_borrow() == null ? 0 :
	       				     	BRF34.getR4_inter_bank_borrow().intValue());
	       				 }
	       				 
	       				Cell R3cell2 = R3row.getCell(5);
	       				 if (R3cell2 != null) {
	       			     R3cell2.setCellValue(BRF34.getR4_other_placement() == null ? 0 :
	       				     	BRF34.getR4_other_placement().intValue());
	       				 }
	       				 
	       				Cell R3cell3 = R3row.getCell(6);
	       				 if (R3cell3 != null) {
	       			     R3cell3.setCellValue(BRF34.getR4_other_borrow() == null ? 0 :
	       				     	BRF34.getR4_other_borrow().intValue());
	       				 }
	       				 
	       			    Cell R3cell4 = R3row.getCell(7);
	       				 if (R3cell4 != null) {
	       			     R3cell4.setCellValue(BRF34.getR4_remani_balance_from() == null ? 0 :
	       				     	BRF34.getR4_remani_balance_from().intValue());
	       				 }
	       				 
	       				Cell R3cell5 = R3row.getCell(8);
	       				 if (R3cell5 != null) {
	       			     R3cell5.setCellValue(BRF34.getR4_remani_balance_to() == null ? 0 :
	       				     	BRF34.getR4_remani_balance_to().intValue());
	       				 }
	       				 
	       	
	       	 
	       				 //////////////////////R5//////////////////////////
	       				 
	       				 Row R4row = sheet.getRow(14);
	       				 Cell R4cell = R4row.getCell(3);
	       					 if (R4cell != null) {
	       				     R4cell.setCellValue(BRF34.getR5_inter_bank_place() == null ? 0 :
	       					     	BRF34.getR5_inter_bank_place().intValue());
	       					 }
	       					 
	       					Cell R4cell1 = R4row.getCell(4);
	       					 if (R4cell1 != null) {
	       				     R4cell1.setCellValue(BRF34.getR5_inter_bank_borrow() == null ? 0 :
	       					     	BRF34.getR5_inter_bank_borrow().intValue());
	       					 }
	       					 
	       					Cell R4cell2 = R4row.getCell(5);
	       					 if (R4cell2 != null) {
	       				     R4cell2.setCellValue(BRF34.getR5_other_placement() == null ? 0 :
	       					     	BRF34.getR5_other_placement().intValue());
	       					 }
	       					 
	       					Cell R4cell3 = R4row.getCell(6);
	       					 if (R4cell3 != null) {
	       				     R4cell3.setCellValue(BRF34.getR5_other_borrow() == null ? 0 :
	       					     	BRF34.getR5_other_borrow().intValue());
	       					 }
	       					 
	       				    Cell R4cell4 = R4row.getCell(7);
	       					 if (R4cell4 != null) {
	       				     R4cell4.setCellValue(BRF34.getR5_remani_balance_from() == null ? 0 :
	       					     	BRF34.getR5_remani_balance_from().intValue());
	       					 }
	       					 
	       					Cell R4cell5 = R4row.getCell(8);
	       					 if (R4cell5 != null) {
	       				     R4cell5.setCellValue(BRF34.getR5_remani_balance_to() == null ? 0 :
	       					     	BRF34.getR5_remani_balance_to().intValue());
	       					 }
	       					 
	       					 //////////////////////R6//////////////////////////
	       					 
	       					 Row R5row = sheet.getRow(15);
	       					 Cell R5cell = R5row.getCell(3);
	       						 if (R5cell != null) {
	       					     R5cell.setCellValue(BRF34.getR6_inter_bank_place() == null ? 0 :
	       						     	BRF34.getR6_inter_bank_place().intValue());
	       						 }
	       						 
	       						Cell R5cell1 = R5row.getCell(4);
	       						 if (R5cell1 != null) {
	       					     R5cell1.setCellValue(BRF34.getR6_inter_bank_borrow() == null ? 0 :
	       						     	BRF34.getR6_inter_bank_borrow().intValue());
	       						 }
	       						 
	       						Cell R5cell2 = R5row.getCell(5);
	       						 if (R5cell2 != null) {
	       					     R5cell2.setCellValue(BRF34.getR6_other_placement() == null ? 0 :
	       						     	BRF34.getR6_other_placement().intValue());
	       						 }
	       						 
	       						Cell R5cell3 = R5row.getCell(6);
	       						 if (R5cell3 != null) {
	       					     R5cell3.setCellValue(BRF34.getR6_other_borrow() == null ? 0 :
	       						     	BRF34.getR6_other_borrow().intValue());
	       						 }
	       						 
	       					    Cell R5cell4 = R5row.getCell(7);
	       						 if (R5cell4 != null) {
	       					     R5cell4.setCellValue(BRF34.getR6_remani_balance_from() == null ? 0 :
	       						     	BRF34.getR6_remani_balance_from().intValue());
	       						 }
	       						 
	       						Cell R5cell5 = R5row.getCell(8);
	       						 if (R5cell5 != null) {
	       					     R5cell5.setCellValue(BRF34.getR6_remani_balance_to() == null ? 0 :
	       						     	BRF34.getR6_remani_balance_to().intValue());
	       						 }
	       						 
	       						 //////////////////////R7//////////////////////////
	       						 
	       						 Row R6row = sheet.getRow(16);
	       						 Cell R6cell = R6row.getCell(3);
	       							 if (R6cell != null) {
	       						     R6cell.setCellValue(BRF34.getR7_inter_bank_place() == null ? 0 :
	       							     	BRF34.getR7_inter_bank_place().intValue());
	       							 }
	       							 
	       				Cell R6cell1 = R6row.getCell(4);
	       				 if (R6cell1 != null) {
	       				 R6cell1.setCellValue(BRF34.getR7_inter_bank_borrow() == null ? 0 :
	       				     	BRF34.getR7_inter_bank_borrow().intValue());
	       				 }
	       				 
	       				Cell R6cell2 = R6row.getCell(5);
	       				 if (R6cell2 != null) {
	       				 R6cell2.setCellValue(BRF34.getR7_other_placement() == null ? 0 :
	       				     	BRF34.getR7_other_placement().intValue());
	       				 }
	       				 
	       				Cell R6cell3 = R6row.getCell(6);
	       				 if (R6cell3 != null) {
	       				 R6cell3.setCellValue(BRF34.getR7_other_borrow() == null ? 0 :
	       				     	BRF34.getR7_other_borrow().intValue());
	       				 }
	       				 
	       				Cell R6cell4 = R6row.getCell(7);
	       				 if (R6cell4 != null) {
	       				 R6cell4.setCellValue(BRF34.getR7_remani_balance_from() == null ? 0 :
	       				     	BRF34.getR7_remani_balance_from().intValue());
	       				 }
	       				 
	       				Cell R6cell5 = R6row.getCell(8);
	       				 if (R6cell5 != null) {
	       				 R6cell5.setCellValue(BRF34.getR7_remani_balance_to() == null ? 0 :
	       				     	BRF34.getR7_remani_balance_to().intValue());
	       				 }
	       				 
	       				 //////////////////////R8//////////////////////////
	       				 
	       				 Row R7row = sheet.getRow(17);
	       				 Cell R7cell = R7row.getCell(3);
	       					 if (R7cell != null) {
	       				     R7cell.setCellValue(BRF34.getR8_inter_bank_place() == null ? 0 :
	       					     	BRF34.getR8_inter_bank_place().intValue());
	       					 }
	       					 
	       					Cell R7cell1 = R7row.getCell(4);
	       					 if (R7cell1 != null) {
	       				     R7cell1.setCellValue(BRF34.getR8_inter_bank_borrow() == null ? 0 :
	       					     	BRF34.getR8_inter_bank_borrow().intValue());
	       					 }
	       					 
	       					Cell R7cell2 = R7row.getCell(5);
	       					 if (R7cell2 != null) {
	       				     R7cell2.setCellValue(BRF34.getR8_other_placement() == null ? 0 :
	       					     	BRF34.getR8_other_placement().intValue());
	       					 }
	       					 
	       					Cell R7cell3 = R7row.getCell(6);
	       					 if (R7cell3 != null) {
	       				     R7cell3.setCellValue(BRF34.getR8_other_borrow() == null ? 0 :
	       					     	BRF34.getR8_other_borrow().intValue());
	       					 }
	       					 
	       				    Cell R7cell4 = R7row.getCell(7);
	       					 if (R7cell4 != null) {
	       				     R7cell4.setCellValue(BRF34.getR8_remani_balance_from() == null ? 0 :
	       					     	BRF34.getR8_remani_balance_from().intValue());
	       					 }
	       					 
	       					Cell R7cell5 = R7row.getCell(8);
	       					 if (R7cell5 != null) {
	       				     R7cell5.setCellValue(BRF34.getR8_remani_balance_to() == null ? 0 :
	       					     	BRF34.getR8_remani_balance_to().intValue());
	       					 }
	       					 
	       					 //////////////////////R9//////////////////////////
	       					 
	       					 Row R8row = sheet.getRow(18);
	       					 Cell R8cell = R8row.getCell(3);
	       						 if (R8cell != null) {
	       					     R8cell.setCellValue(BRF34.getR9_inter_bank_place() == null ? 0 :
	       						     	BRF34.getR9_inter_bank_place().intValue());
	       						 }
	       						 
	       						Cell R8cell1 = R8row.getCell(4);
	       						 if (R8cell1 != null) {
	       					     R8cell1.setCellValue(BRF34.getR9_inter_bank_borrow() == null ? 0 :
	       						     	BRF34.getR9_inter_bank_borrow().intValue());
	       						 }
	       						 
	       						Cell R8cell2 = R8row.getCell(5);
	       						 if (R8cell2 != null) {
	       					     R8cell2.setCellValue(BRF34.getR9_other_placement() == null ? 0 :
	       						     	BRF34.getR9_other_placement().intValue());
	       						 }
	       						 
	       						Cell R8cell3 = R8row.getCell(6);
	       						 if (R8cell3 != null) {
	       					     R8cell3.setCellValue(BRF34.getR9_other_borrow() == null ? 0 :
	       						     	BRF34.getR9_other_borrow().intValue());
	       						 }
	       						 
	       					    Cell R8cell4 = R8row.getCell(7);
	       						 if (R8cell4 != null) {
	       					     R8cell4.setCellValue(BRF34.getR9_remani_balance_from() == null ? 0 :
	       						     	BRF34.getR9_remani_balance_from().intValue());
	       						 }
	       						 
	       						Cell R8cell5 = R8row.getCell(8);
	       						 if (R8cell5 != null) {
	       					     R8cell5.setCellValue(BRF34.getR9_remani_balance_to() == null ? 0 :
	       						     	BRF34.getR9_remani_balance_to().intValue());
	       						 }
	       						 
	       						 //////////////////////R10//////////////////////////
	       						 
	       						 Row R9row = sheet.getRow(19);
	       						 Cell R9cell = R9row.getCell(3);
	       							 if (R9cell != null) {
	       						     R9cell.setCellValue(BRF34.getR10_inter_bank_place() == null ? 0 :
	       							     	BRF34.getR10_inter_bank_place().intValue());
	       							 }
	       							 
	       				Cell R9cell1 = R9row.getCell(4);
	       				 if (R9cell1 != null) {
	       				 R9cell1.setCellValue(BRF34.getR10_inter_bank_borrow() == null ? 0 :
	       				     	BRF34.getR10_inter_bank_borrow().intValue());
	       				 }
	       				 
	       				Cell R9cell2 = R9row.getCell(5);
	       				 if (R9cell2 != null) {
	       				 R9cell2.setCellValue(BRF34.getR10_other_placement() == null ? 0 :
	       				     	BRF34.getR10_other_placement().intValue());
	       				 }
	       				 
	       				Cell R9cell3 = R9row.getCell(6);
	       				 if (R9cell3 != null) {
	       				 R9cell3.setCellValue(BRF34.getR10_other_borrow() == null ? 0 :
	       				     	BRF34.getR10_other_borrow().intValue());
	       				 }
	       				 
	       				Cell R9cell4 = R9row.getCell(7);
	       				 if (R9cell4 != null) {
	       				 R9cell4.setCellValue(BRF34.getR10_remani_balance_from() == null ? 0 :
	       				     	BRF34.getR10_remani_balance_from().intValue());
	       				 }
	       				 
	       				Cell R9cell5 = R9row.getCell(8);
	       				 if (R9cell5 != null) {
	       				 R9cell5.setCellValue(BRF34.getR10_remani_balance_to() == null ? 0 :
	       				     	BRF34.getR10_remani_balance_to().intValue());
	       				 }
	       				 

	       				 //////////////////////////R11////////////////////////
	       				 
	       				 Row R10row = sheet.getRow(20);
	       				 Cell R10cell = R10row.getCell(3);
	       					 if (R10cell != null) {
	       				     R10cell.setCellValue(BRF34.getR11_inter_bank_place() == null ? 0 :
	       					     	BRF34.getR11_inter_bank_place().intValue());
	       					 }
	       					 
	       					Cell R10cell1 = R10row.getCell(4);
	       					 if (R10cell1 != null) {
	       				     R10cell1.setCellValue(BRF34.getR11_inter_bank_borrow() == null ? 0 :
	       					     	BRF34.getR11_inter_bank_borrow().intValue());
	       					 }
	       					 
	       					Cell R10cell2 = R10row.getCell(5);
	       					 if (R10cell2 != null) {
	       				     R10cell2.setCellValue(BRF34.getR11_other_placement() == null ? 0 :
	       					     	BRF34.getR11_other_placement().intValue());
	       					 }
	       					 
	       					Cell R10cell3 = R10row.getCell(6);
	       					 if (R10cell3 != null) {
	       				     R10cell3.setCellValue(BRF34.getR11_other_borrow() == null ? 0 :
	       					     	BRF34.getR11_other_borrow().intValue());
	       					 }
	       					 
	       				    Cell R10cell4 = R10row.getCell(7);
	       					 if (R10cell4 != null) {
	       				     R10cell4.setCellValue(BRF34.getR11_remani_balance_from() == null ? 0 :
	       					     	BRF34.getR11_remani_balance_from().intValue());
	       					 }
	       					 
	       					Cell R10cell5 = R10row.getCell(8);
	       					 if (R10cell5 != null) {
	       				     R10cell5.setCellValue(BRF34.getR11_remani_balance_to() == null ? 0 :
	       					     	BRF34.getR11_remani_balance_to().intValue());
	       					 }
	       					 //////////////////////////R12////////////////////////
	       					 
	       					 Row R11row = sheet.getRow(21);
	       					 Cell R11cell = R11row.getCell(3);
	       						 if (R11cell != null) {
	       					     R11cell.setCellValue(BRF34.getR12_inter_bank_place() == null ? 0 :
	       						     	BRF34.getR12_inter_bank_place().intValue());
	       						 }
	       						 
	       						Cell R11cell1 = R11row.getCell(4);
	       						 if (R11cell1 != null) {
	       					     R11cell1.setCellValue(BRF34.getR12_inter_bank_borrow() == null ? 0 :
	       						     	BRF34.getR12_inter_bank_borrow().intValue());
	       						 }
	       						 
	       						Cell R11cell2 = R11row.getCell(5);
	       						 if (R11cell2 != null) {
	       					     R11cell2.setCellValue(BRF34.getR12_other_placement() == null ? 0 :
	       						     	BRF34.getR12_other_placement().intValue());
	       						 }
	       						 
	       						Cell R11cell3 = R11row.getCell(6);
	       						 if (R11cell3 != null) {
	       					     R11cell3.setCellValue(BRF34.getR12_other_borrow() == null ? 0 :
	       						     	BRF34.getR12_other_borrow().intValue());
	       						 }
	       						 
	       					    Cell R11cell4 = R11row.getCell(7);
	       						 if (R11cell4 != null) {
	       					     R11cell4.setCellValue(BRF34.getR12_remani_balance_from() == null ? 0 :
	       						     	BRF34.getR12_remani_balance_from().intValue());
	       						 }
	       						 
	       						Cell R11cell5 = R11row.getCell(8);
	       						 if (R11cell5 != null) {
	       					     R11cell5.setCellValue(BRF34.getR12_remani_balance_to() == null ? 0 :
	       						     	BRF34.getR12_remani_balance_to().intValue());
	       						 }

	       						 
	       						 
	       				 //////////////////////////R13////////////////////////
	       				 
	       				 Row R12row = sheet.getRow(22);
	       				 Cell R12cell = R12row.getCell(3);
	       					 if (R12cell != null) {
	       				     R12cell.setCellValue(BRF34.getR13_inter_bank_place() == null ? 0 :
	       					     	BRF34.getR13_inter_bank_place().intValue());
	       					 }
	       					 
	       					Cell R12cell1 = R12row.getCell(4);
	       					 if (R12cell1 != null) {
	       				     R12cell1.setCellValue(BRF34.getR13_inter_bank_borrow() == null ? 0 :
	       					     	BRF34.getR13_inter_bank_borrow().intValue());
	       					 }
	       					 
	       					Cell R12cell2 = R12row.getCell(5);
	       					 if (R12cell2 != null) {
	       				     R12cell2.setCellValue(BRF34.getR13_other_placement() == null ? 0 :
	       					     	BRF34.getR13_other_placement().intValue());
	       					 }
	       					 
	       					Cell R12cell3 = R12row.getCell(6);
	       					 if (R12cell3 != null) {
	       				     R12cell3.setCellValue(BRF34.getR13_other_borrow() == null ? 0 :
	       					     	BRF34.getR13_other_borrow().intValue());
	       					 }
	       					 
	       				    Cell R12cell4 = R12row.getCell(7);
	       					 if (R12cell4 != null) {
	       				     R12cell4.setCellValue(BRF34.getR13_remani_balance_from() == null ? 0 :
	       					     	BRF34.getR13_remani_balance_from().intValue());
	       					 }
	       					 
	       					Cell R12cell5 = R12row.getCell(8);
	       					 if (R12cell5 != null) {
	       				     R12cell5.setCellValue(BRF34.getR13_remani_balance_to() == null ? 0 :
	       					     	BRF34.getR13_remani_balance_to().intValue());
	       					 }
	       					 


	       					 //////////////////////////R14////////////////////////
	       					 
	       					 Row R13row = sheet.getRow(23);
	       					 Cell R13cell = R13row.getCell(3);
	       						 if (R13cell != null) {
	       					     R13cell.setCellValue(BRF34.getR14_inter_bank_place() == null ? 0 :
	       						     	BRF34.getR14_inter_bank_place().intValue());
	       						 }
	       						 
	       						Cell R13cell1 = R13row.getCell(4);
	       						 if (R13cell1 != null) {
	       					     R13cell1.setCellValue(BRF34.getR14_inter_bank_borrow() == null ? 0 :
	       						     	BRF34.getR14_inter_bank_borrow().intValue());
	       						 }
	       						 
	       						Cell R13cell2 = R13row.getCell(5);
	       						 if (R13cell2 != null) {
	       					     R13cell2.setCellValue(BRF34.getR14_other_placement() == null ? 0 :
	       						     	BRF34.getR14_other_placement().intValue());
	       						 }
	       						 
	       						Cell R13cell3 = R13row.getCell(6);
	       						 if (R13cell3 != null) {
	       					     R13cell3.setCellValue(BRF34.getR14_other_borrow() == null ? 0 :
	       						     	BRF34.getR14_other_borrow().intValue());
	       						 }
	       						 
	       					    Cell R13cell4 = R13row.getCell(7);
	       						 if (R13cell4 != null) {
	       					     R13cell4.setCellValue(BRF34.getR14_remani_balance_from() == null ? 0 :
	       						     	BRF34.getR14_remani_balance_from().intValue());
	       						 }
	       						 
	       						Cell R13cell5 = R13row.getCell(8);
	       						 if (R13cell5 != null) {
	       					     R13cell5.setCellValue(BRF34.getR14_remani_balance_to() == null ? 0 :
	       						     	BRF34.getR14_remani_balance_to().intValue());
	       						 }
	       						 //////////////////////////R15////////////////////////
	       						 
	       						 Row R14row = sheet.getRow(24);
	       						 Cell R14cell = R14row.getCell(3);
	       							 if (R14cell != null) {
	       						     R14cell.setCellValue(BRF34.getR15_inter_bank_place() == null ? 0 :
	       							     	BRF34.getR15_inter_bank_place().intValue());
	       							 }
	       							 
	       							Cell R14cell1 = R14row.getCell(4);
	       							 if (R14cell1 != null) {
	       						     R14cell1.setCellValue(BRF34.getR15_inter_bank_borrow() == null ? 0 :
	       							     	BRF34.getR15_inter_bank_borrow().intValue());
	       							 }
	       							 
	       							Cell R14cell2 = R14row.getCell(5);
	       							 if (R14cell2 != null) {
	       						     R14cell2.setCellValue(BRF34.getR15_other_placement() == null ? 0 :
	       							     	BRF34.getR15_other_placement().intValue());
	       							 }
	       							 
	       							Cell R14cell3 = R14row.getCell(6);
	       							 if (R14cell3 != null) {
	       						     R14cell3.setCellValue(BRF34.getR15_other_borrow() == null ? 0 :
	       							     	BRF34.getR15_other_borrow().intValue());
	       							 }
	       							 
	       						    Cell R14cell4 = R14row.getCell(7);
	       							 if (R14cell4 != null) {
	       						     R14cell4.setCellValue(BRF34.getR15_remani_balance_from() == null ? 0 :
	       							     	BRF34.getR15_remani_balance_from().intValue());
	       							 }
	       							 
	       							Cell R14cell5 = R14row.getCell(8);
	       							 if (R14cell5 != null) {
	       						     R14cell5.setCellValue(BRF34.getR15_remani_balance_to() == null ? 0 :
	       							     	BRF34.getR15_remani_balance_to().intValue());
	       							 }
	       							 
	       							 
	       							 //////////////////////////R16////////////////////////
	       							 
	       							 Row R15row = sheet.getRow(25);
	       							 Cell R15cell = R15row.getCell(3);
	       								 if (R15cell != null) {
	       							     R15cell.setCellValue(BRF34.getR16_inter_bank_place() == null ? 0 :
	       								     	BRF34.getR16_inter_bank_place().intValue());
	       								 }
	       								 
	       								Cell R15cell1 = R15row.getCell(4);
	       								 if (R15cell1 != null) {
	       							     R15cell1.setCellValue(BRF34.getR16_inter_bank_borrow() == null ? 0 :
	       								     	BRF34.getR16_inter_bank_borrow().intValue());
	       								 }
	       								 
	       								Cell R15cell2 = R15row.getCell(5);
	       								 if (R15cell2 != null) {
	       							     R15cell2.setCellValue(BRF34.getR16_other_placement() == null ? 0 :
	       								     	BRF34.getR16_other_placement().intValue());
	       								 }
	       								 
	       								Cell R15cell3 = R15row.getCell(6);
	       								 if (R15cell3 != null) {
	       							     R15cell3.setCellValue(BRF34.getR16_other_borrow() == null ? 0 :
	       								     	BRF34.getR16_other_borrow().intValue());
	       								 }
	       								 
	       							    Cell R15cell4 = R15row.getCell(7);
	       								 if (R15cell4 != null) {
	       							     R15cell4.setCellValue(BRF34.getR16_remani_balance_from() == null ? 0 :
	       								     	BRF34.getR16_remani_balance_from().intValue());
	       								 }
	       								 
	       								Cell R15cell5 = R15row.getCell(8);
	       								 if (R15cell5 != null) {
	       							     R15cell5.setCellValue(BRF34.getR16_remani_balance_to() == null ? 0 :
	       								     	BRF34.getR16_remani_balance_to().intValue());
	       								 }
	       								 
	       								 //////////////////////////R17////////////////////////
	       								 
	       								 Row R16row = sheet.getRow(26);
	       								 Cell R16cell = R16row.getCell(3);
	       									 if (R16cell != null) {
	       								     R16cell.setCellValue(BRF34.getR17_inter_bank_place() == null ? 0 :
	       									     	BRF34.getR17_inter_bank_place().intValue());
	       									 }
	       									 
	       									Cell R16cell1 = R16row.getCell(4);
	       									 if (R16cell1 != null) {
	       								     R16cell1.setCellValue(BRF34.getR17_inter_bank_borrow() == null ? 0 :
	       									     	BRF34.getR17_inter_bank_borrow().intValue());
	       									 }
	       									 
	       									Cell R16cell2 = R16row.getCell(5);
	       									 if (R16cell2 != null) {
	       								     R16cell2.setCellValue(BRF34.getR17_other_placement() == null ? 0 :
	       									     	BRF34.getR17_other_placement().intValue());
	       									 }
	       									 
	       									Cell R16cell3 = R16row.getCell(6);
	       									 if (R16cell3 != null) {
	       								     R16cell3.setCellValue(BRF34.getR17_other_borrow() == null ? 0 :
	       									     	BRF34.getR17_other_borrow().intValue());
	       									 }
	       									 
	       								    Cell R16cell4 = R16row.getCell(7);
	       									 if (R16cell4 != null) {
	       								     R16cell4.setCellValue(BRF34.getR17_remani_balance_from() == null ? 0 :
	       									     	BRF34.getR17_remani_balance_from().intValue());
	       									 }
	       									 
	       									Cell R16cell5 = R16row.getCell(8);
	       									 if (R16cell5 != null) {
	       								     R16cell5.setCellValue(BRF34.getR17_remani_balance_to() == null ? 0 :
	       									     	BRF34.getR17_remani_balance_to().intValue());
	       									 }
	       									 
	       									 
	       									 
	       									 //////////////////////////R18////////////////////////
	       									 
	       									 Row R17row = sheet.getRow(27);
	       									 Cell R17cell = R17row.getCell(3);
	       										 if (R17cell != null) {
	       									     R17cell.setCellValue(BRF34.getR18_inter_bank_place() == null ? 0 :
	       										     	BRF34.getR18_inter_bank_place().intValue());
	       										 }
	       										 
	       										Cell R17cell1 = R17row.getCell(4);
	       										 if (R17cell1 != null) {
	       									     R17cell1.setCellValue(BRF34.getR18_inter_bank_borrow() == null ? 0 :
	       										     	BRF34.getR18_inter_bank_borrow().intValue());
	       										 }
	       										 
	       										Cell R17cell2 = R17row.getCell(5);
	       										 if (R17cell2 != null) {
	       									     R17cell2.setCellValue(BRF34.getR18_other_placement() == null ? 0 :
	       										     	BRF34.getR18_other_placement().intValue());
	       										 }
	       										 
	       										Cell R17cell3 = R17row.getCell(6);
	       										 if (R17cell3 != null) {
	       									     R17cell3.setCellValue(BRF34.getR18_other_borrow() == null ? 0 :
	       										     	BRF34.getR18_other_borrow().intValue());
	       										 }
	       										 
	       									    Cell R17cell4 = R17row.getCell(7);
	       										 if (R17cell4 != null) {
	       									     R17cell4.setCellValue(BRF34.getR18_remani_balance_from() == null ? 0 :
	       										     	BRF34.getR18_remani_balance_from().intValue());
	       										 }
	       										 
	       										Cell R17cell5 = R17row.getCell(8);
	       										 if (R17cell5 != null) {
	       									     R17cell5.setCellValue(BRF34.getR18_remani_balance_to() == null ? 0 :
	       										     	BRF34.getR18_remani_balance_to().intValue());
	       										 }
	       		
	       						 
	       										 //////////////////////////R19////////////////////////
	       										 
	       										 Row R18row = sheet.getRow(28);
	       										 Cell R18cell = R18row.getCell(3);
	       											 if (R18cell != null) {
	       										     R18cell.setCellValue(BRF34.getR19_inter_bank_place() == null ? 0 :
	       											     	BRF34.getR19_inter_bank_place().intValue());
	       											 }
	       											 
	       											Cell R18cell1 = R18row.getCell(4);
	       											 if (R18cell1 != null) {
	       										     R18cell1.setCellValue(BRF34.getR19_inter_bank_borrow() == null ? 0 :
	       											     	BRF34.getR19_inter_bank_borrow().intValue());
	       											 }
	       											 
	       											Cell R18cell2 = R18row.getCell(5);
	       											 if (R18cell2 != null) {
	       										     R18cell2.setCellValue(BRF34.getR19_other_placement() == null ? 0 :
	       											     	BRF34.getR19_other_placement().intValue());
	       											 }
	       											 
	       											Cell R18cell3 = R18row.getCell(6);
	       											 if (R18cell3 != null) {
	       										     R18cell3.setCellValue(BRF34.getR19_other_borrow() == null ? 0 :
	       											     	BRF34.getR19_other_borrow().intValue());
	       											 }
	       											 
	       										    Cell R18cell4 = R18row.getCell(7);
	       											 if (R18cell4 != null) {
	       										     R18cell4.setCellValue(BRF34.getR19_remani_balance_from() == null ? 0 :
	       											     	BRF34.getR19_remani_balance_from().intValue());
	       											 }
	       											 
	       											Cell R18cell5 = R18row.getCell(8);
	       											 if (R18cell5 != null) {
	       										     R18cell5.setCellValue(BRF34.getR19_remani_balance_to() == null ? 0 :
	       											     	BRF34.getR19_remani_balance_to().intValue());
	       											 }
	       				
	       											 //////////////////////////R20////////////////////////
	       											 
	       											 Row R19row = sheet.getRow(29);
	       											 Cell R19cell = R19row.getCell(3);
	       												 if (R19cell != null) {
	       											     R19cell.setCellValue(BRF34.getR20_inter_bank_place() == null ? 0 :
	       												     	BRF34.getR20_inter_bank_place().intValue());
	       												 }
	       												 
	       												Cell R19cell1 = R19row.getCell(4);
	       												 if (R19cell1 != null) {
	       											     R19cell1.setCellValue(BRF34.getR20_inter_bank_borrow() == null ? 0 :
	       												     	BRF34.getR20_inter_bank_borrow().intValue());
	       												 }
	       												 
	       												Cell R19cell2 = R19row.getCell(5);
	       												 if (R19cell2 != null) {
	       											     R19cell2.setCellValue(BRF34.getR20_other_placement() == null ? 0 :
	       												     	BRF34.getR20_other_placement().intValue());
	       												 }
	       												 
	       												Cell R19cell3 = R19row.getCell(6);
	       												 if (R19cell3 != null) {
	       											     R19cell3.setCellValue(BRF34.getR20_other_borrow() == null ? 0 :
	       												     	BRF34.getR20_other_borrow().intValue());
	       												 }
	       												 
	       											    Cell R19cell4 = R19row.getCell(7);
	       												 if (R19cell4 != null) {
	       											     R19cell4.setCellValue(BRF34.getR20_remani_balance_from() == null ? 0 :
	       												     	BRF34.getR20_remani_balance_from().intValue());
	       												 }
	       												 
	       												Cell R19cell5 = R19row.getCell(8);
	       												 if (R19cell5 != null) {
	       											     R19cell5.setCellValue(BRF34.getR20_remani_balance_to() == null ? 0 :
	       												     	BRF34.getR20_remani_balance_to().intValue());
	       												 }
	       												 
	       													       	 
	       					//////////////////////////R21////////////////////////
	       							       				 
	       												 Row R20row = sheet.getRow(30);
	       												 Cell R20cell = R20row.getCell(3);
	       													 if (R20cell != null) {
	       												     R20cell.setCellValue(BRF34.getR21_inter_bank_place() == null ? 0 :
	       													     	BRF34.getR21_inter_bank_place().intValue());
	       													 }
	       													 
	       													Cell R20cell1 = R20row.getCell(4);
	       													 if (R20cell1 != null) {
	       												     R20cell1.setCellValue(BRF34.getR21_inter_bank_borrow() == null ? 0 :
	       													     	BRF34.getR21_inter_bank_borrow().intValue());
	       													 }
	       													 
	       													Cell R20cell2 = R20row.getCell(5);
	       													 if (R20cell2 != null) {
	       												     R20cell2.setCellValue(BRF34.getR21_other_placement() == null ? 0 :
	       													     	BRF34.getR21_other_placement().intValue());
	       													 }
	       													 
	       													Cell R20cell3 = R20row.getCell(6);
	       													 if (R20cell3 != null) {
	       												     R20cell3.setCellValue(BRF34.getR21_other_borrow() == null ? 0 :
	       													     	BRF34.getR21_other_borrow().intValue());
	       													 }
	       													 
	       												    Cell R20cell4 = R20row.getCell(7);
	       													 if (R20cell4 != null) {
	       												     R20cell4.setCellValue(BRF34.getR21_remani_balance_from() == null ? 0 :
	       													     	BRF34.getR21_remani_balance_from().intValue());
	       													 }
	       													 
	       													Cell R20cell5 = R20row.getCell(8);
	       													 if (R20cell5 != null) {
	       												     R20cell5.setCellValue(BRF34.getR21_remani_balance_to() == null ? 0 :
	       													     	BRF34.getR21_remani_balance_to().intValue());
	       													 }
	       													 //////////////////////////R22////////////////////////
	       													 
	       													 Row R21row = sheet.getRow(31);
	       													 Cell R21cell = R21row.getCell(3);
	       														 if (R21cell != null) {
	       													     R21cell.setCellValue(BRF34.getR22_inter_bank_place() == null ? 0 :
	       														     	BRF34.getR22_inter_bank_place().intValue());
	       														 }
	       														 
	       														Cell R21cell1 = R21row.getCell(4);
	       														 if (R21cell1 != null) {
	       													     R21cell1.setCellValue(BRF34.getR22_inter_bank_borrow() == null ? 0 :
	       														     	BRF34.getR22_inter_bank_borrow().intValue());
	       														 }
	       														 
	       														Cell R21cell2 = R21row.getCell(5);
	       														 if (R21cell2 != null) {
	       													     R21cell2.setCellValue(BRF34.getR22_other_placement() == null ? 0 :
	       														     	BRF34.getR22_other_placement().intValue());
	       														 }
	       														 
	       														Cell R21cell3 = R21row.getCell(6);
	       														 if (R21cell3 != null) {
	       													     R21cell3.setCellValue(BRF34.getR22_other_borrow() == null ? 0 :
	       														     	BRF34.getR22_other_borrow().intValue());
	       														 }
	       														 
	       													    Cell R21cell4 = R21row.getCell(7);
	       														 if (R21cell4 != null) {
	       													     R21cell4.setCellValue(BRF34.getR22_remani_balance_from() == null ? 0 :
	       														     	BRF34.getR22_remani_balance_from().intValue());
	       														 }
	       														 
	       														Cell R21cell5 = R21row.getCell(8);
	       														 if (R21cell5 != null) {
	       													     R21cell5.setCellValue(BRF34.getR22_remani_balance_to() == null ? 0 :
	       														     	BRF34.getR22_remani_balance_to().intValue());
	       														 }

	       														 
	       														 
	       												 //////////////////////////R23////////////////////////
	       												 
	       												 Row R22row = sheet.getRow(32);
	       												 Cell R22cell = R22row.getCell(3);
	       													 if (R22cell != null) {
	       												     R22cell.setCellValue(BRF34.getR23_inter_bank_place() == null ? 0 :
	       													     	BRF34.getR23_inter_bank_place().intValue());
	       													 }
	       													 
	       													Cell R22cell1 = R22row.getCell(4);
	       													 if (R22cell1 != null) {
	       												     R22cell1.setCellValue(BRF34.getR23_inter_bank_borrow() == null ? 0 :
	       													     	BRF34.getR23_inter_bank_borrow().intValue());
	       													 }
	       													 
	       													Cell R22cell2 = R22row.getCell(5);
	       													 if (R22cell2 != null) {
	       												     R22cell2.setCellValue(BRF34.getR23_other_placement() == null ? 0 :
	       													     	BRF34.getR23_other_placement().intValue());
	       													 }
	       													 
	       													Cell R22cell3 = R22row.getCell(6);
	       													 if (R22cell3 != null) {
	       												     R22cell3.setCellValue(BRF34.getR23_other_borrow() == null ? 0 :
	       													     	BRF34.getR23_other_borrow().intValue());
	       													 }
	       													 
	       												    Cell R22cell4 = R22row.getCell(7);
	       													 if (R22cell4 != null) {
	       												     R22cell4.setCellValue(BRF34.getR23_remani_balance_from() == null ? 0 :
	       													     	BRF34.getR23_remani_balance_from().intValue());
	       													 }
	       													 
	       													Cell R22cell5 = R22row.getCell(8);
	       													 if (R22cell5 != null) {
	       												     R22cell5.setCellValue(BRF34.getR23_remani_balance_to() == null ? 0 :
	       													     	BRF34.getR23_remani_balance_to().intValue());
	       													 }
	       													 


	       													 //////////////////////////R24////////////////////////
	       													 
	       													 Row R23row = sheet.getRow(33);
	       													 Cell R23cell = R23row.getCell(3);
	       														 if (R23cell != null) {
	       													     R23cell.setCellValue(BRF34.getR24_inter_bank_place() == null ? 0 :
	       														     	BRF34.getR24_inter_bank_place().intValue());
	       														 }
	       														 
	       														Cell R23cell1 = R23row.getCell(4);
	       														 if (R23cell1 != null) {
	       													     R23cell1.setCellValue(BRF34.getR24_inter_bank_borrow() == null ? 0 :
	       														     	BRF34.getR24_inter_bank_borrow().intValue());
	       														 }
	       														 
	       														Cell R23cell2 = R23row.getCell(5);
	       														 if (R23cell2 != null) {
	       													     R23cell2.setCellValue(BRF34.getR24_other_placement() == null ? 0 :
	       														     	BRF34.getR24_other_placement().intValue());
	       														 }
	       														 
	       														Cell R23cell3 = R23row.getCell(6);
	       														 if (R23cell3 != null) {
	       													     R23cell3.setCellValue(BRF34.getR24_other_borrow() == null ? 0 :
	       														     	BRF34.getR24_other_borrow().intValue());
	       														 }
	       														 
	       													    Cell R23cell4 = R23row.getCell(7);
	       														 if (R23cell4 != null) {
	       													     R23cell4.setCellValue(BRF34.getR24_remani_balance_from() == null ? 0 :
	       														     	BRF34.getR24_remani_balance_from().intValue());
	       														 }
	       														 
	       														Cell R23cell5 = R23row.getCell(8);
	       														 if (R23cell5 != null) {
	       													     R23cell5.setCellValue(BRF34.getR24_remani_balance_to() == null ? 0 :
	       														     	BRF34.getR24_remani_balance_to().intValue());
	       														 }
	       												//////////////////////////R25////////////////////////

	       												Row R24row = sheet.getRow(34);
	       												Cell R24cell = R24row.getCell(3);
	       													 if (R24cell != null) {
	       												    R24cell.setCellValue(BRF34.getR25_inter_bank_place() == null ? 0 :
	       													     	BRF34.getR25_inter_bank_place().intValue());
	       													 }
	       													 
	       													Cell R24cell1 = R24row.getCell(4);
	       													 if (R24cell1 != null) {
	       												    R24cell1.setCellValue(BRF34.getR25_inter_bank_borrow() == null ? 0 :
	       													     	BRF34.getR25_inter_bank_borrow().intValue());
	       													 }
	       													 
	       													Cell R24cell2 = R24row.getCell(5);
	       													 if (R24cell2 != null) {
	       												    R24cell2.setCellValue(BRF34.getR25_other_placement() == null ? 0 :
	       													     	BRF34.getR25_other_placement().intValue());
	       													 }
	       													 
	       													Cell R24cell3 = R24row.getCell(6);
	       													 if (R24cell3 != null) {
	       												    R24cell3.setCellValue(BRF34.getR25_other_borrow() == null ? 0 :
	       													     	BRF34.getR25_other_borrow().intValue());
	       													 }
	       													 
	       												   Cell R24cell4 = R24row.getCell(7);
	       													 if (R24cell4 != null) {
	       												    R24cell4.setCellValue(BRF34.getR25_remani_balance_from() == null ? 0 :
	       													     	BRF34.getR25_remani_balance_from().intValue());
	       													 }
	       													 
	       													Cell R24cell5 = R24row.getCell(8);
	       													 if (R24cell5 != null) {
	       												    R24cell5.setCellValue(BRF34.getR25_remani_balance_to() == null ? 0 :
	       													     	BRF34.getR25_remani_balance_to().intValue());
	       													 }
	       													 
	       													 
	       												 //////////////////////////R26////////////////////////
	       												 
	       												 Row R25row = sheet.getRow(35);
	       												 Cell R25cell = R25row.getCell(3);
	       													 if (R25cell != null) {
	       												     R25cell.setCellValue(BRF34.getR26_inter_bank_place() == null ? 0 :
	       													     	BRF34.getR26_inter_bank_place().intValue());
	       													 }
	       													 
	       													Cell R25cell1 = R25row.getCell(4);
	       													 if (R25cell1 != null) {
	       												     R25cell1.setCellValue(BRF34.getR26_inter_bank_borrow() == null ? 0 :
	       													     	BRF34.getR26_inter_bank_borrow().intValue());
	       													 }
	       													 
	       													Cell R25cell2 = R25row.getCell(5);
	       													 if (R25cell2 != null) {
	       												     R25cell2.setCellValue(BRF34.getR26_other_placement() == null ? 0 :
	       													     	BRF34.getR26_other_placement().intValue());
	       													 }
	       													 
	       													Cell R25cell3 = R25row.getCell(6);
	       													 if (R25cell3 != null) {
	       												     R25cell3.setCellValue(BRF34.getR26_other_borrow() == null ? 0 :
	       													     	BRF34.getR26_other_borrow().intValue());
	       													 }
	       													 
	       												    Cell R25cell4 = R25row.getCell(7);
	       													 if (R25cell4 != null) {
	       												     R25cell4.setCellValue(BRF34.getR26_remani_balance_from() == null ? 0 :
	       													     	BRF34.getR26_remani_balance_from().intValue());
	       													 }
	       													 
	       													Cell R25cell5 = R25row.getCell(8);
	       													 if (R25cell5 != null) {
	       												     R25cell5.setCellValue(BRF34.getR26_remani_balance_to() == null ? 0 :
	       													     	BRF34.getR26_remani_balance_to().intValue());
	       													 }
	       													 
	       													 //////////////////////////R27////////////////////////
	       													 
	       													 Row R26row = sheet.getRow(36);
	       													 Cell R26cell = R26row.getCell(3);
	       														 if (R26cell != null) {
	       													     R26cell.setCellValue(BRF34.getR27_inter_bank_place() == null ? 0 :
	       														     	BRF34.getR27_inter_bank_place().intValue());
	       														 }
	       														 
	       												Cell R26cell1 = R26row.getCell(4);
	       												 if (R26cell1 != null) {
	       												 R26cell1.setCellValue(BRF34.getR27_inter_bank_borrow() == null ? 0 :
	       												     	BRF34.getR27_inter_bank_borrow().intValue());
	       												 }
	       												 
	       												Cell R26cell2 = R26row.getCell(5);
	       												 if (R26cell2 != null) {
	       												 R26cell2.setCellValue(BRF34.getR27_other_placement() == null ? 0 :
	       												     	BRF34.getR27_other_placement().intValue());
	       												 }
	       												 
	       												Cell R26cell3 = R26row.getCell(6);
	       												 if (R26cell3 != null) {
	       												 R26cell3.setCellValue(BRF34.getR27_other_borrow() == null ? 0 :
	       												     	BRF34.getR27_other_borrow().intValue());
	       												 }
	       												 
	       												Cell R26cell4 = R26row.getCell(7);
	       												 if (R26cell4 != null) {
	       												 R26cell4.setCellValue(BRF34.getR27_remani_balance_from() == null ? 0 :
	       												     	BRF34.getR27_remani_balance_from().intValue());
	       												 }
	       												 
	       												Cell R26cell5 = R26row.getCell(8);
	       												 if (R26cell5 != null) {
	       												 R26cell5.setCellValue(BRF34.getR27_remani_balance_to() == null ? 0 :
	       												     	BRF34.getR27_remani_balance_to().intValue());
	       												 }
	       												 
	       												 
	       												 
	       												 //////////////////////////R28////////////////////////
	       												 
	       												 Row R27row = sheet.getRow(37);
	       												 Cell R27cell = R27row.getCell(3);
	       													 if (R27cell != null) {
	       												     R27cell.setCellValue(BRF34.getR28_inter_bank_place() == null ? 0 :
	       													     	BRF34.getR28_inter_bank_place().intValue());
	       													 }
	       													 
	       													Cell R27cell1 = R27row.getCell(4);
	       													 if (R27cell1 != null) {
	       												     R27cell1.setCellValue(BRF34.getR28_inter_bank_borrow() == null ? 0 :
	       													     	BRF34.getR28_inter_bank_borrow().intValue());
	       													 }
	       													 
	       													Cell R27cell2 = R27row.getCell(5);
	       													 if (R27cell2 != null) {
	       												     R27cell2.setCellValue(BRF34.getR28_other_placement() == null ? 0 :
	       													     	BRF34.getR28_other_placement().intValue());
	       													 }
	       													 
	       													Cell R27cell3 = R27row.getCell(6);
	       													 if (R27cell3 != null) {
	       												     R27cell3.setCellValue(BRF34.getR28_other_borrow() == null ? 0 :
	       													     	BRF34.getR28_other_borrow().intValue());
	       													 }
	       													 
	       												    Cell R27cell4 = R27row.getCell(7);
	       													 if (R27cell4 != null) {
	       												     R27cell4.setCellValue(BRF34.getR28_remani_balance_from() == null ? 0 :
	       													     	BRF34.getR28_remani_balance_from().intValue());
	       													 }
	       													 
	       													Cell R27cell5 = R27row.getCell(8);
	       													 if (R27cell5 != null) {
	       												     R27cell5.setCellValue(BRF34.getR28_remani_balance_to() == null ? 0 :
	       													     	BRF34.getR28_remani_balance_to().intValue());
	       													 }


	       													 //////////////////////////R29////////////////////////
	       													 
	       													 Row R28row = sheet.getRow(38);
	       													 Cell R28cell = R28row.getCell(3);
	       														 if (R28cell != null) {
	       													     R28cell.setCellValue(BRF34.getR29_inter_bank_place() == null ? 0 :
	       														     	BRF34.getR29_inter_bank_place().intValue());
	       														 }
	       														 
	       												 Cell R28cell1 = R28row.getCell(4);
	       												  if (R28cell1 != null) {
	       												  R28cell1.setCellValue(BRF34.getR29_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR29_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R28cell2 = R28row.getCell(5);
	       												  if (R28cell2 != null) {
	       												  R28cell2.setCellValue(BRF34.getR29_other_placement() == null ? 0 :
	       												      	BRF34.getR29_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R28cell3 = R28row.getCell(6);
	       												  if (R28cell3 != null) {
	       												  R28cell3.setCellValue(BRF34.getR29_other_borrow() == null ? 0 :
	       												      	BRF34.getR29_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R28cell4 = R28row.getCell(7);
	       												  if (R28cell4 != null) {
	       												  R28cell4.setCellValue(BRF34.getR29_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR29_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R28cell5 = R28row.getCell(8);
	       												  if (R28cell5 != null) {
	       												  R28cell5.setCellValue(BRF34.getR29_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR29_remani_balance_to().intValue());
	       												  }
	       												 
	       												  //////////////////////////R30////////////////////////
	       												  
	       												  Row R29row = sheet.getRow(39);
	       												  Cell R29cell = R29row.getCell(3);
	       												 	 if (R29cell != null) {
	       												      R29cell.setCellValue(BRF34.getR30_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR30_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R29cell1 = R29row.getCell(4);
	       												 	 if (R29cell1 != null) {
	       												      R29cell1.setCellValue(BRF34.getR30_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR30_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R29cell2 = R29row.getCell(5);
	       												 	 if (R29cell2 != null) {
	       												      R29cell2.setCellValue(BRF34.getR30_other_placement() == null ? 0 :
	       												 	     	BRF34.getR30_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R29cell3 = R29row.getCell(6);
	       												 	 if (R29cell3 != null) {
	       												      R29cell3.setCellValue(BRF34.getR30_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR30_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R29cell4 = R29row.getCell(7);
	       												 	 if (R29cell4 != null) {
	       												      R29cell4.setCellValue(BRF34.getR30_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR30_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R29cell5 = R29row.getCell(8);
	       												 	 if (R29cell5 != null) {
	       												      R29cell5.setCellValue(BRF34.getR30_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR30_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       						//////////////////////////R31////////////////////////
	       								       				 
	       												  Row R30row = sheet.getRow(40);
	       												  Cell R30cell = R30row.getCell(3);
	       												 	 if (R30cell != null) {
	       												      R30cell.setCellValue(BRF34.getR31_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR31_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R30cell1 = R30row.getCell(4);
	       												 	 if (R30cell1 != null) {
	       												      R30cell1.setCellValue(BRF34.getR31_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR31_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R30cell2 = R30row.getCell(5);
	       												 	 if (R30cell2 != null) {
	       												      R30cell2.setCellValue(BRF34.getR31_other_placement() == null ? 0 :
	       												 	     	BRF34.getR31_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R30cell3 = R30row.getCell(6);
	       												 	 if (R30cell3 != null) {
	       												      R30cell3.setCellValue(BRF34.getR31_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR31_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R30cell4 = R30row.getCell(7);
	       												 	 if (R30cell4 != null) {
	       												      R30cell4.setCellValue(BRF34.getR31_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR31_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R30cell5 = R30row.getCell(8);
	       												 	 if (R30cell5 != null) {
	       												      R30cell5.setCellValue(BRF34.getR31_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR31_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R32////////////////////////
	       												 	 
	       												 	 Row R31row = sheet.getRow(41);
	       												 	 Cell R31cell = R31row.getCell(3);
	       												 		 if (R31cell != null) {
	       												 	     R31cell.setCellValue(BRF34.getR32_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR32_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R31cell1 = R31row.getCell(4);
	       												 		 if (R31cell1 != null) {
	       												 	     R31cell1.setCellValue(BRF34.getR32_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR32_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R31cell2 = R31row.getCell(5);
	       												 		 if (R31cell2 != null) {
	       												 	     R31cell2.setCellValue(BRF34.getR32_other_placement() == null ? 0 :
	       												 		     	BRF34.getR32_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R31cell3 = R31row.getCell(6);
	       												 		 if (R31cell3 != null) {
	       												 	     R31cell3.setCellValue(BRF34.getR32_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR32_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R31cell4 = R31row.getCell(7);
	       												 		 if (R31cell4 != null) {
	       												 	     R31cell4.setCellValue(BRF34.getR32_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR32_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R31cell5 = R31row.getCell(8);
	       												 		 if (R31cell5 != null) {
	       												 	     R31cell5.setCellValue(BRF34.getR32_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR32_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R33////////////////////////
	       												  
	       												  Row R32row = sheet.getRow(42);
	       												  Cell R32cell = R32row.getCell(3);
	       												 	 if (R32cell != null) {
	       												      R32cell.setCellValue(BRF34.getR33_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR33_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R32cell1 = R32row.getCell(4);
	       												 	 if (R32cell1 != null) {
	       												      R32cell1.setCellValue(BRF34.getR33_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR33_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R32cell2 = R32row.getCell(5);
	       												 	 if (R32cell2 != null) {
	       												      R32cell2.setCellValue(BRF34.getR33_other_placement() == null ? 0 :
	       												 	     	BRF34.getR33_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R32cell3 = R32row.getCell(6);
	       												 	 if (R32cell3 != null) {
	       												      R32cell3.setCellValue(BRF34.getR33_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR33_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R32cell4 = R32row.getCell(7);
	       												 	 if (R32cell4 != null) {
	       												      R32cell4.setCellValue(BRF34.getR33_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR33_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R32cell5 = R32row.getCell(8);
	       												 	 if (R32cell5 != null) {
	       												      R32cell5.setCellValue(BRF34.getR33_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR33_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R34////////////////////////
	       												 	 
	       												 	 Row R33row = sheet.getRow(43);
	       												 	 Cell R33cell = R33row.getCell(3);
	       												 		 if (R33cell != null) {
	       												 	     R33cell.setCellValue(BRF34.getR34_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR34_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R33cell1 = R33row.getCell(4);
	       												 		 if (R33cell1 != null) {
	       												 	     R33cell1.setCellValue(BRF34.getR34_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR34_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R33cell2 = R33row.getCell(5);
	       												 		 if (R33cell2 != null) {
	       												 	     R33cell2.setCellValue(BRF34.getR34_other_placement() == null ? 0 :
	       												 		     	BRF34.getR34_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R33cell3 = R33row.getCell(6);
	       												 		 if (R33cell3 != null) {
	       												 	     R33cell3.setCellValue(BRF34.getR34_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR34_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R33cell4 = R33row.getCell(7);
	       												 		 if (R33cell4 != null) {
	       												 	     R33cell4.setCellValue(BRF34.getR34_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR34_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R33cell5 = R33row.getCell(8);
	       												 		 if (R33cell5 != null) {
	       												 	     R33cell5.setCellValue(BRF34.getR34_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR34_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R35////////////////////////

	       												 Row R34row = sheet.getRow(44);
	       												 Cell R34cell = R34row.getCell(3);
	       												 	 if (R34cell != null) {
	       												     R34cell.setCellValue(BRF34.getR35_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR35_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R34cell1 = R34row.getCell(4);
	       												 	 if (R34cell1 != null) {
	       												     R34cell1.setCellValue(BRF34.getR35_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR35_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R34cell2 = R34row.getCell(5);
	       												 	 if (R34cell2 != null) {
	       												     R34cell2.setCellValue(BRF34.getR35_other_placement() == null ? 0 :
	       												 	     	BRF34.getR35_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R34cell3 = R34row.getCell(6);
	       												 	 if (R34cell3 != null) {
	       												     R34cell3.setCellValue(BRF34.getR35_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR35_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R34cell4 = R34row.getCell(7);
	       												 	 if (R34cell4 != null) {
	       												     R34cell4.setCellValue(BRF34.getR35_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR35_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R34cell5 = R34row.getCell(8);
	       												 	 if (R34cell5 != null) {
	       												     R34cell5.setCellValue(BRF34.getR35_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR35_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R36////////////////////////
	       												  
	       												  Row R35row = sheet.getRow(45);
	       												  Cell R35cell = R35row.getCell(3);
	       												 	 if (R35cell != null) {
	       												      R35cell.setCellValue(BRF34.getR36_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR36_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R35cell1 = R35row.getCell(4);
	       												 	 if (R35cell1 != null) {
	       												      R35cell1.setCellValue(BRF34.getR36_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR36_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R35cell2 = R35row.getCell(5);
	       												 	 if (R35cell2 != null) {
	       												      R35cell2.setCellValue(BRF34.getR36_other_placement() == null ? 0 :
	       												 	     	BRF34.getR36_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R35cell3 = R35row.getCell(6);
	       												 	 if (R35cell3 != null) {
	       												      R35cell3.setCellValue(BRF34.getR36_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR36_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R35cell4 = R35row.getCell(7);
	       												 	 if (R35cell4 != null) {
	       												      R35cell4.setCellValue(BRF34.getR36_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR36_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R35cell5 = R35row.getCell(8);
	       												 	 if (R35cell5 != null) {
	       												      R35cell5.setCellValue(BRF34.getR36_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR36_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R37////////////////////////
	       												 	 
	       												 	 Row R36row = sheet.getRow(47);
	       												 	 Cell R36cell = R36row.getCell(3);
	       												 		 if (R36cell != null) {
	       												 	     R36cell.setCellValue(BRF34.getR37_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR37_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R36cell1 = R36row.getCell(4);
	       												  if (R36cell1 != null) {
	       												  R36cell1.setCellValue(BRF34.getR37_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR37_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R36cell2 = R36row.getCell(5);
	       												  if (R36cell2 != null) {
	       												  R36cell2.setCellValue(BRF34.getR37_other_placement() == null ? 0 :
	       												      	BRF34.getR37_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R36cell3 = R36row.getCell(6);
	       												  if (R36cell3 != null) {
	       												  R36cell3.setCellValue(BRF34.getR37_other_borrow() == null ? 0 :
	       												      	BRF34.getR37_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R36cell4 = R36row.getCell(7);
	       												  if (R36cell4 != null) {
	       												  R36cell4.setCellValue(BRF34.getR37_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR37_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R36cell5 = R36row.getCell(8);
	       												  if (R36cell5 != null) {
	       												  R36cell5.setCellValue(BRF34.getR37_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR37_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R38////////////////////////
	       												  
	       												  Row R37row = sheet.getRow(48);
	       												  Cell R37cell = R37row.getCell(3);
	       												 	 if (R37cell != null) {
	       												      R37cell.setCellValue(BRF34.getR38_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR38_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R37cell1 = R37row.getCell(4);
	       												 	 if (R37cell1 != null) {
	       												      R37cell1.setCellValue(BRF34.getR38_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR38_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R37cell2 = R37row.getCell(5);
	       												 	 if (R37cell2 != null) {
	       												      R37cell2.setCellValue(BRF34.getR38_other_placement() == null ? 0 :
	       												 	     	BRF34.getR38_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R37cell3 = R37row.getCell(6);
	       												 	 if (R37cell3 != null) {
	       												      R37cell3.setCellValue(BRF34.getR38_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR38_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R37cell4 = R37row.getCell(7);
	       												 	 if (R37cell4 != null) {
	       												      R37cell4.setCellValue(BRF34.getR38_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR38_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R37cell5 = R37row.getCell(8);
	       												 	 if (R37cell5 != null) {
	       												      R37cell5.setCellValue(BRF34.getR38_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR38_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R39////////////////////////
	       												 	 
	       												 	 Row R38row = sheet.getRow(49);
	       												 	 Cell R38cell = R38row.getCell(3);
	       												 		 if (R38cell != null) {
	       												 	     R38cell.setCellValue(BRF34.getR39_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR39_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R38cell1 = R38row.getCell(4);
	       												   if (R38cell1 != null) {
	       												   R38cell1.setCellValue(BRF34.getR39_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR39_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R38cell2 = R38row.getCell(5);
	       												   if (R38cell2 != null) {
	       												   R38cell2.setCellValue(BRF34.getR39_other_placement() == null ? 0 :
	       												       	BRF34.getR39_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R38cell3 = R38row.getCell(6);
	       												   if (R38cell3 != null) {
	       												   R38cell3.setCellValue(BRF34.getR39_other_borrow() == null ? 0 :
	       												       	BRF34.getR39_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R38cell4 = R38row.getCell(7);
	       												   if (R38cell4 != null) {
	       												   R38cell4.setCellValue(BRF34.getR39_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR39_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R38cell5 = R38row.getCell(8);
	       												   if (R38cell5 != null) {
	       												   R38cell5.setCellValue(BRF34.getR39_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR39_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R40////////////////////////
	       												   
	       												   Row R39row = sheet.getRow(50);
	       												   Cell R39cell = R39row.getCell(3);
	       												  	 if (R39cell != null) {
	       												       R39cell.setCellValue(BRF34.getR40_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR40_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R39cell1 = R39row.getCell(4);
	       												  	 if (R39cell1 != null) {
	       												       R39cell1.setCellValue(BRF34.getR40_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR40_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R39cell2 = R39row.getCell(5);
	       												  	 if (R39cell2 != null) {
	       												       R39cell2.setCellValue(BRF34.getR40_other_placement() == null ? 0 :
	       												  	     	BRF34.getR40_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R39cell3 = R39row.getCell(6);
	       												  	 if (R39cell3 != null) {
	       												       R39cell3.setCellValue(BRF34.getR40_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR40_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R39cell4 = R39row.getCell(7);
	       												  	 if (R39cell4 != null) {
	       												       R39cell4.setCellValue(BRF34.getR40_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR40_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R39cell5 = R39row.getCell(8);
	       												  	 if (R39cell5 != null) {
	       												       R39cell5.setCellValue(BRF34.getR40_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR40_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       						//////////////////////////R41////////////////////////
	       								       				 
	       												  Row R40row = sheet.getRow(51);
	       												  Cell R40cell = R40row.getCell(3);
	       												 	 if (R40cell != null) {
	       												      R40cell.setCellValue(BRF34.getR41_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR41_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R40cell1 = R40row.getCell(4);
	       												 	 if (R40cell1 != null) {
	       												      R40cell1.setCellValue(BRF34.getR41_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR41_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R40cell2 = R40row.getCell(5);
	       												 	 if (R40cell2 != null) {
	       												      R40cell2.setCellValue(BRF34.getR41_other_placement() == null ? 0 :
	       												 	     	BRF34.getR41_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R40cell3 = R40row.getCell(6);
	       												 	 if (R40cell3 != null) {
	       												      R40cell3.setCellValue(BRF34.getR41_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR41_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R40cell4 = R40row.getCell(7);
	       												 	 if (R40cell4 != null) {
	       												      R40cell4.setCellValue(BRF34.getR41_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR41_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R40cell5 = R40row.getCell(8);
	       												 	 if (R40cell5 != null) {
	       												      R40cell5.setCellValue(BRF34.getR41_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR41_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R42////////////////////////
	       												 	 
	       												 	 Row R41row = sheet.getRow(52);
	       												 	 Cell R41cell = R41row.getCell(3);
	       												 		 if (R41cell != null) {
	       												 	     R41cell.setCellValue(BRF34.getR42_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR42_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R41cell1 = R41row.getCell(4);
	       												 		 if (R41cell1 != null) {
	       												 	     R41cell1.setCellValue(BRF34.getR42_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR42_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R41cell2 = R41row.getCell(5);
	       												 		 if (R41cell2 != null) {
	       												 	     R41cell2.setCellValue(BRF34.getR42_other_placement() == null ? 0 :
	       												 		     	BRF34.getR42_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R41cell3 = R41row.getCell(6);
	       												 		 if (R41cell3 != null) {
	       												 	     R41cell3.setCellValue(BRF34.getR42_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR42_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R41cell4 = R41row.getCell(7);
	       												 		 if (R41cell4 != null) {
	       												 	     R41cell4.setCellValue(BRF34.getR42_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR42_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R41cell5 = R41row.getCell(8);
	       												 		 if (R41cell5 != null) {
	       												 	     R41cell5.setCellValue(BRF34.getR42_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR42_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R43////////////////////////
	       												  
	       												  Row R42row = sheet.getRow(53);
	       												  Cell R42cell = R42row.getCell(3);
	       												 	 if (R42cell != null) {
	       												      R42cell.setCellValue(BRF34.getR43_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR43_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R42cell1 = R42row.getCell(4);
	       												 	 if (R42cell1 != null) {
	       												      R42cell1.setCellValue(BRF34.getR43_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR43_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R42cell2 = R42row.getCell(5);
	       												 	 if (R42cell2 != null) {
	       												      R42cell2.setCellValue(BRF34.getR43_other_placement() == null ? 0 :
	       												 	     	BRF34.getR43_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R42cell3 = R42row.getCell(6);
	       												 	 if (R42cell3 != null) {
	       												      R42cell3.setCellValue(BRF34.getR43_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR43_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R42cell4 = R42row.getCell(7);
	       												 	 if (R42cell4 != null) {
	       												      R42cell4.setCellValue(BRF34.getR43_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR43_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R42cell5 = R42row.getCell(8);
	       												 	 if (R42cell5 != null) {
	       												      R42cell5.setCellValue(BRF34.getR43_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR43_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R44////////////////////////
	       												 	 
	       												 	 Row R43row = sheet.getRow(55);
	       												 	 Cell R43cell = R43row.getCell(3);
	       												 		 if (R43cell != null) {
	       												 	     R43cell.setCellValue(BRF34.getR44_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR44_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R43cell1 = R43row.getCell(4);
	       												 		 if (R43cell1 != null) {
	       												 	     R43cell1.setCellValue(BRF34.getR44_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR44_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R43cell2 = R43row.getCell(5);
	       												 		 if (R43cell2 != null) {
	       												 	     R43cell2.setCellValue(BRF34.getR44_other_placement() == null ? 0 :
	       												 		     	BRF34.getR44_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R43cell3 = R43row.getCell(6);
	       												 		 if (R43cell3 != null) {
	       												 	     R43cell3.setCellValue(BRF34.getR44_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR44_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R43cell4 = R43row.getCell(7);
	       												 		 if (R43cell4 != null) {
	       												 	     R43cell4.setCellValue(BRF34.getR44_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR44_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R43cell5 = R43row.getCell(8);
	       												 		 if (R43cell5 != null) {
	       												 	     R43cell5.setCellValue(BRF34.getR44_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR44_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R45////////////////////////

	       												 Row R44row = sheet.getRow(56);
	       												 Cell R44cell = R44row.getCell(3);
	       												 	 if (R44cell != null) {
	       												     R44cell.setCellValue(BRF34.getR45_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR45_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R44cell1 = R44row.getCell(4);
	       												 	 if (R44cell1 != null) {
	       												     R44cell1.setCellValue(BRF34.getR45_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR45_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R44cell2 = R44row.getCell(5);
	       												 	 if (R44cell2 != null) {
	       												     R44cell2.setCellValue(BRF34.getR45_other_placement() == null ? 0 :
	       												 	     	BRF34.getR45_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R44cell3 = R44row.getCell(6);
	       												 	 if (R44cell3 != null) {
	       												     R44cell3.setCellValue(BRF34.getR45_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR45_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R44cell4 = R44row.getCell(7);
	       												 	 if (R44cell4 != null) {
	       												     R44cell4.setCellValue(BRF34.getR45_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR45_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R44cell5 = R44row.getCell(8);
	       												 	 if (R44cell5 != null) {
	       												     R44cell5.setCellValue(BRF34.getR45_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR45_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R46////////////////////////
	       												  
	       												  Row R45row = sheet.getRow(57);
	       												  Cell R45cell = R45row.getCell(3);
	       												 	 if (R45cell != null) {
	       												      R45cell.setCellValue(BRF34.getR46_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR46_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R45cell1 = R45row.getCell(4);
	       												 	 if (R45cell1 != null) {
	       												      R45cell1.setCellValue(BRF34.getR46_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR46_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R45cell2 = R45row.getCell(5);
	       												 	 if (R45cell2 != null) {
	       												      R45cell2.setCellValue(BRF34.getR46_other_placement() == null ? 0 :
	       												 	     	BRF34.getR46_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R45cell3 = R45row.getCell(6);
	       												 	 if (R45cell3 != null) {
	       												      R45cell3.setCellValue(BRF34.getR46_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR46_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R45cell4 = R45row.getCell(7);
	       												 	 if (R45cell4 != null) {
	       												      R45cell4.setCellValue(BRF34.getR46_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR46_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R45cell5 = R45row.getCell(8);
	       												 	 if (R45cell5 != null) {
	       												      R45cell5.setCellValue(BRF34.getR46_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR46_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R47////////////////////////
	       												 	 
	       												 	 Row R46row = sheet.getRow(58);
	       												 	 Cell R46cell = R46row.getCell(3);
	       												 		 if (R46cell != null) {
	       												 	     R46cell.setCellValue(BRF34.getR47_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR47_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R46cell1 = R46row.getCell(4);
	       												  if (R46cell1 != null) {
	       												  R46cell1.setCellValue(BRF34.getR47_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR47_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R46cell2 = R46row.getCell(5);
	       												  if (R46cell2 != null) {
	       												  R46cell2.setCellValue(BRF34.getR47_other_placement() == null ? 0 :
	       												      	BRF34.getR47_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R46cell3 = R46row.getCell(6);
	       												  if (R46cell3 != null) {
	       												  R46cell3.setCellValue(BRF34.getR47_other_borrow() == null ? 0 :
	       												      	BRF34.getR47_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R46cell4 = R46row.getCell(7);
	       												  if (R46cell4 != null) {
	       												  R46cell4.setCellValue(BRF34.getR47_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR47_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R46cell5 = R46row.getCell(8);
	       												  if (R46cell5 != null) {
	       												  R46cell5.setCellValue(BRF34.getR47_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR47_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R48////////////////////////
	       												  
	       												  Row R47row = sheet.getRow(59);
	       												  Cell R47cell = R47row.getCell(3);
	       												 	 if (R47cell != null) {
	       												      R47cell.setCellValue(BRF34.getR48_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR48_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R47cell1 = R47row.getCell(4);
	       												 	 if (R47cell1 != null) {
	       												      R47cell1.setCellValue(BRF34.getR48_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR48_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R47cell2 = R47row.getCell(5);
	       												 	 if (R47cell2 != null) {
	       												      R47cell2.setCellValue(BRF34.getR48_other_placement() == null ? 0 :
	       												 	     	BRF34.getR48_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R47cell3 = R47row.getCell(6);
	       												 	 if (R47cell3 != null) {
	       												      R47cell3.setCellValue(BRF34.getR48_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR48_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R47cell4 = R47row.getCell(7);
	       												 	 if (R47cell4 != null) {
	       												      R47cell4.setCellValue(BRF34.getR48_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR48_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R47cell5 = R47row.getCell(8);
	       												 	 if (R47cell5 != null) {
	       												      R47cell5.setCellValue(BRF34.getR48_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR48_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R49////////////////////////
	       												 	 
	       												 	 Row R48row = sheet.getRow(60);
	       												 	 Cell R48cell = R48row.getCell(3);
	       												 		 if (R48cell != null) {
	       												 	     R48cell.setCellValue(BRF34.getR49_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR49_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R48cell1 = R48row.getCell(4);
	       												   if (R48cell1 != null) {
	       												   R48cell1.setCellValue(BRF34.getR49_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR49_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R48cell2 = R48row.getCell(5);
	       												   if (R48cell2 != null) {
	       												   R48cell2.setCellValue(BRF34.getR49_other_placement() == null ? 0 :
	       												       	BRF34.getR49_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R48cell3 = R48row.getCell(6);
	       												   if (R48cell3 != null) {
	       												   R48cell3.setCellValue(BRF34.getR49_other_borrow() == null ? 0 :
	       												       	BRF34.getR49_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R48cell4 = R48row.getCell(7);
	       												   if (R48cell4 != null) {
	       												   R48cell4.setCellValue(BRF34.getR49_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR49_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R48cell5 = R48row.getCell(8);
	       												   if (R48cell5 != null) {
	       												   R48cell5.setCellValue(BRF34.getR49_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR49_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R50////////////////////////
	       												   
	       												   Row R49row = sheet.getRow(61);
	       												   Cell R49cell = R49row.getCell(3);
	       												  	 if (R49cell != null) {
	       												       R49cell.setCellValue(BRF34.getR50_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR50_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R49cell1 = R49row.getCell(4);
	       												  	 if (R49cell1 != null) {
	       												       R49cell1.setCellValue(BRF34.getR50_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR50_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R49cell2 = R49row.getCell(5);
	       												  	 if (R49cell2 != null) {
	       												       R49cell2.setCellValue(BRF34.getR50_other_placement() == null ? 0 :
	       												  	     	BRF34.getR50_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R49cell3 = R49row.getCell(6);
	       												  	 if (R49cell3 != null) {
	       												       R49cell3.setCellValue(BRF34.getR50_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR50_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R49cell4 = R49row.getCell(7);
	       												  	 if (R49cell4 != null) {
	       												       R49cell4.setCellValue(BRF34.getR50_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR50_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R49cell5 = R49row.getCell(8);
	       												  	 if (R49cell5 != null) {
	       												       R49cell5.setCellValue(BRF34.getR50_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR50_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       						//////////////////////////R51////////////////////////
	       								       				 
	       												  Row R50row = sheet.getRow(62);
	       												  Cell R50cell = R50row.getCell(3);
	       												 	 if (R50cell != null) {
	       												      R50cell.setCellValue(BRF34.getR51_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR51_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R50cell1 = R50row.getCell(4);
	       												 	 if (R50cell1 != null) {
	       												      R50cell1.setCellValue(BRF34.getR51_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR51_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R50cell2 = R50row.getCell(5);
	       												 	 if (R50cell2 != null) {
	       												      R50cell2.setCellValue(BRF34.getR51_other_placement() == null ? 0 :
	       												 	     	BRF34.getR51_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R50cell3 = R50row.getCell(6);
	       												 	 if (R50cell3 != null) {
	       												      R50cell3.setCellValue(BRF34.getR51_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR51_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R50cell4 = R50row.getCell(7);
	       												 	 if (R50cell4 != null) {
	       												      R50cell4.setCellValue(BRF34.getR51_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR51_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R50cell5 = R50row.getCell(8);
	       												 	 if (R50cell5 != null) {
	       												      R50cell5.setCellValue(BRF34.getR51_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR51_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R52////////////////////////
	       												 	 
	       												 	 Row R51row = sheet.getRow(63);
	       												 	 Cell R51cell = R51row.getCell(3);
	       												 		 if (R51cell != null) {
	       												 	     R51cell.setCellValue(BRF34.getR52_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR52_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R51cell1 = R51row.getCell(4);
	       												 		 if (R51cell1 != null) {
	       												 	     R51cell1.setCellValue(BRF34.getR52_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR52_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R51cell2 = R51row.getCell(5);
	       												 		 if (R51cell2 != null) {
	       												 	     R51cell2.setCellValue(BRF34.getR52_other_placement() == null ? 0 :
	       												 		     	BRF34.getR52_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R51cell3 = R51row.getCell(6);
	       												 		 if (R51cell3 != null) {
	       												 	     R51cell3.setCellValue(BRF34.getR52_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR52_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R51cell4 = R51row.getCell(7);
	       												 		 if (R51cell4 != null) {
	       												 	     R51cell4.setCellValue(BRF34.getR52_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR52_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R51cell5 = R51row.getCell(8);
	       												 		 if (R51cell5 != null) {
	       												 	     R51cell5.setCellValue(BRF34.getR52_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR52_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R53////////////////////////
	       												  
	       												  Row R52row = sheet.getRow(64);
	       												  Cell R52cell = R52row.getCell(3);
	       												 	 if (R52cell != null) {
	       												      R52cell.setCellValue(BRF34.getR53_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR53_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R52cell1 = R52row.getCell(4);
	       												 	 if (R52cell1 != null) {
	       												      R52cell1.setCellValue(BRF34.getR53_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR53_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R52cell2 = R52row.getCell(5);
	       												 	 if (R52cell2 != null) {
	       												      R52cell2.setCellValue(BRF34.getR53_other_placement() == null ? 0 :
	       												 	     	BRF34.getR53_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R52cell3 = R52row.getCell(6);
	       												 	 if (R52cell3 != null) {
	       												      R52cell3.setCellValue(BRF34.getR53_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR53_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R52cell4 = R52row.getCell(7);
	       												 	 if (R52cell4 != null) {
	       												      R52cell4.setCellValue(BRF34.getR53_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR53_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R52cell5 = R52row.getCell(8);
	       												 	 if (R52cell5 != null) {
	       												      R52cell5.setCellValue(BRF34.getR53_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR53_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R54////////////////////////
	       												 	 
	       												 	 Row R53row = sheet.getRow(65);
	       												 	 Cell R53cell = R53row.getCell(3);
	       												 		 if (R53cell != null) {
	       												 	     R53cell.setCellValue(BRF34.getR54_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR54_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R53cell1 = R53row.getCell(4);
	       												 		 if (R53cell1 != null) {
	       												 	     R53cell1.setCellValue(BRF34.getR54_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR54_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R53cell2 = R53row.getCell(5);
	       												 		 if (R53cell2 != null) {
	       												 	     R53cell2.setCellValue(BRF34.getR54_other_placement() == null ? 0 :
	       												 		     	BRF34.getR54_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R53cell3 = R53row.getCell(6);
	       												 		 if (R53cell3 != null) {
	       												 	     R53cell3.setCellValue(BRF34.getR54_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR54_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R53cell4 = R53row.getCell(7);
	       												 		 if (R53cell4 != null) {
	       												 	     R53cell4.setCellValue(BRF34.getR54_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR54_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R53cell5 = R53row.getCell(8);
	       												 		 if (R53cell5 != null) {
	       												 	     R53cell5.setCellValue(BRF34.getR54_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR54_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R55////////////////////////

	       												 Row R54row = sheet.getRow(66);
	       												 Cell R54cell = R54row.getCell(3);
	       												 	 if (R54cell != null) {
	       												     R54cell.setCellValue(BRF34.getR55_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR55_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R54cell1 = R54row.getCell(4);
	       												 	 if (R54cell1 != null) {
	       												     R54cell1.setCellValue(BRF34.getR55_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR55_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R54cell2 = R54row.getCell(5);
	       												 	 if (R54cell2 != null) {
	       												     R54cell2.setCellValue(BRF34.getR55_other_placement() == null ? 0 :
	       												 	     	BRF34.getR55_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R54cell3 = R54row.getCell(6);
	       												 	 if (R54cell3 != null) {
	       												     R54cell3.setCellValue(BRF34.getR55_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR55_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R54cell4 = R54row.getCell(7);
	       												 	 if (R54cell4 != null) {
	       												     R54cell4.setCellValue(BRF34.getR55_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR55_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R54cell5 = R54row.getCell(8);
	       												 	 if (R54cell5 != null) {
	       												     R54cell5.setCellValue(BRF34.getR55_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR55_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R56////////////////////////
	       												  
	       												  Row R55row = sheet.getRow(67);
	       												  Cell R55cell = R55row.getCell(3);
	       												 	 if (R55cell != null) {
	       												      R55cell.setCellValue(BRF34.getR56_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR56_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R55cell1 = R55row.getCell(4);
	       												 	 if (R55cell1 != null) {
	       												      R55cell1.setCellValue(BRF34.getR56_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR56_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R55cell2 = R55row.getCell(5);
	       												 	 if (R55cell2 != null) {
	       												      R55cell2.setCellValue(BRF34.getR56_other_placement() == null ? 0 :
	       												 	     	BRF34.getR56_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R55cell3 = R55row.getCell(6);
	       												 	 if (R55cell3 != null) {
	       												      R55cell3.setCellValue(BRF34.getR56_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR56_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R55cell4 = R55row.getCell(7);
	       												 	 if (R55cell4 != null) {
	       												      R55cell4.setCellValue(BRF34.getR56_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR56_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R55cell5 = R55row.getCell(8);
	       												 	 if (R55cell5 != null) {
	       												      R55cell5.setCellValue(BRF34.getR56_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR56_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R57////////////////////////
	       												 	 
	       												 	 Row R56row = sheet.getRow(68);
	       												 	 Cell R56cell = R56row.getCell(3);
	       												 		 if (R56cell != null) {
	       												 	     R56cell.setCellValue(BRF34.getR57_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR57_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R56cell1 = R56row.getCell(4);
	       												  if (R56cell1 != null) {
	       												  R56cell1.setCellValue(BRF34.getR57_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR57_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R56cell2 = R56row.getCell(5);
	       												  if (R56cell2 != null) {
	       												  R56cell2.setCellValue(BRF34.getR57_other_placement() == null ? 0 :
	       												      	BRF34.getR57_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R56cell3 = R56row.getCell(6);
	       												  if (R56cell3 != null) {
	       												  R56cell3.setCellValue(BRF34.getR57_other_borrow() == null ? 0 :
	       												      	BRF34.getR57_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R56cell4 = R56row.getCell(7);
	       												  if (R56cell4 != null) {
	       												  R56cell4.setCellValue(BRF34.getR57_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR57_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R56cell5 = R56row.getCell(8);
	       												  if (R56cell5 != null) {
	       												  R56cell5.setCellValue(BRF34.getR57_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR57_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R58////////////////////////
	       												  
	       												  Row R57row = sheet.getRow(69);
	       												  Cell R57cell = R57row.getCell(3);
	       												 	 if (R57cell != null) {
	       												      R57cell.setCellValue(BRF34.getR58_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR58_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R57cell1 = R57row.getCell(4);
	       												 	 if (R57cell1 != null) {
	       												      R57cell1.setCellValue(BRF34.getR58_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR58_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R57cell2 = R57row.getCell(5);
	       												 	 if (R57cell2 != null) {
	       												      R57cell2.setCellValue(BRF34.getR58_other_placement() == null ? 0 :
	       												 	     	BRF34.getR58_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R57cell3 = R57row.getCell(6);
	       												 	 if (R57cell3 != null) {
	       												      R57cell3.setCellValue(BRF34.getR58_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR58_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R57cell4 = R57row.getCell(7);
	       												 	 if (R57cell4 != null) {
	       												      R57cell4.setCellValue(BRF34.getR58_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR58_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R57cell5 = R57row.getCell(8);
	       												 	 if (R57cell5 != null) {
	       												      R57cell5.setCellValue(BRF34.getR58_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR58_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R59////////////////////////
	       												 	 
	       												 	 Row R58row = sheet.getRow(70);
	       												 	 Cell R58cell = R58row.getCell(3);
	       												 		 if (R58cell != null) {
	       												 	     R58cell.setCellValue(BRF34.getR59_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR59_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R58cell1 = R58row.getCell(4);
	       												   if (R58cell1 != null) {
	       												   R58cell1.setCellValue(BRF34.getR59_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR59_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R58cell2 = R58row.getCell(5);
	       												   if (R58cell2 != null) {
	       												   R58cell2.setCellValue(BRF34.getR59_other_placement() == null ? 0 :
	       												       	BRF34.getR59_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R58cell3 = R58row.getCell(6);
	       												   if (R58cell3 != null) {
	       												   R58cell3.setCellValue(BRF34.getR59_other_borrow() == null ? 0 :
	       												       	BRF34.getR59_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R58cell4 = R58row.getCell(7);
	       												   if (R58cell4 != null) {
	       												   R58cell4.setCellValue(BRF34.getR59_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR59_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R58cell5 = R58row.getCell(8);
	       												   if (R58cell5 != null) {
	       												   R58cell5.setCellValue(BRF34.getR59_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR59_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R60////////////////////////
	       												   
	       												   Row R59row = sheet.getRow(71);
	       												   Cell R59cell = R59row.getCell(3);
	       												  	 if (R59cell != null) {
	       												       R59cell.setCellValue(BRF34.getR60_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR60_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R59cell1 = R59row.getCell(4);
	       												  	 if (R59cell1 != null) {
	       												       R59cell1.setCellValue(BRF34.getR60_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR60_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R59cell2 = R59row.getCell(5);
	       												  	 if (R59cell2 != null) {
	       												       R59cell2.setCellValue(BRF34.getR60_other_placement() == null ? 0 :
	       												  	     	BRF34.getR60_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R59cell3 = R59row.getCell(6);
	       												  	 if (R59cell3 != null) {
	       												       R59cell3.setCellValue(BRF34.getR60_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR60_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R59cell4 = R59row.getCell(7);
	       												  	 if (R59cell4 != null) {
	       												       R59cell4.setCellValue(BRF34.getR60_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR60_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R59cell5 = R59row.getCell(8);
	       												  	 if (R59cell5 != null) {
	       												       R59cell5.setCellValue(BRF34.getR60_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR60_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       												  	 
	       												  	 
	       						//////////////////////////R61////////////////////////
	       								       				 
	       												  Row R60row = sheet.getRow(72);
	       												  Cell R60cell = R60row.getCell(3);
	       												 	 if (R60cell != null) {
	       												      R60cell.setCellValue(BRF34.getR61_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR61_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R60cell1 = R60row.getCell(4);
	       												 	 if (R60cell1 != null) {
	       												      R60cell1.setCellValue(BRF34.getR61_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR61_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R60cell2 = R60row.getCell(5);
	       												 	 if (R60cell2 != null) {
	       												      R60cell2.setCellValue(BRF34.getR61_other_placement() == null ? 0 :
	       												 	     	BRF34.getR61_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R60cell3 = R60row.getCell(6);
	       												 	 if (R60cell3 != null) {
	       												      R60cell3.setCellValue(BRF34.getR61_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR61_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R60cell4 = R60row.getCell(7);
	       												 	 if (R60cell4 != null) {
	       												      R60cell4.setCellValue(BRF34.getR61_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR61_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R60cell5 = R60row.getCell(8);
	       												 	 if (R60cell5 != null) {
	       												      R60cell5.setCellValue(BRF34.getR61_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR61_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R62////////////////////////
	       												 	 
	       												 	 Row R61row = sheet.getRow(73);
	       												 	 Cell R61cell = R61row.getCell(3);
	       												 		 if (R61cell != null) {
	       												 	     R61cell.setCellValue(BRF34.getR62_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR62_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R61cell1 = R61row.getCell(4);
	       												 		 if (R61cell1 != null) {
	       												 	     R61cell1.setCellValue(BRF34.getR62_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR62_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R61cell2 = R61row.getCell(5);
	       												 		 if (R61cell2 != null) {
	       												 	     R61cell2.setCellValue(BRF34.getR62_other_placement() == null ? 0 :
	       												 		     	BRF34.getR62_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R61cell3 = R61row.getCell(6);
	       												 		 if (R61cell3 != null) {
	       												 	     R61cell3.setCellValue(BRF34.getR62_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR62_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R61cell4 = R61row.getCell(7);
	       												 		 if (R61cell4 != null) {
	       												 	     R61cell4.setCellValue(BRF34.getR62_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR62_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R61cell5 = R61row.getCell(8);
	       												 		 if (R61cell5 != null) {
	       												 	     R61cell5.setCellValue(BRF34.getR62_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR62_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R63////////////////////////
	       												  
	       												  Row R62row = sheet.getRow(74);
	       												  Cell R62cell = R62row.getCell(3);
	       												 	 if (R62cell != null) {
	       												      R62cell.setCellValue(BRF34.getR63_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR63_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R62cell1 = R62row.getCell(4);
	       												 	 if (R62cell1 != null) {
	       												      R62cell1.setCellValue(BRF34.getR63_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR63_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R62cell2 = R62row.getCell(5);
	       												 	 if (R62cell2 != null) {
	       												      R62cell2.setCellValue(BRF34.getR63_other_placement() == null ? 0 :
	       												 	     	BRF34.getR63_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R62cell3 = R62row.getCell(6);
	       												 	 if (R62cell3 != null) {
	       												      R62cell3.setCellValue(BRF34.getR63_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR63_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R62cell4 = R62row.getCell(7);
	       												 	 if (R62cell4 != null) {
	       												      R62cell4.setCellValue(BRF34.getR63_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR63_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R62cell5 = R62row.getCell(8);
	       												 	 if (R62cell5 != null) {
	       												      R62cell5.setCellValue(BRF34.getR63_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR63_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R64////////////////////////
	       												 	 
	       												 	 Row R63row = sheet.getRow(75);
	       												 	 Cell R63cell = R63row.getCell(3);
	       												 		 if (R63cell != null) {
	       												 	     R63cell.setCellValue(BRF34.getR64_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR64_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R63cell1 = R63row.getCell(4);
	       												 		 if (R63cell1 != null) {
	       												 	     R63cell1.setCellValue(BRF34.getR64_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR64_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R63cell2 = R63row.getCell(5);
	       												 		 if (R63cell2 != null) {
	       												 	     R63cell2.setCellValue(BRF34.getR64_other_placement() == null ? 0 :
	       												 		     	BRF34.getR64_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R63cell3 = R63row.getCell(6);
	       												 		 if (R63cell3 != null) {
	       												 	     R63cell3.setCellValue(BRF34.getR64_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR64_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R63cell4 = R63row.getCell(7);
	       												 		 if (R63cell4 != null) {
	       												 	     R63cell4.setCellValue(BRF34.getR64_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR64_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R63cell5 = R63row.getCell(8);
	       												 		 if (R63cell5 != null) {
	       												 	     R63cell5.setCellValue(BRF34.getR64_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR64_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R65////////////////////////

	       												 Row R64row = sheet.getRow(76);
	       												 Cell R64cell = R64row.getCell(3);
	       												 	 if (R64cell != null) {
	       												     R64cell.setCellValue(BRF34.getR65_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR65_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R64cell1 = R64row.getCell(4);
	       												 	 if (R64cell1 != null) {
	       												     R64cell1.setCellValue(BRF34.getR65_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR65_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R64cell2 = R64row.getCell(5);
	       												 	 if (R64cell2 != null) {
	       												     R64cell2.setCellValue(BRF34.getR65_other_placement() == null ? 0 :
	       												 	     	BRF34.getR65_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R64cell3 = R64row.getCell(6);
	       												 	 if (R64cell3 != null) {
	       												     R64cell3.setCellValue(BRF34.getR65_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR65_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R64cell4 = R64row.getCell(7);
	       												 	 if (R64cell4 != null) {
	       												     R64cell4.setCellValue(BRF34.getR65_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR65_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R64cell5 = R64row.getCell(8);
	       												 	 if (R64cell5 != null) {
	       												     R64cell5.setCellValue(BRF34.getR65_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR65_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R66////////////////////////
	       												  
	       												  Row R65row = sheet.getRow(77);
	       												  Cell R65cell = R65row.getCell(3);
	       												 	 if (R65cell != null) {
	       												      R65cell.setCellValue(BRF34.getR66_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR66_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R65cell1 = R65row.getCell(4);
	       												 	 if (R65cell1 != null) {
	       												      R65cell1.setCellValue(BRF34.getR66_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR66_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R65cell2 = R65row.getCell(5);
	       												 	 if (R65cell2 != null) {
	       												      R65cell2.setCellValue(BRF34.getR66_other_placement() == null ? 0 :
	       												 	     	BRF34.getR66_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R65cell3 = R65row.getCell(6);
	       												 	 if (R65cell3 != null) {
	       												      R65cell3.setCellValue(BRF34.getR66_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR66_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R65cell4 = R65row.getCell(7);
	       												 	 if (R65cell4 != null) {
	       												      R65cell4.setCellValue(BRF34.getR66_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR66_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R65cell5 = R65row.getCell(8);
	       												 	 if (R65cell5 != null) {
	       												      R65cell5.setCellValue(BRF34.getR66_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR66_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R67////////////////////////
	       												 	 
	       												 	 Row R66row = sheet.getRow(78);
	       												 	 Cell R66cell = R66row.getCell(3);
	       												 		 if (R66cell != null) {
	       												 	     R66cell.setCellValue(BRF34.getR67_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR67_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R66cell1 = R66row.getCell(4);
	       												  if (R66cell1 != null) {
	       												  R66cell1.setCellValue(BRF34.getR67_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR67_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R66cell2 = R66row.getCell(5);
	       												  if (R66cell2 != null) {
	       												  R66cell2.setCellValue(BRF34.getR67_other_placement() == null ? 0 :
	       												      	BRF34.getR67_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R66cell3 = R66row.getCell(6);
	       												  if (R66cell3 != null) {
	       												  R66cell3.setCellValue(BRF34.getR67_other_borrow() == null ? 0 :
	       												      	BRF34.getR67_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R66cell4 = R66row.getCell(7);
	       												  if (R66cell4 != null) {
	       												  R66cell4.setCellValue(BRF34.getR67_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR67_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R66cell5 = R66row.getCell(8);
	       												  if (R66cell5 != null) {
	       												  R66cell5.setCellValue(BRF34.getR67_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR67_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R68////////////////////////
	       												  
	       												  Row R67row = sheet.getRow(79);
	       												  Cell R67cell = R67row.getCell(3);
	       												 	 if (R67cell != null) {
	       												      R67cell.setCellValue(BRF34.getR68_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR68_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R67cell1 = R67row.getCell(4);
	       												 	 if (R67cell1 != null) {
	       												      R67cell1.setCellValue(BRF34.getR68_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR68_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R67cell2 = R67row.getCell(5);
	       												 	 if (R67cell2 != null) {
	       												      R67cell2.setCellValue(BRF34.getR68_other_placement() == null ? 0 :
	       												 	     	BRF34.getR68_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R67cell3 = R67row.getCell(6);
	       												 	 if (R67cell3 != null) {
	       												      R67cell3.setCellValue(BRF34.getR68_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR68_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R67cell4 = R67row.getCell(7);
	       												 	 if (R67cell4 != null) {
	       												      R67cell4.setCellValue(BRF34.getR68_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR68_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R67cell5 = R67row.getCell(8);
	       												 	 if (R67cell5 != null) {
	       												      R67cell5.setCellValue(BRF34.getR68_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR68_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R69////////////////////////
	       												 	 
	       												 	 Row R68row = sheet.getRow(80);
	       												 	 Cell R68cell = R68row.getCell(3);
	       												 		 if (R68cell != null) {
	       												 	     R68cell.setCellValue(BRF34.getR69_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR69_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R68cell1 = R68row.getCell(4);
	       												   if (R68cell1 != null) {
	       												   R68cell1.setCellValue(BRF34.getR69_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR69_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R68cell2 = R68row.getCell(5);
	       												   if (R68cell2 != null) {
	       												   R68cell2.setCellValue(BRF34.getR69_other_placement() == null ? 0 :
	       												       	BRF34.getR69_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R68cell3 = R68row.getCell(6);
	       												   if (R68cell3 != null) {
	       												   R68cell3.setCellValue(BRF34.getR69_other_borrow() == null ? 0 :
	       												       	BRF34.getR69_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R68cell4 = R68row.getCell(7);
	       												   if (R68cell4 != null) {
	       												   R68cell4.setCellValue(BRF34.getR69_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR69_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R68cell5 = R68row.getCell(8);
	       												   if (R68cell5 != null) {
	       												   R68cell5.setCellValue(BRF34.getR69_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR69_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R70////////////////////////
	       												   
	       												   Row R69row = sheet.getRow(81);
	       												   Cell R69cell = R69row.getCell(3);
	       												  	 if (R69cell != null) {
	       												       R69cell.setCellValue(BRF34.getR70_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR70_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R69cell1 = R69row.getCell(4);
	       												  	 if (R69cell1 != null) {
	       												       R69cell1.setCellValue(BRF34.getR70_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR70_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R69cell2 = R69row.getCell(5);
	       												  	 if (R69cell2 != null) {
	       												       R69cell2.setCellValue(BRF34.getR70_other_placement() == null ? 0 :
	       												  	     	BRF34.getR70_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R69cell3 = R69row.getCell(6);
	       												  	 if (R69cell3 != null) {
	       												       R69cell3.setCellValue(BRF34.getR70_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR70_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R69cell4 = R69row.getCell(7);
	       												  	 if (R69cell4 != null) {
	       												       R69cell4.setCellValue(BRF34.getR70_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR70_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R69cell5 = R69row.getCell(8);
	       												  	 if (R69cell5 != null) {
	       												       R69cell5.setCellValue(BRF34.getR70_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR70_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       												  	 
	       						//////////////////////////R71////////////////////////
	       								       				 
	       												  Row R70row = sheet.getRow(82);
	       												  Cell R70cell = R70row.getCell(3);
	       												 	 if (R70cell != null) {
	       												      R70cell.setCellValue(BRF34.getR71_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR71_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R70cell1 = R70row.getCell(4);
	       												 	 if (R70cell1 != null) {
	       												      R70cell1.setCellValue(BRF34.getR71_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR71_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R70cell2 = R70row.getCell(5);
	       												 	 if (R70cell2 != null) {
	       												      R70cell2.setCellValue(BRF34.getR71_other_placement() == null ? 0 :
	       												 	     	BRF34.getR71_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R70cell3 = R70row.getCell(6);
	       												 	 if (R70cell3 != null) {
	       												      R70cell3.setCellValue(BRF34.getR71_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR71_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R70cell4 = R70row.getCell(7);
	       												 	 if (R70cell4 != null) {
	       												      R70cell4.setCellValue(BRF34.getR71_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR71_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R70cell5 = R70row.getCell(8);
	       												 	 if (R70cell5 != null) {
	       												      R70cell5.setCellValue(BRF34.getR71_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR71_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R72////////////////////////
	       												 	 
	       												 	 Row R71row = sheet.getRow(83);
	       												 	 Cell R71cell = R71row.getCell(3);
	       												 		 if (R71cell != null) {
	       												 	     R71cell.setCellValue(BRF34.getR72_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR72_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R71cell1 = R71row.getCell(4);
	       												 		 if (R71cell1 != null) {
	       												 	     R71cell1.setCellValue(BRF34.getR72_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR72_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R71cell2 = R71row.getCell(5);
	       												 		 if (R71cell2 != null) {
	       												 	     R71cell2.setCellValue(BRF34.getR72_other_placement() == null ? 0 :
	       												 		     	BRF34.getR72_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R71cell3 = R71row.getCell(6);
	       												 		 if (R71cell3 != null) {
	       												 	     R71cell3.setCellValue(BRF34.getR72_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR72_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R71cell4 = R71row.getCell(7);
	       												 		 if (R71cell4 != null) {
	       												 	     R71cell4.setCellValue(BRF34.getR72_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR72_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R71cell5 = R71row.getCell(8);
	       												 		 if (R71cell5 != null) {
	       												 	     R71cell5.setCellValue(BRF34.getR72_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR72_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R73////////////////////////
	       												  
	       												  Row R72row = sheet.getRow(84);
	       												  Cell R72cell = R72row.getCell(3);
	       												 	 if (R72cell != null) {
	       												      R72cell.setCellValue(BRF34.getR73_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR73_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R72cell1 = R72row.getCell(4);
	       												 	 if (R72cell1 != null) {
	       												      R72cell1.setCellValue(BRF34.getR73_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR73_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R72cell2 = R72row.getCell(5);
	       												 	 if (R72cell2 != null) {
	       												      R72cell2.setCellValue(BRF34.getR73_other_placement() == null ? 0 :
	       												 	     	BRF34.getR73_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R72cell3 = R72row.getCell(6);
	       												 	 if (R72cell3 != null) {
	       												      R72cell3.setCellValue(BRF34.getR73_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR73_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R72cell4 = R72row.getCell(7);
	       												 	 if (R72cell4 != null) {
	       												      R72cell4.setCellValue(BRF34.getR73_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR73_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R72cell5 = R72row.getCell(8);
	       												 	 if (R72cell5 != null) {
	       												      R72cell5.setCellValue(BRF34.getR73_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR73_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R74////////////////////////
	       												 	 
	       												 	 Row R73row = sheet.getRow(85);
	       												 	 Cell R73cell = R73row.getCell(3);
	       												 		 if (R73cell != null) {
	       												 	     R73cell.setCellValue(BRF34.getR74_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR74_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R73cell1 = R73row.getCell(4);
	       												 		 if (R73cell1 != null) {
	       												 	     R73cell1.setCellValue(BRF34.getR74_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR74_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R73cell2 = R73row.getCell(5);
	       												 		 if (R73cell2 != null) {
	       												 	     R73cell2.setCellValue(BRF34.getR74_other_placement() == null ? 0 :
	       												 		     	BRF34.getR74_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R73cell3 = R73row.getCell(6);
	       												 		 if (R73cell3 != null) {
	       												 	     R73cell3.setCellValue(BRF34.getR74_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR74_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R73cell4 = R73row.getCell(7);
	       												 		 if (R73cell4 != null) {
	       												 	     R73cell4.setCellValue(BRF34.getR74_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR74_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R73cell5 = R73row.getCell(8);
	       												 		 if (R73cell5 != null) {
	       												 	     R73cell5.setCellValue(BRF34.getR74_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR74_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R75////////////////////////

	       												 Row R74row = sheet.getRow(86);
	       												 Cell R74cell = R74row.getCell(3);
	       												 	 if (R74cell != null) {
	       												     R74cell.setCellValue(BRF34.getR75_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR75_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R74cell1 = R74row.getCell(4);
	       												 	 if (R74cell1 != null) {
	       												     R74cell1.setCellValue(BRF34.getR75_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR75_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R74cell2 = R74row.getCell(5);
	       												 	 if (R74cell2 != null) {
	       												     R74cell2.setCellValue(BRF34.getR75_other_placement() == null ? 0 :
	       												 	     	BRF34.getR75_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R74cell3 = R74row.getCell(6);
	       												 	 if (R74cell3 != null) {
	       												     R74cell3.setCellValue(BRF34.getR75_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR75_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R74cell4 = R74row.getCell(7);
	       												 	 if (R74cell4 != null) {
	       												     R74cell4.setCellValue(BRF34.getR75_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR75_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R74cell5 = R74row.getCell(8);
	       												 	 if (R74cell5 != null) {
	       												     R74cell5.setCellValue(BRF34.getR75_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR75_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R76////////////////////////
	       												  
	       												  Row R75row = sheet.getRow(87);
	       												  Cell R75cell = R75row.getCell(3);
	       												 	 if (R75cell != null) {
	       												      R75cell.setCellValue(BRF34.getR76_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR76_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R75cell1 = R75row.getCell(4);
	       												 	 if (R75cell1 != null) {
	       												      R75cell1.setCellValue(BRF34.getR76_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR76_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R75cell2 = R75row.getCell(5);
	       												 	 if (R75cell2 != null) {
	       												      R75cell2.setCellValue(BRF34.getR76_other_placement() == null ? 0 :
	       												 	     	BRF34.getR76_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R75cell3 = R75row.getCell(6);
	       												 	 if (R75cell3 != null) {
	       												      R75cell3.setCellValue(BRF34.getR76_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR76_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R75cell4 = R75row.getCell(7);
	       												 	 if (R75cell4 != null) {
	       												      R75cell4.setCellValue(BRF34.getR76_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR76_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R75cell5 = R75row.getCell(8);
	       												 	 if (R75cell5 != null) {
	       												      R75cell5.setCellValue(BRF34.getR76_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR76_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R77////////////////////////
	       												 	 
	       												 	 Row R76row = sheet.getRow(88);
	       												 	 Cell R76cell = R76row.getCell(3);
	       												 		 if (R76cell != null) {
	       												 	     R76cell.setCellValue(BRF34.getR77_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR77_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R76cell1 = R76row.getCell(4);
	       												  if (R76cell1 != null) {
	       												  R76cell1.setCellValue(BRF34.getR77_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR77_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R76cell2 = R76row.getCell(5);
	       												  if (R76cell2 != null) {
	       												  R76cell2.setCellValue(BRF34.getR77_other_placement() == null ? 0 :
	       												      	BRF34.getR77_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R76cell3 = R76row.getCell(6);
	       												  if (R76cell3 != null) {
	       												  R76cell3.setCellValue(BRF34.getR77_other_borrow() == null ? 0 :
	       												      	BRF34.getR77_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R76cell4 = R76row.getCell(7);
	       												  if (R76cell4 != null) {
	       												  R76cell4.setCellValue(BRF34.getR77_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR77_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R76cell5 = R76row.getCell(8);
	       												  if (R76cell5 != null) {
	       												  R76cell5.setCellValue(BRF34.getR77_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR77_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R78////////////////////////
	       												  
	       												  Row R77row = sheet.getRow(89);
	       												  Cell R77cell = R77row.getCell(3);
	       												 	 if (R77cell != null) {
	       												      R77cell.setCellValue(BRF34.getR78_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR78_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R77cell1 = R77row.getCell(4);
	       												 	 if (R77cell1 != null) {
	       												      R77cell1.setCellValue(BRF34.getR78_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR78_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R77cell2 = R77row.getCell(5);
	       												 	 if (R77cell2 != null) {
	       												      R77cell2.setCellValue(BRF34.getR78_other_placement() == null ? 0 :
	       												 	     	BRF34.getR78_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R77cell3 = R77row.getCell(6);
	       												 	 if (R77cell3 != null) {
	       												      R77cell3.setCellValue(BRF34.getR78_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR78_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R77cell4 = R77row.getCell(7);
	       												 	 if (R77cell4 != null) {
	       												      R77cell4.setCellValue(BRF34.getR78_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR78_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R77cell5 = R77row.getCell(8);
	       												 	 if (R77cell5 != null) {
	       												      R77cell5.setCellValue(BRF34.getR78_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR78_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R79////////////////////////
	       												 	 
	       												 	 Row R78row = sheet.getRow(90);
	       												 	 Cell R78cell = R78row.getCell(3);
	       												 		 if (R78cell != null) {
	       												 	     R78cell.setCellValue(BRF34.getR79_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR79_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R78cell1 = R78row.getCell(4);
	       												   if (R78cell1 != null) {
	       												   R78cell1.setCellValue(BRF34.getR79_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR79_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R78cell2 = R78row.getCell(5);
	       												   if (R78cell2 != null) {
	       												   R78cell2.setCellValue(BRF34.getR79_other_placement() == null ? 0 :
	       												       	BRF34.getR79_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R78cell3 = R78row.getCell(6);
	       												   if (R78cell3 != null) {
	       												   R78cell3.setCellValue(BRF34.getR79_other_borrow() == null ? 0 :
	       												       	BRF34.getR79_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R78cell4 = R78row.getCell(7);
	       												   if (R78cell4 != null) {
	       												   R78cell4.setCellValue(BRF34.getR79_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR79_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R78cell5 = R78row.getCell(8);
	       												   if (R78cell5 != null) {
	       												   R78cell5.setCellValue(BRF34.getR79_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR79_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R80////////////////////////
	       												   
	       												   Row R79row = sheet.getRow(91);
	       												   Cell R79cell = R79row.getCell(3);
	       												  	 if (R79cell != null) {
	       												       R79cell.setCellValue(BRF34.getR80_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR80_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R79cell1 = R79row.getCell(4);
	       												  	 if (R79cell1 != null) {
	       												       R79cell1.setCellValue(BRF34.getR80_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR80_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R79cell2 = R79row.getCell(5);
	       												  	 if (R79cell2 != null) {
	       												       R79cell2.setCellValue(BRF34.getR80_other_placement() == null ? 0 :
	       												  	     	BRF34.getR80_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R79cell3 = R79row.getCell(6);
	       												  	 if (R79cell3 != null) {
	       												       R79cell3.setCellValue(BRF34.getR80_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR80_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R79cell4 = R79row.getCell(7);
	       												  	 if (R79cell4 != null) {
	       												       R79cell4.setCellValue(BRF34.getR80_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR80_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R79cell5 = R79row.getCell(8);
	       												  	 if (R79cell5 != null) {
	       												       R79cell5.setCellValue(BRF34.getR80_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR80_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       												  	 
	       						//////////////////////////R81////////////////////////
	       								       				 
	       												  Row R80row = sheet.getRow(92);
	       												  Cell R80cell = R80row.getCell(3);
	       												 	 if (R80cell != null) {
	       												      R80cell.setCellValue(BRF34.getR81_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR81_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R80cell1 = R80row.getCell(4);
	       												 	 if (R80cell1 != null) {
	       												      R80cell1.setCellValue(BRF34.getR81_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR81_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R80cell2 = R80row.getCell(5);
	       												 	 if (R80cell2 != null) {
	       												      R80cell2.setCellValue(BRF34.getR81_other_placement() == null ? 0 :
	       												 	     	BRF34.getR81_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R80cell3 = R80row.getCell(6);
	       												 	 if (R80cell3 != null) {
	       												      R80cell3.setCellValue(BRF34.getR81_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR81_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R80cell4 = R80row.getCell(7);
	       												 	 if (R80cell4 != null) {
	       												      R80cell4.setCellValue(BRF34.getR81_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR81_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R80cell5 = R80row.getCell(8);
	       												 	 if (R80cell5 != null) {
	       												      R80cell5.setCellValue(BRF34.getR81_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR81_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R82////////////////////////
	       												 	 
	       												 	 Row R81row = sheet.getRow(94);
	       												 	 Cell R81cell = R81row.getCell(3);
	       												 		 if (R81cell != null) {
	       												 	     R81cell.setCellValue(BRF34.getR82_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR82_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R81cell1 = R81row.getCell(4);
	       												 		 if (R81cell1 != null) {
	       												 	     R81cell1.setCellValue(BRF34.getR82_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR82_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R81cell2 = R81row.getCell(5);
	       												 		 if (R81cell2 != null) {
	       												 	     R81cell2.setCellValue(BRF34.getR82_other_placement() == null ? 0 :
	       												 		     	BRF34.getR82_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R81cell3 = R81row.getCell(6);
	       												 		 if (R81cell3 != null) {
	       												 	     R81cell3.setCellValue(BRF34.getR82_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR82_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R81cell4 = R81row.getCell(7);
	       												 		 if (R81cell4 != null) {
	       												 	     R81cell4.setCellValue(BRF34.getR82_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR82_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R81cell5 = R81row.getCell(8);
	       												 		 if (R81cell5 != null) {
	       												 	     R81cell5.setCellValue(BRF34.getR82_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR82_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R83////////////////////////
	       												  
	       												  Row R82row = sheet.getRow(95);
	       												  Cell R82cell = R82row.getCell(3);
	       												 	 if (R82cell != null) {
	       												      R82cell.setCellValue(BRF34.getR83_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR83_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R82cell1 = R82row.getCell(4);
	       												 	 if (R82cell1 != null) {
	       												      R82cell1.setCellValue(BRF34.getR83_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR83_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R82cell2 = R82row.getCell(5);
	       												 	 if (R82cell2 != null) {
	       												      R82cell2.setCellValue(BRF34.getR83_other_placement() == null ? 0 :
	       												 	     	BRF34.getR83_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R82cell3 = R82row.getCell(6);
	       												 	 if (R82cell3 != null) {
	       												      R82cell3.setCellValue(BRF34.getR83_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR83_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R82cell4 = R82row.getCell(7);
	       												 	 if (R82cell4 != null) {
	       												      R82cell4.setCellValue(BRF34.getR83_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR83_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R82cell5 = R82row.getCell(8);
	       												 	 if (R82cell5 != null) {
	       												      R82cell5.setCellValue(BRF34.getR83_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR83_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R84////////////////////////
	       												 	 
	       												 	 Row R83row = sheet.getRow(96);
	       												 	 Cell R83cell = R83row.getCell(3);
	       												 		 if (R83cell != null) {
	       												 	     R83cell.setCellValue(BRF34.getR84_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR84_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R83cell1 = R83row.getCell(4);
	       												 		 if (R83cell1 != null) {
	       												 	     R83cell1.setCellValue(BRF34.getR84_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR84_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R83cell2 = R83row.getCell(5);
	       												 		 if (R83cell2 != null) {
	       												 	     R83cell2.setCellValue(BRF34.getR84_other_placement() == null ? 0 :
	       												 		     	BRF34.getR84_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R83cell3 = R83row.getCell(6);
	       												 		 if (R83cell3 != null) {
	       												 	     R83cell3.setCellValue(BRF34.getR84_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR84_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R83cell4 = R83row.getCell(7);
	       												 		 if (R83cell4 != null) {
	       												 	     R83cell4.setCellValue(BRF34.getR84_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR84_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R83cell5 = R83row.getCell(8);
	       												 		 if (R83cell5 != null) {
	       												 	     R83cell5.setCellValue(BRF34.getR84_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR84_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R85////////////////////////

	       												 Row R84row = sheet.getRow(97);
	       												 Cell R84cell = R84row.getCell(3);
	       												 	 if (R84cell != null) {
	       												     R84cell.setCellValue(BRF34.getR85_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR85_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R84cell1 = R84row.getCell(4);
	       												 	 if (R84cell1 != null) {
	       												     R84cell1.setCellValue(BRF34.getR85_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR85_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R84cell2 = R84row.getCell(5);
	       												 	 if (R84cell2 != null) {
	       												     R84cell2.setCellValue(BRF34.getR85_other_placement() == null ? 0 :
	       												 	     	BRF34.getR85_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R84cell3 = R84row.getCell(6);
	       												 	 if (R84cell3 != null) {
	       												     R84cell3.setCellValue(BRF34.getR85_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR85_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R84cell4 = R84row.getCell(7);
	       												 	 if (R84cell4 != null) {
	       												     R84cell4.setCellValue(BRF34.getR85_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR85_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R84cell5 = R84row.getCell(8);
	       												 	 if (R84cell5 != null) {
	       												     R84cell5.setCellValue(BRF34.getR85_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR85_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R86////////////////////////
	       												  
	       												  Row R85row = sheet.getRow(98);
	       												  Cell R85cell = R85row.getCell(3);
	       												 	 if (R85cell != null) {
	       												      R85cell.setCellValue(BRF34.getR86_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR86_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R85cell1 = R85row.getCell(4);
	       												 	 if (R85cell1 != null) {
	       												      R85cell1.setCellValue(BRF34.getR86_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR86_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R85cell2 = R85row.getCell(5);
	       												 	 if (R85cell2 != null) {
	       												      R85cell2.setCellValue(BRF34.getR86_other_placement() == null ? 0 :
	       												 	     	BRF34.getR86_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R85cell3 = R85row.getCell(6);
	       												 	 if (R85cell3 != null) {
	       												      R85cell3.setCellValue(BRF34.getR86_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR86_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R85cell4 = R85row.getCell(7);
	       												 	 if (R85cell4 != null) {
	       												      R85cell4.setCellValue(BRF34.getR86_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR86_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R85cell5 = R85row.getCell(8);
	       												 	 if (R85cell5 != null) {
	       												      R85cell5.setCellValue(BRF34.getR86_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR86_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R87////////////////////////
	       												 	 
	       												 	 Row R86row = sheet.getRow(99);
	       												 	 Cell R86cell = R86row.getCell(3);
	       												 		 if (R86cell != null) {
	       												 	     R86cell.setCellValue(BRF34.getR87_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR87_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R86cell1 = R86row.getCell(4);
	       												  if (R86cell1 != null) {
	       												  R86cell1.setCellValue(BRF34.getR87_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR87_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R86cell2 = R86row.getCell(5);
	       												  if (R86cell2 != null) {
	       												  R86cell2.setCellValue(BRF34.getR87_other_placement() == null ? 0 :
	       												      	BRF34.getR87_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R86cell3 = R86row.getCell(6);
	       												  if (R86cell3 != null) {
	       												  R86cell3.setCellValue(BRF34.getR87_other_borrow() == null ? 0 :
	       												      	BRF34.getR87_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R86cell4 = R86row.getCell(7);
	       												  if (R86cell4 != null) {
	       												  R86cell4.setCellValue(BRF34.getR87_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR87_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R86cell5 = R86row.getCell(8);
	       												  if (R86cell5 != null) {
	       												  R86cell5.setCellValue(BRF34.getR87_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR87_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R88////////////////////////
	       												  
	       												  Row R87row = sheet.getRow(100);
	       												  Cell R87cell = R87row.getCell(3);
	       												 	 if (R87cell != null) {
	       												      R87cell.setCellValue(BRF34.getR88_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR88_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R87cell1 = R87row.getCell(4);
	       												 	 if (R87cell1 != null) {
	       												      R87cell1.setCellValue(BRF34.getR88_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR88_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R87cell2 = R87row.getCell(5);
	       												 	 if (R87cell2 != null) {
	       												      R87cell2.setCellValue(BRF34.getR88_other_placement() == null ? 0 :
	       												 	     	BRF34.getR88_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R87cell3 = R87row.getCell(6);
	       												 	 if (R87cell3 != null) {
	       												      R87cell3.setCellValue(BRF34.getR88_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR88_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R87cell4 = R87row.getCell(7);
	       												 	 if (R87cell4 != null) {
	       												      R87cell4.setCellValue(BRF34.getR88_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR88_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R87cell5 = R87row.getCell(8);
	       												 	 if (R87cell5 != null) {
	       												      R87cell5.setCellValue(BRF34.getR88_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR88_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R89////////////////////////
	       												 	 
	       												 	 Row R88row = sheet.getRow(101);
	       												 	 Cell R88cell = R88row.getCell(3);
	       												 		 if (R88cell != null) {
	       												 	     R88cell.setCellValue(BRF34.getR89_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR89_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R88cell1 = R88row.getCell(4);
	       												   if (R88cell1 != null) {
	       												   R88cell1.setCellValue(BRF34.getR89_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR89_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R88cell2 = R88row.getCell(5);
	       												   if (R88cell2 != null) {
	       												   R88cell2.setCellValue(BRF34.getR89_other_placement() == null ? 0 :
	       												       	BRF34.getR89_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R88cell3 = R88row.getCell(6);
	       												   if (R88cell3 != null) {
	       												   R88cell3.setCellValue(BRF34.getR89_other_borrow() == null ? 0 :
	       												       	BRF34.getR89_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R88cell4 = R88row.getCell(7);
	       												   if (R88cell4 != null) {
	       												   R88cell4.setCellValue(BRF34.getR89_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR89_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R88cell5 = R88row.getCell(8);
	       												   if (R88cell5 != null) {
	       												   R88cell5.setCellValue(BRF34.getR89_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR89_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R90////////////////////////
	       												   
	       												   Row R89row = sheet.getRow(102);
	       												   Cell R89cell = R89row.getCell(3);
	       												  	 if (R89cell != null) {
	       												       R89cell.setCellValue(BRF34.getR90_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR90_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R89cell1 = R89row.getCell(4);
	       												  	 if (R89cell1 != null) {
	       												       R89cell1.setCellValue(BRF34.getR90_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR90_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R89cell2 = R89row.getCell(5);
	       												  	 if (R89cell2 != null) {
	       												       R89cell2.setCellValue(BRF34.getR90_other_placement() == null ? 0 :
	       												  	     	BRF34.getR90_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R89cell3 = R89row.getCell(6);
	       												  	 if (R89cell3 != null) {
	       												       R89cell3.setCellValue(BRF34.getR90_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR90_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R89cell4 = R89row.getCell(7);
	       												  	 if (R89cell4 != null) {
	       												       R89cell4.setCellValue(BRF34.getR90_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR90_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R89cell5 = R89row.getCell(8);
	       												  	 if (R89cell5 != null) {
	       												       R89cell5.setCellValue(BRF34.getR90_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR90_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       												  	 
	       						//////////////////////////R91////////////////////////
	       								       				 
	       												  Row R90row = sheet.getRow(103);
	       												  Cell R90cell = R90row.getCell(3);
	       												 	 if (R90cell != null) {
	       												      R90cell.setCellValue(BRF34.getR91_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR91_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R90cell1 = R90row.getCell(4);
	       												 	 if (R90cell1 != null) {
	       												      R90cell1.setCellValue(BRF34.getR91_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR91_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R90cell2 = R90row.getCell(5);
	       												 	 if (R90cell2 != null) {
	       												      R90cell2.setCellValue(BRF34.getR91_other_placement() == null ? 0 :
	       												 	     	BRF34.getR91_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R90cell3 = R90row.getCell(6);
	       												 	 if (R90cell3 != null) {
	       												      R90cell3.setCellValue(BRF34.getR91_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR91_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R90cell4 = R90row.getCell(7);
	       												 	 if (R90cell4 != null) {
	       												      R90cell4.setCellValue(BRF34.getR91_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR91_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R90cell5 = R90row.getCell(8);
	       												 	 if (R90cell5 != null) {
	       												      R90cell5.setCellValue(BRF34.getR91_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR91_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R92////////////////////////
	       												 	 
	       												 	 Row R91row = sheet.getRow(104);
	       												 	 Cell R91cell = R91row.getCell(3);
	       												 		 if (R91cell != null) {
	       												 	     R91cell.setCellValue(BRF34.getR92_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR92_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R91cell1 = R91row.getCell(4);
	       												 		 if (R91cell1 != null) {
	       												 	     R91cell1.setCellValue(BRF34.getR92_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR92_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R91cell2 = R91row.getCell(5);
	       												 		 if (R91cell2 != null) {
	       												 	     R91cell2.setCellValue(BRF34.getR92_other_placement() == null ? 0 :
	       												 		     	BRF34.getR92_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R91cell3 = R91row.getCell(6);
	       												 		 if (R91cell3 != null) {
	       												 	     R91cell3.setCellValue(BRF34.getR92_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR92_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R91cell4 = R91row.getCell(7);
	       												 		 if (R91cell4 != null) {
	       												 	     R91cell4.setCellValue(BRF34.getR92_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR92_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R91cell5 = R91row.getCell(8);
	       												 		 if (R91cell5 != null) {
	       												 	     R91cell5.setCellValue(BRF34.getR92_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR92_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R93////////////////////////
	       												  
	       												  Row R92row = sheet.getRow(105);
	       												  Cell R92cell = R92row.getCell(3);
	       												 	 if (R92cell != null) {
	       												      R92cell.setCellValue(BRF34.getR93_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR93_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R92cell1 = R92row.getCell(4);
	       												 	 if (R92cell1 != null) {
	       												      R92cell1.setCellValue(BRF34.getR93_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR93_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R92cell2 = R92row.getCell(5);
	       												 	 if (R92cell2 != null) {
	       												      R92cell2.setCellValue(BRF34.getR93_other_placement() == null ? 0 :
	       												 	     	BRF34.getR93_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R92cell3 = R92row.getCell(6);
	       												 	 if (R92cell3 != null) {
	       												      R92cell3.setCellValue(BRF34.getR93_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR93_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R92cell4 = R92row.getCell(7);
	       												 	 if (R92cell4 != null) {
	       												      R92cell4.setCellValue(BRF34.getR93_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR93_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R92cell5 = R92row.getCell(8);
	       												 	 if (R92cell5 != null) {
	       												      R92cell5.setCellValue(BRF34.getR93_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR93_remani_balance_to().intValue());
	       												 	 }
	       												 	 


	       												 	 //////////////////////////R94////////////////////////
	       												 	 
	       												 	 Row R93row = sheet.getRow(106);
	       												 	 Cell R93cell = R93row.getCell(3);
	       												 		 if (R93cell != null) {
	       												 	     R93cell.setCellValue(BRF34.getR94_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR94_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R93cell1 = R93row.getCell(4);
	       												 		 if (R93cell1 != null) {
	       												 	     R93cell1.setCellValue(BRF34.getR94_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR94_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R93cell2 = R93row.getCell(5);
	       												 		 if (R93cell2 != null) {
	       												 	     R93cell2.setCellValue(BRF34.getR94_other_placement() == null ? 0 :
	       												 		     	BRF34.getR94_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R93cell3 = R93row.getCell(6);
	       												 		 if (R93cell3 != null) {
	       												 	     R93cell3.setCellValue(BRF34.getR94_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR94_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R93cell4 = R93row.getCell(7);
	       												 		 if (R93cell4 != null) {
	       												 	     R93cell4.setCellValue(BRF34.getR94_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR94_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R93cell5 = R93row.getCell(8);
	       												 		 if (R93cell5 != null) {
	       												 	     R93cell5.setCellValue(BRF34.getR94_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR94_remani_balance_to().intValue());
	       												 		 }
	       												 //////////////////////////R95////////////////////////

	       												 Row R94row = sheet.getRow(107);
	       												 Cell R94cell = R94row.getCell(3);
	       												 	 if (R94cell != null) {
	       												     R94cell.setCellValue(BRF34.getR95_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR95_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R94cell1 = R94row.getCell(4);
	       												 	 if (R94cell1 != null) {
	       												     R94cell1.setCellValue(BRF34.getR95_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR95_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R94cell2 = R94row.getCell(5);
	       												 	 if (R94cell2 != null) {
	       												     R94cell2.setCellValue(BRF34.getR95_other_placement() == null ? 0 :
	       												 	     	BRF34.getR95_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R94cell3 = R94row.getCell(6);
	       												 	 if (R94cell3 != null) {
	       												     R94cell3.setCellValue(BRF34.getR95_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR95_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												    Cell R94cell4 = R94row.getCell(7);
	       												 	 if (R94cell4 != null) {
	       												     R94cell4.setCellValue(BRF34.getR95_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR95_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R94cell5 = R94row.getCell(8);
	       												 	 if (R94cell5 != null) {
	       												     R94cell5.setCellValue(BRF34.getR95_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR95_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 
	       												  //////////////////////////R96////////////////////////
	       												  
	       												  Row R95row = sheet.getRow(108);
	       												  Cell R95cell = R95row.getCell(3);
	       												 	 if (R95cell != null) {
	       												      R95cell.setCellValue(BRF34.getR96_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR96_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R95cell1 = R95row.getCell(4);
	       												 	 if (R95cell1 != null) {
	       												      R95cell1.setCellValue(BRF34.getR96_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR96_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R95cell2 = R95row.getCell(5);
	       												 	 if (R95cell2 != null) {
	       												      R95cell2.setCellValue(BRF34.getR96_other_placement() == null ? 0 :
	       												 	     	BRF34.getR96_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R95cell3 = R95row.getCell(6);
	       												 	 if (R95cell3 != null) {
	       												      R95cell3.setCellValue(BRF34.getR96_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR96_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R95cell4 = R95row.getCell(7);
	       												 	 if (R95cell4 != null) {
	       												      R95cell4.setCellValue(BRF34.getR96_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR96_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R95cell5 = R95row.getCell(8);
	       												 	 if (R95cell5 != null) {
	       												      R95cell5.setCellValue(BRF34.getR96_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR96_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       												 	 //////////////////////////R97////////////////////////
	       												 	 
	       												 	 Row R96row = sheet.getRow(109);
	       												 	 Cell R96cell = R96row.getCell(3);
	       												 		 if (R96cell != null) {
	       												 	     R96cell.setCellValue(BRF34.getR97_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR97_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 Cell R96cell1 = R96row.getCell(4);
	       												  if (R96cell1 != null) {
	       												  R96cell1.setCellValue(BRF34.getR97_inter_bank_borrow() == null ? 0 :
	       												      	BRF34.getR97_inter_bank_borrow().intValue());
	       												  }
	       												  
	       												 Cell R96cell2 = R96row.getCell(5);
	       												  if (R96cell2 != null) {
	       												  R96cell2.setCellValue(BRF34.getR97_other_placement() == null ? 0 :
	       												      	BRF34.getR97_other_placement().intValue());
	       												  }
	       												  
	       												 Cell R96cell3 = R96row.getCell(6);
	       												  if (R96cell3 != null) {
	       												  R96cell3.setCellValue(BRF34.getR97_other_borrow() == null ? 0 :
	       												      	BRF34.getR97_other_borrow().intValue());
	       												  }
	       												  
	       												 Cell R96cell4 = R96row.getCell(7);
	       												  if (R96cell4 != null) {
	       												  R96cell4.setCellValue(BRF34.getR97_remani_balance_from() == null ? 0 :
	       												      	BRF34.getR97_remani_balance_from().intValue());
	       												  }
	       												  
	       												 Cell R96cell5 = R96row.getCell(8);
	       												  if (R96cell5 != null) {
	       												  R96cell5.setCellValue(BRF34.getR97_remani_balance_to() == null ? 0 :
	       												      	BRF34.getR97_remani_balance_to().intValue());
	       												  }
	       												  
	       												  
	       												  
	       												  //////////////////////////R98////////////////////////
	       												  
	       												  Row R97row = sheet.getRow(110);
	       												  Cell R97cell = R97row.getCell(3);
	       												 	 if (R97cell != null) {
	       												      R97cell.setCellValue(BRF34.getR98_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR98_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R97cell1 = R97row.getCell(4);
	       												 	 if (R97cell1 != null) {
	       												      R97cell1.setCellValue(BRF34.getR98_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR98_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R97cell2 = R97row.getCell(5);
	       												 	 if (R97cell2 != null) {
	       												      R97cell2.setCellValue(BRF34.getR98_other_placement() == null ? 0 :
	       												 	     	BRF34.getR98_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R97cell3 = R97row.getCell(6);
	       												 	 if (R97cell3 != null) {
	       												      R97cell3.setCellValue(BRF34.getR98_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR98_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R97cell4 = R97row.getCell(7);
	       												 	 if (R97cell4 != null) {
	       												      R97cell4.setCellValue(BRF34.getR98_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR98_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R97cell5 = R97row.getCell(8);
	       												 	 if (R97cell5 != null) {
	       												      R97cell5.setCellValue(BRF34.getR98_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR98_remani_balance_to().intValue());
	       												 	 }


	       												 	 //////////////////////////R99////////////////////////
	       												 	 
	       												 	 Row R98row = sheet.getRow(111);
	       												 	 Cell R98cell = R98row.getCell(3);
	       												 		 if (R98cell != null) {
	       												 	     R98cell.setCellValue(BRF34.getR99_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR99_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												  Cell R98cell1 = R98row.getCell(4);
	       												   if (R98cell1 != null) {
	       												   R98cell1.setCellValue(BRF34.getR99_inter_bank_borrow() == null ? 0 :
	       												       	BRF34.getR99_inter_bank_borrow().intValue());
	       												   }
	       												   
	       												  Cell R98cell2 = R98row.getCell(5);
	       												   if (R98cell2 != null) {
	       												   R98cell2.setCellValue(BRF34.getR99_other_placement() == null ? 0 :
	       												       	BRF34.getR99_other_placement().intValue());
	       												   }
	       												   
	       												  Cell R98cell3 = R98row.getCell(6);
	       												   if (R98cell3 != null) {
	       												   R98cell3.setCellValue(BRF34.getR99_other_borrow() == null ? 0 :
	       												       	BRF34.getR99_other_borrow().intValue());
	       												   }
	       												   
	       												  Cell R98cell4 = R98row.getCell(7);
	       												   if (R98cell4 != null) {
	       												   R98cell4.setCellValue(BRF34.getR99_remani_balance_from() == null ? 0 :
	       												       	BRF34.getR99_remani_balance_from().intValue());
	       												   }
	       												   
	       												  Cell R98cell5 = R98row.getCell(8);
	       												   if (R98cell5 != null) {
	       												   R98cell5.setCellValue(BRF34.getR99_remani_balance_to() == null ? 0 :
	       												       	BRF34.getR99_remani_balance_to().intValue());
	       												   }
	       												  
	       												   //////////////////////////R100////////////////////////
	       												   
	       												   Row R99row = sheet.getRow(112);
	       												   Cell R99cell = R99row.getCell(3);
	       												  	 if (R99cell != null) {
	       												       R99cell.setCellValue(BRF34.getR100_inter_bank_place() == null ? 0 :
	       												  	     	BRF34.getR100_inter_bank_place().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R99cell1 = R99row.getCell(4);
	       												  	 if (R99cell1 != null) {
	       												       R99cell1.setCellValue(BRF34.getR100_inter_bank_borrow() == null ? 0 :
	       												  	     	BRF34.getR100_inter_bank_borrow().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R99cell2 = R99row.getCell(5);
	       												  	 if (R99cell2 != null) {
	       												       R99cell2.setCellValue(BRF34.getR100_other_placement() == null ? 0 :
	       												  	     	BRF34.getR100_other_placement().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R99cell3 = R99row.getCell(6);
	       												  	 if (R99cell3 != null) {
	       												       R99cell3.setCellValue(BRF34.getR100_other_borrow() == null ? 0 :
	       												  	     	BRF34.getR100_other_borrow().intValue());
	       												  	 }
	       												  	 
	       												      Cell R99cell4 = R99row.getCell(7);
	       												  	 if (R99cell4 != null) {
	       												       R99cell4.setCellValue(BRF34.getR100_remani_balance_from() == null ? 0 :
	       												  	     	BRF34.getR100_remani_balance_from().intValue());
	       												  	 }
	       												  	 
	       												  	Cell R99cell5 = R99row.getCell(8);
	       												  	 if (R99cell5 != null) {
	       												       R99cell5.setCellValue(BRF34.getR100_remani_balance_to() == null ? 0 :
	       												  	     	BRF34.getR100_remani_balance_to().intValue());
	       												  	 }
	       												  	 
	       												  	 
	       												  	 
	       						//////////////////////////R101////////////////////////
	       								       				 
	       												  Row R100row = sheet.getRow(113);
	       												  Cell R100cell = R100row.getCell(3);
	       												 	 if (R100cell != null) {
	       												      R100cell.setCellValue(BRF34.getR101_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR101_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R100cell1 = R100row.getCell(4);
	       												 	 if (R100cell1 != null) {
	       												      R100cell1.setCellValue(BRF34.getR101_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR101_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R100cell2 = R100row.getCell(5);
	       												 	 if (R100cell2 != null) {
	       												      R100cell2.setCellValue(BRF34.getR101_other_placement() == null ? 0 :
	       												 	     	BRF34.getR101_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R100cell3 = R100row.getCell(6);
	       												 	 if (R100cell3 != null) {
	       												      R100cell3.setCellValue(BRF34.getR101_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR101_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R100cell4 = R100row.getCell(7);
	       												 	 if (R100cell4 != null) {
	       												      R100cell4.setCellValue(BRF34.getR101_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR101_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R100cell5 = R100row.getCell(8);
	       												 	 if (R100cell5 != null) {
	       												      R100cell5.setCellValue(BRF34.getR101_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR101_remani_balance_to().intValue());
	       												 	 }
	       												 	 //////////////////////////R102////////////////////////
	       												 	 
	       												 	 Row R101row = sheet.getRow(114);
	       												 	 Cell R101cell = R101row.getCell(3);
	       												 		 if (R101cell != null) {
	       												 	     R101cell.setCellValue(BRF34.getR102_inter_bank_place() == null ? 0 :
	       												 		     	BRF34.getR102_inter_bank_place().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R101cell1 = R101row.getCell(4);
	       												 		 if (R101cell1 != null) {
	       												 	     R101cell1.setCellValue(BRF34.getR102_inter_bank_borrow() == null ? 0 :
	       												 		     	BRF34.getR102_inter_bank_borrow().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R101cell2 = R101row.getCell(5);
	       												 		 if (R101cell2 != null) {
	       												 	     R101cell2.setCellValue(BRF34.getR102_other_placement() == null ? 0 :
	       												 		     	BRF34.getR102_other_placement().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R101cell3 = R101row.getCell(6);
	       												 		 if (R101cell3 != null) {
	       												 	     R101cell3.setCellValue(BRF34.getR102_other_borrow() == null ? 0 :
	       												 		     	BRF34.getR102_other_borrow().intValue());
	       												 		 }
	       												 		 
	       												 	    Cell R101cell4 = R101row.getCell(7);
	       												 		 if (R101cell4 != null) {
	       												 	     R101cell4.setCellValue(BRF34.getR102_remani_balance_from() == null ? 0 :
	       												 		     	BRF34.getR102_remani_balance_from().intValue());
	       												 		 }
	       												 		 
	       												 		Cell R101cell5 = R101row.getCell(8);
	       												 		 if (R101cell5 != null) {
	       												 	     R101cell5.setCellValue(BRF34.getR102_remani_balance_to() == null ? 0 :
	       												 		     	BRF34.getR102_remani_balance_to().intValue());
	       												 		 }

	       												 		 
	       												 		 
	       												  //////////////////////////R103////////////////////////
	       												  
	       												  Row R102row = sheet.getRow(115);
	       												  Cell R102cell = R102row.getCell(3);
	       												 	 if (R102cell != null) {
	       												      R102cell.setCellValue(BRF34.getR103_inter_bank_place() == null ? 0 :
	       												 	     	BRF34.getR103_inter_bank_place().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R102cell1 = R102row.getCell(4);
	       												 	 if (R102cell1 != null) {
	       												      R102cell1.setCellValue(BRF34.getR103_inter_bank_borrow() == null ? 0 :
	       												 	     	BRF34.getR103_inter_bank_borrow().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R102cell2 = R102row.getCell(5);
	       												 	 if (R102cell2 != null) {
	       												      R102cell2.setCellValue(BRF34.getR103_other_placement() == null ? 0 :
	       												 	     	BRF34.getR103_other_placement().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R102cell3 = R102row.getCell(6);
	       												 	 if (R102cell3 != null) {
	       												      R102cell3.setCellValue(BRF34.getR103_other_borrow() == null ? 0 :
	       												 	     	BRF34.getR103_other_borrow().intValue());
	       												 	 }
	       												 	 
	       												     Cell R102cell4 = R102row.getCell(7);
	       												 	 if (R102cell4 != null) {
	       												      R102cell4.setCellValue(BRF34.getR103_remani_balance_from() == null ? 0 :
	       												 	     	BRF34.getR103_remani_balance_from().intValue());
	       												 	 }
	       												 	 
	       												 	Cell R102cell5 = R102row.getCell(8);
	       												 	 if (R102cell5 != null) {
	       												      R102cell5.setCellValue(BRF34.getR103_remani_balance_to() == null ? 0 :
	       												 	     	BRF34.getR103_remani_balance_to().intValue());
	       												 	 }
	       												 	 
	       	 
	       	 
	       	 
	       	 
	       	 
	       	 // Save the changes
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-034-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-034-A.xls");

		return outputFile;
	
	
	
	}
	       	 
	       	 
	public String detailChanges34(BRF34_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {
		String msg = "";

		try {
			
			Session hs = sessionFactory.getCurrentSession();
				Optional<BRF34_DETAIL_ENTITY> BRF34detail = brf34_detailrepo.findById(foracid);
				
				if (BRF34detail.isPresent()) {
					BRF34_DETAIL_ENTITY BRFdetail = BRF34detail.get();

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
						brf34_detailrepo.save(BRFdetail);

//							hs.saveOrUpdate(detail);
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

	/****** ARCHEVE VIEW ******/

	public ModelAndView getArchieveBRF034View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF34_ENTITY> T1rep = new ArrayList<BRF34_ENTITY>();
			// Query<Object[]> qr;

			List<BRF34_ENTITY> T1Master = new ArrayList<BRF34_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF34_ENTITY a where a.report_date = ?1 ", BRF34_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF034ARCH");
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

	public ModelAndView ARCHgetBRF034currentDtl(String reportId, String fromdate, String todate, String currency,
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
				
				
					qr = hs.createNativeQuery("select * from BRF34_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF34_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF34_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF34_ARCHIVENTITY> T1Master = new ArrayList<BRF34_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF34_ARCHIVENTITY a where a.report_date = ?1", BRF34_ARCHIVENTITY.class)
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
			String maturity_date = (String) a[45];
			String gender = (String)a[46];
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

			BRF34_ARCHIVENTITY py = new BRF34_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nre_flg);
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


		
		mv.setViewName("RR" + "/" + "BRF034ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	


	}