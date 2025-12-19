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

import com.bornfire.xbrl.entities.BRBS.BRF2_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF74_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF74_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF74_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF74_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF85_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF85_ENTITY;
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
public class BRF74ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF74ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF74_DetailRepo brf74_detailrepo;

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
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF74_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF74_ENTITY a").getSingleResult();
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



	public ModelAndView getBRF74View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable	) {
				ModelAndView mv = new ModelAndView();
				Session hs = sessionFactory.getCurrentSession();
				int pageSize = pageable.getPageSize();
				int currentPage = pageable.getPageNumber();
				int startItem = currentPage * pageSize;
				List<BRF74_ENTITY> T1rep = new ArrayList<BRF74_ENTITY>();
				

				List<BRF74_ENTITY> T1Master = new ArrayList<BRF74_ENTITY>();
				

				logger.info("Inside archive" +currency);

				try {
					Date d1 = df.parse(todate);
				

					T1Master = hs.createQuery("from BRF74_ENTITY a where a.report_date = ?1 ", BRF74_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

				

				} catch (ParseException e) {
					e.printStackTrace();
				}

				mv.setViewName("RR/BRF74");
				mv.addObject("reportsummary", T1Master);
				mv.addObject("reportmaster", T1Master);
				mv.addObject("displaymode", "summary");
				mv.addObject("reportsflag", "reportsflag");
				mv.addObject("menu", reportId);
				System.out.println("scv" + mv.getViewName());

				return mv;

			}
	public ModelAndView getBRF74Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF74_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");
 
				qr.setParameter(2, filter);
 
			} else {
				qr = hs.createNativeQuery("select * from BRF74_DETAILTABLE a where report_date = ?1");
 
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF74_DETAILTABLE  where report_date = ?1");
		}
 
		try {
			qr.setParameter(1, df.parse(todate));
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF74_DETAIL_ENTITY> T1Master = new ArrayList<BRF74_DETAIL_ENTITY>();
 
		try {
			T1Master = hs.createQuery("from BRF74_DETAIL_ENTITY a where a.report_date = ?1", BRF74_DETAIL_ENTITY.class)
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
			Character del_flg = (Character) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String)a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nre_flag = (Character) a[49];
			
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

			BRF74_DETAIL_ENTITY py = new BRF74_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nre_flag);
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

		mv.setViewName("RR" + "/" + "BRF74::reportcontent");
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
		fileName = "011-BRF-074-A";
					if (!filetype.equals("xbrl")) {
						if(!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF74_DETAIL.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF74_DETAIL.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF074.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF074.jrxml");
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
			}else {	
		
		
		List<BRF74_ENTITY> T1Master = new ArrayList<BRF74_ENTITY>();
		Session hs = sessionFactory.getCurrentSession();
		try {
			Date d1 = df.parse(todate);
		
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF74_ENTITY a where a.report_date = ?1 ", BRF74_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();
		
		if(T1Master.size() == 1) {
			
			for(BRF74_ENTITY BRF074 : T1Master ) {
		
		File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-074-AT.xls");
		
		  // Load the Excel file
    	Workbook workbook = WorkbookFactory.create(Responsecamt);

        // Get the first sheet
    	Sheet sheet = workbook.getSheetAt(0);
    	
   
		Row row2 = sheet.getRow(10);
		 Cell R2cell1 = row2.getCell(3); 
			if (R2cell1 != null) {
				R2cell1.setCellValue(BRF074.getR2_acc_fund_national() == null ? 0 : BRF074.getR2_acc_fund_national().intValue());
			}
			Cell R2cell2 = row2.getCell(4); 
			if (R2cell2 != null) {
				R2cell2.setCellValue(BRF074.getR2_amt_fund_national() == null ? 0 : BRF074.getR2_amt_fund_national().intValue());
			}
			Cell R2cell3 = row2.getCell(5); 
			if (R2cell3 != null) {
				R2cell3.setCellValue(BRF074.getR2_avg_fund_national() == null ? 0 : BRF074.getR2_avg_fund_national().intValue());
			}
			Cell R2cell4 = row2.getCell(6); 
			if (R2cell4 != null) {
				R2cell4.setCellValue(BRF074.getR2_acc_unfund_national() == null ? 0 : BRF074.getR2_acc_unfund_national().intValue());
			}
			Cell R2cell5 = row2.getCell(7); 
			if (R2cell5 != null) {
				R2cell5.setCellValue(BRF074.getR2_amt_unfund_national() == null ? 0 : BRF074.getR2_amt_unfund_national().intValue());
			}
			Cell R2cell6 = row2.getCell(8); 
			if (R2cell6 != null) {
				R2cell6.setCellValue(BRF074.getR2_ccf_unfund_national() == null ? 0 : BRF074.getR2_ccf_unfund_national().intValue());
			}
			Cell R2cell7 = row2.getCell(9); 
			if (R2cell7 != null) {
				R2cell7.setCellValue(BRF074.getR2_stage3_acc_national() == null ? 0 : BRF074.getR2_stage3_acc_national().intValue());
			}
			Cell R2cell8 = row2.getCell(10); 
			if (R2cell8 != null) {
				R2cell8.setCellValue(BRF074.getR2_amt_stage3_national() == null ? 0 : BRF074.getR2_amt_stage3_national().intValue());
			}
			Cell R2cell9 = row2.getCell(11); 
			if (R2cell9 != null) {
				R2cell9.setCellValue(BRF074.getR2_acc_fund_non_national() == null ? 0 : BRF074.getR2_acc_fund_non_national().intValue());
			}
			Cell R2cell10 = row2.getCell(12); 
			if (R2cell10 != null) {
				R2cell10.setCellValue(BRF074.getR2_amt_fund_non_national() == null ? 0 : BRF074.getR2_amt_fund_non_national().intValue());
			}

			Cell R2cell11 = row2.getCell(13); 
			if (R2cell11 != null) {
				R2cell11.setCellValue(BRF074.getR2_avg_fund_non_national() == null ? 0 : BRF074.getR2_avg_fund_non_national().intValue());
			}
			Cell R2cell12 = row2.getCell(14); 
			if (R2cell12 != null) {
				R2cell12.setCellValue(BRF074.getR2_acc_unfund_non_national() == null ? 0 : BRF074.getR2_acc_unfund_non_national().intValue());
			}

			Cell R2cell13 = row2.getCell(15); 
			if (R2cell13 != null) {
				R2cell13.setCellValue(BRF074.getR2_amt_unfund_non_national() == null ? 0 : BRF074.getR2_amt_unfund_non_national().intValue());
			}
			Cell R2cell14 = row2.getCell(16); 
			if (R2cell14 != null) {
				R2cell14.setCellValue(BRF074.getR2_ccf_unfund_non_national() == null ? 0 : BRF074.getR2_ccf_unfund_non_national().intValue());
			}
			Cell R2cell15 = row2.getCell(17); 
			if (R2cell15 != null) {
				R2cell15.setCellValue(BRF074.getR2_stage3_acc_non_national() == null ? 0 : BRF074.getR2_stage3_acc_non_national().intValue());
			}
			Cell R2cell16 = row2.getCell(18); 
			if (R2cell16 != null) {
				R2cell16.setCellValue(BRF074.getR2_amt_stage3_non_national() == null ? 0 : BRF074.getR2_amt_stage3_non_national().intValue());
			}
			Cell  R2cell17 = row2.getCell(21); 
			if (R2cell17 != null) {
				R2cell17.setCellValue(BRF074.getR2_avg_total() == null ? 0 : BRF074.getR2_avg_total().intValue());
			}
			Cell  R2cell18 = row2.getCell(22); 
			if (R2cell18 != null) {
				R2cell18.setCellValue(BRF074.getR2_fund_ccf_total() == null ? 0 : BRF074.getR2_fund_ccf_total().intValue());
			}
			Cell  R2cell19 = row2.getCell(25); 
			if (R2cell19 != null) {
				R2cell19.setCellValue(BRF074.getR2_stage3_acc_quater() == null ? 0 : BRF074.getR2_stage3_acc_quater().intValue());
			}

			Cell  R2cell20 = row2.getCell(26); 
			if (R2cell20 != null) {
				R2cell20.setCellValue(BRF074.getR2_amt_stage3_acc_quater() == null ? 0 : BRF074.getR2_amt_stage3_acc_quater().intValue());
			}
			
			Row row3 = sheet.getRow(11);
			 Cell R3cell1 = row3.getCell(3); 
				if (R3cell1 != null) {
					R3cell1.setCellValue(BRF074.getR3_acc_fund_national() == null ? 0 : BRF074.getR3_acc_fund_national().intValue());
				}
				Cell R3cell2 = row3.getCell(4); 
				if (R3cell2 != null) {
					R3cell2.setCellValue(BRF074.getR3_amt_fund_national() == null ? 0 : BRF074.getR3_amt_fund_national().intValue());
				}
				Cell R3cell3 = row3.getCell(5); 
				if (R3cell3 != null) {
					R3cell3.setCellValue(BRF074.getR3_avg_fund_national() == null ? 0 : BRF074.getR3_avg_fund_national().intValue());
				}
				Cell R3cell4 = row3.getCell(6); 
				if (R3cell4 != null) {
					R3cell4.setCellValue(BRF074.getR3_acc_unfund_national() == null ? 0 : BRF074.getR3_acc_unfund_national().intValue());
				}
				Cell R3cell5 = row3.getCell(7); 
				if (R3cell5 != null) {
					R3cell5.setCellValue(BRF074.getR3_amt_unfund_national() == null ? 0 : BRF074.getR3_amt_unfund_national().intValue());
				}
				Cell R3cell6 = row3.getCell(8); 
				if (R3cell6 != null) {
					R3cell6.setCellValue(BRF074.getR3_ccf_unfund_national() == null ? 0 : BRF074.getR3_ccf_unfund_national().intValue());
				}
				Cell R3cell7 = row3.getCell(9); 
				if (R3cell7 != null) {
					R3cell7.setCellValue(BRF074.getR3_stage3_acc_national() == null ? 0 : BRF074.getR3_stage3_acc_national().intValue());
				}
				Cell R3cell8 = row3.getCell(10); 
				if (R3cell8 != null) {
					R3cell8.setCellValue(BRF074.getR3_amt_stage3_national() == null ? 0 : BRF074.getR3_amt_stage3_national().intValue());
				}
				Cell R3cell9 = row3.getCell(11); 
				if (R3cell9 != null) {
					R3cell9.setCellValue(BRF074.getR3_acc_fund_non_national() == null ? 0 : BRF074.getR3_acc_fund_non_national().intValue());
				}
				Cell R3cell10 = row3.getCell(12); 
				if (R3cell10 != null) {
					R3cell10.setCellValue(BRF074.getR3_amt_fund_non_national() == null ? 0 : BRF074.getR3_amt_fund_non_national().intValue());
				}

				Cell R3cell11 = row3.getCell(13); 
				if (R3cell11 != null) {
					R3cell11.setCellValue(BRF074.getR3_avg_fund_non_national() == null ? 0 : BRF074.getR3_avg_fund_non_national().intValue());
				}
				Cell R3cell12 = row3.getCell(14); 
				if (R3cell12 != null) {
					R3cell12.setCellValue(BRF074.getR3_acc_unfund_non_national() == null ? 0 : BRF074.getR3_acc_unfund_non_national().intValue());
				}

				Cell R3cell13 = row3.getCell(15); 
				if (R3cell13 != null) {
					R3cell13.setCellValue(BRF074.getR3_amt_unfund_non_national() == null ? 0 : BRF074.getR3_amt_unfund_non_national().intValue());
				}
				Cell R3cell14 = row3.getCell(16); 
				if (R3cell14 != null) {
					R3cell14.setCellValue(BRF074.getR3_ccf_unfund_non_national() == null ? 0 : BRF074.getR3_ccf_unfund_non_national().intValue());
				}
				Cell R3cell15 = row3.getCell(17); 
				if (R3cell15 != null) {
					R3cell15.setCellValue(BRF074.getR3_stage3_acc_non_national() == null ? 0 : BRF074.getR3_stage3_acc_non_national().intValue());
				}
				Cell R3cell16 = row3.getCell(18); 
				if (R3cell16 != null) {
					R3cell16.setCellValue(BRF074.getR3_amt_stage3_non_national() == null ? 0 : BRF074.getR3_amt_stage3_non_national().intValue());
				}
				Cell  R3cell17 = row3.getCell(21); 
				if (R3cell17 != null) {
					R3cell17.setCellValue(BRF074.getR3_avg_total() == null ? 0 : BRF074.getR3_avg_total().intValue());
				}
				Cell  R3cell18 = row3.getCell(22); 
				if (R3cell18 != null) {
					R3cell18.setCellValue(BRF074.getR3_fund_ccf_total() == null ? 0 : BRF074.getR3_fund_ccf_total().intValue());
				}
				Cell  R3cell19 = row3.getCell(25); 
				if (R3cell19 != null) {
					R3cell19.setCellValue(BRF074.getR3_stage3_acc_quater() == null ? 0 : BRF074.getR3_stage3_acc_quater().intValue());
				}

				Cell  R3cell20 = row3.getCell(26); 
				if (R3cell20 != null) {
					R3cell20.setCellValue(BRF074.getR3_amt_stage3_acc_quater() == null ? 0 : BRF074.getR3_amt_stage3_acc_quater().intValue());
				}
			Row row4 = sheet.getRow(12);
			 Cell R4cell1 = row4.getCell(3); 
				if (R4cell1 != null) {
					R4cell1.setCellValue(BRF074.getR4_acc_fund_national() == null ? 0 : BRF074.getR4_acc_fund_national().intValue());
				}
				Cell R4cell2 = row4.getCell(4); 
				if (R4cell2 != null) {
					R4cell2.setCellValue(BRF074.getR4_amt_fund_national() == null ? 0 : BRF074.getR4_amt_fund_national().intValue());
				}
				Cell R4cell3 = row4.getCell(5); 
				if (R4cell3 != null) {
					R4cell3.setCellValue(BRF074.getR4_avg_fund_national() == null ? 0 : BRF074.getR4_avg_fund_national().intValue());
				}
				Cell R4cell4 = row4.getCell(6); 
				if (R4cell4 != null) {
					R4cell4.setCellValue(BRF074.getR4_acc_unfund_national() == null ? 0 : BRF074.getR4_acc_unfund_national().intValue());
				}
				Cell R4cell5 = row4.getCell(7); 
				if (R4cell5 != null) {
					R4cell5.setCellValue(BRF074.getR4_amt_unfund_national() == null ? 0 : BRF074.getR4_amt_unfund_national().intValue());
				}
				Cell R4cell6 = row4.getCell(8); 
				if (R4cell6 != null) {
					R4cell6.setCellValue(BRF074.getR4_ccf_unfund_national() == null ? 0 : BRF074.getR4_ccf_unfund_national().intValue());
				}
				Cell R4cell7 = row4.getCell(9); 
				if (R4cell7 != null) {
					R4cell7.setCellValue(BRF074.getR4_stage3_acc_national() == null ? 0 : BRF074.getR4_stage3_acc_national().intValue());
				}
				Cell R4cell8 = row4.getCell(10); 
				if (R4cell8 != null) {
					R4cell8.setCellValue(BRF074.getR4_amt_stage3_national() == null ? 0 : BRF074.getR4_amt_stage3_national().intValue());
				}
				Cell R4cell9 = row4.getCell(11); 
				if (R4cell9 != null) {
					R4cell9.setCellValue(BRF074.getR4_acc_fund_non_national() == null ? 0 : BRF074.getR4_acc_fund_non_national().intValue());
				}
				Cell R4cell10 = row4.getCell(12); 
				if (R4cell10 != null) {
					R4cell10.setCellValue(BRF074.getR4_amt_fund_non_national() == null ? 0 : BRF074.getR4_amt_fund_non_national().intValue());
				}

				Cell R4cell11 = row4.getCell(13); 
				if (R4cell11 != null) {
					R4cell11.setCellValue(BRF074.getR4_avg_fund_non_national() == null ? 0 : BRF074.getR4_avg_fund_non_national().intValue());
				}
				Cell R4cell12 = row4.getCell(14); 
				if (R4cell12 != null) {
					R4cell12.setCellValue(BRF074.getR4_acc_unfund_non_national() == null ? 0 : BRF074.getR4_acc_unfund_non_national().intValue());
				}

				Cell R4cell13 = row4.getCell(15); 
				if (R4cell13 != null) {
					R4cell13.setCellValue(BRF074.getR4_amt_unfund_non_national() == null ? 0 : BRF074.getR4_amt_unfund_non_national().intValue());
				}
				Cell R4cell14 = row4.getCell(16); 
				if (R4cell14 != null) {
					R4cell14.setCellValue(BRF074.getR4_ccf_unfund_non_national() == null ? 0 : BRF074.getR4_ccf_unfund_non_national().intValue());
				}
				Cell R4cell15 = row4.getCell(17); 
				if (R4cell15 != null) {
					R4cell15.setCellValue(BRF074.getR4_stage3_acc_non_national() == null ? 0 : BRF074.getR4_stage3_acc_non_national().intValue());
				}
				Cell R4cell16 = row4.getCell(18); 
				if (R4cell16 != null) {
					R4cell16.setCellValue(BRF074.getR4_amt_stage3_non_national() == null ? 0 : BRF074.getR4_amt_stage3_non_national().intValue());
				}
				Cell  R4cell17 = row4.getCell(21); 
				if (R4cell17 != null) {
					R4cell17.setCellValue(BRF074.getR4_avg_total() == null ? 0 : BRF074.getR4_avg_total().intValue());
				}
				Cell  R4cell18 = row4.getCell(22); 
				if (R4cell18 != null) {
					R4cell18.setCellValue(BRF074.getR4_fund_ccf_total() == null ? 0 : BRF074.getR4_fund_ccf_total().intValue());
				}
				Cell  R4cell19 = row4.getCell(25); 
				if (R4cell19 != null) {
					R4cell19.setCellValue(BRF074.getR4_stage3_acc_quater() == null ? 0 : BRF074.getR4_stage3_acc_quater().intValue());
				}

				Cell  R4cell20 = row4.getCell(26); 
				if (R4cell20 != null) {
					R4cell20.setCellValue(BRF074.getR4_amt_stage3_acc_quater() == null ? 0 : BRF074.getR4_amt_stage3_acc_quater().intValue());
				}
			Row row6 = sheet.getRow(14);
			 Cell R6cell1 = row6.getCell(3); 
				if (R6cell1 != null) {
					R6cell1.setCellValue(BRF074.getR6_acc_fund_national() == null ? 0 : BRF074.getR6_acc_fund_national().intValue());
				}
				Cell R6cell2 = row6.getCell(4); 
				if (R6cell2 != null) {
					R6cell2.setCellValue(BRF074.getR6_amt_fund_national() == null ? 0 : BRF074.getR6_amt_fund_national().intValue());
				}
				Cell R6cell3 = row6.getCell(5); 
				if (R6cell3 != null) {
					R6cell3.setCellValue(BRF074.getR6_avg_fund_national() == null ? 0 : BRF074.getR6_avg_fund_national().intValue());
				}
				Cell R6cell4 = row6.getCell(6); 
				if (R6cell4 != null) {
					R6cell4.setCellValue(BRF074.getR6_acc_unfund_national() == null ? 0 : BRF074.getR6_acc_unfund_national().intValue());
				}
				Cell R6cell5 = row6.getCell(7); 
				if (R6cell5 != null) {
					R6cell5.setCellValue(BRF074.getR6_amt_unfund_national() == null ? 0 : BRF074.getR6_amt_unfund_national().intValue());
				}
				Cell R6cell6 = row6.getCell(8); 
				if (R6cell6 != null) {
					R6cell6.setCellValue(BRF074.getR6_ccf_unfund_national() == null ? 0 : BRF074.getR6_ccf_unfund_national().intValue());
				}
				Cell R6cell7 = row6.getCell(9); 
				if (R6cell7 != null) {
					R6cell7.setCellValue(BRF074.getR6_stage3_acc_national() == null ? 0 : BRF074.getR6_stage3_acc_national().intValue());
				}
				Cell R6cell8 = row6.getCell(10); 
				if (R6cell8 != null) {
					R6cell8.setCellValue(BRF074.getR6_amt_stage3_national() == null ? 0 : BRF074.getR6_amt_stage3_national().intValue());
				}
				Cell R6cell9 = row6.getCell(11); 
				if (R6cell9 != null) {
					R6cell9.setCellValue(BRF074.getR6_acc_fund_non_national() == null ? 0 : BRF074.getR6_acc_fund_non_national().intValue());
				}
				Cell R6cell10 = row6.getCell(12); 
				if (R6cell10 != null) {
					R6cell10.setCellValue(BRF074.getR6_amt_fund_non_national() == null ? 0 : BRF074.getR6_amt_fund_non_national().intValue());
				}

				Cell R6cell11 = row6.getCell(13); 
				if (R6cell11 != null) {
					R6cell11.setCellValue(BRF074.getR6_avg_fund_non_national() == null ? 0 : BRF074.getR6_avg_fund_non_national().intValue());
				}
				Cell R6cell12 = row6.getCell(14); 
				if (R6cell12 != null) {
					R6cell12.setCellValue(BRF074.getR6_acc_unfund_non_national() == null ? 0 : BRF074.getR6_acc_unfund_non_national().intValue());
				}

				Cell R6cell13 = row6.getCell(15); 
				if (R6cell13 != null) {
					R6cell13.setCellValue(BRF074.getR6_amt_unfund_non_national() == null ? 0 : BRF074.getR6_amt_unfund_non_national().intValue());
				}
				Cell R6cell14 = row6.getCell(16); 
				if (R6cell14 != null) {
					R6cell14.setCellValue(BRF074.getR6_ccf_unfund_non_national() == null ? 0 : BRF074.getR6_ccf_unfund_non_national().intValue());
				}
				Cell R6cell15 = row6.getCell(17); 
				if (R6cell15 != null) {
					R6cell15.setCellValue(BRF074.getR6_stage3_acc_non_national() == null ? 0 : BRF074.getR6_stage3_acc_non_national().intValue());
				}
				Cell R6cell16 = row6.getCell(18); 
				if (R6cell16 != null) {
					R6cell16.setCellValue(BRF074.getR6_amt_stage3_non_national() == null ? 0 : BRF074.getR6_amt_stage3_non_national().intValue());
				}
				Cell  R6cell17 = row6.getCell(21); 
				if (R6cell17 != null) {
					R6cell17.setCellValue(BRF074.getR6_avg_total() == null ? 0 : BRF074.getR6_avg_total().intValue());
				}
				Cell  R6cell18 = row6.getCell(22); 
				if (R6cell18 != null) {
					R6cell18.setCellValue(BRF074.getR6_fund_ccf_total() == null ? 0 : BRF074.getR6_fund_ccf_total().intValue());
				}
				Cell  R6cell19 = row6.getCell(25); 
				if (R6cell19 != null) {
					R6cell19.setCellValue(BRF074.getR6_stage3_acc_quater() == null ? 0 : BRF074.getR6_stage3_acc_quater().intValue());
				}

				Cell  R6cell20 = row6.getCell(26); 
				if (R6cell20 != null) {
					R6cell20.setCellValue(BRF074.getR6_amt_stage3_acc_quater() == null ? 0 : BRF074.getR6_amt_stage3_acc_quater().intValue());
				}
            Row row7 = sheet.getRow(15);
            Cell R7cell1 = row7.getCell(3); 
			if (R7cell1 != null) {
				R7cell1.setCellValue(BRF074.getR7_acc_fund_national() == null ? 0 : BRF074.getR7_acc_fund_national().intValue());
			}
			Cell R7cell2 = row7.getCell(4); 
			if (R7cell2 != null) {
				R7cell2.setCellValue(BRF074.getR7_amt_fund_national() == null ? 0 : BRF074.getR7_amt_fund_national().intValue());
			}
			Cell R7cell3 = row7.getCell(5); 
			if (R7cell3 != null) {
				R7cell3.setCellValue(BRF074.getR7_avg_fund_national() == null ? 0 : BRF074.getR7_avg_fund_national().intValue());
			}
			Cell R7cell4 = row7.getCell(6); 
			if (R7cell4 != null) {
				R7cell4.setCellValue(BRF074.getR7_acc_unfund_national() == null ? 0 : BRF074.getR7_acc_unfund_national().intValue());
			}
			Cell R7cell5 = row7.getCell(7); 
			if (R7cell5 != null) {
				R7cell5.setCellValue(BRF074.getR7_amt_unfund_national() == null ? 0 : BRF074.getR7_amt_unfund_national().intValue());
			}
			Cell R7cell6 = row7.getCell(8); 
			if (R7cell6 != null) {
				R7cell6.setCellValue(BRF074.getR7_ccf_unfund_national() == null ? 0 : BRF074.getR7_ccf_unfund_national().intValue());
			}
			Cell R7cell7 = row7.getCell(9); 
			if (R7cell7 != null) {
				R7cell7.setCellValue(BRF074.getR7_stage3_acc_national() == null ? 0 : BRF074.getR7_stage3_acc_national().intValue());
			}
			Cell R7cell8 = row7.getCell(10); 
			if (R7cell8 != null) {
				R7cell8.setCellValue(BRF074.getR7_amt_stage3_national() == null ? 0 : BRF074.getR7_amt_stage3_national().intValue());
			}
			Cell R7cell9 = row7.getCell(11); 
			if (R7cell9 != null) {
				R7cell9.setCellValue(BRF074.getR7_acc_fund_non_national() == null ? 0 : BRF074.getR7_acc_fund_non_national().intValue());
			}
			Cell R7cell10 = row7.getCell(12); 
			if (R7cell10 != null) {
				R7cell10.setCellValue(BRF074.getR7_amt_fund_non_national() == null ? 0 : BRF074.getR7_amt_fund_non_national().intValue());
			}

			Cell R7cell11 = row7.getCell(13); 
			if (R7cell11 != null) {
				R7cell11.setCellValue(BRF074.getR7_avg_fund_non_national() == null ? 0 : BRF074.getR7_avg_fund_non_national().intValue());
			}
			Cell R7cell12 = row7.getCell(14); 
			if (R7cell12 != null) {
				R7cell12.setCellValue(BRF074.getR7_acc_unfund_non_national() == null ? 0 : BRF074.getR7_acc_unfund_non_national().intValue());
			}

			Cell R7cell13 = row7.getCell(15); 
			if (R7cell13 != null) {
				R7cell13.setCellValue(BRF074.getR7_amt_unfund_non_national() == null ? 0 : BRF074.getR7_amt_unfund_non_national().intValue());
			}
			Cell R7cell14 = row7.getCell(16); 
			if (R7cell14 != null) {
				R7cell14.setCellValue(BRF074.getR7_ccf_unfund_non_national() == null ? 0 : BRF074.getR7_ccf_unfund_non_national().intValue());
			}
			Cell R7cell15 = row7.getCell(17); 
			if (R7cell15 != null) {
				R7cell15.setCellValue(BRF074.getR7_stage3_acc_non_national() == null ? 0 : BRF074.getR7_stage3_acc_non_national().intValue());
			}
			Cell R7cell16 = row7.getCell(18); 
			if (R7cell16 != null) {
				R7cell16.setCellValue(BRF074.getR7_amt_stage3_non_national() == null ? 0 : BRF074.getR7_amt_stage3_non_national().intValue());
			}
			Cell  R7cell17 = row7.getCell(21); 
			if (R7cell17 != null) {
				R7cell17.setCellValue(BRF074.getR7_avg_total() == null ? 0 : BRF074.getR7_avg_total().intValue());
			}
			Cell  R7cell18 = row7.getCell(22); 
			if (R7cell18 != null) {
				R7cell18.setCellValue(BRF074.getR7_fund_ccf_total() == null ? 0 : BRF074.getR7_fund_ccf_total().intValue());
			}
			Cell  R7cell19 = row7.getCell(25); 
			if (R7cell19 != null) {
				R7cell19.setCellValue(BRF074.getR7_stage3_acc_quater() == null ? 0 : BRF074.getR7_stage3_acc_quater().intValue());
			}

			Cell  R7cell20 = row7.getCell(26); 
			if (R7cell20 != null) {
				R7cell20.setCellValue(BRF074.getR7_amt_stage3_acc_quater() == null ? 0 : BRF074.getR7_amt_stage3_acc_quater().intValue());
			}
			Row row8 = sheet.getRow(16);
			 Cell R8cell1 = row8.getCell(3); 
				if (R8cell1 != null) {
					R8cell1.setCellValue(BRF074.getR8_acc_fund_national() == null ? 0 : BRF074.getR8_acc_fund_national().intValue());
				}
				Cell R8cell2 = row8.getCell(4); 
				if (R8cell2 != null) {
					R8cell2.setCellValue(BRF074.getR8_amt_fund_national() == null ? 0 : BRF074.getR8_amt_fund_national().intValue());
				}
				Cell R8cell3 = row8.getCell(5); 
				if (R8cell3 != null) {
					R8cell3.setCellValue(BRF074.getR8_avg_fund_national() == null ? 0 : BRF074.getR8_avg_fund_national().intValue());
				}
				Cell R8cell4 = row8.getCell(6); 
				if (R8cell4 != null) {
					R8cell4.setCellValue(BRF074.getR8_acc_unfund_national() == null ? 0 : BRF074.getR8_acc_unfund_national().intValue());
				}
				Cell R8cell5 = row8.getCell(7); 
				if (R8cell5 != null) {
					R8cell5.setCellValue(BRF074.getR8_amt_unfund_national() == null ? 0 : BRF074.getR8_amt_unfund_national().intValue());
				}
				Cell R8cell6 = row8.getCell(8); 
				if (R8cell6 != null) {
					R8cell6.setCellValue(BRF074.getR8_ccf_unfund_national() == null ? 0 : BRF074.getR8_ccf_unfund_national().intValue());
				}
				Cell R8cell7 = row8.getCell(9); 
				if (R8cell7 != null) {
					R8cell7.setCellValue(BRF074.getR8_stage3_acc_national() == null ? 0 : BRF074.getR8_stage3_acc_national().intValue());
				}
				Cell R8cell8 = row8.getCell(10); 
				if (R8cell8 != null) {
					R8cell8.setCellValue(BRF074.getR8_amt_stage3_national() == null ? 0 : BRF074.getR8_amt_stage3_national().intValue());
				}
				Cell R8cell9 = row8.getCell(11); 
				if (R8cell9 != null) {
					R8cell9.setCellValue(BRF074.getR8_acc_fund_non_national() == null ? 0 : BRF074.getR8_acc_fund_non_national().intValue());
				}
				Cell R8cell10 = row8.getCell(12); 
				if (R8cell10 != null) {
					R8cell10.setCellValue(BRF074.getR8_amt_fund_non_national() == null ? 0 : BRF074.getR8_amt_fund_non_national().intValue());
				}

				Cell R8cell11 = row8.getCell(13); 
				if (R8cell11 != null) {
					R8cell11.setCellValue(BRF074.getR8_avg_fund_non_national() == null ? 0 : BRF074.getR8_avg_fund_non_national().intValue());
				}
				Cell R8cell12 = row8.getCell(14); 
				if (R8cell12 != null) {
					R8cell12.setCellValue(BRF074.getR8_acc_unfund_non_national() == null ? 0 : BRF074.getR8_acc_unfund_non_national().intValue());
				}

				Cell R8cell13 = row8.getCell(15); 
				if (R8cell13 != null) {
					R8cell13.setCellValue(BRF074.getR8_amt_unfund_non_national() == null ? 0 : BRF074.getR8_amt_unfund_non_national().intValue());
				}
				Cell R8cell14 = row8.getCell(16); 
				if (R8cell14 != null) {
					R8cell14.setCellValue(BRF074.getR8_ccf_unfund_non_national() == null ? 0 : BRF074.getR8_ccf_unfund_non_national().intValue());
				}
				Cell R8cell15 = row8.getCell(17); 
				if (R8cell15 != null) {
					R8cell15.setCellValue(BRF074.getR8_stage3_acc_non_national() == null ? 0 : BRF074.getR8_stage3_acc_non_national().intValue());
				}
				Cell R8cell16 = row8.getCell(18); 
				if (R8cell16 != null) {
					R8cell16.setCellValue(BRF074.getR8_amt_stage3_non_national() == null ? 0 : BRF074.getR8_amt_stage3_non_national().intValue());
				}
				Cell  R8cell17 = row8.getCell(21); 
				if (R8cell17 != null) {
					R8cell17.setCellValue(BRF074.getR8_avg_total() == null ? 0 : BRF074.getR8_avg_total().intValue());
				}
				Cell  R8cell18 = row8.getCell(22); 
				if (R8cell18 != null) {
					R8cell18.setCellValue(BRF074.getR8_fund_ccf_total() == null ? 0 : BRF074.getR8_fund_ccf_total().intValue());
				}
				Cell  R8cell19 = row8.getCell(25); 
				if (R8cell19 != null) {
					R8cell19.setCellValue(BRF074.getR8_stage3_acc_quater() == null ? 0 : BRF074.getR8_stage3_acc_quater().intValue());
				}

				Cell  R8cell20 = row8.getCell(26); 
				if (R8cell20 != null) {
					R8cell20.setCellValue(BRF074.getR8_amt_stage3_acc_quater() == null ? 0 : BRF074.getR8_amt_stage3_acc_quater().intValue());
				}
			Row row10 = sheet.getRow(18);
			 Cell R10cell1 = row10.getCell(3); 
				if (R10cell1 != null) {
					R10cell1.setCellValue(BRF074.getR10_acc_fund_national() == null ? 0 : BRF074.getR10_acc_fund_national().intValue());
				}
				Cell R10cell2 = row10.getCell(4); 
				if (R10cell2 != null) {
					R10cell2.setCellValue(BRF074.getR10_amt_fund_national() == null ? 0 : BRF074.getR10_amt_fund_national().intValue());
				}
				Cell R10cell3 = row10.getCell(5); 
				if (R10cell3 != null) {
					R10cell3.setCellValue(BRF074.getR10_avg_fund_national() == null ? 0 : BRF074.getR10_avg_fund_national().intValue());
				}
				Cell R10cell4 = row10.getCell(6); 
				if (R10cell4 != null) {
					R10cell4.setCellValue(BRF074.getR10_acc_unfund_national() == null ? 0 : BRF074.getR10_acc_unfund_national().intValue());
				}
				Cell R10cell5 = row10.getCell(7); 
				if (R10cell5 != null) {
					R10cell5.setCellValue(BRF074.getR10_amt_unfund_national() == null ? 0 : BRF074.getR10_amt_unfund_national().intValue());
				}
				Cell R10cell6 = row10.getCell(8); 
				if (R10cell6 != null) {
					R10cell6.setCellValue(BRF074.getR10_ccf_unfund_national() == null ? 0 : BRF074.getR10_ccf_unfund_national().intValue());
				}
				Cell R10cell7 = row10.getCell(9); 
				if (R10cell7 != null) {
					R10cell7.setCellValue(BRF074.getR10_stage3_acc_national() == null ? 0 : BRF074.getR10_stage3_acc_national().intValue());
				}
				Cell R10cell8 = row10.getCell(10); 
				if (R10cell8 != null) {
					R10cell8.setCellValue(BRF074.getR10_amt_stage3_national() == null ? 0 : BRF074.getR10_amt_stage3_national().intValue());
				}
				Cell R10cell9 = row10.getCell(11); 
				if (R10cell9 != null) {
					R10cell9.setCellValue(BRF074.getR10_acc_fund_non_national() == null ? 0 : BRF074.getR10_acc_fund_non_national().intValue());
				}
				Cell R10cell10 = row10.getCell(12); 
				if (R10cell10 != null) {
					R10cell10.setCellValue(BRF074.getR10_amt_fund_non_national() == null ? 0 : BRF074.getR10_amt_fund_non_national().intValue());
				}

				Cell R10cell11 = row10.getCell(13); 
				if (R10cell11 != null) {
					R10cell11.setCellValue(BRF074.getR10_avg_fund_non_national() == null ? 0 : BRF074.getR10_avg_fund_non_national().intValue());
				}
				Cell R10cell12 = row10.getCell(14); 
				if (R10cell12 != null) {
					R10cell12.setCellValue(BRF074.getR10_acc_unfund_non_national() == null ? 0 : BRF074.getR10_acc_unfund_non_national().intValue());
				}

				Cell R10cell13 = row10.getCell(15); 
				if (R10cell13 != null) {
					R10cell13.setCellValue(BRF074.getR10_amt_unfund_non_national() == null ? 0 : BRF074.getR10_amt_unfund_non_national().intValue());
				}
				Cell R10cell14 = row10.getCell(16); 
				if (R10cell14 != null) {
					R10cell14.setCellValue(BRF074.getR10_ccf_unfund_non_national() == null ? 0 : BRF074.getR10_ccf_unfund_non_national().intValue());
				}
				Cell R10cell15 = row10.getCell(17); 
				if (R10cell15 != null) {
					R10cell15.setCellValue(BRF074.getR10_stage3_acc_non_national() == null ? 0 : BRF074.getR10_stage3_acc_non_national().intValue());
				}
				Cell R10cell16 = row10.getCell(18); 
				if (R10cell16 != null) {
					R10cell16.setCellValue(BRF074.getR10_amt_stage3_non_national() == null ? 0 : BRF074.getR10_amt_stage3_non_national().intValue());
				}
				Cell  R10cell17 = row10.getCell(21); 
				if (R10cell17 != null) {
					R10cell17.setCellValue(BRF074.getR10_avg_total() == null ? 0 : BRF074.getR10_avg_total().intValue());
				}
				Cell  R10cell18 = row10.getCell(22); 
				if (R10cell18 != null) {
					R10cell18.setCellValue(BRF074.getR10_fund_ccf_total() == null ? 0 : BRF074.getR10_fund_ccf_total().intValue());
				}
				Cell  R10cell19 = row10.getCell(25); 
				if (R10cell19 != null) {
					R10cell19.setCellValue(BRF074.getR10_stage3_acc_quater() == null ? 0 : BRF074.getR10_stage3_acc_quater().intValue());
				}

				Cell  R10cell20 = row10.getCell(26); 
				if (R10cell20 != null) {
					R10cell20.setCellValue(BRF074.getR10_amt_stage3_acc_quater() == null ? 0 : BRF074.getR10_amt_stage3_acc_quater().intValue());
				}
			Row row11 = sheet.getRow(19);
			 Cell R11cell1 = row11.getCell(3); 
				if (R11cell1 != null) {
					R11cell1.setCellValue(BRF074.getR11_acc_fund_national() == null ? 0 : BRF074.getR11_acc_fund_national().intValue());
				}
				Cell R11cell2 = row11.getCell(4); 
				if (R11cell2 != null) {
					R11cell2.setCellValue(BRF074.getR11_amt_fund_national() == null ? 0 : BRF074.getR11_amt_fund_national().intValue());
				}
				Cell R11cell3 = row11.getCell(5); 
				if (R11cell3 != null) {
					R11cell3.setCellValue(BRF074.getR11_avg_fund_national() == null ? 0 : BRF074.getR11_avg_fund_national().intValue());
				}
				Cell R11cell4 = row11.getCell(6); 
				if (R11cell4 != null) {
					R11cell4.setCellValue(BRF074.getR11_acc_unfund_national() == null ? 0 : BRF074.getR11_acc_unfund_national().intValue());
				}
				Cell R11cell5 = row11.getCell(7); 
				if (R11cell5 != null) {
					R11cell5.setCellValue(BRF074.getR11_amt_unfund_national() == null ? 0 : BRF074.getR11_amt_unfund_national().intValue());
				}
				Cell R11cell6 = row11.getCell(8); 
				if (R11cell6 != null) {
					R11cell6.setCellValue(BRF074.getR11_ccf_unfund_national() == null ? 0 : BRF074.getR11_ccf_unfund_national().intValue());
				}
				Cell R11cell7 = row11.getCell(9); 
				if (R11cell7 != null) {
					R11cell7.setCellValue(BRF074.getR11_stage3_acc_national() == null ? 0 : BRF074.getR11_stage3_acc_national().intValue());
				}
				Cell R11cell8 = row11.getCell(10); 
				if (R11cell8 != null) {
					R11cell8.setCellValue(BRF074.getR11_amt_stage3_national() == null ? 0 : BRF074.getR11_amt_stage3_national().intValue());
				}
				Cell R11cell9 = row11.getCell(11); 
				if (R11cell9 != null) {
					R11cell9.setCellValue(BRF074.getR11_acc_fund_non_national() == null ? 0 : BRF074.getR11_acc_fund_non_national().intValue());
				}
				Cell R11cell10 = row11.getCell(12); 
				if (R11cell10 != null) {
					R11cell10.setCellValue(BRF074.getR11_amt_fund_non_national() == null ? 0 : BRF074.getR11_amt_fund_non_national().intValue());
				}

				Cell R11cell11 = row11.getCell(13); 
				if (R11cell11 != null) {
					R11cell11.setCellValue(BRF074.getR11_avg_fund_non_national() == null ? 0 : BRF074.getR11_avg_fund_non_national().intValue());
				}
				Cell R11cell12 = row11.getCell(14); 
				if (R11cell12 != null) {
					R11cell12.setCellValue(BRF074.getR11_acc_unfund_non_national() == null ? 0 : BRF074.getR11_acc_unfund_non_national().intValue());
				}

				Cell R11cell13 = row11.getCell(15); 
				if (R11cell13 != null) {
					R11cell13.setCellValue(BRF074.getR11_amt_unfund_non_national() == null ? 0 : BRF074.getR11_amt_unfund_non_national().intValue());
				}
				Cell R11cell14 = row11.getCell(16); 
				if (R11cell14 != null) {
					R11cell14.setCellValue(BRF074.getR11_ccf_unfund_non_national() == null ? 0 : BRF074.getR11_ccf_unfund_non_national().intValue());
				}
				Cell R11cell15 = row11.getCell(17); 
				if (R11cell15 != null) {
					R11cell15.setCellValue(BRF074.getR11_stage3_acc_non_national() == null ? 0 : BRF074.getR11_stage3_acc_non_national().intValue());
				}
				Cell R11cell16 = row11.getCell(18); 
				if (R11cell16 != null) {
					R11cell16.setCellValue(BRF074.getR11_amt_stage3_non_national() == null ? 0 : BRF074.getR11_amt_stage3_non_national().intValue());
				}
				Cell  R11cell17 = row11.getCell(21); 
				if (R11cell17 != null) {
					R11cell17.setCellValue(BRF074.getR11_avg_total() == null ? 0 : BRF074.getR11_avg_total().intValue());
				}
				Cell  R11cell18 = row11.getCell(22); 
				if (R11cell18 != null) {
					R11cell18.setCellValue(BRF074.getR11_fund_ccf_total() == null ? 0 : BRF074.getR11_fund_ccf_total().intValue());
				}
				Cell  R11cell19 = row11.getCell(25); 
				if (R11cell19 != null) {
					R11cell19.setCellValue(BRF074.getR11_stage3_acc_quater() == null ? 0 : BRF074.getR11_stage3_acc_quater().intValue());
				}

				Cell  R11cell20 = row11.getCell(26); 
				if (R11cell20 != null) {
					R11cell20.setCellValue(BRF074.getR11_amt_stage3_acc_quater() == null ? 0 : BRF074.getR11_amt_stage3_acc_quater().intValue());
				}
			Row row12 = sheet.getRow(20);
			 Cell R12cell1 = row12.getCell(3); 
				if (R12cell1 != null) {
					R12cell1.setCellValue(BRF074.getR12_acc_fund_national() == null ? 0 : BRF074.getR12_acc_fund_national().intValue());
				}
				Cell R12cell2 = row12.getCell(4); 
				if (R12cell2 != null) {
					R12cell2.setCellValue(BRF074.getR12_amt_fund_national() == null ? 0 : BRF074.getR12_amt_fund_national().intValue());
				}
				Cell R12cell3 = row12.getCell(5); 
				if (R12cell3 != null) {
					R12cell3.setCellValue(BRF074.getR12_avg_fund_national() == null ? 0 : BRF074.getR12_avg_fund_national().intValue());
				}
				Cell R12cell4 = row12.getCell(6); 
				if (R12cell4 != null) {
					R12cell4.setCellValue(BRF074.getR12_acc_unfund_national() == null ? 0 : BRF074.getR12_acc_unfund_national().intValue());
				}
				Cell R12cell5 = row12.getCell(7); 
				if (R12cell5 != null) {
					R12cell5.setCellValue(BRF074.getR12_amt_unfund_national() == null ? 0 : BRF074.getR12_amt_unfund_national().intValue());
				}
				Cell R12cell6 = row12.getCell(8); 
				if (R12cell6 != null) {
					R12cell6.setCellValue(BRF074.getR12_ccf_unfund_national() == null ? 0 : BRF074.getR12_ccf_unfund_national().intValue());
				}
				Cell R12cell7 = row12.getCell(9); 
				if (R12cell7 != null) {
					R12cell7.setCellValue(BRF074.getR12_stage3_acc_national() == null ? 0 : BRF074.getR12_stage3_acc_national().intValue());
				}
				Cell R12cell8 = row12.getCell(10); 
				if (R12cell8 != null) {
					R12cell8.setCellValue(BRF074.getR12_amt_stage3_national() == null ? 0 : BRF074.getR12_amt_stage3_national().intValue());
				}
				Cell R12cell9 = row12.getCell(11); 
				if (R12cell9 != null) {
					R12cell9.setCellValue(BRF074.getR12_acc_fund_non_national() == null ? 0 : BRF074.getR12_acc_fund_non_national().intValue());
				}
				Cell R12cell10 = row12.getCell(12); 
				if (R12cell10 != null) {
					R12cell10.setCellValue(BRF074.getR12_amt_fund_non_national() == null ? 0 : BRF074.getR12_amt_fund_non_national().intValue());
				}

				Cell R12cell11 = row12.getCell(13); 
				if (R12cell11 != null) {
					R12cell11.setCellValue(BRF074.getR12_avg_fund_non_national() == null ? 0 : BRF074.getR12_avg_fund_non_national().intValue());
				}
				Cell R12cell12 = row12.getCell(14); 
				if (R12cell12 != null) {
					R12cell12.setCellValue(BRF074.getR12_acc_unfund_non_national() == null ? 0 : BRF074.getR12_acc_unfund_non_national().intValue());
				}

				Cell R12cell13 = row12.getCell(15); 
				if (R12cell13 != null) {
					R12cell13.setCellValue(BRF074.getR12_amt_unfund_non_national() == null ? 0 : BRF074.getR12_amt_unfund_non_national().intValue());
				}
				Cell R12cell14 = row12.getCell(16); 
				if (R12cell14 != null) {
					R12cell14.setCellValue(BRF074.getR12_ccf_unfund_non_national() == null ? 0 : BRF074.getR12_ccf_unfund_non_national().intValue());
				}
				Cell R12cell15 = row12.getCell(17); 
				if (R12cell15 != null) {
					R12cell15.setCellValue(BRF074.getR12_stage3_acc_non_national() == null ? 0 : BRF074.getR12_stage3_acc_non_national().intValue());
				}
				Cell R12cell16 = row12.getCell(18); 
				if (R12cell16 != null) {
					R12cell16.setCellValue(BRF074.getR12_amt_stage3_non_national() == null ? 0 : BRF074.getR12_amt_stage3_non_national().intValue());
				}
				Cell  R12cell17 = row12.getCell(21); 
				if (R12cell17 != null) {
					R12cell17.setCellValue(BRF074.getR12_avg_total() == null ? 0 : BRF074.getR12_avg_total().intValue());
				}
				Cell  R12cell18 = row12.getCell(22); 
				if (R12cell18 != null) {
					R12cell18.setCellValue(BRF074.getR12_fund_ccf_total() == null ? 0 : BRF074.getR12_fund_ccf_total().intValue());
				}
				Cell  R12cell19 = row12.getCell(25); 
				if (R12cell19 != null) {
					R12cell19.setCellValue(BRF074.getR12_stage3_acc_quater() == null ? 0 : BRF074.getR12_stage3_acc_quater().intValue());
				}

				Cell  R12cell20 = row12.getCell(26); 
				if (R12cell20 != null) {
					R12cell20.setCellValue(BRF074.getR12_amt_stage3_acc_quater() == null ? 0 : BRF074.getR12_amt_stage3_acc_quater().intValue());
				}
		 // Save the changes
		workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
		            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-074-A.xls");
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
			outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-074-A.xls");

			return outputFile;



		}
	
	
	public String detailChanges74(BRF74_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF74_DETAIL_ENTITY> Brf74detail =brf74_detailrepo.findById(foracid);

			if (Brf74detail.isPresent()) {
				BRF74_DETAIL_ENTITY BRFdetail = Brf74detail.get();

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
					brf74_detailrepo.save(BRFdetail);

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
	
	
	
	/**** ARCH DETAILS 
	 * @throws ParseException ****/

	public ModelAndView ARCHgetBRF074currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF74_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF74_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF74_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF74_ARCHIV_ENTITY> T1Master = new ArrayList<BRF74_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF74_ARCHIV_ENTITY a where a.report_date = ?1", BRF74_ARCHIV_ENTITY.class)
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
			Character del_flg = (Character) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String)a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nre_flag = (Character) a[49];
			
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

			BRF74_ARCHIV_ENTITY py = new BRF74_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nre_flag);
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

		mv.setViewName("RR" + "/" + "BRF74ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}


	public ModelAndView getArchieveBRF074View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF74_ENTITY> T1rep = new ArrayList<BRF74_ENTITY>();


		List<BRF74_ENTITY> T1Master = new ArrayList<BRF74_ENTITY>();


		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);


			T1Master = hs.createQuery("from BRF74_ENTITY a where a.report_date = ?1 ", BRF74_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();



		} catch (ParseException e) {
			e.printStackTrace();
		}
		mv.setViewName("RR/BRF74ARCH");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}




		}


	


