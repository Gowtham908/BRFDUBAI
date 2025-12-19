package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.bornfire.xbrl.entities.BRBS.BRF54_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF054ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF32ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF54_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF54_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF54_DetailRep;

import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;

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

public class BRF54ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF54ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	BRF54_DetailRep brf54detailrep;

	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;

	@Autowired
	Environment env;

	@Autowired
	BRF32ServiceRepo brf32ServiceRepo;

	@Autowired
	BRF054ServiceRepo brf054ServiceRepo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF054(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			// dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF54_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF54_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF054View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF54_ENTITY> T1rep = new ArrayList<BRF54_ENTITY>();
		// Query<Object[]> qr;

		List<BRF54_ENTITY> T1Master = new ArrayList<BRF54_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = brf32ServiceRepo .getBRF32reportService(d1);

			T1Master = hs.createQuery("from BRF54_ENTITY a where a.report_date = ?1 ", BRF54_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF54");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF054Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF54_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF54_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF54_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF54_DETAIL_ENTITY> T1Master = new ArrayList<BRF54_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF54_DETAIL_ENTITY a where a.report_date = ?1", BRF54_DETAIL_ENTITY.class)
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
			Date maturity_date = (Date) a[45];
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

			BRF54_DETAIL_ENTITY py = new BRF54_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF54::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF054(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-054-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF54_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF54_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF54.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF54.jrxml");
						}
					}

					// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

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

				List<BRF54_ENTITY> T1Master = new ArrayList<BRF54_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF54_ENTITY a where a.report_date = ?1 ", BRF54_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF54_ENTITY BRF54 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-054-AT.xls");

							// Load the Excel file
							Workbook workbook = WorkbookFactory.create(Responsecamt);

							FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-054-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-054-A.xls");

		return outputFile;

	}
	/*
	 * public File getFileGENERATION(String reportId, String fromdate, String
	 * todate, String currency, String dtltype, String filetype) throws
	 * FileNotFoundException, JRException, SQLException {
	 * 
	 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); DateFormat
	 * dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
	 * logger.info("GET GENERATION"); System.out.println("generation"+todate);
	 * String path = this.env.getProperty("output.exportpath"); String fileName =
	 * ""; String zipFileName = ""; File outputFile; Date master; String NAME; try {
	 * master = dateFormat.parse(todate); NAME = dateFormat1.format(master);
	 * fileName = "T" + reportId + "_" + NAME; } catch (ParseException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * 
	 * 
	 * zipFileName = fileName + ".zip";
	 * 
	 * // String filetype="detailexcel"; // dtltype="report"; try { InputStream
	 * jasperFile; HashMap<String, Object> map = new HashMap<String, Object>();
	 * 
	 * jasperFile = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/Report_main.jasper"); //jasperFile =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T1/T1Previous.jasper"); InputStream subrep01
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/INDEX/RBSINDEX.jasper"); InputStream
	 * subrep02 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/INSTRUCTION/RBSINST.jasper"); InputStream
	 * subrep03 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/INDEX/Contact.jasper"); InputStream subrep1
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T1/T1Previous.jasper"); InputStream subrep2
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T1/T1Curr.jasper"); InputStream subrep3 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T2/T2P.jasper"); InputStream subrep4 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T2/T2C.jasper"); InputStream subrep5 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T3/T3P.jasper"); InputStream subrep6 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T3/T3C.jasper"); InputStream subrep7 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4A_PREVIOUS.jasper"); InputStream
	 * subrep8 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4A_CURRENT.jasper"); InputStream subrep9
	 * = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4B_PREVIOUS.jasper"); InputStream
	 * subrep10 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T4/T4B_CURRENT.jasper"); InputStream
	 * subrep11 = this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T5A/T5A.jasper"); InputStream subrep12 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T5A/T5B.jasper"); InputStream subrep13 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T6/T6.jasper"); InputStream subrep14 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T7/T7.jasper"); InputStream subrep15 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T8/T8A.jasper"); InputStream subrep16 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T8/T8B.jasper"); InputStream subrep17 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T9/T9.jasper"); InputStream subrep18 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T10/T10.jasper"); InputStream subrep19 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T11/T11.jasper"); InputStream subrep20 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12A.jasper"); InputStream subrep21 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12B.jasper"); InputStream subrep22 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12C.jasper"); InputStream subrep23 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12D.jasper"); InputStream subrep24 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12E.jasper"); InputStream subrep25 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12F.jasper"); InputStream subrep26 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12G.jasper"); InputStream subrep27 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T12/T12H.jasper"); InputStream subrep28 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T13/T13A.jasper"); InputStream subrep29 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T13/T13B.jasper"); InputStream subrep30 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T14/T14A.jasper"); InputStream subrep31 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T14/T14B.jasper"); InputStream subrep32 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T15/T15A.jasper"); InputStream subrep33 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T15/T15B.jasper"); InputStream subrep34 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16A.jasper"); InputStream subrep35 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16B.jasper"); InputStream subrep36 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16C.jasper"); InputStream subrep37 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16D.jasper"); InputStream subrep38 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T16/T16E.jasper"); InputStream subrep39 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T17/T17.jasper"); InputStream subrep40 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T18/T18.jasper"); InputStream subrep41 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T19/T19.jasper"); InputStream subrep42 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T20/T20.jasper"); InputStream subrep43 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T21/T21.jasper"); InputStream subrep44 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T22/T22.jasper"); InputStream subrep45 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T23/T23.jasper"); InputStream subrep46 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T24/T24.jasper"); InputStream subrep47 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T25/T25.jasper"); InputStream subrep48 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T26/T26.jasper"); InputStream subrep49 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T27/T27.jasper"); InputStream subrep50 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T28/T28.jasper"); InputStream subrep51 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T29/T29.jasper"); InputStream subrep52 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T30/T30.jasper"); InputStream subrep53 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T31/T31.jasper"); InputStream subrep54 =
	 * this.getClass().getResourceAsStream(
	 * "/static/jasper/BOB_RBS_AML_CONS/T32/T32.jasper");
	 * 
	 * map.put("INST", subrep02); map.put("INDEX",subrep01);
	 * map.put("CONTACT",subrep03); map.put("T1P", subrep1); map.put("T1C",
	 * subrep2); map.put("T2P", subrep3); map.put("T2C", subrep4); map.put("T3P",
	 * subrep5); map.put("T3C", subrep6); map.put("T4AP", subrep7); map.put("T4AC",
	 * subrep8); map.put("T4BP", subrep9); map.put("T4BC", subrep10); map.put("T5A",
	 * subrep11); map.put("T5B", subrep12); map.put("T6", subrep13); map.put("T7",
	 * subrep14); map.put("T8A", subrep15); map.put("T8B", subrep16); map.put("T9",
	 * subrep17); map.put("T10", subrep18); map.put("T11", subrep19);
	 * map.put("T12A", subrep20); map.put("T12B", subrep21); map.put("T12C",
	 * subrep22); map.put("T12D", subrep23); map.put("T12E", subrep24);
	 * map.put("T12F", subrep25); map.put("T12G", subrep26); map.put("T12H",
	 * subrep27); map.put("T13A", subrep28); map.put("T13B", subrep29);
	 * map.put("T14A", subrep30); map.put("T14B", subrep31); map.put("T15A",
	 * subrep32); map.put("T15B", subrep33); map.put("T16A", subrep34);
	 * map.put("T16B", subrep35); map.put("T16C", subrep36); map.put("T16D",
	 * subrep37); map.put("T16E", subrep38); map.put("T17", subrep39);
	 * map.put("T18", subrep40); map.put("T19", subrep41); map.put("T20", subrep42);
	 * map.put("T21", subrep43); map.put("T22", subrep44); map.put("T23", subrep45);
	 * map.put("T24", subrep46); map.put("T25", subrep47); map.put("T26", subrep48);
	 * map.put("T27", subrep49); map.put("T28", subrep50); map.put("T29", subrep51);
	 * map.put("T30", subrep52); map.put("T31", subrep53); map.put("T32", subrep54);
	 * try { master = dateFormat.parse(todate); NAME = dateFormat1.format(master);
	 * fileName = "T" + reportId + "_" + NAME; map.put("REPORT_DATE", NAME); } catch
	 * (ParseException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); }
	 * 
	 * logger.info("GET GENERATION ASSIGNING PARAMETER"); JasperReport jr =
	 * (JasperReport) JRLoader.loadObject(jasperFile); fileName = fileName +
	 * ".xlsx"; path += fileName; logger.info("PATH :" +path); JasperPrint jp =
	 * JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
	 * JRXlsxExporter exporter = new JRXlsxExporter(); exporter.setExporterInput(new
	 * SimpleExporterInput(jp)); exporter.setExporterOutput(new
	 * SimpleOutputStreamExporterOutput(path)); exporter.exportReport();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * outputFile = new File(path);
	 * 
	 * return outputFile;
	 * 
	 * }
	 */

	public ModelAndView ARCHgetBRF54currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF54_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF54_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF54_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF54_ARCHIV_ENTITY> T1Master = new ArrayList<BRF54_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF54_ARCHIV_ENTITY a where a.report_date = ?1", BRF54_ARCHIV_ENTITY.class)
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
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			String nre_flg = (String) a[49];

			String Remarks1;
			if (act_balance_amt_lc != null) {
				if (act_balance_amt_lc.toString().contains("-")) {
					remarks = "DR";
				} else {
					remarks = "CR";
				}
			} else {
				remarks = "";
			}

			BRF54_ARCHIV_ENTITY py = new BRF54_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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
		mv.setViewName("RR" + "/" + "BRF54ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public ModelAndView getArchieveBRF54View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF54_ENTITY> T1rep = new ArrayList<BRF54_ENTITY>();
		// Query<Object[]> qr;
		List<BRF54_ENTITY> T1Master = new ArrayList<BRF54_ENTITY>();
		List<BRF54_ENTITY> T1Master1 = new ArrayList<BRF54_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF54_ENTITY a where a.report_date = ?1 ", BRF54_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from  BRF54_ENTITY a where a.report_date = ?1 ", BRF54_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF54ARCH");
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

	public String detailChanges54(BRF54_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF54_DETAIL_ENTITY> Brf54detail = brf54detailrep.findById(foracid);

			if (Brf54detail.isPresent()) {
				BRF54_DETAIL_ENTITY BRFdetail = Brf54detail.get();

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
					brf54detailrep.save(BRFdetail);

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
