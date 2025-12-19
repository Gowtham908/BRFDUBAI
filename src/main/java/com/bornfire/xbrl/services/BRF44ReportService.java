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
import javax.transaction.Transactional;

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
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRF46_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF44_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF44_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF44_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF44_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF46_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF46_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF46_Entity;
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
public class BRF44ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF44ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	BRF44_DetailRep brf44DetailRep;
	
	@Autowired
	Environment env;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    public String preCheck(String reportid, String fromdate, String todate) {
		
		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF44_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF44_ENTITY a").getSingleResult();
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
public ModelAndView getBRF44View(String reportId, String fromdate, String todate, String currency, String dtltype,
		Pageable pageable) {
	

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF44_ENTITY> T1rep = new ArrayList<BRF44_ENTITY>();
	// Query<Object[]> qr;

	List<BRF44_ENTITY> T1Master = new ArrayList<BRF44_ENTITY>();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from BRF44_ENTITY a where a.report_date = ?1 ", BRF44_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();

		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF44");
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

	public File getFileBRF44(String reportId, String fromdate, String todate, String currency, String dtltype,
		String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-44-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF44_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF44_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF044.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF044.jrxml");
					}
				}

				// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

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
			}outputFile = new File(path);
			return outputFile;
			}else {
				
				List<BRF44_ENTITY> T1Master = new ArrayList<BRF44_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF44_ENTITY a where a.report_date = ?1 ", BRF44_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF44_ENTITY BRF44 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-044-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(10);
	       	 Cell cell = row.getCell(4);
	       	 if (cell != null) {
	            cell.setCellValue(BRF44.getR11_gre_no() == null ? 0 :
	       	     	BRF44.getR11_gre_no().intValue());
	       	 }

	       	Cell cell1 = row.getCell(5);
	       	 if (cell1 != null) {
	            cell1.setCellValue(BRF44.getR11_gre_amount() == null ? 0 :
	       	     	BRF44.getR11_gre_amount().intValue());
	       	 }
	       	 
	     	Cell cell3 = row.getCell(6);
	       	 if (cell3 != null) {
	            cell3.setCellValue(BRF44.getR11_stand_no() == null ? 0 :
	       	     	BRF44.getR11_stand_no().intValue());
	       	 }
	       	 
	     	Cell cell4 = row.getCell(7);
	       	 if (cell4 != null) {
	            cell4.setCellValue(BRF44.getR11_stand_amount() == null ? 0 :
	       	     	BRF44.getR11_stand_amount().intValue());
	       	 }
	       	 
	       	Cell cell5 = row.getCell(8);
	       	 if (cell5 != null) {
	            cell5.setCellValue(BRF44.getR11_high_no() == null ? 0 :
	       	     	BRF44.getR11_high_no().intValue());
	       	 }
	       	 
	     	Cell cell6 = row.getCell(9);
	       	 if (cell6 != null) {
	            cell6.setCellValue(BRF44.getR11_high_amount() == null ? 0 :
	       	     	BRF44.getR11_high_amount().intValue());
	       	 }
	       	 
	       	Cell cell7 = row.getCell(10);
	       	 if (cell7 != null) {
	            cell7.setCellValue(BRF44.getR11_other_no() == null ? 0 :
	       	     	BRF44.getR11_other_no().intValue());
	       	 }
	       	 
	     	Cell cell8 = row.getCell(11);
	       	 if (cell8 != null) {
	            cell8.setCellValue(BRF44.getR11_other_amount() == null ? 0 :
	       	     	BRF44.getR11_other_amount().intValue());
	       	 }
	       	 
	   	   ////////////////////R12////////////////////////////
	  	   
	       	 
	       	 Row R1row = sheet.getRow(11);
	       		       	 Cell R1cell = R1row.getCell(4);
	       		       	 if (R1cell != null) {
	       		            R1cell.setCellValue(BRF44.getR12_gre_no() == null ? 0 :
	       		       	     	BRF44.getR12_gre_no().intValue());
	       		       	 }

	       		       	Cell R1cell1 = R1row.getCell(5);
	       		       	 if (R1cell1 != null) {
	       		            R1cell1.setCellValue(BRF44.getR12_gre_amount() == null ? 0 :
	       		       	     	BRF44.getR12_gre_amount().intValue());
	       		       	 }


	       		   
	       		     	Cell R1cell3 = R1row.getCell(6);
	       		       	 if (R1cell3 != null) {
	       		            R1cell3.setCellValue(BRF44.getR12_stand_no() == null ? 0 :
	       		       	     	BRF44.getR12_stand_no().intValue());
	       		       	 }
	       		       	 
	       		     	Cell R1cell4 = R1row.getCell(7);
	       		       	 if (R1cell4 != null) {
	       		            R1cell4.setCellValue(BRF44.getR12_stand_amount() == null ? 0 :
	       		       	     	BRF44.getR12_stand_amount().intValue());
	       		       	 }
	       		       	 
	       		       	Cell R1cell5 = R1row.getCell(8);
	       		       	 if (R1cell5 != null) {
	       		            R1cell5.setCellValue(BRF44.getR12_high_no() == null ? 0 :
	       		       	     	BRF44.getR12_high_no().intValue());
	       		       	 }
	       		       	 
	       		     	Cell R1cell6 = R1row.getCell(9);
	       		       	 if (R1cell6 != null) {
	       		            R1cell6.setCellValue(BRF44.getR12_high_amount() == null ? 0 :
	       		       	     	BRF44.getR12_high_amount().intValue());
	       		       	 }
	       		       	 
	       		       	Cell R1cell7 = R1row.getCell(10);
	       		       	 if (R1cell7 != null) {
	       		            R1cell7.setCellValue(BRF44.getR12_other_no() == null ? 0 :
	       		       	     	BRF44.getR12_other_no().intValue());
	       		       	 }
	       		       	 
	       		     	Cell R1cell8 = R1row.getCell(11);
	       		       	 if (R1cell8 != null) {
	       		            R1cell8.setCellValue(BRF44.getR12_other_amount() == null ? 0 :
	       		       	     	BRF44.getR12_other_amount().intValue());
	       		       	 }
	       		       	 
	       		 	   ////////////////////R13////////////////////////////
	       			   
	       		      
	       		      Row R2row = sheet.getRow(12);
	       		     	       	 Cell R2cell = R2row.getCell(4);
	       		     	       	 if (R2cell != null) {
	       		     	            R2cell.setCellValue(BRF44.getR13_gre_no() == null ? 0 :
	       		     	       	     	BRF44.getR13_gre_no().intValue());
	       		     	       	 }

	       		     	       	Cell R2cell1 = R2row.getCell(5);
	       		     	       	 if (R2cell1 != null) {
	       		     	            R2cell1.setCellValue(BRF44.getR13_gre_amount() == null ? 0 :
	       		     	       	     	BRF44.getR13_gre_amount().intValue());
	       		     	       	 }


	       		     	   
	       		     	     	Cell R2cell3 = R2row.getCell(6);
	       		     	       	 if (R2cell3 != null) {
	       		     	            R2cell3.setCellValue(BRF44.getR13_stand_no() == null ? 0 :
	       		     	       	     	BRF44.getR13_stand_no().intValue());
	       		     	       	 }
	       		     	       	 
	       		     	     	Cell R2cell4 = R2row.getCell(7);
	       		     	       	 if (R2cell4 != null) {
	       		     	            R2cell4.setCellValue(BRF44.getR13_stand_amount() == null ? 0 :
	       		     	       	     	BRF44.getR13_stand_amount().intValue());
	       		     	       	 }
	       		     	       	 
	       		     	       	Cell R2cell5 = R2row.getCell(8);
	       		     	       	 if (R2cell5 != null) {
	       		     	            R2cell5.setCellValue(BRF44.getR13_high_no() == null ? 0 :
	       		     	       	     	BRF44.getR13_high_no().intValue());
	       		     	       	 }
	       		     	       	 
	       		     	     	Cell R2cell6 = R2row.getCell(9);
	       		     	       	 if (R2cell6 != null) {
	       		     	            R2cell6.setCellValue(BRF44.getR13_high_amount() == null ? 0 :
	       		     	       	     	BRF44.getR13_high_amount().intValue());
	       		     	       	 }
	       		     	       	 
	       		     	       	Cell R2cell7 = R2row.getCell(10);
	       		     	       	 if (R2cell7 != null) {
	       		     	            R2cell7.setCellValue(BRF44.getR13_other_no() == null ? 0 :
	       		     	       	     	BRF44.getR13_other_no().intValue());
	       		     	       	 }
	       		     	       	 
	       		     	     	Cell R2cell8 = R2row.getCell(11);
	       		     	       	 if (R2cell8 != null) {
	       		     	            R2cell8.setCellValue(BRF44.getR13_other_amount() == null ? 0 :
	       		     	       	     	BRF44.getR13_other_amount().intValue());
	       		     	       	 }
	       		     	    
	       		     	 	   ////////////////////R14////////////////////////////
	       		     		   
	       		     	     
	       		     	     Row R3row = sheet.getRow(13);
	       		     	    	       	 Cell R3cell = R3row.getCell(4);
	       		     	    	       	 if (R3cell != null) {
	       		     	    	            R3cell.setCellValue(BRF44.getR14_gre_no() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_gre_no().intValue());
	       		     	    	       	 }

	       		     	    	       	Cell R3cell1 = R3row.getCell(5);
	       		     	    	       	 if (R3cell1 != null) {
	       		     	    	            R3cell1.setCellValue(BRF44.getR14_gre_amount() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_gre_amount().intValue());
	       		     	    	       	 }


	       		     	    	   
	       		     	    	     	Cell R3cell3 = R3row.getCell(6);
	       		     	    	       	 if (R3cell3 != null) {
	       		     	    	            R3cell3.setCellValue(BRF44.getR14_stand_no() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_stand_no().intValue());
	       		     	    	       	 }
	       		     	    	       	 
	       		     	    	     	Cell R3cell4 = R3row.getCell(7);
	       		     	    	       	 if (R3cell4 != null) {
	       		     	    	            R3cell4.setCellValue(BRF44.getR14_stand_amount() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_stand_amount().intValue());
	       		     	    	       	 }
	       		     	    	       	 
	       		     	    	       	Cell R3cell5 = R3row.getCell(8);
	       		     	    	       	 if (R3cell5 != null) {
	       		     	    	            R3cell5.setCellValue(BRF44.getR14_high_no() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_high_no().intValue());
	       		     	    	       	 }
	       		     	    	       	 
	       		     	    	     	Cell R3cell6 = R3row.getCell(9);
	       		     	    	       	 if (R3cell6 != null) {
	       		     	    	            R3cell6.setCellValue(BRF44.getR14_high_amount() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_high_amount().intValue());
	       		     	    	       	 }
	       		     	    	       	 
	       		     	    	       	Cell R3cell7 = R3row.getCell(10);
	       		     	    	       	 if (R3cell7 != null) {
	       		     	    	            R3cell7.setCellValue(BRF44.getR14_other_no() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_other_no().intValue());
	       		     	    	       	 }
	       		     	    	       	 
	       		     	    	     	Cell R3cell8 = R3row.getCell(11);
	       		     	    	       	 if (R3cell8 != null) {
	       		     	    	            R3cell8.setCellValue(BRF44.getR14_other_amount() == null ? 0 :
	       		     	    	       	     	BRF44.getR14_other_amount().intValue());
	       		     	    	       	 }
	       		     	    	       	 
	       		     	    			 
	       		     	    	 	   ////////////////////R15////////////////////////////
	       		     	    		   
	       		     	    	     
	       		     	    	     Row R4row = sheet.getRow(14);
	       		     	    	    	       	 Cell R4cell = R4row.getCell(4);
	       		     	    	    	       	 if (R4cell != null) {
	       		     	    	    	            R4cell.setCellValue(BRF44.getR15_gre_no() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_gre_no().intValue());
	       		     	    	    	       	 }

	       		     	    	    	       	Cell R4cell1 = R4row.getCell(5);
	       		     	    	    	       	 if (R4cell1 != null) {
	       		     	    	    	            R4cell1.setCellValue(BRF44.getR15_gre_amount() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_gre_amount().intValue());
	       		     	    	    	       	 }


	       		     	    	    	   
	       		     	    	    	     	Cell R4cell3 = R4row.getCell(6);
	       		     	    	    	       	 if (R4cell3 != null) {
	       		     	    	    	            R4cell3.setCellValue(BRF44.getR15_stand_no() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_stand_no().intValue());
	       		     	    	    	       	 }
	       		     	    	    	       	 
	       		     	    	    	     	Cell R4cell4 = R4row.getCell(7);
	       		     	    	    	       	 if (R4cell4 != null) {
	       		     	    	    	            R4cell4.setCellValue(BRF44.getR15_stand_amount() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_stand_amount().intValue());
	       		     	    	    	       	 }
	       		     	    	    	       	 
	       		     	    	    	       	Cell R4cell5 = R4row.getCell(8);
	       		     	    	    	       	 if (R4cell5 != null) {
	       		     	    	    	            R4cell5.setCellValue(BRF44.getR15_high_no() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_high_no().intValue());
	       		     	    	    	       	 }
	       		     	    	    	       	 
	       		     	    	    	     	Cell R4cell6 = R4row.getCell(9);
	       		     	    	    	       	 if (R4cell6 != null) {
	       		     	    	    	            R4cell6.setCellValue(BRF44.getR15_high_amount() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_high_amount().intValue());
	       		     	    	    	       	 }
	       		     	    	    	       	 
	       		     	    	    	       	Cell R4cell7 = R4row.getCell(10);
	       		     	    	    	       	 if (R4cell7 != null) {
	       		     	    	    	            R4cell7.setCellValue(BRF44.getR15_other_no() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_other_no().intValue());
	       		     	    	    	       	 }
	       		     	    	    	       	 
	       		     	    	    	     	Cell R4cell8 = R4row.getCell(11);
	       		     	    	    	       	 if (R4cell8 != null) {
	       		     	    	    	            R4cell8.setCellValue(BRF44.getR15_other_amount() == null ? 0 :
	       		     	    	    	       	     	BRF44.getR15_other_amount().intValue());
	       		     	    	    	       	 }
	       		     	    	    	       	 
	       		     	    	    			 
	       		     	    	    			 
	       		     	    	    	 	   ////////////////////R16////////////////////////////
	       		     	    	    		   
	       		     	    	    	     
	       		     	    	    	     Row R5row = sheet.getRow(15);
	       		     	    	    	    	       	 Cell R5cell = R5row.getCell(4);
	       		     	    	    	    	       	 if (R5cell != null) {
	       		     	    	    	    	            R5cell.setCellValue(BRF44.getR16_gre_no() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_gre_no().intValue());
	       		     	    	    	    	       	 }

	       		     	    	    	    	       	Cell R5cell1 = R5row.getCell(5);
	       		     	    	    	    	       	 if (R5cell1 != null) {
	       		     	    	    	    	            R5cell1.setCellValue(BRF44.getR16_gre_amount() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_gre_amount().intValue());
	       		     	    	    	    	       	 }


	       		     	    	    	    	   
	       		     	    	    	    	     	Cell R5cell3 = R5row.getCell(6);
	       		     	    	    	    	       	 if (R5cell3 != null) {
	       		     	    	    	    	            R5cell3.setCellValue(BRF44.getR16_stand_no() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_stand_no().intValue());
	       		     	    	    	    	       	 }
	       		     	    	    	    	       	 
	       		     	    	    	    	     	Cell R5cell4 = R5row.getCell(7);
	       		     	    	    	    	       	 if (R5cell4 != null) {
	       		     	    	    	    	            R5cell4.setCellValue(BRF44.getR16_stand_amount() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_stand_amount().intValue());
	       		     	    	    	    	       	 }
	       		     	    	    	    	       	 
	       		     	    	    	    	       	Cell R5cell5 = R5row.getCell(8);
	       		     	    	    	    	       	 if (R5cell5 != null) {
	       		     	    	    	    	            R5cell5.setCellValue(BRF44.getR16_high_no() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_high_no().intValue());
	       		     	    	    	    	       	 }
	       		     	    	    	    	       	 
	       		     	    	    	    	     	Cell R5cell6 = R5row.getCell(9);
	       		     	    	    	    	       	 if (R5cell6 != null) {
	       		     	    	    	    	            R5cell6.setCellValue(BRF44.getR16_high_amount() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_high_amount().intValue());
	       		     	    	    	    	       	 }
	       		     	    	    	    	       	 
	       		     	    	    	    	       	Cell R5cell7 = R5row.getCell(10);
	       		     	    	    	    	       	 if (R5cell7 != null) {
	       		     	    	    	    	            R5cell7.setCellValue(BRF44.getR16_other_no() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_other_no().intValue());
	       		     	    	    	    	       	 }
	       		     	    	    	    	       	 
	       		     	    	    	    	     	Cell R5cell8 = R5row.getCell(11);
	       		     	    	    	    	       	 if (R5cell8 != null) {
	       		     	    	    	    	            R5cell8.setCellValue(BRF44.getR16_other_amount() == null ? 0 :
	       		     	    	    	    	       	     	BRF44.getR16_other_amount().intValue());
	       		     	    	    	    	       	 }
	       		     	    	    	    	       	 
	       		     	    	    	    			 
	       		     	    	    	    			 
	       		     	    	    	    	 	   ////////////////////R17////////////////////////////
	       		     	    	    	    		   
	       		     	    	    	    	     
	       		     	    	    	    	     Row R6row = sheet.getRow(16);
	       		     	    	    	    	    	       	 Cell R6cell = R6row.getCell(4);
	       		     	    	    	    	    	       	 if (R6cell != null) {
	       		     	    	    	    	    	            R6cell.setCellValue(BRF44.getR17_gre_no() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_gre_no().intValue());
	       		     	    	    	    	    	       	 }

	       		     	    	    	    	    	       	Cell R6cell1 = R6row.getCell(5);
	       		     	    	    	    	    	       	 if (R6cell1 != null) {
	       		     	    	    	    	    	            R6cell1.setCellValue(BRF44.getR17_gre_amount() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_gre_amount().intValue());
	       		     	    	    	    	    	       	 }


	       		     	    	    	    	    	   
	       		     	    	    	    	    	     	Cell R6cell3 = R6row.getCell(6);
	       		     	    	    	    	    	       	 if (R6cell3 != null) {
	       		     	    	    	    	    	            R6cell3.setCellValue(BRF44.getR17_stand_no() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_stand_no().intValue());
	       		     	    	    	    	    	       	 }
	       		     	    	    	    	    	       	 
	       		     	    	    	    	    	     	Cell R6cell4 = R6row.getCell(7);
	       		     	    	    	    	    	       	 if (R6cell4 != null) {
	       		     	    	    	    	    	            R6cell4.setCellValue(BRF44.getR17_stand_amount() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_stand_amount().intValue());
	       		     	    	    	    	    	       	 }
	       		     	    	    	    	    	       	 
	       		     	    	    	    	    	       	Cell R6cell5 = R6row.getCell(8);
	       		     	    	    	    	    	       	 if (R6cell5 != null) {
	       		     	    	    	    	    	            R6cell5.setCellValue(BRF44.getR17_high_no() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_high_no().intValue());
	       		     	    	    	    	    	       	 }
	       		     	    	    	    	    	       	 
	       		     	    	    	    	    	     	Cell R6cell6 = R6row.getCell(9);
	       		     	    	    	    	    	       	 if (R6cell6 != null) {
	       		     	    	    	    	    	            R6cell6.setCellValue(BRF44.getR17_high_amount() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_high_amount().intValue());
	       		     	    	    	    	    	       	 }
	       		     	    	    	    	    	       	 
	       		     	    	    	    	    	       	Cell R6cell7 = R6row.getCell(10);
	       		     	    	    	    	    	       	 if (R6cell7 != null) {
	       		     	    	    	    	    	            R6cell7.setCellValue(BRF44.getR17_other_no() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_other_no().intValue());
	       		     	    	    	    	    	       	 }
	       		     	    	    	    	    	       	 
	       		     	    	    	    	    	     	Cell R6cell8 = R6row.getCell(11);
	       		     	    	    	    	    	       	 if (R6cell8 != null) {
	       		     	    	    	    	    	            R6cell8.setCellValue(BRF44.getR17_other_amount() == null ? 0 :
	       		     	    	    	    	    	       	     	BRF44.getR17_other_amount().intValue());
	       		     	    	    	    	    	       	 }
	       		     	    	    	    	    	       	 
	       		     	    	    	    	    			 
	       		     	    	    	    	    			 
	       		     	    	    	    	    	 	   ////////////////////R18////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R7row = sheet.getRow(17);
	       		     	    	    	    	    	    	 Cell R7cell = R7row.getCell(4);
	       		     	    	    	    	    	    	 if (R7cell != null) {
	       		     	    	    	    	    	         R7cell.setCellValue(BRF44.getR18_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R7cell1 = R7row.getCell(5);
	       		     	    	    	    	    	    	 if (R7cell1 != null) {
	       		     	    	    	    	    	         R7cell1.setCellValue(BRF44.getR18_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R7cell3 = R7row.getCell(6);
	       		     	    	    	    	    	    	 if (R7cell3 != null) {
	       		     	    	    	    	    	         R7cell3.setCellValue(BRF44.getR18_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R7cell4 = R7row.getCell(7);
	       		     	    	    	    	    	    	 if (R7cell4 != null) {
	       		     	    	    	    	    	         R7cell4.setCellValue(BRF44.getR18_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R7cell5 = R7row.getCell(8);
	       		     	    	    	    	    	    	 if (R7cell5 != null) {
	       		     	    	    	    	    	         R7cell5.setCellValue(BRF44.getR18_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R7cell6 = R7row.getCell(9);
	       		     	    	    	    	    	    	 if (R7cell6 != null) {
	       		     	    	    	    	    	         R7cell6.setCellValue(BRF44.getR18_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R7cell7 = R7row.getCell(10);
	       		     	    	    	    	    	    	 if (R7cell7 != null) {
	       		     	    	    	    	    	         R7cell7.setCellValue(BRF44.getR18_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R7cell8 = R7row.getCell(11);
	       		     	    	    	    	    	    	 if (R7cell8 != null) {
	       		     	    	    	    	    	         R7cell8.setCellValue(BRF44.getR18_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR18_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R19////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R8row = sheet.getRow(18);
	       		     	    	    	    	    	    	 Cell R8cell = R8row.getCell(4);
	       		     	    	    	    	    	    	 if (R8cell != null) {
	       		     	    	    	    	    	         R8cell.setCellValue(BRF44.getR19_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R8cell1 = R8row.getCell(5);
	       		     	    	    	    	    	    	 if (R8cell1 != null) {
	       		     	    	    	    	    	         R8cell1.setCellValue(BRF44.getR19_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R8cell3 = R8row.getCell(6);
	       		     	    	    	    	    	    	 if (R8cell3 != null) {
	       		     	    	    	    	    	         R8cell3.setCellValue(BRF44.getR19_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R8cell4 = R8row.getCell(7);
	       		     	    	    	    	    	    	 if (R8cell4 != null) {
	       		     	    	    	    	    	         R8cell4.setCellValue(BRF44.getR19_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R8cell5 = R8row.getCell(8);
	       		     	    	    	    	    	    	 if (R8cell5 != null) {
	       		     	    	    	    	    	         R8cell5.setCellValue(BRF44.getR19_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R8cell6 = R8row.getCell(9);
	       		     	    	    	    	    	    	 if (R8cell6 != null) {
	       		     	    	    	    	    	         R8cell6.setCellValue(BRF44.getR19_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R8cell7 = R8row.getCell(10);
	       		     	    	    	    	    	    	 if (R8cell7 != null) {
	       		     	    	    	    	    	         R8cell7.setCellValue(BRF44.getR19_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R8cell8 = R8row.getCell(11);
	       		     	    	    	    	    	    	 if (R8cell8 != null) {
	       		     	    	    	    	    	         R8cell8.setCellValue(BRF44.getR19_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR19_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R21////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R9row = sheet.getRow(20);
	       		     	    	    	    	    	    	 Cell R9cell = R9row.getCell(4);
	       		     	    	    	    	    	    	 if (R9cell != null) {
	       		     	    	    	    	    	         R9cell.setCellValue(BRF44.getR21_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R9cell1 = R9row.getCell(5);
	       		     	    	    	    	    	    	 if (R9cell1 != null) {
	       		     	    	    	    	    	         R9cell1.setCellValue(BRF44.getR21_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R9cell3 = R9row.getCell(6);
	       		     	    	    	    	    	    	 if (R9cell3 != null) {
	       		     	    	    	    	    	         R9cell3.setCellValue(BRF44.getR21_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R9cell4 = R9row.getCell(7);
	       		     	    	    	    	    	    	 if (R9cell4 != null) {
	       		     	    	    	    	    	         R9cell4.setCellValue(BRF44.getR21_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R9cell5 = R9row.getCell(8);
	       		     	    	    	    	    	    	 if (R9cell5 != null) {
	       		     	    	    	    	    	         R9cell5.setCellValue(BRF44.getR21_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R9cell6 = R9row.getCell(9);
	       		     	    	    	    	    	    	 if (R9cell6 != null) {
	       		     	    	    	    	    	         R9cell6.setCellValue(BRF44.getR21_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R9cell7 = R9row.getCell(10);
	       		     	    	    	    	    	    	 if (R9cell7 != null) {
	       		     	    	    	    	    	         R9cell7.setCellValue(BRF44.getR21_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R9cell8 = R9row.getCell(11);
	       		     	    	    	    	    	    	 if (R9cell8 != null) {
	       		     	    	    	    	    	         R9cell8.setCellValue(BRF44.getR21_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR21_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R22////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R10row = sheet.getRow(21);
	       		     	    	    	    	    	    	 Cell R10cell = R10row.getCell(4);
	       		     	    	    	    	    	    	 if (R10cell != null) {
	       		     	    	    	    	    	         R10cell.setCellValue(BRF44.getR22_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R10cell1 = R10row.getCell(5);
	       		     	    	    	    	    	    	 if (R10cell1 != null) {
	       		     	    	    	    	    	         R10cell1.setCellValue(BRF44.getR22_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R10cell3 = R10row.getCell(6);
	       		     	    	    	    	    	    	 if (R10cell3 != null) {
	       		     	    	    	    	    	         R10cell3.setCellValue(BRF44.getR22_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R10cell4 = R10row.getCell(7);
	       		     	    	    	    	    	    	 if (R10cell4 != null) {
	       		     	    	    	    	    	         R10cell4.setCellValue(BRF44.getR22_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R10cell5 = R10row.getCell(8);
	       		     	    	    	    	    	    	 if (R10cell5 != null) {
	       		     	    	    	    	    	         R10cell5.setCellValue(BRF44.getR22_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R10cell6 = R10row.getCell(9);
	       		     	    	    	    	    	    	 if (R10cell6 != null) {
	       		     	    	    	    	    	         R10cell6.setCellValue(BRF44.getR22_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R10cell7 = R10row.getCell(10);
	       		     	    	    	    	    	    	 if (R10cell7 != null) {
	       		     	    	    	    	    	         R10cell7.setCellValue(BRF44.getR22_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R10cell8 = R10row.getCell(11);
	       		     	    	    	    	    	    	 if (R10cell8 != null) {
	       		     	    	    	    	    	         R10cell8.setCellValue(BRF44.getR22_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR22_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R23////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R11row = sheet.getRow(22);
	       		     	    	    	    	    	    	 Cell R11cell = R11row.getCell(4);
	       		     	    	    	    	    	    	 if (R11cell != null) {
	       		     	    	    	    	    	         R11cell.setCellValue(BRF44.getR23_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R11cell1 = R11row.getCell(5);
	       		     	    	    	    	    	    	 if (R11cell1 != null) {
	       		     	    	    	    	    	         R11cell1.setCellValue(BRF44.getR23_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R11cell3 = R11row.getCell(6);
	       		     	    	    	    	    	    	 if (R11cell3 != null) {
	       		     	    	    	    	    	         R11cell3.setCellValue(BRF44.getR23_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R11cell4 = R11row.getCell(7);
	       		     	    	    	    	    	    	 if (R11cell4 != null) {
	       		     	    	    	    	    	         R11cell4.setCellValue(BRF44.getR23_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R11cell5 = R11row.getCell(8);
	       		     	    	    	    	    	    	 if (R11cell5 != null) {
	       		     	    	    	    	    	         R11cell5.setCellValue(BRF44.getR23_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R11cell6 = R11row.getCell(9);
	       		     	    	    	    	    	    	 if (R11cell6 != null) {
	       		     	    	    	    	    	         R11cell6.setCellValue(BRF44.getR23_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R11cell7 = R11row.getCell(10);
	       		     	    	    	    	    	    	 if (R11cell7 != null) {
	       		     	    	    	    	    	         R11cell7.setCellValue(BRF44.getR23_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R11cell8 = R11row.getCell(11);
	       		     	    	    	    	    	    	 if (R11cell8 != null) {
	       		     	    	    	    	    	         R11cell8.setCellValue(BRF44.getR23_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR23_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R24////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R12row = sheet.getRow(23);
	       		     	    	    	    	    	    	 Cell R12cell = R12row.getCell(4);
	       		     	    	    	    	    	    	 if (R12cell != null) {
	       		     	    	    	    	    	         R12cell.setCellValue(BRF44.getR24_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R12cell1 = R12row.getCell(5);
	       		     	    	    	    	    	    	 if (R12cell1 != null) {
	       		     	    	    	    	    	         R12cell1.setCellValue(BRF44.getR24_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R12cell3 = R12row.getCell(6);
	       		     	    	    	    	    	    	 if (R12cell3 != null) {
	       		     	    	    	    	    	         R12cell3.setCellValue(BRF44.getR24_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R12cell4 = R12row.getCell(7);
	       		     	    	    	    	    	    	 if (R12cell4 != null) {
	       		     	    	    	    	    	         R12cell4.setCellValue(BRF44.getR24_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R12cell5 = R12row.getCell(8);
	       		     	    	    	    	    	    	 if (R12cell5 != null) {
	       		     	    	    	    	    	         R12cell5.setCellValue(BRF44.getR24_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R12cell6 = R12row.getCell(9);
	       		     	    	    	    	    	    	 if (R12cell6 != null) {
	       		     	    	    	    	    	         R12cell6.setCellValue(BRF44.getR24_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R12cell7 = R12row.getCell(10);
	       		     	    	    	    	    	    	 if (R12cell7 != null) {
	       		     	    	    	    	    	         R12cell7.setCellValue(BRF44.getR24_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R12cell8 = R12row.getCell(11);
	       		     	    	    	    	    	    	 if (R12cell8 != null) {
	       		     	    	    	    	    	         R12cell8.setCellValue(BRF44.getR24_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR24_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R25////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R13row = sheet.getRow(24);
	       		     	    	    	    	    	    	 Cell R13cell = R13row.getCell(4);
	       		     	    	    	    	    	    	 if (R13cell != null) {
	       		     	    	    	    	    	         R13cell.setCellValue(BRF44.getR25_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R13cell1 = R13row.getCell(5);
	       		     	    	    	    	    	    	 if (R13cell1 != null) {
	       		     	    	    	    	    	         R13cell1.setCellValue(BRF44.getR25_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R13cell3 = R13row.getCell(6);
	       		     	    	    	    	    	    	 if (R13cell3 != null) {
	       		     	    	    	    	    	         R13cell3.setCellValue(BRF44.getR25_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R13cell4 = R13row.getCell(7);
	       		     	    	    	    	    	    	 if (R13cell4 != null) {
	       		     	    	    	    	    	         R13cell4.setCellValue(BRF44.getR25_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R13cell5 = R13row.getCell(8);
	       		     	    	    	    	    	    	 if (R13cell5 != null) {
	       		     	    	    	    	    	         R13cell5.setCellValue(BRF44.getR25_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R13cell6 = R13row.getCell(9);
	       		     	    	    	    	    	    	 if (R13cell6 != null) {
	       		     	    	    	    	    	         R13cell6.setCellValue(BRF44.getR25_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R13cell7 = R13row.getCell(10);
	       		     	    	    	    	    	    	 if (R13cell7 != null) {
	       		     	    	    	    	    	         R13cell7.setCellValue(BRF44.getR25_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R13cell8 = R13row.getCell(11);
	       		     	    	    	    	    	    	 if (R13cell8 != null) {
	       		     	    	    	    	    	         R13cell8.setCellValue(BRF44.getR25_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR25_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R26////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R14row = sheet.getRow(25);
	       		     	    	    	    	    	    	 Cell R14cell = R14row.getCell(4);
	       		     	    	    	    	    	    	 if (R14cell != null) {
	       		     	    	    	    	    	         R14cell.setCellValue(BRF44.getR26_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R14cell1 = R14row.getCell(5);
	       		     	    	    	    	    	    	 if (R14cell1 != null) {
	       		     	    	    	    	    	         R14cell1.setCellValue(BRF44.getR26_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R14cell3 = R14row.getCell(6);
	       		     	    	    	    	    	    	 if (R14cell3 != null) {
	       		     	    	    	    	    	         R14cell3.setCellValue(BRF44.getR26_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R14cell4 = R14row.getCell(7);
	       		     	    	    	    	    	    	 if (R14cell4 != null) {
	       		     	    	    	    	    	         R14cell4.setCellValue(BRF44.getR26_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R14cell5 = R14row.getCell(8);
	       		     	    	    	    	    	    	 if (R14cell5 != null) {
	       		     	    	    	    	    	         R14cell5.setCellValue(BRF44.getR26_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R14cell6 = R14row.getCell(9);
	       		     	    	    	    	    	    	 if (R14cell6 != null) {
	       		     	    	    	    	    	         R14cell6.setCellValue(BRF44.getR26_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R14cell7 = R14row.getCell(10);
	       		     	    	    	    	    	    	 if (R14cell7 != null) {
	       		     	    	    	    	    	         R14cell7.setCellValue(BRF44.getR26_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R14cell8 = R14row.getCell(11);
	       		     	    	    	    	    	    	 if (R14cell8 != null) {
	       		     	    	    	    	    	         R14cell8.setCellValue(BRF44.getR26_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR26_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R27////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R15row = sheet.getRow(26);
	       		     	    	    	    	    	    	 Cell R15cell = R15row.getCell(4);
	       		     	    	    	    	    	    	 if (R15cell != null) {
	       		     	    	    	    	    	         R15cell.setCellValue(BRF44.getR27_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R15cell1 = R15row.getCell(5);
	       		     	    	    	    	    	    	 if (R15cell1 != null) {
	       		     	    	    	    	    	         R15cell1.setCellValue(BRF44.getR27_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R15cell3 = R15row.getCell(6);
	       		     	    	    	    	    	    	 if (R15cell3 != null) {
	       		     	    	    	    	    	         R15cell3.setCellValue(BRF44.getR27_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R15cell4 = R15row.getCell(7);
	       		     	    	    	    	    	    	 if (R15cell4 != null) {
	       		     	    	    	    	    	         R15cell4.setCellValue(BRF44.getR27_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R15cell5 = R15row.getCell(8);
	       		     	    	    	    	    	    	 if (R15cell5 != null) {
	       		     	    	    	    	    	         R15cell5.setCellValue(BRF44.getR27_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R15cell6 = R15row.getCell(9);
	       		     	    	    	    	    	    	 if (R15cell6 != null) {
	       		     	    	    	    	    	         R15cell6.setCellValue(BRF44.getR27_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R15cell7 = R15row.getCell(10);
	       		     	    	    	    	    	    	 if (R15cell7 != null) {
	       		     	    	    	    	    	         R15cell7.setCellValue(BRF44.getR27_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R15cell8 = R15row.getCell(11);
	       		     	    	    	    	    	    	 if (R15cell8 != null) {
	       		     	    	    	    	    	         R15cell8.setCellValue(BRF44.getR27_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR27_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R28////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R16row = sheet.getRow(27);
	       		     	    	    	    	    	    	 Cell R16cell = R16row.getCell(4);
	       		     	    	    	    	    	    	 if (R16cell != null) {
	       		     	    	    	    	    	         R16cell.setCellValue(BRF44.getR28_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R16cell1 = R16row.getCell(5);
	       		     	    	    	    	    	    	 if (R16cell1 != null) {
	       		     	    	    	    	    	         R16cell1.setCellValue(BRF44.getR28_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R16cell3 = R16row.getCell(6);
	       		     	    	    	    	    	    	 if (R16cell3 != null) {
	       		     	    	    	    	    	         R16cell3.setCellValue(BRF44.getR28_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R16cell4 = R16row.getCell(7);
	       		     	    	    	    	    	    	 if (R16cell4 != null) {
	       		     	    	    	    	    	         R16cell4.setCellValue(BRF44.getR28_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R16cell5 = R16row.getCell(8);
	       		     	    	    	    	    	    	 if (R16cell5 != null) {
	       		     	    	    	    	    	         R16cell5.setCellValue(BRF44.getR28_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R16cell6 = R16row.getCell(9);
	       		     	    	    	    	    	    	 if (R16cell6 != null) {
	       		     	    	    	    	    	         R16cell6.setCellValue(BRF44.getR28_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R16cell7 = R16row.getCell(10);
	       		     	    	    	    	    	    	 if (R16cell7 != null) {
	       		     	    	    	    	    	         R16cell7.setCellValue(BRF44.getR28_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R16cell8 = R16row.getCell(11);
	       		     	    	    	    	    	    	 if (R16cell8 != null) {
	       		     	    	    	    	    	         R16cell8.setCellValue(BRF44.getR28_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR28_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R29////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R17row = sheet.getRow(28);
	       		     	    	    	    	    	    	 Cell R17cell = R17row.getCell(4);
	       		     	    	    	    	    	    	 if (R17cell != null) {
	       		     	    	    	    	    	         R17cell.setCellValue(BRF44.getR29_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R17cell1 = R17row.getCell(5);
	       		     	    	    	    	    	    	 if (R17cell1 != null) {
	       		     	    	    	    	    	         R17cell1.setCellValue(BRF44.getR29_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R17cell3 = R17row.getCell(6);
	       		     	    	    	    	    	    	 if (R17cell3 != null) {
	       		     	    	    	    	    	         R17cell3.setCellValue(BRF44.getR29_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R17cell4 = R17row.getCell(7);
	       		     	    	    	    	    	    	 if (R17cell4 != null) {
	       		     	    	    	    	    	         R17cell4.setCellValue(BRF44.getR29_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R17cell5 = R17row.getCell(8);
	       		     	    	    	    	    	    	 if (R17cell5 != null) {
	       		     	    	    	    	    	         R17cell5.setCellValue(BRF44.getR29_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R17cell6 = R17row.getCell(9);
	       		     	    	    	    	    	    	 if (R17cell6 != null) {
	       		     	    	    	    	    	         R17cell6.setCellValue(BRF44.getR29_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R17cell7 = R17row.getCell(10);
	       		     	    	    	    	    	    	 if (R17cell7 != null) {
	       		     	    	    	    	    	         R17cell7.setCellValue(BRF44.getR29_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R17cell8 = R17row.getCell(11);
	       		     	    	    	    	    	    	 if (R17cell8 != null) {
	       		     	    	    	    	    	         R17cell8.setCellValue(BRF44.getR29_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR29_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R31////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R18row = sheet.getRow(30);
	       		     	    	    	    	    	    	 Cell R18cell = R18row.getCell(4);
	       		     	    	    	    	    	    	 if (R18cell != null) {
	       		     	    	    	    	    	         R18cell.setCellValue(BRF44.getR31_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R18cell1 = R18row.getCell(5);
	       		     	    	    	    	    	    	 if (R18cell1 != null) {
	       		     	    	    	    	    	         R18cell1.setCellValue(BRF44.getR31_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R18cell3 = R18row.getCell(6);
	       		     	    	    	    	    	    	 if (R18cell3 != null) {
	       		     	    	    	    	    	         R18cell3.setCellValue(BRF44.getR31_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R18cell4 = R18row.getCell(7);
	       		     	    	    	    	    	    	 if (R18cell4 != null) {
	       		     	    	    	    	    	         R18cell4.setCellValue(BRF44.getR31_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R18cell5 = R18row.getCell(8);
	       		     	    	    	    	    	    	 if (R18cell5 != null) {
	       		     	    	    	    	    	         R18cell5.setCellValue(BRF44.getR31_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R18cell6 = R18row.getCell(9);
	       		     	    	    	    	    	    	 if (R18cell6 != null) {
	       		     	    	    	    	    	         R18cell6.setCellValue(BRF44.getR31_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R18cell7 = R18row.getCell(10);
	       		     	    	    	    	    	    	 if (R18cell7 != null) {
	       		     	    	    	    	    	         R18cell7.setCellValue(BRF44.getR31_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R18cell8 = R18row.getCell(11);
	       		     	    	    	    	    	    	 if (R18cell8 != null) {
	       		     	    	    	    	    	         R18cell8.setCellValue(BRF44.getR31_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR31_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R32////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R19row = sheet.getRow(31);
	       		     	    	    	    	    	    	 Cell R19cell = R19row.getCell(4);
	       		     	    	    	    	    	    	 if (R19cell != null) {
	       		     	    	    	    	    	         R19cell.setCellValue(BRF44.getR32_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R19cell1 = R19row.getCell(5);
	       		     	    	    	    	    	    	 if (R19cell1 != null) {
	       		     	    	    	    	    	         R19cell1.setCellValue(BRF44.getR32_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R19cell3 = R19row.getCell(6);
	       		     	    	    	    	    	    	 if (R19cell3 != null) {
	       		     	    	    	    	    	         R19cell3.setCellValue(BRF44.getR32_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R19cell4 = R19row.getCell(7);
	       		     	    	    	    	    	    	 if (R19cell4 != null) {
	       		     	    	    	    	    	         R19cell4.setCellValue(BRF44.getR32_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R19cell5 = R19row.getCell(8);
	       		     	    	    	    	    	    	 if (R19cell5 != null) {
	       		     	    	    	    	    	         R19cell5.setCellValue(BRF44.getR32_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R19cell6 = R19row.getCell(9);
	       		     	    	    	    	    	    	 if (R19cell6 != null) {
	       		     	    	    	    	    	         R19cell6.setCellValue(BRF44.getR32_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R19cell7 = R19row.getCell(10);
	       		     	    	    	    	    	    	 if (R19cell7 != null) {
	       		     	    	    	    	    	         R19cell7.setCellValue(BRF44.getR32_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R19cell8 = R19row.getCell(11);
	       		     	    	    	    	    	    	 if (R19cell8 != null) {
	       		     	    	    	    	    	         R19cell8.setCellValue(BRF44.getR32_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR32_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R33////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R20row = sheet.getRow(32);
	       		     	    	    	    	    	    	 Cell R20cell = R20row.getCell(4);
	       		     	    	    	    	    	    	 if (R20cell != null) {
	       		     	    	    	    	    	         R20cell.setCellValue(BRF44.getR33_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R20cell1 = R20row.getCell(5);
	       		     	    	    	    	    	    	 if (R20cell1 != null) {
	       		     	    	    	    	    	         R20cell1.setCellValue(BRF44.getR33_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R20cell3 = R20row.getCell(6);
	       		     	    	    	    	    	    	 if (R20cell3 != null) {
	       		     	    	    	    	    	         R20cell3.setCellValue(BRF44.getR33_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R20cell4 = R20row.getCell(7);
	       		     	    	    	    	    	    	 if (R20cell4 != null) {
	       		     	    	    	    	    	         R20cell4.setCellValue(BRF44.getR33_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R20cell5 = R20row.getCell(8);
	       		     	    	    	    	    	    	 if (R20cell5 != null) {
	       		     	    	    	    	    	         R20cell5.setCellValue(BRF44.getR33_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R20cell6 = R20row.getCell(9);
	       		     	    	    	    	    	    	 if (R20cell6 != null) {
	       		     	    	    	    	    	         R20cell6.setCellValue(BRF44.getR33_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R20cell7 = R20row.getCell(10);
	       		     	    	    	    	    	    	 if (R20cell7 != null) {
	       		     	    	    	    	    	         R20cell7.setCellValue(BRF44.getR33_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R20cell8 = R20row.getCell(11);
	       		     	    	    	    	    	    	 if (R20cell8 != null) {
	       		     	    	    	    	    	         R20cell8.setCellValue(BRF44.getR33_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR33_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R34////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R21row = sheet.getRow(34);
	       		     	    	    	    	    	    	 Cell R21cell = R21row.getCell(4);
	       		     	    	    	    	    	    	 if (R21cell != null) {
	       		     	    	    	    	    	         R21cell.setCellValue(BRF44.getR34_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R21cell1 = R21row.getCell(5);
	       		     	    	    	    	    	    	 if (R21cell1 != null) {
	       		     	    	    	    	    	         R21cell1.setCellValue(BRF44.getR34_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R21cell3 = R21row.getCell(6);
	       		     	    	    	    	    	    	 if (R21cell3 != null) {
	       		     	    	    	    	    	         R21cell3.setCellValue(BRF44.getR34_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R21cell4 = R21row.getCell(7);
	       		     	    	    	    	    	    	 if (R21cell4 != null) {
	       		     	    	    	    	    	         R21cell4.setCellValue(BRF44.getR34_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R21cell5 = R21row.getCell(8);
	       		     	    	    	    	    	    	 if (R21cell5 != null) {
	       		     	    	    	    	    	         R21cell5.setCellValue(BRF44.getR34_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R21cell6 = R21row.getCell(9);
	       		     	    	    	    	    	    	 if (R21cell6 != null) {
	       		     	    	    	    	    	         R21cell6.setCellValue(BRF44.getR34_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R21cell7 = R21row.getCell(10);
	       		     	    	    	    	    	    	 if (R21cell7 != null) {
	       		     	    	    	    	    	         R21cell7.setCellValue(BRF44.getR34_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R21cell8 = R21row.getCell(11);
	       		     	    	    	    	    	    	 if (R21cell8 != null) {
	       		     	    	    	    	    	         R21cell8.setCellValue(BRF44.getR34_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR34_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R35////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R22row = sheet.getRow(35);
	       		     	    	    	    	    	    	 Cell R22cell = R22row.getCell(4);
	       		     	    	    	    	    	    	 if (R22cell != null) {
	       		     	    	    	    	    	         R22cell.setCellValue(BRF44.getR35_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R22cell1 = R22row.getCell(5);
	       		     	    	    	    	    	    	 if (R22cell1 != null) {
	       		     	    	    	    	    	         R22cell1.setCellValue(BRF44.getR35_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R22cell3 = R22row.getCell(6);
	       		     	    	    	    	    	    	 if (R22cell3 != null) {
	       		     	    	    	    	    	         R22cell3.setCellValue(BRF44.getR35_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R22cell4 = R22row.getCell(7);
	       		     	    	    	    	    	    	 if (R22cell4 != null) {
	       		     	    	    	    	    	         R22cell4.setCellValue(BRF44.getR35_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R22cell5 = R22row.getCell(8);
	       		     	    	    	    	    	    	 if (R22cell5 != null) {
	       		     	    	    	    	    	         R22cell5.setCellValue(BRF44.getR35_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R22cell6 = R22row.getCell(9);
	       		     	    	    	    	    	    	 if (R22cell6 != null) {
	       		     	    	    	    	    	         R22cell6.setCellValue(BRF44.getR35_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R22cell7 = R22row.getCell(10);
	       		     	    	    	    	    	    	 if (R22cell7 != null) {
	       		     	    	    	    	    	         R22cell7.setCellValue(BRF44.getR35_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R22cell8 = R22row.getCell(11);
	       		     	    	    	    	    	    	 if (R22cell8 != null) {
	       		     	    	    	    	    	         R22cell8.setCellValue(BRF44.getR35_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR35_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R36////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R23row = sheet.getRow(36);
	       		     	    	    	    	    	    	 Cell R23cell = R23row.getCell(4);
	       		     	    	    	    	    	    	 if (R23cell != null) {
	       		     	    	    	    	    	         R23cell.setCellValue(BRF44.getR36_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R23cell1 = R23row.getCell(5);
	       		     	    	    	    	    	    	 if (R23cell1 != null) {
	       		     	    	    	    	    	         R23cell1.setCellValue(BRF44.getR36_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R23cell3 = R23row.getCell(6);
	       		     	    	    	    	    	    	 if (R23cell3 != null) {
	       		     	    	    	    	    	         R23cell3.setCellValue(BRF44.getR36_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R23cell4 = R23row.getCell(7);
	       		     	    	    	    	    	    	 if (R23cell4 != null) {
	       		     	    	    	    	    	         R23cell4.setCellValue(BRF44.getR36_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R23cell5 = R23row.getCell(8);
	       		     	    	    	    	    	    	 if (R23cell5 != null) {
	       		     	    	    	    	    	         R23cell5.setCellValue(BRF44.getR36_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R23cell6 = R23row.getCell(9);
	       		     	    	    	    	    	    	 if (R23cell6 != null) {
	       		     	    	    	    	    	         R23cell6.setCellValue(BRF44.getR36_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R23cell7 = R23row.getCell(10);
	       		     	    	    	    	    	    	 if (R23cell7 != null) {
	       		     	    	    	    	    	         R23cell7.setCellValue(BRF44.getR36_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R23cell8 = R23row.getCell(11);
	       		     	    	    	    	    	    	 if (R23cell8 != null) {
	       		     	    	    	    	    	         R23cell8.setCellValue(BRF44.getR36_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR36_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	   ////////////////////R37////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R24row = sheet.getRow(37);
	       		     	    	    	    	    	    	 Cell R24cell = R24row.getCell(4);
	       		     	    	    	    	    	    	 if (R24cell != null) {
	       		     	    	    	    	    	         R24cell.setCellValue(BRF44.getR37_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_gre_no().intValue());
	       		     	    	    	    	    	    	 }

	       		     	    	    	    	    	    	Cell R24cell1 = R24row.getCell(5);
	       		     	    	    	    	    	    	 if (R24cell1 != null) {
	       		     	    	    	    	    	         R24cell1.setCellValue(BRF44.getR37_gre_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_gre_amount().intValue());
	       		     	    	    	    	    	    	 }



	       		     	    	    	    	    	  	Cell R24cell3 = R24row.getCell(6);
	       		     	    	    	    	    	    	 if (R24cell3 != null) {
	       		     	    	    	    	    	         R24cell3.setCellValue(BRF44.getR37_stand_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_stand_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R24cell4 = R24row.getCell(7);
	       		     	    	    	    	    	    	 if (R24cell4 != null) {
	       		     	    	    	    	    	         R24cell4.setCellValue(BRF44.getR37_stand_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_stand_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R24cell5 = R24row.getCell(8);
	       		     	    	    	    	    	    	 if (R24cell5 != null) {
	       		     	    	    	    	    	         R24cell5.setCellValue(BRF44.getR37_high_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_high_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R24cell6 = R24row.getCell(9);
	       		     	    	    	    	    	    	 if (R24cell6 != null) {
	       		     	    	    	    	    	         R24cell6.setCellValue(BRF44.getR37_high_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_high_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	    	Cell R24cell7 = R24row.getCell(10);
	       		     	    	    	    	    	    	 if (R24cell7 != null) {
	       		     	    	    	    	    	         R24cell7.setCellValue(BRF44.getR37_other_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_other_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	  	Cell R24cell8 = R24row.getCell(11);
	       		     	    	    	    	    	    	 if (R24cell8 != null) {
	       		     	    	    	    	    	         R24cell8.setCellValue(BRF44.getR37_other_amount() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR37_other_amount().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	    	 
	       		     	    	    	    	    	 	 
	       		     	    	    	    	    	 	 
	       		     	    	    	 ////////////////////R38////////////////////////////
	       		     	    	    	    	    		   
	       		     	    	    	    	    	     
	       		     	    	    	    	    	     Row R25row = sheet.getRow(39);
	       		     	    	    	    	    	    	 Cell R25cell = R25row.getCell(4);
	       		     	    	    	    	    	    	 if (R25cell != null) {
	       		     	    	    	    	    	         R25cell.setCellValue(BRF44.getR38_gre_no() == null ? 0 :
	       		     	    	    	    	    	    	     	BRF44.getR38_gre_no().intValue());
	       		     	    	    	    	    	    	 }
	       		     	    	    	    	    
	       		     	       		     	 ////////////////////R38////////////////////////////
		       		     	    	    	    	    		   
		       		     	    	    	    	    	     
		       		     	    	    	    	    	     Row R26row = sheet.getRow(40);
		       		     	    	    	    	    	    	 Cell R26cell = R26row.getCell(4);
		       		     	    	    	    	    	    	 if (R26cell != null) {
		       		     	    	    	    	    	         R26cell.setCellValue(BRF44.getR39_gre_no() == null ? 0 :
		       		     	    	    	    	    	    	     	BRF44.getR39_gre_no().intValue());
		       		     	    	    	    	    	    	 }
	       		     	    	    	    	    	 	 
	       		     	    			 
	       	 
	       	 
	       	 
	       	 
	       	 // Save the changes
		       	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-044-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-044-A.xls");

		return outputFile;
	
	}



	
	
public ModelAndView getBRF44currentDtl(String reportId, String fromdate, String todate, String currency,
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
					"select * from BRF44_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

			qr.setParameter(2, filter);

		} else {
			qr = hs.createNativeQuery("select * from BRF44_DETAILTABLE a where report_date = ?1");

		}
	} else {
		qr = hs.createNativeQuery("select * from BRF44_DETAILTABLE  where report_date = ?1");
	}

	try {
		qr.setParameter(1, df.parse(todate));

	} catch (ParseException e) {
		e.printStackTrace();
	}
	List<BRF44_DETAIL_ENTITY> T1Master = new ArrayList<BRF44_DETAIL_ENTITY>();

	try {
		T1Master = hs.createQuery("from BRF44_DETAIL_ENTITY a where a.report_date = ?1", BRF44_DETAIL_ENTITY.class)
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
		Date maturity_date = (Date) a[45];
		String gender = (String)a[46];
		String version = (String) a[47];
		String remarks = (String) a[48];
		String nre_flg = (String) a[49];
		
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

		BRF44_DETAIL_ENTITY py = new BRF44_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc,
				country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code,
				group_id, constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, 
				bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user,
				create_time, modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date,
				maturity_date, gender, version, remarks,nre_flg);
		
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

	mv.setViewName("RR" + "/" + "BRF44::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster12", T1Dt1);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}
	
public String detailChanges44(BRF44_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
		BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	String msg = "";

	try {

		Session hs = sessionFactory.getCurrentSession();
		Optional<BRF44_DETAIL_ENTITY> Brf44detail = brf44DetailRep.findById(foracid);

		if (Brf44detail.isPresent()) {
			BRF44_DETAIL_ENTITY BRFdetail = Brf44detail.get();

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
				brf44DetailRep.save(BRFdetail);

//					hs.saveOrUpdate(detail);
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
	public ModelAndView getArchieveBRF044View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF44_ENTITY> T1rep = new ArrayList<BRF44_ENTITY>();
		// Query<Object[]> qr;

		List<BRF44_ENTITY> T1Master = new ArrayList<BRF44_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF44_ENTITY a where a.report_date = ?1 ", BRF44_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF044ARCH");
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



	public ModelAndView ARCHgetBRF044currentDtl(String reportId, String fromdate, String todate, String currency,
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
			
			
				qr = hs.createNativeQuery("select * from BRF44_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1,  df.parse(todate));
				qr.setParameter(2,filter);
					

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF44_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF44_ARCHIVTABLE  where report_date = ?1");
	}

	List<BRF44_ARCHIV_ENTITY> T1Master = new ArrayList<BRF44_ARCHIV_ENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF44_ARCHIV_ENTITY a where a.report_date = ?1", BRF44_ARCHIV_ENTITY.class)
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
		Date maturity_date = (Date) a[45];
		String gender = (String)a[46];
		String version = (String) a[47];
		String remarks = (String) a[48];
		String nre_flg = (String) a[49];
		
		String Remarks1;
		if (act_balance_amt_lc != null) {
			if (act_balance_amt_lc.toString().contains("-")) {
				remarks = "DR";
			} else {
				remarks = "CR";
			}
		} else {
			remarks = "";
		}

		
		
		BRF44_ARCHIV_ENTITY py = new BRF44_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc,
				country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code,
				group_id, constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth, turnover, 
				bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user,
				create_time, modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date,
				maturity_date, gender, version, remarks,nre_flg);
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

	mv.setViewName("RR" + "/" + "BRF044ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
	}
}



