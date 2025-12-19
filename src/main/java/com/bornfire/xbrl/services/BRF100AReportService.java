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
import com.bornfire.xbrl.entities.BRBS.BRF102AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF103_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF103_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF100_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF100_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF100_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF104AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF74_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF74_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF96AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF99_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_100_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_102_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF104_REPORTENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF14_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_99_A_REPORT_ENTITY;
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
public class BRF100AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF100AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF100AServiceRepo brf100aServiceRepo;
	
	@Autowired
	BRF100_DetailRep brf100_DetailRep;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF100A(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF_100_A_REPORT_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF_100_A_REPORT_ENTITY a ").getSingleResult();
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


	public ModelAndView getBRF100AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_100_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_100_A_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_100_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_100_A_REPORT_ENTITY>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF_100_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_100_A_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF100");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	
	public File getFileBRF100A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-100-A";
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

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF100_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF100_Detail.jrxml");
					}

				}  else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF100.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF100.jrxml");
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
				
				List<BRF_99_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_99_A_REPORT_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF_99_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_99_A_REPORT_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF_99_A_REPORT_ENTITY BRF99 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-100-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(11);
	           
	       
	       	 Cell cell = row.getCell(3);
	       	 if (cell != null) {
	            cell.setCellValue(BRF99.getR1_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR1_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell cell1 = row.getCell(4);
	       	 if (cell1 != null) {
	            cell1.setCellValue(BRF99.getR1_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR1_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell cell2 = row.getCell(5);
	       	 if (cell2 != null) {
	            cell2.setCellValue(BRF99.getR1_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR1_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell cell3 = row.getCell(6);
	       	 if (cell3 != null) {
	            cell3.setCellValue(BRF99.getR1_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR1_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell cell4 = row.getCell(9);
	       	 if (cell4 != null) {
	            cell4.setCellValue(BRF99.getR1_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR1_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell cell5 = row.getCell(10);
	       	 if (cell5 != null) {
	            cell5.setCellValue(BRF99.getR1_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR1_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell cell6 = row.getCell(11);
	       	 if (cell6 != null) {
	            cell6.setCellValue(BRF99.getR1_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR1_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell cell7 = row.getCell(12);
	       	 if (cell7 != null) {
	            cell7.setCellValue(BRF99.getR1_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR1_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 ////////////////R2///////////////////////////
	       	 
             Row R2row = sheet.getRow(12);
	           
  	       
	       	 Cell R2cell = R2row.getCell(3);
	       	 if (R2cell != null) {
	            R2cell.setCellValue(BRF99.getR2_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR2_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R2cell1 = R2row.getCell(4);
	       	 if (R2cell1 != null) {
	            R2cell1.setCellValue(BRF99.getR2_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR2_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R2cell2 = R2row.getCell(5);
	       	 if (R2cell2 != null) {
	            R2cell2.setCellValue(BRF99.getR2_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR2_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R2cell3 = R2row.getCell(6);
	       	 if (R2cell3 != null) {
	            R2cell3.setCellValue(BRF99.getR2_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR2_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R2cell4 = R2row.getCell(9);
	       	 if (R2cell4 != null) {
	            R2cell4.setCellValue(BRF99.getR2_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR2_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R2cell5 = R2row.getCell(10);
	       	 if (R2cell5 != null) {
	            R2cell5.setCellValue(BRF99.getR2_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR2_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R2cell6 = R2row.getCell(11);
	       	 if (R2cell6 != null) {
	            R2cell6.setCellValue(BRF99.getR2_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR2_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R2cell7 = R2row.getCell(12);
	       	 if (R2cell7 != null) {
	            R2cell7.setCellValue(BRF99.getR2_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR2_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R3////////////////
			  
			  Row R3row = sheet.getRow(13);
	           
	       
	       	 Cell R3cell = R3row.getCell(3);
	       	 if (R3cell != null) {
	            R3cell.setCellValue(BRF99.getR3_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR3_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R3cell1 = R3row.getCell(4);
	       	 if (R3cell1 != null) {
	            R3cell1.setCellValue(BRF99.getR3_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR3_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R3cell2 = R3row.getCell(5);
	       	 if (R3cell2 != null) {
	            R3cell2.setCellValue(BRF99.getR3_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR3_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R3cell3 = R3row.getCell(6);
	       	 if (R3cell3 != null) {
	            R3cell3.setCellValue(BRF99.getR3_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR3_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R3cell4 = R3row.getCell(9);
	       	 if (R3cell4 != null) {
	            R3cell4.setCellValue(BRF99.getR3_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR3_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R3cell5 = R3row.getCell(10);
	       	 if (R3cell5 != null) {
	            R3cell5.setCellValue(BRF99.getR3_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR3_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R3cell6 = R3row.getCell(11);
	       	 if (R3cell6 != null) {
	            R3cell6.setCellValue(BRF99.getR3_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR3_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R3cell7 = R3row.getCell(12);
	       	 if (R3cell7 != null) {
	            R3cell7.setCellValue(BRF99.getR3_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR3_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R4////////////////
			  
			  Row R4row = sheet.getRow(14);
	           
	       
	       	 Cell R4cell = R4row.getCell(3);
	       	 if (R4cell != null) {
	            R4cell.setCellValue(BRF99.getR4_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR4_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R4cell1 = R4row.getCell(4);
	       	 if (R4cell1 != null) {
	            R4cell1.setCellValue(BRF99.getR4_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR4_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R4cell2 = R4row.getCell(5);
	       	 if (R4cell2 != null) {
	            R4cell2.setCellValue(BRF99.getR4_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR4_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R4cell3 = R4row.getCell(6);
	       	 if (R4cell3 != null) {
	            R4cell3.setCellValue(BRF99.getR4_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR4_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R4cell4 = R4row.getCell(9);
	       	 if (R4cell4 != null) {
	            R4cell4.setCellValue(BRF99.getR4_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR4_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R4cell5 = R4row.getCell(10);
	       	 if (R4cell5 != null) {
	            R4cell5.setCellValue(BRF99.getR4_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR4_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R4cell6 = R4row.getCell(11);
	       	 if (R4cell6 != null) {
	            R4cell6.setCellValue(BRF99.getR4_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR4_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R4cell7 = R4row.getCell(12);
	       	 if (R4cell7 != null) {
	            R4cell7.setCellValue(BRF99.getR4_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR4_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R5////////////////
			  
			  Row R5row = sheet.getRow(15);
	           
	       
	       	 Cell R5cell = R5row.getCell(3);
	       	 if (R5cell != null) {
	            R5cell.setCellValue(BRF99.getR5_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR5_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R5cell1 = R5row.getCell(4);
	       	 if (R5cell1 != null) {
	            R5cell1.setCellValue(BRF99.getR5_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR5_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R5cell2 = R5row.getCell(5);
	       	 if (R5cell2 != null) {
	            R5cell2.setCellValue(BRF99.getR5_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR5_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R5cell3 = R5row.getCell(6);
	       	 if (R5cell3 != null) {
	            R5cell3.setCellValue(BRF99.getR5_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR5_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R5cell4 = R5row.getCell(9);
	       	 if (R5cell4 != null) {
	            R5cell4.setCellValue(BRF99.getR5_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR5_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R5cell5 = R5row.getCell(10);
	       	 if (R5cell5 != null) {
	            R5cell5.setCellValue(BRF99.getR5_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR5_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R5cell6 = R5row.getCell(11);
	       	 if (R5cell6 != null) {
	            R5cell6.setCellValue(BRF99.getR5_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR5_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R5cell7 = R5row.getCell(12);
	       	 if (R5cell7 != null) {
	            R5cell7.setCellValue(BRF99.getR5_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR5_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R6////////////////
			  
			  Row R6row = sheet.getRow(16);
	           
	       
	       	 Cell R6cell = R6row.getCell(3);
	       	 if (R6cell != null) {
	            R6cell.setCellValue(BRF99.getR6_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR6_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R6cell1 = R6row.getCell(4);
	       	 if (R6cell1 != null) {
	            R6cell1.setCellValue(BRF99.getR6_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR6_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R6cell2 = R6row.getCell(5);
	       	 if (R6cell2 != null) {
	            R6cell2.setCellValue(BRF99.getR6_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR6_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R6cell3 = R6row.getCell(6);
	       	 if (R6cell3 != null) {
	            R6cell3.setCellValue(BRF99.getR6_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR6_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R6cell4 = R6row.getCell(9);
	       	 if (R6cell4 != null) {
	            R6cell4.setCellValue(BRF99.getR6_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR6_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R6cell5 = R6row.getCell(10);
	       	 if (R6cell5 != null) {
	            R6cell5.setCellValue(BRF99.getR6_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR6_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R6cell6 = R6row.getCell(11);
	       	 if (R6cell6 != null) {
	            R6cell6.setCellValue(BRF99.getR6_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR6_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R6cell7 = R6row.getCell(12);
	       	 if (R6cell7 != null) {
	            R6cell7.setCellValue(BRF99.getR6_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR6_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R7////////////////
			  
			  Row R7row = sheet.getRow(17);
	           
	       
	       	 Cell R7cell = R7row.getCell(3);
	       	 if (R7cell != null) {
	            R7cell.setCellValue(BRF99.getR7_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR7_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R7cell1 = R7row.getCell(4);
	       	 if (R7cell1 != null) {
	            R7cell1.setCellValue(BRF99.getR7_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR7_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R7cell2 = R7row.getCell(5);
	       	 if (R7cell2 != null) {
	            R7cell2.setCellValue(BRF99.getR7_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR7_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R7cell3 = R7row.getCell(6);
	       	 if (R7cell3 != null) {
	            R7cell3.setCellValue(BRF99.getR7_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR7_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R7cell4 = R7row.getCell(9);
	       	 if (R7cell4 != null) {
	            R7cell4.setCellValue(BRF99.getR7_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR7_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R7cell5 = R7row.getCell(10);
	       	 if (R7cell5 != null) {
	            R7cell5.setCellValue(BRF99.getR7_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR7_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R7cell6 = R7row.getCell(11);
	       	 if (R7cell6 != null) {
	            R7cell6.setCellValue(BRF99.getR7_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR7_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R7cell7 = R7row.getCell(12);
	       	 if (R7cell7 != null) {
	            R7cell7.setCellValue(BRF99.getR7_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR7_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R8////////////////
			  
			  Row R8row = sheet.getRow(18);
	           
	       
	       	 Cell R8cell = R8row.getCell(3);
	       	 if (R8cell != null) {
	            R8cell.setCellValue(BRF99.getR8_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR8_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R8cell1 = R8row.getCell(4);
	       	 if (R8cell1 != null) {
	            R8cell1.setCellValue(BRF99.getR8_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR8_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R8cell2 = R8row.getCell(5);
	       	 if (R8cell2 != null) {
	            R8cell2.setCellValue(BRF99.getR8_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR8_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R8cell3 = R8row.getCell(6);
	       	 if (R8cell3 != null) {
	            R8cell3.setCellValue(BRF99.getR8_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR8_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R8cell4 = R8row.getCell(9);
	       	 if (R8cell4 != null) {
	            R8cell4.setCellValue(BRF99.getR8_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR8_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R8cell5 = R8row.getCell(10);
	       	 if (R8cell5 != null) {
	            R8cell5.setCellValue(BRF99.getR8_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR8_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R8cell6 = R8row.getCell(11);
	       	 if (R8cell6 != null) {
	            R8cell6.setCellValue(BRF99.getR8_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR8_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R8cell7 = R8row.getCell(12);
	       	 if (R8cell7 != null) {
	            R8cell7.setCellValue(BRF99.getR8_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR8_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R9////////////////
			  
			  Row R9row = sheet.getRow(19);
	           
	       
	       	 Cell R9cell = R9row.getCell(3);
	       	 if (R9cell != null) {
	            R9cell.setCellValue(BRF99.getR9_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR9_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R9cell1 = R9row.getCell(4);
	       	 if (R9cell1 != null) {
	            R9cell1.setCellValue(BRF99.getR9_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR9_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R9cell2 = R9row.getCell(5);
	       	 if (R9cell2 != null) {
	            R9cell2.setCellValue(BRF99.getR9_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR9_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R9cell3 = R9row.getCell(6);
	       	 if (R9cell3 != null) {
	            R9cell3.setCellValue(BRF99.getR9_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR9_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R9cell4 = R9row.getCell(9);
	       	 if (R9cell4 != null) {
	            R9cell4.setCellValue(BRF99.getR9_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR9_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R9cell5 = R9row.getCell(10);
	       	 if (R9cell5 != null) {
	            R9cell5.setCellValue(BRF99.getR9_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR9_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R9cell6 = R9row.getCell(11);
	       	 if (R9cell6 != null) {
	            R9cell6.setCellValue(BRF99.getR9_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR9_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R9cell7 = R9row.getCell(12);
	       	 if (R9cell7 != null) {
	            R9cell7.setCellValue(BRF99.getR9_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR9_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R10////////////////
			  
			  Row R10row = sheet.getRow(20);
	           
	       
	       	 Cell R10cell = R10row.getCell(3);
	       	 if (R10cell != null) {
	            R10cell.setCellValue(BRF99.getR10_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR10_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R10cell1 = R10row.getCell(4);
	       	 if (R10cell1 != null) {
	            R10cell1.setCellValue(BRF99.getR10_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR10_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R10cell2 = R10row.getCell(5);
	       	 if (R10cell2 != null) {
	            R10cell2.setCellValue(BRF99.getR10_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR10_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R10cell3 = R10row.getCell(6);
	       	 if (R10cell3 != null) {
	            R10cell3.setCellValue(BRF99.getR10_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR10_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R10cell4 = R10row.getCell(9);
	       	 if (R10cell4 != null) {
	            R10cell4.setCellValue(BRF99.getR10_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR10_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R10cell5 = R10row.getCell(10);
	       	 if (R10cell5 != null) {
	            R10cell5.setCellValue(BRF99.getR10_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR10_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R10cell6 = R10row.getCell(11);
	       	 if (R10cell6 != null) {
	            R10cell6.setCellValue(BRF99.getR10_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR10_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R10cell7 = R10row.getCell(12);
	       	 if (R10cell7 != null) {
	            R10cell7.setCellValue(BRF99.getR10_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR10_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R11////////////////
			  
			  Row R11row = sheet.getRow(21);
	           
	       
	       	 Cell R11cell = R11row.getCell(3);
	       	 if (R11cell != null) {
	            R11cell.setCellValue(BRF99.getR11_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR11_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R11cell1 = R11row.getCell(4);
	       	 if (R11cell1 != null) {
	            R11cell1.setCellValue(BRF99.getR11_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR11_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R11cell2 = R11row.getCell(5);
	       	 if (R11cell2 != null) {
	            R11cell2.setCellValue(BRF99.getR11_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR11_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R11cell3 = R11row.getCell(6);
	       	 if (R11cell3 != null) {
	            R11cell3.setCellValue(BRF99.getR11_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR11_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R11cell4 = R11row.getCell(9);
	       	 if (R11cell4 != null) {
	            R11cell4.setCellValue(BRF99.getR11_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR11_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R11cell5 = R11row.getCell(10);
	       	 if (R11cell5 != null) {
	            R11cell5.setCellValue(BRF99.getR11_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR11_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R11cell6 = R11row.getCell(11);
	       	 if (R11cell6 != null) {
	            R11cell6.setCellValue(BRF99.getR11_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR11_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R11cell7 = R11row.getCell(12);
	       	 if (R11cell7 != null) {
	            R11cell7.setCellValue(BRF99.getR11_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR11_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R12////////////////
			  
			  Row R12row = sheet.getRow(22);
	           
	       
	       	 Cell R12cell = R12row.getCell(3);
	       	 if (R12cell != null) {
	            R12cell.setCellValue(BRF99.getR12_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR12_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R12cell1 = R12row.getCell(4);
	       	 if (R12cell1 != null) {
	            R12cell1.setCellValue(BRF99.getR12_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR12_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R12cell2 = R12row.getCell(5);
	       	 if (R12cell2 != null) {
	            R12cell2.setCellValue(BRF99.getR12_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR12_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R12cell3 = R12row.getCell(6);
	       	 if (R12cell3 != null) {
	            R12cell3.setCellValue(BRF99.getR12_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR12_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R12cell4 = R12row.getCell(9);
	       	 if (R12cell4 != null) {
	            R12cell4.setCellValue(BRF99.getR12_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR12_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R12cell5 = R12row.getCell(10);
	       	 if (R12cell5 != null) {
	            R12cell5.setCellValue(BRF99.getR12_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR12_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R12cell6 = R12row.getCell(11);
	       	 if (R12cell6 != null) {
	            R12cell6.setCellValue(BRF99.getR12_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR12_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R12cell7 = R12row.getCell(12);
	       	 if (R12cell7 != null) {
	            R12cell7.setCellValue(BRF99.getR12_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR12_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R13////////////////
			  
			  Row R13row = sheet.getRow(23);
	           
	       
	       	 Cell R13cell = R13row.getCell(3);
	       	 if (R13cell != null) {
	            R13cell.setCellValue(BRF99.getR13_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR13_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R13cell1 = R13row.getCell(4);
	       	 if (R13cell1 != null) {
	            R13cell1.setCellValue(BRF99.getR13_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR13_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R13cell2 = R13row.getCell(5);
	       	 if (R13cell2 != null) {
	            R13cell2.setCellValue(BRF99.getR13_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR13_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R13cell3 = R13row.getCell(6);
	       	 if (R13cell3 != null) {
	            R13cell3.setCellValue(BRF99.getR13_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR13_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R13cell4 = R13row.getCell(9);
	       	 if (R13cell4 != null) {
	            R13cell4.setCellValue(BRF99.getR13_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR13_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R13cell5 = R13row.getCell(10);
	       	 if (R13cell5 != null) {
	            R13cell5.setCellValue(BRF99.getR13_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR13_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R13cell6 = R13row.getCell(11);
	       	 if (R13cell6 != null) {
	            R13cell6.setCellValue(BRF99.getR13_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR13_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R13cell7 = R13row.getCell(12);
	       	 if (R13cell7 != null) {
	            R13cell7.setCellValue(BRF99.getR13_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR13_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R14////////////////
			  
			  Row R14row = sheet.getRow(24);
	           
	       
	       	 Cell R14cell = R14row.getCell(3);
	       	 if (R14cell != null) {
	            R14cell.setCellValue(BRF99.getR14_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR14_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R14cell1 = R14row.getCell(4);
	       	 if (R14cell1 != null) {
	            R14cell1.setCellValue(BRF99.getR14_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR14_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R14cell2 = R14row.getCell(5);
	       	 if (R14cell2 != null) {
	            R14cell2.setCellValue(BRF99.getR14_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR14_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R14cell3 = R14row.getCell(6);
	       	 if (R14cell3 != null) {
	            R14cell3.setCellValue(BRF99.getR14_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR14_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R14cell4 = R14row.getCell(9);
	       	 if (R14cell4 != null) {
	            R14cell4.setCellValue(BRF99.getR14_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR14_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R14cell5 = R14row.getCell(10);
	       	 if (R14cell5 != null) {
	            R14cell5.setCellValue(BRF99.getR14_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR14_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R14cell6 = R14row.getCell(11);
	       	 if (R14cell6 != null) {
	            R14cell6.setCellValue(BRF99.getR14_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR14_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R14cell7 = R14row.getCell(12);
	       	 if (R14cell7 != null) {
	            R14cell7.setCellValue(BRF99.getR14_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR14_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R15////////////////
			  
			  Row R15row = sheet.getRow(25);
	           
	       
	       	 Cell R15cell = R15row.getCell(3);
	       	 if (R15cell != null) {
	            R15cell.setCellValue(BRF99.getR15_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR15_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R15cell1 = R15row.getCell(4);
	       	 if (R15cell1 != null) {
	            R15cell1.setCellValue(BRF99.getR15_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR15_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R15cell2 = R15row.getCell(5);
	       	 if (R15cell2 != null) {
	            R15cell2.setCellValue(BRF99.getR15_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR15_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R15cell3 = R15row.getCell(6);
	       	 if (R15cell3 != null) {
	            R15cell3.setCellValue(BRF99.getR15_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR15_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R15cell4 = R15row.getCell(9);
	       	 if (R15cell4 != null) {
	            R15cell4.setCellValue(BRF99.getR15_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR15_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R15cell5 = R15row.getCell(10);
	       	 if (R15cell5 != null) {
	            R15cell5.setCellValue(BRF99.getR15_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR15_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R15cell6 = R15row.getCell(11);
	       	 if (R15cell6 != null) {
	            R15cell6.setCellValue(BRF99.getR15_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR15_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R15cell7 = R15row.getCell(12);
	       	 if (R15cell7 != null) {
	            R15cell7.setCellValue(BRF99.getR15_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR15_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R16////////////////
			  
			  Row R16row = sheet.getRow(26);
	           
	       
	       	 Cell R16cell = R16row.getCell(3);
	       	 if (R16cell != null) {
	            R16cell.setCellValue(BRF99.getR16_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR16_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R16cell1 = R16row.getCell(4);
	       	 if (R16cell1 != null) {
	            R16cell1.setCellValue(BRF99.getR16_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR16_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R16cell2 = R16row.getCell(5);
	       	 if (R16cell2 != null) {
	            R16cell2.setCellValue(BRF99.getR16_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR16_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R16cell3 = R16row.getCell(6);
	       	 if (R16cell3 != null) {
	            R16cell3.setCellValue(BRF99.getR16_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR16_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R16cell4 = R16row.getCell(9);
	       	 if (R16cell4 != null) {
	            R16cell4.setCellValue(BRF99.getR16_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR16_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R16cell5 = R16row.getCell(10);
	       	 if (R16cell5 != null) {
	            R16cell5.setCellValue(BRF99.getR16_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR16_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R16cell6 = R16row.getCell(11);
	       	 if (R16cell6 != null) {
	            R16cell6.setCellValue(BRF99.getR16_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR16_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R16cell7 = R16row.getCell(12);
	       	 if (R16cell7 != null) {
	            R16cell7.setCellValue(BRF99.getR16_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR16_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	    	 
             ///////////////////////R18////////////////
			  
			  Row R18row = sheet.getRow(32);
	           
	       
	       	 Cell R18cell = R18row.getCell(3);
	       	 if (R18cell != null) {
	            R18cell.setCellValue(BRF99.getR18_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR18_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R18cell1 = R18row.getCell(4);
	       	 if (R18cell1 != null) {
	            R18cell1.setCellValue(BRF99.getR18_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR18_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R18cell2 = R18row.getCell(5);
	       	 if (R18cell2 != null) {
	            R18cell2.setCellValue(BRF99.getR18_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR18_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R18cell3 = R18row.getCell(6);
	       	 if (R18cell3 != null) {
	            R18cell3.setCellValue(BRF99.getR18_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR18_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R18cell4 = R18row.getCell(9);
	       	 if (R18cell4 != null) {
	            R18cell4.setCellValue(BRF99.getR18_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR18_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R18cell5 = R18row.getCell(10);
	       	 if (R18cell5 != null) {
	            R18cell5.setCellValue(BRF99.getR18_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR18_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R18cell6 = R18row.getCell(11);
	       	 if (R18cell6 != null) {
	            R18cell6.setCellValue(BRF99.getR18_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR18_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R18cell7 = R18row.getCell(12);
	       	 if (R18cell7 != null) {
	            R18cell7.setCellValue(BRF99.getR18_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR18_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R19////////////////
			  
			  Row R19row = sheet.getRow(33);
	           
	       
	       	 Cell R19cell = R19row.getCell(3);
	       	 if (R19cell != null) {
	            R19cell.setCellValue(BRF99.getR19_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR19_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R19cell1 = R19row.getCell(4);
	       	 if (R19cell1 != null) {
	            R19cell1.setCellValue(BRF99.getR19_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR19_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R19cell2 = R19row.getCell(5);
	       	 if (R19cell2 != null) {
	            R19cell2.setCellValue(BRF99.getR19_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR19_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R19cell3 = R19row.getCell(6);
	       	 if (R19cell3 != null) {
	            R19cell3.setCellValue(BRF99.getR19_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR19_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R19cell4 = R19row.getCell(9);
	       	 if (R19cell4 != null) {
	            R19cell4.setCellValue(BRF99.getR19_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR19_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R19cell5 = R19row.getCell(10);
	       	 if (R19cell5 != null) {
	            R19cell5.setCellValue(BRF99.getR19_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR19_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R19cell6 = R19row.getCell(11);
	       	 if (R19cell6 != null) {
	            R19cell6.setCellValue(BRF99.getR19_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR19_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R19cell7 = R19row.getCell(12);
	       	 if (R19cell7 != null) {
	            R19cell7.setCellValue(BRF99.getR19_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR19_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R20////////////////
			  
			  Row R20row = sheet.getRow(34);
	           
	       
	       	 Cell R20cell = R20row.getCell(3);
	       	 if (R20cell != null) {
	            R20cell.setCellValue(BRF99.getR20_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR20_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R20cell1 = R20row.getCell(4);
	       	 if (R20cell1 != null) {
	            R20cell1.setCellValue(BRF99.getR20_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR20_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R20cell2 = R20row.getCell(5);
	       	 if (R20cell2 != null) {
	            R20cell2.setCellValue(BRF99.getR20_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR20_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R20cell3 = R20row.getCell(6);
	       	 if (R20cell3 != null) {
	            R20cell3.setCellValue(BRF99.getR20_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR20_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R20cell4 = R20row.getCell(9);
	       	 if (R20cell4 != null) {
	            R20cell4.setCellValue(BRF99.getR20_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR20_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R20cell5 = R20row.getCell(10);
	       	 if (R20cell5 != null) {
	            R20cell5.setCellValue(BRF99.getR20_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR20_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R20cell6 = R20row.getCell(11);
	       	 if (R20cell6 != null) {
	            R20cell6.setCellValue(BRF99.getR20_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR20_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R20cell7 = R20row.getCell(12);
	       	 if (R20cell7 != null) {
	            R20cell7.setCellValue(BRF99.getR20_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR20_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R21////////////////
			  
			  Row R21row = sheet.getRow(35);
	           
	       
	       	 Cell R21cell = R21row.getCell(3);
	       	 if (R21cell != null) {
	            R21cell.setCellValue(BRF99.getR21_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR21_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R21cell1 = R21row.getCell(4);
	       	 if (R21cell1 != null) {
	            R21cell1.setCellValue(BRF99.getR21_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR21_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R21cell2 = R21row.getCell(5);
	       	 if (R21cell2 != null) {
	            R21cell2.setCellValue(BRF99.getR21_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR21_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R21cell3 = R21row.getCell(6);
	       	 if (R21cell3 != null) {
	            R21cell3.setCellValue(BRF99.getR21_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR21_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R21cell4 = R21row.getCell(9);
	       	 if (R21cell4 != null) {
	            R21cell4.setCellValue(BRF99.getR21_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR21_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R21cell5 = R21row.getCell(10);
	       	 if (R21cell5 != null) {
	            R21cell5.setCellValue(BRF99.getR21_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR21_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R21cell6 = R21row.getCell(11);
	       	 if (R21cell6 != null) {
	            R21cell6.setCellValue(BRF99.getR21_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR21_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R21cell7 = R21row.getCell(12);
	       	 if (R21cell7 != null) {
	            R21cell7.setCellValue(BRF99.getR21_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR21_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R22////////////////
			  
			  Row R22row = sheet.getRow(36);
	           
	       
	       	 Cell R22cell = R22row.getCell(3);
	       	 if (R22cell != null) {
	            R22cell.setCellValue(BRF99.getR22_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR22_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R22cell1 = R22row.getCell(4);
	       	 if (R22cell1 != null) {
	            R22cell1.setCellValue(BRF99.getR22_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR22_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R22cell2 = R22row.getCell(5);
	       	 if (R22cell2 != null) {
	            R22cell2.setCellValue(BRF99.getR22_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR22_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R22cell3 = R22row.getCell(6);
	       	 if (R22cell3 != null) {
	            R22cell3.setCellValue(BRF99.getR22_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR22_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R22cell4 = R22row.getCell(9);
	       	 if (R22cell4 != null) {
	            R22cell4.setCellValue(BRF99.getR22_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR22_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R22cell5 = R22row.getCell(10);
	       	 if (R22cell5 != null) {
	            R22cell5.setCellValue(BRF99.getR22_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR22_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R22cell6 = R22row.getCell(11);
	       	 if (R22cell6 != null) {
	            R22cell6.setCellValue(BRF99.getR22_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR22_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R22cell7 = R22row.getCell(12);
	       	 if (R22cell7 != null) {
	            R22cell7.setCellValue(BRF99.getR22_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR22_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R23////////////////
			  
			  Row R23row = sheet.getRow(37);
	           
	       
	       	 Cell R23cell = R23row.getCell(3);
	       	 if (R23cell != null) {
	            R23cell.setCellValue(BRF99.getR23_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR23_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R23cell1 = R23row.getCell(4);
	       	 if (R23cell1 != null) {
	            R23cell1.setCellValue(BRF99.getR23_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR23_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R23cell2 = R23row.getCell(5);
	       	 if (R23cell2 != null) {
	            R23cell2.setCellValue(BRF99.getR23_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR23_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R23cell3 = R23row.getCell(6);
	       	 if (R23cell3 != null) {
	            R23cell3.setCellValue(BRF99.getR23_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR23_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R23cell4 = R23row.getCell(9);
	       	 if (R23cell4 != null) {
	            R23cell4.setCellValue(BRF99.getR23_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR23_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R23cell5 = R23row.getCell(10);
	       	 if (R23cell5 != null) {
	            R23cell5.setCellValue(BRF99.getR23_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR23_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R23cell6 = R23row.getCell(11);
	       	 if (R23cell6 != null) {
	            R23cell6.setCellValue(BRF99.getR23_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR23_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R23cell7 = R23row.getCell(12);
	       	 if (R23cell7 != null) {
	            R23cell7.setCellValue(BRF99.getR23_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR23_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R24////////////////
			  
			  Row R24row = sheet.getRow(38);
	           
	       
	       	 Cell R24cell = R24row.getCell(3);
	       	 if (R24cell != null) {
	            R24cell.setCellValue(BRF99.getR24_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR24_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R24cell1 = R24row.getCell(4);
	       	 if (R24cell1 != null) {
	            R24cell1.setCellValue(BRF99.getR24_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR24_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R24cell2 = R24row.getCell(5);
	       	 if (R24cell2 != null) {
	            R24cell2.setCellValue(BRF99.getR24_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR24_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R24cell3 = R24row.getCell(6);
	       	 if (R24cell3 != null) {
	            R24cell3.setCellValue(BRF99.getR24_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR24_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R24cell4 = R24row.getCell(9);
	       	 if (R24cell4 != null) {
	            R24cell4.setCellValue(BRF99.getR24_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR24_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R24cell5 = R24row.getCell(10);
	       	 if (R24cell5 != null) {
	            R24cell5.setCellValue(BRF99.getR24_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR24_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R24cell6 = R24row.getCell(11);
	       	 if (R24cell6 != null) {
	            R24cell6.setCellValue(BRF99.getR24_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR24_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R24cell7 = R24row.getCell(12);
	       	 if (R24cell7 != null) {
	            R24cell7.setCellValue(BRF99.getR24_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR24_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R25////////////////
			  
			  Row R25row = sheet.getRow(39);
	           
	       
	       	 Cell R25cell = R25row.getCell(3);
	       	 if (R25cell != null) {
	            R25cell.setCellValue(BRF99.getR25_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR25_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R25cell1 = R25row.getCell(4);
	       	 if (R25cell1 != null) {
	            R25cell1.setCellValue(BRF99.getR25_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR25_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R25cell2 = R25row.getCell(5);
	       	 if (R25cell2 != null) {
	            R25cell2.setCellValue(BRF99.getR25_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR25_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R25cell3 = R25row.getCell(6);
	       	 if (R25cell3 != null) {
	            R25cell3.setCellValue(BRF99.getR25_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR25_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R25cell4 = R25row.getCell(9);
	       	 if (R25cell4 != null) {
	            R25cell4.setCellValue(BRF99.getR25_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR25_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R25cell5 = R25row.getCell(10);
	       	 if (R25cell5 != null) {
	            R25cell5.setCellValue(BRF99.getR25_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR25_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R25cell6 = R25row.getCell(11);
	       	 if (R25cell6 != null) {
	            R25cell6.setCellValue(BRF99.getR25_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR25_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R25cell7 = R25row.getCell(12);
	       	 if (R25cell7 != null) {
	            R25cell7.setCellValue(BRF99.getR25_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR25_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R26////////////////
			  
			  Row R26row = sheet.getRow(40);
	           
	       
	       	 Cell R26cell = R26row.getCell(3);
	       	 if (R26cell != null) {
	            R26cell.setCellValue(BRF99.getR26_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR26_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R26cell1 = R26row.getCell(4);
	       	 if (R26cell1 != null) {
	            R26cell1.setCellValue(BRF99.getR26_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR26_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R26cell2 = R26row.getCell(5);
	       	 if (R26cell2 != null) {
	            R26cell2.setCellValue(BRF99.getR26_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR26_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R26cell3 = R26row.getCell(6);
	       	 if (R26cell3 != null) {
	            R26cell3.setCellValue(BRF99.getR26_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR26_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R26cell4 = R26row.getCell(9);
	       	 if (R26cell4 != null) {
	            R26cell4.setCellValue(BRF99.getR26_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR26_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R26cell5 = R26row.getCell(10);
	       	 if (R26cell5 != null) {
	            R26cell5.setCellValue(BRF99.getR26_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR26_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R26cell6 = R26row.getCell(11);
	       	 if (R26cell6 != null) {
	            R26cell6.setCellValue(BRF99.getR26_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR26_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R26cell7 = R26row.getCell(12);
	       	 if (R26cell7 != null) {
	            R26cell7.setCellValue(BRF99.getR26_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR26_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R27////////////////
			  
			  Row R27row = sheet.getRow(41);
	           
	       
	       	 Cell R27cell = R27row.getCell(3);
	       	 if (R27cell != null) {
	            R27cell.setCellValue(BRF99.getR27_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR27_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R27cell1 = R27row.getCell(4);
	       	 if (R27cell1 != null) {
	            R27cell1.setCellValue(BRF99.getR27_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR27_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R27cell2 = R27row.getCell(5);
	       	 if (R27cell2 != null) {
	            R27cell2.setCellValue(BRF99.getR27_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR27_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R27cell3 = R27row.getCell(6);
	       	 if (R27cell3 != null) {
	            R27cell3.setCellValue(BRF99.getR27_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR27_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R27cell4 = R27row.getCell(9);
	       	 if (R27cell4 != null) {
	            R27cell4.setCellValue(BRF99.getR27_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR27_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R27cell5 = R27row.getCell(10);
	       	 if (R27cell5 != null) {
	            R27cell5.setCellValue(BRF99.getR27_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR27_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R27cell6 = R27row.getCell(11);
	       	 if (R27cell6 != null) {
	            R27cell6.setCellValue(BRF99.getR27_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR27_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R27cell7 = R27row.getCell(12);
	       	 if (R27cell7 != null) {
	            R27cell7.setCellValue(BRF99.getR27_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR27_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R28////////////////
			  
			  Row R28row = sheet.getRow(42);
	           
	       
	       	 Cell R28cell = R28row.getCell(3);
	       	 if (R28cell != null) {
	            R28cell.setCellValue(BRF99.getR28_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR28_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R28cell1 = R28row.getCell(4);
	       	 if (R28cell1 != null) {
	            R28cell1.setCellValue(BRF99.getR28_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR28_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R28cell2 = R28row.getCell(5);
	       	 if (R28cell2 != null) {
	            R28cell2.setCellValue(BRF99.getR28_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR28_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R28cell3 = R28row.getCell(6);
	       	 if (R28cell3 != null) {
	            R28cell3.setCellValue(BRF99.getR28_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR28_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R28cell4 = R28row.getCell(9);
	       	 if (R28cell4 != null) {
	            R28cell4.setCellValue(BRF99.getR28_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR28_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R28cell5 = R28row.getCell(10);
	       	 if (R28cell5 != null) {
	            R28cell5.setCellValue(BRF99.getR28_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR28_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R28cell6 = R28row.getCell(11);
	       	 if (R28cell6 != null) {
	            R28cell6.setCellValue(BRF99.getR28_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR28_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R28cell7 = R28row.getCell(12);
	       	 if (R28cell7 != null) {
	            R28cell7.setCellValue(BRF99.getR28_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR28_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R29////////////////
			  
			  Row R29row = sheet.getRow(43);
	           
	       
	       	 Cell R29cell = R29row.getCell(3);
	       	 if (R29cell != null) {
	            R29cell.setCellValue(BRF99.getR29_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR29_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R29cell1 = R29row.getCell(4);
	       	 if (R29cell1 != null) {
	            R29cell1.setCellValue(BRF99.getR29_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR29_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R29cell2 = R29row.getCell(5);
	       	 if (R29cell2 != null) {
	            R29cell2.setCellValue(BRF99.getR29_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR29_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R29cell3 = R29row.getCell(6);
	       	 if (R29cell3 != null) {
	            R29cell3.setCellValue(BRF99.getR29_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR29_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R29cell4 = R29row.getCell(9);
	       	 if (R29cell4 != null) {
	            R29cell4.setCellValue(BRF99.getR29_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR29_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R29cell5 = R29row.getCell(10);
	       	 if (R29cell5 != null) {
	            R29cell5.setCellValue(BRF99.getR29_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR29_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R29cell6 = R29row.getCell(11);
	       	 if (R29cell6 != null) {
	            R29cell6.setCellValue(BRF99.getR29_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR29_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R29cell7 = R29row.getCell(12);
	       	 if (R29cell7 != null) {
	            R29cell7.setCellValue(BRF99.getR29_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR29_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R30////////////////
			  
			  Row R30row = sheet.getRow(44);
	           
	       
	       	 Cell R30cell = R30row.getCell(3);
	       	 if (R30cell != null) {
	            R30cell.setCellValue(BRF99.getR30_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR30_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R30cell1 = R30row.getCell(4);
	       	 if (R30cell1 != null) {
	            R30cell1.setCellValue(BRF99.getR30_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR30_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R30cell2 = R30row.getCell(5);
	       	 if (R30cell2 != null) {
	            R30cell2.setCellValue(BRF99.getR30_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR30_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R30cell3 = R30row.getCell(6);
	       	 if (R30cell3 != null) {
	            R30cell3.setCellValue(BRF99.getR30_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR30_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R30cell4 = R30row.getCell(9);
	       	 if (R30cell4 != null) {
	            R30cell4.setCellValue(BRF99.getR30_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR30_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R30cell5 = R30row.getCell(10);
	       	 if (R30cell5 != null) {
	            R30cell5.setCellValue(BRF99.getR30_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR30_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R30cell6 = R30row.getCell(11);
	       	 if (R30cell6 != null) {
	            R30cell6.setCellValue(BRF99.getR30_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR30_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R30cell7 = R30row.getCell(12);
	       	 if (R30cell7 != null) {
	            R30cell7.setCellValue(BRF99.getR30_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR30_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R31////////////////
			  
			  Row R31row = sheet.getRow(45);
	           
	       
	       	 Cell R31cell = R31row.getCell(3);
	       	 if (R31cell != null) {
	            R31cell.setCellValue(BRF99.getR31_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR31_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R31cell1 = R31row.getCell(4);
	       	 if (R31cell1 != null) {
	            R31cell1.setCellValue(BRF99.getR31_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR31_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R31cell2 = R31row.getCell(5);
	       	 if (R31cell2 != null) {
	            R31cell2.setCellValue(BRF99.getR31_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR31_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R31cell3 = R31row.getCell(6);
	       	 if (R31cell3 != null) {
	            R31cell3.setCellValue(BRF99.getR31_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR31_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R31cell4 = R31row.getCell(9);
	       	 if (R31cell4 != null) {
	            R31cell4.setCellValue(BRF99.getR31_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR31_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R31cell5 = R31row.getCell(10);
	       	 if (R31cell5 != null) {
	            R31cell5.setCellValue(BRF99.getR31_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR31_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R31cell6 = R31row.getCell(11);
	       	 if (R31cell6 != null) {
	            R31cell6.setCellValue(BRF99.getR31_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR31_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R31cell7 = R31row.getCell(12);
	       	 if (R31cell7 != null) {
	            R31cell7.setCellValue(BRF99.getR31_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR31_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R32////////////////
			  
			  Row R32row = sheet.getRow(46);
	           
	       
	       	 Cell R32cell = R32row.getCell(3);
	       	 if (R32cell != null) {
	            R32cell.setCellValue(BRF99.getR32_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR32_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R32cell1 = R32row.getCell(4);
	       	 if (R32cell1 != null) {
	            R32cell1.setCellValue(BRF99.getR32_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR32_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R32cell2 = R32row.getCell(5);
	       	 if (R32cell2 != null) {
	            R32cell2.setCellValue(BRF99.getR32_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR32_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R32cell3 = R32row.getCell(6);
	       	 if (R32cell3 != null) {
	            R32cell3.setCellValue(BRF99.getR32_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR32_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R32cell4 = R32row.getCell(9);
	       	 if (R32cell4 != null) {
	            R32cell4.setCellValue(BRF99.getR32_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR32_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R32cell5 = R32row.getCell(10);
	       	 if (R32cell5 != null) {
	            R32cell5.setCellValue(BRF99.getR32_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR32_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R32cell6 = R32row.getCell(11);
	       	 if (R32cell6 != null) {
	            R32cell6.setCellValue(BRF99.getR32_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR32_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R32cell7 = R32row.getCell(12);
	       	 if (R32cell7 != null) {
	            R32cell7.setCellValue(BRF99.getR32_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR32_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
             ///////////////////////R33////////////////
			  
			  Row R33row = sheet.getRow(47);
	           
	       
	       	 Cell R33cell = R33row.getCell(3);
	       	 if (R33cell != null) {
	            R33cell.setCellValue(BRF99.getR33_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR33_NUMBER_OF_ACCCOUNTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	 Cell R33cell1 = R33row.getCell(4);
	       	 if (R33cell1 != null) {
	            R33cell1.setCellValue(BRF99.getR33_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR33_VALUE_OF_COMMITMENTS_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R33cell2 = R33row.getCell(5);
	       	 if (R33cell2 != null) {
	            R33cell2.setCellValue(BRF99.getR33_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR33_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	
	       	 
	     	Cell R33cell3 = R33row.getCell(6);
	       	 if (R33cell3 != null) {
	            R33cell3.setCellValue(BRF99.getR33_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED() == null ? 0 :
	       	     	BRF99.getR33_VALUE_OF_COMMITMENTS_NON_NATIONAL_COMPLETED().intValue());
	       	 }
	       	 
	       	Cell R33cell4 = R33row.getCell(9);
	       	 if (R33cell4 != null) {
	            R33cell4.setCellValue(BRF99.getR33_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR33_NUMBER_OF_ACCCOUNTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	     	Cell R33cell5 = R33row.getCell(10);
	       	 if (R33cell5 != null) {
	            R33cell5.setCellValue(BRF99.getR33_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR33_VALUE_OF_COMMITMENTS_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	Cell R33cell6 = R33row.getCell(11);
	       	 if (R33cell6 != null) {
	            R33cell6.setCellValue(BRF99.getR33_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR33_NUMBER_OF_ACCCOUNTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	       	 
	       	Cell R33cell7 = R33row.getCell(12);
	       	 if (R33cell7 != null) {
	            R33cell7.setCellValue(BRF99.getR33_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES() == null ? 0 :
	       	     	BRF99.getR33_VALUE_OF_COMMITMENTS_NON_NATIONAL_PROPERTIES().intValue());
	       	 }
	       	 
	         // Save the changes
	            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-100-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-100-A.xls");

		return outputFile;
	
	
	
	}
	       	 
	
	public ModelAndView getBRF100currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF100_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");
 
				qr.setParameter(2, filter);
 
			} else {
				qr = hs.createNativeQuery("select * from BRF100_DETAILTABLE a where report_date = ?1");
 
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF100_DETAILTABLE  where report_date = ?1");
		}
 
		try {
			qr.setParameter(1, df.parse(todate));
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF100_DETAIL_ENTITY> T1Master = new ArrayList<BRF100_DETAIL_ENTITY>();
 
		try {
			T1Master = hs.createQuery("from BRF100_DETAIL_ENTITY a where a.report_date = ?1", BRF100_DETAIL_ENTITY.class)
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

			BRF100_DETAIL_ENTITY py = new BRF100_DETAIL_ENTITY( acct_crncy_code,  acct_name,  acid,  act_balance_amt_lc,
					 bacid,  constitution_code,  constitution_desc,  country,  country_of_incorp,
					 create_time,  create_user,  cust_id,  cust_type,  del_flg,  eab_lc,
					 entity_flg,  foracid,  gender,  gl_code,  gl_sub_head_code,
					 gl_sub_head_desc,  group_id,  hni_networth,  legal_entity_type,
					 maturity_date,  modify_flg,  modify_time,  modify_user,  nre_flg,
					 nre_status,  purpose_of_advn,  remarks,  report_addl_criteria_1,
					 report_addl_criteria_2,  report_addl_criteria_3,  report_date,  report_label_1,
					 report_name_1,  schm_code,  schm_type,  sector,  sector_code,  segment,
					 sol_id,  sub_sector,  sub_segment,  turnover,  verify_time,  verify_user,
					 version);
			
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

		mv.setViewName("RR" + "/" + "BRF100::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	

	
	public String detailChanges100(BRF100_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF100_DETAIL_ENTITY> Brf100detail = brf100_DetailRep.findById(foracid);

			if (Brf100detail.isPresent()) {
				BRF100_DETAIL_ENTITY BRFdetail = Brf100detail.get();

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
					brf100_DetailRep.save(BRFdetail);

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

	
	
	
	
	
	
	
	
	
	
	
	public ModelAndView ARCHgetBRF100currentDtl(String reportId, String fromdate, String todate, String currency,
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
				
				
					qr = hs.createNativeQuery("select * from BRF100_ARCHIVETABLE a where report_date=?1 and report_label_1=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF100_ARCHIVETABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF100_ARCHIVETABLE  where report_date = ?1");
		}

		List<BRF100_ARCHIV_ENTITY> T1Master = new ArrayList<BRF100_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF100_ARCHIV_ENTITY a where a.report_date = ?1", BRF100_ARCHIV_ENTITY.class)
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

			
			
			BRF100_ARCHIV_ENTITY py = new BRF100_ARCHIV_ENTITY(acct_crncy_code,  acct_name,  acid,  act_balance_amt_lc,
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
		mv.setViewName("RR" + "/" + "BRF100ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
		}

	public ModelAndView getArchieveBRF100View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_100_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_100_A_REPORT_ENTITY>();


		List<BRF_100_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_100_A_REPORT_ENTITY>();


		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);


			T1Master = hs.createQuery("from BRF_100_A_REPORT_ENTITY a where a.report_date = ?1 ", BRF_100_A_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();



		} catch (ParseException e) {
			e.printStackTrace();
		}
		mv.setViewName("RR/BRF100ARCH");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

		
	
		

	}

			
		

	
	
	


