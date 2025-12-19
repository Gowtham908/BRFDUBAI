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

import com.bornfire.xbrl.entities.BRF107_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_107_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF093AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF094AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF095AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF107AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF107_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF102AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF106AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF107_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF96AServiceRepo;
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
public class BRF107AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF107AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF73ServiceRepo brf73ServiceRepo;

	@Autowired
	BRF093AServiceRepo brf093aServiceRepo;

	@Autowired
	BRF094AServiceRepo brf094aServiceRepo;

	@Autowired
	BRF96AServiceRepo brf96aServiceRepo;

	@Autowired
	BRF106AServiceRepo brf106aServiceRepo;

	@Autowired
	BRF107AServiceRepo brf107aServiceRepo;

	@Autowired
	BRF095AServiceRepo brf095aServiceRepo;

	@Autowired
	BRF102AServiceRepo brf102aServiceRepo;

	@Autowired
	BRF107_DetailRepo brf107_detailrepo;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF107A(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF_107_A_REPORT_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF_107_A_REPORT_ENTITY a ")
						.getSingleResult();
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

	public ModelAndView getBRF107AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_107_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_107_A_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_107_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_107_A_REPORT_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF_107_A_REPORT_ENTITY a where a.report_date = ?1 ",
					BRF_107_A_REPORT_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF107A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF107ADetails(String reportId, String fromdate, String todate, String dtltype,
			Pageable pageable, String filter) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		List<Object> T1Dt1 = new ArrayList<Object>();
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			if (!filter.equals("null")) {
				qr = hs.createNativeQuery("select * from ECL_BRF107_DETAIL_TABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from ECL_BRF107_DETAIL_TABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from ECL_BRF107_DETAIL_TABLE  where report_date = ?1");
		}
		List<BRF107_DETAIL_ENTITY> T1Master = new ArrayList<BRF107_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF107_DETAIL_ENTITY a where a.report_date = ?1", BRF107_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + ",");
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String cust_name = (String) a[1];
			String branch_name = (String) a[2];
			String productname = (String) a[3];
			String currency = (String) a[4];
			BigDecimal drawnamount = (BigDecimal) a[5];
			BigDecimal undrawnamount = (BigDecimal) a[6];
			BigDecimal ead = (BigDecimal) a[7];
			Date report_date = (Date) a[8];
			Date maturitydate = (Date) a[9];
			String weighted_pd = (String) a[10];
			BigDecimal finalweightedecl = (BigDecimal) a[11];
			BigDecimal ecl_incul_deferral = (BigDecimal) a[12];
			BigDecimal ecl_mgmt_overlay = (BigDecimal) a[13];
			BigDecimal specific_provision = (BigDecimal) a[14];
			BigDecimal interest_suspense = (BigDecimal) a[15];
			String country = (String) a[16];
			String brf_1_classification = (String) a[17];
			String brf_107 = (String) a[18];
			String basel_2_category = (String) a[19];
			String provision_coverage = (String) a[20];
			String mgmtoverlay = (String) a[21];
			BigDecimal total_rwa = (BigDecimal) a[22];
			String report_lable = (String) a[23];
			String report_addl_criteria1 = (String) a[24];
			String report_addl_criteria2 = (String) a[25];
			String facilityid = (String) a[26];

			BRF107_DETAIL_ENTITY py = new BRF107_DETAIL_ENTITY(cust_id, cust_name, branch_name, productname, currency,
					drawnamount, undrawnamount, ead, report_date, maturitydate, weighted_pd, finalweightedecl,
					ecl_incul_deferral, ecl_mgmt_overlay, specific_provision, interest_suspense, country,
					brf_1_classification, brf_107, basel_2_category, provision_coverage, mgmtoverlay, total_rwa,
					report_lable, report_addl_criteria1, report_addl_criteria2, facilityid);
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

		mv.setViewName("RR" + "/" + "BRF107A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF107A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-107-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF107_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF107_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF107.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF107.jrxml");
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
				}
				outputFile = new File(path);
				return outputFile;
			} else {

				List<BRF_107_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_107_A_REPORT_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF_107_A_REPORT_ENTITY a where a.report_date = ?1 ",
							BRF_107_A_REPORT_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF_107_A_REPORT_ENTITY BRF107 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-107-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							// Get the first sheet
							Sheet sheet = workbook.getSheetAt(0);
							Row row = sheet.getRow(9);
							Cell cell = row.getCell(4);
							if (cell != null) {
								cell.setCellValue(BRF107.getR1_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR1_OUTSTANDING_NBFI().intValue());
							}
							Cell cell1 = row.getCell(5);
							if (cell1 != null) {
								cell1.setCellValue(BRF107.getR1_PROVISION_NBFI() == null ? 0
										: BRF107.getR1_PROVISION_NBFI().intValue());

							}

							Cell cell2 = row.getCell(6);
							if (cell2 != null) {
								cell2.setCellValue(BRF107.getR1_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR1_OUTSTANDING_FEDERAL().intValue());

							}

							Cell cell3 = row.getCell(7);
							if (cell3 != null) {
								cell3.setCellValue(BRF107.getR1_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR1_PROVISION_FEDERAL().intValue());

							}
							Cell cell4 = row.getCell(8);
							if (cell4 != null) {
								cell4.setCellValue(BRF107.getR1_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR1_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell cell5 = row.getCell(9);
							if (cell5 != null) {
								cell5.setCellValue(BRF107.getR1_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR1_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell cell6 = row.getCell(10);
							if (cell6 != null) {
								cell6.setCellValue(BRF107.getR1_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR1_OUTSTANDING_EMIRATES().intValue());

							}
							Cell cell7 = row.getCell(11);
							if (cell7 != null) {
								cell7.setCellValue(BRF107.getR1_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR1_PROVISION_EMIRATES().intValue());

							}

							Cell cell8 = row.getCell(12);
							if (cell8 != null) {
								cell8.setCellValue(BRF107.getR1_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR1_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell cell9 = row.getCell(13);
							if (cell9 != null) {
								cell9.setCellValue(BRF107.getR1_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR1_PROVISION_GOVT_GROSS().intValue());

							}
							Cell cell10 = row.getCell(14);
							if (cell10 != null) {
								cell10.setCellValue(BRF107.getR1_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR1_OUTSTANDING_GRE().intValue());

							}
							Cell cell11 = row.getCell(15);
							if (cell11 != null) {
								cell11.setCellValue(BRF107.getR1_PROVISION_GRE() == null ? 0
										: BRF107.getR1_PROVISION_GRE().intValue());

							}

							Cell cell12 = row.getCell(16);
							if (cell12 != null) {
								cell12.setCellValue(BRF107.getR1_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR1_OUTSTANDING_CORPORATE().intValue());

							}
							Cell cell13 = row.getCell(17);
							if (cell13 != null) {
								cell13.setCellValue(BRF107.getR1_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR1_PROVISION_CORPORATE().intValue());

							}

							Cell cell14 = row.getCell(18);
							if (cell14 != null) {
								cell14.setCellValue(BRF107.getR1_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR1_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell cell15 = row.getCell(19);
							if (cell15 != null) {
								cell15.setCellValue(BRF107.getR1_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR1_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell cell16 = row.getCell(20);
							if (cell16 != null) {
								cell16.setCellValue(BRF107.getR1_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR1_OUTSTANDING_HIGH().intValue());

							}
							Cell cell17 = row.getCell(21);
							if (cell17 != null) {
								cell17.setCellValue(BRF107.getR1_PROVISION_HIGH() == null ? 0
										: BRF107.getR1_PROVISION_HIGH().intValue());

							}
							Cell cell18 = row.getCell(22);
							if (cell18 != null) {
								cell18.setCellValue(BRF107.getR1_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR1_OUTSTANDING_SMALL().intValue());

							}
							Cell cell19 = row.getCell(23);
							if (cell19 != null) {
								cell19.setCellValue(BRF107.getR1_PROVISION_SMALL() == null ? 0
										: BRF107.getR1_PROVISION_SMALL().intValue());

							}

							Cell cell20 = row.getCell(24);
							if (cell20 != null) {
								cell20.setCellValue(BRF107.getR1_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR1_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell cell21 = row.getCell(25);
							if (cell21 != null) {
								cell21.setCellValue(BRF107.getR1_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR1_PROVISION_INDIVIDUAL().intValue());

							}

							////////////////////////////// ROW 2 ///////////////////////

							Row row1 = sheet.getRow(10);
							Cell R1cell = row1.getCell(4);
							if (R1cell != null) {
								R1cell.setCellValue(BRF107.getR2_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR2_OUTSTANDING_NBFI().intValue());
							}
							Cell R1cell1 = row1.getCell(5);
							if (R1cell1 != null) {
								R1cell1.setCellValue(BRF107.getR2_PROVISION_NBFI() == null ? 0
										: BRF107.getR2_PROVISION_NBFI().intValue());

							}

							Cell R1cell2 = row1.getCell(6);
							if (R1cell2 != null) {
								R1cell2.setCellValue(BRF107.getR2_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR2_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R1cell3 = row1.getCell(7);
							if (R1cell3 != null) {
								R1cell3.setCellValue(BRF107.getR2_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR2_PROVISION_FEDERAL().intValue());

							}
							Cell R1cell4 = row1.getCell(8);
							if (R1cell4 != null) {
								R1cell4.setCellValue(BRF107.getR2_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR2_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R1cell5 = row1.getCell(9);
							if (R1cell5 != null) {
								R1cell5.setCellValue(BRF107.getR2_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR2_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R1cell6 = row1.getCell(10);
							if (R1cell6 != null) {
								R1cell6.setCellValue(BRF107.getR2_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR2_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R1cell7 = row1.getCell(11);
							if (R1cell7 != null) {
								R1cell7.setCellValue(BRF107.getR2_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR2_PROVISION_EMIRATES().intValue());

							}

							Cell R1cell8 = row1.getCell(12);
							if (R1cell8 != null) {
								R1cell8.setCellValue(BRF107.getR2_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR2_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R1cell9 = row1.getCell(13);
							if (R1cell9 != null) {
								R1cell9.setCellValue(BRF107.getR2_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR2_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R1cell10 = row1.getCell(14);
							if (R1cell10 != null) {
								R1cell10.setCellValue(BRF107.getR2_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR2_OUTSTANDING_GRE().intValue());

							}
							Cell R1cell11 = row1.getCell(15);
							if (R1cell11 != null) {
								R1cell11.setCellValue(BRF107.getR2_PROVISION_GRE() == null ? 0
										: BRF107.getR2_PROVISION_GRE().intValue());

							}

							Cell R1cell12 = row1.getCell(16);
							if (R1cell12 != null) {
								R1cell12.setCellValue(BRF107.getR2_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR2_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R1cell13 = row1.getCell(17);
							if (R1cell13 != null) {
								R1cell13.setCellValue(BRF107.getR2_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR2_PROVISION_CORPORATE().intValue());

							}

							Cell R1cell14 = row1.getCell(18);
							if (R1cell14 != null) {
								R1cell14.setCellValue(BRF107.getR2_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR2_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R1cell15 = row1.getCell(19);
							if (R1cell15 != null) {
								R1cell15.setCellValue(BRF107.getR2_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR2_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R1cell16 = row1.getCell(20);
							if (R1cell16 != null) {
								R1cell16.setCellValue(BRF107.getR2_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR2_OUTSTANDING_HIGH().intValue());

							}
							Cell R1cell17 = row1.getCell(21);
							if (R1cell17 != null) {
								R1cell17.setCellValue(BRF107.getR2_PROVISION_HIGH() == null ? 0
										: BRF107.getR2_PROVISION_HIGH().intValue());

							}
							Cell R1cell18 = row1.getCell(22);
							if (R1cell18 != null) {
								R1cell18.setCellValue(BRF107.getR2_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR2_OUTSTANDING_SMALL().intValue());

							}
							Cell R1cell19 = row1.getCell(23);
							if (R1cell19 != null) {
								R1cell19.setCellValue(BRF107.getR2_PROVISION_SMALL() == null ? 0
										: BRF107.getR2_PROVISION_SMALL().intValue());

							}

							Cell R1cell20 = row1.getCell(24);
							if (R1cell20 != null) {
								R1cell20.setCellValue(BRF107.getR2_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR2_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R1cell21 = row1.getCell(25);
							if (R1cell21 != null) {
								R1cell21.setCellValue(BRF107.getR2_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR2_PROVISION_INDIVIDUAL().intValue());

							}

							///////////////////////// R5//////////////////////////////

							Row row2 = sheet.getRow(13);
							Cell R2cell = row2.getCell(4);
							if (R2cell != null) {
								R2cell.setCellValue(BRF107.getR5_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR5_OUTSTANDING_NBFI().intValue());
							}

							Cell R2cell2 = row2.getCell(6);
							if (R2cell2 != null) {
								R2cell2.setCellValue(BRF107.getR5_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR5_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R2cell4 = row2.getCell(8);
							if (R2cell4 != null) {
								R2cell4.setCellValue(BRF107.getR5_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR5_OUTSTANDING_NON_COMMERCIAL().intValue());

							}

							Cell R2cell6 = row2.getCell(10);
							if (R2cell6 != null) {
								R2cell6.setCellValue(BRF107.getR5_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR5_OUTSTANDING_EMIRATES().intValue());

							}

							Cell R2cell8 = row2.getCell(12);
							if (R2cell8 != null) {
								R2cell8.setCellValue(BRF107.getR5_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR5_OUTSTANDING_GOVT_GROSS().intValue());

							}

							Cell R2cell10 = row2.getCell(14);
							if (R2cell10 != null) {
								R2cell10.setCellValue(BRF107.getR5_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR5_OUTSTANDING_GRE().intValue());

							}

							Cell R2cell12 = row2.getCell(16);
							if (R2cell12 != null) {
								R2cell12.setCellValue(BRF107.getR5_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR5_OUTSTANDING_CORPORATE().intValue());

							}

							Cell R2cell14 = row2.getCell(18);
							if (R2cell14 != null) {
								R2cell14.setCellValue(BRF107.getR5_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR5_OUTSTANDING_OTHER_CORPORATE().intValue());

							}

							Cell R2cell16 = row2.getCell(20);
							if (R2cell16 != null) {
								R2cell16.setCellValue(BRF107.getR5_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR5_OUTSTANDING_HIGH().intValue());

							}

							Cell R2cell18 = row2.getCell(22);
							if (R2cell18 != null) {
								R2cell18.setCellValue(BRF107.getR5_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR5_OUTSTANDING_SMALL().intValue());

							}

							Cell R2cell20 = row2.getCell(24);
							if (R2cell20 != null) {
								R2cell20.setCellValue(BRF107.getR5_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR5_OUTSTANDING_INDIVIDUAL().intValue());

							}

							/////////////////////////// R6///////////////////////

							Row row3 = sheet.getRow(14);
							Cell R3cell = row3.getCell(4);
							if (R3cell != null) {
								R3cell.setCellValue(BRF107.getR6_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR6_OUTSTANDING_NBFI().intValue());
							}
							Cell R3cell1 = row3.getCell(5);
							if (R3cell1 != null) {
								R3cell1.setCellValue(BRF107.getR6_PROVISION_NBFI() == null ? 0
										: BRF107.getR6_PROVISION_NBFI().intValue());

							}

							Cell R3cell2 = row3.getCell(6);
							if (R3cell2 != null) {
								R3cell2.setCellValue(BRF107.getR6_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR6_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R3cell3 = row3.getCell(7);
							if (R3cell3 != null) {
								R3cell3.setCellValue(BRF107.getR6_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR6_PROVISION_FEDERAL().intValue());

							}
							Cell R3cell4 = row3.getCell(8);
							if (R3cell4 != null) {
								R3cell4.setCellValue(BRF107.getR6_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR6_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R3cell5 = row3.getCell(9);
							if (R3cell5 != null) {
								R3cell5.setCellValue(BRF107.getR6_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR6_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R3cell6 = row3.getCell(10);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF107.getR6_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR6_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R3cell7 = row3.getCell(11);
							if (R3cell7 != null) {
								R3cell7.setCellValue(BRF107.getR6_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR6_PROVISION_EMIRATES().intValue());

							}

							Cell R3cell8 = row3.getCell(12);
							if (R3cell8 != null) {
								R3cell8.setCellValue(BRF107.getR6_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR6_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R3cell9 = row3.getCell(13);
							if (R3cell9 != null) {
								R3cell9.setCellValue(BRF107.getR6_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR6_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R3cell10 = row3.getCell(14);
							if (R3cell10 != null) {
								R3cell10.setCellValue(BRF107.getR6_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR6_OUTSTANDING_GRE().intValue());

							}
							Cell R3cell11 = row3.getCell(15);
							if (R3cell11 != null) {
								R3cell11.setCellValue(BRF107.getR6_PROVISION_GRE() == null ? 0
										: BRF107.getR6_PROVISION_GRE().intValue());

							}

							Cell R3cell12 = row3.getCell(16);
							if (R3cell12 != null) {
								R3cell12.setCellValue(BRF107.getR6_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR6_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R3cell13 = row3.getCell(17);
							if (R3cell13 != null) {
								R3cell13.setCellValue(BRF107.getR6_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR6_PROVISION_CORPORATE().intValue());

							}

							Cell R3cell14 = row3.getCell(18);
							if (R3cell14 != null) {
								R3cell14.setCellValue(BRF107.getR6_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR6_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R3cell15 = row3.getCell(19);
							if (R3cell15 != null) {
								R3cell15.setCellValue(BRF107.getR6_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR6_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R3cell16 = row3.getCell(20);
							if (R3cell16 != null) {
								R3cell16.setCellValue(BRF107.getR6_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR6_OUTSTANDING_HIGH().intValue());

							}
							Cell R3cell17 = row3.getCell(21);
							if (R3cell17 != null) {
								R3cell17.setCellValue(BRF107.getR6_PROVISION_HIGH() == null ? 0
										: BRF107.getR6_PROVISION_HIGH().intValue());

							}
							Cell R3cell18 = row3.getCell(22);
							if (R3cell18 != null) {
								R3cell18.setCellValue(BRF107.getR6_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR6_OUTSTANDING_SMALL().intValue());

							}
							Cell R3cell19 = row3.getCell(23);
							if (R3cell19 != null) {
								R3cell19.setCellValue(BRF107.getR6_PROVISION_SMALL() == null ? 0
										: BRF107.getR6_PROVISION_SMALL().intValue());

							}

							Cell R3cell20 = row3.getCell(24);
							if (R3cell20 != null) {
								R3cell20.setCellValue(BRF107.getR6_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR6_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R3cell21 = row3.getCell(25);
							if (R3cell21 != null) {
								R3cell21.setCellValue(BRF107.getR6_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR6_PROVISION_INDIVIDUAL().intValue());

							}

							//////////////////////////// R7///////////////////////////

							Row row4 = sheet.getRow(15);
							Cell R4cell = row4.getCell(4);
							if (R4cell != null) {
								R4cell.setCellValue(BRF107.getR7_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR7_OUTSTANDING_NBFI().intValue());
							}
							Cell R4cell1 = row4.getCell(5);
							if (R4cell1 != null) {
								R4cell1.setCellValue(BRF107.getR7_PROVISION_NBFI() == null ? 0
										: BRF107.getR7_PROVISION_NBFI().intValue());

							}

							Cell R4cell2 = row4.getCell(6);
							if (R4cell2 != null) {
								R4cell2.setCellValue(BRF107.getR7_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR7_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R4cell3 = row4.getCell(7);
							if (R4cell3 != null) {
								R4cell3.setCellValue(BRF107.getR7_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR7_PROVISION_FEDERAL().intValue());

							}
							Cell R4cell4 = row4.getCell(8);
							if (R4cell4 != null) {
								R4cell4.setCellValue(BRF107.getR7_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR7_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R4cell5 = row4.getCell(9);
							if (R4cell5 != null) {
								R4cell5.setCellValue(BRF107.getR7_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR7_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R4cell6 = row4.getCell(10);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF107.getR7_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR7_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R4cell7 = row4.getCell(11);
							if (R4cell7 != null) {
								R4cell7.setCellValue(BRF107.getR7_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR7_PROVISION_EMIRATES().intValue());

							}

							Cell R4cell8 = row4.getCell(12);
							if (R4cell8 != null) {
								R4cell8.setCellValue(BRF107.getR7_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR7_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R4cell9 = row4.getCell(13);
							if (R4cell9 != null) {
								R4cell9.setCellValue(BRF107.getR7_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR7_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R4cell10 = row4.getCell(14);
							if (R4cell10 != null) {
								R4cell10.setCellValue(BRF107.getR7_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR7_OUTSTANDING_GRE().intValue());

							}
							Cell R4cell11 = row4.getCell(15);
							if (R4cell11 != null) {
								R4cell11.setCellValue(BRF107.getR7_PROVISION_GRE() == null ? 0
										: BRF107.getR7_PROVISION_GRE().intValue());

							}

							Cell R4cell12 = row4.getCell(16);
							if (R4cell12 != null) {
								R4cell12.setCellValue(BRF107.getR7_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR7_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R4cell13 = row4.getCell(17);
							if (R4cell13 != null) {
								R4cell13.setCellValue(BRF107.getR7_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR7_PROVISION_CORPORATE().intValue());

							}

							Cell R4cell14 = row4.getCell(18);
							if (R4cell14 != null) {
								R4cell14.setCellValue(BRF107.getR7_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR7_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R4cell15 = row4.getCell(19);
							if (R4cell15 != null) {
								R4cell15.setCellValue(BRF107.getR7_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR7_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R4cell16 = row4.getCell(20);
							if (R4cell16 != null) {
								R4cell16.setCellValue(BRF107.getR7_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR7_OUTSTANDING_HIGH().intValue());

							}
							Cell R4cell17 = row4.getCell(21);
							if (R4cell17 != null) {
								R4cell17.setCellValue(BRF107.getR7_PROVISION_HIGH() == null ? 0
										: BRF107.getR7_PROVISION_HIGH().intValue());

							}
							Cell R4cell18 = row4.getCell(22);
							if (R4cell18 != null) {
								R4cell18.setCellValue(BRF107.getR7_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR7_OUTSTANDING_SMALL().intValue());

							}
							Cell R4cell19 = row4.getCell(23);
							if (R4cell19 != null) {
								R4cell19.setCellValue(BRF107.getR7_PROVISION_SMALL() == null ? 0
										: BRF107.getR7_PROVISION_SMALL().intValue());

							}

							Cell R4cell20 = row4.getCell(24);
							if (R4cell20 != null) {
								R4cell20.setCellValue(BRF107.getR7_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR7_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R4cell21 = row4.getCell(25);
							if (R4cell21 != null) {
								R4cell21.setCellValue(BRF107.getR7_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR7_PROVISION_INDIVIDUAL().intValue());

							}

							///////////////////////// R10////////////////////////////

							Row row5 = sheet.getRow(18);
							Cell R5cell = row5.getCell(4);
							if (R5cell != null) {
								R5cell.setCellValue(BRF107.getR10_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR10_OUTSTANDING_NBFI().intValue());
							}

							Cell R5cell2 = row5.getCell(6);
							if (R5cell2 != null) {
								R5cell2.setCellValue(BRF107.getR10_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR10_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R5cell4 = row5.getCell(8);
							if (R5cell4 != null) {
								R5cell4.setCellValue(BRF107.getR10_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR10_OUTSTANDING_NON_COMMERCIAL().intValue());

							}

							Cell R5cell6 = row5.getCell(10);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF107.getR10_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR10_OUTSTANDING_EMIRATES().intValue());

							}

							Cell R5cell8 = row5.getCell(12);
							if (R5cell8 != null) {
								R5cell8.setCellValue(BRF107.getR10_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR10_OUTSTANDING_GOVT_GROSS().intValue());

							}

							Cell R5cell10 = row5.getCell(14);
							if (R5cell10 != null) {
								R5cell10.setCellValue(BRF107.getR10_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR10_OUTSTANDING_GRE().intValue());

							}

							Cell R5cell12 = row5.getCell(16);
							if (R5cell12 != null) {
								R5cell12.setCellValue(BRF107.getR10_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR10_OUTSTANDING_CORPORATE().intValue());

							}

							Cell R5cell14 = row5.getCell(18);
							if (R5cell14 != null) {
								R5cell14.setCellValue(BRF107.getR10_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR10_OUTSTANDING_OTHER_CORPORATE().intValue());

							}

							Cell R5cell16 = row5.getCell(20);
							if (R5cell16 != null) {
								R5cell16.setCellValue(BRF107.getR10_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR10_OUTSTANDING_HIGH().intValue());

							}

							Cell R5cell18 = row5.getCell(22);
							if (R5cell18 != null) {
								R5cell18.setCellValue(BRF107.getR10_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR10_OUTSTANDING_SMALL().intValue());

							}

							Cell R5cell20 = row5.getCell(24);
							if (R5cell20 != null) {
								R5cell20.setCellValue(BRF107.getR10_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR10_OUTSTANDING_INDIVIDUAL().intValue());

							}

							////////////////////////// R11//////////////////////////////

							Row row6 = sheet.getRow(19);
							Cell R6cell = row6.getCell(4);
							if (R6cell != null) {
								R6cell.setCellValue(BRF107.getR11_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR11_OUTSTANDING_NBFI().intValue());
							}

							Cell R6cell2 = row6.getCell(6);
							if (R6cell2 != null) {
								R6cell2.setCellValue(BRF107.getR11_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR11_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R6cell4 = row6.getCell(8);
							if (R6cell4 != null) {
								R6cell4.setCellValue(BRF107.getR11_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR11_OUTSTANDING_NON_COMMERCIAL().intValue());

							}

							Cell R6cell6 = row6.getCell(10);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF107.getR11_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR11_OUTSTANDING_EMIRATES().intValue());

							}

							Cell R6cell8 = row6.getCell(12);
							if (R6cell8 != null) {
								R6cell8.setCellValue(BRF107.getR11_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR11_OUTSTANDING_GOVT_GROSS().intValue());

							}

							Cell R6cell10 = row6.getCell(14);
							if (R6cell10 != null) {
								R6cell10.setCellValue(BRF107.getR11_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR11_OUTSTANDING_GRE().intValue());

							}

							Cell R6cell12 = row6.getCell(16);
							if (R6cell12 != null) {
								R6cell12.setCellValue(BRF107.getR11_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR11_OUTSTANDING_CORPORATE().intValue());

							}

							Cell R6cell14 = row6.getCell(18);
							if (R6cell14 != null) {
								R6cell14.setCellValue(BRF107.getR11_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR11_OUTSTANDING_OTHER_CORPORATE().intValue());

							}

							Cell R6cell16 = row6.getCell(20);
							if (R6cell16 != null) {
								R6cell16.setCellValue(BRF107.getR11_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR11_OUTSTANDING_HIGH().intValue());

							}

							Cell R6cell18 = row6.getCell(22);
							if (R6cell18 != null) {
								R6cell18.setCellValue(BRF107.getR11_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR11_OUTSTANDING_SMALL().intValue());

							}

							Cell R6cell20 = row6.getCell(24);
							if (R6cell20 != null) {
								R6cell20.setCellValue(BRF107.getR11_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR11_OUTSTANDING_INDIVIDUAL().intValue());

							}

							////////////////// R12/////////////////////

							Row row7 = sheet.getRow(20);
							Cell R7cell = row7.getCell(4);
							if (R7cell != null) {
								R7cell.setCellValue(BRF107.getR12_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR12_OUTSTANDING_NBFI().intValue());
							}
							Cell R7cell1 = row7.getCell(5);
							if (R7cell1 != null) {
								R7cell1.setCellValue(BRF107.getR12_PROVISION_NBFI() == null ? 0
										: BRF107.getR12_PROVISION_NBFI().intValue());

							}

							Cell R7cell2 = row7.getCell(6);
							if (R7cell2 != null) {
								R7cell2.setCellValue(BRF107.getR12_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR12_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R7cell3 = row7.getCell(7);
							if (R7cell3 != null) {
								R7cell3.setCellValue(BRF107.getR12_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR12_PROVISION_FEDERAL().intValue());

							}
							Cell R7cell4 = row7.getCell(8);
							if (R7cell4 != null) {
								R7cell4.setCellValue(BRF107.getR12_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR12_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R7cell5 = row7.getCell(9);
							if (R7cell5 != null) {
								R7cell5.setCellValue(BRF107.getR12_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR12_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R7cell6 = row7.getCell(10);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF107.getR12_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR12_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R7cell7 = row7.getCell(11);
							if (R7cell7 != null) {
								R7cell7.setCellValue(BRF107.getR12_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR12_PROVISION_EMIRATES().intValue());

							}

							Cell R7cell8 = row7.getCell(12);
							if (R7cell8 != null) {
								R7cell8.setCellValue(BRF107.getR12_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR12_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R7cell9 = row7.getCell(13);
							if (R7cell9 != null) {
								R7cell9.setCellValue(BRF107.getR12_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR12_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R7cell10 = row7.getCell(14);
							if (R7cell10 != null) {
								R7cell10.setCellValue(BRF107.getR12_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR12_OUTSTANDING_GRE().intValue());

							}
							Cell R7cell11 = row7.getCell(15);
							if (R7cell11 != null) {
								R7cell11.setCellValue(BRF107.getR12_PROVISION_GRE() == null ? 0
										: BRF107.getR12_PROVISION_GRE().intValue());

							}

							Cell R7cell12 = row7.getCell(16);
							if (R7cell12 != null) {
								R7cell12.setCellValue(BRF107.getR12_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR12_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R7cell13 = row7.getCell(17);
							if (R7cell13 != null) {
								R7cell13.setCellValue(BRF107.getR12_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR12_PROVISION_CORPORATE().intValue());

							}

							Cell R7cell14 = row7.getCell(18);
							if (R7cell14 != null) {
								R7cell14.setCellValue(BRF107.getR12_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR12_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R7cell15 = row7.getCell(19);
							if (R7cell15 != null) {
								R7cell15.setCellValue(BRF107.getR12_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR12_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R7cell16 = row7.getCell(20);
							if (R7cell16 != null) {
								R7cell16.setCellValue(BRF107.getR12_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR12_OUTSTANDING_HIGH().intValue());

							}
							Cell R7cell17 = row7.getCell(21);
							if (R7cell17 != null) {
								R7cell17.setCellValue(BRF107.getR12_PROVISION_HIGH() == null ? 0
										: BRF107.getR12_PROVISION_HIGH().intValue());

							}
							Cell R7cell18 = row7.getCell(22);
							if (R7cell18 != null) {
								R7cell18.setCellValue(BRF107.getR12_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR12_OUTSTANDING_SMALL().intValue());

							}
							Cell R7cell19 = row7.getCell(23);
							if (R7cell19 != null) {
								R7cell19.setCellValue(BRF107.getR12_PROVISION_SMALL() == null ? 0
										: BRF107.getR12_PROVISION_SMALL().intValue());

							}

							Cell R7cell20 = row7.getCell(24);
							if (R7cell20 != null) {
								R7cell20.setCellValue(BRF107.getR12_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR12_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R7cell21 = row7.getCell(25);
							if (R7cell21 != null) {
								R7cell21.setCellValue(BRF107.getR12_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR12_PROVISION_INDIVIDUAL().intValue());

							}

							///////////////////////// R13//////////////////////////

							Row row8 = sheet.getRow(21);
							Cell R8cell = row8.getCell(4);
							if (R8cell != null) {
								R8cell.setCellValue(BRF107.getR13_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR13_OUTSTANDING_NBFI().intValue());
							}
							Cell R8cell1 = row8.getCell(5);
							if (R8cell1 != null) {
								R8cell1.setCellValue(BRF107.getR13_PROVISION_NBFI() == null ? 0
										: BRF107.getR13_PROVISION_NBFI().intValue());

							}

							Cell R8cell2 = row8.getCell(6);
							if (R8cell2 != null) {
								R8cell2.setCellValue(BRF107.getR13_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR13_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R8cell3 = row8.getCell(7);
							if (R8cell3 != null) {
								R8cell3.setCellValue(BRF107.getR13_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR13_PROVISION_FEDERAL().intValue());

							}
							Cell R8cell4 = row8.getCell(8);
							if (R8cell4 != null) {
								R8cell4.setCellValue(BRF107.getR13_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR13_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R8cell5 = row8.getCell(9);
							if (R8cell5 != null) {
								R8cell5.setCellValue(BRF107.getR13_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR13_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R8cell6 = row8.getCell(10);
							if (R8cell6 != null) {
								R8cell6.setCellValue(BRF107.getR13_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR13_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R8cell7 = row8.getCell(11);
							if (R8cell7 != null) {
								R8cell7.setCellValue(BRF107.getR13_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR13_PROVISION_EMIRATES().intValue());

							}

							Cell R8cell8 = row8.getCell(12);
							if (R8cell8 != null) {
								R8cell8.setCellValue(BRF107.getR13_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR13_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R8cell9 = row8.getCell(13);
							if (R8cell9 != null) {
								R8cell9.setCellValue(BRF107.getR13_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR13_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R8cell10 = row8.getCell(14);
							if (R8cell10 != null) {
								R8cell10.setCellValue(BRF107.getR13_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR13_OUTSTANDING_GRE().intValue());

							}
							Cell R8cell11 = row8.getCell(15);
							if (R8cell11 != null) {
								R8cell11.setCellValue(BRF107.getR13_PROVISION_GRE() == null ? 0
										: BRF107.getR13_PROVISION_GRE().intValue());

							}

							Cell R8cell12 = row8.getCell(16);
							if (R8cell12 != null) {
								R8cell12.setCellValue(BRF107.getR13_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR13_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R8cell13 = row8.getCell(17);
							if (R8cell13 != null) {
								R8cell13.setCellValue(BRF107.getR13_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR13_PROVISION_CORPORATE().intValue());

							}

							Cell R8cell14 = row8.getCell(18);
							if (R8cell14 != null) {
								R8cell14.setCellValue(BRF107.getR13_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR13_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R8cell15 = row8.getCell(19);
							if (R8cell15 != null) {
								R8cell15.setCellValue(BRF107.getR13_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR13_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R8cell16 = row8.getCell(20);
							if (R8cell16 != null) {
								R8cell16.setCellValue(BRF107.getR13_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR13_OUTSTANDING_HIGH().intValue());

							}
							Cell R8cell17 = row8.getCell(21);
							if (R8cell17 != null) {
								R8cell17.setCellValue(BRF107.getR13_PROVISION_HIGH() == null ? 0
										: BRF107.getR13_PROVISION_HIGH().intValue());

							}
							Cell R8cell18 = row8.getCell(22);
							if (R8cell18 != null) {
								R8cell18.setCellValue(BRF107.getR13_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR13_OUTSTANDING_SMALL().intValue());

							}
							Cell R8cell19 = row8.getCell(23);
							if (R8cell19 != null) {
								R8cell19.setCellValue(BRF107.getR13_PROVISION_SMALL() == null ? 0
										: BRF107.getR13_PROVISION_SMALL().intValue());

							}

							Cell R8cell20 = row8.getCell(24);
							if (R8cell20 != null) {
								R8cell20.setCellValue(BRF107.getR13_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR13_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R8cell21 = row8.getCell(25);
							if (R8cell21 != null) {
								R8cell21.setCellValue(BRF107.getR13_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR13_PROVISION_INDIVIDUAL().intValue());

							}

							///////////////////////// R14//////////////////////////

							Row row9 = sheet.getRow(22);
							Cell R9cell = row9.getCell(4);
							if (R9cell != null) {
								R9cell.setCellValue(BRF107.getR14_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR14_OUTSTANDING_NBFI().intValue());
							}
							Cell R9cell1 = row9.getCell(5);
							if (R9cell1 != null) {
								R9cell1.setCellValue(BRF107.getR14_PROVISION_NBFI() == null ? 0
										: BRF107.getR14_PROVISION_NBFI().intValue());

							}

							Cell R9cell2 = row9.getCell(6);
							if (R9cell2 != null) {
								R9cell2.setCellValue(BRF107.getR14_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR14_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R9cell3 = row9.getCell(7);
							if (R9cell3 != null) {
								R9cell3.setCellValue(BRF107.getR14_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR14_PROVISION_FEDERAL().intValue());

							}
							Cell R9cell4 = row9.getCell(8);
							if (R9cell4 != null) {
								R9cell4.setCellValue(BRF107.getR14_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR14_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R9cell5 = row9.getCell(9);
							if (R9cell5 != null) {
								R9cell5.setCellValue(BRF107.getR14_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR14_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R9cell6 = row9.getCell(10);
							if (R9cell6 != null) {
								R9cell6.setCellValue(BRF107.getR14_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR14_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R9cell7 = row9.getCell(11);
							if (R9cell7 != null) {
								R9cell7.setCellValue(BRF107.getR14_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR14_PROVISION_EMIRATES().intValue());

							}

							Cell R9cell8 = row9.getCell(12);
							if (R9cell8 != null) {
								R9cell8.setCellValue(BRF107.getR14_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR14_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R9cell9 = row9.getCell(13);
							if (R9cell9 != null) {
								R9cell9.setCellValue(BRF107.getR14_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR14_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R9cell10 = row9.getCell(14);
							if (R9cell10 != null) {
								R9cell10.setCellValue(BRF107.getR14_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR14_OUTSTANDING_GRE().intValue());

							}
							Cell R9cell11 = row9.getCell(15);
							if (R9cell11 != null) {
								R9cell11.setCellValue(BRF107.getR14_PROVISION_GRE() == null ? 0
										: BRF107.getR14_PROVISION_GRE().intValue());

							}

							Cell R9cell12 = row9.getCell(16);
							if (R9cell12 != null) {
								R9cell12.setCellValue(BRF107.getR14_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR14_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R9cell13 = row9.getCell(17);
							if (R9cell13 != null) {
								R9cell13.setCellValue(BRF107.getR14_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR14_PROVISION_CORPORATE().intValue());

							}

							Cell R9cell14 = row9.getCell(18);
							if (R9cell14 != null) {
								R9cell14.setCellValue(BRF107.getR14_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR14_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R9cell15 = row9.getCell(19);
							if (R9cell15 != null) {
								R9cell15.setCellValue(BRF107.getR14_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR14_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R9cell16 = row9.getCell(20);
							if (R9cell16 != null) {
								R9cell16.setCellValue(BRF107.getR14_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR14_OUTSTANDING_HIGH().intValue());

							}
							Cell R9cell17 = row9.getCell(21);
							if (R9cell17 != null) {
								R9cell17.setCellValue(BRF107.getR14_PROVISION_HIGH() == null ? 0
										: BRF107.getR14_PROVISION_HIGH().intValue());

							}
							Cell R9cell18 = row9.getCell(22);
							if (R9cell18 != null) {
								R9cell18.setCellValue(BRF107.getR14_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR14_OUTSTANDING_SMALL().intValue());

							}
							Cell R9cell19 = row9.getCell(23);
							if (R9cell19 != null) {
								R9cell19.setCellValue(BRF107.getR14_PROVISION_SMALL() == null ? 0
										: BRF107.getR14_PROVISION_SMALL().intValue());

							}

							Cell R9cell20 = row9.getCell(24);
							if (R9cell20 != null) {
								R9cell20.setCellValue(BRF107.getR14_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR14_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R9cell21 = row9.getCell(25);
							if (R9cell21 != null) {
								R9cell21.setCellValue(BRF107.getR14_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR14_PROVISION_INDIVIDUAL().intValue());

							}

							////////////////////////// R17//////////////////////

							Row row10 = sheet.getRow(25);
							Cell R10cell = row10.getCell(4);
							if (R10cell != null) {
								R10cell.setCellValue(BRF107.getR17_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR17_OUTSTANDING_NBFI().intValue());
							}

							Cell R10cell2 = row10.getCell(6);
							if (R10cell2 != null) {
								R10cell2.setCellValue(BRF107.getR17_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR17_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R10cell4 = row10.getCell(8);
							if (R10cell4 != null) {
								R10cell4.setCellValue(BRF107.getR17_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR17_OUTSTANDING_NON_COMMERCIAL().intValue());

							}

							Cell R10cell6 = row10.getCell(10);
							if (R10cell6 != null) {
								R10cell6.setCellValue(BRF107.getR17_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR17_OUTSTANDING_EMIRATES().intValue());

							}

							Cell R10cell8 = row10.getCell(12);
							if (R10cell8 != null) {
								R10cell8.setCellValue(BRF107.getR17_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR17_OUTSTANDING_GOVT_GROSS().intValue());

							}

							Cell R10cell10 = row10.getCell(14);
							if (R10cell10 != null) {
								R10cell10.setCellValue(BRF107.getR17_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR17_OUTSTANDING_GRE().intValue());

							}

							Cell R10cell12 = row10.getCell(16);
							if (R10cell12 != null) {
								R10cell12.setCellValue(BRF107.getR17_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR17_OUTSTANDING_CORPORATE().intValue());

							}

							Cell R10cell14 = row10.getCell(18);
							if (R10cell14 != null) {
								R10cell14.setCellValue(BRF107.getR17_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR17_OUTSTANDING_OTHER_CORPORATE().intValue());

							}

							Cell R10cell16 = row10.getCell(20);
							if (R10cell16 != null) {
								R10cell16.setCellValue(BRF107.getR17_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR17_OUTSTANDING_HIGH().intValue());

							}

							Cell R10cell18 = row10.getCell(22);
							if (R10cell18 != null) {
								R10cell18.setCellValue(BRF107.getR17_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR17_OUTSTANDING_SMALL().intValue());

							}

							Cell R10cell20 = row10.getCell(24);
							if (R10cell20 != null) {
								R10cell20.setCellValue(BRF107.getR17_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR17_OUTSTANDING_INDIVIDUAL().intValue());

							}

							////////////////////////// R18///////////////////////////

							Row row11 = sheet.getRow(26);
							Cell R11cell = row11.getCell(4);
							if (R11cell != null) {
								R11cell.setCellValue(BRF107.getR18_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR18_OUTSTANDING_NBFI().intValue());
							}

							Cell R11cell2 = row11.getCell(6);
							if (R11cell2 != null) {
								R11cell2.setCellValue(BRF107.getR18_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR18_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R11cell4 = row11.getCell(8);
							if (R11cell4 != null) {
								R11cell4.setCellValue(BRF107.getR18_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR18_OUTSTANDING_NON_COMMERCIAL().intValue());

							}

							Cell R11cell6 = row11.getCell(10);
							if (R11cell6 != null) {
								R11cell6.setCellValue(BRF107.getR18_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR18_OUTSTANDING_EMIRATES().intValue());

							}

							Cell R11cell8 = row11.getCell(12);
							if (R11cell8 != null) {
								R11cell8.setCellValue(BRF107.getR18_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR18_OUTSTANDING_GOVT_GROSS().intValue());

							}

							Cell R11cell10 = row11.getCell(14);
							if (R11cell10 != null) {
								R11cell10.setCellValue(BRF107.getR18_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR18_OUTSTANDING_GRE().intValue());

							}

							Cell R11cell12 = row11.getCell(16);
							if (R11cell12 != null) {
								R11cell12.setCellValue(BRF107.getR18_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR18_OUTSTANDING_CORPORATE().intValue());

							}

							Cell R11cell14 = row11.getCell(18);
							if (R11cell14 != null) {
								R11cell14.setCellValue(BRF107.getR18_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR18_OUTSTANDING_OTHER_CORPORATE().intValue());

							}

							Cell R11cell16 = row11.getCell(20);
							if (R11cell16 != null) {
								R11cell16.setCellValue(BRF107.getR18_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR18_OUTSTANDING_HIGH().intValue());

							}

							Cell R11cell18 = row11.getCell(22);
							if (R11cell18 != null) {
								R11cell18.setCellValue(BRF107.getR18_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR18_OUTSTANDING_SMALL().intValue());

							}

							Cell R11cell20 = row11.getCell(24);
							if (R11cell20 != null) {
								R11cell20.setCellValue(BRF107.getR18_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR18_OUTSTANDING_INDIVIDUAL().intValue());

							}

							//////////////////////////////// R19/////////////////////

							Row row12 = sheet.getRow(27);
							Cell R12cell = row12.getCell(4);
							if (R12cell != null) {
								R12cell.setCellValue(BRF107.getR19_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR19_OUTSTANDING_NBFI().intValue());
							}
							Cell R12cell1 = row12.getCell(5);
							if (R12cell1 != null) {
								R12cell1.setCellValue(BRF107.getR19_PROVISION_NBFI() == null ? 0
										: BRF107.getR19_PROVISION_NBFI().intValue());

							}

							Cell R12cell2 = row12.getCell(6);
							if (R12cell2 != null) {
								R12cell2.setCellValue(BRF107.getR19_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR19_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R12cell3 = row12.getCell(7);
							if (R12cell3 != null) {
								R12cell3.setCellValue(BRF107.getR19_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR19_PROVISION_FEDERAL().intValue());

							}
							Cell R12cell4 = row12.getCell(8);
							if (R12cell4 != null) {
								R12cell4.setCellValue(BRF107.getR19_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR19_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R12cell5 = row12.getCell(9);
							if (R12cell5 != null) {
								R12cell5.setCellValue(BRF107.getR19_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR19_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R12cell6 = row12.getCell(10);
							if (R12cell6 != null) {
								R12cell6.setCellValue(BRF107.getR19_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR19_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R12cell7 = row12.getCell(11);
							if (R12cell7 != null) {
								R12cell7.setCellValue(BRF107.getR19_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR19_PROVISION_EMIRATES().intValue());

							}

							Cell R12cell8 = row12.getCell(12);
							if (R12cell8 != null) {
								R12cell8.setCellValue(BRF107.getR19_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR19_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R12cell9 = row12.getCell(13);
							if (R12cell9 != null) {
								R12cell9.setCellValue(BRF107.getR19_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR19_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R12cell10 = row12.getCell(14);
							if (R12cell10 != null) {
								R12cell10.setCellValue(BRF107.getR19_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR19_OUTSTANDING_GRE().intValue());

							}
							Cell R12cell11 = row12.getCell(15);
							if (R12cell11 != null) {
								R12cell11.setCellValue(BRF107.getR19_PROVISION_GRE() == null ? 0
										: BRF107.getR19_PROVISION_GRE().intValue());

							}

							Cell R12cell12 = row12.getCell(16);
							if (R12cell12 != null) {
								R12cell12.setCellValue(BRF107.getR19_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR19_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R12cell13 = row12.getCell(17);
							if (R12cell13 != null) {
								R12cell13.setCellValue(BRF107.getR19_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR19_PROVISION_CORPORATE().intValue());

							}

							Cell R12cell14 = row12.getCell(18);
							if (R12cell14 != null) {
								R12cell14.setCellValue(BRF107.getR19_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR19_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R12cell15 = row12.getCell(19);
							if (R12cell15 != null) {
								R12cell15.setCellValue(BRF107.getR19_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR19_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R12cell16 = row12.getCell(20);
							if (R12cell16 != null) {
								R12cell16.setCellValue(BRF107.getR19_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR19_OUTSTANDING_HIGH().intValue());

							}
							Cell R12cell17 = row12.getCell(21);
							if (R12cell17 != null) {
								R12cell17.setCellValue(BRF107.getR19_PROVISION_HIGH() == null ? 0
										: BRF107.getR19_PROVISION_HIGH().intValue());

							}
							Cell R12cell18 = row12.getCell(22);
							if (R12cell18 != null) {
								R12cell18.setCellValue(BRF107.getR19_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR19_OUTSTANDING_SMALL().intValue());

							}
							Cell R12cell19 = row12.getCell(23);
							if (R12cell19 != null) {
								R12cell19.setCellValue(BRF107.getR19_PROVISION_SMALL() == null ? 0
										: BRF107.getR19_PROVISION_SMALL().intValue());

							}

							Cell R12cell20 = row12.getCell(24);
							if (R12cell20 != null) {
								R12cell20.setCellValue(BRF107.getR19_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR19_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R12cell21 = row12.getCell(25);
							if (R12cell21 != null) {
								R12cell21.setCellValue(BRF107.getR19_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR19_PROVISION_INDIVIDUAL().intValue());

							}

							////////////////////// R20//////////////////////////

							Row row13 = sheet.getRow(28);
							Cell R13cell = row13.getCell(4);
							if (R13cell != null) {
								R13cell.setCellValue(BRF107.getR20_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR20_OUTSTANDING_NBFI().intValue());
							}
							Cell R13cell1 = row13.getCell(5);
							if (R13cell1 != null) {
								R13cell1.setCellValue(BRF107.getR20_PROVISION_NBFI() == null ? 0
										: BRF107.getR20_PROVISION_NBFI().intValue());

							}

							Cell R13cell2 = row13.getCell(6);
							if (R13cell2 != null) {
								R13cell2.setCellValue(BRF107.getR20_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR20_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R13cell3 = row13.getCell(7);
							if (R13cell3 != null) {
								R13cell3.setCellValue(BRF107.getR20_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR20_PROVISION_FEDERAL().intValue());

							}
							Cell R13cell4 = row13.getCell(8);
							if (R13cell4 != null) {
								R13cell4.setCellValue(BRF107.getR20_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR20_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R13cell5 = row13.getCell(9);
							if (R13cell5 != null) {
								R13cell5.setCellValue(BRF107.getR20_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR20_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R13cell6 = row13.getCell(10);
							if (R13cell6 != null) {
								R13cell6.setCellValue(BRF107.getR20_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR20_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R13cell7 = row13.getCell(11);
							if (R13cell7 != null) {
								R13cell7.setCellValue(BRF107.getR20_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR20_PROVISION_EMIRATES().intValue());

							}

							Cell R13cell8 = row13.getCell(12);
							if (R13cell8 != null) {
								R13cell8.setCellValue(BRF107.getR20_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR20_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R13cell9 = row13.getCell(13);
							if (R13cell9 != null) {
								R13cell9.setCellValue(BRF107.getR20_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR20_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R13cell10 = row13.getCell(14);
							if (R13cell10 != null) {
								R13cell10.setCellValue(BRF107.getR20_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR20_OUTSTANDING_GRE().intValue());

							}
							Cell R13cell11 = row13.getCell(15);
							if (R13cell11 != null) {
								R13cell11.setCellValue(BRF107.getR20_PROVISION_GRE() == null ? 0
										: BRF107.getR20_PROVISION_GRE().intValue());

							}

							Cell R13cell12 = row13.getCell(16);
							if (R13cell12 != null) {
								R13cell12.setCellValue(BRF107.getR20_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR20_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R13cell13 = row13.getCell(17);
							if (R13cell13 != null) {
								R13cell13.setCellValue(BRF107.getR20_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR20_PROVISION_CORPORATE().intValue());

							}

							Cell R13cell14 = row13.getCell(18);
							if (R13cell14 != null) {
								R13cell14.setCellValue(BRF107.getR20_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR20_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R13cell15 = row13.getCell(19);
							if (R13cell15 != null) {
								R13cell15.setCellValue(BRF107.getR20_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR20_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R13cell16 = row13.getCell(20);
							if (R13cell16 != null) {
								R13cell16.setCellValue(BRF107.getR20_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR20_OUTSTANDING_HIGH().intValue());

							}
							Cell R13cell17 = row13.getCell(21);
							if (R13cell17 != null) {
								R13cell17.setCellValue(BRF107.getR20_PROVISION_HIGH() == null ? 0
										: BRF107.getR20_PROVISION_HIGH().intValue());

							}
							Cell R13cell18 = row13.getCell(22);
							if (R13cell18 != null) {
								R13cell18.setCellValue(BRF107.getR20_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR20_OUTSTANDING_SMALL().intValue());

							}
							Cell R13cell19 = row13.getCell(23);
							if (R13cell19 != null) {
								R13cell19.setCellValue(BRF107.getR20_PROVISION_SMALL() == null ? 0
										: BRF107.getR20_PROVISION_SMALL().intValue());

							}

							Cell R13cell20 = row13.getCell(24);
							if (R13cell20 != null) {
								R13cell20.setCellValue(BRF107.getR20_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR20_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R13cell21 = row13.getCell(25);
							if (R13cell21 != null) {
								R13cell21.setCellValue(BRF107.getR20_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR20_PROVISION_INDIVIDUAL().intValue());

							}

							////////////////////////// R21//////////////////

							Row row14 = sheet.getRow(29);
							Cell R14cell = row14.getCell(4);
							if (R14cell != null) {
								R14cell.setCellValue(BRF107.getR21_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR21_OUTSTANDING_NBFI().intValue());
							}
							Cell R14cell1 = row14.getCell(5);
							if (R14cell1 != null) {
								R14cell1.setCellValue(BRF107.getR21_PROVISION_NBFI() == null ? 0
										: BRF107.getR21_PROVISION_NBFI().intValue());

							}

							Cell R14cell2 = row14.getCell(6);
							if (R14cell2 != null) {
								R14cell2.setCellValue(BRF107.getR21_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR21_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R14cell3 = row14.getCell(7);
							if (R14cell3 != null) {
								R14cell3.setCellValue(BRF107.getR21_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR21_PROVISION_FEDERAL().intValue());

							}
							Cell R14cell4 = row14.getCell(8);
							if (R14cell4 != null) {
								R14cell4.setCellValue(BRF107.getR21_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR21_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R14cell5 = row14.getCell(9);
							if (R14cell5 != null) {
								R14cell5.setCellValue(BRF107.getR21_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR21_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R14cell6 = row14.getCell(10);
							if (R14cell6 != null) {
								R14cell6.setCellValue(BRF107.getR21_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR21_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R14cell7 = row14.getCell(11);
							if (R14cell7 != null) {
								R14cell7.setCellValue(BRF107.getR21_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR21_PROVISION_EMIRATES().intValue());

							}

							Cell R14cell8 = row14.getCell(12);
							if (R14cell8 != null) {
								R14cell8.setCellValue(BRF107.getR21_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR21_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R14cell9 = row14.getCell(13);
							if (R14cell9 != null) {
								R14cell9.setCellValue(BRF107.getR21_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR21_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R14cell10 = row14.getCell(14);
							if (R14cell10 != null) {
								R14cell10.setCellValue(BRF107.getR21_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR21_OUTSTANDING_GRE().intValue());

							}
							Cell R14cell11 = row14.getCell(15);
							if (R14cell11 != null) {
								R14cell11.setCellValue(BRF107.getR21_PROVISION_GRE() == null ? 0
										: BRF107.getR21_PROVISION_GRE().intValue());

							}

							Cell R14cell12 = row14.getCell(16);
							if (R14cell12 != null) {
								R14cell12.setCellValue(BRF107.getR21_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR21_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R14cell13 = row14.getCell(17);
							if (R14cell13 != null) {
								R14cell13.setCellValue(BRF107.getR21_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR21_PROVISION_CORPORATE().intValue());

							}

							Cell R14cell14 = row14.getCell(18);
							if (R14cell14 != null) {
								R14cell14.setCellValue(BRF107.getR21_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR21_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R14cell15 = row14.getCell(19);
							if (R14cell15 != null) {
								R14cell15.setCellValue(BRF107.getR21_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR21_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R14cell16 = row14.getCell(20);
							if (R14cell16 != null) {
								R14cell16.setCellValue(BRF107.getR21_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR21_OUTSTANDING_HIGH().intValue());

							}
							Cell R14cell17 = row14.getCell(21);
							if (R14cell17 != null) {
								R14cell17.setCellValue(BRF107.getR21_PROVISION_HIGH() == null ? 0
										: BRF107.getR21_PROVISION_HIGH().intValue());

							}
							Cell R14cell18 = row14.getCell(22);
							if (R14cell18 != null) {
								R14cell18.setCellValue(BRF107.getR21_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR21_OUTSTANDING_SMALL().intValue());

							}
							Cell R14cell19 = row14.getCell(23);
							if (R14cell19 != null) {
								R14cell19.setCellValue(BRF107.getR21_PROVISION_SMALL() == null ? 0
										: BRF107.getR21_PROVISION_SMALL().intValue());

							}

							Cell R14cell20 = row14.getCell(24);
							if (R14cell20 != null) {
								R14cell20.setCellValue(BRF107.getR21_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR21_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R14cell21 = row14.getCell(25);
							if (R14cell21 != null) {
								R14cell21.setCellValue(BRF107.getR21_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR21_PROVISION_INDIVIDUAL().intValue());

							}

							/////////////////// R22//////////////
							Row row15 = sheet.getRow(30);
							Cell R15cell = row15.getCell(4);
							if (R15cell != null) {
								R15cell.setCellValue(BRF107.getR22_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR22_OUTSTANDING_NBFI().intValue());
							}
							Cell R15cell1 = row15.getCell(5);
							if (R15cell1 != null) {
								R15cell1.setCellValue(BRF107.getR22_PROVISION_NBFI() == null ? 0
										: BRF107.getR22_PROVISION_NBFI().intValue());

							}

							Cell R15cell2 = row15.getCell(6);
							if (R15cell2 != null) {
								R15cell2.setCellValue(BRF107.getR22_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR22_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R15cell3 = row15.getCell(7);
							if (R15cell3 != null) {
								R15cell3.setCellValue(BRF107.getR22_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR22_PROVISION_FEDERAL().intValue());

							}
							Cell R15cell4 = row15.getCell(8);
							if (R15cell4 != null) {
								R15cell4.setCellValue(BRF107.getR22_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR22_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R15cell5 = row15.getCell(9);
							if (R15cell5 != null) {
								R15cell5.setCellValue(BRF107.getR22_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR22_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R15cell6 = row15.getCell(10);
							if (R15cell6 != null) {
								R15cell6.setCellValue(BRF107.getR22_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR22_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R15cell7 = row15.getCell(11);
							if (R15cell7 != null) {
								R15cell7.setCellValue(BRF107.getR22_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR22_PROVISION_EMIRATES().intValue());

							}

							Cell R15cell8 = row15.getCell(12);
							if (R15cell8 != null) {
								R15cell8.setCellValue(BRF107.getR22_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR22_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R15cell9 = row15.getCell(13);
							if (R15cell9 != null) {
								R15cell9.setCellValue(BRF107.getR22_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR22_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R15cell10 = row15.getCell(14);
							if (R15cell10 != null) {
								R15cell10.setCellValue(BRF107.getR22_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR22_OUTSTANDING_GRE().intValue());

							}
							Cell R15cell11 = row15.getCell(15);
							if (R15cell11 != null) {
								R15cell11.setCellValue(BRF107.getR22_PROVISION_GRE() == null ? 0
										: BRF107.getR22_PROVISION_GRE().intValue());

							}

							Cell R15cell12 = row15.getCell(16);
							if (R15cell12 != null) {
								R15cell12.setCellValue(BRF107.getR22_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR22_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R15cell13 = row15.getCell(17);
							if (R15cell13 != null) {
								R15cell13.setCellValue(BRF107.getR22_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR22_PROVISION_CORPORATE().intValue());

							}

							Cell R15cell14 = row15.getCell(18);
							if (R15cell14 != null) {
								R15cell14.setCellValue(BRF107.getR22_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR22_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R15cell15 = row15.getCell(19);
							if (R15cell15 != null) {
								R15cell15.setCellValue(BRF107.getR22_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR22_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R15cell16 = row15.getCell(20);
							if (R15cell16 != null) {
								R15cell16.setCellValue(BRF107.getR22_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR22_OUTSTANDING_HIGH().intValue());

							}
							Cell R15cell17 = row15.getCell(21);
							if (R15cell17 != null) {
								R15cell17.setCellValue(BRF107.getR22_PROVISION_HIGH() == null ? 0
										: BRF107.getR22_PROVISION_HIGH().intValue());

							}
							Cell R15cell18 = row15.getCell(22);
							if (R15cell18 != null) {
								R15cell18.setCellValue(BRF107.getR22_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR22_OUTSTANDING_SMALL().intValue());

							}
							Cell R15cell19 = row15.getCell(23);
							if (R15cell19 != null) {
								R15cell19.setCellValue(BRF107.getR22_PROVISION_SMALL() == null ? 0
										: BRF107.getR22_PROVISION_SMALL().intValue());

							}

							Cell R15cell20 = row15.getCell(24);
							if (R15cell20 != null) {
								R15cell20.setCellValue(BRF107.getR22_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR22_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R15cell21 = row15.getCell(25);
							if (R15cell21 != null) {
								R15cell21.setCellValue(BRF107.getR22_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR22_PROVISION_INDIVIDUAL().intValue());

							}

							///////////////// R23////////////////

							Row row16 = sheet.getRow(31);
							Cell R16cell = row16.getCell(4);
							if (R16cell != null) {
								R16cell.setCellValue(BRF107.getR23_OUTSTANDING_NBFI() == null ? 0
										: BRF107.getR23_OUTSTANDING_NBFI().intValue());
							}
							Cell R16cell1 = row16.getCell(5);
							if (R16cell1 != null) {
								R16cell1.setCellValue(BRF107.getR23_PROVISION_NBFI() == null ? 0
										: BRF107.getR23_PROVISION_NBFI().intValue());

							}

							Cell R16cell2 = row16.getCell(6);
							if (R16cell2 != null) {
								R16cell2.setCellValue(BRF107.getR23_OUTSTANDING_FEDERAL() == null ? 0
										: BRF107.getR23_OUTSTANDING_FEDERAL().intValue());

							}

							Cell R16cell3 = row16.getCell(7);
							if (R16cell3 != null) {
								R16cell3.setCellValue(BRF107.getR23_PROVISION_FEDERAL() == null ? 0
										: BRF107.getR23_PROVISION_FEDERAL().intValue());

							}
							Cell R16cell4 = row16.getCell(8);
							if (R16cell4 != null) {
								R16cell4.setCellValue(BRF107.getR23_OUTSTANDING_NON_COMMERCIAL() == null ? 0
										: BRF107.getR23_OUTSTANDING_NON_COMMERCIAL().intValue());

							}
							Cell R16cell5 = row16.getCell(9);
							if (R16cell5 != null) {
								R16cell5.setCellValue(BRF107.getR23_PROVISON_NON_COMMERCIAL() == null ? 0
										: BRF107.getR23_PROVISON_NON_COMMERCIAL().intValue());

							}

							Cell R16cell6 = row16.getCell(10);
							if (R16cell6 != null) {
								R16cell6.setCellValue(BRF107.getR23_OUTSTANDING_EMIRATES() == null ? 0
										: BRF107.getR23_OUTSTANDING_EMIRATES().intValue());

							}
							Cell R16cell7 = row16.getCell(11);
							if (R16cell7 != null) {
								R16cell7.setCellValue(BRF107.getR23_PROVISION_EMIRATES() == null ? 0
										: BRF107.getR23_PROVISION_EMIRATES().intValue());

							}

							Cell R16cell8 = row16.getCell(12);
							if (R16cell8 != null) {
								R16cell8.setCellValue(BRF107.getR23_OUTSTANDING_GOVT_GROSS() == null ? 0
										: BRF107.getR23_OUTSTANDING_GOVT_GROSS().intValue());

							}
							Cell R16cell9 = row16.getCell(13);
							if (R16cell9 != null) {
								R16cell9.setCellValue(BRF107.getR23_PROVISION_GOVT_GROSS() == null ? 0
										: BRF107.getR23_PROVISION_GOVT_GROSS().intValue());

							}
							Cell R16cell10 = row16.getCell(14);
							if (R16cell10 != null) {
								R16cell10.setCellValue(BRF107.getR23_OUTSTANDING_GRE() == null ? 0
										: BRF107.getR23_OUTSTANDING_GRE().intValue());

							}
							Cell R16cell11 = row16.getCell(15);
							if (R16cell11 != null) {
								R16cell11.setCellValue(BRF107.getR23_PROVISION_GRE() == null ? 0
										: BRF107.getR23_PROVISION_GRE().intValue());

							}

							Cell R16cell12 = row16.getCell(16);
							if (R16cell12 != null) {
								R16cell12.setCellValue(BRF107.getR23_OUTSTANDING_CORPORATE() == null ? 0
										: BRF107.getR23_OUTSTANDING_CORPORATE().intValue());

							}
							Cell R16cell13 = row16.getCell(17);
							if (R16cell13 != null) {
								R16cell13.setCellValue(BRF107.getR23_PROVISION_CORPORATE() == null ? 0
										: BRF107.getR23_PROVISION_CORPORATE().intValue());

							}

							Cell R16cell14 = row16.getCell(18);
							if (R16cell14 != null) {
								R16cell14.setCellValue(BRF107.getR23_OUTSTANDING_OTHER_CORPORATE() == null ? 0
										: BRF107.getR23_OUTSTANDING_OTHER_CORPORATE().intValue());

							}
							Cell R16cell15 = row16.getCell(19);
							if (R16cell15 != null) {
								R16cell15.setCellValue(BRF107.getR23_PROVISION_OTHER_CORPORATE() == null ? 0
										: BRF107.getR23_PROVISION_OTHER_CORPORATE().intValue());

							}

							Cell R16cell16 = row16.getCell(20);
							if (R16cell16 != null) {
								R16cell16.setCellValue(BRF107.getR23_OUTSTANDING_HIGH() == null ? 0
										: BRF107.getR23_OUTSTANDING_HIGH().intValue());

							}
							Cell R16cell17 = row16.getCell(21);
							if (R16cell17 != null) {
								R16cell17.setCellValue(BRF107.getR23_PROVISION_HIGH() == null ? 0
										: BRF107.getR23_PROVISION_HIGH().intValue());

							}
							Cell R16cell18 = row16.getCell(22);
							if (R16cell18 != null) {
								R16cell18.setCellValue(BRF107.getR23_OUTSTANDING_SMALL() == null ? 0
										: BRF107.getR23_OUTSTANDING_SMALL().intValue());

							}
							Cell R16cell19 = row16.getCell(23);
							if (R16cell19 != null) {
								R16cell19.setCellValue(BRF107.getR23_PROVISION_SMALL() == null ? 0
										: BRF107.getR23_PROVISION_SMALL().intValue());

							}

							Cell R16cell20 = row16.getCell(24);
							if (R16cell20 != null) {
								R16cell20.setCellValue(BRF107.getR23_OUTSTANDING_INDIVIDUAL() == null ? 0
										: BRF107.getR23_OUTSTANDING_INDIVIDUAL().intValue());

							}
							Cell R16cell21 = row16.getCell(25);
							if (R16cell21 != null) {
								R16cell21.setCellValue(BRF107.getR23_PROVISION_INDIVIDUAL() == null ? 0
										: BRF107.getR23_PROVISION_INDIVIDUAL().intValue());

							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-107-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-107-A.xls");

		return outputFile;

	}

	/*
	 * public String detailChanges107(BRF107_DETAIL_ENTITY detail, String foracid,
	 * String report_addl_criteria_1, BigDecimal act_balance_amt_lc, String
	 * report_label_1, String report_name_1) {
	 * 
	 * String msg = "";
	 * 
	 * try {
	 * 
	 * Session hs = sessionFactory.getCurrentSession();
	 * Optional<BRF107_DETAIL_ENTITY> Brf107detail =
	 * brf107_detailrepo.findById(foracid);
	 * 
	 * if (Brf107detail.isPresent()) { BRF107_DETAIL_ENTITY BRFdetail =
	 * Brf107detail.get();
	 * 
	 * if (BRFdetail.getReport_label_1().equals(report_label_1) &&
	 * BRFdetail.getReport_name_1().equals(report_name_1) &&
	 * BRFdetail.getAct_balance_amt_lc().equals(act_balance_amt_lc) &&
	 * BRFdetail.getReport_addl_criteria_1().equals(report_addl_criteria_1)
	 * 
	 * ) { msg = "No modification done"; } else {
	 * 
	 * BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
	 * BRFdetail.setReport_label_1(report_label_1);
	 * BRFdetail.setReport_name_1(report_name_1);
	 * BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
	 * brf107_detailrepo.save(BRFdetail);
	 * 
	 * // hs.saveOrUpdate(detail); logger.info("Edited Record"); msg =
	 * "Edited Successfully"; } } else { msg = "No data Found"; }
	 * 
	 * } catch (Exception e) {
	 * 
	 * msg = "error occured. Please contact Administrator"; e.printStackTrace(); }
	 * 
	 * return msg; }
	 */

	/****
	 * ARCH SUMMARY
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView getArchieveBRF0107View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_107_A_REPORT_ENTITY> T1rep = new ArrayList<BRF_107_A_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_107_A_REPORT_ENTITY> T1Master = new ArrayList<BRF_107_A_REPORT_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF_107_A_REPORT_ENTITY a where a.report_date = ?1 ",
					BRF_107_A_REPORT_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF107ARCH");
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

	public ModelAndView ARCHgetBRF0107currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF107_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF107_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF107_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF107_ARCHIV_ENTITY> T1Master = new ArrayList<BRF107_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs
					.createQuery("from BRF107_ARCHIV_ENTITY a where a.report_date = ?1", BRF107_ARCHIV_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();

		for (Object[] a : result) {
			String cust_id = (String) a[0];
			String foracid = (String) a[1];
			String acct_name = (String) a[2];
			BigDecimal eab_lc = (BigDecimal) a[3];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[4];
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
			String version = (String) a[46];
			String remarks = (String) a[47];

			BRF107_ARCHIV_ENTITY py = new BRF107_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, version,
					remarks);

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

		mv.setViewName("RR" + "/" + "BRF107ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
