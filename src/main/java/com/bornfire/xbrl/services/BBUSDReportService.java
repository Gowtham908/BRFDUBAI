package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.Banking_Book3_OTHERCURRENCY;
import com.bornfire.xbrl.entities.BRBS.Banking_Book_USD;
import com.bornfire.xbrl.entities.BRBS.Banking_Book1_USD;
import com.bornfire.xbrl.entities.BRBS.Banking_Book2_USD;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
@Transactional
@ConfigurationProperties("output")
public class BBUSDReportService {
	private static final Logger logger = LoggerFactory.getLogger(BBUSDReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public ModelAndView BRFBankingbookusdView(Date report_date) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		List<Banking_Book1_USD> T1Master = new ArrayList<>();
		List<Banking_Book2_USD> T1Master1 = new ArrayList<>();
		List<Banking_Book_USD> T1Master2 = new ArrayList<>();

		try {
			T1Master = hs
					.createQuery("from Banking_Book1_USD a where a.report_date = :report_date", Banking_Book1_USD.class)
			 		.setParameter("report_date", report_date).getResultList();

			T1Master1 = hs
					.createQuery("from Banking_Book2_USD a where a.report_date = :report_date", Banking_Book2_USD.class)
					.setParameter("report_date", report_date).getResultList();
			T1Master2 = hs
					.createQuery("from Banking_Book_USD a where a.REPORT_Date = :reportDate",
							Banking_Book_USD.class)
					.setParameter("reportDate", report_date) // Use a variable with the same name as the parameter in
																// the query
					.getResultList();
			
			 for (Banking_Book_USD entry : T1Master2) {
		            System.out.println(entry);
		        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		mv.setViewName("RR/BBUSD");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("book3", T1Master2);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", report_date);

		return mv;
	}

	public File getconsolidateFile(String todate) throws JRException, SQLException, IOException {
		logger.info("Entering getConsolidatedFile method");

		String path = env.getProperty("output.exportpath");
		String fileName = "treport_" + todate + ".xlsx"; // Naming the Excel file with reportId and toDate
		File outputFile = new File(path + fileName);

		try (FileOutputStream fos = new FileOutputStream(outputFile)) {
			InputStream[] jasperFiles = { this.getClass().getResourceAsStream("/static/jasper/Bankingbookusd.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Bankingbookgbp.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Bankingbookeur.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Bankingbookothercurrency.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Bankingbookcons.jrxml") };
			String[] sheetNames = { "Input_Sht_TGA_USD", "Input_Sht_TGA_GBP", "Input_Sht_TGA_EUR",
					"Input_Sht_TGA_OTHER CURRENCIES", "Input_Sht_TGA_CONSOLIDATED" };

			List<JasperPrint> jasperPrintList = new ArrayList<>();
			HashMap<String, Object> map = new HashMap<>();
			map.put("REPORT_DATE", todate); // Setting parameters for the Jasper report

			for (int i = 0; i < jasperFiles.length; i++) {
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperFiles[i]);
				JasperPrint jp = JasperFillManager.fillReport(jasperReport, map, srcdataSource.getConnection());
				jp.setName(sheetNames[i]);
				jasperPrintList.add(jp);
			}

			logger.info("Exporting to Excel");
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fos));
			exporter.exportReport();
			logger.info("Excel File exported successfully");

		} catch (IOException e) {
			logger.error("Error occurred while exporting to Excel: " + e.getMessage(), e);
			throw new IOException("Error occurred while exporting to Excel", e);
		}

		return outputFile;
	}

}
