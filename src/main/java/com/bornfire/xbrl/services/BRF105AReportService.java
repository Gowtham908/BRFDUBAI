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

import com.bornfire.xbrl.entities.BRF105_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF093AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF105AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF105_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF105_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF181AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF105_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF105_ENTITY2;
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
public class BRF105AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF73ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF73ServiceRepo brf73ServiceRepo;
	
	@Autowired
	BRF093AServiceRepo brf093aServiceRepo;
	
	@Autowired
	BRF181AServiceRepo brf181aServiceRepo;
	
	@Autowired
	BRF105AServiceRepo brf105aServiceRepo;
	
	@Autowired
	BRF105_DetailRepo brf105_detailrepo;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF105A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF105_ENTITY2 a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF105_ENTITY2 a ").getSingleResult();
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


	public ModelAndView getBRF105AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF105_ENTITY1> T1rep = new ArrayList<BRF105_ENTITY1>();
			// Query<Object[]> qr;

			List<BRF105_ENTITY1> T1Master = new ArrayList<BRF105_ENTITY1>();
			List<BRF105_ENTITY2> T1Master1 = new ArrayList<BRF105_ENTITY2>();
			
			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from BRF105_ENTITY1 a where a.report_date = ?1 ",BRF105_ENTITY1.class)
						.setParameter(1, df.parse(todate)).getResultList();

				T1Master1 = hs.createQuery("from BRF105_ENTITY2 a where a.report_date = ?1 ", BRF105_ENTITY2.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
			
			} catch (ParseException e)
			{			
				e.printStackTrace();
				}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF105A");
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
	public ModelAndView getBRF105ADetails(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF105_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");
				qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF105_DETAILTABLE a where report_date = ?1");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF105_DETAILTABLE  where report_date = ?1");
		}
		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF105_DETAIL_ENTITY> T1Master = new ArrayList<BRF105_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF105_DETAIL_ENTITY a where a.report_date = ?1", BRF105_DETAIL_ENTITY.class)
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
			String sector = (String) a[17];
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

			BRF105_DETAIL_ENTITY py = new BRF105_DETAIL_ENTITY( cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
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

		mv.setViewName("RR"+"/"+"BRF105A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}


	
		public File getFileBRF105A(String reportId, String fromdate, String todate, String currency, String dtltype,
				String filetype) throws FileNotFoundException, JRException, SQLException {
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			String path = this.env.getProperty("output.exportpath");
			String fileName = "";
			String zipFileName = "";
			File outputFile;

			logger.info("Getting Output file :" + reportId);
			fileName = "011-BRF-105-A";

			if (!filetype.equals("xbrl")) {
				if(!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF105_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF105_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_105_A.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF_105_A.jrxml");
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
				List<BRF105_ENTITY1> T1Master = new ArrayList<>();
				List<BRF105_ENTITY2> T1Master1 = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from BRF105_ENTITY1 a where a.report_date = ?1", BRF105_ENTITY1.class)
							.setParameter(1, df.parse(todate)).getResultList();
					T1Master1 = hs.createQuery("from BRF105_ENTITY2 a where a.report_date = ?1", BRF105_ENTITY2.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-105-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					
					Sheet sheet = workbook.getSheetAt(0);
					
					if (T1Master.size() == 1) {
						for (BRF105_ENTITY1 brf105 : T1Master) {
							Row row3 = sheet.getRow(11);
							Cell R3cell1 = row3.getCell(3); 
							if (R3cell1 != null) {
								R3cell1.setCellValue(brf105.getR3_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR3_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R3cell2 = row3.getCell(4); 
							if (R3cell2 != null) {
								R3cell2.setCellValue(brf105.getR3_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR3_CRWA_CONSOLIDATED().intValue());
							}
							Cell R3cell3 = row3.getCell(5); 
							if (R3cell3 != null) {
								R3cell3.setCellValue(brf105.getR3_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR3_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R3cell4 = row3.getCell(6); 
							if (R3cell4 != null) {
								R3cell4.setCellValue(brf105.getR3_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR3_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R3cell5 = row3.getCell(7); 
							if (R3cell5 != null) {
								R3cell5.setCellValue(brf105.getR3_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR3_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R3cell6 = row3.getCell(8); 
							if (R3cell6 != null) {
								R3cell6.setCellValue(brf105.getR3_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR3_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R3cell7 = row3.getCell(9); 
							if (R3cell7 != null) {
								R3cell7.setCellValue(brf105.getR3_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR3_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R3cell8 = row3.getCell(10); 
							if (R3cell8 != null) {
								R3cell8.setCellValue(brf105.getR3_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR3_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R3cell9 = row3.getCell(11); 
							if (R3cell9 != null) {
								R3cell9.setCellValue(brf105.getR3_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR3_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R3cell10 = row3.getCell(12); 
							if (R3cell10 != null) {
								R3cell10.setCellValue(brf105.getR3_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR3_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R3cell11 = row3.getCell(13); 
							if (R3cell11 != null) {
								R3cell11.setCellValue(brf105.getR3_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR3_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R3cell12 = row3.getCell(14); 
							if (R3cell12 != null) {
								R3cell12.setCellValue(brf105.getR3_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR3_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R3cell13 = row3.getCell(15); 
							if (R3cell13 != null) {
								R3cell13.setCellValue(brf105.getR3_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR3_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R3cell14 = row3.getCell(16); 
							if (R3cell14 != null) {
								R3cell14.setCellValue(brf105.getR3_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR3_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R3cell15 = row3.getCell(17); 
							if (R3cell15 != null) {
								R3cell15.setCellValue(brf105.getR3_NON_PERFORMING() == null ? 0 : brf105.getR3_NON_PERFORMING().intValue());
							}
							Cell R3cell16 = row3.getCell(18); 
							if (R3cell16 != null) {
								R3cell16.setCellValue(brf105.getR3_SPECIFIC_PROVISION() == null ? 0 : brf105.getR3_SPECIFIC_PROVISION().intValue());
							}
							Cell  R3cell17 = row3.getCell(19); 
							if (R3cell17 != null) {
								R3cell17.setCellValue(brf105.getR3_INTEREST() == null ? 0 : brf105.getR3_INTEREST().intValue());
							}
							Cell  R3cell18 = row3.getCell(20); 
							if (R3cell18 != null) {
								R3cell18.setCellValue(brf105.getR3_DEFAULTED() == null ? 0 : brf105.getR3_DEFAULTED().intValue());
							}
							Row row4 = sheet.getRow(12);
							Cell R4cell1 = row4.getCell(3); 
							if (R4cell1 != null) {
								R4cell1.setCellValue(brf105.getR4_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR4_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R4cell2 = row4.getCell(4); 
							if (R4cell2 != null) {
								R4cell2.setCellValue(brf105.getR4_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR4_CRWA_CONSOLIDATED().intValue());
							}
							Cell R4cell3 = row4.getCell(5); 
							if (R4cell3 != null) {
								R4cell3.setCellValue(brf105.getR4_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR4_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R4cell4 = row4.getCell(6); 
							if (R4cell4 != null) {
								R4cell4.setCellValue(brf105.getR4_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR4_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R4cell5 = row4.getCell(7); 
							if (R4cell5 != null) {
								R4cell5.setCellValue(brf105.getR4_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR4_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R4cell6 = row4.getCell(8); 
							if (R4cell6 != null) {
								R4cell6.setCellValue(brf105.getR4_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR4_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R4cell7 = row4.getCell(9); 
							if (R4cell7 != null) {
								R4cell7.setCellValue(brf105.getR4_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR4_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R4cell8 = row4.getCell(10); 
							if (R4cell8 != null) {
								R4cell8.setCellValue(brf105.getR4_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR4_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R4cell9 = row4.getCell(11); 
							if (R4cell9 != null) {
								R4cell9.setCellValue(brf105.getR4_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR4_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R4cell10 = row4.getCell(12); 
							if (R4cell10 != null) {
								R4cell10.setCellValue(brf105.getR4_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR4_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R4cell11 = row4.getCell(13); 
							if (R4cell11 != null) {
								R4cell11.setCellValue(brf105.getR4_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR4_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R4cell12 = row4.getCell(14); 
							if (R4cell12 != null) {
								R4cell12.setCellValue(brf105.getR4_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR4_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R4cell13 = row4.getCell(15); 
							if (R4cell13 != null) {
								R4cell13.setCellValue(brf105.getR4_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR4_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R4cell14 = row4.getCell(16); 
							if (R4cell14 != null) {
								R4cell14.setCellValue(brf105.getR4_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR4_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R4cell15 = row4.getCell(17); 
							if (R4cell15 != null) {
								R4cell15.setCellValue(brf105.getR4_NON_PERFORMING() == null ? 0 : brf105.getR4_NON_PERFORMING().intValue());
							}
							Cell R4cell16 = row4.getCell(18); 
							if (R4cell16 != null) {
								R4cell16.setCellValue(brf105.getR4_SPECIFIC_PROVISION() == null ? 0 : brf105.getR4_SPECIFIC_PROVISION().intValue());
							}
							Cell  R4cell17 = row4.getCell(19); 
							if (R4cell17 != null) {
								R4cell17.setCellValue(brf105.getR4_INTEREST() == null ? 0 : brf105.getR4_INTEREST().intValue());
							}
							Cell  R4cell18 = row4.getCell(20); 
							if (R4cell18 != null) {
								R4cell18.setCellValue(brf105.getR4_DEFAULTED() == null ? 0 : brf105.getR4_DEFAULTED().intValue());
							}
							Row row5 = sheet.getRow(13);
							Cell R5cell1 = row5.getCell(3); 
							if (R5cell1 != null) {
								R5cell1.setCellValue(brf105.getR5_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR5_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R5cell2 = row5.getCell(4); 
							if (R5cell2 != null) {
								R5cell2.setCellValue(brf105.getR5_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR5_CRWA_CONSOLIDATED().intValue());
							}
							Cell R5cell3 = row5.getCell(5); 
							if (R5cell3 != null) {
								R5cell3.setCellValue(brf105.getR5_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR5_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R5cell4 = row5.getCell(6); 
							if (R5cell4 != null) {
								R5cell4.setCellValue(brf105.getR5_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR5_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R5cell5 = row5.getCell(7); 
							if (R5cell5 != null) {
								R5cell5.setCellValue(brf105.getR5_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR5_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R5cell6 = row5.getCell(8); 
							if (R5cell6 != null) {
								R5cell6.setCellValue(brf105.getR5_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR5_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R5cell7 = row5.getCell(9); 
							if (R5cell7 != null) {
								R5cell7.setCellValue(brf105.getR5_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR5_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R5cell8 = row5.getCell(10); 
							if (R5cell8 != null) {
								R5cell8.setCellValue(brf105.getR5_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR5_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R5cell9 = row5.getCell(11); 
							if (R5cell9 != null) {
								R5cell9.setCellValue(brf105.getR5_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR5_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R5cell10 = row5.getCell(12); 
							if (R5cell10 != null) {
								R5cell10.setCellValue(brf105.getR5_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR5_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R5cell11 = row5.getCell(13); 
							if (R5cell11 != null) {
								R5cell11.setCellValue(brf105.getR5_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR5_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R5cell12 = row5.getCell(14); 
							if (R5cell12 != null) {
								R5cell12.setCellValue(brf105.getR5_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR5_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R5cell13 = row5.getCell(15); 
							if (R5cell13 != null) {
								R5cell13.setCellValue(brf105.getR5_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR5_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R5cell14 = row5.getCell(16); 
							if (R5cell14 != null) {
								R5cell14.setCellValue(brf105.getR5_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR5_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R5cell15 = row5.getCell(17); 
							if (R5cell15 != null) {
								R5cell15.setCellValue(brf105.getR5_NON_PERFORMING() == null ? 0 : brf105.getR5_NON_PERFORMING().intValue());
							}
							Cell R5cell16 = row5.getCell(18); 
							if (R5cell16 != null) {
								R5cell16.setCellValue(brf105.getR5_SPECIFIC_PROVISION() == null ? 0 : brf105.getR5_SPECIFIC_PROVISION().intValue());
							}
							Cell  R5cell17 = row5.getCell(19); 
							if (R5cell17 != null) {
								R5cell17.setCellValue(brf105.getR5_INTEREST() == null ? 0 : brf105.getR5_INTEREST().intValue());
							}
							Cell  R5cell18 = row5.getCell(20); 
							if (R5cell18 != null) {
								R5cell18.setCellValue(brf105.getR5_DEFAULTED() == null ? 0 : brf105.getR5_DEFAULTED().intValue());
							}
							Row row7 = sheet.getRow(15);
							Cell R7cell1 = row7.getCell(3); 
							if (R7cell1 != null) {
								R7cell1.setCellValue(brf105.getR7_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR7_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R7cell2 = row7.getCell(4); 
							if (R7cell2 != null) {
								R7cell2.setCellValue(brf105.getR7_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR7_CRWA_CONSOLIDATED().intValue());
							}
							Cell R7cell3 = row7.getCell(5); 
							if (R7cell3 != null) {
								R7cell3.setCellValue(brf105.getR7_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR7_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R7cell4 = row7.getCell(6); 
							if (R7cell4 != null) {
								R7cell4.setCellValue(brf105.getR7_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR7_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R7cell5 = row7.getCell(7); 
							if (R7cell5 != null) {
								R7cell5.setCellValue(brf105.getR7_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR7_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R7cell6 = row7.getCell(8); 
							if (R7cell6 != null) {
								R7cell6.setCellValue(brf105.getR7_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR7_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R7cell7 = row7.getCell(9); 
							if (R7cell7 != null) {
								R7cell7.setCellValue(brf105.getR7_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR7_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R7cell8 = row7.getCell(10); 
							if (R7cell8 != null) {
								R7cell8.setCellValue(brf105.getR7_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR7_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R7cell9 = row7.getCell(11); 
							if (R7cell9 != null) {
								R7cell9.setCellValue(brf105.getR7_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR7_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R7cell10 = row7.getCell(12); 
							if (R7cell10 != null) {
								R7cell10.setCellValue(brf105.getR7_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR7_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R7cell11 = row7.getCell(13); 
							if (R7cell11 != null) {
								R7cell11.setCellValue(brf105.getR7_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR7_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R7cell12 = row7.getCell(14); 
							if (R7cell12 != null) {
								R7cell12.setCellValue(brf105.getR7_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR7_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R7cell13 = row7.getCell(15); 
							if (R7cell13 != null) {
								R7cell13.setCellValue(brf105.getR7_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR7_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R7cell14 = row7.getCell(16); 
							if (R7cell14 != null) {
								R7cell14.setCellValue(brf105.getR7_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR7_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R7cell15 = row7.getCell(17); 
							if (R7cell15 != null) {
								R7cell15.setCellValue(brf105.getR7_NON_PERFORMING() == null ? 0 : brf105.getR7_NON_PERFORMING().intValue());
							}
							Cell R7cell16 = row7.getCell(18); 
							if (R7cell16 != null) {
								R7cell16.setCellValue(brf105.getR7_SPECIFIC_PROVISION() == null ? 0 : brf105.getR7_SPECIFIC_PROVISION().intValue());
							}
							Cell  R7cell17 = row7.getCell(19); 
							if (R7cell17 != null) {
								R7cell17.setCellValue(brf105.getR7_INTEREST() == null ? 0 : brf105.getR7_INTEREST().intValue());
							}
							Cell  R7cell18 = row7.getCell(20); 
							if (R7cell18 != null) {
								R7cell18.setCellValue(brf105.getR7_DEFAULTED() == null ? 0 : brf105.getR7_DEFAULTED().intValue());
							}
							Row row8 = sheet.getRow(16);
							Cell R8cell1 = row8.getCell(3); 
							if (R8cell1 != null) {
								R8cell1.setCellValue(brf105.getR8_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR8_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R8cell2 = row8.getCell(4); 
							if (R8cell2 != null) {
								R8cell2.setCellValue(brf105.getR8_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR8_CRWA_CONSOLIDATED().intValue());
							}
							Cell R8cell3 = row8.getCell(5); 
							if (R8cell3 != null) {
								R8cell3.setCellValue(brf105.getR8_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR8_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R8cell4 = row8.getCell(6); 
							if (R8cell4 != null) {
								R8cell4.setCellValue(brf105.getR8_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR8_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R8cell5 = row8.getCell(7); 
							if (R8cell5 != null) {
								R8cell5.setCellValue(brf105.getR8_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR8_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R8cell6 = row8.getCell(8); 
							if (R8cell6 != null) {
								R8cell6.setCellValue(brf105.getR8_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR8_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R8cell7 = row8.getCell(9); 
							if (R8cell7 != null) {
								R8cell7.setCellValue(brf105.getR8_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR8_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R8cell8 = row8.getCell(10); 
							if (R8cell8 != null) {
								R8cell8.setCellValue(brf105.getR8_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR8_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R8cell9 = row8.getCell(11); 
							if (R8cell9 != null) {
								R8cell9.setCellValue(brf105.getR8_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR8_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R8cell10 = row8.getCell(12); 
							if (R8cell10 != null) {
								R8cell10.setCellValue(brf105.getR8_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR8_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R8cell11 = row8.getCell(13); 
							if (R8cell11 != null) {
								R8cell11.setCellValue(brf105.getR8_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR8_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R8cell12 = row8.getCell(14); 
							if (R8cell12 != null) {
								R8cell12.setCellValue(brf105.getR8_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR8_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R8cell13 = row8.getCell(15); 
							if (R8cell13 != null) {
								R8cell13.setCellValue(brf105.getR8_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR8_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R8cell14 = row8.getCell(16); 
							if (R8cell14 != null) {
								R8cell14.setCellValue(brf105.getR8_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR8_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R8cell15 = row8.getCell(17); 
							if (R8cell15 != null) {
								R8cell15.setCellValue(brf105.getR8_NON_PERFORMING() == null ? 0 : brf105.getR8_NON_PERFORMING().intValue());
							}
							Cell R8cell16 = row8.getCell(18); 
							if (R8cell16 != null) {
								R8cell16.setCellValue(brf105.getR8_SPECIFIC_PROVISION() == null ? 0 : brf105.getR8_SPECIFIC_PROVISION().intValue());
							}
							Cell  R8cell17 = row8.getCell(19); 
							if (R8cell17 != null) {
								R8cell17.setCellValue(brf105.getR8_INTEREST() == null ? 0 : brf105.getR8_INTEREST().intValue());
							}
							Cell  R8cell18 = row8.getCell(20); 
							if (R8cell18 != null) {
								R8cell18.setCellValue(brf105.getR8_DEFAULTED() == null ? 0 : brf105.getR8_DEFAULTED().intValue());
							}
							Row row9 = sheet.getRow(17);
							Cell R9cell1 = row9.getCell(3); 
							if (R9cell1 != null) {
								R9cell1.setCellValue(brf105.getR9_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR9_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R9cell2 = row9.getCell(4); 
							if (R9cell2 != null) {
								R9cell2.setCellValue(brf105.getR9_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR9_CRWA_CONSOLIDATED().intValue());
							}
							Cell R9cell3 = row9.getCell(5); 
							if (R9cell3 != null) {
								R9cell3.setCellValue(brf105.getR9_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR9_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R9cell4 = row9.getCell(6); 
							if (R9cell4 != null) {
								R9cell4.setCellValue(brf105.getR9_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR9_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R9cell5 = row9.getCell(7); 
							if (R9cell5 != null) {
								R9cell5.setCellValue(brf105.getR9_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR9_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R9cell6 = row9.getCell(8); 
							if (R9cell6 != null) {
								R9cell6.setCellValue(brf105.getR9_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR9_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R9cell7 = row9.getCell(9); 
							if (R9cell7 != null) {
								R9cell7.setCellValue(brf105.getR9_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR9_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R9cell8 = row9.getCell(10); 
							if (R9cell8 != null) {
								R9cell8.setCellValue(brf105.getR9_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR9_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R9cell9 = row9.getCell(11); 
							if (R9cell9 != null) {
								R9cell9.setCellValue(brf105.getR9_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR9_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R9cell10 = row9.getCell(12); 
							if (R9cell10 != null) {
								R9cell10.setCellValue(brf105.getR9_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR9_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R9cell11 = row9.getCell(13); 
							if (R9cell11 != null) {
								R9cell11.setCellValue(brf105.getR9_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR9_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R9cell12 = row9.getCell(14); 
							if (R9cell12 != null) {
								R9cell12.setCellValue(brf105.getR9_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR9_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R9cell13 = row9.getCell(15); 
							if (R9cell13 != null) {
								R9cell13.setCellValue(brf105.getR9_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR9_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R9cell14 = row9.getCell(16); 
							if (R9cell14 != null) {
								R9cell14.setCellValue(brf105.getR9_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR9_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R9cell15 = row9.getCell(17); 
							if (R9cell15 != null) {
								R9cell15.setCellValue(brf105.getR9_NON_PERFORMING() == null ? 0 : brf105.getR9_NON_PERFORMING().intValue());
							}
							Cell R9cell16 = row9.getCell(18); 
							if (R9cell16 != null) {
								R9cell16.setCellValue(brf105.getR9_SPECIFIC_PROVISION() == null ? 0 : brf105.getR9_SPECIFIC_PROVISION().intValue());
							}
							Cell  R9cell17 = row9.getCell(19); 
							if (R9cell17 != null) {
								R9cell17.setCellValue(brf105.getR9_INTEREST() == null ? 0 : brf105.getR9_INTEREST().intValue());
							}
							Cell  R9cell18 = row9.getCell(20); 
							if (R9cell18 != null) {
								R9cell18.setCellValue(brf105.getR9_DEFAULTED() == null ? 0 : brf105.getR9_DEFAULTED().intValue());
							}
							Row row12 = sheet.getRow(20);
							Cell R12cell1 = row12.getCell(3); 
							if (R12cell1 != null) {
								R12cell1.setCellValue(brf105.getR12_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR12_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R12cell2 = row12.getCell(4); 
							if (R12cell2 != null) {
								R12cell2.setCellValue(brf105.getR12_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR12_CRWA_CONSOLIDATED().intValue());
							}
							Cell R12cell3 = row12.getCell(5); 
							if (R12cell3 != null) {
								R12cell3.setCellValue(brf105.getR12_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR12_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R12cell4 = row12.getCell(6); 
							if (R12cell4 != null) {
								R12cell4.setCellValue(brf105.getR12_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR12_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R12cell5 = row12.getCell(7); 
							if (R12cell5 != null) {
								R12cell5.setCellValue(brf105.getR12_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR12_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R12cell6 = row12.getCell(8); 
							if (R12cell6 != null) {
								R12cell6.setCellValue(brf105.getR12_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR12_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R12cell7 = row12.getCell(9); 
							if (R12cell7 != null) {
								R12cell7.setCellValue(brf105.getR12_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR12_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R12cell8 = row12.getCell(10); 
							if (R12cell8 != null) {
								R12cell8.setCellValue(brf105.getR12_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR12_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R12cell9 = row12.getCell(11); 
							if (R12cell9 != null) {
								R12cell9.setCellValue(brf105.getR12_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR12_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R12cell10 = row12.getCell(12); 
							if (R12cell10 != null) {
								R12cell10.setCellValue(brf105.getR12_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR12_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R12cell11 = row12.getCell(13); 
							if (R12cell11 != null) {
								R12cell11.setCellValue(brf105.getR12_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR12_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R12cell12 = row12.getCell(14); 
							if (R12cell12 != null) {
								R12cell12.setCellValue(brf105.getR12_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR12_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R12cell13 = row12.getCell(15); 
							if (R12cell13 != null) {
								R12cell13.setCellValue(brf105.getR12_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR12_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R12cell14 = row12.getCell(16); 
							if (R12cell14 != null) {
								R12cell14.setCellValue(brf105.getR12_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR12_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R12cell15 = row12.getCell(17); 
							if (R12cell15 != null) {
								R12cell15.setCellValue(brf105.getR12_NON_PERFORMING() == null ? 0 : brf105.getR12_NON_PERFORMING().intValue());
							}
							Cell R12cell16 = row12.getCell(18); 
							if (R12cell16 != null) {
								R12cell16.setCellValue(brf105.getR12_SPECIFIC_PROVISION() == null ? 0 : brf105.getR12_SPECIFIC_PROVISION().intValue());
							}
							Cell  R12cell17 = row12.getCell(19); 
							if (R12cell17 != null) {
								R12cell17.setCellValue(brf105.getR12_INTEREST() == null ? 0 : brf105.getR12_INTEREST().intValue());
							}
							Cell  R12cell18 = row12.getCell(20); 
							if (R12cell18 != null) {
								R12cell18.setCellValue(brf105.getR12_DEFAULTED() == null ? 0 : brf105.getR12_DEFAULTED().intValue());
							}
                            Row row13 = sheet.getRow(21);
                            Cell R13cell1 = row13.getCell(3); 
							if (R13cell1 != null) {
								R13cell1.setCellValue(brf105.getR13_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR13_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R13cell2 = row13.getCell(4); 
							if (R13cell2 != null) {
								R13cell2.setCellValue(brf105.getR13_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR13_CRWA_CONSOLIDATED().intValue());
							}
							Cell R13cell3 = row13.getCell(5); 
							if (R13cell3 != null) {
								R13cell3.setCellValue(brf105.getR13_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR13_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R13cell4 = row13.getCell(6); 
							if (R13cell4 != null) {
								R13cell4.setCellValue(brf105.getR13_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR13_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R13cell5 = row13.getCell(7); 
							if (R13cell5 != null) {
								R13cell5.setCellValue(brf105.getR13_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR13_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R13cell6 = row13.getCell(8); 
							if (R13cell6 != null) {
								R13cell6.setCellValue(brf105.getR13_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR13_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R13cell7 = row13.getCell(9); 
							if (R13cell7 != null) {
								R13cell7.setCellValue(brf105.getR13_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR13_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R13cell8 = row13.getCell(10); 
							if (R13cell8 != null) {
								R13cell8.setCellValue(brf105.getR13_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR13_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R13cell9 = row13.getCell(11); 
							if (R13cell9 != null) {
								R13cell9.setCellValue(brf105.getR13_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR13_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R13cell10 = row13.getCell(12); 
							if (R13cell10 != null) {
								R13cell10.setCellValue(brf105.getR13_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR13_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R13cell11 = row13.getCell(13); 
							if (R13cell11 != null) {
								R13cell11.setCellValue(brf105.getR13_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR13_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R13cell12 = row13.getCell(14); 
							if (R13cell12 != null) {
								R13cell12.setCellValue(brf105.getR13_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR13_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R13cell13 = row13.getCell(15); 
							if (R13cell13 != null) {
								R13cell13.setCellValue(brf105.getR13_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR13_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R13cell14 = row13.getCell(16); 
							if (R13cell14 != null) {
								R13cell14.setCellValue(brf105.getR13_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR13_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R13cell15 = row13.getCell(17); 
							if (R13cell15 != null) {
								R13cell15.setCellValue(brf105.getR13_NON_PERFORMING() == null ? 0 : brf105.getR13_NON_PERFORMING().intValue());
							}
							Cell R13cell16 = row13.getCell(18); 
							if (R13cell16 != null) {
								R13cell16.setCellValue(brf105.getR13_SPECIFIC_PROVISION() == null ? 0 : brf105.getR13_SPECIFIC_PROVISION().intValue());
							}
							Cell  R13cell17 = row13.getCell(19); 
							if (R13cell17 != null) {
								R13cell17.setCellValue(brf105.getR13_INTEREST() == null ? 0 : brf105.getR13_INTEREST().intValue());
							}
							Cell  R13cell18 = row13.getCell(20); 
							if (R13cell18 != null) {
								R13cell18.setCellValue(brf105.getR13_DEFAULTED() == null ? 0 : brf105.getR13_DEFAULTED().intValue());
							}
							Row row14 = sheet.getRow(22);
							Cell R14cell1 = row14.getCell(3); 
							if (R14cell1 != null) {
								R14cell1.setCellValue(brf105.getR14_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR14_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R14cell2 = row14.getCell(4); 
							if (R14cell2 != null) {
								R14cell2.setCellValue(brf105.getR14_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR14_CRWA_CONSOLIDATED().intValue());
							}
							Cell R14cell3 = row14.getCell(5); 
							if (R14cell3 != null) {
								R14cell3.setCellValue(brf105.getR14_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR14_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R14cell4 = row14.getCell(6); 
							if (R14cell4 != null) {
								R14cell4.setCellValue(brf105.getR14_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR14_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R14cell5 = row14.getCell(7); 
							if (R14cell5 != null) {
								R14cell5.setCellValue(brf105.getR14_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR14_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R14cell6 = row14.getCell(8); 
							if (R14cell6 != null) {
								R14cell6.setCellValue(brf105.getR14_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR14_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R14cell7 = row14.getCell(9); 
							if (R14cell7 != null) {
								R14cell7.setCellValue(brf105.getR14_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR14_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R14cell8 = row14.getCell(10); 
							if (R14cell8 != null) {
								R14cell8.setCellValue(brf105.getR14_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR14_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R14cell9 = row14.getCell(11); 
							if (R14cell9 != null) {
								R14cell9.setCellValue(brf105.getR14_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR14_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R14cell10 = row14.getCell(12); 
							if (R14cell10 != null) {
								R14cell10.setCellValue(brf105.getR14_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR14_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R14cell11 = row14.getCell(13); 
							if (R14cell11 != null) {
								R14cell11.setCellValue(brf105.getR14_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR14_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R14cell12 = row14.getCell(14); 
							if (R14cell12 != null) {
								R14cell12.setCellValue(brf105.getR14_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR14_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R14cell13 = row14.getCell(15); 
							if (R14cell13 != null) {
								R14cell13.setCellValue(brf105.getR14_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR14_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R14cell14 = row14.getCell(16); 
							if (R14cell14 != null) {
								R14cell14.setCellValue(brf105.getR14_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR14_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R14cell15 = row14.getCell(17); 
							if (R14cell15 != null) {
								R14cell15.setCellValue(brf105.getR14_NON_PERFORMING() == null ? 0 : brf105.getR14_NON_PERFORMING().intValue());
							}
							Cell R14cell16 = row14.getCell(18); 
							if (R14cell16 != null) {
								R14cell16.setCellValue(brf105.getR14_SPECIFIC_PROVISION() == null ? 0 : brf105.getR14_SPECIFIC_PROVISION().intValue());
							}
							Cell  R14cell17 = row14.getCell(19); 
							if (R14cell17 != null) {
								R14cell17.setCellValue(brf105.getR14_INTEREST() == null ? 0 : brf105.getR14_INTEREST().intValue());
							}
							Cell  R14cell18 = row14.getCell(20); 
							if (R14cell18 != null) {
								R14cell18.setCellValue(brf105.getR14_DEFAULTED() == null ? 0 : brf105.getR14_DEFAULTED().intValue());
							}
							Row row15 = sheet.getRow(23);
							Cell R15cell1 = row15.getCell(3); 
							if (R15cell1 != null) {
								R15cell1.setCellValue(brf105.getR15_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR15_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R15cell2 = row15.getCell(4); 
							if (R15cell2 != null) {
								R15cell2.setCellValue(brf105.getR15_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR15_CRWA_CONSOLIDATED().intValue());
							}
							Cell R15cell3 = row15.getCell(5); 
							if (R15cell3 != null) {
								R15cell3.setCellValue(brf105.getR15_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR15_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R15cell4 = row15.getCell(6); 
							if (R15cell4 != null) {
								R15cell4.setCellValue(brf105.getR15_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR15_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R15cell5 = row15.getCell(7); 
							if (R15cell5 != null) {
								R15cell5.setCellValue(brf105.getR15_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR15_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R15cell6 = row15.getCell(8); 
							if (R15cell6 != null) {
								R15cell6.setCellValue(brf105.getR15_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR15_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R15cell7 = row15.getCell(9); 
							if (R15cell7 != null) {
								R15cell7.setCellValue(brf105.getR15_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR15_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R15cell8 = row15.getCell(10); 
							if (R15cell8 != null) {
								R15cell8.setCellValue(brf105.getR15_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR15_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R15cell9 = row15.getCell(11); 
							if (R15cell9 != null) {
								R15cell9.setCellValue(brf105.getR15_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR15_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R15cell10 = row15.getCell(12); 
							if (R15cell10 != null) {
								R15cell10.setCellValue(brf105.getR15_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR15_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R15cell11 = row15.getCell(13); 
							if (R15cell11 != null) {
								R15cell11.setCellValue(brf105.getR15_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR15_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R15cell12 = row15.getCell(14); 
							if (R15cell12 != null) {
								R15cell12.setCellValue(brf105.getR15_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR15_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R15cell13 = row15.getCell(15); 
							if (R15cell13 != null) {
								R15cell13.setCellValue(brf105.getR15_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR15_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R15cell14 = row15.getCell(16); 
							if (R15cell14 != null) {
								R15cell14.setCellValue(brf105.getR15_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR15_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R15cell15 = row15.getCell(17); 
							if (R15cell15 != null) {
								R15cell15.setCellValue(brf105.getR15_NON_PERFORMING() == null ? 0 : brf105.getR15_NON_PERFORMING().intValue());
							}
							Cell R15cell16 = row15.getCell(18); 
							if (R15cell16 != null) {
								R15cell16.setCellValue(brf105.getR15_SPECIFIC_PROVISION() == null ? 0 : brf105.getR15_SPECIFIC_PROVISION().intValue());
							}
							Cell  R15cell17 = row15.getCell(19); 
							if (R15cell17 != null) {
								R15cell17.setCellValue(brf105.getR15_INTEREST() == null ? 0 : brf105.getR15_INTEREST().intValue());
							}
							Cell  R15cell18 = row15.getCell(20); 
							if (R15cell18 != null) {
								R15cell18.setCellValue(brf105.getR15_DEFAULTED() == null ? 0 : brf105.getR15_DEFAULTED().intValue());
							}
							Row row16 = sheet.getRow(24);
							Cell R16cell1 = row16.getCell(3); 
							if (R16cell1 != null) {
								R16cell1.setCellValue(brf105.getR16_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR16_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R16cell2 = row16.getCell(4); 
							if (R16cell2 != null) {
								R16cell2.setCellValue(brf105.getR16_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR16_CRWA_CONSOLIDATED().intValue());
							}
							Cell R16cell3 = row16.getCell(5); 
							if (R16cell3 != null) {
								R16cell3.setCellValue(brf105.getR16_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR16_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R16cell4 = row16.getCell(6); 
							if (R16cell4 != null) {
								R16cell4.setCellValue(brf105.getR16_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR16_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R16cell5 = row16.getCell(7); 
							if (R16cell5 != null) {
								R16cell5.setCellValue(brf105.getR16_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR16_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R16cell6 = row16.getCell(8); 
							if (R16cell6 != null) {
								R16cell6.setCellValue(brf105.getR16_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR16_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R16cell7 = row16.getCell(9); 
							if (R16cell7 != null) {
								R16cell7.setCellValue(brf105.getR16_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR16_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R16cell8 = row16.getCell(10); 
							if (R16cell8 != null) {
								R16cell8.setCellValue(brf105.getR16_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR16_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R16cell9 = row16.getCell(11); 
							if (R16cell9 != null) {
								R16cell9.setCellValue(brf105.getR16_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR16_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R16cell10 = row16.getCell(12); 
							if (R16cell10 != null) {
								R16cell10.setCellValue(brf105.getR16_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR16_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R16cell11 = row16.getCell(13); 
							if (R16cell11 != null) {
								R16cell11.setCellValue(brf105.getR16_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR16_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R16cell12 = row16.getCell(14); 
							if (R16cell12 != null) {
								R16cell12.setCellValue(brf105.getR16_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR16_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R16cell13 = row16.getCell(15); 
							if (R16cell13 != null) {
								R16cell13.setCellValue(brf105.getR16_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR16_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R16cell14 = row16.getCell(16); 
							if (R16cell14 != null) {
								R16cell14.setCellValue(brf105.getR16_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR16_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R16cell15 = row16.getCell(17); 
							if (R16cell15 != null) {
								R16cell15.setCellValue(brf105.getR16_NON_PERFORMING() == null ? 0 : brf105.getR16_NON_PERFORMING().intValue());
							}
							Cell R16cell16 = row16.getCell(18); 
							if (R16cell16 != null) {
								R16cell16.setCellValue(brf105.getR16_SPECIFIC_PROVISION() == null ? 0 : brf105.getR16_SPECIFIC_PROVISION().intValue());
							}
							Cell  R16cell17 = row16.getCell(19); 
							if (R16cell17 != null) {
								R16cell17.setCellValue(brf105.getR16_INTEREST() == null ? 0 : brf105.getR16_INTEREST().intValue());
							}
							Cell  R16cell18 = row16.getCell(20); 
							if (R16cell18 != null) {
								R16cell18.setCellValue(brf105.getR16_DEFAULTED() == null ? 0 : brf105.getR16_DEFAULTED().intValue());
							}
							Row row17 = sheet.getRow(25);
							Cell R17cell1 = row17.getCell(3); 
							if (R17cell1 != null) {
								R17cell1.setCellValue(brf105.getR17_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR17_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R17cell2 = row17.getCell(4); 
							if (R17cell2 != null) {
								R17cell2.setCellValue(brf105.getR17_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR17_CRWA_CONSOLIDATED().intValue());
							}
							Cell R17cell3 = row17.getCell(5); 
							if (R17cell3 != null) {
								R17cell3.setCellValue(brf105.getR17_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR17_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R17cell4 = row17.getCell(6); 
							if (R17cell4 != null) {
								R17cell4.setCellValue(brf105.getR17_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR17_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R17cell5 = row17.getCell(7); 
							if (R17cell5 != null) {
								R17cell5.setCellValue(brf105.getR17_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR17_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R17cell6 = row17.getCell(8); 
							if (R17cell6 != null) {
								R17cell6.setCellValue(brf105.getR17_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR17_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R17cell7 = row17.getCell(9); 
							if (R17cell7 != null) {
								R17cell7.setCellValue(brf105.getR17_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR17_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R17cell8 = row17.getCell(10); 
							if (R17cell8 != null) {
								R17cell8.setCellValue(brf105.getR17_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR17_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R17cell9 = row17.getCell(11); 
							if (R17cell9 != null) {
								R17cell9.setCellValue(brf105.getR17_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR17_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R17cell10 = row17.getCell(12); 
							if (R17cell10 != null) {
								R17cell10.setCellValue(brf105.getR17_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR17_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R17cell11 = row17.getCell(13); 
							if (R17cell11 != null) {
								R17cell11.setCellValue(brf105.getR17_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR17_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R17cell12 = row17.getCell(14); 
							if (R17cell12 != null) {
								R17cell12.setCellValue(brf105.getR17_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR17_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R17cell13 = row17.getCell(15); 
							if (R17cell13 != null) {
								R17cell13.setCellValue(brf105.getR17_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR17_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R17cell14 = row17.getCell(16); 
							if (R17cell14 != null) {
								R17cell14.setCellValue(brf105.getR17_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR17_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R17cell15 = row17.getCell(17); 
							if (R17cell15 != null) {
								R17cell15.setCellValue(brf105.getR17_NON_PERFORMING() == null ? 0 : brf105.getR17_NON_PERFORMING().intValue());
							}
							Cell R17cell16 = row17.getCell(18); 
							if (R17cell16 != null) {
								R17cell16.setCellValue(brf105.getR17_SPECIFIC_PROVISION() == null ? 0 : brf105.getR17_SPECIFIC_PROVISION().intValue());
							}
							Cell  R17cell17 = row17.getCell(19); 
							if (R17cell17 != null) {
								R17cell17.setCellValue(brf105.getR17_INTEREST() == null ? 0 : brf105.getR17_INTEREST().intValue());
							}
							Cell  R17cell18 = row17.getCell(20); 
							if (R17cell18 != null) {
								R17cell18.setCellValue(brf105.getR17_DEFAULTED() == null ? 0 : brf105.getR17_DEFAULTED().intValue());
							}
							Row row18 = sheet.getRow(26);
							Cell R18cell1 = row18.getCell(3); 
							if (R18cell1 != null) {
								R18cell1.setCellValue(brf105.getR18_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR18_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R18cell2 = row18.getCell(4); 
							if (R18cell2 != null) {
								R18cell2.setCellValue(brf105.getR18_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR18_CRWA_CONSOLIDATED().intValue());
							}
							Cell R18cell3 = row18.getCell(5); 
							if (R18cell3 != null) {
								R18cell3.setCellValue(brf105.getR18_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR18_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R18cell4 = row18.getCell(6); 
							if (R18cell4 != null) {
								R18cell4.setCellValue(brf105.getR18_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR18_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R18cell5 = row18.getCell(7); 
							if (R18cell5 != null) {
								R18cell5.setCellValue(brf105.getR18_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR18_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R18cell6 = row18.getCell(8); 
							if (R18cell6 != null) {
								R18cell6.setCellValue(brf105.getR18_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR18_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R18cell7 = row18.getCell(9); 
							if (R18cell7 != null) {
								R18cell7.setCellValue(brf105.getR18_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR18_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R18cell8 = row18.getCell(10); 
							if (R18cell8 != null) {
								R18cell8.setCellValue(brf105.getR18_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR18_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R18cell9 = row18.getCell(11); 
							if (R18cell9 != null) {
								R18cell9.setCellValue(brf105.getR18_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR18_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R18cell10 = row18.getCell(12); 
							if (R18cell10 != null) {
								R18cell10.setCellValue(brf105.getR18_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR18_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R18cell11 = row18.getCell(13); 
							if (R18cell11 != null) {
								R18cell11.setCellValue(brf105.getR18_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR18_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R18cell12 = row18.getCell(14); 
							if (R18cell12 != null) {
								R18cell12.setCellValue(brf105.getR18_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR18_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R18cell13 = row18.getCell(15); 
							if (R18cell13 != null) {
								R18cell13.setCellValue(brf105.getR18_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR18_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R18cell14 = row18.getCell(16); 
							if (R18cell14 != null) {
								R18cell14.setCellValue(brf105.getR18_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR18_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R18cell15 = row18.getCell(17); 
							if (R18cell15 != null) {
								R18cell15.setCellValue(brf105.getR18_NON_PERFORMING() == null ? 0 : brf105.getR18_NON_PERFORMING().intValue());
							}
							Cell R18cell16 = row18.getCell(18); 
							if (R18cell16 != null) {
								R18cell16.setCellValue(brf105.getR18_SPECIFIC_PROVISION() == null ? 0 : brf105.getR18_SPECIFIC_PROVISION().intValue());
							}
							Cell  R18cell17 = row18.getCell(19); 
							if (R18cell17 != null) {
								R18cell17.setCellValue(brf105.getR18_INTEREST() == null ? 0 : brf105.getR18_INTEREST().intValue());
							}
							Cell  R18cell18 = row18.getCell(20); 
							if (R18cell18 != null) {
								R18cell18.setCellValue(brf105.getR18_DEFAULTED() == null ? 0 : brf105.getR18_DEFAULTED().intValue());
							}
                            Row row19 = sheet.getRow(27);
                            Cell R19cell1 = row19.getCell(3); 
							if (R19cell1 != null) {
								R19cell1.setCellValue(brf105.getR19_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR19_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R19cell2 = row19.getCell(4); 
							if (R19cell2 != null) {
								R19cell2.setCellValue(brf105.getR19_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR19_CRWA_CONSOLIDATED().intValue());
							}
							Cell R19cell3 = row19.getCell(5); 
							if (R19cell3 != null) {
								R19cell3.setCellValue(brf105.getR19_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR19_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R19cell4 = row19.getCell(6); 
							if (R19cell4 != null) {
								R19cell4.setCellValue(brf105.getR19_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR19_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R19cell5 = row19.getCell(7); 
							if (R19cell5 != null) {
								R19cell5.setCellValue(brf105.getR19_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR19_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R19cell6 = row19.getCell(8); 
							if (R19cell6 != null) {
								R19cell6.setCellValue(brf105.getR19_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR19_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R19cell7 = row19.getCell(9); 
							if (R19cell7 != null) {
								R19cell7.setCellValue(brf105.getR19_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR19_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R19cell8 = row19.getCell(10); 
							if (R19cell8 != null) {
								R19cell8.setCellValue(brf105.getR19_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR19_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R19cell9 = row19.getCell(11); 
							if (R19cell9 != null) {
								R19cell9.setCellValue(brf105.getR19_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR19_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R19cell10 = row19.getCell(12); 
							if (R19cell10 != null) {
								R19cell10.setCellValue(brf105.getR19_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR19_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R19cell11 = row19.getCell(13); 
							if (R19cell11 != null) {
								R19cell11.setCellValue(brf105.getR19_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR19_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R19cell12 = row19.getCell(14); 
							if (R19cell12 != null) {
								R19cell12.setCellValue(brf105.getR19_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR19_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R19cell13 = row19.getCell(15); 
							if (R19cell13 != null) {
								R19cell13.setCellValue(brf105.getR19_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR19_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R19cell14 = row19.getCell(16); 
							if (R19cell14 != null) {
								R19cell14.setCellValue(brf105.getR19_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR19_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R19cell15 = row19.getCell(17); 
							if (R19cell15 != null) {
								R19cell15.setCellValue(brf105.getR19_NON_PERFORMING() == null ? 0 : brf105.getR19_NON_PERFORMING().intValue());
							}
							Cell R19cell16 = row19.getCell(18); 
							if (R19cell16 != null) {
								R19cell16.setCellValue(brf105.getR19_SPECIFIC_PROVISION() == null ? 0 : brf105.getR19_SPECIFIC_PROVISION().intValue());
							}
							Cell  R19cell17 = row19.getCell(19); 
							if (R19cell17 != null) {
								R19cell17.setCellValue(brf105.getR19_INTEREST() == null ? 0 : brf105.getR19_INTEREST().intValue());
							}
							Cell  R19cell18 = row19.getCell(20); 
							if (R19cell18 != null) {
								R19cell18.setCellValue(brf105.getR19_DEFAULTED() == null ? 0 : brf105.getR19_DEFAULTED().intValue());
							}
							Row row20 = sheet.getRow(28);
							Cell R20cell1 = row20.getCell(3); 
							if (R20cell1 != null) {
								R20cell1.setCellValue(brf105.getR20_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR20_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R20cell2 = row20.getCell(4); 
							if (R20cell2 != null) {
								R20cell2.setCellValue(brf105.getR20_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR20_CRWA_CONSOLIDATED().intValue());
							}
							Cell R20cell3 = row20.getCell(5); 
							if (R20cell3 != null) {
								R20cell3.setCellValue(brf105.getR20_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR20_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R20cell4 = row20.getCell(6); 
							if (R20cell4 != null) {
								R20cell4.setCellValue(brf105.getR20_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR20_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R20cell5 = row20.getCell(7); 
							if (R20cell5 != null) {
								R20cell5.setCellValue(brf105.getR20_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR20_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R20cell6 = row20.getCell(8); 
							if (R20cell6 != null) {
								R20cell6.setCellValue(brf105.getR20_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR20_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R20cell7 = row20.getCell(9); 
							if (R20cell7 != null) {
								R20cell7.setCellValue(brf105.getR20_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR20_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R20cell8 = row20.getCell(10); 
							if (R20cell8 != null) {
								R20cell8.setCellValue(brf105.getR20_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR20_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R20cell9 = row20.getCell(11); 
							if (R20cell9 != null) {
								R20cell9.setCellValue(brf105.getR20_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR20_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R20cell10 = row20.getCell(12); 
							if (R20cell10 != null) {
								R20cell10.setCellValue(brf105.getR20_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR20_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R20cell11 = row20.getCell(13); 
							if (R20cell11 != null) {
								R20cell11.setCellValue(brf105.getR20_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR20_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R20cell12 = row20.getCell(14); 
							if (R20cell12 != null) {
								R20cell12.setCellValue(brf105.getR20_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR20_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R20cell13 = row20.getCell(15); 
							if (R20cell13 != null) {
								R20cell13.setCellValue(brf105.getR20_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR20_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R20cell14 = row20.getCell(16); 
							if (R20cell14 != null) {
								R20cell14.setCellValue(brf105.getR20_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR20_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R20cell15 = row20.getCell(17); 
							if (R20cell15 != null) {
								R20cell15.setCellValue(brf105.getR20_NON_PERFORMING() == null ? 0 : brf105.getR20_NON_PERFORMING().intValue());
							}
							Cell R20cell16 = row20.getCell(18); 
							if (R20cell16 != null) {
								R20cell16.setCellValue(brf105.getR20_SPECIFIC_PROVISION() == null ? 0 : brf105.getR20_SPECIFIC_PROVISION().intValue());
							}
							Cell  R20cell17 = row20.getCell(19); 
							if (R20cell17 != null) {
								R20cell17.setCellValue(brf105.getR20_INTEREST() == null ? 0 : brf105.getR20_INTEREST().intValue());
							}
							Cell  R20cell18 = row20.getCell(20); 
							if (R20cell18 != null) {
								R20cell18.setCellValue(brf105.getR20_DEFAULTED() == null ? 0 : brf105.getR20_DEFAULTED().intValue());
							}
							Row row21 = sheet.getRow(29);
							Cell R21cell1 = row21.getCell(3); 
							if (R21cell1 != null) {
								R21cell1.setCellValue(brf105.getR21_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR21_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R21cell2 = row21.getCell(4); 
							if (R21cell2 != null) {
								R21cell2.setCellValue(brf105.getR21_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR21_CRWA_CONSOLIDATED().intValue());
							}
							Cell R21cell3 = row21.getCell(5); 
							if (R21cell3 != null) {
								R21cell3.setCellValue(brf105.getR21_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR21_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R21cell4 = row21.getCell(6); 
							if (R21cell4 != null) {
								R21cell4.setCellValue(brf105.getR21_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR21_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R21cell5 = row21.getCell(7); 
							if (R21cell5 != null) {
								R21cell5.setCellValue(brf105.getR21_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR21_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R21cell6 = row21.getCell(8); 
							if (R21cell6 != null) {
								R21cell6.setCellValue(brf105.getR21_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR21_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R21cell7 = row21.getCell(9); 
							if (R21cell7 != null) {
								R21cell7.setCellValue(brf105.getR21_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR21_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R21cell8 = row21.getCell(10); 
							if (R21cell8 != null) {
								R21cell8.setCellValue(brf105.getR21_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR21_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R21cell9 = row21.getCell(11); 
							if (R21cell9 != null) {
								R21cell9.setCellValue(brf105.getR21_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR21_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R21cell10 = row21.getCell(12); 
							if (R21cell10 != null) {
								R21cell10.setCellValue(brf105.getR21_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR21_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R21cell11 = row21.getCell(13); 
							if (R21cell11 != null) {
								R21cell11.setCellValue(brf105.getR21_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR21_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R21cell12 = row21.getCell(14); 
							if (R21cell12 != null) {
								R21cell12.setCellValue(brf105.getR21_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR21_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R21cell13 = row21.getCell(15); 
							if (R21cell13 != null) {
								R21cell13.setCellValue(brf105.getR21_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR21_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R21cell14 = row21.getCell(16); 
							if (R21cell14 != null) {
								R21cell14.setCellValue(brf105.getR21_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR21_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R21cell15 = row21.getCell(17); 
							if (R21cell15 != null) {
								R21cell15.setCellValue(brf105.getR21_NON_PERFORMING() == null ? 0 : brf105.getR21_NON_PERFORMING().intValue());
							}
							Cell R21cell16 = row21.getCell(18); 
							if (R21cell16 != null) {
								R21cell16.setCellValue(brf105.getR21_SPECIFIC_PROVISION() == null ? 0 : brf105.getR21_SPECIFIC_PROVISION().intValue());
							}
							Cell  R21cell17 = row21.getCell(19); 
							if (R21cell17 != null) {
								R21cell17.setCellValue(brf105.getR21_INTEREST() == null ? 0 : brf105.getR21_INTEREST().intValue());
							}
							Cell  R21cell18 = row21.getCell(20); 
							if (R21cell18 != null) {
								R21cell18.setCellValue(brf105.getR21_DEFAULTED() == null ? 0 : brf105.getR21_DEFAULTED().intValue());
							}
							Row row23 = sheet.getRow(31);
							Cell R23cell1 = row23.getCell(3); 
							if (R23cell1 != null) {
								R23cell1.setCellValue(brf105.getR23_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR23_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R23cell2 = row23.getCell(4); 
							if (R23cell2 != null) {
								R23cell2.setCellValue(brf105.getR23_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR23_CRWA_CONSOLIDATED().intValue());
							}
							Cell R23cell3 = row23.getCell(5); 
							if (R23cell3 != null) {
								R23cell3.setCellValue(brf105.getR23_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR23_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R23cell4 = row23.getCell(6); 
							if (R23cell4 != null) {
								R23cell4.setCellValue(brf105.getR23_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR23_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R23cell5 = row23.getCell(7); 
							if (R23cell5 != null) {
								R23cell5.setCellValue(brf105.getR23_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR23_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R23cell6 = row23.getCell(8); 
							if (R23cell6 != null) {
								R23cell6.setCellValue(brf105.getR23_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR23_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R23cell7 = row23.getCell(9); 
							if (R23cell7 != null) {
								R23cell7.setCellValue(brf105.getR23_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR23_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R23cell8 = row23.getCell(10); 
							if (R23cell8 != null) {
								R23cell8.setCellValue(brf105.getR23_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR23_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R23cell9 = row23.getCell(11); 
							if (R23cell9 != null) {
								R23cell9.setCellValue(brf105.getR23_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR23_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R23cell10 = row23.getCell(12); 
							if (R23cell10 != null) {
								R23cell10.setCellValue(brf105.getR23_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR23_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R23cell11 = row23.getCell(13); 
							if (R23cell11 != null) {
								R23cell11.setCellValue(brf105.getR23_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR23_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R23cell12 = row23.getCell(14); 
							if (R23cell12 != null) {
								R23cell12.setCellValue(brf105.getR23_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR23_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R23cell13 = row23.getCell(15); 
							if (R23cell13 != null) {
								R23cell13.setCellValue(brf105.getR23_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR23_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R23cell14 = row23.getCell(16); 
							if (R23cell14 != null) {
								R23cell14.setCellValue(brf105.getR23_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR23_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R23cell15 = row23.getCell(17); 
							if (R23cell15 != null) {
								R23cell15.setCellValue(brf105.getR23_NON_PERFORMING() == null ? 0 : brf105.getR23_NON_PERFORMING().intValue());
							}
							Cell R23cell16 = row23.getCell(18); 
							if (R23cell16 != null) {
								R23cell16.setCellValue(brf105.getR23_SPECIFIC_PROVISION() == null ? 0 : brf105.getR23_SPECIFIC_PROVISION().intValue());
							}
							Cell  R23cell17 = row23.getCell(19); 
							if (R23cell17 != null) {
								R23cell17.setCellValue(brf105.getR23_INTEREST() == null ? 0 : brf105.getR23_INTEREST().intValue());
							}
							Cell  R23cell18 = row23.getCell(20); 
							if (R23cell18 != null) {
								R23cell18.setCellValue(brf105.getR23_DEFAULTED() == null ? 0 : brf105.getR23_DEFAULTED().intValue());
							}
							Row row24 = sheet.getRow(32);
							Cell R24cell1 = row24.getCell(3); 
							if (R24cell1 != null) {
								R24cell1.setCellValue(brf105.getR24_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR24_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R24cell2 = row24.getCell(4); 
							if (R24cell2 != null) {
								R24cell2.setCellValue(brf105.getR24_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR24_CRWA_CONSOLIDATED().intValue());
							}
							Cell R24cell3 = row24.getCell(5); 
							if (R24cell3 != null) {
								R24cell3.setCellValue(brf105.getR24_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR24_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R24cell4 = row24.getCell(6); 
							if (R24cell4 != null) {
								R24cell4.setCellValue(brf105.getR24_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR24_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R24cell5 = row24.getCell(7); 
							if (R24cell5 != null) {
								R24cell5.setCellValue(brf105.getR24_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR24_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R24cell6 = row24.getCell(8); 
							if (R24cell6 != null) {
								R24cell6.setCellValue(brf105.getR24_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR24_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R24cell7 = row24.getCell(9); 
							if (R24cell7 != null) {
								R24cell7.setCellValue(brf105.getR24_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR24_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R24cell8 = row24.getCell(10); 
							if (R24cell8 != null) {
								R24cell8.setCellValue(brf105.getR24_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR24_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R24cell9 = row24.getCell(11); 
							if (R24cell9 != null) {
								R24cell9.setCellValue(brf105.getR24_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR24_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R24cell10 = row24.getCell(12); 
							if (R24cell10 != null) {
								R24cell10.setCellValue(brf105.getR24_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR24_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R24cell11 = row24.getCell(13); 
							if (R24cell11 != null) {
								R24cell11.setCellValue(brf105.getR24_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR24_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R24cell12 = row24.getCell(14); 
							if (R24cell12 != null) {
								R24cell12.setCellValue(brf105.getR24_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR24_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R24cell13 = row24.getCell(15); 
							if (R24cell13 != null) {
								R24cell13.setCellValue(brf105.getR24_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR24_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R24cell14 = row24.getCell(16); 
							if (R24cell14 != null) {
								R24cell14.setCellValue(brf105.getR24_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR24_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R24cell15 = row24.getCell(17); 
							if (R24cell15 != null) {
								R24cell15.setCellValue(brf105.getR24_NON_PERFORMING() == null ? 0 : brf105.getR24_NON_PERFORMING().intValue());
							}
							Cell R24cell16 = row24.getCell(18); 
							if (R24cell16 != null) {
								R24cell16.setCellValue(brf105.getR24_SPECIFIC_PROVISION() == null ? 0 : brf105.getR24_SPECIFIC_PROVISION().intValue());
							}
							Cell  R24cell17 = row24.getCell(19); 
							if (R24cell17 != null) {
								R24cell17.setCellValue(brf105.getR24_INTEREST() == null ? 0 : brf105.getR24_INTEREST().intValue());
							}
							Cell  R24cell18 = row24.getCell(20); 
							if (R24cell18 != null) {
								R24cell18.setCellValue(brf105.getR24_DEFAULTED() == null ? 0 : brf105.getR24_DEFAULTED().intValue());
							}
							Row row25 = sheet.getRow(33);
							Cell R25cell1 = row25.getCell(3); 
							if (R25cell1 != null) {
								R25cell1.setCellValue(brf105.getR25_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR25_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R25cell2 = row25.getCell(4); 
							if (R25cell2 != null) {
								R25cell2.setCellValue(brf105.getR25_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR25_CRWA_CONSOLIDATED().intValue());
							}
							Cell R25cell3 = row25.getCell(5); 
							if (R25cell3 != null) {
								R25cell3.setCellValue(brf105.getR25_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR25_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R25cell4 = row25.getCell(6); 
							if (R25cell4 != null) {
								R25cell4.setCellValue(brf105.getR25_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR25_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R25cell5 = row25.getCell(7); 
							if (R25cell5 != null) {
								R25cell5.setCellValue(brf105.getR25_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR25_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R25cell6 = row25.getCell(8); 
							if (R25cell6 != null) {
								R25cell6.setCellValue(brf105.getR25_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR25_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R25cell7 = row25.getCell(9); 
							if (R25cell7 != null) {
								R25cell7.setCellValue(brf105.getR25_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR25_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R25cell8 = row25.getCell(10); 
							if (R25cell8 != null) {
								R25cell8.setCellValue(brf105.getR25_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR25_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R25cell9 = row25.getCell(11); 
							if (R25cell9 != null) {
								R25cell9.setCellValue(brf105.getR25_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR25_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R25cell10 = row25.getCell(12); 
							if (R25cell10 != null) {
								R25cell10.setCellValue(brf105.getR25_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR25_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R25cell11 = row25.getCell(13); 
							if (R25cell11 != null) {
								R25cell11.setCellValue(brf105.getR25_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR25_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R25cell12 = row25.getCell(14); 
							if (R25cell12 != null) {
								R25cell12.setCellValue(brf105.getR25_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR25_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R25cell13 = row25.getCell(15); 
							if (R25cell13 != null) {
								R25cell13.setCellValue(brf105.getR25_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR25_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R25cell14 = row25.getCell(16); 
							if (R25cell14 != null) {
								R25cell14.setCellValue(brf105.getR25_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR25_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R25cell15 = row25.getCell(17); 
							if (R25cell15 != null) {
								R25cell15.setCellValue(brf105.getR25_NON_PERFORMING() == null ? 0 : brf105.getR25_NON_PERFORMING().intValue());
							}
							Cell R25cell16 = row25.getCell(18); 
							if (R25cell16 != null) {
								R25cell16.setCellValue(brf105.getR25_SPECIFIC_PROVISION() == null ? 0 : brf105.getR25_SPECIFIC_PROVISION().intValue());
							}
							Cell  R25cell17 = row25.getCell(19); 
							if (R25cell17 != null) {
								R25cell17.setCellValue(brf105.getR25_INTEREST() == null ? 0 : brf105.getR25_INTEREST().intValue());
							}
							Cell  R25cell18 = row25.getCell(20); 
							if (R25cell18 != null) {
								R25cell18.setCellValue(brf105.getR25_DEFAULTED() == null ? 0 : brf105.getR25_DEFAULTED().intValue());
							}
							Row row26 = sheet.getRow(34);
							Cell R26cell1 = row26.getCell(3); 
							if (R26cell1 != null) {
								R26cell1.setCellValue(brf105.getR26_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR26_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R26cell2 = row26.getCell(4); 
							if (R26cell2 != null) {
								R26cell2.setCellValue(brf105.getR26_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR26_CRWA_CONSOLIDATED().intValue());
							}
							Cell R26cell3 = row26.getCell(5); 
							if (R26cell3 != null) {
								R26cell3.setCellValue(brf105.getR26_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR26_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R26cell4 = row26.getCell(6); 
							if (R26cell4 != null) {
								R26cell4.setCellValue(brf105.getR26_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR26_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R26cell5 = row26.getCell(7); 
							if (R26cell5 != null) {
								R26cell5.setCellValue(brf105.getR26_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR26_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R26cell6 = row26.getCell(8); 
							if (R26cell6 != null) {
								R26cell6.setCellValue(brf105.getR26_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR26_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R26cell7 = row26.getCell(9); 
							if (R26cell7 != null) {
								R26cell7.setCellValue(brf105.getR26_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR26_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R26cell8 = row26.getCell(10); 
							if (R26cell8 != null) {
								R26cell8.setCellValue(brf105.getR26_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR26_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R26cell9 = row26.getCell(11); 
							if (R26cell9 != null) {
								R26cell9.setCellValue(brf105.getR26_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR26_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R26cell10 = row26.getCell(12); 
							if (R26cell10 != null) {
								R26cell10.setCellValue(brf105.getR26_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR26_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R26cell11 = row26.getCell(13); 
							if (R26cell11 != null) {
								R26cell11.setCellValue(brf105.getR26_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR26_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R26cell12 = row26.getCell(14); 
							if (R26cell12 != null) {
								R26cell12.setCellValue(brf105.getR26_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR26_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R26cell13 = row26.getCell(15); 
							if (R26cell13 != null) {
								R26cell13.setCellValue(brf105.getR26_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR26_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R26cell14 = row26.getCell(16); 
							if (R26cell14 != null) {
								R26cell14.setCellValue(brf105.getR26_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR26_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R26cell15 = row26.getCell(17); 
							if (R26cell15 != null) {
								R26cell15.setCellValue(brf105.getR26_NON_PERFORMING() == null ? 0 : brf105.getR26_NON_PERFORMING().intValue());
							}
							Cell R26cell16 = row26.getCell(18); 
							if (R26cell16 != null) {
								R26cell16.setCellValue(brf105.getR26_SPECIFIC_PROVISION() == null ? 0 : brf105.getR26_SPECIFIC_PROVISION().intValue());
							}
							Cell  R26cell17 = row26.getCell(19); 
							if (R26cell17 != null) {
								R26cell17.setCellValue(brf105.getR26_INTEREST() == null ? 0 : brf105.getR26_INTEREST().intValue());
							}
							Cell  R26cell18 = row26.getCell(20); 
							if (R26cell18 != null) {
								R26cell18.setCellValue(brf105.getR26_DEFAULTED() == null ? 0 : brf105.getR26_DEFAULTED().intValue());
							}
							Row row27 = sheet.getRow(35);
							Cell R27cell1 = row27.getCell(3); 
							if (R27cell1 != null) {
								R27cell1.setCellValue(brf105.getR27_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR27_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R27cell2 = row27.getCell(4); 
							if (R27cell2 != null) {
								R27cell2.setCellValue(brf105.getR27_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR27_CRWA_CONSOLIDATED().intValue());
							}
							Cell R27cell3 = row27.getCell(5); 
							if (R27cell3 != null) {
								R27cell3.setCellValue(brf105.getR27_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR27_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R27cell4 = row27.getCell(6); 
							if (R27cell4 != null) {
								R27cell4.setCellValue(brf105.getR27_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR27_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R27cell5 = row27.getCell(7); 
							if (R27cell5 != null) {
								R27cell5.setCellValue(brf105.getR27_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR27_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R27cell6 = row27.getCell(8); 
							if (R27cell6 != null) {
								R27cell6.setCellValue(brf105.getR27_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR27_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R27cell7 = row27.getCell(9); 
							if (R27cell7 != null) {
								R27cell7.setCellValue(brf105.getR27_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR27_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R27cell8 = row27.getCell(10); 
							if (R27cell8 != null) {
								R27cell8.setCellValue(brf105.getR27_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR27_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R27cell9 = row27.getCell(11); 
							if (R27cell9 != null) {
								R27cell9.setCellValue(brf105.getR27_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR27_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R27cell10 = row27.getCell(12); 
							if (R27cell10 != null) {
								R27cell10.setCellValue(brf105.getR27_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR27_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R27cell11 = row27.getCell(13); 
							if (R27cell11 != null) {
								R27cell11.setCellValue(brf105.getR27_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR27_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R27cell12 = row27.getCell(14); 
							if (R27cell12 != null) {
								R27cell12.setCellValue(brf105.getR27_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR27_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R27cell13 = row27.getCell(15); 
							if (R27cell13 != null) {
								R27cell13.setCellValue(brf105.getR27_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR27_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R27cell14 = row27.getCell(16); 
							if (R27cell14 != null) {
								R27cell14.setCellValue(brf105.getR27_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR27_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R27cell15 = row27.getCell(17); 
							if (R27cell15 != null) {
								R27cell15.setCellValue(brf105.getR27_NON_PERFORMING() == null ? 0 : brf105.getR27_NON_PERFORMING().intValue());
							}
							Cell R27cell16 = row27.getCell(18); 
							if (R27cell16 != null) {
								R27cell16.setCellValue(brf105.getR27_SPECIFIC_PROVISION() == null ? 0 : brf105.getR27_SPECIFIC_PROVISION().intValue());
							}
							Cell  R27cell17 = row27.getCell(19); 
							if (R27cell17 != null) {
								R27cell17.setCellValue(brf105.getR27_INTEREST() == null ? 0 : brf105.getR27_INTEREST().intValue());
							}
							Cell  R27cell18 = row27.getCell(20); 
							if (R27cell18 != null) {
								R27cell18.setCellValue(brf105.getR27_DEFAULTED() == null ? 0 : brf105.getR27_DEFAULTED().intValue());
							}
							Row row28 = sheet.getRow(36);
							Cell R28cell1 = row28.getCell(3); 
							if (R28cell1 != null) {
								R28cell1.setCellValue(brf105.getR28_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR28_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R28cell2 = row28.getCell(4); 
							if (R28cell2 != null) {
								R28cell2.setCellValue(brf105.getR28_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR28_CRWA_CONSOLIDATED().intValue());
							}
							Cell R28cell3 = row28.getCell(5); 
							if (R28cell3 != null) {
								R28cell3.setCellValue(brf105.getR28_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR28_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R28cell4 = row28.getCell(6); 
							if (R28cell4 != null) {
								R28cell4.setCellValue(brf105.getR28_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR28_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R28cell5 = row28.getCell(7); 
							if (R28cell5 != null) {
								R28cell5.setCellValue(brf105.getR28_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR28_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R28cell6 = row28.getCell(8); 
							if (R28cell6 != null) {
								R28cell6.setCellValue(brf105.getR28_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR28_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R28cell7 = row28.getCell(9); 
							if (R28cell7 != null) {
								R28cell7.setCellValue(brf105.getR28_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR28_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R28cell8 = row28.getCell(10); 
							if (R28cell8 != null) {
								R28cell8.setCellValue(brf105.getR28_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR28_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R28cell9 = row28.getCell(11); 
							if (R28cell9 != null) {
								R28cell9.setCellValue(brf105.getR28_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR28_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R28cell10 = row28.getCell(12); 
							if (R28cell10 != null) {
								R28cell10.setCellValue(brf105.getR28_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR28_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R28cell11 = row28.getCell(13); 
							if (R28cell11 != null) {
								R28cell11.setCellValue(brf105.getR28_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR28_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R28cell12 = row28.getCell(14); 
							if (R28cell12 != null) {
								R28cell12.setCellValue(brf105.getR28_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR28_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R28cell13 = row28.getCell(15); 
							if (R28cell13 != null) {
								R28cell13.setCellValue(brf105.getR28_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR28_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R28cell14 = row28.getCell(16); 
							if (R28cell14 != null) {
								R28cell14.setCellValue(brf105.getR28_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR28_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R28cell15 = row28.getCell(17); 
							if (R28cell15 != null) {
								R28cell15.setCellValue(brf105.getR28_NON_PERFORMING() == null ? 0 : brf105.getR28_NON_PERFORMING().intValue());
							}
							Cell R28cell16 = row28.getCell(18); 
							if (R28cell16 != null) {
								R28cell16.setCellValue(brf105.getR28_SPECIFIC_PROVISION() == null ? 0 : brf105.getR28_SPECIFIC_PROVISION().intValue());
							}
							Cell  R28cell17 = row28.getCell(19); 
							if (R28cell17 != null) {
								R28cell17.setCellValue(brf105.getR28_INTEREST() == null ? 0 : brf105.getR28_INTEREST().intValue());
							}
							Cell  R28cell18 = row28.getCell(20); 
							if (R28cell18 != null) {
								R28cell18.setCellValue(brf105.getR28_DEFAULTED() == null ? 0 : brf105.getR28_DEFAULTED().intValue());
							}
							Row row29 = sheet.getRow(37);
							Cell R29cell1 = row29.getCell(3); 
							if (R29cell1 != null) {
								R29cell1.setCellValue(brf105.getR29_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR29_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R29cell2 = row29.getCell(4); 
							if (R29cell2 != null) {
								R29cell2.setCellValue(brf105.getR29_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR29_CRWA_CONSOLIDATED().intValue());
							}
							Cell R29cell3 = row29.getCell(5); 
							if (R29cell3 != null) {
								R29cell3.setCellValue(brf105.getR29_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR29_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R29cell4 = row29.getCell(6); 
							if (R29cell4 != null) {
								R29cell4.setCellValue(brf105.getR29_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR29_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R29cell5 = row29.getCell(7); 
							if (R29cell5 != null) {
								R29cell5.setCellValue(brf105.getR29_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR29_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R29cell6 = row29.getCell(8); 
							if (R29cell6 != null) {
								R29cell6.setCellValue(brf105.getR29_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR29_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R29cell7 = row29.getCell(9); 
							if (R29cell7 != null) {
								R29cell7.setCellValue(brf105.getR29_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR29_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R29cell8 = row29.getCell(10); 
							if (R29cell8 != null) {
								R29cell8.setCellValue(brf105.getR29_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR29_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R29cell9 = row29.getCell(11); 
							if (R29cell9 != null) {
								R29cell9.setCellValue(brf105.getR29_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR29_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R29cell10 = row29.getCell(12); 
							if (R29cell10 != null) {
								R29cell10.setCellValue(brf105.getR29_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR29_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R29cell11 = row29.getCell(13); 
							if (R29cell11 != null) {
								R29cell11.setCellValue(brf105.getR29_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR29_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R29cell12 = row29.getCell(14); 
							if (R29cell12 != null) {
								R29cell12.setCellValue(brf105.getR29_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR29_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R29cell13 = row29.getCell(15); 
							if (R29cell13 != null) {
								R29cell13.setCellValue(brf105.getR29_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR29_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R29cell14 = row29.getCell(16); 
							if (R29cell14 != null) {
								R29cell14.setCellValue(brf105.getR29_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR29_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R29cell15 = row29.getCell(17); 
							if (R29cell15 != null) {
								R29cell15.setCellValue(brf105.getR29_NON_PERFORMING() == null ? 0 : brf105.getR29_NON_PERFORMING().intValue());
							}
							Cell R29cell16 = row29.getCell(18); 
							if (R29cell16 != null) {
								R29cell16.setCellValue(brf105.getR29_SPECIFIC_PROVISION() == null ? 0 : brf105.getR29_SPECIFIC_PROVISION().intValue());
							}
							Cell  R29cell17 = row29.getCell(19); 
							if (R29cell17 != null) {
								R29cell17.setCellValue(brf105.getR29_INTEREST() == null ? 0 : brf105.getR29_INTEREST().intValue());
							}
							Cell  R29cell18 = row29.getCell(20); 
							if (R29cell18 != null) {
								R29cell18.setCellValue(brf105.getR29_DEFAULTED() == null ? 0 : brf105.getR29_DEFAULTED().intValue());
							}
							Row row30 = sheet.getRow(38);
							Cell R30cell1 = row30.getCell(3); 
							if (R30cell1 != null) {
								R30cell1.setCellValue(brf105.getR30_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR30_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R30cell2 = row30.getCell(4); 
							if (R30cell2 != null) {
								R30cell2.setCellValue(brf105.getR30_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR30_CRWA_CONSOLIDATED().intValue());
							}
							Cell R30cell3 = row30.getCell(5); 
							if (R30cell3 != null) {
								R30cell3.setCellValue(brf105.getR30_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR30_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R30cell4 = row30.getCell(6); 
							if (R30cell4 != null) {
								R30cell4.setCellValue(brf105.getR30_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR30_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R30cell5 = row30.getCell(7); 
							if (R30cell5 != null) {
								R30cell5.setCellValue(brf105.getR30_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR30_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R30cell6 = row30.getCell(8); 
							if (R30cell6 != null) {
								R30cell6.setCellValue(brf105.getR30_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR30_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R30cell7 = row30.getCell(9); 
							if (R30cell7 != null) {
								R30cell7.setCellValue(brf105.getR30_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR30_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R30cell8 = row30.getCell(10); 
							if (R30cell8 != null) {
								R30cell8.setCellValue(brf105.getR30_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR30_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R30cell9 = row30.getCell(11); 
							if (R30cell9 != null) {
								R30cell9.setCellValue(brf105.getR30_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR30_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R30cell10 = row30.getCell(12); 
							if (R30cell10 != null) {
								R30cell10.setCellValue(brf105.getR30_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR30_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R30cell11 = row30.getCell(13); 
							if (R30cell11 != null) {
								R30cell11.setCellValue(brf105.getR30_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR30_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R30cell12 = row30.getCell(14); 
							if (R30cell12 != null) {
								R30cell12.setCellValue(brf105.getR30_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR30_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R30cell13 = row30.getCell(15); 
							if (R30cell13 != null) {
								R30cell13.setCellValue(brf105.getR30_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR30_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R30cell14 = row30.getCell(16); 
							if (R30cell14 != null) {
								R30cell14.setCellValue(brf105.getR30_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR30_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R30cell15 = row30.getCell(17); 
							if (R30cell15 != null) {
								R30cell15.setCellValue(brf105.getR30_NON_PERFORMING() == null ? 0 : brf105.getR30_NON_PERFORMING().intValue());
							}
							Cell R30cell16 = row30.getCell(18); 
							if (R30cell16 != null) {
								R30cell16.setCellValue(brf105.getR30_SPECIFIC_PROVISION() == null ? 0 : brf105.getR30_SPECIFIC_PROVISION().intValue());
							}
							Cell  R30cell17 = row30.getCell(19); 
							if (R30cell17 != null) {
								R30cell17.setCellValue(brf105.getR30_INTEREST() == null ? 0 : brf105.getR30_INTEREST().intValue());
							}
							Cell  R30cell18 = row30.getCell(20); 
							if (R30cell18 != null) {
								R30cell18.setCellValue(brf105.getR30_DEFAULTED() == null ? 0 : brf105.getR30_DEFAULTED().intValue());
							}
							Row row31 = sheet.getRow(39);
							Cell R31cell1 = row31.getCell(3); 
							if (R31cell1 != null) {
								R31cell1.setCellValue(brf105.getR31_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR31_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R31cell2 = row31.getCell(4); 
							if (R31cell2 != null) {
								R31cell2.setCellValue(brf105.getR31_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR31_CRWA_CONSOLIDATED().intValue());
							}
							Cell R31cell3 = row31.getCell(5); 
							if (R31cell3 != null) {
								R31cell3.setCellValue(brf105.getR31_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR31_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R31cell4 = row31.getCell(6); 
							if (R31cell4 != null) {
								R31cell4.setCellValue(brf105.getR31_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR31_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R31cell5 = row31.getCell(7); 
							if (R31cell5 != null) {
								R31cell5.setCellValue(brf105.getR31_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR31_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R31cell6 = row31.getCell(8); 
							if (R31cell6 != null) {
								R31cell6.setCellValue(brf105.getR31_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR31_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R31cell7 = row31.getCell(9); 
							if (R31cell7 != null) {
								R31cell7.setCellValue(brf105.getR31_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR31_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R31cell8 = row31.getCell(10); 
							if (R31cell8 != null) {
								R31cell8.setCellValue(brf105.getR31_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR31_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R31cell9 = row31.getCell(11); 
							if (R31cell9 != null) {
								R31cell9.setCellValue(brf105.getR31_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR31_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R31cell10 = row31.getCell(12); 
							if (R31cell10 != null) {
								R31cell10.setCellValue(brf105.getR31_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR31_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R31cell11 = row31.getCell(13); 
							if (R31cell11 != null) {
								R31cell11.setCellValue(brf105.getR31_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR31_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R31cell12 = row31.getCell(14); 
							if (R31cell12 != null) {
								R31cell12.setCellValue(brf105.getR31_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR31_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R31cell13 = row31.getCell(15); 
							if (R31cell13 != null) {
								R31cell13.setCellValue(brf105.getR31_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR31_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R31cell14 = row31.getCell(16); 
							if (R31cell14 != null) {
								R31cell14.setCellValue(brf105.getR31_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR31_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R31cell15 = row31.getCell(17); 
							if (R31cell15 != null) {
								R31cell15.setCellValue(brf105.getR31_NON_PERFORMING() == null ? 0 : brf105.getR31_NON_PERFORMING().intValue());
							}
							Cell R31cell16 = row31.getCell(18); 
							if (R31cell16 != null) {
								R31cell16.setCellValue(brf105.getR31_SPECIFIC_PROVISION() == null ? 0 : brf105.getR31_SPECIFIC_PROVISION().intValue());
							}
							Cell  R31cell17 = row31.getCell(19); 
							if (R31cell17 != null) {
								R31cell17.setCellValue(brf105.getR31_INTEREST() == null ? 0 : brf105.getR31_INTEREST().intValue());
							}
							Cell  R31cell18 = row31.getCell(20); 
							if (R31cell18 != null) {
								R31cell18.setCellValue(brf105.getR31_DEFAULTED() == null ? 0 : brf105.getR31_DEFAULTED().intValue());
							}
							Row row32 = sheet.getRow(40);
							Cell R32cell1 = row32.getCell(3); 
							if (R32cell1 != null) {
								R32cell1.setCellValue(brf105.getR32_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR32_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R32cell2 = row32.getCell(4); 
							if (R32cell2 != null) {
								R32cell2.setCellValue(brf105.getR32_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR32_CRWA_CONSOLIDATED().intValue());
							}
							Cell R32cell3 = row32.getCell(5); 
							if (R32cell3 != null) {
								R32cell3.setCellValue(brf105.getR32_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR32_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R32cell4 = row32.getCell(6); 
							if (R32cell4 != null) {
								R32cell4.setCellValue(brf105.getR32_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR32_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R32cell5 = row32.getCell(7); 
							if (R32cell5 != null) {
								R32cell5.setCellValue(brf105.getR32_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR32_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R32cell6 = row32.getCell(8); 
							if (R32cell6 != null) {
								R32cell6.setCellValue(brf105.getR32_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR32_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R32cell7 = row32.getCell(9); 
							if (R32cell7 != null) {
								R32cell7.setCellValue(brf105.getR32_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR32_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R32cell8 = row32.getCell(10); 
							if (R32cell8 != null) {
								R32cell8.setCellValue(brf105.getR32_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR32_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R32cell9 = row32.getCell(11); 
							if (R32cell9 != null) {
								R32cell9.setCellValue(brf105.getR32_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR32_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R32cell10 = row32.getCell(12); 
							if (R32cell10 != null) {
								R32cell10.setCellValue(brf105.getR32_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR32_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R32cell11 = row32.getCell(13); 
							if (R32cell11 != null) {
								R32cell11.setCellValue(brf105.getR32_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR32_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R32cell12 = row32.getCell(14); 
							if (R32cell12 != null) {
								R32cell12.setCellValue(brf105.getR32_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR32_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R32cell13 = row32.getCell(15); 
							if (R32cell13 != null) {
								R32cell13.setCellValue(brf105.getR32_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR32_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R32cell14 = row32.getCell(16); 
							if (R32cell14 != null) {
								R32cell14.setCellValue(brf105.getR32_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR32_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R32cell15 = row32.getCell(17); 
							if (R32cell15 != null) {
								R32cell15.setCellValue(brf105.getR32_NON_PERFORMING() == null ? 0 : brf105.getR32_NON_PERFORMING().intValue());
							}
							Cell R32cell16 = row32.getCell(18); 
							if (R32cell16 != null) {
								R32cell16.setCellValue(brf105.getR32_SPECIFIC_PROVISION() == null ? 0 : brf105.getR32_SPECIFIC_PROVISION().intValue());
							}
							Cell  R32cell17 = row32.getCell(19); 
							if (R32cell17 != null) {
								R32cell17.setCellValue(brf105.getR32_INTEREST() == null ? 0 : brf105.getR32_INTEREST().intValue());
							}
							Cell  R32cell18 = row32.getCell(20); 
							if (R32cell18 != null) {
								R32cell18.setCellValue(brf105.getR32_DEFAULTED() == null ? 0 : brf105.getR32_DEFAULTED().intValue());
							}
                            Row row33 = sheet.getRow(41);
                            Cell R33cell1 = row33.getCell(3); 
							if (R33cell1 != null) {
								R33cell1.setCellValue(brf105.getR33_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR33_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R33cell2 = row33.getCell(4); 
							if (R33cell2 != null) {
								R33cell2.setCellValue(brf105.getR33_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR33_CRWA_CONSOLIDATED().intValue());
							}
							Cell R33cell3 = row33.getCell(5); 
							if (R33cell3 != null) {
								R33cell3.setCellValue(brf105.getR33_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR33_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R33cell4 = row33.getCell(6); 
							if (R33cell4 != null) {
								R33cell4.setCellValue(brf105.getR33_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR33_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R33cell5 = row33.getCell(7); 
							if (R33cell5 != null) {
								R33cell5.setCellValue(brf105.getR33_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR33_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R33cell6 = row33.getCell(8); 
							if (R33cell6 != null) {
								R33cell6.setCellValue(brf105.getR33_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR33_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R33cell7 = row33.getCell(9); 
							if (R33cell7 != null) {
								R33cell7.setCellValue(brf105.getR33_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR33_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R33cell8 = row33.getCell(10); 
							if (R33cell8 != null) {
								R33cell8.setCellValue(brf105.getR33_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR33_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R33cell9 = row33.getCell(11); 
							if (R33cell9 != null) {
								R33cell9.setCellValue(brf105.getR33_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR33_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R33cell10 = row33.getCell(12); 
							if (R33cell10 != null) {
								R33cell10.setCellValue(brf105.getR33_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR33_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R33cell11 = row33.getCell(13); 
							if (R33cell11 != null) {
								R33cell11.setCellValue(brf105.getR33_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR33_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R33cell12 = row33.getCell(14); 
							if (R33cell12 != null) {
								R33cell12.setCellValue(brf105.getR33_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR33_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R33cell13 = row33.getCell(15); 
							if (R33cell13 != null) {
								R33cell13.setCellValue(brf105.getR33_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR33_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R33cell14 = row33.getCell(16); 
							if (R33cell14 != null) {
								R33cell14.setCellValue(brf105.getR33_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR33_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R33cell15 = row33.getCell(17); 
							if (R33cell15 != null) {
								R33cell15.setCellValue(brf105.getR33_NON_PERFORMING() == null ? 0 : brf105.getR33_NON_PERFORMING().intValue());
							}
							Cell R33cell16 = row33.getCell(18); 
							if (R33cell16 != null) {
								R33cell16.setCellValue(brf105.getR33_SPECIFIC_PROVISION() == null ? 0 : brf105.getR33_SPECIFIC_PROVISION().intValue());
							}
							Cell  R33cell17 = row33.getCell(19); 
							if (R33cell17 != null) {
								R33cell17.setCellValue(brf105.getR33_INTEREST() == null ? 0 : brf105.getR33_INTEREST().intValue());
							}
							Cell  R33cell18 = row33.getCell(20); 
							if (R33cell18 != null) {
								R33cell18.setCellValue(brf105.getR33_DEFAULTED() == null ? 0 : brf105.getR33_DEFAULTED().intValue());
							}
							Row row35 = sheet.getRow(43);
							Cell R35cell1 = row35.getCell(3); 
							if (R35cell1 != null) {
								R35cell1.setCellValue(brf105.getR35_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR35_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R35cell2 = row35.getCell(4); 
							if (R35cell2 != null) {
								R35cell2.setCellValue(brf105.getR35_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR35_CRWA_CONSOLIDATED().intValue());
							}
							Cell R35cell3 = row35.getCell(5); 
							if (R35cell3 != null) {
								R35cell3.setCellValue(brf105.getR35_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR35_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R35cell4 = row35.getCell(6); 
							if (R35cell4 != null) {
								R35cell4.setCellValue(brf105.getR35_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR35_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R35cell5 = row35.getCell(7); 
							if (R35cell5 != null) {
								R35cell5.setCellValue(brf105.getR35_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR35_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R35cell6 = row35.getCell(8); 
							if (R35cell6 != null) {
								R35cell6.setCellValue(brf105.getR35_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR35_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R35cell7 = row35.getCell(9); 
							if (R35cell7 != null) {
								R35cell7.setCellValue(brf105.getR35_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR35_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R35cell8 = row35.getCell(10); 
							if (R35cell8 != null) {
								R35cell8.setCellValue(brf105.getR35_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR35_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R35cell9 = row35.getCell(11); 
							if (R35cell9 != null) {
								R35cell9.setCellValue(brf105.getR35_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR35_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R35cell10 = row35.getCell(12); 
							if (R35cell10 != null) {
								R35cell10.setCellValue(brf105.getR35_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR35_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R35cell11 = row35.getCell(13); 
							if (R35cell11 != null) {
								R35cell11.setCellValue(brf105.getR35_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR35_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R35cell12 = row35.getCell(14); 
							if (R35cell12 != null) {
								R35cell12.setCellValue(brf105.getR35_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR35_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R35cell13 = row35.getCell(15); 
							if (R35cell13 != null) {
								R35cell13.setCellValue(brf105.getR35_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR35_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R35cell14 = row35.getCell(16); 
							if (R35cell14 != null) {
								R35cell14.setCellValue(brf105.getR35_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR35_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R35cell15 = row35.getCell(17); 
							if (R35cell15 != null) {
								R35cell15.setCellValue(brf105.getR35_NON_PERFORMING() == null ? 0 : brf105.getR35_NON_PERFORMING().intValue());
							}
							Cell R35cell16 = row35.getCell(18); 
							if (R35cell16 != null) {
								R35cell16.setCellValue(brf105.getR35_SPECIFIC_PROVISION() == null ? 0 : brf105.getR35_SPECIFIC_PROVISION().intValue());
							}
							Cell  R35cell17 = row35.getCell(19); 
							if (R35cell17 != null) {
								R35cell17.setCellValue(brf105.getR35_INTEREST() == null ? 0 : brf105.getR35_INTEREST().intValue());
							}
							Cell  R35cell18 = row35.getCell(20); 
							if (R35cell18 != null) {
								R35cell18.setCellValue(brf105.getR35_DEFAULTED() == null ? 0 : brf105.getR35_DEFAULTED().intValue());
							}
							Row row36 = sheet.getRow(44);
							Cell R36cell1 = row36.getCell(3); 
							if (R36cell1 != null) {
								R36cell1.setCellValue(brf105.getR36_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR36_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R36cell2 = row36.getCell(4); 
							if (R36cell2 != null) {
								R36cell2.setCellValue(brf105.getR36_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR36_CRWA_CONSOLIDATED().intValue());
							}
							Cell R36cell3 = row36.getCell(5); 
							if (R36cell3 != null) {
								R36cell3.setCellValue(brf105.getR36_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR36_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R36cell4 = row36.getCell(6); 
							if (R36cell4 != null) {
								R36cell4.setCellValue(brf105.getR36_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR36_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R36cell5 = row36.getCell(7); 
							if (R36cell5 != null) {
								R36cell5.setCellValue(brf105.getR36_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR36_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R36cell6 = row36.getCell(8); 
							if (R36cell6 != null) {
								R36cell6.setCellValue(brf105.getR36_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR36_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R36cell7 = row36.getCell(9); 
							if (R36cell7 != null) {
								R36cell7.setCellValue(brf105.getR36_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR36_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R36cell8 = row36.getCell(10); 
							if (R36cell8 != null) {
								R36cell8.setCellValue(brf105.getR36_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR36_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R36cell9 = row36.getCell(11); 
							if (R36cell9 != null) {
								R36cell9.setCellValue(brf105.getR36_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR36_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R36cell10 = row36.getCell(12); 
							if (R36cell10 != null) {
								R36cell10.setCellValue(brf105.getR36_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR36_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R36cell11 = row36.getCell(13); 
							if (R36cell11 != null) {
								R36cell11.setCellValue(brf105.getR36_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR36_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R36cell12 = row36.getCell(14); 
							if (R36cell12 != null) {
								R36cell12.setCellValue(brf105.getR36_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR36_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R36cell13 = row36.getCell(15); 
							if (R36cell13 != null) {
								R36cell13.setCellValue(brf105.getR36_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR36_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R36cell14 = row36.getCell(16); 
							if (R36cell14 != null) {
								R36cell14.setCellValue(brf105.getR36_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR36_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R36cell15 = row36.getCell(17); 
							if (R36cell15 != null) {
								R36cell15.setCellValue(brf105.getR36_NON_PERFORMING() == null ? 0 : brf105.getR36_NON_PERFORMING().intValue());
							}
							Cell R36cell16 = row36.getCell(18); 
							if (R36cell16 != null) {
								R36cell16.setCellValue(brf105.getR36_SPECIFIC_PROVISION() == null ? 0 : brf105.getR36_SPECIFIC_PROVISION().intValue());
							}
							Cell  R36cell17 = row36.getCell(19); 
							if (R36cell17 != null) {
								R36cell17.setCellValue(brf105.getR36_INTEREST() == null ? 0 : brf105.getR36_INTEREST().intValue());
							}
							Cell  R36cell18 = row36.getCell(20); 
							if (R36cell18 != null) {
								R36cell18.setCellValue(brf105.getR36_DEFAULTED() == null ? 0 : brf105.getR36_DEFAULTED().intValue());
							}
							Row row37 = sheet.getRow(45);
							Cell R37cell1 = row37.getCell(3); 
							if (R37cell1 != null) {
								R37cell1.setCellValue(brf105.getR37_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR37_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R37cell2 = row37.getCell(4); 
							if (R37cell2 != null) {
								R37cell2.setCellValue(brf105.getR37_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR37_CRWA_CONSOLIDATED().intValue());
							}
							Cell R37cell3 = row37.getCell(5); 
							if (R37cell3 != null) {
								R37cell3.setCellValue(brf105.getR37_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR37_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R37cell4 = row37.getCell(6); 
							if (R37cell4 != null) {
								R37cell4.setCellValue(brf105.getR37_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR37_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R37cell5 = row37.getCell(7); 
							if (R37cell5 != null) {
								R37cell5.setCellValue(brf105.getR37_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR37_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R37cell6 = row37.getCell(8); 
							if (R37cell6 != null) {
								R37cell6.setCellValue(brf105.getR37_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR37_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R37cell7 = row37.getCell(9); 
							if (R37cell7 != null) {
								R37cell7.setCellValue(brf105.getR37_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR37_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R37cell8 = row37.getCell(10); 
							if (R37cell8 != null) {
								R37cell8.setCellValue(brf105.getR37_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR37_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R37cell9 = row37.getCell(11); 
							if (R37cell9 != null) {
								R37cell9.setCellValue(brf105.getR37_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR37_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R37cell10 = row37.getCell(12); 
							if (R37cell10 != null) {
								R37cell10.setCellValue(brf105.getR37_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR37_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R37cell11 = row37.getCell(13); 
							if (R37cell11 != null) {
								R37cell11.setCellValue(brf105.getR37_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR37_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R37cell12 = row37.getCell(14); 
							if (R37cell12 != null) {
								R37cell12.setCellValue(brf105.getR37_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR37_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R37cell13 = row37.getCell(15); 
							if (R37cell13 != null) {
								R37cell13.setCellValue(brf105.getR37_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR37_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R37cell14 = row37.getCell(16); 
							if (R37cell14 != null) {
								R37cell14.setCellValue(brf105.getR37_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR37_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R37cell15 = row37.getCell(17); 
							if (R37cell15 != null) {
								R37cell15.setCellValue(brf105.getR37_NON_PERFORMING() == null ? 0 : brf105.getR37_NON_PERFORMING().intValue());
							}
							Cell R37cell16 = row37.getCell(18); 
							if (R37cell16 != null) {
								R37cell16.setCellValue(brf105.getR37_SPECIFIC_PROVISION() == null ? 0 : brf105.getR37_SPECIFIC_PROVISION().intValue());
							}
							Cell  R37cell17 = row37.getCell(19); 
							if (R37cell17 != null) {
								R37cell17.setCellValue(brf105.getR37_INTEREST() == null ? 0 : brf105.getR37_INTEREST().intValue());
							}
							Cell  R37cell18 = row37.getCell(20); 
							if (R37cell18 != null) {
								R37cell18.setCellValue(brf105.getR37_DEFAULTED() == null ? 0 : brf105.getR37_DEFAULTED().intValue());
							}
							Row row39 = sheet.getRow(47);
							Cell R39cell1 = row39.getCell(3); 
							if (R39cell1 != null) {
								R39cell1.setCellValue(brf105.getR39_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR39_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R39cell2 = row39.getCell(4); 
							if (R39cell2 != null) {
								R39cell2.setCellValue(brf105.getR39_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR39_CRWA_CONSOLIDATED().intValue());
							}
							Cell R39cell3 = row39.getCell(5); 
							if (R39cell3 != null) {
								R39cell3.setCellValue(brf105.getR39_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR39_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R39cell4 = row39.getCell(6); 
							if (R39cell4 != null) {
								R39cell4.setCellValue(brf105.getR39_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR39_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R39cell5 = row39.getCell(7); 
							if (R39cell5 != null) {
								R39cell5.setCellValue(brf105.getR39_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR39_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R39cell6 = row39.getCell(8); 
							if (R39cell6 != null) {
								R39cell6.setCellValue(brf105.getR39_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR39_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R39cell7 = row39.getCell(9); 
							if (R39cell7 != null) {
								R39cell7.setCellValue(brf105.getR39_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR39_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R39cell8 = row39.getCell(10); 
							if (R39cell8 != null) {
								R39cell8.setCellValue(brf105.getR39_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR39_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R39cell9 = row39.getCell(11); 
							if (R39cell9 != null) {
								R39cell9.setCellValue(brf105.getR39_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR39_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R39cell10 = row39.getCell(12); 
							if (R39cell10 != null) {
								R39cell10.setCellValue(brf105.getR39_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR39_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R39cell11 = row39.getCell(13); 
							if (R39cell11 != null) {
								R39cell11.setCellValue(brf105.getR39_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR39_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R39cell12 = row39.getCell(14); 
							if (R39cell12 != null) {
								R39cell12.setCellValue(brf105.getR39_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR39_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R39cell13 = row39.getCell(15); 
							if (R39cell13 != null) {
								R39cell13.setCellValue(brf105.getR39_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR39_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R39cell14 = row39.getCell(16); 
							if (R39cell14 != null) {
								R39cell14.setCellValue(brf105.getR39_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR39_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R39cell15 = row39.getCell(17); 
							if (R39cell15 != null) {
								R39cell15.setCellValue(brf105.getR39_NON_PERFORMING() == null ? 0 : brf105.getR39_NON_PERFORMING().intValue());
							}
							Cell R39cell16 = row39.getCell(18); 
							if (R39cell16 != null) {
								R39cell16.setCellValue(brf105.getR39_SPECIFIC_PROVISION() == null ? 0 : brf105.getR39_SPECIFIC_PROVISION().intValue());
							}
							Cell  R39cell17 = row39.getCell(19); 
							if (R39cell17 != null) {
								R39cell17.setCellValue(brf105.getR39_INTEREST() == null ? 0 : brf105.getR39_INTEREST().intValue());
							}
							Cell  R39cell18 = row39.getCell(20); 
							if (R39cell18 != null) {
								R39cell18.setCellValue(brf105.getR39_DEFAULTED() == null ? 0 : brf105.getR39_DEFAULTED().intValue());
							}
							Row row40 = sheet.getRow(48);
							Cell R40cell1 = row40.getCell(3); 
							if (R40cell1 != null) {
								R40cell1.setCellValue(brf105.getR40_TOTAL_CONSOLIDATED() == null ? 0 : brf105.getR40_TOTAL_CONSOLIDATED().intValue());
							}
							Cell R40cell2 = row40.getCell(4); 
							if (R40cell2 != null) {
								R40cell2.setCellValue(brf105.getR40_CRWA_CONSOLIDATED() == null ? 0 : brf105.getR40_CRWA_CONSOLIDATED().intValue());
							}
							Cell R40cell3 = row40.getCell(5); 
							if (R40cell3 != null) {
								R40cell3.setCellValue(brf105.getR40_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105.getR40_EXPOSURE_RESIDENT_UAE().intValue());
							}
							Cell R40cell4 = row40.getCell(6); 
							if (R40cell4 != null) {
								R40cell4.setCellValue(brf105.getR40_CRWA_RESIDENT_UAE() == null ? 0 : brf105.getR40_CRWA_RESIDENT_UAE().intValue());
							}
							Cell R40cell5 = row40.getCell(7); 
							if (R40cell5 != null) {
								R40cell5.setCellValue(brf105.getR40_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105.getR40_EXPOSURE_NON_RESIDENT_UAE().intValue());
							}
							Cell R40cell6 = row40.getCell(8); 
							if (R40cell6 != null) {
								R40cell6.setCellValue(brf105.getR40_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105.getR40_CRWA_NON_RESIDENT_UAE().intValue());
							}
							Cell R40cell7 = row40.getCell(9); 
							if (R40cell7 != null) {
								R40cell7.setCellValue(brf105.getR40_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105.getR40_EXPOSURE_RESIDENT_NON_UAE().intValue());
							}
							Cell R40cell8 = row40.getCell(10); 
							if (R40cell8 != null) {
								R40cell8.setCellValue(brf105.getR40_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105.getR40_CRWA_RESIDENT_NON_UAE().intValue());
							}
							Cell R40cell9 = row40.getCell(11); 
							if (R40cell9 != null) {
								R40cell9.setCellValue(brf105.getR40_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR40_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R40cell10 = row40.getCell(12); 
							if (R40cell10 != null) {
								R40cell10.setCellValue(brf105.getR40_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105.getR40_CRWA_NON_RESIDENT_NON_UAE().intValue());
							}
							Cell R40cell11 = row40.getCell(13); 
							if (R40cell11 != null) {
								R40cell11.setCellValue(brf105.getR40_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR40_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R40cell12 = row40.getCell(14); 
							if (R40cell12 != null) {
								R40cell12.setCellValue(brf105.getR40_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105.getR40_CRWA_INSIDE_CONSOLIDATED().intValue());
							}
							Cell R40cell13 = row40.getCell(15); 
							if (R40cell13 != null) {
								R40cell13.setCellValue(brf105.getR40_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR40_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R40cell14 = row40.getCell(16); 
							if (R40cell14 != null) {
								R40cell14.setCellValue(brf105.getR40_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105.getR40_CRWA_OUTSIDE_CONSOLIDATED().intValue());
							}
							Cell R40cell15 = row40.getCell(17); 
							if (R40cell15 != null) {
								R40cell15.setCellValue(brf105.getR40_NON_PERFORMING() == null ? 0 : brf105.getR40_NON_PERFORMING().intValue());
							}
							Cell R40cell16 = row40.getCell(18); 
							if (R40cell16 != null) {
								R40cell16.setCellValue(brf105.getR40_SPECIFIC_PROVISION() == null ? 0 : brf105.getR40_SPECIFIC_PROVISION().intValue());
							}
							Cell  R40cell17 = row40.getCell(19); 
							if (R40cell17 != null) {
								R40cell17.setCellValue(brf105.getR40_INTEREST() == null ? 0 : brf105.getR40_INTEREST().intValue());
							}
							Cell  R40cell18 = row40.getCell(20); 
							if (R40cell18 != null) {
								R40cell18.setCellValue(brf105.getR40_DEFAULTED() == null ? 0 : brf105.getR40_DEFAULTED().intValue());
							}



						}
					}
					if (T1Master1.size() == 1) {
						for (BRF105_ENTITY2 brf105a : T1Master1) {
							 Row row42 = sheet.getRow(50); 
							 Cell R42cell1 = row42.getCell(3); 
								if (R42cell1 != null) {
									R42cell1.setCellValue(brf105a.getR42_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR42_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R42cell2 = row42.getCell(4); 
								if (R42cell2 != null) {
									R42cell2.setCellValue(brf105a.getR42_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR42_CRWA_CONSOLIDATED().intValue());
								}
								Cell R42cell3 = row42.getCell(5); 
								if (R42cell3 != null) {
									R42cell3.setCellValue(brf105a.getR42_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR42_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R42cell4 = row42.getCell(6); 
								if (R42cell4 != null) {
									R42cell4.setCellValue(brf105a.getR42_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR42_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R42cell5 = row42.getCell(7); 
								if (R42cell5 != null) {
									R42cell5.setCellValue(brf105a.getR42_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR42_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R42cell6 = row42.getCell(8); 
								if (R42cell6 != null) {
									R42cell6.setCellValue(brf105a.getR42_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR42_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R42cell7 = row42.getCell(9); 
								if (R42cell7 != null) {
									R42cell7.setCellValue(brf105a.getR42_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR42_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R42cell8 = row42.getCell(10); 
								if (R42cell8 != null) {
									R42cell8.setCellValue(brf105a.getR42_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR42_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R42cell9 = row42.getCell(11); 
								if (R42cell9 != null) {
									R42cell9.setCellValue(brf105a.getR42_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR42_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R42cell10 = row42.getCell(12); 
								if (R42cell10 != null) {
									R42cell10.setCellValue(brf105a.getR42_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR42_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R42cell11 = row42.getCell(13); 
								if (R42cell11 != null) {
									R42cell11.setCellValue(brf105a.getR42_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR42_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R42cell12 = row42.getCell(14); 
								if (R42cell12 != null) {
									R42cell12.setCellValue(brf105a.getR42_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR42_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R42cell13 = row42.getCell(15); 
								if (R42cell13 != null) {
									R42cell13.setCellValue(brf105a.getR42_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR42_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R42cell14 = row42.getCell(16); 
								if (R42cell14 != null) {
									R42cell14.setCellValue(brf105a.getR42_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR42_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R42cell15 = row42.getCell(17); 
								if (R42cell15 != null) {
									R42cell15.setCellValue(brf105a.getR42_NON_PERFORMING() == null ? 0 : brf105a.getR42_NON_PERFORMING().intValue());
								}
								Cell R42cell16 = row42.getCell(18); 
								if (R42cell16 != null) {
									R42cell16.setCellValue(brf105a.getR42_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR42_SPECIFIC_PROVISION().intValue());
								}
								Cell  R42cell17 = row42.getCell(19); 
								if (R42cell17 != null) {
									R42cell17.setCellValue(brf105a.getR42_INTEREST() == null ? 0 : brf105a.getR42_INTEREST().intValue());
								}
								Cell  R42cell18 = row42.getCell(20); 
								if (R42cell18 != null) {
									R42cell18.setCellValue(brf105a.getR42_DEFAULTED() == null ? 0 : brf105a.getR42_DEFAULTED().intValue());
								}
							 Row row43 = sheet.getRow(51); 
							 Cell R43cell1 = row43.getCell(3); 
								if (R43cell1 != null) {
									R43cell1.setCellValue(brf105a.getR43_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR43_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R43cell2 = row43.getCell(4); 
								if (R43cell2 != null) {
									R43cell2.setCellValue(brf105a.getR43_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR43_CRWA_CONSOLIDATED().intValue());
								}
								Cell R43cell3 = row43.getCell(5); 
								if (R43cell3 != null) {
									R43cell3.setCellValue(brf105a.getR43_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR43_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R43cell4 = row43.getCell(6); 
								if (R43cell4 != null) {
									R43cell4.setCellValue(brf105a.getR43_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR43_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R43cell5 = row43.getCell(7); 
								if (R43cell5 != null) {
									R43cell5.setCellValue(brf105a.getR43_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR43_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R43cell6 = row43.getCell(8); 
								if (R43cell6 != null) {
									R43cell6.setCellValue(brf105a.getR43_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR43_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R43cell7 = row43.getCell(9); 
								if (R43cell7 != null) {
									R43cell7.setCellValue(brf105a.getR43_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR43_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R43cell8 = row43.getCell(10); 
								if (R43cell8 != null) {
									R43cell8.setCellValue(brf105a.getR43_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR43_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R43cell9 = row43.getCell(11); 
								if (R43cell9 != null) {
									R43cell9.setCellValue(brf105a.getR43_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR43_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R43cell10 = row43.getCell(12); 
								if (R43cell10 != null) {
									R43cell10.setCellValue(brf105a.getR43_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR43_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R43cell11 = row43.getCell(13); 
								if (R43cell11 != null) {
									R43cell11.setCellValue(brf105a.getR43_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR43_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R43cell12 = row43.getCell(14); 
								if (R43cell12 != null) {
									R43cell12.setCellValue(brf105a.getR43_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR43_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R43cell13 = row43.getCell(15); 
								if (R43cell13 != null) {
									R43cell13.setCellValue(brf105a.getR43_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR43_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R43cell14 = row43.getCell(16); 
								if (R43cell14 != null) {
									R43cell14.setCellValue(brf105a.getR43_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR43_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R43cell15 = row43.getCell(17); 
								if (R43cell15 != null) {
									R43cell15.setCellValue(brf105a.getR43_NON_PERFORMING() == null ? 0 : brf105a.getR43_NON_PERFORMING().intValue());
								}
								Cell R43cell16 = row43.getCell(18); 
								if (R43cell16 != null) {
									R43cell16.setCellValue(brf105a.getR43_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR43_SPECIFIC_PROVISION().intValue());
								}
								Cell  R43cell17 = row43.getCell(19); 
								if (R43cell17 != null) {
									R43cell17.setCellValue(brf105a.getR43_INTEREST() == null ? 0 : brf105a.getR43_INTEREST().intValue());
								}
								Cell  R43cell18 = row43.getCell(20); 
								if (R43cell18 != null) {
									R43cell18.setCellValue(brf105a.getR43_DEFAULTED() == null ? 0 : brf105a.getR43_DEFAULTED().intValue());
								}
							 Row row44 = sheet.getRow(52); 
							 Cell R44cell1 = row44.getCell(3); 
								if (R44cell1 != null) {
									R44cell1.setCellValue(brf105a.getR44_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR44_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R44cell2 = row44.getCell(4); 
								if (R44cell2 != null) {
									R44cell2.setCellValue(brf105a.getR44_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR44_CRWA_CONSOLIDATED().intValue());
								}
								Cell R44cell3 = row44.getCell(5); 
								if (R44cell3 != null) {
									R44cell3.setCellValue(brf105a.getR44_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR44_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R44cell4 = row44.getCell(6); 
								if (R44cell4 != null) {
									R44cell4.setCellValue(brf105a.getR44_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR44_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R44cell5 = row44.getCell(7); 
								if (R44cell5 != null) {
									R44cell5.setCellValue(brf105a.getR44_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR44_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R44cell6 = row44.getCell(8); 
								if (R44cell6 != null) {
									R44cell6.setCellValue(brf105a.getR44_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR44_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R44cell7 = row44.getCell(9); 
								if (R44cell7 != null) {
									R44cell7.setCellValue(brf105a.getR44_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR44_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R44cell8 = row44.getCell(10); 
								if (R44cell8 != null) {
									R44cell8.setCellValue(brf105a.getR44_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR44_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R44cell9 = row44.getCell(11); 
								if (R44cell9 != null) {
									R44cell9.setCellValue(brf105a.getR44_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR44_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R44cell10 = row44.getCell(12); 
								if (R44cell10 != null) {
									R44cell10.setCellValue(brf105a.getR44_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR44_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R44cell11 = row44.getCell(13); 
								if (R44cell11 != null) {
									R44cell11.setCellValue(brf105a.getR44_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR44_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R44cell12 = row44.getCell(14); 
								if (R44cell12 != null) {
									R44cell12.setCellValue(brf105a.getR44_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR44_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R44cell13 = row44.getCell(15); 
								if (R44cell13 != null) {
									R44cell13.setCellValue(brf105a.getR44_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR44_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R44cell14 = row44.getCell(16); 
								if (R44cell14 != null) {
									R44cell14.setCellValue(brf105a.getR44_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR44_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R44cell15 = row44.getCell(17); 
								if (R44cell15 != null) {
									R44cell15.setCellValue(brf105a.getR44_NON_PERFORMING() == null ? 0 : brf105a.getR44_NON_PERFORMING().intValue());
								}
								Cell R44cell16 = row44.getCell(18); 
								if (R44cell16 != null) {
									R44cell16.setCellValue(brf105a.getR44_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR44_SPECIFIC_PROVISION().intValue());
								}
								Cell  R44cell17 = row44.getCell(19); 
								if (R44cell17 != null) {
									R44cell17.setCellValue(brf105a.getR44_INTEREST() == null ? 0 : brf105a.getR44_INTEREST().intValue());
								}
								Cell  R44cell18 = row44.getCell(20); 
								if (R44cell18 != null) {
									R44cell18.setCellValue(brf105a.getR44_DEFAULTED() == null ? 0 : brf105a.getR44_DEFAULTED().intValue());
								}
                             Row row46 = sheet.getRow(54); 
                             Cell R46cell1 = row46.getCell(3); 
 							if (R46cell1 != null) {
 								R46cell1.setCellValue(brf105a.getR46_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR46_TOTAL_CONSOLIDATED().intValue());
 							}
 							Cell R46cell2 = row46.getCell(4); 
 							if (R46cell2 != null) {
 								R46cell2.setCellValue(brf105a.getR46_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR46_CRWA_CONSOLIDATED().intValue());
 							}
 							Cell R46cell3 = row46.getCell(5); 
 							if (R46cell3 != null) {
 								R46cell3.setCellValue(brf105a.getR46_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR46_EXPOSURE_RESIDENT_UAE().intValue());
 							}
 							Cell R46cell4 = row46.getCell(6); 
 							if (R46cell4 != null) {
 								R46cell4.setCellValue(brf105a.getR46_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR46_CRWA_RESIDENT_UAE().intValue());
 							}
 							Cell R46cell5 = row46.getCell(7); 
 							if (R46cell5 != null) {
 								R46cell5.setCellValue(brf105a.getR46_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR46_EXPOSURE_NON_RESIDENT_UAE().intValue());
 							}
 							Cell R46cell6 = row46.getCell(8); 
 							if (R46cell6 != null) {
 								R46cell6.setCellValue(brf105a.getR46_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR46_CRWA_NON_RESIDENT_UAE().intValue());
 							}
 							Cell R46cell7 = row46.getCell(9); 
 							if (R46cell7 != null) {
 								R46cell7.setCellValue(brf105a.getR46_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR46_EXPOSURE_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R46cell8 = row46.getCell(10); 
 							if (R46cell8 != null) {
 								R46cell8.setCellValue(brf105a.getR46_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR46_CRWA_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R46cell9 = row46.getCell(11); 
 							if (R46cell9 != null) {
 								R46cell9.setCellValue(brf105a.getR46_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR46_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R46cell10 = row46.getCell(12); 
 							if (R46cell10 != null) {
 								R46cell10.setCellValue(brf105a.getR46_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR46_CRWA_NON_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R46cell11 = row46.getCell(13); 
 							if (R46cell11 != null) {
 								R46cell11.setCellValue(brf105a.getR46_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR46_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R46cell12 = row46.getCell(14); 
 							if (R46cell12 != null) {
 								R46cell12.setCellValue(brf105a.getR46_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR46_CRWA_INSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R46cell13 = row46.getCell(15); 
 							if (R46cell13 != null) {
 								R46cell13.setCellValue(brf105a.getR46_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR46_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R46cell14 = row46.getCell(16); 
 							if (R46cell14 != null) {
 								R46cell14.setCellValue(brf105a.getR46_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR46_CRWA_OUTSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R46cell15 = row46.getCell(17); 
 							if (R46cell15 != null) {
 								R46cell15.setCellValue(brf105a.getR46_NON_PERFORMING() == null ? 0 : brf105a.getR46_NON_PERFORMING().intValue());
 							}
 							Cell R46cell16 = row46.getCell(18); 
 							if (R46cell16 != null) {
 								R46cell16.setCellValue(brf105a.getR46_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR46_SPECIFIC_PROVISION().intValue());
 							}
 							Cell  R46cell17 = row46.getCell(19); 
 							if (R46cell17 != null) {
 								R46cell17.setCellValue(brf105a.getR46_INTEREST() == null ? 0 : brf105a.getR46_INTEREST().intValue());
 							}
 							Cell  R46cell18 = row46.getCell(20); 
 							if (R46cell18 != null) {
 								R46cell18.setCellValue(brf105a.getR46_DEFAULTED() == null ? 0 : brf105a.getR46_DEFAULTED().intValue());
 							}
							 Row row47 = sheet.getRow(55); 
							 Cell R47cell1 = row47.getCell(3); 
								if (R47cell1 != null) {
									R47cell1.setCellValue(brf105a.getR47_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR47_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R47cell2 = row47.getCell(4); 
								if (R47cell2 != null) {
									R47cell2.setCellValue(brf105a.getR47_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR47_CRWA_CONSOLIDATED().intValue());
								}
								Cell R47cell3 = row47.getCell(5); 
								if (R47cell3 != null) {
									R47cell3.setCellValue(brf105a.getR47_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR47_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R47cell4 = row47.getCell(6); 
								if (R47cell4 != null) {
									R47cell4.setCellValue(brf105a.getR47_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR47_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R47cell5 = row47.getCell(7); 
								if (R47cell5 != null) {
									R47cell5.setCellValue(brf105a.getR47_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR47_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R47cell6 = row47.getCell(8); 
								if (R47cell6 != null) {
									R47cell6.setCellValue(brf105a.getR47_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR47_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R47cell7 = row47.getCell(9); 
								if (R47cell7 != null) {
									R47cell7.setCellValue(brf105a.getR47_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR47_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R47cell8 = row47.getCell(10); 
								if (R47cell8 != null) {
									R47cell8.setCellValue(brf105a.getR47_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR47_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R47cell9 = row47.getCell(11); 
								if (R47cell9 != null) {
									R47cell9.setCellValue(brf105a.getR47_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR47_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R47cell10 = row47.getCell(12); 
								if (R47cell10 != null) {
									R47cell10.setCellValue(brf105a.getR47_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR47_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R47cell11 = row47.getCell(13); 
								if (R47cell11 != null) {
									R47cell11.setCellValue(brf105a.getR47_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR47_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R47cell12 = row47.getCell(14); 
								if (R47cell12 != null) {
									R47cell12.setCellValue(brf105a.getR47_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR47_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R47cell13 = row47.getCell(15); 
								if (R47cell13 != null) {
									R47cell13.setCellValue(brf105a.getR47_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR47_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R47cell14 = row47.getCell(16); 
								if (R47cell14 != null) {
									R47cell14.setCellValue(brf105a.getR47_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR47_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R47cell15 = row47.getCell(17); 
								if (R47cell15 != null) {
									R47cell15.setCellValue(brf105a.getR47_NON_PERFORMING() == null ? 0 : brf105a.getR47_NON_PERFORMING().intValue());
								}
								Cell R47cell16 = row47.getCell(18); 
								if (R47cell16 != null) {
									R47cell16.setCellValue(brf105a.getR47_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR47_SPECIFIC_PROVISION().intValue());
								}
								Cell  R47cell17 = row47.getCell(19); 
								if (R47cell17 != null) {
									R47cell17.setCellValue(brf105a.getR47_INTEREST() == null ? 0 : brf105a.getR47_INTEREST().intValue());
								}
								Cell  R47cell18 = row47.getCell(20); 
								if (R47cell18 != null) {
									R47cell18.setCellValue(brf105a.getR47_DEFAULTED() == null ? 0 : brf105a.getR47_DEFAULTED().intValue());
								}
							 Row row48 = sheet.getRow(56); 
							 Cell R48cell1 = row48.getCell(3); 
								if (R48cell1 != null) {
									R48cell1.setCellValue(brf105a.getR48_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR48_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R48cell2 = row48.getCell(4); 
								if (R48cell2 != null) {
									R48cell2.setCellValue(brf105a.getR48_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR48_CRWA_CONSOLIDATED().intValue());
								}
								Cell R48cell3 = row48.getCell(5); 
								if (R48cell3 != null) {
									R48cell3.setCellValue(brf105a.getR48_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR48_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R48cell4 = row48.getCell(6); 
								if (R48cell4 != null) {
									R48cell4.setCellValue(brf105a.getR48_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR48_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R48cell5 = row48.getCell(7); 
								if (R48cell5 != null) {
									R48cell5.setCellValue(brf105a.getR48_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR48_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R48cell6 = row48.getCell(8); 
								if (R48cell6 != null) {
									R48cell6.setCellValue(brf105a.getR48_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR48_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R48cell7 = row48.getCell(9); 
								if (R48cell7 != null) {
									R48cell7.setCellValue(brf105a.getR48_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR48_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R48cell8 = row48.getCell(10); 
								if (R48cell8 != null) {
									R48cell8.setCellValue(brf105a.getR48_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR48_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R48cell9 = row48.getCell(11); 
								if (R48cell9 != null) {
									R48cell9.setCellValue(brf105a.getR48_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR48_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R48cell10 = row48.getCell(12); 
								if (R48cell10 != null) {
									R48cell10.setCellValue(brf105a.getR48_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR48_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R48cell11 = row48.getCell(13); 
								if (R48cell11 != null) {
									R48cell11.setCellValue(brf105a.getR48_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR48_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R48cell12 = row48.getCell(14); 
								if (R48cell12 != null) {
									R48cell12.setCellValue(brf105a.getR48_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR48_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R48cell13 = row48.getCell(15); 
								if (R48cell13 != null) {
									R48cell13.setCellValue(brf105a.getR48_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR48_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R48cell14 = row48.getCell(16); 
								if (R48cell14 != null) {
									R48cell14.setCellValue(brf105a.getR48_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR48_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R48cell15 = row48.getCell(17); 
								if (R48cell15 != null) {
									R48cell15.setCellValue(brf105a.getR48_NON_PERFORMING() == null ? 0 : brf105a.getR48_NON_PERFORMING().intValue());
								}
								Cell R48cell16 = row48.getCell(18); 
								if (R48cell16 != null) {
									R48cell16.setCellValue(brf105a.getR48_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR48_SPECIFIC_PROVISION().intValue());
								}
								Cell  R48cell17 = row48.getCell(19); 
								if (R48cell17 != null) {
									R48cell17.setCellValue(brf105a.getR48_INTEREST() == null ? 0 : brf105a.getR48_INTEREST().intValue());
								}
								Cell  R48cell18 = row48.getCell(20); 
								if (R48cell18 != null) {
									R48cell18.setCellValue(brf105a.getR48_DEFAULTED() == null ? 0 : brf105a.getR48_DEFAULTED().intValue());
								}
                             Row row49 = sheet.getRow(57); 
                             Cell R49cell1 = row49.getCell(3); 
 							if (R49cell1 != null) {
 								R49cell1.setCellValue(brf105a.getR49_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR49_TOTAL_CONSOLIDATED().intValue());
 							}
 							Cell R49cell2 = row49.getCell(4); 
 							if (R49cell2 != null) {
 								R49cell2.setCellValue(brf105a.getR49_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR49_CRWA_CONSOLIDATED().intValue());
 							}
 							Cell R49cell3 = row49.getCell(5); 
 							if (R49cell3 != null) {
 								R49cell3.setCellValue(brf105a.getR49_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR49_EXPOSURE_RESIDENT_UAE().intValue());
 							}
 							Cell R49cell4 = row49.getCell(6); 
 							if (R49cell4 != null) {
 								R49cell4.setCellValue(brf105a.getR49_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR49_CRWA_RESIDENT_UAE().intValue());
 							}
 							Cell R49cell5 = row49.getCell(7); 
 							if (R49cell5 != null) {
 								R49cell5.setCellValue(brf105a.getR49_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR49_EXPOSURE_NON_RESIDENT_UAE().intValue());
 							}
 							Cell R49cell6 = row49.getCell(8); 
 							if (R49cell6 != null) {
 								R49cell6.setCellValue(brf105a.getR49_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR49_CRWA_NON_RESIDENT_UAE().intValue());
 							}
 							Cell R49cell7 = row49.getCell(9); 
 							if (R49cell7 != null) {
 								R49cell7.setCellValue(brf105a.getR49_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR49_EXPOSURE_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R49cell8 = row49.getCell(10); 
 							if (R49cell8 != null) {
 								R49cell8.setCellValue(brf105a.getR49_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR49_CRWA_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R49cell9 = row49.getCell(11); 
 							if (R49cell9 != null) {
 								R49cell9.setCellValue(brf105a.getR49_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR49_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R49cell10 = row49.getCell(12); 
 							if (R49cell10 != null) {
 								R49cell10.setCellValue(brf105a.getR49_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR49_CRWA_NON_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R49cell11 = row49.getCell(13); 
 							if (R49cell11 != null) {
 								R49cell11.setCellValue(brf105a.getR49_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR49_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R49cell12 = row49.getCell(14); 
 							if (R49cell12 != null) {
 								R49cell12.setCellValue(brf105a.getR49_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR49_CRWA_INSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R49cell13 = row49.getCell(15); 
 							if (R49cell13 != null) {
 								R49cell13.setCellValue(brf105a.getR49_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR49_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R49cell14 = row49.getCell(16); 
 							if (R49cell14 != null) {
 								R49cell14.setCellValue(brf105a.getR49_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR49_CRWA_OUTSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R49cell15 = row49.getCell(17); 
 							if (R49cell15 != null) {
 								R49cell15.setCellValue(brf105a.getR49_NON_PERFORMING() == null ? 0 : brf105a.getR49_NON_PERFORMING().intValue());
 							}
 							Cell R49cell16 = row49.getCell(18); 
 							if (R49cell16 != null) {
 								R49cell16.setCellValue(brf105a.getR49_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR49_SPECIFIC_PROVISION().intValue());
 							}
 							Cell  R49cell17 = row49.getCell(19); 
 							if (R49cell17 != null) {
 								R49cell17.setCellValue(brf105a.getR49_INTEREST() == null ? 0 : brf105a.getR49_INTEREST().intValue());
 							}
 							Cell  R49cell18 = row49.getCell(20); 
 							if (R49cell18 != null) {
 								R49cell18.setCellValue(brf105a.getR49_DEFAULTED() == null ? 0 : brf105a.getR49_DEFAULTED().intValue());
 							}
							 Row row50 = sheet.getRow(58); 
							 Cell R50cell1 = row50.getCell(3); 
								if (R50cell1 != null) {
									R50cell1.setCellValue(brf105a.getR50_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR50_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R50cell2 = row50.getCell(4); 
								if (R50cell2 != null) {
									R50cell2.setCellValue(brf105a.getR50_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR50_CRWA_CONSOLIDATED().intValue());
								}
								Cell R50cell3 = row50.getCell(5); 
								if (R50cell3 != null) {
									R50cell3.setCellValue(brf105a.getR50_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR50_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R50cell4 = row50.getCell(6); 
								if (R50cell4 != null) {
									R50cell4.setCellValue(brf105a.getR50_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR50_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R50cell5 = row50.getCell(7); 
								if (R50cell5 != null) {
									R50cell5.setCellValue(brf105a.getR50_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR50_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R50cell6 = row50.getCell(8); 
								if (R50cell6 != null) {
									R50cell6.setCellValue(brf105a.getR50_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR50_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R50cell7 = row50.getCell(9); 
								if (R50cell7 != null) {
									R50cell7.setCellValue(brf105a.getR50_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR50_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R50cell8 = row50.getCell(10); 
								if (R50cell8 != null) {
									R50cell8.setCellValue(brf105a.getR50_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR50_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R50cell9 = row50.getCell(11); 
								if (R50cell9 != null) {
									R50cell9.setCellValue(brf105a.getR50_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR50_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R50cell10 = row50.getCell(12); 
								if (R50cell10 != null) {
									R50cell10.setCellValue(brf105a.getR50_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR50_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R50cell11 = row50.getCell(13); 
								if (R50cell11 != null) {
									R50cell11.setCellValue(brf105a.getR50_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR50_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R50cell12 = row50.getCell(14); 
								if (R50cell12 != null) {
									R50cell12.setCellValue(brf105a.getR50_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR50_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R50cell13 = row50.getCell(15); 
								if (R50cell13 != null) {
									R50cell13.setCellValue(brf105a.getR50_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR50_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R50cell14 = row50.getCell(16); 
								if (R50cell14 != null) {
									R50cell14.setCellValue(brf105a.getR50_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR50_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R50cell15 = row50.getCell(17); 
								if (R50cell15 != null) {
									R50cell15.setCellValue(brf105a.getR50_NON_PERFORMING() == null ? 0 : brf105a.getR50_NON_PERFORMING().intValue());
								}
								Cell R50cell16 = row50.getCell(18); 
								if (R50cell16 != null) {
									R50cell16.setCellValue(brf105a.getR50_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR50_SPECIFIC_PROVISION().intValue());
								}
								Cell  R50cell17 = row50.getCell(19); 
								if (R50cell17 != null) {
									R50cell17.setCellValue(brf105a.getR50_INTEREST() == null ? 0 : brf105a.getR50_INTEREST().intValue());
								}
								Cell  R50cell18 = row50.getCell(20); 
								if (R50cell18 != null) {
									R50cell18.setCellValue(brf105a.getR50_DEFAULTED() == null ? 0 : brf105a.getR50_DEFAULTED().intValue());
								}
							 Row row52 = sheet.getRow(60); 
								/*
								 * Cell R52cell1 = row52.getCell(3); if (R52cell1 != null) {
								 * R52cell1.setCellValue(brf105a.getR52_TOTAL_CONSOLIDATED() == null ? 0 :
								 * brf105a.getR52_TOTAL_CONSOLIDATED().intValue()); }
								 */
								Cell R52cell2 = row52.getCell(4); 
								if (R52cell2 != null) {
									R52cell2.setCellValue(brf105a.getR52_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR52_CRWA_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R52cell3 = row52.getCell(5); if (R52cell3 != null) {
								 * R52cell3.setCellValue(brf105a.getR52_EXPOSURE_RESIDENT_UAE() == null ? 0 :
								 * brf105a.getR52_EXPOSURE_RESIDENT_UAE().intValue()); }
								 */
								Cell R52cell4 = row52.getCell(6); 
								if (R52cell4 != null) {
									R52cell4.setCellValue(brf105a.getR52_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR52_CRWA_RESIDENT_UAE().intValue());
								}
								/*
								 * Cell R52cell5 = row52.getCell(7); if (R52cell5 != null) {
								 * R52cell5.setCellValue(brf105a.getR52_EXPOSURE_NON_RESIDENT_UAE() == null ? 0
								 * : brf105a.getR52_EXPOSURE_NON_RESIDENT_UAE().intValue()); }
								 */
								Cell R52cell6 = row52.getCell(8); 
								if (R52cell6 != null) {
									R52cell6.setCellValue(brf105a.getR52_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR52_CRWA_NON_RESIDENT_UAE().intValue());
								}
								/*
								 * Cell R52cell7 = row52.getCell(9); if (R52cell7 != null) {
								 * R52cell7.setCellValue(brf105a.getR52_EXPOSURE_RESIDENT_NON_UAE() == null ? 0
								 * : brf105a.getR52_EXPOSURE_RESIDENT_NON_UAE().intValue()); }
								 */
								Cell R52cell8 = row52.getCell(10); 
								if (R52cell8 != null) {
									R52cell8.setCellValue(brf105a.getR52_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR52_CRWA_RESIDENT_NON_UAE().intValue());
								}
								/*
								 * Cell R52cell9 = row52.getCell(11); if (R52cell9 != null) {
								 * R52cell9.setCellValue(brf105a.getR52_EXPOSURE_NON_RESIDENT_NON_UAE() == null
								 * ? 0 : brf105a.getR52_EXPOSURE_NON_RESIDENT_NON_UAE().intValue()); }
								 */
								Cell R52cell10 = row52.getCell(12); 
								if (R52cell10 != null) {
									R52cell10.setCellValue(brf105a.getR52_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR52_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								/*
								 * Cell R52cell11 = row52.getCell(13); if (R52cell11 != null) {
								 * R52cell11.setCellValue(brf105a.getR52_EXPOSURE_INSIDE_CONSOLIDATED() == null
								 * ? 0 : brf105a.getR52_EXPOSURE_INSIDE_CONSOLIDATED().intValue()); }
								 */
								Cell R52cell12 = row52.getCell(14); 
								if (R52cell12 != null) {
									R52cell12.setCellValue(brf105a.getR52_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR52_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R52cell13 = row52.getCell(15); if (R52cell13 != null) {
								 * R52cell13.setCellValue(brf105a.getR52_EXPOSURE_OUTSIDE_CONSOLIDATED() == null
								 * ? 0 : brf105a.getR52_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue()); }
								 */
								Cell R52cell14 = row52.getCell(16); 
								if (R52cell14 != null) {
									R52cell14.setCellValue(brf105a.getR52_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR52_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R52cell15 = row52.getCell(17); if (R52cell15 != null) {
								 * R52cell15.setCellValue(brf105a.getR52_NON_PERFORMING() == null ? 0 :
								 * brf105a.getR52_NON_PERFORMING().intValue()); } Cell R52cell16 =
								 * row52.getCell(18); if (R52cell16 != null) {
								 * R52cell16.setCellValue(brf105a.getR52_SPECIFIC_PROVISION() == null ? 0 :
								 * brf105a.getR52_SPECIFIC_PROVISION().intValue()); } Cell R52cell17 =
								 * row52.getCell(19); if (R52cell17 != null) {
								 * R52cell17.setCellValue(brf105a.getR52_INTEREST() == null ? 0 :
								 * brf105a.getR52_INTEREST().intValue()); }
								 */
								Cell  R52cell18 = row52.getCell(20); 
								if (R52cell18 != null) {
									R52cell18.setCellValue(brf105a.getR52_DEFAULTED() == null ? 0 : brf105a.getR52_DEFAULTED().intValue());
								}
							 Row row53 = sheet.getRow(61); 
							 Cell R53cell1 = row53.getCell(3); 
								if (R53cell1 != null) {
									R53cell1.setCellValue(brf105a.getR53_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR53_TOTAL_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R53cell2 = row53.getCell(4); if (R53cell2 != null) {
								 * R53cell2.setCellValue(brf105a.getR53_CRWA_CONSOLIDATED() == null ? 0 :
								 * brf105a.getR53_CRWA_CONSOLIDATED().intValue()); }
								 */
								Cell R53cell3 = row53.getCell(5); 
								if (R53cell3 != null) {
									R53cell3.setCellValue(brf105a.getR53_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR53_EXPOSURE_RESIDENT_UAE().intValue());
								}
								/*
								 * Cell R53cell4 = row53.getCell(6); if (R53cell4 != null) {
								 * R53cell4.setCellValue(brf105a.getR53_CRWA_RESIDENT_UAE() == null ? 0 :
								 * brf105a.getR53_CRWA_RESIDENT_UAE().intValue()); }
								 */
								Cell R53cell5 = row53.getCell(7); 
								if (R53cell5 != null) {
									R53cell5.setCellValue(brf105a.getR53_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR53_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								/*
								 * Cell R53cell6 = row53.getCell(8); if (R53cell6 != null) {
								 * R53cell6.setCellValue(brf105a.getR53_CRWA_NON_RESIDENT_UAE() == null ? 0 :
								 * brf105a.getR53_CRWA_NON_RESIDENT_UAE().intValue()); }
								 */
								Cell R53cell7 = row53.getCell(9); 
								if (R53cell7 != null) {
									R53cell7.setCellValue(brf105a.getR53_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR53_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								/*
								 * Cell R53cell8 = row53.getCell(10); if (R53cell8 != null) {
								 * R53cell8.setCellValue(brf105a.getR53_CRWA_RESIDENT_NON_UAE() == null ? 0 :
								 * brf105a.getR53_CRWA_RESIDENT_NON_UAE().intValue()); }
								 */
								Cell R53cell9 = row53.getCell(11); 
								if (R53cell9 != null) {
									R53cell9.setCellValue(brf105a.getR53_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR53_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								/*
								 * Cell R53cell10 = row53.getCell(12); if (R53cell10 != null) {
								 * R53cell10.setCellValue(brf105a.getR53_CRWA_NON_RESIDENT_NON_UAE() == null ? 0
								 * : brf105a.getR53_CRWA_NON_RESIDENT_NON_UAE().intValue()); }
								 */
								Cell R53cell11 = row53.getCell(13); 
								if (R53cell11 != null) {
									R53cell11.setCellValue(brf105a.getR53_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR53_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R53cell12 = row53.getCell(14); if (R53cell12 != null) {
								 * R53cell12.setCellValue(brf105a.getR53_CRWA_INSIDE_CONSOLIDATED() == null ? 0
								 * : brf105a.getR53_CRWA_INSIDE_CONSOLIDATED().intValue()); }
								 */
								Cell R53cell13 = row53.getCell(15); 
								if (R53cell13 != null) {
									R53cell13.setCellValue(brf105a.getR53_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR53_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R53cell14 = row53.getCell(16); if (R53cell14 != null) {
								 * R53cell14.setCellValue(brf105a.getR53_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0
								 * : brf105a.getR53_CRWA_OUTSIDE_CONSOLIDATED().intValue()); }
								 */
								Cell R53cell15 = row53.getCell(17); 
								if (R53cell15 != null) {
									R53cell15.setCellValue(brf105a.getR53_NON_PERFORMING() == null ? 0 : brf105a.getR53_NON_PERFORMING().intValue());
								}
								Cell R53cell16 = row53.getCell(18); 
								if (R53cell16 != null) {
									R53cell16.setCellValue(brf105a.getR53_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR53_SPECIFIC_PROVISION().intValue());
								}
								Cell  R53cell17 = row53.getCell(19); 
								if (R53cell17 != null) {
									R53cell17.setCellValue(brf105a.getR53_INTEREST() == null ? 0 : brf105a.getR53_INTEREST().intValue());
								}
								Cell  R53cell18 = row53.getCell(20); 
								if (R53cell18 != null) {
									R53cell18.setCellValue(brf105a.getR53_DEFAULTED() == null ? 0 : brf105a.getR53_DEFAULTED().intValue());
								}
							 Row row54 = sheet.getRow(62); 
							 Cell R54cell1 = row54.getCell(3); 
								if (R54cell1 != null) {
									R54cell1.setCellValue(brf105a.getR54_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR54_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R54cell2 = row54.getCell(4); 
								if (R54cell2 != null) {
									R54cell2.setCellValue(brf105a.getR54_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR54_CRWA_CONSOLIDATED().intValue());
								}
								/*
								 * Cell R54cell3 = row54.getCell(5); if (R54cell3 != null) {
								 * R54cell3.setCellValue(brf105a.getR54_EXPOSURE_RESIDENT_UAE() == null ? 0 :
								 * brf105a.getR54_EXPOSURE_RESIDENT_UAE().intValue()); } Cell R54cell4 =
								 * row54.getCell(6); if (R54cell4 != null) {
								 * R54cell4.setCellValue(brf105a.getR54_CRWA_RESIDENT_UAE() == null ? 0 :
								 * brf105a.getR54_CRWA_RESIDENT_UAE().intValue()); } Cell R54cell5 =
								 * row54.getCell(7); if (R54cell5 != null) {
								 * R54cell5.setCellValue(brf105a.getR54_EXPOSURE_NON_RESIDENT_UAE() == null ? 0
								 * : brf105a.getR54_EXPOSURE_NON_RESIDENT_UAE().intValue()); } Cell R54cell6 =
								 * row54.getCell(8); if (R54cell6 != null) {
								 * R54cell6.setCellValue(brf105a.getR54_CRWA_NON_RESIDENT_UAE() == null ? 0 :
								 * brf105a.getR54_CRWA_NON_RESIDENT_UAE().intValue()); } Cell R54cell7 =
								 * row54.getCell(9); if (R54cell7 != null) {
								 * R54cell7.setCellValue(brf105a.getR54_EXPOSURE_RESIDENT_NON_UAE() == null ? 0
								 * : brf105a.getR54_EXPOSURE_RESIDENT_NON_UAE().intValue()); } Cell R54cell8 =
								 * row54.getCell(10); if (R54cell8 != null) {
								 * R54cell8.setCellValue(brf105a.getR54_CRWA_RESIDENT_NON_UAE() == null ? 0 :
								 * brf105a.getR54_CRWA_RESIDENT_NON_UAE().intValue()); } Cell R54cell9 =
								 * row54.getCell(11); if (R54cell9 != null) {
								 * R54cell9.setCellValue(brf105a.getR54_EXPOSURE_NON_RESIDENT_NON_UAE() == null
								 * ? 0 : brf105a.getR54_EXPOSURE_NON_RESIDENT_NON_UAE().intValue()); } Cell
								 * R54cell10 = row54.getCell(12); if (R54cell10 != null) {
								 * R54cell10.setCellValue(brf105a.getR54_CRWA_NON_RESIDENT_NON_UAE() == null ? 0
								 * : brf105a.getR54_CRWA_NON_RESIDENT_NON_UAE().intValue()); }
								 */
								Cell R54cell11 = row54.getCell(13); 
								if (R54cell11 != null) {
									R54cell11.setCellValue(brf105a.getR54_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR54_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R54cell12 = row54.getCell(14); 
								if (R54cell12 != null) {
									R54cell12.setCellValue(brf105a.getR54_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR54_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R54cell13 = row54.getCell(15); 
								if (R54cell13 != null) {
									R54cell13.setCellValue(brf105a.getR54_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR54_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R54cell14 = row54.getCell(16); 
								if (R54cell14 != null) {
									R54cell14.setCellValue(brf105a.getR54_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR54_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R54cell15 = row54.getCell(17); 
								if (R54cell15 != null) {
									R54cell15.setCellValue(brf105a.getR54_NON_PERFORMING() == null ? 0 : brf105a.getR54_NON_PERFORMING().intValue());
								}
								Cell R54cell16 = row54.getCell(18); 
								if (R54cell16 != null) {
									R54cell16.setCellValue(brf105a.getR54_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR54_SPECIFIC_PROVISION().intValue());
								}
								Cell  R54cell17 = row54.getCell(19); 
								if (R54cell17 != null) {
									R54cell17.setCellValue(brf105a.getR54_INTEREST() == null ? 0 : brf105a.getR54_INTEREST().intValue());
								}
								Cell  R54cell18 = row54.getCell(20); 
								if (R54cell18 != null) {
									R54cell18.setCellValue(brf105a.getR54_DEFAULTED() == null ? 0 : brf105a.getR54_DEFAULTED().intValue());
								}
                             Row row57 = sheet.getRow(68); 
                             Cell R57cell1 = row57.getCell(3); 
 							if (R57cell1 != null) {
 								R57cell1.setCellValue(brf105a.getR57_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR57_TOTAL_CONSOLIDATED().intValue());
 							}
 							Cell R57cell2 = row57.getCell(4); 
 							if (R57cell2 != null) {
 								R57cell2.setCellValue(brf105a.getR57_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR57_CRWA_CONSOLIDATED().intValue());
 							}
 							Cell R57cell3 = row57.getCell(5); 
 							if (R57cell3 != null) {
 								R57cell3.setCellValue(brf105a.getR57_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR57_EXPOSURE_RESIDENT_UAE().intValue());
 							}
 							Cell R57cell4 = row57.getCell(6); 
 							if (R57cell4 != null) {
 								R57cell4.setCellValue(brf105a.getR57_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR57_CRWA_RESIDENT_UAE().intValue());
 							}
 							Cell R57cell5 = row57.getCell(7); 
 							if (R57cell5 != null) {
 								R57cell5.setCellValue(brf105a.getR57_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR57_EXPOSURE_NON_RESIDENT_UAE().intValue());
 							}
 							Cell R57cell6 = row57.getCell(8); 
 							if (R57cell6 != null) {
 								R57cell6.setCellValue(brf105a.getR57_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR57_CRWA_NON_RESIDENT_UAE().intValue());
 							}
 							Cell R57cell7 = row57.getCell(9); 
 							if (R57cell7 != null) {
 								R57cell7.setCellValue(brf105a.getR57_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR57_EXPOSURE_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R57cell8 = row57.getCell(10); 
 							if (R57cell8 != null) {
 								R57cell8.setCellValue(brf105a.getR57_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR57_CRWA_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R57cell9 = row57.getCell(11); 
 							if (R57cell9 != null) {
 								R57cell9.setCellValue(brf105a.getR57_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR57_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R57cell10 = row57.getCell(12); 
 							if (R57cell10 != null) {
 								R57cell10.setCellValue(brf105a.getR57_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR57_CRWA_NON_RESIDENT_NON_UAE().intValue());
 							}
 							Cell R57cell11 = row57.getCell(13); 
 							if (R57cell11 != null) {
 								R57cell11.setCellValue(brf105a.getR57_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR57_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R57cell12 = row57.getCell(14); 
 							if (R57cell12 != null) {
 								R57cell12.setCellValue(brf105a.getR57_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR57_CRWA_INSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R57cell13 = row57.getCell(15); 
 							if (R57cell13 != null) {
 								R57cell13.setCellValue(brf105a.getR57_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR57_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R57cell14 = row57.getCell(16); 
 							if (R57cell14 != null) {
 								R57cell14.setCellValue(brf105a.getR57_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR57_CRWA_OUTSIDE_CONSOLIDATED().intValue());
 							}
 							Cell R57cell15 = row57.getCell(17); 
 							if (R57cell15 != null) {
 								R57cell15.setCellValue(brf105a.getR57_NON_PERFORMING() == null ? 0 : brf105a.getR57_NON_PERFORMING().intValue());
 							}
 							Cell R57cell16 = row57.getCell(18); 
 							if (R57cell16 != null) {
 								R57cell16.setCellValue(brf105a.getR57_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR57_SPECIFIC_PROVISION().intValue());
 							}
 							Cell  R57cell17 = row57.getCell(19); 
 							if (R57cell17 != null) {
 								R57cell17.setCellValue(brf105a.getR57_INTEREST() == null ? 0 : brf105a.getR57_INTEREST().intValue());
 							}
 							Cell  R57cell18 = row57.getCell(20); 
 							if (R57cell18 != null) {
 								R57cell18.setCellValue(brf105a.getR57_DEFAULTED() == null ? 0 : brf105a.getR57_DEFAULTED().intValue());
 							}
							 Row row58 = sheet.getRow(69); 
							 Cell R58cell1 = row58.getCell(3); 
								if (R58cell1 != null) {
									R58cell1.setCellValue(brf105a.getR58_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR58_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R58cell2 = row58.getCell(4); 
								if (R58cell2 != null) {
									R58cell2.setCellValue(brf105a.getR58_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR58_CRWA_CONSOLIDATED().intValue());
								}
								Cell R58cell3 = row58.getCell(5); 
								if (R58cell3 != null) {
									R58cell3.setCellValue(brf105a.getR58_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR58_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R58cell4 = row58.getCell(6); 
								if (R58cell4 != null) {
									R58cell4.setCellValue(brf105a.getR58_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR58_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R58cell5 = row58.getCell(7); 
								if (R58cell5 != null) {
									R58cell5.setCellValue(brf105a.getR58_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR58_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R58cell6 = row58.getCell(8); 
								if (R58cell6 != null) {
									R58cell6.setCellValue(brf105a.getR58_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR58_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R58cell7 = row58.getCell(9); 
								if (R58cell7 != null) {
									R58cell7.setCellValue(brf105a.getR58_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR58_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R58cell8 = row58.getCell(10); 
								if (R58cell8 != null) {
									R58cell8.setCellValue(brf105a.getR58_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR58_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R58cell9 = row58.getCell(11); 
								if (R58cell9 != null) {
									R58cell9.setCellValue(brf105a.getR58_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR58_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R58cell10 = row58.getCell(12); 
								if (R58cell10 != null) {
									R58cell10.setCellValue(brf105a.getR58_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR58_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R58cell11 = row58.getCell(13); 
								if (R58cell11 != null) {
									R58cell11.setCellValue(brf105a.getR58_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR58_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R58cell12 = row58.getCell(14); 
								if (R58cell12 != null) {
									R58cell12.setCellValue(brf105a.getR58_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR58_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R58cell13 = row58.getCell(15); 
								if (R58cell13 != null) {
									R58cell13.setCellValue(brf105a.getR58_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR58_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R58cell14 = row58.getCell(16); 
								if (R58cell14 != null) {
									R58cell14.setCellValue(brf105a.getR58_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR58_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R58cell15 = row58.getCell(17); 
								if (R58cell15 != null) {
									R58cell15.setCellValue(brf105a.getR58_NON_PERFORMING() == null ? 0 : brf105a.getR58_NON_PERFORMING().intValue());
								}
								Cell R58cell16 = row58.getCell(18); 
								if (R58cell16 != null) {
									R58cell16.setCellValue(brf105a.getR58_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR58_SPECIFIC_PROVISION().intValue());
								}
								Cell  R58cell17 = row58.getCell(19); 
								if (R58cell17 != null) {
									R58cell17.setCellValue(brf105a.getR58_INTEREST() == null ? 0 : brf105a.getR58_INTEREST().intValue());
								}
								Cell  R58cell18 = row58.getCell(20); 
								if (R58cell18 != null) {
									R58cell18.setCellValue(brf105a.getR58_DEFAULTED() == null ? 0 : brf105a.getR58_DEFAULTED().intValue());
								}
							 Row row59 = sheet.getRow(70); 
							 Cell R59cell1 = row59.getCell(3); 
								if (R59cell1 != null) {
									R59cell1.setCellValue(brf105a.getR59_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR59_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R59cell2 = row59.getCell(4); 
								if (R59cell2 != null) {
									R59cell2.setCellValue(brf105a.getR59_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR59_CRWA_CONSOLIDATED().intValue());
								}
								Cell R59cell3 = row59.getCell(5); 
								if (R59cell3 != null) {
									R59cell3.setCellValue(brf105a.getR59_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR59_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R59cell4 = row59.getCell(6); 
								if (R59cell4 != null) {
									R59cell4.setCellValue(brf105a.getR59_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR59_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R59cell5 = row59.getCell(7); 
								if (R59cell5 != null) {
									R59cell5.setCellValue(brf105a.getR59_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR59_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R59cell6 = row59.getCell(8); 
								if (R59cell6 != null) {
									R59cell6.setCellValue(brf105a.getR59_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR59_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R59cell7 = row59.getCell(9); 
								if (R59cell7 != null) {
									R59cell7.setCellValue(brf105a.getR59_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR59_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R59cell8 = row59.getCell(10); 
								if (R59cell8 != null) {
									R59cell8.setCellValue(brf105a.getR59_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR59_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R59cell9 = row59.getCell(11); 
								if (R59cell9 != null) {
									R59cell9.setCellValue(brf105a.getR59_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR59_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R59cell10 = row59.getCell(12); 
								if (R59cell10 != null) {
									R59cell10.setCellValue(brf105a.getR59_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR59_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R59cell11 = row59.getCell(13); 
								if (R59cell11 != null) {
									R59cell11.setCellValue(brf105a.getR59_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR59_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R59cell12 = row59.getCell(14); 
								if (R59cell12 != null) {
									R59cell12.setCellValue(brf105a.getR59_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR59_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R59cell13 = row59.getCell(15); 
								if (R59cell13 != null) {
									R59cell13.setCellValue(brf105a.getR59_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR59_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R59cell14 = row59.getCell(16); 
								if (R59cell14 != null) {
									R59cell14.setCellValue(brf105a.getR59_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR59_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R59cell15 = row59.getCell(17); 
								if (R59cell15 != null) {
									R59cell15.setCellValue(brf105a.getR59_NON_PERFORMING() == null ? 0 : brf105a.getR59_NON_PERFORMING().intValue());
								}
								Cell R59cell16 = row59.getCell(18); 
								if (R59cell16 != null) {
									R59cell16.setCellValue(brf105a.getR59_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR59_SPECIFIC_PROVISION().intValue());
								}
								Cell  R59cell17 = row59.getCell(19); 
								if (R59cell17 != null) {
									R59cell17.setCellValue(brf105a.getR59_INTEREST() == null ? 0 : brf105a.getR59_INTEREST().intValue());
								}
								Cell  R59cell18 = row59.getCell(20); 
								if (R59cell18 != null) {
									R59cell18.setCellValue(brf105a.getR59_DEFAULTED() == null ? 0 : brf105a.getR59_DEFAULTED().intValue());
								}
							 Row row60 = sheet.getRow(71); 
							 Cell R60cell1 = row60.getCell(3); 
								if (R60cell1 != null) {
									R60cell1.setCellValue(brf105a.getR60_TOTAL_CONSOLIDATED() == null ? 0 : brf105a.getR60_TOTAL_CONSOLIDATED().intValue());
								}
								Cell R60cell2 = row60.getCell(4); 
								if (R60cell2 != null) {
									R60cell2.setCellValue(brf105a.getR60_CRWA_CONSOLIDATED() == null ? 0 : brf105a.getR60_CRWA_CONSOLIDATED().intValue());
								}
								Cell R60cell3 = row60.getCell(5); 
								if (R60cell3 != null) {
									R60cell3.setCellValue(brf105a.getR60_EXPOSURE_RESIDENT_UAE() == null ? 0 : brf105a.getR60_EXPOSURE_RESIDENT_UAE().intValue());
								}
								Cell R60cell4 = row60.getCell(6); 
								if (R60cell4 != null) {
									R60cell4.setCellValue(brf105a.getR60_CRWA_RESIDENT_UAE() == null ? 0 : brf105a.getR60_CRWA_RESIDENT_UAE().intValue());
								}
								Cell R60cell5 = row60.getCell(7); 
								if (R60cell5 != null) {
									R60cell5.setCellValue(brf105a.getR60_EXPOSURE_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR60_EXPOSURE_NON_RESIDENT_UAE().intValue());
								}
								Cell R60cell6 = row60.getCell(8); 
								if (R60cell6 != null) {
									R60cell6.setCellValue(brf105a.getR60_CRWA_NON_RESIDENT_UAE() == null ? 0 : brf105a.getR60_CRWA_NON_RESIDENT_UAE().intValue());
								}
								Cell R60cell7 = row60.getCell(9); 
								if (R60cell7 != null) {
									R60cell7.setCellValue(brf105a.getR60_EXPOSURE_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR60_EXPOSURE_RESIDENT_NON_UAE().intValue());
								}
								Cell R60cell8 = row60.getCell(10); 
								if (R60cell8 != null) {
									R60cell8.setCellValue(brf105a.getR60_CRWA_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR60_CRWA_RESIDENT_NON_UAE().intValue());
								}
								Cell R60cell9 = row60.getCell(11); 
								if (R60cell9 != null) {
									R60cell9.setCellValue(brf105a.getR60_EXPOSURE_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR60_EXPOSURE_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R60cell10 = row60.getCell(12); 
								if (R60cell10 != null) {
									R60cell10.setCellValue(brf105a.getR60_CRWA_NON_RESIDENT_NON_UAE() == null ? 0 : brf105a.getR60_CRWA_NON_RESIDENT_NON_UAE().intValue());
								}
								Cell R60cell11 = row60.getCell(13); 
								if (R60cell11 != null) {
									R60cell11.setCellValue(brf105a.getR60_EXPOSURE_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR60_EXPOSURE_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R60cell12 = row60.getCell(14); 
								if (R60cell12 != null) {
									R60cell12.setCellValue(brf105a.getR60_CRWA_INSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR60_CRWA_INSIDE_CONSOLIDATED().intValue());
								}
								Cell R60cell13 = row60.getCell(15); 
								if (R60cell13 != null) {
									R60cell13.setCellValue(brf105a.getR60_EXPOSURE_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR60_EXPOSURE_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R60cell14 = row60.getCell(16); 
								if (R60cell14 != null) {
									R60cell14.setCellValue(brf105a.getR60_CRWA_OUTSIDE_CONSOLIDATED() == null ? 0 : brf105a.getR60_CRWA_OUTSIDE_CONSOLIDATED().intValue());
								}
								Cell R60cell15 = row60.getCell(17); 
								if (R60cell15 != null) {
									R60cell15.setCellValue(brf105a.getR60_NON_PERFORMING() == null ? 0 : brf105a.getR60_NON_PERFORMING().intValue());
								}
								Cell R60cell16 = row60.getCell(18); 
								if (R60cell16 != null) {
									R60cell16.setCellValue(brf105a.getR60_SPECIFIC_PROVISION() == null ? 0 : brf105a.getR60_SPECIFIC_PROVISION().intValue());
								}
								Cell  R60cell17 = row60.getCell(19); 
								if (R60cell17 != null) {
									R60cell17.setCellValue(brf105a.getR60_INTEREST() == null ? 0 : brf105a.getR60_INTEREST().intValue());
								}
								Cell  R60cell18 = row60.getCell(20); 
								if (R60cell18 != null) {
									R60cell18.setCellValue(brf105a.getR60_DEFAULTED() == null ? 0 : brf105a.getR60_DEFAULTED().intValue());
								}
							
						}
					}
					// Save the changes
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-105-A.xls");
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
			outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-105-A.xls");

			return outputFile;
		
		
		
		}
					
		public String detailChanges105(BRF105_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
				BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

			String msg = "";

			try {

				Session hs = sessionFactory.getCurrentSession();
				Optional<BRF105_DETAIL_ENTITY> Brf105detail =brf105_detailrepo.findById(foracid);

				if (Brf105detail.isPresent()) {
					BRF105_DETAIL_ENTITY BRFdetail = Brf105detail.get();

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
						brf105_detailrepo.save(BRFdetail);

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
		public ModelAndView getArchieveBRF0105View(String reportId, String fromdate, String todate, String currency,
				String dtltype, Pageable pageable) {

			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF105_ENTITY1> T1rep = new ArrayList<BRF105_ENTITY1>();
			// Query<Object[]> qr;

			List<BRF105_ENTITY1> T1Master = new ArrayList<BRF105_ENTITY1>();
			List<BRF105_ENTITY2> T1Master1 = new ArrayList<BRF105_ENTITY2>();
			
			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from BRF105_ENTITY1 a where a.report_date = ?1 ",BRF105_ENTITY1.class)
						.setParameter(1, df.parse(todate)).getResultList();

				T1Master1 = hs.createQuery("from BRF105_ENTITY2 a where a.report_date = ?1 ", BRF105_ENTITY2.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
			
			} catch (ParseException e)
			{			
				e.printStackTrace();
				}

			mv.setViewName("RR/BRF105ARCH");
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

		public ModelAndView ARCHgetBRF0105currentDtl(String reportId, String fromdate, String todate, String currency,
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

					qr = hs.createNativeQuery("select * from BRF105_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
					qr.setParameter(1, df.parse(todate));
					qr.setParameter(2, filter);

				} else {
					System.out.println("2");
					qr = hs.createNativeQuery("select * from BRF105_ARCHIVTABLE");

				}
			} else {
				System.out.println("3");
				qr = hs.createNativeQuery("select * from BRF105_ARCHIVTABLE  where report_date = ?1");
			}

			/*
			 * try { qr.setParameter(1, df.parse(todate));
			 * 
			 * } catch (ParseException e) { e.printStackTrace(); }
			 */
			List<BRF105_ARCHIVENTITY> T1Master = new ArrayList<BRF105_ARCHIVENTITY>();

			try {
				System.out.println("Values entered");
				T1Master = hs.createQuery("from BRF105_ARCHIVENTITY a where a.report_date = ?1", BRF105_ARCHIVENTITY.class)
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
				String sector = (String) a[17];
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

				BRF105_ARCHIVENTITY py = new BRF105_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
					    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
					    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
					    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
					    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
					    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,gender,
					    version, remarks);
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

			mv.setViewName("RR" + "/" + "BRF105ARCH::reportcontent");
			mv.addObject("reportdetails", T1Dt1Page.getContent());
			mv.addObject("reportmaster", T1Master);
			mv.addObject("reportmaster1", qr);
			mv.addObject("singledetail", new T1CurProdDetail());
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			return mv;
		}


			
		}
