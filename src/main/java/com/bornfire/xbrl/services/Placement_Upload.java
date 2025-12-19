package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
import com.bornfire.xbrl.entities.BLS0100.BLS0100Detail;
import com.bornfire.xbrl.entities.BLS0100.BLS0100DetailId;
import com.bornfire.xbrl.entities.BLS0100.BLS0100History;
import com.bornfire.xbrl.entities.BLS0100.BLS0100Manual;
import com.bornfire.xbrl.entities.BLS0100.BLS0100Mod;
import com.bornfire.xbrl.entities.BLS0100.BLS0100RepId;
import com.bornfire.xbrl.entities.BLS0100.BLS0100Report;
import com.bornfire.xbrl.entities.file_upload.Placement_Entity;
import com.monitorjbl.xlsx.StreamingReader;

import au.com.bytecode.opencsv.CSVReader;
@Service
@Transactional

public class Placement_Upload {
	private static final Logger logger = LoggerFactory.getLogger(Placement_Upload.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	XBRLReportsMasterRep xbrlReportsMasterRep;

	@Autowired
	DataSource srcdataSource;

	@NotNull
	private String exportpath;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ReferenceCodeConfigure refCodeConfig;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public static File multipartToFile(MultipartFile multipart, String fileName)
			throws IllegalStateException, IOException {
		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		multipart.transferTo(convFile);
		return convFile;
	}

	public String getExportpath() {
		return exportpath;
	}

	public void setExportpath(String exportpath) {
		this.exportpath = exportpath;
	}

	public ModelAndView getTREASURYView(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype, String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> bls0100Rep = new ArrayList<Object>();

		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
			qr = hs.createNativeQuery("select * from table(bls0100_s1_rpt_fun(?1,?2,?3,?4,?5,?6))");

			qr.setParameter(1, reportId);
			qr.setParameter(2, "0");
			qr.setParameter(3, reportDate);
			qr.setParameter(4, fromdate);
			qr.setParameter(5, todate);
			qr.setParameter(6, currency);

		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery(
					"select * from bls0100_s1_rpt_tb a where report_date = ?1 order by instance_code ");
			try {
				qr.setParameter(1, df.parse(reportDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		logger.info("Getting Report Summary for : " + reportId + "," + reportDate + "," + fromdate + "," + todate + ","
				+ currency);

		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {

			String report_id = (String) a[0];
			Date report_date = (Date) a[1];
			Date from_date = (Date) a[2];
			Date to_date = (Date) a[3];
			String version_no = (String) a[4];
			String curr = (String) a[5];
			String ref_code_desc = (String) a[6];
			BigDecimal instance_code = (BigDecimal) a[7];
			BigDecimal central_bank = (BigDecimal) a[8];
			BigDecimal banks = (BigDecimal) a[9];
			BigDecimal non_bnk = (BigDecimal) a[10];
			BigDecimal credit_unions = (BigDecimal) a[11];
			BigDecimal fin_gbc1 = (BigDecimal) a[12];
			BigDecimal trusts_nr_gbc = (BigDecimal) a[13];
			BigDecimal insurance_corp = (BigDecimal) a[14];
			BigDecimal pension = (BigDecimal) a[15];
			BigDecimal investment = (BigDecimal) a[16];
			BigDecimal holding_comp = (BigDecimal) a[17];
			BigDecimal financial_aux = (BigDecimal) a[18];
			BigDecimal central_gov = (BigDecimal) a[19];
			BigDecimal state_loc_gov = (BigDecimal) a[20];
			BigDecimal non_finance_gbc = (BigDecimal) a[21];
			BigDecimal gbc2 = (BigDecimal) a[22];
			BigDecimal public_non_fin_corp = (BigDecimal) a[23];
			BigDecimal oth_non_fin_corp = (BigDecimal) a[24];
			BigDecimal household = (BigDecimal) a[25];
			BigDecimal non_prof_institute = (BigDecimal) a[26];
			BigDecimal aff_nr = (BigDecimal) a[27];
			BigDecimal oth_nr = (BigDecimal) a[28];
			BigDecimal tot_lc = (BigDecimal) a[29];
			BigDecimal fc_central_bnk = (BigDecimal) a[30];
			BigDecimal fc_banks = (BigDecimal) a[31];
			BigDecimal fc_non_bnk = (BigDecimal) a[32];
			BigDecimal fc_credit_unions = (BigDecimal) a[33];
			BigDecimal fc_fin_gbc1 = (BigDecimal) a[34];
			BigDecimal fc_trusts_nr_gbc = (BigDecimal) a[35];
			BigDecimal fc_insurance_corp = (BigDecimal) a[36];
			BigDecimal fc_pension = (BigDecimal) a[37];
			BigDecimal fc_investment = (BigDecimal) a[38];
			BigDecimal fc_holding_comp = (BigDecimal) a[39];
			BigDecimal fc_financial_aux = (BigDecimal) a[40];
			BigDecimal fc_central_gov = (BigDecimal) a[41];
			BigDecimal fc_state_loc_gov = (BigDecimal) a[42];
			BigDecimal fc_non_finance_gbc = (BigDecimal) a[43];
			BigDecimal fc_gbc2 = (BigDecimal) a[44];
			BigDecimal fc_public_non_fin_corp = (BigDecimal) a[45];
			BigDecimal fc_oth_non_fin_corp = (BigDecimal) a[46];
			BigDecimal fc_household = (BigDecimal) a[47];
			BigDecimal fc_non_prof_institute = (BigDecimal) a[48];
			BigDecimal fc_aff_nr_bnk = (BigDecimal) a[49];
			BigDecimal fc_aff_nr_non_bnk = (BigDecimal) a[50];
			BigDecimal fc_oth_nr_bnk = (BigDecimal) a[51];
			BigDecimal fc_oth_nr_non_bnk = (BigDecimal) a[52];
			BigDecimal tot_fc = (BigDecimal) a[53];
			BigDecimal grand_tot = (BigDecimal) a[54];

			BLS0100RepId id = new BLS0100RepId(report_date, instance_code);
			BLS0100Report rep = new BLS0100Report(id, report_id, from_date, to_date, version_no, currency,
					ref_code_desc, central_bank, banks, non_bnk, credit_unions, fin_gbc1, trusts_nr_gbc, insurance_corp,
					pension, investment, holding_comp, financial_aux, central_gov, state_loc_gov, non_finance_gbc, gbc2,
					public_non_fin_corp, oth_non_fin_corp, household, non_prof_institute, aff_nr, oth_nr, tot_lc,
					fc_central_bnk, fc_banks, fc_non_bnk, fc_credit_unions, fc_fin_gbc1, fc_trusts_nr_gbc,
					fc_insurance_corp, fc_pension, fc_investment, fc_holding_comp, fc_financial_aux, fc_central_gov,
					fc_state_loc_gov, fc_non_finance_gbc, fc_gbc2, fc_public_non_fin_corp, fc_oth_non_fin_corp,
					fc_household, fc_non_prof_institute, fc_aff_nr_bnk, fc_aff_nr_non_bnk, fc_oth_nr_bnk,
					fc_oth_nr_non_bnk, tot_fc, grand_tot);

			bls0100Rep.add(rep);

		}
		;

		List<Object> pagedlist;

		if (bls0100Rep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, bls0100Rep.size());
			pagedlist = bls0100Rep.subList(startItem, toIndex);
		}
		logger.info("Converting to Page");
		Page<Object> bls0100RepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				bls0100Rep.size());

		mv.setViewName(reportId + "/" + reportId);
		mv.addObject("secid", "1");
		mv.addObject("subreportid", "BLS0100");
		mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", bls0100RepPage);

		return mv;

	}

	public ModelAndView getTREASURYRep(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype, String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<Object> bls0100Rep = new ArrayList<>();

		if (subreportid.equals("BLS0100") || subreportid == null) {

			bls0100Rep = getBLS0100Rep(reportId, reportDate, fromdate, todate, currency, dtltype, subreportid, secid);

			mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

		}

		List<Object> pagedlist;

		if (bls0100Rep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, bls0100Rep.size());
			pagedlist = bls0100Rep.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> bls0100RepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				bls0100Rep.size());

		mv.addObject("secid", secid);
		mv.addObject("subreportid", subreportid);
		mv.addObject("reportsummary", bls0100RepPage);

		return mv;

	}

	public ModelAndView getTREASURYDtl(String reportId, String instanceCode, String reportDate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		List<Object> bls0100Dtl = new ArrayList<>();

		if (subreportid.equals("BLS0100") || subreportid == null) {

			bls0100Dtl = getBLS0100Detail(reportId, instanceCode, reportDate, fromdate, todate, currency, dtltype,
					subreportid, secid);

			mv.addObject("singledetail", new BLS0100Detail());
			mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

		}

		List<Object> pagedlist;

		if (bls0100Dtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, bls0100Dtl.size());
			pagedlist = bls0100Dtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> bls0100DtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				bls0100Dtl.size());

		mv.addObject("secid", secid);
		mv.addObject("subreportid", subreportid);
		mv.addObject("reportdetails", bls0100DtlPage);

		return mv;
	}

	public String detailChanges(BLS0100Detail detail, Character changeType, String userid) {

		String msg = "";

		try {
			BLS0100Mod mod = new BLS0100Mod(detail);

			Session hs = sessionFactory.getCurrentSession();

			mod.setDel_flg(changeType);
			mod.setLchg_user_id(userid);
			mod.setLchg_time(new Date());

			hs.saveOrUpdate(mod);

			if (changeType.equals('A')) {
				logger.info("Added Record");
				msg = "Added Successfully";
			} else if (changeType.equals('E')) {
				logger.info("Edited Record");
				msg = "Edited Successfully";
			} else if (changeType.equals('D')) {
				logger.info("Deleted Record");
				msg = "Deleted Successfully";
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public String preCheck(String reportid, String asondate, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt;

		try {
			dt = new SimpleDateFormat("dd-MM-yyyy").parse(asondate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs
					.createQuery("select count(*) from BLS0100Detail a where a.bls0100DetailId.report_date=?1")
					.setParameter(1, dt).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt1 = (Long) hs.createQuery("select count(*) from BLS0100Mod a").getSingleResult();
				Long modcnt2 = (Long) hs.createQuery("select count(*) from BLS0110Mod a").getSingleResult();
				Long modcnt3 = (Long) hs.createQuery("select count(*) from BLS0140Mod a").getSingleResult();
				if (modcnt1 > 0 || modcnt2 > 0 || modcnt3 > 0) {
					msg = "Records Pending for Verification For the Report";
				} else {
					msg = "success";
				}
			} else {
				msg = "Data Not available for the Report. Please Contact Administrator";
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "Error";
			e.printStackTrace();

		}

		return msg;

	}

	public ModelAndView getModData(String reportId, Pageable pageable) {

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView(reportId + "/" + reportId + "Verify");
		Session hs = sessionFactory.getCurrentSession();
		logger.info("Getting Mod data");
		List<BLS0100Mod> bls0100Mod = hs.createQuery("from BLS0100Mod").getResultList();

		List<BLS0100Mod> pagedlistbls0100;
		/******************************************
		 * bls0100 pagination
		 *************************************/

		if (bls0100Mod.size() < startItem) {
			pagedlistbls0100 = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, bls0100Mod.size());
			pagedlistbls0100 = bls0100Mod.subList(startItem, toIndex);
		}

		logger.info("Pagination of Mod data");
		Page<BLS0100Mod> bls0100ModPage = new PageImpl<BLS0100Mod>(pagedlistbls0100,
				PageRequest.of(currentPage, pageSize), bls0100Mod.size());

		/******************************************
		 * bls0110 pagination
		 *************************************/

		logger.info("Pagination of Mod data");

		/******************************************
		 * bls0140 pagination
		 ************************************/

		logger.info("Pagination of Mod data");

		mv.setViewName(reportId + "/" + reportId + "Verify");
		mv.addObject("modtype", "BLS0100");
		mv.addObject("ModDatabls0100", bls0100ModPage);
		mv.addObject("singleModbls0100", new BLS0100Mod());

		return mv;
	}

	public String verifyChanges(BLS0100Mod moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BLS0100Mod mod = hs.find(BLS0100Mod.class, moddata.getBls0100ModId());
			mod.setVerify_user_id(userid);
			mod.setVerify_time(new Date());
			hs.flush();
			BLS0100Detail detail = new BLS0100Detail(mod);
			if (mod.getDel_flg().equals('D'))

			{
				logger.info("Verifying Record");
				hs.remove(detail);
			} else {
				hs.saveOrUpdate(detail);
			}
			hs.remove(mod);
			msg = "Verified Successfully";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			msg = "Error Occured. Please contact Administrator";
		}

		return msg;
	}

	public String RejectChanges(BLS0100Mod moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {

			BLS0100Mod mod = hs.find(BLS0100Mod.class, moddata.getBls0100ModId());
			mod.setLchg_user_id(userid);
			hs.flush();
			logger.info("Deleting record form Mod table");
			hs.remove(mod);
			msg = "Rejected Successfully";
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			msg = "Error Occured. Please contact Administrator";
		}
		return msg;
	}

	private List<Object> getBLS0100Rep(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype, String subreportid, String secid) {

		Session hs = sessionFactory.getCurrentSession();
		List<Object> bls0100Rep = new ArrayList<Object>();

		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
			qr = hs.createNativeQuery("select * from table(bls0100_s" + secid + "_rpt_fun(?1,?2,?3,?4,?5,?6))");

			qr.setParameter(1, reportId);
			qr.setParameter(2, "0");
			qr.setParameter(3, reportDate);
			qr.setParameter(4, fromdate);
			qr.setParameter(5, todate);
			qr.setParameter(6, currency);

		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery("select * from bls0100_s" + secid + "_rpt_tb a where report_date = ?1 ");
			try {
				qr.setParameter(1, df.parse(reportDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		logger.info("Getting Report Summary for : " + reportId + "," + reportDate + "," + fromdate + "," + todate + ","
				+ currency);

		List<Object[]> result = qr.getResultList();
		for (Object[] a : result) {

			String report_id = (String) a[0];
			Date report_date = (Date) a[1];
			Date from_date = (Date) a[2];
			Date to_date = (Date) a[3];
			String version_no = (String) a[4];
			String curr = (String) a[5];
			String ref_code_desc = (String) a[6];
			BigDecimal instance_code = (BigDecimal) a[7];
			BigDecimal central_bank = (BigDecimal) a[8];
			BigDecimal banks = (BigDecimal) a[9];
			BigDecimal non_bnk = (BigDecimal) a[10];
			BigDecimal credit_unions = (BigDecimal) a[11];
			BigDecimal fin_gbc1 = (BigDecimal) a[12];
			BigDecimal trusts_nr_gbc = (BigDecimal) a[13];
			BigDecimal insurance_corp = (BigDecimal) a[14];
			BigDecimal pension = (BigDecimal) a[15];
			BigDecimal investment = (BigDecimal) a[16];
			BigDecimal holding_comp = (BigDecimal) a[17];
			BigDecimal financial_aux = (BigDecimal) a[18];
			BigDecimal central_gov = (BigDecimal) a[19];
			BigDecimal state_loc_gov = (BigDecimal) a[20];
			BigDecimal non_finance_gbc = (BigDecimal) a[21];
			BigDecimal gbc2 = (BigDecimal) a[22];
			BigDecimal public_non_fin_corp = (BigDecimal) a[23];
			BigDecimal oth_non_fin_corp = (BigDecimal) a[24];
			BigDecimal household = (BigDecimal) a[25];
			BigDecimal non_prof_institute = (BigDecimal) a[26];
			BigDecimal aff_nr = (BigDecimal) a[27];
			BigDecimal oth_nr = (BigDecimal) a[28];
			BigDecimal tot_lc = (BigDecimal) a[29];
			BigDecimal fc_central_bnk = (BigDecimal) a[30];
			BigDecimal fc_banks = (BigDecimal) a[31];
			BigDecimal fc_non_bnk = (BigDecimal) a[32];
			BigDecimal fc_credit_unions = (BigDecimal) a[33];
			BigDecimal fc_fin_gbc1 = (BigDecimal) a[34];
			BigDecimal fc_trusts_nr_gbc = (BigDecimal) a[35];
			BigDecimal fc_insurance_corp = (BigDecimal) a[36];
			BigDecimal fc_pension = (BigDecimal) a[37];
			BigDecimal fc_investment = (BigDecimal) a[38];
			BigDecimal fc_holding_comp = (BigDecimal) a[39];
			BigDecimal fc_financial_aux = (BigDecimal) a[40];
			BigDecimal fc_central_gov = (BigDecimal) a[41];
			BigDecimal fc_state_loc_gov = (BigDecimal) a[42];
			BigDecimal fc_non_finance_gbc = (BigDecimal) a[43];
			BigDecimal fc_gbc2 = (BigDecimal) a[44];
			BigDecimal fc_public_non_fin_corp = (BigDecimal) a[45];
			BigDecimal fc_oth_non_fin_corp = (BigDecimal) a[46];
			BigDecimal fc_household = (BigDecimal) a[47];
			BigDecimal fc_non_prof_institute = (BigDecimal) a[48];
			BigDecimal fc_aff_nr_bnk = (BigDecimal) a[49];
			BigDecimal fc_aff_nr_non_bnk = (BigDecimal) a[50];
			BigDecimal fc_oth_nr_bnk = (BigDecimal) a[51];
			BigDecimal fc_oth_nr_non_bnk = (BigDecimal) a[52];
			BigDecimal tot_fc = (BigDecimal) a[53];
			BigDecimal grand_tot = (BigDecimal) a[54];

			BLS0100RepId id = new BLS0100RepId(report_date, instance_code);
			BLS0100Report rep = new BLS0100Report(id, report_id, from_date, to_date, version_no, currency,
					ref_code_desc, central_bank, banks, non_bnk, credit_unions, fin_gbc1, trusts_nr_gbc, insurance_corp,
					pension, investment, holding_comp, financial_aux, central_gov, state_loc_gov, non_finance_gbc, gbc2,
					public_non_fin_corp, oth_non_fin_corp, household, non_prof_institute, aff_nr, oth_nr, tot_lc,
					fc_central_bnk, fc_banks, fc_non_bnk, fc_credit_unions, fc_fin_gbc1, fc_trusts_nr_gbc,
					fc_insurance_corp, fc_pension, fc_investment, fc_holding_comp, fc_financial_aux, fc_central_gov,
					fc_state_loc_gov, fc_non_finance_gbc, fc_gbc2, fc_public_non_fin_corp, fc_oth_non_fin_corp,
					fc_household, fc_non_prof_institute, fc_aff_nr_bnk, fc_aff_nr_non_bnk, fc_oth_nr_bnk,
					fc_oth_nr_non_bnk, tot_fc, grand_tot);

			bls0100Rep.add(rep);

		}
		;

		return bls0100Rep;
	}

	private List<Object> getBLS0100Detail(String reportId, String instanceCode, String reportDate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid) {

		Session hs = sessionFactory.getCurrentSession();
		List<Object> bls0100Dtl = new ArrayList<Object>();
		Query<Object[]> qr;
		Query<Object[]> countQr;

		if (dtltype.equals("report")) {
			qr = hs.createNativeQuery("select * from table(bls0100_s" + secid + "_dtl_fun(?1,?2,?3,?4,?5,?6,?7))");
		} else {
			qr = hs.createNativeQuery("select * from table(bls0100_s" + secid + "_dtl_h_fun(?1,?2,?3,?4,?5,?6,?7))");
		}

		qr.setParameter(1, reportId);
		qr.setParameter(2, "0");
		qr.setParameter(3, instanceCode);
		qr.setParameter(4, reportDate);
		qr.setParameter(5, fromdate);
		qr.setParameter(6, todate);
		qr.setParameter(7, currency);

		qr.setFirstResult(0);
		qr.setMaxResults(300);

		logger.info("Getting Report Detail for : " + reportId + "," + reportDate + "," + fromdate + "," + todate + ","
				+ currency);
		List<Object[]> result = qr.getResultList();
		logger.info("Got results");
		for (Object[] a : result) {

			String remarks = (String) a[0];
			String acct_crncy_code = (String) a[1];
			String glsh_code = (String) a[2];
			String sch_type = (String) a[3];
			String sch_code = (String) a[4];
			String cust_id = (String) a[5];
			String acct_no = (String) a[6];
			String acct_name = (String) a[7];
			Date eab_date = (Date) a[8];
			BigDecimal eab_bal = (BigDecimal) a[9];
			Date report_date = (Date) a[10];
			Character del_flg = (Character) a[11];
			String rcre_user_id = (String) a[12];
			Date rcre_time = (Date) a[13];
			String lchg_user_id = (String) a[14];
			Date lchg_time = (Date) a[15];
			String verify_user_id = (String) a[16];
			Date verify_time = (Date) a[17];

			BLS0100DetailId id = new BLS0100DetailId(acct_no, report_date);

			BLS0100Detail rep = new BLS0100Detail(remarks, acct_crncy_code, glsh_code, sch_type, sch_code, cust_id, id,
					acct_name, eab_date, eab_bal, del_flg, rcre_user_id, rcre_time, lchg_user_id, lchg_time,
					verify_user_id, verify_time);

			bls0100Dtl.add(rep);

		}
		;

		return bls0100Dtl;
	}

	public ModelAndView getSearchDetails(String reportId, String instancecode, String asondate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable,
			BLS0100Detail detail) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> bls0100Dtl = new ArrayList<Object>();

		BLS0100Detail dtl;

		if (dtltype.equals("report")) {
			dtl = hs.find(BLS0100Detail.class, detail.getBls0100DetailId());
		} else {
			BLS0100History hist = hs.find(BLS0100History.class, detail.getBls0100DetailId());
			dtl = new BLS0100Detail(hist);
		}

		if (dtl == null) {

			mv.addObject("searchmsg", "No Data Available");

		}

		bls0100Dtl.add(dtl);

		List<Object> pagedlist;

		if (bls0100Dtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, bls0100Dtl.size());
			pagedlist = bls0100Dtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> bls0100DtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				bls0100Dtl.size());

		if (subreportid.equals("BLS0100") || subreportid == null) {

			mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

		} else if (subreportid.equals("BLS0110")) {

			mv.setViewName(reportId + "/" + subreportid + "_S" + secid + ":: reportcontent");

		}

		mv.addObject("reportdetails", bls0100DtlPage);
		mv.addObject("secid", secid);
		mv.addObject("subreportid", subreportid);
		mv.addObject("singledetail", new BLS0100Detail());

		return mv;

	}

	public String uploadPreCheck(String reportId, String reportDate) {

		String msg = "";
		Date repDate = null;
		try {
			repDate = new SimpleDateFormat("dd-MM-yyyy").parse(reportDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Long count = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from Placement_Entity where report_date=?1").setParameter(1, repDate)
				.getSingleResult();

		if (count > 0) {

			msg = "Data Already available for the Report. Do you want to Replace?";

		} else {

			msg = "No existing data found. Do you want to upload?";
		}

		return msg;
	}

	public String processUpload(String asondate, MultipartFile[] files, String userid)
			throws SQLException, FileNotFoundException, IOException {

		String result = "";

		String status = "";

		logger.info("processing BRF156   file");

		MultipartFile uploadedFile = files[0];

		logger.info("uploaded file name:" + uploadedFile.getOriginalFilename() + "asondate:" + asondate + "userid:"
				+ userid);

		result = PlacementUpload(uploadedFile, asondate, userid);
		/*
		 * if (result.equals("success")) { status = validateUpload(asondate,
		 * "BRF5_TRASURY_MANUAL_TABLE"); }
		 */

		return result;
	}

	public String PlacementUpload(MultipartFile file, String asondate, String userid)
			throws SQLException, FileNotFoundException, IOException {

		logger.info("TreasuryReportServices->TreasuryUpload()");
		String fileName = file.getOriginalFilename();
		File convertedFile = multipartToFile(file, fileName);

		String fileExt = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			fileExt = fileName.substring(i + 1);
		}

		logger.info("file extension : " + fileExt);

		String Errormsg = "";

		String status = "";

		logger.info("truncating table: master_tb_manual_table");

		Session theSession = sessionFactory.getCurrentSession();
		theSession.createSQLQuery(" truncate table PLACEMENT_MANUAL_TABLE ").executeUpdate();

		logger.info("master_tb_manual_table truncated");

		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {

			logger.info("reading values from Excel");

			String cellval = "";
			System.out.println("hi1111");
			try (InputStream is = new FileInputStream(convertedFile);

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(is)) {

				for (Sheet s : workbook) {

					int sheetNumber = workbook.getSheetIndex(s);
					if (sheetNumber == 0) {
						System.out.println("jjjjsss---");
						logger.info("inside workbook");

						for (Row r : s) {

							ArrayList<String> resultList = new ArrayList<>();
							if (r.getRowNum() == 0) {
								continue;
							}

							cellval = "";
							String val = null;
							for (int j = 0; j < 30; j++) {
								Cell cell = r.getCell(j);
								if (cell == null || cell.getStringCellValue().length() == 0) {
									val = null;
								} else {
									val = cell.getStringCellValue();

								}
								resultList.add(val);

							}
							System.out.println("inside --start the upload");
							String datePattern = "dd-MMM-yyyy"; // Adjust this pattern based on your actual date format
							SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
							// num_operation
							String num_operation = resultList.get(0);
							BigDecimal num_operation1 = null;
							if (num_operation != null && !num_operation.trim().isEmpty()) {
							    try {
							        num_operation1 = new BigDecimal(num_operation.trim());
							        System.out.println("The number as BigDecimal is: " + num_operation1);
							    } catch (NumberFormatException e) {
							        System.err.println("The string does not contain a parsable number for num_operation.");
							    }
							} else {
							    System.err.println("num_operation is null or empty.");
							}

							// entite_operation
							String entite_operation = resultList.get(1);
							BigDecimal entite_operation1 = null;
							if (entite_operation != null && !entite_operation.trim().isEmpty()) {
							    try {
							        entite_operation1 = new BigDecimal(entite_operation.trim());
							        System.out.println("The number as BigDecimal is: " + entite_operation1);
							    } catch (NumberFormatException e) {
							        System.err.println("The string does not contain a parsable number for entite_operation.");
							    }
							} else {
							    System.err.println("entite_operation is null or empty.");
							}

							// poste
							String poste = "";
							if (resultList.get(2) != null && !resultList.get(2).isEmpty()) {
							    poste = resultList.get(2);
							}

							// titre
							String titre = "";
							if (resultList.get(3) != null && !resultList.get(3).isEmpty()) {
							    titre = resultList.get(3);
							}

							// devise_1
							String devise_1 = "";
							if (resultList.get(4) != null && !resultList.get(4).isEmpty()) {
							    devise_1 = resultList.get(4);
							}

							// nominal_1
							String nominal_1 = resultList.get(5);
							BigDecimal nominal_1_value = null;
							if (nominal_1 != null && !nominal_1.trim().isEmpty()) {
							    try {
							        nominal_1_value = new BigDecimal(nominal_1.trim());
							        System.out.println("The number as BigDecimal is: " + nominal_1_value);
							    } catch (NumberFormatException e) {
							        System.err.println("The string does not contain a parsable number for nominal_1.");
							    }
							} else {
							    System.err.println("nominal_1 is null or empty.");
							}

							// date_operation
							String date_operation_str = resultList.get(6);
							Date date_operation = null;
							if (date_operation_str != null && !date_operation_str.isEmpty()) {
							    try {
							        date_operation = dateFormat.parse(date_operation_str);
							    } catch (Exception e) {
							        e.printStackTrace(); // Handle parse exception
							    }
							} else {
							    System.out.println("date_operation date is null");
							}

							// date_valeur
							String date_valeur_str = resultList.get(7);
							Date date_valeur = null;
							if (date_valeur_str != null && !date_valeur_str.isEmpty()) {
							    try {
							        date_valeur = dateFormat.parse(date_valeur_str);
							    } catch (Exception e) {
							        e.printStackTrace(); // Handle parse exception
							    }
							} else {
							    System.out.println("date_valeur date is null");
							}

							// date_echeance
							String date_echeance_str = resultList.get(8);
							Date date_echeance = null;
							if (date_echeance_str != null && !date_echeance_str.isEmpty()) {
							    try {
							        date_echeance = dateFormat.parse(date_echeance_str);
							    } catch (Exception e) {
							        e.printStackTrace(); // Handle parse exception
							    }
							} else {
							    System.out.println("date_echeance date is null");
							}

							// preavis
							String preavis = "";
							if (resultList.get(9) != null && !resultList.get(9).isEmpty()) {
							    preavis = resultList.get(9);
							}

							// entite
							String entite = "";
							if (resultList.get(10) != null && !resultList.get(10).isEmpty()) {
							    entite = resultList.get(10);
							}

							// portefeuille
							String portefeuille = "";
							if (resultList.get(11) != null && !resultList.get(11).isEmpty()) {
							    portefeuille = resultList.get(11);
							}

							// contrepartie
							String contrepartie = "";
							if (resultList.get(12) != null && !resultList.get(12).isEmpty()) {
							    contrepartie = resultList.get(12);
							}

							// acct_no
							String acct_no = "";
							if (resultList.get(13) != null && !resultList.get(13).isEmpty()) {
							    acct_no = resultList.get(13);
							}

							// report_date
							String report_date_str = resultList.get(14);
							Date report_date = null;
							if (report_date_str != null && !report_date_str.isEmpty()) {
							    try {
							        report_date = dateFormat.parse(report_date_str);
							    } catch (Exception e) {
							        e.printStackTrace(); // Handle parse exception
							    }
							} else {
							    System.out.println("report_date date is null");
							}

							// acct_name
							String acct_name = "";
							if (resultList.get(15) != null && !resultList.get(15).isEmpty()) {
							    acct_name = resultList.get(15);
							}

							// acct_bal
							String acct_bal = resultList.get(16);
							BigDecimal acct_bal1 = null;
							if (acct_bal != null && !acct_bal.trim().isEmpty()) {
							    try {
							        acct_bal1 = new BigDecimal(acct_bal.trim());
							        System.out.println("The number as BigDecimal is: " + acct_bal1);
							    } catch (NumberFormatException e) {
							        System.err.println("The string does not contain a parsable number for acct_bal.");
							    }
							} else {
							    System.err.println("acct_bal is null or empty.");
							}

							// nre_status
							String nre_status = "";
							if (resultList.get(17) != null && !resultList.get(17).isEmpty()) {
							    nre_status = resultList.get(17);
							}

							// Creating the entity object
							Placement_Entity entity1 = new Placement_Entity(
							    num_operation1, entite_operation1, poste, titre, devise_1, nominal_1_value, date_operation, date_valeur, 
							    date_echeance, preavis, entite, portefeuille, contrepartie, acct_no, report_date, acct_name, acct_bal1, nre_status
							);

							System.out.println(entity1.getReport_date() + "entity");

							logger.info("saving values:");
							theSession.saveOrUpdate(entity1);
							theSession.flush();
							theSession.clear();
						}

						logger.info("inserted values into master_tb_manual_table");
					}

					status = "success";
				}
			} catch (Exception e) {
				e.printStackTrace();
				status = "failed";
			}
		}

		else {
			logger.info("reading values from CSV");

			try (CSVReader reader = new CSVReader(new FileReader(convertedFile.getAbsolutePath()), ',')) {
				String[] nextLine;
				int skipRow = 0;
				while ((nextLine = reader.readNext()) != null) {
					if (skipRow > 0) {
						try {
							String entity = nextLine[0];
							String acct_no = nextLine[1];
							String currency = nextLine[2];
							String amount = nextLine[3];
							String lcy = nextLine[4];
							String v_description = nextLine[5];
							String gl_freeze = nextLine[6];

							BLS0100Manual bls0100Manual = new BLS0100Manual(entity, userid, amount, lcy, v_description,
									gl_freeze, acct_no, currency, new Date());
							logger.info("saving values");
							theSession.save(bls0100Manual);
							theSession.flush();
							theSession.clear();
						} catch (ArrayIndexOutOfBoundsException e) {
							// Handle cases where the CSV row doesn't have enough columns
							logger.error("CSV row doesn't have enough columns: " + Arrays.toString(nextLine));
						} catch (NumberFormatException e) {
							// Handle cases where conversion to numbers fails
							logger.error("Failed to parse numeric values: " + Arrays.toString(nextLine));
						} catch (Exception e) {
							// Catch any other unexpected exceptions
							logger.error("Error processing CSV row: " + Arrays.toString(nextLine), e);
						}
					}
					skipRow++;
				}
				logger.info("inserted values into BLS0100_TREASURY_MANUAL_TB");
				status = "success";
			} catch (FileNotFoundException e) {
				// Handle file not found error
				logger.error("CSV file not found", e);
				status = "failed";
			} catch (IOException e) {
				// Handle IO exception
				logger.error("Error reading CSV file", e);
				status = "failed";
			}

		}

		return status;

	}

	private String validateUpload(String asondate, String fileName) {

		String errormsg = null;
		logger.info("before procedure call");

		Session theSession = sessionFactory.getCurrentSession();

		StoredProcedureQuery query = theSession.createStoredProcedureQuery("COMMON_VALIDATION_SP")
				.registerStoredProcedureParameter("FILE_NAME", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("REPORT_DATE", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("VALD_STATUS", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("ERROR_DTL", Clob.class, ParameterMode.OUT);

		logger.info("setting procedure variable");

		query.setParameter("FILE_NAME", fileName);
		query.setParameter("REPORT_DATE", asondate);

		logger.info("fileName--->>>" + fileName);
		logger.info("REPORT_DATE--->>>" + asondate);
		// logger.info("VALD_STATUS--->>>" + asondate);
		logger.info("executing");

		query.execute();

		logger.info("setting out variable");
		String validStatus = (String) query.getOutputParameterValue("VALD_STATUS");
		System.out.println("validStatus");
		Clob errorDtl = (Clob) query.getOutputParameterValue("ERROR_DTL");

		if (validStatus.equals("Y")) {
			errormsg = "success";
			logger.info(errormsg);

		} else {

			try {
				errormsg = errorDtl.getSubString(1, (int) errorDtl.length());
				System.out.println(errorDtl.length());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			logger.info(errormsg);
		}

		return errormsg;
	}
}
