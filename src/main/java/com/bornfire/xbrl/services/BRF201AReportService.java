package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.BRF201_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_C_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF069_SUMMARY_D_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF201_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF201_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_A;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_B;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_C;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_D;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_E;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_F;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_ENTITY_G;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_A;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_B;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_C;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_D;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_E;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_F;
import com.bornfire.xbrl.entities.BRBS.BRF201_SUMMARY_REP_G;
import com.bornfire.xbrl.entities.BRBS.BRF202A_entity;
import com.bornfire.xbrl.entities.BRBS.BRF69_SUMMARY_A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF84A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.ReportBRF202AData;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.YourFormDatas;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
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
public class BRF201AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF201AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF201_DetailRepo brf201_Detailrepo;

	@Autowired
	BRF201_SUMMARY_REP_A brf201_SUMMARY_REP_A;

	@Autowired
	BRF201_SUMMARY_REP_B brf201_SUMMARY_REP_B;

	@Autowired
	BRF201_SUMMARY_REP_C brf201_SUMMARY_REP_C;

	@Autowired
	BRF201_SUMMARY_REP_D brf201_SUMMARY_REP_D;

	@Autowired
	BRF201_SUMMARY_REP_E brf201_SUMMARY_REP_E;

	@Autowired
	BRF201_SUMMARY_REP_F brf201_SUMMARY_REP_F;

	@Autowired
	BRF201_SUMMARY_REP_G brf201_SUMMARY_REP_G;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF201_SUMMARY_ENTITY_A a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF201_SUMMARY_ENTITY_A a").getSingleResult();
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

	public ModelAndView getBRF201AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		// Query<Object[]> qr;
		// List<BRF201A_A2_RPT> T1Master1 = new ArrayList<BRF201A_A2_RPT>();

		List<BRF201_SUMMARY_ENTITY_A> T1Master = new ArrayList<BRF201_SUMMARY_ENTITY_A>();
		List<BRF201_SUMMARY_ENTITY_B> T2Master = new ArrayList<BRF201_SUMMARY_ENTITY_B>();
		List<BRF201_SUMMARY_ENTITY_C> T3Master = new ArrayList<BRF201_SUMMARY_ENTITY_C>();
		List<BRF201_SUMMARY_ENTITY_D> T4Master = new ArrayList<BRF201_SUMMARY_ENTITY_D>();
		List<BRF201_SUMMARY_ENTITY_E> T5Master = new ArrayList<BRF201_SUMMARY_ENTITY_E>();
		List<BRF201_SUMMARY_ENTITY_F> T6Master = new ArrayList<BRF201_SUMMARY_ENTITY_F>();
		List<BRF201_SUMMARY_ENTITY_G> T7Master = new ArrayList<BRF201_SUMMARY_ENTITY_G>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_A a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_A.class).setParameter(1, df.parse(todate)).getResultList();
			T2Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_B a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_B.class).setParameter(1, df.parse(todate)).getResultList();
			T3Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_C a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_C.class).setParameter(1, df.parse(todate)).getResultList();
			T4Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_D a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_D.class).setParameter(1, df.parse(todate)).getResultList();
			T5Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_E a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_E.class).setParameter(1, df.parse(todate)).getResultList();
			T6Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_F a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_F.class).setParameter(1, df.parse(todate)).getResultList();
			T7Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_G a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_G.class).setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF201A_A2_RPT a where a.report_date = ?1 ",
			 * BRF201A_A2_RPT.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF201");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("modify_flg", T2Master.size() > 0 ? T2Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T2Master.size() > 0 ? T2Master.get(0).getModify_user() : null);
		mv.addObject("reportsummary2", T2Master);
		mv.addObject("reportsummary3", T3Master);
		mv.addObject("reportsummary4", T4Master);
		mv.addObject("reportsummary5", T5Master);
		mv.addObject("reportsummary6", T6Master);
		mv.addObject("reportsummary7", T7Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF201AcurrentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF201_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF201_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF201_DETAILTABLE  where report_date = ?1");
		}
		List<BRF201_DETAIL_ENTITY> T1Master = new ArrayList<BRF201_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF201_DETAIL_ENTITY a where a.report_date = ?1", BRF201_DETAIL_ENTITY.class)
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
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];

			BRF201_DETAIL_ENTITY py = new BRF201_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks);
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

		mv.setViewName("RR" + "/" + "ReportBRF201A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF201A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		File outputFile = null;

		logger.info("Getting Output file :" + reportId);
		fileName = "t" + reportId + "_" + todate;

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile = null;
					logger.info("Getting Jasper file :" + reportId);

					if (dtltype.equals("report") && !(filetype.equals("detailexcel"))) {
						// Add more Jasper files if needed
						System.out.println("22");
						InputStream[] jasperFiles = {
								this.getClass().getResourceAsStream("/static/jasper/BRF201A.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201B.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201C.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201D.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201E.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201F.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201G.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF201H.jrxml"), };

						// Compile JasperReports
						JasperReport[] jasperReports = new JasperReport[jasperFiles.length];
						for (int i = 0; i < jasperFiles.length; i++) {
							jasperReports[i] = JasperCompileManager.compileReport(jasperFiles[i]);
						}

						// System.out.println(Month + Year); // Commented out, as it seems unnecessary

						HashMap<String, Object> map = new HashMap<>();
						map.put("REPORT_DATE", todate);

						// Fill JasperPrint for each report
						JasperPrint[] jasperPrints = new JasperPrint[jasperReports.length];

						for (int i = 0; i < jasperReports.length; i++) {
							try (Connection connection = srcdataSource.getConnection()) {
								jasperPrints[i] = JasperFillManager.fillReport(jasperReports[i], map, connection);
							}
						}

						// Combine JasperPrints
//		                if (jasperPrints.length > 0 && jasperPrints[0].getPages().size() > 0) {
//		                    
						JasperPrint combinedJasperPrint = new JasperPrint();
						for (JasperPrint jasperPrint : jasperPrints) {
							List<JRPrintPage> pages = jasperPrint.getPages();
							for (JRPrintPage page : pages) {
								combinedJasperPrint.addPage(page);
							}
						}

						fileName = "BRF201" + ".xlsx";
						path += File.separator + fileName; // Use File.separator for path construction

						SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
						reportConfig.setSheetNames(new String[] { fileName });
						reportConfig.setIgnoreGraphics(true);
						JRXlsxExporter exporter = new JRXlsxExporter();
						exporter.setExporterInput(new SimpleExporterInput(combinedJasperPrint));
						exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
						exporter.setConfiguration(reportConfig); // Set the configuration
						exporter.exportReport();
						// Helper method to adjust the vertical position of a page
						// Your class definition here

						// Your main method or other code here
//		                }
//		                else {
//		                    // Handle case when there is no data
//		                    System.out.println("No data to export");
//		                }

					} else {
						// Your existing code for non-report Jasper files
						if (filetype.equals("detailexcel")) {
							System.out.println("1");
							if (dtltype.equals("report")) {
								jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF201_Detail.jrxml");
							}
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF201_Detail.jrxml");
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
							fileName = fileName + ".xlsx";
							path += fileName;
							JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
							JRXlsxExporter exporter = new JRXlsxExporter();
							exporter.setExporterInput(new SimpleExporterInput(jp));
							exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
							exporter.exportReport();
							logger.info("Excel File exported");
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				outputFile = new File(path);
				return outputFile;
			} else {
				List<BRF201_SUMMARY_ENTITY_A> T1Master = new ArrayList<BRF201_SUMMARY_ENTITY_A>();
				List<BRF201_SUMMARY_ENTITY_B> T2Master = new ArrayList<BRF201_SUMMARY_ENTITY_B>();
				List<BRF201_SUMMARY_ENTITY_C> T3Master = new ArrayList<BRF201_SUMMARY_ENTITY_C>();
				List<BRF201_SUMMARY_ENTITY_D> T4Master = new ArrayList<BRF201_SUMMARY_ENTITY_D>();
				List<BRF201_SUMMARY_ENTITY_E> T5Master = new ArrayList<BRF201_SUMMARY_ENTITY_E>();
				List<BRF201_SUMMARY_ENTITY_F> T6Master = new ArrayList<BRF201_SUMMARY_ENTITY_F>();
				List<BRF201_SUMMARY_ENTITY_G> T7Master = new ArrayList<BRF201_SUMMARY_ENTITY_G>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_A a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_A.class).setParameter(1, df.parse(todate)).getResultList();
					T2Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_B a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_B.class).setParameter(1, df.parse(todate)).getResultList();
					T3Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_C a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_C.class).setParameter(1, df.parse(todate)).getResultList();
					T4Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_D a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_D.class).setParameter(1, df.parse(todate)).getResultList();
					T5Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_E a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_E.class).setParameter(1, df.parse(todate)).getResultList();
					T6Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_F a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_F.class).setParameter(1, df.parse(todate)).getResultList();
					T7Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_G a where a.report_date = ?1 order by srl_no",
							BRF201_SUMMARY_ENTITY_G.class).setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-201-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					Sheet sheet = workbook.getSheetAt(0);

					if (T1Master.size() == 1) {
						for (BRF201_SUMMARY_ENTITY_A brf201 : T1Master) {

							Row row = sheet.getRow(8);

							/*
							 * Cell cell = row.getCell(4); if (cell != null) {
							 * cell.setCellValue(brf201.getR1_network_in_uae() == null ? 0 :
							 * brf201.getR1_network_in_uae().intValue()); }
							 */
							Cell cell1 = row.getCell(3);
							if (cell1 != null) {
								cell1.setCellValue(brf201.getR1_beginning_of_period() == null ? 0
										: brf201.getR1_beginning_of_period().intValue());
							}

							Cell cell2 = row.getCell(4);
							if (cell2 != null) {
								cell2.setCellValue(brf201.getR1_opened_during_period() == null ? 0
										: brf201.getR1_opened_during_period().intValue());
							}

							Cell cell3 = row.getCell(5);
							if (cell3 != null) {
								cell3.setCellValue(brf201.getR1_closed_during_period() == null ? 0
										: brf201.getR1_closed_during_period().intValue());
							}
							Cell cell4 = row.getCell(6);
							if (cell4 != null) {
								cell4.setCellValue(brf201.getR1_end_of_period() == null ? 0
										: brf201.getR1_end_of_period().intValue());
							}

							Cell cell5 = row.getCell(7);
							if (cell5 != null) {
								cell5.setCellValue(
										brf201.getR1_abudhabi() == null ? 0 : brf201.getR1_abudhabi().intValue());
							}
							Cell cell = row.getCell(8);
							if (cell != null) {
								cell.setCellValue(brf201.getR1_dubai() == null ? 0 : brf201.getR1_dubai().intValue());
							}

							Cell cell7 = row.getCell(9);
							if (cell7 != null) {
								cell7.setCellValue(
										brf201.getR1_sharjah() == null ? 0 : brf201.getR1_sharjah().intValue());
							}
							Cell cell9 = row.getCell(10);
							if (cell9 != null) {
								cell9.setCellValue(brf201.getR1_ajman() == null ? 0 : brf201.getR1_ajman().intValue());
							}
							Cell cell8 = row.getCell(11);
							if (cell8 != null) {
								cell8.setCellValue(brf201.getR1_rak() == null ? 0 : brf201.getR1_rak().intValue());
							}

							Cell cell10 = row.getCell(12);
							if (cell10 != null) {
								cell10.setCellValue(
										brf201.getR1_fujairah() == null ? 0 : brf201.getR1_fujairah().intValue());
							}
							Cell cell61 = row.getCell(13);
							if (cell61 != null) {
								cell61.setCellValue(brf201.getR1_uaq() == null ? 0 : brf201.getR1_uaq().intValue());
							}
							Row R2row = sheet.getRow(9);
							Cell R2cell1 = R2row.getCell(3);
							if (R2cell1 != null) {
								R2cell1.setCellValue(brf201.getR2_beginning_of_period() == null ? 0
										: brf201.getR2_beginning_of_period().intValue());
							}

							Cell R2cell2 = R2row.getCell(4);
							if (R2cell2 != null) {
								R2cell2.setCellValue(brf201.getR2_opened_during_period() == null ? 0
										: brf201.getR2_opened_during_period().intValue());
							}

							Cell R2cell3 = R2row.getCell(5);
							if (R2cell3 != null) {
								R2cell3.setCellValue(brf201.getR2_closed_during_period() == null ? 0
										: brf201.getR2_closed_during_period().intValue());
							}
							Cell R2cell4 = R2row.getCell(6);
							if (R2cell4 != null) {
								R2cell4.setCellValue(brf201.getR2_end_of_period() == null ? 0
										: brf201.getR2_end_of_period().intValue());
							}

							Cell R2cell5 = R2row.getCell(7);
							if (R2cell5 != null) {
								R2cell5.setCellValue(
										brf201.getR2_abudhabi() == null ? 0 : brf201.getR2_abudhabi().intValue());
							}
							Cell R2cell = R2row.getCell(8);
							if (R2cell != null) {
								R2cell.setCellValue(brf201.getR2_dubai() == null ? 0 : brf201.getR2_dubai().intValue());
							}

							Cell R2cell7 = R2row.getCell(9);
							if (R2cell7 != null) {
								R2cell7.setCellValue(
										brf201.getR2_sharjah() == null ? 0 : brf201.getR2_sharjah().intValue());
							}
							Cell R2cell9 = R2row.getCell(10);
							if (R2cell9 != null) {
								R2cell9.setCellValue(
										brf201.getR2_ajman() == null ? 0 : brf201.getR2_ajman().intValue());
							}
							Cell R2cell8 = R2row.getCell(11);
							if (R2cell8 != null) {
								R2cell8.setCellValue(brf201.getR2_rak() == null ? 0 : brf201.getR2_rak().intValue());
							}

							Cell R2cell10 = R2row.getCell(12);
							if (R2cell10 != null) {
								R2cell10.setCellValue(
										brf201.getR2_fujairah() == null ? 0 : brf201.getR2_fujairah().intValue());
							}
							Cell R2cell61 = R2row.getCell(13);
							if (R2cell61 != null) {
								R2cell61.setCellValue(brf201.getR2_uaq() == null ? 0 : brf201.getR2_uaq().intValue());
							}

							Row R3row = sheet.getRow(10);
							Cell R3cell1 = R3row.getCell(3);
							if (R3cell1 != null) {
								R3cell1.setCellValue(brf201.getR3_beginning_of_period() == null ? 0
										: brf201.getR3_beginning_of_period().intValue());
							}

							Cell R3cell2 = R3row.getCell(4);
							if (R3cell2 != null) {
								R3cell2.setCellValue(brf201.getR3_opened_during_period() == null ? 0
										: brf201.getR3_opened_during_period().intValue());
							}

							Cell R3cell3 = R3row.getCell(5);
							if (R3cell3 != null) {
								R3cell3.setCellValue(brf201.getR3_closed_during_period() == null ? 0
										: brf201.getR3_closed_during_period().intValue());
							}
							Cell R3cell4 = R3row.getCell(6);
							if (R3cell4 != null) {
								R3cell4.setCellValue(brf201.getR3_end_of_period() == null ? 0
										: brf201.getR3_end_of_period().intValue());
							}

							Cell R3cell5 = R3row.getCell(7);
							if (R3cell5 != null) {
								R3cell5.setCellValue(
										brf201.getR3_abudhabi() == null ? 0 : brf201.getR3_abudhabi().intValue());
							}
							Cell R3cell = R3row.getCell(8);
							if (R3cell != null) {
								R3cell.setCellValue(brf201.getR3_dubai() == null ? 0 : brf201.getR3_dubai().intValue());
							}

							Cell R3cell7 = R3row.getCell(9);
							if (R3cell7 != null) {
								R3cell7.setCellValue(
										brf201.getR3_sharjah() == null ? 0 : brf201.getR3_sharjah().intValue());
							}
							Cell R3cell9 = R3row.getCell(10);
							if (R3cell9 != null) {
								R3cell9.setCellValue(
										brf201.getR3_ajman() == null ? 0 : brf201.getR3_ajman().intValue());
							}
							Cell R3cell8 = R3row.getCell(11);
							if (R3cell8 != null) {
								R3cell8.setCellValue(brf201.getR3_rak() == null ? 0 : brf201.getR3_rak().intValue());
							}

							Cell R3cell10 = R3row.getCell(12);
							if (R3cell10 != null) {
								R3cell10.setCellValue(
										brf201.getR3_fujairah() == null ? 0 : brf201.getR3_fujairah().intValue());
							}
							Cell R3cell61 = R3row.getCell(13);
							if (R3cell61 != null) {
								R3cell61.setCellValue(brf201.getR3_uaq() == null ? 0 : brf201.getR3_uaq().intValue());
							}

							Row R4row = sheet.getRow(11);
							Cell R4cell1 = R4row.getCell(3);
							if (R4cell1 != null) {
								R4cell1.setCellValue(brf201.getR4_beginning_of_period() == null ? 0
										: brf201.getR4_beginning_of_period().intValue());
							}

							Cell R4cell2 = R4row.getCell(4);
							if (R4cell2 != null) {
								R4cell2.setCellValue(brf201.getR4_opened_during_period() == null ? 0
										: brf201.getR4_opened_during_period().intValue());
							}

							Cell R4cell3 = R4row.getCell(5);
							if (R4cell3 != null) {
								R4cell3.setCellValue(brf201.getR4_closed_during_period() == null ? 0
										: brf201.getR4_closed_during_period().intValue());
							}
							Cell R4cell4 = R4row.getCell(6);
							if (R4cell4 != null) {
								R4cell4.setCellValue(brf201.getR4_end_of_period() == null ? 0
										: brf201.getR4_end_of_period().intValue());
							}

							Cell R4cell5 = R4row.getCell(7);
							if (R4cell5 != null) {
								R4cell5.setCellValue(
										brf201.getR4_abudhabi() == null ? 0 : brf201.getR4_abudhabi().intValue());
							}
							Cell R4cell = R4row.getCell(8);
							if (R4cell != null) {
								R4cell.setCellValue(brf201.getR4_dubai() == null ? 0 : brf201.getR4_dubai().intValue());
							}

							Cell R4cell7 = R4row.getCell(9);
							if (R4cell7 != null) {
								R4cell7.setCellValue(
										brf201.getR4_sharjah() == null ? 0 : brf201.getR4_sharjah().intValue());
							}
							Cell R4cell9 = R4row.getCell(10);
							if (R4cell9 != null) {
								R4cell9.setCellValue(
										brf201.getR4_ajman() == null ? 0 : brf201.getR4_ajman().intValue());
							}
							Cell R4cell8 = R4row.getCell(11);
							if (R4cell8 != null) {
								R4cell8.setCellValue(brf201.getR4_rak() == null ? 0 : brf201.getR4_rak().intValue());
							}

							Cell R4cell10 = R4row.getCell(12);
							if (R4cell10 != null) {
								R4cell10.setCellValue(
										brf201.getR4_fujairah() == null ? 0 : brf201.getR4_fujairah().intValue());
							}
							Cell R4cell61 = R4row.getCell(13);
							if (R4cell61 != null) {
								R4cell61.setCellValue(brf201.getR4_uaq() == null ? 0 : brf201.getR4_uaq().intValue());
							}
							Row R5row = sheet.getRow(12);

							Cell R5cell1 = R5row.getCell(3);
							if (R5cell1 != null) {
								R5cell1.setCellValue(brf201.getR5_beginning_of_period() == null ? 0
										: brf201.getR5_beginning_of_period().intValue());
							}

							Cell R5cell2 = R5row.getCell(4);
							if (R5cell2 != null) {
								R5cell2.setCellValue(brf201.getR5_opened_during_period() == null ? 0
										: brf201.getR5_opened_during_period().intValue());
							}

							Cell R5cell3 = R5row.getCell(5);
							if (R5cell3 != null) {
								R5cell3.setCellValue(brf201.getR5_closed_during_period() == null ? 0
										: brf201.getR5_closed_during_period().intValue());
							}
							Cell R5cell4 = R5row.getCell(6);
							if (R5cell4 != null) {
								R5cell4.setCellValue(brf201.getR5_end_of_period() == null ? 0
										: brf201.getR5_end_of_period().intValue());
							}

							Cell R5cell5 = R5row.getCell(7);
							if (R5cell5 != null) {
								R5cell5.setCellValue(
										brf201.getR5_abudhabi() == null ? 0 : brf201.getR5_abudhabi().intValue());
							}
							Cell R5cell = R5row.getCell(8);
							if (R5cell != null) {
								R5cell.setCellValue(brf201.getR5_dubai() == null ? 0 : brf201.getR5_dubai().intValue());
							}

							Cell R5cell7 = R5row.getCell(9);
							if (R5cell7 != null) {
								R5cell7.setCellValue(
										brf201.getR5_sharjah() == null ? 0 : brf201.getR5_sharjah().intValue());
							}
							Cell R5cell9 = R5row.getCell(10);
							if (R5cell9 != null) {
								R5cell9.setCellValue(
										brf201.getR5_ajman() == null ? 0 : brf201.getR5_ajman().intValue());
							}
							Cell R5cell8 = R5row.getCell(11);
							if (R5cell8 != null) {
								R5cell8.setCellValue(brf201.getR5_rak() == null ? 0 : brf201.getR5_rak().intValue());
							}

							Cell R5cell10 = R5row.getCell(12);
							if (R5cell10 != null) {
								R5cell10.setCellValue(
										brf201.getR5_fujairah() == null ? 0 : brf201.getR5_fujairah().intValue());
							}
							Cell R5cell61 = R5row.getCell(13);
							if (R5cell61 != null) {
								R5cell61.setCellValue(brf201.getR5_uaq() == null ? 0 : brf201.getR5_uaq().intValue());
							}
							Row R6row = sheet.getRow(13);

							Cell R6cell1 = R6row.getCell(3);
							if (R6cell1 != null) {
								R6cell1.setCellValue(brf201.getR6_beginning_of_period() == null ? 0
										: brf201.getR6_beginning_of_period().intValue());
							}

							Cell R6cell2 = R6row.getCell(4);
							if (R6cell2 != null) {
								R6cell2.setCellValue(brf201.getR6_opened_during_period() == null ? 0
										: brf201.getR6_opened_during_period().intValue());
							}

							Cell R6cell3 = R6row.getCell(5);
							if (R6cell3 != null) {
								R6cell3.setCellValue(brf201.getR6_closed_during_period() == null ? 0
										: brf201.getR6_closed_during_period().intValue());
							}
							Cell R6cell4 = R6row.getCell(6);
							if (R6cell4 != null) {
								R6cell4.setCellValue(brf201.getR6_end_of_period() == null ? 0
										: brf201.getR6_end_of_period().intValue());
							}

							Cell R6cell5 = R6row.getCell(7);
							if (R6cell5 != null) {
								R6cell5.setCellValue(
										brf201.getR6_abudhabi() == null ? 0 : brf201.getR6_abudhabi().intValue());
							}
							Cell R6cell = R6row.getCell(8);
							if (R6cell != null) {
								R6cell.setCellValue(brf201.getR6_dubai() == null ? 0 : brf201.getR6_dubai().intValue());
							}

							Cell R6cell7 = R6row.getCell(9);
							if (R6cell7 != null) {
								R6cell7.setCellValue(
										brf201.getR6_sharjah() == null ? 0 : brf201.getR6_sharjah().intValue());
							}
							Cell R6cell9 = R6row.getCell(10);
							if (R6cell9 != null) {
								R6cell9.setCellValue(
										brf201.getR6_ajman() == null ? 0 : brf201.getR6_ajman().intValue());
							}
							Cell R6cell8 = R6row.getCell(11);
							if (R6cell8 != null) {
								R6cell8.setCellValue(brf201.getR6_rak() == null ? 0 : brf201.getR6_rak().intValue());
							}

							Cell R6cell10 = R6row.getCell(12);
							if (R6cell10 != null) {
								R6cell10.setCellValue(
										brf201.getR6_fujairah() == null ? 0 : brf201.getR6_fujairah().intValue());
							}
							Cell R6cell61 = R6row.getCell(13);
							if (R6cell61 != null) {
								R6cell61.setCellValue(brf201.getR6_uaq() == null ? 0 : brf201.getR6_uaq().intValue());
							}
							Row R7row = sheet.getRow(14);

							Cell R7cell1 = R7row.getCell(3);
							if (R7cell1 != null) {
								R7cell1.setCellValue(brf201.getR7_beginning_of_period() == null ? 0
										: brf201.getR7_beginning_of_period().intValue());
							}

							Cell R7cell2 = R7row.getCell(4);
							if (R7cell2 != null) {
								R7cell2.setCellValue(brf201.getR7_opened_during_period() == null ? 0
										: brf201.getR7_opened_during_period().intValue());
							}

							Cell R7cell3 = R7row.getCell(5);
							if (R7cell3 != null) {
								R7cell3.setCellValue(brf201.getR7_closed_during_period() == null ? 0
										: brf201.getR7_closed_during_period().intValue());
							}
							Cell R7cell4 = R7row.getCell(6);
							if (R7cell4 != null) {
								R7cell4.setCellValue(brf201.getR7_end_of_period() == null ? 0
										: brf201.getR7_end_of_period().intValue());
							}

							Cell R7cell5 = R7row.getCell(7);
							if (R7cell5 != null) {
								R7cell5.setCellValue(
										brf201.getR7_abudhabi() == null ? 0 : brf201.getR7_abudhabi().intValue());
							}
							Cell R7cell = R7row.getCell(8);
							if (R7cell != null) {
								R7cell.setCellValue(brf201.getR7_dubai() == null ? 0 : brf201.getR7_dubai().intValue());
							}

							Cell R7cell7 = R7row.getCell(9);
							if (R7cell7 != null) {
								R7cell7.setCellValue(
										brf201.getR7_sharjah() == null ? 0 : brf201.getR7_sharjah().intValue());
							}
							Cell R7cell9 = R7row.getCell(10);
							if (R7cell9 != null) {
								R7cell9.setCellValue(
										brf201.getR7_ajman() == null ? 0 : brf201.getR7_ajman().intValue());
							}
							Cell R7cell8 = R7row.getCell(11);
							if (R7cell8 != null) {
								R7cell8.setCellValue(brf201.getR7_rak() == null ? 0 : brf201.getR7_rak().intValue());
							}

							Cell R7cell10 = R7row.getCell(12);
							if (R7cell10 != null) {
								R7cell10.setCellValue(
										brf201.getR7_fujairah() == null ? 0 : brf201.getR7_fujairah().intValue());
							}
							Cell R7cell61 = R7row.getCell(13);
							if (R7cell61 != null) {
								R7cell61.setCellValue(brf201.getR7_uaq() == null ? 0 : brf201.getR7_uaq().intValue());
							}

						}
					}
					if (T7Master.size() == 1) {
						for (BRF201_SUMMARY_ENTITY_G brf201 : T7Master) {

							Row row = sheet.getRow(73);

							Cell cell0 = row.getCell(2);
							if (cell0 != null) {
								cell0.setCellValue(brf201.getR1_total_network_numbers() == null ? 0
										: brf201.getR1_total_network_numbers().intValue());
							}

							Cell cell1 = row.getCell(3);
							if (cell1 != null) {
								cell1.setCellValue(brf201.getR1_domestic_foreign_branches() == null ? 0
										: brf201.getR1_domestic_foreign_branches().intValue());
							}

							Cell cell2 = row.getCell(4);
							if (cell2 != null) {
								cell2.setCellValue(
										brf201.getR1_rep_offices() == null ? 0 : brf201.getR1_rep_offices().intValue());
							}

							Cell cell3 = row.getCell(5);
							if (cell3 != null) {
								cell3.setCellValue(brf201.getR1_banking_subsidiaries() == null ? 0
										: brf201.getR1_banking_subsidiaries().intValue());
							}
							Cell cell4 = row.getCell(6);
							if (cell4 != null) {
								cell4.setCellValue(brf201.getR1_non_banking_financial_subsidiaries() == null ? 0
										: brf201.getR1_non_banking_financial_subsidiaries().intValue());
							}

							Cell cell5 = row.getCell(7);
							if (cell5 != null) {
								cell5.setCellValue(brf201.getR1_non_financial_subsidiaries() == null ? 0
										: brf201.getR1_non_financial_subsidiaries().intValue());
							}
							Cell cell = row.getCell(8);
							if (cell != null) {
								cell.setCellValue(
										brf201.getR1_pay_offices() == null ? 0 : brf201.getR1_pay_offices().intValue());
							}

							Cell cell7 = row.getCell(9);
							if (cell7 != null) {
								cell7.setCellValue(brf201.getR1_elec_business_units() == null ? 0
										: brf201.getR1_elec_business_units().intValue());
							}
							Cell cell9 = row.getCell(10);
							if (cell9 != null) {
								cell9.setCellValue(brf201.getR1_atms() == null ? 0 : brf201.getR1_atms().intValue());
							}
							Cell cell8 = row.getCell(11);
							if (cell8 != null) {
								cell8.setCellValue(brf201.getR1_admins_office_uae() == null ? 0
										: brf201.getR1_admins_office_uae().intValue());
							}

							Cell cell10 = row.getCell(12);
							if (cell10 != null) {
								cell10.setCellValue(brf201.getR1_admins_office_outside_uae() == null ? 0
										: brf201.getR1_admins_office_outside_uae().intValue());
							}
							Cell cell61 = row.getCell(13);
							if (cell61 != null) {
								cell61.setCellValue(brf201.getR1_no_of_mobile_banking_user() == null ? 0
										: brf201.getR1_no_of_mobile_banking_user().intValue());

								Cell cell611 = row.getCell(14);
								if (cell611 != null) {
									cell611.setCellValue(brf201.getR1_no_of_internet_banking_user() == null ? 0
											: brf201.getR1_no_of_internet_banking_user().intValue());
								}
							}
						}
						// Update Table 2
						/* updateTable1(sheet, T1Master); */

						updateTable2(sheet, T2Master);

						updateTable3(sheet, T3Master);

						updateTable4(sheet, T4Master);
						updateTable5(sheet, T5Master);
						updateTable6(sheet, T6Master); /* updateTable7(sheet, T7Master); */

						// Write to final output file
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-201-A.xls")) {
							workbook.write(fileOut);
						}
						workbook.close();

						path = env.getProperty("output.exportpathfinal") + "011-BRF-201-A.xls";
					}
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
					e.printStackTrace();
				}
			}

			return new File(path);
		}
		return outputFile;
	}

	private void updateTable2(Sheet sheet, List<BRF201_SUMMARY_ENTITY_B> T2Master) {
		int startRow = 18; // Starting row number
		for (int index = 0; index < T2Master.size(); index++) {
			BRF201_SUMMARY_ENTITY_B BRF201 = T2Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row
			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF201.getR1_rep_name() == null) ? "0" : BRF201.getR1_rep_name().toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 != null) {
					String value1 = (BRF201.getR1_rep_country_of_incorporation() == null) ? "0"
							: BRF201.getR1_rep_country_of_incorporation().toString();
					cell1.setCellValue(value1);

					Cell cell2 = row.getCell(4);
					if (cell2 != null) {
						String value3 = (BRF201.getR1_rep_date_opened() == null) ? "0"
								: BRF201.getR1_rep_date_opened().toString();
						cell2.setCellValue(value3);
					}

					Cell cell22 = row.getCell(5);
					if (cell22 != null) {
						String value4 = (BRF201.getR1_rep_date_closed() == null) ? "0"
								: BRF201.getR1_rep_date_closed().toString();
						cell22.setCellValue(value4);
					}

					Cell cell3 = row.getCell(6);
					if (cell3 != null) {
						String value5 = (BRF201.getR1_rep_regulator() == null) ? "0"
								: BRF201.getR1_rep_regulator().toString();
						cell3.setCellValue(value5);
					}

					Cell cell4 = row.getCell(7);
					if (cell4 != null) {
						String value6 = (BRF201.getR1_rep_ownership() == null) ? "0"
								: BRF201.getR1_rep_ownership().toString();
						cell4.setCellValue(value6);
					}

					Cell cell5 = row.getCell(8);
					if (cell5 != null) {
						String value7 = (BRF201.getR1_rep_nature_of_business() == null) ? "0"
								: BRF201.getR1_rep_nature_of_business().toString();
						cell5.setCellValue(value7);
					}

					Cell cell6 = row.getCell(9);
					if (cell6 != null) {
						String value8 = (BRF201.getR1_rep_share_capital() == null) ? "0"
								: BRF201.getR1_rep_share_capital().toString();
						cell6.setCellValue(value8);
					}

					Cell cell7 = row.getCell(10);
					if (cell7 != null) {
						String value9 = (BRF201.getR1_rep_share_premium() == null) ? "0"
								: BRF201.getR1_rep_share_premium().toString();
						cell7.setCellValue(value9);
					}

					Cell cell8 = row.getCell(11);
					if (cell8 != null) {
						String value10 = (BRF201.getR1_rep_reserves() == null) ? "0"
								: BRF201.getR1_rep_reserves().toString();
						cell8.setCellValue(value10);
					}
					Cell cell9 = row.getCell(12);
					if (cell9 != null) {
						String value11 = (BRF201.getR1_rep_accumulated_retained_earnings() == null) ? "0"
								: BRF201.getR1_rep_accumulated_retained_earnings().toString();
						cell9.setCellValue(value11);
					}
					Cell cell10 = row.getCell(13);
					if (cell10 != null) {
						String value11 = (BRF201.getR1_rep_assets() == null) ? "0"
								: BRF201.getR1_rep_assets().toString();
						cell10.setCellValue(value11);
					}
					Cell cell610 = row.getCell(14);
					if (cell610 != null) {
						String value11 = (BRF201.getR1_rep_ceo_name() == null) ? "0"
								: BRF201.getR1_rep_ceo_name().toString();
						cell610.setCellValue(value11);
					}
					Cell cell410 = row.getCell(15);
					if (cell410 != null) {
						String value11 = (BRF201.getR1_rep_no_of_staff() == null) ? "0"
								: BRF201.getR1_rep_no_of_staff().toString();
						cell410.setCellValue(value11);
					}
					Cell cell310 = row.getCell(16);
					if (cell310 != null) {
						String value11 = (BRF201.getR1_rep_no_of_uae_nationals() == null) ? "0"
								: BRF201.getR1_rep_no_of_uae_nationals().toString();
						cell310.setCellValue(value11);
					}
					Cell cell120 = row.getCell(17);
					if (cell120 != null) {
						String value11 = (BRF201.getR1_rep_no_of_branches() == null) ? "0"
								: BRF201.getR1_rep_no_of_branches().toString();
						cell120.setCellValue(value11);
					}
					Cell cell100 = row.getCell(18);
					if (cell100 != null) {
						String value11 = (BRF201.getR1_rep_no_of_atm() == null) ? "0"
								: BRF201.getR1_rep_no_of_atm().toString();
						cell100.setCellValue(value11);
					}
					Cell cell110 = row.getCell(19);
					if (cell110 != null) {
						String value11 = (BRF201.getR1_rep_cb_approval_ref_num() == null) ? "0"
								: BRF201.getR1_rep_cb_approval_ref_num().toString();
						cell110.setCellValue(value11);
					}
				}
			}
		}
	}

	private void updateTable3(Sheet sheet, List<BRF201_SUMMARY_ENTITY_C> T3Master) {
		int startRow = 29; // Starting row number
		for (int index = 0; index < T3Master.size(); index++) {
			BRF201_SUMMARY_ENTITY_C BRF201 = T3Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF201.getR1_for_name() == null) ? "0" : BRF201.getR1_for_name().toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 != null) {
					String value1 = (BRF201.getR1_for_country_of_incorporation() == null) ? "0"
							: BRF201.getR1_for_country_of_incorporation().toString();
					cell1.setCellValue(value1);

					Cell cell2 = row.getCell(4);
					if (cell2 != null) {
						String value3 = (BRF201.getR1_for_date_opened() == null) ? "0"
								: BRF201.getR1_for_date_opened().toString();
						cell2.setCellValue(value3);
					}

					Cell cell22 = row.getCell(5);
					if (cell22 != null) {
						String value4 = (BRF201.getR1_for_date_closed() == null) ? "0"
								: BRF201.getR1_for_date_closed().toString();
						cell22.setCellValue(value4);
					}

					Cell cell3 = row.getCell(6);
					if (cell3 != null) {
						String value5 = (BRF201.getR1_for_regulator() == null) ? "0"
								: BRF201.getR1_for_regulator().toString();
						cell3.setCellValue(value5);
					}

					Cell cell4 = row.getCell(7);
					if (cell4 != null) {
						String value6 = (BRF201.getR1_for_ownership() == null) ? "0"
								: BRF201.getR1_for_ownership().toString();
						cell4.setCellValue(value6);
					}

					Cell cell5 = row.getCell(8);
					if (cell5 != null) {
						String value7 = (BRF201.getR1_for_nature_of_business() == null) ? "0"
								: BRF201.getR1_for_nature_of_business().toString();
						cell5.setCellValue(value7);
					}

					Cell cell6 = row.getCell(9);
					if (cell6 != null) {
						String value8 = (BRF201.getR1_for_share_capital() == null) ? "0"
								: BRF201.getR1_for_share_capital().toString();
						cell6.setCellValue(value8);
					}

					Cell cell7 = row.getCell(10);
					if (cell7 != null) {
						String value9 = (BRF201.getR1_for_share_premium() == null) ? "0"
								: BRF201.getR1_for_share_premium().toString();
						cell7.setCellValue(value9);
					}

					Cell cell8 = row.getCell(11);
					if (cell8 != null) {
						String value10 = (BRF201.getR1_for_reserves() == null) ? "0"
								: BRF201.getR1_for_reserves().toString();
						cell8.setCellValue(value10);
					}
					Cell cell9 = row.getCell(12);
					if (cell9 != null) {
						String value11 = (BRF201.getR1_for_accumulated_retained_earnings() == null) ? "0"
								: BRF201.getR1_for_accumulated_retained_earnings().toString();
						cell9.setCellValue(value11);
					}
					Cell cell10 = row.getCell(13);
					if (cell10 != null) {
						String value11 = (BRF201.getR1_for_assets() == null) ? "0"
								: BRF201.getR1_for_assets().toString();
						cell10.setCellValue(value11);
					}
					Cell cell610 = row.getCell(14);
					if (cell610 != null) {
						String value11 = (BRF201.getR1_for_ceo_name() == null) ? "0"
								: BRF201.getR1_for_ceo_name().toString();
						cell610.setCellValue(value11);
					}
					Cell cell410 = row.getCell(15);
					if (cell410 != null) {
						String value11 = (BRF201.getR1_for_no_of_staff() == null) ? "0"
								: BRF201.getR1_for_no_of_staff().toString();
						cell410.setCellValue(value11);
					}
					Cell cell310 = row.getCell(16);
					if (cell310 != null) {
						String value11 = (BRF201.getR1_for_no_of_uae_nationals() == null) ? "0"
								: BRF201.getR1_for_no_of_uae_nationals().toString();
						cell310.setCellValue(value11);
					}
					Cell cell120 = row.getCell(17);
					if (cell120 != null) {
						String value11 = (BRF201.getR1_for_no_of_branches() == null) ? "0"
								: BRF201.getR1_for_no_of_branches().toString();
						cell120.setCellValue(value11);
					}
					Cell cell100 = row.getCell(18);
					if (cell100 != null) {
						String value11 = (BRF201.getR1_for_no_of_atm() == null) ? "0"
								: BRF201.getR1_for_no_of_atm().toString();
						cell100.setCellValue(value11);
					}
					Cell cell110 = row.getCell(19);
					if (cell110 != null) {
						String value11 = (BRF201.getR1_for_cb_approval_ref_num() == null) ? "0"
								: BRF201.getR1_for_cb_approval_ref_num().toString();
						cell110.setCellValue(value11);
					}
				}
			}
		}
	}

	private void updateTable4(Sheet sheet, List<BRF201_SUMMARY_ENTITY_D> T4Master) {
		int startRow = 40; // Starting row number
		for (int index = 0; index < T4Master.size(); index++) {
			BRF201_SUMMARY_ENTITY_D BRF201 = T4Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF201.getR1_ban_name() == null) ? "0" : BRF201.getR1_ban_name().toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 != null) {
					String value1 = (BRF201.getR1_ban_country_of_incorporation() == null) ? "0"
							: BRF201.getR1_ban_country_of_incorporation().toString();
					cell1.setCellValue(value1);

					Cell cell2 = row.getCell(4);
					if (cell2 != null) {
						String value3 = (BRF201.getR1_ban_date_opened() == null) ? "0"
								: BRF201.getR1_ban_date_opened().toString();
						cell2.setCellValue(value3);
					}

					Cell cell22 = row.getCell(5);
					if (cell22 != null) {
						String value4 = (BRF201.getR1_ban_date_closed() == null) ? "0"
								: BRF201.getR1_ban_date_closed().toString();
						cell22.setCellValue(value4);
					}

					Cell cell3 = row.getCell(6);
					if (cell3 != null) {
						String value5 = (BRF201.getR1_ban_regulator() == null) ? "0"
								: BRF201.getR1_ban_regulator().toString();
						cell3.setCellValue(value5);
					}

					Cell cell4 = row.getCell(7);
					if (cell4 != null) {
						String value6 = (BRF201.getR1_ban_ownership() == null) ? "0"
								: BRF201.getR1_ban_ownership().toString();
						cell4.setCellValue(value6);
					}

					Cell cell5 = row.getCell(8);
					if (cell5 != null) {
						String value7 = (BRF201.getR1_ban_nature_of_business() == null) ? "0"
								: BRF201.getR1_ban_nature_of_business().toString();
						cell5.setCellValue(value7);
					}

					Cell cell6 = row.getCell(9);
					if (cell6 != null) {
						String value8 = (BRF201.getR1_ban_share_capital() == null) ? "0"
								: BRF201.getR1_ban_share_capital().toString();
						cell6.setCellValue(value8);
					}

					Cell cell7 = row.getCell(10);
					if (cell7 != null) {
						String value9 = (BRF201.getR1_ban_share_premium() == null) ? "0"
								: BRF201.getR1_ban_share_premium().toString();
						cell7.setCellValue(value9);
					}

					Cell cell8 = row.getCell(11);
					if (cell8 != null) {
						String value10 = (BRF201.getR1_ban_reserves() == null) ? "0"
								: BRF201.getR1_ban_reserves().toString();
						cell8.setCellValue(value10);
					}
					Cell cell9 = row.getCell(12);
					if (cell9 != null) {
						String value11 = (BRF201.getR1_ban_accumulated_retained_earnings() == null) ? "0"
								: BRF201.getR1_ban_accumulated_retained_earnings().toString();
						cell9.setCellValue(value11);
					}
					Cell cell10 = row.getCell(13);
					if (cell10 != null) {
						String value11 = (BRF201.getR1_ban_assets() == null) ? "0"
								: BRF201.getR1_ban_assets().toString();
						cell10.setCellValue(value11);
					}
					Cell cell610 = row.getCell(14);
					if (cell610 != null) {
						String value11 = (BRF201.getR1_ban_ceo_name() == null) ? "0"
								: BRF201.getR1_ban_ceo_name().toString();
						cell610.setCellValue(value11);
					}
					Cell cell410 = row.getCell(15);
					if (cell410 != null) {
						String value11 = (BRF201.getR1_ban_no_of_staff() == null) ? "0"
								: BRF201.getR1_ban_no_of_staff().toString();
						cell410.setCellValue(value11);
					}
					Cell cell310 = row.getCell(16);
					if (cell310 != null) {
						String value11 = (BRF201.getR1_ban_no_of_uae_nationals() == null) ? "0"
								: BRF201.getR1_ban_no_of_uae_nationals().toString();
						cell310.setCellValue(value11);
					}
					Cell cell120 = row.getCell(17);
					if (cell120 != null) {
						String value11 = (BRF201.getR1_ban_no_of_branches() == null) ? "0"
								: BRF201.getR1_ban_no_of_branches().toString();
						cell120.setCellValue(value11);
					}
					Cell cell100 = row.getCell(18);
					if (cell100 != null) {
						String value11 = (BRF201.getR1_ban_no_of_atm() == null) ? "0"
								: BRF201.getR1_ban_no_of_atm().toString();
						cell100.setCellValue(value11);
					}
					Cell cell110 = row.getCell(19);
					if (cell110 != null) {
						String value11 = (BRF201.getR1_ban_cb_approval_ref_num() == null) ? "0"
								: BRF201.getR1_ban_cb_approval_ref_num().toString();
						cell110.setCellValue(value11);
					}
				}
			}
		}
	}

	private void updateTable5(Sheet sheet, List<BRF201_SUMMARY_ENTITY_E> T5Master) {
		int startRow = 51; // Starting row number
		for (int index = 0; index < T5Master.size(); index++) {
			BRF201_SUMMARY_ENTITY_E BRF201 = T5Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF201.getR1_fin_name() == null) ? "0" : BRF201.getR1_fin_name().toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 != null) {
					String value1 = (BRF201.getR1_fin_country_of_incorporation() == null) ? "0"
							: BRF201.getR1_fin_country_of_incorporation().toString();
					cell1.setCellValue(value1);

					Cell cell2 = row.getCell(4);
					if (cell2 != null) {
						String value3 = (BRF201.getR1_fin_date_opened() == null) ? "0"
								: BRF201.getR1_fin_date_opened().toString();
						cell2.setCellValue(value3);
					}

					Cell cell22 = row.getCell(5);
					if (cell22 != null) {
						String value4 = (BRF201.getR1_fin_date_closed() == null) ? "0"
								: BRF201.getR1_fin_date_closed().toString();
						cell22.setCellValue(value4);
					}

					Cell cell3 = row.getCell(6);
					if (cell3 != null) {
						String value5 = (BRF201.getR1_fin_regulator() == null) ? "0"
								: BRF201.getR1_fin_regulator().toString();
						cell3.setCellValue(value5);
					}

					Cell cell4 = row.getCell(7);
					if (cell4 != null) {
						String value6 = (BRF201.getR1_fin_ownership() == null) ? "0"
								: BRF201.getR1_fin_ownership().toString();
						cell4.setCellValue(value6);
					}

					Cell cell5 = row.getCell(8);
					if (cell5 != null) {
						String value7 = (BRF201.getR1_fin_nature_of_business() == null) ? "0"
								: BRF201.getR1_fin_nature_of_business().toString();
						cell5.setCellValue(value7);
					}

					Cell cell6 = row.getCell(9);
					if (cell6 != null) {
						String value8 = (BRF201.getR1_fin_share_capital() == null) ? "0"
								: BRF201.getR1_fin_share_capital().toString();
						cell6.setCellValue(value8);
					}

					Cell cell7 = row.getCell(10);
					if (cell7 != null) {
						String value9 = (BRF201.getR1_fin_share_premium() == null) ? "0"
								: BRF201.getR1_fin_share_premium().toString();
						cell7.setCellValue(value9);
					}

					Cell cell8 = row.getCell(11);
					if (cell8 != null) {
						String value10 = (BRF201.getR1_fin_reserves() == null) ? "0"
								: BRF201.getR1_fin_reserves().toString();
						cell8.setCellValue(value10);
					}
					Cell cell9 = row.getCell(12);
					if (cell9 != null) {
						String value11 = (BRF201.getR1_fin_accumulated_retained_earnings() == null) ? "0"
								: BRF201.getR1_fin_accumulated_retained_earnings().toString();
						cell9.setCellValue(value11);
					}
					Cell cell10 = row.getCell(13);
					if (cell10 != null) {
						String value11 = (BRF201.getR1_fin_assets() == null) ? "0"
								: BRF201.getR1_fin_assets().toString();
						cell10.setCellValue(value11);
					}
					Cell cell610 = row.getCell(14);
					if (cell610 != null) {
						String value11 = (BRF201.getR1_fin_ceo_name() == null) ? "0"
								: BRF201.getR1_fin_ceo_name().toString();
						cell610.setCellValue(value11);
					}
					Cell cell410 = row.getCell(15);
					if (cell410 != null) {
						String value11 = (BRF201.getR1_fin_no_of_staff() == null) ? "0"
								: BRF201.getR1_fin_no_of_staff().toString();
						cell410.setCellValue(value11);
					}
					Cell cell310 = row.getCell(16);
					if (cell310 != null) {
						String value11 = (BRF201.getR1_fin_no_of_uae_nationals() == null) ? "0"
								: BRF201.getR1_fin_no_of_uae_nationals().toString();
						cell310.setCellValue(value11);
					}
					Cell cell120 = row.getCell(17);
					if (cell120 != null) {
						String value11 = (BRF201.getR1_fin_no_of_branches() == null) ? "0"
								: BRF201.getR1_fin_no_of_branches().toString();
						cell120.setCellValue(value11);
					}
					Cell cell100 = row.getCell(18);
					if (cell100 != null) {
						String value11 = (BRF201.getR1_fin_no_of_atm() == null) ? "0"
								: BRF201.getR1_fin_no_of_atm().toString();
						cell100.setCellValue(value11);
					}
					Cell cell110 = row.getCell(19);
					if (cell110 != null) {
						String value11 = (BRF201.getR1_fin_cb_approval_ref_num() == null) ? "0"
								: BRF201.getR1_fin_cb_approval_ref_num().toString();
						cell110.setCellValue(value11);
					}
				}
			}
		}
	}

	private void updateTable6(Sheet sheet, List<BRF201_SUMMARY_ENTITY_F> T6Master) {
		int startRow = 62; // Starting row number
		for (int index = 0; index < T6Master.size(); index++) {
			BRF201_SUMMARY_ENTITY_F BRF201 = T6Master.get(index);
			Row row = sheet.getRow(startRow + index); // Dynamically get the correct row

			Cell cell = row.getCell(2);
			if (cell != null) {
				String value = (BRF201.getR1_non_name() == null) ? "0" : BRF201.getR1_non_name().toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 != null) {
					String value1 = (BRF201.getR1_non_country_of_incorporation() == null) ? "0"
							: BRF201.getR1_non_country_of_incorporation().toString();
					cell1.setCellValue(value1);

					Cell cell2 = row.getCell(4);
					if (cell2 != null) {
						String value3 = (BRF201.getR1_non_date_opened() == null) ? "0"
								: BRF201.getR1_non_date_opened().toString();
						cell2.setCellValue(value3);
					}

					Cell cell22 = row.getCell(5);
					if (cell22 != null) {
						String value4 = (BRF201.getR1_non_date_closed() == null) ? "0"
								: BRF201.getR1_non_date_closed().toString();
						cell22.setCellValue(value4);
					}

					Cell cell3 = row.getCell(6);
					if (cell3 != null) {
						String value5 = (BRF201.getR1_non_regulator() == null) ? "0"
								: BRF201.getR1_non_regulator().toString();
						cell3.setCellValue(value5);
					}

					Cell cell4 = row.getCell(7);
					if (cell4 != null) {
						String value6 = (BRF201.getR1_non_ownership() == null) ? "0"
								: BRF201.getR1_non_ownership().toString();
						cell4.setCellValue(value6);
					}

					Cell cell5 = row.getCell(8);
					if (cell5 != null) {
						String value7 = (BRF201.getR1_non_nature_of_business() == null) ? "0"
								: BRF201.getR1_non_nature_of_business().toString();
						cell5.setCellValue(value7);
					}

					Cell cell6 = row.getCell(9);
					if (cell6 != null) {
						String value8 = (BRF201.getR1_non_share_capital() == null) ? "0"
								: BRF201.getR1_non_share_capital().toString();
						cell6.setCellValue(value8);
					}

					Cell cell7 = row.getCell(10);
					if (cell7 != null) {
						String value9 = (BRF201.getR1_non_share_premium() == null) ? "0"
								: BRF201.getR1_non_share_premium().toString();
						cell7.setCellValue(value9);
					}

					Cell cell8 = row.getCell(11);
					if (cell8 != null) {
						String value10 = (BRF201.getR1_non_reserves() == null) ? "0"
								: BRF201.getR1_non_reserves().toString();
						cell8.setCellValue(value10);
					}
					Cell cell9 = row.getCell(12);
					if (cell9 != null) {
						String value11 = (BRF201.getR1_non_accumulated_retained_earnings() == null) ? "0"
								: BRF201.getR1_non_accumulated_retained_earnings().toString();
						cell9.setCellValue(value11);
					}
					Cell cell10 = row.getCell(13);
					if (cell10 != null) {
						String value11 = (BRF201.getR1_non_assets() == null) ? "0"
								: BRF201.getR1_non_assets().toString();
						cell10.setCellValue(value11);
					}
					Cell cell610 = row.getCell(14);
					if (cell610 != null) {
						String value11 = (BRF201.getR1_non_ceo_name() == null) ? "0"
								: BRF201.getR1_non_ceo_name().toString();
						cell610.setCellValue(value11);
					}
					Cell cell410 = row.getCell(15);
					if (cell410 != null) {
						String value11 = (BRF201.getR1_non_no_of_staff() == null) ? "0"
								: BRF201.getR1_non_no_of_staff().toString();
						cell410.setCellValue(value11);
					}
					Cell cell310 = row.getCell(16);
					if (cell310 != null) {
						String value11 = (BRF201.getR1_non_no_of_uae_nationals() == null) ? "0"
								: BRF201.getR1_non_no_of_uae_nationals().toString();
						cell310.setCellValue(value11);
					}
					Cell cell120 = row.getCell(17);
					if (cell120 != null) {
						String value11 = (BRF201.getR1_non_no_of_branches() == null) ? "0"
								: BRF201.getR1_non_no_of_branches().toString();
						cell120.setCellValue(value11);
					}
					Cell cell100 = row.getCell(18);
					if (cell100 != null) {
						String value11 = (BRF201.getR1_non_no_of_atm() == null) ? "0"
								: BRF201.getR1_non_no_of_atm().toString();
						cell100.setCellValue(value11);
					}
					Cell cell110 = row.getCell(19);
					if (cell110 != null) {
						String value11 = (BRF201.getR1_non_cb_approval_ref_num() == null) ? "0"
								: BRF201.getR1_non_cb_approval_ref_num().toString();
						cell110.setCellValue(value11);
					}
				}
			}
		}
	}

	/*
	 * private void updateTable7(Sheet sheet, List<BRF201_SUMMARY_ENTITY_G>
	 * T7Master) { int startRow = 73; for (int index = 0; index < T7Master.size();
	 * index++) { BRF201_SUMMARY_ENTITY_G BRF201 = T7Master.get(index);
	 * 
	 * Row row = sheet.getRow(29);
	 * 
	 * Cell cell = row.getCell(2); if (cell != null) { String value =
	 * (BRF201.getR1_total_network_numbers() == null) ? "0" :
	 * BRF201.getR1_total_network_numbers().toString(); cell.setCellValue(value);
	 * 
	 * Cell cell1 = row.getCell(3); if (cell1 != null) { String value1 =
	 * (BRF201.getR1_domestic_foreign_branches() == null) ? "0" :
	 * BRF201.getR1_domestic_foreign_branches().toString();
	 * cell1.setCellValue(value1);
	 * 
	 * Cell cell2 = row.getCell(4); if (cell2 != null) { String value3 =
	 * (BRF201.getR1_rep_offices() == null) ? "0" :
	 * BRF201.getR1_rep_offices().toString(); cell2.setCellValue(value3); }
	 * 
	 * Cell cell22 = row.getCell(5); if (cell22 != null) { String value4 =
	 * (BRF201.getR1_banking_subsidiaries() == null) ? "0" :
	 * BRF201.getR1_banking_subsidiaries().toString(); cell22.setCellValue(value4);
	 * }
	 * 
	 * Cell cell3 = row.getCell(6); if (cell3 != null) { String value5 =
	 * (BRF201.getR1_non_banking_financial_subsidiaries() == null) ? "0" :
	 * BRF201.getR1_non_banking_financial_subsidiaries().toString();
	 * cell3.setCellValue(value5); }
	 * 
	 * Cell cell4 = row.getCell(7); if (cell4 != null) { String value6 =
	 * (BRF201.getR1_pay_offices() == null) ? "0" :
	 * BRF201.getR1_non_ownership().toString(); cell4.setCellValue(value6); }
	 * 
	 * Cell cell5 = row.getCell(8); if (cell5 != null) { String value7 =
	 * (BRF201.getR1_non_nature_of_business() == null) ? "0" :
	 * BRF201.getR1_non_nature_of_business().toString(); cell5.setCellValue(value7);
	 * }
	 * 
	 * Cell cell6 = row.getCell(9); if (cell6 != null) { String value8 =
	 * (BRF201.getR1_non_share_capital() == null) ? "0" :
	 * BRF201.getR1_non_share_capital().toString(); cell6.setCellValue(value8); }
	 * 
	 * Cell cell7 = row.getCell(10); if (cell7 != null) { String value9 =
	 * (BRF201.getR1_non_share_premium() == null) ? "0" :
	 * BRF201.getR1_non_share_premium().toString(); cell7.setCellValue(value9); }
	 * 
	 * Cell cell8 = row.getCell(11); if (cell8 != null) { String value10 =
	 * (BRF201.getR1_non_reserves() == null) ? "0" :
	 * BRF201.getR1_non_reserves().toString(); cell8.setCellValue(value10); } Cell
	 * cell9 = row.getCell(12); if (cell9 != null) { String value11 =
	 * (BRF201.getR1_non_accumulated_retained_earnings() == null) ? "0" :
	 * BRF201.getR1_non_accumulated_retained_earnings().toString();
	 * cell9.setCellValue(value11); } Cell cell10 = row.getCell(13); if (cell10 !=
	 * null) { String value11 = (BRF201.getR1_non_assets() == null) ? "0" :
	 * BRF201.getR1_non_assets().toString(); cell10.setCellValue(value11); } Cell
	 * cell610 = row.getCell(14); if (cell610 != null) { String value11 =
	 * (BRF201.getR1_non_ceo_name() == null) ? "0" :
	 * BRF201.getR1_non_ceo_name().toString(); cell610.setCellValue(value11); } Cell
	 * cell410 = row.getCell(15); if (cell410 != null) { String value11 =
	 * (BRF201.getR1_non_no_of_staff() == null) ? "0" :
	 * BRF201.getR1_non_no_of_staff().toString(); cell410.setCellValue(value11); }
	 * Cell cell310 = row.getCell(16); if (cell310 != null) { String value11 =
	 * (BRF201.getR1_non_no_of_uae_nationals() == null) ? "0" :
	 * BRF201.getR1_non_no_of_uae_nationals().toString();
	 * cell310.setCellValue(value11); } Cell cell120 = row.getCell(17); if (cell120
	 * != null) { String value11 = (BRF201.getR1_non_no_of_branches() == null) ? "0"
	 * : BRF201.getR1_non_no_of_branches().toString();
	 * cell120.setCellValue(value11); } Cell cell100 = row.getCell(18); if (cell100
	 * != null) { String value11 = (BRF201.getR1_non_no_of_atm() == null) ? "0" :
	 * BRF201.getR1_non_no_of_atm().toString(); cell100.setCellValue(value11); }
	 * Cell cell110 = row.getCell(19); if (cell110 != null) { String value11 =
	 * (BRF201.getR1_non_cb_approval_ref_num() == null) ? "0" :
	 * BRF201.getR1_non_cb_approval_ref_num().toString();
	 * cell110.setCellValue(value11); } } } } }
	 */

	public String detailChanges201(BRF201_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF201_DETAIL_ENTITY> Brf201detail = brf201_Detailrepo.findById(foracid);

			if (Brf201detail.isPresent()) {
				BRF201_DETAIL_ENTITY BRFdetail = Brf201detail.get();

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
					brf201_Detailrepo.save(BRFdetail);

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

	/****
	 * ARCH SUMMARY
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView getArchieveBRF201AView(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF201_SUMMARY_ENTITY_A> T1Master = new ArrayList<BRF201_SUMMARY_ENTITY_A>();
		List<BRF201_SUMMARY_ENTITY_B> T2Master = new ArrayList<BRF201_SUMMARY_ENTITY_B>();
		List<BRF201_SUMMARY_ENTITY_C> T3Master = new ArrayList<BRF201_SUMMARY_ENTITY_C>();
		List<BRF201_SUMMARY_ENTITY_D> T4Master = new ArrayList<BRF201_SUMMARY_ENTITY_D>();
		List<BRF201_SUMMARY_ENTITY_E> T5Master = new ArrayList<BRF201_SUMMARY_ENTITY_E>();
		List<BRF201_SUMMARY_ENTITY_F> T6Master = new ArrayList<BRF201_SUMMARY_ENTITY_F>();
		List<BRF201_SUMMARY_ENTITY_G> T7Master = new ArrayList<BRF201_SUMMARY_ENTITY_G>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_A a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_A.class).setParameter(1, df.parse(todate)).getResultList();
			T2Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_B a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_B.class).setParameter(1, df.parse(todate)).getResultList();
			T3Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_C a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_C.class).setParameter(1, df.parse(todate)).getResultList();
			T4Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_D a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_D.class).setParameter(1, df.parse(todate)).getResultList();
			T5Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_E a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_E.class).setParameter(1, df.parse(todate)).getResultList();
			T6Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_F a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_F.class).setParameter(1, df.parse(todate)).getResultList();
			T7Master = hs.createQuery("from BRF201_SUMMARY_ENTITY_G a where a.report_date = ?1 order by srl_no",
					BRF201_SUMMARY_ENTITY_G.class).setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF201A_A2_RPT a where a.report_date = ?1 ",
			 * BRF201A_A2_RPT.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF201ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("modify_flg", T1Master.size() > 0 ? T1Master.get(0).getModify_flg() : null);
		mv.addObject("modify_user", T1Master.size() > 0 ? T1Master.get(0).getModify_user() : null);
		mv.addObject("reportsummary2", T2Master);
		mv.addObject("reportsummary3", T3Master);
		mv.addObject("reportsummary4", T4Master);
		mv.addObject("reportsummary5", T5Master);
		mv.addObject("reportsummary6", T6Master);
		mv.addObject("reportsummary7", T7Master);
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

	public ModelAndView ARCHgetBRF201AcurrentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF201_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF201_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF201_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF201_ARCHIV_ENTITY> T1Master = new ArrayList<BRF201_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs
					.createQuery("from BRF201_ARCHIV_ENTITY a where a.report_date = ?1", BRF201_ARCHIV_ENTITY.class)
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
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];

			BRF201_ARCHIV_ENTITY py = new BRF201_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks);

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

		mv.setViewName("RR" + "/" + "BRF201ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String modifyBRF201Report(YourFormDatas formData, Date asondate, String userId, HttpServletRequest req) {
		String msg = "";

		/*
		 * List<BRF201_SUMMARY_ENTITY_A> existingReports =
		 * brf201_SUMMARY_REP_A.getBRF201reportService(asondate);
		 * List<BRF201_SUMMARY_ENTITY_A> userData =
		 * formData.getBrf201_SUMMARY_ENTITY_A();
		 */
		List<BRF201_SUMMARY_ENTITY_B> existingReports1 = brf201_SUMMARY_REP_B.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_B> userData1 = formData.getBrf201_SUMMARY_ENTITY_B();

		List<BRF201_SUMMARY_ENTITY_C> existingReports2 = brf201_SUMMARY_REP_C.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_C> userData2 = formData.getBrf201_SUMMARY_ENTITY_C();

		List<BRF201_SUMMARY_ENTITY_D> existingReports3 = brf201_SUMMARY_REP_D.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_D> userData3 = formData.getBrf201_SUMMARY_ENTITY_D();

		List<BRF201_SUMMARY_ENTITY_E> existingReports4 = brf201_SUMMARY_REP_E.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_E> userData4 = formData.getBrf201_SUMMARY_ENTITY_E();

		List<BRF201_SUMMARY_ENTITY_F> existingReports5 = brf201_SUMMARY_REP_F.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_F> userData5 = formData.getBrf201_SUMMARY_ENTITY_F();

		List<BRF201_SUMMARY_ENTITY_G> existingReports6 = brf201_SUMMARY_REP_G.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_G> userData6 = formData.getBrf201_SUMMARY_ENTITY_G();

		List<String> oldValuesList = new ArrayList<>();
		List<String> newValuesList = new ArrayList<>();
		List<String> fieldNames = new ArrayList<>();

		List<String> finaloldvalB = new ArrayList<>();
		List<String> finaloldvalC = new ArrayList<>();
		List<String> finaloldvalD = new ArrayList<>();
		List<String> finaloldvalE = new ArrayList<>();
		List<String> finaloldvalF = new ArrayList<>();
		List<String> finaloldvalG = new ArrayList<>();

		for (BRF201_SUMMARY_ENTITY_B userdatas : userData1) {
			boolean found = false;
			for (BRF201_SUMMARY_ENTITY_B exiting : userData1) {
				if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldvalB.add(userdatas.toString());
			}
		}
		for (BRF201_SUMMARY_ENTITY_C userdatas : userData2) {
			boolean found = false;
			for (BRF201_SUMMARY_ENTITY_C exiting : userData2) {
				if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldvalC.add(userdatas.toString());
			}
		}
		for (BRF201_SUMMARY_ENTITY_D userdatas : userData3) {
			boolean found = false;
			for (BRF201_SUMMARY_ENTITY_D exiting : userData3) {
				if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldvalD.add(userdatas.toString());
			}
		}
		for (BRF201_SUMMARY_ENTITY_E userdatas : userData4) {
			boolean found = false;
			for (BRF201_SUMMARY_ENTITY_E exiting : userData4) {
				if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldvalE.add(userdatas.toString());
			}
		}
		for (BRF201_SUMMARY_ENTITY_F userdatas : userData5) {
			boolean found = false;
			for (BRF201_SUMMARY_ENTITY_F exiting : userData5) {
				if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldvalF.add(userdatas.toString());
			}
		}
		for (BRF201_SUMMARY_ENTITY_G userdatas : userData6) {
			boolean found = false;
			for (BRF201_SUMMARY_ENTITY_G exiting : userData6) {
				if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
					found = true;
					break;
				}
			}
			if (!found) {
				finaloldvalG.add(userdatas.toString());
			}
		}
		StringBuilder oldChange = new StringBuilder();
		StringBuilder newChange = new StringBuilder();

		boolean rowEditedB = false;
		for (BRF201_SUMMARY_ENTITY_B datavalues : userData1) {
			for (BRF201_SUMMARY_ENTITY_B existingReport : existingReports1) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getSrl_no() + " : ";
					if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getSrl_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getSrl_no()).append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_name().compareTo(existingReport.getR1_rep_name()) != 0) {
						fieldNames.add("Representative Offices - Name");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_rep_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_rep_name())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_country_of_incorporation()
							.compareTo(existingReport.getR1_rep_country_of_incorporation()) != 0) {
						fieldNames.add("Representative Offices - Country of Incorporation");
						oldChange.append(rowPrefix).append("Column 3: ")
								.append(existingReport.getR1_rep_country_of_incorporation()).append("; ");
						newChange.append(rowPrefix).append("Column 3: ")
								.append(datavalues.getR1_rep_country_of_incorporation()).append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_date_opened().compareTo(existingReport.getR1_rep_date_opened()) != 0) {
						fieldNames.add("Representative Offices - Date Opened(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_rep_date_opened())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_rep_date_opened())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_date_closed().compareTo(existingReport.getR1_rep_date_closed()) != 0) {
						fieldNames.add("Representative Offices - Date Closed(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_rep_date_closed())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_rep_date_closed())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_regulator().compareTo(existingReport.getR1_rep_regulator()) != 0) {
						fieldNames.add("Representative Offices - Regulator");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_rep_regulator())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_rep_regulator())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_ownership().compareTo(existingReport.getR1_rep_ownership()) != 0) {
						fieldNames.add("Representative Offices - Ownership %");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_rep_ownership())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_rep_ownership())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_nature_of_business()
							.compareTo(existingReport.getR1_rep_nature_of_business()) != 0) {
						fieldNames.add("Representative Offices - Nature of Business");
						oldChange.append(rowPrefix).append("Column 8: ")
								.append(existingReport.getR1_rep_nature_of_business()).append("; ");
						newChange.append(rowPrefix).append("Column 8: ")
								.append(datavalues.getR1_rep_nature_of_business()).append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_share_capital().compareTo(existingReport.getR1_rep_share_capital()) != 0) {
						fieldNames.add("Representative Offices - Share Capital");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(existingReport.getR1_rep_share_capital()).append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_rep_share_capital())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_share_premium().compareTo(existingReport.getR1_rep_share_premium()) != 0) {
						fieldNames.add("Representative Offices - Share Premium");
						oldChange.append(rowPrefix).append("Column 10: ")
								.append(existingReport.getR1_rep_share_premium()).append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_rep_share_premium())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_reserves().compareTo(existingReport.getR1_rep_reserves()) != 0) {
						fieldNames.add("Representative Offices - Reserves");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_rep_reserves())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_rep_reserves())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_accumulated_retained_earnings()
							.compareTo(existingReport.getR1_rep_accumulated_retained_earnings()) != 0) {
						fieldNames.add("Representative Offices - Accumulated Retained Earnings");
						oldChange.append(rowPrefix).append("Column 12: ")
								.append(existingReport.getR1_rep_accumulated_retained_earnings()).append("; ");
						newChange.append(rowPrefix).append("Column 12: ")
								.append(datavalues.getR1_rep_accumulated_retained_earnings()).append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_assets().compareTo(existingReport.getR1_rep_assets()) != 0) {
						fieldNames.add("Representative Offices - Assets ");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_rep_assets())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_rep_assets())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_ceo_name().compareTo(existingReport.getR1_rep_ceo_name()) != 0) {
						fieldNames.add("Representative Offices - CEO's Name");
						oldChange.append(rowPrefix).append("Column 14: ").append(existingReport.getR1_rep_ceo_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 14: ").append(datavalues.getR1_rep_ceo_name())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_no_of_staff().compareTo(existingReport.getR1_rep_no_of_staff()) != 0) {
						fieldNames.add("Representative Offices - Number of Staff");
						oldChange.append(rowPrefix).append("Column 15: ").append(existingReport.getR1_rep_no_of_staff())
								.append("; ");
						newChange.append(rowPrefix).append("Column 15: ").append(datavalues.getR1_rep_no_of_staff())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_no_of_uae_nationals()
							.compareTo(existingReport.getR1_rep_no_of_uae_nationals()) != 0) {
						fieldNames.add("Representative Offices - Number of UAE Nationals");
						oldChange.append(rowPrefix).append("Column 16: ")
								.append(existingReport.getR1_rep_no_of_uae_nationals()).append("; ");
						newChange.append(rowPrefix).append("Column 16: ")
								.append(datavalues.getR1_rep_no_of_uae_nationals()).append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_no_of_branches()
							.compareTo(existingReport.getR1_rep_no_of_branches()) != 0) {
						fieldNames.add("Representative Offices - Number of Branches");
						oldChange.append(rowPrefix).append("Column 17: ")
								.append(existingReport.getR1_rep_no_of_branches()).append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_rep_no_of_branches())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_no_of_atm().compareTo(existingReport.getR1_rep_no_of_atm()) != 0) {
						fieldNames.add("Representative Offices - Number of ATMs");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_rep_no_of_atm())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_rep_no_of_atm())
								.append("; ");
						rowEditedB = true;
					}
					if (datavalues.getR1_rep_cb_approval_ref_num()
							.compareTo(existingReport.getR1_rep_cb_approval_ref_num()) != 0) {
						fieldNames.add("Representative Offices - CB Approval Reference Number");
						oldChange.append(rowPrefix).append("Column 19: ")
								.append(existingReport.getR1_rep_cb_approval_ref_num()).append("; ");
						newChange.append(rowPrefix).append("Column 19: ")
								.append(datavalues.getR1_rep_cb_approval_ref_num()).append("; ");
						rowEditedB = true;
					}
				}
			}
		}
		boolean rowEditedC = false;
		for (BRF201_SUMMARY_ENTITY_C datavalues : userData2) {
			for (BRF201_SUMMARY_ENTITY_C existingReport : existingReports2) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getSrl_no() + " : ";
					if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getSrl_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getSrl_no()).append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_name().compareTo(existingReport.getR1_for_name()) != 0) {
						fieldNames.add("Foreign Branches - Name");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_for_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_for_name())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_country_of_incorporation()
							.compareTo(existingReport.getR1_for_country_of_incorporation()) != 0) {
						fieldNames.add("Foreign Branches - Country of Incorporation");
						oldChange.append(rowPrefix).append("Column 3: ")
								.append(existingReport.getR1_for_country_of_incorporation()).append("; ");
						newChange.append(rowPrefix).append("Column 3: ")
								.append(datavalues.getR1_for_country_of_incorporation()).append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_date_opened().compareTo(existingReport.getR1_for_date_opened()) != 0) {
						fieldNames.add("Foreign Branches - Date Opened(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_for_date_opened())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_for_date_opened())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_date_closed().compareTo(existingReport.getR1_for_date_closed()) != 0) {
						fieldNames.add("Foreign Branches - Date Closed(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_for_date_closed())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_for_date_closed())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_regulator().compareTo(existingReport.getR1_for_regulator()) != 0) {
						fieldNames.add("Foreign Branches - Regulator");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_for_regulator())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_for_regulator())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_ownership().compareTo(existingReport.getR1_for_ownership()) != 0) {
						fieldNames.add("Foreign Branches - Ownership %");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_for_ownership())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_for_ownership())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_nature_of_business()
							.compareTo(existingReport.getR1_for_nature_of_business()) != 0) {
						fieldNames.add("Foreign Branches - Nature of Business");
						oldChange.append(rowPrefix).append("Column 8: ")
								.append(existingReport.getR1_for_nature_of_business()).append("; ");
						newChange.append(rowPrefix).append("Column 8: ")
								.append(datavalues.getR1_for_nature_of_business()).append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_share_capital().compareTo(existingReport.getR1_for_share_capital()) != 0) {
						fieldNames.add("Foreign Branches - Share Capital");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(existingReport.getR1_for_share_capital()).append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_for_share_capital())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_share_premium().compareTo(existingReport.getR1_for_share_premium()) != 0) {
						fieldNames.add("Foreign Branches - Share Premium");
						oldChange.append(rowPrefix).append("Column 10: ")
								.append(existingReport.getR1_for_share_premium()).append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_for_share_premium())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_reserves().compareTo(existingReport.getR1_for_reserves()) != 0) {
						fieldNames.add("Foreign Branches - Reserves");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_for_reserves())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_for_reserves())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_accumulated_retained_earnings()
							.compareTo(existingReport.getR1_for_accumulated_retained_earnings()) != 0) {
						fieldNames.add("Foreign Branches - Accumulated Retained Earnings");
						oldChange.append(rowPrefix).append("Column 12: ")
								.append(existingReport.getR1_for_accumulated_retained_earnings()).append("; ");
						newChange.append(rowPrefix).append("Column 12: ")
								.append(datavalues.getR1_for_accumulated_retained_earnings()).append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_assets().compareTo(existingReport.getR1_for_assets()) != 0) {
						fieldNames.add("Foreign Branches - Assets ");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_for_assets())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_for_assets())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_ceo_name().compareTo(existingReport.getR1_for_ceo_name()) != 0) {
						fieldNames.add("Foreign Branches - CEO's Name");
						oldChange.append(rowPrefix).append("Column 14: ").append(existingReport.getR1_for_ceo_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 14: ").append(datavalues.getR1_for_ceo_name())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_no_of_staff().compareTo(existingReport.getR1_for_no_of_staff()) != 0) {
						fieldNames.add("Foreign Branches - Number of Staff");
						oldChange.append(rowPrefix).append("Column 15: ").append(existingReport.getR1_for_no_of_staff())
								.append("; ");
						newChange.append(rowPrefix).append("Column 15: ").append(datavalues.getR1_for_no_of_staff())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_no_of_uae_nationals()
							.compareTo(existingReport.getR1_for_no_of_uae_nationals()) != 0) {
						fieldNames.add("Foreign Branches - Number of UAE Nationals");
						oldChange.append(rowPrefix).append("Column 16: ")
								.append(existingReport.getR1_for_no_of_uae_nationals()).append("; ");
						newChange.append(rowPrefix).append("Column 16: ")
								.append(datavalues.getR1_for_no_of_uae_nationals()).append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_no_of_branches()
							.compareTo(existingReport.getR1_for_no_of_branches()) != 0) {
						fieldNames.add("Foreign Branches - Number of Branches");
						oldChange.append(rowPrefix).append("Column 17: ")
								.append(existingReport.getR1_for_no_of_branches()).append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_for_no_of_branches())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_no_of_atm().compareTo(existingReport.getR1_for_no_of_atm()) != 0) {
						fieldNames.add("Foreign Branches - Number of ATMs");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_for_no_of_atm())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_for_no_of_atm())
								.append("; ");
						rowEditedC = true;
					}
					if (datavalues.getR1_for_cb_approval_ref_num()
							.compareTo(existingReport.getR1_for_cb_approval_ref_num()) != 0) {
						fieldNames.add("Foreign Branches - CB Approval Reference Number");
						oldChange.append(rowPrefix).append("Column 19: ")
								.append(existingReport.getR1_for_cb_approval_ref_num()).append("; ");
						newChange.append(rowPrefix).append("Column 19: ")
								.append(datavalues.getR1_for_cb_approval_ref_num()).append("; ");
						rowEditedC = true;
					}
				}
			}
		}
		boolean rowEditedD = false;
		for (BRF201_SUMMARY_ENTITY_D datavalues : userData3) {
			for (BRF201_SUMMARY_ENTITY_D existingReport : existingReports3) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getSrl_no() + " : ";
					if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getSrl_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getSrl_no()).append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_name().compareTo(existingReport.getR1_ban_name()) != 0) {
						fieldNames.add("Banking Subsidiaries - Name");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_ban_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_ban_name())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_country_of_incorporation()
							.compareTo(existingReport.getR1_ban_country_of_incorporation()) != 0) {
						fieldNames.add("Banking Subsidiaries - Country of Incorporation");
						oldChange.append(rowPrefix).append("Column 3: ")
								.append(existingReport.getR1_ban_country_of_incorporation()).append("; ");
						newChange.append(rowPrefix).append("Column 3: ")
								.append(datavalues.getR1_ban_country_of_incorporation()).append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_date_opened().compareTo(existingReport.getR1_ban_date_opened()) != 0) {
						fieldNames.add("Banking Subsidiaries - Date Opened(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_ban_date_opened())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_ban_date_opened())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_date_closed().compareTo(existingReport.getR1_ban_date_closed()) != 0) {
						fieldNames.add("Banking Subsidiaries - Date Closed(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_ban_date_closed())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_ban_date_closed())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_regulator().compareTo(existingReport.getR1_ban_regulator()) != 0) {
						fieldNames.add("Banking Subsidiaries - Regulator");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_ban_regulator())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_ban_regulator())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_ownership().compareTo(existingReport.getR1_ban_ownership()) != 0) {
						fieldNames.add("Banking Subsidiaries - Ownership %");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_ban_ownership())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_ban_ownership())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_nature_of_business()
							.compareTo(existingReport.getR1_ban_nature_of_business()) != 0) {
						fieldNames.add("Banking Subsidiaries - Nature of Business");
						oldChange.append(rowPrefix).append("Column 8: ")
								.append(existingReport.getR1_ban_nature_of_business()).append("; ");
						newChange.append(rowPrefix).append("Column 8: ")
								.append(datavalues.getR1_ban_nature_of_business()).append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_share_capital().compareTo(existingReport.getR1_ban_share_capital()) != 0) {
						fieldNames.add("Banking Subsidiaries - Share Capital");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(existingReport.getR1_ban_share_capital()).append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_ban_share_capital())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_share_premium().compareTo(existingReport.getR1_ban_share_premium()) != 0) {
						fieldNames.add("Banking Subsidiaries - Share Premium");
						oldChange.append(rowPrefix).append("Column 10: ")
								.append(existingReport.getR1_ban_share_premium()).append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_ban_share_premium())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_reserves().compareTo(existingReport.getR1_ban_reserves()) != 0) {
						fieldNames.add("Banking Subsidiaries - Reserves");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_ban_reserves())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_ban_reserves())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_accumulated_retained_earnings()
							.compareTo(existingReport.getR1_ban_accumulated_retained_earnings()) != 0) {
						fieldNames.add("Banking Subsidiaries - Accumulated Retained Earnings");
						oldChange.append(rowPrefix).append("Column 12: ")
								.append(existingReport.getR1_ban_accumulated_retained_earnings()).append("; ");
						newChange.append(rowPrefix).append("Column 12: ")
								.append(datavalues.getR1_ban_accumulated_retained_earnings()).append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_assets().compareTo(existingReport.getR1_ban_assets()) != 0) {
						fieldNames.add("Banking Subsidiaries - Assets ");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_ban_assets())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_ban_assets())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_ceo_name().compareTo(existingReport.getR1_ban_ceo_name()) != 0) {
						fieldNames.add("Banking Subsidiaries - CEO's Name");
						oldChange.append(rowPrefix).append("Column 14: ").append(existingReport.getR1_ban_ceo_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 14: ").append(datavalues.getR1_ban_ceo_name())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_no_of_staff().compareTo(existingReport.getR1_ban_no_of_staff()) != 0) {
						fieldNames.add("Banking Subsidiaries - Number of Staff");
						oldChange.append(rowPrefix).append("Column 15: ").append(existingReport.getR1_ban_no_of_staff())
								.append("; ");
						newChange.append(rowPrefix).append("Column 15: ").append(datavalues.getR1_ban_no_of_staff())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_no_of_uae_nationals()
							.compareTo(existingReport.getR1_ban_no_of_uae_nationals()) != 0) {
						fieldNames.add("Banking Subsidiaries - Number of UAE Nationals");
						oldChange.append(rowPrefix).append("Column 16: ")
								.append(existingReport.getR1_ban_no_of_uae_nationals()).append("; ");
						newChange.append(rowPrefix).append("Column 16: ")
								.append(datavalues.getR1_ban_no_of_uae_nationals()).append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_no_of_branches()
							.compareTo(existingReport.getR1_ban_no_of_branches()) != 0) {
						fieldNames.add("Banking Subsidiaries - Number of Branches");
						oldChange.append(rowPrefix).append("Column 17: ")
								.append(existingReport.getR1_ban_no_of_branches()).append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_ban_no_of_branches())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_no_of_atm().compareTo(existingReport.getR1_ban_no_of_atm()) != 0) {
						fieldNames.add("Banking Subsidiaries - Number of ATMs");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_ban_no_of_atm())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_ban_no_of_atm())
								.append("; ");
						rowEditedD = true;
					}
					if (datavalues.getR1_ban_cb_approval_ref_num()
							.compareTo(existingReport.getR1_ban_cb_approval_ref_num()) != 0) {
						fieldNames.add("Banking Subsidiaries - CB Approval Reference Number");
						oldChange.append(rowPrefix).append("Column 19: ")
								.append(existingReport.getR1_ban_cb_approval_ref_num()).append("; ");
						newChange.append(rowPrefix).append("Column 19: ")
								.append(datavalues.getR1_ban_cb_approval_ref_num()).append("; ");
						rowEditedD = true;
					}
				}
			}
		}
		boolean rowEditedE = false;
		for (BRF201_SUMMARY_ENTITY_E datavalues : userData4) {
			for (BRF201_SUMMARY_ENTITY_E existingReport : existingReports4) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getSrl_no() + " : ";
					if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getSrl_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getSrl_no()).append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_name().compareTo(existingReport.getR1_fin_name()) != 0) {
						fieldNames.add("Financial Subsidiaries - Name");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_fin_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_fin_name())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_country_of_incorporation()
							.compareTo(existingReport.getR1_fin_country_of_incorporation()) != 0) {
						fieldNames.add("Financial Subsidiaries - Country of Incorporation");
						oldChange.append(rowPrefix).append("Column 3: ")
								.append(existingReport.getR1_fin_country_of_incorporation()).append("; ");
						newChange.append(rowPrefix).append("Column 3: ")
								.append(datavalues.getR1_fin_country_of_incorporation()).append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_date_opened().compareTo(existingReport.getR1_fin_date_opened()) != 0) {
						fieldNames.add("Financial Subsidiaries - Date Opened(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_fin_date_opened())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_fin_date_opened())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_date_closed().compareTo(existingReport.getR1_fin_date_closed()) != 0) {
						fieldNames.add("Financial Subsidiaries - Date Closed(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_fin_date_closed())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_fin_date_closed())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_regulator().compareTo(existingReport.getR1_fin_regulator()) != 0) {
						fieldNames.add("Financial Subsidiaries - Regulator");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_fin_regulator())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_fin_regulator())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_ownership().compareTo(existingReport.getR1_fin_ownership()) != 0) {
						fieldNames.add("Financial Subsidiaries - Ownership %");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_fin_ownership())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_fin_ownership())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_nature_of_business()
							.compareTo(existingReport.getR1_fin_nature_of_business()) != 0) {
						fieldNames.add("Financial Subsidiaries - Nature of Business");
						oldChange.append(rowPrefix).append("Column 8: ")
								.append(existingReport.getR1_fin_nature_of_business()).append("; ");
						newChange.append(rowPrefix).append("Column 8: ")
								.append(datavalues.getR1_fin_nature_of_business()).append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_share_capital().compareTo(existingReport.getR1_fin_share_capital()) != 0) {
						fieldNames.add("Financial Subsidiaries - Share Capital");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(existingReport.getR1_fin_share_capital()).append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_fin_share_capital())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_share_premium().compareTo(existingReport.getR1_fin_share_premium()) != 0) {
						fieldNames.add("Financial Subsidiaries - Share Premium");
						oldChange.append(rowPrefix).append("Column 10: ")
								.append(existingReport.getR1_fin_share_premium()).append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_fin_share_premium())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_reserves().compareTo(existingReport.getR1_fin_reserves()) != 0) {
						fieldNames.add("Financial Subsidiaries - Reserves");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_fin_reserves())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_fin_reserves())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_accumulated_retained_earnings()
							.compareTo(existingReport.getR1_fin_accumulated_retained_earnings()) != 0) {
						fieldNames.add("Financial Subsidiaries - Accumulated Retained Earnings");
						oldChange.append(rowPrefix).append("Column 12: ")
								.append(existingReport.getR1_fin_accumulated_retained_earnings()).append("; ");
						newChange.append(rowPrefix).append("Column 12: ")
								.append(datavalues.getR1_fin_accumulated_retained_earnings()).append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_assets().compareTo(existingReport.getR1_fin_assets()) != 0) {
						fieldNames.add("Financial Subsidiaries - Assets ");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_fin_assets())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_fin_assets())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_ceo_name().compareTo(existingReport.getR1_fin_ceo_name()) != 0) {
						fieldNames.add("Financial Subsidiaries - CEO's Name");
						oldChange.append(rowPrefix).append("Column 14: ").append(existingReport.getR1_fin_ceo_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 14: ").append(datavalues.getR1_fin_ceo_name())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_no_of_staff().compareTo(existingReport.getR1_fin_no_of_staff()) != 0) {
						fieldNames.add("Financial Subsidiaries - Number of Staff");
						oldChange.append(rowPrefix).append("Column 15: ").append(existingReport.getR1_fin_no_of_staff())
								.append("; ");
						newChange.append(rowPrefix).append("Column 15: ").append(datavalues.getR1_fin_no_of_staff())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_no_of_uae_nationals()
							.compareTo(existingReport.getR1_fin_no_of_uae_nationals()) != 0) {
						fieldNames.add("Financial Subsidiaries - Number of UAE Nationals");
						oldChange.append(rowPrefix).append("Column 16: ")
								.append(existingReport.getR1_fin_no_of_uae_nationals()).append("; ");
						newChange.append(rowPrefix).append("Column 16: ")
								.append(datavalues.getR1_fin_no_of_uae_nationals()).append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_no_of_branches()
							.compareTo(existingReport.getR1_fin_no_of_branches()) != 0) {
						fieldNames.add("Financial Subsidiaries - Number of Branches");
						oldChange.append(rowPrefix).append("Column 17: ")
								.append(existingReport.getR1_fin_no_of_branches()).append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_fin_no_of_branches())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_no_of_atm().compareTo(existingReport.getR1_fin_no_of_atm()) != 0) {
						fieldNames.add("Financial Subsidiaries - Number of ATMs");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_fin_no_of_atm())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_fin_no_of_atm())
								.append("; ");
						rowEditedE = true;
					}
					if (datavalues.getR1_fin_cb_approval_ref_num()
							.compareTo(existingReport.getR1_fin_cb_approval_ref_num()) != 0) {
						fieldNames.add("Financial Subsidiaries - CB Approval Reference Number");
						oldChange.append(rowPrefix).append("Column 19: ")
								.append(existingReport.getR1_fin_cb_approval_ref_num()).append("; ");
						newChange.append(rowPrefix).append("Column 19: ")
								.append(datavalues.getR1_fin_cb_approval_ref_num()).append("; ");
						rowEditedE = true;
					}
				}
			}
		}
		boolean rowEditedF = false;
		for (BRF201_SUMMARY_ENTITY_F datavalues : userData5) {
			for (BRF201_SUMMARY_ENTITY_F existingReport : existingReports5) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getSrl_no() + " : ";
					if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getSrl_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getSrl_no()).append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_name().compareTo(existingReport.getR1_non_name()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Name");
						oldChange.append(rowPrefix).append("Column 2: ").append(existingReport.getR1_non_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 2: ").append(datavalues.getR1_non_name())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_country_of_incorporation()
							.compareTo(existingReport.getR1_non_country_of_incorporation()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Country of Incorporation");
						oldChange.append(rowPrefix).append("Column 3: ")
								.append(existingReport.getR1_non_country_of_incorporation()).append("; ");
						newChange.append(rowPrefix).append("Column 3: ")
								.append(datavalues.getR1_non_country_of_incorporation()).append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_date_opened().compareTo(existingReport.getR1_non_date_opened()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Date Opened(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_non_date_opened())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_non_date_opened())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_date_closed().compareTo(existingReport.getR1_non_date_closed()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Date Closed(DD/MM/YYYY)");
						oldChange.append(rowPrefix).append("Column 5: ").append(existingReport.getR1_non_date_closed())
								.append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_non_date_closed())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_regulator().compareTo(existingReport.getR1_non_regulator()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Regulator");
						oldChange.append(rowPrefix).append("Column 6: ").append(existingReport.getR1_non_regulator())
								.append("; ");
						newChange.append(rowPrefix).append("Column 6: ").append(datavalues.getR1_non_regulator())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_ownership().compareTo(existingReport.getR1_non_ownership()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Ownership %");
						oldChange.append(rowPrefix).append("Column 7: ").append(existingReport.getR1_non_ownership())
								.append("; ");
						newChange.append(rowPrefix).append("Column 7: ").append(datavalues.getR1_non_ownership())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_nature_of_business()
							.compareTo(existingReport.getR1_non_nature_of_business()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Nature of Business");
						oldChange.append(rowPrefix).append("Column 8: ")
								.append(existingReport.getR1_non_nature_of_business()).append("; ");
						newChange.append(rowPrefix).append("Column 8: ")
								.append(datavalues.getR1_non_nature_of_business()).append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_share_capital().compareTo(existingReport.getR1_non_share_capital()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Share Capital");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(existingReport.getR1_non_share_capital()).append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_non_share_capital())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_share_premium().compareTo(existingReport.getR1_non_share_premium()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Share Premium");
						oldChange.append(rowPrefix).append("Column 10: ")
								.append(existingReport.getR1_non_share_premium()).append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_non_share_premium())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_reserves().compareTo(existingReport.getR1_non_reserves()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Reserves");
						oldChange.append(rowPrefix).append("Column 11: ").append(existingReport.getR1_non_reserves())
								.append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_non_reserves())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_accumulated_retained_earnings()
							.compareTo(existingReport.getR1_non_accumulated_retained_earnings()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Accumulated Retained Earnings");
						oldChange.append(rowPrefix).append("Column 12: ")
								.append(existingReport.getR1_non_accumulated_retained_earnings()).append("; ");
						newChange.append(rowPrefix).append("Column 12: ")
								.append(datavalues.getR1_non_accumulated_retained_earnings()).append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_assets().compareTo(existingReport.getR1_non_assets()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Assets ");
						oldChange.append(rowPrefix).append("Column 13: ").append(existingReport.getR1_non_assets())
								.append("; ");
						newChange.append(rowPrefix).append("Column 13: ").append(datavalues.getR1_non_assets())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_ceo_name().compareTo(existingReport.getR1_non_ceo_name()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - CEO's Name");
						oldChange.append(rowPrefix).append("Column 14: ").append(existingReport.getR1_non_ceo_name())
								.append("; ");
						newChange.append(rowPrefix).append("Column 14: ").append(datavalues.getR1_non_ceo_name())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_no_of_staff().compareTo(existingReport.getR1_non_no_of_staff()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Number of Staff");
						oldChange.append(rowPrefix).append("Column 15: ").append(existingReport.getR1_non_no_of_staff())
								.append("; ");
						newChange.append(rowPrefix).append("Column 15: ").append(datavalues.getR1_non_no_of_staff())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_no_of_uae_nationals()
							.compareTo(existingReport.getR1_non_no_of_uae_nationals()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Number of UAE Nationals");
						oldChange.append(rowPrefix).append("Column 16: ")
								.append(existingReport.getR1_non_no_of_uae_nationals()).append("; ");
						newChange.append(rowPrefix).append("Column 16: ")
								.append(datavalues.getR1_non_no_of_uae_nationals()).append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_no_of_branches()
							.compareTo(existingReport.getR1_non_no_of_branches()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Number of Branches");
						oldChange.append(rowPrefix).append("Column 17: ")
								.append(existingReport.getR1_non_no_of_branches()).append("; ");
						newChange.append(rowPrefix).append("Column 17: ").append(datavalues.getR1_non_no_of_branches())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_no_of_atm().compareTo(existingReport.getR1_non_no_of_atm()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - Number of ATMs");
						oldChange.append(rowPrefix).append("Column 18: ").append(existingReport.getR1_non_no_of_atm())
								.append("; ");
						newChange.append(rowPrefix).append("Column 18: ").append(datavalues.getR1_non_no_of_atm())
								.append("; ");
						rowEditedF = true;
					}
					if (datavalues.getR1_non_cb_approval_ref_num()
							.compareTo(existingReport.getR1_non_cb_approval_ref_num()) != 0) {
						fieldNames.add("Non-Financial Subsidiaries - CB Approval Reference Number");
						oldChange.append(rowPrefix).append("Column 19: ")
								.append(existingReport.getR1_non_cb_approval_ref_num()).append("; ");
						newChange.append(rowPrefix).append("Column 19: ")
								.append(datavalues.getR1_non_cb_approval_ref_num()).append("; ");
						rowEditedF = true;
					}
				}
			}
		}
		boolean rowEditedG = false;
		for (BRF201_SUMMARY_ENTITY_G datavalues : userData6) {
			for (BRF201_SUMMARY_ENTITY_G existingReport : existingReports6) {
				// Assuming you want to compare only if the serial numbers match
				if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) == 0) {
					String rowPrefix = "Row " + datavalues.getSrl_no() + " : ";
					if (datavalues.getSrl_no().compareTo(existingReport.getSrl_no()) != 0) {
						fieldNames.add("Srl no");
						oldChange.append(rowPrefix).append("Column 1: ").append(existingReport.getSrl_no())
								.append("; ");
						newChange.append(rowPrefix).append("Column 1: ").append(datavalues.getSrl_no()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_total_network_numbers()
							.compareTo(existingReport.getR1_total_network_numbers()) != 0) {
						fieldNames.add("Total Network  - Total Network (Total of Column D to M only)");
						oldChange.append(rowPrefix).append("Column 2: ")
								.append(existingReport.getR1_total_network_numbers()).append("; ");
						newChange.append(rowPrefix).append("Column 2: ")
								.append(datavalues.getR1_total_network_numbers()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_domestic_foreign_branches()
							.compareTo(existingReport.getR1_domestic_foreign_branches()) != 0) {
						fieldNames.add("Total Network  - Domestic and Foreign Branches");
						oldChange.append(rowPrefix).append("Column 3: ")
								.append(existingReport.getR1_domestic_foreign_branches()).append("; ");
						newChange.append(rowPrefix).append("Column 3: ")
								.append(datavalues.getR1_domestic_foreign_branches()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_rep_offices().compareTo(existingReport.getR1_rep_offices()) != 0) {
						fieldNames.add("Total Network  - Representative offices");
						oldChange.append(rowPrefix).append("Column 4: ").append(existingReport.getR1_rep_offices())
								.append("; ");
						newChange.append(rowPrefix).append("Column 4: ").append(datavalues.getR1_rep_offices())
								.append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_banking_subsidiaries()
							.compareTo(existingReport.getR1_banking_subsidiaries()) != 0) {
						fieldNames.add("Total Network  - Banking Subsidiaries");
						oldChange.append(rowPrefix).append("Column 5: ")
								.append(existingReport.getR1_banking_subsidiaries()).append("; ");
						newChange.append(rowPrefix).append("Column 5: ").append(datavalues.getR1_banking_subsidiaries())
								.append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_non_banking_financial_subsidiaries()
							.compareTo(existingReport.getR1_non_banking_financial_subsidiaries()) != 0) {
						fieldNames.add("Total Network  - Non-Banking Financial Subsidiaries");
						oldChange.append(rowPrefix).append("Column 6: ")
								.append(existingReport.getR1_non_banking_financial_subsidiaries()).append("; ");
						newChange.append(rowPrefix).append("Column 6: ")
								.append(datavalues.getR1_non_banking_financial_subsidiaries()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_non_financial_subsidiaries()
							.compareTo(existingReport.getR1_non_financial_subsidiaries()) != 0) {
						fieldNames.add("Total Network  - Non-Financial Subsidiaries");
						oldChange.append(rowPrefix).append("Column 7: ")
								.append(existingReport.getR1_non_financial_subsidiaries()).append("; ");
						newChange.append(rowPrefix).append("Column 7: ")
								.append(datavalues.getR1_non_financial_subsidiaries()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_pay_offices().compareTo(existingReport.getR1_pay_offices()) != 0) {
						fieldNames.add("Total Network  - Pay offices");
						oldChange.append(rowPrefix).append("Column 8: ").append(existingReport.getR1_pay_offices())
								.append("; ");
						newChange.append(rowPrefix).append("Column 8: ").append(datavalues.getR1_pay_offices())
								.append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_elec_business_units()
							.compareTo(existingReport.getR1_elec_business_units()) != 0) {
						fieldNames.add("Total Network  - Electronic Business Units");
						oldChange.append(rowPrefix).append("Column 9: ")
								.append(existingReport.getR1_elec_business_units()).append("; ");
						newChange.append(rowPrefix).append("Column 9: ").append(datavalues.getR1_elec_business_units())
								.append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_atms().compareTo(existingReport.getR1_atms()) != 0) {
						fieldNames.add("Total Network  - ATMs");
						oldChange.append(rowPrefix).append("Column 10: ").append(existingReport.getR1_atms())
								.append("; ");
						newChange.append(rowPrefix).append("Column 10: ").append(datavalues.getR1_atms()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_admins_office_uae().compareTo(existingReport.getR1_admins_office_uae()) != 0) {
						fieldNames.add("Total Network  - Administrative Offices in UAE");
						oldChange.append(rowPrefix).append("Column 11: ")
								.append(existingReport.getR1_admins_office_uae()).append("; ");
						newChange.append(rowPrefix).append("Column 11: ").append(datavalues.getR1_admins_office_uae())
								.append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_admins_office_outside_uae()
							.compareTo(existingReport.getR1_admins_office_outside_uae()) != 0) {
						fieldNames.add("Total Network  - Administrative Offices Outside UAE");
						oldChange.append(rowPrefix).append("Column 12: ")
								.append(existingReport.getR1_admins_office_outside_uae()).append("; ");
						newChange.append(rowPrefix).append("Column 12: ")
								.append(datavalues.getR1_admins_office_outside_uae()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_no_of_mobile_banking_user()
							.compareTo(existingReport.getR1_no_of_mobile_banking_user()) != 0) {
						fieldNames.add("Total Network  - Number of Mobile Banking Users ");
						oldChange.append(rowPrefix).append("Column 13: ")
								.append(existingReport.getR1_no_of_mobile_banking_user()).append("; ");
						newChange.append(rowPrefix).append("Column 13: ")
								.append(datavalues.getR1_no_of_mobile_banking_user()).append("; ");
						rowEditedG = true;
					}
					if (datavalues.getR1_no_of_internet_banking_user()
							.compareTo(existingReport.getR1_no_of_internet_banking_user()) != 0) {
						fieldNames.add("Total Network  - Number of Internet Banking Users");
						oldChange.append(rowPrefix).append("Column 14: ")
								.append(existingReport.getR1_no_of_internet_banking_user()).append("; ");
						newChange.append(rowPrefix).append("Column 14: ")
								.append(datavalues.getR1_no_of_internet_banking_user()).append("; ");
						rowEditedG = true;
					}
				}
			}
		}
		if (rowEditedB) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
		}
		if (rowEditedC) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
		}
		if (rowEditedD) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
		}
		if (rowEditedE) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
		}
		if (rowEditedF) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
		}
		if (rowEditedG) {
			oldValuesList.add(oldChange.toString().trim());
			newValuesList.add(newChange.toString().trim());
		}
		// Repeat for other rows as needed

		/*
		 * if (Objects.nonNull(userData) && !userData.isEmpty()) {
		 * List<BRF201_SUMMARY_ENTITY_A> updatedReports = new ArrayList<>(); for
		 * (BRF201_SUMMARY_ENTITY_A entity : userData) { entity.setDel_flg("N");
		 * entity.setEntity_flg("Y"); entity.setModify_flg("Y");
		 * entity.setModify_user(userId); entity.setReport_date(asondate);
		 * entity.setReport_submit_date(new Date()); updatedReports.add(entity); }
		 * brf201_SUMMARY_REP_A.saveAll(updatedReports); msg = "Updated Successfully"; }
		 * else { msg = "Data Not Found"; }
		 */

		if (Objects.nonNull(userData1) && !userData1.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_B> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_B entity : userData1) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_B.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData2) && !userData1.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_C> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_C entity : userData2) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_C.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData3) && !userData1.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_D> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_D entity : userData3) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_D.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData4) && !userData1.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_E> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_E entity : userData4) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_E.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(userData5) && !userData1.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_F> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_F entity : userData5) {
				entity.setDel_flg("N");
				entity.setEntity_flg("Y");
				entity.setModify_flg("Y");
				entity.setModify_user(userId);
				entity.setReport_date(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_F.saveAll(updatedReports);
			msg = "Updated Successfully";
		} else {
			msg = "Data Not Found";
		}
		// 1. Handle Entity B - Modify first
		if (rowEditedB) {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity B - Modify
			MANUAL_Service_Entity auditB = new MANUAL_Service_Entity();
			auditB.setAudit_date(new Date());
			auditB.setEntry_time(new Date());
			auditB.setEntry_user(user1);
			auditB.setFunc_code("MODIFY");
			auditB.setAudit_table("BRF201_SUMMARYTABLE_B");
			auditB.setAudit_screen("MODIFY");
			auditB.setEvent_id(user1);
			auditB.setEvent_name(username);
			auditB.setOld_value(String.join("; ", oldValuesList));
			auditB.setNew_value(String.join("; ", newValuesList));
			auditB.setField_name(String.join("; ", fieldNames));
			auditB.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			auditB.setAuth_user(values1.getAuth_user());
			auditB.setAuth_time(values1.getAuth_time());
			auditB.setAudit_ref_no(auditID);

			// Save MODIFY entry for Entity B
			mANUAL_Service_Rep.save(auditB);
		}

		// 2. Handle Entity C - Modify next
		else if (rowEditedC) {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity C - Modify
			MANUAL_Service_Entity auditC = new MANUAL_Service_Entity();
			auditC.setAudit_date(new Date());
			auditC.setEntry_time(new Date());
			auditC.setEntry_user(user1);
			auditC.setFunc_code("MODIFY");
			auditC.setAudit_table("BRF201_SUMMARYTABLE_C");
			auditC.setAudit_screen("MODIFY");
			auditC.setEvent_id(user1);
			auditC.setEvent_name(username);
			auditC.setOld_value(String.join("; ", oldValuesList));
			auditC.setNew_value(String.join("; ", newValuesList));
			auditC.setField_name(String.join("; ", fieldNames));
			auditC.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			auditC.setAuth_user(values1.getAuth_user());
			auditC.setAuth_time(values1.getAuth_time());
			auditC.setAudit_ref_no(auditID);

			// Save MODIFY entry for Entity C
			mANUAL_Service_Rep.save(auditC);
		}
		// 3. Handle Entity D - Modify next
		else if (rowEditedD) {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity D - Modify
			MANUAL_Service_Entity auditD = new MANUAL_Service_Entity();
			auditD.setAudit_date(new Date());
			auditD.setEntry_time(new Date());
			auditD.setEntry_user(user1);
			auditD.setFunc_code("MODIFY");
			auditD.setAudit_table("BRF201_SUMMARYTABLE_D");
			auditD.setAudit_screen("MODIFY");
			auditD.setEvent_id(user1);
			auditD.setEvent_name(username);
			auditD.setOld_value(String.join("; ", oldValuesList));
			auditD.setNew_value(String.join("; ", newValuesList));
			auditD.setField_name(String.join("; ", fieldNames));
			auditD.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			auditD.setAuth_user(values1.getAuth_user());
			auditD.setAuth_time(values1.getAuth_time());
			auditD.setAudit_ref_no(auditID);

			// Save MODIFY entry for Entity D
			mANUAL_Service_Rep.save(auditD);
		}
		// 4. Handle Entity E - Modify next
		else if (rowEditedE) {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity E - Modify
			MANUAL_Service_Entity auditE = new MANUAL_Service_Entity();
			auditE.setAudit_date(new Date());
			auditE.setEntry_time(new Date());
			auditE.setEntry_user(user1);
			auditE.setFunc_code("MODIFY");
			auditE.setAudit_table("BRF201_SUMMARYTABLE_E");
			auditE.setAudit_screen("MODIFY");
			auditE.setEvent_id(user1);
			auditE.setEvent_name(username);
			auditE.setOld_value(String.join("; ", oldValuesList));
			auditE.setNew_value(String.join("; ", newValuesList));
			auditE.setField_name(String.join("; ", fieldNames));
			auditE.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			auditE.setAuth_user(values1.getAuth_user());
			auditE.setAuth_time(values1.getAuth_time());
			auditE.setAudit_ref_no(auditID);

			// Save MODIFY entry for Entity E
			mANUAL_Service_Rep.save(auditE);
		}
		// 5. Handle Entity F - Modify next
		else if (rowEditedF) {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity F - Modify
			MANUAL_Service_Entity auditF = new MANUAL_Service_Entity();
			auditF.setAudit_date(new Date());
			auditF.setEntry_time(new Date());
			auditF.setEntry_user(user1);
			auditF.setFunc_code("MODIFY");
			auditF.setAudit_table("BRF201_SUMMARYTABLE_F");
			auditF.setAudit_screen("MODIFY");
			auditF.setEvent_id(user1);
			auditF.setEvent_name(username);
			auditF.setOld_value(String.join("; ", oldValuesList));
			auditF.setNew_value(String.join("; ", newValuesList));
			auditF.setField_name(String.join("; ", fieldNames));
			auditF.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			auditF.setAuth_user(values1.getAuth_user());
			auditF.setAuth_time(values1.getAuth_time());
			auditF.setAudit_ref_no(auditID);

			// Save MODIFY entry for Entity F
			mANUAL_Service_Rep.save(auditF);
		}
		// 6. Handle Entity G - Modify next
		else if (rowEditedG) {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity G - Modify
			MANUAL_Service_Entity auditG = new MANUAL_Service_Entity();
			auditG.setAudit_date(new Date());
			auditG.setEntry_time(new Date());
			auditG.setEntry_user(user1);
			auditG.setFunc_code("MODIFY");
			auditG.setAudit_table("BRF201_SUMMARYTABLE_G");
			auditG.setAudit_screen("MODIFY");
			auditG.setEvent_id(user1);
			auditG.setEvent_name(username);
			auditG.setOld_value(String.join("; ", oldValuesList));
			auditG.setNew_value(String.join("; ", newValuesList));
			auditG.setField_name(String.join("; ", fieldNames));
			auditG.setRemarks("Modify Successfully");

			UserProfile values1 = userProfileRep.getRole(user1);
			auditG.setAuth_user(values1.getAuth_user());
			auditG.setAuth_time(values1.getAuth_time());
			auditG.setAudit_ref_no(auditID);

			// Save MODIFY entry for Entity G
			mANUAL_Service_Rep.save(auditG);
		}

		// 7.if no modification
		else {
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Entity B Logic
			if (!rowEditedB && existingReports1.size() != userData1.size()) {
				for (BRF201_SUMMARY_ENTITY_B userdatas : userData1) {
					boolean found = false;
					for (BRF201_SUMMARY_ENTITY_B exiting : existingReports1) {
						if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
							found = true;
							break;
						}
					}
					if (!found) {
						finaloldvalB.add(userdatas.toString());
					}
				}

				// Create audit entry for Entity B
				MANUAL_Service_Entity auditAddB = new MANUAL_Service_Entity();
				auditAddB.setAudit_date(new Date());
				auditAddB.setEntry_time(new Date());
				auditAddB.setEntry_user(user1);
				auditAddB.setFunc_code("ADD");
				auditAddB.setAudit_table("BRF201_SUMMARY_TABLE_B");
				auditAddB.setAudit_screen("ADD");
				auditAddB.setEvent_id(user1);
				auditAddB.setEvent_name(username);
				auditAddB.setNew_value(String.join("; ", finaloldvalB));
				auditAddB.setRemarks("Added Successfully");

				UserProfile valuesB = userProfileRep.getRole(user1);
				auditAddB.setAuth_user(valuesB.getAuth_user());
				auditAddB.setAuth_time(valuesB.getAuth_time());
				auditAddB.setAudit_ref_no(auditID);

				mANUAL_Service_Rep.save(auditAddB);
			}

			// Entity C Logic
			if (!rowEditedC && existingReports2.size() != userData2.size()) {
				for (BRF201_SUMMARY_ENTITY_C userdatas : userData2) {
					boolean found = false;
					for (BRF201_SUMMARY_ENTITY_C exiting : existingReports2) {
						if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
							found = true;
							break;
						}
					}
					if (!found) {
						finaloldvalC.add(userdatas.toString());
					}
				}

				// Create audit entry for Entity C
				MANUAL_Service_Entity auditAddC = new MANUAL_Service_Entity();
				auditAddC.setAudit_date(new Date());
				auditAddC.setEntry_time(new Date());
				auditAddC.setEntry_user(user1);
				auditAddC.setFunc_code("ADD");
				auditAddC.setAudit_table("BRF201_SUMMARY_TABLE_C");
				auditAddC.setAudit_screen("ADD");
				auditAddC.setEvent_id(user1);
				auditAddC.setEvent_name(username);
				auditAddC.setNew_value(String.join("; ", finaloldvalC));
				auditAddC.setRemarks("Added Successfully");

				UserProfile valuesC = userProfileRep.getRole(user1);
				auditAddC.setAuth_user(valuesC.getAuth_user());
				auditAddC.setAuth_time(valuesC.getAuth_time());
				auditAddC.setAudit_ref_no(auditID);

				mANUAL_Service_Rep.save(auditAddC);
			}

			// Entity D Logic
			if (!rowEditedD && existingReports3.size() != userData3.size()) {
				for (BRF201_SUMMARY_ENTITY_D userdatas : userData3) {
					boolean found = false;
					for (BRF201_SUMMARY_ENTITY_D exiting : existingReports3) {
						if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
							found = true;
							break;
						}
					}
					if (!found) {
						finaloldvalD.add(userdatas.toString());
					}
				}

				// Create audit entry for Entity D
				MANUAL_Service_Entity auditAddD = new MANUAL_Service_Entity();
				auditAddD.setAudit_date(new Date());
				auditAddD.setEntry_time(new Date());
				auditAddD.setEntry_user(user1);
				auditAddD.setFunc_code("ADD");
				auditAddD.setAudit_table("BRF201_SUMMARY_TABLE_D");
				auditAddD.setAudit_screen("ADD");
				auditAddD.setEvent_id(user1);
				auditAddD.setEvent_name(username);
				auditAddD.setNew_value(String.join("; ", finaloldvalD));
				auditAddD.setRemarks("Added Successfully");

				UserProfile valuesD = userProfileRep.getRole(user1);
				auditAddD.setAuth_user(valuesD.getAuth_user());
				auditAddD.setAuth_time(valuesD.getAuth_time());
				auditAddD.setAudit_ref_no(auditID);

				mANUAL_Service_Rep.save(auditAddD);
			}

			// Entity E Logic
			if (!rowEditedE && existingReports4.size() != userData4.size()) {
				for (BRF201_SUMMARY_ENTITY_E userdatas : userData4) {
					boolean found = false;
					for (BRF201_SUMMARY_ENTITY_E exiting : existingReports4) {
						if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
							found = true;
							break;
						}
					}
					if (!found) {
						finaloldvalE.add(userdatas.toString());
					}
				}

				// Create audit entry for Entity E
				MANUAL_Service_Entity auditAddE = new MANUAL_Service_Entity();
				auditAddE.setAudit_date(new Date());
				auditAddE.setEntry_time(new Date());
				auditAddE.setEntry_user(user1);
				auditAddE.setFunc_code("ADD");
				auditAddE.setAudit_table("BRF201_SUMMARY_TABLE_E");
				auditAddE.setAudit_screen("ADD");
				auditAddE.setEvent_id(user1);
				auditAddE.setEvent_name(username);
				auditAddE.setNew_value(String.join("; ", finaloldvalE));
				auditAddE.setRemarks("Added Successfully");

				UserProfile valuesE = userProfileRep.getRole(user1);
				auditAddE.setAuth_user(valuesE.getAuth_user());
				auditAddE.setAuth_time(valuesE.getAuth_time());
				auditAddE.setAudit_ref_no(auditID);

				mANUAL_Service_Rep.save(auditAddE);
			}

			// Entity F Logic
			if (!rowEditedF && existingReports5.size() != userData5.size()) {
				for (BRF201_SUMMARY_ENTITY_F userdatas : userData5) {
					boolean found = false;
					for (BRF201_SUMMARY_ENTITY_F exiting : existingReports5) {
						if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
							found = true;
							break;
						}
					}
					if (!found) {
						finaloldvalF.add(userdatas.toString());
					}
				}

				// Create audit entry for Entity F
				MANUAL_Service_Entity auditAddF = new MANUAL_Service_Entity();
				auditAddF.setAudit_date(new Date());
				auditAddF.setEntry_time(new Date());
				auditAddF.setEntry_user(user1);
				auditAddF.setFunc_code("ADD");
				auditAddF.setAudit_table("BRF201_SUMMARY_TABLE_F");
				auditAddF.setAudit_screen("ADD");
				auditAddF.setEvent_id(user1);
				auditAddF.setEvent_name(username);
				auditAddF.setNew_value(String.join("; ", finaloldvalF));
				auditAddF.setRemarks("Added Successfully");

				UserProfile valuesF = userProfileRep.getRole(user1);
				auditAddF.setAuth_user(valuesF.getAuth_user());
				auditAddF.setAuth_time(valuesF.getAuth_time());
				auditAddF.setAudit_ref_no(auditID);

				mANUAL_Service_Rep.save(auditAddF);
			}

			// Entity G Logic
//			if (!rowEditedG && existingReports6.size() != userData6.size()) {
//				for (BRF201_SUMMARY_ENTITY_G userdatas : userData6) {
//					boolean found = false;
//					for (BRF201_SUMMARY_ENTITY_G exiting : existingReports6) {
//						if (exiting.getSrl_no().equals(userdatas.getSrl_no())) {
//							found = true;
//							break;
//						}
//					}
//					if (!found) {
//						finaloldvalG.add(userdatas.toString());
//					}
//				}
//
//				// Create audit entry for Entity G
//				MANUAL_Service_Entity auditAddG = new MANUAL_Service_Entity();
//				auditAddG.setAudit_date(new Date());
//				auditAddG.setEntry_time(new Date());
//				auditAddG.setEntry_user(user1);
//				auditAddG.setFunc_code("ADD");
//				auditAddG.setAudit_table("BRF201_SUMMARY_TABLE_G");
//				auditAddG.setAudit_screen("ADD");
//				auditAddG.setEvent_id(user1);
//				auditAddG.setEvent_name(username);
//				auditAddG.setNew_value(String.join("; ", finaloldvalG));
//				auditAddG.setRemarks("Added Successfully");
//
//				UserProfile valuesG = userProfileRep.getRole(user1);
//				auditAddG.setAuth_user(valuesG.getAuth_user());
//				auditAddG.setAuth_time(valuesG.getAuth_time());
//				auditAddG.setAudit_ref_no(auditID);
//
//				mANUAL_Service_Rep.save(auditAddG);
//			}
		}

		return msg;
	}

	public String verifyBRF201Report(Date asondate, String userId, HttpServletRequest req) {
		String msg = "";

		List<BRF201_SUMMARY_ENTITY_A> existingReports = brf201_SUMMARY_REP_A.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_B> existingReports1 = brf201_SUMMARY_REP_B.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_C> existingReports2 = brf201_SUMMARY_REP_C.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_D> existingReports3 = brf201_SUMMARY_REP_D.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_E> existingReports4 = brf201_SUMMARY_REP_E.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_F> existingReports5 = brf201_SUMMARY_REP_F.getBRF201reportService(asondate);
		List<BRF201_SUMMARY_ENTITY_G> existingReports6 = brf201_SUMMARY_REP_G.getBRF201reportService(asondate);

		if (Objects.nonNull(existingReports) && !existingReports.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_A> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_A entity : existingReports) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_A.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports1) && !existingReports1.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_B> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_B entity : existingReports1) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_B.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports2) && !existingReports2.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_C> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_C entity : existingReports2) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_C.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports3) && !existingReports3.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_D> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_D entity : existingReports3) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_D.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports4) && !existingReports4.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_E> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_E entity : existingReports4) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_E.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports5) && !existingReports5.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_F> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_F entity : existingReports5) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_F.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}

		if (Objects.nonNull(existingReports6) && !existingReports6.isEmpty()) {
			List<BRF201_SUMMARY_ENTITY_G> updatedReports = new ArrayList<>();
			for (BRF201_SUMMARY_ENTITY_G entity : existingReports6) {
				entity.setEntity_flg("Y");
				entity.setModify_flg("N");
				entity.setReport_date(asondate);
				entity.setVerify_time(new Date());
				entity.setVerify_user(userId);
				entity.setVerify_time(asondate);
				entity.setReport_submit_date(new Date());
				updatedReports.add(entity);
			}
			brf201_SUMMARY_REP_G.saveAll(updatedReports);
			msg = "Verify Successfully";
		} else {
			msg = "Data Not Found";
		}
		String auditID = sequence.generateRequestUUId();
		System.out.println("Generated Audit ID: " + auditID);

		String user1 = (String) req.getSession().getAttribute("USERID");
		String username = (String) req.getSession().getAttribute("USERNAME");
		System.out.println("USERID: " + user1);
		System.out.println("USERNAME: " + username);

		MANUAL_Service_Entity audit = new MANUAL_Service_Entity();
		audit.setAudit_date(new Date());
		audit.setEntry_time(new Date());
		audit.setEntry_user(user1);
		audit.setFunc_code("VERIFY");
		audit.setAudit_table("BRF201_SUMMARYTABLE");
		audit.setAudit_screen("VERIFY");
		audit.setEvent_id(user1);
		audit.setEvent_name(username);
		audit.setRemarks("Verify Successfully");

		UserProfile values1 = userProfileRep.getRole(user1);
		System.out.println("Auth User: " + values1.getAuth_user());
		System.out.println("Auth Time: " + values1.getAuth_time());

		audit.setAuth_user(values1.getAuth_user());
		audit.setAuth_time(values1.getAuth_time());
		audit.setAudit_ref_no(auditID);

		mANUAL_Service_Rep.save(audit);
		System.out.println("Audit entry saved successfully with Audit ID: " + auditID);

		
		return msg;
	}

}
