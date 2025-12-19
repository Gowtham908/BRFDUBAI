
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

import com.bornfire.xbrl.entities.BRF96_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF093AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF094AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF206A_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF32reportentity;
import com.bornfire.xbrl.entities.BRBS.BRF73ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF96_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF96_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF96_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF96AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;

import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_96_REPORT_ENTITY;
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
public class BRF96AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF96AReportService.class);

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
	BRF96_DetailRepo brf96_detailrepo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF96A(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF_96_REPORT_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF_96_REPORT_ENTITY a ").getSingleResult();
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

	public ModelAndView getBRF96AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_96_REPORT_ENTITY> T1rep = new ArrayList<BRF_96_REPORT_ENTITY>();
		// Query<Object[]> qr;

		List<BRF_96_REPORT_ENTITY> T1Master = new ArrayList<BRF_96_REPORT_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs
					.createQuery("from BRF_96_REPORT_ENTITY a where a.report_date = ?1 ", BRF_96_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF96");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF96ADetails(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF96_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF96_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF96_DETAILTABLE  where report_date = ?1");
		}
		List<BRF96_DETAIL_ENTITY> T1Master = new ArrayList<BRF96_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF96_DETAIL_ENTITY a where a.report_date = ?1", BRF96_DETAIL_ENTITY.class)
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

			BRF96_DETAIL_ENTITY py = new BRF96_DETAIL_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF96::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF96A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-096-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF96_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF96_Detail.jrxml");
						}
					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF96.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF96.jrxml");
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
			}

			else {

				/* file type "BRF" */

				List<BRF_96_REPORT_ENTITY> updateSheetRow1To66 = new ArrayList<BRF_96_REPORT_ENTITY>();

				Session hs = sessionFactory.getCurrentSession();

				try {
					Date d1 = df.parse(todate);

					updateSheetRow1To66 = hs.createQuery("from BRF_96_REPORT_ENTITY a where a.report_date = ?1",
							BRF_96_REPORT_ENTITY.class).setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-096-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					if (updateSheetRow1To66.size() == 1) {
						for (BRF_96_REPORT_ENTITY brf206Row1TO471 : updateSheetRow1To66) {

							updateSheetRow1To67(sheet, brf206Row1TO471);

						}
					}

					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-096-A.xls");
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

			}
		} //// else end

		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-096-A.xls");

		return outputFile;

	}

	public String detailChanges96(BRF96_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF96_DETAIL_ENTITY> Brf96detail = brf96_detailrepo.findById(foracid);

			if (Brf96detail.isPresent()) {
				BRF96_DETAIL_ENTITY BRFdetail = Brf96detail.get();

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
					brf96_detailrepo.save(BRFdetail);

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

	/****
	 * ARCH SUMMARY
	 * 
	 * @throws ParseException
	 ****/

	public ModelAndView getArchieveBRF096View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF_96_REPORT_ENTITY> T1rep = new ArrayList<BRF_96_REPORT_ENTITY>();
// Query<Object[]> qr;

		List<BRF_96_REPORT_ENTITY> T1Master = new ArrayList<BRF_96_REPORT_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs
					.createQuery("from  BRF_96_REPORT_ENTITY a where a.report_date = ?1 ", BRF_96_REPORT_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF96ARCH");
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

	public ModelAndView ARCHgetBRF096currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF96_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF96_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF96_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF96_ARCHIV_ENTITY> T1Master = new ArrayList<BRF96_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF96_ARCHIV_ENTITY a where a.report_date = ?1", BRF96_ARCHIV_ENTITY.class)
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

			BRF96_ARCHIV_ENTITY py = new BRF96_ARCHIV_ENTITY(cust_id, foracid, acct_name, eab_lc, act_balance_amt_lc,
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

		mv.setViewName("RR" + "/" + "BRF96ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public void updateSheetRow1To67(Sheet sheet, BRF_96_REPORT_ENTITY brf96ARow1TO471) {

		Row row7 = sheet.getRow(7);
		Cell row7cell3 = row7.getCell(3);

		if (row7cell3 != null) {
			row7cell3
					.setCellValue(brf96ARow1TO471.getR1_Total() == null ? 0 : brf96ARow1TO471.getR1_Total().intValue());
		}

		Row row8 = sheet.getRow(8);
		Cell row8cell3 = row8.getCell(3);

		if (row8cell3 != null) {
			row8cell3
					.setCellValue(brf96ARow1TO471.getR2_Total() == null ? 0 : brf96ARow1TO471.getR2_Total().intValue());
		}

		Row row11 = sheet.getRow(11);
		Cell row11cell3 = row11.getCell(3);

		if (row11cell3 != null) {
			row11cell3
					.setCellValue(brf96ARow1TO471.getR4_Total() == null ? 0 : brf96ARow1TO471.getR4_Total().intValue());
		}

		Row row12 = sheet.getRow(12);
		Cell row12cell3 = row12.getCell(3);

		if (row12cell3 != null) {
			row12cell3
					.setCellValue(brf96ARow1TO471.getR5_Total() == null ? 0 : brf96ARow1TO471.getR5_Total().intValue());
		}

		Row row14 = sheet.getRow(14);
		Cell row14cell3 = row14.getCell(3);

		if (row14cell3 != null) {
			row14cell3
					.setCellValue(brf96ARow1TO471.getR7_Total() == null ? 0 : brf96ARow1TO471.getR7_Total().intValue());
		}

		Row row15 = sheet.getRow(15);
		Cell row15cell3 = row15.getCell(3);

		if (row15cell3 != null) {
			row15cell3
					.setCellValue(brf96ARow1TO471.getR8_Total() == null ? 0 : brf96ARow1TO471.getR8_Total().intValue());
		}

		Row row16 = sheet.getRow(16);
		Cell row16cell3 = row16.getCell(3);

		if (row16cell3 != null) {
			row16cell3
					.setCellValue(brf96ARow1TO471.getR9_Total() == null ? 0 : brf96ARow1TO471.getR9_Total().intValue());
		}

		Row row17 = sheet.getRow(17);
		Cell row17cell3 = row17.getCell(3);

		if (row17cell3 != null) {
			row17cell3.setCellValue(
					brf96ARow1TO471.getR10_Total() == null ? 0 : brf96ARow1TO471.getR10_Total().intValue());
		}

		Row row18 = sheet.getRow(18);
		Cell row18cell3 = row18.getCell(3);

		if (row18cell3 != null) {
			row18cell3.setCellValue(
					brf96ARow1TO471.getR11_Total() == null ? 0 : brf96ARow1TO471.getR11_Total().intValue());
		}

		Row row21 = sheet.getRow(21);
		Cell row21cell3 = row21.getCell(3);

		if (row21cell3 != null) {
			row21cell3.setCellValue(
					brf96ARow1TO471.getR13_Total() == null ? 0 : brf96ARow1TO471.getR13_Total().intValue());
		}

		Row row22 = sheet.getRow(22);
		Cell row22cell3 = row22.getCell(3);

		if (row22cell3 != null) {
			row22cell3.setCellValue(
					brf96ARow1TO471.getR14_Total() == null ? 0 : brf96ARow1TO471.getR14_Total().intValue());
		}

		Row row23 = sheet.getRow(23);
		Cell row23cell3 = row23.getCell(3);

		if (row23cell3 != null) {
			row23cell3.setCellValue(
					brf96ARow1TO471.getR15_Total() == null ? 0 : brf96ARow1TO471.getR15_Total().intValue());
		}

		Row row24 = sheet.getRow(24);
		Cell row24cell3 = row24.getCell(3);

		if (row24cell3 != null) {
			row24cell3.setCellValue(
					brf96ARow1TO471.getR16_Total() == null ? 0 : brf96ARow1TO471.getR16_Total().intValue());
		}

		Row row27 = sheet.getRow(27);
		Cell row27cell3 = row27.getCell(3);

		if (row27cell3 != null) {
			row27cell3.setCellValue(
					brf96ARow1TO471.getR18_Total() == null ? 0 : brf96ARow1TO471.getR18_Total().intValue());
		}

		Row row28 = sheet.getRow(28);
		Cell row28cell3 = row28.getCell(3);

		if (row28cell3 != null) {
			row28cell3.setCellValue(
					brf96ARow1TO471.getR19_Total() == null ? 0 : brf96ARow1TO471.getR19_Total().intValue());
		}

		Row row31 = sheet.getRow(31);
		Cell row31cell3 = row31.getCell(3);

		if (row31cell3 != null) {
			row31cell3.setCellValue(
					brf96ARow1TO471.getR21_Total() == null ? 0 : brf96ARow1TO471.getR21_Total().intValue());
		}

		Row row38 = sheet.getRow(38);
		Cell row38cell3 = row38.getCell(3);

		if (row38cell3 != null) {
			row38cell3.setCellValue(brf96ARow1TO471.getR24_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR24_Exposure_Before_CCF().intValue());
		}

		Row row39 = sheet.getRow(39);
		Cell row39cell3 = row39.getCell(3);

		if (row39cell3 != null) {
			row39cell3.setCellValue(brf96ARow1TO471.getR25_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR25_Exposure_Before_CCF().intValue());
		}

		Row row40 = sheet.getRow(40);
		Cell row40cell3 = row40.getCell(3);

		if (row40cell3 != null) {
			row40cell3.setCellValue(brf96ARow1TO471.getR26_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR26_Exposure_Before_CCF().intValue());
		}

		Row row41 = sheet.getRow(41);
		Cell row41cell3 = row41.getCell(3);

		if (row41cell3 != null) {
			row41cell3.setCellValue(brf96ARow1TO471.getR27_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR27_Exposure_Before_CCF().intValue());
		}

		Row row43 = sheet.getRow(43);
		Cell row43cell3 = row43.getCell(3);

		if (row43cell3 != null) {
			row43cell3.setCellValue(brf96ARow1TO471.getR29_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR29_Exposure_Before_CCF().intValue());
		}

		Row row44 = sheet.getRow(44);
		Cell row44cell3 = row44.getCell(3);

		if (row44cell3 != null) {
			row44cell3.setCellValue(brf96ARow1TO471.getR30_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR30_Exposure_Before_CCF().intValue());
		}

		Row row46 = sheet.getRow(46);
		Cell row46cell3 = row46.getCell(3);

		if (row46cell3 != null) {
			row46cell3.setCellValue(brf96ARow1TO471.getR32_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR32_Exposure_Before_CCF().intValue());
		}

		Row row49 = sheet.getRow(49);
		Cell row49cell3 = row49.getCell(3);

		if (row49cell3 != null) {
			row49cell3.setCellValue(brf96ARow1TO471.getR34_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR34_Exposure_Before_CCF().intValue());
		}

		Row row51 = sheet.getRow(51);
		Cell row51cell3 = row51.getCell(3);

		if (row51cell3 != null) {
			row51cell3.setCellValue(brf96ARow1TO471.getR36_Exposure_Before_CCF() == null ? 0
					: brf96ARow1TO471.getR36_Exposure_Before_CCF().intValue());
		}

		Row row57 = sheet.getRow(57);
		Cell row57cell3 = row57.getCell(3);

		if (row57cell3 != null) {
			row57cell3.setCellValue(
					brf96ARow1TO471.getR39_AED_000s() == null ? 0 : brf96ARow1TO471.getR39_AED_000s().intValue());
		}

		Row row58 = sheet.getRow(58);
		Cell row58cell3 = row58.getCell(3);

		if (row58cell3 != null) {
			row58cell3.setCellValue(
					brf96ARow1TO471.getR40_AED_000s() == null ? 0 : brf96ARow1TO471.getR40_AED_000s().intValue());
		}

		Row row59 = sheet.getRow(59);
		Cell row59cell3 = row59.getCell(3);

		if (row59cell3 != null) {
			row59cell3.setCellValue(
					brf96ARow1TO471.getR41_AED_000s() == null ? 0 : brf96ARow1TO471.getR41_AED_000s().intValue());
		}

		Row row60 = sheet.getRow(60);
		Cell row60cell3 = row60.getCell(3);

		if (row60cell3 != null) {
			row60cell3.setCellValue(
					brf96ARow1TO471.getR42_AED_000s() == null ? 0 : brf96ARow1TO471.getR42_AED_000s().intValue());
		}

		Row row61 = sheet.getRow(61);
		Cell row61cell3 = row61.getCell(3);

		if (row61cell3 != null) {
			row61cell3.setCellValue(
					brf96ARow1TO471.getR43_AED_000s() == null ? 0 : brf96ARow1TO471.getR43_AED_000s().intValue());
		}

		Row row62 = sheet.getRow(62);
		Cell row62cell3 = row62.getCell(3);

		if (row62cell3 != null) {
			row62cell3.setCellValue(
					brf96ARow1TO471.getR44_AED_000s() == null ? 0 : brf96ARow1TO471.getR44_AED_000s().intValue());
		}

		Row row63 = sheet.getRow(63);
		Cell row63cell3 = row63.getCell(3);

		if (row63cell3 != null) {
			row63cell3.setCellValue(
					brf96ARow1TO471.getR45_AED_000s() == null ? 0 : brf96ARow1TO471.getR45_AED_000s().intValue());
		}

	}

}
