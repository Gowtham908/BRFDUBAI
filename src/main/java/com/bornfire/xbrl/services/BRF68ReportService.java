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
import com.bornfire.xbrl.entities.BRBS.BRF151reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF152ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF153ReportEntity;
import com.bornfire.xbrl.entities.BRBS.BRF153ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF154ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF154reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF155ServiceRepo;
//import com.bornfire.xbrl.entities.BRF60_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF68_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF051ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF060Reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF068ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF155reportentity;

import com.bornfire.xbrl.entities.BRBS.BRF068ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF67_ENTITY;
//import com.bornfire.xbrl.entities.BRBS.BRF60_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF68_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF68_DetailRepo;

import com.bornfire.xbrl.entities.BRBS.BRF68_Entity1;
import com.bornfire.xbrl.entities.BRBS.BRF68_Entity2;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;
import com.bornfire.xbrl.entities.BRBS.BRF152_Entity;

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

public class BRF68ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF68ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF068ServiceRepo brf068ServiceRepo;
	
	@Autowired
	BRF68_DetailRepo brf68_DetailRepo;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF068(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF68_Entity1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF68_Entity1 a").getSingleResult();
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
	
	public ModelAndView getBRF068View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF68_Entity1> T1rep = new ArrayList<BRF68_Entity1>();
		// Query<Object[]> qr;

		List<BRF68_Entity1> T1Master = new ArrayList<BRF68_Entity1>();
		
		List<BRF68_Entity2> T1Master1 = new ArrayList<BRF68_Entity2>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF68_Entity1 a where a.report_date = ?1 ", BRF68_Entity1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			T1Master1 = hs.createQuery("from BRF68_Entity2 a where a.report_date = ?1 ", BRF68_Entity2.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/ReportBRF068");
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
	public ModelAndView getBRF068Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF68_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF68_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF68_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF68_DETAIL_ENTITY> T1Master = new ArrayList<BRF68_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF68_DETAIL_ENTITY a where a.report_date = ?1", BRF68_DETAIL_ENTITY.class)
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
			String gender = (String) a[48];
			String nationality = (String)a[49];
			String Remarks1;
			if (act_balance_amt_lc  != null) {
				if (act_balance_amt_lc .toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}
		BRF68_DETAIL_ENTITY py = new BRF68_DETAIL_ENTITY( cust_id,  foracid,  acct_name,  eab_lc,
				 act_balance_amt_lc,  acct_crncy_code,  gl_code,  gl_sub_head_code,
				 gl_sub_head_desc,  country_of_incorp,  cust_type,  schm_code,  schm_type,
				 sol_id,  acid,  segment,  sub_segment,  sector,  sub_sector,
				 sector_code,  group_id,  constitution_code,  country,  legal_entity_type,
				 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
				 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
				 report_addl_criteria_3,  create_user,  create_time,  modify_user,  modify_time,
				 verify_user,  verify_time,  entity_flg,  modify_flg,  del_flg,
				 nre_status,  report_date,  maturity_date,  version,  remarks,  gender,nationality);
			
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

		mv.setViewName("RR" + "/" + "ReportBRF068::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF068(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-068-A";
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

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF68_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF68_Detail.jrxml");
					}
				
				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
					
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF68.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF68.jrxml");
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
		} else {
			List<BRF68_Entity1> T1Master = new ArrayList<>();
			List<BRF68_Entity2> T1Master1 = new ArrayList<>();

			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);

				T1Master = hs.createQuery("from BRF68_Entity1 a where a.report_date = ?1", BRF68_Entity1.class)
						.setParameter(1, df.parse(todate)).getResultList();
				T1Master1 = hs.createQuery("from BRF68_Entity2 a where a.report_date = ?1", BRF68_Entity2.class)
						.setParameter(1, df.parse(todate)).getResultList();

				File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-068-AT.xls");
				Workbook workbook = WorkbookFactory.create(responseCamt);
				
				Sheet sheet = workbook.getSheetAt(0);
				
				if (T1Master.size() == 1) {
					for (BRF68_Entity1 brf68 : T1Master) {
						
						 ///row2
						Row row2 = sheet.getRow(11);
						/*
						 * Cell R2cell1 = row2.getCell(4); if (R2cell1 != null) {
						 * R2cell1.setCellValue(brf68.getR2_male() == null ? 0 :
						 * brf68.getR2_male().intValue()); } Cell R2cell2 = row2.getCell(5); if (R2cell2
						 * != null) { R2cell2.setCellValue(brf68.getR2_female() == null ? 0 :
						 * brf68.getR2_female().intValue()); }
						 */
							Cell R2cell3 = row2.getCell(6); 
							if (R2cell3 != null) {
								R2cell3.setCellValue(brf68.getR2_entities() == null ? 0 : brf68.getR2_entities().intValue());
							}
							Cell R2cell4 = row2.getCell(10); 
							if (R2cell4 != null) {
								R2cell4.setCellValue(brf68.getR2_nos1() == null ? 0 : brf68.getR2_nos1().intValue());
							}
							Cell R2cell5 = row2.getCell(11); 
							if (R2cell5 != null) {
								R2cell5.setCellValue(brf68.getR2_amount1() == null ? 0 : brf68.getR2_amount1().intValue());
							}
							Cell R2cell6 = row2.getCell(12); 
							if (R2cell6 != null) {
								R2cell6.setCellValue(brf68.getR2_nos2() == null ? 0 : brf68.getR2_nos2().intValue());
							}
							Cell R2cell7 = row2.getCell(13); 
							if (R2cell7 != null) {
								R2cell7.setCellValue(brf68.getR2_amount2() == null ? 0 : brf68.getR2_amount2().intValue());
							}
							Cell R2cell8 = row2.getCell(14); 
							if (R2cell8 != null) {
								R2cell8.setCellValue(brf68.getR2_nos3() == null ? 0 : brf68.getR2_nos3().intValue());
							}
							Cell R2cell9 = row2.getCell(15); 
							if (R2cell9 != null) {
								R2cell9.setCellValue(brf68.getR2_amount3() == null ? 0 : brf68.getR2_amount3().intValue());
							}
							Cell R2cell10 = row2.getCell(16); 
							if (R2cell10 != null) {
								R2cell10.setCellValue(brf68.getR2_nos4() == null ? 0 : brf68.getR2_nos4().intValue());
							}
							Cell R2cell11 = row2.getCell(17); 
							if (R2cell11 != null) {
								R2cell11.setCellValue(brf68.getR2_amount4() == null ? 0 : brf68.getR2_amount4().intValue());
							}
							Cell R2cell12 = row2.getCell(18); 
							if (R2cell12 != null) {
								R2cell12.setCellValue(brf68.getR2_nos5() == null ? 0 : brf68.getR2_nos5().intValue());
							}
							Cell R2cell13 = row2.getCell(19); 
							if (R2cell13 != null) {
								R2cell13.setCellValue(brf68.getR2_amount5() == null ? 0 : brf68.getR2_amount5().intValue());
							}
							Cell R2cell14 = row2.getCell(20); 
							if (R2cell14 != null) {
								R2cell14.setCellValue(brf68.getR2_nos6() == null ? 0 : brf68.getR2_nos6().intValue());
							}
							Cell R2cell15 = row2.getCell(21); 
							if (R2cell15 != null) {
								R2cell15.setCellValue(brf68.getR2_amount6() == null ? 0 : brf68.getR2_amount6().intValue());
							}
							Cell R2cell16 = row2.getCell(22); 
							if (R2cell16 != null) {
								R2cell16.setCellValue(brf68.getR2_nos7() == null ? 0 : brf68.getR2_nos7().intValue());
							}
							Cell  R2cell17 = row2.getCell(23); 
							if (R2cell17 != null) {
								R2cell17.setCellValue(brf68.getR2_amount7() == null ? 0 : brf68.getR2_amount7().intValue());
							}
							Cell  R2cell18 = row2.getCell(24); 
							if (R2cell18 != null) {
								R2cell18.setCellValue(brf68.getR2_nos8() == null ? 0 : brf68.getR2_nos8().intValue());
							}
							Cell  R2cell19 = row2.getCell(25); 
							if (R2cell19 != null) {
								R2cell19.setCellValue(brf68.getR2_amount8() == null ? 0 : brf68.getR2_amount8().intValue());
							}
							Cell  R2cell20 = row2.getCell(26); 
							if (R2cell20 != null) {
								R2cell20.setCellValue(brf68.getR2_nos9() == null ? 0 : brf68.getR2_nos9().intValue());
							}
							Cell  R2cell21 = row2.getCell(27); 
							if (R2cell21 != null) {
								R2cell21.setCellValue(brf68.getR2_amount9() == null ? 0 : brf68.getR2_amount9().intValue());
							}
							Cell R2cell22 = row2.getCell(28); 
							if (R2cell22 != null) {
								R2cell22.setCellValue(brf68.getR2_nos10() == null ? 0 : brf68.getR2_nos10().intValue());
							}
							Cell  R2cell23 = row2.getCell(29); 
							if (R2cell23 != null) {
								R2cell23.setCellValue(brf68.getR2_amount10() == null ? 0 : brf68.getR2_amount10().intValue());
							}
							Cell R2cell24 = row2.getCell(30); 
							if (R2cell24 != null) {
								R2cell24.setCellValue(brf68.getR2_nos11() == null ? 0 : brf68.getR2_nos11().intValue());
							}
							Cell  R2cell25 = row2.getCell(31); 
							if (R2cell25 != null) {
								R2cell25.setCellValue(brf68.getR2_amount11() == null ? 0 : brf68.getR2_amount11().intValue());
							}
							Cell  R2cell26 = row2.getCell(32); 
							if (R2cell26 != null) {
								R2cell26.setCellValue(brf68.getR2_nos12() == null ? 0 : brf68.getR2_nos12().intValue());
							}
							Cell  R2cell27 = row2.getCell(33); 
							if (R2cell27 != null) {
								R2cell27.setCellValue(brf68.getR2_amount12() == null ? 0 : brf68.getR2_amount12().intValue());
							}
							Cell  R2cell28 = row2.getCell(34); 
							if (R2cell28 != null) {
								R2cell28.setCellValue(brf68.getR2_nos13() == null ? 0 : brf68.getR2_nos13().intValue());
							}
							Cell  R2cell29 = row2.getCell(35); 
							if (R2cell29 != null) {
								R2cell29.setCellValue(brf68.getR2_amount13() == null ? 0 : brf68.getR2_amount13().intValue());
							}
							Cell  R2cell30 = row2.getCell(36); 
							if (R2cell30 != null) {
								R2cell30.setCellValue(brf68.getR2_nos14() == null ? 0 : brf68.getR2_nos14().intValue());
							}
							Cell  R2cell31 = row2.getCell(37); 
							if (R2cell31 != null) {
								R2cell31.setCellValue(brf68.getR2_amount14() == null ? 0 : brf68.getR2_amount14().intValue());
							}
							
						 ///row3
						Row row3 = sheet.getRow(12);
						/*
						 * Cell R3cell1 = row3.getCell(4); if (R3cell1 != null) {
						 * R3cell1.setCellValue(brf68.getR3_male() == null ? 0 :
						 * brf68.getR3_male().intValue()); } Cell R3cell2 = row3.getCell(5); if (R3cell2
						 * != null) { R3cell2.setCellValue(brf68.getR3_female() == null ? 0 :
						 * brf68.getR3_female().intValue()); }
						 */
						Cell R3cell3 = row3.getCell(6); 
						if (R3cell3 != null) {
							R3cell3.setCellValue(brf68.getR3_entities() == null ? 0 : brf68.getR3_entities().intValue());
						}
						Cell R3cell4 = row3.getCell(10); 
						if (R3cell4 != null) {
							R3cell4.setCellValue(brf68.getR3_nos1() == null ? 0 : brf68.getR3_nos1().intValue());
						}
						Cell R3cell5 = row3.getCell(11); 
						if (R3cell5 != null) {
							R3cell5.setCellValue(brf68.getR3_amount1() == null ? 0 : brf68.getR3_amount1().intValue());
						}
						Cell R3cell6 = row3.getCell(12); 
						if (R3cell6 != null) {
							R3cell6.setCellValue(brf68.getR3_nos2() == null ? 0 : brf68.getR3_nos2().intValue());
						}
						Cell R3cell7 = row3.getCell(13); 
						if (R3cell7 != null) {
							R3cell7.setCellValue(brf68.getR3_amount2() == null ? 0 : brf68.getR3_amount2().intValue());
						}
						Cell R3cell8 = row3.getCell(14); 
						if (R3cell8 != null) {
							R3cell8.setCellValue(brf68.getR3_nos3() == null ? 0 : brf68.getR3_nos3().intValue());
						}
						Cell R3cell9 = row3.getCell(15); 
						if (R3cell9 != null) {
							R3cell9.setCellValue(brf68.getR3_amount3() == null ? 0 : brf68.getR3_amount3().intValue());
						}
						Cell R3cell10 = row3.getCell(16); 
						if (R3cell10 != null) {
							R3cell10.setCellValue(brf68.getR3_nos4() == null ? 0 : brf68.getR3_nos4().intValue());
						}
						Cell R3cell11 = row3.getCell(17); 
						if (R3cell11 != null) {
							R3cell11.setCellValue(brf68.getR3_amount4() == null ? 0 : brf68.getR3_amount4().intValue());
						}
						Cell R3cell12 = row3.getCell(18); 
						if (R3cell12 != null) {
							R3cell12.setCellValue(brf68.getR3_nos5() == null ? 0 : brf68.getR3_nos5().intValue());
						}
						Cell R3cell13 = row3.getCell(19); 
						if (R3cell13 != null) {
							R3cell13.setCellValue(brf68.getR3_amount5() == null ? 0 : brf68.getR3_amount5().intValue());
						}
						Cell R3cell14 = row3.getCell(20); 
						if (R3cell14 != null) {
							R3cell14.setCellValue(brf68.getR3_nos6() == null ? 0 : brf68.getR3_nos6().intValue());
						}
						Cell R3cell15 = row3.getCell(21); 
						if (R3cell15 != null) {
							R3cell15.setCellValue(brf68.getR3_amount6() == null ? 0 : brf68.getR3_amount6().intValue());
						}
						Cell R3cell16 = row3.getCell(22); 
						if (R3cell16 != null) {
							R3cell16.setCellValue(brf68.getR3_nos7() == null ? 0 : brf68.getR3_nos7().intValue());
						}
						Cell  R3cell17 = row3.getCell(23); 
						if (R3cell17 != null) {
							R3cell17.setCellValue(brf68.getR3_amount7() == null ? 0 : brf68.getR3_amount7().intValue());
						}
						Cell  R3cell18 = row3.getCell(24); 
						if (R3cell18 != null) {
							R3cell18.setCellValue(brf68.getR3_nos8() == null ? 0 : brf68.getR3_nos8().intValue());
						}
						Cell  R3cell19 = row3.getCell(25); 
						if (R3cell19 != null) {
							R3cell19.setCellValue(brf68.getR3_amount8() == null ? 0 : brf68.getR3_amount8().intValue());
						}
						Cell  R3cell20 = row3.getCell(26); 
						if (R3cell20 != null) {
							R3cell20.setCellValue(brf68.getR3_nos9() == null ? 0 : brf68.getR3_nos9().intValue());
						}
						Cell  R3cell21 = row3.getCell(27); 
						if (R3cell21 != null) {
							R3cell21.setCellValue(brf68.getR3_amount9() == null ? 0 : brf68.getR3_amount9().intValue());
						}
						Cell R3cell22 = row3.getCell(28); 
						if (R3cell22 != null) {
							R3cell22.setCellValue(brf68.getR3_nos10() == null ? 0 : brf68.getR3_nos10().intValue());
						}
						Cell  R3cell23 = row3.getCell(29); 
						if (R3cell23 != null) {
							R3cell23.setCellValue(brf68.getR3_amount10() == null ? 0 : brf68.getR3_amount10().intValue());
						}
						Cell R3cell24 = row3.getCell(30); 
						if (R3cell24 != null) {
							R3cell24.setCellValue(brf68.getR3_nos11() == null ? 0 : brf68.getR3_nos11().intValue());
						}
						Cell  R3cell25 = row3.getCell(31); 
						if (R3cell25 != null) {
							R3cell25.setCellValue(brf68.getR3_amount11() == null ? 0 : brf68.getR3_amount11().intValue());
						}
						Cell  R3cell26 = row3.getCell(32); 
						if (R3cell26 != null) {
							R3cell26.setCellValue(brf68.getR3_nos12() == null ? 0 : brf68.getR3_nos12().intValue());
						}
						Cell  R3cell27 = row3.getCell(33); 
						if (R3cell27 != null) {
							R3cell27.setCellValue(brf68.getR3_amount12() == null ? 0 : brf68.getR3_amount12().intValue());
						}
						Cell  R3cell28 = row3.getCell(34); 
						if (R3cell28 != null) {
							R3cell28.setCellValue(brf68.getR3_nos13() == null ? 0 : brf68.getR3_nos13().intValue());
						}
						Cell  R3cell29 = row3.getCell(35); 
						if (R3cell29 != null) {
							R3cell29.setCellValue(brf68.getR3_amount13() == null ? 0 : brf68.getR3_amount13().intValue());
						}
						Cell  R3cell30 = row3.getCell(36); 
						if (R3cell30 != null) {
							R3cell30.setCellValue(brf68.getR3_nos14() == null ? 0 : brf68.getR3_nos14().intValue());
						}
						Cell  R3cell31 = row3.getCell(37); 
						if (R3cell31 != null) {
							R3cell31.setCellValue(brf68.getR3_amount14() == null ? 0 : brf68.getR3_amount14().intValue());
						}
						
						///row4
						Row row4 = sheet.getRow(13);
						/*
						 * Cell R4cell1 = row4.getCell(4); if (R4cell1 != null) {
						 * R4cell1.setCellValue(brf68.getR4_male() == null ? 0 :
						 * brf68.getR4_male().intValue()); } Cell R4cell2 = row4.getCell(5); if (R4cell2
						 * != null) { R4cell2.setCellValue(brf68.getR4_female() == null ? 0 :
						 * brf68.getR4_female().intValue()); }
						 */
						Cell R4cell3 = row4.getCell(6); 
						if (R4cell3 != null) {
							R4cell3.setCellValue(brf68.getR4_entities() == null ? 0 : brf68.getR4_entities().intValue());
						}
						Cell R4cell4 = row4.getCell(10); 
						if (R4cell4 != null) {
							R4cell4.setCellValue(brf68.getR4_nos1() == null ? 0 : brf68.getR4_nos1().intValue());
						}
						Cell R4cell5 = row4.getCell(11); 
						if (R4cell5 != null) {
							R4cell5.setCellValue(brf68.getR4_amount1() == null ? 0 : brf68.getR4_amount1().intValue());
						}
						Cell R4cell6 = row4.getCell(12); 
						if (R4cell6 != null) {
							R4cell6.setCellValue(brf68.getR4_nos2() == null ? 0 : brf68.getR4_nos2().intValue());
						}
						Cell R4cell7 = row4.getCell(13); 
						if (R4cell7 != null) {
							R4cell7.setCellValue(brf68.getR4_amount2() == null ? 0 : brf68.getR4_amount2().intValue());
						}
						Cell R4cell8 = row4.getCell(14); 
						if (R4cell8 != null) {
							R4cell8.setCellValue(brf68.getR4_nos3() == null ? 0 : brf68.getR4_nos3().intValue());
						}
						Cell R4cell9 = row4.getCell(15); 
						if (R4cell9 != null) {
							R4cell9.setCellValue(brf68.getR4_amount3() == null ? 0 : brf68.getR4_amount3().intValue());
						}
						Cell R4cell10 = row4.getCell(16); 
						if (R4cell10 != null) {
							R4cell10.setCellValue(brf68.getR4_nos4() == null ? 0 : brf68.getR4_nos4().intValue());
						}
						Cell R4cell11 = row4.getCell(17); 
						if (R4cell11 != null) {
							R4cell11.setCellValue(brf68.getR4_amount4() == null ? 0 : brf68.getR4_amount4().intValue());
						}
						Cell R4cell12 = row4.getCell(18); 
						if (R4cell12 != null) {
							R4cell12.setCellValue(brf68.getR4_nos5() == null ? 0 : brf68.getR4_nos5().intValue());
						}
						Cell R4cell13 = row4.getCell(19); 
						if (R4cell13 != null) {
							R4cell13.setCellValue(brf68.getR4_amount5() == null ? 0 : brf68.getR4_amount5().intValue());
						}
						Cell R4cell14 = row4.getCell(20); 
						if (R4cell14 != null) {
							R4cell14.setCellValue(brf68.getR4_nos6() == null ? 0 : brf68.getR4_nos6().intValue());
						}
						Cell R4cell15 = row4.getCell(21); 
						if (R4cell15 != null) {
							R4cell15.setCellValue(brf68.getR4_amount6() == null ? 0 : brf68.getR4_amount6().intValue());
						}
						Cell R4cell16 = row4.getCell(22); 
						if (R4cell16 != null) {
							R4cell16.setCellValue(brf68.getR4_nos7() == null ? 0 : brf68.getR4_nos7().intValue());
						}
						Cell  R4cell17 = row4.getCell(23); 
						if (R4cell17 != null) {
							R4cell17.setCellValue(brf68.getR4_amount7() == null ? 0 : brf68.getR4_amount7().intValue());
						}
						Cell  R4cell18 = row4.getCell(24); 
						if (R4cell18 != null) {
							R4cell18.setCellValue(brf68.getR4_nos8() == null ? 0 : brf68.getR4_nos8().intValue());
						}
						Cell  R4cell19 = row4.getCell(25); 
						if (R4cell19 != null) {
							R4cell19.setCellValue(brf68.getR4_amount8() == null ? 0 : brf68.getR4_amount8().intValue());
						}
						Cell  R4cell20 = row4.getCell(26); 
						if (R4cell20 != null) {
							R4cell20.setCellValue(brf68.getR4_nos9() == null ? 0 : brf68.getR4_nos9().intValue());
						}
						Cell  R4cell21 = row4.getCell(27); 
						if (R4cell21 != null) {
							R4cell21.setCellValue(brf68.getR4_amount9() == null ? 0 : brf68.getR4_amount9().intValue());
						}
						Cell R4cell22 = row4.getCell(28); 
						if (R4cell22 != null) {
							R4cell22.setCellValue(brf68.getR4_nos10() == null ? 0 : brf68.getR4_nos10().intValue());
						}
						Cell  R4cell23 = row4.getCell(29); 
						if (R4cell23 != null) {
							R4cell23.setCellValue(brf68.getR4_amount10() == null ? 0 : brf68.getR4_amount10().intValue());
						}
						Cell R4cell24 = row4.getCell(30); 
						if (R4cell24 != null) {
							R4cell24.setCellValue(brf68.getR4_nos11() == null ? 0 : brf68.getR4_nos11().intValue());
						}
						Cell  R4cell25 = row4.getCell(31); 
						if (R4cell25 != null) {
							R4cell25.setCellValue(brf68.getR4_amount11() == null ? 0 : brf68.getR4_amount11().intValue());
						}
						Cell  R4cell26 = row4.getCell(32); 
						if (R4cell26 != null) {
							R4cell26.setCellValue(brf68.getR4_nos12() == null ? 0 : brf68.getR4_nos12().intValue());
						}
						Cell  R4cell27 = row4.getCell(33); 
						if (R4cell27 != null) {
							R4cell27.setCellValue(brf68.getR4_amount12() == null ? 0 : brf68.getR4_amount12().intValue());
						}
						Cell  R4cell28 = row4.getCell(34); 
						if (R4cell28 != null) {
							R4cell28.setCellValue(brf68.getR4_nos13() == null ? 0 : brf68.getR4_nos13().intValue());
						}
						Cell  R4cell29 = row4.getCell(35); 
						if (R4cell29 != null) {
							R4cell29.setCellValue(brf68.getR4_amount13() == null ? 0 : brf68.getR4_amount13().intValue());
						}
						Cell  R4cell30 = row4.getCell(36); 
						if (R4cell30 != null) {
							R4cell30.setCellValue(brf68.getR4_nos14() == null ? 0 : brf68.getR4_nos14().intValue());
						}
						Cell  R4cell31 = row4.getCell(37); 
						if (R4cell31 != null) {
							R4cell31.setCellValue(brf68.getR4_amount14() == null ? 0 : brf68.getR4_amount14().intValue());
						}
						
						///row5
						Row row5 = sheet.getRow(14);
						/*
						 * Cell R5cell1 = row5.getCell(4); if (R5cell1 != null) {
						 * R5cell1.setCellValue(brf68.getR5_male() == null ? 0 :
						 * brf68.getR5_male().intValue()); } Cell R5cell2 = row5.getCell(5); if (R5cell2
						 * != null) { R5cell2.setCellValue(brf68.getR5_female() == null ? 0 :
						 * brf68.getR5_female().intValue()); }
						 */
						Cell R5cell3 = row5.getCell(6); 
						if (R5cell3 != null) {
							R5cell3.setCellValue(brf68.getR5_entities() == null ? 0 : brf68.getR5_entities().intValue());
						}
						Cell R5cell4 = row5.getCell(10); 
						if (R5cell4 != null) {
							R5cell4.setCellValue(brf68.getR5_nos1() == null ? 0 : brf68.getR5_nos1().intValue());
						}
						Cell R5cell5 = row5.getCell(11); 
						if (R5cell5 != null) {
							R5cell5.setCellValue(brf68.getR5_amount1() == null ? 0 : brf68.getR5_amount1().intValue());
						}
						Cell R5cell6 = row5.getCell(12); 
						if (R5cell6 != null) {
							R5cell6.setCellValue(brf68.getR5_nos2() == null ? 0 : brf68.getR5_nos2().intValue());
						}
						Cell R5cell7 = row5.getCell(13); 
						if (R5cell7 != null) {
							R5cell7.setCellValue(brf68.getR5_amount2() == null ? 0 : brf68.getR5_amount2().intValue());
						}
						Cell R5cell8 = row5.getCell(14); 
						if (R5cell8 != null) {
							R5cell8.setCellValue(brf68.getR5_nos3() == null ? 0 : brf68.getR5_nos3().intValue());
						}
						Cell R5cell9 = row5.getCell(15); 
						if (R5cell9 != null) {
							R5cell9.setCellValue(brf68.getR5_amount3() == null ? 0 : brf68.getR5_amount3().intValue());
						}
						Cell R5cell10 = row5.getCell(16); 
						if (R5cell10 != null) {
							R5cell10.setCellValue(brf68.getR5_nos4() == null ? 0 : brf68.getR5_nos4().intValue());
						}
						Cell R5cell11 = row5.getCell(17); 
						if (R5cell11 != null) {
							R5cell11.setCellValue(brf68.getR5_amount4() == null ? 0 : brf68.getR5_amount4().intValue());
						}
						Cell R5cell12 = row5.getCell(18); 
						if (R5cell12 != null) {
							R5cell12.setCellValue(brf68.getR5_nos5() == null ? 0 : brf68.getR5_nos5().intValue());
						}
						Cell R5cell13 = row5.getCell(19); 
						if (R5cell13 != null) {
							R5cell13.setCellValue(brf68.getR5_amount5() == null ? 0 : brf68.getR5_amount5().intValue());
						}
						Cell R5cell14 = row5.getCell(20); 
						if (R5cell14 != null) {
							R5cell14.setCellValue(brf68.getR5_nos6() == null ? 0 : brf68.getR5_nos6().intValue());
						}
						Cell R5cell15 = row5.getCell(21); 
						if (R5cell15 != null) {
							R5cell15.setCellValue(brf68.getR5_amount6() == null ? 0 : brf68.getR5_amount6().intValue());
						}
						Cell R5cell16 = row5.getCell(22); 
						if (R5cell16 != null) {
							R5cell16.setCellValue(brf68.getR5_nos7() == null ? 0 : brf68.getR5_nos7().intValue());
						}
						Cell  R5cell17 = row5.getCell(23); 
						if (R5cell17 != null) {
							R5cell17.setCellValue(brf68.getR5_amount7() == null ? 0 : brf68.getR5_amount7().intValue());
						}
						Cell  R5cell18 = row5.getCell(24); 
						if (R5cell18 != null) {
							R5cell18.setCellValue(brf68.getR5_nos8() == null ? 0 : brf68.getR5_nos8().intValue());
						}
						Cell  R5cell19 = row5.getCell(25); 
						if (R5cell19 != null) {
							R5cell19.setCellValue(brf68.getR5_amount8() == null ? 0 : brf68.getR5_amount8().intValue());
						}
						Cell  R5cell20 = row5.getCell(26); 
						if (R5cell20 != null) {
							R5cell20.setCellValue(brf68.getR5_nos9() == null ? 0 : brf68.getR5_nos9().intValue());
						}
						Cell  R5cell21 = row5.getCell(27); 
						if (R5cell21 != null) {
							R5cell21.setCellValue(brf68.getR5_amount9() == null ? 0 : brf68.getR5_amount9().intValue());
						}
						Cell R5cell22 = row5.getCell(28); 
						if (R5cell22 != null) {
							R5cell22.setCellValue(brf68.getR5_nos10() == null ? 0 : brf68.getR5_nos10().intValue());
						}
						Cell  R5cell23 = row5.getCell(29); 
						if (R5cell23 != null) {
							R5cell23.setCellValue(brf68.getR5_amount10() == null ? 0 : brf68.getR5_amount10().intValue());
						}
						Cell R5cell24 = row5.getCell(30); 
						if (R5cell24 != null) {
							R5cell24.setCellValue(brf68.getR5_nos11() == null ? 0 : brf68.getR5_nos11().intValue());
						}
						Cell  R5cell25 = row5.getCell(31); 
						if (R5cell25 != null) {
							R5cell25.setCellValue(brf68.getR5_amount11() == null ? 0 : brf68.getR5_amount11().intValue());
						}
						Cell  R5cell26 = row5.getCell(32); 
						if (R5cell26 != null) {
							R5cell26.setCellValue(brf68.getR5_nos12() == null ? 0 : brf68.getR5_nos12().intValue());
						}
						Cell  R5cell27 = row5.getCell(33); 
						if (R5cell27 != null) {
							R5cell27.setCellValue(brf68.getR5_amount12() == null ? 0 : brf68.getR5_amount12().intValue());
						}
						Cell  R5cell28 = row5.getCell(34); 
						if (R5cell28 != null) {
							R5cell28.setCellValue(brf68.getR5_nos13() == null ? 0 : brf68.getR5_nos13().intValue());
						}
						Cell  R5cell29 = row5.getCell(35); 
						if (R5cell29 != null) {
							R5cell29.setCellValue(brf68.getR5_amount13() == null ? 0 : brf68.getR5_amount13().intValue());
						}
						Cell  R5cell30 = row5.getCell(36); 
						if (R5cell30 != null) {
							R5cell30.setCellValue(brf68.getR5_nos14() == null ? 0 : brf68.getR5_nos14().intValue());
						}
						Cell  R5cell31 = row5.getCell(37); 
						if (R5cell31 != null) {
							R5cell31.setCellValue(brf68.getR5_amount14() == null ? 0 : brf68.getR5_amount14().intValue());
						}
						
						
						
						///row7
						Row row7 = sheet.getRow(16);
						/*
						 * Cell R7cell1 = row7.getCell(4); if (R7cell1 != null) {
						 * R7cell1.setCellValue(brf68.getR7_male() == null ? 0 :
						 * brf68.getR7_male().intValue()); } Cell R7cell2 = row7.getCell(5); if (R7cell2
						 * != null) { R7cell2.setCellValue(brf68.getR7_female() == null ? 0 :
						 * brf68.getR7_female().intValue()); }
						 */
						Cell R7cell3 = row7.getCell(6); 
						if (R7cell3 != null) {
							R7cell3.setCellValue(brf68.getR7_entities() == null ? 0 : brf68.getR7_entities().intValue());
						}
						Cell R7cell4 = row7.getCell(10); 
						if (R7cell4 != null) {
							R7cell4.setCellValue(brf68.getR7_nos1() == null ? 0 : brf68.getR7_nos1().intValue());
						}
						Cell R7cell5 = row7.getCell(11); 
						if (R7cell5 != null) {
							R7cell5.setCellValue(brf68.getR7_amount1() == null ? 0 : brf68.getR7_amount1().intValue());
						}
						Cell R7cell6 = row7.getCell(12); 
						if (R7cell6 != null) {
							R7cell6.setCellValue(brf68.getR7_nos2() == null ? 0 : brf68.getR7_nos2().intValue());
						}
						Cell R7cell7 = row7.getCell(13); 
						if (R7cell7 != null) {
							R7cell7.setCellValue(brf68.getR7_amount2() == null ? 0 : brf68.getR7_amount2().intValue());
						}
						Cell R7cell8 = row7.getCell(14); 
						if (R7cell8 != null) {
							R7cell8.setCellValue(brf68.getR7_nos3() == null ? 0 : brf68.getR7_nos3().intValue());
						}
						Cell R7cell9 = row7.getCell(15); 
						if (R7cell9 != null) {
							R7cell9.setCellValue(brf68.getR7_amount3() == null ? 0 : brf68.getR7_amount3().intValue());
						}
						Cell R7cell10 = row7.getCell(16); 
						if (R7cell10 != null) {
							R7cell10.setCellValue(brf68.getR7_nos4() == null ? 0 : brf68.getR7_nos4().intValue());
						}
						Cell R7cell11 = row7.getCell(17); 
						if (R7cell11 != null) {
							R7cell11.setCellValue(brf68.getR7_amount4() == null ? 0 : brf68.getR7_amount4().intValue());
						}
						Cell R7cell12 = row7.getCell(18); 
						if (R7cell12 != null) {
							R7cell12.setCellValue(brf68.getR7_nos5() == null ? 0 : brf68.getR7_nos5().intValue());
						}
						Cell R7cell13 = row7.getCell(19); 
						if (R7cell13 != null) {
							R7cell13.setCellValue(brf68.getR7_amount5() == null ? 0 : brf68.getR7_amount5().intValue());
						}
						Cell R7cell14 = row7.getCell(20); 
						if (R7cell14 != null) {
							R7cell14.setCellValue(brf68.getR7_nos6() == null ? 0 : brf68.getR7_nos6().intValue());
						}
						Cell R7cell15 = row7.getCell(21); 
						if (R7cell15 != null) {
							R7cell15.setCellValue(brf68.getR7_amount6() == null ? 0 : brf68.getR7_amount6().intValue());
						}
						Cell R7cell16 = row7.getCell(22); 
						if (R7cell16 != null) {
							R7cell16.setCellValue(brf68.getR7_nos7() == null ? 0 : brf68.getR7_nos7().intValue());
						}
						Cell  R7cell17 = row7.getCell(23); 
						if (R7cell17 != null) {
							R7cell17.setCellValue(brf68.getR7_amount7() == null ? 0 : brf68.getR7_amount7().intValue());
						}
						Cell  R7cell18 = row7.getCell(24); 
						if (R7cell18 != null) {
							R7cell18.setCellValue(brf68.getR7_nos8() == null ? 0 : brf68.getR7_nos8().intValue());
						}
						Cell  R7cell19 = row7.getCell(25); 
						if (R7cell19 != null) {
							R7cell19.setCellValue(brf68.getR7_amount8() == null ? 0 : brf68.getR7_amount8().intValue());
						}
						Cell  R7cell20 = row7.getCell(26); 
						if (R7cell20 != null) {
							R7cell20.setCellValue(brf68.getR7_nos9() == null ? 0 : brf68.getR7_nos9().intValue());
						}
						Cell  R7cell21 = row7.getCell(27); 
						if (R7cell21 != null) {
							R7cell21.setCellValue(brf68.getR7_amount9() == null ? 0 : brf68.getR7_amount9().intValue());
						}
						Cell R7cell22 = row7.getCell(28); 
						if (R7cell22 != null) {
							R7cell22.setCellValue(brf68.getR7_nos10() == null ? 0 : brf68.getR7_nos10().intValue());
						}
						Cell  R7cell23 = row7.getCell(29); 
						if (R7cell23 != null) {
							R7cell23.setCellValue(brf68.getR7_amount10() == null ? 0 : brf68.getR7_amount10().intValue());
						}
						Cell R7cell24 = row7.getCell(30); 
						if (R7cell24 != null) {
							R7cell24.setCellValue(brf68.getR7_nos11() == null ? 0 : brf68.getR7_nos11().intValue());
						}
						Cell  R7cell25 = row7.getCell(31); 
						if (R7cell25 != null) {
							R7cell25.setCellValue(brf68.getR7_amount11() == null ? 0 : brf68.getR7_amount11().intValue());
						}
						Cell  R7cell26 = row7.getCell(32); 
						if (R7cell26 != null) {
							R7cell26.setCellValue(brf68.getR7_nos12() == null ? 0 : brf68.getR7_nos12().intValue());
						}
						Cell  R7cell27 = row7.getCell(33); 
						if (R7cell27 != null) {
							R7cell27.setCellValue(brf68.getR7_amount12() == null ? 0 : brf68.getR7_amount12().intValue());
						}
						Cell  R7cell28 = row7.getCell(34); 
						if (R7cell28 != null) {
							R7cell28.setCellValue(brf68.getR7_nos13() == null ? 0 : brf68.getR7_nos13().intValue());
						}
						Cell  R7cell29 = row7.getCell(35); 
						if (R7cell29 != null) {
							R7cell29.setCellValue(brf68.getR7_amount13() == null ? 0 : brf68.getR7_amount13().intValue());
						}
						Cell  R7cell30 = row7.getCell(36); 
						if (R7cell30 != null) {
							R7cell30.setCellValue(brf68.getR7_nos14() == null ? 0 : brf68.getR7_nos14().intValue());
						}
						Cell  R7cell31 = row7.getCell(37); 
						if (R7cell31 != null) {
							R7cell31.setCellValue(brf68.getR7_amount14() == null ? 0 : brf68.getR7_amount14().intValue());
						}
						
						///row8
						Row row8 = sheet.getRow(17);
						/*
						 * Cell R8cell1 = row8.getCell(4); if (R8cell1 != null) {
						 * R8cell1.setCellValue(brf68.getR8_male() == null ? 0 :
						 * brf68.getR8_male().intValue()); } Cell R8cell2 = row8.getCell(5); if (R8cell2
						 * != null) { R8cell2.setCellValue(brf68.getR8_female() == null ? 0 :
						 * brf68.getR8_female().intValue()); }
						 */
						Cell R8cell3 = row8.getCell(6); 
						if (R8cell3 != null) {
							R8cell3.setCellValue(brf68.getR8_entities() == null ? 0 : brf68.getR8_entities().intValue());
						}
						Cell R8cell4 = row8.getCell(10); 
						if (R8cell4 != null) {
							R8cell4.setCellValue(brf68.getR8_nos1() == null ? 0 : brf68.getR8_nos1().intValue());
						}
						Cell R8cell5 = row8.getCell(11); 
						if (R8cell5 != null) {
							R8cell5.setCellValue(brf68.getR8_amount1() == null ? 0 : brf68.getR8_amount1().intValue());
						}
						Cell R8cell6 = row8.getCell(12); 
						if (R8cell6 != null) {
							R8cell6.setCellValue(brf68.getR8_nos2() == null ? 0 : brf68.getR8_nos2().intValue());
						}
						Cell R8cell7 = row8.getCell(13); 
						if (R8cell7 != null) {
							R8cell7.setCellValue(brf68.getR8_amount2() == null ? 0 : brf68.getR8_amount2().intValue());
						}
						Cell R8cell8 = row8.getCell(14); 
						if (R8cell8 != null) {
							R8cell8.setCellValue(brf68.getR8_nos3() == null ? 0 : brf68.getR8_nos3().intValue());
						}
						Cell R8cell9 = row8.getCell(15); 
						if (R8cell9 != null) {
							R8cell9.setCellValue(brf68.getR8_amount3() == null ? 0 : brf68.getR8_amount3().intValue());
						}
						Cell R8cell10 = row8.getCell(16); 
						if (R8cell10 != null) {
							R8cell10.setCellValue(brf68.getR8_nos4() == null ? 0 : brf68.getR8_nos4().intValue());
						}
						Cell R8cell11 = row8.getCell(17); 
						if (R8cell11 != null) {
							R8cell11.setCellValue(brf68.getR8_amount4() == null ? 0 : brf68.getR8_amount4().intValue());
						}
						Cell R8cell12 = row8.getCell(18); 
						if (R8cell12 != null) {
							R8cell12.setCellValue(brf68.getR8_nos5() == null ? 0 : brf68.getR8_nos5().intValue());
						}
						Cell R8cell13 = row8.getCell(19); 
						if (R8cell13 != null) {
							R8cell13.setCellValue(brf68.getR8_amount5() == null ? 0 : brf68.getR8_amount5().intValue());
						}
						Cell R8cell14 = row8.getCell(20); 
						if (R8cell14 != null) {
							R8cell14.setCellValue(brf68.getR8_nos6() == null ? 0 : brf68.getR8_nos6().intValue());
						}
						Cell R8cell15 = row8.getCell(21); 
						if (R8cell15 != null) {
							R8cell15.setCellValue(brf68.getR8_amount6() == null ? 0 : brf68.getR8_amount6().intValue());
						}
						Cell R8cell16 = row8.getCell(22); 
						if (R8cell16 != null) {
							R8cell16.setCellValue(brf68.getR8_nos7() == null ? 0 : brf68.getR8_nos7().intValue());
						}
						Cell  R8cell17 = row8.getCell(23); 
						if (R8cell17 != null) {
							R8cell17.setCellValue(brf68.getR8_amount7() == null ? 0 : brf68.getR8_amount7().intValue());
						}
						Cell  R8cell18 = row8.getCell(24); 
						if (R8cell18 != null) {
							R8cell18.setCellValue(brf68.getR8_nos8() == null ? 0 : brf68.getR8_nos8().intValue());
						}
						Cell  R8cell19 = row8.getCell(25); 
						if (R8cell19 != null) {
							R8cell19.setCellValue(brf68.getR8_amount8() == null ? 0 : brf68.getR8_amount8().intValue());
						}
						Cell  R8cell20 = row8.getCell(26); 
						if (R8cell20 != null) {
							R8cell20.setCellValue(brf68.getR8_nos9() == null ? 0 : brf68.getR8_nos9().intValue());
						}
						Cell  R8cell21 = row8.getCell(27); 
						if (R8cell21 != null) {
							R8cell21.setCellValue(brf68.getR8_amount9() == null ? 0 : brf68.getR8_amount9().intValue());
						}
						Cell R8cell22 = row8.getCell(28); 
						if (R8cell22 != null) {
							R8cell22.setCellValue(brf68.getR8_nos10() == null ? 0 : brf68.getR8_nos10().intValue());
						}
						Cell  R8cell23 = row8.getCell(29); 
						if (R8cell23 != null) {
							R8cell23.setCellValue(brf68.getR8_amount10() == null ? 0 : brf68.getR8_amount10().intValue());
						}
						Cell R8cell24 = row8.getCell(30); 
						if (R8cell24 != null) {
							R8cell24.setCellValue(brf68.getR8_nos11() == null ? 0 : brf68.getR8_nos11().intValue());
						}
						Cell  R8cell25 = row8.getCell(31); 
						if (R8cell25 != null) {
							R8cell25.setCellValue(brf68.getR8_amount11() == null ? 0 : brf68.getR8_amount11().intValue());
						}
						Cell  R8cell26 = row8.getCell(32); 
						if (R8cell26 != null) {
							R8cell26.setCellValue(brf68.getR8_nos12() == null ? 0 : brf68.getR8_nos12().intValue());
						}
						Cell  R8cell27 = row8.getCell(33); 
						if (R8cell27 != null) {
							R8cell27.setCellValue(brf68.getR8_amount12() == null ? 0 : brf68.getR8_amount12().intValue());
						}
						Cell  R8cell28 = row8.getCell(34); 
						if (R8cell28 != null) {
							R8cell28.setCellValue(brf68.getR8_nos13() == null ? 0 : brf68.getR8_nos13().intValue());
						}
						Cell  R8cell29 = row8.getCell(35); 
						if (R8cell29 != null) {
							R8cell29.setCellValue(brf68.getR8_amount13() == null ? 0 : brf68.getR8_amount13().intValue());
						}
						Cell  R8cell30 = row8.getCell(36); 
						if (R8cell30 != null) {
							R8cell30.setCellValue(brf68.getR8_nos14() == null ? 0 : brf68.getR8_nos14().intValue());
						}
						Cell  R8cell31 = row8.getCell(37); 
						if (R8cell31 != null) {
							R8cell31.setCellValue(brf68.getR8_amount14() == null ? 0 : brf68.getR8_amount14().intValue());
						}
						
						Row row9 = sheet.getRow(18);
						/*
						 * Cell R9cell1 = row9.getCell(4); if (R9cell1 != null) {
						 * R9cell1.setCellValue(brf68.getR9_male() == null ? 0 :
						 * brf68.getR9_male().intValue()); } Cell R9cell2 = row9.getCell(5); if (R9cell2
						 * != null) { R9cell2.setCellValue(brf68.getR9_female() == null ? 0 :
						 * brf68.getR9_female().intValue()); }
						 */
						Cell R9cell3 = row9.getCell(6); 
						if (R9cell3 != null) {
							R9cell3.setCellValue(brf68.getR9_entities() == null ? 0 : brf68.getR9_entities().intValue());
						}
						Cell R9cell4 = row9.getCell(10); 
						if (R9cell4 != null) {
							R9cell4.setCellValue(brf68.getR9_nos1() == null ? 0 : brf68.getR9_nos1().intValue());
						}
						Cell R9cell5 = row9.getCell(11); 
						if (R9cell5 != null) {
							R9cell5.setCellValue(brf68.getR9_amount1() == null ? 0 : brf68.getR9_amount1().intValue());
						}
						Cell R9cell6 = row9.getCell(12); 
						if (R9cell6 != null) {
							R9cell6.setCellValue(brf68.getR9_nos2() == null ? 0 : brf68.getR9_nos2().intValue());
						}
						Cell R9cell7 = row9.getCell(13); 
						if (R9cell7 != null) {
							R9cell7.setCellValue(brf68.getR9_amount2() == null ? 0 : brf68.getR9_amount2().intValue());
						}
						Cell R9cell8 = row9.getCell(14); 
						if (R9cell8 != null) {
							R9cell8.setCellValue(brf68.getR9_nos3() == null ? 0 : brf68.getR9_nos3().intValue());
						}
						Cell R9cell9 = row9.getCell(15); 
						if (R9cell9 != null) {
							R9cell9.setCellValue(brf68.getR9_amount3() == null ? 0 : brf68.getR9_amount3().intValue());
						}
						Cell R9cell10 = row9.getCell(16); 
						if (R9cell10 != null) {
							R9cell10.setCellValue(brf68.getR9_nos4() == null ? 0 : brf68.getR9_nos4().intValue());
						}
						Cell R9cell11 = row9.getCell(17); 
						if (R9cell11 != null) {
							R9cell11.setCellValue(brf68.getR9_amount4() == null ? 0 : brf68.getR9_amount4().intValue());
						}
						Cell R9cell12 = row9.getCell(18); 
						if (R9cell12 != null) {
							R9cell12.setCellValue(brf68.getR9_nos5() == null ? 0 : brf68.getR9_nos5().intValue());
						}
						Cell R9cell13 = row9.getCell(19); 
						if (R9cell13 != null) {
							R9cell13.setCellValue(brf68.getR9_amount5() == null ? 0 : brf68.getR9_amount5().intValue());
						}
						Cell R9cell14 = row9.getCell(20); 
						if (R9cell14 != null) {
							R9cell14.setCellValue(brf68.getR9_nos6() == null ? 0 : brf68.getR9_nos6().intValue());
						}
						Cell R9cell15 = row9.getCell(21); 
						if (R9cell15 != null) {
							R9cell15.setCellValue(brf68.getR9_amount6() == null ? 0 : brf68.getR9_amount6().intValue());
						}
						Cell R9cell16 = row9.getCell(22); 
						if (R9cell16 != null) {
							R9cell16.setCellValue(brf68.getR9_nos7() == null ? 0 : brf68.getR9_nos7().intValue());
						}
						Cell  R9cell17 = row9.getCell(23); 
						if (R9cell17 != null) {
							R9cell17.setCellValue(brf68.getR9_amount7() == null ? 0 : brf68.getR9_amount7().intValue());
						}
						Cell  R9cell18 = row9.getCell(24); 
						if (R9cell18 != null) {
							R9cell18.setCellValue(brf68.getR9_nos8() == null ? 0 : brf68.getR9_nos8().intValue());
						}
						Cell  R9cell19 = row9.getCell(25); 
						if (R9cell19 != null) {
							R9cell19.setCellValue(brf68.getR9_amount8() == null ? 0 : brf68.getR9_amount8().intValue());
						}
						Cell  R9cell20 = row9.getCell(26); 
						if (R9cell20 != null) {
							R9cell20.setCellValue(brf68.getR9_nos9() == null ? 0 : brf68.getR9_nos9().intValue());
						}
						Cell  R9cell21 = row9.getCell(27); 
						if (R9cell21 != null) {
							R9cell21.setCellValue(brf68.getR9_amount9() == null ? 0 : brf68.getR9_amount9().intValue());
						}
						Cell R9cell22 = row9.getCell(28); 
						if (R9cell22 != null) {
							R9cell22.setCellValue(brf68.getR9_nos10() == null ? 0 : brf68.getR9_nos10().intValue());
						}
						Cell  R9cell23 = row9.getCell(29); 
						if (R9cell23 != null) {
							R9cell23.setCellValue(brf68.getR9_amount10() == null ? 0 : brf68.getR9_amount10().intValue());
						}
						Cell R9cell24 = row9.getCell(30); 
						if (R9cell24 != null) {
							R9cell24.setCellValue(brf68.getR9_nos11() == null ? 0 : brf68.getR9_nos11().intValue());
						}
						Cell  R9cell25 = row9.getCell(31); 
						if (R9cell25 != null) {
							R9cell25.setCellValue(brf68.getR9_amount11() == null ? 0 : brf68.getR9_amount11().intValue());
						}
						Cell  R9cell26 = row9.getCell(32); 
						if (R9cell26 != null) {
							R9cell26.setCellValue(brf68.getR9_nos12() == null ? 0 : brf68.getR9_nos12().intValue());
						}
						Cell  R9cell27 = row9.getCell(33); 
						if (R9cell27 != null) {
							R9cell27.setCellValue(brf68.getR9_amount12() == null ? 0 : brf68.getR9_amount12().intValue());
						}
						Cell  R9cell28 = row9.getCell(34); 
						if (R9cell28 != null) {
							R9cell28.setCellValue(brf68.getR9_nos13() == null ? 0 : brf68.getR9_nos13().intValue());
						}
						Cell  R9cell29 = row9.getCell(35); 
						if (R9cell29 != null) {
							R9cell29.setCellValue(brf68.getR9_amount13() == null ? 0 : brf68.getR9_amount13().intValue());
						}
						Cell  R9cell30 = row9.getCell(36); 
						if (R9cell30 != null) {
							R9cell30.setCellValue(brf68.getR9_nos14() == null ? 0 : brf68.getR9_nos14().intValue());
						}
						Cell  R9cell31 = row9.getCell(37); 
						if (R9cell31 != null) {
							R9cell31.setCellValue(brf68.getR9_amount14() == null ? 0 : brf68.getR9_amount14().intValue());
						}
						
			            Row row10 = sheet.getRow(19);
						/*
						 * Cell R10cell1 = row10.getCell(4); if (R10cell1 != null) {
						 * R10cell1.setCellValue(brf68.getR10_male() == null ? 0 :
						 * brf68.getR10_male().intValue()); } Cell R10cell2 = row10.getCell(5); if
						 * (R10cell2 != null) { R10cell2.setCellValue(brf68.getR10_female() == null ? 0
						 * : brf68.getR10_female().intValue()); }
						 */
						Cell R10cell3 = row10.getCell(6); 
						if (R10cell3 != null) {
							R10cell3.setCellValue(brf68.getR10_entities() == null ? 0 : brf68.getR10_entities().intValue());
						}
						Cell R10cell4 = row10.getCell(10); 
						if (R10cell4 != null) {
							R10cell4.setCellValue(brf68.getR10_nos1() == null ? 0 : brf68.getR10_nos1().intValue());
						}
						Cell R10cell5 = row10.getCell(11); 
						if (R10cell5 != null) {
							R10cell5.setCellValue(brf68.getR10_amount1() == null ? 0 : brf68.getR10_amount1().intValue());
						}
						Cell R10cell6 = row10.getCell(12); 
						if (R10cell6 != null) {
							R10cell6.setCellValue(brf68.getR10_nos2() == null ? 0 : brf68.getR10_nos2().intValue());
						}
						Cell R10cell7 = row10.getCell(13); 
						if (R10cell7 != null) {
							R10cell7.setCellValue(brf68.getR10_amount2() == null ? 0 : brf68.getR10_amount2().intValue());
						}
						Cell R10cell8 = row10.getCell(14); 
						if (R10cell8 != null) {
							R10cell8.setCellValue(brf68.getR10_nos3() == null ? 0 : brf68.getR10_nos3().intValue());
						}
						Cell R10cell9 = row10.getCell(15); 
						if (R10cell9 != null) {
							R10cell9.setCellValue(brf68.getR10_amount3() == null ? 0 : brf68.getR10_amount3().intValue());
						}
						Cell R10cell10 = row10.getCell(16); 
						if (R10cell10 != null) {
							R10cell10.setCellValue(brf68.getR10_nos4() == null ? 0 : brf68.getR10_nos4().intValue());
						}
						Cell R10cell11 = row10.getCell(17); 
						if (R10cell11 != null) {
							R10cell11.setCellValue(brf68.getR10_amount4() == null ? 0 : brf68.getR10_amount4().intValue());
						}
						Cell R10cell12 = row10.getCell(18); 
						if (R10cell12 != null) {
							R10cell12.setCellValue(brf68.getR10_nos5() == null ? 0 : brf68.getR10_nos5().intValue());
						}
						Cell R10cell13 = row10.getCell(19); 
						if (R10cell13 != null) {
							R10cell13.setCellValue(brf68.getR10_amount5() == null ? 0 : brf68.getR10_amount5().intValue());
						}
						Cell R10cell14 = row10.getCell(20); 
						if (R10cell14 != null) {
							R10cell14.setCellValue(brf68.getR10_nos6() == null ? 0 : brf68.getR10_nos6().intValue());
						}
						Cell R10cell15 = row10.getCell(21); 
						if (R10cell15 != null) {
							R10cell15.setCellValue(brf68.getR10_amount6() == null ? 0 : brf68.getR10_amount6().intValue());
						}
						Cell R10cell16 = row10.getCell(22); 
						if (R10cell16 != null) {
							R10cell16.setCellValue(brf68.getR10_nos7() == null ? 0 : brf68.getR10_nos7().intValue());
						}
						Cell  R10cell17 = row10.getCell(23); 
						if (R10cell17 != null) {
							R10cell17.setCellValue(brf68.getR10_amount7() == null ? 0 : brf68.getR10_amount7().intValue());
						}
						Cell  R10cell18 = row10.getCell(24); 
						if (R10cell18 != null) {
							R10cell18.setCellValue(brf68.getR10_nos8() == null ? 0 : brf68.getR10_nos8().intValue());
						}
						Cell  R10cell19 = row10.getCell(25); 
						if (R10cell19 != null) {
							R10cell19.setCellValue(brf68.getR10_amount8() == null ? 0 : brf68.getR10_amount8().intValue());
						}
						Cell  R10cell20 = row10.getCell(26); 
						if (R10cell20 != null) {
							R10cell20.setCellValue(brf68.getR10_nos9() == null ? 0 : brf68.getR10_nos9().intValue());
						}
						Cell  R10cell21 = row10.getCell(27); 
						if (R10cell21 != null) {
							R10cell21.setCellValue(brf68.getR10_amount9() == null ? 0 : brf68.getR10_amount9().intValue());
						}
						Cell R10cell22 = row10.getCell(28); 
						if (R10cell22 != null) {
							R10cell22.setCellValue(brf68.getR10_nos10() == null ? 0 : brf68.getR10_nos10().intValue());
						}
						Cell  R10cell23 = row10.getCell(29); 
						if (R10cell23 != null) {
							R10cell23.setCellValue(brf68.getR10_amount10() == null ? 0 : brf68.getR10_amount10().intValue());
						}
						Cell R10cell24 = row10.getCell(30); 
						if (R10cell24 != null) {
							R10cell24.setCellValue(brf68.getR10_nos11() == null ? 0 : brf68.getR10_nos11().intValue());
						}
						Cell  R10cell25 = row10.getCell(31); 
						if (R10cell25 != null) {
							R10cell25.setCellValue(brf68.getR10_amount11() == null ? 0 : brf68.getR10_amount11().intValue());
						}
						Cell  R10cell26 = row10.getCell(32); 
						if (R10cell26 != null) {
							R10cell26.setCellValue(brf68.getR10_nos12() == null ? 0 : brf68.getR10_nos12().intValue());
						}
						Cell  R10cell27 = row10.getCell(33); 
						if (R10cell27 != null) {
							R10cell27.setCellValue(brf68.getR10_amount12() == null ? 0 : brf68.getR10_amount12().intValue());
						}
						Cell  R10cell28 = row10.getCell(34); 
						if (R10cell28 != null) {
							R10cell28.setCellValue(brf68.getR10_nos13() == null ? 0 : brf68.getR10_nos13().intValue());
						}
						Cell  R10cell29 = row10.getCell(35); 
						if (R10cell29 != null) {
							R10cell29.setCellValue(brf68.getR10_amount13() == null ? 0 : brf68.getR10_amount13().intValue());
						}
						Cell  R10cell30 = row10.getCell(36); 
						if (R10cell30 != null) {
							R10cell30.setCellValue(brf68.getR10_nos14() == null ? 0 : brf68.getR10_nos14().intValue());
						}
						Cell  R10cell31 = row10.getCell(37); 
						if (R10cell31 != null) {
							R10cell31.setCellValue(brf68.getR10_amount14() == null ? 0 : brf68.getR10_amount14().intValue());
						}
						
			            Row row13 = sheet.getRow(22);
			            Cell R13cell1 = row13.getCell(4); 
						if (R13cell1 != null) {
							R13cell1.setCellValue(brf68.getR13_male() == null ? 0 : brf68.getR13_male().intValue());
						}
						Cell R13cell2 = row13.getCell(5); 
						if (R13cell2 != null) {
							R13cell2.setCellValue(brf68.getR13_female() == null ? 0 : brf68.getR13_female().intValue());
						}
						Cell R13cell3 = row13.getCell(6); 
						if (R13cell3 != null) {
							R13cell3.setCellValue(brf68.getR13_entities() == null ? 0 : brf68.getR13_entities().intValue());
						}
						Cell R13cell4 = row13.getCell(10); 
						if (R13cell4 != null) {
							R13cell4.setCellValue(brf68.getR13_nos1() == null ? 0 : brf68.getR13_nos1().intValue());
						}
						Cell R13cell5 = row13.getCell(11); 
						if (R13cell5 != null) {
							R13cell5.setCellValue(brf68.getR13_amount1() == null ? 0 : brf68.getR13_amount1().intValue());
						}
						Cell R13cell6 = row13.getCell(12); 
						if (R13cell6 != null) {
							R13cell6.setCellValue(brf68.getR13_nos2() == null ? 0 : brf68.getR13_nos2().intValue());
						}
						Cell R13cell7 = row13.getCell(13); 
						if (R13cell7 != null) {
							R13cell7.setCellValue(brf68.getR13_amount2() == null ? 0 : brf68.getR13_amount2().intValue());
						}
						Cell R13cell8 = row13.getCell(14); 
						if (R13cell8 != null) {
							R13cell8.setCellValue(brf68.getR13_nos3() == null ? 0 : brf68.getR13_nos3().intValue());
						}
						Cell R13cell9 = row13.getCell(15); 
						if (R13cell9 != null) {
							R13cell9.setCellValue(brf68.getR13_amount3() == null ? 0 : brf68.getR13_amount3().intValue());
						}
						Cell R13cell10 = row13.getCell(16); 
						if (R13cell10 != null) {
							R13cell10.setCellValue(brf68.getR13_nos4() == null ? 0 : brf68.getR13_nos4().intValue());
						}
						Cell R13cell11 = row13.getCell(17); 
						if (R13cell11 != null) {
							R13cell11.setCellValue(brf68.getR13_amount4() == null ? 0 : brf68.getR13_amount4().intValue());
						}
						Cell R13cell12 = row13.getCell(18); 
						if (R13cell12 != null) {
							R13cell12.setCellValue(brf68.getR13_nos5() == null ? 0 : brf68.getR13_nos5().intValue());
						}
						Cell R13cell13 = row13.getCell(19); 
						if (R13cell13 != null) {
							R13cell13.setCellValue(brf68.getR13_amount5() == null ? 0 : brf68.getR13_amount5().intValue());
						}
						Cell R13cell14 = row13.getCell(20); 
						if (R13cell14 != null) {
							R13cell14.setCellValue(brf68.getR13_nos6() == null ? 0 : brf68.getR13_nos6().intValue());
						}
						Cell R13cell15 = row13.getCell(21); 
						if (R13cell15 != null) {
							R13cell15.setCellValue(brf68.getR13_amount6() == null ? 0 : brf68.getR13_amount6().intValue());
						}
						Cell R13cell16 = row13.getCell(22); 
						if (R13cell16 != null) {
							R13cell16.setCellValue(brf68.getR13_nos7() == null ? 0 : brf68.getR13_nos7().intValue());
						}
						Cell  R13cell17 = row13.getCell(23); 
						if (R13cell17 != null) {
							R13cell17.setCellValue(brf68.getR13_amount7() == null ? 0 : brf68.getR13_amount7().intValue());
						}
						Cell  R13cell18 = row13.getCell(24); 
						if (R13cell18 != null) {
							R13cell18.setCellValue(brf68.getR13_nos8() == null ? 0 : brf68.getR13_nos8().intValue());
						}
						Cell  R13cell19 = row13.getCell(25); 
						if (R13cell19 != null) {
							R13cell19.setCellValue(brf68.getR13_amount8() == null ? 0 : brf68.getR13_amount8().intValue());
						}
						Cell  R13cell20 = row13.getCell(26); 
						if (R13cell20 != null) {
							R13cell20.setCellValue(brf68.getR13_nos9() == null ? 0 : brf68.getR13_nos9().intValue());
						}
						Cell  R13cell21 = row13.getCell(27); 
						if (R13cell21 != null) {
							R13cell21.setCellValue(brf68.getR13_amount9() == null ? 0 : brf68.getR13_amount9().intValue());
						}
						Cell R13cell22 = row13.getCell(28); 
						if (R13cell22 != null) {
							R13cell22.setCellValue(brf68.getR13_nos10() == null ? 0 : brf68.getR13_nos10().intValue());
						}
						Cell  R13cell23 = row13.getCell(29); 
						if (R13cell23 != null) {
							R13cell23.setCellValue(brf68.getR13_amount10() == null ? 0 : brf68.getR13_amount10().intValue());
						}
						Cell R13cell24 = row13.getCell(30); 
						if (R13cell24 != null) {
							R13cell24.setCellValue(brf68.getR13_nos11() == null ? 0 : brf68.getR13_nos11().intValue());
						}
						Cell  R13cell25 = row13.getCell(31); 
						if (R13cell25 != null) {
							R13cell25.setCellValue(brf68.getR13_amount11() == null ? 0 : brf68.getR13_amount11().intValue());
						}
						Cell  R13cell26 = row13.getCell(32); 
						if (R13cell26 != null) {
							R13cell26.setCellValue(brf68.getR13_nos12() == null ? 0 : brf68.getR13_nos12().intValue());
						}
						Cell  R13cell27 = row13.getCell(33); 
						if (R13cell27 != null) {
							R13cell27.setCellValue(brf68.getR13_amount12() == null ? 0 : brf68.getR13_amount12().intValue());
						}
						Cell  R13cell28 = row13.getCell(34); 
						if (R13cell28 != null) {
							R13cell28.setCellValue(brf68.getR13_nos13() == null ? 0 : brf68.getR13_nos13().intValue());
						}
						Cell  R13cell29 = row13.getCell(35); 
						if (R13cell29 != null) {
							R13cell29.setCellValue(brf68.getR13_amount13() == null ? 0 : brf68.getR13_amount13().intValue());
						}
						Cell  R13cell30 = row13.getCell(36); 
						if (R13cell30 != null) {
							R13cell30.setCellValue(brf68.getR13_nos14() == null ? 0 : brf68.getR13_nos14().intValue());
						}
						Cell  R13cell31 = row13.getCell(37); 
						if (R13cell31 != null) {
							R13cell31.setCellValue(brf68.getR13_amount14() == null ? 0 : brf68.getR13_amount14().intValue());
						}
						
			            Row row14 = sheet.getRow(23);
			            Cell R14cell1 = row14.getCell(4); 
						if (R14cell1 != null) {
							R14cell1.setCellValue(brf68.getR14_male() == null ? 0 : brf68.getR14_male().intValue());
						}
						Cell R14cell2 = row14.getCell(5); 
						if (R14cell2 != null) {
							R14cell2.setCellValue(brf68.getR14_female() == null ? 0 : brf68.getR14_female().intValue());
						}
						Cell R14cell3 = row14.getCell(6); 
						if (R14cell3 != null) {
							R14cell3.setCellValue(brf68.getR14_entities() == null ? 0 : brf68.getR14_entities().intValue());
						}
						Cell R14cell4 = row14.getCell(10); 
						if (R14cell4 != null) {
							R14cell4.setCellValue(brf68.getR14_nos1() == null ? 0 : brf68.getR14_nos1().intValue());
						}
						Cell R14cell5 = row14.getCell(11); 
						if (R14cell5 != null) {
							R14cell5.setCellValue(brf68.getR14_amount1() == null ? 0 : brf68.getR14_amount1().intValue());
						}
						Cell R14cell6 = row14.getCell(12); 
						if (R14cell6 != null) {
							R14cell6.setCellValue(brf68.getR14_nos2() == null ? 0 : brf68.getR14_nos2().intValue());
						}
						Cell R14cell7 = row14.getCell(13); 
						if (R14cell7 != null) {
							R14cell7.setCellValue(brf68.getR14_amount2() == null ? 0 : brf68.getR14_amount2().intValue());
						}
						Cell R14cell8 = row14.getCell(14); 
						if (R14cell8 != null) {
							R14cell8.setCellValue(brf68.getR14_nos3() == null ? 0 : brf68.getR14_nos3().intValue());
						}
						Cell R14cell9 = row14.getCell(15); 
						if (R14cell9 != null) {
							R14cell9.setCellValue(brf68.getR14_amount3() == null ? 0 : brf68.getR14_amount3().intValue());
						}
						Cell R14cell10 = row14.getCell(16); 
						if (R14cell10 != null) {
							R14cell10.setCellValue(brf68.getR14_nos4() == null ? 0 : brf68.getR14_nos4().intValue());
						}
						Cell R14cell11 = row14.getCell(17); 
						if (R14cell11 != null) {
							R14cell11.setCellValue(brf68.getR14_amount4() == null ? 0 : brf68.getR14_amount4().intValue());
						}
						Cell R14cell12 = row14.getCell(18); 
						if (R14cell12 != null) {
							R14cell12.setCellValue(brf68.getR14_nos5() == null ? 0 : brf68.getR14_nos5().intValue());
						}
						Cell R14cell13 = row14.getCell(19); 
						if (R14cell13 != null) {
							R14cell13.setCellValue(brf68.getR14_amount5() == null ? 0 : brf68.getR14_amount5().intValue());
						}
						Cell R14cell14 = row14.getCell(20); 
						if (R14cell14 != null) {
							R14cell14.setCellValue(brf68.getR14_nos6() == null ? 0 : brf68.getR14_nos6().intValue());
						}
						Cell R14cell15 = row14.getCell(21); 
						if (R14cell15 != null) {
							R14cell15.setCellValue(brf68.getR14_amount6() == null ? 0 : brf68.getR14_amount6().intValue());
						}
						Cell R14cell16 = row14.getCell(22); 
						if (R14cell16 != null) {
							R14cell16.setCellValue(brf68.getR14_nos7() == null ? 0 : brf68.getR14_nos7().intValue());
						}
						Cell  R14cell17 = row14.getCell(23); 
						if (R14cell17 != null) {
							R14cell17.setCellValue(brf68.getR14_amount7() == null ? 0 : brf68.getR14_amount7().intValue());
						}
						Cell  R14cell18 = row14.getCell(24); 
						if (R14cell18 != null) {
							R14cell18.setCellValue(brf68.getR14_nos8() == null ? 0 : brf68.getR14_nos8().intValue());
						}
						Cell  R14cell19 = row14.getCell(25); 
						if (R14cell19 != null) {
							R14cell19.setCellValue(brf68.getR14_amount8() == null ? 0 : brf68.getR14_amount8().intValue());
						}
						Cell  R14cell20 = row14.getCell(26); 
						if (R14cell20 != null) {
							R14cell20.setCellValue(brf68.getR14_nos9() == null ? 0 : brf68.getR14_nos9().intValue());
						}
						Cell  R14cell21 = row14.getCell(27); 
						if (R14cell21 != null) {
							R14cell21.setCellValue(brf68.getR14_amount9() == null ? 0 : brf68.getR14_amount9().intValue());
						}
						Cell R14cell22 = row14.getCell(28); 
						if (R14cell22 != null) {
							R14cell22.setCellValue(brf68.getR14_nos10() == null ? 0 : brf68.getR14_nos10().intValue());
						}
						Cell  R14cell23 = row14.getCell(29); 
						if (R14cell23 != null) {
							R14cell23.setCellValue(brf68.getR14_amount10() == null ? 0 : brf68.getR14_amount10().intValue());
						}
						Cell R14cell24 = row14.getCell(30); 
						if (R14cell24 != null) {
							R14cell24.setCellValue(brf68.getR14_nos11() == null ? 0 : brf68.getR14_nos11().intValue());
						}
						Cell  R14cell25 = row14.getCell(31); 
						if (R14cell25 != null) {
							R14cell25.setCellValue(brf68.getR14_amount11() == null ? 0 : brf68.getR14_amount11().intValue());
						}
						Cell  R14cell26 = row14.getCell(32); 
						if (R14cell26 != null) {
							R14cell26.setCellValue(brf68.getR14_nos12() == null ? 0 : brf68.getR14_nos12().intValue());
						}
						Cell  R14cell27 = row14.getCell(33); 
						if (R14cell27 != null) {
							R14cell27.setCellValue(brf68.getR14_amount12() == null ? 0 : brf68.getR14_amount12().intValue());
						}
						Cell  R14cell28 = row14.getCell(34); 
						if (R14cell28 != null) {
							R14cell28.setCellValue(brf68.getR14_nos13() == null ? 0 : brf68.getR14_nos13().intValue());
						}
						Cell  R14cell29 = row14.getCell(35); 
						if (R14cell29 != null) {
							R14cell29.setCellValue(brf68.getR14_amount13() == null ? 0 : brf68.getR14_amount13().intValue());
						}
						Cell  R14cell30 = row14.getCell(36); 
						if (R14cell30 != null) {
							R14cell30.setCellValue(brf68.getR14_nos14() == null ? 0 : brf68.getR14_nos14().intValue());
						}
						Cell  R14cell31 = row14.getCell(37); 
						if (R14cell31 != null) {
							R14cell31.setCellValue(brf68.getR14_amount14() == null ? 0 : brf68.getR14_amount14().intValue());
						}
						
			            Row row15 = sheet.getRow(24);
			            Cell R15cell1 = row15.getCell(4); 
						if (R15cell1 != null) {
							R15cell1.setCellValue(brf68.getR15_male() == null ? 0 : brf68.getR15_male().intValue());
						}
						Cell R15cell2 = row15.getCell(5); 
						if (R15cell2 != null) {
							R15cell2.setCellValue(brf68.getR15_female() == null ? 0 : brf68.getR15_female().intValue());
						}
						Cell R15cell3 = row15.getCell(6); 
						if (R15cell3 != null) {
							R15cell3.setCellValue(brf68.getR15_entities() == null ? 0 : brf68.getR15_entities().intValue());
						}
						Cell R15cell4 = row15.getCell(10); 
						if (R15cell4 != null) {
							R15cell4.setCellValue(brf68.getR15_nos1() == null ? 0 : brf68.getR15_nos1().intValue());
						}
						Cell R15cell5 = row15.getCell(11); 
						if (R15cell5 != null) {
							R15cell5.setCellValue(brf68.getR15_amount1() == null ? 0 : brf68.getR15_amount1().intValue());
						}
						Cell R15cell6 = row15.getCell(12); 
						if (R15cell6 != null) {
							R15cell6.setCellValue(brf68.getR15_nos2() == null ? 0 : brf68.getR15_nos2().intValue());
						}
						Cell R15cell7 = row15.getCell(13); 
						if (R15cell7 != null) {
							R15cell7.setCellValue(brf68.getR15_amount2() == null ? 0 : brf68.getR15_amount2().intValue());
						}
						Cell R15cell8 = row15.getCell(14); 
						if (R15cell8 != null) {
							R15cell8.setCellValue(brf68.getR15_nos3() == null ? 0 : brf68.getR15_nos3().intValue());
						}
						Cell R15cell9 = row15.getCell(15); 
						if (R15cell9 != null) {
							R15cell9.setCellValue(brf68.getR15_amount3() == null ? 0 : brf68.getR15_amount3().intValue());
						}
						Cell R15cell10 = row15.getCell(16); 
						if (R15cell10 != null) {
							R15cell10.setCellValue(brf68.getR15_nos4() == null ? 0 : brf68.getR15_nos4().intValue());
						}
						Cell R15cell11 = row15.getCell(17); 
						if (R15cell11 != null) {
							R15cell11.setCellValue(brf68.getR15_amount4() == null ? 0 : brf68.getR15_amount4().intValue());
						}
						Cell R15cell12 = row15.getCell(18); 
						if (R15cell12 != null) {
							R15cell12.setCellValue(brf68.getR15_nos5() == null ? 0 : brf68.getR15_nos5().intValue());
						}
						Cell R15cell13 = row15.getCell(19); 
						if (R15cell13 != null) {
							R15cell13.setCellValue(brf68.getR15_amount5() == null ? 0 : brf68.getR15_amount5().intValue());
						}
						Cell R15cell14 = row15.getCell(20); 
						if (R15cell14 != null) {
							R15cell14.setCellValue(brf68.getR15_nos6() == null ? 0 : brf68.getR15_nos6().intValue());
						}
						Cell R15cell15 = row15.getCell(21); 
						if (R15cell15 != null) {
							R15cell15.setCellValue(brf68.getR15_amount6() == null ? 0 : brf68.getR15_amount6().intValue());
						}
						Cell R15cell16 = row15.getCell(22); 
						if (R15cell16 != null) {
							R15cell16.setCellValue(brf68.getR15_nos7() == null ? 0 : brf68.getR15_nos7().intValue());
						}
						Cell  R15cell17 = row15.getCell(23); 
						if (R15cell17 != null) {
							R15cell17.setCellValue(brf68.getR15_amount7() == null ? 0 : brf68.getR15_amount7().intValue());
						}
						Cell  R15cell18 = row15.getCell(24); 
						if (R15cell18 != null) {
							R15cell18.setCellValue(brf68.getR15_nos8() == null ? 0 : brf68.getR15_nos8().intValue());
						}
						Cell  R15cell19 = row15.getCell(25); 
						if (R15cell19 != null) {
							R15cell19.setCellValue(brf68.getR15_amount8() == null ? 0 : brf68.getR15_amount8().intValue());
						}
						Cell  R15cell20 = row15.getCell(26); 
						if (R15cell20 != null) {
							R15cell20.setCellValue(brf68.getR15_nos9() == null ? 0 : brf68.getR15_nos9().intValue());
						}
						Cell  R15cell21 = row15.getCell(27); 
						if (R15cell21 != null) {
							R15cell21.setCellValue(brf68.getR15_amount9() == null ? 0 : brf68.getR15_amount9().intValue());
						}
						Cell R15cell22 = row15.getCell(28); 
						if (R15cell22 != null) {
							R15cell22.setCellValue(brf68.getR15_nos10() == null ? 0 : brf68.getR15_nos10().intValue());
						}
						Cell  R15cell23 = row15.getCell(29); 
						if (R15cell23 != null) {
							R15cell23.setCellValue(brf68.getR15_amount10() == null ? 0 : brf68.getR15_amount10().intValue());
						}
						Cell R15cell24 = row15.getCell(30); 
						if (R15cell24 != null) {
							R15cell24.setCellValue(brf68.getR15_nos11() == null ? 0 : brf68.getR15_nos11().intValue());
						}
						Cell  R15cell25 = row15.getCell(31); 
						if (R15cell25 != null) {
							R15cell25.setCellValue(brf68.getR15_amount11() == null ? 0 : brf68.getR15_amount11().intValue());
						}
						Cell  R15cell26 = row15.getCell(32); 
						if (R15cell26 != null) {
							R15cell26.setCellValue(brf68.getR15_nos12() == null ? 0 : brf68.getR15_nos12().intValue());
						}
						Cell  R15cell27 = row15.getCell(33); 
						if (R15cell27 != null) {
							R15cell27.setCellValue(brf68.getR15_amount12() == null ? 0 : brf68.getR15_amount12().intValue());
						}
						Cell  R15cell28 = row15.getCell(34); 
						if (R15cell28 != null) {
							R15cell28.setCellValue(brf68.getR15_nos13() == null ? 0 : brf68.getR15_nos13().intValue());
						}
						Cell  R15cell29 = row15.getCell(35); 
						if (R15cell29 != null) {
							R15cell29.setCellValue(brf68.getR15_amount13() == null ? 0 : brf68.getR15_amount13().intValue());
						}
						Cell  R15cell30 = row15.getCell(36); 
						if (R15cell30 != null) {
							R15cell30.setCellValue(brf68.getR15_nos14() == null ? 0 : brf68.getR15_nos14().intValue());
						}
						Cell  R15cell31 = row15.getCell(37); 
						if (R15cell31 != null) {
							R15cell31.setCellValue(brf68.getR15_amount14() == null ? 0 : brf68.getR15_amount14().intValue());
						}
						
			            Row row16 = sheet.getRow(25);
			            Cell R16cell1 = row16.getCell(4); 
						if (R16cell1 != null) {
							R16cell1.setCellValue(brf68.getR16_male() == null ? 0 : brf68.getR16_male().intValue());
						}
						Cell R16cell2 = row16.getCell(5); 
						if (R16cell2 != null) {
							R16cell2.setCellValue(brf68.getR16_female() == null ? 0 : brf68.getR16_female().intValue());
						}
						Cell R16cell3 = row16.getCell(6); 
						if (R16cell3 != null) {
							R16cell3.setCellValue(brf68.getR16_entities() == null ? 0 : brf68.getR16_entities().intValue());
						}
						Cell R16cell4 = row16.getCell(10); 
						if (R16cell4 != null) {
							R16cell4.setCellValue(brf68.getR16_nos1() == null ? 0 : brf68.getR16_nos1().intValue());
						}
						Cell R16cell5 = row16.getCell(11); 
						if (R16cell5 != null) {
							R16cell5.setCellValue(brf68.getR16_amount1() == null ? 0 : brf68.getR16_amount1().intValue());
						}
						Cell R16cell6 = row16.getCell(12); 
						if (R16cell6 != null) {
							R16cell6.setCellValue(brf68.getR16_nos2() == null ? 0 : brf68.getR16_nos2().intValue());
						}
						Cell R16cell7 = row16.getCell(13); 
						if (R16cell7 != null) {
							R16cell7.setCellValue(brf68.getR16_amount2() == null ? 0 : brf68.getR16_amount2().intValue());
						}
						Cell R16cell8 = row16.getCell(14); 
						if (R16cell8 != null) {
							R16cell8.setCellValue(brf68.getR16_nos3() == null ? 0 : brf68.getR16_nos3().intValue());
						}
						Cell R16cell9 = row16.getCell(15); 
						if (R16cell9 != null) {
							R16cell9.setCellValue(brf68.getR16_amount3() == null ? 0 : brf68.getR16_amount3().intValue());
						}
						Cell R16cell10 = row16.getCell(16); 
						if (R16cell10 != null) {
							R16cell10.setCellValue(brf68.getR16_nos4() == null ? 0 : brf68.getR16_nos4().intValue());
						}
						Cell R16cell11 = row16.getCell(17); 
						if (R16cell11 != null) {
							R16cell11.setCellValue(brf68.getR16_amount4() == null ? 0 : brf68.getR16_amount4().intValue());
						}
						Cell R16cell12 = row16.getCell(18); 
						if (R16cell12 != null) {
							R16cell12.setCellValue(brf68.getR16_nos5() == null ? 0 : brf68.getR16_nos5().intValue());
						}
						Cell R16cell13 = row16.getCell(19); 
						if (R16cell13 != null) {
							R16cell13.setCellValue(brf68.getR16_amount5() == null ? 0 : brf68.getR16_amount5().intValue());
						}
						Cell R16cell14 = row16.getCell(20); 
						if (R16cell14 != null) {
							R16cell14.setCellValue(brf68.getR16_nos6() == null ? 0 : brf68.getR16_nos6().intValue());
						}
						Cell R16cell15 = row16.getCell(21); 
						if (R16cell15 != null) {
							R16cell15.setCellValue(brf68.getR16_amount6() == null ? 0 : brf68.getR16_amount6().intValue());
						}
						Cell R16cell16 = row16.getCell(22); 
						if (R16cell16 != null) {
							R16cell16.setCellValue(brf68.getR16_nos7() == null ? 0 : brf68.getR16_nos7().intValue());
						}
						Cell  R16cell17 = row16.getCell(23); 
						if (R16cell17 != null) {
							R16cell17.setCellValue(brf68.getR16_amount7() == null ? 0 : brf68.getR16_amount7().intValue());
						}
						Cell  R16cell18 = row16.getCell(24); 
						if (R16cell18 != null) {
							R16cell18.setCellValue(brf68.getR16_nos8() == null ? 0 : brf68.getR16_nos8().intValue());
						}
						Cell  R16cell19 = row16.getCell(25); 
						if (R16cell19 != null) {
							R16cell19.setCellValue(brf68.getR16_amount8() == null ? 0 : brf68.getR16_amount8().intValue());
						}
						Cell  R16cell20 = row16.getCell(26); 
						if (R16cell20 != null) {
							R16cell20.setCellValue(brf68.getR16_nos9() == null ? 0 : brf68.getR16_nos9().intValue());
						}
						Cell  R16cell21 = row16.getCell(27); 
						if (R16cell21 != null) {
							R16cell21.setCellValue(brf68.getR16_amount9() == null ? 0 : brf68.getR16_amount9().intValue());
						}
						Cell R16cell22 = row16.getCell(28); 
						if (R16cell22 != null) {
							R16cell22.setCellValue(brf68.getR16_nos10() == null ? 0 : brf68.getR16_nos10().intValue());
						}
						Cell  R16cell23 = row16.getCell(29); 
						if (R16cell23 != null) {
							R16cell23.setCellValue(brf68.getR16_amount10() == null ? 0 : brf68.getR16_amount10().intValue());
						}
						Cell R16cell24 = row16.getCell(30); 
						if (R16cell24 != null) {
							R16cell24.setCellValue(brf68.getR16_nos11() == null ? 0 : brf68.getR16_nos11().intValue());
						}
						Cell  R16cell25 = row16.getCell(31); 
						if (R16cell25 != null) {
							R16cell25.setCellValue(brf68.getR16_amount11() == null ? 0 : brf68.getR16_amount11().intValue());
						}
						Cell  R16cell26 = row16.getCell(32); 
						if (R16cell26 != null) {
							R16cell26.setCellValue(brf68.getR16_nos12() == null ? 0 : brf68.getR16_nos12().intValue());
						}
						Cell  R16cell27 = row16.getCell(33); 
						if (R16cell27 != null) {
							R16cell27.setCellValue(brf68.getR16_amount12() == null ? 0 : brf68.getR16_amount12().intValue());
						}
						Cell  R16cell28 = row16.getCell(34); 
						if (R16cell28 != null) {
							R16cell28.setCellValue(brf68.getR16_nos13() == null ? 0 : brf68.getR16_nos13().intValue());
						}
						Cell  R16cell29 = row16.getCell(35); 
						if (R16cell29 != null) {
							R16cell29.setCellValue(brf68.getR16_amount13() == null ? 0 : brf68.getR16_amount13().intValue());
						}
						Cell  R16cell30 = row16.getCell(36); 
						if (R16cell30 != null) {
							R16cell30.setCellValue(brf68.getR16_nos14() == null ? 0 : brf68.getR16_nos14().intValue());
						}
						Cell  R16cell31 = row16.getCell(37); 
						if (R16cell31 != null) {
							R16cell31.setCellValue(brf68.getR16_amount14() == null ? 0 : brf68.getR16_amount14().intValue());
						}
						
			            Row row19 = sheet.getRow(28);
			            Cell R19cell1 = row19.getCell(4); 
						if (R19cell1 != null) {
							R19cell1.setCellValue(brf68.getR19_male() == null ? 0 : brf68.getR19_male().intValue());
						}
						Cell R19cell2 = row19.getCell(5); 
						if (R19cell2 != null) {
							R19cell2.setCellValue(brf68.getR19_female() == null ? 0 : brf68.getR19_female().intValue());
						}
						/*
						 * Cell R19cell3 = row19.getCell(6); if (R19cell3 != null) {
						 * R19cell3.setCellValue(brf68.getR19_entities() == null ? 0 :
						 * brf68.getR19_entities().intValue()); }
						 */
						Cell R19cell4 = row19.getCell(10); 
						if (R19cell4 != null) {
							R19cell4.setCellValue(brf68.getR19_nos1() == null ? 0 : brf68.getR19_nos1().intValue());
						}
						Cell R19cell5 = row19.getCell(11); 
						if (R19cell5 != null) {
							R19cell5.setCellValue(brf68.getR19_amount1() == null ? 0 : brf68.getR19_amount1().intValue());
						}
						Cell R19cell6 = row19.getCell(12); 
						if (R19cell6 != null) {
							R19cell6.setCellValue(brf68.getR19_nos2() == null ? 0 : brf68.getR19_nos2().intValue());
						}
						Cell R19cell7 = row19.getCell(13); 
						if (R19cell7 != null) {
							R19cell7.setCellValue(brf68.getR19_amount2() == null ? 0 : brf68.getR19_amount2().intValue());
						}
						Cell R19cell8 = row19.getCell(14); 
						if (R19cell8 != null) {
							R19cell8.setCellValue(brf68.getR19_nos3() == null ? 0 : brf68.getR19_nos3().intValue());
						}
						Cell R19cell9 = row19.getCell(15); 
						if (R19cell9 != null) {
							R19cell9.setCellValue(brf68.getR19_amount3() == null ? 0 : brf68.getR19_amount3().intValue());
						}
						Cell R19cell10 = row19.getCell(16); 
						if (R19cell10 != null) {
							R19cell10.setCellValue(brf68.getR19_nos4() == null ? 0 : brf68.getR19_nos4().intValue());
						}
						Cell R19cell11 = row19.getCell(17); 
						if (R19cell11 != null) {
							R19cell11.setCellValue(brf68.getR19_amount4() == null ? 0 : brf68.getR19_amount4().intValue());
						}
						Cell R19cell12 = row19.getCell(18); 
						if (R19cell12 != null) {
							R19cell12.setCellValue(brf68.getR19_nos5() == null ? 0 : brf68.getR19_nos5().intValue());
						}
						Cell R19cell13 = row19.getCell(19); 
						if (R19cell13 != null) {
							R19cell13.setCellValue(brf68.getR19_amount5() == null ? 0 : brf68.getR19_amount5().intValue());
						}
						Cell R19cell14 = row19.getCell(20); 
						if (R19cell14 != null) {
							R19cell14.setCellValue(brf68.getR19_nos6() == null ? 0 : brf68.getR19_nos6().intValue());
						}
						Cell R19cell15 = row19.getCell(21); 
						if (R19cell15 != null) {
							R19cell15.setCellValue(brf68.getR19_amount6() == null ? 0 : brf68.getR19_amount6().intValue());
						}
						Cell R19cell16 = row19.getCell(22); 
						if (R19cell16 != null) {
							R19cell16.setCellValue(brf68.getR19_nos7() == null ? 0 : brf68.getR19_nos7().intValue());
						}
						Cell  R19cell17 = row19.getCell(23); 
						if (R19cell17 != null) {
							R19cell17.setCellValue(brf68.getR19_amount7() == null ? 0 : brf68.getR19_amount7().intValue());
						}
						Cell  R19cell18 = row19.getCell(24); 
						if (R19cell18 != null) {
							R19cell18.setCellValue(brf68.getR19_nos8() == null ? 0 : brf68.getR19_nos8().intValue());
						}
						Cell  R19cell19 = row19.getCell(25); 
						if (R19cell19 != null) {
							R19cell19.setCellValue(brf68.getR19_amount8() == null ? 0 : brf68.getR19_amount8().intValue());
						}
						Cell  R19cell20 = row19.getCell(26); 
						if (R19cell20 != null) {
							R19cell20.setCellValue(brf68.getR19_nos9() == null ? 0 : brf68.getR19_nos9().intValue());
						}
						Cell  R19cell21 = row19.getCell(27); 
						if (R19cell21 != null) {
							R19cell21.setCellValue(brf68.getR19_amount9() == null ? 0 : brf68.getR19_amount9().intValue());
						}
						Cell R19cell22 = row19.getCell(28); 
						if (R19cell22 != null) {
							R19cell22.setCellValue(brf68.getR19_nos10() == null ? 0 : brf68.getR19_nos10().intValue());
						}
						Cell  R19cell23 = row19.getCell(29); 
						if (R19cell23 != null) {
							R19cell23.setCellValue(brf68.getR19_amount10() == null ? 0 : brf68.getR19_amount10().intValue());
						}
						Cell R19cell24 = row19.getCell(30); 
						if (R19cell24 != null) {
							R19cell24.setCellValue(brf68.getR19_nos11() == null ? 0 : brf68.getR19_nos11().intValue());
						}
						Cell  R19cell25 = row19.getCell(31); 
						if (R19cell25 != null) {
							R19cell25.setCellValue(brf68.getR19_amount11() == null ? 0 : brf68.getR19_amount11().intValue());
						}
						Cell  R19cell26 = row19.getCell(32); 
						if (R19cell26 != null) {
							R19cell26.setCellValue(brf68.getR19_nos12() == null ? 0 : brf68.getR19_nos12().intValue());
						}
						Cell  R19cell27 = row19.getCell(33); 
						if (R19cell27 != null) {
							R19cell27.setCellValue(brf68.getR19_amount12() == null ? 0 : brf68.getR19_amount12().intValue());
						}
						Cell  R19cell28 = row19.getCell(34); 
						if (R19cell28 != null) {
							R19cell28.setCellValue(brf68.getR19_nos13() == null ? 0 : brf68.getR19_nos13().intValue());
						}
						Cell  R19cell29 = row19.getCell(35); 
						if (R19cell29 != null) {
							R19cell29.setCellValue(brf68.getR19_amount13() == null ? 0 : brf68.getR19_amount13().intValue());
						}
						Cell  R19cell30 = row19.getCell(36); 
						if (R19cell30 != null) {
							R19cell30.setCellValue(brf68.getR19_nos14() == null ? 0 : brf68.getR19_nos14().intValue());
						}
						Cell  R19cell31 = row19.getCell(37); 
						if (R19cell31 != null) {
							R19cell31.setCellValue(brf68.getR19_amount14() == null ? 0 : brf68.getR19_amount14().intValue());
						}
						
			            Row row20 = sheet.getRow(29);
			            Cell R20cell1 = row20.getCell(4); 
						if (R20cell1 != null) {
							R20cell1.setCellValue(brf68.getR20_male() == null ? 0 : brf68.getR20_male().intValue());
						}
						Cell R20cell2 = row20.getCell(5); 
						if (R20cell2 != null) {
							R20cell2.setCellValue(brf68.getR20_female() == null ? 0 : brf68.getR20_female().intValue());
						}
						/*
						 * Cell R20cell3 = row20.getCell(6); if (R20cell3 != null) {
						 * R20cell3.setCellValue(brf68.getR20_entities() == null ? 0 :
						 * brf68.getR20_entities().intValue()); }
						 */
						Cell R20cell4 = row20.getCell(10); 
						if (R20cell4 != null) {
							R20cell4.setCellValue(brf68.getR20_nos1() == null ? 0 : brf68.getR20_nos1().intValue());
						}
						Cell R20cell5 = row20.getCell(11); 
						if (R20cell5 != null) {
							R20cell5.setCellValue(brf68.getR20_amount1() == null ? 0 : brf68.getR20_amount1().intValue());
						}
						Cell R20cell6 = row20.getCell(12); 
						if (R20cell6 != null) {
							R20cell6.setCellValue(brf68.getR20_nos2() == null ? 0 : brf68.getR20_nos2().intValue());
						}
						Cell R20cell7 = row20.getCell(13); 
						if (R20cell7 != null) {
							R20cell7.setCellValue(brf68.getR20_amount2() == null ? 0 : brf68.getR20_amount2().intValue());
						}
						Cell R20cell8 = row20.getCell(14); 
						if (R20cell8 != null) {
							R20cell8.setCellValue(brf68.getR20_nos3() == null ? 0 : brf68.getR20_nos3().intValue());
						}
						Cell R20cell9 = row20.getCell(15); 
						if (R20cell9 != null) {
							R20cell9.setCellValue(brf68.getR20_amount3() == null ? 0 : brf68.getR20_amount3().intValue());
						}
						Cell R20cell10 = row20.getCell(16); 
						if (R20cell10 != null) {
							R20cell10.setCellValue(brf68.getR20_nos4() == null ? 0 : brf68.getR20_nos4().intValue());
						}
						Cell R20cell11 = row20.getCell(17); 
						if (R20cell11 != null) {
							R20cell11.setCellValue(brf68.getR20_amount4() == null ? 0 : brf68.getR20_amount4().intValue());
						}
						Cell R20cell12 = row20.getCell(18); 
						if (R20cell12 != null) {
							R20cell12.setCellValue(brf68.getR20_nos5() == null ? 0 : brf68.getR20_nos5().intValue());
						}
						Cell R20cell13 = row20.getCell(19); 
						if (R20cell13 != null) {
							R20cell13.setCellValue(brf68.getR20_amount5() == null ? 0 : brf68.getR20_amount5().intValue());
						}
						Cell R20cell14 = row20.getCell(20); 
						if (R20cell14 != null) {
							R20cell14.setCellValue(brf68.getR20_nos6() == null ? 0 : brf68.getR20_nos6().intValue());
						}
						Cell R20cell15 = row20.getCell(21); 
						if (R20cell15 != null) {
							R20cell15.setCellValue(brf68.getR20_amount6() == null ? 0 : brf68.getR20_amount6().intValue());
						}
						Cell R20cell16 = row20.getCell(22); 
						if (R20cell16 != null) {
							R20cell16.setCellValue(brf68.getR20_nos7() == null ? 0 : brf68.getR20_nos7().intValue());
						}
						Cell  R20cell17 = row20.getCell(23); 
						if (R20cell17 != null) {
							R20cell17.setCellValue(brf68.getR20_amount7() == null ? 0 : brf68.getR20_amount7().intValue());
						}
						Cell  R20cell18 = row20.getCell(24); 
						if (R20cell18 != null) {
							R20cell18.setCellValue(brf68.getR20_nos8() == null ? 0 : brf68.getR20_nos8().intValue());
						}
						Cell  R20cell19 = row20.getCell(25); 
						if (R20cell19 != null) {
							R20cell19.setCellValue(brf68.getR20_amount8() == null ? 0 : brf68.getR20_amount8().intValue());
						}
						Cell  R20cell20 = row20.getCell(26); 
						if (R20cell20 != null) {
							R20cell20.setCellValue(brf68.getR20_nos9() == null ? 0 : brf68.getR20_nos9().intValue());
						}
						Cell  R20cell21 = row20.getCell(27); 
						if (R20cell21 != null) {
							R20cell21.setCellValue(brf68.getR20_amount9() == null ? 0 : brf68.getR20_amount9().intValue());
						}
						Cell R20cell22 = row20.getCell(28); 
						if (R20cell22 != null) {
							R20cell22.setCellValue(brf68.getR20_nos10() == null ? 0 : brf68.getR20_nos10().intValue());
						}
						Cell  R20cell23 = row20.getCell(29); 
						if (R20cell23 != null) {
							R20cell23.setCellValue(brf68.getR20_amount10() == null ? 0 : brf68.getR20_amount10().intValue());
						}
						Cell R20cell24 = row20.getCell(30); 
						if (R20cell24 != null) {
							R20cell24.setCellValue(brf68.getR20_nos11() == null ? 0 : brf68.getR20_nos11().intValue());
						}
						Cell  R20cell25 = row20.getCell(31); 
						if (R20cell25 != null) {
							R20cell25.setCellValue(brf68.getR20_amount11() == null ? 0 : brf68.getR20_amount11().intValue());
						}
						Cell  R20cell26 = row20.getCell(32); 
						if (R20cell26 != null) {
							R20cell26.setCellValue(brf68.getR20_nos12() == null ? 0 : brf68.getR20_nos12().intValue());
						}
						Cell  R20cell27 = row20.getCell(33); 
						if (R20cell27 != null) {
							R20cell27.setCellValue(brf68.getR20_amount12() == null ? 0 : brf68.getR20_amount12().intValue());
						}
						Cell  R20cell28 = row20.getCell(34); 
						if (R20cell28 != null) {
							R20cell28.setCellValue(brf68.getR20_nos13() == null ? 0 : brf68.getR20_nos13().intValue());
						}
						Cell  R20cell29 = row20.getCell(35); 
						if (R20cell29 != null) {
							R20cell29.setCellValue(brf68.getR20_amount13() == null ? 0 : brf68.getR20_amount13().intValue());
						}
						Cell  R20cell30 = row20.getCell(36); 
						if (R20cell30 != null) {
							R20cell30.setCellValue(brf68.getR20_nos14() == null ? 0 : brf68.getR20_nos14().intValue());
						}
						Cell  R20cell31 = row20.getCell(37); 
						if (R20cell31 != null) {
							R20cell31.setCellValue(brf68.getR20_amount14() == null ? 0 : brf68.getR20_amount14().intValue());
						}
						
					}
				}
				if (T1Master1.size() == 1) {
					for (BRF68_Entity2 brf68a : T1Master1) {
						// Access rows from 21 to 34
			            Row row21 = sheet.getRow(30);
			            Cell R21cell1 = row21.getCell(4); 
						if (R21cell1 != null) {
							R21cell1.setCellValue(brf68a.getR21_male() == null ? 0 : brf68a.getR21_male().intValue());
						}
						Cell R21cell2 = row21.getCell(5); 
						if (R21cell2 != null) {
							R21cell2.setCellValue(brf68a.getR21_female() == null ? 0 : brf68a.getR21_female().intValue());
						}
						/*
						 * Cell R21cell3 = row21.getCell(6); if (R21cell3 != null) {
						 * R21cell3.setCellValue(brf68a.getR21_entities() == null ? 0 :
						 * brf68a.getR21_entities().intValue()); }
						 */
						Cell R21cell4 = row21.getCell(10); 
						if (R21cell4 != null) {
							R21cell4.setCellValue(brf68a.getR21_nos1() == null ? 0 : brf68a.getR21_nos1().intValue());
						}
						Cell R21cell5 = row21.getCell(11); 
						if (R21cell5 != null) {
							R21cell5.setCellValue(brf68a.getR21_amount1() == null ? 0 : brf68a.getR21_amount1().intValue());
						}
						Cell R21cell6 = row21.getCell(12); 
						if (R21cell6 != null) {
							R21cell6.setCellValue(brf68a.getR21_nos2() == null ? 0 : brf68a.getR21_nos2().intValue());
						}
						Cell R21cell7 = row21.getCell(13); 
						if (R21cell7 != null) {
							R21cell7.setCellValue(brf68a.getR21_amount2() == null ? 0 : brf68a.getR21_amount2().intValue());
						}
						Cell R21cell8 = row21.getCell(14); 
						if (R21cell8 != null) {
							R21cell8.setCellValue(brf68a.getR21_nos3() == null ? 0 : brf68a.getR21_nos3().intValue());
						}
						Cell R21cell9 = row21.getCell(15); 
						if (R21cell9 != null) {
							R21cell9.setCellValue(brf68a.getR21_amount3() == null ? 0 : brf68a.getR21_amount3().intValue());
						}
						Cell R21cell10 = row21.getCell(16); 
						if (R21cell10 != null) {
							R21cell10.setCellValue(brf68a.getR21_nos4() == null ? 0 : brf68a.getR21_nos4().intValue());
						}
						Cell R21cell11 = row21.getCell(17); 
						if (R21cell11 != null) {
							R21cell11.setCellValue(brf68a.getR21_amount4() == null ? 0 : brf68a.getR21_amount4().intValue());
						}
						Cell R21cell12 = row21.getCell(18); 
						if (R21cell12 != null) {
							R21cell12.setCellValue(brf68a.getR21_nos5() == null ? 0 : brf68a.getR21_nos5().intValue());
						}
						Cell R21cell13 = row21.getCell(19); 
						if (R21cell13 != null) {
							R21cell13.setCellValue(brf68a.getR21_amount5() == null ? 0 : brf68a.getR21_amount5().intValue());
						}
						Cell R21cell14 = row21.getCell(20); 
						if (R21cell14 != null) {
							R21cell14.setCellValue(brf68a.getR21_nos6() == null ? 0 : brf68a.getR21_nos6().intValue());
						}
						Cell R21cell15 = row21.getCell(21); 
						if (R21cell15 != null) {
							R21cell15.setCellValue(brf68a.getR21_amount6() == null ? 0 : brf68a.getR21_amount6().intValue());
						}
						Cell R21cell16 = row21.getCell(22); 
						if (R21cell16 != null) {
							R21cell16.setCellValue(brf68a.getR21_nos7() == null ? 0 : brf68a.getR21_nos7().intValue());
						}
						Cell  R21cell17 = row21.getCell(23); 
						if (R21cell17 != null) {
							R21cell17.setCellValue(brf68a.getR21_amount7() == null ? 0 : brf68a.getR21_amount7().intValue());
						}
						Cell  R21cell18 = row21.getCell(24); 
						if (R21cell18 != null) {
							R21cell18.setCellValue(brf68a.getR21_nos8() == null ? 0 : brf68a.getR21_nos8().intValue());
						}
						Cell  R21cell19 = row21.getCell(25); 
						if (R21cell19 != null) {
							R21cell19.setCellValue(brf68a.getR21_amount8() == null ? 0 : brf68a.getR21_amount8().intValue());
						}
						Cell  R21cell20 = row21.getCell(26); 
						if (R21cell20 != null) {
							R21cell20.setCellValue(brf68a.getR21_nos9() == null ? 0 : brf68a.getR21_nos9().intValue());
						}
						Cell  R21cell21 = row21.getCell(27); 
						if (R21cell21 != null) {
							R21cell21.setCellValue(brf68a.getR21_amount9() == null ? 0 : brf68a.getR21_amount9().intValue());
						}
						Cell R21cell22 = row21.getCell(28); 
						if (R21cell22 != null) {
							R21cell22.setCellValue(brf68a.getR21_nos10() == null ? 0 : brf68a.getR21_nos10().intValue());
						}
						Cell  R21cell23 = row21.getCell(29); 
						if (R21cell23 != null) {
							R21cell23.setCellValue(brf68a.getR21_amount10() == null ? 0 : brf68a.getR21_amount10().intValue());
						}
						Cell R21cell24 = row21.getCell(30); 
						if (R21cell24 != null) {
							R21cell24.setCellValue(brf68a.getR21_nos11() == null ? 0 : brf68a.getR21_nos11().intValue());
						}
						Cell  R21cell25 = row21.getCell(31); 
						if (R21cell25 != null) {
							R21cell25.setCellValue(brf68a.getR21_amount11() == null ? 0 : brf68a.getR21_amount11().intValue());
						}
						Cell  R21cell26 = row21.getCell(32); 
						if (R21cell26 != null) {
							R21cell26.setCellValue(brf68a.getR21_nos12() == null ? 0 : brf68a.getR21_nos12().intValue());
						}
						Cell  R21cell27 = row21.getCell(33); 
						if (R21cell27 != null) {
							R21cell27.setCellValue(brf68a.getR21_amount12() == null ? 0 : brf68a.getR21_amount12().intValue());
						}
						Cell  R21cell28 = row21.getCell(34); 
						if (R21cell28 != null) {
							R21cell28.setCellValue(brf68a.getR21_nos13() == null ? 0 : brf68a.getR21_nos13().intValue());
						}
						Cell  R21cell29 = row21.getCell(35); 
						if (R21cell29 != null) {
							R21cell29.setCellValue(brf68a.getR21_amount13() == null ? 0 : brf68a.getR21_amount13().intValue());
						}
						Cell  R21cell30 = row21.getCell(36); 
						if (R21cell30 != null) {
							R21cell30.setCellValue(brf68a.getR21_nos14() == null ? 0 : brf68a.getR21_nos14().intValue());
						}
						Cell  R21cell31 = row21.getCell(37); 
						if (R21cell31 != null) {
							R21cell31.setCellValue(brf68a.getR21_amount14() == null ? 0 : brf68a.getR21_amount14().intValue());
						}
						
			            Row row22 = sheet.getRow(31);
			            Cell R22cell1 = row22.getCell(4); 
						if (R22cell1 != null) {
							R22cell1.setCellValue(brf68a.getR22_male() == null ? 0 : brf68a.getR22_male().intValue());
						}
						Cell R22cell2 = row22.getCell(5); 
						if (R22cell2 != null) {
							R22cell2.setCellValue(brf68a.getR22_female() == null ? 0 : brf68a.getR22_female().intValue());
						}
						/*
						 * Cell R22cell3 = row22.getCell(6); if (R22cell3 != null) {
						 * R22cell3.setCellValue(brf68a.getR22_entities() == null ? 0 :
						 * brf68a.getR22_entities().intValue()); }
						 */
						Cell R22cell4 = row22.getCell(10); 
						if (R22cell4 != null) {
							R22cell4.setCellValue(brf68a.getR22_nos1() == null ? 0 : brf68a.getR22_nos1().intValue());
						}
						Cell R22cell5 = row22.getCell(11); 
						if (R22cell5 != null) {
							R22cell5.setCellValue(brf68a.getR22_amount1() == null ? 0 : brf68a.getR22_amount1().intValue());
						}
						Cell R22cell6 = row22.getCell(12); 
						if (R22cell6 != null) {
							R22cell6.setCellValue(brf68a.getR22_nos2() == null ? 0 : brf68a.getR22_nos2().intValue());
						}
						Cell R22cell7 = row22.getCell(13); 
						if (R22cell7 != null) {
							R22cell7.setCellValue(brf68a.getR22_amount2() == null ? 0 : brf68a.getR22_amount2().intValue());
						}
						Cell R22cell8 = row22.getCell(14); 
						if (R22cell8 != null) {
							R22cell8.setCellValue(brf68a.getR22_nos3() == null ? 0 : brf68a.getR22_nos3().intValue());
						}
						Cell R22cell9 = row22.getCell(15); 
						if (R22cell9 != null) {
							R22cell9.setCellValue(brf68a.getR22_amount3() == null ? 0 : brf68a.getR22_amount3().intValue());
						}
						Cell R22cell10 = row22.getCell(16); 
						if (R22cell10 != null) {
							R22cell10.setCellValue(brf68a.getR22_nos4() == null ? 0 : brf68a.getR22_nos4().intValue());
						}
						Cell R22cell11 = row22.getCell(17); 
						if (R22cell11 != null) {
							R22cell11.setCellValue(brf68a.getR22_amount4() == null ? 0 : brf68a.getR22_amount4().intValue());
						}
						Cell R22cell12 = row22.getCell(18); 
						if (R22cell12 != null) {
							R22cell12.setCellValue(brf68a.getR22_nos5() == null ? 0 : brf68a.getR22_nos5().intValue());
						}
						Cell R22cell13 = row22.getCell(19); 
						if (R22cell13 != null) {
							R22cell13.setCellValue(brf68a.getR22_amount5() == null ? 0 : brf68a.getR22_amount5().intValue());
						}
						Cell R22cell14 = row22.getCell(20); 
						if (R22cell14 != null) {
							R22cell14.setCellValue(brf68a.getR22_nos6() == null ? 0 : brf68a.getR22_nos6().intValue());
						}
						Cell R22cell15 = row22.getCell(21); 
						if (R22cell15 != null) {
							R22cell15.setCellValue(brf68a.getR22_amount6() == null ? 0 : brf68a.getR22_amount6().intValue());
						}
						Cell R22cell16 = row22.getCell(22); 
						if (R22cell16 != null) {
							R22cell16.setCellValue(brf68a.getR22_nos7() == null ? 0 : brf68a.getR22_nos7().intValue());
						}
						Cell  R22cell17 = row22.getCell(23); 
						if (R22cell17 != null) {
							R22cell17.setCellValue(brf68a.getR22_amount7() == null ? 0 : brf68a.getR22_amount7().intValue());
						}
						Cell  R22cell18 = row22.getCell(24); 
						if (R22cell18 != null) {
							R22cell18.setCellValue(brf68a.getR22_nos8() == null ? 0 : brf68a.getR22_nos8().intValue());
						}
						Cell  R22cell19 = row22.getCell(25); 
						if (R22cell19 != null) {
							R22cell19.setCellValue(brf68a.getR22_amount8() == null ? 0 : brf68a.getR22_amount8().intValue());
						}
						Cell  R22cell20 = row22.getCell(26); 
						if (R22cell20 != null) {
							R22cell20.setCellValue(brf68a.getR22_nos9() == null ? 0 : brf68a.getR22_nos9().intValue());
						}
						Cell  R22cell21 = row22.getCell(27); 
						if (R22cell21 != null) {
							R22cell21.setCellValue(brf68a.getR22_amount9() == null ? 0 : brf68a.getR22_amount9().intValue());
						}
						Cell R22cell22 = row22.getCell(28); 
						if (R22cell22 != null) {
							R22cell22.setCellValue(brf68a.getR22_nos10() == null ? 0 : brf68a.getR22_nos10().intValue());
						}
						Cell  R22cell23 = row22.getCell(29); 
						if (R22cell23 != null) {
							R22cell23.setCellValue(brf68a.getR22_amount10() == null ? 0 : brf68a.getR22_amount10().intValue());
						}
						Cell R22cell24 = row22.getCell(30); 
						if (R22cell24 != null) {
							R22cell24.setCellValue(brf68a.getR22_nos11() == null ? 0 : brf68a.getR22_nos11().intValue());
						}
						Cell  R22cell25 = row22.getCell(31); 
						if (R22cell25 != null) {
							R22cell25.setCellValue(brf68a.getR22_amount11() == null ? 0 : brf68a.getR22_amount11().intValue());
						}
						Cell  R22cell26 = row22.getCell(32); 
						if (R22cell26 != null) {
							R22cell26.setCellValue(brf68a.getR22_nos12() == null ? 0 : brf68a.getR22_nos12().intValue());
						}
						Cell  R22cell27 = row22.getCell(33); 
						if (R22cell27 != null) {
							R22cell27.setCellValue(brf68a.getR22_amount12() == null ? 0 : brf68a.getR22_amount12().intValue());
						}
						Cell  R22cell28 = row22.getCell(34); 
						if (R22cell28 != null) {
							R22cell28.setCellValue(brf68a.getR22_nos13() == null ? 0 : brf68a.getR22_nos13().intValue());
						}
						Cell  R22cell29 = row22.getCell(35); 
						if (R22cell29 != null) {
							R22cell29.setCellValue(brf68a.getR22_amount13() == null ? 0 : brf68a.getR22_amount13().intValue());
						}
						Cell  R22cell30 = row22.getCell(36); 
						if (R22cell30 != null) {
							R22cell30.setCellValue(brf68a.getR22_nos14() == null ? 0 : brf68a.getR22_nos14().intValue());
						}
						Cell  R22cell31 = row22.getCell(37); 
						if (R22cell31 != null) {
							R22cell31.setCellValue(brf68a.getR22_amount14() == null ? 0 : brf68a.getR22_amount14().intValue());
						}
						
			            Row row23 = sheet.getRow(32);
			            Cell R23cell1 = row23.getCell(4); 
						if (R23cell1 != null) {
							R23cell1.setCellValue(brf68a.getR23_male() == null ? 0 : brf68a.getR23_male().intValue());
						}
						Cell R23cell2 = row23.getCell(5); 
						if (R23cell2 != null) {
							R23cell2.setCellValue(brf68a.getR23_female() == null ? 0 : brf68a.getR23_female().intValue());
						}
						/*
						 * Cell R23cell3 = row23.getCell(6); if (R23cell3 != null) {
						 * R23cell3.setCellValue(brf68a.getR23_entities() == null ? 0 :
						 * brf68a.getR23_entities().intValue()); }
						 */
						Cell R23cell4 = row23.getCell(10); 
						if (R23cell4 != null) {
							R23cell4.setCellValue(brf68a.getR23_nos1() == null ? 0 : brf68a.getR23_nos1().intValue());
						}
						Cell R23cell5 = row23.getCell(11); 
						if (R23cell5 != null) {
							R23cell5.setCellValue(brf68a.getR23_amount1() == null ? 0 : brf68a.getR23_amount1().intValue());
						}
						Cell R23cell6 = row23.getCell(12); 
						if (R23cell6 != null) {
							R23cell6.setCellValue(brf68a.getR23_nos2() == null ? 0 : brf68a.getR23_nos2().intValue());
						}
						Cell R23cell7 = row23.getCell(13); 
						if (R23cell7 != null) {
							R23cell7.setCellValue(brf68a.getR23_amount2() == null ? 0 : brf68a.getR23_amount2().intValue());
						}
						Cell R23cell8 = row23.getCell(14); 
						if (R23cell8 != null) {
							R23cell8.setCellValue(brf68a.getR23_nos3() == null ? 0 : brf68a.getR23_nos3().intValue());
						}
						Cell R23cell9 = row23.getCell(15); 
						if (R23cell9 != null) {
							R23cell9.setCellValue(brf68a.getR23_amount3() == null ? 0 : brf68a.getR23_amount3().intValue());
						}
						Cell R23cell10 = row23.getCell(16); 
						if (R23cell10 != null) {
							R23cell10.setCellValue(brf68a.getR23_nos4() == null ? 0 : brf68a.getR23_nos4().intValue());
						}
						Cell R23cell11 = row23.getCell(17); 
						if (R23cell11 != null) {
							R23cell11.setCellValue(brf68a.getR23_amount4() == null ? 0 : brf68a.getR23_amount4().intValue());
						}
						Cell R23cell12 = row23.getCell(18); 
						if (R23cell12 != null) {
							R23cell12.setCellValue(brf68a.getR23_nos5() == null ? 0 : brf68a.getR23_nos5().intValue());
						}
						Cell R23cell13 = row23.getCell(19); 
						if (R23cell13 != null) {
							R23cell13.setCellValue(brf68a.getR23_amount5() == null ? 0 : brf68a.getR23_amount5().intValue());
						}
						Cell R23cell14 = row23.getCell(20); 
						if (R23cell14 != null) {
							R23cell14.setCellValue(brf68a.getR23_nos6() == null ? 0 : brf68a.getR23_nos6().intValue());
						}
						Cell R23cell15 = row23.getCell(21); 
						if (R23cell15 != null) {
							R23cell15.setCellValue(brf68a.getR23_amount6() == null ? 0 : brf68a.getR23_amount6().intValue());
						}
						Cell R23cell16 = row23.getCell(22); 
						if (R23cell16 != null) {
							R23cell16.setCellValue(brf68a.getR23_nos7() == null ? 0 : brf68a.getR23_nos7().intValue());
						}
						Cell  R23cell17 = row23.getCell(23); 
						if (R23cell17 != null) {
							R23cell17.setCellValue(brf68a.getR23_amount7() == null ? 0 : brf68a.getR23_amount7().intValue());
						}
						Cell  R23cell18 = row23.getCell(24); 
						if (R23cell18 != null) {
							R23cell18.setCellValue(brf68a.getR23_nos8() == null ? 0 : brf68a.getR23_nos8().intValue());
						}
						Cell  R23cell19 = row23.getCell(25); 
						if (R23cell19 != null) {
							R23cell19.setCellValue(brf68a.getR23_amount8() == null ? 0 : brf68a.getR23_amount8().intValue());
						}
						Cell  R23cell20 = row23.getCell(26); 
						if (R23cell20 != null) {
							R23cell20.setCellValue(brf68a.getR23_nos9() == null ? 0 : brf68a.getR23_nos9().intValue());
						}
						Cell  R23cell21 = row23.getCell(27); 
						if (R23cell21 != null) {
							R23cell21.setCellValue(brf68a.getR23_amount9() == null ? 0 : brf68a.getR23_amount9().intValue());
						}
						Cell R23cell22 = row23.getCell(28); 
						if (R23cell22 != null) {
							R23cell22.setCellValue(brf68a.getR23_nos10() == null ? 0 : brf68a.getR23_nos10().intValue());
						}
						Cell  R23cell23 = row23.getCell(29); 
						if (R23cell23 != null) {
							R23cell23.setCellValue(brf68a.getR23_amount10() == null ? 0 : brf68a.getR23_amount10().intValue());
						}
						Cell R23cell24 = row23.getCell(30); 
						if (R23cell24 != null) {
							R23cell24.setCellValue(brf68a.getR23_nos11() == null ? 0 : brf68a.getR23_nos11().intValue());
						}
						Cell  R23cell25 = row23.getCell(31); 
						if (R23cell25 != null) {
							R23cell25.setCellValue(brf68a.getR23_amount11() == null ? 0 : brf68a.getR23_amount11().intValue());
						}
						Cell  R23cell26 = row23.getCell(32); 
						if (R23cell26 != null) {
							R23cell26.setCellValue(brf68a.getR23_nos12() == null ? 0 : brf68a.getR23_nos12().intValue());
						}
						Cell  R23cell27 = row23.getCell(33); 
						if (R23cell27 != null) {
							R23cell27.setCellValue(brf68a.getR23_amount12() == null ? 0 : brf68a.getR23_amount12().intValue());
						}
						Cell  R23cell28 = row23.getCell(34); 
						if (R23cell28 != null) {
							R23cell28.setCellValue(brf68a.getR23_nos13() == null ? 0 : brf68a.getR23_nos13().intValue());
						}
						Cell  R23cell29 = row23.getCell(35); 
						if (R23cell29 != null) {
							R23cell29.setCellValue(brf68a.getR23_amount13() == null ? 0 : brf68a.getR23_amount13().intValue());
						}
						Cell  R23cell30 = row23.getCell(36); 
						if (R23cell30 != null) {
							R23cell30.setCellValue(brf68a.getR23_nos14() == null ? 0 : brf68a.getR23_nos14().intValue());
						}
						Cell  R23cell31 = row23.getCell(37); 
						if (R23cell31 != null) {
							R23cell31.setCellValue(brf68a.getR23_amount14() == null ? 0 : brf68a.getR23_amount14().intValue());
						}
						
			            Row row25 = sheet.getRow(34);
			            Cell R25cell1 = row25.getCell(4); 
						if (R25cell1 != null) {
							R25cell1.setCellValue(brf68a.getR25_male() == null ? 0 : brf68a.getR25_male().intValue());
						}
						Cell R25cell2 = row25.getCell(5); 
						if (R25cell2 != null) {
							R25cell2.setCellValue(brf68a.getR25_female() == null ? 0 : brf68a.getR25_female().intValue());
						}
						/*
						 * Cell R25cell3 = row25.getCell(6); if (R25cell3 != null) {
						 * R25cell3.setCellValue(brf68a.getR25_entities() == null ? 0 :
						 * brf68a.getR25_entities().intValue()); }
						 */
						Cell R25cell4 = row25.getCell(10); 
						if (R25cell4 != null) {
							R25cell4.setCellValue(brf68a.getR25_nos1() == null ? 0 : brf68a.getR25_nos1().intValue());
						}
						Cell R25cell5 = row25.getCell(11); 
						if (R25cell5 != null) {
							R25cell5.setCellValue(brf68a.getR25_amount1() == null ? 0 : brf68a.getR25_amount1().intValue());
						}
						Cell R25cell6 = row25.getCell(12); 
						if (R25cell6 != null) {
							R25cell6.setCellValue(brf68a.getR25_nos2() == null ? 0 : brf68a.getR25_nos2().intValue());
						}
						Cell R25cell7 = row25.getCell(13); 
						if (R25cell7 != null) {
							R25cell7.setCellValue(brf68a.getR25_amount2() == null ? 0 : brf68a.getR25_amount2().intValue());
						}
						Cell R25cell8 = row25.getCell(14); 
						if (R25cell8 != null) {
							R25cell8.setCellValue(brf68a.getR25_nos3() == null ? 0 : brf68a.getR25_nos3().intValue());
						}
						Cell R25cell9 = row25.getCell(15); 
						if (R25cell9 != null) {
							R25cell9.setCellValue(brf68a.getR25_amount3() == null ? 0 : brf68a.getR25_amount3().intValue());
						}
						Cell R25cell10 = row25.getCell(16); 
						if (R25cell10 != null) {
							R25cell10.setCellValue(brf68a.getR25_nos4() == null ? 0 : brf68a.getR25_nos4().intValue());
						}
						Cell R25cell11 = row25.getCell(17); 
						if (R25cell11 != null) {
							R25cell11.setCellValue(brf68a.getR25_amount4() == null ? 0 : brf68a.getR25_amount4().intValue());
						}
						Cell R25cell12 = row25.getCell(18); 
						if (R25cell12 != null) {
							R25cell12.setCellValue(brf68a.getR25_nos5() == null ? 0 : brf68a.getR25_nos5().intValue());
						}
						Cell R25cell13 = row25.getCell(19); 
						if (R25cell13 != null) {
							R25cell13.setCellValue(brf68a.getR25_amount5() == null ? 0 : brf68a.getR25_amount5().intValue());
						}
						Cell R25cell14 = row25.getCell(20); 
						if (R25cell14 != null) {
							R25cell14.setCellValue(brf68a.getR25_nos6() == null ? 0 : brf68a.getR25_nos6().intValue());
						}
						Cell R25cell15 = row25.getCell(21); 
						if (R25cell15 != null) {
							R25cell15.setCellValue(brf68a.getR25_amount6() == null ? 0 : brf68a.getR25_amount6().intValue());
						}
						Cell R25cell16 = row25.getCell(22); 
						if (R25cell16 != null) {
							R25cell16.setCellValue(brf68a.getR25_nos7() == null ? 0 : brf68a.getR25_nos7().intValue());
						}
						Cell  R25cell17 = row25.getCell(23); 
						if (R25cell17 != null) {
							R25cell17.setCellValue(brf68a.getR25_amount7() == null ? 0 : brf68a.getR25_amount7().intValue());
						}
						Cell  R25cell18 = row25.getCell(24); 
						if (R25cell18 != null) {
							R25cell18.setCellValue(brf68a.getR25_nos8() == null ? 0 : brf68a.getR25_nos8().intValue());
						}
						Cell  R25cell19 = row25.getCell(25); 
						if (R25cell19 != null) {
							R25cell19.setCellValue(brf68a.getR25_amount8() == null ? 0 : brf68a.getR25_amount8().intValue());
						}
						Cell  R25cell20 = row25.getCell(26); 
						if (R25cell20 != null) {
							R25cell20.setCellValue(brf68a.getR25_nos9() == null ? 0 : brf68a.getR25_nos9().intValue());
						}
						Cell  R25cell21 = row25.getCell(27); 
						if (R25cell21 != null) {
							R25cell21.setCellValue(brf68a.getR25_amount9() == null ? 0 : brf68a.getR25_amount9().intValue());
						}
						Cell R25cell22 = row25.getCell(28); 
						if (R25cell22 != null) {
							R25cell22.setCellValue(brf68a.getR25_nos10() == null ? 0 : brf68a.getR25_nos10().intValue());
						}
						Cell  R25cell23 = row25.getCell(29); 
						if (R25cell23 != null) {
							R25cell23.setCellValue(brf68a.getR25_amount10() == null ? 0 : brf68a.getR25_amount10().intValue());
						}
						Cell R25cell24 = row25.getCell(30); 
						if (R25cell24 != null) {
							R25cell24.setCellValue(brf68a.getR25_nos11() == null ? 0 : brf68a.getR25_nos11().intValue());
						}
						Cell  R25cell25 = row25.getCell(31); 
						if (R25cell25 != null) {
							R25cell25.setCellValue(brf68a.getR25_amount11() == null ? 0 : brf68a.getR25_amount11().intValue());
						}
						Cell  R25cell26 = row25.getCell(32); 
						if (R25cell26 != null) {
							R25cell26.setCellValue(brf68a.getR25_nos12() == null ? 0 : brf68a.getR25_nos12().intValue());
						}
						Cell  R25cell27 = row25.getCell(33); 
						if (R25cell27 != null) {
							R25cell27.setCellValue(brf68a.getR25_amount12() == null ? 0 : brf68a.getR25_amount12().intValue());
						}
						Cell  R25cell28 = row25.getCell(34); 
						if (R25cell28 != null) {
							R25cell28.setCellValue(brf68a.getR25_nos13() == null ? 0 : brf68a.getR25_nos13().intValue());
						}
						Cell  R25cell29 = row25.getCell(35); 
						if (R25cell29 != null) {
							R25cell29.setCellValue(brf68a.getR25_amount13() == null ? 0 : brf68a.getR25_amount13().intValue());
						}
						Cell  R25cell30 = row25.getCell(36); 
						if (R25cell30 != null) {
							R25cell30.setCellValue(brf68a.getR25_nos14() == null ? 0 : brf68a.getR25_nos14().intValue());
						}
						Cell  R25cell31 = row25.getCell(37); 
						if (R25cell31 != null) {
							R25cell31.setCellValue(brf68a.getR25_amount14() == null ? 0 : brf68a.getR25_amount14().intValue());
						}
						
			            Row row26 = sheet.getRow(35);
			            Cell R26cell1 = row26.getCell(4); 
						if (R26cell1 != null) {
							R26cell1.setCellValue(brf68a.getR26_male() == null ? 0 : brf68a.getR26_male().intValue());
						}
						Cell R26cell2 = row26.getCell(5); 
						if (R26cell2 != null) {
							R26cell2.setCellValue(brf68a.getR26_female() == null ? 0 : brf68a.getR26_female().intValue());
						}
						/*
						 * Cell R26cell3 = row26.getCell(6); if (R26cell3 != null) {
						 * R26cell3.setCellValue(brf68a.getR26_entities() == null ? 0 :
						 * brf68a.getR26_entities().intValue()); }
						 */
						Cell R26cell4 = row26.getCell(10); 
						if (R26cell4 != null) {
							R26cell4.setCellValue(brf68a.getR26_nos1() == null ? 0 : brf68a.getR26_nos1().intValue());
						}
						Cell R26cell5 = row26.getCell(11); 
						if (R26cell5 != null) {
							R26cell5.setCellValue(brf68a.getR26_amount1() == null ? 0 : brf68a.getR26_amount1().intValue());
						}
						Cell R26cell6 = row26.getCell(12); 
						if (R26cell6 != null) {
							R26cell6.setCellValue(brf68a.getR26_nos2() == null ? 0 : brf68a.getR26_nos2().intValue());
						}
						Cell R26cell7 = row26.getCell(13); 
						if (R26cell7 != null) {
							R26cell7.setCellValue(brf68a.getR26_amount2() == null ? 0 : brf68a.getR26_amount2().intValue());
						}
						Cell R26cell8 = row26.getCell(14); 
						if (R26cell8 != null) {
							R26cell8.setCellValue(brf68a.getR26_nos3() == null ? 0 : brf68a.getR26_nos3().intValue());
						}
						Cell R26cell9 = row26.getCell(15); 
						if (R26cell9 != null) {
							R26cell9.setCellValue(brf68a.getR26_amount3() == null ? 0 : brf68a.getR26_amount3().intValue());
						}
						Cell R26cell10 = row26.getCell(16); 
						if (R26cell10 != null) {
							R26cell10.setCellValue(brf68a.getR26_nos4() == null ? 0 : brf68a.getR26_nos4().intValue());
						}
						Cell R26cell11 = row26.getCell(17); 
						if (R26cell11 != null) {
							R26cell11.setCellValue(brf68a.getR26_amount4() == null ? 0 : brf68a.getR26_amount4().intValue());
						}
						Cell R26cell12 = row26.getCell(18); 
						if (R26cell12 != null) {
							R26cell12.setCellValue(brf68a.getR26_nos5() == null ? 0 : brf68a.getR26_nos5().intValue());
						}
						Cell R26cell13 = row26.getCell(19); 
						if (R26cell13 != null) {
							R26cell13.setCellValue(brf68a.getR26_amount5() == null ? 0 : brf68a.getR26_amount5().intValue());
						}
						Cell R26cell14 = row26.getCell(20); 
						if (R26cell14 != null) {
							R26cell14.setCellValue(brf68a.getR26_nos6() == null ? 0 : brf68a.getR26_nos6().intValue());
						}
						Cell R26cell15 = row26.getCell(21); 
						if (R26cell15 != null) {
							R26cell15.setCellValue(brf68a.getR26_amount6() == null ? 0 : brf68a.getR26_amount6().intValue());
						}
						Cell R26cell16 = row26.getCell(22); 
						if (R26cell16 != null) {
							R26cell16.setCellValue(brf68a.getR26_nos7() == null ? 0 : brf68a.getR26_nos7().intValue());
						}
						Cell  R26cell17 = row26.getCell(23); 
						if (R26cell17 != null) {
							R26cell17.setCellValue(brf68a.getR26_amount7() == null ? 0 : brf68a.getR26_amount7().intValue());
						}
						Cell  R26cell18 = row26.getCell(24); 
						if (R26cell18 != null) {
							R26cell18.setCellValue(brf68a.getR26_nos8() == null ? 0 : brf68a.getR26_nos8().intValue());
						}
						Cell  R26cell19 = row26.getCell(25); 
						if (R26cell19 != null) {
							R26cell19.setCellValue(brf68a.getR26_amount8() == null ? 0 : brf68a.getR26_amount8().intValue());
						}
						Cell  R26cell20 = row26.getCell(26); 
						if (R26cell20 != null) {
							R26cell20.setCellValue(brf68a.getR26_nos9() == null ? 0 : brf68a.getR26_nos9().intValue());
						}
						Cell  R26cell21 = row26.getCell(27); 
						if (R26cell21 != null) {
							R26cell21.setCellValue(brf68a.getR26_amount9() == null ? 0 : brf68a.getR26_amount9().intValue());
						}
						Cell R26cell22 = row26.getCell(28); 
						if (R26cell22 != null) {
							R26cell22.setCellValue(brf68a.getR26_nos10() == null ? 0 : brf68a.getR26_nos10().intValue());
						}
						Cell  R26cell23 = row26.getCell(29); 
						if (R26cell23 != null) {
							R26cell23.setCellValue(brf68a.getR26_amount10() == null ? 0 : brf68a.getR26_amount10().intValue());
						}
						Cell R26cell24 = row26.getCell(30); 
						if (R26cell24 != null) {
							R26cell24.setCellValue(brf68a.getR26_nos11() == null ? 0 : brf68a.getR26_nos11().intValue());
						}
						Cell  R26cell25 = row26.getCell(31); 
						if (R26cell25 != null) {
							R26cell25.setCellValue(brf68a.getR26_amount11() == null ? 0 : brf68a.getR26_amount11().intValue());
						}
						Cell  R26cell26 = row26.getCell(32); 
						if (R26cell26 != null) {
							R26cell26.setCellValue(brf68a.getR26_nos12() == null ? 0 : brf68a.getR26_nos12().intValue());
						}
						Cell  R26cell27 = row26.getCell(33); 
						if (R26cell27 != null) {
							R26cell27.setCellValue(brf68a.getR26_amount12() == null ? 0 : brf68a.getR26_amount12().intValue());
						}
						Cell  R26cell28 = row26.getCell(34); 
						if (R26cell28 != null) {
							R26cell28.setCellValue(brf68a.getR26_nos13() == null ? 0 : brf68a.getR26_nos13().intValue());
						}
						Cell  R26cell29 = row26.getCell(35); 
						if (R26cell29 != null) {
							R26cell29.setCellValue(brf68a.getR26_amount13() == null ? 0 : brf68a.getR26_amount13().intValue());
						}
						Cell  R26cell30 = row26.getCell(36); 
						if (R26cell30 != null) {
							R26cell30.setCellValue(brf68a.getR26_nos14() == null ? 0 : brf68a.getR26_nos14().intValue());
						}
						Cell  R26cell31 = row26.getCell(37); 
						if (R26cell31 != null) {
							R26cell31.setCellValue(brf68a.getR26_amount14() == null ? 0 : brf68a.getR26_amount14().intValue());
						}
						
			            Row row27 = sheet.getRow(36);
			            Cell R27cell1 = row27.getCell(4); 
						if (R27cell1 != null) {
							R27cell1.setCellValue(brf68a.getR27_male() == null ? 0 : brf68a.getR27_male().intValue());
						}
						Cell R27cell2 = row27.getCell(5); 
						if (R27cell2 != null) {
							R27cell2.setCellValue(brf68a.getR27_female() == null ? 0 : brf68a.getR27_female().intValue());
						}
						/*
						 * Cell R27cell3 = row27.getCell(6); if (R27cell3 != null) {
						 * R27cell3.setCellValue(brf68a.getR27_entities() == null ? 0 :
						 * brf68a.getR27_entities().intValue()); }
						 */
						Cell R27cell4 = row27.getCell(10); 
						if (R27cell4 != null) {
							R27cell4.setCellValue(brf68a.getR27_nos1() == null ? 0 : brf68a.getR27_nos1().intValue());
						}
						Cell R27cell5 = row27.getCell(11); 
						if (R27cell5 != null) {
							R27cell5.setCellValue(brf68a.getR27_amount1() == null ? 0 : brf68a.getR27_amount1().intValue());
						}
						Cell R27cell6 = row27.getCell(12); 
						if (R27cell6 != null) {
							R27cell6.setCellValue(brf68a.getR27_nos2() == null ? 0 : brf68a.getR27_nos2().intValue());
						}
						Cell R27cell7 = row27.getCell(13); 
						if (R27cell7 != null) {
							R27cell7.setCellValue(brf68a.getR27_amount2() == null ? 0 : brf68a.getR27_amount2().intValue());
						}
						Cell R27cell8 = row27.getCell(14); 
						if (R27cell8 != null) {
							R27cell8.setCellValue(brf68a.getR27_nos3() == null ? 0 : brf68a.getR27_nos3().intValue());
						}
						Cell R27cell9 = row27.getCell(15); 
						if (R27cell9 != null) {
							R27cell9.setCellValue(brf68a.getR27_amount3() == null ? 0 : brf68a.getR27_amount3().intValue());
						}
						Cell R27cell10 = row27.getCell(16); 
						if (R27cell10 != null) {
							R27cell10.setCellValue(brf68a.getR27_nos4() == null ? 0 : brf68a.getR27_nos4().intValue());
						}
						Cell R27cell11 = row27.getCell(17); 
						if (R27cell11 != null) {
							R27cell11.setCellValue(brf68a.getR27_amount4() == null ? 0 : brf68a.getR27_amount4().intValue());
						}
						Cell R27cell12 = row27.getCell(18); 
						if (R27cell12 != null) {
							R27cell12.setCellValue(brf68a.getR27_nos5() == null ? 0 : brf68a.getR27_nos5().intValue());
						}
						Cell R27cell13 = row27.getCell(19); 
						if (R27cell13 != null) {
							R27cell13.setCellValue(brf68a.getR27_amount5() == null ? 0 : brf68a.getR27_amount5().intValue());
						}
						Cell R27cell14 = row27.getCell(20); 
						if (R27cell14 != null) {
							R27cell14.setCellValue(brf68a.getR27_nos6() == null ? 0 : brf68a.getR27_nos6().intValue());
						}
						Cell R27cell15 = row27.getCell(21); 
						if (R27cell15 != null) {
							R27cell15.setCellValue(brf68a.getR27_amount6() == null ? 0 : brf68a.getR27_amount6().intValue());
						}
						Cell R27cell16 = row27.getCell(22); 
						if (R27cell16 != null) {
							R27cell16.setCellValue(brf68a.getR27_nos7() == null ? 0 : brf68a.getR27_nos7().intValue());
						}
						Cell  R27cell17 = row27.getCell(23); 
						if (R27cell17 != null) {
							R27cell17.setCellValue(brf68a.getR27_amount7() == null ? 0 : brf68a.getR27_amount7().intValue());
						}
						Cell  R27cell18 = row27.getCell(24); 
						if (R27cell18 != null) {
							R27cell18.setCellValue(brf68a.getR27_nos8() == null ? 0 : brf68a.getR27_nos8().intValue());
						}
						Cell  R27cell19 = row27.getCell(25); 
						if (R27cell19 != null) {
							R27cell19.setCellValue(brf68a.getR27_amount8() == null ? 0 : brf68a.getR27_amount8().intValue());
						}
						Cell  R27cell20 = row27.getCell(26); 
						if (R27cell20 != null) {
							R27cell20.setCellValue(brf68a.getR27_nos9() == null ? 0 : brf68a.getR27_nos9().intValue());
						}
						Cell  R27cell21 = row27.getCell(27); 
						if (R27cell21 != null) {
							R27cell21.setCellValue(brf68a.getR27_amount9() == null ? 0 : brf68a.getR27_amount9().intValue());
						}
						Cell R27cell22 = row27.getCell(28); 
						if (R27cell22 != null) {
							R27cell22.setCellValue(brf68a.getR27_nos10() == null ? 0 : brf68a.getR27_nos10().intValue());
						}
						Cell  R27cell23 = row27.getCell(29); 
						if (R27cell23 != null) {
							R27cell23.setCellValue(brf68a.getR27_amount10() == null ? 0 : brf68a.getR27_amount10().intValue());
						}
						Cell R27cell24 = row27.getCell(30); 
						if (R27cell24 != null) {
							R27cell24.setCellValue(brf68a.getR27_nos11() == null ? 0 : brf68a.getR27_nos11().intValue());
						}
						Cell  R27cell25 = row27.getCell(31); 
						if (R27cell25 != null) {
							R27cell25.setCellValue(brf68a.getR27_amount11() == null ? 0 : brf68a.getR27_amount11().intValue());
						}
						Cell  R27cell26 = row27.getCell(32); 
						if (R27cell26 != null) {
							R27cell26.setCellValue(brf68a.getR27_nos12() == null ? 0 : brf68a.getR27_nos12().intValue());
						}
						Cell  R27cell27 = row27.getCell(33); 
						if (R27cell27 != null) {
							R27cell27.setCellValue(brf68a.getR27_amount12() == null ? 0 : brf68a.getR27_amount12().intValue());
						}
						Cell  R27cell28 = row27.getCell(34); 
						if (R27cell28 != null) {
							R27cell28.setCellValue(brf68a.getR27_nos13() == null ? 0 : brf68a.getR27_nos13().intValue());
						}
						Cell  R27cell29 = row27.getCell(35); 
						if (R27cell29 != null) {
							R27cell29.setCellValue(brf68a.getR27_amount13() == null ? 0 : brf68a.getR27_amount13().intValue());
						}
						Cell  R27cell30 = row27.getCell(36); 
						if (R27cell30 != null) {
							R27cell30.setCellValue(brf68a.getR27_nos14() == null ? 0 : brf68a.getR27_nos14().intValue());
						}
						Cell  R27cell31 = row27.getCell(37); 
						if (R27cell31 != null) {
							R27cell31.setCellValue(brf68a.getR27_amount14() == null ? 0 : brf68a.getR27_amount14().intValue());
						}
						
			            Row row28 = sheet.getRow(37);
			            Cell R28cell1 = row28.getCell(4); 
						if (R28cell1 != null) {
							R28cell1.setCellValue(brf68a.getR28_male() == null ? 0 : brf68a.getR28_male().intValue());
						}
						Cell R28cell2 = row28.getCell(5); 
						if (R28cell2 != null) {
							R28cell2.setCellValue(brf68a.getR28_female() == null ? 0 : brf68a.getR28_female().intValue());
						}
						/*
						 * Cell R28cell3 = row28.getCell(6); if (R28cell3 != null) {
						 * R28cell3.setCellValue(brf68a.getR28_entities() == null ? 0 :
						 * brf68a.getR28_entities().intValue()); }
						 */
						Cell R28cell4 = row28.getCell(10); 
						if (R28cell4 != null) {
							R28cell4.setCellValue(brf68a.getR28_nos1() == null ? 0 : brf68a.getR28_nos1().intValue());
						}
						Cell R28cell5 = row28.getCell(11); 
						if (R28cell5 != null) {
							R28cell5.setCellValue(brf68a.getR28_amount1() == null ? 0 : brf68a.getR28_amount1().intValue());
						}
						Cell R28cell6 = row28.getCell(12); 
						if (R28cell6 != null) {
							R28cell6.setCellValue(brf68a.getR28_nos2() == null ? 0 : brf68a.getR28_nos2().intValue());
						}
						Cell R28cell7 = row28.getCell(13); 
						if (R28cell7 != null) {
							R28cell7.setCellValue(brf68a.getR28_amount2() == null ? 0 : brf68a.getR28_amount2().intValue());
						}
						Cell R28cell8 = row28.getCell(14); 
						if (R28cell8 != null) {
							R28cell8.setCellValue(brf68a.getR28_nos3() == null ? 0 : brf68a.getR28_nos3().intValue());
						}
						Cell R28cell9 = row28.getCell(15); 
						if (R28cell9 != null) {
							R28cell9.setCellValue(brf68a.getR28_amount3() == null ? 0 : brf68a.getR28_amount3().intValue());
						}
						Cell R28cell10 = row28.getCell(16); 
						if (R28cell10 != null) {
							R28cell10.setCellValue(brf68a.getR28_nos4() == null ? 0 : brf68a.getR28_nos4().intValue());
						}
						Cell R28cell11 = row28.getCell(17); 
						if (R28cell11 != null) {
							R28cell11.setCellValue(brf68a.getR28_amount4() == null ? 0 : brf68a.getR28_amount4().intValue());
						}
						Cell R28cell12 = row28.getCell(18); 
						if (R28cell12 != null) {
							R28cell12.setCellValue(brf68a.getR28_nos5() == null ? 0 : brf68a.getR28_nos5().intValue());
						}
						Cell R28cell13 = row28.getCell(19); 
						if (R28cell13 != null) {
							R28cell13.setCellValue(brf68a.getR28_amount5() == null ? 0 : brf68a.getR28_amount5().intValue());
						}
						Cell R28cell14 = row28.getCell(20); 
						if (R28cell14 != null) {
							R28cell14.setCellValue(brf68a.getR28_nos6() == null ? 0 : brf68a.getR28_nos6().intValue());
						}
						Cell R28cell15 = row28.getCell(21); 
						if (R28cell15 != null) {
							R28cell15.setCellValue(brf68a.getR28_amount6() == null ? 0 : brf68a.getR28_amount6().intValue());
						}
						Cell R28cell16 = row28.getCell(22); 
						if (R28cell16 != null) {
							R28cell16.setCellValue(brf68a.getR28_nos7() == null ? 0 : brf68a.getR28_nos7().intValue());
						}
						Cell  R28cell17 = row28.getCell(23); 
						if (R28cell17 != null) {
							R28cell17.setCellValue(brf68a.getR28_amount7() == null ? 0 : brf68a.getR28_amount7().intValue());
						}
						Cell  R28cell18 = row28.getCell(24); 
						if (R28cell18 != null) {
							R28cell18.setCellValue(brf68a.getR28_nos8() == null ? 0 : brf68a.getR28_nos8().intValue());
						}
						Cell  R28cell19 = row28.getCell(25); 
						if (R28cell19 != null) {
							R28cell19.setCellValue(brf68a.getR28_amount8() == null ? 0 : brf68a.getR28_amount8().intValue());
						}
						Cell  R28cell20 = row28.getCell(26); 
						if (R28cell20 != null) {
							R28cell20.setCellValue(brf68a.getR28_nos9() == null ? 0 : brf68a.getR28_nos9().intValue());
						}
						Cell  R28cell21 = row28.getCell(27); 
						if (R28cell21 != null) {
							R28cell21.setCellValue(brf68a.getR28_amount9() == null ? 0 : brf68a.getR28_amount9().intValue());
						}
						Cell R28cell22 = row28.getCell(28); 
						if (R28cell22 != null) {
							R28cell22.setCellValue(brf68a.getR28_nos10() == null ? 0 : brf68a.getR28_nos10().intValue());
						}
						Cell  R28cell23 = row28.getCell(29); 
						if (R28cell23 != null) {
							R28cell23.setCellValue(brf68a.getR28_amount10() == null ? 0 : brf68a.getR28_amount10().intValue());
						}
						Cell R28cell24 = row28.getCell(30); 
						if (R28cell24 != null) {
							R28cell24.setCellValue(brf68a.getR28_nos11() == null ? 0 : brf68a.getR28_nos11().intValue());
						}
						Cell  R28cell25 = row28.getCell(31); 
						if (R28cell25 != null) {
							R28cell25.setCellValue(brf68a.getR28_amount11() == null ? 0 : brf68a.getR28_amount11().intValue());
						}
						Cell  R28cell26 = row28.getCell(32); 
						if (R28cell26 != null) {
							R28cell26.setCellValue(brf68a.getR28_nos12() == null ? 0 : brf68a.getR28_nos12().intValue());
						}
						Cell  R28cell27 = row28.getCell(33); 
						if (R28cell27 != null) {
							R28cell27.setCellValue(brf68a.getR28_amount12() == null ? 0 : brf68a.getR28_amount12().intValue());
						}
						Cell  R28cell28 = row28.getCell(34); 
						if (R28cell28 != null) {
							R28cell28.setCellValue(brf68a.getR28_nos13() == null ? 0 : brf68a.getR28_nos13().intValue());
						}
						Cell  R28cell29 = row28.getCell(35); 
						if (R28cell29 != null) {
							R28cell29.setCellValue(brf68a.getR28_amount13() == null ? 0 : brf68a.getR28_amount13().intValue());
						}
						Cell  R28cell30 = row28.getCell(36); 
						if (R28cell30 != null) {
							R28cell30.setCellValue(brf68a.getR28_nos14() == null ? 0 : brf68a.getR28_nos14().intValue());
						}
						Cell  R28cell31 = row28.getCell(37); 
						if (R28cell31 != null) {
							R28cell31.setCellValue(brf68a.getR28_amount14() == null ? 0 : brf68a.getR28_amount14().intValue());
						}
						
			            Row row29 = sheet.getRow(38);
			            Cell R29cell1 = row29.getCell(4); 
						if (R29cell1 != null) {
							R29cell1.setCellValue(brf68a.getR29_male() == null ? 0 : brf68a.getR29_male().intValue());
						}
						Cell R29cell2 = row29.getCell(5); 
						if (R29cell2 != null) {
							R29cell2.setCellValue(brf68a.getR29_female() == null ? 0 : brf68a.getR29_female().intValue());
						}
						/*
						 * Cell R29cell3 = row29.getCell(6); if (R29cell3 != null) {
						 * R29cell3.setCellValue(brf68a.getR29_entities() == null ? 0 :
						 * brf68a.getR29_entities().intValue()); }
						 */
						Cell R29cell4 = row29.getCell(10); 
						if (R29cell4 != null) {
							R29cell4.setCellValue(brf68a.getR29_nos1() == null ? 0 : brf68a.getR29_nos1().intValue());
						}
						Cell R29cell5 = row29.getCell(11); 
						if (R29cell5 != null) {
							R29cell5.setCellValue(brf68a.getR29_amount1() == null ? 0 : brf68a.getR29_amount1().intValue());
						}
						Cell R29cell6 = row29.getCell(12); 
						if (R29cell6 != null) {
							R29cell6.setCellValue(brf68a.getR29_nos2() == null ? 0 : brf68a.getR29_nos2().intValue());
						}
						Cell R29cell7 = row29.getCell(13); 
						if (R29cell7 != null) {
							R29cell7.setCellValue(brf68a.getR29_amount2() == null ? 0 : brf68a.getR29_amount2().intValue());
						}
						Cell R29cell8 = row29.getCell(14); 
						if (R29cell8 != null) {
							R29cell8.setCellValue(brf68a.getR29_nos3() == null ? 0 : brf68a.getR29_nos3().intValue());
						}
						Cell R29cell9 = row29.getCell(15); 
						if (R29cell9 != null) {
							R29cell9.setCellValue(brf68a.getR29_amount3() == null ? 0 : brf68a.getR29_amount3().intValue());
						}
						Cell R29cell10 = row29.getCell(16); 
						if (R29cell10 != null) {
							R29cell10.setCellValue(brf68a.getR29_nos4() == null ? 0 : brf68a.getR29_nos4().intValue());
						}
						Cell R29cell11 = row29.getCell(17); 
						if (R29cell11 != null) {
							R29cell11.setCellValue(brf68a.getR29_amount4() == null ? 0 : brf68a.getR29_amount4().intValue());
						}
						Cell R29cell12 = row29.getCell(18); 
						if (R29cell12 != null) {
							R29cell12.setCellValue(brf68a.getR29_nos5() == null ? 0 : brf68a.getR29_nos5().intValue());
						}
						Cell R29cell13 = row29.getCell(19); 
						if (R29cell13 != null) {
							R29cell13.setCellValue(brf68a.getR29_amount5() == null ? 0 : brf68a.getR29_amount5().intValue());
						}
						Cell R29cell14 = row29.getCell(20); 
						if (R29cell14 != null) {
							R29cell14.setCellValue(brf68a.getR29_nos6() == null ? 0 : brf68a.getR29_nos6().intValue());
						}
						Cell R29cell15 = row29.getCell(21); 
						if (R29cell15 != null) {
							R29cell15.setCellValue(brf68a.getR29_amount6() == null ? 0 : brf68a.getR29_amount6().intValue());
						}
						Cell R29cell16 = row29.getCell(22); 
						if (R29cell16 != null) {
							R29cell16.setCellValue(brf68a.getR29_nos7() == null ? 0 : brf68a.getR29_nos7().intValue());
						}
						Cell  R29cell17 = row29.getCell(23); 
						if (R29cell17 != null) {
							R29cell17.setCellValue(brf68a.getR29_amount7() == null ? 0 : brf68a.getR29_amount7().intValue());
						}
						Cell  R29cell18 = row29.getCell(24); 
						if (R29cell18 != null) {
							R29cell18.setCellValue(brf68a.getR29_nos8() == null ? 0 : brf68a.getR29_nos8().intValue());
						}
						Cell  R29cell19 = row29.getCell(25); 
						if (R29cell19 != null) {
							R29cell19.setCellValue(brf68a.getR29_amount8() == null ? 0 : brf68a.getR29_amount8().intValue());
						}
						Cell  R29cell20 = row29.getCell(26); 
						if (R29cell20 != null) {
							R29cell20.setCellValue(brf68a.getR29_nos9() == null ? 0 : brf68a.getR29_nos9().intValue());
						}
						Cell  R29cell21 = row29.getCell(27); 
						if (R29cell21 != null) {
							R29cell21.setCellValue(brf68a.getR29_amount9() == null ? 0 : brf68a.getR29_amount9().intValue());
						}
						Cell R29cell22 = row29.getCell(28); 
						if (R29cell22 != null) {
							R29cell22.setCellValue(brf68a.getR29_nos10() == null ? 0 : brf68a.getR29_nos10().intValue());
						}
						Cell  R29cell23 = row29.getCell(29); 
						if (R29cell23 != null) {
							R29cell23.setCellValue(brf68a.getR29_amount10() == null ? 0 : brf68a.getR29_amount10().intValue());
						}
						Cell R29cell24 = row29.getCell(30); 
						if (R29cell24 != null) {
							R29cell24.setCellValue(brf68a.getR29_nos11() == null ? 0 : brf68a.getR29_nos11().intValue());
						}
						Cell  R29cell25 = row29.getCell(31); 
						if (R29cell25 != null) {
							R29cell25.setCellValue(brf68a.getR29_amount11() == null ? 0 : brf68a.getR29_amount11().intValue());
						}
						Cell  R29cell26 = row29.getCell(32); 
						if (R29cell26 != null) {
							R29cell26.setCellValue(brf68a.getR29_nos12() == null ? 0 : brf68a.getR29_nos12().intValue());
						}
						Cell  R29cell27 = row29.getCell(33); 
						if (R29cell27 != null) {
							R29cell27.setCellValue(brf68a.getR29_amount12() == null ? 0 : brf68a.getR29_amount12().intValue());
						}
						Cell  R29cell28 = row29.getCell(34); 
						if (R29cell28 != null) {
							R29cell28.setCellValue(brf68a.getR29_nos13() == null ? 0 : brf68a.getR29_nos13().intValue());
						}
						Cell  R29cell29 = row29.getCell(35); 
						if (R29cell29 != null) {
							R29cell29.setCellValue(brf68a.getR29_amount13() == null ? 0 : brf68a.getR29_amount13().intValue());
						}
						Cell  R29cell30 = row29.getCell(36); 
						if (R29cell30 != null) {
							R29cell30.setCellValue(brf68a.getR29_nos14() == null ? 0 : brf68a.getR29_nos14().intValue());
						}
						Cell  R29cell31 = row29.getCell(37); 
						if (R29cell31 != null) {
							R29cell31.setCellValue(brf68a.getR29_amount14() == null ? 0 : brf68a.getR29_amount14().intValue());
						}
						
			            Row row31 = sheet.getRow(40);
						/*
						 * Cell R31cell1 = row31.getCell(4); if (R31cell1 != null) {
						 * R31cell1.setCellValue(brf68a.getR31_male() == null ? 0 :
						 * brf68a.getR31_male().intValue()); } Cell R31cell2 = row31.getCell(5); if
						 * (R31cell2 != null) { R31cell2.setCellValue(brf68a.getR31_female() == null ? 0
						 * : brf68a.getR31_female().intValue()); }
						 */
						Cell R31cell3 = row31.getCell(6); 
						if (R31cell3 != null) {
							R31cell3.setCellValue(brf68a.getR31_entities() == null ? 0 : brf68a.getR31_entities().intValue());
						}
						Cell R31cell4 = row31.getCell(10); 
						if (R31cell4 != null) {
							R31cell4.setCellValue(brf68a.getR31_nos1() == null ? 0 : brf68a.getR31_nos1().intValue());
						}
						Cell R31cell5 = row31.getCell(11); 
						if (R31cell5 != null) {
							R31cell5.setCellValue(brf68a.getR31_amount1() == null ? 0 : brf68a.getR31_amount1().intValue());
						}
						Cell R31cell6 = row31.getCell(12); 
						if (R31cell6 != null) {
							R31cell6.setCellValue(brf68a.getR31_nos2() == null ? 0 : brf68a.getR31_nos2().intValue());
						}
						Cell R31cell7 = row31.getCell(13); 
						if (R31cell7 != null) {
							R31cell7.setCellValue(brf68a.getR31_amount2() == null ? 0 : brf68a.getR31_amount2().intValue());
						}
						Cell R31cell8 = row31.getCell(14); 
						if (R31cell8 != null) {
							R31cell8.setCellValue(brf68a.getR31_nos3() == null ? 0 : brf68a.getR31_nos3().intValue());
						}
						Cell R31cell9 = row31.getCell(15); 
						if (R31cell9 != null) {
							R31cell9.setCellValue(brf68a.getR31_amount3() == null ? 0 : brf68a.getR31_amount3().intValue());
						}
						Cell R31cell10 = row31.getCell(16); 
						if (R31cell10 != null) {
							R31cell10.setCellValue(brf68a.getR31_nos4() == null ? 0 : brf68a.getR31_nos4().intValue());
						}
						Cell R31cell11 = row31.getCell(17); 
						if (R31cell11 != null) {
							R31cell11.setCellValue(brf68a.getR31_amount4() == null ? 0 : brf68a.getR31_amount4().intValue());
						}
						Cell R31cell12 = row31.getCell(18); 
						if (R31cell12 != null) {
							R31cell12.setCellValue(brf68a.getR31_nos5() == null ? 0 : brf68a.getR31_nos5().intValue());
						}
						Cell R31cell13 = row31.getCell(19); 
						if (R31cell13 != null) {
							R31cell13.setCellValue(brf68a.getR31_amount5() == null ? 0 : brf68a.getR31_amount5().intValue());
						}
						Cell R31cell14 = row31.getCell(20); 
						if (R31cell14 != null) {
							R31cell14.setCellValue(brf68a.getR31_nos6() == null ? 0 : brf68a.getR31_nos6().intValue());
						}
						Cell R31cell15 = row31.getCell(21); 
						if (R31cell15 != null) {
							R31cell15.setCellValue(brf68a.getR31_amount6() == null ? 0 : brf68a.getR31_amount6().intValue());
						}
						Cell R31cell16 = row31.getCell(22); 
						if (R31cell16 != null) {
							R31cell16.setCellValue(brf68a.getR31_nos7() == null ? 0 : brf68a.getR31_nos7().intValue());
						}
						Cell  R31cell17 = row31.getCell(23); 
						if (R31cell17 != null) {
							R31cell17.setCellValue(brf68a.getR31_amount7() == null ? 0 : brf68a.getR31_amount7().intValue());
						}
						Cell  R31cell18 = row31.getCell(24); 
						if (R31cell18 != null) {
							R31cell18.setCellValue(brf68a.getR31_nos8() == null ? 0 : brf68a.getR31_nos8().intValue());
						}
						Cell  R31cell19 = row31.getCell(25); 
						if (R31cell19 != null) {
							R31cell19.setCellValue(brf68a.getR31_amount8() == null ? 0 : brf68a.getR31_amount8().intValue());
						}
						Cell  R31cell20 = row31.getCell(26); 
						if (R31cell20 != null) {
							R31cell20.setCellValue(brf68a.getR31_nos9() == null ? 0 : brf68a.getR31_nos9().intValue());
						}
						Cell  R31cell21 = row31.getCell(27); 
						if (R31cell21 != null) {
							R31cell21.setCellValue(brf68a.getR31_amount9() == null ? 0 : brf68a.getR31_amount9().intValue());
						}
						Cell R31cell22 = row31.getCell(28); 
						if (R31cell22 != null) {
							R31cell22.setCellValue(brf68a.getR31_nos10() == null ? 0 : brf68a.getR31_nos10().intValue());
						}
						Cell  R31cell23 = row31.getCell(29); 
						if (R31cell23 != null) {
							R31cell23.setCellValue(brf68a.getR31_amount10() == null ? 0 : brf68a.getR31_amount10().intValue());
						}
						Cell R31cell24 = row31.getCell(30); 
						if (R31cell24 != null) {
							R31cell24.setCellValue(brf68a.getR31_nos11() == null ? 0 : brf68a.getR31_nos11().intValue());
						}
						Cell  R31cell25 = row31.getCell(31); 
						if (R31cell25 != null) {
							R31cell25.setCellValue(brf68a.getR31_amount11() == null ? 0 : brf68a.getR31_amount11().intValue());
						}
						Cell  R31cell26 = row31.getCell(32); 
						if (R31cell26 != null) {
							R31cell26.setCellValue(brf68a.getR31_nos12() == null ? 0 : brf68a.getR31_nos12().intValue());
						}
						Cell  R31cell27 = row31.getCell(33); 
						if (R31cell27 != null) {
							R31cell27.setCellValue(brf68a.getR31_amount12() == null ? 0 : brf68a.getR31_amount12().intValue());
						}
						Cell  R31cell28 = row31.getCell(34); 
						if (R31cell28 != null) {
							R31cell28.setCellValue(brf68a.getR31_nos13() == null ? 0 : brf68a.getR31_nos13().intValue());
						}
						Cell  R31cell29 = row31.getCell(35); 
						if (R31cell29 != null) {
							R31cell29.setCellValue(brf68a.getR31_amount13() == null ? 0 : brf68a.getR31_amount13().intValue());
						}
						Cell  R31cell30 = row31.getCell(36); 
						if (R31cell30 != null) {
							R31cell30.setCellValue(brf68a.getR31_nos14() == null ? 0 : brf68a.getR31_nos14().intValue());
						}
						Cell  R31cell31 = row31.getCell(37); 
						if (R31cell31 != null) {
							R31cell31.setCellValue(brf68a.getR31_amount14() == null ? 0 : brf68a.getR31_amount14().intValue());
						}
						
			            Row row32 = sheet.getRow(41);
						/*
						 * Cell R32cell1 = row32.getCell(4); if (R32cell1 != null) {
						 * R32cell1.setCellValue(brf68a.getR32_male() == null ? 0 :
						 * brf68a.getR32_male().intValue()); } Cell R32cell2 = row32.getCell(5); if
						 * (R32cell2 != null) { R32cell2.setCellValue(brf68a.getR32_female() == null ? 0
						 * : brf68a.getR32_female().intValue()); }
						 */
						Cell R32cell3 = row32.getCell(6); 
						if (R32cell3 != null) {
							R32cell3.setCellValue(brf68a.getR32_entities() == null ? 0 : brf68a.getR32_entities().intValue());
						}
						Cell R32cell4 = row32.getCell(10); 
						if (R32cell4 != null) {
							R32cell4.setCellValue(brf68a.getR32_nos1() == null ? 0 : brf68a.getR32_nos1().intValue());
						}
						Cell R32cell5 = row32.getCell(11); 
						if (R32cell5 != null) {
							R32cell5.setCellValue(brf68a.getR32_amount1() == null ? 0 : brf68a.getR32_amount1().intValue());
						}
						Cell R32cell6 = row32.getCell(12); 
						if (R32cell6 != null) {
							R32cell6.setCellValue(brf68a.getR32_nos2() == null ? 0 : brf68a.getR32_nos2().intValue());
						}
						Cell R32cell7 = row32.getCell(13); 
						if (R32cell7 != null) {
							R32cell7.setCellValue(brf68a.getR32_amount2() == null ? 0 : brf68a.getR32_amount2().intValue());
						}
						Cell R32cell8 = row32.getCell(14); 
						if (R32cell8 != null) {
							R32cell8.setCellValue(brf68a.getR32_nos3() == null ? 0 : brf68a.getR32_nos3().intValue());
						}
						Cell R32cell9 = row32.getCell(15); 
						if (R32cell9 != null) {
							R32cell9.setCellValue(brf68a.getR32_amount3() == null ? 0 : brf68a.getR32_amount3().intValue());
						}
						Cell R32cell10 = row32.getCell(16); 
						if (R32cell10 != null) {
							R32cell10.setCellValue(brf68a.getR32_nos4() == null ? 0 : brf68a.getR32_nos4().intValue());
						}
						Cell R32cell11 = row32.getCell(17); 
						if (R32cell11 != null) {
							R32cell11.setCellValue(brf68a.getR32_amount4() == null ? 0 : brf68a.getR32_amount4().intValue());
						}
						Cell R32cell12 = row32.getCell(18); 
						if (R32cell12 != null) {
							R32cell12.setCellValue(brf68a.getR32_nos5() == null ? 0 : brf68a.getR32_nos5().intValue());
						}
						Cell R32cell13 = row32.getCell(19); 
						if (R32cell13 != null) {
							R32cell13.setCellValue(brf68a.getR32_amount5() == null ? 0 : brf68a.getR32_amount5().intValue());
						}
						Cell R32cell14 = row32.getCell(20); 
						if (R32cell14 != null) {
							R32cell14.setCellValue(brf68a.getR32_nos6() == null ? 0 : brf68a.getR32_nos6().intValue());
						}
						Cell R32cell15 = row32.getCell(21); 
						if (R32cell15 != null) {
							R32cell15.setCellValue(brf68a.getR32_amount6() == null ? 0 : brf68a.getR32_amount6().intValue());
						}
						Cell R32cell16 = row32.getCell(22); 
						if (R32cell16 != null) {
							R32cell16.setCellValue(brf68a.getR32_nos7() == null ? 0 : brf68a.getR32_nos7().intValue());
						}
						Cell  R32cell17 = row32.getCell(23); 
						if (R32cell17 != null) {
							R32cell17.setCellValue(brf68a.getR32_amount7() == null ? 0 : brf68a.getR32_amount7().intValue());
						}
						Cell  R32cell18 = row32.getCell(24); 
						if (R32cell18 != null) {
							R32cell18.setCellValue(brf68a.getR32_nos8() == null ? 0 : brf68a.getR32_nos8().intValue());
						}
						Cell  R32cell19 = row32.getCell(25); 
						if (R32cell19 != null) {
							R32cell19.setCellValue(brf68a.getR32_amount8() == null ? 0 : brf68a.getR32_amount8().intValue());
						}
						Cell  R32cell20 = row32.getCell(26); 
						if (R32cell20 != null) {
							R32cell20.setCellValue(brf68a.getR32_nos9() == null ? 0 : brf68a.getR32_nos9().intValue());
						}
						Cell  R32cell21 = row32.getCell(27); 
						if (R32cell21 != null) {
							R32cell21.setCellValue(brf68a.getR32_amount9() == null ? 0 : brf68a.getR32_amount9().intValue());
						}
						Cell R32cell22 = row32.getCell(28); 
						if (R32cell22 != null) {
							R32cell22.setCellValue(brf68a.getR32_nos10() == null ? 0 : brf68a.getR32_nos10().intValue());
						}
						Cell  R32cell23 = row32.getCell(29); 
						if (R32cell23 != null) {
							R32cell23.setCellValue(brf68a.getR32_amount10() == null ? 0 : brf68a.getR32_amount10().intValue());
						}
						Cell R32cell24 = row32.getCell(30); 
						if (R32cell24 != null) {
							R32cell24.setCellValue(brf68a.getR32_nos11() == null ? 0 : brf68a.getR32_nos11().intValue());
						}
						Cell  R32cell25 = row32.getCell(31); 
						if (R32cell25 != null) {
							R32cell25.setCellValue(brf68a.getR32_amount11() == null ? 0 : brf68a.getR32_amount11().intValue());
						}
						Cell  R32cell26 = row32.getCell(32); 
						if (R32cell26 != null) {
							R32cell26.setCellValue(brf68a.getR32_nos12() == null ? 0 : brf68a.getR32_nos12().intValue());
						}
						Cell  R32cell27 = row32.getCell(33); 
						if (R32cell27 != null) {
							R32cell27.setCellValue(brf68a.getR32_amount12() == null ? 0 : brf68a.getR32_amount12().intValue());
						}
						Cell  R32cell28 = row32.getCell(34); 
						if (R32cell28 != null) {
							R32cell28.setCellValue(brf68a.getR32_nos13() == null ? 0 : brf68a.getR32_nos13().intValue());
						}
						Cell  R32cell29 = row32.getCell(35); 
						if (R32cell29 != null) {
							R32cell29.setCellValue(brf68a.getR32_amount13() == null ? 0 : brf68a.getR32_amount13().intValue());
						}
						Cell  R32cell30 = row32.getCell(36); 
						if (R32cell30 != null) {
							R32cell30.setCellValue(brf68a.getR32_nos14() == null ? 0 : brf68a.getR32_nos14().intValue());
						}
						Cell  R32cell31 = row32.getCell(37); 
						if (R32cell31 != null) {
							R32cell31.setCellValue(brf68a.getR32_amount14() == null ? 0 : brf68a.getR32_amount14().intValue());
						}
						
			            Row row33 = sheet.getRow(42);
						/*
						 * Cell R33cell1 = row33.getCell(4); if (R33cell1 != null) {
						 * R33cell1.setCellValue(brf68a.getR33_male() == null ? 0 :
						 * brf68a.getR33_male().intValue()); } Cell R33cell2 = row33.getCell(5); if
						 * (R33cell2 != null) { R33cell2.setCellValue(brf68a.getR33_female() == null ? 0
						 * : brf68a.getR33_female().intValue()); }
						 */
						Cell R33cell3 = row33.getCell(6); 
						if (R33cell3 != null) {
							R33cell3.setCellValue(brf68a.getR33_entities() == null ? 0 : brf68a.getR33_entities().intValue());
						}
						Cell R33cell4 = row33.getCell(10); 
						if (R33cell4 != null) {
							R33cell4.setCellValue(brf68a.getR33_nos1() == null ? 0 : brf68a.getR33_nos1().intValue());
						}
						Cell R33cell5 = row33.getCell(11); 
						if (R33cell5 != null) {
							R33cell5.setCellValue(brf68a.getR33_amount1() == null ? 0 : brf68a.getR33_amount1().intValue());
						}
						Cell R33cell6 = row33.getCell(12); 
						if (R33cell6 != null) {
							R33cell6.setCellValue(brf68a.getR33_nos2() == null ? 0 : brf68a.getR33_nos2().intValue());
						}
						Cell R33cell7 = row33.getCell(13); 
						if (R33cell7 != null) {
							R33cell7.setCellValue(brf68a.getR33_amount2() == null ? 0 : brf68a.getR33_amount2().intValue());
						}
						Cell R33cell8 = row33.getCell(14); 
						if (R33cell8 != null) {
							R33cell8.setCellValue(brf68a.getR33_nos3() == null ? 0 : brf68a.getR33_nos3().intValue());
						}
						Cell R33cell9 = row33.getCell(15); 
						if (R33cell9 != null) {
							R33cell9.setCellValue(brf68a.getR33_amount3() == null ? 0 : brf68a.getR33_amount3().intValue());
						}
						Cell R33cell10 = row33.getCell(16); 
						if (R33cell10 != null) {
							R33cell10.setCellValue(brf68a.getR33_nos4() == null ? 0 : brf68a.getR33_nos4().intValue());
						}
						Cell R33cell11 = row33.getCell(17); 
						if (R33cell11 != null) {
							R33cell11.setCellValue(brf68a.getR33_amount4() == null ? 0 : brf68a.getR33_amount4().intValue());
						}
						Cell R33cell12 = row33.getCell(18); 
						if (R33cell12 != null) {
							R33cell12.setCellValue(brf68a.getR33_nos5() == null ? 0 : brf68a.getR33_nos5().intValue());
						}
						Cell R33cell13 = row33.getCell(19); 
						if (R33cell13 != null) {
							R33cell13.setCellValue(brf68a.getR33_amount5() == null ? 0 : brf68a.getR33_amount5().intValue());
						}
						Cell R33cell14 = row33.getCell(20); 
						if (R33cell14 != null) {
							R33cell14.setCellValue(brf68a.getR33_nos6() == null ? 0 : brf68a.getR33_nos6().intValue());
						}
						Cell R33cell15 = row33.getCell(21); 
						if (R33cell15 != null) {
							R33cell15.setCellValue(brf68a.getR33_amount6() == null ? 0 : brf68a.getR33_amount6().intValue());
						}
						Cell R33cell16 = row33.getCell(22); 
						if (R33cell16 != null) {
							R33cell16.setCellValue(brf68a.getR33_nos7() == null ? 0 : brf68a.getR33_nos7().intValue());
						}
						Cell  R33cell17 = row33.getCell(23); 
						if (R33cell17 != null) {
							R33cell17.setCellValue(brf68a.getR33_amount7() == null ? 0 : brf68a.getR33_amount7().intValue());
						}
						Cell  R33cell18 = row33.getCell(24); 
						if (R33cell18 != null) {
							R33cell18.setCellValue(brf68a.getR33_nos8() == null ? 0 : brf68a.getR33_nos8().intValue());
						}
						Cell  R33cell19 = row33.getCell(25); 
						if (R33cell19 != null) {
							R33cell19.setCellValue(brf68a.getR33_amount8() == null ? 0 : brf68a.getR33_amount8().intValue());
						}
						Cell  R33cell20 = row33.getCell(26); 
						if (R33cell20 != null) {
							R33cell20.setCellValue(brf68a.getR33_nos9() == null ? 0 : brf68a.getR33_nos9().intValue());
						}
						Cell  R33cell21 = row33.getCell(27); 
						if (R33cell21 != null) {
							R33cell21.setCellValue(brf68a.getR33_amount9() == null ? 0 : brf68a.getR33_amount9().intValue());
						}
						Cell R33cell22 = row33.getCell(28); 
						if (R33cell22 != null) {
							R33cell22.setCellValue(brf68a.getR33_nos10() == null ? 0 : brf68a.getR33_nos10().intValue());
						}
						Cell  R33cell23 = row33.getCell(29); 
						if (R33cell23 != null) {
							R33cell23.setCellValue(brf68a.getR33_amount10() == null ? 0 : brf68a.getR33_amount10().intValue());
						}
						Cell R33cell24 = row33.getCell(30); 
						if (R33cell24 != null) {
							R33cell24.setCellValue(brf68a.getR33_nos11() == null ? 0 : brf68a.getR33_nos11().intValue());
						}
						Cell  R33cell25 = row33.getCell(31); 
						if (R33cell25 != null) {
							R33cell25.setCellValue(brf68a.getR33_amount11() == null ? 0 : brf68a.getR33_amount11().intValue());
						}
						Cell  R33cell26 = row33.getCell(32); 
						if (R33cell26 != null) {
							R33cell26.setCellValue(brf68a.getR33_nos12() == null ? 0 : brf68a.getR33_nos12().intValue());
						}
						Cell  R33cell27 = row33.getCell(33); 
						if (R33cell27 != null) {
							R33cell27.setCellValue(brf68a.getR33_amount12() == null ? 0 : brf68a.getR33_amount12().intValue());
						}
						Cell  R33cell28 = row33.getCell(34); 
						if (R33cell28 != null) {
							R33cell28.setCellValue(brf68a.getR33_nos13() == null ? 0 : brf68a.getR33_nos13().intValue());
						}
						Cell  R33cell29 = row33.getCell(35); 
						if (R33cell29 != null) {
							R33cell29.setCellValue(brf68a.getR33_amount13() == null ? 0 : brf68a.getR33_amount13().intValue());
						}
						Cell  R33cell30 = row33.getCell(36); 
						if (R33cell30 != null) {
							R33cell30.setCellValue(brf68a.getR33_nos14() == null ? 0 : brf68a.getR33_nos14().intValue());
						}
						Cell  R33cell31 = row33.getCell(37); 
						if (R33cell31 != null) {
							R33cell31.setCellValue(brf68a.getR33_amount14() == null ? 0 : brf68a.getR33_amount14().intValue());
						}
						
			            Row row34 = sheet.getRow(43);
						/*
						 * Cell R34cell1 = row34.getCell(4); if (R34cell1 != null) {
						 * R34cell1.setCellValue(brf68a.getR34_male() == null ? 0 :
						 * brf68a.getR34_male().intValue()); } Cell R34cell2 = row34.getCell(5); if
						 * (R34cell2 != null) { R34cell2.setCellValue(brf68a.getR34_female() == null ? 0
						 * : brf68a.getR34_female().intValue()); }
						 */
						Cell R34cell3 = row34.getCell(6); 
						if (R34cell3 != null) {
							R34cell3.setCellValue(brf68a.getR34_entities() == null ? 0 : brf68a.getR34_entities().intValue());
						}
						Cell R34cell4 = row34.getCell(10); 
						if (R34cell4 != null) {
							R34cell4.setCellValue(brf68a.getR34_nos1() == null ? 0 : brf68a.getR34_nos1().intValue());
						}
						Cell R34cell5 = row34.getCell(11); 
						if (R34cell5 != null) {
							R34cell5.setCellValue(brf68a.getR34_amount1() == null ? 0 : brf68a.getR34_amount1().intValue());
						}
						Cell R34cell6 = row34.getCell(12); 
						if (R34cell6 != null) {
							R34cell6.setCellValue(brf68a.getR34_nos2() == null ? 0 : brf68a.getR34_nos2().intValue());
						}
						Cell R34cell7 = row34.getCell(13); 
						if (R34cell7 != null) {
							R34cell7.setCellValue(brf68a.getR34_amount2() == null ? 0 : brf68a.getR34_amount2().intValue());
						}
						Cell R34cell8 = row34.getCell(14); 
						if (R34cell8 != null) {
							R34cell8.setCellValue(brf68a.getR34_nos3() == null ? 0 : brf68a.getR34_nos3().intValue());
						}
						Cell R34cell9 = row34.getCell(15); 
						if (R34cell9 != null) {
							R34cell9.setCellValue(brf68a.getR34_amount3() == null ? 0 : brf68a.getR34_amount3().intValue());
						}
						Cell R34cell10 = row34.getCell(16); 
						if (R34cell10 != null) {
							R34cell10.setCellValue(brf68a.getR34_nos4() == null ? 0 : brf68a.getR34_nos4().intValue());
						}
						Cell R34cell11 = row34.getCell(17); 
						if (R34cell11 != null) {
							R34cell11.setCellValue(brf68a.getR34_amount4() == null ? 0 : brf68a.getR34_amount4().intValue());
						}
						Cell R34cell12 = row34.getCell(18); 
						if (R34cell12 != null) {
							R34cell12.setCellValue(brf68a.getR34_nos5() == null ? 0 : brf68a.getR34_nos5().intValue());
						}
						Cell R34cell13 = row34.getCell(19); 
						if (R34cell13 != null) {
							R34cell13.setCellValue(brf68a.getR34_amount5() == null ? 0 : brf68a.getR34_amount5().intValue());
						}
						Cell R34cell14 = row34.getCell(20); 
						if (R34cell14 != null) {
							R34cell14.setCellValue(brf68a.getR34_nos6() == null ? 0 : brf68a.getR34_nos6().intValue());
						}
						Cell R34cell15 = row34.getCell(21); 
						if (R34cell15 != null) {
							R34cell15.setCellValue(brf68a.getR34_amount6() == null ? 0 : brf68a.getR34_amount6().intValue());
						}
						Cell R34cell16 = row34.getCell(22); 
						if (R34cell16 != null) {
							R34cell16.setCellValue(brf68a.getR34_nos7() == null ? 0 : brf68a.getR34_nos7().intValue());
						}
						Cell  R34cell17 = row34.getCell(23); 
						if (R34cell17 != null) {
							R34cell17.setCellValue(brf68a.getR34_amount7() == null ? 0 : brf68a.getR34_amount7().intValue());
						}
						Cell  R34cell18 = row34.getCell(24); 
						if (R34cell18 != null) {
							R34cell18.setCellValue(brf68a.getR34_nos8() == null ? 0 : brf68a.getR34_nos8().intValue());
						}
						Cell  R34cell19 = row34.getCell(25); 
						if (R34cell19 != null) {
							R34cell19.setCellValue(brf68a.getR34_amount8() == null ? 0 : brf68a.getR34_amount8().intValue());
						}
						Cell  R34cell20 = row34.getCell(26); 
						if (R34cell20 != null) {
							R34cell20.setCellValue(brf68a.getR34_nos9() == null ? 0 : brf68a.getR34_nos9().intValue());
						}
						Cell  R34cell21 = row34.getCell(27); 
						if (R34cell21 != null) {
							R34cell21.setCellValue(brf68a.getR34_amount9() == null ? 0 : brf68a.getR34_amount9().intValue());
						}
						Cell R34cell22 = row34.getCell(28); 
						if (R34cell22 != null) {
							R34cell22.setCellValue(brf68a.getR34_nos10() == null ? 0 : brf68a.getR34_nos10().intValue());
						}
						Cell  R34cell23 = row34.getCell(29); 
						if (R34cell23 != null) {
							R34cell23.setCellValue(brf68a.getR34_amount10() == null ? 0 : brf68a.getR34_amount10().intValue());
						}
						Cell R34cell24 = row34.getCell(30); 
						if (R34cell24 != null) {
							R34cell24.setCellValue(brf68a.getR34_nos11() == null ? 0 : brf68a.getR34_nos11().intValue());
						}
						Cell  R34cell25 = row34.getCell(31); 
						if (R34cell25 != null) {
							R34cell25.setCellValue(brf68a.getR34_amount11() == null ? 0 : brf68a.getR34_amount11().intValue());
						}
						Cell  R34cell26 = row34.getCell(32); 
						if (R34cell26 != null) {
							R34cell26.setCellValue(brf68a.getR34_nos12() == null ? 0 : brf68a.getR34_nos12().intValue());
						}
						Cell  R34cell27 = row34.getCell(33); 
						if (R34cell27 != null) {
							R34cell27.setCellValue(brf68a.getR34_amount12() == null ? 0 : brf68a.getR34_amount12().intValue());
						}
						Cell  R34cell28 = row34.getCell(34); 
						if (R34cell28 != null) {
							R34cell28.setCellValue(brf68a.getR34_nos13() == null ? 0 : brf68a.getR34_nos13().intValue());
						}
						Cell  R34cell29 = row34.getCell(35); 
						if (R34cell29 != null) {
							R34cell29.setCellValue(brf68a.getR34_amount13() == null ? 0 : brf68a.getR34_amount13().intValue());
						}
						Cell  R34cell30 = row34.getCell(36); 
						if (R34cell30 != null) {
							R34cell30.setCellValue(brf68a.getR34_nos14() == null ? 0 : brf68a.getR34_nos14().intValue());
						}
						Cell  R34cell31 = row34.getCell(37); 
						if (R34cell31 != null) {
							R34cell31.setCellValue(brf68a.getR34_amount14() == null ? 0 : brf68a.getR34_amount14().intValue());
						}
						
					}
				}
				workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
				FileOutputStream fileOut = new FileOutputStream(
						env.getProperty("output.exportpathfinal") + "011-BRF-068-A.xls");
				workbook.write(fileOut);
				fileOut.close();
				System.out.println(fileOut);
				path = fileOut.toString();
				// Close the workbook
				System.out.println("PATH : " + path);
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

		} //// else end

	}
	outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-068-A.xls");

	return outputFile;

}
	
	public String detailChanges68(BRF68_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF68_DETAIL_ENTITY> Brf68detail = brf68_DetailRepo.findById(foracid);

			if (Brf68detail.isPresent()) {
				BRF68_DETAIL_ENTITY BRFdetail = Brf68detail.get();

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
					brf68_DetailRepo.save(BRFdetail);

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
	public ModelAndView getArchieveBRF068View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF68_Entity1> T1rep = new ArrayList<BRF68_Entity1>();
		// Query<Object[]> qr;

		List<BRF68_Entity1> T1Master = new ArrayList<BRF68_Entity1>();
		
		List<BRF68_Entity2> T1Master1 = new ArrayList<BRF68_Entity2>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF68_Entity1 a where a.report_date = ?1 ", BRF68_Entity1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			T1Master1 = hs.createQuery("from BRF68_Entity2 a where a.report_date = ?1 ", BRF68_Entity2.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF68ARCH");
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



	public ModelAndView ARCHgetBRF068currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF68_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF68_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF68_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF68_ARCHIV_ENTITY> T1Master = new ArrayList<BRF68_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF68_ARCHIV_ENTITY a where a.report_date = ?1", BRF68_ARCHIV_ENTITY.class)
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
		String gender = (String) a[48];
		String nationality = (String) a[49];
		
		
		
		
		String Remarks1;
		if (act_balance_amt_lc  != null) {
			if (act_balance_amt_lc .toString().contains("-")) {
				Remarks1 = "DR";
			} else {
				Remarks1 = "CR";
			}
		} else {
			Remarks1 = "";
		}
		BRF68_ARCHIV_ENTITY py = new BRF68_ARCHIV_ENTITY( cust_id,  foracid,  acct_name,  eab_lc,
			 act_balance_amt_lc,  acct_crncy_code,  gl_code,  gl_sub_head_code,
			 gl_sub_head_desc,  country_of_incorp,  cust_type,  schm_code,  schm_type,
			 sol_id,  acid,  segment,  sub_segment,  sector,  sub_sector,
			 sector_code,  group_id,  constitution_code,  country,  legal_entity_type,
			 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
			 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
			 report_addl_criteria_3,  create_user,  create_time,  modify_user,  modify_time,
			 verify_user,  verify_time,  entity_flg,  modify_flg,  del_flg,
			 nre_status,  report_date,  maturity_date,  version,  remarks,  gender,nationality);
		
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
	mv.setViewName("RR" + "/" + "BRF68ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
	}

	}


