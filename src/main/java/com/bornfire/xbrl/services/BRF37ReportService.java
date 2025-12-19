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

import com.bornfire.xbrl.entities.BRBS.BRF37;
import com.bornfire.xbrl.entities.BRBS.BRF37B_DetaiRep;
import com.bornfire.xbrl.entities.BRBS.BRF37_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF37_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF37_DetaiRep;
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
public class BRF37ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF37ReportService.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF37_DetaiRep BRF37_DetaiRep;

	@Autowired
	BRF37B_DetaiRep BRF37B_DetaiRep;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheck(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF37 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from   BRF37 a").getSingleResult();
				if (modcnt > 0) {
					msg = "success";
				}
			} else {
				// msg = "Data Not available for the Report. Please Contact Administrator";
				msg = "success";

			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "success";
			e.printStackTrace();

		}

		return msg;

	}

	public File getFileBRF37(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-037-A";
		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF37_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF37_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF37.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF37.jrxml");
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
			} else {

				List<BRF37> T1Master = new ArrayList<BRF37>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF37 a where a.report_date = ?1 ", BRF37.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF37 BRF37 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-037-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);
							Row row = sheet.getRow(11);
							Cell cell = row.getCell(3);
							if (cell != null) {
								cell.setCellValue(BRF37.getR12_aed() == null ? 0 : BRF37.getR12_aed().intValue());
							}

							Cell cell1 = row.getCell(4);
							if (cell1 != null) {
								cell1.setCellValue(BRF37.getR12_fcy() == null ? 0 : BRF37.getR12_fcy().intValue());
							}

							Cell cell3 = row.getCell(6);
							if (cell3 != null) {
								cell3.setCellValue(
										BRF37.getR12_commercial() == null ? 0 : BRF37.getR12_commercial().intValue());
							}

							Cell cell4 = row.getCell(7);
							if (cell4 != null) {
								cell4.setCellValue(BRF37.getR12_gre() == null ? 0 : BRF37.getR12_gre().intValue());
							}

							Cell cell5 = row.getCell(8);
							if (cell5 != null) {
								cell5.setCellValue(BRF37.getR12_fdbi() == null ? 0 : BRF37.getR12_fdbi().intValue());
							}

							Cell cell6 = row.getCell(9);
							if (cell6 != null) {
								cell6.setCellValue(BRF37.getR12_sme() == null ? 0 : BRF37.getR12_sme().intValue());
							}

							Cell cell7 = row.getCell(10);
							if (cell7 != null) {
								cell7.setCellValue(
										BRF37.getR12_individual() == null ? 0 : BRF37.getR12_individual().intValue());
							}

							/////////////////////////////// R13//////////////////

							Row R1row = sheet.getRow(12);
							Cell R1cell = R1row.getCell(3);
							if (R1cell != null) {
								R1cell.setCellValue(BRF37.getR13_aed() == null ? 0 : BRF37.getR13_aed().intValue());
							}

							Cell R1cell1 = R1row.getCell(4);
							if (R1cell1 != null) {
								R1cell1.setCellValue(BRF37.getR13_fcy() == null ? 0 : BRF37.getR13_fcy().intValue());
							}

							Cell R1cell3 = R1row.getCell(6);
							if (R1cell3 != null) {
								R1cell3.setCellValue(
										BRF37.getR13_commercial() == null ? 0 : BRF37.getR13_commercial().intValue());
							}

							Cell R1cell4 = R1row.getCell(7);
							if (R1cell4 != null) {
								R1cell4.setCellValue(BRF37.getR13_gre() == null ? 0 : BRF37.getR13_gre().intValue());
							}

							Cell R1cell5 = R1row.getCell(8);
							if (R1cell5 != null) {
								R1cell5.setCellValue(BRF37.getR13_fdbi() == null ? 0 : BRF37.getR13_fdbi().intValue());
							}

							Cell R1cell6 = R1row.getCell(9);
							if (R1cell6 != null) {
								R1cell6.setCellValue(BRF37.getR13_sme() == null ? 0 : BRF37.getR13_sme().intValue());
							}

							Cell R1cell7 = R1row.getCell(10);
							if (R1cell7 != null) {
								R1cell7.setCellValue(
										BRF37.getR13_individual() == null ? 0 : BRF37.getR13_individual().intValue());
							}

							/////////////////////////////// R14//////////////////

							Row R2row = sheet.getRow(13);
							Cell R2cell = R2row.getCell(3);
							if (R2cell != null) {
								R2cell.setCellValue(BRF37.getR14_aed() == null ? 0 : BRF37.getR14_aed().intValue());
							}

							Cell R2cell1 = R2row.getCell(4);
							if (R2cell1 != null) {
								R2cell1.setCellValue(BRF37.getR14_fcy() == null ? 0 : BRF37.getR14_fcy().intValue());
							}

							Cell R2cell3 = R2row.getCell(6);
							if (R2cell3 != null) {
								R2cell3.setCellValue(
										BRF37.getR14_commercial() == null ? 0 : BRF37.getR14_commercial().intValue());
							}

							Cell R2cell4 = R2row.getCell(7);
							if (R2cell4 != null) {
								R2cell4.setCellValue(BRF37.getR14_gre() == null ? 0 : BRF37.getR14_gre().intValue());
							}

							Cell R2cell5 = R2row.getCell(8);
							if (R2cell5 != null) {
								R2cell5.setCellValue(BRF37.getR14_fdbi() == null ? 0 : BRF37.getR14_fdbi().intValue());
							}

							Cell R2cell6 = R2row.getCell(9);
							if (R2cell6 != null) {
								R2cell6.setCellValue(BRF37.getR14_sme() == null ? 0 : BRF37.getR14_sme().intValue());
							}

							Cell R2cell7 = R2row.getCell(10);
							if (R2cell7 != null) {
								R2cell7.setCellValue(
										BRF37.getR14_individual() == null ? 0 : BRF37.getR14_individual().intValue());
							}

							/////////////////////////////// R15//////////////////

							Row R3row = sheet.getRow(14);
							Cell R3cell = R3row.getCell(3);
							if (R3cell != null) {
								R3cell.setCellValue(BRF37.getR15_aed() == null ? 0 : BRF37.getR15_aed().intValue());
							}

							Cell R3cell1 = R3row.getCell(4);
							if (R3cell1 != null) {
								R3cell1.setCellValue(BRF37.getR15_fcy() == null ? 0 : BRF37.getR15_fcy().intValue());
							}

							Cell R3cell3 = R3row.getCell(6);
							if (R3cell3 != null) {
								R3cell3.setCellValue(
										BRF37.getR15_commercial() == null ? 0 : BRF37.getR15_commercial().intValue());
							}

							Cell R3cell4 = R3row.getCell(7);
							if (R3cell4 != null) {
								R3cell4.setCellValue(BRF37.getR15_gre() == null ? 0 : BRF37.getR15_gre().intValue());
							}

							Cell R3cell5 = R3row.getCell(8);
							if (R3cell5 != null) {
								R3cell5.setCellValue(BRF37.getR15_fdbi() == null ? 0 : BRF37.getR15_fdbi().intValue());
							}

							Cell R3cell6 = R3row.getCell(9);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF37.getR15_sme() == null ? 0 : BRF37.getR15_sme().intValue());
							}

							Cell R3cell7 = R3row.getCell(10);
							if (R3cell7 != null) {
								R3cell7.setCellValue(
										BRF37.getR15_individual() == null ? 0 : BRF37.getR15_individual().intValue());
							}

							/////////////////////////////// R17//////////////////

							Row R4row = sheet.getRow(16);
							Cell R4cell = R4row.getCell(3);
							if (R4cell != null) {
								R4cell.setCellValue(BRF37.getR17_aed() == null ? 0 : BRF37.getR17_aed().intValue());
							}

							Cell R4cell1 = R4row.getCell(4);
							if (R4cell1 != null) {
								R4cell1.setCellValue(BRF37.getR17_fcy() == null ? 0 : BRF37.getR17_fcy().intValue());
							}

							Cell R4cell3 = R4row.getCell(6);
							if (R4cell3 != null) {
								R4cell3.setCellValue(
										BRF37.getR17_commercial() == null ? 0 : BRF37.getR17_commercial().intValue());
							}

							Cell R4cell4 = R4row.getCell(7);
							if (R4cell4 != null) {
								R4cell4.setCellValue(BRF37.getR17_gre() == null ? 0 : BRF37.getR17_gre().intValue());
							}

							Cell R4cell5 = R4row.getCell(8);
							if (R4cell5 != null) {
								R4cell5.setCellValue(BRF37.getR17_fdbi() == null ? 0 : BRF37.getR17_fdbi().intValue());
							}

							Cell R4cell6 = R4row.getCell(9);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF37.getR17_sme() == null ? 0 : BRF37.getR17_sme().intValue());
							}

							Cell R4cell7 = R4row.getCell(10);
							if (R4cell7 != null) {
								R4cell7.setCellValue(
										BRF37.getR17_individual() == null ? 0 : BRF37.getR17_individual().intValue());
							}

							/////////////////////////////// R18//////////////////

							Row R5row = sheet.getRow(17);
							Cell R5cell = R5row.getCell(3);
							if (R5cell != null) {
								R5cell.setCellValue(BRF37.getR18_aed() == null ? 0 : BRF37.getR18_aed().intValue());
							}

							Cell R5cell1 = R5row.getCell(4);
							if (R5cell1 != null) {
								R5cell1.setCellValue(BRF37.getR18_fcy() == null ? 0 : BRF37.getR18_fcy().intValue());
							}

							Cell R5cell3 = R5row.getCell(6);
							if (R5cell3 != null) {
								R5cell3.setCellValue(
										BRF37.getR18_commercial() == null ? 0 : BRF37.getR18_commercial().intValue());
							}

							Cell R5cell4 = R5row.getCell(7);
							if (R5cell4 != null) {
								R5cell4.setCellValue(BRF37.getR18_gre() == null ? 0 : BRF37.getR18_gre().intValue());
							}

							Cell R5cell5 = R5row.getCell(8);
							if (R5cell5 != null) {
								R5cell5.setCellValue(BRF37.getR18_fdbi() == null ? 0 : BRF37.getR18_fdbi().intValue());
							}

							Cell R5cell6 = R5row.getCell(9);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF37.getR18_sme() == null ? 0 : BRF37.getR18_sme().intValue());
							}

							Cell R5cell7 = R5row.getCell(10);
							if (R5cell7 != null) {
								R5cell7.setCellValue(
										BRF37.getR18_individual() == null ? 0 : BRF37.getR18_individual().intValue());
							}

							/////////////////////////////// R19//////////////////

							Row R6row = sheet.getRow(18);
							Cell R6cell = R6row.getCell(3);
							if (R6cell != null) {
								R6cell.setCellValue(BRF37.getR19_aed() == null ? 0 : BRF37.getR19_aed().intValue());
							}

							Cell R6cell1 = R6row.getCell(4);
							if (R6cell1 != null) {
								R6cell1.setCellValue(BRF37.getR19_fcy() == null ? 0 : BRF37.getR19_fcy().intValue());
							}

							Cell R6cell3 = R6row.getCell(6);
							if (R6cell3 != null) {
								R6cell3.setCellValue(
										BRF37.getR19_commercial() == null ? 0 : BRF37.getR19_commercial().intValue());
							}

							Cell R6cell4 = R6row.getCell(7);
							if (R6cell4 != null) {
								R6cell4.setCellValue(BRF37.getR19_gre() == null ? 0 : BRF37.getR19_gre().intValue());
							}

							Cell R6cell5 = R6row.getCell(8);
							if (R6cell5 != null) {
								R6cell5.setCellValue(BRF37.getR19_fdbi() == null ? 0 : BRF37.getR19_fdbi().intValue());
							}

							Cell R6cell6 = R6row.getCell(9);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF37.getR19_sme() == null ? 0 : BRF37.getR19_sme().intValue());
							}

							Cell R6cell7 = R6row.getCell(10);
							if (R6cell7 != null) {
								R6cell7.setCellValue(
										BRF37.getR19_individual() == null ? 0 : BRF37.getR19_individual().intValue());
							}

							/////////////////////////////// R20//////////////////

							Row R7row = sheet.getRow(19);
							Cell R7cell = R7row.getCell(3);
							if (R7cell != null) {
								R7cell.setCellValue(BRF37.getR20_aed() == null ? 0 : BRF37.getR20_aed().intValue());
							}

							Cell R7cell1 = R7row.getCell(4);
							if (R7cell1 != null) {
								R7cell1.setCellValue(BRF37.getR20_fcy() == null ? 0 : BRF37.getR20_fcy().intValue());
							}

							Cell R7cell3 = R7row.getCell(6);
							if (R7cell3 != null) {
								R7cell3.setCellValue(
										BRF37.getR20_commercial() == null ? 0 : BRF37.getR20_commercial().intValue());
							}

							Cell R7cell4 = R7row.getCell(7);
							if (R7cell4 != null) {
								R7cell4.setCellValue(BRF37.getR20_gre() == null ? 0 : BRF37.getR20_gre().intValue());
							}

							Cell R7cell5 = R7row.getCell(8);
							if (R7cell5 != null) {
								R7cell5.setCellValue(BRF37.getR20_fdbi() == null ? 0 : BRF37.getR20_fdbi().intValue());
							}

							Cell R7cell6 = R7row.getCell(9);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF37.getR20_sme() == null ? 0 : BRF37.getR20_sme().intValue());
							}

							Cell R7cell7 = R7row.getCell(10);
							if (R7cell7 != null) {
								R7cell7.setCellValue(
										BRF37.getR20_individual() == null ? 0 : BRF37.getR20_individual().intValue());
							}

							/////////////////////////////// R21//////////////////

							Row R8row = sheet.getRow(20);
							Cell R8cell = R8row.getCell(3);
							if (R8cell != null) {
								R8cell.setCellValue(BRF37.getR21_aed() == null ? 0 : BRF37.getR21_aed().intValue());
							}

							Cell R8cell1 = R8row.getCell(4);
							if (R8cell1 != null) {
								R8cell1.setCellValue(BRF37.getR21_fcy() == null ? 0 : BRF37.getR21_fcy().intValue());
							}

							Cell R8cell3 = R8row.getCell(6);
							if (R8cell3 != null) {
								R8cell3.setCellValue(
										BRF37.getR21_commercial() == null ? 0 : BRF37.getR21_commercial().intValue());
							}

							Cell R8cell4 = R8row.getCell(7);
							if (R8cell4 != null) {
								R8cell4.setCellValue(BRF37.getR21_gre() == null ? 0 : BRF37.getR21_gre().intValue());
							}

							Cell R8cell5 = R8row.getCell(8);
							if (R8cell5 != null) {
								R8cell5.setCellValue(BRF37.getR21_fdbi() == null ? 0 : BRF37.getR21_fdbi().intValue());
							}

							Cell R8cell6 = R8row.getCell(9);
							if (R8cell6 != null) {
								R8cell6.setCellValue(BRF37.getR21_sme() == null ? 0 : BRF37.getR21_sme().intValue());
							}

							Cell R8cell7 = R8row.getCell(10);
							if (R8cell7 != null) {
								R8cell7.setCellValue(
										BRF37.getR21_individual() == null ? 0 : BRF37.getR21_individual().intValue());
							}

							/////////////////////////////// R22//////////////////

							Row R9row = sheet.getRow(21);
							Cell R9cell = R9row.getCell(3);
							if (R9cell != null) {
								R9cell.setCellValue(BRF37.getR22_aed() == null ? 0 : BRF37.getR22_aed().intValue());
							}

							Cell R9cell1 = R9row.getCell(4);
							if (R9cell1 != null) {
								R9cell1.setCellValue(BRF37.getR22_fcy() == null ? 0 : BRF37.getR22_fcy().intValue());
							}

							Cell R9cell3 = R9row.getCell(6);
							if (R9cell3 != null) {
								R9cell3.setCellValue(
										BRF37.getR22_commercial() == null ? 0 : BRF37.getR22_commercial().intValue());
							}

							Cell R9cell4 = R9row.getCell(7);
							if (R9cell4 != null) {
								R9cell4.setCellValue(BRF37.getR22_gre() == null ? 0 : BRF37.getR22_gre().intValue());
							}

							Cell R9cell5 = R9row.getCell(8);
							if (R9cell5 != null) {
								R9cell5.setCellValue(BRF37.getR22_fdbi() == null ? 0 : BRF37.getR22_fdbi().intValue());
							}

							Cell R9cell6 = R9row.getCell(9);
							if (R9cell6 != null) {
								R9cell6.setCellValue(BRF37.getR22_sme() == null ? 0 : BRF37.getR22_sme().intValue());
							}

							Cell R9cell7 = R9row.getCell(10);
							if (R9cell7 != null) {
								R9cell7.setCellValue(
										BRF37.getR22_individual() == null ? 0 : BRF37.getR22_individual().intValue());
							}

							/////////////////////////////// R23//////////////////

							Row R10row = sheet.getRow(22);
							Cell R10cell = R10row.getCell(3);
							if (R10cell != null) {
								R10cell.setCellValue(BRF37.getR23_aed() == null ? 0 : BRF37.getR23_aed().intValue());
							}

							Cell R10cell1 = R10row.getCell(4);
							if (R10cell1 != null) {
								R10cell1.setCellValue(BRF37.getR23_fcy() == null ? 0 : BRF37.getR23_fcy().intValue());
							}

							Cell R10cell3 = R10row.getCell(6);
							if (R10cell3 != null) {
								R10cell3.setCellValue(
										BRF37.getR23_commercial() == null ? 0 : BRF37.getR23_commercial().intValue());
							}

							Cell R10cell4 = R10row.getCell(7);
							if (R10cell4 != null) {
								R10cell4.setCellValue(BRF37.getR23_gre() == null ? 0 : BRF37.getR23_gre().intValue());
							}

							Cell R10cell5 = R10row.getCell(8);
							if (R10cell5 != null) {
								R10cell5.setCellValue(BRF37.getR23_fdbi() == null ? 0 : BRF37.getR23_fdbi().intValue());
							}

							Cell R10cell6 = R10row.getCell(9);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF37.getR23_sme() == null ? 0 : BRF37.getR23_sme().intValue());
							}

							Cell R10cell7 = R10row.getCell(10);
							if (R10cell7 != null) {
								R10cell7.setCellValue(
										BRF37.getR23_individual() == null ? 0 : BRF37.getR23_individual().intValue());
							}

							/////////////////////////////// R24//////////////////

							Row R11row = sheet.getRow(23);
							Cell R11cell = R11row.getCell(3);
							if (R11cell != null) {
								R11cell.setCellValue(BRF37.getR24_aed() == null ? 0 : BRF37.getR24_aed().intValue());
							}

							Cell R11cell1 = R11row.getCell(4);
							if (R11cell1 != null) {
								R11cell1.setCellValue(BRF37.getR24_fcy() == null ? 0 : BRF37.getR24_fcy().intValue());
							}

							Cell R11cell3 = R11row.getCell(6);
							if (R11cell3 != null) {
								R11cell3.setCellValue(
										BRF37.getR24_commercial() == null ? 0 : BRF37.getR24_commercial().intValue());
							}

							Cell R11cell4 = R11row.getCell(7);
							if (R11cell4 != null) {
								R11cell4.setCellValue(BRF37.getR24_gre() == null ? 0 : BRF37.getR24_gre().intValue());
							}

							Cell R11cell5 = R11row.getCell(8);
							if (R11cell5 != null) {
								R11cell5.setCellValue(BRF37.getR24_fdbi() == null ? 0 : BRF37.getR24_fdbi().intValue());
							}

							Cell R11cell6 = R11row.getCell(9);
							if (R11cell6 != null) {
								R11cell6.setCellValue(BRF37.getR24_sme() == null ? 0 : BRF37.getR24_sme().intValue());
							}

							Cell R11cell7 = R11row.getCell(10);
							if (R11cell7 != null) {
								R11cell7.setCellValue(
										BRF37.getR24_individual() == null ? 0 : BRF37.getR24_individual().intValue());
							}

							/////////////////////////////// R25//////////////////

							Row R12row = sheet.getRow(24);
							Cell R12cell = R12row.getCell(3);
							if (R12cell != null) {
								R12cell.setCellValue(BRF37.getR25_aed() == null ? 0 : BRF37.getR25_aed().intValue());
							}

							Cell R12cell1 = R12row.getCell(4);
							if (R12cell1 != null) {
								R12cell1.setCellValue(BRF37.getR25_fcy() == null ? 0 : BRF37.getR25_fcy().intValue());
							}

							Cell R12cell3 = R12row.getCell(6);
							if (R12cell3 != null) {
								R12cell3.setCellValue(
										BRF37.getR25_commercial() == null ? 0 : BRF37.getR25_commercial().intValue());
							}

							Cell R12cell4 = R12row.getCell(7);
							if (R12cell4 != null) {
								R12cell4.setCellValue(BRF37.getR25_gre() == null ? 0 : BRF37.getR25_gre().intValue());
							}

							Cell R12cell5 = R12row.getCell(8);
							if (R12cell5 != null) {
								R12cell5.setCellValue(BRF37.getR25_fdbi() == null ? 0 : BRF37.getR25_fdbi().intValue());
							}

							Cell R12cell6 = R12row.getCell(9);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF37.getR25_sme() == null ? 0 : BRF37.getR25_sme().intValue());
							}

							Cell R12cell7 = R12row.getCell(10);
							if (R12cell7 != null) {
								R12cell7.setCellValue(
										BRF37.getR25_individual() == null ? 0 : BRF37.getR25_individual().intValue());
							}

							/////////////////////////////// R26//////////////////

							Row R13row = sheet.getRow(25);
							Cell R13cell = R13row.getCell(3);
							if (R13cell != null) {
								R13cell.setCellValue(BRF37.getR26_aed() == null ? 0 : BRF37.getR26_aed().intValue());
							}

							Cell R13cell1 = R13row.getCell(4);
							if (R13cell1 != null) {
								R13cell1.setCellValue(BRF37.getR26_fcy() == null ? 0 : BRF37.getR26_fcy().intValue());
							}

							Cell R13cell3 = R13row.getCell(6);
							if (R13cell3 != null) {
								R13cell3.setCellValue(
										BRF37.getR26_commercial() == null ? 0 : BRF37.getR26_commercial().intValue());
							}

							Cell R13cell4 = R13row.getCell(7);
							if (R13cell4 != null) {
								R13cell4.setCellValue(BRF37.getR26_gre() == null ? 0 : BRF37.getR26_gre().intValue());
							}

							Cell R13cell5 = R13row.getCell(8);
							if (R13cell5 != null) {
								R13cell5.setCellValue(BRF37.getR26_fdbi() == null ? 0 : BRF37.getR26_fdbi().intValue());
							}

							Cell R13cell6 = R13row.getCell(9);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF37.getR26_sme() == null ? 0 : BRF37.getR26_sme().intValue());
							}

							Cell R13cell7 = R13row.getCell(10);
							if (R13cell7 != null) {
								R13cell7.setCellValue(
										BRF37.getR26_individual() == null ? 0 : BRF37.getR26_individual().intValue());
							}

							/////////////////////////////// R28//////////////////

							Row R14row = sheet.getRow(27);
							Cell R14cell = R14row.getCell(3);
							if (R14cell != null) {
								R14cell.setCellValue(BRF37.getR28_aed() == null ? 0 : BRF37.getR28_aed().intValue());
							}

							Cell R14cell1 = R14row.getCell(4);
							if (R14cell1 != null) {
								R14cell1.setCellValue(BRF37.getR28_fcy() == null ? 0 : BRF37.getR28_fcy().intValue());
							}

							Cell R14cell3 = R14row.getCell(6);
							if (R14cell3 != null) {
								R14cell3.setCellValue(
										BRF37.getR28_commercial() == null ? 0 : BRF37.getR28_commercial().intValue());
							}

							Cell R14cell4 = R14row.getCell(7);
							if (R14cell4 != null) {
								R14cell4.setCellValue(BRF37.getR28_gre() == null ? 0 : BRF37.getR28_gre().intValue());
							}

							Cell R14cell5 = R14row.getCell(8);
							if (R14cell5 != null) {
								R14cell5.setCellValue(BRF37.getR28_fdbi() == null ? 0 : BRF37.getR28_fdbi().intValue());
							}

							Cell R14cell6 = R14row.getCell(9);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF37.getR28_sme() == null ? 0 : BRF37.getR28_sme().intValue());
							}

							Cell R14cell7 = R14row.getCell(10);
							if (R14cell7 != null) {
								R14cell7.setCellValue(
										BRF37.getR28_individual() == null ? 0 : BRF37.getR28_individual().intValue());
							}

							/////////////////////////////// R29//////////////////

							Row R15row = sheet.getRow(28);
							Cell R15cell = R15row.getCell(3);
							if (R15cell != null) {
								R15cell.setCellValue(BRF37.getR29_aed() == null ? 0 : BRF37.getR29_aed().intValue());
							}

							Cell R15cell1 = R15row.getCell(4);
							if (R15cell1 != null) {
								R15cell1.setCellValue(BRF37.getR29_fcy() == null ? 0 : BRF37.getR29_fcy().intValue());
							}

							Cell R15cell3 = R15row.getCell(6);
							if (R15cell3 != null) {
								R15cell3.setCellValue(
										BRF37.getR29_commercial() == null ? 0 : BRF37.getR29_commercial().intValue());
							}

							Cell R15cell4 = R15row.getCell(7);
							if (R15cell4 != null) {
								R15cell4.setCellValue(BRF37.getR29_gre() == null ? 0 : BRF37.getR29_gre().intValue());
							}

							Cell R15cell5 = R15row.getCell(8);
							if (R15cell5 != null) {
								R15cell5.setCellValue(BRF37.getR29_fdbi() == null ? 0 : BRF37.getR29_fdbi().intValue());
							}

							Cell R15cell6 = R15row.getCell(9);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF37.getR29_sme() == null ? 0 : BRF37.getR29_sme().intValue());
							}

							Cell R15cell7 = R15row.getCell(10);
							if (R15cell7 != null) {
								R15cell7.setCellValue(
										BRF37.getR29_individual() == null ? 0 : BRF37.getR29_individual().intValue());
							}

							/////////////////////////////// R30//////////////////

							Row R16row = sheet.getRow(29);
							Cell R16cell = R16row.getCell(3);
							if (R16cell != null) {
								R16cell.setCellValue(BRF37.getR30_aed() == null ? 0 : BRF37.getR30_aed().intValue());
							}

							Cell R16cell1 = R16row.getCell(4);
							if (R16cell1 != null) {
								R16cell1.setCellValue(BRF37.getR30_fcy() == null ? 0 : BRF37.getR30_fcy().intValue());
							}

							Cell R16cell3 = R16row.getCell(6);
							if (R16cell3 != null) {
								R16cell3.setCellValue(
										BRF37.getR30_commercial() == null ? 0 : BRF37.getR30_commercial().intValue());
							}

							Cell R16cell4 = R16row.getCell(7);
							if (R16cell4 != null) {
								R16cell4.setCellValue(BRF37.getR30_gre() == null ? 0 : BRF37.getR30_gre().intValue());
							}

							Cell R16cell5 = R16row.getCell(8);
							if (R16cell5 != null) {
								R16cell5.setCellValue(BRF37.getR30_fdbi() == null ? 0 : BRF37.getR30_fdbi().intValue());
							}

							Cell R16cell6 = R16row.getCell(9);
							if (R16cell6 != null) {
								R16cell6.setCellValue(BRF37.getR30_sme() == null ? 0 : BRF37.getR30_sme().intValue());
							}

							Cell R16cell7 = R16row.getCell(10);
							if (R16cell7 != null) {
								R16cell7.setCellValue(
										BRF37.getR30_individual() == null ? 0 : BRF37.getR30_individual().intValue());
							}

							/////////////////////////////// R31//////////////////

							Row R17row = sheet.getRow(30);
							Cell R17cell = R17row.getCell(3);
							if (R17cell != null) {
								R17cell.setCellValue(BRF37.getR31_aed() == null ? 0 : BRF37.getR31_aed().intValue());
							}

							Cell R17cell1 = R17row.getCell(4);
							if (R17cell1 != null) {
								R17cell1.setCellValue(BRF37.getR31_fcy() == null ? 0 : BRF37.getR31_fcy().intValue());
							}

							Cell R17cell3 = R17row.getCell(6);
							if (R17cell3 != null) {
								R17cell3.setCellValue(
										BRF37.getR31_commercial() == null ? 0 : BRF37.getR31_commercial().intValue());
							}

							Cell R17cell4 = R17row.getCell(7);
							if (R17cell4 != null) {
								R17cell4.setCellValue(BRF37.getR31_gre() == null ? 0 : BRF37.getR31_gre().intValue());
							}

							Cell R17cell5 = R17row.getCell(8);
							if (R17cell5 != null) {
								R17cell5.setCellValue(BRF37.getR31_fdbi() == null ? 0 : BRF37.getR31_fdbi().intValue());
							}

							Cell R17cell6 = R17row.getCell(9);
							if (R17cell6 != null) {
								R17cell6.setCellValue(BRF37.getR31_sme() == null ? 0 : BRF37.getR31_sme().intValue());
							}

							Cell R17cell7 = R17row.getCell(10);
							if (R17cell7 != null) {
								R17cell7.setCellValue(
										BRF37.getR31_individual() == null ? 0 : BRF37.getR31_individual().intValue());
							}

							/////////////////////////////// R34//////////////////

							Row R18row = sheet.getRow(33);
							Cell R18cell = R18row.getCell(3);
							if (R18cell != null) {
								R18cell.setCellValue(BRF37.getR34_aed() == null ? 0 : BRF37.getR34_aed().intValue());
							}

							Cell R18cell1 = R18row.getCell(4);
							if (R18cell1 != null) {
								R18cell1.setCellValue(BRF37.getR34_fcy() == null ? 0 : BRF37.getR34_fcy().intValue());
							}

							Cell R18cell3 = R18row.getCell(6);
							if (R18cell3 != null) {
								R18cell3.setCellValue(
										BRF37.getR34_commercial() == null ? 0 : BRF37.getR34_commercial().intValue());
							}

							Cell R18cell4 = R18row.getCell(7);
							if (R18cell4 != null) {
								R18cell4.setCellValue(BRF37.getR34_gre() == null ? 0 : BRF37.getR34_gre().intValue());
							}

							Cell R18cell5 = R18row.getCell(8);
							if (R18cell5 != null) {
								R18cell5.setCellValue(BRF37.getR34_fdbi() == null ? 0 : BRF37.getR34_fdbi().intValue());
							}

							Cell R18cell6 = R18row.getCell(9);
							if (R18cell6 != null) {
								R18cell6.setCellValue(BRF37.getR34_sme() == null ? 0 : BRF37.getR34_sme().intValue());
							}

							Cell R18cell7 = R18row.getCell(10);
							if (R18cell7 != null) {
								R18cell7.setCellValue(
										BRF37.getR34_individual() == null ? 0 : BRF37.getR34_individual().intValue());
							}

							/////////////////////////////// R35//////////////////

							Row R19row = sheet.getRow(34);
							Cell R19cell = R19row.getCell(3);
							if (R19cell != null) {
								R19cell.setCellValue(BRF37.getR35_aed() == null ? 0 : BRF37.getR35_aed().intValue());
							}

							Cell R19cell1 = R19row.getCell(4);
							if (R19cell1 != null) {
								R19cell1.setCellValue(BRF37.getR35_fcy() == null ? 0 : BRF37.getR35_fcy().intValue());
							}

							Cell R19cell3 = R19row.getCell(6);
							if (R19cell3 != null) {
								R19cell3.setCellValue(
										BRF37.getR35_commercial() == null ? 0 : BRF37.getR35_commercial().intValue());
							}

							Cell R19cell4 = R19row.getCell(7);
							if (R19cell4 != null) {
								R19cell4.setCellValue(BRF37.getR35_gre() == null ? 0 : BRF37.getR35_gre().intValue());
							}

							Cell R19cell5 = R19row.getCell(8);
							if (R19cell5 != null) {
								R19cell5.setCellValue(BRF37.getR35_fdbi() == null ? 0 : BRF37.getR35_fdbi().intValue());
							}

							Cell R19cell6 = R19row.getCell(9);
							if (R19cell6 != null) {
								R19cell6.setCellValue(BRF37.getR35_sme() == null ? 0 : BRF37.getR35_sme().intValue());
							}

							Cell R19cell7 = R19row.getCell(10);
							if (R19cell7 != null) {
								R19cell7.setCellValue(
										BRF37.getR35_individual() == null ? 0 : BRF37.getR35_individual().intValue());
							}

							/////////////////////////////// R36//////////////////

							Row R20row = sheet.getRow(35);
							Cell R20cell = R20row.getCell(3);
							if (R20cell != null) {
								R20cell.setCellValue(BRF37.getR36_aed() == null ? 0 : BRF37.getR36_aed().intValue());
							}

							Cell R20cell1 = R20row.getCell(4);
							if (R20cell1 != null) {
								R20cell1.setCellValue(BRF37.getR36_fcy() == null ? 0 : BRF37.getR36_fcy().intValue());
							}

							Cell R20cell3 = R20row.getCell(6);
							if (R20cell3 != null) {
								R20cell3.setCellValue(
										BRF37.getR36_commercial() == null ? 0 : BRF37.getR36_commercial().intValue());
							}

							Cell R20cell4 = R20row.getCell(7);
							if (R20cell4 != null) {
								R20cell4.setCellValue(BRF37.getR36_gre() == null ? 0 : BRF37.getR36_gre().intValue());
							}

							Cell R20cell5 = R20row.getCell(8);
							if (R20cell5 != null) {
								R20cell5.setCellValue(BRF37.getR36_fdbi() == null ? 0 : BRF37.getR36_fdbi().intValue());
							}

							Cell R20cell6 = R20row.getCell(9);
							if (R20cell6 != null) {
								R20cell6.setCellValue(BRF37.getR36_sme() == null ? 0 : BRF37.getR36_sme().intValue());
							}

							Cell R20cell7 = R20row.getCell(10);
							if (R20cell7 != null) {
								R20cell7.setCellValue(
										BRF37.getR36_individual() == null ? 0 : BRF37.getR36_individual().intValue());
							}

							/////////////////////////////// R37//////////////////

							Row R21row = sheet.getRow(36);
							Cell R21cell = R21row.getCell(3);
							if (R21cell != null) {
								R21cell.setCellValue(BRF37.getR37_aed() == null ? 0 : BRF37.getR37_aed().intValue());
							}

							Cell R21cell1 = R21row.getCell(4);
							if (R21cell1 != null) {
								R21cell1.setCellValue(BRF37.getR37_fcy() == null ? 0 : BRF37.getR37_fcy().intValue());
							}

							Cell R21cell3 = R21row.getCell(6);
							if (R21cell3 != null) {
								R21cell3.setCellValue(
										BRF37.getR37_commercial() == null ? 0 : BRF37.getR37_commercial().intValue());
							}

							Cell R21cell4 = R21row.getCell(7);
							if (R21cell4 != null) {
								R21cell4.setCellValue(BRF37.getR37_gre() == null ? 0 : BRF37.getR37_gre().intValue());
							}

							Cell R21cell5 = R21row.getCell(8);
							if (R21cell5 != null) {
								R21cell5.setCellValue(BRF37.getR37_fdbi() == null ? 0 : BRF37.getR37_fdbi().intValue());
							}

							Cell R21cell6 = R21row.getCell(9);
							if (R21cell6 != null) {
								R21cell6.setCellValue(BRF37.getR37_sme() == null ? 0 : BRF37.getR37_sme().intValue());
							}

							Cell R21cell7 = R21row.getCell(10);
							if (R21cell7 != null) {
								R21cell7.setCellValue(
										BRF37.getR37_individual() == null ? 0 : BRF37.getR37_individual().intValue());
							}

							/////////////////////////////// R38//////////////////

							Row R22row = sheet.getRow(37);
							Cell R22cell = R22row.getCell(3);
							if (R22cell != null) {
								R22cell.setCellValue(BRF37.getR38_aed() == null ? 0 : BRF37.getR38_aed().intValue());
							}

							Cell R22cell1 = R22row.getCell(4);
							if (R22cell1 != null) {
								R22cell1.setCellValue(BRF37.getR38_fcy() == null ? 0 : BRF37.getR38_fcy().intValue());
							}

							Cell R22cell3 = R22row.getCell(6);
							if (R22cell3 != null) {
								R22cell3.setCellValue(
										BRF37.getR38_commercial() == null ? 0 : BRF37.getR38_commercial().intValue());
							}

							Cell R22cell4 = R22row.getCell(7);
							if (R22cell4 != null) {
								R22cell4.setCellValue(BRF37.getR38_gre() == null ? 0 : BRF37.getR38_gre().intValue());
							}

							Cell R22cell5 = R22row.getCell(8);
							if (R22cell5 != null) {
								R22cell5.setCellValue(BRF37.getR38_fdbi() == null ? 0 : BRF37.getR38_fdbi().intValue());
							}

							Cell R22cell6 = R22row.getCell(9);
							if (R22cell6 != null) {
								R22cell6.setCellValue(BRF37.getR38_sme() == null ? 0 : BRF37.getR38_sme().intValue());
							}

							Cell R22cell7 = R22row.getCell(10);
							if (R22cell7 != null) {
								R22cell7.setCellValue(
										BRF37.getR38_individual() == null ? 0 : BRF37.getR38_individual().intValue());
							}

							/////////////////////////////// R39//////////////////

							Row R23row = sheet.getRow(38);
							Cell R23cell = R23row.getCell(3);
							if (R23cell != null) {
								R23cell.setCellValue(BRF37.getR39_aed() == null ? 0 : BRF37.getR39_aed().intValue());
							}

							Cell R23cell1 = R23row.getCell(4);
							if (R23cell1 != null) {
								R23cell1.setCellValue(BRF37.getR39_fcy() == null ? 0 : BRF37.getR39_fcy().intValue());
							}

							Cell R23cell3 = R23row.getCell(6);
							if (R23cell3 != null) {
								R23cell3.setCellValue(
										BRF37.getR39_commercial() == null ? 0 : BRF37.getR39_commercial().intValue());
							}

							Cell R23cell4 = R23row.getCell(7);
							if (R23cell4 != null) {
								R23cell4.setCellValue(BRF37.getR39_gre() == null ? 0 : BRF37.getR39_gre().intValue());
							}

							Cell R23cell5 = R23row.getCell(8);
							if (R23cell5 != null) {
								R23cell5.setCellValue(BRF37.getR39_fdbi() == null ? 0 : BRF37.getR39_fdbi().intValue());
							}

							Cell R23cell6 = R23row.getCell(9);
							if (R23cell6 != null) {
								R23cell6.setCellValue(BRF37.getR39_sme() == null ? 0 : BRF37.getR39_sme().intValue());
							}

							Cell R23cell7 = R23row.getCell(10);
							if (R23cell7 != null) {
								R23cell7.setCellValue(
										BRF37.getR39_individual() == null ? 0 : BRF37.getR39_individual().intValue());
							}

							/////////////////////////////// R40//////////////////

							Row R24row = sheet.getRow(39);
							Cell R24cell = R24row.getCell(3);
							if (R24cell != null) {
								R24cell.setCellValue(BRF37.getR40_aed() == null ? 0 : BRF37.getR40_aed().intValue());
							}

							Cell R24cell1 = R24row.getCell(4);
							if (R24cell1 != null) {
								R24cell1.setCellValue(BRF37.getR40_fcy() == null ? 0 : BRF37.getR40_fcy().intValue());
							}

							Cell R24cell3 = R24row.getCell(6);
							if (R24cell3 != null) {
								R24cell3.setCellValue(
										BRF37.getR40_commercial() == null ? 0 : BRF37.getR40_commercial().intValue());
							}

							Cell R24cell4 = R24row.getCell(7);
							if (R24cell4 != null) {
								R24cell4.setCellValue(BRF37.getR40_gre() == null ? 0 : BRF37.getR40_gre().intValue());
							}

							Cell R24cell5 = R24row.getCell(8);
							if (R24cell5 != null) {
								R24cell5.setCellValue(BRF37.getR40_fdbi() == null ? 0 : BRF37.getR40_fdbi().intValue());
							}

							Cell R24cell6 = R24row.getCell(9);
							if (R24cell6 != null) {
								R24cell6.setCellValue(BRF37.getR40_sme() == null ? 0 : BRF37.getR40_sme().intValue());
							}

							Cell R24cell7 = R24row.getCell(10);
							if (R24cell7 != null) {
								R24cell7.setCellValue(
										BRF37.getR40_individual() == null ? 0 : BRF37.getR40_individual().intValue());
							}

							/////////////////////////////// R41//////////////////

							Row R25row = sheet.getRow(40);
							Cell R25cell = R25row.getCell(3);
							if (R25cell != null) {
								R25cell.setCellValue(BRF37.getR41_aed() == null ? 0 : BRF37.getR41_aed().intValue());
							}

							Cell R25cell1 = R25row.getCell(4);
							if (R25cell1 != null) {
								R25cell1.setCellValue(BRF37.getR41_fcy() == null ? 0 : BRF37.getR41_fcy().intValue());
							}

							Cell R25cell3 = R25row.getCell(6);
							if (R25cell3 != null) {
								R25cell3.setCellValue(
										BRF37.getR41_commercial() == null ? 0 : BRF37.getR41_commercial().intValue());
							}

							Cell R25cell4 = R25row.getCell(7);
							if (R25cell4 != null) {
								R25cell4.setCellValue(BRF37.getR41_gre() == null ? 0 : BRF37.getR41_gre().intValue());
							}

							Cell R25cell5 = R25row.getCell(8);
							if (R25cell5 != null) {
								R25cell5.setCellValue(BRF37.getR41_fdbi() == null ? 0 : BRF37.getR41_fdbi().intValue());
							}

							Cell R25cell6 = R25row.getCell(9);
							if (R25cell6 != null) {
								R25cell6.setCellValue(BRF37.getR41_sme() == null ? 0 : BRF37.getR41_sme().intValue());
							}

							Cell R25cell7 = R25row.getCell(10);
							if (R25cell7 != null) {
								R25cell7.setCellValue(
										BRF37.getR41_individual() == null ? 0 : BRF37.getR41_individual().intValue());
							}

							/////////////////////////////// R42//////////////////

							Row R26row = sheet.getRow(41);
							Cell R26cell = R26row.getCell(3);
							if (R26cell != null) {
								R26cell.setCellValue(BRF37.getR42_aed() == null ? 0 : BRF37.getR42_aed().intValue());
							}

							Cell R26cell1 = R26row.getCell(4);
							if (R26cell1 != null) {
								R26cell1.setCellValue(BRF37.getR42_fcy() == null ? 0 : BRF37.getR42_fcy().intValue());
							}

							Cell R26cell3 = R26row.getCell(6);
							if (R26cell3 != null) {
								R26cell3.setCellValue(
										BRF37.getR42_commercial() == null ? 0 : BRF37.getR42_commercial().intValue());
							}

							Cell R26cell4 = R26row.getCell(7);
							if (R26cell4 != null) {
								R26cell4.setCellValue(BRF37.getR42_gre() == null ? 0 : BRF37.getR42_gre().intValue());
							}

							Cell R26cell5 = R26row.getCell(8);
							if (R26cell5 != null) {
								R26cell5.setCellValue(BRF37.getR42_fdbi() == null ? 0 : BRF37.getR42_fdbi().intValue());
							}

							Cell R26cell6 = R26row.getCell(9);
							if (R26cell6 != null) {
								R26cell6.setCellValue(BRF37.getR42_sme() == null ? 0 : BRF37.getR42_sme().intValue());
							}

							Cell R26cell7 = R26row.getCell(10);
							if (R26cell7 != null) {
								R26cell7.setCellValue(
										BRF37.getR42_individual() == null ? 0 : BRF37.getR42_individual().intValue());
							}

							/////////////////////////////// R43//////////////////

							Row R27row = sheet.getRow(42);
							Cell R27cell = R27row.getCell(3);
							if (R27cell != null) {
								R27cell.setCellValue(BRF37.getR43_aed() == null ? 0 : BRF37.getR43_aed().intValue());
							}

							Cell R27cell1 = R27row.getCell(4);
							if (R27cell1 != null) {
								R27cell1.setCellValue(BRF37.getR43_fcy() == null ? 0 : BRF37.getR43_fcy().intValue());
							}

							Cell R27cell3 = R27row.getCell(6);
							if (R27cell3 != null) {
								R27cell3.setCellValue(
										BRF37.getR43_commercial() == null ? 0 : BRF37.getR43_commercial().intValue());
							}

							Cell R27cell4 = R27row.getCell(7);
							if (R27cell4 != null) {
								R27cell4.setCellValue(BRF37.getR43_gre() == null ? 0 : BRF37.getR43_gre().intValue());
							}

							Cell R27cell5 = R27row.getCell(8);
							if (R27cell5 != null) {
								R27cell5.setCellValue(BRF37.getR43_fdbi() == null ? 0 : BRF37.getR43_fdbi().intValue());
							}

							Cell R27cell6 = R27row.getCell(9);
							if (R27cell6 != null) {
								R27cell6.setCellValue(BRF37.getR43_sme() == null ? 0 : BRF37.getR43_sme().intValue());
							}

							Cell R27cell7 = R27row.getCell(10);
							if (R27cell7 != null) {
								R27cell7.setCellValue(
										BRF37.getR43_individual() == null ? 0 : BRF37.getR43_individual().intValue());
							}

							/////////////////////////////// R45//////////////////

							Row R28row = sheet.getRow(44);
							Cell R28cell = R28row.getCell(3);
							if (R28cell != null) {
								R28cell.setCellValue(BRF37.getR45_aed() == null ? 0 : BRF37.getR45_aed().intValue());
							}

							Cell R28cell1 = R28row.getCell(4);
							if (R28cell1 != null) {
								R28cell1.setCellValue(BRF37.getR45_fcy() == null ? 0 : BRF37.getR45_fcy().intValue());
							}

							Cell R28cell3 = R28row.getCell(6);
							if (R28cell3 != null) {
								R28cell3.setCellValue(
										BRF37.getR45_commercial() == null ? 0 : BRF37.getR45_commercial().intValue());
							}

							Cell R28cell4 = R28row.getCell(7);
							if (R28cell4 != null) {
								R28cell4.setCellValue(BRF37.getR45_gre() == null ? 0 : BRF37.getR45_gre().intValue());
							}

							Cell R28cell5 = R28row.getCell(8);
							if (R28cell5 != null) {
								R28cell5.setCellValue(BRF37.getR45_fdbi() == null ? 0 : BRF37.getR45_fdbi().intValue());
							}

							Cell R28cell6 = R28row.getCell(9);
							if (R28cell6 != null) {
								R28cell6.setCellValue(BRF37.getR45_sme() == null ? 0 : BRF37.getR45_sme().intValue());
							}

							Cell R28cell7 = R28row.getCell(10);
							if (R28cell7 != null) {
								R28cell7.setCellValue(
										BRF37.getR45_individual() == null ? 0 : BRF37.getR45_individual().intValue());
							}

							/////////////////////////////// R46//////////////////

							Row R29row = sheet.getRow(45);
							Cell R29cell = R29row.getCell(3);
							if (R29cell != null) {
								R29cell.setCellValue(BRF37.getR46_aed() == null ? 0 : BRF37.getR46_aed().intValue());
							}

							Cell R29cell1 = R29row.getCell(4);
							if (R29cell1 != null) {
								R29cell1.setCellValue(BRF37.getR46_fcy() == null ? 0 : BRF37.getR46_fcy().intValue());
							}

							Cell R29cell3 = R29row.getCell(6);
							if (R29cell3 != null) {
								R29cell3.setCellValue(
										BRF37.getR46_commercial() == null ? 0 : BRF37.getR46_commercial().intValue());
							}

							Cell R29cell4 = R29row.getCell(7);
							if (R29cell4 != null) {
								R29cell4.setCellValue(BRF37.getR46_gre() == null ? 0 : BRF37.getR46_gre().intValue());
							}

							Cell R29cell5 = R29row.getCell(8);
							if (R29cell5 != null) {
								R29cell5.setCellValue(BRF37.getR46_fdbi() == null ? 0 : BRF37.getR46_fdbi().intValue());
							}

							Cell R29cell6 = R29row.getCell(9);
							if (R29cell6 != null) {
								R29cell6.setCellValue(BRF37.getR46_sme() == null ? 0 : BRF37.getR46_sme().intValue());
							}

							Cell R29cell7 = R29row.getCell(10);
							if (R29cell7 != null) {
								R29cell7.setCellValue(
										BRF37.getR46_individual() == null ? 0 : BRF37.getR46_individual().intValue());
							}

							/////////////////////////////// R47//////////////////

							Row R30row = sheet.getRow(46);
							Cell R30cell = R30row.getCell(3);
							if (R30cell != null) {
								R30cell.setCellValue(BRF37.getR47_aed() == null ? 0 : BRF37.getR47_aed().intValue());
							}

							Cell R30cell1 = R30row.getCell(4);
							if (R30cell1 != null) {
								R30cell1.setCellValue(BRF37.getR47_fcy() == null ? 0 : BRF37.getR47_fcy().intValue());
							}

							Cell R30cell3 = R30row.getCell(6);
							if (R30cell3 != null) {
								R30cell3.setCellValue(
										BRF37.getR47_commercial() == null ? 0 : BRF37.getR47_commercial().intValue());
							}

							Cell R30cell4 = R30row.getCell(7);
							if (R30cell4 != null) {
								R30cell4.setCellValue(BRF37.getR47_gre() == null ? 0 : BRF37.getR47_gre().intValue());
							}

							Cell R30cell5 = R30row.getCell(8);
							if (R30cell5 != null) {
								R30cell5.setCellValue(BRF37.getR47_fdbi() == null ? 0 : BRF37.getR47_fdbi().intValue());
							}

							Cell R30cell6 = R30row.getCell(9);
							if (R30cell6 != null) {
								R30cell6.setCellValue(BRF37.getR47_sme() == null ? 0 : BRF37.getR47_sme().intValue());
							}

							Cell R30cell7 = R30row.getCell(10);
							if (R30cell7 != null) {
								R30cell7.setCellValue(
										BRF37.getR47_individual() == null ? 0 : BRF37.getR47_individual().intValue());
							}

							/////////////////////////////// R48//////////////////

							Row R31row = sheet.getRow(47);
							Cell R31cell = R31row.getCell(3);
							if (R31cell != null) {
								R31cell.setCellValue(BRF37.getR48_aed() == null ? 0 : BRF37.getR48_aed().intValue());
							}

							Cell R31cell1 = R31row.getCell(4);
							if (R31cell1 != null) {
								R31cell1.setCellValue(BRF37.getR48_fcy() == null ? 0 : BRF37.getR48_fcy().intValue());
							}

							Cell R31cell3 = R31row.getCell(6);
							if (R31cell3 != null) {
								R31cell3.setCellValue(
										BRF37.getR48_commercial() == null ? 0 : BRF37.getR48_commercial().intValue());
							}

							Cell R31cell4 = R31row.getCell(7);
							if (R31cell4 != null) {
								R31cell4.setCellValue(BRF37.getR48_gre() == null ? 0 : BRF37.getR48_gre().intValue());
							}

							Cell R31cell5 = R31row.getCell(8);
							if (R31cell5 != null) {
								R31cell5.setCellValue(BRF37.getR48_fdbi() == null ? 0 : BRF37.getR48_fdbi().intValue());
							}

							Cell R31cell6 = R31row.getCell(9);
							if (R31cell6 != null) {
								R31cell6.setCellValue(BRF37.getR48_sme() == null ? 0 : BRF37.getR48_sme().intValue());
							}

							Cell R31cell7 = R31row.getCell(10);
							if (R31cell7 != null) {
								R31cell7.setCellValue(
										BRF37.getR48_individual() == null ? 0 : BRF37.getR48_individual().intValue());
							}

							/////////////////////////////// R49//////////////////

							Row R32row = sheet.getRow(48);
							Cell R32cell = R32row.getCell(3);
							if (R32cell != null) {
								R32cell.setCellValue(BRF37.getR49_aed() == null ? 0 : BRF37.getR49_aed().intValue());
							}

							Cell R32cell1 = R32row.getCell(4);
							if (R32cell1 != null) {
								R32cell1.setCellValue(BRF37.getR49_fcy() == null ? 0 : BRF37.getR49_fcy().intValue());
							}

							Cell R32cell3 = R32row.getCell(6);
							if (R32cell3 != null) {
								R32cell3.setCellValue(
										BRF37.getR49_commercial() == null ? 0 : BRF37.getR49_commercial().intValue());
							}

							Cell R32cell4 = R32row.getCell(7);
							if (R32cell4 != null) {
								R32cell4.setCellValue(BRF37.getR49_gre() == null ? 0 : BRF37.getR49_gre().intValue());
							}

							Cell R32cell5 = R32row.getCell(8);
							if (R32cell5 != null) {
								R32cell5.setCellValue(BRF37.getR49_fdbi() == null ? 0 : BRF37.getR49_fdbi().intValue());
							}

							Cell R32cell6 = R32row.getCell(9);
							if (R32cell6 != null) {
								R32cell6.setCellValue(BRF37.getR49_sme() == null ? 0 : BRF37.getR49_sme().intValue());
							}

							Cell R32cell7 = R32row.getCell(10);
							if (R32cell7 != null) {
								R32cell7.setCellValue(
										BRF37.getR49_individual() == null ? 0 : BRF37.getR49_individual().intValue());
							}

							/////////////////////////////// R50//////////////////

							Row R33row = sheet.getRow(49);
							Cell R33cell = R33row.getCell(3);
							if (R33cell != null) {
								R33cell.setCellValue(BRF37.getR50_aed() == null ? 0 : BRF37.getR50_aed().intValue());
							}

							Cell R33cell1 = R33row.getCell(4);
							if (R33cell1 != null) {
								R33cell1.setCellValue(BRF37.getR50_fcy() == null ? 0 : BRF37.getR50_fcy().intValue());
							}

							Cell R33cell3 = R33row.getCell(6);
							if (R33cell3 != null) {
								R33cell3.setCellValue(
										BRF37.getR50_commercial() == null ? 0 : BRF37.getR50_commercial().intValue());
							}

							Cell R33cell4 = R33row.getCell(7);
							if (R33cell4 != null) {
								R33cell4.setCellValue(BRF37.getR50_gre() == null ? 0 : BRF37.getR50_gre().intValue());
							}

							Cell R33cell5 = R33row.getCell(8);
							if (R33cell5 != null) {
								R33cell5.setCellValue(BRF37.getR50_fdbi() == null ? 0 : BRF37.getR50_fdbi().intValue());
							}

							Cell R33cell6 = R33row.getCell(9);
							if (R33cell6 != null) {
								R33cell6.setCellValue(BRF37.getR50_sme() == null ? 0 : BRF37.getR50_sme().intValue());
							}

							Cell R33cell7 = R33row.getCell(10);
							if (R33cell7 != null) {
								R33cell7.setCellValue(
										BRF37.getR50_individual() == null ? 0 : BRF37.getR50_individual().intValue());
							}

							/////////////////////////////// R51//////////////////

							Row R34row = sheet.getRow(50);
							Cell R34cell = R34row.getCell(3);
							if (R34cell != null) {
								R34cell.setCellValue(BRF37.getR51_aed() == null ? 0 : BRF37.getR51_aed().intValue());
							}

							Cell R34cell1 = R34row.getCell(4);
							if (R34cell1 != null) {
								R34cell1.setCellValue(BRF37.getR51_fcy() == null ? 0 : BRF37.getR51_fcy().intValue());
							}

							Cell R34cell3 = R34row.getCell(6);
							if (R34cell3 != null) {
								R34cell3.setCellValue(
										BRF37.getR51_commercial() == null ? 0 : BRF37.getR51_commercial().intValue());
							}

							Cell R34cell4 = R34row.getCell(7);
							if (R34cell4 != null) {
								R34cell4.setCellValue(BRF37.getR51_gre() == null ? 0 : BRF37.getR51_gre().intValue());
							}

							Cell R34cell5 = R34row.getCell(8);
							if (R34cell5 != null) {
								R34cell5.setCellValue(BRF37.getR51_fdbi() == null ? 0 : BRF37.getR51_fdbi().intValue());
							}

							Cell R34cell6 = R34row.getCell(9);
							if (R34cell6 != null) {
								R34cell6.setCellValue(BRF37.getR51_sme() == null ? 0 : BRF37.getR51_sme().intValue());
							}

							Cell R34cell7 = R34row.getCell(10);
							if (R34cell7 != null) {
								R34cell7.setCellValue(
										BRF37.getR51_individual() == null ? 0 : BRF37.getR51_individual().intValue());
							}

							/////////////////////////////// R53//////////////////

							Row R35row = sheet.getRow(52);
							Cell R35cell = R35row.getCell(3);
							if (R35cell != null) {
								R35cell.setCellValue(BRF37.getR53_aed() == null ? 0 : BRF37.getR53_aed().intValue());
							}

							Cell R35cell1 = R35row.getCell(4);
							if (R35cell1 != null) {
								R35cell1.setCellValue(BRF37.getR53_fcy() == null ? 0 : BRF37.getR53_fcy().intValue());
							}

							Cell R35cell3 = R35row.getCell(6);
							if (R35cell3 != null) {
								R35cell3.setCellValue(
										BRF37.getR53_commercial() == null ? 0 : BRF37.getR53_commercial().intValue());
							}

							Cell R35cell4 = R35row.getCell(7);
							if (R35cell4 != null) {
								R35cell4.setCellValue(BRF37.getR53_gre() == null ? 0 : BRF37.getR53_gre().intValue());
							}

							Cell R35cell5 = R35row.getCell(8);
							if (R35cell5 != null) {
								R35cell5.setCellValue(BRF37.getR53_fdbi() == null ? 0 : BRF37.getR53_fdbi().intValue());
							}

							Cell R35cell6 = R35row.getCell(9);
							if (R35cell6 != null) {
								R35cell6.setCellValue(BRF37.getR53_sme() == null ? 0 : BRF37.getR53_sme().intValue());
							}

							Cell R35cell7 = R35row.getCell(10);
							if (R35cell7 != null) {
								R35cell7.setCellValue(
										BRF37.getR53_individual() == null ? 0 : BRF37.getR53_individual().intValue());
							}

							/////////////////////////////// R54//////////////////

							Row R36row = sheet.getRow(53);
							Cell R36cell = R36row.getCell(3);
							if (R36cell != null) {
								R36cell.setCellValue(BRF37.getR54_aed() == null ? 0 : BRF37.getR54_aed().intValue());
							}

							Cell R36cell1 = R36row.getCell(4);
							if (R36cell1 != null) {
								R36cell1.setCellValue(BRF37.getR54_fcy() == null ? 0 : BRF37.getR54_fcy().intValue());
							}

							Cell R36cell3 = R36row.getCell(6);
							if (R36cell3 != null) {
								R36cell3.setCellValue(
										BRF37.getR54_commercial() == null ? 0 : BRF37.getR54_commercial().intValue());
							}

							Cell R36cell4 = R36row.getCell(7);
							if (R36cell4 != null) {
								R36cell4.setCellValue(BRF37.getR54_gre() == null ? 0 : BRF37.getR54_gre().intValue());
							}

							Cell R36cell5 = R36row.getCell(8);
							if (R36cell5 != null) {
								R36cell5.setCellValue(BRF37.getR54_fdbi() == null ? 0 : BRF37.getR54_fdbi().intValue());
							}

							Cell R36cell6 = R36row.getCell(9);
							if (R36cell6 != null) {
								R36cell6.setCellValue(BRF37.getR54_sme() == null ? 0 : BRF37.getR54_sme().intValue());
							}

							Cell R36cell7 = R36row.getCell(10);
							if (R36cell7 != null) {
								R36cell7.setCellValue(
										BRF37.getR54_individual() == null ? 0 : BRF37.getR54_individual().intValue());
							}

							/////////////////////////////// R55//////////////////

							Row R37row = sheet.getRow(54);
							Cell R37cell = R37row.getCell(3);
							if (R37cell != null) {
								R37cell.setCellValue(BRF37.getR55_aed() == null ? 0 : BRF37.getR55_aed().intValue());
							}

							Cell R37cell1 = R37row.getCell(4);
							if (R37cell1 != null) {
								R37cell1.setCellValue(BRF37.getR55_fcy() == null ? 0 : BRF37.getR55_fcy().intValue());
							}

							Cell R37cell3 = R37row.getCell(6);
							if (R37cell3 != null) {
								R37cell3.setCellValue(
										BRF37.getR55_commercial() == null ? 0 : BRF37.getR55_commercial().intValue());
							}

							Cell R37cell4 = R37row.getCell(7);
							if (R37cell4 != null) {
								R37cell4.setCellValue(BRF37.getR55_gre() == null ? 0 : BRF37.getR55_gre().intValue());
							}

							Cell R37cell5 = R37row.getCell(8);
							if (R37cell5 != null) {
								R37cell5.setCellValue(BRF37.getR55_fdbi() == null ? 0 : BRF37.getR55_fdbi().intValue());
							}

							Cell R37cell6 = R37row.getCell(9);
							if (R37cell6 != null) {
								R37cell6.setCellValue(BRF37.getR55_sme() == null ? 0 : BRF37.getR55_sme().intValue());
							}

							Cell R37cell7 = R37row.getCell(10);
							if (R37cell7 != null) {
								R37cell7.setCellValue(
										BRF37.getR55_individual() == null ? 0 : BRF37.getR55_individual().intValue());
							}

							/////////////////////////////// R57//////////////////

							Row R38row = sheet.getRow(57);
							Cell R38cell = R38row.getCell(3);
							if (R38cell != null) {
								R38cell.setCellValue(BRF37.getR57_minimum_rate() == null ? 0
										: BRF37.getR57_minimum_rate().intValue());
							}

							Cell R38cell1 = R38row.getCell(4);
							if (R38cell1 != null) {
								R38cell1.setCellValue(BRF37.getR57_maximum_rate() == null ? 0
										: BRF37.getR57_maximum_rate().intValue());
							}

							Cell R38cell2 = R38row.getCell(5);
							if (R38cell2 != null) {
								R38cell2.setCellValue(BRF37.getR57_average_rate() == null ? 0
										: BRF37.getR57_average_rate().intValue());
							}

							Cell R38cell3 = R38row.getCell(6);
							if (R38cell3 != null) {
								R38cell3.setCellValue(BRF37.getR57_minimum_rate_inidiv() == null ? 0
										: BRF37.getR57_minimum_rate_inidiv().intValue());
							}

							Cell R38cell4 = R38row.getCell(7);
							if (R38cell4 != null) {
								R38cell4.setCellValue(BRF37.getR57_maximum_rate_inidiv() == null ? 0
										: BRF37.getR57_maximum_rate_inidiv().intValue());
							}

							Cell R38cell5 = R38row.getCell(8);
							if (R38cell5 != null) {
								R38cell5.setCellValue(BRF37.getR57_average_rate_inidiv() == null ? 0
										: BRF37.getR57_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R58//////////////////

							Row R39row = sheet.getRow(58);
							Cell R39cell = R39row.getCell(3);
							if (R39cell != null) {
								R39cell.setCellValue(BRF37.getR58_minimum_rate() == null ? 0
										: BRF37.getR58_minimum_rate().intValue());
							}

							Cell R39cell1 = R39row.getCell(4);
							if (R39cell1 != null) {
								R39cell1.setCellValue(BRF37.getR58_maximum_rate() == null ? 0
										: BRF37.getR58_maximum_rate().intValue());
							}

							Cell R39cell2 = R39row.getCell(5);
							if (R39cell2 != null) {
								R39cell2.setCellValue(BRF37.getR58_average_rate() == null ? 0
										: BRF37.getR58_average_rate().intValue());
							}

							Cell R39cell3 = R39row.getCell(6);
							if (R39cell3 != null) {
								R39cell3.setCellValue(BRF37.getR58_minimum_rate_inidiv() == null ? 0
										: BRF37.getR58_minimum_rate_inidiv().intValue());
							}

							Cell R39cell4 = R39row.getCell(7);
							if (R39cell4 != null) {
								R39cell4.setCellValue(BRF37.getR58_maximum_rate_inidiv() == null ? 0
										: BRF37.getR58_maximum_rate_inidiv().intValue());
							}

							Cell R39cell5 = R39row.getCell(8);
							if (R39cell5 != null) {
								R39cell5.setCellValue(BRF37.getR58_average_rate_inidiv() == null ? 0
										: BRF37.getR58_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R59//////////////////

							Row R40row = sheet.getRow(59);
							Cell R40cell = R40row.getCell(3);
							if (R40cell != null) {
								R40cell.setCellValue(BRF37.getR59_minimum_rate() == null ? 0
										: BRF37.getR59_minimum_rate().intValue());
							}

							Cell R40cell1 = R40row.getCell(4);
							if (R40cell1 != null) {
								R40cell1.setCellValue(BRF37.getR59_maximum_rate() == null ? 0
										: BRF37.getR59_maximum_rate().intValue());
							}

							Cell R40cell2 = R40row.getCell(5);
							if (R40cell2 != null) {
								R40cell2.setCellValue(BRF37.getR59_average_rate() == null ? 0
										: BRF37.getR59_average_rate().intValue());
							}

							Cell R40cell3 = R40row.getCell(6);
							if (R40cell3 != null) {
								R40cell3.setCellValue(BRF37.getR59_minimum_rate_inidiv() == null ? 0
										: BRF37.getR59_minimum_rate_inidiv().intValue());
							}

							Cell R40cell4 = R40row.getCell(7);
							if (R40cell4 != null) {
								R40cell4.setCellValue(BRF37.getR59_maximum_rate_inidiv() == null ? 0
										: BRF37.getR59_maximum_rate_inidiv().intValue());
							}

							Cell R40cell5 = R40row.getCell(8);
							if (R40cell5 != null) {
								R40cell5.setCellValue(BRF37.getR59_average_rate_inidiv() == null ? 0
										: BRF37.getR59_average_rate_inidiv().intValue());
							}
							/////////////////////////////// R60//////////////////

							Row R41row = sheet.getRow(60);
							Cell R41cell = R41row.getCell(3);
							if (R41cell != null) {
								R41cell.setCellValue(BRF37.getR60_minimum_rate() == null ? 0
										: BRF37.getR60_minimum_rate().intValue());
							}

							Cell R41cell1 = R41row.getCell(4);
							if (R41cell1 != null) {
								R41cell1.setCellValue(BRF37.getR60_maximum_rate() == null ? 0
										: BRF37.getR60_maximum_rate().intValue());
							}

							Cell R41cell2 = R41row.getCell(5);
							if (R41cell2 != null) {
								R41cell2.setCellValue(BRF37.getR60_average_rate() == null ? 0
										: BRF37.getR60_average_rate().intValue());
							}

							Cell R41cell3 = R41row.getCell(6);
							if (R41cell3 != null) {
								R41cell3.setCellValue(BRF37.getR60_minimum_rate_inidiv() == null ? 0
										: BRF37.getR60_minimum_rate_inidiv().intValue());
							}

							Cell R41cell4 = R41row.getCell(7);
							if (R41cell4 != null) {
								R41cell4.setCellValue(BRF37.getR60_maximum_rate_inidiv() == null ? 0
										: BRF37.getR60_maximum_rate_inidiv().intValue());
							}

							Cell R41cell5 = R41row.getCell(8);
							if (R41cell5 != null) {
								R41cell5.setCellValue(BRF37.getR60_average_rate_inidiv() == null ? 0
										: BRF37.getR60_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R61//////////////////

							Row R42row = sheet.getRow(61);
							Cell R42cell = R42row.getCell(3);
							if (R42cell != null) {
								R42cell.setCellValue(BRF37.getR61_minimum_rate() == null ? 0
										: BRF37.getR61_minimum_rate().intValue());
							}

							Cell R42cell1 = R42row.getCell(4);
							if (R42cell1 != null) {
								R42cell1.setCellValue(BRF37.getR61_maximum_rate() == null ? 0
										: BRF37.getR61_maximum_rate().intValue());
							}

							Cell R42cell2 = R42row.getCell(5);
							if (R42cell2 != null) {
								R42cell2.setCellValue(BRF37.getR61_average_rate() == null ? 0
										: BRF37.getR61_average_rate().intValue());
							}

							Cell R42cell3 = R42row.getCell(6);
							if (R42cell3 != null) {
								R42cell3.setCellValue(BRF37.getR61_minimum_rate_inidiv() == null ? 0
										: BRF37.getR61_minimum_rate_inidiv().intValue());
							}

							Cell R42cell4 = R42row.getCell(7);
							if (R42cell4 != null) {
								R42cell4.setCellValue(BRF37.getR61_maximum_rate_inidiv() == null ? 0
										: BRF37.getR61_maximum_rate_inidiv().intValue());
							}

							Cell R42cell5 = R42row.getCell(8);
							if (R42cell5 != null) {
								R42cell5.setCellValue(BRF37.getR61_average_rate_inidiv() == null ? 0
										: BRF37.getR61_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R62//////////////////

							Row R43row = sheet.getRow(62);
							Cell R43cell = R43row.getCell(3);
							if (R43cell != null) {
								R43cell.setCellValue(BRF37.getR62_minimum_rate() == null ? 0
										: BRF37.getR62_minimum_rate().intValue());
							}

							Cell R43cell1 = R43row.getCell(4);
							if (R43cell1 != null) {
								R43cell1.setCellValue(BRF37.getR62_maximum_rate() == null ? 0
										: BRF37.getR62_maximum_rate().intValue());
							}

							Cell R43cell2 = R43row.getCell(5);
							if (R43cell2 != null) {
								R43cell2.setCellValue(BRF37.getR62_average_rate() == null ? 0
										: BRF37.getR62_average_rate().intValue());
							}

							Cell R43cell3 = R43row.getCell(6);
							if (R43cell3 != null) {
								R43cell3.setCellValue(BRF37.getR62_minimum_rate_inidiv() == null ? 0
										: BRF37.getR62_minimum_rate_inidiv().intValue());
							}

							Cell R43cell4 = R43row.getCell(7);
							if (R43cell4 != null) {
								R43cell4.setCellValue(BRF37.getR62_maximum_rate_inidiv() == null ? 0
										: BRF37.getR62_maximum_rate_inidiv().intValue());
							}

							Cell R43cell5 = R43row.getCell(8);
							if (R43cell5 != null) {
								R43cell5.setCellValue(BRF37.getR62_average_rate_inidiv() == null ? 0
										: BRF37.getR62_average_rate_inidiv().intValue());
							}
							/////////////////////////////// R63//////////////////

							Row R44row = sheet.getRow(63);
							Cell R44cell = R44row.getCell(3);
							if (R44cell != null) {
								R44cell.setCellValue(BRF37.getR63_minimum_rate() == null ? 0
										: BRF37.getR63_minimum_rate().intValue());
							}

							Cell R44cell1 = R44row.getCell(4);
							if (R44cell1 != null) {
								R44cell1.setCellValue(BRF37.getR63_maximum_rate() == null ? 0
										: BRF37.getR63_maximum_rate().intValue());
							}

							Cell R44cell2 = R44row.getCell(5);
							if (R44cell2 != null) {
								R44cell2.setCellValue(BRF37.getR63_average_rate() == null ? 0
										: BRF37.getR63_average_rate().intValue());
							}

							Cell R44cell3 = R44row.getCell(6);
							if (R44cell3 != null) {
								R44cell3.setCellValue(BRF37.getR63_minimum_rate_inidiv() == null ? 0
										: BRF37.getR63_minimum_rate_inidiv().intValue());
							}

							Cell R44cell4 = R44row.getCell(7);
							if (R44cell4 != null) {
								R44cell4.setCellValue(BRF37.getR63_maximum_rate_inidiv() == null ? 0
										: BRF37.getR63_maximum_rate_inidiv().intValue());
							}

							Cell R44cell5 = R44row.getCell(8);
							if (R44cell5 != null) {
								R44cell5.setCellValue(BRF37.getR63_average_rate_inidiv() == null ? 0
										: BRF37.getR63_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R64//////////////////

							Row R45row = sheet.getRow(64);
							Cell R45cell = R45row.getCell(3);
							if (R45cell != null) {
								R45cell.setCellValue(BRF37.getR64_minimum_rate() == null ? 0
										: BRF37.getR64_minimum_rate().intValue());
							}

							Cell R45cell1 = R45row.getCell(4);
							if (R45cell1 != null) {
								R45cell1.setCellValue(BRF37.getR64_maximum_rate() == null ? 0
										: BRF37.getR64_maximum_rate().intValue());
							}

							Cell R45cell2 = R45row.getCell(5);
							if (R45cell2 != null) {
								R45cell2.setCellValue(BRF37.getR64_average_rate() == null ? 0
										: BRF37.getR64_average_rate().intValue());
							}

							Cell R45cell3 = R45row.getCell(6);
							if (R45cell3 != null) {
								R45cell3.setCellValue(BRF37.getR64_minimum_rate_inidiv() == null ? 0
										: BRF37.getR64_minimum_rate_inidiv().intValue());
							}

							Cell R45cell4 = R45row.getCell(7);
							if (R45cell4 != null) {
								R45cell4.setCellValue(BRF37.getR64_maximum_rate_inidiv() == null ? 0
										: BRF37.getR64_maximum_rate_inidiv().intValue());
							}

							Cell R45cell5 = R45row.getCell(8);
							if (R45cell5 != null) {
								R45cell5.setCellValue(BRF37.getR64_average_rate_inidiv() == null ? 0
										: BRF37.getR64_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R65//////////////////

							Row R46row = sheet.getRow(65);
							Cell R46cell = R46row.getCell(3);
							if (R46cell != null) {
								R46cell.setCellValue(BRF37.getR65_minimum_rate() == null ? 0
										: BRF37.getR65_minimum_rate().intValue());
							}

							Cell R46cell1 = R46row.getCell(4);
							if (R46cell1 != null) {
								R46cell1.setCellValue(BRF37.getR65_maximum_rate() == null ? 0
										: BRF37.getR65_maximum_rate().intValue());
							}

							Cell R46cell2 = R46row.getCell(5);
							if (R46cell2 != null) {
								R46cell2.setCellValue(BRF37.getR65_average_rate() == null ? 0
										: BRF37.getR65_average_rate().intValue());
							}

							Cell R46cell3 = R46row.getCell(6);
							if (R46cell3 != null) {
								R46cell3.setCellValue(BRF37.getR65_minimum_rate_inidiv() == null ? 0
										: BRF37.getR65_minimum_rate_inidiv().intValue());
							}

							Cell R46cell4 = R46row.getCell(7);
							if (R46cell4 != null) {
								R46cell4.setCellValue(BRF37.getR65_maximum_rate_inidiv() == null ? 0
										: BRF37.getR65_maximum_rate_inidiv().intValue());
							}

							Cell R46cell5 = R46row.getCell(8);
							if (R46cell5 != null) {
								R46cell5.setCellValue(BRF37.getR65_average_rate_inidiv() == null ? 0
										: BRF37.getR65_average_rate_inidiv().intValue());
							}
							/////////////////////////////// R66//////////////////

							Row R47row = sheet.getRow(66);
							Cell R47cell = R47row.getCell(3);
							if (R47cell != null) {
								R47cell.setCellValue(BRF37.getR66_minimum_rate() == null ? 0
										: BRF37.getR66_minimum_rate().intValue());
							}

							Cell R47cell1 = R47row.getCell(4);
							if (R47cell1 != null) {
								R47cell1.setCellValue(BRF37.getR66_maximum_rate() == null ? 0
										: BRF37.getR66_maximum_rate().intValue());
							}

							Cell R47cell2 = R47row.getCell(5);
							if (R47cell2 != null) {
								R47cell2.setCellValue(BRF37.getR66_average_rate() == null ? 0
										: BRF37.getR66_average_rate().intValue());
							}

							Cell R47cell3 = R47row.getCell(6);
							if (R47cell3 != null) {
								R47cell3.setCellValue(BRF37.getR66_minimum_rate_inidiv() == null ? 0
										: BRF37.getR66_minimum_rate_inidiv().intValue());
							}

							Cell R47cell4 = R47row.getCell(7);
							if (R47cell4 != null) {
								R47cell4.setCellValue(BRF37.getR66_maximum_rate_inidiv() == null ? 0
										: BRF37.getR66_maximum_rate_inidiv().intValue());
							}

							Cell R47cell5 = R47row.getCell(8);
							if (R47cell5 != null) {
								R47cell5.setCellValue(BRF37.getR66_average_rate_inidiv() == null ? 0
										: BRF37.getR66_average_rate_inidiv().intValue());
							}
							/////////////////////////////// R67//////////////////

							Row R48row = sheet.getRow(67);
							Cell R48cell = R48row.getCell(3);
							if (R48cell != null) {
								R48cell.setCellValue(BRF37.getR67_minimum_rate() == null ? 0
										: BRF37.getR67_minimum_rate().intValue());
							}

							Cell R48cell1 = R48row.getCell(4);
							if (R48cell1 != null) {
								R48cell1.setCellValue(BRF37.getR67_maximum_rate() == null ? 0
										: BRF37.getR67_maximum_rate().intValue());
							}

							Cell R48cell2 = R48row.getCell(5);
							if (R48cell2 != null) {
								R48cell2.setCellValue(BRF37.getR67_average_rate() == null ? 0
										: BRF37.getR67_average_rate().intValue());
							}

							Cell R48cell3 = R48row.getCell(6);
							if (R48cell3 != null) {
								R48cell3.setCellValue(BRF37.getR67_minimum_rate_inidiv() == null ? 0
										: BRF37.getR67_minimum_rate_inidiv().intValue());
							}

							Cell R48cell4 = R48row.getCell(7);
							if (R48cell4 != null) {
								R48cell4.setCellValue(BRF37.getR67_maximum_rate_inidiv() == null ? 0
										: BRF37.getR67_maximum_rate_inidiv().intValue());
							}

							Cell R48cell5 = R48row.getCell(8);
							if (R48cell5 != null) {
								R48cell5.setCellValue(BRF37.getR67_average_rate_inidiv() == null ? 0
										: BRF37.getR67_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R68//////////////////

							Row R49row = sheet.getRow(70);
							Cell R49cell = R49row.getCell(3);
							if (R49cell != null) {
								R49cell.setCellValue(BRF37.getR68_minimum_rate() == null ? 0
										: BRF37.getR68_minimum_rate().intValue());
							}

							Cell R49cell1 = R49row.getCell(4);
							if (R49cell1 != null) {
								R49cell1.setCellValue(BRF37.getR68_maximum_rate() == null ? 0
										: BRF37.getR68_maximum_rate().intValue());
							}

							Cell R49cell2 = R49row.getCell(5);
							if (R49cell2 != null) {
								R49cell2.setCellValue(BRF37.getR68_average_rate() == null ? 0
										: BRF37.getR68_average_rate().intValue());
							}

							Cell R49cell3 = R49row.getCell(6);
							if (R49cell3 != null) {
								R49cell3.setCellValue(BRF37.getR68_minimum_rate_inidiv() == null ? 0
										: BRF37.getR68_minimum_rate_inidiv().intValue());
							}

							Cell R49cell4 = R49row.getCell(7);
							if (R49cell4 != null) {
								R49cell4.setCellValue(BRF37.getR68_maximum_rate_inidiv() == null ? 0
										: BRF37.getR68_maximum_rate_inidiv().intValue());
							}

							Cell R49cell5 = R49row.getCell(8);
							if (R49cell5 != null) {
								R49cell5.setCellValue(BRF37.getR68_average_rate_inidiv() == null ? 0
										: BRF37.getR68_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R69//////////////////

							Row R50row = sheet.getRow(71);
							Cell R50cell = R50row.getCell(3);
							if (R50cell != null) {
								R50cell.setCellValue(BRF37.getR69_minimum_rate() == null ? 0
										: BRF37.getR69_minimum_rate().intValue());
							}

							Cell R50cell1 = R50row.getCell(4);
							if (R50cell1 != null) {
								R50cell1.setCellValue(BRF37.getR69_maximum_rate() == null ? 0
										: BRF37.getR69_maximum_rate().intValue());
							}

							Cell R50cell2 = R50row.getCell(5);
							if (R50cell2 != null) {
								R50cell2.setCellValue(BRF37.getR69_average_rate() == null ? 0
										: BRF37.getR69_average_rate().intValue());
							}

							Cell R50cell3 = R50row.getCell(6);
							if (R50cell3 != null) {
								R50cell3.setCellValue(BRF37.getR69_minimum_rate_inidiv() == null ? 0
										: BRF37.getR69_minimum_rate_inidiv().intValue());
							}

							Cell R50cell4 = R50row.getCell(7);
							if (R50cell4 != null) {
								R50cell4.setCellValue(BRF37.getR69_maximum_rate_inidiv() == null ? 0
										: BRF37.getR69_maximum_rate_inidiv().intValue());
							}

							Cell R50cell5 = R50row.getCell(8);
							if (R50cell5 != null) {
								R50cell5.setCellValue(BRF37.getR69_average_rate_inidiv() == null ? 0
										: BRF37.getR69_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R70//////////////////

							Row R51row = sheet.getRow(72);
							Cell R51cell = R51row.getCell(3);
							if (R51cell != null) {
								R51cell.setCellValue(BRF37.getR70_minimum_rate() == null ? 0
										: BRF37.getR70_minimum_rate().intValue());
							}

							Cell R51cell1 = R51row.getCell(4);
							if (R51cell1 != null) {
								R51cell1.setCellValue(BRF37.getR70_maximum_rate() == null ? 0
										: BRF37.getR70_maximum_rate().intValue());
							}

							Cell R51cell2 = R51row.getCell(5);
							if (R51cell2 != null) {
								R51cell2.setCellValue(BRF37.getR70_average_rate() == null ? 0
										: BRF37.getR70_average_rate().intValue());
							}

							Cell R51cell3 = R51row.getCell(6);
							if (R51cell3 != null) {
								R51cell3.setCellValue(BRF37.getR70_minimum_rate_inidiv() == null ? 0
										: BRF37.getR70_minimum_rate_inidiv().intValue());
							}

							Cell R51cell4 = R51row.getCell(7);
							if (R51cell4 != null) {
								R51cell4.setCellValue(BRF37.getR70_maximum_rate_inidiv() == null ? 0
										: BRF37.getR70_maximum_rate_inidiv().intValue());
							}

							Cell R51cell5 = R51row.getCell(8);
							if (R51cell5 != null) {
								R51cell5.setCellValue(BRF37.getR70_average_rate_inidiv() == null ? 0
										: BRF37.getR70_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R71//////////////////

							Row R52row = sheet.getRow(73);
							Cell R52cell = R52row.getCell(3);
							if (R52cell != null) {
								R52cell.setCellValue(BRF37.getR71_minimum_rate() == null ? 0
										: BRF37.getR71_minimum_rate().intValue());
							}

							Cell R52cell1 = R52row.getCell(4);
							if (R52cell1 != null) {
								R52cell1.setCellValue(BRF37.getR71_maximum_rate() == null ? 0
										: BRF37.getR71_maximum_rate().intValue());
							}

							Cell R52cell2 = R52row.getCell(5);
							if (R52cell2 != null) {
								R52cell2.setCellValue(BRF37.getR71_average_rate() == null ? 0
										: BRF37.getR71_average_rate().intValue());
							}

							Cell R52cell3 = R52row.getCell(6);
							if (R52cell3 != null) {
								R52cell3.setCellValue(BRF37.getR71_minimum_rate_inidiv() == null ? 0
										: BRF37.getR71_minimum_rate_inidiv().intValue());
							}

							Cell R52cell4 = R52row.getCell(7);
							if (R52cell4 != null) {
								R52cell4.setCellValue(BRF37.getR71_maximum_rate_inidiv() == null ? 0
										: BRF37.getR71_maximum_rate_inidiv().intValue());
							}

							Cell R52cell5 = R52row.getCell(8);
							if (R52cell5 != null) {
								R52cell5.setCellValue(BRF37.getR71_average_rate_inidiv() == null ? 0
										: BRF37.getR71_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R72//////////////////

							Row R53row = sheet.getRow(74);
							Cell R53cell = R53row.getCell(3);
							if (R53cell != null) {
								R53cell.setCellValue(BRF37.getR72_minimum_rate() == null ? 0
										: BRF37.getR72_minimum_rate().intValue());
							}

							Cell R53cell1 = R53row.getCell(4);
							if (R53cell1 != null) {
								R53cell1.setCellValue(BRF37.getR72_maximum_rate() == null ? 0
										: BRF37.getR72_maximum_rate().intValue());
							}

							Cell R53cell2 = R53row.getCell(5);
							if (R53cell2 != null) {
								R53cell2.setCellValue(BRF37.getR72_average_rate() == null ? 0
										: BRF37.getR72_average_rate().intValue());
							}

							Cell R53cell3 = R53row.getCell(6);
							if (R53cell3 != null) {
								R53cell3.setCellValue(BRF37.getR72_minimum_rate_inidiv() == null ? 0
										: BRF37.getR72_minimum_rate_inidiv().intValue());
							}

							Cell R53cell4 = R53row.getCell(7);
							if (R53cell4 != null) {
								R53cell4.setCellValue(BRF37.getR72_maximum_rate_inidiv() == null ? 0
										: BRF37.getR72_maximum_rate_inidiv().intValue());
							}

							Cell R53cell5 = R53row.getCell(8);
							if (R53cell5 != null) {
								R53cell5.setCellValue(BRF37.getR72_average_rate_inidiv() == null ? 0
										: BRF37.getR72_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R73//////////////////

							Row R54row = sheet.getRow(75);
							Cell R54cell = R54row.getCell(3);
							if (R54cell != null) {
								R54cell.setCellValue(BRF37.getR73_minimum_rate() == null ? 0
										: BRF37.getR73_minimum_rate().intValue());
							}

							Cell R54cell1 = R54row.getCell(4);
							if (R54cell1 != null) {
								R54cell1.setCellValue(BRF37.getR73_maximum_rate() == null ? 0
										: BRF37.getR73_maximum_rate().intValue());
							}

							Cell R54cell2 = R54row.getCell(5);
							if (R54cell2 != null) {
								R54cell2.setCellValue(BRF37.getR73_average_rate() == null ? 0
										: BRF37.getR73_average_rate().intValue());
							}

							Cell R54cell3 = R54row.getCell(6);
							if (R54cell3 != null) {
								R54cell3.setCellValue(BRF37.getR73_minimum_rate_inidiv() == null ? 0
										: BRF37.getR73_minimum_rate_inidiv().intValue());
							}

							Cell R54cell4 = R54row.getCell(7);
							if (R54cell4 != null) {
								R54cell4.setCellValue(BRF37.getR73_maximum_rate_inidiv() == null ? 0
										: BRF37.getR73_maximum_rate_inidiv().intValue());
							}

							Cell R54cell5 = R54row.getCell(8);
							if (R54cell5 != null) {
								R54cell5.setCellValue(BRF37.getR73_average_rate_inidiv() == null ? 0
										: BRF37.getR73_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R74//////////////////

							Row R55row = sheet.getRow(76);
							Cell R55cell = R55row.getCell(3);
							if (R55cell != null) {
								R55cell.setCellValue(BRF37.getR74_minimum_rate() == null ? 0
										: BRF37.getR74_minimum_rate().intValue());
							}

							Cell R55cell1 = R55row.getCell(4);
							if (R55cell1 != null) {
								R55cell1.setCellValue(BRF37.getR74_maximum_rate() == null ? 0
										: BRF37.getR74_maximum_rate().intValue());
							}

							Cell R55cell2 = R55row.getCell(5);
							if (R55cell2 != null) {
								R55cell2.setCellValue(BRF37.getR74_average_rate() == null ? 0
										: BRF37.getR74_average_rate().intValue());
							}

							Cell R55cell3 = R55row.getCell(6);
							if (R55cell3 != null) {
								R55cell3.setCellValue(BRF37.getR74_minimum_rate_inidiv() == null ? 0
										: BRF37.getR74_minimum_rate_inidiv().intValue());
							}

							Cell R55cell4 = R55row.getCell(7);
							if (R55cell4 != null) {
								R55cell4.setCellValue(BRF37.getR74_maximum_rate_inidiv() == null ? 0
										: BRF37.getR74_maximum_rate_inidiv().intValue());
							}

							Cell R55cell5 = R55row.getCell(8);
							if (R55cell5 != null) {
								R55cell5.setCellValue(BRF37.getR74_average_rate_inidiv() == null ? 0
										: BRF37.getR74_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R75//////////////////

							Row R56row = sheet.getRow(77);
							Cell R56cell = R56row.getCell(3);
							if (R56cell != null) {
								R56cell.setCellValue(BRF37.getR75_minimum_rate() == null ? 0
										: BRF37.getR75_minimum_rate().intValue());
							}

							Cell R56cell1 = R56row.getCell(4);
							if (R56cell1 != null) {
								R56cell1.setCellValue(BRF37.getR75_maximum_rate() == null ? 0
										: BRF37.getR75_maximum_rate().intValue());
							}

							Cell R56cell2 = R56row.getCell(5);
							if (R56cell2 != null) {
								R56cell2.setCellValue(BRF37.getR75_average_rate() == null ? 0
										: BRF37.getR75_average_rate().intValue());
							}

							Cell R56cell3 = R56row.getCell(6);
							if (R56cell3 != null) {
								R56cell3.setCellValue(BRF37.getR75_minimum_rate_inidiv() == null ? 0
										: BRF37.getR75_minimum_rate_inidiv().intValue());
							}

							Cell R56cell4 = R56row.getCell(7);
							if (R56cell4 != null) {
								R56cell4.setCellValue(BRF37.getR75_maximum_rate_inidiv() == null ? 0
										: BRF37.getR75_maximum_rate_inidiv().intValue());
							}

							Cell R56cell5 = R56row.getCell(8);
							if (R56cell5 != null) {
								R56cell5.setCellValue(BRF37.getR75_average_rate_inidiv() == null ? 0
										: BRF37.getR75_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R76//////////////////

							Row R57row = sheet.getRow(78);
							Cell R57cell = R57row.getCell(3);
							if (R57cell != null) {
								R57cell.setCellValue(BRF37.getR76_minimum_rate() == null ? 0
										: BRF37.getR76_minimum_rate().intValue());
							}

							Cell R57cell1 = R57row.getCell(4);
							if (R57cell1 != null) {
								R57cell1.setCellValue(BRF37.getR76_maximum_rate() == null ? 0
										: BRF37.getR76_maximum_rate().intValue());
							}

							Cell R57cell2 = R57row.getCell(5);
							if (R57cell2 != null) {
								R57cell2.setCellValue(BRF37.getR76_average_rate() == null ? 0
										: BRF37.getR76_average_rate().intValue());
							}

							Cell R57cell3 = R57row.getCell(6);
							if (R57cell3 != null) {
								R57cell3.setCellValue(BRF37.getR76_minimum_rate_inidiv() == null ? 0
										: BRF37.getR76_minimum_rate_inidiv().intValue());
							}

							Cell R57cell4 = R57row.getCell(7);
							if (R57cell4 != null) {
								R57cell4.setCellValue(BRF37.getR76_maximum_rate_inidiv() == null ? 0
										: BRF37.getR76_maximum_rate_inidiv().intValue());
							}

							Cell R57cell5 = R57row.getCell(8);
							if (R57cell5 != null) {
								R57cell5.setCellValue(BRF37.getR76_average_rate_inidiv() == null ? 0
										: BRF37.getR76_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R77//////////////////

							Row R58row = sheet.getRow(79);
							Cell R58cell = R58row.getCell(3);
							if (R58cell != null) {
								R58cell.setCellValue(BRF37.getR77_minimum_rate() == null ? 0
										: BRF37.getR77_minimum_rate().intValue());
							}

							Cell R58cell1 = R58row.getCell(4);
							if (R58cell1 != null) {
								R58cell1.setCellValue(BRF37.getR77_maximum_rate() == null ? 0
										: BRF37.getR77_maximum_rate().intValue());
							}

							Cell R58cell2 = R58row.getCell(5);
							if (R58cell2 != null) {
								R58cell2.setCellValue(BRF37.getR77_average_rate() == null ? 0
										: BRF37.getR77_average_rate().intValue());
							}

							Cell R58cell3 = R58row.getCell(6);
							if (R58cell3 != null) {
								R58cell3.setCellValue(BRF37.getR77_minimum_rate_inidiv() == null ? 0
										: BRF37.getR77_minimum_rate_inidiv().intValue());
							}

							Cell R58cell4 = R58row.getCell(7);
							if (R58cell4 != null) {
								R58cell4.setCellValue(BRF37.getR77_maximum_rate_inidiv() == null ? 0
										: BRF37.getR77_maximum_rate_inidiv().intValue());
							}

							Cell R58cell5 = R58row.getCell(8);
							if (R58cell5 != null) {
								R58cell5.setCellValue(BRF37.getR77_average_rate_inidiv() == null ? 0
										: BRF37.getR77_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R78//////////////////

							Row R59row = sheet.getRow(80);
							Cell R59cell = R59row.getCell(3);
							if (R59cell != null) {
								R59cell.setCellValue(BRF37.getR78_minimum_rate() == null ? 0
										: BRF37.getR78_minimum_rate().intValue());
							}

							Cell R59cell1 = R59row.getCell(4);
							if (R59cell1 != null) {
								R59cell1.setCellValue(BRF37.getR78_maximum_rate() == null ? 0
										: BRF37.getR78_maximum_rate().intValue());
							}

							Cell R59cell2 = R59row.getCell(5);
							if (R59cell2 != null) {
								R59cell2.setCellValue(BRF37.getR78_average_rate() == null ? 0
										: BRF37.getR78_average_rate().intValue());
							}

							Cell R59cell3 = R59row.getCell(6);
							if (R59cell3 != null) {
								R59cell3.setCellValue(BRF37.getR78_minimum_rate_inidiv() == null ? 0
										: BRF37.getR78_minimum_rate_inidiv().intValue());
							}

							Cell R59cell4 = R59row.getCell(7);
							if (R59cell4 != null) {
								R59cell4.setCellValue(BRF37.getR78_maximum_rate_inidiv() == null ? 0
										: BRF37.getR78_maximum_rate_inidiv().intValue());
							}

							Cell R59cell5 = R59row.getCell(8);
							if (R59cell5 != null) {
								R59cell5.setCellValue(BRF37.getR78_average_rate_inidiv() == null ? 0
										: BRF37.getR78_average_rate_inidiv().intValue());
							}

							/////////////////////////////// R79//////////////////

							Row R60row = sheet.getRow(82);
							Cell R60cell = R60row.getCell(3);
							if (R60cell != null) {
								R60cell.setCellValue(BRF37.getR79_minimum_rate() == null ? 0
										: BRF37.getR79_minimum_rate().intValue());
							}

							Cell R60cell1 = R60row.getCell(4);
							if (R60cell1 != null) {
								R60cell1.setCellValue(BRF37.getR79_maximum_rate() == null ? 0
										: BRF37.getR79_maximum_rate().intValue());
							}

							Cell R60cell2 = R60row.getCell(5);
							if (R60cell2 != null) {
								R60cell2.setCellValue(BRF37.getR79_average_rate() == null ? 0
										: BRF37.getR79_average_rate().intValue());
							}

							/////////////////////////////// R80//////////////////

							Row R61row = sheet.getRow(83);
							Cell R61cell = R61row.getCell(3);
							if (R61cell != null) {
								R61cell.setCellValue(BRF37.getR80_minimum_rate() == null ? 0
										: BRF37.getR80_minimum_rate().intValue());
							}

							Cell R61cell1 = R61row.getCell(4);
							if (R61cell1 != null) {
								R61cell1.setCellValue(BRF37.getR80_maximum_rate() == null ? 0
										: BRF37.getR80_maximum_rate().intValue());
							}

							Cell R61cell2 = R61row.getCell(5);
							if (R61cell2 != null) {
								R61cell2.setCellValue(BRF37.getR80_average_rate() == null ? 0
										: BRF37.getR80_average_rate().intValue());
							}

							/////////////////////////////// R81//////////////////

							Row R62row = sheet.getRow(84);
							Cell R62cell = R62row.getCell(3);
							if (R62cell != null) {
								R62cell.setCellValue(BRF37.getR81_minimum_rate() == null ? 0
										: BRF37.getR81_minimum_rate().intValue());
							}

							Cell R62cell1 = R62row.getCell(4);
							if (R62cell1 != null) {
								R62cell1.setCellValue(BRF37.getR81_maximum_rate() == null ? 0
										: BRF37.getR81_maximum_rate().intValue());
							}

							Cell R62cell2 = R62row.getCell(5);
							if (R62cell2 != null) {
								R62cell2.setCellValue(BRF37.getR81_average_rate() == null ? 0
										: BRF37.getR81_average_rate().intValue());
							}

							/////////////////////////////// R82//////////////////

							Row R63row = sheet.getRow(85);
							Cell R63cell = R63row.getCell(3);
							if (R63cell != null) {
								R63cell.setCellValue(BRF37.getR82_minimum_rate() == null ? 0
										: BRF37.getR82_minimum_rate().intValue());
							}

							Cell R63cell1 = R63row.getCell(4);
							if (R63cell1 != null) {
								R63cell1.setCellValue(BRF37.getR82_maximum_rate() == null ? 0
										: BRF37.getR82_maximum_rate().intValue());
							}

							Cell R63cell2 = R63row.getCell(5);
							if (R63cell2 != null) {
								R63cell2.setCellValue(BRF37.getR82_average_rate() == null ? 0
										: BRF37.getR82_average_rate().intValue());
							}

							/////////////////////////////// R83//////////////////

							Row R64row = sheet.getRow(86);
							Cell R64cell = R64row.getCell(3);
							if (R64cell != null) {
								R64cell.setCellValue(BRF37.getR83_minimum_rate() == null ? 0
										: BRF37.getR83_minimum_rate().intValue());
							}

							Cell R64cell1 = R64row.getCell(4);
							if (R64cell1 != null) {
								R64cell1.setCellValue(BRF37.getR83_maximum_rate() == null ? 0
										: BRF37.getR83_maximum_rate().intValue());
							}

							Cell R64cell2 = R64row.getCell(5);
							if (R64cell2 != null) {
								R64cell2.setCellValue(BRF37.getR83_average_rate() == null ? 0
										: BRF37.getR83_average_rate().intValue());
							}

							/////////////////////////////// R84//////////////////

							Row R65row = sheet.getRow(88);
							Cell R65cell = R65row.getCell(3);
							if (R65cell != null) {
								R65cell.setCellValue(BRF37.getR84_minimum_rate() == null ? 0
										: BRF37.getR84_minimum_rate().intValue());
							}

							Cell R65cell1 = R65row.getCell(4);
							if (R65cell1 != null) {
								R65cell1.setCellValue(BRF37.getR84_maximum_rate() == null ? 0
										: BRF37.getR84_maximum_rate().intValue());
							}

							Cell R65cell2 = R65row.getCell(5);
							if (R65cell2 != null) {
								R65cell2.setCellValue(BRF37.getR84_average_rate() == null ? 0
										: BRF37.getR84_average_rate().intValue());
							}

							/////////////////////////////// R85//////////////////

							Row R66row = sheet.getRow(89);
							Cell R66cell = R66row.getCell(3);
							if (R66cell != null) {
								R66cell.setCellValue(BRF37.getR85_minimum_rate() == null ? 0
										: BRF37.getR85_minimum_rate().intValue());
							}

							Cell R66cell1 = R66row.getCell(4);
							if (R66cell1 != null) {
								R66cell1.setCellValue(BRF37.getR85_maximum_rate() == null ? 0
										: BRF37.getR85_maximum_rate().intValue());
							}

							Cell R66cell2 = R66row.getCell(5);
							if (R66cell2 != null) {
								R66cell2.setCellValue(BRF37.getR85_average_rate() == null ? 0
										: BRF37.getR85_average_rate().intValue());
							}

							/////////////////////////////// R86//////////////////

							Row R67row = sheet.getRow(90);
							Cell R67cell = R67row.getCell(3);
							if (R67cell != null) {
								R67cell.setCellValue(BRF37.getR86_minimum_rate() == null ? 0
										: BRF37.getR86_minimum_rate().intValue());
							}

							Cell R67cell1 = R67row.getCell(4);
							if (R67cell1 != null) {
								R67cell1.setCellValue(BRF37.getR86_maximum_rate() == null ? 0
										: BRF37.getR86_maximum_rate().intValue());
							}

							Cell R67cell2 = R67row.getCell(5);
							if (R67cell2 != null) {
								R67cell2.setCellValue(BRF37.getR86_average_rate() == null ? 0
										: BRF37.getR86_average_rate().intValue());
							}

							/////////////////////////////// R87//////////////////

							Row R68row = sheet.getRow(91);
							Cell R68cell = R68row.getCell(3);
							if (R68cell != null) {
								R68cell.setCellValue(BRF37.getR87_minimum_rate() == null ? 0
										: BRF37.getR87_minimum_rate().intValue());
							}

							Cell R68cell1 = R68row.getCell(4);
							if (R68cell1 != null) {
								R68cell1.setCellValue(BRF37.getR87_maximum_rate() == null ? 0
										: BRF37.getR87_maximum_rate().intValue());
							}

							Cell R68cell2 = R68row.getCell(5);
							if (R68cell2 != null) {
								R68cell2.setCellValue(BRF37.getR87_average_rate() == null ? 0
										: BRF37.getR87_average_rate().intValue());
							}

							/////////////////////////////// R88//////////////////

							Row R69row = sheet.getRow(92);
							Cell R69cell = R69row.getCell(3);
							if (R69cell != null) {
								R69cell.setCellValue(BRF37.getR88_minimum_rate() == null ? 0
										: BRF37.getR88_minimum_rate().intValue());
							}

							Cell R69cell1 = R69row.getCell(4);
							if (R69cell1 != null) {
								R69cell1.setCellValue(BRF37.getR88_maximum_rate() == null ? 0
										: BRF37.getR88_maximum_rate().intValue());
							}

							Cell R69cell2 = R69row.getCell(5);
							if (R69cell2 != null) {
								R69cell2.setCellValue(BRF37.getR88_average_rate() == null ? 0
										: BRF37.getR88_average_rate().intValue());
							}

							/////////////////////////////// R89//////////////////

							Row R70row = sheet.getRow(93);
							Cell R70cell = R70row.getCell(3);
							if (R70cell != null) {
								R70cell.setCellValue(BRF37.getR89_minimum_rate() == null ? 0
										: BRF37.getR89_minimum_rate().intValue());
							}

							Cell R70cell1 = R70row.getCell(4);
							if (R70cell1 != null) {
								R70cell1.setCellValue(BRF37.getR89_maximum_rate() == null ? 0
										: BRF37.getR89_maximum_rate().intValue());
							}

							Cell R70cell2 = R70row.getCell(5);
							if (R70cell2 != null) {
								R70cell2.setCellValue(BRF37.getR89_average_rate() == null ? 0
										: BRF37.getR89_average_rate().intValue());
							}

							/////////////////////////////// R143//////////////////

							Row R125row = sheet.getRow(94);
							Cell R125cell = R125row.getCell(3);
							if (R125cell != null) {
								R125cell.setCellValue(BRF37.getR143_minimum_rate() == null ? 0
										: BRF37.getR143_minimum_rate().intValue());
							}

							Cell R125cell1 = R125row.getCell(4);
							if (R125cell1 != null) {
								R125cell1.setCellValue(BRF37.getR143_maximum_rate() == null ? 0
										: BRF37.getR143_maximum_rate().intValue());
							}

							Cell R125cell2 = R125row.getCell(5);
							if (R125cell2 != null) {
								R125cell2.setCellValue(BRF37.getR143_average_rate() == null ? 0
										: BRF37.getR143_average_rate().intValue());
							}

							/////////////////////////////// R90//////////////////

							Row R71row = sheet.getRow(95);
							Cell R71cell = R71row.getCell(3);
							if (R71cell != null) {
								R71cell.setCellValue(BRF37.getR90_minimum_rate() == null ? 0
										: BRF37.getR90_minimum_rate().intValue());
							}

							Cell R71cell1 = R71row.getCell(4);
							if (R71cell1 != null) {
								R71cell1.setCellValue(BRF37.getR90_maximum_rate() == null ? 0
										: BRF37.getR90_maximum_rate().intValue());
							}

							Cell R71cell2 = R71row.getCell(5);
							if (R71cell2 != null) {
								R71cell2.setCellValue(BRF37.getR90_average_rate() == null ? 0
										: BRF37.getR90_average_rate().intValue());
							}

							/////////////////////////////// R91//////////////////

							Row R72row = sheet.getRow(96);
							Cell R72cell = R72row.getCell(3);
							if (R72cell != null) {
								R72cell.setCellValue(BRF37.getR91_minimum_rate() == null ? 0
										: BRF37.getR91_minimum_rate().intValue());
							}

							Cell R72cell1 = R72row.getCell(4);
							if (R72cell1 != null) {
								R72cell1.setCellValue(BRF37.getR91_maximum_rate() == null ? 0
										: BRF37.getR91_maximum_rate().intValue());
							}

							Cell R72cell2 = R72row.getCell(5);
							if (R72cell2 != null) {
								R72cell2.setCellValue(BRF37.getR91_average_rate() == null ? 0
										: BRF37.getR91_average_rate().intValue());
							}

							/////////////////////////////// R92//////////////////

							Row R73row = sheet.getRow(97);
							Cell R73cell = R73row.getCell(3);
							if (R73cell != null) {
								R73cell.setCellValue(BRF37.getR92_minimum_rate() == null ? 0
										: BRF37.getR92_minimum_rate().intValue());
							}

							Cell R73cell1 = R73row.getCell(4);
							if (R73cell1 != null) {
								R73cell1.setCellValue(BRF37.getR92_maximum_rate() == null ? 0
										: BRF37.getR92_maximum_rate().intValue());
							}

							Cell R73cell2 = R73row.getCell(5);
							if (R73cell2 != null) {
								R73cell2.setCellValue(BRF37.getR92_average_rate() == null ? 0
										: BRF37.getR92_average_rate().intValue());
							}

							/////////////////////////////// R93//////////////////

							Row R74row = sheet.getRow(98);
							Cell R74cell = R74row.getCell(3);
							if (R74cell != null) {
								R74cell.setCellValue(BRF37.getR93_minimum_rate() == null ? 0
										: BRF37.getR93_minimum_rate().intValue());
							}

							Cell R74cell1 = R74row.getCell(4);
							if (R74cell1 != null) {
								R74cell1.setCellValue(BRF37.getR93_maximum_rate() == null ? 0
										: BRF37.getR93_maximum_rate().intValue());
							}

							Cell R74cell2 = R74row.getCell(5);
							if (R74cell2 != null) {
								R74cell2.setCellValue(BRF37.getR93_average_rate() == null ? 0
										: BRF37.getR93_average_rate().intValue());
							}

							/////////////////////////////// R94//////////////////

							Row R75row = sheet.getRow(99);
							Cell R75cell = R75row.getCell(3);
							if (R75cell != null) {
								R75cell.setCellValue(BRF37.getR94_minimum_rate() == null ? 0
										: BRF37.getR94_minimum_rate().intValue());
							}

							Cell R75cell1 = R75row.getCell(4);
							if (R75cell1 != null) {
								R75cell1.setCellValue(BRF37.getR94_maximum_rate() == null ? 0
										: BRF37.getR94_maximum_rate().intValue());
							}

							Cell R75cell2 = R75row.getCell(5);
							if (R75cell2 != null) {
								R75cell2.setCellValue(BRF37.getR94_average_rate() == null ? 0
										: BRF37.getR94_average_rate().intValue());
							}

							/////////////////////////////// R95//////////////////

							Row R76row = sheet.getRow(100);
							Cell R76cell = R76row.getCell(3);
							if (R76cell != null) {
								R76cell.setCellValue(BRF37.getR95_minimum_rate() == null ? 0
										: BRF37.getR95_minimum_rate().intValue());
							}

							Cell R76cell1 = R76row.getCell(4);
							if (R76cell1 != null) {
								R76cell1.setCellValue(BRF37.getR95_maximum_rate() == null ? 0
										: BRF37.getR95_maximum_rate().intValue());
							}

							Cell R76cell2 = R76row.getCell(5);
							if (R76cell2 != null) {
								R76cell2.setCellValue(BRF37.getR95_average_rate() == null ? 0
										: BRF37.getR95_average_rate().intValue());
							}

							/////////////////////////////// R96//////////////////

							Row R77row = sheet.getRow(101);
							Cell R77cell = R77row.getCell(3);
							if (R77cell != null) {
								R77cell.setCellValue(BRF37.getR96_minimum_rate() == null ? 0
										: BRF37.getR96_minimum_rate().intValue());
							}

							Cell R77cell1 = R77row.getCell(4);
							if (R77cell1 != null) {
								R77cell1.setCellValue(BRF37.getR96_maximum_rate() == null ? 0
										: BRF37.getR96_maximum_rate().intValue());
							}

							Cell R77cell2 = R77row.getCell(5);
							if (R77cell2 != null) {
								R77cell2.setCellValue(BRF37.getR96_average_rate2() == null ? 0
										: BRF37.getR96_average_rate2().intValue());
							}

							/////////////////////////////// R97//////////////////

							Row R78row = sheet.getRow(102);
							Cell R78cell = R78row.getCell(3);
							if (R78cell != null) {
								R78cell.setCellValue(BRF37.getR97_minimum_rate() == null ? 0
										: BRF37.getR97_minimum_rate().intValue());
							}

							Cell R78cell1 = R78row.getCell(4);
							if (R78cell1 != null) {
								R78cell1.setCellValue(BRF37.getR97_maximum_rate() == null ? 0
										: BRF37.getR97_maximum_rate().intValue());
							}

							Cell R78cell2 = R78row.getCell(5);
							if (R78cell2 != null) {
								R78cell2.setCellValue(BRF37.getR97_average_rate() == null ? 0
										: BRF37.getR97_average_rate().intValue());
							}

							/////////////////////////////// R98//////////////////

							Row R79row = sheet.getRow(103);
							Cell R79cell = R79row.getCell(3);
							if (R79cell != null) {
								R79cell.setCellValue(BRF37.getR98_minimum_rate() == null ? 0
										: BRF37.getR98_minimum_rate().intValue());
							}

							Cell R79cell1 = R79row.getCell(4);
							if (R79cell1 != null) {
								R79cell1.setCellValue(BRF37.getR98_maximum_rate() == null ? 0
										: BRF37.getR98_maximum_rate().intValue());
							}

							Cell R79cell2 = R79row.getCell(5);
							if (R79cell2 != null) {
								R79cell2.setCellValue(BRF37.getR98_average_rate() == null ? 0
										: BRF37.getR98_average_rate().intValue());
							}

							/////////////////////////////// R99//////////////////

							Row R80row = sheet.getRow(104);
							Cell R80cell = R80row.getCell(3);
							if (R80cell != null) {
								R80cell.setCellValue(BRF37.getR99_minimum_rate() == null ? 0
										: BRF37.getR99_minimum_rate().intValue());
							}

							Cell R80cell1 = R80row.getCell(4);
							if (R80cell1 != null) {
								R80cell1.setCellValue(BRF37.getR99_maximum_rate() == null ? 0
										: BRF37.getR99_maximum_rate().intValue());
							}

							Cell R80cell2 = R80row.getCell(5);
							if (R80cell2 != null) {
								R80cell2.setCellValue(BRF37.getR99_average_rate() == null ? 0
										: BRF37.getR99_average_rate().intValue());
							}

							/////////////////////////////// R100//////////////////

							Row R81row = sheet.getRow(105);
							Cell R81cell = R81row.getCell(3);
							if (R81cell != null) {
								R81cell.setCellValue(BRF37.getR100_minimum_rate() == null ? 0
										: BRF37.getR100_minimum_rate().intValue());
							}

							Cell R81cell1 = R81row.getCell(4);
							if (R81cell1 != null) {
								R81cell1.setCellValue(BRF37.getR100_maximum_rate() == null ? 0
										: BRF37.getR100_maximum_rate().intValue());
							}

							Cell R81cell2 = R81row.getCell(5);
							if (R81cell2 != null) {
								R81cell2.setCellValue(BRF37.getR100_average_rate() == null ? 0
										: BRF37.getR100_average_rate().intValue());
							}

							/////////////////////////////// R101//////////////////

							Row R82row = sheet.getRow(106);
							Cell R82cell = R82row.getCell(3);
							if (R82cell != null) {
								R82cell.setCellValue(BRF37.getR101_minimum_rate() == null ? 0
										: BRF37.getR101_minimum_rate().intValue());
							}

							Cell R82cell1 = R82row.getCell(4);
							if (R82cell1 != null) {
								R82cell1.setCellValue(BRF37.getR101_maximum_rate() == null ? 0
										: BRF37.getR101_maximum_rate().intValue());
							}

							Cell R82cell2 = R82row.getCell(5);
							if (R82cell2 != null) {
								R82cell2.setCellValue(BRF37.getR101_average_rate() == null ? 0
										: BRF37.getR101_average_rate().intValue());
							}

							/////////////////////////////// R102//////////////////

							Row R83row = sheet.getRow(107);
							Cell R83cell = R83row.getCell(3);
							if (R83cell != null) {
								R83cell.setCellValue(BRF37.getR102_minimum_rate() == null ? 0
										: BRF37.getR102_minimum_rate().intValue());
							}

							Cell R83cell1 = R83row.getCell(4);
							if (R83cell1 != null) {
								R83cell1.setCellValue(BRF37.getR102_maximum_rate() == null ? 0
										: BRF37.getR102_maximum_rate().intValue());
							}

							Cell R83cell2 = R83row.getCell(5);
							if (R83cell2 != null) {
								R83cell2.setCellValue(BRF37.getR102_average_rate() == null ? 0
										: BRF37.getR102_average_rate().intValue());
							}

							/////////////////////////////// R103//////////////////

							Row R84row = sheet.getRow(108);
							Cell R84cell = R84row.getCell(3);
							if (R84cell != null) {
								R84cell.setCellValue(BRF37.getR103_minimum_rate() == null ? 0
										: BRF37.getR103_minimum_rate().intValue());
							}

							Cell R84cell1 = R84row.getCell(4);
							if (R84cell1 != null) {
								R84cell1.setCellValue(BRF37.getR103_maximum_rate() == null ? 0
										: BRF37.getR103_maximum_rate().intValue());
							}

							Cell R84cell2 = R84row.getCell(5);
							if (R84cell2 != null) {
								R84cell2.setCellValue(BRF37.getR103_average_rate() == null ? 0
										: BRF37.getR103_average_rate().intValue());
							}

							/////////////////////////////// R104//////////////////

							Row R85row = sheet.getRow(109);
							Cell R85cell = R85row.getCell(3);
							if (R85cell != null) {
								R85cell.setCellValue(BRF37.getR104_minimum_rate() == null ? 0
										: BRF37.getR104_minimum_rate().intValue());
							}

							Cell R85cell1 = R85row.getCell(4);
							if (R85cell1 != null) {
								R85cell1.setCellValue(BRF37.getR104_maximum_rate() == null ? 0
										: BRF37.getR104_maximum_rate().intValue());
							}

							Cell R85cell2 = R85row.getCell(5);
							if (R85cell2 != null) {
								R85cell2.setCellValue(BRF37.getR104_average_rate() == null ? 0
										: BRF37.getR104_average_rate().intValue());
							}

							/////////////////////////////// R105//////////////////

							Row R86row = sheet.getRow(110);
							Cell R86cell = R86row.getCell(3);
							if (R86cell != null) {
								R86cell.setCellValue(BRF37.getR105_minimum_rate() == null ? 0
										: BRF37.getR105_minimum_rate().intValue());
							}

							Cell R86cell1 = R86row.getCell(4);
							if (R86cell1 != null) {
								R86cell1.setCellValue(BRF37.getR105_maximum_rate() == null ? 0
										: BRF37.getR105_maximum_rate().intValue());
							}

							Cell R86cell2 = R86row.getCell(5);
							if (R86cell2 != null) {
								R86cell2.setCellValue(BRF37.getR105_average_rate() == null ? 0
										: BRF37.getR105_average_rate().intValue());
							}

							/////////////////////////////// R106//////////////////

							Row R87row = sheet.getRow(111);
							Cell R87cell = R87row.getCell(3);
							if (R87cell != null) {
								R87cell.setCellValue(BRF37.getR106_minimum_rate() == null ? 0
										: BRF37.getR106_minimum_rate().intValue());
							}

							Cell R87cell1 = R87row.getCell(4);
							if (R87cell1 != null) {
								R87cell1.setCellValue(BRF37.getR106_maximum_rate() == null ? 0
										: BRF37.getR106_maximum_rate().intValue());
							}

							Cell R87cell2 = R87row.getCell(5);
							if (R87cell2 != null) {
								R87cell2.setCellValue(BRF37.getR106_average_rate() == null ? 0
										: BRF37.getR106_average_rate().intValue());
							}

							/////////////////////////////// R107//////////////////

							Row R88row = sheet.getRow(112);
							Cell R88cell = R88row.getCell(3);
							if (R88cell != null) {
								R88cell.setCellValue(BRF37.getR107_minimum_rate() == null ? 0
										: BRF37.getR107_minimum_rate().intValue());
							}

							Cell R88cell1 = R88row.getCell(4);
							if (R88cell1 != null) {
								R88cell1.setCellValue(BRF37.getR107_maximum_rate() == null ? 0
										: BRF37.getR107_maximum_rate().intValue());
							}

							Cell R88cell2 = R88row.getCell(5);
							if (R88cell2 != null) {
								R88cell2.setCellValue(BRF37.getR107_average_rate() == null ? 0
										: BRF37.getR107_average_rate().intValue());
							}

							/////////////////////////////// R108//////////////////

							Row R89row = sheet.getRow(113);
							Cell R89cell = R89row.getCell(3);
							if (R89cell != null) {
								R89cell.setCellValue(BRF37.getR108_minimum_rate() == null ? 0
										: BRF37.getR108_minimum_rate().intValue());
							}

							Cell R89cell1 = R89row.getCell(4);
							if (R89cell1 != null) {
								R89cell1.setCellValue(BRF37.getR108_maximum_rate() == null ? 0
										: BRF37.getR108_maximum_rate().intValue());
							}

							Cell R89cell2 = R89row.getCell(5);
							if (R89cell2 != null) {
								R89cell2.setCellValue(BRF37.getR108_average_rate() == null ? 0
										: BRF37.getR108_average_rate().intValue());
							}

							/////////////////////////////// R109//////////////////

							Row R90row = sheet.getRow(114);
							Cell R90cell = R90row.getCell(3);
							if (R90cell != null) {
								R90cell.setCellValue(BRF37.getR109_minimum_rate() == null ? 0
										: BRF37.getR109_minimum_rate().intValue());
							}

							Cell R90cell1 = R90row.getCell(4);
							if (R90cell1 != null) {
								R90cell1.setCellValue(BRF37.getR109_maximum_rate() == null ? 0
										: BRF37.getR109_maximum_rate().intValue());
							}

							Cell R90cell2 = R90row.getCell(5);
							if (R90cell2 != null) {
								R90cell2.setCellValue(BRF37.getR109_average_rate() == null ? 0
										: BRF37.getR109_average_rate().intValue());
							}

							/////////////////////////////// R110//////////////////

							Row R91row = sheet.getRow(115);
							Cell R91cell = R91row.getCell(3);
							if (R91cell != null) {
								R91cell.setCellValue(BRF37.getR110_minimum_rate() == null ? 0
										: BRF37.getR110_minimum_rate().intValue());
							}

							Cell R91cell1 = R91row.getCell(4);
							if (R91cell1 != null) {
								R91cell1.setCellValue(BRF37.getR110_maximum_rate() == null ? 0
										: BRF37.getR110_maximum_rate().intValue());
							}

							Cell R91cell2 = R91row.getCell(5);
							if (R91cell2 != null) {
								R91cell2.setCellValue(BRF37.getR110_average_rate() == null ? 0
										: BRF37.getR110_average_rate().intValue());
							}

							/////////////////////////////// R111//////////////////

							Row R92row = sheet.getRow(116);
							Cell R92cell = R92row.getCell(3);
							if (R92cell != null) {
								R92cell.setCellValue(BRF37.getR111_minimum_rate() == null ? 0
										: BRF37.getR111_minimum_rate().intValue());
							}

							Cell R92cell1 = R92row.getCell(4);
							if (R92cell1 != null) {
								R92cell1.setCellValue(BRF37.getR111_maximum_rate() == null ? 0
										: BRF37.getR111_maximum_rate().intValue());
							}

							Cell R92cell2 = R92row.getCell(5);
							if (R92cell2 != null) {
								R92cell2.setCellValue(BRF37.getR111_average_rate() == null ? 0
										: BRF37.getR111_average_rate().intValue());
							}

							/////////////////////////////// R112//////////////////

							Row R93row = sheet.getRow(117);
							Cell R93cell = R93row.getCell(3);
							if (R93cell != null) {
								R93cell.setCellValue(BRF37.getR112_minimum_rate() == null ? 0
										: BRF37.getR112_minimum_rate().intValue());
							}

							Cell R93cell1 = R93row.getCell(4);
							if (R93cell1 != null) {
								R93cell1.setCellValue(BRF37.getR112_maximum_rate() == null ? 0
										: BRF37.getR112_maximum_rate().intValue());
							}

							Cell R93cell2 = R93row.getCell(5);
							if (R93cell2 != null) {
								R93cell2.setCellValue(BRF37.getR112_average_rate() == null ? 0
										: BRF37.getR112_average_rate().intValue());
							}

							/////////////////////////////// R113//////////////////

							Row R94row = sheet.getRow(118);
							Cell R94cell = R94row.getCell(3);
							if (R94cell != null) {
								R94cell.setCellValue(BRF37.getR113_minimum_rate() == null ? 0
										: BRF37.getR113_minimum_rate().intValue());
							}

							Cell R94cell1 = R94row.getCell(4);
							if (R94cell1 != null) {
								R94cell1.setCellValue(BRF37.getR113_maximum_rate() == null ? 0
										: BRF37.getR113_maximum_rate().intValue());
							}

							Cell R94cell2 = R94row.getCell(5);
							if (R94cell2 != null) {
								R94cell2.setCellValue(BRF37.getR113_average_rate() == null ? 0
										: BRF37.getR113_average_rate().intValue());
							}

							/////////////////////////////// R114//////////////////

							Row R95row = sheet.getRow(119);
							Cell R95cell = R95row.getCell(3);
							if (R95cell != null) {
								R95cell.setCellValue(BRF37.getR114_minimum_rate() == null ? 0
										: BRF37.getR114_minimum_rate().intValue());
							}

							Cell R95cell1 = R95row.getCell(4);
							if (R95cell1 != null) {
								R95cell1.setCellValue(BRF37.getR114_maximum_rate() == null ? 0
										: BRF37.getR114_maximum_rate().intValue());
							}

							Cell R95cell2 = R95row.getCell(5);
							if (R95cell2 != null) {
								R95cell2.setCellValue(BRF37.getR114_average_rate() == null ? 0
										: BRF37.getR114_average_rate().intValue());
							}

							/////////////////////////////// R115//////////////////

							Row R96row = sheet.getRow(120);
							Cell R96cell = R96row.getCell(3);
							if (R96cell != null) {
								R96cell.setCellValue(BRF37.getR115_minimum_rate() == null ? 0
										: BRF37.getR115_minimum_rate().intValue());
							}

							Cell R96cell1 = R96row.getCell(4);
							if (R96cell1 != null) {
								R96cell1.setCellValue(BRF37.getR115_maximum_rate() == null ? 0
										: BRF37.getR115_maximum_rate().intValue());
							}

							Cell R96cell2 = R96row.getCell(5);
							if (R96cell2 != null) {
								R96cell2.setCellValue(BRF37.getR115_average_rate() == null ? 0
										: BRF37.getR115_average_rate().intValue());
							}

							/////////////////////////////// R116//////////////////

							Row R97row = sheet.getRow(121);
							Cell R97cell = R97row.getCell(3);
							if (R97cell != null) {
								R97cell.setCellValue(BRF37.getR116_minimum_rate() == null ? 0
										: BRF37.getR116_minimum_rate().intValue());
							}

							Cell R97cell1 = R97row.getCell(4);
							if (R97cell1 != null) {
								R97cell1.setCellValue(BRF37.getR116_maximum_rate() == null ? 0
										: BRF37.getR116_maximum_rate().intValue());
							}

							Cell R97cell2 = R97row.getCell(5);
							if (R97cell2 != null) {
								R97cell2.setCellValue(BRF37.getR116_average_rate() == null ? 0
										: BRF37.getR116_average_rate().intValue());
							}

							/////////////////////////////// R117//////////////////

							Row R98row = sheet.getRow(122);
							Cell R98cell = R98row.getCell(3);
							if (R98cell != null) {
								R98cell.setCellValue(BRF37.getR117_minimum_rate() == null ? 0
										: BRF37.getR117_minimum_rate().intValue());
							}

							Cell R98cell1 = R98row.getCell(4);
							if (R98cell1 != null) {
								R98cell1.setCellValue(BRF37.getR117_maximum_rate() == null ? 0
										: BRF37.getR117_maximum_rate().intValue());
							}

							Cell R98cell2 = R98row.getCell(5);
							if (R98cell2 != null) {
								R98cell2.setCellValue(BRF37.getR117_average_rate() == null ? 0
										: BRF37.getR117_average_rate().intValue());
							}

							/////////////////////////////// R118//////////////////

							Row R99row = sheet.getRow(123);
							Cell R99cell = R99row.getCell(3);
							if (R99cell != null) {
								R99cell.setCellValue(BRF37.getR118_minimum_rate() == null ? 0
										: BRF37.getR118_minimum_rate().intValue());
							}

							Cell R99cell1 = R99row.getCell(4);
							if (R99cell1 != null) {
								R99cell1.setCellValue(BRF37.getR118_maximum_rate() == null ? 0
										: BRF37.getR118_maximum_rate().intValue());
							}

							Cell R99cell2 = R99row.getCell(5);
							if (R99cell2 != null) {
								R99cell2.setCellValue(BRF37.getR118_average_rate() == null ? 0
										: BRF37.getR118_average_rate().intValue());
							}

							/////////////////////////////// R119//////////////////

							Row R100row = sheet.getRow(124);
							Cell R100cell = R100row.getCell(3);
							if (R100cell != null) {
								R100cell.setCellValue(BRF37.getR119_minimum_rate() == null ? 0
										: BRF37.getR119_minimum_rate().intValue());
							}

							Cell R100cell1 = R100row.getCell(4);
							if (R100cell1 != null) {
								R100cell1.setCellValue(BRF37.getR119_maximum_rate() == null ? 0
										: BRF37.getR119_maximum_rate().intValue());
							}

							Cell R100cell2 = R100row.getCell(5);
							if (R100cell2 != null) {
								R100cell2.setCellValue(BRF37.getR119_average_rate() == null ? 0
										: BRF37.getR119_average_rate().intValue());
							}

							/////////////////////////////// R120//////////////////

							Row R101row = sheet.getRow(125);
							Cell R101cell = R101row.getCell(3);
							if (R101cell != null) {
								R101cell.setCellValue(BRF37.getR120_minimum_rate() == null ? 0
										: BRF37.getR120_minimum_rate().intValue());
							}

							Cell R101cell1 = R101row.getCell(4);
							if (R101cell1 != null) {
								R101cell1.setCellValue(BRF37.getR120_maximum_rate() == null ? 0
										: BRF37.getR120_maximum_rate().intValue());
							}

							Cell R101cell2 = R101row.getCell(5);
							if (R101cell2 != null) {
								R101cell2.setCellValue(BRF37.getR120_average_rate() == null ? 0
										: BRF37.getR120_average_rate().intValue());
							}

							/////////////////////////////// R121//////////////////

							Row R102row = sheet.getRow(126);
							Cell R102cell = R102row.getCell(3);
							if (R102cell != null) {
								R102cell.setCellValue(BRF37.getR121_minimum_rate() == null ? 0
										: BRF37.getR121_minimum_rate().intValue());
							}

							Cell R102cell1 = R102row.getCell(4);
							if (R102cell1 != null) {
								R102cell1.setCellValue(BRF37.getR121_maximum_rate() == null ? 0
										: BRF37.getR121_maximum_rate().intValue());
							}

							Cell R102cell2 = R102row.getCell(5);
							if (R102cell2 != null) {
								R102cell2.setCellValue(BRF37.getR121_average_rate() == null ? 0
										: BRF37.getR121_average_rate().intValue());
							}

							/////////////////////////////// R122//////////////////

							Row R103row = sheet.getRow(127);
							Cell R103cell = R103row.getCell(3);
							if (R103cell != null) {
								R103cell.setCellValue(BRF37.getR122_minimum_rate() == null ? 0
										: BRF37.getR122_minimum_rate().intValue());
							}

							Cell R103cell1 = R103row.getCell(4);
							if (R103cell1 != null) {
								R103cell1.setCellValue(BRF37.getR122_maximum_rate() == null ? 0
										: BRF37.getR122_maximum_rate().intValue());
							}

							Cell R103cell2 = R103row.getCell(5);
							if (R103cell2 != null) {
								R103cell2.setCellValue(BRF37.getR122_average_rate() == null ? 0
										: BRF37.getR122_average_rate().intValue());
							}

							/////////////////////////////// R123//////////////////

							Row R104row = sheet.getRow(128);
							Cell R104cell = R104row.getCell(3);
							if (R104cell != null) {
								R104cell.setCellValue(BRF37.getR123_minimum_rate() == null ? 0
										: BRF37.getR123_minimum_rate().intValue());
							}

							Cell R104cell1 = R104row.getCell(4);
							if (R104cell1 != null) {
								R104cell1.setCellValue(BRF37.getR123_maximum_rate() == null ? 0
										: BRF37.getR123_maximum_rate().intValue());
							}

							Cell R104cell2 = R104row.getCell(5);
							if (R104cell2 != null) {
								R104cell2.setCellValue(BRF37.getR123_average_rate() == null ? 0
										: BRF37.getR123_average_rate().intValue());
							}

							/////////////////////////////// R124//////////////////

							Row R105row = sheet.getRow(129);
							Cell R105cell = R105row.getCell(3);
							if (R105cell != null) {
								R105cell.setCellValue(BRF37.getR124_minimum_rate() == null ? 0
										: BRF37.getR124_minimum_rate().intValue());
							}

							Cell R105cell1 = R105row.getCell(4);
							if (R105cell1 != null) {
								R105cell1.setCellValue(BRF37.getR124_maximum_rate() == null ? 0
										: BRF37.getR124_maximum_rate().intValue());
							}

							Cell R105cell2 = R105row.getCell(5);
							if (R105cell2 != null) {
								R105cell2.setCellValue(BRF37.getR124_average_rate() == null ? 0
										: BRF37.getR124_average_rate().intValue());
							}

							/////////////////////////////// R125//////////////////

							Row R106row = sheet.getRow(130);
							Cell R106cell = R106row.getCell(3);
							if (R106cell != null) {
								R106cell.setCellValue(BRF37.getR125_minimum_rate() == null ? 0
										: BRF37.getR125_minimum_rate().intValue());
							}

							Cell R106cell1 = R106row.getCell(4);
							if (R106cell1 != null) {
								R106cell1.setCellValue(BRF37.getR125_maximum_rate() == null ? 0
										: BRF37.getR125_maximum_rate().intValue());
							}

							Cell R106cell2 = R106row.getCell(5);
							if (R106cell2 != null) {
								R106cell2.setCellValue(BRF37.getR125_average_rate() == null ? 0
										: BRF37.getR125_average_rate().intValue());
							}

							/////////////////////////////// R126//////////////////

							Row R107row = sheet.getRow(131);
							Cell R107cell = R107row.getCell(3);
							if (R107cell != null) {
								R107cell.setCellValue(BRF37.getR126_minimum_rate() == null ? 0
										: BRF37.getR126_minimum_rate().intValue());
							}

							Cell R107cell1 = R107row.getCell(4);
							if (R107cell1 != null) {
								R107cell1.setCellValue(BRF37.getR126_maximum_rate() == null ? 0
										: BRF37.getR126_maximum_rate().intValue());
							}

							Cell R107cell2 = R107row.getCell(5);
							if (R107cell2 != null) {
								R107cell2.setCellValue(BRF37.getR126_average_rate() == null ? 0
										: BRF37.getR126_average_rate().intValue());
							}

							/////////////////////////////// R127//////////////////

							Row R108row = sheet.getRow(132);
							Cell R108cell = R108row.getCell(3);
							if (R108cell != null) {
								R108cell.setCellValue(BRF37.getR127_minimum_rate() == null ? 0
										: BRF37.getR127_minimum_rate().intValue());
							}

							Cell R108cell1 = R108row.getCell(4);
							if (R108cell1 != null) {
								R108cell1.setCellValue(BRF37.getR127_maximum_rate() == null ? 0
										: BRF37.getR127_maximum_rate().intValue());
							}

							Cell R108cell2 = R108row.getCell(5);
							if (R108cell2 != null) {
								R108cell2.setCellValue(BRF37.getR127_average_rate() == null ? 0
										: BRF37.getR127_average_rate().intValue());
							}

							/////////////////////////////// R128//////////////////

							Row R109row = sheet.getRow(133);
							Cell R109cell = R109row.getCell(3);
							if (R109cell != null) {
								R109cell.setCellValue(BRF37.getR128_minimum_rate() == null ? 0
										: BRF37.getR128_minimum_rate().intValue());
							}

							Cell R109cell1 = R109row.getCell(4);
							if (R109cell1 != null) {
								R109cell1.setCellValue(BRF37.getR128_maximum_rate() == null ? 0
										: BRF37.getR128_maximum_rate().intValue());
							}

							Cell R109cell2 = R109row.getCell(5);
							if (R109cell2 != null) {
								R109cell2.setCellValue(BRF37.getR128_average_rate() == null ? 0
										: BRF37.getR128_average_rate().intValue());
							}

							/////////////////////////////// R129//////////////////

							Row R110row = sheet.getRow(134);
							Cell R110cell = R110row.getCell(3);
							if (R110cell != null) {
								R110cell.setCellValue(BRF37.getR129_minimum_rate() == null ? 0
										: BRF37.getR129_minimum_rate().intValue());
							}

							Cell R110cell1 = R110row.getCell(4);
							if (R110cell1 != null) {
								R110cell1.setCellValue(BRF37.getR129_maximum_rate() == null ? 0
										: BRF37.getR129_maximum_rate().intValue());
							}

							Cell R110cell2 = R110row.getCell(5);
							if (R110cell2 != null) {
								R110cell2.setCellValue(BRF37.getR129_average_rate() == null ? 0
										: BRF37.getR129_average_rate().intValue());
							}

							/////////////////////////////// R144//////////////////

							Row R124row = sheet.getRow(135);
							Cell R124cell = R124row.getCell(3);
							if (R124cell != null) {
								R124cell.setCellValue(BRF37.getR144_minimum_rate() == null ? 0
										: BRF37.getR144_minimum_rate().intValue());
							}

							Cell R124cell1 = R124row.getCell(4);
							if (R124cell1 != null) {
								R124cell1.setCellValue(BRF37.getR144_maximum_rate() == null ? 0
										: BRF37.getR144_maximum_rate().intValue());
							}

							Cell R124cell2 = R124row.getCell(5);
							if (R124cell2 != null) {
								R124cell2.setCellValue(BRF37.getR144_average_rate() == null ? 0
										: BRF37.getR144_average_rate().intValue());
							}

							/////////////////////////////// R130//////////////////

							Row R111row = sheet.getRow(136);
							Cell R111cell = R111row.getCell(3);
							if (R111cell != null) {
								R111cell.setCellValue(BRF37.getR130_minimum_rate() == null ? 0
										: BRF37.getR130_minimum_rate().intValue());
							}

							Cell R111cell1 = R111row.getCell(4);
							if (R111cell1 != null) {
								R111cell1.setCellValue(BRF37.getR130_maximum_rate() == null ? 0
										: BRF37.getR130_maximum_rate().intValue());
							}

							Cell R111cell2 = R111row.getCell(5);
							if (R111cell2 != null) {
								R111cell2.setCellValue(BRF37.getR130_average_rate() == null ? 0
										: BRF37.getR130_average_rate().intValue());
							}

							/////////////////////////////// R131//////////////////

							Row R112row = sheet.getRow(137);
							Cell R112cell = R112row.getCell(3);
							if (R112cell != null) {
								R112cell.setCellValue(BRF37.getR131_minimum_rate() == null ? 0
										: BRF37.getR131_minimum_rate().intValue());
							}

							Cell R112cell1 = R112row.getCell(4);
							if (R112cell1 != null) {
								R112cell1.setCellValue(BRF37.getR131_maximum_rate() == null ? 0
										: BRF37.getR131_maximum_rate().intValue());
							}

							Cell R112cell2 = R112row.getCell(5);
							if (R112cell2 != null) {
								R112cell2.setCellValue(BRF37.getR131_average_rate() == null ? 0
										: BRF37.getR131_average_rate().intValue());
							}

							/////////////////////////////// R132//////////////////

							Row R113row = sheet.getRow(138);
							Cell R113cell = R113row.getCell(3);
							if (R113cell != null) {
								R113cell.setCellValue(BRF37.getR132_minimum_rate() == null ? 0
										: BRF37.getR132_minimum_rate().intValue());
							}

							Cell R113cell1 = R113row.getCell(4);
							if (R113cell1 != null) {
								R113cell1.setCellValue(BRF37.getR132_maximum_rate() == null ? 0
										: BRF37.getR132_maximum_rate().intValue());
							}

							Cell R113cell2 = R113row.getCell(5);
							if (R113cell2 != null) {
								R113cell2.setCellValue(BRF37.getR132_average_rate() == null ? 0
										: BRF37.getR132_average_rate().intValue());
							}

							/////////////////////////////// R133//////////////////

							Row R114row = sheet.getRow(139);
							Cell R114cell = R114row.getCell(3);
							if (R114cell != null) {
								R114cell.setCellValue(BRF37.getR133_minimum_rate() == null ? 0
										: BRF37.getR133_minimum_rate().intValue());
							}

							Cell R114cell1 = R114row.getCell(4);
							if (R114cell1 != null) {
								R114cell1.setCellValue(BRF37.getR133_maximum_rate() == null ? 0
										: BRF37.getR133_maximum_rate().intValue());
							}

							Cell R114cell2 = R114row.getCell(5);
							if (R114cell2 != null) {
								R114cell2.setCellValue(BRF37.getR133_average_rate() == null ? 0
										: BRF37.getR133_average_rate().intValue());
							}

							/////////////////////////////// R134//////////////////

							Row R115row = sheet.getRow(140);
							Cell R115cell = R115row.getCell(3);
							if (R115cell != null) {
								R115cell.setCellValue(BRF37.getR134_minimum_rate() == null ? 0
										: BRF37.getR134_minimum_rate().intValue());
							}

							Cell R115cell1 = R115row.getCell(4);
							if (R115cell1 != null) {
								R115cell1.setCellValue(BRF37.getR134_maximum_rate() == null ? 0
										: BRF37.getR134_maximum_rate().intValue());
							}

							Cell R115cell2 = R115row.getCell(5);
							if (R115cell2 != null) {
								R115cell2.setCellValue(BRF37.getR134_average_rate() == null ? 0
										: BRF37.getR134_average_rate().intValue());
							}

							/////////////////////////////// R135//////////////////

							Row R116row = sheet.getRow(141);
							Cell R116cell = R116row.getCell(3);
							if (R116cell != null) {
								R116cell.setCellValue(BRF37.getR135_minimum_rate() == null ? 0
										: BRF37.getR135_minimum_rate().intValue());
							}

							Cell R116cell1 = R116row.getCell(4);
							if (R116cell1 != null) {
								R116cell1.setCellValue(BRF37.getR135_maximum_rate() == null ? 0
										: BRF37.getR135_maximum_rate().intValue());
							}

							Cell R116cell2 = R116row.getCell(5);
							if (R116cell2 != null) {
								R116cell2.setCellValue(BRF37.getR135_average_rate() == null ? 0
										: BRF37.getR135_average_rate().intValue());
							}

							/////////////////////////////// R136//////////////////

							Row R117row = sheet.getRow(144);
							Cell R117cell = R117row.getCell(3);
							if (R117cell != null) {
								R117cell.setCellValue(BRF37.getR136_minimum_rate() == null ? 0
										: BRF37.getR136_minimum_rate().intValue());
							}

							Cell R117cell1 = R117row.getCell(4);
							if (R117cell1 != null) {
								R117cell1.setCellValue(BRF37.getR136_maximum_rate() == null ? 0
										: BRF37.getR136_maximum_rate().intValue());
							}

							Cell R117cell2 = R117row.getCell(5);
							if (R117cell2 != null) {
								R117cell2.setCellValue(BRF37.getR136_average_rate() == null ? 0
										: BRF37.getR136_average_rate().intValue());
							}

							/////////////////////////////// R137//////////////////

							Row R118row = sheet.getRow(145);
							Cell R118cell = R118row.getCell(3);
							if (R118cell != null) {
								R118cell.setCellValue(BRF37.getR137_minimum_rate() == null ? 0
										: BRF37.getR137_minimum_rate().intValue());
							}

							Cell R118cell1 = R118row.getCell(4);
							if (R118cell1 != null) {
								R118cell1.setCellValue(BRF37.getR137_maximum_rate() == null ? 0
										: BRF37.getR137_maximum_rate().intValue());
							}

							Cell R118cell2 = R118row.getCell(5);
							if (R118cell2 != null) {
								R118cell2.setCellValue(BRF37.getR137_average_rate() == null ? 0
										: BRF37.getR137_average_rate().intValue());
							}

///////////////////////////////R138//////////////////

							Row R119row = sheet.getRow(146);
							Cell R119cell = R119row.getCell(3);
							if (R119cell != null) {
								R119cell.setCellValue(BRF37.getR138_minimum_rate() == null ? 0
										: BRF37.getR138_minimum_rate().intValue());
							}

							Cell R119cell1 = R119row.getCell(4);
							if (R119cell1 != null) {
								R119cell1.setCellValue(BRF37.getR138_maximum_rate() == null ? 0
										: BRF37.getR138_maximum_rate().intValue());
							}

							Cell R119cell2 = R119row.getCell(5);
							if (R119cell2 != null) {
								R119cell2.setCellValue(BRF37.getR138_average_rate() == null ? 0
										: BRF37.getR138_average_rate().intValue());
							}

							Cell R119cell3 = R119row.getCell(6);
							if (R119cell3 != null) {
								R119cell3.setCellValue(
										BRF37.getR138_federal() == null ? 0 : BRF37.getR138_federal().intValue());
							}

							Cell R119cell4 = R119row.getCell(7);
							if (R119cell4 != null) {
								R119cell4
										.setCellValue(BRF37.getR138_gre() == null ? 0 : BRF37.getR138_gre().intValue());
							}

							Cell R119cell5 = R119row.getCell(8);
							if (R119cell5 != null) {
								R119cell5.setCellValue(
										BRF37.getR138_nbfi() == null ? 0 : BRF37.getR138_nbfi().intValue());
							}

							Cell R119cell6 = R119row.getCell(9);
							if (R119cell6 != null) {
								R119cell6
										.setCellValue(BRF37.getR138_sme() == null ? 0 : BRF37.getR138_sme().intValue());
							}

///////////////////////////////R139//////////////////

							Row R120row = sheet.getRow(147);
							Cell R120cell = R120row.getCell(3);
							if (R120cell != null) {
								R120cell.setCellValue(BRF37.getR139_minimum_rate() == null ? 0
										: BRF37.getR139_minimum_rate().intValue());
							}

							Cell R120cell1 = R120row.getCell(4);
							if (R120cell1 != null) {
								R120cell1.setCellValue(BRF37.getR139_maximum_rate() == null ? 0
										: BRF37.getR139_maximum_rate().intValue());
							}

							Cell R120cell2 = R120row.getCell(5);
							if (R120cell2 != null) {
								R120cell2.setCellValue(BRF37.getR139_average_rate() == null ? 0
										: BRF37.getR139_average_rate().intValue());
							}

							Cell R120cell3 = R120row.getCell(6);
							if (R120cell3 != null) {
								R120cell3.setCellValue(
										BRF37.getR139_federal() == null ? 0 : BRF37.getR139_federal().intValue());
							}

							Cell R120cell4 = R120row.getCell(7);
							if (R120cell4 != null) {
								R120cell4
										.setCellValue(BRF37.getR139_gre() == null ? 0 : BRF37.getR139_gre().intValue());
							}

							Cell R120cell5 = R120row.getCell(8);
							if (R120cell5 != null) {
								R120cell5.setCellValue(
										BRF37.getR139_nbfi() == null ? 0 : BRF37.getR139_nbfi().intValue());
							}

							Cell R120cell6 = R120row.getCell(9);
							if (R120cell6 != null) {
								R120cell6
										.setCellValue(BRF37.getR139_sme() == null ? 0 : BRF37.getR139_sme().intValue());
							}

///////////////////////////////R140//////////////////

							Row R121row = sheet.getRow(148);
							Cell R121cell = R121row.getCell(3);
							if (R121cell != null) {
								R121cell.setCellValue(BRF37.getR140_minimum_rate() == null ? 0
										: BRF37.getR140_minimum_rate().intValue());
							}

							Cell R121cell1 = R121row.getCell(4);
							if (R121cell1 != null) {
								R121cell1.setCellValue(BRF37.getR140_maximum_rate() == null ? 0
										: BRF37.getR140_maximum_rate().intValue());
							}

							Cell R121cell2 = R121row.getCell(5);
							if (R121cell2 != null) {
								R121cell2.setCellValue(BRF37.getR140_average_rate() == null ? 0
										: BRF37.getR140_average_rate().intValue());
							}

							Cell R121cell3 = R121row.getCell(6);
							if (R121cell3 != null) {
								R121cell3.setCellValue(
										BRF37.getR140_federal() == null ? 0 : BRF37.getR140_federal().intValue());
							}

							Cell R121cell4 = R121row.getCell(7);
							if (R121cell4 != null) {
								R121cell4
										.setCellValue(BRF37.getR140_gre() == null ? 0 : BRF37.getR140_gre().intValue());
							}

							Cell R121cell5 = R121row.getCell(8);
							if (R121cell5 != null) {
								R121cell5.setCellValue(
										BRF37.getR140_nbfi() == null ? 0 : BRF37.getR140_nbfi().intValue());
							}

							Cell R121cell6 = R121row.getCell(9);
							if (R121cell6 != null) {
								R121cell6
										.setCellValue(BRF37.getR140_sme() == null ? 0 : BRF37.getR140_sme().intValue());
							}

///////////////////////////////R141//////////////////

							Row R122row = sheet.getRow(149);
							Cell R122cell = R122row.getCell(3);
							if (R122cell != null) {
								R122cell.setCellValue(BRF37.getR141_minimum_rate() == null ? 0
										: BRF37.getR141_minimum_rate().intValue());
							}

							Cell R122cell1 = R122row.getCell(4);
							if (R122cell1 != null) {
								R122cell1.setCellValue(BRF37.getR141_maximum_rate() == null ? 0
										: BRF37.getR141_maximum_rate().intValue());
							}

							Cell R122cell2 = R122row.getCell(5);
							if (R122cell2 != null) {
								R122cell2.setCellValue(BRF37.getR141_average_rate() == null ? 0
										: BRF37.getR141_average_rate().intValue());
							}

							Cell R122cell3 = R122row.getCell(6);
							if (R122cell3 != null) {
								R122cell3.setCellValue(
										BRF37.getR141_federal() == null ? 0 : BRF37.getR141_federal().intValue());
							}

							Cell R122cell4 = R122row.getCell(7);
							if (R122cell4 != null) {
								R122cell4
										.setCellValue(BRF37.getR141_gre() == null ? 0 : BRF37.getR141_gre().intValue());
							}

							Cell R122cell5 = R122row.getCell(8);
							if (R122cell5 != null) {
								R122cell5.setCellValue(
										BRF37.getR141_nbfi() == null ? 0 : BRF37.getR141_nbfi().intValue());
							}

							Cell R122cell6 = R122row.getCell(9);
							if (R122cell6 != null) {
								R122cell6
										.setCellValue(BRF37.getR141_sme() == null ? 0 : BRF37.getR141_sme().intValue());
							}

///////////////////////////////R142//////////////////

							Row R123row = sheet.getRow(150);
							Cell R123cell = R123row.getCell(3);
							if (R123cell != null) {
								R123cell.setCellValue(BRF37.getR142_minimum_rate() == null ? 0
										: BRF37.getR142_minimum_rate().intValue());
							}

							Cell R123cell1 = R123row.getCell(4);
							if (R123cell1 != null) {
								R123cell1.setCellValue(BRF37.getR142_maximum_rate() == null ? 0
										: BRF37.getR142_maximum_rate().intValue());
							}

							Cell R123cell2 = R123row.getCell(5);
							if (R123cell2 != null) {
								R123cell2.setCellValue(BRF37.getR142_average_rate() == null ? 0
										: BRF37.getR142_average_rate().intValue());
							}

							Cell R123cell3 = R123row.getCell(6);
							if (R123cell3 != null) {
								R123cell3.setCellValue(
										BRF37.getR142_federal() == null ? 0 : BRF37.getR142_federal().intValue());
							}

							Cell R123cell4 = R123row.getCell(7);
							if (R123cell4 != null) {
								R123cell4
										.setCellValue(BRF37.getR142_gre() == null ? 0 : BRF37.getR142_gre().intValue());
							}

							Cell R123cell5 = R123row.getCell(8);
							if (R123cell5 != null) {
								R123cell5.setCellValue(
										BRF37.getR142_nbfi() == null ? 0 : BRF37.getR142_nbfi().intValue());
							}

							Cell R123cell6 = R123row.getCell(9);
							if (R123cell6 != null) {
								R123cell6
										.setCellValue(BRF37.getR142_sme() == null ? 0 : BRF37.getR142_sme().intValue());
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-037-A.xls");
							workbook.write(fileOut);
							fileOut.close();
							System.out.println(fileOut);
							path = fileOut.toString();
							// Close the workbook
							System.out.println("PATH : " + path);
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

			} //// else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-037-A.xls");

		return outputFile;

	}

	public ModelAndView getBRF37currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF37_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF37_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF37_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF37_DETAIL_ENTITY> T1Master = new ArrayList<BRF37_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF37_DETAIL_ENTITY a where a.report_date = ?1", BRF37_DETAIL_ENTITY.class)
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
			String nre_flg = (String) a[49];

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

			BRF37_DETAIL_ENTITY py = new BRF37_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg);
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

		mv.setViewName("RR" + "/" + "BRF37::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;

	}

	public ModelAndView getBRF37View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF37> T1rep = new ArrayList<BRF37>();
		// Query<Object[]> qr;

		List<BRF37> T1Master = new ArrayList<BRF37>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF37 a where a.report_date = ?1 ", BRF37.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF37");
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

	/****
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView ARCHgetBRF037currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery(
						"select * from BRF37_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF37_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF37_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF37_ARCHIVENTITY> T1Master = new ArrayList<BRF37_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF37_ARCHIVENTITY a where a.report_date = ?1", BRF37_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for: " + reportId + "," + fromdate + "," + todate + "," + currency);

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
			String nre_flg = (String) a[49];

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

			BRF37_ARCHIVENTITY py = new BRF37_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg);
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

		mv.setViewName("RR" + "/" + "BRF037ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	/****** ARCHEVE VIEW ******/

	public ModelAndView getArchieveBRF037View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF37> T1rep = new ArrayList<BRF37>();

		List<BRF37> T1Master = new ArrayList<BRF37>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF37 a where a.report_date = ?1 ", BRF37.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("RR/BRF037ARCH");
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

	public String detailChanges37(BRF37_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF37_DETAIL_ENTITY> Brf37detail = BRF37_DetaiRep.findById(foracid);

			if (Brf37detail.isPresent()) {
				BRF37_DETAIL_ENTITY BRFdetail = Brf37detail.get();

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
					BRF37_DetaiRep.save(BRFdetail);

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

}
