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

import com.bornfire.xbrl.entities.BRBS.BRF56_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF56_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRF151_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF151ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF151_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF151_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF151reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF151_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF32ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF56_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF56_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF56_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF60_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;

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

public class BRF151ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF151ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF32ServiceRepo brf32ServiceRepo;
	
	@Autowired
	BRF151ServiceRepo brf151ServiceRepo;
	
	@Autowired
	BRF151_DetailRepo  brf151DetailRep;

	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF151(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF151reportentity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF151reportentity a").getSingleResult();
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
	
	public ModelAndView getBRF151View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF151reportentity> T1rep = new ArrayList<BRF151reportentity>();
		// Query<Object[]> qr;

		List<BRF151reportentity> T1Master = new ArrayList<BRF151reportentity>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF151reportentity a where a.report_date = ?1 ", BRF151reportentity.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF151");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF151Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF151_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF151_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF151_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF151_DETAIL_ENTITY> T1Master = new ArrayList<BRF151_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF151_DETAIL_ENTITY a where a.report_date = ?1", BRF151_DETAIL_ENTITY.class)
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

			BRF151_DETAIL_ENTITY py = new BRF151_DETAIL_ENTITY( cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
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

		mv.setViewName("RR"+"/"+"BRF151::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF151(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-151-A";
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

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF151_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF151_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF151.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF151.jrxml");
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
			
			List<BRF151reportentity> T1Master = new ArrayList<BRF151reportentity>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);
			
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF151reportentity a where a.report_date = ?1 ", BRF151reportentity.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			if(T1Master.size() == 1) {
				
				for(BRF151reportentity BRF151 : T1Master ) {
			
			File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-151-AT.xls");
			
			  // Load the Excel file
        	Workbook workbook = WorkbookFactory.create(Responsecamt);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            
           ////////////////////////// ///ROW2
            Row row = sheet.getRow(9);
            Cell cell = row.getCell(3);
            if (cell != null) {
                cell.setCellValue(BRF151.getR2_resident_individual() == null ? 0 :
                	BRF151.getR2_resident_individual().intValue());
            }
            Cell cell1 = row.getCell(4);
            if (cell1 != null) {
                cell1.setCellValue(BRF151.getR2_nonresident_individual() == null ? 0 :
                	BRF151.getR2_nonresident_individual().intValue());
            }
            Cell cell2 = row.getCell(5);
            if (cell2 != null) {
                cell2.setCellValue(BRF151.getR2_resident_retail() == null ? 0 :
                	BRF151.getR2_resident_retail().intValue());
            }
            Cell cell3 = row.getCell(6);
            if (cell3 != null) {
                cell3.setCellValue(BRF151.getR2_nonresident_retail() == null ? 0 :
                	BRF151.getR2_nonresident_retail().intValue());
            }
            Cell cell4 = row.getCell(7);
            if (cell4 != null) {
                cell4.setCellValue(BRF151.getR2_resident_sme() == null ? 0 :
                	BRF151.getR2_resident_sme().intValue());
            }
            Cell cell5 = row.getCell(8);
            if (cell5 != null) {
                cell5.setCellValue(BRF151.getR2_nonresident_sme() == null ? 0 :
                	BRF151.getR2_nonresident_sme().intValue());
            }
            Cell cell6 = row.getCell(9);
            if (cell6 != null) {
                cell6.setCellValue(BRF151.getR2_resident_hni() == null ? 0 :
                	BRF151.getR2_resident_hni().intValue());
            }	
            Cell cell7 = row.getCell(10);
            if (cell7 != null) {
                cell7.setCellValue(BRF151.getR2_nonresident_hni() == null ? 0 :
                	BRF151.getR2_nonresident_hni().intValue());
            }
            Cell cell8 = row.getCell(11);
            if (cell8 != null) {
                cell8.setCellValue(BRF151.getR2_resident_gres() == null ? 0 :
                	BRF151.getR2_resident_gres().intValue());
            }
            Cell cell9 = row.getCell(12);
            if (cell9 != null) {
                cell9.setCellValue(BRF151.getR2_nonresident_gres() == null ? 0 :
                	BRF151.getR2_nonresident_gres().intValue());
            }
            ///
            Cell cell10 = row.getCell(13);
            if (cell10 != null) {
                cell10.setCellValue(BRF151.getR2_resident_corporate() == null ? 0 :
                	BRF151.getR2_resident_corporate().intValue());
            }
            Cell cell11 = row.getCell(14);
            if (cell11 != null) {
                cell11.setCellValue(BRF151.getR2_nonresident_corporate() == null ? 0 :
                	BRF151.getR2_nonresident_gres().intValue());
            }
            Cell cell12 = row.getCell(15);
            if (cell12 != null) {
                cell12.setCellValue(BRF151.getR2_resident_nbfi() == null ? 0 :
                	BRF151.getR2_resident_nbfi().intValue());
            }
            Cell cell13 = row.getCell(16);
            if (cell13 != null) {
                cell13.setCellValue(BRF151.getR2_nonresident_nbfi() == null ? 0 :
                	BRF151.getR2_nonresident_nbfi().intValue());
            }
            
            Cell cell14 = row.getCell(17);
            if (cell14 != null) {
                cell14.setCellValue(BRF151.getR2_resident_banks() == null ? 0 :
                	BRF151.getR2_resident_banks().intValue());
            }
            
            Cell cell15 = row.getCell(12);
            if (cell15 != null) {
                cell15.setCellValue(BRF151.getR2_nonresident_banks() == null ? 0 :
                	BRF151.getR2_nonresident_banks().intValue());
            }
            Cell cell16 = row.getCell(12);
            if (cell16 != null) {
                cell16.setCellValue(BRF151.getR2_resident_gov_nces() == null ? 0 :
                	BRF151.getR2_resident_gov_nces().intValue());
            }
            
            Cell cell17 = row.getCell(12);
            if (cell17 != null) {
                cell17.setCellValue(BRF151.getR2_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR2_nonresident_gov_nces().intValue());
            }
           
            
            //////////////////////////////ROW 3///////////////////////
            
			Row row1 = sheet.getRow(10);
           
			 Cell R3cell = row1.getCell(3);
	            if (R3cell != null) {
	                R3cell.setCellValue(BRF151.getR3_resident_individual() == null ? 0 :
	                	BRF151.getR3_resident_individual().intValue());
	            }
	            Cell R3cell1 = row1.getCell(4);
	            if (R3cell1 != null) {
	                R3cell1.setCellValue(BRF151.getR3_nonresident_individual() == null ? 0 :
	                	BRF151.getR3_nonresident_individual().intValue());
	            }
	            Cell R3cell2 = row1.getCell(5);
	            if (R3cell2 != null) {
	                R3cell2.setCellValue(BRF151.getR3_resident_retail() == null ? 0 :
	                	BRF151.getR3_resident_retail().intValue());
	            }
	            Cell R3cell3 = row1.getCell(6);
	            if (R3cell3 != null) {
	                R3cell3.setCellValue(BRF151.getR3_nonresident_retail() == null ? 0 :
	                	BRF151.getR3_nonresident_retail().intValue());
	            }
	            Cell R3cell4 = row1.getCell(7);
	            if (R3cell4 != null) {
	                R3cell4.setCellValue(BRF151.getR3_resident_sme() == null ? 0 :
	                	BRF151.getR3_resident_sme().intValue());
	            }
	            Cell R3cell5 = row1.getCell(8);
	            if (R3cell5 != null) {
	                R3cell5.setCellValue(BRF151.getR3_nonresident_sme() == null ? 0 :
	                	BRF151.getR3_nonresident_sme().intValue());
	            }
	            Cell R3cell6 = row1.getCell(9);
	            if (R3cell6 != null) {
	                R3cell6.setCellValue(BRF151.getR3_resident_hni() == null ? 0 :
	                	BRF151.getR3_resident_hni().intValue());
	            }	
	            Cell R3cell7 = row1.getCell(10);
	            if (R3cell7 != null) {
	                R3cell7.setCellValue(BRF151.getR3_nonresident_hni() == null ? 0 :
	                	BRF151.getR3_nonresident_hni().intValue());
	            }
	            Cell R3cell8 = row1.getCell(11);
	            if (R3cell8 != null) {
	                R3cell8.setCellValue(BRF151.getR3_resident_gres() == null ? 0 :
	                	BRF151.getR3_resident_gres().intValue());
	            }
	            Cell R3cell9 = row1.getCell(12);
	            if (R3cell9 != null) {
	                R3cell9.setCellValue(BRF151.getR3_nonresident_gres() == null ? 0 :
	                	BRF151.getR3_nonresident_gres().intValue());
	            }
	            ///
	            Cell R3cell10 = row1.getCell(13);
	            if (R3cell10 != null) {
	                R3cell10.setCellValue(BRF151.getR3_resident_corporate() == null ? 0 :
	                	BRF151.getR3_resident_corporate().intValue());
	            }
	            Cell R3cell11 = row1.getCell(14);
	            if (R3cell11 != null) {
	                R3cell11.setCellValue(BRF151.getR3_nonresident_corporate() == null ? 0 :
	                	BRF151.getR3_nonresident_gres().intValue());
	            }
	            Cell R3cell12 = row1.getCell(15);
	            if (R3cell12 != null) {
	                R3cell12.setCellValue(BRF151.getR3_resident_nbfi() == null ? 0 :
	                	BRF151.getR3_resident_nbfi().intValue());
	            }
	            Cell R3cell13 = row1.getCell(16);
	            if (R3cell13 != null) {
	                R3cell13.setCellValue(BRF151.getR3_nonresident_nbfi() == null ? 0 :
	                	BRF151.getR3_nonresident_nbfi().intValue());
	            }
	            
	            Cell R3cell14 = row1.getCell(17);
	            if (R3cell14 != null) {
	                R3cell14.setCellValue(BRF151.getR3_resident_banks() == null ? 0 :
	                	BRF151.getR3_resident_banks().intValue());
	            }
	            
	            Cell R3cell15 = row1.getCell(12);
	            if (R3cell15 != null) {
	                R3cell15.setCellValue(BRF151.getR3_nonresident_banks() == null ? 0 :
	                	BRF151.getR3_nonresident_banks().intValue());
	            }
	            Cell R3cell16 = row1.getCell(12);
	            if (R3cell16 != null) {
	                R3cell16.setCellValue(BRF151.getR3_resident_gov_nces() == null ? 0 :
	                	BRF151.getR3_resident_gov_nces().intValue());
	            }
	            
	            Cell R3cell17 = row1.getCell(12);
	            if (R3cell17 != null) {
	            	R3cell17.setCellValue(BRF151.getR3_nonresident_gov_nces() == null ? 0 :
	                	BRF151.getR3_nonresident_gov_nces().intValue());
	            }
	           
            ////////////////ROW 5//////////////
			Row row2 = sheet.getRow(12);
            
			Cell R5cell = row2.getCell(3);
            if (R5cell != null) {
                R5cell.setCellValue(BRF151.getR5_resident_individual() == null ? 0 :
                	BRF151.getR5_resident_individual().intValue());
            }
            Cell R5cell1 = row2.getCell(4);
            if (R5cell1 != null) {
                R5cell1.setCellValue(BRF151.getR5_nonresident_individual() == null ? 0 :
                	BRF151.getR5_nonresident_individual().intValue());
            }
            Cell R5cell2 = row2.getCell(5);
            if (R5cell2 != null) {
                R5cell2.setCellValue(BRF151.getR5_resident_retail() == null ? 0 :
                	BRF151.getR5_resident_retail().intValue());
            }
            Cell R5cell3 = row2.getCell(6);
            if (R5cell3 != null) {
                R5cell3.setCellValue(BRF151.getR5_nonresident_retail() == null ? 0 :
                	BRF151.getR5_nonresident_retail().intValue());
            }
            Cell R5cell4 = row2.getCell(7);
            if (R5cell4 != null) {
                R5cell4.setCellValue(BRF151.getR5_resident_sme() == null ? 0 :
                	BRF151.getR5_resident_sme().intValue());
            }
            Cell R5cell5 = row2.getCell(8);
            if (R5cell5 != null) {
                R5cell5.setCellValue(BRF151.getR5_nonresident_sme() == null ? 0 :
                	BRF151.getR5_nonresident_sme().intValue());
            }
            Cell R5cell6 = row2.getCell(9);
            if (R5cell6 != null) {
                R5cell6.setCellValue(BRF151.getR5_resident_hni() == null ? 0 :
                	BRF151.getR5_resident_hni().intValue());
            }	
            Cell R5cell7 = row2.getCell(10);
            if (R5cell7 != null) {
                R5cell7.setCellValue(BRF151.getR5_nonresident_hni() == null ? 0 :
                	BRF151.getR5_nonresident_hni().intValue());
            }
            Cell R5cell8 = row2.getCell(11);
            if (R5cell8 != null) {
                R5cell8.setCellValue(BRF151.getR5_resident_gres() == null ? 0 :
                	BRF151.getR5_resident_gres().intValue());
            }
            Cell R5cell9 = row2.getCell(12);
            if (R5cell9 != null) {
                R5cell9.setCellValue(BRF151.getR5_nonresident_gres() == null ? 0 :
                	BRF151.getR5_nonresident_gres().intValue());
            }
            ///
            Cell R5cell10 = row2.getCell(13);
            if (R5cell10 != null) {
                R5cell10.setCellValue(BRF151.getR5_resident_corporate() == null ? 0 :
                	BRF151.getR5_resident_corporate().intValue());
            }
            Cell R5cell11 = row2.getCell(14);
            if (R5cell11 != null) {
                R5cell11.setCellValue(BRF151.getR5_nonresident_corporate() == null ? 0 :
                	BRF151.getR5_nonresident_gres().intValue());
            }
            Cell R5cell12 = row2.getCell(15);
            if (R5cell12 != null) {
                R5cell12.setCellValue(BRF151.getR5_resident_nbfi() == null ? 0 :
                	BRF151.getR5_resident_nbfi().intValue());
            }
            Cell R5cell13 = row2.getCell(16);
            if (R5cell13 != null) {
                R5cell13.setCellValue(BRF151.getR5_nonresident_nbfi() == null ? 0 :
                	BRF151.getR5_nonresident_nbfi().intValue());
            }
            
            Cell R5cell14 = row2.getCell(17);
            if (R5cell14 != null) {
                R5cell14.setCellValue(BRF151.getR5_resident_banks() == null ? 0 :
                	BRF151.getR5_resident_banks().intValue());
            }
            
            Cell R5cell15 = row2.getCell(12);
            if (R5cell15 != null) {
                R5cell15.setCellValue(BRF151.getR5_nonresident_banks() == null ? 0 :
                	BRF151.getR5_nonresident_banks().intValue());
            }
            Cell R5cell16 = row2.getCell(12);
            if (R5cell16 != null) {
                R5cell16.setCellValue(BRF151.getR5_resident_gov_nces() == null ? 0 :
                	BRF151.getR5_resident_gov_nces().intValue());
            }
            
            Cell R5cell17 = row2.getCell(12);
            if (R5cell17 != null) {
            	R5cell17.setCellValue(BRF151.getR5_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR5_nonresident_gov_nces().intValue());
            }
        
            ///////////////ROW 6 //////////
			Row row3 = sheet.getRow(13);
			 Cell R6cell = row3.getCell(3);
	            if (R6cell != null) {
	                R6cell.setCellValue(BRF151.getR6_resident_individual() == null ? 0 :
	                	BRF151.getR6_resident_individual().intValue());
	            }
	            Cell R6cell1 = row3.getCell(4);
	            if (R6cell1 != null) {
	                R6cell1.setCellValue(BRF151.getR6_nonresident_individual() == null ? 0 :
	                	BRF151.getR6_nonresident_individual().intValue());
	            }
	            Cell R6cell2 = row3.getCell(5);
	            if (R6cell2 != null) {
	                R6cell2.setCellValue(BRF151.getR6_resident_retail() == null ? 0 :
	                	BRF151.getR6_resident_retail().intValue());
	            }
	            Cell R6cell3 = row3.getCell(6);
	            if (R6cell3 != null) {
	                R6cell3.setCellValue(BRF151.getR6_nonresident_retail() == null ? 0 :
	                	BRF151.getR6_nonresident_retail().intValue());
	            }
	            Cell R6cell4 = row3.getCell(7);
	            if (R6cell4 != null) {
	                R6cell4.setCellValue(BRF151.getR6_resident_sme() == null ? 0 :
	                	BRF151.getR6_resident_sme().intValue());
	            }
	            Cell R6cell5 = row3.getCell(8);
	            if (R6cell5 != null) {
	                R6cell5.setCellValue(BRF151.getR6_nonresident_sme() == null ? 0 :
	                	BRF151.getR6_nonresident_sme().intValue());
	            }
	            Cell R6cell6 = row3.getCell(9);
	            if (R6cell6 != null) {
	                R6cell6.setCellValue(BRF151.getR6_resident_hni() == null ? 0 :
	                	BRF151.getR6_resident_hni().intValue());
	            }	
	            Cell R6cell7 = row3.getCell(10);
	            if (R6cell7 != null) {
	                R6cell7.setCellValue(BRF151.getR6_nonresident_hni() == null ? 0 :
	                	BRF151.getR6_nonresident_hni().intValue());
	            }
	            Cell R6cell8 = row3.getCell(11);
	            if (R6cell8 != null) {
	                R6cell8.setCellValue(BRF151.getR6_resident_gres() == null ? 0 :
	                	BRF151.getR6_resident_gres().intValue());
	            }
	            Cell R6cell9 = row3.getCell(12);
	            if (R6cell9 != null) {
	                R6cell9.setCellValue(BRF151.getR6_nonresident_gres() == null ? 0 :
	                	BRF151.getR6_nonresident_gres().intValue());
	            }
	            ///
	            Cell R6cell10 = row3.getCell(13);
	            if (R6cell10 != null) {
	                R6cell10.setCellValue(BRF151.getR6_resident_corporate() == null ? 0 :
	                	BRF151.getR6_resident_corporate().intValue());
	            }
	            Cell R6cell11 = row3.getCell(14);
	            if (R6cell11 != null) {
	                R6cell11.setCellValue(BRF151.getR6_nonresident_corporate() == null ? 0 :
	                	BRF151.getR6_nonresident_gres().intValue());
	            }
	            Cell R6cell12 = row3.getCell(15);
	            if (R6cell12 != null) {
	                R6cell12.setCellValue(BRF151.getR6_resident_nbfi() == null ? 0 :
	                	BRF151.getR6_resident_nbfi().intValue());
	            }
	            Cell R6cell13 = row3.getCell(16);
	            if (R6cell13 != null) {
	                R6cell13.setCellValue(BRF151.getR6_nonresident_nbfi() == null ? 0 :
	                	BRF151.getR6_nonresident_nbfi().intValue());
	            }
	            
	            Cell R6cell14 = row3.getCell(17);
	            if (R6cell14 != null) {
	                R6cell14.setCellValue(BRF151.getR6_resident_banks() == null ? 0 :
	                	BRF151.getR6_resident_banks().intValue());
	            }
	            
	            Cell R6cell15 = row3.getCell(12);
	            if (R6cell15 != null) {
	                R6cell15.setCellValue(BRF151.getR6_nonresident_banks() == null ? 0 :
	                	BRF151.getR6_nonresident_banks().intValue());
	            }
	            Cell R6cell16 = row3.getCell(12);
	            if (R6cell16 != null) {
	                R6cell16.setCellValue(BRF151.getR6_resident_gov_nces() == null ? 0 :
	                	BRF151.getR6_resident_gov_nces().intValue());
	            }
	            
	            Cell R6cell17 = row3.getCell(12);
	            if (R6cell17 != null) {
	            	R6cell17.setCellValue(BRF151.getR6_nonresident_gov_nces() == null ? 0 :
	                	BRF151.getR6_nonresident_gov_nces().intValue());
	            }
            //////ROW7/////
			Row row4 = sheet.getRow(14);
			Cell R7cell = row4.getCell(3);
            if (R7cell != null) {
                R7cell.setCellValue(BRF151.getR7_resident_individual() == null ? 0 :
                	BRF151.getR7_resident_individual().intValue());
            }
            Cell R7cell1 = row4.getCell(4);
            if (R7cell1 != null) {
                R7cell1.setCellValue(BRF151.getR7_nonresident_individual() == null ? 0 :
                	BRF151.getR7_nonresident_individual().intValue());
            }
            Cell R7cell2 = row4.getCell(5);
            if (R7cell2 != null) {
                R7cell2.setCellValue(BRF151.getR7_resident_retail() == null ? 0 :
                	BRF151.getR7_resident_retail().intValue());
            }
            Cell R7cell3 = row4.getCell(6);
            if (R7cell3 != null) {
                R7cell3.setCellValue(BRF151.getR7_nonresident_retail() == null ? 0 :
                	BRF151.getR7_nonresident_retail().intValue());
            }
            Cell R7cell4 = row4.getCell(7);
            if (R7cell4 != null) {
                R7cell4.setCellValue(BRF151.getR7_resident_sme() == null ? 0 :
                	BRF151.getR7_resident_sme().intValue());
            }
            Cell R7cell5 = row4.getCell(8);
            if (R7cell5 != null) {
                R7cell5.setCellValue(BRF151.getR7_nonresident_sme() == null ? 0 :
                	BRF151.getR7_nonresident_sme().intValue());
            }
            Cell R7cell6 = row4.getCell(9);
            if (R7cell6 != null) {
                R7cell6.setCellValue(BRF151.getR7_resident_hni() == null ? 0 :
                	BRF151.getR7_resident_hni().intValue());
            }	
            Cell R7cell7 = row4.getCell(10);
            if (R7cell7 != null) {
                R7cell7.setCellValue(BRF151.getR7_nonresident_hni() == null ? 0 :
                	BRF151.getR7_nonresident_hni().intValue());
            }
            Cell R7cell8 = row4.getCell(11);
            if (R7cell8 != null) {
                R7cell8.setCellValue(BRF151.getR7_resident_gres() == null ? 0 :
                	BRF151.getR7_resident_gres().intValue());
            }
            Cell R7cell9 = row4.getCell(12);
            if (R7cell9 != null) {
                R7cell9.setCellValue(BRF151.getR7_nonresident_gres() == null ? 0 :
                	BRF151.getR7_nonresident_gres().intValue());
            }
            ///
            Cell R7cell10 = row4.getCell(13);
            if (R7cell10 != null) {
                R7cell10.setCellValue(BRF151.getR7_resident_corporate() == null ? 0 :
                	BRF151.getR7_resident_corporate().intValue());
            }
            Cell R7cell11 = row4.getCell(14);
            if (R7cell11 != null) {
                R7cell11.setCellValue(BRF151.getR7_nonresident_corporate() == null ? 0 :
                	BRF151.getR7_nonresident_gres().intValue());
            }
            Cell R7cell12 = row4.getCell(15);
            if (R7cell12 != null) {
                R7cell12.setCellValue(BRF151.getR7_resident_nbfi() == null ? 0 :
                	BRF151.getR7_resident_nbfi().intValue());
            }
            Cell R7cell13 = row4.getCell(16);
            if (R7cell13 != null) {
                R7cell13.setCellValue(BRF151.getR7_nonresident_nbfi() == null ? 0 :
                	BRF151.getR7_nonresident_nbfi().intValue());
            }
            
            Cell R7cell14 = row4.getCell(17);
            if (R7cell14 != null) {
                R7cell14.setCellValue(BRF151.getR7_resident_banks() == null ? 0 :
                	BRF151.getR7_resident_banks().intValue());
            }
            
            Cell R7cell15 = row4.getCell(12);
            if (R7cell15 != null) {
                R7cell15.setCellValue(BRF151.getR7_nonresident_banks() == null ? 0 :
                	BRF151.getR7_nonresident_banks().intValue());
            }
            Cell R7cell16 = row4.getCell(12);
            if (R7cell16 != null) {
                R7cell16.setCellValue(BRF151.getR7_resident_gov_nces() == null ? 0 :
                	BRF151.getR7_resident_gov_nces().intValue());
            }
            
            Cell R7cell17 = row4.getCell(12);
            if (R7cell17 != null) {
            	R7cell17.setCellValue(BRF151.getR7_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR7_nonresident_gov_nces().intValue());
            }
        
            
            //////////ROW8///////////
			Row row5 = sheet.getRow(15);
			Cell R8cell = row5.getCell(3);
            if (R8cell != null) {
                R8cell.setCellValue(BRF151.getR8_resident_individual() == null ? 0 :
                	BRF151.getR8_resident_individual().intValue());
            }
            Cell R8cell1 = row5.getCell(4);
            if (R8cell1 != null) {
                R8cell1.setCellValue(BRF151.getR8_nonresident_individual() == null ? 0 :
                	BRF151.getR8_nonresident_individual().intValue());
            }
            Cell R8cell2 = row5.getCell(5);
            if (R8cell2 != null) {
                R8cell2.setCellValue(BRF151.getR8_resident_retail() == null ? 0 :
                	BRF151.getR8_resident_retail().intValue());
            }
            Cell R8cell3 = row5.getCell(6);
            if (R8cell3 != null) {
                R8cell3.setCellValue(BRF151.getR8_nonresident_retail() == null ? 0 :
                	BRF151.getR8_nonresident_retail().intValue());
            }
            Cell R8cell4 = row5.getCell(7);
            if (R8cell4 != null) {
                R8cell4.setCellValue(BRF151.getR8_resident_sme() == null ? 0 :
                	BRF151.getR8_resident_sme().intValue());
            }
            Cell R8cell5 = row5.getCell(8);
            if (R8cell5 != null) {
                R8cell5.setCellValue(BRF151.getR8_nonresident_sme() == null ? 0 :
                	BRF151.getR8_nonresident_sme().intValue());
            }
            Cell R8cell6 = row5.getCell(9);
            if (R8cell6 != null) {
                R8cell6.setCellValue(BRF151.getR8_resident_hni() == null ? 0 :
                	BRF151.getR8_resident_hni().intValue());
            }	
            Cell R8cell7 = row5.getCell(10);
            if (R8cell7 != null) {
                R8cell7.setCellValue(BRF151.getR8_nonresident_hni() == null ? 0 :
                	BRF151.getR8_nonresident_hni().intValue());
            }
            Cell R8cell8 = row5.getCell(11);
            if (R8cell8 != null) {
                R8cell8.setCellValue(BRF151.getR8_resident_gres() == null ? 0 :
                	BRF151.getR8_resident_gres().intValue());
            }
            Cell R8cell9 = row5.getCell(12);
            if (R8cell9 != null) {
                R8cell9.setCellValue(BRF151.getR8_nonresident_gres() == null ? 0 :
                	BRF151.getR8_nonresident_gres().intValue());
            }
            ///
            Cell R8cell10 = row5.getCell(13);
            if (R8cell10 != null) {
                R8cell10.setCellValue(BRF151.getR8_resident_corporate() == null ? 0 :
                	BRF151.getR8_resident_corporate().intValue());
            }
            Cell R8cell11 = row5.getCell(14);
            if (R8cell11 != null) {
                R8cell11.setCellValue(BRF151.getR8_nonresident_corporate() == null ? 0 :
                	BRF151.getR8_nonresident_gres().intValue());
            }
            Cell R8cell12 = row5.getCell(15);
            if (R8cell12 != null) {
                R8cell12.setCellValue(BRF151.getR8_resident_nbfi() == null ? 0 :
                	BRF151.getR8_resident_nbfi().intValue());
            }
            Cell R8cell13 = row5.getCell(16);
            if (R8cell13 != null) {
                R8cell13.setCellValue(BRF151.getR8_nonresident_nbfi() == null ? 0 :
                	BRF151.getR8_nonresident_nbfi().intValue());
            }
            
            Cell R8cell14 = row5.getCell(17);
            if (R8cell14 != null) {
                R8cell14.setCellValue(BRF151.getR8_resident_banks() == null ? 0 :
                	BRF151.getR8_resident_banks().intValue());
            }
            
            Cell R8cell15 = row5.getCell(12);
            if (R8cell15 != null) {
                R8cell15.setCellValue(BRF151.getR8_nonresident_banks() == null ? 0 :
                	BRF151.getR8_nonresident_banks().intValue());
            }
            Cell R8cell16 = row5.getCell(12);
            if (R8cell16 != null) {
                R8cell16.setCellValue(BRF151.getR8_resident_gov_nces() == null ? 0 :
                	BRF151.getR8_resident_gov_nces().intValue());
            }
            
            Cell R8cell17 = row5.getCell(12);
            if (R8cell17 != null) {
            	R8cell17.setCellValue(BRF151.getR8_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR8_nonresident_gov_nces().intValue());
            }
        
            ///////////ROW10///////////
			Row row6 = sheet.getRow(17);
			Cell R10cell = row6.getCell(3);
            if (R10cell != null) {
                R10cell.setCellValue(BRF151.getR10_resident_individual() == null ? 0 :
                	BRF151.getR10_resident_individual().intValue());
            }
            Cell R10cell1 = row6.getCell(4);
            if (R10cell1 != null) {
                R10cell1.setCellValue(BRF151.getR10_nonresident_individual() == null ? 0 :
                	BRF151.getR10_nonresident_individual().intValue());
            }
            Cell R10cell2 = row6.getCell(5);
            if (R10cell2 != null) {
                R10cell2.setCellValue(BRF151.getR10_resident_retail() == null ? 0 :
                	BRF151.getR10_resident_retail().intValue());
            }
            Cell R10cell3 = row6.getCell(6);
            if (R10cell3 != null) {
                R10cell3.setCellValue(BRF151.getR10_nonresident_retail() == null ? 0 :
                	BRF151.getR10_nonresident_retail().intValue());
            }
            Cell R10cell4 = row6.getCell(7);
            if (R10cell4 != null) {
                R10cell4.setCellValue(BRF151.getR10_resident_sme() == null ? 0 :
                	BRF151.getR10_resident_sme().intValue());
            }
            Cell R10cell5 = row6.getCell(8);
            if (R10cell5 != null) {
                R10cell5.setCellValue(BRF151.getR10_nonresident_sme() == null ? 0 :
                	BRF151.getR10_nonresident_sme().intValue());
            }
            Cell R10cell6 = row6.getCell(9);
            if (R10cell6 != null) {
                R10cell6.setCellValue(BRF151.getR10_resident_hni() == null ? 0 :
                	BRF151.getR10_resident_hni().intValue());
            }	
            Cell R10cell7 = row6.getCell(10);
            if (R10cell7 != null) {
                R10cell7.setCellValue(BRF151.getR10_nonresident_hni() == null ? 0 :
                	BRF151.getR10_nonresident_hni().intValue());
            }
            Cell R10cell8 = row6.getCell(11);
            if (R10cell8 != null) {
                R10cell8.setCellValue(BRF151.getR10_resident_gres() == null ? 0 :
                	BRF151.getR10_resident_gres().intValue());
            }
            Cell R10cell9 = row6.getCell(12);
            if (R10cell9 != null) {
                R10cell9.setCellValue(BRF151.getR10_nonresident_gres() == null ? 0 :
                	BRF151.getR10_nonresident_gres().intValue());
            }
            ///
            Cell R10cell10 = row6.getCell(13);
            if (R10cell10 != null) {
                R10cell10.setCellValue(BRF151.getR10_resident_corporate() == null ? 0 :
                	BRF151.getR10_resident_corporate().intValue());
            }
            Cell R10cell11 = row6.getCell(14);
            if (R10cell11 != null) {
                R10cell11.setCellValue(BRF151.getR10_nonresident_corporate() == null ? 0 :
                	BRF151.getR10_nonresident_gres().intValue());
            }
            Cell R10cell12 = row6.getCell(15);
            if (R10cell12 != null) {
                R10cell12.setCellValue(BRF151.getR10_resident_nbfi() == null ? 0 :
                	BRF151.getR10_resident_nbfi().intValue());
            }
            Cell R10cell13 = row6.getCell(16);
            if (R10cell13 != null) {
                R10cell13.setCellValue(BRF151.getR10_nonresident_nbfi() == null ? 0 :
                	BRF151.getR10_nonresident_nbfi().intValue());
            }
            
            Cell R10cell14 = row6.getCell(17);
            if (R10cell14 != null) {
                R10cell14.setCellValue(BRF151.getR10_resident_banks() == null ? 0 :
                	BRF151.getR10_resident_banks().intValue());
            }
            
            Cell R10cell15 = row6.getCell(12);
            if (R10cell15 != null) {
                R10cell15.setCellValue(BRF151.getR10_nonresident_banks() == null ? 0 :
                	BRF151.getR10_nonresident_banks().intValue());
            }
            Cell R10cell16 = row6.getCell(12);
            if (R10cell16 != null) {
                R10cell16.setCellValue(BRF151.getR10_resident_gov_nces() == null ? 0 :
                	BRF151.getR10_resident_gov_nces().intValue());
            }
            
            Cell R10cell17 = row6.getCell(12);
            if (R10cell17 != null) {
            	R10cell17.setCellValue(BRF151.getR10_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR10_nonresident_gov_nces().intValue());
            }
        
            /////////////////////ROW11//////////////
			Row row7 = sheet.getRow(18);
			Cell R11cell = row7.getCell(3);
            if (R11cell != null) {
                R11cell.setCellValue(BRF151.getR11_resident_individual() == null ? 0 :
                	BRF151.getR11_resident_individual().intValue());
            }
            Cell R11cell1 = row7.getCell(4);
            if (R11cell1 != null) {
                R11cell1.setCellValue(BRF151.getR11_nonresident_individual() == null ? 0 :
                	BRF151.getR11_nonresident_individual().intValue());
            }
            Cell R11cell2 = row7.getCell(5);
            if (R11cell2 != null) {
                R11cell2.setCellValue(BRF151.getR11_resident_retail() == null ? 0 :
                	BRF151.getR11_resident_retail().intValue());
            }
            Cell R11cell3 = row7.getCell(6);
            if (R11cell3 != null) {
                R11cell3.setCellValue(BRF151.getR11_nonresident_retail() == null ? 0 :
                	BRF151.getR11_nonresident_retail().intValue());
            }
            Cell R11cell4 = row7.getCell(7);
            if (R11cell4 != null) {
                R11cell4.setCellValue(BRF151.getR11_resident_sme() == null ? 0 :
                	BRF151.getR11_resident_sme().intValue());
            }
            Cell R11cell5 = row7.getCell(8);
            if (R11cell5 != null) {
                R11cell5.setCellValue(BRF151.getR11_nonresident_sme() == null ? 0 :
                	BRF151.getR11_nonresident_sme().intValue());
            }
            Cell R11cell6 = row7.getCell(9);
            if (R11cell6 != null) {
                R11cell6.setCellValue(BRF151.getR11_resident_hni() == null ? 0 :
                	BRF151.getR11_resident_hni().intValue());
            }	
            Cell R11cell7 = row7.getCell(10);
            if (R11cell7 != null) {
                R11cell7.setCellValue(BRF151.getR11_nonresident_hni() == null ? 0 :
                	BRF151.getR11_nonresident_hni().intValue());
            }
            Cell R11cell8 = row7.getCell(11);
            if (R11cell8 != null) {
                R11cell8.setCellValue(BRF151.getR11_resident_gres() == null ? 0 :
                	BRF151.getR11_resident_gres().intValue());
            }
            Cell R11cell9 = row7.getCell(12);
            if (R11cell9 != null) {
                R11cell9.setCellValue(BRF151.getR11_nonresident_gres() == null ? 0 :
                	BRF151.getR11_nonresident_gres().intValue());
            }
            ///
            Cell R11cell10 = row7.getCell(13);
            if (R11cell10 != null) {
                R11cell10.setCellValue(BRF151.getR11_resident_corporate() == null ? 0 :
                	BRF151.getR11_resident_corporate().intValue());
            }
            Cell R11cell11 = row7.getCell(14);
            if (R11cell11 != null) {
                R11cell11.setCellValue(BRF151.getR11_nonresident_corporate() == null ? 0 :
                	BRF151.getR11_nonresident_gres().intValue());
            }
            Cell R11cell12 = row7.getCell(15);
            if (R11cell12 != null) {
                R11cell12.setCellValue(BRF151.getR11_resident_nbfi() == null ? 0 :
                	BRF151.getR11_resident_nbfi().intValue());
            }
            Cell R11cell13 = row7.getCell(16);
            if (R11cell13 != null) {
                R11cell13.setCellValue(BRF151.getR11_nonresident_nbfi() == null ? 0 :
                	BRF151.getR11_nonresident_nbfi().intValue());
            }
            
            Cell R11cell14 = row7.getCell(17);
            if (R11cell14 != null) {
                R11cell14.setCellValue(BRF151.getR11_resident_banks() == null ? 0 :
                	BRF151.getR11_resident_banks().intValue());
            }
            
            Cell R11cell15 = row7.getCell(12);
            if (R11cell15 != null) {
                R11cell15.setCellValue(BRF151.getR11_nonresident_banks() == null ? 0 :
                	BRF151.getR11_nonresident_banks().intValue());
            }
            Cell R11cell16 = row7.getCell(12);
            if (R11cell16 != null) {
                R11cell16.setCellValue(BRF151.getR11_resident_gov_nces() == null ? 0 :
                	BRF151.getR11_resident_gov_nces().intValue());
            }
            
            Cell R11cell17 = row7.getCell(12);
            if (R11cell17 != null) {
            	R11cell17.setCellValue(BRF151.getR11_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR11_nonresident_gov_nces().intValue());
            }
        
	          
            
            
            
            ////////////////ROW12////////////////////////
            Row row8 = sheet.getRow(19);
            Cell R12cell = row8.getCell(3);
            if (R12cell != null) {
                R12cell.setCellValue(BRF151.getR12_resident_individual() == null ? 0 :
                	BRF151.getR12_resident_individual().intValue());
            }
            Cell R12cell1 = row8.getCell(4);
            if (R12cell1 != null) {
                R12cell1.setCellValue(BRF151.getR12_nonresident_individual() == null ? 0 :
                	BRF151.getR12_nonresident_individual().intValue());
            }
            Cell R12cell2 = row8.getCell(5);
            if (R12cell2 != null) {
                R12cell2.setCellValue(BRF151.getR12_resident_retail() == null ? 0 :
                	BRF151.getR12_resident_retail().intValue());
            }
            Cell R12cell3 = row8.getCell(6);
            if (R12cell3 != null) {
                R12cell3.setCellValue(BRF151.getR12_nonresident_retail() == null ? 0 :
                	BRF151.getR12_nonresident_retail().intValue());
            }
            Cell R12cell4 = row8.getCell(7);
            if (R12cell4 != null) {
                R12cell4.setCellValue(BRF151.getR12_resident_sme() == null ? 0 :
                	BRF151.getR12_resident_sme().intValue());
            }
            Cell R12cell5 = row8.getCell(8);
            if (R12cell5 != null) {
                R12cell5.setCellValue(BRF151.getR12_nonresident_sme() == null ? 0 :
                	BRF151.getR12_nonresident_sme().intValue());
            }
            Cell R12cell6 = row8.getCell(9);
            if (R12cell6 != null) {
                R12cell6.setCellValue(BRF151.getR12_resident_hni() == null ? 0 :
                	BRF151.getR12_resident_hni().intValue());
            }	
            Cell R12cell7 = row8.getCell(10);
            if (R12cell7 != null) {
                R12cell7.setCellValue(BRF151.getR12_nonresident_hni() == null ? 0 :
                	BRF151.getR12_nonresident_hni().intValue());
            }
            Cell R12cell8 = row8.getCell(11);
            if (R12cell8 != null) {
                R12cell8.setCellValue(BRF151.getR12_resident_gres() == null ? 0 :
                	BRF151.getR12_resident_gres().intValue());
            }
            Cell R12cell9 = row8.getCell(12);
            if (R12cell9 != null) {
                R12cell9.setCellValue(BRF151.getR12_nonresident_gres() == null ? 0 :
                	BRF151.getR12_nonresident_gres().intValue());
            }
            ///
            Cell R12cell10 = row8.getCell(13);
            if (R12cell10 != null) {
                R12cell10.setCellValue(BRF151.getR12_resident_corporate() == null ? 0 :
                	BRF151.getR12_resident_corporate().intValue());
            }
            Cell R12cell11 = row8.getCell(14);
            if (R12cell11 != null) {
                R12cell11.setCellValue(BRF151.getR12_nonresident_corporate() == null ? 0 :
                	BRF151.getR12_nonresident_gres().intValue());
            }
            Cell R12cell12 = row8.getCell(15);
            if (R12cell12 != null) {
                R12cell12.setCellValue(BRF151.getR12_resident_nbfi() == null ? 0 :
                	BRF151.getR12_resident_nbfi().intValue());
            }
            Cell R12cell13 = row8.getCell(16);
            if (R12cell13 != null) {
                R12cell13.setCellValue(BRF151.getR12_nonresident_nbfi() == null ? 0 :
                	BRF151.getR12_nonresident_nbfi().intValue());
            }
            
            Cell R12cell14 = row8.getCell(17);
            if (R12cell14 != null) {
                R12cell14.setCellValue(BRF151.getR12_resident_banks() == null ? 0 :
                	BRF151.getR12_resident_banks().intValue());
            }
            
            Cell R12cell15 = row8.getCell(12);
            if (R12cell15 != null) {
                R12cell15.setCellValue(BRF151.getR12_nonresident_banks() == null ? 0 :
                	BRF151.getR12_nonresident_banks().intValue());
            }
            Cell R12cell16 = row8.getCell(12);
            if (R12cell16 != null) {
                R12cell16.setCellValue(BRF151.getR12_resident_gov_nces() == null ? 0 :
                	BRF151.getR12_resident_gov_nces().intValue());
            }
            
            Cell R12cell17 = row8.getCell(12);
            if (R12cell17 != null) {
            	R12cell17.setCellValue(BRF151.getR12_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR12_nonresident_gov_nces().intValue());
            }
        
            ////////ROW13
            
			Row row9 = sheet.getRow(20);
			Cell R13cell = row9.getCell(3);
            if (R13cell != null) {
                R13cell.setCellValue(BRF151.getR13_resident_individual() == null ? 0 :
                	BRF151.getR13_resident_individual().intValue());
            }
            Cell R13cell1 = row9.getCell(4);
            if (R13cell1 != null) {
                R13cell1.setCellValue(BRF151.getR13_nonresident_individual() == null ? 0 :
                	BRF151.getR13_nonresident_individual().intValue());
            }
            Cell R13cell2 = row9.getCell(5);
            if (R13cell2 != null) {
                R13cell2.setCellValue(BRF151.getR13_resident_retail() == null ? 0 :
                	BRF151.getR13_resident_retail().intValue());
            }
            Cell R13cell3 = row9.getCell(6);
            if (R13cell3 != null) {
                R13cell3.setCellValue(BRF151.getR13_nonresident_retail() == null ? 0 :
                	BRF151.getR13_nonresident_retail().intValue());
            }
            Cell R13cell4 = row9.getCell(7);
            if (R13cell4 != null) {
                R13cell4.setCellValue(BRF151.getR13_resident_sme() == null ? 0 :
                	BRF151.getR13_resident_sme().intValue());
            }
            Cell R13cell5 = row9.getCell(8);
            if (R13cell5 != null) {
                R13cell5.setCellValue(BRF151.getR13_nonresident_sme() == null ? 0 :
                	BRF151.getR13_nonresident_sme().intValue());
            }
            Cell R13cell6 = row9.getCell(9);
            if (R13cell6 != null) {
                R13cell6.setCellValue(BRF151.getR13_resident_hni() == null ? 0 :
                	BRF151.getR13_resident_hni().intValue());
            }	
            Cell R13cell7 = row9.getCell(10);
            if (R13cell7 != null) {
                R13cell7.setCellValue(BRF151.getR13_nonresident_hni() == null ? 0 :
                	BRF151.getR13_nonresident_hni().intValue());
            }
            Cell R13cell8 = row9.getCell(11);
            if (R13cell8 != null) {
                R13cell8.setCellValue(BRF151.getR13_resident_gres() == null ? 0 :
                	BRF151.getR13_resident_gres().intValue());
            }
            Cell R13cell9 = row9.getCell(12);
            if (R13cell9 != null) {
                R13cell9.setCellValue(BRF151.getR13_nonresident_gres() == null ? 0 :
                	BRF151.getR13_nonresident_gres().intValue());
            }
            ///
            Cell R13cell10 = row9.getCell(13);
            if (R13cell10 != null) {
                R13cell10.setCellValue(BRF151.getR13_resident_corporate() == null ? 0 :
                	BRF151.getR13_resident_corporate().intValue());
            }
            Cell R13cell11 = row9.getCell(14);
            if (R13cell11 != null) {
                R13cell11.setCellValue(BRF151.getR13_nonresident_corporate() == null ? 0 :
                	BRF151.getR13_nonresident_gres().intValue());
            }
            Cell R13cell12 = row9.getCell(15);
            if (R13cell12 != null) {
                R13cell12.setCellValue(BRF151.getR13_resident_nbfi() == null ? 0 :
                	BRF151.getR13_resident_nbfi().intValue());
            }
            Cell R13cell13 = row9.getCell(16);
            if (R13cell13 != null) {
                R13cell13.setCellValue(BRF151.getR13_nonresident_nbfi() == null ? 0 :
                	BRF151.getR13_nonresident_nbfi().intValue());
            }
            
            Cell R13cell14 = row9.getCell(17);
            if (R13cell14 != null) {
                R13cell14.setCellValue(BRF151.getR13_resident_banks() == null ? 0 :
                	BRF151.getR13_resident_banks().intValue());
            }
            
            Cell R13cell15 = row9.getCell(12);
            if (R13cell15 != null) {
                R13cell15.setCellValue(BRF151.getR13_nonresident_banks() == null ? 0 :
                	BRF151.getR13_nonresident_banks().intValue());
            }
            Cell R13cell16 = row9.getCell(12);
            if (R13cell16 != null) {
                R13cell16.setCellValue(BRF151.getR13_resident_gov_nces() == null ? 0 :
                	BRF151.getR13_resident_gov_nces().intValue());
            }
            
            Cell R13cell17 = row9.getCell(12);
            if (R13cell17 != null) {
            	R13cell17.setCellValue(BRF151.getR13_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR13_nonresident_gov_nces().intValue());
            }
        
            /////////////////////////////////ROW14
			Row row10 = sheet.getRow(21);
			Cell R14cell = row10.getCell(3);
            if (R14cell != null) {
                R14cell.setCellValue(BRF151.getR14_resident_individual() == null ? 0 :
                	BRF151.getR14_resident_individual().intValue());
            }
            Cell R14cell1 = row10.getCell(4);
            if (R14cell1 != null) {
                R14cell1.setCellValue(BRF151.getR14_nonresident_individual() == null ? 0 :
                	BRF151.getR14_nonresident_individual().intValue());
            }
            Cell R14cell2 = row10.getCell(5);
            if (R14cell2 != null) {
                R14cell2.setCellValue(BRF151.getR14_resident_retail() == null ? 0 :
                	BRF151.getR14_resident_retail().intValue());
            }
            Cell R14cell3 = row10.getCell(6);
            if (R14cell3 != null) {
                R14cell3.setCellValue(BRF151.getR14_nonresident_retail() == null ? 0 :
                	BRF151.getR14_nonresident_retail().intValue());
            }
            Cell R14cell4 = row10.getCell(7);
            if (R14cell4 != null) {
                R14cell4.setCellValue(BRF151.getR14_resident_sme() == null ? 0 :
                	BRF151.getR14_resident_sme().intValue());
            }
            Cell R14cell5 = row10.getCell(8);
            if (R14cell5 != null) {
                R14cell5.setCellValue(BRF151.getR14_nonresident_sme() == null ? 0 :
                	BRF151.getR14_nonresident_sme().intValue());
            }
            Cell R14cell6 = row10.getCell(9);
            if (R14cell6 != null) {
                R14cell6.setCellValue(BRF151.getR14_resident_hni() == null ? 0 :
                	BRF151.getR14_resident_hni().intValue());
            }	
            Cell R14cell7 = row10.getCell(10);
            if (R14cell7 != null) {
                R14cell7.setCellValue(BRF151.getR14_nonresident_hni() == null ? 0 :
                	BRF151.getR14_nonresident_hni().intValue());
            }
            Cell R14cell8 = row10.getCell(11);
            if (R14cell8 != null) {
                R14cell8.setCellValue(BRF151.getR14_resident_gres() == null ? 0 :
                	BRF151.getR14_resident_gres().intValue());
            }
            Cell R14cell9 = row10.getCell(12);
            if (R14cell9 != null) {
                R14cell9.setCellValue(BRF151.getR14_nonresident_gres() == null ? 0 :
                	BRF151.getR14_nonresident_gres().intValue());
            }
            ///
            Cell R14cell10 = row10.getCell(13);
            if (R14cell10 != null) {
                R14cell10.setCellValue(BRF151.getR14_resident_corporate() == null ? 0 :
                	BRF151.getR14_resident_corporate().intValue());
            }
            Cell R14cell11 = row10.getCell(14);
            if (R14cell11 != null) {
                R14cell11.setCellValue(BRF151.getR14_nonresident_corporate() == null ? 0 :
                	BRF151.getR14_nonresident_gres().intValue());
            }
            Cell R14cell12 = row10.getCell(15);
            if (R14cell12 != null) {
                R14cell12.setCellValue(BRF151.getR14_resident_nbfi() == null ? 0 :
                	BRF151.getR14_resident_nbfi().intValue());
            }
            Cell R14cell13 = row10.getCell(16);
            if (R14cell13 != null) {
                R14cell13.setCellValue(BRF151.getR14_nonresident_nbfi() == null ? 0 :
                	BRF151.getR14_nonresident_nbfi().intValue());
            }
            
            Cell R14cell14 = row10.getCell(17);
            if (R14cell14 != null) {
                R14cell14.setCellValue(BRF151.getR14_resident_banks() == null ? 0 :
                	BRF151.getR14_resident_banks().intValue());
            }
            
            Cell R14cell15 = row10.getCell(12);
            if (R14cell15 != null) {
                R14cell15.setCellValue(BRF151.getR14_nonresident_banks() == null ? 0 :
                	BRF151.getR14_nonresident_banks().intValue());
            }
            Cell R14cell16 = row10.getCell(12);
            if (R14cell16 != null) {
                R14cell16.setCellValue(BRF151.getR14_resident_gov_nces() == null ? 0 :
                	BRF151.getR14_resident_gov_nces().intValue());
            }
            
            Cell R14cell17 = row10.getCell(12);
            if (R14cell17 != null) {
            	R14cell17.setCellValue(BRF151.getR14_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR14_nonresident_gov_nces().intValue());
            }
        
            //////////ROW16
			Row row11 = sheet.getRow(23);
			Cell R16cell = row11.getCell(3);
            if (R16cell != null) {
                R16cell.setCellValue(BRF151.getR16_resident_individual() == null ? 0 :
                	BRF151.getR16_resident_individual().intValue());
            }
            Cell R16cell1 = row11.getCell(4);
            if (R16cell1 != null) {
                R16cell1.setCellValue(BRF151.getR16_nonresident_individual() == null ? 0 :
                	BRF151.getR16_nonresident_individual().intValue());
            }
            Cell R16cell2 = row11.getCell(5);
            if (R16cell2 != null) {
                R16cell2.setCellValue(BRF151.getR16_resident_retail() == null ? 0 :
                	BRF151.getR16_resident_retail().intValue());
            }
            Cell R16cell3 = row11.getCell(6);
            if (R16cell3 != null) {
                R16cell3.setCellValue(BRF151.getR16_nonresident_retail() == null ? 0 :
                	BRF151.getR16_nonresident_retail().intValue());
            }
            Cell R16cell4 = row11.getCell(7);
            if (R16cell4 != null) {
                R16cell4.setCellValue(BRF151.getR16_resident_sme() == null ? 0 :
                	BRF151.getR16_resident_sme().intValue());
            }
            Cell R16cell5 = row11.getCell(8);
            if (R16cell5 != null) {
                R16cell5.setCellValue(BRF151.getR16_nonresident_sme() == null ? 0 :
                	BRF151.getR16_nonresident_sme().intValue());
            }
            Cell R16cell6 = row11.getCell(9);
            if (R16cell6 != null) {
                R16cell6.setCellValue(BRF151.getR16_resident_hni() == null ? 0 :
                	BRF151.getR16_resident_hni().intValue());
            }	
            Cell R16cell7 = row11.getCell(10);
            if (R16cell7 != null) {
                R16cell7.setCellValue(BRF151.getR16_nonresident_hni() == null ? 0 :
                	BRF151.getR16_nonresident_hni().intValue());
            }
            Cell R16cell8 = row11.getCell(11);
            if (R16cell8 != null) {
                R16cell8.setCellValue(BRF151.getR16_resident_gres() == null ? 0 :
                	BRF151.getR16_resident_gres().intValue());
            }
            Cell R16cell9 = row11.getCell(12);
            if (R16cell9 != null) {
                R16cell9.setCellValue(BRF151.getR16_nonresident_gres() == null ? 0 :
                	BRF151.getR16_nonresident_gres().intValue());
            }
            ///
            Cell R16cell10 = row11.getCell(13);
            if (R16cell10 != null) {
                R16cell10.setCellValue(BRF151.getR16_resident_corporate() == null ? 0 :
                	BRF151.getR16_resident_corporate().intValue());
            }
            Cell R16cell11 = row11.getCell(14);
            if (R16cell11 != null) {
                R16cell11.setCellValue(BRF151.getR16_nonresident_corporate() == null ? 0 :
                	BRF151.getR16_nonresident_gres().intValue());
            }
            Cell R16cell12 = row11.getCell(15);
            if (R16cell12 != null) {
                R16cell12.setCellValue(BRF151.getR16_resident_nbfi() == null ? 0 :
                	BRF151.getR16_resident_nbfi().intValue());
            }
            Cell R16cell13 = row11.getCell(16);
            if (R16cell13 != null) {
                R16cell13.setCellValue(BRF151.getR16_nonresident_nbfi() == null ? 0 :
                	BRF151.getR16_nonresident_nbfi().intValue());
            }
            
            Cell R16cell14 = row11.getCell(17);
            if (R16cell14 != null) {
                R16cell14.setCellValue(BRF151.getR16_resident_banks() == null ? 0 :
                	BRF151.getR16_resident_banks().intValue());
            }
            
            Cell R16cell15 = row11.getCell(12);
            if (R16cell15 != null) {
                R16cell15.setCellValue(BRF151.getR16_nonresident_banks() == null ? 0 :
                	BRF151.getR16_nonresident_banks().intValue());
            }
            Cell R16cell16 = row11.getCell(12);
            if (R16cell16 != null) {
                R16cell16.setCellValue(BRF151.getR16_resident_gov_nces() == null ? 0 :
                	BRF151.getR16_resident_gov_nces().intValue());
            }
            
            Cell R16cell17 = row11.getCell(12);
            if (R16cell17 != null) {
            	R16cell17.setCellValue(BRF151.getR16_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR16_nonresident_gov_nces().intValue());
            }
        
            /////ROW17
			Row row12 = sheet.getRow(24);
			Cell R17cell = row12.getCell(3);
            if (R17cell != null) {
                R17cell.setCellValue(BRF151.getR17_resident_individual() == null ? 0 :
                	BRF151.getR17_resident_individual().intValue());
            }
            Cell R17cell1 = row12.getCell(4);
            if (R17cell1 != null) {
                R17cell1.setCellValue(BRF151.getR17_nonresident_individual() == null ? 0 :
                	BRF151.getR17_nonresident_individual().intValue());
            }
            Cell R17cell2 = row12.getCell(5);
            if (R17cell2 != null) {
                R17cell2.setCellValue(BRF151.getR17_resident_retail() == null ? 0 :
                	BRF151.getR17_resident_retail().intValue());
            }
            Cell R17cell3 = row12.getCell(6);
            if (R17cell3 != null) {
                R17cell3.setCellValue(BRF151.getR17_nonresident_retail() == null ? 0 :
                	BRF151.getR17_nonresident_retail().intValue());
            }
            Cell R17cell4 = row12.getCell(7);
            if (R17cell4 != null) {
                R17cell4.setCellValue(BRF151.getR17_resident_sme() == null ? 0 :
                	BRF151.getR17_resident_sme().intValue());
            }
            Cell R17cell5 = row12.getCell(8);
            if (R17cell5 != null) {
                R17cell5.setCellValue(BRF151.getR17_nonresident_sme() == null ? 0 :
                	BRF151.getR17_nonresident_sme().intValue());
            }
            Cell R17cell6 = row12.getCell(9);
            if (R17cell6 != null) {
                R17cell6.setCellValue(BRF151.getR17_resident_hni() == null ? 0 :
                	BRF151.getR17_resident_hni().intValue());
            }	
            Cell R17cell7 = row12.getCell(10);
            if (R17cell7 != null) {
                R17cell7.setCellValue(BRF151.getR17_nonresident_hni() == null ? 0 :
                	BRF151.getR17_nonresident_hni().intValue());
            }
            Cell R17cell8 = row12.getCell(11);
            if (R17cell8 != null) {
                R17cell8.setCellValue(BRF151.getR17_resident_gres() == null ? 0 :
                	BRF151.getR17_resident_gres().intValue());
            }
            Cell R17cell9 = row12.getCell(12);
            if (R17cell9 != null) {
                R17cell9.setCellValue(BRF151.getR17_nonresident_gres() == null ? 0 :
                	BRF151.getR17_nonresident_gres().intValue());
            }
            ///
            Cell R17cell10 = row12.getCell(13);
            if (R17cell10 != null) {
                R17cell10.setCellValue(BRF151.getR17_resident_corporate() == null ? 0 :
                	BRF151.getR17_resident_corporate().intValue());
            }
            Cell R17cell11 = row12.getCell(14);
            if (R17cell11 != null) {
                R17cell11.setCellValue(BRF151.getR17_nonresident_corporate() == null ? 0 :
                	BRF151.getR17_nonresident_gres().intValue());
            }
            Cell R17cell12 = row12.getCell(15);
            if (R17cell12 != null) {
                R17cell12.setCellValue(BRF151.getR17_resident_nbfi() == null ? 0 :
                	BRF151.getR17_resident_nbfi().intValue());
            }
            Cell R17cell13 = row12.getCell(16);
            if (R17cell13 != null) {
                R17cell13.setCellValue(BRF151.getR17_nonresident_nbfi() == null ? 0 :
                	BRF151.getR17_nonresident_nbfi().intValue());
            }
            
            Cell R17cell14 = row12.getCell(17);
            if (R17cell14 != null) {
                R17cell14.setCellValue(BRF151.getR17_resident_banks() == null ? 0 :
                	BRF151.getR17_resident_banks().intValue());
            }
            
            Cell R17cell15 = row12.getCell(12);
            if (R17cell15 != null) {
                R17cell15.setCellValue(BRF151.getR17_nonresident_banks() == null ? 0 :
                	BRF151.getR17_nonresident_banks().intValue());
            }
            Cell R17cell16 = row12.getCell(12);
            if (R17cell16 != null) {
                R17cell16.setCellValue(BRF151.getR17_resident_gov_nces() == null ? 0 :
                	BRF151.getR17_resident_gov_nces().intValue());
            }
            
            Cell R17cell17 = row12.getCell(12);
            if (R17cell17 != null) {
            	R17cell17.setCellValue(BRF151.getR17_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR17_nonresident_gov_nces().intValue());
            }
        
            ///////////ROW18
			Row row13 = sheet.getRow(25);
			Cell R18cell = row13.getCell(3);
            if (R18cell != null) {
                R18cell.setCellValue(BRF151.getR18_resident_individual() == null ? 0 :
                	BRF151.getR18_resident_individual().intValue());
            }
            Cell R18cell1 = row13.getCell(4);
            if (R18cell1 != null) {
                R18cell1.setCellValue(BRF151.getR18_nonresident_individual() == null ? 0 :
                	BRF151.getR18_nonresident_individual().intValue());
            }
            Cell R18cell2 = row13.getCell(5);
            if (R18cell2 != null) {
                R18cell2.setCellValue(BRF151.getR18_resident_retail() == null ? 0 :
                	BRF151.getR18_resident_retail().intValue());
            }
            Cell R18cell3 = row13.getCell(6);
            if (R18cell3 != null) {
                R18cell3.setCellValue(BRF151.getR18_nonresident_retail() == null ? 0 :
                	BRF151.getR18_nonresident_retail().intValue());
            }
            Cell R18cell4 = row13.getCell(7);
            if (R18cell4 != null) {
                R18cell4.setCellValue(BRF151.getR18_resident_sme() == null ? 0 :
                	BRF151.getR18_resident_sme().intValue());
            }
            Cell R18cell5 = row13.getCell(8);
            if (R18cell5 != null) {
                R18cell5.setCellValue(BRF151.getR18_nonresident_sme() == null ? 0 :
                	BRF151.getR18_nonresident_sme().intValue());
            }
            Cell R18cell6 = row13.getCell(9);
            if (R18cell6 != null) {
                R18cell6.setCellValue(BRF151.getR18_resident_hni() == null ? 0 :
                	BRF151.getR18_resident_hni().intValue());
            }	
            Cell R18cell7 = row13.getCell(10);
            if (R18cell7 != null) {
                R18cell7.setCellValue(BRF151.getR18_nonresident_hni() == null ? 0 :
                	BRF151.getR18_nonresident_hni().intValue());
            }
            Cell R18cell8 = row13.getCell(11);
            if (R18cell8 != null) {
                R18cell8.setCellValue(BRF151.getR18_resident_gres() == null ? 0 :
                	BRF151.getR18_resident_gres().intValue());
            }
            Cell R18cell9 = row13.getCell(12);
            if (R18cell9 != null) {
                R18cell9.setCellValue(BRF151.getR18_nonresident_gres() == null ? 0 :
                	BRF151.getR18_nonresident_gres().intValue());
            }
            ///
            Cell R18cell10 = row13.getCell(13);
            if (R18cell10 != null) {
                R18cell10.setCellValue(BRF151.getR18_resident_corporate() == null ? 0 :
                	BRF151.getR18_resident_corporate().intValue());
            }
            Cell R18cell11 = row13.getCell(14);
            if (R18cell11 != null) {
                R18cell11.setCellValue(BRF151.getR18_nonresident_corporate() == null ? 0 :
                	BRF151.getR18_nonresident_gres().intValue());
            }
            Cell R18cell12 = row13.getCell(15);
            if (R18cell12 != null) {
                R18cell12.setCellValue(BRF151.getR18_resident_nbfi() == null ? 0 :
                	BRF151.getR18_resident_nbfi().intValue());
            }
            Cell R18cell13 = row13.getCell(16);
            if (R18cell13 != null) {
                R18cell13.setCellValue(BRF151.getR18_nonresident_nbfi() == null ? 0 :
                	BRF151.getR18_nonresident_nbfi().intValue());
            }
            
            Cell R18cell14 = row13.getCell(17);
            if (R18cell14 != null) {
                R18cell14.setCellValue(BRF151.getR18_resident_banks() == null ? 0 :
                	BRF151.getR18_resident_banks().intValue());
            }
            
            Cell R18cell15 = row13.getCell(12);
            if (R18cell15 != null) {
                R18cell15.setCellValue(BRF151.getR18_nonresident_banks() == null ? 0 :
                	BRF151.getR18_nonresident_banks().intValue());
            }
            Cell R18cell16 = row13.getCell(12);
            if (R18cell16 != null) {
                R18cell16.setCellValue(BRF151.getR18_resident_gov_nces() == null ? 0 :
                	BRF151.getR18_resident_gov_nces().intValue());
            }
            
            Cell R18cell17 = row13.getCell(12);
            if (R18cell17 != null) {
            	R18cell17.setCellValue(BRF151.getR18_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR18_nonresident_gov_nces().intValue());
            }
        
            ////ROW19
			Row row14 = sheet.getRow(26);
			Cell R19cell = row14.getCell(3);
            if (R19cell != null) {
                R19cell.setCellValue(BRF151.getR19_resident_individual() == null ? 0 :
                	BRF151.getR19_resident_individual().intValue());
            }
            Cell R19cell1 = row14.getCell(4);
            if (R19cell1 != null) {
                R19cell1.setCellValue(BRF151.getR19_nonresident_individual() == null ? 0 :
                	BRF151.getR19_nonresident_individual().intValue());
            }
            Cell R19cell2 = row14.getCell(5);
            if (R19cell2 != null) {
                R19cell2.setCellValue(BRF151.getR19_resident_retail() == null ? 0 :
                	BRF151.getR19_resident_retail().intValue());
            }
            Cell R19cell3 = row14.getCell(6);
            if (R19cell3 != null) {
                R19cell3.setCellValue(BRF151.getR19_nonresident_retail() == null ? 0 :
                	BRF151.getR19_nonresident_retail().intValue());
            }
            Cell R19cell4 = row14.getCell(7);
            if (R19cell4 != null) {
                R19cell4.setCellValue(BRF151.getR19_resident_sme() == null ? 0 :
                	BRF151.getR19_resident_sme().intValue());
            }
            Cell R19cell5 = row14.getCell(8);
            if (R19cell5 != null) {
                R19cell5.setCellValue(BRF151.getR19_nonresident_sme() == null ? 0 :
                	BRF151.getR19_nonresident_sme().intValue());
            }
            Cell R19cell6 = row14.getCell(9);
            if (R19cell6 != null) {
                R19cell6.setCellValue(BRF151.getR19_resident_hni() == null ? 0 :
                	BRF151.getR19_resident_hni().intValue());
            }	
            Cell R19cell7 = row14.getCell(10);
            if (R19cell7 != null) {
                R19cell7.setCellValue(BRF151.getR19_nonresident_hni() == null ? 0 :
                	BRF151.getR19_nonresident_hni().intValue());
            }
            Cell R19cell8 = row14.getCell(11);
            if (R19cell8 != null) {
                R19cell8.setCellValue(BRF151.getR19_resident_gres() == null ? 0 :
                	BRF151.getR19_resident_gres().intValue());
            }
            Cell R19cell9 = row14.getCell(12);
            if (R19cell9 != null) {
                R19cell9.setCellValue(BRF151.getR19_nonresident_gres() == null ? 0 :
                	BRF151.getR19_nonresident_gres().intValue());
            }
            ///
            Cell R19cell10 = row14.getCell(13);
            if (R19cell10 != null) {
                R19cell10.setCellValue(BRF151.getR19_resident_corporate() == null ? 0 :
                	BRF151.getR19_resident_corporate().intValue());
            }
            Cell R19cell11 = row14.getCell(14);
            if (R19cell11 != null) {
                R19cell11.setCellValue(BRF151.getR19_nonresident_corporate() == null ? 0 :
                	BRF151.getR19_nonresident_gres().intValue());
            }
            Cell R19cell12 = row14.getCell(15);
            if (R19cell12 != null) {
                R19cell12.setCellValue(BRF151.getR19_resident_nbfi() == null ? 0 :
                	BRF151.getR19_resident_nbfi().intValue());
            }
            Cell R19cell13 = row14.getCell(16);
            if (R19cell13 != null) {
                R19cell13.setCellValue(BRF151.getR19_nonresident_nbfi() == null ? 0 :
                	BRF151.getR19_nonresident_nbfi().intValue());
            }
            
            Cell R19cell14 = row14.getCell(17);
            if (R19cell14 != null) {
                R19cell14.setCellValue(BRF151.getR19_resident_banks() == null ? 0 :
                	BRF151.getR19_resident_banks().intValue());
            }
            
            Cell R19cell15 = row14.getCell(12);
            if (R19cell15 != null) {
                R19cell15.setCellValue(BRF151.getR19_nonresident_banks() == null ? 0 :
                	BRF151.getR19_nonresident_banks().intValue());
            }
            Cell R19cell16 = row14.getCell(12);
            if (R19cell16 != null) {
                R19cell16.setCellValue(BRF151.getR19_resident_gov_nces() == null ? 0 :
                	BRF151.getR19_resident_gov_nces().intValue());
            }
            
            Cell R19cell17 = row14.getCell(12);
            if (R19cell17 != null) {
            	R19cell17.setCellValue(BRF151.getR19_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR19_nonresident_gov_nces().intValue());
            }
        
			 ////ROW20
			Row row15 = sheet.getRow(27);
			
			Cell R20cell = row15.getCell(3);
            if (R20cell != null) {
                R20cell.setCellValue(BRF151.getR20_resident_individual() == null ? 0 :
                	BRF151.getR20_resident_individual().intValue());
            }
            Cell R20cell1 = row15.getCell(4);
            if (R20cell1 != null) {
                R20cell1.setCellValue(BRF151.getR20_nonresident_individual() == null ? 0 :
                	BRF151.getR20_nonresident_individual().intValue());
            }
            Cell R20cell2 = row15.getCell(5);
            if (R20cell2 != null) {
                R20cell2.setCellValue(BRF151.getR20_resident_retail() == null ? 0 :
                	BRF151.getR20_resident_retail().intValue());
            }
            Cell R20cell3 = row15.getCell(6);
            if (R20cell3 != null) {
                R20cell3.setCellValue(BRF151.getR20_nonresident_retail() == null ? 0 :
                	BRF151.getR20_nonresident_retail().intValue());
            }
            Cell R20cell4 = row15.getCell(7);
            if (R20cell4 != null) {
                R20cell4.setCellValue(BRF151.getR20_resident_sme() == null ? 0 :
                	BRF151.getR20_resident_sme().intValue());
            }
            Cell R20cell5 = row15.getCell(8);
            if (R20cell5 != null) {
                R20cell5.setCellValue(BRF151.getR20_nonresident_sme() == null ? 0 :
                	BRF151.getR20_nonresident_sme().intValue());
            }
            Cell R20cell6 = row15.getCell(9);
            if (R20cell6 != null) {
                R20cell6.setCellValue(BRF151.getR20_resident_hni() == null ? 0 :
                	BRF151.getR20_resident_hni().intValue());
            }	
            Cell R20cell7 = row15.getCell(10);
            if (R20cell7 != null) {
                R20cell7.setCellValue(BRF151.getR20_nonresident_hni() == null ? 0 :
                	BRF151.getR20_nonresident_hni().intValue());
            }
            Cell R20cell8 = row15.getCell(11);
            if (R20cell8 != null) {
                R20cell8.setCellValue(BRF151.getR20_resident_gres() == null ? 0 :
                	BRF151.getR20_resident_gres().intValue());
            }
            Cell R20cell9 = row15.getCell(12);
            if (R20cell9 != null) {
                R20cell9.setCellValue(BRF151.getR20_nonresident_gres() == null ? 0 :
                	BRF151.getR20_nonresident_gres().intValue());
            }
            ///
            Cell R20cell10 = row15.getCell(13);
            if (R20cell10 != null) {
                R20cell10.setCellValue(BRF151.getR20_resident_corporate() == null ? 0 :
                	BRF151.getR20_resident_corporate().intValue());
            }
            Cell R20cell11 = row15.getCell(14);
            if (R20cell11 != null) {
                R20cell11.setCellValue(BRF151.getR20_nonresident_corporate() == null ? 0 :
                	BRF151.getR20_nonresident_gres().intValue());
            }
            Cell R20cell12 = row15.getCell(15);
            if (R20cell12 != null) {
                R20cell12.setCellValue(BRF151.getR20_resident_nbfi() == null ? 0 :
                	BRF151.getR20_resident_nbfi().intValue());
            }
            Cell R20cell13 = row15.getCell(16);
            if (R20cell13 != null) {
                R20cell13.setCellValue(BRF151.getR20_nonresident_nbfi() == null ? 0 :
                	BRF151.getR20_nonresident_nbfi().intValue());
            }
            
            Cell R20cell14 = row15.getCell(17);
            if (R20cell14 != null) {
                R20cell14.setCellValue(BRF151.getR20_resident_banks() == null ? 0 :
                	BRF151.getR20_resident_banks().intValue());
            }
            
            Cell R20cell15 = row15.getCell(12);
            if (R20cell15 != null) {
                R20cell15.setCellValue(BRF151.getR20_nonresident_banks() == null ? 0 :
                	BRF151.getR20_nonresident_banks().intValue());
            }
            Cell R20cell16 = row15.getCell(12);
            if (R20cell16 != null) {
                R20cell16.setCellValue(BRF151.getR20_resident_gov_nces() == null ? 0 :
                	BRF151.getR20_resident_gov_nces().intValue());
            }
            
            Cell R20cell17 = row15.getCell(12);
            if (R20cell17 != null) {
            	R20cell17.setCellValue(BRF151.getR20_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR20_nonresident_gov_nces().intValue());
            }
        
			 ////ROW21
			Row row16 = sheet.getRow(28);
           
			Cell R21cell = row16.getCell(3);
            if (R21cell != null) {
                R21cell.setCellValue(BRF151.getR21_resident_individual() == null ? 0 :
                	BRF151.getR21_resident_individual().intValue());
            }
            Cell R21cell1 = row16.getCell(4);
            if (R21cell1 != null) {
                R21cell1.setCellValue(BRF151.getR21_nonresident_individual() == null ? 0 :
                	BRF151.getR21_nonresident_individual().intValue());
            }
            Cell R21cell2 = row16.getCell(5);
            if (R21cell2 != null) {
                R21cell2.setCellValue(BRF151.getR21_resident_retail() == null ? 0 :
                	BRF151.getR21_resident_retail().intValue());
            }
            Cell R21cell3 = row16.getCell(6);
            if (R21cell3 != null) {
                R21cell3.setCellValue(BRF151.getR21_nonresident_retail() == null ? 0 :
                	BRF151.getR21_nonresident_retail().intValue());
            }
            Cell R21cell4 = row16.getCell(7);
            if (R21cell4 != null) {
                R21cell4.setCellValue(BRF151.getR21_resident_sme() == null ? 0 :
                	BRF151.getR21_resident_sme().intValue());
            }
            Cell R21cell5 = row16.getCell(8);
            if (R21cell5 != null) {
                R21cell5.setCellValue(BRF151.getR21_nonresident_sme() == null ? 0 :
                	BRF151.getR21_nonresident_sme().intValue());
            }
            Cell R21cell6 = row16.getCell(9);
            if (R21cell6 != null) {
                R21cell6.setCellValue(BRF151.getR21_resident_hni() == null ? 0 :
                	BRF151.getR21_resident_hni().intValue());
            }	
            Cell R21cell7 = row16.getCell(10);
            if (R21cell7 != null) {
                R21cell7.setCellValue(BRF151.getR21_nonresident_hni() == null ? 0 :
                	BRF151.getR21_nonresident_hni().intValue());
            }
            Cell R21cell8 = row16.getCell(11);
            if (R21cell8 != null) {
                R21cell8.setCellValue(BRF151.getR21_resident_gres() == null ? 0 :
                	BRF151.getR21_resident_gres().intValue());
            }
            Cell R21cell9 = row16.getCell(12);
            if (R21cell9 != null) {
                R21cell9.setCellValue(BRF151.getR21_nonresident_gres() == null ? 0 :
                	BRF151.getR21_nonresident_gres().intValue());
            }
            ///
            Cell R21cell10 = row16.getCell(13);
            if (R21cell10 != null) {
                R21cell10.setCellValue(BRF151.getR21_resident_corporate() == null ? 0 :
                	BRF151.getR21_resident_corporate().intValue());
            }
            Cell R21cell11 = row16.getCell(14);
            if (R21cell11 != null) {
                R21cell11.setCellValue(BRF151.getR21_nonresident_corporate() == null ? 0 :
                	BRF151.getR21_nonresident_gres().intValue());
            }
            Cell R21cell12 = row16.getCell(15);
            if (R21cell12 != null) {
                R21cell12.setCellValue(BRF151.getR21_resident_nbfi() == null ? 0 :
                	BRF151.getR21_resident_nbfi().intValue());
            }
            Cell R21cell13 = row16.getCell(16);
            if (R21cell13 != null) {
                R21cell13.setCellValue(BRF151.getR21_nonresident_nbfi() == null ? 0 :
                	BRF151.getR21_nonresident_nbfi().intValue());
            }
            
            Cell R21cell14 = row16.getCell(17);
            if (R21cell14 != null) {
                R21cell14.setCellValue(BRF151.getR21_resident_banks() == null ? 0 :
                	BRF151.getR21_resident_banks().intValue());
            }
            
            Cell R21cell15 = row16.getCell(12);
            if (R21cell15 != null) {
                R21cell15.setCellValue(BRF151.getR21_nonresident_banks() == null ? 0 :
                	BRF151.getR21_nonresident_banks().intValue());
            }
            Cell R21cell16 = row16.getCell(12);
            if (R21cell16 != null) {
                R21cell16.setCellValue(BRF151.getR21_resident_gov_nces() == null ? 0 :
                	BRF151.getR21_resident_gov_nces().intValue());
            }
            
            Cell R21cell17 = row16.getCell(12);
            if (R21cell17 != null) {
            	R21cell17.setCellValue(BRF151.getR21_nonresident_gov_nces() == null ? 0 :
                	BRF151.getR21_nonresident_gov_nces().intValue());
            }
        
            
            // Save the changes
            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-151-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-151-A.xls");

	return outputFile;



}


	

	public String detailChanges151(BRF151_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF151_DETAIL_ENTITY> Brf10detail = brf151DetailRep.findById(foracid);

			if (Brf10detail.isPresent()) {
				BRF151_DETAIL_ENTITY BRFdetail = Brf10detail.get();

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
					brf151DetailRep.save(BRFdetail);

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
	public ModelAndView getArchieveBRF151View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF151reportentity> T1rep = new ArrayList<BRF151reportentity>();
		// Query<Object[]> qr;

		List<BRF151reportentity> T1Master = new ArrayList<BRF151reportentity>();
		
		
		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF151reportentity a where a.report_date = ?1 ", BRF151reportentity.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
		

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF151ARCH");
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
	public ModelAndView ARCHgetBRF151currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF151_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF151_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF151_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF151_ARCHIV_ENTITY> T1Master = new ArrayList<BRF151_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF151_ARCHIV_ENTITY a where a.report_date = ?1", BRF151_ARCHIV_ENTITY.class)
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

			BRF151_ARCHIV_ENTITY py = new BRF151_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
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

		mv.setViewName("RR" + "/" + "BRF151ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
}





