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

import com.bornfire.xbrl.entities.BRBS.BRF205_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF205_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF205_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
import com.bornfire.xbrl.entities.BRBS.BRF003_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF204_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF205A_A1_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF205A_A2_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF205_DetailRep;
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
public class BRF205AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF205AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF205_DetailRep brf205_DetailRep;
	
	
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
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF205A_A1_RPT a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF205A_A1_RPT a").getSingleResult();
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


	public ModelAndView getBRF205AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF205A_A1_RPT> T1rep = new ArrayList<BRF205A_A1_RPT>();
			// Query<Object[]> qr;

			List<BRF205A_A1_RPT> T1Master = new ArrayList<BRF205A_A1_RPT>();
			List<BRF205A_A2_RPT> T1Master1 = new ArrayList<BRF205A_A2_RPT>();

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from BRF205A_A1_RPT a where a.report_date = ?1 ", BRF205A_A1_RPT.class)
						.setParameter(1, df.parse(todate)).getResultList();

				T1Master1 = hs.createQuery("from BRF205A_A2_RPT a where a.report_date = ?1 ", BRF205A_A2_RPT.class)
						.setParameter(1, df.parse(todate)).getResultList();

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF205");
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
	
	
	
	public File getFileBRF205A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-205-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF205_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF205_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF205A.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF205A.jrxml");
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
			List<BRF205A_A1_RPT> T1Master = new ArrayList<>();
			List<BRF205A_A2_RPT> T1Master1 = new ArrayList<>();

			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);

				T1Master = hs.createQuery("from BRF205A_A1_RPT a where a.report_date = ?1", BRF205A_A1_RPT.class)
						.setParameter(1, df.parse(todate)).getResultList();
				T1Master1 = hs.createQuery("from BRF205A_A2_RPT a where a.report_date = ?1", BRF205A_A2_RPT.class)
						.setParameter(1, df.parse(todate)).getResultList();

				File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-205-AT.xls");
				Workbook workbook = WorkbookFactory.create(responseCamt);
				
				Sheet sheet = workbook.getSheetAt(0);
				
				if (T1Master.size() == 1) {
					for (BRF205A_A1_RPT BRF205A : T1Master) {
						Row row = sheet.getRow(11);
			            
				       	 Cell cell = row.getCell(4);
				       	 if (cell != null) {
				            cell.setCellValue(BRF205A.getR2_gcc_ksa_aed() == null ? 0 :
				            	BRF205A.getR2_gcc_ksa_aed().intValue());
				       	 }	
						
				       	Cell cell1 = row.getCell(5);
				       	 if (cell1 != null) {
				            cell1.setCellValue(BRF205A.getR2_gcc_ksa_fcy() == null ? 0 :
				            	BRF205A.getR2_gcc_ksa_fcy().intValue());
				       	 }	
						
				       	Cell cell2 = row.getCell(6);
				       	 if (cell2 != null) {
				            cell2.setCellValue(BRF205A.getR2_gcc_oman_aed() == null ? 0 :
				            	BRF205A.getR2_gcc_oman_aed().intValue());
				       	 }	
						
				       	Cell cell3 = row.getCell(7);
				       	 if (cell3 != null) {
				            cell3.setCellValue(BRF205A.getR2_gcc_oman_fcy() == null ? 0 :
				            	BRF205A.getR2_gcc_oman_fcy().intValue());
				       	 }	
						
				       	Cell cell4 = row.getCell(8);
				       	 if (cell4 != null) {
				            cell4.setCellValue(BRF205A.getR2_gcc_kuwait_aed() == null ? 0 :
				            	BRF205A.getR2_gcc_kuwait_aed().intValue());
				       	 }	
						
				       	Cell cell5 = row.getCell(9);
				       	 if (cell5 != null) {
				            cell5.setCellValue(BRF205A.getR2_gcc_kuwait_fcy() == null ? 0 :
				            	BRF205A.getR2_gcc_kuwait_fcy().intValue());
				       	 }	
						
				       	Cell cell6 = row.getCell(10);
				       	 if (cell6 != null) {
				            cell6.setCellValue(BRF205A.getR2_gcc_qatar_aed() == null ? 0 :
				            	BRF205A.getR2_gcc_qatar_aed().intValue());
				       	 }	
						
				       	Cell cell7 = row.getCell(11);
				       	 if (cell7 != null) {
				            cell7.setCellValue(BRF205A.getR2_gcc_qatar_fcy() == null ? 0 :
				            	BRF205A.getR2_gcc_qatar_fcy().intValue());
				       	 }	
						
				       	Cell cell8 = row.getCell(12);
				       	 if (cell8 != null) {
				            cell8.setCellValue(BRF205A.getR2_gcc_bahrain_aed() == null ? 0 :
				            	BRF205A.getR2_gcc_bahrain_aed().intValue());
				       	 }	
						
				       	Cell cell9 = row.getCell(13);
				       	 if (cell9 != null) {
				            cell9.setCellValue(BRF205A.getR2_gcc_bahrain_fcy() == null ? 0 :
				            	BRF205A.getR2_gcc_bahrain_fcy().intValue());
				       	 }	
						
				       	Cell cell10 = row.getCell(14);
				       	 if (cell10 != null) {
				            cell10.setCellValue(BRF205A.getR2_other_aed() == null ? 0 :
				            	BRF205A.getR2_other_aed().intValue());
				       	 }	
						
				       	Cell cell11 = row.getCell(15);
				       	 if (cell11 != null) {
				            cell11.setCellValue(BRF205A.getR2_other_fcy() == null ? 0 :
				            	BRF205A.getR2_other_fcy().intValue());
				       	 }	
						
				   	  /////////////////////R3//////////////////
				   	  
				   	  Row R3row = sheet.getRow(12);
				   			            
				   		 Cell R3cell = R3row.getCell(4);
				   		 if (R3cell != null) {
				   	     R3cell.setCellValue(BRF205A.getR3_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR3_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R3cell1 = R3row.getCell(5);
				   		 if (R3cell1 != null) {
				   	     R3cell1.setCellValue(BRF205A.getR3_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR3_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R3cell2 = R3row.getCell(6);
				   		 if (R3cell2 != null) {
				   	     R3cell2.setCellValue(BRF205A.getR3_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR3_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R3cell3 = R3row.getCell(7);
				   		 if (R3cell3 != null) {
				   	     R3cell3.setCellValue(BRF205A.getR3_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR3_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R3cell4 = R3row.getCell(8);
				   		 if (R3cell4 != null) {
				   	     R3cell4.setCellValue(BRF205A.getR3_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR3_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R3cell5 = R3row.getCell(9);
				   		 if (R3cell5 != null) {
				   	     R3cell5.setCellValue(BRF205A.getR3_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR3_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R3cell6 = R3row.getCell(10);
				   		 if (R3cell6 != null) {
				   	     R3cell6.setCellValue(BRF205A.getR3_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR3_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R3cell7 = R3row.getCell(11);
				   		 if (R3cell7 != null) {
				   	     R3cell7.setCellValue(BRF205A.getR3_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR3_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R3cell8 = R3row.getCell(12);
				   		 if (R3cell8 != null) {
				   	     R3cell8.setCellValue(BRF205A.getR3_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR3_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R3cell9 = R3row.getCell(13);
				   		 if (R3cell9 != null) {
				   	     R3cell9.setCellValue(BRF205A.getR3_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR3_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R3cell10 = R3row.getCell(14);
				   		 if (R3cell10 != null) {
				   	     R3cell10.setCellValue(BRF205A.getR3_other_aed() == null ? 0 :
				   	     	BRF205A.getR3_other_aed().intValue());
				   		 }	
				   	
				   		Cell R3cell11 = R3row.getCell(15);
				   		 if (R3cell11 != null) {
				   	     R3cell11.setCellValue(BRF205A.getR3_other_fcy() == null ? 0 :
				   	     	BRF205A.getR3_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R4//////////////////
				   	  
				   	  Row R4row = sheet.getRow(13);
				   			            
				   		 Cell R4cell = R4row.getCell(4);
				   		 if (R4cell != null) {
				   	     R4cell.setCellValue(BRF205A.getR4_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR4_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R4cell1 = R4row.getCell(5);
				   		 if (R4cell1 != null) {
				   	     R4cell1.setCellValue(BRF205A.getR4_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR4_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R4cell2 = R4row.getCell(6);
				   		 if (R4cell2 != null) {
				   	     R4cell2.setCellValue(BRF205A.getR4_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR4_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R4cell3 = R4row.getCell(7);
				   		 if (R4cell3 != null) {
				   	     R4cell3.setCellValue(BRF205A.getR4_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR4_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R4cell4 = R4row.getCell(8);
				   		 if (R4cell4 != null) {
				   	     R4cell4.setCellValue(BRF205A.getR4_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR4_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R4cell5 = R4row.getCell(9);
				   		 if (R4cell5 != null) {
				   	     R4cell5.setCellValue(BRF205A.getR4_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR4_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R4cell6 = R4row.getCell(10);
				   		 if (R4cell6 != null) {
				   	     R4cell6.setCellValue(BRF205A.getR4_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR4_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R4cell7 = R4row.getCell(11);
				   		 if (R4cell7 != null) {
				   	     R4cell7.setCellValue(BRF205A.getR4_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR4_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R4cell8 = R4row.getCell(12);
				   		 if (R4cell8 != null) {
				   	     R4cell8.setCellValue(BRF205A.getR4_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR4_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R4cell9 = R4row.getCell(13);
				   		 if (R4cell9 != null) {
				   	     R4cell9.setCellValue(BRF205A.getR4_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR4_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R4cell10 = R4row.getCell(14);
				   		 if (R4cell10 != null) {
				   	     R4cell10.setCellValue(BRF205A.getR4_other_aed() == null ? 0 :
				   	     	BRF205A.getR4_other_aed().intValue());
				   		 }	
				   	
				   		Cell R4cell11 = R4row.getCell(15);
				   		 if (R4cell11 != null) {
				   	     R4cell11.setCellValue(BRF205A.getR4_other_fcy() == null ? 0 :
				   	     	BRF205A.getR4_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R5//////////////////
				   	  
				   	  Row R5row = sheet.getRow(14);
				   			            
				   		 Cell R5cell = R5row.getCell(4);
				   		 if (R5cell != null) {
				   	     R5cell.setCellValue(BRF205A.getR5_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR5_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R5cell1 = R5row.getCell(5);
				   		 if (R5cell1 != null) {
				   	     R5cell1.setCellValue(BRF205A.getR5_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR5_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R5cell2 = R5row.getCell(6);
				   		 if (R5cell2 != null) {
				   	     R5cell2.setCellValue(BRF205A.getR5_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR5_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R5cell3 = R5row.getCell(7);
				   		 if (R5cell3 != null) {
				   	     R5cell3.setCellValue(BRF205A.getR5_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR5_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R5cell4 = R5row.getCell(8);
				   		 if (R5cell4 != null) {
				   	     R5cell4.setCellValue(BRF205A.getR5_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR5_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R5cell5 = R5row.getCell(9);
				   		 if (R5cell5 != null) {
				   	     R5cell5.setCellValue(BRF205A.getR5_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR5_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R5cell6 = R5row.getCell(10);
				   		 if (R5cell6 != null) {
				   	     R5cell6.setCellValue(BRF205A.getR5_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR5_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R5cell7 = R5row.getCell(11);
				   		 if (R5cell7 != null) {
				   	     R5cell7.setCellValue(BRF205A.getR5_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR5_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R5cell8 = R5row.getCell(12);
				   		 if (R5cell8 != null) {
				   	     R5cell8.setCellValue(BRF205A.getR5_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR5_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R5cell9 = R5row.getCell(13);
				   		 if (R5cell9 != null) {
				   	     R5cell9.setCellValue(BRF205A.getR5_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR5_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R5cell10 = R5row.getCell(14);
				   		 if (R5cell10 != null) {
				   	     R5cell10.setCellValue(BRF205A.getR5_other_aed() == null ? 0 :
				   	     	BRF205A.getR5_other_aed().intValue());
				   		 }	
				   	
				   		Cell R5cell11 = R5row.getCell(15);
				   		 if (R5cell11 != null) {
				   	     R5cell11.setCellValue(BRF205A.getR5_other_fcy() == null ? 0 :
				   	     	BRF205A.getR5_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R7//////////////////
				   	  
				   	  Row R7row = sheet.getRow(16);
				   			            
				   		 Cell R7cell = R7row.getCell(4);
				   		 if (R7cell != null) {
				   	     R7cell.setCellValue(BRF205A.getR7_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR7_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R7cell1 = R7row.getCell(5);
				   		 if (R7cell1 != null) {
				   	     R7cell1.setCellValue(BRF205A.getR7_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR7_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R7cell2 = R7row.getCell(6);
				   		 if (R7cell2 != null) {
				   	     R7cell2.setCellValue(BRF205A.getR7_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR7_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R7cell3 = R7row.getCell(7);
				   		 if (R7cell3 != null) {
				   	     R7cell3.setCellValue(BRF205A.getR7_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR7_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R7cell4 = R7row.getCell(8);
				   		 if (R7cell4 != null) {
				   	     R7cell4.setCellValue(BRF205A.getR7_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR7_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R7cell5 = R7row.getCell(9);
				   		 if (R7cell5 != null) {
				   	     R7cell5.setCellValue(BRF205A.getR7_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR7_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R7cell6 = R7row.getCell(10);
				   		 if (R7cell6 != null) {
				   	     R7cell6.setCellValue(BRF205A.getR7_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR7_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R7cell7 = R7row.getCell(11);
				   		 if (R7cell7 != null) {
				   	     R7cell7.setCellValue(BRF205A.getR7_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR7_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R7cell8 = R7row.getCell(12);
				   		 if (R7cell8 != null) {
				   	     R7cell8.setCellValue(BRF205A.getR7_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR7_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R7cell9 = R7row.getCell(13);
				   		 if (R7cell9 != null) {
				   	     R7cell9.setCellValue(BRF205A.getR7_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR7_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R7cell10 = R7row.getCell(14);
				   		 if (R7cell10 != null) {
				   	     R7cell10.setCellValue(BRF205A.getR7_other_aed() == null ? 0 :
				   	     	BRF205A.getR7_other_aed().intValue());
				   		 }	
				   	
				   		Cell R7cell11 = R7row.getCell(15);
				   		 if (R7cell11 != null) {
				   	     R7cell11.setCellValue(BRF205A.getR7_other_fcy() == null ? 0 :
				   	     	BRF205A.getR7_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R8//////////////////
				   	  
				   	  Row R8row = sheet.getRow(17);
				   			            
				   		 Cell R8cell = R8row.getCell(4);
				   		 if (R8cell != null) {
				   	     R8cell.setCellValue(BRF205A.getR8_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR8_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R8cell1 = R8row.getCell(5);
				   		 if (R8cell1 != null) {
				   	     R8cell1.setCellValue(BRF205A.getR8_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR8_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R8cell2 = R8row.getCell(6);
				   		 if (R8cell2 != null) {
				   	     R8cell2.setCellValue(BRF205A.getR8_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR8_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R8cell3 = R8row.getCell(7);
				   		 if (R8cell3 != null) {
				   	     R8cell3.setCellValue(BRF205A.getR8_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR8_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R8cell4 = R8row.getCell(8);
				   		 if (R8cell4 != null) {
				   	     R8cell4.setCellValue(BRF205A.getR8_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR8_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R8cell5 = R8row.getCell(9);
				   		 if (R8cell5 != null) {
				   	     R8cell5.setCellValue(BRF205A.getR8_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR8_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R8cell6 = R8row.getCell(10);
				   		 if (R8cell6 != null) {
				   	     R8cell6.setCellValue(BRF205A.getR8_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR8_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R8cell7 = R8row.getCell(11);
				   		 if (R8cell7 != null) {
				   	     R8cell7.setCellValue(BRF205A.getR8_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR8_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R8cell8 = R8row.getCell(12);
				   		 if (R8cell8 != null) {
				   	     R8cell8.setCellValue(BRF205A.getR8_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR8_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R8cell9 = R8row.getCell(13);
				   		 if (R8cell9 != null) {
				   	     R8cell9.setCellValue(BRF205A.getR8_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR8_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R8cell10 = R8row.getCell(14);
				   		 if (R8cell10 != null) {
				   	     R8cell10.setCellValue(BRF205A.getR8_other_aed() == null ? 0 :
				   	     	BRF205A.getR8_other_aed().intValue());
				   		 }	
				   	
				   		Cell R8cell11 = R8row.getCell(15);
				   		 if (R8cell11 != null) {
				   	     R8cell11.setCellValue(BRF205A.getR8_other_fcy() == null ? 0 :
				   	     	BRF205A.getR8_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R9//////////////////
				   	  
				   	  Row R9row = sheet.getRow(18);
				   			            
				   		 Cell R9cell = R9row.getCell(4);
				   		 if (R9cell != null) {
				   	     R9cell.setCellValue(BRF205A.getR9_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR9_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R9cell1 = R9row.getCell(5);
				   		 if (R9cell1 != null) {
				   	     R9cell1.setCellValue(BRF205A.getR9_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR9_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R9cell2 = R9row.getCell(6);
				   		 if (R9cell2 != null) {
				   	     R9cell2.setCellValue(BRF205A.getR9_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR9_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R9cell3 = R9row.getCell(7);
				   		 if (R9cell3 != null) {
				   	     R9cell3.setCellValue(BRF205A.getR9_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR9_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R9cell4 = R9row.getCell(8);
				   		 if (R9cell4 != null) {
				   	     R9cell4.setCellValue(BRF205A.getR9_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR9_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R9cell5 = R9row.getCell(9);
				   		 if (R9cell5 != null) {
				   	     R9cell5.setCellValue(BRF205A.getR9_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR9_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R9cell6 = R9row.getCell(10);
				   		 if (R9cell6 != null) {
				   	     R9cell6.setCellValue(BRF205A.getR9_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR9_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R9cell7 = R9row.getCell(11);
				   		 if (R9cell7 != null) {
				   	     R9cell7.setCellValue(BRF205A.getR9_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR9_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R9cell8 = R9row.getCell(12);
				   		 if (R9cell8 != null) {
				   	     R9cell8.setCellValue(BRF205A.getR9_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR9_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R9cell9 = R9row.getCell(13);
				   		 if (R9cell9 != null) {
				   	     R9cell9.setCellValue(BRF205A.getR9_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR9_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R9cell10 = R9row.getCell(14);
				   		 if (R9cell10 != null) {
				   	     R9cell10.setCellValue(BRF205A.getR9_other_aed() == null ? 0 :
				   	     	BRF205A.getR9_other_aed().intValue());
				   		 }	
				   	
				   		Cell R9cell11 = R9row.getCell(15);
				   		 if (R9cell11 != null) {
				   	     R9cell11.setCellValue(BRF205A.getR9_other_fcy() == null ? 0 :
				   	     	BRF205A.getR9_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R10//////////////////
				   	  
				   	  Row R10row = sheet.getRow(19);
				   			            
				   		 Cell R10cell = R10row.getCell(4);
				   		 if (R10cell != null) {
				   	     R10cell.setCellValue(BRF205A.getR10_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR10_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R10cell1 = R10row.getCell(5);
				   		 if (R10cell1 != null) {
				   	     R10cell1.setCellValue(BRF205A.getR10_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR10_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R10cell2 = R10row.getCell(6);
				   		 if (R10cell2 != null) {
				   	     R10cell2.setCellValue(BRF205A.getR10_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR10_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R10cell3 = R10row.getCell(7);
				   		 if (R10cell3 != null) {
				   	     R10cell3.setCellValue(BRF205A.getR10_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR10_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R10cell4 = R10row.getCell(8);
				   		 if (R10cell4 != null) {
				   	     R10cell4.setCellValue(BRF205A.getR10_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR10_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R10cell5 = R10row.getCell(9);
				   		 if (R10cell5 != null) {
				   	     R10cell5.setCellValue(BRF205A.getR10_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR10_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R10cell6 = R10row.getCell(10);
				   		 if (R10cell6 != null) {
				   	     R10cell6.setCellValue(BRF205A.getR10_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR10_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R10cell7 = R10row.getCell(11);
				   		 if (R10cell7 != null) {
				   	     R10cell7.setCellValue(BRF205A.getR10_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR10_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R10cell8 = R10row.getCell(12);
				   		 if (R10cell8 != null) {
				   	     R10cell8.setCellValue(BRF205A.getR10_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR10_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R10cell9 = R10row.getCell(13);
				   		 if (R10cell9 != null) {
				   	     R10cell9.setCellValue(BRF205A.getR10_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR10_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R10cell10 = R10row.getCell(14);
				   		 if (R10cell10 != null) {
				   	     R10cell10.setCellValue(BRF205A.getR10_other_aed() == null ? 0 :
				   	     	BRF205A.getR10_other_aed().intValue());
				   		 }	
				   	
				   		Cell R10cell11 = R10row.getCell(15);
				   		 if (R10cell11 != null) {
				   	     R10cell11.setCellValue(BRF205A.getR10_other_fcy() == null ? 0 :
				   	     	BRF205A.getR10_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R13//////////////////
				   	  
				   	  Row R13row = sheet.getRow(22);
				   			            
				   		 Cell R13cell = R13row.getCell(4);
				   		 if (R13cell != null) {
				   	     R13cell.setCellValue(BRF205A.getR13_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR13_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R13cell1 = R13row.getCell(5);
				   		 if (R13cell1 != null) {
				   	     R13cell1.setCellValue(BRF205A.getR13_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR13_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R13cell2 = R13row.getCell(6);
				   		 if (R13cell2 != null) {
				   	     R13cell2.setCellValue(BRF205A.getR13_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR13_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R13cell3 = R13row.getCell(7);
				   		 if (R13cell3 != null) {
				   	     R13cell3.setCellValue(BRF205A.getR13_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR13_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R13cell4 = R13row.getCell(8);
				   		 if (R13cell4 != null) {
				   	     R13cell4.setCellValue(BRF205A.getR13_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR13_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R13cell5 = R13row.getCell(9);
				   		 if (R13cell5 != null) {
				   	     R13cell5.setCellValue(BRF205A.getR13_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR13_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R13cell6 = R13row.getCell(10);
				   		 if (R13cell6 != null) {
				   	     R13cell6.setCellValue(BRF205A.getR13_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR13_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R13cell7 = R13row.getCell(11);
				   		 if (R13cell7 != null) {
				   	     R13cell7.setCellValue(BRF205A.getR13_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR13_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R13cell8 = R13row.getCell(12);
				   		 if (R13cell8 != null) {
				   	     R13cell8.setCellValue(BRF205A.getR13_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR13_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R13cell9 = R13row.getCell(13);
				   		 if (R13cell9 != null) {
				   	     R13cell9.setCellValue(BRF205A.getR13_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR13_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R13cell10 = R13row.getCell(14);
				   		 if (R13cell10 != null) {
				   	     R13cell10.setCellValue(BRF205A.getR13_other_aed() == null ? 0 :
				   	     	BRF205A.getR13_other_aed().intValue());
				   		 }	
				   	
				   		Cell R13cell11 = R13row.getCell(15);
				   		 if (R13cell11 != null) {
				   	     R13cell11.setCellValue(BRF205A.getR13_other_fcy() == null ? 0 :
				   	     	BRF205A.getR13_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R14//////////////////
				   	  
				   	  Row R14row = sheet.getRow(23);
				   			            
				   		 Cell R14cell = R14row.getCell(4);
				   		 if (R14cell != null) {
				   	     R14cell.setCellValue(BRF205A.getR14_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR14_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R14cell1 = R14row.getCell(5);
				   		 if (R14cell1 != null) {
				   	     R14cell1.setCellValue(BRF205A.getR14_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR14_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R14cell2 = R14row.getCell(6);
				   		 if (R14cell2 != null) {
				   	     R14cell2.setCellValue(BRF205A.getR14_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR14_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R14cell3 = R14row.getCell(7);
				   		 if (R14cell3 != null) {
				   	     R14cell3.setCellValue(BRF205A.getR14_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR14_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R14cell4 = R14row.getCell(8);
				   		 if (R14cell4 != null) {
				   	     R14cell4.setCellValue(BRF205A.getR14_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR14_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R14cell5 = R14row.getCell(9);
				   		 if (R14cell5 != null) {
				   	     R14cell5.setCellValue(BRF205A.getR14_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR14_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R14cell6 = R14row.getCell(10);
				   		 if (R14cell6 != null) {
				   	     R14cell6.setCellValue(BRF205A.getR14_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR14_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R14cell7 = R14row.getCell(11);
				   		 if (R14cell7 != null) {
				   	     R14cell7.setCellValue(BRF205A.getR14_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR14_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R14cell8 = R14row.getCell(12);
				   		 if (R14cell8 != null) {
				   	     R14cell8.setCellValue(BRF205A.getR14_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR14_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R14cell9 = R14row.getCell(13);
				   		 if (R14cell9 != null) {
				   	     R14cell9.setCellValue(BRF205A.getR14_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR14_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R14cell10 = R14row.getCell(14);
				   		 if (R14cell10 != null) {
				   	     R14cell10.setCellValue(BRF205A.getR14_other_aed() == null ? 0 :
				   	     	BRF205A.getR14_other_aed().intValue());
				   		 }	
				   	
				   		Cell R14cell11 = R14row.getCell(15);
				   		 if (R14cell11 != null) {
				   	     R14cell11.setCellValue(BRF205A.getR14_other_fcy() == null ? 0 :
				   	     	BRF205A.getR14_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R15//////////////////
				   	  
				   	  Row R15row = sheet.getRow(24);
				   			            
				   		 Cell R15cell = R15row.getCell(4);
				   		 if (R15cell != null) {
				   	     R15cell.setCellValue(BRF205A.getR15_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR15_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R15cell1 = R15row.getCell(5);
				   		 if (R15cell1 != null) {
				   	     R15cell1.setCellValue(BRF205A.getR15_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR15_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R15cell2 = R15row.getCell(6);
				   		 if (R15cell2 != null) {
				   	     R15cell2.setCellValue(BRF205A.getR15_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR15_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R15cell3 = R15row.getCell(7);
				   		 if (R15cell3 != null) {
				   	     R15cell3.setCellValue(BRF205A.getR15_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR15_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R15cell4 = R15row.getCell(8);
				   		 if (R15cell4 != null) {
				   	     R15cell4.setCellValue(BRF205A.getR15_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR15_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R15cell5 = R15row.getCell(9);
				   		 if (R15cell5 != null) {
				   	     R15cell5.setCellValue(BRF205A.getR15_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR15_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R15cell6 = R15row.getCell(10);
				   		 if (R15cell6 != null) {
				   	     R15cell6.setCellValue(BRF205A.getR15_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR15_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R15cell7 = R15row.getCell(11);
				   		 if (R15cell7 != null) {
				   	     R15cell7.setCellValue(BRF205A.getR15_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR15_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R15cell8 = R15row.getCell(12);
				   		 if (R15cell8 != null) {
				   	     R15cell8.setCellValue(BRF205A.getR15_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR15_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R15cell9 = R15row.getCell(13);
				   		 if (R15cell9 != null) {
				   	     R15cell9.setCellValue(BRF205A.getR15_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR15_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R15cell10 = R15row.getCell(14);
				   		 if (R15cell10 != null) {
				   	     R15cell10.setCellValue(BRF205A.getR15_other_aed() == null ? 0 :
				   	     	BRF205A.getR15_other_aed().intValue());
				   		 }	
				   	
				   		Cell R15cell11 = R15row.getCell(15);
				   		 if (R15cell11 != null) {
				   	     R15cell11.setCellValue(BRF205A.getR15_other_fcy() == null ? 0 :
				   	     	BRF205A.getR15_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R16//////////////////
				   	  
				   	  Row R16row = sheet.getRow(25);
				   			            
				   		 Cell R16cell = R16row.getCell(4);
				   		 if (R16cell != null) {
				   	     R16cell.setCellValue(BRF205A.getR16_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR16_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R16cell1 = R16row.getCell(5);
				   		 if (R16cell1 != null) {
				   	     R16cell1.setCellValue(BRF205A.getR16_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR16_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R16cell2 = R16row.getCell(6);
				   		 if (R16cell2 != null) {
				   	     R16cell2.setCellValue(BRF205A.getR16_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR16_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R16cell3 = R16row.getCell(7);
				   		 if (R16cell3 != null) {
				   	     R16cell3.setCellValue(BRF205A.getR16_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR16_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R16cell4 = R16row.getCell(8);
				   		 if (R16cell4 != null) {
				   	     R16cell4.setCellValue(BRF205A.getR16_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR16_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R16cell5 = R16row.getCell(9);
				   		 if (R16cell5 != null) {
				   	     R16cell5.setCellValue(BRF205A.getR16_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR16_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R16cell6 = R16row.getCell(10);
				   		 if (R16cell6 != null) {
				   	     R16cell6.setCellValue(BRF205A.getR16_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR16_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R16cell7 = R16row.getCell(11);
				   		 if (R16cell7 != null) {
				   	     R16cell7.setCellValue(BRF205A.getR16_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR16_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R16cell8 = R16row.getCell(12);
				   		 if (R16cell8 != null) {
				   	     R16cell8.setCellValue(BRF205A.getR16_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR16_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R16cell9 = R16row.getCell(13);
				   		 if (R16cell9 != null) {
				   	     R16cell9.setCellValue(BRF205A.getR16_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR16_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R16cell10 = R16row.getCell(14);
				   		 if (R16cell10 != null) {
				   	     R16cell10.setCellValue(BRF205A.getR16_other_aed() == null ? 0 :
				   	     	BRF205A.getR16_other_aed().intValue());
				   		 }	
				   	
				   		Cell R16cell11 = R16row.getCell(15);
				   		 if (R16cell11 != null) {
				   	     R16cell11.setCellValue(BRF205A.getR16_other_fcy() == null ? 0 :
				   	     	BRF205A.getR16_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R18//////////////////
				   	  
				   	  Row R18row = sheet.getRow(27);
				   			            
				   		 Cell R18cell = R18row.getCell(4);
				   		 if (R18cell != null) {
				   	     R18cell.setCellValue(BRF205A.getR18_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR18_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R18cell1 = R18row.getCell(5);
				   		 if (R18cell1 != null) {
				   	     R18cell1.setCellValue(BRF205A.getR18_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR18_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R18cell2 = R18row.getCell(6);
				   		 if (R18cell2 != null) {
				   	     R18cell2.setCellValue(BRF205A.getR18_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR18_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R18cell3 = R18row.getCell(7);
				   		 if (R18cell3 != null) {
				   	     R18cell3.setCellValue(BRF205A.getR18_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR18_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R18cell4 = R18row.getCell(8);
				   		 if (R18cell4 != null) {
				   	     R18cell4.setCellValue(BRF205A.getR18_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR18_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R18cell5 = R18row.getCell(9);
				   		 if (R18cell5 != null) {
				   	     R18cell5.setCellValue(BRF205A.getR18_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR18_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R18cell6 = R18row.getCell(10);
				   		 if (R18cell6 != null) {
				   	     R18cell6.setCellValue(BRF205A.getR18_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR18_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R18cell7 = R18row.getCell(11);
				   		 if (R18cell7 != null) {
				   	     R18cell7.setCellValue(BRF205A.getR18_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR18_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R18cell8 = R18row.getCell(12);
				   		 if (R18cell8 != null) {
				   	     R18cell8.setCellValue(BRF205A.getR18_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR18_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R18cell9 = R18row.getCell(13);
				   		 if (R18cell9 != null) {
				   	     R18cell9.setCellValue(BRF205A.getR18_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR18_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R18cell10 = R18row.getCell(14);
				   		 if (R18cell10 != null) {
				   	     R18cell10.setCellValue(BRF205A.getR18_other_aed() == null ? 0 :
				   	     	BRF205A.getR18_other_aed().intValue());
				   		 }	
				   	
				   		Cell R18cell11 = R18row.getCell(15);
				   		 if (R18cell11 != null) {
				   	     R18cell11.setCellValue(BRF205A.getR18_other_fcy() == null ? 0 :
				   	     	BRF205A.getR18_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R19//////////////////
				   	  
				   	  Row R19row = sheet.getRow(28);
				   			            
				   		 Cell R19cell = R19row.getCell(4);
				   		 if (R19cell != null) {
				   	     R19cell.setCellValue(BRF205A.getR19_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR19_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R19cell1 = R19row.getCell(5);
				   		 if (R19cell1 != null) {
				   	     R19cell1.setCellValue(BRF205A.getR19_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR19_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R19cell2 = R19row.getCell(6);
				   		 if (R19cell2 != null) {
				   	     R19cell2.setCellValue(BRF205A.getR19_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR19_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R19cell3 = R19row.getCell(7);
				   		 if (R19cell3 != null) {
				   	     R19cell3.setCellValue(BRF205A.getR19_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR19_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R19cell4 = R19row.getCell(8);
				   		 if (R19cell4 != null) {
				   	     R19cell4.setCellValue(BRF205A.getR19_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR19_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R19cell5 = R19row.getCell(9);
				   		 if (R19cell5 != null) {
				   	     R19cell5.setCellValue(BRF205A.getR19_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR19_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R19cell6 = R19row.getCell(10);
				   		 if (R19cell6 != null) {
				   	     R19cell6.setCellValue(BRF205A.getR19_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR19_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R19cell7 = R19row.getCell(11);
				   		 if (R19cell7 != null) {
				   	     R19cell7.setCellValue(BRF205A.getR19_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR19_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R19cell8 = R19row.getCell(12);
				   		 if (R19cell8 != null) {
				   	     R19cell8.setCellValue(BRF205A.getR19_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR19_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R19cell9 = R19row.getCell(13);
				   		 if (R19cell9 != null) {
				   	     R19cell9.setCellValue(BRF205A.getR19_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR19_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R19cell10 = R19row.getCell(14);
				   		 if (R19cell10 != null) {
				   	     R19cell10.setCellValue(BRF205A.getR19_other_aed() == null ? 0 :
				   	     	BRF205A.getR19_other_aed().intValue());
				   		 }	
				   	
				   		Cell R19cell11 = R19row.getCell(15);
				   		 if (R19cell11 != null) {
				   	     R19cell11.setCellValue(BRF205A.getR19_other_fcy() == null ? 0 :
				   	     	BRF205A.getR19_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R20//////////////////
				   	  
				   	  Row R20row = sheet.getRow(29);
				   			            
				   		 Cell R20cell = R20row.getCell(4);
				   		 if (R20cell != null) {
				   	     R20cell.setCellValue(BRF205A.getR20_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR20_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R20cell1 = R20row.getCell(5);
				   		 if (R20cell1 != null) {
				   	     R20cell1.setCellValue(BRF205A.getR20_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR20_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R20cell2 = R20row.getCell(6);
				   		 if (R20cell2 != null) {
				   	     R20cell2.setCellValue(BRF205A.getR20_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR20_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R20cell3 = R20row.getCell(7);
				   		 if (R20cell3 != null) {
				   	     R20cell3.setCellValue(BRF205A.getR20_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR20_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R20cell4 = R20row.getCell(8);
				   		 if (R20cell4 != null) {
				   	     R20cell4.setCellValue(BRF205A.getR20_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR20_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R20cell5 = R20row.getCell(9);
				   		 if (R20cell5 != null) {
				   	     R20cell5.setCellValue(BRF205A.getR20_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR20_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R20cell6 = R20row.getCell(10);
				   		 if (R20cell6 != null) {
				   	     R20cell6.setCellValue(BRF205A.getR20_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR20_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R20cell7 = R20row.getCell(11);
				   		 if (R20cell7 != null) {
				   	     R20cell7.setCellValue(BRF205A.getR20_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR20_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R20cell8 = R20row.getCell(12);
				   		 if (R20cell8 != null) {
				   	     R20cell8.setCellValue(BRF205A.getR20_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR20_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R20cell9 = R20row.getCell(13);
				   		 if (R20cell9 != null) {
				   	     R20cell9.setCellValue(BRF205A.getR20_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR20_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R20cell10 = R20row.getCell(14);
				   		 if (R20cell10 != null) {
				   	     R20cell10.setCellValue(BRF205A.getR20_other_aed() == null ? 0 :
				   	     	BRF205A.getR20_other_aed().intValue());
				   		 }	
				   	
				   		Cell R20cell11 = R20row.getCell(15);
				   		 if (R20cell11 != null) {
				   	     R20cell11.setCellValue(BRF205A.getR20_other_fcy() == null ? 0 :
				   	     	BRF205A.getR20_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R21//////////////////
				   	  
				   	  Row R21row = sheet.getRow(30);
				   			            
				   		 Cell R21cell = R21row.getCell(4);
				   		 if (R21cell != null) {
				   	     R21cell.setCellValue(BRF205A.getR21_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR21_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R21cell1 = R21row.getCell(5);
				   		 if (R21cell1 != null) {
				   	     R21cell1.setCellValue(BRF205A.getR21_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR21_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R21cell2 = R21row.getCell(6);
				   		 if (R21cell2 != null) {
				   	     R21cell2.setCellValue(BRF205A.getR21_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR21_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R21cell3 = R21row.getCell(7);
				   		 if (R21cell3 != null) {
				   	     R21cell3.setCellValue(BRF205A.getR21_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR21_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R21cell4 = R21row.getCell(8);
				   		 if (R21cell4 != null) {
				   	     R21cell4.setCellValue(BRF205A.getR21_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR21_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R21cell5 = R21row.getCell(9);
				   		 if (R21cell5 != null) {
				   	     R21cell5.setCellValue(BRF205A.getR21_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR21_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R21cell6 = R21row.getCell(10);
				   		 if (R21cell6 != null) {
				   	     R21cell6.setCellValue(BRF205A.getR21_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR21_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R21cell7 = R21row.getCell(11);
				   		 if (R21cell7 != null) {
				   	     R21cell7.setCellValue(BRF205A.getR21_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR21_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R21cell8 = R21row.getCell(12);
				   		 if (R21cell8 != null) {
				   	     R21cell8.setCellValue(BRF205A.getR21_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR21_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R21cell9 = R21row.getCell(13);
				   		 if (R21cell9 != null) {
				   	     R21cell9.setCellValue(BRF205A.getR21_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR21_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R21cell10 = R21row.getCell(14);
				   		 if (R21cell10 != null) {
				   	     R21cell10.setCellValue(BRF205A.getR21_other_aed() == null ? 0 :
				   	     	BRF205A.getR21_other_aed().intValue());
				   		 }	
				   	
				   		Cell R21cell11 = R21row.getCell(15);
				   		 if (R21cell11 != null) {
				   	     R21cell11.setCellValue(BRF205A.getR21_other_fcy() == null ? 0 :
				   	     	BRF205A.getR21_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R23//////////////////
				   	  
				   	  Row R23row = sheet.getRow(32);
				   			            
				   		 Cell R23cell = R23row.getCell(4);
				   		 if (R23cell != null) {
				   	     R23cell.setCellValue(BRF205A.getR23_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR23_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R23cell1 = R23row.getCell(5);
				   		 if (R23cell1 != null) {
				   	     R23cell1.setCellValue(BRF205A.getR23_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR23_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R23cell2 = R23row.getCell(6);
				   		 if (R23cell2 != null) {
				   	     R23cell2.setCellValue(BRF205A.getR23_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR23_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R23cell3 = R23row.getCell(7);
				   		 if (R23cell3 != null) {
				   	     R23cell3.setCellValue(BRF205A.getR23_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR23_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R23cell4 = R23row.getCell(8);
				   		 if (R23cell4 != null) {
				   	     R23cell4.setCellValue(BRF205A.getR23_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR23_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R23cell5 = R23row.getCell(9);
				   		 if (R23cell5 != null) {
				   	     R23cell5.setCellValue(BRF205A.getR23_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR23_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R23cell6 = R23row.getCell(10);
				   		 if (R23cell6 != null) {
				   	     R23cell6.setCellValue(BRF205A.getR23_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR23_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R23cell7 = R23row.getCell(11);
				   		 if (R23cell7 != null) {
				   	     R23cell7.setCellValue(BRF205A.getR23_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR23_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R23cell8 = R23row.getCell(12);
				   		 if (R23cell8 != null) {
				   	     R23cell8.setCellValue(BRF205A.getR23_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR23_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R23cell9 = R23row.getCell(13);
				   		 if (R23cell9 != null) {
				   	     R23cell9.setCellValue(BRF205A.getR23_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR23_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R23cell10 = R23row.getCell(14);
				   		 if (R23cell10 != null) {
				   	     R23cell10.setCellValue(BRF205A.getR23_other_aed() == null ? 0 :
				   	     	BRF205A.getR23_other_aed().intValue());
				   		 }	
				   	
				   		Cell R23cell11 = R23row.getCell(15);
				   		 if (R23cell11 != null) {
				   	     R23cell11.setCellValue(BRF205A.getR23_other_fcy() == null ? 0 :
				   	     	BRF205A.getR23_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R24//////////////////
				   	  
				   	  Row R24row = sheet.getRow(33);
				   			            
				   		 Cell R24cell = R24row.getCell(4);
				   		 if (R24cell != null) {
				   	     R24cell.setCellValue(BRF205A.getR24_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR24_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R24cell1 = R24row.getCell(5);
				   		 if (R24cell1 != null) {
				   	     R24cell1.setCellValue(BRF205A.getR24_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR24_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R24cell2 = R24row.getCell(6);
				   		 if (R24cell2 != null) {
				   	     R24cell2.setCellValue(BRF205A.getR24_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR24_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R24cell3 = R24row.getCell(7);
				   		 if (R24cell3 != null) {
				   	     R24cell3.setCellValue(BRF205A.getR24_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR24_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R24cell4 = R24row.getCell(8);
				   		 if (R24cell4 != null) {
				   	     R24cell4.setCellValue(BRF205A.getR24_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR24_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R24cell5 = R24row.getCell(9);
				   		 if (R24cell5 != null) {
				   	     R24cell5.setCellValue(BRF205A.getR24_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR24_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R24cell6 = R24row.getCell(10);
				   		 if (R24cell6 != null) {
				   	     R24cell6.setCellValue(BRF205A.getR24_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR24_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R24cell7 = R24row.getCell(11);
				   		 if (R24cell7 != null) {
				   	     R24cell7.setCellValue(BRF205A.getR24_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR24_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R24cell8 = R24row.getCell(12);
				   		 if (R24cell8 != null) {
				   	     R24cell8.setCellValue(BRF205A.getR24_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR24_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R24cell9 = R24row.getCell(13);
				   		 if (R24cell9 != null) {
				   	     R24cell9.setCellValue(BRF205A.getR24_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR24_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R24cell10 = R24row.getCell(14);
				   		 if (R24cell10 != null) {
				   	     R24cell10.setCellValue(BRF205A.getR24_other_aed() == null ? 0 :
				   	     	BRF205A.getR24_other_aed().intValue());
				   		 }	
				   	
				   		Cell R24cell11 = R24row.getCell(15);
				   		 if (R24cell11 != null) {
				   	     R24cell11.setCellValue(BRF205A.getR24_other_fcy() == null ? 0 :
				   	     	BRF205A.getR24_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R25//////////////////
				   	  
				   	  Row R25row = sheet.getRow(34);
				   			            
				   		 Cell R25cell = R25row.getCell(4);
				   		 if (R25cell != null) {
				   	     R25cell.setCellValue(BRF205A.getR25_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR25_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R25cell1 = R25row.getCell(5);
				   		 if (R25cell1 != null) {
				   	     R25cell1.setCellValue(BRF205A.getR25_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR25_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R25cell2 = R25row.getCell(6);
				   		 if (R25cell2 != null) {
				   	     R25cell2.setCellValue(BRF205A.getR25_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR25_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R25cell3 = R25row.getCell(7);
				   		 if (R25cell3 != null) {
				   	     R25cell3.setCellValue(BRF205A.getR25_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR25_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R25cell4 = R25row.getCell(8);
				   		 if (R25cell4 != null) {
				   	     R25cell4.setCellValue(BRF205A.getR25_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR25_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R25cell5 = R25row.getCell(9);
				   		 if (R25cell5 != null) {
				   	     R25cell5.setCellValue(BRF205A.getR25_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR25_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R25cell6 = R25row.getCell(10);
				   		 if (R25cell6 != null) {
				   	     R25cell6.setCellValue(BRF205A.getR25_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR25_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R25cell7 = R25row.getCell(11);
				   		 if (R25cell7 != null) {
				   	     R25cell7.setCellValue(BRF205A.getR25_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR25_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R25cell8 = R25row.getCell(12);
				   		 if (R25cell8 != null) {
				   	     R25cell8.setCellValue(BRF205A.getR25_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR25_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R25cell9 = R25row.getCell(13);
				   		 if (R25cell9 != null) {
				   	     R25cell9.setCellValue(BRF205A.getR25_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR25_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R25cell10 = R25row.getCell(14);
				   		 if (R25cell10 != null) {
				   	     R25cell10.setCellValue(BRF205A.getR25_other_aed() == null ? 0 :
				   	     	BRF205A.getR25_other_aed().intValue());
				   		 }	
				   	
				   		Cell R25cell11 = R25row.getCell(15);
				   		 if (R25cell11 != null) {
				   	     R25cell11.setCellValue(BRF205A.getR25_other_fcy() == null ? 0 :
				   	     	BRF205A.getR25_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R26//////////////////
				   	  
				   	  Row R26row = sheet.getRow(35);
				   			            
				   		 Cell R26cell = R26row.getCell(4);
				   		 if (R26cell != null) {
				   	     R26cell.setCellValue(BRF205A.getR26_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR26_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R26cell1 = R26row.getCell(5);
				   		 if (R26cell1 != null) {
				   	     R26cell1.setCellValue(BRF205A.getR26_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR26_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R26cell2 = R26row.getCell(6);
				   		 if (R26cell2 != null) {
				   	     R26cell2.setCellValue(BRF205A.getR26_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR26_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R26cell3 = R26row.getCell(7);
				   		 if (R26cell3 != null) {
				   	     R26cell3.setCellValue(BRF205A.getR26_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR26_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R26cell4 = R26row.getCell(8);
				   		 if (R26cell4 != null) {
				   	     R26cell4.setCellValue(BRF205A.getR26_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR26_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R26cell5 = R26row.getCell(9);
				   		 if (R26cell5 != null) {
				   	     R26cell5.setCellValue(BRF205A.getR26_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR26_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R26cell6 = R26row.getCell(10);
				   		 if (R26cell6 != null) {
				   	     R26cell6.setCellValue(BRF205A.getR26_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR26_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R26cell7 = R26row.getCell(11);
				   		 if (R26cell7 != null) {
				   	     R26cell7.setCellValue(BRF205A.getR26_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR26_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R26cell8 = R26row.getCell(12);
				   		 if (R26cell8 != null) {
				   	     R26cell8.setCellValue(BRF205A.getR26_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR26_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R26cell9 = R26row.getCell(13);
				   		 if (R26cell9 != null) {
				   	     R26cell9.setCellValue(BRF205A.getR26_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR26_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R26cell10 = R26row.getCell(14);
				   		 if (R26cell10 != null) {
				   	     R26cell10.setCellValue(BRF205A.getR26_other_aed() == null ? 0 :
				   	     	BRF205A.getR26_other_aed().intValue());
				   		 }	
				   	
				   		Cell R26cell11 = R26row.getCell(15);
				   		 if (R26cell11 != null) {
				   	     R26cell11.setCellValue(BRF205A.getR26_other_fcy() == null ? 0 :
				   	     	BRF205A.getR26_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R28//////////////////
				   	  
				   	  Row R28row = sheet.getRow(37);
				   			            
				   		 Cell R28cell = R28row.getCell(4);
				   		 if (R28cell != null) {
				   	     R28cell.setCellValue(BRF205A.getR28_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR28_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R28cell1 = R28row.getCell(5);
				   		 if (R28cell1 != null) {
				   	     R28cell1.setCellValue(BRF205A.getR28_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR28_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R28cell2 = R28row.getCell(6);
				   		 if (R28cell2 != null) {
				   	     R28cell2.setCellValue(BRF205A.getR28_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR28_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R28cell3 = R28row.getCell(7);
				   		 if (R28cell3 != null) {
				   	     R28cell3.setCellValue(BRF205A.getR28_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR28_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R28cell4 = R28row.getCell(8);
				   		 if (R28cell4 != null) {
				   	     R28cell4.setCellValue(BRF205A.getR28_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR28_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R28cell5 = R28row.getCell(9);
				   		 if (R28cell5 != null) {
				   	     R28cell5.setCellValue(BRF205A.getR28_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR28_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R28cell6 = R28row.getCell(10);
				   		 if (R28cell6 != null) {
				   	     R28cell6.setCellValue(BRF205A.getR28_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR28_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R28cell7 = R28row.getCell(11);
				   		 if (R28cell7 != null) {
				   	     R28cell7.setCellValue(BRF205A.getR28_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR28_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R28cell8 = R28row.getCell(12);
				   		 if (R28cell8 != null) {
				   	     R28cell8.setCellValue(BRF205A.getR28_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR28_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R28cell9 = R28row.getCell(13);
				   		 if (R28cell9 != null) {
				   	     R28cell9.setCellValue(BRF205A.getR28_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR28_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R28cell10 = R28row.getCell(14);
				   		 if (R28cell10 != null) {
				   	     R28cell10.setCellValue(BRF205A.getR28_other_aed() == null ? 0 :
				   	     	BRF205A.getR28_other_aed().intValue());
				   		 }	
				   	
				   		Cell R28cell11 = R28row.getCell(15);
				   		 if (R28cell11 != null) {
				   	     R28cell11.setCellValue(BRF205A.getR28_other_fcy() == null ? 0 :
				   	     	BRF205A.getR28_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R29//////////////////
				   	  
				   	  Row R29row = sheet.getRow(38);
				   			            
				   		 Cell R29cell = R29row.getCell(4);
				   		 if (R29cell != null) {
				   	     R29cell.setCellValue(BRF205A.getR29_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR29_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R29cell1 = R29row.getCell(5);
				   		 if (R29cell1 != null) {
				   	     R29cell1.setCellValue(BRF205A.getR29_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR29_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R29cell2 = R29row.getCell(6);
				   		 if (R29cell2 != null) {
				   	     R29cell2.setCellValue(BRF205A.getR29_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR29_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R29cell3 = R29row.getCell(7);
				   		 if (R29cell3 != null) {
				   	     R29cell3.setCellValue(BRF205A.getR29_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR29_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R29cell4 = R29row.getCell(8);
				   		 if (R29cell4 != null) {
				   	     R29cell4.setCellValue(BRF205A.getR29_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR29_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R29cell5 = R29row.getCell(9);
				   		 if (R29cell5 != null) {
				   	     R29cell5.setCellValue(BRF205A.getR29_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR29_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R29cell6 = R29row.getCell(10);
				   		 if (R29cell6 != null) {
				   	     R29cell6.setCellValue(BRF205A.getR29_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR29_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R29cell7 = R29row.getCell(11);
				   		 if (R29cell7 != null) {
				   	     R29cell7.setCellValue(BRF205A.getR29_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR29_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R29cell8 = R29row.getCell(12);
				   		 if (R29cell8 != null) {
				   	     R29cell8.setCellValue(BRF205A.getR29_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR29_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R29cell9 = R29row.getCell(13);
				   		 if (R29cell9 != null) {
				   	     R29cell9.setCellValue(BRF205A.getR29_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR29_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R29cell10 = R29row.getCell(14);
				   		 if (R29cell10 != null) {
				   	     R29cell10.setCellValue(BRF205A.getR29_other_aed() == null ? 0 :
				   	     	BRF205A.getR29_other_aed().intValue());
				   		 }	
				   	
				   		Cell R29cell11 = R29row.getCell(15);
				   		 if (R29cell11 != null) {
				   	     R29cell11.setCellValue(BRF205A.getR29_other_fcy() == null ? 0 :
				   	     	BRF205A.getR29_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R30//////////////////
				   	  
				   	  Row R30row = sheet.getRow(39);
				   			            
				   		 Cell R30cell = R30row.getCell(4);
				   		 if (R30cell != null) {
				   	     R30cell.setCellValue(BRF205A.getR30_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR30_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R30cell1 = R30row.getCell(5);
				   		 if (R30cell1 != null) {
				   	     R30cell1.setCellValue(BRF205A.getR30_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR30_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R30cell2 = R30row.getCell(6);
				   		 if (R30cell2 != null) {
				   	     R30cell2.setCellValue(BRF205A.getR30_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR30_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R30cell3 = R30row.getCell(7);
				   		 if (R30cell3 != null) {
				   	     R30cell3.setCellValue(BRF205A.getR30_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR30_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R30cell4 = R30row.getCell(8);
				   		 if (R30cell4 != null) {
				   	     R30cell4.setCellValue(BRF205A.getR30_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR30_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R30cell5 = R30row.getCell(9);
				   		 if (R30cell5 != null) {
				   	     R30cell5.setCellValue(BRF205A.getR30_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR30_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R30cell6 = R30row.getCell(10);
				   		 if (R30cell6 != null) {
				   	     R30cell6.setCellValue(BRF205A.getR30_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR30_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R30cell7 = R30row.getCell(11);
				   		 if (R30cell7 != null) {
				   	     R30cell7.setCellValue(BRF205A.getR30_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR30_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R30cell8 = R30row.getCell(12);
				   		 if (R30cell8 != null) {
				   	     R30cell8.setCellValue(BRF205A.getR30_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR30_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R30cell9 = R30row.getCell(13);
				   		 if (R30cell9 != null) {
				   	     R30cell9.setCellValue(BRF205A.getR30_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR30_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R30cell10 = R30row.getCell(14);
				   		 if (R30cell10 != null) {
				   	     R30cell10.setCellValue(BRF205A.getR30_other_aed() == null ? 0 :
				   	     	BRF205A.getR30_other_aed().intValue());
				   		 }	
				   	
				   		Cell R30cell11 = R30row.getCell(15);
				   		 if (R30cell11 != null) {
				   	     R30cell11.setCellValue(BRF205A.getR30_other_fcy() == null ? 0 :
				   	     	BRF205A.getR30_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R31//////////////////
				   	  
				   	  Row R31row = sheet.getRow(40);
				   			            
				   		 Cell R31cell = R31row.getCell(4);
				   		 if (R31cell != null) {
				   	     R31cell.setCellValue(BRF205A.getR31_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR31_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R31cell1 = R31row.getCell(5);
				   		 if (R31cell1 != null) {
				   	     R31cell1.setCellValue(BRF205A.getR31_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR31_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R31cell2 = R31row.getCell(6);
				   		 if (R31cell2 != null) {
				   	     R31cell2.setCellValue(BRF205A.getR31_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR31_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R31cell3 = R31row.getCell(7);
				   		 if (R31cell3 != null) {
				   	     R31cell3.setCellValue(BRF205A.getR31_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR31_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R31cell4 = R31row.getCell(8);
				   		 if (R31cell4 != null) {
				   	     R31cell4.setCellValue(BRF205A.getR31_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR31_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R31cell5 = R31row.getCell(9);
				   		 if (R31cell5 != null) {
				   	     R31cell5.setCellValue(BRF205A.getR31_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR31_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R31cell6 = R31row.getCell(10);
				   		 if (R31cell6 != null) {
				   	     R31cell6.setCellValue(BRF205A.getR31_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR31_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R31cell7 = R31row.getCell(11);
				   		 if (R31cell7 != null) {
				   	     R31cell7.setCellValue(BRF205A.getR31_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR31_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R31cell8 = R31row.getCell(12);
				   		 if (R31cell8 != null) {
				   	     R31cell8.setCellValue(BRF205A.getR31_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR31_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R31cell9 = R31row.getCell(13);
				   		 if (R31cell9 != null) {
				   	     R31cell9.setCellValue(BRF205A.getR31_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR31_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R31cell10 = R31row.getCell(14);
				   		 if (R31cell10 != null) {
				   	     R31cell10.setCellValue(BRF205A.getR31_other_aed() == null ? 0 :
				   	     	BRF205A.getR31_other_aed().intValue());
				   		 }	
				   	
				   		Cell R31cell11 = R31row.getCell(15);
				   		 if (R31cell11 != null) {
				   	     R31cell11.setCellValue(BRF205A.getR31_other_fcy() == null ? 0 :
				   	     	BRF205A.getR31_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R33//////////////////
				   	  
				   	  Row R33row = sheet.getRow(42);
				   			            
				   		 Cell R33cell = R33row.getCell(4);
				   		 if (R33cell != null) {
				   	     R33cell.setCellValue(BRF205A.getR33_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR33_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R33cell1 = R33row.getCell(5);
				   		 if (R33cell1 != null) {
				   	     R33cell1.setCellValue(BRF205A.getR33_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR33_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R33cell2 = R33row.getCell(6);
				   		 if (R33cell2 != null) {
				   	     R33cell2.setCellValue(BRF205A.getR33_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR33_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R33cell3 = R33row.getCell(7);
				   		 if (R33cell3 != null) {
				   	     R33cell3.setCellValue(BRF205A.getR33_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR33_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R33cell4 = R33row.getCell(8);
				   		 if (R33cell4 != null) {
				   	     R33cell4.setCellValue(BRF205A.getR33_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR33_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R33cell5 = R33row.getCell(9);
				   		 if (R33cell5 != null) {
				   	     R33cell5.setCellValue(BRF205A.getR33_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR33_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R33cell6 = R33row.getCell(10);
				   		 if (R33cell6 != null) {
				   	     R33cell6.setCellValue(BRF205A.getR33_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR33_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R33cell7 = R33row.getCell(11);
				   		 if (R33cell7 != null) {
				   	     R33cell7.setCellValue(BRF205A.getR33_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR33_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R33cell8 = R33row.getCell(12);
				   		 if (R33cell8 != null) {
				   	     R33cell8.setCellValue(BRF205A.getR33_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR33_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R33cell9 = R33row.getCell(13);
				   		 if (R33cell9 != null) {
				   	     R33cell9.setCellValue(BRF205A.getR33_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR33_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R33cell10 = R33row.getCell(14);
				   		 if (R33cell10 != null) {
				   	     R33cell10.setCellValue(BRF205A.getR33_other_aed() == null ? 0 :
				   	     	BRF205A.getR33_other_aed().intValue());
				   		 }	
				   	
				   		Cell R33cell11 = R33row.getCell(15);
				   		 if (R33cell11 != null) {
				   	     R33cell11.setCellValue(BRF205A.getR33_other_fcy() == null ? 0 :
				   	     	BRF205A.getR33_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R34//////////////////
				   	  
				   	  Row R34row = sheet.getRow(43);
				   			            
				   		 Cell R34cell = R34row.getCell(4);
				   		 if (R34cell != null) {
				   	     R34cell.setCellValue(BRF205A.getR34_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR34_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R34cell1 = R34row.getCell(5);
				   		 if (R34cell1 != null) {
				   	     R34cell1.setCellValue(BRF205A.getR34_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR34_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R34cell2 = R34row.getCell(6);
				   		 if (R34cell2 != null) {
				   	     R34cell2.setCellValue(BRF205A.getR34_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR34_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R34cell3 = R34row.getCell(7);
				   		 if (R34cell3 != null) {
				   	     R34cell3.setCellValue(BRF205A.getR34_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR34_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R34cell4 = R34row.getCell(8);
				   		 if (R34cell4 != null) {
				   	     R34cell4.setCellValue(BRF205A.getR34_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR34_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R34cell5 = R34row.getCell(9);
				   		 if (R34cell5 != null) {
				   	     R34cell5.setCellValue(BRF205A.getR34_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR34_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R34cell6 = R34row.getCell(10);
				   		 if (R34cell6 != null) {
				   	     R34cell6.setCellValue(BRF205A.getR34_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR34_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R34cell7 = R34row.getCell(11);
				   		 if (R34cell7 != null) {
				   	     R34cell7.setCellValue(BRF205A.getR34_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR34_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R34cell8 = R34row.getCell(12);
				   		 if (R34cell8 != null) {
				   	     R34cell8.setCellValue(BRF205A.getR34_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR34_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R34cell9 = R34row.getCell(13);
				   		 if (R34cell9 != null) {
				   	     R34cell9.setCellValue(BRF205A.getR34_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR34_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R34cell10 = R34row.getCell(14);
				   		 if (R34cell10 != null) {
				   	     R34cell10.setCellValue(BRF205A.getR34_other_aed() == null ? 0 :
				   	     	BRF205A.getR34_other_aed().intValue());
				   		 }	
				   	
				   		Cell R34cell11 = R34row.getCell(15);
				   		 if (R34cell11 != null) {
				   	     R34cell11.setCellValue(BRF205A.getR34_other_fcy() == null ? 0 :
				   	     	BRF205A.getR34_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R36//////////////////
				   	  
				   	  Row R36row = sheet.getRow(45);
				   			            
				   		 Cell R36cell = R36row.getCell(4);
				   		 if (R36cell != null) {
				   	     R36cell.setCellValue(BRF205A.getR36_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR36_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R36cell1 = R36row.getCell(5);
				   		 if (R36cell1 != null) {
				   	     R36cell1.setCellValue(BRF205A.getR36_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR36_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R36cell2 = R36row.getCell(6);
				   		 if (R36cell2 != null) {
				   	     R36cell2.setCellValue(BRF205A.getR36_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR36_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R36cell3 = R36row.getCell(7);
				   		 if (R36cell3 != null) {
				   	     R36cell3.setCellValue(BRF205A.getR36_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR36_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R36cell4 = R36row.getCell(8);
				   		 if (R36cell4 != null) {
				   	     R36cell4.setCellValue(BRF205A.getR36_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR36_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R36cell5 = R36row.getCell(9);
				   		 if (R36cell5 != null) {
				   	     R36cell5.setCellValue(BRF205A.getR36_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR36_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R36cell6 = R36row.getCell(10);
				   		 if (R36cell6 != null) {
				   	     R36cell6.setCellValue(BRF205A.getR36_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR36_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R36cell7 = R36row.getCell(11);
				   		 if (R36cell7 != null) {
				   	     R36cell7.setCellValue(BRF205A.getR36_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR36_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R36cell8 = R36row.getCell(12);
				   		 if (R36cell8 != null) {
				   	     R36cell8.setCellValue(BRF205A.getR36_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR36_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R36cell9 = R36row.getCell(13);
				   		 if (R36cell9 != null) {
				   	     R36cell9.setCellValue(BRF205A.getR36_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR36_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R36cell10 = R36row.getCell(14);
				   		 if (R36cell10 != null) {
				   	     R36cell10.setCellValue(BRF205A.getR36_other_aed() == null ? 0 :
				   	     	BRF205A.getR36_other_aed().intValue());
				   		 }	
				   	
				   		Cell R36cell11 = R36row.getCell(15);
				   		 if (R36cell11 != null) {
				   	     R36cell11.setCellValue(BRF205A.getR36_other_fcy() == null ? 0 :
				   	     	BRF205A.getR36_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R37//////////////////
				   	  
				   	  Row R37row = sheet.getRow(46);
				   			            
				   		 Cell R37cell = R37row.getCell(4);
				   		 if (R37cell != null) {
				   	     R37cell.setCellValue(BRF205A.getR37_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR37_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R37cell1 = R37row.getCell(5);
				   		 if (R37cell1 != null) {
				   	     R37cell1.setCellValue(BRF205A.getR37_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR37_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R37cell2 = R37row.getCell(6);
				   		 if (R37cell2 != null) {
				   	     R37cell2.setCellValue(BRF205A.getR37_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR37_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R37cell3 = R37row.getCell(7);
				   		 if (R37cell3 != null) {
				   	     R37cell3.setCellValue(BRF205A.getR37_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR37_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R37cell4 = R37row.getCell(8);
				   		 if (R37cell4 != null) {
				   	     R37cell4.setCellValue(BRF205A.getR37_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR37_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R37cell5 = R37row.getCell(9);
				   		 if (R37cell5 != null) {
				   	     R37cell5.setCellValue(BRF205A.getR37_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR37_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R37cell6 = R37row.getCell(10);
				   		 if (R37cell6 != null) {
				   	     R37cell6.setCellValue(BRF205A.getR37_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR37_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R37cell7 = R37row.getCell(11);
				   		 if (R37cell7 != null) {
				   	     R37cell7.setCellValue(BRF205A.getR37_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR37_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R37cell8 = R37row.getCell(12);
				   		 if (R37cell8 != null) {
				   	     R37cell8.setCellValue(BRF205A.getR37_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR37_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R37cell9 = R37row.getCell(13);
				   		 if (R37cell9 != null) {
				   	     R37cell9.setCellValue(BRF205A.getR37_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR37_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R37cell10 = R37row.getCell(14);
				   		 if (R37cell10 != null) {
				   	     R37cell10.setCellValue(BRF205A.getR37_other_aed() == null ? 0 :
				   	     	BRF205A.getR37_other_aed().intValue());
				   		 }	
				   	
				   		Cell R37cell11 = R37row.getCell(15);
				   		 if (R37cell11 != null) {
				   	     R37cell11.setCellValue(BRF205A.getR37_other_fcy() == null ? 0 :
				   	     	BRF205A.getR37_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R38//////////////////
				   	  
				   	  Row R38row = sheet.getRow(47);
				   			            
				   		 Cell R38cell = R38row.getCell(4);
				   		 if (R38cell != null) {
				   	     R38cell.setCellValue(BRF205A.getR38_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR38_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R38cell1 = R38row.getCell(5);
				   		 if (R38cell1 != null) {
				   	     R38cell1.setCellValue(BRF205A.getR38_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR38_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R38cell2 = R38row.getCell(6);
				   		 if (R38cell2 != null) {
				   	     R38cell2.setCellValue(BRF205A.getR38_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR38_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R38cell3 = R38row.getCell(7);
				   		 if (R38cell3 != null) {
				   	     R38cell3.setCellValue(BRF205A.getR38_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR38_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R38cell4 = R38row.getCell(8);
				   		 if (R38cell4 != null) {
				   	     R38cell4.setCellValue(BRF205A.getR38_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR38_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R38cell5 = R38row.getCell(9);
				   		 if (R38cell5 != null) {
				   	     R38cell5.setCellValue(BRF205A.getR38_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR38_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R38cell6 = R38row.getCell(10);
				   		 if (R38cell6 != null) {
				   	     R38cell6.setCellValue(BRF205A.getR38_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR38_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R38cell7 = R38row.getCell(11);
				   		 if (R38cell7 != null) {
				   	     R38cell7.setCellValue(BRF205A.getR38_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR38_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R38cell8 = R38row.getCell(12);
				   		 if (R38cell8 != null) {
				   	     R38cell8.setCellValue(BRF205A.getR38_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR38_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R38cell9 = R38row.getCell(13);
				   		 if (R38cell9 != null) {
				   	     R38cell9.setCellValue(BRF205A.getR38_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR38_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R38cell10 = R38row.getCell(14);
				   		 if (R38cell10 != null) {
				   	     R38cell10.setCellValue(BRF205A.getR38_other_aed() == null ? 0 :
				   	     	BRF205A.getR38_other_aed().intValue());
				   		 }	
				   	
				   		Cell R38cell11 = R38row.getCell(15);
				   		 if (R38cell11 != null) {
				   	     R38cell11.setCellValue(BRF205A.getR38_other_fcy() == null ? 0 :
				   	     	BRF205A.getR38_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R39//////////////////
				   	  
				   	  Row R39row = sheet.getRow(48);
				   			            
				   		 Cell R39cell = R39row.getCell(4);
				   		 if (R39cell != null) {
				   	     R39cell.setCellValue(BRF205A.getR39_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR39_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R39cell1 = R39row.getCell(5);
				   		 if (R39cell1 != null) {
				   	     R39cell1.setCellValue(BRF205A.getR39_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR39_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R39cell2 = R39row.getCell(6);
				   		 if (R39cell2 != null) {
				   	     R39cell2.setCellValue(BRF205A.getR39_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR39_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R39cell3 = R39row.getCell(7);
				   		 if (R39cell3 != null) {
				   	     R39cell3.setCellValue(BRF205A.getR39_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR39_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R39cell4 = R39row.getCell(8);
				   		 if (R39cell4 != null) {
				   	     R39cell4.setCellValue(BRF205A.getR39_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR39_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R39cell5 = R39row.getCell(9);
				   		 if (R39cell5 != null) {
				   	     R39cell5.setCellValue(BRF205A.getR39_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR39_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R39cell6 = R39row.getCell(10);
				   		 if (R39cell6 != null) {
				   	     R39cell6.setCellValue(BRF205A.getR39_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR39_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R39cell7 = R39row.getCell(11);
				   		 if (R39cell7 != null) {
				   	     R39cell7.setCellValue(BRF205A.getR39_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR39_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R39cell8 = R39row.getCell(12);
				   		 if (R39cell8 != null) {
				   	     R39cell8.setCellValue(BRF205A.getR39_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR39_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R39cell9 = R39row.getCell(13);
				   		 if (R39cell9 != null) {
				   	     R39cell9.setCellValue(BRF205A.getR39_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR39_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R39cell10 = R39row.getCell(14);
				   		 if (R39cell10 != null) {
				   	     R39cell10.setCellValue(BRF205A.getR39_other_aed() == null ? 0 :
				   	     	BRF205A.getR39_other_aed().intValue());
				   		 }	
				   	
				   		Cell R39cell11 = R39row.getCell(15);
				   		 if (R39cell11 != null) {
				   	     R39cell11.setCellValue(BRF205A.getR39_other_fcy() == null ? 0 :
				   	     	BRF205A.getR39_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R41//////////////////
				   	  
				   	  Row R41row = sheet.getRow(50);
				   			            
				   		 Cell R41cell = R41row.getCell(4);
				   		 if (R41cell != null) {
				   	     R41cell.setCellValue(BRF205A.getR41_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR41_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R41cell1 = R41row.getCell(5);
				   		 if (R41cell1 != null) {
				   	     R41cell1.setCellValue(BRF205A.getR41_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR41_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R41cell2 = R41row.getCell(6);
				   		 if (R41cell2 != null) {
				   	     R41cell2.setCellValue(BRF205A.getR41_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR41_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R41cell3 = R41row.getCell(7);
				   		 if (R41cell3 != null) {
				   	     R41cell3.setCellValue(BRF205A.getR41_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR41_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R41cell4 = R41row.getCell(8);
				   		 if (R41cell4 != null) {
				   	     R41cell4.setCellValue(BRF205A.getR41_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR41_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R41cell5 = R41row.getCell(9);
				   		 if (R41cell5 != null) {
				   	     R41cell5.setCellValue(BRF205A.getR41_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR41_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R41cell6 = R41row.getCell(10);
				   		 if (R41cell6 != null) {
				   	     R41cell6.setCellValue(BRF205A.getR41_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR41_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R41cell7 = R41row.getCell(11);
				   		 if (R41cell7 != null) {
				   	     R41cell7.setCellValue(BRF205A.getR41_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR41_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R41cell8 = R41row.getCell(12);
				   		 if (R41cell8 != null) {
				   	     R41cell8.setCellValue(BRF205A.getR41_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR41_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R41cell9 = R41row.getCell(13);
				   		 if (R41cell9 != null) {
				   	     R41cell9.setCellValue(BRF205A.getR41_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR41_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R41cell10 = R41row.getCell(14);
				   		 if (R41cell10 != null) {
				   	     R41cell10.setCellValue(BRF205A.getR41_other_aed() == null ? 0 :
				   	     	BRF205A.getR41_other_aed().intValue());
				   		 }	
				   	
				   		Cell R41cell11 = R41row.getCell(15);
				   		 if (R41cell11 != null) {
				   	     R41cell11.setCellValue(BRF205A.getR41_other_fcy() == null ? 0 :
				   	     	BRF205A.getR41_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R42//////////////////
				   	  
				   	  Row R42row = sheet.getRow(51);
				   			            
				   		 Cell R42cell = R42row.getCell(4);
				   		 if (R42cell != null) {
				   	     R42cell.setCellValue(BRF205A.getR42_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR42_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R42cell1 = R42row.getCell(5);
				   		 if (R42cell1 != null) {
				   	     R42cell1.setCellValue(BRF205A.getR42_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR42_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R42cell2 = R42row.getCell(6);
				   		 if (R42cell2 != null) {
				   	     R42cell2.setCellValue(BRF205A.getR42_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR42_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R42cell3 = R42row.getCell(7);
				   		 if (R42cell3 != null) {
				   	     R42cell3.setCellValue(BRF205A.getR42_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR42_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R42cell4 = R42row.getCell(8);
				   		 if (R42cell4 != null) {
				   	     R42cell4.setCellValue(BRF205A.getR42_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR42_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R42cell5 = R42row.getCell(9);
				   		 if (R42cell5 != null) {
				   	     R42cell5.setCellValue(BRF205A.getR42_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR42_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R42cell6 = R42row.getCell(10);
				   		 if (R42cell6 != null) {
				   	     R42cell6.setCellValue(BRF205A.getR42_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR42_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R42cell7 = R42row.getCell(11);
				   		 if (R42cell7 != null) {
				   	     R42cell7.setCellValue(BRF205A.getR42_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR42_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R42cell8 = R42row.getCell(12);
				   		 if (R42cell8 != null) {
				   	     R42cell8.setCellValue(BRF205A.getR42_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR42_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R42cell9 = R42row.getCell(13);
				   		 if (R42cell9 != null) {
				   	     R42cell9.setCellValue(BRF205A.getR42_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR42_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R42cell10 = R42row.getCell(14);
				   		 if (R42cell10 != null) {
				   	     R42cell10.setCellValue(BRF205A.getR42_other_aed() == null ? 0 :
				   	     	BRF205A.getR42_other_aed().intValue());
				   		 }	
				   	
				   		Cell R42cell11 = R42row.getCell(15);
				   		 if (R42cell11 != null) {
				   	     R42cell11.setCellValue(BRF205A.getR42_other_fcy() == null ? 0 :
				   	     	BRF205A.getR42_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R44//////////////////
				   	  
				   	  Row R44row = sheet.getRow(53);
				   			            
				   		 Cell R44cell = R44row.getCell(4);
				   		 if (R44cell != null) {
				   	     R44cell.setCellValue(BRF205A.getR44_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR44_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R44cell1 = R44row.getCell(5);
				   		 if (R44cell1 != null) {
				   	     R44cell1.setCellValue(BRF205A.getR44_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR44_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R44cell2 = R44row.getCell(6);
				   		 if (R44cell2 != null) {
				   	     R44cell2.setCellValue(BRF205A.getR44_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR44_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R44cell3 = R44row.getCell(7);
				   		 if (R44cell3 != null) {
				   	     R44cell3.setCellValue(BRF205A.getR44_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR44_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R44cell4 = R44row.getCell(8);
				   		 if (R44cell4 != null) {
				   	     R44cell4.setCellValue(BRF205A.getR44_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR44_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R44cell5 = R44row.getCell(9);
				   		 if (R44cell5 != null) {
				   	     R44cell5.setCellValue(BRF205A.getR44_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR44_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R44cell6 = R44row.getCell(10);
				   		 if (R44cell6 != null) {
				   	     R44cell6.setCellValue(BRF205A.getR44_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR44_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R44cell7 = R44row.getCell(11);
				   		 if (R44cell7 != null) {
				   	     R44cell7.setCellValue(BRF205A.getR44_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR44_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R44cell8 = R44row.getCell(12);
				   		 if (R44cell8 != null) {
				   	     R44cell8.setCellValue(BRF205A.getR44_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR44_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R44cell9 = R44row.getCell(13);
				   		 if (R44cell9 != null) {
				   	     R44cell9.setCellValue(BRF205A.getR44_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR44_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R44cell10 = R44row.getCell(14);
				   		 if (R44cell10 != null) {
				   	     R44cell10.setCellValue(BRF205A.getR44_other_aed() == null ? 0 :
				   	     	BRF205A.getR44_other_aed().intValue());
				   		 }	
				   	
				   		Cell R44cell11 = R44row.getCell(15);
				   		 if (R44cell11 != null) {
				   	     R44cell11.setCellValue(BRF205A.getR44_other_fcy() == null ? 0 :
				   	     	BRF205A.getR44_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R46//////////////////
				   	  
				   	  Row R46row = sheet.getRow(55);
				   			            
				   		 Cell R46cell = R46row.getCell(4);
				   		 if (R46cell != null) {
				   	     R46cell.setCellValue(BRF205A.getR46_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR46_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R46cell1 = R46row.getCell(5);
				   		 if (R46cell1 != null) {
				   	     R46cell1.setCellValue(BRF205A.getR46_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR46_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R46cell2 = R46row.getCell(6);
				   		 if (R46cell2 != null) {
				   	     R46cell2.setCellValue(BRF205A.getR46_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR46_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R46cell3 = R46row.getCell(7);
				   		 if (R46cell3 != null) {
				   	     R46cell3.setCellValue(BRF205A.getR46_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR46_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R46cell4 = R46row.getCell(8);
				   		 if (R46cell4 != null) {
				   	     R46cell4.setCellValue(BRF205A.getR46_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR46_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R46cell5 = R46row.getCell(9);
				   		 if (R46cell5 != null) {
				   	     R46cell5.setCellValue(BRF205A.getR46_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR46_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R46cell6 = R46row.getCell(10);
				   		 if (R46cell6 != null) {
				   	     R46cell6.setCellValue(BRF205A.getR46_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR46_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R46cell7 = R46row.getCell(11);
				   		 if (R46cell7 != null) {
				   	     R46cell7.setCellValue(BRF205A.getR46_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR46_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R46cell8 = R46row.getCell(12);
				   		 if (R46cell8 != null) {
				   	     R46cell8.setCellValue(BRF205A.getR46_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR46_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R46cell9 = R46row.getCell(13);
				   		 if (R46cell9 != null) {
				   	     R46cell9.setCellValue(BRF205A.getR46_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR46_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R46cell10 = R46row.getCell(14);
				   		 if (R46cell10 != null) {
				   	     R46cell10.setCellValue(BRF205A.getR46_other_aed() == null ? 0 :
				   	     	BRF205A.getR46_other_aed().intValue());
				   		 }	
				   	
				   		Cell R46cell11 = R46row.getCell(15);
				   		 if (R46cell11 != null) {
				   	     R46cell11.setCellValue(BRF205A.getR46_other_fcy() == null ? 0 :
				   	     	BRF205A.getR46_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R47//////////////////
				   	  
				   	  Row R47row = sheet.getRow(56);
				   			            
				   		 Cell R47cell = R47row.getCell(4);
				   		 if (R47cell != null) {
				   	     R47cell.setCellValue(BRF205A.getR47_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR47_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R47cell1 = R47row.getCell(5);
				   		 if (R47cell1 != null) {
				   	     R47cell1.setCellValue(BRF205A.getR47_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR47_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R47cell2 = R47row.getCell(6);
				   		 if (R47cell2 != null) {
				   	     R47cell2.setCellValue(BRF205A.getR47_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR47_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R47cell3 = R47row.getCell(7);
				   		 if (R47cell3 != null) {
				   	     R47cell3.setCellValue(BRF205A.getR47_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR47_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R47cell4 = R47row.getCell(8);
				   		 if (R47cell4 != null) {
				   	     R47cell4.setCellValue(BRF205A.getR47_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR47_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R47cell5 = R47row.getCell(9);
				   		 if (R47cell5 != null) {
				   	     R47cell5.setCellValue(BRF205A.getR47_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR47_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R47cell6 = R47row.getCell(10);
				   		 if (R47cell6 != null) {
				   	     R47cell6.setCellValue(BRF205A.getR47_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR47_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R47cell7 = R47row.getCell(11);
				   		 if (R47cell7 != null) {
				   	     R47cell7.setCellValue(BRF205A.getR47_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR47_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R47cell8 = R47row.getCell(12);
				   		 if (R47cell8 != null) {
				   	     R47cell8.setCellValue(BRF205A.getR47_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR47_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R47cell9 = R47row.getCell(13);
				   		 if (R47cell9 != null) {
				   	     R47cell9.setCellValue(BRF205A.getR47_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR47_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R47cell10 = R47row.getCell(14);
				   		 if (R47cell10 != null) {
				   	     R47cell10.setCellValue(BRF205A.getR47_other_aed() == null ? 0 :
				   	     	BRF205A.getR47_other_aed().intValue());
				   		 }	
				   	
				   		Cell R47cell11 = R47row.getCell(15);
				   		 if (R47cell11 != null) {
				   	     R47cell11.setCellValue(BRF205A.getR47_other_fcy() == null ? 0 :
				   	     	BRF205A.getR47_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R48//////////////////
				   	  
				   	  Row R48row = sheet.getRow(57);
				   			            
				   		 Cell R48cell = R48row.getCell(4);
				   		 if (R48cell != null) {
				   	     R48cell.setCellValue(BRF205A.getR48_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR48_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R48cell1 = R48row.getCell(5);
				   		 if (R48cell1 != null) {
				   	     R48cell1.setCellValue(BRF205A.getR48_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR48_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R48cell2 = R48row.getCell(6);
				   		 if (R48cell2 != null) {
				   	     R48cell2.setCellValue(BRF205A.getR48_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR48_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R48cell3 = R48row.getCell(7);
				   		 if (R48cell3 != null) {
				   	     R48cell3.setCellValue(BRF205A.getR48_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR48_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R48cell4 = R48row.getCell(8);
				   		 if (R48cell4 != null) {
				   	     R48cell4.setCellValue(BRF205A.getR48_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR48_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R48cell5 = R48row.getCell(9);
				   		 if (R48cell5 != null) {
				   	     R48cell5.setCellValue(BRF205A.getR48_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR48_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R48cell6 = R48row.getCell(10);
				   		 if (R48cell6 != null) {
				   	     R48cell6.setCellValue(BRF205A.getR48_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR48_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R48cell7 = R48row.getCell(11);
				   		 if (R48cell7 != null) {
				   	     R48cell7.setCellValue(BRF205A.getR48_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR48_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R48cell8 = R48row.getCell(12);
				   		 if (R48cell8 != null) {
				   	     R48cell8.setCellValue(BRF205A.getR48_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR48_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R48cell9 = R48row.getCell(13);
				   		 if (R48cell9 != null) {
				   	     R48cell9.setCellValue(BRF205A.getR48_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR48_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R48cell10 = R48row.getCell(14);
				   		 if (R48cell10 != null) {
				   	     R48cell10.setCellValue(BRF205A.getR48_other_aed() == null ? 0 :
				   	     	BRF205A.getR48_other_aed().intValue());
				   		 }	
				   	
				   		Cell R48cell11 = R48row.getCell(15);
				   		 if (R48cell11 != null) {
				   	     R48cell11.setCellValue(BRF205A.getR48_other_fcy() == null ? 0 :
				   	     	BRF205A.getR48_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R49//////////////////
				   	  
				   	  Row R49row = sheet.getRow(58);
				   			            
				   		 Cell R49cell = R49row.getCell(4);
				   		 if (R49cell != null) {
				   	     R49cell.setCellValue(BRF205A.getR49_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR49_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R49cell1 = R49row.getCell(5);
				   		 if (R49cell1 != null) {
				   	     R49cell1.setCellValue(BRF205A.getR49_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR49_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R49cell2 = R49row.getCell(6);
				   		 if (R49cell2 != null) {
				   	     R49cell2.setCellValue(BRF205A.getR49_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR49_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R49cell3 = R49row.getCell(7);
				   		 if (R49cell3 != null) {
				   	     R49cell3.setCellValue(BRF205A.getR49_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR49_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R49cell4 = R49row.getCell(8);
				   		 if (R49cell4 != null) {
				   	     R49cell4.setCellValue(BRF205A.getR49_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR49_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R49cell5 = R49row.getCell(9);
				   		 if (R49cell5 != null) {
				   	     R49cell5.setCellValue(BRF205A.getR49_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR49_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R49cell6 = R49row.getCell(10);
				   		 if (R49cell6 != null) {
				   	     R49cell6.setCellValue(BRF205A.getR49_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR49_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R49cell7 = R49row.getCell(11);
				   		 if (R49cell7 != null) {
				   	     R49cell7.setCellValue(BRF205A.getR49_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR49_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R49cell8 = R49row.getCell(12);
				   		 if (R49cell8 != null) {
				   	     R49cell8.setCellValue(BRF205A.getR49_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR49_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R49cell9 = R49row.getCell(13);
				   		 if (R49cell9 != null) {
				   	     R49cell9.setCellValue(BRF205A.getR49_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR49_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R49cell10 = R49row.getCell(14);
				   		 if (R49cell10 != null) {
				   	     R49cell10.setCellValue(BRF205A.getR49_other_aed() == null ? 0 :
				   	     	BRF205A.getR49_other_aed().intValue());
				   		 }	
				   	
				   		Cell R49cell11 = R49row.getCell(15);
				   		 if (R49cell11 != null) {
				   	     R49cell11.setCellValue(BRF205A.getR49_other_fcy() == null ? 0 :
				   	     	BRF205A.getR49_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R50//////////////////
				   	  
				   	  Row R50row = sheet.getRow(59);
				   			            
				   		 Cell R50cell = R50row.getCell(4);
				   		 if (R50cell != null) {
				   	     R50cell.setCellValue(BRF205A.getR50_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR50_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R50cell1 = R50row.getCell(5);
				   		 if (R50cell1 != null) {
				   	     R50cell1.setCellValue(BRF205A.getR50_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR50_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R50cell2 = R50row.getCell(6);
				   		 if (R50cell2 != null) {
				   	     R50cell2.setCellValue(BRF205A.getR50_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR50_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R50cell3 = R50row.getCell(7);
				   		 if (R50cell3 != null) {
				   	     R50cell3.setCellValue(BRF205A.getR50_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR50_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R50cell4 = R50row.getCell(8);
				   		 if (R50cell4 != null) {
				   	     R50cell4.setCellValue(BRF205A.getR50_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR50_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R50cell5 = R50row.getCell(9);
				   		 if (R50cell5 != null) {
				   	     R50cell5.setCellValue(BRF205A.getR50_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR50_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R50cell6 = R50row.getCell(10);
				   		 if (R50cell6 != null) {
				   	     R50cell6.setCellValue(BRF205A.getR50_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR50_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R50cell7 = R50row.getCell(11);
				   		 if (R50cell7 != null) {
				   	     R50cell7.setCellValue(BRF205A.getR50_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR50_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R50cell8 = R50row.getCell(12);
				   		 if (R50cell8 != null) {
				   	     R50cell8.setCellValue(BRF205A.getR50_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR50_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R50cell9 = R50row.getCell(13);
				   		 if (R50cell9 != null) {
				   	     R50cell9.setCellValue(BRF205A.getR50_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR50_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R50cell10 = R50row.getCell(14);
				   		 if (R50cell10 != null) {
				   	     R50cell10.setCellValue(BRF205A.getR50_other_aed() == null ? 0 :
				   	     	BRF205A.getR50_other_aed().intValue());
				   		 }	
				   	
				   		Cell R50cell11 = R50row.getCell(15);
				   		 if (R50cell11 != null) {
				   	     R50cell11.setCellValue(BRF205A.getR50_other_fcy() == null ? 0 :
				   	     	BRF205A.getR50_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R51//////////////////
				   	  
				   	  Row R51row = sheet.getRow(60);
				   			            
				   		 Cell R51cell = R51row.getCell(4);
				   		 if (R51cell != null) {
				   	     R51cell.setCellValue(BRF205A.getR51_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR51_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R51cell1 = R51row.getCell(5);
				   		 if (R51cell1 != null) {
				   	     R51cell1.setCellValue(BRF205A.getR51_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR51_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R51cell2 = R51row.getCell(6);
				   		 if (R51cell2 != null) {
				   	     R51cell2.setCellValue(BRF205A.getR51_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR51_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R51cell3 = R51row.getCell(7);
				   		 if (R51cell3 != null) {
				   	     R51cell3.setCellValue(BRF205A.getR51_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR51_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R51cell4 = R51row.getCell(8);
				   		 if (R51cell4 != null) {
				   	     R51cell4.setCellValue(BRF205A.getR51_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR51_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R51cell5 = R51row.getCell(9);
				   		 if (R51cell5 != null) {
				   	     R51cell5.setCellValue(BRF205A.getR51_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR51_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R51cell6 = R51row.getCell(10);
				   		 if (R51cell6 != null) {
				   	     R51cell6.setCellValue(BRF205A.getR51_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR51_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R51cell7 = R51row.getCell(11);
				   		 if (R51cell7 != null) {
				   	     R51cell7.setCellValue(BRF205A.getR51_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR51_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R51cell8 = R51row.getCell(12);
				   		 if (R51cell8 != null) {
				   	     R51cell8.setCellValue(BRF205A.getR51_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR51_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R51cell9 = R51row.getCell(13);
				   		 if (R51cell9 != null) {
				   	     R51cell9.setCellValue(BRF205A.getR51_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR51_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R51cell10 = R51row.getCell(14);
				   		 if (R51cell10 != null) {
				   	     R51cell10.setCellValue(BRF205A.getR51_other_aed() == null ? 0 :
				   	     	BRF205A.getR51_other_aed().intValue());
				   		 }	
				   	
				   		Cell R51cell11 = R51row.getCell(15);
				   		 if (R51cell11 != null) {
				   	     R51cell11.setCellValue(BRF205A.getR51_other_fcy() == null ? 0 :
				   	     	BRF205A.getR51_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R52//////////////////
				   	  
				   	  Row R52row = sheet.getRow(61);
				   			            
				   		 Cell R52cell = R52row.getCell(4);
				   		 if (R52cell != null) {
				   	     R52cell.setCellValue(BRF205A.getR52_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR52_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R52cell1 = R52row.getCell(5);
				   		 if (R52cell1 != null) {
				   	     R52cell1.setCellValue(BRF205A.getR52_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR52_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R52cell2 = R52row.getCell(6);
				   		 if (R52cell2 != null) {
				   	     R52cell2.setCellValue(BRF205A.getR52_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR52_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R52cell3 = R52row.getCell(7);
				   		 if (R52cell3 != null) {
				   	     R52cell3.setCellValue(BRF205A.getR52_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR52_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R52cell4 = R52row.getCell(8);
				   		 if (R52cell4 != null) {
				   	     R52cell4.setCellValue(BRF205A.getR52_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR52_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R52cell5 = R52row.getCell(9);
				   		 if (R52cell5 != null) {
				   	     R52cell5.setCellValue(BRF205A.getR52_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR52_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R52cell6 = R52row.getCell(10);
				   		 if (R52cell6 != null) {
				   	     R52cell6.setCellValue(BRF205A.getR52_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR52_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R52cell7 = R52row.getCell(11);
				   		 if (R52cell7 != null) {
				   	     R52cell7.setCellValue(BRF205A.getR52_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR52_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R52cell8 = R52row.getCell(12);
				   		 if (R52cell8 != null) {
				   	     R52cell8.setCellValue(BRF205A.getR52_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR52_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R52cell9 = R52row.getCell(13);
				   		 if (R52cell9 != null) {
				   	     R52cell9.setCellValue(BRF205A.getR52_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR52_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R52cell10 = R52row.getCell(14);
				   		 if (R52cell10 != null) {
				   	     R52cell10.setCellValue(BRF205A.getR52_other_aed() == null ? 0 :
				   	     	BRF205A.getR52_other_aed().intValue());
				   		 }	
				   	
				   		Cell R52cell11 = R52row.getCell(15);
				   		 if (R52cell11 != null) {
				   	     R52cell11.setCellValue(BRF205A.getR52_other_fcy() == null ? 0 :
				   	     	BRF205A.getR52_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R54//////////////////
				   	  
				   	  Row R54row = sheet.getRow(63);
				   			            
				   		 Cell R54cell = R54row.getCell(4);
				   		 if (R54cell != null) {
				   	     R54cell.setCellValue(BRF205A.getR54_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR54_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R54cell1 = R54row.getCell(5);
				   		 if (R54cell1 != null) {
				   	     R54cell1.setCellValue(BRF205A.getR54_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR54_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R54cell2 = R54row.getCell(6);
				   		 if (R54cell2 != null) {
				   	     R54cell2.setCellValue(BRF205A.getR54_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR54_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R54cell3 = R54row.getCell(7);
				   		 if (R54cell3 != null) {
				   	     R54cell3.setCellValue(BRF205A.getR54_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR54_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R54cell4 = R54row.getCell(8);
				   		 if (R54cell4 != null) {
				   	     R54cell4.setCellValue(BRF205A.getR54_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR54_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R54cell5 = R54row.getCell(9);
				   		 if (R54cell5 != null) {
				   	     R54cell5.setCellValue(BRF205A.getR54_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR54_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R54cell6 = R54row.getCell(10);
				   		 if (R54cell6 != null) {
				   	     R54cell6.setCellValue(BRF205A.getR54_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR54_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R54cell7 = R54row.getCell(11);
				   		 if (R54cell7 != null) {
				   	     R54cell7.setCellValue(BRF205A.getR54_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR54_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R54cell8 = R54row.getCell(12);
				   		 if (R54cell8 != null) {
				   	     R54cell8.setCellValue(BRF205A.getR54_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR54_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R54cell9 = R54row.getCell(13);
				   		 if (R54cell9 != null) {
				   	     R54cell9.setCellValue(BRF205A.getR54_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR54_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R54cell10 = R54row.getCell(14);
				   		 if (R54cell10 != null) {
				   	     R54cell10.setCellValue(BRF205A.getR54_other_aed() == null ? 0 :
				   	     	BRF205A.getR54_other_aed().intValue());
				   		 }	
				   	
				   		Cell R54cell11 = R54row.getCell(15);
				   		 if (R54cell11 != null) {
				   	     R54cell11.setCellValue(BRF205A.getR54_other_fcy() == null ? 0 :
				   	     	BRF205A.getR54_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R55//////////////////
				   	  
				   	  Row R55row = sheet.getRow(64);
				   			            
				   		 Cell R55cell = R55row.getCell(4);
				   		 if (R55cell != null) {
				   	     R55cell.setCellValue(BRF205A.getR55_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR55_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R55cell1 = R55row.getCell(5);
				   		 if (R55cell1 != null) {
				   	     R55cell1.setCellValue(BRF205A.getR55_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR55_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R55cell2 = R55row.getCell(6);
				   		 if (R55cell2 != null) {
				   	     R55cell2.setCellValue(BRF205A.getR55_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR55_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R55cell3 = R55row.getCell(7);
				   		 if (R55cell3 != null) {
				   	     R55cell3.setCellValue(BRF205A.getR55_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR55_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R55cell4 = R55row.getCell(8);
				   		 if (R55cell4 != null) {
				   	     R55cell4.setCellValue(BRF205A.getR55_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR55_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R55cell5 = R55row.getCell(9);
				   		 if (R55cell5 != null) {
				   	     R55cell5.setCellValue(BRF205A.getR55_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR55_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R55cell6 = R55row.getCell(10);
				   		 if (R55cell6 != null) {
				   	     R55cell6.setCellValue(BRF205A.getR55_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR55_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R55cell7 = R55row.getCell(11);
				   		 if (R55cell7 != null) {
				   	     R55cell7.setCellValue(BRF205A.getR55_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR55_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R55cell8 = R55row.getCell(12);
				   		 if (R55cell8 != null) {
				   	     R55cell8.setCellValue(BRF205A.getR55_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR55_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R55cell9 = R55row.getCell(13);
				   		 if (R55cell9 != null) {
				   	     R55cell9.setCellValue(BRF205A.getR55_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR55_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R55cell10 = R55row.getCell(14);
				   		 if (R55cell10 != null) {
				   	     R55cell10.setCellValue(BRF205A.getR55_other_aed() == null ? 0 :
				   	     	BRF205A.getR55_other_aed().intValue());
				   		 }	
				   	
				   		Cell R55cell11 = R55row.getCell(15);
				   		 if (R55cell11 != null) {
				   	     R55cell11.setCellValue(BRF205A.getR55_other_fcy() == null ? 0 :
				   	     	BRF205A.getR55_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   	  /////////////////////R56//////////////////
				   	  
				   	  Row R56row = sheet.getRow(65);
				   			            
				   		 Cell R56cell = R56row.getCell(4);
				   		 if (R56cell != null) {
				   	     R56cell.setCellValue(BRF205A.getR56_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR56_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R56cell1 = R56row.getCell(5);
				   		 if (R56cell1 != null) {
				   	     R56cell1.setCellValue(BRF205A.getR56_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR56_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R56cell2 = R56row.getCell(6);
				   		 if (R56cell2 != null) {
				   	     R56cell2.setCellValue(BRF205A.getR56_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR56_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R56cell3 = R56row.getCell(7);
				   		 if (R56cell3 != null) {
				   	     R56cell3.setCellValue(BRF205A.getR56_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR56_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R56cell4 = R56row.getCell(8);
				   		 if (R56cell4 != null) {
				   	     R56cell4.setCellValue(BRF205A.getR56_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR56_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R56cell5 = R56row.getCell(9);
				   		 if (R56cell5 != null) {
				   	     R56cell5.setCellValue(BRF205A.getR56_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR56_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R56cell6 = R56row.getCell(10);
				   		 if (R56cell6 != null) {
				   	     R56cell6.setCellValue(BRF205A.getR56_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR56_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R56cell7 = R56row.getCell(11);
				   		 if (R56cell7 != null) {
				   	     R56cell7.setCellValue(BRF205A.getR56_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR56_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R56cell8 = R56row.getCell(12);
				   		 if (R56cell8 != null) {
				   	     R56cell8.setCellValue(BRF205A.getR56_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR56_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R56cell9 = R56row.getCell(13);
				   		 if (R56cell9 != null) {
				   	     R56cell9.setCellValue(BRF205A.getR56_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR56_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R56cell10 = R56row.getCell(14);
				   		 if (R56cell10 != null) {
				   	     R56cell10.setCellValue(BRF205A.getR56_other_aed() == null ? 0 :
				   	     	BRF205A.getR56_other_aed().intValue());
				   		 }	
				   	
				   		Cell R56cell11 = R56row.getCell(15);
				   		 if (R56cell11 != null) {
				   	     R56cell11.setCellValue(BRF205A.getR56_other_fcy() == null ? 0 :
				   	     	BRF205A.getR56_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R57//////////////////
				   	  
				   	  Row R57row = sheet.getRow(66);
				   			            
				   		 Cell R57cell = R57row.getCell(4);
				   		 if (R57cell != null) {
				   	     R57cell.setCellValue(BRF205A.getR57_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR57_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R57cell1 = R57row.getCell(5);
				   		 if (R57cell1 != null) {
				   	     R57cell1.setCellValue(BRF205A.getR57_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR57_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R57cell2 = R57row.getCell(6);
				   		 if (R57cell2 != null) {
				   	     R57cell2.setCellValue(BRF205A.getR57_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR57_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R57cell3 = R57row.getCell(7);
				   		 if (R57cell3 != null) {
				   	     R57cell3.setCellValue(BRF205A.getR57_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR57_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R57cell4 = R57row.getCell(8);
				   		 if (R57cell4 != null) {
				   	     R57cell4.setCellValue(BRF205A.getR57_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR57_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R57cell5 = R57row.getCell(9);
				   		 if (R57cell5 != null) {
				   	     R57cell5.setCellValue(BRF205A.getR57_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR57_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R57cell6 = R57row.getCell(10);
				   		 if (R57cell6 != null) {
				   	     R57cell6.setCellValue(BRF205A.getR57_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR57_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R57cell7 = R57row.getCell(11);
				   		 if (R57cell7 != null) {
				   	     R57cell7.setCellValue(BRF205A.getR57_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR57_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R57cell8 = R57row.getCell(12);
				   		 if (R57cell8 != null) {
				   	     R57cell8.setCellValue(BRF205A.getR57_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR57_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R57cell9 = R57row.getCell(13);
				   		 if (R57cell9 != null) {
				   	     R57cell9.setCellValue(BRF205A.getR57_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR57_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R57cell10 = R57row.getCell(14);
				   		 if (R57cell10 != null) {
				   	     R57cell10.setCellValue(BRF205A.getR57_other_aed() == null ? 0 :
				   	     	BRF205A.getR57_other_aed().intValue());
				   		 }	
				   	
				   		Cell R57cell11 = R57row.getCell(15);
				   		 if (R57cell11 != null) {
				   	     R57cell11.setCellValue(BRF205A.getR57_other_fcy() == null ? 0 :
				   	     	BRF205A.getR57_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R58//////////////////
				   	  
				   	  Row R58row = sheet.getRow(67);
				   			            
				   		 Cell R58cell = R58row.getCell(4);
				   		 if (R58cell != null) {
				   	     R58cell.setCellValue(BRF205A.getR58_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR58_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R58cell1 = R58row.getCell(5);
				   		 if (R58cell1 != null) {
				   	     R58cell1.setCellValue(BRF205A.getR58_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR58_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R58cell2 = R58row.getCell(6);
				   		 if (R58cell2 != null) {
				   	     R58cell2.setCellValue(BRF205A.getR58_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR58_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R58cell3 = R58row.getCell(7);
				   		 if (R58cell3 != null) {
				   	     R58cell3.setCellValue(BRF205A.getR58_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR58_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R58cell4 = R58row.getCell(8);
				   		 if (R58cell4 != null) {
				   	     R58cell4.setCellValue(BRF205A.getR58_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR58_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R58cell5 = R58row.getCell(9);
				   		 if (R58cell5 != null) {
				   	     R58cell5.setCellValue(BRF205A.getR58_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR58_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R58cell6 = R58row.getCell(10);
				   		 if (R58cell6 != null) {
				   	     R58cell6.setCellValue(BRF205A.getR58_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR58_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R58cell7 = R58row.getCell(11);
				   		 if (R58cell7 != null) {
				   	     R58cell7.setCellValue(BRF205A.getR58_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR58_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R58cell8 = R58row.getCell(12);
				   		 if (R58cell8 != null) {
				   	     R58cell8.setCellValue(BRF205A.getR58_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR58_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R58cell9 = R58row.getCell(13);
				   		 if (R58cell9 != null) {
				   	     R58cell9.setCellValue(BRF205A.getR58_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR58_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R58cell10 = R58row.getCell(14);
				   		 if (R58cell10 != null) {
				   	     R58cell10.setCellValue(BRF205A.getR58_other_aed() == null ? 0 :
				   	     	BRF205A.getR58_other_aed().intValue());
				   		 }	
				   	
				   		Cell R58cell11 = R58row.getCell(15);
				   		 if (R58cell11 != null) {
				   	     R58cell11.setCellValue(BRF205A.getR58_other_fcy() == null ? 0 :
				   	     	BRF205A.getR58_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R59//////////////////
				   	  
				   	  Row R59row = sheet.getRow(68);
				   			            
				   		 Cell R59cell = R59row.getCell(4);
				   		 if (R59cell != null) {
				   	     R59cell.setCellValue(BRF205A.getR59_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR59_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R59cell1 = R59row.getCell(5);
				   		 if (R59cell1 != null) {
				   	     R59cell1.setCellValue(BRF205A.getR59_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR59_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R59cell2 = R59row.getCell(6);
				   		 if (R59cell2 != null) {
				   	     R59cell2.setCellValue(BRF205A.getR59_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR59_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R59cell3 = R59row.getCell(7);
				   		 if (R59cell3 != null) {
				   	     R59cell3.setCellValue(BRF205A.getR59_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR59_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R59cell4 = R59row.getCell(8);
				   		 if (R59cell4 != null) {
				   	     R59cell4.setCellValue(BRF205A.getR59_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR59_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R59cell5 = R59row.getCell(9);
				   		 if (R59cell5 != null) {
				   	     R59cell5.setCellValue(BRF205A.getR59_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR59_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R59cell6 = R59row.getCell(10);
				   		 if (R59cell6 != null) {
				   	     R59cell6.setCellValue(BRF205A.getR59_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR59_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R59cell7 = R59row.getCell(11);
				   		 if (R59cell7 != null) {
				   	     R59cell7.setCellValue(BRF205A.getR59_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR59_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R59cell8 = R59row.getCell(12);
				   		 if (R59cell8 != null) {
				   	     R59cell8.setCellValue(BRF205A.getR59_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR59_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R59cell9 = R59row.getCell(13);
				   		 if (R59cell9 != null) {
				   	     R59cell9.setCellValue(BRF205A.getR59_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR59_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R59cell10 = R59row.getCell(14);
				   		 if (R59cell10 != null) {
				   	     R59cell10.setCellValue(BRF205A.getR59_other_aed() == null ? 0 :
				   	     	BRF205A.getR59_other_aed().intValue());
				   		 }	
				   	
				   		Cell R59cell11 = R59row.getCell(15);
				   		 if (R59cell11 != null) {
				   	     R59cell11.setCellValue(BRF205A.getR59_other_fcy() == null ? 0 :
				   	     	BRF205A.getR59_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R60//////////////////
				   	  
				   	  Row R60row = sheet.getRow(69);
				   			            
				   		 Cell R60cell = R60row.getCell(4);
				   		 if (R60cell != null) {
				   	     R60cell.setCellValue(BRF205A.getR60_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR60_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R60cell1 = R60row.getCell(5);
				   		 if (R60cell1 != null) {
				   	     R60cell1.setCellValue(BRF205A.getR60_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR60_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R60cell2 = R60row.getCell(6);
				   		 if (R60cell2 != null) {
				   	     R60cell2.setCellValue(BRF205A.getR60_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR60_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R60cell3 = R60row.getCell(7);
				   		 if (R60cell3 != null) {
				   	     R60cell3.setCellValue(BRF205A.getR60_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR60_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R60cell4 = R60row.getCell(8);
				   		 if (R60cell4 != null) {
				   	     R60cell4.setCellValue(BRF205A.getR60_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR60_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R60cell5 = R60row.getCell(9);
				   		 if (R60cell5 != null) {
				   	     R60cell5.setCellValue(BRF205A.getR60_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR60_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R60cell6 = R60row.getCell(10);
				   		 if (R60cell6 != null) {
				   	     R60cell6.setCellValue(BRF205A.getR60_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR60_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R60cell7 = R60row.getCell(11);
				   		 if (R60cell7 != null) {
				   	     R60cell7.setCellValue(BRF205A.getR60_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR60_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R60cell8 = R60row.getCell(12);
				   		 if (R60cell8 != null) {
				   	     R60cell8.setCellValue(BRF205A.getR60_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR60_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R60cell9 = R60row.getCell(13);
				   		 if (R60cell9 != null) {
				   	     R60cell9.setCellValue(BRF205A.getR60_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR60_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R60cell10 = R60row.getCell(14);
				   		 if (R60cell10 != null) {
				   	     R60cell10.setCellValue(BRF205A.getR60_other_aed() == null ? 0 :
				   	     	BRF205A.getR60_other_aed().intValue());
				   		 }	
				   	
				   		Cell R60cell11 = R60row.getCell(15);
				   		 if (R60cell11 != null) {
				   	     R60cell11.setCellValue(BRF205A.getR60_other_fcy() == null ? 0 :
				   	     	BRF205A.getR60_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R61//////////////////
				   	  
				   	  Row R61row = sheet.getRow(70);
				   			            
				   		 Cell R61cell = R61row.getCell(4);
				   		 if (R61cell != null) {
				   	     R61cell.setCellValue(BRF205A.getR61_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR61_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R61cell1 = R61row.getCell(5);
				   		 if (R61cell1 != null) {
				   	     R61cell1.setCellValue(BRF205A.getR61_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR61_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R61cell2 = R61row.getCell(6);
				   		 if (R61cell2 != null) {
				   	     R61cell2.setCellValue(BRF205A.getR61_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR61_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R61cell3 = R61row.getCell(7);
				   		 if (R61cell3 != null) {
				   	     R61cell3.setCellValue(BRF205A.getR61_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR61_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R61cell4 = R61row.getCell(8);
				   		 if (R61cell4 != null) {
				   	     R61cell4.setCellValue(BRF205A.getR61_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR61_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R61cell5 = R61row.getCell(9);
				   		 if (R61cell5 != null) {
				   	     R61cell5.setCellValue(BRF205A.getR61_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR61_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R61cell6 = R61row.getCell(10);
				   		 if (R61cell6 != null) {
				   	     R61cell6.setCellValue(BRF205A.getR61_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR61_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R61cell7 = R61row.getCell(11);
				   		 if (R61cell7 != null) {
				   	     R61cell7.setCellValue(BRF205A.getR61_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR61_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R61cell8 = R61row.getCell(12);
				   		 if (R61cell8 != null) {
				   	     R61cell8.setCellValue(BRF205A.getR61_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR61_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R61cell9 = R61row.getCell(13);
				   		 if (R61cell9 != null) {
				   	     R61cell9.setCellValue(BRF205A.getR61_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR61_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R61cell10 = R61row.getCell(14);
				   		 if (R61cell10 != null) {
				   	     R61cell10.setCellValue(BRF205A.getR61_other_aed() == null ? 0 :
				   	     	BRF205A.getR61_other_aed().intValue());
				   		 }	
				   	
				   		Cell R61cell11 = R61row.getCell(15);
				   		 if (R61cell11 != null) {
				   	     R61cell11.setCellValue(BRF205A.getR61_other_fcy() == null ? 0 :
				   	     	BRF205A.getR61_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R62//////////////////
				   	  
				   	  Row R62row = sheet.getRow(71);
				   			            
				   		 Cell R62cell = R62row.getCell(4);
				   		 if (R62cell != null) {
				   	     R62cell.setCellValue(BRF205A.getR62_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR62_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R62cell1 = R62row.getCell(5);
				   		 if (R62cell1 != null) {
				   	     R62cell1.setCellValue(BRF205A.getR62_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR62_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R62cell2 = R62row.getCell(6);
				   		 if (R62cell2 != null) {
				   	     R62cell2.setCellValue(BRF205A.getR62_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR62_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R62cell3 = R62row.getCell(7);
				   		 if (R62cell3 != null) {
				   	     R62cell3.setCellValue(BRF205A.getR62_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR62_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R62cell4 = R62row.getCell(8);
				   		 if (R62cell4 != null) {
				   	     R62cell4.setCellValue(BRF205A.getR62_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR62_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R62cell5 = R62row.getCell(9);
				   		 if (R62cell5 != null) {
				   	     R62cell5.setCellValue(BRF205A.getR62_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR62_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R62cell6 = R62row.getCell(10);
				   		 if (R62cell6 != null) {
				   	     R62cell6.setCellValue(BRF205A.getR62_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR62_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R62cell7 = R62row.getCell(11);
				   		 if (R62cell7 != null) {
				   	     R62cell7.setCellValue(BRF205A.getR62_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR62_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R62cell8 = R62row.getCell(12);
				   		 if (R62cell8 != null) {
				   	     R62cell8.setCellValue(BRF205A.getR62_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR62_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R62cell9 = R62row.getCell(13);
				   		 if (R62cell9 != null) {
				   	     R62cell9.setCellValue(BRF205A.getR62_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR62_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R62cell10 = R62row.getCell(14);
				   		 if (R62cell10 != null) {
				   	     R62cell10.setCellValue(BRF205A.getR62_other_aed() == null ? 0 :
				   	     	BRF205A.getR62_other_aed().intValue());
				   		 }	
				   	
				   		Cell R62cell11 = R62row.getCell(15);
				   		 if (R62cell11 != null) {
				   	     R62cell11.setCellValue(BRF205A.getR62_other_fcy() == null ? 0 :
				   	     	BRF205A.getR62_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R64//////////////////
				   	  
				   	  Row R64row = sheet.getRow(73);
				   			            
				   		 Cell R64cell = R64row.getCell(4);
				   		 if (R64cell != null) {
				   	     R64cell.setCellValue(BRF205A.getR64_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR64_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R64cell1 = R64row.getCell(5);
				   		 if (R64cell1 != null) {
				   	     R64cell1.setCellValue(BRF205A.getR64_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR64_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R64cell2 = R64row.getCell(6);
				   		 if (R64cell2 != null) {
				   	     R64cell2.setCellValue(BRF205A.getR64_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR64_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R64cell3 = R64row.getCell(7);
				   		 if (R64cell3 != null) {
				   	     R64cell3.setCellValue(BRF205A.getR64_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR64_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R64cell4 = R64row.getCell(8);
				   		 if (R64cell4 != null) {
				   	     R64cell4.setCellValue(BRF205A.getR64_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR64_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R64cell5 = R64row.getCell(9);
				   		 if (R64cell5 != null) {
				   	     R64cell5.setCellValue(BRF205A.getR64_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR64_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R64cell6 = R64row.getCell(10);
				   		 if (R64cell6 != null) {
				   	     R64cell6.setCellValue(BRF205A.getR64_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR64_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R64cell7 = R64row.getCell(11);
				   		 if (R64cell7 != null) {
				   	     R64cell7.setCellValue(BRF205A.getR64_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR64_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R64cell8 = R64row.getCell(12);
				   		 if (R64cell8 != null) {
				   	     R64cell8.setCellValue(BRF205A.getR64_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR64_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R64cell9 = R64row.getCell(13);
				   		 if (R64cell9 != null) {
				   	     R64cell9.setCellValue(BRF205A.getR64_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR64_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R64cell10 = R64row.getCell(14);
				   		 if (R64cell10 != null) {
				   	     R64cell10.setCellValue(BRF205A.getR64_other_aed() == null ? 0 :
				   	     	BRF205A.getR64_other_aed().intValue());
				   		 }	
				   	
				   		Cell R64cell11 = R64row.getCell(15);
				   		 if (R64cell11 != null) {
				   	     R64cell11.setCellValue(BRF205A.getR64_other_fcy() == null ? 0 :
				   	     	BRF205A.getR64_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R65//////////////////
				   	  
				   	  Row R65row = sheet.getRow(74);
				   			            
				   		 Cell R65cell = R65row.getCell(4);
				   		 if (R65cell != null) {
				   	     R65cell.setCellValue(BRF205A.getR65_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR65_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R65cell1 = R65row.getCell(5);
				   		 if (R65cell1 != null) {
				   	     R65cell1.setCellValue(BRF205A.getR65_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR65_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R65cell2 = R65row.getCell(6);
				   		 if (R65cell2 != null) {
				   	     R65cell2.setCellValue(BRF205A.getR65_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR65_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R65cell3 = R65row.getCell(7);
				   		 if (R65cell3 != null) {
				   	     R65cell3.setCellValue(BRF205A.getR65_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR65_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R65cell4 = R65row.getCell(8);
				   		 if (R65cell4 != null) {
				   	     R65cell4.setCellValue(BRF205A.getR65_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR65_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R65cell5 = R65row.getCell(9);
				   		 if (R65cell5 != null) {
				   	     R65cell5.setCellValue(BRF205A.getR65_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR65_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R65cell6 = R65row.getCell(10);
				   		 if (R65cell6 != null) {
				   	     R65cell6.setCellValue(BRF205A.getR65_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR65_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R65cell7 = R65row.getCell(11);
				   		 if (R65cell7 != null) {
				   	     R65cell7.setCellValue(BRF205A.getR65_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR65_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R65cell8 = R65row.getCell(12);
				   		 if (R65cell8 != null) {
				   	     R65cell8.setCellValue(BRF205A.getR65_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR65_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R65cell9 = R65row.getCell(13);
				   		 if (R65cell9 != null) {
				   	     R65cell9.setCellValue(BRF205A.getR65_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR65_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R65cell10 = R65row.getCell(14);
				   		 if (R65cell10 != null) {
				   	     R65cell10.setCellValue(BRF205A.getR65_other_aed() == null ? 0 :
				   	     	BRF205A.getR65_other_aed().intValue());
				   		 }	
				   	
				   		Cell R65cell11 = R65row.getCell(15);
				   		 if (R65cell11 != null) {
				   	     R65cell11.setCellValue(BRF205A.getR65_other_fcy() == null ? 0 :
				   	     	BRF205A.getR65_other_fcy().intValue());
				   		 }	
				   		 
				   	  /////////////////////R66//////////////////
				   	  
				   	  Row R66row = sheet.getRow(75);
				   			            
				   		 Cell R66cell = R66row.getCell(4);
				   		 if (R66cell != null) {
				   	     R66cell.setCellValue(BRF205A.getR66_gcc_ksa_aed() == null ? 0 :
				   	     	BRF205A.getR66_gcc_ksa_aed().intValue());
				   		 }	
				   	
				   		Cell R66cell1 = R66row.getCell(5);
				   		 if (R66cell1 != null) {
				   	     R66cell1.setCellValue(BRF205A.getR66_gcc_ksa_fcy() == null ? 0 :
				   	     	BRF205A.getR66_gcc_ksa_fcy().intValue());
				   		 }	
				   	
				   		Cell R66cell2 = R66row.getCell(6);
				   		 if (R66cell2 != null) {
				   	     R66cell2.setCellValue(BRF205A.getR66_gcc_oman_aed() == null ? 0 :
				   	     	BRF205A.getR66_gcc_oman_aed().intValue());
				   		 }	
				   	
				   		Cell R66cell3 = R66row.getCell(7);
				   		 if (R66cell3 != null) {
				   	     R66cell3.setCellValue(BRF205A.getR66_gcc_oman_fcy() == null ? 0 :
				   	     	BRF205A.getR66_gcc_oman_fcy().intValue());
				   		 }	
				   	
				   		Cell R66cell4 = R66row.getCell(8);
				   		 if (R66cell4 != null) {
				   	     R66cell4.setCellValue(BRF205A.getR66_gcc_kuwait_aed() == null ? 0 :
				   	     	BRF205A.getR66_gcc_kuwait_aed().intValue());
				   		 }	
				   	
				   		Cell R66cell5 = R66row.getCell(9);
				   		 if (R66cell5 != null) {
				   	     R66cell5.setCellValue(BRF205A.getR66_gcc_kuwait_fcy() == null ? 0 :
				   	     	BRF205A.getR66_gcc_kuwait_fcy().intValue());
				   		 }	
				   	
				   		Cell R66cell6 = R66row.getCell(10);
				   		 if (R66cell6 != null) {
				   	     R66cell6.setCellValue(BRF205A.getR66_gcc_qatar_aed() == null ? 0 :
				   	     	BRF205A.getR66_gcc_qatar_aed().intValue());
				   		 }	
				   	
				   		Cell R66cell7 = R66row.getCell(11);
				   		 if (R66cell7 != null) {
				   	     R66cell7.setCellValue(BRF205A.getR66_gcc_qatar_fcy() == null ? 0 :
				   	     	BRF205A.getR66_gcc_qatar_fcy().intValue());
				   		 }	
				   	
				   		Cell R66cell8 = R66row.getCell(12);
				   		 if (R66cell8 != null) {
				   	     R66cell8.setCellValue(BRF205A.getR66_gcc_bahrain_aed() == null ? 0 :
				   	     	BRF205A.getR66_gcc_bahrain_aed().intValue());
				   		 }	
				   	
				   		Cell R66cell9 = R66row.getCell(13);
				   		 if (R66cell9 != null) {
				   	     R66cell9.setCellValue(BRF205A.getR66_gcc_bahrain_fcy() == null ? 0 :
				   	     	BRF205A.getR66_gcc_bahrain_fcy().intValue());
				   		 }	
				   	
				   		Cell R66cell10 = R66row.getCell(14);
				   		 if (R66cell10 != null) {
				   	     R66cell10.setCellValue(BRF205A.getR66_other_aed() == null ? 0 :
				   	     	BRF205A.getR66_other_aed().intValue());
				   		 }	
				   	
				   		Cell R66cell11 = R66row.getCell(15);
				   		 if (R66cell11 != null) {
				   	     R66cell11.setCellValue(BRF205A.getR66_other_fcy() == null ? 0 :
				   	     	BRF205A.getR66_other_fcy().intValue());
				   		 }	
				   		 
				   		 
				   		 
				   		 
					}
				}
				if (T1Master1.size() == 1) {
					for (BRF205A_A2_RPT BRF205B : T1Master1) {
	/////////////////////R67//////////////////
					   	  
					   	  Row R67row = sheet.getRow(76);
					   			            
					   		 Cell R67cell = R67row.getCell(4);
					   		 if (R67cell != null) {
					   	     R67cell.setCellValue(BRF205B.getR67_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR67_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R67cell1 = R67row.getCell(5);
					   		 if (R67cell1 != null) {
					   	     R67cell1.setCellValue(BRF205B.getR67_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR67_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R67cell2 = R67row.getCell(6);
					   		 if (R67cell2 != null) {
					   	     R67cell2.setCellValue(BRF205B.getR67_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR67_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R67cell3 = R67row.getCell(7);
					   		 if (R67cell3 != null) {
					   	     R67cell3.setCellValue(BRF205B.getR67_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR67_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R67cell4 = R67row.getCell(8);
					   		 if (R67cell4 != null) {
					   	     R67cell4.setCellValue(BRF205B.getR67_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR67_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R67cell5 = R67row.getCell(9);
					   		 if (R67cell5 != null) {
					   	     R67cell5.setCellValue(BRF205B.getR67_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR67_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R67cell6 = R67row.getCell(10);
					   		 if (R67cell6 != null) {
					   	     R67cell6.setCellValue(BRF205B.getR67_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR67_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R67cell7 = R67row.getCell(11);
					   		 if (R67cell7 != null) {
					   	     R67cell7.setCellValue(BRF205B.getR67_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR67_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R67cell8 = R67row.getCell(12);
					   		 if (R67cell8 != null) {
					   	     R67cell8.setCellValue(BRF205B.getR67_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR67_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R67cell9 = R67row.getCell(13);
					   		 if (R67cell9 != null) {
					   	     R67cell9.setCellValue(BRF205B.getR67_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR67_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R67cell10 = R67row.getCell(14);
					   		 if (R67cell10 != null) {
					   	     R67cell10.setCellValue(BRF205B.getR67_other_aed() == null ? 0 :
					   	     	BRF205B.getR67_other_aed().intValue());
					   		 }	
					   	
					   		Cell R67cell11 = R67row.getCell(15);
					   		 if (R67cell11 != null) {
					   	     R67cell11.setCellValue(BRF205B.getR67_other_fcy() == null ? 0 :
					   	     	BRF205B.getR67_other_fcy().intValue());
					   		 }	
					   		 
					   		 
					   	  /////////////////////R68//////////////////
					   	  
					   	  Row R68row = sheet.getRow(77);
					   			            
					   		 Cell R68cell = R68row.getCell(4);
					   		 if (R68cell != null) {
					   	     R68cell.setCellValue(BRF205B.getR68_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR68_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R68cell1 = R68row.getCell(5);
					   		 if (R68cell1 != null) {
					   	     R68cell1.setCellValue(BRF205B.getR68_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR68_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R68cell2 = R68row.getCell(6);
					   		 if (R68cell2 != null) {
					   	     R68cell2.setCellValue(BRF205B.getR68_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR68_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R68cell3 = R68row.getCell(7);
					   		 if (R68cell3 != null) {
					   	     R68cell3.setCellValue(BRF205B.getR68_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR68_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R68cell4 = R68row.getCell(8);
					   		 if (R68cell4 != null) {
					   	     R68cell4.setCellValue(BRF205B.getR68_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR68_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R68cell5 = R68row.getCell(9);
					   		 if (R68cell5 != null) {
					   	     R68cell5.setCellValue(BRF205B.getR68_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR68_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R68cell6 = R68row.getCell(10);
					   		 if (R68cell6 != null) {
					   	     R68cell6.setCellValue(BRF205B.getR68_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR68_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R68cell7 = R68row.getCell(11);
					   		 if (R68cell7 != null) {
					   	     R68cell7.setCellValue(BRF205B.getR68_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR68_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R68cell8 = R68row.getCell(12);
					   		 if (R68cell8 != null) {
					   	     R68cell8.setCellValue(BRF205B.getR68_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR68_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R68cell9 = R68row.getCell(13);
					   		 if (R68cell9 != null) {
					   	     R68cell9.setCellValue(BRF205B.getR68_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR68_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R68cell10 = R68row.getCell(14);
					   		 if (R68cell10 != null) {
					   	     R68cell10.setCellValue(BRF205B.getR68_other_aed() == null ? 0 :
					   	     	BRF205B.getR68_other_aed().intValue());
					   		 }	
					   	
					   		Cell R68cell11 = R68row.getCell(15);
					   		 if (R68cell11 != null) {
					   	     R68cell11.setCellValue(BRF205B.getR68_other_fcy() == null ? 0 :
					   	     	BRF205B.getR68_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R69//////////////////
					   	  
					   	  Row R69row = sheet.getRow(78);
					   			            
					   		 Cell R69cell = R69row.getCell(4);
					   		 if (R69cell != null) {
					   	     R69cell.setCellValue(BRF205B.getR69_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR69_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R69cell1 = R69row.getCell(5);
					   		 if (R69cell1 != null) {
					   	     R69cell1.setCellValue(BRF205B.getR69_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR69_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R69cell2 = R69row.getCell(6);
					   		 if (R69cell2 != null) {
					   	     R69cell2.setCellValue(BRF205B.getR69_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR69_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R69cell3 = R69row.getCell(7);
					   		 if (R69cell3 != null) {
					   	     R69cell3.setCellValue(BRF205B.getR69_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR69_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R69cell4 = R69row.getCell(8);
					   		 if (R69cell4 != null) {
					   	     R69cell4.setCellValue(BRF205B.getR69_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR69_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R69cell5 = R69row.getCell(9);
					   		 if (R69cell5 != null) {
					   	     R69cell5.setCellValue(BRF205B.getR69_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR69_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R69cell6 = R69row.getCell(10);
					   		 if (R69cell6 != null) {
					   	     R69cell6.setCellValue(BRF205B.getR69_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR69_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R69cell7 = R69row.getCell(11);
					   		 if (R69cell7 != null) {
					   	     R69cell7.setCellValue(BRF205B.getR69_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR69_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R69cell8 = R69row.getCell(12);
					   		 if (R69cell8 != null) {
					   	     R69cell8.setCellValue(BRF205B.getR69_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR69_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R69cell9 = R69row.getCell(13);
					   		 if (R69cell9 != null) {
					   	     R69cell9.setCellValue(BRF205B.getR69_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR69_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R69cell10 = R69row.getCell(14);
					   		 if (R69cell10 != null) {
					   	     R69cell10.setCellValue(BRF205B.getR69_other_aed() == null ? 0 :
					   	     	BRF205B.getR69_other_aed().intValue());
					   		 }	
					   	
					   		Cell R69cell11 = R69row.getCell(15);
					   		 if (R69cell11 != null) {
					   	     R69cell11.setCellValue(BRF205B.getR69_other_fcy() == null ? 0 :
					   	     	BRF205B.getR69_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R70//////////////////
					   	  
					   	  Row R70row = sheet.getRow(79);
					   			            
					   		 Cell R70cell = R70row.getCell(4);
					   		 if (R70cell != null) {
					   	     R70cell.setCellValue(BRF205B.getR70_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR70_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R70cell1 = R70row.getCell(5);
					   		 if (R70cell1 != null) {
					   	     R70cell1.setCellValue(BRF205B.getR70_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR70_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R70cell2 = R70row.getCell(6);
					   		 if (R70cell2 != null) {
					   	     R70cell2.setCellValue(BRF205B.getR70_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR70_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R70cell3 = R70row.getCell(7);
					   		 if (R70cell3 != null) {
					   	     R70cell3.setCellValue(BRF205B.getR70_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR70_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R70cell4 = R70row.getCell(8);
					   		 if (R70cell4 != null) {
					   	     R70cell4.setCellValue(BRF205B.getR70_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR70_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R70cell5 = R70row.getCell(9);
					   		 if (R70cell5 != null) {
					   	     R70cell5.setCellValue(BRF205B.getR70_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR70_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R70cell6 = R70row.getCell(10);
					   		 if (R70cell6 != null) {
					   	     R70cell6.setCellValue(BRF205B.getR70_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR70_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R70cell7 = R70row.getCell(11);
					   		 if (R70cell7 != null) {
					   	     R70cell7.setCellValue(BRF205B.getR70_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR70_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R70cell8 = R70row.getCell(12);
					   		 if (R70cell8 != null) {
					   	     R70cell8.setCellValue(BRF205B.getR70_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR70_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R70cell9 = R70row.getCell(13);
					   		 if (R70cell9 != null) {
					   	     R70cell9.setCellValue(BRF205B.getR70_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR70_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R70cell10 = R70row.getCell(14);
					   		 if (R70cell10 != null) {
					   	     R70cell10.setCellValue(BRF205B.getR70_other_aed() == null ? 0 :
					   	     	BRF205B.getR70_other_aed().intValue());
					   		 }	
					   	
					   		Cell R70cell11 = R70row.getCell(15);
					   		 if (R70cell11 != null) {
					   	     R70cell11.setCellValue(BRF205B.getR70_other_fcy() == null ? 0 :
					   	     	BRF205B.getR70_other_fcy().intValue());
					   		 }	
					   		 
					   		 
					   	  /////////////////////R73//////////////////
					   	  
					   	  Row R73row = sheet.getRow(82);
					   			            
					   		 Cell R73cell = R73row.getCell(4);
					   		 if (R73cell != null) {
					   	     R73cell.setCellValue(BRF205B.getR73_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR73_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R73cell1 = R73row.getCell(5);
					   		 if (R73cell1 != null) {
					   	     R73cell1.setCellValue(BRF205B.getR73_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR73_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R73cell2 = R73row.getCell(6);
					   		 if (R73cell2 != null) {
					   	     R73cell2.setCellValue(BRF205B.getR73_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR73_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R73cell3 = R73row.getCell(7);
					   		 if (R73cell3 != null) {
					   	     R73cell3.setCellValue(BRF205B.getR73_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR73_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R73cell4 = R73row.getCell(8);
					   		 if (R73cell4 != null) {
					   	     R73cell4.setCellValue(BRF205B.getR73_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR73_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R73cell5 = R73row.getCell(9);
					   		 if (R73cell5 != null) {
					   	     R73cell5.setCellValue(BRF205B.getR73_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR73_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R73cell6 = R73row.getCell(10);
					   		 if (R73cell6 != null) {
					   	     R73cell6.setCellValue(BRF205B.getR73_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR73_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R73cell7 = R73row.getCell(11);
					   		 if (R73cell7 != null) {
					   	     R73cell7.setCellValue(BRF205B.getR73_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR73_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R73cell8 = R73row.getCell(12);
					   		 if (R73cell8 != null) {
					   	     R73cell8.setCellValue(BRF205B.getR73_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR73_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R73cell9 = R73row.getCell(13);
					   		 if (R73cell9 != null) {
					   	     R73cell9.setCellValue(BRF205B.getR73_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR73_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R73cell10 = R73row.getCell(14);
					   		 if (R73cell10 != null) {
					   	     R73cell10.setCellValue(BRF205B.getR73_other_aed() == null ? 0 :
					   	     	BRF205B.getR73_other_aed().intValue());
					   		 }	
					   	
					   		Cell R73cell11 = R73row.getCell(15);
					   		 if (R73cell11 != null) {
					   	     R73cell11.setCellValue(BRF205B.getR73_other_fcy() == null ? 0 :
					   	     	BRF205B.getR73_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R74//////////////////
					   	  
					   	  Row R74row = sheet.getRow(83);
					   			            
					   		 Cell R74cell = R74row.getCell(4);
					   		 if (R74cell != null) {
					   	     R74cell.setCellValue(BRF205B.getR74_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR74_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R74cell1 = R74row.getCell(5);
					   		 if (R74cell1 != null) {
					   	     R74cell1.setCellValue(BRF205B.getR74_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR74_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R74cell2 = R74row.getCell(6);
					   		 if (R74cell2 != null) {
					   	     R74cell2.setCellValue(BRF205B.getR74_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR74_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R74cell3 = R74row.getCell(7);
					   		 if (R74cell3 != null) {
					   	     R74cell3.setCellValue(BRF205B.getR74_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR74_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R74cell4 = R74row.getCell(8);
					   		 if (R74cell4 != null) {
					   	     R74cell4.setCellValue(BRF205B.getR74_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR74_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R74cell5 = R74row.getCell(9);
					   		 if (R74cell5 != null) {
					   	     R74cell5.setCellValue(BRF205B.getR74_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR74_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R74cell6 = R74row.getCell(10);
					   		 if (R74cell6 != null) {
					   	     R74cell6.setCellValue(BRF205B.getR74_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR74_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R74cell7 = R74row.getCell(11);
					   		 if (R74cell7 != null) {
					   	     R74cell7.setCellValue(BRF205B.getR74_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR74_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R74cell8 = R74row.getCell(12);
					   		 if (R74cell8 != null) {
					   	     R74cell8.setCellValue(BRF205B.getR74_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR74_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R74cell9 = R74row.getCell(13);
					   		 if (R74cell9 != null) {
					   	     R74cell9.setCellValue(BRF205B.getR74_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR74_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R74cell10 = R74row.getCell(14);
					   		 if (R74cell10 != null) {
					   	     R74cell10.setCellValue(BRF205B.getR74_other_aed() == null ? 0 :
					   	     	BRF205B.getR74_other_aed().intValue());
					   		 }	
					   	
					   		Cell R74cell11 = R74row.getCell(15);
					   		 if (R74cell11 != null) {
					   	     R74cell11.setCellValue(BRF205B.getR74_other_fcy() == null ? 0 :
					   	     	BRF205B.getR74_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R76//////////////////
					   	  
					   	  Row R76row = sheet.getRow(85);
					   			            
					   		 Cell R76cell = R76row.getCell(4);
					   		 if (R76cell != null) {
					   	     R76cell.setCellValue(BRF205B.getR76_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR76_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R76cell1 = R76row.getCell(5);
					   		 if (R76cell1 != null) {
					   	     R76cell1.setCellValue(BRF205B.getR76_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR76_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R76cell2 = R76row.getCell(6);
					   		 if (R76cell2 != null) {
					   	     R76cell2.setCellValue(BRF205B.getR76_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR76_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R76cell3 = R76row.getCell(7);
					   		 if (R76cell3 != null) {
					   	     R76cell3.setCellValue(BRF205B.getR76_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR76_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R76cell4 = R76row.getCell(8);
					   		 if (R76cell4 != null) {
					   	     R76cell4.setCellValue(BRF205B.getR76_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR76_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R76cell5 = R76row.getCell(9);
					   		 if (R76cell5 != null) {
					   	     R76cell5.setCellValue(BRF205B.getR76_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR76_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R76cell6 = R76row.getCell(10);
					   		 if (R76cell6 != null) {
					   	     R76cell6.setCellValue(BRF205B.getR76_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR76_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R76cell7 = R76row.getCell(11);
					   		 if (R76cell7 != null) {
					   	     R76cell7.setCellValue(BRF205B.getR76_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR76_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R76cell8 = R76row.getCell(12);
					   		 if (R76cell8 != null) {
					   	     R76cell8.setCellValue(BRF205B.getR76_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR76_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R76cell9 = R76row.getCell(13);
					   		 if (R76cell9 != null) {
					   	     R76cell9.setCellValue(BRF205B.getR76_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR76_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R76cell10 = R76row.getCell(14);
					   		 if (R76cell10 != null) {
					   	     R76cell10.setCellValue(BRF205B.getR76_other_aed() == null ? 0 :
					   	     	BRF205B.getR76_other_aed().intValue());
					   		 }	
					   	
					   		Cell R76cell11 = R76row.getCell(15);
					   		 if (R76cell11 != null) {
					   	     R76cell11.setCellValue(BRF205B.getR76_other_fcy() == null ? 0 :
					   	     	BRF205B.getR76_other_fcy().intValue());
					   		 }	
					   		 
					   		 
					   	  /////////////////////R77//////////////////
					   	  
					   	  Row R77row = sheet.getRow(86);
					   			            
					   		 Cell R77cell = R77row.getCell(4);
					   		 if (R77cell != null) {
					   	     R77cell.setCellValue(BRF205B.getR77_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR77_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R77cell1 = R77row.getCell(5);
					   		 if (R77cell1 != null) {
					   	     R77cell1.setCellValue(BRF205B.getR77_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR77_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R77cell2 = R77row.getCell(6);
					   		 if (R77cell2 != null) {
					   	     R77cell2.setCellValue(BRF205B.getR77_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR77_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R77cell3 = R77row.getCell(7);
					   		 if (R77cell3 != null) {
					   	     R77cell3.setCellValue(BRF205B.getR77_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR77_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R77cell4 = R77row.getCell(8);
					   		 if (R77cell4 != null) {
					   	     R77cell4.setCellValue(BRF205B.getR77_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR77_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R77cell5 = R77row.getCell(9);
					   		 if (R77cell5 != null) {
					   	     R77cell5.setCellValue(BRF205B.getR77_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR77_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R77cell6 = R77row.getCell(10);
					   		 if (R77cell6 != null) {
					   	     R77cell6.setCellValue(BRF205B.getR77_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR77_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R77cell7 = R77row.getCell(11);
					   		 if (R77cell7 != null) {
					   	     R77cell7.setCellValue(BRF205B.getR77_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR77_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R77cell8 = R77row.getCell(12);
					   		 if (R77cell8 != null) {
					   	     R77cell8.setCellValue(BRF205B.getR77_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR77_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R77cell9 = R77row.getCell(13);
					   		 if (R77cell9 != null) {
					   	     R77cell9.setCellValue(BRF205B.getR77_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR77_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R77cell10 = R77row.getCell(14);
					   		 if (R77cell10 != null) {
					   	     R77cell10.setCellValue(BRF205B.getR77_other_aed() == null ? 0 :
					   	     	BRF205B.getR77_other_aed().intValue());
					   		 }	
					   	
					   		Cell R77cell11 = R77row.getCell(15);
					   		 if (R77cell11 != null) {
					   	     R77cell11.setCellValue(BRF205B.getR77_other_fcy() == null ? 0 :
					   	     	BRF205B.getR77_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R78//////////////////
					   	  
					   	  Row R78row = sheet.getRow(87);
					   			            
					   		 Cell R78cell = R78row.getCell(4);
					   		 if (R78cell != null) {
					   	     R78cell.setCellValue(BRF205B.getR78_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR78_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R78cell1 = R78row.getCell(5);
					   		 if (R78cell1 != null) {
					   	     R78cell1.setCellValue(BRF205B.getR78_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR78_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R78cell2 = R78row.getCell(6);
					   		 if (R78cell2 != null) {
					   	     R78cell2.setCellValue(BRF205B.getR78_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR78_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R78cell3 = R78row.getCell(7);
					   		 if (R78cell3 != null) {
					   	     R78cell3.setCellValue(BRF205B.getR78_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR78_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R78cell4 = R78row.getCell(8);
					   		 if (R78cell4 != null) {
					   	     R78cell4.setCellValue(BRF205B.getR78_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR78_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R78cell5 = R78row.getCell(9);
					   		 if (R78cell5 != null) {
					   	     R78cell5.setCellValue(BRF205B.getR78_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR78_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R78cell6 = R78row.getCell(10);
					   		 if (R78cell6 != null) {
					   	     R78cell6.setCellValue(BRF205B.getR78_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR78_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R78cell7 = R78row.getCell(11);
					   		 if (R78cell7 != null) {
					   	     R78cell7.setCellValue(BRF205B.getR78_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR78_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R78cell8 = R78row.getCell(12);
					   		 if (R78cell8 != null) {
					   	     R78cell8.setCellValue(BRF205B.getR78_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR78_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R78cell9 = R78row.getCell(13);
					   		 if (R78cell9 != null) {
					   	     R78cell9.setCellValue(BRF205B.getR78_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR78_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R78cell10 = R78row.getCell(14);
					   		 if (R78cell10 != null) {
					   	     R78cell10.setCellValue(BRF205B.getR78_other_aed() == null ? 0 :
					   	     	BRF205B.getR78_other_aed().intValue());
					   		 }	
					   	
					   		Cell R78cell11 = R78row.getCell(15);
					   		 if (R78cell11 != null) {
					   	     R78cell11.setCellValue(BRF205B.getR78_other_fcy() == null ? 0 :
					   	     	BRF205B.getR78_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R79//////////////////
					   	  
					   	  Row R79row = sheet.getRow(88);
					   			            
					   		 Cell R79cell = R79row.getCell(4);
					   		 if (R79cell != null) {
					   	     R79cell.setCellValue(BRF205B.getR79_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR79_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R79cell1 = R79row.getCell(5);
					   		 if (R79cell1 != null) {
					   	     R79cell1.setCellValue(BRF205B.getR79_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR79_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R79cell2 = R79row.getCell(6);
					   		 if (R79cell2 != null) {
					   	     R79cell2.setCellValue(BRF205B.getR79_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR79_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R79cell3 = R79row.getCell(7);
					   		 if (R79cell3 != null) {
					   	     R79cell3.setCellValue(BRF205B.getR79_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR79_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R79cell4 = R79row.getCell(8);
					   		 if (R79cell4 != null) {
					   	     R79cell4.setCellValue(BRF205B.getR79_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR79_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R79cell5 = R79row.getCell(9);
					   		 if (R79cell5 != null) {
					   	     R79cell5.setCellValue(BRF205B.getR79_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR79_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R79cell6 = R79row.getCell(10);
					   		 if (R79cell6 != null) {
					   	     R79cell6.setCellValue(BRF205B.getR79_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR79_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R79cell7 = R79row.getCell(11);
					   		 if (R79cell7 != null) {
					   	     R79cell7.setCellValue(BRF205B.getR79_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR79_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R79cell8 = R79row.getCell(12);
					   		 if (R79cell8 != null) {
					   	     R79cell8.setCellValue(BRF205B.getR79_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR79_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R79cell9 = R79row.getCell(13);
					   		 if (R79cell9 != null) {
					   	     R79cell9.setCellValue(BRF205B.getR79_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR79_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R79cell10 = R79row.getCell(14);
					   		 if (R79cell10 != null) {
					   	     R79cell10.setCellValue(BRF205B.getR79_other_aed() == null ? 0 :
					   	     	BRF205B.getR79_other_aed().intValue());
					   		 }	
					   	
					   		Cell R79cell11 = R79row.getCell(15);
					   		 if (R79cell11 != null) {
					   	     R79cell11.setCellValue(BRF205B.getR79_other_fcy() == null ? 0 :
					   	     	BRF205B.getR79_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R80//////////////////
					   	  
					   	  Row R80row = sheet.getRow(89);
					   			            
					   		 Cell R80cell = R80row.getCell(4);
					   		 if (R80cell != null) {
					   	     R80cell.setCellValue(BRF205B.getR80_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR80_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R80cell1 = R80row.getCell(5);
					   		 if (R80cell1 != null) {
					   	     R80cell1.setCellValue(BRF205B.getR80_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR80_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R80cell2 = R80row.getCell(6);
					   		 if (R80cell2 != null) {
					   	     R80cell2.setCellValue(BRF205B.getR80_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR80_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R80cell3 = R80row.getCell(7);
					   		 if (R80cell3 != null) {
					   	     R80cell3.setCellValue(BRF205B.getR80_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR80_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R80cell4 = R80row.getCell(8);
					   		 if (R80cell4 != null) {
					   	     R80cell4.setCellValue(BRF205B.getR80_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR80_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R80cell5 = R80row.getCell(9);
					   		 if (R80cell5 != null) {
					   	     R80cell5.setCellValue(BRF205B.getR80_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR80_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R80cell6 = R80row.getCell(10);
					   		 if (R80cell6 != null) {
					   	     R80cell6.setCellValue(BRF205B.getR80_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR80_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R80cell7 = R80row.getCell(11);
					   		 if (R80cell7 != null) {
					   	     R80cell7.setCellValue(BRF205B.getR80_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR80_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R80cell8 = R80row.getCell(12);
					   		 if (R80cell8 != null) {
					   	     R80cell8.setCellValue(BRF205B.getR80_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR80_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R80cell9 = R80row.getCell(13);
					   		 if (R80cell9 != null) {
					   	     R80cell9.setCellValue(BRF205B.getR80_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR80_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R80cell10 = R80row.getCell(14);
					   		 if (R80cell10 != null) {
					   	     R80cell10.setCellValue(BRF205B.getR80_other_aed() == null ? 0 :
					   	     	BRF205B.getR80_other_aed().intValue());
					   		 }	
					   	
					   		Cell R80cell11 = R80row.getCell(15);
					   		 if (R80cell11 != null) {
					   	     R80cell11.setCellValue(BRF205B.getR80_other_fcy() == null ? 0 :
					   	     	BRF205B.getR80_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R81//////////////////
					   	  
					   	  Row R81row = sheet.getRow(90);
					   			            
					   		 Cell R81cell = R81row.getCell(4);
					   		 if (R81cell != null) {
					   	     R81cell.setCellValue(BRF205B.getR81_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR81_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R81cell1 = R81row.getCell(5);
					   		 if (R81cell1 != null) {
					   	     R81cell1.setCellValue(BRF205B.getR81_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR81_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R81cell2 = R81row.getCell(6);
					   		 if (R81cell2 != null) {
					   	     R81cell2.setCellValue(BRF205B.getR81_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR81_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R81cell3 = R81row.getCell(7);
					   		 if (R81cell3 != null) {
					   	     R81cell3.setCellValue(BRF205B.getR81_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR81_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R81cell4 = R81row.getCell(8);
					   		 if (R81cell4 != null) {
					   	     R81cell4.setCellValue(BRF205B.getR81_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR81_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R81cell5 = R81row.getCell(9);
					   		 if (R81cell5 != null) {
					   	     R81cell5.setCellValue(BRF205B.getR81_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR81_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R81cell6 = R81row.getCell(10);
					   		 if (R81cell6 != null) {
					   	     R81cell6.setCellValue(BRF205B.getR81_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR81_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R81cell7 = R81row.getCell(11);
					   		 if (R81cell7 != null) {
					   	     R81cell7.setCellValue(BRF205B.getR81_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR81_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R81cell8 = R81row.getCell(12);
					   		 if (R81cell8 != null) {
					   	     R81cell8.setCellValue(BRF205B.getR81_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR81_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R81cell9 = R81row.getCell(13);
					   		 if (R81cell9 != null) {
					   	     R81cell9.setCellValue(BRF205B.getR81_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR81_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R81cell10 = R81row.getCell(14);
					   		 if (R81cell10 != null) {
					   	     R81cell10.setCellValue(BRF205B.getR81_other_aed() == null ? 0 :
					   	     	BRF205B.getR81_other_aed().intValue());
					   		 }	
					   	
					   		Cell R81cell11 = R81row.getCell(15);
					   		 if (R81cell11 != null) {
					   	     R81cell11.setCellValue(BRF205B.getR81_other_fcy() == null ? 0 :
					   	     	BRF205B.getR81_other_fcy().intValue());
					   		 }	
					   		 
					   	  /////////////////////R82//////////////////
					   	  
					   	  Row R82row = sheet.getRow(91);
					   			            
					   		 Cell R82cell = R82row.getCell(4);
					   		 if (R82cell != null) {
					   	     R82cell.setCellValue(BRF205B.getR82_gcc_ksa_aed() == null ? 0 :
					   	     	BRF205B.getR82_gcc_ksa_aed().intValue());
					   		 }	
					   	
					   		Cell R82cell1 = R82row.getCell(5);
					   		 if (R82cell1 != null) {
					   	     R82cell1.setCellValue(BRF205B.getR82_gcc_ksa_fcy() == null ? 0 :
					   	     	BRF205B.getR82_gcc_ksa_fcy().intValue());
					   		 }	
					   	
					   		Cell R82cell2 = R82row.getCell(6);
					   		 if (R82cell2 != null) {
					   	     R82cell2.setCellValue(BRF205B.getR82_gcc_oman_aed() == null ? 0 :
					   	     	BRF205B.getR82_gcc_oman_aed().intValue());
					   		 }	
					   	
					   		Cell R82cell3 = R82row.getCell(7);
					   		 if (R82cell3 != null) {
					   	     R82cell3.setCellValue(BRF205B.getR82_gcc_oman_fcy() == null ? 0 :
					   	     	BRF205B.getR82_gcc_oman_fcy().intValue());
					   		 }	
					   	
					   		Cell R82cell4 = R82row.getCell(8);
					   		 if (R82cell4 != null) {
					   	     R82cell4.setCellValue(BRF205B.getR82_gcc_kuwait_aed() == null ? 0 :
					   	     	BRF205B.getR82_gcc_kuwait_aed().intValue());
					   		 }	
					   	
					   		Cell R82cell5 = R82row.getCell(9);
					   		 if (R82cell5 != null) {
					   	     R82cell5.setCellValue(BRF205B.getR82_gcc_kuwait_fcy() == null ? 0 :
					   	     	BRF205B.getR82_gcc_kuwait_fcy().intValue());
					   		 }	
					   	
					   		Cell R82cell6 = R82row.getCell(10);
					   		 if (R82cell6 != null) {
					   	     R82cell6.setCellValue(BRF205B.getR82_gcc_qatar_aed() == null ? 0 :
					   	     	BRF205B.getR82_gcc_qatar_aed().intValue());
					   		 }	
					   	
					   		Cell R82cell7 = R82row.getCell(11);
					   		 if (R82cell7 != null) {
					   	     R82cell7.setCellValue(BRF205B.getR82_gcc_qatar_fcy() == null ? 0 :
					   	     	BRF205B.getR82_gcc_qatar_fcy().intValue());
					   		 }	
					   	
					   		Cell R82cell8 = R82row.getCell(12);
					   		 if (R82cell8 != null) {
					   	     R82cell8.setCellValue(BRF205B.getR82_gcc_bahrain_aed() == null ? 0 :
					   	     	BRF205B.getR82_gcc_bahrain_aed().intValue());
					   		 }	
					   	
					   		Cell R82cell9 = R82row.getCell(13);
					   		 if (R82cell9 != null) {
					   	     R82cell9.setCellValue(BRF205B.getR82_gcc_bahrain_fcy() == null ? 0 :
					   	     	BRF205B.getR82_gcc_bahrain_fcy().intValue());
					   		 }	
					   	
					   		Cell R82cell10 = R82row.getCell(14);
					   		 if (R82cell10 != null) {
					   	     R82cell10.setCellValue(BRF205B.getR82_other_aed() == null ? 0 :
					   	     	BRF205B.getR82_other_aed().intValue());
					   		 }	
					   	
					   		Cell R82cell11 = R82row.getCell(15);
					   		 if (R82cell11 != null) {
					   	     R82cell11.setCellValue(BRF205B.getR82_other_fcy() == null ? 0 :
					   	     	BRF205B.getR82_other_fcy().intValue());
					   		 }	
					   		 
						
					}
				}
				FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-205-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-205-A.xls");

		return outputFile;
	
	
	
	}
	       	 
	       	 
	
	public ModelAndView getBRF205AcurrentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF205_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF205_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF205_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF205_DETAIL_ENTITY> T1Master = new ArrayList<BRF205_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF205_DETAIL_ENTITY a where a.report_date = ?1", BRF205_DETAIL_ENTITY.class)
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
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			String purpose_of_rem = (String) a[49];
			String collection_code = (String) a[50];

			BRF205_DETAIL_ENTITY py =  new BRF205_DETAIL_ENTITY( cust_id,  foracid,  act_balance_amt_lc,  eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,  sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,  create_time,  modify_user, modify_time,
					 verify_user,   verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,  report_date,  maturity_date,  gender,  version,  remarks,purpose_of_rem,collection_code);

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

		mv.setViewName("RR" + "/" +"BRF205::reportcontent");
	//	mv.setViewName("RR" + "/" + "BRF100A::reportcontent");
		
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	
	
	public String detailChanges205(BRF205_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF205_DETAIL_ENTITY> Brf205detail =brf205_DetailRep.findById(foracid);

			if (Brf205detail.isPresent()) {
				BRF205_DETAIL_ENTITY BRFdetail = Brf205detail.get();

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
					brf205_DetailRep.save(BRFdetail);

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

	
	
	
	
	@SuppressWarnings("unchecked")
	public ModelAndView ARCHgetBRF205currentDtl(String reportId, String fromdate, String todate, String currency,
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
				
				
					qr = hs.createNativeQuery("select * from BRF205_ARCHIVETABLE a where report_date=?1 and report_label_1=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF205_ARCHIVETABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF205_ARCHIVETABLE  where report_date = ?1");
		}

		List<BRF205_ARCHIV_ENTITY> T1Master = new ArrayList<BRF205_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF205_ARCHIV_ENTITY a where a.report_date = ?1", BRF205_ARCHIV_ENTITY.class)
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
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			String purpose_of_rem = (String) a[49];
			String collection_code = (String) a[50];

			BRF205_ARCHIV_ENTITY py =  new BRF205_ARCHIV_ENTITY( cust_id,  foracid,  act_balance_amt_lc,  eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,  sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,  create_time,  modify_user, modify_time,
					 verify_user,   verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,  report_date,  maturity_date,  gender,  version,  remarks,purpose_of_rem,collection_code);

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
		mv.setViewName("RR" + "/" + "BRF205ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
		}





	public ModelAndView getArchieveBRF205View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF205A_A1_RPT> T1rep = new ArrayList<BRF205A_A1_RPT>();
		// Query<Object[]> qr;
		List<BRF205A_A1_RPT> T1Master = new ArrayList<BRF205A_A1_RPT>();
		List<BRF205A_A2_RPT> T1Master1 = new ArrayList<BRF205A_A2_RPT>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF205A_A1_RPT a where a.report_date = ?1 ", BRF205A_A1_RPT.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from  BRF205A_A2_RPT a where a.report_date = ?1 ", BRF205A_A2_RPT.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF205ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

		
			}
		

	
	
	


