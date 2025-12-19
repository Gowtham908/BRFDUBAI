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

import com.bornfire.xbrl.entities.BRF65_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF65ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF65_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF65_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF65_Entity;
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
public class BRF65ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF65ReportService.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF65ServiceRepo brf65ServiceRepo;
	
	@Autowired
	BRF65_DetailRepo brf65DetailRep;
	
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF65_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF65_Entity a").getSingleResult();
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
	public ModelAndView getBRF065View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF65_Entity> T1rep = new ArrayList<BRF65_Entity>();
		// Query<Object[]> qr;

		List<BRF65_Entity> T1Master = new ArrayList<BRF65_Entity>();

		logger.info("Inside archive" +currency);

		try {		
			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF65_Entity a where a.report_date = ?1 ", BRF65_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		mv.setViewName("RR/BRF65");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	public ModelAndView getBRF065currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF65A_DETAILTABLE");

				//qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF65A_DETAILTABLE");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF65A_DETAILTABLE  where report_date = ?1");
		}
		List<BRF65_DETAIL_ENTITY> T1Master = new ArrayList<BRF65_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF65_DETAIL_ENTITY a where a.report_date = ?1", BRF65_DETAIL_ENTITY.class)
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
			String acct_crncy_code = (String) a[3];
			String gl_code = (String) a[4];
			String gl_sub_head_code = (String) a[5];
			String schm_code = (String) a[6];
			String schm_type = (String) a[7];
			String sol_id = (String) a[8];
			String acid = (String) a[9];
			String bacid = (String) a[10];
			String report_name_1 = (String) a[11];
			String report_label_1 = (String) a[12];
			String report_addl_criteria_1 = (String) a[13];
			String report_addl_criteria_2 = (String) a[14];
			String report_addl_criteria_3 = (String) a[15];
			String create_user = (String) a[16];
			Date create_time = (Date) a[17];
			String modify_user = (String) a[18];
			Date modify_time = (Date) a[19];
			String verify_user = (String) a[20];
			Date verify_time = (Date) a[21];
			String entity_flg = (String) a[22];
			String modify_flg = (String) a[23];
			String del_flg = (String) a[24];
			Date report_date = (Date) a[25];
			String version = (String) a[26];
			String remarks = (String) a[27];
			String legal_entity_type = (String) a[28];
			String constitution_desc = (String) a[29];
			String segment = (String) a[30];
			String sub_segment = (String) a[31];
			BigDecimal sector = (BigDecimal) a[32];
			String sub_sector = (String) a[33];
			String group_id = (String) a[34];
			String purpose_of_advn = (String) a[35];
			String gl_sub_head_desc = (String) a[36];
			String sector_code = (String) a[37];
			BigDecimal hni_networth = (BigDecimal) a[38];
			String turnover = (String) a[39];
			String maturity_date = (String) a[40];
			String country_of_incorp = (String) a[41];
			String nre_status = (String) a[42];
			String constitution_code = (String) a[43];
			String cust_type = (String) a[44];
			String country = (String) a[45];
			String gender = (String) a[46];
			BigDecimal eab_lc = (BigDecimal) a[47];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[48];

			
			BRF65_DETAIL_ENTITY py = new BRF65_DETAIL_ENTITY(cust_id, foracid, acct_name, acct_crncy_code, gl_code,
					gl_sub_head_code, schm_code, schm_type, sol_id, acid, bacid, report_name_1, report_label_1,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
					modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, report_date,
					version, remarks, legal_entity_type, constitution_desc, segment, sub_segment, sector, sub_sector,
					group_id, purpose_of_advn, gl_sub_head_desc, sector_code, hni_networth, turnover, maturity_date,
					country_of_incorp, nre_status, constitution_code, cust_type, country, gender, eab_lc,
					act_balance_amt_lc);

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

		mv.setViewName("RR" + "/" + "BRF65::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF065(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path =  this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-065-A";
		
		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {
		

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF65Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF65Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF65.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF65.jrxml");
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
		}
		else {
			
			List<BRF65_Entity> T1Master = new ArrayList<BRF65_Entity>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);
			
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF65_Entity a where a.report_date = ?1 ", BRF65_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			if(T1Master.size() == 1) {
				
				for(BRF65_Entity BRF65 : T1Master ) {
			
			File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-065-AT.xls");
			
			  // Load the Excel file
	    	Workbook workbook = WorkbookFactory.create(Responsecamt);

	        // Get the first sheet
	    	Sheet sheet = workbook.getSheetAt(0);
	    	
	    	//srl_no -10(Federal Govt & their non-commercial entities)
	    	
	        Row row = sheet.getRow(9);
	        Cell cell = row.getCell(3);
	        if (cell != null) {
	            cell.setCellValue(BRF65.getS2_rescheduled_once() == null ? 0 :
	            	BRF65.getS2_rescheduled_once().intValue());
	        }
	        Cell cell1 = row.getCell(4);
	        if (cell1 != null) {
	            cell1.setCellValue(BRF65.getS2_rescheduled_twice() == null ? 0 :
	            	BRF65.getS2_rescheduled_twice().intValue());
	        }
	        Cell cell2 = row.getCell(5);
	        if (cell2 != null) {
	            cell2.setCellValue(BRF65.getS2_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getS2_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell3 = row.getCell(7);
	        if (cell3 != null) {
	            cell3.setCellValue(BRF65.getS2_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getS2_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell4 = row.getCell(8);
	        if (cell4 != null) {
	            cell4.setCellValue(BRF65.getS2_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getS2_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell5 = row.getCell(9);
	        if (cell5 != null) {
	            cell5.setCellValue(BRF65.getS2_bullet_repayment() == null ? 0 :
	            	BRF65.getS2_bullet_repayment().intValue());
	        }
	        Cell cell6 = row.getCell(11);
	        if (cell6 != null) {
	            cell6.setCellValue(BRF65.getS2_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getS2_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell7 = row.getCell(12);
	        if (cell7 != null) {
	            cell7.setCellValue(BRF65.getS2_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getS2_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell8 = row.getCell(13);
	        if (cell8 != null) {
	            cell8.setCellValue(BRF65.getS2_specific_provisions() == null ? 0 :
	            	BRF65.getS2_specific_provisions().intValue());
	        }
	        //srl_no -11(Local Governments & their non-commercial entities)
	    	
	        Row row1 = sheet.getRow(10);
	        Cell cell10 = row1.getCell(3);
	        if (cell10 != null) {
	            cell10.setCellValue(BRF65.getS3_rescheduled_once() == null ? 0 :
	            	BRF65.getS3_rescheduled_once().intValue());
	        }
	        Cell cell11 = row1.getCell(4);
	        if (cell11 != null) {
	            cell11.setCellValue(BRF65.getS3_rescheduled_twice() == null ? 0 :
	            	BRF65.getS3_rescheduled_twice().intValue());
	        }
	        Cell cell12 = row1.getCell(5);
	        if (cell12 != null) {
	            cell12.setCellValue(BRF65.getS3_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getS3_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell13 = row1.getCell(7);
	        if (cell13 != null) {
	            cell13.setCellValue(BRF65.getS3_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getS3_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell14 = row1.getCell(8);
	        if (cell14 != null) {
	            cell14.setCellValue(BRF65.getS3_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getS3_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell15 = row1.getCell(9);
	        if (cell15 != null) {
	            cell15.setCellValue(BRF65.getS3_bullet_repayment() == null ? 0 :
	            	BRF65.getS3_bullet_repayment().intValue());
	        }
	        Cell cell16 = row1.getCell(11);
	        if (cell16 != null) {
	            cell16.setCellValue(BRF65.getS3_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getS3_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell17 = row1.getCell(12);
	        if (cell17 != null) {
	            cell17.setCellValue(BRF65.getS3_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getS3_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell18 = row1.getCell(13);
	        if (cell18 != null) {
	            cell18.setCellValue(BRF65.getS3_specific_provisions() == null ? 0 :
	            	BRF65.getS3_specific_provisions().intValue());
	        }
	        //srl_no -12(GREs with Govt ownership more than 50%)
	    	
	        Row row2 = sheet.getRow(11);
	        Cell cell20 = row2.getCell(3);
	        if (cell20 != null) {
	            cell20.setCellValue(BRF65.getS4_rescheduled_once() == null ? 0 :
	            	BRF65.getS4_rescheduled_once().intValue());
	        }
	        Cell cell21 = row2.getCell(4);
	        if (cell21 != null) {
	            cell21.setCellValue(BRF65.getS4_rescheduled_twice() == null ? 0 :
	            	BRF65.getS4_rescheduled_twice().intValue());
	        }
	        Cell cell22 = row2.getCell(5);
	        if (cell22 != null) {
	            cell22.setCellValue(BRF65.getS4_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getS4_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell23 = row2.getCell(7);
	        if (cell23 != null) {
	            cell23.setCellValue(BRF65.getS4_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getS4_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell24 = row2.getCell(8);
	        if (cell24 != null) {
	            cell24.setCellValue(BRF65.getS4_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getS4_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell25 = row2.getCell(9);
	        if (cell25 != null) {
	            cell25.setCellValue(BRF65.getS4_bullet_repayment() == null ? 0 :
	            	BRF65.getS4_bullet_repayment().intValue());
	        }
	        Cell cell26 = row2.getCell(11);
	        if (cell26 != null) {
	            cell26.setCellValue(BRF65.getS4_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getS4_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell27 = row2.getCell(12);
	        if (cell27 != null) {
	            cell27.setCellValue(BRF65.getS4_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getS4_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell28 = row2.getCell(13);
	        if (cell28 != null) {
	            cell28.setCellValue(BRF65.getS4_specific_provisions() == null ? 0 :
	            	BRF65.getS4_specific_provisions().intValue());
	        }
			//srl_no -14(Corporates with Govt ownership of less than 50%)
	    	
	        Row row3 = sheet.getRow(13);
	        Cell cell30 = row3.getCell(3);
	        if (cell30 != null) {
	            cell30.setCellValue(BRF65.getT2_rescheduled_once() == null ? 0 :
	            	BRF65.getT2_rescheduled_once().intValue());
	        }
	        Cell cell31 = row3.getCell(4);
	        if (cell31 != null) {
	            cell31.setCellValue(BRF65.getT2_rescheduled_twice() == null ? 0 :
	            	BRF65.getT2_rescheduled_twice().intValue());
	        }
	        Cell cell32 = row3.getCell(5);
	        if (cell32 != null) {
	            cell32.setCellValue(BRF65.getT2_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getT2_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell33 = row3.getCell(7);
	        if (cell33 != null) {
	            cell33.setCellValue(BRF65.getT2_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getT2_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell34 = row3.getCell(8);
	        if (cell34 != null) {
	            cell34.setCellValue(BRF65.getT2_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getT2_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell35 = row3.getCell(9);
	        if (cell35 != null) {
	            cell35.setCellValue(BRF65.getT2_bullet_repayment() == null ? 0 :
	            	BRF65.getT2_bullet_repayment().intValue());
	        }
	        Cell cell36 = row3.getCell(11);
	        if (cell36 != null) {
	            cell36.setCellValue(BRF65.getT2_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getT2_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell37 = row3.getCell(12);
	        if (cell37 != null) {
	            cell37.setCellValue(BRF65.getT2_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getT2_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell38 = row3.getCell(13);
	        if (cell38 != null) {
	            cell38.setCellValue(BRF65.getT2_specific_provisions() == null ? 0 :
	            	BRF65.getT2_specific_provisions().intValue());
	        }
			//srl_no -15(Other corporates)
	    	
	        Row row4 = sheet.getRow(14);
	        Cell cell40 = row4.getCell(3);
	        if (cell40 != null) {
	            cell40.setCellValue(BRF65.getT3_rescheduled_once() == null ? 0 :
	            	BRF65.getT3_rescheduled_once().intValue());
	        }
	        Cell cell41 = row4.getCell(4);
	        if (cell41 != null) {
	            cell41.setCellValue(BRF65.getT3_rescheduled_twice() == null ? 0 :
	            	BRF65.getT3_rescheduled_twice().intValue());
	        }
	        Cell cell42 = row4.getCell(5);
	        if (cell42 != null) {
	            cell42.setCellValue(BRF65.getT3_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getT3_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell43 = row4.getCell(7);
	        if (cell43 != null) {
	            cell43.setCellValue(BRF65.getT3_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getT3_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell44 = row4.getCell(8);
	        if (cell44 != null) {
	            cell44.setCellValue(BRF65.getT3_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getT3_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell45 = row4.getCell(9);
	        if (cell45 != null) {
	            cell45.setCellValue(BRF65.getT3_bullet_repayment() == null ? 0 :
	            	BRF65.getT3_bullet_repayment().intValue());
	        }
	        Cell cell46 = row4.getCell(11);
	        if (cell46 != null) {
	            cell46.setCellValue(BRF65.getT3_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getT3_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell47 = row4.getCell(12);
	        if (cell47 != null) {
	            cell47.setCellValue(BRF65.getT3_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getT3_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell48 = row4.getCell(13);
	        if (cell48 != null) {
	            cell48.setCellValue(BRF65.getT3_specific_provisions() == null ? 0 :
	            	BRF65.getT3_specific_provisions().intValue());
	        }
			//srl_no -16(High Net worth Individuals (HNI))
	    	
	        Row row5 = sheet.getRow(15);
	        Cell cell50 = row5.getCell(3);
	        if (cell50 != null) {
	            cell50.setCellValue(BRF65.getT4_rescheduled_once() == null ? 0 :
	            	BRF65.getT4_rescheduled_once().intValue());
	        }
	        Cell cell51 = row5.getCell(4);
	        if (cell51 != null) {
	            cell51.setCellValue(BRF65.getT4_rescheduled_twice() == null ? 0 :
	            	BRF65.getT4_rescheduled_twice().intValue());
	        }
	        Cell cell52 = row5.getCell(5);
	        if (cell52 != null) {
	            cell52.setCellValue(BRF65.getT4_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getT4_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell53 = row5.getCell(7);
	        if (cell53 != null) {
	            cell53.setCellValue(BRF65.getT4_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getT4_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell54 = row5.getCell(8);
	        if (cell54 != null) {
	            cell54.setCellValue(BRF65.getT4_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getT4_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell55 = row5.getCell(9);
	        if (cell55 != null) {
	            cell55.setCellValue(BRF65.getT4_bullet_repayment() == null ? 0 :
	            	BRF65.getT4_bullet_repayment().intValue());
	        }
	        Cell cell56 = row5.getCell(11);
	        if (cell56 != null) {
	            cell56.setCellValue(BRF65.getT4_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getT4_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell57 = row5.getCell(12);
	        if (cell57 != null) {
	            cell57.setCellValue(BRF65.getT4_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getT4_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell58 = row5.getCell(13);
	        if (cell58 != null) {
	            cell58.setCellValue(BRF65.getT4_specific_provisions() == null ? 0 :
	            	BRF65.getT4_specific_provisions().intValue());
	        }
			//srl_no -17(Small & Medium Enterprises (SMEs))
	    	
	        Row row6 = sheet.getRow(16);
	        Cell cell60 = row6.getCell(3);
	        if (cell60 != null) {
	            cell60.setCellValue(BRF65.getT5_rescheduled_once() == null ? 0 :
	            	BRF65.getT5_rescheduled_once().intValue());
	        }
	        Cell cell61 = row6.getCell(4);
	        if (cell61 != null) {
	            cell61.setCellValue(BRF65.getT5_rescheduled_twice() == null ? 0 :
	            	BRF65.getT5_rescheduled_twice().intValue());
	        }
	        Cell cell62 = row6.getCell(5);
	        if (cell62 != null) {
	            cell62.setCellValue(BRF65.getT5_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getT5_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell63 = row6.getCell(7);
	        if (cell63 != null) {
	            cell63.setCellValue(BRF65.getT5_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getT5_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell64 = row6.getCell(8);
	        if (cell64 != null) {
	            cell64.setCellValue(BRF65.getT5_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getT5_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell65 = row6.getCell(9);
	        if (cell65 != null) {
	            cell65.setCellValue(BRF65.getT5_bullet_repayment() == null ? 0 :
	            	BRF65.getT5_bullet_repayment().intValue());
	        }
	        Cell cell66 = row6.getCell(11);
	        if (cell66 != null) {
	            cell66.setCellValue(BRF65.getT5_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getT5_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell67 = row6.getCell(12);
	        if (cell67 != null) {
	            cell67.setCellValue(BRF65.getT5_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getT5_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell68 = row6.getCell(13);
	        if (cell68 != null) {
	            cell68.setCellValue(BRF65.getT5_specific_provisions() == null ? 0 :
	            	BRF65.getT5_specific_provisions().intValue());
	        }
			//srl_no -19(Car loans)
	    	
	        Row row7 = sheet.getRow(18);
	        Cell cell70 = row7.getCell(3);
	        if (cell70 != null) {
	            cell70.setCellValue(BRF65.getV2_rescheduled_once() == null ? 0 :
	            	BRF65.getV2_rescheduled_once().intValue());
	        }
	        Cell cell71 = row7.getCell(4);
	        if (cell71 != null) {
	            cell71.setCellValue(BRF65.getV2_rescheduled_twice() == null ? 0 :
	            	BRF65.getV2_rescheduled_twice().intValue());
	        }
	        Cell cell72 = row7.getCell(5);
	        if (cell72 != null) {
	            cell72.setCellValue(BRF65.getV2_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getV2_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell73 = row7.getCell(7);
	        if (cell73 != null) {
	            cell73.setCellValue(BRF65.getV2_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getV2_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell74 = row7.getCell(8);
	        if (cell74 != null) {
	            cell74.setCellValue(BRF65.getV2_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getV2_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell75 = row7.getCell(9);
	        if (cell75 != null) {
	            cell75.setCellValue(BRF65.getV2_bullet_repayment() == null ? 0 :
	            	BRF65.getV2_bullet_repayment().intValue());
	        }
	        Cell cell76 = row7.getCell(11);
	        if (cell76 != null) {
	            cell76.setCellValue(BRF65.getV2_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getV2_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell77 = row7.getCell(12);
	        if (cell77 != null) {
	            cell77.setCellValue(BRF65.getV2_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getV2_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell78 = row7.getCell(13);
	        if (cell78 != null) {
	            cell78.setCellValue(BRF65.getV2_specific_provisions() == null ? 0 :
	            	BRF65.getV2_specific_provisions().intValue());
	        }
			//srl_no -20(Overdrafts)
	    	
	        Row row8 = sheet.getRow(19);
	        Cell cell80 = row8.getCell(3);
	        if (cell80 != null) {
	            cell80.setCellValue(BRF65.getV3_rescheduled_once() == null ? 0 :
	            	BRF65.getV3_rescheduled_once().intValue());
	        }
	        Cell cell81 = row8.getCell(4);
	        if (cell81 != null) {
	            cell81.setCellValue(BRF65.getV3_rescheduled_twice() == null ? 0 :
	            	BRF65.getV3_rescheduled_twice().intValue());
	        }
	        Cell cell82 = row8.getCell(5);
	        if (cell82 != null) {
	            cell82.setCellValue(BRF65.getV3_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getV3_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell83 = row8.getCell(7);
	        if (cell83 != null) {
	            cell83.setCellValue(BRF65.getV3_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getV3_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell84 = row8.getCell(8);
	        if (cell84 != null) {
	            cell84.setCellValue(BRF65.getV3_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getV3_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell85 = row8.getCell(9);
	        if (cell85 != null) {
	            cell85.setCellValue(BRF65.getV3_bullet_repayment() == null ? 0 :
	            	BRF65.getV3_bullet_repayment().intValue());
	        }
	        Cell cell86 = row8.getCell(11);
	        if (cell86 != null) {
	            cell86.setCellValue(BRF65.getV3_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getV3_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell87 = row8.getCell(12);
	        if (cell87 != null) {
	            cell87.setCellValue(BRF65.getV3_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getV3_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell88 = row8.getCell(13);
	        if (cell88 != null) {
	            cell88.setCellValue(BRF65.getV3_specific_provisions() == null ? 0 :
	            	BRF65.getV3_specific_provisions().intValue());
	        }
			//srl_no -21(Real Estate/ housing loans)
	    	
	        Row row9 = sheet.getRow(20);
	        Cell cell90 = row9.getCell(3);
	        if (cell90 != null) {
	            cell90.setCellValue(BRF65.getV4_rescheduled_once() == null ? 0 :
	            	BRF65.getV4_rescheduled_once().intValue());
	        }
	        Cell cell91 = row9.getCell(4);
	        if (cell91 != null) {
	            cell91.setCellValue(BRF65.getV4_rescheduled_twice() == null ? 0 :
	            	BRF65.getV4_rescheduled_twice().intValue());
	        }
	        Cell cell92 = row9.getCell(5);
	        if (cell92 != null) {
	            cell92.setCellValue(BRF65.getV4_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getV4_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell93 = row9.getCell(7);
	        if (cell93 != null) {
	            cell93.setCellValue(BRF65.getV4_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getV4_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell94 = row9.getCell(8);
	        if (cell94 != null) {
	            cell94.setCellValue(BRF65.getV4_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getV4_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell95 = row9.getCell(9);
	        if (cell95 != null) {
	            cell95.setCellValue(BRF65.getV4_bullet_repayment() == null ? 0 :
	            	BRF65.getV4_bullet_repayment().intValue());
	        }
	        Cell cell96 = row9.getCell(11);
	        if (cell96 != null) {
	            cell96.setCellValue(BRF65.getV4_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getV4_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell97 = row9.getCell(12);
	        if (cell97 != null) {
	            cell97.setCellValue(BRF65.getV4_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getV4_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell98 = row9.getCell(13);
	        if (cell98 != null) {
	            cell98.setCellValue(BRF65.getV4_specific_provisions() == null ? 0 :
	            	BRF65.getV4_specific_provisions().intValue());
	        }
			//srl_no -22(Loans against shares to individuals)
	    	
	        Row row10 = sheet.getRow(21);
	        Cell cell100 = row10.getCell(3);
	        if (cell100 != null) {
	            cell100.setCellValue(BRF65.getV5_rescheduled_once() == null ? 0 :
	            	BRF65.getV5_rescheduled_once().intValue());
	        }
	        Cell cell101 = row10.getCell(4);
	        if (cell101 != null) {
	            cell101.setCellValue(BRF65.getV5_rescheduled_twice() == null ? 0 :
	            	BRF65.getV5_rescheduled_twice().intValue());
	        }
	        Cell cell102 = row10.getCell(5);
	        if (cell102 != null) {
	            cell102.setCellValue(BRF65.getV5_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getV5_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell103 = row10.getCell(7);
	        if (cell103 != null) {
	            cell103.setCellValue(BRF65.getV5_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getV5_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell104 = row10.getCell(8);
	        if (cell104 != null) {
	            cell104.setCellValue(BRF65.getV5_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getV5_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell105 = row10.getCell(9);
	        if (cell105 != null) {
	            cell105.setCellValue(BRF65.getV5_bullet_repayment() == null ? 0 :
	            	BRF65.getV5_bullet_repayment().intValue());
	        }
	        Cell cell106 = row10.getCell(11);
	        if (cell106 != null) {
	            cell106.setCellValue(BRF65.getV5_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getV5_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell107 = row10.getCell(12);
	        if (cell107 != null) {
	            cell107.setCellValue(BRF65.getV5_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getV5_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell108 = row10.getCell(13);
	        if (cell108 != null) {
	            cell108.setCellValue(BRF65.getV5_specific_provisions() == null ? 0 :
	            	BRF65.getV5_specific_provisions().intValue());
	        }
			//srl_no -23(Other loans to individuals)
	    	
	        Row row11 = sheet.getRow(22);
	        Cell cell110 = row11.getCell(3);
	        if (cell110 != null) {
	            cell110.setCellValue(BRF65.getV6_rescheduled_once() == null ? 0 :
	            	BRF65.getV6_rescheduled_once().intValue());
	        }
	        Cell cell111 = row11.getCell(4);
	        if (cell111 != null) {
	            cell111.setCellValue(BRF65.getV6_rescheduled_twice() == null ? 0 :
	            	BRF65.getV6_rescheduled_twice().intValue());
	        }
	        Cell cell112 = row11.getCell(5);
	        if (cell112 != null) {
	            cell112.setCellValue(BRF65.getV6_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getV6_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell113 = row11.getCell(7);
	        if (cell113 != null) {
	            cell113.setCellValue(BRF65.getV6_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getV6_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell114 = row11.getCell(8);
	        if (cell114 != null) {
	            cell114.setCellValue(BRF65.getV6_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getV6_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell115 = row11.getCell(9);
	        if (cell115 != null) {
	            cell115.setCellValue(BRF65.getV6_bullet_repayment() == null ? 0 :
	            	BRF65.getV6_bullet_repayment().intValue());
	        }
	        Cell cell116 = row11.getCell(11);
	        if (cell116 != null) {
	            cell116.setCellValue(BRF65.getV6_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getV6_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell117 = row11.getCell(12);
	        if (cell117 != null) {
	            cell117.setCellValue(BRF65.getV6_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getV6_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell118 = row11.getCell(13);
	        if (cell118 != null) {
	            cell118.setCellValue(BRF65.getV6_specific_provisions() == null ? 0 :
	            	BRF65.getV6_specific_provisions().intValue());
	        }
			//srl_no -24(Small business loans (up to AED 2 Million))
	    	
	        Row row12 = sheet.getRow(23);
	        Cell cell120 = row12.getCell(3);
	        if (cell120 != null) {
	            cell120.setCellValue(BRF65.getV7_rescheduled_once() == null ? 0 :
	            	BRF65.getV7_rescheduled_once().intValue());
	        }
	        Cell cell121 = row12.getCell(4);
	        if (cell121 != null) {
	            cell121.setCellValue(BRF65.getV7_rescheduled_twice() == null ? 0 :
	            	BRF65.getV7_rescheduled_twice().intValue());
	        }
	        Cell cell122 = row12.getCell(5);
	        if (cell122 != null) {
	            cell122.setCellValue(BRF65.getV7_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getV7_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell123 = row12.getCell(7);
	        if (cell123 != null) {
	            cell123.setCellValue(BRF65.getV7_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getV7_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell124 = row12.getCell(8);
	        if (cell124 != null) {
	            cell124.setCellValue(BRF65.getV7_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getV7_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell125 = row12.getCell(9);
	        if (cell125 != null) {
	            cell125.setCellValue(BRF65.getV7_bullet_repayment() == null ? 0 :
	            	BRF65.getV7_bullet_repayment().intValue());
	        }
	        Cell cell126 = row12.getCell(11);
	        if (cell126 != null) {
	            cell126.setCellValue(BRF65.getV7_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getV7_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell127 = row12.getCell(12);
	        if (cell127 != null) {
	            cell127.setCellValue(BRF65.getV7_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getV7_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell128 = row12.getCell(13);
	        if (cell128 != null) {
	            cell128.setCellValue(BRF65.getV7_specific_provisions() == null ? 0 :
	            	BRF65.getV7_specific_provisions().intValue());
	        }
			//srl_no -24(Small business loans (Non - Residents Loans)
	    	
	        Row row13 = sheet.getRow(24);
	        Cell cell130 = row13.getCell(3);
	        if (cell130 != null) {
	            cell130.setCellValue(BRF65.getW1_rescheduled_once() == null ? 0 :
	            	BRF65.getW1_rescheduled_once().intValue());
	        }
	        Cell cell131 = row13.getCell(4);
	        if (cell131 != null) {
	            cell131.setCellValue(BRF65.getW1_rescheduled_twice() == null ? 0 :
	            	BRF65.getW1_rescheduled_twice().intValue());
	        }
	        Cell cell132 = row13.getCell(5);
	        if (cell132 != null) {
	            cell132.setCellValue(BRF65.getW1_rescheduled_more_than_twice() == null ? 0 :
	            	BRF65.getW1_rescheduled_more_than_twice().intValue());
	        }
	        Cell cell133 = row13.getCell(7);
	        if (cell133 != null) {
	            cell133.setCellValue(BRF65.getW1_principal_regularly_amortized_period() == null ? 0 :
	            	BRF65.getW1_principal_regularly_amortized_period().intValue());
	        }
	        Cell cell134 = row13.getCell(8);
	        if (cell134 != null) {
	            cell134.setCellValue(BRF65.getW1_repayment_after_grace_period_exceed_oneyr() == null ? 0 :
	            	BRF65.getW1_repayment_after_grace_period_exceed_oneyr().intValue());
	        }
	        Cell cell135 = row13.getCell(9);
	        if (cell135 != null) {
	            cell135.setCellValue(BRF65.getW1_bullet_repayment() == null ? 0 :
	            	BRF65.getW1_bullet_repayment().intValue());
	        }
	        Cell cell136 = row13.getCell(11);
	        if (cell136 != null) {
	            cell136.setCellValue(BRF65.getW1_interest_profit_overdue_pl() == null ? 0 :
	            	BRF65.getW1_interest_profit_overdue_pl().intValue());
	        }
	        Cell cell137 = row13.getCell(12);
	        if (cell137 != null) {
	            cell137.setCellValue(BRF65.getW1_interest_profit_overdue_intsus() == null ? 0 :
	            	BRF65.getW1_interest_profit_overdue_intsus().intValue());
	        }
	        Cell cell138 = row13.getCell(13);
	        if (cell138 != null) {
	            cell138.setCellValue(BRF65.getW1_specific_provisions() == null ? 0 :
	            	BRF65.getW1_specific_provisions().intValue());
	        }
	     // Save the changes
	        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	        FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-065-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-065-A.xls");

	return outputFile;



	}
	        
	

	public String detailChanges65(BRF65_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
	        BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	    String msg = "";

	    try {
	        // Get the current Hibernate session
	        Session hs = sessionFactory.getCurrentSession();

	        // Find the BRF65_DETAIL_ENTITY object by its foracid
	        Optional<BRF65_DETAIL_ENTITY> brf65DetailOptional = brf65DetailRep.findById(foracid);

	        if (brf65DetailOptional.isPresent()) {
	            BRF65_DETAIL_ENTITY brfDetail = brf65DetailOptional.get();
	            if (brfDetail != null && report_label_1 != null && report_name_1 != null && report_addl_criteria_1 != null) {
	            	if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc()) &&
	                        report_label_1.equals(brfDetail.getReport_label_1()) &&
	                        report_name_1.equals(brfDetail.getReport_name_1()) &&
	                        report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
	                    msg = "No modification done";
	                } else {
	                    // Update the BRF65_DETAIL_ENTITY object with the provided parameters
	                    brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
	                    brfDetail.setReport_label_1(report_label_1);
	                    brfDetail.setReport_name_1(report_name_1);
	                    brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

	                    // Save the updated object
	                    brf65DetailRep.save(brfDetail);

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
	public ModelAndView getArchieveBRF065View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF65_Entity> T1rep = new ArrayList<BRF65_Entity>();
		// Query<Object[]> qr;

		List<BRF65_Entity> T1Master = new ArrayList<BRF65_Entity>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);	

			T1Master = hs.createQuery("from BRF65_Entity a where a.report_date = ?1 ", BRF65_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		mv.setViewName("RR/BRF65ARCH");
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

	public ModelAndView ARCHgetBRF065currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF65_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF65_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF65_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF65_ARCHIVENTITY> T1Master = new ArrayList<BRF65_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF65_ARCHIVENTITY a where a.report_date = ?1", BRF65_ARCHIVENTITY.class)
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
			String acct_crncy_code = (String) a[3];
			String gl_code = (String) a[4];
			String gl_sub_head_code = (String) a[5];
			String schm_code = (String) a[6];
			String schm_type = (String) a[7];
			String sol_id = (String) a[8];
			String acid = (String) a[9];
			String bacid = (String) a[10];
			String report_name_1 = (String) a[11];
			String report_label_1 = (String) a[12];
			String report_addl_criteria_1 = (String) a[13];
			String report_addl_criteria_2 = (String) a[14];
			String report_addl_criteria_3 = (String) a[15];
			String create_user = (String) a[16];
			Date create_time = (Date) a[17];
			String modify_user = (String) a[18];
			Date modify_time = (Date) a[19];
			String verify_user = (String) a[20];
			Date verify_time = (Date) a[21];
			String entity_flg = (String) a[22];
			String modify_flg = (String) a[23];
			String del_flg = (String) a[24];
			Date report_date = (Date) a[25];
			String version = (String) a[26];
			String remarks = (String) a[27];
			String legal_entity_type = (String) a[28];
			String constitution_desc = (String) a[29];
			String segment = (String) a[30];
			String sub_segment = (String) a[31];
			BigDecimal sector = (BigDecimal) a[32];
			String sub_sector = (String) a[33];
			String group_id = (String) a[34];
			String purpose_of_advn = (String) a[35];
			String gl_sub_head_desc = (String) a[36];
			String sector_code = (String) a[37];
			BigDecimal hni_networth = (BigDecimal) a[38];
			String turnover = (String) a[39];
			String maturity_date = (String) a[40];
			String country_of_incorp = (String) a[41];
			String nre_status = (String) a[42];
			String constitution_code = (String) a[43];
			String cust_type = (String) a[44];
			String country = (String) a[45];
			String gender = (String) a[46];
			BigDecimal eab_lc = (BigDecimal) a[47];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[48];

			
			BRF65_ARCHIVENTITY py = new BRF65_ARCHIVENTITY(cust_id, foracid, acct_name, acct_crncy_code, gl_code,
					gl_sub_head_code, schm_code, schm_type, sol_id, acid, bacid, report_name_1, report_label_1,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
					modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, report_date,
					version, remarks, legal_entity_type, constitution_desc, segment, sub_segment, sector, sub_sector,
					group_id, purpose_of_advn, gl_sub_head_desc, sector_code, hni_networth, turnover, maturity_date,
					country_of_incorp, nre_status, constitution_code, cust_type, country, gender, eab_lc,
					act_balance_amt_lc);

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

		mv.setViewName("RR" + "/" + "BRF65ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	}


