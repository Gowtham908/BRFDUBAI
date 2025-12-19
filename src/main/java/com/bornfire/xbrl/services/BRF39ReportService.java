package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
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
import org.apache.poi.ss.usermodel.FormulaEvaluator;
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
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.BRBS.BRF39_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF39_ENTITYREP;
import com.bornfire.xbrl.entities.BRBS.BRF39_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF39_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF39_DetaiRep;
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
public class BRF39ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF39ReportService.class);
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF39_DetaiRep BRF39_DetaiRep;

	@Autowired
	BRF39_ENTITYREP BRF39_ENTITYREP;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF39_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF39_ENTITY a ").getSingleResult();
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

	public ModelAndView getBRF039View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF39_ENTITY> T1rep = new ArrayList<BRF39_ENTITY>();
		// Query<Object[]> qr;

		List<BRF39_ENTITY> T1Master = new ArrayList<BRF39_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			List<Object[]> T1Master1 = BRF39_ENTITYREP.findllvalues(todate);

			for (Object[] BRF39_ENTITY : T1Master1) {

				BRF39_ENTITY BRF39 = new BRF39_ENTITY();
				System.out.println(BRF39_ENTITY[0]);

				/*
				 * BigDecimal capital_case = BRF39_ENTITY[0] != null ? (BigDecimal)
				 * BRF39_ENTITY[0] : new BigDecimal("0"); BRF39.setCapital_case(capital_case);
				 */

				BRF39.setName_of_borrower(
						String.valueOf(BRF39_ENTITY[1]) != null ? String.valueOf(BRF39_ENTITY[1]) : "");
				BRF39.setCin(String.valueOf(BRF39_ENTITY[2]) != null ? String.valueOf(BRF39_ENTITY[2]) : "");
				BRF39.setBorrower_type(String.valueOf(BRF39_ENTITY[3]) != null ? String.valueOf(BRF39_ENTITY[3]) : "");
				BRF39.setGroup_name(String.valueOf(BRF39_ENTITY[4]) != null ? String.valueOf(BRF39_ENTITY[4]) : "");
				BRF39.setResidency_status(
						String.valueOf(BRF39_ENTITY[5]) != null ? String.valueOf(BRF39_ENTITY[5]) : "");
				BRF39.setCountry_incorporated(
						String.valueOf(BRF39_ENTITY[6]) != null ? String.valueOf(BRF39_ENTITY[6]) : "");
				BRF39.setCredit_rating(String.valueOf(BRF39_ENTITY[7]) != null ? String.valueOf(BRF39_ENTITY[7]) : "");
				BRF39.setCredit_rating_type(
						String.valueOf(BRF39_ENTITY[8]) != null ? String.valueOf(BRF39_ENTITY[8]) : "");
				BRF39.setEconomic_status(
						String.valueOf(BRF39_ENTITY[9]) != null ? String.valueOf(BRF39_ENTITY[9]) : "");
				BRF39.setCurrency(String.valueOf(BRF39_ENTITY[10]) != null ? String.valueOf(BRF39_ENTITY[10]) : "");

				BigDecimal funded_os = BRF39_ENTITY[11] != null ? (BigDecimal) BRF39_ENTITY[11] : new BigDecimal("0");
				BRF39.setFunded_os(funded_os);

				BigDecimal credit_risk = BRF39_ENTITY[12] != null ? (BigDecimal) BRF39_ENTITY[12] : new BigDecimal("0");
				BRF39.setCredit_risk(credit_risk);

				BigDecimal debt_securities = BRF39_ENTITY[13] != null ? (BigDecimal) BRF39_ENTITY[13]
						: new BigDecimal("0");
				BRF39.setDebt_securities(debt_securities);

				BigDecimal equities = BRF39_ENTITY[14] != null ? (BigDecimal) BRF39_ENTITY[14] : new BigDecimal("0");
				BRF39.setEquities(equities);

				BigDecimal unfunded_os = BRF39_ENTITY[15] != null ? (BigDecimal) BRF39_ENTITY[15] : new BigDecimal("0");
				BRF39.setUnfunded_os(unfunded_os);

				BigDecimal ccf_equivalent_of_unfunded_os = BRF39_ENTITY[16] != null ? (BigDecimal) BRF39_ENTITY[16]
						: new BigDecimal("0");
				BRF39.setCcf_equivalent_of_unfunded_os(ccf_equivalent_of_unfunded_os);

				BigDecimal ccf_equivalent_limits = BRF39_ENTITY[17] != null ? (BigDecimal) BRF39_ENTITY[17]
						: new BigDecimal("0");
				BRF39.setCcf_equivalent_limits(ccf_equivalent_limits);

				BigDecimal total_exposure_without_credit_risk = BRF39_ENTITY[18] != null ? (BigDecimal) BRF39_ENTITY[18]
						: new BigDecimal("0");
				BRF39.setTotal_exposure_without_credit_risk(total_exposure_without_credit_risk);

				BigDecimal total_exposure_net = BRF39_ENTITY[19] != null ? (BigDecimal) BRF39_ENTITY[19]
						: new BigDecimal("0");
				BRF39.setTotal_exposure_net(total_exposure_net);

				BigDecimal tier_1_capital_without_credit_risk = BRF39_ENTITY[20] != null ? (BigDecimal) BRF39_ENTITY[20]
						: new BigDecimal("0");
				BRF39.setTier_1_capital_without_credit_risk(tier_1_capital_without_credit_risk);

				BigDecimal tier_1_capital_without_net = BRF39_ENTITY[21] != null ? (BigDecimal) BRF39_ENTITY[21]
						: new BigDecimal("0");
				BRF39.setTier_1_capital_without_net(tier_1_capital_without_net);

				T1Master.add(BRF39);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF39");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("getcapitalcase", BRF39_ENTITYREP.getcapitalcase(todate));
		mv.addObject("getfunded_os", BRF39_ENTITYREP.getFunded_os(todate));
		mv.addObject("getcredit_risk", BRF39_ENTITYREP.getCredit_risk(todate));
		mv.addObject("getdebt_securities", BRF39_ENTITYREP.getDebt_securities(todate));
		mv.addObject("getequities", BRF39_ENTITYREP.getEquities(todate));
		mv.addObject("getunfunded_os", BRF39_ENTITYREP.getUnfunded_os(todate));
		mv.addObject("getccf_equivalent_of_unfunded_os", BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate));
		mv.addObject("getccf_equivalent_limits", BRF39_ENTITYREP.getCcf_equivalent_limits(todate));

		mv.addObject("gettotalexposurewithout_creditrisk", BRF39_ENTITYREP.gettotalexposurewithout_creditrisk(todate));
		mv.addObject("gettotal_exposure_net", BRF39_ENTITYREP.gettotal_exposure_net(todate));

		/*
		 * mv.addObject("getResult", BRF39_ENTITYREP.getResult(todate));
		 * mv.addObject("getResult1", BRF39_ENTITYREP.getResult1(todate));
		 */
		// Fetch values and convert to BigDecimal
		BigDecimal funded_os = BRF39_ENTITYREP.getFunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getFunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal debt_securities = BRF39_ENTITYREP.getDebt_securities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getDebt_securities(todate))
				: BigDecimal.ZERO;
		BigDecimal equities = BRF39_ENTITYREP.getEquities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getEquities(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_of_unfunded_os = BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_limits = BRF39_ENTITYREP.getCcf_equivalent_limits(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_limits(todate))
				: BigDecimal.ZERO;

		// Adding individual values to the model
		mv.addObject("getfunded_os", funded_os);
		mv.addObject("getdebt_securities", debt_securities);
		mv.addObject("getequities", equities);
		mv.addObject("getccf_equivalent_of_unfunded_os", ccf_equivalent_of_unfunded_os);
		mv.addObject("getccf_equivalent_limits", ccf_equivalent_limits);

		// Summing up the values
		BigDecimal totalexpo = funded_os.add(debt_securities).add(equities).add(ccf_equivalent_of_unfunded_os)
				.add(ccf_equivalent_limits);
		mv.addObject("totalexpo", totalexpo);

		// Fetch values and convert to BigDecimal for the second set
		BigDecimal funded_os2 = BRF39_ENTITYREP.getFunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getFunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal credit_risk2 = BRF39_ENTITYREP.getCredit_risk(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCredit_risk(todate))
				: BigDecimal.ZERO;
		BigDecimal debt_securities2 = BRF39_ENTITYREP.getDebt_securities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getDebt_securities(todate))
				: BigDecimal.ZERO;
		BigDecimal equities2 = BRF39_ENTITYREP.getEquities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getEquities(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_of_unfunded_os2 = BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_limits2 = BRF39_ENTITYREP.getCcf_equivalent_limits(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_limits(todate))
				: BigDecimal.ZERO;

		// Adding individual values to the model for the second set
		mv.addObject("getfunded_os2", funded_os2);
		mv.addObject("credit_risk2", credit_risk2);
		mv.addObject("getdebt_securities2", debt_securities2);
		mv.addObject("getequities2", equities2);
		mv.addObject("getccf_equivalent_of_unfunded_os2", ccf_equivalent_of_unfunded_os2);
		mv.addObject("getccf_equivalent_limits2", ccf_equivalent_limits2);

		// Summing up the values for the second set
		BigDecimal totalValue2 = funded_os2.subtract(credit_risk2).add(debt_securities2).add(equities2)
				.add(ccf_equivalent_of_unfunded_os2).add(ccf_equivalent_limits2);
		mv.addObject("totalValue2", totalValue2);

		/**
		 * mv.addObject("gettotal_exposure_without_credit_risk",
		 * BRF39_ENTITYREP.getTotal_exposure_without_credit_risk(todate));
		 * mv.addObject("gettotal_exposure_net",
		 * BRF39_ENTITYREP.getTotal_exposure_net(todate));
		 * mv.addObject("gettier_1_capital_without_credit_risk",
		 * BRF39_ENTITYREP.getTier_1_capital_without_credit_risk(todate));
		 * mv.addObject("gettier_1_capital_without_net",
		 * BRF39_ENTITYREP.getTier_1_capital_without_credit_risk(todate));
		 */

		// Fetching the value of getcapitalcase
		String getcapitalcase = BRF39_ENTITYREP.getcapitalcase(todate);

		// Adding totalexpo and getcapitalcase to the ModelAndView
		mv.addObject("totalexpo", totalexpo);
		mv.addObject("getcapitalcase", getcapitalcase);

		BigDecimal expressionResult;
		if (getcapitalcase.equals(BigDecimal.ZERO)) {
			expressionResult = BigDecimal.ZERO;
		} else {
			expressionResult = totalexpo.divide(new BigDecimal(getcapitalcase), MathContext.DECIMAL128);
		}

		// Adding expressionResult to the ModelAndView
		mv.addObject("expressionResult", expressionResult);

		BigDecimal expressionResult1;
		if (getcapitalcase.equals(BigDecimal.ZERO)) {
			expressionResult1 = BigDecimal.ZERO;
		} else {
			expressionResult1 = totalValue2.divide(new BigDecimal(getcapitalcase), MathContext.DECIMAL128);
		}
//.multiply(BigDecimal.valueOf(100)
		// Adding expressionResult to the ModelAndView
		mv.addObject("expressionResult1", expressionResult1);

		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF039currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF39B_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF39B_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF39B_DETAILTABLE  where report_date = ?1");
		}
		List<BRF39_DETAIL_ENTITY> T1Master = new ArrayList<BRF39_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF39_DETAIL_ENTITY a where a.report_date = ?1", BRF39_DETAIL_ENTITY.class)
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
			BigDecimal funded_os = (BigDecimal) a[50];
			BigDecimal credit_risk = (BigDecimal) a[51];
			BigDecimal debt_securities = (BigDecimal) a[52];
			BigDecimal equities = (BigDecimal) a[53];
			BigDecimal unfunded_os = (BigDecimal) a[54];
			BigDecimal ccf_equivalent_of_unfunded_os = (BigDecimal) a[55];
			BigDecimal ccf_equivalent_limits = (BigDecimal) a[56];

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

			BRF39_DETAIL_ENTITY py = new BRF39_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg, funded_os, credit_risk, debt_securities, equities, unfunded_os,
					ccf_equivalent_of_unfunded_os, ccf_equivalent_limits);

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

		mv.setViewName("RR" + "/" + "BRF39::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	@SuppressWarnings("deprecation")
	public File getFileBRF039(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-039-A";
		if (!filetype.equals("xbrl")) {

			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF39_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF39_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF39.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF39.jrxml");
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

				/* file type "BRF" */

				try {

					List<Object[]> T1Master = BRF39_ENTITYREP.findllvalues(todate);

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-039-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

					/* Iteration Part */
					if (!T1Master.isEmpty()) {

						int startRow = 9; // Starting row index
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master.size(); index++) {

							Object[] brf039 = T1Master.get(index);

							Row row = sheet.getRow(startRow + index);

							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							// name_of_borrower
							Cell cell2 = row.getCell(2);
							if (cell2 == null) {
								cell2 = row.createCell(2);
							}

							cell2.setCellValue(brf039[1] == null ? "" : brf039[1].toString());

							// cin
							Cell cell3 = row.getCell(3);
							if (cell3 == null) {
								cell3 = row.createCell(3);
							}

							cell3.setCellValue(brf039[2] == null ? "" : brf039[2].toString());

							// borrower_type
							Cell cell4 = row.getCell(4);
							if (cell4 == null) {
								cell4 = row.createCell(4);
							}

							cell4.setCellValue(brf039[3] == null ? "" : brf039[3].toString());

							// group_name
							Cell cell5 = row.getCell(5);
							if (cell5 == null) {
								cell5 = row.createCell(5);
							}

							cell5.setCellValue(brf039[4] == null ? "" : brf039[4].toString());

							// residency_status
							Cell cell6 = row.getCell(6);
							if (cell6 == null) {
								cell6 = row.createCell(6);
							}

							cell6.setCellValue(brf039[5] == null ? "" : brf039[5].toString());

							// country_incorporated
							Cell cell7 = row.getCell(7);
							if (cell7 == null) {
								cell7 = row.createCell(7);
							}

							cell7.setCellValue(brf039[6] == null ? "" : brf039[6].toString());

							// credit_rating
							Cell cell8 = row.getCell(8);
							if (cell8 == null) {
								cell8 = row.createCell(8);
							}

							cell8.setCellValue(brf039[7] == null ? "" : brf039[7].toString());

							// credit_rating_type
							Cell cell9 = row.getCell(9);
							if (cell9 == null) {
								cell9 = row.createCell(9);
							}

							cell9.setCellValue(brf039[8] == null ? "" : brf039[8].toString());

							// economic_status
							Cell cell10 = row.getCell(10);
							if (cell10 == null) {
								cell10 = row.createCell(10);
							}

							cell10.setCellValue(brf039[9] == null ? "" : brf039[9].toString());

							// currency
							Cell cell11 = row.getCell(11);
							if (cell11 == null) {
								cell11 = row.createCell(11);
							}

							cell11.setCellValue(brf039[10] == null ? "" : brf039[10].toString());

							// funded_os
							Cell cell12 = row.getCell(12);
							if (cell12 == null) {
								cell12 = row.createCell(12);
							}
							cell12.setCellValue(brf039[11] == null ? 0 : ((BigDecimal) brf039[11]).intValue());

							// credit_risk
							Cell cell13 = row.getCell(13);
							if (cell13 == null) {
								cell13 = row.createCell(13);
							}
							cell13.setCellValue(brf039[12] == null ? 0 : ((BigDecimal) brf039[12]).intValue());

							// debt_securities
							Cell cell14 = row.getCell(14);
							if (cell14 == null) {
								cell14 = row.createCell(14);
							}
							cell14.setCellValue(brf039[13] == null ? 0 : ((BigDecimal) brf039[13]).intValue());

							// equities
							Cell cell15 = row.getCell(15);
							if (cell15 == null) {
								cell15 = row.createCell(15);
							}
							cell15.setCellValue(brf039[14] == null ? 0 : ((BigDecimal) brf039[14]).intValue());

							// unfunded_os
							Cell cell16 = row.getCell(16);
							if (cell16 == null) {
								cell16 = row.createCell(16);
							}
							cell16.setCellValue(brf039[15] == null ? 0 : ((BigDecimal) brf039[15]).intValue());

							// ccf_equivalent_of_unfunded_os
							Cell cell17 = row.getCell(17);
							if (cell17 == null) {
								cell17 = row.createCell(17);
							}
							cell17.setCellValue(brf039[16] == null ? 0 : ((BigDecimal) brf039[16]).intValue());

							// ccf_equivalent_limits
							Cell cell18 = row.getCell(18);
							if (cell18 == null) {
								cell18 = row.createCell(18);
							}
							cell18.setCellValue(brf039[17] == null ? 0 : ((BigDecimal) brf039[17]).intValue());

						}
					} else {
						System.out.println("No data found for the specified date.");
					}

					// workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					for (Row row : sheet) {
						for (Cell cell : row) {
							if (cell.getCellType() == cell.CELL_TYPE_FORMULA) {
								try {
									evaluator.evaluateFormulaCell(cell);
								} catch (Exception e) {
									System.err.println("Skipping formula evaluation for cell " + cell.getAddress()
											+ ": " + e.getMessage());
								}

							}
						}
					}

					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-039-A.xls");
					workbook.write(fileOut);
					fileOut.close();
					System.out.println(fileOut);
					path = fileOut.toString();
					// Close the workbook
					System.out.println("PATH : " + path);
					workbook.close();

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
		}

		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-039-A.xls");

		return outputFile;

	}

	public String detailChanges39(BRF39_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF39_DETAIL_ENTITY> Brf39detail = BRF39_DetaiRep.findById(foracid);

			if (Brf39detail.isPresent()) {
				BRF39_DETAIL_ENTITY BRFdetail = Brf39detail.get();

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
					BRF39_DetaiRep.save(BRFdetail);

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

// TO show thw Archieve values
	public ModelAndView getArchieveBRF039View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF39_ENTITY> T1rep = new ArrayList<BRF39_ENTITY>();
		// Query<Object[]> qr;

		List<BRF39_ENTITY> T1Master = new ArrayList<BRF39_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			List<Object[]> T1Master1 = BRF39_ENTITYREP.findllvalues(todate);

			for (Object[] BRF39_ENTITY : T1Master1) {

				BRF39_ENTITY BRF39 = new BRF39_ENTITY();
				System.out.println(BRF39_ENTITY[0]);

				/*
				 * BigDecimal capital_case = BRF39_ENTITY[0] != null ? (BigDecimal)
				 * BRF39_ENTITY[0] : new BigDecimal("0"); BRF39.setCapital_case(capital_case);
				 */

				BRF39.setName_of_borrower(
						String.valueOf(BRF39_ENTITY[1]) != null ? String.valueOf(BRF39_ENTITY[1]) : "");
				BRF39.setCin(String.valueOf(BRF39_ENTITY[2]) != null ? String.valueOf(BRF39_ENTITY[2]) : "");
				BRF39.setBorrower_type(String.valueOf(BRF39_ENTITY[3]) != null ? String.valueOf(BRF39_ENTITY[3]) : "");
				BRF39.setGroup_name(String.valueOf(BRF39_ENTITY[4]) != null ? String.valueOf(BRF39_ENTITY[4]) : "");
				BRF39.setResidency_status(
						String.valueOf(BRF39_ENTITY[5]) != null ? String.valueOf(BRF39_ENTITY[5]) : "");
				BRF39.setCountry_incorporated(
						String.valueOf(BRF39_ENTITY[6]) != null ? String.valueOf(BRF39_ENTITY[6]) : "");
				BRF39.setCredit_rating(String.valueOf(BRF39_ENTITY[7]) != null ? String.valueOf(BRF39_ENTITY[7]) : "");
				BRF39.setCredit_rating_type(
						String.valueOf(BRF39_ENTITY[8]) != null ? String.valueOf(BRF39_ENTITY[8]) : "");
				BRF39.setEconomic_status(
						String.valueOf(BRF39_ENTITY[9]) != null ? String.valueOf(BRF39_ENTITY[9]) : "");
				BRF39.setCurrency(String.valueOf(BRF39_ENTITY[10]) != null ? String.valueOf(BRF39_ENTITY[10]) : "");

				BigDecimal funded_os = BRF39_ENTITY[11] != null ? (BigDecimal) BRF39_ENTITY[11] : new BigDecimal("0");
				BRF39.setFunded_os(funded_os);

				BigDecimal credit_risk = BRF39_ENTITY[12] != null ? (BigDecimal) BRF39_ENTITY[12] : new BigDecimal("0");
				BRF39.setCredit_risk(credit_risk);

				BigDecimal debt_securities = BRF39_ENTITY[13] != null ? (BigDecimal) BRF39_ENTITY[13]
						: new BigDecimal("0");
				BRF39.setDebt_securities(debt_securities);

				BigDecimal equities = BRF39_ENTITY[14] != null ? (BigDecimal) BRF39_ENTITY[14] : new BigDecimal("0");
				BRF39.setEquities(equities);

				BigDecimal unfunded_os = BRF39_ENTITY[15] != null ? (BigDecimal) BRF39_ENTITY[15] : new BigDecimal("0");
				BRF39.setUnfunded_os(unfunded_os);

				BigDecimal ccf_equivalent_of_unfunded_os = BRF39_ENTITY[16] != null ? (BigDecimal) BRF39_ENTITY[16]
						: new BigDecimal("0");
				BRF39.setCcf_equivalent_of_unfunded_os(ccf_equivalent_of_unfunded_os);

				BigDecimal ccf_equivalent_limits = BRF39_ENTITY[17] != null ? (BigDecimal) BRF39_ENTITY[17]
						: new BigDecimal("0");
				BRF39.setCcf_equivalent_limits(ccf_equivalent_limits);

				BigDecimal total_exposure_without_credit_risk = BRF39_ENTITY[18] != null ? (BigDecimal) BRF39_ENTITY[18]
						: new BigDecimal("0");
				BRF39.setTotal_exposure_without_credit_risk(total_exposure_without_credit_risk);

				BigDecimal total_exposure_net = BRF39_ENTITY[19] != null ? (BigDecimal) BRF39_ENTITY[19]
						: new BigDecimal("0");
				BRF39.setTotal_exposure_net(total_exposure_net);

				BigDecimal tier_1_capital_without_credit_risk = BRF39_ENTITY[20] != null ? (BigDecimal) BRF39_ENTITY[20]
						: new BigDecimal("0");
				BRF39.setTier_1_capital_without_credit_risk(tier_1_capital_without_credit_risk);

				BigDecimal tier_1_capital_without_net = BRF39_ENTITY[21] != null ? (BigDecimal) BRF39_ENTITY[21]
						: new BigDecimal("0");
				BRF39.setTier_1_capital_without_net(tier_1_capital_without_net);

				T1Master.add(BRF39);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF39ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("getcapitalcase", BRF39_ENTITYREP.getcapitalcase(todate));
		mv.addObject("getfunded_os", BRF39_ENTITYREP.getFunded_os(todate));
		mv.addObject("getcredit_risk", BRF39_ENTITYREP.getCredit_risk(todate));
		mv.addObject("getdebt_securities", BRF39_ENTITYREP.getDebt_securities(todate));
		mv.addObject("getequities", BRF39_ENTITYREP.getEquities(todate));
		mv.addObject("getunfunded_os", BRF39_ENTITYREP.getUnfunded_os(todate));
		mv.addObject("getccf_equivalent_of_unfunded_os", BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate));
		mv.addObject("getccf_equivalent_limits", BRF39_ENTITYREP.getCcf_equivalent_limits(todate));

		mv.addObject("gettotalexposurewithout_creditrisk", BRF39_ENTITYREP.gettotalexposurewithout_creditrisk(todate));
		mv.addObject("gettotal_exposure_net", BRF39_ENTITYREP.gettotal_exposure_net(todate));

		/*
		 * mv.addObject("getResult", BRF39_ENTITYREP.getResult(todate));
		 * mv.addObject("getResult1", BRF39_ENTITYREP.getResult1(todate));
		 */
		// Fetch values and convert to BigDecimal
		BigDecimal funded_os = BRF39_ENTITYREP.getFunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getFunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal debt_securities = BRF39_ENTITYREP.getDebt_securities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getDebt_securities(todate))
				: BigDecimal.ZERO;
		BigDecimal equities = BRF39_ENTITYREP.getEquities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getEquities(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_of_unfunded_os = BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_limits = BRF39_ENTITYREP.getCcf_equivalent_limits(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_limits(todate))
				: BigDecimal.ZERO;

		// Adding individual values to the model
		mv.addObject("getfunded_os", funded_os);
		mv.addObject("getdebt_securities", debt_securities);
		mv.addObject("getequities", equities);
		mv.addObject("getccf_equivalent_of_unfunded_os", ccf_equivalent_of_unfunded_os);
		mv.addObject("getccf_equivalent_limits", ccf_equivalent_limits);

		// Summing up the values
		BigDecimal totalexpo = funded_os.add(debt_securities).add(equities).add(ccf_equivalent_of_unfunded_os)
				.add(ccf_equivalent_limits);
		mv.addObject("totalexpo", totalexpo);

		// Fetch values and convert to BigDecimal for the second set
		BigDecimal funded_os2 = BRF39_ENTITYREP.getFunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getFunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal credit_risk2 = BRF39_ENTITYREP.getCredit_risk(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCredit_risk(todate))
				: BigDecimal.ZERO;
		BigDecimal debt_securities2 = BRF39_ENTITYREP.getDebt_securities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getDebt_securities(todate))
				: BigDecimal.ZERO;
		BigDecimal equities2 = BRF39_ENTITYREP.getEquities(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getEquities(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_of_unfunded_os2 = BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_of_unfunded_os(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equivalent_limits2 = BRF39_ENTITYREP.getCcf_equivalent_limits(todate) != null
				? new BigDecimal(BRF39_ENTITYREP.getCcf_equivalent_limits(todate))
				: BigDecimal.ZERO;

		// Adding individual values to the model for the second set
		mv.addObject("getfunded_os2", funded_os2);
		mv.addObject("credit_risk2", credit_risk2);
		mv.addObject("getdebt_securities2", debt_securities2);
		mv.addObject("getequities2", equities2);
		mv.addObject("getccf_equivalent_of_unfunded_os2", ccf_equivalent_of_unfunded_os2);
		mv.addObject("getccf_equivalent_limits2", ccf_equivalent_limits2);

		// Summing up the values for the second set
		BigDecimal totalValue2 = funded_os2.subtract(credit_risk2).add(debt_securities2).add(equities2)
				.add(ccf_equivalent_of_unfunded_os2).add(ccf_equivalent_limits2);
		mv.addObject("totalValue2", totalValue2);

		/**
		 * mv.addObject("gettotal_exposure_without_credit_risk",
		 * BRF39_ENTITYREP.getTotal_exposure_without_credit_risk(todate));
		 * mv.addObject("gettotal_exposure_net",
		 * BRF39_ENTITYREP.getTotal_exposure_net(todate));
		 * mv.addObject("gettier_1_capital_without_credit_risk",
		 * BRF39_ENTITYREP.getTier_1_capital_without_credit_risk(todate));
		 * mv.addObject("gettier_1_capital_without_net",
		 * BRF39_ENTITYREP.getTier_1_capital_without_credit_risk(todate));
		 */

		// Fetching the value of getcapitalcase
		String getcapitalcase = BRF39_ENTITYREP.getcapitalcase(todate);

		// Adding totalexpo and getcapitalcase to the ModelAndView
		mv.addObject("totalexpo", totalexpo);
		mv.addObject("getcapitalcase", getcapitalcase);

		BigDecimal expressionResult;
		if (getcapitalcase.equals(BigDecimal.ZERO)) {
			expressionResult = BigDecimal.ZERO;
		} else {
			expressionResult = totalexpo.divide(new BigDecimal(getcapitalcase), MathContext.DECIMAL128);
		}

		// Adding expressionResult to the ModelAndView
		mv.addObject("expressionResult", expressionResult);

		BigDecimal expressionResult1;
		if (getcapitalcase.equals(BigDecimal.ZERO)) {
			expressionResult1 = BigDecimal.ZERO;
		} else {
			expressionResult1 = totalValue2.divide(new BigDecimal(getcapitalcase), MathContext.DECIMAL128);
		}

		// Adding expressionResult to the ModelAndView
		mv.addObject("expressionResult1", expressionResult1);

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

	public ModelAndView ARCHgetBRF039currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF39_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF39_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF39_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF39_ARCHIVENTITY> T1Master = new ArrayList<BRF39_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF39_ARCHIVENTITY a where a.report_date = ?1", BRF39_ARCHIVENTITY.class)
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
			BigDecimal funded_os = (BigDecimal) a[50];
			BigDecimal credit_risk = (BigDecimal) a[51];
			BigDecimal debt_securities = (BigDecimal) a[52];
			BigDecimal equities = (BigDecimal) a[53];
			BigDecimal unfunded_os = (BigDecimal) a[54];
			BigDecimal ccf_equivalent_of_unfunded_os = (BigDecimal) a[55];
			BigDecimal ccf_equivalent_limits = (BigDecimal) a[56];

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

			BRF39_ARCHIVENTITY py = new BRF39_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg, funded_os, credit_risk, debt_securities, equities, unfunded_os,
					ccf_equivalent_of_unfunded_os, ccf_equivalent_limits);

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

		mv.setViewName("RR" + "/" + "BRF39ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
}
