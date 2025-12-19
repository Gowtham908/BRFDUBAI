package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.bornfire.xbrl.entities.TransactionmastertableRep;
import com.bornfire.xbrl.entities.BRBS.BRF_MAPPING_TABLE;
 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
 
@Service
@Transactional
@ConfigurationProperties("output")
public class REFCODEMAPPING {
	private static final Logger logger = LoggerFactory.getLogger(REFCODEMAPPING.class);
 
	@Autowired
	SessionFactory sessionFactory;
 
	@Autowired
	DataSource srcdataSource;
 
	@Autowired
	Environment env;
 
	@Autowired
	TransactionmastertableRep rep;
 
	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */
 
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	public File getFile( String todate,  String dtltype,
			String filetype, String report_name_1) throws FileNotFoundException, JRException, SQLException {
 
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
System.out.println(report_name_1+"INSIDE");
		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;
		System.out.println(report_name_1);
		System.out.println(todate);
		fileName = "011-BRF-001-A";

 
		if (!filetype.equals("xbrl")) {
 
			try {
				InputStream jasperFile;
 
					if ( (!report_name_1.equals("null"))){
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/MappedAccounts.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/MappedAccounts.jrxml");
					}

 
				/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
				JasperReport jr = JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();
 
				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_DATE", todate);
				map.put("REPORT_NAME_1", report_name_1);
				if (filetype.equals("pdf")) {
					System.out.println("PDF");
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
   public File getFile1(String report_name_1,  String filetype) throws FileNotFoundException, JRException, SQLException {
	   System.out.println("inside the path");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
 
		String path = env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;
		File pre = new File(path);
		if(pre.exists()) {
			System.out.println("present");
		}else {
			pre.mkdirs();
		}
 
		fileName =  "Mapped_"+report_name_1;
		logger.info("Getting Output fileName :" + report_name_1);
		try {
			InputStream jasperFile;
			logger.info("Getting Jasper file :" + "Third_PARTY");
			if (filetype.equals("pdf")) {
				logger.info("pdf inside :---" );
					jasperFile = this.getClass().getResourceAsStream("/static/jasper/MappedAccounts.jrxml");
				}else {
					logger.info("excel inside :---" );
					jasperFile = this.getClass()
							.getResourceAsStream("/static/jasper/MappedAccounts.jrxml");
			}

			List<BRF_MAPPING_TABLE> entityList = new ArrayList<>();
			JasperReport jr = JasperCompileManager.compileReport(jasperFile);
			HashMap<String, Object> map = new HashMap<String, Object>();
 
			logger.info("Assigning Parameters for Jasper");
			map.put("REPORT_NAME_1", report_name_1);
			if (filetype.equals("pdf")) {
				fileName = fileName + ".pdf";
				path = fileName;
				JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
				JasperExportManager.exportReportToPdfFile(jp, path);
				logger.info("PDF File exported");
			} else {
 
				System.out.println("EXCEEEEEll");
				fileName = fileName + ".xlsx";
				path = fileName;
				JRBeanCollectionDataSource dataSrc = new JRBeanCollectionDataSource(entityList);
				JasperPrint jp = JasperFillManager.fillReport(jr, map,srcdataSource.getConnection());
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



}