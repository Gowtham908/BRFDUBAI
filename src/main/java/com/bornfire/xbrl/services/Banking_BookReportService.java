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

import com.bornfire.xbrl.entities.BRBS.BANKING_BOOK1_CONS3;
import com.bornfire.xbrl.entities.BRBS.Banking_Book1_Cons;

import com.bornfire.xbrl.entities.BRBS.Banking_Book2_Cons;
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
public class Banking_BookReportService {
	private static final Logger logger = LoggerFactory.getLogger(Banking_BookReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
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
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from Banking_Book1_Cons a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from Banking_Book1_Cons a").getSingleResult();
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

	public ModelAndView getBRFBanking_BookView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Banking_Book1_Cons> T1rep = new ArrayList<Banking_Book1_Cons>();
		// Query<Object[]> qr;
		List<Banking_Book1_Cons> T1Master = new ArrayList<Banking_Book1_Cons>();
		List<Banking_Book2_Cons> T1Master1 = new ArrayList<Banking_Book2_Cons>();
		List<BANKING_BOOK1_CONS3> T1Master2 = new ArrayList<BANKING_BOOK1_CONS3>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  Banking_Book1_Cons a where a.report_date = ?1 ", Banking_Book1_Cons.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from  Banking_Book2_Cons a where a.report_date = ?1 ", Banking_Book2_Cons.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			T1Master2 = hs.createQuery("from BANKING_BOOK1_CONS3 a where a.REPORT_DATE = ?1", BANKING_BOOK1_CONS3.class)
				     .setParameter(1, df.parse(todate)).getResultList();

			
			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRFBankingbook");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("book3", T1Master2);
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

		}
	
	
	
	public File getFileBanking_Book(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName =  "011-BRF-Bankingbook-A";
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

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/Banking_Book_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/Banking_Book_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/Bankingbookconsolidated.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/Bankingbookconsolidated.jrxml");
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

		}
		outputFile = new File(path);

		return outputFile;
		
		
	}
	
	





	 public File getconsolidateFile(String reportId, String fromDate, String toDate, String currency, String dtlType,
	            String fileType) throws JRException, SQLException, IOException {

	        logger.info("Entering getConsolidatedFile method");

	        String path = env.getProperty("output.exportpath");
	        String fileName = "t" + reportId + "_" + toDate + ".xlsx"; // Naming the Excel file with reportId and toDate
	        File outputFile = new File(path + fileName);

	        try {

	            // List of Jasper files and their corresponding sheet names
	            InputStream[] jasperFiles = { 
	                this.getClass().getResourceAsStream("/static/jasper/Bankingbookusd.jrxml"),
	                this.getClass().getResourceAsStream("/static/jasper/Bankingbookgbp.jrxml"),   
	                this.getClass().getResourceAsStream("/static/jasper/Bankingbookeur.jrxml"),
	                this.getClass().getResourceAsStream("/static/jasper/Bankingbookothercurrency.jrxml"),
	                this.getClass().getResourceAsStream("/static/jasper/Bankingbookconsolidated.jrxml"),    
	                this.getClass().getResourceAsStream("/static/jasper/Bankingbook_MR3.jrxml"), 
	                this.getClass().getResourceAsStream("/static/jasper/BASELINE.jrxml"),
	                this.getClass().getResourceAsStream("/static/jasper/ADVERSE.jrxml"),
	                 };
	            String[] sheetNames = { 
	            		"Input_Sht_TGA_USD", 
	            		"Input_Sht_TGA_GBP", 
	            		"Input_Sht_TGA_EUR",
	            		"Input_Sht_TGA_OTHER CURRENCIES",
	            		"Input_Sht_TGA_CONSOLIDATED",
	            		 "M3 Working", 
	            		 "Baseline", 
	            		 "Adverse", 
	            		};

	            List<JasperPrint> jasperPrintList = new ArrayList<>();

	            HashMap<String, Object> map = new HashMap<>();
	            map.put("REPORT_DATE", toDate); // Setting parameters for the Jasper report

	            for (int i = 0; i < jasperFiles.length; i++) {
	                JasperReport jasperReport = JasperCompileManager.compileReport(jasperFiles[i]);
	                JasperPrint jp = JasperFillManager.fillReport(jasperReport, map, srcdataSource.getConnection());
	                jp.setName(sheetNames[i]);
	                jasperPrintList.add(jp);
	            }

	            // Exporting the JasperPrintList to Excel
	            logger.info("Exporting to Excel");
	            JRXlsxExporter exporter = new JRXlsxExporter();
	            exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
	            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(outputFile)));
	            exporter.exportReport();
	            logger.info("Excel File exported successfully");

	        } catch (IOException e) {
	            logger.error("Error occurred while exporting to Excel: " + e.getMessage());
	            throw new IOException("Error occurred while exporting to Excel", e);
	        }

	        return outputFile;
	    }
	

		
			}
		

	
	
	


