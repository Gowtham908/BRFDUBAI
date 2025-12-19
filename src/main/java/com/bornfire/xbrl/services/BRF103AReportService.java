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

import com.bornfire.xbrl.entities.BRBS.BRF093AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF094AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF100AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF103AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF103_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF103_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF103AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF102AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF102_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF104AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF44_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF64_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF103_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF103_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF68_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF68_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF96AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF103_ENTITY;


import com.bornfire.xbrl.entities.BRBS.BRF_102_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF103_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF104_REPORTENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF103_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
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
public class BRF103AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF103AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	
	
	@Autowired
	BRF103AServiceRepo brf103aServiceRepo; 
	
	@Autowired
	BRF103_DetailRep brf103_DetailRep;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF103A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF103_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF103_ENTITY a ").getSingleResult();
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


	public ModelAndView getBRF103AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF103_ENTITY> T1rep = new ArrayList<BRF103_ENTITY>();
		// Query<Object[]> qr;

		List<BRF103_ENTITY> T1Master = new ArrayList<BRF103_ENTITY>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF103_ENTITY a where a.report_date = ?1 ", BRF103_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF103A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	
	public File getFileBRF103A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-103-A";
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

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF103_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF103_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF103.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF103.jrxml");
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
				
				List<BRF103_ENTITY> T1Master = new ArrayList<BRF103_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF103_ENTITY a where a.report_date = ?1 ", BRF103_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF103_ENTITY BRF103 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-103-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(10);
	           
	            Cell cell12 = row.getCell(16);
		       	 if (cell12 != null) {
		            cell12.setCellValue(BRF103.getR2_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR2_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell cell13 = row.getCell(17);
		       	 if (cell13 != null) {
		            cell13.setCellValue(BRF103.getR2_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR2_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell cell14 = row.getCell(18);
		       	 if (cell14 != null) {
		            cell14.setCellValue(BRF103.getR2_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR2_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell cell15 = row.getCell(19);
		       	 if (cell15 != null) {
		            cell15.setCellValue(BRF103.getR2_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR2_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell cell16 = row.getCell(20);
		       	 if (cell16 != null) {
		            cell16.setCellValue(BRF103.getR2_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR2_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell cell17 = row.getCell(21);
		       	 if (cell17 != null) {
		            cell17.setCellValue(BRF103.getR2_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR2_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell cell18 = row.getCell(22);
		       	 if (cell18 != null) {
		            cell18.setCellValue(BRF103.getR2_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR2_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell cell19 = row.getCell(23);
		       	 if (cell19 != null) {
		            cell19.setCellValue(BRF103.getR2_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR2_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
	       	 
		            /////////////////////R3/////////////////           
				   
				 Row R1row = sheet.getRow(11);
				
				Cell R1cell12 = R1row.getCell(16);
		       	 if (R1cell12 != null) {
		            R1cell12.setCellValue(BRF103.getR3_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR3_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R1cell13 = R1row.getCell(17);
		       	 if (R1cell13 != null) {
		            R1cell13.setCellValue(BRF103.getR3_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR3_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R1cell14 = R1row.getCell(18);
		       	 if (R1cell14 != null) {
		            R1cell14.setCellValue(BRF103.getR3_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR3_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R1cell15 = R1row.getCell(19);
		       	 if (R1cell15 != null) {
		            R1cell15.setCellValue(BRF103.getR3_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR3_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R1cell16 = R1row.getCell(20);
		       	 if (R1cell16 != null) {
		            R1cell16.setCellValue(BRF103.getR3_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR3_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R1cell17 = R1row.getCell(21);
		       	 if (R1cell17 != null) {
		            R1cell17.setCellValue(BRF103.getR3_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR3_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R1cell18 = R1row.getCell(22);
		       	 if (R1cell18 != null) {
		            R1cell18.setCellValue(BRF103.getR3_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR3_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R1cell19 = R1row.getCell(23);
		       	 if (R1cell19 != null) {
		            R1cell19.setCellValue(BRF103.getR3_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR3_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	 
		            /////////////////////R4/////////////////           
				   
				 Row R2row = sheet.getRow(12);
				
				Cell R2cell12 = R2row.getCell(16);
		       	 if (R2cell12 != null) {
		            R2cell12.setCellValue(BRF103.getR4_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR4_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R2cell13 = R2row.getCell(17);
		       	 if (R2cell13 != null) {
		            R2cell13.setCellValue(BRF103.getR4_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR4_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R2cell14 = R2row.getCell(18);
		       	 if (R2cell14 != null) {
		            R2cell14.setCellValue(BRF103.getR4_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR4_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R2cell15 = R2row.getCell(19);
		       	 if (R2cell15 != null) {
		            R2cell15.setCellValue(BRF103.getR4_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR4_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R2cell16 = R2row.getCell(20);
		       	 if (R2cell16 != null) {
		            R2cell16.setCellValue(BRF103.getR4_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR4_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R2cell17 = R2row.getCell(21);
		       	 if (R2cell17 != null) {
		            R2cell17.setCellValue(BRF103.getR4_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR4_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R2cell18 = R2row.getCell(22);
		       	 if (R2cell18 != null) {
		            R2cell18.setCellValue(BRF103.getR4_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR4_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R2cell19 = R2row.getCell(23);
		       	 if (R2cell19 != null) {
		            R2cell19.setCellValue(BRF103.getR4_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR4_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	 
		       	 /////////////////////R5/////////////////           
				   
				 Row R3row = sheet.getRow(13);
				 
				 Cell R3cell16 = R3row.getCell(20);
		       	 if (R3cell16 != null) {
		            R3cell16.setCellValue(BRF103.getR5_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR5_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R3cell17 = R3row.getCell(21);
		       	 if (R3cell17 != null) {
		            R3cell17.setCellValue(BRF103.getR5_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR5_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R3cell18 = R3row.getCell(22);
		       	 if (R3cell18 != null) {
		            R3cell18.setCellValue(BRF103.getR5_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR5_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R3cell19 = R3row.getCell(23);
		       	 if (R3cell19 != null) {
		            R3cell19.setCellValue(BRF103.getR5_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR5_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		            /////////////////////R7/////////////////           
				   
				 Row R4row = sheet.getRow(15);
				
				Cell R4cell12 = R4row.getCell(16);
		       	 if (R4cell12 != null) {
		            R4cell12.setCellValue(BRF103.getR7_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR7_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R4cell13 = R4row.getCell(17);
		       	 if (R4cell13 != null) {
		            R4cell13.setCellValue(BRF103.getR7_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR7_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R4cell14 = R4row.getCell(18);
		       	 if (R4cell14 != null) {
		            R4cell14.setCellValue(BRF103.getR7_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR7_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R4cell15 = R4row.getCell(19);
		       	 if (R4cell15 != null) {
		            R4cell15.setCellValue(BRF103.getR7_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR7_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R4cell16 = R4row.getCell(20);
		       	 if (R4cell16 != null) {
		            R4cell16.setCellValue(BRF103.getR7_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR7_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R4cell17 = R4row.getCell(21);
		       	 if (R4cell17 != null) {
		            R4cell17.setCellValue(BRF103.getR7_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR7_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R4cell18 = R4row.getCell(22);
		       	 if (R4cell18 != null) {
		            R4cell18.setCellValue(BRF103.getR7_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR7_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R4cell19 = R4row.getCell(23);
		       	 if (R4cell19 != null) {
		            R4cell19.setCellValue(BRF103.getR7_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR7_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	 
		            /////////////////////R8/////////////////           
				   
				 Row R5row = sheet.getRow(16);
				
				Cell R5cell12 = R5row.getCell(16);
		       	 if (R5cell12 != null) {
		            R5cell12.setCellValue(BRF103.getR8_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR8_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R5cell13 = R5row.getCell(17);
		       	 if (R5cell13 != null) {
		            R5cell13.setCellValue(BRF103.getR8_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR8_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R5cell14 = R5row.getCell(18);
		       	 if (R5cell14 != null) {
		            R5cell14.setCellValue(BRF103.getR8_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR8_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R5cell15 = R5row.getCell(19);
		       	 if (R5cell15 != null) {
		            R5cell15.setCellValue(BRF103.getR8_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR8_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R5cell16 = R5row.getCell(20);
		       	 if (R5cell16 != null) {
		            R5cell16.setCellValue(BRF103.getR8_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR8_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R5cell17 = R5row.getCell(21);
		       	 if (R5cell17 != null) {
		            R5cell17.setCellValue(BRF103.getR8_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR8_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R5cell18 = R5row.getCell(22);
		       	 if (R5cell18 != null) {
		            R5cell18.setCellValue(BRF103.getR8_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR8_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R5cell19 = R5row.getCell(23);
		       	 if (R5cell19 != null) {
		            R5cell19.setCellValue(BRF103.getR8_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR8_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		            /////////////////////R9/////////////////           
				   
				 Row R6row = sheet.getRow(17);
				
				Cell R6cell12 = R6row.getCell(16);
		       	 if (R6cell12 != null) {
		            R6cell12.setCellValue(BRF103.getR9_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR9_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R6cell13 = R6row.getCell(17);
		       	 if (R6cell13 != null) {
		            R6cell13.setCellValue(BRF103.getR9_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR9_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R6cell14 = R6row.getCell(18);
		       	 if (R6cell14 != null) {
		            R6cell14.setCellValue(BRF103.getR9_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR9_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R6cell15 = R6row.getCell(19);
		       	 if (R6cell15 != null) {
		            R6cell15.setCellValue(BRF103.getR9_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR9_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R6cell16 = R6row.getCell(20);
		       	 if (R6cell16 != null) {
		            R6cell16.setCellValue(BRF103.getR9_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR9_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R6cell17 = R6row.getCell(21);
		       	 if (R6cell17 != null) {
		            R6cell17.setCellValue(BRF103.getR9_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR9_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R6cell18 = R6row.getCell(22);
		       	 if (R6cell18 != null) {
		            R6cell18.setCellValue(BRF103.getR9_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR9_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R6cell19 = R6row.getCell(23);
		       	 if (R6cell19 != null) {
		            R6cell19.setCellValue(BRF103.getR9_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR9_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		            /////////////////////R10/////////////////           
				   
				 Row R7row = sheet.getRow(18);
				
				
		       	 
		       	Cell R7cell16 = R7row.getCell(20);
		       	 if (R7cell16 != null) {
		            R7cell16.setCellValue(BRF103.getR10_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR10_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R7cell17 = R7row.getCell(21);
		       	 if (R7cell17 != null) {
		            R7cell17.setCellValue(BRF103.getR10_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR10_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R7cell18 = R7row.getCell(22);
		       	 if (R7cell18 != null) {
		            R7cell18.setCellValue(BRF103.getR10_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR10_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R7cell19 = R7row.getCell(23);
		       	 if (R7cell19 != null) {
		            R7cell19.setCellValue(BRF103.getR10_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR10_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		            /////////////////////R12/////////////////           
				   
				 Row R8row = sheet.getRow(20);
				
				Cell R8cell12 = R8row.getCell(16);
		       	 if (R8cell12 != null) {
		            R8cell12.setCellValue(BRF103.getR12_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR12_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R8cell13 = R8row.getCell(17);
		       	 if (R8cell13 != null) {
		            R8cell13.setCellValue(BRF103.getR12_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR12_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R8cell14 = R8row.getCell(18);
		       	 if (R8cell14 != null) {
		            R8cell14.setCellValue(BRF103.getR12_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR12_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R8cell15 = R8row.getCell(19);
		       	 if (R8cell15 != null) {
		            R8cell15.setCellValue(BRF103.getR12_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR12_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R8cell16 = R8row.getCell(20);
		       	 if (R8cell16 != null) {
		            R8cell16.setCellValue(BRF103.getR12_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR12_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R8cell17 = R8row.getCell(21);
		       	 if (R8cell17 != null) {
		            R8cell17.setCellValue(BRF103.getR12_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR12_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R8cell18 = R8row.getCell(22);
		       	 if (R8cell18 != null) {
		            R8cell18.setCellValue(BRF103.getR12_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR12_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R8cell19 = R8row.getCell(23);
		       	 if (R8cell19 != null) {
		            R8cell19.setCellValue(BRF103.getR12_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR12_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	 
		            /////////////////////R13/////////////////           
				   
				 Row R9row = sheet.getRow(21);
				
				Cell R9cell12 = R9row.getCell(16);
		       	 if (R9cell12 != null) {
		            R9cell12.setCellValue(BRF103.getR13_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR13_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R9cell13 = R9row.getCell(17);
		       	 if (R9cell13 != null) {
		            R9cell13.setCellValue(BRF103.getR13_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR13_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R9cell14 = R9row.getCell(18);
		       	 if (R9cell14 != null) {
		            R9cell14.setCellValue(BRF103.getR13_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR13_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R9cell15 = R9row.getCell(19);
		       	 if (R9cell15 != null) {
		            R9cell15.setCellValue(BRF103.getR13_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR13_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R9cell16 = R9row.getCell(20);
		       	 if (R9cell16 != null) {
		            R9cell16.setCellValue(BRF103.getR13_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR13_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R9cell17 = R9row.getCell(21);
		       	 if (R9cell17 != null) {
		            R9cell17.setCellValue(BRF103.getR13_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR13_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R9cell18 = R9row.getCell(22);
		       	 if (R9cell18 != null) {
		            R9cell18.setCellValue(BRF103.getR13_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR13_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R9cell19 = R9row.getCell(23);
		       	 if (R9cell19 != null) {
		            R9cell19.setCellValue(BRF103.getR13_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR13_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
	             Cell R9cell24 = R9row.getCell(28);
		       	 if (R9cell24 != null) {
		            R9cell24.setCellValue(BRF103.getR13_ACCOUNTS_AED_DORMANT() == null ? 0 :
		       	     	BRF103.getR13_ACCOUNTS_AED_DORMANT().intValue());
		       	 }
		       	 
		     	 Cell R9cell25 = R9row.getCell(29);
		       	 if (R9cell25 != null) {
		            R9cell25.setCellValue(BRF103.getR13_AMOUNT_AED_DORMANT() == null ? 0 :
		       	     	BRF103.getR13_AMOUNT_AED_DORMANT().intValue());
		       	 }
		       	 
		       	 
		       	Cell R9cell26 = R9row.getCell(30);
		       	 if (R9cell26 != null) {
		            R9cell26.setCellValue(BRF103.getR13_ACCOUNTS_FCY_DORMANT() == null ? 0 :
		       	     	BRF103.getR13_ACCOUNTS_FCY_DORMANT().intValue());
		       	 }
		       	 
		     	Cell R9cell27 = R9row.getCell(31);
		       	 if (R9cell27 != null) {
		            R9cell27.setCellValue(BRF103.getR13_AMOUNT_FCY_DORMANT() == null ? 0 :
		       	     	BRF103.getR13_AMOUNT_FCY_DORMANT().intValue());
		       	 }
		       	 
		       	 
		            /////////////////////R14/////////////////           
				   
				 Row R10row = sheet.getRow(22);
				
				Cell R10cell12 = R10row.getCell(16);
		       	 if (R10cell12 != null) {
		            R10cell12.setCellValue(BRF103.getR14_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR14_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R10cell13 = R10row.getCell(17);
		       	 if (R10cell13 != null) {
		            R10cell13.setCellValue(BRF103.getR14_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR14_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R10cell14 = R10row.getCell(18);
		       	 if (R10cell14 != null) {
		            R10cell14.setCellValue(BRF103.getR14_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR14_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R10cell15 = R10row.getCell(19);
		       	 if (R10cell15 != null) {
		            R10cell15.setCellValue(BRF103.getR14_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR14_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R10cell16 = R10row.getCell(20);
		       	 if (R10cell16 != null) {
		            R10cell16.setCellValue(BRF103.getR14_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR14_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R10cell17 = R10row.getCell(21);
		       	 if (R10cell17 != null) {
		            R10cell17.setCellValue(BRF103.getR14_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR14_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R10cell18 = R10row.getCell(22);
		       	 if (R10cell18 != null) {
		            R10cell18.setCellValue(BRF103.getR14_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR14_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R10cell19 = R10row.getCell(23);
		       	 if (R10cell19 != null) {
		            R10cell19.setCellValue(BRF103.getR14_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR14_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		            /////////////////////R15/////////////////           
				   
				 Row R11row = sheet.getRow(23);
				
		       	 
		       	Cell R11cell16 = R11row.getCell(20);
		       	 if (R11cell16 != null) {
		            R11cell16.setCellValue(BRF103.getR15_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR15_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R11cell17 = R11row.getCell(21);
		       	 if (R11cell17 != null) {
		            R11cell17.setCellValue(BRF103.getR15_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR15_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R11cell18 = R11row.getCell(22);
		       	 if (R11cell18 != null) {
		            R11cell18.setCellValue(BRF103.getR15_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR15_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R11cell19 = R11row.getCell(23);
		       	 if (R11cell19 != null) {
		            R11cell19.setCellValue(BRF103.getR15_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR15_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		            /////////////////////R17/////////////////           
				   
				 Row R12row = sheet.getRow(25);
				Cell R12cell4 = R12row.getCell(8);
		       	 if (R12cell4 != null) {
		            R12cell4.setCellValue(BRF103.getR17_ACCOUNTS_AED_2YEAR() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_AED_2YEAR().intValue());
		       	 }
				 
				 Cell R12cell5 = R12row.getCell(9);
		       	 if (R12cell5 != null) {
		            R12cell5.setCellValue(BRF103.getR17_AMOUNT_AED_2YEAR() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_AED_2YEAR().intValue());
		       	 }
				 
				  Cell R12cell6 = R12row.getCell(10);
		       	 if (R12cell6!= null) {
		            R12cell6.setCellValue(BRF103.getR17_ACCOUNTS_FCY_2YEAR() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_FCY_2YEAR().intValue());
		       	 }
				 
				 Cell R12cell7 = R12row.getCell(11);
		       	 if (R12cell7 != null) {
		            R12cell7.setCellValue(BRF103.getR17_AMOUNT_FCY_2YEAR() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_FCY_2YEAR().intValue());
		       	 }
				 
				  
				 Cell R12cell8 = R12row.getCell(12);
		       	 if (R12cell8 != null) {
		            R12cell8.setCellValue(BRF103.getR17_ACCOUNTS_AED_3YEAR() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_AED_3YEAR().intValue());
		       	 }
				 
				 
				  
				 Cell R12cell9 = R12row.getCell(13);
		       	 if (R12cell9 != null) {
		            R12cell9.setCellValue(BRF103.getR17_AMOUNT_AED_3YEAR() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_AED_3YEAR().intValue());
		       	 }
				 
				 
				 Cell R12cell10 = R12row.getCell(14);
		       	 if (R12cell10 != null) {
		            R12cell10.setCellValue(BRF103.getR17_ACCOUNTS_FCY_3YEAR() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_FCY_3YEAR().intValue());
		       	 }
				 
				 Cell R12cell11 = R12row.getCell(15);
		       	 if (R12cell11 != null) {
		            R12cell11.setCellValue(BRF103.getR17_AMOUNT_FCY_3YEAR() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_FCY_3YEAR().intValue());
		       	 }
				 
				
				
				
				Cell R12cell12 = R12row.getCell(16);
		       	 if (R12cell12 != null) {
		            R12cell12.setCellValue(BRF103.getR17_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R12cell13 = R12row.getCell(17);
		       	 if (R12cell13 != null) {
		            R12cell13.setCellValue(BRF103.getR17_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R12cell14 = R12row.getCell(18);
		       	 if (R12cell14 != null) {
		            R12cell14.setCellValue(BRF103.getR17_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R12cell15 = R12row.getCell(19);
		       	 if (R12cell15 != null) {
		            R12cell15.setCellValue(BRF103.getR17_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R12cell16 = R12row.getCell(20);
		       	 if (R12cell16 != null) {
		            R12cell16.setCellValue(BRF103.getR17_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R12cell17 = R12row.getCell(21);
		       	 if (R12cell17 != null) {
		            R12cell17.setCellValue(BRF103.getR17_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R12cell18 = R12row.getCell(22);
		       	 if (R12cell18 != null) {
		            R12cell18.setCellValue(BRF103.getR17_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR17_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R12cell19 = R12row.getCell(23);
		       	 if (R12cell19 != null) {
		            R12cell19.setCellValue(BRF103.getR17_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR17_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		            /////////////////////R18/////////////////           
				   
				 Row R13row = sheet.getRow(26);
				Cell R13cell4 = R13row.getCell(8);
		       	 if (R13cell4 != null) {
		            R13cell4.setCellValue(BRF103.getR18_ACCOUNTS_AED_2YEAR() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_AED_2YEAR().intValue());
		       	 }
				 
				 Cell R13cell5 = R13row.getCell(9);
		       	 if (R13cell5 != null) {
		            R13cell5.setCellValue(BRF103.getR18_AMOUNT_AED_2YEAR() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_AED_2YEAR().intValue());
		       	 }
				 
				  Cell R13cell6 = R13row.getCell(10);
		       	 if (R13cell6!= null) {
		            R13cell6.setCellValue(BRF103.getR18_ACCOUNTS_FCY_2YEAR() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_FCY_2YEAR().intValue());
		       	 }
				 
				 Cell R13cell7 = R13row.getCell(11);
		       	 if (R13cell7 != null) {
		            R13cell7.setCellValue(BRF103.getR18_AMOUNT_FCY_2YEAR() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_FCY_2YEAR().intValue());
		       	 }
				 
				  
				 Cell R13cell8 = R13row.getCell(12);
		       	 if (R13cell8 != null) {
		            R13cell8.setCellValue(BRF103.getR18_ACCOUNTS_AED_3YEAR() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_AED_3YEAR().intValue());
		       	 }
				 
				 
				  
				 Cell R13cell9 = R13row.getCell(13);
		       	 if (R13cell9 != null) {
		            R13cell9.setCellValue(BRF103.getR18_AMOUNT_AED_3YEAR() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_AED_3YEAR().intValue());
		       	 }
				 
				 
				 Cell R13cell10 = R13row.getCell(14);
		       	 if (R13cell10 != null) {
		            R13cell10.setCellValue(BRF103.getR18_ACCOUNTS_FCY_3YEAR() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_FCY_3YEAR().intValue());
		       	 }
				 
				 Cell R13cell11 = R13row.getCell(15);
		       	 if (R13cell11 != null) {
		            R13cell11.setCellValue(BRF103.getR18_AMOUNT_FCY_3YEAR() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_FCY_3YEAR().intValue());
		       	 }
				 
				
				
				
				Cell R13cell12 = R13row.getCell(16);
		       	 if (R13cell12 != null) {
		            R13cell12.setCellValue(BRF103.getR18_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R13cell13 = R13row.getCell(17);
		       	 if (R13cell13 != null) {
		            R13cell13.setCellValue(BRF103.getR18_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R13cell14 = R13row.getCell(18);
		       	 if (R13cell14 != null) {
		            R13cell14.setCellValue(BRF103.getR18_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R13cell15 = R13row.getCell(19);
		       	 if (R13cell15 != null) {
		            R13cell15.setCellValue(BRF103.getR18_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R13cell16 = R13row.getCell(20);
		       	 if (R13cell16 != null) {
		            R13cell16.setCellValue(BRF103.getR18_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R13cell17 = R13row.getCell(21);
		       	 if (R13cell17 != null) {
		            R13cell17.setCellValue(BRF103.getR18_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R13cell18 = R13row.getCell(22);
		       	 if (R13cell18 != null) {
		            R13cell18.setCellValue(BRF103.getR18_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR18_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R13cell19 = R13row.getCell(23);
		       	 if (R13cell19 != null) {
		            R13cell19.setCellValue(BRF103.getR18_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR18_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		            /////////////////////R19/////////////////           
				   
				 Row R14row = sheet.getRow(27);
				Cell R14cell4 = R14row.getCell(8);
		       	 if (R14cell4 != null) {
		            R14cell4.setCellValue(BRF103.getR19_ACCOUNTS_AED_2YEAR() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_AED_2YEAR().intValue());
		       	 }
				 
				 Cell R14cell5 = R14row.getCell(9);
		       	 if (R14cell5 != null) {
		            R14cell5.setCellValue(BRF103.getR19_AMOUNT_AED_2YEAR() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_AED_2YEAR().intValue());
		       	 }
				 
				  Cell R14cell6 = R14row.getCell(10);
		       	 if (R14cell6!= null) {
		            R14cell6.setCellValue(BRF103.getR19_ACCOUNTS_FCY_2YEAR() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_FCY_2YEAR().intValue());
		       	 }
				 
				 Cell R14cell7 = R14row.getCell(11);
		       	 if (R14cell7 != null) {
		            R14cell7.setCellValue(BRF103.getR19_AMOUNT_FCY_2YEAR() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_FCY_2YEAR().intValue());
		       	 }
				 
				  
				 Cell R14cell8 = R14row.getCell(12);
		       	 if (R14cell8 != null) {
		            R14cell8.setCellValue(BRF103.getR19_ACCOUNTS_AED_3YEAR() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_AED_3YEAR().intValue());
		       	 }
				 
				 
				  
				 Cell R14cell9 = R14row.getCell(13);
		       	 if (R14cell9 != null) {
		            R14cell9.setCellValue(BRF103.getR19_AMOUNT_AED_3YEAR() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_AED_3YEAR().intValue());
		       	 }
				 
				 
				 Cell R14cell10 = R14row.getCell(14);
		       	 if (R14cell10 != null) {
		            R14cell10.setCellValue(BRF103.getR19_ACCOUNTS_FCY_3YEAR() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_FCY_3YEAR().intValue());
		       	 }
				 
				 Cell R14cell11 = R14row.getCell(15);
		       	 if (R14cell11 != null) {
		            R14cell11.setCellValue(BRF103.getR19_AMOUNT_FCY_3YEAR() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_FCY_3YEAR().intValue());
		       	 }
				 
				
				
				
				Cell R14cell12 = R14row.getCell(16);
		       	 if (R14cell12 != null) {
		            R14cell12.setCellValue(BRF103.getR19_ACCOUNTS_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_AED_5YEAR().intValue());
		       	 }
		       	 
		     	 Cell R14cell13 = R14row.getCell(17);
		       	 if (R14cell13 != null) {
		            R14cell13.setCellValue(BRF103.getR19_AMOUNT_AED_5YEAR() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_AED_5YEAR().intValue());
		       	 }
		       	 
		       	 
		       	Cell R14cell14 = R14row.getCell(18);
		       	 if (R14cell14 != null) {
		            R14cell14.setCellValue(BRF103.getR19_ACCOUNTS_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_FCY_5YEAR().intValue());
		       	 }
		       	 
		     	Cell R14cell15 = R14row.getCell(19);
		       	 if (R14cell15 != null) {
		            R14cell15.setCellValue(BRF103.getR19_AMOUNT_FCY_5YEAR() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_FCY_5YEAR().intValue());
		       	 }
		       	 
		       	Cell R14cell16 = R14row.getCell(20);
		       	 if (R14cell16 != null) {
		            R14cell16.setCellValue(BRF103.getR19_ACCOUNTS_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R14cell17 = R14row.getCell(21);
		       	 if (R14cell17 != null) {
		            R14cell17.setCellValue(BRF103.getR19_AMOUNT_AED_ABOVE() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_AED_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R14cell18 = R14row.getCell(22);
		       	 if (R14cell18 != null) {
		            R14cell18.setCellValue(BRF103.getR19_ACCOUNTS_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR19_ACCOUNTS_FCY_ABOVE().intValue());
		       	 }
		       	 
		       	Cell R14cell19 = R14row.getCell(23);
		       	 if (R14cell19 != null) {
		            R14cell19.setCellValue(BRF103.getR19_AMOUNT_FCY_ABOVE() == null ? 0 :
		       	     	BRF103.getR19_AMOUNT_FCY_ABOVE().intValue());
		       	 }
		       	 
		            /////////////////////R20/////////////////           
				   
					Row R15row = sheet.getRow(28);
					
					Cell R15cell12 = R15row.getCell(16);
			       	 if (R15cell12 != null) {
			            R15cell12.setCellValue(BRF103.getR20_ACCOUNTS_AED_5YEAR() == null ? 0 :
			       	     	BRF103.getR20_ACCOUNTS_AED_5YEAR().intValue());
			       	 }
			       	 
			     	 Cell R15cell13 = R15row.getCell(17);
			       	 if (R15cell13 != null) {
			            R15cell13.setCellValue(BRF103.getR20_AMOUNT_AED_5YEAR() == null ? 0 :
			       	     	BRF103.getR20_AMOUNT_AED_5YEAR().intValue());
			       	 }
			       	 
			       	 
			       	Cell R15cell14 = R15row.getCell(18);
			       	 if (R15cell14 != null) {
			            R15cell14.setCellValue(BRF103.getR20_ACCOUNTS_FCY_5YEAR() == null ? 0 :
			       	     	BRF103.getR20_ACCOUNTS_FCY_5YEAR().intValue());
			       	 }
			       	 
			     	Cell R15cell15 = R15row.getCell(19);
			       	 if (R15cell15 != null) {
			            R15cell15.setCellValue(BRF103.getR20_AMOUNT_FCY_5YEAR() == null ? 0 :
			       	     	BRF103.getR20_AMOUNT_FCY_5YEAR().intValue());
			       	 }
			       	 
			       	Cell R15cell16 = R15row.getCell(20);
			       	 if (R15cell16 != null) {
			            R15cell16.setCellValue(BRF103.getR20_ACCOUNTS_AED_ABOVE() == null ? 0 :
			       	     	BRF103.getR20_ACCOUNTS_AED_ABOVE().intValue());
			       	 }
			       	 
			       	Cell R15cell17 = R15row.getCell(21);
			       	 if (R15cell17 != null) {
			            R15cell17.setCellValue(BRF103.getR20_AMOUNT_AED_ABOVE() == null ? 0 :
			       	     	BRF103.getR20_AMOUNT_AED_ABOVE().intValue());
			       	 }
			       	 
			       	Cell R15cell18 = R15row.getCell(22);
			       	 if (R15cell18 != null) {
			            R15cell18.setCellValue(BRF103.getR20_ACCOUNTS_FCY_ABOVE() == null ? 0 :
			       	     	BRF103.getR20_ACCOUNTS_FCY_ABOVE().intValue());
			       	 }
			       	 
			       	Cell R15cell19 = R15row.getCell(23);
			       	 if (R15cell19 != null) {
			            R15cell19.setCellValue(BRF103.getR20_AMOUNT_FCY_ABOVE() == null ? 0 :
			       	     	BRF103.getR20_AMOUNT_FCY_ABOVE().intValue());
			       	 }
		             Cell R15cell24 = R15row.getCell(28);
			       	 if (R15cell24 != null) {
			            R15cell24.setCellValue(BRF103.getR20_ACCOUNTS_AED_DORMANT() == null ? 0 :
			       	     	BRF103.getR20_ACCOUNTS_AED_DORMANT().intValue());
			       	 }
			       	 
			     	 Cell R15cell25 = R15row.getCell(29);
			       	 if (R15cell25 != null) {
			            R15cell25.setCellValue(BRF103.getR20_AMOUNT_AED_DORMANT() == null ? 0 :
			       	     	BRF103.getR20_AMOUNT_AED_DORMANT().intValue());
			       	 }
			       	 
			       	 
			       	Cell R15cell26 = R15row.getCell(30);
			       	 if (R15cell26 != null) {
			            R15cell26.setCellValue(BRF103.getR20_ACCOUNTS_FCY_DORMANT() == null ? 0 :
			       	     	BRF103.getR20_ACCOUNTS_FCY_DORMANT().intValue());
			       	 }
			       	 
			     	Cell R15cell27 = R15row.getCell(31);
			       	 if (R15cell27 != null) {
			            R15cell27.setCellValue(BRF103.getR20_AMOUNT_FCY_DORMANT() == null ? 0 :
			       	     	BRF103.getR20_AMOUNT_FCY_DORMANT().intValue());
			       	 }
			       	 
	/////////////////////R21/////////////////           
					   
						Row R16row = sheet.getRow(29);
						Cell R16cell16 = R16row.getCell(20);
				       	 if (R16cell16 != null) {
				            R16cell16.setCellValue(BRF103.getR21_ACCOUNTS_AED_ABOVE() == null ? 0 :
				       	     	BRF103.getR21_ACCOUNTS_AED_ABOVE().intValue());
				       	 }
				       	 
				       	Cell R16cell17 = R16row.getCell(21);
				       	 if (R16cell17 != null) {
				            R16cell17.setCellValue(BRF103.getR21_AMOUNT_AED_ABOVE() == null ? 0 :
				       	     	BRF103.getR21_AMOUNT_AED_ABOVE().intValue());
				       	 }
				       	 
				       	Cell R16cell18 = R16row.getCell(22);
				       	 if (R16cell18 != null) {
				            R16cell18.setCellValue(BRF103.getR21_ACCOUNTS_FCY_ABOVE() == null ? 0 :
				       	     	BRF103.getR21_ACCOUNTS_FCY_ABOVE().intValue());
				       	 }
				       	 
				       	Cell R16cell19 = R16row.getCell(23);
				       	 if (R16cell19 != null) {
				            R16cell19.setCellValue(BRF103.getR21_AMOUNT_FCY_ABOVE() == null ? 0 :
				       	     	BRF103.getR21_AMOUNT_FCY_ABOVE().intValue());
				       	 }
				       	 
				         /////////////////////R22/////////////////           
						   
							Row R17row = sheet.getRow(30); 	 
				       	 
			             Cell R17cell24 = R17row.getCell(28);
				       	 if (R17cell24 != null) {
				            R17cell24.setCellValue(BRF103.getR22_ACCOUNTS_AED_DORMANT() == null ? 0 :
				       	     	BRF103.getR22_ACCOUNTS_AED_DORMANT().intValue());
				       	 }
				       	 
				     	 Cell R17cell25 = R17row.getCell(29);
				       	 if (R17cell25 != null) {
				            R17cell25.setCellValue(BRF103.getR22_AMOUNT_AED_DORMANT() == null ? 0 :
				       	     	BRF103.getR22_AMOUNT_AED_DORMANT().intValue());
				       	 }
				       	 
				       	 
				       	Cell R17cell26 = R17row.getCell(30);
				       	 if (R17cell26 != null) {
				            R17cell26.setCellValue(BRF103.getR22_ACCOUNTS_FCY_DORMANT() == null ? 0 :
				       	     	BRF103.getR22_ACCOUNTS_FCY_DORMANT().intValue());
				       	 }
				       	 
				     	Cell R17cell27 = R17row.getCell(31);
				       	 if (R17cell27 != null) {
				            R17cell27.setCellValue(BRF103.getR22_AMOUNT_FCY_DORMANT() == null ? 0 :
				       	     	BRF103.getR22_AMOUNT_FCY_DORMANT().intValue());
				       	 }
				       	 
				            /////////////////////R24/////////////////           
						   
							Row R18row = sheet.getRow(32);
							
							Cell R18cell12 = R18row.getCell(16);
					       	 if (R18cell12 != null) {
					            R18cell12.setCellValue(BRF103.getR24_ACCOUNTS_AED_5YEAR() == null ? 0 :
					       	     	BRF103.getR24_ACCOUNTS_AED_5YEAR().intValue());
					       	 }
					       	 
					     	 Cell R18cell13 = R18row.getCell(17);
					       	 if (R18cell13 != null) {
					            R18cell13.setCellValue(BRF103.getR24_AMOUNT_AED_5YEAR() == null ? 0 :
					       	     	BRF103.getR24_AMOUNT_AED_5YEAR().intValue());
					       	 }
					       	 
					       	 
					       	Cell R18cell14 = R18row.getCell(18);
					       	 if (R18cell14 != null) {
					            R18cell14.setCellValue(BRF103.getR24_ACCOUNTS_FCY_5YEAR() == null ? 0 :
					       	     	BRF103.getR24_ACCOUNTS_FCY_5YEAR().intValue());
					       	 }
					       	 
					     	Cell R18cell15 = R18row.getCell(19);
					       	 if (R18cell15 != null) {
					            R18cell15.setCellValue(BRF103.getR24_AMOUNT_FCY_5YEAR() == null ? 0 :
					       	     	BRF103.getR24_AMOUNT_FCY_5YEAR().intValue());
					       	 }
					       	 
					       	Cell R18cell16 = R18row.getCell(20);
					       	 if (R18cell16 != null) {
					            R18cell16.setCellValue(BRF103.getR24_ACCOUNTS_AED_ABOVE() == null ? 0 :
					       	     	BRF103.getR24_ACCOUNTS_AED_ABOVE().intValue());
					       	 }
					       	 
					       	Cell R18cell17 = R18row.getCell(21);
					       	 if (R18cell17 != null) {
					            R18cell17.setCellValue(BRF103.getR24_AMOUNT_AED_ABOVE() == null ? 0 :
					       	     	BRF103.getR24_AMOUNT_AED_ABOVE().intValue());
					       	 }
					       	 
					       	Cell R18cell18 = R18row.getCell(22);
					       	 if (R18cell18 != null) {
					            R18cell18.setCellValue(BRF103.getR24_ACCOUNTS_FCY_ABOVE() == null ? 0 :
					       	     	BRF103.getR24_ACCOUNTS_FCY_ABOVE().intValue());
					       	 }
					       	 
					       	Cell R18cell19 = R18row.getCell(23);
					       	 if (R18cell19 != null) {
					            R18cell19.setCellValue(BRF103.getR24_AMOUNT_FCY_ABOVE() == null ? 0 :
					       	     	BRF103.getR24_AMOUNT_FCY_ABOVE().intValue());
					       	 }
					       	 
					       	 
			/////////////////////R25/////////////////           
							   
								Row R19row = sheet.getRow(33);
					       	 
					         Cell R19cell24 = R19row.getCell(28);
					       	 if (R19cell24 != null) {
					            R19cell24.setCellValue(BRF103.getR25_ACCOUNTS_AED_DORMANT() == null ? 0 :
					       	     	BRF103.getR25_ACCOUNTS_AED_DORMANT().intValue());
					       	 }
					       	 
					     	Cell R19cell26 = R19row.getCell(30);
					       	 if (R19cell26 != null) {
					            R19cell26.setCellValue(BRF103.getR25_ACCOUNTS_FCY_DORMANT() == null ? 0 :
					       	     	BRF103.getR25_ACCOUNTS_FCY_DORMANT().intValue());
					       	 }
					       	 
		       	 
					         /////////////////////R26/////////////////           
							   
								Row R20row = sheet.getRow(34);
								
						       	 
						       	Cell R20cell16 = R20row.getCell(20);
						       	 if (R20cell16 != null) {
						            R20cell16.setCellValue(BRF103.getR26_ACCOUNTS_AED_ABOVE() == null ? 0 :
						       	     	BRF103.getR26_ACCOUNTS_AED_ABOVE().intValue());
						       	 }
						       	 
						       	Cell R20cell17 = R20row.getCell(21);
						       	 if (R20cell17 != null) {
						            R20cell17.setCellValue(BRF103.getR26_AMOUNT_AED_ABOVE() == null ? 0 :
						       	     	BRF103.getR26_AMOUNT_AED_ABOVE().intValue());
						       	 }
						       	 
						       	Cell R20cell18 = R20row.getCell(22);
						       	 if (R20cell18 != null) {
						            R20cell18.setCellValue(BRF103.getR26_ACCOUNTS_FCY_ABOVE() == null ? 0 :
						       	     	BRF103.getR26_ACCOUNTS_FCY_ABOVE().intValue());
						       	 }
						       	 
						       	Cell R20cell19 = R20row.getCell(23);
						       	 if (R20cell19 != null) {
						            R20cell19.setCellValue(BRF103.getR26_AMOUNT_FCY_ABOVE() == null ? 0 :
						       	     	BRF103.getR26_AMOUNT_FCY_ABOVE().intValue());
						       	 }
						       	 
						       	 
						            /////////////////////R27/////////////////           
								   
									Row R21row = sheet.getRow(35);
									
							       	 
							       	Cell R21cell16 = R21row.getCell(20);
							       	 if (R21cell16 != null) {
							            R21cell16.setCellValue(BRF103.getR27_ACCOUNTS_AED_ABOVE() == null ? 0 :
							       	     	BRF103.getR27_ACCOUNTS_AED_ABOVE().intValue());
							       	 }
							       	 
							       	Cell R21cell17 = R21row.getCell(21);
							       	 if (R21cell17 != null) {
							            R21cell17.setCellValue(BRF103.getR27_AMOUNT_AED_ABOVE() == null ? 0 :
							       	     	BRF103.getR27_AMOUNT_AED_ABOVE().intValue());
							       	 }
							       	 
							       	Cell R21cell18 = R21row.getCell(22);
							       	 if (R21cell18 != null) {
							            R21cell18.setCellValue(BRF103.getR27_ACCOUNTS_FCY_ABOVE() == null ? 0 :
							       	     	BRF103.getR27_ACCOUNTS_FCY_ABOVE().intValue());
							       	 }
							       	 
							       	Cell R21cell19 = R21row.getCell(23);
							       	 if (R21cell19 != null) {
							            R21cell19.setCellValue(BRF103.getR27_AMOUNT_FCY_ABOVE() == null ? 0 :
							       	     	BRF103.getR27_AMOUNT_FCY_ABOVE().intValue());
							       	 }
							       	 
							       	Cell R21cell26 = R21row.getCell(30);
							       	 if (R21cell26 != null) {
							            R21cell26.setCellValue(BRF103.getR27_ACCOUNTS_FCY_DORMANT() == null ? 0 :
							       	     	BRF103.getR27_ACCOUNTS_FCY_DORMANT().intValue());
							       	 }
							       	 
							     	Cell R21cell27 = R21row.getCell(31);
							       	 if (R21cell27 != null) {
							            R21cell27.setCellValue(BRF103.getR27_AMOUNT_FCY_DORMANT() == null ? 0 :
							       	     	BRF103.getR27_AMOUNT_FCY_DORMANT().intValue());
							       	 }
								
		       	 
	       	 
	         // Save the changes
	            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-103-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-103-A.xls");

		return outputFile;
	
	
	
	}
	       	 
	       	 
	
	
	public ModelAndView getBRF103currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF103_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF103_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF103_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF103_DETAIL_ENTITY> T1Master = new ArrayList<BRF103_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF103_DETAIL_ENTITY a where a.report_date = ?1", BRF103_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String acct_crncy_code = (String) a[0];
			String acct_name = (String) a[1];
			String  acid = (String) a[2];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[3];
			String bacid = (String) a[4];
			String constitution_code  = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date)  a[9];
			String create_user = (String) a[10];
			String cust_id  = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			String entity_flg = (String) a[14];
			String foracid = (String) a[15];
			String gender =(String) a[16];
			String gl_code =(String) a[17];
			String gl_sub_head_code=(String)a[18];
			String gl_sub_head_desc=(String)a[19];
			String group_id=(String)a[20];
			BigDecimal hni_networth = (BigDecimal) a[21];
			String legal_entity_type=(String)a[22];
			String maturity_date=(String)a[23];
			String modify_flg=(String)a[24];
			Date modify_time = (Date)  a[25];
			String modify_user=(String)a[26];
			String nre_flg=(String)a[27];
			String nre_status=(String)a[28];
			String purpose_of_advn=(String)a[29];
			BigDecimal eab_lc = (BigDecimal) a[30];
			String remarks=(String)a[31];
			String report_addl_criteria_1=(String)a[32];
			String report_addl_criteria_2=(String)a[33];
			String report_addl_criteria_3=(String)a[34];
			Date report_date = (Date)  a[35];
			String report_label_1=(String)a[36];
			String report_name_1=(String)a[37];
			String schm_code=(String)a[38];
			String schm_type=(String)a[39];
			String sector = (String) a[40];
			String sector_code=(String)a[41];
			String segment=(String)a[42];
			String sol_id=(String)a[43];
			String sub_sector=(String)a[44];
			String sub_segment=(String)a[45];
			String turnover=(String)a[46];
			Date verify_time = (Date)  a[47];
			String verify_user=(String)a[48];
			String version=(String)a[49];
			String Remarks1;
			if ( act_balance_amt_lc != null) {
				if ( act_balance_amt_lc.toString().contains("-")) {
					Remarks1 = "DR";
				} else {
					Remarks1 = "CR";
				}
			} else {
				Remarks1 = "";
			}

			BRF103_DETAIL_ENTITY py = new BRF103_DETAIL_ENTITY(
				    acct_crncy_code, acct_name, acid, act_balance_amt_lc,
				    bacid, constitution_code, constitution_desc, country, country_of_incorp,
				    create_time, create_user, cust_id, cust_type, del_flg, entity_flg,
				    foracid, gender, gl_code, gl_sub_head_code, gl_sub_head_desc,
				    group_id, hni_networth, legal_entity_type, maturity_date, modify_flg,
				    modify_time, modify_user, nre_flg, nre_status, purpose_of_advn,
				    eab_lc, remarks, report_addl_criteria_1, report_addl_criteria_2,
				    report_addl_criteria_3, report_date, report_label_1, report_name_1,
				    schm_code, schm_type, sector, sector_code, segment, sol_id,
				    sub_sector, sub_segment, turnover, verify_time, verify_user, version
				);

			
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

		mv.setViewName("RR" + "/" + "BRF103A::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
	public String detailChanges103(BRF103_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
	        BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	    String msg = "";

	    try {
	        // Get the current Hibernate session
	        Session hs = sessionFactory.getCurrentSession();

	        // Find the BRF103_DETAIL_ENTITY object by its foracid
	        Optional<BRF103_DETAIL_ENTITY> brf103DetailOptional = brf103_DetailRep.findById(foracid);

	        if (brf103DetailOptional.isPresent()) {
	            BRF103_DETAIL_ENTITY brfDetail = brf103DetailOptional.get();
	            if (brfDetail != null && report_label_1 != null && report_name_1 != null && report_addl_criteria_1 != null) {
	            	if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc()) &&
	                        report_label_1.equals(brfDetail.getReport_label_1()) &&
	                        report_name_1.equals(brfDetail.getReport_name_1()) &&
	                        report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
	                    msg = "No modification done";
	                } else {
	                    // Update the BRF103_DETAIL_ENTITY object with the provided parameters
	                    brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
	                    brfDetail.setReport_label_1(report_label_1);
	                    brfDetail.setReport_name_1(report_name_1);
	                    brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

	                    // Save the updated object
	                    brf103_DetailRep.save(brfDetail);

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
	
	
	
	
	public ModelAndView getArchieveBRF103View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF103_ENTITY> T1rep = new ArrayList<BRF103_ENTITY>();
	// Query<Object[]> qr;

	List<BRF103_ENTITY> T1Master = new ArrayList<BRF103_ENTITY>();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF103_ENTITY a where a.report_date = ?1 ", BRF103_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();

		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);


	mv.setViewName("RR/BRF103ARCH");
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



	public ModelAndView ARCHgetBRF103currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF103_ARCHIVETABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF103_ARCHIVETABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF103_ARCHIVETABLE  where report_date = ?1");
	}

	List<BRF103_ARCHIV_ENTITY> T1Master = new ArrayList<BRF103_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF103_ARCHIV_ENTITY a where a.report_date = ?1", BRF103_ARCHIV_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();
	} catch (ParseException e) {

		e.printStackTrace();
	}

	logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
	List<Object[]> result = qr.getResultList();

	for (Object[] a : result) {
		
		BigDecimal act_balance_amt_lc = (BigDecimal) a[0];
		String acct_crncy_code = (String) a[1];
		String acct_name = (String) a[2];
		String acid = (String) a[3];
		String bacid = (String) a[4];
		String constitution_code  = (String) a[5];
		String constitution_desc = (String) a[6];
		String country = (String) a[7];
		String country_of_incorp = (String) a[8];
		Date create_time = (Date)  a[9];
		String create_user = (String) a[10];
		String cust_id  = (String) a[11];
		String cust_type = (String) a[12];
		String del_flg = (String) a[13];
		BigDecimal eab_lc = (BigDecimal) a[14];
		String entity_flg = (String) a[15];
		String foracid = (String) a[16];
		String gender =(String) a[17];
		String gl_code =(String) a[18];
		String gl_sub_head_code=(String)a[19];
		String gl_sub_head_desc=(String)a[20];
		String group_id=(String)a[21];
		BigDecimal hni_networth = (BigDecimal) a[22];
		String legal_entity_type=(String)a[23];
		Date maturity_date=(Date)a[24];
		String modify_flg=(String)a[25];
		Date modify_time = (Date)  a[26];
		String modify_user=(String)a[27];
		String nre_flg=(String)a[28];
		String nre_status=(String)a[29];
		String purpose_of_advn=(String)a[30];
		String remarks=(String)a[31];
		String report_addl_criteria_1=(String)a[32];
		String report_addl_criteria_2=(String)a[33];
		String report_addl_criteria_3=(String)a[34];
		Date report_date = (Date)  a[35];
		String report_label_1=(String)a[36];
		String report_name_1=(String)a[37];
		String schm_code=(String)a[38];
		String schm_type=(String)a[39];
		BigDecimal sector = (BigDecimal) a[40];
		String sector_code=(String)a[41];
		String segment=(String)a[42];
		String sol_id=(String)a[43];
		String sub_sector=(String)a[44];
		String sub_segment=(String)a[45];
		String turnover=(String)a[46];
		Date verify_time = (Date)  a[47];
		String verify_user=(String)a[48];
		String version=(String)a[49];
		//String Remarks1;
		if (act_balance_amt_lc != null) {
			if (act_balance_amt_lc.toString().contains("-")) {
				remarks = "DR";
			} else {
				remarks = "CR";
			}
		} else {
			remarks = "";
		}

		
		
		BRF103_ARCHIV_ENTITY py = new BRF103_ARCHIV_ENTITY(acct_crncy_code,  acct_name,  acid,  act_balance_amt_lc,
				 bacid,  constitution_code,  constitution_desc,  country,  country_of_incorp,
					create_time,  create_user,  cust_id,  cust_type,  del_flg,  eab_lc,
					 entity_flg,  foracid,  gender,  gl_code,  gl_sub_head_code,
					 gl_sub_head_desc,  group_id,  hni_networth,  legal_entity_type,
					 maturity_date,  modify_flg,  modify_time,  modify_user,  nre_flg,
					 nre_status,  purpose_of_advn,  remarks,  report_addl_criteria_1,
					 report_addl_criteria_2,  report_addl_criteria_3,  report_date,  report_label_1,
					 report_name_1,  schm_code,  schm_type,  sector,  sector_code,
					 segment,  sol_id,  sub_sector,  sub_segment,  turnover,  verify_time,
					 verify_user,  version );
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
	mv.setViewName("RR" + "/" + "BRF103ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
	}

	 public String verifybrf103Report(Date asondate, String userId) {
			String msg = "";
			 Optional<BRF103_ENTITY> up = brf103aServiceRepo.getBRF103AReport(asondate);
			    
			    if (up.isPresent()) {
			    	BRF103_ENTITY brf103 = up.get();
			        brf103.setModify_flg("N");
			        brf103.setVerify_time(new Date());
			        brf103.setVerify_user(userId);
			        brf103.setVerify_user(userId);
			        brf103.setVerify_time(asondate);
			        brf103aServiceRepo.save(brf103);
				msg = "Verified Successfully";
			} else {
				msg = "Data Not Found";
			}
			return msg;
		}
	
	 public String modifyRecord103(Date asondate, BRF103_ENTITY BRF103_ENTITY, String userId) {
		    String msg = "";
		    Optional<BRF103_ENTITY> up = brf103aServiceRepo.getBRF103AReport(asondate);
		    
		    if (up.isPresent()) {
		    	BRF103_ENTITY brf103 = up.get();
		    	if (BRF103_ENTITY.getR5_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR5_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR5_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR10_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR10_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR15_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR15_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR15_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR20_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR20_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR21_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR21_ACCOUNTS_AED_ABOVE());
		    	}
		    	///
		    	if (BRF103_ENTITY.getR5_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR5_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR5_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR10_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR10_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR15_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR15_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR15_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR20_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR20_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR21_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR21_AMOUNT_AED_ABOVE());
		    	}
		    	///
		    	if (BRF103_ENTITY.getR5_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR5_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR5_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR10_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR10_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR15_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR15_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR15_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR20_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR20_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR21_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR21_ACCOUNTS_FCY_ABOVE());
		    	}
		    	///
		    	if (BRF103_ENTITY.getR5_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR5_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR5_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR10_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR10_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR15_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR15_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR15_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR20_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR20_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR21_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR21_AMOUNT_FCY_ABOVE());
		    	}
		    	///21
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR20_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR20_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR20_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR20_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR20_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR20_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR20_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR20_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_AED_DORMANT() != null) {
		    	    brf103.setR20_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR20_ACCOUNTS_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_AED_DORMANT() != null) {
		    	    brf103.setR20_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR20_AMOUNT_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_FCY_DORMANT() != null) {
		    	    brf103.setR20_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR20_ACCOUNTS_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_FCY_DORMANT() != null) {
		    	    brf103.setR20_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR20_AMOUNT_FCY_DORMANT());
		    	}
		    	///NEW
		    	if (BRF103_ENTITY.getR2_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR2_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR2_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR2_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR2_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR2_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR2_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR2_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR2_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR2_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR2_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR2_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR2_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR2_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR2_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR2_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR2_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR2_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR2_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR2_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR2_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR2_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR2_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR2_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR3_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR3_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR3_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR3_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR3_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR3_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR3_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR3_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR3_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR3_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR3_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR3_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR3_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR3_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR3_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR3_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR3_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR3_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR3_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR3_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR3_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR3_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR3_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR3_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR4_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR4_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR4_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR4_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR4_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR4_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR4_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR4_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR4_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR4_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR4_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR4_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR4_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR4_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR4_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR4_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR4_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR4_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR4_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR4_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR4_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR4_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR4_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR4_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR5_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR5_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR5_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR5_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR5_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR5_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR5_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR5_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR5_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR5_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR5_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR5_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR7_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR7_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR7_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR7_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR7_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR7_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR7_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR7_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR7_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR7_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR7_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR7_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR7_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR7_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR7_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR7_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR7_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR7_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR7_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR7_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR7_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR7_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR7_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR7_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR8_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR8_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR8_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR8_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR8_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR8_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR8_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR8_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR8_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR8_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR8_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR8_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR8_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR8_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR8_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR8_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR8_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR8_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR8_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR8_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR8_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR8_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR8_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR8_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR9_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR9_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR9_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR9_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR9_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR9_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR9_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR9_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR9_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR9_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR9_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR9_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR9_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR9_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR9_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR9_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR9_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR9_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR9_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR9_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR9_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR9_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR9_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR9_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR10_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR10_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR10_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR10_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR10_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR10_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR10_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR10_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR10_AMOUNT_FCY_ABOVE());
		    	}if (BRF103_ENTITY.getR12_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR12_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR12_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR12_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR12_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR12_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR12_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR12_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR12_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR12_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR12_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR12_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR12_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR12_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR12_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR12_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR12_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR12_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR12_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR12_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR12_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR12_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR12_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR12_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR13_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR13_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR13_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR13_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR13_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR13_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR13_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR13_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR13_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR13_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR13_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR13_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR13_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR13_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR13_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR13_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR13_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR13_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR13_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR13_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR13_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR13_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR13_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR13_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR14_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR14_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR14_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR14_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR14_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR14_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR14_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR14_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR14_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR14_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR14_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR14_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR14_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR14_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR14_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR14_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR14_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR14_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR14_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR14_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR14_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR14_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR14_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR14_AMOUNT_FCY_ABOVE());
		    	}
				/*
				 * if (BRF103_ENTITY.getR15_ACCOUNTS_AED_ABOVE() != null) {
				 * brf103.setR15_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR15_ACCOUNTS_AED_ABOVE());
				 * } if (BRF103_ENTITY.getR15_AMOUNT_AED_ABOVE() != null) {
				 * brf103.setR15_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR15_AMOUNT_AED_ABOVE()); } if
				 * (BRF103_ENTITY.getR15_ACCOUNTS_FCY_ABOVE() != null) {
				 * brf103.setR15_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR15_ACCOUNTS_FCY_ABOVE());
				 * } if (BRF103_ENTITY.getR15_AMOUNT_FCY_ABOVE() != null) {
				 * brf103.setR15_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR15_AMOUNT_FCY_ABOVE()); }
				 */
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_AED_2YEAR() != null) {
		    	    brf103.setR17_ACCOUNTS_AED_2YEAR(BRF103_ENTITY.getR17_ACCOUNTS_AED_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_AED_2YEAR() != null) {
		    	    brf103.setR17_AMOUNT_AED_2YEAR(BRF103_ENTITY.getR17_AMOUNT_AED_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_FCY_2YEAR() != null) {
		    	    brf103.setR17_ACCOUNTS_FCY_2YEAR(BRF103_ENTITY.getR17_ACCOUNTS_FCY_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_FCY_2YEAR() != null) {
		    	    brf103.setR17_AMOUNT_FCY_2YEAR(BRF103_ENTITY.getR17_AMOUNT_FCY_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_AED_3YEAR() != null) {
		    	    brf103.setR17_ACCOUNTS_AED_3YEAR(BRF103_ENTITY.getR17_ACCOUNTS_AED_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_AED_3YEAR() != null) {
		    	    brf103.setR17_AMOUNT_AED_3YEAR(BRF103_ENTITY.getR17_AMOUNT_AED_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_FCY_3YEAR() != null) {
		    	    brf103.setR17_ACCOUNTS_FCY_3YEAR(BRF103_ENTITY.getR17_ACCOUNTS_FCY_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_FCY_3YEAR() != null) {
		    	    brf103.setR17_AMOUNT_FCY_3YEAR(BRF103_ENTITY.getR17_AMOUNT_FCY_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR17_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR17_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR17_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR17_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR17_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR17_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR17_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR17_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR17_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR17_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR17_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR17_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR17_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR17_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR17_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR17_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR17_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR17_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_AED_2YEAR() != null) {
		    	    brf103.setR18_ACCOUNTS_AED_2YEAR(BRF103_ENTITY.getR18_ACCOUNTS_AED_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_AED_2YEAR() != null) {
		    	    brf103.setR18_AMOUNT_AED_2YEAR(BRF103_ENTITY.getR18_AMOUNT_AED_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_FCY_2YEAR() != null) {
		    	    brf103.setR18_ACCOUNTS_FCY_2YEAR(BRF103_ENTITY.getR18_ACCOUNTS_FCY_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_FCY_2YEAR() != null) {
		    	    brf103.setR18_AMOUNT_FCY_2YEAR(BRF103_ENTITY.getR18_AMOUNT_FCY_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_AED_3YEAR() != null) {
		    	    brf103.setR18_ACCOUNTS_AED_3YEAR(BRF103_ENTITY.getR18_ACCOUNTS_AED_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_AED_3YEAR() != null) {
		    	    brf103.setR18_AMOUNT_AED_3YEAR(BRF103_ENTITY.getR18_AMOUNT_AED_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_FCY_3YEAR() != null) {
		    	    brf103.setR18_ACCOUNTS_FCY_3YEAR(BRF103_ENTITY.getR18_ACCOUNTS_FCY_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_FCY_3YEAR() != null) {
		    	    brf103.setR18_AMOUNT_FCY_3YEAR(BRF103_ENTITY.getR18_AMOUNT_FCY_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR18_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR18_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR18_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR18_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR18_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR18_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR18_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR18_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR18_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR18_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR18_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR18_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR18_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR18_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR18_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR18_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR18_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR18_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_AED_2YEAR() != null) {
		    	    brf103.setR19_ACCOUNTS_AED_2YEAR(BRF103_ENTITY.getR19_ACCOUNTS_AED_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_AED_2YEAR() != null) {
		    	    brf103.setR19_AMOUNT_AED_2YEAR(BRF103_ENTITY.getR19_AMOUNT_AED_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_FCY_2YEAR() != null) {
		    	    brf103.setR19_ACCOUNTS_FCY_2YEAR(BRF103_ENTITY.getR19_ACCOUNTS_FCY_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_FCY_2YEAR() != null) {
		    	    brf103.setR19_AMOUNT_FCY_2YEAR(BRF103_ENTITY.getR19_AMOUNT_FCY_2YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_AED_3YEAR() != null) {
		    	    brf103.setR19_ACCOUNTS_AED_3YEAR(BRF103_ENTITY.getR19_ACCOUNTS_AED_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_AED_3YEAR() != null) {
		    	    brf103.setR19_AMOUNT_AED_3YEAR(BRF103_ENTITY.getR19_AMOUNT_AED_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_FCY_3YEAR() != null) {
		    	    brf103.setR19_ACCOUNTS_FCY_3YEAR(BRF103_ENTITY.getR19_ACCOUNTS_FCY_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_FCY_3YEAR() != null) {
		    	    brf103.setR19_AMOUNT_FCY_3YEAR(BRF103_ENTITY.getR19_AMOUNT_FCY_3YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR19_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR19_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR19_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR19_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR19_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR19_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR19_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR19_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR19_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR19_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR19_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR19_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR19_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR19_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR19_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR19_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR19_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR19_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR20_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR20_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR20_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR20_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR20_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR20_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR20_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR20_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR20_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR20_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR20_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR20_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR20_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR20_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR20_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR20_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR21_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR21_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR21_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR21_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR21_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR21_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR21_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR21_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR21_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR24_ACCOUNTS_AED_5YEAR() != null) {
		    	    brf103.setR24_ACCOUNTS_AED_5YEAR(BRF103_ENTITY.getR24_ACCOUNTS_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR24_AMOUNT_AED_5YEAR() != null) {
		    	    brf103.setR24_AMOUNT_AED_5YEAR(BRF103_ENTITY.getR24_AMOUNT_AED_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR24_ACCOUNTS_FCY_5YEAR() != null) {
		    	    brf103.setR24_ACCOUNTS_FCY_5YEAR(BRF103_ENTITY.getR24_ACCOUNTS_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR24_AMOUNT_FCY_5YEAR() != null) {
		    	    brf103.setR24_AMOUNT_FCY_5YEAR(BRF103_ENTITY.getR24_AMOUNT_FCY_5YEAR());
		    	}
		    	if (BRF103_ENTITY.getR24_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR24_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR24_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR24_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR24_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR24_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR24_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR24_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR24_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR24_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR24_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR24_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR26_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR26_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR26_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR26_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR26_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR26_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR26_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR26_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR26_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR26_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR26_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR26_AMOUNT_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR27_ACCOUNTS_AED_ABOVE() != null) {
		    	    brf103.setR27_ACCOUNTS_AED_ABOVE(BRF103_ENTITY.getR27_ACCOUNTS_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR27_AMOUNT_AED_ABOVE() != null) {
		    	    brf103.setR27_AMOUNT_AED_ABOVE(BRF103_ENTITY.getR27_AMOUNT_AED_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR27_ACCOUNTS_FCY_ABOVE() != null) {
		    	    brf103.setR27_ACCOUNTS_FCY_ABOVE(BRF103_ENTITY.getR27_ACCOUNTS_FCY_ABOVE());
		    	}
		    	if (BRF103_ENTITY.getR27_AMOUNT_FCY_ABOVE() != null) {
		    	    brf103.setR27_AMOUNT_FCY_ABOVE(BRF103_ENTITY.getR27_AMOUNT_FCY_ABOVE());
		    	}
		    	//////DORMANT COLUMN EDIT
		    	if (BRF103_ENTITY.getR13_ACCOUNTS_AED_DORMANT() != null) {
		    	    brf103.setR13_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR13_ACCOUNTS_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR13_AMOUNT_AED_DORMANT() != null) {
		    	    brf103.setR13_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR13_AMOUNT_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR13_ACCOUNTS_FCY_DORMANT() != null) {
		    	    brf103.setR13_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR13_ACCOUNTS_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR13_AMOUNT_FCY_DORMANT() != null) {
		    	    brf103.setR13_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR13_AMOUNT_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_AED_DORMANT() != null) {
		    	    brf103.setR20_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR20_ACCOUNTS_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_AED_DORMANT() != null) {
		    	    brf103.setR20_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR20_AMOUNT_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_ACCOUNTS_FCY_DORMANT() != null) {
		    	    brf103.setR20_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR20_ACCOUNTS_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR20_AMOUNT_FCY_DORMANT() != null) {
		    	    brf103.setR20_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR20_AMOUNT_FCY_DORMANT());
		    	} if (BRF103_ENTITY.getR22_ACCOUNTS_AED_DORMANT() != null) {
		    	    brf103.setR22_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR22_ACCOUNTS_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR22_AMOUNT_AED_DORMANT() != null) {
		    	    brf103.setR22_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR22_AMOUNT_AED_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR22_ACCOUNTS_FCY_DORMANT() != null) {
		    	    brf103.setR22_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR22_ACCOUNTS_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR22_AMOUNT_FCY_DORMANT() != null) {
		    	    brf103.setR22_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR22_AMOUNT_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR25_ACCOUNTS_AED_DORMANT() != null) {
		    	    brf103.setR25_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR25_ACCOUNTS_AED_DORMANT());
		    	}
		    	 
		    	if (BRF103_ENTITY.getR25_ACCOUNTS_FCY_DORMANT() != null) {
		    	    brf103.setR25_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR25_ACCOUNTS_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR27_ACCOUNTS_FCY_DORMANT() != null) {
		    	    brf103.setR27_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR27_ACCOUNTS_FCY_DORMANT());
		    	}
		    	if (BRF103_ENTITY.getR27_AMOUNT_FCY_DORMANT()!= null) {
		    	    brf103.setR27_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR27_AMOUNT_FCY_DORMANT());
		    	}
		    	 brf103.setR5_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR5_ACCOUNTS_AED_DORMANT());
		    	 brf103.setR10_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR10_ACCOUNTS_AED_DORMANT());
		    	 brf103.setR15_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR15_ACCOUNTS_AED_DORMANT());		    	
		    	 brf103.setR21_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR21_ACCOUNTS_AED_DORMANT());
		    	 
		    	 brf103.setR5_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR5_AMOUNT_AED_DORMANT());
		    	 brf103.setR10_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR10_AMOUNT_AED_DORMANT());
		    	 brf103.setR15_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR15_AMOUNT_AED_DORMANT());
		    	 brf103.setR21_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR21_AMOUNT_AED_DORMANT());
		    	 
		    	 brf103.setR5_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR5_ACCOUNTS_FCY_DORMANT());
		    	 brf103.setR10_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR10_ACCOUNTS_FCY_DORMANT());
		    	 brf103.setR15_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR15_ACCOUNTS_FCY_DORMANT());
		    	 brf103.setR21_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR21_ACCOUNTS_FCY_DORMANT());
		    	 
		    	 brf103.setR5_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR5_AMOUNT_FCY_DORMANT());
		    	 brf103.setR10_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR10_AMOUNT_FCY_DORMANT());
		    	 brf103.setR15_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR15_AMOUNT_FCY_DORMANT());
                 brf103.setR21_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR21_AMOUNT_FCY_DORMANT());
                 
					
                 brf103.setR2_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR2_ACCOUNTS_AED_DORMANT());
				 brf103.setR2_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR2_AMOUNT_AED_DORMANT());
			     brf103.setR2_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR2_ACCOUNTS_FCY_DORMANT());
				 brf103.setR2_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR2_AMOUNT_FCY_DORMANT());
					 

				 brf103.setR3_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR3_ACCOUNTS_AED_DORMANT());
				 brf103.setR3_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR3_AMOUNT_AED_DORMANT());
			     brf103.setR3_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR3_ACCOUNTS_FCY_DORMANT());
				 brf103.setR3_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR3_AMOUNT_FCY_DORMANT());
					 
				 brf103.setR4_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR4_ACCOUNTS_AED_DORMANT());
				 brf103.setR4_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR4_AMOUNT_AED_DORMANT());
			     brf103.setR4_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR4_ACCOUNTS_FCY_DORMANT());
				 brf103.setR4_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR4_AMOUNT_FCY_DORMANT());

				 brf103.setR5_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR5_ACCOUNTS_AED_DORMANT());
				 brf103.setR5_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR5_AMOUNT_AED_DORMANT());
			     brf103.setR5_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR5_ACCOUNTS_FCY_DORMANT());
				 brf103.setR5_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR5_AMOUNT_FCY_DORMANT());

				 brf103.setR7_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR7_ACCOUNTS_AED_DORMANT());
				 brf103.setR7_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR7_AMOUNT_AED_DORMANT());
			     brf103.setR7_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR7_ACCOUNTS_FCY_DORMANT());
				 brf103.setR7_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR7_AMOUNT_FCY_DORMANT());

				 brf103.setR8_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR8_ACCOUNTS_AED_DORMANT());
				 brf103.setR8_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR8_AMOUNT_AED_DORMANT());
			     brf103.setR8_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR8_ACCOUNTS_FCY_DORMANT());
				 brf103.setR8_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR8_AMOUNT_FCY_DORMANT()); 

				 brf103.setR9_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR9_ACCOUNTS_AED_DORMANT());
				 brf103.setR9_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR9_AMOUNT_AED_DORMANT());
			     brf103.setR9_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR9_ACCOUNTS_FCY_DORMANT());
				 brf103.setR9_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR9_AMOUNT_FCY_DORMANT()); 
				 
				 brf103.setR12_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR12_ACCOUNTS_AED_DORMANT());
				 brf103.setR12_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR12_AMOUNT_AED_DORMANT());
			     brf103.setR12_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR12_ACCOUNTS_FCY_DORMANT());
				 brf103.setR12_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR12_AMOUNT_FCY_DORMANT()); 
		    	
				 brf103.setR14_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR14_ACCOUNTS_AED_DORMANT());
				 brf103.setR14_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR14_AMOUNT_AED_DORMANT());
			     brf103.setR14_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR14_ACCOUNTS_FCY_DORMANT());
				 brf103.setR14_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR14_AMOUNT_FCY_DORMANT()); 
				 
				 brf103.setR26_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR26_ACCOUNTS_AED_ABOVE());
					brf103.setR26_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR26_AMOUNT_AED_DORMANT());
					brf103.setR26_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR26_ACCOUNTS_FCY_DORMANT());
					brf103.setR26_AMOUNT_FCY_DORMANT (BRF103_ENTITY.getR26_AMOUNT_FCY_DORMANT());
					 
					brf103.setR24_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR24_ACCOUNTS_AED_ABOVE());
					brf103.setR24_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR24_AMOUNT_AED_DORMANT());
					brf103.setR24_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR24_ACCOUNTS_FCY_DORMANT());
					brf103.setR24_AMOUNT_FCY_DORMANT (BRF103_ENTITY.getR24_AMOUNT_FCY_DORMANT());
					
					brf103.setR21_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR21_ACCOUNTS_AED_ABOVE());
					brf103.setR21_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR21_AMOUNT_AED_DORMANT());
					brf103.setR21_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR21_ACCOUNTS_FCY_DORMANT());
					brf103.setR21_AMOUNT_FCY_DORMANT (BRF103_ENTITY.getR21_AMOUNT_FCY_DORMANT());
					
					
					brf103.setR17_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR17_ACCOUNTS_AED_DORMANT());
					brf103.setR17_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR17_AMOUNT_AED_DORMANT());
					brf103.setR17_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR17_ACCOUNTS_FCY_DORMANT());
					brf103.setR17_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR17_AMOUNT_FCY_DORMANT());
					
					brf103.setR18_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR18_ACCOUNTS_AED_DORMANT());
					brf103.setR18_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR18_AMOUNT_AED_DORMANT());
					brf103.setR18_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR18_ACCOUNTS_FCY_DORMANT());
					brf103.setR18_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR18_AMOUNT_FCY_DORMANT());
					
					brf103.setR19_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR19_ACCOUNTS_AED_DORMANT());
					brf103.setR19_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR19_ACCOUNTS_FCY_DORMANT());
					brf103.setR19_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR19_AMOUNT_AED_DORMANT());
					brf103.setR19_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR19_AMOUNT_FCY_DORMANT());
					
					brf103.setR1_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR1_ACCOUNTS_AED_DORMANT());
					brf103.setR1_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR1_AMOUNT_AED_DORMANT());
					brf103.setR1_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR1_ACCOUNTS_FCY_DORMANT());
					brf103.setR1_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR1_AMOUNT_FCY_DORMANT());
					
					brf103.setR6_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR6_ACCOUNTS_AED_DORMANT());
					brf103.setR6_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR6_AMOUNT_AED_DORMANT());
					brf103.setR6_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR6_ACCOUNTS_FCY_DORMANT());
					brf103.setR6_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR6_AMOUNT_FCY_DORMANT());
					
					brf103.setR11_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR11_ACCOUNTS_AED_DORMANT());
					brf103.setR11_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR11_AMOUNT_AED_DORMANT());
					brf103.setR11_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR11_ACCOUNTS_FCY_DORMANT());
					brf103.setR11_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR11_AMOUNT_FCY_DORMANT());
					
					
					brf103.setR16_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR16_ACCOUNTS_AED_DORMANT());
					brf103.setR16_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR16_AMOUNT_AED_DORMANT());
					brf103.setR16_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR16_ACCOUNTS_FCY_DORMANT());
					brf103.setR16_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR16_AMOUNT_FCY_DORMANT());
					
					brf103.setR23_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR23_ACCOUNTS_AED_DORMANT());
					brf103.setR23_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR23_AMOUNT_AED_DORMANT());
					brf103.setR23_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR23_ACCOUNTS_FCY_DORMANT());
					brf103.setR23_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR23_AMOUNT_FCY_DORMANT());
					
					
					
					
				 
					brf103.setR28_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR28_ACCOUNTS_AED_DORMANT());
					brf103.setR28_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR28_AMOUNT_AED_DORMANT());
					brf103.setR28_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR28_ACCOUNTS_FCY_DORMANT());
					brf103.setR28_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR28_AMOUNT_FCY_DORMANT());
					
					brf103.setR29_ACCOUNTS_AED_DORMANT(BRF103_ENTITY.getR29_ACCOUNTS_AED_DORMANT());
					brf103.setR29_ACCOUNTS_FCY_DORMANT(BRF103_ENTITY.getR29_ACCOUNTS_FCY_DORMANT());
					brf103.setR29_AMOUNT_AED_DORMANT(BRF103_ENTITY.getR29_AMOUNT_AED_DORMANT());
					brf103.setR29_AMOUNT_FCY_DORMANT(BRF103_ENTITY.getR29_AMOUNT_FCY_DORMANT());
				 
					
					
				 

		        brf103.setDel_flg("N");
		        brf103.setEntity_flg("Y");
		        brf103.setModify_flg("Y");
		        brf103.setModify_user(userId);
		        brf103.setReport_date(asondate);
		        brf103.setReport_to_date(asondate);
		        
		        brf103aServiceRepo.save(brf103);
		        
		     

		        
		        msg = "Updated Successfully";
		    } else {
		        logger.info("Data Not Found");
		        msg = "Data Not Found";
		    }
		    
		    return msg;
		}
		

	}

			
		

	
	
	


