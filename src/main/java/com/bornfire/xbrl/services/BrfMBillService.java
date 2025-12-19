package com.bornfire.xbrl.services;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.config.CompressFiles;
import com.bornfire.xbrl.entities.ArchDates;
import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryDetail;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryDetailId;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryReport;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryReportId;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_DETAIL;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_DETAIL_ID;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_ENTITY;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_History;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_MOD;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_REPORT;
import com.bornfire.xbrl.entities.M_BILL.BRF_M_BILL_REPORT_ID;
import com.bornfire.xbrl.entities.M_BILL.BrfMBillRep;
import com.monitorjbl.xlsx.StreamingReader;

import au.com.bytecode.opencsv.CSVReader;
import net.sf.jasperreports.engine.JRException;
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
public class BrfMBillService {

	private static final Logger logger = LoggerFactory.getLogger(BrfMBillService.class);

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
	
	@Autowired
	BrfMBillRep BrfMbill_Rep;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	
	public String getExportpath() {
		return exportpath;
	}

	public void setExportpath(String exportpath) {
		this.exportpath = exportpath;
	}

	public ModelAndView getBrfMBillView(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype,String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> brfmbillrep1 = new ArrayList<Object>();
		
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
			qr = hs.createNativeQuery("select * from table(BRF_M_BILL_RPT_TB bls0100_s1_rpt_fun(?1,?2,?3,?4,?5))");

			qr.setParameter(1, reportId);
			qr.setParameter(2, "0");
			qr.setParameter(3, reportDate);
			qr.setParameter(4, fromdate);
			qr.setParameter(5, todate);
			

		
		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery("select * from BRF_M_BILL_RPT_TB a where report_date = ?1 order by instance_code");
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

			BRF_M_BILL_REPORT_ID BRF_M_BILL_REPORT_ID = new BRF_M_BILL_REPORT_ID(instance_code, report_date);
			BRF_M_BILL_REPORT BRF_M_BILL_REPORT = new BRF_M_BILL_REPORT(BRF_M_BILL_REPORT_ID, report_id, from_date, to_date, version_no, currency,
					ref_code_desc, central_bank, banks, non_bnk, credit_unions, fin_gbc1, trusts_nr_gbc, insurance_corp,
					pension, investment, holding_comp, financial_aux, central_gov, state_loc_gov, non_finance_gbc, gbc2,
					public_non_fin_corp, oth_non_fin_corp, household, non_prof_institute, aff_nr, oth_nr, tot_lc,
					fc_central_bnk, fc_banks, fc_non_bnk, fc_credit_unions, fc_fin_gbc1, fc_trusts_nr_gbc,
					fc_insurance_corp, fc_pension, fc_investment, fc_holding_comp, fc_financial_aux, fc_central_gov,
					fc_state_loc_gov, fc_non_finance_gbc, fc_gbc2, fc_public_non_fin_corp, fc_oth_non_fin_corp,
					fc_household, fc_non_prof_institute, fc_aff_nr_bnk, fc_aff_nr_non_bnk, fc_oth_nr_bnk,
					fc_oth_nr_non_bnk, tot_fc, grand_tot);
			brfmbillrep1.add(BRF_M_BILL_REPORT);

		};

		List<Object> pagedlist;

		if (brfmbillrep1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, brfmbillrep1.size());
			pagedlist = brfmbillrep1.subList(startItem, toIndex);
		}
		logger.info("Converting to Page");
		Page<Object> brfmbillrep1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				brfmbillrep1.size());

		mv.setViewName(reportId + "/" + reportId);
		mv.addObject("secid", "1");
		mv.addObject("subreportid", "MBILL");
		mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("councodelist", refCodeConfig.councodelist());
		
		mv.addObject("reportsummary", brfmbillrep1Page);

		return mv;

	}

	public ModelAndView getBrfmbillrep1(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype,String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		//Session hs = sessionFactory.getCurrentSession();
		List<Object> Brfmbillrep1 = new ArrayList<>();

		if (subreportid.equals("MBILL") || subreportid == null) {

			Brfmbillrep1 = getMBILLRep(reportId, reportDate, fromdate, todate, currency, dtltype, subreportid);

			mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

		}
		List<Object> pagedlist;

		if (Brfmbillrep1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, Brfmbillrep1.size());
			pagedlist = Brfmbillrep1.subList(startItem, toIndex);
		}
		
		logger.info("Converting to Page");
		Page<Object> Brfmbillrep1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				Brfmbillrep1.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportsummary", Brfmbillrep1Page);

		return mv;

	}

	private List<Object> getMBILLRep(String reportId, String reportDate, String fromdate, String todate,
		 String dtltype, String subreportid, String secid) {
		Session hs = sessionFactory.getCurrentSession();
		List<Object> Brfmbillrep1 = new ArrayList<Object>();

		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
			qr = hs.createNativeQuery("select * from table(bls0100_s" + secid + "_rpt_fun(?1,?2,?3,?4,?5))");

			qr.setParameter(1, reportId);
			qr.setParameter(2, "0");
			qr.setParameter(3, reportDate);
			qr.setParameter(4, fromdate);
			qr.setParameter(5, todate);
			

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
				);

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

			BRF_M_BILL_REPORT_ID id = new BRF_M_BILL_REPORT_ID(instance_code,report_date );
			BRF_M_BILL_REPORT rep = new BRF_M_BILL_REPORT(id, report_id, from_date, to_date, version_no, curr,
					ref_code_desc, central_bank, banks, non_bnk, credit_unions, fin_gbc1, trusts_nr_gbc, insurance_corp,
					pension, investment, holding_comp, financial_aux, central_gov, state_loc_gov, non_finance_gbc, gbc2,
					public_non_fin_corp, oth_non_fin_corp, household, non_prof_institute, aff_nr, oth_nr, tot_lc,
					fc_central_bnk, fc_banks, fc_non_bnk, fc_credit_unions, fc_fin_gbc1, fc_trusts_nr_gbc,
					fc_insurance_corp, fc_pension, fc_investment, fc_holding_comp, fc_financial_aux, fc_central_gov,
					fc_state_loc_gov, fc_non_finance_gbc, fc_gbc2, fc_public_non_fin_corp, fc_oth_non_fin_corp,
					fc_household, fc_non_prof_institute, fc_aff_nr_bnk, fc_aff_nr_non_bnk, fc_oth_nr_bnk,
					fc_oth_nr_non_bnk, tot_fc, grand_tot);

			Brfmbillrep1.add(rep);

		}
		;

		return Brfmbillrep1;
	}
	private List<Object> getMBILLDetail(String reportId, String instanceCode, String reportDate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid) {

		Session hs = sessionFactory.getCurrentSession();
		List<Object> MBILLDtl = new ArrayList<Object>();
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

			String	num_compta	= (String) a[0];
			String	numero_piece	= (String) a[1];
			String	op_finance	= (String) a[2];
			String	op_evenement	= (String) a[3];
			String	compte	= (String) a[4];
			String	entite_groupe	= (String) a[5];
			String	tiers	= (String) a[6];
			String	description	= (String) a[7];
			String	entite_operation	= (String) a[8];
			String	poste	= (String) a[9];
			Date	date_compta	= (Date)  a[10];
			String	devise	= (String) a[11];
			String	montant	= (String) a[12];
			String	cours	= (String) a[13];
			String	contrevaleur	= (String) a[14];
			String	signe	= (String) a[15];
			String	devise_compta	= (String) a[16];
			String	entite	= (String) a[17];
			String	flag_od	= (String) a[18];
			String	description1	= (String) a[19];
			String	tri_1	= (String) a[20];
			String	tri_2	= (String) a[21];
			String	tri_3	= (String) a[22];
			String	type_instrument	= (String) a[23];
			String	standard	= (String) a[24];
			Date	report_date	= (Date)  a[25];
			String	 del_flg	= (String) a[26];
			String	rcre_user_id	= (String) a[27];
			String	rcre_time	= (String) a[28];
			String	lchg_user_id	= (String) a[29];
			String	lchg_time	= (String) a[30];
			String	verify_user_id	= (String) a[31];
			String	verify_time	= (String) a[32];


			BRF_M_BILL_DETAIL_ID id = new BRF_M_BILL_DETAIL_ID(numero_piece, report_date);

			BRF_M_BILL_DETAIL rep = new BRF_M_BILL_DETAIL(num_compta,numero_piece,op_finance	,
					op_evenement	,compte	,entite_groupe	,entite_groupe	,
					tiers	,description1	,entite_operation	,poste	,
					date_compta	,devise	,montant	,cours	,contrevaleur	,
					signe	,devise_compta	,entite	,flag_od	,
					description1	,tri_1	,tri_2	,tri_3	,
					type_instrument	,standard	,report_date	,del_flg	,
					rcre_user_id	,rcre_time	,lchg_user_id	,lchg_time	,
					verify_user_id	,verify_time);

			MBILLDtl.add(rep);

		}
		;

		return MBILLDtl;
	}

	public ModelAndView getBrfMbillDtl(String reportId, String instanceCode, String reportDate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable) {
		
		

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ModelAndView mv = new ModelAndView();

		List<Object> MbillDtl = new ArrayList<>();

		if (subreportid.equals("MBILL") || subreportid == null) {

			MbillDtl = getBrfMbillDtl(reportId, instanceCode, reportDate, fromdate, todate, currency, dtltype,
					subreportid, secid);

			mv.addObject("singledetail", new Object());
			mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

		}  
	List<Object> pagedlist;

	if (MbillDtl.size() < startItem) {
		pagedlist = Collections.emptyList();
	} else {
		int toIndex = Math.min(startItem + pageSize, MbillDtl.size());
		pagedlist = MbillDtl.subList(startItem, toIndex);
	}

	logger.info("Converting to Page");
	Page<Object> MbillDtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
			MbillDtl.size());

	mv.addObject("secid", secid);
	mv.addObject("subreportid", subreportid);
	mv.addObject("reportdetails", MbillDtlPage);

	return mv;
}


	private List<Object> getBrfMbillDtl(String reportId, String instanceCode, String reportDate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid) {
		// TODO Auto-generated method stub
		return null;
	}

	public File getFile(String reportId, String asondate, String fromdate, String todate, String currency,
			String subreportid, String secid, String dtltype, String filetype)
			throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String path = exportpath;
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);

		try {
			fileName = reportId + "_" + xbrlReportsMasterRep.getBankCode(reportId) + "_"
					+ dateFormat.format(new SimpleDateFormat("dd-MMM-yyyy").parse(asondate));

		} catch (ParseException e1) {

			logger.info(e1.getMessage());
			e1.printStackTrace();
		}

		zipFileName = path + "/" + fileName + ".zip";

		if (!filetype.equals("xbrl")) {

			try {
				File jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					jasperFile = ResourceUtils.getFile("classpath:static/jasper/SUP1500/SUP1500_DTL.jasper");
				} else {
					jasperFile = ResourceUtils.getFile("classpath:static/jasper/SUP1500/SUP1500.jasper");
				}

				JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_ID", reportId);
				map.put("VERSION_NO", "0");
				map.put("REPORT_DATE", asondate);
				map.put("FROM_DATE", fromdate);
				map.put("TO_DATE", todate);
				map.put("CRNCY_CODE", currency);
				map.put("TAXONOMY", xbrlReportsMasterRep.getTaxonomyVersion(reportId));
				map.put("REPORTING_FREQUENCY", xbrlReportsMasterRep.getReportFrq(reportId));

				File folders = new File(path);
				if (!folders.exists()) {
					folders.mkdirs();
				}

				if (filetype.equals("pdf")) {
					fileName = fileName + ".pdf";
					path = path + "/" + fileName;
					JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
					JasperExportManager.exportReportToPdfFile(jp, path);
					logger.info("PDF File exported");
				} else {
					fileName = fileName + ".xlsx";
					path = path + "/" + fileName;
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

		} else {

			Session hs = sessionFactory.getCurrentSession();
			try {

				File folders = new File(path);
				if (!folders.exists()) {
					folders.mkdirs();
				}

				fileName = fileName + ".xml";
				path = path + "/" + fileName;

				Query qr = hs.createNativeQuery(
						"SELECT a.xbrl_rpt.getClobVal() as xbrl FROM SUP1500_XBRL_OUTPUT a where a.report_date=?1");

				qr.setParameter(1, asondate);
				logger.info("Getting XBRL File");
				Clob clob = (Clob) qr.getSingleResult();

				Reader reader = clob.getCharacterStream();
				FileWriter fileWriter = new FileWriter(path);
				int i;
				while ((i = reader.read()) != -1) {
					fileWriter.write((char) i);
				}
				fileWriter.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		if (filetype.equals("xbrl")) {
			logger.info("Compressing XBRL File");
			CompressFiles.zipSingleFile(new File(path), zipFileName);
			outputFile = new File(zipFileName);
		} else {
			outputFile = new File(path);
		}

		return outputFile;

	}

	public String detailChanges(BRF_M_BILL_DETAIL detail, String changeType, String userid) {

		String msg = "";

		try {
			BRF_M_BILL_MOD mod = new BRF_M_BILL_MOD(detail);

			mod.setDel_flg(changeType);
			mod.setLchg_user_id(userid);
			mod.setLchg_time(new Date());

			Session hs = sessionFactory.getCurrentSession();
			
		
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
					.createQuery("select count(*) from BRF_M_BILL_ENTITY a where a.BRF_M_BILL_ID.report_date=?1")
					.setParameter(1, dt).getSingleResult();

			if (dtlcnt > 0) {	 
					msg = "success";			
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
		List<BRF_M_BILL_MOD> BRF_M_BILL_MOD = hs.createQuery("from BRF_M_BILL_MOD", BRF_M_BILL_MOD.class).getResultList();
		
		List<BRF_M_BILL_MOD> pagedlist;

		if (BRF_M_BILL_MOD.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BRF_M_BILL_MOD.size());
			pagedlist = BRF_M_BILL_MOD.subList(startItem, toIndex);
		}

		logger.info("Pagination of Mod data");
		Page<BRF_M_BILL_MOD> BRF_FORWARD_REVEAL_MODPage = new PageImpl<BRF_M_BILL_MOD>(pagedlist, PageRequest.of(currentPage, pageSize),
				BRF_M_BILL_MOD.size());


		mv.setViewName(reportId + "/" + reportId + "Verify");
		mv.addObject("ModData", BRF_FORWARD_REVEAL_MODPage);
		mv.addObject("singleMod", new BRF_M_BILL_MOD());

		return mv;
	}

	public String verifyChanges(BRF_M_BILL_MOD moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BRF_M_BILL_MOD mod = hs.find(BRF_M_BILL_MOD.class, moddata.getBRF_M_BILL_MOD_ID());
			mod.setLchg_user_id(userid);
			mod.setLchg_time(new Date());
			hs.flush();
			
			BRF_M_BILL_DETAIL detail = new BRF_M_BILL_DETAIL(mod);
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

	public String RejectChanges(BRF_M_BILL_MOD moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BRF_M_BILL_MOD mod = hs.find(BRF_M_BILL_MOD.class, moddata.getBRF_M_BILL_MOD_ID());
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

	
public List<ArchDates> getArchRepDates(String reportid) {
		
		Session hs = sessionFactory.getCurrentSession();

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		List<Object[]> result = hs.createQuery(
				"select distinct a.BRF_M_BILL_ID.report_date, a.from_date, a.to_date from BRF_FORWARD_REVEAL_MANUAL_ENTITY a ")
				.getResultList();

		List<ArchDates> archDates = new ArrayList<ArchDates>();

		for (Object[] a : result) {

			Date report_date = (Date) a[0];
			Date from_date = (Date) a[1];
			Date to_date = (Date) a[2];

			archDates.add(new ArchDates(df.format(report_date), df.format(from_date), df.format(to_date)));

		};

		return archDates;
	}


	public ModelAndView getSearchDetails(String reportId, String instancecode, String asondate, String fromdate,
			String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable,
			BRF_M_BILL_DETAIL detail) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BrfMbillDtl = new ArrayList<Object>();

		BRF_M_BILL_DETAIL dtl;

		if (dtltype.equals("report")) {
			dtl = hs.find(BRF_M_BILL_DETAIL.class, detail.getBRF_M_BILL_DETAIL_ID());
			
			
		} else {
			BRF_M_BILL_History hist = hs.find(BRF_M_BILL_History.class, detail.getBRF_M_BILL_DETAIL_ID());
			dtl = new BRF_M_BILL_DETAIL(hist);
		}

		if (dtl == null) {

			mv.addObject("searchmsg", "No Data Available");

		}

		BrfMbillDtl.add(dtl);

		List<Object> pagedlist;

		if (BrfMbillDtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BrfMbillDtl.size());
			pagedlist = BrfMbillDtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BrfMbillDtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BrfMbillDtl.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportdetails", BrfMbillDtlPage);
		mv.addObject("singledetail", new BRF_M_BILL_DETAIL());

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

		Long cnt1 = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from BRF_M_BILL_REPORT where BRF_M_BILL_REPORT_ID.report_date=?1")
				.setParameter(1, repDate).getSingleResult();

		if (cnt1 > 0) {
			msg = "Data Already available for the Report. Do you want to Replace?";
		} else {
			msg = "success";
		}

		return msg;
	}
	
	public String processUpload(String asondate, MultipartFile[] files, String userid)
			throws SQLException, FileNotFoundException, IOException {

		String result = "";

		String status = "";
		logger.info("processing BRF_MBILL file");

		MultipartFile uploadedFile = files[0];

		logger.info("uploaded file name:" + uploadedFile.getOriginalFilename() + "asondate:" + asondate + "userid:"
				+ userid);

		result = BRF_M_BILLUpload(uploadedFile, asondate, userid);
		if (result.equals("success")) {
			status = validateUpload(asondate, "BRFMBILL");
		}

		return status;
	}
		
		
	public static File multipartToFile(MultipartFile multipart, String fileName)
			throws IllegalStateException, IOException {
		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		multipart.transferTo(convFile);
		return convFile;
	}
	
	public String BRF_M_BILLUpload(MultipartFile file, String asondate, String userid)
			throws SQLException, FileNotFoundException, IOException {

		logger.info("BRFMbillReportServices->BRF_M_BILLUpload()");
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

		logger.info("truncating table: BRF_MATURITY_BILL_MANUAL_TABLE");

		Session theSession = sessionFactory.getCurrentSession();
		theSession.createSQLQuery(" truncate table BRF_MATURITY_BILL_MANUAL_TABLE ").executeUpdate();
		

		logger.info("BRF_MATURITY_BILL_MANUAL_TABLE truncated");

		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {
			
			logger.info("reading values from Excel");

			String cellval = "";

			try (InputStream is = new FileInputStream(convertedFile);

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(is)) {
				
				
				
				for (Sheet s : workbook) {
					
					int sheetNumber = workbook.getSheetIndex(s);
					if(sheetNumber == 0 ) {
			
					logger.info("inside workbook");
					
					for (Row r : s) {
									
						ArrayList<String> resultList = new ArrayList<>();
						if (r.getRowNum() == 0) {
							continue;
						}

						cellval = "";
						String val = null;
						for (int j = 0; j < 36; j++) {
							Cell cell = r.getCell(j);
							if (cell == null || cell.getStringCellValue().length() == 0) {
								val = null;
							} else {
								val = cell.getStringCellValue();
							
							}
							resultList.add(val);

						}

						 //String	poste = resultList.get(0);
						// String	treasury_bills_trade = resultList.get(1);
						// String value_date = resultList.get(2);
						 
						 //String num_operation = null;
						 //String gl_values= null;
						// if( resultList.get(1) == null || resultList.get(1)=="") {
						//	 System.out.println("hii");
						// }
						// else {
							//  num_operation = resultList.get(1);
		                  //    gl_values = resultList.get(2);

						// }

						 
					//	 NUM_OPERATION	GL_VALUES	OP_REFERENCE	POSTE	DEALDATE	VALUEDATE	MATURITYDATE	CURRENCY1	CURRENCY2	NOMINAL_1	RAMOUNT	NO_OF_DAYS	AMOUNT1	DEALRATE	AMOUNT2	REVAL_RATE	REVAL_AMOUNT	PROFITLOSS	CONTREPARTIE	BRANCH_CODE	LCYRATE	LCYPROFITLOSS
						String	num_compta		=	resultList.get(0)	;
						String	numero_piece		=	resultList.get(1)	;
						String	op_finance	=	resultList.get(2)	;
						String	op_evenement		=	resultList.get(3)	;
						String	compte		=	resultList.get(4)	;
						String	entite_groupe	=	resultList.get(5)	;
						String	tiers		=	resultList.get(6)	;
						String	description		=	resultList.get(7)	;
						String	entite_operation		=	resultList.get(8)	;
						String	poste		=	resultList.get(9)	;
						String	date_compta		=	resultList.get(10)	;
						String	devise	=	resultList.get(11)	;
						String	montant		=	resultList.get(12)	;
						String	cours	=	resultList.get(13)	;
						String	contrevaleur		=	resultList.get(14)	;
						String	signe	=	resultList.get(15)	;
						String	devise_compta=	resultList.get(16)	;
						String	entite=	resultList.get(17)	;
						String	flag_od		=	resultList.get(18)	;
						String	tri_1		=	resultList.get(19)	;
						String	tri_2		=	resultList.get(20)	;
						String	tri_3		=	resultList.get(21)	;
						String	type_instrument		=	resultList.get(22)	;
						String	standard	=	resultList.get(23)	;
						String	report_date		=	resultList.get(24)	;
						String	entry_user		=	resultList.get(25)	;
						//String	entry_time		=	resultList.get(26)	;
						String	modify_user		=	resultList.get(26)	;
					//	String	modify_time		=	resultList.get(28)	;
						String	verify_user		=	resultList.get(27)	;
				//		String	verify_time		=	resultList.get(30)	;
						String	del_flg	=	resultList.get(28)	;
						String	entity_flg	=	resultList.get(29)	;
						String	modify_flg		=	resultList.get(30)	;

						 
                       	 if(num_compta == null) {
									 logger.info("break -> due to null value");
									 break;
								 }
                       	BRF_M_BILL_ENTITY Brf_M_BILL_ENTITY = new BRF_M_BILL_ENTITY(num_compta,numero_piece,op_finance,op_evenement,
                       			compte,entite_groupe,tiers,description,entite_operation,poste,date_compta,devise,montant,cours,contrevaleur,
                       			signe,devise_compta,entite,flag_od,tri_1,tri_2,tri_3,type_instrument,standard,report_date,entry_user,modify_user,verify_user,del_flg,entity_flg,modify_flg,new Date());
	//	 NUM_OPERATION	GL_VALUES	OP_REFERENCE	POSTE	DEALDATE	VALUEDATE	MATURITYDATE	CURRENCY1	CURRENCY2	NOMINAL_1	AMOUNT	NO_OF_DAYS	AMOUNT1	
	//DEALRATE	AMOUNT2	REVAL_RATE	REVAL_AMOUNT	PROFITLOSS	CONTREPARTIE	BRANCH_CODE	LCYRATE	LCYPROFITLOSS
					
								// BRF_FORWARD_REVEAL_MANUAL_ENTITY Brf_FORWARD_REVEAL_MANUAL_ENTITY1 = new BRF_FORWARD_REVEAL_MANUAL_ENTITY();								
                      // 	BRF_M_BILL_ENTITY Brf_M_BILL_ENTITY1 = new BRF_M_BILL_ENTITY();
                       	Brf_M_BILL_ENTITY.setNum_compta	(resultList.get(0));
                       	Brf_M_BILL_ENTITY.setNumero_piece	(resultList.get(1));
                       	Brf_M_BILL_ENTITY.setOp_finance	(resultList.get(2));
                       	Brf_M_BILL_ENTITY.setOp_evenement	(resultList.get(3));
                       	Brf_M_BILL_ENTITY.setCompte	(resultList.get(4));
                       	Brf_M_BILL_ENTITY.setEntite_groupe(resultList.get(5));
                       	Brf_M_BILL_ENTITY.setTiers(resultList.get(6));
                       	Brf_M_BILL_ENTITY.setDescription(resultList.get(7));
                       	Brf_M_BILL_ENTITY.setEntite_operation(resultList.get(8));
                       	Brf_M_BILL_ENTITY.setPoste(resultList.get(9));
                       	Brf_M_BILL_ENTITY.setDate_compta(resultList.get(10));
                       	Brf_M_BILL_ENTITY.setDevise(resultList.get(11));
                       	Brf_M_BILL_ENTITY.setMontant(resultList.get(12));
                       	Brf_M_BILL_ENTITY.setCours(resultList.get(13));
                       	Brf_M_BILL_ENTITY.setContrevaleur(resultList.get(14));
                       	Brf_M_BILL_ENTITY.setSigne(resultList.get(15));
                       	Brf_M_BILL_ENTITY.setDevise_compta	(resultList.get(16));
                       	Brf_M_BILL_ENTITY.setEntite(resultList.get(17));
                       	Brf_M_BILL_ENTITY.setFlag_od(resultList.get(18));
                       	Brf_M_BILL_ENTITY.setTri_1	(resultList.get(19));
                       	Brf_M_BILL_ENTITY.setTri_2	(resultList.get(20));
                       	Brf_M_BILL_ENTITY.setTri_3(resultList.get(21));
                       	Brf_M_BILL_ENTITY.setType_instrument(resultList.get(22));
                       	Brf_M_BILL_ENTITY.setStandard(resultList.get(23));
                       	Brf_M_BILL_ENTITY.setReport_date(resultList.get(24));
                       	
									  // Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
									  //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1)); //
								  // Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
									  
									 	
                       	BrfMbill_Rep.save(Brf_M_BILL_ENTITY);
								 
								 
						// System.out.println(Brf_FORWARD_REVEAL_MANUAL_ENTITY.toString());
						 logger.info("saving values:");
						//theSession.saveOrUpdate(Brf_FORWARD_REVEAL_MANUAL_ENTITY);
						theSession.flush();
						theSession.clear();
					}

					logger.info("inserted values into BRF_MATURITY_BILL_MANUAL_TABLE");
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

			try {

				CSVReader reader = new CSVReader(new FileReader(convertedFile.getAbsolutePath()), ',');
				String[] nextLine;
				int skipRow = 0;
				while ((nextLine = reader.readNext()) != null) {

					if (skipRow > 0) {

						//String	treasury_bills_bank = nextLine[0];
						// String	treasury_bills_trade = nextLine[1];
						// String	report_date = nextLine[2];
						 
						String 	num_compta	=	nextLine[0];
						String 	numero_piece	=	nextLine[1];
						String 	op_finance	=	nextLine[2];
						String 	op_evenement	=	nextLine[3];
						String 	compte	=	nextLine[4];
						String 	entite_groupe	=	nextLine[5];
						String 	tiers	=	nextLine[6];
						String 	description	=	nextLine[7];
						String 	entite_operation	=	nextLine[8];
						String 	poste	=	nextLine[9];
						String 	date_compta	=	nextLine[10];
						String 	devise	=	nextLine[11];
						String 	montant	=	nextLine[12];
						String 	cours	=	nextLine[13];
						String 	contrevaleur	=	nextLine[14];
						String 	signe	=	nextLine[15];
						String 	devise_compta	=	nextLine[16];
						String 	entite	=	nextLine[17];
						String 	flag_od	=	nextLine[18];
						String 	tri_1	=	nextLine[19];
						String 	tri_2	=	nextLine[20];
						String 	tri_3	=	nextLine[21];
						String 	type_instrument	=	nextLine[22];
						String 	standard	=	nextLine[23];
						String 	report_date	=	nextLine[24];
						String 	entry_user=	nextLine[25];
						String 	modify_user=nextLine[26];
						String 	verify_user=nextLine[27];
						String 	del_flg=nextLine[28];
						String 	entity_flg=nextLine[29];
						String 	modify_flg=nextLine[30];

					
								 if(report_date == null) {
									 logger.info("break -> due to null value");
									 break;
								 }
								 
								// BRF_FORWARD_REVEAL_MANUAL_ID bRF_FORWARD_REVEAL_MANUAL_ID = new BRF_FORWARD_REVEAL_MANUAL_ID(num_operation,report_date);
								 BRF_M_BILL_ENTITY Brf_M_BILL_ENTITY = new BRF_M_BILL_ENTITY(num_compta,numero_piece,op_finance,
										 op_evenement	,compte	,entite_groupe	, tiers	,
										 description	,entite_operation	,poste	,date_compta	,
										 devise	, montant	, cours	, contrevaleur	,signe	,
										 devise_compta	,entite	, flag_od	, tri_1	,
										 tri_2	, tri_3	,type_instrument	,standard	,report_date,
										 entry_user,modify_user,verify_user,del_flg,entity_flg,modify_flg,new Date());
								
								 
								// Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setId(123); // Manually assign the identifier
								 // Set other attributes of the entity
								// session.save(entity); // Save the entity
								 //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(num_operation);
								 logger.info("saving values");
								 
						theSession.save(Brf_M_BILL_ENTITY);
						theSession.flush();
						theSession.clear();
					}
					skipRow++;
				}
				// theSession.saveOrUpdate(sup1000ManualS1List);
				logger.info("inserted values into BRFMbill_MANUAL_TABLE");
				status = "success";
			} catch (Exception e) {
				e.printStackTrace();
				status = "failed";
			}

		}

		return status;

	}

	private String validateUpload (String asondate, String fileName) {

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
		logger.info("fileName--->>>"+fileName);
		logger.info("REPORT_DATE--->>>" + asondate);
		logger.info("executing");

		query.execute();

		logger.info("setting out variable");
		String validStatus = (String) query.getOutputParameterValue("VALD_STATUS");
		Clob errorDtl = (Clob) query.getOutputParameterValue("ERROR_DTL");

		if (validStatus.equals("Y")) {
			System.out.println("HII");
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