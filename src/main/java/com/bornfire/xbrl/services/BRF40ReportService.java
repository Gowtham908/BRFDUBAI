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

import com.bornfire.xbrl.entities.BRBS.BRF208_Entity1;
import com.bornfire.xbrl.entities.BRBS.BRF208_Entity2;
import com.bornfire.xbrl.entities.BRBS.BRF40_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF40_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF40_DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF40_Entity1;
import com.bornfire.xbrl.entities.BRBS.BRF40_Entity2;
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
public class BRF40ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF40ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	BRF40_DetailRep brf40_DetailRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF40_Entity1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF40_Entity1 a").getSingleResult();
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

	public ModelAndView getBRF40View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<BRF40_Entity1> T1Master = new ArrayList<BRF40_Entity1>();
		List<BRF40_Entity2> T1Master1 = new ArrayList<BRF40_Entity2>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
		//T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF40_Entity1 a where a.report_date = ?1 ", BRF40_Entity1.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			T1Master1 = hs.createQuery("from BRF40_Entity2 a where a.report_date = ?1 ", BRF40_Entity2.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF40");
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
	/**
	 * @param reportId
	 * @param fromdate
	 * @param todate
	 * @param currency
	 * @param dtltype
	 * @param filetype
	 * @return
	 * @throws FileNotFoundException
	 * @throws JRException
	 * @throws SQLException
	 */
	public File getFileBRF40(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-040-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF40_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF40_Detail.jrxml");

						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF40.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF40.jrxml");
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
			} else {
				List<BRF40_Entity1> T1Master = new ArrayList<>();
				List<BRF40_Entity2> T1Master1 = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from  BRF40_Entity1 a where a.report_date = ?1 ", BRF40_Entity1.class)
							.setParameter(1, df.parse(todate)).getResultList();

					T1Master1 = hs.createQuery("from BRF40_Entity2 a where a.report_date = ?1 ", BRF40_Entity2.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-040-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					if (T1Master.size() == 1) {
						for (BRF40_Entity1 BRF40 : T1Master) {
							/// row11
							Row row = sheet.getRow(10);

							Cell cell = row.getCell(3);
							if (cell != null) {
								cell.setCellValue(BRF40.getR11_outstanding_balance() == null ? 0
										: BRF40.getR11_outstanding_balance().intValue());
							}
							Cell cell1 = row.getCell(7);
							if (cell1 != null) {
								cell1.setCellValue(BRF40.getR11_provision_suspense() == null ? 0
										: BRF40.getR11_provision_suspense().intValue());
							}
							Cell cell2 = row.getCell(8);
							if (cell2 != null) {
								cell2.setCellValue(BRF40.getR11_stage3_provision() == null ? 0
										: BRF40.getR11_stage3_provision().intValue());
							}
							/*Cell cell3 = row.getCell(9);
							if (cell3 != null) {
								cell3.setCellValue(BRF40.getR11_other_alloate() == null ? 0
										: BRF40.getR11_other_alloate().intValue());
							}*/
							Cell cell4 = row.getCell(11);
							if (cell4 != null) {
								cell4.setCellValue(BRF40.getR11_1_asset() == null ? 0
										: BRF40.getR11_1_asset().intValue());
							}
							Cell cell5 = row.getCell(12);
							if (cell5 != null) {
								cell5.setCellValue(BRF40.getR11_2_asset() == null ? 0
										: BRF40.getR11_2_asset().intValue());
							}
							Cell cell6 = row.getCell(13);
							if (cell6 != null) {
								cell6.setCellValue(BRF40.getR11_3a_asset() == null ? 0
										: BRF40.getR11_3a_asset().intValue());
							}
							Cell cell7 = row.getCell(14);
							if (cell7 != null) {
								cell7.setCellValue(BRF40.getR11_3b_asset() == null ? 0
										: BRF40.getR11_3b_asset().intValue());
							}
							Cell cell8 = row.getCell(15);
							if (cell8 != null) {
								cell8.setCellValue(
										BRF40.getR11_3c_asset() == null ? 0 
										: BRF40.getR11_3c_asset().intValue());
							}
							Cell cell9 = row.getCell(17);
							if (cell9 != null) {
								cell9.setCellValue(BRF40.getR11_1_provision() == null ? 0
										: BRF40.getR11_1_provision().intValue());
							}

							Cell cell10 = row.getCell(18);
							if (cell10 != null) {
								cell10.setCellValue(BRF40.getR11_2_provision() == null ? 0
										: BRF40.getR11_2_provision().intValue());
							}
							Cell cell11 = row.getCell(19);
							if (cell11 != null) {
								cell11.setCellValue(BRF40.getR11_3a_provision() == null ? 0
										: BRF40.getR11_3a_provision().intValue());
							}
							Cell cell12 = row.getCell(20);
							if (cell12 != null) {
								cell12.setCellValue(BRF40.getR11_3b_provision() == null ? 0
										: BRF40.getR11_3b_provision().intValue());
							}
							Cell cell13 = row.getCell(21);
							if (cell13 != null) {
								cell13.setCellValue(BRF40.getR11_3c_provision() == null ? 0
										: BRF40.getR11_3c_provision().intValue());
							}

							Cell cell14 = row.getCell(23);
							if (cell14 != null) {
								cell14.setCellValue(
										BRF40.getR11_current() == null ? 0 
										: BRF40.getR11_current().intValue());
							}

							Cell cell15 = row.getCell(24);
							if (cell15 != null) {
								cell15.setCellValue(
										BRF40.getR11_lessthan_30() == null ? 0 
										: BRF40.getR11_lessthan_30().intValue());
							}
							Cell cell16 = row.getCell(25);
							if (cell16 != null) {
								cell16.setCellValue(BRF40.getR11_exclusive_90days() == null ? 0
										: BRF40.getR11_exclusive_90days().intValue());
							}

							Cell cell17 = row.getCell(26);
							if (cell17 != null) {
								cell17.setCellValue(BRF40.getR11_exclusive_120days() == null ? 0
										: BRF40.getR11_exclusive_120days().intValue());
							}

							Cell cell18 = row.getCell(27);
							if (cell18 != null) {
								cell18.setCellValue(BRF40.getR11_exclusive_180days() == null ? 0
										: BRF40.getR11_exclusive_180days().intValue());
							}

							Cell cell19 = row.getCell(28);
							if (cell19 != null) {
								cell19.setCellValue(BRF40.getR11_exclusive_over_180days() == null ? 0
										: BRF40.getR11_exclusive_over_180days().intValue());
							}

							Cell cell20 = row.getCell(31);
							if (cell20 != null) {
								cell20.setCellValue(
										BRF40.getR11_new_stage3() == null ? 0 
										: BRF40.getR11_new_stage3().intValue());
							}
							Cell cell21 = row.getCell(32);
							if (cell21 != null) {
								cell21.setCellValue(BRF40.getR11_new_specific() == null ? 0
										: BRF40.getR11_new_specific().intValue());
							}
							/*Cell cell22 = row.getCell(33);
							if (cell22 != null) {
								cell22.setCellValue(
										BRF40.getR11_new_other() == null ? 0 
										: BRF40.getR11_new_other().intValue());
							}*/

							Cell cell23 = row.getCell(35);
							if (cell23 != null) {
								cell23.setCellValue(BRF40.getR11_performing_accounts() == null ? 0
										: BRF40.getR11_performing_accounts().intValue());
							}

							Cell cell24 = row.getCell(36);
							if (cell24 != null) {
								cell24.setCellValue(BRF40.getR11_non_performing_accounts() == null ? 0
										: BRF40.getR11_non_performing_accounts().intValue());
							}

							/// row12
							Row row1 = sheet.getRow(11);
							Cell R12cell = row1.getCell(3);
							if (R12cell != null) {
								R12cell.setCellValue(BRF40.getR12_outstanding_balance() == null ? 0
										: BRF40.getR12_outstanding_balance().intValue());
							}
							Cell R12cell1 = row1.getCell(7);
							if (R12cell1 != null) {
								R12cell1.setCellValue(BRF40.getR12_provision_suspense() == null ? 0
										: BRF40.getR12_provision_suspense().intValue());
							}
							Cell R12cell2 = row1.getCell(8);
							if (R12cell2 != null) {
								R12cell2.setCellValue(BRF40.getR12_stage3_provision() == null ? 0
										: BRF40.getR12_stage3_provision().intValue());
							}
							/*Cell R12cell3 = row1.getCell(9);
							if (R12cell3 != null) {
								R12cell3.setCellValue(BRF40.getR12_other_alloate() == null ? 0
										: BRF40.getR12_other_alloate().intValue());
							}*/
							Cell R12cell4 = row1.getCell(11);
							if (R12cell4 != null) {
								R12cell4.setCellValue(BRF40.getR12_1_asset() == null ? 0
										: BRF40.getR12_1_asset().intValue());
							}
							Cell R12cell5 = row1.getCell(12);
							if (R12cell5 != null) {
								R12cell5.setCellValue(BRF40.getR12_2_asset() == null ? 0
										: BRF40.getR12_2_asset().intValue());
							}
							Cell R12cell6 = row1.getCell(13);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF40.getR12_3a_asset() == null ? 0
										: BRF40.getR12_3a_asset().intValue());
							}
							Cell R12cell7 = row1.getCell(14);
							if (R12cell7 != null) {
								R12cell7.setCellValue(BRF40.getR12_3b_asset() == null ? 0
										: BRF40.getR12_3b_asset().intValue());
							}
							Cell R12cell8 = row1.getCell(15);
							if (R12cell8 != null) {
								R12cell8.setCellValue(
										BRF40.getR12_3c_asset() == null ? 0 : BRF40.getR12_3c_asset().intValue());
							}
							Cell R12cell9 = row1.getCell(17);
							if (R12cell9 != null) {
								R12cell9.setCellValue(BRF40.getR12_1_provision() == null ? 0
										: BRF40.getR12_1_provision().intValue());
							}

							Cell R12cell10 = row1.getCell(18);
							if (R12cell10 != null) {
								R12cell10.setCellValue(BRF40.getR12_2_provision() == null ? 0
										: BRF40.getR12_2_provision().intValue());
							}
							Cell R12cell11 = row1.getCell(19);
							if (R12cell11 != null) {
								R12cell11.setCellValue(BRF40.getR12_3a_provision() == null ? 0
										: BRF40.getR12_3a_provision().intValue());
							}
							Cell R12cell12 = row1.getCell(20);
							if (R12cell12 != null) {
								R12cell12.setCellValue(BRF40.getR12_3b_provision() == null ? 0
										: BRF40.getR12_3b_provision().intValue());
							}
							Cell R12cell13 = row1.getCell(21);
							if (R12cell13 != null) {
								R12cell13.setCellValue(BRF40.getR12_3c_provision() == null ? 0
										: BRF40.getR12_3c_provision().intValue());
							}

							Cell R12cell14 = row1.getCell(23);
							if (R12cell14 != null) {
								R12cell14.setCellValue(
										BRF40.getR12_current() == null ? 0 : BRF40.getR12_current().intValue());
							}

							Cell R12cell15 = row1.getCell(24);
							if (R12cell15 != null) {
								R12cell15.setCellValue(
										BRF40.getR12_lessthan_30() == null ? 0 : BRF40.getR12_lessthan_30().intValue());
							}
							Cell R12cell16 = row1.getCell(25);
							if (R12cell16 != null) {
								R12cell16.setCellValue(BRF40.getR12_exclusive_90days() == null ? 0
										: BRF40.getR12_exclusive_90days().intValue());
							}

							Cell R12cell17 = row1.getCell(26);
							if (R12cell17 != null) {
								R12cell17.setCellValue(BRF40.getR12_exclusive_120days() == null ? 0
										: BRF40.getR12_exclusive_120days().intValue());
							}

							Cell R12cell18 = row1.getCell(27);
							if (R12cell18 != null) {
								R12cell18.setCellValue(BRF40.getR12_exclusive_180days() == null ? 0
										: BRF40.getR12_exclusive_180days().intValue());
							}

							Cell R12cell19 = row1.getCell(28);
							if (R12cell19 != null) {
								R12cell19.setCellValue(BRF40.getR12_exclusive_over_180days() == null ? 0
										: BRF40.getR12_exclusive_over_180days().intValue());
							}

							Cell R12cell20 = row1.getCell(31);
							if (R12cell20 != null) {
								R12cell20.setCellValue(
										BRF40.getR12_new_stage3() == null ? 0 : BRF40.getR12_new_stage3().intValue());
							}
							Cell R12cell21 = row1.getCell(32);
							if (R12cell21 != null) {
								R12cell21.setCellValue(BRF40.getR12_new_specific() == null ? 0
										: BRF40.getR12_new_specific().intValue());
							}
							/*Cell R12cell22 = row1.getCell(33);
							if (R12cell22 != null) {
								R12cell22.setCellValue(
										BRF40.getR12_new_other() == null ? 0 : BRF40.getR12_new_other().intValue());
							}*/

							Cell R12cell23 = row1.getCell(35);
							if (R12cell23 != null) {
								R12cell23.setCellValue(BRF40.getR12_performing_accounts() == null ? 0
										: BRF40.getR12_performing_accounts().intValue());
							}

							Cell R12cell24 = row1.getCell(36);
							if (R12cell24 != null) {
								R12cell24.setCellValue(BRF40.getR12_non_performing_accounts() == null ? 0
										: BRF40.getR12_non_performing_accounts().intValue());
							}

							/// row22
							Row row2 = sheet.getRow(12);
							Cell R13cell = row2.getCell(3);
							if (R13cell != null) {
								R13cell.setCellValue(BRF40.getR13_outstanding_balance() == null ? 0
										: BRF40.getR13_outstanding_balance().intValue());
							}
							Cell R13cell1 = row2.getCell(7);
							if (R13cell1 != null) {
								R13cell1.setCellValue(BRF40.getR13_provision_suspense() == null ? 0
										: BRF40.getR13_provision_suspense().intValue());
							}
							Cell R13cell2 = row2.getCell(8);
							if (R13cell2 != null) {
								R13cell2.setCellValue(BRF40.getR13_stage3_provision() == null ? 0
										: BRF40.getR13_stage3_provision().intValue());
							}
							/*Cell R13cell3 = row2.getCell(9);
							if (R13cell3 != null) {
								R13cell3.setCellValue(BRF40.getR13_other_alloate() == null ? 0
										: BRF40.getR13_other_alloate().intValue());
							}*/
							Cell R13cell4 = row2.getCell(11);
							if (R13cell4 != null) {
								R13cell4.setCellValue(BRF40.getR13_1_asset() == null ? 0
										: BRF40.getR13_1_asset().intValue());
							}
							Cell R13cell5 = row2.getCell(12);
							if (R13cell5 != null) {
								R13cell5.setCellValue(BRF40.getR13_2_asset() == null ? 0
										: BRF40.getR13_2_asset().intValue());
							}
							Cell R13cell6 = row2.getCell(13);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF40.getR13_3a_asset() == null ? 0
										: BRF40.getR13_3a_asset().intValue());
							}
							Cell R13cell7 = row2.getCell(14);
							if (R13cell7 != null) {
								R13cell7.setCellValue(BRF40.getR13_3b_asset() == null ? 0
										: BRF40.getR13_3b_asset().intValue());
							}
							Cell R13cell8 = row2.getCell(15);
							if (R13cell8 != null) {
								R13cell8.setCellValue(
										BRF40.getR13_3c_asset() == null ? 0 : BRF40.getR13_3c_asset().intValue());
							}
							Cell R13cell9 = row2.getCell(17);
							if (R13cell9 != null) {
								R13cell9.setCellValue(BRF40.getR13_1_provision() == null ? 0
										: BRF40.getR13_1_provision().intValue());
							}

							Cell R13cell10 = row2.getCell(18);
							if (R13cell10 != null) {
								R13cell10.setCellValue(BRF40.getR13_2_provision() == null ? 0
										: BRF40.getR13_2_provision().intValue());
							}
							Cell R13cell11 = row2.getCell(19);
							if (R13cell11 != null) {
								R13cell11.setCellValue(BRF40.getR13_3a_provision() == null ? 0
										: BRF40.getR13_3a_provision().intValue());
							}
							Cell R13cell12 = row2.getCell(20);
							if (R13cell12 != null) {
								R13cell12.setCellValue(BRF40.getR13_3b_provision() == null ? 0
										: BRF40.getR13_3b_provision().intValue());
							}
							Cell R13cell13 = row2.getCell(21);
							if (R13cell13 != null) {
								R13cell13.setCellValue(BRF40.getR13_3c_provision() == null ? 0
										: BRF40.getR13_3c_provision().intValue());
							}

							Cell R13cell14 = row2.getCell(23);
							if (R13cell14 != null) {
								R13cell14.setCellValue(
										BRF40.getR13_current() == null ? 0 : BRF40.getR13_current().intValue());
							}

							Cell R13cell15 = row2.getCell(24);
							if (R13cell15 != null) {
								R13cell15.setCellValue(
										BRF40.getR13_lessthan_30() == null ? 0 : BRF40.getR13_lessthan_30().intValue());
							}
							Cell R13cell16 = row2.getCell(25);
							if (R13cell16 != null) {
								R13cell16.setCellValue(BRF40.getR13_exclusive_90days() == null ? 0
										: BRF40.getR13_exclusive_90days().intValue());
							}

							Cell R13cell17 = row2.getCell(26);
							if (R13cell17 != null) {
								R13cell17.setCellValue(BRF40.getR13_exclusive_120days() == null ? 0
										: BRF40.getR13_exclusive_120days().intValue());
							}

							Cell R13cell18 = row2.getCell(27);
							if (R13cell18 != null) {
								R13cell18.setCellValue(BRF40.getR13_exclusive_180days() == null ? 0
										: BRF40.getR13_exclusive_180days().intValue());
							}

							Cell R13cell19 = row2.getCell(28);
							if (R13cell19 != null) {
								R13cell19.setCellValue(BRF40.getR13_exclusive_over_180days() == null ? 0
										: BRF40.getR13_exclusive_over_180days().intValue());
							}

							Cell R13cell20 = row2.getCell(31);
							if (R13cell20 != null) {
								R13cell20.setCellValue(
										BRF40.getR13_new_stage3() == null ? 0 : BRF40.getR13_new_stage3().intValue());
							}
							Cell R13cell21 = row2.getCell(32);
							if (R13cell21 != null) {
								R13cell21.setCellValue(BRF40.getR13_new_specific() == null ? 0
										: BRF40.getR13_new_specific().intValue());
							}
							/*Cell R13cell22 = row2.getCell(33);
							if (R13cell22 != null) {
								R13cell22.setCellValue(
										BRF40.getR13_new_other() == null ? 0 : BRF40.getR13_new_other().intValue());
							}*/

							Cell R13cell23 = row2.getCell(35);
							if (R13cell23 != null) {
								R13cell23.setCellValue(BRF40.getR13_performing_accounts() == null ? 0
										: BRF40.getR13_performing_accounts().intValue());
							}

							Cell R13cell24 = row2.getCell(36);
							if (R13cell24 != null) {
								R13cell24.setCellValue(BRF40.getR13_non_performing_accounts() == null ? 0
										: BRF40.getR13_non_performing_accounts().intValue());
							}

							/// row14
							Row row3 = sheet.getRow(13);
							Cell R14cell = row3.getCell(3);
							if (R14cell != null) {
								R14cell.setCellValue(BRF40.getR14_outstanding_balance() == null ? 0
										: BRF40.getR14_outstanding_balance().intValue());
							}
							Cell R14cell1 = row3.getCell(7);
							if (R14cell1 != null) {
								R14cell1.setCellValue(BRF40.getR14_provision_suspense() == null ? 0
										: BRF40.getR14_provision_suspense().intValue());
							}
							Cell R14cell2 = row3.getCell(8);
							if (R14cell2 != null) {
								R14cell2.setCellValue(BRF40.getR14_stage3_provision() == null ? 0
										: BRF40.getR14_stage3_provision().intValue());
							}
							/*Cell R14cell3 = row3.getCell(9);
							if (R14cell3 != null) {
								R14cell3.setCellValue(BRF40.getR14_other_alloate() == null ? 0
										: BRF40.getR14_other_alloate().intValue());
							}*/
							Cell R14cell4 = row3.getCell(11);
							if (R14cell4 != null) {
								R14cell4.setCellValue(BRF40.getR14_1_asset() == null ? 0
										: BRF40.getR14_1_asset().intValue());
							}
							Cell R14cell5 = row3.getCell(12);
							if (R14cell5 != null) {
								R14cell5.setCellValue(BRF40.getR14_2_asset() == null ? 0
										: BRF40.getR14_2_asset().intValue());
							}
							Cell R14cell6 = row3.getCell(13);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF40.getR14_3a_asset() == null ? 0
										: BRF40.getR14_3a_asset().intValue());
							}
							Cell R14cell7 = row3.getCell(14);
							if (R14cell7 != null) {
								R14cell7.setCellValue(BRF40.getR14_3b_asset() == null ? 0
										: BRF40.getR14_3b_asset().intValue());
							}
							Cell R14cell8 = row3.getCell(15);
							if (R14cell8 != null) {
								R14cell8.setCellValue(
										BRF40.getR14_3c_asset() == null ? 0 : BRF40.getR14_3c_asset().intValue());
							}
							Cell R14cell9 = row3.getCell(17);
							if (R14cell9 != null) {
								R14cell9.setCellValue(BRF40.getR14_1_provision() == null ? 0
										: BRF40.getR14_1_provision().intValue());
							}

							Cell R14cell10 = row3.getCell(18);
							if (R14cell10 != null) {
								R14cell10.setCellValue(BRF40.getR14_2_provision() == null ? 0
										: BRF40.getR14_2_provision().intValue());
							}
							Cell R14cell11 = row3.getCell(19);
							if (R14cell11 != null) {
								R14cell11.setCellValue(BRF40.getR14_3a_provision() == null ? 0
										: BRF40.getR14_3a_provision().intValue());
							}
							Cell R14cell12 = row3.getCell(20);
							if (R14cell12 != null) {
								R14cell12.setCellValue(BRF40.getR14_3b_provision() == null ? 0
										: BRF40.getR14_3b_provision().intValue());
							}
							Cell R14cell13 = row3.getCell(21);
							if (R14cell13 != null) {
								R14cell13.setCellValue(BRF40.getR14_3c_provision() == null ? 0
										: BRF40.getR14_3c_provision().intValue());
							}

							Cell R14cell14 = row3.getCell(23);
							if (R14cell14 != null) {
								R14cell14.setCellValue(
										BRF40.getR14_current() == null ? 0 : BRF40.getR14_current().intValue());
							}

							Cell R14cell15 = row3.getCell(24);
							if (R14cell15 != null) {
								R14cell15.setCellValue(
										BRF40.getR14_lessthan_30() == null ? 0 : BRF40.getR14_lessthan_30().intValue());
							}
							Cell R14cell16 = row3.getCell(25);
							if (R14cell16 != null) {
								R14cell16.setCellValue(BRF40.getR14_exclusive_90days() == null ? 0
										: BRF40.getR14_exclusive_90days().intValue());
							}

							Cell R14cell17 = row3.getCell(26);
							if (R14cell17 != null) {
								R14cell17.setCellValue(BRF40.getR14_exclusive_120days() == null ? 0
										: BRF40.getR14_exclusive_120days().intValue());
							}

							Cell R14cell18 = row3.getCell(27);
							if (R14cell18 != null) {
								R14cell18.setCellValue(BRF40.getR14_exclusive_180days() == null ? 0
										: BRF40.getR14_exclusive_180days().intValue());
							}

							Cell R14cell19 = row3.getCell(28);
							if (R14cell19 != null) {
								R14cell19.setCellValue(BRF40.getR14_exclusive_over_180days() == null ? 0
										: BRF40.getR14_exclusive_over_180days().intValue());
							}

							Cell R14cell20 = row3.getCell(31);
							if (R14cell20 != null) {
								R14cell20.setCellValue(
										BRF40.getR14_new_stage3() == null ? 0 : BRF40.getR14_new_stage3().intValue());
							}
							Cell R14cell21 = row3.getCell(32);
							if (R14cell21 != null) {
								R14cell21.setCellValue(BRF40.getR14_new_specific() == null ? 0
										: BRF40.getR14_new_specific().intValue());
							}
							/*Cell R14cell22 = row3.getCell(33);
							if (R14cell22 != null) {
								R14cell22.setCellValue(
										BRF40.getR14_new_other() == null ? 0 : BRF40.getR14_new_other().intValue());
							}*/

							Cell R14cell23 = row3.getCell(35);
							if (R14cell23 != null) {
								R14cell23.setCellValue(BRF40.getR14_performing_accounts() == null ? 0
										: BRF40.getR14_performing_accounts().intValue());
							}

							Cell R14cell24 = row3.getCell(36);
							if (R14cell24 != null) {
								R14cell24.setCellValue(BRF40.getR14_non_performing_accounts() == null ? 0
										: BRF40.getR14_non_performing_accounts().intValue());
							}

							/// row15
							Row row4 = sheet.getRow(14);
							Cell R15cell = row4.getCell(3);
							if (R15cell != null) {
								R15cell.setCellValue(BRF40.getR15_outstanding_balance() == null ? 0
										: BRF40.getR15_outstanding_balance().intValue());
							}
							Cell R15cell1 = row4.getCell(7);
							if (R15cell1 != null) {
								R15cell1.setCellValue(BRF40.getR15_provision_suspense() == null ? 0
										: BRF40.getR15_provision_suspense().intValue());
							}
							Cell R15cell2 = row4.getCell(8);
							if (R15cell2 != null) {
								R15cell2.setCellValue(BRF40.getR15_stage3_provision() == null ? 0
										: BRF40.getR15_stage3_provision().intValue());
							}
							/*Cell R15cell3 = row4.getCell(9);
							if (R15cell3 != null) {
								R15cell3.setCellValue(BRF40.getR15_other_alloate() == null ? 0
										: BRF40.getR15_other_alloate().intValue());
							}*/
							Cell R15cell4 = row4.getCell(11);
							if (R15cell4 != null) {
								R15cell4.setCellValue(BRF40.getR15_1_asset() == null ? 0
										: BRF40.getR15_1_asset().intValue());
							}
							Cell R15cell5 = row4.getCell(12);
							if (R15cell5 != null) {
								R15cell5.setCellValue(BRF40.getR15_2_asset() == null ? 0
										: BRF40.getR15_2_asset().intValue());
							}
							Cell R15cell6 = row4.getCell(13);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF40.getR15_3a_asset() == null ? 0
										: BRF40.getR15_3a_asset().intValue());
							}
							Cell R15cell7 = row4.getCell(14);
							if (R15cell7 != null) {
								R15cell7.setCellValue(BRF40.getR15_3b_asset() == null ? 0
										: BRF40.getR15_3b_asset().intValue());
							}
							Cell R15cell8 = row4.getCell(15);
							if (R15cell8 != null) {
								R15cell8.setCellValue(
										BRF40.getR15_3c_asset() == null ? 0 : BRF40.getR15_3c_asset().intValue());
							}
							Cell R15cell9 = row4.getCell(17);
							if (R15cell9 != null) {
								R15cell9.setCellValue(BRF40.getR15_1_provision() == null ? 0
										: BRF40.getR15_1_provision().intValue());
							}

							Cell R15cell10 = row4.getCell(18);
							if (R15cell10 != null) {
								R15cell10.setCellValue(BRF40.getR15_2_provision() == null ? 0
										: BRF40.getR15_2_provision().intValue());
							}
							Cell R15cell11 = row4.getCell(19);
							if (R15cell11 != null) {
								R15cell11.setCellValue(BRF40.getR15_3a_provision() == null ? 0
										: BRF40.getR15_3a_provision().intValue());
							}
							Cell R15cell12 = row4.getCell(20);
							if (R15cell12 != null) {
								R15cell12.setCellValue(BRF40.getR15_3b_provision() == null ? 0
										: BRF40.getR15_3b_provision().intValue());
							}
							Cell R15cell13 = row4.getCell(21);
							if (R15cell13 != null) {
								R15cell13.setCellValue(BRF40.getR15_3c_provision() == null ? 0
										: BRF40.getR15_3c_provision().intValue());
							}

							Cell R15cell14 = row4.getCell(23);
							if (R15cell14 != null) {
								R15cell14.setCellValue(
										BRF40.getR15_current() == null ? 0 : BRF40.getR15_current().intValue());
							}

							Cell R15cell15 = row4.getCell(24);
							if (R15cell15 != null) {
								R15cell15.setCellValue(
										BRF40.getR15_lessthan_30() == null ? 0 : BRF40.getR15_lessthan_30().intValue());
							}
							Cell R15cell16 = row4.getCell(25);
							if (R15cell16 != null) {
								R15cell16.setCellValue(BRF40.getR15_exclusive_90days() == null ? 0
										: BRF40.getR15_exclusive_90days().intValue());
							}

							Cell R15cell17 = row4.getCell(26);
							if (R15cell17 != null) {
								R15cell17.setCellValue(BRF40.getR15_exclusive_120days() == null ? 0
										: BRF40.getR15_exclusive_120days().intValue());
							}

							Cell R15cell18 = row4.getCell(27);
							if (R15cell18 != null) {
								R15cell18.setCellValue(BRF40.getR15_exclusive_180days() == null ? 0
										: BRF40.getR15_exclusive_180days().intValue());
							}

							Cell R15cell19 = row4.getCell(28);
							if (R15cell19 != null) {
								R15cell19.setCellValue(BRF40.getR15_exclusive_over_180days() == null ? 0
										: BRF40.getR15_exclusive_over_180days().intValue());
							}

							Cell R15cell20 = row4.getCell(31);
							if (R15cell20 != null) {
								R15cell20.setCellValue(
										BRF40.getR15_new_stage3() == null ? 0 : BRF40.getR15_new_stage3().intValue());
							}
							Cell R15cell21 = row4.getCell(32);
							if (R15cell21 != null) {
								R15cell21.setCellValue(BRF40.getR15_new_specific() == null ? 0
										: BRF40.getR15_new_specific().intValue());
							}
							/*Cell R15cell22 = row4.getCell(33);
							if (R15cell22 != null) {
								R15cell22.setCellValue(
										BRF40.getR15_new_other() == null ? 0 : BRF40.getR15_new_other().intValue());
							}*/

							Cell R15cell23 = row4.getCell(35);
							if (R15cell23 != null) {
								R15cell23.setCellValue(BRF40.getR15_performing_accounts() == null ? 0
										: BRF40.getR15_performing_accounts().intValue());
							}

							Cell R15cell24 = row4.getCell(36);
							if (R15cell24 != null) {
								R15cell24.setCellValue(BRF40.getR15_non_performing_accounts() == null ? 0
										: BRF40.getR15_non_performing_accounts().intValue());
							}

							
							/// row16
							Row row5 = sheet.getRow(15);
							Cell R16cell = row5.getCell(3);
							if (R16cell != null) {
								R16cell.setCellValue(BRF40.getR16_outstanding_balance() == null ? 0
										: BRF40.getR16_outstanding_balance().intValue());
							}
							Cell R16cell1 = row5.getCell(7);
							if (R16cell1 != null) {
								R16cell1.setCellValue(BRF40.getR16_provision_suspense() == null ? 0
										: BRF40.getR16_provision_suspense().intValue());
							}
							Cell R16cell2 = row5.getCell(8);
							if (R16cell2 != null) {
								R16cell2.setCellValue(BRF40.getR16_stage3_provision() == null ? 0
										: BRF40.getR16_stage3_provision().intValue());
							}
							/*Cell R16cell3 = row5.getCell(9);
							if (R16cell3 != null) {
								R16cell3.setCellValue(BRF40.getR16_other_alloate() == null ? 0
										: BRF40.getR16_other_alloate().intValue());
							}*/
							Cell R16cell4 = row5.getCell(11);
							if (R16cell4 != null) {
								R16cell4.setCellValue(BRF40.getR16_1_asset() == null ? 0
										: BRF40.getR16_1_asset().intValue());
							}
							Cell R16cell5 = row5.getCell(12);
							if (R16cell5 != null) {
								R16cell5.setCellValue(BRF40.getR16_2_asset() == null ? 0
										: BRF40.getR16_2_asset().intValue());
							}
							Cell R16cell6 = row5.getCell(13);
							if (R16cell6 != null) {
								R16cell6.setCellValue(BRF40.getR16_3a_asset() == null ? 0
										: BRF40.getR16_3a_asset().intValue());
							}
							Cell R16cell7 = row5.getCell(14);
							if (R16cell7 != null) {
								R16cell7.setCellValue(BRF40.getR16_3b_asset() == null ? 0
										: BRF40.getR16_3b_asset().intValue());
							}
							Cell R16cell8 = row5.getCell(15);
							if (R16cell8 != null) {
								R16cell8.setCellValue(
										BRF40.getR16_3c_asset() == null ? 0 : BRF40.getR16_3c_asset().intValue());
							}
							Cell R16cell9 = row5.getCell(17);
							if (R16cell9 != null) {
								R16cell9.setCellValue(BRF40.getR16_1_provision() == null ? 0
										: BRF40.getR16_1_provision().intValue());
							}

							Cell R16cell10 = row5.getCell(18);
							if (R16cell10 != null) {
								R16cell10.setCellValue(BRF40.getR16_2_provision() == null ? 0
										: BRF40.getR16_2_provision().intValue());
							}
							Cell R16cell11 = row5.getCell(19);
							if (R16cell11 != null) {
								R16cell11.setCellValue(BRF40.getR16_3a_provision() == null ? 0
										: BRF40.getR16_3a_provision().intValue());
							}
							Cell R16cell12 = row5.getCell(20);
							if (R16cell12 != null) {
								R16cell12.setCellValue(BRF40.getR16_3b_provision() == null ? 0
										: BRF40.getR16_3b_provision().intValue());
							}
							Cell R16cell13 = row5.getCell(21);
							if (R16cell13 != null) {
								R16cell13.setCellValue(BRF40.getR16_3c_provision() == null ? 0
										: BRF40.getR16_3c_provision().intValue());
							}

							Cell R16cell14 = row5.getCell(23);
							if (R16cell14 != null) {
								R16cell14.setCellValue(
										BRF40.getR16_current() == null ? 0 : BRF40.getR16_current().intValue());
							}

							Cell R16cell15 = row5.getCell(24);
							if (R16cell15 != null) {
								R16cell15.setCellValue(
										BRF40.getR16_lessthan_30() == null ? 0 : BRF40.getR16_lessthan_30().intValue());
							}
							Cell R16cell16 = row5.getCell(25);
							if (R16cell16 != null) {
								R16cell16.setCellValue(BRF40.getR16_exclusive_90days() == null ? 0
										: BRF40.getR16_exclusive_90days().intValue());
							}

							Cell R16cell17 = row5.getCell(26);
							if (R16cell17 != null) {
								R16cell17.setCellValue(BRF40.getR16_exclusive_120days() == null ? 0
										: BRF40.getR16_exclusive_120days().intValue());
							}

							Cell R16cell18 = row5.getCell(27);
							if (R16cell18 != null) {
								R16cell18.setCellValue(BRF40.getR16_exclusive_180days() == null ? 0
										: BRF40.getR16_exclusive_180days().intValue());
							}

							Cell R16cell19 = row5.getCell(28);
							if (R16cell19 != null) {
								R16cell19.setCellValue(BRF40.getR16_exclusive_over_180days() == null ? 0
										: BRF40.getR16_exclusive_over_180days().intValue());
							}

							Cell R16cell20 = row5.getCell(31);
							if (R16cell20 != null) {
								R16cell20.setCellValue(
										BRF40.getR16_new_stage3() == null ? 0 : BRF40.getR16_new_stage3().intValue());
							}
							Cell R16cell21 = row5.getCell(32);
							if (R16cell21 != null) {
								R16cell21.setCellValue(BRF40.getR16_new_specific() == null ? 0
										: BRF40.getR16_new_specific().intValue());
							}
							/*Cell R16cell22 = row5.getCell(33);
							if (R16cell22 != null) {
								R16cell22.setCellValue(
										BRF40.getR16_new_other() == null ? 0 : BRF40.getR16_new_other().intValue());
							}*/

							Cell R16cell23 = row5.getCell(35);
							if (R16cell23 != null) {
								R16cell23.setCellValue(BRF40.getR16_performing_accounts() == null ? 0
										: BRF40.getR16_performing_accounts().intValue());
							}

							Cell R16cell24 = row5.getCell(36);
							if (R16cell24 != null) {
								R16cell24.setCellValue(BRF40.getR16_non_performing_accounts() == null ? 0
										: BRF40.getR16_non_performing_accounts().intValue());
							}

							/// row17
							Row row6 = sheet.getRow(16);
							Cell R17cell = row6.getCell(3);
							if (R17cell != null) {
								R17cell.setCellValue(BRF40.getR17_outstanding_balance() == null ? 0
										: BRF40.getR17_outstanding_balance().intValue());
							}
							Cell R17cell1 = row6.getCell(7);
							if (R17cell1 != null) {
								R17cell1.setCellValue(BRF40.getR17_provision_suspense() == null ? 0
										: BRF40.getR17_provision_suspense().intValue());
							}
							Cell R17cell2 = row6.getCell(8);
							if (R17cell2 != null) {
								R17cell2.setCellValue(BRF40.getR17_stage3_provision() == null ? 0
										: BRF40.getR17_stage3_provision().intValue());
							}
							/*Cell R17cell3 = row6.getCell(9);
							if (R17cell3 != null) {
								R17cell3.setCellValue(BRF40.getR17_other_alloate() == null ? 0
										: BRF40.getR17_other_alloate().intValue());
							}*/
							Cell R17cell4 = row6.getCell(11);
							if (R17cell4 != null) {
								R17cell4.setCellValue(BRF40.getR17_1_asset() == null ? 0
										: BRF40.getR17_1_asset().intValue());
							}
							Cell R17cell5 = row6.getCell(12);
							if (R17cell5 != null) {
								R17cell5.setCellValue(BRF40.getR17_2_asset() == null ? 0
										: BRF40.getR17_2_asset().intValue());
							}
							Cell R17cell6 = row6.getCell(13);
							if (R17cell6 != null) {
								R17cell6.setCellValue(BRF40.getR17_3a_asset() == null ? 0
										: BRF40.getR17_3a_asset().intValue());
							}
							Cell R17cell7 = row6.getCell(14);
							if (R17cell7 != null) {
								R17cell7.setCellValue(BRF40.getR17_3b_asset() == null ? 0
										: BRF40.getR17_3b_asset().intValue());
							}
							Cell R17cell8 = row6.getCell(15);
							if (R17cell8 != null) {
								R17cell8.setCellValue(
										BRF40.getR17_3c_asset() == null ? 0 : BRF40.getR17_3c_asset().intValue());
							}
							Cell R17cell9 = row6.getCell(17);
							if (R17cell9 != null) {
								R17cell9.setCellValue(BRF40.getR17_1_provision() == null ? 0
										: BRF40.getR17_1_provision().intValue());
							}

							Cell R17cell10 = row6.getCell(18);
							if (R17cell10 != null) {
								R17cell10.setCellValue(BRF40.getR17_2_provision() == null ? 0
										: BRF40.getR17_2_provision().intValue());
							}
							Cell R17cell11 = row6.getCell(19);
							if (R17cell11 != null) {
								R17cell11.setCellValue(BRF40.getR17_3a_provision() == null ? 0
										: BRF40.getR17_3a_provision().intValue());
							}
							Cell R17cell12 = row6.getCell(20);
							if (R17cell12 != null) {
								R17cell12.setCellValue(BRF40.getR17_3b_provision() == null ? 0
										: BRF40.getR17_3b_provision().intValue());
							}
							Cell R17cell13 = row6.getCell(21);
							if (R17cell13 != null) {
								R17cell13.setCellValue(BRF40.getR17_3c_provision() == null ? 0
										: BRF40.getR17_3c_provision().intValue());
							}

							Cell R17cell14 = row6.getCell(23);
							if (R17cell14 != null) {
								R17cell14.setCellValue(
										BRF40.getR17_current() == null ? 0 : BRF40.getR17_current().intValue());
							}

							Cell R17cell15 = row6.getCell(24);
							if (R17cell15 != null) {
								R17cell15.setCellValue(
										BRF40.getR17_lessthan_30() == null ? 0 : BRF40.getR17_lessthan_30().intValue());
							}
							Cell R17cell16 = row6.getCell(25);
							if (R17cell16 != null) {
								R17cell16.setCellValue(BRF40.getR17_exclusive_90days() == null ? 0
										: BRF40.getR17_exclusive_90days().intValue());
							}

							Cell R17cell17 = row6.getCell(26);
							if (R17cell17 != null) {
								R17cell17.setCellValue(BRF40.getR17_exclusive_120days() == null ? 0
										: BRF40.getR17_exclusive_120days().intValue());
							}

							Cell R17cell18 = row6.getCell(27);
							if (R17cell18 != null) {
								R17cell18.setCellValue(BRF40.getR17_exclusive_180days() == null ? 0
										: BRF40.getR17_exclusive_180days().intValue());
							}

							Cell R17cell19 = row6.getCell(28);
							if (R17cell19 != null) {
								R17cell19.setCellValue(BRF40.getR17_exclusive_over_180days() == null ? 0
										: BRF40.getR17_exclusive_over_180days().intValue());
							}

							Cell R17cell20 = row6.getCell(31);
							if (R17cell20 != null) {
								R17cell20.setCellValue(
										BRF40.getR17_new_stage3() == null ? 0 : BRF40.getR17_new_stage3().intValue());
							}
							Cell R17cell21 = row6.getCell(32);
							if (R17cell21 != null) {
								R17cell21.setCellValue(BRF40.getR17_new_specific() == null ? 0
										: BRF40.getR17_new_specific().intValue());
							}
							/*Cell R17cell22 = row6.getCell(33);
							if (R17cell22 != null) {
								R17cell22.setCellValue(
										BRF40.getR17_new_other() == null ? 0 : BRF40.getR17_new_other().intValue());
							}*/

							Cell R17cell23 = row6.getCell(35);
							if (R17cell23 != null) {
								R17cell23.setCellValue(BRF40.getR17_performing_accounts() == null ? 0
										: BRF40.getR17_performing_accounts().intValue());
							}

							Cell R17cell24 = row6.getCell(36);
							if (R17cell24 != null) {
								R17cell24.setCellValue(BRF40.getR17_non_performing_accounts() == null ? 0
										: BRF40.getR17_non_performing_accounts().intValue());
							}

							/// row18
							Row row7 = sheet.getRow(17);
							Cell R18cell = row7.getCell(3);
							if (R18cell != null) {
								R18cell.setCellValue(BRF40.getR18_outstanding_balance() == null ? 0
										: BRF40.getR18_outstanding_balance().intValue());
							}
							Cell R18cell1 = row7.getCell(7);
							if (R18cell1 != null) {
								R18cell1.setCellValue(BRF40.getR18_provision_suspense() == null ? 0
										: BRF40.getR18_provision_suspense().intValue());
							}
							Cell R18cell2 = row7.getCell(8);
							if (R18cell2 != null) {
								R18cell2.setCellValue(BRF40.getR18_stage3_provision() == null ? 0
										: BRF40.getR18_stage3_provision().intValue());
							}
							/*Cell R18cell3 = row7.getCell(9);
							if (R18cell3 != null) {
								R18cell3.setCellValue(BRF40.getR18_other_alloate() == null ? 0
										: BRF40.getR18_other_alloate().intValue());
							}*/
							Cell R18cell4 = row7.getCell(11);
							if (R18cell4 != null) {
								R18cell4.setCellValue(BRF40.getR18_1_asset() == null ? 0
										: BRF40.getR18_1_asset().intValue());
							}
							Cell R18cell5 = row7.getCell(12);
							if (R18cell5 != null) {
								R18cell5.setCellValue(BRF40.getR18_2_asset() == null ? 0
										: BRF40.getR18_2_asset().intValue());
							}
							Cell R18cell6 = row7.getCell(13);
							if (R18cell6 != null) {
								R18cell6.setCellValue(BRF40.getR18_3a_asset() == null ? 0
										: BRF40.getR18_3a_asset().intValue());
							}
							Cell R18cell7 = row7.getCell(14);
							if (R18cell7 != null) {
								R18cell7.setCellValue(BRF40.getR18_3b_asset() == null ? 0
										: BRF40.getR18_3b_asset().intValue());
							}
							Cell R18cell8 = row7.getCell(15);
							if (R18cell8 != null) {
								R18cell8.setCellValue(
										BRF40.getR18_3c_asset() == null ? 0 : BRF40.getR18_3c_asset().intValue());
							}
							Cell R18cell9 = row7.getCell(17);
							if (R18cell9 != null) {
								R18cell9.setCellValue(BRF40.getR18_1_provision() == null ? 0
										: BRF40.getR18_1_provision().intValue());
							}

							Cell R18cell10 = row7.getCell(18);
							if (R18cell10 != null) {
								R18cell10.setCellValue(BRF40.getR18_2_provision() == null ? 0
										: BRF40.getR18_2_provision().intValue());
							}
							Cell R18cell11 = row7.getCell(19);
							if (R18cell11 != null) {
								R18cell11.setCellValue(BRF40.getR18_3a_provision() == null ? 0
										: BRF40.getR18_3a_provision().intValue());
							}
							Cell R18cell12 = row7.getCell(20);
							if (R18cell12 != null) {
								R18cell12.setCellValue(BRF40.getR18_3b_provision() == null ? 0
										: BRF40.getR18_3b_provision().intValue());
							}
							Cell R18cell13 = row7.getCell(21);
							if (R18cell13 != null) {
								R18cell13.setCellValue(BRF40.getR18_3c_provision() == null ? 0
										: BRF40.getR18_3c_provision().intValue());
							}

							Cell R18cell14 = row7.getCell(23);
							if (R18cell14 != null) {
								R18cell14.setCellValue(
										BRF40.getR18_current() == null ? 0 : BRF40.getR18_current().intValue());
							}

							Cell R18cell15 = row7.getCell(24);
							if (R18cell15 != null) {
								R18cell15.setCellValue(
										BRF40.getR18_lessthan_30() == null ? 0 : BRF40.getR18_lessthan_30().intValue());
							}
							Cell R18cell16 = row7.getCell(25);
							if (R18cell16 != null) {
								R18cell16.setCellValue(BRF40.getR18_exclusive_90days() == null ? 0
										: BRF40.getR18_exclusive_90days().intValue());
							}

							Cell R18cell17 = row7.getCell(26);
							if (R18cell17 != null) {
								R18cell17.setCellValue(BRF40.getR18_exclusive_120days() == null ? 0
										: BRF40.getR18_exclusive_120days().intValue());
							}

							Cell R18cell18 = row7.getCell(27);
							if (R18cell18 != null) {
								R18cell18.setCellValue(BRF40.getR18_exclusive_180days() == null ? 0
										: BRF40.getR18_exclusive_180days().intValue());
							}

							Cell R18cell19 = row7.getCell(28);
							if (R18cell19 != null) {
								R18cell19.setCellValue(BRF40.getR18_exclusive_over_180days() == null ? 0
										: BRF40.getR18_exclusive_over_180days().intValue());
							}

							Cell R18cell20 = row7.getCell(31);
							if (R18cell20 != null) {
								R18cell20.setCellValue(
										BRF40.getR18_new_stage3() == null ? 0 : BRF40.getR18_new_stage3().intValue());
							}
							Cell R18cell21 = row7.getCell(32);
							if (R18cell21 != null) {
								R18cell21.setCellValue(BRF40.getR18_new_specific() == null ? 0
										: BRF40.getR18_new_specific().intValue());
							}
							/*Cell R18cell22 = row7.getCell(33);
							if (R18cell22 != null) {
								R18cell22.setCellValue(
										BRF40.getR18_new_other() == null ? 0 : BRF40.getR18_new_other().intValue());
							}*/

							Cell R18cell23 = row7.getCell(35);
							if (R18cell23 != null) {
								R18cell23.setCellValue(BRF40.getR18_performing_accounts() == null ? 0
										: BRF40.getR18_performing_accounts().intValue());
							}

							Cell R18cell24 = row7.getCell(36);
							if (R18cell24 != null) {
								R18cell24.setCellValue(BRF40.getR18_non_performing_accounts() == null ? 0
										: BRF40.getR18_non_performing_accounts().intValue());
							}
							/// row19
							Row row8 = sheet.getRow(18);
							Cell R19cell = row8.getCell(3);
							if (R19cell != null) {
								R19cell.setCellValue(BRF40.getR19_outstanding_balance() == null ? 0
										: BRF40.getR19_outstanding_balance().intValue());
							}
							Cell R19cell1 = row8.getCell(7);
							if (R19cell1 != null) {
								R19cell1.setCellValue(BRF40.getR19_provision_suspense() == null ? 0
										: BRF40.getR19_provision_suspense().intValue());
							}
							Cell R19cell2 = row8.getCell(8);
							if (R19cell2 != null) {
								R19cell2.setCellValue(BRF40.getR19_stage3_provision() == null ? 0
										: BRF40.getR19_stage3_provision().intValue());
							}
							/*Cell R19cell3 = row8.getCell(9);
							if (R19cell3 != null) {
								R19cell3.setCellValue(BRF40.getR19_other_alloate() == null ? 0
										: BRF40.getR19_other_alloate().intValue());
							}*/
							Cell R19cell4 = row8.getCell(11);
							if (R19cell4 != null) {
								R19cell4.setCellValue(BRF40.getR19_1_asset() == null ? 0
										: BRF40.getR19_1_asset().intValue());
							}
							Cell R19cell5 = row8.getCell(12);
							if (R19cell5 != null) {
								R19cell5.setCellValue(BRF40.getR19_2_asset() == null ? 0
										: BRF40.getR19_2_asset().intValue());
							}
							Cell R19cell6 = row8.getCell(13);
							if (R19cell6 != null) {
								R19cell6.setCellValue(BRF40.getR19_3a_asset() == null ? 0
										: BRF40.getR19_3a_asset().intValue());
							}
							Cell R19cell7 = row8.getCell(14);
							if (R19cell7 != null) {
								R19cell7.setCellValue(BRF40.getR19_3b_asset() == null ? 0
										: BRF40.getR19_3b_asset().intValue());
							}
							Cell R19cell8 = row8.getCell(15);
							if (R19cell8 != null) {
								R19cell8.setCellValue(
										BRF40.getR19_3c_asset() == null ? 0 : BRF40.getR19_3c_asset().intValue());
							}
							Cell R19cell9 = row8.getCell(17);
							if (R19cell9 != null) {
								R19cell9.setCellValue(BRF40.getR19_1_provision() == null ? 0
										: BRF40.getR19_1_provision().intValue());
							}

							Cell R19cell10 = row8.getCell(18);
							if (R19cell10 != null) {
								R19cell10.setCellValue(BRF40.getR19_2_provision() == null ? 0
										: BRF40.getR19_2_provision().intValue());
							}
							Cell R19cell11 = row8.getCell(19);
							if (R19cell11 != null) {
								R19cell11.setCellValue(BRF40.getR19_3a_provision() == null ? 0
										: BRF40.getR19_3a_provision().intValue());
							}
							Cell R19cell12 = row8.getCell(20);
							if (R19cell12 != null) {
								R19cell12.setCellValue(BRF40.getR19_3b_provision() == null ? 0
										: BRF40.getR19_3b_provision().intValue());
							}
							Cell R19cell13 = row8.getCell(21);
							if (R19cell13 != null) {
								R19cell13.setCellValue(BRF40.getR19_3c_provision() == null ? 0
										: BRF40.getR19_3c_provision().intValue());
							}

							Cell R19cell14 = row8.getCell(23);
							if (R19cell14 != null) {
								R19cell14.setCellValue(
										BRF40.getR19_current() == null ? 0 : BRF40.getR19_current().intValue());
							}

							Cell R19cell15 = row8.getCell(24);
							if (R19cell15 != null) {
								R19cell15.setCellValue(
										BRF40.getR19_lessthan_30() == null ? 0 : BRF40.getR19_lessthan_30().intValue());
							}
							Cell R19cell16 = row8.getCell(25);
							if (R19cell16 != null) {
								R19cell16.setCellValue(BRF40.getR19_exclusive_90days() == null ? 0
										: BRF40.getR19_exclusive_90days().intValue());
							}

							Cell R19cell17 = row8.getCell(26);
							if (R19cell17 != null) {
								R19cell17.setCellValue(BRF40.getR19_exclusive_120days() == null ? 0
										: BRF40.getR19_exclusive_120days().intValue());
							}

							Cell R19cell18 = row8.getCell(27);
							if (R19cell18 != null) {
								R19cell18.setCellValue(BRF40.getR19_exclusive_180days() == null ? 0
										: BRF40.getR19_exclusive_180days().intValue());
							}

							Cell R19cell19 = row8.getCell(28);
							if (R19cell19 != null) {
								R19cell19.setCellValue(BRF40.getR19_exclusive_over_180days() == null ? 0
										: BRF40.getR19_exclusive_over_180days().intValue());
							}

							Cell R19cell20 = row8.getCell(31);
							if (R19cell20 != null) {
								R19cell20.setCellValue(
										BRF40.getR19_new_stage3() == null ? 0 : BRF40.getR19_new_stage3().intValue());
							}
							Cell R19cell21 = row8.getCell(32);
							if (R19cell21 != null) {
								R19cell21.setCellValue(BRF40.getR19_new_specific() == null ? 0
										: BRF40.getR19_new_specific().intValue());
							}
							/*Cell R19cell22 = row8.getCell(33);
							if (R19cell22 != null) {
								R19cell22.setCellValue(
										BRF40.getR19_new_other() == null ? 0 : BRF40.getR19_new_other().intValue());
							}*/

							Cell R19cell23 = row8.getCell(35);
							if (R19cell23 != null) {
								R19cell23.setCellValue(BRF40.getR19_performing_accounts() == null ? 0
										: BRF40.getR19_performing_accounts().intValue());
							}

							Cell R19cell24 = row8.getCell(36);
							if (R19cell24 != null) {
								R19cell24.setCellValue(BRF40.getR19_non_performing_accounts() == null ? 0
										: BRF40.getR19_non_performing_accounts().intValue());
							}
							/// row20
							Row row9= sheet.getRow(19);
							Cell R20cell = row9.getCell(3);
							if (R20cell != null) {
								R20cell.setCellValue(BRF40.getR20_outstanding_balance() == null ? 0
										: BRF40.getR20_outstanding_balance().intValue());
							}
							Cell R20cell1 = row9.getCell(7);
							if (R20cell1 != null) {
								R20cell1.setCellValue(BRF40.getR20_provision_suspense() == null ? 0
										: BRF40.getR20_provision_suspense().intValue());
							}
							Cell R20cell2 = row9.getCell(8);
							if (R20cell2 != null) {
								R20cell2.setCellValue(BRF40.getR20_stage3_provision() == null ? 0
										: BRF40.getR20_stage3_provision().intValue());
							}
							/*Cell R20cell3 = row9.getCell(9);
							if (R20cell3 != null) {
								R20cell3.setCellValue(BRF40.getR20_other_alloate() == null ? 0
										: BRF40.getR20_other_alloate().intValue());
							}*/
							Cell R20cell4 = row9.getCell(11);
							if (R20cell4 != null) {
								R20cell4.setCellValue(BRF40.getR20_1_asset() == null ? 0
										: BRF40.getR20_1_asset().intValue());
							}
							Cell R20cell5 = row9.getCell(12);
							if (R20cell5 != null) {
								R20cell5.setCellValue(BRF40.getR20_2_asset() == null ? 0
										: BRF40.getR20_2_asset().intValue());
							}
							Cell R20cell6 = row9.getCell(13);
							if (R20cell6 != null) {
								R20cell6.setCellValue(BRF40.getR20_3a_asset() == null ? 0
										: BRF40.getR20_3a_asset().intValue());
							}
							Cell R20cell7 = row9.getCell(14);
							if (R20cell7 != null) {
								R20cell7.setCellValue(BRF40.getR20_3b_asset() == null ? 0
										: BRF40.getR20_3b_asset().intValue());
							}
							Cell R20cell8 = row9.getCell(15);
							if (R20cell8 != null) {
								R20cell8.setCellValue(
										BRF40.getR20_3c_asset() == null ? 0 : BRF40.getR20_3c_asset().intValue());
							}
							Cell R20cell9 = row9.getCell(17);
							if (R20cell9 != null) {
								R20cell9.setCellValue(BRF40.getR20_1_provision() == null ? 0
										: BRF40.getR20_1_provision().intValue());
							}

							Cell R20cell10 = row9.getCell(18);
							if (R20cell10 != null) {
								R20cell10.setCellValue(BRF40.getR20_2_provision() == null ? 0
										: BRF40.getR20_2_provision().intValue());
							}
							Cell R20cell11 = row9.getCell(19);
							if (R20cell11 != null) {
								R20cell11.setCellValue(BRF40.getR20_3a_provision() == null ? 0
										: BRF40.getR20_3a_provision().intValue());
							}
							Cell R20cell12 = row9.getCell(20);
							if (R20cell12 != null) {
								R20cell12.setCellValue(BRF40.getR20_3b_provision() == null ? 0
										: BRF40.getR20_3b_provision().intValue());
							}
							Cell R20cell13 = row9.getCell(21);
							if (R20cell13 != null) {
								R20cell13.setCellValue(BRF40.getR20_3c_provision() == null ? 0
										: BRF40.getR20_3c_provision().intValue());
							}

							Cell R20cell14 = row9.getCell(23);
							if (R20cell14 != null) {
								R20cell14.setCellValue(
										BRF40.getR20_current() == null ? 0 : BRF40.getR20_current().intValue());
							}

							Cell R20cell15 = row9.getCell(24);
							if (R20cell15 != null) {
								R20cell15.setCellValue(
										BRF40.getR20_lessthan_30() == null ? 0 : BRF40.getR20_lessthan_30().intValue());
							}
							Cell R20cell16 = row9.getCell(25);
							if (R20cell16 != null) {
								R20cell16.setCellValue(BRF40.getR20_exclusive_90days() == null ? 0
										: BRF40.getR20_exclusive_90days().intValue());
							}

							Cell R20cell17 = row9.getCell(26);
							if (R20cell17 != null) {
								R20cell17.setCellValue(BRF40.getR20_exclusive_120days() == null ? 0
										: BRF40.getR20_exclusive_120days().intValue());
							}

							Cell R20cell18 = row9.getCell(27);
							if (R20cell18 != null) {
								R20cell18.setCellValue(BRF40.getR20_exclusive_180days() == null ? 0
										: BRF40.getR20_exclusive_180days().intValue());
							}

							Cell R20cell19 = row9.getCell(28);
							if (R20cell19 != null) {
								R20cell19.setCellValue(BRF40.getR20_exclusive_over_180days() == null ? 0
										: BRF40.getR20_exclusive_over_180days().intValue());
							}

							Cell R20cell20 = row9.getCell(31);
							if (R20cell20 != null) {
								R20cell20.setCellValue(
										BRF40.getR20_new_stage3() == null ? 0 : BRF40.getR20_new_stage3().intValue());
							}
							Cell R20cell21 = row9.getCell(32);
							if (R20cell21 != null) {
								R20cell21.setCellValue(BRF40.getR20_new_specific() == null ? 0
										: BRF40.getR20_new_specific().intValue());
							}
							/*Cell R20cell22 = row9.getCell(33);
							if (R20cell22 != null) {
								R20cell22.setCellValue(
										BRF40.getR20_new_other() == null ? 0 : BRF40.getR20_new_other().intValue());
							}*/

							Cell R20cell23 = row9.getCell(35);
							if (R20cell23 != null) {
								R20cell23.setCellValue(BRF40.getR20_performing_accounts() == null ? 0
										: BRF40.getR20_performing_accounts().intValue());
							}

							Cell R20cell24 = row9.getCell(36);
							if (R20cell24 != null) {
								R20cell24.setCellValue(BRF40.getR20_non_performing_accounts() == null ? 0
										: BRF40.getR20_non_performing_accounts().intValue());
							}

							/// row21
							Row row10= sheet.getRow(20);
							Cell R21cell = row10.getCell(3);
							if (R21cell != null) {
								R21cell.setCellValue(BRF40.getR21_outstanding_balance() == null ? 0
										: BRF40.getR21_outstanding_balance().intValue());
							}
							Cell R21cell1 = row10.getCell(7);
							if (R21cell1 != null) {
								R21cell1.setCellValue(BRF40.getR21_provision_suspense() == null ? 0
										: BRF40.getR21_provision_suspense().intValue());
							}
							Cell R21cell2 = row10.getCell(8);
							if (R21cell2 != null) {
								R21cell2.setCellValue(BRF40.getR21_stage3_provision() == null ? 0
										: BRF40.getR21_stage3_provision().intValue());
							}
							/*Cell R21cell3 = row10.getCell(9);
							if (R21cell3 != null) {
								R21cell3.setCellValue(BRF40.getR21_other_alloate() == null ? 0
										: BRF40.getR21_other_alloate().intValue());
							}*/
							Cell R21cell4 = row10.getCell(11);
							if (R21cell4 != null) {
								R21cell4.setCellValue(BRF40.getR21_1_asset() == null ? 0
										: BRF40.getR21_1_asset().intValue());
							}
							Cell R21cell5 = row10.getCell(12);
							if (R21cell5 != null) {
								R21cell5.setCellValue(BRF40.getR21_2_asset() == null ? 0
										: BRF40.getR21_2_asset().intValue());
							}
							Cell R21cell6 = row10.getCell(13);
							if (R21cell6 != null) {
								R21cell6.setCellValue(BRF40.getR21_3a_asset() == null ? 0
										: BRF40.getR21_3a_asset().intValue());
							}
							Cell R21cell7 = row10.getCell(14);
							if (R21cell7 != null) {
								R21cell7.setCellValue(BRF40.getR21_3b_asset() == null ? 0
										: BRF40.getR21_3b_asset().intValue());
							}
							Cell R21cell8 = row10.getCell(15);
							if (R21cell8 != null) {
								R21cell8.setCellValue(
										BRF40.getR21_3c_asset() == null ? 0 : BRF40.getR21_3c_asset().intValue());
							}
							Cell R21cell9 = row10.getCell(17);
							if (R21cell9 != null) {
								R21cell9.setCellValue(BRF40.getR21_1_provision() == null ? 0
										: BRF40.getR21_1_provision().intValue());
							}

							Cell R21cell10 = row10.getCell(18);
							if (R21cell10 != null) {
								R21cell10.setCellValue(BRF40.getR21_2_provision() == null ? 0
										: BRF40.getR21_2_provision().intValue());
							}
							Cell R21cell11 = row10.getCell(19);
							if (R21cell11 != null) {
								R21cell11.setCellValue(BRF40.getR21_3a_provision() == null ? 0
										: BRF40.getR21_3a_provision().intValue());
							}
							Cell R21cell12 = row10.getCell(20);
							if (R21cell12 != null) {
								R21cell12.setCellValue(BRF40.getR21_3b_provision() == null ? 0
										: BRF40.getR21_3b_provision().intValue());
							}
							Cell R21cell13 = row10.getCell(21);
							if (R21cell13 != null) {
								R21cell13.setCellValue(BRF40.getR21_3c_provision() == null ? 0
										: BRF40.getR21_3c_provision().intValue());
							}

							Cell R21cell14 = row10.getCell(23);
							if (R21cell14 != null) {
								R21cell14.setCellValue(
										BRF40.getR21_current() == null ? 0 : BRF40.getR21_current().intValue());
							}

							Cell R21cell15 = row10.getCell(24);
							if (R21cell15 != null) {
								R21cell15.setCellValue(
										BRF40.getR21_lessthan_30() == null ? 0 : BRF40.getR21_lessthan_30().intValue());
							}
							Cell R21cell16 = row10.getCell(25);
							if (R21cell16 != null) {
								R21cell16.setCellValue(BRF40.getR21_exclusive_90days() == null ? 0
										: BRF40.getR21_exclusive_90days().intValue());
							}

							Cell R21cell17 = row10.getCell(26);
							if (R21cell17 != null) {
								R21cell17.setCellValue(BRF40.getR21_exclusive_120days() == null ? 0
										: BRF40.getR21_exclusive_120days().intValue());
							}

							Cell R21cell18 = row10.getCell(27);
							if (R21cell18 != null) {
								R21cell18.setCellValue(BRF40.getR21_exclusive_180days() == null ? 0
										: BRF40.getR21_exclusive_180days().intValue());
							}

							Cell R21cell19 = row10.getCell(28);
							if (R21cell19 != null) {
								R21cell19.setCellValue(BRF40.getR21_exclusive_over_180days() == null ? 0
										: BRF40.getR21_exclusive_over_180days().intValue());
							}

							Cell R21cell20 = row10.getCell(31);
							if (R21cell20 != null) {
								R21cell20.setCellValue(
										BRF40.getR21_new_stage3() == null ? 0 : BRF40.getR21_new_stage3().intValue());
							}
							Cell R21cell21 = row10.getCell(32);
							if (R21cell21 != null) {
								R21cell21.setCellValue(BRF40.getR21_new_specific() == null ? 0
										: BRF40.getR21_new_specific().intValue());
							}
							/*Cell R21cell22 = row10.getCell(33);
							if (R21cell22 != null) {
								R21cell22.setCellValue(
										BRF40.getR21_new_other() == null ? 0 : BRF40.getR21_new_other().intValue());
							}*/

							Cell R21cell23 = row10.getCell(35);
							if (R21cell23 != null) {
								R21cell23.setCellValue(BRF40.getR21_performing_accounts() == null ? 0
										: BRF40.getR21_performing_accounts().intValue());
							}

							Cell R21cell24 = row10.getCell(36);
							if (R21cell24 != null) {
								R21cell24.setCellValue(BRF40.getR21_non_performing_accounts() == null ? 0
										: BRF40.getR21_non_performing_accounts().intValue());
							}

							
							/// row24
							Row row11= sheet.getRow(23);
							
							/*Cell R24cell3 = row11.getCell(9);
							if (R24cell3 != null) {
								R24cell3.setCellValue(BRF40.getR24_other_alloate() == null ? 0
										: BRF40.getR24_other_alloate().intValue());
							}*/
							Cell R24cell4 = row11.getCell(11);
							if (R24cell4 != null) {
								R24cell4.setCellValue(BRF40.getR24_1_asset() == null ? 0
										: BRF40.getR24_1_asset().intValue());
							}
							Cell R24cell5 = row11.getCell(12);
							if (R24cell5 != null) {
								R24cell5.setCellValue(BRF40.getR24_2_asset() == null ? 0
										: BRF40.getR24_2_asset().intValue());
							}
							Cell R24cell6 = row11.getCell(13);
							if (R24cell6 != null) {
								R24cell6.setCellValue(BRF40.getR24_3a_asset() == null ? 0
										: BRF40.getR24_3a_asset().intValue());
							}
							Cell R24cell7 = row11.getCell(14);
							if (R24cell7 != null) {
								R24cell7.setCellValue(BRF40.getR24_3b_asset() == null ? 0
										: BRF40.getR24_3b_asset().intValue());
							}
							Cell R24cell8 = row11.getCell(15);
							if (R24cell8 != null) {
								R24cell8.setCellValue(
										BRF40.getR24_3c_asset() == null ? 0 
										: BRF40.getR24_3c_asset().intValue());
							}
														Cell R24cell14 = row11.getCell(23);
							if (R24cell14 != null) {
								R24cell14.setCellValue(
										BRF40.getR24_current() == null ? 0 
												: BRF40.getR24_current().intValue());
							}

							Cell R24cell15 = row11.getCell(24);
							if (R24cell15 != null) {
								R24cell15.setCellValue(
										BRF40.getR24_lessthan_30() == null ? 0 : BRF40.getR24_lessthan_30().intValue());
							}
							Cell R24cell16 = row11.getCell(25);
							if (R24cell16 != null) {
								R24cell16.setCellValue(BRF40.getR24_exclusive_90days() == null ? 0
										: BRF40.getR24_exclusive_90days().intValue());
							}

							Cell R24cell17 = row11.getCell(26);
							if (R24cell17 != null) {
								R24cell17.setCellValue(BRF40.getR24_exclusive_120days() == null ? 0
										: BRF40.getR24_exclusive_120days().intValue());
							}

							Cell R24cell18 = row11.getCell(27);
							if (R24cell18 != null) {
								R24cell18.setCellValue(BRF40.getR24_exclusive_180days() == null ? 0
										: BRF40.getR24_exclusive_180days().intValue());
							}

							Cell R24cell19 = row11.getCell(28);
							if (R24cell19 != null) {
								R24cell19.setCellValue(BRF40.getR24_exclusive_over_180days() == null ? 0
										: BRF40.getR24_exclusive_over_180days().intValue());
							}

							Cell R24cell20 = row11.getCell(31);
							if (R24cell20 != null) {
								R24cell20.setCellValue(
										BRF40.getR24_new_stage3() == null ? 0 : BRF40.getR24_new_stage3().intValue());
							}
							Cell R24cell21 = row11.getCell(32);
							if (R24cell21 != null) {
								R24cell21.setCellValue(BRF40.getR24_new_specific() == null ? 0
										: BRF40.getR24_new_specific().intValue());
							}
							/*Cell R24cell22 = row11.getCell(33);
							if (R24cell22 != null) {
								R24cell22.setCellValue(
										BRF40.getR24_new_other() == null ? 0 : BRF40.getR24_new_other().intValue());
							}*/

							Cell R24cell23 = row11.getCell(35);
							if (R24cell23 != null) {
								R24cell23.setCellValue(BRF40.getR24_performing_accounts() == null ? 0
										: BRF40.getR24_performing_accounts().intValue());
							}

							Cell R24cell24 = row11.getCell(36);
							if (R24cell24 != null) {
								R24cell24.setCellValue(BRF40.getR24_non_performing_accounts() == null ? 0
										: BRF40.getR24_non_performing_accounts().intValue());
							}

							/// row26
							Row row12= sheet.getRow(25);
							Cell R26cell = row12.getCell(3);
							if (R26cell != null) {
								R26cell.setCellValue(BRF40.getR26_outstanding_balance() == null ? 0
										: BRF40.getR26_outstanding_balance().intValue());
							}
							Cell R26cell1 = row12.getCell(7);
							if (R26cell1 != null) {
								R26cell1.setCellValue(BRF40.getR26_provision_suspense() == null ? 0
										: BRF40.getR26_provision_suspense().intValue());
							}
							Cell R26cell2 = row12.getCell(8);
							if (R26cell2 != null) {
								R26cell2.setCellValue(BRF40.getR26_stage3_provision() == null ? 0
										: BRF40.getR26_stage3_provision().intValue());
							}
							/*Cell R26cell3 = row12.getCell(9);
							if (R26cell3 != null) {
								R26cell3.setCellValue(BRF40.getR26_other_alloate() == null ? 0
										: BRF40.getR26_other_alloate().intValue());
							}*/
							Cell R26cell4 = row12.getCell(11);
							if (R26cell4 != null) {
								R26cell4.setCellValue(BRF40.getR26_1_asset() == null ? 0
										: BRF40.getR26_1_asset().intValue());
							}
							Cell R26cell5 = row12.getCell(12);
							if (R26cell5 != null) {
								R26cell5.setCellValue(BRF40.getR26_2_asset() == null ? 0
										: BRF40.getR26_2_asset().intValue());
							}
							Cell R26cell6 = row12.getCell(13);
							if (R26cell6 != null) {
								R26cell6.setCellValue(BRF40.getR26_3a_asset() == null ? 0
										: BRF40.getR26_3a_asset().intValue());
							}
							Cell R26cell7 = row12.getCell(14);
							if (R26cell7 != null) {
								R26cell7.setCellValue(BRF40.getR26_3b_asset() == null ? 0
										: BRF40.getR26_3b_asset().intValue());
							}
							Cell R26cell8 = row12.getCell(15);
							if (R26cell8 != null) {
								R26cell8.setCellValue(
										BRF40.getR26_3c_asset() == null ? 0 : BRF40.getR26_3c_asset().intValue());
							}
							Cell R26cell9 = row12.getCell(17);
							if (R26cell9 != null) {
								R26cell9.setCellValue(BRF40.getR26_1_provision() == null ? 0
										: BRF40.getR26_1_provision().intValue());
							}

							Cell R26cell10 = row12.getCell(18);
							if (R26cell10 != null) {
								R26cell10.setCellValue(BRF40.getR26_2_provision() == null ? 0
										: BRF40.getR26_2_provision().intValue());
							}
							Cell R26cell11 = row12.getCell(19);
							if (R26cell11 != null) {
								R26cell11.setCellValue(BRF40.getR26_3a_provision() == null ? 0
										: BRF40.getR26_3a_provision().intValue());
							}
							Cell R26cell12 = row12.getCell(20);
							if (R26cell12 != null) {
								R26cell12.setCellValue(BRF40.getR26_3b_provision() == null ? 0
										: BRF40.getR26_3b_provision().intValue());
							}
							Cell R26cell13 = row12.getCell(21);
							if (R26cell13 != null) {
								R26cell13.setCellValue(BRF40.getR26_3c_provision() == null ? 0
										: BRF40.getR26_3c_provision().intValue());
							}

							Cell R26cell14 = row12.getCell(23);
							if (R26cell14 != null) {
								R26cell14.setCellValue(
										BRF40.getR26_current() == null ? 0 : BRF40.getR26_current().intValue());
							}

							Cell R26cell15 = row12.getCell(24);
							if (R26cell15 != null) {
								R26cell15.setCellValue(
										BRF40.getR26_lessthan_30() == null ? 0 : BRF40.getR26_lessthan_30().intValue());
							}
							Cell R26cell16 = row12.getCell(25);
							if (R26cell16 != null) {
								R26cell16.setCellValue(BRF40.getR26_exclusive_90days() == null ? 0
										: BRF40.getR26_exclusive_90days().intValue());
							}

							Cell R26cell17 = row12.getCell(26);
							if (R26cell17 != null) {
								R26cell17.setCellValue(BRF40.getR26_exclusive_120days() == null ? 0
										: BRF40.getR26_exclusive_120days().intValue());
							}

							Cell R26cell18 = row12.getCell(27);
							if (R26cell18 != null) {
								R26cell18.setCellValue(BRF40.getR26_exclusive_180days() == null ? 0
										: BRF40.getR26_exclusive_180days().intValue());
							}

							Cell R26cell19 = row12.getCell(28);
							if (R26cell19 != null) {
								R26cell19.setCellValue(BRF40.getR26_exclusive_over_180days() == null ? 0
										: BRF40.getR26_exclusive_over_180days().intValue());
							}

							Cell R26cell20 = row12.getCell(31);
							if (R26cell20 != null) {
								R26cell20.setCellValue(
										BRF40.getR26_new_stage3() == null ? 0 : BRF40.getR26_new_stage3().intValue());
							}
							Cell R26cell21 = row12.getCell(32);
							if (R26cell21 != null) {
								R26cell21.setCellValue(BRF40.getR26_new_specific() == null ? 0
										: BRF40.getR26_new_specific().intValue());
							}
							/*Cell R26cell22 = row12.getCell(33);
							if (R26cell22 != null) {
								R26cell22.setCellValue(
										BRF40.getR26_new_other() == null ? 0 : BRF40.getR26_new_other().intValue());
							}*/

							Cell R26cell23 = row12.getCell(35);
							if (R26cell23 != null) {
								R26cell23.setCellValue(BRF40.getR26_performing_accounts() == null ? 0
										: BRF40.getR26_performing_accounts().intValue());
							}

							Cell R26cell24 = row12.getCell(36);
							if (R26cell24 != null) {
								R26cell24.setCellValue(BRF40.getR26_non_performing_accounts() == null ? 0
										: BRF40.getR26_non_performing_accounts().intValue());
							}
							/// row27
							Row row13= sheet.getRow(26);
							Cell R27cell = row13.getCell(3);
							if (R27cell != null) {
								R27cell.setCellValue(BRF40.getR27_outstanding_balance() == null ? 0
										: BRF40.getR27_outstanding_balance().intValue());
							}
							Cell R27cell1 = row13.getCell(7);
							if (R27cell1 != null) {
								R27cell1.setCellValue(BRF40.getR27_provision_suspense() == null ? 0
										: BRF40.getR27_provision_suspense().intValue());
							}
							Cell R27cell2 = row13.getCell(8);
							if (R27cell2 != null) {
								R27cell2.setCellValue(BRF40.getR27_stage3_provision() == null ? 0
										: BRF40.getR27_stage3_provision().intValue());
							}
							/*Cell R27cell3 = row13.getCell(9);
							if (R27cell3 != null) {
								R27cell3.setCellValue(BRF40.getR27_other_alloate() == null ? 0
										: BRF40.getR27_other_alloate().intValue());
							}*/
							Cell R27cell4 = row13.getCell(11);
							if (R27cell4 != null) {
								R27cell4.setCellValue(BRF40.getR27_1_asset() == null ? 0
										: BRF40.getR27_1_asset().intValue());
							}
							Cell R27cell5 = row13.getCell(12);
							if (R27cell5 != null) {
								R27cell5.setCellValue(BRF40.getR27_2_asset() == null ? 0
										: BRF40.getR27_2_asset().intValue());
							}
							Cell R27cell6 = row13.getCell(13);
							if (R27cell6 != null) {
								R27cell6.setCellValue(BRF40.getR27_3a_asset() == null ? 0
										: BRF40.getR27_3a_asset().intValue());
							}
							Cell R27cell7 = row13.getCell(14);
							if (R27cell7 != null) {
								R27cell7.setCellValue(BRF40.getR27_3b_asset() == null ? 0
										: BRF40.getR27_3b_asset().intValue());
							}
							Cell R27cell8 = row13.getCell(15);
							if (R27cell8 != null) {
								R27cell8.setCellValue(
										BRF40.getR27_3c_asset() == null ? 0 : BRF40.getR27_3c_asset().intValue());
							}
							Cell R27cell9 = row13.getCell(17);
							if (R27cell9 != null) {
								R27cell9.setCellValue(BRF40.getR27_1_provision() == null ? 0
										: BRF40.getR27_1_provision().intValue());
							}

							Cell R27cell10 = row13.getCell(18);
							if (R27cell10 != null) {
								R27cell10.setCellValue(BRF40.getR27_2_provision() == null ? 0
										: BRF40.getR27_2_provision().intValue());
							}
							Cell R27cell11 = row13.getCell(19);
							if (R27cell11 != null) {
								R27cell11.setCellValue(BRF40.getR27_3a_provision() == null ? 0
										: BRF40.getR27_3a_provision().intValue());
							}
							Cell R27cell12 = row13.getCell(20);
							if (R27cell12 != null) {
								R27cell12.setCellValue(BRF40.getR27_3b_provision() == null ? 0
										: BRF40.getR27_3b_provision().intValue());
							}
							Cell R27cell13 = row13.getCell(21);
							if (R27cell13 != null) {
								R27cell13.setCellValue(BRF40.getR27_3c_provision() == null ? 0
										: BRF40.getR27_3c_provision().intValue());
							}

							Cell R27cell14 = row13.getCell(23);
							if (R27cell14 != null) {
								R27cell14.setCellValue(
										BRF40.getR27_current() == null ? 0 : BRF40.getR27_current().intValue());
							}

							Cell R27cell15 = row13.getCell(24);
							if (R27cell15 != null) {
								R27cell15.setCellValue(
										BRF40.getR27_lessthan_30() == null ? 0 : BRF40.getR27_lessthan_30().intValue());
							}
							Cell R27cell16 = row13.getCell(25);
							if (R27cell16 != null) {
								R27cell16.setCellValue(BRF40.getR27_exclusive_90days() == null ? 0
										: BRF40.getR27_exclusive_90days().intValue());
							}

							Cell R27cell17 = row13.getCell(26);
							if (R27cell17 != null) {
								R27cell17.setCellValue(BRF40.getR27_exclusive_120days() == null ? 0
										: BRF40.getR27_exclusive_120days().intValue());
							}

							Cell R27cell18 = row13.getCell(27);
							if (R27cell18 != null) {
								R27cell18.setCellValue(BRF40.getR27_exclusive_180days() == null ? 0
										: BRF40.getR27_exclusive_180days().intValue());
							}

							Cell R27cell19 = row13.getCell(28);
							if (R27cell19 != null) {
								R27cell19.setCellValue(BRF40.getR27_exclusive_over_180days() == null ? 0
										: BRF40.getR27_exclusive_over_180days().intValue());
							}

							Cell R27cell20 = row13.getCell(31);
							if (R27cell20 != null) {
								R27cell20.setCellValue(
										BRF40.getR27_new_stage3() == null ? 0 : BRF40.getR27_new_stage3().intValue());
							}
							Cell R27cell21 = row13.getCell(32);
							if (R27cell21 != null) {
								R27cell21.setCellValue(BRF40.getR27_new_specific() == null ? 0
										: BRF40.getR27_new_specific().intValue());
							}
							/*Cell R27cell22 = row13.getCell(33);
							if (R27cell22 != null) {
								R27cell22.setCellValue(
										BRF40.getR27_new_other() == null ? 0 : BRF40.getR27_new_other().intValue());
							}*/

							Cell R27cell23 = row13.getCell(35);
							if (R27cell23 != null) {
								R27cell23.setCellValue(BRF40.getR27_performing_accounts() == null ? 0
										: BRF40.getR27_performing_accounts().intValue());
							}

							Cell R27cell24 = row13.getCell(36);
							if (R27cell24 != null) {
								R27cell24.setCellValue(BRF40.getR27_non_performing_accounts() == null ? 0
										: BRF40.getR27_non_performing_accounts().intValue());
							}

							/// row28
							Row row14= sheet.getRow(27);
							Cell R28cell = row14.getCell(3);
							if (R28cell != null) {
								R28cell.setCellValue(BRF40.getR28_outstanding_balance() == null ? 0
										: BRF40.getR28_outstanding_balance().intValue());
							}
							Cell R28cell1 = row14.getCell(7);
							if (R28cell1 != null) {
								R28cell1.setCellValue(BRF40.getR28_provision_suspense() == null ? 0
										: BRF40.getR28_provision_suspense().intValue());
							}
							Cell R28cell2 = row14.getCell(8);
							if (R28cell2 != null) {
								R28cell2.setCellValue(BRF40.getR28_stage3_provision() == null ? 0
										: BRF40.getR28_stage3_provision().intValue());
							}
							/*Cell R28cell3 = row14.getCell(9);
							if (R28cell3 != null) {
								R28cell3.setCellValue(BRF40.getR28_other_alloate() == null ? 0
										: BRF40.getR28_other_alloate().intValue());
							}*/
							Cell R28cell4 = row14.getCell(11);
							if (R28cell4 != null) {
								R28cell4.setCellValue(BRF40.getR28_1_asset() == null ? 0
										: BRF40.getR28_1_asset().intValue());
							}
							Cell R28cell5 = row14.getCell(12);
							if (R28cell5 != null) {
								R28cell5.setCellValue(BRF40.getR28_2_asset() == null ? 0
										: BRF40.getR28_2_asset().intValue());
							}
							Cell R28cell6 = row14.getCell(13);
							if (R28cell6 != null) {
								R28cell6.setCellValue(BRF40.getR28_3a_asset() == null ? 0
										: BRF40.getR28_3a_asset().intValue());
							}
							Cell R28cell7 = row14.getCell(14);
							if (R28cell7 != null) {
								R28cell7.setCellValue(BRF40.getR28_3b_asset() == null ? 0
										: BRF40.getR28_3b_asset().intValue());
							}
							Cell R28cell8 = row14.getCell(15);
							if (R28cell8 != null) {
								R28cell8.setCellValue(
										BRF40.getR28_3c_asset() == null ? 0 : BRF40.getR28_3c_asset().intValue());
							}
							Cell R28cell9 = row14.getCell(17);
							if (R28cell9 != null) {
								R28cell9.setCellValue(BRF40.getR28_1_provision() == null ? 0
										: BRF40.getR28_1_provision().intValue());
							}

							Cell R28cell10 = row14.getCell(18);
							if (R28cell10 != null) {
								R28cell10.setCellValue(BRF40.getR28_2_provision() == null ? 0
										: BRF40.getR28_2_provision().intValue());
							}
							Cell R28cell11 = row14.getCell(19);
							if (R28cell11 != null) {
								R28cell11.setCellValue(BRF40.getR28_3a_provision() == null ? 0
										: BRF40.getR28_3a_provision().intValue());
							}
							Cell R28cell12 = row14.getCell(20);
							if (R28cell12 != null) {
								R28cell12.setCellValue(BRF40.getR28_3b_provision() == null ? 0
										: BRF40.getR28_3b_provision().intValue());
							}
							Cell R28cell13 = row14.getCell(21);
							if (R28cell13 != null) {
								R28cell13.setCellValue(BRF40.getR28_3c_provision() == null ? 0
										: BRF40.getR28_3c_provision().intValue());
							}

							Cell R28cell14 = row14.getCell(23);
							if (R28cell14 != null) {
								R28cell14.setCellValue(
										BRF40.getR28_current() == null ? 0 : BRF40.getR28_current().intValue());
							}

							Cell R28cell15 = row14.getCell(24);
							if (R28cell15 != null) {
								R28cell15.setCellValue(
										BRF40.getR28_lessthan_30() == null ? 0 : BRF40.getR28_lessthan_30().intValue());
							}
							Cell R28cell16 = row14.getCell(25);
							if (R28cell16 != null) {
								R28cell16.setCellValue(BRF40.getR28_exclusive_90days() == null ? 0
										: BRF40.getR28_exclusive_90days().intValue());
							}

							Cell R28cell17 = row14.getCell(26);
							if (R28cell17 != null) {
								R28cell17.setCellValue(BRF40.getR28_exclusive_120days() == null ? 0
										: BRF40.getR28_exclusive_120days().intValue());
							}

							Cell R28cell18 = row14.getCell(27);
							if (R28cell18 != null) {
								R28cell18.setCellValue(BRF40.getR28_exclusive_180days() == null ? 0
										: BRF40.getR28_exclusive_180days().intValue());
							}

							Cell R28cell19 = row14.getCell(28);
							if (R28cell19 != null) {
								R28cell19.setCellValue(BRF40.getR28_exclusive_over_180days() == null ? 0
										: BRF40.getR28_exclusive_over_180days().intValue());
							}

							Cell R28cell20 = row14.getCell(31);
							if (R28cell20 != null) {
								R28cell20.setCellValue(
										BRF40.getR28_new_stage3() == null ? 0 : BRF40.getR28_new_stage3().intValue());
							}
							Cell R28cell21 = row14.getCell(32);
							if (R28cell21 != null) {
								R28cell21.setCellValue(BRF40.getR28_new_specific() == null ? 0
										: BRF40.getR28_new_specific().intValue());
							}
							/*Cell R28cell22 = row14.getCell(33);
							if (R28cell22 != null) {
								R28cell22.setCellValue(
										BRF40.getR28_new_other() == null ? 0 : BRF40.getR28_new_other().intValue());
							}*/

							Cell R28cell23 = row14.getCell(35);
							if (R28cell23 != null) {
								R28cell23.setCellValue(BRF40.getR28_performing_accounts() == null ? 0
										: BRF40.getR28_performing_accounts().intValue());
							}

							Cell R28cell24 = row14.getCell(36);
							if (R28cell24 != null) {
								R28cell24.setCellValue(BRF40.getR28_non_performing_accounts() == null ? 0
										: BRF40.getR28_non_performing_accounts().intValue());
							}

							/// row29
							Row row15= sheet.getRow(28);
							Cell R29cell = row15.getCell(3);
							if (R29cell != null) {
								R29cell.setCellValue(BRF40.getR29_outstanding_balance() == null ? 0
										: BRF40.getR29_outstanding_balance().intValue());
							}
							Cell R29cell1 = row15.getCell(7);
							if (R29cell1 != null) {
								R29cell1.setCellValue(BRF40.getR29_provision_suspense() == null ? 0
										: BRF40.getR29_provision_suspense().intValue());
							}
							Cell R29cell2 = row15.getCell(8);
							if (R29cell2 != null) {
								R29cell2.setCellValue(BRF40.getR29_stage3_provision() == null ? 0
										: BRF40.getR29_stage3_provision().intValue());
							}
							/*Cell R29cell3 = row15.getCell(9);
							if (R29cell3 != null) {
								R29cell3.setCellValue(BRF40.getR29_other_alloate() == null ? 0
										: BRF40.getR29_other_alloate().intValue());
							}*/
							Cell R29cell4 = row15.getCell(11);
							if (R29cell4 != null) {
								R29cell4.setCellValue(BRF40.getR29_1_asset() == null ? 0
										: BRF40.getR29_1_asset().intValue());
							}
							Cell R29cell5 = row15.getCell(12);
							if (R29cell5 != null) {
								R29cell5.setCellValue(BRF40.getR29_2_asset() == null ? 0
										: BRF40.getR29_2_asset().intValue());
							}
							Cell R29cell6 = row15.getCell(13);
							if (R29cell6 != null) {
								R29cell6.setCellValue(BRF40.getR29_3a_asset() == null ? 0
										: BRF40.getR29_3a_asset().intValue());
							}
							Cell R29cell7 = row15.getCell(14);
							if (R29cell7 != null) {
								R29cell7.setCellValue(BRF40.getR29_3b_asset() == null ? 0
										: BRF40.getR29_3b_asset().intValue());
							}
							Cell R29cell8 = row15.getCell(15);
							if (R29cell8 != null) {
								R29cell8.setCellValue(
										BRF40.getR29_3c_asset() == null ? 0 : BRF40.getR29_3c_asset().intValue());
							}
							Cell R29cell9 = row15.getCell(17);
							if (R29cell9 != null) {
								R29cell9.setCellValue(BRF40.getR29_1_provision() == null ? 0
										: BRF40.getR29_1_provision().intValue());
							}

							Cell R29cell10 = row15.getCell(18);
							if (R29cell10 != null) {
								R29cell10.setCellValue(BRF40.getR29_2_provision() == null ? 0
										: BRF40.getR29_2_provision().intValue());
							}
							Cell R29cell11 = row15.getCell(19);
							if (R29cell11 != null) {
								R29cell11.setCellValue(BRF40.getR29_3a_provision() == null ? 0
										: BRF40.getR29_3a_provision().intValue());
							}
							Cell R29cell12 = row15.getCell(20);
							if (R29cell12 != null) {
								R29cell12.setCellValue(BRF40.getR29_3b_provision() == null ? 0
										: BRF40.getR29_3b_provision().intValue());
							}
							Cell R29cell13 = row15.getCell(21);
							if (R29cell13 != null) {
								R29cell13.setCellValue(BRF40.getR29_3c_provision() == null ? 0
										: BRF40.getR29_3c_provision().intValue());
							}

							Cell R29cell14 = row15.getCell(23);
							if (R29cell14 != null) {
								R29cell14.setCellValue(
										BRF40.getR29_current() == null ? 0 : BRF40.getR29_current().intValue());
							}

							Cell R29cell15 = row15.getCell(24);
							if (R29cell15 != null) {
								R29cell15.setCellValue(
										BRF40.getR29_lessthan_30() == null ? 0 : BRF40.getR29_lessthan_30().intValue());
							}
							Cell R29cell16 = row15.getCell(25);
							if (R29cell16 != null) {
								R29cell16.setCellValue(BRF40.getR29_exclusive_90days() == null ? 0
										: BRF40.getR29_exclusive_90days().intValue());
							}

							Cell R29cell17 = row15.getCell(26);
							if (R29cell17 != null) {
								R29cell17.setCellValue(BRF40.getR29_exclusive_120days() == null ? 0
										: BRF40.getR29_exclusive_120days().intValue());
							}

							Cell R29cell18 = row15.getCell(27);
							if (R29cell18 != null) {
								R29cell18.setCellValue(BRF40.getR29_exclusive_180days() == null ? 0
										: BRF40.getR29_exclusive_180days().intValue());
							}

							Cell R29cell19 = row15.getCell(28);
							if (R29cell19 != null) {
								R29cell19.setCellValue(BRF40.getR29_exclusive_over_180days() == null ? 0
										: BRF40.getR29_exclusive_over_180days().intValue());
							}

							Cell R29cell20 = row15.getCell(31);
							if (R29cell20 != null) {
								R29cell20.setCellValue(
										BRF40.getR29_new_stage3() == null ? 0 : BRF40.getR29_new_stage3().intValue());
							}
							Cell R29cell21 = row15.getCell(32);
							if (R29cell21 != null) {
								R29cell21.setCellValue(BRF40.getR29_new_specific() == null ? 0
										: BRF40.getR29_new_specific().intValue());
							}
							/*Cell R29cell22 = row15.getCell(33);
							if (R29cell22 != null) {
								R29cell22.setCellValue(
										BRF40.getR29_new_other() == null ? 0 : BRF40.getR29_new_other().intValue());
							}*/

							Cell R29cell23 = row15.getCell(35);
							if (R29cell23 != null) {
								R29cell23.setCellValue(BRF40.getR29_performing_accounts() == null ? 0
										: BRF40.getR29_performing_accounts().intValue());
							}

							Cell R29cell24 = row15.getCell(36);
							if (R29cell24 != null) {
								R29cell24.setCellValue(BRF40.getR29_non_performing_accounts() == null ? 0
										: BRF40.getR29_non_performing_accounts().intValue());
							}

							/// row30
							Row row16= sheet.getRow(29);
							Cell R30cell = row16.getCell(3);
							if (R30cell != null) {
								R30cell.setCellValue(BRF40.getR30_outstanding_balance() == null ? 0
										: BRF40.getR30_outstanding_balance().intValue());
							}
							Cell R30cell1 = row16.getCell(7);
							if (R30cell1 != null) {
								R30cell1.setCellValue(BRF40.getR30_provision_suspense() == null ? 0
										: BRF40.getR30_provision_suspense().intValue());
							}
							Cell R30cell2 = row16.getCell(8);
							if (R30cell2 != null) {
								R30cell2.setCellValue(BRF40.getR30_stage3_provision() == null ? 0
										: BRF40.getR30_stage3_provision().intValue());
							}
							/*Cell R30cell3 = row16.getCell(9);
							if (R30cell3 != null) {
								R30cell3.setCellValue(BRF40.getR30_other_alloate() == null ? 0
										: BRF40.getR30_other_alloate().intValue());
							}*/
							Cell R30cell4 = row16.getCell(11);
							if (R30cell4 != null) {
								R30cell4.setCellValue(BRF40.getR30_1_asset() == null ? 0
										: BRF40.getR30_1_asset().intValue());
							}
							Cell R30cell5 = row16.getCell(12);
							if (R30cell5 != null) {
								R30cell5.setCellValue(BRF40.getR30_2_asset() == null ? 0
										: BRF40.getR30_2_asset().intValue());
							}
							Cell R30cell6 = row16.getCell(13);
							if (R30cell6 != null) {
								R30cell6.setCellValue(BRF40.getR30_3a_asset() == null ? 0
										: BRF40.getR30_3a_asset().intValue());
							}
							Cell R30cell7 = row16.getCell(14);
							if (R30cell7 != null) {
								R30cell7.setCellValue(BRF40.getR30_3b_asset() == null ? 0
										: BRF40.getR30_3b_asset().intValue());
							}
							Cell R30cell8 = row16.getCell(15);
							if (R30cell8 != null) {
								R30cell8.setCellValue(
										BRF40.getR30_3c_asset() == null ? 0 : BRF40.getR30_3c_asset().intValue());
							}
							Cell R30cell9 = row16.getCell(17);
							if (R30cell9 != null) {
								R30cell9.setCellValue(BRF40.getR30_1_provision() == null ? 0
										: BRF40.getR30_1_provision().intValue());
							}

							Cell R30cell10 = row16.getCell(18);
							if (R30cell10 != null) {
								R30cell10.setCellValue(BRF40.getR30_2_provision() == null ? 0
										: BRF40.getR30_2_provision().intValue());
							}
							Cell R30cell11 = row16.getCell(19);
							if (R30cell11 != null) {
								R30cell11.setCellValue(BRF40.getR30_3a_provision() == null ? 0
										: BRF40.getR30_3a_provision().intValue());
							}
							Cell R30cell12 = row16.getCell(20);
							if (R30cell12 != null) {
								R30cell12.setCellValue(BRF40.getR30_3b_provision() == null ? 0
										: BRF40.getR30_3b_provision().intValue());
							}
							Cell R30cell13 = row16.getCell(21);
							if (R30cell13 != null) {
								R30cell13.setCellValue(BRF40.getR30_3c_provision() == null ? 0
										: BRF40.getR30_3c_provision().intValue());
							}

							Cell R30cell14 = row16.getCell(23);
							if (R30cell14 != null) {
								R30cell14.setCellValue(
										BRF40.getR30_current() == null ? 0 : BRF40.getR30_current().intValue());
							}

							Cell R30cell15 = row16.getCell(24);
							if (R30cell15 != null) {
								R30cell15.setCellValue(
										BRF40.getR30_lessthan_30() == null ? 0 : BRF40.getR30_lessthan_30().intValue());
							}
							Cell R30cell16 = row16.getCell(25);
							if (R30cell16 != null) {
								R30cell16.setCellValue(BRF40.getR30_exclusive_90days() == null ? 0
										: BRF40.getR30_exclusive_90days().intValue());
							}

							Cell R30cell17 = row16.getCell(26);
							if (R30cell17 != null) {
								R30cell17.setCellValue(BRF40.getR30_exclusive_120days() == null ? 0
										: BRF40.getR30_exclusive_120days().intValue());
							}

							Cell R30cell18 = row16.getCell(27);
							if (R30cell18 != null) {
								R30cell18.setCellValue(BRF40.getR30_exclusive_180days() == null ? 0
										: BRF40.getR30_exclusive_180days().intValue());
							}

							Cell R30cell19 = row16.getCell(28);
							if (R30cell19 != null) {
								R30cell19.setCellValue(BRF40.getR30_exclusive_over_180days() == null ? 0
										: BRF40.getR30_exclusive_over_180days().intValue());
							}

							Cell R30cell20 = row16.getCell(31);
							if (R30cell20 != null) {
								R30cell20.setCellValue(
										BRF40.getR30_new_stage3() == null ? 0 : BRF40.getR30_new_stage3().intValue());
							}
							Cell R30cell21 = row16.getCell(32);
							if (R30cell21 != null) {
								R30cell21.setCellValue(BRF40.getR30_new_specific() == null ? 0
										: BRF40.getR30_new_specific().intValue());
							}
							/*Cell R30cell22 = row16.getCell(33);
							if (R30cell22 != null) {
								R30cell22.setCellValue(
										BRF40.getR30_new_other() == null ? 0 : BRF40.getR30_new_other().intValue());
							}*/

							Cell R30cell23 = row16.getCell(35);
							if (R30cell23 != null) {
								R30cell23.setCellValue(BRF40.getR30_performing_accounts() == null ? 0
										: BRF40.getR30_performing_accounts().intValue());
							}

							Cell R30cell24 = row16.getCell(36);
							if (R30cell24 != null) {
								R30cell24.setCellValue(BRF40.getR30_non_performing_accounts() == null ? 0
										: BRF40.getR30_non_performing_accounts().intValue());
							}

							/// row31
							Row row17= sheet.getRow(30);
							Cell R31cell = row17.getCell(3);
							if (R31cell != null) {
								R31cell.setCellValue(BRF40.getR31_outstanding_balance() == null ? 0
										: BRF40.getR31_outstanding_balance().intValue());
							}
							Cell R31cell1 = row17.getCell(7);
							if (R31cell1 != null) {
								R31cell1.setCellValue(BRF40.getR31_provision_suspense() == null ? 0
										: BRF40.getR31_provision_suspense().intValue());
							}
							Cell R31cell2 = row17.getCell(8);
							if (R31cell2 != null) {
								R31cell2.setCellValue(BRF40.getR31_stage3_provision() == null ? 0
										: BRF40.getR31_stage3_provision().intValue());
							}
							/*Cell R31cell3 = row17.getCell(9);
							if (R31cell3 != null) {
								R31cell3.setCellValue(BRF40.getR31_other_alloate() == null ? 0
										: BRF40.getR31_other_alloate().intValue());
							}*/
							Cell R31cell4 = row17.getCell(11);
							if (R31cell4 != null) {
								R31cell4.setCellValue(BRF40.getR31_1_asset() == null ? 0
										: BRF40.getR31_1_asset().intValue());
							}
							Cell R31cell5 = row17.getCell(12);
							if (R31cell5 != null) {
								R31cell5.setCellValue(BRF40.getR31_2_asset() == null ? 0
										: BRF40.getR31_2_asset().intValue());
							}
							Cell R31cell6 = row17.getCell(13);
							if (R31cell6 != null) {
								R31cell6.setCellValue(BRF40.getR31_3a_asset() == null ? 0
										: BRF40.getR31_3a_asset().intValue());
							}
							Cell R31cell7 = row17.getCell(14);
							if (R31cell7 != null) {
								R31cell7.setCellValue(BRF40.getR31_3b_asset() == null ? 0
										: BRF40.getR31_3b_asset().intValue());
							}
							Cell R31cell8 = row17.getCell(15);
							if (R31cell8 != null) {
								R31cell8.setCellValue(
										BRF40.getR31_3c_asset() == null ? 0 : BRF40.getR31_3c_asset().intValue());
							}
							Cell R31cell9 = row17.getCell(17);
							if (R31cell9 != null) {
								R31cell9.setCellValue(BRF40.getR31_1_provision() == null ? 0
										: BRF40.getR31_1_provision().intValue());
							}

							Cell R31cell10 = row17.getCell(18);
							if (R31cell10 != null) {
								R31cell10.setCellValue(BRF40.getR31_2_provision() == null ? 0
										: BRF40.getR31_2_provision().intValue());
							}
							Cell R31cell11 = row17.getCell(19);
							if (R31cell11 != null) {
								R31cell11.setCellValue(BRF40.getR31_3a_provision() == null ? 0
										: BRF40.getR31_3a_provision().intValue());
							}
							Cell R31cell12 = row17.getCell(20);
							if (R31cell12 != null) {
								R31cell12.setCellValue(BRF40.getR31_3b_provision() == null ? 0
										: BRF40.getR31_3b_provision().intValue());
							}
							Cell R31cell13 = row17.getCell(21);
							if (R31cell13 != null) {
								R31cell13.setCellValue(BRF40.getR31_3c_provision() == null ? 0
										: BRF40.getR31_3c_provision().intValue());
							}

							Cell R31cell14 = row17.getCell(23);
							if (R31cell14 != null) {
								R31cell14.setCellValue(
										BRF40.getR31_current() == null ? 0 : BRF40.getR31_current().intValue());
							}

							Cell R31cell15 = row17.getCell(24);
							if (R31cell15 != null) {
								R31cell15.setCellValue(
										BRF40.getR31_lessthan_30() == null ? 0 : BRF40.getR31_lessthan_30().intValue());
							}
							Cell R31cell16 = row17.getCell(25);
							if (R31cell16 != null) {
								R31cell16.setCellValue(BRF40.getR31_exclusive_90days() == null ? 0
										: BRF40.getR31_exclusive_90days().intValue());
							}

							Cell R31cell17 = row17.getCell(26);
							if (R31cell17 != null) {
								R31cell17.setCellValue(BRF40.getR31_exclusive_120days() == null ? 0
										: BRF40.getR31_exclusive_120days().intValue());
							}

							Cell R31cell18 = row17.getCell(27);
							if (R31cell18 != null) {
								R31cell18.setCellValue(BRF40.getR31_exclusive_180days() == null ? 0
										: BRF40.getR31_exclusive_180days().intValue());
							}

							Cell R31cell19 = row17.getCell(28);
							if (R31cell19 != null) {
								R31cell19.setCellValue(BRF40.getR31_exclusive_over_180days() == null ? 0
										: BRF40.getR31_exclusive_over_180days().intValue());
							}

							Cell R31cell20 = row17.getCell(31);
							if (R31cell20 != null) {
								R31cell20.setCellValue(
										BRF40.getR31_new_stage3() == null ? 0 : BRF40.getR31_new_stage3().intValue());
							}
							Cell R31cell21 = row17.getCell(32);
							if (R31cell21 != null) {
								R31cell21.setCellValue(BRF40.getR31_new_specific() == null ? 0
										: BRF40.getR31_new_specific().intValue());
							}
							/*Cell R31cell22 = row17.getCell(33);
							if (R31cell22 != null) {
								R31cell22.setCellValue(
										BRF40.getR31_new_other() == null ? 0 : BRF40.getR31_new_other().intValue());
							}*/

							Cell R31cell23 = row17.getCell(35);
							if (R31cell23 != null) {
								R31cell23.setCellValue(BRF40.getR31_performing_accounts() == null ? 0
										: BRF40.getR31_performing_accounts().intValue());
							}

							Cell R31cell24 = row17.getCell(36);
							if (R31cell24 != null) {
								R31cell24.setCellValue(BRF40.getR31_non_performing_accounts() == null ? 0
										: BRF40.getR31_non_performing_accounts().intValue());
							}
							/// row32
							Row row18= sheet.getRow(31);
							Cell R32cell = row18.getCell(3);
							if (R32cell != null) {
								R32cell.setCellValue(BRF40.getR32_outstanding_balance() == null ? 0
										: BRF40.getR32_outstanding_balance().intValue());
							}
							Cell R32cell1 = row18.getCell(7);
							if (R32cell1 != null) {
								R32cell1.setCellValue(BRF40.getR32_provision_suspense() == null ? 0
										: BRF40.getR32_provision_suspense().intValue());
							}
							Cell R32cell2 = row18.getCell(8);
							if (R32cell2 != null) {
								R32cell2.setCellValue(BRF40.getR32_stage3_provision() == null ? 0
										: BRF40.getR32_stage3_provision().intValue());
							}
							/*Cell R32cell3 = row18.getCell(9);
							if (R32cell3 != null) {
								R32cell3.setCellValue(BRF40.getR32_other_alloate() == null ? 0
										: BRF40.getR32_other_alloate().intValue());
							}*/
							Cell R32cell4 = row18.getCell(11);
							if (R32cell4 != null) {
								R32cell4.setCellValue(BRF40.getR32_1_asset() == null ? 0
										: BRF40.getR32_1_asset().intValue());
							}
							Cell R32cell5 = row18.getCell(12);
							if (R32cell5 != null) {
								R32cell5.setCellValue(BRF40.getR32_2_asset() == null ? 0
										: BRF40.getR32_2_asset().intValue());
							}
							Cell R32cell6 = row18.getCell(13);
							if (R32cell6 != null) {
								R32cell6.setCellValue(BRF40.getR32_3a_asset() == null ? 0
										: BRF40.getR32_3a_asset().intValue());
							}
							Cell R32cell7 = row18.getCell(14);
							if (R32cell7 != null) {
								R32cell7.setCellValue(BRF40.getR32_3b_asset() == null ? 0
										: BRF40.getR32_3b_asset().intValue());
							}
							Cell R32cell8 = row18.getCell(15);
							if (R32cell8 != null) {
								R32cell8.setCellValue(
										BRF40.getR32_3c_asset() == null ? 0 : BRF40.getR32_3c_asset().intValue());
							}
							Cell R32cell9 = row18.getCell(17);
							if (R32cell9 != null) {
								R32cell9.setCellValue(BRF40.getR32_1_provision() == null ? 0
										: BRF40.getR32_1_provision().intValue());
							}

							Cell R32cell10 = row18.getCell(18);
							if (R32cell10 != null) {
								R32cell10.setCellValue(BRF40.getR32_2_provision() == null ? 0
										: BRF40.getR32_2_provision().intValue());
							}
							Cell R32cell11 = row18.getCell(19);
							if (R32cell11 != null) {
								R32cell11.setCellValue(BRF40.getR32_3a_provision() == null ? 0
										: BRF40.getR32_3a_provision().intValue());
							}
							Cell R32cell12 = row18.getCell(20);
							if (R32cell12 != null) {
								R32cell12.setCellValue(BRF40.getR32_3b_provision() == null ? 0
										: BRF40.getR32_3b_provision().intValue());
							}
							Cell R32cell13 = row18.getCell(21);
							if (R32cell13 != null) {
								R32cell13.setCellValue(BRF40.getR32_3c_provision() == null ? 0
										: BRF40.getR32_3c_provision().intValue());
							}

							Cell R32cell14 = row18.getCell(23);
							if (R32cell14 != null) {
								R32cell14.setCellValue(
										BRF40.getR32_current() == null ? 0 : BRF40.getR32_current().intValue());
							}

							Cell R32cell15 = row18.getCell(24);
							if (R32cell15 != null) {
								R32cell15.setCellValue(
										BRF40.getR32_lessthan_30() == null ? 0 : BRF40.getR32_lessthan_30().intValue());
							}
							Cell R32cell16 = row18.getCell(25);
							if (R32cell16 != null) {
								R32cell16.setCellValue(BRF40.getR32_exclusive_90days() == null ? 0
										: BRF40.getR32_exclusive_90days().intValue());
							}

							Cell R32cell17 = row18.getCell(26);
							if (R32cell17 != null) {
								R32cell17.setCellValue(BRF40.getR32_exclusive_120days() == null ? 0
										: BRF40.getR32_exclusive_120days().intValue());
							}

							Cell R32cell18 = row18.getCell(27);
							if (R32cell18 != null) {
								R32cell18.setCellValue(BRF40.getR32_exclusive_180days() == null ? 0
										: BRF40.getR32_exclusive_180days().intValue());
							}

							Cell R32cell19 = row18.getCell(28);
							if (R32cell19 != null) {
								R32cell19.setCellValue(BRF40.getR32_exclusive_over_180days() == null ? 0
										: BRF40.getR32_exclusive_over_180days().intValue());
							}

							Cell R32cell20 = row18.getCell(31);
							if (R32cell20 != null) {
								R32cell20.setCellValue(
										BRF40.getR32_new_stage3() == null ? 0 : BRF40.getR32_new_stage3().intValue());
							}
							Cell R32cell21 = row18.getCell(32);
							if (R32cell21 != null) {
								R32cell21.setCellValue(BRF40.getR32_new_specific() == null ? 0
										: BRF40.getR32_new_specific().intValue());
							}
							/*Cell R32cell22 = row18.getCell(33);
							if (R32cell22 != null) {
								R32cell22.setCellValue(
										BRF40.getR32_new_other() == null ? 0 : BRF40.getR32_new_other().intValue());
							}*/

							Cell R32cell23 = row18.getCell(35);
							if (R32cell23 != null) {
								R32cell23.setCellValue(BRF40.getR32_performing_accounts() == null ? 0
										: BRF40.getR32_performing_accounts().intValue());
							}

							Cell R32cell24 = row18.getCell(36);
							if (R32cell24 != null) {
								R32cell24.setCellValue(BRF40.getR32_non_performing_accounts() == null ? 0
										: BRF40.getR32_non_performing_accounts().intValue());
							}
							/// row33
							Row row19= sheet.getRow(32);
							Cell R33cell = row19.getCell(3);
							if (R33cell != null) {
								R33cell.setCellValue(BRF40.getR33_outstanding_balance() == null ? 0
										: BRF40.getR33_outstanding_balance().intValue());
							}
							Cell R33cell1 = row19.getCell(7);
							if (R33cell1 != null) {
								R33cell1.setCellValue(BRF40.getR33_provision_suspense() == null ? 0
										: BRF40.getR33_provision_suspense().intValue());
							}
							Cell R33cell2 = row19.getCell(8);
							if (R33cell2 != null) {
								R33cell2.setCellValue(BRF40.getR33_stage3_provision() == null ? 0
										: BRF40.getR33_stage3_provision().intValue());
							}
							/*Cell R33cell3 = row19.getCell(9);
							if (R33cell3 != null) {
								R33cell3.setCellValue(BRF40.getR33_other_alloate() == null ? 0
										: BRF40.getR33_other_alloate().intValue());
							}*/
							Cell R33cell4 = row19.getCell(11);
							if (R33cell4 != null) {
								R33cell4.setCellValue(BRF40.getR33_1_asset() == null ? 0
										: BRF40.getR33_1_asset().intValue());
							}
							Cell R33cell5 = row19.getCell(12);
							if (R33cell5 != null) {
								R33cell5.setCellValue(BRF40.getR33_2_asset() == null ? 0
										: BRF40.getR33_2_asset().intValue());
							}
							Cell R33cell6 = row19.getCell(13);
							if (R33cell6 != null) {
								R33cell6.setCellValue(BRF40.getR33_3a_asset() == null ? 0
										: BRF40.getR33_3a_asset().intValue());
							}
							Cell R33cell7 = row19.getCell(14);
							if (R33cell7 != null) {
								R33cell7.setCellValue(BRF40.getR33_3b_asset() == null ? 0
										: BRF40.getR33_3b_asset().intValue());
							}
							Cell R33cell8 = row19.getCell(15);
							if (R33cell8 != null) {
								R33cell8.setCellValue(
										BRF40.getR33_3c_asset() == null ? 0 : BRF40.getR33_3c_asset().intValue());
							}
							Cell R33cell9 = row19.getCell(17);
							if (R33cell9 != null) {
								R33cell9.setCellValue(BRF40.getR33_1_provision() == null ? 0
										: BRF40.getR33_1_provision().intValue());
							}

							Cell R33cell10 = row19.getCell(18);
							if (R33cell10 != null) {
								R33cell10.setCellValue(BRF40.getR33_2_provision() == null ? 0
										: BRF40.getR33_2_provision().intValue());
							}
							Cell R33cell11 = row19.getCell(19);
							if (R33cell11 != null) {
								R33cell11.setCellValue(BRF40.getR33_3a_provision() == null ? 0
										: BRF40.getR33_3a_provision().intValue());
							}
							Cell R33cell12 = row19.getCell(20);
							if (R33cell12 != null) {
								R33cell12.setCellValue(BRF40.getR33_3b_provision() == null ? 0
										: BRF40.getR33_3b_provision().intValue());
							}
							Cell R33cell13 = row19.getCell(21);
							if (R33cell13 != null) {
								R33cell13.setCellValue(BRF40.getR33_3c_provision() == null ? 0
										: BRF40.getR33_3c_provision().intValue());
							}

							Cell R33cell14 = row19.getCell(23);
							if (R33cell14 != null) {
								R33cell14.setCellValue(
										BRF40.getR33_current() == null ? 0 : BRF40.getR33_current().intValue());
							}

							Cell R33cell15 = row19.getCell(24);
							if (R33cell15 != null) {
								R33cell15.setCellValue(
										BRF40.getR33_lessthan_30() == null ? 0 : BRF40.getR33_lessthan_30().intValue());
							}
							Cell R33cell16 = row19.getCell(25);
							if (R33cell16 != null) {
								R33cell16.setCellValue(BRF40.getR33_exclusive_90days() == null ? 0
										: BRF40.getR33_exclusive_90days().intValue());
							}

							Cell R33cell17 = row19.getCell(26);
							if (R33cell17 != null) {
								R33cell17.setCellValue(BRF40.getR33_exclusive_120days() == null ? 0
										: BRF40.getR33_exclusive_120days().intValue());
							}

							Cell R33cell18 = row19.getCell(27);
							if (R33cell18 != null) {
								R33cell18.setCellValue(BRF40.getR33_exclusive_180days() == null ? 0
										: BRF40.getR33_exclusive_180days().intValue());
							}

							Cell R33cell19 = row19.getCell(28);
							if (R33cell19 != null) {
								R33cell19.setCellValue(BRF40.getR33_exclusive_over_180days() == null ? 0
										: BRF40.getR33_exclusive_over_180days().intValue());
							}

							Cell R33cell20 = row19.getCell(31);
							if (R33cell20 != null) {
								R33cell20.setCellValue(
										BRF40.getR33_new_stage3() == null ? 0 : BRF40.getR33_new_stage3().intValue());
							}
							Cell R33cell21 = row19.getCell(32);
							if (R33cell21 != null) {
								R33cell21.setCellValue(BRF40.getR33_new_specific() == null ? 0
										: BRF40.getR33_new_specific().intValue());
							}
							/*Cell R33cell22 = row19.getCell(33);
							if (R33cell22 != null) {
								R33cell22.setCellValue(
										BRF40.getR33_new_other() == null ? 0 : BRF40.getR33_new_other().intValue());
							}*/

							Cell R33cell23 = row19.getCell(35);
							if (R33cell23 != null) {
								R33cell23.setCellValue(BRF40.getR33_performing_accounts() == null ? 0
										: BRF40.getR33_performing_accounts().intValue());
							}

							Cell R33cell24 = row19.getCell(36);
							if (R33cell24 != null) {
								R33cell24.setCellValue(BRF40.getR33_non_performing_accounts() == null ? 0
										: BRF40.getR33_non_performing_accounts().intValue());
							}
							/// row34
							Row row20= sheet.getRow(33);
							Cell R34cell = row20.getCell(3);
							if (R34cell != null) {
								R34cell.setCellValue(BRF40.getR34_outstanding_balance() == null ? 0
										: BRF40.getR34_outstanding_balance().intValue());
							}
							Cell R34cell1 = row20.getCell(7);
							if (R34cell1 != null) {
								R34cell1.setCellValue(BRF40.getR34_provision_suspense() == null ? 0
										: BRF40.getR34_provision_suspense().intValue());
							}
							Cell R34cell2 = row20.getCell(8);
							if (R34cell2 != null) {
								R34cell2.setCellValue(BRF40.getR34_stage3_provision() == null ? 0
										: BRF40.getR34_stage3_provision().intValue());
							}
							/*Cell R34cell3 = row20.getCell(9);
							if (R34cell3 != null) {
								R34cell3.setCellValue(BRF40.getR34_other_alloate() == null ? 0
										: BRF40.getR34_other_alloate().intValue());
							}*/
							Cell R34cell4 = row20.getCell(11);
							if (R34cell4 != null) {
								R34cell4.setCellValue(BRF40.getR34_1_asset() == null ? 0
										: BRF40.getR34_1_asset().intValue());
							}
							Cell R34cell5 = row20.getCell(12);
							if (R34cell5 != null) {
								R34cell5.setCellValue(BRF40.getR34_2_asset() == null ? 0
										: BRF40.getR34_2_asset().intValue());
							}
							Cell R34cell6 = row20.getCell(13);
							if (R34cell6 != null) {
								R34cell6.setCellValue(BRF40.getR34_3a_asset() == null ? 0
										: BRF40.getR34_3a_asset().intValue());
							}
							Cell R34cell7 = row20.getCell(14);
							if (R34cell7 != null) {
								R34cell7.setCellValue(BRF40.getR34_3b_asset() == null ? 0
										: BRF40.getR34_3b_asset().intValue());
							}
							Cell R34cell8 = row20.getCell(15);
							if (R34cell8 != null) {
								R34cell8.setCellValue(
										BRF40.getR34_3c_asset() == null ? 0 : BRF40.getR34_3c_asset().intValue());
							}
							Cell R34cell9 = row20.getCell(17);
							if (R34cell9 != null) {
								R34cell9.setCellValue(BRF40.getR34_1_provision() == null ? 0
										: BRF40.getR34_1_provision().intValue());
							}

							Cell R34cell10 = row20.getCell(18);
							if (R34cell10 != null) {
								R34cell10.setCellValue(BRF40.getR34_2_provision() == null ? 0
										: BRF40.getR34_2_provision().intValue());
							}
							Cell R34cell11 = row20.getCell(19);
							if (R34cell11 != null) {
								R34cell11.setCellValue(BRF40.getR34_3a_provision() == null ? 0
										: BRF40.getR34_3a_provision().intValue());
							}
							Cell R34cell12 = row20.getCell(20);
							if (R34cell12 != null) {
								R34cell12.setCellValue(BRF40.getR34_3b_provision() == null ? 0
										: BRF40.getR34_3b_provision().intValue());
							}
							Cell R34cell13 = row20.getCell(21);
							if (R34cell13 != null) {
								R34cell13.setCellValue(BRF40.getR34_3c_provision() == null ? 0
										: BRF40.getR34_3c_provision().intValue());
							}

							Cell R34cell14 = row20.getCell(23);
							if (R34cell14 != null) {
								R34cell14.setCellValue(
										BRF40.getR34_current() == null ? 0 : BRF40.getR34_current().intValue());
							}

							Cell R34cell15 = row20.getCell(24);
							if (R34cell15 != null) {
								R34cell15.setCellValue(
										BRF40.getR34_lessthan_30() == null ? 0 : BRF40.getR34_lessthan_30().intValue());
							}
							Cell R34cell16 = row20.getCell(25);
							if (R34cell16 != null) {
								R34cell16.setCellValue(BRF40.getR34_exclusive_90days() == null ? 0
										: BRF40.getR34_exclusive_90days().intValue());
							}

							Cell R34cell17 = row20.getCell(26);
							if (R34cell17 != null) {
								R34cell17.setCellValue(BRF40.getR34_exclusive_120days() == null ? 0
										: BRF40.getR34_exclusive_120days().intValue());
							}

							Cell R34cell18 = row20.getCell(27);
							if (R34cell18 != null) {
								R34cell18.setCellValue(BRF40.getR34_exclusive_180days() == null ? 0
										: BRF40.getR34_exclusive_180days().intValue());
							}

							Cell R34cell19 = row20.getCell(28);
							if (R34cell19 != null) {
								R34cell19.setCellValue(BRF40.getR34_exclusive_over_180days() == null ? 0
										: BRF40.getR34_exclusive_over_180days().intValue());
							}

							Cell R34cell20 = row20.getCell(31);
							if (R34cell20 != null) {
								R34cell20.setCellValue(
										BRF40.getR34_new_stage3() == null ? 0 : BRF40.getR34_new_stage3().intValue());
							}
							Cell R34cell21 = row20.getCell(32);
							if (R34cell21 != null) {
								R34cell21.setCellValue(BRF40.getR34_new_specific() == null ? 0
										: BRF40.getR34_new_specific().intValue());
							}
							/*Cell R34cell22 = row20.getCell(33);
							if (R34cell22 != null) {
								R34cell22.setCellValue(
										BRF40.getR34_new_other() == null ? 0 : BRF40.getR34_new_other().intValue());
							}*/

							Cell R34cell23 = row20.getCell(35);
							if (R34cell23 != null) {
								R34cell23.setCellValue(BRF40.getR34_performing_accounts() == null ? 0
										: BRF40.getR34_performing_accounts().intValue());
							}

							Cell R34cell24 = row20.getCell(36);
							if (R34cell24 != null) {
								R34cell24.setCellValue(BRF40.getR34_non_performing_accounts() == null ? 0
										: BRF40.getR34_non_performing_accounts().intValue());
							}
							/// row35
							Row row21= sheet.getRow(34);
							Cell R35cell = row21.getCell(3);
							if (R35cell != null) {
								R35cell.setCellValue(BRF40.getR35_outstanding_balance() == null ? 0
										: BRF40.getR35_outstanding_balance().intValue());
							}
							Cell R35cell1 = row21.getCell(7);
							if (R35cell1 != null) {
								R35cell1.setCellValue(BRF40.getR35_provision_suspense() == null ? 0
										: BRF40.getR35_provision_suspense().intValue());
							}
							Cell R35cell2 = row21.getCell(8);
							if (R35cell2 != null) {
								R35cell2.setCellValue(BRF40.getR35_stage3_provision() == null ? 0
										: BRF40.getR35_stage3_provision().intValue());
							}
							/*Cell R35cell3 = row21.getCell(9);
							if (R35cell3 != null) {
								R35cell3.setCellValue(BRF40.getR35_other_alloate() == null ? 0
										: BRF40.getR35_other_alloate().intValue());
							}*/
							Cell R35cell4 = row21.getCell(11);
							if (R35cell4 != null) {
								R35cell4.setCellValue(BRF40.getR35_1_asset() == null ? 0
										: BRF40.getR35_1_asset().intValue());
							}
							Cell R35cell5 = row21.getCell(12);
							if (R35cell5 != null) {
								R35cell5.setCellValue(BRF40.getR35_2_asset() == null ? 0
										: BRF40.getR35_2_asset().intValue());
							}
							Cell R35cell6 = row21.getCell(13);
							if (R35cell6 != null) {
								R35cell6.setCellValue(BRF40.getR35_3a_asset() == null ? 0
										: BRF40.getR35_3a_asset().intValue());
							}
							Cell R35cell7 = row21.getCell(14);
							if (R35cell7 != null) {
								R35cell7.setCellValue(BRF40.getR35_3b_asset() == null ? 0
										: BRF40.getR35_3b_asset().intValue());
							}
							Cell R35cell8 = row21.getCell(15);
							if (R35cell8 != null) {
								R35cell8.setCellValue(
										BRF40.getR35_3c_asset() == null ? 0 : BRF40.getR35_3c_asset().intValue());
							}
							Cell R35cell9 = row21.getCell(17);
							if (R35cell9 != null) {
								R35cell9.setCellValue(BRF40.getR35_1_provision() == null ? 0
										: BRF40.getR35_1_provision().intValue());
							}

							Cell R35cell10 = row21.getCell(18);
							if (R35cell10 != null) {
								R35cell10.setCellValue(BRF40.getR35_2_provision() == null ? 0
										: BRF40.getR35_2_provision().intValue());
							}
							Cell R35cell11 = row21.getCell(19);
							if (R35cell11 != null) {
								R35cell11.setCellValue(BRF40.getR35_3a_provision() == null ? 0
										: BRF40.getR35_3a_provision().intValue());
							}
							Cell R35cell12 = row21.getCell(20);
							if (R35cell12 != null) {
								R35cell12.setCellValue(BRF40.getR35_3b_provision() == null ? 0
										: BRF40.getR35_3b_provision().intValue());
							}
							Cell R35cell13 = row21.getCell(21);
							if (R35cell13 != null) {
								R35cell13.setCellValue(BRF40.getR35_3c_provision() == null ? 0
										: BRF40.getR35_3c_provision().intValue());
							}

							Cell R35cell14 = row21.getCell(23);
							if (R35cell14 != null) {
								R35cell14.setCellValue(
										BRF40.getR35_current() == null ? 0 : BRF40.getR35_current().intValue());
							}

							Cell R35cell15 = row21.getCell(24);
							if (R35cell15 != null) {
								R35cell15.setCellValue(
										BRF40.getR35_lessthan_30() == null ? 0 : BRF40.getR35_lessthan_30().intValue());
							}
							Cell R35cell16 = row21.getCell(25);
							if (R35cell16 != null) {
								R35cell16.setCellValue(BRF40.getR35_exclusive_90days() == null ? 0
										: BRF40.getR35_exclusive_90days().intValue());
							}

							Cell R35cell17 = row21.getCell(26);
							if (R35cell17 != null) {
								R35cell17.setCellValue(BRF40.getR35_exclusive_120days() == null ? 0
										: BRF40.getR35_exclusive_120days().intValue());
							}

							Cell R35cell18 = row21.getCell(27);
							if (R35cell18 != null) {
								R35cell18.setCellValue(BRF40.getR35_exclusive_180days() == null ? 0
										: BRF40.getR35_exclusive_180days().intValue());
							}

							Cell R35cell19 = row21.getCell(28);
							if (R35cell19 != null) {
								R35cell19.setCellValue(BRF40.getR35_exclusive_over_180days() == null ? 0
										: BRF40.getR35_exclusive_over_180days().intValue());
							}

							Cell R35cell20 = row21.getCell(31);
							if (R35cell20 != null) {
								R35cell20.setCellValue(
										BRF40.getR35_new_stage3() == null ? 0 : BRF40.getR35_new_stage3().intValue());
							}
							Cell R35cell21 = row21.getCell(32);
							if (R35cell21 != null) {
								R35cell21.setCellValue(BRF40.getR35_new_specific() == null ? 0
										: BRF40.getR35_new_specific().intValue());
							}
							/*Cell R35cell22 = row21.getCell(33);
							if (R35cell22 != null) {
								R35cell22.setCellValue(
										BRF40.getR35_new_other() == null ? 0 : BRF40.getR35_new_other().intValue());
							}*/

							Cell R35cell23 = row21.getCell(35);
							if (R35cell23 != null) {
								R35cell23.setCellValue(BRF40.getR35_performing_accounts() == null ? 0
										: BRF40.getR35_performing_accounts().intValue());
							}

							Cell R35cell24 = row21.getCell(36);
							if (R35cell24 != null) {
								R35cell24.setCellValue(BRF40.getR35_non_performing_accounts() == null ? 0
										: BRF40.getR35_non_performing_accounts().intValue());
							}
							/// row37
							Row row22= sheet.getRow(36);
							Cell R37cell = row22.getCell(3);
							if (R37cell != null) {
								R37cell.setCellValue(BRF40.getR37_outstanding_balance() == null ? 0
										: BRF40.getR37_outstanding_balance().intValue());
							}
							Cell R37cell1 = row22.getCell(7);
							if (R37cell1 != null) {
								R37cell1.setCellValue(BRF40.getR37_provision_suspense() == null ? 0
										: BRF40.getR37_provision_suspense().intValue());
							}
							Cell R37cell2 = row22.getCell(8);
							if (R37cell2 != null) {
								R37cell2.setCellValue(BRF40.getR37_stage3_provision() == null ? 0
										: BRF40.getR37_stage3_provision().intValue());
							}
							/*Cell R37cell3 = row22.getCell(9);
							if (R37cell3 != null) {
								R37cell3.setCellValue(BRF40.getR37_other_alloate() == null ? 0
										: BRF40.getR37_other_alloate().intValue());
							}*/
							Cell R37cell4 = row22.getCell(11);
							if (R37cell4 != null) {
								R37cell4.setCellValue(BRF40.getR37_1_asset() == null ? 0
										: BRF40.getR37_1_asset().intValue());
							}
							Cell R37cell5 = row22.getCell(12);
							if (R37cell5 != null) {
								R37cell5.setCellValue(BRF40.getR37_2_asset() == null ? 0
										: BRF40.getR37_2_asset().intValue());
							}
							Cell R37cell6 = row22.getCell(13);
							if (R37cell6 != null) {
								R37cell6.setCellValue(BRF40.getR37_3a_asset() == null ? 0
										: BRF40.getR37_3a_asset().intValue());
							}
							Cell R37cell7 = row22.getCell(14);
							if (R37cell7 != null) {
								R37cell7.setCellValue(BRF40.getR37_3b_asset() == null ? 0
										: BRF40.getR37_3b_asset().intValue());
							}
							Cell R37cell8 = row22.getCell(15);
							if (R37cell8 != null) {
								R37cell8.setCellValue(
										BRF40.getR37_3c_asset() == null ? 0 : BRF40.getR37_3c_asset().intValue());
							}
							Cell R37cell9 = row22.getCell(17);
							if (R37cell9 != null) {
								R37cell9.setCellValue(BRF40.getR37_1_provision() == null ? 0
										: BRF40.getR37_1_provision().intValue());
							}

							Cell R37cell10 = row22.getCell(18);
							if (R37cell10 != null) {
								R37cell10.setCellValue(BRF40.getR37_2_provision() == null ? 0
										: BRF40.getR37_2_provision().intValue());
							}
							Cell R37cell11 = row22.getCell(19);
							if (R37cell11 != null) {
								R37cell11.setCellValue(BRF40.getR37_3a_provision() == null ? 0
										: BRF40.getR37_3a_provision().intValue());
							}
							Cell R37cell12 = row22.getCell(20);
							if (R37cell12 != null) {
								R37cell12.setCellValue(BRF40.getR37_3b_provision() == null ? 0
										: BRF40.getR37_3b_provision().intValue());
							}
							Cell R37cell13 = row22.getCell(21);
							if (R37cell13 != null) {
								R37cell13.setCellValue(BRF40.getR37_3c_provision() == null ? 0
										: BRF40.getR37_3c_provision().intValue());
							}

							Cell R37cell14 = row22.getCell(23);
							if (R37cell14 != null) {
								R37cell14.setCellValue(
										BRF40.getR37_current() == null ? 0 : BRF40.getR37_current().intValue());
							}

							Cell R37cell15 = row22.getCell(24);
							if (R37cell15 != null) {
								R37cell15.setCellValue(
										BRF40.getR37_lessthan_30() == null ? 0 : BRF40.getR37_lessthan_30().intValue());
							}
							Cell R37cell16 = row22.getCell(25);
							if (R37cell16 != null) {
								R37cell16.setCellValue(BRF40.getR37_exclusive_90days() == null ? 0
										: BRF40.getR37_exclusive_90days().intValue());
							}

							Cell R37cell17 = row22.getCell(26);
							if (R37cell17 != null) {
								R37cell17.setCellValue(BRF40.getR37_exclusive_120days() == null ? 0
										: BRF40.getR37_exclusive_120days().intValue());
							}

							Cell R37cell18 = row22.getCell(27);
							if (R37cell18 != null) {
								R37cell18.setCellValue(BRF40.getR37_exclusive_180days() == null ? 0
										: BRF40.getR37_exclusive_180days().intValue());
							}

							Cell R37cell19 = row22.getCell(28);
							if (R37cell19 != null) {
								R37cell19.setCellValue(BRF40.getR37_exclusive_over_180days() == null ? 0
										: BRF40.getR37_exclusive_over_180days().intValue());
							}

							Cell R37cell20 = row22.getCell(31);
							if (R37cell20 != null) {
								R37cell20.setCellValue(
										BRF40.getR37_new_stage3() == null ? 0 : BRF40.getR37_new_stage3().intValue());
							}
							Cell R37cell21 = row22.getCell(32);
							if (R37cell21 != null) {
								R37cell21.setCellValue(BRF40.getR37_new_specific() == null ? 0
										: BRF40.getR37_new_specific().intValue());
							}
							/*Cell R37cell22 = row22.getCell(33);
							if (R37cell22 != null) {
								R37cell22.setCellValue(
										BRF40.getR37_new_other() == null ? 0 : BRF40.getR37_new_other().intValue());
							}*/

							Cell R37cell23 = row22.getCell(35);
							if (R37cell23 != null) {
								R37cell23.setCellValue(BRF40.getR37_performing_accounts() == null ? 0
										: BRF40.getR37_performing_accounts().intValue());
							}

							Cell R37cell24 = row22.getCell(36);
							if (R37cell24 != null) {
								R37cell24.setCellValue(BRF40.getR37_non_performing_accounts() == null ? 0
										: BRF40.getR37_non_performing_accounts().intValue());
							}

							/// row38
							Row row23= sheet.getRow(37);
							Cell R38cell = row23.getCell(3);
							if (R38cell != null) {
								R38cell.setCellValue(BRF40.getR38_outstanding_balance() == null ? 0
										: BRF40.getR38_outstanding_balance().intValue());
							}
							Cell R38cell1 = row23.getCell(7);
							if (R38cell1 != null) {
								R38cell1.setCellValue(BRF40.getR38_provision_suspense() == null ? 0
										: BRF40.getR38_provision_suspense().intValue());
							}
							Cell R38cell2 = row23.getCell(8);
							if (R38cell2 != null) {
								R38cell2.setCellValue(BRF40.getR38_stage3_provision() == null ? 0
										: BRF40.getR38_stage3_provision().intValue());
							}
							/*Cell R38cell3 = row23.getCell(9);
							if (R38cell3 != null) {
								R38cell3.setCellValue(BRF40.getR38_other_alloate() == null ? 0
										: BRF40.getR38_other_alloate().intValue());
							}*/
							Cell R38cell4 = row23.getCell(11);
							if (R38cell4 != null) {
								R38cell4.setCellValue(BRF40.getR38_1_asset() == null ? 0
										: BRF40.getR38_1_asset().intValue());
							}
							Cell R38cell5 = row23.getCell(12);
							if (R38cell5 != null) {
								R38cell5.setCellValue(BRF40.getR38_2_asset() == null ? 0
										: BRF40.getR38_2_asset().intValue());
							}
							Cell R38cell6 = row23.getCell(13);
							if (R38cell6 != null) {
								R38cell6.setCellValue(BRF40.getR38_3a_asset() == null ? 0
										: BRF40.getR38_3a_asset().intValue());
							}
							Cell R38cell7 = row23.getCell(14);
							if (R38cell7 != null) {
								R38cell7.setCellValue(BRF40.getR38_3b_asset() == null ? 0
										: BRF40.getR38_3b_asset().intValue());
							}
							Cell R38cell8 = row23.getCell(15);
							if (R38cell8 != null) {
								R38cell8.setCellValue(
										BRF40.getR38_3c_asset() == null ? 0 : BRF40.getR38_3c_asset().intValue());
							}
							Cell R38cell9 = row23.getCell(17);
							if (R38cell9 != null) {
								R38cell9.setCellValue(BRF40.getR38_1_provision() == null ? 0
										: BRF40.getR38_1_provision().intValue());
							}

							Cell R38cell10 = row23.getCell(18);
							if (R38cell10 != null) {
								R38cell10.setCellValue(BRF40.getR38_2_provision() == null ? 0
										: BRF40.getR38_2_provision().intValue());
							}
							Cell R38cell11 = row23.getCell(19);
							if (R38cell11 != null) {
								R38cell11.setCellValue(BRF40.getR38_3a_provision() == null ? 0
										: BRF40.getR38_3a_provision().intValue());
							}
							Cell R38cell12 = row23.getCell(20);
							if (R38cell12 != null) {
								R38cell12.setCellValue(BRF40.getR38_3b_provision() == null ? 0
										: BRF40.getR38_3b_provision().intValue());
							}
							Cell R38cell13 = row23.getCell(21);
							if (R38cell13 != null) {
								R38cell13.setCellValue(BRF40.getR38_3c_provision() == null ? 0
										: BRF40.getR38_3c_provision().intValue());
							}

							Cell R38cell14 = row23.getCell(23);
							if (R38cell14 != null) {
								R38cell14.setCellValue(
										BRF40.getR38_current() == null ? 0 : BRF40.getR38_current().intValue());
							}

							Cell R38cell15 = row23.getCell(24);
							if (R38cell15 != null) {
								R38cell15.setCellValue(
										BRF40.getR38_lessthan_30() == null ? 0 : BRF40.getR38_lessthan_30().intValue());
							}
							Cell R38cell16 = row23.getCell(25);
							if (R38cell16 != null) {
								R38cell16.setCellValue(BRF40.getR38_exclusive_90days() == null ? 0
										: BRF40.getR38_exclusive_90days().intValue());
							}

							Cell R38cell17 = row23.getCell(26);
							if (R38cell17 != null) {
								R38cell17.setCellValue(BRF40.getR38_exclusive_120days() == null ? 0
										: BRF40.getR38_exclusive_120days().intValue());
							}

							Cell R38cell18 = row23.getCell(27);
							if (R38cell18 != null) {
								R38cell18.setCellValue(BRF40.getR38_exclusive_180days() == null ? 0
										: BRF40.getR38_exclusive_180days().intValue());
							}

							Cell R38cell19 = row23.getCell(28);
							if (R38cell19 != null) {
								R38cell19.setCellValue(BRF40.getR38_exclusive_over_180days() == null ? 0
										: BRF40.getR38_exclusive_over_180days().intValue());
							}

							Cell R38cell20 = row23.getCell(31);
							if (R38cell20 != null) {
								R38cell20.setCellValue(
										BRF40.getR38_new_stage3() == null ? 0 : BRF40.getR38_new_stage3().intValue());
							}
							Cell R38cell21 = row23.getCell(32);
							if (R38cell21 != null) {
								R38cell21.setCellValue(BRF40.getR38_new_specific() == null ? 0
										: BRF40.getR38_new_specific().intValue());
							}
							/*Cell R38cell22 = row23.getCell(33);
							if (R38cell22 != null) {
								R38cell22.setCellValue(
										BRF40.getR38_new_other() == null ? 0 : BRF40.getR38_new_other().intValue());
							}*/

							Cell R38cell23 = row23.getCell(35);
							if (R38cell23 != null) {
								R38cell23.setCellValue(BRF40.getR38_performing_accounts() == null ? 0
										: BRF40.getR38_performing_accounts().intValue());
							}

							Cell R38cell24 = row23.getCell(36);
							if (R38cell24 != null) {
								R38cell24.setCellValue(BRF40.getR38_non_performing_accounts() == null ? 0
										: BRF40.getR38_non_performing_accounts().intValue());
							}
							/// row39
							Row row24= sheet.getRow(38);
							Cell R39cell = row24.getCell(3);
							if (R39cell != null) {
								R39cell.setCellValue(BRF40.getR39_outstanding_balance() == null ? 0
										: BRF40.getR39_outstanding_balance().intValue());
							}
							Cell R39cell1 = row24.getCell(7);
							if (R39cell1 != null) {
								R39cell1.setCellValue(BRF40.getR39_provision_suspense() == null ? 0
										: BRF40.getR39_provision_suspense().intValue());
							}
							Cell R39cell2 = row24.getCell(8);
							if (R39cell2 != null) {
								R39cell2.setCellValue(BRF40.getR39_stage3_provision() == null ? 0
										: BRF40.getR39_stage3_provision().intValue());
							}
							/*Cell R39cell3 = row24.getCell(9);
							if (R39cell3 != null) {
								R39cell3.setCellValue(BRF40.getR39_other_alloate() == null ? 0
										: BRF40.getR39_other_alloate().intValue());
							}*/
							Cell R39cell4 = row24.getCell(11);
							if (R39cell4 != null) {
								R39cell4.setCellValue(BRF40.getR39_1_asset() == null ? 0
										: BRF40.getR39_1_asset().intValue());
							}
							Cell R39cell5 = row24.getCell(12);
							if (R39cell5 != null) {
								R39cell5.setCellValue(BRF40.getR39_2_asset() == null ? 0
										: BRF40.getR39_2_asset().intValue());
							}
							Cell R39cell6 = row24.getCell(13);
							if (R39cell6 != null) {
								R39cell6.setCellValue(BRF40.getR39_3a_asset() == null ? 0
										: BRF40.getR39_3a_asset().intValue());
							}
							Cell R39cell7 = row24.getCell(14);
							if (R39cell7 != null) {
								R39cell7.setCellValue(BRF40.getR39_3b_asset() == null ? 0
										: BRF40.getR39_3b_asset().intValue());
							}
							Cell R39cell8 = row24.getCell(15);
							if (R39cell8 != null) {
								R39cell8.setCellValue(
										BRF40.getR39_3c_asset() == null ? 0 : BRF40.getR39_3c_asset().intValue());
							}
							Cell R39cell9 = row24.getCell(17);
							if (R39cell9 != null) {
								R39cell9.setCellValue(BRF40.getR39_1_provision() == null ? 0
										: BRF40.getR39_1_provision().intValue());
							}

							Cell R39cell10 = row24.getCell(18);
							if (R39cell10 != null) {
								R39cell10.setCellValue(BRF40.getR39_2_provision() == null ? 0
										: BRF40.getR39_2_provision().intValue());
							}
							Cell R39cell11 = row24.getCell(19);
							if (R39cell11 != null) {
								R39cell11.setCellValue(BRF40.getR39_3a_provision() == null ? 0
										: BRF40.getR39_3a_provision().intValue());
							}
							Cell R39cell12 = row24.getCell(20);
							if (R39cell12 != null) {
								R39cell12.setCellValue(BRF40.getR39_3b_provision() == null ? 0
										: BRF40.getR39_3b_provision().intValue());
							}
							Cell R39cell13 = row24.getCell(21);
							if (R39cell13 != null) {
								R39cell13.setCellValue(BRF40.getR39_3c_provision() == null ? 0
										: BRF40.getR39_3c_provision().intValue());
							}

							Cell R39cell14 = row24.getCell(23);
							if (R39cell14 != null) {
								R39cell14.setCellValue(
										BRF40.getR39_current() == null ? 0 : BRF40.getR39_current().intValue());
							}

							Cell R39cell15 = row24.getCell(24);
							if (R39cell15 != null) {
								R39cell15.setCellValue(
										BRF40.getR39_lessthan_30() == null ? 0 : BRF40.getR39_lessthan_30().intValue());
							}
							Cell R39cell16 = row24.getCell(25);
							if (R39cell16 != null) {
								R39cell16.setCellValue(BRF40.getR39_exclusive_90days() == null ? 0
										: BRF40.getR39_exclusive_90days().intValue());
							}

							Cell R39cell17 = row24.getCell(26);
							if (R39cell17 != null) {
								R39cell17.setCellValue(BRF40.getR39_exclusive_120days() == null ? 0
										: BRF40.getR39_exclusive_120days().intValue());
							}

							Cell R39cell18 = row24.getCell(27);
							if (R39cell18 != null) {
								R39cell18.setCellValue(BRF40.getR39_exclusive_180days() == null ? 0
										: BRF40.getR39_exclusive_180days().intValue());
							}

							Cell R39cell19 = row24.getCell(28);
							if (R39cell19 != null) {
								R39cell19.setCellValue(BRF40.getR39_exclusive_over_180days() == null ? 0
										: BRF40.getR39_exclusive_over_180days().intValue());
							}

							Cell R39cell20 = row24.getCell(31);
							if (R39cell20 != null) {
								R39cell20.setCellValue(
										BRF40.getR39_new_stage3() == null ? 0 : BRF40.getR39_new_stage3().intValue());
							}
							Cell R39cell21 = row24.getCell(32);
							if (R39cell21 != null) {
								R39cell21.setCellValue(BRF40.getR39_new_specific() == null ? 0
										: BRF40.getR39_new_specific().intValue());
							}
							/*Cell R39cell22 = row24.getCell(33);
							if (R39cell22 != null) {
								R39cell22.setCellValue(
										BRF40.getR39_new_other() == null ? 0 : BRF40.getR39_new_other().intValue());
							}*/

							Cell R39cell23 = row24.getCell(35);
							if (R39cell23 != null) {
								R39cell23.setCellValue(BRF40.getR39_performing_accounts() == null ? 0
										: BRF40.getR39_performing_accounts().intValue());
							}

							Cell R39cell24 = row24.getCell(36);
							if (R39cell24 != null) {
								R39cell24.setCellValue(BRF40.getR39_non_performing_accounts() == null ? 0
										: BRF40.getR39_non_performing_accounts().intValue());
							}
							/// row40
							Row row25= sheet.getRow(39);
							Cell R40cell = row25.getCell(3);
							if (R40cell != null) {
								R40cell.setCellValue(BRF40.getR40_outstanding_balance() == null ? 0
										: BRF40.getR40_outstanding_balance().intValue());
							}
							Cell R40cell1 = row25.getCell(7);
							if (R40cell1 != null) {
								R40cell1.setCellValue(BRF40.getR40_provision_suspense() == null ? 0
										: BRF40.getR40_provision_suspense().intValue());
							}
							Cell R40cell2 = row25.getCell(8);
							if (R40cell2 != null) {
								R40cell2.setCellValue(BRF40.getR40_stage3_provision() == null ? 0
										: BRF40.getR40_stage3_provision().intValue());
							}
							/*Cell R40cell3 = row25.getCell(9);
							if (R40cell3 != null) {
								R40cell3.setCellValue(BRF40.getR40_other_alloate() == null ? 0
										: BRF40.getR40_other_alloate().intValue());
							}*/
							Cell R40cell4 = row25.getCell(11);
							if (R40cell4 != null) {
								R40cell4.setCellValue(BRF40.getR40_1_asset() == null ? 0
										: BRF40.getR40_1_asset().intValue());
							}
							Cell R40cell5 = row25.getCell(12);
							if (R40cell5 != null) {
								R40cell5.setCellValue(BRF40.getR40_2_asset() == null ? 0
										: BRF40.getR40_2_asset().intValue());
							}
							Cell R40cell6 = row25.getCell(13);
							if (R40cell6 != null) {
								R40cell6.setCellValue(BRF40.getR40_3a_asset() == null ? 0
										: BRF40.getR40_3a_asset().intValue());
							}
							Cell R40cell7 = row25.getCell(14);
							if (R40cell7 != null) {
								R40cell7.setCellValue(BRF40.getR40_3b_asset() == null ? 0
										: BRF40.getR40_3b_asset().intValue());
							}
							Cell R40cell8 = row25.getCell(15);
							if (R40cell8 != null) {
								R40cell8.setCellValue(
										BRF40.getR40_3c_asset() == null ? 0 : BRF40.getR40_3c_asset().intValue());
							}
							Cell R40cell9 = row25.getCell(17);
							if (R40cell9 != null) {
								R40cell9.setCellValue(BRF40.getR40_1_provision() == null ? 0
										: BRF40.getR40_1_provision().intValue());
							}

							Cell R40cell10 = row25.getCell(18);
							if (R40cell10 != null) {
								R40cell10.setCellValue(BRF40.getR40_2_provision() == null ? 0
										: BRF40.getR40_2_provision().intValue());
							}
							Cell R40cell11 = row25.getCell(19);
							if (R40cell11 != null) {
								R40cell11.setCellValue(BRF40.getR40_3a_provision() == null ? 0
										: BRF40.getR40_3a_provision().intValue());
							}
							Cell R40cell12 = row25.getCell(20);
							if (R40cell12 != null) {
								R40cell12.setCellValue(BRF40.getR40_3b_provision() == null ? 0
										: BRF40.getR40_3b_provision().intValue());
							}
							Cell R40cell13 = row25.getCell(21);
							if (R40cell13 != null) {
								R40cell13.setCellValue(BRF40.getR40_3c_provision() == null ? 0
										: BRF40.getR40_3c_provision().intValue());
							}

							Cell R40cell14 = row25.getCell(23);
							if (R40cell14 != null) {
								R40cell14.setCellValue(
										BRF40.getR40_current() == null ? 0 : BRF40.getR40_current().intValue());
							}

							Cell R40cell15 = row25.getCell(24);
							if (R40cell15 != null) {
								R40cell15.setCellValue(
										BRF40.getR40_lessthan_30() == null ? 0 : BRF40.getR40_lessthan_30().intValue());
							}
							Cell R40cell16 = row25.getCell(25);
							if (R40cell16 != null) {
								R40cell16.setCellValue(BRF40.getR40_exclusive_90days() == null ? 0
										: BRF40.getR40_exclusive_90days().intValue());
							}

							Cell R40cell17 = row25.getCell(26);
							if (R40cell17 != null) {
								R40cell17.setCellValue(BRF40.getR40_exclusive_120days() == null ? 0
										: BRF40.getR40_exclusive_120days().intValue());
							}

							Cell R40cell18 = row25.getCell(27);
							if (R40cell18 != null) {
								R40cell18.setCellValue(BRF40.getR40_exclusive_180days() == null ? 0
										: BRF40.getR40_exclusive_180days().intValue());
							}

							Cell R40cell19 = row25.getCell(28);
							if (R40cell19 != null) {
								R40cell19.setCellValue(BRF40.getR40_exclusive_over_180days() == null ? 0
										: BRF40.getR40_exclusive_over_180days().intValue());
							}

							Cell R40cell20 = row25.getCell(31);
							if (R40cell20 != null) {
								R40cell20.setCellValue(
										BRF40.getR40_new_stage3() == null ? 0 : BRF40.getR40_new_stage3().intValue());
							}
							Cell R40cell21 = row25.getCell(32);
							if (R40cell21 != null) {
								R40cell21.setCellValue(BRF40.getR40_new_specific() == null ? 0
										: BRF40.getR40_new_specific().intValue());
							}
							/*Cell R40cell22 = row25.getCell(33);
							if (R40cell22 != null) {
								R40cell22.setCellValue(
										BRF40.getR40_new_other() == null ? 0 : BRF40.getR40_new_other().intValue());
							}*/

							Cell R40cell23 = row25.getCell(35);
							if (R40cell23 != null) {
								R40cell23.setCellValue(BRF40.getR40_performing_accounts() == null ? 0
										: BRF40.getR40_performing_accounts().intValue());
							}

							Cell R40cell24 = row25.getCell(36);
							if (R40cell24 != null) {
								R40cell24.setCellValue(BRF40.getR40_non_performing_accounts() == null ? 0
										: BRF40.getR40_non_performing_accounts().intValue());
							}
						}
					}
					if (T1Master1.size() == 1) {
						for (BRF40_Entity2 BRF40a : T1Master1) {
							
							/// row42
							Row row26= sheet.getRow(41);
							Cell R42cell = row26.getCell(3);
							if (R42cell != null) {
								R42cell.setCellValue(BRF40a.getR42_outstanding_balance() == null ? 0
										: BRF40a.getR42_outstanding_balance().intValue());
							}
							Cell R42cell1 = row26.getCell(7);
							if (R42cell1 != null) {
								R42cell1.setCellValue(BRF40a.getR42_provision_suspense() == null ? 0
										: BRF40a.getR42_provision_suspense().intValue());
							}
							Cell R42cell2 = row26.getCell(8);
							if (R42cell2 != null) {
								R42cell2.setCellValue(BRF40a.getR42_stage3_provision() == null ? 0
										: BRF40a.getR42_stage3_provision().intValue());
							}
							/*Cell R42cell3 = row26.getCell(9);
							if (R42cell3 != null) {
								R42cell3.setCellValue(BRF40a.getR42_other_alloate() == null ? 0
										: BRF40a.getR42_other_alloate().intValue());
							}*/
							Cell R42cell4 = row26.getCell(11);
							if (R42cell4 != null) {
								R42cell4.setCellValue(BRF40a.getR42_1_asset() == null ? 0
										: BRF40a.getR42_1_asset().intValue());
							}
							Cell R42cell5 = row26.getCell(12);
							if (R42cell5 != null) {
								R42cell5.setCellValue(BRF40a.getR42_2_asset() == null ? 0
										: BRF40a.getR42_2_asset().intValue());
							}
							Cell R42cell6 = row26.getCell(13);
							if (R42cell6 != null) {
								R42cell6.setCellValue(BRF40a.getR42_3a_asset() == null ? 0
										: BRF40a.getR42_3a_asset().intValue());
							}
							Cell R42cell7 = row26.getCell(14);
							if (R42cell7 != null) {
								R42cell7.setCellValue(BRF40a.getR42_3b_asset() == null ? 0
										: BRF40a.getR42_3b_asset().intValue());
							}
							Cell R42cell8 = row26.getCell(15);
							if (R42cell8 != null) {
								R42cell8.setCellValue(
										BRF40a.getR42_3c_asset() == null ? 0 : BRF40a.getR42_3c_asset().intValue());
							}
							Cell R42cell9 = row26.getCell(17);
							if (R42cell9 != null) {
								R42cell9.setCellValue(BRF40a.getR42_1_provision() == null ? 0
										: BRF40a.getR42_1_provision().intValue());
							}

							Cell R42cell10 = row26.getCell(18);
							if (R42cell10 != null) {
								R42cell10.setCellValue(BRF40a.getR42_2_provision() == null ? 0
										: BRF40a.getR42_2_provision().intValue());
							}
							Cell R42cell11 = row26.getCell(19);
							if (R42cell11 != null) {
								R42cell11.setCellValue(BRF40a.getR42_3a_provision() == null ? 0
										: BRF40a.getR42_3a_provision().intValue());
							}
							Cell R42cell12 = row26.getCell(20);
							if (R42cell12 != null) {
								R42cell12.setCellValue(BRF40a.getR42_3b_provision() == null ? 0
										: BRF40a.getR42_3b_provision().intValue());
							}
							Cell R42cell13 = row26.getCell(21);
							if (R42cell13 != null) {
								R42cell13.setCellValue(BRF40a.getR42_3c_provision() == null ? 0
										: BRF40a.getR42_3c_provision().intValue());
							}

							Cell R42cell14 = row26.getCell(23);
							if (R42cell14 != null) {
								R42cell14.setCellValue(
										BRF40a.getR42_current() == null ? 0 : BRF40a.getR42_current().intValue());
							}

							Cell R42cell15 = row26.getCell(24);
							if (R42cell15 != null) {
								R42cell15.setCellValue(
										BRF40a.getR42_lessthan_30() == null ? 0 : BRF40a.getR42_lessthan_30().intValue());
							}
							Cell R42cell16 = row26.getCell(25);
							if (R42cell16 != null) {
								R42cell16.setCellValue(BRF40a.getR42_exclusive_90days() == null ? 0
										: BRF40a.getR42_exclusive_90days().intValue());
							}

							Cell R42cell17 = row26.getCell(26);
							if (R42cell17 != null) {
								R42cell17.setCellValue(BRF40a.getR42_exclusive_120days() == null ? 0
										: BRF40a.getR42_exclusive_120days().intValue());
							}

							Cell R42cell18 = row26.getCell(27);
							if (R42cell18 != null) {
								R42cell18.setCellValue(BRF40a.getR42_exclusive_180days() == null ? 0
										: BRF40a.getR42_exclusive_180days().intValue());
							}

							Cell R42cell19 = row26.getCell(28);
							if (R42cell19 != null) {
								R42cell19.setCellValue(BRF40a.getR42_exclusive_over_180days() == null ? 0
										: BRF40a.getR42_exclusive_over_180days().intValue());
							}

							Cell R42cell20 = row26.getCell(31);
							if (R42cell20 != null) {
								R42cell20.setCellValue(
										BRF40a.getR42_new_stage3() == null ? 0 : BRF40a.getR42_new_stage3().intValue());
							}
							Cell R42cell21 = row26.getCell(32);
							if (R42cell21 != null) {
								R42cell21.setCellValue(BRF40a.getR42_new_specific() == null ? 0
										: BRF40a.getR42_new_specific().intValue());
							}
							/*Cell R42cell22 = row26.getCell(33);
							if (R42cell22 != null) {
								R42cell22.setCellValue(
										BRF40a.getR42_new_other() == null ? 0 : BRF40a.getR42_new_other().intValue());
							}*/

							Cell R42cell23 = row26.getCell(35);
							if (R42cell23 != null) {
								R42cell23.setCellValue(BRF40a.getR42_performing_accounts() == null ? 0
										: BRF40a.getR42_performing_accounts().intValue());
							}

							Cell R42cell24 = row26.getCell(36);
							if (R42cell24 != null) {
								R42cell24.setCellValue(BRF40a.getR42_non_performing_accounts() == null ? 0
										: BRF40a.getR42_non_performing_accounts().intValue());
							}
							/// row43
							Row row27= sheet.getRow(42);
							Cell R43cell = row27.getCell(3);
							if (R43cell != null) {
								R43cell.setCellValue(BRF40a.getR43_outstanding_balance() == null ? 0
										: BRF40a.getR43_outstanding_balance().intValue());
							}
							Cell R43cell1 = row27.getCell(7);
							if (R43cell1 != null) {
								R43cell1.setCellValue(BRF40a.getR43_provision_suspense() == null ? 0
										: BRF40a.getR43_provision_suspense().intValue());
							}
							Cell R43cell2 = row27.getCell(8);
							if (R43cell2 != null) {
								R43cell2.setCellValue(BRF40a.getR43_stage3_provision() == null ? 0
										: BRF40a.getR43_stage3_provision().intValue());
							}
							/*Cell R43cell3 = row27.getCell(9);
							if (R43cell3 != null) {
								R43cell3.setCellValue(BRF40a.getR43_other_alloate() == null ? 0
										: BRF40a.getR43_other_alloate().intValue());
							}*/
							Cell R43cell4 = row27.getCell(11);
							if (R43cell4 != null) {
								R43cell4.setCellValue(BRF40a.getR43_1_asset() == null ? 0
										: BRF40a.getR43_1_asset().intValue());
							}
							Cell R43cell5 = row27.getCell(12);
							if (R43cell5 != null) {
								R43cell5.setCellValue(BRF40a.getR43_2_asset() == null ? 0
										: BRF40a.getR43_2_asset().intValue());
							}
							Cell R43cell6 = row27.getCell(13);
							if (R43cell6 != null) {
								R43cell6.setCellValue(BRF40a.getR43_3a_asset() == null ? 0
										: BRF40a.getR43_3a_asset().intValue());
							}
							Cell R43cell7 = row27.getCell(14);
							if (R43cell7 != null) {
								R43cell7.setCellValue(BRF40a.getR43_3b_asset() == null ? 0
										: BRF40a.getR43_3b_asset().intValue());
							}
							Cell R43cell8 = row27.getCell(15);
							if (R43cell8 != null) {
								R43cell8.setCellValue(
										BRF40a.getR43_3c_asset() == null ? 0 : BRF40a.getR43_3c_asset().intValue());
							}
							Cell R43cell9 = row27.getCell(17);
							if (R43cell9 != null) {
								R43cell9.setCellValue(BRF40a.getR43_1_provision() == null ? 0
										: BRF40a.getR43_1_provision().intValue());
							}

							Cell R43cell10 = row27.getCell(18);
							if (R43cell10 != null) {
								R43cell10.setCellValue(BRF40a.getR43_2_provision() == null ? 0
										: BRF40a.getR43_2_provision().intValue());
							}
							Cell R43cell11 = row27.getCell(19);
							if (R43cell11 != null) {
								R43cell11.setCellValue(BRF40a.getR43_3a_provision() == null ? 0
										: BRF40a.getR43_3a_provision().intValue());
							}
							Cell R43cell12 = row27.getCell(20);
							if (R43cell12 != null) {
								R43cell12.setCellValue(BRF40a.getR43_3b_provision() == null ? 0
										: BRF40a.getR43_3b_provision().intValue());
							}
							Cell R43cell13 = row27.getCell(21);
							if (R43cell13 != null) {
								R43cell13.setCellValue(BRF40a.getR43_3c_provision() == null ? 0
										: BRF40a.getR43_3c_provision().intValue());
							}

							Cell R43cell14 = row27.getCell(23);
							if (R43cell14 != null) {
								R43cell14.setCellValue(
										BRF40a.getR43_current() == null ? 0 : BRF40a.getR43_current().intValue());
							}

							Cell R43cell15 = row27.getCell(24);
							if (R43cell15 != null) {
								R43cell15.setCellValue(
										BRF40a.getR43_lessthan_30() == null ? 0 : BRF40a.getR43_lessthan_30().intValue());
							}
							Cell R43cell16 = row27.getCell(25);
							if (R43cell16 != null) {
								R43cell16.setCellValue(BRF40a.getR43_exclusive_90days() == null ? 0
										: BRF40a.getR43_exclusive_90days().intValue());
							}

							Cell R43cell17 = row27.getCell(26);
							if (R43cell17 != null) {
								R43cell17.setCellValue(BRF40a.getR43_exclusive_120days() == null ? 0
										: BRF40a.getR43_exclusive_120days().intValue());
							}

							Cell R43cell18 = row27.getCell(27);
							if (R43cell18 != null) {
								R43cell18.setCellValue(BRF40a.getR43_exclusive_180days() == null ? 0
										: BRF40a.getR43_exclusive_180days().intValue());
							}

							Cell R43cell19 = row27.getCell(28);
							if (R43cell19 != null) {
								R43cell19.setCellValue(BRF40a.getR43_exclusive_over_180days() == null ? 0
										: BRF40a.getR43_exclusive_over_180days().intValue());
							}

							Cell R43cell20 = row27.getCell(31);
							if (R43cell20 != null) {
								R43cell20.setCellValue(
										BRF40a.getR43_new_stage3() == null ? 0 : BRF40a.getR43_new_stage3().intValue());
							}
							Cell R43cell21 = row27.getCell(32);
							if (R43cell21 != null) {
								R43cell21.setCellValue(BRF40a.getR43_new_specific() == null ? 0
										: BRF40a.getR43_new_specific().intValue());
							}
							/*Cell R43cell22 = row27.getCell(33);
							if (R43cell22 != null) {
								R43cell22.setCellValue(
										BRF40a.getR43_new_other() == null ? 0 : BRF40a.getR43_new_other().intValue());
							}*/

							Cell R43cell23 = row27.getCell(35);
							if (R43cell23 != null) {
								R43cell23.setCellValue(BRF40a.getR43_performing_accounts() == null ? 0
										: BRF40a.getR43_performing_accounts().intValue());
							}

							Cell R43cell24 = row27.getCell(36);
							if (R43cell24 != null) {
								R43cell24.setCellValue(BRF40a.getR43_non_performing_accounts() == null ? 0
										: BRF40a.getR43_non_performing_accounts().intValue());
							}
							/// row44
							Row row28= sheet.getRow(43);
							Cell R44cell = row28.getCell(3);
							if (R44cell != null) {
								R44cell.setCellValue(BRF40a.getR44_outstanding_balance() == null ? 0
										: BRF40a.getR44_outstanding_balance().intValue());
							}
							Cell R44cell1 = row28.getCell(7);
							if (R44cell1 != null) {
								R44cell1.setCellValue(BRF40a.getR44_provision_suspense() == null ? 0
										: BRF40a.getR44_provision_suspense().intValue());
							}
							Cell R44cell2 = row28.getCell(8);
							if (R44cell2 != null) {
								R44cell2.setCellValue(BRF40a.getR44_stage3_provision() == null ? 0
										: BRF40a.getR44_stage3_provision().intValue());
							}
							/*Cell R44cell3 = row28.getCell(9);
							if (R44cell3 != null) {
								R44cell3.setCellValue(BRF40a.getR44_other_alloate() == null ? 0
										: BRF40a.getR44_other_alloate().intValue());
							}*/
							Cell R44cell4 = row28.getCell(11);
							if (R44cell4 != null) {
								R44cell4.setCellValue(BRF40a.getR44_1_asset() == null ? 0
										: BRF40a.getR44_1_asset().intValue());
							}
							Cell R44cell5 = row28.getCell(12);
							if (R44cell5 != null) {
								R44cell5.setCellValue(BRF40a.getR44_2_asset() == null ? 0
										: BRF40a.getR44_2_asset().intValue());
							}
							Cell R44cell6 = row28.getCell(13);
							if (R44cell6 != null) {
								R44cell6.setCellValue(BRF40a.getR44_3a_asset() == null ? 0
										: BRF40a.getR44_3a_asset().intValue());
							}
							Cell R44cell7 = row28.getCell(14);
							if (R44cell7 != null) {
								R44cell7.setCellValue(BRF40a.getR44_3b_asset() == null ? 0
										: BRF40a.getR44_3b_asset().intValue());
							}
							Cell R44cell8 = row28.getCell(15);
							if (R44cell8 != null) {
								R44cell8.setCellValue(
										BRF40a.getR44_3c_asset() == null ? 0 : BRF40a.getR44_3c_asset().intValue());
							}
							Cell R44cell9 = row28.getCell(17);
							if (R44cell9 != null) {
								R44cell9.setCellValue(BRF40a.getR44_1_provision() == null ? 0
										: BRF40a.getR44_1_provision().intValue());
							}

							Cell R44cell10 = row28.getCell(18);
							if (R44cell10 != null) {
								R44cell10.setCellValue(BRF40a.getR44_2_provision() == null ? 0
										: BRF40a.getR44_2_provision().intValue());
							}
							Cell R44cell11 = row28.getCell(19);
							if (R44cell11 != null) {
								R44cell11.setCellValue(BRF40a.getR44_3a_provision() == null ? 0
										: BRF40a.getR44_3a_provision().intValue());
							}
							Cell R44cell12 = row28.getCell(20);
							if (R44cell12 != null) {
								R44cell12.setCellValue(BRF40a.getR44_3b_provision() == null ? 0
										: BRF40a.getR44_3b_provision().intValue());
							}
							Cell R44cell13 = row28.getCell(21);
							if (R44cell13 != null) {
								R44cell13.setCellValue(BRF40a.getR44_3c_provision() == null ? 0
										: BRF40a.getR44_3c_provision().intValue());
							}

							Cell R44cell14 = row28.getCell(23);
							if (R44cell14 != null) {
								R44cell14.setCellValue(
										BRF40a.getR44_current() == null ? 0 : BRF40a.getR44_current().intValue());
							}

							Cell R44cell15 = row28.getCell(24);
							if (R44cell15 != null) {
								R44cell15.setCellValue(
										BRF40a.getR44_lessthan_30() == null ? 0 : BRF40a.getR44_lessthan_30().intValue());
							}
							Cell R44cell16 = row28.getCell(25);
							if (R44cell16 != null) {
								R44cell16.setCellValue(BRF40a.getR44_exclusive_90days() == null ? 0
										: BRF40a.getR44_exclusive_90days().intValue());
							}

							Cell R44cell17 = row28.getCell(26);
							if (R44cell17 != null) {
								R44cell17.setCellValue(BRF40a.getR44_exclusive_120days() == null ? 0
										: BRF40a.getR44_exclusive_120days().intValue());
							}

							Cell R44cell18 = row28.getCell(27);
							if (R44cell18 != null) {
								R44cell18.setCellValue(BRF40a.getR44_exclusive_180days() == null ? 0
										: BRF40a.getR44_exclusive_180days().intValue());
							}

							Cell R44cell19 = row28.getCell(28);
							if (R44cell19 != null) {
								R44cell19.setCellValue(BRF40a.getR44_exclusive_over_180days() == null ? 0
										: BRF40a.getR44_exclusive_over_180days().intValue());
							}

							Cell R44cell20 = row28.getCell(31);
							if (R44cell20 != null) {
								R44cell20.setCellValue(
										BRF40a.getR44_new_stage3() == null ? 0 : BRF40a.getR44_new_stage3().intValue());
							}
							Cell R44cell21 = row28.getCell(32);
							if (R44cell21 != null) {
								R44cell21.setCellValue(BRF40a.getR44_new_specific() == null ? 0
										: BRF40a.getR44_new_specific().intValue());
							}
							/*Cell R44cell22 = row28.getCell(33);
							if (R44cell22 != null) {
								R44cell22.setCellValue(
										BRF40a.getR44_new_other() == null ? 0 : BRF40a.getR44_new_other().intValue());
							}*/

							Cell R44cell23 = row28.getCell(35);
							if (R44cell23 != null) {
								R44cell23.setCellValue(BRF40a.getR44_performing_accounts() == null ? 0
										: BRF40a.getR44_performing_accounts().intValue());
							}

							Cell R44cell24 = row28.getCell(36);
							if (R44cell24 != null) {
								R44cell24.setCellValue(BRF40a.getR44_non_performing_accounts() == null ? 0
										: BRF40a.getR44_non_performing_accounts().intValue());
							}
							/// row45
							Row row29= sheet.getRow(44);
							Cell R45cell = row29.getCell(3);
							if (R45cell != null) {
								R45cell.setCellValue(BRF40a.getR45_outstanding_balance() == null ? 0
										: BRF40a.getR45_outstanding_balance().intValue());
							}
							Cell R45cell1 = row29.getCell(7);
							if (R45cell1 != null) {
								R45cell1.setCellValue(BRF40a.getR45_provision_suspense() == null ? 0
										: BRF40a.getR45_provision_suspense().intValue());
							}
							Cell R45cell2 = row29.getCell(8);
							if (R45cell2 != null) {
								R45cell2.setCellValue(BRF40a.getR45_stage3_provision() == null ? 0
										: BRF40a.getR45_stage3_provision().intValue());
							}
							/*Cell R45cell3 = row29.getCell(9);
							if (R45cell3 != null) {
								R45cell3.setCellValue(BRF40a.getR45_other_alloate() == null ? 0
										: BRF40a.getR45_other_alloate().intValue());
							}*/
							Cell R45cell4 = row29.getCell(11);
							if (R45cell4 != null) {
								R45cell4.setCellValue(BRF40a.getR45_1_asset() == null ? 0
										: BRF40a.getR45_1_asset().intValue());
							}
							Cell R45cell5 = row29.getCell(12);
							if (R45cell5 != null) {
								R45cell5.setCellValue(BRF40a.getR45_2_asset() == null ? 0
										: BRF40a.getR45_2_asset().intValue());
							}
							Cell R45cell6 = row29.getCell(13);
							if (R45cell6 != null) {
								R45cell6.setCellValue(BRF40a.getR45_3a_asset() == null ? 0
										: BRF40a.getR45_3a_asset().intValue());
							}
							Cell R45cell7 = row29.getCell(14);
							if (R45cell7 != null) {
								R45cell7.setCellValue(BRF40a.getR45_3b_asset() == null ? 0
										: BRF40a.getR45_3b_asset().intValue());
							}
							Cell R45cell8 = row29.getCell(15);
							if (R45cell8 != null) {
								R45cell8.setCellValue(
										BRF40a.getR45_3c_asset() == null ? 0 : BRF40a.getR45_3c_asset().intValue());
							}
							Cell R45cell9 = row29.getCell(17);
							if (R45cell9 != null) {
								R45cell9.setCellValue(BRF40a.getR45_1_provision() == null ? 0
										: BRF40a.getR45_1_provision().intValue());
							}

							Cell R45cell10 = row29.getCell(18);
							if (R45cell10 != null) {
								R45cell10.setCellValue(BRF40a.getR45_2_provision() == null ? 0
										: BRF40a.getR45_2_provision().intValue());
							}
							Cell R45cell11 = row29.getCell(19);
							if (R45cell11 != null) {
								R45cell11.setCellValue(BRF40a.getR45_3a_provision() == null ? 0
										: BRF40a.getR45_3a_provision().intValue());
							}
							Cell R45cell12 = row29.getCell(20);
							if (R45cell12 != null) {
								R45cell12.setCellValue(BRF40a.getR45_3b_provision() == null ? 0
										: BRF40a.getR45_3b_provision().intValue());
							}
							Cell R45cell13 = row29.getCell(21);
							if (R45cell13 != null) {
								R45cell13.setCellValue(BRF40a.getR45_3c_provision() == null ? 0
										: BRF40a.getR45_3c_provision().intValue());
							}

							Cell R45cell14 = row29.getCell(23);
							if (R45cell14 != null) {
								R45cell14.setCellValue(
										BRF40a.getR45_current() == null ? 0 : BRF40a.getR45_current().intValue());
							}

							Cell R45cell15 = row29.getCell(24);
							if (R45cell15 != null) {
								R45cell15.setCellValue(
										BRF40a.getR45_lessthan_30() == null ? 0 : BRF40a.getR45_lessthan_30().intValue());
							}
							Cell R45cell16 = row29.getCell(25);
							if (R45cell16 != null) {
								R45cell16.setCellValue(BRF40a.getR45_exclusive_90days() == null ? 0
										: BRF40a.getR45_exclusive_90days().intValue());
							}

							Cell R45cell17 = row29.getCell(26);
							if (R45cell17 != null) {
								R45cell17.setCellValue(BRF40a.getR45_exclusive_120days() == null ? 0
										: BRF40a.getR45_exclusive_120days().intValue());
							}

							Cell R45cell18 = row29.getCell(27);
							if (R45cell18 != null) {
								R45cell18.setCellValue(BRF40a.getR45_exclusive_180days() == null ? 0
										: BRF40a.getR45_exclusive_180days().intValue());
							}

							Cell R45cell19 = row29.getCell(28);
							if (R45cell19 != null) {
								R45cell19.setCellValue(BRF40a.getR45_exclusive_over_180days() == null ? 0
										: BRF40a.getR45_exclusive_over_180days().intValue());
							}

							Cell R45cell20 = row29.getCell(31);
							if (R45cell20 != null) {
								R45cell20.setCellValue(
										BRF40a.getR45_new_stage3() == null ? 0 : BRF40a.getR45_new_stage3().intValue());
							}
							Cell R45cell21 = row29.getCell(32);
							if (R45cell21 != null) {
								R45cell21.setCellValue(BRF40a.getR45_new_specific() == null ? 0
										: BRF40a.getR45_new_specific().intValue());
							}
							/*Cell R45cell22 = row29.getCell(33);
							if (R45cell22 != null) {
								R45cell22.setCellValue(
										BRF40a.getR45_new_other() == null ? 0 : BRF40a.getR45_new_other().intValue());
							}*/

							Cell R45cell23 = row29.getCell(35);
							if (R45cell23 != null) {
								R45cell23.setCellValue(BRF40a.getR45_performing_accounts() == null ? 0
										: BRF40a.getR45_performing_accounts().intValue());
							}

							Cell R45cell24 = row29.getCell(36);
							if (R45cell24 != null) {
								R45cell24.setCellValue(BRF40a.getR45_non_performing_accounts() == null ? 0
										: BRF40a.getR45_non_performing_accounts().intValue());
							}
							/// row46
							Row row30= sheet.getRow(45);
							Cell R46cell = row30.getCell(3);
							if (R46cell != null) {
								R46cell.setCellValue(BRF40a.getR46_outstanding_balance() == null ? 0
										: BRF40a.getR46_outstanding_balance().intValue());
							}
							Cell R46cell1 = row30.getCell(7);
							if (R46cell1 != null) {
								R46cell1.setCellValue(BRF40a.getR46_provision_suspense() == null ? 0
										: BRF40a.getR46_provision_suspense().intValue());
							}
							Cell R46cell2 = row30.getCell(8);
							if (R46cell2 != null) {
								R46cell2.setCellValue(BRF40a.getR46_stage3_provision() == null ? 0
										: BRF40a.getR46_stage3_provision().intValue());
							}
							/*Cell R46cell3 = row30.getCell(9);
							if (R46cell3 != null) {
								R46cell3.setCellValue(BRF40a.getR46_other_alloate() == null ? 0
										: BRF40a.getR46_other_alloate().intValue());
							}*/
							Cell R46cell4 = row30.getCell(11);
							if (R46cell4 != null) {
								R46cell4.setCellValue(BRF40a.getR46_1_asset() == null ? 0
										: BRF40a.getR46_1_asset().intValue());
							}
							Cell R46cell5 = row30.getCell(12);
							if (R46cell5 != null) {
								R46cell5.setCellValue(BRF40a.getR46_2_asset() == null ? 0
										: BRF40a.getR46_2_asset().intValue());
							}
							Cell R46cell6 = row30.getCell(13);
							if (R46cell6 != null) {
								R46cell6.setCellValue(BRF40a.getR46_3a_asset() == null ? 0
										: BRF40a.getR46_3a_asset().intValue());
							}
							Cell R46cell7 = row30.getCell(14);
							if (R46cell7 != null) {
								R46cell7.setCellValue(BRF40a.getR46_3b_asset() == null ? 0
										: BRF40a.getR46_3b_asset().intValue());
							}
							Cell R46cell8 = row30.getCell(15);
							if (R46cell8 != null) {
								R46cell8.setCellValue(
										BRF40a.getR46_3c_asset() == null ? 0 : BRF40a.getR46_3c_asset().intValue());
							}
							Cell R46cell9 = row30.getCell(17);
							if (R46cell9 != null) {
								R46cell9.setCellValue(BRF40a.getR46_1_provision() == null ? 0
										: BRF40a.getR46_1_provision().intValue());
							}

							Cell R46cell10 = row30.getCell(18);
							if (R46cell10 != null) {
								R46cell10.setCellValue(BRF40a.getR46_2_provision() == null ? 0
										: BRF40a.getR46_2_provision().intValue());
							}
							Cell R46cell11 = row30.getCell(19);
							if (R46cell11 != null) {
								R46cell11.setCellValue(BRF40a.getR46_3a_provision() == null ? 0
										: BRF40a.getR46_3a_provision().intValue());
							}
							Cell R46cell12 = row30.getCell(20);
							if (R46cell12 != null) {
								R46cell12.setCellValue(BRF40a.getR46_3b_provision() == null ? 0
										: BRF40a.getR46_3b_provision().intValue());
							}
							Cell R46cell13 = row30.getCell(21);
							if (R46cell13 != null) {
								R46cell13.setCellValue(BRF40a.getR46_3c_provision() == null ? 0
										: BRF40a.getR46_3c_provision().intValue());
							}

							Cell R46cell14 = row30.getCell(23);
							if (R46cell14 != null) {
								R46cell14.setCellValue(
										BRF40a.getR46_current() == null ? 0 : BRF40a.getR46_current().intValue());
							}

							Cell R46cell15 = row30.getCell(24);
							if (R46cell15 != null) {
								R46cell15.setCellValue(
										BRF40a.getR46_lessthan_30() == null ? 0 : BRF40a.getR46_lessthan_30().intValue());
							}
							Cell R46cell16 = row30.getCell(25);
							if (R46cell16 != null) {
								R46cell16.setCellValue(BRF40a.getR46_exclusive_90days() == null ? 0
										: BRF40a.getR46_exclusive_90days().intValue());
							}

							Cell R46cell17 = row30.getCell(26);
							if (R46cell17 != null) {
								R46cell17.setCellValue(BRF40a.getR46_exclusive_120days() == null ? 0
										: BRF40a.getR46_exclusive_120days().intValue());
							}

							Cell R46cell18 = row30.getCell(27);
							if (R46cell18 != null) {
								R46cell18.setCellValue(BRF40a.getR46_exclusive_180days() == null ? 0
										: BRF40a.getR46_exclusive_180days().intValue());
							}

							Cell R46cell19 = row30.getCell(28);
							if (R46cell19 != null) {
								R46cell19.setCellValue(BRF40a.getR46_exclusive_over_180days() == null ? 0
										: BRF40a.getR46_exclusive_over_180days().intValue());
							}

							Cell R46cell20 = row30.getCell(31);
							if (R46cell20 != null) {
								R46cell20.setCellValue(
										BRF40a.getR46_new_stage3() == null ? 0 : BRF40a.getR46_new_stage3().intValue());
							}
							Cell R46cell21 = row30.getCell(32);
							if (R46cell21 != null) {
								R46cell21.setCellValue(BRF40a.getR46_new_specific() == null ? 0
										: BRF40a.getR46_new_specific().intValue());
							}
							/*Cell R46cell22 = row30.getCell(33);
							if (R46cell22 != null) {
								R46cell22.setCellValue(
										BRF40a.getR46_new_other() == null ? 0 : BRF40a.getR46_new_other().intValue());
							}*/

							Cell R46cell23 = row30.getCell(35);
							if (R46cell23 != null) {
								R46cell23.setCellValue(BRF40a.getR46_performing_accounts() == null ? 0
										: BRF40a.getR46_performing_accounts().intValue());
							}

							Cell R46cell24 = row30.getCell(36);
							if (R46cell24 != null) {
								R46cell24.setCellValue(BRF40a.getR46_non_performing_accounts() == null ? 0
										: BRF40a.getR46_non_performing_accounts().intValue());
							}
							/// row47
							Row row31= sheet.getRow(46);
							Cell R47cell = row31.getCell(3);
							if (R47cell != null) {
								R47cell.setCellValue(BRF40a.getR47_outstanding_balance() == null ? 0
										: BRF40a.getR47_outstanding_balance().intValue());
							}
							Cell R47cell1 = row31.getCell(7);
							if (R47cell1 != null) {
								R47cell1.setCellValue(BRF40a.getR47_provision_suspense() == null ? 0
										: BRF40a.getR47_provision_suspense().intValue());
							}
							Cell R47cell2 = row31.getCell(8);
							if (R47cell2 != null) {
								R47cell2.setCellValue(BRF40a.getR47_stage3_provision() == null ? 0
										: BRF40a.getR47_stage3_provision().intValue());
							}
							/*Cell R47cell3 = row31.getCell(9);
							if (R47cell3 != null) {
								R47cell3.setCellValue(BRF40a.getR47_other_alloate() == null ? 0
										: BRF40a.getR47_other_alloate().intValue());
							}*/
							Cell R47cell4 = row31.getCell(11);
							if (R47cell4 != null) {
								R47cell4.setCellValue(BRF40a.getR47_1_asset() == null ? 0
										: BRF40a.getR47_1_asset().intValue());
							}
							Cell R47cell5 = row31.getCell(12);
							if (R47cell5 != null) {
								R47cell5.setCellValue(BRF40a.getR47_2_asset() == null ? 0
										: BRF40a.getR47_2_asset().intValue());
							}
							Cell R47cell6 = row31.getCell(13);
							if (R47cell6 != null) {
								R47cell6.setCellValue(BRF40a.getR47_3a_asset() == null ? 0
										: BRF40a.getR47_3a_asset().intValue());
							}
							Cell R47cell7 = row31.getCell(14);
							if (R47cell7 != null) {
								R47cell7.setCellValue(BRF40a.getR47_3b_asset() == null ? 0
										: BRF40a.getR47_3b_asset().intValue());
							}
							Cell R47cell8 = row31.getCell(15);
							if (R47cell8 != null) {
								R47cell8.setCellValue(
										BRF40a.getR47_3c_asset() == null ? 0 : BRF40a.getR47_3c_asset().intValue());
							}
							Cell R47cell9 = row31.getCell(17);
							if (R47cell9 != null) {
								R47cell9.setCellValue(BRF40a.getR47_1_provision() == null ? 0
										: BRF40a.getR47_1_provision().intValue());
							}

							Cell R47cell10 = row31.getCell(18);
							if (R47cell10 != null) {
								R47cell10.setCellValue(BRF40a.getR47_2_provision() == null ? 0
										: BRF40a.getR47_2_provision().intValue());
							}
							Cell R47cell11 = row31.getCell(19);
							if (R47cell11 != null) {
								R47cell11.setCellValue(BRF40a.getR47_3a_provision() == null ? 0
										: BRF40a.getR47_3a_provision().intValue());
							}
							Cell R47cell12 = row31.getCell(20);
							if (R47cell12 != null) {
								R47cell12.setCellValue(BRF40a.getR47_3b_provision() == null ? 0
										: BRF40a.getR47_3b_provision().intValue());
							}
							Cell R47cell13 = row31.getCell(21);
							if (R47cell13 != null) {
								R47cell13.setCellValue(BRF40a.getR47_3c_provision() == null ? 0
										: BRF40a.getR47_3c_provision().intValue());
							}

							Cell R47cell14 = row31.getCell(23);
							if (R47cell14 != null) {
								R47cell14.setCellValue(
										BRF40a.getR47_current() == null ? 0 : BRF40a.getR47_current().intValue());
							}

							Cell R47cell15 = row31.getCell(24);
							if (R47cell15 != null) {
								R47cell15.setCellValue(
										BRF40a.getR47_lessthan_30() == null ? 0 : BRF40a.getR47_lessthan_30().intValue());
							}
							Cell R47cell16 = row31.getCell(25);
							if (R47cell16 != null) {
								R47cell16.setCellValue(BRF40a.getR47_exclusive_90days() == null ? 0
										: BRF40a.getR47_exclusive_90days().intValue());
							}

							Cell R47cell17 = row31.getCell(26);
							if (R47cell17 != null) {
								R47cell17.setCellValue(BRF40a.getR47_exclusive_120days() == null ? 0
										: BRF40a.getR47_exclusive_120days().intValue());
							}

							Cell R47cell18 = row31.getCell(27);
							if (R47cell18 != null) {
								R47cell18.setCellValue(BRF40a.getR47_exclusive_180days() == null ? 0
										: BRF40a.getR47_exclusive_180days().intValue());
							}

							Cell R47cell19 = row31.getCell(28);
							if (R47cell19 != null) {
								R47cell19.setCellValue(BRF40a.getR47_exclusive_over_180days() == null ? 0
										: BRF40a.getR47_exclusive_over_180days().intValue());
							}

							Cell R47cell20 = row31.getCell(31);
							if (R47cell20 != null) {
								R47cell20.setCellValue(
										BRF40a.getR47_new_stage3() == null ? 0 : BRF40a.getR47_new_stage3().intValue());
							}
							Cell R47cell21 = row31.getCell(32);
							if (R47cell21 != null) {
								R47cell21.setCellValue(BRF40a.getR47_new_specific() == null ? 0
										: BRF40a.getR47_new_specific().intValue());
							}
							/*Cell R47cell22 = row31.getCell(33);
							if (R47cell22 != null) {
								R47cell22.setCellValue(
										BRF40a.getR47_new_other() == null ? 0 : BRF40a.getR47_new_other().intValue());
							}*/

							Cell R47cell23 = row31.getCell(35);
							if (R47cell23 != null) {
								R47cell23.setCellValue(BRF40a.getR47_performing_accounts() == null ? 0
										: BRF40a.getR47_performing_accounts().intValue());
							}

							Cell R47cell24 = row31.getCell(36);
							if (R47cell24 != null) {
								R47cell24.setCellValue(BRF40a.getR47_non_performing_accounts() == null ? 0
										: BRF40a.getR47_non_performing_accounts().intValue());
							}
							/// row48
							Row row32= sheet.getRow(47);
							Cell R48cell = row32.getCell(3);
							if (R48cell != null) {
								R48cell.setCellValue(BRF40a.getR48_outstanding_balance() == null ? 0
										: BRF40a.getR48_outstanding_balance().intValue());
							}
							Cell R48cell1 = row32.getCell(7);
							if (R48cell1 != null) {
								R48cell1.setCellValue(BRF40a.getR48_provision_suspense() == null ? 0
										: BRF40a.getR48_provision_suspense().intValue());
							}
							Cell R48cell2 = row32.getCell(8);
							if (R48cell2 != null) {
								R48cell2.setCellValue(BRF40a.getR48_stage3_provision() == null ? 0
										: BRF40a.getR48_stage3_provision().intValue());
							}
							/*Cell R48cell3 = row32.getCell(9);
							if (R48cell3 != null) {
								R48cell3.setCellValue(BRF40a.getR48_other_alloate() == null ? 0
										: BRF40a.getR48_other_alloate().intValue());
							}*/
							Cell R48cell4 = row32.getCell(11);
							if (R48cell4 != null) {
								R48cell4.setCellValue(BRF40a.getR48_1_asset() == null ? 0
										: BRF40a.getR48_1_asset().intValue());
							}
							Cell R48cell5 = row32.getCell(12);
							if (R48cell5 != null) {
								R48cell5.setCellValue(BRF40a.getR48_2_asset() == null ? 0
										: BRF40a.getR48_2_asset().intValue());
							}
							Cell R48cell6 = row32.getCell(13);
							if (R48cell6 != null) {
								R48cell6.setCellValue(BRF40a.getR48_3a_asset() == null ? 0
										: BRF40a.getR48_3a_asset().intValue());
							}
							Cell R48cell7 = row32.getCell(14);
							if (R48cell7 != null) {
								R48cell7.setCellValue(BRF40a.getR48_3b_asset() == null ? 0
										: BRF40a.getR48_3b_asset().intValue());
							}
							Cell R48cell8 = row32.getCell(15);
							if (R48cell8 != null) {
								R48cell8.setCellValue(
										BRF40a.getR48_3c_asset() == null ? 0 : BRF40a.getR48_3c_asset().intValue());
							}
							Cell R48cell9 = row32.getCell(17);
							if (R48cell9 != null) {
								R48cell9.setCellValue(BRF40a.getR48_1_provision() == null ? 0
										: BRF40a.getR48_1_provision().intValue());
							}

							Cell R48cell10 = row32.getCell(18);
							if (R48cell10 != null) {
								R48cell10.setCellValue(BRF40a.getR48_2_provision() == null ? 0
										: BRF40a.getR48_2_provision().intValue());
							}
							Cell R48cell11 = row32.getCell(19);
							if (R48cell11 != null) {
								R48cell11.setCellValue(BRF40a.getR48_3a_provision() == null ? 0
										: BRF40a.getR48_3a_provision().intValue());
							}
							Cell R48cell12 = row32.getCell(20);
							if (R48cell12 != null) {
								R48cell12.setCellValue(BRF40a.getR48_3b_provision() == null ? 0
										: BRF40a.getR48_3b_provision().intValue());
							}
							Cell R48cell13 = row32.getCell(21);
							if (R48cell13 != null) {
								R48cell13.setCellValue(BRF40a.getR48_3c_provision() == null ? 0
										: BRF40a.getR48_3c_provision().intValue());
							}

							Cell R48cell14 = row32.getCell(23);
							if (R48cell14 != null) {
								R48cell14.setCellValue(
										BRF40a.getR48_current() == null ? 0 : BRF40a.getR48_current().intValue());
							}

							Cell R48cell15 = row32.getCell(24);
							if (R48cell15 != null) {
								R48cell15.setCellValue(
										BRF40a.getR48_lessthan_30() == null ? 0 : BRF40a.getR48_lessthan_30().intValue());
							}
							Cell R48cell16 = row32.getCell(25);
							if (R48cell16 != null) {
								R48cell16.setCellValue(BRF40a.getR48_exclusive_90days() == null ? 0
										: BRF40a.getR48_exclusive_90days().intValue());
							}

							Cell R48cell17 = row32.getCell(26);
							if (R48cell17 != null) {
								R48cell17.setCellValue(BRF40a.getR48_exclusive_120days() == null ? 0
										: BRF40a.getR48_exclusive_120days().intValue());
							}

							Cell R48cell18 = row32.getCell(27);
							if (R48cell18 != null) {
								R48cell18.setCellValue(BRF40a.getR48_exclusive_180days() == null ? 0
										: BRF40a.getR48_exclusive_180days().intValue());
							}

							Cell R48cell19 = row32.getCell(28);
							if (R48cell19 != null) {
								R48cell19.setCellValue(BRF40a.getR48_exclusive_over_180days() == null ? 0
										: BRF40a.getR48_exclusive_over_180days().intValue());
							}

							Cell R48cell20 = row32.getCell(31);
							if (R48cell20 != null) {
								R48cell20.setCellValue(
										BRF40a.getR48_new_stage3() == null ? 0 : BRF40a.getR48_new_stage3().intValue());
							}
							Cell R48cell21 = row32.getCell(32);
							if (R48cell21 != null) {
								R48cell21.setCellValue(BRF40a.getR48_new_specific() == null ? 0
										: BRF40a.getR48_new_specific().intValue());
							}
							/*Cell R48cell22 = row32.getCell(33);
							if (R48cell22 != null) {
								R48cell22.setCellValue(
										BRF40a.getR48_new_other() == null ? 0 : BRF40a.getR48_new_other().intValue());
							}*/

							Cell R48cell23 = row32.getCell(35);
							if (R48cell23 != null) {
								R48cell23.setCellValue(BRF40a.getR48_performing_accounts() == null ? 0
										: BRF40a.getR48_performing_accounts().intValue());
							}

							Cell R48cell24 = row32.getCell(36);
							if (R48cell24 != null) {
								R48cell24.setCellValue(BRF40a.getR48_non_performing_accounts() == null ? 0
										: BRF40a.getR48_non_performing_accounts().intValue());
							}
							/// row49
							Row row33= sheet.getRow(48);
							Cell R49cell = row33.getCell(3);
							if (R49cell != null) {
								R49cell.setCellValue(BRF40a.getR49_outstanding_balance() == null ? 0
										: BRF40a.getR49_outstanding_balance().intValue());
							}
							Cell R49cell1 = row33.getCell(7);
							if (R49cell1 != null) {
								R49cell1.setCellValue(BRF40a.getR49_provision_suspense() == null ? 0
										: BRF40a.getR49_provision_suspense().intValue());
							}
							Cell R49cell2 = row33.getCell(8);
							if (R49cell2 != null) {
								R49cell2.setCellValue(BRF40a.getR49_stage3_provision() == null ? 0
										: BRF40a.getR49_stage3_provision().intValue());
							}
							/*Cell R49cell3 = row33.getCell(9);
							if (R49cell3 != null) {
								R49cell3.setCellValue(BRF40a.getR49_other_alloate() == null ? 0
										: BRF40a.getR49_other_alloate().intValue());
							}*/
							Cell R49cell4 = row33.getCell(11);
							if (R49cell4 != null) {
								R49cell4.setCellValue(BRF40a.getR49_1_asset() == null ? 0
										: BRF40a.getR49_1_asset().intValue());
							}
							Cell R49cell5 = row33.getCell(12);
							if (R49cell5 != null) {
								R49cell5.setCellValue(BRF40a.getR49_2_asset() == null ? 0
										: BRF40a.getR49_2_asset().intValue());
							}
							Cell R49cell6 = row33.getCell(13);
							if (R49cell6 != null) {
								R49cell6.setCellValue(BRF40a.getR49_3a_asset() == null ? 0
										: BRF40a.getR49_3a_asset().intValue());
							}
							Cell R49cell7 = row33.getCell(14);
							if (R49cell7 != null) {
								R49cell7.setCellValue(BRF40a.getR49_3b_asset() == null ? 0
										: BRF40a.getR49_3b_asset().intValue());
							}
							Cell R49cell8 = row33.getCell(15);
							if (R49cell8 != null) {
								R49cell8.setCellValue(
										BRF40a.getR49_3c_asset() == null ? 0 : BRF40a.getR49_3c_asset().intValue());
							}
							Cell R49cell9 = row33.getCell(17);
							if (R49cell9 != null) {
								R49cell9.setCellValue(BRF40a.getR49_1_provision() == null ? 0
										: BRF40a.getR49_1_provision().intValue());
							}

							Cell R49cell10 = row33.getCell(18);
							if (R49cell10 != null) {
								R49cell10.setCellValue(BRF40a.getR49_2_provision() == null ? 0
										: BRF40a.getR49_2_provision().intValue());
							}
							Cell R49cell11 = row33.getCell(19);
							if (R49cell11 != null) {
								R49cell11.setCellValue(BRF40a.getR49_3a_provision() == null ? 0
										: BRF40a.getR49_3a_provision().intValue());
							}
							Cell R49cell12 = row33.getCell(20);
							if (R49cell12 != null) {
								R49cell12.setCellValue(BRF40a.getR49_3b_provision() == null ? 0
										: BRF40a.getR49_3b_provision().intValue());
							}
							Cell R49cell13 = row33.getCell(21);
							if (R49cell13 != null) {
								R49cell13.setCellValue(BRF40a.getR49_3c_provision() == null ? 0
										: BRF40a.getR49_3c_provision().intValue());
							}

							Cell R49cell14 = row33.getCell(23);
							if (R49cell14 != null) {
								R49cell14.setCellValue(
										BRF40a.getR49_current() == null ? 0 : BRF40a.getR49_current().intValue());
							}

							Cell R49cell15 = row33.getCell(24);
							if (R49cell15 != null) {
								R49cell15.setCellValue(
										BRF40a.getR49_lessthan_30() == null ? 0 : BRF40a.getR49_lessthan_30().intValue());
							}
							Cell R49cell16 = row33.getCell(25);
							if (R49cell16 != null) {
								R49cell16.setCellValue(BRF40a.getR49_exclusive_90days() == null ? 0
										: BRF40a.getR49_exclusive_90days().intValue());
							}

							Cell R49cell17 = row33.getCell(26);
							if (R49cell17 != null) {
								R49cell17.setCellValue(BRF40a.getR49_exclusive_120days() == null ? 0
										: BRF40a.getR49_exclusive_120days().intValue());
							}

							Cell R49cell18 = row33.getCell(27);
							if (R49cell18 != null) {
								R49cell18.setCellValue(BRF40a.getR49_exclusive_180days() == null ? 0
										: BRF40a.getR49_exclusive_180days().intValue());
							}

							Cell R49cell19 = row33.getCell(28);
							if (R49cell19 != null) {
								R49cell19.setCellValue(BRF40a.getR49_exclusive_over_180days() == null ? 0
										: BRF40a.getR49_exclusive_over_180days().intValue());
							}

							Cell R49cell20 = row33.getCell(31);
							if (R49cell20 != null) {
								R49cell20.setCellValue(
										BRF40a.getR49_new_stage3() == null ? 0 : BRF40a.getR49_new_stage3().intValue());
							}
							Cell R49cell21 = row33.getCell(32);
							if (R49cell21 != null) {
								R49cell21.setCellValue(BRF40a.getR49_new_specific() == null ? 0
										: BRF40a.getR49_new_specific().intValue());
							}
							/*Cell R49cell22 = row33.getCell(33);
							if (R49cell22 != null) {
								R49cell22.setCellValue(
										BRF40a.getR49_new_other() == null ? 0 : BRF40a.getR49_new_other().intValue());
							}*/

							Cell R49cell23 = row33.getCell(35);
							if (R49cell23 != null) {
								R49cell23.setCellValue(BRF40a.getR49_performing_accounts() == null ? 0
										: BRF40a.getR49_performing_accounts().intValue());
							}

							Cell R49cell24 = row33.getCell(36);
							if (R49cell24 != null) {
								R49cell24.setCellValue(BRF40a.getR49_non_performing_accounts() == null ? 0
										: BRF40a.getR49_non_performing_accounts().intValue());
							}
							/// row50
							Row row34= sheet.getRow(49);
							Cell R50cell = row34.getCell(3);
							if (R50cell != null) {
								R50cell.setCellValue(BRF40a.getR50_outstanding_balance() == null ? 0
										: BRF40a.getR50_outstanding_balance().intValue());
							}
							Cell R50cell1 = row34.getCell(7);
							if (R50cell1 != null) {
								R50cell1.setCellValue(BRF40a.getR50_provision_suspense() == null ? 0
										: BRF40a.getR50_provision_suspense().intValue());
							}
							Cell R50cell2 = row34.getCell(8);
							if (R50cell2 != null) {
								R50cell2.setCellValue(BRF40a.getR50_stage3_provision() == null ? 0
										: BRF40a.getR50_stage3_provision().intValue());
							}
							/*Cell R50cell3 = row34.getCell(9);
							if (R50cell3 != null) {
								R50cell3.setCellValue(BRF40a.getR50_other_alloate() == null ? 0
										: BRF40a.getR50_other_alloate().intValue());
							}*/
							Cell R50cell4 = row34.getCell(11);
							if (R50cell4 != null) {
								R50cell4.setCellValue(BRF40a.getR50_1_asset() == null ? 0
										: BRF40a.getR50_1_asset().intValue());
							}
							Cell R50cell5 = row34.getCell(12);
							if (R50cell5 != null) {
								R50cell5.setCellValue(BRF40a.getR50_2_asset() == null ? 0
										: BRF40a.getR50_2_asset().intValue());
							}
							Cell R50cell6 = row34.getCell(13);
							if (R50cell6 != null) {
								R50cell6.setCellValue(BRF40a.getR50_3a_asset() == null ? 0
										: BRF40a.getR50_3a_asset().intValue());
							}
							Cell R50cell7 = row34.getCell(14);
							if (R50cell7 != null) {
								R50cell7.setCellValue(BRF40a.getR50_3b_asset() == null ? 0
										: BRF40a.getR50_3b_asset().intValue());
							}
							Cell R50cell8 = row34.getCell(15);
							if (R50cell8 != null) {
								R50cell8.setCellValue(
										BRF40a.getR50_3c_asset() == null ? 0 : BRF40a.getR50_3c_asset().intValue());
							}
							Cell R50cell9 = row34.getCell(17);
							if (R50cell9 != null) {
								R50cell9.setCellValue(BRF40a.getR50_1_provision() == null ? 0
										: BRF40a.getR50_1_provision().intValue());
							}

							Cell R50cell10 = row34.getCell(18);
							if (R50cell10 != null) {
								R50cell10.setCellValue(BRF40a.getR50_2_provision() == null ? 0
										: BRF40a.getR50_2_provision().intValue());
							}
							Cell R50cell11 = row34.getCell(19);
							if (R50cell11 != null) {
								R50cell11.setCellValue(BRF40a.getR50_3a_provision() == null ? 0
										: BRF40a.getR50_3a_provision().intValue());
							}
							Cell R50cell12 = row34.getCell(20);
							if (R50cell12 != null) {
								R50cell12.setCellValue(BRF40a.getR50_3b_provision() == null ? 0
										: BRF40a.getR50_3b_provision().intValue());
							}
							Cell R50cell13 = row34.getCell(21);
							if (R50cell13 != null) {
								R50cell13.setCellValue(BRF40a.getR50_3c_provision() == null ? 0
										: BRF40a.getR50_3c_provision().intValue());
							}

							Cell R50cell14 = row34.getCell(23);
							if (R50cell14 != null) {
								R50cell14.setCellValue(
										BRF40a.getR50_current() == null ? 0 : BRF40a.getR50_current().intValue());
							}

							Cell R50cell15 = row34.getCell(24);
							if (R50cell15 != null) {
								R50cell15.setCellValue(
										BRF40a.getR50_lessthan_30() == null ? 0 : BRF40a.getR50_lessthan_30().intValue());
							}
							Cell R50cell16 = row34.getCell(25);
							if (R50cell16 != null) {
								R50cell16.setCellValue(BRF40a.getR50_exclusive_90days() == null ? 0
										: BRF40a.getR50_exclusive_90days().intValue());
							}

							Cell R50cell17 = row34.getCell(26);
							if (R50cell17 != null) {
								R50cell17.setCellValue(BRF40a.getR50_exclusive_120days() == null ? 0
										: BRF40a.getR50_exclusive_120days().intValue());
							}

							Cell R50cell18 = row34.getCell(27);
							if (R50cell18 != null) {
								R50cell18.setCellValue(BRF40a.getR50_exclusive_180days() == null ? 0
										: BRF40a.getR50_exclusive_180days().intValue());
							}

							Cell R50cell19 = row34.getCell(28);
							if (R50cell19 != null) {
								R50cell19.setCellValue(BRF40a.getR50_exclusive_over_180days() == null ? 0
										: BRF40a.getR50_exclusive_over_180days().intValue());
							}

							Cell R50cell20 = row34.getCell(31);
							if (R50cell20 != null) {
								R50cell20.setCellValue(
										BRF40a.getR50_new_stage3() == null ? 0 : BRF40a.getR50_new_stage3().intValue());
							}
							Cell R50cell21 = row34.getCell(32);
							if (R50cell21 != null) {
								R50cell21.setCellValue(BRF40a.getR50_new_specific() == null ? 0
										: BRF40a.getR50_new_specific().intValue());
							}
							/*Cell R50cell22 = row34.getCell(33);
							if (R50cell22 != null) {
								R50cell22.setCellValue(
										BRF40a.getR50_new_other() == null ? 0 : BRF40a.getR50_new_other().intValue());
							}*/

							Cell R50cell23 = row34.getCell(35);
							if (R50cell23 != null) {
								R50cell23.setCellValue(BRF40a.getR50_performing_accounts() == null ? 0
										: BRF40a.getR50_performing_accounts().intValue());
							}

							Cell R50cell24 = row34.getCell(36);
							if (R50cell24 != null) {
								R50cell24.setCellValue(BRF40a.getR50_non_performing_accounts() == null ? 0
										: BRF40a.getR50_non_performing_accounts().intValue());
							}

							/// row51
							Row row35= sheet.getRow(50);
							Cell R51cell = row35.getCell(3);
							if (R51cell != null) {
								R51cell.setCellValue(BRF40a.getR51_outstanding_balance() == null ? 0
										: BRF40a.getR51_outstanding_balance().intValue());
							}
							Cell R51cell1 = row35.getCell(7);
							if (R51cell1 != null) {
								R51cell1.setCellValue(BRF40a.getR51_provision_suspense() == null ? 0
										: BRF40a.getR51_provision_suspense().intValue());
							}
							Cell R51cell2 = row35.getCell(8);
							if (R51cell2 != null) {
								R51cell2.setCellValue(BRF40a.getR51_stage3_provision() == null ? 0
										: BRF40a.getR51_stage3_provision().intValue());
							}
							/*Cell R51cell3 = row35.getCell(9);
							if (R51cell3 != null) {
								R51cell3.setCellValue(BRF40a.getR51_other_alloate() == null ? 0
										: BRF40a.getR51_other_alloate().intValue());
							}*/
							Cell R51cell4 = row35.getCell(11);
							if (R51cell4 != null) {
								R51cell4.setCellValue(BRF40a.getR51_1_asset() == null ? 0
										: BRF40a.getR51_1_asset().intValue());
							}
							Cell R51cell5 = row35.getCell(12);
							if (R51cell5 != null) {
								R51cell5.setCellValue(BRF40a.getR51_2_asset() == null ? 0
										: BRF40a.getR51_2_asset().intValue());
							}
							Cell R51cell6 = row35.getCell(13);
							if (R51cell6 != null) {
								R51cell6.setCellValue(BRF40a.getR51_3a_asset() == null ? 0
										: BRF40a.getR51_3a_asset().intValue());
							}
							Cell R51cell7 = row35.getCell(14);
							if (R51cell7 != null) {
								R51cell7.setCellValue(BRF40a.getR51_3b_asset() == null ? 0
										: BRF40a.getR51_3b_asset().intValue());
							}
							Cell R51cell8 = row35.getCell(15);
							if (R51cell8 != null) {
								R51cell8.setCellValue(
										BRF40a.getR51_3c_asset() == null ? 0 : BRF40a.getR51_3c_asset().intValue());
							}
							Cell R51cell9 = row35.getCell(17);
							if (R51cell9 != null) {
								R51cell9.setCellValue(BRF40a.getR51_1_provision() == null ? 0
										: BRF40a.getR51_1_provision().intValue());
							}

							Cell R51cell10 = row35.getCell(18);
							if (R51cell10 != null) {
								R51cell10.setCellValue(BRF40a.getR51_2_provision() == null ? 0
										: BRF40a.getR51_2_provision().intValue());
							}
							Cell R51cell11 = row35.getCell(19);
							if (R51cell11 != null) {
								R51cell11.setCellValue(BRF40a.getR51_3a_provision() == null ? 0
										: BRF40a.getR51_3a_provision().intValue());
							}
							Cell R51cell12 = row35.getCell(20);
							if (R51cell12 != null) {
								R51cell12.setCellValue(BRF40a.getR51_3b_provision() == null ? 0
										: BRF40a.getR51_3b_provision().intValue());
							}
							Cell R51cell13 = row35.getCell(21);
							if (R51cell13 != null) {
								R51cell13.setCellValue(BRF40a.getR51_3c_provision() == null ? 0
										: BRF40a.getR51_3c_provision().intValue());
							}

							Cell R51cell14 = row35.getCell(23);
							if (R51cell14 != null) {
								R51cell14.setCellValue(
										BRF40a.getR51_current() == null ? 0 : BRF40a.getR51_current().intValue());
							}

							Cell R51cell15 = row35.getCell(24);
							if (R51cell15 != null) {
								R51cell15.setCellValue(
										BRF40a.getR51_lessthan_30() == null ? 0 : BRF40a.getR51_lessthan_30().intValue());
							}
							Cell R51cell16 = row35.getCell(25);
							if (R51cell16 != null) {
								R51cell16.setCellValue(BRF40a.getR51_exclusive_90days() == null ? 0
										: BRF40a.getR51_exclusive_90days().intValue());
							}

							Cell R51cell17 = row35.getCell(26);
							if (R51cell17 != null) {
								R51cell17.setCellValue(BRF40a.getR51_exclusive_120days() == null ? 0
										: BRF40a.getR51_exclusive_120days().intValue());
							}

							Cell R51cell18 = row35.getCell(27);
							if (R51cell18 != null) {
								R51cell18.setCellValue(BRF40a.getR51_exclusive_180days() == null ? 0
										: BRF40a.getR51_exclusive_180days().intValue());
							}

							Cell R51cell19 = row35.getCell(28);
							if (R51cell19 != null) {
								R51cell19.setCellValue(BRF40a.getR51_exclusive_over_180days() == null ? 0
										: BRF40a.getR51_exclusive_over_180days().intValue());
							}

							Cell R51cell20 = row35.getCell(31);
							if (R51cell20 != null) {
								R51cell20.setCellValue(
										BRF40a.getR51_new_stage3() == null ? 0 : BRF40a.getR51_new_stage3().intValue());
							}
							Cell R51cell21 = row35.getCell(32);
							if (R51cell21 != null) {
								R51cell21.setCellValue(BRF40a.getR51_new_specific() == null ? 0
										: BRF40a.getR51_new_specific().intValue());
							}
							/*Cell R51cell22 = row35.getCell(33);
							if (R51cell22 != null) {
								R51cell22.setCellValue(
										BRF40a.getR51_new_other() == null ? 0 : BRF40a.getR51_new_other().intValue());
							}*/

							Cell R51cell23 = row35.getCell(35);
							if (R51cell23 != null) {
								R51cell23.setCellValue(BRF40a.getR51_performing_accounts() == null ? 0
										: BRF40a.getR51_performing_accounts().intValue());
							}

							Cell R51cell24 = row35.getCell(36);
							if (R51cell24 != null) {
								R51cell24.setCellValue(BRF40a.getR51_non_performing_accounts() == null ? 0
										: BRF40a.getR51_non_performing_accounts().intValue());
							}
							/// row52
							Row row36= sheet.getRow(51);
							Cell R52cell = row36.getCell(3);
							if (R52cell != null) {
								R52cell.setCellValue(BRF40a.getR52_outstanding_balance() == null ? 0
										: BRF40a.getR52_outstanding_balance().intValue());
							}
							Cell R52cell1 = row36.getCell(7);
							if (R52cell1 != null) {
								R52cell1.setCellValue(BRF40a.getR52_provision_suspense() == null ? 0
										: BRF40a.getR52_provision_suspense().intValue());
							}
							Cell R52cell2 = row36.getCell(8);
							if (R52cell2 != null) {
								R52cell2.setCellValue(BRF40a.getR52_stage3_provision() == null ? 0
										: BRF40a.getR52_stage3_provision().intValue());
							}
							/*Cell R52cell3 = row36.getCell(9);
							if (R52cell3 != null) {
								R52cell3.setCellValue(BRF40a.getR52_other_alloate() == null ? 0
										: BRF40a.getR52_other_alloate().intValue());
							}*/
							Cell R52cell4 = row36.getCell(11);
							if (R52cell4 != null) {
								R52cell4.setCellValue(BRF40a.getR52_1_asset() == null ? 0
										: BRF40a.getR52_1_asset().intValue());
							}
							Cell R52cell5 = row36.getCell(12);
							if (R52cell5 != null) {
								R52cell5.setCellValue(BRF40a.getR52_2_asset() == null ? 0
										: BRF40a.getR52_2_asset().intValue());
							}
							Cell R52cell6 = row36.getCell(13);
							if (R52cell6 != null) {
								R52cell6.setCellValue(BRF40a.getR52_3a_asset() == null ? 0
										: BRF40a.getR52_3a_asset().intValue());
							}
							Cell R52cell7 = row36.getCell(14);
							if (R52cell7 != null) {
								R52cell7.setCellValue(BRF40a.getR52_3b_asset() == null ? 0
										: BRF40a.getR52_3b_asset().intValue());
							}
							Cell R52cell8 = row36.getCell(15);
							if (R52cell8 != null) {
								R52cell8.setCellValue(
										BRF40a.getR52_3c_asset() == null ? 0 : BRF40a.getR52_3c_asset().intValue());
							}
							Cell R52cell9 = row36.getCell(17);
							if (R52cell9 != null) {
								R52cell9.setCellValue(BRF40a.getR52_1_provision() == null ? 0
										: BRF40a.getR52_1_provision().intValue());
							}

							Cell R52cell10 = row36.getCell(18);
							if (R52cell10 != null) {
								R52cell10.setCellValue(BRF40a.getR52_2_provision() == null ? 0
										: BRF40a.getR52_2_provision().intValue());
							}
							Cell R52cell11 = row36.getCell(19);
							if (R52cell11 != null) {
								R52cell11.setCellValue(BRF40a.getR52_3a_provision() == null ? 0
										: BRF40a.getR52_3a_provision().intValue());
							}
							Cell R52cell12 = row36.getCell(20);
							if (R52cell12 != null) {
								R52cell12.setCellValue(BRF40a.getR52_3b_provision() == null ? 0
										: BRF40a.getR52_3b_provision().intValue());
							}
							Cell R52cell13 = row36.getCell(21);
							if (R52cell13 != null) {
								R52cell13.setCellValue(BRF40a.getR52_3c_provision() == null ? 0
										: BRF40a.getR52_3c_provision().intValue());
							}

							Cell R52cell14 = row36.getCell(23);
							if (R52cell14 != null) {
								R52cell14.setCellValue(
										BRF40a.getR52_current() == null ? 0 : BRF40a.getR52_current().intValue());
							}

							Cell R52cell15 = row36.getCell(24);
							if (R52cell15 != null) {
								R52cell15.setCellValue(
										BRF40a.getR52_lessthan_30() == null ? 0 : BRF40a.getR52_lessthan_30().intValue());
							}
							Cell R52cell16 = row36.getCell(25);
							if (R52cell16 != null) {
								R52cell16.setCellValue(BRF40a.getR52_exclusive_90days() == null ? 0
										: BRF40a.getR52_exclusive_90days().intValue());
							}

							Cell R52cell17 = row36.getCell(26);
							if (R52cell17 != null) {
								R52cell17.setCellValue(BRF40a.getR52_exclusive_120days() == null ? 0
										: BRF40a.getR52_exclusive_120days().intValue());
							}

							Cell R52cell18 = row36.getCell(27);
							if (R52cell18 != null) {
								R52cell18.setCellValue(BRF40a.getR52_exclusive_180days() == null ? 0
										: BRF40a.getR52_exclusive_180days().intValue());
							}

							Cell R52cell19 = row36.getCell(28);
							if (R52cell19 != null) {
								R52cell19.setCellValue(BRF40a.getR52_exclusive_over_180days() == null ? 0
										: BRF40a.getR52_exclusive_over_180days().intValue());
							}

							Cell R52cell20 = row36.getCell(31);
							if (R52cell20 != null) {
								R52cell20.setCellValue(
										BRF40a.getR52_new_stage3() == null ? 0 : BRF40a.getR52_new_stage3().intValue());
							}
							Cell R52cell21 = row36.getCell(32);
							if (R52cell21 != null) {
								R52cell21.setCellValue(BRF40a.getR52_new_specific() == null ? 0
										: BRF40a.getR52_new_specific().intValue());
							}
							/*Cell R52cell22 = row36.getCell(33);
							if (R52cell22 != null) {
								R52cell22.setCellValue(
										BRF40a.getR52_new_other() == null ? 0 : BRF40a.getR52_new_other().intValue());
							}*/

							Cell R52cell23 = row36.getCell(35);
							if (R52cell23 != null) {
								R52cell23.setCellValue(BRF40a.getR52_performing_accounts() == null ? 0
										: BRF40a.getR52_performing_accounts().intValue());
							}

							Cell R52cell24 = row36.getCell(36);
							if (R52cell24 != null) {
								R52cell24.setCellValue(BRF40a.getR52_non_performing_accounts() == null ? 0
										: BRF40a.getR52_non_performing_accounts().intValue());
							}
							/// row53
							Row row37= sheet.getRow(52);
							Cell R53cell = row37.getCell(3);
							if (R53cell != null) {
								R53cell.setCellValue(BRF40a.getR53_outstanding_balance() == null ? 0
										: BRF40a.getR53_outstanding_balance().intValue());
							}
							Cell R53cell1 = row37.getCell(7);
							if (R53cell1 != null) {
								R53cell1.setCellValue(BRF40a.getR53_provision_suspense() == null ? 0
										: BRF40a.getR53_provision_suspense().intValue());
							}
							Cell R53cell2 = row37.getCell(8);
							if (R53cell2 != null) {
								R53cell2.setCellValue(BRF40a.getR53_stage3_provision() == null ? 0
										: BRF40a.getR53_stage3_provision().intValue());
							}
							/*Cell R53cell3 = row37.getCell(9);
							if (R53cell3 != null) {
								R53cell3.setCellValue(BRF40a.getR53_other_alloate() == null ? 0
										: BRF40a.getR53_other_alloate().intValue());
							}*/
							Cell R53cell4 = row37.getCell(11);
							if (R53cell4 != null) {
								R53cell4.setCellValue(BRF40a.getR53_1_asset() == null ? 0
										: BRF40a.getR53_1_asset().intValue());
							}
							Cell R53cell5 = row37.getCell(12);
							if (R53cell5 != null) {
								R53cell5.setCellValue(BRF40a.getR53_2_asset() == null ? 0
										: BRF40a.getR53_2_asset().intValue());
							}
							Cell R53cell6 = row37.getCell(13);
							if (R53cell6 != null) {
								R53cell6.setCellValue(BRF40a.getR53_3a_asset() == null ? 0
										: BRF40a.getR53_3a_asset().intValue());
							}
							Cell R53cell7 = row37.getCell(14);
							if (R53cell7 != null) {
								R53cell7.setCellValue(BRF40a.getR53_3b_asset() == null ? 0
										: BRF40a.getR53_3b_asset().intValue());
							}
							Cell R53cell8 = row37.getCell(15);
							if (R53cell8 != null) {
								R53cell8.setCellValue(
										BRF40a.getR53_3c_asset() == null ? 0 : BRF40a.getR53_3c_asset().intValue());
							}
							Cell R53cell9 = row37.getCell(17);
							if (R53cell9 != null) {
								R53cell9.setCellValue(BRF40a.getR53_1_provision() == null ? 0
										: BRF40a.getR53_1_provision().intValue());
							}

							Cell R53cell10 = row37.getCell(18);
							if (R53cell10 != null) {
								R53cell10.setCellValue(BRF40a.getR53_2_provision() == null ? 0
										: BRF40a.getR53_2_provision().intValue());
							}
							Cell R53cell11 = row37.getCell(19);
							if (R53cell11 != null) {
								R53cell11.setCellValue(BRF40a.getR53_3a_provision() == null ? 0
										: BRF40a.getR53_3a_provision().intValue());
							}
							Cell R53cell12 = row37.getCell(20);
							if (R53cell12 != null) {
								R53cell12.setCellValue(BRF40a.getR53_3b_provision() == null ? 0
										: BRF40a.getR53_3b_provision().intValue());
							}
							Cell R53cell13 = row37.getCell(21);
							if (R53cell13 != null) {
								R53cell13.setCellValue(BRF40a.getR53_3c_provision() == null ? 0
										: BRF40a.getR53_3c_provision().intValue());
							}

							Cell R53cell14 = row37.getCell(23);
							if (R53cell14 != null) {
								R53cell14.setCellValue(
										BRF40a.getR53_current() == null ? 0 : BRF40a.getR53_current().intValue());
							}

							Cell R53cell15 = row37.getCell(24);
							if (R53cell15 != null) {
								R53cell15.setCellValue(
										BRF40a.getR53_lessthan_30() == null ? 0 : BRF40a.getR53_lessthan_30().intValue());
							}
							Cell R53cell16 = row37.getCell(25);
							if (R53cell16 != null) {
								R53cell16.setCellValue(BRF40a.getR53_exclusive_90days() == null ? 0
										: BRF40a.getR53_exclusive_90days().intValue());
							}

							Cell R53cell17 = row37.getCell(26);
							if (R53cell17 != null) {
								R53cell17.setCellValue(BRF40a.getR53_exclusive_120days() == null ? 0
										: BRF40a.getR53_exclusive_120days().intValue());
							}

							Cell R53cell18 = row37.getCell(27);
							if (R53cell18 != null) {
								R53cell18.setCellValue(BRF40a.getR53_exclusive_180days() == null ? 0
										: BRF40a.getR53_exclusive_180days().intValue());
							}

							Cell R53cell19 = row37.getCell(28);
							if (R53cell19 != null) {
								R53cell19.setCellValue(BRF40a.getR53_exclusive_over_180days() == null ? 0
										: BRF40a.getR53_exclusive_over_180days().intValue());
							}

							Cell R53cell20 = row37.getCell(31);
							if (R53cell20 != null) {
								R53cell20.setCellValue(
										BRF40a.getR53_new_stage3() == null ? 0 : BRF40a.getR53_new_stage3().intValue());
							}
							Cell R53cell21 = row37.getCell(32);
							if (R53cell21 != null) {
								R53cell21.setCellValue(BRF40a.getR53_new_specific() == null ? 0
										: BRF40a.getR53_new_specific().intValue());
							}
							/*Cell R53cell22 = row37.getCell(33);
							if (R53cell22 != null) {
								R53cell22.setCellValue(
										BRF40a.getR53_new_other() == null ? 0 : BRF40a.getR53_new_other().intValue());
							}*/

							Cell R53cell23 = row37.getCell(35);
							if (R53cell23 != null) {
								R53cell23.setCellValue(BRF40a.getR53_performing_accounts() == null ? 0
										: BRF40a.getR53_performing_accounts().intValue());
							}

							Cell R53cell24 = row37.getCell(36);
							if (R53cell24 != null) {
								R53cell24.setCellValue(BRF40a.getR53_non_performing_accounts() == null ? 0
										: BRF40a.getR53_non_performing_accounts().intValue());
							}

							
						}
					}
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-040-A.xls");
					workbook.write(fileOut);
					fileOut.close();
					System.out.println(fileOut);
					path = fileOut.toString();
					// Close the workbook
					System.out.println("PATH : " + path);
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

			} //// else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-040-A.xls");

		return outputFile;

	}

	public ModelAndView getBRF40currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF40_DETAILTABLE  a where report_date = ?1 and report_label =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF40_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF40_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF40_DETAIL_ENTITY> T1Master = new ArrayList<BRF40_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF40_DETAIL_ENTITY a where a.report_date = ?1", BRF40_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String acct_crncy_code = (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[3];
			String bacid = (String) a[4];
			String constitution_code = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date) a[9];
			String create_user = (String) a[10];
			String cust_id = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			BigDecimal eab_lc = (BigDecimal) a[14];
			String entity_flg = (String) a[15];
			String foracid = (String) a[16];
			String gender = (String) a[17];
			String gl_code = (String) a[18];
			String gl_sub_head_code = (String) a[19];
			String gl_sub_head_desc = (String) a[20];
			String group_id = (String) a[21];
			BigDecimal hni_networth = (BigDecimal) a[22];
			String legal_entity_type = (String) a[23];
			Date maturity_date = (Date) a[24];
			String modify_flg = (String) a[25];
			Date modify_time = (Date) a[26];
			String modify_user = (String) a[27];
			String nre_flg = (String) a[28];
			String nre_status = (String) a[29];
			String purpose_of_advn = (String) a[30];
			String remarks = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			Date report_date = (Date) a[35];
			String report_label_1 = (String) a[36];
			String report_name_1 = (String) a[37];
			String schm_code = (String) a[38];
			String schm_type = (String) a[39];
			BigDecimal sector = (BigDecimal) a[40];
			String sector_code = (String) a[41];
			String segment = (String) a[42];
			String sol_id = (String) a[43];
			String sub_sector = (String) a[44];
			String sub_segment = (String) a[45];
			String turnover = (String) a[46];
			Date verify_time = (Date) a[47];
			String verify_user = (String) a[48];
			String version = (String) a[49];
			String eco_act = (String) a[50];
			String asst_cls = (String) a[51];
			String asst_category = (String) a[52];

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

			BRF40_DETAIL_ENTITY py = new BRF40_DETAIL_ENTITY(acct_crncy_code, acct_name, acid, act_balance_amt_lc,
					bacid, constitution_code, constitution_desc, country, country_of_incorp, create_time, create_user,
					cust_id, cust_type, del_flg, eab_lc, entity_flg, foracid, gender, gl_code, gl_sub_head_code,
					gl_sub_head_desc, group_id, hni_networth, legal_entity_type, maturity_date, modify_flg, modify_time,
					modify_user, nre_flg, nre_status, purpose_of_advn, remarks, report_addl_criteria_1,
					report_addl_criteria_2, report_addl_criteria_3, report_date, report_label_1, report_name_1,
					schm_code, schm_type, sector, sector_code, segment, sol_id, sub_sector, sub_segment, turnover,
					verify_time, verify_user, version, eco_act, asst_cls, asst_category);

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

		mv.setViewName("RR" + "/" + "BRF40::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges40(BRF40_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF40_DETAIL_ENTITY> Brf40detail = brf40_DetailRep.findById(foracid);

			if (Brf40detail.isPresent()) {
				BRF40_DETAIL_ENTITY BRFdetail = Brf40detail.get();

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
					brf40_DetailRep.save(BRFdetail);

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

	public ModelAndView getArchieveBRF40View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF40_Entity1> T1Master = new ArrayList<BRF40_Entity1>();
		List<BRF40_Entity2> T1Master1 = new ArrayList<BRF40_Entity2>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF40_Entity1 a where a.report_date = ?1 ", BRF40_Entity1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF40_Entity2 a where a.report_date = ?1 ", BRF40_Entity2.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF40ARCH");
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

	/****
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView ARCHgetBRF40currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF40_ARCHIVETABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF40_ARCHIVETABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF40_ARCHIVETABLE  where report_date = ?1");
		}

		List<BRF40_ARCHIV_ENTITY> T1Master = new ArrayList<BRF40_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF40_ARCHIV_ENTITY a where a.report_date = ?1", BRF40_ARCHIV_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {
			String acct_crncy_code = (String) a[0];
			String acct_name = (String) a[1];
			String acid = (String) a[2];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[3];
			String bacid = (String) a[4];
			String constitution_code = (String) a[5];
			String constitution_desc = (String) a[6];
			String country = (String) a[7];
			String country_of_incorp = (String) a[8];
			Date create_time = (Date) a[9];
			String create_user = (String) a[10];
			String cust_id = (String) a[11];
			String cust_type = (String) a[12];
			String del_flg = (String) a[13];
			BigDecimal eab_lc = (BigDecimal) a[14];
			String entity_flg = (String) a[15];
			String foracid = (String) a[16];
			String gender = (String) a[17];
			String gl_code = (String) a[18];
			String gl_sub_head_code = (String) a[19];
			String gl_sub_head_desc = (String) a[20];
			String group_id = (String) a[21];
			BigDecimal hni_networth = (BigDecimal) a[22];
			String legal_entity_type = (String) a[23];
			Date maturity_date = (Date) a[24];
			String modify_flg = (String) a[25];
			Date modify_time = (Date) a[26];
			String modify_user = (String) a[27];
			String nre_flg = (String) a[28];
			String nre_status = (String) a[29];
			String purpose_of_advn = (String) a[30];
			String remarks = (String) a[31];
			String report_addl_criteria_1 = (String) a[32];
			String report_addl_criteria_2 = (String) a[33];
			String report_addl_criteria_3 = (String) a[34];
			Date report_date = (Date) a[35];
			String report_label_1 = (String) a[36];
			String report_name_1 = (String) a[37];
			String schm_code = (String) a[38];
			String schm_type = (String) a[39];
			BigDecimal sector = (BigDecimal) a[40];
			String sector_code = (String) a[41];
			String segment = (String) a[42];
			String sol_id = (String) a[43];
			String sub_sector = (String) a[44];
			String sub_segment = (String) a[45];
			String turnover = (String) a[46];
			Date verify_time = (Date) a[47];
			String verify_user = (String) a[48];
			String version = (String) a[49];
			String eco_act = (String) a[49];
			String asst_cls = (String) a[49];
			String asst_category = (String) a[49];
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

			BRF40_ARCHIV_ENTITY py = new BRF40_ARCHIV_ENTITY(acct_crncy_code, acct_name, acid, act_balance_amt_lc,
					bacid, constitution_code, constitution_desc, country, country_of_incorp, create_time, create_user,
					cust_id, cust_type, del_flg, eab_lc, entity_flg, foracid, gender, gl_code, gl_sub_head_code,
					gl_sub_head_desc, group_id, hni_networth, legal_entity_type, maturity_date, modify_flg, modify_time,
					modify_user, nre_flg, nre_status, purpose_of_advn, remarks, report_addl_criteria_1,
					report_addl_criteria_2, report_addl_criteria_3, report_date, report_label_1, report_name_1,
					schm_code, schm_type, sector, sector_code, segment, sol_id, sub_sector, sub_segment, turnover,
					verify_time, verify_user, version, eco_act, asst_cls, asst_category);

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

		mv.setViewName("RR" + "/" + "BRF40ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
