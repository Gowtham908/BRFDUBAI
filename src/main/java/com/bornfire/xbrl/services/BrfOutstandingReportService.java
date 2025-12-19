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
import com.bornfire.xbrl.entities.BLS0100.BLS0100Detail;
import com.bornfire.xbrl.entities.BLS0100.BLS0100DetailId;
import com.bornfire.xbrl.entities.BLS0100.BLS0100RepId;
import com.bornfire.xbrl.entities.BLS0100.BLS0100Report;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntity;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryDetail;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryDetailId;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryHistory;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryManual;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryMod;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryReport;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingEntryReportId;
import com.bornfire.xbrl.entities.BrfOutstandingEntries.BrfOutstandingREP;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALDetail;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALDetail_Id;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALReport;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEALReport_Id;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_History;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_MANUAL_ENTITY;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_MANUAL_ID;
import com.bornfire.xbrl.entities.FWD_REVEAL.BRF_FORWARD_REVEAL_MOD;
import com.bornfire.xbrl.entities.FWD_REVEAL.Brf_FORWARD_REVEAL_MANUAL_REP;
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
public class BrfOutstandingReportService {

	private static final Logger logger = LoggerFactory.getLogger(BrfOutstandingReportService.class);

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
	BrfOutstandingREP BrfOutstandingrep;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	
	public String getExportpath() {
		return exportpath;
	}

	public void setExportpath(String exportpath) {
		this.exportpath = exportpath;
	}

	public ModelAndView getBrfOutstandingView(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype,String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BrfOutstandingRep = new ArrayList<Object>();
		
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
			qr = hs.createNativeQuery("select * from table(BRF_OUTSTANDING_ENTRIES_RPT_TB bls0100_s1_rpt_fun(?1,?2,?3,?4,?5))");

			qr.setParameter(1, reportId);
			qr.setParameter(2, "0");
			qr.setParameter(3, reportDate);
			qr.setParameter(4, fromdate);
			qr.setParameter(5, todate);
			

		
		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery("select * from BRF_OUTSTANDING_ENTRIES_RPT_TB a where report_date = ?1 order by instance_code");
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

			BrfOutstandingEntryReportId id = new BrfOutstandingEntryReportId(instance_code, report_date);
			BrfOutstandingEntryReport rep = new BrfOutstandingEntryReport(id, report_id, from_date, to_date, version_no, currency,
					ref_code_desc, central_bank, banks, non_bnk, credit_unions, fin_gbc1, trusts_nr_gbc, insurance_corp,
					pension, investment, holding_comp, financial_aux, central_gov, state_loc_gov, non_finance_gbc, gbc2,
					public_non_fin_corp, oth_non_fin_corp, household, non_prof_institute, aff_nr, oth_nr, tot_lc,
					fc_central_bnk, fc_banks, fc_non_bnk, fc_credit_unions, fc_fin_gbc1, fc_trusts_nr_gbc,
					fc_insurance_corp, fc_pension, fc_investment, fc_holding_comp, fc_financial_aux, fc_central_gov,
					fc_state_loc_gov, fc_non_finance_gbc, fc_gbc2, fc_public_non_fin_corp, fc_oth_non_fin_corp,
					fc_household, fc_non_prof_institute, fc_aff_nr_bnk, fc_aff_nr_non_bnk, fc_oth_nr_bnk,
					fc_oth_nr_non_bnk, tot_fc, grand_tot);
			
			BrfOutstandingRep.add(rep);

		};

		List<Object> pagedlist;

		if (BrfOutstandingRep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BrfOutstandingRep.size());
			pagedlist = BrfOutstandingRep.subList(startItem, toIndex);
		}
		logger.info("Converting to Page");
		Page<Object> BrfOutstandingRepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BrfOutstandingRep.size());

		mv.setViewName(reportId + "/" + reportId);
		mv.addObject("subreportid", "BRFOUTSTANDING");
		mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("councodelist", refCodeConfig.councodelist());
		
		mv.addObject("reportsummary", BrfOutstandingRepPage);

		return mv;

	}

	/*public ModelAndView BrfOutstandingRep(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype,String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BrfOutstandingRep = new ArrayList<Object>();
		
		Query<Object[]> qr;

		if (dtltype.equals("report")) {
			logger.info("Inside report");
		
		qr = hs.createNativeQuery("select * from BRF_OUTSTANDING_ENTRIES_RPT_TB a where report_date = ?1 ");
		qr.setParameter(1, reportDate);
	

		} else {

			logger.info("Inside archive");
			qr = hs.createNativeQuery("select * from BRF_OUTSTANDING_ENTRIES_RPT_TB a where report_date = ?1 ");
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
			String instance_name = (String) a[5];
			BigDecimal instance_code = (BigDecimal) a[6];
			BigDecimal resident = (BigDecimal) a[7];
			BigDecimal non_resident = (BigDecimal) a[8];
			BigDecimal total = (BigDecimal) a[9];


			
			
			BrfOutstandingEntryReportId BrfOutstandingEntryReportId = new BrfOutstandingEntryReportId(instance_code, report_date);
			BrfOutstandingEntryReport BrfOutstandingEntryReport = new BrfOutstandingEntryReport(BrfOutstandingEntryReportId, 
										report_id, from_date, to_date, version_no, instance_name, 
										resident, non_resident, total);
			
			BrfOutstandingRep.add(BrfOutstandingEntryReport);


		}
		;

		List<Object> pagedlist;

		if (BrfOutstandingRep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BrfOutstandingRep.size());
			pagedlist = BrfOutstandingRep.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BrfOutstandingRepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BrfOutstandingRep.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportsummary", BrfOutstandingRepPage);

		return mv;

	}*/
	public ModelAndView getBrfOutstandingRep(String reportId, String reportDate, String fromdate, String todate,
			String currency, String dtltype, String subreportid, String secid, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		List<Object> BrfOutstandingRep = new ArrayList<>();

		if (subreportid.equals("BrfOutstanding") || subreportid == null) {

			BrfOutstandingRep = getBrfOutstandingRep(reportId, reportDate, fromdate, todate, currency, dtltype, subreportid);

			mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

		}

		List<Object> pagedlist;

		if (BrfOutstandingRep.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BrfOutstandingRep.size());
			pagedlist = BrfOutstandingRep.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BrfOutstandingRepPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BrfOutstandingRep.size());

		mv.addObject("secid", secid);
		mv.addObject("subreportid", subreportid);
		mv.addObject("reportsummary", BrfOutstandingRepPage);

		return mv;

	}


		

		private List<Object> getBrfOutstandingRep(String reportId, String reportDate, String fromdate, String todate,
			 String dtltype, String subreportid, String secid) {
			Session hs = sessionFactory.getCurrentSession();
			List<Object> brfOutstandingRep = new ArrayList<Object>();

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

				BrfOutstandingEntryReportId id = new BrfOutstandingEntryReportId(report_date, instance_code);
				BrfOutstandingEntryReport rep = new BrfOutstandingEntryReport(id, report_id, from_date, to_date, version_no, curr,
						ref_code_desc, central_bank, banks, non_bnk, credit_unions, fin_gbc1, trusts_nr_gbc, insurance_corp,
						pension, investment, holding_comp, financial_aux, central_gov, state_loc_gov, non_finance_gbc, gbc2,
						public_non_fin_corp, oth_non_fin_corp, household, non_prof_institute, aff_nr, oth_nr, tot_lc,
						fc_central_bnk, fc_banks, fc_non_bnk, fc_credit_unions, fc_fin_gbc1, fc_trusts_nr_gbc,
						fc_insurance_corp, fc_pension, fc_investment, fc_holding_comp, fc_financial_aux, fc_central_gov,
						fc_state_loc_gov, fc_non_finance_gbc, fc_gbc2, fc_public_non_fin_corp, fc_oth_non_fin_corp,
						fc_household, fc_non_prof_institute, fc_aff_nr_bnk, fc_aff_nr_non_bnk, fc_oth_nr_bnk,
						fc_oth_nr_non_bnk, tot_fc, grand_tot);

				brfOutstandingRep.add(rep);

			}
			;

			return brfOutstandingRep;
		}

		private List<Object> getBrfOutstandingDetail(String reportId, String instanceCode, String reportDate, String fromdate,
				String todate, String currency, String dtltype, String subreportid, String secid) {

			Session hs = sessionFactory.getCurrentSession();
			List<Object> brfOutstandingDtl = new ArrayList<Object>();
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

				String nostor_code = (String) a[0];
				String type = (String) a[1];
				String bucket = (String) a[2];
				String days = (String) a[3];
				String num_operation = (String) a[4];
				String date_import = (String) a[5];
				String date_operation = (String) a[6];
				String date_valeur = (String) a[7];
				Date amount = (Date) a[8];
				BigDecimal devise = (BigDecimal) a[9];
				String poste = (String) a[10];
				String tiers = (String) a[11];
				String op_finance = (String) a[12];
				String groupe1 = (String) a[13];
				String groupe2 = (String) a[14];
				String groupe3 = (String) a[15];
				String corresp_sender1 = (String) a[16];
				String corresp_sender2 = (String) a[17];
				Date report_date = (Date) a[18];
				Character del_flg = (Character) a[19];
				String rcre_user_id = (String) a[20];
				Date rcre_time = (Date) a[21];
				String lchg_user_id = (String) a[22];
				Date lchg_time = (Date) a[23];
				String verify_user_id = (String) a[24];
				Date verify_time = (Date) a[25];

				BrfOutstandingEntryDetailId id = new BrfOutstandingEntryDetailId(num_operation, report_date);

				BrfOutstandingEntryDetail rep = new BrfOutstandingEntryDetail(nostor_code, type, bucket, days, num_operation, date_import, date_operation,
						date_valeur, amount, devise, poste,tiers,op_finance,groupe1,groupe2,groupe3,corresp_sender1,corresp_sender2,report_date,del_flg, rcre_user_id, rcre_time, lchg_user_id, lchg_time,
						verify_user_id, verify_time);

				brfOutstandingDtl.add(rep);

			}
			;

			return brfOutstandingDtl;
		}

		

		public ModelAndView getBrfOutstandingDtl(String reportId, String instanceCode, String reportDate, String fromdate,
				String todate, String currency, String dtltype, String subreportid, String secid, Pageable pageable) {

			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;

			ModelAndView mv = new ModelAndView();

			List<Object> BrfOutstandingDtl = new ArrayList<>();

			if (subreportid.equals("BLS0100") || subreportid == null) {

				BrfOutstandingDtl = getBrfOutstandingEntryDetail(reportId, instanceCode, reportDate, fromdate, todate, currency, dtltype,
						subreportid, secid);

				mv.addObject("singledetail", new Object());
				mv.setViewName(reportId + "/" + reportId + ":: reportcontent");

			}  
		List<Object> pagedlist;

		if (BrfOutstandingDtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BrfOutstandingDtl.size());
			pagedlist = BrfOutstandingDtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BrfOutstandingDtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BrfOutstandingDtl.size());

		mv.addObject("secid", secid);
		mv.addObject("subreportid", subreportid);
		mv.addObject("reportdetails", BrfOutstandingDtlPage);

		return mv;
	}

	

	private List<Object> getBrfOutstandingEntryDetail(String reportId, String instanceCode, String reportDate,
				String fromdate, String todate, String currency, String dtltype, String subreportid, String secid) {
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

	public String detailChanges(BrfOutstandingEntryDetail detail, Character changeType, String userid) {

		String msg = "";

		try {
			BrfOutstandingEntryMod mod = new BrfOutstandingEntryMod(detail);


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
			////dt = new SimpleDateFormat("dd-MM-yyyy").parse(asondate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs
					.createQuery("select count(*) from BRF_OUTSTANDING_ENTRIES_MANUAL_TABLE a where a.BrtOustanding_ID.report_date=?1")
					.setParameter(1,new Date()).getSingleResult();

			if (dtlcnt > 0) {	 
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt1 = (Long) hs.createQuery("select count(*) from BrfOutstandingEntryMod a").getSingleResult();
				Long modcnt2 = (Long) hs.createQuery("select count(*) from BrfOutstandingEntryMod a").getSingleResult();
				Long modcnt3 = (Long) hs.createQuery("select count(*) from BrfOutstandingEntryMod a").getSingleResult();
				if (modcnt1 > 0 || modcnt2 > 0 || modcnt3 > 0) {
					msg = "Records Pending for Verification For the Report";
				} else {
					msg = "success";
				}
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
		List<BrfOutstandingEntryMod> brfOutstandingMod = hs.createQuery("from BrfOutstandingEntryMod", BrfOutstandingEntryMod.class).getResultList();
		
		List<BrfOutstandingEntryMod> pagedlistbrfOutstanding;

		if (brfOutstandingMod.size() < startItem) {
			pagedlistbrfOutstanding = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, brfOutstandingMod.size());
			pagedlistbrfOutstanding = brfOutstandingMod.subList(startItem, toIndex);
		}

		logger.info("Pagination of Mod data");
		Page<BrfOutstandingEntryMod> BrfOutstandingEntryModPage = new PageImpl<BrfOutstandingEntryMod>(pagedlistbrfOutstanding, PageRequest.of(currentPage, pageSize),
				brfOutstandingMod.size());

logger.info("Pagination of Mod data");
		
/******************************************
 * bls0140 pagination
 ************************************/
	
		logger.info("Pagination of Mod data");
		mv.setViewName(reportId + "/" + reportId + "Verify");
		mv.addObject("ModData", BrfOutstandingEntryModPage);
		mv.addObject("singleModBrfOutstandingMod", new BrfOutstandingEntryMod());

		return mv;
	}

	public String verifyChanges(BrfOutstandingEntryMod moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BrfOutstandingEntryMod mod = hs.find(BrfOutstandingEntryMod.class, moddata.getBrfOutstandingEntryMod_Id());
			mod.setVerify_user_id(userid);
			mod.setVerify_time(new Date());
			hs.flush();
			
			BrfOutstandingEntryDetail detail = new BrfOutstandingEntryDetail(mod);
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

	public String RejectChanges(BrfOutstandingEntryMod moddata, String userid) {

		String msg = "";

		Session hs = sessionFactory.getCurrentSession();

		try {
			BrfOutstandingEntryMod mod = hs.find(BrfOutstandingEntryMod.class, moddata.getBrfOutstandingEntryMod_Id());
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
				"select distinct a.BrtOustanding_ID.report_date, a.from_date, a.to_date from BrfOutstandingEntity a ")
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
			BrfOutstandingEntryDetail detail) {

		ModelAndView mv = new ModelAndView();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		Session hs = sessionFactory.getCurrentSession();
		List<Object> BrfOutstandingDtl = new ArrayList<Object>();

		BrfOutstandingEntryDetail dtl;

		if (dtltype.equals("report")) {
			dtl = hs.find(BrfOutstandingEntryDetail.class, detail.getBrfOutstandingEntryDetailId());
			
			
		} else {
			BrfOutstandingEntryHistory hist = hs.find(BrfOutstandingEntryHistory.class, detail.getBrfOutstandingEntryDetailId());
			dtl = new BrfOutstandingEntryDetail(hist);
		}

		if (dtl == null) {

			mv.addObject("searchmsg", "No Data Available");

		}

		BrfOutstandingDtl.add(dtl);

		List<Object> pagedlist;

		if (BrfOutstandingDtl.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, BrfOutstandingDtl.size());
			pagedlist = BrfOutstandingDtl.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> BrfOutstandingDtlPage = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize),
				BrfOutstandingDtl.size());

		mv.setViewName(reportId + "/" + reportId + ":: reportcontent");
		mv.addObject("reportdetails", BrfOutstandingDtlPage);
		mv.addObject("singledetail", new BrfOutstandingEntryDetail());

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
				.createQuery("select count(*) from BrfOutstandingEntity where num_operation=?1")
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
		logger.info("processing BRF_OUTSTANDING_MANUAL file");

		MultipartFile uploadedFile = files[0];

		logger.info("uploaded file name:" + uploadedFile.getOriginalFilename() + "asondate:" + asondate + "userid:"
				+ userid);

		result = BrfOutstandingUpload(uploadedFile, asondate, userid);
		if (result.equals("success")) {
			status = validateUpload(asondate, "BRFOUTSTANDING");
		}

		return status;
	}
	
	public static File multipartToFile(MultipartFile multipart, String fileName)
			throws IllegalStateException, IOException {
		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		multipart.transferTo(convFile);
		return convFile;
	}
	
	public String BrfOutstandingUpload(MultipartFile file, String asondate, String userid)
			throws SQLException, FileNotFoundException, IOException {

		logger.info("BrfOutstandingReportServices->BrfOutstandingUpload()");
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

		logger.info("truncating table: BRF_OUTSTANDING_ENTRIES_MANUAL_TABLE");

		Session theSession = sessionFactory.getCurrentSession();
		theSession.createSQLQuery(" truncate table BRF_OUTSTANDING_ENTRIES_MANUAL_TABLE ").executeUpdate();
		

		logger.info("BRF_OUTSTANDING_ENTRIES_MANUAL_TABLE truncated");

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
						for (int j = 0; j < 30; j++) {
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

						 String 	nostor_code	=	resultList.get(0);
						 String 	type	=	resultList.get(1);
						 String     bucket	=	resultList.get(2);
						 String 	days	=	resultList.get(3);
						 String 	num_operation	=	resultList.get(4);
						 String 	date_import	=	resultList.get(5);
						 String 	date_operation	=	resultList.get(6);
						 String 	date_valeur	=	resultList.get(7);
						 String 	amount	=	resultList.get(8);
						 String 	devise	=	resultList.get(9);
						 String 	poste	=	resultList.get(10);
						 String 	tiers	=	resultList.get(11);
						 String 	op_finance	=	resultList.get(12);
						 String 	groupe1	=	resultList.get(13);
						 String 	groupe2	=	resultList.get(14);
						 String 	groupe3	=	resultList.get(15);
						 String 	corresp_sender1	=	resultList.get(16);
						 String 	corresp_sender2	=	resultList.get(17);
						 String 	report_date	=	resultList.get(18);
						
                        
                       	 if(num_operation == null) {
									 logger.info("break -> due to null value");
									 break;
								 }
                       	BrfOutstandingEntryManual brfOutstandingEntryManual = new BrfOutstandingEntryManual(nostor_code,type,bucket,days,
								 num_operation,date_import,date_operation,date_valeur,amount,devise,poste,tiers,tiers,groupe1,groupe2,
								 groupe3,corresp_sender1,corresp_sender2,report_date,new Date());
	//	 NUM_OPERATION	GL_VALUES	OP_REFERENCE	POSTE	DEALDATE	VALUEDATE	MATURITYDATE	CURRENCY1	CURRENCY2	NOMINAL_1	AMOUNT	NO_OF_DAYS	AMOUNT1	
	//DEALRATE	AMOUNT2	REVAL_RATE	REVAL_AMOUNT	PROFITLOSS	CONTREPARTIE	BRANCH_CODE	LCYRATE	LCYPROFITLOSS
					
								// BRF_FORWARD_REVEAL_MANUAL_ENTITY Brf_FORWARD_REVEAL_MANUAL_ENTITY1 = new BRF_FORWARD_REVEAL_MANUAL_ENTITY();								
                       	brfOutstandingEntryManual.setNostor_code(resultList.get(0));
                       	brfOutstandingEntryManual.setType	(resultList.get(1));
                       	brfOutstandingEntryManual.setBucket	(resultList.get(2));
                       	brfOutstandingEntryManual.setDays	(resultList.get(3));
                       	brfOutstandingEntryManual.setNum_operation	(resultList.get(4));
                       	brfOutstandingEntryManual.setDate_import(resultList.get(5));
                       	brfOutstandingEntryManual.setDate_operation(resultList.get(6));
                       	brfOutstandingEntryManual.setDate_valeur(resultList.get(7));
                       	brfOutstandingEntryManual.setAmount	(resultList.get(8));
                       	brfOutstandingEntryManual.setDevise	(resultList.get(9));
                       	brfOutstandingEntryManual.setPoste	(resultList.get(10));
                       	brfOutstandingEntryManual.setTiers	(resultList.get(11));
                       	brfOutstandingEntryManual.setOp_finance	(resultList.get(12));
                       	brfOutstandingEntryManual.setGroupe1	(resultList.get(13));
                       	brfOutstandingEntryManual.setGroupe2	(resultList.get(14));
                       	brfOutstandingEntryManual.setGroupe3	(resultList.get(15));
                       	brfOutstandingEntryManual.setCorresp_sender1	(resultList.get(16));
                       	brfOutstandingEntryManual.setCorresp_sender2	(resultList.get(17));
                       	brfOutstandingEntryManual.setReport_date(resultList.get(18));
;
									  
									  // Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
									  //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(resultList.get(1)); //
								   //Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1)); //
								  // Brf_FORWARD_REVEAL_MANUAL_ENTITY.setNum_operation(resultList.get(1));
									  
									 	
                     // BrfOutstandingrep.save(brfOutstandingEntryManual);
								 
								 
						// System.out.println(Brf_FORWARD_REVEAL_MANUAL_ENTITY.toString());
						 logger.info("saving values:");
						theSession.saveOrUpdate(brfOutstandingEntryManual);
						theSession.flush();
						theSession.clear();
					}

					logger.info("inserted values into BRF_OUTSTANDING_ENTRIES_MANUAL_TABLE");
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
						 
						 String 	nostor_code	=	nextLine[0];
						 String 	type	=	nextLine[1];
						 String 	bucket	=	nextLine[2];
						 String 	days	=	nextLine[3];
						 String 	num_operation	=	nextLine[4];
						 String 	date_import	=	nextLine[5];
						 String 	date_operation	=	nextLine[6];
						 String 	date_valeur	=	nextLine[7];
						 String 	amount	=	nextLine[8];
						 String 	devise	=	nextLine[9];
						 String 	poste	=	nextLine[10];
						 String 	tiers	=	nextLine[11];
						 String 	op_finance	=	nextLine[12];
						 String 	groupe1	=	nextLine[13];
						 String 	groupe2	=	nextLine[14];
						 String 	groupe3	=	nextLine[15];
						 String 	corresp_sender1	=	nextLine[16];
						 String 	corresp_sender2	=	nextLine[17];
						 String 	report_date	=	nextLine[18];
						
					
								 if(report_date == null) {
									 logger.info("break -> due to null value");
									 break;
								 }
								 
								// BRF_FORWARD_REVEAL_MANUAL_ID bRF_FORWARD_REVEAL_MANUAL_ID = new BRF_FORWARD_REVEAL_MANUAL_ID(num_operation,report_date);
								 BrfOutstandingEntryManual brfOutstandingEntryManual = new BrfOutstandingEntryManual(nostor_code,type,bucket,days,
										 num_operation,date_import,date_operation,date_valeur,amount,devise,poste,tiers,tiers,groupe1,groupe2,
										 groupe3,corresp_sender1,corresp_sender2,report_date,new Date());
								
								 
								// Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setId(123); // Manually assign the identifier
								 // Set other attributes of the entity
								// session.save(entity); // Save the entity
								 //Brf_FORWARD_REVEAL_MANUAL_ENTITY1.setNum_operation(num_operation);
								 logger.info("saving values");
								 
						theSession.save(brfOutstandingEntryManual);
						theSession.flush();
						theSession.clear();
					}
					skipRow++;
				}
				// theSession.saveOrUpdate(sup1000ManualS1List);
				logger.info("inserted values into BRF_oustanding_manual_TB");
				status = "success";
			} catch (Exception e) {
				e.printStackTrace();
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
		//logger.info("VALD_STATUS--->>>" + asondate);
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