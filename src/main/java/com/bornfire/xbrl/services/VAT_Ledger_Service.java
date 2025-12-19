package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

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
public class VAT_Ledger_Service {

	@Autowired
	Environment env;

	@Autowired
	DataSource srcdataSource;

	public File getFileB10(String date) throws FileNotFoundException, JRException, SQLException {

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		File outputFile;

		fileName = "VAT_Ledger" + "_" + date;

		try {
			InputStream jasperFile;

			jasperFile = this.getClass().getResourceAsStream("/static/jasper/VAT_LEDGER_DAILY_DATA.jrxml");

			JasperReport jr = JasperCompileManager.compileReport(jasperFile);
			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("REPORT_DATE", date);

			System.out.println("EXCEEEEEll");
			fileName = fileName + ".xlsx";
			path += fileName;
			JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jp));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
			exporter.exportReport();

		} catch (Exception e) {
			e.printStackTrace();
		}

		outputFile = new File(path);
		System.out.println("output file");
		return outputFile;
	}
}
