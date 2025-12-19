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

import com.bornfire.xbrl.entities.BRBS.BRF151ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF152ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF153ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF154ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF155ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF051ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF060Reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF56ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF56_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF56_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF32ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF56_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF56_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF56_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;

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

public class BRF56ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF56ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;
	
	@Autowired
	Environment env;
	
	
	@Autowired
	BRF56_DetailRepo  brf56DetailRep;
	
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF056(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF56_ENTITY1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF56_ENTITY1 a").getSingleResult();
				if (modcnt > 0) {
					msg = "success";
				}
			} else {
			//	msg = "Data Not availabel for the Report. Please Contact Administrator";
				msg = "success";

			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "success";
			e.printStackTrace();

		}

		return msg;

	}
	
	public ModelAndView getBRF056View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF56_ENTITY1> T1rep = new ArrayList<BRF56_ENTITY1>();
		// Query<Object[]> qr;

		List<BRF56_ENTITY1> T1Master = new ArrayList<BRF56_ENTITY1>();
		
		List<BRF56_ENTITY2> T1Master1 = new ArrayList<BRF56_ENTITY2>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF56_ENTITY1 a where a.report_date = ?1 ", BRF56_ENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			T1Master1 = hs.createQuery("from BRF56_ENTITY2 a where a.report_date = ?1 ", BRF56_ENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF56");
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
	public ModelAndView getBRF056Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF56_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery ("select * from BRF56_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF56_DETAILTABLE a where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF56_DETAIL_ENTITY> T1Master = new ArrayList<BRF56_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF56_DETAIL_ENTITY a where a.report_date = ?1", BRF56_DETAIL_ENTITY.class)
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

			BRF56_DETAIL_ENTITY py = new BRF56_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks);
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

		mv.setViewName("RR"+"/"+"BRF56::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	

	public File getFileBRF056(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-056-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF56_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF56_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF56.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF56.jrxml");
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
				List<BRF56_ENTITY1> T1Master = new ArrayList<>();
				List<BRF56_ENTITY2> T1Master1 = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from BRF56_ENTITY1 a where a.report_date = ?1", BRF56_ENTITY1.class)
							.setParameter(1, df.parse(todate)).getResultList();
					T1Master1 = hs.createQuery("from BRF56_ENTITY2 a where a.report_date = ?1", BRF56_ENTITY2.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-056-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					
					
	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            if (T1Master.size() == 1) {
					for (BRF56_ENTITY1 BRF56 : T1Master) {
		
				Row row = sheet.getRow(10);
				 Cell cell3 = row.getCell(6);
				 if (cell3 != null) {
				 cell3.setCellValue(BRF56.getR2_entities() == null ? 0 :
				 BRF56.getR2_entities().intValue());
				       	 }				 
						
				 Cell cell4 = row.getCell(11);
				 if (cell4 != null) {
				 cell4.setCellValue(BRF56.getR2_nos1() == null ? 0 :
				 BRF56.getR2_nos1().intValue());
				       	 }	
				 
				 Cell cell5 = row.getCell(12);
				 if (cell5 != null) {
				 cell5.setCellValue(BRF56.getR2_amount1() == null ? 0 :
				 BRF56.getR2_amount1().intValue());
				       	 }	
					
				 Cell cell6 = row.getCell(13);
				 if (cell6 != null) {
				 cell6.setCellValue(BRF56.getR2_nos2() == null ? 0 :
				 BRF56.getR2_nos2().intValue());
				       	 }	
				 
				 Cell cell7 = row.getCell(14);
				 if (cell7 != null) {
				 cell7.setCellValue(BRF56.getR2_amount2() == null ? 0 :
				 BRF56.getR2_amount2().intValue());
				       	 }
				 
				 Cell cell8 = row.getCell(15);
				 if (cell8 != null) {
				 cell8.setCellValue(BRF56.getR2_nos3() == null ? 0 :
				 BRF56.getR2_nos3().intValue());
				       	 }	
				 
				 Cell cell9 = row.getCell(16);
				 if (cell9 != null) {
				 cell9.setCellValue(BRF56.getR2_amount3() == null ? 0 :
				 BRF56.getR2_amount3().intValue());
				       	 }
				 
				 Cell cell10 = row.getCell(17);
				 if (cell10 != null) {
				 cell10.setCellValue(BRF56.getR2_nos4() == null ? 0 :
				 BRF56.getR2_nos4().intValue());
				       	 }	
				 
				 Cell cell11 = row.getCell(18);
				 if (cell11 != null) {
				 cell11.setCellValue(BRF56.getR2_amount4() == null ? 0 :
				 BRF56.getR2_amount4().intValue());
				       	 }
				 
				 Cell cell12 = row.getCell(19);
				 if (cell12 != null) {
				 cell12.setCellValue(BRF56.getR2_nos5() == null ? 0 :
				 BRF56.getR2_nos5().intValue());
				       	 }	
				 
				 Cell cell13 = row.getCell(20);
				 if (cell13 != null) {
				 cell13.setCellValue(BRF56.getR2_amount5() == null ? 0 :
				 BRF56.getR2_amount5().intValue());
				       	 }
				 
				 Cell cell14 = row.getCell(21);
				 if (cell14 != null) {
				 cell14.setCellValue(BRF56.getR2_nos6() == null ? 0 :
				 BRF56.getR2_nos6().intValue());
				       	 }	
				 
				 Cell cell15 = row.getCell(22);
				 if (cell15 != null) {
				 cell15.setCellValue(BRF56.getR2_amount6() == null ? 0 :
				 BRF56.getR2_amount6().intValue());
				       	 }
				 
				 Cell cell16 = row.getCell(23);
				 if (cell16 != null) {
				 cell16.setCellValue(BRF56.getR2_nos7() == null ? 0 :
				 BRF56.getR2_nos7().intValue());
				       	 }	
				 
				 Cell cell17 = row.getCell(24);
				 if (cell17 != null) {
				 cell17.setCellValue(BRF56.getR2_amount7() == null ? 0 :
				 BRF56.getR2_amount7().intValue());
				       	 }
				 
				 Cell cell18 = row.getCell(25);
				 if (cell18 != null) {
				 cell18.setCellValue(BRF56.getR2_nos8() == null ? 0 :
				 BRF56.getR2_nos8().intValue());
				       	 }	
				 
				 Cell cell19 = row.getCell(26);
				 if (cell19 != null) {
				 cell19.setCellValue(BRF56.getR2_amount8() == null ? 0 :
				 BRF56.getR2_amount8().intValue());
				       	 }
				 
				 Cell cell20 = row.getCell(27);
				 if (cell20 != null) {
				 cell20.setCellValue(BRF56.getR2_nos9() == null ? 0 :
				 BRF56.getR2_nos9().intValue());
				       	 }	
				 
				 Cell cell21 = row.getCell(28);
				 if (cell21 != null) {
				 cell21.setCellValue(BRF56.getR2_amount9() == null ? 0 :
				 BRF56.getR2_amount9().intValue());
				       	 }
				 
				 Cell cell22 = row.getCell(29);
				 if (cell22 != null) {
				 cell22.setCellValue(BRF56.getR2_nos10() == null ? 0 :
				 BRF56.getR2_nos10().intValue());
				       	 }	
				 
				 Cell cell23 = row.getCell(30);
				 if (cell23 != null) {
				 cell23.setCellValue(BRF56.getR2_amount10() == null ? 0 :
				 BRF56.getR2_amount10().intValue());
				       	 }
				 
				 Cell cell24 = row.getCell(31);
				 if (cell24 != null) {
				 cell24.setCellValue(BRF56.getR2_nos11() == null ? 0 :
				 BRF56.getR2_nos11().intValue());
				       	 }	
				 
				 Cell cell25 = row.getCell(32);
				 if (cell25 != null) {
				 cell25.setCellValue(BRF56.getR2_amount11() == null ? 0 :
				 BRF56.getR2_amount11().intValue());
				       	 }
				 
				 Cell cell26 = row.getCell(33);
				 if (cell26 != null) {
				 cell26.setCellValue(BRF56.getR2_nos12() == null ? 0 :
				 BRF56.getR2_nos12().intValue());
				       	 }	
				 
				 Cell cell27 = row.getCell(34);
				 if (cell27 != null) {
				 cell27.setCellValue(BRF56.getR2_amount12() == null ? 0 :
				 BRF56.getR2_amount12().intValue());
				       	 }
				 
				 Cell cell28 = row.getCell(35);
				 if (cell28 != null) {
				 cell28.setCellValue(BRF56.getR2_nos13() == null ? 0 :
				 BRF56.getR2_nos13().intValue());
				       	 }	
				 
				 Cell cell29 = row.getCell(36);
				 if (cell29 != null) {
				 cell29.setCellValue(BRF56.getR2_amount13() == null ? 0 :
				 BRF56.getR2_amount13().intValue());
				       	 }
				 
				 Cell cell30 = row.getCell(37);
				 if (cell30 != null) {
				 cell30.setCellValue(BRF56.getR2_nos14() == null ? 0 :
				 BRF56.getR2_nos14().intValue());
				       	 }	
				 
				 Cell cell31 = row.getCell(38);
				 if (cell31 != null) {
				 cell31.setCellValue(BRF56.getR2_amount14() == null ? 0 :
				 BRF56.getR2_amount14().intValue());
				       	 }
				 
				 
/////////////////////R3/////////////////////////
					
	 Row R1row = sheet.getRow(11);
	 
	 Cell R1cell3 = R1row.getCell(6);
	 if (R1cell3 != null) {
	 R1cell3.setCellValue(BRF56.getR3_entities() == null ? 0 :
	 BRF56.getR3_entities().intValue());
	       	 }				 
			
	 Cell R1cell4 = R1row.getCell(11);
	 if (R1cell4 != null) {
	 R1cell4.setCellValue(BRF56.getR3_nos1() == null ? 0 :
	 BRF56.getR3_nos1().intValue());
	       	 }	
	 
	 Cell R1cell5 = R1row.getCell(12);
	 if (R1cell5 != null) {
	 R1cell5.setCellValue(BRF56.getR3_amount1() == null ? 0 :
	 BRF56.getR3_amount1().intValue());
	       	 }	
		
	 Cell R1cell6 = R1row.getCell(13);
	 if (R1cell6 != null) {
	 R1cell6.setCellValue(BRF56.getR3_nos2() == null ? 0 :
	 BRF56.getR3_nos2().intValue());
	       	 }	
	 
	 Cell R1cell7 = R1row.getCell(14);
	 if (R1cell7 != null) {
	 R1cell7.setCellValue(BRF56.getR3_amount2() == null ? 0 :
	 BRF56.getR3_amount2().intValue());
	       	 }
	 
	 Cell R1cell8 = R1row.getCell(15);
	 if (R1cell8 != null) {
	 R1cell8.setCellValue(BRF56.getR3_nos3() == null ? 0 :
	 BRF56.getR3_nos3().intValue());
	       	 }	
	 
	 Cell R1cell9 = R1row.getCell(16);
	 if (R1cell9 != null) {
	 R1cell9.setCellValue(BRF56.getR3_amount3() == null ? 0 :
	 BRF56.getR3_amount3().intValue());
	       	 }
	 
	 Cell R1cell10 = R1row.getCell(17);
	 if (R1cell10 != null) {
	 R1cell10.setCellValue(BRF56.getR3_nos4() == null ? 0 :
	 BRF56.getR3_nos4().intValue());
	       	 }	
	 
	 Cell R1cell11 = R1row.getCell(18);
	 if (R1cell11 != null) {
	 R1cell11.setCellValue(BRF56.getR3_amount4() == null ? 0 :
	 BRF56.getR3_amount4().intValue());
	       	 }
	 
	 Cell R1cell12 = R1row.getCell(19);
	 if (R1cell12 != null) {
	 R1cell12.setCellValue(BRF56.getR3_nos5() == null ? 0 :
	 BRF56.getR3_nos5().intValue());
	       	 }	
	 
	 Cell R1cell13 = R1row.getCell(20);
	 if (R1cell13 != null) {
	 R1cell13.setCellValue(BRF56.getR3_amount5() == null ? 0 :
	 BRF56.getR3_amount5().intValue());
	       	 }
	 
	 Cell R1cell14 = R1row.getCell(21);
	 if (R1cell14 != null) {
	 R1cell14.setCellValue(BRF56.getR3_nos6() == null ? 0 :
	 BRF56.getR3_nos6().intValue());
	       	 }	
	 
	 Cell R1cell15 = R1row.getCell(22);
	 if (R1cell15 != null) {
	 R1cell15.setCellValue(BRF56.getR3_amount6() == null ? 0 :
	 BRF56.getR3_amount6().intValue());
	       	 }
	 
	 Cell R1cell16 = R1row.getCell(23);
	 if (R1cell16 != null) {
	 R1cell16.setCellValue(BRF56.getR3_nos7() == null ? 0 :
	 BRF56.getR3_nos7().intValue());
	       	 }	
	 
	 Cell R1cell17 = R1row.getCell(24);
	 if (R1cell17 != null) {
	 R1cell17.setCellValue(BRF56.getR3_amount7() == null ? 0 :
	 BRF56.getR3_amount7().intValue());
	       	 }
	 
	 Cell R1cell18 = R1row.getCell(25);
	 if (R1cell18 != null) {
	 R1cell18.setCellValue(BRF56.getR3_nos8() == null ? 0 :
	 BRF56.getR3_nos8().intValue());
	       	 }	
	 
	 Cell R1cell19 = R1row.getCell(26);
	 if (R1cell19 != null) {
	 R1cell19.setCellValue(BRF56.getR3_amount8() == null ? 0 :
	 BRF56.getR3_amount8().intValue());
	       	 }
	 
	 Cell R1cell20 = R1row.getCell(27);
	 if (R1cell20 != null) {
	 R1cell20.setCellValue(BRF56.getR3_nos9() == null ? 0 :
	 BRF56.getR3_nos9().intValue());
	       	 }	
	 
	 Cell R1cell21 = R1row.getCell(28);
	 if (R1cell21 != null) {
	 R1cell21.setCellValue(BRF56.getR3_amount9() == null ? 0 :
	 BRF56.getR3_amount9().intValue());
	       	 }
	 
	 Cell R1cell22 = R1row.getCell(29);
	 if (R1cell22 != null) {
	 R1cell22.setCellValue(BRF56.getR3_nos10() == null ? 0 :
	 BRF56.getR3_nos10().intValue());
	       	 }	
	 
	 Cell R1cell23 = R1row.getCell(30);
	 if (R1cell23 != null) {
	 R1cell23.setCellValue(BRF56.getR3_amount10() == null ? 0 :
	 BRF56.getR3_amount10().intValue());
	       	 }
	 
	 Cell R1cell24 = R1row.getCell(31);
	 if (R1cell24 != null) {
	 R1cell24.setCellValue(BRF56.getR3_nos11() == null ? 0 :
	 BRF56.getR3_nos11().intValue());
	       	 }	
	 
	 Cell R1cell25 = R1row.getCell(32);
	 if (R1cell25 != null) {
	 R1cell25.setCellValue(BRF56.getR3_amount11() == null ? 0 :
	 BRF56.getR3_amount11().intValue());
	       	 }
	 
	 Cell R1cell26 = R1row.getCell(33);
	 if (R1cell26 != null) {
	 R1cell26.setCellValue(BRF56.getR3_nos12() == null ? 0 :
	 BRF56.getR3_nos12().intValue());
	       	 }	
	 
	 Cell R1cell27 = R1row.getCell(34);
	 if (R1cell27 != null) {
	 R1cell27.setCellValue(BRF56.getR3_amount12() == null ? 0 :
	 BRF56.getR3_amount12().intValue());
	       	 }
	 
	 Cell R1cell28 = R1row.getCell(35);
	 if (R1cell28 != null) {
	 R1cell28.setCellValue(BRF56.getR3_nos13() == null ? 0 :
	 BRF56.getR3_nos13().intValue());
	       	 }	
	 
	 Cell R1cell29 = R1row.getCell(36);
	 if (R1cell29 != null) {
	 R1cell29.setCellValue(BRF56.getR3_amount13() == null ? 0 :
	 BRF56.getR3_amount13().intValue());
	       	 }
	 
	 Cell R1cell30 = R1row.getCell(37);
	 if (R1cell30 != null) {
	 R1cell30.setCellValue(BRF56.getR3_nos14() == null ? 0 :
	 BRF56.getR3_nos14().intValue());
	       	 }	
	 
	 Cell R1cell31 = R1row.getCell(38);
	 if (R1cell31 != null) {
	 R1cell31.setCellValue(BRF56.getR3_amount14() == null ? 0 :
	 BRF56.getR3_amount14().intValue());
	       	 }
	 
/////////////////////R4/////////////////////////
		
Row R2row = sheet.getRow(12);

Cell R2cell3 = R2row.getCell(6);
if (R2cell3 != null) {
R2cell3.setCellValue(BRF56.getR4_entities() == null ? 0 :
BRF56.getR4_entities().intValue());
 }				 

Cell R2cell4 = R2row.getCell(11);
if (R2cell4 != null) {
R2cell4.setCellValue(BRF56.getR4_nos1() == null ? 0 :
BRF56.getR4_nos1().intValue());
 }	

Cell R2cell5 = R2row.getCell(12);
if (R2cell5 != null) {
R2cell5.setCellValue(BRF56.getR4_amount1() == null ? 0 :
BRF56.getR4_amount1().intValue());
 }	

Cell R2cell6 = R2row.getCell(13);
if (R2cell6 != null) {
R2cell6.setCellValue(BRF56.getR4_nos2() == null ? 0 :
BRF56.getR4_nos2().intValue());
 }	

Cell R2cell7 = R2row.getCell(14);
if (R2cell7 != null) {
R2cell7.setCellValue(BRF56.getR4_amount2() == null ? 0 :
BRF56.getR4_amount2().intValue());
 }

Cell R2cell8 = R2row.getCell(15);
if (R2cell8 != null) {
R2cell8.setCellValue(BRF56.getR4_nos3() == null ? 0 :
BRF56.getR4_nos3().intValue());
 }	

Cell R2cell9 = R2row.getCell(16);
if (R2cell9 != null) {
R2cell9.setCellValue(BRF56.getR4_amount3() == null ? 0 :
BRF56.getR4_amount3().intValue());
 }

Cell R2cell10 = R2row.getCell(17);
if (R2cell10 != null) {
R2cell10.setCellValue(BRF56.getR4_nos4() == null ? 0 :
BRF56.getR4_nos4().intValue());
 }	

Cell R2cell11 = R2row.getCell(18);
if (R2cell11 != null) {
R2cell11.setCellValue(BRF56.getR4_amount4() == null ? 0 :
BRF56.getR4_amount4().intValue());
 }

Cell R2cell12 = R2row.getCell(19);
if (R2cell12 != null) {
R2cell12.setCellValue(BRF56.getR4_nos5() == null ? 0 :
BRF56.getR4_nos5().intValue());
 }	

Cell R2cell13 = R2row.getCell(20);
if (R2cell13 != null) {
R2cell13.setCellValue(BRF56.getR4_amount5() == null ? 0 :
BRF56.getR4_amount5().intValue());
 }

Cell R2cell14 = R2row.getCell(21);
if (R2cell14 != null) {
R2cell14.setCellValue(BRF56.getR4_nos6() == null ? 0 :
BRF56.getR4_nos6().intValue());
 }	

Cell R2cell15 = R2row.getCell(22);
if (R2cell15 != null) {
R2cell15.setCellValue(BRF56.getR4_amount6() == null ? 0 :
BRF56.getR4_amount6().intValue());
 }

Cell R2cell16 = R2row.getCell(23);
if (R2cell16 != null) {
R2cell16.setCellValue(BRF56.getR4_nos7() == null ? 0 :
BRF56.getR4_nos7().intValue());
 }	

Cell R2cell17 = R2row.getCell(24);
if (R2cell17 != null) {
R2cell17.setCellValue(BRF56.getR4_amount7() == null ? 0 :
BRF56.getR4_amount7().intValue());
 }

Cell R2cell18 = R2row.getCell(25);
if (R2cell18 != null) {
R2cell18.setCellValue(BRF56.getR4_nos8() == null ? 0 :
BRF56.getR4_nos8().intValue());
 }	

Cell R2cell19 = R2row.getCell(26);
if (R2cell19 != null) {
R2cell19.setCellValue(BRF56.getR4_amount8() == null ? 0 :
BRF56.getR4_amount8().intValue());
 }

Cell R2cell20 = R2row.getCell(27);
if (R2cell20 != null) {
R2cell20.setCellValue(BRF56.getR4_nos9() == null ? 0 :
BRF56.getR4_nos9().intValue());
 }	

Cell R2cell21 = R2row.getCell(28);
if (R2cell21 != null) {
R2cell21.setCellValue(BRF56.getR4_amount9() == null ? 0 :
BRF56.getR4_amount9().intValue());
 }

Cell R2cell22 = R2row.getCell(29);
if (R2cell22 != null) {
R2cell22.setCellValue(BRF56.getR4_nos10() == null ? 0 :
BRF56.getR4_nos10().intValue());
 }	

Cell R2cell23 = R2row.getCell(30);
if (R2cell23 != null) {
R2cell23.setCellValue(BRF56.getR4_amount10() == null ? 0 :
BRF56.getR4_amount10().intValue());
 }

Cell R2cell24 = R2row.getCell(31);
if (R2cell24 != null) {
R2cell24.setCellValue(BRF56.getR4_nos11() == null ? 0 :
BRF56.getR4_nos11().intValue());
 }	

Cell R2cell25 = R2row.getCell(32);
if (R2cell25 != null) {
R2cell25.setCellValue(BRF56.getR4_amount11() == null ? 0 :
BRF56.getR4_amount11().intValue());
 }

Cell R2cell26 = R2row.getCell(33);
if (R2cell26 != null) {
R2cell26.setCellValue(BRF56.getR4_nos12() == null ? 0 :
BRF56.getR4_nos12().intValue());
 }	

Cell R2cell27 = R2row.getCell(34);
if (R2cell27 != null) {
R2cell27.setCellValue(BRF56.getR4_amount12() == null ? 0 :
BRF56.getR4_amount12().intValue());
 }

Cell R2cell28 = R2row.getCell(35);
if (R2cell28 != null) {
R2cell28.setCellValue(BRF56.getR4_nos13() == null ? 0 :
BRF56.getR4_nos13().intValue());
 }	

Cell R2cell29 = R2row.getCell(36);
if (R2cell29 != null) {
R2cell29.setCellValue(BRF56.getR4_amount13() == null ? 0 :
BRF56.getR4_amount13().intValue());
 }

Cell R2cell30 = R2row.getCell(37);
if (R2cell30 != null) {
R2cell30.setCellValue(BRF56.getR4_nos14() == null ? 0 :
BRF56.getR4_nos14().intValue());
 }	

Cell R2cell31 = R2row.getCell(38);
if (R2cell31 != null) {
R2cell31.setCellValue(BRF56.getR4_amount14() == null ? 0 :
BRF56.getR4_amount14().intValue());
 }

				 
/////////////////////R7/////////////////////////

Row R3row = sheet.getRow(15);

Cell R3cell3 = R3row.getCell(6);
if (R3cell3 != null) {
R3cell3.setCellValue(BRF56.getR7_entities() == null ? 0 :
BRF56.getR7_entities().intValue());
}				 

Cell R3cell4 = R3row.getCell(11);
if (R3cell4 != null) {
R3cell4.setCellValue(BRF56.getR7_nos1() == null ? 0 :
BRF56.getR7_nos1().intValue());
}	

Cell R3cell5 = R3row.getCell(12);
if (R3cell5 != null) {
R3cell5.setCellValue(BRF56.getR7_amount1() == null ? 0 :
BRF56.getR7_amount1().intValue());
}	

Cell R3cell6 = R3row.getCell(13);
if (R3cell6 != null) {
R3cell6.setCellValue(BRF56.getR7_nos2() == null ? 0 :
BRF56.getR7_nos2().intValue());
}	

Cell R3cell7 = R3row.getCell(14);
if (R3cell7 != null) {
R3cell7.setCellValue(BRF56.getR7_amount2() == null ? 0 :
BRF56.getR7_amount2().intValue());
}

Cell R3cell8 = R3row.getCell(15);
if (R3cell8 != null) {
R3cell8.setCellValue(BRF56.getR7_nos3() == null ? 0 :
BRF56.getR7_nos3().intValue());
}	

Cell R3cell9 = R3row.getCell(16);
if (R3cell9 != null) {
R3cell9.setCellValue(BRF56.getR7_amount3() == null ? 0 :
BRF56.getR7_amount3().intValue());
}

Cell R3cell10 = R3row.getCell(17);
if (R3cell10 != null) {
R3cell10.setCellValue(BRF56.getR7_nos4() == null ? 0 :
BRF56.getR7_nos4().intValue());
}	

Cell R3cell11 = R3row.getCell(18);
if (R3cell11 != null) {
R3cell11.setCellValue(BRF56.getR7_amount4() == null ? 0 :
BRF56.getR7_amount4().intValue());
}

Cell R3cell12 = R3row.getCell(19);
if (R3cell12 != null) {
R3cell12.setCellValue(BRF56.getR7_nos5() == null ? 0 :
BRF56.getR7_nos5().intValue());
}	

Cell R3cell13 = R3row.getCell(20);
if (R3cell13 != null) {
R3cell13.setCellValue(BRF56.getR7_amount5() == null ? 0 :
BRF56.getR7_amount5().intValue());
}

Cell R3cell14 = R3row.getCell(21);
if (R3cell14 != null) {
R3cell14.setCellValue(BRF56.getR7_nos6() == null ? 0 :
BRF56.getR7_nos6().intValue());
}	

Cell R3cell15 = R3row.getCell(22);
if (R3cell15 != null) {
R3cell15.setCellValue(BRF56.getR7_amount6() == null ? 0 :
BRF56.getR7_amount6().intValue());
}

Cell R3cell16 = R3row.getCell(23);
if (R3cell16 != null) {
R3cell16.setCellValue(BRF56.getR7_nos7() == null ? 0 :
BRF56.getR7_nos7().intValue());
}	

Cell R3cell17 = R3row.getCell(24);
if (R3cell17 != null) {
R3cell17.setCellValue(BRF56.getR7_amount7() == null ? 0 :
BRF56.getR7_amount7().intValue());
}

Cell R3cell18 = R3row.getCell(25);
if (R3cell18 != null) {
R3cell18.setCellValue(BRF56.getR7_nos8() == null ? 0 :
BRF56.getR7_nos8().intValue());
}	

Cell R3cell19 = R3row.getCell(26);
if (R3cell19 != null) {
R3cell19.setCellValue(BRF56.getR7_amount8() == null ? 0 :
BRF56.getR7_amount8().intValue());
}

Cell R3cell20 = R3row.getCell(27);
if (R3cell20 != null) {
R3cell20.setCellValue(BRF56.getR7_nos9() == null ? 0 :
BRF56.getR7_nos9().intValue());
}	

Cell R3cell21 = R3row.getCell(28);
if (R3cell21 != null) {
R3cell21.setCellValue(BRF56.getR7_amount9() == null ? 0 :
BRF56.getR7_amount9().intValue());
}

Cell R3cell22 = R3row.getCell(29);
if (R3cell22 != null) {
R3cell22.setCellValue(BRF56.getR7_nos10() == null ? 0 :
BRF56.getR7_nos10().intValue());
}	

Cell R3cell23 = R3row.getCell(30);
if (R3cell23 != null) {
R3cell23.setCellValue(BRF56.getR7_amount10() == null ? 0 :
BRF56.getR7_amount10().intValue());
}

Cell R3cell24 = R3row.getCell(31);
if (R3cell24 != null) {
R3cell24.setCellValue(BRF56.getR7_nos11() == null ? 0 :
BRF56.getR7_nos11().intValue());
}	

Cell R3cell25 = R3row.getCell(32);
if (R3cell25 != null) {
R3cell25.setCellValue(BRF56.getR7_amount11() == null ? 0 :
BRF56.getR7_amount11().intValue());
}

Cell R3cell26 = R3row.getCell(33);
if (R3cell26 != null) {
R3cell26.setCellValue(BRF56.getR7_nos12() == null ? 0 :
BRF56.getR7_nos12().intValue());
}	

Cell R3cell27 = R3row.getCell(34);
if (R3cell27 != null) {
R3cell27.setCellValue(BRF56.getR7_amount12() == null ? 0 :
BRF56.getR7_amount12().intValue());
}

Cell R3cell28 = R3row.getCell(35);
if (R3cell28 != null) {
R3cell28.setCellValue(BRF56.getR7_nos13() == null ? 0 :
BRF56.getR7_nos13().intValue());
}	

Cell R3cell29 = R3row.getCell(36);
if (R3cell29 != null) {
R3cell29.setCellValue(BRF56.getR7_amount13() == null ? 0 :
BRF56.getR7_amount13().intValue());
}

Cell R3cell30 = R3row.getCell(37);
if (R3cell30 != null) {
R3cell30.setCellValue(BRF56.getR7_nos14() == null ? 0 :
BRF56.getR7_nos14().intValue());
}	

Cell R3cell31 = R3row.getCell(38);
if (R3cell31 != null) {
R3cell31.setCellValue(BRF56.getR7_amount14() == null ? 0 :
BRF56.getR7_amount14().intValue());
}



/////////////////////R8/////////////////////////

Row R4row = sheet.getRow(16);

Cell R4cell3 = R4row.getCell(6);
if (R4cell3 != null) {
R4cell3.setCellValue(BRF56.getR8_entities() == null ? 0 :
BRF56.getR8_entities().intValue());
}				 

Cell R4cell4 = R4row.getCell(11);
if (R4cell4 != null) {
R4cell4.setCellValue(BRF56.getR8_nos1() == null ? 0 :
BRF56.getR8_nos1().intValue());
}	

Cell R4cell5 = R4row.getCell(12);
if (R4cell5 != null) {
R4cell5.setCellValue(BRF56.getR8_amount1() == null ? 0 :
BRF56.getR8_amount1().intValue());
}	

Cell R4cell6 = R4row.getCell(13);
if (R4cell6 != null) {
R4cell6.setCellValue(BRF56.getR8_nos2() == null ? 0 :
BRF56.getR8_nos2().intValue());
}	

Cell R4cell7 = R4row.getCell(14);
if (R4cell7 != null) {
R4cell7.setCellValue(BRF56.getR8_amount2() == null ? 0 :
BRF56.getR8_amount2().intValue());
}

Cell R4cell8 = R4row.getCell(15);
if (R4cell8 != null) {
R4cell8.setCellValue(BRF56.getR8_nos3() == null ? 0 :
BRF56.getR8_nos3().intValue());
}	

Cell R4cell9 = R4row.getCell(16);
if (R4cell9 != null) {
R4cell9.setCellValue(BRF56.getR8_amount3() == null ? 0 :
BRF56.getR8_amount3().intValue());
}

Cell R4cell10 = R4row.getCell(17);
if (R4cell10 != null) {
R4cell10.setCellValue(BRF56.getR8_nos4() == null ? 0 :
BRF56.getR8_nos4().intValue());
}	

Cell R4cell11 = R4row.getCell(18);
if (R4cell11 != null) {
R4cell11.setCellValue(BRF56.getR8_amount4() == null ? 0 :
BRF56.getR8_amount4().intValue());
}

Cell R4cell12 = R4row.getCell(19);
if (R4cell12 != null) {
R4cell12.setCellValue(BRF56.getR8_nos5() == null ? 0 :
BRF56.getR8_nos5().intValue());
}	

Cell R4cell13 = R4row.getCell(20);
if (R4cell13 != null) {
R4cell13.setCellValue(BRF56.getR8_amount5() == null ? 0 :
BRF56.getR8_amount5().intValue());
}

Cell R4cell14 = R4row.getCell(21);
if (R4cell14 != null) {
R4cell14.setCellValue(BRF56.getR8_nos6() == null ? 0 :
BRF56.getR8_nos6().intValue());
}	

Cell R4cell15 = R4row.getCell(22);
if (R4cell15 != null) {
R4cell15.setCellValue(BRF56.getR8_amount6() == null ? 0 :
BRF56.getR8_amount6().intValue());
}

Cell R4cell16 = R4row.getCell(23);
if (R4cell16 != null) {
R4cell16.setCellValue(BRF56.getR8_nos7() == null ? 0 :
BRF56.getR8_nos7().intValue());
}	

Cell R4cell17 = R4row.getCell(24);
if (R4cell17 != null) {
R4cell17.setCellValue(BRF56.getR8_amount7() == null ? 0 :
BRF56.getR8_amount7().intValue());
}

Cell R4cell18 = R4row.getCell(25);
if (R4cell18 != null) {
R4cell18.setCellValue(BRF56.getR8_nos8() == null ? 0 :
BRF56.getR8_nos8().intValue());
}	

Cell R4cell19 = R4row.getCell(26);
if (R4cell19 != null) {
R4cell19.setCellValue(BRF56.getR8_amount8() == null ? 0 :
BRF56.getR8_amount8().intValue());
}

Cell R4cell20 = R4row.getCell(27);
if (R4cell20 != null) {
R4cell20.setCellValue(BRF56.getR8_nos9() == null ? 0 :
BRF56.getR8_nos9().intValue());
}	

Cell R4cell21 = R4row.getCell(28);
if (R4cell21 != null) {
R4cell21.setCellValue(BRF56.getR8_amount9() == null ? 0 :
BRF56.getR8_amount9().intValue());
}

Cell R4cell22 = R4row.getCell(29);
if (R4cell22 != null) {
R4cell22.setCellValue(BRF56.getR8_nos10() == null ? 0 :
BRF56.getR8_nos10().intValue());
}	

Cell R4cell23 = R4row.getCell(30);
if (R4cell23 != null) {
R4cell23.setCellValue(BRF56.getR8_amount10() == null ? 0 :
BRF56.getR8_amount10().intValue());
}

Cell R4cell24 = R4row.getCell(31);
if (R4cell24 != null) {
R4cell24.setCellValue(BRF56.getR8_nos11() == null ? 0 :
BRF56.getR8_nos11().intValue());
}	

Cell R4cell25 = R4row.getCell(32);
if (R4cell25 != null) {
R4cell25.setCellValue(BRF56.getR8_amount11() == null ? 0 :
BRF56.getR8_amount11().intValue());
}

Cell R4cell26 = R4row.getCell(33);
if (R4cell26 != null) {
R4cell26.setCellValue(BRF56.getR8_nos12() == null ? 0 :
BRF56.getR8_nos12().intValue());
}	

Cell R4cell27 = R4row.getCell(34);
if (R4cell27 != null) {
R4cell27.setCellValue(BRF56.getR8_amount12() == null ? 0 :
BRF56.getR8_amount12().intValue());
}

Cell R4cell28 = R4row.getCell(35);
if (R4cell28 != null) {
R4cell28.setCellValue(BRF56.getR8_nos13() == null ? 0 :
BRF56.getR8_nos13().intValue());
}	

Cell R4cell29 = R4row.getCell(36);
if (R4cell29 != null) {
R4cell29.setCellValue(BRF56.getR8_amount13() == null ? 0 :
BRF56.getR8_amount13().intValue());
}

Cell R4cell30 = R4row.getCell(37);
if (R4cell30 != null) {
R4cell30.setCellValue(BRF56.getR8_nos14() == null ? 0 :
BRF56.getR8_nos14().intValue());
}	

Cell R4cell31 = R4row.getCell(38);
if (R4cell31 != null) {
R4cell31.setCellValue(BRF56.getR8_amount14() == null ? 0 :
BRF56.getR8_amount14().intValue());
}

/////////////////////R10/////////////////////////

Row R5row = sheet.getRow(18);

Cell R5cell3 = R5row.getCell(6);
if (R5cell3 != null) {
R5cell3.setCellValue(BRF56.getR10_entities() == null ? 0 :
BRF56.getR10_entities().intValue());
}				 

Cell R5cell4 = R5row.getCell(11);
if (R5cell4 != null) {
R5cell4.setCellValue(BRF56.getR10_nos1() == null ? 0 :
BRF56.getR10_nos1().intValue());
}	

Cell R5cell5 = R5row.getCell(12);
if (R5cell5 != null) {
R5cell5.setCellValue(BRF56.getR10_amount1() == null ? 0 :
BRF56.getR10_amount1().intValue());
}	

Cell R5cell6 = R5row.getCell(13);
if (R5cell6 != null) {
R5cell6.setCellValue(BRF56.getR10_nos2() == null ? 0 :
BRF56.getR10_nos2().intValue());
}	

Cell R5cell7 = R5row.getCell(14);
if (R5cell7 != null) {
R5cell7.setCellValue(BRF56.getR10_amount2() == null ? 0 :
BRF56.getR10_amount2().intValue());
}

Cell R5cell8 = R5row.getCell(15);
if (R5cell8 != null) {
R5cell8.setCellValue(BRF56.getR10_nos3() == null ? 0 :
BRF56.getR10_nos3().intValue());
}	

Cell R5cell9 = R5row.getCell(16);
if (R5cell9 != null) {
R5cell9.setCellValue(BRF56.getR10_amount3() == null ? 0 :
BRF56.getR10_amount3().intValue());
}

Cell R5cell10 = R5row.getCell(17);
if (R5cell10 != null) {
R5cell10.setCellValue(BRF56.getR10_nos4() == null ? 0 :
BRF56.getR10_nos4().intValue());
}	

Cell R5cell11 = R5row.getCell(18);
if (R5cell11 != null) {
R5cell11.setCellValue(BRF56.getR10_amount4() == null ? 0 :
BRF56.getR10_amount4().intValue());
}

Cell R5cell12 = R5row.getCell(19);
if (R5cell12 != null) {
R5cell12.setCellValue(BRF56.getR10_nos5() == null ? 0 :
BRF56.getR10_nos5().intValue());
}	

Cell R5cell13 = R5row.getCell(20);
if (R5cell13 != null) {
R5cell13.setCellValue(BRF56.getR10_amount5() == null ? 0 :
BRF56.getR10_amount5().intValue());
}

Cell R5cell14 = R5row.getCell(21);
if (R5cell14 != null) {
R5cell14.setCellValue(BRF56.getR10_nos6() == null ? 0 :
BRF56.getR10_nos6().intValue());
}	

Cell R5cell15 = R5row.getCell(22);
if (R5cell15 != null) {
R5cell15.setCellValue(BRF56.getR10_amount6() == null ? 0 :
BRF56.getR10_amount6().intValue());
}

Cell R5cell16 = R5row.getCell(23);
if (R5cell16 != null) {
R5cell16.setCellValue(BRF56.getR10_nos7() == null ? 0 :
BRF56.getR10_nos7().intValue());
}	

Cell R5cell17 = R5row.getCell(24);
if (R5cell17 != null) {
R5cell17.setCellValue(BRF56.getR10_amount7() == null ? 0 :
BRF56.getR10_amount7().intValue());
}

Cell R5cell18 = R5row.getCell(25);
if (R5cell18 != null) {
R5cell18.setCellValue(BRF56.getR10_nos8() == null ? 0 :
BRF56.getR10_nos8().intValue());
}	

Cell R5cell19 = R5row.getCell(26);
if (R5cell19 != null) {
R5cell19.setCellValue(BRF56.getR10_amount8() == null ? 0 :
BRF56.getR10_amount8().intValue());
}

Cell R5cell20 = R5row.getCell(27);
if (R5cell20 != null) {
R5cell20.setCellValue(BRF56.getR10_nos9() == null ? 0 :
BRF56.getR10_nos9().intValue());
}	

Cell R5cell21 = R5row.getCell(28);
if (R5cell21 != null) {
R5cell21.setCellValue(BRF56.getR10_amount9() == null ? 0 :
BRF56.getR10_amount9().intValue());
}

Cell R5cell22 = R5row.getCell(29);
if (R5cell22 != null) {
R5cell22.setCellValue(BRF56.getR10_nos10() == null ? 0 :
BRF56.getR10_nos10().intValue());
}	

Cell R5cell23 = R5row.getCell(30);
if (R5cell23 != null) {
R5cell23.setCellValue(BRF56.getR10_amount10() == null ? 0 :
BRF56.getR10_amount10().intValue());
}

Cell R5cell24 = R5row.getCell(31);
if (R5cell24 != null) {
R5cell24.setCellValue(BRF56.getR10_nos11() == null ? 0 :
BRF56.getR10_nos11().intValue());
}	

Cell R5cell25 = R5row.getCell(32);
if (R5cell25 != null) {
R5cell25.setCellValue(BRF56.getR10_amount11() == null ? 0 :
BRF56.getR10_amount11().intValue());
}

Cell R5cell26 = R5row.getCell(33);
if (R5cell26 != null) {
R5cell26.setCellValue(BRF56.getR10_nos12() == null ? 0 :
BRF56.getR10_nos12().intValue());
}	

Cell R5cell27 = R5row.getCell(34);
if (R5cell27 != null) {
R5cell27.setCellValue(BRF56.getR10_amount12() == null ? 0 :
BRF56.getR10_amount12().intValue());
}

Cell R5cell28 = R5row.getCell(35);
if (R5cell28 != null) {
R5cell28.setCellValue(BRF56.getR10_nos13() == null ? 0 :
BRF56.getR10_nos13().intValue());
}	

Cell R5cell29 = R5row.getCell(36);
if (R5cell29 != null) {
R5cell29.setCellValue(BRF56.getR10_amount13() == null ? 0 :
BRF56.getR10_amount13().intValue());
}

Cell R5cell30 = R5row.getCell(37);
if (R5cell30 != null) {
R5cell30.setCellValue(BRF56.getR10_nos14() == null ? 0 :
BRF56.getR10_nos14().intValue());
}	

Cell R5cell31 = R5row.getCell(38);
if (R5cell31 != null) {
R5cell31.setCellValue(BRF56.getR10_amount14() == null ? 0 :
BRF56.getR10_amount14().intValue());
}


/////////////////////R11/////////////////////////

Row R6row = sheet.getRow(19);

Cell R6cell3 = R6row.getCell(6);
if (R6cell3 != null) {
R6cell3.setCellValue(BRF56.getR11_entities() == null ? 0 :
BRF56.getR11_entities().intValue());
}				 

Cell R6cell4 = R6row.getCell(11);
if (R6cell4 != null) {
R6cell4.setCellValue(BRF56.getR11_nos1() == null ? 0 :
BRF56.getR11_nos1().intValue());
}	

Cell R6cell5 = R6row.getCell(12);
if (R6cell5 != null) {
R6cell5.setCellValue(BRF56.getR11_amount1() == null ? 0 :
BRF56.getR11_amount1().intValue());
}	

Cell R6cell6 = R6row.getCell(13);
if (R6cell6 != null) {
R6cell6.setCellValue(BRF56.getR11_nos2() == null ? 0 :
BRF56.getR11_nos2().intValue());
}	

Cell R6cell7 = R6row.getCell(14);
if (R6cell7 != null) {
R6cell7.setCellValue(BRF56.getR11_amount2() == null ? 0 :
BRF56.getR11_amount2().intValue());
}

Cell R6cell8 = R6row.getCell(15);
if (R6cell8 != null) {
R6cell8.setCellValue(BRF56.getR11_nos3() == null ? 0 :
BRF56.getR11_nos3().intValue());
}	

Cell R6cell9 = R6row.getCell(16);
if (R6cell9 != null) {
R6cell9.setCellValue(BRF56.getR11_amount3() == null ? 0 :
BRF56.getR11_amount3().intValue());
}

Cell R6cell10 = R6row.getCell(17);
if (R6cell10 != null) {
R6cell10.setCellValue(BRF56.getR11_nos4() == null ? 0 :
BRF56.getR11_nos4().intValue());
}	

Cell R6cell11 = R6row.getCell(18);
if (R6cell11 != null) {
R6cell11.setCellValue(BRF56.getR11_amount4() == null ? 0 :
BRF56.getR11_amount4().intValue());
}

Cell R6cell12 = R6row.getCell(19);
if (R6cell12 != null) {
R6cell12.setCellValue(BRF56.getR11_nos5() == null ? 0 :
BRF56.getR11_nos5().intValue());
}	

Cell R6cell13 = R6row.getCell(20);
if (R6cell13 != null) {
R6cell13.setCellValue(BRF56.getR11_amount5() == null ? 0 :
BRF56.getR11_amount5().intValue());
}

Cell R6cell14 = R6row.getCell(21);
if (R6cell14 != null) {
R6cell14.setCellValue(BRF56.getR11_nos6() == null ? 0 :
BRF56.getR11_nos6().intValue());
}	

Cell R6cell15 = R6row.getCell(22);
if (R6cell15 != null) {
R6cell15.setCellValue(BRF56.getR11_amount6() == null ? 0 :
BRF56.getR11_amount6().intValue());
}

Cell R6cell16 = R6row.getCell(23);
if (R6cell16 != null) {
R6cell16.setCellValue(BRF56.getR11_nos7() == null ? 0 :
BRF56.getR11_nos7().intValue());
}	

Cell R6cell17 = R6row.getCell(24);
if (R6cell17 != null) {
R6cell17.setCellValue(BRF56.getR11_amount7() == null ? 0 :
BRF56.getR11_amount7().intValue());
}

Cell R6cell18 = R6row.getCell(25);
if (R6cell18 != null) {
R6cell18.setCellValue(BRF56.getR11_nos8() == null ? 0 :
BRF56.getR11_nos8().intValue());
}	

Cell R6cell19 = R6row.getCell(26);
if (R6cell19 != null) {
R6cell19.setCellValue(BRF56.getR11_amount8() == null ? 0 :
BRF56.getR11_amount8().intValue());
}

Cell R6cell20 = R6row.getCell(27);
if (R6cell20 != null) {
R6cell20.setCellValue(BRF56.getR11_nos9() == null ? 0 :
BRF56.getR11_nos9().intValue());
}	

Cell R6cell21 = R6row.getCell(28);
if (R6cell21 != null) {
R6cell21.setCellValue(BRF56.getR11_amount9() == null ? 0 :
BRF56.getR11_amount9().intValue());
}

Cell R6cell22 = R6row.getCell(29);
if (R6cell22 != null) {
R6cell22.setCellValue(BRF56.getR11_nos10() == null ? 0 :
BRF56.getR11_nos10().intValue());
}	

Cell R6cell23 = R6row.getCell(30);
if (R6cell23 != null) {
R6cell23.setCellValue(BRF56.getR11_amount10() == null ? 0 :
BRF56.getR11_amount10().intValue());
}

Cell R6cell24 = R6row.getCell(31);
if (R6cell24 != null) {
R6cell24.setCellValue(BRF56.getR11_nos11() == null ? 0 :
BRF56.getR11_nos11().intValue());
}	

Cell R6cell25 = R6row.getCell(32);
if (R6cell25 != null) {
R6cell25.setCellValue(BRF56.getR11_amount11() == null ? 0 :
BRF56.getR11_amount11().intValue());
}

Cell R6cell26 = R6row.getCell(33);
if (R6cell26 != null) {
R6cell26.setCellValue(BRF56.getR11_nos12() == null ? 0 :
BRF56.getR11_nos12().intValue());
}	

Cell R6cell27 = R6row.getCell(34);
if (R6cell27 != null) {
R6cell27.setCellValue(BRF56.getR11_amount12() == null ? 0 :
BRF56.getR11_amount12().intValue());
}

Cell R6cell28 = R6row.getCell(35);
if (R6cell28 != null) {
R6cell28.setCellValue(BRF56.getR11_nos13() == null ? 0 :
BRF56.getR11_nos13().intValue());
}	

Cell R6cell29 = R6row.getCell(36);
if (R6cell29 != null) {
R6cell29.setCellValue(BRF56.getR11_amount13() == null ? 0 :
BRF56.getR11_amount13().intValue());
}

Cell R6cell30 = R6row.getCell(37);
if (R6cell30 != null) {
R6cell30.setCellValue(BRF56.getR11_nos14() == null ? 0 :
BRF56.getR11_nos14().intValue());
}	

Cell R6cell31 = R6row.getCell(38);
if (R6cell31 != null) {
R6cell31.setCellValue(BRF56.getR11_amount14() == null ? 0 :
BRF56.getR11_amount14().intValue());
}


/////////////////////R14/////////////////////////

Row R7row = sheet.getRow(22);

Cell R7cell3 = R7row.getCell(6);
if (R7cell3 != null) {
R7cell3.setCellValue(BRF56.getR14_entities() == null ? 0 :
BRF56.getR14_entities().intValue());
}				 

Cell R7cell4 = R7row.getCell(11);
if (R7cell4 != null) {
R7cell4.setCellValue(BRF56.getR14_nos1() == null ? 0 :
BRF56.getR14_nos1().intValue());
}	

Cell R7cell5 = R7row.getCell(12);
if (R7cell5 != null) {
R7cell5.setCellValue(BRF56.getR14_amount1() == null ? 0 :
BRF56.getR14_amount1().intValue());
}	

Cell R7cell6 = R7row.getCell(13);
if (R7cell6 != null) {
R7cell6.setCellValue(BRF56.getR14_nos2() == null ? 0 :
BRF56.getR14_nos2().intValue());
}	

Cell R7cell7 = R7row.getCell(14);
if (R7cell7 != null) {
R7cell7.setCellValue(BRF56.getR14_amount2() == null ? 0 :
BRF56.getR14_amount2().intValue());
}

Cell R7cell8 = R7row.getCell(15);
if (R7cell8 != null) {
R7cell8.setCellValue(BRF56.getR14_nos3() == null ? 0 :
BRF56.getR14_nos3().intValue());
}	

Cell R7cell9 = R7row.getCell(16);
if (R7cell9 != null) {
R7cell9.setCellValue(BRF56.getR14_amount3() == null ? 0 :
BRF56.getR14_amount3().intValue());
}

Cell R7cell10 = R7row.getCell(17);
if (R7cell10 != null) {
R7cell10.setCellValue(BRF56.getR14_nos4() == null ? 0 :
BRF56.getR14_nos4().intValue());
}	

Cell R7cell11 = R7row.getCell(18);
if (R7cell11 != null) {
R7cell11.setCellValue(BRF56.getR14_amount4() == null ? 0 :
BRF56.getR14_amount4().intValue());
}

Cell R7cell12 = R7row.getCell(19);
if (R7cell12 != null) {
R7cell12.setCellValue(BRF56.getR14_nos5() == null ? 0 :
BRF56.getR14_nos5().intValue());
}	

Cell R7cell13 = R7row.getCell(20);
if (R7cell13 != null) {
R7cell13.setCellValue(BRF56.getR14_amount5() == null ? 0 :
BRF56.getR14_amount5().intValue());
}

Cell R7cell14 = R7row.getCell(21);
if (R7cell14 != null) {
R7cell14.setCellValue(BRF56.getR14_nos6() == null ? 0 :
BRF56.getR14_nos6().intValue());
}	

Cell R7cell15 = R7row.getCell(22);
if (R7cell15 != null) {
R7cell15.setCellValue(BRF56.getR14_amount6() == null ? 0 :
BRF56.getR14_amount6().intValue());
}

Cell R7cell16 = R7row.getCell(23);
if (R7cell16 != null) {
R7cell16.setCellValue(BRF56.getR14_nos7() == null ? 0 :
BRF56.getR14_nos7().intValue());
}	

Cell R7cell17 = R7row.getCell(24);
if (R7cell17 != null) {
R7cell17.setCellValue(BRF56.getR14_amount7() == null ? 0 :
BRF56.getR14_amount7().intValue());
}

Cell R7cell18 = R7row.getCell(25);
if (R7cell18 != null) {
R7cell18.setCellValue(BRF56.getR14_nos8() == null ? 0 :
BRF56.getR14_nos8().intValue());
}	

Cell R7cell19 = R7row.getCell(26);
if (R7cell19 != null) {
R7cell19.setCellValue(BRF56.getR14_amount8() == null ? 0 :
BRF56.getR14_amount8().intValue());
}

Cell R7cell20 = R7row.getCell(27);
if (R7cell20 != null) {
R7cell20.setCellValue(BRF56.getR14_nos9() == null ? 0 :
BRF56.getR14_nos9().intValue());
}	

Cell R7cell21 = R7row.getCell(28);
if (R7cell21 != null) {
R7cell21.setCellValue(BRF56.getR14_amount9() == null ? 0 :
BRF56.getR14_amount9().intValue());
}

Cell R7cell22 = R7row.getCell(29);
if (R7cell22 != null) {
R7cell22.setCellValue(BRF56.getR14_nos10() == null ? 0 :
BRF56.getR14_nos10().intValue());
}	

Cell R7cell23 = R7row.getCell(30);
if (R7cell23 != null) {
R7cell23.setCellValue(BRF56.getR14_amount10() == null ? 0 :
BRF56.getR14_amount10().intValue());
}

Cell R7cell24 = R7row.getCell(31);
if (R7cell24 != null) {
R7cell24.setCellValue(BRF56.getR14_nos11() == null ? 0 :
BRF56.getR14_nos11().intValue());
}	

Cell R7cell25 = R7row.getCell(32);
if (R7cell25 != null) {
R7cell25.setCellValue(BRF56.getR14_amount11() == null ? 0 :
BRF56.getR14_amount11().intValue());
}

Cell R7cell26 = R7row.getCell(33);
if (R7cell26 != null) {
R7cell26.setCellValue(BRF56.getR14_nos12() == null ? 0 :
BRF56.getR14_nos12().intValue());
}	

Cell R7cell27 = R7row.getCell(34);
if (R7cell27 != null) {
R7cell27.setCellValue(BRF56.getR14_amount12() == null ? 0 :
BRF56.getR14_amount12().intValue());
}

Cell R7cell28 = R7row.getCell(35);
if (R7cell28 != null) {
R7cell28.setCellValue(BRF56.getR14_nos13() == null ? 0 :
BRF56.getR14_nos13().intValue());
}	

Cell R7cell29 = R7row.getCell(36);
if (R7cell29 != null) {
R7cell29.setCellValue(BRF56.getR14_amount13() == null ? 0 :
BRF56.getR14_amount13().intValue());
}

Cell R7cell30 = R7row.getCell(37);
if (R7cell30 != null) {
R7cell30.setCellValue(BRF56.getR14_nos14() == null ? 0 :
BRF56.getR14_nos14().intValue());
}	

Cell R7cell31 = R7row.getCell(38);
if (R7cell31 != null) {
R7cell31.setCellValue(BRF56.getR14_amount14() == null ? 0 :
BRF56.getR14_amount14().intValue());
}


/////////////////////R15/////////////////////////

Row R8row = sheet.getRow(23);

Cell R8cell3 = R8row.getCell(6);
if (R8cell3 != null) {
R8cell3.setCellValue(BRF56.getR15_entities() == null ? 0 :
BRF56.getR15_entities().intValue());
}				 

Cell R8cell4 = R8row.getCell(11);
if (R8cell4 != null) {
R8cell4.setCellValue(BRF56.getR15_nos1() == null ? 0 :
BRF56.getR15_nos1().intValue());
}	

Cell R8cell5 = R8row.getCell(12);
if (R8cell5 != null) {
R8cell5.setCellValue(BRF56.getR15_amount1() == null ? 0 :
BRF56.getR15_amount1().intValue());
}	

Cell R8cell6 = R8row.getCell(13);
if (R8cell6 != null) {
R8cell6.setCellValue(BRF56.getR15_nos2() == null ? 0 :
BRF56.getR15_nos2().intValue());
}	

Cell R8cell7 = R8row.getCell(14);
if (R8cell7 != null) {
R8cell7.setCellValue(BRF56.getR15_amount2() == null ? 0 :
BRF56.getR15_amount2().intValue());
}

Cell R8cell8 = R8row.getCell(15);
if (R8cell8 != null) {
R8cell8.setCellValue(BRF56.getR15_nos3() == null ? 0 :
BRF56.getR15_nos3().intValue());
}	

Cell R8cell9 = R8row.getCell(16);
if (R8cell9 != null) {
R8cell9.setCellValue(BRF56.getR15_amount3() == null ? 0 :
BRF56.getR15_amount3().intValue());
}

Cell R8cell10 = R8row.getCell(17);
if (R8cell10 != null) {
R8cell10.setCellValue(BRF56.getR15_nos4() == null ? 0 :
BRF56.getR15_nos4().intValue());
}	

Cell R8cell11 = R8row.getCell(18);
if (R8cell11 != null) {
R8cell11.setCellValue(BRF56.getR15_amount4() == null ? 0 :
BRF56.getR15_amount4().intValue());
}

Cell R8cell12 = R8row.getCell(19);
if (R8cell12 != null) {
R8cell12.setCellValue(BRF56.getR15_nos5() == null ? 0 :
BRF56.getR15_nos5().intValue());
}	

Cell R8cell13 = R8row.getCell(20);
if (R8cell13 != null) {
R8cell13.setCellValue(BRF56.getR15_amount5() == null ? 0 :
BRF56.getR15_amount5().intValue());
}

Cell R8cell14 = R8row.getCell(21);
if (R8cell14 != null) {
R8cell14.setCellValue(BRF56.getR15_nos6() == null ? 0 :
BRF56.getR15_nos6().intValue());
}	

Cell R8cell15 = R8row.getCell(22);
if (R8cell15 != null) {
R8cell15.setCellValue(BRF56.getR15_amount6() == null ? 0 :
BRF56.getR15_amount6().intValue());
}

Cell R8cell16 = R8row.getCell(23);
if (R8cell16 != null) {
R8cell16.setCellValue(BRF56.getR15_nos7() == null ? 0 :
BRF56.getR15_nos7().intValue());
}	

Cell R8cell17 = R8row.getCell(24);
if (R8cell17 != null) {
R8cell17.setCellValue(BRF56.getR15_amount7() == null ? 0 :
BRF56.getR15_amount7().intValue());
}

Cell R8cell18 = R8row.getCell(25);
if (R8cell18 != null) {
R8cell18.setCellValue(BRF56.getR15_nos8() == null ? 0 :
BRF56.getR15_nos8().intValue());
}	

Cell R8cell19 = R8row.getCell(26);
if (R8cell19 != null) {
R8cell19.setCellValue(BRF56.getR15_amount8() == null ? 0 :
BRF56.getR15_amount8().intValue());
}

Cell R8cell20 = R8row.getCell(27);
if (R8cell20 != null) {
R8cell20.setCellValue(BRF56.getR15_nos9() == null ? 0 :
BRF56.getR15_nos9().intValue());
}	

Cell R8cell21 = R8row.getCell(28);
if (R8cell21 != null) {
R8cell21.setCellValue(BRF56.getR15_amount9() == null ? 0 :
BRF56.getR15_amount9().intValue());
}

Cell R8cell22 = R8row.getCell(29);
if (R8cell22 != null) {
R8cell22.setCellValue(BRF56.getR15_nos10() == null ? 0 :
BRF56.getR15_nos10().intValue());
}	

Cell R8cell23 = R8row.getCell(30);
if (R8cell23 != null) {
R8cell23.setCellValue(BRF56.getR15_amount10() == null ? 0 :
BRF56.getR15_amount10().intValue());
}

Cell R8cell24 = R8row.getCell(31);
if (R8cell24 != null) {
R8cell24.setCellValue(BRF56.getR15_nos11() == null ? 0 :
BRF56.getR15_nos11().intValue());
}	

Cell R8cell25 = R8row.getCell(32);
if (R8cell25 != null) {
R8cell25.setCellValue(BRF56.getR15_amount11() == null ? 0 :
BRF56.getR15_amount11().intValue());
}

Cell R8cell26 = R8row.getCell(33);
if (R8cell26 != null) {
R8cell26.setCellValue(BRF56.getR15_nos12() == null ? 0 :
BRF56.getR15_nos12().intValue());
}	

Cell R8cell27 = R8row.getCell(34);
if (R8cell27 != null) {
R8cell27.setCellValue(BRF56.getR15_amount12() == null ? 0 :
BRF56.getR15_amount12().intValue());
}

Cell R8cell28 = R8row.getCell(35);
if (R8cell28 != null) {
R8cell28.setCellValue(BRF56.getR15_nos13() == null ? 0 :
BRF56.getR15_nos13().intValue());
}	

Cell R8cell29 = R8row.getCell(36);
if (R8cell29 != null) {
R8cell29.setCellValue(BRF56.getR15_amount13() == null ? 0 :
BRF56.getR15_amount13().intValue());
}

Cell R8cell30 = R8row.getCell(37);
if (R8cell30 != null) {
R8cell30.setCellValue(BRF56.getR15_nos14() == null ? 0 :
BRF56.getR15_nos14().intValue());
}	

Cell R8cell31 = R8row.getCell(38);
if (R8cell31 != null) {
R8cell31.setCellValue(BRF56.getR15_amount14() == null ? 0 :
BRF56.getR15_amount14().intValue());
}


/////////////////////R16/////////////////////////

Row R9row = sheet.getRow(24);

Cell R9cell3 = R9row.getCell(6);
if (R9cell3 != null) {
R9cell3.setCellValue(BRF56.getR16_entities() == null ? 0 :
BRF56.getR16_entities().intValue());
}				 

Cell R9cell4 = R9row.getCell(11);
if (R9cell4 != null) {
R9cell4.setCellValue(BRF56.getR16_nos1() == null ? 0 :
BRF56.getR16_nos1().intValue());
}	

Cell R9cell5 = R9row.getCell(12);
if (R9cell5 != null) {
R9cell5.setCellValue(BRF56.getR16_amount1() == null ? 0 :
BRF56.getR16_amount1().intValue());
}	

Cell R9cell6 = R9row.getCell(13);
if (R9cell6 != null) {
R9cell6.setCellValue(BRF56.getR16_nos2() == null ? 0 :
BRF56.getR16_nos2().intValue());
}	

Cell R9cell7 = R9row.getCell(14);
if (R9cell7 != null) {
R9cell7.setCellValue(BRF56.getR16_amount2() == null ? 0 :
BRF56.getR16_amount2().intValue());
}

Cell R9cell8 = R9row.getCell(15);
if (R9cell8 != null) {
R9cell8.setCellValue(BRF56.getR16_nos3() == null ? 0 :
BRF56.getR16_nos3().intValue());
}	

Cell R9cell9 = R9row.getCell(16);
if (R9cell9 != null) {
R9cell9.setCellValue(BRF56.getR16_amount3() == null ? 0 :
BRF56.getR16_amount3().intValue());
}

Cell R9cell10 = R9row.getCell(17);
if (R9cell10 != null) {
R9cell10.setCellValue(BRF56.getR16_nos4() == null ? 0 :
BRF56.getR16_nos4().intValue());
}	

Cell R9cell11 = R9row.getCell(18);
if (R9cell11 != null) {
R9cell11.setCellValue(BRF56.getR16_amount4() == null ? 0 :
BRF56.getR16_amount4().intValue());
}

Cell R9cell12 = R9row.getCell(19);
if (R9cell12 != null) {
R9cell12.setCellValue(BRF56.getR16_nos5() == null ? 0 :
BRF56.getR16_nos5().intValue());
}	

Cell R9cell13 = R9row.getCell(20);
if (R9cell13 != null) {
R9cell13.setCellValue(BRF56.getR16_amount5() == null ? 0 :
BRF56.getR16_amount5().intValue());
}

Cell R9cell14 = R9row.getCell(21);
if (R9cell14 != null) {
R9cell14.setCellValue(BRF56.getR16_nos6() == null ? 0 :
BRF56.getR16_nos6().intValue());
}	

Cell R9cell15 = R9row.getCell(22);
if (R9cell15 != null) {
R9cell15.setCellValue(BRF56.getR16_amount6() == null ? 0 :
BRF56.getR16_amount6().intValue());
}

Cell R9cell16 = R9row.getCell(23);
if (R9cell16 != null) {
R9cell16.setCellValue(BRF56.getR16_nos7() == null ? 0 :
BRF56.getR16_nos7().intValue());
}	

Cell R9cell17 = R9row.getCell(24);
if (R9cell17 != null) {
R9cell17.setCellValue(BRF56.getR16_amount7() == null ? 0 :
BRF56.getR16_amount7().intValue());
}

Cell R9cell18 = R9row.getCell(25);
if (R9cell18 != null) {
R9cell18.setCellValue(BRF56.getR16_nos8() == null ? 0 :
BRF56.getR16_nos8().intValue());
}	

Cell R9cell19 = R9row.getCell(26);
if (R9cell19 != null) {
R9cell19.setCellValue(BRF56.getR16_amount8() == null ? 0 :
BRF56.getR16_amount8().intValue());
}

Cell R9cell20 = R9row.getCell(27);
if (R9cell20 != null) {
R9cell20.setCellValue(BRF56.getR16_nos9() == null ? 0 :
BRF56.getR16_nos9().intValue());
}	

Cell R9cell21 = R9row.getCell(28);
if (R9cell21 != null) {
R9cell21.setCellValue(BRF56.getR16_amount9() == null ? 0 :
BRF56.getR16_amount9().intValue());
}

Cell R9cell22 = R9row.getCell(29);
if (R9cell22 != null) {
R9cell22.setCellValue(BRF56.getR16_nos10() == null ? 0 :
BRF56.getR16_nos10().intValue());
}	

Cell R9cell23 = R9row.getCell(30);
if (R9cell23 != null) {
R9cell23.setCellValue(BRF56.getR16_amount10() == null ? 0 :
BRF56.getR16_amount10().intValue());
}

Cell R9cell24 = R9row.getCell(31);
if (R9cell24 != null) {
R9cell24.setCellValue(BRF56.getR16_nos11() == null ? 0 :
BRF56.getR16_nos11().intValue());
}	

Cell R9cell25 = R9row.getCell(32);
if (R9cell25 != null) {
R9cell25.setCellValue(BRF56.getR16_amount11() == null ? 0 :
BRF56.getR16_amount11().intValue());
}

Cell R9cell26 = R9row.getCell(33);
if (R9cell26 != null) {
R9cell26.setCellValue(BRF56.getR16_nos12() == null ? 0 :
BRF56.getR16_nos12().intValue());
}	

Cell R9cell27 = R9row.getCell(34);
if (R9cell27 != null) {
R9cell27.setCellValue(BRF56.getR16_amount12() == null ? 0 :
BRF56.getR16_amount12().intValue());
}

Cell R9cell28 = R9row.getCell(35);
if (R9cell28 != null) {
R9cell28.setCellValue(BRF56.getR16_nos13() == null ? 0 :
BRF56.getR16_nos13().intValue());
}	

Cell R9cell29 = R9row.getCell(36);
if (R9cell29 != null) {
R9cell29.setCellValue(BRF56.getR16_amount13() == null ? 0 :
BRF56.getR16_amount13().intValue());
}

Cell R9cell30 = R9row.getCell(37);
if (R9cell30 != null) {
R9cell30.setCellValue(BRF56.getR16_nos14() == null ? 0 :
BRF56.getR16_nos14().intValue());
}	

Cell R9cell31 = R9row.getCell(38);
if (R9cell31 != null) {
R9cell31.setCellValue(BRF56.getR16_amount14() == null ? 0 :
BRF56.getR16_amount14().intValue());
}


/////////////////////R17/////////////////////////

Row R10row = sheet.getRow(25);

Cell R10cell3 = R10row.getCell(6);
if (R10cell3 != null) {
R10cell3.setCellValue(BRF56.getR17_entities() == null ? 0 :
BRF56.getR17_entities().intValue());
}				 

Cell R10cell4 = R10row.getCell(11);
if (R10cell4 != null) {
R10cell4.setCellValue(BRF56.getR17_nos1() == null ? 0 :
BRF56.getR17_nos1().intValue());
}	

Cell R10cell5 = R10row.getCell(12);
if (R10cell5 != null) {
R10cell5.setCellValue(BRF56.getR17_amount1() == null ? 0 :
BRF56.getR17_amount1().intValue());
}	

Cell R10cell6 = R10row.getCell(13);
if (R10cell6 != null) {
R10cell6.setCellValue(BRF56.getR17_nos2() == null ? 0 :
BRF56.getR17_nos2().intValue());
}	

Cell R10cell7 = R10row.getCell(14);
if (R10cell7 != null) {
R10cell7.setCellValue(BRF56.getR17_amount2() == null ? 0 :
BRF56.getR17_amount2().intValue());
}

Cell R10cell8 = R10row.getCell(15);
if (R10cell8 != null) {
R10cell8.setCellValue(BRF56.getR17_nos3() == null ? 0 :
BRF56.getR17_nos3().intValue());
}	

Cell R10cell9 = R10row.getCell(16);
if (R10cell9 != null) {
R10cell9.setCellValue(BRF56.getR17_amount3() == null ? 0 :
BRF56.getR17_amount3().intValue());
}

Cell R10cell10 = R10row.getCell(17);
if (R10cell10 != null) {
R10cell10.setCellValue(BRF56.getR17_nos4() == null ? 0 :
BRF56.getR17_nos4().intValue());
}	

Cell R10cell11 = R10row.getCell(18);
if (R10cell11 != null) {
R10cell11.setCellValue(BRF56.getR17_amount4() == null ? 0 :
BRF56.getR17_amount4().intValue());
}

Cell R10cell12 = R10row.getCell(19);
if (R10cell12 != null) {
R10cell12.setCellValue(BRF56.getR17_nos5() == null ? 0 :
BRF56.getR17_nos5().intValue());
}	

Cell R10cell13 = R10row.getCell(20);
if (R10cell13 != null) {
R10cell13.setCellValue(BRF56.getR17_amount5() == null ? 0 :
BRF56.getR17_amount5().intValue());
}

Cell R10cell14 = R10row.getCell(21);
if (R10cell14 != null) {
R10cell14.setCellValue(BRF56.getR17_nos6() == null ? 0 :
BRF56.getR17_nos6().intValue());
}	

Cell R10cell15 = R10row.getCell(22);
if (R10cell15 != null) {
R10cell15.setCellValue(BRF56.getR17_amount6() == null ? 0 :
BRF56.getR17_amount6().intValue());
}

Cell R10cell16 = R10row.getCell(23);
if (R10cell16 != null) {
R10cell16.setCellValue(BRF56.getR17_nos7() == null ? 0 :
BRF56.getR17_nos7().intValue());
}	

Cell R10cell17 = R10row.getCell(24);
if (R10cell17 != null) {
R10cell17.setCellValue(BRF56.getR17_amount7() == null ? 0 :
BRF56.getR17_amount7().intValue());
}

Cell R10cell18 = R10row.getCell(25);
if (R10cell18 != null) {
R10cell18.setCellValue(BRF56.getR17_nos8() == null ? 0 :
BRF56.getR17_nos8().intValue());
}	

Cell R10cell19 = R10row.getCell(26);
if (R10cell19 != null) {
R10cell19.setCellValue(BRF56.getR17_amount8() == null ? 0 :
BRF56.getR17_amount8().intValue());
}

Cell R10cell20 = R10row.getCell(27);
if (R10cell20 != null) {
R10cell20.setCellValue(BRF56.getR17_nos9() == null ? 0 :
BRF56.getR17_nos9().intValue());
}	

Cell R10cell21 = R10row.getCell(28);
if (R10cell21 != null) {
R10cell21.setCellValue(BRF56.getR17_amount9() == null ? 0 :
BRF56.getR17_amount9().intValue());
}

Cell R10cell22 = R10row.getCell(29);
if (R10cell22 != null) {
R10cell22.setCellValue(BRF56.getR17_nos10() == null ? 0 :
BRF56.getR17_nos10().intValue());
}	

Cell R10cell23 = R10row.getCell(30);
if (R10cell23 != null) {
R10cell23.setCellValue(BRF56.getR17_amount10() == null ? 0 :
BRF56.getR17_amount10().intValue());
}

Cell R10cell24 = R10row.getCell(31);
if (R10cell24 != null) {
R10cell24.setCellValue(BRF56.getR17_nos11() == null ? 0 :
BRF56.getR17_nos11().intValue());
}	

Cell R10cell25 = R10row.getCell(32);
if (R10cell25 != null) {
R10cell25.setCellValue(BRF56.getR17_amount11() == null ? 0 :
BRF56.getR17_amount11().intValue());
}

Cell R10cell26 = R10row.getCell(33);
if (R10cell26 != null) {
R10cell26.setCellValue(BRF56.getR17_nos12() == null ? 0 :
BRF56.getR17_nos12().intValue());
}	

Cell R10cell27 = R10row.getCell(34);
if (R10cell27 != null) {
R10cell27.setCellValue(BRF56.getR17_amount12() == null ? 0 :
BRF56.getR17_amount12().intValue());
}

Cell R10cell28 = R10row.getCell(35);
if (R10cell28 != null) {
R10cell28.setCellValue(BRF56.getR17_nos13() == null ? 0 :
BRF56.getR17_nos13().intValue());
}	

Cell R10cell29 = R10row.getCell(36);
if (R10cell29 != null) {
R10cell29.setCellValue(BRF56.getR17_amount13() == null ? 0 :
BRF56.getR17_amount13().intValue());
}

Cell R10cell30 = R10row.getCell(37);
if (R10cell30 != null) {
R10cell30.setCellValue(BRF56.getR17_nos14() == null ? 0 :
BRF56.getR17_nos14().intValue());
}	

Cell R10cell31 = R10row.getCell(38);
if (R10cell31 != null) {
R10cell31.setCellValue(BRF56.getR17_amount14() == null ? 0 :
BRF56.getR17_amount14().intValue());
}


/////////////////////R18/////////////////////////

Row R11row = sheet.getRow(26);

Cell R11cell3 = R11row.getCell(6);
if (R11cell3 != null) {
R11cell3.setCellValue(BRF56.getR18_entities() == null ? 0 :
BRF56.getR18_entities().intValue());
}				 

Cell R11cell4 = R11row.getCell(11);
if (R11cell4 != null) {
R11cell4.setCellValue(BRF56.getR18_nos1() == null ? 0 :
BRF56.getR18_nos1().intValue());
}	

Cell R11cell5 = R11row.getCell(12);
if (R11cell5 != null) {
R11cell5.setCellValue(BRF56.getR18_amount1() == null ? 0 :
BRF56.getR18_amount1().intValue());
}	

Cell R11cell6 = R11row.getCell(13);
if (R11cell6 != null) {
R11cell6.setCellValue(BRF56.getR18_nos2() == null ? 0 :
BRF56.getR18_nos2().intValue());
}	

Cell R11cell7 = R11row.getCell(14);
if (R11cell7 != null) {
R11cell7.setCellValue(BRF56.getR18_amount2() == null ? 0 :
BRF56.getR18_amount2().intValue());
}

Cell R11cell8 = R11row.getCell(15);
if (R11cell8 != null) {
R11cell8.setCellValue(BRF56.getR18_nos3() == null ? 0 :
BRF56.getR18_nos3().intValue());
}	

Cell R11cell9 = R11row.getCell(16);
if (R11cell9 != null) {
R11cell9.setCellValue(BRF56.getR18_amount3() == null ? 0 :
BRF56.getR18_amount3().intValue());
}

Cell R11cell10 = R11row.getCell(17);
if (R11cell10 != null) {
R11cell10.setCellValue(BRF56.getR18_nos4() == null ? 0 :
BRF56.getR18_nos4().intValue());
}	

Cell R11cell11 = R11row.getCell(18);
if (R11cell11 != null) {
R11cell11.setCellValue(BRF56.getR18_amount4() == null ? 0 :
BRF56.getR18_amount4().intValue());
}

Cell R11cell12 = R11row.getCell(19);
if (R11cell12 != null) {
R11cell12.setCellValue(BRF56.getR18_nos5() == null ? 0 :
BRF56.getR18_nos5().intValue());
}	

Cell R11cell13 = R11row.getCell(20);
if (R11cell13 != null) {
R11cell13.setCellValue(BRF56.getR18_amount5() == null ? 0 :
BRF56.getR18_amount5().intValue());
}

Cell R11cell14 = R11row.getCell(21);
if (R11cell14 != null) {
R11cell14.setCellValue(BRF56.getR18_nos6() == null ? 0 :
BRF56.getR18_nos6().intValue());
}	

Cell R11cell15 = R11row.getCell(22);
if (R11cell15 != null) {
R11cell15.setCellValue(BRF56.getR18_amount6() == null ? 0 :
BRF56.getR18_amount6().intValue());
}

Cell R11cell16 = R11row.getCell(23);
if (R11cell16 != null) {
R11cell16.setCellValue(BRF56.getR18_nos7() == null ? 0 :
BRF56.getR18_nos7().intValue());
}	

Cell R11cell17 = R11row.getCell(24);
if (R11cell17 != null) {
R11cell17.setCellValue(BRF56.getR18_amount7() == null ? 0 :
BRF56.getR18_amount7().intValue());
}

Cell R11cell18 = R11row.getCell(25);
if (R11cell18 != null) {
R11cell18.setCellValue(BRF56.getR18_nos8() == null ? 0 :
BRF56.getR18_nos8().intValue());
}	

Cell R11cell19 = R11row.getCell(26);
if (R11cell19 != null) {
R11cell19.setCellValue(BRF56.getR18_amount8() == null ? 0 :
BRF56.getR18_amount8().intValue());
}

Cell R11cell20 = R11row.getCell(27);
if (R11cell20 != null) {
R11cell20.setCellValue(BRF56.getR18_nos9() == null ? 0 :
BRF56.getR18_nos9().intValue());
}	

Cell R11cell21 = R11row.getCell(28);
if (R11cell21 != null) {
R11cell21.setCellValue(BRF56.getR18_amount9() == null ? 0 :
BRF56.getR18_amount9().intValue());
}

Cell R11cell22 = R11row.getCell(29);
if (R11cell22 != null) {
R11cell22.setCellValue(BRF56.getR18_nos10() == null ? 0 :
BRF56.getR18_nos10().intValue());
}	

Cell R11cell23 = R11row.getCell(30);
if (R11cell23 != null) {
R11cell23.setCellValue(BRF56.getR18_amount10() == null ? 0 :
BRF56.getR18_amount10().intValue());
}

Cell R11cell24 = R11row.getCell(31);
if (R11cell24 != null) {
R11cell24.setCellValue(BRF56.getR18_nos11() == null ? 0 :
BRF56.getR18_nos11().intValue());
}	

Cell R11cell25 = R11row.getCell(32);
if (R11cell25 != null) {
R11cell25.setCellValue(BRF56.getR18_amount11() == null ? 0 :
BRF56.getR18_amount11().intValue());
}

Cell R11cell26 = R11row.getCell(33);
if (R11cell26 != null) {
R11cell26.setCellValue(BRF56.getR18_nos12() == null ? 0 :
BRF56.getR18_nos12().intValue());
}	

Cell R11cell27 = R11row.getCell(34);
if (R11cell27 != null) {
R11cell27.setCellValue(BRF56.getR18_amount12() == null ? 0 :
BRF56.getR18_amount12().intValue());
}

Cell R11cell28 = R11row.getCell(35);
if (R11cell28 != null) {
R11cell28.setCellValue(BRF56.getR18_nos13() == null ? 0 :
BRF56.getR18_nos13().intValue());
}	

Cell R11cell29 = R11row.getCell(36);
if (R11cell29 != null) {
R11cell29.setCellValue(BRF56.getR18_amount13() == null ? 0 :
BRF56.getR18_amount13().intValue());
}

Cell R11cell30 = R11row.getCell(37);
if (R11cell30 != null) {
R11cell30.setCellValue(BRF56.getR18_nos14() == null ? 0 :
BRF56.getR18_nos14().intValue());
}	

Cell R11cell31 = R11row.getCell(38);
if (R11cell31 != null) {
R11cell31.setCellValue(BRF56.getR18_amount14() == null ? 0 :
BRF56.getR18_amount14().intValue());
}


/////////////////////R20/////////////////////////

Row R12row = sheet.getRow(28);

Cell R12cell3 = R12row.getCell(6);
if (R12cell3 != null) {
R12cell3.setCellValue(BRF56.getR20_entities() == null ? 0 :
BRF56.getR20_entities().intValue());
}				 

Cell R12cell4 = R12row.getCell(11);
if (R12cell4 != null) {
R12cell4.setCellValue(BRF56.getR20_nos1() == null ? 0 :
BRF56.getR20_nos1().intValue());
}	

Cell R12cell5 = R12row.getCell(12);
if (R12cell5 != null) {
R12cell5.setCellValue(BRF56.getR20_amount1() == null ? 0 :
BRF56.getR20_amount1().intValue());
}	

Cell R12cell6 = R12row.getCell(13);
if (R12cell6 != null) {
R12cell6.setCellValue(BRF56.getR20_nos2() == null ? 0 :
BRF56.getR20_nos2().intValue());
}	

Cell R12cell7 = R12row.getCell(14);
if (R12cell7 != null) {
R12cell7.setCellValue(BRF56.getR20_amount2() == null ? 0 :
BRF56.getR20_amount2().intValue());
}

Cell R12cell8 = R12row.getCell(15);
if (R12cell8 != null) {
R12cell8.setCellValue(BRF56.getR20_nos3() == null ? 0 :
BRF56.getR20_nos3().intValue());
}	

Cell R12cell9 = R12row.getCell(16);
if (R12cell9 != null) {
R12cell9.setCellValue(BRF56.getR20_amount3() == null ? 0 :
BRF56.getR20_amount3().intValue());
}

Cell R12cell10 = R12row.getCell(17);
if (R12cell10 != null) {
R12cell10.setCellValue(BRF56.getR20_nos4() == null ? 0 :
BRF56.getR20_nos4().intValue());
}	

Cell R12cell11 = R12row.getCell(18);
if (R12cell11 != null) {
R12cell11.setCellValue(BRF56.getR20_amount4() == null ? 0 :
BRF56.getR20_amount4().intValue());
}

Cell R12cell12 = R12row.getCell(19);
if (R12cell12 != null) {
R12cell12.setCellValue(BRF56.getR20_nos5() == null ? 0 :
BRF56.getR20_nos5().intValue());
}	

Cell R12cell13 = R12row.getCell(20);
if (R12cell13 != null) {
R12cell13.setCellValue(BRF56.getR20_amount5() == null ? 0 :
BRF56.getR20_amount5().intValue());
}

Cell R12cell14 = R12row.getCell(21);
if (R12cell14 != null) {
R12cell14.setCellValue(BRF56.getR20_nos6() == null ? 0 :
BRF56.getR20_nos6().intValue());
}	

Cell R12cell15 = R12row.getCell(22);
if (R12cell15 != null) {
R12cell15.setCellValue(BRF56.getR20_amount6() == null ? 0 :
BRF56.getR20_amount6().intValue());
}

Cell R12cell16 = R12row.getCell(23);
if (R12cell16 != null) {
R12cell16.setCellValue(BRF56.getR20_nos7() == null ? 0 :
BRF56.getR20_nos7().intValue());
}	

Cell R12cell17 = R12row.getCell(24);
if (R12cell17 != null) {
R12cell17.setCellValue(BRF56.getR20_amount7() == null ? 0 :
BRF56.getR20_amount7().intValue());
}

Cell R12cell18 = R12row.getCell(25);
if (R12cell18 != null) {
R12cell18.setCellValue(BRF56.getR20_nos8() == null ? 0 :
BRF56.getR20_nos8().intValue());
}	

Cell R12cell19 = R12row.getCell(26);
if (R12cell19 != null) {
R12cell19.setCellValue(BRF56.getR20_amount8() == null ? 0 :
BRF56.getR20_amount8().intValue());
}

Cell R12cell20 = R12row.getCell(27);
if (R12cell20 != null) {
R12cell20.setCellValue(BRF56.getR20_nos9() == null ? 0 :
BRF56.getR20_nos9().intValue());
}	

Cell R12cell21 = R12row.getCell(28);
if (R12cell21 != null) {
R12cell21.setCellValue(BRF56.getR20_amount9() == null ? 0 :
BRF56.getR20_amount9().intValue());
}

Cell R12cell22 = R12row.getCell(29);
if (R12cell22 != null) {
R12cell22.setCellValue(BRF56.getR20_nos10() == null ? 0 :
BRF56.getR20_nos10().intValue());
}	

Cell R12cell23 = R12row.getCell(30);
if (R12cell23 != null) {
R12cell23.setCellValue(BRF56.getR20_amount10() == null ? 0 :
BRF56.getR20_amount10().intValue());
}

Cell R12cell24 = R12row.getCell(31);
if (R12cell24 != null) {
R12cell24.setCellValue(BRF56.getR20_nos11() == null ? 0 :
BRF56.getR20_nos11().intValue());
}	

Cell R12cell25 = R12row.getCell(32);
if (R12cell25 != null) {
R12cell25.setCellValue(BRF56.getR20_amount11() == null ? 0 :
BRF56.getR20_amount11().intValue());
}

Cell R12cell26 = R12row.getCell(33);
if (R12cell26 != null) {
R12cell26.setCellValue(BRF56.getR20_nos12() == null ? 0 :
BRF56.getR20_nos12().intValue());
}	

Cell R12cell27 = R12row.getCell(34);
if (R12cell27 != null) {
R12cell27.setCellValue(BRF56.getR20_amount12() == null ? 0 :
BRF56.getR20_amount12().intValue());
}

Cell R12cell28 = R12row.getCell(35);
if (R12cell28 != null) {
R12cell28.setCellValue(BRF56.getR20_nos13() == null ? 0 :
BRF56.getR20_nos13().intValue());
}	

Cell R12cell29 = R12row.getCell(36);
if (R12cell29 != null) {
R12cell29.setCellValue(BRF56.getR20_amount13() == null ? 0 :
BRF56.getR20_amount13().intValue());
}

Cell R12cell30 = R12row.getCell(37);
if (R12cell30 != null) {
R12cell30.setCellValue(BRF56.getR20_nos14() == null ? 0 :
BRF56.getR20_nos14().intValue());
}	

Cell R12cell31 = R12row.getCell(38);
if (R12cell31 != null) {
R12cell31.setCellValue(BRF56.getR20_amount14() == null ? 0 :
BRF56.getR20_amount14().intValue());
}


/////////////////////R21/////////////////////////

Row R13row = sheet.getRow(29);

Cell R13cell3 = R13row.getCell(6);
if (R13cell3 != null) {
R13cell3.setCellValue(BRF56.getR21_entities() == null ? 0 :
BRF56.getR21_entities().intValue());
}				 

Cell R13cell4 = R13row.getCell(11);
if (R13cell4 != null) {
R13cell4.setCellValue(BRF56.getR21_nos1() == null ? 0 :
BRF56.getR21_nos1().intValue());
}	

Cell R13cell5 = R13row.getCell(12);
if (R13cell5 != null) {
R13cell5.setCellValue(BRF56.getR21_amount1() == null ? 0 :
BRF56.getR21_amount1().intValue());
}	

Cell R13cell6 = R13row.getCell(13);
if (R13cell6 != null) {
R13cell6.setCellValue(BRF56.getR21_nos2() == null ? 0 :
BRF56.getR21_nos2().intValue());
}	

Cell R13cell7 = R13row.getCell(14);
if (R13cell7 != null) {
R13cell7.setCellValue(BRF56.getR21_amount2() == null ? 0 :
BRF56.getR21_amount2().intValue());
}

Cell R13cell8 = R13row.getCell(15);
if (R13cell8 != null) {
R13cell8.setCellValue(BRF56.getR21_nos3() == null ? 0 :
BRF56.getR21_nos3().intValue());
}	

Cell R13cell9 = R13row.getCell(16);
if (R13cell9 != null) {
R13cell9.setCellValue(BRF56.getR21_amount3() == null ? 0 :
BRF56.getR21_amount3().intValue());
}

Cell R13cell10 = R13row.getCell(17);
if (R13cell10 != null) {
R13cell10.setCellValue(BRF56.getR21_nos4() == null ? 0 :
BRF56.getR21_nos4().intValue());
}	

Cell R13cell11 = R13row.getCell(18);
if (R13cell11 != null) {
R13cell11.setCellValue(BRF56.getR21_amount4() == null ? 0 :
BRF56.getR21_amount4().intValue());
}

Cell R13cell12 = R13row.getCell(19);
if (R13cell12 != null) {
R13cell12.setCellValue(BRF56.getR21_nos5() == null ? 0 :
BRF56.getR21_nos5().intValue());
}	

Cell R13cell13 = R13row.getCell(20);
if (R13cell13 != null) {
R13cell13.setCellValue(BRF56.getR21_amount5() == null ? 0 :
BRF56.getR21_amount5().intValue());
}

Cell R13cell14 = R13row.getCell(21);
if (R13cell14 != null) {
R13cell14.setCellValue(BRF56.getR21_nos6() == null ? 0 :
BRF56.getR21_nos6().intValue());
}	

Cell R13cell15 = R13row.getCell(22);
if (R13cell15 != null) {
R13cell15.setCellValue(BRF56.getR21_amount6() == null ? 0 :
BRF56.getR21_amount6().intValue());
}

Cell R13cell16 = R13row.getCell(23);
if (R13cell16 != null) {
R13cell16.setCellValue(BRF56.getR21_nos7() == null ? 0 :
BRF56.getR21_nos7().intValue());
}	

Cell R13cell17 = R13row.getCell(24);
if (R13cell17 != null) {
R13cell17.setCellValue(BRF56.getR21_amount7() == null ? 0 :
BRF56.getR21_amount7().intValue());
}

Cell R13cell18 = R13row.getCell(25);
if (R13cell18 != null) {
R13cell18.setCellValue(BRF56.getR21_nos8() == null ? 0 :
BRF56.getR21_nos8().intValue());
}	

Cell R13cell19 = R13row.getCell(26);
if (R13cell19 != null) {
R13cell19.setCellValue(BRF56.getR21_amount8() == null ? 0 :
BRF56.getR21_amount8().intValue());
}

Cell R13cell20 = R13row.getCell(27);
if (R13cell20 != null) {
R13cell20.setCellValue(BRF56.getR21_nos9() == null ? 0 :
BRF56.getR21_nos9().intValue());
}	

Cell R13cell21 = R13row.getCell(28);
if (R13cell21 != null) {
R13cell21.setCellValue(BRF56.getR21_amount9() == null ? 0 :
BRF56.getR21_amount9().intValue());
}

Cell R13cell22 = R13row.getCell(29);
if (R13cell22 != null) {
R13cell22.setCellValue(BRF56.getR21_nos10() == null ? 0 :
BRF56.getR21_nos10().intValue());
}	

Cell R13cell23 = R13row.getCell(30);
if (R13cell23 != null) {
R13cell23.setCellValue(BRF56.getR21_amount10() == null ? 0 :
BRF56.getR21_amount10().intValue());
}

Cell R13cell24 = R13row.getCell(31);
if (R13cell24 != null) {
R13cell24.setCellValue(BRF56.getR21_nos11() == null ? 0 :
BRF56.getR21_nos11().intValue());
}	

Cell R13cell25 = R13row.getCell(32);
if (R13cell25 != null) {
R13cell25.setCellValue(BRF56.getR21_amount11() == null ? 0 :
BRF56.getR21_amount11().intValue());
}

Cell R13cell26 = R13row.getCell(33);
if (R13cell26 != null) {
R13cell26.setCellValue(BRF56.getR21_nos12() == null ? 0 :
BRF56.getR21_nos12().intValue());
}	

Cell R13cell27 = R13row.getCell(34);
if (R13cell27 != null) {
R13cell27.setCellValue(BRF56.getR21_amount12() == null ? 0 :
BRF56.getR21_amount12().intValue());
}

Cell R13cell28 = R13row.getCell(35);
if (R13cell28 != null) {
R13cell28.setCellValue(BRF56.getR21_nos13() == null ? 0 :
BRF56.getR21_nos13().intValue());
}	

Cell R13cell29 = R13row.getCell(36);
if (R13cell29 != null) {
R13cell29.setCellValue(BRF56.getR21_amount13() == null ? 0 :
BRF56.getR21_amount13().intValue());
}

Cell R13cell30 = R13row.getCell(37);
if (R13cell30 != null) {
R13cell30.setCellValue(BRF56.getR21_nos14() == null ? 0 :
BRF56.getR21_nos14().intValue());
}	

Cell R13cell31 = R13row.getCell(38);
if (R13cell31 != null) {
R13cell31.setCellValue(BRF56.getR21_amount14() == null ? 0 :
BRF56.getR21_amount14().intValue());
}

					}
				}
				if (T1Master1.size() == 1) {
					for (BRF56_ENTITY2 BRF56a : T1Master1) {
						
					    /////////////////////R22/////////////////////////
						
						 Row R14row = sheet.getRow(30);
						 
						 Cell R14cell1 = R14row.getCell(4);
						 if (R14cell1 != null) {
						 R14cell1.setCellValue(BRF56a.getR22_male() == null ? 0 :
						 BRF56a.getR22_male().intValue());
						       	 }				 
								
						 Cell R14cell2 = R14row.getCell(5);
						 if (R14cell2 != null) {
						 R14cell2.setCellValue(BRF56a.getR22_female() == null ? 0 :
						 BRF56a.getR22_female().intValue());
						       	 }	
								
						 Cell R14cell4 = R14row.getCell(11);
						 if (R14cell4 != null) {
						 R14cell4.setCellValue(BRF56a.getR22_nos1() == null ? 0 :
						 BRF56a.getR22_nos1().intValue());
						       	 }	
						 
						 Cell R14cell5 = R14row.getCell(12);
						 if (R14cell5 != null) {
						 R14cell5.setCellValue(BRF56a.getR22_amount1() == null ? 0 :
						 BRF56a.getR22_amount1().intValue());
						       	 }	
							
						 Cell R14cell6 = R14row.getCell(13);
						 if (R14cell6 != null) {
						 R14cell6.setCellValue(BRF56a.getR22_nos2() == null ? 0 :
						 BRF56a.getR22_nos2().intValue());
						       	 }	
						 
						 Cell R14cell7 = R14row.getCell(14);
						 if (R14cell7 != null) {
						 R14cell7.setCellValue(BRF56a.getR22_amount2() == null ? 0 :
						 BRF56a.getR22_amount2().intValue());
						       	 }
						 
						 Cell R14cell8 = R14row.getCell(15);
						 if (R14cell8 != null) {
						 R14cell8.setCellValue(BRF56a.getR22_nos3() == null ? 0 :
						 BRF56a.getR22_nos3().intValue());
						       	 }	
						 
						 Cell R14cell9 = R14row.getCell(16);
						 if (R14cell9 != null) {
						 R14cell9.setCellValue(BRF56a.getR22_amount3() == null ? 0 :
						 BRF56a.getR22_amount3().intValue());
						       	 }
						 
						 Cell R14cell10 = R14row.getCell(17);
						 if (R14cell10 != null) {
						 R14cell10.setCellValue(BRF56a.getR22_nos4() == null ? 0 :
						 BRF56a.getR22_nos4().intValue());
						       	 }	
						 
						 Cell R14cell11 = R14row.getCell(18);
						 if (R14cell11 != null) {
						 R14cell11.setCellValue(BRF56a.getR22_amount4() == null ? 0 :
						 BRF56a.getR22_amount4().intValue());
						       	 }
						 
						 Cell R14cell12 = R14row.getCell(19);
						 if (R14cell12 != null) {
						 R14cell12.setCellValue(BRF56a.getR22_nos5() == null ? 0 :
						 BRF56a.getR22_nos5().intValue());
						       	 }	
						 
						 Cell R14cell13 = R14row.getCell(20);
						 if (R14cell13 != null) {
						 R14cell13.setCellValue(BRF56a.getR22_amount5() == null ? 0 :
						 BRF56a.getR22_amount5().intValue());
						       	 }
						 
						 Cell R14cell14 = R14row.getCell(21);
						 if (R14cell14 != null) {
						 R14cell14.setCellValue(BRF56a.getR22_nos6() == null ? 0 :
						 BRF56a.getR22_nos6().intValue());
						       	 }	
						 
						 Cell R14cell15 = R14row.getCell(22);
						 if (R14cell15 != null) {
						 R14cell15.setCellValue(BRF56a.getR22_amount6() == null ? 0 :
						 BRF56a.getR22_amount6().intValue());
						       	 }
						 
						 Cell R14cell16 = R14row.getCell(23);
						 if (R14cell16 != null) {
						 R14cell16.setCellValue(BRF56a.getR22_nos7() == null ? 0 :
						 BRF56a.getR22_nos7().intValue());
						       	 }	
						 
						 Cell R14cell17 = R14row.getCell(24);
						 if (R14cell17 != null) {
						 R14cell17.setCellValue(BRF56a.getR22_amount7() == null ? 0 :
						 BRF56a.getR22_amount7().intValue());
						       	 }
						 
						 Cell R14cell18 = R14row.getCell(25);
						 if (R14cell18 != null) {
						 R14cell18.setCellValue(BRF56a.getR22_nos8() == null ? 0 :
						 BRF56a.getR22_nos8().intValue());
						       	 }	
						 
						 Cell R14cell19 = R14row.getCell(26);
						 if (R14cell19 != null) {
						 R14cell19.setCellValue(BRF56a.getR22_amount8() == null ? 0 :
						 BRF56a.getR22_amount8().intValue());
						       	 }
						 
						 Cell R14cell20 = R14row.getCell(27);
						 if (R14cell20 != null) {
						 R14cell20.setCellValue(BRF56a.getR22_nos9() == null ? 0 :
						 BRF56a.getR22_nos9().intValue());
						       	 }	
						 
						 Cell R14cell21 = R14row.getCell(28);
						 if (R14cell21 != null) {
						 R14cell21.setCellValue(BRF56a.getR22_amount9() == null ? 0 :
						 BRF56a.getR22_amount9().intValue());
						       	 }
						 
						 Cell R14cell22 = R14row.getCell(29);
						 if (R14cell22 != null) {
						 R14cell22.setCellValue(BRF56a.getR22_nos10() == null ? 0 :
						 BRF56a.getR22_nos10().intValue());
						       	 }	
						 
						 Cell R14cell23 = R14row.getCell(30);
						 if (R14cell23 != null) {
						 R14cell23.setCellValue(BRF56a.getR22_amount10() == null ? 0 :
						 BRF56a.getR22_amount10().intValue());
						       	 }
						 
						 Cell R14cell24 = R14row.getCell(31);
						 if (R14cell24 != null) {
						 R14cell24.setCellValue(BRF56a.getR22_nos11() == null ? 0 :
						 BRF56a.getR22_nos11().intValue());
						       	 }	
						 
						 Cell R14cell25 = R14row.getCell(32);
						 if (R14cell25 != null) {
						 R14cell25.setCellValue(BRF56a.getR22_amount11() == null ? 0 :
						 BRF56a.getR22_amount11().intValue());
						       	 }
						 
						 Cell R14cell26 = R14row.getCell(33);
						 if (R14cell26 != null) {
						 R14cell26.setCellValue(BRF56a.getR22_nos12() == null ? 0 :
						 BRF56a.getR22_nos12().intValue());
						       	 }	
						 
						 Cell R14cell27 = R14row.getCell(34);
						 if (R14cell27 != null) {
						 R14cell27.setCellValue(BRF56a.getR22_amount12() == null ? 0 :
						 BRF56a.getR22_amount12().intValue());
						       	 }
						 
						 Cell R14cell28 = R14row.getCell(35);
						 if (R14cell28 != null) {
						 R14cell28.setCellValue(BRF56a.getR22_nos13() == null ? 0 :
						 BRF56a.getR22_nos13().intValue());
						       	 }	
						 
						 Cell R14cell29 = R14row.getCell(36);
						 if (R14cell29 != null) {
						 R14cell29.setCellValue(BRF56a.getR22_amount13() == null ? 0 :
						 BRF56a.getR22_amount13().intValue());
						       	 }
						 
						 Cell R14cell30 = R14row.getCell(37);
						 if (R14cell30 != null) {
						 R14cell30.setCellValue(BRF56a.getR22_nos14() == null ? 0 :
						 BRF56a.getR22_nos14().intValue());
						       	 }	
						 
						 Cell R14cell31 = R14row.getCell(38);
						 if (R14cell31 != null) {
						 R14cell31.setCellValue(BRF56a.getR22_amount14() == null ? 0 :
						 BRF56a.getR22_amount14().intValue());
						       	 }
								 


	/////////////////////R23/////////////////////////
						
						 Row R15row = sheet.getRow(31);
						 
						 Cell R15cell3 = R15row.getCell(6);
						 if (R15cell3 != null) {
						 R15cell3.setCellValue(BRF56a.getR23_entities() == null ? 0 :
						 BRF56a.getR23_entities().intValue());
						       	 }				 
								
						 Cell R15cell4 = R15row.getCell(11);
						 if (R15cell4 != null) {
						 R15cell4.setCellValue(BRF56a.getR23_nos1() == null ? 0 :
						 BRF56a.getR23_nos1().intValue());
						       	 }	
						 
						 Cell R15cell5 = R15row.getCell(12);
						 if (R15cell5 != null) {
						 R15cell5.setCellValue(BRF56a.getR23_amount1() == null ? 0 :
						 BRF56a.getR23_amount1().intValue());
						       	 }	
							
						 Cell R15cell6 = R15row.getCell(13);
						 if (R15cell6 != null) {
						 R15cell6.setCellValue(BRF56a.getR23_nos2() == null ? 0 :
						 BRF56a.getR23_nos2().intValue());
						       	 }	
						 
						 Cell R15cell7 = R15row.getCell(14);
						 if (R15cell7 != null) {
						 R15cell7.setCellValue(BRF56a.getR23_amount2() == null ? 0 :
						 BRF56a.getR23_amount2().intValue());
						       	 }
						 
						 Cell R15cell8 = R15row.getCell(15);
						 if (R15cell8 != null) {
						 R15cell8.setCellValue(BRF56a.getR23_nos3() == null ? 0 :
						 BRF56a.getR23_nos3().intValue());
						       	 }	
						 
						 Cell R15cell9 = R15row.getCell(16);
						 if (R15cell9 != null) {
						 R15cell9.setCellValue(BRF56a.getR23_amount3() == null ? 0 :
						 BRF56a.getR23_amount3().intValue());
						       	 }
						 
						 Cell R15cell10 = R15row.getCell(17);
						 if (R15cell10 != null) {
						 R15cell10.setCellValue(BRF56a.getR23_nos4() == null ? 0 :
						 BRF56a.getR23_nos4().intValue());
						       	 }	
						 
						 Cell R15cell11 = R15row.getCell(18);
						 if (R15cell11 != null) {
						 R15cell11.setCellValue(BRF56a.getR23_amount4() == null ? 0 :
						 BRF56a.getR23_amount4().intValue());
						       	 }
						 
						 Cell R15cell12 = R15row.getCell(19);
						 if (R15cell12 != null) {
						 R15cell12.setCellValue(BRF56a.getR23_nos5() == null ? 0 :
						 BRF56a.getR23_nos5().intValue());
						       	 }	
						 
						 Cell R15cell13 = R15row.getCell(20);
						 if (R15cell13 != null) {
						 R15cell13.setCellValue(BRF56a.getR23_amount5() == null ? 0 :
						 BRF56a.getR23_amount5().intValue());
						       	 }
						 
						 Cell R15cell14 = R15row.getCell(21);
						 if (R15cell14 != null) {
						 R15cell14.setCellValue(BRF56a.getR23_nos6() == null ? 0 :
						 BRF56a.getR23_nos6().intValue());
						       	 }	
						 
						 Cell R15cell15 = R15row.getCell(22);
						 if (R15cell15 != null) {
						 R15cell15.setCellValue(BRF56a.getR23_amount6() == null ? 0 :
						 BRF56a.getR23_amount6().intValue());
						       	 }
						 
						 Cell R15cell16 = R15row.getCell(23);
						 if (R15cell16 != null) {
						 R15cell16.setCellValue(BRF56a.getR23_nos7() == null ? 0 :
						 BRF56a.getR23_nos7().intValue());
						       	 }	
						 
						 Cell R15cell17 = R15row.getCell(24);
						 if (R15cell17 != null) {
						 R15cell17.setCellValue(BRF56a.getR23_amount7() == null ? 0 :
						 BRF56a.getR23_amount7().intValue());
						       	 }
						 
						 Cell R15cell18 = R15row.getCell(25);
						 if (R15cell18 != null) {
						 R15cell18.setCellValue(BRF56a.getR23_nos8() == null ? 0 :
						 BRF56a.getR23_nos8().intValue());
						       	 }	
						 
						 Cell R15cell19 = R15row.getCell(26);
						 if (R15cell19 != null) {
						 R15cell19.setCellValue(BRF56a.getR23_amount8() == null ? 0 :
						 BRF56a.getR23_amount8().intValue());
						       	 }
						 
						 Cell R15cell20 = R15row.getCell(27);
						 if (R15cell20 != null) {
						 R15cell20.setCellValue(BRF56a.getR23_nos9() == null ? 0 :
						 BRF56a.getR23_nos9().intValue());
						       	 }	
						 
						 Cell R15cell21 = R15row.getCell(28);
						 if (R15cell21 != null) {
						 R15cell21.setCellValue(BRF56a.getR23_amount9() == null ? 0 :
						 BRF56a.getR23_amount9().intValue());
						       	 }
						 
						 Cell R15cell22 = R15row.getCell(29);
						 if (R15cell22 != null) {
						 R15cell22.setCellValue(BRF56a.getR23_nos10() == null ? 0 :
						 BRF56a.getR23_nos10().intValue());
						       	 }	
						 
						 Cell R15cell23 = R15row.getCell(30);
						 if (R15cell23 != null) {
						 R15cell23.setCellValue(BRF56a.getR23_amount10() == null ? 0 :
						 BRF56a.getR23_amount10().intValue());
						       	 }
						 
						 Cell R15cell24 = R15row.getCell(31);
						 if (R15cell24 != null) {
						 R15cell24.setCellValue(BRF56a.getR23_nos11() == null ? 0 :
						 BRF56a.getR23_nos11().intValue());
						       	 }	
						 
						 Cell R15cell25 = R15row.getCell(32);
						 if (R15cell25 != null) {
						 R15cell25.setCellValue(BRF56a.getR23_amount11() == null ? 0 :
						 BRF56a.getR23_amount11().intValue());
						       	 }
						 
						 Cell R15cell26 = R15row.getCell(33);
						 if (R15cell26 != null) {
						 R15cell26.setCellValue(BRF56a.getR23_nos12() == null ? 0 :
						 BRF56a.getR23_nos12().intValue());
						       	 }	
						 
						 Cell R15cell27 = R15row.getCell(34);
						 if (R15cell27 != null) {
						 R15cell27.setCellValue(BRF56a.getR23_amount12() == null ? 0 :
						 BRF56a.getR23_amount12().intValue());
						       	 }
						 
						 Cell R15cell28 = R15row.getCell(35);
						 if (R15cell28 != null) {
						 R15cell28.setCellValue(BRF56a.getR23_nos13() == null ? 0 :
						 BRF56a.getR23_nos13().intValue());
						       	 }	
						 
						 Cell R15cell29 = R15row.getCell(36);
						 if (R15cell29 != null) {
						 R15cell29.setCellValue(BRF56a.getR23_amount13() == null ? 0 :
						 BRF56a.getR23_amount13().intValue());
						       	 }
						 
						 Cell R15cell30 = R15row.getCell(37);
						 if (R15cell30 != null) {
						 R15cell30.setCellValue(BRF56a.getR23_nos14() == null ? 0 :
						 BRF56a.getR23_nos14().intValue());
						       	 }	
						 
						 Cell R15cell31 = R15row.getCell(38);
						 if (R15cell31 != null) {
						 R15cell31.setCellValue(BRF56a.getR23_amount14() == null ? 0 :
						 BRF56a.getR23_amount14().intValue());
						       	 }
								 
						
						    /////////////////////R26/////////////////////////
							
						 Row R16row = sheet.getRow(34);
						 
						 Cell R16cell1 = R16row.getCell(4);
						 if (R16cell1 != null) {
						 R16cell1.setCellValue(BRF56a.getR26_male() == null ? 0 :
						 BRF56a.getR26_male().intValue());
						       	 }				 
								
						 Cell R16cell2 = R16row.getCell(5);
						 if (R16cell2 != null) {
						 R16cell2.setCellValue(BRF56a.getR26_female() == null ? 0 :
						 BRF56a.getR26_female().intValue());
						       	 }	
								
						 Cell R16cell4 = R16row.getCell(11);
						 if (R16cell4 != null) {
						 R16cell4.setCellValue(BRF56a.getR26_nos1() == null ? 0 :
						 BRF56a.getR26_nos1().intValue());
						       	 }	
						 
						 Cell R16cell5 = R16row.getCell(12);
						 if (R16cell5 != null) {
						 R16cell5.setCellValue(BRF56a.getR26_amount1() == null ? 0 :
						 BRF56a.getR26_amount1().intValue());
						       	 }	
							
						 Cell R16cell6 = R16row.getCell(13);
						 if (R16cell6 != null) {
						 R16cell6.setCellValue(BRF56a.getR26_nos2() == null ? 0 :
						 BRF56a.getR26_nos2().intValue());
						       	 }	
						 
						 Cell R16cell7 = R16row.getCell(14);
						 if (R16cell7 != null) {
						 R16cell7.setCellValue(BRF56a.getR26_amount2() == null ? 0 :
						 BRF56a.getR26_amount2().intValue());
						       	 }
						 
						 Cell R16cell8 = R16row.getCell(15);
						 if (R16cell8 != null) {
						 R16cell8.setCellValue(BRF56a.getR26_nos3() == null ? 0 :
						 BRF56a.getR26_nos3().intValue());
						       	 }	
						 
						 Cell R16cell9 = R16row.getCell(16);
						 if (R16cell9 != null) {
						 R16cell9.setCellValue(BRF56a.getR26_amount3() == null ? 0 :
						 BRF56a.getR26_amount3().intValue());
						       	 }
						 
						 Cell R16cell10 = R16row.getCell(17);
						 if (R16cell10 != null) {
						 R16cell10.setCellValue(BRF56a.getR26_nos4() == null ? 0 :
						 BRF56a.getR26_nos4().intValue());
						       	 }	
						 
						 Cell R16cell11 = R16row.getCell(18);
						 if (R16cell11 != null) {
						 R16cell11.setCellValue(BRF56a.getR26_amount4() == null ? 0 :
						 BRF56a.getR26_amount4().intValue());
						       	 }
						 
						 Cell R16cell12 = R16row.getCell(19);
						 if (R16cell12 != null) {
						 R16cell12.setCellValue(BRF56a.getR26_nos5() == null ? 0 :
						 BRF56a.getR26_nos5().intValue());
						       	 }	
						 
						 Cell R16cell13 = R16row.getCell(20);
						 if (R16cell13 != null) {
						 R16cell13.setCellValue(BRF56a.getR26_amount5() == null ? 0 :
						 BRF56a.getR26_amount5().intValue());
						       	 }
						 
						 Cell R16cell14 = R16row.getCell(21);
						 if (R16cell14 != null) {
						 R16cell14.setCellValue(BRF56a.getR26_nos6() == null ? 0 :
						 BRF56a.getR26_nos6().intValue());
						       	 }	
						 
						 Cell R16cell15 = R16row.getCell(22);
						 if (R16cell15 != null) {
						 R16cell15.setCellValue(BRF56a.getR26_amount6() == null ? 0 :
						 BRF56a.getR26_amount6().intValue());
						       	 }
						 
						 Cell R16cell16 = R16row.getCell(23);
						 if (R16cell16 != null) {
						 R16cell16.setCellValue(BRF56a.getR26_nos7() == null ? 0 :
						 BRF56a.getR26_nos7().intValue());
						       	 }	
						 
						 Cell R16cell17 = R16row.getCell(24);
						 if (R16cell17 != null) {
						 R16cell17.setCellValue(BRF56a.getR26_amount7() == null ? 0 :
						 BRF56a.getR26_amount7().intValue());
						       	 }
						 
						 Cell R16cell18 = R16row.getCell(25);
						 if (R16cell18 != null) {
						 R16cell18.setCellValue(BRF56a.getR26_nos8() == null ? 0 :
						 BRF56a.getR26_nos8().intValue());
						       	 }	
						 
						 Cell R16cell19 = R16row.getCell(26);
						 if (R16cell19 != null) {
						 R16cell19.setCellValue(BRF56a.getR26_amount8() == null ? 0 :
						 BRF56a.getR26_amount8().intValue());
						       	 }
						 
						 Cell R16cell20 = R16row.getCell(27);
						 if (R16cell20 != null) {
						 R16cell20.setCellValue(BRF56a.getR26_nos9() == null ? 0 :
						 BRF56a.getR26_nos9().intValue());
						       	 }	
						 
						 Cell R16cell21 = R16row.getCell(28);
						 if (R16cell21 != null) {
						 R16cell21.setCellValue(BRF56a.getR26_amount9() == null ? 0 :
						 BRF56a.getR26_amount9().intValue());
						       	 }
						 
						 Cell R16cell22 = R16row.getCell(29);
						 if (R16cell22 != null) {
						 R16cell22.setCellValue(BRF56a.getR26_nos10() == null ? 0 :
						 BRF56a.getR26_nos10().intValue());
						       	 }	
						 
						 Cell R16cell23 = R16row.getCell(30);
						 if (R16cell23 != null) {
						 R16cell23.setCellValue(BRF56a.getR26_amount10() == null ? 0 :
						 BRF56a.getR26_amount10().intValue());
						       	 }
						 
						 Cell R16cell24 = R16row.getCell(31);
						 if (R16cell24 != null) {
						 R16cell24.setCellValue(BRF56a.getR26_nos11() == null ? 0 :
						 BRF56a.getR26_nos11().intValue());
						       	 }	
						 
						 Cell R16cell25 = R16row.getCell(32);
						 if (R16cell25 != null) {
						 R16cell25.setCellValue(BRF56a.getR26_amount11() == null ? 0 :
						 BRF56a.getR26_amount11().intValue());
						       	 }
						 
						 Cell R16cell26 = R16row.getCell(33);
						 if (R16cell26 != null) {
						 R16cell26.setCellValue(BRF56a.getR26_nos12() == null ? 0 :
						 BRF56a.getR26_nos12().intValue());
						       	 }	
						 
						 Cell R16cell27 = R16row.getCell(34);
						 if (R16cell27 != null) {
						 R16cell27.setCellValue(BRF56a.getR26_amount12() == null ? 0 :
						 BRF56a.getR26_amount12().intValue());
						       	 }
						 
						 Cell R16cell28 = R16row.getCell(35);
						 if (R16cell28 != null) {
						 R16cell28.setCellValue(BRF56a.getR26_nos13() == null ? 0 :
						 BRF56a.getR26_nos13().intValue());
						       	 }	
						 
						 Cell R16cell29 = R16row.getCell(36);
						 if (R16cell29 != null) {
						 R16cell29.setCellValue(BRF56a.getR26_amount13() == null ? 0 :
						 BRF56a.getR26_amount13().intValue());
						       	 }
						 
						 Cell R16cell30 = R16row.getCell(37);
						 if (R16cell30 != null) {
						 R16cell30.setCellValue(BRF56a.getR26_nos14() == null ? 0 :
						 BRF56a.getR26_nos14().intValue());
						       	 }	
						 
						 Cell R16cell31 = R16row.getCell(38);
						 if (R16cell31 != null) {
						 R16cell31.setCellValue(BRF56a.getR26_amount14() == null ? 0 :
						 BRF56a.getR26_amount14().intValue());
						       	 }
								 

						    /////////////////////R27/////////////////////////
							
						 Row R17row = sheet.getRow(35);
						 
						 Cell R17cell1 = R17row.getCell(4);
						 if (R17cell1 != null) {
						 R17cell1.setCellValue(BRF56a.getR27_male() == null ? 0 :
						 BRF56a.getR27_male().intValue());
						       	 }				 
								
						 Cell R17cell2 = R17row.getCell(5);
						 if (R17cell2 != null) {
						 R17cell2.setCellValue(BRF56a.getR27_female() == null ? 0 :
						 BRF56a.getR27_female().intValue());
						       	 }	
								
						 Cell R17cell4 = R17row.getCell(11);
						 if (R17cell4 != null) {
						 R17cell4.setCellValue(BRF56a.getR27_nos1() == null ? 0 :
						 BRF56a.getR27_nos1().intValue());
						       	 }	
						 
						 Cell R17cell5 = R17row.getCell(12);
						 if (R17cell5 != null) {
						 R17cell5.setCellValue(BRF56a.getR27_amount1() == null ? 0 :
						 BRF56a.getR27_amount1().intValue());
						       	 }	
							
						 Cell R17cell6 = R17row.getCell(13);
						 if (R17cell6 != null) {
						 R17cell6.setCellValue(BRF56a.getR27_nos2() == null ? 0 :
						 BRF56a.getR27_nos2().intValue());
						       	 }	
						 
						 Cell R17cell7 = R17row.getCell(14);
						 if (R17cell7 != null) {
						 R17cell7.setCellValue(BRF56a.getR27_amount2() == null ? 0 :
						 BRF56a.getR27_amount2().intValue());
						       	 }
						 
						 Cell R17cell8 = R17row.getCell(15);
						 if (R17cell8 != null) {
						 R17cell8.setCellValue(BRF56a.getR27_nos3() == null ? 0 :
						 BRF56a.getR27_nos3().intValue());
						       	 }	
						 
						 Cell R17cell9 = R17row.getCell(16);
						 if (R17cell9 != null) {
						 R17cell9.setCellValue(BRF56a.getR27_amount3() == null ? 0 :
						 BRF56a.getR27_amount3().intValue());
						       	 }
						 
						 Cell R17cell10 = R17row.getCell(17);
						 if (R17cell10 != null) {
						 R17cell10.setCellValue(BRF56a.getR27_nos4() == null ? 0 :
						 BRF56a.getR27_nos4().intValue());
						       	 }	
						 
						 Cell R17cell11 = R17row.getCell(18);
						 if (R17cell11 != null) {
						 R17cell11.setCellValue(BRF56a.getR27_amount4() == null ? 0 :
						 BRF56a.getR27_amount4().intValue());
						       	 }
						 
						 Cell R17cell12 = R17row.getCell(19);
						 if (R17cell12 != null) {
						 R17cell12.setCellValue(BRF56a.getR27_nos5() == null ? 0 :
						 BRF56a.getR27_nos5().intValue());
						       	 }	
						 
						 Cell R17cell13 = R17row.getCell(20);
						 if (R17cell13 != null) {
						 R17cell13.setCellValue(BRF56a.getR27_amount5() == null ? 0 :
						 BRF56a.getR27_amount5().intValue());
						       	 }
						 
						 Cell R17cell14 = R17row.getCell(21);
						 if (R17cell14 != null) {
						 R17cell14.setCellValue(BRF56a.getR27_nos6() == null ? 0 :
						 BRF56a.getR27_nos6().intValue());
						       	 }	
						 
						 Cell R17cell15 = R17row.getCell(22);
						 if (R17cell15 != null) {
						 R17cell15.setCellValue(BRF56a.getR27_amount6() == null ? 0 :
						 BRF56a.getR27_amount6().intValue());
						       	 }
						 
						 Cell R17cell16 = R17row.getCell(23);
						 if (R17cell16 != null) {
						 R17cell16.setCellValue(BRF56a.getR27_nos7() == null ? 0 :
						 BRF56a.getR27_nos7().intValue());
						       	 }	
						 
						 Cell R17cell17 = R17row.getCell(24);
						 if (R17cell17 != null) {
						 R17cell17.setCellValue(BRF56a.getR27_amount7() == null ? 0 :
						 BRF56a.getR27_amount7().intValue());
						       	 }
						 
						 Cell R17cell18 = R17row.getCell(25);
						 if (R17cell18 != null) {
						 R17cell18.setCellValue(BRF56a.getR27_nos8() == null ? 0 :
						 BRF56a.getR27_nos8().intValue());
						       	 }	
						 
						 Cell R17cell19 = R17row.getCell(26);
						 if (R17cell19 != null) {
						 R17cell19.setCellValue(BRF56a.getR27_amount8() == null ? 0 :
						 BRF56a.getR27_amount8().intValue());
						       	 }
						 
						 Cell R17cell20 = R17row.getCell(27);
						 if (R17cell20 != null) {
						 R17cell20.setCellValue(BRF56a.getR27_nos9() == null ? 0 :
						 BRF56a.getR27_nos9().intValue());
						       	 }	
						 
						 Cell R17cell21 = R17row.getCell(28);
						 if (R17cell21 != null) {
						 R17cell21.setCellValue(BRF56a.getR27_amount9() == null ? 0 :
						 BRF56a.getR27_amount9().intValue());
						       	 }
						 
						 Cell R17cell22 = R17row.getCell(29);
						 if (R17cell22 != null) {
						 R17cell22.setCellValue(BRF56a.getR27_nos10() == null ? 0 :
						 BRF56a.getR27_nos10().intValue());
						       	 }	
						 
						 Cell R17cell23 = R17row.getCell(30);
						 if (R17cell23 != null) {
						 R17cell23.setCellValue(BRF56a.getR27_amount10() == null ? 0 :
						 BRF56a.getR27_amount10().intValue());
						       	 }
						 
						 Cell R17cell24 = R17row.getCell(31);
						 if (R17cell24 != null) {
						 R17cell24.setCellValue(BRF56a.getR27_nos11() == null ? 0 :
						 BRF56a.getR27_nos11().intValue());
						       	 }	
						 
						 Cell R17cell25 = R17row.getCell(32);
						 if (R17cell25 != null) {
						 R17cell25.setCellValue(BRF56a.getR27_amount11() == null ? 0 :
						 BRF56a.getR27_amount11().intValue());
						       	 }
						 
						 Cell R17cell26 = R17row.getCell(33);
						 if (R17cell26 != null) {
						 R17cell26.setCellValue(BRF56a.getR27_nos12() == null ? 0 :
						 BRF56a.getR27_nos12().intValue());
						       	 }	
						 
						 Cell R17cell27 = R17row.getCell(34);
						 if (R17cell27 != null) {
						 R17cell27.setCellValue(BRF56a.getR27_amount12() == null ? 0 :
						 BRF56a.getR27_amount12().intValue());
						       	 }
						 
						 Cell R17cell28 = R17row.getCell(35);
						 if (R17cell28 != null) {
						 R17cell28.setCellValue(BRF56a.getR27_nos13() == null ? 0 :
						 BRF56a.getR27_nos13().intValue());
						       	 }	
						 
						 Cell R17cell29 = R17row.getCell(36);
						 if (R17cell29 != null) {
						 R17cell29.setCellValue(BRF56a.getR27_amount13() == null ? 0 :
						 BRF56a.getR27_amount13().intValue());
						       	 }
						 
						 Cell R17cell30 = R17row.getCell(37);
						 if (R17cell30 != null) {
						 R17cell30.setCellValue(BRF56a.getR27_nos14() == null ? 0 :
						 BRF56a.getR27_nos14().intValue());
						       	 }	
						 
						 Cell R17cell31 = R17row.getCell(38);
						 if (R17cell31 != null) {
						 R17cell31.setCellValue(BRF56a.getR27_amount14() == null ? 0 :
						 BRF56a.getR27_amount14().intValue());
						       	 }
								 

						    /////////////////////R28/////////////////////////
							
						 Row R18row = sheet.getRow(36);
						 
						 Cell R18cell1 = R18row.getCell(4);
						 if (R18cell1 != null) {
						 R18cell1.setCellValue(BRF56a.getR28_male() == null ? 0 :
						 BRF56a.getR28_male().intValue());
						       	 }				 
								
						 Cell R18cell2 = R18row.getCell(5);
						 if (R18cell2 != null) {
						 R18cell2.setCellValue(BRF56a.getR28_female() == null ? 0 :
						 BRF56a.getR28_female().intValue());
						       	 }	
								
						 Cell R18cell4 = R18row.getCell(11);
						 if (R18cell4 != null) {
						 R18cell4.setCellValue(BRF56a.getR28_nos1() == null ? 0 :
						 BRF56a.getR28_nos1().intValue());
						       	 }	
						 
						 Cell R18cell5 = R18row.getCell(12);
						 if (R18cell5 != null) {
						 R18cell5.setCellValue(BRF56a.getR28_amount1() == null ? 0 :
						 BRF56a.getR28_amount1().intValue());
						       	 }	
							
						 Cell R18cell6 = R18row.getCell(13);
						 if (R18cell6 != null) {
						 R18cell6.setCellValue(BRF56a.getR28_nos2() == null ? 0 :
						 BRF56a.getR28_nos2().intValue());
						       	 }	
						 
						 Cell R18cell7 = R18row.getCell(14);
						 if (R18cell7 != null) {
						 R18cell7.setCellValue(BRF56a.getR28_amount2() == null ? 0 :
						 BRF56a.getR28_amount2().intValue());
						       	 }
						 
						 Cell R18cell8 = R18row.getCell(15);
						 if (R18cell8 != null) {
						 R18cell8.setCellValue(BRF56a.getR28_nos3() == null ? 0 :
						 BRF56a.getR28_nos3().intValue());
						       	 }	
						 
						 Cell R18cell9 = R18row.getCell(16);
						 if (R18cell9 != null) {
						 R18cell9.setCellValue(BRF56a.getR28_amount3() == null ? 0 :
						 BRF56a.getR28_amount3().intValue());
						       	 }
						 
						 Cell R18cell10 = R18row.getCell(17);
						 if (R18cell10 != null) {
						 R18cell10.setCellValue(BRF56a.getR28_nos4() == null ? 0 :
						 BRF56a.getR28_nos4().intValue());
						       	 }	
						 
						 Cell R18cell11 = R18row.getCell(18);
						 if (R18cell11 != null) {
						 R18cell11.setCellValue(BRF56a.getR28_amount4() == null ? 0 :
						 BRF56a.getR28_amount4().intValue());
						       	 }
						 
						 Cell R18cell12 = R18row.getCell(19);
						 if (R18cell12 != null) {
						 R18cell12.setCellValue(BRF56a.getR28_nos5() == null ? 0 :
						 BRF56a.getR28_nos5().intValue());
						       	 }	
						 
						 Cell R18cell13 = R18row.getCell(20);
						 if (R18cell13 != null) {
						 R18cell13.setCellValue(BRF56a.getR28_amount5() == null ? 0 :
						 BRF56a.getR28_amount5().intValue());
						       	 }
						 
						 Cell R18cell14 = R18row.getCell(21);
						 if (R18cell14 != null) {
						 R18cell14.setCellValue(BRF56a.getR28_nos6() == null ? 0 :
						 BRF56a.getR28_nos6().intValue());
						       	 }	
						 
						 Cell R18cell15 = R18row.getCell(22);
						 if (R18cell15 != null) {
						 R18cell15.setCellValue(BRF56a.getR28_amount6() == null ? 0 :
						 BRF56a.getR28_amount6().intValue());
						       	 }
						 
						 Cell R18cell16 = R18row.getCell(23);
						 if (R18cell16 != null) {
						 R18cell16.setCellValue(BRF56a.getR28_nos7() == null ? 0 :
						 BRF56a.getR28_nos7().intValue());
						       	 }	
						 
						 Cell R18cell17 = R18row.getCell(24);
						 if (R18cell17 != null) {
						 R18cell17.setCellValue(BRF56a.getR28_amount7() == null ? 0 :
						 BRF56a.getR28_amount7().intValue());
						       	 }
						 
						 Cell R18cell18 = R18row.getCell(25);
						 if (R18cell18 != null) {
						 R18cell18.setCellValue(BRF56a.getR28_nos8() == null ? 0 :
						 BRF56a.getR28_nos8().intValue());
						       	 }	
						 
						 Cell R18cell19 = R18row.getCell(26);
						 if (R18cell19 != null) {
						 R18cell19.setCellValue(BRF56a.getR28_amount8() == null ? 0 :
						 BRF56a.getR28_amount8().intValue());
						       	 }
						 
						 Cell R18cell20 = R18row.getCell(27);
						 if (R18cell20 != null) {
						 R18cell20.setCellValue(BRF56a.getR28_nos9() == null ? 0 :
						 BRF56a.getR28_nos9().intValue());
						       	 }	
						 
						 Cell R18cell21 = R18row.getCell(28);
						 if (R18cell21 != null) {
						 R18cell21.setCellValue(BRF56a.getR28_amount9() == null ? 0 :
						 BRF56a.getR28_amount9().intValue());
						       	 }
						 
						 Cell R18cell22 = R18row.getCell(29);
						 if (R18cell22 != null) {
						 R18cell22.setCellValue(BRF56a.getR28_nos10() == null ? 0 :
						 BRF56a.getR28_nos10().intValue());
						       	 }	
						 
						 Cell R18cell23 = R18row.getCell(30);
						 if (R18cell23 != null) {
						 R18cell23.setCellValue(BRF56a.getR28_amount10() == null ? 0 :
						 BRF56a.getR28_amount10().intValue());
						       	 }
						 
						 Cell R18cell24 = R18row.getCell(31);
						 if (R18cell24 != null) {
						 R18cell24.setCellValue(BRF56a.getR28_nos11() == null ? 0 :
						 BRF56a.getR28_nos11().intValue());
						       	 }	
						 
						 Cell R18cell25 = R18row.getCell(32);
						 if (R18cell25 != null) {
						 R18cell25.setCellValue(BRF56a.getR28_amount11() == null ? 0 :
						 BRF56a.getR28_amount11().intValue());
						       	 }
						 
						 Cell R18cell26 = R18row.getCell(33);
						 if (R18cell26 != null) {
						 R18cell26.setCellValue(BRF56a.getR28_nos12() == null ? 0 :
						 BRF56a.getR28_nos12().intValue());
						       	 }	
						 
						 Cell R18cell27 = R18row.getCell(34);
						 if (R18cell27 != null) {
						 R18cell27.setCellValue(BRF56a.getR28_amount12() == null ? 0 :
						 BRF56a.getR28_amount12().intValue());
						       	 }
						 
						 Cell R18cell28 = R18row.getCell(35);
						 if (R18cell28 != null) {
						 R18cell28.setCellValue(BRF56a.getR28_nos13() == null ? 0 :
						 BRF56a.getR28_nos13().intValue());
						       	 }	
						 
						 Cell R18cell29 = R18row.getCell(36);
						 if (R18cell29 != null) {
						 R18cell29.setCellValue(BRF56a.getR28_amount13() == null ? 0 :
						 BRF56a.getR28_amount13().intValue());
						       	 }
						 
						 Cell R18cell30 = R18row.getCell(37);
						 if (R18cell30 != null) {
						 R18cell30.setCellValue(BRF56a.getR28_nos14() == null ? 0 :
						 BRF56a.getR28_nos14().intValue());
						       	 }	
						 
						 Cell R18cell31 = R18row.getCell(38);
						 if (R18cell31 != null) {
						 R18cell31.setCellValue(BRF56a.getR28_amount14() == null ? 0 :
						 BRF56a.getR28_amount14().intValue());
						       	 }
								 
						 
						    /////////////////////R29/////////////////////////
							
						 Row R19row = sheet.getRow(37);
						 
						 Cell R19cell1 = R19row.getCell(4);
						 if (R19cell1 != null) {
						 R19cell1.setCellValue(BRF56a.getR29_male() == null ? 0 :
						 BRF56a.getR29_male().intValue());
						       	 }				 
								
						 Cell R19cell2 = R19row.getCell(5);
						 if (R19cell2 != null) {
						 R19cell2.setCellValue(BRF56a.getR29_female() == null ? 0 :
						 BRF56a.getR29_female().intValue());
						       	 }	
								
						 Cell R19cell4 = R19row.getCell(11);
						 if (R19cell4 != null) {
						 R19cell4.setCellValue(BRF56a.getR29_nos1() == null ? 0 :
						 BRF56a.getR29_nos1().intValue());
						       	 }	
						 
						 Cell R19cell5 = R19row.getCell(12);
						 if (R19cell5 != null) {
						 R19cell5.setCellValue(BRF56a.getR29_amount1() == null ? 0 :
						 BRF56a.getR29_amount1().intValue());
						       	 }	
							
						 Cell R19cell6 = R19row.getCell(13);
						 if (R19cell6 != null) {
						 R19cell6.setCellValue(BRF56a.getR29_nos2() == null ? 0 :
						 BRF56a.getR29_nos2().intValue());
						       	 }	
						 
						 Cell R19cell7 = R19row.getCell(14);
						 if (R19cell7 != null) {
						 R19cell7.setCellValue(BRF56a.getR29_amount2() == null ? 0 :
						 BRF56a.getR29_amount2().intValue());
						       	 }
						 
						 Cell R19cell8 = R19row.getCell(15);
						 if (R19cell8 != null) {
						 R19cell8.setCellValue(BRF56a.getR29_nos3() == null ? 0 :
						 BRF56a.getR29_nos3().intValue());
						       	 }	
						 
						 Cell R19cell9 = R19row.getCell(16);
						 if (R19cell9 != null) {
						 R19cell9.setCellValue(BRF56a.getR29_amount3() == null ? 0 :
						 BRF56a.getR29_amount3().intValue());
						       	 }
						 
						 Cell R19cell10 = R19row.getCell(17);
						 if (R19cell10 != null) {
						 R19cell10.setCellValue(BRF56a.getR29_nos4() == null ? 0 :
						 BRF56a.getR29_nos4().intValue());
						       	 }	
						 
						 Cell R19cell11 = R19row.getCell(18);
						 if (R19cell11 != null) {
						 R19cell11.setCellValue(BRF56a.getR29_amount4() == null ? 0 :
						 BRF56a.getR29_amount4().intValue());
						       	 }
						 
						 Cell R19cell12 = R19row.getCell(19);
						 if (R19cell12 != null) {
						 R19cell12.setCellValue(BRF56a.getR29_nos5() == null ? 0 :
						 BRF56a.getR29_nos5().intValue());
						       	 }	
						 
						 Cell R19cell13 = R19row.getCell(20);
						 if (R19cell13 != null) {
						 R19cell13.setCellValue(BRF56a.getR29_amount5() == null ? 0 :
						 BRF56a.getR29_amount5().intValue());
						       	 }
						 
						 Cell R19cell14 = R19row.getCell(21);
						 if (R19cell14 != null) {
						 R19cell14.setCellValue(BRF56a.getR29_nos6() == null ? 0 :
						 BRF56a.getR29_nos6().intValue());
						       	 }	
						 
						 Cell R19cell15 = R19row.getCell(22);
						 if (R19cell15 != null) {
						 R19cell15.setCellValue(BRF56a.getR29_amount6() == null ? 0 :
						 BRF56a.getR29_amount6().intValue());
						       	 }
						 
						 Cell R19cell16 = R19row.getCell(23);
						 if (R19cell16 != null) {
						 R19cell16.setCellValue(BRF56a.getR29_nos7() == null ? 0 :
						 BRF56a.getR29_nos7().intValue());
						       	 }	
						 
						 Cell R19cell17 = R19row.getCell(24);
						 if (R19cell17 != null) {
						 R19cell17.setCellValue(BRF56a.getR29_amount7() == null ? 0 :
						 BRF56a.getR29_amount7().intValue());
						       	 }
						 
						 Cell R19cell18 = R19row.getCell(25);
						 if (R19cell18 != null) {
						 R19cell18.setCellValue(BRF56a.getR29_nos8() == null ? 0 :
						 BRF56a.getR29_nos8().intValue());
						       	 }	
						 
						 Cell R19cell19 = R19row.getCell(26);
						 if (R19cell19 != null) {
						 R19cell19.setCellValue(BRF56a.getR29_amount8() == null ? 0 :
						 BRF56a.getR29_amount8().intValue());
						       	 }
						 
						 Cell R19cell20 = R19row.getCell(27);
						 if (R19cell20 != null) {
						 R19cell20.setCellValue(BRF56a.getR29_nos9() == null ? 0 :
						 BRF56a.getR29_nos9().intValue());
						       	 }	
						 
						 Cell R19cell21 = R19row.getCell(28);
						 if (R19cell21 != null) {
						 R19cell21.setCellValue(BRF56a.getR29_amount9() == null ? 0 :
						 BRF56a.getR29_amount9().intValue());
						       	 }
						 
						 Cell R19cell22 = R19row.getCell(29);
						 if (R19cell22 != null) {
						 R19cell22.setCellValue(BRF56a.getR29_nos10() == null ? 0 :
						 BRF56a.getR29_nos10().intValue());
						       	 }	
						 
						 Cell R19cell23 = R19row.getCell(30);
						 if (R19cell23 != null) {
						 R19cell23.setCellValue(BRF56a.getR29_amount10() == null ? 0 :
						 BRF56a.getR29_amount10().intValue());
						       	 }
						 
						 Cell R19cell24 = R19row.getCell(31);
						 if (R19cell24 != null) {
						 R19cell24.setCellValue(BRF56a.getR29_nos11() == null ? 0 :
						 BRF56a.getR29_nos11().intValue());
						       	 }	
						 
						 Cell R19cell25 = R19row.getCell(32);
						 if (R19cell25 != null) {
						 R19cell25.setCellValue(BRF56a.getR29_amount11() == null ? 0 :
						 BRF56a.getR29_amount11().intValue());
						       	 }
						 
						 Cell R19cell26 = R19row.getCell(33);
						 if (R19cell26 != null) {
						 R19cell26.setCellValue(BRF56a.getR29_nos12() == null ? 0 :
						 BRF56a.getR29_nos12().intValue());
						       	 }	
						 
						 Cell R19cell27 = R19row.getCell(34);
						 if (R19cell27 != null) {
						 R19cell27.setCellValue(BRF56a.getR29_amount12() == null ? 0 :
						 BRF56a.getR29_amount12().intValue());
						       	 }
						 
						 Cell R19cell28 = R19row.getCell(35);
						 if (R19cell28 != null) {
						 R19cell28.setCellValue(BRF56a.getR29_nos13() == null ? 0 :
						 BRF56a.getR29_nos13().intValue());
						       	 }	
						 
						 Cell R19cell29 = R19row.getCell(36);
						 if (R19cell29 != null) {
						 R19cell29.setCellValue(BRF56a.getR29_amount13() == null ? 0 :
						 BRF56a.getR29_amount13().intValue());
						       	 }
						 
						 Cell R19cell30 = R19row.getCell(37);
						 if (R19cell30 != null) {
						 R19cell30.setCellValue(BRF56a.getR29_nos14() == null ? 0 :
						 BRF56a.getR29_nos14().intValue());
						       	 }	
						 
						 Cell R19cell31 = R19row.getCell(38);
						 if (R19cell31 != null) {
						 R19cell31.setCellValue(BRF56a.getR29_amount14() == null ? 0 :
						 BRF56a.getR29_amount14().intValue());
						       	 }
								 

						    /////////////////////R30/////////////////////////
							
						 Row R20row = sheet.getRow(38);
						 
						 Cell R20cell1 = R20row.getCell(4);
						 if (R20cell1 != null) {
						 R20cell1.setCellValue(BRF56a.getR30_male() == null ? 0 :
						 BRF56a.getR30_male().intValue());
						       	 }				 
								
						 Cell R20cell2 = R20row.getCell(5);
						 if (R20cell2 != null) {
						 R20cell2.setCellValue(BRF56a.getR30_female() == null ? 0 :
						 BRF56a.getR30_female().intValue());
						       	 }	
								
						 Cell R20cell4 = R20row.getCell(11);
						 if (R20cell4 != null) {
						 R20cell4.setCellValue(BRF56a.getR30_nos1() == null ? 0 :
						 BRF56a.getR30_nos1().intValue());
						       	 }	
						 
						 Cell R20cell5 = R20row.getCell(12);
						 if (R20cell5 != null) {
						 R20cell5.setCellValue(BRF56a.getR30_amount1() == null ? 0 :
						 BRF56a.getR30_amount1().intValue());
						       	 }	
							
						 Cell R20cell6 = R20row.getCell(13);
						 if (R20cell6 != null) {
						 R20cell6.setCellValue(BRF56a.getR30_nos2() == null ? 0 :
						 BRF56a.getR30_nos2().intValue());
						       	 }	
						 
						 Cell R20cell7 = R20row.getCell(14);
						 if (R20cell7 != null) {
						 R20cell7.setCellValue(BRF56a.getR30_amount2() == null ? 0 :
						 BRF56a.getR30_amount2().intValue());
						       	 }
						 
						 Cell R20cell8 = R20row.getCell(15);
						 if (R20cell8 != null) {
						 R20cell8.setCellValue(BRF56a.getR30_nos3() == null ? 0 :
						 BRF56a.getR30_nos3().intValue());
						       	 }	
						 
						 Cell R20cell9 = R20row.getCell(16);
						 if (R20cell9 != null) {
						 R20cell9.setCellValue(BRF56a.getR30_amount3() == null ? 0 :
						 BRF56a.getR30_amount3().intValue());
						       	 }
						 
						 Cell R20cell10 = R20row.getCell(17);
						 if (R20cell10 != null) {
						 R20cell10.setCellValue(BRF56a.getR30_nos4() == null ? 0 :
						 BRF56a.getR30_nos4().intValue());
						       	 }	
						 
						 Cell R20cell11 = R20row.getCell(18);
						 if (R20cell11 != null) {
						 R20cell11.setCellValue(BRF56a.getR30_amount4() == null ? 0 :
						 BRF56a.getR30_amount4().intValue());
						       	 }
						 
						 Cell R20cell12 = R20row.getCell(19);
						 if (R20cell12 != null) {
						 R20cell12.setCellValue(BRF56a.getR30_nos5() == null ? 0 :
						 BRF56a.getR30_nos5().intValue());
						       	 }	
						 
						 Cell R20cell13 = R20row.getCell(20);
						 if (R20cell13 != null) {
						 R20cell13.setCellValue(BRF56a.getR30_amount5() == null ? 0 :
						 BRF56a.getR30_amount5().intValue());
						       	 }
						 
						 Cell R20cell14 = R20row.getCell(21);
						 if (R20cell14 != null) {
						 R20cell14.setCellValue(BRF56a.getR30_nos6() == null ? 0 :
						 BRF56a.getR30_nos6().intValue());
						       	 }	
						 
						 Cell R20cell15 = R20row.getCell(22);
						 if (R20cell15 != null) {
						 R20cell15.setCellValue(BRF56a.getR30_amount6() == null ? 0 :
						 BRF56a.getR30_amount6().intValue());
						       	 }
						 
						 Cell R20cell16 = R20row.getCell(23);
						 if (R20cell16 != null) {
						 R20cell16.setCellValue(BRF56a.getR30_nos7() == null ? 0 :
						 BRF56a.getR30_nos7().intValue());
						       	 }	
						 
						 Cell R20cell17 = R20row.getCell(24);
						 if (R20cell17 != null) {
						 R20cell17.setCellValue(BRF56a.getR30_amount7() == null ? 0 :
						 BRF56a.getR30_amount7().intValue());
						       	 }
						 
						 Cell R20cell18 = R20row.getCell(25);
						 if (R20cell18 != null) {
						 R20cell18.setCellValue(BRF56a.getR30_nos8() == null ? 0 :
						 BRF56a.getR30_nos8().intValue());
						       	 }	
						 
						 Cell R20cell19 = R20row.getCell(26);
						 if (R20cell19 != null) {
						 R20cell19.setCellValue(BRF56a.getR30_amount8() == null ? 0 :
						 BRF56a.getR30_amount8().intValue());
						       	 }
						 
						 Cell R20cell20 = R20row.getCell(27);
						 if (R20cell20 != null) {
						 R20cell20.setCellValue(BRF56a.getR30_nos9() == null ? 0 :
						 BRF56a.getR30_nos9().intValue());
						       	 }	
						 
						 Cell R20cell21 = R20row.getCell(28);
						 if (R20cell21 != null) {
						 R20cell21.setCellValue(BRF56a.getR30_amount9() == null ? 0 :
						 BRF56a.getR30_amount9().intValue());
						       	 }
						 
						 Cell R20cell22 = R20row.getCell(29);
						 if (R20cell22 != null) {
						 R20cell22.setCellValue(BRF56a.getR30_nos10() == null ? 0 :
						 BRF56a.getR30_nos10().intValue());
						       	 }	
						 
						 Cell R20cell23 = R20row.getCell(30);
						 if (R20cell23 != null) {
						 R20cell23.setCellValue(BRF56a.getR30_amount10() == null ? 0 :
						 BRF56a.getR30_amount10().intValue());
						       	 }
						 
						 Cell R20cell24 = R20row.getCell(31);
						 if (R20cell24 != null) {
						 R20cell24.setCellValue(BRF56a.getR30_nos11() == null ? 0 :
						 BRF56a.getR30_nos11().intValue());
						       	 }	
						 
						 Cell R20cell25 = R20row.getCell(32);
						 if (R20cell25 != null) {
						 R20cell25.setCellValue(BRF56a.getR30_amount11() == null ? 0 :
						 BRF56a.getR30_amount11().intValue());
						       	 }
						 
						 Cell R20cell26 = R20row.getCell(33);
						 if (R20cell26 != null) {
						 R20cell26.setCellValue(BRF56a.getR30_nos12() == null ? 0 :
						 BRF56a.getR30_nos12().intValue());
						       	 }	
						 
						 Cell R20cell27 = R20row.getCell(34);
						 if (R20cell27 != null) {
						 R20cell27.setCellValue(BRF56a.getR30_amount12() == null ? 0 :
						 BRF56a.getR30_amount12().intValue());
						       	 }
						 
						 Cell R20cell28 = R20row.getCell(35);
						 if (R20cell28 != null) {
						 R20cell28.setCellValue(BRF56a.getR30_nos13() == null ? 0 :
						 BRF56a.getR30_nos13().intValue());
						       	 }	
						 
						 Cell R20cell29 = R20row.getCell(36);
						 if (R20cell29 != null) {
						 R20cell29.setCellValue(BRF56a.getR30_amount13() == null ? 0 :
						 BRF56a.getR30_amount13().intValue());
						       	 }
						 
						 Cell R20cell30 = R20row.getCell(37);
						 if (R20cell30 != null) {
						 R20cell30.setCellValue(BRF56a.getR30_nos14() == null ? 0 :
						 BRF56a.getR30_nos14().intValue());
						       	 }	
						 
						 Cell R20cell31 = R20row.getCell(38);
						 if (R20cell31 != null) {
						 R20cell31.setCellValue(BRF56a.getR30_amount14() == null ? 0 :
						 BRF56a.getR30_amount14().intValue());
						       	 }
								 

						    /////////////////////R31/////////////////////////
							
						 Row R21row = sheet.getRow(39);
						 
						 Cell R21cell1 = R21row.getCell(4);
						 if (R21cell1 != null) {
						 R21cell1.setCellValue(BRF56a.getR31_male() == null ? 0 :
						 BRF56a.getR31_male().intValue());
						       	 }				 
								
						 Cell R21cell2 = R21row.getCell(5);
						 if (R21cell2 != null) {
						 R21cell2.setCellValue(BRF56a.getR31_female() == null ? 0 :
						 BRF56a.getR31_female().intValue());
						       	 }	
								
						 Cell R21cell4 = R21row.getCell(11);
						 if (R21cell4 != null) {
						 R21cell4.setCellValue(BRF56a.getR31_nos1() == null ? 0 :
						 BRF56a.getR31_nos1().intValue());
						       	 }	
						 
						 Cell R21cell5 = R21row.getCell(12);
						 if (R21cell5 != null) {
						 R21cell5.setCellValue(BRF56a.getR31_amount1() == null ? 0 :
						 BRF56a.getR31_amount1().intValue());
						       	 }	
							
						 Cell R21cell6 = R21row.getCell(13);
						 if (R21cell6 != null) {
						 R21cell6.setCellValue(BRF56a.getR31_nos2() == null ? 0 :
						 BRF56a.getR31_nos2().intValue());
						       	 }	
						 
						 Cell R21cell7 = R21row.getCell(14);
						 if (R21cell7 != null) {
						 R21cell7.setCellValue(BRF56a.getR31_amount2() == null ? 0 :
						 BRF56a.getR31_amount2().intValue());
						       	 }
						 
						 Cell R21cell8 = R21row.getCell(15);
						 if (R21cell8 != null) {
						 R21cell8.setCellValue(BRF56a.getR31_nos3() == null ? 0 :
						 BRF56a.getR31_nos3().intValue());
						       	 }	
						 
						 Cell R21cell9 = R21row.getCell(16);
						 if (R21cell9 != null) {
						 R21cell9.setCellValue(BRF56a.getR31_amount3() == null ? 0 :
						 BRF56a.getR31_amount3().intValue());
						       	 }
						 
						 Cell R21cell10 = R21row.getCell(17);
						 if (R21cell10 != null) {
						 R21cell10.setCellValue(BRF56a.getR31_nos4() == null ? 0 :
						 BRF56a.getR31_nos4().intValue());
						       	 }	
						 
						 Cell R21cell11 = R21row.getCell(18);
						 if (R21cell11 != null) {
						 R21cell11.setCellValue(BRF56a.getR31_amount4() == null ? 0 :
						 BRF56a.getR31_amount4().intValue());
						       	 }
						 
						 Cell R21cell12 = R21row.getCell(19);
						 if (R21cell12 != null) {
						 R21cell12.setCellValue(BRF56a.getR31_nos5() == null ? 0 :
						 BRF56a.getR31_nos5().intValue());
						       	 }	
						 
						 Cell R21cell13 = R21row.getCell(20);
						 if (R21cell13 != null) {
						 R21cell13.setCellValue(BRF56a.getR31_amount5() == null ? 0 :
						 BRF56a.getR31_amount5().intValue());
						       	 }
						 
						 Cell R21cell14 = R21row.getCell(21);
						 if (R21cell14 != null) {
						 R21cell14.setCellValue(BRF56a.getR31_nos6() == null ? 0 :
						 BRF56a.getR31_nos6().intValue());
						       	 }	
						 
						 Cell R21cell15 = R21row.getCell(22);
						 if (R21cell15 != null) {
						 R21cell15.setCellValue(BRF56a.getR31_amount6() == null ? 0 :
						 BRF56a.getR31_amount6().intValue());
						       	 }
						 
						 Cell R21cell16 = R21row.getCell(23);
						 if (R21cell16 != null) {
						 R21cell16.setCellValue(BRF56a.getR31_nos7() == null ? 0 :
						 BRF56a.getR31_nos7().intValue());
						       	 }	
						 
						 Cell R21cell17 = R21row.getCell(24);
						 if (R21cell17 != null) {
						 R21cell17.setCellValue(BRF56a.getR31_amount7() == null ? 0 :
						 BRF56a.getR31_amount7().intValue());
						       	 }
						 
						 Cell R21cell18 = R21row.getCell(25);
						 if (R21cell18 != null) {
						 R21cell18.setCellValue(BRF56a.getR31_nos8() == null ? 0 :
						 BRF56a.getR31_nos8().intValue());
						       	 }	
						 
						 Cell R21cell19 = R21row.getCell(26);
						 if (R21cell19 != null) {
						 R21cell19.setCellValue(BRF56a.getR31_amount8() == null ? 0 :
						 BRF56a.getR31_amount8().intValue());
						       	 }
						 
						 Cell R21cell20 = R21row.getCell(27);
						 if (R21cell20 != null) {
						 R21cell20.setCellValue(BRF56a.getR31_nos9() == null ? 0 :
						 BRF56a.getR31_nos9().intValue());
						       	 }	
						 
						 Cell R21cell21 = R21row.getCell(28);
						 if (R21cell21 != null) {
						 R21cell21.setCellValue(BRF56a.getR31_amount9() == null ? 0 :
						 BRF56a.getR31_amount9().intValue());
						       	 }
						 
						 Cell R21cell22 = R21row.getCell(29);
						 if (R21cell22 != null) {
						 R21cell22.setCellValue(BRF56a.getR31_nos10() == null ? 0 :
						 BRF56a.getR31_nos10().intValue());
						       	 }	
						 
						 Cell R21cell23 = R21row.getCell(30);
						 if (R21cell23 != null) {
						 R21cell23.setCellValue(BRF56a.getR31_amount10() == null ? 0 :
						 BRF56a.getR31_amount10().intValue());
						       	 }
						 
						 Cell R21cell24 = R21row.getCell(31);
						 if (R21cell24 != null) {
						 R21cell24.setCellValue(BRF56a.getR31_nos11() == null ? 0 :
						 BRF56a.getR31_nos11().intValue());
						       	 }	
						 
						 Cell R21cell25 = R21row.getCell(32);
						 if (R21cell25 != null) {
						 R21cell25.setCellValue(BRF56a.getR31_amount11() == null ? 0 :
						 BRF56a.getR31_amount11().intValue());
						       	 }
						 
						 Cell R21cell26 = R21row.getCell(33);
						 if (R21cell26 != null) {
						 R21cell26.setCellValue(BRF56a.getR31_nos12() == null ? 0 :
						 BRF56a.getR31_nos12().intValue());
						       	 }	
						 
						 Cell R21cell27 = R21row.getCell(34);
						 if (R21cell27 != null) {
						 R21cell27.setCellValue(BRF56a.getR31_amount12() == null ? 0 :
						 BRF56a.getR31_amount12().intValue());
						       	 }
						 
						 Cell R21cell28 = R21row.getCell(35);
						 if (R21cell28 != null) {
						 R21cell28.setCellValue(BRF56a.getR31_nos13() == null ? 0 :
						 BRF56a.getR31_nos13().intValue());
						       	 }	
						 
						 Cell R21cell29 = R21row.getCell(36);
						 if (R21cell29 != null) {
						 R21cell29.setCellValue(BRF56a.getR31_amount13() == null ? 0 :
						 BRF56a.getR31_amount13().intValue());
						       	 }
						 
						 Cell R21cell30 = R21row.getCell(37);
						 if (R21cell30 != null) {
						 R21cell30.setCellValue(BRF56a.getR31_nos14() == null ? 0 :
						 BRF56a.getR31_nos14().intValue());
						       	 }	
						 
						 Cell R21cell31 = R21row.getCell(38);
						 if (R21cell31 != null) {
						 R21cell31.setCellValue(BRF56a.getR31_amount14() == null ? 0 :
						 BRF56a.getR31_amount14().intValue());
						       	 }
								 

						    /////////////////////R32/////////////////////////
							
						 Row R22row = sheet.getRow(40);
						 
						 Cell R22cell1 = R22row.getCell(4);
						 if (R22cell1 != null) {
						 R22cell1.setCellValue(BRF56a.getR32_male() == null ? 0 :
						 BRF56a.getR32_male().intValue());
						       	 }				 
								
						 Cell R22cell2 = R22row.getCell(5);
						 if (R22cell2 != null) {
						 R22cell2.setCellValue(BRF56a.getR32_female() == null ? 0 :
						 BRF56a.getR32_female().intValue());
						       	 }	
								
						 Cell R22cell4 = R22row.getCell(11);
						 if (R22cell4 != null) {
						 R22cell4.setCellValue(BRF56a.getR32_nos1() == null ? 0 :
						 BRF56a.getR32_nos1().intValue());
						       	 }	
						 
						 Cell R22cell5 = R22row.getCell(12);
						 if (R22cell5 != null) {
						 R22cell5.setCellValue(BRF56a.getR32_amount1() == null ? 0 :
						 BRF56a.getR32_amount1().intValue());
						       	 }	
							
						 Cell R22cell6 = R22row.getCell(13);
						 if (R22cell6 != null) {
						 R22cell6.setCellValue(BRF56a.getR32_nos2() == null ? 0 :
						 BRF56a.getR32_nos2().intValue());
						       	 }	
						 
						 Cell R22cell7 = R22row.getCell(14);
						 if (R22cell7 != null) {
						 R22cell7.setCellValue(BRF56a.getR32_amount2() == null ? 0 :
						 BRF56a.getR32_amount2().intValue());
						       	 }
						 
						 Cell R22cell8 = R22row.getCell(15);
						 if (R22cell8 != null) {
						 R22cell8.setCellValue(BRF56a.getR32_nos3() == null ? 0 :
						 BRF56a.getR32_nos3().intValue());
						       	 }	
						 
						 Cell R22cell9 = R22row.getCell(16);
						 if (R22cell9 != null) {
						 R22cell9.setCellValue(BRF56a.getR32_amount3() == null ? 0 :
						 BRF56a.getR32_amount3().intValue());
						       	 }
						 
						 Cell R22cell10 = R22row.getCell(17);
						 if (R22cell10 != null) {
						 R22cell10.setCellValue(BRF56a.getR32_nos4() == null ? 0 :
						 BRF56a.getR32_nos4().intValue());
						       	 }	
						 
						 Cell R22cell11 = R22row.getCell(18);
						 if (R22cell11 != null) {
						 R22cell11.setCellValue(BRF56a.getR32_amount4() == null ? 0 :
						 BRF56a.getR32_amount4().intValue());
						       	 }
						 
						 Cell R22cell12 = R22row.getCell(19);
						 if (R22cell12 != null) {
						 R22cell12.setCellValue(BRF56a.getR32_nos5() == null ? 0 :
						 BRF56a.getR32_nos5().intValue());
						       	 }	
						 
						 Cell R22cell13 = R22row.getCell(20);
						 if (R22cell13 != null) {
						 R22cell13.setCellValue(BRF56a.getR32_amount5() == null ? 0 :
						 BRF56a.getR32_amount5().intValue());
						       	 }
						 
						 Cell R22cell14 = R22row.getCell(21);
						 if (R22cell14 != null) {
						 R22cell14.setCellValue(BRF56a.getR32_nos6() == null ? 0 :
						 BRF56a.getR32_nos6().intValue());
						       	 }	
						 
						 Cell R22cell15 = R22row.getCell(22);
						 if (R22cell15 != null) {
						 R22cell15.setCellValue(BRF56a.getR32_amount6() == null ? 0 :
						 BRF56a.getR32_amount6().intValue());
						       	 }
						 
						 Cell R22cell16 = R22row.getCell(23);
						 if (R22cell16 != null) {
						 R22cell16.setCellValue(BRF56a.getR32_nos7() == null ? 0 :
						 BRF56a.getR32_nos7().intValue());
						       	 }	
						 
						 Cell R22cell17 = R22row.getCell(24);
						 if (R22cell17 != null) {
						 R22cell17.setCellValue(BRF56a.getR32_amount7() == null ? 0 :
						 BRF56a.getR32_amount7().intValue());
						       	 }
						 
						 Cell R22cell18 = R22row.getCell(25);
						 if (R22cell18 != null) {
						 R22cell18.setCellValue(BRF56a.getR32_nos8() == null ? 0 :
						 BRF56a.getR32_nos8().intValue());
						       	 }	
						 
						 Cell R22cell19 = R22row.getCell(26);
						 if (R22cell19 != null) {
						 R22cell19.setCellValue(BRF56a.getR32_amount8() == null ? 0 :
						 BRF56a.getR32_amount8().intValue());
						       	 }
						 
						 Cell R22cell20 = R22row.getCell(27);
						 if (R22cell20 != null) {
						 R22cell20.setCellValue(BRF56a.getR32_nos9() == null ? 0 :
						 BRF56a.getR32_nos9().intValue());
						       	 }	
						 
						 Cell R22cell21 = R22row.getCell(28);
						 if (R22cell21 != null) {
						 R22cell21.setCellValue(BRF56a.getR32_amount9() == null ? 0 :
						 BRF56a.getR32_amount9().intValue());
						       	 }
						 
						 Cell R22cell22 = R22row.getCell(29);
						 if (R22cell22 != null) {
						 R22cell22.setCellValue(BRF56a.getR32_nos10() == null ? 0 :
						 BRF56a.getR32_nos10().intValue());
						       	 }	
						 
						 Cell R22cell23 = R22row.getCell(30);
						 if (R22cell23 != null) {
						 R22cell23.setCellValue(BRF56a.getR32_amount10() == null ? 0 :
						 BRF56a.getR32_amount10().intValue());
						       	 }
						 
						 Cell R22cell24 = R22row.getCell(31);
						 if (R22cell24 != null) {
						 R22cell24.setCellValue(BRF56a.getR32_nos11() == null ? 0 :
						 BRF56a.getR32_nos11().intValue());
						       	 }	
						 
						 Cell R22cell25 = R22row.getCell(32);
						 if (R22cell25 != null) {
						 R22cell25.setCellValue(BRF56a.getR32_amount11() == null ? 0 :
						 BRF56a.getR32_amount11().intValue());
						       	 }
						 
						 Cell R22cell26 = R22row.getCell(33);
						 if (R22cell26 != null) {
						 R22cell26.setCellValue(BRF56a.getR32_nos12() == null ? 0 :
						 BRF56a.getR32_nos12().intValue());
						       	 }	
						 
						 Cell R22cell27 = R22row.getCell(34);
						 if (R22cell27 != null) {
						 R22cell27.setCellValue(BRF56a.getR32_amount12() == null ? 0 :
						 BRF56a.getR32_amount12().intValue());
						       	 }
						 
						 Cell R22cell28 = R22row.getCell(35);
						 if (R22cell28 != null) {
						 R22cell28.setCellValue(BRF56a.getR32_nos13() == null ? 0 :
						 BRF56a.getR32_nos13().intValue());
						       	 }	
						 
						 Cell R22cell29 = R22row.getCell(36);
						 if (R22cell29 != null) {
						 R22cell29.setCellValue(BRF56a.getR32_amount13() == null ? 0 :
						 BRF56a.getR32_amount13().intValue());
						       	 }
						 
						 Cell R22cell30 = R22row.getCell(37);
						 if (R22cell30 != null) {
						 R22cell30.setCellValue(BRF56a.getR32_nos14() == null ? 0 :
						 BRF56a.getR32_nos14().intValue());
						       	 }	
						 
						 Cell R22cell31 = R22row.getCell(38);
						 if (R22cell31 != null) {
						 R22cell31.setCellValue(BRF56a.getR32_amount14() == null ? 0 :
						 BRF56a.getR32_amount14().intValue());
						       	 }
								 

						    /////////////////////R33/////////////////////////
							
						 Row R23row = sheet.getRow(41);
						 
						 Cell R23cell1 = R23row.getCell(4);
						 if (R23cell1 != null) {
						 R23cell1.setCellValue(BRF56a.getR33_male() == null ? 0 :
						 BRF56a.getR33_male().intValue());
						       	 }				 
								
						 Cell R23cell2 = R23row.getCell(5);
						 if (R23cell2 != null) {
						 R23cell2.setCellValue(BRF56a.getR33_female() == null ? 0 :
						 BRF56a.getR33_female().intValue());
						       	 }	
								
						 Cell R23cell4 = R23row.getCell(11);
						 if (R23cell4 != null) {
						 R23cell4.setCellValue(BRF56a.getR33_nos1() == null ? 0 :
						 BRF56a.getR33_nos1().intValue());
						       	 }	
						 
						 Cell R23cell5 = R23row.getCell(12);
						 if (R23cell5 != null) {
						 R23cell5.setCellValue(BRF56a.getR33_amount1() == null ? 0 :
						 BRF56a.getR33_amount1().intValue());
						       	 }	
							
						 Cell R23cell6 = R23row.getCell(13);
						 if (R23cell6 != null) {
						 R23cell6.setCellValue(BRF56a.getR33_nos2() == null ? 0 :
						 BRF56a.getR33_nos2().intValue());
						       	 }	
						 
						 Cell R23cell7 = R23row.getCell(14);
						 if (R23cell7 != null) {
						 R23cell7.setCellValue(BRF56a.getR33_amount2() == null ? 0 :
						 BRF56a.getR33_amount2().intValue());
						       	 }
						 
						 Cell R23cell8 = R23row.getCell(15);
						 if (R23cell8 != null) {
						 R23cell8.setCellValue(BRF56a.getR33_nos3() == null ? 0 :
						 BRF56a.getR33_nos3().intValue());
						       	 }	
						 
						 Cell R23cell9 = R23row.getCell(16);
						 if (R23cell9 != null) {
						 R23cell9.setCellValue(BRF56a.getR33_amount3() == null ? 0 :
						 BRF56a.getR33_amount3().intValue());
						       	 }
						 
						 Cell R23cell10 = R23row.getCell(17);
						 if (R23cell10 != null) {
						 R23cell10.setCellValue(BRF56a.getR33_nos4() == null ? 0 :
						 BRF56a.getR33_nos4().intValue());
						       	 }	
						 
						 Cell R23cell11 = R23row.getCell(18);
						 if (R23cell11 != null) {
						 R23cell11.setCellValue(BRF56a.getR33_amount4() == null ? 0 :
						 BRF56a.getR33_amount4().intValue());
						       	 }
						 
						 Cell R23cell12 = R23row.getCell(19);
						 if (R23cell12 != null) {
						 R23cell12.setCellValue(BRF56a.getR33_nos5() == null ? 0 :
						 BRF56a.getR33_nos5().intValue());
						       	 }	
						 
						 Cell R23cell13 = R23row.getCell(20);
						 if (R23cell13 != null) {
						 R23cell13.setCellValue(BRF56a.getR33_amount5() == null ? 0 :
						 BRF56a.getR33_amount5().intValue());
						       	 }
						 
						 Cell R23cell14 = R23row.getCell(21);
						 if (R23cell14 != null) {
						 R23cell14.setCellValue(BRF56a.getR33_nos6() == null ? 0 :
						 BRF56a.getR33_nos6().intValue());
						       	 }	
						 
						 Cell R23cell15 = R23row.getCell(22);
						 if (R23cell15 != null) {
						 R23cell15.setCellValue(BRF56a.getR33_amount6() == null ? 0 :
						 BRF56a.getR33_amount6().intValue());
						       	 }
						 
						 Cell R23cell16 = R23row.getCell(23);
						 if (R23cell16 != null) {
						 R23cell16.setCellValue(BRF56a.getR33_nos7() == null ? 0 :
						 BRF56a.getR33_nos7().intValue());
						       	 }	
						 
						 Cell R23cell17 = R23row.getCell(24);
						 if (R23cell17 != null) {
						 R23cell17.setCellValue(BRF56a.getR33_amount7() == null ? 0 :
						 BRF56a.getR33_amount7().intValue());
						       	 }
						 
						 Cell R23cell18 = R23row.getCell(25);
						 if (R23cell18 != null) {
						 R23cell18.setCellValue(BRF56a.getR33_nos8() == null ? 0 :
						 BRF56a.getR33_nos8().intValue());
						       	 }	
						 
						 Cell R23cell19 = R23row.getCell(26);
						 if (R23cell19 != null) {
						 R23cell19.setCellValue(BRF56a.getR33_amount8() == null ? 0 :
						 BRF56a.getR33_amount8().intValue());
						       	 }
						 
						 Cell R23cell20 = R23row.getCell(27);
						 if (R23cell20 != null) {
						 R23cell20.setCellValue(BRF56a.getR33_nos9() == null ? 0 :
						 BRF56a.getR33_nos9().intValue());
						       	 }	
						 
						 Cell R23cell21 = R23row.getCell(28);
						 if (R23cell21 != null) {
						 R23cell21.setCellValue(BRF56a.getR33_amount9() == null ? 0 :
						 BRF56a.getR33_amount9().intValue());
						       	 }
						 
						 Cell R23cell22 = R23row.getCell(29);
						 if (R23cell22 != null) {
						 R23cell22.setCellValue(BRF56a.getR33_nos10() == null ? 0 :
						 BRF56a.getR33_nos10().intValue());
						       	 }	
						 
						 Cell R23cell23 = R23row.getCell(30);
						 if (R23cell23 != null) {
						 R23cell23.setCellValue(BRF56a.getR33_amount10() == null ? 0 :
						 BRF56a.getR33_amount10().intValue());
						       	 }
						 
						 Cell R23cell24 = R23row.getCell(31);
						 if (R23cell24 != null) {
						 R23cell24.setCellValue(BRF56a.getR33_nos11() == null ? 0 :
						 BRF56a.getR33_nos11().intValue());
						       	 }	
						 
						 Cell R23cell25 = R23row.getCell(32);
						 if (R23cell25 != null) {
						 R23cell25.setCellValue(BRF56a.getR33_amount11() == null ? 0 :
						 BRF56a.getR33_amount11().intValue());
						       	 }
						 
						 Cell R23cell26 = R23row.getCell(33);
						 if (R23cell26 != null) {
						 R23cell26.setCellValue(BRF56a.getR33_nos12() == null ? 0 :
						 BRF56a.getR33_nos12().intValue());
						       	 }	
						 
						 Cell R23cell27 = R23row.getCell(34);
						 if (R23cell27 != null) {
						 R23cell27.setCellValue(BRF56a.getR33_amount12() == null ? 0 :
						 BRF56a.getR33_amount12().intValue());
						       	 }
						 
						 Cell R23cell28 = R23row.getCell(35);
						 if (R23cell28 != null) {
						 R23cell28.setCellValue(BRF56a.getR33_nos13() == null ? 0 :
						 BRF56a.getR33_nos13().intValue());
						       	 }	
						 
						 Cell R23cell29 = R23row.getCell(36);
						 if (R23cell29 != null) {
						 R23cell29.setCellValue(BRF56a.getR33_amount13() == null ? 0 :
						 BRF56a.getR33_amount13().intValue());
						       	 }
						 
						 Cell R23cell30 = R23row.getCell(37);
						 if (R23cell30 != null) {
						 R23cell30.setCellValue(BRF56a.getR33_nos14() == null ? 0 :
						 BRF56a.getR33_nos14().intValue());
						       	 }	
						 
						 Cell R23cell31 = R23row.getCell(38);
						 if (R23cell31 != null) {
						 R23cell31.setCellValue(BRF56a.getR33_amount14() == null ? 0 :
						 BRF56a.getR33_amount14().intValue());
						       	 }
								 

						    /////////////////////R34/////////////////////////
							
						 Row R24row = sheet.getRow(42);
						 
						 Cell R24cell1 = R24row.getCell(4);
						 if (R24cell1 != null) {
						 R24cell1.setCellValue(BRF56a.getR34_male() == null ? 0 :
						 BRF56a.getR34_male().intValue());
						       	 }				 
								
						 Cell R24cell2 = R24row.getCell(5);
						 if (R24cell2 != null) {
						 R24cell2.setCellValue(BRF56a.getR34_female() == null ? 0 :
						 BRF56a.getR34_female().intValue());
						       	 }	
								
						 Cell R24cell4 = R24row.getCell(11);
						 if (R24cell4 != null) {
						 R24cell4.setCellValue(BRF56a.getR34_nos1() == null ? 0 :
						 BRF56a.getR34_nos1().intValue());
						       	 }	
						 
						 Cell R24cell5 = R24row.getCell(12);
						 if (R24cell5 != null) {
						 R24cell5.setCellValue(BRF56a.getR34_amount1() == null ? 0 :
						 BRF56a.getR34_amount1().intValue());
						       	 }	
							
						 Cell R24cell6 = R24row.getCell(13);
						 if (R24cell6 != null) {
						 R24cell6.setCellValue(BRF56a.getR34_nos2() == null ? 0 :
						 BRF56a.getR34_nos2().intValue());
						       	 }	
						 
						 Cell R24cell7 = R24row.getCell(14);
						 if (R24cell7 != null) {
						 R24cell7.setCellValue(BRF56a.getR34_amount2() == null ? 0 :
						 BRF56a.getR34_amount2().intValue());
						       	 }
						 
						 Cell R24cell8 = R24row.getCell(15);
						 if (R24cell8 != null) {
						 R24cell8.setCellValue(BRF56a.getR34_nos3() == null ? 0 :
						 BRF56a.getR34_nos3().intValue());
						       	 }	
						 
						 Cell R24cell9 = R24row.getCell(16);
						 if (R24cell9 != null) {
						 R24cell9.setCellValue(BRF56a.getR34_amount3() == null ? 0 :
						 BRF56a.getR34_amount3().intValue());
						       	 }
						 
						 Cell R24cell10 = R24row.getCell(17);
						 if (R24cell10 != null) {
						 R24cell10.setCellValue(BRF56a.getR34_nos4() == null ? 0 :
						 BRF56a.getR34_nos4().intValue());
						       	 }	
						 
						 Cell R24cell11 = R24row.getCell(18);
						 if (R24cell11 != null) {
						 R24cell11.setCellValue(BRF56a.getR34_amount4() == null ? 0 :
						 BRF56a.getR34_amount4().intValue());
						       	 }
						 
						 Cell R24cell12 = R24row.getCell(19);
						 if (R24cell12 != null) {
						 R24cell12.setCellValue(BRF56a.getR34_nos5() == null ? 0 :
						 BRF56a.getR34_nos5().intValue());
						       	 }	
						 
						 Cell R24cell13 = R24row.getCell(20);
						 if (R24cell13 != null) {
						 R24cell13.setCellValue(BRF56a.getR34_amount5() == null ? 0 :
						 BRF56a.getR34_amount5().intValue());
						       	 }
						 
						 Cell R24cell14 = R24row.getCell(21);
						 if (R24cell14 != null) {
						 R24cell14.setCellValue(BRF56a.getR34_nos6() == null ? 0 :
						 BRF56a.getR34_nos6().intValue());
						       	 }	
						 
						 Cell R24cell15 = R24row.getCell(22);
						 if (R24cell15 != null) {
						 R24cell15.setCellValue(BRF56a.getR34_amount6() == null ? 0 :
						 BRF56a.getR34_amount6().intValue());
						       	 }
						 
						 Cell R24cell16 = R24row.getCell(23);
						 if (R24cell16 != null) {
						 R24cell16.setCellValue(BRF56a.getR34_nos7() == null ? 0 :
						 BRF56a.getR34_nos7().intValue());
						       	 }	
						 
						 Cell R24cell17 = R24row.getCell(24);
						 if (R24cell17 != null) {
						 R24cell17.setCellValue(BRF56a.getR34_amount7() == null ? 0 :
						 BRF56a.getR34_amount7().intValue());
						       	 }
						 
						 Cell R24cell18 = R24row.getCell(25);
						 if (R24cell18 != null) {
						 R24cell18.setCellValue(BRF56a.getR34_nos8() == null ? 0 :
						 BRF56a.getR34_nos8().intValue());
						       	 }	
						 
						 Cell R24cell19 = R24row.getCell(26);
						 if (R24cell19 != null) {
						 R24cell19.setCellValue(BRF56a.getR34_amount8() == null ? 0 :
						 BRF56a.getR34_amount8().intValue());
						       	 }
						 
						 Cell R24cell20 = R24row.getCell(27);
						 if (R24cell20 != null) {
						 R24cell20.setCellValue(BRF56a.getR34_nos9() == null ? 0 :
						 BRF56a.getR34_nos9().intValue());
						       	 }	
						 
						 Cell R24cell21 = R24row.getCell(28);
						 if (R24cell21 != null) {
						 R24cell21.setCellValue(BRF56a.getR34_amount9() == null ? 0 :
						 BRF56a.getR34_amount9().intValue());
						       	 }
						 
						 Cell R24cell22 = R24row.getCell(29);
						 if (R24cell22 != null) {
						 R24cell22.setCellValue(BRF56a.getR34_nos10() == null ? 0 :
						 BRF56a.getR34_nos10().intValue());
						       	 }	
						 
						 Cell R24cell23 = R24row.getCell(30);
						 if (R24cell23 != null) {
						 R24cell23.setCellValue(BRF56a.getR34_amount10() == null ? 0 :
						 BRF56a.getR34_amount10().intValue());
						       	 }
						 
						 Cell R24cell24 = R24row.getCell(31);
						 if (R24cell24 != null) {
						 R24cell24.setCellValue(BRF56a.getR34_nos11() == null ? 0 :
						 BRF56a.getR34_nos11().intValue());
						       	 }	
						 
						 Cell R24cell25 = R24row.getCell(32);
						 if (R24cell25 != null) {
						 R24cell25.setCellValue(BRF56a.getR34_amount11() == null ? 0 :
						 BRF56a.getR34_amount11().intValue());
						       	 }
						 
						 Cell R24cell26 = R24row.getCell(33);
						 if (R24cell26 != null) {
						 R24cell26.setCellValue(BRF56a.getR34_nos12() == null ? 0 :
						 BRF56a.getR34_nos12().intValue());
						       	 }	
						 
						 Cell R24cell27 = R24row.getCell(34);
						 if (R24cell27 != null) {
						 R24cell27.setCellValue(BRF56a.getR34_amount12() == null ? 0 :
						 BRF56a.getR34_amount12().intValue());
						       	 }
						 
						 Cell R24cell28 = R24row.getCell(35);
						 if (R24cell28 != null) {
						 R24cell28.setCellValue(BRF56a.getR34_nos13() == null ? 0 :
						 BRF56a.getR34_nos13().intValue());
						       	 }	
						 
						 Cell R24cell29 = R24row.getCell(36);
						 if (R24cell29 != null) {
						 R24cell29.setCellValue(BRF56a.getR34_amount13() == null ? 0 :
						 BRF56a.getR34_amount13().intValue());
						       	 }
						 
						 Cell R24cell30 = R24row.getCell(37);
						 if (R24cell30 != null) {
						 R24cell30.setCellValue(BRF56a.getR34_nos14() == null ? 0 :
						 BRF56a.getR34_nos14().intValue());
						       	 }	
						 
						 Cell R24cell31 = R24row.getCell(38);
						 if (R24cell31 != null) {
						 R24cell31.setCellValue(BRF56a.getR34_amount14() == null ? 0 :
						 BRF56a.getR34_amount14().intValue());
						       	 }
								 

						    /////////////////////R36/////////////////////////
							
						 Row R25row = sheet.getRow(44);
						 
						 Cell R25cell1 = R25row.getCell(4);
						 if (R25cell1 != null) {
						 R25cell1.setCellValue(BRF56a.getR36_male() == null ? 0 :
						 BRF56a.getR36_male().intValue());
						       	 }				 
								
						 Cell R25cell2 = R25row.getCell(5);
						 if (R25cell2 != null) {
						 R25cell2.setCellValue(BRF56a.getR36_female() == null ? 0 :
						 BRF56a.getR36_female().intValue());
						       	 }	
								
						 Cell R25cell4 = R25row.getCell(11);
						 if (R25cell4 != null) {
						 R25cell4.setCellValue(BRF56a.getR36_nos1() == null ? 0 :
						 BRF56a.getR36_nos1().intValue());
						       	 }	
						 
						 Cell R25cell5 = R25row.getCell(12);
						 if (R25cell5 != null) {
						 R25cell5.setCellValue(BRF56a.getR36_amount1() == null ? 0 :
						 BRF56a.getR36_amount1().intValue());
						       	 }	
							
						 Cell R25cell6 = R25row.getCell(13);
						 if (R25cell6 != null) {
						 R25cell6.setCellValue(BRF56a.getR36_nos2() == null ? 0 :
						 BRF56a.getR36_nos2().intValue());
						       	 }	
						 
						 Cell R25cell7 = R25row.getCell(14);
						 if (R25cell7 != null) {
						 R25cell7.setCellValue(BRF56a.getR36_amount2() == null ? 0 :
						 BRF56a.getR36_amount2().intValue());
						       	 }
						 
						 Cell R25cell8 = R25row.getCell(15);
						 if (R25cell8 != null) {
						 R25cell8.setCellValue(BRF56a.getR36_nos3() == null ? 0 :
						 BRF56a.getR36_nos3().intValue());
						       	 }	
						 
						 Cell R25cell9 = R25row.getCell(16);
						 if (R25cell9 != null) {
						 R25cell9.setCellValue(BRF56a.getR36_amount3() == null ? 0 :
						 BRF56a.getR36_amount3().intValue());
						       	 }
						 
						 Cell R25cell10 = R25row.getCell(17);
						 if (R25cell10 != null) {
						 R25cell10.setCellValue(BRF56a.getR36_nos4() == null ? 0 :
						 BRF56a.getR36_nos4().intValue());
						       	 }	
						 
						 Cell R25cell11 = R25row.getCell(18);
						 if (R25cell11 != null) {
						 R25cell11.setCellValue(BRF56a.getR36_amount4() == null ? 0 :
						 BRF56a.getR36_amount4().intValue());
						       	 }
						 
						 Cell R25cell12 = R25row.getCell(19);
						 if (R25cell12 != null) {
						 R25cell12.setCellValue(BRF56a.getR36_nos5() == null ? 0 :
						 BRF56a.getR36_nos5().intValue());
						       	 }	
						 
						 Cell R25cell13 = R25row.getCell(20);
						 if (R25cell13 != null) {
						 R25cell13.setCellValue(BRF56a.getR36_amount5() == null ? 0 :
						 BRF56a.getR36_amount5().intValue());
						       	 }
						 
						 Cell R25cell14 = R25row.getCell(21);
						 if (R25cell14 != null) {
						 R25cell14.setCellValue(BRF56a.getR36_nos6() == null ? 0 :
						 BRF56a.getR36_nos6().intValue());
						       	 }	
						 
						 Cell R25cell15 = R25row.getCell(22);
						 if (R25cell15 != null) {
						 R25cell15.setCellValue(BRF56a.getR36_amount6() == null ? 0 :
						 BRF56a.getR36_amount6().intValue());
						       	 }
						 
						 Cell R25cell16 = R25row.getCell(23);
						 if (R25cell16 != null) {
						 R25cell16.setCellValue(BRF56a.getR36_nos7() == null ? 0 :
						 BRF56a.getR36_nos7().intValue());
						       	 }	
						 
						 Cell R25cell17 = R25row.getCell(24);
						 if (R25cell17 != null) {
						 R25cell17.setCellValue(BRF56a.getR36_amount7() == null ? 0 :
						 BRF56a.getR36_amount7().intValue());
						       	 }
						 
						 Cell R25cell18 = R25row.getCell(25);
						 if (R25cell18 != null) {
						 R25cell18.setCellValue(BRF56a.getR36_nos8() == null ? 0 :
						 BRF56a.getR36_nos8().intValue());
						       	 }	
						 
						 Cell R25cell19 = R25row.getCell(26);
						 if (R25cell19 != null) {
						 R25cell19.setCellValue(BRF56a.getR36_amount8() == null ? 0 :
						 BRF56a.getR36_amount8().intValue());
						       	 }
						 
						 Cell R25cell20 = R25row.getCell(27);
						 if (R25cell20 != null) {
						 R25cell20.setCellValue(BRF56a.getR36_nos9() == null ? 0 :
						 BRF56a.getR36_nos9().intValue());
						       	 }	
						 
						 Cell R25cell21 = R25row.getCell(28);
						 if (R25cell21 != null) {
						 R25cell21.setCellValue(BRF56a.getR36_amount9() == null ? 0 :
						 BRF56a.getR36_amount9().intValue());
						       	 }
						 
						 Cell R25cell22 = R25row.getCell(29);
						 if (R25cell22 != null) {
						 R25cell22.setCellValue(BRF56a.getR36_nos10() == null ? 0 :
						 BRF56a.getR36_nos10().intValue());
						       	 }	
						 
						 Cell R25cell23 = R25row.getCell(30);
						 if (R25cell23 != null) {
						 R25cell23.setCellValue(BRF56a.getR36_amount10() == null ? 0 :
						 BRF56a.getR36_amount10().intValue());
						       	 }
						 
						 Cell R25cell24 = R25row.getCell(31);
						 if (R25cell24 != null) {
						 R25cell24.setCellValue(BRF56a.getR36_nos11() == null ? 0 :
						 BRF56a.getR36_nos11().intValue());
						       	 }	
						 
						 Cell R25cell25 = R25row.getCell(32);
						 if (R25cell25 != null) {
						 R25cell25.setCellValue(BRF56a.getR36_amount11() == null ? 0 :
						 BRF56a.getR36_amount11().intValue());
						       	 }
						 
						 Cell R25cell26 = R25row.getCell(33);
						 if (R25cell26 != null) {
						 R25cell26.setCellValue(BRF56a.getR36_nos12() == null ? 0 :
						 BRF56a.getR36_nos12().intValue());
						       	 }	
						 
						 Cell R25cell27 = R25row.getCell(34);
						 if (R25cell27 != null) {
						 R25cell27.setCellValue(BRF56a.getR36_amount12() == null ? 0 :
						 BRF56a.getR36_amount12().intValue());
						       	 }
						 
						 Cell R25cell28 = R25row.getCell(35);
						 if (R25cell28 != null) {
						 R25cell28.setCellValue(BRF56a.getR36_nos13() == null ? 0 :
						 BRF56a.getR36_nos13().intValue());
						       	 }	
						 
						 Cell R25cell29 = R25row.getCell(36);
						 if (R25cell29 != null) {
						 R25cell29.setCellValue(BRF56a.getR36_amount13() == null ? 0 :
						 BRF56a.getR36_amount13().intValue());
						       	 }
						 
						 Cell R25cell30 = R25row.getCell(37);
						 if (R25cell30 != null) {
						 R25cell30.setCellValue(BRF56a.getR36_nos14() == null ? 0 :
						 BRF56a.getR36_nos14().intValue());
						       	 }	
						 
						 Cell R25cell31 = R25row.getCell(38);
						 if (R25cell31 != null) {
						 R25cell31.setCellValue(BRF56a.getR36_amount14() == null ? 0 :
						 BRF56a.getR36_amount14().intValue());
						       	 }
								 

						    /////////////////////R37/////////////////////////
							
						 Row R26row = sheet.getRow(45);
						 
						 Cell R26cell1 = R26row.getCell(4);
						 if (R26cell1 != null) {
						 R26cell1.setCellValue(BRF56a.getR37_male() == null ? 0 :
						 BRF56a.getR37_male().intValue());
						       	 }				 
								
						 Cell R26cell2 = R26row.getCell(5);
						 if (R26cell2 != null) {
						 R26cell2.setCellValue(BRF56a.getR37_female() == null ? 0 :
						 BRF56a.getR37_female().intValue());
						       	 }	
								
						 Cell R26cell4 = R26row.getCell(11);
						 if (R26cell4 != null) {
						 R26cell4.setCellValue(BRF56a.getR37_nos1() == null ? 0 :
						 BRF56a.getR37_nos1().intValue());
						       	 }	
						 
						 Cell R26cell5 = R26row.getCell(12);
						 if (R26cell5 != null) {
						 R26cell5.setCellValue(BRF56a.getR37_amount1() == null ? 0 :
						 BRF56a.getR37_amount1().intValue());
						       	 }	
							
						 Cell R26cell6 = R26row.getCell(13);
						 if (R26cell6 != null) {
						 R26cell6.setCellValue(BRF56a.getR37_nos2() == null ? 0 :
						 BRF56a.getR37_nos2().intValue());
						       	 }	
						 
						 Cell R26cell7 = R26row.getCell(14);
						 if (R26cell7 != null) {
						 R26cell7.setCellValue(BRF56a.getR37_amount2() == null ? 0 :
						 BRF56a.getR37_amount2().intValue());
						       	 }
						 
						 Cell R26cell8 = R26row.getCell(15);
						 if (R26cell8 != null) {
						 R26cell8.setCellValue(BRF56a.getR37_nos3() == null ? 0 :
						 BRF56a.getR37_nos3().intValue());
						       	 }	
						 
						 Cell R26cell9 = R26row.getCell(16);
						 if (R26cell9 != null) {
						 R26cell9.setCellValue(BRF56a.getR37_amount3() == null ? 0 :
						 BRF56a.getR37_amount3().intValue());
						       	 }
						 
						 Cell R26cell10 = R26row.getCell(17);
						 if (R26cell10 != null) {
						 R26cell10.setCellValue(BRF56a.getR37_nos4() == null ? 0 :
						 BRF56a.getR37_nos4().intValue());
						       	 }	
						 
						 Cell R26cell11 = R26row.getCell(18);
						 if (R26cell11 != null) {
						 R26cell11.setCellValue(BRF56a.getR37_amount4() == null ? 0 :
						 BRF56a.getR37_amount4().intValue());
						       	 }
						 
						 Cell R26cell12 = R26row.getCell(19);
						 if (R26cell12 != null) {
						 R26cell12.setCellValue(BRF56a.getR37_nos5() == null ? 0 :
						 BRF56a.getR37_nos5().intValue());
						       	 }	
						 
						 Cell R26cell13 = R26row.getCell(20);
						 if (R26cell13 != null) {
						 R26cell13.setCellValue(BRF56a.getR37_amount5() == null ? 0 :
						 BRF56a.getR37_amount5().intValue());
						       	 }
						 
						 Cell R26cell14 = R26row.getCell(21);
						 if (R26cell14 != null) {
						 R26cell14.setCellValue(BRF56a.getR37_nos6() == null ? 0 :
						 BRF56a.getR37_nos6().intValue());
						       	 }	
						 
						 Cell R26cell15 = R26row.getCell(22);
						 if (R26cell15 != null) {
						 R26cell15.setCellValue(BRF56a.getR37_amount6() == null ? 0 :
						 BRF56a.getR37_amount6().intValue());
						       	 }
						 
						 Cell R26cell16 = R26row.getCell(23);
						 if (R26cell16 != null) {
						 R26cell16.setCellValue(BRF56a.getR37_nos7() == null ? 0 :
						 BRF56a.getR37_nos7().intValue());
						       	 }	
						 
						 Cell R26cell17 = R26row.getCell(24);
						 if (R26cell17 != null) {
						 R26cell17.setCellValue(BRF56a.getR37_amount7() == null ? 0 :
						 BRF56a.getR37_amount7().intValue());
						       	 }
						 
						 Cell R26cell18 = R26row.getCell(25);
						 if (R26cell18 != null) {
						 R26cell18.setCellValue(BRF56a.getR37_nos8() == null ? 0 :
						 BRF56a.getR37_nos8().intValue());
						       	 }	
						 
						 Cell R26cell19 = R26row.getCell(26);
						 if (R26cell19 != null) {
						 R26cell19.setCellValue(BRF56a.getR37_amount8() == null ? 0 :
						 BRF56a.getR37_amount8().intValue());
						       	 }
						 
						 Cell R26cell20 = R26row.getCell(27);
						 if (R26cell20 != null) {
						 R26cell20.setCellValue(BRF56a.getR37_nos9() == null ? 0 :
						 BRF56a.getR37_nos9().intValue());
						       	 }	
						 
						 Cell R26cell21 = R26row.getCell(28);
						 if (R26cell21 != null) {
						 R26cell21.setCellValue(BRF56a.getR37_amount9() == null ? 0 :
						 BRF56a.getR37_amount9().intValue());
						       	 }
						 
						 Cell R26cell22 = R26row.getCell(29);
						 if (R26cell22 != null) {
						 R26cell22.setCellValue(BRF56a.getR37_nos10() == null ? 0 :
						 BRF56a.getR37_nos10().intValue());
						       	 }	
						 
						 Cell R26cell23 = R26row.getCell(30);
						 if (R26cell23 != null) {
						 R26cell23.setCellValue(BRF56a.getR37_amount10() == null ? 0 :
						 BRF56a.getR37_amount10().intValue());
						       	 }
						 
						 Cell R26cell24 = R26row.getCell(31);
						 if (R26cell24 != null) {
						 R26cell24.setCellValue(BRF56a.getR37_nos11() == null ? 0 :
						 BRF56a.getR37_nos11().intValue());
						       	 }	
						 
						 Cell R26cell25 = R26row.getCell(32);
						 if (R26cell25 != null) {
						 R26cell25.setCellValue(BRF56a.getR37_amount11() == null ? 0 :
						 BRF56a.getR37_amount11().intValue());
						       	 }
						 
						 Cell R26cell26 = R26row.getCell(33);
						 if (R26cell26 != null) {
						 R26cell26.setCellValue(BRF56a.getR37_nos12() == null ? 0 :
						 BRF56a.getR37_nos12().intValue());
						       	 }	
						 
						 Cell R26cell27 = R26row.getCell(34);
						 if (R26cell27 != null) {
						 R26cell27.setCellValue(BRF56a.getR37_amount12() == null ? 0 :
						 BRF56a.getR37_amount12().intValue());
						       	 }
						 
						 Cell R26cell28 = R26row.getCell(35);
						 if (R26cell28 != null) {
						 R26cell28.setCellValue(BRF56a.getR37_nos13() == null ? 0 :
						 BRF56a.getR37_nos13().intValue());
						       	 }	
						 
						 Cell R26cell29 = R26row.getCell(36);
						 if (R26cell29 != null) {
						 R26cell29.setCellValue(BRF56a.getR37_amount13() == null ? 0 :
						 BRF56a.getR37_amount13().intValue());
						       	 }
						 
						 Cell R26cell30 = R26row.getCell(37);
						 if (R26cell30 != null) {
						 R26cell30.setCellValue(BRF56a.getR37_nos14() == null ? 0 :
						 BRF56a.getR37_nos14().intValue());
						       	 }	
						 
						 Cell R26cell31 = R26row.getCell(38);
						 if (R26cell31 != null) {
						 R26cell31.setCellValue(BRF56a.getR37_amount14() == null ? 0 :
						 BRF56a.getR37_amount14().intValue());
						       	 }
								 

						    /////////////////////R38/////////////////////////
							
						 Row R27row = sheet.getRow(46);
						 
						 Cell R27cell1 = R27row.getCell(4);
						 if (R27cell1 != null) {
						 R27cell1.setCellValue(BRF56a.getR38_male() == null ? 0 :
						 BRF56a.getR38_male().intValue());
						       	 }				 
								
						 Cell R27cell2 = R27row.getCell(5);
						 if (R27cell2 != null) {
						 R27cell2.setCellValue(BRF56a.getR38_female() == null ? 0 :
						 BRF56a.getR38_female().intValue());
						       	 }	
								
						 Cell R27cell4 = R27row.getCell(11);
						 if (R27cell4 != null) {
						 R27cell4.setCellValue(BRF56a.getR38_nos1() == null ? 0 :
						 BRF56a.getR38_nos1().intValue());
						       	 }	
						 
						 Cell R27cell5 = R27row.getCell(12);
						 if (R27cell5 != null) {
						 R27cell5.setCellValue(BRF56a.getR38_amount1() == null ? 0 :
						 BRF56a.getR38_amount1().intValue());
						       	 }	
							
						 Cell R27cell6 = R27row.getCell(13);
						 if (R27cell6 != null) {
						 R27cell6.setCellValue(BRF56a.getR38_nos2() == null ? 0 :
						 BRF56a.getR38_nos2().intValue());
						       	 }	
						 
						 Cell R27cell7 = R27row.getCell(14);
						 if (R27cell7 != null) {
						 R27cell7.setCellValue(BRF56a.getR38_amount2() == null ? 0 :
						 BRF56a.getR38_amount2().intValue());
						       	 }
						 
						 Cell R27cell8 = R27row.getCell(15);
						 if (R27cell8 != null) {
						 R27cell8.setCellValue(BRF56a.getR38_nos3() == null ? 0 :
						 BRF56a.getR38_nos3().intValue());
						       	 }	
						 
						 Cell R27cell9 = R27row.getCell(16);
						 if (R27cell9 != null) {
						 R27cell9.setCellValue(BRF56a.getR38_amount3() == null ? 0 :
						 BRF56a.getR38_amount3().intValue());
						       	 }
						 
						 Cell R27cell10 = R27row.getCell(17);
						 if (R27cell10 != null) {
						 R27cell10.setCellValue(BRF56a.getR38_nos4() == null ? 0 :
						 BRF56a.getR38_nos4().intValue());
						       	 }	
						 
						 Cell R27cell11 = R27row.getCell(18);
						 if (R27cell11 != null) {
						 R27cell11.setCellValue(BRF56a.getR38_amount4() == null ? 0 :
						 BRF56a.getR38_amount4().intValue());
						       	 }
						 
						 Cell R27cell12 = R27row.getCell(19);
						 if (R27cell12 != null) {
						 R27cell12.setCellValue(BRF56a.getR38_nos5() == null ? 0 :
						 BRF56a.getR38_nos5().intValue());
						       	 }	
						 
						 Cell R27cell13 = R27row.getCell(20);
						 if (R27cell13 != null) {
						 R27cell13.setCellValue(BRF56a.getR38_amount5() == null ? 0 :
						 BRF56a.getR38_amount5().intValue());
						       	 }
						 
						 Cell R27cell14 = R27row.getCell(21);
						 if (R27cell14 != null) {
						 R27cell14.setCellValue(BRF56a.getR38_nos6() == null ? 0 :
						 BRF56a.getR38_nos6().intValue());
						       	 }	
						 
						 Cell R27cell15 = R27row.getCell(22);
						 if (R27cell15 != null) {
						 R27cell15.setCellValue(BRF56a.getR38_amount6() == null ? 0 :
						 BRF56a.getR38_amount6().intValue());
						       	 }
						 
						 Cell R27cell16 = R27row.getCell(23);
						 if (R27cell16 != null) {
						 R27cell16.setCellValue(BRF56a.getR38_nos7() == null ? 0 :
						 BRF56a.getR38_nos7().intValue());
						       	 }	
						 
						 Cell R27cell17 = R27row.getCell(24);
						 if (R27cell17 != null) {
						 R27cell17.setCellValue(BRF56a.getR38_amount7() == null ? 0 :
						 BRF56a.getR38_amount7().intValue());
						       	 }
						 
						 Cell R27cell18 = R27row.getCell(25);
						 if (R27cell18 != null) {
						 R27cell18.setCellValue(BRF56a.getR38_nos8() == null ? 0 :
						 BRF56a.getR38_nos8().intValue());
						       	 }	
						 
						 Cell R27cell19 = R27row.getCell(26);
						 if (R27cell19 != null) {
						 R27cell19.setCellValue(BRF56a.getR38_amount8() == null ? 0 :
						 BRF56a.getR38_amount8().intValue());
						       	 }
						 
						 Cell R27cell20 = R27row.getCell(27);
						 if (R27cell20 != null) {
						 R27cell20.setCellValue(BRF56a.getR38_nos9() == null ? 0 :
						 BRF56a.getR38_nos9().intValue());
						       	 }	
						 
						 Cell R27cell21 = R27row.getCell(28);
						 if (R27cell21 != null) {
						 R27cell21.setCellValue(BRF56a.getR38_amount9() == null ? 0 :
						 BRF56a.getR38_amount9().intValue());
						       	 }
						 
						 Cell R27cell22 = R27row.getCell(29);
						 if (R27cell22 != null) {
						 R27cell22.setCellValue(BRF56a.getR38_nos10() == null ? 0 :
						 BRF56a.getR38_nos10().intValue());
						       	 }	
						 
						 Cell R27cell23 = R27row.getCell(30);
						 if (R27cell23 != null) {
						 R27cell23.setCellValue(BRF56a.getR38_amount10() == null ? 0 :
						 BRF56a.getR38_amount10().intValue());
						       	 }
						 
						 Cell R27cell24 = R27row.getCell(31);
						 if (R27cell24 != null) {
						 R27cell24.setCellValue(BRF56a.getR38_nos11() == null ? 0 :
						 BRF56a.getR38_nos11().intValue());
						       	 }	
						 
						 Cell R27cell25 = R27row.getCell(32);
						 if (R27cell25 != null) {
						 R27cell25.setCellValue(BRF56a.getR38_amount11() == null ? 0 :
						 BRF56a.getR38_amount11().intValue());
						       	 }
						 
						 Cell R27cell26 = R27row.getCell(33);
						 if (R27cell26 != null) {
						 R27cell26.setCellValue(BRF56a.getR38_nos12() == null ? 0 :
						 BRF56a.getR38_nos12().intValue());
						       	 }	
						 
						 Cell R27cell27 = R27row.getCell(34);
						 if (R27cell27 != null) {
						 R27cell27.setCellValue(BRF56a.getR38_amount12() == null ? 0 :
						 BRF56a.getR38_amount12().intValue());
						       	 }
						 
						 Cell R27cell28 = R27row.getCell(35);
						 if (R27cell28 != null) {
						 R27cell28.setCellValue(BRF56a.getR38_nos13() == null ? 0 :
						 BRF56a.getR38_nos13().intValue());
						       	 }	
						 
						 Cell R27cell29 = R27row.getCell(36);
						 if (R27cell29 != null) {
						 R27cell29.setCellValue(BRF56a.getR38_amount13() == null ? 0 :
						 BRF56a.getR38_amount13().intValue());
						       	 }
						 
						 Cell R27cell30 = R27row.getCell(37);
						 if (R27cell30 != null) {
						 R27cell30.setCellValue(BRF56a.getR38_nos14() == null ? 0 :
						 BRF56a.getR38_nos14().intValue());
						       	 }	
						 
						 Cell R27cell31 = R27row.getCell(38);
						 if (R27cell31 != null) {
						 R27cell31.setCellValue(BRF56a.getR38_amount14() == null ? 0 :
						 BRF56a.getR38_amount14().intValue());
						       	 }
								 

						    /////////////////////R39/////////////////////////
							
						 Row R28row = sheet.getRow(47);
						 
						 Cell R28cell1 = R28row.getCell(4);
						 if (R28cell1 != null) {
						 R28cell1.setCellValue(BRF56a.getR39_male() == null ? 0 :
						 BRF56a.getR39_male().intValue());
						       	 }				 
								
						 Cell R28cell2 = R28row.getCell(5);
						 if (R28cell2 != null) {
						 R28cell2.setCellValue(BRF56a.getR39_female() == null ? 0 :
						 BRF56a.getR39_female().intValue());
						       	 }	
								
						 Cell R28cell4 = R28row.getCell(11);
						 if (R28cell4 != null) {
						 R28cell4.setCellValue(BRF56a.getR39_nos1() == null ? 0 :
						 BRF56a.getR39_nos1().intValue());
						       	 }	
						 
						 Cell R28cell5 = R28row.getCell(12);
						 if (R28cell5 != null) {
						 R28cell5.setCellValue(BRF56a.getR39_amount1() == null ? 0 :
						 BRF56a.getR39_amount1().intValue());
						       	 }	
							
						 Cell R28cell6 = R28row.getCell(13);
						 if (R28cell6 != null) {
						 R28cell6.setCellValue(BRF56a.getR39_nos2() == null ? 0 :
						 BRF56a.getR39_nos2().intValue());
						       	 }	
						 
						 Cell R28cell7 = R28row.getCell(14);
						 if (R28cell7 != null) {
						 R28cell7.setCellValue(BRF56a.getR39_amount2() == null ? 0 :
						 BRF56a.getR39_amount2().intValue());
						       	 }
						 
						 Cell R28cell8 = R28row.getCell(15);
						 if (R28cell8 != null) {
						 R28cell8.setCellValue(BRF56a.getR39_nos3() == null ? 0 :
						 BRF56a.getR39_nos3().intValue());
						       	 }	
						 
						 Cell R28cell9 = R28row.getCell(16);
						 if (R28cell9 != null) {
						 R28cell9.setCellValue(BRF56a.getR39_amount3() == null ? 0 :
						 BRF56a.getR39_amount3().intValue());
						       	 }
						 
						 Cell R28cell10 = R28row.getCell(17);
						 if (R28cell10 != null) {
						 R28cell10.setCellValue(BRF56a.getR39_nos4() == null ? 0 :
						 BRF56a.getR39_nos4().intValue());
						       	 }	
						 
						 Cell R28cell11 = R28row.getCell(18);
						 if (R28cell11 != null) {
						 R28cell11.setCellValue(BRF56a.getR39_amount4() == null ? 0 :
						 BRF56a.getR39_amount4().intValue());
						       	 }
						 
						 Cell R28cell12 = R28row.getCell(19);
						 if (R28cell12 != null) {
						 R28cell12.setCellValue(BRF56a.getR39_nos5() == null ? 0 :
						 BRF56a.getR39_nos5().intValue());
						       	 }	
						 
						 Cell R28cell13 = R28row.getCell(20);
						 if (R28cell13 != null) {
						 R28cell13.setCellValue(BRF56a.getR39_amount5() == null ? 0 :
						 BRF56a.getR39_amount5().intValue());
						       	 }
						 
						 Cell R28cell14 = R28row.getCell(21);
						 if (R28cell14 != null) {
						 R28cell14.setCellValue(BRF56a.getR39_nos6() == null ? 0 :
						 BRF56a.getR39_nos6().intValue());
						       	 }	
						 
						 Cell R28cell15 = R28row.getCell(22);
						 if (R28cell15 != null) {
						 R28cell15.setCellValue(BRF56a.getR39_amount6() == null ? 0 :
						 BRF56a.getR39_amount6().intValue());
						       	 }
						 
						 Cell R28cell16 = R28row.getCell(23);
						 if (R28cell16 != null) {
						 R28cell16.setCellValue(BRF56a.getR39_nos7() == null ? 0 :
						 BRF56a.getR39_nos7().intValue());
						       	 }	
						 
						 Cell R28cell17 = R28row.getCell(24);
						 if (R28cell17 != null) {
						 R28cell17.setCellValue(BRF56a.getR39_amount7() == null ? 0 :
						 BRF56a.getR39_amount7().intValue());
						       	 }
						 
						 Cell R28cell18 = R28row.getCell(25);
						 if (R28cell18 != null) {
						 R28cell18.setCellValue(BRF56a.getR39_nos8() == null ? 0 :
						 BRF56a.getR39_nos8().intValue());
						       	 }	
						 
						 Cell R28cell19 = R28row.getCell(26);
						 if (R28cell19 != null) {
						 R28cell19.setCellValue(BRF56a.getR39_amount8() == null ? 0 :
						 BRF56a.getR39_amount8().intValue());
						       	 }
						 
						 Cell R28cell20 = R28row.getCell(27);
						 if (R28cell20 != null) {
						 R28cell20.setCellValue(BRF56a.getR39_nos9() == null ? 0 :
						 BRF56a.getR39_nos9().intValue());
						       	 }	
						 
						 Cell R28cell21 = R28row.getCell(28);
						 if (R28cell21 != null) {
						 R28cell21.setCellValue(BRF56a.getR39_amount9() == null ? 0 :
						 BRF56a.getR39_amount9().intValue());
						       	 }
						 
						 Cell R28cell22 = R28row.getCell(29);
						 if (R28cell22 != null) {
						 R28cell22.setCellValue(BRF56a.getR39_nos10() == null ? 0 :
						 BRF56a.getR39_nos10().intValue());
						       	 }	
						 
						 Cell R28cell23 = R28row.getCell(30);
						 if (R28cell23 != null) {
						 R28cell23.setCellValue(BRF56a.getR39_amount10() == null ? 0 :
						 BRF56a.getR39_amount10().intValue());
						       	 }
						 
						 Cell R28cell24 = R28row.getCell(31);
						 if (R28cell24 != null) {
						 R28cell24.setCellValue(BRF56a.getR39_nos11() == null ? 0 :
						 BRF56a.getR39_nos11().intValue());
						       	 }	
						 
						 Cell R28cell25 = R28row.getCell(32);
						 if (R28cell25 != null) {
						 R28cell25.setCellValue(BRF56a.getR39_amount11() == null ? 0 :
						 BRF56a.getR39_amount11().intValue());
						       	 }
						 
						 Cell R28cell26 = R28row.getCell(33);
						 if (R28cell26 != null) {
						 R28cell26.setCellValue(BRF56a.getR39_nos12() == null ? 0 :
						 BRF56a.getR39_nos12().intValue());
						       	 }	
						 
						 Cell R28cell27 = R28row.getCell(34);
						 if (R28cell27 != null) {
						 R28cell27.setCellValue(BRF56a.getR39_amount12() == null ? 0 :
						 BRF56a.getR39_amount12().intValue());
						       	 }
						 
						 Cell R28cell28 = R28row.getCell(35);
						 if (R28cell28 != null) {
						 R28cell28.setCellValue(BRF56a.getR39_nos13() == null ? 0 :
						 BRF56a.getR39_nos13().intValue());
						       	 }	
						 
						 Cell R28cell29 = R28row.getCell(36);
						 if (R28cell29 != null) {
						 R28cell29.setCellValue(BRF56a.getR39_amount13() == null ? 0 :
						 BRF56a.getR39_amount13().intValue());
						       	 }
						 
						 Cell R28cell30 = R28row.getCell(37);
						 if (R28cell30 != null) {
						 R28cell30.setCellValue(BRF56a.getR39_nos14() == null ? 0 :
						 BRF56a.getR39_nos14().intValue());
						       	 }	
						 
						 Cell R28cell31 = R28row.getCell(38);
						 if (R28cell31 != null) {
						 R28cell31.setCellValue(BRF56a.getR39_amount14() == null ? 0 :
						 BRF56a.getR39_amount14().intValue());
						       	 }
								 

						    /////////////////////R40/////////////////////////
							
						 Row R29row = sheet.getRow(48);
						 
						 Cell R29cell1 = R29row.getCell(4);
						 if (R29cell1 != null) {
						 R29cell1.setCellValue(BRF56a.getR40_male() == null ? 0 :
						 BRF56a.getR40_male().intValue());
						       	 }				 
								
						 Cell R29cell2 = R29row.getCell(5);
						 if (R29cell2 != null) {
						 R29cell2.setCellValue(BRF56a.getR40_female() == null ? 0 :
						 BRF56a.getR40_female().intValue());
						       	 }	
								
						 Cell R29cell4 = R29row.getCell(11);
						 if (R29cell4 != null) {
						 R29cell4.setCellValue(BRF56a.getR40_nos1() == null ? 0 :
						 BRF56a.getR40_nos1().intValue());
						       	 }	
						 
						 Cell R29cell5 = R29row.getCell(12);
						 if (R29cell5 != null) {
						 R29cell5.setCellValue(BRF56a.getR40_amount1() == null ? 0 :
						 BRF56a.getR40_amount1().intValue());
						       	 }	
							
						 Cell R29cell6 = R29row.getCell(13);
						 if (R29cell6 != null) {
						 R29cell6.setCellValue(BRF56a.getR40_nos2() == null ? 0 :
						 BRF56a.getR40_nos2().intValue());
						       	 }	
						 
						 Cell R29cell7 = R29row.getCell(14);
						 if (R29cell7 != null) {
						 R29cell7.setCellValue(BRF56a.getR40_amount2() == null ? 0 :
						 BRF56a.getR40_amount2().intValue());
						       	 }
						 
						 Cell R29cell8 = R29row.getCell(15);
						 if (R29cell8 != null) {
						 R29cell8.setCellValue(BRF56a.getR40_nos3() == null ? 0 :
						 BRF56a.getR40_nos3().intValue());
						       	 }	
						 
						 Cell R29cell9 = R29row.getCell(16);
						 if (R29cell9 != null) {
						 R29cell9.setCellValue(BRF56a.getR40_amount3() == null ? 0 :
						 BRF56a.getR40_amount3().intValue());
						       	 }
						 
						 Cell R29cell10 = R29row.getCell(17);
						 if (R29cell10 != null) {
						 R29cell10.setCellValue(BRF56a.getR40_nos4() == null ? 0 :
						 BRF56a.getR40_nos4().intValue());
						       	 }	
						 
						 Cell R29cell11 = R29row.getCell(18);
						 if (R29cell11 != null) {
						 R29cell11.setCellValue(BRF56a.getR40_amount4() == null ? 0 :
						 BRF56a.getR40_amount4().intValue());
						       	 }
						 
						 Cell R29cell12 = R29row.getCell(19);
						 if (R29cell12 != null) {
						 R29cell12.setCellValue(BRF56a.getR40_nos5() == null ? 0 :
						 BRF56a.getR40_nos5().intValue());
						       	 }	
						 
						 Cell R29cell13 = R29row.getCell(20);
						 if (R29cell13 != null) {
						 R29cell13.setCellValue(BRF56a.getR40_amount5() == null ? 0 :
						 BRF56a.getR40_amount5().intValue());
						       	 }
						 
						 Cell R29cell14 = R29row.getCell(21);
						 if (R29cell14 != null) {
						 R29cell14.setCellValue(BRF56a.getR40_nos6() == null ? 0 :
						 BRF56a.getR40_nos6().intValue());
						       	 }	
						 
						 Cell R29cell15 = R29row.getCell(22);
						 if (R29cell15 != null) {
						 R29cell15.setCellValue(BRF56a.getR40_amount6() == null ? 0 :
						 BRF56a.getR40_amount6().intValue());
						       	 }
						 
						 Cell R29cell16 = R29row.getCell(23);
						 if (R29cell16 != null) {
						 R29cell16.setCellValue(BRF56a.getR40_nos7() == null ? 0 :
						 BRF56a.getR40_nos7().intValue());
						       	 }	
						 
						 Cell R29cell17 = R29row.getCell(24);
						 if (R29cell17 != null) {
						 R29cell17.setCellValue(BRF56a.getR40_amount7() == null ? 0 :
						 BRF56a.getR40_amount7().intValue());
						       	 }
						 
						 Cell R29cell18 = R29row.getCell(25);
						 if (R29cell18 != null) {
						 R29cell18.setCellValue(BRF56a.getR40_nos8() == null ? 0 :
						 BRF56a.getR40_nos8().intValue());
						       	 }	
						 
						 Cell R29cell19 = R29row.getCell(26);
						 if (R29cell19 != null) {
						 R29cell19.setCellValue(BRF56a.getR40_amount8() == null ? 0 :
						 BRF56a.getR40_amount8().intValue());
						       	 }
						 
						 Cell R29cell20 = R29row.getCell(27);
						 if (R29cell20 != null) {
						 R29cell20.setCellValue(BRF56a.getR40_nos9() == null ? 0 :
						 BRF56a.getR40_nos9().intValue());
						       	 }	
						 
						 Cell R29cell21 = R29row.getCell(28);
						 if (R29cell21 != null) {
						 R29cell21.setCellValue(BRF56a.getR40_amount9() == null ? 0 :
						 BRF56a.getR40_amount9().intValue());
						       	 }
						 
						 Cell R29cell22 = R29row.getCell(29);
						 if (R29cell22 != null) {
						 R29cell22.setCellValue(BRF56a.getR40_nos10() == null ? 0 :
						 BRF56a.getR40_nos10().intValue());
						       	 }	
						 
						 Cell R29cell23 = R29row.getCell(30);
						 if (R29cell23 != null) {
						 R29cell23.setCellValue(BRF56a.getR40_amount10() == null ? 0 :
						 BRF56a.getR40_amount10().intValue());
						       	 }
						 
						 Cell R29cell24 = R29row.getCell(31);
						 if (R29cell24 != null) {
						 R29cell24.setCellValue(BRF56a.getR40_nos11() == null ? 0 :
						 BRF56a.getR40_nos11().intValue());
						       	 }	
						 
						 Cell R29cell25 = R29row.getCell(32);
						 if (R29cell25 != null) {
						 R29cell25.setCellValue(BRF56a.getR40_amount11() == null ? 0 :
						 BRF56a.getR40_amount11().intValue());
						       	 }
						 
						 Cell R29cell26 = R29row.getCell(33);
						 if (R29cell26 != null) {
						 R29cell26.setCellValue(BRF56a.getR40_nos12() == null ? 0 :
						 BRF56a.getR40_nos12().intValue());
						       	 }	
						 
						 Cell R29cell27 = R29row.getCell(34);
						 if (R29cell27 != null) {
						 R29cell27.setCellValue(BRF56a.getR40_amount12() == null ? 0 :
						 BRF56a.getR40_amount12().intValue());
						       	 }
						 
						 Cell R29cell28 = R29row.getCell(35);
						 if (R29cell28 != null) {
						 R29cell28.setCellValue(BRF56a.getR40_nos13() == null ? 0 :
						 BRF56a.getR40_nos13().intValue());
						       	 }	
						 
						 Cell R29cell29 = R29row.getCell(36);
						 if (R29cell29 != null) {
						 R29cell29.setCellValue(BRF56a.getR40_amount13() == null ? 0 :
						 BRF56a.getR40_amount13().intValue());
						       	 }
						 
						 Cell R29cell30 = R29row.getCell(37);
						 if (R29cell30 != null) {
						 R29cell30.setCellValue(BRF56a.getR40_nos14() == null ? 0 :
						 BRF56a.getR40_nos14().intValue());
						       	 }	
						 
						 Cell R29cell31 = R29row.getCell(38);
						 if (R29cell31 != null) {
						 R29cell31.setCellValue(BRF56a.getR40_amount14() == null ? 0 :
						 BRF56a.getR40_amount14().intValue());
						       	 }
								 

						    /////////////////////R41/////////////////////////
							
						 Row R30row = sheet.getRow(49);
						 
						 Cell R30cell1 = R30row.getCell(4);
						 if (R30cell1 != null) {
						 R30cell1.setCellValue(BRF56a.getR41_male() == null ? 0 :
						 BRF56a.getR41_male().intValue());
						       	 }				 
								
						 Cell R30cell2 = R30row.getCell(5);
						 if (R30cell2 != null) {
						 R30cell2.setCellValue(BRF56a.getR41_female() == null ? 0 :
						 BRF56a.getR41_female().intValue());
						       	 }	
								
						 Cell R30cell4 = R30row.getCell(11);
						 if (R30cell4 != null) {
						 R30cell4.setCellValue(BRF56a.getR41_nos1() == null ? 0 :
						 BRF56a.getR41_nos1().intValue());
						       	 }	
						 
						 Cell R30cell5 = R30row.getCell(12);
						 if (R30cell5 != null) {
						 R30cell5.setCellValue(BRF56a.getR41_amount1() == null ? 0 :
						 BRF56a.getR41_amount1().intValue());
						       	 }	
							
						 Cell R30cell6 = R30row.getCell(13);
						 if (R30cell6 != null) {
						 R30cell6.setCellValue(BRF56a.getR41_nos2() == null ? 0 :
						 BRF56a.getR41_nos2().intValue());
						       	 }	
						 
						 Cell R30cell7 = R30row.getCell(14);
						 if (R30cell7 != null) {
						 R30cell7.setCellValue(BRF56a.getR41_amount2() == null ? 0 :
						 BRF56a.getR41_amount2().intValue());
						       	 }
						 
						 Cell R30cell8 = R30row.getCell(15);
						 if (R30cell8 != null) {
						 R30cell8.setCellValue(BRF56a.getR41_nos3() == null ? 0 :
						 BRF56a.getR41_nos3().intValue());
						       	 }	
						 
						 Cell R30cell9 = R30row.getCell(16);
						 if (R30cell9 != null) {
						 R30cell9.setCellValue(BRF56a.getR41_amount3() == null ? 0 :
						 BRF56a.getR41_amount3().intValue());
						       	 }
						 
						 Cell R30cell10 = R30row.getCell(17);
						 if (R30cell10 != null) {
						 R30cell10.setCellValue(BRF56a.getR41_nos4() == null ? 0 :
						 BRF56a.getR41_nos4().intValue());
						       	 }	
						 
						 Cell R30cell11 = R30row.getCell(18);
						 if (R30cell11 != null) {
						 R30cell11.setCellValue(BRF56a.getR41_amount4() == null ? 0 :
						 BRF56a.getR41_amount4().intValue());
						       	 }
						 
						 Cell R30cell12 = R30row.getCell(19);
						 if (R30cell12 != null) {
						 R30cell12.setCellValue(BRF56a.getR41_nos5() == null ? 0 :
						 BRF56a.getR41_nos5().intValue());
						       	 }	
						 
						 Cell R30cell13 = R30row.getCell(20);
						 if (R30cell13 != null) {
						 R30cell13.setCellValue(BRF56a.getR41_amount5() == null ? 0 :
						 BRF56a.getR41_amount5().intValue());
						       	 }
						 
						 Cell R30cell14 = R30row.getCell(21);
						 if (R30cell14 != null) {
						 R30cell14.setCellValue(BRF56a.getR41_nos6() == null ? 0 :
						 BRF56a.getR41_nos6().intValue());
						       	 }	
						 
						 Cell R30cell15 = R30row.getCell(22);
						 if (R30cell15 != null) {
						 R30cell15.setCellValue(BRF56a.getR41_amount6() == null ? 0 :
						 BRF56a.getR41_amount6().intValue());
						       	 }
						 
						 Cell R30cell16 = R30row.getCell(23);
						 if (R30cell16 != null) {
						 R30cell16.setCellValue(BRF56a.getR41_nos7() == null ? 0 :
						 BRF56a.getR41_nos7().intValue());
						       	 }	
						 
						 Cell R30cell17 = R30row.getCell(24);
						 if (R30cell17 != null) {
						 R30cell17.setCellValue(BRF56a.getR41_amount7() == null ? 0 :
						 BRF56a.getR41_amount7().intValue());
						       	 }
						 
						 Cell R30cell18 = R30row.getCell(25);
						 if (R30cell18 != null) {
						 R30cell18.setCellValue(BRF56a.getR41_nos8() == null ? 0 :
						 BRF56a.getR41_nos8().intValue());
						       	 }	
						 
						 Cell R30cell19 = R30row.getCell(26);
						 if (R30cell19 != null) {
						 R30cell19.setCellValue(BRF56a.getR41_amount8() == null ? 0 :
						 BRF56a.getR41_amount8().intValue());
						       	 }
						 
						 Cell R30cell20 = R30row.getCell(27);
						 if (R30cell20 != null) {
						 R30cell20.setCellValue(BRF56a.getR41_nos9() == null ? 0 :
						 BRF56a.getR41_nos9().intValue());
						       	 }	
						 
						 Cell R30cell21 = R30row.getCell(28);
						 if (R30cell21 != null) {
						 R30cell21.setCellValue(BRF56a.getR41_amount9() == null ? 0 :
						 BRF56a.getR41_amount9().intValue());
						       	 }
						 
						 Cell R30cell22 = R30row.getCell(29);
						 if (R30cell22 != null) {
						 R30cell22.setCellValue(BRF56a.getR41_nos10() == null ? 0 :
						 BRF56a.getR41_nos10().intValue());
						       	 }	
						 
						 Cell R30cell23 = R30row.getCell(30);
						 if (R30cell23 != null) {
						 R30cell23.setCellValue(BRF56a.getR41_amount10() == null ? 0 :
						 BRF56a.getR41_amount10().intValue());
						       	 }
						 
						 Cell R30cell24 = R30row.getCell(31);
						 if (R30cell24 != null) {
						 R30cell24.setCellValue(BRF56a.getR41_nos11() == null ? 0 :
						 BRF56a.getR41_nos11().intValue());
						       	 }	
						 
						 Cell R30cell25 = R30row.getCell(32);
						 if (R30cell25 != null) {
						 R30cell25.setCellValue(BRF56a.getR41_amount11() == null ? 0 :
						 BRF56a.getR41_amount11().intValue());
						       	 }
						 
						 Cell R30cell26 = R30row.getCell(33);
						 if (R30cell26 != null) {
						 R30cell26.setCellValue(BRF56a.getR41_nos12() == null ? 0 :
						 BRF56a.getR41_nos12().intValue());
						       	 }	
						 
						 Cell R30cell27 = R30row.getCell(34);
						 if (R30cell27 != null) {
						 R30cell27.setCellValue(BRF56a.getR41_amount12() == null ? 0 :
						 BRF56a.getR41_amount12().intValue());
						       	 }
						 
						 Cell R30cell28 = R30row.getCell(35);
						 if (R30cell28 != null) {
						 R30cell28.setCellValue(BRF56a.getR41_nos13() == null ? 0 :
						 BRF56a.getR41_nos13().intValue());
						       	 }	
						 
						 Cell R30cell29 = R30row.getCell(36);
						 if (R30cell29 != null) {
						 R30cell29.setCellValue(BRF56a.getR41_amount13() == null ? 0 :
						 BRF56a.getR41_amount13().intValue());
						       	 }
						 
						 Cell R30cell30 = R30row.getCell(37);
						 if (R30cell30 != null) {
						 R30cell30.setCellValue(BRF56a.getR41_nos14() == null ? 0 :
						 BRF56a.getR41_nos14().intValue());
						       	 }	
						 
						 Cell R30cell31 = R30row.getCell(38);
						 if (R30cell31 != null) {
						 R30cell31.setCellValue(BRF56a.getR41_amount14() == null ? 0 :
						 BRF56a.getR41_amount14().intValue());
						       	 }
								 

						    /////////////////////R42/////////////////////////
							
						 Row R31row = sheet.getRow(50);
						 
						 Cell R31cell1 = R31row.getCell(4);
						 if (R31cell1 != null) {
						 R31cell1.setCellValue(BRF56a.getR42_male() == null ? 0 :
						 BRF56a.getR42_male().intValue());
						       	 }				 
								
						 Cell R31cell2 = R31row.getCell(5);
						 if (R31cell2 != null) {
						 R31cell2.setCellValue(BRF56a.getR42_female() == null ? 0 :
						 BRF56a.getR42_female().intValue());
						       	 }	
								
						 Cell R31cell4 = R31row.getCell(11);
						 if (R31cell4 != null) {
						 R31cell4.setCellValue(BRF56a.getR42_nos1() == null ? 0 :
						 BRF56a.getR42_nos1().intValue());
						       	 }	
						 
						 Cell R31cell5 = R31row.getCell(12);
						 if (R31cell5 != null) {
						 R31cell5.setCellValue(BRF56a.getR42_amount1() == null ? 0 :
						 BRF56a.getR42_amount1().intValue());
						       	 }	
							
						 Cell R31cell6 = R31row.getCell(13);
						 if (R31cell6 != null) {
						 R31cell6.setCellValue(BRF56a.getR42_nos2() == null ? 0 :
						 BRF56a.getR42_nos2().intValue());
						       	 }	
						 
						 Cell R31cell7 = R31row.getCell(14);
						 if (R31cell7 != null) {
						 R31cell7.setCellValue(BRF56a.getR42_amount2() == null ? 0 :
						 BRF56a.getR42_amount2().intValue());
						       	 }
						 
						 Cell R31cell8 = R31row.getCell(15);
						 if (R31cell8 != null) {
						 R31cell8.setCellValue(BRF56a.getR42_nos3() == null ? 0 :
						 BRF56a.getR42_nos3().intValue());
						       	 }	
						 
						 Cell R31cell9 = R31row.getCell(16);
						 if (R31cell9 != null) {
						 R31cell9.setCellValue(BRF56a.getR42_amount3() == null ? 0 :
						 BRF56a.getR42_amount3().intValue());
						       	 }
						 
						 Cell R31cell10 = R31row.getCell(17);
						 if (R31cell10 != null) {
						 R31cell10.setCellValue(BRF56a.getR42_nos4() == null ? 0 :
						 BRF56a.getR42_nos4().intValue());
						       	 }	
						 
						 Cell R31cell11 = R31row.getCell(18);
						 if (R31cell11 != null) {
						 R31cell11.setCellValue(BRF56a.getR42_amount4() == null ? 0 :
						 BRF56a.getR42_amount4().intValue());
						       	 }
						 
						 Cell R31cell12 = R31row.getCell(19);
						 if (R31cell12 != null) {
						 R31cell12.setCellValue(BRF56a.getR42_nos5() == null ? 0 :
						 BRF56a.getR42_nos5().intValue());
						       	 }	
						 
						 Cell R31cell13 = R31row.getCell(20);
						 if (R31cell13 != null) {
						 R31cell13.setCellValue(BRF56a.getR42_amount5() == null ? 0 :
						 BRF56a.getR42_amount5().intValue());
						       	 }
						 
						 Cell R31cell14 = R31row.getCell(21);
						 if (R31cell14 != null) {
						 R31cell14.setCellValue(BRF56a.getR42_nos6() == null ? 0 :
						 BRF56a.getR42_nos6().intValue());
						       	 }	
						 
						 Cell R31cell15 = R31row.getCell(22);
						 if (R31cell15 != null) {
						 R31cell15.setCellValue(BRF56a.getR42_amount6() == null ? 0 :
						 BRF56a.getR42_amount6().intValue());
						       	 }
						 
						 Cell R31cell16 = R31row.getCell(23);
						 if (R31cell16 != null) {
						 R31cell16.setCellValue(BRF56a.getR42_nos7() == null ? 0 :
						 BRF56a.getR42_nos7().intValue());
						       	 }	
						 
						 Cell R31cell17 = R31row.getCell(24);
						 if (R31cell17 != null) {
						 R31cell17.setCellValue(BRF56a.getR42_amount7() == null ? 0 :
						 BRF56a.getR42_amount7().intValue());
						       	 }
						 
						 Cell R31cell18 = R31row.getCell(25);
						 if (R31cell18 != null) {
						 R31cell18.setCellValue(BRF56a.getR42_nos8() == null ? 0 :
						 BRF56a.getR42_nos8().intValue());
						       	 }	
						 
						 Cell R31cell19 = R31row.getCell(26);
						 if (R31cell19 != null) {
						 R31cell19.setCellValue(BRF56a.getR42_amount8() == null ? 0 :
						 BRF56a.getR42_amount8().intValue());
						       	 }
						 
						 Cell R31cell20 = R31row.getCell(27);
						 if (R31cell20 != null) {
						 R31cell20.setCellValue(BRF56a.getR42_nos9() == null ? 0 :
						 BRF56a.getR42_nos9().intValue());
						       	 }	
						 
						 Cell R31cell21 = R31row.getCell(28);
						 if (R31cell21 != null) {
						 R31cell21.setCellValue(BRF56a.getR42_amount9() == null ? 0 :
						 BRF56a.getR42_amount9().intValue());
						       	 }
						 
						 Cell R31cell22 = R31row.getCell(29);
						 if (R31cell22 != null) {
						 R31cell22.setCellValue(BRF56a.getR42_nos10() == null ? 0 :
						 BRF56a.getR42_nos10().intValue());
						       	 }	
						 
						 Cell R31cell23 = R31row.getCell(30);
						 if (R31cell23 != null) {
						 R31cell23.setCellValue(BRF56a.getR42_amount10() == null ? 0 :
						 BRF56a.getR42_amount10().intValue());
						       	 }
						 
						 Cell R31cell24 = R31row.getCell(31);
						 if (R31cell24 != null) {
						 R31cell24.setCellValue(BRF56a.getR42_nos11() == null ? 0 :
						 BRF56a.getR42_nos11().intValue());
						       	 }	
						 
						 Cell R31cell25 = R31row.getCell(32);
						 if (R31cell25 != null) {
						 R31cell25.setCellValue(BRF56a.getR42_amount11() == null ? 0 :
						 BRF56a.getR42_amount11().intValue());
						       	 }
						 
						 Cell R31cell26 = R31row.getCell(33);
						 if (R31cell26 != null) {
						 R31cell26.setCellValue(BRF56a.getR42_nos12() == null ? 0 :
						 BRF56a.getR42_nos12().intValue());
						       	 }	
						 
						 Cell R31cell27 = R31row.getCell(34);
						 if (R31cell27 != null) {
						 R31cell27.setCellValue(BRF56a.getR42_amount12() == null ? 0 :
						 BRF56a.getR42_amount12().intValue());
						       	 }
						 
						 Cell R31cell28 = R31row.getCell(35);
						 if (R31cell28 != null) {
						 R31cell28.setCellValue(BRF56a.getR42_nos13() == null ? 0 :
						 BRF56a.getR42_nos13().intValue());
						       	 }	
						 
						 Cell R31cell29 = R31row.getCell(36);
						 if (R31cell29 != null) {
						 R31cell29.setCellValue(BRF56a.getR42_amount13() == null ? 0 :
						 BRF56a.getR42_amount13().intValue());
						       	 }
						 
						 Cell R31cell30 = R31row.getCell(37);
						 if (R31cell30 != null) {
						 R31cell30.setCellValue(BRF56a.getR42_nos14() == null ? 0 :
						 BRF56a.getR42_nos14().intValue());
						       	 }	
						 
						 Cell R31cell31 = R31row.getCell(38);
						 if (R31cell31 != null) {
						 R31cell31.setCellValue(BRF56a.getR42_amount14() == null ? 0 :
						 BRF56a.getR42_amount14().intValue());
						       	 }
								 

						    /////////////////////R43/////////////////////////
							
						 Row R32row = sheet.getRow(51);
						 
						 Cell R32cell1 = R32row.getCell(4);
						 if (R32cell1 != null) {
						 R32cell1.setCellValue(BRF56a.getR43_male() == null ? 0 :
						 BRF56a.getR43_male().intValue());
						       	 }				 
								
						 Cell R32cell2 = R32row.getCell(5);
						 if (R32cell2 != null) {
						 R32cell2.setCellValue(BRF56a.getR43_female() == null ? 0 :
						 BRF56a.getR43_female().intValue());
						       	 }	
								
						 Cell R32cell4 = R32row.getCell(11);
						 if (R32cell4 != null) {
						 R32cell4.setCellValue(BRF56a.getR43_nos1() == null ? 0 :
						 BRF56a.getR43_nos1().intValue());
						       	 }	
						 
						 Cell R32cell5 = R32row.getCell(12);
						 if (R32cell5 != null) {
						 R32cell5.setCellValue(BRF56a.getR43_amount1() == null ? 0 :
						 BRF56a.getR43_amount1().intValue());
						       	 }	
							
						 Cell R32cell6 = R32row.getCell(13);
						 if (R32cell6 != null) {
						 R32cell6.setCellValue(BRF56a.getR43_nos2() == null ? 0 :
						 BRF56a.getR43_nos2().intValue());
						       	 }	
						 
						 Cell R32cell7 = R32row.getCell(14);
						 if (R32cell7 != null) {
						 R32cell7.setCellValue(BRF56a.getR43_amount2() == null ? 0 :
						 BRF56a.getR43_amount2().intValue());
						       	 }
						 
						 Cell R32cell8 = R32row.getCell(15);
						 if (R32cell8 != null) {
						 R32cell8.setCellValue(BRF56a.getR43_nos3() == null ? 0 :
						 BRF56a.getR43_nos3().intValue());
						       	 }	
						 
						 Cell R32cell9 = R32row.getCell(16);
						 if (R32cell9 != null) {
						 R32cell9.setCellValue(BRF56a.getR43_amount3() == null ? 0 :
						 BRF56a.getR43_amount3().intValue());
						       	 }
						 
						 Cell R32cell10 = R32row.getCell(17);
						 if (R32cell10 != null) {
						 R32cell10.setCellValue(BRF56a.getR43_nos4() == null ? 0 :
						 BRF56a.getR43_nos4().intValue());
						       	 }	
						 
						 Cell R32cell11 = R32row.getCell(18);
						 if (R32cell11 != null) {
						 R32cell11.setCellValue(BRF56a.getR43_amount4() == null ? 0 :
						 BRF56a.getR43_amount4().intValue());
						       	 }
						 
						 Cell R32cell12 = R32row.getCell(19);
						 if (R32cell12 != null) {
						 R32cell12.setCellValue(BRF56a.getR43_nos5() == null ? 0 :
						 BRF56a.getR43_nos5().intValue());
						       	 }	
						 
						 Cell R32cell13 = R32row.getCell(20);
						 if (R32cell13 != null) {
						 R32cell13.setCellValue(BRF56a.getR43_amount5() == null ? 0 :
						 BRF56a.getR43_amount5().intValue());
						       	 }
						 
						 Cell R32cell14 = R32row.getCell(21);
						 if (R32cell14 != null) {
						 R32cell14.setCellValue(BRF56a.getR43_nos6() == null ? 0 :
						 BRF56a.getR43_nos6().intValue());
						       	 }	
						 
						 Cell R32cell15 = R32row.getCell(22);
						 if (R32cell15 != null) {
						 R32cell15.setCellValue(BRF56a.getR43_amount6() == null ? 0 :
						 BRF56a.getR43_amount6().intValue());
						       	 }
						 
						 Cell R32cell16 = R32row.getCell(23);
						 if (R32cell16 != null) {
						 R32cell16.setCellValue(BRF56a.getR43_nos7() == null ? 0 :
						 BRF56a.getR43_nos7().intValue());
						       	 }	
						 
						 Cell R32cell17 = R32row.getCell(24);
						 if (R32cell17 != null) {
						 R32cell17.setCellValue(BRF56a.getR43_amount7() == null ? 0 :
						 BRF56a.getR43_amount7().intValue());
						       	 }
						 
						 Cell R32cell18 = R32row.getCell(25);
						 if (R32cell18 != null) {
						 R32cell18.setCellValue(BRF56a.getR43_nos8() == null ? 0 :
						 BRF56a.getR43_nos8().intValue());
						       	 }	
						 
						 Cell R32cell19 = R32row.getCell(26);
						 if (R32cell19 != null) {
						 R32cell19.setCellValue(BRF56a.getR43_amount8() == null ? 0 :
						 BRF56a.getR43_amount8().intValue());
						       	 }
						 
						 Cell R32cell20 = R32row.getCell(27);
						 if (R32cell20 != null) {
						 R32cell20.setCellValue(BRF56a.getR43_nos9() == null ? 0 :
						 BRF56a.getR43_nos9().intValue());
						       	 }	
						 
						 Cell R32cell21 = R32row.getCell(28);
						 if (R32cell21 != null) {
						 R32cell21.setCellValue(BRF56a.getR43_amount9() == null ? 0 :
						 BRF56a.getR43_amount9().intValue());
						       	 }
						 
						 Cell R32cell22 = R32row.getCell(29);
						 if (R32cell22 != null) {
						 R32cell22.setCellValue(BRF56a.getR43_nos10() == null ? 0 :
						 BRF56a.getR43_nos10().intValue());
						       	 }	
						 
						 Cell R32cell23 = R32row.getCell(30);
						 if (R32cell23 != null) {
						 R32cell23.setCellValue(BRF56a.getR43_amount10() == null ? 0 :
						 BRF56a.getR43_amount10().intValue());
						       	 }
						 
						 Cell R32cell24 = R32row.getCell(31);
						 if (R32cell24 != null) {
						 R32cell24.setCellValue(BRF56a.getR43_nos11() == null ? 0 :
						 BRF56a.getR43_nos11().intValue());
						       	 }	
						 
						 Cell R32cell25 = R32row.getCell(32);
						 if (R32cell25 != null) {
						 R32cell25.setCellValue(BRF56a.getR43_amount11() == null ? 0 :
						 BRF56a.getR43_amount11().intValue());
						       	 }
						 
						 Cell R32cell26 = R32row.getCell(33);
						 if (R32cell26 != null) {
						 R32cell26.setCellValue(BRF56a.getR43_nos12() == null ? 0 :
						 BRF56a.getR43_nos12().intValue());
						       	 }	
						 
						 Cell R32cell27 = R32row.getCell(34);
						 if (R32cell27 != null) {
						 R32cell27.setCellValue(BRF56a.getR43_amount12() == null ? 0 :
						 BRF56a.getR43_amount12().intValue());
						       	 }
						 
						 Cell R32cell28 = R32row.getCell(35);
						 if (R32cell28 != null) {
						 R32cell28.setCellValue(BRF56a.getR43_nos13() == null ? 0 :
						 BRF56a.getR43_nos13().intValue());
						       	 }	
						 
						 Cell R32cell29 = R32row.getCell(36);
						 if (R32cell29 != null) {
						 R32cell29.setCellValue(BRF56a.getR43_amount13() == null ? 0 :
						 BRF56a.getR43_amount13().intValue());
						       	 }
						 
						 Cell R32cell30 = R32row.getCell(37);
						 if (R32cell30 != null) {
						 R32cell30.setCellValue(BRF56a.getR43_nos14() == null ? 0 :
						 BRF56a.getR43_nos14().intValue());
						       	 }	
						 
						 Cell R32cell31 = R32row.getCell(38);
						 if (R32cell31 != null) {
						 R32cell31.setCellValue(BRF56a.getR43_amount14() == null ? 0 :
						 BRF56a.getR43_amount14().intValue());
						       	 }
								 

						
					}
				}
				
				// Save the changes
		        workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
				FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-056-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-056-A.xls");

		return outputFile;
	
	
	
	}
	
	
	
	
	public String detailChanges056(BRF56_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF56_DETAIL_ENTITY> Brf56detail = brf56DetailRep.findById(foracid);

			if (Brf56detail.isPresent()) {
				BRF56_DETAIL_ENTITY BRFdetail = Brf56detail.get();
				
			

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
					brf56DetailRep.save(BRFdetail);

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
	public ModelAndView getArchieveBRF056View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF56_ENTITY1> T1rep = new ArrayList<BRF56_ENTITY1>();
		// Query<Object[]> qr;

		List<BRF56_ENTITY1> T1Master = new ArrayList<BRF56_ENTITY1>();
		
		List<BRF56_ENTITY2> T1Master1 = new ArrayList<BRF56_ENTITY2>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF56_ENTITY1 a where a.report_date = ?1 ", BRF56_ENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			T1Master1 = hs.createQuery("from BRF56_ENTITY2 a where a.report_date = ?1 ", BRF56_ENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF56ARCH");
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


		
/**** ARCH DETAILS 
* @throws ParseException ****/
	public ModelAndView ARCHgetBRF056currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF56_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF56_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF56_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF56_ARCHIV_ENTITY> T1Master = new ArrayList<BRF56_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF56_ARCHIV_ENTITY a where a.report_date = ?1", BRF56_ARCHIV_ENTITY.class)
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

			BRF56_DETAIL_ENTITY py = new BRF56_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks);
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

		mv.setViewName("RR" + "/" + "BRF56ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
}
