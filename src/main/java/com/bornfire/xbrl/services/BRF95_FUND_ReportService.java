package com.bornfire.xbrl.services;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.FileNotFoundException;
import java.net.URL;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.BRF95_CCF_CR3_SHEET;
import com.bornfire.xbrl.entities.BRBS.BRF95_FINAL_CCFREPORT;
import com.bornfire.xbrl.entities.BRBS.BRF95_FUND_BASED1;
import com.bornfire.xbrl.entities.BRBS.BRF95_FUND_BASED2;
import com.bornfire.xbrl.entities.BRBS.BRF95_FUND_BASED_UNDRAWN;
import com.bornfire.xbrl.entities.BRBS.BRF95_NONFUND_BASED_TABLE1;
import com.bornfire.xbrl.entities.BRBS.BRF95_NONFUND_BASED_TABLE2;
import com.bornfire.xbrl.entities.BRBS.BRF95_NON_FUND_BASED_UNDRAWN_A;
import com.bornfire.xbrl.entities.BRBS.BRF95_NON_FUND_BASED_UNDRAWN_B;
import com.bornfire.xbrl.entities.BRBS.BRF95_TABLE1;
import com.bornfire.xbrl.entities.BRBS.BRF95_TABLE2;
import com.bornfire.xbrl.entities.BRBS.BRF95_TABLE3;
import com.bornfire.xbrl.entities.BRBS.BRF95_TABLE4;
import com.bornfire.xbrl.entities.BRBS.BRF95_TABLE5;
import com.bornfire.xbrl.entities.BRBS.BRF95_TABLE6;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;


@Service
@Transactional
@ConfigurationProperties("output")


public class BRF95_FUND_ReportService {


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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF95_FUND_BASED1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF95_FUND_BASED1 a").getSingleResult();
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

	public ModelAndView getBRFFB_View(String reportId, String fromdate, String todate, String currency, String dtltype,
	        Pageable pageable) {

	    ModelAndView mv = new ModelAndView();
	    Session hs = sessionFactory.getCurrentSession();
	    int pageSize = pageable.getPageSize();
	    int currentPage = pageable.getPageNumber();
	    int startItem = currentPage * pageSize;
	    List<BRF95_FUND_BASED1> T1rep = new ArrayList<BRF95_FUND_BASED1>();
	    // Query<Object[]> qr;
	    List<BRF95_FUND_BASED1> T1Master = new ArrayList<BRF95_FUND_BASED1>();
	    List<BRF95_FUND_BASED2> T1Master1 = new ArrayList<BRF95_FUND_BASED2>();
	    List<BRF95_FUND_BASED_UNDRAWN> T1Master2 = new ArrayList<BRF95_FUND_BASED_UNDRAWN>();
	    List<BRF95_NONFUND_BASED_TABLE1> T1Master3 = new ArrayList<BRF95_NONFUND_BASED_TABLE1>();
	    List<BRF95_NONFUND_BASED_TABLE2> T1Master4 = new ArrayList<BRF95_NONFUND_BASED_TABLE2>();
	    List<BRF95_NON_FUND_BASED_UNDRAWN_A> T1Master5 = new ArrayList<BRF95_NON_FUND_BASED_UNDRAWN_A>();
	    List<BRF95_NON_FUND_BASED_UNDRAWN_B> T1Master6 = new ArrayList<BRF95_NON_FUND_BASED_UNDRAWN_B>();
	    List<BRF95_CCF_CR3_SHEET> T1Master7 = new ArrayList<BRF95_CCF_CR3_SHEET>();
	    List<BRF95_FINAL_CCFREPORT > T1Master8 = new ArrayList<BRF95_FINAL_CCFREPORT >();
	    List<BRF95_TABLE1> T1Master9 = new ArrayList<BRF95_TABLE1>();
	    List<BRF95_TABLE2> T1Master10 = new ArrayList<BRF95_TABLE2>();
	    List<BRF95_TABLE3> T1Master11 = new ArrayList<BRF95_TABLE3>();
	    List<BRF95_TABLE4> T1Master12 = new ArrayList<BRF95_TABLE4>();
	    List<BRF95_TABLE5> T1Master13 = new ArrayList<BRF95_TABLE5>();
	    List<BRF95_TABLE6> T1Master14 = new ArrayList<BRF95_TABLE6>();


	    logger.info("Inside archive" + currency);

	    try {
	        Date d1 = df.parse(todate);
	        // T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	        T1Master = hs.createQuery("from BRF95_FUND_BASED1 a where a.report_date = ?1 ", BRF95_FUND_BASED1.class)
	                .setParameter(1, df.parse(todate)).getResultList();

	        T1Master1 = hs.createQuery("from BRF95_FUND_BASED2 a where a.report_date = ?1 ", BRF95_FUND_BASED2.class)
	                .setParameter(1, df.parse(todate)).getResultList();

	        T1Master2 = hs.createQuery("from BRF95_FUND_BASED_UNDRAWN a where a.report_date = ?1 ", BRF95_FUND_BASED_UNDRAWN.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master3 = hs.createQuery("from BRF95_NONFUND_BASED_TABLE1 a where a.report_date = ?1 ", BRF95_NONFUND_BASED_TABLE1.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master4 = hs.createQuery("from BRF95_NONFUND_BASED_TABLE2 a where a.report_date = ?1 ", BRF95_NONFUND_BASED_TABLE2.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master5 = hs.createQuery("from BRF95_NON_FUND_BASED_UNDRAWN_A a where a.report_date = ?1 ", BRF95_NON_FUND_BASED_UNDRAWN_A.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master6 = hs.createQuery("from BRF95_NON_FUND_BASED_UNDRAWN_B a where a.report_date = ?1 ", BRF95_NON_FUND_BASED_UNDRAWN_B.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master7 = hs.createQuery("from BRF95_CCF_CR3_SHEET a where a.report_date = ?1 ", BRF95_CCF_CR3_SHEET.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master8 = hs.createQuery("from BRF95_FINAL_CCFREPORT a where a.report_date = ?1 ", BRF95_FINAL_CCFREPORT.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master9 = hs.createQuery("from BRF95_TABLE1 a where a.report_date = ?1 ", BRF95_TABLE1.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master10 = hs.createQuery("from BRF95_TABLE2 a where a.report_date = ?1 ", BRF95_TABLE2.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master11 = hs.createQuery("from BRF95_TABLE3 a where a.report_date = ?1 ", BRF95_TABLE3.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master12 = hs.createQuery("from BRF95_TABLE4 a where a.report_date = ?1 ", BRF95_TABLE4.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master13 = hs.createQuery("from BRF95_TABLE5 a where a.report_date = ?1 ", BRF95_TABLE5.class)
	                .setParameter(1, df.parse(todate)).getResultList();
	        
	        T1Master14 = hs.createQuery("from BRF95_TABLE6 a where a.report_date = ?1 ", BRF95_TABLE6.class)
	                .setParameter(1, df.parse(todate)).getResultList();

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    // T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	    mv.setViewName("RR/BRF95_FUND"); 
	    // mv.addObject("currlist", refCodeConfig.currList());
	    mv.addObject("reportsummary", T1Master);
	    mv.addObject("reportsummary1", T1Master1);
	    mv.addObject("reportsummary2", T1Master2);
	    mv.addObject("reportsummary3", T1Master3);
	    mv.addObject("reportsummary4", T1Master4);
	    mv.addObject("reportsummary5", T1Master5);
	    mv.addObject("reportsummary6", T1Master6);
	    mv.addObject("reportsummary7", T1Master7);	    	 	    
	    mv.addObject("reportsummary8", T1Master8);
	    mv.addObject("reportsummary9", T1Master9);
	    mv.addObject("reportsummary10", T1Master10);
	    mv.addObject("reportsummary11", T1Master11);
	    mv.addObject("reportsummary12", T1Master12);
	    mv.addObject("reportsummary13", T1Master13);
	    mv.addObject("reportsummary14", T1Master14);
	    

	    /* mv.addObject("reportsummary1", T1Master1); */
	    mv.addObject("reportmaster", T1Master);
	    mv.addObject("displaymode", "summary");
	    mv.addObject("reportsflag", "reportsflag");
	    mv.addObject("menu", reportId);
	    System.out.println("scv" + mv.getViewName());

	    return mv;
	}
	
	public File getconsolidateFile95(String reportId, String fromDate, String toDate, String currency, String dtlType,
            String fileType) throws JRException, SQLException, IOException {

        logger.info("Entering getConsolidatedFile method");

        String path = env.getProperty("output.exportpath");
        String fileName = "t" + reportId + "_" + toDate + ".xlsx"; // Naming the Excel file with reportId and toDate
        File outputFile = new File(path + fileName);

        try {

            // List of Jasper files and their corresponding sheet names
            InputStream[] jasperFiles = { 
            		
            		this.getClass().getResourceAsStream("/static/jasper/GL_JASPER.jrxml"),
            		this.getClass().getResourceAsStream("/static/jasper/BRF95_CHECKPOINT.jrxml"),
            		this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_DATA_FUNDBASED_Detail.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_DATA_UNNFUNDBASED.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_DATA_BILL.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_INVESTMENT_DATA.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_PLACEMENT_DATA .jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA .jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_NOSTRO_OTHR_BALANCES.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_NOSTRO_INTER_BRANCH.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_CBUAE_BALANCE.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_CASH_BALANCE.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_CLAIM_ON_BANK.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_CLAIM_ON_BANK_NOTE.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_CENTRAL_BANK_SOVEREIGN.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_RWA_CASH_AND_DB_DATA_OTHER_ASSETS_CASH_BALANCE.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/BRF95_OTHER_ASSETS.jrxml"),
            	    this.getClass().getResourceAsStream("/static/jasper/FB_NB_BRF95.jrxml")
            	    
                 };
            String[] sheetNames = { 
            		"GL",
            		"Check_point",
            		"Data_FB",
            		"Data_NFB",
            		"Bank_Bill",
            		"Investment",
            		"Placement",
            		"Cash_CB_Data",
            		"Cash_CB_Nostro_Other_Balance",
            		"Cash_CB-Nostro_Inter_branch",
            		"Cash_CB_CBUAE",
            		"Cash_CB_Cash_Balance",
            		"Cash_CB_Claim_on_bank",
            		"Cash_CB_Claim_BankNote",
            		"Cash_CB_Central_Bank_Sovereign",
            		"Cash_CB_Other_Assets_Cash_Balance",
            		"OTHER_ASSETS",
            		"FB_NB_BRF95",
            		};

            List<JasperPrint> jasperPrintList = new ArrayList<>();

            HashMap<String, Object> map = new HashMap<>();
            
            map.put("PAGE_BREAK_CONDITION", true);
            map.put("REPORT_DATE", toDate); // Setting parameters for the Jasper report
            

            for (int i = 0; i < jasperFiles.length; i++) {
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperFiles[i]);
                JasperPrint jp = JasperFillManager.fillReport(jasperReport, map, srcdataSource.getConnection());
                jp.setName(sheetNames[i]);
                jasperPrintList.add(jp);
            }

            // Exporting the JasperPrintList to Excel
            logger.info("Exporting to Excel");
            SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
            reportConfig.setSheetNames(new String[] { fileName });
            reportConfig.setDetectCellType(true);
            reportConfig.setOnePagePerSheet(false);
            reportConfig.setRemoveEmptySpaceBetweenRows(false);
            reportConfig.setWhitePageBackground(false);
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
	
	public File getFileBRF95(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName =  "FB_NFB_BRF95";
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

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/FB_NB_BRF95.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/FB_NB_BRF95.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/FB_NB_BRF95.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/FB_NB_BRF95.jrxml");
					}
				}

				//JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
				JasperReport jr
				  = JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("PAGE_BREAK_CONDITION", true);
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
	private static int calculatePageHeight(List<JRPrintElement> elements) {
		int maxHeight = 0;

		for (JRPrintElement element : elements) {
			// Adjust this based on your element's properties
			int elementHeight = element.getY() + element.getHeight();
			maxHeight = Math.max(maxHeight, elementHeight);
		}

		return maxHeight;
	}
	
	

}