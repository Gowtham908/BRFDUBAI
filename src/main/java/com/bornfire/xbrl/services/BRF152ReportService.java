
package com.bornfire.xbrl.services;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRF152_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF152ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF152_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF152_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.BRF152_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF153_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF152_Entity;

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

public class BRF152ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF152ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF152ServiceRepo brf152ServiceRepo;
	
	@Autowired 
	BRF152_DetailRepo brf152_detailrepo;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF152(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF152_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF152_Entity a").getSingleResult();
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
	
	public ModelAndView getBRF152View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF152_Entity> T1rep = new ArrayList<BRF152_Entity>();
		// Query<Object[]> qr;

		List<BRF152_Entity> T1Master = new ArrayList<BRF152_Entity>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF152_Entity a where a.report_date = ?1 ", BRF152_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF152");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF152Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF152_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF152_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF152_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF152_DETAIL_ENTITY> T1Master = new ArrayList<BRF152_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF152_DETAIL_ENTITY a where a.report_date = ?1", BRF152_DETAIL_ENTITY.class)
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
			BigDecimal amt_ac = (BigDecimal) a[5];
			String acct_crncy_code = (String) a[6];
			String gl_code = (String) a[7];
			String gl_sub_head_code = (String) a[8];
			String gl_sub_head_desc = (String) a[9];
			String country_of_incorp = (String) a[10];
			String cust_type = (String) a[11];
			String schm_code = (String) a[12];
			String schm_type = (String) a[13];
			String sol_id = (String) a[14];
			String acid = (String) a[15];
			String segment = (String) a[16];
			String sub_segment = (String) a[17];
			BigDecimal sector = (BigDecimal) a[18];
			String sub_sector = (String) a[19];
			String sector_code = (String) a[20];
			String group_id = (String) a[21];
			String constitution_code = (String) a[22];
			String country = (String) a[23];
			String legal_entity_type = (String) a[24];
			String constitution_desc = (String) a[25];
			String purpose_of_advn = (String) a[26];
			BigDecimal hni_networth = (BigDecimal) a[27];
			String turnover = (String) a[28];
			String bacid = (String) a[29];
			String report_name_1 = (String) a[30];
			String report_label_1 = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			String create_user = (String) a[35];
			Date create_time = (Date) a[36];
			String modify_user = (String) a[37];
			Date modify_time = (Date) a[38];
			String verify_user = (String) a[39];
			Date verify_time = (Date) a[40];
			String entity_flg = (String) a[41];
			String modify_flg = (String) a[42];
			String del_flg = (String) a[43];
			String nre_status = (String) a[44];
			Date report_date = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			String version = (String) a[48];
			String remarks = (String) a[49];
			

			BRF152_DETAIL_ENTITY py = new BRF152_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,amt_ac, 
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, 
					schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, 
					country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid, report_name_1,
					report_label_1, report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, 
					create_time, modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, 
					nre_status, report_date, maturity_date, version, gender, remarks);


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
		
		mv.setViewName("RR"+"/"+"BRF152::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF152(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-152-A";

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF152_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF152_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF152.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF152.jrxml");
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
			
			List<BRF152_Entity> T1Master = new ArrayList<BRF152_Entity>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);
			
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF152_Entity a where a.report_date = ?1 ", BRF152_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			if(T1Master.size() == 1) {
				
				for(BRF152_Entity BRF152 : T1Master ) {
			
			File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-152-AT.xls");
			
			  // Load the Excel file
	    	Workbook workbook = WorkbookFactory.create(Responsecamt);

	        // Get the first sheet
	    	Sheet sheet = workbook.getSheetAt(0);
	    	
	    	//srl_no -1
	    	
	        Row row = sheet.getRow(9);
	        Cell cell = row.getCell(3);
	        if (cell != null) {
	            cell.setCellValue(BRF152.getR1_national_amount() == null ? 0 :
	            	BRF152.getR1_national_amount().intValue());
	        }
	        Cell cell1 = row.getCell(4);
	        if (cell1 != null) {
	            cell1.setCellValue(BRF152.getR1_gross_value() == null ? 0 :
	            	BRF152.getR1_gross_value().intValue());
	        }
	        Cell cell2 = row.getCell(5);
	        if (cell2 != null) {
	            cell2.setCellValue(BRF152.getR1_residual_oneyear() == null ? 0 :
	            	BRF152.getR1_residual_oneyear().intValue());
	        }
	        Cell cell3 = row.getCell(6);
	        if (cell3 != null) {
	            cell3.setCellValue(BRF152.getR1_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR1_residual_onetothree_year().intValue());
	        }
	        Cell cell4 = row.getCell(7);
	        if (cell4 != null) {
	            cell4.setCellValue(BRF152.getR1_residual_threeyear() == null ? 0 :
	            	BRF152.getR1_residual_threeyear().intValue());
	        }
	        Cell cell5 = row.getCell(8);
	        if (cell5 != null) {
	            cell5.setCellValue(BRF152.getR1_tenper_oneyear() == null ? 0 :
	            	BRF152.getR1_tenper_oneyear().intValue());
	        }
	        Cell cell6 = row.getCell(9);
	        if (cell6 != null) {
	            cell6.setCellValue(BRF152.getR1_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR1_minustenper_oneyear().intValue());
	        }	
	        Cell cell7 = row.getCell(10);
	        if (cell7 != null) {
	            cell7.setCellValue(BRF152.getR1_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR1_tenper_onetothree_year().intValue());
	        }
	        Cell cell8 = row.getCell(11);
	        if (cell8 != null) {
	            cell8.setCellValue(BRF152.getR1_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR1_minustenper_onetothree_year().intValue());
	        }
	        Cell cell9 = row.getCell(12);
	        if (cell9 != null) {
	            cell9.setCellValue(BRF152.getR1_tenper_threeyear() == null ? 0 :
	            	BRF152.getR1_tenper_threeyear().intValue());
	        }
	        Cell cell10 = row.getCell(13);
	        if (cell10 != null) {
	        	cell10.setCellValue(BRF152.getR1_zero_threeyear() == null ? 0 :
	            	BRF152.getR1_zero_threeyear().intValue());
	        }
	       
//srl_no -12
	        Row row1 = sheet.getRow(12);
	        Cell R2cell = row1.getCell(3);
	        if (R2cell != null) {
	            R2cell.setCellValue(BRF152.getR2_national_amount() == null ? 0 :
	            	BRF152.getR2_national_amount().intValue());
	        }
	        Cell R2cell1 = row1.getCell(4);
	        if (R2cell1 != null) {
	            R2cell1.setCellValue(BRF152.getR2_gross_value() == null ? 0 :
	            	BRF152.getR2_gross_value().intValue());
	        }
	        Cell R2cell2 = row1.getCell(5);
	        if (R2cell2 != null) {
	            R2cell2.setCellValue(BRF152.getR2_residual_oneyear() == null ? 0 :
	            	BRF152.getR2_residual_oneyear().intValue());
	        }
	        Cell R2cell3 = row1.getCell(6);
	        if (R2cell3 != null) {
	            R2cell3.setCellValue(BRF152.getR2_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR2_residual_onetothree_year().intValue());
	        }
	        Cell R2cell4 = row1.getCell(7);
	        if (R2cell4 != null) {
	            R2cell4.setCellValue(BRF152.getR2_residual_threeyear() == null ? 0 :
	            	BRF152.getR2_residual_threeyear().intValue());
	        }
	        Cell R2cell5 = row1.getCell(8);
	        if (R2cell5 != null) {
	            R2cell5.setCellValue(BRF152.getR2_tenper_oneyear() == null ? 0 :
	            	BRF152.getR2_tenper_oneyear().intValue());
	        }
	        Cell R2cell6 = row1.getCell(9);
	        if (R2cell6 != null) {
	            R2cell6.setCellValue(BRF152.getR2_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR2_minustenper_oneyear().intValue());
	        }	
	        Cell R2cell7 = row1.getCell(10);
	        if (R2cell7 != null) {
	            R2cell7.setCellValue(BRF152.getR2_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR2_tenper_onetothree_year().intValue());
	        }
	        Cell R2cell8 = row1.getCell(11);
	        if (R2cell8 != null) {
	            R2cell8.setCellValue(BRF152.getR2_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR2_minustenper_onetothree_year().intValue());
	        }
	        Cell R2cell9 = row1.getCell(12);
	        if (R2cell9 != null) {
	            R2cell9.setCellValue(BRF152.getR2_tenper_threeyear() == null ? 0 :
	            	BRF152.getR2_tenper_threeyear().intValue());
	        }
	        Cell R2cell10 = row1.getCell(13);
	        if (R2cell10 != null) {
	        	R2cell10.setCellValue(BRF152.getR2_zero_threeyear() == null ? 0 :
	            	BRF152.getR2_zero_threeyear().intValue());
	        }
	        
	       
	      //srl_no -16///////
	        Row row2 = sheet.getRow(16);
	        Cell R3cell = row2.getCell(3);
	        if (R3cell != null) {
	            R3cell.setCellValue(BRF152.getR3_national_amount() == null ? 0 :
	            	BRF152.getR3_national_amount().intValue());
	        }
	        Cell R3cell1 = row2.getCell(4);
	        if (R3cell1 != null) {
	            R3cell1.setCellValue(BRF152.getR3_gross_value() == null ? 0 :
	            	BRF152.getR3_gross_value().intValue());
	        }
	        Cell R3cell2 = row2.getCell(5);
	        if (R3cell2 != null) {
	            R3cell2.setCellValue(BRF152.getR3_residual_oneyear() == null ? 0 :
	            	BRF152.getR3_residual_oneyear().intValue());
	        }
	        Cell R3cell3 = row2.getCell(6);
	        if (R3cell3 != null) {
	            R3cell3.setCellValue(BRF152.getR3_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR3_residual_onetothree_year().intValue());
	        }
	        Cell R3cell4 = row2.getCell(7);
	        if (R3cell4 != null) {
	            R3cell4.setCellValue(BRF152.getR3_residual_threeyear() == null ? 0 :
	            	BRF152.getR3_residual_threeyear().intValue());
	        }
	        Cell R3cell5 = row2.getCell(8);
	        if (R3cell5 != null) {
	            R3cell5.setCellValue(BRF152.getR3_tenper_oneyear() == null ? 0 :
	            	BRF152.getR3_tenper_oneyear().intValue());
	        }
	        Cell R3cell6 = row2.getCell(9);
	        if (R3cell6 != null) {
	            R3cell6.setCellValue(BRF152.getR3_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR3_minustenper_oneyear().intValue());
	        }	
	        Cell R3cell7 = row2.getCell(10);
	        if (R3cell7 != null) {
	            R3cell7.setCellValue(BRF152.getR3_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR3_tenper_onetothree_year().intValue());
	        }
	        Cell R3cell8 = row2.getCell(11);
	        if (R3cell8 != null) {
	            R3cell8.setCellValue(BRF152.getR3_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR3_minustenper_onetothree_year().intValue());
	        }
	        Cell R3cell9 = row2.getCell(12);
	        if (R3cell9 != null) {
	            R3cell9.setCellValue(BRF152.getR3_tenper_threeyear() == null ? 0 :
	            	BRF152.getR3_tenper_threeyear().intValue());
	        }
	        Cell R3cell10 = row2.getCell(13);
	        if (R3cell10 != null) {
	        	R3cell10.setCellValue(BRF152.getR3_zero_threeyear() == null ? 0 :
	            	BRF152.getR3_zero_threeyear().intValue());
	        }
	        
	        //srl_no -19///////
	        Row row3 = sheet.getRow(19);
	        Cell R4cell = row3.getCell(3);
	        if (R4cell != null) {
	            R4cell.setCellValue(BRF152.getR4_national_amount() == null ? 0 :
	            	BRF152.getR4_national_amount().intValue());
	        }
	        Cell R4cell1 = row3.getCell(4);
	        if (R4cell1 != null) {
	            R4cell1.setCellValue(BRF152.getR4_gross_value() == null ? 0 :
	            	BRF152.getR4_gross_value().intValue());
	        }
	        Cell R4cell2 = row3.getCell(5);
	        if (R4cell2 != null) {
	            R4cell2.setCellValue(BRF152.getR4_residual_oneyear() == null ? 0 :
	            	BRF152.getR4_residual_oneyear().intValue());
	        }
	        Cell R4cell3 = row3.getCell(6);
	        if (R4cell3 != null) {
	            R4cell3.setCellValue(BRF152.getR4_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR4_residual_onetothree_year().intValue());
	        }
	        Cell R4cell4 = row3.getCell(7);
	        if (R4cell4 != null) {
	            R4cell4.setCellValue(BRF152.getR4_residual_threeyear() == null ? 0 :
	            	BRF152.getR4_residual_threeyear().intValue());
	        }
	        Cell R4cell5 = row3.getCell(8);
	        if (R4cell5 != null) {
	            R4cell5.setCellValue(BRF152.getR4_tenper_oneyear() == null ? 0 :
	            	BRF152.getR4_tenper_oneyear().intValue());
	        }
	        Cell R4cell6 = row3.getCell(9);
	        if (R4cell6 != null) {
	            R4cell6.setCellValue(BRF152.getR4_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR4_minustenper_oneyear().intValue());
	        }	
	        Cell R4cell7 = row3.getCell(10);
	        if (R4cell7 != null) {
	            R4cell7.setCellValue(BRF152.getR4_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR4_tenper_onetothree_year().intValue());
	        }
	        Cell R4cell8 = row3.getCell(11);
	        if (R4cell8 != null) {
	            R4cell8.setCellValue(BRF152.getR4_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR4_minustenper_onetothree_year().intValue());
	        }
	        Cell R4cell9 = row3.getCell(12);
	        if (R4cell9 != null) {
	            R4cell9.setCellValue(BRF152.getR4_tenper_threeyear() == null ? 0 :
	            	BRF152.getR4_tenper_threeyear().intValue());
	        }
	        Cell R4cell10 = row3.getCell(13);
	        if (R4cell10 != null) {
	        	R4cell10.setCellValue(BRF152.getR4_zero_threeyear() == null ? 0 :
	            	BRF152.getR4_zero_threeyear().intValue());
	        }
	        
	        
	        //srl_no -23///////
	        Row row4 = sheet.getRow(23);
	        
	        Cell R5cell = row4.getCell(3);
	        if (R5cell != null) {
	            R5cell.setCellValue(BRF152.getR5_national_amount() == null ? 0 :
	            	BRF152.getR5_national_amount().intValue());
	        }
	        Cell R5cell1 = row4.getCell(4);
	        if (R5cell1 != null) {
	            R5cell1.setCellValue(BRF152.getR5_gross_value() == null ? 0 :
	            	BRF152.getR5_gross_value().intValue());
	        }
	        Cell R5cell2 = row4.getCell(5);
	        if (R5cell2 != null) {
	            R5cell2.setCellValue(BRF152.getR5_residual_oneyear() == null ? 0 :
	            	BRF152.getR5_residual_oneyear().intValue());
	        }
	        Cell R5cell3 = row4.getCell(6);
	        if (R5cell3 != null) {
	            R5cell3.setCellValue(BRF152.getR5_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR5_residual_onetothree_year().intValue());
	        }
	        Cell R5cell4 = row4.getCell(7);
	        if (R5cell4 != null) {
	            R5cell4.setCellValue(BRF152.getR5_residual_threeyear() == null ? 0 :
	            	BRF152.getR5_residual_threeyear().intValue());
	        }
	        Cell R5cell5 = row4.getCell(8);
	        if (R5cell5 != null) {
	            R5cell5.setCellValue(BRF152.getR5_tenper_oneyear() == null ? 0 :
	            	BRF152.getR5_tenper_oneyear().intValue());
	        }
	        Cell R5cell6 = row4.getCell(9);
	        if (R5cell6 != null) {
	            R5cell6.setCellValue(BRF152.getR5_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR5_minustenper_oneyear().intValue());
	        }	
	        Cell R5cell7 = row4.getCell(10);
	        if (R5cell7 != null) {
	            R5cell7.setCellValue(BRF152.getR5_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR5_tenper_onetothree_year().intValue());
	        }
	        Cell R5cell8 = row4.getCell(11);
	        if (R5cell8 != null) {
	            R5cell8.setCellValue(BRF152.getR5_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR5_minustenper_onetothree_year().intValue());
	        }
	        Cell R5cell9 = row4.getCell(12);
	        if (R5cell9 != null) {
	            R5cell9.setCellValue(BRF152.getR5_tenper_threeyear() == null ? 0 :
	            	BRF152.getR5_tenper_threeyear().intValue());
	        }
	        Cell R5cell10 = row4.getCell(13);
	        if (R5cell10 != null) {
	        	R5cell10.setCellValue(BRF152.getR5_zero_threeyear() == null ? 0 :
	            	BRF152.getR5_zero_threeyear().intValue());
	        }
	        
	        
	        //srl_no -26///////
	        Row row5 = sheet.getRow(26);
	        
	        Cell R6cell = row5.getCell(3);
	        if (R6cell != null) {
	            R6cell.setCellValue(BRF152.getR6_national_amount() == null ? 0 :
	            	BRF152.getR6_national_amount().intValue());
	        }
	        Cell R6cell1 = row5.getCell(4);
	        if (R6cell1 != null) {
	            R6cell1.setCellValue(BRF152.getR6_gross_value() == null ? 0 :
	            	BRF152.getR6_gross_value().intValue());
	        }
	        Cell R6cell2 = row5.getCell(5);
	        if (R6cell2 != null) {
	            R6cell2.setCellValue(BRF152.getR6_residual_oneyear() == null ? 0 :
	            	BRF152.getR6_residual_oneyear().intValue());
	        }
	        Cell R6cell3 = row5.getCell(6);
	        if (R6cell3 != null) {
	            R6cell3.setCellValue(BRF152.getR6_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR6_residual_onetothree_year().intValue());
	        }
	        Cell R6cell4 = row5.getCell(7);
	        if (R6cell4 != null) {
	            R6cell4.setCellValue(BRF152.getR6_residual_threeyear() == null ? 0 :
	            	BRF152.getR6_residual_threeyear().intValue());
	        }
	        Cell R6cell5 = row5.getCell(8);
	        if (R6cell5 != null) {
	            R6cell5.setCellValue(BRF152.getR6_tenper_oneyear() == null ? 0 :
	            	BRF152.getR6_tenper_oneyear().intValue());
	        }
	        Cell R6cell6 = row5.getCell(9);
	        if (R6cell6 != null) {
	            R6cell6.setCellValue(BRF152.getR6_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR6_minustenper_oneyear().intValue());
	        }	
	        Cell R6cell7 = row5.getCell(10);
	        if (R6cell7 != null) {
	            R6cell7.setCellValue(BRF152.getR6_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR6_tenper_onetothree_year().intValue());
	        }
	        Cell R6cell8 = row5.getCell(11);
	        if (R6cell8 != null) {
	            R6cell8.setCellValue(BRF152.getR6_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR6_minustenper_onetothree_year().intValue());
	        }
	        Cell R6cell9 = row5.getCell(12);
	        if (R6cell9 != null) {
	            R6cell9.setCellValue(BRF152.getR6_tenper_threeyear() == null ? 0 :
	            	BRF152.getR6_tenper_threeyear().intValue());
	        }
	        Cell R6cell10 = row5.getCell(13);
	        if (R6cell10 != null) {
	        	R6cell10.setCellValue(BRF152.getR6_zero_threeyear() == null ? 0 :
	            	BRF152.getR6_zero_threeyear().intValue());
	        }
	       //////srl_no -30///////
	        Row row6 = sheet.getRow(30);
	        
	        Cell R7cell = row6.getCell(3);
	        if (R7cell != null) {
	            R7cell.setCellValue(BRF152.getR7_national_amount() == null ? 0 :
	            	BRF152.getR7_national_amount().intValue());
	        }
	        Cell R7cell1 = row6.getCell(4);
	        if (R7cell1 != null) {
	            R7cell1.setCellValue(BRF152.getR7_gross_value() == null ? 0 :
	            	BRF152.getR7_gross_value().intValue());
	        }
	        Cell R7cell2 = row6.getCell(5);
	        if (R7cell2 != null) {
	            R7cell2.setCellValue(BRF152.getR7_residual_oneyear() == null ? 0 :
	            	BRF152.getR7_residual_oneyear().intValue());
	        }
	        Cell R7cell3 = row6.getCell(6);
	        if (R7cell3 != null) {
	            R7cell3.setCellValue(BRF152.getR7_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR7_residual_onetothree_year().intValue());
	        }
	        Cell R7cell4 = row6.getCell(7);
	        if (R7cell4 != null) {
	            R7cell4.setCellValue(BRF152.getR7_residual_threeyear() == null ? 0 :
	            	BRF152.getR7_residual_threeyear().intValue());
	        }
	        Cell R7cell5 = row6.getCell(8);
	        if (R7cell5 != null) {
	            R7cell5.setCellValue(BRF152.getR7_tenper_oneyear() == null ? 0 :
	            	BRF152.getR7_tenper_oneyear().intValue());
	        }
	        Cell R7cell6 = row6.getCell(9);
	        if (R7cell6 != null) {
	            R7cell6.setCellValue(BRF152.getR7_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR7_minustenper_oneyear().intValue());
	        }	
	        Cell R7cell7 = row6.getCell(10);
	        if (R7cell7 != null) {
	            R7cell7.setCellValue(BRF152.getR7_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR7_tenper_onetothree_year().intValue());
	        }
	        Cell R7cell8 = row6.getCell(11);
	        if (R7cell8 != null) {
	            R7cell8.setCellValue(BRF152.getR7_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR7_minustenper_onetothree_year().intValue());
	        }
	        Cell R7cell9 = row6.getCell(12);
	        if (R7cell9 != null) {
	            R7cell9.setCellValue(BRF152.getR7_tenper_threeyear() == null ? 0 :
	            	BRF152.getR7_tenper_threeyear().intValue());
	        }
	        Cell R7cell10 = row6.getCell(13);
	        if (R7cell10 != null) {
	        	R7cell10.setCellValue(BRF152.getR7_zero_threeyear() == null ? 0 :
	            	BRF152.getR7_zero_threeyear().intValue());
	        }
	      /////srl_no -33///////
	        Row row7 = sheet.getRow(33);
	        Cell R8cell = row7.getCell(3);
	        if (R8cell != null) {
	            R8cell.setCellValue(BRF152.getR8_national_amount() == null ? 0 :
	            	BRF152.getR8_national_amount().intValue());
	        }
	        Cell R8cell1 = row7.getCell(4);
	        if (R8cell1 != null) {
	            R8cell1.setCellValue(BRF152.getR8_gross_value() == null ? 0 :
	            	BRF152.getR8_gross_value().intValue());
	        }
	        Cell R8cell2 = row7.getCell(5);
	        if (R8cell2 != null) {
	            R8cell2.setCellValue(BRF152.getR8_residual_oneyear() == null ? 0 :
	            	BRF152.getR8_residual_oneyear().intValue());
	        }
	        Cell R8cell3 = row7.getCell(6);
	        if (R8cell3 != null) {
	            R8cell3.setCellValue(BRF152.getR8_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR8_residual_onetothree_year().intValue());
	        }
	        Cell R8cell4 = row7.getCell(7);
	        if (R8cell4 != null) {
	            R8cell4.setCellValue(BRF152.getR8_residual_threeyear() == null ? 0 :
	            	BRF152.getR8_residual_threeyear().intValue());
	        }
	        Cell R8cell5 = row7.getCell(8);
	        if (R8cell5 != null) {
	            R8cell5.setCellValue(BRF152.getR8_tenper_oneyear() == null ? 0 :
	            	BRF152.getR8_tenper_oneyear().intValue());
	        }
	        Cell R8cell6 = row7.getCell(9);
	        if (R8cell6 != null) {
	            R8cell6.setCellValue(BRF152.getR8_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR8_minustenper_oneyear().intValue());
	        }	
	        Cell R8cell7 = row7.getCell(10);
	        if (R8cell7 != null) {
	            R8cell7.setCellValue(BRF152.getR8_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR8_tenper_onetothree_year().intValue());
	        }
	        Cell R8cell8 = row7.getCell(11);
	        if (R8cell8 != null) {
	            R8cell8.setCellValue(BRF152.getR8_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR8_minustenper_onetothree_year().intValue());
	        }
	        Cell R8cell9 = row7.getCell(12);
	        if (R8cell9 != null) {
	            R8cell9.setCellValue(BRF152.getR8_tenper_threeyear() == null ? 0 :
	            	BRF152.getR8_tenper_threeyear().intValue());
	        }
	        Cell R8cell10 = row7.getCell(13);
	        if (R8cell10 != null) {
	        	R8cell10.setCellValue(BRF152.getR8_zero_threeyear() == null ? 0 :
	            	BRF152.getR8_zero_threeyear().intValue());
	        }
	        
	        //srl_no -37///////
	        Row row8 = sheet.getRow(37);
	        Cell R9cell = row8.getCell(3);
	        if (R9cell != null) {
	            R9cell.setCellValue(BRF152.getR9_national_amount() == null ? 0 :
	            	BRF152.getR9_national_amount().intValue());
	        }
	        Cell R9cell1 = row8.getCell(4);
	        if (R9cell1 != null) {
	            R9cell1.setCellValue(BRF152.getR9_gross_value() == null ? 0 :
	            	BRF152.getR9_gross_value().intValue());
	        }
	        Cell R9cell2 = row8.getCell(5);
	        if (R9cell2 != null) {
	            R9cell2.setCellValue(BRF152.getR9_residual_oneyear() == null ? 0 :
	            	BRF152.getR9_residual_oneyear().intValue());
	        }
	        Cell R9cell3 = row8.getCell(6);
	        if (R9cell3 != null) {
	            R9cell3.setCellValue(BRF152.getR9_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR9_residual_onetothree_year().intValue());
	        }
	        Cell R9cell4 = row8.getCell(7);
	        if (R9cell4 != null) {
	            R9cell4.setCellValue(BRF152.getR9_residual_threeyear() == null ? 0 :
	            	BRF152.getR9_residual_threeyear().intValue());
	        }
	        Cell R9cell5 = row8.getCell(8);
	        if (R9cell5 != null) {
	            R9cell5.setCellValue(BRF152.getR9_tenper_oneyear() == null ? 0 :
	            	BRF152.getR9_tenper_oneyear().intValue());
	        }
	        Cell R9cell6 = row8.getCell(9);
	        if (R9cell6 != null) {
	            R9cell6.setCellValue(BRF152.getR9_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR9_minustenper_oneyear().intValue());
	        }	
	        Cell R9cell7 = row8.getCell(10);
	        if (R9cell7 != null) {
	            R9cell7.setCellValue(BRF152.getR9_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR9_tenper_onetothree_year().intValue());
	        }
	        Cell R9cell8 = row8.getCell(11);
	        if (R9cell8 != null) {
	            R9cell8.setCellValue(BRF152.getR9_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR9_minustenper_onetothree_year().intValue());
	        }
	        Cell R9cell9 = row8.getCell(12);
	        if (R9cell9 != null) {
	            R9cell9.setCellValue(BRF152.getR9_tenper_threeyear() == null ? 0 :
	            	BRF152.getR9_tenper_threeyear().intValue());
	        }
	        Cell R9cell10 = row8.getCell(13);
	        if (R9cell10 != null) {
	        	R9cell10.setCellValue(BRF152.getR9_zero_threeyear() == null ? 0 :
	            	BRF152.getR9_zero_threeyear().intValue());
	        }
	       //////srl_no -40///////
	        Row row9 = sheet.getRow(40);
	        Cell R10cell = row9.getCell(3);
	        if (R10cell != null) {
	            R10cell.setCellValue(BRF152.getR10_national_amount() == null ? 0 :
	            	BRF152.getR10_national_amount().intValue());
	        }
	        Cell R10cell1 = row9.getCell(4);
	        if (R10cell1 != null) {
	            R10cell1.setCellValue(BRF152.getR10_gross_value() == null ? 0 :
	            	BRF152.getR10_gross_value().intValue());
	        }
	        Cell R10cell2 = row9.getCell(5);
	        if (R10cell2 != null) {
	            R10cell2.setCellValue(BRF152.getR10_residual_oneyear() == null ? 0 :
	            	BRF152.getR10_residual_oneyear().intValue());
	        }
	        Cell R10cell3 = row9.getCell(6);
	        if (R10cell3 != null) {
	            R10cell3.setCellValue(BRF152.getR10_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR10_residual_onetothree_year().intValue());
	        }
	        Cell R10cell4 = row9.getCell(7);
	        if (R10cell4 != null) {
	            R10cell4.setCellValue(BRF152.getR10_residual_threeyear() == null ? 0 :
	            	BRF152.getR10_residual_threeyear().intValue());
	        }
	        Cell R10cell5 = row9.getCell(8);
	        if (R10cell5 != null) {
	            R10cell5.setCellValue(BRF152.getR10_tenper_oneyear() == null ? 0 :
	            	BRF152.getR10_tenper_oneyear().intValue());
	        }
	        Cell R10cell6 = row9.getCell(9);
	        if (R10cell6 != null) {
	            R10cell6.setCellValue(BRF152.getR10_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR10_minustenper_oneyear().intValue());
	        }	
	        Cell R10cell7 = row9.getCell(10);
	        if (R10cell7 != null) {
	            R10cell7.setCellValue(BRF152.getR10_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR10_tenper_onetothree_year().intValue());
	        }
	        Cell R10cell8 = row9.getCell(11);
	        if (R10cell8 != null) {
	            R10cell8.setCellValue(BRF152.getR10_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR10_minustenper_onetothree_year().intValue());
	        }
	        Cell R10cell9 = row9.getCell(12);
	        if (R10cell9 != null) {
	            R10cell9.setCellValue(BRF152.getR10_tenper_threeyear() == null ? 0 :
	            	BRF152.getR10_tenper_threeyear().intValue());
	        }
	        Cell R10cell10 = row9.getCell(13);
	        if (R10cell10 != null) {
	        	R10cell10.setCellValue(BRF152.getR10_zero_threeyear() == null ? 0 :
	            	BRF152.getR10_zero_threeyear().intValue());
	        }
	        
	        //////srl_no -45///////
	        Row row10 = sheet.getRow(45);
	        
	        
	       
	        //////srl_no -48///////
	        Row row11 = sheet.getRow(48);
	        
	        Cell R12cell = row11.getCell(3);
	        if (R12cell != null) {
	            R12cell.setCellValue(BRF152.getR12_national_amount() == null ? 0 :
	            	BRF152.getR12_national_amount().intValue());
	        }
	        Cell R12cell1 = row11.getCell(4);
	        if (R12cell1 != null) {
	            R12cell1.setCellValue(BRF152.getR12_gross_value() == null ? 0 :
	            	BRF152.getR12_gross_value().intValue());
	        }
	        Cell R12cell2 = row11.getCell(5);
	        if (R12cell2 != null) {
	            R12cell2.setCellValue(BRF152.getR12_residual_oneyear() == null ? 0 :
	            	BRF152.getR12_residual_oneyear().intValue());
	        }
	        Cell R12cell3 = row11.getCell(6);
	        if (R12cell3 != null) {
	            R12cell3.setCellValue(BRF152.getR12_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR12_residual_onetothree_year().intValue());
	        }
	        Cell R12cell4 = row11.getCell(7);
	        if (R12cell4 != null) {
	            R12cell4.setCellValue(BRF152.getR12_residual_threeyear() == null ? 0 :
	            	BRF152.getR12_residual_threeyear().intValue());
	        }
	        Cell R12cell5 = row11.getCell(8);
	        if (R12cell5 != null) {
	            R12cell5.setCellValue(BRF152.getR12_tenper_oneyear() == null ? 0 :
	            	BRF152.getR12_tenper_oneyear().intValue());
	        }
	        Cell R12cell6 = row11.getCell(9);
	        if (R12cell6 != null) {
	            R12cell6.setCellValue(BRF152.getR12_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR12_minustenper_oneyear().intValue());
	        }	
	        Cell R12cell7 = row11.getCell(10);
	        if (R12cell7 != null) {
	            R12cell7.setCellValue(BRF152.getR12_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR12_tenper_onetothree_year().intValue());
	        }
	        Cell R12cell8 = row11.getCell(11);
	        if (R12cell8 != null) {
	            R12cell8.setCellValue(BRF152.getR12_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR12_minustenper_onetothree_year().intValue());
	        }
	        Cell R12cell9 = row11.getCell(12);
	        if (R12cell9 != null) {
	            R12cell9.setCellValue(BRF152.getR12_tenper_threeyear() == null ? 0 :
	            	BRF152.getR12_tenper_threeyear().intValue());
	        }
	        Cell R12cell10 = row11.getCell(13);
	        if (R12cell10 != null) {
	        	R12cell10.setCellValue(BRF152.getR12_zero_threeyear() == null ? 0 :
	            	BRF152.getR12_zero_threeyear().intValue());
	        }
	        
	        //////srl_no -52///////
	        Row row12 = sheet.getRow(52);
	        Cell R13cell = row12.getCell(3);
	        if (R13cell != null) {
	            R13cell.setCellValue(BRF152.getR13_national_amount() == null ? 0 :
	            	BRF152.getR13_national_amount().intValue());
	        }
	        Cell R13cell1 = row12.getCell(4);
	        if (R13cell1 != null) {
	            R13cell1.setCellValue(BRF152.getR13_gross_value() == null ? 0 :
	            	BRF152.getR13_gross_value().intValue());
	        }
	        Cell R13cell2 = row12.getCell(5);
	        if (R13cell2 != null) {
	            R13cell2.setCellValue(BRF152.getR13_residual_oneyear() == null ? 0 :
	            	BRF152.getR13_residual_oneyear().intValue());
	        }
	        Cell R13cell3 = row12.getCell(6);
	        if (R13cell3 != null) {
	            R13cell3.setCellValue(BRF152.getR13_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR13_residual_onetothree_year().intValue());
	        }
	        Cell R13cell4 = row12.getCell(7);
	        if (R13cell4 != null) {
	            R13cell4.setCellValue(BRF152.getR13_residual_threeyear() == null ? 0 :
	            	BRF152.getR13_residual_threeyear().intValue());
	        }
	        Cell R13cell5 = row12.getCell(8);
	        if (R13cell5 != null) {
	            R13cell5.setCellValue(BRF152.getR13_tenper_oneyear() == null ? 0 :
	            	BRF152.getR13_tenper_oneyear().intValue());
	        }
	        Cell R13cell6 = row12.getCell(9);
	        if (R13cell6 != null) {
	            R13cell6.setCellValue(BRF152.getR13_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR13_minustenper_oneyear().intValue());
	        }	
	        Cell R13cell7 = row12.getCell(10);
	        if (R13cell7 != null) {
	            R13cell7.setCellValue(BRF152.getR13_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR13_tenper_onetothree_year().intValue());
	        }
	        Cell R13cell8 = row12.getCell(11);
	        if (R13cell8 != null) {
	            R13cell8.setCellValue(BRF152.getR13_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR13_minustenper_onetothree_year().intValue());
	        }
	        Cell R13cell9 = row12.getCell(12);
	        if (R13cell9 != null) {
	            R13cell9.setCellValue(BRF152.getR13_tenper_threeyear() == null ? 0 :
	            	BRF152.getR13_tenper_threeyear().intValue());
	        }
	        Cell R13cell10 = row12.getCell(13);
	        if (R13cell10 != null) {
	        	R13cell10.setCellValue(BRF152.getR13_zero_threeyear() == null ? 0 :
	            	BRF152.getR13_zero_threeyear().intValue());
	        }
	        //////srl_no -55///////
	        Row row13 = sheet.getRow(55);
	        
	        Cell R14cell = row13.getCell(3);
	        if (R14cell != null) {
	            R14cell.setCellValue(BRF152.getR14_national_amount() == null ? 0 :
	            	BRF152.getR14_national_amount().intValue());
	        }
	        Cell R14cell1 = row13.getCell(4);
	        if (R14cell1 != null) {
	            R14cell1.setCellValue(BRF152.getR14_gross_value() == null ? 0 :
	            	BRF152.getR14_gross_value().intValue());
	        }
	        Cell R14cell2 = row13.getCell(5);
	        if (R14cell2 != null) {
	            R14cell2.setCellValue(BRF152.getR14_residual_oneyear() == null ? 0 :
	            	BRF152.getR14_residual_oneyear().intValue());
	        }
	        Cell R14cell3 = row13.getCell(6);
	        if (R14cell3 != null) {
	            R14cell3.setCellValue(BRF152.getR14_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR14_residual_onetothree_year().intValue());
	        }
	        Cell R14cell4 = row13.getCell(7);
	        if (R14cell4 != null) {
	            R14cell4.setCellValue(BRF152.getR14_residual_threeyear() == null ? 0 :
	            	BRF152.getR14_residual_threeyear().intValue());
	        }
	        Cell R14cell5 = row13.getCell(8);
	        if (R14cell5 != null) {
	            R14cell5.setCellValue(BRF152.getR14_tenper_oneyear() == null ? 0 :
	            	BRF152.getR14_tenper_oneyear().intValue());
	        }
	        Cell R14cell6 = row13.getCell(9);
	        if (R14cell6 != null) {
	            R14cell6.setCellValue(BRF152.getR14_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR14_minustenper_oneyear().intValue());
	        }	
	        Cell R14cell7 = row13.getCell(10);
	        if (R14cell7 != null) {
	            R14cell7.setCellValue(BRF152.getR14_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR14_tenper_onetothree_year().intValue());
	        }
	        Cell R14cell8 = row13.getCell(11);
	        if (R14cell8 != null) {
	            R14cell8.setCellValue(BRF152.getR14_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR14_minustenper_onetothree_year().intValue());
	        }
	        Cell R14cell9 = row13.getCell(12);
	        if (R14cell9 != null) {
	            R14cell9.setCellValue(BRF152.getR14_tenper_threeyear() == null ? 0 :
	            	BRF152.getR14_tenper_threeyear().intValue());
	        }
	        Cell R14cell10 = row13.getCell(13);
	        if (R14cell10 != null) {
	        	R14cell10.setCellValue(BRF152.getR14_zero_threeyear() == null ? 0 :
	            	BRF152.getR14_zero_threeyear().intValue());
	        }
	        
	        
	        //////srl_no -59///////
	        Row row14 = sheet.getRow(59);
	        
	        Cell R15cell = row14.getCell(3);
	        if (R15cell != null) {
	            R15cell.setCellValue(BRF152.getR15_national_amount() == null ? 0 :
	            	BRF152.getR15_national_amount().intValue());
	        }
	        Cell R15cell1 = row14.getCell(4);
	        if (R15cell1 != null) {
	            R15cell1.setCellValue(BRF152.getR15_gross_value() == null ? 0 :
	            	BRF152.getR15_gross_value().intValue());
	        }
	        Cell R15cell2 = row14.getCell(5);
	        if (R15cell2 != null) {
	            R15cell2.setCellValue(BRF152.getR15_residual_oneyear() == null ? 0 :
	            	BRF152.getR15_residual_oneyear().intValue());
	        }
	        Cell R15cell3 = row14.getCell(6);
	        if (R15cell3 != null) {
	            R15cell3.setCellValue(BRF152.getR15_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR15_residual_onetothree_year().intValue());
	        }
	        Cell R15cell4 = row14.getCell(7);
	        if (R15cell4 != null) {
	            R15cell4.setCellValue(BRF152.getR15_residual_threeyear() == null ? 0 :
	            	BRF152.getR15_residual_threeyear().intValue());
	        }
	        Cell R15cell5 = row14.getCell(8);
	        if (R15cell5 != null) {
	            R15cell5.setCellValue(BRF152.getR15_tenper_oneyear() == null ? 0 :
	            	BRF152.getR15_tenper_oneyear().intValue());
	        }
	        Cell R15cell6 = row14.getCell(9);
	        if (R15cell6 != null) {
	            R15cell6.setCellValue(BRF152.getR15_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR15_minustenper_oneyear().intValue());
	        }	
	        Cell R15cell7 = row14.getCell(10);
	        if (R15cell7 != null) {
	            R15cell7.setCellValue(BRF152.getR15_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR15_tenper_onetothree_year().intValue());
	        }
	        Cell R15cell8 = row14.getCell(11);
	        if (R15cell8 != null) {
	            R15cell8.setCellValue(BRF152.getR15_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR15_minustenper_onetothree_year().intValue());
	        }
	        Cell R15cell9 = row14.getCell(12);
	        if (R15cell9 != null) {
	            R15cell9.setCellValue(BRF152.getR15_tenper_threeyear() == null ? 0 :
	            	BRF152.getR15_tenper_threeyear().intValue());
	        }
	        Cell R15cell10 = row14.getCell(13);
	        if (R15cell10 != null) {
	        	R15cell10.setCellValue(BRF152.getR15_zero_threeyear() == null ? 0 :
	            	BRF152.getR15_zero_threeyear().intValue());
	        }
	        
	        //////srl_no -62///////
	        Row row15 = sheet.getRow(62);
	        Cell R16cell = row15.getCell(3);
	        if (R16cell != null) {
	            R16cell.setCellValue(BRF152.getR16_national_amount() == null ? 0 :
	            	BRF152.getR16_national_amount().intValue());
	        }
	        Cell R16cell1 = row15.getCell(4);
	        if (R16cell1 != null) {
	            R16cell1.setCellValue(BRF152.getR16_gross_value() == null ? 0 :
	            	BRF152.getR16_gross_value().intValue());
	        }
	        Cell R16cell2 = row15.getCell(5);
	        if (R16cell2 != null) {
	            R16cell2.setCellValue(BRF152.getR16_residual_oneyear() == null ? 0 :
	            	BRF152.getR16_residual_oneyear().intValue());
	        }
	        Cell R16cell3 = row15.getCell(6);
	        if (R16cell3 != null) {
	            R16cell3.setCellValue(BRF152.getR16_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR16_residual_onetothree_year().intValue());
	        }
	        Cell R16cell4 = row15.getCell(7);
	        if (R16cell4 != null) {
	            R16cell4.setCellValue(BRF152.getR16_residual_threeyear() == null ? 0 :
	            	BRF152.getR16_residual_threeyear().intValue());
	        }
	        Cell R16cell5 = row15.getCell(8);
	        if (R16cell5 != null) {
	            R16cell5.setCellValue(BRF152.getR16_tenper_oneyear() == null ? 0 :
	            	BRF152.getR16_tenper_oneyear().intValue());
	        }
	        Cell R16cell6 = row15.getCell(9);
	        if (R16cell6 != null) {
	            R16cell6.setCellValue(BRF152.getR16_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR16_minustenper_oneyear().intValue());
	        }	
	        Cell R16cell7 = row15.getCell(10);
	        if (R16cell7 != null) {
	            R16cell7.setCellValue(BRF152.getR16_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR16_tenper_onetothree_year().intValue());
	        }
	        Cell R16cell8 = row15.getCell(11);
	        if (R16cell8 != null) {
	            R16cell8.setCellValue(BRF152.getR16_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR16_minustenper_onetothree_year().intValue());
	        }
	        Cell R16cell9 = row15.getCell(12);
	        if (R16cell9 != null) {
	            R16cell9.setCellValue(BRF152.getR16_tenper_threeyear() == null ? 0 :
	            	BRF152.getR16_tenper_threeyear().intValue());
	        }
	        Cell R16cell10 = row15.getCell(13);
	        if (R16cell10 != null) {
	        	R16cell10.setCellValue(BRF152.getR16_zero_threeyear() == null ? 0 :
	            	BRF152.getR16_zero_threeyear().intValue());
	        }
	        
	        
	        
	        
	        //////srl_no -66///////
	        Row row16 = sheet.getRow(66);
	        
	        Cell R17cell = row16.getCell(3);
	        if (R17cell != null) {
	            R17cell.setCellValue(BRF152.getR17_national_amount() == null ? 0 :
	            	BRF152.getR17_national_amount().intValue());
	        }
	        Cell R17cell1 = row16.getCell(4);
	        if (R17cell1 != null) {
	            R17cell1.setCellValue(BRF152.getR17_gross_value() == null ? 0 :
	            	BRF152.getR17_gross_value().intValue());
	        }
	        Cell R17cell2 = row16.getCell(5);
	        if (R17cell2 != null) {
	            R17cell2.setCellValue(BRF152.getR17_residual_oneyear() == null ? 0 :
	            	BRF152.getR17_residual_oneyear().intValue());
	        }
	        Cell R17cell3 = row16.getCell(6);
	        if (R17cell3 != null) {
	            R17cell3.setCellValue(BRF152.getR17_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR17_residual_onetothree_year().intValue());
	        }
	        Cell R17cell4 = row16.getCell(7);
	        if (R17cell4 != null) {
	            R17cell4.setCellValue(BRF152.getR17_residual_threeyear() == null ? 0 :
	            	BRF152.getR17_residual_threeyear().intValue());
	        }
	        Cell R17cell5 = row16.getCell(8);
	        if (R17cell5 != null) {
	            R17cell5.setCellValue(BRF152.getR17_tenper_oneyear() == null ? 0 :
	            	BRF152.getR17_tenper_oneyear().intValue());
	        }
	        Cell R17cell6 = row16.getCell(9);
	        if (R17cell6 != null) {
	            R17cell6.setCellValue(BRF152.getR17_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR17_minustenper_oneyear().intValue());
	        }	
	        Cell R17cell7 = row16.getCell(10);
	        if (R17cell7 != null) {
	            R17cell7.setCellValue(BRF152.getR17_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR17_tenper_onetothree_year().intValue());
	        }
	        Cell R17cell8 = row16.getCell(11);
	        if (R17cell8 != null) {
	            R17cell8.setCellValue(BRF152.getR17_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR17_minustenper_onetothree_year().intValue());
	        }
	        Cell R17cell9 = row16.getCell(12);
	        if (R17cell9 != null) {
	            R17cell9.setCellValue(BRF152.getR17_tenper_threeyear() == null ? 0 :
	            	BRF152.getR17_tenper_threeyear().intValue());
	        }
	        Cell R17cell10 = row16.getCell(13);
	        if (R17cell10 != null) {
	        	R17cell10.setCellValue(BRF152.getR17_zero_threeyear() == null ? 0 :
	            	BRF152.getR17_zero_threeyear().intValue());
	        }
	        
	  //////srl_no -69///////
	        Row row17 = sheet.getRow(69);
	        
	        Cell R18cel = row17.getCell(3);
	        if (R18cel != null) {
	            R18cel.setCellValue(BRF152.getR18_national_amount() == null ? 0 :
	            	BRF152.getR18_national_amount().intValue());
	        }
	        Cell R18cell1 = row17.getCell(4);
	        if (R18cell1 != null) {
	            R18cell1.setCellValue(BRF152.getR18_gross_value() == null ? 0 :
	            	BRF152.getR18_gross_value().intValue());
	        }
	        Cell R18cell2 = row17.getCell(5);
	        if (R18cell2 != null) {
	            R18cell2.setCellValue(BRF152.getR18_residual_oneyear() == null ? 0 :
	            	BRF152.getR18_residual_oneyear().intValue());
	        }
	        Cell R18cell3 = row17.getCell(6);
	        if (R18cell3 != null) {
	            R18cell3.setCellValue(BRF152.getR18_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR18_residual_onetothree_year().intValue());
	        }
	        Cell R18cell4 = row17.getCell(7);
	        if (R18cell4 != null) {
	            R18cell4.setCellValue(BRF152.getR18_residual_threeyear() == null ? 0 :
	            	BRF152.getR18_residual_threeyear().intValue());
	        }
	        Cell R18cell5 = row17.getCell(8);
	        if (R18cell5 != null) {
	            R18cell5.setCellValue(BRF152.getR18_tenper_oneyear() == null ? 0 :
	            	BRF152.getR18_tenper_oneyear().intValue());
	        }
	        Cell R18cell6 = row17.getCell(9);
	        if (R18cell6 != null) {
	            R18cell6.setCellValue(BRF152.getR18_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR18_minustenper_oneyear().intValue());
	        }	
	        Cell R18cell7 = row17.getCell(10);
	        if (R18cell7 != null) {
	            R18cell7.setCellValue(BRF152.getR18_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR18_tenper_onetothree_year().intValue());
	        }
	        Cell R18cell8 = row17.getCell(11);
	        if (R18cell8 != null) {
	            R18cell8.setCellValue(BRF152.getR18_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR18_minustenper_onetothree_year().intValue());
	        }
	        Cell R18cell9 = row17.getCell(12);
	        if (R18cell9 != null) {
	            R18cell9.setCellValue(BRF152.getR18_tenper_threeyear() == null ? 0 :
	            	BRF152.getR18_tenper_threeyear().intValue());
	        }
	        Cell R18cell10 = row17.getCell(13);
	        if (R18cell10 != null) {
	        	R18cell10.setCellValue(BRF152.getR18_zero_threeyear() == null ? 0 :
	            	BRF152.getR18_zero_threeyear().intValue());
	        }
	        
	  //////srl_no -73///////
	        Row row18 = sheet.getRow(73);
	        
	        Cell R19cell = row18.getCell(3);
	        if (R19cell != null) {
	            R19cell.setCellValue(BRF152.getR19_national_amount() == null ? 0 :
	            	BRF152.getR19_national_amount().intValue());
	        }
	        Cell R19cell1 = row18.getCell(4);
	        if (R19cell1 != null) {
	            R19cell1.setCellValue(BRF152.getR19_gross_value() == null ? 0 :
	            	BRF152.getR19_gross_value().intValue());
	        }
	        Cell R19cell2 = row18.getCell(5);
	        if (R19cell2 != null) {
	            R19cell2.setCellValue(BRF152.getR19_residual_oneyear() == null ? 0 :
	            	BRF152.getR19_residual_oneyear().intValue());
	        }
	        Cell R19cell3 = row18.getCell(6);
	        if (R19cell3 != null) {
	            R19cell3.setCellValue(BRF152.getR19_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR19_residual_onetothree_year().intValue());
	        }
	        Cell R19cell4 = row18.getCell(7);
	        if (R19cell4 != null) {
	            R19cell4.setCellValue(BRF152.getR19_residual_threeyear() == null ? 0 :
	            	BRF152.getR19_residual_threeyear().intValue());
	        }
	      	
	        
	        
	  //////srl_no -78///////
	        Row row19 = sheet.getRow(78);
	        
	       
	        Cell R20cell1 = row19.getCell(4);
	        if (R20cell1 != null) {
	            R20cell1.setCellValue(BRF152.getR20_gross_value() == null ? 0 :
	            	BRF152.getR20_gross_value().intValue());
	        }
	        Cell R20cell2 = row19.getCell(5);
	        if (R20cell2 != null) {
	            R20cell2.setCellValue(BRF152.getR20_residual_oneyear() == null ? 0 :
	            	BRF152.getR20_residual_oneyear().intValue());
	        }
	        Cell R20cell3 = row19.getCell(6);
	        if (R20cell3 != null) {
	            R20cell3.setCellValue(BRF152.getR20_residual_onetothree_year() == null ? 0 :
	            	BRF152.getR20_residual_onetothree_year().intValue());
	        }
	        Cell R20cell4 = row19.getCell(7);
	        if (R20cell4 != null) {
	            R20cell4.setCellValue(BRF152.getR20_residual_threeyear() == null ? 0 :
	            	BRF152.getR20_residual_threeyear().intValue());
	        }
	       
	        
	  //////srl_no -79///////
	        Row row20 = sheet.getRow(79);
	        
	        
	        
	        Cell R21cell5 = row20.getCell(8);
	        if (R21cell5 != null) {
	            R21cell5.setCellValue(BRF152.getR21_tenper_oneyear() == null ? 0 :
	            	BRF152.getR21_tenper_oneyear().intValue());
	        }
	        Cell R21cell6 = row20.getCell(9);
	        if (R21cell6 != null) {
	            R21cell6.setCellValue(BRF152.getR21_minustenper_oneyear() == null ? 0 :
	            	BRF152.getR21_minustenper_oneyear().intValue());
	        }	
	        Cell R21cell7 = row20.getCell(10);
	        if (R21cell7 != null) {
	            R21cell7.setCellValue(BRF152.getR21_tenper_onetothree_year() == null ? 0 :
	            	BRF152.getR21_tenper_onetothree_year().intValue());
	        }
	        Cell R21cell8 = row20.getCell(11);
	        if (R21cell8 != null) {
	            R21cell8.setCellValue(BRF152.getR21_minustenper_onetothree_year() == null ? 0 :
	            	BRF152.getR21_minustenper_onetothree_year().intValue());
	        }
	        Cell R21cell9 = row20.getCell(12);
	        if (R21cell9 != null) {
	            R21cell9.setCellValue(BRF152.getR21_tenper_threeyear() == null ? 0 :
	            	BRF152.getR21_tenper_threeyear().intValue());
	        }
	        Cell R21cell10 = row20.getCell(13);
	        if (R21cell10 != null) {
	        	R21cell10.setCellValue(BRF152.getR21_zero_threeyear() == null ? 0 :
	            	BRF152.getR21_zero_threeyear().intValue());
	        }
	        
	  //////srl_no -80///////
	        Row row21 = sheet.getRow(80);
	       
	        Cell R22cell1 = row21.getCell(4);
	        if (R22cell1 != null) {
	            R22cell1.setCellValue(BRF152.getR22_gross_value() == null ? 0 :
	            	BRF152.getR22_gross_value().intValue());
	        }
	        
	        
	        // Save the changes
	        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	        FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-152-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-152-A.xls");

	return outputFile;



	}
	        	
				
	public String detailChanges152(BRF152_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, BigDecimal amt_ac,String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF152_DETAIL_ENTITY> Brf152detail =brf152_detailrepo.findById(foracid);

			if (Brf152detail.isPresent()) {
				BRF152_DETAIL_ENTITY BRFdetail = Brf152detail.get();

				if (BRFdetail.getReport_label_1().equals(report_label_1)
						&& BRFdetail.getReport_name_1().equals(report_name_1)
						&& BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc)
						&& BRFdetail.getAmt_ac().equals(amt_ac)
						&& BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)

				) {
					msg = "No modification done";
				} else {

					BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
					BRFdetail.setAmt_ac(amt_ac);
					BRFdetail.setReport_label_1(report_label_1);
					BRFdetail.setReport_name_1(report_name_1);
					BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
					brf152_detailrepo.save(BRFdetail);

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
	public ModelAndView getArchieveBRF0152View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF152_Entity> T1rep = new ArrayList<BRF152_Entity>();
		// Query<Object[]> qr;

		List<BRF152_Entity> T1Master = new ArrayList<BRF152_Entity>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF152_Entity a where a.report_date = ?1 ", BRF152_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF152ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	/**** ARCH DETAILS 
	 * @throws ParseException ****/

	public ModelAndView ARCHgetBRF0152currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF152_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF152_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF152_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF152_ARCHIVENTITY> T1Master = new ArrayList<BRF152_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF152_ARCHIVENTITY a where a.report_date = ?1", BRF152_ARCHIVENTITY.class)
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
			BigDecimal amt_ac = (BigDecimal) a[5];
			String acct_crncy_code = (String) a[6];
			String gl_code = (String) a[7];
			String gl_sub_head_code = (String) a[8];
			String gl_sub_head_desc = (String) a[9];
			String country_of_incorp = (String) a[10];
			String cust_type = (String) a[11];
			String schm_code = (String) a[12];
			String schm_type = (String) a[13];
			String sol_id = (String) a[14];
			String acid = (String) a[15];
			String segment = (String) a[16];
			String sub_segment = (String) a[17];
			BigDecimal sector = (BigDecimal) a[18];
			String sub_sector = (String) a[19];
			String sector_code = (String) a[20];
			String group_id = (String) a[21];
			String constitution_code = (String) a[22];
			String country = (String) a[23];
			String legal_entity_type = (String) a[24];
			String constitution_desc = (String) a[25];
			String purpose_of_advn = (String) a[26];
			BigDecimal hni_networth = (BigDecimal) a[27];
			String turnover = (String) a[28];
			String bacid = (String) a[29];
			String report_name_1 = (String) a[30];
			String report_label_1 = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			String create_user = (String) a[35];
			Date create_time = (Date) a[36];
			String modify_user = (String) a[37];
			Date modify_time = (Date) a[38];
			String verify_user = (String) a[39];
			Date verify_time = (Date) a[40];
			String entity_flg = (String) a[41];
			String modify_flg = (String) a[42];
			String del_flg = (String) a[43];
			String nre_status = (String) a[44];
			Date report_date = (Date) a[45];
			String maturity_date = (String) a[46];
			String gender = (String) a[47];
			String version = (String) a[48];
			String remarks = (String) a[49];
			

			BRF152_ARCHIVENTITY py = new BRF152_ARCHIVENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,amt_ac, 
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type, schm_code, 
					schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id, constitution_code, 
					country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, bacid, report_name_1,
					report_label_1, report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, 
					create_time, modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, 
					nre_status, report_date, maturity_date, version, gender, remarks);


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

	
		mv.setViewName("RR" + "/" + "BRF152ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	}