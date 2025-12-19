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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.BRF80_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF80_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF80_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF80_Detailrepo;

import com.bornfire.xbrl.entities.BRBS.BRF80_ENTITY_REP;
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
public class BRF80ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF80ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF80_Detailrepo brf80_detailrepo;
	@Autowired
	BRF80_ENTITY_REP BRF80_ENTITYREP;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF80_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF80_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF80View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF80_ENTITY> T1Master = new ArrayList<BRF80_ENTITY>();
		List<BRF80_ENTITY> T1rep = new ArrayList<BRF80_ENTITY>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			/*
			 * T1Master = hs.createQuery("from  BRF80_ENTITY a where a.report_date = ?1 ",
			 * BRF80_ENTITY .class) .setParameter(1, df.parse(todate)).getResultList();
			 */

			List<Object[]> T1Master1 = BRF80_ENTITYREP.findllvalues(todate);

			for (Object[] BRF80_ENTITY : T1Master1) {
				BigDecimal TOTALEXPOSURE = BigDecimal.ZERO;
				BRF80_ENTITY BRF80 = new BRF80_ENTITY();
				System.out.println(BRF80_ENTITY[0]);
				BRF80.setSelf_sustainable(String.valueOf(BRF80_ENTITY[0]));

				System.out.println(BRF80_ENTITY[1]);
				BRF80.setEmirates(String.valueOf(BRF80_ENTITY[1]));

				System.out.println(BRF80_ENTITY[2]);
				BRF80.setCin_figi_gleiid(String.valueOf(BRF80_ENTITY[2]));

				System.out.println(BRF80_ENTITY[3]);
				BRF80.setSpecify_as_f(String.valueOf(BRF80_ENTITY[3]));

				System.out.println(BRF80_ENTITY[4]);
				BRF80.setBorrower_type(String.valueOf(BRF80_ENTITY[4]));

				System.out.println(BRF80_ENTITY[5]);
				BRF80.setGroup_name(String.valueOf(BRF80_ENTITY[5]));

				System.out.println(BRF80_ENTITY[6]);
				BRF80.setCredit_rating(String.valueOf(BRF80_ENTITY[6]));

				System.out.println(BRF80_ENTITY[7]);
				BRF80.setCredit_rating_type(String.valueOf(BRF80_ENTITY[7]));

				System.out.println(BRF80_ENTITY[8]);
				BRF80.setEconomic_sector(String.valueOf(BRF80_ENTITY[8]));

				System.out.println(BRF80_ENTITY[9]);
				BRF80.setCurrency(String.valueOf(BRF80_ENTITY[9]));

				BigDecimal fundos = BRF80_ENTITY[10] != null ? (BigDecimal) BRF80_ENTITY[10] : new BigDecimal("0");
				BRF80.setFunded_os(fundos);

				BigDecimal debit_securities = BRF80_ENTITY[11] != null ? (BigDecimal) BRF80_ENTITY[11]
						: new BigDecimal("0");
				BRF80.setDebit_securities(debit_securities);

				BigDecimal equities = BRF80_ENTITY[12] != null ? (BigDecimal) BRF80_ENTITY[12] : new BigDecimal("0");
				BRF80.setEquities(equities);

				BigDecimal unfunded_os = BRF80_ENTITY[13] != null ? (BigDecimal) BRF80_ENTITY[13] : new BigDecimal("0");
				BRF80.setUnfunded_os(unfunded_os);

				BigDecimal ccf_equi_unfuned_os = BRF80_ENTITY[14] != null ? (BigDecimal) BRF80_ENTITY[14]
						: new BigDecimal("0");
				BRF80.setCcf_equi_unfuned_os(ccf_equi_unfuned_os);

				BigDecimal ccf_equi_funded_n_unfuned_limits = BRF80_ENTITY[15] != null ? (BigDecimal) BRF80_ENTITY[15]
						: new BigDecimal("0");
				BRF80.setCcf_equi_funded_n_unfuned_limits(ccf_equi_funded_n_unfuned_limits);

				BigDecimal total_exposer = BRF80_ENTITY[16] != null ? (BigDecimal) BRF80_ENTITY[16]
						: new BigDecimal("0");
				BRF80.setTotal_exposer(total_exposer);

				BigDecimal as_of_tier1_capital = BRF80_ENTITY[17] != null ? (BigDecimal) BRF80_ENTITY[17]
						: new BigDecimal("0");
				BRF80.setAs_of_tier1_capital(as_of_tier1_capital);

				BigDecimal credit_risk_miti_type = BRF80_ENTITY[18] != null ? (BigDecimal) BRF80_ENTITY[18]
						: new BigDecimal("0");
				BRF80.setCredit_risk_miti_type(credit_risk_miti_type);

				BigDecimal credit_risk_miti_hair_cut = BRF80_ENTITY[19] != null ? (BigDecimal) BRF80_ENTITY[19]
						: new BigDecimal("0");
				BRF80.setCredit_risk_miti_hair_cut(credit_risk_miti_hair_cut);

				BigDecimal collateral_hair_cut = BRF80_ENTITY[20] != null ? (BigDecimal) BRF80_ENTITY[20]
						: new BigDecimal("0");
				BRF80.setCollateral_hair_cut(collateral_hair_cut);

				BRF80.setCbuae_class(String.valueOf(BRF80_ENTITY[21]));

				BigDecimal provision = BRF80_ENTITY[22] != null ? (BigDecimal) BRF80_ENTITY[22] : new BigDecimal("0");
				BRF80.setProvision(provision);

				BRF80.setRemarks(String.valueOf(BRF80_ENTITY[23]));

				BigDecimal tier_1_capital = BRF80_ENTITY[24] != null ? (BigDecimal) BRF80_ENTITY[24]
						: new BigDecimal("0");
				BRF80.setTier_1_capital(tier_1_capital);

				BRF80.setRow_label(String.valueOf(BRF80_ENTITY[25]));
				// Retrieve Tier 1 capital (assuming you have it stored in BRF80_ENTITY[16] or
				// another index)
				BigDecimal TIER1CAPITAL = (BigDecimal) BRF80_ENTITY[24] != null ? (BigDecimal) BRF80_ENTITY[24]
						: BigDecimal.ZERO;

				BigDecimal FUN = (BigDecimal) BRF80_ENTITY[10] != null ? (BigDecimal) BRF80_ENTITY[10]
						: BigDecimal.ZERO;
				BigDecimal DEBT = (BigDecimal) BRF80_ENTITY[11] != null ? (BigDecimal) BRF80_ENTITY[11]
						: BigDecimal.ZERO;
				BigDecimal equity = (BigDecimal) BRF80_ENTITY[12] != null ? (BigDecimal) BRF80_ENTITY[12]
						: BigDecimal.ZERO;
				BigDecimal CCFUNFUND = (BigDecimal) BRF80_ENTITY[14] != null ? (BigDecimal) BRF80_ENTITY[14]
						: BigDecimal.ZERO;
				BigDecimal CCFLIMIT = (BigDecimal) BRF80_ENTITY[15] != null ? (BigDecimal) BRF80_ENTITY[15]
						: BigDecimal.ZERO;

				// Calculate the total exposure by adding values
				TOTALEXPOSURE = TOTALEXPOSURE.add(FUN).add(DEBT).add(equity).add(CCFUNFUND).add(CCFLIMIT);

				// Set the total exposure in the BRF77 object
				BRF80.setTotal_exposer(TOTALEXPOSURE);
				// Calculate the ratio of total exposure to Tier 1 capital
				BigDecimal total_exposure_to_tier1_capital;
				if (TIER1CAPITAL.compareTo(BigDecimal.ZERO) != 0) {
					total_exposure_to_tier1_capital = TOTALEXPOSURE.divide(TIER1CAPITAL, MathContext.DECIMAL128); // Use
																													// appropriate
																													// MathContext
				} else {
					total_exposure_to_tier1_capital = BigDecimal.ZERO; // Handle division by zero
				}

				// Optionally, set the ratio in the BRF80 object or use it as needed
				BRF80.setAs_of_tier1_capital(total_exposure_to_tier1_capital);
				T1Master.add(BRF80);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF80");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);

		mv.addObject("getfundos", BRF80_ENTITYREP.getfundos(todate));

		mv.addObject("getdebtsecurities", BRF80_ENTITYREP.getdebtsecurities(todate));

		mv.addObject("getequities", BRF80_ENTITYREP.getequities(todate));
		mv.addObject("getunfund", BRF80_ENTITYREP.getunfund(todate));
		mv.addObject("getccf_equi_unfuned_os", BRF80_ENTITYREP.getccf_equi_unfuned_os(todate));
		mv.addObject("gettotal", BRF80_ENTITYREP.gettotal(todate));
		// mv.addObject("getastier", BRF80_ENTITYREP.getastier(todate));
		mv.addObject("getccf_equi_funded_n_unfuned_limits",
				BRF80_ENTITYREP.getccf_equi_funded_n_unfuned_limits(todate));
		mv.addObject("getcrmafterhaircut", BRF80_ENTITYREP.getcrmafterhaircut(todate));
		mv.addObject("getcollateralafterhaircut", BRF80_ENTITYREP.getcollateralafterhaircut(todate));
		mv.addObject("getprovision", BRF80_ENTITYREP.getprovision(todate));
		// mv.addObject("gettotalexposureafterhaircut",
		// BRF80_ENTITYREP.gettotalexposureafterhaircut(todate));
		mv.addObject("getcapitalcase", BRF80_ENTITYREP.getcapitalcase(todate));

		/*
		 * // Ensure variables match those used in calculation BigDecimal total_exposerd
		 * = FUN.add(DEBT).add(equity).add(CCFUNFUND).add(CCFLIMIT);
		 * mv.addObject("total_exposerd", total_exposerd);
		 * 
		 * // Fetching the value of getTier1_capital String getTier1_capital =
		 * BRF80_ENTITYREP.getcapitalcase(todate);
		 * 
		 * // Adding total_exposerd and getTier1_capital to the ModelAndView
		 * mv.addObject("getTier1_capital", getTier1_capital);
		 * 
		 * BigDecimal as_of_tier1_capitald;
		 * 
		 * // Ensure the string is converted to BigDecimal properly BigDecimal
		 * tier1_capital_value = new BigDecimal(getTier1_capital);
		 * 
		 * if (tier1_capital_value.compareTo(BigDecimal.ZERO) == 0) {
		 * as_of_tier1_capitald = BigDecimal.ZERO; } else { as_of_tier1_capitald =
		 * total_exposerd.divide(tier1_capital_value, MathContext.DECIMAL128); }
		 * 
		 * // Adding as_of_tier1_capitald to the ModelAndView
		 * mv.addObject("as_of_tier1_capitald", as_of_tier1_capitald);
		 */

		// Repeat the process for total_exposertot

		BigDecimal funded_os1 = BRF80_ENTITYREP.getfundos(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getfundos(todate))
				: BigDecimal.ZERO;
		BigDecimal debit_securities1 = BRF80_ENTITYREP.getdebtsecurities(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getdebtsecurities(todate))
				: BigDecimal.ZERO;
		BigDecimal equities1 = BRF80_ENTITYREP.getequities(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getequities(todate))
				: BigDecimal.ZERO;
		BigDecimal CCF_EQUI_UNFUNED_OS1 = BRF80_ENTITYREP.getccf_equi_unfuned_os(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getccf_equi_unfuned_os(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equi_funded_n_unfuned_limits1 = BRF80_ENTITYREP
				.getccf_equi_funded_n_unfuned_limits(todate) != null
						? new BigDecimal(BRF80_ENTITYREP.getccf_equi_funded_n_unfuned_limits(todate))
						: BigDecimal.ZERO;

		BigDecimal total_exposertot = funded_os1.add(debit_securities1).add(equities1).add(CCF_EQUI_UNFUNED_OS1)
				.add(ccf_equi_funded_n_unfuned_limits1);
		mv.addObject("total_exposertot", total_exposertot);

		// Fetching the value of getTier1_capitaltot
		String getTier1_capitaltot = BRF80_ENTITYREP.getcapitalcase(todate);

		// Adding getTier1_capitaltot to the ModelAndView
		mv.addObject("getTier1_capitaltot", getTier1_capitaltot);

		// Calculating as_of_tier1_capitaltot
		BigDecimal as_of_tier1_capitaltot;
		if (getTier1_capitaltot == null || new BigDecimal(getTier1_capitaltot).equals(BigDecimal.ZERO)) {
			as_of_tier1_capitaltot = BigDecimal.ZERO;
		} else {
			as_of_tier1_capitaltot = total_exposertot.divide(new BigDecimal(getTier1_capitaltot),
					MathContext.DECIMAL128);
		}

		// Adding as_of_tier1_capitaltot to the ModelAndView
		mv.addObject("as_of_tier1_capitaltot", as_of_tier1_capitaltot);
		/*
		 * Date todate1 = new Date(); String total =
		 * BRF83_ENTITY1REP.gettotalexposure(todate1); mv.addObject("gettotalexposure",
		 * total);
		 */
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF80currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF80_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF80_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF80_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF80_DETAIL_ENTITY> T1Master = new ArrayList<BRF80_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF80_DETAIL_ENTITY a where a.report_date = ?1", BRF80_DETAIL_ENTITY.class)
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
			String isin_code = (String) a[50];
			String rating = (String) a[51];
			String industry = (String) a[52];

			BRF80_DETAIL_ENTITY py = new BRF80_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg, isin_code, rating, industry);

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

		mv.setViewName("RR" + "/" + "BRF80::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFile(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-080-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF80_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF80_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF80.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF80.jrxml");
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
				List<BRF80_ENTITY> T1Master = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// Retrieve data
					List<Object[]> T1Master1 = BRF80_ENTITYREP.findllvalues(todate);

					File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-080-AT.xls");

					// Load the Excel file
					Workbook workbook = WorkbookFactory.create(responseFile);
					Sheet sheet = workbook.getSheetAt(0);

					FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

					if (!T1Master1.isEmpty()) {
						int startRow = 9; // Starting row index
						System.out.println("T1Master size: " + T1Master.size());

						for (int index = 0; index < T1Master1.size(); index++) {
							Object[] BRF80_ENTITY = T1Master1.get(index);
							Row row = sheet.getRow(startRow + index);
							if (row == null) {
								row = sheet.createRow(startRow + index);
							}

							Cell cell = row.getCell(2);
							if (cell == null) {
								cell = row.createCell(2);
							}

							String value = (BRF80_ENTITY[0] == null) ? "NA" : BRF80_ENTITY[0].toString();
							cell.setCellValue(value);

							Cell cell1 = row.getCell(3);
							if (cell1 == null) {
								cell1 = row.createCell(3);
							}
							String value1 = (BRF80_ENTITY[1] == null) ? "NA" : BRF80_ENTITY[1].toString();
							cell1.setCellValue(value1);

							Cell cell2 = row.getCell(4);
							if (cell2 == null) {
								cell2 = row.createCell(4);
							}
							String value2 = (BRF80_ENTITY[2] == null) ? "NA" : BRF80_ENTITY[2].toString();
							cell2.setCellValue(value2);

							Cell cell3 = row.getCell(5);
							if (cell3 == null) {
								cell3 = row.createCell(5);
							}
							String value3 = (BRF80_ENTITY[3] == null) ? "NA" : BRF80_ENTITY[3].toString();
							cell3.setCellValue(value3);

							Cell cell4 = row.getCell(6);
							if (cell4 == null) {
								cell4 = row.createCell(6);
							}
							String value4 = (BRF80_ENTITY[4] == null) ? "NA" : BRF80_ENTITY[4].toString();
							cell4.setCellValue(value4);

							Cell cell5 = row.getCell(7);
							if (cell5 == null) {
								cell5 = row.createCell(7);
							}
							String value5 = (BRF80_ENTITY[5] == null) ? "NA" : BRF80_ENTITY[5].toString();
							cell5.setCellValue(value5);

							Cell cell6 = row.getCell(8);
							if (cell6 == null) {
								cell6 = row.createCell(8);
							}
							String value6 = (BRF80_ENTITY[6] == null) ? "NA" : BRF80_ENTITY[6].toString();
							cell6.setCellValue(value6);

							Cell cell7 = row.getCell(9);
							if (cell7 == null) {
								cell7 = row.createCell(9);
							}
							String value14 = (BRF80_ENTITY[7] == null) ? "NA" : BRF80_ENTITY[7].toString();
							cell7.setCellValue(value14);

							Cell cell15 = row.getCell(10);
							if (cell15 == null) {
								cell15 = row.createCell(10);
							}
							String value25 = (BRF80_ENTITY[8] == null) ? "NA" : BRF80_ENTITY[8].toString();
							cell15.setCellValue(value25);

							Cell cell16 = row.getCell(11);
							if (cell16 == null) {
								cell16 = row.createCell(11);
							}
							String value16 = (BRF80_ENTITY[9] == null) ? "NA" : BRF80_ENTITY[9].toString();
							cell16.setCellValue(value16);

							Cell cell10 = row.getCell(12);
							if (cell10 == null) {
								cell10 = row.createCell(12);
							}

							cell10.setCellValue(
									BRF80_ENTITY[10] == null ? 0 : ((BigDecimal) BRF80_ENTITY[10]).intValue());

							Cell cell100 = row.getCell(13);
							if (cell100 == null) {
								cell100 = row.createCell(13);
							}

							cell100.setCellValue(
									BRF80_ENTITY[11] == null ? 0 : ((BigDecimal) BRF80_ENTITY[11]).intValue());

							Cell cell110 = row.getCell(14);
							if (cell110 == null) {
								cell110 = row.createCell(14);
							}

							cell110.setCellValue(
									BRF80_ENTITY[12] == null ? 0 : ((BigDecimal) BRF80_ENTITY[12]).intValue());

							Cell cell0 = row.getCell(15);
							if (cell0 == null) {
								cell0 = row.createCell(15);
							}

							cell0.setCellValue(
									BRF80_ENTITY[13] == null ? 0 : ((BigDecimal) BRF80_ENTITY[13]).intValue());

							Cell cell20 = row.getCell(16);
							if (cell20 == null) {
								cell20 = row.createCell(16);
							}

							cell20.setCellValue(
									BRF80_ENTITY[14] == null ? 0 : ((BigDecimal) BRF80_ENTITY[14]).intValue());

							Cell cell30 = row.getCell(17);
							if (cell30 == null) {
								cell30 = row.createCell(17);
							}

							cell30.setCellValue(
									BRF80_ENTITY[15] == null ? 0 : ((BigDecimal) BRF80_ENTITY[15]).intValue());

							Cell cell90 = row.getCell(20);
							if (cell90 == null) {
								cell90 = row.createCell(20);
							}

							cell90.setCellValue(
									BRF80_ENTITY[18] == null ? 0 : ((BigDecimal) BRF80_ENTITY[18]).intValue());

							Cell cell901 = row.getCell(21);
							if (cell901 == null) {
								cell901 = row.createCell(21);
							}

							cell901.setCellValue(
									BRF80_ENTITY[19] == null ? 0 : ((BigDecimal) BRF80_ENTITY[19]).intValue());

							Cell cell902 = row.getCell(22);
							if (cell902 == null) {
								cell902 = row.createCell(22);
							}

							cell902.setCellValue(
									BRF80_ENTITY[20] == null ? 0 : ((BigDecimal) BRF80_ENTITY[20]).intValue());

							Cell cell116 = row.getCell(23);
							if (cell116 == null) {
								cell116 = row.createCell(23);
							}
							String value116 = (BRF80_ENTITY[21] == null) ? "NA" : BRF80_ENTITY[21].toString();
							cell116.setCellValue(value116);

							Cell cell900 = row.getCell(24);
							if (cell900 == null) {
								cell900 = row.createCell(24);
							}

							cell900.setCellValue(
									BRF80_ENTITY[22] == null ? 0 : ((BigDecimal) BRF80_ENTITY[22]).intValue());
							Cell cell416 = row.getCell(25);
							if (cell416 == null) {
								cell416 = row.createCell(25);
							}
							String value176 = (BRF80_ENTITY[23] == null) ? "NA" : BRF80_ENTITY[23].toString();
							cell416.setCellValue(value176);
						}
						if (!T1Master1.isEmpty()) {
							int startRow1 = 7; // Assuming startRow1 should be used here

							for (int index = 0; index < T1Master1.size(); index++) {
								Object[] BRF80_ENTITY = T1Master1.get(index);
								Row row = sheet.getRow(startRow1 + index); // Use startRow1 instead of startRow

								if (row == null) {
									row = sheet.createRow(startRow1 + index); // Use startRow1 here as well
								}

								Cell cell01 = row.getCell(3);
								if (cell01 == null) {
									cell01 = row.createCell(3);
								}
								cell01.setCellValue(
										BRF80_ENTITY[24] == null ? 0 : ((BigDecimal) BRF80_ENTITY[24]).intValue());

							}
						}

						else {
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
					}
				} catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-039-A.xls");

		return outputFile;

	}

	public String detailChanges80(BRF80_DETAIL_ENTITY detail, String report_label_1, BigDecimal act_balance_amt_lc,
			String foracid, String report_name_1, String report_addl_criteria_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF80_DETAIL_ENTITY> Brf80detail = brf80_detailrepo.findById(foracid);

			if (Brf80detail.isPresent()) {
				BRF80_DETAIL_ENTITY BRFdetail = Brf80detail.get();

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
					brf80_detailrepo.save(BRFdetail);

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

	public ModelAndView getArchieveBRF080View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF80_ENTITY> T1Master = new ArrayList<BRF80_ENTITY>();
		List<BRF80_ENTITY> T1rep = new ArrayList<BRF80_ENTITY>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			/*
			 * T1Master = hs.createQuery("from  BRF80_ENTITY a where a.report_date = ?1 ",
			 * BRF80_ENTITY .class) .setParameter(1, df.parse(todate)).getResultList();
			 */

			List<Object[]> T1Master1 = BRF80_ENTITYREP.findllvalues(todate);

			for (Object[] BRF80_ENTITY : T1Master1) {
				BigDecimal TOTALEXPOSURE = BigDecimal.ZERO;
				BRF80_ENTITY BRF80 = new BRF80_ENTITY();
				System.out.println(BRF80_ENTITY[0]);
				BRF80.setSelf_sustainable(String.valueOf(BRF80_ENTITY[0]));

				System.out.println(BRF80_ENTITY[1]);
				BRF80.setEmirates(String.valueOf(BRF80_ENTITY[1]));

				System.out.println(BRF80_ENTITY[2]);
				BRF80.setCin_figi_gleiid(String.valueOf(BRF80_ENTITY[2]));

				System.out.println(BRF80_ENTITY[3]);
				BRF80.setSpecify_as_f(String.valueOf(BRF80_ENTITY[3]));

				System.out.println(BRF80_ENTITY[4]);
				BRF80.setBorrower_type(String.valueOf(BRF80_ENTITY[4]));

				System.out.println(BRF80_ENTITY[5]);
				BRF80.setGroup_name(String.valueOf(BRF80_ENTITY[5]));

				System.out.println(BRF80_ENTITY[6]);
				BRF80.setCredit_rating(String.valueOf(BRF80_ENTITY[6]));

				System.out.println(BRF80_ENTITY[7]);
				BRF80.setCredit_rating_type(String.valueOf(BRF80_ENTITY[7]));

				System.out.println(BRF80_ENTITY[8]);
				BRF80.setEconomic_sector(String.valueOf(BRF80_ENTITY[8]));

				System.out.println(BRF80_ENTITY[9]);
				BRF80.setCurrency(String.valueOf(BRF80_ENTITY[9]));

				BigDecimal fundos = BRF80_ENTITY[10] != null ? (BigDecimal) BRF80_ENTITY[10] : new BigDecimal("0");
				BRF80.setFunded_os(fundos);

				BigDecimal debit_securities = BRF80_ENTITY[11] != null ? (BigDecimal) BRF80_ENTITY[11]
						: new BigDecimal("0");
				BRF80.setDebit_securities(debit_securities);

				BigDecimal equities = BRF80_ENTITY[12] != null ? (BigDecimal) BRF80_ENTITY[12] : new BigDecimal("0");
				BRF80.setEquities(equities);

				BigDecimal unfunded_os = BRF80_ENTITY[13] != null ? (BigDecimal) BRF80_ENTITY[13] : new BigDecimal("0");
				BRF80.setUnfunded_os(unfunded_os);

				BigDecimal ccf_equi_unfuned_os = BRF80_ENTITY[14] != null ? (BigDecimal) BRF80_ENTITY[14]
						: new BigDecimal("0");
				BRF80.setCcf_equi_unfuned_os(ccf_equi_unfuned_os);

				BigDecimal ccf_equi_funded_n_unfuned_limits = BRF80_ENTITY[15] != null ? (BigDecimal) BRF80_ENTITY[15]
						: new BigDecimal("0");
				BRF80.setCcf_equi_funded_n_unfuned_limits(ccf_equi_funded_n_unfuned_limits);

				BigDecimal total_exposer = BRF80_ENTITY[16] != null ? (BigDecimal) BRF80_ENTITY[16]
						: new BigDecimal("0");
				BRF80.setTotal_exposer(total_exposer);

				BigDecimal as_of_tier1_capital = BRF80_ENTITY[17] != null ? (BigDecimal) BRF80_ENTITY[17]
						: new BigDecimal("0");
				BRF80.setAs_of_tier1_capital(as_of_tier1_capital);

				BigDecimal credit_risk_miti_type = BRF80_ENTITY[18] != null ? (BigDecimal) BRF80_ENTITY[18]
						: new BigDecimal("0");
				BRF80.setCredit_risk_miti_type(credit_risk_miti_type);

				BigDecimal credit_risk_miti_hair_cut = BRF80_ENTITY[19] != null ? (BigDecimal) BRF80_ENTITY[19]
						: new BigDecimal("0");
				BRF80.setCredit_risk_miti_hair_cut(credit_risk_miti_hair_cut);

				BigDecimal collateral_hair_cut = BRF80_ENTITY[20] != null ? (BigDecimal) BRF80_ENTITY[20]
						: new BigDecimal("0");
				BRF80.setCollateral_hair_cut(collateral_hair_cut);

				BRF80.setCbuae_class(String.valueOf(BRF80_ENTITY[21]));

				BigDecimal provision = BRF80_ENTITY[22] != null ? (BigDecimal) BRF80_ENTITY[22] : new BigDecimal("0");
				BRF80.setProvision(provision);

				BRF80.setRemarks(String.valueOf(BRF80_ENTITY[23]));

				BigDecimal tier_1_capital = BRF80_ENTITY[24] != null ? (BigDecimal) BRF80_ENTITY[24]
						: new BigDecimal("0");
				BRF80.setTier_1_capital(tier_1_capital);

				BRF80.setRow_label(String.valueOf(BRF80_ENTITY[25]));
				// Retrieve Tier 1 capital (assuming you have it stored in BRF80_ENTITY[16] or
				// another index)
				BigDecimal TIER1CAPITAL = (BigDecimal) BRF80_ENTITY[24] != null ? (BigDecimal) BRF80_ENTITY[24]
						: BigDecimal.ZERO;

				BigDecimal FUN = (BigDecimal) BRF80_ENTITY[10] != null ? (BigDecimal) BRF80_ENTITY[10]
						: BigDecimal.ZERO;
				BigDecimal DEBT = (BigDecimal) BRF80_ENTITY[11] != null ? (BigDecimal) BRF80_ENTITY[11]
						: BigDecimal.ZERO;
				BigDecimal equity = (BigDecimal) BRF80_ENTITY[12] != null ? (BigDecimal) BRF80_ENTITY[12]
						: BigDecimal.ZERO;
				BigDecimal CCFUNFUND = (BigDecimal) BRF80_ENTITY[14] != null ? (BigDecimal) BRF80_ENTITY[14]
						: BigDecimal.ZERO;
				BigDecimal CCFLIMIT = (BigDecimal) BRF80_ENTITY[15] != null ? (BigDecimal) BRF80_ENTITY[15]
						: BigDecimal.ZERO;

				// Calculate the total exposure by adding values
				TOTALEXPOSURE = TOTALEXPOSURE.add(FUN).add(DEBT).add(equity).add(CCFUNFUND).add(CCFLIMIT);

				// Set the total exposure in the BRF77 object
				BRF80.setTotal_exposer(TOTALEXPOSURE);
				// Calculate the ratio of total exposure to Tier 1 capital
				BigDecimal total_exposure_to_tier1_capital;
				if (TIER1CAPITAL.compareTo(BigDecimal.ZERO) != 0) {
					total_exposure_to_tier1_capital = TOTALEXPOSURE.divide(TIER1CAPITAL, MathContext.DECIMAL128); // Use
																													// appropriate
																													// MathContext
				} else {
					total_exposure_to_tier1_capital = BigDecimal.ZERO; // Handle division by zero
				}

				// Optionally, set the ratio in the BRF80 object or use it as needed
				BRF80.setAs_of_tier1_capital(total_exposure_to_tier1_capital);
				T1Master.add(BRF80);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF80ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);

		mv.addObject("getfundos", BRF80_ENTITYREP.getfundos(todate));

		mv.addObject("getdebtsecurities", BRF80_ENTITYREP.getdebtsecurities(todate));

		mv.addObject("getequities", BRF80_ENTITYREP.getequities(todate));
		mv.addObject("getunfund", BRF80_ENTITYREP.getunfund(todate));
		mv.addObject("getccf_equi_unfuned_os", BRF80_ENTITYREP.getccf_equi_unfuned_os(todate));
		mv.addObject("gettotal", BRF80_ENTITYREP.gettotal(todate));
		// mv.addObject("getastier", BRF80_ENTITYREP.getastier(todate));
		mv.addObject("getccf_equi_funded_n_unfuned_limits",
				BRF80_ENTITYREP.getccf_equi_funded_n_unfuned_limits(todate));
		mv.addObject("getcrmafterhaircut", BRF80_ENTITYREP.getcrmafterhaircut(todate));
		mv.addObject("getcollateralafterhaircut", BRF80_ENTITYREP.getcollateralafterhaircut(todate));
		mv.addObject("getprovision", BRF80_ENTITYREP.getprovision(todate));
		// mv.addObject("gettotalexposureafterhaircut",
		// BRF80_ENTITYREP.gettotalexposureafterhaircut(todate));
		mv.addObject("getcapitalcase", BRF80_ENTITYREP.getcapitalcase(todate));

		/*
		 * // Ensure variables match those used in calculation BigDecimal total_exposerd
		 * = FUN.add(DEBT).add(equity).add(CCFUNFUND).add(CCFLIMIT);
		 * mv.addObject("total_exposerd", total_exposerd);
		 * 
		 * // Fetching the value of getTier1_capital String getTier1_capital =
		 * BRF80_ENTITYREP.getcapitalcase(todate);
		 * 
		 * // Adding total_exposerd and getTier1_capital to the ModelAndView
		 * mv.addObject("getTier1_capital", getTier1_capital);
		 * 
		 * BigDecimal as_of_tier1_capitald;
		 * 
		 * // Ensure the string is converted to BigDecimal properly BigDecimal
		 * tier1_capital_value = new BigDecimal(getTier1_capital);
		 * 
		 * if (tier1_capital_value.compareTo(BigDecimal.ZERO) == 0) {
		 * as_of_tier1_capitald = BigDecimal.ZERO; } else { as_of_tier1_capitald =
		 * total_exposerd.divide(tier1_capital_value, MathContext.DECIMAL128); }
		 * 
		 * // Adding as_of_tier1_capitald to the ModelAndView
		 * mv.addObject("as_of_tier1_capitald", as_of_tier1_capitald);
		 */

		// Repeat the process for total_exposertot

		BigDecimal funded_os1 = BRF80_ENTITYREP.getfundos(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getfundos(todate))
				: BigDecimal.ZERO;
		BigDecimal debit_securities1 = BRF80_ENTITYREP.getdebtsecurities(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getdebtsecurities(todate))
				: BigDecimal.ZERO;
		BigDecimal equities1 = BRF80_ENTITYREP.getequities(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getequities(todate))
				: BigDecimal.ZERO;
		BigDecimal CCF_EQUI_UNFUNED_OS1 = BRF80_ENTITYREP.getccf_equi_unfuned_os(todate) != null
				? new BigDecimal(BRF80_ENTITYREP.getccf_equi_unfuned_os(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equi_funded_n_unfuned_limits1 = BRF80_ENTITYREP
				.getccf_equi_funded_n_unfuned_limits(todate) != null
						? new BigDecimal(BRF80_ENTITYREP.getccf_equi_funded_n_unfuned_limits(todate))
						: BigDecimal.ZERO;

		BigDecimal total_exposertot = funded_os1.add(debit_securities1).add(equities1).add(CCF_EQUI_UNFUNED_OS1)
				.add(ccf_equi_funded_n_unfuned_limits1);
		mv.addObject("total_exposertot", total_exposertot);

		// Fetching the value of getTier1_capitaltot
		String getTier1_capitaltot = BRF80_ENTITYREP.getcapitalcase(todate);

		// Adding getTier1_capitaltot to the ModelAndView
		mv.addObject("getTier1_capitaltot", getTier1_capitaltot);

		// Calculating as_of_tier1_capitaltot
		BigDecimal as_of_tier1_capitaltot;
		if (getTier1_capitaltot == null || new BigDecimal(getTier1_capitaltot).equals(BigDecimal.ZERO)) {
			as_of_tier1_capitaltot = BigDecimal.ZERO;
		} else {
			as_of_tier1_capitaltot = total_exposertot.divide(new BigDecimal(getTier1_capitaltot),
					MathContext.DECIMAL128);
		}

		// Adding as_of_tier1_capitaltot to the ModelAndView
		mv.addObject("as_of_tier1_capitaltot", as_of_tier1_capitaltot);
		/*
		 * Date todate1 = new Date(); String total =
		 * BRF83_ENTITY1REP.gettotalexposure(todate1); mv.addObject("gettotalexposure",
		 * total);
		 */
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

	public ModelAndView ARCHgetBRF080currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF80_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF80_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF80_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF80_ARCHIVENTITY> T1Master = new ArrayList<BRF80_ARCHIVENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF80_ARCHIVENTITY a where a.report_date = ?1", BRF80_ARCHIVENTITY.class)
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
			String isin_code = (String) a[50];
			String rating = (String) a[51];
			String industry = (String) a[52];

			BRF80_DETAIL_ENTITY py = new BRF80_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flg, isin_code, rating, industry);

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

		mv.setViewName("RR" + "/" + "BRF80ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
