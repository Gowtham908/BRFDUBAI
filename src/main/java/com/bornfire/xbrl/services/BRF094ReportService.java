package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
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
import java.util.Map;

import java.io.FileOutputStream;
import java.io.IOException;

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

import com.bornfire.xbrl.entities.BRBS.BRF094_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF094_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF094_NEW_REP;
import com.bornfire.xbrl.entities.BRBS.BRF094_SUMMARYENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF094_SUMMARYENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF094_SUMMARYENTITY3;
import com.bornfire.xbrl.entities.BRBS.BRF094_SUMMARYENTITY4;
import com.bornfire.xbrl.entities.BRBS.BRF094_SUMMARYENTITY5;
import com.bornfire.xbrl.entities.BRBS.BRF094_SUMMARYENTITY6;
import com.bornfire.xbrl.entities.BRBS.BRF94_Detailrep;
import com.bornfire.xbrl.entities.BRBS.T1CurProdDetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import java.sql.Connection;

@Service
@Transactional
@ConfigurationProperties("output")
public class BRF094ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF93ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF094_NEW_REP brf094entity2;

	@Autowired
	BRF94_Detailrep brf94_Detailrep;

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF094_SUMMARYENTITY1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF094_SUMMARYENTITY1 a ").getSingleResult();
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

	public ModelAndView getBRF094View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF094_SUMMARYENTITY1> T1rep = new ArrayList<BRF094_SUMMARYENTITY1>();

		List<BRF094_SUMMARYENTITY1> T1Master = new ArrayList<BRF094_SUMMARYENTITY1>();
		List<BRF094_SUMMARYENTITY2> T1Master1 = new ArrayList<BRF094_SUMMARYENTITY2>();
		List<BRF094_SUMMARYENTITY3> T1Master2 = new ArrayList<BRF094_SUMMARYENTITY3>();
		List<BRF094_SUMMARYENTITY4> T1Master3 = new ArrayList<BRF094_SUMMARYENTITY4>();
		List<BRF094_SUMMARYENTITY5> T1Master4 = new ArrayList<BRF094_SUMMARYENTITY5>();

		// List<BRF93_SUMMARYENTITY6> T2rep = new ArrayList<BRF93_SUMMARYENTITY6>();
		List<Object[]> T2rep = new ArrayList<Object[]>();

		List<BRF094_SUMMARYENTITY6> Remaining = new ArrayList<BRF094_SUMMARYENTITY6>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			T1Master = hs
					.createQuery("from BRF094_SUMMARYENTITY1 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs
					.createQuery("from BRF094_SUMMARYENTITY2 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master2 = hs
					.createQuery("from BRF094_SUMMARYENTITY3 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY3.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master3 = hs
					.createQuery("from BRF094_SUMMARYENTITY4 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY4.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master4 = hs
					.createQuery("from BRF094_SUMMARYENTITY5 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY5.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = brf094entity2.findallvalues(todate);

			System.out.println(T2rep.toString());

			for (Object[] BRF94 : T2rep) {
				System.out.println("Inside loop");
				BRF094_SUMMARYENTITY6 BRF094_SUMMARYENTITY6 = new BRF094_SUMMARYENTITY6();

				if (BRF94[0] != null && BRF94[0].equals("Remaining Countries")) {
					BRF094_SUMMARYENTITY6.setRemaining_countries(BRF94[1] != null ? (String) BRF94[1] : " ");
					System.out.println(BRF094_SUMMARYENTITY6.getRemaining_countries() != null
							? BRF094_SUMMARYENTITY6.getRemaining_countries()
							: " ");

					BRF094_SUMMARYENTITY6.setGovt_finan_invest_no_of_transactions(
							BRF94[2] != null ? (BigDecimal) BRF94[2] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGovt_finan_invest_amount(BRF94[3] != null ? (BigDecimal) BRF94[3] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setGovt_direct_invest_no_of_transactions(
							BRF94[4] != null ? (BigDecimal) BRF94[4] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGovt_direct_invest_amount(BRF94[5] != null ? (BigDecimal) BRF94[5] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setGovt_service_no_of_transactions(
							BRF94[6] != null ? (BigDecimal) BRF94[6] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGovt_service_invest_amount(BRF94[7] != null ? (BigDecimal) BRF94[7] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setGovt_trade_no_of_transactions(
							BRF94[8] != null ? (BigDecimal) BRF94[8] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGovt_trade_invest_amount(BRF94[9] != null ? (BigDecimal) BRF94[9] : BigDecimal.ZERO);

					BRF094_SUMMARYENTITY6.setReserve_finan_invest_no_of_transactions(
							BRF94[10] != null ? (BigDecimal) BRF94[10] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_finan_invest_amount(
							BRF94[11] != null ? (BigDecimal) BRF94[11] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_direct_invest_no_of_transactions(
							BRF94[12] != null ? (BigDecimal) BRF94[12] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_direct_invest_amount(
							BRF94[13] != null ? (BigDecimal) BRF94[13] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_service_no_of_transactions(
							BRF94[14] != null ? (BigDecimal) BRF94[14] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_service_invest_amount(
							BRF94[15] != null ? (BigDecimal) BRF94[15] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_trade_no_of_transactions(
							BRF94[16] != null ? (BigDecimal) BRF94[16] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setReserve_trade_invest_amount(
							BRF94[17] != null ? (BigDecimal) BRF94[17] : BigDecimal.ZERO);

					BRF094_SUMMARYENTITY6.setGre_finan_invest_no_of_transactions(
							BRF94[18] != null ? (BigDecimal) BRF94[18] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGre_finan_invest_amount(BRF94[19] != null ? (BigDecimal) BRF94[19] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setGre_direct_invest_no_of_transactions(
							BRF94[20] != null ? (BigDecimal) BRF94[20] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGre_direct_invest_amount(BRF94[21] != null ? (BigDecimal) BRF94[21] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setGre_service_no_of_transactions(
							BRF94[22] != null ? (BigDecimal) BRF94[22] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGre_service_invest_amount(BRF94[23] != null ? (BigDecimal) BRF94[23] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setGre_trade_no_of_transactions(
							BRF94[24] != null ? (BigDecimal) BRF94[24] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setGre_trade_invest_amount(BRF94[25] != null ? (BigDecimal) BRF94[25] : BigDecimal.ZERO);

					BRF094_SUMMARYENTITY6.setCorporate_finan_invest_no_of_transactions(
							BRF94[26] != null ? (BigDecimal) BRF94[26] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_finan_invest_amount(
							BRF94[27] != null ? (BigDecimal) BRF94[27] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_direct_invest_no_of_transactions(
							BRF94[28] != null ? (BigDecimal) BRF94[28] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_direct_invest_amount(
							BRF94[29] != null ? (BigDecimal) BRF94[29] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_service_no_of_transactions(
							BRF94[30] != null ? (BigDecimal) BRF94[30] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_service_invest_amount(
							BRF94[31] != null ? (BigDecimal) BRF94[31] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_trade_no_of_transactions(
							BRF94[32] != null ? (BigDecimal) BRF94[32] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setCorporate_trade_invest_amount(
							BRF94[33] != null ? (BigDecimal) BRF94[33] : BigDecimal.ZERO);

					BRF094_SUMMARYENTITY6.setSme_finan_invest_no_of_transactions(
							BRF94[34] != null ? (BigDecimal) BRF94[34] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setSme_finan_invest_amount(BRF94[35] != null ? (BigDecimal) BRF94[35] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setSme_direct_invest_no_of_transactions(
							BRF94[36] != null ? (BigDecimal) BRF94[36] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setSme_direct_invest_amount(BRF94[37] != null ? (BigDecimal) BRF94[37] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setSme_service_no_of_transactions(
							BRF94[38] != null ? (BigDecimal) BRF94[38] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setSme_service_invest_amount(BRF94[39] != null ? (BigDecimal) BRF94[39] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setSme_trade_no_of_transactions(
							BRF94[40] != null ? (BigDecimal) BRF94[40] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6
							.setSme_trade_invest_amount(BRF94[41] != null ? (BigDecimal) BRF94[41] : BigDecimal.ZERO);

					BRF094_SUMMARYENTITY6.setIndvidual_finan_invest_no_of_transactions(
							BRF94[42] != null ? (BigDecimal) BRF94[42] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_finan_invest_amount(
							BRF94[43] != null ? (BigDecimal) BRF94[43] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_direct_invest_no_of_transactions(
							BRF94[44] != null ? (BigDecimal) BRF94[44] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_direct_invest_amount(
							BRF94[45] != null ? (BigDecimal) BRF94[45] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_family_no_of_transactions(
							BRF94[46] != null ? (BigDecimal) BRF94[46] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_family_invest_amount(
							BRF94[47] != null ? (BigDecimal) BRF94[47] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_educate_no_of_transactions(
							BRF94[48] != null ? (BigDecimal) BRF94[48] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_educate_invest_amount(
							BRF94[49] != null ? (BigDecimal) BRF94[49] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_medical_no_of_transactions(
							BRF94[50] != null ? (BigDecimal) BRF94[50] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_medical_invest_amount(
							BRF94[51] != null ? (BigDecimal) BRF94[51] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_tour_no_of_transactions(
							BRF94[52] != null ? (BigDecimal) BRF94[52] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_tour_invest_amount(
							BRF94[53] != null ? (BigDecimal) BRF94[53] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_debt_no_of_transactions(
							BRF94[54] != null ? (BigDecimal) BRF94[54] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_debt_invest_amount(
							BRF94[55] != null ? (BigDecimal) BRF94[55] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_other_no_of_transactions(
							BRF94[56] != null ? (BigDecimal) BRF94[56] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setIndvidual_other_invest_amount(
							BRF94[57] != null ? (BigDecimal) BRF94[57] : BigDecimal.ZERO);

					BRF094_SUMMARYENTITY6.setTransactions(BRF94[58] != null ? (BigDecimal) BRF94[58] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setAmount(BRF94[59] != null ? (BigDecimal) BRF94[59] : BigDecimal.ZERO);
					BRF094_SUMMARYENTITY6.setRow_label(BRF94[60] != null ? (String) BRF94[60] : " ");

					Remaining.add(BRF094_SUMMARYENTITY6);
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("RR/BRF094");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
		mv.addObject("reportsummary3", T1Master3);
		mv.addObject("reportsummary4", T1Master4);
		mv.addObject("reportsummary5", T2rep);

		System.out.println(Remaining);
		mv.addObject("Remaining", Remaining);
		/// remain-GOVT
		mv.addObject("getgovtfintranremain", brf094entity2.getgovtfintranremain(todate));
		mv.addObject("getgovtfinamountremain", brf094entity2.getgovtfinamountremain(todate));
		mv.addObject("getgovtdirtranremain", brf094entity2.getgovtdirtranremain(todate));
		mv.addObject("getgovtdiramountremain", brf094entity2.getgovtdiramountremain(todate));
		mv.addObject("getgovtsertranremain", brf094entity2.getgovtsertranremain(todate));
		mv.addObject("getgovtseramountremain", brf094entity2.getgovtseramountremain(todate));
		mv.addObject("getgovttradetranremain", brf094entity2.getgovttradetranremain(todate));
		mv.addObject("getgovttradeamountremain", brf094entity2.getgovttradeamountremain(todate));

///remain-RESERVE
		mv.addObject("getresfintranremain", brf094entity2.getresfintranremain(todate));
		mv.addObject("getresfinamountremain", brf094entity2.getresfinamountremain(todate));
		mv.addObject("getresdirtranremain", brf094entity2.getresdirtranremain(todate));
		mv.addObject("getresdiramountremain", brf094entity2.getresdiramountremain(todate));
		mv.addObject("getressertranremain", brf094entity2.getressertranremain(todate));
		mv.addObject("getresseramountremain", brf094entity2.getresseramountremain(todate));
		mv.addObject("getrestradetranremain", brf094entity2.getrestradetranremain(todate));
		mv.addObject("getrestradeamountremain", brf094entity2.getrestradeamountremain(todate));

		/// remain-GRE
		mv.addObject("getgrefintranremain", brf094entity2.getgrefintranremain(todate));
		mv.addObject("getgrefinamountremain", brf094entity2.getgrefinamountremain(todate));
		mv.addObject("getgredirtranremain", brf094entity2.getgredirtranremain(todate));
		mv.addObject("getgrediramountremain", brf094entity2.getgrediramountremain(todate));
		mv.addObject("getgresertranremain", brf094entity2.getgresertranremain(todate));
		mv.addObject("getgreseramountremain", brf094entity2.getgreseramountremain(todate));
		mv.addObject("getgretradetranremain", brf094entity2.getgretradetranremain(todate));
		mv.addObject("getgretradeamountremain", brf094entity2.getgretradeamountremain(todate));

		/// remain-corporate
		mv.addObject("getcorfintranremain", brf094entity2.getcorfintranremain(todate));
		mv.addObject("getcorfinamountremain", brf094entity2.getcorfinamountremain(todate));
		mv.addObject("getcorpdirtranremain", brf094entity2.getcorpdirtranremain(todate));
		mv.addObject("getcorpdiramountremain", brf094entity2.getcorpdiramountremain(todate));
		mv.addObject("getcorsertranremain", brf094entity2.getcorsertranremain(todate));
		mv.addObject("getcorseramountremain", brf094entity2.getcorseramountremain(todate));
		mv.addObject("getcortradetranremain", brf094entity2.getcortradetranremain(todate));
		mv.addObject("getcortradeamountremain", brf094entity2.getcortradeamountremain(todate));

		/// remain-SME
		mv.addObject("getsmefintranremain", brf094entity2.getsmefintranremain(todate));
		mv.addObject("getsmefinamountremain", brf094entity2.getsmefinamountremain(todate));
		mv.addObject("getsmedirtranremain", brf094entity2.getsmedirtranremain(todate));
		mv.addObject("getsmediramountremain", brf094entity2.getsmediramountremain(todate));
		mv.addObject("getsmesertranremain", brf094entity2.getsmesertranremain(todate));
		mv.addObject("getsmeseramountremain", brf094entity2.getsmeseramountremain(todate));
		mv.addObject("getsmetradetranremain", brf094entity2.getsmetradetranremain(todate));
		mv.addObject("getsmetradeamountremain", brf094entity2.getsmetradeamountremain(todate));

		/// remain-INDIVIDUAL
		mv.addObject("getindfintranremain", brf094entity2.getindfintranremain(todate));
		mv.addObject("getindfinamountremain", brf094entity2.getindfinamountremain(todate));
		mv.addObject("getinddirtranremain", brf094entity2.getinddirtranremain(todate));
		mv.addObject("getinddiramountremain", brf094entity2.getinddiramountremain(todate));
		mv.addObject("getindfamtranremain", brf094entity2.getindfamtranremain(todate));
		mv.addObject("getindfamamountremain", brf094entity2.getindfamamountremain(todate));
		mv.addObject("getindedutranremain", brf094entity2.getindedutranremain(todate));
		mv.addObject("getindeduamountremain", brf094entity2.getindeduamountremain(todate));
		mv.addObject("getindmedtranremain", brf094entity2.getindmedtranremain(todate));
		mv.addObject("getindmedamountremain", brf094entity2.getindmedamountremain(todate));
		mv.addObject("getindtourtranremain", brf094entity2.getindtourtranremain(todate));
		mv.addObject("getindtourramountremain", brf094entity2.getindtourramountremain(todate));
		mv.addObject("getinddebttranremain", brf094entity2.getinddebttranremain(todate));
		mv.addObject("getinddebtamountremain", brf094entity2.getinddebtamountremain(todate));
		mv.addObject("getindothertranremain", brf094entity2.getindothertranremain(todate));
		mv.addObject("getindotheramountremain", brf094entity2.getindotheramountremain(todate));
		// ALL FEILDS(TRANSACTIONS) +COUNTRY
		//// TOTAL.NO.OF.TRANSACTIONS
		mv.addObject("getremaintrantotal", brf094entity2.getremaintrantotal(todate));
		/// ALL FEILD(AMOUNT)+country-amount
		mv.addObject("getremainamounttotal", brf094entity2.getremainamounttotal(todate));

		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF094currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF094A_DETAILTABLE");
				// qr.setParameter(1, filter);
			} else {

				qr = hs.createNativeQuery("select * from BRF094A_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF094A_DETAILTABLE  where report_date = ?1");
			System.out.println(4);

		}
		List<BRF094_DETAIL_ENTITY> T1Master = new ArrayList<BRF094_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF094_DETAIL_ENTITY  a where a.report_date = ?1", BRF094_DETAIL_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
			String purpose_of_rem = (String) a[49];
			String collection_code = (String) a[50];

			BRF094_DETAIL_ENTITY py = new BRF094_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, purpose_of_rem, collection_code);

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

		mv.setViewName("RR" + "/" + "BRF094::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<BRF094_SUMMARYENTITY1> fetchEntity1Data(Session session, Date date) throws ParseException {
		return session
				.createQuery("from BRF094_SUMMARYENTITY1 a where a.report_date = :date", BRF094_SUMMARYENTITY1.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF094_SUMMARYENTITY2> fetchEntity2Data(Session session, Date date) throws ParseException {
		return session
				.createQuery("from BRF094_SUMMARYENTITY2 a where a.report_date = :date", BRF094_SUMMARYENTITY2.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF094_SUMMARYENTITY3> fetchEntity3Data(Session session, Date date) throws ParseException {
		return session
				.createQuery("from BRF094_SUMMARYENTITY3 a where a.report_date = :date", BRF094_SUMMARYENTITY3.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF094_SUMMARYENTITY4> fetchEntity4Data(Session session, Date date) throws ParseException {
		return session
				.createQuery("from BRF094_SUMMARYENTITY4 a where a.report_date = :date", BRF094_SUMMARYENTITY4.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF094_SUMMARYENTITY5> fetchEntity5Data(Session session, Date date) throws ParseException {
		return session
				.createQuery("from BRF094_SUMMARYENTITY5 a where a.report_date = :date", BRF094_SUMMARYENTITY5.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF094_SUMMARYENTITY6> fetchEntity6Data(Session session, Date date) throws ParseException {
		return session
				.createQuery("from BRF094_SUMMARYENTITY6 a where a.report_date = :date", BRF094_SUMMARYENTITY6.class)
				.setParameter("date", date).getResultList();
	}

	public void updateSheetWithEntity1Data(Sheet sheet, List<BRF094_SUMMARYENTITY1> BRF094_SUMMARYENTITY1) {
		if (BRF094_SUMMARYENTITY1.size() == 1) {
			BRF094_SUMMARYENTITY1 brf94 = BRF094_SUMMARYENTITY1.get(0);
			Row R2row = sheet.getRow(10);
			Cell R2cell1 = R2row.getCell(3);
			if (R2cell1 != null) {
				R2cell1.setCellValue(brf94.getR2_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR2_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R2cell2 = R2row.getCell(4);
			if (R2cell2 != null) {
				R2cell2.setCellValue(brf94.getR2_amount_financial_investment_government() == null ? 0
						: brf94.getR2_amount_financial_investment_government().intValue());
			}
			Cell R2cell3 = R2row.getCell(5);
			if (R2cell3 != null) {
				R2cell3.setCellValue(brf94.getR2_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR2_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R2cell4 = R2row.getCell(6);
			if (R2cell4 != null) {
				R2cell4.setCellValue(brf94.getR2_amount_direct_investment_government() == null ? 0
						: brf94.getR2_amount_direct_investment_government().intValue());
			}
			Cell R2cell5 = R2row.getCell(7);
			if (R2cell5 != null) {
				R2cell5.setCellValue(brf94.getR2_no_of_transactions_services_government() == null ? 0
						: brf94.getR2_no_of_transactions_services_government().intValue());
			}
			Cell R2cell6 = R2row.getCell(8);
			if (R2cell6 != null) {
				R2cell6.setCellValue(brf94.getR2_amount_services_government() == null ? 0
						: brf94.getR2_amount_services_government().intValue());
			}
			Cell R2cell7 = R2row.getCell(9);
			if (R2cell7 != null) {
				R2cell7.setCellValue(brf94.getR2_no_of_transactions_trade_government() == null ? 0
						: brf94.getR2_no_of_transactions_trade_government().intValue());
			}
			Cell R2cell8 = R2row.getCell(10);
			if (R2cell8 != null) {
				R2cell8.setCellValue(brf94.getR2_amount_trade_government() == null ? 0
						: brf94.getR2_amount_trade_government().intValue());
			}
			Cell R2cell9 = R2row.getCell(11);
			if (R2cell9 != null) {
				R2cell9.setCellValue(brf94.getR2_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR2_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R2cell10 = R2row.getCell(12);
			if (R2cell10 != null) {
				R2cell10.setCellValue(brf94.getR2_amount_financial_investment_reserve() == null ? 0
						: brf94.getR2_amount_financial_investment_reserve().intValue());
			}
			Cell R2cell11 = R2row.getCell(13);
			if (R2cell11 != null) {
				R2cell11.setCellValue(brf94.getR2_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR2_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R2cell12 = R2row.getCell(14);
			if (R2cell12 != null) {
				R2cell12.setCellValue(brf94.getR2_amount_direct_investment_reserve() == null ? 0
						: brf94.getR2_amount_direct_investment_reserve().intValue());
			}
			Cell R2cell13 = R2row.getCell(15);
			if (R2cell13 != null) {
				R2cell13.setCellValue(brf94.getR2_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR2_no_of_transactions_services_reserve().intValue());
			}
			Cell R2cell14 = R2row.getCell(16);
			if (R2cell14 != null) {
				R2cell14.setCellValue(brf94.getR2_amount_services_reserve() == null ? 0
						: brf94.getR2_amount_services_reserve().intValue());
			}
			Cell R2cell15 = R2row.getCell(17);
			if (R2cell15 != null) {
				R2cell15.setCellValue(brf94.getR2_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR2_no_of_transactions_trade_reserve().intValue());
			}
			Cell R2cell16 = R2row.getCell(18);
			if (R2cell16 != null) {
				R2cell16.setCellValue(
						brf94.getR2_amount_trade_reserve() == null ? 0 : brf94.getR2_amount_trade_reserve().intValue());
			}
			Cell R2cell17 = R2row.getCell(19);
			if (R2cell17 != null) {
				R2cell17.setCellValue(brf94.getR2_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR2_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R2cell18 = R2row.getCell(20);
			if (R2cell18 != null) {
				R2cell18.setCellValue(brf94.getR2_amount_financial_investment_gre() == null ? 0
						: brf94.getR2_amount_financial_investment_gre().intValue());
			}
			Cell R2cell19 = R2row.getCell(21);
			if (R2cell19 != null) {
				R2cell19.setCellValue(brf94.getR2_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR2_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R2cell20 = R2row.getCell(22);
			if (R2cell20 != null) {
				R2cell20.setCellValue(brf94.getR2_amount_direct_investment_gre() == null ? 0
						: brf94.getR2_amount_direct_investment_gre().intValue());
			}
			Cell R2cell21 = R2row.getCell(23);
			if (R2cell21 != null) {
				R2cell21.setCellValue(brf94.getR2_no_of_transactions_services_gre() == null ? 0
						: brf94.getR2_no_of_transactions_services_gre().intValue());
			}
			Cell R2cell22 = R2row.getCell(24);
			if (R2cell22 != null) {
				R2cell22.setCellValue(
						brf94.getR2_amount_services_gre() == null ? 0 : brf94.getR2_amount_services_gre().intValue());
			}
			Cell R2cell23 = R2row.getCell(25);
			if (R2cell23 != null) {
				R2cell23.setCellValue(brf94.getR2_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR2_no_of_transactions_trade_gre().intValue());
			}
			Cell R2cell24 = R2row.getCell(26);
			if (R2cell24 != null) {
				R2cell24.setCellValue(
						brf94.getR2_amount_trade_gre() == null ? 0 : brf94.getR2_amount_trade_gre().intValue());
			}
			Cell R2cell25 = R2row.getCell(27);
			if (R2cell25 != null) {
				R2cell25.setCellValue(brf94.getR2_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR2_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R2cell26 = R2row.getCell(28);
			if (R2cell26 != null) {
				R2cell26.setCellValue(brf94.getR2_amount_financial_investment_corporate() == null ? 0
						: brf94.getR2_amount_financial_investment_corporate().intValue());
			}
			Cell R2cell27 = R2row.getCell(29);
			if (R2cell27 != null) {
				R2cell27.setCellValue(brf94.getR2_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR2_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R2cell28 = R2row.getCell(30);
			if (R2cell28 != null) {
				R2cell28.setCellValue(brf94.getR2_amount_direct_investment_corporate() == null ? 0
						: brf94.getR2_amount_direct_investment_corporate().intValue());
			}
			Cell R2cell29 = R2row.getCell(31);
			if (R2cell29 != null) {
				R2cell29.setCellValue(brf94.getR2_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR2_no_of_transactions_services_corporate().intValue());
			}
			Cell R2cell30 = R2row.getCell(32);
			if (R2cell30 != null) {
				R2cell30.setCellValue(brf94.getR2_amount_services_corporate() == null ? 0
						: brf94.getR2_amount_services_corporate().intValue());
			}
			Cell R2cell31 = R2row.getCell(33);
			if (R2cell31 != null) {
				R2cell31.setCellValue(brf94.getR2_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR2_no_of_transactions_trade_corporate().intValue());
			}
			Cell R2cell32 = R2row.getCell(34);
			if (R2cell32 != null) {
				R2cell32.setCellValue(brf94.getR2_amount_trade_corporate() == null ? 0
						: brf94.getR2_amount_trade_corporate().intValue());
			}
			Cell R2cell33 = R2row.getCell(35);
			if (R2cell33 != null) {
				R2cell33.setCellValue(brf94.getR2_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR2_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R2cell34 = R2row.getCell(36);
			if (R2cell34 != null) {
				R2cell34.setCellValue(brf94.getR2_amount_financial_investment_sme() == null ? 0
						: brf94.getR2_amount_financial_investment_sme().intValue());
			}
			Cell R2cell35 = R2row.getCell(37);
			if (R2cell35 != null) {
				R2cell35.setCellValue(brf94.getR2_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR2_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R2cell36 = R2row.getCell(38);
			if (R2cell36 != null) {
				R2cell36.setCellValue(brf94.getR2_amount_direct_investment_sme() == null ? 0
						: brf94.getR2_amount_direct_investment_sme().intValue());
			}
			Cell R2cell37 = R2row.getCell(39);
			if (R2cell37 != null) {
				R2cell37.setCellValue(brf94.getR2_no_of_transactions_services_sme() == null ? 0
						: brf94.getR2_no_of_transactions_services_sme().intValue());
			}
			Cell R2cell38 = R2row.getCell(40);
			if (R2cell38 != null) {
				R2cell38.setCellValue(
						brf94.getR2_amount_services_sme() == null ? 0 : brf94.getR2_amount_services_sme().intValue());
			}
			Cell R2cell39 = R2row.getCell(41);
			if (R2cell39 != null) {
				R2cell39.setCellValue(brf94.getR2_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR2_no_of_transactions_trade_sme().intValue());
			}
			Cell R2cell40 = R2row.getCell(42);
			if (R2cell40 != null) {
				R2cell40.setCellValue(
						brf94.getR2_amount_trade_sme() == null ? 0 : brf94.getR2_amount_trade_sme().intValue());
			}
			Cell R2cell41 = R2row.getCell(43);
			if (R2cell41 != null) {
				R2cell41.setCellValue(brf94.getR2_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR2_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R2cell42 = R2row.getCell(44);
			if (R2cell42 != null) {
				R2cell42.setCellValue(brf94.getR2_amount_financial_investment_individual() == null ? 0
						: brf94.getR2_amount_financial_investment_individual().intValue());
			}
			Cell R2cell43 = R2row.getCell(45);
			if (R2cell43 != null) {
				R2cell43.setCellValue(brf94.getR2_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR2_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R2cell44 = R2row.getCell(46);
			if (R2cell44 != null) {
				R2cell44.setCellValue(brf94.getR2_amount_direct_investment_individual() == null ? 0
						: brf94.getR2_amount_direct_investment_individual().intValue());
			}
			Cell R2cell45 = R2row.getCell(47);
			if (R2cell45 != null) {
				R2cell45.setCellValue(brf94.getR2_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR2_no_of_transactions_family_support_individual().intValue());
			}
			Cell R2cell46 = R2row.getCell(48);
			if (R2cell46 != null) {
				R2cell46.setCellValue(brf94.getR2_amount_family_support_individual() == null ? 0
						: brf94.getR2_amount_family_support_individual().intValue());
			}
			Cell R2cell47 = R2row.getCell(49);
			if (R2cell47 != null) {
				R2cell47.setCellValue(brf94.getR2_no_of_transactions_education_individual() == null ? 0
						: brf94.getR2_no_of_transactions_education_individual().intValue());
			}
			Cell R2cell48 = R2row.getCell(50);
			if (R2cell48 != null) {
				R2cell48.setCellValue(brf94.getR2_amount_education_individual() == null ? 0
						: brf94.getR2_amount_education_individual().intValue());
			}
			Cell R2cell49 = R2row.getCell(51);
			if (R2cell49 != null) {
				R2cell49.setCellValue(brf94.getR2_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR2_no_of_transactions_medical_individual().intValue());
			}

			Cell R2cell50 = R2row.getCell(52);
			if (R2cell50 != null) {
				R2cell50.setCellValue(brf94.getR2_amount_medical_individual() == null ? 0
						: brf94.getR2_amount_medical_individual().intValue());
			}
			Cell R2cell51 = R2row.getCell(53);
			if (R2cell51 != null) {
				R2cell51.setCellValue(brf94.getR2_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR2_no_of_transactions_tourism_individual().intValue());
			}
			Cell R2cell52 = R2row.getCell(54);
			if (R2cell52 != null) {
				R2cell52.setCellValue(brf94.getR2_amount_tourism_individual() == null ? 0
						: brf94.getR2_amount_tourism_individual().intValue());
			}
			Cell R2cell53 = R2row.getCell(55);
			if (R2cell53 != null) {
				R2cell53.setCellValue(brf94.getR2_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR2_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R2cell54 = R2row.getCell(56);
			if (R2cell54 != null) {
				R2cell54.setCellValue(brf94.getR2_amount_debt_settlement_individual() == null ? 0
						: brf94.getR2_amount_debt_settlement_individual().intValue());
			}
			Cell R2cell55 = R2row.getCell(57);
			if (R2cell55 != null) {
				R2cell55.setCellValue(brf94.getR2_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR2_no_of_transactions_other_services_individual().intValue());
			}

			Cell R2cell56 = R2row.getCell(58);
			if (R2cell56 != null) {
				R2cell56.setCellValue(brf94.getR2_amount_other_services_individual() == null ? 0
						: brf94.getR2_amount_other_services_individual().intValue());
			}

			Row R3row = sheet.getRow(11);
			Cell R3cell1 = R3row.getCell(3);
			if (R3cell1 != null) {
				R3cell1.setCellValue(brf94.getR3_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR3_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R3cell2 = R3row.getCell(4);
			if (R3cell2 != null) {
				R3cell2.setCellValue(brf94.getR3_amount_financial_investment_government() == null ? 0
						: brf94.getR3_amount_financial_investment_government().intValue());
			}
			Cell R3cell3 = R3row.getCell(5);
			if (R3cell3 != null) {
				R3cell3.setCellValue(brf94.getR3_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR3_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R3cell4 = R3row.getCell(6);
			if (R3cell4 != null) {
				R3cell4.setCellValue(brf94.getR3_amount_direct_investment_government() == null ? 0
						: brf94.getR3_amount_direct_investment_government().intValue());
			}
			Cell R3cell5 = R3row.getCell(7);
			if (R3cell5 != null) {
				R3cell5.setCellValue(brf94.getR3_no_of_transactions_services_government() == null ? 0
						: brf94.getR3_no_of_transactions_services_government().intValue());
			}
			Cell R3cell6 = R3row.getCell(8);
			if (R3cell6 != null) {
				R3cell6.setCellValue(brf94.getR3_amount_services_government() == null ? 0
						: brf94.getR3_amount_services_government().intValue());
			}
			Cell R3cell7 = R3row.getCell(9);
			if (R3cell7 != null) {
				R3cell7.setCellValue(brf94.getR3_no_of_transactions_trade_government() == null ? 0
						: brf94.getR3_no_of_transactions_trade_government().intValue());
			}
			Cell R3cell8 = R3row.getCell(10);
			if (R3cell8 != null) {
				R3cell8.setCellValue(brf94.getR3_amount_trade_government() == null ? 0
						: brf94.getR3_amount_trade_government().intValue());
			}
			Cell R3cell9 = R3row.getCell(11);
			if (R3cell9 != null) {
				R3cell9.setCellValue(brf94.getR3_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR3_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R3cell10 = R3row.getCell(12);
			if (R3cell10 != null) {
				R3cell10.setCellValue(brf94.getR3_amount_financial_investment_reserve() == null ? 0
						: brf94.getR3_amount_financial_investment_reserve().intValue());
			}
			Cell R3cell11 = R3row.getCell(13);
			if (R3cell11 != null) {
				R3cell11.setCellValue(brf94.getR3_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR3_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R3cell12 = R3row.getCell(14);
			if (R3cell12 != null) {
				R3cell12.setCellValue(brf94.getR3_amount_direct_investment_reserve() == null ? 0
						: brf94.getR3_amount_direct_investment_reserve().intValue());
			}
			Cell R3cell13 = R3row.getCell(15);
			if (R3cell13 != null) {
				R3cell13.setCellValue(brf94.getR3_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR3_no_of_transactions_services_reserve().intValue());
			}
			Cell R3cell14 = R3row.getCell(16);
			if (R3cell14 != null) {
				R3cell14.setCellValue(brf94.getR3_amount_services_reserve() == null ? 0
						: brf94.getR3_amount_services_reserve().intValue());
			}
			Cell R3cell15 = R3row.getCell(17);
			if (R3cell15 != null) {
				R3cell15.setCellValue(brf94.getR3_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR3_no_of_transactions_trade_reserve().intValue());
			}
			Cell R3cell16 = R3row.getCell(18);
			if (R3cell16 != null) {
				R3cell16.setCellValue(
						brf94.getR3_amount_trade_reserve() == null ? 0 : brf94.getR3_amount_trade_reserve().intValue());
			}
			Cell R3cell17 = R3row.getCell(19);
			if (R3cell17 != null) {
				R3cell17.setCellValue(brf94.getR3_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR3_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R3cell18 = R3row.getCell(20);
			if (R3cell18 != null) {
				R3cell18.setCellValue(brf94.getR3_amount_financial_investment_gre() == null ? 0
						: brf94.getR3_amount_financial_investment_gre().intValue());
			}
			Cell R3cell19 = R3row.getCell(21);
			if (R3cell19 != null) {
				R3cell19.setCellValue(brf94.getR3_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR3_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R3cell20 = R3row.getCell(22);
			if (R3cell20 != null) {
				R3cell20.setCellValue(brf94.getR3_amount_direct_investment_gre() == null ? 0
						: brf94.getR3_amount_direct_investment_gre().intValue());
			}
			Cell R3cell21 = R3row.getCell(23);
			if (R3cell21 != null) {
				R3cell21.setCellValue(brf94.getR3_no_of_transactions_services_gre() == null ? 0
						: brf94.getR3_no_of_transactions_services_gre().intValue());
			}
			Cell R3cell22 = R3row.getCell(24);
			if (R3cell22 != null) {
				R3cell22.setCellValue(
						brf94.getR3_amount_services_gre() == null ? 0 : brf94.getR3_amount_services_gre().intValue());
			}
			Cell R3cell23 = R3row.getCell(25);
			if (R3cell23 != null) {
				R3cell23.setCellValue(brf94.getR3_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR3_no_of_transactions_trade_gre().intValue());
			}
			Cell R3cell24 = R3row.getCell(26);
			if (R3cell24 != null) {
				R3cell24.setCellValue(
						brf94.getR3_amount_trade_gre() == null ? 0 : brf94.getR3_amount_trade_gre().intValue());
			}
			Cell R3cell25 = R3row.getCell(27);
			if (R3cell25 != null) {
				R3cell25.setCellValue(brf94.getR3_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR3_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R3cell26 = R3row.getCell(28);
			if (R3cell26 != null) {
				R3cell26.setCellValue(brf94.getR3_amount_financial_investment_corporate() == null ? 0
						: brf94.getR3_amount_financial_investment_corporate().intValue());
			}
			Cell R3cell27 = R3row.getCell(29);
			if (R3cell27 != null) {
				R3cell27.setCellValue(brf94.getR3_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR3_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R3cell28 = R3row.getCell(30);
			if (R3cell28 != null) {
				R3cell28.setCellValue(brf94.getR3_amount_direct_investment_corporate() == null ? 0
						: brf94.getR3_amount_direct_investment_corporate().intValue());
			}
			Cell R3cell29 = R3row.getCell(31);
			if (R3cell29 != null) {
				R3cell29.setCellValue(brf94.getR3_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR3_no_of_transactions_services_corporate().intValue());
			}
			Cell R3cell30 = R3row.getCell(32);
			if (R3cell30 != null) {
				R3cell30.setCellValue(brf94.getR3_amount_services_corporate() == null ? 0
						: brf94.getR3_amount_services_corporate().intValue());
			}
			Cell R3cell31 = R3row.getCell(33);
			if (R3cell31 != null) {
				R3cell31.setCellValue(brf94.getR3_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR3_no_of_transactions_trade_corporate().intValue());
			}
			Cell R3cell32 = R3row.getCell(34);
			if (R3cell32 != null) {
				R3cell32.setCellValue(brf94.getR3_amount_trade_corporate() == null ? 0
						: brf94.getR3_amount_trade_corporate().intValue());
			}
			Cell R3cell33 = R3row.getCell(35);
			if (R3cell33 != null) {
				R3cell33.setCellValue(brf94.getR3_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR3_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R3cell34 = R3row.getCell(36);
			if (R3cell34 != null) {
				R3cell34.setCellValue(brf94.getR3_amount_financial_investment_sme() == null ? 0
						: brf94.getR3_amount_financial_investment_sme().intValue());
			}
			Cell R3cell35 = R3row.getCell(37);
			if (R3cell35 != null) {
				R3cell35.setCellValue(brf94.getR3_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR3_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R3cell36 = R3row.getCell(38);
			if (R3cell36 != null) {
				R3cell36.setCellValue(brf94.getR3_amount_direct_investment_sme() == null ? 0
						: brf94.getR3_amount_direct_investment_sme().intValue());
			}
			Cell R3cell37 = R3row.getCell(39);
			if (R3cell37 != null) {
				R3cell37.setCellValue(brf94.getR3_no_of_transactions_services_sme() == null ? 0
						: brf94.getR3_no_of_transactions_services_sme().intValue());
			}
			Cell R3cell38 = R3row.getCell(40);
			if (R3cell38 != null) {
				R3cell38.setCellValue(
						brf94.getR3_amount_services_sme() == null ? 0 : brf94.getR3_amount_services_sme().intValue());
			}
			Cell R3cell39 = R3row.getCell(41);
			if (R3cell39 != null) {
				R3cell39.setCellValue(brf94.getR3_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR3_no_of_transactions_trade_sme().intValue());
			}
			Cell R3cell40 = R3row.getCell(42);
			if (R3cell40 != null) {
				R3cell40.setCellValue(
						brf94.getR3_amount_trade_sme() == null ? 0 : brf94.getR3_amount_trade_sme().intValue());
			}
			Cell R3cell41 = R3row.getCell(43);
			if (R3cell41 != null) {
				R3cell41.setCellValue(brf94.getR3_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR3_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R3cell42 = R3row.getCell(44);
			if (R3cell42 != null) {
				R3cell42.setCellValue(brf94.getR3_amount_financial_investment_individual() == null ? 0
						: brf94.getR3_amount_financial_investment_individual().intValue());
			}
			Cell R3cell43 = R3row.getCell(45);
			if (R3cell43 != null) {
				R3cell43.setCellValue(brf94.getR3_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR3_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R3cell44 = R3row.getCell(46);
			if (R3cell44 != null) {
				R3cell44.setCellValue(brf94.getR3_amount_direct_investment_individual() == null ? 0
						: brf94.getR3_amount_direct_investment_individual().intValue());
			}
			Cell R3cell45 = R3row.getCell(47);
			if (R3cell45 != null) {
				R3cell45.setCellValue(brf94.getR3_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR3_no_of_transactions_family_support_individual().intValue());
			}
			Cell R3cell46 = R3row.getCell(48);
			if (R3cell46 != null) {
				R3cell46.setCellValue(brf94.getR3_amount_family_support_individual() == null ? 0
						: brf94.getR3_amount_family_support_individual().intValue());
			}
			Cell R3cell47 = R3row.getCell(49);
			if (R3cell47 != null) {
				R3cell47.setCellValue(brf94.getR3_no_of_transactions_education_individual() == null ? 0
						: brf94.getR3_no_of_transactions_education_individual().intValue());
			}
			Cell R3cell48 = R3row.getCell(50);
			if (R3cell48 != null) {
				R3cell48.setCellValue(brf94.getR3_amount_education_individual() == null ? 0
						: brf94.getR3_amount_education_individual().intValue());
			}
			Cell R3cell49 = R3row.getCell(51);
			if (R3cell49 != null) {
				R3cell49.setCellValue(brf94.getR3_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR3_no_of_transactions_medical_individual().intValue());
			}

			Cell R3cell50 = R3row.getCell(52);
			if (R3cell50 != null) {
				R3cell50.setCellValue(brf94.getR3_amount_medical_individual() == null ? 0
						: brf94.getR3_amount_medical_individual().intValue());
			}
			Cell R3cell51 = R3row.getCell(53);
			if (R3cell51 != null) {
				R3cell51.setCellValue(brf94.getR3_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR3_no_of_transactions_tourism_individual().intValue());
			}
			Cell R3cell52 = R3row.getCell(54);
			if (R3cell52 != null) {
				R3cell52.setCellValue(brf94.getR3_amount_tourism_individual() == null ? 0
						: brf94.getR3_amount_tourism_individual().intValue());
			}
			Cell R3cell53 = R3row.getCell(55);
			if (R3cell53 != null) {
				R3cell53.setCellValue(brf94.getR3_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR3_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R3cell54 = R3row.getCell(56);
			if (R3cell54 != null) {
				R3cell54.setCellValue(brf94.getR3_amount_debt_settlement_individual() == null ? 0
						: brf94.getR3_amount_debt_settlement_individual().intValue());
			}
			Cell R3cell55 = R3row.getCell(57);
			if (R3cell55 != null) {
				R3cell55.setCellValue(brf94.getR3_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR3_no_of_transactions_other_services_individual().intValue());
			}

			Cell R3cell56 = R3row.getCell(58);
			if (R3cell56 != null) {
				R3cell56.setCellValue(brf94.getR3_amount_other_services_individual() == null ? 0
						: brf94.getR3_amount_other_services_individual().intValue());
			}

			Row R5row = sheet.getRow(13);
			Cell R5cell1 = R5row.getCell(3);
			if (R5cell1 != null) {
				R5cell1.setCellValue(brf94.getR5_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR5_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R5cell2 = R5row.getCell(4);
			if (R5cell2 != null) {
				R5cell2.setCellValue(brf94.getR5_amount_financial_investment_government() == null ? 0
						: brf94.getR5_amount_financial_investment_government().intValue());
			}
			Cell R5cell3 = R5row.getCell(5);
			if (R5cell3 != null) {
				R5cell3.setCellValue(brf94.getR5_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR5_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R5cell4 = R5row.getCell(6);
			if (R5cell4 != null) {
				R5cell4.setCellValue(brf94.getR5_amount_direct_investment_government() == null ? 0
						: brf94.getR5_amount_direct_investment_government().intValue());
			}
			Cell R5cell5 = R5row.getCell(7);
			if (R5cell5 != null) {
				R5cell5.setCellValue(brf94.getR5_no_of_transactions_services_government() == null ? 0
						: brf94.getR5_no_of_transactions_services_government().intValue());
			}
			Cell R5cell6 = R5row.getCell(8);
			if (R5cell6 != null) {
				R5cell6.setCellValue(brf94.getR5_amount_services_government() == null ? 0
						: brf94.getR5_amount_services_government().intValue());
			}
			Cell R5cell7 = R5row.getCell(9);
			if (R5cell7 != null) {
				R5cell7.setCellValue(brf94.getR5_no_of_transactions_trade_government() == null ? 0
						: brf94.getR5_no_of_transactions_trade_government().intValue());
			}
			Cell R5cell8 = R5row.getCell(10);
			if (R5cell8 != null) {
				R5cell8.setCellValue(brf94.getR5_amount_trade_government() == null ? 0
						: brf94.getR5_amount_trade_government().intValue());
			}
			Cell R5cell9 = R5row.getCell(11);
			if (R5cell9 != null) {
				R5cell9.setCellValue(brf94.getR5_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR5_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R5cell10 = R5row.getCell(12);
			if (R5cell10 != null) {
				R5cell10.setCellValue(brf94.getR5_amount_financial_investment_reserve() == null ? 0
						: brf94.getR5_amount_financial_investment_reserve().intValue());
			}
			Cell R5cell11 = R5row.getCell(13);
			if (R5cell11 != null) {
				R5cell11.setCellValue(brf94.getR5_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR5_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R5cell12 = R5row.getCell(14);
			if (R5cell12 != null) {
				R5cell12.setCellValue(brf94.getR5_amount_direct_investment_reserve() == null ? 0
						: brf94.getR5_amount_direct_investment_reserve().intValue());
			}
			Cell R5cell13 = R5row.getCell(15);
			if (R5cell13 != null) {
				R5cell13.setCellValue(brf94.getR5_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR5_no_of_transactions_services_reserve().intValue());
			}
			Cell R5cell14 = R5row.getCell(16);
			if (R5cell14 != null) {
				R5cell14.setCellValue(brf94.getR5_amount_services_reserve() == null ? 0
						: brf94.getR5_amount_services_reserve().intValue());
			}
			Cell R5cell15 = R5row.getCell(17);
			if (R5cell15 != null) {
				R5cell15.setCellValue(brf94.getR5_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR5_no_of_transactions_trade_reserve().intValue());
			}
			Cell R5cell16 = R5row.getCell(18);
			if (R5cell16 != null) {
				R5cell16.setCellValue(
						brf94.getR5_amount_trade_reserve() == null ? 0 : brf94.getR5_amount_trade_reserve().intValue());
			}
			Cell R5cell17 = R5row.getCell(19);
			if (R5cell17 != null) {
				R5cell17.setCellValue(brf94.getR5_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR5_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R5cell18 = R5row.getCell(20);
			if (R5cell18 != null) {
				R5cell18.setCellValue(brf94.getR5_amount_financial_investment_gre() == null ? 0
						: brf94.getR5_amount_financial_investment_gre().intValue());
			}
			Cell R5cell19 = R5row.getCell(21);
			if (R5cell19 != null) {
				R5cell19.setCellValue(brf94.getR5_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR5_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R5cell20 = R5row.getCell(22);
			if (R5cell20 != null) {
				R5cell20.setCellValue(brf94.getR5_amount_direct_investment_gre() == null ? 0
						: brf94.getR5_amount_direct_investment_gre().intValue());
			}
			Cell R5cell21 = R5row.getCell(23);
			if (R5cell21 != null) {
				R5cell21.setCellValue(brf94.getR5_no_of_transactions_services_gre() == null ? 0
						: brf94.getR5_no_of_transactions_services_gre().intValue());
			}
			Cell R5cell22 = R5row.getCell(24);
			if (R5cell22 != null) {
				R5cell22.setCellValue(
						brf94.getR5_amount_services_gre() == null ? 0 : brf94.getR5_amount_services_gre().intValue());
			}
			Cell R5cell23 = R5row.getCell(25);
			if (R5cell23 != null) {
				R5cell23.setCellValue(brf94.getR5_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR5_no_of_transactions_trade_gre().intValue());
			}
			Cell R5cell24 = R5row.getCell(26);
			if (R5cell24 != null) {
				R5cell24.setCellValue(
						brf94.getR5_amount_trade_gre() == null ? 0 : brf94.getR5_amount_trade_gre().intValue());
			}
			Cell R5cell25 = R5row.getCell(27);
			if (R5cell25 != null) {
				R5cell25.setCellValue(brf94.getR5_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR5_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R5cell26 = R5row.getCell(28);
			if (R5cell26 != null) {
				R5cell26.setCellValue(brf94.getR5_amount_financial_investment_corporate() == null ? 0
						: brf94.getR5_amount_financial_investment_corporate().intValue());
			}
			Cell R5cell27 = R5row.getCell(29);
			if (R5cell27 != null) {
				R5cell27.setCellValue(brf94.getR5_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR5_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R5cell28 = R5row.getCell(30);
			if (R5cell28 != null) {
				R5cell28.setCellValue(brf94.getR5_amount_direct_investment_corporate() == null ? 0
						: brf94.getR5_amount_direct_investment_corporate().intValue());
			}
			Cell R5cell29 = R5row.getCell(31);
			if (R5cell29 != null) {
				R5cell29.setCellValue(brf94.getR5_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR5_no_of_transactions_services_corporate().intValue());
			}
			Cell R5cell30 = R5row.getCell(32);
			if (R5cell30 != null) {
				R5cell30.setCellValue(brf94.getR5_amount_services_corporate() == null ? 0
						: brf94.getR5_amount_services_corporate().intValue());
			}
			Cell R5cell31 = R5row.getCell(33);
			if (R5cell31 != null) {
				R5cell31.setCellValue(brf94.getR5_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR5_no_of_transactions_trade_corporate().intValue());
			}
			Cell R5cell32 = R5row.getCell(34);
			if (R5cell32 != null) {
				R5cell32.setCellValue(brf94.getR5_amount_trade_corporate() == null ? 0
						: brf94.getR5_amount_trade_corporate().intValue());
			}
			Cell R5cell33 = R5row.getCell(35);
			if (R5cell33 != null) {
				R5cell33.setCellValue(brf94.getR5_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR5_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R5cell34 = R5row.getCell(36);
			if (R5cell34 != null) {
				R5cell34.setCellValue(brf94.getR5_amount_financial_investment_sme() == null ? 0
						: brf94.getR5_amount_financial_investment_sme().intValue());
			}
			Cell R5cell35 = R5row.getCell(37);
			if (R5cell35 != null) {
				R5cell35.setCellValue(brf94.getR5_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR5_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R5cell36 = R5row.getCell(38);
			if (R5cell36 != null) {
				R5cell36.setCellValue(brf94.getR5_amount_direct_investment_sme() == null ? 0
						: brf94.getR5_amount_direct_investment_sme().intValue());
			}
			Cell R5cell37 = R5row.getCell(39);
			if (R5cell37 != null) {
				R5cell37.setCellValue(brf94.getR5_no_of_transactions_services_sme() == null ? 0
						: brf94.getR5_no_of_transactions_services_sme().intValue());
			}
			Cell R5cell38 = R5row.getCell(40);
			if (R5cell38 != null) {
				R5cell38.setCellValue(
						brf94.getR5_amount_services_sme() == null ? 0 : brf94.getR5_amount_services_sme().intValue());
			}
			Cell R5cell39 = R5row.getCell(41);
			if (R5cell39 != null) {
				R5cell39.setCellValue(brf94.getR5_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR5_no_of_transactions_trade_sme().intValue());
			}
			Cell R5cell40 = R5row.getCell(42);
			if (R5cell40 != null) {
				R5cell40.setCellValue(
						brf94.getR5_amount_trade_sme() == null ? 0 : brf94.getR5_amount_trade_sme().intValue());
			}
			Cell R5cell41 = R5row.getCell(43);
			if (R5cell41 != null) {
				R5cell41.setCellValue(brf94.getR5_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR5_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R5cell42 = R5row.getCell(44);
			if (R5cell42 != null) {
				R5cell42.setCellValue(brf94.getR5_amount_financial_investment_individual() == null ? 0
						: brf94.getR5_amount_financial_investment_individual().intValue());
			}
			Cell R5cell43 = R5row.getCell(45);
			if (R5cell43 != null) {
				R5cell43.setCellValue(brf94.getR5_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR5_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R5cell44 = R5row.getCell(46);
			if (R5cell44 != null) {
				R5cell44.setCellValue(brf94.getR5_amount_direct_investment_individual() == null ? 0
						: brf94.getR5_amount_direct_investment_individual().intValue());
			}
			Cell R5cell45 = R5row.getCell(47);
			if (R5cell45 != null) {
				R5cell45.setCellValue(brf94.getR5_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR5_no_of_transactions_family_support_individual().intValue());
			}
			Cell R5cell46 = R5row.getCell(48);
			if (R5cell46 != null) {
				R5cell46.setCellValue(brf94.getR5_amount_family_support_individual() == null ? 0
						: brf94.getR5_amount_family_support_individual().intValue());
			}
			Cell R5cell47 = R5row.getCell(49);
			if (R5cell47 != null) {
				R5cell47.setCellValue(brf94.getR5_no_of_transactions_education_individual() == null ? 0
						: brf94.getR5_no_of_transactions_education_individual().intValue());
			}
			Cell R5cell48 = R5row.getCell(50);
			if (R5cell48 != null) {
				R5cell48.setCellValue(brf94.getR5_amount_education_individual() == null ? 0
						: brf94.getR5_amount_education_individual().intValue());
			}
			Cell R5cell49 = R5row.getCell(51);
			if (R5cell49 != null) {
				R5cell49.setCellValue(brf94.getR5_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR5_no_of_transactions_medical_individual().intValue());
			}

			Cell R5cell50 = R5row.getCell(52);
			if (R5cell50 != null) {
				R5cell50.setCellValue(brf94.getR5_amount_medical_individual() == null ? 0
						: brf94.getR5_amount_medical_individual().intValue());
			}
			Cell R5cell51 = R5row.getCell(53);
			if (R5cell51 != null) {
				R5cell51.setCellValue(brf94.getR5_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR5_no_of_transactions_tourism_individual().intValue());
			}
			Cell R5cell52 = R5row.getCell(54);
			if (R5cell52 != null) {
				R5cell52.setCellValue(brf94.getR5_amount_tourism_individual() == null ? 0
						: brf94.getR5_amount_tourism_individual().intValue());
			}
			Cell R5cell53 = R5row.getCell(55);
			if (R5cell53 != null) {
				R5cell53.setCellValue(brf94.getR5_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR5_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R5cell54 = R5row.getCell(56);
			if (R5cell54 != null) {
				R5cell54.setCellValue(brf94.getR5_amount_debt_settlement_individual() == null ? 0
						: brf94.getR5_amount_debt_settlement_individual().intValue());
			}
			Cell R5cell55 = R5row.getCell(57);
			if (R5cell55 != null) {
				R5cell55.setCellValue(brf94.getR5_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR5_no_of_transactions_other_services_individual().intValue());
			}

			Cell R5cell56 = R5row.getCell(58);
			if (R5cell56 != null) {
				R5cell56.setCellValue(brf94.getR5_amount_other_services_individual() == null ? 0
						: brf94.getR5_amount_other_services_individual().intValue());
			}

			Row R6row = sheet.getRow(14);
			Cell R6cell1 = R6row.getCell(3);
			if (R6cell1 != null) {
				R6cell1.setCellValue(brf94.getR6_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR6_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R6cell2 = R6row.getCell(4);
			if (R6cell2 != null) {
				R6cell2.setCellValue(brf94.getR6_amount_financial_investment_government() == null ? 0
						: brf94.getR6_amount_financial_investment_government().intValue());
			}
			Cell R6cell3 = R6row.getCell(5);
			if (R6cell3 != null) {
				R6cell3.setCellValue(brf94.getR6_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR6_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R6cell4 = R6row.getCell(6);
			if (R6cell4 != null) {
				R6cell4.setCellValue(brf94.getR6_amount_direct_investment_government() == null ? 0
						: brf94.getR6_amount_direct_investment_government().intValue());
			}
			Cell R6cell5 = R6row.getCell(7);
			if (R6cell5 != null) {
				R6cell5.setCellValue(brf94.getR6_no_of_transactions_services_government() == null ? 0
						: brf94.getR6_no_of_transactions_services_government().intValue());
			}
			Cell R6cell6 = R6row.getCell(8);
			if (R6cell6 != null) {
				R6cell6.setCellValue(brf94.getR6_amount_services_government() == null ? 0
						: brf94.getR6_amount_services_government().intValue());
			}
			Cell R6cell7 = R6row.getCell(9);
			if (R6cell7 != null) {
				R6cell7.setCellValue(brf94.getR6_no_of_transactions_trade_government() == null ? 0
						: brf94.getR6_no_of_transactions_trade_government().intValue());
			}
			Cell R6cell8 = R6row.getCell(10);
			if (R6cell8 != null) {
				R6cell8.setCellValue(brf94.getR6_amount_trade_government() == null ? 0
						: brf94.getR6_amount_trade_government().intValue());
			}
			Cell R6cell9 = R6row.getCell(11);
			if (R6cell9 != null) {
				R6cell9.setCellValue(brf94.getR6_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR6_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R6cell10 = R6row.getCell(12);
			if (R6cell10 != null) {
				R6cell10.setCellValue(brf94.getR6_amount_financial_investment_reserve() == null ? 0
						: brf94.getR6_amount_financial_investment_reserve().intValue());
			}
			Cell R6cell11 = R6row.getCell(13);
			if (R6cell11 != null) {
				R6cell11.setCellValue(brf94.getR6_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR6_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R6cell12 = R6row.getCell(14);
			if (R6cell12 != null) {
				R6cell12.setCellValue(brf94.getR6_amount_direct_investment_reserve() == null ? 0
						: brf94.getR6_amount_direct_investment_reserve().intValue());
			}
			Cell R6cell13 = R6row.getCell(15);
			if (R6cell13 != null) {
				R6cell13.setCellValue(brf94.getR6_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR6_no_of_transactions_services_reserve().intValue());
			}
			Cell R6cell14 = R6row.getCell(16);
			if (R6cell14 != null) {
				R6cell14.setCellValue(brf94.getR6_amount_services_reserve() == null ? 0
						: brf94.getR6_amount_services_reserve().intValue());
			}
			Cell R6cell15 = R6row.getCell(17);
			if (R6cell15 != null) {
				R6cell15.setCellValue(brf94.getR6_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR6_no_of_transactions_trade_reserve().intValue());
			}
			Cell R6cell16 = R6row.getCell(18);
			if (R6cell16 != null) {
				R6cell16.setCellValue(
						brf94.getR6_amount_trade_reserve() == null ? 0 : brf94.getR6_amount_trade_reserve().intValue());
			}
			Cell R6cell17 = R6row.getCell(19);
			if (R6cell17 != null) {
				R6cell17.setCellValue(brf94.getR6_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR6_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R6cell18 = R6row.getCell(20);
			if (R6cell18 != null) {
				R6cell18.setCellValue(brf94.getR6_amount_financial_investment_gre() == null ? 0
						: brf94.getR6_amount_financial_investment_gre().intValue());
			}
			Cell R6cell19 = R6row.getCell(21);
			if (R6cell19 != null) {
				R6cell19.setCellValue(brf94.getR6_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR6_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R6cell20 = R6row.getCell(22);
			if (R6cell20 != null) {
				R6cell20.setCellValue(brf94.getR6_amount_direct_investment_gre() == null ? 0
						: brf94.getR6_amount_direct_investment_gre().intValue());
			}
			Cell R6cell21 = R6row.getCell(23);
			if (R6cell21 != null) {
				R6cell21.setCellValue(brf94.getR6_no_of_transactions_services_gre() == null ? 0
						: brf94.getR6_no_of_transactions_services_gre().intValue());
			}
			Cell R6cell22 = R6row.getCell(24);
			if (R6cell22 != null) {
				R6cell22.setCellValue(
						brf94.getR6_amount_services_gre() == null ? 0 : brf94.getR6_amount_services_gre().intValue());
			}
			Cell R6cell23 = R6row.getCell(25);
			if (R6cell23 != null) {
				R6cell23.setCellValue(brf94.getR6_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR6_no_of_transactions_trade_gre().intValue());
			}
			Cell R6cell24 = R6row.getCell(26);
			if (R6cell24 != null) {
				R6cell24.setCellValue(
						brf94.getR6_amount_trade_gre() == null ? 0 : brf94.getR6_amount_trade_gre().intValue());
			}
			Cell R6cell25 = R6row.getCell(27);
			if (R6cell25 != null) {
				R6cell25.setCellValue(brf94.getR6_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR6_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R6cell26 = R6row.getCell(28);
			if (R6cell26 != null) {
				R6cell26.setCellValue(brf94.getR6_amount_financial_investment_corporate() == null ? 0
						: brf94.getR6_amount_financial_investment_corporate().intValue());
			}
			Cell R6cell27 = R6row.getCell(29);
			if (R6cell27 != null) {
				R6cell27.setCellValue(brf94.getR6_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR6_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R6cell28 = R6row.getCell(30);
			if (R6cell28 != null) {
				R6cell28.setCellValue(brf94.getR6_amount_direct_investment_corporate() == null ? 0
						: brf94.getR6_amount_direct_investment_corporate().intValue());
			}
			Cell R6cell29 = R6row.getCell(31);
			if (R6cell29 != null) {
				R6cell29.setCellValue(brf94.getR6_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR6_no_of_transactions_services_corporate().intValue());
			}
			Cell R6cell30 = R6row.getCell(32);
			if (R6cell30 != null) {
				R6cell30.setCellValue(brf94.getR6_amount_services_corporate() == null ? 0
						: brf94.getR6_amount_services_corporate().intValue());
			}
			Cell R6cell31 = R6row.getCell(33);
			if (R6cell31 != null) {
				R6cell31.setCellValue(brf94.getR6_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR6_no_of_transactions_trade_corporate().intValue());
			}
			Cell R6cell32 = R6row.getCell(34);
			if (R6cell32 != null) {
				R6cell32.setCellValue(brf94.getR6_amount_trade_corporate() == null ? 0
						: brf94.getR6_amount_trade_corporate().intValue());
			}
			Cell R6cell33 = R6row.getCell(35);
			if (R6cell33 != null) {
				R6cell33.setCellValue(brf94.getR6_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR6_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R6cell34 = R6row.getCell(36);
			if (R6cell34 != null) {
				R6cell34.setCellValue(brf94.getR6_amount_financial_investment_sme() == null ? 0
						: brf94.getR6_amount_financial_investment_sme().intValue());
			}
			Cell R6cell35 = R6row.getCell(37);
			if (R6cell35 != null) {
				R6cell35.setCellValue(brf94.getR6_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR6_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R6cell36 = R6row.getCell(38);
			if (R6cell36 != null) {
				R6cell36.setCellValue(brf94.getR6_amount_direct_investment_sme() == null ? 0
						: brf94.getR6_amount_direct_investment_sme().intValue());
			}
			Cell R6cell37 = R6row.getCell(39);
			if (R6cell37 != null) {
				R6cell37.setCellValue(brf94.getR6_no_of_transactions_services_sme() == null ? 0
						: brf94.getR6_no_of_transactions_services_sme().intValue());
			}
			Cell R6cell38 = R6row.getCell(40);
			if (R6cell38 != null) {
				R6cell38.setCellValue(
						brf94.getR6_amount_services_sme() == null ? 0 : brf94.getR6_amount_services_sme().intValue());
			}
			Cell R6cell39 = R6row.getCell(41);
			if (R6cell39 != null) {
				R6cell39.setCellValue(brf94.getR6_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR6_no_of_transactions_trade_sme().intValue());
			}
			Cell R6cell40 = R6row.getCell(42);
			if (R6cell40 != null) {
				R6cell40.setCellValue(
						brf94.getR6_amount_trade_sme() == null ? 0 : brf94.getR6_amount_trade_sme().intValue());
			}
			Cell R6cell41 = R6row.getCell(43);
			if (R6cell41 != null) {
				R6cell41.setCellValue(brf94.getR6_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR6_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R6cell42 = R6row.getCell(44);
			if (R6cell42 != null) {
				R6cell42.setCellValue(brf94.getR6_amount_financial_investment_individual() == null ? 0
						: brf94.getR6_amount_financial_investment_individual().intValue());
			}
			Cell R6cell43 = R6row.getCell(45);
			if (R6cell43 != null) {
				R6cell43.setCellValue(brf94.getR6_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR6_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R6cell44 = R6row.getCell(46);
			if (R6cell44 != null) {
				R6cell44.setCellValue(brf94.getR6_amount_direct_investment_individual() == null ? 0
						: brf94.getR6_amount_direct_investment_individual().intValue());
			}
			Cell R6cell45 = R6row.getCell(47);
			if (R6cell45 != null) {
				R6cell45.setCellValue(brf94.getR6_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR6_no_of_transactions_family_support_individual().intValue());
			}
			Cell R6cell46 = R6row.getCell(48);
			if (R6cell46 != null) {
				R6cell46.setCellValue(brf94.getR6_amount_family_support_individual() == null ? 0
						: brf94.getR6_amount_family_support_individual().intValue());
			}
			Cell R6cell47 = R6row.getCell(49);
			if (R6cell47 != null) {
				R6cell47.setCellValue(brf94.getR6_no_of_transactions_education_individual() == null ? 0
						: brf94.getR6_no_of_transactions_education_individual().intValue());
			}
			Cell R6cell48 = R6row.getCell(50);
			if (R6cell48 != null) {
				R6cell48.setCellValue(brf94.getR6_amount_education_individual() == null ? 0
						: brf94.getR6_amount_education_individual().intValue());
			}
			Cell R6cell49 = R6row.getCell(51);
			if (R6cell49 != null) {
				R6cell49.setCellValue(brf94.getR6_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR6_no_of_transactions_medical_individual().intValue());
			}

			Cell R6cell50 = R6row.getCell(52);
			if (R6cell50 != null) {
				R6cell50.setCellValue(brf94.getR6_amount_medical_individual() == null ? 0
						: brf94.getR6_amount_medical_individual().intValue());
			}
			Cell R6cell51 = R6row.getCell(53);
			if (R6cell51 != null) {
				R6cell51.setCellValue(brf94.getR6_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR6_no_of_transactions_tourism_individual().intValue());
			}
			Cell R6cell52 = R6row.getCell(54);
			if (R6cell52 != null) {
				R6cell52.setCellValue(brf94.getR6_amount_tourism_individual() == null ? 0
						: brf94.getR6_amount_tourism_individual().intValue());
			}
			Cell R6cell53 = R6row.getCell(55);
			if (R6cell53 != null) {
				R6cell53.setCellValue(brf94.getR6_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR6_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R6cell54 = R6row.getCell(56);
			if (R6cell54 != null) {
				R6cell54.setCellValue(brf94.getR6_amount_debt_settlement_individual() == null ? 0
						: brf94.getR6_amount_debt_settlement_individual().intValue());
			}
			Cell R6cell55 = R6row.getCell(57);
			if (R6cell55 != null) {
				R6cell55.setCellValue(brf94.getR6_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR6_no_of_transactions_other_services_individual().intValue());
			}

			Cell R6cell56 = R6row.getCell(58);
			if (R6cell56 != null) {
				R6cell56.setCellValue(brf94.getR6_amount_other_services_individual() == null ? 0
						: brf94.getR6_amount_other_services_individual().intValue());
			}

			Row R7row = sheet.getRow(15);
			Cell R7cell1 = R7row.getCell(3);
			if (R7cell1 != null) {
				R7cell1.setCellValue(brf94.getR7_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR7_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R7cell2 = R7row.getCell(4);
			if (R7cell2 != null) {
				R7cell2.setCellValue(brf94.getR7_amount_financial_investment_government() == null ? 0
						: brf94.getR7_amount_financial_investment_government().intValue());
			}
			Cell R7cell3 = R7row.getCell(5);
			if (R7cell3 != null) {
				R7cell3.setCellValue(brf94.getR7_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR7_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R7cell4 = R7row.getCell(6);
			if (R7cell4 != null) {
				R7cell4.setCellValue(brf94.getR7_amount_direct_investment_government() == null ? 0
						: brf94.getR7_amount_direct_investment_government().intValue());
			}
			Cell R7cell5 = R7row.getCell(7);
			if (R7cell5 != null) {
				R7cell5.setCellValue(brf94.getR7_no_of_transactions_services_government() == null ? 0
						: brf94.getR7_no_of_transactions_services_government().intValue());
			}
			Cell R7cell6 = R7row.getCell(8);
			if (R7cell6 != null) {
				R7cell6.setCellValue(brf94.getR7_amount_services_government() == null ? 0
						: brf94.getR7_amount_services_government().intValue());
			}
			Cell R7cell7 = R7row.getCell(9);
			if (R7cell7 != null) {
				R7cell7.setCellValue(brf94.getR7_no_of_transactions_trade_government() == null ? 0
						: brf94.getR7_no_of_transactions_trade_government().intValue());
			}
			Cell R7cell8 = R7row.getCell(10);
			if (R7cell8 != null) {
				R7cell8.setCellValue(brf94.getR7_amount_trade_government() == null ? 0
						: brf94.getR7_amount_trade_government().intValue());
			}
			Cell R7cell9 = R7row.getCell(11);
			if (R7cell9 != null) {
				R7cell9.setCellValue(brf94.getR7_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR7_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R7cell10 = R7row.getCell(12);
			if (R7cell10 != null) {
				R7cell10.setCellValue(brf94.getR7_amount_financial_investment_reserve() == null ? 0
						: brf94.getR7_amount_financial_investment_reserve().intValue());
			}
			Cell R7cell11 = R7row.getCell(13);
			if (R7cell11 != null) {
				R7cell11.setCellValue(brf94.getR7_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR7_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R7cell12 = R7row.getCell(14);
			if (R7cell12 != null) {
				R7cell12.setCellValue(brf94.getR7_amount_direct_investment_reserve() == null ? 0
						: brf94.getR7_amount_direct_investment_reserve().intValue());
			}
			Cell R7cell13 = R7row.getCell(15);
			if (R7cell13 != null) {
				R7cell13.setCellValue(brf94.getR7_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR7_no_of_transactions_services_reserve().intValue());
			}
			Cell R7cell14 = R7row.getCell(16);
			if (R7cell14 != null) {
				R7cell14.setCellValue(brf94.getR7_amount_services_reserve() == null ? 0
						: brf94.getR7_amount_services_reserve().intValue());
			}
			Cell R7cell15 = R7row.getCell(17);
			if (R7cell15 != null) {
				R7cell15.setCellValue(brf94.getR7_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR7_no_of_transactions_trade_reserve().intValue());
			}
			Cell R7cell16 = R7row.getCell(18);
			if (R7cell16 != null) {
				R7cell16.setCellValue(
						brf94.getR7_amount_trade_reserve() == null ? 0 : brf94.getR7_amount_trade_reserve().intValue());
			}
			Cell R7cell17 = R7row.getCell(19);
			if (R7cell17 != null) {
				R7cell17.setCellValue(brf94.getR7_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR7_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R7cell18 = R7row.getCell(20);
			if (R7cell18 != null) {
				R7cell18.setCellValue(brf94.getR7_amount_financial_investment_gre() == null ? 0
						: brf94.getR7_amount_financial_investment_gre().intValue());
			}
			Cell R7cell19 = R7row.getCell(21);
			if (R7cell19 != null) {
				R7cell19.setCellValue(brf94.getR7_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR7_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R7cell20 = R7row.getCell(22);
			if (R7cell20 != null) {
				R7cell20.setCellValue(brf94.getR7_amount_direct_investment_gre() == null ? 0
						: brf94.getR7_amount_direct_investment_gre().intValue());
			}
			Cell R7cell21 = R7row.getCell(23);
			if (R7cell21 != null) {
				R7cell21.setCellValue(brf94.getR7_no_of_transactions_services_gre() == null ? 0
						: brf94.getR7_no_of_transactions_services_gre().intValue());
			}
			Cell R7cell22 = R7row.getCell(24);
			if (R7cell22 != null) {
				R7cell22.setCellValue(
						brf94.getR7_amount_services_gre() == null ? 0 : brf94.getR7_amount_services_gre().intValue());
			}
			Cell R7cell23 = R7row.getCell(25);
			if (R7cell23 != null) {
				R7cell23.setCellValue(brf94.getR7_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR7_no_of_transactions_trade_gre().intValue());
			}
			Cell R7cell24 = R7row.getCell(26);
			if (R7cell24 != null) {
				R7cell24.setCellValue(
						brf94.getR7_amount_trade_gre() == null ? 0 : brf94.getR7_amount_trade_gre().intValue());
			}
			Cell R7cell25 = R7row.getCell(27);
			if (R7cell25 != null) {
				R7cell25.setCellValue(brf94.getR7_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR7_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R7cell26 = R7row.getCell(28);
			if (R7cell26 != null) {
				R7cell26.setCellValue(brf94.getR7_amount_financial_investment_corporate() == null ? 0
						: brf94.getR7_amount_financial_investment_corporate().intValue());
			}
			Cell R7cell27 = R7row.getCell(29);
			if (R7cell27 != null) {
				R7cell27.setCellValue(brf94.getR7_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR7_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R7cell28 = R7row.getCell(30);
			if (R7cell28 != null) {
				R7cell28.setCellValue(brf94.getR7_amount_direct_investment_corporate() == null ? 0
						: brf94.getR7_amount_direct_investment_corporate().intValue());
			}
			Cell R7cell29 = R7row.getCell(31);
			if (R7cell29 != null) {
				R7cell29.setCellValue(brf94.getR7_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR7_no_of_transactions_services_corporate().intValue());
			}
			Cell R7cell30 = R7row.getCell(32);
			if (R7cell30 != null) {
				R7cell30.setCellValue(brf94.getR7_amount_services_corporate() == null ? 0
						: brf94.getR7_amount_services_corporate().intValue());
			}
			Cell R7cell31 = R7row.getCell(33);
			if (R7cell31 != null) {
				R7cell31.setCellValue(brf94.getR7_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR7_no_of_transactions_trade_corporate().intValue());
			}
			Cell R7cell32 = R7row.getCell(34);
			if (R7cell32 != null) {
				R7cell32.setCellValue(brf94.getR7_amount_trade_corporate() == null ? 0
						: brf94.getR7_amount_trade_corporate().intValue());
			}
			Cell R7cell33 = R7row.getCell(35);
			if (R7cell33 != null) {
				R7cell33.setCellValue(brf94.getR7_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR7_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R7cell34 = R7row.getCell(36);
			if (R7cell34 != null) {
				R7cell34.setCellValue(brf94.getR7_amount_financial_investment_sme() == null ? 0
						: brf94.getR7_amount_financial_investment_sme().intValue());
			}
			Cell R7cell35 = R7row.getCell(37);
			if (R7cell35 != null) {
				R7cell35.setCellValue(brf94.getR7_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR7_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R7cell36 = R7row.getCell(38);
			if (R7cell36 != null) {
				R7cell36.setCellValue(brf94.getR7_amount_direct_investment_sme() == null ? 0
						: brf94.getR7_amount_direct_investment_sme().intValue());
			}
			Cell R7cell37 = R7row.getCell(39);
			if (R7cell37 != null) {
				R7cell37.setCellValue(brf94.getR7_no_of_transactions_services_sme() == null ? 0
						: brf94.getR7_no_of_transactions_services_sme().intValue());
			}
			Cell R7cell38 = R7row.getCell(40);
			if (R7cell38 != null) {
				R7cell38.setCellValue(
						brf94.getR7_amount_services_sme() == null ? 0 : brf94.getR7_amount_services_sme().intValue());
			}
			Cell R7cell39 = R7row.getCell(41);
			if (R7cell39 != null) {
				R7cell39.setCellValue(brf94.getR7_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR7_no_of_transactions_trade_sme().intValue());
			}
			Cell R7cell40 = R7row.getCell(42);
			if (R7cell40 != null) {
				R7cell40.setCellValue(
						brf94.getR7_amount_trade_sme() == null ? 0 : brf94.getR7_amount_trade_sme().intValue());
			}
			Cell R7cell41 = R7row.getCell(43);
			if (R7cell41 != null) {
				R7cell41.setCellValue(brf94.getR7_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR7_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R7cell42 = R7row.getCell(44);
			if (R7cell42 != null) {
				R7cell42.setCellValue(brf94.getR7_amount_financial_investment_individual() == null ? 0
						: brf94.getR7_amount_financial_investment_individual().intValue());
			}
			Cell R7cell43 = R7row.getCell(45);
			if (R7cell43 != null) {
				R7cell43.setCellValue(brf94.getR7_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR7_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R7cell44 = R7row.getCell(46);
			if (R7cell44 != null) {
				R7cell44.setCellValue(brf94.getR7_amount_direct_investment_individual() == null ? 0
						: brf94.getR7_amount_direct_investment_individual().intValue());
			}
			Cell R7cell45 = R7row.getCell(47);
			if (R7cell45 != null) {
				R7cell45.setCellValue(brf94.getR7_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR7_no_of_transactions_family_support_individual().intValue());
			}
			Cell R7cell46 = R7row.getCell(48);
			if (R7cell46 != null) {
				R7cell46.setCellValue(brf94.getR7_amount_family_support_individual() == null ? 0
						: brf94.getR7_amount_family_support_individual().intValue());
			}
			Cell R7cell47 = R7row.getCell(49);
			if (R7cell47 != null) {
				R7cell47.setCellValue(brf94.getR7_no_of_transactions_education_individual() == null ? 0
						: brf94.getR7_no_of_transactions_education_individual().intValue());
			}
			Cell R7cell48 = R7row.getCell(50);
			if (R7cell48 != null) {
				R7cell48.setCellValue(brf94.getR7_amount_education_individual() == null ? 0
						: brf94.getR7_amount_education_individual().intValue());
			}
			Cell R7cell49 = R7row.getCell(51);
			if (R7cell49 != null) {
				R7cell49.setCellValue(brf94.getR7_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR7_no_of_transactions_medical_individual().intValue());
			}

			Cell R7cell50 = R7row.getCell(52);
			if (R7cell50 != null) {
				R7cell50.setCellValue(brf94.getR7_amount_medical_individual() == null ? 0
						: brf94.getR7_amount_medical_individual().intValue());
			}
			Cell R7cell51 = R7row.getCell(53);
			if (R7cell51 != null) {
				R7cell51.setCellValue(brf94.getR7_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR7_no_of_transactions_tourism_individual().intValue());
			}
			Cell R7cell52 = R7row.getCell(54);
			if (R7cell52 != null) {
				R7cell52.setCellValue(brf94.getR7_amount_tourism_individual() == null ? 0
						: brf94.getR7_amount_tourism_individual().intValue());
			}
			Cell R7cell53 = R7row.getCell(55);
			if (R7cell53 != null) {
				R7cell53.setCellValue(brf94.getR7_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR7_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R7cell54 = R7row.getCell(56);
			if (R7cell54 != null) {
				R7cell54.setCellValue(brf94.getR7_amount_debt_settlement_individual() == null ? 0
						: brf94.getR7_amount_debt_settlement_individual().intValue());
			}
			Cell R7cell55 = R7row.getCell(57);
			if (R7cell55 != null) {
				R7cell55.setCellValue(brf94.getR7_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR7_no_of_transactions_other_services_individual().intValue());
			}

			Cell R7cell56 = R7row.getCell(58);
			if (R7cell56 != null) {
				R7cell56.setCellValue(brf94.getR7_amount_other_services_individual() == null ? 0
						: brf94.getR7_amount_other_services_individual().intValue());
			}

			Row R8row = sheet.getRow(16);
			Cell R8cell1 = R8row.getCell(3);
			if (R8cell1 != null) {
				R8cell1.setCellValue(brf94.getR8_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR8_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R8cell2 = R8row.getCell(4);
			if (R8cell2 != null) {
				R8cell2.setCellValue(brf94.getR8_amount_financial_investment_government() == null ? 0
						: brf94.getR8_amount_financial_investment_government().intValue());
			}
			Cell R8cell3 = R8row.getCell(5);
			if (R8cell3 != null) {
				R8cell3.setCellValue(brf94.getR8_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR8_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R8cell4 = R8row.getCell(6);
			if (R8cell4 != null) {
				R8cell4.setCellValue(brf94.getR8_amount_direct_investment_government() == null ? 0
						: brf94.getR8_amount_direct_investment_government().intValue());
			}
			Cell R8cell5 = R8row.getCell(7);
			if (R8cell5 != null) {
				R8cell5.setCellValue(brf94.getR8_no_of_transactions_services_government() == null ? 0
						: brf94.getR8_no_of_transactions_services_government().intValue());
			}
			Cell R8cell6 = R8row.getCell(8);
			if (R8cell6 != null) {
				R8cell6.setCellValue(brf94.getR8_amount_services_government() == null ? 0
						: brf94.getR8_amount_services_government().intValue());
			}
			Cell R8cell7 = R8row.getCell(9);
			if (R8cell7 != null) {
				R8cell7.setCellValue(brf94.getR8_no_of_transactions_trade_government() == null ? 0
						: brf94.getR8_no_of_transactions_trade_government().intValue());
			}
			Cell R8cell8 = R8row.getCell(10);
			if (R8cell8 != null) {
				R8cell8.setCellValue(brf94.getR8_amount_trade_government() == null ? 0
						: brf94.getR8_amount_trade_government().intValue());
			}
			Cell R8cell9 = R8row.getCell(11);
			if (R8cell9 != null) {
				R8cell9.setCellValue(brf94.getR8_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR8_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R8cell10 = R8row.getCell(12);
			if (R8cell10 != null) {
				R8cell10.setCellValue(brf94.getR8_amount_financial_investment_reserve() == null ? 0
						: brf94.getR8_amount_financial_investment_reserve().intValue());
			}
			Cell R8cell11 = R8row.getCell(13);
			if (R8cell11 != null) {
				R8cell11.setCellValue(brf94.getR8_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR8_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R8cell12 = R8row.getCell(14);
			if (R8cell12 != null) {
				R8cell12.setCellValue(brf94.getR8_amount_direct_investment_reserve() == null ? 0
						: brf94.getR8_amount_direct_investment_reserve().intValue());
			}
			Cell R8cell13 = R8row.getCell(15);
			if (R8cell13 != null) {
				R8cell13.setCellValue(brf94.getR8_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR8_no_of_transactions_services_reserve().intValue());
			}
			Cell R8cell14 = R8row.getCell(16);
			if (R8cell14 != null) {
				R8cell14.setCellValue(brf94.getR8_amount_services_reserve() == null ? 0
						: brf94.getR8_amount_services_reserve().intValue());
			}
			Cell R8cell15 = R8row.getCell(17);
			if (R8cell15 != null) {
				R8cell15.setCellValue(brf94.getR8_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR8_no_of_transactions_trade_reserve().intValue());
			}
			Cell R8cell16 = R8row.getCell(18);
			if (R8cell16 != null) {
				R8cell16.setCellValue(
						brf94.getR8_amount_trade_reserve() == null ? 0 : brf94.getR8_amount_trade_reserve().intValue());
			}
			Cell R8cell17 = R8row.getCell(19);
			if (R8cell17 != null) {
				R8cell17.setCellValue(brf94.getR8_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR8_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R8cell18 = R8row.getCell(20);
			if (R8cell18 != null) {
				R8cell18.setCellValue(brf94.getR8_amount_financial_investment_gre() == null ? 0
						: brf94.getR8_amount_financial_investment_gre().intValue());
			}
			Cell R8cell19 = R8row.getCell(21);
			if (R8cell19 != null) {
				R8cell19.setCellValue(brf94.getR8_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR8_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R8cell20 = R8row.getCell(22);
			if (R8cell20 != null) {
				R8cell20.setCellValue(brf94.getR8_amount_direct_investment_gre() == null ? 0
						: brf94.getR8_amount_direct_investment_gre().intValue());
			}
			Cell R8cell21 = R8row.getCell(23);
			if (R8cell21 != null) {
				R8cell21.setCellValue(brf94.getR8_no_of_transactions_services_gre() == null ? 0
						: brf94.getR8_no_of_transactions_services_gre().intValue());
			}
			Cell R8cell22 = R8row.getCell(24);
			if (R8cell22 != null) {
				R8cell22.setCellValue(
						brf94.getR8_amount_services_gre() == null ? 0 : brf94.getR8_amount_services_gre().intValue());
			}
			Cell R8cell23 = R8row.getCell(25);
			if (R8cell23 != null) {
				R8cell23.setCellValue(brf94.getR8_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR8_no_of_transactions_trade_gre().intValue());
			}
			Cell R8cell24 = R8row.getCell(26);
			if (R8cell24 != null) {
				R8cell24.setCellValue(
						brf94.getR8_amount_trade_gre() == null ? 0 : brf94.getR8_amount_trade_gre().intValue());
			}
			Cell R8cell25 = R8row.getCell(27);
			if (R8cell25 != null) {
				R8cell25.setCellValue(brf94.getR8_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR8_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R8cell26 = R8row.getCell(28);
			if (R8cell26 != null) {
				R8cell26.setCellValue(brf94.getR8_amount_financial_investment_corporate() == null ? 0
						: brf94.getR8_amount_financial_investment_corporate().intValue());
			}
			Cell R8cell27 = R8row.getCell(29);
			if (R8cell27 != null) {
				R8cell27.setCellValue(brf94.getR8_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR8_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R8cell28 = R8row.getCell(30);
			if (R8cell28 != null) {
				R8cell28.setCellValue(brf94.getR8_amount_direct_investment_corporate() == null ? 0
						: brf94.getR8_amount_direct_investment_corporate().intValue());
			}
			Cell R8cell29 = R8row.getCell(31);
			if (R8cell29 != null) {
				R8cell29.setCellValue(brf94.getR8_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR8_no_of_transactions_services_corporate().intValue());
			}
			Cell R8cell30 = R8row.getCell(32);
			if (R8cell30 != null) {
				R8cell30.setCellValue(brf94.getR8_amount_services_corporate() == null ? 0
						: brf94.getR8_amount_services_corporate().intValue());
			}
			Cell R8cell31 = R8row.getCell(33);
			if (R8cell31 != null) {
				R8cell31.setCellValue(brf94.getR8_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR8_no_of_transactions_trade_corporate().intValue());
			}
			Cell R8cell32 = R8row.getCell(34);
			if (R8cell32 != null) {
				R8cell32.setCellValue(brf94.getR8_amount_trade_corporate() == null ? 0
						: brf94.getR8_amount_trade_corporate().intValue());
			}
			Cell R8cell33 = R8row.getCell(35);
			if (R8cell33 != null) {
				R8cell33.setCellValue(brf94.getR8_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR8_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R8cell34 = R8row.getCell(36);
			if (R8cell34 != null) {
				R8cell34.setCellValue(brf94.getR8_amount_financial_investment_sme() == null ? 0
						: brf94.getR8_amount_financial_investment_sme().intValue());
			}
			Cell R8cell35 = R8row.getCell(37);
			if (R8cell35 != null) {
				R8cell35.setCellValue(brf94.getR8_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR8_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R8cell36 = R8row.getCell(38);
			if (R8cell36 != null) {
				R8cell36.setCellValue(brf94.getR8_amount_direct_investment_sme() == null ? 0
						: brf94.getR8_amount_direct_investment_sme().intValue());
			}
			Cell R8cell37 = R8row.getCell(39);
			if (R8cell37 != null) {
				R8cell37.setCellValue(brf94.getR8_no_of_transactions_services_sme() == null ? 0
						: brf94.getR8_no_of_transactions_services_sme().intValue());
			}
			Cell R8cell38 = R8row.getCell(40);
			if (R8cell38 != null) {
				R8cell38.setCellValue(
						brf94.getR8_amount_services_sme() == null ? 0 : brf94.getR8_amount_services_sme().intValue());
			}
			Cell R8cell39 = R8row.getCell(41);
			if (R8cell39 != null) {
				R8cell39.setCellValue(brf94.getR8_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR8_no_of_transactions_trade_sme().intValue());
			}
			Cell R8cell40 = R8row.getCell(42);
			if (R8cell40 != null) {
				R8cell40.setCellValue(
						brf94.getR8_amount_trade_sme() == null ? 0 : brf94.getR8_amount_trade_sme().intValue());
			}
			Cell R8cell41 = R8row.getCell(43);
			if (R8cell41 != null) {
				R8cell41.setCellValue(brf94.getR8_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR8_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R8cell42 = R8row.getCell(44);
			if (R8cell42 != null) {
				R8cell42.setCellValue(brf94.getR8_amount_financial_investment_individual() == null ? 0
						: brf94.getR8_amount_financial_investment_individual().intValue());
			}
			Cell R8cell43 = R8row.getCell(45);
			if (R8cell43 != null) {
				R8cell43.setCellValue(brf94.getR8_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR8_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R8cell44 = R8row.getCell(46);
			if (R8cell44 != null) {
				R8cell44.setCellValue(brf94.getR8_amount_direct_investment_individual() == null ? 0
						: brf94.getR8_amount_direct_investment_individual().intValue());
			}
			Cell R8cell45 = R8row.getCell(47);
			if (R8cell45 != null) {
				R8cell45.setCellValue(brf94.getR8_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR8_no_of_transactions_family_support_individual().intValue());
			}
			Cell R8cell46 = R8row.getCell(48);
			if (R8cell46 != null) {
				R8cell46.setCellValue(brf94.getR8_amount_family_support_individual() == null ? 0
						: brf94.getR8_amount_family_support_individual().intValue());
			}
			Cell R8cell47 = R8row.getCell(49);
			if (R8cell47 != null) {
				R8cell47.setCellValue(brf94.getR8_no_of_transactions_education_individual() == null ? 0
						: brf94.getR8_no_of_transactions_education_individual().intValue());
			}
			Cell R8cell48 = R8row.getCell(50);
			if (R8cell48 != null) {
				R8cell48.setCellValue(brf94.getR8_amount_education_individual() == null ? 0
						: brf94.getR8_amount_education_individual().intValue());
			}
			Cell R8cell49 = R8row.getCell(51);
			if (R8cell49 != null) {
				R8cell49.setCellValue(brf94.getR8_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR8_no_of_transactions_medical_individual().intValue());
			}

			Cell R8cell50 = R8row.getCell(52);
			if (R8cell50 != null) {
				R8cell50.setCellValue(brf94.getR8_amount_medical_individual() == null ? 0
						: brf94.getR8_amount_medical_individual().intValue());
			}
			Cell R8cell51 = R8row.getCell(53);
			if (R8cell51 != null) {
				R8cell51.setCellValue(brf94.getR8_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR8_no_of_transactions_tourism_individual().intValue());
			}
			Cell R8cell52 = R8row.getCell(54);
			if (R8cell52 != null) {
				R8cell52.setCellValue(brf94.getR8_amount_tourism_individual() == null ? 0
						: brf94.getR8_amount_tourism_individual().intValue());
			}
			Cell R8cell53 = R8row.getCell(55);
			if (R8cell53 != null) {
				R8cell53.setCellValue(brf94.getR8_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR8_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R8cell54 = R8row.getCell(56);
			if (R8cell54 != null) {
				R8cell54.setCellValue(brf94.getR8_amount_debt_settlement_individual() == null ? 0
						: brf94.getR8_amount_debt_settlement_individual().intValue());
			}
			Cell R8cell55 = R8row.getCell(57);
			if (R8cell55 != null) {
				R8cell55.setCellValue(brf94.getR8_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR8_no_of_transactions_other_services_individual().intValue());
			}

			Cell R8cell56 = R8row.getCell(58);
			if (R8cell56 != null) {
				R8cell56.setCellValue(brf94.getR8_amount_other_services_individual() == null ? 0
						: brf94.getR8_amount_other_services_individual().intValue());
			}

			Row R9row = sheet.getRow(17);
			Cell R9cell1 = R9row.getCell(3);
			if (R9cell1 != null) {
				R9cell1.setCellValue(brf94.getR9_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR9_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R9cell2 = R9row.getCell(4);
			if (R9cell2 != null) {
				R9cell2.setCellValue(brf94.getR9_amount_financial_investment_government() == null ? 0
						: brf94.getR9_amount_financial_investment_government().intValue());
			}
			Cell R9cell3 = R9row.getCell(5);
			if (R9cell3 != null) {
				R9cell3.setCellValue(brf94.getR9_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR9_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R9cell4 = R9row.getCell(6);
			if (R9cell4 != null) {
				R9cell4.setCellValue(brf94.getR9_amount_direct_investment_government() == null ? 0
						: brf94.getR9_amount_direct_investment_government().intValue());
			}
			Cell R9cell5 = R9row.getCell(7);
			if (R9cell5 != null) {
				R9cell5.setCellValue(brf94.getR9_no_of_transactions_services_government() == null ? 0
						: brf94.getR9_no_of_transactions_services_government().intValue());
			}
			Cell R9cell6 = R9row.getCell(8);
			if (R9cell6 != null) {
				R9cell6.setCellValue(brf94.getR9_amount_services_government() == null ? 0
						: brf94.getR9_amount_services_government().intValue());
			}
			Cell R9cell7 = R9row.getCell(9);
			if (R9cell7 != null) {
				R9cell7.setCellValue(brf94.getR9_no_of_transactions_trade_government() == null ? 0
						: brf94.getR9_no_of_transactions_trade_government().intValue());
			}
			Cell R9cell8 = R9row.getCell(10);
			if (R9cell8 != null) {
				R9cell8.setCellValue(brf94.getR9_amount_trade_government() == null ? 0
						: brf94.getR9_amount_trade_government().intValue());
			}
			Cell R9cell9 = R9row.getCell(11);
			if (R9cell9 != null) {
				R9cell9.setCellValue(brf94.getR9_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR9_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R9cell10 = R9row.getCell(12);
			if (R9cell10 != null) {
				R9cell10.setCellValue(brf94.getR9_amount_financial_investment_reserve() == null ? 0
						: brf94.getR9_amount_financial_investment_reserve().intValue());
			}
			Cell R9cell11 = R9row.getCell(13);
			if (R9cell11 != null) {
				R9cell11.setCellValue(brf94.getR9_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR9_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R9cell12 = R9row.getCell(14);
			if (R9cell12 != null) {
				R9cell12.setCellValue(brf94.getR9_amount_direct_investment_reserve() == null ? 0
						: brf94.getR9_amount_direct_investment_reserve().intValue());
			}
			Cell R9cell13 = R9row.getCell(15);
			if (R9cell13 != null) {
				R9cell13.setCellValue(brf94.getR9_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR9_no_of_transactions_services_reserve().intValue());
			}
			Cell R9cell14 = R9row.getCell(16);
			if (R9cell14 != null) {
				R9cell14.setCellValue(brf94.getR9_amount_services_reserve() == null ? 0
						: brf94.getR9_amount_services_reserve().intValue());
			}
			Cell R9cell15 = R9row.getCell(17);
			if (R9cell15 != null) {
				R9cell15.setCellValue(brf94.getR9_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR9_no_of_transactions_trade_reserve().intValue());
			}
			Cell R9cell16 = R9row.getCell(18);
			if (R9cell16 != null) {
				R9cell16.setCellValue(
						brf94.getR9_amount_trade_reserve() == null ? 0 : brf94.getR9_amount_trade_reserve().intValue());
			}
			Cell R9cell17 = R9row.getCell(19);
			if (R9cell17 != null) {
				R9cell17.setCellValue(brf94.getR9_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR9_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R9cell18 = R9row.getCell(20);
			if (R9cell18 != null) {
				R9cell18.setCellValue(brf94.getR9_amount_financial_investment_gre() == null ? 0
						: brf94.getR9_amount_financial_investment_gre().intValue());
			}
			Cell R9cell19 = R9row.getCell(21);
			if (R9cell19 != null) {
				R9cell19.setCellValue(brf94.getR9_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR9_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R9cell20 = R9row.getCell(22);
			if (R9cell20 != null) {
				R9cell20.setCellValue(brf94.getR9_amount_direct_investment_gre() == null ? 0
						: brf94.getR9_amount_direct_investment_gre().intValue());
			}
			Cell R9cell21 = R9row.getCell(23);
			if (R9cell21 != null) {
				R9cell21.setCellValue(brf94.getR9_no_of_transactions_services_gre() == null ? 0
						: brf94.getR9_no_of_transactions_services_gre().intValue());
			}
			Cell R9cell22 = R9row.getCell(24);
			if (R9cell22 != null) {
				R9cell22.setCellValue(
						brf94.getR9_amount_services_gre() == null ? 0 : brf94.getR9_amount_services_gre().intValue());
			}
			Cell R9cell23 = R9row.getCell(25);
			if (R9cell23 != null) {
				R9cell23.setCellValue(brf94.getR9_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR9_no_of_transactions_trade_gre().intValue());
			}
			Cell R9cell24 = R9row.getCell(26);
			if (R9cell24 != null) {
				R9cell24.setCellValue(
						brf94.getR9_amount_trade_gre() == null ? 0 : brf94.getR9_amount_trade_gre().intValue());
			}
			Cell R9cell25 = R9row.getCell(27);
			if (R9cell25 != null) {
				R9cell25.setCellValue(brf94.getR9_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR9_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R9cell26 = R9row.getCell(28);
			if (R9cell26 != null) {
				R9cell26.setCellValue(brf94.getR9_amount_financial_investment_corporate() == null ? 0
						: brf94.getR9_amount_financial_investment_corporate().intValue());
			}
			Cell R9cell27 = R9row.getCell(29);
			if (R9cell27 != null) {
				R9cell27.setCellValue(brf94.getR9_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR9_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R9cell28 = R9row.getCell(30);
			if (R9cell28 != null) {
				R9cell28.setCellValue(brf94.getR9_amount_direct_investment_corporate() == null ? 0
						: brf94.getR9_amount_direct_investment_corporate().intValue());
			}
			Cell R9cell29 = R9row.getCell(31);
			if (R9cell29 != null) {
				R9cell29.setCellValue(brf94.getR9_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR9_no_of_transactions_services_corporate().intValue());
			}
			Cell R9cell30 = R9row.getCell(32);
			if (R9cell30 != null) {
				R9cell30.setCellValue(brf94.getR9_amount_services_corporate() == null ? 0
						: brf94.getR9_amount_services_corporate().intValue());
			}
			Cell R9cell31 = R9row.getCell(33);
			if (R9cell31 != null) {
				R9cell31.setCellValue(brf94.getR9_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR9_no_of_transactions_trade_corporate().intValue());
			}
			Cell R9cell32 = R9row.getCell(34);
			if (R9cell32 != null) {
				R9cell32.setCellValue(brf94.getR9_amount_trade_corporate() == null ? 0
						: brf94.getR9_amount_trade_corporate().intValue());
			}
			Cell R9cell33 = R9row.getCell(35);
			if (R9cell33 != null) {
				R9cell33.setCellValue(brf94.getR9_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR9_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R9cell34 = R9row.getCell(36);
			if (R9cell34 != null) {
				R9cell34.setCellValue(brf94.getR9_amount_financial_investment_sme() == null ? 0
						: brf94.getR9_amount_financial_investment_sme().intValue());
			}
			Cell R9cell35 = R9row.getCell(37);
			if (R9cell35 != null) {
				R9cell35.setCellValue(brf94.getR9_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR9_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R9cell36 = R9row.getCell(38);
			if (R9cell36 != null) {
				R9cell36.setCellValue(brf94.getR9_amount_direct_investment_sme() == null ? 0
						: brf94.getR9_amount_direct_investment_sme().intValue());
			}
			Cell R9cell37 = R9row.getCell(39);
			if (R9cell37 != null) {
				R9cell37.setCellValue(brf94.getR9_no_of_transactions_services_sme() == null ? 0
						: brf94.getR9_no_of_transactions_services_sme().intValue());
			}
			Cell R9cell38 = R9row.getCell(40);
			if (R9cell38 != null) {
				R9cell38.setCellValue(
						brf94.getR9_amount_services_sme() == null ? 0 : brf94.getR9_amount_services_sme().intValue());
			}
			Cell R9cell39 = R9row.getCell(41);
			if (R9cell39 != null) {
				R9cell39.setCellValue(brf94.getR9_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR9_no_of_transactions_trade_sme().intValue());
			}
			Cell R9cell40 = R9row.getCell(42);
			if (R9cell40 != null) {
				R9cell40.setCellValue(
						brf94.getR9_amount_trade_sme() == null ? 0 : brf94.getR9_amount_trade_sme().intValue());
			}
			Cell R9cell41 = R9row.getCell(43);
			if (R9cell41 != null) {
				R9cell41.setCellValue(brf94.getR9_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR9_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R9cell42 = R9row.getCell(44);
			if (R9cell42 != null) {
				R9cell42.setCellValue(brf94.getR9_amount_financial_investment_individual() == null ? 0
						: brf94.getR9_amount_financial_investment_individual().intValue());
			}
			Cell R9cell43 = R9row.getCell(45);
			if (R9cell43 != null) {
				R9cell43.setCellValue(brf94.getR9_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR9_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R9cell44 = R9row.getCell(46);
			if (R9cell44 != null) {
				R9cell44.setCellValue(brf94.getR9_amount_direct_investment_individual() == null ? 0
						: brf94.getR9_amount_direct_investment_individual().intValue());
			}
			Cell R9cell45 = R9row.getCell(47);
			if (R9cell45 != null) {
				R9cell45.setCellValue(brf94.getR9_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR9_no_of_transactions_family_support_individual().intValue());
			}
			Cell R9cell46 = R9row.getCell(48);
			if (R9cell46 != null) {
				R9cell46.setCellValue(brf94.getR9_amount_family_support_individual() == null ? 0
						: brf94.getR9_amount_family_support_individual().intValue());
			}
			Cell R9cell47 = R9row.getCell(49);
			if (R9cell47 != null) {
				R9cell47.setCellValue(brf94.getR9_no_of_transactions_education_individual() == null ? 0
						: brf94.getR9_no_of_transactions_education_individual().intValue());
			}
			Cell R9cell48 = R9row.getCell(50);
			if (R9cell48 != null) {
				R9cell48.setCellValue(brf94.getR9_amount_education_individual() == null ? 0
						: brf94.getR9_amount_education_individual().intValue());
			}
			Cell R9cell49 = R9row.getCell(51);
			if (R9cell49 != null) {
				R9cell49.setCellValue(brf94.getR9_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR9_no_of_transactions_medical_individual().intValue());
			}

			Cell R9cell50 = R9row.getCell(52);
			if (R9cell50 != null) {
				R9cell50.setCellValue(brf94.getR9_amount_medical_individual() == null ? 0
						: brf94.getR9_amount_medical_individual().intValue());
			}
			Cell R9cell51 = R9row.getCell(53);
			if (R9cell51 != null) {
				R9cell51.setCellValue(brf94.getR9_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR9_no_of_transactions_tourism_individual().intValue());
			}
			Cell R9cell52 = R9row.getCell(54);
			if (R9cell52 != null) {
				R9cell52.setCellValue(brf94.getR9_amount_tourism_individual() == null ? 0
						: brf94.getR9_amount_tourism_individual().intValue());
			}
			Cell R9cell53 = R9row.getCell(55);
			if (R9cell53 != null) {
				R9cell53.setCellValue(brf94.getR9_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR9_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R9cell54 = R9row.getCell(56);
			if (R9cell54 != null) {
				R9cell54.setCellValue(brf94.getR9_amount_debt_settlement_individual() == null ? 0
						: brf94.getR9_amount_debt_settlement_individual().intValue());
			}
			Cell R9cell55 = R9row.getCell(57);
			if (R9cell55 != null) {
				R9cell55.setCellValue(brf94.getR9_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR9_no_of_transactions_other_services_individual().intValue());
			}

			Cell R9cell56 = R9row.getCell(58);
			if (R9cell56 != null) {
				R9cell56.setCellValue(brf94.getR9_amount_other_services_individual() == null ? 0
						: brf94.getR9_amount_other_services_individual().intValue());
			}

			Row R10row = sheet.getRow(18);
			Cell R10cell1 = R10row.getCell(3);
			if (R10cell1 != null) {
				R10cell1.setCellValue(brf94.getR10_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR10_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R10cell2 = R10row.getCell(4);
			if (R10cell2 != null) {
				R10cell2.setCellValue(brf94.getR10_amount_financial_investment_government() == null ? 0
						: brf94.getR10_amount_financial_investment_government().intValue());
			}
			Cell R10cell3 = R10row.getCell(5);
			if (R10cell3 != null) {
				R10cell3.setCellValue(brf94.getR10_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR10_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R10cell4 = R10row.getCell(6);
			if (R10cell4 != null) {
				R10cell4.setCellValue(brf94.getR10_amount_direct_investment_government() == null ? 0
						: brf94.getR10_amount_direct_investment_government().intValue());
			}
			Cell R10cell5 = R10row.getCell(7);
			if (R10cell5 != null) {
				R10cell5.setCellValue(brf94.getR10_no_of_transactions_services_government() == null ? 0
						: brf94.getR10_no_of_transactions_services_government().intValue());
			}
			Cell R10cell6 = R10row.getCell(8);
			if (R10cell6 != null) {
				R10cell6.setCellValue(brf94.getR10_amount_services_government() == null ? 0
						: brf94.getR10_amount_services_government().intValue());
			}
			Cell R10cell7 = R10row.getCell(9);
			if (R10cell7 != null) {
				R10cell7.setCellValue(brf94.getR10_no_of_transactions_trade_government() == null ? 0
						: brf94.getR10_no_of_transactions_trade_government().intValue());
			}
			Cell R10cell8 = R10row.getCell(10);
			if (R10cell8 != null) {
				R10cell8.setCellValue(brf94.getR10_amount_trade_government() == null ? 0
						: brf94.getR10_amount_trade_government().intValue());
			}
			Cell R10cell9 = R10row.getCell(11);
			if (R10cell9 != null) {
				R10cell9.setCellValue(brf94.getR10_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR10_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R10cell10 = R10row.getCell(12);
			if (R10cell10 != null) {
				R10cell10.setCellValue(brf94.getR10_amount_financial_investment_reserve() == null ? 0
						: brf94.getR10_amount_financial_investment_reserve().intValue());
			}
			Cell R10cell11 = R10row.getCell(13);
			if (R10cell11 != null) {
				R10cell11.setCellValue(brf94.getR10_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR10_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R10cell12 = R10row.getCell(14);
			if (R10cell12 != null) {
				R10cell12.setCellValue(brf94.getR10_amount_direct_investment_reserve() == null ? 0
						: brf94.getR10_amount_direct_investment_reserve().intValue());
			}
			Cell R10cell13 = R10row.getCell(15);
			if (R10cell13 != null) {
				R10cell13.setCellValue(brf94.getR10_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR10_no_of_transactions_services_reserve().intValue());
			}
			Cell R10cell14 = R10row.getCell(16);
			if (R10cell14 != null) {
				R10cell14.setCellValue(brf94.getR10_amount_services_reserve() == null ? 0
						: brf94.getR10_amount_services_reserve().intValue());
			}
			Cell R10cell15 = R10row.getCell(17);
			if (R10cell15 != null) {
				R10cell15.setCellValue(brf94.getR10_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR10_no_of_transactions_trade_reserve().intValue());
			}
			Cell R10cell16 = R10row.getCell(18);
			if (R10cell16 != null) {
				R10cell16.setCellValue(brf94.getR10_amount_trade_reserve() == null ? 0
						: brf94.getR10_amount_trade_reserve().intValue());
			}
			Cell R10cell17 = R10row.getCell(19);
			if (R10cell17 != null) {
				R10cell17.setCellValue(brf94.getR10_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR10_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R10cell18 = R10row.getCell(20);
			if (R10cell18 != null) {
				R10cell18.setCellValue(brf94.getR10_amount_financial_investment_gre() == null ? 0
						: brf94.getR10_amount_financial_investment_gre().intValue());
			}
			Cell R10cell19 = R10row.getCell(21);
			if (R10cell19 != null) {
				R10cell19.setCellValue(brf94.getR10_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR10_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R10cell20 = R10row.getCell(22);
			if (R10cell20 != null) {
				R10cell20.setCellValue(brf94.getR10_amount_direct_investment_gre() == null ? 0
						: brf94.getR10_amount_direct_investment_gre().intValue());
			}
			Cell R10cell21 = R10row.getCell(23);
			if (R10cell21 != null) {
				R10cell21.setCellValue(brf94.getR10_no_of_transactions_services_gre() == null ? 0
						: brf94.getR10_no_of_transactions_services_gre().intValue());
			}
			Cell R10cell22 = R10row.getCell(24);
			if (R10cell22 != null) {
				R10cell22.setCellValue(
						brf94.getR10_amount_services_gre() == null ? 0 : brf94.getR10_amount_services_gre().intValue());
			}
			Cell R10cell23 = R10row.getCell(25);
			if (R10cell23 != null) {
				R10cell23.setCellValue(brf94.getR10_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR10_no_of_transactions_trade_gre().intValue());
			}
			Cell R10cell24 = R10row.getCell(26);
			if (R10cell24 != null) {
				R10cell24.setCellValue(
						brf94.getR10_amount_trade_gre() == null ? 0 : brf94.getR10_amount_trade_gre().intValue());
			}
			Cell R10cell25 = R10row.getCell(27);
			if (R10cell25 != null) {
				R10cell25.setCellValue(brf94.getR10_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR10_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R10cell26 = R10row.getCell(28);
			if (R10cell26 != null) {
				R10cell26.setCellValue(brf94.getR10_amount_financial_investment_corporate() == null ? 0
						: brf94.getR10_amount_financial_investment_corporate().intValue());
			}
			Cell R10cell27 = R10row.getCell(29);
			if (R10cell27 != null) {
				R10cell27.setCellValue(brf94.getR10_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR10_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R10cell28 = R10row.getCell(30);
			if (R10cell28 != null) {
				R10cell28.setCellValue(brf94.getR10_amount_direct_investment_corporate() == null ? 0
						: brf94.getR10_amount_direct_investment_corporate().intValue());
			}
			Cell R10cell29 = R10row.getCell(31);
			if (R10cell29 != null) {
				R10cell29.setCellValue(brf94.getR10_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR10_no_of_transactions_services_corporate().intValue());
			}
			Cell R10cell30 = R10row.getCell(32);
			if (R10cell30 != null) {
				R10cell30.setCellValue(brf94.getR10_amount_services_corporate() == null ? 0
						: brf94.getR10_amount_services_corporate().intValue());
			}
			Cell R10cell31 = R10row.getCell(33);
			if (R10cell31 != null) {
				R10cell31.setCellValue(brf94.getR10_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR10_no_of_transactions_trade_corporate().intValue());
			}
			Cell R10cell32 = R10row.getCell(34);
			if (R10cell32 != null) {
				R10cell32.setCellValue(brf94.getR10_amount_trade_corporate() == null ? 0
						: brf94.getR10_amount_trade_corporate().intValue());
			}
			Cell R10cell33 = R10row.getCell(35);
			if (R10cell33 != null) {
				R10cell33.setCellValue(brf94.getR10_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR10_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R10cell34 = R10row.getCell(36);
			if (R10cell34 != null) {
				R10cell34.setCellValue(brf94.getR10_amount_financial_investment_sme() == null ? 0
						: brf94.getR10_amount_financial_investment_sme().intValue());
			}
			Cell R10cell35 = R10row.getCell(37);
			if (R10cell35 != null) {
				R10cell35.setCellValue(brf94.getR10_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR10_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R10cell36 = R10row.getCell(38);
			if (R10cell36 != null) {
				R10cell36.setCellValue(brf94.getR10_amount_direct_investment_sme() == null ? 0
						: brf94.getR10_amount_direct_investment_sme().intValue());
			}
			Cell R10cell37 = R10row.getCell(39);
			if (R10cell37 != null) {
				R10cell37.setCellValue(brf94.getR10_no_of_transactions_services_sme() == null ? 0
						: brf94.getR10_no_of_transactions_services_sme().intValue());
			}
			Cell R10cell38 = R10row.getCell(40);
			if (R10cell38 != null) {
				R10cell38.setCellValue(
						brf94.getR10_amount_services_sme() == null ? 0 : brf94.getR10_amount_services_sme().intValue());
			}
			Cell R10cell39 = R10row.getCell(41);
			if (R10cell39 != null) {
				R10cell39.setCellValue(brf94.getR10_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR10_no_of_transactions_trade_sme().intValue());
			}
			Cell R10cell40 = R10row.getCell(42);
			if (R10cell40 != null) {
				R10cell40.setCellValue(
						brf94.getR10_amount_trade_sme() == null ? 0 : brf94.getR10_amount_trade_sme().intValue());
			}
			Cell R10cell41 = R10row.getCell(43);
			if (R10cell41 != null) {
				R10cell41.setCellValue(brf94.getR10_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR10_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R10cell42 = R10row.getCell(44);
			if (R10cell42 != null) {
				R10cell42.setCellValue(brf94.getR10_amount_financial_investment_individual() == null ? 0
						: brf94.getR10_amount_financial_investment_individual().intValue());
			}
			Cell R10cell43 = R10row.getCell(45);
			if (R10cell43 != null) {
				R10cell43.setCellValue(brf94.getR10_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR10_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R10cell44 = R10row.getCell(46);
			if (R10cell44 != null) {
				R10cell44.setCellValue(brf94.getR10_amount_direct_investment_individual() == null ? 0
						: brf94.getR10_amount_direct_investment_individual().intValue());
			}
			Cell R10cell45 = R10row.getCell(47);
			if (R10cell45 != null) {
				R10cell45.setCellValue(brf94.getR10_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR10_no_of_transactions_family_support_individual().intValue());
			}
			Cell R10cell46 = R10row.getCell(48);
			if (R10cell46 != null) {
				R10cell46.setCellValue(brf94.getR10_amount_family_support_individual() == null ? 0
						: brf94.getR10_amount_family_support_individual().intValue());
			}
			Cell R10cell47 = R10row.getCell(49);
			if (R10cell47 != null) {
				R10cell47.setCellValue(brf94.getR10_no_of_transactions_education_individual() == null ? 0
						: brf94.getR10_no_of_transactions_education_individual().intValue());
			}
			Cell R10cell48 = R10row.getCell(50);
			if (R10cell48 != null) {
				R10cell48.setCellValue(brf94.getR10_amount_education_individual() == null ? 0
						: brf94.getR10_amount_education_individual().intValue());
			}
			Cell R10cell49 = R10row.getCell(51);
			if (R10cell49 != null) {
				R10cell49.setCellValue(brf94.getR10_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR10_no_of_transactions_medical_individual().intValue());
			}

			Cell R10cell50 = R10row.getCell(52);
			if (R10cell50 != null) {
				R10cell50.setCellValue(brf94.getR10_amount_medical_individual() == null ? 0
						: brf94.getR10_amount_medical_individual().intValue());
			}
			Cell R10cell51 = R10row.getCell(53);
			if (R10cell51 != null) {
				R10cell51.setCellValue(brf94.getR10_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR10_no_of_transactions_tourism_individual().intValue());
			}
			Cell R10cell52 = R10row.getCell(54);
			if (R10cell52 != null) {
				R10cell52.setCellValue(brf94.getR10_amount_tourism_individual() == null ? 0
						: brf94.getR10_amount_tourism_individual().intValue());
			}
			Cell R10cell53 = R10row.getCell(55);
			if (R10cell53 != null) {
				R10cell53.setCellValue(brf94.getR10_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR10_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R10cell54 = R10row.getCell(56);
			if (R10cell54 != null) {
				R10cell54.setCellValue(brf94.getR10_amount_debt_settlement_individual() == null ? 0
						: brf94.getR10_amount_debt_settlement_individual().intValue());
			}
			Cell R10cell55 = R10row.getCell(57);
			if (R10cell55 != null) {
				R10cell55.setCellValue(brf94.getR10_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR10_no_of_transactions_other_services_individual().intValue());
			}

			Cell R10cell56 = R10row.getCell(58);
			if (R10cell56 != null) {
				R10cell56.setCellValue(brf94.getR10_amount_other_services_individual() == null ? 0
						: brf94.getR10_amount_other_services_individual().intValue());
			}

			Row R11row = sheet.getRow(19);
			Cell R11cell1 = R11row.getCell(3);
			if (R11cell1 != null) {
				R11cell1.setCellValue(brf94.getR11_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR11_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R11cell2 = R11row.getCell(4);
			if (R11cell2 != null) {
				R11cell2.setCellValue(brf94.getR11_amount_financial_investment_government() == null ? 0
						: brf94.getR11_amount_financial_investment_government().intValue());
			}
			Cell R11cell3 = R11row.getCell(5);
			if (R11cell3 != null) {
				R11cell3.setCellValue(brf94.getR11_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR11_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R11cell4 = R11row.getCell(6);
			if (R11cell4 != null) {
				R11cell4.setCellValue(brf94.getR11_amount_direct_investment_government() == null ? 0
						: brf94.getR11_amount_direct_investment_government().intValue());
			}
			Cell R11cell5 = R11row.getCell(7);
			if (R11cell5 != null) {
				R11cell5.setCellValue(brf94.getR11_no_of_transactions_services_government() == null ? 0
						: brf94.getR11_no_of_transactions_services_government().intValue());
			}
			Cell R11cell6 = R11row.getCell(8);
			if (R11cell6 != null) {
				R11cell6.setCellValue(brf94.getR11_amount_services_government() == null ? 0
						: brf94.getR11_amount_services_government().intValue());
			}
			Cell R11cell7 = R11row.getCell(9);
			if (R11cell7 != null) {
				R11cell7.setCellValue(brf94.getR11_no_of_transactions_trade_government() == null ? 0
						: brf94.getR11_no_of_transactions_trade_government().intValue());
			}
			Cell R11cell8 = R11row.getCell(10);
			if (R11cell8 != null) {
				R11cell8.setCellValue(brf94.getR11_amount_trade_government() == null ? 0
						: brf94.getR11_amount_trade_government().intValue());
			}
			Cell R11cell9 = R11row.getCell(11);
			if (R11cell9 != null) {
				R11cell9.setCellValue(brf94.getR11_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR11_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R11cell10 = R11row.getCell(12);
			if (R11cell10 != null) {
				R11cell10.setCellValue(brf94.getR11_amount_financial_investment_reserve() == null ? 0
						: brf94.getR11_amount_financial_investment_reserve().intValue());
			}
			Cell R11cell11 = R11row.getCell(13);
			if (R11cell11 != null) {
				R11cell11.setCellValue(brf94.getR11_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR11_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R11cell12 = R11row.getCell(14);
			if (R11cell12 != null) {
				R11cell12.setCellValue(brf94.getR11_amount_direct_investment_reserve() == null ? 0
						: brf94.getR11_amount_direct_investment_reserve().intValue());
			}
			Cell R11cell13 = R11row.getCell(15);
			if (R11cell13 != null) {
				R11cell13.setCellValue(brf94.getR11_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR11_no_of_transactions_services_reserve().intValue());
			}
			Cell R11cell14 = R11row.getCell(16);
			if (R11cell14 != null) {
				R11cell14.setCellValue(brf94.getR11_amount_services_reserve() == null ? 0
						: brf94.getR11_amount_services_reserve().intValue());
			}
			Cell R11cell15 = R11row.getCell(17);
			if (R11cell15 != null) {
				R11cell15.setCellValue(brf94.getR11_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR11_no_of_transactions_trade_reserve().intValue());
			}
			Cell R11cell16 = R11row.getCell(18);
			if (R11cell16 != null) {
				R11cell16.setCellValue(brf94.getR11_amount_trade_reserve() == null ? 0
						: brf94.getR11_amount_trade_reserve().intValue());
			}
			Cell R11cell17 = R11row.getCell(19);
			if (R11cell17 != null) {
				R11cell17.setCellValue(brf94.getR11_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR11_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R11cell18 = R11row.getCell(20);
			if (R11cell18 != null) {
				R11cell18.setCellValue(brf94.getR11_amount_financial_investment_gre() == null ? 0
						: brf94.getR11_amount_financial_investment_gre().intValue());
			}
			Cell R11cell19 = R11row.getCell(21);
			if (R11cell19 != null) {
				R11cell19.setCellValue(brf94.getR11_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR11_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R11cell20 = R11row.getCell(22);
			if (R11cell20 != null) {
				R11cell20.setCellValue(brf94.getR11_amount_direct_investment_gre() == null ? 0
						: brf94.getR11_amount_direct_investment_gre().intValue());
			}
			Cell R11cell21 = R11row.getCell(23);
			if (R11cell21 != null) {
				R11cell21.setCellValue(brf94.getR11_no_of_transactions_services_gre() == null ? 0
						: brf94.getR11_no_of_transactions_services_gre().intValue());
			}
			Cell R11cell22 = R11row.getCell(24);
			if (R11cell22 != null) {
				R11cell22.setCellValue(
						brf94.getR11_amount_services_gre() == null ? 0 : brf94.getR11_amount_services_gre().intValue());
			}
			Cell R11cell23 = R11row.getCell(25);
			if (R11cell23 != null) {
				R11cell23.setCellValue(brf94.getR11_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR11_no_of_transactions_trade_gre().intValue());
			}
			Cell R11cell24 = R11row.getCell(26);
			if (R11cell24 != null) {
				R11cell24.setCellValue(
						brf94.getR11_amount_trade_gre() == null ? 0 : brf94.getR11_amount_trade_gre().intValue());
			}
			Cell R11cell25 = R11row.getCell(27);
			if (R11cell25 != null) {
				R11cell25.setCellValue(brf94.getR11_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR11_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R11cell26 = R11row.getCell(28);
			if (R11cell26 != null) {
				R11cell26.setCellValue(brf94.getR11_amount_financial_investment_corporate() == null ? 0
						: brf94.getR11_amount_financial_investment_corporate().intValue());
			}
			Cell R11cell27 = R11row.getCell(29);
			if (R11cell27 != null) {
				R11cell27.setCellValue(brf94.getR11_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR11_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R11cell28 = R11row.getCell(30);
			if (R11cell28 != null) {
				R11cell28.setCellValue(brf94.getR11_amount_direct_investment_corporate() == null ? 0
						: brf94.getR11_amount_direct_investment_corporate().intValue());
			}
			Cell R11cell29 = R11row.getCell(31);
			if (R11cell29 != null) {
				R11cell29.setCellValue(brf94.getR11_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR11_no_of_transactions_services_corporate().intValue());
			}
			Cell R11cell30 = R11row.getCell(32);
			if (R11cell30 != null) {
				R11cell30.setCellValue(brf94.getR11_amount_services_corporate() == null ? 0
						: brf94.getR11_amount_services_corporate().intValue());
			}
			Cell R11cell31 = R11row.getCell(33);
			if (R11cell31 != null) {
				R11cell31.setCellValue(brf94.getR11_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR11_no_of_transactions_trade_corporate().intValue());
			}
			Cell R11cell32 = R11row.getCell(34);
			if (R11cell32 != null) {
				R11cell32.setCellValue(brf94.getR11_amount_trade_corporate() == null ? 0
						: brf94.getR11_amount_trade_corporate().intValue());
			}
			Cell R11cell33 = R11row.getCell(35);
			if (R11cell33 != null) {
				R11cell33.setCellValue(brf94.getR11_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR11_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R11cell34 = R11row.getCell(36);
			if (R11cell34 != null) {
				R11cell34.setCellValue(brf94.getR11_amount_financial_investment_sme() == null ? 0
						: brf94.getR11_amount_financial_investment_sme().intValue());
			}
			Cell R11cell35 = R11row.getCell(37);
			if (R11cell35 != null) {
				R11cell35.setCellValue(brf94.getR11_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR11_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R11cell36 = R11row.getCell(38);
			if (R11cell36 != null) {
				R11cell36.setCellValue(brf94.getR11_amount_direct_investment_sme() == null ? 0
						: brf94.getR11_amount_direct_investment_sme().intValue());
			}
			Cell R11cell37 = R11row.getCell(39);
			if (R11cell37 != null) {
				R11cell37.setCellValue(brf94.getR11_no_of_transactions_services_sme() == null ? 0
						: brf94.getR11_no_of_transactions_services_sme().intValue());
			}
			Cell R11cell38 = R11row.getCell(40);
			if (R11cell38 != null) {
				R11cell38.setCellValue(
						brf94.getR11_amount_services_sme() == null ? 0 : brf94.getR11_amount_services_sme().intValue());
			}
			Cell R11cell39 = R11row.getCell(41);
			if (R11cell39 != null) {
				R11cell39.setCellValue(brf94.getR11_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR11_no_of_transactions_trade_sme().intValue());
			}
			Cell R11cell40 = R11row.getCell(42);
			if (R11cell40 != null) {
				R11cell40.setCellValue(
						brf94.getR11_amount_trade_sme() == null ? 0 : brf94.getR11_amount_trade_sme().intValue());
			}
			Cell R11cell41 = R11row.getCell(43);
			if (R11cell41 != null) {
				R11cell41.setCellValue(brf94.getR11_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR11_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R11cell42 = R11row.getCell(44);
			if (R11cell42 != null) {
				R11cell42.setCellValue(brf94.getR11_amount_financial_investment_individual() == null ? 0
						: brf94.getR11_amount_financial_investment_individual().intValue());
			}
			Cell R11cell43 = R11row.getCell(45);
			if (R11cell43 != null) {
				R11cell43.setCellValue(brf94.getR11_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR11_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R11cell44 = R11row.getCell(46);
			if (R11cell44 != null) {
				R11cell44.setCellValue(brf94.getR11_amount_direct_investment_individual() == null ? 0
						: brf94.getR11_amount_direct_investment_individual().intValue());
			}
			Cell R11cell45 = R11row.getCell(47);
			if (R11cell45 != null) {
				R11cell45.setCellValue(brf94.getR11_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR11_no_of_transactions_family_support_individual().intValue());
			}
			Cell R11cell46 = R11row.getCell(48);
			if (R11cell46 != null) {
				R11cell46.setCellValue(brf94.getR11_amount_family_support_individual() == null ? 0
						: brf94.getR11_amount_family_support_individual().intValue());
			}
			Cell R11cell47 = R11row.getCell(49);
			if (R11cell47 != null) {
				R11cell47.setCellValue(brf94.getR11_no_of_transactions_education_individual() == null ? 0
						: brf94.getR11_no_of_transactions_education_individual().intValue());
			}
			Cell R11cell48 = R11row.getCell(50);
			if (R11cell48 != null) {
				R11cell48.setCellValue(brf94.getR11_amount_education_individual() == null ? 0
						: brf94.getR11_amount_education_individual().intValue());
			}
			Cell R11cell49 = R11row.getCell(51);
			if (R11cell49 != null) {
				R11cell49.setCellValue(brf94.getR11_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR11_no_of_transactions_medical_individual().intValue());
			}

			Cell R11cell50 = R11row.getCell(52);
			if (R11cell50 != null) {
				R11cell50.setCellValue(brf94.getR11_amount_medical_individual() == null ? 0
						: brf94.getR11_amount_medical_individual().intValue());
			}
			Cell R11cell51 = R11row.getCell(53);
			if (R11cell51 != null) {
				R11cell51.setCellValue(brf94.getR11_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR11_no_of_transactions_tourism_individual().intValue());
			}
			Cell R11cell52 = R11row.getCell(54);
			if (R11cell52 != null) {
				R11cell52.setCellValue(brf94.getR11_amount_tourism_individual() == null ? 0
						: brf94.getR11_amount_tourism_individual().intValue());
			}
			Cell R11cell53 = R11row.getCell(55);
			if (R11cell53 != null) {
				R11cell53.setCellValue(brf94.getR11_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR11_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R11cell54 = R11row.getCell(56);
			if (R11cell54 != null) {
				R11cell54.setCellValue(brf94.getR11_amount_debt_settlement_individual() == null ? 0
						: brf94.getR11_amount_debt_settlement_individual().intValue());
			}
			Cell R11cell55 = R11row.getCell(57);
			if (R11cell55 != null) {
				R11cell55.setCellValue(brf94.getR11_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR11_no_of_transactions_other_services_individual().intValue());
			}

			Cell R11cell56 = R11row.getCell(58);
			if (R11cell56 != null) {
				R11cell56.setCellValue(brf94.getR11_amount_other_services_individual() == null ? 0
						: brf94.getR11_amount_other_services_individual().intValue());
			}

			Row R12row = sheet.getRow(20);
			Cell R12cell1 = R12row.getCell(3);
			if (R12cell1 != null) {
				R12cell1.setCellValue(brf94.getR12_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR12_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R12cell2 = R12row.getCell(4);
			if (R12cell2 != null) {
				R12cell2.setCellValue(brf94.getR12_amount_financial_investment_government() == null ? 0
						: brf94.getR12_amount_financial_investment_government().intValue());
			}
			Cell R12cell3 = R12row.getCell(5);
			if (R12cell3 != null) {
				R12cell3.setCellValue(brf94.getR12_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR12_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R12cell4 = R12row.getCell(6);
			if (R12cell4 != null) {
				R12cell4.setCellValue(brf94.getR12_amount_direct_investment_government() == null ? 0
						: brf94.getR12_amount_direct_investment_government().intValue());
			}
			Cell R12cell5 = R12row.getCell(7);
			if (R12cell5 != null) {
				R12cell5.setCellValue(brf94.getR12_no_of_transactions_services_government() == null ? 0
						: brf94.getR12_no_of_transactions_services_government().intValue());
			}
			Cell R12cell6 = R12row.getCell(8);
			if (R12cell6 != null) {
				R12cell6.setCellValue(brf94.getR12_amount_services_government() == null ? 0
						: brf94.getR12_amount_services_government().intValue());
			}
			Cell R12cell7 = R12row.getCell(9);
			if (R12cell7 != null) {
				R12cell7.setCellValue(brf94.getR12_no_of_transactions_trade_government() == null ? 0
						: brf94.getR12_no_of_transactions_trade_government().intValue());
			}
			Cell R12cell8 = R12row.getCell(10);
			if (R12cell8 != null) {
				R12cell8.setCellValue(brf94.getR12_amount_trade_government() == null ? 0
						: brf94.getR12_amount_trade_government().intValue());
			}
			Cell R12cell9 = R12row.getCell(11);
			if (R12cell9 != null) {
				R12cell9.setCellValue(brf94.getR12_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR12_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R12cell10 = R12row.getCell(12);
			if (R12cell10 != null) {
				R12cell10.setCellValue(brf94.getR12_amount_financial_investment_reserve() == null ? 0
						: brf94.getR12_amount_financial_investment_reserve().intValue());
			}
			Cell R12cell11 = R12row.getCell(13);
			if (R12cell11 != null) {
				R12cell11.setCellValue(brf94.getR12_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR12_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R12cell12 = R12row.getCell(14);
			if (R12cell12 != null) {
				R12cell12.setCellValue(brf94.getR12_amount_direct_investment_reserve() == null ? 0
						: brf94.getR12_amount_direct_investment_reserve().intValue());
			}
			Cell R12cell13 = R12row.getCell(15);
			if (R12cell13 != null) {
				R12cell13.setCellValue(brf94.getR12_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR12_no_of_transactions_services_reserve().intValue());
			}
			Cell R12cell14 = R12row.getCell(16);
			if (R12cell14 != null) {
				R12cell14.setCellValue(brf94.getR12_amount_services_reserve() == null ? 0
						: brf94.getR12_amount_services_reserve().intValue());
			}
			Cell R12cell15 = R12row.getCell(17);
			if (R12cell15 != null) {
				R12cell15.setCellValue(brf94.getR12_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR12_no_of_transactions_trade_reserve().intValue());
			}
			Cell R12cell16 = R12row.getCell(18);
			if (R12cell16 != null) {
				R12cell16.setCellValue(brf94.getR12_amount_trade_reserve() == null ? 0
						: brf94.getR12_amount_trade_reserve().intValue());
			}
			Cell R12cell17 = R12row.getCell(19);
			if (R12cell17 != null) {
				R12cell17.setCellValue(brf94.getR12_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR12_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R12cell18 = R12row.getCell(20);
			if (R12cell18 != null) {
				R12cell18.setCellValue(brf94.getR12_amount_financial_investment_gre() == null ? 0
						: brf94.getR12_amount_financial_investment_gre().intValue());
			}
			Cell R12cell19 = R12row.getCell(21);
			if (R12cell19 != null) {
				R12cell19.setCellValue(brf94.getR12_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR12_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R12cell20 = R12row.getCell(22);
			if (R12cell20 != null) {
				R12cell20.setCellValue(brf94.getR12_amount_direct_investment_gre() == null ? 0
						: brf94.getR12_amount_direct_investment_gre().intValue());
			}
			Cell R12cell21 = R12row.getCell(23);
			if (R12cell21 != null) {
				R12cell21.setCellValue(brf94.getR12_no_of_transactions_services_gre() == null ? 0
						: brf94.getR12_no_of_transactions_services_gre().intValue());
			}
			Cell R12cell22 = R12row.getCell(24);
			if (R12cell22 != null) {
				R12cell22.setCellValue(
						brf94.getR12_amount_services_gre() == null ? 0 : brf94.getR12_amount_services_gre().intValue());
			}
			Cell R12cell23 = R12row.getCell(25);
			if (R12cell23 != null) {
				R12cell23.setCellValue(brf94.getR12_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR12_no_of_transactions_trade_gre().intValue());
			}
			Cell R12cell24 = R12row.getCell(26);
			if (R12cell24 != null) {
				R12cell24.setCellValue(
						brf94.getR12_amount_trade_gre() == null ? 0 : brf94.getR12_amount_trade_gre().intValue());
			}
			Cell R12cell25 = R12row.getCell(27);
			if (R12cell25 != null) {
				R12cell25.setCellValue(brf94.getR12_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR12_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R12cell26 = R12row.getCell(28);
			if (R12cell26 != null) {
				R12cell26.setCellValue(brf94.getR12_amount_financial_investment_corporate() == null ? 0
						: brf94.getR12_amount_financial_investment_corporate().intValue());
			}
			Cell R12cell27 = R12row.getCell(29);
			if (R12cell27 != null) {
				R12cell27.setCellValue(brf94.getR12_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR12_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R12cell28 = R12row.getCell(30);
			if (R12cell28 != null) {
				R12cell28.setCellValue(brf94.getR12_amount_direct_investment_corporate() == null ? 0
						: brf94.getR12_amount_direct_investment_corporate().intValue());
			}
			Cell R12cell29 = R12row.getCell(31);
			if (R12cell29 != null) {
				R12cell29.setCellValue(brf94.getR12_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR12_no_of_transactions_services_corporate().intValue());
			}
			Cell R12cell30 = R12row.getCell(32);
			if (R12cell30 != null) {
				R12cell30.setCellValue(brf94.getR12_amount_services_corporate() == null ? 0
						: brf94.getR12_amount_services_corporate().intValue());
			}
			Cell R12cell31 = R12row.getCell(33);
			if (R12cell31 != null) {
				R12cell31.setCellValue(brf94.getR12_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR12_no_of_transactions_trade_corporate().intValue());
			}
			Cell R12cell32 = R12row.getCell(34);
			if (R12cell32 != null) {
				R12cell32.setCellValue(brf94.getR12_amount_trade_corporate() == null ? 0
						: brf94.getR12_amount_trade_corporate().intValue());
			}
			Cell R12cell33 = R12row.getCell(35);
			if (R12cell33 != null) {
				R12cell33.setCellValue(brf94.getR12_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR12_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R12cell34 = R12row.getCell(36);
			if (R12cell34 != null) {
				R12cell34.setCellValue(brf94.getR12_amount_financial_investment_sme() == null ? 0
						: brf94.getR12_amount_financial_investment_sme().intValue());
			}
			Cell R12cell35 = R12row.getCell(37);
			if (R12cell35 != null) {
				R12cell35.setCellValue(brf94.getR12_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR12_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R12cell36 = R12row.getCell(38);
			if (R12cell36 != null) {
				R12cell36.setCellValue(brf94.getR12_amount_direct_investment_sme() == null ? 0
						: brf94.getR12_amount_direct_investment_sme().intValue());
			}
			Cell R12cell37 = R12row.getCell(39);
			if (R12cell37 != null) {
				R12cell37.setCellValue(brf94.getR12_no_of_transactions_services_sme() == null ? 0
						: brf94.getR12_no_of_transactions_services_sme().intValue());
			}
			Cell R12cell38 = R12row.getCell(40);
			if (R12cell38 != null) {
				R12cell38.setCellValue(
						brf94.getR12_amount_services_sme() == null ? 0 : brf94.getR12_amount_services_sme().intValue());
			}
			Cell R12cell39 = R12row.getCell(41);
			if (R12cell39 != null) {
				R12cell39.setCellValue(brf94.getR12_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR12_no_of_transactions_trade_sme().intValue());
			}
			Cell R12cell40 = R12row.getCell(42);
			if (R12cell40 != null) {
				R12cell40.setCellValue(
						brf94.getR12_amount_trade_sme() == null ? 0 : brf94.getR12_amount_trade_sme().intValue());
			}
			Cell R12cell41 = R12row.getCell(43);
			if (R12cell41 != null) {
				R12cell41.setCellValue(brf94.getR12_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR12_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R12cell42 = R12row.getCell(44);
			if (R12cell42 != null) {
				R12cell42.setCellValue(brf94.getR12_amount_financial_investment_individual() == null ? 0
						: brf94.getR12_amount_financial_investment_individual().intValue());
			}
			Cell R12cell43 = R12row.getCell(45);
			if (R12cell43 != null) {
				R12cell43.setCellValue(brf94.getR12_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR12_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R12cell44 = R12row.getCell(46);
			if (R12cell44 != null) {
				R12cell44.setCellValue(brf94.getR12_amount_direct_investment_individual() == null ? 0
						: brf94.getR12_amount_direct_investment_individual().intValue());
			}
			Cell R12cell45 = R12row.getCell(47);
			if (R12cell45 != null) {
				R12cell45.setCellValue(brf94.getR12_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR12_no_of_transactions_family_support_individual().intValue());
			}
			Cell R12cell46 = R12row.getCell(48);
			if (R12cell46 != null) {
				R12cell46.setCellValue(brf94.getR12_amount_family_support_individual() == null ? 0
						: brf94.getR12_amount_family_support_individual().intValue());
			}
			Cell R12cell47 = R12row.getCell(49);
			if (R12cell47 != null) {
				R12cell47.setCellValue(brf94.getR12_no_of_transactions_education_individual() == null ? 0
						: brf94.getR12_no_of_transactions_education_individual().intValue());
			}
			Cell R12cell48 = R12row.getCell(50);
			if (R12cell48 != null) {
				R12cell48.setCellValue(brf94.getR12_amount_education_individual() == null ? 0
						: brf94.getR12_amount_education_individual().intValue());
			}
			Cell R12cell49 = R12row.getCell(51);
			if (R12cell49 != null) {
				R12cell49.setCellValue(brf94.getR12_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR12_no_of_transactions_medical_individual().intValue());
			}

			Cell R12cell50 = R12row.getCell(52);
			if (R12cell50 != null) {
				R12cell50.setCellValue(brf94.getR12_amount_medical_individual() == null ? 0
						: brf94.getR12_amount_medical_individual().intValue());
			}
			Cell R12cell51 = R12row.getCell(53);
			if (R12cell51 != null) {
				R12cell51.setCellValue(brf94.getR12_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR12_no_of_transactions_tourism_individual().intValue());
			}
			Cell R12cell52 = R12row.getCell(54);
			if (R12cell52 != null) {
				R12cell52.setCellValue(brf94.getR12_amount_tourism_individual() == null ? 0
						: brf94.getR12_amount_tourism_individual().intValue());
			}
			Cell R12cell53 = R12row.getCell(55);
			if (R12cell53 != null) {
				R12cell53.setCellValue(brf94.getR12_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR12_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R12cell54 = R12row.getCell(56);
			if (R12cell54 != null) {
				R12cell54.setCellValue(brf94.getR12_amount_debt_settlement_individual() == null ? 0
						: brf94.getR12_amount_debt_settlement_individual().intValue());
			}
			Cell R12cell55 = R12row.getCell(57);
			if (R12cell55 != null) {
				R12cell55.setCellValue(brf94.getR12_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR12_no_of_transactions_other_services_individual().intValue());
			}

			Cell R12cell56 = R12row.getCell(58);
			if (R12cell56 != null) {
				R12cell56.setCellValue(brf94.getR12_amount_other_services_individual() == null ? 0
						: brf94.getR12_amount_other_services_individual().intValue());
			}

			Row R13row = sheet.getRow(21);
			Cell R13cell1 = R13row.getCell(3);
			if (R13cell1 != null) {
				R13cell1.setCellValue(brf94.getR13_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR13_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R13cell2 = R13row.getCell(4);
			if (R13cell2 != null) {
				R13cell2.setCellValue(brf94.getR13_amount_financial_investment_government() == null ? 0
						: brf94.getR13_amount_financial_investment_government().intValue());
			}
			Cell R13cell3 = R13row.getCell(5);
			if (R13cell3 != null) {
				R13cell3.setCellValue(brf94.getR13_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR13_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R13cell4 = R13row.getCell(6);
			if (R13cell4 != null) {
				R13cell4.setCellValue(brf94.getR13_amount_direct_investment_government() == null ? 0
						: brf94.getR13_amount_direct_investment_government().intValue());
			}
			Cell R13cell5 = R13row.getCell(7);
			if (R13cell5 != null) {
				R13cell5.setCellValue(brf94.getR13_no_of_transactions_services_government() == null ? 0
						: brf94.getR13_no_of_transactions_services_government().intValue());
			}
			Cell R13cell6 = R13row.getCell(8);
			if (R13cell6 != null) {
				R13cell6.setCellValue(brf94.getR13_amount_services_government() == null ? 0
						: brf94.getR13_amount_services_government().intValue());
			}
			Cell R13cell7 = R13row.getCell(9);
			if (R13cell7 != null) {
				R13cell7.setCellValue(brf94.getR13_no_of_transactions_trade_government() == null ? 0
						: brf94.getR13_no_of_transactions_trade_government().intValue());
			}
			Cell R13cell8 = R13row.getCell(10);
			if (R13cell8 != null) {
				R13cell8.setCellValue(brf94.getR13_amount_trade_government() == null ? 0
						: brf94.getR13_amount_trade_government().intValue());
			}
			Cell R13cell9 = R13row.getCell(11);
			if (R13cell9 != null) {
				R13cell9.setCellValue(brf94.getR13_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR13_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R13cell10 = R13row.getCell(12);
			if (R13cell10 != null) {
				R13cell10.setCellValue(brf94.getR13_amount_financial_investment_reserve() == null ? 0
						: brf94.getR13_amount_financial_investment_reserve().intValue());
			}
			Cell R13cell11 = R13row.getCell(13);
			if (R13cell11 != null) {
				R13cell11.setCellValue(brf94.getR13_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR13_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R13cell12 = R13row.getCell(14);
			if (R13cell12 != null) {
				R13cell12.setCellValue(brf94.getR13_amount_direct_investment_reserve() == null ? 0
						: brf94.getR13_amount_direct_investment_reserve().intValue());
			}
			Cell R13cell13 = R13row.getCell(15);
			if (R13cell13 != null) {
				R13cell13.setCellValue(brf94.getR13_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR13_no_of_transactions_services_reserve().intValue());
			}
			Cell R13cell14 = R13row.getCell(16);
			if (R13cell14 != null) {
				R13cell14.setCellValue(brf94.getR13_amount_services_reserve() == null ? 0
						: brf94.getR13_amount_services_reserve().intValue());
			}
			Cell R13cell15 = R13row.getCell(17);
			if (R13cell15 != null) {
				R13cell15.setCellValue(brf94.getR13_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR13_no_of_transactions_trade_reserve().intValue());
			}
			Cell R13cell16 = R13row.getCell(18);
			if (R13cell16 != null) {
				R13cell16.setCellValue(brf94.getR13_amount_trade_reserve() == null ? 0
						: brf94.getR13_amount_trade_reserve().intValue());
			}
			Cell R13cell17 = R13row.getCell(19);
			if (R13cell17 != null) {
				R13cell17.setCellValue(brf94.getR13_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR13_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R13cell18 = R13row.getCell(20);
			if (R13cell18 != null) {
				R13cell18.setCellValue(brf94.getR13_amount_financial_investment_gre() == null ? 0
						: brf94.getR13_amount_financial_investment_gre().intValue());
			}
			Cell R13cell19 = R13row.getCell(21);
			if (R13cell19 != null) {
				R13cell19.setCellValue(brf94.getR13_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR13_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R13cell20 = R13row.getCell(22);
			if (R13cell20 != null) {
				R13cell20.setCellValue(brf94.getR13_amount_direct_investment_gre() == null ? 0
						: brf94.getR13_amount_direct_investment_gre().intValue());
			}
			Cell R13cell21 = R13row.getCell(23);
			if (R13cell21 != null) {
				R13cell21.setCellValue(brf94.getR13_no_of_transactions_services_gre() == null ? 0
						: brf94.getR13_no_of_transactions_services_gre().intValue());
			}
			Cell R13cell22 = R13row.getCell(24);
			if (R13cell22 != null) {
				R13cell22.setCellValue(
						brf94.getR13_amount_services_gre() == null ? 0 : brf94.getR13_amount_services_gre().intValue());
			}
			Cell R13cell23 = R13row.getCell(25);
			if (R13cell23 != null) {
				R13cell23.setCellValue(brf94.getR13_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR13_no_of_transactions_trade_gre().intValue());
			}
			Cell R13cell24 = R13row.getCell(26);
			if (R13cell24 != null) {
				R13cell24.setCellValue(
						brf94.getR13_amount_trade_gre() == null ? 0 : brf94.getR13_amount_trade_gre().intValue());
			}
			Cell R13cell25 = R13row.getCell(27);
			if (R13cell25 != null) {
				R13cell25.setCellValue(brf94.getR13_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR13_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R13cell26 = R13row.getCell(28);
			if (R13cell26 != null) {
				R13cell26.setCellValue(brf94.getR13_amount_financial_investment_corporate() == null ? 0
						: brf94.getR13_amount_financial_investment_corporate().intValue());
			}
			Cell R13cell27 = R13row.getCell(29);
			if (R13cell27 != null) {
				R13cell27.setCellValue(brf94.getR13_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR13_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R13cell28 = R13row.getCell(30);
			if (R13cell28 != null) {
				R13cell28.setCellValue(brf94.getR13_amount_direct_investment_corporate() == null ? 0
						: brf94.getR13_amount_direct_investment_corporate().intValue());
			}
			Cell R13cell29 = R13row.getCell(31);
			if (R13cell29 != null) {
				R13cell29.setCellValue(brf94.getR13_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR13_no_of_transactions_services_corporate().intValue());
			}
			Cell R13cell30 = R13row.getCell(32);
			if (R13cell30 != null) {
				R13cell30.setCellValue(brf94.getR13_amount_services_corporate() == null ? 0
						: brf94.getR13_amount_services_corporate().intValue());
			}
			Cell R13cell31 = R13row.getCell(33);
			if (R13cell31 != null) {
				R13cell31.setCellValue(brf94.getR13_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR13_no_of_transactions_trade_corporate().intValue());
			}
			Cell R13cell32 = R13row.getCell(34);
			if (R13cell32 != null) {
				R13cell32.setCellValue(brf94.getR13_amount_trade_corporate() == null ? 0
						: brf94.getR13_amount_trade_corporate().intValue());
			}
			Cell R13cell33 = R13row.getCell(35);
			if (R13cell33 != null) {
				R13cell33.setCellValue(brf94.getR13_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR13_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R13cell34 = R13row.getCell(36);
			if (R13cell34 != null) {
				R13cell34.setCellValue(brf94.getR13_amount_financial_investment_sme() == null ? 0
						: brf94.getR13_amount_financial_investment_sme().intValue());
			}
			Cell R13cell35 = R13row.getCell(37);
			if (R13cell35 != null) {
				R13cell35.setCellValue(brf94.getR13_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR13_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R13cell36 = R13row.getCell(38);
			if (R13cell36 != null) {
				R13cell36.setCellValue(brf94.getR13_amount_direct_investment_sme() == null ? 0
						: brf94.getR13_amount_direct_investment_sme().intValue());
			}
			Cell R13cell37 = R13row.getCell(39);
			if (R13cell37 != null) {
				R13cell37.setCellValue(brf94.getR13_no_of_transactions_services_sme() == null ? 0
						: brf94.getR13_no_of_transactions_services_sme().intValue());
			}
			Cell R13cell38 = R13row.getCell(40);
			if (R13cell38 != null) {
				R13cell38.setCellValue(
						brf94.getR13_amount_services_sme() == null ? 0 : brf94.getR13_amount_services_sme().intValue());
			}
			Cell R13cell39 = R13row.getCell(41);
			if (R13cell39 != null) {
				R13cell39.setCellValue(brf94.getR13_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR13_no_of_transactions_trade_sme().intValue());
			}
			Cell R13cell40 = R13row.getCell(42);
			if (R13cell40 != null) {
				R13cell40.setCellValue(
						brf94.getR13_amount_trade_sme() == null ? 0 : brf94.getR13_amount_trade_sme().intValue());
			}
			Cell R13cell41 = R13row.getCell(43);
			if (R13cell41 != null) {
				R13cell41.setCellValue(brf94.getR13_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR13_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R13cell42 = R13row.getCell(44);
			if (R13cell42 != null) {
				R13cell42.setCellValue(brf94.getR13_amount_financial_investment_individual() == null ? 0
						: brf94.getR13_amount_financial_investment_individual().intValue());
			}
			Cell R13cell43 = R13row.getCell(45);
			if (R13cell43 != null) {
				R13cell43.setCellValue(brf94.getR13_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR13_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R13cell44 = R13row.getCell(46);
			if (R13cell44 != null) {
				R13cell44.setCellValue(brf94.getR13_amount_direct_investment_individual() == null ? 0
						: brf94.getR13_amount_direct_investment_individual().intValue());
			}
			Cell R13cell45 = R13row.getCell(47);
			if (R13cell45 != null) {
				R13cell45.setCellValue(brf94.getR13_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR13_no_of_transactions_family_support_individual().intValue());
			}
			Cell R13cell46 = R13row.getCell(48);
			if (R13cell46 != null) {
				R13cell46.setCellValue(brf94.getR13_amount_family_support_individual() == null ? 0
						: brf94.getR13_amount_family_support_individual().intValue());
			}
			Cell R13cell47 = R13row.getCell(49);
			if (R13cell47 != null) {
				R13cell47.setCellValue(brf94.getR13_no_of_transactions_education_individual() == null ? 0
						: brf94.getR13_no_of_transactions_education_individual().intValue());
			}
			Cell R13cell48 = R13row.getCell(50);
			if (R13cell48 != null) {
				R13cell48.setCellValue(brf94.getR13_amount_education_individual() == null ? 0
						: brf94.getR13_amount_education_individual().intValue());
			}
			Cell R13cell49 = R13row.getCell(51);
			if (R13cell49 != null) {
				R13cell49.setCellValue(brf94.getR13_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR13_no_of_transactions_medical_individual().intValue());
			}

			Cell R13cell50 = R13row.getCell(52);
			if (R13cell50 != null) {
				R13cell50.setCellValue(brf94.getR13_amount_medical_individual() == null ? 0
						: brf94.getR13_amount_medical_individual().intValue());
			}
			Cell R13cell51 = R13row.getCell(53);
			if (R13cell51 != null) {
				R13cell51.setCellValue(brf94.getR13_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR13_no_of_transactions_tourism_individual().intValue());
			}
			Cell R13cell52 = R13row.getCell(54);
			if (R13cell52 != null) {
				R13cell52.setCellValue(brf94.getR13_amount_tourism_individual() == null ? 0
						: brf94.getR13_amount_tourism_individual().intValue());
			}
			Cell R13cell53 = R13row.getCell(55);
			if (R13cell53 != null) {
				R13cell53.setCellValue(brf94.getR13_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR13_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R13cell54 = R13row.getCell(56);
			if (R13cell54 != null) {
				R13cell54.setCellValue(brf94.getR13_amount_debt_settlement_individual() == null ? 0
						: brf94.getR13_amount_debt_settlement_individual().intValue());
			}
			Cell R13cell55 = R13row.getCell(57);
			if (R13cell55 != null) {
				R13cell55.setCellValue(brf94.getR13_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR13_no_of_transactions_other_services_individual().intValue());
			}

			Cell R13cell56 = R13row.getCell(58);
			if (R13cell56 != null) {
				R13cell56.setCellValue(brf94.getR13_amount_other_services_individual() == null ? 0
						: brf94.getR13_amount_other_services_individual().intValue());
			}

			Row R14row = sheet.getRow(22);
			Cell R14cell1 = R14row.getCell(3);
			if (R14cell1 != null) {
				R14cell1.setCellValue(brf94.getR14_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR14_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R14cell2 = R14row.getCell(4);
			if (R14cell2 != null) {
				R14cell2.setCellValue(brf94.getR14_amount_financial_investment_government() == null ? 0
						: brf94.getR14_amount_financial_investment_government().intValue());
			}
			Cell R14cell3 = R14row.getCell(5);
			if (R14cell3 != null) {
				R14cell3.setCellValue(brf94.getR14_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR14_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R14cell4 = R14row.getCell(6);
			if (R14cell4 != null) {
				R14cell4.setCellValue(brf94.getR14_amount_direct_investment_government() == null ? 0
						: brf94.getR14_amount_direct_investment_government().intValue());
			}
			Cell R14cell5 = R14row.getCell(7);
			if (R14cell5 != null) {
				R14cell5.setCellValue(brf94.getR14_no_of_transactions_services_government() == null ? 0
						: brf94.getR14_no_of_transactions_services_government().intValue());
			}
			Cell R14cell6 = R14row.getCell(8);
			if (R14cell6 != null) {
				R14cell6.setCellValue(brf94.getR14_amount_services_government() == null ? 0
						: brf94.getR14_amount_services_government().intValue());
			}
			Cell R14cell7 = R14row.getCell(9);
			if (R14cell7 != null) {
				R14cell7.setCellValue(brf94.getR14_no_of_transactions_trade_government() == null ? 0
						: brf94.getR14_no_of_transactions_trade_government().intValue());
			}
			Cell R14cell8 = R14row.getCell(10);
			if (R14cell8 != null) {
				R14cell8.setCellValue(brf94.getR14_amount_trade_government() == null ? 0
						: brf94.getR14_amount_trade_government().intValue());
			}
			Cell R14cell9 = R14row.getCell(11);
			if (R14cell9 != null) {
				R14cell9.setCellValue(brf94.getR14_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR14_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R14cell10 = R14row.getCell(12);
			if (R14cell10 != null) {
				R14cell10.setCellValue(brf94.getR14_amount_financial_investment_reserve() == null ? 0
						: brf94.getR14_amount_financial_investment_reserve().intValue());
			}
			Cell R14cell11 = R14row.getCell(13);
			if (R14cell11 != null) {
				R14cell11.setCellValue(brf94.getR14_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR14_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R14cell12 = R14row.getCell(14);
			if (R14cell12 != null) {
				R14cell12.setCellValue(brf94.getR14_amount_direct_investment_reserve() == null ? 0
						: brf94.getR14_amount_direct_investment_reserve().intValue());
			}
			Cell R14cell13 = R14row.getCell(15);
			if (R14cell13 != null) {
				R14cell13.setCellValue(brf94.getR14_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR14_no_of_transactions_services_reserve().intValue());
			}
			Cell R14cell14 = R14row.getCell(16);
			if (R14cell14 != null) {
				R14cell14.setCellValue(brf94.getR14_amount_services_reserve() == null ? 0
						: brf94.getR14_amount_services_reserve().intValue());
			}
			Cell R14cell15 = R14row.getCell(17);
			if (R14cell15 != null) {
				R14cell15.setCellValue(brf94.getR14_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR14_no_of_transactions_trade_reserve().intValue());
			}
			Cell R14cell16 = R14row.getCell(18);
			if (R14cell16 != null) {
				R14cell16.setCellValue(brf94.getR14_amount_trade_reserve() == null ? 0
						: brf94.getR14_amount_trade_reserve().intValue());
			}
			Cell R14cell17 = R14row.getCell(19);
			if (R14cell17 != null) {
				R14cell17.setCellValue(brf94.getR14_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR14_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R14cell18 = R14row.getCell(20);
			if (R14cell18 != null) {
				R14cell18.setCellValue(brf94.getR14_amount_financial_investment_gre() == null ? 0
						: brf94.getR14_amount_financial_investment_gre().intValue());
			}
			Cell R14cell19 = R14row.getCell(21);
			if (R14cell19 != null) {
				R14cell19.setCellValue(brf94.getR14_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR14_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R14cell20 = R14row.getCell(22);
			if (R14cell20 != null) {
				R14cell20.setCellValue(brf94.getR14_amount_direct_investment_gre() == null ? 0
						: brf94.getR14_amount_direct_investment_gre().intValue());
			}
			Cell R14cell21 = R14row.getCell(23);
			if (R14cell21 != null) {
				R14cell21.setCellValue(brf94.getR14_no_of_transactions_services_gre() == null ? 0
						: brf94.getR14_no_of_transactions_services_gre().intValue());
			}
			Cell R14cell22 = R14row.getCell(24);
			if (R14cell22 != null) {
				R14cell22.setCellValue(
						brf94.getR14_amount_services_gre() == null ? 0 : brf94.getR14_amount_services_gre().intValue());
			}
			Cell R14cell23 = R14row.getCell(25);
			if (R14cell23 != null) {
				R14cell23.setCellValue(brf94.getR14_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR14_no_of_transactions_trade_gre().intValue());
			}
			Cell R14cell24 = R14row.getCell(26);
			if (R14cell24 != null) {
				R14cell24.setCellValue(
						brf94.getR14_amount_trade_gre() == null ? 0 : brf94.getR14_amount_trade_gre().intValue());
			}
			Cell R14cell25 = R14row.getCell(27);
			if (R14cell25 != null) {
				R14cell25.setCellValue(brf94.getR14_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR14_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R14cell26 = R14row.getCell(28);
			if (R14cell26 != null) {
				R14cell26.setCellValue(brf94.getR14_amount_financial_investment_corporate() == null ? 0
						: brf94.getR14_amount_financial_investment_corporate().intValue());
			}
			Cell R14cell27 = R14row.getCell(29);
			if (R14cell27 != null) {
				R14cell27.setCellValue(brf94.getR14_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR14_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R14cell28 = R14row.getCell(30);
			if (R14cell28 != null) {
				R14cell28.setCellValue(brf94.getR14_amount_direct_investment_corporate() == null ? 0
						: brf94.getR14_amount_direct_investment_corporate().intValue());
			}
			Cell R14cell29 = R14row.getCell(31);
			if (R14cell29 != null) {
				R14cell29.setCellValue(brf94.getR14_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR14_no_of_transactions_services_corporate().intValue());
			}
			Cell R14cell30 = R14row.getCell(32);
			if (R14cell30 != null) {
				R14cell30.setCellValue(brf94.getR14_amount_services_corporate() == null ? 0
						: brf94.getR14_amount_services_corporate().intValue());
			}
			Cell R14cell31 = R14row.getCell(33);
			if (R14cell31 != null) {
				R14cell31.setCellValue(brf94.getR14_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR14_no_of_transactions_trade_corporate().intValue());
			}
			Cell R14cell32 = R14row.getCell(34);
			if (R14cell32 != null) {
				R14cell32.setCellValue(brf94.getR14_amount_trade_corporate() == null ? 0
						: brf94.getR14_amount_trade_corporate().intValue());
			}
			Cell R14cell33 = R14row.getCell(35);
			if (R14cell33 != null) {
				R14cell33.setCellValue(brf94.getR14_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR14_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R14cell34 = R14row.getCell(36);
			if (R14cell34 != null) {
				R14cell34.setCellValue(brf94.getR14_amount_financial_investment_sme() == null ? 0
						: brf94.getR14_amount_financial_investment_sme().intValue());
			}
			Cell R14cell35 = R14row.getCell(37);
			if (R14cell35 != null) {
				R14cell35.setCellValue(brf94.getR14_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR14_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R14cell36 = R14row.getCell(38);
			if (R14cell36 != null) {
				R14cell36.setCellValue(brf94.getR14_amount_direct_investment_sme() == null ? 0
						: brf94.getR14_amount_direct_investment_sme().intValue());
			}
			Cell R14cell37 = R14row.getCell(39);
			if (R14cell37 != null) {
				R14cell37.setCellValue(brf94.getR14_no_of_transactions_services_sme() == null ? 0
						: brf94.getR14_no_of_transactions_services_sme().intValue());
			}
			Cell R14cell38 = R14row.getCell(40);
			if (R14cell38 != null) {
				R14cell38.setCellValue(
						brf94.getR14_amount_services_sme() == null ? 0 : brf94.getR14_amount_services_sme().intValue());
			}
			Cell R14cell39 = R14row.getCell(41);
			if (R14cell39 != null) {
				R14cell39.setCellValue(brf94.getR14_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR14_no_of_transactions_trade_sme().intValue());
			}
			Cell R14cell40 = R14row.getCell(42);
			if (R14cell40 != null) {
				R14cell40.setCellValue(
						brf94.getR14_amount_trade_sme() == null ? 0 : brf94.getR14_amount_trade_sme().intValue());
			}
			Cell R14cell41 = R14row.getCell(43);
			if (R14cell41 != null) {
				R14cell41.setCellValue(brf94.getR14_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR14_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R14cell42 = R14row.getCell(44);
			if (R14cell42 != null) {
				R14cell42.setCellValue(brf94.getR14_amount_financial_investment_individual() == null ? 0
						: brf94.getR14_amount_financial_investment_individual().intValue());
			}
			Cell R14cell43 = R14row.getCell(45);
			if (R14cell43 != null) {
				R14cell43.setCellValue(brf94.getR14_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR14_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R14cell44 = R14row.getCell(46);
			if (R14cell44 != null) {
				R14cell44.setCellValue(brf94.getR14_amount_direct_investment_individual() == null ? 0
						: brf94.getR14_amount_direct_investment_individual().intValue());
			}
			Cell R14cell45 = R14row.getCell(47);
			if (R14cell45 != null) {
				R14cell45.setCellValue(brf94.getR14_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR14_no_of_transactions_family_support_individual().intValue());
			}
			Cell R14cell46 = R14row.getCell(48);
			if (R14cell46 != null) {
				R14cell46.setCellValue(brf94.getR14_amount_family_support_individual() == null ? 0
						: brf94.getR14_amount_family_support_individual().intValue());
			}
			Cell R14cell47 = R14row.getCell(49);
			if (R14cell47 != null) {
				R14cell47.setCellValue(brf94.getR14_no_of_transactions_education_individual() == null ? 0
						: brf94.getR14_no_of_transactions_education_individual().intValue());
			}
			Cell R14cell48 = R14row.getCell(50);
			if (R14cell48 != null) {
				R14cell48.setCellValue(brf94.getR14_amount_education_individual() == null ? 0
						: brf94.getR14_amount_education_individual().intValue());
			}
			Cell R14cell49 = R14row.getCell(51);
			if (R14cell49 != null) {
				R14cell49.setCellValue(brf94.getR14_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR14_no_of_transactions_medical_individual().intValue());
			}

			Cell R14cell50 = R14row.getCell(52);
			if (R14cell50 != null) {
				R14cell50.setCellValue(brf94.getR14_amount_medical_individual() == null ? 0
						: brf94.getR14_amount_medical_individual().intValue());
			}
			Cell R14cell51 = R14row.getCell(53);
			if (R14cell51 != null) {
				R14cell51.setCellValue(brf94.getR14_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR14_no_of_transactions_tourism_individual().intValue());
			}
			Cell R14cell52 = R14row.getCell(54);
			if (R14cell52 != null) {
				R14cell52.setCellValue(brf94.getR14_amount_tourism_individual() == null ? 0
						: brf94.getR14_amount_tourism_individual().intValue());
			}
			Cell R14cell53 = R14row.getCell(55);
			if (R14cell53 != null) {
				R14cell53.setCellValue(brf94.getR14_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR14_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R14cell54 = R14row.getCell(56);
			if (R14cell54 != null) {
				R14cell54.setCellValue(brf94.getR14_amount_debt_settlement_individual() == null ? 0
						: brf94.getR14_amount_debt_settlement_individual().intValue());
			}
			Cell R14cell55 = R14row.getCell(57);
			if (R14cell55 != null) {
				R14cell55.setCellValue(brf94.getR14_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR14_no_of_transactions_other_services_individual().intValue());
			}

			Cell R14cell56 = R14row.getCell(58);
			if (R14cell56 != null) {
				R14cell56.setCellValue(brf94.getR14_amount_other_services_individual() == null ? 0
						: brf94.getR14_amount_other_services_individual().intValue());
			}

			Row R15row = sheet.getRow(23);
			Cell R15cell1 = R15row.getCell(3);
			if (R15cell1 != null) {
				R15cell1.setCellValue(brf94.getR15_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR15_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R15cell2 = R15row.getCell(4);
			if (R15cell2 != null) {
				R15cell2.setCellValue(brf94.getR15_amount_financial_investment_government() == null ? 0
						: brf94.getR15_amount_financial_investment_government().intValue());
			}
			Cell R15cell3 = R15row.getCell(5);
			if (R15cell3 != null) {
				R15cell3.setCellValue(brf94.getR15_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR15_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R15cell4 = R15row.getCell(6);
			if (R15cell4 != null) {
				R15cell4.setCellValue(brf94.getR15_amount_direct_investment_government() == null ? 0
						: brf94.getR15_amount_direct_investment_government().intValue());
			}
			Cell R15cell5 = R15row.getCell(7);
			if (R15cell5 != null) {
				R15cell5.setCellValue(brf94.getR15_no_of_transactions_services_government() == null ? 0
						: brf94.getR15_no_of_transactions_services_government().intValue());
			}
			Cell R15cell6 = R15row.getCell(8);
			if (R15cell6 != null) {
				R15cell6.setCellValue(brf94.getR15_amount_services_government() == null ? 0
						: brf94.getR15_amount_services_government().intValue());
			}
			Cell R15cell7 = R15row.getCell(9);
			if (R15cell7 != null) {
				R15cell7.setCellValue(brf94.getR15_no_of_transactions_trade_government() == null ? 0
						: brf94.getR15_no_of_transactions_trade_government().intValue());
			}
			Cell R15cell8 = R15row.getCell(10);
			if (R15cell8 != null) {
				R15cell8.setCellValue(brf94.getR15_amount_trade_government() == null ? 0
						: brf94.getR15_amount_trade_government().intValue());
			}
			Cell R15cell9 = R15row.getCell(11);
			if (R15cell9 != null) {
				R15cell9.setCellValue(brf94.getR15_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR15_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R15cell10 = R15row.getCell(12);
			if (R15cell10 != null) {
				R15cell10.setCellValue(brf94.getR15_amount_financial_investment_reserve() == null ? 0
						: brf94.getR15_amount_financial_investment_reserve().intValue());
			}
			Cell R15cell11 = R15row.getCell(13);
			if (R15cell11 != null) {
				R15cell11.setCellValue(brf94.getR15_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR15_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R15cell12 = R15row.getCell(14);
			if (R15cell12 != null) {
				R15cell12.setCellValue(brf94.getR15_amount_direct_investment_reserve() == null ? 0
						: brf94.getR15_amount_direct_investment_reserve().intValue());
			}
			Cell R15cell13 = R15row.getCell(15);
			if (R15cell13 != null) {
				R15cell13.setCellValue(brf94.getR15_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR15_no_of_transactions_services_reserve().intValue());
			}
			Cell R15cell14 = R15row.getCell(16);
			if (R15cell14 != null) {
				R15cell14.setCellValue(brf94.getR15_amount_services_reserve() == null ? 0
						: brf94.getR15_amount_services_reserve().intValue());
			}
			Cell R15cell15 = R15row.getCell(17);
			if (R15cell15 != null) {
				R15cell15.setCellValue(brf94.getR15_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR15_no_of_transactions_trade_reserve().intValue());
			}
			Cell R15cell16 = R15row.getCell(18);
			if (R15cell16 != null) {
				R15cell16.setCellValue(brf94.getR15_amount_trade_reserve() == null ? 0
						: brf94.getR15_amount_trade_reserve().intValue());
			}
			Cell R15cell17 = R15row.getCell(19);
			if (R15cell17 != null) {
				R15cell17.setCellValue(brf94.getR15_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR15_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R15cell18 = R15row.getCell(20);
			if (R15cell18 != null) {
				R15cell18.setCellValue(brf94.getR15_amount_financial_investment_gre() == null ? 0
						: brf94.getR15_amount_financial_investment_gre().intValue());
			}
			Cell R15cell19 = R15row.getCell(21);
			if (R15cell19 != null) {
				R15cell19.setCellValue(brf94.getR15_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR15_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R15cell20 = R15row.getCell(22);
			if (R15cell20 != null) {
				R15cell20.setCellValue(brf94.getR15_amount_direct_investment_gre() == null ? 0
						: brf94.getR15_amount_direct_investment_gre().intValue());
			}
			Cell R15cell21 = R15row.getCell(23);
			if (R15cell21 != null) {
				R15cell21.setCellValue(brf94.getR15_no_of_transactions_services_gre() == null ? 0
						: brf94.getR15_no_of_transactions_services_gre().intValue());
			}
			Cell R15cell22 = R15row.getCell(24);
			if (R15cell22 != null) {
				R15cell22.setCellValue(
						brf94.getR15_amount_services_gre() == null ? 0 : brf94.getR15_amount_services_gre().intValue());
			}
			Cell R15cell23 = R15row.getCell(25);
			if (R15cell23 != null) {
				R15cell23.setCellValue(brf94.getR15_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR15_no_of_transactions_trade_gre().intValue());
			}
			Cell R15cell24 = R15row.getCell(26);
			if (R15cell24 != null) {
				R15cell24.setCellValue(
						brf94.getR15_amount_trade_gre() == null ? 0 : brf94.getR15_amount_trade_gre().intValue());
			}
			Cell R15cell25 = R15row.getCell(27);
			if (R15cell25 != null) {
				R15cell25.setCellValue(brf94.getR15_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR15_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R15cell26 = R15row.getCell(28);
			if (R15cell26 != null) {
				R15cell26.setCellValue(brf94.getR15_amount_financial_investment_corporate() == null ? 0
						: brf94.getR15_amount_financial_investment_corporate().intValue());
			}
			Cell R15cell27 = R15row.getCell(29);
			if (R15cell27 != null) {
				R15cell27.setCellValue(brf94.getR15_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR15_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R15cell28 = R15row.getCell(30);
			if (R15cell28 != null) {
				R15cell28.setCellValue(brf94.getR15_amount_direct_investment_corporate() == null ? 0
						: brf94.getR15_amount_direct_investment_corporate().intValue());
			}
			Cell R15cell29 = R15row.getCell(31);
			if (R15cell29 != null) {
				R15cell29.setCellValue(brf94.getR15_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR15_no_of_transactions_services_corporate().intValue());
			}
			Cell R15cell30 = R15row.getCell(32);
			if (R15cell30 != null) {
				R15cell30.setCellValue(brf94.getR15_amount_services_corporate() == null ? 0
						: brf94.getR15_amount_services_corporate().intValue());
			}
			Cell R15cell31 = R15row.getCell(33);
			if (R15cell31 != null) {
				R15cell31.setCellValue(brf94.getR15_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR15_no_of_transactions_trade_corporate().intValue());
			}
			Cell R15cell32 = R15row.getCell(34);
			if (R15cell32 != null) {
				R15cell32.setCellValue(brf94.getR15_amount_trade_corporate() == null ? 0
						: brf94.getR15_amount_trade_corporate().intValue());
			}
			Cell R15cell33 = R15row.getCell(35);
			if (R15cell33 != null) {
				R15cell33.setCellValue(brf94.getR15_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR15_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R15cell34 = R15row.getCell(36);
			if (R15cell34 != null) {
				R15cell34.setCellValue(brf94.getR15_amount_financial_investment_sme() == null ? 0
						: brf94.getR15_amount_financial_investment_sme().intValue());
			}
			Cell R15cell35 = R15row.getCell(37);
			if (R15cell35 != null) {
				R15cell35.setCellValue(brf94.getR15_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR15_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R15cell36 = R15row.getCell(38);
			if (R15cell36 != null) {
				R15cell36.setCellValue(brf94.getR15_amount_direct_investment_sme() == null ? 0
						: brf94.getR15_amount_direct_investment_sme().intValue());
			}
			Cell R15cell37 = R15row.getCell(39);
			if (R15cell37 != null) {
				R15cell37.setCellValue(brf94.getR15_no_of_transactions_services_sme() == null ? 0
						: brf94.getR15_no_of_transactions_services_sme().intValue());
			}
			Cell R15cell38 = R15row.getCell(40);
			if (R15cell38 != null) {
				R15cell38.setCellValue(
						brf94.getR15_amount_services_sme() == null ? 0 : brf94.getR15_amount_services_sme().intValue());
			}
			Cell R15cell39 = R15row.getCell(41);
			if (R15cell39 != null) {
				R15cell39.setCellValue(brf94.getR15_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR15_no_of_transactions_trade_sme().intValue());
			}
			Cell R15cell40 = R15row.getCell(42);
			if (R15cell40 != null) {
				R15cell40.setCellValue(
						brf94.getR15_amount_trade_sme() == null ? 0 : brf94.getR15_amount_trade_sme().intValue());
			}
			Cell R15cell41 = R15row.getCell(43);
			if (R15cell41 != null) {
				R15cell41.setCellValue(brf94.getR15_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR15_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R15cell42 = R15row.getCell(44);
			if (R15cell42 != null) {
				R15cell42.setCellValue(brf94.getR15_amount_financial_investment_individual() == null ? 0
						: brf94.getR15_amount_financial_investment_individual().intValue());
			}
			Cell R15cell43 = R15row.getCell(45);
			if (R15cell43 != null) {
				R15cell43.setCellValue(brf94.getR15_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR15_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R15cell44 = R15row.getCell(46);
			if (R15cell44 != null) {
				R15cell44.setCellValue(brf94.getR15_amount_direct_investment_individual() == null ? 0
						: brf94.getR15_amount_direct_investment_individual().intValue());
			}
			Cell R15cell45 = R15row.getCell(47);
			if (R15cell45 != null) {
				R15cell45.setCellValue(brf94.getR15_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR15_no_of_transactions_family_support_individual().intValue());
			}
			Cell R15cell46 = R15row.getCell(48);
			if (R15cell46 != null) {
				R15cell46.setCellValue(brf94.getR15_amount_family_support_individual() == null ? 0
						: brf94.getR15_amount_family_support_individual().intValue());
			}
			Cell R15cell47 = R15row.getCell(49);
			if (R15cell47 != null) {
				R15cell47.setCellValue(brf94.getR15_no_of_transactions_education_individual() == null ? 0
						: brf94.getR15_no_of_transactions_education_individual().intValue());
			}
			Cell R15cell48 = R15row.getCell(50);
			if (R15cell48 != null) {
				R15cell48.setCellValue(brf94.getR15_amount_education_individual() == null ? 0
						: brf94.getR15_amount_education_individual().intValue());
			}
			Cell R15cell49 = R15row.getCell(51);
			if (R15cell49 != null) {
				R15cell49.setCellValue(brf94.getR15_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR15_no_of_transactions_medical_individual().intValue());
			}

			Cell R15cell50 = R15row.getCell(52);
			if (R15cell50 != null) {
				R15cell50.setCellValue(brf94.getR15_amount_medical_individual() == null ? 0
						: brf94.getR15_amount_medical_individual().intValue());
			}
			Cell R15cell51 = R15row.getCell(53);
			if (R15cell51 != null) {
				R15cell51.setCellValue(brf94.getR15_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR15_no_of_transactions_tourism_individual().intValue());
			}
			Cell R15cell52 = R15row.getCell(54);
			if (R15cell52 != null) {
				R15cell52.setCellValue(brf94.getR15_amount_tourism_individual() == null ? 0
						: brf94.getR15_amount_tourism_individual().intValue());
			}
			Cell R15cell53 = R15row.getCell(55);
			if (R15cell53 != null) {
				R15cell53.setCellValue(brf94.getR15_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR15_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R15cell54 = R15row.getCell(56);
			if (R15cell54 != null) {
				R15cell54.setCellValue(brf94.getR15_amount_debt_settlement_individual() == null ? 0
						: brf94.getR15_amount_debt_settlement_individual().intValue());
			}
			Cell R15cell55 = R15row.getCell(57);
			if (R15cell55 != null) {
				R15cell55.setCellValue(brf94.getR15_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR15_no_of_transactions_other_services_individual().intValue());
			}

			Cell R15cell56 = R15row.getCell(58);
			if (R15cell56 != null) {
				R15cell56.setCellValue(brf94.getR15_amount_other_services_individual() == null ? 0
						: brf94.getR15_amount_other_services_individual().intValue());
			}

			Row R16row = sheet.getRow(24);
			Cell R16cell1 = R16row.getCell(3);
			if (R16cell1 != null) {
				R16cell1.setCellValue(brf94.getR16_no_of_transactions_financial_investment_government() == null ? 0
						: brf94.getR16_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R16cell2 = R16row.getCell(4);
			if (R16cell2 != null) {
				R16cell2.setCellValue(brf94.getR16_amount_financial_investment_government() == null ? 0
						: brf94.getR16_amount_financial_investment_government().intValue());
			}
			Cell R16cell3 = R16row.getCell(5);
			if (R16cell3 != null) {
				R16cell3.setCellValue(brf94.getR16_no_of_transactions_direct_investment_government() == null ? 0
						: brf94.getR16_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R16cell4 = R16row.getCell(6);
			if (R16cell4 != null) {
				R16cell4.setCellValue(brf94.getR16_amount_direct_investment_government() == null ? 0
						: brf94.getR16_amount_direct_investment_government().intValue());
			}
			Cell R16cell5 = R16row.getCell(7);
			if (R16cell5 != null) {
				R16cell5.setCellValue(brf94.getR16_no_of_transactions_services_government() == null ? 0
						: brf94.getR16_no_of_transactions_services_government().intValue());
			}
			Cell R16cell6 = R16row.getCell(8);
			if (R16cell6 != null) {
				R16cell6.setCellValue(brf94.getR16_amount_services_government() == null ? 0
						: brf94.getR16_amount_services_government().intValue());
			}
			Cell R16cell7 = R16row.getCell(9);
			if (R16cell7 != null) {
				R16cell7.setCellValue(brf94.getR16_no_of_transactions_trade_government() == null ? 0
						: brf94.getR16_no_of_transactions_trade_government().intValue());
			}
			Cell R16cell8 = R16row.getCell(10);
			if (R16cell8 != null) {
				R16cell8.setCellValue(brf94.getR16_amount_trade_government() == null ? 0
						: brf94.getR16_amount_trade_government().intValue());
			}
			Cell R16cell9 = R16row.getCell(11);
			if (R16cell9 != null) {
				R16cell9.setCellValue(brf94.getR16_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94.getR16_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R16cell10 = R16row.getCell(12);
			if (R16cell10 != null) {
				R16cell10.setCellValue(brf94.getR16_amount_financial_investment_reserve() == null ? 0
						: brf94.getR16_amount_financial_investment_reserve().intValue());
			}
			Cell R16cell11 = R16row.getCell(13);
			if (R16cell11 != null) {
				R16cell11.setCellValue(brf94.getR16_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94.getR16_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R16cell12 = R16row.getCell(14);
			if (R16cell12 != null) {
				R16cell12.setCellValue(brf94.getR16_amount_direct_investment_reserve() == null ? 0
						: brf94.getR16_amount_direct_investment_reserve().intValue());
			}
			Cell R16cell13 = R16row.getCell(15);
			if (R16cell13 != null) {
				R16cell13.setCellValue(brf94.getR16_no_of_transactions_services_reserve() == null ? 0
						: brf94.getR16_no_of_transactions_services_reserve().intValue());
			}
			Cell R16cell14 = R16row.getCell(16);
			if (R16cell14 != null) {
				R16cell14.setCellValue(brf94.getR16_amount_services_reserve() == null ? 0
						: brf94.getR16_amount_services_reserve().intValue());
			}
			Cell R16cell15 = R16row.getCell(17);
			if (R16cell15 != null) {
				R16cell15.setCellValue(brf94.getR16_no_of_transactions_trade_reserve() == null ? 0
						: brf94.getR16_no_of_transactions_trade_reserve().intValue());
			}
			Cell R16cell16 = R16row.getCell(18);
			if (R16cell16 != null) {
				R16cell16.setCellValue(brf94.getR16_amount_trade_reserve() == null ? 0
						: brf94.getR16_amount_trade_reserve().intValue());
			}
			Cell R16cell17 = R16row.getCell(19);
			if (R16cell17 != null) {
				R16cell17.setCellValue(brf94.getR16_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94.getR16_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R16cell18 = R16row.getCell(20);
			if (R16cell18 != null) {
				R16cell18.setCellValue(brf94.getR16_amount_financial_investment_gre() == null ? 0
						: brf94.getR16_amount_financial_investment_gre().intValue());
			}
			Cell R16cell19 = R16row.getCell(21);
			if (R16cell19 != null) {
				R16cell19.setCellValue(brf94.getR16_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94.getR16_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R16cell20 = R16row.getCell(22);
			if (R16cell20 != null) {
				R16cell20.setCellValue(brf94.getR16_amount_direct_investment_gre() == null ? 0
						: brf94.getR16_amount_direct_investment_gre().intValue());
			}
			Cell R16cell21 = R16row.getCell(23);
			if (R16cell21 != null) {
				R16cell21.setCellValue(brf94.getR16_no_of_transactions_services_gre() == null ? 0
						: brf94.getR16_no_of_transactions_services_gre().intValue());
			}
			Cell R16cell22 = R16row.getCell(24);
			if (R16cell22 != null) {
				R16cell22.setCellValue(
						brf94.getR16_amount_services_gre() == null ? 0 : brf94.getR16_amount_services_gre().intValue());
			}
			Cell R16cell23 = R16row.getCell(25);
			if (R16cell23 != null) {
				R16cell23.setCellValue(brf94.getR16_no_of_transactions_trade_gre() == null ? 0
						: brf94.getR16_no_of_transactions_trade_gre().intValue());
			}
			Cell R16cell24 = R16row.getCell(26);
			if (R16cell24 != null) {
				R16cell24.setCellValue(
						brf94.getR16_amount_trade_gre() == null ? 0 : brf94.getR16_amount_trade_gre().intValue());
			}
			Cell R16cell25 = R16row.getCell(27);
			if (R16cell25 != null) {
				R16cell25.setCellValue(brf94.getR16_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94.getR16_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R16cell26 = R16row.getCell(28);
			if (R16cell26 != null) {
				R16cell26.setCellValue(brf94.getR16_amount_financial_investment_corporate() == null ? 0
						: brf94.getR16_amount_financial_investment_corporate().intValue());
			}
			Cell R16cell27 = R16row.getCell(29);
			if (R16cell27 != null) {
				R16cell27.setCellValue(brf94.getR16_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94.getR16_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R16cell28 = R16row.getCell(30);
			if (R16cell28 != null) {
				R16cell28.setCellValue(brf94.getR16_amount_direct_investment_corporate() == null ? 0
						: brf94.getR16_amount_direct_investment_corporate().intValue());
			}
			Cell R16cell29 = R16row.getCell(31);
			if (R16cell29 != null) {
				R16cell29.setCellValue(brf94.getR16_no_of_transactions_services_corporate() == null ? 0
						: brf94.getR16_no_of_transactions_services_corporate().intValue());
			}
			Cell R16cell30 = R16row.getCell(32);
			if (R16cell30 != null) {
				R16cell30.setCellValue(brf94.getR16_amount_services_corporate() == null ? 0
						: brf94.getR16_amount_services_corporate().intValue());
			}
			Cell R16cell31 = R16row.getCell(33);
			if (R16cell31 != null) {
				R16cell31.setCellValue(brf94.getR16_no_of_transactions_trade_corporate() == null ? 0
						: brf94.getR16_no_of_transactions_trade_corporate().intValue());
			}
			Cell R16cell32 = R16row.getCell(34);
			if (R16cell32 != null) {
				R16cell32.setCellValue(brf94.getR16_amount_trade_corporate() == null ? 0
						: brf94.getR16_amount_trade_corporate().intValue());
			}
			Cell R16cell33 = R16row.getCell(35);
			if (R16cell33 != null) {
				R16cell33.setCellValue(brf94.getR16_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94.getR16_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R16cell34 = R16row.getCell(36);
			if (R16cell34 != null) {
				R16cell34.setCellValue(brf94.getR16_amount_financial_investment_sme() == null ? 0
						: brf94.getR16_amount_financial_investment_sme().intValue());
			}
			Cell R16cell35 = R16row.getCell(37);
			if (R16cell35 != null) {
				R16cell35.setCellValue(brf94.getR16_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94.getR16_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R16cell36 = R16row.getCell(38);
			if (R16cell36 != null) {
				R16cell36.setCellValue(brf94.getR16_amount_direct_investment_sme() == null ? 0
						: brf94.getR16_amount_direct_investment_sme().intValue());
			}
			Cell R16cell37 = R16row.getCell(39);
			if (R16cell37 != null) {
				R16cell37.setCellValue(brf94.getR16_no_of_transactions_services_sme() == null ? 0
						: brf94.getR16_no_of_transactions_services_sme().intValue());
			}
			Cell R16cell38 = R16row.getCell(40);
			if (R16cell38 != null) {
				R16cell38.setCellValue(
						brf94.getR16_amount_services_sme() == null ? 0 : brf94.getR16_amount_services_sme().intValue());
			}
			Cell R16cell39 = R16row.getCell(41);
			if (R16cell39 != null) {
				R16cell39.setCellValue(brf94.getR16_no_of_transactions_trade_sme() == null ? 0
						: brf94.getR16_no_of_transactions_trade_sme().intValue());
			}
			Cell R16cell40 = R16row.getCell(42);
			if (R16cell40 != null) {
				R16cell40.setCellValue(
						brf94.getR16_amount_trade_sme() == null ? 0 : brf94.getR16_amount_trade_sme().intValue());
			}
			Cell R16cell41 = R16row.getCell(43);
			if (R16cell41 != null) {
				R16cell41.setCellValue(brf94.getR16_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94.getR16_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R16cell42 = R16row.getCell(44);
			if (R16cell42 != null) {
				R16cell42.setCellValue(brf94.getR16_amount_financial_investment_individual() == null ? 0
						: brf94.getR16_amount_financial_investment_individual().intValue());
			}
			Cell R16cell43 = R16row.getCell(45);
			if (R16cell43 != null) {
				R16cell43.setCellValue(brf94.getR16_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94.getR16_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R16cell44 = R16row.getCell(46);
			if (R16cell44 != null) {
				R16cell44.setCellValue(brf94.getR16_amount_direct_investment_individual() == null ? 0
						: brf94.getR16_amount_direct_investment_individual().intValue());
			}
			Cell R16cell45 = R16row.getCell(47);
			if (R16cell45 != null) {
				R16cell45.setCellValue(brf94.getR16_no_of_transactions_family_support_individual() == null ? 0
						: brf94.getR16_no_of_transactions_family_support_individual().intValue());
			}
			Cell R16cell46 = R16row.getCell(48);
			if (R16cell46 != null) {
				R16cell46.setCellValue(brf94.getR16_amount_family_support_individual() == null ? 0
						: brf94.getR16_amount_family_support_individual().intValue());
			}
			Cell R16cell47 = R16row.getCell(49);
			if (R16cell47 != null) {
				R16cell47.setCellValue(brf94.getR16_no_of_transactions_education_individual() == null ? 0
						: brf94.getR16_no_of_transactions_education_individual().intValue());
			}
			Cell R16cell48 = R16row.getCell(50);
			if (R16cell48 != null) {
				R16cell48.setCellValue(brf94.getR16_amount_education_individual() == null ? 0
						: brf94.getR16_amount_education_individual().intValue());
			}
			Cell R16cell49 = R16row.getCell(51);
			if (R16cell49 != null) {
				R16cell49.setCellValue(brf94.getR16_no_of_transactions_medical_individual() == null ? 0
						: brf94.getR16_no_of_transactions_medical_individual().intValue());
			}

			Cell R16cell50 = R16row.getCell(52);
			if (R16cell50 != null) {
				R16cell50.setCellValue(brf94.getR16_amount_medical_individual() == null ? 0
						: brf94.getR16_amount_medical_individual().intValue());
			}
			Cell R16cell51 = R16row.getCell(53);
			if (R16cell51 != null) {
				R16cell51.setCellValue(brf94.getR16_no_of_transactions_tourism_individual() == null ? 0
						: brf94.getR16_no_of_transactions_tourism_individual().intValue());
			}
			Cell R16cell52 = R16row.getCell(54);
			if (R16cell52 != null) {
				R16cell52.setCellValue(brf94.getR16_amount_tourism_individual() == null ? 0
						: brf94.getR16_amount_tourism_individual().intValue());
			}
			Cell R16cell53 = R16row.getCell(55);
			if (R16cell53 != null) {
				R16cell53.setCellValue(brf94.getR16_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94.getR16_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R16cell54 = R16row.getCell(56);
			if (R16cell54 != null) {
				R16cell54.setCellValue(brf94.getR16_amount_debt_settlement_individual() == null ? 0
						: brf94.getR16_amount_debt_settlement_individual().intValue());
			}
			Cell R16cell55 = R16row.getCell(57);
			if (R16cell55 != null) {
				R16cell55.setCellValue(brf94.getR16_no_of_transactions_other_services_individual() == null ? 0
						: brf94.getR16_no_of_transactions_other_services_individual().intValue());
			}

			Cell R16cell56 = R16row.getCell(58);
			if (R16cell56 != null) {
				R16cell56.setCellValue(brf94.getR16_amount_other_services_individual() == null ? 0
						: brf94.getR16_amount_other_services_individual().intValue());
			}

		}
	}

	public void updateSheetWithEntity2Data(Sheet sheet, List<BRF094_SUMMARYENTITY2> BRF094_SUMMARYENTITY2) {
		if (BRF094_SUMMARYENTITY2.size() == 1) {
			BRF094_SUMMARYENTITY2 brf94a = BRF094_SUMMARYENTITY2.get(0);
			Row R17row = sheet.getRow(25);
			Cell R17cell1 = R17row.getCell(3);
			if (R17cell1 != null) {
				R17cell1.setCellValue(brf94a.getR17_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR17_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R17cell2 = R17row.getCell(4);
			if (R17cell2 != null) {
				R17cell2.setCellValue(brf94a.getR17_amount_financial_investment_government() == null ? 0
						: brf94a.getR17_amount_financial_investment_government().intValue());
			}
			Cell R17cell3 = R17row.getCell(5);
			if (R17cell3 != null) {
				R17cell3.setCellValue(brf94a.getR17_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR17_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R17cell4 = R17row.getCell(6);
			if (R17cell4 != null) {
				R17cell4.setCellValue(brf94a.getR17_amount_direct_investment_government() == null ? 0
						: brf94a.getR17_amount_direct_investment_government().intValue());
			}
			Cell R17cell5 = R17row.getCell(7);
			if (R17cell5 != null) {
				R17cell5.setCellValue(brf94a.getR17_no_of_transactions_services_government() == null ? 0
						: brf94a.getR17_no_of_transactions_services_government().intValue());
			}
			Cell R17cell6 = R17row.getCell(8);
			if (R17cell6 != null) {
				R17cell6.setCellValue(brf94a.getR17_amount_services_government() == null ? 0
						: brf94a.getR17_amount_services_government().intValue());
			}
			Cell R17cell7 = R17row.getCell(9);
			if (R17cell7 != null) {
				R17cell7.setCellValue(brf94a.getR17_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR17_no_of_transactions_trade_government().intValue());
			}
			Cell R17cell8 = R17row.getCell(10);
			if (R17cell8 != null) {
				R17cell8.setCellValue(brf94a.getR17_amount_trade_government() == null ? 0
						: brf94a.getR17_amount_trade_government().intValue());
			}
			Cell R17cell9 = R17row.getCell(11);
			if (R17cell9 != null) {
				R17cell9.setCellValue(brf94a.getR17_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR17_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R17cell10 = R17row.getCell(12);
			if (R17cell10 != null) {
				R17cell10.setCellValue(brf94a.getR17_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR17_amount_financial_investment_reserve().intValue());
			}
			Cell R17cell11 = R17row.getCell(13);
			if (R17cell11 != null) {
				R17cell11.setCellValue(brf94a.getR17_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR17_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R17cell12 = R17row.getCell(14);
			if (R17cell12 != null) {
				R17cell12.setCellValue(brf94a.getR17_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR17_amount_direct_investment_reserve().intValue());
			}
			Cell R17cell13 = R17row.getCell(15);
			if (R17cell13 != null) {
				R17cell13.setCellValue(brf94a.getR17_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR17_no_of_transactions_services_reserve().intValue());
			}
			Cell R17cell14 = R17row.getCell(16);
			if (R17cell14 != null) {
				R17cell14.setCellValue(brf94a.getR17_amount_services_reserve() == null ? 0
						: brf94a.getR17_amount_services_reserve().intValue());
			}
			Cell R17cell15 = R17row.getCell(17);
			if (R17cell15 != null) {
				R17cell15.setCellValue(brf94a.getR17_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR17_no_of_transactions_trade_reserve().intValue());
			}
			Cell R17cell16 = R17row.getCell(18);
			if (R17cell16 != null) {
				R17cell16.setCellValue(brf94a.getR17_amount_trade_reserve() == null ? 0
						: brf94a.getR17_amount_trade_reserve().intValue());
			}
			Cell R17cell17 = R17row.getCell(19);
			if (R17cell17 != null) {
				R17cell17.setCellValue(brf94a.getR17_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR17_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R17cell18 = R17row.getCell(20);
			if (R17cell18 != null) {
				R17cell18.setCellValue(brf94a.getR17_amount_financial_investment_gre() == null ? 0
						: brf94a.getR17_amount_financial_investment_gre().intValue());
			}
			Cell R17cell19 = R17row.getCell(21);
			if (R17cell19 != null) {
				R17cell19.setCellValue(brf94a.getR17_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR17_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R17cell20 = R17row.getCell(22);
			if (R17cell20 != null) {
				R17cell20.setCellValue(brf94a.getR17_amount_direct_investment_gre() == null ? 0
						: brf94a.getR17_amount_direct_investment_gre().intValue());
			}
			Cell R17cell21 = R17row.getCell(23);
			if (R17cell21 != null) {
				R17cell21.setCellValue(brf94a.getR17_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR17_no_of_transactions_services_gre().intValue());
			}
			Cell R17cell22 = R17row.getCell(24);
			if (R17cell22 != null) {
				R17cell22.setCellValue(brf94a.getR17_amount_services_gre() == null ? 0
						: brf94a.getR17_amount_services_gre().intValue());
			}
			Cell R17cell23 = R17row.getCell(25);
			if (R17cell23 != null) {
				R17cell23.setCellValue(brf94a.getR17_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR17_no_of_transactions_trade_gre().intValue());
			}
			Cell R17cell24 = R17row.getCell(26);
			if (R17cell24 != null) {
				R17cell24.setCellValue(
						brf94a.getR17_amount_trade_gre() == null ? 0 : brf94a.getR17_amount_trade_gre().intValue());
			}
			Cell R17cell25 = R17row.getCell(27);
			if (R17cell25 != null) {
				R17cell25.setCellValue(brf94a.getR17_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR17_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R17cell26 = R17row.getCell(28);
			if (R17cell26 != null) {
				R17cell26.setCellValue(brf94a.getR17_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR17_amount_financial_investment_corporate().intValue());
			}
			Cell R17cell27 = R17row.getCell(29);
			if (R17cell27 != null) {
				R17cell27.setCellValue(brf94a.getR17_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR17_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R17cell28 = R17row.getCell(30);
			if (R17cell28 != null) {
				R17cell28.setCellValue(brf94a.getR17_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR17_amount_direct_investment_corporate().intValue());
			}
			Cell R17cell29 = R17row.getCell(31);
			if (R17cell29 != null) {
				R17cell29.setCellValue(brf94a.getR17_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR17_no_of_transactions_services_corporate().intValue());
			}
			Cell R17cell30 = R17row.getCell(32);
			if (R17cell30 != null) {
				R17cell30.setCellValue(brf94a.getR17_amount_services_corporate() == null ? 0
						: brf94a.getR17_amount_services_corporate().intValue());
			}
			Cell R17cell31 = R17row.getCell(33);
			if (R17cell31 != null) {
				R17cell31.setCellValue(brf94a.getR17_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR17_no_of_transactions_trade_corporate().intValue());
			}
			Cell R17cell32 = R17row.getCell(34);
			if (R17cell32 != null) {
				R17cell32.setCellValue(brf94a.getR17_amount_trade_corporate() == null ? 0
						: brf94a.getR17_amount_trade_corporate().intValue());
			}
			Cell R17cell33 = R17row.getCell(35);
			if (R17cell33 != null) {
				R17cell33.setCellValue(brf94a.getR17_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR17_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R17cell34 = R17row.getCell(36);
			if (R17cell34 != null) {
				R17cell34.setCellValue(brf94a.getR17_amount_financial_investment_sme() == null ? 0
						: brf94a.getR17_amount_financial_investment_sme().intValue());
			}
			Cell R17cell35 = R17row.getCell(37);
			if (R17cell35 != null) {
				R17cell35.setCellValue(brf94a.getR17_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR17_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R17cell36 = R17row.getCell(38);
			if (R17cell36 != null) {
				R17cell36.setCellValue(brf94a.getR17_amount_direct_investment_sme() == null ? 0
						: brf94a.getR17_amount_direct_investment_sme().intValue());
			}
			Cell R17cell37 = R17row.getCell(39);
			if (R17cell37 != null) {
				R17cell37.setCellValue(brf94a.getR17_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR17_no_of_transactions_services_sme().intValue());
			}
			Cell R17cell38 = R17row.getCell(40);
			if (R17cell38 != null) {
				R17cell38.setCellValue(brf94a.getR17_amount_services_sme() == null ? 0
						: brf94a.getR17_amount_services_sme().intValue());
			}
			Cell R17cell39 = R17row.getCell(41);
			if (R17cell39 != null) {
				R17cell39.setCellValue(brf94a.getR17_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR17_no_of_transactions_trade_sme().intValue());
			}
			Cell R17cell40 = R17row.getCell(42);
			if (R17cell40 != null) {
				R17cell40.setCellValue(
						brf94a.getR17_amount_trade_sme() == null ? 0 : brf94a.getR17_amount_trade_sme().intValue());
			}
			Cell R17cell41 = R17row.getCell(43);
			if (R17cell41 != null) {
				R17cell41.setCellValue(brf94a.getR17_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R17cell42 = R17row.getCell(44);
			if (R17cell42 != null) {
				R17cell42.setCellValue(brf94a.getR17_amount_financial_investment_individual() == null ? 0
						: brf94a.getR17_amount_financial_investment_individual().intValue());
			}
			Cell R17cell43 = R17row.getCell(45);
			if (R17cell43 != null) {
				R17cell43.setCellValue(brf94a.getR17_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R17cell44 = R17row.getCell(46);
			if (R17cell44 != null) {
				R17cell44.setCellValue(brf94a.getR17_amount_direct_investment_individual() == null ? 0
						: brf94a.getR17_amount_direct_investment_individual().intValue());
			}
			Cell R17cell45 = R17row.getCell(47);
			if (R17cell45 != null) {
				R17cell45.setCellValue(brf94a.getR17_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_family_support_individual().intValue());
			}
			Cell R17cell46 = R17row.getCell(48);
			if (R17cell46 != null) {
				R17cell46.setCellValue(brf94a.getR17_amount_family_support_individual() == null ? 0
						: brf94a.getR17_amount_family_support_individual().intValue());
			}
			Cell R17cell47 = R17row.getCell(49);
			if (R17cell47 != null) {
				R17cell47.setCellValue(brf94a.getR17_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_education_individual().intValue());
			}
			Cell R17cell48 = R17row.getCell(50);
			if (R17cell48 != null) {
				R17cell48.setCellValue(brf94a.getR17_amount_education_individual() == null ? 0
						: brf94a.getR17_amount_education_individual().intValue());
			}
			Cell R17cell49 = R17row.getCell(51);
			if (R17cell49 != null) {
				R17cell49.setCellValue(brf94a.getR17_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_medical_individual().intValue());
			}

			Cell R17cell50 = R17row.getCell(52);
			if (R17cell50 != null) {
				R17cell50.setCellValue(brf94a.getR17_amount_medical_individual() == null ? 0
						: brf94a.getR17_amount_medical_individual().intValue());
			}
			Cell R17cell51 = R17row.getCell(53);
			if (R17cell51 != null) {
				R17cell51.setCellValue(brf94a.getR17_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_tourism_individual().intValue());
			}
			Cell R17cell52 = R17row.getCell(54);
			if (R17cell52 != null) {
				R17cell52.setCellValue(brf94a.getR17_amount_tourism_individual() == null ? 0
						: brf94a.getR17_amount_tourism_individual().intValue());
			}
			Cell R17cell53 = R17row.getCell(55);
			if (R17cell53 != null) {
				R17cell53.setCellValue(brf94a.getR17_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R17cell54 = R17row.getCell(56);
			if (R17cell54 != null) {
				R17cell54.setCellValue(brf94a.getR17_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR17_amount_debt_settlement_individual().intValue());
			}
			Cell R17cell55 = R17row.getCell(57);
			if (R17cell55 != null) {
				R17cell55.setCellValue(brf94a.getR17_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR17_no_of_transactions_other_services_individual().intValue());
			}

			Cell R17cell56 = R17row.getCell(58);
			if (R17cell56 != null) {
				R17cell56.setCellValue(brf94a.getR17_amount_other_services_individual() == null ? 0
						: brf94a.getR17_amount_other_services_individual().intValue());
			}

			Row R18row = sheet.getRow(26);
			Cell R18cell1 = R18row.getCell(3);
			if (R18cell1 != null) {
				R18cell1.setCellValue(brf94a.getR18_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR18_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R18cell2 = R18row.getCell(4);
			if (R18cell2 != null) {
				R18cell2.setCellValue(brf94a.getR18_amount_financial_investment_government() == null ? 0
						: brf94a.getR18_amount_financial_investment_government().intValue());
			}
			Cell R18cell3 = R18row.getCell(5);
			if (R18cell3 != null) {
				R18cell3.setCellValue(brf94a.getR18_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR18_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R18cell4 = R18row.getCell(6);
			if (R18cell4 != null) {
				R18cell4.setCellValue(brf94a.getR18_amount_direct_investment_government() == null ? 0
						: brf94a.getR18_amount_direct_investment_government().intValue());
			}
			Cell R18cell5 = R18row.getCell(7);
			if (R18cell5 != null) {
				R18cell5.setCellValue(brf94a.getR18_no_of_transactions_services_government() == null ? 0
						: brf94a.getR18_no_of_transactions_services_government().intValue());
			}
			Cell R18cell6 = R18row.getCell(8);
			if (R18cell6 != null) {
				R18cell6.setCellValue(brf94a.getR18_amount_services_government() == null ? 0
						: brf94a.getR18_amount_services_government().intValue());
			}
			Cell R18cell7 = R18row.getCell(9);
			if (R18cell7 != null) {
				R18cell7.setCellValue(brf94a.getR18_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR18_no_of_transactions_trade_government().intValue());
			}
			Cell R18cell8 = R18row.getCell(10);
			if (R18cell8 != null) {
				R18cell8.setCellValue(brf94a.getR18_amount_trade_government() == null ? 0
						: brf94a.getR18_amount_trade_government().intValue());
			}
			Cell R18cell9 = R18row.getCell(11);
			if (R18cell9 != null) {
				R18cell9.setCellValue(brf94a.getR18_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR18_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R18cell10 = R18row.getCell(12);
			if (R18cell10 != null) {
				R18cell10.setCellValue(brf94a.getR18_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR18_amount_financial_investment_reserve().intValue());
			}
			Cell R18cell11 = R18row.getCell(13);
			if (R18cell11 != null) {
				R18cell11.setCellValue(brf94a.getR18_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR18_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R18cell12 = R18row.getCell(14);
			if (R18cell12 != null) {
				R18cell12.setCellValue(brf94a.getR18_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR18_amount_direct_investment_reserve().intValue());
			}
			Cell R18cell13 = R18row.getCell(15);
			if (R18cell13 != null) {
				R18cell13.setCellValue(brf94a.getR18_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR18_no_of_transactions_services_reserve().intValue());
			}
			Cell R18cell14 = R18row.getCell(16);
			if (R18cell14 != null) {
				R18cell14.setCellValue(brf94a.getR18_amount_services_reserve() == null ? 0
						: brf94a.getR18_amount_services_reserve().intValue());
			}
			Cell R18cell15 = R18row.getCell(17);
			if (R18cell15 != null) {
				R18cell15.setCellValue(brf94a.getR18_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR18_no_of_transactions_trade_reserve().intValue());
			}
			Cell R18cell16 = R18row.getCell(18);
			if (R18cell16 != null) {
				R18cell16.setCellValue(brf94a.getR18_amount_trade_reserve() == null ? 0
						: brf94a.getR18_amount_trade_reserve().intValue());
			}
			Cell R18cell17 = R18row.getCell(19);
			if (R18cell17 != null) {
				R18cell17.setCellValue(brf94a.getR18_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR18_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R18cell18 = R18row.getCell(20);
			if (R18cell18 != null) {
				R18cell18.setCellValue(brf94a.getR18_amount_financial_investment_gre() == null ? 0
						: brf94a.getR18_amount_financial_investment_gre().intValue());
			}
			Cell R18cell19 = R18row.getCell(21);
			if (R18cell19 != null) {
				R18cell19.setCellValue(brf94a.getR18_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR18_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R18cell20 = R18row.getCell(22);
			if (R18cell20 != null) {
				R18cell20.setCellValue(brf94a.getR18_amount_direct_investment_gre() == null ? 0
						: brf94a.getR18_amount_direct_investment_gre().intValue());
			}
			Cell R18cell21 = R18row.getCell(23);
			if (R18cell21 != null) {
				R18cell21.setCellValue(brf94a.getR18_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR18_no_of_transactions_services_gre().intValue());
			}
			Cell R18cell22 = R18row.getCell(24);
			if (R18cell22 != null) {
				R18cell22.setCellValue(brf94a.getR18_amount_services_gre() == null ? 0
						: brf94a.getR18_amount_services_gre().intValue());
			}
			Cell R18cell23 = R18row.getCell(25);
			if (R18cell23 != null) {
				R18cell23.setCellValue(brf94a.getR18_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR18_no_of_transactions_trade_gre().intValue());
			}
			Cell R18cell24 = R18row.getCell(26);
			if (R18cell24 != null) {
				R18cell24.setCellValue(
						brf94a.getR18_amount_trade_gre() == null ? 0 : brf94a.getR18_amount_trade_gre().intValue());
			}
			Cell R18cell25 = R18row.getCell(27);
			if (R18cell25 != null) {
				R18cell25.setCellValue(brf94a.getR18_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR18_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R18cell26 = R18row.getCell(28);
			if (R18cell26 != null) {
				R18cell26.setCellValue(brf94a.getR18_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR18_amount_financial_investment_corporate().intValue());
			}
			Cell R18cell27 = R18row.getCell(29);
			if (R18cell27 != null) {
				R18cell27.setCellValue(brf94a.getR18_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR18_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R18cell28 = R18row.getCell(30);
			if (R18cell28 != null) {
				R18cell28.setCellValue(brf94a.getR18_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR18_amount_direct_investment_corporate().intValue());
			}
			Cell R18cell29 = R18row.getCell(31);
			if (R18cell29 != null) {
				R18cell29.setCellValue(brf94a.getR18_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR18_no_of_transactions_services_corporate().intValue());
			}
			Cell R18cell30 = R18row.getCell(32);
			if (R18cell30 != null) {
				R18cell30.setCellValue(brf94a.getR18_amount_services_corporate() == null ? 0
						: brf94a.getR18_amount_services_corporate().intValue());
			}
			Cell R18cell31 = R18row.getCell(33);
			if (R18cell31 != null) {
				R18cell31.setCellValue(brf94a.getR18_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR18_no_of_transactions_trade_corporate().intValue());
			}
			Cell R18cell32 = R18row.getCell(34);
			if (R18cell32 != null) {
				R18cell32.setCellValue(brf94a.getR18_amount_trade_corporate() == null ? 0
						: brf94a.getR18_amount_trade_corporate().intValue());
			}
			Cell R18cell33 = R18row.getCell(35);
			if (R18cell33 != null) {
				R18cell33.setCellValue(brf94a.getR18_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR18_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R18cell34 = R18row.getCell(36);
			if (R18cell34 != null) {
				R18cell34.setCellValue(brf94a.getR18_amount_financial_investment_sme() == null ? 0
						: brf94a.getR18_amount_financial_investment_sme().intValue());
			}
			Cell R18cell35 = R18row.getCell(37);
			if (R18cell35 != null) {
				R18cell35.setCellValue(brf94a.getR18_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR18_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R18cell36 = R18row.getCell(38);
			if (R18cell36 != null) {
				R18cell36.setCellValue(brf94a.getR18_amount_direct_investment_sme() == null ? 0
						: brf94a.getR18_amount_direct_investment_sme().intValue());
			}
			Cell R18cell37 = R18row.getCell(39);
			if (R18cell37 != null) {
				R18cell37.setCellValue(brf94a.getR18_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR18_no_of_transactions_services_sme().intValue());
			}
			Cell R18cell38 = R18row.getCell(40);
			if (R18cell38 != null) {
				R18cell38.setCellValue(brf94a.getR18_amount_services_sme() == null ? 0
						: brf94a.getR18_amount_services_sme().intValue());
			}
			Cell R18cell39 = R18row.getCell(41);
			if (R18cell39 != null) {
				R18cell39.setCellValue(brf94a.getR18_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR18_no_of_transactions_trade_sme().intValue());
			}
			Cell R18cell40 = R18row.getCell(42);
			if (R18cell40 != null) {
				R18cell40.setCellValue(
						brf94a.getR18_amount_trade_sme() == null ? 0 : brf94a.getR18_amount_trade_sme().intValue());
			}
			Cell R18cell41 = R18row.getCell(43);
			if (R18cell41 != null) {
				R18cell41.setCellValue(brf94a.getR18_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R18cell42 = R18row.getCell(44);
			if (R18cell42 != null) {
				R18cell42.setCellValue(brf94a.getR18_amount_financial_investment_individual() == null ? 0
						: brf94a.getR18_amount_financial_investment_individual().intValue());
			}
			Cell R18cell43 = R18row.getCell(45);
			if (R18cell43 != null) {
				R18cell43.setCellValue(brf94a.getR18_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R18cell44 = R18row.getCell(46);
			if (R18cell44 != null) {
				R18cell44.setCellValue(brf94a.getR18_amount_direct_investment_individual() == null ? 0
						: brf94a.getR18_amount_direct_investment_individual().intValue());
			}
			Cell R18cell45 = R18row.getCell(47);
			if (R18cell45 != null) {
				R18cell45.setCellValue(brf94a.getR18_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_family_support_individual().intValue());
			}
			Cell R18cell46 = R18row.getCell(48);
			if (R18cell46 != null) {
				R18cell46.setCellValue(brf94a.getR18_amount_family_support_individual() == null ? 0
						: brf94a.getR18_amount_family_support_individual().intValue());
			}
			Cell R18cell47 = R18row.getCell(49);
			if (R18cell47 != null) {
				R18cell47.setCellValue(brf94a.getR18_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_education_individual().intValue());
			}
			Cell R18cell48 = R18row.getCell(50);
			if (R18cell48 != null) {
				R18cell48.setCellValue(brf94a.getR18_amount_education_individual() == null ? 0
						: brf94a.getR18_amount_education_individual().intValue());
			}
			Cell R18cell49 = R18row.getCell(51);
			if (R18cell49 != null) {
				R18cell49.setCellValue(brf94a.getR18_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_medical_individual().intValue());
			}

			Cell R18cell50 = R18row.getCell(52);
			if (R18cell50 != null) {
				R18cell50.setCellValue(brf94a.getR18_amount_medical_individual() == null ? 0
						: brf94a.getR18_amount_medical_individual().intValue());
			}
			Cell R18cell51 = R18row.getCell(53);
			if (R18cell51 != null) {
				R18cell51.setCellValue(brf94a.getR18_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_tourism_individual().intValue());
			}
			Cell R18cell52 = R18row.getCell(54);
			if (R18cell52 != null) {
				R18cell52.setCellValue(brf94a.getR18_amount_tourism_individual() == null ? 0
						: brf94a.getR18_amount_tourism_individual().intValue());
			}
			Cell R18cell53 = R18row.getCell(55);
			if (R18cell53 != null) {
				R18cell53.setCellValue(brf94a.getR18_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R18cell54 = R18row.getCell(56);
			if (R18cell54 != null) {
				R18cell54.setCellValue(brf94a.getR18_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR18_amount_debt_settlement_individual().intValue());
			}
			Cell R18cell55 = R18row.getCell(57);
			if (R18cell55 != null) {
				R18cell55.setCellValue(brf94a.getR18_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR18_no_of_transactions_other_services_individual().intValue());
			}

			Cell R18cell56 = R18row.getCell(58);
			if (R18cell56 != null) {
				R18cell56.setCellValue(brf94a.getR18_amount_other_services_individual() == null ? 0
						: brf94a.getR18_amount_other_services_individual().intValue());
			}

			Row R19row = sheet.getRow(27);
			Cell R19cell1 = R19row.getCell(3);
			if (R19cell1 != null) {
				R19cell1.setCellValue(brf94a.getR19_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR19_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R19cell2 = R19row.getCell(4);
			if (R19cell2 != null) {
				R19cell2.setCellValue(brf94a.getR19_amount_financial_investment_government() == null ? 0
						: brf94a.getR19_amount_financial_investment_government().intValue());
			}
			Cell R19cell3 = R19row.getCell(5);
			if (R19cell3 != null) {
				R19cell3.setCellValue(brf94a.getR19_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR19_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R19cell4 = R19row.getCell(6);
			if (R19cell4 != null) {
				R19cell4.setCellValue(brf94a.getR19_amount_direct_investment_government() == null ? 0
						: brf94a.getR19_amount_direct_investment_government().intValue());
			}
			Cell R19cell5 = R19row.getCell(7);
			if (R19cell5 != null) {
				R19cell5.setCellValue(brf94a.getR19_no_of_transactions_services_government() == null ? 0
						: brf94a.getR19_no_of_transactions_services_government().intValue());
			}
			Cell R19cell6 = R19row.getCell(8);
			if (R19cell6 != null) {
				R19cell6.setCellValue(brf94a.getR19_amount_services_government() == null ? 0
						: brf94a.getR19_amount_services_government().intValue());
			}
			Cell R19cell7 = R19row.getCell(9);
			if (R19cell7 != null) {
				R19cell7.setCellValue(brf94a.getR19_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR19_no_of_transactions_trade_government().intValue());
			}
			Cell R19cell8 = R19row.getCell(10);
			if (R19cell8 != null) {
				R19cell8.setCellValue(brf94a.getR19_amount_trade_government() == null ? 0
						: brf94a.getR19_amount_trade_government().intValue());
			}
			Cell R19cell9 = R19row.getCell(11);
			if (R19cell9 != null) {
				R19cell9.setCellValue(brf94a.getR19_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR19_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R19cell10 = R19row.getCell(12);
			if (R19cell10 != null) {
				R19cell10.setCellValue(brf94a.getR19_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR19_amount_financial_investment_reserve().intValue());
			}
			Cell R19cell11 = R19row.getCell(13);
			if (R19cell11 != null) {
				R19cell11.setCellValue(brf94a.getR19_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR19_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R19cell12 = R19row.getCell(14);
			if (R19cell12 != null) {
				R19cell12.setCellValue(brf94a.getR19_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR19_amount_direct_investment_reserve().intValue());
			}
			Cell R19cell13 = R19row.getCell(15);
			if (R19cell13 != null) {
				R19cell13.setCellValue(brf94a.getR19_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR19_no_of_transactions_services_reserve().intValue());
			}
			Cell R19cell14 = R19row.getCell(16);
			if (R19cell14 != null) {
				R19cell14.setCellValue(brf94a.getR19_amount_services_reserve() == null ? 0
						: brf94a.getR19_amount_services_reserve().intValue());
			}
			Cell R19cell15 = R19row.getCell(17);
			if (R19cell15 != null) {
				R19cell15.setCellValue(brf94a.getR19_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR19_no_of_transactions_trade_reserve().intValue());
			}
			Cell R19cell16 = R19row.getCell(18);
			if (R19cell16 != null) {
				R19cell16.setCellValue(brf94a.getR19_amount_trade_reserve() == null ? 0
						: brf94a.getR19_amount_trade_reserve().intValue());
			}
			Cell R19cell17 = R19row.getCell(19);
			if (R19cell17 != null) {
				R19cell17.setCellValue(brf94a.getR19_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR19_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R19cell18 = R19row.getCell(20);
			if (R19cell18 != null) {
				R19cell18.setCellValue(brf94a.getR19_amount_financial_investment_gre() == null ? 0
						: brf94a.getR19_amount_financial_investment_gre().intValue());
			}
			Cell R19cell19 = R19row.getCell(21);
			if (R19cell19 != null) {
				R19cell19.setCellValue(brf94a.getR19_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR19_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R19cell20 = R19row.getCell(22);
			if (R19cell20 != null) {
				R19cell20.setCellValue(brf94a.getR19_amount_direct_investment_gre() == null ? 0
						: brf94a.getR19_amount_direct_investment_gre().intValue());
			}
			Cell R19cell21 = R19row.getCell(23);
			if (R19cell21 != null) {
				R19cell21.setCellValue(brf94a.getR19_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR19_no_of_transactions_services_gre().intValue());
			}
			Cell R19cell22 = R19row.getCell(24);
			if (R19cell22 != null) {
				R19cell22.setCellValue(brf94a.getR19_amount_services_gre() == null ? 0
						: brf94a.getR19_amount_services_gre().intValue());
			}
			Cell R19cell23 = R19row.getCell(25);
			if (R19cell23 != null) {
				R19cell23.setCellValue(brf94a.getR19_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR19_no_of_transactions_trade_gre().intValue());
			}
			Cell R19cell24 = R19row.getCell(26);
			if (R19cell24 != null) {
				R19cell24.setCellValue(
						brf94a.getR19_amount_trade_gre() == null ? 0 : brf94a.getR19_amount_trade_gre().intValue());
			}
			Cell R19cell25 = R19row.getCell(27);
			if (R19cell25 != null) {
				R19cell25.setCellValue(brf94a.getR19_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR19_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R19cell26 = R19row.getCell(28);
			if (R19cell26 != null) {
				R19cell26.setCellValue(brf94a.getR19_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR19_amount_financial_investment_corporate().intValue());
			}
			Cell R19cell27 = R19row.getCell(29);
			if (R19cell27 != null) {
				R19cell27.setCellValue(brf94a.getR19_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR19_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R19cell28 = R19row.getCell(30);
			if (R19cell28 != null) {
				R19cell28.setCellValue(brf94a.getR19_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR19_amount_direct_investment_corporate().intValue());
			}
			Cell R19cell29 = R19row.getCell(31);
			if (R19cell29 != null) {
				R19cell29.setCellValue(brf94a.getR19_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR19_no_of_transactions_services_corporate().intValue());
			}
			Cell R19cell30 = R19row.getCell(32);
			if (R19cell30 != null) {
				R19cell30.setCellValue(brf94a.getR19_amount_services_corporate() == null ? 0
						: brf94a.getR19_amount_services_corporate().intValue());
			}
			Cell R19cell31 = R19row.getCell(33);
			if (R19cell31 != null) {
				R19cell31.setCellValue(brf94a.getR19_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR19_no_of_transactions_trade_corporate().intValue());
			}
			Cell R19cell32 = R19row.getCell(34);
			if (R19cell32 != null) {
				R19cell32.setCellValue(brf94a.getR19_amount_trade_corporate() == null ? 0
						: brf94a.getR19_amount_trade_corporate().intValue());
			}
			Cell R19cell33 = R19row.getCell(35);
			if (R19cell33 != null) {
				R19cell33.setCellValue(brf94a.getR19_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR19_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R19cell34 = R19row.getCell(36);
			if (R19cell34 != null) {
				R19cell34.setCellValue(brf94a.getR19_amount_financial_investment_sme() == null ? 0
						: brf94a.getR19_amount_financial_investment_sme().intValue());
			}
			Cell R19cell35 = R19row.getCell(37);
			if (R19cell35 != null) {
				R19cell35.setCellValue(brf94a.getR19_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR19_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R19cell36 = R19row.getCell(38);
			if (R19cell36 != null) {
				R19cell36.setCellValue(brf94a.getR19_amount_direct_investment_sme() == null ? 0
						: brf94a.getR19_amount_direct_investment_sme().intValue());
			}
			Cell R19cell37 = R19row.getCell(39);
			if (R19cell37 != null) {
				R19cell37.setCellValue(brf94a.getR19_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR19_no_of_transactions_services_sme().intValue());
			}
			Cell R19cell38 = R19row.getCell(40);
			if (R19cell38 != null) {
				R19cell38.setCellValue(brf94a.getR19_amount_services_sme() == null ? 0
						: brf94a.getR19_amount_services_sme().intValue());
			}
			Cell R19cell39 = R19row.getCell(41);
			if (R19cell39 != null) {
				R19cell39.setCellValue(brf94a.getR19_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR19_no_of_transactions_trade_sme().intValue());
			}
			Cell R19cell40 = R19row.getCell(42);
			if (R19cell40 != null) {
				R19cell40.setCellValue(
						brf94a.getR19_amount_trade_sme() == null ? 0 : brf94a.getR19_amount_trade_sme().intValue());
			}
			Cell R19cell41 = R19row.getCell(43);
			if (R19cell41 != null) {
				R19cell41.setCellValue(brf94a.getR19_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R19cell42 = R19row.getCell(44);
			if (R19cell42 != null) {
				R19cell42.setCellValue(brf94a.getR19_amount_financial_investment_individual() == null ? 0
						: brf94a.getR19_amount_financial_investment_individual().intValue());
			}
			Cell R19cell43 = R19row.getCell(45);
			if (R19cell43 != null) {
				R19cell43.setCellValue(brf94a.getR19_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R19cell44 = R19row.getCell(46);
			if (R19cell44 != null) {
				R19cell44.setCellValue(brf94a.getR19_amount_direct_investment_individual() == null ? 0
						: brf94a.getR19_amount_direct_investment_individual().intValue());
			}
			Cell R19cell45 = R19row.getCell(47);
			if (R19cell45 != null) {
				R19cell45.setCellValue(brf94a.getR19_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_family_support_individual().intValue());
			}
			Cell R19cell46 = R19row.getCell(48);
			if (R19cell46 != null) {
				R19cell46.setCellValue(brf94a.getR19_amount_family_support_individual() == null ? 0
						: brf94a.getR19_amount_family_support_individual().intValue());
			}
			Cell R19cell47 = R19row.getCell(49);
			if (R19cell47 != null) {
				R19cell47.setCellValue(brf94a.getR19_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_education_individual().intValue());
			}
			Cell R19cell48 = R19row.getCell(50);
			if (R19cell48 != null) {
				R19cell48.setCellValue(brf94a.getR19_amount_education_individual() == null ? 0
						: brf94a.getR19_amount_education_individual().intValue());
			}
			Cell R19cell49 = R19row.getCell(51);
			if (R19cell49 != null) {
				R19cell49.setCellValue(brf94a.getR19_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_medical_individual().intValue());
			}

			Cell R19cell50 = R19row.getCell(52);
			if (R19cell50 != null) {
				R19cell50.setCellValue(brf94a.getR19_amount_medical_individual() == null ? 0
						: brf94a.getR19_amount_medical_individual().intValue());
			}
			Cell R19cell51 = R19row.getCell(53);
			if (R19cell51 != null) {
				R19cell51.setCellValue(brf94a.getR19_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_tourism_individual().intValue());
			}
			Cell R19cell52 = R19row.getCell(54);
			if (R19cell52 != null) {
				R19cell52.setCellValue(brf94a.getR19_amount_tourism_individual() == null ? 0
						: brf94a.getR19_amount_tourism_individual().intValue());
			}
			Cell R19cell53 = R19row.getCell(55);
			if (R19cell53 != null) {
				R19cell53.setCellValue(brf94a.getR19_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R19cell54 = R19row.getCell(56);
			if (R19cell54 != null) {
				R19cell54.setCellValue(brf94a.getR19_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR19_amount_debt_settlement_individual().intValue());
			}
			Cell R19cell55 = R19row.getCell(57);
			if (R19cell55 != null) {
				R19cell55.setCellValue(brf94a.getR19_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR19_no_of_transactions_other_services_individual().intValue());
			}

			Cell R19cell56 = R19row.getCell(58);
			if (R19cell56 != null) {
				R19cell56.setCellValue(brf94a.getR19_amount_other_services_individual() == null ? 0
						: brf94a.getR19_amount_other_services_individual().intValue());
			}

			Row R20row = sheet.getRow(28);
			Cell R20cell1 = R20row.getCell(3);
			if (R20cell1 != null) {
				R20cell1.setCellValue(brf94a.getR20_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR20_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R20cell2 = R20row.getCell(4);
			if (R20cell2 != null) {
				R20cell2.setCellValue(brf94a.getR20_amount_financial_investment_government() == null ? 0
						: brf94a.getR20_amount_financial_investment_government().intValue());
			}
			Cell R20cell3 = R20row.getCell(5);
			if (R20cell3 != null) {
				R20cell3.setCellValue(brf94a.getR20_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR20_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R20cell4 = R20row.getCell(6);
			if (R20cell4 != null) {
				R20cell4.setCellValue(brf94a.getR20_amount_direct_investment_government() == null ? 0
						: brf94a.getR20_amount_direct_investment_government().intValue());
			}
			Cell R20cell5 = R20row.getCell(7);
			if (R20cell5 != null) {
				R20cell5.setCellValue(brf94a.getR20_no_of_transactions_services_government() == null ? 0
						: brf94a.getR20_no_of_transactions_services_government().intValue());
			}
			Cell R20cell6 = R20row.getCell(8);
			if (R20cell6 != null) {
				R20cell6.setCellValue(brf94a.getR20_amount_services_government() == null ? 0
						: brf94a.getR20_amount_services_government().intValue());
			}
			Cell R20cell7 = R20row.getCell(9);
			if (R20cell7 != null) {
				R20cell7.setCellValue(brf94a.getR20_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR20_no_of_transactions_trade_government().intValue());
			}
			Cell R20cell8 = R20row.getCell(10);
			if (R20cell8 != null) {
				R20cell8.setCellValue(brf94a.getR20_amount_trade_government() == null ? 0
						: brf94a.getR20_amount_trade_government().intValue());
			}
			Cell R20cell9 = R20row.getCell(11);
			if (R20cell9 != null) {
				R20cell9.setCellValue(brf94a.getR20_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR20_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R20cell10 = R20row.getCell(12);
			if (R20cell10 != null) {
				R20cell10.setCellValue(brf94a.getR20_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR20_amount_financial_investment_reserve().intValue());
			}
			Cell R20cell11 = R20row.getCell(13);
			if (R20cell11 != null) {
				R20cell11.setCellValue(brf94a.getR20_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR20_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R20cell12 = R20row.getCell(14);
			if (R20cell12 != null) {
				R20cell12.setCellValue(brf94a.getR20_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR20_amount_direct_investment_reserve().intValue());
			}
			Cell R20cell13 = R20row.getCell(15);
			if (R20cell13 != null) {
				R20cell13.setCellValue(brf94a.getR20_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR20_no_of_transactions_services_reserve().intValue());
			}
			Cell R20cell14 = R20row.getCell(16);
			if (R20cell14 != null) {
				R20cell14.setCellValue(brf94a.getR20_amount_services_reserve() == null ? 0
						: brf94a.getR20_amount_services_reserve().intValue());
			}
			Cell R20cell15 = R20row.getCell(17);
			if (R20cell15 != null) {
				R20cell15.setCellValue(brf94a.getR20_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR20_no_of_transactions_trade_reserve().intValue());
			}
			Cell R20cell16 = R20row.getCell(18);
			if (R20cell16 != null) {
				R20cell16.setCellValue(brf94a.getR20_amount_trade_reserve() == null ? 0
						: brf94a.getR20_amount_trade_reserve().intValue());
			}
			Cell R20cell17 = R20row.getCell(19);
			if (R20cell17 != null) {
				R20cell17.setCellValue(brf94a.getR20_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR20_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R20cell18 = R20row.getCell(20);
			if (R20cell18 != null) {
				R20cell18.setCellValue(brf94a.getR20_amount_financial_investment_gre() == null ? 0
						: brf94a.getR20_amount_financial_investment_gre().intValue());
			}
			Cell R20cell19 = R20row.getCell(21);
			if (R20cell19 != null) {
				R20cell19.setCellValue(brf94a.getR20_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR20_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R20cell20 = R20row.getCell(22);
			if (R20cell20 != null) {
				R20cell20.setCellValue(brf94a.getR20_amount_direct_investment_gre() == null ? 0
						: brf94a.getR20_amount_direct_investment_gre().intValue());
			}
			Cell R20cell21 = R20row.getCell(23);
			if (R20cell21 != null) {
				R20cell21.setCellValue(brf94a.getR20_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR20_no_of_transactions_services_gre().intValue());
			}
			Cell R20cell22 = R20row.getCell(24);
			if (R20cell22 != null) {
				R20cell22.setCellValue(brf94a.getR20_amount_services_gre() == null ? 0
						: brf94a.getR20_amount_services_gre().intValue());
			}
			Cell R20cell23 = R20row.getCell(25);
			if (R20cell23 != null) {
				R20cell23.setCellValue(brf94a.getR20_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR20_no_of_transactions_trade_gre().intValue());
			}
			Cell R20cell24 = R20row.getCell(26);
			if (R20cell24 != null) {
				R20cell24.setCellValue(
						brf94a.getR20_amount_trade_gre() == null ? 0 : brf94a.getR20_amount_trade_gre().intValue());
			}
			Cell R20cell25 = R20row.getCell(27);
			if (R20cell25 != null) {
				R20cell25.setCellValue(brf94a.getR20_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR20_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R20cell26 = R20row.getCell(28);
			if (R20cell26 != null) {
				R20cell26.setCellValue(brf94a.getR20_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR20_amount_financial_investment_corporate().intValue());
			}
			Cell R20cell27 = R20row.getCell(29);
			if (R20cell27 != null) {
				R20cell27.setCellValue(brf94a.getR20_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR20_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R20cell28 = R20row.getCell(30);
			if (R20cell28 != null) {
				R20cell28.setCellValue(brf94a.getR20_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR20_amount_direct_investment_corporate().intValue());
			}
			Cell R20cell29 = R20row.getCell(31);
			if (R20cell29 != null) {
				R20cell29.setCellValue(brf94a.getR20_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR20_no_of_transactions_services_corporate().intValue());
			}
			Cell R20cell30 = R20row.getCell(32);
			if (R20cell30 != null) {
				R20cell30.setCellValue(brf94a.getR20_amount_services_corporate() == null ? 0
						: brf94a.getR20_amount_services_corporate().intValue());
			}
			Cell R20cell31 = R20row.getCell(33);
			if (R20cell31 != null) {
				R20cell31.setCellValue(brf94a.getR20_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR20_no_of_transactions_trade_corporate().intValue());
			}
			Cell R20cell32 = R20row.getCell(34);
			if (R20cell32 != null) {
				R20cell32.setCellValue(brf94a.getR20_amount_trade_corporate() == null ? 0
						: brf94a.getR20_amount_trade_corporate().intValue());
			}
			Cell R20cell33 = R20row.getCell(35);
			if (R20cell33 != null) {
				R20cell33.setCellValue(brf94a.getR20_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR20_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R20cell34 = R20row.getCell(36);
			if (R20cell34 != null) {
				R20cell34.setCellValue(brf94a.getR20_amount_financial_investment_sme() == null ? 0
						: brf94a.getR20_amount_financial_investment_sme().intValue());
			}
			Cell R20cell35 = R20row.getCell(37);
			if (R20cell35 != null) {
				R20cell35.setCellValue(brf94a.getR20_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR20_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R20cell36 = R20row.getCell(38);
			if (R20cell36 != null) {
				R20cell36.setCellValue(brf94a.getR20_amount_direct_investment_sme() == null ? 0
						: brf94a.getR20_amount_direct_investment_sme().intValue());
			}
			Cell R20cell37 = R20row.getCell(39);
			if (R20cell37 != null) {
				R20cell37.setCellValue(brf94a.getR20_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR20_no_of_transactions_services_sme().intValue());
			}
			Cell R20cell38 = R20row.getCell(40);
			if (R20cell38 != null) {
				R20cell38.setCellValue(brf94a.getR20_amount_services_sme() == null ? 0
						: brf94a.getR20_amount_services_sme().intValue());
			}
			Cell R20cell39 = R20row.getCell(41);
			if (R20cell39 != null) {
				R20cell39.setCellValue(brf94a.getR20_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR20_no_of_transactions_trade_sme().intValue());
			}
			Cell R20cell40 = R20row.getCell(42);
			if (R20cell40 != null) {
				R20cell40.setCellValue(
						brf94a.getR20_amount_trade_sme() == null ? 0 : brf94a.getR20_amount_trade_sme().intValue());
			}
			Cell R20cell41 = R20row.getCell(43);
			if (R20cell41 != null) {
				R20cell41.setCellValue(brf94a.getR20_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R20cell42 = R20row.getCell(44);
			if (R20cell42 != null) {
				R20cell42.setCellValue(brf94a.getR20_amount_financial_investment_individual() == null ? 0
						: brf94a.getR20_amount_financial_investment_individual().intValue());
			}
			Cell R20cell43 = R20row.getCell(45);
			if (R20cell43 != null) {
				R20cell43.setCellValue(brf94a.getR20_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R20cell44 = R20row.getCell(46);
			if (R20cell44 != null) {
				R20cell44.setCellValue(brf94a.getR20_amount_direct_investment_individual() == null ? 0
						: brf94a.getR20_amount_direct_investment_individual().intValue());
			}
			Cell R20cell45 = R20row.getCell(47);
			if (R20cell45 != null) {
				R20cell45.setCellValue(brf94a.getR20_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_family_support_individual().intValue());
			}
			Cell R20cell46 = R20row.getCell(48);
			if (R20cell46 != null) {
				R20cell46.setCellValue(brf94a.getR20_amount_family_support_individual() == null ? 0
						: brf94a.getR20_amount_family_support_individual().intValue());
			}
			Cell R20cell47 = R20row.getCell(49);
			if (R20cell47 != null) {
				R20cell47.setCellValue(brf94a.getR20_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_education_individual().intValue());
			}
			Cell R20cell48 = R20row.getCell(50);
			if (R20cell48 != null) {
				R20cell48.setCellValue(brf94a.getR20_amount_education_individual() == null ? 0
						: brf94a.getR20_amount_education_individual().intValue());
			}
			Cell R20cell49 = R20row.getCell(51);
			if (R20cell49 != null) {
				R20cell49.setCellValue(brf94a.getR20_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_medical_individual().intValue());
			}

			Cell R20cell50 = R20row.getCell(52);
			if (R20cell50 != null) {
				R20cell50.setCellValue(brf94a.getR20_amount_medical_individual() == null ? 0
						: brf94a.getR20_amount_medical_individual().intValue());
			}
			Cell R20cell51 = R20row.getCell(53);
			if (R20cell51 != null) {
				R20cell51.setCellValue(brf94a.getR20_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_tourism_individual().intValue());
			}
			Cell R20cell52 = R20row.getCell(54);
			if (R20cell52 != null) {
				R20cell52.setCellValue(brf94a.getR20_amount_tourism_individual() == null ? 0
						: brf94a.getR20_amount_tourism_individual().intValue());
			}
			Cell R20cell53 = R20row.getCell(55);
			if (R20cell53 != null) {
				R20cell53.setCellValue(brf94a.getR20_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R20cell54 = R20row.getCell(56);
			if (R20cell54 != null) {
				R20cell54.setCellValue(brf94a.getR20_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR20_amount_debt_settlement_individual().intValue());
			}
			Cell R20cell55 = R20row.getCell(57);
			if (R20cell55 != null) {
				R20cell55.setCellValue(brf94a.getR20_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR20_no_of_transactions_other_services_individual().intValue());
			}

			Cell R20cell56 = R20row.getCell(58);
			if (R20cell56 != null) {
				R20cell56.setCellValue(brf94a.getR20_amount_other_services_individual() == null ? 0
						: brf94a.getR20_amount_other_services_individual().intValue());
			}

			Row R21row = sheet.getRow(29);
			Cell R21cell1 = R21row.getCell(3);
			if (R21cell1 != null) {
				R21cell1.setCellValue(brf94a.getR21_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR21_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R21cell2 = R21row.getCell(4);
			if (R21cell2 != null) {
				R21cell2.setCellValue(brf94a.getR21_amount_financial_investment_government() == null ? 0
						: brf94a.getR21_amount_financial_investment_government().intValue());
			}
			Cell R21cell3 = R21row.getCell(5);
			if (R21cell3 != null) {
				R21cell3.setCellValue(brf94a.getR21_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR21_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R21cell4 = R21row.getCell(6);
			if (R21cell4 != null) {
				R21cell4.setCellValue(brf94a.getR21_amount_direct_investment_government() == null ? 0
						: brf94a.getR21_amount_direct_investment_government().intValue());
			}
			Cell R21cell5 = R21row.getCell(7);
			if (R21cell5 != null) {
				R21cell5.setCellValue(brf94a.getR21_no_of_transactions_services_government() == null ? 0
						: brf94a.getR21_no_of_transactions_services_government().intValue());
			}
			Cell R21cell6 = R21row.getCell(8);
			if (R21cell6 != null) {
				R21cell6.setCellValue(brf94a.getR21_amount_services_government() == null ? 0
						: brf94a.getR21_amount_services_government().intValue());
			}
			Cell R21cell7 = R21row.getCell(9);
			if (R21cell7 != null) {
				R21cell7.setCellValue(brf94a.getR21_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR21_no_of_transactions_trade_government().intValue());
			}
			Cell R21cell8 = R21row.getCell(10);
			if (R21cell8 != null) {
				R21cell8.setCellValue(brf94a.getR21_amount_trade_government() == null ? 0
						: brf94a.getR21_amount_trade_government().intValue());
			}
			Cell R21cell9 = R21row.getCell(11);
			if (R21cell9 != null) {
				R21cell9.setCellValue(brf94a.getR21_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR21_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R21cell10 = R21row.getCell(12);
			if (R21cell10 != null) {
				R21cell10.setCellValue(brf94a.getR21_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR21_amount_financial_investment_reserve().intValue());
			}
			Cell R21cell11 = R21row.getCell(13);
			if (R21cell11 != null) {
				R21cell11.setCellValue(brf94a.getR21_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR21_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R21cell12 = R21row.getCell(14);
			if (R21cell12 != null) {
				R21cell12.setCellValue(brf94a.getR21_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR21_amount_direct_investment_reserve().intValue());
			}
			Cell R21cell13 = R21row.getCell(15);
			if (R21cell13 != null) {
				R21cell13.setCellValue(brf94a.getR21_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR21_no_of_transactions_services_reserve().intValue());
			}
			Cell R21cell14 = R21row.getCell(16);
			if (R21cell14 != null) {
				R21cell14.setCellValue(brf94a.getR21_amount_services_reserve() == null ? 0
						: brf94a.getR21_amount_services_reserve().intValue());
			}
			Cell R21cell15 = R21row.getCell(17);
			if (R21cell15 != null) {
				R21cell15.setCellValue(brf94a.getR21_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR21_no_of_transactions_trade_reserve().intValue());
			}
			Cell R21cell16 = R21row.getCell(18);
			if (R21cell16 != null) {
				R21cell16.setCellValue(brf94a.getR21_amount_trade_reserve() == null ? 0
						: brf94a.getR21_amount_trade_reserve().intValue());
			}
			Cell R21cell17 = R21row.getCell(19);
			if (R21cell17 != null) {
				R21cell17.setCellValue(brf94a.getR21_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR21_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R21cell18 = R21row.getCell(20);
			if (R21cell18 != null) {
				R21cell18.setCellValue(brf94a.getR21_amount_financial_investment_gre() == null ? 0
						: brf94a.getR21_amount_financial_investment_gre().intValue());
			}
			Cell R21cell19 = R21row.getCell(21);
			if (R21cell19 != null) {
				R21cell19.setCellValue(brf94a.getR21_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR21_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R21cell20 = R21row.getCell(22);
			if (R21cell20 != null) {
				R21cell20.setCellValue(brf94a.getR21_amount_direct_investment_gre() == null ? 0
						: brf94a.getR21_amount_direct_investment_gre().intValue());
			}
			Cell R21cell21 = R21row.getCell(23);
			if (R21cell21 != null) {
				R21cell21.setCellValue(brf94a.getR21_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR21_no_of_transactions_services_gre().intValue());
			}
			Cell R21cell22 = R21row.getCell(24);
			if (R21cell22 != null) {
				R21cell22.setCellValue(brf94a.getR21_amount_services_gre() == null ? 0
						: brf94a.getR21_amount_services_gre().intValue());
			}
			Cell R21cell23 = R21row.getCell(25);
			if (R21cell23 != null) {
				R21cell23.setCellValue(brf94a.getR21_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR21_no_of_transactions_trade_gre().intValue());
			}
			Cell R21cell24 = R21row.getCell(26);
			if (R21cell24 != null) {
				R21cell24.setCellValue(
						brf94a.getR21_amount_trade_gre() == null ? 0 : brf94a.getR21_amount_trade_gre().intValue());
			}
			Cell R21cell25 = R21row.getCell(27);
			if (R21cell25 != null) {
				R21cell25.setCellValue(brf94a.getR21_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR21_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R21cell26 = R21row.getCell(28);
			if (R21cell26 != null) {
				R21cell26.setCellValue(brf94a.getR21_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR21_amount_financial_investment_corporate().intValue());
			}
			Cell R21cell27 = R21row.getCell(29);
			if (R21cell27 != null) {
				R21cell27.setCellValue(brf94a.getR21_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR21_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R21cell28 = R21row.getCell(30);
			if (R21cell28 != null) {
				R21cell28.setCellValue(brf94a.getR21_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR21_amount_direct_investment_corporate().intValue());
			}
			Cell R21cell29 = R21row.getCell(31);
			if (R21cell29 != null) {
				R21cell29.setCellValue(brf94a.getR21_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR21_no_of_transactions_services_corporate().intValue());
			}
			Cell R21cell30 = R21row.getCell(32);
			if (R21cell30 != null) {
				R21cell30.setCellValue(brf94a.getR21_amount_services_corporate() == null ? 0
						: brf94a.getR21_amount_services_corporate().intValue());
			}
			Cell R21cell31 = R21row.getCell(33);
			if (R21cell31 != null) {
				R21cell31.setCellValue(brf94a.getR21_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR21_no_of_transactions_trade_corporate().intValue());
			}
			Cell R21cell32 = R21row.getCell(34);
			if (R21cell32 != null) {
				R21cell32.setCellValue(brf94a.getR21_amount_trade_corporate() == null ? 0
						: brf94a.getR21_amount_trade_corporate().intValue());
			}
			Cell R21cell33 = R21row.getCell(35);
			if (R21cell33 != null) {
				R21cell33.setCellValue(brf94a.getR21_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR21_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R21cell34 = R21row.getCell(36);
			if (R21cell34 != null) {
				R21cell34.setCellValue(brf94a.getR21_amount_financial_investment_sme() == null ? 0
						: brf94a.getR21_amount_financial_investment_sme().intValue());
			}
			Cell R21cell35 = R21row.getCell(37);
			if (R21cell35 != null) {
				R21cell35.setCellValue(brf94a.getR21_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR21_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R21cell36 = R21row.getCell(38);
			if (R21cell36 != null) {
				R21cell36.setCellValue(brf94a.getR21_amount_direct_investment_sme() == null ? 0
						: brf94a.getR21_amount_direct_investment_sme().intValue());
			}
			Cell R21cell37 = R21row.getCell(39);
			if (R21cell37 != null) {
				R21cell37.setCellValue(brf94a.getR21_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR21_no_of_transactions_services_sme().intValue());
			}
			Cell R21cell38 = R21row.getCell(40);
			if (R21cell38 != null) {
				R21cell38.setCellValue(brf94a.getR21_amount_services_sme() == null ? 0
						: brf94a.getR21_amount_services_sme().intValue());
			}
			Cell R21cell39 = R21row.getCell(41);
			if (R21cell39 != null) {
				R21cell39.setCellValue(brf94a.getR21_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR21_no_of_transactions_trade_sme().intValue());
			}
			Cell R21cell40 = R21row.getCell(42);
			if (R21cell40 != null) {
				R21cell40.setCellValue(
						brf94a.getR21_amount_trade_sme() == null ? 0 : brf94a.getR21_amount_trade_sme().intValue());
			}
			Cell R21cell41 = R21row.getCell(43);
			if (R21cell41 != null) {
				R21cell41.setCellValue(brf94a.getR21_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R21cell42 = R21row.getCell(44);
			if (R21cell42 != null) {
				R21cell42.setCellValue(brf94a.getR21_amount_financial_investment_individual() == null ? 0
						: brf94a.getR21_amount_financial_investment_individual().intValue());
			}
			Cell R21cell43 = R21row.getCell(45);
			if (R21cell43 != null) {
				R21cell43.setCellValue(brf94a.getR21_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R21cell44 = R21row.getCell(46);
			if (R21cell44 != null) {
				R21cell44.setCellValue(brf94a.getR21_amount_direct_investment_individual() == null ? 0
						: brf94a.getR21_amount_direct_investment_individual().intValue());
			}
			Cell R21cell45 = R21row.getCell(47);
			if (R21cell45 != null) {
				R21cell45.setCellValue(brf94a.getR21_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_family_support_individual().intValue());
			}
			Cell R21cell46 = R21row.getCell(48);
			if (R21cell46 != null) {
				R21cell46.setCellValue(brf94a.getR21_amount_family_support_individual() == null ? 0
						: brf94a.getR21_amount_family_support_individual().intValue());
			}
			Cell R21cell47 = R21row.getCell(49);
			if (R21cell47 != null) {
				R21cell47.setCellValue(brf94a.getR21_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_education_individual().intValue());
			}
			Cell R21cell48 = R21row.getCell(50);
			if (R21cell48 != null) {
				R21cell48.setCellValue(brf94a.getR21_amount_education_individual() == null ? 0
						: brf94a.getR21_amount_education_individual().intValue());
			}
			Cell R21cell49 = R21row.getCell(51);
			if (R21cell49 != null) {
				R21cell49.setCellValue(brf94a.getR21_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_medical_individual().intValue());
			}

			Cell R21cell50 = R21row.getCell(52);
			if (R21cell50 != null) {
				R21cell50.setCellValue(brf94a.getR21_amount_medical_individual() == null ? 0
						: brf94a.getR21_amount_medical_individual().intValue());
			}
			Cell R21cell51 = R21row.getCell(53);
			if (R21cell51 != null) {
				R21cell51.setCellValue(brf94a.getR21_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_tourism_individual().intValue());
			}
			Cell R21cell52 = R21row.getCell(54);
			if (R21cell52 != null) {
				R21cell52.setCellValue(brf94a.getR21_amount_tourism_individual() == null ? 0
						: brf94a.getR21_amount_tourism_individual().intValue());
			}
			Cell R21cell53 = R21row.getCell(55);
			if (R21cell53 != null) {
				R21cell53.setCellValue(brf94a.getR21_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R21cell54 = R21row.getCell(56);
			if (R21cell54 != null) {
				R21cell54.setCellValue(brf94a.getR21_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR21_amount_debt_settlement_individual().intValue());
			}
			Cell R21cell55 = R21row.getCell(57);
			if (R21cell55 != null) {
				R21cell55.setCellValue(brf94a.getR21_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR21_no_of_transactions_other_services_individual().intValue());
			}

			Cell R21cell56 = R21row.getCell(58);
			if (R21cell56 != null) {
				R21cell56.setCellValue(brf94a.getR21_amount_other_services_individual() == null ? 0
						: brf94a.getR21_amount_other_services_individual().intValue());
			}

			Row R22row = sheet.getRow(30);
			Cell R22cell1 = R22row.getCell(3);
			if (R22cell1 != null) {
				R22cell1.setCellValue(brf94a.getR22_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR22_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R22cell2 = R22row.getCell(4);
			if (R22cell2 != null) {
				R22cell2.setCellValue(brf94a.getR22_amount_financial_investment_government() == null ? 0
						: brf94a.getR22_amount_financial_investment_government().intValue());
			}
			Cell R22cell3 = R22row.getCell(5);
			if (R22cell3 != null) {
				R22cell3.setCellValue(brf94a.getR22_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR22_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R22cell4 = R22row.getCell(6);
			if (R22cell4 != null) {
				R22cell4.setCellValue(brf94a.getR22_amount_direct_investment_government() == null ? 0
						: brf94a.getR22_amount_direct_investment_government().intValue());
			}
			Cell R22cell5 = R22row.getCell(7);
			if (R22cell5 != null) {
				R22cell5.setCellValue(brf94a.getR22_no_of_transactions_services_government() == null ? 0
						: brf94a.getR22_no_of_transactions_services_government().intValue());
			}
			Cell R22cell6 = R22row.getCell(8);
			if (R22cell6 != null) {
				R22cell6.setCellValue(brf94a.getR22_amount_services_government() == null ? 0
						: brf94a.getR22_amount_services_government().intValue());
			}
			Cell R22cell7 = R22row.getCell(9);
			if (R22cell7 != null) {
				R22cell7.setCellValue(brf94a.getR22_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR22_no_of_transactions_trade_government().intValue());
			}
			Cell R22cell8 = R22row.getCell(10);
			if (R22cell8 != null) {
				R22cell8.setCellValue(brf94a.getR22_amount_trade_government() == null ? 0
						: brf94a.getR22_amount_trade_government().intValue());
			}
			Cell R22cell9 = R22row.getCell(11);
			if (R22cell9 != null) {
				R22cell9.setCellValue(brf94a.getR22_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR22_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R22cell10 = R22row.getCell(12);
			if (R22cell10 != null) {
				R22cell10.setCellValue(brf94a.getR22_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR22_amount_financial_investment_reserve().intValue());
			}
			Cell R22cell11 = R22row.getCell(13);
			if (R22cell11 != null) {
				R22cell11.setCellValue(brf94a.getR22_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR22_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R22cell12 = R22row.getCell(14);
			if (R22cell12 != null) {
				R22cell12.setCellValue(brf94a.getR22_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR22_amount_direct_investment_reserve().intValue());
			}
			Cell R22cell13 = R22row.getCell(15);
			if (R22cell13 != null) {
				R22cell13.setCellValue(brf94a.getR22_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR22_no_of_transactions_services_reserve().intValue());
			}
			Cell R22cell14 = R22row.getCell(16);
			if (R22cell14 != null) {
				R22cell14.setCellValue(brf94a.getR22_amount_services_reserve() == null ? 0
						: brf94a.getR22_amount_services_reserve().intValue());
			}
			Cell R22cell15 = R22row.getCell(17);
			if (R22cell15 != null) {
				R22cell15.setCellValue(brf94a.getR22_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR22_no_of_transactions_trade_reserve().intValue());
			}
			Cell R22cell16 = R22row.getCell(18);
			if (R22cell16 != null) {
				R22cell16.setCellValue(brf94a.getR22_amount_trade_reserve() == null ? 0
						: brf94a.getR22_amount_trade_reserve().intValue());
			}
			Cell R22cell17 = R22row.getCell(19);
			if (R22cell17 != null) {
				R22cell17.setCellValue(brf94a.getR22_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR22_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R22cell18 = R22row.getCell(20);
			if (R22cell18 != null) {
				R22cell18.setCellValue(brf94a.getR22_amount_financial_investment_gre() == null ? 0
						: brf94a.getR22_amount_financial_investment_gre().intValue());
			}
			Cell R22cell19 = R22row.getCell(21);
			if (R22cell19 != null) {
				R22cell19.setCellValue(brf94a.getR22_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR22_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R22cell20 = R22row.getCell(22);
			if (R22cell20 != null) {
				R22cell20.setCellValue(brf94a.getR22_amount_direct_investment_gre() == null ? 0
						: brf94a.getR22_amount_direct_investment_gre().intValue());
			}
			Cell R22cell21 = R22row.getCell(23);
			if (R22cell21 != null) {
				R22cell21.setCellValue(brf94a.getR22_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR22_no_of_transactions_services_gre().intValue());
			}
			Cell R22cell22 = R22row.getCell(24);
			if (R22cell22 != null) {
				R22cell22.setCellValue(brf94a.getR22_amount_services_gre() == null ? 0
						: brf94a.getR22_amount_services_gre().intValue());
			}
			Cell R22cell23 = R22row.getCell(25);
			if (R22cell23 != null) {
				R22cell23.setCellValue(brf94a.getR22_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR22_no_of_transactions_trade_gre().intValue());
			}
			Cell R22cell24 = R22row.getCell(26);
			if (R22cell24 != null) {
				R22cell24.setCellValue(
						brf94a.getR22_amount_trade_gre() == null ? 0 : brf94a.getR22_amount_trade_gre().intValue());
			}
			Cell R22cell25 = R22row.getCell(27);
			if (R22cell25 != null) {
				R22cell25.setCellValue(brf94a.getR22_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR22_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R22cell26 = R22row.getCell(28);
			if (R22cell26 != null) {
				R22cell26.setCellValue(brf94a.getR22_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR22_amount_financial_investment_corporate().intValue());
			}
			Cell R22cell27 = R22row.getCell(29);
			if (R22cell27 != null) {
				R22cell27.setCellValue(brf94a.getR22_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR22_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R22cell28 = R22row.getCell(30);
			if (R22cell28 != null) {
				R22cell28.setCellValue(brf94a.getR22_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR22_amount_direct_investment_corporate().intValue());
			}
			Cell R22cell29 = R22row.getCell(31);
			if (R22cell29 != null) {
				R22cell29.setCellValue(brf94a.getR22_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR22_no_of_transactions_services_corporate().intValue());
			}
			Cell R22cell30 = R22row.getCell(32);
			if (R22cell30 != null) {
				R22cell30.setCellValue(brf94a.getR22_amount_services_corporate() == null ? 0
						: brf94a.getR22_amount_services_corporate().intValue());
			}
			Cell R22cell31 = R22row.getCell(33);
			if (R22cell31 != null) {
				R22cell31.setCellValue(brf94a.getR22_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR22_no_of_transactions_trade_corporate().intValue());
			}
			Cell R22cell32 = R22row.getCell(34);
			if (R22cell32 != null) {
				R22cell32.setCellValue(brf94a.getR22_amount_trade_corporate() == null ? 0
						: brf94a.getR22_amount_trade_corporate().intValue());
			}
			Cell R22cell33 = R22row.getCell(35);
			if (R22cell33 != null) {
				R22cell33.setCellValue(brf94a.getR22_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR22_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R22cell34 = R22row.getCell(36);
			if (R22cell34 != null) {
				R22cell34.setCellValue(brf94a.getR22_amount_financial_investment_sme() == null ? 0
						: brf94a.getR22_amount_financial_investment_sme().intValue());
			}
			Cell R22cell35 = R22row.getCell(37);
			if (R22cell35 != null) {
				R22cell35.setCellValue(brf94a.getR22_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR22_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R22cell36 = R22row.getCell(38);
			if (R22cell36 != null) {
				R22cell36.setCellValue(brf94a.getR22_amount_direct_investment_sme() == null ? 0
						: brf94a.getR22_amount_direct_investment_sme().intValue());
			}
			Cell R22cell37 = R22row.getCell(39);
			if (R22cell37 != null) {
				R22cell37.setCellValue(brf94a.getR22_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR22_no_of_transactions_services_sme().intValue());
			}
			Cell R22cell38 = R22row.getCell(40);
			if (R22cell38 != null) {
				R22cell38.setCellValue(brf94a.getR22_amount_services_sme() == null ? 0
						: brf94a.getR22_amount_services_sme().intValue());
			}
			Cell R22cell39 = R22row.getCell(41);
			if (R22cell39 != null) {
				R22cell39.setCellValue(brf94a.getR22_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR22_no_of_transactions_trade_sme().intValue());
			}
			Cell R22cell40 = R22row.getCell(42);
			if (R22cell40 != null) {
				R22cell40.setCellValue(
						brf94a.getR22_amount_trade_sme() == null ? 0 : brf94a.getR22_amount_trade_sme().intValue());
			}
			Cell R22cell41 = R22row.getCell(43);
			if (R22cell41 != null) {
				R22cell41.setCellValue(brf94a.getR22_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R22cell42 = R22row.getCell(44);
			if (R22cell42 != null) {
				R22cell42.setCellValue(brf94a.getR22_amount_financial_investment_individual() == null ? 0
						: brf94a.getR22_amount_financial_investment_individual().intValue());
			}
			Cell R22cell43 = R22row.getCell(45);
			if (R22cell43 != null) {
				R22cell43.setCellValue(brf94a.getR22_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R22cell44 = R22row.getCell(46);
			if (R22cell44 != null) {
				R22cell44.setCellValue(brf94a.getR22_amount_direct_investment_individual() == null ? 0
						: brf94a.getR22_amount_direct_investment_individual().intValue());
			}
			Cell R22cell45 = R22row.getCell(47);
			if (R22cell45 != null) {
				R22cell45.setCellValue(brf94a.getR22_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_family_support_individual().intValue());
			}
			Cell R22cell46 = R22row.getCell(48);
			if (R22cell46 != null) {
				R22cell46.setCellValue(brf94a.getR22_amount_family_support_individual() == null ? 0
						: brf94a.getR22_amount_family_support_individual().intValue());
			}
			Cell R22cell47 = R22row.getCell(49);
			if (R22cell47 != null) {
				R22cell47.setCellValue(brf94a.getR22_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_education_individual().intValue());
			}
			Cell R22cell48 = R22row.getCell(50);
			if (R22cell48 != null) {
				R22cell48.setCellValue(brf94a.getR22_amount_education_individual() == null ? 0
						: brf94a.getR22_amount_education_individual().intValue());
			}
			Cell R22cell49 = R22row.getCell(51);
			if (R22cell49 != null) {
				R22cell49.setCellValue(brf94a.getR22_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_medical_individual().intValue());
			}

			Cell R22cell50 = R22row.getCell(52);
			if (R22cell50 != null) {
				R22cell50.setCellValue(brf94a.getR22_amount_medical_individual() == null ? 0
						: brf94a.getR22_amount_medical_individual().intValue());
			}
			Cell R22cell51 = R22row.getCell(53);
			if (R22cell51 != null) {
				R22cell51.setCellValue(brf94a.getR22_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_tourism_individual().intValue());
			}
			Cell R22cell52 = R22row.getCell(54);
			if (R22cell52 != null) {
				R22cell52.setCellValue(brf94a.getR22_amount_tourism_individual() == null ? 0
						: brf94a.getR22_amount_tourism_individual().intValue());
			}
			Cell R22cell53 = R22row.getCell(55);
			if (R22cell53 != null) {
				R22cell53.setCellValue(brf94a.getR22_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R22cell54 = R22row.getCell(56);
			if (R22cell54 != null) {
				R22cell54.setCellValue(brf94a.getR22_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR22_amount_debt_settlement_individual().intValue());
			}
			Cell R22cell55 = R22row.getCell(57);
			if (R22cell55 != null) {
				R22cell55.setCellValue(brf94a.getR22_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR22_no_of_transactions_other_services_individual().intValue());
			}

			Cell R22cell56 = R22row.getCell(58);
			if (R22cell56 != null) {
				R22cell56.setCellValue(brf94a.getR22_amount_other_services_individual() == null ? 0
						: brf94a.getR22_amount_other_services_individual().intValue());
			}

			Row R23row = sheet.getRow(31);
			Cell R23cell1 = R23row.getCell(3);
			if (R23cell1 != null) {
				R23cell1.setCellValue(brf94a.getR23_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR23_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R23cell2 = R23row.getCell(4);
			if (R23cell2 != null) {
				R23cell2.setCellValue(brf94a.getR23_amount_financial_investment_government() == null ? 0
						: brf94a.getR23_amount_financial_investment_government().intValue());
			}
			Cell R23cell3 = R23row.getCell(5);
			if (R23cell3 != null) {
				R23cell3.setCellValue(brf94a.getR23_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR23_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R23cell4 = R23row.getCell(6);
			if (R23cell4 != null) {
				R23cell4.setCellValue(brf94a.getR23_amount_direct_investment_government() == null ? 0
						: brf94a.getR23_amount_direct_investment_government().intValue());
			}
			Cell R23cell5 = R23row.getCell(7);
			if (R23cell5 != null) {
				R23cell5.setCellValue(brf94a.getR23_no_of_transactions_services_government() == null ? 0
						: brf94a.getR23_no_of_transactions_services_government().intValue());
			}
			Cell R23cell6 = R23row.getCell(8);
			if (R23cell6 != null) {
				R23cell6.setCellValue(brf94a.getR23_amount_services_government() == null ? 0
						: brf94a.getR23_amount_services_government().intValue());
			}
			Cell R23cell7 = R23row.getCell(9);
			if (R23cell7 != null) {
				R23cell7.setCellValue(brf94a.getR23_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR23_no_of_transactions_trade_government().intValue());
			}
			Cell R23cell8 = R23row.getCell(10);
			if (R23cell8 != null) {
				R23cell8.setCellValue(brf94a.getR23_amount_trade_government() == null ? 0
						: brf94a.getR23_amount_trade_government().intValue());
			}
			Cell R23cell9 = R23row.getCell(11);
			if (R23cell9 != null) {
				R23cell9.setCellValue(brf94a.getR23_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR23_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R23cell10 = R23row.getCell(12);
			if (R23cell10 != null) {
				R23cell10.setCellValue(brf94a.getR23_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR23_amount_financial_investment_reserve().intValue());
			}
			Cell R23cell11 = R23row.getCell(13);
			if (R23cell11 != null) {
				R23cell11.setCellValue(brf94a.getR23_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR23_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R23cell12 = R23row.getCell(14);
			if (R23cell12 != null) {
				R23cell12.setCellValue(brf94a.getR23_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR23_amount_direct_investment_reserve().intValue());
			}
			Cell R23cell13 = R23row.getCell(15);
			if (R23cell13 != null) {
				R23cell13.setCellValue(brf94a.getR23_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR23_no_of_transactions_services_reserve().intValue());
			}
			Cell R23cell14 = R23row.getCell(16);
			if (R23cell14 != null) {
				R23cell14.setCellValue(brf94a.getR23_amount_services_reserve() == null ? 0
						: brf94a.getR23_amount_services_reserve().intValue());
			}
			Cell R23cell15 = R23row.getCell(17);
			if (R23cell15 != null) {
				R23cell15.setCellValue(brf94a.getR23_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR23_no_of_transactions_trade_reserve().intValue());
			}
			Cell R23cell16 = R23row.getCell(18);
			if (R23cell16 != null) {
				R23cell16.setCellValue(brf94a.getR23_amount_trade_reserve() == null ? 0
						: brf94a.getR23_amount_trade_reserve().intValue());
			}
			Cell R23cell17 = R23row.getCell(19);
			if (R23cell17 != null) {
				R23cell17.setCellValue(brf94a.getR23_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR23_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R23cell18 = R23row.getCell(20);
			if (R23cell18 != null) {
				R23cell18.setCellValue(brf94a.getR23_amount_financial_investment_gre() == null ? 0
						: brf94a.getR23_amount_financial_investment_gre().intValue());
			}
			Cell R23cell19 = R23row.getCell(21);
			if (R23cell19 != null) {
				R23cell19.setCellValue(brf94a.getR23_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR23_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R23cell20 = R23row.getCell(22);
			if (R23cell20 != null) {
				R23cell20.setCellValue(brf94a.getR23_amount_direct_investment_gre() == null ? 0
						: brf94a.getR23_amount_direct_investment_gre().intValue());
			}
			Cell R23cell21 = R23row.getCell(23);
			if (R23cell21 != null) {
				R23cell21.setCellValue(brf94a.getR23_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR23_no_of_transactions_services_gre().intValue());
			}
			Cell R23cell22 = R23row.getCell(24);
			if (R23cell22 != null) {
				R23cell22.setCellValue(brf94a.getR23_amount_services_gre() == null ? 0
						: brf94a.getR23_amount_services_gre().intValue());
			}
			Cell R23cell23 = R23row.getCell(25);
			if (R23cell23 != null) {
				R23cell23.setCellValue(brf94a.getR23_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR23_no_of_transactions_trade_gre().intValue());
			}
			Cell R23cell24 = R23row.getCell(26);
			if (R23cell24 != null) {
				R23cell24.setCellValue(
						brf94a.getR23_amount_trade_gre() == null ? 0 : brf94a.getR23_amount_trade_gre().intValue());
			}
			Cell R23cell25 = R23row.getCell(27);
			if (R23cell25 != null) {
				R23cell25.setCellValue(brf94a.getR23_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR23_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R23cell26 = R23row.getCell(28);
			if (R23cell26 != null) {
				R23cell26.setCellValue(brf94a.getR23_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR23_amount_financial_investment_corporate().intValue());
			}
			Cell R23cell27 = R23row.getCell(29);
			if (R23cell27 != null) {
				R23cell27.setCellValue(brf94a.getR23_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR23_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R23cell28 = R23row.getCell(30);
			if (R23cell28 != null) {
				R23cell28.setCellValue(brf94a.getR23_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR23_amount_direct_investment_corporate().intValue());
			}
			Cell R23cell29 = R23row.getCell(31);
			if (R23cell29 != null) {
				R23cell29.setCellValue(brf94a.getR23_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR23_no_of_transactions_services_corporate().intValue());
			}
			Cell R23cell30 = R23row.getCell(32);
			if (R23cell30 != null) {
				R23cell30.setCellValue(brf94a.getR23_amount_services_corporate() == null ? 0
						: brf94a.getR23_amount_services_corporate().intValue());
			}
			Cell R23cell31 = R23row.getCell(33);
			if (R23cell31 != null) {
				R23cell31.setCellValue(brf94a.getR23_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR23_no_of_transactions_trade_corporate().intValue());
			}
			Cell R23cell32 = R23row.getCell(34);
			if (R23cell32 != null) {
				R23cell32.setCellValue(brf94a.getR23_amount_trade_corporate() == null ? 0
						: brf94a.getR23_amount_trade_corporate().intValue());
			}
			Cell R23cell33 = R23row.getCell(35);
			if (R23cell33 != null) {
				R23cell33.setCellValue(brf94a.getR23_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR23_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R23cell34 = R23row.getCell(36);
			if (R23cell34 != null) {
				R23cell34.setCellValue(brf94a.getR23_amount_financial_investment_sme() == null ? 0
						: brf94a.getR23_amount_financial_investment_sme().intValue());
			}
			Cell R23cell35 = R23row.getCell(37);
			if (R23cell35 != null) {
				R23cell35.setCellValue(brf94a.getR23_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR23_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R23cell36 = R23row.getCell(38);
			if (R23cell36 != null) {
				R23cell36.setCellValue(brf94a.getR23_amount_direct_investment_sme() == null ? 0
						: brf94a.getR23_amount_direct_investment_sme().intValue());
			}
			Cell R23cell37 = R23row.getCell(39);
			if (R23cell37 != null) {
				R23cell37.setCellValue(brf94a.getR23_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR23_no_of_transactions_services_sme().intValue());
			}
			Cell R23cell38 = R23row.getCell(40);
			if (R23cell38 != null) {
				R23cell38.setCellValue(brf94a.getR23_amount_services_sme() == null ? 0
						: brf94a.getR23_amount_services_sme().intValue());
			}
			Cell R23cell39 = R23row.getCell(41);
			if (R23cell39 != null) {
				R23cell39.setCellValue(brf94a.getR23_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR23_no_of_transactions_trade_sme().intValue());
			}
			Cell R23cell40 = R23row.getCell(42);
			if (R23cell40 != null) {
				R23cell40.setCellValue(
						brf94a.getR23_amount_trade_sme() == null ? 0 : brf94a.getR23_amount_trade_sme().intValue());
			}
			Cell R23cell41 = R23row.getCell(43);
			if (R23cell41 != null) {
				R23cell41.setCellValue(brf94a.getR23_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R23cell42 = R23row.getCell(44);
			if (R23cell42 != null) {
				R23cell42.setCellValue(brf94a.getR23_amount_financial_investment_individual() == null ? 0
						: brf94a.getR23_amount_financial_investment_individual().intValue());
			}
			Cell R23cell43 = R23row.getCell(45);
			if (R23cell43 != null) {
				R23cell43.setCellValue(brf94a.getR23_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R23cell44 = R23row.getCell(46);
			if (R23cell44 != null) {
				R23cell44.setCellValue(brf94a.getR23_amount_direct_investment_individual() == null ? 0
						: brf94a.getR23_amount_direct_investment_individual().intValue());
			}
			Cell R23cell45 = R23row.getCell(47);
			if (R23cell45 != null) {
				R23cell45.setCellValue(brf94a.getR23_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_family_support_individual().intValue());
			}
			Cell R23cell46 = R23row.getCell(48);
			if (R23cell46 != null) {
				R23cell46.setCellValue(brf94a.getR23_amount_family_support_individual() == null ? 0
						: brf94a.getR23_amount_family_support_individual().intValue());
			}
			Cell R23cell47 = R23row.getCell(49);
			if (R23cell47 != null) {
				R23cell47.setCellValue(brf94a.getR23_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_education_individual().intValue());
			}
			Cell R23cell48 = R23row.getCell(50);
			if (R23cell48 != null) {
				R23cell48.setCellValue(brf94a.getR23_amount_education_individual() == null ? 0
						: brf94a.getR23_amount_education_individual().intValue());
			}
			Cell R23cell49 = R23row.getCell(51);
			if (R23cell49 != null) {
				R23cell49.setCellValue(brf94a.getR23_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_medical_individual().intValue());
			}

			Cell R23cell50 = R23row.getCell(52);
			if (R23cell50 != null) {
				R23cell50.setCellValue(brf94a.getR23_amount_medical_individual() == null ? 0
						: brf94a.getR23_amount_medical_individual().intValue());
			}
			Cell R23cell51 = R23row.getCell(53);
			if (R23cell51 != null) {
				R23cell51.setCellValue(brf94a.getR23_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_tourism_individual().intValue());
			}
			Cell R23cell52 = R23row.getCell(54);
			if (R23cell52 != null) {
				R23cell52.setCellValue(brf94a.getR23_amount_tourism_individual() == null ? 0
						: brf94a.getR23_amount_tourism_individual().intValue());
			}
			Cell R23cell53 = R23row.getCell(55);
			if (R23cell53 != null) {
				R23cell53.setCellValue(brf94a.getR23_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R23cell54 = R23row.getCell(56);
			if (R23cell54 != null) {
				R23cell54.setCellValue(brf94a.getR23_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR23_amount_debt_settlement_individual().intValue());
			}
			Cell R23cell55 = R23row.getCell(57);
			if (R23cell55 != null) {
				R23cell55.setCellValue(brf94a.getR23_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR23_no_of_transactions_other_services_individual().intValue());
			}

			Cell R23cell56 = R23row.getCell(58);
			if (R23cell56 != null) {
				R23cell56.setCellValue(brf94a.getR23_amount_other_services_individual() == null ? 0
						: brf94a.getR23_amount_other_services_individual().intValue());
			}

			Row R24row = sheet.getRow(32);
			Cell R24cell1 = R24row.getCell(3);
			if (R24cell1 != null) {
				R24cell1.setCellValue(brf94a.getR24_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR24_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R24cell2 = R24row.getCell(4);
			if (R24cell2 != null) {
				R24cell2.setCellValue(brf94a.getR24_amount_financial_investment_government() == null ? 0
						: brf94a.getR24_amount_financial_investment_government().intValue());
			}
			Cell R24cell3 = R24row.getCell(5);
			if (R24cell3 != null) {
				R24cell3.setCellValue(brf94a.getR24_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR24_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R24cell4 = R24row.getCell(6);
			if (R24cell4 != null) {
				R24cell4.setCellValue(brf94a.getR24_amount_direct_investment_government() == null ? 0
						: brf94a.getR24_amount_direct_investment_government().intValue());
			}
			Cell R24cell5 = R24row.getCell(7);
			if (R24cell5 != null) {
				R24cell5.setCellValue(brf94a.getR24_no_of_transactions_services_government() == null ? 0
						: brf94a.getR24_no_of_transactions_services_government().intValue());
			}
			Cell R24cell6 = R24row.getCell(8);
			if (R24cell6 != null) {
				R24cell6.setCellValue(brf94a.getR24_amount_services_government() == null ? 0
						: brf94a.getR24_amount_services_government().intValue());
			}
			Cell R24cell7 = R24row.getCell(9);
			if (R24cell7 != null) {
				R24cell7.setCellValue(brf94a.getR24_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR24_no_of_transactions_trade_government().intValue());
			}
			Cell R24cell8 = R24row.getCell(10);
			if (R24cell8 != null) {
				R24cell8.setCellValue(brf94a.getR24_amount_trade_government() == null ? 0
						: brf94a.getR24_amount_trade_government().intValue());
			}
			Cell R24cell9 = R24row.getCell(11);
			if (R24cell9 != null) {
				R24cell9.setCellValue(brf94a.getR24_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR24_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R24cell10 = R24row.getCell(12);
			if (R24cell10 != null) {
				R24cell10.setCellValue(brf94a.getR24_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR24_amount_financial_investment_reserve().intValue());
			}
			Cell R24cell11 = R24row.getCell(13);
			if (R24cell11 != null) {
				R24cell11.setCellValue(brf94a.getR24_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR24_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R24cell12 = R24row.getCell(14);
			if (R24cell12 != null) {
				R24cell12.setCellValue(brf94a.getR24_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR24_amount_direct_investment_reserve().intValue());
			}
			Cell R24cell13 = R24row.getCell(15);
			if (R24cell13 != null) {
				R24cell13.setCellValue(brf94a.getR24_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR24_no_of_transactions_services_reserve().intValue());
			}
			Cell R24cell14 = R24row.getCell(16);
			if (R24cell14 != null) {
				R24cell14.setCellValue(brf94a.getR24_amount_services_reserve() == null ? 0
						: brf94a.getR24_amount_services_reserve().intValue());
			}
			Cell R24cell15 = R24row.getCell(17);
			if (R24cell15 != null) {
				R24cell15.setCellValue(brf94a.getR24_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR24_no_of_transactions_trade_reserve().intValue());
			}
			Cell R24cell16 = R24row.getCell(18);
			if (R24cell16 != null) {
				R24cell16.setCellValue(brf94a.getR24_amount_trade_reserve() == null ? 0
						: brf94a.getR24_amount_trade_reserve().intValue());
			}
			Cell R24cell17 = R24row.getCell(19);
			if (R24cell17 != null) {
				R24cell17.setCellValue(brf94a.getR24_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR24_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R24cell18 = R24row.getCell(20);
			if (R24cell18 != null) {
				R24cell18.setCellValue(brf94a.getR24_amount_financial_investment_gre() == null ? 0
						: brf94a.getR24_amount_financial_investment_gre().intValue());
			}
			Cell R24cell19 = R24row.getCell(21);
			if (R24cell19 != null) {
				R24cell19.setCellValue(brf94a.getR24_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR24_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R24cell20 = R24row.getCell(22);
			if (R24cell20 != null) {
				R24cell20.setCellValue(brf94a.getR24_amount_direct_investment_gre() == null ? 0
						: brf94a.getR24_amount_direct_investment_gre().intValue());
			}
			Cell R24cell21 = R24row.getCell(23);
			if (R24cell21 != null) {
				R24cell21.setCellValue(brf94a.getR24_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR24_no_of_transactions_services_gre().intValue());
			}
			Cell R24cell22 = R24row.getCell(24);
			if (R24cell22 != null) {
				R24cell22.setCellValue(brf94a.getR24_amount_services_gre() == null ? 0
						: brf94a.getR24_amount_services_gre().intValue());
			}
			Cell R24cell23 = R24row.getCell(25);
			if (R24cell23 != null) {
				R24cell23.setCellValue(brf94a.getR24_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR24_no_of_transactions_trade_gre().intValue());
			}
			Cell R24cell24 = R24row.getCell(26);
			if (R24cell24 != null) {
				R24cell24.setCellValue(
						brf94a.getR24_amount_trade_gre() == null ? 0 : brf94a.getR24_amount_trade_gre().intValue());
			}
			Cell R24cell25 = R24row.getCell(27);
			if (R24cell25 != null) {
				R24cell25.setCellValue(brf94a.getR24_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR24_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R24cell26 = R24row.getCell(28);
			if (R24cell26 != null) {
				R24cell26.setCellValue(brf94a.getR24_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR24_amount_financial_investment_corporate().intValue());
			}
			Cell R24cell27 = R24row.getCell(29);
			if (R24cell27 != null) {
				R24cell27.setCellValue(brf94a.getR24_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR24_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R24cell28 = R24row.getCell(30);
			if (R24cell28 != null) {
				R24cell28.setCellValue(brf94a.getR24_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR24_amount_direct_investment_corporate().intValue());
			}
			Cell R24cell29 = R24row.getCell(31);
			if (R24cell29 != null) {
				R24cell29.setCellValue(brf94a.getR24_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR24_no_of_transactions_services_corporate().intValue());
			}
			Cell R24cell30 = R24row.getCell(32);
			if (R24cell30 != null) {
				R24cell30.setCellValue(brf94a.getR24_amount_services_corporate() == null ? 0
						: brf94a.getR24_amount_services_corporate().intValue());
			}
			Cell R24cell31 = R24row.getCell(33);
			if (R24cell31 != null) {
				R24cell31.setCellValue(brf94a.getR24_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR24_no_of_transactions_trade_corporate().intValue());
			}
			Cell R24cell32 = R24row.getCell(34);
			if (R24cell32 != null) {
				R24cell32.setCellValue(brf94a.getR24_amount_trade_corporate() == null ? 0
						: brf94a.getR24_amount_trade_corporate().intValue());
			}
			Cell R24cell33 = R24row.getCell(35);
			if (R24cell33 != null) {
				R24cell33.setCellValue(brf94a.getR24_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR24_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R24cell34 = R24row.getCell(36);
			if (R24cell34 != null) {
				R24cell34.setCellValue(brf94a.getR24_amount_financial_investment_sme() == null ? 0
						: brf94a.getR24_amount_financial_investment_sme().intValue());
			}
			Cell R24cell35 = R24row.getCell(37);
			if (R24cell35 != null) {
				R24cell35.setCellValue(brf94a.getR24_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR24_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R24cell36 = R24row.getCell(38);
			if (R24cell36 != null) {
				R24cell36.setCellValue(brf94a.getR24_amount_direct_investment_sme() == null ? 0
						: brf94a.getR24_amount_direct_investment_sme().intValue());
			}
			Cell R24cell37 = R24row.getCell(39);
			if (R24cell37 != null) {
				R24cell37.setCellValue(brf94a.getR24_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR24_no_of_transactions_services_sme().intValue());
			}
			Cell R24cell38 = R24row.getCell(40);
			if (R24cell38 != null) {
				R24cell38.setCellValue(brf94a.getR24_amount_services_sme() == null ? 0
						: brf94a.getR24_amount_services_sme().intValue());
			}
			Cell R24cell39 = R24row.getCell(41);
			if (R24cell39 != null) {
				R24cell39.setCellValue(brf94a.getR24_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR24_no_of_transactions_trade_sme().intValue());
			}
			Cell R24cell40 = R24row.getCell(42);
			if (R24cell40 != null) {
				R24cell40.setCellValue(
						brf94a.getR24_amount_trade_sme() == null ? 0 : brf94a.getR24_amount_trade_sme().intValue());
			}
			Cell R24cell41 = R24row.getCell(43);
			if (R24cell41 != null) {
				R24cell41.setCellValue(brf94a.getR24_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R24cell42 = R24row.getCell(44);
			if (R24cell42 != null) {
				R24cell42.setCellValue(brf94a.getR24_amount_financial_investment_individual() == null ? 0
						: brf94a.getR24_amount_financial_investment_individual().intValue());
			}
			Cell R24cell43 = R24row.getCell(45);
			if (R24cell43 != null) {
				R24cell43.setCellValue(brf94a.getR24_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R24cell44 = R24row.getCell(46);
			if (R24cell44 != null) {
				R24cell44.setCellValue(brf94a.getR24_amount_direct_investment_individual() == null ? 0
						: brf94a.getR24_amount_direct_investment_individual().intValue());
			}
			Cell R24cell45 = R24row.getCell(47);
			if (R24cell45 != null) {
				R24cell45.setCellValue(brf94a.getR24_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_family_support_individual().intValue());
			}
			Cell R24cell46 = R24row.getCell(48);
			if (R24cell46 != null) {
				R24cell46.setCellValue(brf94a.getR24_amount_family_support_individual() == null ? 0
						: brf94a.getR24_amount_family_support_individual().intValue());
			}
			Cell R24cell47 = R24row.getCell(49);
			if (R24cell47 != null) {
				R24cell47.setCellValue(brf94a.getR24_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_education_individual().intValue());
			}
			Cell R24cell48 = R24row.getCell(50);
			if (R24cell48 != null) {
				R24cell48.setCellValue(brf94a.getR24_amount_education_individual() == null ? 0
						: brf94a.getR24_amount_education_individual().intValue());
			}
			Cell R24cell49 = R24row.getCell(51);
			if (R24cell49 != null) {
				R24cell49.setCellValue(brf94a.getR24_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_medical_individual().intValue());
			}

			Cell R24cell50 = R24row.getCell(52);
			if (R24cell50 != null) {
				R24cell50.setCellValue(brf94a.getR24_amount_medical_individual() == null ? 0
						: brf94a.getR24_amount_medical_individual().intValue());
			}
			Cell R24cell51 = R24row.getCell(53);
			if (R24cell51 != null) {
				R24cell51.setCellValue(brf94a.getR24_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_tourism_individual().intValue());
			}
			Cell R24cell52 = R24row.getCell(54);
			if (R24cell52 != null) {
				R24cell52.setCellValue(brf94a.getR24_amount_tourism_individual() == null ? 0
						: brf94a.getR24_amount_tourism_individual().intValue());
			}
			Cell R24cell53 = R24row.getCell(55);
			if (R24cell53 != null) {
				R24cell53.setCellValue(brf94a.getR24_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R24cell54 = R24row.getCell(56);
			if (R24cell54 != null) {
				R24cell54.setCellValue(brf94a.getR24_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR24_amount_debt_settlement_individual().intValue());
			}
			Cell R24cell55 = R24row.getCell(57);
			if (R24cell55 != null) {
				R24cell55.setCellValue(brf94a.getR24_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR24_no_of_transactions_other_services_individual().intValue());
			}

			Cell R24cell56 = R24row.getCell(58);
			if (R24cell56 != null) {
				R24cell56.setCellValue(brf94a.getR24_amount_other_services_individual() == null ? 0
						: brf94a.getR24_amount_other_services_individual().intValue());
			}

			Row R25row = sheet.getRow(33);
			Cell R25cell1 = R25row.getCell(3);
			if (R25cell1 != null) {
				R25cell1.setCellValue(brf94a.getR25_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR25_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R25cell2 = R25row.getCell(4);
			if (R25cell2 != null) {
				R25cell2.setCellValue(brf94a.getR25_amount_financial_investment_government() == null ? 0
						: brf94a.getR25_amount_financial_investment_government().intValue());
			}
			Cell R25cell3 = R25row.getCell(5);
			if (R25cell3 != null) {
				R25cell3.setCellValue(brf94a.getR25_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR25_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R25cell4 = R25row.getCell(6);
			if (R25cell4 != null) {
				R25cell4.setCellValue(brf94a.getR25_amount_direct_investment_government() == null ? 0
						: brf94a.getR25_amount_direct_investment_government().intValue());
			}
			Cell R25cell5 = R25row.getCell(7);
			if (R25cell5 != null) {
				R25cell5.setCellValue(brf94a.getR25_no_of_transactions_services_government() == null ? 0
						: brf94a.getR25_no_of_transactions_services_government().intValue());
			}
			Cell R25cell6 = R25row.getCell(8);
			if (R25cell6 != null) {
				R25cell6.setCellValue(brf94a.getR25_amount_services_government() == null ? 0
						: brf94a.getR25_amount_services_government().intValue());
			}
			Cell R25cell7 = R25row.getCell(9);
			if (R25cell7 != null) {
				R25cell7.setCellValue(brf94a.getR25_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR25_no_of_transactions_trade_government().intValue());
			}
			Cell R25cell8 = R25row.getCell(10);
			if (R25cell8 != null) {
				R25cell8.setCellValue(brf94a.getR25_amount_trade_government() == null ? 0
						: brf94a.getR25_amount_trade_government().intValue());
			}
			Cell R25cell9 = R25row.getCell(11);
			if (R25cell9 != null) {
				R25cell9.setCellValue(brf94a.getR25_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR25_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R25cell10 = R25row.getCell(12);
			if (R25cell10 != null) {
				R25cell10.setCellValue(brf94a.getR25_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR25_amount_financial_investment_reserve().intValue());
			}
			Cell R25cell11 = R25row.getCell(13);
			if (R25cell11 != null) {
				R25cell11.setCellValue(brf94a.getR25_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR25_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R25cell12 = R25row.getCell(14);
			if (R25cell12 != null) {
				R25cell12.setCellValue(brf94a.getR25_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR25_amount_direct_investment_reserve().intValue());
			}
			Cell R25cell13 = R25row.getCell(15);
			if (R25cell13 != null) {
				R25cell13.setCellValue(brf94a.getR25_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR25_no_of_transactions_services_reserve().intValue());
			}
			Cell R25cell14 = R25row.getCell(16);
			if (R25cell14 != null) {
				R25cell14.setCellValue(brf94a.getR25_amount_services_reserve() == null ? 0
						: brf94a.getR25_amount_services_reserve().intValue());
			}
			Cell R25cell15 = R25row.getCell(17);
			if (R25cell15 != null) {
				R25cell15.setCellValue(brf94a.getR25_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR25_no_of_transactions_trade_reserve().intValue());
			}
			Cell R25cell16 = R25row.getCell(18);
			if (R25cell16 != null) {
				R25cell16.setCellValue(brf94a.getR25_amount_trade_reserve() == null ? 0
						: brf94a.getR25_amount_trade_reserve().intValue());
			}
			Cell R25cell17 = R25row.getCell(19);
			if (R25cell17 != null) {
				R25cell17.setCellValue(brf94a.getR25_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR25_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R25cell18 = R25row.getCell(20);
			if (R25cell18 != null) {
				R25cell18.setCellValue(brf94a.getR25_amount_financial_investment_gre() == null ? 0
						: brf94a.getR25_amount_financial_investment_gre().intValue());
			}
			Cell R25cell19 = R25row.getCell(21);
			if (R25cell19 != null) {
				R25cell19.setCellValue(brf94a.getR25_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR25_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R25cell20 = R25row.getCell(22);
			if (R25cell20 != null) {
				R25cell20.setCellValue(brf94a.getR25_amount_direct_investment_gre() == null ? 0
						: brf94a.getR25_amount_direct_investment_gre().intValue());
			}
			Cell R25cell21 = R25row.getCell(23);
			if (R25cell21 != null) {
				R25cell21.setCellValue(brf94a.getR25_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR25_no_of_transactions_services_gre().intValue());
			}
			Cell R25cell22 = R25row.getCell(24);
			if (R25cell22 != null) {
				R25cell22.setCellValue(brf94a.getR25_amount_services_gre() == null ? 0
						: brf94a.getR25_amount_services_gre().intValue());
			}
			Cell R25cell23 = R25row.getCell(25);
			if (R25cell23 != null) {
				R25cell23.setCellValue(brf94a.getR25_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR25_no_of_transactions_trade_gre().intValue());
			}
			Cell R25cell24 = R25row.getCell(26);
			if (R25cell24 != null) {
				R25cell24.setCellValue(
						brf94a.getR25_amount_trade_gre() == null ? 0 : brf94a.getR25_amount_trade_gre().intValue());
			}
			Cell R25cell25 = R25row.getCell(27);
			if (R25cell25 != null) {
				R25cell25.setCellValue(brf94a.getR25_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR25_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R25cell26 = R25row.getCell(28);
			if (R25cell26 != null) {
				R25cell26.setCellValue(brf94a.getR25_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR25_amount_financial_investment_corporate().intValue());
			}
			Cell R25cell27 = R25row.getCell(29);
			if (R25cell27 != null) {
				R25cell27.setCellValue(brf94a.getR25_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR25_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R25cell28 = R25row.getCell(30);
			if (R25cell28 != null) {
				R25cell28.setCellValue(brf94a.getR25_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR25_amount_direct_investment_corporate().intValue());
			}
			Cell R25cell29 = R25row.getCell(31);
			if (R25cell29 != null) {
				R25cell29.setCellValue(brf94a.getR25_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR25_no_of_transactions_services_corporate().intValue());
			}
			Cell R25cell30 = R25row.getCell(32);
			if (R25cell30 != null) {
				R25cell30.setCellValue(brf94a.getR25_amount_services_corporate() == null ? 0
						: brf94a.getR25_amount_services_corporate().intValue());
			}
			Cell R25cell31 = R25row.getCell(33);
			if (R25cell31 != null) {
				R25cell31.setCellValue(brf94a.getR25_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR25_no_of_transactions_trade_corporate().intValue());
			}
			Cell R25cell32 = R25row.getCell(34);
			if (R25cell32 != null) {
				R25cell32.setCellValue(brf94a.getR25_amount_trade_corporate() == null ? 0
						: brf94a.getR25_amount_trade_corporate().intValue());
			}
			Cell R25cell33 = R25row.getCell(35);
			if (R25cell33 != null) {
				R25cell33.setCellValue(brf94a.getR25_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR25_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R25cell34 = R25row.getCell(36);
			if (R25cell34 != null) {
				R25cell34.setCellValue(brf94a.getR25_amount_financial_investment_sme() == null ? 0
						: brf94a.getR25_amount_financial_investment_sme().intValue());
			}
			Cell R25cell35 = R25row.getCell(37);
			if (R25cell35 != null) {
				R25cell35.setCellValue(brf94a.getR25_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR25_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R25cell36 = R25row.getCell(38);
			if (R25cell36 != null) {
				R25cell36.setCellValue(brf94a.getR25_amount_direct_investment_sme() == null ? 0
						: brf94a.getR25_amount_direct_investment_sme().intValue());
			}
			Cell R25cell37 = R25row.getCell(39);
			if (R25cell37 != null) {
				R25cell37.setCellValue(brf94a.getR25_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR25_no_of_transactions_services_sme().intValue());
			}
			Cell R25cell38 = R25row.getCell(40);
			if (R25cell38 != null) {
				R25cell38.setCellValue(brf94a.getR25_amount_services_sme() == null ? 0
						: brf94a.getR25_amount_services_sme().intValue());
			}
			Cell R25cell39 = R25row.getCell(41);
			if (R25cell39 != null) {
				R25cell39.setCellValue(brf94a.getR25_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR25_no_of_transactions_trade_sme().intValue());
			}
			Cell R25cell40 = R25row.getCell(42);
			if (R25cell40 != null) {
				R25cell40.setCellValue(
						brf94a.getR25_amount_trade_sme() == null ? 0 : brf94a.getR25_amount_trade_sme().intValue());
			}
			Cell R25cell41 = R25row.getCell(43);
			if (R25cell41 != null) {
				R25cell41.setCellValue(brf94a.getR25_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R25cell42 = R25row.getCell(44);
			if (R25cell42 != null) {
				R25cell42.setCellValue(brf94a.getR25_amount_financial_investment_individual() == null ? 0
						: brf94a.getR25_amount_financial_investment_individual().intValue());
			}
			Cell R25cell43 = R25row.getCell(45);
			if (R25cell43 != null) {
				R25cell43.setCellValue(brf94a.getR25_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R25cell44 = R25row.getCell(46);
			if (R25cell44 != null) {
				R25cell44.setCellValue(brf94a.getR25_amount_direct_investment_individual() == null ? 0
						: brf94a.getR25_amount_direct_investment_individual().intValue());
			}
			Cell R25cell45 = R25row.getCell(47);
			if (R25cell45 != null) {
				R25cell45.setCellValue(brf94a.getR25_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_family_support_individual().intValue());
			}
			Cell R25cell46 = R25row.getCell(48);
			if (R25cell46 != null) {
				R25cell46.setCellValue(brf94a.getR25_amount_family_support_individual() == null ? 0
						: brf94a.getR25_amount_family_support_individual().intValue());
			}
			Cell R25cell47 = R25row.getCell(49);
			if (R25cell47 != null) {
				R25cell47.setCellValue(brf94a.getR25_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_education_individual().intValue());
			}
			Cell R25cell48 = R25row.getCell(50);
			if (R25cell48 != null) {
				R25cell48.setCellValue(brf94a.getR25_amount_education_individual() == null ? 0
						: brf94a.getR25_amount_education_individual().intValue());
			}
			Cell R25cell49 = R25row.getCell(51);
			if (R25cell49 != null) {
				R25cell49.setCellValue(brf94a.getR25_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_medical_individual().intValue());
			}

			Cell R25cell50 = R25row.getCell(52);
			if (R25cell50 != null) {
				R25cell50.setCellValue(brf94a.getR25_amount_medical_individual() == null ? 0
						: brf94a.getR25_amount_medical_individual().intValue());
			}
			Cell R25cell51 = R25row.getCell(53);
			if (R25cell51 != null) {
				R25cell51.setCellValue(brf94a.getR25_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_tourism_individual().intValue());
			}
			Cell R25cell52 = R25row.getCell(54);
			if (R25cell52 != null) {
				R25cell52.setCellValue(brf94a.getR25_amount_tourism_individual() == null ? 0
						: brf94a.getR25_amount_tourism_individual().intValue());
			}
			Cell R25cell53 = R25row.getCell(55);
			if (R25cell53 != null) {
				R25cell53.setCellValue(brf94a.getR25_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R25cell54 = R25row.getCell(56);
			if (R25cell54 != null) {
				R25cell54.setCellValue(brf94a.getR25_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR25_amount_debt_settlement_individual().intValue());
			}
			Cell R25cell55 = R25row.getCell(57);
			if (R25cell55 != null) {
				R25cell55.setCellValue(brf94a.getR25_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR25_no_of_transactions_other_services_individual().intValue());
			}

			Cell R25cell56 = R25row.getCell(58);
			if (R25cell56 != null) {
				R25cell56.setCellValue(brf94a.getR25_amount_other_services_individual() == null ? 0
						: brf94a.getR25_amount_other_services_individual().intValue());
			}

			Row R27row = sheet.getRow(35);
			Cell R27cell1 = R27row.getCell(3);
			if (R27cell1 != null) {
				R27cell1.setCellValue(brf94a.getR27_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR27_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R27cell2 = R27row.getCell(4);
			if (R27cell2 != null) {
				R27cell2.setCellValue(brf94a.getR27_amount_financial_investment_government() == null ? 0
						: brf94a.getR27_amount_financial_investment_government().intValue());
			}
			Cell R27cell3 = R27row.getCell(5);
			if (R27cell3 != null) {
				R27cell3.setCellValue(brf94a.getR27_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR27_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R27cell4 = R27row.getCell(6);
			if (R27cell4 != null) {
				R27cell4.setCellValue(brf94a.getR27_amount_direct_investment_government() == null ? 0
						: brf94a.getR27_amount_direct_investment_government().intValue());
			}
			Cell R27cell5 = R27row.getCell(7);
			if (R27cell5 != null) {
				R27cell5.setCellValue(brf94a.getR27_no_of_transactions_services_government() == null ? 0
						: brf94a.getR27_no_of_transactions_services_government().intValue());
			}
			Cell R27cell6 = R27row.getCell(8);
			if (R27cell6 != null) {
				R27cell6.setCellValue(brf94a.getR27_amount_services_government() == null ? 0
						: brf94a.getR27_amount_services_government().intValue());
			}
			Cell R27cell7 = R27row.getCell(9);
			if (R27cell7 != null) {
				R27cell7.setCellValue(brf94a.getR27_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR27_no_of_transactions_trade_government().intValue());
			}
			Cell R27cell8 = R27row.getCell(10);
			if (R27cell8 != null) {
				R27cell8.setCellValue(brf94a.getR27_amount_trade_government() == null ? 0
						: brf94a.getR27_amount_trade_government().intValue());
			}
			Cell R27cell9 = R27row.getCell(11);
			if (R27cell9 != null) {
				R27cell9.setCellValue(brf94a.getR27_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR27_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R27cell10 = R27row.getCell(12);
			if (R27cell10 != null) {
				R27cell10.setCellValue(brf94a.getR27_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR27_amount_financial_investment_reserve().intValue());
			}
			Cell R27cell11 = R27row.getCell(13);
			if (R27cell11 != null) {
				R27cell11.setCellValue(brf94a.getR27_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR27_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R27cell12 = R27row.getCell(14);
			if (R27cell12 != null) {
				R27cell12.setCellValue(brf94a.getR27_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR27_amount_direct_investment_reserve().intValue());
			}
			Cell R27cell13 = R27row.getCell(15);
			if (R27cell13 != null) {
				R27cell13.setCellValue(brf94a.getR27_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR27_no_of_transactions_services_reserve().intValue());
			}
			Cell R27cell14 = R27row.getCell(16);
			if (R27cell14 != null) {
				R27cell14.setCellValue(brf94a.getR27_amount_services_reserve() == null ? 0
						: brf94a.getR27_amount_services_reserve().intValue());
			}
			Cell R27cell15 = R27row.getCell(17);
			if (R27cell15 != null) {
				R27cell15.setCellValue(brf94a.getR27_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR27_no_of_transactions_trade_reserve().intValue());
			}
			Cell R27cell16 = R27row.getCell(18);
			if (R27cell16 != null) {
				R27cell16.setCellValue(brf94a.getR27_amount_trade_reserve() == null ? 0
						: brf94a.getR27_amount_trade_reserve().intValue());
			}
			Cell R27cell17 = R27row.getCell(19);
			if (R27cell17 != null) {
				R27cell17.setCellValue(brf94a.getR27_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR27_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R27cell18 = R27row.getCell(20);
			if (R27cell18 != null) {
				R27cell18.setCellValue(brf94a.getR27_amount_financial_investment_gre() == null ? 0
						: brf94a.getR27_amount_financial_investment_gre().intValue());
			}
			Cell R27cell19 = R27row.getCell(21);
			if (R27cell19 != null) {
				R27cell19.setCellValue(brf94a.getR27_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR27_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R27cell20 = R27row.getCell(22);
			if (R27cell20 != null) {
				R27cell20.setCellValue(brf94a.getR27_amount_direct_investment_gre() == null ? 0
						: brf94a.getR27_amount_direct_investment_gre().intValue());
			}
			Cell R27cell21 = R27row.getCell(23);
			if (R27cell21 != null) {
				R27cell21.setCellValue(brf94a.getR27_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR27_no_of_transactions_services_gre().intValue());
			}
			Cell R27cell22 = R27row.getCell(24);
			if (R27cell22 != null) {
				R27cell22.setCellValue(brf94a.getR27_amount_services_gre() == null ? 0
						: brf94a.getR27_amount_services_gre().intValue());
			}
			Cell R27cell23 = R27row.getCell(25);
			if (R27cell23 != null) {
				R27cell23.setCellValue(brf94a.getR27_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR27_no_of_transactions_trade_gre().intValue());
			}
			Cell R27cell24 = R27row.getCell(26);
			if (R27cell24 != null) {
				R27cell24.setCellValue(
						brf94a.getR27_amount_trade_gre() == null ? 0 : brf94a.getR27_amount_trade_gre().intValue());
			}
			Cell R27cell25 = R27row.getCell(27);
			if (R27cell25 != null) {
				R27cell25.setCellValue(brf94a.getR27_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR27_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R27cell26 = R27row.getCell(28);
			if (R27cell26 != null) {
				R27cell26.setCellValue(brf94a.getR27_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR27_amount_financial_investment_corporate().intValue());
			}
			Cell R27cell27 = R27row.getCell(29);
			if (R27cell27 != null) {
				R27cell27.setCellValue(brf94a.getR27_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR27_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R27cell28 = R27row.getCell(30);
			if (R27cell28 != null) {
				R27cell28.setCellValue(brf94a.getR27_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR27_amount_direct_investment_corporate().intValue());
			}
			Cell R27cell29 = R27row.getCell(31);
			if (R27cell29 != null) {
				R27cell29.setCellValue(brf94a.getR27_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR27_no_of_transactions_services_corporate().intValue());
			}
			Cell R27cell30 = R27row.getCell(32);
			if (R27cell30 != null) {
				R27cell30.setCellValue(brf94a.getR27_amount_services_corporate() == null ? 0
						: brf94a.getR27_amount_services_corporate().intValue());
			}
			Cell R27cell31 = R27row.getCell(33);
			if (R27cell31 != null) {
				R27cell31.setCellValue(brf94a.getR27_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR27_no_of_transactions_trade_corporate().intValue());
			}
			Cell R27cell32 = R27row.getCell(34);
			if (R27cell32 != null) {
				R27cell32.setCellValue(brf94a.getR27_amount_trade_corporate() == null ? 0
						: brf94a.getR27_amount_trade_corporate().intValue());
			}
			Cell R27cell33 = R27row.getCell(35);
			if (R27cell33 != null) {
				R27cell33.setCellValue(brf94a.getR27_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR27_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R27cell34 = R27row.getCell(36);
			if (R27cell34 != null) {
				R27cell34.setCellValue(brf94a.getR27_amount_financial_investment_sme() == null ? 0
						: brf94a.getR27_amount_financial_investment_sme().intValue());
			}
			Cell R27cell35 = R27row.getCell(37);
			if (R27cell35 != null) {
				R27cell35.setCellValue(brf94a.getR27_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR27_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R27cell36 = R27row.getCell(38);
			if (R27cell36 != null) {
				R27cell36.setCellValue(brf94a.getR27_amount_direct_investment_sme() == null ? 0
						: brf94a.getR27_amount_direct_investment_sme().intValue());
			}
			Cell R27cell37 = R27row.getCell(39);
			if (R27cell37 != null) {
				R27cell37.setCellValue(brf94a.getR27_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR27_no_of_transactions_services_sme().intValue());
			}
			Cell R27cell38 = R27row.getCell(40);
			if (R27cell38 != null) {
				R27cell38.setCellValue(brf94a.getR27_amount_services_sme() == null ? 0
						: brf94a.getR27_amount_services_sme().intValue());
			}
			Cell R27cell39 = R27row.getCell(41);
			if (R27cell39 != null) {
				R27cell39.setCellValue(brf94a.getR27_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR27_no_of_transactions_trade_sme().intValue());
			}
			Cell R27cell40 = R27row.getCell(42);
			if (R27cell40 != null) {
				R27cell40.setCellValue(
						brf94a.getR27_amount_trade_sme() == null ? 0 : brf94a.getR27_amount_trade_sme().intValue());
			}
			Cell R27cell41 = R27row.getCell(43);
			if (R27cell41 != null) {
				R27cell41.setCellValue(brf94a.getR27_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R27cell42 = R27row.getCell(44);
			if (R27cell42 != null) {
				R27cell42.setCellValue(brf94a.getR27_amount_financial_investment_individual() == null ? 0
						: brf94a.getR27_amount_financial_investment_individual().intValue());
			}
			Cell R27cell43 = R27row.getCell(45);
			if (R27cell43 != null) {
				R27cell43.setCellValue(brf94a.getR27_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R27cell44 = R27row.getCell(46);
			if (R27cell44 != null) {
				R27cell44.setCellValue(brf94a.getR27_amount_direct_investment_individual() == null ? 0
						: brf94a.getR27_amount_direct_investment_individual().intValue());
			}
			Cell R27cell45 = R27row.getCell(47);
			if (R27cell45 != null) {
				R27cell45.setCellValue(brf94a.getR27_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_family_support_individual().intValue());
			}
			Cell R27cell46 = R27row.getCell(48);
			if (R27cell46 != null) {
				R27cell46.setCellValue(brf94a.getR27_amount_family_support_individual() == null ? 0
						: brf94a.getR27_amount_family_support_individual().intValue());
			}
			Cell R27cell47 = R27row.getCell(49);
			if (R27cell47 != null) {
				R27cell47.setCellValue(brf94a.getR27_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_education_individual().intValue());
			}
			Cell R27cell48 = R27row.getCell(50);
			if (R27cell48 != null) {
				R27cell48.setCellValue(brf94a.getR27_amount_education_individual() == null ? 0
						: brf94a.getR27_amount_education_individual().intValue());
			}
			Cell R27cell49 = R27row.getCell(51);
			if (R27cell49 != null) {
				R27cell49.setCellValue(brf94a.getR27_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_medical_individual().intValue());
			}

			Cell R27cell50 = R27row.getCell(52);
			if (R27cell50 != null) {
				R27cell50.setCellValue(brf94a.getR27_amount_medical_individual() == null ? 0
						: brf94a.getR27_amount_medical_individual().intValue());
			}
			Cell R27cell51 = R27row.getCell(53);
			if (R27cell51 != null) {
				R27cell51.setCellValue(brf94a.getR27_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_tourism_individual().intValue());
			}
			Cell R27cell52 = R27row.getCell(54);
			if (R27cell52 != null) {
				R27cell52.setCellValue(brf94a.getR27_amount_tourism_individual() == null ? 0
						: brf94a.getR27_amount_tourism_individual().intValue());
			}
			Cell R27cell53 = R27row.getCell(55);
			if (R27cell53 != null) {
				R27cell53.setCellValue(brf94a.getR27_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R27cell54 = R27row.getCell(56);
			if (R27cell54 != null) {
				R27cell54.setCellValue(brf94a.getR27_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR27_amount_debt_settlement_individual().intValue());
			}
			Cell R27cell55 = R27row.getCell(57);
			if (R27cell55 != null) {
				R27cell55.setCellValue(brf94a.getR27_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR27_no_of_transactions_other_services_individual().intValue());
			}

			Cell R27cell56 = R27row.getCell(58);
			if (R27cell56 != null) {
				R27cell56.setCellValue(brf94a.getR27_amount_other_services_individual() == null ? 0
						: brf94a.getR27_amount_other_services_individual().intValue());
			}

			Row R28row = sheet.getRow(36);
			Cell R28cell1 = R28row.getCell(3);
			if (R28cell1 != null) {
				R28cell1.setCellValue(brf94a.getR28_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR28_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R28cell2 = R28row.getCell(4);
			if (R28cell2 != null) {
				R28cell2.setCellValue(brf94a.getR28_amount_financial_investment_government() == null ? 0
						: brf94a.getR28_amount_financial_investment_government().intValue());
			}
			Cell R28cell3 = R28row.getCell(5);
			if (R28cell3 != null) {
				R28cell3.setCellValue(brf94a.getR28_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR28_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R28cell4 = R28row.getCell(6);
			if (R28cell4 != null) {
				R28cell4.setCellValue(brf94a.getR28_amount_direct_investment_government() == null ? 0
						: brf94a.getR28_amount_direct_investment_government().intValue());
			}
			Cell R28cell5 = R28row.getCell(7);
			if (R28cell5 != null) {
				R28cell5.setCellValue(brf94a.getR28_no_of_transactions_services_government() == null ? 0
						: brf94a.getR28_no_of_transactions_services_government().intValue());
			}
			Cell R28cell6 = R28row.getCell(8);
			if (R28cell6 != null) {
				R28cell6.setCellValue(brf94a.getR28_amount_services_government() == null ? 0
						: brf94a.getR28_amount_services_government().intValue());
			}
			Cell R28cell7 = R28row.getCell(9);
			if (R28cell7 != null) {
				R28cell7.setCellValue(brf94a.getR28_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR28_no_of_transactions_trade_government().intValue());
			}
			Cell R28cell8 = R28row.getCell(10);
			if (R28cell8 != null) {
				R28cell8.setCellValue(brf94a.getR28_amount_trade_government() == null ? 0
						: brf94a.getR28_amount_trade_government().intValue());
			}
			Cell R28cell9 = R28row.getCell(11);
			if (R28cell9 != null) {
				R28cell9.setCellValue(brf94a.getR28_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR28_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R28cell10 = R28row.getCell(12);
			if (R28cell10 != null) {
				R28cell10.setCellValue(brf94a.getR28_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR28_amount_financial_investment_reserve().intValue());
			}
			Cell R28cell11 = R28row.getCell(13);
			if (R28cell11 != null) {
				R28cell11.setCellValue(brf94a.getR28_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR28_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R28cell12 = R28row.getCell(14);
			if (R28cell12 != null) {
				R28cell12.setCellValue(brf94a.getR28_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR28_amount_direct_investment_reserve().intValue());
			}
			Cell R28cell13 = R28row.getCell(15);
			if (R28cell13 != null) {
				R28cell13.setCellValue(brf94a.getR28_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR28_no_of_transactions_services_reserve().intValue());
			}
			Cell R28cell14 = R28row.getCell(16);
			if (R28cell14 != null) {
				R28cell14.setCellValue(brf94a.getR28_amount_services_reserve() == null ? 0
						: brf94a.getR28_amount_services_reserve().intValue());
			}
			Cell R28cell15 = R28row.getCell(17);
			if (R28cell15 != null) {
				R28cell15.setCellValue(brf94a.getR28_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR28_no_of_transactions_trade_reserve().intValue());
			}
			Cell R28cell16 = R28row.getCell(18);
			if (R28cell16 != null) {
				R28cell16.setCellValue(brf94a.getR28_amount_trade_reserve() == null ? 0
						: brf94a.getR28_amount_trade_reserve().intValue());
			}
			Cell R28cell17 = R28row.getCell(19);
			if (R28cell17 != null) {
				R28cell17.setCellValue(brf94a.getR28_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR28_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R28cell18 = R28row.getCell(20);
			if (R28cell18 != null) {
				R28cell18.setCellValue(brf94a.getR28_amount_financial_investment_gre() == null ? 0
						: brf94a.getR28_amount_financial_investment_gre().intValue());
			}
			Cell R28cell19 = R28row.getCell(21);
			if (R28cell19 != null) {
				R28cell19.setCellValue(brf94a.getR28_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR28_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R28cell20 = R28row.getCell(22);
			if (R28cell20 != null) {
				R28cell20.setCellValue(brf94a.getR28_amount_direct_investment_gre() == null ? 0
						: brf94a.getR28_amount_direct_investment_gre().intValue());
			}
			Cell R28cell21 = R28row.getCell(23);
			if (R28cell21 != null) {
				R28cell21.setCellValue(brf94a.getR28_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR28_no_of_transactions_services_gre().intValue());
			}
			Cell R28cell22 = R28row.getCell(24);
			if (R28cell22 != null) {
				R28cell22.setCellValue(brf94a.getR28_amount_services_gre() == null ? 0
						: brf94a.getR28_amount_services_gre().intValue());
			}
			Cell R28cell23 = R28row.getCell(25);
			if (R28cell23 != null) {
				R28cell23.setCellValue(brf94a.getR28_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR28_no_of_transactions_trade_gre().intValue());
			}
			Cell R28cell24 = R28row.getCell(26);
			if (R28cell24 != null) {
				R28cell24.setCellValue(
						brf94a.getR28_amount_trade_gre() == null ? 0 : brf94a.getR28_amount_trade_gre().intValue());
			}
			Cell R28cell25 = R28row.getCell(27);
			if (R28cell25 != null) {
				R28cell25.setCellValue(brf94a.getR28_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR28_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R28cell26 = R28row.getCell(28);
			if (R28cell26 != null) {
				R28cell26.setCellValue(brf94a.getR28_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR28_amount_financial_investment_corporate().intValue());
			}
			Cell R28cell27 = R28row.getCell(29);
			if (R28cell27 != null) {
				R28cell27.setCellValue(brf94a.getR28_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR28_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R28cell28 = R28row.getCell(30);
			if (R28cell28 != null) {
				R28cell28.setCellValue(brf94a.getR28_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR28_amount_direct_investment_corporate().intValue());
			}
			Cell R28cell29 = R28row.getCell(31);
			if (R28cell29 != null) {
				R28cell29.setCellValue(brf94a.getR28_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR28_no_of_transactions_services_corporate().intValue());
			}
			Cell R28cell30 = R28row.getCell(32);
			if (R28cell30 != null) {
				R28cell30.setCellValue(brf94a.getR28_amount_services_corporate() == null ? 0
						: brf94a.getR28_amount_services_corporate().intValue());
			}
			Cell R28cell31 = R28row.getCell(33);
			if (R28cell31 != null) {
				R28cell31.setCellValue(brf94a.getR28_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR28_no_of_transactions_trade_corporate().intValue());
			}
			Cell R28cell32 = R28row.getCell(34);
			if (R28cell32 != null) {
				R28cell32.setCellValue(brf94a.getR28_amount_trade_corporate() == null ? 0
						: brf94a.getR28_amount_trade_corporate().intValue());
			}
			Cell R28cell33 = R28row.getCell(35);
			if (R28cell33 != null) {
				R28cell33.setCellValue(brf94a.getR28_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR28_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R28cell34 = R28row.getCell(36);
			if (R28cell34 != null) {
				R28cell34.setCellValue(brf94a.getR28_amount_financial_investment_sme() == null ? 0
						: brf94a.getR28_amount_financial_investment_sme().intValue());
			}
			Cell R28cell35 = R28row.getCell(37);
			if (R28cell35 != null) {
				R28cell35.setCellValue(brf94a.getR28_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR28_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R28cell36 = R28row.getCell(38);
			if (R28cell36 != null) {
				R28cell36.setCellValue(brf94a.getR28_amount_direct_investment_sme() == null ? 0
						: brf94a.getR28_amount_direct_investment_sme().intValue());
			}
			Cell R28cell37 = R28row.getCell(39);
			if (R28cell37 != null) {
				R28cell37.setCellValue(brf94a.getR28_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR28_no_of_transactions_services_sme().intValue());
			}
			Cell R28cell38 = R28row.getCell(40);
			if (R28cell38 != null) {
				R28cell38.setCellValue(brf94a.getR28_amount_services_sme() == null ? 0
						: brf94a.getR28_amount_services_sme().intValue());
			}
			Cell R28cell39 = R28row.getCell(41);
			if (R28cell39 != null) {
				R28cell39.setCellValue(brf94a.getR28_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR28_no_of_transactions_trade_sme().intValue());
			}
			Cell R28cell40 = R28row.getCell(42);
			if (R28cell40 != null) {
				R28cell40.setCellValue(
						brf94a.getR28_amount_trade_sme() == null ? 0 : brf94a.getR28_amount_trade_sme().intValue());
			}
			Cell R28cell41 = R28row.getCell(43);
			if (R28cell41 != null) {
				R28cell41.setCellValue(brf94a.getR28_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R28cell42 = R28row.getCell(44);
			if (R28cell42 != null) {
				R28cell42.setCellValue(brf94a.getR28_amount_financial_investment_individual() == null ? 0
						: brf94a.getR28_amount_financial_investment_individual().intValue());
			}
			Cell R28cell43 = R28row.getCell(45);
			if (R28cell43 != null) {
				R28cell43.setCellValue(brf94a.getR28_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R28cell44 = R28row.getCell(46);
			if (R28cell44 != null) {
				R28cell44.setCellValue(brf94a.getR28_amount_direct_investment_individual() == null ? 0
						: brf94a.getR28_amount_direct_investment_individual().intValue());
			}
			Cell R28cell45 = R28row.getCell(47);
			if (R28cell45 != null) {
				R28cell45.setCellValue(brf94a.getR28_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_family_support_individual().intValue());
			}
			Cell R28cell46 = R28row.getCell(48);
			if (R28cell46 != null) {
				R28cell46.setCellValue(brf94a.getR28_amount_family_support_individual() == null ? 0
						: brf94a.getR28_amount_family_support_individual().intValue());
			}
			Cell R28cell47 = R28row.getCell(49);
			if (R28cell47 != null) {
				R28cell47.setCellValue(brf94a.getR28_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_education_individual().intValue());
			}
			Cell R28cell48 = R28row.getCell(50);
			if (R28cell48 != null) {
				R28cell48.setCellValue(brf94a.getR28_amount_education_individual() == null ? 0
						: brf94a.getR28_amount_education_individual().intValue());
			}
			Cell R28cell49 = R28row.getCell(51);
			if (R28cell49 != null) {
				R28cell49.setCellValue(brf94a.getR28_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_medical_individual().intValue());
			}

			Cell R28cell50 = R28row.getCell(52);
			if (R28cell50 != null) {
				R28cell50.setCellValue(brf94a.getR28_amount_medical_individual() == null ? 0
						: brf94a.getR28_amount_medical_individual().intValue());
			}
			Cell R28cell51 = R28row.getCell(53);
			if (R28cell51 != null) {
				R28cell51.setCellValue(brf94a.getR28_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_tourism_individual().intValue());
			}
			Cell R28cell52 = R28row.getCell(54);
			if (R28cell52 != null) {
				R28cell52.setCellValue(brf94a.getR28_amount_tourism_individual() == null ? 0
						: brf94a.getR28_amount_tourism_individual().intValue());
			}
			Cell R28cell53 = R28row.getCell(55);
			if (R28cell53 != null) {
				R28cell53.setCellValue(brf94a.getR28_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R28cell54 = R28row.getCell(56);
			if (R28cell54 != null) {
				R28cell54.setCellValue(brf94a.getR28_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR28_amount_debt_settlement_individual().intValue());
			}
			Cell R28cell55 = R28row.getCell(57);
			if (R28cell55 != null) {
				R28cell55.setCellValue(brf94a.getR28_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR28_no_of_transactions_other_services_individual().intValue());
			}

			Cell R28cell56 = R28row.getCell(58);
			if (R28cell56 != null) {
				R28cell56.setCellValue(brf94a.getR28_amount_other_services_individual() == null ? 0
						: brf94a.getR28_amount_other_services_individual().intValue());
			}

			Row R29row = sheet.getRow(37);
			Cell R29cell1 = R29row.getCell(3);
			if (R29cell1 != null) {
				R29cell1.setCellValue(brf94a.getR29_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR29_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R29cell2 = R29row.getCell(4);
			if (R29cell2 != null) {
				R29cell2.setCellValue(brf94a.getR29_amount_financial_investment_government() == null ? 0
						: brf94a.getR29_amount_financial_investment_government().intValue());
			}
			Cell R29cell3 = R29row.getCell(5);
			if (R29cell3 != null) {
				R29cell3.setCellValue(brf94a.getR29_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR29_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R29cell4 = R29row.getCell(6);
			if (R29cell4 != null) {
				R29cell4.setCellValue(brf94a.getR29_amount_direct_investment_government() == null ? 0
						: brf94a.getR29_amount_direct_investment_government().intValue());
			}
			Cell R29cell5 = R29row.getCell(7);
			if (R29cell5 != null) {
				R29cell5.setCellValue(brf94a.getR29_no_of_transactions_services_government() == null ? 0
						: brf94a.getR29_no_of_transactions_services_government().intValue());
			}
			Cell R29cell6 = R29row.getCell(8);
			if (R29cell6 != null) {
				R29cell6.setCellValue(brf94a.getR29_amount_services_government() == null ? 0
						: brf94a.getR29_amount_services_government().intValue());
			}
			Cell R29cell7 = R29row.getCell(9);
			if (R29cell7 != null) {
				R29cell7.setCellValue(brf94a.getR29_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR29_no_of_transactions_trade_government().intValue());
			}
			Cell R29cell8 = R29row.getCell(10);
			if (R29cell8 != null) {
				R29cell8.setCellValue(brf94a.getR29_amount_trade_government() == null ? 0
						: brf94a.getR29_amount_trade_government().intValue());
			}
			Cell R29cell9 = R29row.getCell(11);
			if (R29cell9 != null) {
				R29cell9.setCellValue(brf94a.getR29_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR29_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R29cell10 = R29row.getCell(12);
			if (R29cell10 != null) {
				R29cell10.setCellValue(brf94a.getR29_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR29_amount_financial_investment_reserve().intValue());
			}
			Cell R29cell11 = R29row.getCell(13);
			if (R29cell11 != null) {
				R29cell11.setCellValue(brf94a.getR29_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR29_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R29cell12 = R29row.getCell(14);
			if (R29cell12 != null) {
				R29cell12.setCellValue(brf94a.getR29_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR29_amount_direct_investment_reserve().intValue());
			}
			Cell R29cell13 = R29row.getCell(15);
			if (R29cell13 != null) {
				R29cell13.setCellValue(brf94a.getR29_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR29_no_of_transactions_services_reserve().intValue());
			}
			Cell R29cell14 = R29row.getCell(16);
			if (R29cell14 != null) {
				R29cell14.setCellValue(brf94a.getR29_amount_services_reserve() == null ? 0
						: brf94a.getR29_amount_services_reserve().intValue());
			}
			Cell R29cell15 = R29row.getCell(17);
			if (R29cell15 != null) {
				R29cell15.setCellValue(brf94a.getR29_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR29_no_of_transactions_trade_reserve().intValue());
			}
			Cell R29cell16 = R29row.getCell(18);
			if (R29cell16 != null) {
				R29cell16.setCellValue(brf94a.getR29_amount_trade_reserve() == null ? 0
						: brf94a.getR29_amount_trade_reserve().intValue());
			}
			Cell R29cell17 = R29row.getCell(19);
			if (R29cell17 != null) {
				R29cell17.setCellValue(brf94a.getR29_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR29_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R29cell18 = R29row.getCell(20);
			if (R29cell18 != null) {
				R29cell18.setCellValue(brf94a.getR29_amount_financial_investment_gre() == null ? 0
						: brf94a.getR29_amount_financial_investment_gre().intValue());
			}
			Cell R29cell19 = R29row.getCell(21);
			if (R29cell19 != null) {
				R29cell19.setCellValue(brf94a.getR29_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR29_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R29cell20 = R29row.getCell(22);
			if (R29cell20 != null) {
				R29cell20.setCellValue(brf94a.getR29_amount_direct_investment_gre() == null ? 0
						: brf94a.getR29_amount_direct_investment_gre().intValue());
			}
			Cell R29cell21 = R29row.getCell(23);
			if (R29cell21 != null) {
				R29cell21.setCellValue(brf94a.getR29_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR29_no_of_transactions_services_gre().intValue());
			}
			Cell R29cell22 = R29row.getCell(24);
			if (R29cell22 != null) {
				R29cell22.setCellValue(brf94a.getR29_amount_services_gre() == null ? 0
						: brf94a.getR29_amount_services_gre().intValue());
			}
			Cell R29cell23 = R29row.getCell(25);
			if (R29cell23 != null) {
				R29cell23.setCellValue(brf94a.getR29_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR29_no_of_transactions_trade_gre().intValue());
			}
			Cell R29cell24 = R29row.getCell(26);
			if (R29cell24 != null) {
				R29cell24.setCellValue(
						brf94a.getR29_amount_trade_gre() == null ? 0 : brf94a.getR29_amount_trade_gre().intValue());
			}
			Cell R29cell25 = R29row.getCell(27);
			if (R29cell25 != null) {
				R29cell25.setCellValue(brf94a.getR29_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR29_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R29cell26 = R29row.getCell(28);
			if (R29cell26 != null) {
				R29cell26.setCellValue(brf94a.getR29_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR29_amount_financial_investment_corporate().intValue());
			}
			Cell R29cell27 = R29row.getCell(29);
			if (R29cell27 != null) {
				R29cell27.setCellValue(brf94a.getR29_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR29_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R29cell28 = R29row.getCell(30);
			if (R29cell28 != null) {
				R29cell28.setCellValue(brf94a.getR29_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR29_amount_direct_investment_corporate().intValue());
			}
			Cell R29cell29 = R29row.getCell(31);
			if (R29cell29 != null) {
				R29cell29.setCellValue(brf94a.getR29_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR29_no_of_transactions_services_corporate().intValue());
			}
			Cell R29cell30 = R29row.getCell(32);
			if (R29cell30 != null) {
				R29cell30.setCellValue(brf94a.getR29_amount_services_corporate() == null ? 0
						: brf94a.getR29_amount_services_corporate().intValue());
			}
			Cell R29cell31 = R29row.getCell(33);
			if (R29cell31 != null) {
				R29cell31.setCellValue(brf94a.getR29_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR29_no_of_transactions_trade_corporate().intValue());
			}
			Cell R29cell32 = R29row.getCell(34);
			if (R29cell32 != null) {
				R29cell32.setCellValue(brf94a.getR29_amount_trade_corporate() == null ? 0
						: brf94a.getR29_amount_trade_corporate().intValue());
			}
			Cell R29cell33 = R29row.getCell(35);
			if (R29cell33 != null) {
				R29cell33.setCellValue(brf94a.getR29_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR29_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R29cell34 = R29row.getCell(36);
			if (R29cell34 != null) {
				R29cell34.setCellValue(brf94a.getR29_amount_financial_investment_sme() == null ? 0
						: brf94a.getR29_amount_financial_investment_sme().intValue());
			}
			Cell R29cell35 = R29row.getCell(37);
			if (R29cell35 != null) {
				R29cell35.setCellValue(brf94a.getR29_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR29_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R29cell36 = R29row.getCell(38);
			if (R29cell36 != null) {
				R29cell36.setCellValue(brf94a.getR29_amount_direct_investment_sme() == null ? 0
						: brf94a.getR29_amount_direct_investment_sme().intValue());
			}
			Cell R29cell37 = R29row.getCell(39);
			if (R29cell37 != null) {
				R29cell37.setCellValue(brf94a.getR29_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR29_no_of_transactions_services_sme().intValue());
			}
			Cell R29cell38 = R29row.getCell(40);
			if (R29cell38 != null) {
				R29cell38.setCellValue(brf94a.getR29_amount_services_sme() == null ? 0
						: brf94a.getR29_amount_services_sme().intValue());
			}
			Cell R29cell39 = R29row.getCell(41);
			if (R29cell39 != null) {
				R29cell39.setCellValue(brf94a.getR29_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR29_no_of_transactions_trade_sme().intValue());
			}
			Cell R29cell40 = R29row.getCell(42);
			if (R29cell40 != null) {
				R29cell40.setCellValue(
						brf94a.getR29_amount_trade_sme() == null ? 0 : brf94a.getR29_amount_trade_sme().intValue());
			}
			Cell R29cell41 = R29row.getCell(43);
			if (R29cell41 != null) {
				R29cell41.setCellValue(brf94a.getR29_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R29cell42 = R29row.getCell(44);
			if (R29cell42 != null) {
				R29cell42.setCellValue(brf94a.getR29_amount_financial_investment_individual() == null ? 0
						: brf94a.getR29_amount_financial_investment_individual().intValue());
			}
			Cell R29cell43 = R29row.getCell(45);
			if (R29cell43 != null) {
				R29cell43.setCellValue(brf94a.getR29_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R29cell44 = R29row.getCell(46);
			if (R29cell44 != null) {
				R29cell44.setCellValue(brf94a.getR29_amount_direct_investment_individual() == null ? 0
						: brf94a.getR29_amount_direct_investment_individual().intValue());
			}
			Cell R29cell45 = R29row.getCell(47);
			if (R29cell45 != null) {
				R29cell45.setCellValue(brf94a.getR29_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_family_support_individual().intValue());
			}
			Cell R29cell46 = R29row.getCell(48);
			if (R29cell46 != null) {
				R29cell46.setCellValue(brf94a.getR29_amount_family_support_individual() == null ? 0
						: brf94a.getR29_amount_family_support_individual().intValue());
			}
			Cell R29cell47 = R29row.getCell(49);
			if (R29cell47 != null) {
				R29cell47.setCellValue(brf94a.getR29_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_education_individual().intValue());
			}
			Cell R29cell48 = R29row.getCell(50);
			if (R29cell48 != null) {
				R29cell48.setCellValue(brf94a.getR29_amount_education_individual() == null ? 0
						: brf94a.getR29_amount_education_individual().intValue());
			}
			Cell R29cell49 = R29row.getCell(51);
			if (R29cell49 != null) {
				R29cell49.setCellValue(brf94a.getR29_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_medical_individual().intValue());
			}

			Cell R29cell50 = R29row.getCell(52);
			if (R29cell50 != null) {
				R29cell50.setCellValue(brf94a.getR29_amount_medical_individual() == null ? 0
						: brf94a.getR29_amount_medical_individual().intValue());
			}
			Cell R29cell51 = R29row.getCell(53);
			if (R29cell51 != null) {
				R29cell51.setCellValue(brf94a.getR29_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_tourism_individual().intValue());
			}
			Cell R29cell52 = R29row.getCell(54);
			if (R29cell52 != null) {
				R29cell52.setCellValue(brf94a.getR29_amount_tourism_individual() == null ? 0
						: brf94a.getR29_amount_tourism_individual().intValue());
			}
			Cell R29cell53 = R29row.getCell(55);
			if (R29cell53 != null) {
				R29cell53.setCellValue(brf94a.getR29_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R29cell54 = R29row.getCell(56);
			if (R29cell54 != null) {
				R29cell54.setCellValue(brf94a.getR29_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR29_amount_debt_settlement_individual().intValue());
			}
			Cell R29cell55 = R29row.getCell(57);
			if (R29cell55 != null) {
				R29cell55.setCellValue(brf94a.getR29_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR29_no_of_transactions_other_services_individual().intValue());
			}

			Cell R29cell56 = R29row.getCell(58);
			if (R29cell56 != null) {
				R29cell56.setCellValue(brf94a.getR29_amount_other_services_individual() == null ? 0
						: brf94a.getR29_amount_other_services_individual().intValue());
			}

			Row R30row = sheet.getRow(38);
			Cell R30cell1 = R30row.getCell(3);
			if (R30cell1 != null) {
				R30cell1.setCellValue(brf94a.getR30_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR30_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R30cell2 = R30row.getCell(4);
			if (R30cell2 != null) {
				R30cell2.setCellValue(brf94a.getR30_amount_financial_investment_government() == null ? 0
						: brf94a.getR30_amount_financial_investment_government().intValue());
			}
			Cell R30cell3 = R30row.getCell(5);
			if (R30cell3 != null) {
				R30cell3.setCellValue(brf94a.getR30_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR30_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R30cell4 = R30row.getCell(6);
			if (R30cell4 != null) {
				R30cell4.setCellValue(brf94a.getR30_amount_direct_investment_government() == null ? 0
						: brf94a.getR30_amount_direct_investment_government().intValue());
			}
			Cell R30cell5 = R30row.getCell(7);
			if (R30cell5 != null) {
				R30cell5.setCellValue(brf94a.getR30_no_of_transactions_services_government() == null ? 0
						: brf94a.getR30_no_of_transactions_services_government().intValue());
			}
			Cell R30cell6 = R30row.getCell(8);
			if (R30cell6 != null) {
				R30cell6.setCellValue(brf94a.getR30_amount_services_government() == null ? 0
						: brf94a.getR30_amount_services_government().intValue());
			}
			Cell R30cell7 = R30row.getCell(9);
			if (R30cell7 != null) {
				R30cell7.setCellValue(brf94a.getR30_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR30_no_of_transactions_trade_government().intValue());
			}
			Cell R30cell8 = R30row.getCell(10);
			if (R30cell8 != null) {
				R30cell8.setCellValue(brf94a.getR30_amount_trade_government() == null ? 0
						: brf94a.getR30_amount_trade_government().intValue());
			}
			Cell R30cell9 = R30row.getCell(11);
			if (R30cell9 != null) {
				R30cell9.setCellValue(brf94a.getR30_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR30_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R30cell10 = R30row.getCell(12);
			if (R30cell10 != null) {
				R30cell10.setCellValue(brf94a.getR30_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR30_amount_financial_investment_reserve().intValue());
			}
			Cell R30cell11 = R30row.getCell(13);
			if (R30cell11 != null) {
				R30cell11.setCellValue(brf94a.getR30_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR30_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R30cell12 = R30row.getCell(14);
			if (R30cell12 != null) {
				R30cell12.setCellValue(brf94a.getR30_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR30_amount_direct_investment_reserve().intValue());
			}
			Cell R30cell13 = R30row.getCell(15);
			if (R30cell13 != null) {
				R30cell13.setCellValue(brf94a.getR30_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR30_no_of_transactions_services_reserve().intValue());
			}
			Cell R30cell14 = R30row.getCell(16);
			if (R30cell14 != null) {
				R30cell14.setCellValue(brf94a.getR30_amount_services_reserve() == null ? 0
						: brf94a.getR30_amount_services_reserve().intValue());
			}
			Cell R30cell15 = R30row.getCell(17);
			if (R30cell15 != null) {
				R30cell15.setCellValue(brf94a.getR30_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR30_no_of_transactions_trade_reserve().intValue());
			}
			Cell R30cell16 = R30row.getCell(18);
			if (R30cell16 != null) {
				R30cell16.setCellValue(brf94a.getR30_amount_trade_reserve() == null ? 0
						: brf94a.getR30_amount_trade_reserve().intValue());
			}
			Cell R30cell17 = R30row.getCell(19);
			if (R30cell17 != null) {
				R30cell17.setCellValue(brf94a.getR30_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR30_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R30cell18 = R30row.getCell(20);
			if (R30cell18 != null) {
				R30cell18.setCellValue(brf94a.getR30_amount_financial_investment_gre() == null ? 0
						: brf94a.getR30_amount_financial_investment_gre().intValue());
			}
			Cell R30cell19 = R30row.getCell(21);
			if (R30cell19 != null) {
				R30cell19.setCellValue(brf94a.getR30_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR30_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R30cell20 = R30row.getCell(22);
			if (R30cell20 != null) {
				R30cell20.setCellValue(brf94a.getR30_amount_direct_investment_gre() == null ? 0
						: brf94a.getR30_amount_direct_investment_gre().intValue());
			}
			Cell R30cell21 = R30row.getCell(23);
			if (R30cell21 != null) {
				R30cell21.setCellValue(brf94a.getR30_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR30_no_of_transactions_services_gre().intValue());
			}
			Cell R30cell22 = R30row.getCell(24);
			if (R30cell22 != null) {
				R30cell22.setCellValue(brf94a.getR30_amount_services_gre() == null ? 0
						: brf94a.getR30_amount_services_gre().intValue());
			}
			Cell R30cell23 = R30row.getCell(25);
			if (R30cell23 != null) {
				R30cell23.setCellValue(brf94a.getR30_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR30_no_of_transactions_trade_gre().intValue());
			}
			Cell R30cell24 = R30row.getCell(26);
			if (R30cell24 != null) {
				R30cell24.setCellValue(
						brf94a.getR30_amount_trade_gre() == null ? 0 : brf94a.getR30_amount_trade_gre().intValue());
			}
			Cell R30cell25 = R30row.getCell(27);
			if (R30cell25 != null) {
				R30cell25.setCellValue(brf94a.getR30_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR30_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R30cell26 = R30row.getCell(28);
			if (R30cell26 != null) {
				R30cell26.setCellValue(brf94a.getR30_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR30_amount_financial_investment_corporate().intValue());
			}
			Cell R30cell27 = R30row.getCell(29);
			if (R30cell27 != null) {
				R30cell27.setCellValue(brf94a.getR30_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR30_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R30cell28 = R30row.getCell(30);
			if (R30cell28 != null) {
				R30cell28.setCellValue(brf94a.getR30_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR30_amount_direct_investment_corporate().intValue());
			}
			Cell R30cell29 = R30row.getCell(31);
			if (R30cell29 != null) {
				R30cell29.setCellValue(brf94a.getR30_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR30_no_of_transactions_services_corporate().intValue());
			}
			Cell R30cell30 = R30row.getCell(32);
			if (R30cell30 != null) {
				R30cell30.setCellValue(brf94a.getR30_amount_services_corporate() == null ? 0
						: brf94a.getR30_amount_services_corporate().intValue());
			}
			Cell R30cell31 = R30row.getCell(33);
			if (R30cell31 != null) {
				R30cell31.setCellValue(brf94a.getR30_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR30_no_of_transactions_trade_corporate().intValue());
			}
			Cell R30cell32 = R30row.getCell(34);
			if (R30cell32 != null) {
				R30cell32.setCellValue(brf94a.getR30_amount_trade_corporate() == null ? 0
						: brf94a.getR30_amount_trade_corporate().intValue());
			}
			Cell R30cell33 = R30row.getCell(35);
			if (R30cell33 != null) {
				R30cell33.setCellValue(brf94a.getR30_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR30_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R30cell34 = R30row.getCell(36);
			if (R30cell34 != null) {
				R30cell34.setCellValue(brf94a.getR30_amount_financial_investment_sme() == null ? 0
						: brf94a.getR30_amount_financial_investment_sme().intValue());
			}
			Cell R30cell35 = R30row.getCell(37);
			if (R30cell35 != null) {
				R30cell35.setCellValue(brf94a.getR30_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR30_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R30cell36 = R30row.getCell(38);
			if (R30cell36 != null) {
				R30cell36.setCellValue(brf94a.getR30_amount_direct_investment_sme() == null ? 0
						: brf94a.getR30_amount_direct_investment_sme().intValue());
			}
			Cell R30cell37 = R30row.getCell(39);
			if (R30cell37 != null) {
				R30cell37.setCellValue(brf94a.getR30_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR30_no_of_transactions_services_sme().intValue());
			}
			Cell R30cell38 = R30row.getCell(40);
			if (R30cell38 != null) {
				R30cell38.setCellValue(brf94a.getR30_amount_services_sme() == null ? 0
						: brf94a.getR30_amount_services_sme().intValue());
			}
			Cell R30cell39 = R30row.getCell(41);
			if (R30cell39 != null) {
				R30cell39.setCellValue(brf94a.getR30_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR30_no_of_transactions_trade_sme().intValue());
			}
			Cell R30cell40 = R30row.getCell(42);
			if (R30cell40 != null) {
				R30cell40.setCellValue(
						brf94a.getR30_amount_trade_sme() == null ? 0 : brf94a.getR30_amount_trade_sme().intValue());
			}
			Cell R30cell41 = R30row.getCell(43);
			if (R30cell41 != null) {
				R30cell41.setCellValue(brf94a.getR30_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R30cell42 = R30row.getCell(44);
			if (R30cell42 != null) {
				R30cell42.setCellValue(brf94a.getR30_amount_financial_investment_individual() == null ? 0
						: brf94a.getR30_amount_financial_investment_individual().intValue());
			}
			Cell R30cell43 = R30row.getCell(45);
			if (R30cell43 != null) {
				R30cell43.setCellValue(brf94a.getR30_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R30cell44 = R30row.getCell(46);
			if (R30cell44 != null) {
				R30cell44.setCellValue(brf94a.getR30_amount_direct_investment_individual() == null ? 0
						: brf94a.getR30_amount_direct_investment_individual().intValue());
			}
			Cell R30cell45 = R30row.getCell(47);
			if (R30cell45 != null) {
				R30cell45.setCellValue(brf94a.getR30_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_family_support_individual().intValue());
			}
			Cell R30cell46 = R30row.getCell(48);
			if (R30cell46 != null) {
				R30cell46.setCellValue(brf94a.getR30_amount_family_support_individual() == null ? 0
						: brf94a.getR30_amount_family_support_individual().intValue());
			}
			Cell R30cell47 = R30row.getCell(49);
			if (R30cell47 != null) {
				R30cell47.setCellValue(brf94a.getR30_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_education_individual().intValue());
			}
			Cell R30cell48 = R30row.getCell(50);
			if (R30cell48 != null) {
				R30cell48.setCellValue(brf94a.getR30_amount_education_individual() == null ? 0
						: brf94a.getR30_amount_education_individual().intValue());
			}
			Cell R30cell49 = R30row.getCell(51);
			if (R30cell49 != null) {
				R30cell49.setCellValue(brf94a.getR30_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_medical_individual().intValue());
			}

			Cell R30cell50 = R30row.getCell(52);
			if (R30cell50 != null) {
				R30cell50.setCellValue(brf94a.getR30_amount_medical_individual() == null ? 0
						: brf94a.getR30_amount_medical_individual().intValue());
			}
			Cell R30cell51 = R30row.getCell(53);
			if (R30cell51 != null) {
				R30cell51.setCellValue(brf94a.getR30_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_tourism_individual().intValue());
			}
			Cell R30cell52 = R30row.getCell(54);
			if (R30cell52 != null) {
				R30cell52.setCellValue(brf94a.getR30_amount_tourism_individual() == null ? 0
						: brf94a.getR30_amount_tourism_individual().intValue());
			}
			Cell R30cell53 = R30row.getCell(55);
			if (R30cell53 != null) {
				R30cell53.setCellValue(brf94a.getR30_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R30cell54 = R30row.getCell(56);
			if (R30cell54 != null) {
				R30cell54.setCellValue(brf94a.getR30_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR30_amount_debt_settlement_individual().intValue());
			}
			Cell R30cell55 = R30row.getCell(57);
			if (R30cell55 != null) {
				R30cell55.setCellValue(brf94a.getR30_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR30_no_of_transactions_other_services_individual().intValue());
			}

			Cell R30cell56 = R30row.getCell(58);
			if (R30cell56 != null) {
				R30cell56.setCellValue(brf94a.getR30_amount_other_services_individual() == null ? 0
						: brf94a.getR30_amount_other_services_individual().intValue());
			}

			Row R31row = sheet.getRow(39);
			Cell R31cell1 = R31row.getCell(3);
			if (R31cell1 != null) {
				R31cell1.setCellValue(brf94a.getR31_no_of_transactions_financial_investment_government() == null ? 0
						: brf94a.getR31_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R31cell2 = R31row.getCell(4);
			if (R31cell2 != null) {
				R31cell2.setCellValue(brf94a.getR31_amount_financial_investment_government() == null ? 0
						: brf94a.getR31_amount_financial_investment_government().intValue());
			}
			Cell R31cell3 = R31row.getCell(5);
			if (R31cell3 != null) {
				R31cell3.setCellValue(brf94a.getR31_no_of_transactions_direct_investment_government() == null ? 0
						: brf94a.getR31_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R31cell4 = R31row.getCell(6);
			if (R31cell4 != null) {
				R31cell4.setCellValue(brf94a.getR31_amount_direct_investment_government() == null ? 0
						: brf94a.getR31_amount_direct_investment_government().intValue());
			}
			Cell R31cell5 = R31row.getCell(7);
			if (R31cell5 != null) {
				R31cell5.setCellValue(brf94a.getR31_no_of_transactions_services_government() == null ? 0
						: brf94a.getR31_no_of_transactions_services_government().intValue());
			}
			Cell R31cell6 = R31row.getCell(8);
			if (R31cell6 != null) {
				R31cell6.setCellValue(brf94a.getR31_amount_services_government() == null ? 0
						: brf94a.getR31_amount_services_government().intValue());
			}
			Cell R31cell7 = R31row.getCell(9);
			if (R31cell7 != null) {
				R31cell7.setCellValue(brf94a.getR31_no_of_transactions_trade_government() == null ? 0
						: brf94a.getR31_no_of_transactions_trade_government().intValue());
			}
			Cell R31cell8 = R31row.getCell(10);
			if (R31cell8 != null) {
				R31cell8.setCellValue(brf94a.getR31_amount_trade_government() == null ? 0
						: brf94a.getR31_amount_trade_government().intValue());
			}
			Cell R31cell9 = R31row.getCell(11);
			if (R31cell9 != null) {
				R31cell9.setCellValue(brf94a.getR31_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94a.getR31_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R31cell10 = R31row.getCell(12);
			if (R31cell10 != null) {
				R31cell10.setCellValue(brf94a.getR31_amount_financial_investment_reserve() == null ? 0
						: brf94a.getR31_amount_financial_investment_reserve().intValue());
			}
			Cell R31cell11 = R31row.getCell(13);
			if (R31cell11 != null) {
				R31cell11.setCellValue(brf94a.getR31_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94a.getR31_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R31cell12 = R31row.getCell(14);
			if (R31cell12 != null) {
				R31cell12.setCellValue(brf94a.getR31_amount_direct_investment_reserve() == null ? 0
						: brf94a.getR31_amount_direct_investment_reserve().intValue());
			}
			Cell R31cell13 = R31row.getCell(15);
			if (R31cell13 != null) {
				R31cell13.setCellValue(brf94a.getR31_no_of_transactions_services_reserve() == null ? 0
						: brf94a.getR31_no_of_transactions_services_reserve().intValue());
			}
			Cell R31cell14 = R31row.getCell(16);
			if (R31cell14 != null) {
				R31cell14.setCellValue(brf94a.getR31_amount_services_reserve() == null ? 0
						: brf94a.getR31_amount_services_reserve().intValue());
			}
			Cell R31cell15 = R31row.getCell(17);
			if (R31cell15 != null) {
				R31cell15.setCellValue(brf94a.getR31_no_of_transactions_trade_reserve() == null ? 0
						: brf94a.getR31_no_of_transactions_trade_reserve().intValue());
			}
			Cell R31cell16 = R31row.getCell(18);
			if (R31cell16 != null) {
				R31cell16.setCellValue(brf94a.getR31_amount_trade_reserve() == null ? 0
						: brf94a.getR31_amount_trade_reserve().intValue());
			}
			Cell R31cell17 = R31row.getCell(19);
			if (R31cell17 != null) {
				R31cell17.setCellValue(brf94a.getR31_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94a.getR31_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R31cell18 = R31row.getCell(20);
			if (R31cell18 != null) {
				R31cell18.setCellValue(brf94a.getR31_amount_financial_investment_gre() == null ? 0
						: brf94a.getR31_amount_financial_investment_gre().intValue());
			}
			Cell R31cell19 = R31row.getCell(21);
			if (R31cell19 != null) {
				R31cell19.setCellValue(brf94a.getR31_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94a.getR31_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R31cell20 = R31row.getCell(22);
			if (R31cell20 != null) {
				R31cell20.setCellValue(brf94a.getR31_amount_direct_investment_gre() == null ? 0
						: brf94a.getR31_amount_direct_investment_gre().intValue());
			}
			Cell R31cell21 = R31row.getCell(23);
			if (R31cell21 != null) {
				R31cell21.setCellValue(brf94a.getR31_no_of_transactions_services_gre() == null ? 0
						: brf94a.getR31_no_of_transactions_services_gre().intValue());
			}
			Cell R31cell22 = R31row.getCell(24);
			if (R31cell22 != null) {
				R31cell22.setCellValue(brf94a.getR31_amount_services_gre() == null ? 0
						: brf94a.getR31_amount_services_gre().intValue());
			}
			Cell R31cell23 = R31row.getCell(25);
			if (R31cell23 != null) {
				R31cell23.setCellValue(brf94a.getR31_no_of_transactions_trade_gre() == null ? 0
						: brf94a.getR31_no_of_transactions_trade_gre().intValue());
			}
			Cell R31cell24 = R31row.getCell(26);
			if (R31cell24 != null) {
				R31cell24.setCellValue(
						brf94a.getR31_amount_trade_gre() == null ? 0 : brf94a.getR31_amount_trade_gre().intValue());
			}
			Cell R31cell25 = R31row.getCell(27);
			if (R31cell25 != null) {
				R31cell25.setCellValue(brf94a.getR31_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94a.getR31_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R31cell26 = R31row.getCell(28);
			if (R31cell26 != null) {
				R31cell26.setCellValue(brf94a.getR31_amount_financial_investment_corporate() == null ? 0
						: brf94a.getR31_amount_financial_investment_corporate().intValue());
			}
			Cell R31cell27 = R31row.getCell(29);
			if (R31cell27 != null) {
				R31cell27.setCellValue(brf94a.getR31_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94a.getR31_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R31cell28 = R31row.getCell(30);
			if (R31cell28 != null) {
				R31cell28.setCellValue(brf94a.getR31_amount_direct_investment_corporate() == null ? 0
						: brf94a.getR31_amount_direct_investment_corporate().intValue());
			}
			Cell R31cell29 = R31row.getCell(31);
			if (R31cell29 != null) {
				R31cell29.setCellValue(brf94a.getR31_no_of_transactions_services_corporate() == null ? 0
						: brf94a.getR31_no_of_transactions_services_corporate().intValue());
			}
			Cell R31cell30 = R31row.getCell(32);
			if (R31cell30 != null) {
				R31cell30.setCellValue(brf94a.getR31_amount_services_corporate() == null ? 0
						: brf94a.getR31_amount_services_corporate().intValue());
			}
			Cell R31cell31 = R31row.getCell(33);
			if (R31cell31 != null) {
				R31cell31.setCellValue(brf94a.getR31_no_of_transactions_trade_corporate() == null ? 0
						: brf94a.getR31_no_of_transactions_trade_corporate().intValue());
			}
			Cell R31cell32 = R31row.getCell(34);
			if (R31cell32 != null) {
				R31cell32.setCellValue(brf94a.getR31_amount_trade_corporate() == null ? 0
						: brf94a.getR31_amount_trade_corporate().intValue());
			}
			Cell R31cell33 = R31row.getCell(35);
			if (R31cell33 != null) {
				R31cell33.setCellValue(brf94a.getR31_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94a.getR31_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R31cell34 = R31row.getCell(36);
			if (R31cell34 != null) {
				R31cell34.setCellValue(brf94a.getR31_amount_financial_investment_sme() == null ? 0
						: brf94a.getR31_amount_financial_investment_sme().intValue());
			}
			Cell R31cell35 = R31row.getCell(37);
			if (R31cell35 != null) {
				R31cell35.setCellValue(brf94a.getR31_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94a.getR31_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R31cell36 = R31row.getCell(38);
			if (R31cell36 != null) {
				R31cell36.setCellValue(brf94a.getR31_amount_direct_investment_sme() == null ? 0
						: brf94a.getR31_amount_direct_investment_sme().intValue());
			}
			Cell R31cell37 = R31row.getCell(39);
			if (R31cell37 != null) {
				R31cell37.setCellValue(brf94a.getR31_no_of_transactions_services_sme() == null ? 0
						: brf94a.getR31_no_of_transactions_services_sme().intValue());
			}
			Cell R31cell38 = R31row.getCell(40);
			if (R31cell38 != null) {
				R31cell38.setCellValue(brf94a.getR31_amount_services_sme() == null ? 0
						: brf94a.getR31_amount_services_sme().intValue());
			}
			Cell R31cell39 = R31row.getCell(41);
			if (R31cell39 != null) {
				R31cell39.setCellValue(brf94a.getR31_no_of_transactions_trade_sme() == null ? 0
						: brf94a.getR31_no_of_transactions_trade_sme().intValue());
			}
			Cell R31cell40 = R31row.getCell(42);
			if (R31cell40 != null) {
				R31cell40.setCellValue(
						brf94a.getR31_amount_trade_sme() == null ? 0 : brf94a.getR31_amount_trade_sme().intValue());
			}
			Cell R31cell41 = R31row.getCell(43);
			if (R31cell41 != null) {
				R31cell41.setCellValue(brf94a.getR31_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R31cell42 = R31row.getCell(44);
			if (R31cell42 != null) {
				R31cell42.setCellValue(brf94a.getR31_amount_financial_investment_individual() == null ? 0
						: brf94a.getR31_amount_financial_investment_individual().intValue());
			}
			Cell R31cell43 = R31row.getCell(45);
			if (R31cell43 != null) {
				R31cell43.setCellValue(brf94a.getR31_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R31cell44 = R31row.getCell(46);
			if (R31cell44 != null) {
				R31cell44.setCellValue(brf94a.getR31_amount_direct_investment_individual() == null ? 0
						: brf94a.getR31_amount_direct_investment_individual().intValue());
			}
			Cell R31cell45 = R31row.getCell(47);
			if (R31cell45 != null) {
				R31cell45.setCellValue(brf94a.getR31_no_of_transactions_family_support_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_family_support_individual().intValue());
			}
			Cell R31cell46 = R31row.getCell(48);
			if (R31cell46 != null) {
				R31cell46.setCellValue(brf94a.getR31_amount_family_support_individual() == null ? 0
						: brf94a.getR31_amount_family_support_individual().intValue());
			}
			Cell R31cell47 = R31row.getCell(49);
			if (R31cell47 != null) {
				R31cell47.setCellValue(brf94a.getR31_no_of_transactions_education_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_education_individual().intValue());
			}
			Cell R31cell48 = R31row.getCell(50);
			if (R31cell48 != null) {
				R31cell48.setCellValue(brf94a.getR31_amount_education_individual() == null ? 0
						: brf94a.getR31_amount_education_individual().intValue());
			}
			Cell R31cell49 = R31row.getCell(51);
			if (R31cell49 != null) {
				R31cell49.setCellValue(brf94a.getR31_no_of_transactions_medical_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_medical_individual().intValue());
			}

			Cell R31cell50 = R31row.getCell(52);
			if (R31cell50 != null) {
				R31cell50.setCellValue(brf94a.getR31_amount_medical_individual() == null ? 0
						: brf94a.getR31_amount_medical_individual().intValue());
			}
			Cell R31cell51 = R31row.getCell(53);
			if (R31cell51 != null) {
				R31cell51.setCellValue(brf94a.getR31_no_of_transactions_tourism_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_tourism_individual().intValue());
			}
			Cell R31cell52 = R31row.getCell(54);
			if (R31cell52 != null) {
				R31cell52.setCellValue(brf94a.getR31_amount_tourism_individual() == null ? 0
						: brf94a.getR31_amount_tourism_individual().intValue());
			}
			Cell R31cell53 = R31row.getCell(55);
			if (R31cell53 != null) {
				R31cell53.setCellValue(brf94a.getR31_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R31cell54 = R31row.getCell(56);
			if (R31cell54 != null) {
				R31cell54.setCellValue(brf94a.getR31_amount_debt_settlement_individual() == null ? 0
						: brf94a.getR31_amount_debt_settlement_individual().intValue());
			}
			Cell R31cell55 = R31row.getCell(57);
			if (R31cell55 != null) {
				R31cell55.setCellValue(brf94a.getR31_no_of_transactions_other_services_individual() == null ? 0
						: brf94a.getR31_no_of_transactions_other_services_individual().intValue());
			}

			Cell R31cell56 = R31row.getCell(58);
			if (R31cell56 != null) {
				R31cell56.setCellValue(brf94a.getR31_amount_other_services_individual() == null ? 0
						: brf94a.getR31_amount_other_services_individual().intValue());
			}

		}
	}

	public void updateSheetWithEntity3Data(Sheet sheet, List<BRF094_SUMMARYENTITY3> BRF094_SUMMARYENTITY3) {
		if (BRF094_SUMMARYENTITY3.size() == 1) {
			BRF094_SUMMARYENTITY3 brf94b = BRF094_SUMMARYENTITY3.get(0);
			Row R33row = sheet.getRow(41);
			Cell R33cell1 = R33row.getCell(3);
			if (R33cell1 != null) {
				R33cell1.setCellValue(brf94b.getR33_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR33_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R33cell2 = R33row.getCell(4);
			if (R33cell2 != null) {
				R33cell2.setCellValue(brf94b.getR33_amount_financial_investment_government() == null ? 0
						: brf94b.getR33_amount_financial_investment_government().intValue());
			}
			Cell R33cell3 = R33row.getCell(5);
			if (R33cell3 != null) {
				R33cell3.setCellValue(brf94b.getR33_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR33_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R33cell4 = R33row.getCell(6);
			if (R33cell4 != null) {
				R33cell4.setCellValue(brf94b.getR33_amount_direct_investment_government() == null ? 0
						: brf94b.getR33_amount_direct_investment_government().intValue());
			}
			Cell R33cell5 = R33row.getCell(7);
			if (R33cell5 != null) {
				R33cell5.setCellValue(brf94b.getR33_no_of_transactions_services_government() == null ? 0
						: brf94b.getR33_no_of_transactions_services_government().intValue());
			}
			Cell R33cell6 = R33row.getCell(8);
			if (R33cell6 != null) {
				R33cell6.setCellValue(brf94b.getR33_amount_services_government() == null ? 0
						: brf94b.getR33_amount_services_government().intValue());
			}
			Cell R33cell7 = R33row.getCell(9);
			if (R33cell7 != null) {
				R33cell7.setCellValue(brf94b.getR33_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR33_no_of_transactions_trade_government().intValue());
			}
			Cell R33cell8 = R33row.getCell(10);
			if (R33cell8 != null) {
				R33cell8.setCellValue(brf94b.getR33_amount_trade_government() == null ? 0
						: brf94b.getR33_amount_trade_government().intValue());
			}
			Cell R33cell9 = R33row.getCell(11);
			if (R33cell9 != null) {
				R33cell9.setCellValue(brf94b.getR33_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR33_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R33cell10 = R33row.getCell(12);
			if (R33cell10 != null) {
				R33cell10.setCellValue(brf94b.getR33_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR33_amount_financial_investment_reserve().intValue());
			}
			Cell R33cell11 = R33row.getCell(13);
			if (R33cell11 != null) {
				R33cell11.setCellValue(brf94b.getR33_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR33_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R33cell12 = R33row.getCell(14);
			if (R33cell12 != null) {
				R33cell12.setCellValue(brf94b.getR33_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR33_amount_direct_investment_reserve().intValue());
			}
			Cell R33cell13 = R33row.getCell(15);
			if (R33cell13 != null) {
				R33cell13.setCellValue(brf94b.getR33_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR33_no_of_transactions_services_reserve().intValue());
			}
			Cell R33cell14 = R33row.getCell(16);
			if (R33cell14 != null) {
				R33cell14.setCellValue(brf94b.getR33_amount_services_reserve() == null ? 0
						: brf94b.getR33_amount_services_reserve().intValue());
			}
			Cell R33cell15 = R33row.getCell(17);
			if (R33cell15 != null) {
				R33cell15.setCellValue(brf94b.getR33_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR33_no_of_transactions_trade_reserve().intValue());
			}
			Cell R33cell16 = R33row.getCell(18);
			if (R33cell16 != null) {
				R33cell16.setCellValue(brf94b.getR33_amount_trade_reserve() == null ? 0
						: brf94b.getR33_amount_trade_reserve().intValue());
			}
			Cell R33cell17 = R33row.getCell(19);
			if (R33cell17 != null) {
				R33cell17.setCellValue(brf94b.getR33_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR33_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R33cell18 = R33row.getCell(20);
			if (R33cell18 != null) {
				R33cell18.setCellValue(brf94b.getR33_amount_financial_investment_gre() == null ? 0
						: brf94b.getR33_amount_financial_investment_gre().intValue());
			}
			Cell R33cell19 = R33row.getCell(21);
			if (R33cell19 != null) {
				R33cell19.setCellValue(brf94b.getR33_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR33_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R33cell20 = R33row.getCell(22);
			if (R33cell20 != null) {
				R33cell20.setCellValue(brf94b.getR33_amount_direct_investment_gre() == null ? 0
						: brf94b.getR33_amount_direct_investment_gre().intValue());
			}
			Cell R33cell21 = R33row.getCell(23);
			if (R33cell21 != null) {
				R33cell21.setCellValue(brf94b.getR33_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR33_no_of_transactions_services_gre().intValue());
			}
			Cell R33cell22 = R33row.getCell(24);
			if (R33cell22 != null) {
				R33cell22.setCellValue(brf94b.getR33_amount_services_gre() == null ? 0
						: brf94b.getR33_amount_services_gre().intValue());
			}
			Cell R33cell23 = R33row.getCell(25);
			if (R33cell23 != null) {
				R33cell23.setCellValue(brf94b.getR33_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR33_no_of_transactions_trade_gre().intValue());
			}
			Cell R33cell24 = R33row.getCell(26);
			if (R33cell24 != null) {
				R33cell24.setCellValue(
						brf94b.getR33_amount_trade_gre() == null ? 0 : brf94b.getR33_amount_trade_gre().intValue());
			}
			Cell R33cell25 = R33row.getCell(27);
			if (R33cell25 != null) {
				R33cell25.setCellValue(brf94b.getR33_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR33_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R33cell26 = R33row.getCell(28);
			if (R33cell26 != null) {
				R33cell26.setCellValue(brf94b.getR33_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR33_amount_financial_investment_corporate().intValue());
			}
			Cell R33cell27 = R33row.getCell(29);
			if (R33cell27 != null) {
				R33cell27.setCellValue(brf94b.getR33_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR33_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R33cell28 = R33row.getCell(30);
			if (R33cell28 != null) {
				R33cell28.setCellValue(brf94b.getR33_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR33_amount_direct_investment_corporate().intValue());
			}
			Cell R33cell29 = R33row.getCell(31);
			if (R33cell29 != null) {
				R33cell29.setCellValue(brf94b.getR33_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR33_no_of_transactions_services_corporate().intValue());
			}
			Cell R33cell30 = R33row.getCell(32);
			if (R33cell30 != null) {
				R33cell30.setCellValue(brf94b.getR33_amount_services_corporate() == null ? 0
						: brf94b.getR33_amount_services_corporate().intValue());
			}
			Cell R33cell31 = R33row.getCell(33);
			if (R33cell31 != null) {
				R33cell31.setCellValue(brf94b.getR33_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR33_no_of_transactions_trade_corporate().intValue());
			}
			Cell R33cell32 = R33row.getCell(34);
			if (R33cell32 != null) {
				R33cell32.setCellValue(brf94b.getR33_amount_trade_corporate() == null ? 0
						: brf94b.getR33_amount_trade_corporate().intValue());
			}
			Cell R33cell33 = R33row.getCell(35);
			if (R33cell33 != null) {
				R33cell33.setCellValue(brf94b.getR33_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR33_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R33cell34 = R33row.getCell(36);
			if (R33cell34 != null) {
				R33cell34.setCellValue(brf94b.getR33_amount_financial_investment_sme() == null ? 0
						: brf94b.getR33_amount_financial_investment_sme().intValue());
			}
			Cell R33cell35 = R33row.getCell(37);
			if (R33cell35 != null) {
				R33cell35.setCellValue(brf94b.getR33_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR33_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R33cell36 = R33row.getCell(38);
			if (R33cell36 != null) {
				R33cell36.setCellValue(brf94b.getR33_amount_direct_investment_sme() == null ? 0
						: brf94b.getR33_amount_direct_investment_sme().intValue());
			}
			Cell R33cell37 = R33row.getCell(39);
			if (R33cell37 != null) {
				R33cell37.setCellValue(brf94b.getR33_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR33_no_of_transactions_services_sme().intValue());
			}
			Cell R33cell38 = R33row.getCell(40);
			if (R33cell38 != null) {
				R33cell38.setCellValue(brf94b.getR33_amount_services_sme() == null ? 0
						: brf94b.getR33_amount_services_sme().intValue());
			}
			Cell R33cell39 = R33row.getCell(41);
			if (R33cell39 != null) {
				R33cell39.setCellValue(brf94b.getR33_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR33_no_of_transactions_trade_sme().intValue());
			}
			Cell R33cell40 = R33row.getCell(42);
			if (R33cell40 != null) {
				R33cell40.setCellValue(
						brf94b.getR33_amount_trade_sme() == null ? 0 : brf94b.getR33_amount_trade_sme().intValue());
			}
			Cell R33cell41 = R33row.getCell(43);
			if (R33cell41 != null) {
				R33cell41.setCellValue(brf94b.getR33_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R33cell42 = R33row.getCell(44);
			if (R33cell42 != null) {
				R33cell42.setCellValue(brf94b.getR33_amount_financial_investment_individual() == null ? 0
						: brf94b.getR33_amount_financial_investment_individual().intValue());
			}
			Cell R33cell43 = R33row.getCell(45);
			if (R33cell43 != null) {
				R33cell43.setCellValue(brf94b.getR33_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R33cell44 = R33row.getCell(46);
			if (R33cell44 != null) {
				R33cell44.setCellValue(brf94b.getR33_amount_direct_investment_individual() == null ? 0
						: brf94b.getR33_amount_direct_investment_individual().intValue());
			}
			Cell R33cell45 = R33row.getCell(47);
			if (R33cell45 != null) {
				R33cell45.setCellValue(brf94b.getR33_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_family_support_individual().intValue());
			}
			Cell R33cell46 = R33row.getCell(48);
			if (R33cell46 != null) {
				R33cell46.setCellValue(brf94b.getR33_amount_family_support_individual() == null ? 0
						: brf94b.getR33_amount_family_support_individual().intValue());
			}
			Cell R33cell47 = R33row.getCell(49);
			if (R33cell47 != null) {
				R33cell47.setCellValue(brf94b.getR33_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_education_individual().intValue());
			}
			Cell R33cell48 = R33row.getCell(50);
			if (R33cell48 != null) {
				R33cell48.setCellValue(brf94b.getR33_amount_education_individual() == null ? 0
						: brf94b.getR33_amount_education_individual().intValue());
			}
			Cell R33cell49 = R33row.getCell(51);
			if (R33cell49 != null) {
				R33cell49.setCellValue(brf94b.getR33_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_medical_individual().intValue());
			}

			Cell R33cell50 = R33row.getCell(52);
			if (R33cell50 != null) {
				R33cell50.setCellValue(brf94b.getR33_amount_medical_individual() == null ? 0
						: brf94b.getR33_amount_medical_individual().intValue());
			}
			Cell R33cell51 = R33row.getCell(53);
			if (R33cell51 != null) {
				R33cell51.setCellValue(brf94b.getR33_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_tourism_individual().intValue());
			}
			Cell R33cell52 = R33row.getCell(54);
			if (R33cell52 != null) {
				R33cell52.setCellValue(brf94b.getR33_amount_tourism_individual() == null ? 0
						: brf94b.getR33_amount_tourism_individual().intValue());
			}
			Cell R33cell53 = R33row.getCell(55);
			if (R33cell53 != null) {
				R33cell53.setCellValue(brf94b.getR33_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R33cell54 = R33row.getCell(56);
			if (R33cell54 != null) {
				R33cell54.setCellValue(brf94b.getR33_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR33_amount_debt_settlement_individual().intValue());
			}
			Cell R33cell55 = R33row.getCell(57);
			if (R33cell55 != null) {
				R33cell55.setCellValue(brf94b.getR33_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR33_no_of_transactions_other_services_individual().intValue());
			}

			Cell R33cell56 = R33row.getCell(58);
			if (R33cell56 != null) {
				R33cell56.setCellValue(brf94b.getR33_amount_other_services_individual() == null ? 0
						: brf94b.getR33_amount_other_services_individual().intValue());
			}

			Row R34row = sheet.getRow(42);
			Cell R34cell1 = R34row.getCell(3);
			if (R34cell1 != null) {
				R34cell1.setCellValue(brf94b.getR34_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR34_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R34cell2 = R34row.getCell(4);
			if (R34cell2 != null) {
				R34cell2.setCellValue(brf94b.getR34_amount_financial_investment_government() == null ? 0
						: brf94b.getR34_amount_financial_investment_government().intValue());
			}
			Cell R34cell3 = R34row.getCell(5);
			if (R34cell3 != null) {
				R34cell3.setCellValue(brf94b.getR34_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR34_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R34cell4 = R34row.getCell(6);
			if (R34cell4 != null) {
				R34cell4.setCellValue(brf94b.getR34_amount_direct_investment_government() == null ? 0
						: brf94b.getR34_amount_direct_investment_government().intValue());
			}
			Cell R34cell5 = R34row.getCell(7);
			if (R34cell5 != null) {
				R34cell5.setCellValue(brf94b.getR34_no_of_transactions_services_government() == null ? 0
						: brf94b.getR34_no_of_transactions_services_government().intValue());
			}
			Cell R34cell6 = R34row.getCell(8);
			if (R34cell6 != null) {
				R34cell6.setCellValue(brf94b.getR34_amount_services_government() == null ? 0
						: brf94b.getR34_amount_services_government().intValue());
			}
			Cell R34cell7 = R34row.getCell(9);
			if (R34cell7 != null) {
				R34cell7.setCellValue(brf94b.getR34_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR34_no_of_transactions_trade_government().intValue());
			}
			Cell R34cell8 = R34row.getCell(10);
			if (R34cell8 != null) {
				R34cell8.setCellValue(brf94b.getR34_amount_trade_government() == null ? 0
						: brf94b.getR34_amount_trade_government().intValue());
			}
			Cell R34cell9 = R34row.getCell(11);
			if (R34cell9 != null) {
				R34cell9.setCellValue(brf94b.getR34_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR34_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R34cell10 = R34row.getCell(12);
			if (R34cell10 != null) {
				R34cell10.setCellValue(brf94b.getR34_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR34_amount_financial_investment_reserve().intValue());
			}
			Cell R34cell11 = R34row.getCell(13);
			if (R34cell11 != null) {
				R34cell11.setCellValue(brf94b.getR34_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR34_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R34cell12 = R34row.getCell(14);
			if (R34cell12 != null) {
				R34cell12.setCellValue(brf94b.getR34_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR34_amount_direct_investment_reserve().intValue());
			}
			Cell R34cell13 = R34row.getCell(15);
			if (R34cell13 != null) {
				R34cell13.setCellValue(brf94b.getR34_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR34_no_of_transactions_services_reserve().intValue());
			}
			Cell R34cell14 = R34row.getCell(16);
			if (R34cell14 != null) {
				R34cell14.setCellValue(brf94b.getR34_amount_services_reserve() == null ? 0
						: brf94b.getR34_amount_services_reserve().intValue());
			}
			Cell R34cell15 = R34row.getCell(17);
			if (R34cell15 != null) {
				R34cell15.setCellValue(brf94b.getR34_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR34_no_of_transactions_trade_reserve().intValue());
			}
			Cell R34cell16 = R34row.getCell(18);
			if (R34cell16 != null) {
				R34cell16.setCellValue(brf94b.getR34_amount_trade_reserve() == null ? 0
						: brf94b.getR34_amount_trade_reserve().intValue());
			}
			Cell R34cell17 = R34row.getCell(19);
			if (R34cell17 != null) {
				R34cell17.setCellValue(brf94b.getR34_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR34_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R34cell18 = R34row.getCell(20);
			if (R34cell18 != null) {
				R34cell18.setCellValue(brf94b.getR34_amount_financial_investment_gre() == null ? 0
						: brf94b.getR34_amount_financial_investment_gre().intValue());
			}
			Cell R34cell19 = R34row.getCell(21);
			if (R34cell19 != null) {
				R34cell19.setCellValue(brf94b.getR34_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR34_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R34cell20 = R34row.getCell(22);
			if (R34cell20 != null) {
				R34cell20.setCellValue(brf94b.getR34_amount_direct_investment_gre() == null ? 0
						: brf94b.getR34_amount_direct_investment_gre().intValue());
			}
			Cell R34cell21 = R34row.getCell(23);
			if (R34cell21 != null) {
				R34cell21.setCellValue(brf94b.getR34_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR34_no_of_transactions_services_gre().intValue());
			}
			Cell R34cell22 = R34row.getCell(24);
			if (R34cell22 != null) {
				R34cell22.setCellValue(brf94b.getR34_amount_services_gre() == null ? 0
						: brf94b.getR34_amount_services_gre().intValue());
			}
			Cell R34cell23 = R34row.getCell(25);
			if (R34cell23 != null) {
				R34cell23.setCellValue(brf94b.getR34_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR34_no_of_transactions_trade_gre().intValue());
			}
			Cell R34cell24 = R34row.getCell(26);
			if (R34cell24 != null) {
				R34cell24.setCellValue(
						brf94b.getR34_amount_trade_gre() == null ? 0 : brf94b.getR34_amount_trade_gre().intValue());
			}
			Cell R34cell25 = R34row.getCell(27);
			if (R34cell25 != null) {
				R34cell25.setCellValue(brf94b.getR34_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR34_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R34cell26 = R34row.getCell(28);
			if (R34cell26 != null) {
				R34cell26.setCellValue(brf94b.getR34_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR34_amount_financial_investment_corporate().intValue());
			}
			Cell R34cell27 = R34row.getCell(29);
			if (R34cell27 != null) {
				R34cell27.setCellValue(brf94b.getR34_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR34_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R34cell28 = R34row.getCell(30);
			if (R34cell28 != null) {
				R34cell28.setCellValue(brf94b.getR34_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR34_amount_direct_investment_corporate().intValue());
			}
			Cell R34cell29 = R34row.getCell(31);
			if (R34cell29 != null) {
				R34cell29.setCellValue(brf94b.getR34_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR34_no_of_transactions_services_corporate().intValue());
			}
			Cell R34cell30 = R34row.getCell(32);
			if (R34cell30 != null) {
				R34cell30.setCellValue(brf94b.getR34_amount_services_corporate() == null ? 0
						: brf94b.getR34_amount_services_corporate().intValue());
			}
			Cell R34cell31 = R34row.getCell(33);
			if (R34cell31 != null) {
				R34cell31.setCellValue(brf94b.getR34_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR34_no_of_transactions_trade_corporate().intValue());
			}
			Cell R34cell32 = R34row.getCell(34);
			if (R34cell32 != null) {
				R34cell32.setCellValue(brf94b.getR34_amount_trade_corporate() == null ? 0
						: brf94b.getR34_amount_trade_corporate().intValue());
			}
			Cell R34cell33 = R34row.getCell(35);
			if (R34cell33 != null) {
				R34cell33.setCellValue(brf94b.getR34_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR34_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R34cell34 = R34row.getCell(36);
			if (R34cell34 != null) {
				R34cell34.setCellValue(brf94b.getR34_amount_financial_investment_sme() == null ? 0
						: brf94b.getR34_amount_financial_investment_sme().intValue());
			}
			Cell R34cell35 = R34row.getCell(37);
			if (R34cell35 != null) {
				R34cell35.setCellValue(brf94b.getR34_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR34_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R34cell36 = R34row.getCell(38);
			if (R34cell36 != null) {
				R34cell36.setCellValue(brf94b.getR34_amount_direct_investment_sme() == null ? 0
						: brf94b.getR34_amount_direct_investment_sme().intValue());
			}
			Cell R34cell37 = R34row.getCell(39);
			if (R34cell37 != null) {
				R34cell37.setCellValue(brf94b.getR34_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR34_no_of_transactions_services_sme().intValue());
			}
			Cell R34cell38 = R34row.getCell(40);
			if (R34cell38 != null) {
				R34cell38.setCellValue(brf94b.getR34_amount_services_sme() == null ? 0
						: brf94b.getR34_amount_services_sme().intValue());
			}
			Cell R34cell39 = R34row.getCell(41);
			if (R34cell39 != null) {
				R34cell39.setCellValue(brf94b.getR34_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR34_no_of_transactions_trade_sme().intValue());
			}
			Cell R34cell40 = R34row.getCell(42);
			if (R34cell40 != null) {
				R34cell40.setCellValue(
						brf94b.getR34_amount_trade_sme() == null ? 0 : brf94b.getR34_amount_trade_sme().intValue());
			}
			Cell R34cell41 = R34row.getCell(43);
			if (R34cell41 != null) {
				R34cell41.setCellValue(brf94b.getR34_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R34cell42 = R34row.getCell(44);
			if (R34cell42 != null) {
				R34cell42.setCellValue(brf94b.getR34_amount_financial_investment_individual() == null ? 0
						: brf94b.getR34_amount_financial_investment_individual().intValue());
			}
			Cell R34cell43 = R34row.getCell(45);
			if (R34cell43 != null) {
				R34cell43.setCellValue(brf94b.getR34_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R34cell44 = R34row.getCell(46);
			if (R34cell44 != null) {
				R34cell44.setCellValue(brf94b.getR34_amount_direct_investment_individual() == null ? 0
						: brf94b.getR34_amount_direct_investment_individual().intValue());
			}
			Cell R34cell45 = R34row.getCell(47);
			if (R34cell45 != null) {
				R34cell45.setCellValue(brf94b.getR34_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_family_support_individual().intValue());
			}
			Cell R34cell46 = R34row.getCell(48);
			if (R34cell46 != null) {
				R34cell46.setCellValue(brf94b.getR34_amount_family_support_individual() == null ? 0
						: brf94b.getR34_amount_family_support_individual().intValue());
			}
			Cell R34cell47 = R34row.getCell(49);
			if (R34cell47 != null) {
				R34cell47.setCellValue(brf94b.getR34_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_education_individual().intValue());
			}
			Cell R34cell48 = R34row.getCell(50);
			if (R34cell48 != null) {
				R34cell48.setCellValue(brf94b.getR34_amount_education_individual() == null ? 0
						: brf94b.getR34_amount_education_individual().intValue());
			}
			Cell R34cell49 = R34row.getCell(51);
			if (R34cell49 != null) {
				R34cell49.setCellValue(brf94b.getR34_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_medical_individual().intValue());
			}

			Cell R34cell50 = R34row.getCell(52);
			if (R34cell50 != null) {
				R34cell50.setCellValue(brf94b.getR34_amount_medical_individual() == null ? 0
						: brf94b.getR34_amount_medical_individual().intValue());
			}
			Cell R34cell51 = R34row.getCell(53);
			if (R34cell51 != null) {
				R34cell51.setCellValue(brf94b.getR34_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_tourism_individual().intValue());
			}
			Cell R34cell52 = R34row.getCell(54);
			if (R34cell52 != null) {
				R34cell52.setCellValue(brf94b.getR34_amount_tourism_individual() == null ? 0
						: brf94b.getR34_amount_tourism_individual().intValue());
			}
			Cell R34cell53 = R34row.getCell(55);
			if (R34cell53 != null) {
				R34cell53.setCellValue(brf94b.getR34_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R34cell54 = R34row.getCell(56);
			if (R34cell54 != null) {
				R34cell54.setCellValue(brf94b.getR34_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR34_amount_debt_settlement_individual().intValue());
			}
			Cell R34cell55 = R34row.getCell(57);
			if (R34cell55 != null) {
				R34cell55.setCellValue(brf94b.getR34_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR34_no_of_transactions_other_services_individual().intValue());
			}

			Cell R34cell56 = R34row.getCell(58);
			if (R34cell56 != null) {
				R34cell56.setCellValue(brf94b.getR34_amount_other_services_individual() == null ? 0
						: brf94b.getR34_amount_other_services_individual().intValue());
			}

			Row R35row = sheet.getRow(43);
			Cell R35cell1 = R35row.getCell(3);
			if (R35cell1 != null) {
				R35cell1.setCellValue(brf94b.getR35_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR35_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R35cell2 = R35row.getCell(4);
			if (R35cell2 != null) {
				R35cell2.setCellValue(brf94b.getR35_amount_financial_investment_government() == null ? 0
						: brf94b.getR35_amount_financial_investment_government().intValue());
			}
			Cell R35cell3 = R35row.getCell(5);
			if (R35cell3 != null) {
				R35cell3.setCellValue(brf94b.getR35_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR35_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R35cell4 = R35row.getCell(6);
			if (R35cell4 != null) {
				R35cell4.setCellValue(brf94b.getR35_amount_direct_investment_government() == null ? 0
						: brf94b.getR35_amount_direct_investment_government().intValue());
			}
			Cell R35cell5 = R35row.getCell(7);
			if (R35cell5 != null) {
				R35cell5.setCellValue(brf94b.getR35_no_of_transactions_services_government() == null ? 0
						: brf94b.getR35_no_of_transactions_services_government().intValue());
			}
			Cell R35cell6 = R35row.getCell(8);
			if (R35cell6 != null) {
				R35cell6.setCellValue(brf94b.getR35_amount_services_government() == null ? 0
						: brf94b.getR35_amount_services_government().intValue());
			}
			Cell R35cell7 = R35row.getCell(9);
			if (R35cell7 != null) {
				R35cell7.setCellValue(brf94b.getR35_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR35_no_of_transactions_trade_government().intValue());
			}
			Cell R35cell8 = R35row.getCell(10);
			if (R35cell8 != null) {
				R35cell8.setCellValue(brf94b.getR35_amount_trade_government() == null ? 0
						: brf94b.getR35_amount_trade_government().intValue());
			}
			Cell R35cell9 = R35row.getCell(11);
			if (R35cell9 != null) {
				R35cell9.setCellValue(brf94b.getR35_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR35_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R35cell10 = R35row.getCell(12);
			if (R35cell10 != null) {
				R35cell10.setCellValue(brf94b.getR35_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR35_amount_financial_investment_reserve().intValue());
			}
			Cell R35cell11 = R35row.getCell(13);
			if (R35cell11 != null) {
				R35cell11.setCellValue(brf94b.getR35_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR35_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R35cell12 = R35row.getCell(14);
			if (R35cell12 != null) {
				R35cell12.setCellValue(brf94b.getR35_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR35_amount_direct_investment_reserve().intValue());
			}
			Cell R35cell13 = R35row.getCell(15);
			if (R35cell13 != null) {
				R35cell13.setCellValue(brf94b.getR35_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR35_no_of_transactions_services_reserve().intValue());
			}
			Cell R35cell14 = R35row.getCell(16);
			if (R35cell14 != null) {
				R35cell14.setCellValue(brf94b.getR35_amount_services_reserve() == null ? 0
						: brf94b.getR35_amount_services_reserve().intValue());
			}
			Cell R35cell15 = R35row.getCell(17);
			if (R35cell15 != null) {
				R35cell15.setCellValue(brf94b.getR35_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR35_no_of_transactions_trade_reserve().intValue());
			}
			Cell R35cell16 = R35row.getCell(18);
			if (R35cell16 != null) {
				R35cell16.setCellValue(brf94b.getR35_amount_trade_reserve() == null ? 0
						: brf94b.getR35_amount_trade_reserve().intValue());
			}
			Cell R35cell17 = R35row.getCell(19);
			if (R35cell17 != null) {
				R35cell17.setCellValue(brf94b.getR35_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR35_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R35cell18 = R35row.getCell(20);
			if (R35cell18 != null) {
				R35cell18.setCellValue(brf94b.getR35_amount_financial_investment_gre() == null ? 0
						: brf94b.getR35_amount_financial_investment_gre().intValue());
			}
			Cell R35cell19 = R35row.getCell(21);
			if (R35cell19 != null) {
				R35cell19.setCellValue(brf94b.getR35_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR35_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R35cell20 = R35row.getCell(22);
			if (R35cell20 != null) {
				R35cell20.setCellValue(brf94b.getR35_amount_direct_investment_gre() == null ? 0
						: brf94b.getR35_amount_direct_investment_gre().intValue());
			}
			Cell R35cell21 = R35row.getCell(23);
			if (R35cell21 != null) {
				R35cell21.setCellValue(brf94b.getR35_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR35_no_of_transactions_services_gre().intValue());
			}
			Cell R35cell22 = R35row.getCell(24);
			if (R35cell22 != null) {
				R35cell22.setCellValue(brf94b.getR35_amount_services_gre() == null ? 0
						: brf94b.getR35_amount_services_gre().intValue());
			}
			Cell R35cell23 = R35row.getCell(25);
			if (R35cell23 != null) {
				R35cell23.setCellValue(brf94b.getR35_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR35_no_of_transactions_trade_gre().intValue());
			}
			Cell R35cell24 = R35row.getCell(26);
			if (R35cell24 != null) {
				R35cell24.setCellValue(
						brf94b.getR35_amount_trade_gre() == null ? 0 : brf94b.getR35_amount_trade_gre().intValue());
			}
			Cell R35cell25 = R35row.getCell(27);
			if (R35cell25 != null) {
				R35cell25.setCellValue(brf94b.getR35_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR35_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R35cell26 = R35row.getCell(28);
			if (R35cell26 != null) {
				R35cell26.setCellValue(brf94b.getR35_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR35_amount_financial_investment_corporate().intValue());
			}
			Cell R35cell27 = R35row.getCell(29);
			if (R35cell27 != null) {
				R35cell27.setCellValue(brf94b.getR35_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR35_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R35cell28 = R35row.getCell(30);
			if (R35cell28 != null) {
				R35cell28.setCellValue(brf94b.getR35_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR35_amount_direct_investment_corporate().intValue());
			}
			Cell R35cell29 = R35row.getCell(31);
			if (R35cell29 != null) {
				R35cell29.setCellValue(brf94b.getR35_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR35_no_of_transactions_services_corporate().intValue());
			}
			Cell R35cell30 = R35row.getCell(32);
			if (R35cell30 != null) {
				R35cell30.setCellValue(brf94b.getR35_amount_services_corporate() == null ? 0
						: brf94b.getR35_amount_services_corporate().intValue());
			}
			Cell R35cell31 = R35row.getCell(33);
			if (R35cell31 != null) {
				R35cell31.setCellValue(brf94b.getR35_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR35_no_of_transactions_trade_corporate().intValue());
			}
			Cell R35cell32 = R35row.getCell(34);
			if (R35cell32 != null) {
				R35cell32.setCellValue(brf94b.getR35_amount_trade_corporate() == null ? 0
						: brf94b.getR35_amount_trade_corporate().intValue());
			}
			Cell R35cell33 = R35row.getCell(35);
			if (R35cell33 != null) {
				R35cell33.setCellValue(brf94b.getR35_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR35_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R35cell34 = R35row.getCell(36);
			if (R35cell34 != null) {
				R35cell34.setCellValue(brf94b.getR35_amount_financial_investment_sme() == null ? 0
						: brf94b.getR35_amount_financial_investment_sme().intValue());
			}
			Cell R35cell35 = R35row.getCell(37);
			if (R35cell35 != null) {
				R35cell35.setCellValue(brf94b.getR35_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR35_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R35cell36 = R35row.getCell(38);
			if (R35cell36 != null) {
				R35cell36.setCellValue(brf94b.getR35_amount_direct_investment_sme() == null ? 0
						: brf94b.getR35_amount_direct_investment_sme().intValue());
			}
			Cell R35cell37 = R35row.getCell(39);
			if (R35cell37 != null) {
				R35cell37.setCellValue(brf94b.getR35_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR35_no_of_transactions_services_sme().intValue());
			}
			Cell R35cell38 = R35row.getCell(40);
			if (R35cell38 != null) {
				R35cell38.setCellValue(brf94b.getR35_amount_services_sme() == null ? 0
						: brf94b.getR35_amount_services_sme().intValue());
			}
			Cell R35cell39 = R35row.getCell(41);
			if (R35cell39 != null) {
				R35cell39.setCellValue(brf94b.getR35_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR35_no_of_transactions_trade_sme().intValue());
			}
			Cell R35cell40 = R35row.getCell(42);
			if (R35cell40 != null) {
				R35cell40.setCellValue(
						brf94b.getR35_amount_trade_sme() == null ? 0 : brf94b.getR35_amount_trade_sme().intValue());
			}
			Cell R35cell41 = R35row.getCell(43);
			if (R35cell41 != null) {
				R35cell41.setCellValue(brf94b.getR35_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R35cell42 = R35row.getCell(44);
			if (R35cell42 != null) {
				R35cell42.setCellValue(brf94b.getR35_amount_financial_investment_individual() == null ? 0
						: brf94b.getR35_amount_financial_investment_individual().intValue());
			}
			Cell R35cell43 = R35row.getCell(45);
			if (R35cell43 != null) {
				R35cell43.setCellValue(brf94b.getR35_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R35cell44 = R35row.getCell(46);
			if (R35cell44 != null) {
				R35cell44.setCellValue(brf94b.getR35_amount_direct_investment_individual() == null ? 0
						: brf94b.getR35_amount_direct_investment_individual().intValue());
			}
			Cell R35cell45 = R35row.getCell(47);
			if (R35cell45 != null) {
				R35cell45.setCellValue(brf94b.getR35_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_family_support_individual().intValue());
			}
			Cell R35cell46 = R35row.getCell(48);
			if (R35cell46 != null) {
				R35cell46.setCellValue(brf94b.getR35_amount_family_support_individual() == null ? 0
						: brf94b.getR35_amount_family_support_individual().intValue());
			}
			Cell R35cell47 = R35row.getCell(49);
			if (R35cell47 != null) {
				R35cell47.setCellValue(brf94b.getR35_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_education_individual().intValue());
			}
			Cell R35cell48 = R35row.getCell(50);
			if (R35cell48 != null) {
				R35cell48.setCellValue(brf94b.getR35_amount_education_individual() == null ? 0
						: brf94b.getR35_amount_education_individual().intValue());
			}
			Cell R35cell49 = R35row.getCell(51);
			if (R35cell49 != null) {
				R35cell49.setCellValue(brf94b.getR35_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_medical_individual().intValue());
			}

			Cell R35cell50 = R35row.getCell(52);
			if (R35cell50 != null) {
				R35cell50.setCellValue(brf94b.getR35_amount_medical_individual() == null ? 0
						: brf94b.getR35_amount_medical_individual().intValue());
			}
			Cell R35cell51 = R35row.getCell(53);
			if (R35cell51 != null) {
				R35cell51.setCellValue(brf94b.getR35_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_tourism_individual().intValue());
			}
			Cell R35cell52 = R35row.getCell(54);
			if (R35cell52 != null) {
				R35cell52.setCellValue(brf94b.getR35_amount_tourism_individual() == null ? 0
						: brf94b.getR35_amount_tourism_individual().intValue());
			}
			Cell R35cell53 = R35row.getCell(55);
			if (R35cell53 != null) {
				R35cell53.setCellValue(brf94b.getR35_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R35cell54 = R35row.getCell(56);
			if (R35cell54 != null) {
				R35cell54.setCellValue(brf94b.getR35_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR35_amount_debt_settlement_individual().intValue());
			}
			Cell R35cell55 = R35row.getCell(57);
			if (R35cell55 != null) {
				R35cell55.setCellValue(brf94b.getR35_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR35_no_of_transactions_other_services_individual().intValue());
			}

			Cell R35cell56 = R35row.getCell(58);
			if (R35cell56 != null) {
				R35cell56.setCellValue(brf94b.getR35_amount_other_services_individual() == null ? 0
						: brf94b.getR35_amount_other_services_individual().intValue());
			}

			Row R36row = sheet.getRow(44);
			Cell R36cell1 = R36row.getCell(3);
			if (R36cell1 != null) {
				R36cell1.setCellValue(brf94b.getR36_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR36_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R36cell2 = R36row.getCell(4);
			if (R36cell2 != null) {
				R36cell2.setCellValue(brf94b.getR36_amount_financial_investment_government() == null ? 0
						: brf94b.getR36_amount_financial_investment_government().intValue());
			}
			Cell R36cell3 = R36row.getCell(5);
			if (R36cell3 != null) {
				R36cell3.setCellValue(brf94b.getR36_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR36_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R36cell4 = R36row.getCell(6);
			if (R36cell4 != null) {
				R36cell4.setCellValue(brf94b.getR36_amount_direct_investment_government() == null ? 0
						: brf94b.getR36_amount_direct_investment_government().intValue());
			}
			Cell R36cell5 = R36row.getCell(7);
			if (R36cell5 != null) {
				R36cell5.setCellValue(brf94b.getR36_no_of_transactions_services_government() == null ? 0
						: brf94b.getR36_no_of_transactions_services_government().intValue());
			}
			Cell R36cell6 = R36row.getCell(8);
			if (R36cell6 != null) {
				R36cell6.setCellValue(brf94b.getR36_amount_services_government() == null ? 0
						: brf94b.getR36_amount_services_government().intValue());
			}
			Cell R36cell7 = R36row.getCell(9);
			if (R36cell7 != null) {
				R36cell7.setCellValue(brf94b.getR36_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR36_no_of_transactions_trade_government().intValue());
			}
			Cell R36cell8 = R36row.getCell(10);
			if (R36cell8 != null) {
				R36cell8.setCellValue(brf94b.getR36_amount_trade_government() == null ? 0
						: brf94b.getR36_amount_trade_government().intValue());
			}
			Cell R36cell9 = R36row.getCell(11);
			if (R36cell9 != null) {
				R36cell9.setCellValue(brf94b.getR36_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR36_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R36cell10 = R36row.getCell(12);
			if (R36cell10 != null) {
				R36cell10.setCellValue(brf94b.getR36_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR36_amount_financial_investment_reserve().intValue());
			}
			Cell R36cell11 = R36row.getCell(13);
			if (R36cell11 != null) {
				R36cell11.setCellValue(brf94b.getR36_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR36_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R36cell12 = R36row.getCell(14);
			if (R36cell12 != null) {
				R36cell12.setCellValue(brf94b.getR36_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR36_amount_direct_investment_reserve().intValue());
			}
			Cell R36cell13 = R36row.getCell(15);
			if (R36cell13 != null) {
				R36cell13.setCellValue(brf94b.getR36_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR36_no_of_transactions_services_reserve().intValue());
			}
			Cell R36cell14 = R36row.getCell(16);
			if (R36cell14 != null) {
				R36cell14.setCellValue(brf94b.getR36_amount_services_reserve() == null ? 0
						: brf94b.getR36_amount_services_reserve().intValue());
			}
			Cell R36cell15 = R36row.getCell(17);
			if (R36cell15 != null) {
				R36cell15.setCellValue(brf94b.getR36_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR36_no_of_transactions_trade_reserve().intValue());
			}
			Cell R36cell16 = R36row.getCell(18);
			if (R36cell16 != null) {
				R36cell16.setCellValue(brf94b.getR36_amount_trade_reserve() == null ? 0
						: brf94b.getR36_amount_trade_reserve().intValue());
			}
			Cell R36cell17 = R36row.getCell(19);
			if (R36cell17 != null) {
				R36cell17.setCellValue(brf94b.getR36_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR36_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R36cell18 = R36row.getCell(20);
			if (R36cell18 != null) {
				R36cell18.setCellValue(brf94b.getR36_amount_financial_investment_gre() == null ? 0
						: brf94b.getR36_amount_financial_investment_gre().intValue());
			}
			Cell R36cell19 = R36row.getCell(21);
			if (R36cell19 != null) {
				R36cell19.setCellValue(brf94b.getR36_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR36_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R36cell20 = R36row.getCell(22);
			if (R36cell20 != null) {
				R36cell20.setCellValue(brf94b.getR36_amount_direct_investment_gre() == null ? 0
						: brf94b.getR36_amount_direct_investment_gre().intValue());
			}
			Cell R36cell21 = R36row.getCell(23);
			if (R36cell21 != null) {
				R36cell21.setCellValue(brf94b.getR36_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR36_no_of_transactions_services_gre().intValue());
			}
			Cell R36cell22 = R36row.getCell(24);
			if (R36cell22 != null) {
				R36cell22.setCellValue(brf94b.getR36_amount_services_gre() == null ? 0
						: brf94b.getR36_amount_services_gre().intValue());
			}
			Cell R36cell23 = R36row.getCell(25);
			if (R36cell23 != null) {
				R36cell23.setCellValue(brf94b.getR36_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR36_no_of_transactions_trade_gre().intValue());
			}
			Cell R36cell24 = R36row.getCell(26);
			if (R36cell24 != null) {
				R36cell24.setCellValue(
						brf94b.getR36_amount_trade_gre() == null ? 0 : brf94b.getR36_amount_trade_gre().intValue());
			}
			Cell R36cell25 = R36row.getCell(27);
			if (R36cell25 != null) {
				R36cell25.setCellValue(brf94b.getR36_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR36_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R36cell26 = R36row.getCell(28);
			if (R36cell26 != null) {
				R36cell26.setCellValue(brf94b.getR36_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR36_amount_financial_investment_corporate().intValue());
			}
			Cell R36cell27 = R36row.getCell(29);
			if (R36cell27 != null) {
				R36cell27.setCellValue(brf94b.getR36_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR36_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R36cell28 = R36row.getCell(30);
			if (R36cell28 != null) {
				R36cell28.setCellValue(brf94b.getR36_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR36_amount_direct_investment_corporate().intValue());
			}
			Cell R36cell29 = R36row.getCell(31);
			if (R36cell29 != null) {
				R36cell29.setCellValue(brf94b.getR36_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR36_no_of_transactions_services_corporate().intValue());
			}
			Cell R36cell30 = R36row.getCell(32);
			if (R36cell30 != null) {
				R36cell30.setCellValue(brf94b.getR36_amount_services_corporate() == null ? 0
						: brf94b.getR36_amount_services_corporate().intValue());
			}
			Cell R36cell31 = R36row.getCell(33);
			if (R36cell31 != null) {
				R36cell31.setCellValue(brf94b.getR36_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR36_no_of_transactions_trade_corporate().intValue());
			}
			Cell R36cell32 = R36row.getCell(34);
			if (R36cell32 != null) {
				R36cell32.setCellValue(brf94b.getR36_amount_trade_corporate() == null ? 0
						: brf94b.getR36_amount_trade_corporate().intValue());
			}
			Cell R36cell33 = R36row.getCell(35);
			if (R36cell33 != null) {
				R36cell33.setCellValue(brf94b.getR36_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR36_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R36cell34 = R36row.getCell(36);
			if (R36cell34 != null) {
				R36cell34.setCellValue(brf94b.getR36_amount_financial_investment_sme() == null ? 0
						: brf94b.getR36_amount_financial_investment_sme().intValue());
			}
			Cell R36cell35 = R36row.getCell(37);
			if (R36cell35 != null) {
				R36cell35.setCellValue(brf94b.getR36_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR36_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R36cell36 = R36row.getCell(38);
			if (R36cell36 != null) {
				R36cell36.setCellValue(brf94b.getR36_amount_direct_investment_sme() == null ? 0
						: brf94b.getR36_amount_direct_investment_sme().intValue());
			}
			Cell R36cell37 = R36row.getCell(39);
			if (R36cell37 != null) {
				R36cell37.setCellValue(brf94b.getR36_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR36_no_of_transactions_services_sme().intValue());
			}
			Cell R36cell38 = R36row.getCell(40);
			if (R36cell38 != null) {
				R36cell38.setCellValue(brf94b.getR36_amount_services_sme() == null ? 0
						: brf94b.getR36_amount_services_sme().intValue());
			}
			Cell R36cell39 = R36row.getCell(41);
			if (R36cell39 != null) {
				R36cell39.setCellValue(brf94b.getR36_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR36_no_of_transactions_trade_sme().intValue());
			}
			Cell R36cell40 = R36row.getCell(42);
			if (R36cell40 != null) {
				R36cell40.setCellValue(
						brf94b.getR36_amount_trade_sme() == null ? 0 : brf94b.getR36_amount_trade_sme().intValue());
			}
			Cell R36cell41 = R36row.getCell(43);
			if (R36cell41 != null) {
				R36cell41.setCellValue(brf94b.getR36_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R36cell42 = R36row.getCell(44);
			if (R36cell42 != null) {
				R36cell42.setCellValue(brf94b.getR36_amount_financial_investment_individual() == null ? 0
						: brf94b.getR36_amount_financial_investment_individual().intValue());
			}
			Cell R36cell43 = R36row.getCell(45);
			if (R36cell43 != null) {
				R36cell43.setCellValue(brf94b.getR36_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R36cell44 = R36row.getCell(46);
			if (R36cell44 != null) {
				R36cell44.setCellValue(brf94b.getR36_amount_direct_investment_individual() == null ? 0
						: brf94b.getR36_amount_direct_investment_individual().intValue());
			}
			Cell R36cell45 = R36row.getCell(47);
			if (R36cell45 != null) {
				R36cell45.setCellValue(brf94b.getR36_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_family_support_individual().intValue());
			}
			Cell R36cell46 = R36row.getCell(48);
			if (R36cell46 != null) {
				R36cell46.setCellValue(brf94b.getR36_amount_family_support_individual() == null ? 0
						: brf94b.getR36_amount_family_support_individual().intValue());
			}
			Cell R36cell47 = R36row.getCell(49);
			if (R36cell47 != null) {
				R36cell47.setCellValue(brf94b.getR36_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_education_individual().intValue());
			}
			Cell R36cell48 = R36row.getCell(50);
			if (R36cell48 != null) {
				R36cell48.setCellValue(brf94b.getR36_amount_education_individual() == null ? 0
						: brf94b.getR36_amount_education_individual().intValue());
			}
			Cell R36cell49 = R36row.getCell(51);
			if (R36cell49 != null) {
				R36cell49.setCellValue(brf94b.getR36_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_medical_individual().intValue());
			}

			Cell R36cell50 = R36row.getCell(52);
			if (R36cell50 != null) {
				R36cell50.setCellValue(brf94b.getR36_amount_medical_individual() == null ? 0
						: brf94b.getR36_amount_medical_individual().intValue());
			}
			Cell R36cell51 = R36row.getCell(53);
			if (R36cell51 != null) {
				R36cell51.setCellValue(brf94b.getR36_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_tourism_individual().intValue());
			}
			Cell R36cell52 = R36row.getCell(54);
			if (R36cell52 != null) {
				R36cell52.setCellValue(brf94b.getR36_amount_tourism_individual() == null ? 0
						: brf94b.getR36_amount_tourism_individual().intValue());
			}
			Cell R36cell53 = R36row.getCell(55);
			if (R36cell53 != null) {
				R36cell53.setCellValue(brf94b.getR36_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R36cell54 = R36row.getCell(56);
			if (R36cell54 != null) {
				R36cell54.setCellValue(brf94b.getR36_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR36_amount_debt_settlement_individual().intValue());
			}
			Cell R36cell55 = R36row.getCell(57);
			if (R36cell55 != null) {
				R36cell55.setCellValue(brf94b.getR36_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR36_no_of_transactions_other_services_individual().intValue());
			}

			Cell R36cell56 = R36row.getCell(58);
			if (R36cell56 != null) {
				R36cell56.setCellValue(brf94b.getR36_amount_other_services_individual() == null ? 0
						: brf94b.getR36_amount_other_services_individual().intValue());
			}

			Row R37row = sheet.getRow(45);
			Cell R37cell1 = R37row.getCell(3);
			if (R37cell1 != null) {
				R37cell1.setCellValue(brf94b.getR37_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR37_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R37cell2 = R37row.getCell(4);
			if (R37cell2 != null) {
				R37cell2.setCellValue(brf94b.getR37_amount_financial_investment_government() == null ? 0
						: brf94b.getR37_amount_financial_investment_government().intValue());
			}
			Cell R37cell3 = R37row.getCell(5);
			if (R37cell3 != null) {
				R37cell3.setCellValue(brf94b.getR37_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR37_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R37cell4 = R37row.getCell(6);
			if (R37cell4 != null) {
				R37cell4.setCellValue(brf94b.getR37_amount_direct_investment_government() == null ? 0
						: brf94b.getR37_amount_direct_investment_government().intValue());
			}
			Cell R37cell5 = R37row.getCell(7);
			if (R37cell5 != null) {
				R37cell5.setCellValue(brf94b.getR37_no_of_transactions_services_government() == null ? 0
						: brf94b.getR37_no_of_transactions_services_government().intValue());
			}
			Cell R37cell6 = R37row.getCell(8);
			if (R37cell6 != null) {
				R37cell6.setCellValue(brf94b.getR37_amount_services_government() == null ? 0
						: brf94b.getR37_amount_services_government().intValue());
			}
			Cell R37cell7 = R37row.getCell(9);
			if (R37cell7 != null) {
				R37cell7.setCellValue(brf94b.getR37_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR37_no_of_transactions_trade_government().intValue());
			}
			Cell R37cell8 = R37row.getCell(10);
			if (R37cell8 != null) {
				R37cell8.setCellValue(brf94b.getR37_amount_trade_government() == null ? 0
						: brf94b.getR37_amount_trade_government().intValue());
			}
			Cell R37cell9 = R37row.getCell(11);
			if (R37cell9 != null) {
				R37cell9.setCellValue(brf94b.getR37_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR37_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R37cell10 = R37row.getCell(12);
			if (R37cell10 != null) {
				R37cell10.setCellValue(brf94b.getR37_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR37_amount_financial_investment_reserve().intValue());
			}
			Cell R37cell11 = R37row.getCell(13);
			if (R37cell11 != null) {
				R37cell11.setCellValue(brf94b.getR37_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR37_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R37cell12 = R37row.getCell(14);
			if (R37cell12 != null) {
				R37cell12.setCellValue(brf94b.getR37_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR37_amount_direct_investment_reserve().intValue());
			}
			Cell R37cell13 = R37row.getCell(15);
			if (R37cell13 != null) {
				R37cell13.setCellValue(brf94b.getR37_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR37_no_of_transactions_services_reserve().intValue());
			}
			Cell R37cell14 = R37row.getCell(16);
			if (R37cell14 != null) {
				R37cell14.setCellValue(brf94b.getR37_amount_services_reserve() == null ? 0
						: brf94b.getR37_amount_services_reserve().intValue());
			}
			Cell R37cell15 = R37row.getCell(17);
			if (R37cell15 != null) {
				R37cell15.setCellValue(brf94b.getR37_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR37_no_of_transactions_trade_reserve().intValue());
			}
			Cell R37cell16 = R37row.getCell(18);
			if (R37cell16 != null) {
				R37cell16.setCellValue(brf94b.getR37_amount_trade_reserve() == null ? 0
						: brf94b.getR37_amount_trade_reserve().intValue());
			}
			Cell R37cell17 = R37row.getCell(19);
			if (R37cell17 != null) {
				R37cell17.setCellValue(brf94b.getR37_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR37_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R37cell18 = R37row.getCell(20);
			if (R37cell18 != null) {
				R37cell18.setCellValue(brf94b.getR37_amount_financial_investment_gre() == null ? 0
						: brf94b.getR37_amount_financial_investment_gre().intValue());
			}
			Cell R37cell19 = R37row.getCell(21);
			if (R37cell19 != null) {
				R37cell19.setCellValue(brf94b.getR37_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR37_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R37cell20 = R37row.getCell(22);
			if (R37cell20 != null) {
				R37cell20.setCellValue(brf94b.getR37_amount_direct_investment_gre() == null ? 0
						: brf94b.getR37_amount_direct_investment_gre().intValue());
			}
			Cell R37cell21 = R37row.getCell(23);
			if (R37cell21 != null) {
				R37cell21.setCellValue(brf94b.getR37_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR37_no_of_transactions_services_gre().intValue());
			}
			Cell R37cell22 = R37row.getCell(24);
			if (R37cell22 != null) {
				R37cell22.setCellValue(brf94b.getR37_amount_services_gre() == null ? 0
						: brf94b.getR37_amount_services_gre().intValue());
			}
			Cell R37cell23 = R37row.getCell(25);
			if (R37cell23 != null) {
				R37cell23.setCellValue(brf94b.getR37_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR37_no_of_transactions_trade_gre().intValue());
			}
			Cell R37cell24 = R37row.getCell(26);
			if (R37cell24 != null) {
				R37cell24.setCellValue(
						brf94b.getR37_amount_trade_gre() == null ? 0 : brf94b.getR37_amount_trade_gre().intValue());
			}
			Cell R37cell25 = R37row.getCell(27);
			if (R37cell25 != null) {
				R37cell25.setCellValue(brf94b.getR37_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR37_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R37cell26 = R37row.getCell(28);
			if (R37cell26 != null) {
				R37cell26.setCellValue(brf94b.getR37_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR37_amount_financial_investment_corporate().intValue());
			}
			Cell R37cell27 = R37row.getCell(29);
			if (R37cell27 != null) {
				R37cell27.setCellValue(brf94b.getR37_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR37_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R37cell28 = R37row.getCell(30);
			if (R37cell28 != null) {
				R37cell28.setCellValue(brf94b.getR37_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR37_amount_direct_investment_corporate().intValue());
			}
			Cell R37cell29 = R37row.getCell(31);
			if (R37cell29 != null) {
				R37cell29.setCellValue(brf94b.getR37_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR37_no_of_transactions_services_corporate().intValue());
			}
			Cell R37cell30 = R37row.getCell(32);
			if (R37cell30 != null) {
				R37cell30.setCellValue(brf94b.getR37_amount_services_corporate() == null ? 0
						: brf94b.getR37_amount_services_corporate().intValue());
			}
			Cell R37cell31 = R37row.getCell(33);
			if (R37cell31 != null) {
				R37cell31.setCellValue(brf94b.getR37_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR37_no_of_transactions_trade_corporate().intValue());
			}
			Cell R37cell32 = R37row.getCell(34);
			if (R37cell32 != null) {
				R37cell32.setCellValue(brf94b.getR37_amount_trade_corporate() == null ? 0
						: brf94b.getR37_amount_trade_corporate().intValue());
			}
			Cell R37cell33 = R37row.getCell(35);
			if (R37cell33 != null) {
				R37cell33.setCellValue(brf94b.getR37_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR37_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R37cell34 = R37row.getCell(36);
			if (R37cell34 != null) {
				R37cell34.setCellValue(brf94b.getR37_amount_financial_investment_sme() == null ? 0
						: brf94b.getR37_amount_financial_investment_sme().intValue());
			}
			Cell R37cell35 = R37row.getCell(37);
			if (R37cell35 != null) {
				R37cell35.setCellValue(brf94b.getR37_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR37_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R37cell36 = R37row.getCell(38);
			if (R37cell36 != null) {
				R37cell36.setCellValue(brf94b.getR37_amount_direct_investment_sme() == null ? 0
						: brf94b.getR37_amount_direct_investment_sme().intValue());
			}
			Cell R37cell37 = R37row.getCell(39);
			if (R37cell37 != null) {
				R37cell37.setCellValue(brf94b.getR37_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR37_no_of_transactions_services_sme().intValue());
			}
			Cell R37cell38 = R37row.getCell(40);
			if (R37cell38 != null) {
				R37cell38.setCellValue(brf94b.getR37_amount_services_sme() == null ? 0
						: brf94b.getR37_amount_services_sme().intValue());
			}
			Cell R37cell39 = R37row.getCell(41);
			if (R37cell39 != null) {
				R37cell39.setCellValue(brf94b.getR37_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR37_no_of_transactions_trade_sme().intValue());
			}
			Cell R37cell40 = R37row.getCell(42);
			if (R37cell40 != null) {
				R37cell40.setCellValue(
						brf94b.getR37_amount_trade_sme() == null ? 0 : brf94b.getR37_amount_trade_sme().intValue());
			}
			Cell R37cell41 = R37row.getCell(43);
			if (R37cell41 != null) {
				R37cell41.setCellValue(brf94b.getR37_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R37cell42 = R37row.getCell(44);
			if (R37cell42 != null) {
				R37cell42.setCellValue(brf94b.getR37_amount_financial_investment_individual() == null ? 0
						: brf94b.getR37_amount_financial_investment_individual().intValue());
			}
			Cell R37cell43 = R37row.getCell(45);
			if (R37cell43 != null) {
				R37cell43.setCellValue(brf94b.getR37_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R37cell44 = R37row.getCell(46);
			if (R37cell44 != null) {
				R37cell44.setCellValue(brf94b.getR37_amount_direct_investment_individual() == null ? 0
						: brf94b.getR37_amount_direct_investment_individual().intValue());
			}
			Cell R37cell45 = R37row.getCell(47);
			if (R37cell45 != null) {
				R37cell45.setCellValue(brf94b.getR37_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_family_support_individual().intValue());
			}
			Cell R37cell46 = R37row.getCell(48);
			if (R37cell46 != null) {
				R37cell46.setCellValue(brf94b.getR37_amount_family_support_individual() == null ? 0
						: brf94b.getR37_amount_family_support_individual().intValue());
			}
			Cell R37cell47 = R37row.getCell(49);
			if (R37cell47 != null) {
				R37cell47.setCellValue(brf94b.getR37_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_education_individual().intValue());
			}
			Cell R37cell48 = R37row.getCell(50);
			if (R37cell48 != null) {
				R37cell48.setCellValue(brf94b.getR37_amount_education_individual() == null ? 0
						: brf94b.getR37_amount_education_individual().intValue());
			}
			Cell R37cell49 = R37row.getCell(51);
			if (R37cell49 != null) {
				R37cell49.setCellValue(brf94b.getR37_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_medical_individual().intValue());
			}

			Cell R37cell50 = R37row.getCell(52);
			if (R37cell50 != null) {
				R37cell50.setCellValue(brf94b.getR37_amount_medical_individual() == null ? 0
						: brf94b.getR37_amount_medical_individual().intValue());
			}
			Cell R37cell51 = R37row.getCell(53);
			if (R37cell51 != null) {
				R37cell51.setCellValue(brf94b.getR37_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_tourism_individual().intValue());
			}
			Cell R37cell52 = R37row.getCell(54);
			if (R37cell52 != null) {
				R37cell52.setCellValue(brf94b.getR37_amount_tourism_individual() == null ? 0
						: brf94b.getR37_amount_tourism_individual().intValue());
			}
			Cell R37cell53 = R37row.getCell(55);
			if (R37cell53 != null) {
				R37cell53.setCellValue(brf94b.getR37_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R37cell54 = R37row.getCell(56);
			if (R37cell54 != null) {
				R37cell54.setCellValue(brf94b.getR37_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR37_amount_debt_settlement_individual().intValue());
			}
			Cell R37cell55 = R37row.getCell(57);
			if (R37cell55 != null) {
				R37cell55.setCellValue(brf94b.getR37_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR37_no_of_transactions_other_services_individual().intValue());
			}

			Cell R37cell56 = R37row.getCell(58);
			if (R37cell56 != null) {
				R37cell56.setCellValue(brf94b.getR37_amount_other_services_individual() == null ? 0
						: brf94b.getR37_amount_other_services_individual().intValue());
			}

			Row R38row = sheet.getRow(46);
			Cell R38cell1 = R38row.getCell(3);
			if (R38cell1 != null) {
				R38cell1.setCellValue(brf94b.getR38_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR38_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R38cell2 = R38row.getCell(4);
			if (R38cell2 != null) {
				R38cell2.setCellValue(brf94b.getR38_amount_financial_investment_government() == null ? 0
						: brf94b.getR38_amount_financial_investment_government().intValue());
			}
			Cell R38cell3 = R38row.getCell(5);
			if (R38cell3 != null) {
				R38cell3.setCellValue(brf94b.getR38_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR38_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R38cell4 = R38row.getCell(6);
			if (R38cell4 != null) {
				R38cell4.setCellValue(brf94b.getR38_amount_direct_investment_government() == null ? 0
						: brf94b.getR38_amount_direct_investment_government().intValue());
			}
			Cell R38cell5 = R38row.getCell(7);
			if (R38cell5 != null) {
				R38cell5.setCellValue(brf94b.getR38_no_of_transactions_services_government() == null ? 0
						: brf94b.getR38_no_of_transactions_services_government().intValue());
			}
			Cell R38cell6 = R38row.getCell(8);
			if (R38cell6 != null) {
				R38cell6.setCellValue(brf94b.getR38_amount_services_government() == null ? 0
						: brf94b.getR38_amount_services_government().intValue());
			}
			Cell R38cell7 = R38row.getCell(9);
			if (R38cell7 != null) {
				R38cell7.setCellValue(brf94b.getR38_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR38_no_of_transactions_trade_government().intValue());
			}
			Cell R38cell8 = R38row.getCell(10);
			if (R38cell8 != null) {
				R38cell8.setCellValue(brf94b.getR38_amount_trade_government() == null ? 0
						: brf94b.getR38_amount_trade_government().intValue());
			}
			Cell R38cell9 = R38row.getCell(11);
			if (R38cell9 != null) {
				R38cell9.setCellValue(brf94b.getR38_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR38_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R38cell10 = R38row.getCell(12);
			if (R38cell10 != null) {
				R38cell10.setCellValue(brf94b.getR38_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR38_amount_financial_investment_reserve().intValue());
			}
			Cell R38cell11 = R38row.getCell(13);
			if (R38cell11 != null) {
				R38cell11.setCellValue(brf94b.getR38_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR38_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R38cell12 = R38row.getCell(14);
			if (R38cell12 != null) {
				R38cell12.setCellValue(brf94b.getR38_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR38_amount_direct_investment_reserve().intValue());
			}
			Cell R38cell13 = R38row.getCell(15);
			if (R38cell13 != null) {
				R38cell13.setCellValue(brf94b.getR38_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR38_no_of_transactions_services_reserve().intValue());
			}
			Cell R38cell14 = R38row.getCell(16);
			if (R38cell14 != null) {
				R38cell14.setCellValue(brf94b.getR38_amount_services_reserve() == null ? 0
						: brf94b.getR38_amount_services_reserve().intValue());
			}
			Cell R38cell15 = R38row.getCell(17);
			if (R38cell15 != null) {
				R38cell15.setCellValue(brf94b.getR38_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR38_no_of_transactions_trade_reserve().intValue());
			}
			Cell R38cell16 = R38row.getCell(18);
			if (R38cell16 != null) {
				R38cell16.setCellValue(brf94b.getR38_amount_trade_reserve() == null ? 0
						: brf94b.getR38_amount_trade_reserve().intValue());
			}
			Cell R38cell17 = R38row.getCell(19);
			if (R38cell17 != null) {
				R38cell17.setCellValue(brf94b.getR38_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR38_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R38cell18 = R38row.getCell(20);
			if (R38cell18 != null) {
				R38cell18.setCellValue(brf94b.getR38_amount_financial_investment_gre() == null ? 0
						: brf94b.getR38_amount_financial_investment_gre().intValue());
			}
			Cell R38cell19 = R38row.getCell(21);
			if (R38cell19 != null) {
				R38cell19.setCellValue(brf94b.getR38_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR38_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R38cell20 = R38row.getCell(22);
			if (R38cell20 != null) {
				R38cell20.setCellValue(brf94b.getR38_amount_direct_investment_gre() == null ? 0
						: brf94b.getR38_amount_direct_investment_gre().intValue());
			}
			Cell R38cell21 = R38row.getCell(23);
			if (R38cell21 != null) {
				R38cell21.setCellValue(brf94b.getR38_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR38_no_of_transactions_services_gre().intValue());
			}
			Cell R38cell22 = R38row.getCell(24);
			if (R38cell22 != null) {
				R38cell22.setCellValue(brf94b.getR38_amount_services_gre() == null ? 0
						: brf94b.getR38_amount_services_gre().intValue());
			}
			Cell R38cell23 = R38row.getCell(25);
			if (R38cell23 != null) {
				R38cell23.setCellValue(brf94b.getR38_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR38_no_of_transactions_trade_gre().intValue());
			}
			Cell R38cell24 = R38row.getCell(26);
			if (R38cell24 != null) {
				R38cell24.setCellValue(
						brf94b.getR38_amount_trade_gre() == null ? 0 : brf94b.getR38_amount_trade_gre().intValue());
			}
			Cell R38cell25 = R38row.getCell(27);
			if (R38cell25 != null) {
				R38cell25.setCellValue(brf94b.getR38_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR38_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R38cell26 = R38row.getCell(28);
			if (R38cell26 != null) {
				R38cell26.setCellValue(brf94b.getR38_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR38_amount_financial_investment_corporate().intValue());
			}
			Cell R38cell27 = R38row.getCell(29);
			if (R38cell27 != null) {
				R38cell27.setCellValue(brf94b.getR38_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR38_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R38cell28 = R38row.getCell(30);
			if (R38cell28 != null) {
				R38cell28.setCellValue(brf94b.getR38_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR38_amount_direct_investment_corporate().intValue());
			}
			Cell R38cell29 = R38row.getCell(31);
			if (R38cell29 != null) {
				R38cell29.setCellValue(brf94b.getR38_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR38_no_of_transactions_services_corporate().intValue());
			}
			Cell R38cell30 = R38row.getCell(32);
			if (R38cell30 != null) {
				R38cell30.setCellValue(brf94b.getR38_amount_services_corporate() == null ? 0
						: brf94b.getR38_amount_services_corporate().intValue());
			}
			Cell R38cell31 = R38row.getCell(33);
			if (R38cell31 != null) {
				R38cell31.setCellValue(brf94b.getR38_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR38_no_of_transactions_trade_corporate().intValue());
			}
			Cell R38cell32 = R38row.getCell(34);
			if (R38cell32 != null) {
				R38cell32.setCellValue(brf94b.getR38_amount_trade_corporate() == null ? 0
						: brf94b.getR38_amount_trade_corporate().intValue());
			}
			Cell R38cell33 = R38row.getCell(35);
			if (R38cell33 != null) {
				R38cell33.setCellValue(brf94b.getR38_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR38_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R38cell34 = R38row.getCell(36);
			if (R38cell34 != null) {
				R38cell34.setCellValue(brf94b.getR38_amount_financial_investment_sme() == null ? 0
						: brf94b.getR38_amount_financial_investment_sme().intValue());
			}
			Cell R38cell35 = R38row.getCell(37);
			if (R38cell35 != null) {
				R38cell35.setCellValue(brf94b.getR38_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR38_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R38cell36 = R38row.getCell(38);
			if (R38cell36 != null) {
				R38cell36.setCellValue(brf94b.getR38_amount_direct_investment_sme() == null ? 0
						: brf94b.getR38_amount_direct_investment_sme().intValue());
			}
			Cell R38cell37 = R38row.getCell(39);
			if (R38cell37 != null) {
				R38cell37.setCellValue(brf94b.getR38_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR38_no_of_transactions_services_sme().intValue());
			}
			Cell R38cell38 = R38row.getCell(40);
			if (R38cell38 != null) {
				R38cell38.setCellValue(brf94b.getR38_amount_services_sme() == null ? 0
						: brf94b.getR38_amount_services_sme().intValue());
			}
			Cell R38cell39 = R38row.getCell(41);
			if (R38cell39 != null) {
				R38cell39.setCellValue(brf94b.getR38_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR38_no_of_transactions_trade_sme().intValue());
			}
			Cell R38cell40 = R38row.getCell(42);
			if (R38cell40 != null) {
				R38cell40.setCellValue(
						brf94b.getR38_amount_trade_sme() == null ? 0 : brf94b.getR38_amount_trade_sme().intValue());
			}
			Cell R38cell41 = R38row.getCell(43);
			if (R38cell41 != null) {
				R38cell41.setCellValue(brf94b.getR38_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R38cell42 = R38row.getCell(44);
			if (R38cell42 != null) {
				R38cell42.setCellValue(brf94b.getR38_amount_financial_investment_individual() == null ? 0
						: brf94b.getR38_amount_financial_investment_individual().intValue());
			}
			Cell R38cell43 = R38row.getCell(45);
			if (R38cell43 != null) {
				R38cell43.setCellValue(brf94b.getR38_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R38cell44 = R38row.getCell(46);
			if (R38cell44 != null) {
				R38cell44.setCellValue(brf94b.getR38_amount_direct_investment_individual() == null ? 0
						: brf94b.getR38_amount_direct_investment_individual().intValue());
			}
			Cell R38cell45 = R38row.getCell(47);
			if (R38cell45 != null) {
				R38cell45.setCellValue(brf94b.getR38_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_family_support_individual().intValue());
			}
			Cell R38cell46 = R38row.getCell(48);
			if (R38cell46 != null) {
				R38cell46.setCellValue(brf94b.getR38_amount_family_support_individual() == null ? 0
						: brf94b.getR38_amount_family_support_individual().intValue());
			}
			Cell R38cell47 = R38row.getCell(49);
			if (R38cell47 != null) {
				R38cell47.setCellValue(brf94b.getR38_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_education_individual().intValue());
			}
			Cell R38cell48 = R38row.getCell(50);
			if (R38cell48 != null) {
				R38cell48.setCellValue(brf94b.getR38_amount_education_individual() == null ? 0
						: brf94b.getR38_amount_education_individual().intValue());
			}
			Cell R38cell49 = R38row.getCell(51);
			if (R38cell49 != null) {
				R38cell49.setCellValue(brf94b.getR38_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_medical_individual().intValue());
			}

			Cell R38cell50 = R38row.getCell(52);
			if (R38cell50 != null) {
				R38cell50.setCellValue(brf94b.getR38_amount_medical_individual() == null ? 0
						: brf94b.getR38_amount_medical_individual().intValue());
			}
			Cell R38cell51 = R38row.getCell(53);
			if (R38cell51 != null) {
				R38cell51.setCellValue(brf94b.getR38_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_tourism_individual().intValue());
			}
			Cell R38cell52 = R38row.getCell(54);
			if (R38cell52 != null) {
				R38cell52.setCellValue(brf94b.getR38_amount_tourism_individual() == null ? 0
						: brf94b.getR38_amount_tourism_individual().intValue());
			}
			Cell R38cell53 = R38row.getCell(55);
			if (R38cell53 != null) {
				R38cell53.setCellValue(brf94b.getR38_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R38cell54 = R38row.getCell(56);
			if (R38cell54 != null) {
				R38cell54.setCellValue(brf94b.getR38_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR38_amount_debt_settlement_individual().intValue());
			}
			Cell R38cell55 = R38row.getCell(57);
			if (R38cell55 != null) {
				R38cell55.setCellValue(brf94b.getR38_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR38_no_of_transactions_other_services_individual().intValue());
			}

			Cell R38cell56 = R38row.getCell(58);
			if (R38cell56 != null) {
				R38cell56.setCellValue(brf94b.getR38_amount_other_services_individual() == null ? 0
						: brf94b.getR38_amount_other_services_individual().intValue());
			}

			Row R39row = sheet.getRow(47);
			Cell R39cell1 = R39row.getCell(3);
			if (R39cell1 != null) {
				R39cell1.setCellValue(brf94b.getR39_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR39_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R39cell2 = R39row.getCell(4);
			if (R39cell2 != null) {
				R39cell2.setCellValue(brf94b.getR39_amount_financial_investment_government() == null ? 0
						: brf94b.getR39_amount_financial_investment_government().intValue());
			}
			Cell R39cell3 = R39row.getCell(5);
			if (R39cell3 != null) {
				R39cell3.setCellValue(brf94b.getR39_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR39_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R39cell4 = R39row.getCell(6);
			if (R39cell4 != null) {
				R39cell4.setCellValue(brf94b.getR39_amount_direct_investment_government() == null ? 0
						: brf94b.getR39_amount_direct_investment_government().intValue());
			}
			Cell R39cell5 = R39row.getCell(7);
			if (R39cell5 != null) {
				R39cell5.setCellValue(brf94b.getR39_no_of_transactions_services_government() == null ? 0
						: brf94b.getR39_no_of_transactions_services_government().intValue());
			}
			Cell R39cell6 = R39row.getCell(8);
			if (R39cell6 != null) {
				R39cell6.setCellValue(brf94b.getR39_amount_services_government() == null ? 0
						: brf94b.getR39_amount_services_government().intValue());
			}
			Cell R39cell7 = R39row.getCell(9);
			if (R39cell7 != null) {
				R39cell7.setCellValue(brf94b.getR39_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR39_no_of_transactions_trade_government().intValue());
			}
			Cell R39cell8 = R39row.getCell(10);
			if (R39cell8 != null) {
				R39cell8.setCellValue(brf94b.getR39_amount_trade_government() == null ? 0
						: brf94b.getR39_amount_trade_government().intValue());
			}
			Cell R39cell9 = R39row.getCell(11);
			if (R39cell9 != null) {
				R39cell9.setCellValue(brf94b.getR39_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR39_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R39cell10 = R39row.getCell(12);
			if (R39cell10 != null) {
				R39cell10.setCellValue(brf94b.getR39_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR39_amount_financial_investment_reserve().intValue());
			}
			Cell R39cell11 = R39row.getCell(13);
			if (R39cell11 != null) {
				R39cell11.setCellValue(brf94b.getR39_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR39_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R39cell12 = R39row.getCell(14);
			if (R39cell12 != null) {
				R39cell12.setCellValue(brf94b.getR39_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR39_amount_direct_investment_reserve().intValue());
			}
			Cell R39cell13 = R39row.getCell(15);
			if (R39cell13 != null) {
				R39cell13.setCellValue(brf94b.getR39_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR39_no_of_transactions_services_reserve().intValue());
			}
			Cell R39cell14 = R39row.getCell(16);
			if (R39cell14 != null) {
				R39cell14.setCellValue(brf94b.getR39_amount_services_reserve() == null ? 0
						: brf94b.getR39_amount_services_reserve().intValue());
			}
			Cell R39cell15 = R39row.getCell(17);
			if (R39cell15 != null) {
				R39cell15.setCellValue(brf94b.getR39_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR39_no_of_transactions_trade_reserve().intValue());
			}
			Cell R39cell16 = R39row.getCell(18);
			if (R39cell16 != null) {
				R39cell16.setCellValue(brf94b.getR39_amount_trade_reserve() == null ? 0
						: brf94b.getR39_amount_trade_reserve().intValue());
			}
			Cell R39cell17 = R39row.getCell(19);
			if (R39cell17 != null) {
				R39cell17.setCellValue(brf94b.getR39_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR39_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R39cell18 = R39row.getCell(20);
			if (R39cell18 != null) {
				R39cell18.setCellValue(brf94b.getR39_amount_financial_investment_gre() == null ? 0
						: brf94b.getR39_amount_financial_investment_gre().intValue());
			}
			Cell R39cell19 = R39row.getCell(21);
			if (R39cell19 != null) {
				R39cell19.setCellValue(brf94b.getR39_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR39_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R39cell20 = R39row.getCell(22);
			if (R39cell20 != null) {
				R39cell20.setCellValue(brf94b.getR39_amount_direct_investment_gre() == null ? 0
						: brf94b.getR39_amount_direct_investment_gre().intValue());
			}
			Cell R39cell21 = R39row.getCell(23);
			if (R39cell21 != null) {
				R39cell21.setCellValue(brf94b.getR39_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR39_no_of_transactions_services_gre().intValue());
			}
			Cell R39cell22 = R39row.getCell(24);
			if (R39cell22 != null) {
				R39cell22.setCellValue(brf94b.getR39_amount_services_gre() == null ? 0
						: brf94b.getR39_amount_services_gre().intValue());
			}
			Cell R39cell23 = R39row.getCell(25);
			if (R39cell23 != null) {
				R39cell23.setCellValue(brf94b.getR39_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR39_no_of_transactions_trade_gre().intValue());
			}
			Cell R39cell24 = R39row.getCell(26);
			if (R39cell24 != null) {
				R39cell24.setCellValue(
						brf94b.getR39_amount_trade_gre() == null ? 0 : brf94b.getR39_amount_trade_gre().intValue());
			}
			Cell R39cell25 = R39row.getCell(27);
			if (R39cell25 != null) {
				R39cell25.setCellValue(brf94b.getR39_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR39_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R39cell26 = R39row.getCell(28);
			if (R39cell26 != null) {
				R39cell26.setCellValue(brf94b.getR39_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR39_amount_financial_investment_corporate().intValue());
			}
			Cell R39cell27 = R39row.getCell(29);
			if (R39cell27 != null) {
				R39cell27.setCellValue(brf94b.getR39_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR39_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R39cell28 = R39row.getCell(30);
			if (R39cell28 != null) {
				R39cell28.setCellValue(brf94b.getR39_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR39_amount_direct_investment_corporate().intValue());
			}
			Cell R39cell29 = R39row.getCell(31);
			if (R39cell29 != null) {
				R39cell29.setCellValue(brf94b.getR39_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR39_no_of_transactions_services_corporate().intValue());
			}
			Cell R39cell30 = R39row.getCell(32);
			if (R39cell30 != null) {
				R39cell30.setCellValue(brf94b.getR39_amount_services_corporate() == null ? 0
						: brf94b.getR39_amount_services_corporate().intValue());
			}
			Cell R39cell31 = R39row.getCell(33);
			if (R39cell31 != null) {
				R39cell31.setCellValue(brf94b.getR39_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR39_no_of_transactions_trade_corporate().intValue());
			}
			Cell R39cell32 = R39row.getCell(34);
			if (R39cell32 != null) {
				R39cell32.setCellValue(brf94b.getR39_amount_trade_corporate() == null ? 0
						: brf94b.getR39_amount_trade_corporate().intValue());
			}
			Cell R39cell33 = R39row.getCell(35);
			if (R39cell33 != null) {
				R39cell33.setCellValue(brf94b.getR39_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR39_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R39cell34 = R39row.getCell(36);
			if (R39cell34 != null) {
				R39cell34.setCellValue(brf94b.getR39_amount_financial_investment_sme() == null ? 0
						: brf94b.getR39_amount_financial_investment_sme().intValue());
			}
			Cell R39cell35 = R39row.getCell(37);
			if (R39cell35 != null) {
				R39cell35.setCellValue(brf94b.getR39_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR39_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R39cell36 = R39row.getCell(38);
			if (R39cell36 != null) {
				R39cell36.setCellValue(brf94b.getR39_amount_direct_investment_sme() == null ? 0
						: brf94b.getR39_amount_direct_investment_sme().intValue());
			}
			Cell R39cell37 = R39row.getCell(39);
			if (R39cell37 != null) {
				R39cell37.setCellValue(brf94b.getR39_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR39_no_of_transactions_services_sme().intValue());
			}
			Cell R39cell38 = R39row.getCell(40);
			if (R39cell38 != null) {
				R39cell38.setCellValue(brf94b.getR39_amount_services_sme() == null ? 0
						: brf94b.getR39_amount_services_sme().intValue());
			}
			Cell R39cell39 = R39row.getCell(41);
			if (R39cell39 != null) {
				R39cell39.setCellValue(brf94b.getR39_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR39_no_of_transactions_trade_sme().intValue());
			}
			Cell R39cell40 = R39row.getCell(42);
			if (R39cell40 != null) {
				R39cell40.setCellValue(
						brf94b.getR39_amount_trade_sme() == null ? 0 : brf94b.getR39_amount_trade_sme().intValue());
			}
			Cell R39cell41 = R39row.getCell(43);
			if (R39cell41 != null) {
				R39cell41.setCellValue(brf94b.getR39_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R39cell42 = R39row.getCell(44);
			if (R39cell42 != null) {
				R39cell42.setCellValue(brf94b.getR39_amount_financial_investment_individual() == null ? 0
						: brf94b.getR39_amount_financial_investment_individual().intValue());
			}
			Cell R39cell43 = R39row.getCell(45);
			if (R39cell43 != null) {
				R39cell43.setCellValue(brf94b.getR39_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R39cell44 = R39row.getCell(46);
			if (R39cell44 != null) {
				R39cell44.setCellValue(brf94b.getR39_amount_direct_investment_individual() == null ? 0
						: brf94b.getR39_amount_direct_investment_individual().intValue());
			}
			Cell R39cell45 = R39row.getCell(47);
			if (R39cell45 != null) {
				R39cell45.setCellValue(brf94b.getR39_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_family_support_individual().intValue());
			}
			Cell R39cell46 = R39row.getCell(48);
			if (R39cell46 != null) {
				R39cell46.setCellValue(brf94b.getR39_amount_family_support_individual() == null ? 0
						: brf94b.getR39_amount_family_support_individual().intValue());
			}
			Cell R39cell47 = R39row.getCell(49);
			if (R39cell47 != null) {
				R39cell47.setCellValue(brf94b.getR39_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_education_individual().intValue());
			}
			Cell R39cell48 = R39row.getCell(50);
			if (R39cell48 != null) {
				R39cell48.setCellValue(brf94b.getR39_amount_education_individual() == null ? 0
						: brf94b.getR39_amount_education_individual().intValue());
			}
			Cell R39cell49 = R39row.getCell(51);
			if (R39cell49 != null) {
				R39cell49.setCellValue(brf94b.getR39_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_medical_individual().intValue());
			}

			Cell R39cell50 = R39row.getCell(52);
			if (R39cell50 != null) {
				R39cell50.setCellValue(brf94b.getR39_amount_medical_individual() == null ? 0
						: brf94b.getR39_amount_medical_individual().intValue());
			}
			Cell R39cell51 = R39row.getCell(53);
			if (R39cell51 != null) {
				R39cell51.setCellValue(brf94b.getR39_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_tourism_individual().intValue());
			}
			Cell R39cell52 = R39row.getCell(54);
			if (R39cell52 != null) {
				R39cell52.setCellValue(brf94b.getR39_amount_tourism_individual() == null ? 0
						: brf94b.getR39_amount_tourism_individual().intValue());
			}
			Cell R39cell53 = R39row.getCell(55);
			if (R39cell53 != null) {
				R39cell53.setCellValue(brf94b.getR39_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R39cell54 = R39row.getCell(56);
			if (R39cell54 != null) {
				R39cell54.setCellValue(brf94b.getR39_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR39_amount_debt_settlement_individual().intValue());
			}
			Cell R39cell55 = R39row.getCell(57);
			if (R39cell55 != null) {
				R39cell55.setCellValue(brf94b.getR39_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR39_no_of_transactions_other_services_individual().intValue());
			}

			Cell R39cell56 = R39row.getCell(58);
			if (R39cell56 != null) {
				R39cell56.setCellValue(brf94b.getR39_amount_other_services_individual() == null ? 0
						: brf94b.getR39_amount_other_services_individual().intValue());
			}

			Row R40row = sheet.getRow(48);
			Cell R40cell1 = R40row.getCell(3);
			if (R40cell1 != null) {
				R40cell1.setCellValue(brf94b.getR40_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR40_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R40cell2 = R40row.getCell(4);
			if (R40cell2 != null) {
				R40cell2.setCellValue(brf94b.getR40_amount_financial_investment_government() == null ? 0
						: brf94b.getR40_amount_financial_investment_government().intValue());
			}
			Cell R40cell3 = R40row.getCell(5);
			if (R40cell3 != null) {
				R40cell3.setCellValue(brf94b.getR40_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR40_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R40cell4 = R40row.getCell(6);
			if (R40cell4 != null) {
				R40cell4.setCellValue(brf94b.getR40_amount_direct_investment_government() == null ? 0
						: brf94b.getR40_amount_direct_investment_government().intValue());
			}
			Cell R40cell5 = R40row.getCell(7);
			if (R40cell5 != null) {
				R40cell5.setCellValue(brf94b.getR40_no_of_transactions_services_government() == null ? 0
						: brf94b.getR40_no_of_transactions_services_government().intValue());
			}
			Cell R40cell6 = R40row.getCell(8);
			if (R40cell6 != null) {
				R40cell6.setCellValue(brf94b.getR40_amount_services_government() == null ? 0
						: brf94b.getR40_amount_services_government().intValue());
			}
			Cell R40cell7 = R40row.getCell(9);
			if (R40cell7 != null) {
				R40cell7.setCellValue(brf94b.getR40_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR40_no_of_transactions_trade_government().intValue());
			}
			Cell R40cell8 = R40row.getCell(10);
			if (R40cell8 != null) {
				R40cell8.setCellValue(brf94b.getR40_amount_trade_government() == null ? 0
						: brf94b.getR40_amount_trade_government().intValue());
			}
			Cell R40cell9 = R40row.getCell(11);
			if (R40cell9 != null) {
				R40cell9.setCellValue(brf94b.getR40_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR40_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R40cell10 = R40row.getCell(12);
			if (R40cell10 != null) {
				R40cell10.setCellValue(brf94b.getR40_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR40_amount_financial_investment_reserve().intValue());
			}
			Cell R40cell11 = R40row.getCell(13);
			if (R40cell11 != null) {
				R40cell11.setCellValue(brf94b.getR40_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR40_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R40cell12 = R40row.getCell(14);
			if (R40cell12 != null) {
				R40cell12.setCellValue(brf94b.getR40_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR40_amount_direct_investment_reserve().intValue());
			}
			Cell R40cell13 = R40row.getCell(15);
			if (R40cell13 != null) {
				R40cell13.setCellValue(brf94b.getR40_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR40_no_of_transactions_services_reserve().intValue());
			}
			Cell R40cell14 = R40row.getCell(16);
			if (R40cell14 != null) {
				R40cell14.setCellValue(brf94b.getR40_amount_services_reserve() == null ? 0
						: brf94b.getR40_amount_services_reserve().intValue());
			}
			Cell R40cell15 = R40row.getCell(17);
			if (R40cell15 != null) {
				R40cell15.setCellValue(brf94b.getR40_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR40_no_of_transactions_trade_reserve().intValue());
			}
			Cell R40cell16 = R40row.getCell(18);
			if (R40cell16 != null) {
				R40cell16.setCellValue(brf94b.getR40_amount_trade_reserve() == null ? 0
						: brf94b.getR40_amount_trade_reserve().intValue());
			}
			Cell R40cell17 = R40row.getCell(19);
			if (R40cell17 != null) {
				R40cell17.setCellValue(brf94b.getR40_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR40_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R40cell18 = R40row.getCell(20);
			if (R40cell18 != null) {
				R40cell18.setCellValue(brf94b.getR40_amount_financial_investment_gre() == null ? 0
						: brf94b.getR40_amount_financial_investment_gre().intValue());
			}
			Cell R40cell19 = R40row.getCell(21);
			if (R40cell19 != null) {
				R40cell19.setCellValue(brf94b.getR40_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR40_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R40cell20 = R40row.getCell(22);
			if (R40cell20 != null) {
				R40cell20.setCellValue(brf94b.getR40_amount_direct_investment_gre() == null ? 0
						: brf94b.getR40_amount_direct_investment_gre().intValue());
			}
			Cell R40cell21 = R40row.getCell(23);
			if (R40cell21 != null) {
				R40cell21.setCellValue(brf94b.getR40_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR40_no_of_transactions_services_gre().intValue());
			}
			Cell R40cell22 = R40row.getCell(24);
			if (R40cell22 != null) {
				R40cell22.setCellValue(brf94b.getR40_amount_services_gre() == null ? 0
						: brf94b.getR40_amount_services_gre().intValue());
			}
			Cell R40cell23 = R40row.getCell(25);
			if (R40cell23 != null) {
				R40cell23.setCellValue(brf94b.getR40_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR40_no_of_transactions_trade_gre().intValue());
			}
			Cell R40cell24 = R40row.getCell(26);
			if (R40cell24 != null) {
				R40cell24.setCellValue(
						brf94b.getR40_amount_trade_gre() == null ? 0 : brf94b.getR40_amount_trade_gre().intValue());
			}
			Cell R40cell25 = R40row.getCell(27);
			if (R40cell25 != null) {
				R40cell25.setCellValue(brf94b.getR40_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR40_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R40cell26 = R40row.getCell(28);
			if (R40cell26 != null) {
				R40cell26.setCellValue(brf94b.getR40_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR40_amount_financial_investment_corporate().intValue());
			}
			Cell R40cell27 = R40row.getCell(29);
			if (R40cell27 != null) {
				R40cell27.setCellValue(brf94b.getR40_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR40_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R40cell28 = R40row.getCell(30);
			if (R40cell28 != null) {
				R40cell28.setCellValue(brf94b.getR40_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR40_amount_direct_investment_corporate().intValue());
			}
			Cell R40cell29 = R40row.getCell(31);
			if (R40cell29 != null) {
				R40cell29.setCellValue(brf94b.getR40_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR40_no_of_transactions_services_corporate().intValue());
			}
			Cell R40cell30 = R40row.getCell(32);
			if (R40cell30 != null) {
				R40cell30.setCellValue(brf94b.getR40_amount_services_corporate() == null ? 0
						: brf94b.getR40_amount_services_corporate().intValue());
			}
			Cell R40cell31 = R40row.getCell(33);
			if (R40cell31 != null) {
				R40cell31.setCellValue(brf94b.getR40_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR40_no_of_transactions_trade_corporate().intValue());
			}
			Cell R40cell32 = R40row.getCell(34);
			if (R40cell32 != null) {
				R40cell32.setCellValue(brf94b.getR40_amount_trade_corporate() == null ? 0
						: brf94b.getR40_amount_trade_corporate().intValue());
			}
			Cell R40cell33 = R40row.getCell(35);
			if (R40cell33 != null) {
				R40cell33.setCellValue(brf94b.getR40_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR40_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R40cell34 = R40row.getCell(36);
			if (R40cell34 != null) {
				R40cell34.setCellValue(brf94b.getR40_amount_financial_investment_sme() == null ? 0
						: brf94b.getR40_amount_financial_investment_sme().intValue());
			}
			Cell R40cell35 = R40row.getCell(37);
			if (R40cell35 != null) {
				R40cell35.setCellValue(brf94b.getR40_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR40_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R40cell36 = R40row.getCell(38);
			if (R40cell36 != null) {
				R40cell36.setCellValue(brf94b.getR40_amount_direct_investment_sme() == null ? 0
						: brf94b.getR40_amount_direct_investment_sme().intValue());
			}
			Cell R40cell37 = R40row.getCell(39);
			if (R40cell37 != null) {
				R40cell37.setCellValue(brf94b.getR40_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR40_no_of_transactions_services_sme().intValue());
			}
			Cell R40cell38 = R40row.getCell(40);
			if (R40cell38 != null) {
				R40cell38.setCellValue(brf94b.getR40_amount_services_sme() == null ? 0
						: brf94b.getR40_amount_services_sme().intValue());
			}
			Cell R40cell39 = R40row.getCell(41);
			if (R40cell39 != null) {
				R40cell39.setCellValue(brf94b.getR40_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR40_no_of_transactions_trade_sme().intValue());
			}
			Cell R40cell40 = R40row.getCell(42);
			if (R40cell40 != null) {
				R40cell40.setCellValue(
						brf94b.getR40_amount_trade_sme() == null ? 0 : brf94b.getR40_amount_trade_sme().intValue());
			}
			Cell R40cell41 = R40row.getCell(43);
			if (R40cell41 != null) {
				R40cell41.setCellValue(brf94b.getR40_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R40cell42 = R40row.getCell(44);
			if (R40cell42 != null) {
				R40cell42.setCellValue(brf94b.getR40_amount_financial_investment_individual() == null ? 0
						: brf94b.getR40_amount_financial_investment_individual().intValue());
			}
			Cell R40cell43 = R40row.getCell(45);
			if (R40cell43 != null) {
				R40cell43.setCellValue(brf94b.getR40_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R40cell44 = R40row.getCell(46);
			if (R40cell44 != null) {
				R40cell44.setCellValue(brf94b.getR40_amount_direct_investment_individual() == null ? 0
						: brf94b.getR40_amount_direct_investment_individual().intValue());
			}
			Cell R40cell45 = R40row.getCell(47);
			if (R40cell45 != null) {
				R40cell45.setCellValue(brf94b.getR40_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_family_support_individual().intValue());
			}
			Cell R40cell46 = R40row.getCell(48);
			if (R40cell46 != null) {
				R40cell46.setCellValue(brf94b.getR40_amount_family_support_individual() == null ? 0
						: brf94b.getR40_amount_family_support_individual().intValue());
			}
			Cell R40cell47 = R40row.getCell(49);
			if (R40cell47 != null) {
				R40cell47.setCellValue(brf94b.getR40_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_education_individual().intValue());
			}
			Cell R40cell48 = R40row.getCell(50);
			if (R40cell48 != null) {
				R40cell48.setCellValue(brf94b.getR40_amount_education_individual() == null ? 0
						: brf94b.getR40_amount_education_individual().intValue());
			}
			Cell R40cell49 = R40row.getCell(51);
			if (R40cell49 != null) {
				R40cell49.setCellValue(brf94b.getR40_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_medical_individual().intValue());
			}

			Cell R40cell50 = R40row.getCell(52);
			if (R40cell50 != null) {
				R40cell50.setCellValue(brf94b.getR40_amount_medical_individual() == null ? 0
						: brf94b.getR40_amount_medical_individual().intValue());
			}
			Cell R40cell51 = R40row.getCell(53);
			if (R40cell51 != null) {
				R40cell51.setCellValue(brf94b.getR40_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_tourism_individual().intValue());
			}
			Cell R40cell52 = R40row.getCell(54);
			if (R40cell52 != null) {
				R40cell52.setCellValue(brf94b.getR40_amount_tourism_individual() == null ? 0
						: brf94b.getR40_amount_tourism_individual().intValue());
			}
			Cell R40cell53 = R40row.getCell(55);
			if (R40cell53 != null) {
				R40cell53.setCellValue(brf94b.getR40_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R40cell54 = R40row.getCell(56);
			if (R40cell54 != null) {
				R40cell54.setCellValue(brf94b.getR40_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR40_amount_debt_settlement_individual().intValue());
			}
			Cell R40cell55 = R40row.getCell(57);
			if (R40cell55 != null) {
				R40cell55.setCellValue(brf94b.getR40_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR40_no_of_transactions_other_services_individual().intValue());
			}

			Cell R40cell56 = R40row.getCell(58);
			if (R40cell56 != null) {
				R40cell56.setCellValue(brf94b.getR40_amount_other_services_individual() == null ? 0
						: brf94b.getR40_amount_other_services_individual().intValue());
			}

			Row R41row = sheet.getRow(49);
			Cell R41cell1 = R41row.getCell(3);
			if (R41cell1 != null) {
				R41cell1.setCellValue(brf94b.getR41_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR41_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R41cell2 = R41row.getCell(4);
			if (R41cell2 != null) {
				R41cell2.setCellValue(brf94b.getR41_amount_financial_investment_government() == null ? 0
						: brf94b.getR41_amount_financial_investment_government().intValue());
			}
			Cell R41cell3 = R41row.getCell(5);
			if (R41cell3 != null) {
				R41cell3.setCellValue(brf94b.getR41_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR41_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R41cell4 = R41row.getCell(6);
			if (R41cell4 != null) {
				R41cell4.setCellValue(brf94b.getR41_amount_direct_investment_government() == null ? 0
						: brf94b.getR41_amount_direct_investment_government().intValue());
			}
			Cell R41cell5 = R41row.getCell(7);
			if (R41cell5 != null) {
				R41cell5.setCellValue(brf94b.getR41_no_of_transactions_services_government() == null ? 0
						: brf94b.getR41_no_of_transactions_services_government().intValue());
			}
			Cell R41cell6 = R41row.getCell(8);
			if (R41cell6 != null) {
				R41cell6.setCellValue(brf94b.getR41_amount_services_government() == null ? 0
						: brf94b.getR41_amount_services_government().intValue());
			}
			Cell R41cell7 = R41row.getCell(9);
			if (R41cell7 != null) {
				R41cell7.setCellValue(brf94b.getR41_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR41_no_of_transactions_trade_government().intValue());
			}
			Cell R41cell8 = R41row.getCell(10);
			if (R41cell8 != null) {
				R41cell8.setCellValue(brf94b.getR41_amount_trade_government() == null ? 0
						: brf94b.getR41_amount_trade_government().intValue());
			}
			Cell R41cell9 = R41row.getCell(11);
			if (R41cell9 != null) {
				R41cell9.setCellValue(brf94b.getR41_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR41_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R41cell10 = R41row.getCell(12);
			if (R41cell10 != null) {
				R41cell10.setCellValue(brf94b.getR41_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR41_amount_financial_investment_reserve().intValue());
			}
			Cell R41cell11 = R41row.getCell(13);
			if (R41cell11 != null) {
				R41cell11.setCellValue(brf94b.getR41_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR41_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R41cell12 = R41row.getCell(14);
			if (R41cell12 != null) {
				R41cell12.setCellValue(brf94b.getR41_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR41_amount_direct_investment_reserve().intValue());
			}
			Cell R41cell13 = R41row.getCell(15);
			if (R41cell13 != null) {
				R41cell13.setCellValue(brf94b.getR41_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR41_no_of_transactions_services_reserve().intValue());
			}
			Cell R41cell14 = R41row.getCell(16);
			if (R41cell14 != null) {
				R41cell14.setCellValue(brf94b.getR41_amount_services_reserve() == null ? 0
						: brf94b.getR41_amount_services_reserve().intValue());
			}
			Cell R41cell15 = R41row.getCell(17);
			if (R41cell15 != null) {
				R41cell15.setCellValue(brf94b.getR41_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR41_no_of_transactions_trade_reserve().intValue());
			}
			Cell R41cell16 = R41row.getCell(18);
			if (R41cell16 != null) {
				R41cell16.setCellValue(brf94b.getR41_amount_trade_reserve() == null ? 0
						: brf94b.getR41_amount_trade_reserve().intValue());
			}
			Cell R41cell17 = R41row.getCell(19);
			if (R41cell17 != null) {
				R41cell17.setCellValue(brf94b.getR41_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR41_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R41cell18 = R41row.getCell(20);
			if (R41cell18 != null) {
				R41cell18.setCellValue(brf94b.getR41_amount_financial_investment_gre() == null ? 0
						: brf94b.getR41_amount_financial_investment_gre().intValue());
			}
			Cell R41cell19 = R41row.getCell(21);
			if (R41cell19 != null) {
				R41cell19.setCellValue(brf94b.getR41_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR41_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R41cell20 = R41row.getCell(22);
			if (R41cell20 != null) {
				R41cell20.setCellValue(brf94b.getR41_amount_direct_investment_gre() == null ? 0
						: brf94b.getR41_amount_direct_investment_gre().intValue());
			}
			Cell R41cell21 = R41row.getCell(23);
			if (R41cell21 != null) {
				R41cell21.setCellValue(brf94b.getR41_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR41_no_of_transactions_services_gre().intValue());
			}
			Cell R41cell22 = R41row.getCell(24);
			if (R41cell22 != null) {
				R41cell22.setCellValue(brf94b.getR41_amount_services_gre() == null ? 0
						: brf94b.getR41_amount_services_gre().intValue());
			}
			Cell R41cell23 = R41row.getCell(25);
			if (R41cell23 != null) {
				R41cell23.setCellValue(brf94b.getR41_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR41_no_of_transactions_trade_gre().intValue());
			}
			Cell R41cell24 = R41row.getCell(26);
			if (R41cell24 != null) {
				R41cell24.setCellValue(
						brf94b.getR41_amount_trade_gre() == null ? 0 : brf94b.getR41_amount_trade_gre().intValue());
			}
			Cell R41cell25 = R41row.getCell(27);
			if (R41cell25 != null) {
				R41cell25.setCellValue(brf94b.getR41_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR41_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R41cell26 = R41row.getCell(28);
			if (R41cell26 != null) {
				R41cell26.setCellValue(brf94b.getR41_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR41_amount_financial_investment_corporate().intValue());
			}
			Cell R41cell27 = R41row.getCell(29);
			if (R41cell27 != null) {
				R41cell27.setCellValue(brf94b.getR41_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR41_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R41cell28 = R41row.getCell(30);
			if (R41cell28 != null) {
				R41cell28.setCellValue(brf94b.getR41_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR41_amount_direct_investment_corporate().intValue());
			}
			Cell R41cell29 = R41row.getCell(31);
			if (R41cell29 != null) {
				R41cell29.setCellValue(brf94b.getR41_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR41_no_of_transactions_services_corporate().intValue());
			}
			Cell R41cell30 = R41row.getCell(32);
			if (R41cell30 != null) {
				R41cell30.setCellValue(brf94b.getR41_amount_services_corporate() == null ? 0
						: brf94b.getR41_amount_services_corporate().intValue());
			}
			Cell R41cell31 = R41row.getCell(33);
			if (R41cell31 != null) {
				R41cell31.setCellValue(brf94b.getR41_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR41_no_of_transactions_trade_corporate().intValue());
			}
			Cell R41cell32 = R41row.getCell(34);
			if (R41cell32 != null) {
				R41cell32.setCellValue(brf94b.getR41_amount_trade_corporate() == null ? 0
						: brf94b.getR41_amount_trade_corporate().intValue());
			}
			Cell R41cell33 = R41row.getCell(35);
			if (R41cell33 != null) {
				R41cell33.setCellValue(brf94b.getR41_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR41_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R41cell34 = R41row.getCell(36);
			if (R41cell34 != null) {
				R41cell34.setCellValue(brf94b.getR41_amount_financial_investment_sme() == null ? 0
						: brf94b.getR41_amount_financial_investment_sme().intValue());
			}
			Cell R41cell35 = R41row.getCell(37);
			if (R41cell35 != null) {
				R41cell35.setCellValue(brf94b.getR41_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR41_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R41cell36 = R41row.getCell(38);
			if (R41cell36 != null) {
				R41cell36.setCellValue(brf94b.getR41_amount_direct_investment_sme() == null ? 0
						: brf94b.getR41_amount_direct_investment_sme().intValue());
			}
			Cell R41cell37 = R41row.getCell(39);
			if (R41cell37 != null) {
				R41cell37.setCellValue(brf94b.getR41_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR41_no_of_transactions_services_sme().intValue());
			}
			Cell R41cell38 = R41row.getCell(40);
			if (R41cell38 != null) {
				R41cell38.setCellValue(brf94b.getR41_amount_services_sme() == null ? 0
						: brf94b.getR41_amount_services_sme().intValue());
			}
			Cell R41cell39 = R41row.getCell(41);
			if (R41cell39 != null) {
				R41cell39.setCellValue(brf94b.getR41_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR41_no_of_transactions_trade_sme().intValue());
			}
			Cell R41cell40 = R41row.getCell(42);
			if (R41cell40 != null) {
				R41cell40.setCellValue(
						brf94b.getR41_amount_trade_sme() == null ? 0 : brf94b.getR41_amount_trade_sme().intValue());
			}
			Cell R41cell41 = R41row.getCell(43);
			if (R41cell41 != null) {
				R41cell41.setCellValue(brf94b.getR41_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R41cell42 = R41row.getCell(44);
			if (R41cell42 != null) {
				R41cell42.setCellValue(brf94b.getR41_amount_financial_investment_individual() == null ? 0
						: brf94b.getR41_amount_financial_investment_individual().intValue());
			}
			Cell R41cell43 = R41row.getCell(45);
			if (R41cell43 != null) {
				R41cell43.setCellValue(brf94b.getR41_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R41cell44 = R41row.getCell(46);
			if (R41cell44 != null) {
				R41cell44.setCellValue(brf94b.getR41_amount_direct_investment_individual() == null ? 0
						: brf94b.getR41_amount_direct_investment_individual().intValue());
			}
			Cell R41cell45 = R41row.getCell(47);
			if (R41cell45 != null) {
				R41cell45.setCellValue(brf94b.getR41_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_family_support_individual().intValue());
			}
			Cell R41cell46 = R41row.getCell(48);
			if (R41cell46 != null) {
				R41cell46.setCellValue(brf94b.getR41_amount_family_support_individual() == null ? 0
						: brf94b.getR41_amount_family_support_individual().intValue());
			}
			Cell R41cell47 = R41row.getCell(49);
			if (R41cell47 != null) {
				R41cell47.setCellValue(brf94b.getR41_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_education_individual().intValue());
			}
			Cell R41cell48 = R41row.getCell(50);
			if (R41cell48 != null) {
				R41cell48.setCellValue(brf94b.getR41_amount_education_individual() == null ? 0
						: brf94b.getR41_amount_education_individual().intValue());
			}
			Cell R41cell49 = R41row.getCell(51);
			if (R41cell49 != null) {
				R41cell49.setCellValue(brf94b.getR41_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_medical_individual().intValue());
			}

			Cell R41cell50 = R41row.getCell(52);
			if (R41cell50 != null) {
				R41cell50.setCellValue(brf94b.getR41_amount_medical_individual() == null ? 0
						: brf94b.getR41_amount_medical_individual().intValue());
			}
			Cell R41cell51 = R41row.getCell(53);
			if (R41cell51 != null) {
				R41cell51.setCellValue(brf94b.getR41_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_tourism_individual().intValue());
			}
			Cell R41cell52 = R41row.getCell(54);
			if (R41cell52 != null) {
				R41cell52.setCellValue(brf94b.getR41_amount_tourism_individual() == null ? 0
						: brf94b.getR41_amount_tourism_individual().intValue());
			}
			Cell R41cell53 = R41row.getCell(55);
			if (R41cell53 != null) {
				R41cell53.setCellValue(brf94b.getR41_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R41cell54 = R41row.getCell(56);
			if (R41cell54 != null) {
				R41cell54.setCellValue(brf94b.getR41_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR41_amount_debt_settlement_individual().intValue());
			}
			Cell R41cell55 = R41row.getCell(57);
			if (R41cell55 != null) {
				R41cell55.setCellValue(brf94b.getR41_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR41_no_of_transactions_other_services_individual().intValue());
			}

			Cell R41cell56 = R41row.getCell(58);
			if (R41cell56 != null) {
				R41cell56.setCellValue(brf94b.getR41_amount_other_services_individual() == null ? 0
						: brf94b.getR41_amount_other_services_individual().intValue());
			}

			Row R42row = sheet.getRow(50);
			Cell R42cell1 = R42row.getCell(3);
			if (R42cell1 != null) {
				R42cell1.setCellValue(brf94b.getR42_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR42_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R42cell2 = R42row.getCell(4);
			if (R42cell2 != null) {
				R42cell2.setCellValue(brf94b.getR42_amount_financial_investment_government() == null ? 0
						: brf94b.getR42_amount_financial_investment_government().intValue());
			}
			Cell R42cell3 = R42row.getCell(5);
			if (R42cell3 != null) {
				R42cell3.setCellValue(brf94b.getR42_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR42_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R42cell4 = R42row.getCell(6);
			if (R42cell4 != null) {
				R42cell4.setCellValue(brf94b.getR42_amount_direct_investment_government() == null ? 0
						: brf94b.getR42_amount_direct_investment_government().intValue());
			}
			Cell R42cell5 = R42row.getCell(7);
			if (R42cell5 != null) {
				R42cell5.setCellValue(brf94b.getR42_no_of_transactions_services_government() == null ? 0
						: brf94b.getR42_no_of_transactions_services_government().intValue());
			}
			Cell R42cell6 = R42row.getCell(8);
			if (R42cell6 != null) {
				R42cell6.setCellValue(brf94b.getR42_amount_services_government() == null ? 0
						: brf94b.getR42_amount_services_government().intValue());
			}
			Cell R42cell7 = R42row.getCell(9);
			if (R42cell7 != null) {
				R42cell7.setCellValue(brf94b.getR42_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR42_no_of_transactions_trade_government().intValue());
			}
			Cell R42cell8 = R42row.getCell(10);
			if (R42cell8 != null) {
				R42cell8.setCellValue(brf94b.getR42_amount_trade_government() == null ? 0
						: brf94b.getR42_amount_trade_government().intValue());
			}
			Cell R42cell9 = R42row.getCell(11);
			if (R42cell9 != null) {
				R42cell9.setCellValue(brf94b.getR42_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR42_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R42cell10 = R42row.getCell(12);
			if (R42cell10 != null) {
				R42cell10.setCellValue(brf94b.getR42_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR42_amount_financial_investment_reserve().intValue());
			}
			Cell R42cell11 = R42row.getCell(13);
			if (R42cell11 != null) {
				R42cell11.setCellValue(brf94b.getR42_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR42_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R42cell12 = R42row.getCell(14);
			if (R42cell12 != null) {
				R42cell12.setCellValue(brf94b.getR42_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR42_amount_direct_investment_reserve().intValue());
			}
			Cell R42cell13 = R42row.getCell(15);
			if (R42cell13 != null) {
				R42cell13.setCellValue(brf94b.getR42_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR42_no_of_transactions_services_reserve().intValue());
			}
			Cell R42cell14 = R42row.getCell(16);
			if (R42cell14 != null) {
				R42cell14.setCellValue(brf94b.getR42_amount_services_reserve() == null ? 0
						: brf94b.getR42_amount_services_reserve().intValue());
			}
			Cell R42cell15 = R42row.getCell(17);
			if (R42cell15 != null) {
				R42cell15.setCellValue(brf94b.getR42_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR42_no_of_transactions_trade_reserve().intValue());
			}
			Cell R42cell16 = R42row.getCell(18);
			if (R42cell16 != null) {
				R42cell16.setCellValue(brf94b.getR42_amount_trade_reserve() == null ? 0
						: brf94b.getR42_amount_trade_reserve().intValue());
			}
			Cell R42cell17 = R42row.getCell(19);
			if (R42cell17 != null) {
				R42cell17.setCellValue(brf94b.getR42_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR42_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R42cell18 = R42row.getCell(20);
			if (R42cell18 != null) {
				R42cell18.setCellValue(brf94b.getR42_amount_financial_investment_gre() == null ? 0
						: brf94b.getR42_amount_financial_investment_gre().intValue());
			}
			Cell R42cell19 = R42row.getCell(21);
			if (R42cell19 != null) {
				R42cell19.setCellValue(brf94b.getR42_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR42_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R42cell20 = R42row.getCell(22);
			if (R42cell20 != null) {
				R42cell20.setCellValue(brf94b.getR42_amount_direct_investment_gre() == null ? 0
						: brf94b.getR42_amount_direct_investment_gre().intValue());
			}
			Cell R42cell21 = R42row.getCell(23);
			if (R42cell21 != null) {
				R42cell21.setCellValue(brf94b.getR42_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR42_no_of_transactions_services_gre().intValue());
			}
			Cell R42cell22 = R42row.getCell(24);
			if (R42cell22 != null) {
				R42cell22.setCellValue(brf94b.getR42_amount_services_gre() == null ? 0
						: brf94b.getR42_amount_services_gre().intValue());
			}
			Cell R42cell23 = R42row.getCell(25);
			if (R42cell23 != null) {
				R42cell23.setCellValue(brf94b.getR42_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR42_no_of_transactions_trade_gre().intValue());
			}
			Cell R42cell24 = R42row.getCell(26);
			if (R42cell24 != null) {
				R42cell24.setCellValue(
						brf94b.getR42_amount_trade_gre() == null ? 0 : brf94b.getR42_amount_trade_gre().intValue());
			}
			Cell R42cell25 = R42row.getCell(27);
			if (R42cell25 != null) {
				R42cell25.setCellValue(brf94b.getR42_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR42_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R42cell26 = R42row.getCell(28);
			if (R42cell26 != null) {
				R42cell26.setCellValue(brf94b.getR42_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR42_amount_financial_investment_corporate().intValue());
			}
			Cell R42cell27 = R42row.getCell(29);
			if (R42cell27 != null) {
				R42cell27.setCellValue(brf94b.getR42_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR42_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R42cell28 = R42row.getCell(30);
			if (R42cell28 != null) {
				R42cell28.setCellValue(brf94b.getR42_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR42_amount_direct_investment_corporate().intValue());
			}
			Cell R42cell29 = R42row.getCell(31);
			if (R42cell29 != null) {
				R42cell29.setCellValue(brf94b.getR42_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR42_no_of_transactions_services_corporate().intValue());
			}
			Cell R42cell30 = R42row.getCell(32);
			if (R42cell30 != null) {
				R42cell30.setCellValue(brf94b.getR42_amount_services_corporate() == null ? 0
						: brf94b.getR42_amount_services_corporate().intValue());
			}
			Cell R42cell31 = R42row.getCell(33);
			if (R42cell31 != null) {
				R42cell31.setCellValue(brf94b.getR42_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR42_no_of_transactions_trade_corporate().intValue());
			}
			Cell R42cell32 = R42row.getCell(34);
			if (R42cell32 != null) {
				R42cell32.setCellValue(brf94b.getR42_amount_trade_corporate() == null ? 0
						: brf94b.getR42_amount_trade_corporate().intValue());
			}
			Cell R42cell33 = R42row.getCell(35);
			if (R42cell33 != null) {
				R42cell33.setCellValue(brf94b.getR42_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR42_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R42cell34 = R42row.getCell(36);
			if (R42cell34 != null) {
				R42cell34.setCellValue(brf94b.getR42_amount_financial_investment_sme() == null ? 0
						: brf94b.getR42_amount_financial_investment_sme().intValue());
			}
			Cell R42cell35 = R42row.getCell(37);
			if (R42cell35 != null) {
				R42cell35.setCellValue(brf94b.getR42_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR42_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R42cell36 = R42row.getCell(38);
			if (R42cell36 != null) {
				R42cell36.setCellValue(brf94b.getR42_amount_direct_investment_sme() == null ? 0
						: brf94b.getR42_amount_direct_investment_sme().intValue());
			}
			Cell R42cell37 = R42row.getCell(39);
			if (R42cell37 != null) {
				R42cell37.setCellValue(brf94b.getR42_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR42_no_of_transactions_services_sme().intValue());
			}
			Cell R42cell38 = R42row.getCell(40);
			if (R42cell38 != null) {
				R42cell38.setCellValue(brf94b.getR42_amount_services_sme() == null ? 0
						: brf94b.getR42_amount_services_sme().intValue());
			}
			Cell R42cell39 = R42row.getCell(41);
			if (R42cell39 != null) {
				R42cell39.setCellValue(brf94b.getR42_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR42_no_of_transactions_trade_sme().intValue());
			}
			Cell R42cell40 = R42row.getCell(42);
			if (R42cell40 != null) {
				R42cell40.setCellValue(
						brf94b.getR42_amount_trade_sme() == null ? 0 : brf94b.getR42_amount_trade_sme().intValue());
			}
			Cell R42cell41 = R42row.getCell(43);
			if (R42cell41 != null) {
				R42cell41.setCellValue(brf94b.getR42_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R42cell42 = R42row.getCell(44);
			if (R42cell42 != null) {
				R42cell42.setCellValue(brf94b.getR42_amount_financial_investment_individual() == null ? 0
						: brf94b.getR42_amount_financial_investment_individual().intValue());
			}
			Cell R42cell43 = R42row.getCell(45);
			if (R42cell43 != null) {
				R42cell43.setCellValue(brf94b.getR42_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R42cell44 = R42row.getCell(46);
			if (R42cell44 != null) {
				R42cell44.setCellValue(brf94b.getR42_amount_direct_investment_individual() == null ? 0
						: brf94b.getR42_amount_direct_investment_individual().intValue());
			}
			Cell R42cell45 = R42row.getCell(47);
			if (R42cell45 != null) {
				R42cell45.setCellValue(brf94b.getR42_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_family_support_individual().intValue());
			}
			Cell R42cell46 = R42row.getCell(48);
			if (R42cell46 != null) {
				R42cell46.setCellValue(brf94b.getR42_amount_family_support_individual() == null ? 0
						: brf94b.getR42_amount_family_support_individual().intValue());
			}
			Cell R42cell47 = R42row.getCell(49);
			if (R42cell47 != null) {
				R42cell47.setCellValue(brf94b.getR42_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_education_individual().intValue());
			}
			Cell R42cell48 = R42row.getCell(50);
			if (R42cell48 != null) {
				R42cell48.setCellValue(brf94b.getR42_amount_education_individual() == null ? 0
						: brf94b.getR42_amount_education_individual().intValue());
			}
			Cell R42cell49 = R42row.getCell(51);
			if (R42cell49 != null) {
				R42cell49.setCellValue(brf94b.getR42_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_medical_individual().intValue());
			}

			Cell R42cell50 = R42row.getCell(52);
			if (R42cell50 != null) {
				R42cell50.setCellValue(brf94b.getR42_amount_medical_individual() == null ? 0
						: brf94b.getR42_amount_medical_individual().intValue());
			}
			Cell R42cell51 = R42row.getCell(53);
			if (R42cell51 != null) {
				R42cell51.setCellValue(brf94b.getR42_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_tourism_individual().intValue());
			}
			Cell R42cell52 = R42row.getCell(54);
			if (R42cell52 != null) {
				R42cell52.setCellValue(brf94b.getR42_amount_tourism_individual() == null ? 0
						: brf94b.getR42_amount_tourism_individual().intValue());
			}
			Cell R42cell53 = R42row.getCell(55);
			if (R42cell53 != null) {
				R42cell53.setCellValue(brf94b.getR42_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R42cell54 = R42row.getCell(56);
			if (R42cell54 != null) {
				R42cell54.setCellValue(brf94b.getR42_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR42_amount_debt_settlement_individual().intValue());
			}
			Cell R42cell55 = R42row.getCell(57);
			if (R42cell55 != null) {
				R42cell55.setCellValue(brf94b.getR42_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR42_no_of_transactions_other_services_individual().intValue());
			}

			Cell R42cell56 = R42row.getCell(58);
			if (R42cell56 != null) {
				R42cell56.setCellValue(brf94b.getR42_amount_other_services_individual() == null ? 0
						: brf94b.getR42_amount_other_services_individual().intValue());
			}

			Row R44row = sheet.getRow(52);
			Cell R44cell1 = R44row.getCell(3);
			if (R44cell1 != null) {
				R44cell1.setCellValue(brf94b.getR44_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR44_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R44cell2 = R44row.getCell(4);
			if (R44cell2 != null) {
				R44cell2.setCellValue(brf94b.getR44_amount_financial_investment_government() == null ? 0
						: brf94b.getR44_amount_financial_investment_government().intValue());
			}
			Cell R44cell3 = R44row.getCell(5);
			if (R44cell3 != null) {
				R44cell3.setCellValue(brf94b.getR44_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR44_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R44cell4 = R44row.getCell(6);
			if (R44cell4 != null) {
				R44cell4.setCellValue(brf94b.getR44_amount_direct_investment_government() == null ? 0
						: brf94b.getR44_amount_direct_investment_government().intValue());
			}
			Cell R44cell5 = R44row.getCell(7);
			if (R44cell5 != null) {
				R44cell5.setCellValue(brf94b.getR44_no_of_transactions_services_government() == null ? 0
						: brf94b.getR44_no_of_transactions_services_government().intValue());
			}
			Cell R44cell6 = R44row.getCell(8);
			if (R44cell6 != null) {
				R44cell6.setCellValue(brf94b.getR44_amount_services_government() == null ? 0
						: brf94b.getR44_amount_services_government().intValue());
			}
			Cell R44cell7 = R44row.getCell(9);
			if (R44cell7 != null) {
				R44cell7.setCellValue(brf94b.getR44_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR44_no_of_transactions_trade_government().intValue());
			}
			Cell R44cell8 = R44row.getCell(10);
			if (R44cell8 != null) {
				R44cell8.setCellValue(brf94b.getR44_amount_trade_government() == null ? 0
						: brf94b.getR44_amount_trade_government().intValue());
			}
			Cell R44cell9 = R44row.getCell(11);
			if (R44cell9 != null) {
				R44cell9.setCellValue(brf94b.getR44_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR44_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R44cell10 = R44row.getCell(12);
			if (R44cell10 != null) {
				R44cell10.setCellValue(brf94b.getR44_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR44_amount_financial_investment_reserve().intValue());
			}
			Cell R44cell11 = R44row.getCell(13);
			if (R44cell11 != null) {
				R44cell11.setCellValue(brf94b.getR44_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR44_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R44cell12 = R44row.getCell(14);
			if (R44cell12 != null) {
				R44cell12.setCellValue(brf94b.getR44_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR44_amount_direct_investment_reserve().intValue());
			}
			Cell R44cell13 = R44row.getCell(15);
			if (R44cell13 != null) {
				R44cell13.setCellValue(brf94b.getR44_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR44_no_of_transactions_services_reserve().intValue());
			}
			Cell R44cell14 = R44row.getCell(16);
			if (R44cell14 != null) {
				R44cell14.setCellValue(brf94b.getR44_amount_services_reserve() == null ? 0
						: brf94b.getR44_amount_services_reserve().intValue());
			}
			Cell R44cell15 = R44row.getCell(17);
			if (R44cell15 != null) {
				R44cell15.setCellValue(brf94b.getR44_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR44_no_of_transactions_trade_reserve().intValue());
			}
			Cell R44cell16 = R44row.getCell(18);
			if (R44cell16 != null) {
				R44cell16.setCellValue(brf94b.getR44_amount_trade_reserve() == null ? 0
						: brf94b.getR44_amount_trade_reserve().intValue());
			}
			Cell R44cell17 = R44row.getCell(19);
			if (R44cell17 != null) {
				R44cell17.setCellValue(brf94b.getR44_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR44_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R44cell18 = R44row.getCell(20);
			if (R44cell18 != null) {
				R44cell18.setCellValue(brf94b.getR44_amount_financial_investment_gre() == null ? 0
						: brf94b.getR44_amount_financial_investment_gre().intValue());
			}
			Cell R44cell19 = R44row.getCell(21);
			if (R44cell19 != null) {
				R44cell19.setCellValue(brf94b.getR44_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR44_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R44cell20 = R44row.getCell(22);
			if (R44cell20 != null) {
				R44cell20.setCellValue(brf94b.getR44_amount_direct_investment_gre() == null ? 0
						: brf94b.getR44_amount_direct_investment_gre().intValue());
			}
			Cell R44cell21 = R44row.getCell(23);
			if (R44cell21 != null) {
				R44cell21.setCellValue(brf94b.getR44_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR44_no_of_transactions_services_gre().intValue());
			}
			Cell R44cell22 = R44row.getCell(24);
			if (R44cell22 != null) {
				R44cell22.setCellValue(brf94b.getR44_amount_services_gre() == null ? 0
						: brf94b.getR44_amount_services_gre().intValue());
			}
			Cell R44cell23 = R44row.getCell(25);
			if (R44cell23 != null) {
				R44cell23.setCellValue(brf94b.getR44_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR44_no_of_transactions_trade_gre().intValue());
			}
			Cell R44cell24 = R44row.getCell(26);
			if (R44cell24 != null) {
				R44cell24.setCellValue(
						brf94b.getR44_amount_trade_gre() == null ? 0 : brf94b.getR44_amount_trade_gre().intValue());
			}
			Cell R44cell25 = R44row.getCell(27);
			if (R44cell25 != null) {
				R44cell25.setCellValue(brf94b.getR44_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR44_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R44cell26 = R44row.getCell(28);
			if (R44cell26 != null) {
				R44cell26.setCellValue(brf94b.getR44_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR44_amount_financial_investment_corporate().intValue());
			}
			Cell R44cell27 = R44row.getCell(29);
			if (R44cell27 != null) {
				R44cell27.setCellValue(brf94b.getR44_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR44_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R44cell28 = R44row.getCell(30);
			if (R44cell28 != null) {
				R44cell28.setCellValue(brf94b.getR44_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR44_amount_direct_investment_corporate().intValue());
			}
			Cell R44cell29 = R44row.getCell(31);
			if (R44cell29 != null) {
				R44cell29.setCellValue(brf94b.getR44_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR44_no_of_transactions_services_corporate().intValue());
			}
			Cell R44cell30 = R44row.getCell(32);
			if (R44cell30 != null) {
				R44cell30.setCellValue(brf94b.getR44_amount_services_corporate() == null ? 0
						: brf94b.getR44_amount_services_corporate().intValue());
			}
			Cell R44cell31 = R44row.getCell(33);
			if (R44cell31 != null) {
				R44cell31.setCellValue(brf94b.getR44_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR44_no_of_transactions_trade_corporate().intValue());
			}
			Cell R44cell32 = R44row.getCell(34);
			if (R44cell32 != null) {
				R44cell32.setCellValue(brf94b.getR44_amount_trade_corporate() == null ? 0
						: brf94b.getR44_amount_trade_corporate().intValue());
			}
			Cell R44cell33 = R44row.getCell(35);
			if (R44cell33 != null) {
				R44cell33.setCellValue(brf94b.getR44_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR44_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R44cell34 = R44row.getCell(36);
			if (R44cell34 != null) {
				R44cell34.setCellValue(brf94b.getR44_amount_financial_investment_sme() == null ? 0
						: brf94b.getR44_amount_financial_investment_sme().intValue());
			}
			Cell R44cell35 = R44row.getCell(37);
			if (R44cell35 != null) {
				R44cell35.setCellValue(brf94b.getR44_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR44_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R44cell36 = R44row.getCell(38);
			if (R44cell36 != null) {
				R44cell36.setCellValue(brf94b.getR44_amount_direct_investment_sme() == null ? 0
						: brf94b.getR44_amount_direct_investment_sme().intValue());
			}
			Cell R44cell37 = R44row.getCell(39);
			if (R44cell37 != null) {
				R44cell37.setCellValue(brf94b.getR44_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR44_no_of_transactions_services_sme().intValue());
			}
			Cell R44cell38 = R44row.getCell(40);
			if (R44cell38 != null) {
				R44cell38.setCellValue(brf94b.getR44_amount_services_sme() == null ? 0
						: brf94b.getR44_amount_services_sme().intValue());
			}
			Cell R44cell39 = R44row.getCell(41);
			if (R44cell39 != null) {
				R44cell39.setCellValue(brf94b.getR44_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR44_no_of_transactions_trade_sme().intValue());
			}
			Cell R44cell40 = R44row.getCell(42);
			if (R44cell40 != null) {
				R44cell40.setCellValue(
						brf94b.getR44_amount_trade_sme() == null ? 0 : brf94b.getR44_amount_trade_sme().intValue());
			}
			Cell R44cell41 = R44row.getCell(43);
			if (R44cell41 != null) {
				R44cell41.setCellValue(brf94b.getR44_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R44cell42 = R44row.getCell(44);
			if (R44cell42 != null) {
				R44cell42.setCellValue(brf94b.getR44_amount_financial_investment_individual() == null ? 0
						: brf94b.getR44_amount_financial_investment_individual().intValue());
			}
			Cell R44cell43 = R44row.getCell(45);
			if (R44cell43 != null) {
				R44cell43.setCellValue(brf94b.getR44_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R44cell44 = R44row.getCell(46);
			if (R44cell44 != null) {
				R44cell44.setCellValue(brf94b.getR44_amount_direct_investment_individual() == null ? 0
						: brf94b.getR44_amount_direct_investment_individual().intValue());
			}
			Cell R44cell45 = R44row.getCell(47);
			if (R44cell45 != null) {
				R44cell45.setCellValue(brf94b.getR44_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_family_support_individual().intValue());
			}
			Cell R44cell46 = R44row.getCell(48);
			if (R44cell46 != null) {
				R44cell46.setCellValue(brf94b.getR44_amount_family_support_individual() == null ? 0
						: brf94b.getR44_amount_family_support_individual().intValue());
			}
			Cell R44cell47 = R44row.getCell(49);
			if (R44cell47 != null) {
				R44cell47.setCellValue(brf94b.getR44_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_education_individual().intValue());
			}
			Cell R44cell48 = R44row.getCell(50);
			if (R44cell48 != null) {
				R44cell48.setCellValue(brf94b.getR44_amount_education_individual() == null ? 0
						: brf94b.getR44_amount_education_individual().intValue());
			}
			Cell R44cell49 = R44row.getCell(51);
			if (R44cell49 != null) {
				R44cell49.setCellValue(brf94b.getR44_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_medical_individual().intValue());
			}

			Cell R44cell50 = R44row.getCell(52);
			if (R44cell50 != null) {
				R44cell50.setCellValue(brf94b.getR44_amount_medical_individual() == null ? 0
						: brf94b.getR44_amount_medical_individual().intValue());
			}
			Cell R44cell51 = R44row.getCell(53);
			if (R44cell51 != null) {
				R44cell51.setCellValue(brf94b.getR44_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_tourism_individual().intValue());
			}
			Cell R44cell52 = R44row.getCell(54);
			if (R44cell52 != null) {
				R44cell52.setCellValue(brf94b.getR44_amount_tourism_individual() == null ? 0
						: brf94b.getR44_amount_tourism_individual().intValue());
			}
			Cell R44cell53 = R44row.getCell(55);
			if (R44cell53 != null) {
				R44cell53.setCellValue(brf94b.getR44_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R44cell54 = R44row.getCell(56);
			if (R44cell54 != null) {
				R44cell54.setCellValue(brf94b.getR44_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR44_amount_debt_settlement_individual().intValue());
			}
			Cell R44cell55 = R44row.getCell(57);
			if (R44cell55 != null) {
				R44cell55.setCellValue(brf94b.getR44_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR44_no_of_transactions_other_services_individual().intValue());
			}

			Cell R44cell56 = R44row.getCell(58);
			if (R44cell56 != null) {
				R44cell56.setCellValue(brf94b.getR44_amount_other_services_individual() == null ? 0
						: brf94b.getR44_amount_other_services_individual().intValue());
			}

			Row R45row = sheet.getRow(53);
			Cell R45cell1 = R45row.getCell(3);
			if (R45cell1 != null) {
				R45cell1.setCellValue(brf94b.getR45_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR45_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R45cell2 = R45row.getCell(4);
			if (R45cell2 != null) {
				R45cell2.setCellValue(brf94b.getR45_amount_financial_investment_government() == null ? 0
						: brf94b.getR45_amount_financial_investment_government().intValue());
			}
			Cell R45cell3 = R45row.getCell(5);
			if (R45cell3 != null) {
				R45cell3.setCellValue(brf94b.getR45_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR45_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R45cell4 = R45row.getCell(6);
			if (R45cell4 != null) {
				R45cell4.setCellValue(brf94b.getR45_amount_direct_investment_government() == null ? 0
						: brf94b.getR45_amount_direct_investment_government().intValue());
			}
			Cell R45cell5 = R45row.getCell(7);
			if (R45cell5 != null) {
				R45cell5.setCellValue(brf94b.getR45_no_of_transactions_services_government() == null ? 0
						: brf94b.getR45_no_of_transactions_services_government().intValue());
			}
			Cell R45cell6 = R45row.getCell(8);
			if (R45cell6 != null) {
				R45cell6.setCellValue(brf94b.getR45_amount_services_government() == null ? 0
						: brf94b.getR45_amount_services_government().intValue());
			}
			Cell R45cell7 = R45row.getCell(9);
			if (R45cell7 != null) {
				R45cell7.setCellValue(brf94b.getR45_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR45_no_of_transactions_trade_government().intValue());
			}
			Cell R45cell8 = R45row.getCell(10);
			if (R45cell8 != null) {
				R45cell8.setCellValue(brf94b.getR45_amount_trade_government() == null ? 0
						: brf94b.getR45_amount_trade_government().intValue());
			}
			Cell R45cell9 = R45row.getCell(11);
			if (R45cell9 != null) {
				R45cell9.setCellValue(brf94b.getR45_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR45_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R45cell10 = R45row.getCell(12);
			if (R45cell10 != null) {
				R45cell10.setCellValue(brf94b.getR45_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR45_amount_financial_investment_reserve().intValue());
			}
			Cell R45cell11 = R45row.getCell(13);
			if (R45cell11 != null) {
				R45cell11.setCellValue(brf94b.getR45_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR45_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R45cell12 = R45row.getCell(14);
			if (R45cell12 != null) {
				R45cell12.setCellValue(brf94b.getR45_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR45_amount_direct_investment_reserve().intValue());
			}
			Cell R45cell13 = R45row.getCell(15);
			if (R45cell13 != null) {
				R45cell13.setCellValue(brf94b.getR45_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR45_no_of_transactions_services_reserve().intValue());
			}
			Cell R45cell14 = R45row.getCell(16);
			if (R45cell14 != null) {
				R45cell14.setCellValue(brf94b.getR45_amount_services_reserve() == null ? 0
						: brf94b.getR45_amount_services_reserve().intValue());
			}
			Cell R45cell15 = R45row.getCell(17);
			if (R45cell15 != null) {
				R45cell15.setCellValue(brf94b.getR45_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR45_no_of_transactions_trade_reserve().intValue());
			}
			Cell R45cell16 = R45row.getCell(18);
			if (R45cell16 != null) {
				R45cell16.setCellValue(brf94b.getR45_amount_trade_reserve() == null ? 0
						: brf94b.getR45_amount_trade_reserve().intValue());
			}
			Cell R45cell17 = R45row.getCell(19);
			if (R45cell17 != null) {
				R45cell17.setCellValue(brf94b.getR45_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR45_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R45cell18 = R45row.getCell(20);
			if (R45cell18 != null) {
				R45cell18.setCellValue(brf94b.getR45_amount_financial_investment_gre() == null ? 0
						: brf94b.getR45_amount_financial_investment_gre().intValue());
			}
			Cell R45cell19 = R45row.getCell(21);
			if (R45cell19 != null) {
				R45cell19.setCellValue(brf94b.getR45_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR45_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R45cell20 = R45row.getCell(22);
			if (R45cell20 != null) {
				R45cell20.setCellValue(brf94b.getR45_amount_direct_investment_gre() == null ? 0
						: brf94b.getR45_amount_direct_investment_gre().intValue());
			}
			Cell R45cell21 = R45row.getCell(23);
			if (R45cell21 != null) {
				R45cell21.setCellValue(brf94b.getR45_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR45_no_of_transactions_services_gre().intValue());
			}
			Cell R45cell22 = R45row.getCell(24);
			if (R45cell22 != null) {
				R45cell22.setCellValue(brf94b.getR45_amount_services_gre() == null ? 0
						: brf94b.getR45_amount_services_gre().intValue());
			}
			Cell R45cell23 = R45row.getCell(25);
			if (R45cell23 != null) {
				R45cell23.setCellValue(brf94b.getR45_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR45_no_of_transactions_trade_gre().intValue());
			}
			Cell R45cell24 = R45row.getCell(26);
			if (R45cell24 != null) {
				R45cell24.setCellValue(
						brf94b.getR45_amount_trade_gre() == null ? 0 : brf94b.getR45_amount_trade_gre().intValue());
			}
			Cell R45cell25 = R45row.getCell(27);
			if (R45cell25 != null) {
				R45cell25.setCellValue(brf94b.getR45_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR45_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R45cell26 = R45row.getCell(28);
			if (R45cell26 != null) {
				R45cell26.setCellValue(brf94b.getR45_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR45_amount_financial_investment_corporate().intValue());
			}
			Cell R45cell27 = R45row.getCell(29);
			if (R45cell27 != null) {
				R45cell27.setCellValue(brf94b.getR45_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR45_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R45cell28 = R45row.getCell(30);
			if (R45cell28 != null) {
				R45cell28.setCellValue(brf94b.getR45_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR45_amount_direct_investment_corporate().intValue());
			}
			Cell R45cell29 = R45row.getCell(31);
			if (R45cell29 != null) {
				R45cell29.setCellValue(brf94b.getR45_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR45_no_of_transactions_services_corporate().intValue());
			}
			Cell R45cell30 = R45row.getCell(32);
			if (R45cell30 != null) {
				R45cell30.setCellValue(brf94b.getR45_amount_services_corporate() == null ? 0
						: brf94b.getR45_amount_services_corporate().intValue());
			}
			Cell R45cell31 = R45row.getCell(33);
			if (R45cell31 != null) {
				R45cell31.setCellValue(brf94b.getR45_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR45_no_of_transactions_trade_corporate().intValue());
			}
			Cell R45cell32 = R45row.getCell(34);
			if (R45cell32 != null) {
				R45cell32.setCellValue(brf94b.getR45_amount_trade_corporate() == null ? 0
						: brf94b.getR45_amount_trade_corporate().intValue());
			}
			Cell R45cell33 = R45row.getCell(35);
			if (R45cell33 != null) {
				R45cell33.setCellValue(brf94b.getR45_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR45_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R45cell34 = R45row.getCell(36);
			if (R45cell34 != null) {
				R45cell34.setCellValue(brf94b.getR45_amount_financial_investment_sme() == null ? 0
						: brf94b.getR45_amount_financial_investment_sme().intValue());
			}
			Cell R45cell35 = R45row.getCell(37);
			if (R45cell35 != null) {
				R45cell35.setCellValue(brf94b.getR45_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR45_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R45cell36 = R45row.getCell(38);
			if (R45cell36 != null) {
				R45cell36.setCellValue(brf94b.getR45_amount_direct_investment_sme() == null ? 0
						: brf94b.getR45_amount_direct_investment_sme().intValue());
			}
			Cell R45cell37 = R45row.getCell(39);
			if (R45cell37 != null) {
				R45cell37.setCellValue(brf94b.getR45_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR45_no_of_transactions_services_sme().intValue());
			}
			Cell R45cell38 = R45row.getCell(40);
			if (R45cell38 != null) {
				R45cell38.setCellValue(brf94b.getR45_amount_services_sme() == null ? 0
						: brf94b.getR45_amount_services_sme().intValue());
			}
			Cell R45cell39 = R45row.getCell(41);
			if (R45cell39 != null) {
				R45cell39.setCellValue(brf94b.getR45_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR45_no_of_transactions_trade_sme().intValue());
			}
			Cell R45cell40 = R45row.getCell(42);
			if (R45cell40 != null) {
				R45cell40.setCellValue(
						brf94b.getR45_amount_trade_sme() == null ? 0 : brf94b.getR45_amount_trade_sme().intValue());
			}
			Cell R45cell41 = R45row.getCell(43);
			if (R45cell41 != null) {
				R45cell41.setCellValue(brf94b.getR45_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R45cell42 = R45row.getCell(44);
			if (R45cell42 != null) {
				R45cell42.setCellValue(brf94b.getR45_amount_financial_investment_individual() == null ? 0
						: brf94b.getR45_amount_financial_investment_individual().intValue());
			}
			Cell R45cell43 = R45row.getCell(45);
			if (R45cell43 != null) {
				R45cell43.setCellValue(brf94b.getR45_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R45cell44 = R45row.getCell(46);
			if (R45cell44 != null) {
				R45cell44.setCellValue(brf94b.getR45_amount_direct_investment_individual() == null ? 0
						: brf94b.getR45_amount_direct_investment_individual().intValue());
			}
			Cell R45cell45 = R45row.getCell(47);
			if (R45cell45 != null) {
				R45cell45.setCellValue(brf94b.getR45_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_family_support_individual().intValue());
			}
			Cell R45cell46 = R45row.getCell(48);
			if (R45cell46 != null) {
				R45cell46.setCellValue(brf94b.getR45_amount_family_support_individual() == null ? 0
						: brf94b.getR45_amount_family_support_individual().intValue());
			}
			Cell R45cell47 = R45row.getCell(49);
			if (R45cell47 != null) {
				R45cell47.setCellValue(brf94b.getR45_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_education_individual().intValue());
			}
			Cell R45cell48 = R45row.getCell(50);
			if (R45cell48 != null) {
				R45cell48.setCellValue(brf94b.getR45_amount_education_individual() == null ? 0
						: brf94b.getR45_amount_education_individual().intValue());
			}
			Cell R45cell49 = R45row.getCell(51);
			if (R45cell49 != null) {
				R45cell49.setCellValue(brf94b.getR45_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_medical_individual().intValue());
			}

			Cell R45cell50 = R45row.getCell(52);
			if (R45cell50 != null) {
				R45cell50.setCellValue(brf94b.getR45_amount_medical_individual() == null ? 0
						: brf94b.getR45_amount_medical_individual().intValue());
			}
			Cell R45cell51 = R45row.getCell(53);
			if (R45cell51 != null) {
				R45cell51.setCellValue(brf94b.getR45_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_tourism_individual().intValue());
			}
			Cell R45cell52 = R45row.getCell(54);
			if (R45cell52 != null) {
				R45cell52.setCellValue(brf94b.getR45_amount_tourism_individual() == null ? 0
						: brf94b.getR45_amount_tourism_individual().intValue());
			}
			Cell R45cell53 = R45row.getCell(55);
			if (R45cell53 != null) {
				R45cell53.setCellValue(brf94b.getR45_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R45cell54 = R45row.getCell(56);
			if (R45cell54 != null) {
				R45cell54.setCellValue(brf94b.getR45_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR45_amount_debt_settlement_individual().intValue());
			}
			Cell R45cell55 = R45row.getCell(57);
			if (R45cell55 != null) {
				R45cell55.setCellValue(brf94b.getR45_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR45_no_of_transactions_other_services_individual().intValue());
			}

			Cell R45cell56 = R45row.getCell(58);
			if (R45cell56 != null) {
				R45cell56.setCellValue(brf94b.getR45_amount_other_services_individual() == null ? 0
						: brf94b.getR45_amount_other_services_individual().intValue());
			}

			Row R46row = sheet.getRow(54);
			Cell R46cell1 = R46row.getCell(3);
			if (R46cell1 != null) {
				R46cell1.setCellValue(brf94b.getR46_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR46_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R46cell2 = R46row.getCell(4);
			if (R46cell2 != null) {
				R46cell2.setCellValue(brf94b.getR46_amount_financial_investment_government() == null ? 0
						: brf94b.getR46_amount_financial_investment_government().intValue());
			}
			Cell R46cell3 = R46row.getCell(5);
			if (R46cell3 != null) {
				R46cell3.setCellValue(brf94b.getR46_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR46_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R46cell4 = R46row.getCell(6);
			if (R46cell4 != null) {
				R46cell4.setCellValue(brf94b.getR46_amount_direct_investment_government() == null ? 0
						: brf94b.getR46_amount_direct_investment_government().intValue());
			}
			Cell R46cell5 = R46row.getCell(7);
			if (R46cell5 != null) {
				R46cell5.setCellValue(brf94b.getR46_no_of_transactions_services_government() == null ? 0
						: brf94b.getR46_no_of_transactions_services_government().intValue());
			}
			Cell R46cell6 = R46row.getCell(8);
			if (R46cell6 != null) {
				R46cell6.setCellValue(brf94b.getR46_amount_services_government() == null ? 0
						: brf94b.getR46_amount_services_government().intValue());
			}
			Cell R46cell7 = R46row.getCell(9);
			if (R46cell7 != null) {
				R46cell7.setCellValue(brf94b.getR46_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR46_no_of_transactions_trade_government().intValue());
			}
			Cell R46cell8 = R46row.getCell(10);
			if (R46cell8 != null) {
				R46cell8.setCellValue(brf94b.getR46_amount_trade_government() == null ? 0
						: brf94b.getR46_amount_trade_government().intValue());
			}
			Cell R46cell9 = R46row.getCell(11);
			if (R46cell9 != null) {
				R46cell9.setCellValue(brf94b.getR46_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR46_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R46cell10 = R46row.getCell(12);
			if (R46cell10 != null) {
				R46cell10.setCellValue(brf94b.getR46_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR46_amount_financial_investment_reserve().intValue());
			}
			Cell R46cell11 = R46row.getCell(13);
			if (R46cell11 != null) {
				R46cell11.setCellValue(brf94b.getR46_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR46_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R46cell12 = R46row.getCell(14);
			if (R46cell12 != null) {
				R46cell12.setCellValue(brf94b.getR46_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR46_amount_direct_investment_reserve().intValue());
			}
			Cell R46cell13 = R46row.getCell(15);
			if (R46cell13 != null) {
				R46cell13.setCellValue(brf94b.getR46_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR46_no_of_transactions_services_reserve().intValue());
			}
			Cell R46cell14 = R46row.getCell(16);
			if (R46cell14 != null) {
				R46cell14.setCellValue(brf94b.getR46_amount_services_reserve() == null ? 0
						: brf94b.getR46_amount_services_reserve().intValue());
			}
			Cell R46cell15 = R46row.getCell(17);
			if (R46cell15 != null) {
				R46cell15.setCellValue(brf94b.getR46_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR46_no_of_transactions_trade_reserve().intValue());
			}
			Cell R46cell16 = R46row.getCell(18);
			if (R46cell16 != null) {
				R46cell16.setCellValue(brf94b.getR46_amount_trade_reserve() == null ? 0
						: brf94b.getR46_amount_trade_reserve().intValue());
			}
			Cell R46cell17 = R46row.getCell(19);
			if (R46cell17 != null) {
				R46cell17.setCellValue(brf94b.getR46_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR46_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R46cell18 = R46row.getCell(20);
			if (R46cell18 != null) {
				R46cell18.setCellValue(brf94b.getR46_amount_financial_investment_gre() == null ? 0
						: brf94b.getR46_amount_financial_investment_gre().intValue());
			}
			Cell R46cell19 = R46row.getCell(21);
			if (R46cell19 != null) {
				R46cell19.setCellValue(brf94b.getR46_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR46_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R46cell20 = R46row.getCell(22);
			if (R46cell20 != null) {
				R46cell20.setCellValue(brf94b.getR46_amount_direct_investment_gre() == null ? 0
						: brf94b.getR46_amount_direct_investment_gre().intValue());
			}
			Cell R46cell21 = R46row.getCell(23);
			if (R46cell21 != null) {
				R46cell21.setCellValue(brf94b.getR46_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR46_no_of_transactions_services_gre().intValue());
			}
			Cell R46cell22 = R46row.getCell(24);
			if (R46cell22 != null) {
				R46cell22.setCellValue(brf94b.getR46_amount_services_gre() == null ? 0
						: brf94b.getR46_amount_services_gre().intValue());
			}
			Cell R46cell23 = R46row.getCell(25);
			if (R46cell23 != null) {
				R46cell23.setCellValue(brf94b.getR46_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR46_no_of_transactions_trade_gre().intValue());
			}
			Cell R46cell24 = R46row.getCell(26);
			if (R46cell24 != null) {
				R46cell24.setCellValue(
						brf94b.getR46_amount_trade_gre() == null ? 0 : brf94b.getR46_amount_trade_gre().intValue());
			}
			Cell R46cell25 = R46row.getCell(27);
			if (R46cell25 != null) {
				R46cell25.setCellValue(brf94b.getR46_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR46_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R46cell26 = R46row.getCell(28);
			if (R46cell26 != null) {
				R46cell26.setCellValue(brf94b.getR46_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR46_amount_financial_investment_corporate().intValue());
			}
			Cell R46cell27 = R46row.getCell(29);
			if (R46cell27 != null) {
				R46cell27.setCellValue(brf94b.getR46_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR46_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R46cell28 = R46row.getCell(30);
			if (R46cell28 != null) {
				R46cell28.setCellValue(brf94b.getR46_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR46_amount_direct_investment_corporate().intValue());
			}
			Cell R46cell29 = R46row.getCell(31);
			if (R46cell29 != null) {
				R46cell29.setCellValue(brf94b.getR46_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR46_no_of_transactions_services_corporate().intValue());
			}
			Cell R46cell30 = R46row.getCell(32);
			if (R46cell30 != null) {
				R46cell30.setCellValue(brf94b.getR46_amount_services_corporate() == null ? 0
						: brf94b.getR46_amount_services_corporate().intValue());
			}
			Cell R46cell31 = R46row.getCell(33);
			if (R46cell31 != null) {
				R46cell31.setCellValue(brf94b.getR46_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR46_no_of_transactions_trade_corporate().intValue());
			}
			Cell R46cell32 = R46row.getCell(34);
			if (R46cell32 != null) {
				R46cell32.setCellValue(brf94b.getR46_amount_trade_corporate() == null ? 0
						: brf94b.getR46_amount_trade_corporate().intValue());
			}
			Cell R46cell33 = R46row.getCell(35);
			if (R46cell33 != null) {
				R46cell33.setCellValue(brf94b.getR46_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR46_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R46cell34 = R46row.getCell(36);
			if (R46cell34 != null) {
				R46cell34.setCellValue(brf94b.getR46_amount_financial_investment_sme() == null ? 0
						: brf94b.getR46_amount_financial_investment_sme().intValue());
			}
			Cell R46cell35 = R46row.getCell(37);
			if (R46cell35 != null) {
				R46cell35.setCellValue(brf94b.getR46_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR46_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R46cell36 = R46row.getCell(38);
			if (R46cell36 != null) {
				R46cell36.setCellValue(brf94b.getR46_amount_direct_investment_sme() == null ? 0
						: brf94b.getR46_amount_direct_investment_sme().intValue());
			}
			Cell R46cell37 = R46row.getCell(39);
			if (R46cell37 != null) {
				R46cell37.setCellValue(brf94b.getR46_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR46_no_of_transactions_services_sme().intValue());
			}
			Cell R46cell38 = R46row.getCell(40);
			if (R46cell38 != null) {
				R46cell38.setCellValue(brf94b.getR46_amount_services_sme() == null ? 0
						: brf94b.getR46_amount_services_sme().intValue());
			}
			Cell R46cell39 = R46row.getCell(41);
			if (R46cell39 != null) {
				R46cell39.setCellValue(brf94b.getR46_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR46_no_of_transactions_trade_sme().intValue());
			}
			Cell R46cell40 = R46row.getCell(42);
			if (R46cell40 != null) {
				R46cell40.setCellValue(
						brf94b.getR46_amount_trade_sme() == null ? 0 : brf94b.getR46_amount_trade_sme().intValue());
			}
			Cell R46cell41 = R46row.getCell(43);
			if (R46cell41 != null) {
				R46cell41.setCellValue(brf94b.getR46_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R46cell42 = R46row.getCell(44);
			if (R46cell42 != null) {
				R46cell42.setCellValue(brf94b.getR46_amount_financial_investment_individual() == null ? 0
						: brf94b.getR46_amount_financial_investment_individual().intValue());
			}
			Cell R46cell43 = R46row.getCell(45);
			if (R46cell43 != null) {
				R46cell43.setCellValue(brf94b.getR46_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R46cell44 = R46row.getCell(46);
			if (R46cell44 != null) {
				R46cell44.setCellValue(brf94b.getR46_amount_direct_investment_individual() == null ? 0
						: brf94b.getR46_amount_direct_investment_individual().intValue());
			}
			Cell R46cell45 = R46row.getCell(47);
			if (R46cell45 != null) {
				R46cell45.setCellValue(brf94b.getR46_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_family_support_individual().intValue());
			}
			Cell R46cell46 = R46row.getCell(48);
			if (R46cell46 != null) {
				R46cell46.setCellValue(brf94b.getR46_amount_family_support_individual() == null ? 0
						: brf94b.getR46_amount_family_support_individual().intValue());
			}
			Cell R46cell47 = R46row.getCell(49);
			if (R46cell47 != null) {
				R46cell47.setCellValue(brf94b.getR46_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_education_individual().intValue());
			}
			Cell R46cell48 = R46row.getCell(50);
			if (R46cell48 != null) {
				R46cell48.setCellValue(brf94b.getR46_amount_education_individual() == null ? 0
						: brf94b.getR46_amount_education_individual().intValue());
			}
			Cell R46cell49 = R46row.getCell(51);
			if (R46cell49 != null) {
				R46cell49.setCellValue(brf94b.getR46_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_medical_individual().intValue());
			}

			Cell R46cell50 = R46row.getCell(52);
			if (R46cell50 != null) {
				R46cell50.setCellValue(brf94b.getR46_amount_medical_individual() == null ? 0
						: brf94b.getR46_amount_medical_individual().intValue());
			}
			Cell R46cell51 = R46row.getCell(53);
			if (R46cell51 != null) {
				R46cell51.setCellValue(brf94b.getR46_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_tourism_individual().intValue());
			}
			Cell R46cell52 = R46row.getCell(54);
			if (R46cell52 != null) {
				R46cell52.setCellValue(brf94b.getR46_amount_tourism_individual() == null ? 0
						: brf94b.getR46_amount_tourism_individual().intValue());
			}
			Cell R46cell53 = R46row.getCell(55);
			if (R46cell53 != null) {
				R46cell53.setCellValue(brf94b.getR46_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R46cell54 = R46row.getCell(56);
			if (R46cell54 != null) {
				R46cell54.setCellValue(brf94b.getR46_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR46_amount_debt_settlement_individual().intValue());
			}
			Cell R46cell55 = R46row.getCell(57);
			if (R46cell55 != null) {
				R46cell55.setCellValue(brf94b.getR46_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR46_no_of_transactions_other_services_individual().intValue());
			}

			Cell R46cell56 = R46row.getCell(58);
			if (R46cell56 != null) {
				R46cell56.setCellValue(brf94b.getR46_amount_other_services_individual() == null ? 0
						: brf94b.getR46_amount_other_services_individual().intValue());
			}

			Row R47row = sheet.getRow(55);
			Cell R47cell1 = R47row.getCell(3);
			if (R47cell1 != null) {
				R47cell1.setCellValue(brf94b.getR47_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR47_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R47cell2 = R47row.getCell(4);
			if (R47cell2 != null) {
				R47cell2.setCellValue(brf94b.getR47_amount_financial_investment_government() == null ? 0
						: brf94b.getR47_amount_financial_investment_government().intValue());
			}
			Cell R47cell3 = R47row.getCell(5);
			if (R47cell3 != null) {
				R47cell3.setCellValue(brf94b.getR47_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR47_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R47cell4 = R47row.getCell(6);
			if (R47cell4 != null) {
				R47cell4.setCellValue(brf94b.getR47_amount_direct_investment_government() == null ? 0
						: brf94b.getR47_amount_direct_investment_government().intValue());
			}
			Cell R47cell5 = R47row.getCell(7);
			if (R47cell5 != null) {
				R47cell5.setCellValue(brf94b.getR47_no_of_transactions_services_government() == null ? 0
						: brf94b.getR47_no_of_transactions_services_government().intValue());
			}
			Cell R47cell6 = R47row.getCell(8);
			if (R47cell6 != null) {
				R47cell6.setCellValue(brf94b.getR47_amount_services_government() == null ? 0
						: brf94b.getR47_amount_services_government().intValue());
			}
			Cell R47cell7 = R47row.getCell(9);
			if (R47cell7 != null) {
				R47cell7.setCellValue(brf94b.getR47_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR47_no_of_transactions_trade_government().intValue());
			}
			Cell R47cell8 = R47row.getCell(10);
			if (R47cell8 != null) {
				R47cell8.setCellValue(brf94b.getR47_amount_trade_government() == null ? 0
						: brf94b.getR47_amount_trade_government().intValue());
			}
			Cell R47cell9 = R47row.getCell(11);
			if (R47cell9 != null) {
				R47cell9.setCellValue(brf94b.getR47_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR47_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R47cell10 = R47row.getCell(12);
			if (R47cell10 != null) {
				R47cell10.setCellValue(brf94b.getR47_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR47_amount_financial_investment_reserve().intValue());
			}
			Cell R47cell11 = R47row.getCell(13);
			if (R47cell11 != null) {
				R47cell11.setCellValue(brf94b.getR47_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR47_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R47cell12 = R47row.getCell(14);
			if (R47cell12 != null) {
				R47cell12.setCellValue(brf94b.getR47_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR47_amount_direct_investment_reserve().intValue());
			}
			Cell R47cell13 = R47row.getCell(15);
			if (R47cell13 != null) {
				R47cell13.setCellValue(brf94b.getR47_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR47_no_of_transactions_services_reserve().intValue());
			}
			Cell R47cell14 = R47row.getCell(16);
			if (R47cell14 != null) {
				R47cell14.setCellValue(brf94b.getR47_amount_services_reserve() == null ? 0
						: brf94b.getR47_amount_services_reserve().intValue());
			}
			Cell R47cell15 = R47row.getCell(17);
			if (R47cell15 != null) {
				R47cell15.setCellValue(brf94b.getR47_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR47_no_of_transactions_trade_reserve().intValue());
			}
			Cell R47cell16 = R47row.getCell(18);
			if (R47cell16 != null) {
				R47cell16.setCellValue(brf94b.getR47_amount_trade_reserve() == null ? 0
						: brf94b.getR47_amount_trade_reserve().intValue());
			}
			Cell R47cell17 = R47row.getCell(19);
			if (R47cell17 != null) {
				R47cell17.setCellValue(brf94b.getR47_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR47_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R47cell18 = R47row.getCell(20);
			if (R47cell18 != null) {
				R47cell18.setCellValue(brf94b.getR47_amount_financial_investment_gre() == null ? 0
						: brf94b.getR47_amount_financial_investment_gre().intValue());
			}
			Cell R47cell19 = R47row.getCell(21);
			if (R47cell19 != null) {
				R47cell19.setCellValue(brf94b.getR47_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR47_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R47cell20 = R47row.getCell(22);
			if (R47cell20 != null) {
				R47cell20.setCellValue(brf94b.getR47_amount_direct_investment_gre() == null ? 0
						: brf94b.getR47_amount_direct_investment_gre().intValue());
			}
			Cell R47cell21 = R47row.getCell(23);
			if (R47cell21 != null) {
				R47cell21.setCellValue(brf94b.getR47_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR47_no_of_transactions_services_gre().intValue());
			}
			Cell R47cell22 = R47row.getCell(24);
			if (R47cell22 != null) {
				R47cell22.setCellValue(brf94b.getR47_amount_services_gre() == null ? 0
						: brf94b.getR47_amount_services_gre().intValue());
			}
			Cell R47cell23 = R47row.getCell(25);
			if (R47cell23 != null) {
				R47cell23.setCellValue(brf94b.getR47_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR47_no_of_transactions_trade_gre().intValue());
			}
			Cell R47cell24 = R47row.getCell(26);
			if (R47cell24 != null) {
				R47cell24.setCellValue(
						brf94b.getR47_amount_trade_gre() == null ? 0 : brf94b.getR47_amount_trade_gre().intValue());
			}
			Cell R47cell25 = R47row.getCell(27);
			if (R47cell25 != null) {
				R47cell25.setCellValue(brf94b.getR47_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR47_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R47cell26 = R47row.getCell(28);
			if (R47cell26 != null) {
				R47cell26.setCellValue(brf94b.getR47_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR47_amount_financial_investment_corporate().intValue());
			}
			Cell R47cell27 = R47row.getCell(29);
			if (R47cell27 != null) {
				R47cell27.setCellValue(brf94b.getR47_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR47_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R47cell28 = R47row.getCell(30);
			if (R47cell28 != null) {
				R47cell28.setCellValue(brf94b.getR47_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR47_amount_direct_investment_corporate().intValue());
			}
			Cell R47cell29 = R47row.getCell(31);
			if (R47cell29 != null) {
				R47cell29.setCellValue(brf94b.getR47_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR47_no_of_transactions_services_corporate().intValue());
			}
			Cell R47cell30 = R47row.getCell(32);
			if (R47cell30 != null) {
				R47cell30.setCellValue(brf94b.getR47_amount_services_corporate() == null ? 0
						: brf94b.getR47_amount_services_corporate().intValue());
			}
			Cell R47cell31 = R47row.getCell(33);
			if (R47cell31 != null) {
				R47cell31.setCellValue(brf94b.getR47_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR47_no_of_transactions_trade_corporate().intValue());
			}
			Cell R47cell32 = R47row.getCell(34);
			if (R47cell32 != null) {
				R47cell32.setCellValue(brf94b.getR47_amount_trade_corporate() == null ? 0
						: brf94b.getR47_amount_trade_corporate().intValue());
			}
			Cell R47cell33 = R47row.getCell(35);
			if (R47cell33 != null) {
				R47cell33.setCellValue(brf94b.getR47_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR47_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R47cell34 = R47row.getCell(36);
			if (R47cell34 != null) {
				R47cell34.setCellValue(brf94b.getR47_amount_financial_investment_sme() == null ? 0
						: brf94b.getR47_amount_financial_investment_sme().intValue());
			}
			Cell R47cell35 = R47row.getCell(37);
			if (R47cell35 != null) {
				R47cell35.setCellValue(brf94b.getR47_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR47_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R47cell36 = R47row.getCell(38);
			if (R47cell36 != null) {
				R47cell36.setCellValue(brf94b.getR47_amount_direct_investment_sme() == null ? 0
						: brf94b.getR47_amount_direct_investment_sme().intValue());
			}
			Cell R47cell37 = R47row.getCell(39);
			if (R47cell37 != null) {
				R47cell37.setCellValue(brf94b.getR47_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR47_no_of_transactions_services_sme().intValue());
			}
			Cell R47cell38 = R47row.getCell(40);
			if (R47cell38 != null) {
				R47cell38.setCellValue(brf94b.getR47_amount_services_sme() == null ? 0
						: brf94b.getR47_amount_services_sme().intValue());
			}
			Cell R47cell39 = R47row.getCell(41);
			if (R47cell39 != null) {
				R47cell39.setCellValue(brf94b.getR47_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR47_no_of_transactions_trade_sme().intValue());
			}
			Cell R47cell40 = R47row.getCell(42);
			if (R47cell40 != null) {
				R47cell40.setCellValue(
						brf94b.getR47_amount_trade_sme() == null ? 0 : brf94b.getR47_amount_trade_sme().intValue());
			}
			Cell R47cell41 = R47row.getCell(43);
			if (R47cell41 != null) {
				R47cell41.setCellValue(brf94b.getR47_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R47cell42 = R47row.getCell(44);
			if (R47cell42 != null) {
				R47cell42.setCellValue(brf94b.getR47_amount_financial_investment_individual() == null ? 0
						: brf94b.getR47_amount_financial_investment_individual().intValue());
			}
			Cell R47cell43 = R47row.getCell(45);
			if (R47cell43 != null) {
				R47cell43.setCellValue(brf94b.getR47_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R47cell44 = R47row.getCell(46);
			if (R47cell44 != null) {
				R47cell44.setCellValue(brf94b.getR47_amount_direct_investment_individual() == null ? 0
						: brf94b.getR47_amount_direct_investment_individual().intValue());
			}
			Cell R47cell45 = R47row.getCell(47);
			if (R47cell45 != null) {
				R47cell45.setCellValue(brf94b.getR47_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_family_support_individual().intValue());
			}
			Cell R47cell46 = R47row.getCell(48);
			if (R47cell46 != null) {
				R47cell46.setCellValue(brf94b.getR47_amount_family_support_individual() == null ? 0
						: brf94b.getR47_amount_family_support_individual().intValue());
			}
			Cell R47cell47 = R47row.getCell(49);
			if (R47cell47 != null) {
				R47cell47.setCellValue(brf94b.getR47_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_education_individual().intValue());
			}
			Cell R47cell48 = R47row.getCell(50);
			if (R47cell48 != null) {
				R47cell48.setCellValue(brf94b.getR47_amount_education_individual() == null ? 0
						: brf94b.getR47_amount_education_individual().intValue());
			}
			Cell R47cell49 = R47row.getCell(51);
			if (R47cell49 != null) {
				R47cell49.setCellValue(brf94b.getR47_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_medical_individual().intValue());
			}

			Cell R47cell50 = R47row.getCell(52);
			if (R47cell50 != null) {
				R47cell50.setCellValue(brf94b.getR47_amount_medical_individual() == null ? 0
						: brf94b.getR47_amount_medical_individual().intValue());
			}
			Cell R47cell51 = R47row.getCell(53);
			if (R47cell51 != null) {
				R47cell51.setCellValue(brf94b.getR47_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_tourism_individual().intValue());
			}
			Cell R47cell52 = R47row.getCell(54);
			if (R47cell52 != null) {
				R47cell52.setCellValue(brf94b.getR47_amount_tourism_individual() == null ? 0
						: brf94b.getR47_amount_tourism_individual().intValue());
			}
			Cell R47cell53 = R47row.getCell(55);
			if (R47cell53 != null) {
				R47cell53.setCellValue(brf94b.getR47_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R47cell54 = R47row.getCell(56);
			if (R47cell54 != null) {
				R47cell54.setCellValue(brf94b.getR47_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR47_amount_debt_settlement_individual().intValue());
			}
			Cell R47cell55 = R47row.getCell(57);
			if (R47cell55 != null) {
				R47cell55.setCellValue(brf94b.getR47_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR47_no_of_transactions_other_services_individual().intValue());
			}

			Cell R47cell56 = R47row.getCell(58);
			if (R47cell56 != null) {
				R47cell56.setCellValue(brf94b.getR47_amount_other_services_individual() == null ? 0
						: brf94b.getR47_amount_other_services_individual().intValue());
			}

			Row R48row = sheet.getRow(56);
			Cell R48cell1 = R48row.getCell(3);
			if (R48cell1 != null) {
				R48cell1.setCellValue(brf94b.getR48_no_of_transactions_financial_investment_government() == null ? 0
						: brf94b.getR48_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R48cell2 = R48row.getCell(4);
			if (R48cell2 != null) {
				R48cell2.setCellValue(brf94b.getR48_amount_financial_investment_government() == null ? 0
						: brf94b.getR48_amount_financial_investment_government().intValue());
			}
			Cell R48cell3 = R48row.getCell(5);
			if (R48cell3 != null) {
				R48cell3.setCellValue(brf94b.getR48_no_of_transactions_direct_investment_government() == null ? 0
						: brf94b.getR48_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R48cell4 = R48row.getCell(6);
			if (R48cell4 != null) {
				R48cell4.setCellValue(brf94b.getR48_amount_direct_investment_government() == null ? 0
						: brf94b.getR48_amount_direct_investment_government().intValue());
			}
			Cell R48cell5 = R48row.getCell(7);
			if (R48cell5 != null) {
				R48cell5.setCellValue(brf94b.getR48_no_of_transactions_services_government() == null ? 0
						: brf94b.getR48_no_of_transactions_services_government().intValue());
			}
			Cell R48cell6 = R48row.getCell(8);
			if (R48cell6 != null) {
				R48cell6.setCellValue(brf94b.getR48_amount_services_government() == null ? 0
						: brf94b.getR48_amount_services_government().intValue());
			}
			Cell R48cell7 = R48row.getCell(9);
			if (R48cell7 != null) {
				R48cell7.setCellValue(brf94b.getR48_no_of_transactions_trade_government() == null ? 0
						: brf94b.getR48_no_of_transactions_trade_government().intValue());
			}
			Cell R48cell8 = R48row.getCell(10);
			if (R48cell8 != null) {
				R48cell8.setCellValue(brf94b.getR48_amount_trade_government() == null ? 0
						: brf94b.getR48_amount_trade_government().intValue());
			}
			Cell R48cell9 = R48row.getCell(11);
			if (R48cell9 != null) {
				R48cell9.setCellValue(brf94b.getR48_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94b.getR48_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R48cell10 = R48row.getCell(12);
			if (R48cell10 != null) {
				R48cell10.setCellValue(brf94b.getR48_amount_financial_investment_reserve() == null ? 0
						: brf94b.getR48_amount_financial_investment_reserve().intValue());
			}
			Cell R48cell11 = R48row.getCell(13);
			if (R48cell11 != null) {
				R48cell11.setCellValue(brf94b.getR48_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94b.getR48_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R48cell12 = R48row.getCell(14);
			if (R48cell12 != null) {
				R48cell12.setCellValue(brf94b.getR48_amount_direct_investment_reserve() == null ? 0
						: brf94b.getR48_amount_direct_investment_reserve().intValue());
			}
			Cell R48cell13 = R48row.getCell(15);
			if (R48cell13 != null) {
				R48cell13.setCellValue(brf94b.getR48_no_of_transactions_services_reserve() == null ? 0
						: brf94b.getR48_no_of_transactions_services_reserve().intValue());
			}
			Cell R48cell14 = R48row.getCell(16);
			if (R48cell14 != null) {
				R48cell14.setCellValue(brf94b.getR48_amount_services_reserve() == null ? 0
						: brf94b.getR48_amount_services_reserve().intValue());
			}
			Cell R48cell15 = R48row.getCell(17);
			if (R48cell15 != null) {
				R48cell15.setCellValue(brf94b.getR48_no_of_transactions_trade_reserve() == null ? 0
						: brf94b.getR48_no_of_transactions_trade_reserve().intValue());
			}
			Cell R48cell16 = R48row.getCell(18);
			if (R48cell16 != null) {
				R48cell16.setCellValue(brf94b.getR48_amount_trade_reserve() == null ? 0
						: brf94b.getR48_amount_trade_reserve().intValue());
			}
			Cell R48cell17 = R48row.getCell(19);
			if (R48cell17 != null) {
				R48cell17.setCellValue(brf94b.getR48_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94b.getR48_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R48cell18 = R48row.getCell(20);
			if (R48cell18 != null) {
				R48cell18.setCellValue(brf94b.getR48_amount_financial_investment_gre() == null ? 0
						: brf94b.getR48_amount_financial_investment_gre().intValue());
			}
			Cell R48cell19 = R48row.getCell(21);
			if (R48cell19 != null) {
				R48cell19.setCellValue(brf94b.getR48_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94b.getR48_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R48cell20 = R48row.getCell(22);
			if (R48cell20 != null) {
				R48cell20.setCellValue(brf94b.getR48_amount_direct_investment_gre() == null ? 0
						: brf94b.getR48_amount_direct_investment_gre().intValue());
			}
			Cell R48cell21 = R48row.getCell(23);
			if (R48cell21 != null) {
				R48cell21.setCellValue(brf94b.getR48_no_of_transactions_services_gre() == null ? 0
						: brf94b.getR48_no_of_transactions_services_gre().intValue());
			}
			Cell R48cell22 = R48row.getCell(24);
			if (R48cell22 != null) {
				R48cell22.setCellValue(brf94b.getR48_amount_services_gre() == null ? 0
						: brf94b.getR48_amount_services_gre().intValue());
			}
			Cell R48cell23 = R48row.getCell(25);
			if (R48cell23 != null) {
				R48cell23.setCellValue(brf94b.getR48_no_of_transactions_trade_gre() == null ? 0
						: brf94b.getR48_no_of_transactions_trade_gre().intValue());
			}
			Cell R48cell24 = R48row.getCell(26);
			if (R48cell24 != null) {
				R48cell24.setCellValue(
						brf94b.getR48_amount_trade_gre() == null ? 0 : brf94b.getR48_amount_trade_gre().intValue());
			}
			Cell R48cell25 = R48row.getCell(27);
			if (R48cell25 != null) {
				R48cell25.setCellValue(brf94b.getR48_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94b.getR48_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R48cell26 = R48row.getCell(28);
			if (R48cell26 != null) {
				R48cell26.setCellValue(brf94b.getR48_amount_financial_investment_corporate() == null ? 0
						: brf94b.getR48_amount_financial_investment_corporate().intValue());
			}
			Cell R48cell27 = R48row.getCell(29);
			if (R48cell27 != null) {
				R48cell27.setCellValue(brf94b.getR48_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94b.getR48_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R48cell28 = R48row.getCell(30);
			if (R48cell28 != null) {
				R48cell28.setCellValue(brf94b.getR48_amount_direct_investment_corporate() == null ? 0
						: brf94b.getR48_amount_direct_investment_corporate().intValue());
			}
			Cell R48cell29 = R48row.getCell(31);
			if (R48cell29 != null) {
				R48cell29.setCellValue(brf94b.getR48_no_of_transactions_services_corporate() == null ? 0
						: brf94b.getR48_no_of_transactions_services_corporate().intValue());
			}
			Cell R48cell30 = R48row.getCell(32);
			if (R48cell30 != null) {
				R48cell30.setCellValue(brf94b.getR48_amount_services_corporate() == null ? 0
						: brf94b.getR48_amount_services_corporate().intValue());
			}
			Cell R48cell31 = R48row.getCell(33);
			if (R48cell31 != null) {
				R48cell31.setCellValue(brf94b.getR48_no_of_transactions_trade_corporate() == null ? 0
						: brf94b.getR48_no_of_transactions_trade_corporate().intValue());
			}
			Cell R48cell32 = R48row.getCell(34);
			if (R48cell32 != null) {
				R48cell32.setCellValue(brf94b.getR48_amount_trade_corporate() == null ? 0
						: brf94b.getR48_amount_trade_corporate().intValue());
			}
			Cell R48cell33 = R48row.getCell(35);
			if (R48cell33 != null) {
				R48cell33.setCellValue(brf94b.getR48_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94b.getR48_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R48cell34 = R48row.getCell(36);
			if (R48cell34 != null) {
				R48cell34.setCellValue(brf94b.getR48_amount_financial_investment_sme() == null ? 0
						: brf94b.getR48_amount_financial_investment_sme().intValue());
			}
			Cell R48cell35 = R48row.getCell(37);
			if (R48cell35 != null) {
				R48cell35.setCellValue(brf94b.getR48_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94b.getR48_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R48cell36 = R48row.getCell(38);
			if (R48cell36 != null) {
				R48cell36.setCellValue(brf94b.getR48_amount_direct_investment_sme() == null ? 0
						: brf94b.getR48_amount_direct_investment_sme().intValue());
			}
			Cell R48cell37 = R48row.getCell(39);
			if (R48cell37 != null) {
				R48cell37.setCellValue(brf94b.getR48_no_of_transactions_services_sme() == null ? 0
						: brf94b.getR48_no_of_transactions_services_sme().intValue());
			}
			Cell R48cell38 = R48row.getCell(40);
			if (R48cell38 != null) {
				R48cell38.setCellValue(brf94b.getR48_amount_services_sme() == null ? 0
						: brf94b.getR48_amount_services_sme().intValue());
			}
			Cell R48cell39 = R48row.getCell(41);
			if (R48cell39 != null) {
				R48cell39.setCellValue(brf94b.getR48_no_of_transactions_trade_sme() == null ? 0
						: brf94b.getR48_no_of_transactions_trade_sme().intValue());
			}
			Cell R48cell40 = R48row.getCell(42);
			if (R48cell40 != null) {
				R48cell40.setCellValue(
						brf94b.getR48_amount_trade_sme() == null ? 0 : brf94b.getR48_amount_trade_sme().intValue());
			}
			Cell R48cell41 = R48row.getCell(43);
			if (R48cell41 != null) {
				R48cell41.setCellValue(brf94b.getR48_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R48cell42 = R48row.getCell(44);
			if (R48cell42 != null) {
				R48cell42.setCellValue(brf94b.getR48_amount_financial_investment_individual() == null ? 0
						: brf94b.getR48_amount_financial_investment_individual().intValue());
			}
			Cell R48cell43 = R48row.getCell(45);
			if (R48cell43 != null) {
				R48cell43.setCellValue(brf94b.getR48_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R48cell44 = R48row.getCell(46);
			if (R48cell44 != null) {
				R48cell44.setCellValue(brf94b.getR48_amount_direct_investment_individual() == null ? 0
						: brf94b.getR48_amount_direct_investment_individual().intValue());
			}
			Cell R48cell45 = R48row.getCell(47);
			if (R48cell45 != null) {
				R48cell45.setCellValue(brf94b.getR48_no_of_transactions_family_support_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_family_support_individual().intValue());
			}
			Cell R48cell46 = R48row.getCell(48);
			if (R48cell46 != null) {
				R48cell46.setCellValue(brf94b.getR48_amount_family_support_individual() == null ? 0
						: brf94b.getR48_amount_family_support_individual().intValue());
			}
			Cell R48cell47 = R48row.getCell(49);
			if (R48cell47 != null) {
				R48cell47.setCellValue(brf94b.getR48_no_of_transactions_education_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_education_individual().intValue());
			}
			Cell R48cell48 = R48row.getCell(50);
			if (R48cell48 != null) {
				R48cell48.setCellValue(brf94b.getR48_amount_education_individual() == null ? 0
						: brf94b.getR48_amount_education_individual().intValue());
			}
			Cell R48cell49 = R48row.getCell(51);
			if (R48cell49 != null) {
				R48cell49.setCellValue(brf94b.getR48_no_of_transactions_medical_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_medical_individual().intValue());
			}

			Cell R48cell50 = R48row.getCell(52);
			if (R48cell50 != null) {
				R48cell50.setCellValue(brf94b.getR48_amount_medical_individual() == null ? 0
						: brf94b.getR48_amount_medical_individual().intValue());
			}
			Cell R48cell51 = R48row.getCell(53);
			if (R48cell51 != null) {
				R48cell51.setCellValue(brf94b.getR48_no_of_transactions_tourism_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_tourism_individual().intValue());
			}
			Cell R48cell52 = R48row.getCell(54);
			if (R48cell52 != null) {
				R48cell52.setCellValue(brf94b.getR48_amount_tourism_individual() == null ? 0
						: brf94b.getR48_amount_tourism_individual().intValue());
			}
			Cell R48cell53 = R48row.getCell(55);
			if (R48cell53 != null) {
				R48cell53.setCellValue(brf94b.getR48_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R48cell54 = R48row.getCell(56);
			if (R48cell54 != null) {
				R48cell54.setCellValue(brf94b.getR48_amount_debt_settlement_individual() == null ? 0
						: brf94b.getR48_amount_debt_settlement_individual().intValue());
			}
			Cell R48cell55 = R48row.getCell(57);
			if (R48cell55 != null) {
				R48cell55.setCellValue(brf94b.getR48_no_of_transactions_other_services_individual() == null ? 0
						: brf94b.getR48_no_of_transactions_other_services_individual().intValue());
			}

			Cell R48cell56 = R48row.getCell(58);
			if (R48cell56 != null) {
				R48cell56.setCellValue(brf94b.getR48_amount_other_services_individual() == null ? 0
						: brf94b.getR48_amount_other_services_individual().intValue());
			}

		}

	}

	public void updateSheetWithEntity4Data(Sheet sheet, List<BRF094_SUMMARYENTITY4> BRF094_SUMMARYENTITY4) {
		if (BRF094_SUMMARYENTITY4.size() == 1) {
			BRF094_SUMMARYENTITY4 brf94c = BRF094_SUMMARYENTITY4.get(0);

			Row R50row = sheet.getRow(58);
			Cell R50cell1 = R50row.getCell(3);
			if (R50cell1 != null) {
				R50cell1.setCellValue(brf94c.getR50_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR50_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R50cell2 = R50row.getCell(4);
			if (R50cell2 != null) {
				R50cell2.setCellValue(brf94c.getR50_amount_financial_investment_government() == null ? 0
						: brf94c.getR50_amount_financial_investment_government().intValue());
			}
			Cell R50cell3 = R50row.getCell(5);
			if (R50cell3 != null) {
				R50cell3.setCellValue(brf94c.getR50_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR50_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R50cell4 = R50row.getCell(6);
			if (R50cell4 != null) {
				R50cell4.setCellValue(brf94c.getR50_amount_direct_investment_government() == null ? 0
						: brf94c.getR50_amount_direct_investment_government().intValue());
			}
			Cell R50cell5 = R50row.getCell(7);
			if (R50cell5 != null) {
				R50cell5.setCellValue(brf94c.getR50_no_of_transactions_services_government() == null ? 0
						: brf94c.getR50_no_of_transactions_services_government().intValue());
			}
			Cell R50cell6 = R50row.getCell(8);
			if (R50cell6 != null) {
				R50cell6.setCellValue(brf94c.getR50_amount_services_government() == null ? 0
						: brf94c.getR50_amount_services_government().intValue());
			}
			Cell R50cell7 = R50row.getCell(9);
			if (R50cell7 != null) {
				R50cell7.setCellValue(brf94c.getR50_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR50_no_of_transactions_trade_government().intValue());
			}
			Cell R50cell8 = R50row.getCell(10);
			if (R50cell8 != null) {
				R50cell8.setCellValue(brf94c.getR50_amount_trade_government() == null ? 0
						: brf94c.getR50_amount_trade_government().intValue());
			}
			Cell R50cell9 = R50row.getCell(11);
			if (R50cell9 != null) {
				R50cell9.setCellValue(brf94c.getR50_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR50_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R50cell10 = R50row.getCell(12);
			if (R50cell10 != null) {
				R50cell10.setCellValue(brf94c.getR50_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR50_amount_financial_investment_reserve().intValue());
			}
			Cell R50cell11 = R50row.getCell(13);
			if (R50cell11 != null) {
				R50cell11.setCellValue(brf94c.getR50_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR50_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R50cell12 = R50row.getCell(14);
			if (R50cell12 != null) {
				R50cell12.setCellValue(brf94c.getR50_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR50_amount_direct_investment_reserve().intValue());
			}
			Cell R50cell13 = R50row.getCell(15);
			if (R50cell13 != null) {
				R50cell13.setCellValue(brf94c.getR50_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR50_no_of_transactions_services_reserve().intValue());
			}
			Cell R50cell14 = R50row.getCell(16);
			if (R50cell14 != null) {
				R50cell14.setCellValue(brf94c.getR50_amount_services_reserve() == null ? 0
						: brf94c.getR50_amount_services_reserve().intValue());
			}
			Cell R50cell15 = R50row.getCell(17);
			if (R50cell15 != null) {
				R50cell15.setCellValue(brf94c.getR50_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR50_no_of_transactions_trade_reserve().intValue());
			}
			Cell R50cell16 = R50row.getCell(18);
			if (R50cell16 != null) {
				R50cell16.setCellValue(brf94c.getR50_amount_trade_reserve() == null ? 0
						: brf94c.getR50_amount_trade_reserve().intValue());
			}
			Cell R50cell17 = R50row.getCell(19);
			if (R50cell17 != null) {
				R50cell17.setCellValue(brf94c.getR50_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR50_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R50cell18 = R50row.getCell(20);
			if (R50cell18 != null) {
				R50cell18.setCellValue(brf94c.getR50_amount_financial_investment_gre() == null ? 0
						: brf94c.getR50_amount_financial_investment_gre().intValue());
			}
			Cell R50cell19 = R50row.getCell(21);
			if (R50cell19 != null) {
				R50cell19.setCellValue(brf94c.getR50_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR50_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R50cell20 = R50row.getCell(22);
			if (R50cell20 != null) {
				R50cell20.setCellValue(brf94c.getR50_amount_direct_investment_gre() == null ? 0
						: brf94c.getR50_amount_direct_investment_gre().intValue());
			}
			Cell R50cell21 = R50row.getCell(23);
			if (R50cell21 != null) {
				R50cell21.setCellValue(brf94c.getR50_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR50_no_of_transactions_services_gre().intValue());
			}
			Cell R50cell22 = R50row.getCell(24);
			if (R50cell22 != null) {
				R50cell22.setCellValue(brf94c.getR50_amount_services_gre() == null ? 0
						: brf94c.getR50_amount_services_gre().intValue());
			}
			Cell R50cell23 = R50row.getCell(25);
			if (R50cell23 != null) {
				R50cell23.setCellValue(brf94c.getR50_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR50_no_of_transactions_trade_gre().intValue());
			}
			Cell R50cell24 = R50row.getCell(26);
			if (R50cell24 != null) {
				R50cell24.setCellValue(
						brf94c.getR50_amount_trade_gre() == null ? 0 : brf94c.getR50_amount_trade_gre().intValue());
			}
			Cell R50cell25 = R50row.getCell(27);
			if (R50cell25 != null) {
				R50cell25.setCellValue(brf94c.getR50_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR50_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R50cell26 = R50row.getCell(28);
			if (R50cell26 != null) {
				R50cell26.setCellValue(brf94c.getR50_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR50_amount_financial_investment_corporate().intValue());
			}
			Cell R50cell27 = R50row.getCell(29);
			if (R50cell27 != null) {
				R50cell27.setCellValue(brf94c.getR50_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR50_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R50cell28 = R50row.getCell(30);
			if (R50cell28 != null) {
				R50cell28.setCellValue(brf94c.getR50_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR50_amount_direct_investment_corporate().intValue());
			}
			Cell R50cell29 = R50row.getCell(31);
			if (R50cell29 != null) {
				R50cell29.setCellValue(brf94c.getR50_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR50_no_of_transactions_services_corporate().intValue());
			}
			Cell R50cell30 = R50row.getCell(32);
			if (R50cell30 != null) {
				R50cell30.setCellValue(brf94c.getR50_amount_services_corporate() == null ? 0
						: brf94c.getR50_amount_services_corporate().intValue());
			}
			Cell R50cell31 = R50row.getCell(33);
			if (R50cell31 != null) {
				R50cell31.setCellValue(brf94c.getR50_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR50_no_of_transactions_trade_corporate().intValue());
			}
			Cell R50cell32 = R50row.getCell(34);
			if (R50cell32 != null) {
				R50cell32.setCellValue(brf94c.getR50_amount_trade_corporate() == null ? 0
						: brf94c.getR50_amount_trade_corporate().intValue());
			}
			Cell R50cell33 = R50row.getCell(35);
			if (R50cell33 != null) {
				R50cell33.setCellValue(brf94c.getR50_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR50_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R50cell34 = R50row.getCell(36);
			if (R50cell34 != null) {
				R50cell34.setCellValue(brf94c.getR50_amount_financial_investment_sme() == null ? 0
						: brf94c.getR50_amount_financial_investment_sme().intValue());
			}
			Cell R50cell35 = R50row.getCell(37);
			if (R50cell35 != null) {
				R50cell35.setCellValue(brf94c.getR50_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR50_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R50cell36 = R50row.getCell(38);
			if (R50cell36 != null) {
				R50cell36.setCellValue(brf94c.getR50_amount_direct_investment_sme() == null ? 0
						: brf94c.getR50_amount_direct_investment_sme().intValue());
			}
			Cell R50cell37 = R50row.getCell(39);
			if (R50cell37 != null) {
				R50cell37.setCellValue(brf94c.getR50_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR50_no_of_transactions_services_sme().intValue());
			}
			Cell R50cell38 = R50row.getCell(40);
			if (R50cell38 != null) {
				R50cell38.setCellValue(brf94c.getR50_amount_services_sme() == null ? 0
						: brf94c.getR50_amount_services_sme().intValue());
			}
			Cell R50cell39 = R50row.getCell(41);
			if (R50cell39 != null) {
				R50cell39.setCellValue(brf94c.getR50_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR50_no_of_transactions_trade_sme().intValue());
			}
			Cell R50cell40 = R50row.getCell(42);
			if (R50cell40 != null) {
				R50cell40.setCellValue(
						brf94c.getR50_amount_trade_sme() == null ? 0 : brf94c.getR50_amount_trade_sme().intValue());
			}
			Cell R50cell41 = R50row.getCell(43);
			if (R50cell41 != null) {
				R50cell41.setCellValue(brf94c.getR50_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R50cell42 = R50row.getCell(44);
			if (R50cell42 != null) {
				R50cell42.setCellValue(brf94c.getR50_amount_financial_investment_individual() == null ? 0
						: brf94c.getR50_amount_financial_investment_individual().intValue());
			}
			Cell R50cell43 = R50row.getCell(45);
			if (R50cell43 != null) {
				R50cell43.setCellValue(brf94c.getR50_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R50cell44 = R50row.getCell(46);
			if (R50cell44 != null) {
				R50cell44.setCellValue(brf94c.getR50_amount_direct_investment_individual() == null ? 0
						: brf94c.getR50_amount_direct_investment_individual().intValue());
			}
			Cell R50cell45 = R50row.getCell(47);
			if (R50cell45 != null) {
				R50cell45.setCellValue(brf94c.getR50_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_family_support_individual().intValue());
			}
			Cell R50cell46 = R50row.getCell(48);
			if (R50cell46 != null) {
				R50cell46.setCellValue(brf94c.getR50_amount_family_support_individual() == null ? 0
						: brf94c.getR50_amount_family_support_individual().intValue());
			}
			Cell R50cell47 = R50row.getCell(49);
			if (R50cell47 != null) {
				R50cell47.setCellValue(brf94c.getR50_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_education_individual().intValue());
			}
			Cell R50cell48 = R50row.getCell(50);
			if (R50cell48 != null) {
				R50cell48.setCellValue(brf94c.getR50_amount_education_individual() == null ? 0
						: brf94c.getR50_amount_education_individual().intValue());
			}
			Cell R50cell49 = R50row.getCell(51);
			if (R50cell49 != null) {
				R50cell49.setCellValue(brf94c.getR50_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_medical_individual().intValue());
			}

			Cell R50cell50 = R50row.getCell(52);
			if (R50cell50 != null) {
				R50cell50.setCellValue(brf94c.getR50_amount_medical_individual() == null ? 0
						: brf94c.getR50_amount_medical_individual().intValue());
			}
			Cell R50cell51 = R50row.getCell(53);
			if (R50cell51 != null) {
				R50cell51.setCellValue(brf94c.getR50_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_tourism_individual().intValue());
			}
			Cell R50cell52 = R50row.getCell(54);
			if (R50cell52 != null) {
				R50cell52.setCellValue(brf94c.getR50_amount_tourism_individual() == null ? 0
						: brf94c.getR50_amount_tourism_individual().intValue());
			}
			Cell R50cell53 = R50row.getCell(55);
			if (R50cell53 != null) {
				R50cell53.setCellValue(brf94c.getR50_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R50cell54 = R50row.getCell(56);
			if (R50cell54 != null) {
				R50cell54.setCellValue(brf94c.getR50_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR50_amount_debt_settlement_individual().intValue());
			}
			Cell R50cell55 = R50row.getCell(57);
			if (R50cell55 != null) {
				R50cell55.setCellValue(brf94c.getR50_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR50_no_of_transactions_other_services_individual().intValue());
			}

			Cell R50cell56 = R50row.getCell(58);
			if (R50cell56 != null) {
				R50cell56.setCellValue(brf94c.getR50_amount_other_services_individual() == null ? 0
						: brf94c.getR50_amount_other_services_individual().intValue());
			}

			Row R51row = sheet.getRow(59);
			Cell R51cell1 = R51row.getCell(3);
			if (R51cell1 != null) {
				R51cell1.setCellValue(brf94c.getR51_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR51_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R51cell2 = R51row.getCell(4);
			if (R51cell2 != null) {
				R51cell2.setCellValue(brf94c.getR51_amount_financial_investment_government() == null ? 0
						: brf94c.getR51_amount_financial_investment_government().intValue());
			}
			Cell R51cell3 = R51row.getCell(5);
			if (R51cell3 != null) {
				R51cell3.setCellValue(brf94c.getR51_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR51_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R51cell4 = R51row.getCell(6);
			if (R51cell4 != null) {
				R51cell4.setCellValue(brf94c.getR51_amount_direct_investment_government() == null ? 0
						: brf94c.getR51_amount_direct_investment_government().intValue());
			}
			Cell R51cell5 = R51row.getCell(7);
			if (R51cell5 != null) {
				R51cell5.setCellValue(brf94c.getR51_no_of_transactions_services_government() == null ? 0
						: brf94c.getR51_no_of_transactions_services_government().intValue());
			}
			Cell R51cell6 = R51row.getCell(8);
			if (R51cell6 != null) {
				R51cell6.setCellValue(brf94c.getR51_amount_services_government() == null ? 0
						: brf94c.getR51_amount_services_government().intValue());
			}
			Cell R51cell7 = R51row.getCell(9);
			if (R51cell7 != null) {
				R51cell7.setCellValue(brf94c.getR51_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR51_no_of_transactions_trade_government().intValue());
			}
			Cell R51cell8 = R51row.getCell(10);
			if (R51cell8 != null) {
				R51cell8.setCellValue(brf94c.getR51_amount_trade_government() == null ? 0
						: brf94c.getR51_amount_trade_government().intValue());
			}
			Cell R51cell9 = R51row.getCell(11);
			if (R51cell9 != null) {
				R51cell9.setCellValue(brf94c.getR51_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR51_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R51cell10 = R51row.getCell(12);
			if (R51cell10 != null) {
				R51cell10.setCellValue(brf94c.getR51_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR51_amount_financial_investment_reserve().intValue());
			}
			Cell R51cell11 = R51row.getCell(13);
			if (R51cell11 != null) {
				R51cell11.setCellValue(brf94c.getR51_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR51_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R51cell12 = R51row.getCell(14);
			if (R51cell12 != null) {
				R51cell12.setCellValue(brf94c.getR51_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR51_amount_direct_investment_reserve().intValue());
			}
			Cell R51cell13 = R51row.getCell(15);
			if (R51cell13 != null) {
				R51cell13.setCellValue(brf94c.getR51_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR51_no_of_transactions_services_reserve().intValue());
			}
			Cell R51cell14 = R51row.getCell(16);
			if (R51cell14 != null) {
				R51cell14.setCellValue(brf94c.getR51_amount_services_reserve() == null ? 0
						: brf94c.getR51_amount_services_reserve().intValue());
			}
			Cell R51cell15 = R51row.getCell(17);
			if (R51cell15 != null) {
				R51cell15.setCellValue(brf94c.getR51_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR51_no_of_transactions_trade_reserve().intValue());
			}
			Cell R51cell16 = R51row.getCell(18);
			if (R51cell16 != null) {
				R51cell16.setCellValue(brf94c.getR51_amount_trade_reserve() == null ? 0
						: brf94c.getR51_amount_trade_reserve().intValue());
			}
			Cell R51cell17 = R51row.getCell(19);
			if (R51cell17 != null) {
				R51cell17.setCellValue(brf94c.getR51_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR51_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R51cell18 = R51row.getCell(20);
			if (R51cell18 != null) {
				R51cell18.setCellValue(brf94c.getR51_amount_financial_investment_gre() == null ? 0
						: brf94c.getR51_amount_financial_investment_gre().intValue());
			}
			Cell R51cell19 = R51row.getCell(21);
			if (R51cell19 != null) {
				R51cell19.setCellValue(brf94c.getR51_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR51_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R51cell20 = R51row.getCell(22);
			if (R51cell20 != null) {
				R51cell20.setCellValue(brf94c.getR51_amount_direct_investment_gre() == null ? 0
						: brf94c.getR51_amount_direct_investment_gre().intValue());
			}
			Cell R51cell21 = R51row.getCell(23);
			if (R51cell21 != null) {
				R51cell21.setCellValue(brf94c.getR51_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR51_no_of_transactions_services_gre().intValue());
			}
			Cell R51cell22 = R51row.getCell(24);
			if (R51cell22 != null) {
				R51cell22.setCellValue(brf94c.getR51_amount_services_gre() == null ? 0
						: brf94c.getR51_amount_services_gre().intValue());
			}
			Cell R51cell23 = R51row.getCell(25);
			if (R51cell23 != null) {
				R51cell23.setCellValue(brf94c.getR51_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR51_no_of_transactions_trade_gre().intValue());
			}
			Cell R51cell24 = R51row.getCell(26);
			if (R51cell24 != null) {
				R51cell24.setCellValue(
						brf94c.getR51_amount_trade_gre() == null ? 0 : brf94c.getR51_amount_trade_gre().intValue());
			}
			Cell R51cell25 = R51row.getCell(27);
			if (R51cell25 != null) {
				R51cell25.setCellValue(brf94c.getR51_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR51_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R51cell26 = R51row.getCell(28);
			if (R51cell26 != null) {
				R51cell26.setCellValue(brf94c.getR51_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR51_amount_financial_investment_corporate().intValue());
			}
			Cell R51cell27 = R51row.getCell(29);
			if (R51cell27 != null) {
				R51cell27.setCellValue(brf94c.getR51_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR51_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R51cell28 = R51row.getCell(30);
			if (R51cell28 != null) {
				R51cell28.setCellValue(brf94c.getR51_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR51_amount_direct_investment_corporate().intValue());
			}
			Cell R51cell29 = R51row.getCell(31);
			if (R51cell29 != null) {
				R51cell29.setCellValue(brf94c.getR51_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR51_no_of_transactions_services_corporate().intValue());
			}
			Cell R51cell30 = R51row.getCell(32);
			if (R51cell30 != null) {
				R51cell30.setCellValue(brf94c.getR51_amount_services_corporate() == null ? 0
						: brf94c.getR51_amount_services_corporate().intValue());
			}
			Cell R51cell31 = R51row.getCell(33);
			if (R51cell31 != null) {
				R51cell31.setCellValue(brf94c.getR51_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR51_no_of_transactions_trade_corporate().intValue());
			}
			Cell R51cell32 = R51row.getCell(34);
			if (R51cell32 != null) {
				R51cell32.setCellValue(brf94c.getR51_amount_trade_corporate() == null ? 0
						: brf94c.getR51_amount_trade_corporate().intValue());
			}
			Cell R51cell33 = R51row.getCell(35);
			if (R51cell33 != null) {
				R51cell33.setCellValue(brf94c.getR51_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR51_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R51cell34 = R51row.getCell(36);
			if (R51cell34 != null) {
				R51cell34.setCellValue(brf94c.getR51_amount_financial_investment_sme() == null ? 0
						: brf94c.getR51_amount_financial_investment_sme().intValue());
			}
			Cell R51cell35 = R51row.getCell(37);
			if (R51cell35 != null) {
				R51cell35.setCellValue(brf94c.getR51_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR51_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R51cell36 = R51row.getCell(38);
			if (R51cell36 != null) {
				R51cell36.setCellValue(brf94c.getR51_amount_direct_investment_sme() == null ? 0
						: brf94c.getR51_amount_direct_investment_sme().intValue());
			}
			Cell R51cell37 = R51row.getCell(39);
			if (R51cell37 != null) {
				R51cell37.setCellValue(brf94c.getR51_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR51_no_of_transactions_services_sme().intValue());
			}
			Cell R51cell38 = R51row.getCell(40);
			if (R51cell38 != null) {
				R51cell38.setCellValue(brf94c.getR51_amount_services_sme() == null ? 0
						: brf94c.getR51_amount_services_sme().intValue());
			}
			Cell R51cell39 = R51row.getCell(41);
			if (R51cell39 != null) {
				R51cell39.setCellValue(brf94c.getR51_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR51_no_of_transactions_trade_sme().intValue());
			}
			Cell R51cell40 = R51row.getCell(42);
			if (R51cell40 != null) {
				R51cell40.setCellValue(
						brf94c.getR51_amount_trade_sme() == null ? 0 : brf94c.getR51_amount_trade_sme().intValue());
			}
			Cell R51cell41 = R51row.getCell(43);
			if (R51cell41 != null) {
				R51cell41.setCellValue(brf94c.getR51_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R51cell42 = R51row.getCell(44);
			if (R51cell42 != null) {
				R51cell42.setCellValue(brf94c.getR51_amount_financial_investment_individual() == null ? 0
						: brf94c.getR51_amount_financial_investment_individual().intValue());
			}
			Cell R51cell43 = R51row.getCell(45);
			if (R51cell43 != null) {
				R51cell43.setCellValue(brf94c.getR51_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R51cell44 = R51row.getCell(46);
			if (R51cell44 != null) {
				R51cell44.setCellValue(brf94c.getR51_amount_direct_investment_individual() == null ? 0
						: brf94c.getR51_amount_direct_investment_individual().intValue());
			}
			Cell R51cell45 = R51row.getCell(47);
			if (R51cell45 != null) {
				R51cell45.setCellValue(brf94c.getR51_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_family_support_individual().intValue());
			}
			Cell R51cell46 = R51row.getCell(48);
			if (R51cell46 != null) {
				R51cell46.setCellValue(brf94c.getR51_amount_family_support_individual() == null ? 0
						: brf94c.getR51_amount_family_support_individual().intValue());
			}
			Cell R51cell47 = R51row.getCell(49);
			if (R51cell47 != null) {
				R51cell47.setCellValue(brf94c.getR51_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_education_individual().intValue());
			}
			Cell R51cell48 = R51row.getCell(50);
			if (R51cell48 != null) {
				R51cell48.setCellValue(brf94c.getR51_amount_education_individual() == null ? 0
						: brf94c.getR51_amount_education_individual().intValue());
			}
			Cell R51cell49 = R51row.getCell(51);
			if (R51cell49 != null) {
				R51cell49.setCellValue(brf94c.getR51_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_medical_individual().intValue());
			}

			Cell R51cell50 = R51row.getCell(52);
			if (R51cell50 != null) {
				R51cell50.setCellValue(brf94c.getR51_amount_medical_individual() == null ? 0
						: brf94c.getR51_amount_medical_individual().intValue());
			}
			Cell R51cell51 = R51row.getCell(53);
			if (R51cell51 != null) {
				R51cell51.setCellValue(brf94c.getR51_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_tourism_individual().intValue());
			}
			Cell R51cell52 = R51row.getCell(54);
			if (R51cell52 != null) {
				R51cell52.setCellValue(brf94c.getR51_amount_tourism_individual() == null ? 0
						: brf94c.getR51_amount_tourism_individual().intValue());
			}
			Cell R51cell53 = R51row.getCell(55);
			if (R51cell53 != null) {
				R51cell53.setCellValue(brf94c.getR51_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R51cell54 = R51row.getCell(56);
			if (R51cell54 != null) {
				R51cell54.setCellValue(brf94c.getR51_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR51_amount_debt_settlement_individual().intValue());
			}
			Cell R51cell55 = R51row.getCell(57);
			if (R51cell55 != null) {
				R51cell55.setCellValue(brf94c.getR51_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR51_no_of_transactions_other_services_individual().intValue());
			}

			Cell R51cell56 = R51row.getCell(58);
			if (R51cell56 != null) {
				R51cell56.setCellValue(brf94c.getR51_amount_other_services_individual() == null ? 0
						: brf94c.getR51_amount_other_services_individual().intValue());
			}

			Row R52row = sheet.getRow(60);
			Cell R52cell1 = R52row.getCell(3);
			if (R52cell1 != null) {
				R52cell1.setCellValue(brf94c.getR52_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR52_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R52cell2 = R52row.getCell(4);
			if (R52cell2 != null) {
				R52cell2.setCellValue(brf94c.getR52_amount_financial_investment_government() == null ? 0
						: brf94c.getR52_amount_financial_investment_government().intValue());
			}
			Cell R52cell3 = R52row.getCell(5);
			if (R52cell3 != null) {
				R52cell3.setCellValue(brf94c.getR52_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR52_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R52cell4 = R52row.getCell(6);
			if (R52cell4 != null) {
				R52cell4.setCellValue(brf94c.getR52_amount_direct_investment_government() == null ? 0
						: brf94c.getR52_amount_direct_investment_government().intValue());
			}
			Cell R52cell5 = R52row.getCell(7);
			if (R52cell5 != null) {
				R52cell5.setCellValue(brf94c.getR52_no_of_transactions_services_government() == null ? 0
						: brf94c.getR52_no_of_transactions_services_government().intValue());
			}
			Cell R52cell6 = R52row.getCell(8);
			if (R52cell6 != null) {
				R52cell6.setCellValue(brf94c.getR52_amount_services_government() == null ? 0
						: brf94c.getR52_amount_services_government().intValue());
			}
			Cell R52cell7 = R52row.getCell(9);
			if (R52cell7 != null) {
				R52cell7.setCellValue(brf94c.getR52_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR52_no_of_transactions_trade_government().intValue());
			}
			Cell R52cell8 = R52row.getCell(10);
			if (R52cell8 != null) {
				R52cell8.setCellValue(brf94c.getR52_amount_trade_government() == null ? 0
						: brf94c.getR52_amount_trade_government().intValue());
			}
			Cell R52cell9 = R52row.getCell(11);
			if (R52cell9 != null) {
				R52cell9.setCellValue(brf94c.getR52_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR52_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R52cell10 = R52row.getCell(12);
			if (R52cell10 != null) {
				R52cell10.setCellValue(brf94c.getR52_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR52_amount_financial_investment_reserve().intValue());
			}
			Cell R52cell11 = R52row.getCell(13);
			if (R52cell11 != null) {
				R52cell11.setCellValue(brf94c.getR52_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR52_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R52cell12 = R52row.getCell(14);
			if (R52cell12 != null) {
				R52cell12.setCellValue(brf94c.getR52_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR52_amount_direct_investment_reserve().intValue());
			}
			Cell R52cell13 = R52row.getCell(15);
			if (R52cell13 != null) {
				R52cell13.setCellValue(brf94c.getR52_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR52_no_of_transactions_services_reserve().intValue());
			}
			Cell R52cell14 = R52row.getCell(16);
			if (R52cell14 != null) {
				R52cell14.setCellValue(brf94c.getR52_amount_services_reserve() == null ? 0
						: brf94c.getR52_amount_services_reserve().intValue());
			}
			Cell R52cell15 = R52row.getCell(17);
			if (R52cell15 != null) {
				R52cell15.setCellValue(brf94c.getR52_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR52_no_of_transactions_trade_reserve().intValue());
			}
			Cell R52cell16 = R52row.getCell(18);
			if (R52cell16 != null) {
				R52cell16.setCellValue(brf94c.getR52_amount_trade_reserve() == null ? 0
						: brf94c.getR52_amount_trade_reserve().intValue());
			}
			Cell R52cell17 = R52row.getCell(19);
			if (R52cell17 != null) {
				R52cell17.setCellValue(brf94c.getR52_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR52_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R52cell18 = R52row.getCell(20);
			if (R52cell18 != null) {
				R52cell18.setCellValue(brf94c.getR52_amount_financial_investment_gre() == null ? 0
						: brf94c.getR52_amount_financial_investment_gre().intValue());
			}
			Cell R52cell19 = R52row.getCell(21);
			if (R52cell19 != null) {
				R52cell19.setCellValue(brf94c.getR52_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR52_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R52cell20 = R52row.getCell(22);
			if (R52cell20 != null) {
				R52cell20.setCellValue(brf94c.getR52_amount_direct_investment_gre() == null ? 0
						: brf94c.getR52_amount_direct_investment_gre().intValue());
			}
			Cell R52cell21 = R52row.getCell(23);
			if (R52cell21 != null) {
				R52cell21.setCellValue(brf94c.getR52_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR52_no_of_transactions_services_gre().intValue());
			}
			Cell R52cell22 = R52row.getCell(24);
			if (R52cell22 != null) {
				R52cell22.setCellValue(brf94c.getR52_amount_services_gre() == null ? 0
						: brf94c.getR52_amount_services_gre().intValue());
			}
			Cell R52cell23 = R52row.getCell(25);
			if (R52cell23 != null) {
				R52cell23.setCellValue(brf94c.getR52_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR52_no_of_transactions_trade_gre().intValue());
			}
			Cell R52cell24 = R52row.getCell(26);
			if (R52cell24 != null) {
				R52cell24.setCellValue(
						brf94c.getR52_amount_trade_gre() == null ? 0 : brf94c.getR52_amount_trade_gre().intValue());
			}
			Cell R52cell25 = R52row.getCell(27);
			if (R52cell25 != null) {
				R52cell25.setCellValue(brf94c.getR52_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR52_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R52cell26 = R52row.getCell(28);
			if (R52cell26 != null) {
				R52cell26.setCellValue(brf94c.getR52_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR52_amount_financial_investment_corporate().intValue());
			}
			Cell R52cell27 = R52row.getCell(29);
			if (R52cell27 != null) {
				R52cell27.setCellValue(brf94c.getR52_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR52_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R52cell28 = R52row.getCell(30);
			if (R52cell28 != null) {
				R52cell28.setCellValue(brf94c.getR52_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR52_amount_direct_investment_corporate().intValue());
			}
			Cell R52cell29 = R52row.getCell(31);
			if (R52cell29 != null) {
				R52cell29.setCellValue(brf94c.getR52_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR52_no_of_transactions_services_corporate().intValue());
			}
			Cell R52cell30 = R52row.getCell(32);
			if (R52cell30 != null) {
				R52cell30.setCellValue(brf94c.getR52_amount_services_corporate() == null ? 0
						: brf94c.getR52_amount_services_corporate().intValue());
			}
			Cell R52cell31 = R52row.getCell(33);
			if (R52cell31 != null) {
				R52cell31.setCellValue(brf94c.getR52_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR52_no_of_transactions_trade_corporate().intValue());
			}
			Cell R52cell32 = R52row.getCell(34);
			if (R52cell32 != null) {
				R52cell32.setCellValue(brf94c.getR52_amount_trade_corporate() == null ? 0
						: brf94c.getR52_amount_trade_corporate().intValue());
			}
			Cell R52cell33 = R52row.getCell(35);
			if (R52cell33 != null) {
				R52cell33.setCellValue(brf94c.getR52_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR52_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R52cell34 = R52row.getCell(36);
			if (R52cell34 != null) {
				R52cell34.setCellValue(brf94c.getR52_amount_financial_investment_sme() == null ? 0
						: brf94c.getR52_amount_financial_investment_sme().intValue());
			}
			Cell R52cell35 = R52row.getCell(37);
			if (R52cell35 != null) {
				R52cell35.setCellValue(brf94c.getR52_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR52_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R52cell36 = R52row.getCell(38);
			if (R52cell36 != null) {
				R52cell36.setCellValue(brf94c.getR52_amount_direct_investment_sme() == null ? 0
						: brf94c.getR52_amount_direct_investment_sme().intValue());
			}
			Cell R52cell37 = R52row.getCell(39);
			if (R52cell37 != null) {
				R52cell37.setCellValue(brf94c.getR52_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR52_no_of_transactions_services_sme().intValue());
			}
			Cell R52cell38 = R52row.getCell(40);
			if (R52cell38 != null) {
				R52cell38.setCellValue(brf94c.getR52_amount_services_sme() == null ? 0
						: brf94c.getR52_amount_services_sme().intValue());
			}
			Cell R52cell39 = R52row.getCell(41);
			if (R52cell39 != null) {
				R52cell39.setCellValue(brf94c.getR52_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR52_no_of_transactions_trade_sme().intValue());
			}
			Cell R52cell40 = R52row.getCell(42);
			if (R52cell40 != null) {
				R52cell40.setCellValue(
						brf94c.getR52_amount_trade_sme() == null ? 0 : brf94c.getR52_amount_trade_sme().intValue());
			}
			Cell R52cell41 = R52row.getCell(43);
			if (R52cell41 != null) {
				R52cell41.setCellValue(brf94c.getR52_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R52cell42 = R52row.getCell(44);
			if (R52cell42 != null) {
				R52cell42.setCellValue(brf94c.getR52_amount_financial_investment_individual() == null ? 0
						: brf94c.getR52_amount_financial_investment_individual().intValue());
			}
			Cell R52cell43 = R52row.getCell(45);
			if (R52cell43 != null) {
				R52cell43.setCellValue(brf94c.getR52_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R52cell44 = R52row.getCell(46);
			if (R52cell44 != null) {
				R52cell44.setCellValue(brf94c.getR52_amount_direct_investment_individual() == null ? 0
						: brf94c.getR52_amount_direct_investment_individual().intValue());
			}
			Cell R52cell45 = R52row.getCell(47);
			if (R52cell45 != null) {
				R52cell45.setCellValue(brf94c.getR52_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_family_support_individual().intValue());
			}
			Cell R52cell46 = R52row.getCell(48);
			if (R52cell46 != null) {
				R52cell46.setCellValue(brf94c.getR52_amount_family_support_individual() == null ? 0
						: brf94c.getR52_amount_family_support_individual().intValue());
			}
			Cell R52cell47 = R52row.getCell(49);
			if (R52cell47 != null) {
				R52cell47.setCellValue(brf94c.getR52_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_education_individual().intValue());
			}
			Cell R52cell48 = R52row.getCell(50);
			if (R52cell48 != null) {
				R52cell48.setCellValue(brf94c.getR52_amount_education_individual() == null ? 0
						: brf94c.getR52_amount_education_individual().intValue());
			}
			Cell R52cell49 = R52row.getCell(51);
			if (R52cell49 != null) {
				R52cell49.setCellValue(brf94c.getR52_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_medical_individual().intValue());
			}

			Cell R52cell50 = R52row.getCell(52);
			if (R52cell50 != null) {
				R52cell50.setCellValue(brf94c.getR52_amount_medical_individual() == null ? 0
						: brf94c.getR52_amount_medical_individual().intValue());
			}
			Cell R52cell51 = R52row.getCell(53);
			if (R52cell51 != null) {
				R52cell51.setCellValue(brf94c.getR52_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_tourism_individual().intValue());
			}
			Cell R52cell52 = R52row.getCell(54);
			if (R52cell52 != null) {
				R52cell52.setCellValue(brf94c.getR52_amount_tourism_individual() == null ? 0
						: brf94c.getR52_amount_tourism_individual().intValue());
			}
			Cell R52cell53 = R52row.getCell(55);
			if (R52cell53 != null) {
				R52cell53.setCellValue(brf94c.getR52_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R52cell54 = R52row.getCell(56);
			if (R52cell54 != null) {
				R52cell54.setCellValue(brf94c.getR52_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR52_amount_debt_settlement_individual().intValue());
			}
			Cell R52cell55 = R52row.getCell(57);
			if (R52cell55 != null) {
				R52cell55.setCellValue(brf94c.getR52_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR52_no_of_transactions_other_services_individual().intValue());
			}

			Cell R52cell56 = R52row.getCell(58);
			if (R52cell56 != null) {
				R52cell56.setCellValue(brf94c.getR52_amount_other_services_individual() == null ? 0
						: brf94c.getR52_amount_other_services_individual().intValue());
			}

			Row R53row = sheet.getRow(61);
			Cell R53cell1 = R53row.getCell(3);
			if (R53cell1 != null) {
				R53cell1.setCellValue(brf94c.getR53_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR53_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R53cell2 = R53row.getCell(4);
			if (R53cell2 != null) {
				R53cell2.setCellValue(brf94c.getR53_amount_financial_investment_government() == null ? 0
						: brf94c.getR53_amount_financial_investment_government().intValue());
			}
			Cell R53cell3 = R53row.getCell(5);
			if (R53cell3 != null) {
				R53cell3.setCellValue(brf94c.getR53_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR53_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R53cell4 = R53row.getCell(6);
			if (R53cell4 != null) {
				R53cell4.setCellValue(brf94c.getR53_amount_direct_investment_government() == null ? 0
						: brf94c.getR53_amount_direct_investment_government().intValue());
			}
			Cell R53cell5 = R53row.getCell(7);
			if (R53cell5 != null) {
				R53cell5.setCellValue(brf94c.getR53_no_of_transactions_services_government() == null ? 0
						: brf94c.getR53_no_of_transactions_services_government().intValue());
			}
			Cell R53cell6 = R53row.getCell(8);
			if (R53cell6 != null) {
				R53cell6.setCellValue(brf94c.getR53_amount_services_government() == null ? 0
						: brf94c.getR53_amount_services_government().intValue());
			}
			Cell R53cell7 = R53row.getCell(9);
			if (R53cell7 != null) {
				R53cell7.setCellValue(brf94c.getR53_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR53_no_of_transactions_trade_government().intValue());
			}
			Cell R53cell8 = R53row.getCell(10);
			if (R53cell8 != null) {
				R53cell8.setCellValue(brf94c.getR53_amount_trade_government() == null ? 0
						: brf94c.getR53_amount_trade_government().intValue());
			}
			Cell R53cell9 = R53row.getCell(11);
			if (R53cell9 != null) {
				R53cell9.setCellValue(brf94c.getR53_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR53_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R53cell10 = R53row.getCell(12);
			if (R53cell10 != null) {
				R53cell10.setCellValue(brf94c.getR53_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR53_amount_financial_investment_reserve().intValue());
			}
			Cell R53cell11 = R53row.getCell(13);
			if (R53cell11 != null) {
				R53cell11.setCellValue(brf94c.getR53_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR53_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R53cell12 = R53row.getCell(14);
			if (R53cell12 != null) {
				R53cell12.setCellValue(brf94c.getR53_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR53_amount_direct_investment_reserve().intValue());
			}
			Cell R53cell13 = R53row.getCell(15);
			if (R53cell13 != null) {
				R53cell13.setCellValue(brf94c.getR53_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR53_no_of_transactions_services_reserve().intValue());
			}
			Cell R53cell14 = R53row.getCell(16);
			if (R53cell14 != null) {
				R53cell14.setCellValue(brf94c.getR53_amount_services_reserve() == null ? 0
						: brf94c.getR53_amount_services_reserve().intValue());
			}
			Cell R53cell15 = R53row.getCell(17);
			if (R53cell15 != null) {
				R53cell15.setCellValue(brf94c.getR53_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR53_no_of_transactions_trade_reserve().intValue());
			}
			Cell R53cell16 = R53row.getCell(18);
			if (R53cell16 != null) {
				R53cell16.setCellValue(brf94c.getR53_amount_trade_reserve() == null ? 0
						: brf94c.getR53_amount_trade_reserve().intValue());
			}
			Cell R53cell17 = R53row.getCell(19);
			if (R53cell17 != null) {
				R53cell17.setCellValue(brf94c.getR53_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR53_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R53cell18 = R53row.getCell(20);
			if (R53cell18 != null) {
				R53cell18.setCellValue(brf94c.getR53_amount_financial_investment_gre() == null ? 0
						: brf94c.getR53_amount_financial_investment_gre().intValue());
			}
			Cell R53cell19 = R53row.getCell(21);
			if (R53cell19 != null) {
				R53cell19.setCellValue(brf94c.getR53_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR53_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R53cell20 = R53row.getCell(22);
			if (R53cell20 != null) {
				R53cell20.setCellValue(brf94c.getR53_amount_direct_investment_gre() == null ? 0
						: brf94c.getR53_amount_direct_investment_gre().intValue());
			}
			Cell R53cell21 = R53row.getCell(23);
			if (R53cell21 != null) {
				R53cell21.setCellValue(brf94c.getR53_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR53_no_of_transactions_services_gre().intValue());
			}
			Cell R53cell22 = R53row.getCell(24);
			if (R53cell22 != null) {
				R53cell22.setCellValue(brf94c.getR53_amount_services_gre() == null ? 0
						: brf94c.getR53_amount_services_gre().intValue());
			}
			Cell R53cell23 = R53row.getCell(25);
			if (R53cell23 != null) {
				R53cell23.setCellValue(brf94c.getR53_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR53_no_of_transactions_trade_gre().intValue());
			}
			Cell R53cell24 = R53row.getCell(26);
			if (R53cell24 != null) {
				R53cell24.setCellValue(
						brf94c.getR53_amount_trade_gre() == null ? 0 : brf94c.getR53_amount_trade_gre().intValue());
			}
			Cell R53cell25 = R53row.getCell(27);
			if (R53cell25 != null) {
				R53cell25.setCellValue(brf94c.getR53_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR53_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R53cell26 = R53row.getCell(28);
			if (R53cell26 != null) {
				R53cell26.setCellValue(brf94c.getR53_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR53_amount_financial_investment_corporate().intValue());
			}
			Cell R53cell27 = R53row.getCell(29);
			if (R53cell27 != null) {
				R53cell27.setCellValue(brf94c.getR53_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR53_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R53cell28 = R53row.getCell(30);
			if (R53cell28 != null) {
				R53cell28.setCellValue(brf94c.getR53_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR53_amount_direct_investment_corporate().intValue());
			}
			Cell R53cell29 = R53row.getCell(31);
			if (R53cell29 != null) {
				R53cell29.setCellValue(brf94c.getR53_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR53_no_of_transactions_services_corporate().intValue());
			}
			Cell R53cell30 = R53row.getCell(32);
			if (R53cell30 != null) {
				R53cell30.setCellValue(brf94c.getR53_amount_services_corporate() == null ? 0
						: brf94c.getR53_amount_services_corporate().intValue());
			}
			Cell R53cell31 = R53row.getCell(33);
			if (R53cell31 != null) {
				R53cell31.setCellValue(brf94c.getR53_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR53_no_of_transactions_trade_corporate().intValue());
			}
			Cell R53cell32 = R53row.getCell(34);
			if (R53cell32 != null) {
				R53cell32.setCellValue(brf94c.getR53_amount_trade_corporate() == null ? 0
						: brf94c.getR53_amount_trade_corporate().intValue());
			}
			Cell R53cell33 = R53row.getCell(35);
			if (R53cell33 != null) {
				R53cell33.setCellValue(brf94c.getR53_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR53_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R53cell34 = R53row.getCell(36);
			if (R53cell34 != null) {
				R53cell34.setCellValue(brf94c.getR53_amount_financial_investment_sme() == null ? 0
						: brf94c.getR53_amount_financial_investment_sme().intValue());
			}
			Cell R53cell35 = R53row.getCell(37);
			if (R53cell35 != null) {
				R53cell35.setCellValue(brf94c.getR53_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR53_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R53cell36 = R53row.getCell(38);
			if (R53cell36 != null) {
				R53cell36.setCellValue(brf94c.getR53_amount_direct_investment_sme() == null ? 0
						: brf94c.getR53_amount_direct_investment_sme().intValue());
			}
			Cell R53cell37 = R53row.getCell(39);
			if (R53cell37 != null) {
				R53cell37.setCellValue(brf94c.getR53_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR53_no_of_transactions_services_sme().intValue());
			}
			Cell R53cell38 = R53row.getCell(40);
			if (R53cell38 != null) {
				R53cell38.setCellValue(brf94c.getR53_amount_services_sme() == null ? 0
						: brf94c.getR53_amount_services_sme().intValue());
			}
			Cell R53cell39 = R53row.getCell(41);
			if (R53cell39 != null) {
				R53cell39.setCellValue(brf94c.getR53_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR53_no_of_transactions_trade_sme().intValue());
			}
			Cell R53cell40 = R53row.getCell(42);
			if (R53cell40 != null) {
				R53cell40.setCellValue(
						brf94c.getR53_amount_trade_sme() == null ? 0 : brf94c.getR53_amount_trade_sme().intValue());
			}
			Cell R53cell41 = R53row.getCell(43);
			if (R53cell41 != null) {
				R53cell41.setCellValue(brf94c.getR53_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R53cell42 = R53row.getCell(44);
			if (R53cell42 != null) {
				R53cell42.setCellValue(brf94c.getR53_amount_financial_investment_individual() == null ? 0
						: brf94c.getR53_amount_financial_investment_individual().intValue());
			}
			Cell R53cell43 = R53row.getCell(45);
			if (R53cell43 != null) {
				R53cell43.setCellValue(brf94c.getR53_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R53cell44 = R53row.getCell(46);
			if (R53cell44 != null) {
				R53cell44.setCellValue(brf94c.getR53_amount_direct_investment_individual() == null ? 0
						: brf94c.getR53_amount_direct_investment_individual().intValue());
			}
			Cell R53cell45 = R53row.getCell(47);
			if (R53cell45 != null) {
				R53cell45.setCellValue(brf94c.getR53_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_family_support_individual().intValue());
			}
			Cell R53cell46 = R53row.getCell(48);
			if (R53cell46 != null) {
				R53cell46.setCellValue(brf94c.getR53_amount_family_support_individual() == null ? 0
						: brf94c.getR53_amount_family_support_individual().intValue());
			}
			Cell R53cell47 = R53row.getCell(49);
			if (R53cell47 != null) {
				R53cell47.setCellValue(brf94c.getR53_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_education_individual().intValue());
			}
			Cell R53cell48 = R53row.getCell(50);
			if (R53cell48 != null) {
				R53cell48.setCellValue(brf94c.getR53_amount_education_individual() == null ? 0
						: brf94c.getR53_amount_education_individual().intValue());
			}
			Cell R53cell49 = R53row.getCell(51);
			if (R53cell49 != null) {
				R53cell49.setCellValue(brf94c.getR53_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_medical_individual().intValue());
			}

			Cell R53cell50 = R53row.getCell(52);
			if (R53cell50 != null) {
				R53cell50.setCellValue(brf94c.getR53_amount_medical_individual() == null ? 0
						: brf94c.getR53_amount_medical_individual().intValue());
			}
			Cell R53cell51 = R53row.getCell(53);
			if (R53cell51 != null) {
				R53cell51.setCellValue(brf94c.getR53_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_tourism_individual().intValue());
			}
			Cell R53cell52 = R53row.getCell(54);
			if (R53cell52 != null) {
				R53cell52.setCellValue(brf94c.getR53_amount_tourism_individual() == null ? 0
						: brf94c.getR53_amount_tourism_individual().intValue());
			}
			Cell R53cell53 = R53row.getCell(55);
			if (R53cell53 != null) {
				R53cell53.setCellValue(brf94c.getR53_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R53cell54 = R53row.getCell(56);
			if (R53cell54 != null) {
				R53cell54.setCellValue(brf94c.getR53_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR53_amount_debt_settlement_individual().intValue());
			}
			Cell R53cell55 = R53row.getCell(57);
			if (R53cell55 != null) {
				R53cell55.setCellValue(brf94c.getR53_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR53_no_of_transactions_other_services_individual().intValue());
			}

			Cell R53cell56 = R53row.getCell(58);
			if (R53cell56 != null) {
				R53cell56.setCellValue(brf94c.getR53_amount_other_services_individual() == null ? 0
						: brf94c.getR53_amount_other_services_individual().intValue());
			}

			Row R54row = sheet.getRow(62);
			Cell R54cell1 = R54row.getCell(3);
			if (R54cell1 != null) {
				R54cell1.setCellValue(brf94c.getR54_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR54_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R54cell2 = R54row.getCell(4);
			if (R54cell2 != null) {
				R54cell2.setCellValue(brf94c.getR54_amount_financial_investment_government() == null ? 0
						: brf94c.getR54_amount_financial_investment_government().intValue());
			}
			Cell R54cell3 = R54row.getCell(5);
			if (R54cell3 != null) {
				R54cell3.setCellValue(brf94c.getR54_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR54_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R54cell4 = R54row.getCell(6);
			if (R54cell4 != null) {
				R54cell4.setCellValue(brf94c.getR54_amount_direct_investment_government() == null ? 0
						: brf94c.getR54_amount_direct_investment_government().intValue());
			}
			Cell R54cell5 = R54row.getCell(7);
			if (R54cell5 != null) {
				R54cell5.setCellValue(brf94c.getR54_no_of_transactions_services_government() == null ? 0
						: brf94c.getR54_no_of_transactions_services_government().intValue());
			}
			Cell R54cell6 = R54row.getCell(8);
			if (R54cell6 != null) {
				R54cell6.setCellValue(brf94c.getR54_amount_services_government() == null ? 0
						: brf94c.getR54_amount_services_government().intValue());
			}
			Cell R54cell7 = R54row.getCell(9);
			if (R54cell7 != null) {
				R54cell7.setCellValue(brf94c.getR54_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR54_no_of_transactions_trade_government().intValue());
			}
			Cell R54cell8 = R54row.getCell(10);
			if (R54cell8 != null) {
				R54cell8.setCellValue(brf94c.getR54_amount_trade_government() == null ? 0
						: brf94c.getR54_amount_trade_government().intValue());
			}
			Cell R54cell9 = R54row.getCell(11);
			if (R54cell9 != null) {
				R54cell9.setCellValue(brf94c.getR54_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR54_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R54cell10 = R54row.getCell(12);
			if (R54cell10 != null) {
				R54cell10.setCellValue(brf94c.getR54_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR54_amount_financial_investment_reserve().intValue());
			}
			Cell R54cell11 = R54row.getCell(13);
			if (R54cell11 != null) {
				R54cell11.setCellValue(brf94c.getR54_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR54_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R54cell12 = R54row.getCell(14);
			if (R54cell12 != null) {
				R54cell12.setCellValue(brf94c.getR54_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR54_amount_direct_investment_reserve().intValue());
			}
			Cell R54cell13 = R54row.getCell(15);
			if (R54cell13 != null) {
				R54cell13.setCellValue(brf94c.getR54_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR54_no_of_transactions_services_reserve().intValue());
			}
			Cell R54cell14 = R54row.getCell(16);
			if (R54cell14 != null) {
				R54cell14.setCellValue(brf94c.getR54_amount_services_reserve() == null ? 0
						: brf94c.getR54_amount_services_reserve().intValue());
			}
			Cell R54cell15 = R54row.getCell(17);
			if (R54cell15 != null) {
				R54cell15.setCellValue(brf94c.getR54_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR54_no_of_transactions_trade_reserve().intValue());
			}
			Cell R54cell16 = R54row.getCell(18);
			if (R54cell16 != null) {
				R54cell16.setCellValue(brf94c.getR54_amount_trade_reserve() == null ? 0
						: brf94c.getR54_amount_trade_reserve().intValue());
			}
			Cell R54cell17 = R54row.getCell(19);
			if (R54cell17 != null) {
				R54cell17.setCellValue(brf94c.getR54_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR54_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R54cell18 = R54row.getCell(20);
			if (R54cell18 != null) {
				R54cell18.setCellValue(brf94c.getR54_amount_financial_investment_gre() == null ? 0
						: brf94c.getR54_amount_financial_investment_gre().intValue());
			}
			Cell R54cell19 = R54row.getCell(21);
			if (R54cell19 != null) {
				R54cell19.setCellValue(brf94c.getR54_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR54_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R54cell20 = R54row.getCell(22);
			if (R54cell20 != null) {
				R54cell20.setCellValue(brf94c.getR54_amount_direct_investment_gre() == null ? 0
						: brf94c.getR54_amount_direct_investment_gre().intValue());
			}
			Cell R54cell21 = R54row.getCell(23);
			if (R54cell21 != null) {
				R54cell21.setCellValue(brf94c.getR54_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR54_no_of_transactions_services_gre().intValue());
			}
			Cell R54cell22 = R54row.getCell(24);
			if (R54cell22 != null) {
				R54cell22.setCellValue(brf94c.getR54_amount_services_gre() == null ? 0
						: brf94c.getR54_amount_services_gre().intValue());
			}
			Cell R54cell23 = R54row.getCell(25);
			if (R54cell23 != null) {
				R54cell23.setCellValue(brf94c.getR54_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR54_no_of_transactions_trade_gre().intValue());
			}
			Cell R54cell24 = R54row.getCell(26);
			if (R54cell24 != null) {
				R54cell24.setCellValue(
						brf94c.getR54_amount_trade_gre() == null ? 0 : brf94c.getR54_amount_trade_gre().intValue());
			}
			Cell R54cell25 = R54row.getCell(27);
			if (R54cell25 != null) {
				R54cell25.setCellValue(brf94c.getR54_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR54_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R54cell26 = R54row.getCell(28);
			if (R54cell26 != null) {
				R54cell26.setCellValue(brf94c.getR54_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR54_amount_financial_investment_corporate().intValue());
			}
			Cell R54cell27 = R54row.getCell(29);
			if (R54cell27 != null) {
				R54cell27.setCellValue(brf94c.getR54_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR54_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R54cell28 = R54row.getCell(30);
			if (R54cell28 != null) {
				R54cell28.setCellValue(brf94c.getR54_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR54_amount_direct_investment_corporate().intValue());
			}
			Cell R54cell29 = R54row.getCell(31);
			if (R54cell29 != null) {
				R54cell29.setCellValue(brf94c.getR54_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR54_no_of_transactions_services_corporate().intValue());
			}
			Cell R54cell30 = R54row.getCell(32);
			if (R54cell30 != null) {
				R54cell30.setCellValue(brf94c.getR54_amount_services_corporate() == null ? 0
						: brf94c.getR54_amount_services_corporate().intValue());
			}
			Cell R54cell31 = R54row.getCell(33);
			if (R54cell31 != null) {
				R54cell31.setCellValue(brf94c.getR54_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR54_no_of_transactions_trade_corporate().intValue());
			}
			Cell R54cell32 = R54row.getCell(34);
			if (R54cell32 != null) {
				R54cell32.setCellValue(brf94c.getR54_amount_trade_corporate() == null ? 0
						: brf94c.getR54_amount_trade_corporate().intValue());
			}
			Cell R54cell33 = R54row.getCell(35);
			if (R54cell33 != null) {
				R54cell33.setCellValue(brf94c.getR54_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR54_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R54cell34 = R54row.getCell(36);
			if (R54cell34 != null) {
				R54cell34.setCellValue(brf94c.getR54_amount_financial_investment_sme() == null ? 0
						: brf94c.getR54_amount_financial_investment_sme().intValue());
			}
			Cell R54cell35 = R54row.getCell(37);
			if (R54cell35 != null) {
				R54cell35.setCellValue(brf94c.getR54_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR54_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R54cell36 = R54row.getCell(38);
			if (R54cell36 != null) {
				R54cell36.setCellValue(brf94c.getR54_amount_direct_investment_sme() == null ? 0
						: brf94c.getR54_amount_direct_investment_sme().intValue());
			}
			Cell R54cell37 = R54row.getCell(39);
			if (R54cell37 != null) {
				R54cell37.setCellValue(brf94c.getR54_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR54_no_of_transactions_services_sme().intValue());
			}
			Cell R54cell38 = R54row.getCell(40);
			if (R54cell38 != null) {
				R54cell38.setCellValue(brf94c.getR54_amount_services_sme() == null ? 0
						: brf94c.getR54_amount_services_sme().intValue());
			}
			Cell R54cell39 = R54row.getCell(41);
			if (R54cell39 != null) {
				R54cell39.setCellValue(brf94c.getR54_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR54_no_of_transactions_trade_sme().intValue());
			}
			Cell R54cell40 = R54row.getCell(42);
			if (R54cell40 != null) {
				R54cell40.setCellValue(
						brf94c.getR54_amount_trade_sme() == null ? 0 : brf94c.getR54_amount_trade_sme().intValue());
			}
			Cell R54cell41 = R54row.getCell(43);
			if (R54cell41 != null) {
				R54cell41.setCellValue(brf94c.getR54_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R54cell42 = R54row.getCell(44);
			if (R54cell42 != null) {
				R54cell42.setCellValue(brf94c.getR54_amount_financial_investment_individual() == null ? 0
						: brf94c.getR54_amount_financial_investment_individual().intValue());
			}
			Cell R54cell43 = R54row.getCell(45);
			if (R54cell43 != null) {
				R54cell43.setCellValue(brf94c.getR54_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R54cell44 = R54row.getCell(46);
			if (R54cell44 != null) {
				R54cell44.setCellValue(brf94c.getR54_amount_direct_investment_individual() == null ? 0
						: brf94c.getR54_amount_direct_investment_individual().intValue());
			}
			Cell R54cell45 = R54row.getCell(47);
			if (R54cell45 != null) {
				R54cell45.setCellValue(brf94c.getR54_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_family_support_individual().intValue());
			}
			Cell R54cell46 = R54row.getCell(48);
			if (R54cell46 != null) {
				R54cell46.setCellValue(brf94c.getR54_amount_family_support_individual() == null ? 0
						: brf94c.getR54_amount_family_support_individual().intValue());
			}
			Cell R54cell47 = R54row.getCell(49);
			if (R54cell47 != null) {
				R54cell47.setCellValue(brf94c.getR54_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_education_individual().intValue());
			}
			Cell R54cell48 = R54row.getCell(50);
			if (R54cell48 != null) {
				R54cell48.setCellValue(brf94c.getR54_amount_education_individual() == null ? 0
						: brf94c.getR54_amount_education_individual().intValue());
			}
			Cell R54cell49 = R54row.getCell(51);
			if (R54cell49 != null) {
				R54cell49.setCellValue(brf94c.getR54_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_medical_individual().intValue());
			}

			Cell R54cell50 = R54row.getCell(52);
			if (R54cell50 != null) {
				R54cell50.setCellValue(brf94c.getR54_amount_medical_individual() == null ? 0
						: brf94c.getR54_amount_medical_individual().intValue());
			}
			Cell R54cell51 = R54row.getCell(53);
			if (R54cell51 != null) {
				R54cell51.setCellValue(brf94c.getR54_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_tourism_individual().intValue());
			}
			Cell R54cell52 = R54row.getCell(54);
			if (R54cell52 != null) {
				R54cell52.setCellValue(brf94c.getR54_amount_tourism_individual() == null ? 0
						: brf94c.getR54_amount_tourism_individual().intValue());
			}
			Cell R54cell53 = R54row.getCell(55);
			if (R54cell53 != null) {
				R54cell53.setCellValue(brf94c.getR54_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R54cell54 = R54row.getCell(56);
			if (R54cell54 != null) {
				R54cell54.setCellValue(brf94c.getR54_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR54_amount_debt_settlement_individual().intValue());
			}
			Cell R54cell55 = R54row.getCell(57);
			if (R54cell55 != null) {
				R54cell55.setCellValue(brf94c.getR54_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR54_no_of_transactions_other_services_individual().intValue());
			}

			Cell R54cell56 = R54row.getCell(58);
			if (R54cell56 != null) {
				R54cell56.setCellValue(brf94c.getR54_amount_other_services_individual() == null ? 0
						: brf94c.getR54_amount_other_services_individual().intValue());
			}

			Row R55row = sheet.getRow(63);
			Cell R55cell1 = R55row.getCell(3);
			if (R55cell1 != null) {
				R55cell1.setCellValue(brf94c.getR55_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR55_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R55cell2 = R55row.getCell(4);
			if (R55cell2 != null) {
				R55cell2.setCellValue(brf94c.getR55_amount_financial_investment_government() == null ? 0
						: brf94c.getR55_amount_financial_investment_government().intValue());
			}
			Cell R55cell3 = R55row.getCell(5);
			if (R55cell3 != null) {
				R55cell3.setCellValue(brf94c.getR55_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR55_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R55cell4 = R55row.getCell(6);
			if (R55cell4 != null) {
				R55cell4.setCellValue(brf94c.getR55_amount_direct_investment_government() == null ? 0
						: brf94c.getR55_amount_direct_investment_government().intValue());
			}
			Cell R55cell5 = R55row.getCell(7);
			if (R55cell5 != null) {
				R55cell5.setCellValue(brf94c.getR55_no_of_transactions_services_government() == null ? 0
						: brf94c.getR55_no_of_transactions_services_government().intValue());
			}
			Cell R55cell6 = R55row.getCell(8);
			if (R55cell6 != null) {
				R55cell6.setCellValue(brf94c.getR55_amount_services_government() == null ? 0
						: brf94c.getR55_amount_services_government().intValue());
			}
			Cell R55cell7 = R55row.getCell(9);
			if (R55cell7 != null) {
				R55cell7.setCellValue(brf94c.getR55_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR55_no_of_transactions_trade_government().intValue());
			}
			Cell R55cell8 = R55row.getCell(10);
			if (R55cell8 != null) {
				R55cell8.setCellValue(brf94c.getR55_amount_trade_government() == null ? 0
						: brf94c.getR55_amount_trade_government().intValue());
			}
			Cell R55cell9 = R55row.getCell(11);
			if (R55cell9 != null) {
				R55cell9.setCellValue(brf94c.getR55_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR55_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R55cell10 = R55row.getCell(12);
			if (R55cell10 != null) {
				R55cell10.setCellValue(brf94c.getR55_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR55_amount_financial_investment_reserve().intValue());
			}
			Cell R55cell11 = R55row.getCell(13);
			if (R55cell11 != null) {
				R55cell11.setCellValue(brf94c.getR55_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR55_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R55cell12 = R55row.getCell(14);
			if (R55cell12 != null) {
				R55cell12.setCellValue(brf94c.getR55_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR55_amount_direct_investment_reserve().intValue());
			}
			Cell R55cell13 = R55row.getCell(15);
			if (R55cell13 != null) {
				R55cell13.setCellValue(brf94c.getR55_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR55_no_of_transactions_services_reserve().intValue());
			}
			Cell R55cell14 = R55row.getCell(16);
			if (R55cell14 != null) {
				R55cell14.setCellValue(brf94c.getR55_amount_services_reserve() == null ? 0
						: brf94c.getR55_amount_services_reserve().intValue());
			}
			Cell R55cell15 = R55row.getCell(17);
			if (R55cell15 != null) {
				R55cell15.setCellValue(brf94c.getR55_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR55_no_of_transactions_trade_reserve().intValue());
			}
			Cell R55cell16 = R55row.getCell(18);
			if (R55cell16 != null) {
				R55cell16.setCellValue(brf94c.getR55_amount_trade_reserve() == null ? 0
						: brf94c.getR55_amount_trade_reserve().intValue());
			}
			Cell R55cell17 = R55row.getCell(19);
			if (R55cell17 != null) {
				R55cell17.setCellValue(brf94c.getR55_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR55_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R55cell18 = R55row.getCell(20);
			if (R55cell18 != null) {
				R55cell18.setCellValue(brf94c.getR55_amount_financial_investment_gre() == null ? 0
						: brf94c.getR55_amount_financial_investment_gre().intValue());
			}
			Cell R55cell19 = R55row.getCell(21);
			if (R55cell19 != null) {
				R55cell19.setCellValue(brf94c.getR55_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR55_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R55cell20 = R55row.getCell(22);
			if (R55cell20 != null) {
				R55cell20.setCellValue(brf94c.getR55_amount_direct_investment_gre() == null ? 0
						: brf94c.getR55_amount_direct_investment_gre().intValue());
			}
			Cell R55cell21 = R55row.getCell(23);
			if (R55cell21 != null) {
				R55cell21.setCellValue(brf94c.getR55_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR55_no_of_transactions_services_gre().intValue());
			}
			Cell R55cell22 = R55row.getCell(24);
			if (R55cell22 != null) {
				R55cell22.setCellValue(brf94c.getR55_amount_services_gre() == null ? 0
						: brf94c.getR55_amount_services_gre().intValue());
			}
			Cell R55cell23 = R55row.getCell(25);
			if (R55cell23 != null) {
				R55cell23.setCellValue(brf94c.getR55_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR55_no_of_transactions_trade_gre().intValue());
			}
			Cell R55cell24 = R55row.getCell(26);
			if (R55cell24 != null) {
				R55cell24.setCellValue(
						brf94c.getR55_amount_trade_gre() == null ? 0 : brf94c.getR55_amount_trade_gre().intValue());
			}
			Cell R55cell25 = R55row.getCell(27);
			if (R55cell25 != null) {
				R55cell25.setCellValue(brf94c.getR55_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR55_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R55cell26 = R55row.getCell(28);
			if (R55cell26 != null) {
				R55cell26.setCellValue(brf94c.getR55_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR55_amount_financial_investment_corporate().intValue());
			}
			Cell R55cell27 = R55row.getCell(29);
			if (R55cell27 != null) {
				R55cell27.setCellValue(brf94c.getR55_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR55_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R55cell28 = R55row.getCell(30);
			if (R55cell28 != null) {
				R55cell28.setCellValue(brf94c.getR55_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR55_amount_direct_investment_corporate().intValue());
			}
			Cell R55cell29 = R55row.getCell(31);
			if (R55cell29 != null) {
				R55cell29.setCellValue(brf94c.getR55_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR55_no_of_transactions_services_corporate().intValue());
			}
			Cell R55cell30 = R55row.getCell(32);
			if (R55cell30 != null) {
				R55cell30.setCellValue(brf94c.getR55_amount_services_corporate() == null ? 0
						: brf94c.getR55_amount_services_corporate().intValue());
			}
			Cell R55cell31 = R55row.getCell(33);
			if (R55cell31 != null) {
				R55cell31.setCellValue(brf94c.getR55_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR55_no_of_transactions_trade_corporate().intValue());
			}
			Cell R55cell32 = R55row.getCell(34);
			if (R55cell32 != null) {
				R55cell32.setCellValue(brf94c.getR55_amount_trade_corporate() == null ? 0
						: brf94c.getR55_amount_trade_corporate().intValue());
			}
			Cell R55cell33 = R55row.getCell(35);
			if (R55cell33 != null) {
				R55cell33.setCellValue(brf94c.getR55_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR55_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R55cell34 = R55row.getCell(36);
			if (R55cell34 != null) {
				R55cell34.setCellValue(brf94c.getR55_amount_financial_investment_sme() == null ? 0
						: brf94c.getR55_amount_financial_investment_sme().intValue());
			}
			Cell R55cell35 = R55row.getCell(37);
			if (R55cell35 != null) {
				R55cell35.setCellValue(brf94c.getR55_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR55_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R55cell36 = R55row.getCell(38);
			if (R55cell36 != null) {
				R55cell36.setCellValue(brf94c.getR55_amount_direct_investment_sme() == null ? 0
						: brf94c.getR55_amount_direct_investment_sme().intValue());
			}
			Cell R55cell37 = R55row.getCell(39);
			if (R55cell37 != null) {
				R55cell37.setCellValue(brf94c.getR55_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR55_no_of_transactions_services_sme().intValue());
			}
			Cell R55cell38 = R55row.getCell(40);
			if (R55cell38 != null) {
				R55cell38.setCellValue(brf94c.getR55_amount_services_sme() == null ? 0
						: brf94c.getR55_amount_services_sme().intValue());
			}
			Cell R55cell39 = R55row.getCell(41);
			if (R55cell39 != null) {
				R55cell39.setCellValue(brf94c.getR55_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR55_no_of_transactions_trade_sme().intValue());
			}
			Cell R55cell40 = R55row.getCell(42);
			if (R55cell40 != null) {
				R55cell40.setCellValue(
						brf94c.getR55_amount_trade_sme() == null ? 0 : brf94c.getR55_amount_trade_sme().intValue());
			}
			Cell R55cell41 = R55row.getCell(43);
			if (R55cell41 != null) {
				R55cell41.setCellValue(brf94c.getR55_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R55cell42 = R55row.getCell(44);
			if (R55cell42 != null) {
				R55cell42.setCellValue(brf94c.getR55_amount_financial_investment_individual() == null ? 0
						: brf94c.getR55_amount_financial_investment_individual().intValue());
			}
			Cell R55cell43 = R55row.getCell(45);
			if (R55cell43 != null) {
				R55cell43.setCellValue(brf94c.getR55_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R55cell44 = R55row.getCell(46);
			if (R55cell44 != null) {
				R55cell44.setCellValue(brf94c.getR55_amount_direct_investment_individual() == null ? 0
						: brf94c.getR55_amount_direct_investment_individual().intValue());
			}
			Cell R55cell45 = R55row.getCell(47);
			if (R55cell45 != null) {
				R55cell45.setCellValue(brf94c.getR55_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_family_support_individual().intValue());
			}
			Cell R55cell46 = R55row.getCell(48);
			if (R55cell46 != null) {
				R55cell46.setCellValue(brf94c.getR55_amount_family_support_individual() == null ? 0
						: brf94c.getR55_amount_family_support_individual().intValue());
			}
			Cell R55cell47 = R55row.getCell(49);
			if (R55cell47 != null) {
				R55cell47.setCellValue(brf94c.getR55_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_education_individual().intValue());
			}
			Cell R55cell48 = R55row.getCell(50);
			if (R55cell48 != null) {
				R55cell48.setCellValue(brf94c.getR55_amount_education_individual() == null ? 0
						: brf94c.getR55_amount_education_individual().intValue());
			}
			Cell R55cell49 = R55row.getCell(51);
			if (R55cell49 != null) {
				R55cell49.setCellValue(brf94c.getR55_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_medical_individual().intValue());
			}

			Cell R55cell50 = R55row.getCell(52);
			if (R55cell50 != null) {
				R55cell50.setCellValue(brf94c.getR55_amount_medical_individual() == null ? 0
						: brf94c.getR55_amount_medical_individual().intValue());
			}
			Cell R55cell51 = R55row.getCell(53);
			if (R55cell51 != null) {
				R55cell51.setCellValue(brf94c.getR55_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_tourism_individual().intValue());
			}
			Cell R55cell52 = R55row.getCell(54);
			if (R55cell52 != null) {
				R55cell52.setCellValue(brf94c.getR55_amount_tourism_individual() == null ? 0
						: brf94c.getR55_amount_tourism_individual().intValue());
			}
			Cell R55cell53 = R55row.getCell(55);
			if (R55cell53 != null) {
				R55cell53.setCellValue(brf94c.getR55_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R55cell54 = R55row.getCell(56);
			if (R55cell54 != null) {
				R55cell54.setCellValue(brf94c.getR55_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR55_amount_debt_settlement_individual().intValue());
			}
			Cell R55cell55 = R55row.getCell(57);
			if (R55cell55 != null) {
				R55cell55.setCellValue(brf94c.getR55_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR55_no_of_transactions_other_services_individual().intValue());
			}

			Cell R55cell56 = R55row.getCell(58);
			if (R55cell56 != null) {
				R55cell56.setCellValue(brf94c.getR55_amount_other_services_individual() == null ? 0
						: brf94c.getR55_amount_other_services_individual().intValue());
			}

			Row R56row = sheet.getRow(64);
			Cell R56cell1 = R56row.getCell(3);
			if (R56cell1 != null) {
				R56cell1.setCellValue(brf94c.getR56_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR56_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R56cell2 = R56row.getCell(4);
			if (R56cell2 != null) {
				R56cell2.setCellValue(brf94c.getR56_amount_financial_investment_government() == null ? 0
						: brf94c.getR56_amount_financial_investment_government().intValue());
			}
			Cell R56cell3 = R56row.getCell(5);
			if (R56cell3 != null) {
				R56cell3.setCellValue(brf94c.getR56_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR56_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R56cell4 = R56row.getCell(6);
			if (R56cell4 != null) {
				R56cell4.setCellValue(brf94c.getR56_amount_direct_investment_government() == null ? 0
						: brf94c.getR56_amount_direct_investment_government().intValue());
			}
			Cell R56cell5 = R56row.getCell(7);
			if (R56cell5 != null) {
				R56cell5.setCellValue(brf94c.getR56_no_of_transactions_services_government() == null ? 0
						: brf94c.getR56_no_of_transactions_services_government().intValue());
			}
			Cell R56cell6 = R56row.getCell(8);
			if (R56cell6 != null) {
				R56cell6.setCellValue(brf94c.getR56_amount_services_government() == null ? 0
						: brf94c.getR56_amount_services_government().intValue());
			}
			Cell R56cell7 = R56row.getCell(9);
			if (R56cell7 != null) {
				R56cell7.setCellValue(brf94c.getR56_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR56_no_of_transactions_trade_government().intValue());
			}
			Cell R56cell8 = R56row.getCell(10);
			if (R56cell8 != null) {
				R56cell8.setCellValue(brf94c.getR56_amount_trade_government() == null ? 0
						: brf94c.getR56_amount_trade_government().intValue());
			}
			Cell R56cell9 = R56row.getCell(11);
			if (R56cell9 != null) {
				R56cell9.setCellValue(brf94c.getR56_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR56_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R56cell10 = R56row.getCell(12);
			if (R56cell10 != null) {
				R56cell10.setCellValue(brf94c.getR56_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR56_amount_financial_investment_reserve().intValue());
			}
			Cell R56cell11 = R56row.getCell(13);
			if (R56cell11 != null) {
				R56cell11.setCellValue(brf94c.getR56_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR56_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R56cell12 = R56row.getCell(14);
			if (R56cell12 != null) {
				R56cell12.setCellValue(brf94c.getR56_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR56_amount_direct_investment_reserve().intValue());
			}
			Cell R56cell13 = R56row.getCell(15);
			if (R56cell13 != null) {
				R56cell13.setCellValue(brf94c.getR56_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR56_no_of_transactions_services_reserve().intValue());
			}
			Cell R56cell14 = R56row.getCell(16);
			if (R56cell14 != null) {
				R56cell14.setCellValue(brf94c.getR56_amount_services_reserve() == null ? 0
						: brf94c.getR56_amount_services_reserve().intValue());
			}
			Cell R56cell15 = R56row.getCell(17);
			if (R56cell15 != null) {
				R56cell15.setCellValue(brf94c.getR56_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR56_no_of_transactions_trade_reserve().intValue());
			}
			Cell R56cell16 = R56row.getCell(18);
			if (R56cell16 != null) {
				R56cell16.setCellValue(brf94c.getR56_amount_trade_reserve() == null ? 0
						: brf94c.getR56_amount_trade_reserve().intValue());
			}
			Cell R56cell17 = R56row.getCell(19);
			if (R56cell17 != null) {
				R56cell17.setCellValue(brf94c.getR56_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR56_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R56cell18 = R56row.getCell(20);
			if (R56cell18 != null) {
				R56cell18.setCellValue(brf94c.getR56_amount_financial_investment_gre() == null ? 0
						: brf94c.getR56_amount_financial_investment_gre().intValue());
			}
			Cell R56cell19 = R56row.getCell(21);
			if (R56cell19 != null) {
				R56cell19.setCellValue(brf94c.getR56_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR56_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R56cell20 = R56row.getCell(22);
			if (R56cell20 != null) {
				R56cell20.setCellValue(brf94c.getR56_amount_direct_investment_gre() == null ? 0
						: brf94c.getR56_amount_direct_investment_gre().intValue());
			}
			Cell R56cell21 = R56row.getCell(23);
			if (R56cell21 != null) {
				R56cell21.setCellValue(brf94c.getR56_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR56_no_of_transactions_services_gre().intValue());
			}
			Cell R56cell22 = R56row.getCell(24);
			if (R56cell22 != null) {
				R56cell22.setCellValue(brf94c.getR56_amount_services_gre() == null ? 0
						: brf94c.getR56_amount_services_gre().intValue());
			}
			Cell R56cell23 = R56row.getCell(25);
			if (R56cell23 != null) {
				R56cell23.setCellValue(brf94c.getR56_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR56_no_of_transactions_trade_gre().intValue());
			}
			Cell R56cell24 = R56row.getCell(26);
			if (R56cell24 != null) {
				R56cell24.setCellValue(
						brf94c.getR56_amount_trade_gre() == null ? 0 : brf94c.getR56_amount_trade_gre().intValue());
			}
			Cell R56cell25 = R56row.getCell(27);
			if (R56cell25 != null) {
				R56cell25.setCellValue(brf94c.getR56_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR56_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R56cell26 = R56row.getCell(28);
			if (R56cell26 != null) {
				R56cell26.setCellValue(brf94c.getR56_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR56_amount_financial_investment_corporate().intValue());
			}
			Cell R56cell27 = R56row.getCell(29);
			if (R56cell27 != null) {
				R56cell27.setCellValue(brf94c.getR56_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR56_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R56cell28 = R56row.getCell(30);
			if (R56cell28 != null) {
				R56cell28.setCellValue(brf94c.getR56_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR56_amount_direct_investment_corporate().intValue());
			}
			Cell R56cell29 = R56row.getCell(31);
			if (R56cell29 != null) {
				R56cell29.setCellValue(brf94c.getR56_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR56_no_of_transactions_services_corporate().intValue());
			}
			Cell R56cell30 = R56row.getCell(32);
			if (R56cell30 != null) {
				R56cell30.setCellValue(brf94c.getR56_amount_services_corporate() == null ? 0
						: brf94c.getR56_amount_services_corporate().intValue());
			}
			Cell R56cell31 = R56row.getCell(33);
			if (R56cell31 != null) {
				R56cell31.setCellValue(brf94c.getR56_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR56_no_of_transactions_trade_corporate().intValue());
			}
			Cell R56cell32 = R56row.getCell(34);
			if (R56cell32 != null) {
				R56cell32.setCellValue(brf94c.getR56_amount_trade_corporate() == null ? 0
						: brf94c.getR56_amount_trade_corporate().intValue());
			}
			Cell R56cell33 = R56row.getCell(35);
			if (R56cell33 != null) {
				R56cell33.setCellValue(brf94c.getR56_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR56_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R56cell34 = R56row.getCell(36);
			if (R56cell34 != null) {
				R56cell34.setCellValue(brf94c.getR56_amount_financial_investment_sme() == null ? 0
						: brf94c.getR56_amount_financial_investment_sme().intValue());
			}
			Cell R56cell35 = R56row.getCell(37);
			if (R56cell35 != null) {
				R56cell35.setCellValue(brf94c.getR56_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR56_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R56cell36 = R56row.getCell(38);
			if (R56cell36 != null) {
				R56cell36.setCellValue(brf94c.getR56_amount_direct_investment_sme() == null ? 0
						: brf94c.getR56_amount_direct_investment_sme().intValue());
			}
			Cell R56cell37 = R56row.getCell(39);
			if (R56cell37 != null) {
				R56cell37.setCellValue(brf94c.getR56_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR56_no_of_transactions_services_sme().intValue());
			}
			Cell R56cell38 = R56row.getCell(40);
			if (R56cell38 != null) {
				R56cell38.setCellValue(brf94c.getR56_amount_services_sme() == null ? 0
						: brf94c.getR56_amount_services_sme().intValue());
			}
			Cell R56cell39 = R56row.getCell(41);
			if (R56cell39 != null) {
				R56cell39.setCellValue(brf94c.getR56_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR56_no_of_transactions_trade_sme().intValue());
			}
			Cell R56cell40 = R56row.getCell(42);
			if (R56cell40 != null) {
				R56cell40.setCellValue(
						brf94c.getR56_amount_trade_sme() == null ? 0 : brf94c.getR56_amount_trade_sme().intValue());
			}
			Cell R56cell41 = R56row.getCell(43);
			if (R56cell41 != null) {
				R56cell41.setCellValue(brf94c.getR56_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R56cell42 = R56row.getCell(44);
			if (R56cell42 != null) {
				R56cell42.setCellValue(brf94c.getR56_amount_financial_investment_individual() == null ? 0
						: brf94c.getR56_amount_financial_investment_individual().intValue());
			}
			Cell R56cell43 = R56row.getCell(45);
			if (R56cell43 != null) {
				R56cell43.setCellValue(brf94c.getR56_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R56cell44 = R56row.getCell(46);
			if (R56cell44 != null) {
				R56cell44.setCellValue(brf94c.getR56_amount_direct_investment_individual() == null ? 0
						: brf94c.getR56_amount_direct_investment_individual().intValue());
			}
			Cell R56cell45 = R56row.getCell(47);
			if (R56cell45 != null) {
				R56cell45.setCellValue(brf94c.getR56_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_family_support_individual().intValue());
			}
			Cell R56cell46 = R56row.getCell(48);
			if (R56cell46 != null) {
				R56cell46.setCellValue(brf94c.getR56_amount_family_support_individual() == null ? 0
						: brf94c.getR56_amount_family_support_individual().intValue());
			}
			Cell R56cell47 = R56row.getCell(49);
			if (R56cell47 != null) {
				R56cell47.setCellValue(brf94c.getR56_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_education_individual().intValue());
			}
			Cell R56cell48 = R56row.getCell(50);
			if (R56cell48 != null) {
				R56cell48.setCellValue(brf94c.getR56_amount_education_individual() == null ? 0
						: brf94c.getR56_amount_education_individual().intValue());
			}
			Cell R56cell49 = R56row.getCell(51);
			if (R56cell49 != null) {
				R56cell49.setCellValue(brf94c.getR56_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_medical_individual().intValue());
			}

			Cell R56cell50 = R56row.getCell(52);
			if (R56cell50 != null) {
				R56cell50.setCellValue(brf94c.getR56_amount_medical_individual() == null ? 0
						: brf94c.getR56_amount_medical_individual().intValue());
			}
			Cell R56cell51 = R56row.getCell(53);
			if (R56cell51 != null) {
				R56cell51.setCellValue(brf94c.getR56_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_tourism_individual().intValue());
			}
			Cell R56cell52 = R56row.getCell(54);
			if (R56cell52 != null) {
				R56cell52.setCellValue(brf94c.getR56_amount_tourism_individual() == null ? 0
						: brf94c.getR56_amount_tourism_individual().intValue());
			}
			Cell R56cell53 = R56row.getCell(55);
			if (R56cell53 != null) {
				R56cell53.setCellValue(brf94c.getR56_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R56cell54 = R56row.getCell(56);
			if (R56cell54 != null) {
				R56cell54.setCellValue(brf94c.getR56_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR56_amount_debt_settlement_individual().intValue());
			}
			Cell R56cell55 = R56row.getCell(57);
			if (R56cell55 != null) {
				R56cell55.setCellValue(brf94c.getR56_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR56_no_of_transactions_other_services_individual().intValue());
			}

			Cell R56cell56 = R56row.getCell(58);
			if (R56cell56 != null) {
				R56cell56.setCellValue(brf94c.getR56_amount_other_services_individual() == null ? 0
						: brf94c.getR56_amount_other_services_individual().intValue());
			}

			Row R57row = sheet.getRow(65);
			Cell R57cell1 = R57row.getCell(3);
			if (R57cell1 != null) {
				R57cell1.setCellValue(brf94c.getR57_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR57_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R57cell2 = R57row.getCell(4);
			if (R57cell2 != null) {
				R57cell2.setCellValue(brf94c.getR57_amount_financial_investment_government() == null ? 0
						: brf94c.getR57_amount_financial_investment_government().intValue());
			}
			Cell R57cell3 = R57row.getCell(5);
			if (R57cell3 != null) {
				R57cell3.setCellValue(brf94c.getR57_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR57_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R57cell4 = R57row.getCell(6);
			if (R57cell4 != null) {
				R57cell4.setCellValue(brf94c.getR57_amount_direct_investment_government() == null ? 0
						: brf94c.getR57_amount_direct_investment_government().intValue());
			}
			Cell R57cell5 = R57row.getCell(7);
			if (R57cell5 != null) {
				R57cell5.setCellValue(brf94c.getR57_no_of_transactions_services_government() == null ? 0
						: brf94c.getR57_no_of_transactions_services_government().intValue());
			}
			Cell R57cell6 = R57row.getCell(8);
			if (R57cell6 != null) {
				R57cell6.setCellValue(brf94c.getR57_amount_services_government() == null ? 0
						: brf94c.getR57_amount_services_government().intValue());
			}
			Cell R57cell7 = R57row.getCell(9);
			if (R57cell7 != null) {
				R57cell7.setCellValue(brf94c.getR57_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR57_no_of_transactions_trade_government().intValue());
			}
			Cell R57cell8 = R57row.getCell(10);
			if (R57cell8 != null) {
				R57cell8.setCellValue(brf94c.getR57_amount_trade_government() == null ? 0
						: brf94c.getR57_amount_trade_government().intValue());
			}
			Cell R57cell9 = R57row.getCell(11);
			if (R57cell9 != null) {
				R57cell9.setCellValue(brf94c.getR57_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR57_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R57cell10 = R57row.getCell(12);
			if (R57cell10 != null) {
				R57cell10.setCellValue(brf94c.getR57_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR57_amount_financial_investment_reserve().intValue());
			}
			Cell R57cell11 = R57row.getCell(13);
			if (R57cell11 != null) {
				R57cell11.setCellValue(brf94c.getR57_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR57_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R57cell12 = R57row.getCell(14);
			if (R57cell12 != null) {
				R57cell12.setCellValue(brf94c.getR57_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR57_amount_direct_investment_reserve().intValue());
			}
			Cell R57cell13 = R57row.getCell(15);
			if (R57cell13 != null) {
				R57cell13.setCellValue(brf94c.getR57_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR57_no_of_transactions_services_reserve().intValue());
			}
			Cell R57cell14 = R57row.getCell(16);
			if (R57cell14 != null) {
				R57cell14.setCellValue(brf94c.getR57_amount_services_reserve() == null ? 0
						: brf94c.getR57_amount_services_reserve().intValue());
			}
			Cell R57cell15 = R57row.getCell(17);
			if (R57cell15 != null) {
				R57cell15.setCellValue(brf94c.getR57_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR57_no_of_transactions_trade_reserve().intValue());
			}
			Cell R57cell16 = R57row.getCell(18);
			if (R57cell16 != null) {
				R57cell16.setCellValue(brf94c.getR57_amount_trade_reserve() == null ? 0
						: brf94c.getR57_amount_trade_reserve().intValue());
			}
			Cell R57cell17 = R57row.getCell(19);
			if (R57cell17 != null) {
				R57cell17.setCellValue(brf94c.getR57_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR57_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R57cell18 = R57row.getCell(20);
			if (R57cell18 != null) {
				R57cell18.setCellValue(brf94c.getR57_amount_financial_investment_gre() == null ? 0
						: brf94c.getR57_amount_financial_investment_gre().intValue());
			}
			Cell R57cell19 = R57row.getCell(21);
			if (R57cell19 != null) {
				R57cell19.setCellValue(brf94c.getR57_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR57_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R57cell20 = R57row.getCell(22);
			if (R57cell20 != null) {
				R57cell20.setCellValue(brf94c.getR57_amount_direct_investment_gre() == null ? 0
						: brf94c.getR57_amount_direct_investment_gre().intValue());
			}
			Cell R57cell21 = R57row.getCell(23);
			if (R57cell21 != null) {
				R57cell21.setCellValue(brf94c.getR57_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR57_no_of_transactions_services_gre().intValue());
			}
			Cell R57cell22 = R57row.getCell(24);
			if (R57cell22 != null) {
				R57cell22.setCellValue(brf94c.getR57_amount_services_gre() == null ? 0
						: brf94c.getR57_amount_services_gre().intValue());
			}
			Cell R57cell23 = R57row.getCell(25);
			if (R57cell23 != null) {
				R57cell23.setCellValue(brf94c.getR57_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR57_no_of_transactions_trade_gre().intValue());
			}
			Cell R57cell24 = R57row.getCell(26);
			if (R57cell24 != null) {
				R57cell24.setCellValue(
						brf94c.getR57_amount_trade_gre() == null ? 0 : brf94c.getR57_amount_trade_gre().intValue());
			}
			Cell R57cell25 = R57row.getCell(27);
			if (R57cell25 != null) {
				R57cell25.setCellValue(brf94c.getR57_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR57_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R57cell26 = R57row.getCell(28);
			if (R57cell26 != null) {
				R57cell26.setCellValue(brf94c.getR57_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR57_amount_financial_investment_corporate().intValue());
			}
			Cell R57cell27 = R57row.getCell(29);
			if (R57cell27 != null) {
				R57cell27.setCellValue(brf94c.getR57_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR57_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R57cell28 = R57row.getCell(30);
			if (R57cell28 != null) {
				R57cell28.setCellValue(brf94c.getR57_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR57_amount_direct_investment_corporate().intValue());
			}
			Cell R57cell29 = R57row.getCell(31);
			if (R57cell29 != null) {
				R57cell29.setCellValue(brf94c.getR57_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR57_no_of_transactions_services_corporate().intValue());
			}
			Cell R57cell30 = R57row.getCell(32);
			if (R57cell30 != null) {
				R57cell30.setCellValue(brf94c.getR57_amount_services_corporate() == null ? 0
						: brf94c.getR57_amount_services_corporate().intValue());
			}
			Cell R57cell31 = R57row.getCell(33);
			if (R57cell31 != null) {
				R57cell31.setCellValue(brf94c.getR57_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR57_no_of_transactions_trade_corporate().intValue());
			}
			Cell R57cell32 = R57row.getCell(34);
			if (R57cell32 != null) {
				R57cell32.setCellValue(brf94c.getR57_amount_trade_corporate() == null ? 0
						: brf94c.getR57_amount_trade_corporate().intValue());
			}
			Cell R57cell33 = R57row.getCell(35);
			if (R57cell33 != null) {
				R57cell33.setCellValue(brf94c.getR57_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR57_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R57cell34 = R57row.getCell(36);
			if (R57cell34 != null) {
				R57cell34.setCellValue(brf94c.getR57_amount_financial_investment_sme() == null ? 0
						: brf94c.getR57_amount_financial_investment_sme().intValue());
			}
			Cell R57cell35 = R57row.getCell(37);
			if (R57cell35 != null) {
				R57cell35.setCellValue(brf94c.getR57_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR57_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R57cell36 = R57row.getCell(38);
			if (R57cell36 != null) {
				R57cell36.setCellValue(brf94c.getR57_amount_direct_investment_sme() == null ? 0
						: brf94c.getR57_amount_direct_investment_sme().intValue());
			}
			Cell R57cell37 = R57row.getCell(39);
			if (R57cell37 != null) {
				R57cell37.setCellValue(brf94c.getR57_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR57_no_of_transactions_services_sme().intValue());
			}
			Cell R57cell38 = R57row.getCell(40);
			if (R57cell38 != null) {
				R57cell38.setCellValue(brf94c.getR57_amount_services_sme() == null ? 0
						: brf94c.getR57_amount_services_sme().intValue());
			}
			Cell R57cell39 = R57row.getCell(41);
			if (R57cell39 != null) {
				R57cell39.setCellValue(brf94c.getR57_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR57_no_of_transactions_trade_sme().intValue());
			}
			Cell R57cell40 = R57row.getCell(42);
			if (R57cell40 != null) {
				R57cell40.setCellValue(
						brf94c.getR57_amount_trade_sme() == null ? 0 : brf94c.getR57_amount_trade_sme().intValue());
			}
			Cell R57cell41 = R57row.getCell(43);
			if (R57cell41 != null) {
				R57cell41.setCellValue(brf94c.getR57_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R57cell42 = R57row.getCell(44);
			if (R57cell42 != null) {
				R57cell42.setCellValue(brf94c.getR57_amount_financial_investment_individual() == null ? 0
						: brf94c.getR57_amount_financial_investment_individual().intValue());
			}
			Cell R57cell43 = R57row.getCell(45);
			if (R57cell43 != null) {
				R57cell43.setCellValue(brf94c.getR57_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R57cell44 = R57row.getCell(46);
			if (R57cell44 != null) {
				R57cell44.setCellValue(brf94c.getR57_amount_direct_investment_individual() == null ? 0
						: brf94c.getR57_amount_direct_investment_individual().intValue());
			}
			Cell R57cell45 = R57row.getCell(47);
			if (R57cell45 != null) {
				R57cell45.setCellValue(brf94c.getR57_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_family_support_individual().intValue());
			}
			Cell R57cell46 = R57row.getCell(48);
			if (R57cell46 != null) {
				R57cell46.setCellValue(brf94c.getR57_amount_family_support_individual() == null ? 0
						: brf94c.getR57_amount_family_support_individual().intValue());
			}
			Cell R57cell47 = R57row.getCell(49);
			if (R57cell47 != null) {
				R57cell47.setCellValue(brf94c.getR57_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_education_individual().intValue());
			}
			Cell R57cell48 = R57row.getCell(50);
			if (R57cell48 != null) {
				R57cell48.setCellValue(brf94c.getR57_amount_education_individual() == null ? 0
						: brf94c.getR57_amount_education_individual().intValue());
			}
			Cell R57cell49 = R57row.getCell(51);
			if (R57cell49 != null) {
				R57cell49.setCellValue(brf94c.getR57_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_medical_individual().intValue());
			}

			Cell R57cell50 = R57row.getCell(52);
			if (R57cell50 != null) {
				R57cell50.setCellValue(brf94c.getR57_amount_medical_individual() == null ? 0
						: brf94c.getR57_amount_medical_individual().intValue());
			}
			Cell R57cell51 = R57row.getCell(53);
			if (R57cell51 != null) {
				R57cell51.setCellValue(brf94c.getR57_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_tourism_individual().intValue());
			}
			Cell R57cell52 = R57row.getCell(54);
			if (R57cell52 != null) {
				R57cell52.setCellValue(brf94c.getR57_amount_tourism_individual() == null ? 0
						: brf94c.getR57_amount_tourism_individual().intValue());
			}
			Cell R57cell53 = R57row.getCell(55);
			if (R57cell53 != null) {
				R57cell53.setCellValue(brf94c.getR57_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R57cell54 = R57row.getCell(56);
			if (R57cell54 != null) {
				R57cell54.setCellValue(brf94c.getR57_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR57_amount_debt_settlement_individual().intValue());
			}
			Cell R57cell55 = R57row.getCell(57);
			if (R57cell55 != null) {
				R57cell55.setCellValue(brf94c.getR57_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR57_no_of_transactions_other_services_individual().intValue());
			}

			Cell R57cell56 = R57row.getCell(58);
			if (R57cell56 != null) {
				R57cell56.setCellValue(brf94c.getR57_amount_other_services_individual() == null ? 0
						: brf94c.getR57_amount_other_services_individual().intValue());
			}

			Row R58row = sheet.getRow(66);
			Cell R58cell1 = R58row.getCell(3);
			if (R58cell1 != null) {
				R58cell1.setCellValue(brf94c.getR58_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR58_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R58cell2 = R58row.getCell(4);
			if (R58cell2 != null) {
				R58cell2.setCellValue(brf94c.getR58_amount_financial_investment_government() == null ? 0
						: brf94c.getR58_amount_financial_investment_government().intValue());
			}
			Cell R58cell3 = R58row.getCell(5);
			if (R58cell3 != null) {
				R58cell3.setCellValue(brf94c.getR58_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR58_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R58cell4 = R58row.getCell(6);
			if (R58cell4 != null) {
				R58cell4.setCellValue(brf94c.getR58_amount_direct_investment_government() == null ? 0
						: brf94c.getR58_amount_direct_investment_government().intValue());
			}
			Cell R58cell5 = R58row.getCell(7);
			if (R58cell5 != null) {
				R58cell5.setCellValue(brf94c.getR58_no_of_transactions_services_government() == null ? 0
						: brf94c.getR58_no_of_transactions_services_government().intValue());
			}
			Cell R58cell6 = R58row.getCell(8);
			if (R58cell6 != null) {
				R58cell6.setCellValue(brf94c.getR58_amount_services_government() == null ? 0
						: brf94c.getR58_amount_services_government().intValue());
			}
			Cell R58cell7 = R58row.getCell(9);
			if (R58cell7 != null) {
				R58cell7.setCellValue(brf94c.getR58_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR58_no_of_transactions_trade_government().intValue());
			}
			Cell R58cell8 = R58row.getCell(10);
			if (R58cell8 != null) {
				R58cell8.setCellValue(brf94c.getR58_amount_trade_government() == null ? 0
						: brf94c.getR58_amount_trade_government().intValue());
			}
			Cell R58cell9 = R58row.getCell(11);
			if (R58cell9 != null) {
				R58cell9.setCellValue(brf94c.getR58_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR58_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R58cell10 = R58row.getCell(12);
			if (R58cell10 != null) {
				R58cell10.setCellValue(brf94c.getR58_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR58_amount_financial_investment_reserve().intValue());
			}
			Cell R58cell11 = R58row.getCell(13);
			if (R58cell11 != null) {
				R58cell11.setCellValue(brf94c.getR58_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR58_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R58cell12 = R58row.getCell(14);
			if (R58cell12 != null) {
				R58cell12.setCellValue(brf94c.getR58_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR58_amount_direct_investment_reserve().intValue());
			}
			Cell R58cell13 = R58row.getCell(15);
			if (R58cell13 != null) {
				R58cell13.setCellValue(brf94c.getR58_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR58_no_of_transactions_services_reserve().intValue());
			}
			Cell R58cell14 = R58row.getCell(16);
			if (R58cell14 != null) {
				R58cell14.setCellValue(brf94c.getR58_amount_services_reserve() == null ? 0
						: brf94c.getR58_amount_services_reserve().intValue());
			}
			Cell R58cell15 = R58row.getCell(17);
			if (R58cell15 != null) {
				R58cell15.setCellValue(brf94c.getR58_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR58_no_of_transactions_trade_reserve().intValue());
			}
			Cell R58cell16 = R58row.getCell(18);
			if (R58cell16 != null) {
				R58cell16.setCellValue(brf94c.getR58_amount_trade_reserve() == null ? 0
						: brf94c.getR58_amount_trade_reserve().intValue());
			}
			Cell R58cell17 = R58row.getCell(19);
			if (R58cell17 != null) {
				R58cell17.setCellValue(brf94c.getR58_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR58_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R58cell18 = R58row.getCell(20);
			if (R58cell18 != null) {
				R58cell18.setCellValue(brf94c.getR58_amount_financial_investment_gre() == null ? 0
						: brf94c.getR58_amount_financial_investment_gre().intValue());
			}
			Cell R58cell19 = R58row.getCell(21);
			if (R58cell19 != null) {
				R58cell19.setCellValue(brf94c.getR58_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR58_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R58cell20 = R58row.getCell(22);
			if (R58cell20 != null) {
				R58cell20.setCellValue(brf94c.getR58_amount_direct_investment_gre() == null ? 0
						: brf94c.getR58_amount_direct_investment_gre().intValue());
			}
			Cell R58cell21 = R58row.getCell(23);
			if (R58cell21 != null) {
				R58cell21.setCellValue(brf94c.getR58_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR58_no_of_transactions_services_gre().intValue());
			}
			Cell R58cell22 = R58row.getCell(24);
			if (R58cell22 != null) {
				R58cell22.setCellValue(brf94c.getR58_amount_services_gre() == null ? 0
						: brf94c.getR58_amount_services_gre().intValue());
			}
			Cell R58cell23 = R58row.getCell(25);
			if (R58cell23 != null) {
				R58cell23.setCellValue(brf94c.getR58_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR58_no_of_transactions_trade_gre().intValue());
			}
			Cell R58cell24 = R58row.getCell(26);
			if (R58cell24 != null) {
				R58cell24.setCellValue(
						brf94c.getR58_amount_trade_gre() == null ? 0 : brf94c.getR58_amount_trade_gre().intValue());
			}
			Cell R58cell25 = R58row.getCell(27);
			if (R58cell25 != null) {
				R58cell25.setCellValue(brf94c.getR58_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR58_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R58cell26 = R58row.getCell(28);
			if (R58cell26 != null) {
				R58cell26.setCellValue(brf94c.getR58_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR58_amount_financial_investment_corporate().intValue());
			}
			Cell R58cell27 = R58row.getCell(29);
			if (R58cell27 != null) {
				R58cell27.setCellValue(brf94c.getR58_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR58_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R58cell28 = R58row.getCell(30);
			if (R58cell28 != null) {
				R58cell28.setCellValue(brf94c.getR58_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR58_amount_direct_investment_corporate().intValue());
			}
			Cell R58cell29 = R58row.getCell(31);
			if (R58cell29 != null) {
				R58cell29.setCellValue(brf94c.getR58_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR58_no_of_transactions_services_corporate().intValue());
			}
			Cell R58cell30 = R58row.getCell(32);
			if (R58cell30 != null) {
				R58cell30.setCellValue(brf94c.getR58_amount_services_corporate() == null ? 0
						: brf94c.getR58_amount_services_corporate().intValue());
			}
			Cell R58cell31 = R58row.getCell(33);
			if (R58cell31 != null) {
				R58cell31.setCellValue(brf94c.getR58_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR58_no_of_transactions_trade_corporate().intValue());
			}
			Cell R58cell32 = R58row.getCell(34);
			if (R58cell32 != null) {
				R58cell32.setCellValue(brf94c.getR58_amount_trade_corporate() == null ? 0
						: brf94c.getR58_amount_trade_corporate().intValue());
			}
			Cell R58cell33 = R58row.getCell(35);
			if (R58cell33 != null) {
				R58cell33.setCellValue(brf94c.getR58_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR58_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R58cell34 = R58row.getCell(36);
			if (R58cell34 != null) {
				R58cell34.setCellValue(brf94c.getR58_amount_financial_investment_sme() == null ? 0
						: brf94c.getR58_amount_financial_investment_sme().intValue());
			}
			Cell R58cell35 = R58row.getCell(37);
			if (R58cell35 != null) {
				R58cell35.setCellValue(brf94c.getR58_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR58_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R58cell36 = R58row.getCell(38);
			if (R58cell36 != null) {
				R58cell36.setCellValue(brf94c.getR58_amount_direct_investment_sme() == null ? 0
						: brf94c.getR58_amount_direct_investment_sme().intValue());
			}
			Cell R58cell37 = R58row.getCell(39);
			if (R58cell37 != null) {
				R58cell37.setCellValue(brf94c.getR58_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR58_no_of_transactions_services_sme().intValue());
			}
			Cell R58cell38 = R58row.getCell(40);
			if (R58cell38 != null) {
				R58cell38.setCellValue(brf94c.getR58_amount_services_sme() == null ? 0
						: brf94c.getR58_amount_services_sme().intValue());
			}
			Cell R58cell39 = R58row.getCell(41);
			if (R58cell39 != null) {
				R58cell39.setCellValue(brf94c.getR58_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR58_no_of_transactions_trade_sme().intValue());
			}
			Cell R58cell40 = R58row.getCell(42);
			if (R58cell40 != null) {
				R58cell40.setCellValue(
						brf94c.getR58_amount_trade_sme() == null ? 0 : brf94c.getR58_amount_trade_sme().intValue());
			}
			Cell R58cell41 = R58row.getCell(43);
			if (R58cell41 != null) {
				R58cell41.setCellValue(brf94c.getR58_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R58cell42 = R58row.getCell(44);
			if (R58cell42 != null) {
				R58cell42.setCellValue(brf94c.getR58_amount_financial_investment_individual() == null ? 0
						: brf94c.getR58_amount_financial_investment_individual().intValue());
			}
			Cell R58cell43 = R58row.getCell(45);
			if (R58cell43 != null) {
				R58cell43.setCellValue(brf94c.getR58_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R58cell44 = R58row.getCell(46);
			if (R58cell44 != null) {
				R58cell44.setCellValue(brf94c.getR58_amount_direct_investment_individual() == null ? 0
						: brf94c.getR58_amount_direct_investment_individual().intValue());
			}
			Cell R58cell45 = R58row.getCell(47);
			if (R58cell45 != null) {
				R58cell45.setCellValue(brf94c.getR58_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_family_support_individual().intValue());
			}
			Cell R58cell46 = R58row.getCell(48);
			if (R58cell46 != null) {
				R58cell46.setCellValue(brf94c.getR58_amount_family_support_individual() == null ? 0
						: brf94c.getR58_amount_family_support_individual().intValue());
			}
			Cell R58cell47 = R58row.getCell(49);
			if (R58cell47 != null) {
				R58cell47.setCellValue(brf94c.getR58_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_education_individual().intValue());
			}
			Cell R58cell48 = R58row.getCell(50);
			if (R58cell48 != null) {
				R58cell48.setCellValue(brf94c.getR58_amount_education_individual() == null ? 0
						: brf94c.getR58_amount_education_individual().intValue());
			}
			Cell R58cell49 = R58row.getCell(51);
			if (R58cell49 != null) {
				R58cell49.setCellValue(brf94c.getR58_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_medical_individual().intValue());
			}

			Cell R58cell50 = R58row.getCell(52);
			if (R58cell50 != null) {
				R58cell50.setCellValue(brf94c.getR58_amount_medical_individual() == null ? 0
						: brf94c.getR58_amount_medical_individual().intValue());
			}
			Cell R58cell51 = R58row.getCell(53);
			if (R58cell51 != null) {
				R58cell51.setCellValue(brf94c.getR58_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_tourism_individual().intValue());
			}
			Cell R58cell52 = R58row.getCell(54);
			if (R58cell52 != null) {
				R58cell52.setCellValue(brf94c.getR58_amount_tourism_individual() == null ? 0
						: brf94c.getR58_amount_tourism_individual().intValue());
			}
			Cell R58cell53 = R58row.getCell(55);
			if (R58cell53 != null) {
				R58cell53.setCellValue(brf94c.getR58_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R58cell54 = R58row.getCell(56);
			if (R58cell54 != null) {
				R58cell54.setCellValue(brf94c.getR58_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR58_amount_debt_settlement_individual().intValue());
			}
			Cell R58cell55 = R58row.getCell(57);
			if (R58cell55 != null) {
				R58cell55.setCellValue(brf94c.getR58_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR58_no_of_transactions_other_services_individual().intValue());
			}

			Cell R58cell56 = R58row.getCell(58);
			if (R58cell56 != null) {
				R58cell56.setCellValue(brf94c.getR58_amount_other_services_individual() == null ? 0
						: brf94c.getR58_amount_other_services_individual().intValue());
			}

			Row R59row = sheet.getRow(67);
			Cell R59cell1 = R59row.getCell(3);
			if (R59cell1 != null) {
				R59cell1.setCellValue(brf94c.getR59_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR59_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R59cell2 = R59row.getCell(4);
			if (R59cell2 != null) {
				R59cell2.setCellValue(brf94c.getR59_amount_financial_investment_government() == null ? 0
						: brf94c.getR59_amount_financial_investment_government().intValue());
			}
			Cell R59cell3 = R59row.getCell(5);
			if (R59cell3 != null) {
				R59cell3.setCellValue(brf94c.getR59_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR59_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R59cell4 = R59row.getCell(6);
			if (R59cell4 != null) {
				R59cell4.setCellValue(brf94c.getR59_amount_direct_investment_government() == null ? 0
						: brf94c.getR59_amount_direct_investment_government().intValue());
			}
			Cell R59cell5 = R59row.getCell(7);
			if (R59cell5 != null) {
				R59cell5.setCellValue(brf94c.getR59_no_of_transactions_services_government() == null ? 0
						: brf94c.getR59_no_of_transactions_services_government().intValue());
			}
			Cell R59cell6 = R59row.getCell(8);
			if (R59cell6 != null) {
				R59cell6.setCellValue(brf94c.getR59_amount_services_government() == null ? 0
						: brf94c.getR59_amount_services_government().intValue());
			}
			Cell R59cell7 = R59row.getCell(9);
			if (R59cell7 != null) {
				R59cell7.setCellValue(brf94c.getR59_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR59_no_of_transactions_trade_government().intValue());
			}
			Cell R59cell8 = R59row.getCell(10);
			if (R59cell8 != null) {
				R59cell8.setCellValue(brf94c.getR59_amount_trade_government() == null ? 0
						: brf94c.getR59_amount_trade_government().intValue());
			}
			Cell R59cell9 = R59row.getCell(11);
			if (R59cell9 != null) {
				R59cell9.setCellValue(brf94c.getR59_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR59_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R59cell10 = R59row.getCell(12);
			if (R59cell10 != null) {
				R59cell10.setCellValue(brf94c.getR59_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR59_amount_financial_investment_reserve().intValue());
			}
			Cell R59cell11 = R59row.getCell(13);
			if (R59cell11 != null) {
				R59cell11.setCellValue(brf94c.getR59_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR59_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R59cell12 = R59row.getCell(14);
			if (R59cell12 != null) {
				R59cell12.setCellValue(brf94c.getR59_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR59_amount_direct_investment_reserve().intValue());
			}
			Cell R59cell13 = R59row.getCell(15);
			if (R59cell13 != null) {
				R59cell13.setCellValue(brf94c.getR59_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR59_no_of_transactions_services_reserve().intValue());
			}
			Cell R59cell14 = R59row.getCell(16);
			if (R59cell14 != null) {
				R59cell14.setCellValue(brf94c.getR59_amount_services_reserve() == null ? 0
						: brf94c.getR59_amount_services_reserve().intValue());
			}
			Cell R59cell15 = R59row.getCell(17);
			if (R59cell15 != null) {
				R59cell15.setCellValue(brf94c.getR59_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR59_no_of_transactions_trade_reserve().intValue());
			}
			Cell R59cell16 = R59row.getCell(18);
			if (R59cell16 != null) {
				R59cell16.setCellValue(brf94c.getR59_amount_trade_reserve() == null ? 0
						: brf94c.getR59_amount_trade_reserve().intValue());
			}
			Cell R59cell17 = R59row.getCell(19);
			if (R59cell17 != null) {
				R59cell17.setCellValue(brf94c.getR59_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR59_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R59cell18 = R59row.getCell(20);
			if (R59cell18 != null) {
				R59cell18.setCellValue(brf94c.getR59_amount_financial_investment_gre() == null ? 0
						: brf94c.getR59_amount_financial_investment_gre().intValue());
			}
			Cell R59cell19 = R59row.getCell(21);
			if (R59cell19 != null) {
				R59cell19.setCellValue(brf94c.getR59_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR59_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R59cell20 = R59row.getCell(22);
			if (R59cell20 != null) {
				R59cell20.setCellValue(brf94c.getR59_amount_direct_investment_gre() == null ? 0
						: brf94c.getR59_amount_direct_investment_gre().intValue());
			}
			Cell R59cell21 = R59row.getCell(23);
			if (R59cell21 != null) {
				R59cell21.setCellValue(brf94c.getR59_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR59_no_of_transactions_services_gre().intValue());
			}
			Cell R59cell22 = R59row.getCell(24);
			if (R59cell22 != null) {
				R59cell22.setCellValue(brf94c.getR59_amount_services_gre() == null ? 0
						: brf94c.getR59_amount_services_gre().intValue());
			}
			Cell R59cell23 = R59row.getCell(25);
			if (R59cell23 != null) {
				R59cell23.setCellValue(brf94c.getR59_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR59_no_of_transactions_trade_gre().intValue());
			}
			Cell R59cell24 = R59row.getCell(26);
			if (R59cell24 != null) {
				R59cell24.setCellValue(
						brf94c.getR59_amount_trade_gre() == null ? 0 : brf94c.getR59_amount_trade_gre().intValue());
			}
			Cell R59cell25 = R59row.getCell(27);
			if (R59cell25 != null) {
				R59cell25.setCellValue(brf94c.getR59_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR59_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R59cell26 = R59row.getCell(28);
			if (R59cell26 != null) {
				R59cell26.setCellValue(brf94c.getR59_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR59_amount_financial_investment_corporate().intValue());
			}
			Cell R59cell27 = R59row.getCell(29);
			if (R59cell27 != null) {
				R59cell27.setCellValue(brf94c.getR59_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR59_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R59cell28 = R59row.getCell(30);
			if (R59cell28 != null) {
				R59cell28.setCellValue(brf94c.getR59_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR59_amount_direct_investment_corporate().intValue());
			}
			Cell R59cell29 = R59row.getCell(31);
			if (R59cell29 != null) {
				R59cell29.setCellValue(brf94c.getR59_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR59_no_of_transactions_services_corporate().intValue());
			}
			Cell R59cell30 = R59row.getCell(32);
			if (R59cell30 != null) {
				R59cell30.setCellValue(brf94c.getR59_amount_services_corporate() == null ? 0
						: brf94c.getR59_amount_services_corporate().intValue());
			}
			Cell R59cell31 = R59row.getCell(33);
			if (R59cell31 != null) {
				R59cell31.setCellValue(brf94c.getR59_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR59_no_of_transactions_trade_corporate().intValue());
			}
			Cell R59cell32 = R59row.getCell(34);
			if (R59cell32 != null) {
				R59cell32.setCellValue(brf94c.getR59_amount_trade_corporate() == null ? 0
						: brf94c.getR59_amount_trade_corporate().intValue());
			}
			Cell R59cell33 = R59row.getCell(35);
			if (R59cell33 != null) {
				R59cell33.setCellValue(brf94c.getR59_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR59_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R59cell34 = R59row.getCell(36);
			if (R59cell34 != null) {
				R59cell34.setCellValue(brf94c.getR59_amount_financial_investment_sme() == null ? 0
						: brf94c.getR59_amount_financial_investment_sme().intValue());
			}
			Cell R59cell35 = R59row.getCell(37);
			if (R59cell35 != null) {
				R59cell35.setCellValue(brf94c.getR59_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR59_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R59cell36 = R59row.getCell(38);
			if (R59cell36 != null) {
				R59cell36.setCellValue(brf94c.getR59_amount_direct_investment_sme() == null ? 0
						: brf94c.getR59_amount_direct_investment_sme().intValue());
			}
			Cell R59cell37 = R59row.getCell(39);
			if (R59cell37 != null) {
				R59cell37.setCellValue(brf94c.getR59_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR59_no_of_transactions_services_sme().intValue());
			}
			Cell R59cell38 = R59row.getCell(40);
			if (R59cell38 != null) {
				R59cell38.setCellValue(brf94c.getR59_amount_services_sme() == null ? 0
						: brf94c.getR59_amount_services_sme().intValue());
			}
			Cell R59cell39 = R59row.getCell(41);
			if (R59cell39 != null) {
				R59cell39.setCellValue(brf94c.getR59_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR59_no_of_transactions_trade_sme().intValue());
			}
			Cell R59cell40 = R59row.getCell(42);
			if (R59cell40 != null) {
				R59cell40.setCellValue(
						brf94c.getR59_amount_trade_sme() == null ? 0 : brf94c.getR59_amount_trade_sme().intValue());
			}
			Cell R59cell41 = R59row.getCell(43);
			if (R59cell41 != null) {
				R59cell41.setCellValue(brf94c.getR59_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R59cell42 = R59row.getCell(44);
			if (R59cell42 != null) {
				R59cell42.setCellValue(brf94c.getR59_amount_financial_investment_individual() == null ? 0
						: brf94c.getR59_amount_financial_investment_individual().intValue());
			}
			Cell R59cell43 = R59row.getCell(45);
			if (R59cell43 != null) {
				R59cell43.setCellValue(brf94c.getR59_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R59cell44 = R59row.getCell(46);
			if (R59cell44 != null) {
				R59cell44.setCellValue(brf94c.getR59_amount_direct_investment_individual() == null ? 0
						: brf94c.getR59_amount_direct_investment_individual().intValue());
			}
			Cell R59cell45 = R59row.getCell(47);
			if (R59cell45 != null) {
				R59cell45.setCellValue(brf94c.getR59_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_family_support_individual().intValue());
			}
			Cell R59cell46 = R59row.getCell(48);
			if (R59cell46 != null) {
				R59cell46.setCellValue(brf94c.getR59_amount_family_support_individual() == null ? 0
						: brf94c.getR59_amount_family_support_individual().intValue());
			}
			Cell R59cell47 = R59row.getCell(49);
			if (R59cell47 != null) {
				R59cell47.setCellValue(brf94c.getR59_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_education_individual().intValue());
			}
			Cell R59cell48 = R59row.getCell(50);
			if (R59cell48 != null) {
				R59cell48.setCellValue(brf94c.getR59_amount_education_individual() == null ? 0
						: brf94c.getR59_amount_education_individual().intValue());
			}
			Cell R59cell49 = R59row.getCell(51);
			if (R59cell49 != null) {
				R59cell49.setCellValue(brf94c.getR59_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_medical_individual().intValue());
			}

			Cell R59cell50 = R59row.getCell(52);
			if (R59cell50 != null) {
				R59cell50.setCellValue(brf94c.getR59_amount_medical_individual() == null ? 0
						: brf94c.getR59_amount_medical_individual().intValue());
			}
			Cell R59cell51 = R59row.getCell(53);
			if (R59cell51 != null) {
				R59cell51.setCellValue(brf94c.getR59_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_tourism_individual().intValue());
			}
			Cell R59cell52 = R59row.getCell(54);
			if (R59cell52 != null) {
				R59cell52.setCellValue(brf94c.getR59_amount_tourism_individual() == null ? 0
						: brf94c.getR59_amount_tourism_individual().intValue());
			}
			Cell R59cell53 = R59row.getCell(55);
			if (R59cell53 != null) {
				R59cell53.setCellValue(brf94c.getR59_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R59cell54 = R59row.getCell(56);
			if (R59cell54 != null) {
				R59cell54.setCellValue(brf94c.getR59_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR59_amount_debt_settlement_individual().intValue());
			}
			Cell R59cell55 = R59row.getCell(57);
			if (R59cell55 != null) {
				R59cell55.setCellValue(brf94c.getR59_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR59_no_of_transactions_other_services_individual().intValue());
			}

			Cell R59cell56 = R59row.getCell(58);
			if (R59cell56 != null) {
				R59cell56.setCellValue(brf94c.getR59_amount_other_services_individual() == null ? 0
						: brf94c.getR59_amount_other_services_individual().intValue());
			}

			Row R60row = sheet.getRow(68);
			Cell R60cell1 = R60row.getCell(3);
			if (R60cell1 != null) {
				R60cell1.setCellValue(brf94c.getR60_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR60_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R60cell2 = R60row.getCell(4);
			if (R60cell2 != null) {
				R60cell2.setCellValue(brf94c.getR60_amount_financial_investment_government() == null ? 0
						: brf94c.getR60_amount_financial_investment_government().intValue());
			}
			Cell R60cell3 = R60row.getCell(5);
			if (R60cell3 != null) {
				R60cell3.setCellValue(brf94c.getR60_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR60_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R60cell4 = R60row.getCell(6);
			if (R60cell4 != null) {
				R60cell4.setCellValue(brf94c.getR60_amount_direct_investment_government() == null ? 0
						: brf94c.getR60_amount_direct_investment_government().intValue());
			}
			Cell R60cell5 = R60row.getCell(7);
			if (R60cell5 != null) {
				R60cell5.setCellValue(brf94c.getR60_no_of_transactions_services_government() == null ? 0
						: brf94c.getR60_no_of_transactions_services_government().intValue());
			}
			Cell R60cell6 = R60row.getCell(8);
			if (R60cell6 != null) {
				R60cell6.setCellValue(brf94c.getR60_amount_services_government() == null ? 0
						: brf94c.getR60_amount_services_government().intValue());
			}
			Cell R60cell7 = R60row.getCell(9);
			if (R60cell7 != null) {
				R60cell7.setCellValue(brf94c.getR60_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR60_no_of_transactions_trade_government().intValue());
			}
			Cell R60cell8 = R60row.getCell(10);
			if (R60cell8 != null) {
				R60cell8.setCellValue(brf94c.getR60_amount_trade_government() == null ? 0
						: brf94c.getR60_amount_trade_government().intValue());
			}
			Cell R60cell9 = R60row.getCell(11);
			if (R60cell9 != null) {
				R60cell9.setCellValue(brf94c.getR60_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR60_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R60cell10 = R60row.getCell(12);
			if (R60cell10 != null) {
				R60cell10.setCellValue(brf94c.getR60_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR60_amount_financial_investment_reserve().intValue());
			}
			Cell R60cell11 = R60row.getCell(13);
			if (R60cell11 != null) {
				R60cell11.setCellValue(brf94c.getR60_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR60_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R60cell12 = R60row.getCell(14);
			if (R60cell12 != null) {
				R60cell12.setCellValue(brf94c.getR60_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR60_amount_direct_investment_reserve().intValue());
			}
			Cell R60cell13 = R60row.getCell(15);
			if (R60cell13 != null) {
				R60cell13.setCellValue(brf94c.getR60_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR60_no_of_transactions_services_reserve().intValue());
			}
			Cell R60cell14 = R60row.getCell(16);
			if (R60cell14 != null) {
				R60cell14.setCellValue(brf94c.getR60_amount_services_reserve() == null ? 0
						: brf94c.getR60_amount_services_reserve().intValue());
			}
			Cell R60cell15 = R60row.getCell(17);
			if (R60cell15 != null) {
				R60cell15.setCellValue(brf94c.getR60_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR60_no_of_transactions_trade_reserve().intValue());
			}
			Cell R60cell16 = R60row.getCell(18);
			if (R60cell16 != null) {
				R60cell16.setCellValue(brf94c.getR60_amount_trade_reserve() == null ? 0
						: brf94c.getR60_amount_trade_reserve().intValue());
			}
			Cell R60cell17 = R60row.getCell(19);
			if (R60cell17 != null) {
				R60cell17.setCellValue(brf94c.getR60_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR60_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R60cell18 = R60row.getCell(20);
			if (R60cell18 != null) {
				R60cell18.setCellValue(brf94c.getR60_amount_financial_investment_gre() == null ? 0
						: brf94c.getR60_amount_financial_investment_gre().intValue());
			}
			Cell R60cell19 = R60row.getCell(21);
			if (R60cell19 != null) {
				R60cell19.setCellValue(brf94c.getR60_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR60_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R60cell20 = R60row.getCell(22);
			if (R60cell20 != null) {
				R60cell20.setCellValue(brf94c.getR60_amount_direct_investment_gre() == null ? 0
						: brf94c.getR60_amount_direct_investment_gre().intValue());
			}
			Cell R60cell21 = R60row.getCell(23);
			if (R60cell21 != null) {
				R60cell21.setCellValue(brf94c.getR60_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR60_no_of_transactions_services_gre().intValue());
			}
			Cell R60cell22 = R60row.getCell(24);
			if (R60cell22 != null) {
				R60cell22.setCellValue(brf94c.getR60_amount_services_gre() == null ? 0
						: brf94c.getR60_amount_services_gre().intValue());
			}
			Cell R60cell23 = R60row.getCell(25);
			if (R60cell23 != null) {
				R60cell23.setCellValue(brf94c.getR60_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR60_no_of_transactions_trade_gre().intValue());
			}
			Cell R60cell24 = R60row.getCell(26);
			if (R60cell24 != null) {
				R60cell24.setCellValue(
						brf94c.getR60_amount_trade_gre() == null ? 0 : brf94c.getR60_amount_trade_gre().intValue());
			}
			Cell R60cell25 = R60row.getCell(27);
			if (R60cell25 != null) {
				R60cell25.setCellValue(brf94c.getR60_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR60_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R60cell26 = R60row.getCell(28);
			if (R60cell26 != null) {
				R60cell26.setCellValue(brf94c.getR60_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR60_amount_financial_investment_corporate().intValue());
			}
			Cell R60cell27 = R60row.getCell(29);
			if (R60cell27 != null) {
				R60cell27.setCellValue(brf94c.getR60_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR60_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R60cell28 = R60row.getCell(30);
			if (R60cell28 != null) {
				R60cell28.setCellValue(brf94c.getR60_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR60_amount_direct_investment_corporate().intValue());
			}
			Cell R60cell29 = R60row.getCell(31);
			if (R60cell29 != null) {
				R60cell29.setCellValue(brf94c.getR60_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR60_no_of_transactions_services_corporate().intValue());
			}
			Cell R60cell30 = R60row.getCell(32);
			if (R60cell30 != null) {
				R60cell30.setCellValue(brf94c.getR60_amount_services_corporate() == null ? 0
						: brf94c.getR60_amount_services_corporate().intValue());
			}
			Cell R60cell31 = R60row.getCell(33);
			if (R60cell31 != null) {
				R60cell31.setCellValue(brf94c.getR60_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR60_no_of_transactions_trade_corporate().intValue());
			}
			Cell R60cell32 = R60row.getCell(34);
			if (R60cell32 != null) {
				R60cell32.setCellValue(brf94c.getR60_amount_trade_corporate() == null ? 0
						: brf94c.getR60_amount_trade_corporate().intValue());
			}
			Cell R60cell33 = R60row.getCell(35);
			if (R60cell33 != null) {
				R60cell33.setCellValue(brf94c.getR60_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR60_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R60cell34 = R60row.getCell(36);
			if (R60cell34 != null) {
				R60cell34.setCellValue(brf94c.getR60_amount_financial_investment_sme() == null ? 0
						: brf94c.getR60_amount_financial_investment_sme().intValue());
			}
			Cell R60cell35 = R60row.getCell(37);
			if (R60cell35 != null) {
				R60cell35.setCellValue(brf94c.getR60_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR60_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R60cell36 = R60row.getCell(38);
			if (R60cell36 != null) {
				R60cell36.setCellValue(brf94c.getR60_amount_direct_investment_sme() == null ? 0
						: brf94c.getR60_amount_direct_investment_sme().intValue());
			}
			Cell R60cell37 = R60row.getCell(39);
			if (R60cell37 != null) {
				R60cell37.setCellValue(brf94c.getR60_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR60_no_of_transactions_services_sme().intValue());
			}
			Cell R60cell38 = R60row.getCell(40);
			if (R60cell38 != null) {
				R60cell38.setCellValue(brf94c.getR60_amount_services_sme() == null ? 0
						: brf94c.getR60_amount_services_sme().intValue());
			}
			Cell R60cell39 = R60row.getCell(41);
			if (R60cell39 != null) {
				R60cell39.setCellValue(brf94c.getR60_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR60_no_of_transactions_trade_sme().intValue());
			}
			Cell R60cell40 = R60row.getCell(42);
			if (R60cell40 != null) {
				R60cell40.setCellValue(
						brf94c.getR60_amount_trade_sme() == null ? 0 : brf94c.getR60_amount_trade_sme().intValue());
			}
			Cell R60cell41 = R60row.getCell(43);
			if (R60cell41 != null) {
				R60cell41.setCellValue(brf94c.getR60_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R60cell42 = R60row.getCell(44);
			if (R60cell42 != null) {
				R60cell42.setCellValue(brf94c.getR60_amount_financial_investment_individual() == null ? 0
						: brf94c.getR60_amount_financial_investment_individual().intValue());
			}
			Cell R60cell43 = R60row.getCell(45);
			if (R60cell43 != null) {
				R60cell43.setCellValue(brf94c.getR60_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R60cell44 = R60row.getCell(46);
			if (R60cell44 != null) {
				R60cell44.setCellValue(brf94c.getR60_amount_direct_investment_individual() == null ? 0
						: brf94c.getR60_amount_direct_investment_individual().intValue());
			}
			Cell R60cell45 = R60row.getCell(47);
			if (R60cell45 != null) {
				R60cell45.setCellValue(brf94c.getR60_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_family_support_individual().intValue());
			}
			Cell R60cell46 = R60row.getCell(48);
			if (R60cell46 != null) {
				R60cell46.setCellValue(brf94c.getR60_amount_family_support_individual() == null ? 0
						: brf94c.getR60_amount_family_support_individual().intValue());
			}
			Cell R60cell47 = R60row.getCell(49);
			if (R60cell47 != null) {
				R60cell47.setCellValue(brf94c.getR60_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_education_individual().intValue());
			}
			Cell R60cell48 = R60row.getCell(50);
			if (R60cell48 != null) {
				R60cell48.setCellValue(brf94c.getR60_amount_education_individual() == null ? 0
						: brf94c.getR60_amount_education_individual().intValue());
			}
			Cell R60cell49 = R60row.getCell(51);
			if (R60cell49 != null) {
				R60cell49.setCellValue(brf94c.getR60_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_medical_individual().intValue());
			}

			Cell R60cell50 = R60row.getCell(52);
			if (R60cell50 != null) {
				R60cell50.setCellValue(brf94c.getR60_amount_medical_individual() == null ? 0
						: brf94c.getR60_amount_medical_individual().intValue());
			}
			Cell R60cell51 = R60row.getCell(53);
			if (R60cell51 != null) {
				R60cell51.setCellValue(brf94c.getR60_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_tourism_individual().intValue());
			}
			Cell R60cell52 = R60row.getCell(54);
			if (R60cell52 != null) {
				R60cell52.setCellValue(brf94c.getR60_amount_tourism_individual() == null ? 0
						: brf94c.getR60_amount_tourism_individual().intValue());
			}
			Cell R60cell53 = R60row.getCell(55);
			if (R60cell53 != null) {
				R60cell53.setCellValue(brf94c.getR60_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R60cell54 = R60row.getCell(56);
			if (R60cell54 != null) {
				R60cell54.setCellValue(brf94c.getR60_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR60_amount_debt_settlement_individual().intValue());
			}
			Cell R60cell55 = R60row.getCell(57);
			if (R60cell55 != null) {
				R60cell55.setCellValue(brf94c.getR60_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR60_no_of_transactions_other_services_individual().intValue());
			}

			Cell R60cell56 = R60row.getCell(58);
			if (R60cell56 != null) {
				R60cell56.setCellValue(brf94c.getR60_amount_other_services_individual() == null ? 0
						: brf94c.getR60_amount_other_services_individual().intValue());
			}

			Row R61row = sheet.getRow(69);
			Cell R61cell1 = R61row.getCell(3);
			if (R61cell1 != null) {
				R61cell1.setCellValue(brf94c.getR61_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR61_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R61cell2 = R61row.getCell(4);
			if (R61cell2 != null) {
				R61cell2.setCellValue(brf94c.getR61_amount_financial_investment_government() == null ? 0
						: brf94c.getR61_amount_financial_investment_government().intValue());
			}
			Cell R61cell3 = R61row.getCell(5);
			if (R61cell3 != null) {
				R61cell3.setCellValue(brf94c.getR61_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR61_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R61cell4 = R61row.getCell(6);
			if (R61cell4 != null) {
				R61cell4.setCellValue(brf94c.getR61_amount_direct_investment_government() == null ? 0
						: brf94c.getR61_amount_direct_investment_government().intValue());
			}
			Cell R61cell5 = R61row.getCell(7);
			if (R61cell5 != null) {
				R61cell5.setCellValue(brf94c.getR61_no_of_transactions_services_government() == null ? 0
						: brf94c.getR61_no_of_transactions_services_government().intValue());
			}
			Cell R61cell6 = R61row.getCell(8);
			if (R61cell6 != null) {
				R61cell6.setCellValue(brf94c.getR61_amount_services_government() == null ? 0
						: brf94c.getR61_amount_services_government().intValue());
			}
			Cell R61cell7 = R61row.getCell(9);
			if (R61cell7 != null) {
				R61cell7.setCellValue(brf94c.getR61_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR61_no_of_transactions_trade_government().intValue());
			}
			Cell R61cell8 = R61row.getCell(10);
			if (R61cell8 != null) {
				R61cell8.setCellValue(brf94c.getR61_amount_trade_government() == null ? 0
						: brf94c.getR61_amount_trade_government().intValue());
			}
			Cell R61cell9 = R61row.getCell(11);
			if (R61cell9 != null) {
				R61cell9.setCellValue(brf94c.getR61_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR61_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R61cell10 = R61row.getCell(12);
			if (R61cell10 != null) {
				R61cell10.setCellValue(brf94c.getR61_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR61_amount_financial_investment_reserve().intValue());
			}
			Cell R61cell11 = R61row.getCell(13);
			if (R61cell11 != null) {
				R61cell11.setCellValue(brf94c.getR61_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR61_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R61cell12 = R61row.getCell(14);
			if (R61cell12 != null) {
				R61cell12.setCellValue(brf94c.getR61_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR61_amount_direct_investment_reserve().intValue());
			}
			Cell R61cell13 = R61row.getCell(15);
			if (R61cell13 != null) {
				R61cell13.setCellValue(brf94c.getR61_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR61_no_of_transactions_services_reserve().intValue());
			}
			Cell R61cell14 = R61row.getCell(16);
			if (R61cell14 != null) {
				R61cell14.setCellValue(brf94c.getR61_amount_services_reserve() == null ? 0
						: brf94c.getR61_amount_services_reserve().intValue());
			}
			Cell R61cell15 = R61row.getCell(17);
			if (R61cell15 != null) {
				R61cell15.setCellValue(brf94c.getR61_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR61_no_of_transactions_trade_reserve().intValue());
			}
			Cell R61cell16 = R61row.getCell(18);
			if (R61cell16 != null) {
				R61cell16.setCellValue(brf94c.getR61_amount_trade_reserve() == null ? 0
						: brf94c.getR61_amount_trade_reserve().intValue());
			}
			Cell R61cell17 = R61row.getCell(19);
			if (R61cell17 != null) {
				R61cell17.setCellValue(brf94c.getR61_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR61_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R61cell18 = R61row.getCell(20);
			if (R61cell18 != null) {
				R61cell18.setCellValue(brf94c.getR61_amount_financial_investment_gre() == null ? 0
						: brf94c.getR61_amount_financial_investment_gre().intValue());
			}
			Cell R61cell19 = R61row.getCell(21);
			if (R61cell19 != null) {
				R61cell19.setCellValue(brf94c.getR61_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR61_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R61cell20 = R61row.getCell(22);
			if (R61cell20 != null) {
				R61cell20.setCellValue(brf94c.getR61_amount_direct_investment_gre() == null ? 0
						: brf94c.getR61_amount_direct_investment_gre().intValue());
			}
			Cell R61cell21 = R61row.getCell(23);
			if (R61cell21 != null) {
				R61cell21.setCellValue(brf94c.getR61_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR61_no_of_transactions_services_gre().intValue());
			}
			Cell R61cell22 = R61row.getCell(24);
			if (R61cell22 != null) {
				R61cell22.setCellValue(brf94c.getR61_amount_services_gre() == null ? 0
						: brf94c.getR61_amount_services_gre().intValue());
			}
			Cell R61cell23 = R61row.getCell(25);
			if (R61cell23 != null) {
				R61cell23.setCellValue(brf94c.getR61_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR61_no_of_transactions_trade_gre().intValue());
			}
			Cell R61cell24 = R61row.getCell(26);
			if (R61cell24 != null) {
				R61cell24.setCellValue(
						brf94c.getR61_amount_trade_gre() == null ? 0 : brf94c.getR61_amount_trade_gre().intValue());
			}
			Cell R61cell25 = R61row.getCell(27);
			if (R61cell25 != null) {
				R61cell25.setCellValue(brf94c.getR61_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR61_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R61cell26 = R61row.getCell(28);
			if (R61cell26 != null) {
				R61cell26.setCellValue(brf94c.getR61_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR61_amount_financial_investment_corporate().intValue());
			}
			Cell R61cell27 = R61row.getCell(29);
			if (R61cell27 != null) {
				R61cell27.setCellValue(brf94c.getR61_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR61_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R61cell28 = R61row.getCell(30);
			if (R61cell28 != null) {
				R61cell28.setCellValue(brf94c.getR61_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR61_amount_direct_investment_corporate().intValue());
			}
			Cell R61cell29 = R61row.getCell(31);
			if (R61cell29 != null) {
				R61cell29.setCellValue(brf94c.getR61_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR61_no_of_transactions_services_corporate().intValue());
			}
			Cell R61cell30 = R61row.getCell(32);
			if (R61cell30 != null) {
				R61cell30.setCellValue(brf94c.getR61_amount_services_corporate() == null ? 0
						: brf94c.getR61_amount_services_corporate().intValue());
			}
			Cell R61cell31 = R61row.getCell(33);
			if (R61cell31 != null) {
				R61cell31.setCellValue(brf94c.getR61_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR61_no_of_transactions_trade_corporate().intValue());
			}
			Cell R61cell32 = R61row.getCell(34);
			if (R61cell32 != null) {
				R61cell32.setCellValue(brf94c.getR61_amount_trade_corporate() == null ? 0
						: brf94c.getR61_amount_trade_corporate().intValue());
			}
			Cell R61cell33 = R61row.getCell(35);
			if (R61cell33 != null) {
				R61cell33.setCellValue(brf94c.getR61_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR61_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R61cell34 = R61row.getCell(36);
			if (R61cell34 != null) {
				R61cell34.setCellValue(brf94c.getR61_amount_financial_investment_sme() == null ? 0
						: brf94c.getR61_amount_financial_investment_sme().intValue());
			}
			Cell R61cell35 = R61row.getCell(37);
			if (R61cell35 != null) {
				R61cell35.setCellValue(brf94c.getR61_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR61_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R61cell36 = R61row.getCell(38);
			if (R61cell36 != null) {
				R61cell36.setCellValue(brf94c.getR61_amount_direct_investment_sme() == null ? 0
						: brf94c.getR61_amount_direct_investment_sme().intValue());
			}
			Cell R61cell37 = R61row.getCell(39);
			if (R61cell37 != null) {
				R61cell37.setCellValue(brf94c.getR61_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR61_no_of_transactions_services_sme().intValue());
			}
			Cell R61cell38 = R61row.getCell(40);
			if (R61cell38 != null) {
				R61cell38.setCellValue(brf94c.getR61_amount_services_sme() == null ? 0
						: brf94c.getR61_amount_services_sme().intValue());
			}
			Cell R61cell39 = R61row.getCell(41);
			if (R61cell39 != null) {
				R61cell39.setCellValue(brf94c.getR61_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR61_no_of_transactions_trade_sme().intValue());
			}
			Cell R61cell40 = R61row.getCell(42);
			if (R61cell40 != null) {
				R61cell40.setCellValue(
						brf94c.getR61_amount_trade_sme() == null ? 0 : brf94c.getR61_amount_trade_sme().intValue());
			}
			Cell R61cell41 = R61row.getCell(43);
			if (R61cell41 != null) {
				R61cell41.setCellValue(brf94c.getR61_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R61cell42 = R61row.getCell(44);
			if (R61cell42 != null) {
				R61cell42.setCellValue(brf94c.getR61_amount_financial_investment_individual() == null ? 0
						: brf94c.getR61_amount_financial_investment_individual().intValue());
			}
			Cell R61cell43 = R61row.getCell(45);
			if (R61cell43 != null) {
				R61cell43.setCellValue(brf94c.getR61_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R61cell44 = R61row.getCell(46);
			if (R61cell44 != null) {
				R61cell44.setCellValue(brf94c.getR61_amount_direct_investment_individual() == null ? 0
						: brf94c.getR61_amount_direct_investment_individual().intValue());
			}
			Cell R61cell45 = R61row.getCell(47);
			if (R61cell45 != null) {
				R61cell45.setCellValue(brf94c.getR61_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_family_support_individual().intValue());
			}
			Cell R61cell46 = R61row.getCell(48);
			if (R61cell46 != null) {
				R61cell46.setCellValue(brf94c.getR61_amount_family_support_individual() == null ? 0
						: brf94c.getR61_amount_family_support_individual().intValue());
			}
			Cell R61cell47 = R61row.getCell(49);
			if (R61cell47 != null) {
				R61cell47.setCellValue(brf94c.getR61_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_education_individual().intValue());
			}
			Cell R61cell48 = R61row.getCell(50);
			if (R61cell48 != null) {
				R61cell48.setCellValue(brf94c.getR61_amount_education_individual() == null ? 0
						: brf94c.getR61_amount_education_individual().intValue());
			}
			Cell R61cell49 = R61row.getCell(51);
			if (R61cell49 != null) {
				R61cell49.setCellValue(brf94c.getR61_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_medical_individual().intValue());
			}

			Cell R61cell50 = R61row.getCell(52);
			if (R61cell50 != null) {
				R61cell50.setCellValue(brf94c.getR61_amount_medical_individual() == null ? 0
						: brf94c.getR61_amount_medical_individual().intValue());
			}
			Cell R61cell51 = R61row.getCell(53);
			if (R61cell51 != null) {
				R61cell51.setCellValue(brf94c.getR61_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_tourism_individual().intValue());
			}
			Cell R61cell52 = R61row.getCell(54);
			if (R61cell52 != null) {
				R61cell52.setCellValue(brf94c.getR61_amount_tourism_individual() == null ? 0
						: brf94c.getR61_amount_tourism_individual().intValue());
			}
			Cell R61cell53 = R61row.getCell(55);
			if (R61cell53 != null) {
				R61cell53.setCellValue(brf94c.getR61_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R61cell54 = R61row.getCell(56);
			if (R61cell54 != null) {
				R61cell54.setCellValue(brf94c.getR61_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR61_amount_debt_settlement_individual().intValue());
			}
			Cell R61cell55 = R61row.getCell(57);
			if (R61cell55 != null) {
				R61cell55.setCellValue(brf94c.getR61_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR61_no_of_transactions_other_services_individual().intValue());
			}

			Cell R61cell56 = R61row.getCell(58);
			if (R61cell56 != null) {
				R61cell56.setCellValue(brf94c.getR61_amount_other_services_individual() == null ? 0
						: brf94c.getR61_amount_other_services_individual().intValue());
			}

			Row R62row = sheet.getRow(70);
			Cell R62cell1 = R62row.getCell(3);
			if (R62cell1 != null) {
				R62cell1.setCellValue(brf94c.getR62_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR62_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R62cell2 = R62row.getCell(4);
			if (R62cell2 != null) {
				R62cell2.setCellValue(brf94c.getR62_amount_financial_investment_government() == null ? 0
						: brf94c.getR62_amount_financial_investment_government().intValue());
			}
			Cell R62cell3 = R62row.getCell(5);
			if (R62cell3 != null) {
				R62cell3.setCellValue(brf94c.getR62_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR62_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R62cell4 = R62row.getCell(6);
			if (R62cell4 != null) {
				R62cell4.setCellValue(brf94c.getR62_amount_direct_investment_government() == null ? 0
						: brf94c.getR62_amount_direct_investment_government().intValue());
			}
			Cell R62cell5 = R62row.getCell(7);
			if (R62cell5 != null) {
				R62cell5.setCellValue(brf94c.getR62_no_of_transactions_services_government() == null ? 0
						: brf94c.getR62_no_of_transactions_services_government().intValue());
			}
			Cell R62cell6 = R62row.getCell(8);
			if (R62cell6 != null) {
				R62cell6.setCellValue(brf94c.getR62_amount_services_government() == null ? 0
						: brf94c.getR62_amount_services_government().intValue());
			}
			Cell R62cell7 = R62row.getCell(9);
			if (R62cell7 != null) {
				R62cell7.setCellValue(brf94c.getR62_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR62_no_of_transactions_trade_government().intValue());
			}
			Cell R62cell8 = R62row.getCell(10);
			if (R62cell8 != null) {
				R62cell8.setCellValue(brf94c.getR62_amount_trade_government() == null ? 0
						: brf94c.getR62_amount_trade_government().intValue());
			}
			Cell R62cell9 = R62row.getCell(11);
			if (R62cell9 != null) {
				R62cell9.setCellValue(brf94c.getR62_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR62_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R62cell10 = R62row.getCell(12);
			if (R62cell10 != null) {
				R62cell10.setCellValue(brf94c.getR62_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR62_amount_financial_investment_reserve().intValue());
			}
			Cell R62cell11 = R62row.getCell(13);
			if (R62cell11 != null) {
				R62cell11.setCellValue(brf94c.getR62_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR62_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R62cell12 = R62row.getCell(14);
			if (R62cell12 != null) {
				R62cell12.setCellValue(brf94c.getR62_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR62_amount_direct_investment_reserve().intValue());
			}
			Cell R62cell13 = R62row.getCell(15);
			if (R62cell13 != null) {
				R62cell13.setCellValue(brf94c.getR62_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR62_no_of_transactions_services_reserve().intValue());
			}
			Cell R62cell14 = R62row.getCell(16);
			if (R62cell14 != null) {
				R62cell14.setCellValue(brf94c.getR62_amount_services_reserve() == null ? 0
						: brf94c.getR62_amount_services_reserve().intValue());
			}
			Cell R62cell15 = R62row.getCell(17);
			if (R62cell15 != null) {
				R62cell15.setCellValue(brf94c.getR62_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR62_no_of_transactions_trade_reserve().intValue());
			}
			Cell R62cell16 = R62row.getCell(18);
			if (R62cell16 != null) {
				R62cell16.setCellValue(brf94c.getR62_amount_trade_reserve() == null ? 0
						: brf94c.getR62_amount_trade_reserve().intValue());
			}
			Cell R62cell17 = R62row.getCell(19);
			if (R62cell17 != null) {
				R62cell17.setCellValue(brf94c.getR62_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR62_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R62cell18 = R62row.getCell(20);
			if (R62cell18 != null) {
				R62cell18.setCellValue(brf94c.getR62_amount_financial_investment_gre() == null ? 0
						: brf94c.getR62_amount_financial_investment_gre().intValue());
			}
			Cell R62cell19 = R62row.getCell(21);
			if (R62cell19 != null) {
				R62cell19.setCellValue(brf94c.getR62_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR62_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R62cell20 = R62row.getCell(22);
			if (R62cell20 != null) {
				R62cell20.setCellValue(brf94c.getR62_amount_direct_investment_gre() == null ? 0
						: brf94c.getR62_amount_direct_investment_gre().intValue());
			}
			Cell R62cell21 = R62row.getCell(23);
			if (R62cell21 != null) {
				R62cell21.setCellValue(brf94c.getR62_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR62_no_of_transactions_services_gre().intValue());
			}
			Cell R62cell22 = R62row.getCell(24);
			if (R62cell22 != null) {
				R62cell22.setCellValue(brf94c.getR62_amount_services_gre() == null ? 0
						: brf94c.getR62_amount_services_gre().intValue());
			}
			Cell R62cell23 = R62row.getCell(25);
			if (R62cell23 != null) {
				R62cell23.setCellValue(brf94c.getR62_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR62_no_of_transactions_trade_gre().intValue());
			}
			Cell R62cell24 = R62row.getCell(26);
			if (R62cell24 != null) {
				R62cell24.setCellValue(
						brf94c.getR62_amount_trade_gre() == null ? 0 : brf94c.getR62_amount_trade_gre().intValue());
			}
			Cell R62cell25 = R62row.getCell(27);
			if (R62cell25 != null) {
				R62cell25.setCellValue(brf94c.getR62_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR62_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R62cell26 = R62row.getCell(28);
			if (R62cell26 != null) {
				R62cell26.setCellValue(brf94c.getR62_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR62_amount_financial_investment_corporate().intValue());
			}
			Cell R62cell27 = R62row.getCell(29);
			if (R62cell27 != null) {
				R62cell27.setCellValue(brf94c.getR62_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR62_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R62cell28 = R62row.getCell(30);
			if (R62cell28 != null) {
				R62cell28.setCellValue(brf94c.getR62_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR62_amount_direct_investment_corporate().intValue());
			}
			Cell R62cell29 = R62row.getCell(31);
			if (R62cell29 != null) {
				R62cell29.setCellValue(brf94c.getR62_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR62_no_of_transactions_services_corporate().intValue());
			}
			Cell R62cell30 = R62row.getCell(32);
			if (R62cell30 != null) {
				R62cell30.setCellValue(brf94c.getR62_amount_services_corporate() == null ? 0
						: brf94c.getR62_amount_services_corporate().intValue());
			}
			Cell R62cell31 = R62row.getCell(33);
			if (R62cell31 != null) {
				R62cell31.setCellValue(brf94c.getR62_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR62_no_of_transactions_trade_corporate().intValue());
			}
			Cell R62cell32 = R62row.getCell(34);
			if (R62cell32 != null) {
				R62cell32.setCellValue(brf94c.getR62_amount_trade_corporate() == null ? 0
						: brf94c.getR62_amount_trade_corporate().intValue());
			}
			Cell R62cell33 = R62row.getCell(35);
			if (R62cell33 != null) {
				R62cell33.setCellValue(brf94c.getR62_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR62_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R62cell34 = R62row.getCell(36);
			if (R62cell34 != null) {
				R62cell34.setCellValue(brf94c.getR62_amount_financial_investment_sme() == null ? 0
						: brf94c.getR62_amount_financial_investment_sme().intValue());
			}
			Cell R62cell35 = R62row.getCell(37);
			if (R62cell35 != null) {
				R62cell35.setCellValue(brf94c.getR62_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR62_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R62cell36 = R62row.getCell(38);
			if (R62cell36 != null) {
				R62cell36.setCellValue(brf94c.getR62_amount_direct_investment_sme() == null ? 0
						: brf94c.getR62_amount_direct_investment_sme().intValue());
			}
			Cell R62cell37 = R62row.getCell(39);
			if (R62cell37 != null) {
				R62cell37.setCellValue(brf94c.getR62_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR62_no_of_transactions_services_sme().intValue());
			}
			Cell R62cell38 = R62row.getCell(40);
			if (R62cell38 != null) {
				R62cell38.setCellValue(brf94c.getR62_amount_services_sme() == null ? 0
						: brf94c.getR62_amount_services_sme().intValue());
			}
			Cell R62cell39 = R62row.getCell(41);
			if (R62cell39 != null) {
				R62cell39.setCellValue(brf94c.getR62_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR62_no_of_transactions_trade_sme().intValue());
			}
			Cell R62cell40 = R62row.getCell(42);
			if (R62cell40 != null) {
				R62cell40.setCellValue(
						brf94c.getR62_amount_trade_sme() == null ? 0 : brf94c.getR62_amount_trade_sme().intValue());
			}
			Cell R62cell41 = R62row.getCell(43);
			if (R62cell41 != null) {
				R62cell41.setCellValue(brf94c.getR62_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R62cell42 = R62row.getCell(44);
			if (R62cell42 != null) {
				R62cell42.setCellValue(brf94c.getR62_amount_financial_investment_individual() == null ? 0
						: brf94c.getR62_amount_financial_investment_individual().intValue());
			}
			Cell R62cell43 = R62row.getCell(45);
			if (R62cell43 != null) {
				R62cell43.setCellValue(brf94c.getR62_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R62cell44 = R62row.getCell(46);
			if (R62cell44 != null) {
				R62cell44.setCellValue(brf94c.getR62_amount_direct_investment_individual() == null ? 0
						: brf94c.getR62_amount_direct_investment_individual().intValue());
			}
			Cell R62cell45 = R62row.getCell(47);
			if (R62cell45 != null) {
				R62cell45.setCellValue(brf94c.getR62_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_family_support_individual().intValue());
			}
			Cell R62cell46 = R62row.getCell(48);
			if (R62cell46 != null) {
				R62cell46.setCellValue(brf94c.getR62_amount_family_support_individual() == null ? 0
						: brf94c.getR62_amount_family_support_individual().intValue());
			}
			Cell R62cell47 = R62row.getCell(49);
			if (R62cell47 != null) {
				R62cell47.setCellValue(brf94c.getR62_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_education_individual().intValue());
			}
			Cell R62cell48 = R62row.getCell(50);
			if (R62cell48 != null) {
				R62cell48.setCellValue(brf94c.getR62_amount_education_individual() == null ? 0
						: brf94c.getR62_amount_education_individual().intValue());
			}
			Cell R62cell49 = R62row.getCell(51);
			if (R62cell49 != null) {
				R62cell49.setCellValue(brf94c.getR62_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_medical_individual().intValue());
			}

			Cell R62cell50 = R62row.getCell(52);
			if (R62cell50 != null) {
				R62cell50.setCellValue(brf94c.getR62_amount_medical_individual() == null ? 0
						: brf94c.getR62_amount_medical_individual().intValue());
			}
			Cell R62cell51 = R62row.getCell(53);
			if (R62cell51 != null) {
				R62cell51.setCellValue(brf94c.getR62_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_tourism_individual().intValue());
			}
			Cell R62cell52 = R62row.getCell(54);
			if (R62cell52 != null) {
				R62cell52.setCellValue(brf94c.getR62_amount_tourism_individual() == null ? 0
						: brf94c.getR62_amount_tourism_individual().intValue());
			}
			Cell R62cell53 = R62row.getCell(55);
			if (R62cell53 != null) {
				R62cell53.setCellValue(brf94c.getR62_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R62cell54 = R62row.getCell(56);
			if (R62cell54 != null) {
				R62cell54.setCellValue(brf94c.getR62_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR62_amount_debt_settlement_individual().intValue());
			}
			Cell R62cell55 = R62row.getCell(57);
			if (R62cell55 != null) {
				R62cell55.setCellValue(brf94c.getR62_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR62_no_of_transactions_other_services_individual().intValue());
			}

			Cell R62cell56 = R62row.getCell(58);
			if (R62cell56 != null) {
				R62cell56.setCellValue(brf94c.getR62_amount_other_services_individual() == null ? 0
						: brf94c.getR62_amount_other_services_individual().intValue());
			}

			Row R63row = sheet.getRow(71);
			Cell R63cell1 = R63row.getCell(3);
			if (R63cell1 != null) {
				R63cell1.setCellValue(brf94c.getR63_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR63_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R63cell2 = R63row.getCell(4);
			if (R63cell2 != null) {
				R63cell2.setCellValue(brf94c.getR63_amount_financial_investment_government() == null ? 0
						: brf94c.getR63_amount_financial_investment_government().intValue());
			}
			Cell R63cell3 = R63row.getCell(5);
			if (R63cell3 != null) {
				R63cell3.setCellValue(brf94c.getR63_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR63_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R63cell4 = R63row.getCell(6);
			if (R63cell4 != null) {
				R63cell4.setCellValue(brf94c.getR63_amount_direct_investment_government() == null ? 0
						: brf94c.getR63_amount_direct_investment_government().intValue());
			}
			Cell R63cell5 = R63row.getCell(7);
			if (R63cell5 != null) {
				R63cell5.setCellValue(brf94c.getR63_no_of_transactions_services_government() == null ? 0
						: brf94c.getR63_no_of_transactions_services_government().intValue());
			}
			Cell R63cell6 = R63row.getCell(8);
			if (R63cell6 != null) {
				R63cell6.setCellValue(brf94c.getR63_amount_services_government() == null ? 0
						: brf94c.getR63_amount_services_government().intValue());
			}
			Cell R63cell7 = R63row.getCell(9);
			if (R63cell7 != null) {
				R63cell7.setCellValue(brf94c.getR63_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR63_no_of_transactions_trade_government().intValue());
			}
			Cell R63cell8 = R63row.getCell(10);
			if (R63cell8 != null) {
				R63cell8.setCellValue(brf94c.getR63_amount_trade_government() == null ? 0
						: brf94c.getR63_amount_trade_government().intValue());
			}
			Cell R63cell9 = R63row.getCell(11);
			if (R63cell9 != null) {
				R63cell9.setCellValue(brf94c.getR63_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR63_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R63cell10 = R63row.getCell(12);
			if (R63cell10 != null) {
				R63cell10.setCellValue(brf94c.getR63_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR63_amount_financial_investment_reserve().intValue());
			}
			Cell R63cell11 = R63row.getCell(13);
			if (R63cell11 != null) {
				R63cell11.setCellValue(brf94c.getR63_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR63_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R63cell12 = R63row.getCell(14);
			if (R63cell12 != null) {
				R63cell12.setCellValue(brf94c.getR63_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR63_amount_direct_investment_reserve().intValue());
			}
			Cell R63cell13 = R63row.getCell(15);
			if (R63cell13 != null) {
				R63cell13.setCellValue(brf94c.getR63_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR63_no_of_transactions_services_reserve().intValue());
			}
			Cell R63cell14 = R63row.getCell(16);
			if (R63cell14 != null) {
				R63cell14.setCellValue(brf94c.getR63_amount_services_reserve() == null ? 0
						: brf94c.getR63_amount_services_reserve().intValue());
			}
			Cell R63cell15 = R63row.getCell(17);
			if (R63cell15 != null) {
				R63cell15.setCellValue(brf94c.getR63_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR63_no_of_transactions_trade_reserve().intValue());
			}
			Cell R63cell16 = R63row.getCell(18);
			if (R63cell16 != null) {
				R63cell16.setCellValue(brf94c.getR63_amount_trade_reserve() == null ? 0
						: brf94c.getR63_amount_trade_reserve().intValue());
			}
			Cell R63cell17 = R63row.getCell(19);
			if (R63cell17 != null) {
				R63cell17.setCellValue(brf94c.getR63_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR63_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R63cell18 = R63row.getCell(20);
			if (R63cell18 != null) {
				R63cell18.setCellValue(brf94c.getR63_amount_financial_investment_gre() == null ? 0
						: brf94c.getR63_amount_financial_investment_gre().intValue());
			}
			Cell R63cell19 = R63row.getCell(21);
			if (R63cell19 != null) {
				R63cell19.setCellValue(brf94c.getR63_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR63_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R63cell20 = R63row.getCell(22);
			if (R63cell20 != null) {
				R63cell20.setCellValue(brf94c.getR63_amount_direct_investment_gre() == null ? 0
						: brf94c.getR63_amount_direct_investment_gre().intValue());
			}
			Cell R63cell21 = R63row.getCell(23);
			if (R63cell21 != null) {
				R63cell21.setCellValue(brf94c.getR63_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR63_no_of_transactions_services_gre().intValue());
			}
			Cell R63cell22 = R63row.getCell(24);
			if (R63cell22 != null) {
				R63cell22.setCellValue(brf94c.getR63_amount_services_gre() == null ? 0
						: brf94c.getR63_amount_services_gre().intValue());
			}
			Cell R63cell23 = R63row.getCell(25);
			if (R63cell23 != null) {
				R63cell23.setCellValue(brf94c.getR63_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR63_no_of_transactions_trade_gre().intValue());
			}
			Cell R63cell24 = R63row.getCell(26);
			if (R63cell24 != null) {
				R63cell24.setCellValue(
						brf94c.getR63_amount_trade_gre() == null ? 0 : brf94c.getR63_amount_trade_gre().intValue());
			}
			Cell R63cell25 = R63row.getCell(27);
			if (R63cell25 != null) {
				R63cell25.setCellValue(brf94c.getR63_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR63_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R63cell26 = R63row.getCell(28);
			if (R63cell26 != null) {
				R63cell26.setCellValue(brf94c.getR63_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR63_amount_financial_investment_corporate().intValue());
			}
			Cell R63cell27 = R63row.getCell(29);
			if (R63cell27 != null) {
				R63cell27.setCellValue(brf94c.getR63_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR63_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R63cell28 = R63row.getCell(30);
			if (R63cell28 != null) {
				R63cell28.setCellValue(brf94c.getR63_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR63_amount_direct_investment_corporate().intValue());
			}
			Cell R63cell29 = R63row.getCell(31);
			if (R63cell29 != null) {
				R63cell29.setCellValue(brf94c.getR63_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR63_no_of_transactions_services_corporate().intValue());
			}
			Cell R63cell30 = R63row.getCell(32);
			if (R63cell30 != null) {
				R63cell30.setCellValue(brf94c.getR63_amount_services_corporate() == null ? 0
						: brf94c.getR63_amount_services_corporate().intValue());
			}
			Cell R63cell31 = R63row.getCell(33);
			if (R63cell31 != null) {
				R63cell31.setCellValue(brf94c.getR63_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR63_no_of_transactions_trade_corporate().intValue());
			}
			Cell R63cell32 = R63row.getCell(34);
			if (R63cell32 != null) {
				R63cell32.setCellValue(brf94c.getR63_amount_trade_corporate() == null ? 0
						: brf94c.getR63_amount_trade_corporate().intValue());
			}
			Cell R63cell33 = R63row.getCell(35);
			if (R63cell33 != null) {
				R63cell33.setCellValue(brf94c.getR63_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR63_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R63cell34 = R63row.getCell(36);
			if (R63cell34 != null) {
				R63cell34.setCellValue(brf94c.getR63_amount_financial_investment_sme() == null ? 0
						: brf94c.getR63_amount_financial_investment_sme().intValue());
			}
			Cell R63cell35 = R63row.getCell(37);
			if (R63cell35 != null) {
				R63cell35.setCellValue(brf94c.getR63_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR63_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R63cell36 = R63row.getCell(38);
			if (R63cell36 != null) {
				R63cell36.setCellValue(brf94c.getR63_amount_direct_investment_sme() == null ? 0
						: brf94c.getR63_amount_direct_investment_sme().intValue());
			}
			Cell R63cell37 = R63row.getCell(39);
			if (R63cell37 != null) {
				R63cell37.setCellValue(brf94c.getR63_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR63_no_of_transactions_services_sme().intValue());
			}
			Cell R63cell38 = R63row.getCell(40);
			if (R63cell38 != null) {
				R63cell38.setCellValue(brf94c.getR63_amount_services_sme() == null ? 0
						: brf94c.getR63_amount_services_sme().intValue());
			}
			Cell R63cell39 = R63row.getCell(41);
			if (R63cell39 != null) {
				R63cell39.setCellValue(brf94c.getR63_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR63_no_of_transactions_trade_sme().intValue());
			}
			Cell R63cell40 = R63row.getCell(42);
			if (R63cell40 != null) {
				R63cell40.setCellValue(
						brf94c.getR63_amount_trade_sme() == null ? 0 : brf94c.getR63_amount_trade_sme().intValue());
			}
			Cell R63cell41 = R63row.getCell(43);
			if (R63cell41 != null) {
				R63cell41.setCellValue(brf94c.getR63_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R63cell42 = R63row.getCell(44);
			if (R63cell42 != null) {
				R63cell42.setCellValue(brf94c.getR63_amount_financial_investment_individual() == null ? 0
						: brf94c.getR63_amount_financial_investment_individual().intValue());
			}
			Cell R63cell43 = R63row.getCell(45);
			if (R63cell43 != null) {
				R63cell43.setCellValue(brf94c.getR63_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R63cell44 = R63row.getCell(46);
			if (R63cell44 != null) {
				R63cell44.setCellValue(brf94c.getR63_amount_direct_investment_individual() == null ? 0
						: brf94c.getR63_amount_direct_investment_individual().intValue());
			}
			Cell R63cell45 = R63row.getCell(47);
			if (R63cell45 != null) {
				R63cell45.setCellValue(brf94c.getR63_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_family_support_individual().intValue());
			}
			Cell R63cell46 = R63row.getCell(48);
			if (R63cell46 != null) {
				R63cell46.setCellValue(brf94c.getR63_amount_family_support_individual() == null ? 0
						: brf94c.getR63_amount_family_support_individual().intValue());
			}
			Cell R63cell47 = R63row.getCell(49);
			if (R63cell47 != null) {
				R63cell47.setCellValue(brf94c.getR63_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_education_individual().intValue());
			}
			Cell R63cell48 = R63row.getCell(50);
			if (R63cell48 != null) {
				R63cell48.setCellValue(brf94c.getR63_amount_education_individual() == null ? 0
						: brf94c.getR63_amount_education_individual().intValue());
			}
			Cell R63cell49 = R63row.getCell(51);
			if (R63cell49 != null) {
				R63cell49.setCellValue(brf94c.getR63_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_medical_individual().intValue());
			}

			Cell R63cell50 = R63row.getCell(52);
			if (R63cell50 != null) {
				R63cell50.setCellValue(brf94c.getR63_amount_medical_individual() == null ? 0
						: brf94c.getR63_amount_medical_individual().intValue());
			}
			Cell R63cell51 = R63row.getCell(53);
			if (R63cell51 != null) {
				R63cell51.setCellValue(brf94c.getR63_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_tourism_individual().intValue());
			}
			Cell R63cell52 = R63row.getCell(54);
			if (R63cell52 != null) {
				R63cell52.setCellValue(brf94c.getR63_amount_tourism_individual() == null ? 0
						: brf94c.getR63_amount_tourism_individual().intValue());
			}
			Cell R63cell53 = R63row.getCell(55);
			if (R63cell53 != null) {
				R63cell53.setCellValue(brf94c.getR63_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R63cell54 = R63row.getCell(56);
			if (R63cell54 != null) {
				R63cell54.setCellValue(brf94c.getR63_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR63_amount_debt_settlement_individual().intValue());
			}
			Cell R63cell55 = R63row.getCell(57);
			if (R63cell55 != null) {
				R63cell55.setCellValue(brf94c.getR63_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR63_no_of_transactions_other_services_individual().intValue());
			}

			Cell R63cell56 = R63row.getCell(58);
			if (R63cell56 != null) {
				R63cell56.setCellValue(brf94c.getR63_amount_other_services_individual() == null ? 0
						: brf94c.getR63_amount_other_services_individual().intValue());
			}

			Row R64row = sheet.getRow(72);
			Cell R64cell1 = R64row.getCell(3);
			if (R64cell1 != null) {
				R64cell1.setCellValue(brf94c.getR64_no_of_transactions_financial_investment_government() == null ? 0
						: brf94c.getR64_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R64cell2 = R64row.getCell(4);
			if (R64cell2 != null) {
				R64cell2.setCellValue(brf94c.getR64_amount_financial_investment_government() == null ? 0
						: brf94c.getR64_amount_financial_investment_government().intValue());
			}
			Cell R64cell3 = R64row.getCell(5);
			if (R64cell3 != null) {
				R64cell3.setCellValue(brf94c.getR64_no_of_transactions_direct_investment_government() == null ? 0
						: brf94c.getR64_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R64cell4 = R64row.getCell(6);
			if (R64cell4 != null) {
				R64cell4.setCellValue(brf94c.getR64_amount_direct_investment_government() == null ? 0
						: brf94c.getR64_amount_direct_investment_government().intValue());
			}
			Cell R64cell5 = R64row.getCell(7);
			if (R64cell5 != null) {
				R64cell5.setCellValue(brf94c.getR64_no_of_transactions_services_government() == null ? 0
						: brf94c.getR64_no_of_transactions_services_government().intValue());
			}
			Cell R64cell6 = R64row.getCell(8);
			if (R64cell6 != null) {
				R64cell6.setCellValue(brf94c.getR64_amount_services_government() == null ? 0
						: brf94c.getR64_amount_services_government().intValue());
			}
			Cell R64cell7 = R64row.getCell(9);
			if (R64cell7 != null) {
				R64cell7.setCellValue(brf94c.getR64_no_of_transactions_trade_government() == null ? 0
						: brf94c.getR64_no_of_transactions_trade_government().intValue());
			}
			Cell R64cell8 = R64row.getCell(10);
			if (R64cell8 != null) {
				R64cell8.setCellValue(brf94c.getR64_amount_trade_government() == null ? 0
						: brf94c.getR64_amount_trade_government().intValue());
			}
			Cell R64cell9 = R64row.getCell(11);
			if (R64cell9 != null) {
				R64cell9.setCellValue(brf94c.getR64_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94c.getR64_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R64cell10 = R64row.getCell(12);
			if (R64cell10 != null) {
				R64cell10.setCellValue(brf94c.getR64_amount_financial_investment_reserve() == null ? 0
						: brf94c.getR64_amount_financial_investment_reserve().intValue());
			}
			Cell R64cell11 = R64row.getCell(13);
			if (R64cell11 != null) {
				R64cell11.setCellValue(brf94c.getR64_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94c.getR64_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R64cell12 = R64row.getCell(14);
			if (R64cell12 != null) {
				R64cell12.setCellValue(brf94c.getR64_amount_direct_investment_reserve() == null ? 0
						: brf94c.getR64_amount_direct_investment_reserve().intValue());
			}
			Cell R64cell13 = R64row.getCell(15);
			if (R64cell13 != null) {
				R64cell13.setCellValue(brf94c.getR64_no_of_transactions_services_reserve() == null ? 0
						: brf94c.getR64_no_of_transactions_services_reserve().intValue());
			}
			Cell R64cell14 = R64row.getCell(16);
			if (R64cell14 != null) {
				R64cell14.setCellValue(brf94c.getR64_amount_services_reserve() == null ? 0
						: brf94c.getR64_amount_services_reserve().intValue());
			}
			Cell R64cell15 = R64row.getCell(17);
			if (R64cell15 != null) {
				R64cell15.setCellValue(brf94c.getR64_no_of_transactions_trade_reserve() == null ? 0
						: brf94c.getR64_no_of_transactions_trade_reserve().intValue());
			}
			Cell R64cell16 = R64row.getCell(18);
			if (R64cell16 != null) {
				R64cell16.setCellValue(brf94c.getR64_amount_trade_reserve() == null ? 0
						: brf94c.getR64_amount_trade_reserve().intValue());
			}
			Cell R64cell17 = R64row.getCell(19);
			if (R64cell17 != null) {
				R64cell17.setCellValue(brf94c.getR64_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94c.getR64_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R64cell18 = R64row.getCell(20);
			if (R64cell18 != null) {
				R64cell18.setCellValue(brf94c.getR64_amount_financial_investment_gre() == null ? 0
						: brf94c.getR64_amount_financial_investment_gre().intValue());
			}
			Cell R64cell19 = R64row.getCell(21);
			if (R64cell19 != null) {
				R64cell19.setCellValue(brf94c.getR64_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94c.getR64_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R64cell20 = R64row.getCell(22);
			if (R64cell20 != null) {
				R64cell20.setCellValue(brf94c.getR64_amount_direct_investment_gre() == null ? 0
						: brf94c.getR64_amount_direct_investment_gre().intValue());
			}
			Cell R64cell21 = R64row.getCell(23);
			if (R64cell21 != null) {
				R64cell21.setCellValue(brf94c.getR64_no_of_transactions_services_gre() == null ? 0
						: brf94c.getR64_no_of_transactions_services_gre().intValue());
			}
			Cell R64cell22 = R64row.getCell(24);
			if (R64cell22 != null) {
				R64cell22.setCellValue(brf94c.getR64_amount_services_gre() == null ? 0
						: brf94c.getR64_amount_services_gre().intValue());
			}
			Cell R64cell23 = R64row.getCell(25);
			if (R64cell23 != null) {
				R64cell23.setCellValue(brf94c.getR64_no_of_transactions_trade_gre() == null ? 0
						: brf94c.getR64_no_of_transactions_trade_gre().intValue());
			}
			Cell R64cell24 = R64row.getCell(26);
			if (R64cell24 != null) {
				R64cell24.setCellValue(
						brf94c.getR64_amount_trade_gre() == null ? 0 : brf94c.getR64_amount_trade_gre().intValue());
			}
			Cell R64cell25 = R64row.getCell(27);
			if (R64cell25 != null) {
				R64cell25.setCellValue(brf94c.getR64_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94c.getR64_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R64cell26 = R64row.getCell(28);
			if (R64cell26 != null) {
				R64cell26.setCellValue(brf94c.getR64_amount_financial_investment_corporate() == null ? 0
						: brf94c.getR64_amount_financial_investment_corporate().intValue());
			}
			Cell R64cell27 = R64row.getCell(29);
			if (R64cell27 != null) {
				R64cell27.setCellValue(brf94c.getR64_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94c.getR64_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R64cell28 = R64row.getCell(30);
			if (R64cell28 != null) {
				R64cell28.setCellValue(brf94c.getR64_amount_direct_investment_corporate() == null ? 0
						: brf94c.getR64_amount_direct_investment_corporate().intValue());
			}
			Cell R64cell29 = R64row.getCell(31);
			if (R64cell29 != null) {
				R64cell29.setCellValue(brf94c.getR64_no_of_transactions_services_corporate() == null ? 0
						: brf94c.getR64_no_of_transactions_services_corporate().intValue());
			}
			Cell R64cell30 = R64row.getCell(32);
			if (R64cell30 != null) {
				R64cell30.setCellValue(brf94c.getR64_amount_services_corporate() == null ? 0
						: brf94c.getR64_amount_services_corporate().intValue());
			}
			Cell R64cell31 = R64row.getCell(33);
			if (R64cell31 != null) {
				R64cell31.setCellValue(brf94c.getR64_no_of_transactions_trade_corporate() == null ? 0
						: brf94c.getR64_no_of_transactions_trade_corporate().intValue());
			}
			Cell R64cell32 = R64row.getCell(34);
			if (R64cell32 != null) {
				R64cell32.setCellValue(brf94c.getR64_amount_trade_corporate() == null ? 0
						: brf94c.getR64_amount_trade_corporate().intValue());
			}
			Cell R64cell33 = R64row.getCell(35);
			if (R64cell33 != null) {
				R64cell33.setCellValue(brf94c.getR64_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94c.getR64_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R64cell34 = R64row.getCell(36);
			if (R64cell34 != null) {
				R64cell34.setCellValue(brf94c.getR64_amount_financial_investment_sme() == null ? 0
						: brf94c.getR64_amount_financial_investment_sme().intValue());
			}
			Cell R64cell35 = R64row.getCell(37);
			if (R64cell35 != null) {
				R64cell35.setCellValue(brf94c.getR64_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94c.getR64_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R64cell36 = R64row.getCell(38);
			if (R64cell36 != null) {
				R64cell36.setCellValue(brf94c.getR64_amount_direct_investment_sme() == null ? 0
						: brf94c.getR64_amount_direct_investment_sme().intValue());
			}
			Cell R64cell37 = R64row.getCell(39);
			if (R64cell37 != null) {
				R64cell37.setCellValue(brf94c.getR64_no_of_transactions_services_sme() == null ? 0
						: brf94c.getR64_no_of_transactions_services_sme().intValue());
			}
			Cell R64cell38 = R64row.getCell(40);
			if (R64cell38 != null) {
				R64cell38.setCellValue(brf94c.getR64_amount_services_sme() == null ? 0
						: brf94c.getR64_amount_services_sme().intValue());
			}
			Cell R64cell39 = R64row.getCell(41);
			if (R64cell39 != null) {
				R64cell39.setCellValue(brf94c.getR64_no_of_transactions_trade_sme() == null ? 0
						: brf94c.getR64_no_of_transactions_trade_sme().intValue());
			}
			Cell R64cell40 = R64row.getCell(42);
			if (R64cell40 != null) {
				R64cell40.setCellValue(
						brf94c.getR64_amount_trade_sme() == null ? 0 : brf94c.getR64_amount_trade_sme().intValue());
			}
			Cell R64cell41 = R64row.getCell(43);
			if (R64cell41 != null) {
				R64cell41.setCellValue(brf94c.getR64_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R64cell42 = R64row.getCell(44);
			if (R64cell42 != null) {
				R64cell42.setCellValue(brf94c.getR64_amount_financial_investment_individual() == null ? 0
						: brf94c.getR64_amount_financial_investment_individual().intValue());
			}
			Cell R64cell43 = R64row.getCell(45);
			if (R64cell43 != null) {
				R64cell43.setCellValue(brf94c.getR64_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R64cell44 = R64row.getCell(46);
			if (R64cell44 != null) {
				R64cell44.setCellValue(brf94c.getR64_amount_direct_investment_individual() == null ? 0
						: brf94c.getR64_amount_direct_investment_individual().intValue());
			}
			Cell R64cell45 = R64row.getCell(47);
			if (R64cell45 != null) {
				R64cell45.setCellValue(brf94c.getR64_no_of_transactions_family_support_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_family_support_individual().intValue());
			}
			Cell R64cell46 = R64row.getCell(48);
			if (R64cell46 != null) {
				R64cell46.setCellValue(brf94c.getR64_amount_family_support_individual() == null ? 0
						: brf94c.getR64_amount_family_support_individual().intValue());
			}
			Cell R64cell47 = R64row.getCell(49);
			if (R64cell47 != null) {
				R64cell47.setCellValue(brf94c.getR64_no_of_transactions_education_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_education_individual().intValue());
			}
			Cell R64cell48 = R64row.getCell(50);
			if (R64cell48 != null) {
				R64cell48.setCellValue(brf94c.getR64_amount_education_individual() == null ? 0
						: brf94c.getR64_amount_education_individual().intValue());
			}
			Cell R64cell49 = R64row.getCell(51);
			if (R64cell49 != null) {
				R64cell49.setCellValue(brf94c.getR64_no_of_transactions_medical_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_medical_individual().intValue());
			}

			Cell R64cell50 = R64row.getCell(52);
			if (R64cell50 != null) {
				R64cell50.setCellValue(brf94c.getR64_amount_medical_individual() == null ? 0
						: brf94c.getR64_amount_medical_individual().intValue());
			}
			Cell R64cell51 = R64row.getCell(53);
			if (R64cell51 != null) {
				R64cell51.setCellValue(brf94c.getR64_no_of_transactions_tourism_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_tourism_individual().intValue());
			}
			Cell R64cell52 = R64row.getCell(54);
			if (R64cell52 != null) {
				R64cell52.setCellValue(brf94c.getR64_amount_tourism_individual() == null ? 0
						: brf94c.getR64_amount_tourism_individual().intValue());
			}
			Cell R64cell53 = R64row.getCell(55);
			if (R64cell53 != null) {
				R64cell53.setCellValue(brf94c.getR64_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R64cell54 = R64row.getCell(56);
			if (R64cell54 != null) {
				R64cell54.setCellValue(brf94c.getR64_amount_debt_settlement_individual() == null ? 0
						: brf94c.getR64_amount_debt_settlement_individual().intValue());
			}
			Cell R64cell55 = R64row.getCell(57);
			if (R64cell55 != null) {
				R64cell55.setCellValue(brf94c.getR64_no_of_transactions_other_services_individual() == null ? 0
						: brf94c.getR64_no_of_transactions_other_services_individual().intValue());
			}

			Cell R64cell56 = R64row.getCell(58);
			if (R64cell56 != null) {
				R64cell56.setCellValue(brf94c.getR64_amount_other_services_individual() == null ? 0
						: brf94c.getR64_amount_other_services_individual().intValue());
			}

		}

	}

	public void updateSheetWithEntity5Data(Sheet sheet, List<BRF094_SUMMARYENTITY5> BRF094_SUMMARYENTITY5) {
		if (BRF094_SUMMARYENTITY5.size() == 1) {
			BRF094_SUMMARYENTITY5 brf94d = BRF094_SUMMARYENTITY5.get(0);
			Row R65row = sheet.getRow(73);
			Cell R65cell1 = R65row.getCell(3);
			if (R65cell1 != null) {
				R65cell1.setCellValue(brf94d.getR65_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR65_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R65cell2 = R65row.getCell(4);
			if (R65cell2 != null) {
				R65cell2.setCellValue(brf94d.getR65_amount_financial_investment_government() == null ? 0
						: brf94d.getR65_amount_financial_investment_government().intValue());
			}
			Cell R65cell3 = R65row.getCell(5);
			if (R65cell3 != null) {
				R65cell3.setCellValue(brf94d.getR65_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR65_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R65cell4 = R65row.getCell(6);
			if (R65cell4 != null) {
				R65cell4.setCellValue(brf94d.getR65_amount_direct_investment_government() == null ? 0
						: brf94d.getR65_amount_direct_investment_government().intValue());
			}
			Cell R65cell5 = R65row.getCell(7);
			if (R65cell5 != null) {
				R65cell5.setCellValue(brf94d.getR65_no_of_transactions_services_government() == null ? 0
						: brf94d.getR65_no_of_transactions_services_government().intValue());
			}
			Cell R65cell6 = R65row.getCell(8);
			if (R65cell6 != null) {
				R65cell6.setCellValue(brf94d.getR65_amount_services_government() == null ? 0
						: brf94d.getR65_amount_services_government().intValue());
			}
			Cell R65cell7 = R65row.getCell(9);
			if (R65cell7 != null) {
				R65cell7.setCellValue(brf94d.getR65_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR65_no_of_transactions_trade_government().intValue());
			}
			Cell R65cell8 = R65row.getCell(10);
			if (R65cell8 != null) {
				R65cell8.setCellValue(brf94d.getR65_amount_trade_government() == null ? 0
						: brf94d.getR65_amount_trade_government().intValue());
			}
			Cell R65cell9 = R65row.getCell(11);
			if (R65cell9 != null) {
				R65cell9.setCellValue(brf94d.getR65_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR65_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R65cell10 = R65row.getCell(12);
			if (R65cell10 != null) {
				R65cell10.setCellValue(brf94d.getR65_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR65_amount_financial_investment_reserve().intValue());
			}
			Cell R65cell11 = R65row.getCell(13);
			if (R65cell11 != null) {
				R65cell11.setCellValue(brf94d.getR65_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR65_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R65cell12 = R65row.getCell(14);
			if (R65cell12 != null) {
				R65cell12.setCellValue(brf94d.getR65_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR65_amount_direct_investment_reserve().intValue());
			}
			Cell R65cell13 = R65row.getCell(15);
			if (R65cell13 != null) {
				R65cell13.setCellValue(brf94d.getR65_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR65_no_of_transactions_services_reserve().intValue());
			}
			Cell R65cell14 = R65row.getCell(16);
			if (R65cell14 != null) {
				R65cell14.setCellValue(brf94d.getR65_amount_services_reserve() == null ? 0
						: brf94d.getR65_amount_services_reserve().intValue());
			}
			Cell R65cell15 = R65row.getCell(17);
			if (R65cell15 != null) {
				R65cell15.setCellValue(brf94d.getR65_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR65_no_of_transactions_trade_reserve().intValue());
			}
			Cell R65cell16 = R65row.getCell(18);
			if (R65cell16 != null) {
				R65cell16.setCellValue(brf94d.getR65_amount_trade_reserve() == null ? 0
						: brf94d.getR65_amount_trade_reserve().intValue());
			}
			Cell R65cell17 = R65row.getCell(19);
			if (R65cell17 != null) {
				R65cell17.setCellValue(brf94d.getR65_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR65_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R65cell18 = R65row.getCell(20);
			if (R65cell18 != null) {
				R65cell18.setCellValue(brf94d.getR65_amount_financial_investment_gre() == null ? 0
						: brf94d.getR65_amount_financial_investment_gre().intValue());
			}
			Cell R65cell19 = R65row.getCell(21);
			if (R65cell19 != null) {
				R65cell19.setCellValue(brf94d.getR65_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR65_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R65cell20 = R65row.getCell(22);
			if (R65cell20 != null) {
				R65cell20.setCellValue(brf94d.getR65_amount_direct_investment_gre() == null ? 0
						: brf94d.getR65_amount_direct_investment_gre().intValue());
			}
			Cell R65cell21 = R65row.getCell(23);
			if (R65cell21 != null) {
				R65cell21.setCellValue(brf94d.getR65_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR65_no_of_transactions_services_gre().intValue());
			}
			Cell R65cell22 = R65row.getCell(24);
			if (R65cell22 != null) {
				R65cell22.setCellValue(brf94d.getR65_amount_services_gre() == null ? 0
						: brf94d.getR65_amount_services_gre().intValue());
			}
			Cell R65cell23 = R65row.getCell(25);
			if (R65cell23 != null) {
				R65cell23.setCellValue(brf94d.getR65_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR65_no_of_transactions_trade_gre().intValue());
			}
			Cell R65cell24 = R65row.getCell(26);
			if (R65cell24 != null) {
				R65cell24.setCellValue(
						brf94d.getR65_amount_trade_gre() == null ? 0 : brf94d.getR65_amount_trade_gre().intValue());
			}
			Cell R65cell25 = R65row.getCell(27);
			if (R65cell25 != null) {
				R65cell25.setCellValue(brf94d.getR65_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR65_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R65cell26 = R65row.getCell(28);
			if (R65cell26 != null) {
				R65cell26.setCellValue(brf94d.getR65_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR65_amount_financial_investment_corporate().intValue());
			}
			Cell R65cell27 = R65row.getCell(29);
			if (R65cell27 != null) {
				R65cell27.setCellValue(brf94d.getR65_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR65_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R65cell28 = R65row.getCell(30);
			if (R65cell28 != null) {
				R65cell28.setCellValue(brf94d.getR65_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR65_amount_direct_investment_corporate().intValue());
			}
			Cell R65cell29 = R65row.getCell(31);
			if (R65cell29 != null) {
				R65cell29.setCellValue(brf94d.getR65_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR65_no_of_transactions_services_corporate().intValue());
			}
			Cell R65cell30 = R65row.getCell(32);
			if (R65cell30 != null) {
				R65cell30.setCellValue(brf94d.getR65_amount_services_corporate() == null ? 0
						: brf94d.getR65_amount_services_corporate().intValue());
			}
			Cell R65cell31 = R65row.getCell(33);
			if (R65cell31 != null) {
				R65cell31.setCellValue(brf94d.getR65_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR65_no_of_transactions_trade_corporate().intValue());
			}
			Cell R65cell32 = R65row.getCell(34);
			if (R65cell32 != null) {
				R65cell32.setCellValue(brf94d.getR65_amount_trade_corporate() == null ? 0
						: brf94d.getR65_amount_trade_corporate().intValue());
			}
			Cell R65cell33 = R65row.getCell(35);
			if (R65cell33 != null) {
				R65cell33.setCellValue(brf94d.getR65_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR65_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R65cell34 = R65row.getCell(36);
			if (R65cell34 != null) {
				R65cell34.setCellValue(brf94d.getR65_amount_financial_investment_sme() == null ? 0
						: brf94d.getR65_amount_financial_investment_sme().intValue());
			}
			Cell R65cell35 = R65row.getCell(37);
			if (R65cell35 != null) {
				R65cell35.setCellValue(brf94d.getR65_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR65_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R65cell36 = R65row.getCell(38);
			if (R65cell36 != null) {
				R65cell36.setCellValue(brf94d.getR65_amount_direct_investment_sme() == null ? 0
						: brf94d.getR65_amount_direct_investment_sme().intValue());
			}
			Cell R65cell37 = R65row.getCell(39);
			if (R65cell37 != null) {
				R65cell37.setCellValue(brf94d.getR65_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR65_no_of_transactions_services_sme().intValue());
			}
			Cell R65cell38 = R65row.getCell(40);
			if (R65cell38 != null) {
				R65cell38.setCellValue(brf94d.getR65_amount_services_sme() == null ? 0
						: brf94d.getR65_amount_services_sme().intValue());
			}
			Cell R65cell39 = R65row.getCell(41);
			if (R65cell39 != null) {
				R65cell39.setCellValue(brf94d.getR65_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR65_no_of_transactions_trade_sme().intValue());
			}
			Cell R65cell40 = R65row.getCell(42);
			if (R65cell40 != null) {
				R65cell40.setCellValue(
						brf94d.getR65_amount_trade_sme() == null ? 0 : brf94d.getR65_amount_trade_sme().intValue());
			}
			Cell R65cell41 = R65row.getCell(43);
			if (R65cell41 != null) {
				R65cell41.setCellValue(brf94d.getR65_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R65cell42 = R65row.getCell(44);
			if (R65cell42 != null) {
				R65cell42.setCellValue(brf94d.getR65_amount_financial_investment_individual() == null ? 0
						: brf94d.getR65_amount_financial_investment_individual().intValue());
			}
			Cell R65cell43 = R65row.getCell(45);
			if (R65cell43 != null) {
				R65cell43.setCellValue(brf94d.getR65_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R65cell44 = R65row.getCell(46);
			if (R65cell44 != null) {
				R65cell44.setCellValue(brf94d.getR65_amount_direct_investment_individual() == null ? 0
						: brf94d.getR65_amount_direct_investment_individual().intValue());
			}
			Cell R65cell45 = R65row.getCell(47);
			if (R65cell45 != null) {
				R65cell45.setCellValue(brf94d.getR65_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_family_support_individual().intValue());
			}
			Cell R65cell46 = R65row.getCell(48);
			if (R65cell46 != null) {
				R65cell46.setCellValue(brf94d.getR65_amount_family_support_individual() == null ? 0
						: brf94d.getR65_amount_family_support_individual().intValue());
			}
			Cell R65cell47 = R65row.getCell(49);
			if (R65cell47 != null) {
				R65cell47.setCellValue(brf94d.getR65_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_education_individual().intValue());
			}
			Cell R65cell48 = R65row.getCell(50);
			if (R65cell48 != null) {
				R65cell48.setCellValue(brf94d.getR65_amount_education_individual() == null ? 0
						: brf94d.getR65_amount_education_individual().intValue());
			}
			Cell R65cell49 = R65row.getCell(51);
			if (R65cell49 != null) {
				R65cell49.setCellValue(brf94d.getR65_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_medical_individual().intValue());
			}

			Cell R65cell50 = R65row.getCell(52);
			if (R65cell50 != null) {
				R65cell50.setCellValue(brf94d.getR65_amount_medical_individual() == null ? 0
						: brf94d.getR65_amount_medical_individual().intValue());
			}
			Cell R65cell51 = R65row.getCell(53);
			if (R65cell51 != null) {
				R65cell51.setCellValue(brf94d.getR65_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_tourism_individual().intValue());
			}
			Cell R65cell52 = R65row.getCell(54);
			if (R65cell52 != null) {
				R65cell52.setCellValue(brf94d.getR65_amount_tourism_individual() == null ? 0
						: brf94d.getR65_amount_tourism_individual().intValue());
			}
			Cell R65cell53 = R65row.getCell(55);
			if (R65cell53 != null) {
				R65cell53.setCellValue(brf94d.getR65_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R65cell54 = R65row.getCell(56);
			if (R65cell54 != null) {
				R65cell54.setCellValue(brf94d.getR65_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR65_amount_debt_settlement_individual().intValue());
			}
			Cell R65cell55 = R65row.getCell(57);
			if (R65cell55 != null) {
				R65cell55.setCellValue(brf94d.getR65_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR65_no_of_transactions_other_services_individual().intValue());
			}

			Cell R65cell56 = R65row.getCell(58);
			if (R65cell56 != null) {
				R65cell56.setCellValue(brf94d.getR65_amount_other_services_individual() == null ? 0
						: brf94d.getR65_amount_other_services_individual().intValue());
			}

			Row R66row = sheet.getRow(74);
			Cell R66cell1 = R66row.getCell(3);
			if (R66cell1 != null) {
				R66cell1.setCellValue(brf94d.getR66_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR66_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R66cell2 = R66row.getCell(4);
			if (R66cell2 != null) {
				R66cell2.setCellValue(brf94d.getR66_amount_financial_investment_government() == null ? 0
						: brf94d.getR66_amount_financial_investment_government().intValue());
			}
			Cell R66cell3 = R66row.getCell(5);
			if (R66cell3 != null) {
				R66cell3.setCellValue(brf94d.getR66_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR66_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R66cell4 = R66row.getCell(6);
			if (R66cell4 != null) {
				R66cell4.setCellValue(brf94d.getR66_amount_direct_investment_government() == null ? 0
						: brf94d.getR66_amount_direct_investment_government().intValue());
			}
			Cell R66cell5 = R66row.getCell(7);
			if (R66cell5 != null) {
				R66cell5.setCellValue(brf94d.getR66_no_of_transactions_services_government() == null ? 0
						: brf94d.getR66_no_of_transactions_services_government().intValue());
			}
			Cell R66cell6 = R66row.getCell(8);
			if (R66cell6 != null) {
				R66cell6.setCellValue(brf94d.getR66_amount_services_government() == null ? 0
						: brf94d.getR66_amount_services_government().intValue());
			}
			Cell R66cell7 = R66row.getCell(9);
			if (R66cell7 != null) {
				R66cell7.setCellValue(brf94d.getR66_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR66_no_of_transactions_trade_government().intValue());
			}
			Cell R66cell8 = R66row.getCell(10);
			if (R66cell8 != null) {
				R66cell8.setCellValue(brf94d.getR66_amount_trade_government() == null ? 0
						: brf94d.getR66_amount_trade_government().intValue());
			}
			Cell R66cell9 = R66row.getCell(11);
			if (R66cell9 != null) {
				R66cell9.setCellValue(brf94d.getR66_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR66_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R66cell10 = R66row.getCell(12);
			if (R66cell10 != null) {
				R66cell10.setCellValue(brf94d.getR66_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR66_amount_financial_investment_reserve().intValue());
			}
			Cell R66cell11 = R66row.getCell(13);
			if (R66cell11 != null) {
				R66cell11.setCellValue(brf94d.getR66_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR66_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R66cell12 = R66row.getCell(14);
			if (R66cell12 != null) {
				R66cell12.setCellValue(brf94d.getR66_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR66_amount_direct_investment_reserve().intValue());
			}
			Cell R66cell13 = R66row.getCell(15);
			if (R66cell13 != null) {
				R66cell13.setCellValue(brf94d.getR66_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR66_no_of_transactions_services_reserve().intValue());
			}
			Cell R66cell14 = R66row.getCell(16);
			if (R66cell14 != null) {
				R66cell14.setCellValue(brf94d.getR66_amount_services_reserve() == null ? 0
						: brf94d.getR66_amount_services_reserve().intValue());
			}
			Cell R66cell15 = R66row.getCell(17);
			if (R66cell15 != null) {
				R66cell15.setCellValue(brf94d.getR66_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR66_no_of_transactions_trade_reserve().intValue());
			}
			Cell R66cell16 = R66row.getCell(18);
			if (R66cell16 != null) {
				R66cell16.setCellValue(brf94d.getR66_amount_trade_reserve() == null ? 0
						: brf94d.getR66_amount_trade_reserve().intValue());
			}
			Cell R66cell17 = R66row.getCell(19);
			if (R66cell17 != null) {
				R66cell17.setCellValue(brf94d.getR66_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR66_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R66cell18 = R66row.getCell(20);
			if (R66cell18 != null) {
				R66cell18.setCellValue(brf94d.getR66_amount_financial_investment_gre() == null ? 0
						: brf94d.getR66_amount_financial_investment_gre().intValue());
			}
			Cell R66cell19 = R66row.getCell(21);
			if (R66cell19 != null) {
				R66cell19.setCellValue(brf94d.getR66_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR66_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R66cell20 = R66row.getCell(22);
			if (R66cell20 != null) {
				R66cell20.setCellValue(brf94d.getR66_amount_direct_investment_gre() == null ? 0
						: brf94d.getR66_amount_direct_investment_gre().intValue());
			}
			Cell R66cell21 = R66row.getCell(23);
			if (R66cell21 != null) {
				R66cell21.setCellValue(brf94d.getR66_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR66_no_of_transactions_services_gre().intValue());
			}
			Cell R66cell22 = R66row.getCell(24);
			if (R66cell22 != null) {
				R66cell22.setCellValue(brf94d.getR66_amount_services_gre() == null ? 0
						: brf94d.getR66_amount_services_gre().intValue());
			}
			Cell R66cell23 = R66row.getCell(25);
			if (R66cell23 != null) {
				R66cell23.setCellValue(brf94d.getR66_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR66_no_of_transactions_trade_gre().intValue());
			}
			Cell R66cell24 = R66row.getCell(26);
			if (R66cell24 != null) {
				R66cell24.setCellValue(
						brf94d.getR66_amount_trade_gre() == null ? 0 : brf94d.getR66_amount_trade_gre().intValue());
			}
			Cell R66cell25 = R66row.getCell(27);
			if (R66cell25 != null) {
				R66cell25.setCellValue(brf94d.getR66_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR66_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R66cell26 = R66row.getCell(28);
			if (R66cell26 != null) {
				R66cell26.setCellValue(brf94d.getR66_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR66_amount_financial_investment_corporate().intValue());
			}
			Cell R66cell27 = R66row.getCell(29);
			if (R66cell27 != null) {
				R66cell27.setCellValue(brf94d.getR66_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR66_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R66cell28 = R66row.getCell(30);
			if (R66cell28 != null) {
				R66cell28.setCellValue(brf94d.getR66_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR66_amount_direct_investment_corporate().intValue());
			}
			Cell R66cell29 = R66row.getCell(31);
			if (R66cell29 != null) {
				R66cell29.setCellValue(brf94d.getR66_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR66_no_of_transactions_services_corporate().intValue());
			}
			Cell R66cell30 = R66row.getCell(32);
			if (R66cell30 != null) {
				R66cell30.setCellValue(brf94d.getR66_amount_services_corporate() == null ? 0
						: brf94d.getR66_amount_services_corporate().intValue());
			}
			Cell R66cell31 = R66row.getCell(33);
			if (R66cell31 != null) {
				R66cell31.setCellValue(brf94d.getR66_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR66_no_of_transactions_trade_corporate().intValue());
			}
			Cell R66cell32 = R66row.getCell(34);
			if (R66cell32 != null) {
				R66cell32.setCellValue(brf94d.getR66_amount_trade_corporate() == null ? 0
						: brf94d.getR66_amount_trade_corporate().intValue());
			}
			Cell R66cell33 = R66row.getCell(35);
			if (R66cell33 != null) {
				R66cell33.setCellValue(brf94d.getR66_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR66_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R66cell34 = R66row.getCell(36);
			if (R66cell34 != null) {
				R66cell34.setCellValue(brf94d.getR66_amount_financial_investment_sme() == null ? 0
						: brf94d.getR66_amount_financial_investment_sme().intValue());
			}
			Cell R66cell35 = R66row.getCell(37);
			if (R66cell35 != null) {
				R66cell35.setCellValue(brf94d.getR66_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR66_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R66cell36 = R66row.getCell(38);
			if (R66cell36 != null) {
				R66cell36.setCellValue(brf94d.getR66_amount_direct_investment_sme() == null ? 0
						: brf94d.getR66_amount_direct_investment_sme().intValue());
			}
			Cell R66cell37 = R66row.getCell(39);
			if (R66cell37 != null) {
				R66cell37.setCellValue(brf94d.getR66_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR66_no_of_transactions_services_sme().intValue());
			}
			Cell R66cell38 = R66row.getCell(40);
			if (R66cell38 != null) {
				R66cell38.setCellValue(brf94d.getR66_amount_services_sme() == null ? 0
						: brf94d.getR66_amount_services_sme().intValue());
			}
			Cell R66cell39 = R66row.getCell(41);
			if (R66cell39 != null) {
				R66cell39.setCellValue(brf94d.getR66_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR66_no_of_transactions_trade_sme().intValue());
			}
			Cell R66cell40 = R66row.getCell(42);
			if (R66cell40 != null) {
				R66cell40.setCellValue(
						brf94d.getR66_amount_trade_sme() == null ? 0 : brf94d.getR66_amount_trade_sme().intValue());
			}
			Cell R66cell41 = R66row.getCell(43);
			if (R66cell41 != null) {
				R66cell41.setCellValue(brf94d.getR66_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R66cell42 = R66row.getCell(44);
			if (R66cell42 != null) {
				R66cell42.setCellValue(brf94d.getR66_amount_financial_investment_individual() == null ? 0
						: brf94d.getR66_amount_financial_investment_individual().intValue());
			}
			Cell R66cell43 = R66row.getCell(45);
			if (R66cell43 != null) {
				R66cell43.setCellValue(brf94d.getR66_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R66cell44 = R66row.getCell(46);
			if (R66cell44 != null) {
				R66cell44.setCellValue(brf94d.getR66_amount_direct_investment_individual() == null ? 0
						: brf94d.getR66_amount_direct_investment_individual().intValue());
			}
			Cell R66cell45 = R66row.getCell(47);
			if (R66cell45 != null) {
				R66cell45.setCellValue(brf94d.getR66_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_family_support_individual().intValue());
			}
			Cell R66cell46 = R66row.getCell(48);
			if (R66cell46 != null) {
				R66cell46.setCellValue(brf94d.getR66_amount_family_support_individual() == null ? 0
						: brf94d.getR66_amount_family_support_individual().intValue());
			}
			Cell R66cell47 = R66row.getCell(49);
			if (R66cell47 != null) {
				R66cell47.setCellValue(brf94d.getR66_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_education_individual().intValue());
			}
			Cell R66cell48 = R66row.getCell(50);
			if (R66cell48 != null) {
				R66cell48.setCellValue(brf94d.getR66_amount_education_individual() == null ? 0
						: brf94d.getR66_amount_education_individual().intValue());
			}
			Cell R66cell49 = R66row.getCell(51);
			if (R66cell49 != null) {
				R66cell49.setCellValue(brf94d.getR66_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_medical_individual().intValue());
			}

			Cell R66cell50 = R66row.getCell(52);
			if (R66cell50 != null) {
				R66cell50.setCellValue(brf94d.getR66_amount_medical_individual() == null ? 0
						: brf94d.getR66_amount_medical_individual().intValue());
			}
			Cell R66cell51 = R66row.getCell(53);
			if (R66cell51 != null) {
				R66cell51.setCellValue(brf94d.getR66_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_tourism_individual().intValue());
			}
			Cell R66cell52 = R66row.getCell(54);
			if (R66cell52 != null) {
				R66cell52.setCellValue(brf94d.getR66_amount_tourism_individual() == null ? 0
						: brf94d.getR66_amount_tourism_individual().intValue());
			}
			Cell R66cell53 = R66row.getCell(55);
			if (R66cell53 != null) {
				R66cell53.setCellValue(brf94d.getR66_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R66cell54 = R66row.getCell(56);
			if (R66cell54 != null) {
				R66cell54.setCellValue(brf94d.getR66_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR66_amount_debt_settlement_individual().intValue());
			}
			Cell R66cell55 = R66row.getCell(57);
			if (R66cell55 != null) {
				R66cell55.setCellValue(brf94d.getR66_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR66_no_of_transactions_other_services_individual().intValue());
			}

			Cell R66cell56 = R66row.getCell(58);
			if (R66cell56 != null) {
				R66cell56.setCellValue(brf94d.getR66_amount_other_services_individual() == null ? 0
						: brf94d.getR66_amount_other_services_individual().intValue());
			}

			Row R67row = sheet.getRow(75);
			Cell R67cell1 = R67row.getCell(3);
			if (R67cell1 != null) {
				R67cell1.setCellValue(brf94d.getR67_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR67_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R67cell2 = R67row.getCell(4);
			if (R67cell2 != null) {
				R67cell2.setCellValue(brf94d.getR67_amount_financial_investment_government() == null ? 0
						: brf94d.getR67_amount_financial_investment_government().intValue());
			}
			Cell R67cell3 = R67row.getCell(5);
			if (R67cell3 != null) {
				R67cell3.setCellValue(brf94d.getR67_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR67_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R67cell4 = R67row.getCell(6);
			if (R67cell4 != null) {
				R67cell4.setCellValue(brf94d.getR67_amount_direct_investment_government() == null ? 0
						: brf94d.getR67_amount_direct_investment_government().intValue());
			}
			Cell R67cell5 = R67row.getCell(7);
			if (R67cell5 != null) {
				R67cell5.setCellValue(brf94d.getR67_no_of_transactions_services_government() == null ? 0
						: brf94d.getR67_no_of_transactions_services_government().intValue());
			}
			Cell R67cell6 = R67row.getCell(8);
			if (R67cell6 != null) {
				R67cell6.setCellValue(brf94d.getR67_amount_services_government() == null ? 0
						: brf94d.getR67_amount_services_government().intValue());
			}
			Cell R67cell7 = R67row.getCell(9);
			if (R67cell7 != null) {
				R67cell7.setCellValue(brf94d.getR67_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR67_no_of_transactions_trade_government().intValue());
			}
			Cell R67cell8 = R67row.getCell(10);
			if (R67cell8 != null) {
				R67cell8.setCellValue(brf94d.getR67_amount_trade_government() == null ? 0
						: brf94d.getR67_amount_trade_government().intValue());
			}
			Cell R67cell9 = R67row.getCell(11);
			if (R67cell9 != null) {
				R67cell9.setCellValue(brf94d.getR67_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR67_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R67cell10 = R67row.getCell(12);
			if (R67cell10 != null) {
				R67cell10.setCellValue(brf94d.getR67_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR67_amount_financial_investment_reserve().intValue());
			}
			Cell R67cell11 = R67row.getCell(13);
			if (R67cell11 != null) {
				R67cell11.setCellValue(brf94d.getR67_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR67_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R67cell12 = R67row.getCell(14);
			if (R67cell12 != null) {
				R67cell12.setCellValue(brf94d.getR67_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR67_amount_direct_investment_reserve().intValue());
			}
			Cell R67cell13 = R67row.getCell(15);
			if (R67cell13 != null) {
				R67cell13.setCellValue(brf94d.getR67_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR67_no_of_transactions_services_reserve().intValue());
			}
			Cell R67cell14 = R67row.getCell(16);
			if (R67cell14 != null) {
				R67cell14.setCellValue(brf94d.getR67_amount_services_reserve() == null ? 0
						: brf94d.getR67_amount_services_reserve().intValue());
			}
			Cell R67cell15 = R67row.getCell(17);
			if (R67cell15 != null) {
				R67cell15.setCellValue(brf94d.getR67_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR67_no_of_transactions_trade_reserve().intValue());
			}
			Cell R67cell16 = R67row.getCell(18);
			if (R67cell16 != null) {
				R67cell16.setCellValue(brf94d.getR67_amount_trade_reserve() == null ? 0
						: brf94d.getR67_amount_trade_reserve().intValue());
			}
			Cell R67cell17 = R67row.getCell(19);
			if (R67cell17 != null) {
				R67cell17.setCellValue(brf94d.getR67_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR67_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R67cell18 = R67row.getCell(20);
			if (R67cell18 != null) {
				R67cell18.setCellValue(brf94d.getR67_amount_financial_investment_gre() == null ? 0
						: brf94d.getR67_amount_financial_investment_gre().intValue());
			}
			Cell R67cell19 = R67row.getCell(21);
			if (R67cell19 != null) {
				R67cell19.setCellValue(brf94d.getR67_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR67_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R67cell20 = R67row.getCell(22);
			if (R67cell20 != null) {
				R67cell20.setCellValue(brf94d.getR67_amount_direct_investment_gre() == null ? 0
						: brf94d.getR67_amount_direct_investment_gre().intValue());
			}
			Cell R67cell21 = R67row.getCell(23);
			if (R67cell21 != null) {
				R67cell21.setCellValue(brf94d.getR67_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR67_no_of_transactions_services_gre().intValue());
			}
			Cell R67cell22 = R67row.getCell(24);
			if (R67cell22 != null) {
				R67cell22.setCellValue(brf94d.getR67_amount_services_gre() == null ? 0
						: brf94d.getR67_amount_services_gre().intValue());
			}
			Cell R67cell23 = R67row.getCell(25);
			if (R67cell23 != null) {
				R67cell23.setCellValue(brf94d.getR67_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR67_no_of_transactions_trade_gre().intValue());
			}
			Cell R67cell24 = R67row.getCell(26);
			if (R67cell24 != null) {
				R67cell24.setCellValue(
						brf94d.getR67_amount_trade_gre() == null ? 0 : brf94d.getR67_amount_trade_gre().intValue());
			}
			Cell R67cell25 = R67row.getCell(27);
			if (R67cell25 != null) {
				R67cell25.setCellValue(brf94d.getR67_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR67_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R67cell26 = R67row.getCell(28);
			if (R67cell26 != null) {
				R67cell26.setCellValue(brf94d.getR67_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR67_amount_financial_investment_corporate().intValue());
			}
			Cell R67cell27 = R67row.getCell(29);
			if (R67cell27 != null) {
				R67cell27.setCellValue(brf94d.getR67_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR67_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R67cell28 = R67row.getCell(30);
			if (R67cell28 != null) {
				R67cell28.setCellValue(brf94d.getR67_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR67_amount_direct_investment_corporate().intValue());
			}
			Cell R67cell29 = R67row.getCell(31);
			if (R67cell29 != null) {
				R67cell29.setCellValue(brf94d.getR67_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR67_no_of_transactions_services_corporate().intValue());
			}
			Cell R67cell30 = R67row.getCell(32);
			if (R67cell30 != null) {
				R67cell30.setCellValue(brf94d.getR67_amount_services_corporate() == null ? 0
						: brf94d.getR67_amount_services_corporate().intValue());
			}
			Cell R67cell31 = R67row.getCell(33);
			if (R67cell31 != null) {
				R67cell31.setCellValue(brf94d.getR67_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR67_no_of_transactions_trade_corporate().intValue());
			}
			Cell R67cell32 = R67row.getCell(34);
			if (R67cell32 != null) {
				R67cell32.setCellValue(brf94d.getR67_amount_trade_corporate() == null ? 0
						: brf94d.getR67_amount_trade_corporate().intValue());
			}
			Cell R67cell33 = R67row.getCell(35);
			if (R67cell33 != null) {
				R67cell33.setCellValue(brf94d.getR67_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR67_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R67cell34 = R67row.getCell(36);
			if (R67cell34 != null) {
				R67cell34.setCellValue(brf94d.getR67_amount_financial_investment_sme() == null ? 0
						: brf94d.getR67_amount_financial_investment_sme().intValue());
			}
			Cell R67cell35 = R67row.getCell(37);
			if (R67cell35 != null) {
				R67cell35.setCellValue(brf94d.getR67_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR67_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R67cell36 = R67row.getCell(38);
			if (R67cell36 != null) {
				R67cell36.setCellValue(brf94d.getR67_amount_direct_investment_sme() == null ? 0
						: brf94d.getR67_amount_direct_investment_sme().intValue());
			}
			Cell R67cell37 = R67row.getCell(39);
			if (R67cell37 != null) {
				R67cell37.setCellValue(brf94d.getR67_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR67_no_of_transactions_services_sme().intValue());
			}
			Cell R67cell38 = R67row.getCell(40);
			if (R67cell38 != null) {
				R67cell38.setCellValue(brf94d.getR67_amount_services_sme() == null ? 0
						: brf94d.getR67_amount_services_sme().intValue());
			}
			Cell R67cell39 = R67row.getCell(41);
			if (R67cell39 != null) {
				R67cell39.setCellValue(brf94d.getR67_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR67_no_of_transactions_trade_sme().intValue());
			}
			Cell R67cell40 = R67row.getCell(42);
			if (R67cell40 != null) {
				R67cell40.setCellValue(
						brf94d.getR67_amount_trade_sme() == null ? 0 : brf94d.getR67_amount_trade_sme().intValue());
			}
			Cell R67cell41 = R67row.getCell(43);
			if (R67cell41 != null) {
				R67cell41.setCellValue(brf94d.getR67_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R67cell42 = R67row.getCell(44);
			if (R67cell42 != null) {
				R67cell42.setCellValue(brf94d.getR67_amount_financial_investment_individual() == null ? 0
						: brf94d.getR67_amount_financial_investment_individual().intValue());
			}
			Cell R67cell43 = R67row.getCell(45);
			if (R67cell43 != null) {
				R67cell43.setCellValue(brf94d.getR67_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R67cell44 = R67row.getCell(46);
			if (R67cell44 != null) {
				R67cell44.setCellValue(brf94d.getR67_amount_direct_investment_individual() == null ? 0
						: brf94d.getR67_amount_direct_investment_individual().intValue());
			}
			Cell R67cell45 = R67row.getCell(47);
			if (R67cell45 != null) {
				R67cell45.setCellValue(brf94d.getR67_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_family_support_individual().intValue());
			}
			Cell R67cell46 = R67row.getCell(48);
			if (R67cell46 != null) {
				R67cell46.setCellValue(brf94d.getR67_amount_family_support_individual() == null ? 0
						: brf94d.getR67_amount_family_support_individual().intValue());
			}
			Cell R67cell47 = R67row.getCell(49);
			if (R67cell47 != null) {
				R67cell47.setCellValue(brf94d.getR67_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_education_individual().intValue());
			}
			Cell R67cell48 = R67row.getCell(50);
			if (R67cell48 != null) {
				R67cell48.setCellValue(brf94d.getR67_amount_education_individual() == null ? 0
						: brf94d.getR67_amount_education_individual().intValue());
			}
			Cell R67cell49 = R67row.getCell(51);
			if (R67cell49 != null) {
				R67cell49.setCellValue(brf94d.getR67_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_medical_individual().intValue());
			}

			Cell R67cell50 = R67row.getCell(52);
			if (R67cell50 != null) {
				R67cell50.setCellValue(brf94d.getR67_amount_medical_individual() == null ? 0
						: brf94d.getR67_amount_medical_individual().intValue());
			}
			Cell R67cell51 = R67row.getCell(53);
			if (R67cell51 != null) {
				R67cell51.setCellValue(brf94d.getR67_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_tourism_individual().intValue());
			}
			Cell R67cell52 = R67row.getCell(54);
			if (R67cell52 != null) {
				R67cell52.setCellValue(brf94d.getR67_amount_tourism_individual() == null ? 0
						: brf94d.getR67_amount_tourism_individual().intValue());
			}
			Cell R67cell53 = R67row.getCell(55);
			if (R67cell53 != null) {
				R67cell53.setCellValue(brf94d.getR67_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R67cell54 = R67row.getCell(56);
			if (R67cell54 != null) {
				R67cell54.setCellValue(brf94d.getR67_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR67_amount_debt_settlement_individual().intValue());
			}
			Cell R67cell55 = R67row.getCell(57);
			if (R67cell55 != null) {
				R67cell55.setCellValue(brf94d.getR67_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR67_no_of_transactions_other_services_individual().intValue());
			}

			Cell R67cell56 = R67row.getCell(58);
			if (R67cell56 != null) {
				R67cell56.setCellValue(brf94d.getR67_amount_other_services_individual() == null ? 0
						: brf94d.getR67_amount_other_services_individual().intValue());
			}

			Row R69row = sheet.getRow(77);
			Cell R69cell1 = R69row.getCell(3);
			if (R69cell1 != null) {
				R69cell1.setCellValue(brf94d.getR69_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR69_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R69cell2 = R69row.getCell(4);
			if (R69cell2 != null) {
				R69cell2.setCellValue(brf94d.getR69_amount_financial_investment_government() == null ? 0
						: brf94d.getR69_amount_financial_investment_government().intValue());
			}
			Cell R69cell3 = R69row.getCell(5);
			if (R69cell3 != null) {
				R69cell3.setCellValue(brf94d.getR69_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR69_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R69cell4 = R69row.getCell(6);
			if (R69cell4 != null) {
				R69cell4.setCellValue(brf94d.getR69_amount_direct_investment_government() == null ? 0
						: brf94d.getR69_amount_direct_investment_government().intValue());
			}
			Cell R69cell5 = R69row.getCell(7);
			if (R69cell5 != null) {
				R69cell5.setCellValue(brf94d.getR69_no_of_transactions_services_government() == null ? 0
						: brf94d.getR69_no_of_transactions_services_government().intValue());
			}
			Cell R69cell6 = R69row.getCell(8);
			if (R69cell6 != null) {
				R69cell6.setCellValue(brf94d.getR69_amount_services_government() == null ? 0
						: brf94d.getR69_amount_services_government().intValue());
			}
			Cell R69cell7 = R69row.getCell(9);
			if (R69cell7 != null) {
				R69cell7.setCellValue(brf94d.getR69_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR69_no_of_transactions_trade_government().intValue());
			}
			Cell R69cell8 = R69row.getCell(10);
			if (R69cell8 != null) {
				R69cell8.setCellValue(brf94d.getR69_amount_trade_government() == null ? 0
						: brf94d.getR69_amount_trade_government().intValue());
			}
			Cell R69cell9 = R69row.getCell(11);
			if (R69cell9 != null) {
				R69cell9.setCellValue(brf94d.getR69_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR69_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R69cell10 = R69row.getCell(12);
			if (R69cell10 != null) {
				R69cell10.setCellValue(brf94d.getR69_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR69_amount_financial_investment_reserve().intValue());
			}
			Cell R69cell11 = R69row.getCell(13);
			if (R69cell11 != null) {
				R69cell11.setCellValue(brf94d.getR69_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR69_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R69cell12 = R69row.getCell(14);
			if (R69cell12 != null) {
				R69cell12.setCellValue(brf94d.getR69_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR69_amount_direct_investment_reserve().intValue());
			}
			Cell R69cell13 = R69row.getCell(15);
			if (R69cell13 != null) {
				R69cell13.setCellValue(brf94d.getR69_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR69_no_of_transactions_services_reserve().intValue());
			}
			Cell R69cell14 = R69row.getCell(16);
			if (R69cell14 != null) {
				R69cell14.setCellValue(brf94d.getR69_amount_services_reserve() == null ? 0
						: brf94d.getR69_amount_services_reserve().intValue());
			}
			Cell R69cell15 = R69row.getCell(17);
			if (R69cell15 != null) {
				R69cell15.setCellValue(brf94d.getR69_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR69_no_of_transactions_trade_reserve().intValue());
			}
			Cell R69cell16 = R69row.getCell(18);
			if (R69cell16 != null) {
				R69cell16.setCellValue(brf94d.getR69_amount_trade_reserve() == null ? 0
						: brf94d.getR69_amount_trade_reserve().intValue());
			}
			Cell R69cell17 = R69row.getCell(19);
			if (R69cell17 != null) {
				R69cell17.setCellValue(brf94d.getR69_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR69_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R69cell18 = R69row.getCell(20);
			if (R69cell18 != null) {
				R69cell18.setCellValue(brf94d.getR69_amount_financial_investment_gre() == null ? 0
						: brf94d.getR69_amount_financial_investment_gre().intValue());
			}
			Cell R69cell19 = R69row.getCell(21);
			if (R69cell19 != null) {
				R69cell19.setCellValue(brf94d.getR69_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR69_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R69cell20 = R69row.getCell(22);
			if (R69cell20 != null) {
				R69cell20.setCellValue(brf94d.getR69_amount_direct_investment_gre() == null ? 0
						: brf94d.getR69_amount_direct_investment_gre().intValue());
			}
			Cell R69cell21 = R69row.getCell(23);
			if (R69cell21 != null) {
				R69cell21.setCellValue(brf94d.getR69_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR69_no_of_transactions_services_gre().intValue());
			}
			Cell R69cell22 = R69row.getCell(24);
			if (R69cell22 != null) {
				R69cell22.setCellValue(brf94d.getR69_amount_services_gre() == null ? 0
						: brf94d.getR69_amount_services_gre().intValue());
			}
			Cell R69cell23 = R69row.getCell(25);
			if (R69cell23 != null) {
				R69cell23.setCellValue(brf94d.getR69_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR69_no_of_transactions_trade_gre().intValue());
			}
			Cell R69cell24 = R69row.getCell(26);
			if (R69cell24 != null) {
				R69cell24.setCellValue(
						brf94d.getR69_amount_trade_gre() == null ? 0 : brf94d.getR69_amount_trade_gre().intValue());
			}
			Cell R69cell25 = R69row.getCell(27);
			if (R69cell25 != null) {
				R69cell25.setCellValue(brf94d.getR69_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR69_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R69cell26 = R69row.getCell(28);
			if (R69cell26 != null) {
				R69cell26.setCellValue(brf94d.getR69_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR69_amount_financial_investment_corporate().intValue());
			}
			Cell R69cell27 = R69row.getCell(29);
			if (R69cell27 != null) {
				R69cell27.setCellValue(brf94d.getR69_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR69_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R69cell28 = R69row.getCell(30);
			if (R69cell28 != null) {
				R69cell28.setCellValue(brf94d.getR69_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR69_amount_direct_investment_corporate().intValue());
			}
			Cell R69cell29 = R69row.getCell(31);
			if (R69cell29 != null) {
				R69cell29.setCellValue(brf94d.getR69_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR69_no_of_transactions_services_corporate().intValue());
			}
			Cell R69cell30 = R69row.getCell(32);
			if (R69cell30 != null) {
				R69cell30.setCellValue(brf94d.getR69_amount_services_corporate() == null ? 0
						: brf94d.getR69_amount_services_corporate().intValue());
			}
			Cell R69cell31 = R69row.getCell(33);
			if (R69cell31 != null) {
				R69cell31.setCellValue(brf94d.getR69_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR69_no_of_transactions_trade_corporate().intValue());
			}
			Cell R69cell32 = R69row.getCell(34);
			if (R69cell32 != null) {
				R69cell32.setCellValue(brf94d.getR69_amount_trade_corporate() == null ? 0
						: brf94d.getR69_amount_trade_corporate().intValue());
			}
			Cell R69cell33 = R69row.getCell(35);
			if (R69cell33 != null) {
				R69cell33.setCellValue(brf94d.getR69_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR69_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R69cell34 = R69row.getCell(36);
			if (R69cell34 != null) {
				R69cell34.setCellValue(brf94d.getR69_amount_financial_investment_sme() == null ? 0
						: brf94d.getR69_amount_financial_investment_sme().intValue());
			}
			Cell R69cell35 = R69row.getCell(37);
			if (R69cell35 != null) {
				R69cell35.setCellValue(brf94d.getR69_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR69_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R69cell36 = R69row.getCell(38);
			if (R69cell36 != null) {
				R69cell36.setCellValue(brf94d.getR69_amount_direct_investment_sme() == null ? 0
						: brf94d.getR69_amount_direct_investment_sme().intValue());
			}
			Cell R69cell37 = R69row.getCell(39);
			if (R69cell37 != null) {
				R69cell37.setCellValue(brf94d.getR69_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR69_no_of_transactions_services_sme().intValue());
			}
			Cell R69cell38 = R69row.getCell(40);
			if (R69cell38 != null) {
				R69cell38.setCellValue(brf94d.getR69_amount_services_sme() == null ? 0
						: brf94d.getR69_amount_services_sme().intValue());
			}
			Cell R69cell39 = R69row.getCell(41);
			if (R69cell39 != null) {
				R69cell39.setCellValue(brf94d.getR69_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR69_no_of_transactions_trade_sme().intValue());
			}
			Cell R69cell40 = R69row.getCell(42);
			if (R69cell40 != null) {
				R69cell40.setCellValue(
						brf94d.getR69_amount_trade_sme() == null ? 0 : brf94d.getR69_amount_trade_sme().intValue());
			}
			Cell R69cell41 = R69row.getCell(43);
			if (R69cell41 != null) {
				R69cell41.setCellValue(brf94d.getR69_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R69cell42 = R69row.getCell(44);
			if (R69cell42 != null) {
				R69cell42.setCellValue(brf94d.getR69_amount_financial_investment_individual() == null ? 0
						: brf94d.getR69_amount_financial_investment_individual().intValue());
			}
			Cell R69cell43 = R69row.getCell(45);
			if (R69cell43 != null) {
				R69cell43.setCellValue(brf94d.getR69_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R69cell44 = R69row.getCell(46);
			if (R69cell44 != null) {
				R69cell44.setCellValue(brf94d.getR69_amount_direct_investment_individual() == null ? 0
						: brf94d.getR69_amount_direct_investment_individual().intValue());
			}
			Cell R69cell45 = R69row.getCell(47);
			if (R69cell45 != null) {
				R69cell45.setCellValue(brf94d.getR69_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_family_support_individual().intValue());
			}
			Cell R69cell46 = R69row.getCell(48);
			if (R69cell46 != null) {
				R69cell46.setCellValue(brf94d.getR69_amount_family_support_individual() == null ? 0
						: brf94d.getR69_amount_family_support_individual().intValue());
			}
			Cell R69cell47 = R69row.getCell(49);
			if (R69cell47 != null) {
				R69cell47.setCellValue(brf94d.getR69_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_education_individual().intValue());
			}
			Cell R69cell48 = R69row.getCell(50);
			if (R69cell48 != null) {
				R69cell48.setCellValue(brf94d.getR69_amount_education_individual() == null ? 0
						: brf94d.getR69_amount_education_individual().intValue());
			}
			Cell R69cell49 = R69row.getCell(51);
			if (R69cell49 != null) {
				R69cell49.setCellValue(brf94d.getR69_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_medical_individual().intValue());
			}

			Cell R69cell50 = R69row.getCell(52);
			if (R69cell50 != null) {
				R69cell50.setCellValue(brf94d.getR69_amount_medical_individual() == null ? 0
						: brf94d.getR69_amount_medical_individual().intValue());
			}
			Cell R69cell51 = R69row.getCell(53);
			if (R69cell51 != null) {
				R69cell51.setCellValue(brf94d.getR69_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_tourism_individual().intValue());
			}
			Cell R69cell52 = R69row.getCell(54);
			if (R69cell52 != null) {
				R69cell52.setCellValue(brf94d.getR69_amount_tourism_individual() == null ? 0
						: brf94d.getR69_amount_tourism_individual().intValue());
			}
			Cell R69cell53 = R69row.getCell(55);
			if (R69cell53 != null) {
				R69cell53.setCellValue(brf94d.getR69_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R69cell54 = R69row.getCell(56);
			if (R69cell54 != null) {
				R69cell54.setCellValue(brf94d.getR69_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR69_amount_debt_settlement_individual().intValue());
			}
			Cell R69cell55 = R69row.getCell(57);
			if (R69cell55 != null) {
				R69cell55.setCellValue(brf94d.getR69_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR69_no_of_transactions_other_services_individual().intValue());
			}

			Cell R69cell56 = R69row.getCell(58);
			if (R69cell56 != null) {
				R69cell56.setCellValue(brf94d.getR69_amount_other_services_individual() == null ? 0
						: brf94d.getR69_amount_other_services_individual().intValue());
			}

			Row R70row = sheet.getRow(78);
			Cell R70cell1 = R70row.getCell(3);
			if (R70cell1 != null) {
				R70cell1.setCellValue(brf94d.getR70_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR70_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R70cell2 = R70row.getCell(4);
			if (R70cell2 != null) {
				R70cell2.setCellValue(brf94d.getR70_amount_financial_investment_government() == null ? 0
						: brf94d.getR70_amount_financial_investment_government().intValue());
			}
			Cell R70cell3 = R70row.getCell(5);
			if (R70cell3 != null) {
				R70cell3.setCellValue(brf94d.getR70_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR70_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R70cell4 = R70row.getCell(6);
			if (R70cell4 != null) {
				R70cell4.setCellValue(brf94d.getR70_amount_direct_investment_government() == null ? 0
						: brf94d.getR70_amount_direct_investment_government().intValue());
			}
			Cell R70cell5 = R70row.getCell(7);
			if (R70cell5 != null) {
				R70cell5.setCellValue(brf94d.getR70_no_of_transactions_services_government() == null ? 0
						: brf94d.getR70_no_of_transactions_services_government().intValue());
			}
			Cell R70cell6 = R70row.getCell(8);
			if (R70cell6 != null) {
				R70cell6.setCellValue(brf94d.getR70_amount_services_government() == null ? 0
						: brf94d.getR70_amount_services_government().intValue());
			}
			Cell R70cell7 = R70row.getCell(9);
			if (R70cell7 != null) {
				R70cell7.setCellValue(brf94d.getR70_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR70_no_of_transactions_trade_government().intValue());
			}
			Cell R70cell8 = R70row.getCell(10);
			if (R70cell8 != null) {
				R70cell8.setCellValue(brf94d.getR70_amount_trade_government() == null ? 0
						: brf94d.getR70_amount_trade_government().intValue());
			}
			Cell R70cell9 = R70row.getCell(11);
			if (R70cell9 != null) {
				R70cell9.setCellValue(brf94d.getR70_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR70_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R70cell10 = R70row.getCell(12);
			if (R70cell10 != null) {
				R70cell10.setCellValue(brf94d.getR70_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR70_amount_financial_investment_reserve().intValue());
			}
			Cell R70cell11 = R70row.getCell(13);
			if (R70cell11 != null) {
				R70cell11.setCellValue(brf94d.getR70_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR70_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R70cell12 = R70row.getCell(14);
			if (R70cell12 != null) {
				R70cell12.setCellValue(brf94d.getR70_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR70_amount_direct_investment_reserve().intValue());
			}
			Cell R70cell13 = R70row.getCell(15);
			if (R70cell13 != null) {
				R70cell13.setCellValue(brf94d.getR70_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR70_no_of_transactions_services_reserve().intValue());
			}
			Cell R70cell14 = R70row.getCell(16);
			if (R70cell14 != null) {
				R70cell14.setCellValue(brf94d.getR70_amount_services_reserve() == null ? 0
						: brf94d.getR70_amount_services_reserve().intValue());
			}
			Cell R70cell15 = R70row.getCell(17);
			if (R70cell15 != null) {
				R70cell15.setCellValue(brf94d.getR70_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR70_no_of_transactions_trade_reserve().intValue());
			}
			Cell R70cell16 = R70row.getCell(18);
			if (R70cell16 != null) {
				R70cell16.setCellValue(brf94d.getR70_amount_trade_reserve() == null ? 0
						: brf94d.getR70_amount_trade_reserve().intValue());
			}
			Cell R70cell17 = R70row.getCell(19);
			if (R70cell17 != null) {
				R70cell17.setCellValue(brf94d.getR70_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR70_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R70cell18 = R70row.getCell(20);
			if (R70cell18 != null) {
				R70cell18.setCellValue(brf94d.getR70_amount_financial_investment_gre() == null ? 0
						: brf94d.getR70_amount_financial_investment_gre().intValue());
			}
			Cell R70cell19 = R70row.getCell(21);
			if (R70cell19 != null) {
				R70cell19.setCellValue(brf94d.getR70_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR70_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R70cell20 = R70row.getCell(22);
			if (R70cell20 != null) {
				R70cell20.setCellValue(brf94d.getR70_amount_direct_investment_gre() == null ? 0
						: brf94d.getR70_amount_direct_investment_gre().intValue());
			}
			Cell R70cell21 = R70row.getCell(23);
			if (R70cell21 != null) {
				R70cell21.setCellValue(brf94d.getR70_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR70_no_of_transactions_services_gre().intValue());
			}
			Cell R70cell22 = R70row.getCell(24);
			if (R70cell22 != null) {
				R70cell22.setCellValue(brf94d.getR70_amount_services_gre() == null ? 0
						: brf94d.getR70_amount_services_gre().intValue());
			}
			Cell R70cell23 = R70row.getCell(25);
			if (R70cell23 != null) {
				R70cell23.setCellValue(brf94d.getR70_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR70_no_of_transactions_trade_gre().intValue());
			}
			Cell R70cell24 = R70row.getCell(26);
			if (R70cell24 != null) {
				R70cell24.setCellValue(
						brf94d.getR70_amount_trade_gre() == null ? 0 : brf94d.getR70_amount_trade_gre().intValue());
			}
			Cell R70cell25 = R70row.getCell(27);
			if (R70cell25 != null) {
				R70cell25.setCellValue(brf94d.getR70_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR70_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R70cell26 = R70row.getCell(28);
			if (R70cell26 != null) {
				R70cell26.setCellValue(brf94d.getR70_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR70_amount_financial_investment_corporate().intValue());
			}
			Cell R70cell27 = R70row.getCell(29);
			if (R70cell27 != null) {
				R70cell27.setCellValue(brf94d.getR70_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR70_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R70cell28 = R70row.getCell(30);
			if (R70cell28 != null) {
				R70cell28.setCellValue(brf94d.getR70_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR70_amount_direct_investment_corporate().intValue());
			}
			Cell R70cell29 = R70row.getCell(31);
			if (R70cell29 != null) {
				R70cell29.setCellValue(brf94d.getR70_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR70_no_of_transactions_services_corporate().intValue());
			}
			Cell R70cell30 = R70row.getCell(32);
			if (R70cell30 != null) {
				R70cell30.setCellValue(brf94d.getR70_amount_services_corporate() == null ? 0
						: brf94d.getR70_amount_services_corporate().intValue());
			}
			Cell R70cell31 = R70row.getCell(33);
			if (R70cell31 != null) {
				R70cell31.setCellValue(brf94d.getR70_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR70_no_of_transactions_trade_corporate().intValue());
			}
			Cell R70cell32 = R70row.getCell(34);
			if (R70cell32 != null) {
				R70cell32.setCellValue(brf94d.getR70_amount_trade_corporate() == null ? 0
						: brf94d.getR70_amount_trade_corporate().intValue());
			}
			Cell R70cell33 = R70row.getCell(35);
			if (R70cell33 != null) {
				R70cell33.setCellValue(brf94d.getR70_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR70_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R70cell34 = R70row.getCell(36);
			if (R70cell34 != null) {
				R70cell34.setCellValue(brf94d.getR70_amount_financial_investment_sme() == null ? 0
						: brf94d.getR70_amount_financial_investment_sme().intValue());
			}
			Cell R70cell35 = R70row.getCell(37);
			if (R70cell35 != null) {
				R70cell35.setCellValue(brf94d.getR70_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR70_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R70cell36 = R70row.getCell(38);
			if (R70cell36 != null) {
				R70cell36.setCellValue(brf94d.getR70_amount_direct_investment_sme() == null ? 0
						: brf94d.getR70_amount_direct_investment_sme().intValue());
			}
			Cell R70cell37 = R70row.getCell(39);
			if (R70cell37 != null) {
				R70cell37.setCellValue(brf94d.getR70_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR70_no_of_transactions_services_sme().intValue());
			}
			Cell R70cell38 = R70row.getCell(40);
			if (R70cell38 != null) {
				R70cell38.setCellValue(brf94d.getR70_amount_services_sme() == null ? 0
						: brf94d.getR70_amount_services_sme().intValue());
			}
			Cell R70cell39 = R70row.getCell(41);
			if (R70cell39 != null) {
				R70cell39.setCellValue(brf94d.getR70_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR70_no_of_transactions_trade_sme().intValue());
			}
			Cell R70cell40 = R70row.getCell(42);
			if (R70cell40 != null) {
				R70cell40.setCellValue(
						brf94d.getR70_amount_trade_sme() == null ? 0 : brf94d.getR70_amount_trade_sme().intValue());
			}
			Cell R70cell41 = R70row.getCell(43);
			if (R70cell41 != null) {
				R70cell41.setCellValue(brf94d.getR70_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R70cell42 = R70row.getCell(44);
			if (R70cell42 != null) {
				R70cell42.setCellValue(brf94d.getR70_amount_financial_investment_individual() == null ? 0
						: brf94d.getR70_amount_financial_investment_individual().intValue());
			}
			Cell R70cell43 = R70row.getCell(45);
			if (R70cell43 != null) {
				R70cell43.setCellValue(brf94d.getR70_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R70cell44 = R70row.getCell(46);
			if (R70cell44 != null) {
				R70cell44.setCellValue(brf94d.getR70_amount_direct_investment_individual() == null ? 0
						: brf94d.getR70_amount_direct_investment_individual().intValue());
			}
			Cell R70cell45 = R70row.getCell(47);
			if (R70cell45 != null) {
				R70cell45.setCellValue(brf94d.getR70_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_family_support_individual().intValue());
			}
			Cell R70cell46 = R70row.getCell(48);
			if (R70cell46 != null) {
				R70cell46.setCellValue(brf94d.getR70_amount_family_support_individual() == null ? 0
						: brf94d.getR70_amount_family_support_individual().intValue());
			}
			Cell R70cell47 = R70row.getCell(49);
			if (R70cell47 != null) {
				R70cell47.setCellValue(brf94d.getR70_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_education_individual().intValue());
			}
			Cell R70cell48 = R70row.getCell(50);
			if (R70cell48 != null) {
				R70cell48.setCellValue(brf94d.getR70_amount_education_individual() == null ? 0
						: brf94d.getR70_amount_education_individual().intValue());
			}
			Cell R70cell49 = R70row.getCell(51);
			if (R70cell49 != null) {
				R70cell49.setCellValue(brf94d.getR70_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_medical_individual().intValue());
			}

			Cell R70cell50 = R70row.getCell(52);
			if (R70cell50 != null) {
				R70cell50.setCellValue(brf94d.getR70_amount_medical_individual() == null ? 0
						: brf94d.getR70_amount_medical_individual().intValue());
			}
			Cell R70cell51 = R70row.getCell(53);
			if (R70cell51 != null) {
				R70cell51.setCellValue(brf94d.getR70_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_tourism_individual().intValue());
			}
			Cell R70cell52 = R70row.getCell(54);
			if (R70cell52 != null) {
				R70cell52.setCellValue(brf94d.getR70_amount_tourism_individual() == null ? 0
						: brf94d.getR70_amount_tourism_individual().intValue());
			}
			Cell R70cell53 = R70row.getCell(55);
			if (R70cell53 != null) {
				R70cell53.setCellValue(brf94d.getR70_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R70cell54 = R70row.getCell(56);
			if (R70cell54 != null) {
				R70cell54.setCellValue(brf94d.getR70_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR70_amount_debt_settlement_individual().intValue());
			}
			Cell R70cell55 = R70row.getCell(57);
			if (R70cell55 != null) {
				R70cell55.setCellValue(brf94d.getR70_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR70_no_of_transactions_other_services_individual().intValue());
			}

			Cell R70cell56 = R70row.getCell(58);
			if (R70cell56 != null) {
				R70cell56.setCellValue(brf94d.getR70_amount_other_services_individual() == null ? 0
						: brf94d.getR70_amount_other_services_individual().intValue());
			}

			Row R71row = sheet.getRow(79);
			Cell R71cell1 = R71row.getCell(3);
			if (R71cell1 != null) {
				R71cell1.setCellValue(brf94d.getR71_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR71_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R71cell2 = R71row.getCell(4);
			if (R71cell2 != null) {
				R71cell2.setCellValue(brf94d.getR71_amount_financial_investment_government() == null ? 0
						: brf94d.getR71_amount_financial_investment_government().intValue());
			}
			Cell R71cell3 = R71row.getCell(5);
			if (R71cell3 != null) {
				R71cell3.setCellValue(brf94d.getR71_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR71_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R71cell4 = R71row.getCell(6);
			if (R71cell4 != null) {
				R71cell4.setCellValue(brf94d.getR71_amount_direct_investment_government() == null ? 0
						: brf94d.getR71_amount_direct_investment_government().intValue());
			}
			Cell R71cell5 = R71row.getCell(7);
			if (R71cell5 != null) {
				R71cell5.setCellValue(brf94d.getR71_no_of_transactions_services_government() == null ? 0
						: brf94d.getR71_no_of_transactions_services_government().intValue());
			}
			Cell R71cell6 = R71row.getCell(8);
			if (R71cell6 != null) {
				R71cell6.setCellValue(brf94d.getR71_amount_services_government() == null ? 0
						: brf94d.getR71_amount_services_government().intValue());
			}
			Cell R71cell7 = R71row.getCell(9);
			if (R71cell7 != null) {
				R71cell7.setCellValue(brf94d.getR71_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR71_no_of_transactions_trade_government().intValue());
			}
			Cell R71cell8 = R71row.getCell(10);
			if (R71cell8 != null) {
				R71cell8.setCellValue(brf94d.getR71_amount_trade_government() == null ? 0
						: brf94d.getR71_amount_trade_government().intValue());
			}
			Cell R71cell9 = R71row.getCell(11);
			if (R71cell9 != null) {
				R71cell9.setCellValue(brf94d.getR71_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR71_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R71cell10 = R71row.getCell(12);
			if (R71cell10 != null) {
				R71cell10.setCellValue(brf94d.getR71_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR71_amount_financial_investment_reserve().intValue());
			}
			Cell R71cell11 = R71row.getCell(13);
			if (R71cell11 != null) {
				R71cell11.setCellValue(brf94d.getR71_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR71_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R71cell12 = R71row.getCell(14);
			if (R71cell12 != null) {
				R71cell12.setCellValue(brf94d.getR71_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR71_amount_direct_investment_reserve().intValue());
			}
			Cell R71cell13 = R71row.getCell(15);
			if (R71cell13 != null) {
				R71cell13.setCellValue(brf94d.getR71_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR71_no_of_transactions_services_reserve().intValue());
			}
			Cell R71cell14 = R71row.getCell(16);
			if (R71cell14 != null) {
				R71cell14.setCellValue(brf94d.getR71_amount_services_reserve() == null ? 0
						: brf94d.getR71_amount_services_reserve().intValue());
			}
			Cell R71cell15 = R71row.getCell(17);
			if (R71cell15 != null) {
				R71cell15.setCellValue(brf94d.getR71_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR71_no_of_transactions_trade_reserve().intValue());
			}
			Cell R71cell16 = R71row.getCell(18);
			if (R71cell16 != null) {
				R71cell16.setCellValue(brf94d.getR71_amount_trade_reserve() == null ? 0
						: brf94d.getR71_amount_trade_reserve().intValue());
			}
			Cell R71cell17 = R71row.getCell(19);
			if (R71cell17 != null) {
				R71cell17.setCellValue(brf94d.getR71_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR71_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R71cell18 = R71row.getCell(20);
			if (R71cell18 != null) {
				R71cell18.setCellValue(brf94d.getR71_amount_financial_investment_gre() == null ? 0
						: brf94d.getR71_amount_financial_investment_gre().intValue());
			}
			Cell R71cell19 = R71row.getCell(21);
			if (R71cell19 != null) {
				R71cell19.setCellValue(brf94d.getR71_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR71_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R71cell20 = R71row.getCell(22);
			if (R71cell20 != null) {
				R71cell20.setCellValue(brf94d.getR71_amount_direct_investment_gre() == null ? 0
						: brf94d.getR71_amount_direct_investment_gre().intValue());
			}
			Cell R71cell21 = R71row.getCell(23);
			if (R71cell21 != null) {
				R71cell21.setCellValue(brf94d.getR71_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR71_no_of_transactions_services_gre().intValue());
			}
			Cell R71cell22 = R71row.getCell(24);
			if (R71cell22 != null) {
				R71cell22.setCellValue(brf94d.getR71_amount_services_gre() == null ? 0
						: brf94d.getR71_amount_services_gre().intValue());
			}
			Cell R71cell23 = R71row.getCell(25);
			if (R71cell23 != null) {
				R71cell23.setCellValue(brf94d.getR71_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR71_no_of_transactions_trade_gre().intValue());
			}
			Cell R71cell24 = R71row.getCell(26);
			if (R71cell24 != null) {
				R71cell24.setCellValue(
						brf94d.getR71_amount_trade_gre() == null ? 0 : brf94d.getR71_amount_trade_gre().intValue());
			}
			Cell R71cell25 = R71row.getCell(27);
			if (R71cell25 != null) {
				R71cell25.setCellValue(brf94d.getR71_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR71_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R71cell26 = R71row.getCell(28);
			if (R71cell26 != null) {
				R71cell26.setCellValue(brf94d.getR71_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR71_amount_financial_investment_corporate().intValue());
			}
			Cell R71cell27 = R71row.getCell(29);
			if (R71cell27 != null) {
				R71cell27.setCellValue(brf94d.getR71_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR71_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R71cell28 = R71row.getCell(30);
			if (R71cell28 != null) {
				R71cell28.setCellValue(brf94d.getR71_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR71_amount_direct_investment_corporate().intValue());
			}
			Cell R71cell29 = R71row.getCell(31);
			if (R71cell29 != null) {
				R71cell29.setCellValue(brf94d.getR71_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR71_no_of_transactions_services_corporate().intValue());
			}
			Cell R71cell30 = R71row.getCell(32);
			if (R71cell30 != null) {
				R71cell30.setCellValue(brf94d.getR71_amount_services_corporate() == null ? 0
						: brf94d.getR71_amount_services_corporate().intValue());
			}
			Cell R71cell31 = R71row.getCell(33);
			if (R71cell31 != null) {
				R71cell31.setCellValue(brf94d.getR71_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR71_no_of_transactions_trade_corporate().intValue());
			}
			Cell R71cell32 = R71row.getCell(34);
			if (R71cell32 != null) {
				R71cell32.setCellValue(brf94d.getR71_amount_trade_corporate() == null ? 0
						: brf94d.getR71_amount_trade_corporate().intValue());
			}
			Cell R71cell33 = R71row.getCell(35);
			if (R71cell33 != null) {
				R71cell33.setCellValue(brf94d.getR71_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR71_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R71cell34 = R71row.getCell(36);
			if (R71cell34 != null) {
				R71cell34.setCellValue(brf94d.getR71_amount_financial_investment_sme() == null ? 0
						: brf94d.getR71_amount_financial_investment_sme().intValue());
			}
			Cell R71cell35 = R71row.getCell(37);
			if (R71cell35 != null) {
				R71cell35.setCellValue(brf94d.getR71_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR71_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R71cell36 = R71row.getCell(38);
			if (R71cell36 != null) {
				R71cell36.setCellValue(brf94d.getR71_amount_direct_investment_sme() == null ? 0
						: brf94d.getR71_amount_direct_investment_sme().intValue());
			}
			Cell R71cell37 = R71row.getCell(39);
			if (R71cell37 != null) {
				R71cell37.setCellValue(brf94d.getR71_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR71_no_of_transactions_services_sme().intValue());
			}
			Cell R71cell38 = R71row.getCell(40);
			if (R71cell38 != null) {
				R71cell38.setCellValue(brf94d.getR71_amount_services_sme() == null ? 0
						: brf94d.getR71_amount_services_sme().intValue());
			}
			Cell R71cell39 = R71row.getCell(41);
			if (R71cell39 != null) {
				R71cell39.setCellValue(brf94d.getR71_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR71_no_of_transactions_trade_sme().intValue());
			}
			Cell R71cell40 = R71row.getCell(42);
			if (R71cell40 != null) {
				R71cell40.setCellValue(
						brf94d.getR71_amount_trade_sme() == null ? 0 : brf94d.getR71_amount_trade_sme().intValue());
			}
			Cell R71cell41 = R71row.getCell(43);
			if (R71cell41 != null) {
				R71cell41.setCellValue(brf94d.getR71_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R71cell42 = R71row.getCell(44);
			if (R71cell42 != null) {
				R71cell42.setCellValue(brf94d.getR71_amount_financial_investment_individual() == null ? 0
						: brf94d.getR71_amount_financial_investment_individual().intValue());
			}
			Cell R71cell43 = R71row.getCell(45);
			if (R71cell43 != null) {
				R71cell43.setCellValue(brf94d.getR71_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R71cell44 = R71row.getCell(46);
			if (R71cell44 != null) {
				R71cell44.setCellValue(brf94d.getR71_amount_direct_investment_individual() == null ? 0
						: brf94d.getR71_amount_direct_investment_individual().intValue());
			}
			Cell R71cell45 = R71row.getCell(47);
			if (R71cell45 != null) {
				R71cell45.setCellValue(brf94d.getR71_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_family_support_individual().intValue());
			}
			Cell R71cell46 = R71row.getCell(48);
			if (R71cell46 != null) {
				R71cell46.setCellValue(brf94d.getR71_amount_family_support_individual() == null ? 0
						: brf94d.getR71_amount_family_support_individual().intValue());
			}
			Cell R71cell47 = R71row.getCell(49);
			if (R71cell47 != null) {
				R71cell47.setCellValue(brf94d.getR71_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_education_individual().intValue());
			}
			Cell R71cell48 = R71row.getCell(50);
			if (R71cell48 != null) {
				R71cell48.setCellValue(brf94d.getR71_amount_education_individual() == null ? 0
						: brf94d.getR71_amount_education_individual().intValue());
			}
			Cell R71cell49 = R71row.getCell(51);
			if (R71cell49 != null) {
				R71cell49.setCellValue(brf94d.getR71_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_medical_individual().intValue());
			}

			Cell R71cell50 = R71row.getCell(52);
			if (R71cell50 != null) {
				R71cell50.setCellValue(brf94d.getR71_amount_medical_individual() == null ? 0
						: brf94d.getR71_amount_medical_individual().intValue());
			}
			Cell R71cell51 = R71row.getCell(53);
			if (R71cell51 != null) {
				R71cell51.setCellValue(brf94d.getR71_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_tourism_individual().intValue());
			}
			Cell R71cell52 = R71row.getCell(54);
			if (R71cell52 != null) {
				R71cell52.setCellValue(brf94d.getR71_amount_tourism_individual() == null ? 0
						: brf94d.getR71_amount_tourism_individual().intValue());
			}
			Cell R71cell53 = R71row.getCell(55);
			if (R71cell53 != null) {
				R71cell53.setCellValue(brf94d.getR71_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R71cell54 = R71row.getCell(56);
			if (R71cell54 != null) {
				R71cell54.setCellValue(brf94d.getR71_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR71_amount_debt_settlement_individual().intValue());
			}
			Cell R71cell55 = R71row.getCell(57);
			if (R71cell55 != null) {
				R71cell55.setCellValue(brf94d.getR71_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR71_no_of_transactions_other_services_individual().intValue());
			}

			Cell R71cell56 = R71row.getCell(58);
			if (R71cell56 != null) {
				R71cell56.setCellValue(brf94d.getR71_amount_other_services_individual() == null ? 0
						: brf94d.getR71_amount_other_services_individual().intValue());
			}

			Row R72row = sheet.getRow(80);
			Cell R72cell1 = R72row.getCell(3);
			if (R72cell1 != null) {
				R72cell1.setCellValue(brf94d.getR72_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR72_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R72cell2 = R72row.getCell(4);
			if (R72cell2 != null) {
				R72cell2.setCellValue(brf94d.getR72_amount_financial_investment_government() == null ? 0
						: brf94d.getR72_amount_financial_investment_government().intValue());
			}
			Cell R72cell3 = R72row.getCell(5);
			if (R72cell3 != null) {
				R72cell3.setCellValue(brf94d.getR72_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR72_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R72cell4 = R72row.getCell(6);
			if (R72cell4 != null) {
				R72cell4.setCellValue(brf94d.getR72_amount_direct_investment_government() == null ? 0
						: brf94d.getR72_amount_direct_investment_government().intValue());
			}
			Cell R72cell5 = R72row.getCell(7);
			if (R72cell5 != null) {
				R72cell5.setCellValue(brf94d.getR72_no_of_transactions_services_government() == null ? 0
						: brf94d.getR72_no_of_transactions_services_government().intValue());
			}
			Cell R72cell6 = R72row.getCell(8);
			if (R72cell6 != null) {
				R72cell6.setCellValue(brf94d.getR72_amount_services_government() == null ? 0
						: brf94d.getR72_amount_services_government().intValue());
			}
			Cell R72cell7 = R72row.getCell(9);
			if (R72cell7 != null) {
				R72cell7.setCellValue(brf94d.getR72_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR72_no_of_transactions_trade_government().intValue());
			}
			Cell R72cell8 = R72row.getCell(10);
			if (R72cell8 != null) {
				R72cell8.setCellValue(brf94d.getR72_amount_trade_government() == null ? 0
						: brf94d.getR72_amount_trade_government().intValue());
			}
			Cell R72cell9 = R72row.getCell(11);
			if (R72cell9 != null) {
				R72cell9.setCellValue(brf94d.getR72_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR72_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R72cell10 = R72row.getCell(12);
			if (R72cell10 != null) {
				R72cell10.setCellValue(brf94d.getR72_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR72_amount_financial_investment_reserve().intValue());
			}
			Cell R72cell11 = R72row.getCell(13);
			if (R72cell11 != null) {
				R72cell11.setCellValue(brf94d.getR72_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR72_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R72cell12 = R72row.getCell(14);
			if (R72cell12 != null) {
				R72cell12.setCellValue(brf94d.getR72_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR72_amount_direct_investment_reserve().intValue());
			}
			Cell R72cell13 = R72row.getCell(15);
			if (R72cell13 != null) {
				R72cell13.setCellValue(brf94d.getR72_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR72_no_of_transactions_services_reserve().intValue());
			}
			Cell R72cell14 = R72row.getCell(16);
			if (R72cell14 != null) {
				R72cell14.setCellValue(brf94d.getR72_amount_services_reserve() == null ? 0
						: brf94d.getR72_amount_services_reserve().intValue());
			}
			Cell R72cell15 = R72row.getCell(17);
			if (R72cell15 != null) {
				R72cell15.setCellValue(brf94d.getR72_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR72_no_of_transactions_trade_reserve().intValue());
			}
			Cell R72cell16 = R72row.getCell(18);
			if (R72cell16 != null) {
				R72cell16.setCellValue(brf94d.getR72_amount_trade_reserve() == null ? 0
						: brf94d.getR72_amount_trade_reserve().intValue());
			}
			Cell R72cell17 = R72row.getCell(19);
			if (R72cell17 != null) {
				R72cell17.setCellValue(brf94d.getR72_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR72_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R72cell18 = R72row.getCell(20);
			if (R72cell18 != null) {
				R72cell18.setCellValue(brf94d.getR72_amount_financial_investment_gre() == null ? 0
						: brf94d.getR72_amount_financial_investment_gre().intValue());
			}
			Cell R72cell19 = R72row.getCell(21);
			if (R72cell19 != null) {
				R72cell19.setCellValue(brf94d.getR72_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR72_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R72cell20 = R72row.getCell(22);
			if (R72cell20 != null) {
				R72cell20.setCellValue(brf94d.getR72_amount_direct_investment_gre() == null ? 0
						: brf94d.getR72_amount_direct_investment_gre().intValue());
			}
			Cell R72cell21 = R72row.getCell(23);
			if (R72cell21 != null) {
				R72cell21.setCellValue(brf94d.getR72_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR72_no_of_transactions_services_gre().intValue());
			}
			Cell R72cell22 = R72row.getCell(24);
			if (R72cell22 != null) {
				R72cell22.setCellValue(brf94d.getR72_amount_services_gre() == null ? 0
						: brf94d.getR72_amount_services_gre().intValue());
			}
			Cell R72cell23 = R72row.getCell(25);
			if (R72cell23 != null) {
				R72cell23.setCellValue(brf94d.getR72_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR72_no_of_transactions_trade_gre().intValue());
			}
			Cell R72cell24 = R72row.getCell(26);
			if (R72cell24 != null) {
				R72cell24.setCellValue(
						brf94d.getR72_amount_trade_gre() == null ? 0 : brf94d.getR72_amount_trade_gre().intValue());
			}
			Cell R72cell25 = R72row.getCell(27);
			if (R72cell25 != null) {
				R72cell25.setCellValue(brf94d.getR72_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR72_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R72cell26 = R72row.getCell(28);
			if (R72cell26 != null) {
				R72cell26.setCellValue(brf94d.getR72_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR72_amount_financial_investment_corporate().intValue());
			}
			Cell R72cell27 = R72row.getCell(29);
			if (R72cell27 != null) {
				R72cell27.setCellValue(brf94d.getR72_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR72_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R72cell28 = R72row.getCell(30);
			if (R72cell28 != null) {
				R72cell28.setCellValue(brf94d.getR72_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR72_amount_direct_investment_corporate().intValue());
			}
			Cell R72cell29 = R72row.getCell(31);
			if (R72cell29 != null) {
				R72cell29.setCellValue(brf94d.getR72_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR72_no_of_transactions_services_corporate().intValue());
			}
			Cell R72cell30 = R72row.getCell(32);
			if (R72cell30 != null) {
				R72cell30.setCellValue(brf94d.getR72_amount_services_corporate() == null ? 0
						: brf94d.getR72_amount_services_corporate().intValue());
			}
			Cell R72cell31 = R72row.getCell(33);
			if (R72cell31 != null) {
				R72cell31.setCellValue(brf94d.getR72_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR72_no_of_transactions_trade_corporate().intValue());
			}
			Cell R72cell32 = R72row.getCell(34);
			if (R72cell32 != null) {
				R72cell32.setCellValue(brf94d.getR72_amount_trade_corporate() == null ? 0
						: brf94d.getR72_amount_trade_corporate().intValue());
			}
			Cell R72cell33 = R72row.getCell(35);
			if (R72cell33 != null) {
				R72cell33.setCellValue(brf94d.getR72_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR72_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R72cell34 = R72row.getCell(36);
			if (R72cell34 != null) {
				R72cell34.setCellValue(brf94d.getR72_amount_financial_investment_sme() == null ? 0
						: brf94d.getR72_amount_financial_investment_sme().intValue());
			}
			Cell R72cell35 = R72row.getCell(37);
			if (R72cell35 != null) {
				R72cell35.setCellValue(brf94d.getR72_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR72_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R72cell36 = R72row.getCell(38);
			if (R72cell36 != null) {
				R72cell36.setCellValue(brf94d.getR72_amount_direct_investment_sme() == null ? 0
						: brf94d.getR72_amount_direct_investment_sme().intValue());
			}
			Cell R72cell37 = R72row.getCell(39);
			if (R72cell37 != null) {
				R72cell37.setCellValue(brf94d.getR72_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR72_no_of_transactions_services_sme().intValue());
			}
			Cell R72cell38 = R72row.getCell(40);
			if (R72cell38 != null) {
				R72cell38.setCellValue(brf94d.getR72_amount_services_sme() == null ? 0
						: brf94d.getR72_amount_services_sme().intValue());
			}
			Cell R72cell39 = R72row.getCell(41);
			if (R72cell39 != null) {
				R72cell39.setCellValue(brf94d.getR72_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR72_no_of_transactions_trade_sme().intValue());
			}
			Cell R72cell40 = R72row.getCell(42);
			if (R72cell40 != null) {
				R72cell40.setCellValue(
						brf94d.getR72_amount_trade_sme() == null ? 0 : brf94d.getR72_amount_trade_sme().intValue());
			}
			Cell R72cell41 = R72row.getCell(43);
			if (R72cell41 != null) {
				R72cell41.setCellValue(brf94d.getR72_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R72cell42 = R72row.getCell(44);
			if (R72cell42 != null) {
				R72cell42.setCellValue(brf94d.getR72_amount_financial_investment_individual() == null ? 0
						: brf94d.getR72_amount_financial_investment_individual().intValue());
			}
			Cell R72cell43 = R72row.getCell(45);
			if (R72cell43 != null) {
				R72cell43.setCellValue(brf94d.getR72_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R72cell44 = R72row.getCell(46);
			if (R72cell44 != null) {
				R72cell44.setCellValue(brf94d.getR72_amount_direct_investment_individual() == null ? 0
						: brf94d.getR72_amount_direct_investment_individual().intValue());
			}
			Cell R72cell45 = R72row.getCell(47);
			if (R72cell45 != null) {
				R72cell45.setCellValue(brf94d.getR72_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_family_support_individual().intValue());
			}
			Cell R72cell46 = R72row.getCell(48);
			if (R72cell46 != null) {
				R72cell46.setCellValue(brf94d.getR72_amount_family_support_individual() == null ? 0
						: brf94d.getR72_amount_family_support_individual().intValue());
			}
			Cell R72cell47 = R72row.getCell(49);
			if (R72cell47 != null) {
				R72cell47.setCellValue(brf94d.getR72_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_education_individual().intValue());
			}
			Cell R72cell48 = R72row.getCell(50);
			if (R72cell48 != null) {
				R72cell48.setCellValue(brf94d.getR72_amount_education_individual() == null ? 0
						: brf94d.getR72_amount_education_individual().intValue());
			}
			Cell R72cell49 = R72row.getCell(51);
			if (R72cell49 != null) {
				R72cell49.setCellValue(brf94d.getR72_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_medical_individual().intValue());
			}

			Cell R72cell50 = R72row.getCell(52);
			if (R72cell50 != null) {
				R72cell50.setCellValue(brf94d.getR72_amount_medical_individual() == null ? 0
						: brf94d.getR72_amount_medical_individual().intValue());
			}
			Cell R72cell51 = R72row.getCell(53);
			if (R72cell51 != null) {
				R72cell51.setCellValue(brf94d.getR72_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_tourism_individual().intValue());
			}
			Cell R72cell52 = R72row.getCell(54);
			if (R72cell52 != null) {
				R72cell52.setCellValue(brf94d.getR72_amount_tourism_individual() == null ? 0
						: brf94d.getR72_amount_tourism_individual().intValue());
			}
			Cell R72cell53 = R72row.getCell(55);
			if (R72cell53 != null) {
				R72cell53.setCellValue(brf94d.getR72_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R72cell54 = R72row.getCell(56);
			if (R72cell54 != null) {
				R72cell54.setCellValue(brf94d.getR72_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR72_amount_debt_settlement_individual().intValue());
			}
			Cell R72cell55 = R72row.getCell(57);
			if (R72cell55 != null) {
				R72cell55.setCellValue(brf94d.getR72_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR72_no_of_transactions_other_services_individual().intValue());
			}

			Cell R72cell56 = R72row.getCell(58);
			if (R72cell56 != null) {
				R72cell56.setCellValue(brf94d.getR72_amount_other_services_individual() == null ? 0
						: brf94d.getR72_amount_other_services_individual().intValue());
			}

			Row R73row = sheet.getRow(81);
			Cell R73cell1 = R73row.getCell(3);
			if (R73cell1 != null) {
				R73cell1.setCellValue(brf94d.getR73_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR73_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R73cell2 = R73row.getCell(4);
			if (R73cell2 != null) {
				R73cell2.setCellValue(brf94d.getR73_amount_financial_investment_government() == null ? 0
						: brf94d.getR73_amount_financial_investment_government().intValue());
			}
			Cell R73cell3 = R73row.getCell(5);
			if (R73cell3 != null) {
				R73cell3.setCellValue(brf94d.getR73_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR73_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R73cell4 = R73row.getCell(6);
			if (R73cell4 != null) {
				R73cell4.setCellValue(brf94d.getR73_amount_direct_investment_government() == null ? 0
						: brf94d.getR73_amount_direct_investment_government().intValue());
			}
			Cell R73cell5 = R73row.getCell(7);
			if (R73cell5 != null) {
				R73cell5.setCellValue(brf94d.getR73_no_of_transactions_services_government() == null ? 0
						: brf94d.getR73_no_of_transactions_services_government().intValue());
			}
			Cell R73cell6 = R73row.getCell(8);
			if (R73cell6 != null) {
				R73cell6.setCellValue(brf94d.getR73_amount_services_government() == null ? 0
						: brf94d.getR73_amount_services_government().intValue());
			}
			Cell R73cell7 = R73row.getCell(9);
			if (R73cell7 != null) {
				R73cell7.setCellValue(brf94d.getR73_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR73_no_of_transactions_trade_government().intValue());
			}
			Cell R73cell8 = R73row.getCell(10);
			if (R73cell8 != null) {
				R73cell8.setCellValue(brf94d.getR73_amount_trade_government() == null ? 0
						: brf94d.getR73_amount_trade_government().intValue());
			}
			Cell R73cell9 = R73row.getCell(11);
			if (R73cell9 != null) {
				R73cell9.setCellValue(brf94d.getR73_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR73_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R73cell10 = R73row.getCell(12);
			if (R73cell10 != null) {
				R73cell10.setCellValue(brf94d.getR73_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR73_amount_financial_investment_reserve().intValue());
			}
			Cell R73cell11 = R73row.getCell(13);
			if (R73cell11 != null) {
				R73cell11.setCellValue(brf94d.getR73_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR73_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R73cell12 = R73row.getCell(14);
			if (R73cell12 != null) {
				R73cell12.setCellValue(brf94d.getR73_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR73_amount_direct_investment_reserve().intValue());
			}
			Cell R73cell13 = R73row.getCell(15);
			if (R73cell13 != null) {
				R73cell13.setCellValue(brf94d.getR73_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR73_no_of_transactions_services_reserve().intValue());
			}
			Cell R73cell14 = R73row.getCell(16);
			if (R73cell14 != null) {
				R73cell14.setCellValue(brf94d.getR73_amount_services_reserve() == null ? 0
						: brf94d.getR73_amount_services_reserve().intValue());
			}
			Cell R73cell15 = R73row.getCell(17);
			if (R73cell15 != null) {
				R73cell15.setCellValue(brf94d.getR73_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR73_no_of_transactions_trade_reserve().intValue());
			}
			Cell R73cell16 = R73row.getCell(18);
			if (R73cell16 != null) {
				R73cell16.setCellValue(brf94d.getR73_amount_trade_reserve() == null ? 0
						: brf94d.getR73_amount_trade_reserve().intValue());
			}
			Cell R73cell17 = R73row.getCell(19);
			if (R73cell17 != null) {
				R73cell17.setCellValue(brf94d.getR73_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR73_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R73cell18 = R73row.getCell(20);
			if (R73cell18 != null) {
				R73cell18.setCellValue(brf94d.getR73_amount_financial_investment_gre() == null ? 0
						: brf94d.getR73_amount_financial_investment_gre().intValue());
			}
			Cell R73cell19 = R73row.getCell(21);
			if (R73cell19 != null) {
				R73cell19.setCellValue(brf94d.getR73_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR73_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R73cell20 = R73row.getCell(22);
			if (R73cell20 != null) {
				R73cell20.setCellValue(brf94d.getR73_amount_direct_investment_gre() == null ? 0
						: brf94d.getR73_amount_direct_investment_gre().intValue());
			}
			Cell R73cell21 = R73row.getCell(23);
			if (R73cell21 != null) {
				R73cell21.setCellValue(brf94d.getR73_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR73_no_of_transactions_services_gre().intValue());
			}
			Cell R73cell22 = R73row.getCell(24);
			if (R73cell22 != null) {
				R73cell22.setCellValue(brf94d.getR73_amount_services_gre() == null ? 0
						: brf94d.getR73_amount_services_gre().intValue());
			}
			Cell R73cell23 = R73row.getCell(25);
			if (R73cell23 != null) {
				R73cell23.setCellValue(brf94d.getR73_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR73_no_of_transactions_trade_gre().intValue());
			}
			Cell R73cell24 = R73row.getCell(26);
			if (R73cell24 != null) {
				R73cell24.setCellValue(
						brf94d.getR73_amount_trade_gre() == null ? 0 : brf94d.getR73_amount_trade_gre().intValue());
			}
			Cell R73cell25 = R73row.getCell(27);
			if (R73cell25 != null) {
				R73cell25.setCellValue(brf94d.getR73_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR73_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R73cell26 = R73row.getCell(28);
			if (R73cell26 != null) {
				R73cell26.setCellValue(brf94d.getR73_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR73_amount_financial_investment_corporate().intValue());
			}
			Cell R73cell27 = R73row.getCell(29);
			if (R73cell27 != null) {
				R73cell27.setCellValue(brf94d.getR73_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR73_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R73cell28 = R73row.getCell(30);
			if (R73cell28 != null) {
				R73cell28.setCellValue(brf94d.getR73_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR73_amount_direct_investment_corporate().intValue());
			}
			Cell R73cell29 = R73row.getCell(31);
			if (R73cell29 != null) {
				R73cell29.setCellValue(brf94d.getR73_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR73_no_of_transactions_services_corporate().intValue());
			}
			Cell R73cell30 = R73row.getCell(32);
			if (R73cell30 != null) {
				R73cell30.setCellValue(brf94d.getR73_amount_services_corporate() == null ? 0
						: brf94d.getR73_amount_services_corporate().intValue());
			}
			Cell R73cell31 = R73row.getCell(33);
			if (R73cell31 != null) {
				R73cell31.setCellValue(brf94d.getR73_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR73_no_of_transactions_trade_corporate().intValue());
			}
			Cell R73cell32 = R73row.getCell(34);
			if (R73cell32 != null) {
				R73cell32.setCellValue(brf94d.getR73_amount_trade_corporate() == null ? 0
						: brf94d.getR73_amount_trade_corporate().intValue());
			}
			Cell R73cell33 = R73row.getCell(35);
			if (R73cell33 != null) {
				R73cell33.setCellValue(brf94d.getR73_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR73_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R73cell34 = R73row.getCell(36);
			if (R73cell34 != null) {
				R73cell34.setCellValue(brf94d.getR73_amount_financial_investment_sme() == null ? 0
						: brf94d.getR73_amount_financial_investment_sme().intValue());
			}
			Cell R73cell35 = R73row.getCell(37);
			if (R73cell35 != null) {
				R73cell35.setCellValue(brf94d.getR73_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR73_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R73cell36 = R73row.getCell(38);
			if (R73cell36 != null) {
				R73cell36.setCellValue(brf94d.getR73_amount_direct_investment_sme() == null ? 0
						: brf94d.getR73_amount_direct_investment_sme().intValue());
			}
			Cell R73cell37 = R73row.getCell(39);
			if (R73cell37 != null) {
				R73cell37.setCellValue(brf94d.getR73_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR73_no_of_transactions_services_sme().intValue());
			}
			Cell R73cell38 = R73row.getCell(40);
			if (R73cell38 != null) {
				R73cell38.setCellValue(brf94d.getR73_amount_services_sme() == null ? 0
						: brf94d.getR73_amount_services_sme().intValue());
			}
			Cell R73cell39 = R73row.getCell(41);
			if (R73cell39 != null) {
				R73cell39.setCellValue(brf94d.getR73_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR73_no_of_transactions_trade_sme().intValue());
			}
			Cell R73cell40 = R73row.getCell(42);
			if (R73cell40 != null) {
				R73cell40.setCellValue(
						brf94d.getR73_amount_trade_sme() == null ? 0 : brf94d.getR73_amount_trade_sme().intValue());
			}
			Cell R73cell41 = R73row.getCell(43);
			if (R73cell41 != null) {
				R73cell41.setCellValue(brf94d.getR73_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R73cell42 = R73row.getCell(44);
			if (R73cell42 != null) {
				R73cell42.setCellValue(brf94d.getR73_amount_financial_investment_individual() == null ? 0
						: brf94d.getR73_amount_financial_investment_individual().intValue());
			}
			Cell R73cell43 = R73row.getCell(45);
			if (R73cell43 != null) {
				R73cell43.setCellValue(brf94d.getR73_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R73cell44 = R73row.getCell(46);
			if (R73cell44 != null) {
				R73cell44.setCellValue(brf94d.getR73_amount_direct_investment_individual() == null ? 0
						: brf94d.getR73_amount_direct_investment_individual().intValue());
			}
			Cell R73cell45 = R73row.getCell(47);
			if (R73cell45 != null) {
				R73cell45.setCellValue(brf94d.getR73_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_family_support_individual().intValue());
			}
			Cell R73cell46 = R73row.getCell(48);
			if (R73cell46 != null) {
				R73cell46.setCellValue(brf94d.getR73_amount_family_support_individual() == null ? 0
						: brf94d.getR73_amount_family_support_individual().intValue());
			}
			Cell R73cell47 = R73row.getCell(49);
			if (R73cell47 != null) {
				R73cell47.setCellValue(brf94d.getR73_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_education_individual().intValue());
			}
			Cell R73cell48 = R73row.getCell(50);
			if (R73cell48 != null) {
				R73cell48.setCellValue(brf94d.getR73_amount_education_individual() == null ? 0
						: brf94d.getR73_amount_education_individual().intValue());
			}
			Cell R73cell49 = R73row.getCell(51);
			if (R73cell49 != null) {
				R73cell49.setCellValue(brf94d.getR73_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_medical_individual().intValue());
			}

			Cell R73cell50 = R73row.getCell(52);
			if (R73cell50 != null) {
				R73cell50.setCellValue(brf94d.getR73_amount_medical_individual() == null ? 0
						: brf94d.getR73_amount_medical_individual().intValue());
			}
			Cell R73cell51 = R73row.getCell(53);
			if (R73cell51 != null) {
				R73cell51.setCellValue(brf94d.getR73_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_tourism_individual().intValue());
			}
			Cell R73cell52 = R73row.getCell(54);
			if (R73cell52 != null) {
				R73cell52.setCellValue(brf94d.getR73_amount_tourism_individual() == null ? 0
						: brf94d.getR73_amount_tourism_individual().intValue());
			}
			Cell R73cell53 = R73row.getCell(55);
			if (R73cell53 != null) {
				R73cell53.setCellValue(brf94d.getR73_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R73cell54 = R73row.getCell(56);
			if (R73cell54 != null) {
				R73cell54.setCellValue(brf94d.getR73_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR73_amount_debt_settlement_individual().intValue());
			}
			Cell R73cell55 = R73row.getCell(57);
			if (R73cell55 != null) {
				R73cell55.setCellValue(brf94d.getR73_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR73_no_of_transactions_other_services_individual().intValue());
			}

			Cell R73cell56 = R73row.getCell(58);
			if (R73cell56 != null) {
				R73cell56.setCellValue(brf94d.getR73_amount_other_services_individual() == null ? 0
						: brf94d.getR73_amount_other_services_individual().intValue());
			}

			Row R74row = sheet.getRow(82);
			Cell R74cell1 = R74row.getCell(3);
			if (R74cell1 != null) {
				R74cell1.setCellValue(brf94d.getR74_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR74_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R74cell2 = R74row.getCell(4);
			if (R74cell2 != null) {
				R74cell2.setCellValue(brf94d.getR74_amount_financial_investment_government() == null ? 0
						: brf94d.getR74_amount_financial_investment_government().intValue());
			}
			Cell R74cell3 = R74row.getCell(5);
			if (R74cell3 != null) {
				R74cell3.setCellValue(brf94d.getR74_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR74_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R74cell4 = R74row.getCell(6);
			if (R74cell4 != null) {
				R74cell4.setCellValue(brf94d.getR74_amount_direct_investment_government() == null ? 0
						: brf94d.getR74_amount_direct_investment_government().intValue());
			}
			Cell R74cell5 = R74row.getCell(7);
			if (R74cell5 != null) {
				R74cell5.setCellValue(brf94d.getR74_no_of_transactions_services_government() == null ? 0
						: brf94d.getR74_no_of_transactions_services_government().intValue());
			}
			Cell R74cell6 = R74row.getCell(8);
			if (R74cell6 != null) {
				R74cell6.setCellValue(brf94d.getR74_amount_services_government() == null ? 0
						: brf94d.getR74_amount_services_government().intValue());
			}
			Cell R74cell7 = R74row.getCell(9);
			if (R74cell7 != null) {
				R74cell7.setCellValue(brf94d.getR74_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR74_no_of_transactions_trade_government().intValue());
			}
			Cell R74cell8 = R74row.getCell(10);
			if (R74cell8 != null) {
				R74cell8.setCellValue(brf94d.getR74_amount_trade_government() == null ? 0
						: brf94d.getR74_amount_trade_government().intValue());
			}
			Cell R74cell9 = R74row.getCell(11);
			if (R74cell9 != null) {
				R74cell9.setCellValue(brf94d.getR74_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR74_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R74cell10 = R74row.getCell(12);
			if (R74cell10 != null) {
				R74cell10.setCellValue(brf94d.getR74_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR74_amount_financial_investment_reserve().intValue());
			}
			Cell R74cell11 = R74row.getCell(13);
			if (R74cell11 != null) {
				R74cell11.setCellValue(brf94d.getR74_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR74_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R74cell12 = R74row.getCell(14);
			if (R74cell12 != null) {
				R74cell12.setCellValue(brf94d.getR74_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR74_amount_direct_investment_reserve().intValue());
			}
			Cell R74cell13 = R74row.getCell(15);
			if (R74cell13 != null) {
				R74cell13.setCellValue(brf94d.getR74_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR74_no_of_transactions_services_reserve().intValue());
			}
			Cell R74cell14 = R74row.getCell(16);
			if (R74cell14 != null) {
				R74cell14.setCellValue(brf94d.getR74_amount_services_reserve() == null ? 0
						: brf94d.getR74_amount_services_reserve().intValue());
			}
			Cell R74cell15 = R74row.getCell(17);
			if (R74cell15 != null) {
				R74cell15.setCellValue(brf94d.getR74_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR74_no_of_transactions_trade_reserve().intValue());
			}
			Cell R74cell16 = R74row.getCell(18);
			if (R74cell16 != null) {
				R74cell16.setCellValue(brf94d.getR74_amount_trade_reserve() == null ? 0
						: brf94d.getR74_amount_trade_reserve().intValue());
			}
			Cell R74cell17 = R74row.getCell(19);
			if (R74cell17 != null) {
				R74cell17.setCellValue(brf94d.getR74_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR74_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R74cell18 = R74row.getCell(20);
			if (R74cell18 != null) {
				R74cell18.setCellValue(brf94d.getR74_amount_financial_investment_gre() == null ? 0
						: brf94d.getR74_amount_financial_investment_gre().intValue());
			}
			Cell R74cell19 = R74row.getCell(21);
			if (R74cell19 != null) {
				R74cell19.setCellValue(brf94d.getR74_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR74_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R74cell20 = R74row.getCell(22);
			if (R74cell20 != null) {
				R74cell20.setCellValue(brf94d.getR74_amount_direct_investment_gre() == null ? 0
						: brf94d.getR74_amount_direct_investment_gre().intValue());
			}
			Cell R74cell21 = R74row.getCell(23);
			if (R74cell21 != null) {
				R74cell21.setCellValue(brf94d.getR74_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR74_no_of_transactions_services_gre().intValue());
			}
			Cell R74cell22 = R74row.getCell(24);
			if (R74cell22 != null) {
				R74cell22.setCellValue(brf94d.getR74_amount_services_gre() == null ? 0
						: brf94d.getR74_amount_services_gre().intValue());
			}
			Cell R74cell23 = R74row.getCell(25);
			if (R74cell23 != null) {
				R74cell23.setCellValue(brf94d.getR74_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR74_no_of_transactions_trade_gre().intValue());
			}
			Cell R74cell24 = R74row.getCell(26);
			if (R74cell24 != null) {
				R74cell24.setCellValue(
						brf94d.getR74_amount_trade_gre() == null ? 0 : brf94d.getR74_amount_trade_gre().intValue());
			}
			Cell R74cell25 = R74row.getCell(27);
			if (R74cell25 != null) {
				R74cell25.setCellValue(brf94d.getR74_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR74_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R74cell26 = R74row.getCell(28);
			if (R74cell26 != null) {
				R74cell26.setCellValue(brf94d.getR74_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR74_amount_financial_investment_corporate().intValue());
			}
			Cell R74cell27 = R74row.getCell(29);
			if (R74cell27 != null) {
				R74cell27.setCellValue(brf94d.getR74_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR74_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R74cell28 = R74row.getCell(30);
			if (R74cell28 != null) {
				R74cell28.setCellValue(brf94d.getR74_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR74_amount_direct_investment_corporate().intValue());
			}
			Cell R74cell29 = R74row.getCell(31);
			if (R74cell29 != null) {
				R74cell29.setCellValue(brf94d.getR74_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR74_no_of_transactions_services_corporate().intValue());
			}
			Cell R74cell30 = R74row.getCell(32);
			if (R74cell30 != null) {
				R74cell30.setCellValue(brf94d.getR74_amount_services_corporate() == null ? 0
						: brf94d.getR74_amount_services_corporate().intValue());
			}
			Cell R74cell31 = R74row.getCell(33);
			if (R74cell31 != null) {
				R74cell31.setCellValue(brf94d.getR74_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR74_no_of_transactions_trade_corporate().intValue());
			}
			Cell R74cell32 = R74row.getCell(34);
			if (R74cell32 != null) {
				R74cell32.setCellValue(brf94d.getR74_amount_trade_corporate() == null ? 0
						: brf94d.getR74_amount_trade_corporate().intValue());
			}
			Cell R74cell33 = R74row.getCell(35);
			if (R74cell33 != null) {
				R74cell33.setCellValue(brf94d.getR74_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR74_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R74cell34 = R74row.getCell(36);
			if (R74cell34 != null) {
				R74cell34.setCellValue(brf94d.getR74_amount_financial_investment_sme() == null ? 0
						: brf94d.getR74_amount_financial_investment_sme().intValue());
			}
			Cell R74cell35 = R74row.getCell(37);
			if (R74cell35 != null) {
				R74cell35.setCellValue(brf94d.getR74_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR74_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R74cell36 = R74row.getCell(38);
			if (R74cell36 != null) {
				R74cell36.setCellValue(brf94d.getR74_amount_direct_investment_sme() == null ? 0
						: brf94d.getR74_amount_direct_investment_sme().intValue());
			}
			Cell R74cell37 = R74row.getCell(39);
			if (R74cell37 != null) {
				R74cell37.setCellValue(brf94d.getR74_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR74_no_of_transactions_services_sme().intValue());
			}
			Cell R74cell38 = R74row.getCell(40);
			if (R74cell38 != null) {
				R74cell38.setCellValue(brf94d.getR74_amount_services_sme() == null ? 0
						: brf94d.getR74_amount_services_sme().intValue());
			}
			Cell R74cell39 = R74row.getCell(41);
			if (R74cell39 != null) {
				R74cell39.setCellValue(brf94d.getR74_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR74_no_of_transactions_trade_sme().intValue());
			}
			Cell R74cell40 = R74row.getCell(42);
			if (R74cell40 != null) {
				R74cell40.setCellValue(
						brf94d.getR74_amount_trade_sme() == null ? 0 : brf94d.getR74_amount_trade_sme().intValue());
			}
			Cell R74cell41 = R74row.getCell(43);
			if (R74cell41 != null) {
				R74cell41.setCellValue(brf94d.getR74_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R74cell42 = R74row.getCell(44);
			if (R74cell42 != null) {
				R74cell42.setCellValue(brf94d.getR74_amount_financial_investment_individual() == null ? 0
						: brf94d.getR74_amount_financial_investment_individual().intValue());
			}
			Cell R74cell43 = R74row.getCell(45);
			if (R74cell43 != null) {
				R74cell43.setCellValue(brf94d.getR74_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R74cell44 = R74row.getCell(46);
			if (R74cell44 != null) {
				R74cell44.setCellValue(brf94d.getR74_amount_direct_investment_individual() == null ? 0
						: brf94d.getR74_amount_direct_investment_individual().intValue());
			}
			Cell R74cell45 = R74row.getCell(47);
			if (R74cell45 != null) {
				R74cell45.setCellValue(brf94d.getR74_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_family_support_individual().intValue());
			}
			Cell R74cell46 = R74row.getCell(48);
			if (R74cell46 != null) {
				R74cell46.setCellValue(brf94d.getR74_amount_family_support_individual() == null ? 0
						: brf94d.getR74_amount_family_support_individual().intValue());
			}
			Cell R74cell47 = R74row.getCell(49);
			if (R74cell47 != null) {
				R74cell47.setCellValue(brf94d.getR74_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_education_individual().intValue());
			}
			Cell R74cell48 = R74row.getCell(50);
			if (R74cell48 != null) {
				R74cell48.setCellValue(brf94d.getR74_amount_education_individual() == null ? 0
						: brf94d.getR74_amount_education_individual().intValue());
			}
			Cell R74cell49 = R74row.getCell(51);
			if (R74cell49 != null) {
				R74cell49.setCellValue(brf94d.getR74_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_medical_individual().intValue());
			}

			Cell R74cell50 = R74row.getCell(52);
			if (R74cell50 != null) {
				R74cell50.setCellValue(brf94d.getR74_amount_medical_individual() == null ? 0
						: brf94d.getR74_amount_medical_individual().intValue());
			}
			Cell R74cell51 = R74row.getCell(53);
			if (R74cell51 != null) {
				R74cell51.setCellValue(brf94d.getR74_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_tourism_individual().intValue());
			}
			Cell R74cell52 = R74row.getCell(54);
			if (R74cell52 != null) {
				R74cell52.setCellValue(brf94d.getR74_amount_tourism_individual() == null ? 0
						: brf94d.getR74_amount_tourism_individual().intValue());
			}
			Cell R74cell53 = R74row.getCell(55);
			if (R74cell53 != null) {
				R74cell53.setCellValue(brf94d.getR74_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R74cell54 = R74row.getCell(56);
			if (R74cell54 != null) {
				R74cell54.setCellValue(brf94d.getR74_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR74_amount_debt_settlement_individual().intValue());
			}
			Cell R74cell55 = R74row.getCell(57);
			if (R74cell55 != null) {
				R74cell55.setCellValue(brf94d.getR74_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR74_no_of_transactions_other_services_individual().intValue());
			}

			Cell R74cell56 = R74row.getCell(58);
			if (R74cell56 != null) {
				R74cell56.setCellValue(brf94d.getR74_amount_other_services_individual() == null ? 0
						: brf94d.getR74_amount_other_services_individual().intValue());
			}

			Row R76row = sheet.getRow(84);
			Cell R76cell1 = R76row.getCell(3);
			if (R76cell1 != null) {
				R76cell1.setCellValue(brf94d.getR76_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR76_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R76cell2 = R76row.getCell(4);
			if (R76cell2 != null) {
				R76cell2.setCellValue(brf94d.getR76_amount_financial_investment_government() == null ? 0
						: brf94d.getR76_amount_financial_investment_government().intValue());
			}
			Cell R76cell3 = R76row.getCell(5);
			if (R76cell3 != null) {
				R76cell3.setCellValue(brf94d.getR76_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR76_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R76cell4 = R76row.getCell(6);
			if (R76cell4 != null) {
				R76cell4.setCellValue(brf94d.getR76_amount_direct_investment_government() == null ? 0
						: brf94d.getR76_amount_direct_investment_government().intValue());
			}
			Cell R76cell5 = R76row.getCell(7);
			if (R76cell5 != null) {
				R76cell5.setCellValue(brf94d.getR76_no_of_transactions_services_government() == null ? 0
						: brf94d.getR76_no_of_transactions_services_government().intValue());
			}
			Cell R76cell6 = R76row.getCell(8);
			if (R76cell6 != null) {
				R76cell6.setCellValue(brf94d.getR76_amount_services_government() == null ? 0
						: brf94d.getR76_amount_services_government().intValue());
			}
			Cell R76cell7 = R76row.getCell(9);
			if (R76cell7 != null) {
				R76cell7.setCellValue(brf94d.getR76_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR76_no_of_transactions_trade_government().intValue());
			}
			Cell R76cell8 = R76row.getCell(10);
			if (R76cell8 != null) {
				R76cell8.setCellValue(brf94d.getR76_amount_trade_government() == null ? 0
						: brf94d.getR76_amount_trade_government().intValue());
			}
			Cell R76cell9 = R76row.getCell(11);
			if (R76cell9 != null) {
				R76cell9.setCellValue(brf94d.getR76_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR76_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R76cell10 = R76row.getCell(12);
			if (R76cell10 != null) {
				R76cell10.setCellValue(brf94d.getR76_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR76_amount_financial_investment_reserve().intValue());
			}
			Cell R76cell11 = R76row.getCell(13);
			if (R76cell11 != null) {
				R76cell11.setCellValue(brf94d.getR76_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR76_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R76cell12 = R76row.getCell(14);
			if (R76cell12 != null) {
				R76cell12.setCellValue(brf94d.getR76_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR76_amount_direct_investment_reserve().intValue());
			}
			Cell R76cell13 = R76row.getCell(15);
			if (R76cell13 != null) {
				R76cell13.setCellValue(brf94d.getR76_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR76_no_of_transactions_services_reserve().intValue());
			}
			Cell R76cell14 = R76row.getCell(16);
			if (R76cell14 != null) {
				R76cell14.setCellValue(brf94d.getR76_amount_services_reserve() == null ? 0
						: brf94d.getR76_amount_services_reserve().intValue());
			}
			Cell R76cell15 = R76row.getCell(17);
			if (R76cell15 != null) {
				R76cell15.setCellValue(brf94d.getR76_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR76_no_of_transactions_trade_reserve().intValue());
			}
			Cell R76cell16 = R76row.getCell(18);
			if (R76cell16 != null) {
				R76cell16.setCellValue(brf94d.getR76_amount_trade_reserve() == null ? 0
						: brf94d.getR76_amount_trade_reserve().intValue());
			}
			Cell R76cell17 = R76row.getCell(19);
			if (R76cell17 != null) {
				R76cell17.setCellValue(brf94d.getR76_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR76_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R76cell18 = R76row.getCell(20);
			if (R76cell18 != null) {
				R76cell18.setCellValue(brf94d.getR76_amount_financial_investment_gre() == null ? 0
						: brf94d.getR76_amount_financial_investment_gre().intValue());
			}
			Cell R76cell19 = R76row.getCell(21);
			if (R76cell19 != null) {
				R76cell19.setCellValue(brf94d.getR76_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR76_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R76cell20 = R76row.getCell(22);
			if (R76cell20 != null) {
				R76cell20.setCellValue(brf94d.getR76_amount_direct_investment_gre() == null ? 0
						: brf94d.getR76_amount_direct_investment_gre().intValue());
			}
			Cell R76cell21 = R76row.getCell(23);
			if (R76cell21 != null) {
				R76cell21.setCellValue(brf94d.getR76_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR76_no_of_transactions_services_gre().intValue());
			}
			Cell R76cell22 = R76row.getCell(24);
			if (R76cell22 != null) {
				R76cell22.setCellValue(brf94d.getR76_amount_services_gre() == null ? 0
						: brf94d.getR76_amount_services_gre().intValue());
			}
			Cell R76cell23 = R76row.getCell(25);
			if (R76cell23 != null) {
				R76cell23.setCellValue(brf94d.getR76_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR76_no_of_transactions_trade_gre().intValue());
			}
			Cell R76cell24 = R76row.getCell(26);
			if (R76cell24 != null) {
				R76cell24.setCellValue(
						brf94d.getR76_amount_trade_gre() == null ? 0 : brf94d.getR76_amount_trade_gre().intValue());
			}
			Cell R76cell25 = R76row.getCell(27);
			if (R76cell25 != null) {
				R76cell25.setCellValue(brf94d.getR76_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR76_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R76cell26 = R76row.getCell(28);
			if (R76cell26 != null) {
				R76cell26.setCellValue(brf94d.getR76_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR76_amount_financial_investment_corporate().intValue());
			}
			Cell R76cell27 = R76row.getCell(29);
			if (R76cell27 != null) {
				R76cell27.setCellValue(brf94d.getR76_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR76_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R76cell28 = R76row.getCell(30);
			if (R76cell28 != null) {
				R76cell28.setCellValue(brf94d.getR76_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR76_amount_direct_investment_corporate().intValue());
			}
			Cell R76cell29 = R76row.getCell(31);
			if (R76cell29 != null) {
				R76cell29.setCellValue(brf94d.getR76_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR76_no_of_transactions_services_corporate().intValue());
			}
			Cell R76cell30 = R76row.getCell(32);
			if (R76cell30 != null) {
				R76cell30.setCellValue(brf94d.getR76_amount_services_corporate() == null ? 0
						: brf94d.getR76_amount_services_corporate().intValue());
			}
			Cell R76cell31 = R76row.getCell(33);
			if (R76cell31 != null) {
				R76cell31.setCellValue(brf94d.getR76_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR76_no_of_transactions_trade_corporate().intValue());
			}
			Cell R76cell32 = R76row.getCell(34);
			if (R76cell32 != null) {
				R76cell32.setCellValue(brf94d.getR76_amount_trade_corporate() == null ? 0
						: brf94d.getR76_amount_trade_corporate().intValue());
			}
			Cell R76cell33 = R76row.getCell(35);
			if (R76cell33 != null) {
				R76cell33.setCellValue(brf94d.getR76_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR76_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R76cell34 = R76row.getCell(36);
			if (R76cell34 != null) {
				R76cell34.setCellValue(brf94d.getR76_amount_financial_investment_sme() == null ? 0
						: brf94d.getR76_amount_financial_investment_sme().intValue());
			}
			Cell R76cell35 = R76row.getCell(37);
			if (R76cell35 != null) {
				R76cell35.setCellValue(brf94d.getR76_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR76_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R76cell36 = R76row.getCell(38);
			if (R76cell36 != null) {
				R76cell36.setCellValue(brf94d.getR76_amount_direct_investment_sme() == null ? 0
						: brf94d.getR76_amount_direct_investment_sme().intValue());
			}
			Cell R76cell37 = R76row.getCell(39);
			if (R76cell37 != null) {
				R76cell37.setCellValue(brf94d.getR76_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR76_no_of_transactions_services_sme().intValue());
			}
			Cell R76cell38 = R76row.getCell(40);
			if (R76cell38 != null) {
				R76cell38.setCellValue(brf94d.getR76_amount_services_sme() == null ? 0
						: brf94d.getR76_amount_services_sme().intValue());
			}
			Cell R76cell39 = R76row.getCell(41);
			if (R76cell39 != null) {
				R76cell39.setCellValue(brf94d.getR76_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR76_no_of_transactions_trade_sme().intValue());
			}
			Cell R76cell40 = R76row.getCell(42);
			if (R76cell40 != null) {
				R76cell40.setCellValue(
						brf94d.getR76_amount_trade_sme() == null ? 0 : brf94d.getR76_amount_trade_sme().intValue());
			}
			Cell R76cell41 = R76row.getCell(43);
			if (R76cell41 != null) {
				R76cell41.setCellValue(brf94d.getR76_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R76cell42 = R76row.getCell(44);
			if (R76cell42 != null) {
				R76cell42.setCellValue(brf94d.getR76_amount_financial_investment_individual() == null ? 0
						: brf94d.getR76_amount_financial_investment_individual().intValue());
			}
			Cell R76cell43 = R76row.getCell(45);
			if (R76cell43 != null) {
				R76cell43.setCellValue(brf94d.getR76_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R76cell44 = R76row.getCell(46);
			if (R76cell44 != null) {
				R76cell44.setCellValue(brf94d.getR76_amount_direct_investment_individual() == null ? 0
						: brf94d.getR76_amount_direct_investment_individual().intValue());
			}
			Cell R76cell45 = R76row.getCell(47);
			if (R76cell45 != null) {
				R76cell45.setCellValue(brf94d.getR76_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_family_support_individual().intValue());
			}
			Cell R76cell46 = R76row.getCell(48);
			if (R76cell46 != null) {
				R76cell46.setCellValue(brf94d.getR76_amount_family_support_individual() == null ? 0
						: brf94d.getR76_amount_family_support_individual().intValue());
			}
			Cell R76cell47 = R76row.getCell(49);
			if (R76cell47 != null) {
				R76cell47.setCellValue(brf94d.getR76_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_education_individual().intValue());
			}
			Cell R76cell48 = R76row.getCell(50);
			if (R76cell48 != null) {
				R76cell48.setCellValue(brf94d.getR76_amount_education_individual() == null ? 0
						: brf94d.getR76_amount_education_individual().intValue());
			}
			Cell R76cell49 = R76row.getCell(51);
			if (R76cell49 != null) {
				R76cell49.setCellValue(brf94d.getR76_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_medical_individual().intValue());
			}

			Cell R76cell50 = R76row.getCell(52);
			if (R76cell50 != null) {
				R76cell50.setCellValue(brf94d.getR76_amount_medical_individual() == null ? 0
						: brf94d.getR76_amount_medical_individual().intValue());
			}
			Cell R76cell51 = R76row.getCell(53);
			if (R76cell51 != null) {
				R76cell51.setCellValue(brf94d.getR76_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_tourism_individual().intValue());
			}
			Cell R76cell52 = R76row.getCell(54);
			if (R76cell52 != null) {
				R76cell52.setCellValue(brf94d.getR76_amount_tourism_individual() == null ? 0
						: brf94d.getR76_amount_tourism_individual().intValue());
			}
			Cell R76cell53 = R76row.getCell(55);
			if (R76cell53 != null) {
				R76cell53.setCellValue(brf94d.getR76_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R76cell54 = R76row.getCell(56);
			if (R76cell54 != null) {
				R76cell54.setCellValue(brf94d.getR76_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR76_amount_debt_settlement_individual().intValue());
			}
			Cell R76cell55 = R76row.getCell(57);
			if (R76cell55 != null) {
				R76cell55.setCellValue(brf94d.getR76_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR76_no_of_transactions_other_services_individual().intValue());
			}

			Cell R76cell56 = R76row.getCell(58);
			if (R76cell56 != null) {
				R76cell56.setCellValue(brf94d.getR76_amount_other_services_individual() == null ? 0
						: brf94d.getR76_amount_other_services_individual().intValue());
			}

			Row R77row = sheet.getRow(85);
			Cell R77cell1 = R77row.getCell(3);
			if (R77cell1 != null) {
				R77cell1.setCellValue(brf94d.getR77_no_of_transactions_financial_investment_government() == null ? 0
						: brf94d.getR77_no_of_transactions_financial_investment_government().intValue());
			}

			Cell R77cell2 = R77row.getCell(4);
			if (R77cell2 != null) {
				R77cell2.setCellValue(brf94d.getR77_amount_financial_investment_government() == null ? 0
						: brf94d.getR77_amount_financial_investment_government().intValue());
			}
			Cell R77cell3 = R77row.getCell(5);
			if (R77cell3 != null) {
				R77cell3.setCellValue(brf94d.getR77_no_of_transactions_direct_investment_government() == null ? 0
						: brf94d.getR77_no_of_transactions_direct_investment_government().intValue());
			}
			Cell R77cell4 = R77row.getCell(6);
			if (R77cell4 != null) {
				R77cell4.setCellValue(brf94d.getR77_amount_direct_investment_government() == null ? 0
						: brf94d.getR77_amount_direct_investment_government().intValue());
			}
			Cell R77cell5 = R77row.getCell(7);
			if (R77cell5 != null) {
				R77cell5.setCellValue(brf94d.getR77_no_of_transactions_services_government() == null ? 0
						: brf94d.getR77_no_of_transactions_services_government().intValue());
			}
			Cell R77cell6 = R77row.getCell(8);
			if (R77cell6 != null) {
				R77cell6.setCellValue(brf94d.getR77_amount_services_government() == null ? 0
						: brf94d.getR77_amount_services_government().intValue());
			}
			Cell R77cell7 = R77row.getCell(9);
			if (R77cell7 != null) {
				R77cell7.setCellValue(brf94d.getR77_no_of_transactions_trade_government() == null ? 0
						: brf94d.getR77_no_of_transactions_trade_government().intValue());
			}
			Cell R77cell8 = R77row.getCell(10);
			if (R77cell8 != null) {
				R77cell8.setCellValue(brf94d.getR77_amount_trade_government() == null ? 0
						: brf94d.getR77_amount_trade_government().intValue());
			}
			Cell R77cell9 = R77row.getCell(11);
			if (R77cell9 != null) {
				R77cell9.setCellValue(brf94d.getR77_no_of_transactions_financial_investment_reserve() == null ? 0
						: brf94d.getR77_no_of_transactions_financial_investment_reserve().intValue());
			}
			Cell R77cell10 = R77row.getCell(12);
			if (R77cell10 != null) {
				R77cell10.setCellValue(brf94d.getR77_amount_financial_investment_reserve() == null ? 0
						: brf94d.getR77_amount_financial_investment_reserve().intValue());
			}
			Cell R77cell11 = R77row.getCell(13);
			if (R77cell11 != null) {
				R77cell11.setCellValue(brf94d.getR77_no_of_transactions_direct_investment_reserve() == null ? 0
						: brf94d.getR77_no_of_transactions_direct_investment_reserve().intValue());
			}
			Cell R77cell12 = R77row.getCell(14);
			if (R77cell12 != null) {
				R77cell12.setCellValue(brf94d.getR77_amount_direct_investment_reserve() == null ? 0
						: brf94d.getR77_amount_direct_investment_reserve().intValue());
			}
			Cell R77cell13 = R77row.getCell(15);
			if (R77cell13 != null) {
				R77cell13.setCellValue(brf94d.getR77_no_of_transactions_services_reserve() == null ? 0
						: brf94d.getR77_no_of_transactions_services_reserve().intValue());
			}
			Cell R77cell14 = R77row.getCell(16);
			if (R77cell14 != null) {
				R77cell14.setCellValue(brf94d.getR77_amount_services_reserve() == null ? 0
						: brf94d.getR77_amount_services_reserve().intValue());
			}
			Cell R77cell15 = R77row.getCell(17);
			if (R77cell15 != null) {
				R77cell15.setCellValue(brf94d.getR77_no_of_transactions_trade_reserve() == null ? 0
						: brf94d.getR77_no_of_transactions_trade_reserve().intValue());
			}
			Cell R77cell16 = R77row.getCell(18);
			if (R77cell16 != null) {
				R77cell16.setCellValue(brf94d.getR77_amount_trade_reserve() == null ? 0
						: brf94d.getR77_amount_trade_reserve().intValue());
			}
			Cell R77cell17 = R77row.getCell(19);
			if (R77cell17 != null) {
				R77cell17.setCellValue(brf94d.getR77_no_of_transactions_financial_investment_gre() == null ? 0
						: brf94d.getR77_no_of_transactions_financial_investment_gre().intValue());
			}
			Cell R77cell18 = R77row.getCell(20);
			if (R77cell18 != null) {
				R77cell18.setCellValue(brf94d.getR77_amount_financial_investment_gre() == null ? 0
						: brf94d.getR77_amount_financial_investment_gre().intValue());
			}
			Cell R77cell19 = R77row.getCell(21);
			if (R77cell19 != null) {
				R77cell19.setCellValue(brf94d.getR77_no_of_transactions_direct_investment_gre() == null ? 0
						: brf94d.getR77_no_of_transactions_direct_investment_gre().intValue());
			}
			Cell R77cell20 = R77row.getCell(22);
			if (R77cell20 != null) {
				R77cell20.setCellValue(brf94d.getR77_amount_direct_investment_gre() == null ? 0
						: brf94d.getR77_amount_direct_investment_gre().intValue());
			}
			Cell R77cell21 = R77row.getCell(23);
			if (R77cell21 != null) {
				R77cell21.setCellValue(brf94d.getR77_no_of_transactions_services_gre() == null ? 0
						: brf94d.getR77_no_of_transactions_services_gre().intValue());
			}
			Cell R77cell22 = R77row.getCell(24);
			if (R77cell22 != null) {
				R77cell22.setCellValue(brf94d.getR77_amount_services_gre() == null ? 0
						: brf94d.getR77_amount_services_gre().intValue());
			}
			Cell R77cell23 = R77row.getCell(25);
			if (R77cell23 != null) {
				R77cell23.setCellValue(brf94d.getR77_no_of_transactions_trade_gre() == null ? 0
						: brf94d.getR77_no_of_transactions_trade_gre().intValue());
			}
			Cell R77cell24 = R77row.getCell(26);
			if (R77cell24 != null) {
				R77cell24.setCellValue(
						brf94d.getR77_amount_trade_gre() == null ? 0 : brf94d.getR77_amount_trade_gre().intValue());
			}
			Cell R77cell25 = R77row.getCell(27);
			if (R77cell25 != null) {
				R77cell25.setCellValue(brf94d.getR77_no_of_transactions_financial_investment_corporate() == null ? 0
						: brf94d.getR77_no_of_transactions_financial_investment_corporate().intValue());
			}
			Cell R77cell26 = R77row.getCell(28);
			if (R77cell26 != null) {
				R77cell26.setCellValue(brf94d.getR77_amount_financial_investment_corporate() == null ? 0
						: brf94d.getR77_amount_financial_investment_corporate().intValue());
			}
			Cell R77cell27 = R77row.getCell(29);
			if (R77cell27 != null) {
				R77cell27.setCellValue(brf94d.getR77_no_of_transactions_direct_investment_corporate() == null ? 0
						: brf94d.getR77_no_of_transactions_direct_investment_corporate().intValue());
			}
			Cell R77cell28 = R77row.getCell(30);
			if (R77cell28 != null) {
				R77cell28.setCellValue(brf94d.getR77_amount_direct_investment_corporate() == null ? 0
						: brf94d.getR77_amount_direct_investment_corporate().intValue());
			}
			Cell R77cell29 = R77row.getCell(31);
			if (R77cell29 != null) {
				R77cell29.setCellValue(brf94d.getR77_no_of_transactions_services_corporate() == null ? 0
						: brf94d.getR77_no_of_transactions_services_corporate().intValue());
			}
			Cell R77cell30 = R77row.getCell(32);
			if (R77cell30 != null) {
				R77cell30.setCellValue(brf94d.getR77_amount_services_corporate() == null ? 0
						: brf94d.getR77_amount_services_corporate().intValue());
			}
			Cell R77cell31 = R77row.getCell(33);
			if (R77cell31 != null) {
				R77cell31.setCellValue(brf94d.getR77_no_of_transactions_trade_corporate() == null ? 0
						: brf94d.getR77_no_of_transactions_trade_corporate().intValue());
			}
			Cell R77cell32 = R77row.getCell(34);
			if (R77cell32 != null) {
				R77cell32.setCellValue(brf94d.getR77_amount_trade_corporate() == null ? 0
						: brf94d.getR77_amount_trade_corporate().intValue());
			}
			Cell R77cell33 = R77row.getCell(35);
			if (R77cell33 != null) {
				R77cell33.setCellValue(brf94d.getR77_no_of_transactions_financial_investment_sme() == null ? 0
						: brf94d.getR77_no_of_transactions_financial_investment_sme().intValue());
			}
			Cell R77cell34 = R77row.getCell(36);
			if (R77cell34 != null) {
				R77cell34.setCellValue(brf94d.getR77_amount_financial_investment_sme() == null ? 0
						: brf94d.getR77_amount_financial_investment_sme().intValue());
			}
			Cell R77cell35 = R77row.getCell(37);
			if (R77cell35 != null) {
				R77cell35.setCellValue(brf94d.getR77_no_of_transactions_direct_investment_sme() == null ? 0
						: brf94d.getR77_no_of_transactions_direct_investment_sme().intValue());
			}
			Cell R77cell36 = R77row.getCell(38);
			if (R77cell36 != null) {
				R77cell36.setCellValue(brf94d.getR77_amount_direct_investment_sme() == null ? 0
						: brf94d.getR77_amount_direct_investment_sme().intValue());
			}
			Cell R77cell37 = R77row.getCell(39);
			if (R77cell37 != null) {
				R77cell37.setCellValue(brf94d.getR77_no_of_transactions_services_sme() == null ? 0
						: brf94d.getR77_no_of_transactions_services_sme().intValue());
			}
			Cell R77cell38 = R77row.getCell(40);
			if (R77cell38 != null) {
				R77cell38.setCellValue(brf94d.getR77_amount_services_sme() == null ? 0
						: brf94d.getR77_amount_services_sme().intValue());
			}
			Cell R77cell39 = R77row.getCell(41);
			if (R77cell39 != null) {
				R77cell39.setCellValue(brf94d.getR77_no_of_transactions_trade_sme() == null ? 0
						: brf94d.getR77_no_of_transactions_trade_sme().intValue());
			}
			Cell R77cell40 = R77row.getCell(42);
			if (R77cell40 != null) {
				R77cell40.setCellValue(
						brf94d.getR77_amount_trade_sme() == null ? 0 : brf94d.getR77_amount_trade_sme().intValue());
			}
			Cell R77cell41 = R77row.getCell(43);
			if (R77cell41 != null) {
				R77cell41.setCellValue(brf94d.getR77_no_of_transactions_financial_investment_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_financial_investment_individual().intValue());
			}
			Cell R77cell42 = R77row.getCell(44);
			if (R77cell42 != null) {
				R77cell42.setCellValue(brf94d.getR77_amount_financial_investment_individual() == null ? 0
						: brf94d.getR77_amount_financial_investment_individual().intValue());
			}
			Cell R77cell43 = R77row.getCell(45);
			if (R77cell43 != null) {
				R77cell43.setCellValue(brf94d.getR77_no_of_transactions_direct_investment_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_direct_investment_individual().intValue());
			}
			Cell R77cell44 = R77row.getCell(46);
			if (R77cell44 != null) {
				R77cell44.setCellValue(brf94d.getR77_amount_direct_investment_individual() == null ? 0
						: brf94d.getR77_amount_direct_investment_individual().intValue());
			}
			Cell R77cell45 = R77row.getCell(47);
			if (R77cell45 != null) {
				R77cell45.setCellValue(brf94d.getR77_no_of_transactions_family_support_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_family_support_individual().intValue());
			}
			Cell R77cell46 = R77row.getCell(48);
			if (R77cell46 != null) {
				R77cell46.setCellValue(brf94d.getR77_amount_family_support_individual() == null ? 0
						: brf94d.getR77_amount_family_support_individual().intValue());
			}
			Cell R77cell47 = R77row.getCell(49);
			if (R77cell47 != null) {
				R77cell47.setCellValue(brf94d.getR77_no_of_transactions_education_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_education_individual().intValue());
			}
			Cell R77cell48 = R77row.getCell(50);
			if (R77cell48 != null) {
				R77cell48.setCellValue(brf94d.getR77_amount_education_individual() == null ? 0
						: brf94d.getR77_amount_education_individual().intValue());
			}
			Cell R77cell49 = R77row.getCell(51);
			if (R77cell49 != null) {
				R77cell49.setCellValue(brf94d.getR77_no_of_transactions_medical_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_medical_individual().intValue());
			}

			Cell R77cell50 = R77row.getCell(52);
			if (R77cell50 != null) {
				R77cell50.setCellValue(brf94d.getR77_amount_medical_individual() == null ? 0
						: brf94d.getR77_amount_medical_individual().intValue());
			}
			Cell R77cell51 = R77row.getCell(53);
			if (R77cell51 != null) {
				R77cell51.setCellValue(brf94d.getR77_no_of_transactions_tourism_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_tourism_individual().intValue());
			}
			Cell R77cell52 = R77row.getCell(54);
			if (R77cell52 != null) {
				R77cell52.setCellValue(brf94d.getR77_amount_tourism_individual() == null ? 0
						: brf94d.getR77_amount_tourism_individual().intValue());
			}
			Cell R77cell53 = R77row.getCell(55);
			if (R77cell53 != null) {
				R77cell53.setCellValue(brf94d.getR77_no_of_transactions_debt_settlement_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_debt_settlement_individual().intValue());
			}
			Cell R77cell54 = R77row.getCell(56);
			if (R77cell54 != null) {
				R77cell54.setCellValue(brf94d.getR77_amount_debt_settlement_individual() == null ? 0
						: brf94d.getR77_amount_debt_settlement_individual().intValue());
			}
			Cell R77cell55 = R77row.getCell(57);
			if (R77cell55 != null) {
				R77cell55.setCellValue(brf94d.getR77_no_of_transactions_other_services_individual() == null ? 0
						: brf94d.getR77_no_of_transactions_other_services_individual().intValue());
			}

			Cell R77cell56 = R77row.getCell(58);
			if (R77cell56 != null) {
				R77cell56.setCellValue(brf94d.getR77_amount_other_services_individual() == null ? 0
						: brf94d.getR77_amount_other_services_individual().intValue());
			}

		}

	}

	public File getFileBRF094(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws JRException, SQLException, IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String path = this.env.getProperty("output.exportpath");
		String fileName = "t" + reportId + "_" + todate;
		File outputFile = null;

		logger.info("Getting Output file: " + reportId);

		if (!"xbrl".equalsIgnoreCase(filetype)) {
			if (!filetype.equals("BRF")) {
				// Handle other filetypes if necessary

				try {
					logger.info("Getting Jasper files for report type: " + dtltype);
					if ("report".equalsIgnoreCase(dtltype) && !"detailexcel".equalsIgnoreCase(filetype)) {
						// Compile JasperReports
						InputStream[] jasperFiles = {
								this.getClass().getResourceAsStream("/static/jasper/BRF094_A.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF094_B.jrxml"),
								this.getClass().getResourceAsStream("/static/jasper/BRF094_C.jrxml") };

						JasperReport[] jasperReports = new JasperReport[jasperFiles.length];
						for (int i = 0; i < jasperFiles.length; i++) {
							jasperReports[i] = JasperCompileManager.compileReport(jasperFiles[i]);
						}

						// Fill JasperPrint for each report
						JasperPrint[] jasperPrints = new JasperPrint[jasperReports.length];
						for (int i = 0; i < jasperReports.length; i++) {
							try (Connection connection = srcdataSource.getConnection()) {
								Map<String, Object> params = new HashMap<>();
								params.put("REPORT_DATE", todate);
								jasperPrints[i] = JasperFillManager.fillReport(jasperReports[i], params, connection);
							}
						}

						// Combine JasperPrints
						JasperPrint combinedJasperPrint = new JasperPrint();
						for (JasperPrint jasperPrint : jasperPrints) {
							List<JRPrintPage> pages = jasperPrint.getPages();
							for (JRPrintPage page : pages) {
								combinedJasperPrint.addPage(page);
							}
						}

						if (combinedJasperPrint.getPages().isEmpty()) {
							logger.error("Combined JasperPrint has no pages.");
						} else {
							if ("excel".equalsIgnoreCase(filetype)) {
								fileName = "BRF094A.xlsx";
								path += File.separator + fileName;
								SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
								reportConfig.setSheetNames(new String[] { fileName });
								reportConfig.setDetectCellType(true);
								reportConfig.setOnePagePerSheet(false);
								reportConfig.setRemoveEmptySpaceBetweenRows(false);
								reportConfig.setWhitePageBackground(false);

								JRXlsxExporter exporter = new JRXlsxExporter();
								exporter.setExporterInput(new SimpleExporterInput(combinedJasperPrint));
								exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(path)));
								exporter.setConfiguration(reportConfig);
								exporter.exportReport();
								logger.info("Excel File exported successfully");
							} else {
								fileName = "BRF094A.pdf";
								path += File.separator + fileName;
								JRPdfExporter exporter = new JRPdfExporter();
								exporter.setExporterInput(new SimpleExporterInput(combinedJasperPrint));
								exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(path)));

								// Configure PDF export settings
								SimplePdfReportConfiguration pdfReportConfig = new SimplePdfReportConfiguration();
								pdfReportConfig.setSizePageToContent(true);
								pdfReportConfig.setForceLineBreakPolicy(false);
								exporter.setConfiguration(pdfReportConfig);
								exporter.exportReport();
								logger.info("PDF File exported successfully");
							}
						}
					} else {
						// Handle other cases like "detailexcel" or non-"report" dtltype
						logger.info("Handling non-report Jasper file for dtltype: " + dtltype);
						InputStream jasperFile;
						if ("detailexcel".equalsIgnoreCase(filetype)) {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF94_DETAIL.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF94_DETAIL.jrxml");
						}

						JasperReport jr = JasperCompileManager.compileReport(jasperFile);
						Map<String, Object> params = new HashMap<>();
						params.put("REPORT_DATE", todate);

						if ("pdf".equalsIgnoreCase(filetype)) {
							fileName = fileName + ".pdf";
							path += fileName;
							JasperPrint jp = JasperFillManager.fillReport(jr, params, srcdataSource.getConnection());
							JasperExportManager.exportReportToPdfFile(jp, path);
							logger.info("PDF File exported successfully");
						} else {
							fileName = fileName + ".xlsx";
							path += fileName;
							JasperPrint jp = JasperFillManager.fillReport(jr, params, srcdataSource.getConnection());
							JRXlsxExporter exporter = new JRXlsxExporter();
							exporter.setExporterInput(new SimpleExporterInput(jp));
							exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
							exporter.exportReport();
							logger.info("Excel File exported successfully");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				outputFile = new File(path);
				return outputFile;
			} else {
				List<BRF094_SUMMARYENTITY1> T1Master = new ArrayList<>();
				List<BRF094_SUMMARYENTITY2> T1Master1 = new ArrayList<>();
				List<BRF094_SUMMARYENTITY3> T1Master2 = new ArrayList<>();
				List<BRF094_SUMMARYENTITY4> T1Master3 = new ArrayList<>();
				List<BRF094_SUMMARYENTITY5> T1Master4 = new ArrayList<>();

				List<Object[]> T2rep = new ArrayList<>();
				List<BRF094_SUMMARYENTITY6> Remaining = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();

				try {
					Date d1 = dateFormat.parse(todate);

					T1Master = fetchEntity1Data(hs, d1);
					T1Master1 = fetchEntity2Data(hs, d1);
					T1Master2 = fetchEntity3Data(hs, d1);
					T1Master3 = fetchEntity4Data(hs, d1);
					T1Master4 = fetchEntity5Data(hs, d1);
					T2rep = brf094entity2.findallvalues(todate);

					try (FileInputStream fis = new FileInputStream(
							env.getProperty("output.exportpathtemp") + "011-BRF-094-AT.xls");
							Workbook workbook = WorkbookFactory.create(fis)) {
						Sheet sheet = workbook.getSheetAt(0);

						// Update sheet with entity data
						updateSheetWithEntity1Data(sheet, T1Master);
						updateSheetWithEntity2Data(sheet, T1Master1);
						updateSheetWithEntity3Data(sheet, T1Master2);
						updateSheetWithEntity4Data(sheet, T1Master3);
						updateSheetWithEntity5Data(sheet, T1Master4);

						if (!T2rep.isEmpty()) {
							int startRow = 87;
							for (int index = 0; index < T2rep.size(); index++) {
								Object[] BRF094 = T2rep.get(index);
								Row row = sheet.getRow(startRow + index);
								if (row == null) {
									row = sheet.createRow(startRow + index);
								}

								// remaining_countries
								Cell cell = row.getCell(2);
								if (cell == null) {
									cell = row.createCell(2);
								}
								cell.setCellValue(BRF094[1] == null ? "" : BRF094[1].toString());
								// govt_finan_invest_no_of_transactions
								Cell cell1 = row.getCell(3);
								if (cell1 == null) {
									cell1 = row.createCell(3);
								}
								cell1.setCellValue(BRF094[2] == null ? 0 : ((BigDecimal) BRF094[2]).intValue());

								// govt_finan_invest_amount
								Cell cell2 = row.getCell(4);
								if (cell2 == null) {
									cell2 = row.createCell(4);
								}
								cell2.setCellValue(BRF094[3] == null ? 0 : ((BigDecimal) BRF094[3]).intValue());

								// govt_direct_invest_no_of_transactions
								Cell cell3 = row.getCell(5);
								if (cell3 == null) {
									cell3 = row.createCell(5);
								}
								cell3.setCellValue(BRF094[4] == null ? 0 : ((BigDecimal) BRF094[4]).intValue());

								// govt_direct_invest_amount
								Cell cell4 = row.getCell(6);
								if (cell4 == null) {
									cell4 = row.createCell(6);
								}
								cell4.setCellValue(BRF094[5] == null ? 0 : ((BigDecimal) BRF094[5]).intValue());

								// govt_service_no_of_transactions
								Cell cell5 = row.getCell(7);
								if (cell5 == null) {
									cell5 = row.createCell(7);
								}
								cell5.setCellValue(BRF094[6] == null ? 0 : ((BigDecimal) BRF094[6]).intValue());
								// govt_service_invest_amount
								Cell cell6 = row.getCell(8);
								if (cell6 == null) {
									cell6 = row.createCell(8);
								}
								cell6.setCellValue(BRF094[7] == null ? 0 : ((BigDecimal) BRF094[7]).intValue());
///
								// govt_trade_no_of_transactions
								Cell cell7 = row.getCell(9);
								if (cell7 == null) {
									cell7 = row.createCell(9);
								}
								cell7.setCellValue(BRF094[8] == null ? 0 : ((BigDecimal) BRF094[8]).intValue());
								// govt_trade_invest_amount
								Cell cell8 = row.getCell(10);
								if (cell8 == null) {
									cell8 = row.createCell(10);
								}
								cell8.setCellValue(BRF094[9] == null ? 0 : ((BigDecimal) BRF094[9]).intValue());
								// reserve_finan_invest_no_of_transactions
								Cell cell9 = row.getCell(11);
								if (cell9 == null) {
									cell9 = row.createCell(11);
								}
								cell9.setCellValue(BRF094[10] == null ? 0 : ((BigDecimal) BRF094[10]).intValue());
								// reserve_finan_invest_amount
								Cell cell10 = row.getCell(12);
								if (cell10 == null) {
									cell10 = row.createCell(12);
								}
								cell10.setCellValue(BRF094[11] == null ? 0 : ((BigDecimal) BRF094[11]).intValue());
								// reserve_direct_invest_no_of_transactions
								Cell cell11 = row.getCell(13);
								if (cell11 == null) {
									cell11 = row.createCell(13);
								}
								cell11.setCellValue(BRF094[12] == null ? 0 : ((BigDecimal) BRF094[12]).intValue());
								// reserve_direct_invest_amount
								Cell cell12 = row.getCell(14);
								if (cell12 == null) {
									cell12 = row.createCell(14);
								}
								cell12.setCellValue(BRF094[13] == null ? 0 : ((BigDecimal) BRF094[13]).intValue());
								// reserve_service_no_of_transactions
								Cell cell13 = row.getCell(15);
								if (cell13 == null) {
									cell13 = row.createCell(15);
								}
								cell13.setCellValue(BRF094[14] == null ? 0 : ((BigDecimal) BRF094[14]).intValue());
								// reserve_service_invest_amount
								Cell cell14 = row.getCell(16);
								if (cell14 == null) {
									cell14 = row.createCell(16);
								}
								cell14.setCellValue(BRF094[15] == null ? 0 : ((BigDecimal) BRF094[15]).intValue());
								// reserve_trade_no_of_transactions
								Cell cell15 = row.getCell(17);
								if (cell15 == null) {
									cell15 = row.createCell(17);
								}
								cell15.setCellValue(BRF094[16] == null ? 0 : ((BigDecimal) BRF094[16]).intValue());
								// reserve_trade_invest_amount
								Cell cell16 = row.getCell(18);
								if (cell16 == null) {
									cell16 = row.createCell(18);
								}
								cell16.setCellValue(BRF094[17] == null ? 0 : ((BigDecimal) BRF094[17]).intValue());
								// gre_finan_invest_no_of_transactions
								Cell cell17 = row.getCell(19);
								if (cell17 == null) {
									cell17 = row.createCell(19);
								}
								cell17.setCellValue(BRF094[18] == null ? 0 : ((BigDecimal) BRF094[18]).intValue());
								// gre_finan_invest_amount
								Cell cell18 = row.getCell(20);
								if (cell18 == null) {
									cell18 = row.createCell(20);
								}
								cell18.setCellValue(BRF094[19] == null ? 0 : ((BigDecimal) BRF094[19]).intValue());
								// gre_direct_invest_no_of_transactions
								Cell cell19 = row.getCell(21);
								if (cell19 == null) {
									cell19 = row.createCell(21);
								}
								cell19.setCellValue(BRF094[20] == null ? 0 : ((BigDecimal) BRF094[20]).intValue());
								// gre_direct_invest_amount
								Cell cell20 = row.getCell(22);
								if (cell20 == null) {
									cell20 = row.createCell(22);
								}
								cell20.setCellValue(BRF094[21] == null ? 0 : ((BigDecimal) BRF094[21]).intValue());
								// gre_service_no_of_transactions
								Cell cell21 = row.getCell(23);
								if (cell21 == null) {
									cell21 = row.createCell(23);
								}
								cell21.setCellValue(BRF094[22] == null ? 0 : ((BigDecimal) BRF094[22]).intValue());
								// gre_service_invest_amount
								Cell cell22 = row.getCell(24);
								if (cell22 == null) {
									cell22 = row.createCell(24);
								}
								cell22.setCellValue(BRF094[23] == null ? 0 : ((BigDecimal) BRF094[23]).intValue());
								// gre_trade_no_of_transactions
								Cell cell23 = row.getCell(25);
								if (cell23 == null) {
									cell23 = row.createCell(25);
								}
								cell23.setCellValue(BRF094[24] == null ? 0 : ((BigDecimal) BRF094[24]).intValue());
								// gre_trade_invest_amount
								Cell cell24 = row.getCell(26);
								if (cell24 == null) {
									cell24 = row.createCell(26);
								}
								cell24.setCellValue(BRF094[25] == null ? 0 : ((BigDecimal) BRF094[25]).intValue());
								// corporate_finan_invest_no_of_transactions
								Cell cell25 = row.getCell(27);
								if (cell25 == null) {
									cell25 = row.createCell(27);
								}
								cell25.setCellValue(BRF094[26] == null ? 0 : ((BigDecimal) BRF094[26]).intValue());
								// corporate_finan_invest_amount
								Cell cell26 = row.getCell(28);
								if (cell26 == null) {
									cell26 = row.createCell(28);
								}
								cell26.setCellValue(BRF094[27] == null ? 0 : ((BigDecimal) BRF094[27]).intValue());
								// corporate_direct_invest_no_of_transactions
								Cell cell27 = row.getCell(29);
								if (cell27 == null) {
									cell27 = row.createCell(29);
								}
								cell27.setCellValue(BRF094[28] == null ? 0 : ((BigDecimal) BRF094[28]).intValue());
								// corporate_direct_invest_amount
								Cell cell28 = row.getCell(30);
								if (cell28 == null) {
									cell28 = row.createCell(30);
								}
								cell28.setCellValue(BRF094[29] == null ? 0 : ((BigDecimal) BRF094[29]).intValue());
								// corporate_service_no_of_transactions
								Cell cell29 = row.getCell(31);
								if (cell29 == null) {
									cell29 = row.createCell(31);
								}
								cell29.setCellValue(BRF094[30] == null ? 0 : ((BigDecimal) BRF094[30]).intValue());
								// corporate_service_invest_amount
								Cell cell30 = row.getCell(32);
								if (cell30 == null) {
									cell30 = row.createCell(32);
								}
								cell30.setCellValue(BRF094[31] == null ? 0 : ((BigDecimal) BRF094[31]).intValue());
								// corporate_trade_no_of_transactions
								Cell cell31 = row.getCell(33);
								if (cell31 == null) {
									cell31 = row.createCell(33);
								}
								cell31.setCellValue(BRF094[32] == null ? 0 : ((BigDecimal) BRF094[32]).intValue());
								// corporate_trade_invest_amount
								Cell cell32 = row.getCell(34);
								if (cell32 == null) {
									cell32 = row.createCell(34);
								}
								cell32.setCellValue(BRF094[33] == null ? 0 : ((BigDecimal) BRF094[33]).intValue());
								// sme_finan_invest_no_of_transactions
								Cell cell33 = row.getCell(35);
								if (cell33 == null) {
									cell33 = row.createCell(35);
								}
								cell33.setCellValue(BRF094[34] == null ? 0 : ((BigDecimal) BRF094[34]).intValue());
								// sme_finan_invest_amount
								Cell cell34 = row.getCell(36);
								if (cell34 == null) {
									cell34 = row.createCell(36);
								}
								cell34.setCellValue(BRF094[35] == null ? 0 : ((BigDecimal) BRF094[35]).intValue());
								// sme_direct_invest_no_of_transactions
								Cell cell35 = row.getCell(37);
								if (cell35 == null) {
									cell35 = row.createCell(37);
								}
								cell35.setCellValue(BRF094[36] == null ? 0 : ((BigDecimal) BRF094[36]).intValue());
								// sme_direct_invest_amount
								Cell cell36 = row.getCell(38);
								if (cell36 == null) {
									cell36 = row.createCell(38);
								}
								cell36.setCellValue(BRF094[37] == null ? 0 : ((BigDecimal) BRF094[37]).intValue());
								// sme_service_no_of_transactions
								Cell cell37 = row.getCell(39);
								if (cell37 == null) {
									cell37 = row.createCell(39);
								}
								cell37.setCellValue(BRF094[38] == null ? 0 : ((BigDecimal) BRF094[38]).intValue());
								// sme_service_invest_amount
								Cell cell38 = row.getCell(40);
								if (cell38 == null) {
									cell38 = row.createCell(40);
								}
								cell38.setCellValue(BRF094[39] == null ? 0 : ((BigDecimal) BRF094[39]).intValue());
								// sme_trade_no_of_transactions
								Cell cell39 = row.getCell(41);
								if (cell39 == null) {
									cell39 = row.createCell(41);
								}
								cell39.setCellValue(BRF094[40] == null ? 0 : ((BigDecimal) BRF094[40]).intValue());
								// sme_trade_invest_amount
								Cell cell40 = row.getCell(42);
								if (cell40 == null) {
									cell40 = row.createCell(42);
								}
								cell40.setCellValue(BRF094[41] == null ? 0 : ((BigDecimal) BRF094[41]).intValue());
								// indvidual_finan_invest_no_of_transactions
								Cell cell41 = row.getCell(43);
								if (cell41 == null) {
									cell41 = row.createCell(43);
								}
								cell41.setCellValue(BRF094[42] == null ? 0 : ((BigDecimal) BRF094[42]).intValue());
								// indvidual_finan_invest_amount
								Cell cell42 = row.getCell(44);
								if (cell42 == null) {
									cell42 = row.createCell(44);
								}
								cell42.setCellValue(BRF094[43] == null ? 0 : ((BigDecimal) BRF094[43]).intValue());
								// indvidual_direct_invest_no_of_transactions
								Cell cell43 = row.getCell(45);
								if (cell43 == null) {
									cell43 = row.createCell(45);
								}
								cell43.setCellValue(BRF094[44] == null ? 0 : ((BigDecimal) BRF094[44]).intValue());
								// indvidual_direct_invest_amount
								Cell cell44 = row.getCell(46);
								if (cell44 == null) {
									cell44 = row.createCell(46);
								}
								cell44.setCellValue(BRF094[45] == null ? 0 : ((BigDecimal) BRF094[45]).intValue());
								// indvidual_family_no_of_transactions
								Cell cell45 = row.getCell(47);
								if (cell45 == null) {
									cell45 = row.createCell(47);
								}
								cell45.setCellValue(BRF094[46] == null ? 0 : ((BigDecimal) BRF094[46]).intValue());
								// indvidual_family_invest_amount
								Cell cell46 = row.getCell(48);
								if (cell46 == null) {
									cell46 = row.createCell(48);
								}
								cell46.setCellValue(BRF094[47] == null ? 0 : ((BigDecimal) BRF094[47]).intValue());
								// indvidual_educate_no_of_transactions
								Cell cell47 = row.getCell(49);
								if (cell47 == null) {
									cell47 = row.createCell(49);
								}
								cell47.setCellValue(BRF094[48] == null ? 0 : ((BigDecimal) BRF094[48]).intValue());
								// indvidual_educate_invest_amount
								Cell cell48 = row.getCell(50);
								if (cell48 == null) {
									cell48 = row.createCell(50);
								}
								cell48.setCellValue(BRF094[49] == null ? 0 : ((BigDecimal) BRF094[49]).intValue());
								// indvidual_medical_no_of_transactions
								Cell cell49 = row.getCell(51);
								if (cell49 == null) {
									cell49 = row.createCell(51);
								}
								cell49.setCellValue(BRF094[50] == null ? 0 : ((BigDecimal) BRF094[50]).intValue());
								// indvidual_medical_invest_amount
								Cell cell50 = row.getCell(52);
								if (cell50 == null) {
									cell50 = row.createCell(52);
								}
								cell50.setCellValue(BRF094[51] == null ? 0 : ((BigDecimal) BRF094[51]).intValue());
								// indvidual_tour_no_of_transactions
								Cell cell51 = row.getCell(53);
								if (cell51 == null) {
									cell51 = row.createCell(53);
								}
								cell51.setCellValue(BRF094[52] == null ? 0 : ((BigDecimal) BRF094[52]).intValue());
								// indvidual_tour_invest_amount
								Cell cell52 = row.getCell(54);
								if (cell52 == null) {
									cell52 = row.createCell(54);
								}
								cell52.setCellValue(BRF094[53] == null ? 0 : ((BigDecimal) BRF094[53]).intValue());
								// indvidual_debt_no_of_transactions
								Cell cell53 = row.getCell(55);
								if (cell53 == null) {
									cell53 = row.createCell(55);
								}
								cell53.setCellValue(BRF094[54] == null ? 0 : ((BigDecimal) BRF094[54]).intValue());
								// indvidual_debt_invest_amount
								Cell cell54 = row.getCell(56);
								if (cell54 == null) {
									cell54 = row.createCell(56);
								}
								cell54.setCellValue(BRF094[55] == null ? 0 : ((BigDecimal) BRF094[55]).intValue());
								// indvidual_other_no_of_transactions
								Cell cell55 = row.getCell(57);
								if (cell55 == null) {
									cell55 = row.createCell(57);
								}
								cell55.setCellValue(BRF094[56] == null ? 0 : ((BigDecimal) BRF094[56]).intValue());
								// indvidual_other_invest_amount
								Cell cell56 = row.getCell(58);
								if (cell56 == null) {
									cell56 = row.createCell(58);
								}
								cell56.setCellValue(BRF094[57] == null ? 0 : ((BigDecimal) BRF094[57]).intValue());

							}

						}

						// Evaluate all formulas
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						// Save the changes to the workbook
						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-094-A.xls")) {
							workbook.write(fileOut);
							path = fileOut.toString();
							logger.info("PATH : " + path);
						}
					}

				} catch (ParseException | EncryptedDocumentException | InvalidFormatException | IOException e) {
					e.printStackTrace();
				}

				// Final output file
				outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-094-A.xls");
				return outputFile;
			}
		}
		return outputFile;
	}

	public String detailChanges94(BRF094_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1, String report_addl_criteria_2,
			String purpose_of_rem) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			System.out.println(foracid + "| |" + purpose_of_rem + "| |" + report_addl_criteria_2);
			BRF094_DETAIL_ENTITY BRF094detail = brf94_Detailrep.findByCustomCriteria(foracid, report_addl_criteria_2,
					purpose_of_rem);
			System.out.println(foracid + "| |" + purpose_of_rem + "| |" + report_addl_criteria_2);
			System.out.println(BRF094detail);

			System.out.println(act_balance_amt_lc + report_label_1 + report_name_1 + report_addl_criteria_1);
			if (BRF094detail != null) {

				BRF094detail.setAct_balance_amt_lc(act_balance_amt_lc);
				BRF094detail.setReport_label_1(report_label_1);
				BRF094detail.setReport_name_1(report_name_1);
				BRF094detail.setReport_addl_criteria_1(report_addl_criteria_1);
				brf94_Detailrep.save(BRF094detail);

				// hs.saveOrUpdate(detail);
				logger.info("Edited Record");
				msg = "Edited Successfully";

			} else {
				msg = "No data Found";
			}

		} catch (Exception e) {

			msg = "error occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public ModelAndView getArchieveBRF094View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF094_SUMMARYENTITY1> T1rep = new ArrayList<BRF094_SUMMARYENTITY1>();

		List<BRF094_SUMMARYENTITY1> T1Master = new ArrayList<BRF094_SUMMARYENTITY1>();
		List<BRF094_SUMMARYENTITY2> T1Master1 = new ArrayList<BRF094_SUMMARYENTITY2>();
		List<BRF094_SUMMARYENTITY3> T1Master2 = new ArrayList<BRF094_SUMMARYENTITY3>();
		List<BRF094_SUMMARYENTITY4> T1Master3 = new ArrayList<BRF094_SUMMARYENTITY4>();
		List<BRF094_SUMMARYENTITY5> T1Master4 = new ArrayList<BRF094_SUMMARYENTITY5>();

		// List<BRF094_SUMMARYENTITY6> T2rep = new ArrayList<BRF094_SUMMARYENTITY6>();
		List<Object[]> T2rep = new ArrayList<Object[]>();

		List<BRF094_SUMMARYENTITY6> Remaining = new ArrayList<BRF094_SUMMARYENTITY6>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			T1Master = hs
					.createQuery("from BRF094_SUMMARYENTITY1 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY1.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs
					.createQuery("from BRF094_SUMMARYENTITY2 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY2.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master2 = hs
					.createQuery("from BRF094_SUMMARYENTITY3 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY3.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master3 = hs
					.createQuery("from BRF094_SUMMARYENTITY4 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY4.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master4 = hs
					.createQuery("from BRF094_SUMMARYENTITY5 a where a.report_date = ?1 ", BRF094_SUMMARYENTITY5.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = brf094entity2.findallvalues(todate);

			System.out.println(T2rep.toString());

			for (Object[] BRF94 : T2rep) {
				System.out.println("Inside loop");
				BRF094_SUMMARYENTITY6 BRF094_SUMMARYENTITY6 = new BRF094_SUMMARYENTITY6();

				if (BRF94[0].equals("Remaining Countries")) {

					BRF094_SUMMARYENTITY6.setRemaining_countries(BRF94[1] != null ? (String) BRF94[1] : null);
					System.out.println(BRF094_SUMMARYENTITY6.getRemaining_countries());

					BRF094_SUMMARYENTITY6
							.setGovt_finan_invest_no_of_transactions(BRF94[2] != null ? (BigDecimal) BRF94[2] : null);
					BRF094_SUMMARYENTITY6.setGovt_finan_invest_amount(BRF94[3] != null ? (BigDecimal) BRF94[3] : null);
					BRF094_SUMMARYENTITY6
							.setGovt_direct_invest_no_of_transactions(BRF94[4] != null ? (BigDecimal) BRF94[4] : null);
					BRF094_SUMMARYENTITY6.setGovt_direct_invest_amount(BRF94[5] != null ? (BigDecimal) BRF94[5] : null);
					BRF094_SUMMARYENTITY6
							.setGovt_service_no_of_transactions(BRF94[6] != null ? (BigDecimal) BRF94[6] : null);
					BRF094_SUMMARYENTITY6
							.setGovt_service_invest_amount(BRF94[7] != null ? (BigDecimal) BRF94[7] : null);
					BRF094_SUMMARYENTITY6
							.setGovt_trade_no_of_transactions(BRF94[8] != null ? (BigDecimal) BRF94[8] : null);
					BRF094_SUMMARYENTITY6.setGovt_trade_invest_amount(BRF94[9] != null ? (BigDecimal) BRF94[9] : null);

					BRF094_SUMMARYENTITY6.setReserve_finan_invest_no_of_transactions(
							BRF94[10] != null ? (BigDecimal) BRF94[10] : null);
					BRF094_SUMMARYENTITY6
							.setReserve_finan_invest_amount(BRF94[11] != null ? (BigDecimal) BRF94[11] : null);
					BRF094_SUMMARYENTITY6.setReserve_direct_invest_no_of_transactions(
							BRF94[12] != null ? (BigDecimal) BRF94[12] : null);
					BRF094_SUMMARYENTITY6
							.setReserve_direct_invest_amount(BRF94[13] != null ? (BigDecimal) BRF94[13] : null);
					BRF094_SUMMARYENTITY6
							.setReserve_service_no_of_transactions(BRF94[14] != null ? (BigDecimal) BRF94[14] : null);
					BRF094_SUMMARYENTITY6
							.setReserve_service_invest_amount(BRF94[15] != null ? (BigDecimal) BRF94[15] : null);
					BRF094_SUMMARYENTITY6
							.setReserve_trade_no_of_transactions(BRF94[16] != null ? (BigDecimal) BRF94[16] : null);
					BRF094_SUMMARYENTITY6
							.setReserve_trade_invest_amount(BRF94[17] != null ? (BigDecimal) BRF94[17] : null);

					BRF094_SUMMARYENTITY6
							.setGre_finan_invest_no_of_transactions(BRF94[18] != null ? (BigDecimal) BRF94[18] : null);
					BRF094_SUMMARYENTITY6.setGre_finan_invest_amount(BRF94[19] != null ? (BigDecimal) BRF94[19] : null);
					BRF094_SUMMARYENTITY6
							.setGre_direct_invest_no_of_transactions(BRF94[20] != null ? (BigDecimal) BRF94[20] : null);
					BRF094_SUMMARYENTITY6
							.setGre_direct_invest_amount(BRF94[21] != null ? (BigDecimal) BRF94[21] : null);
					BRF094_SUMMARYENTITY6
							.setGre_service_no_of_transactions(BRF94[22] != null ? (BigDecimal) BRF94[22] : null);
					BRF094_SUMMARYENTITY6
							.setGre_service_invest_amount(BRF94[23] != null ? (BigDecimal) BRF94[23] : null);
					BRF094_SUMMARYENTITY6
							.setGre_trade_no_of_transactions(BRF94[24] != null ? (BigDecimal) BRF94[24] : null);
					BRF094_SUMMARYENTITY6.setGre_trade_invest_amount(BRF94[25] != null ? (BigDecimal) BRF94[25] : null);

					BRF094_SUMMARYENTITY6.setCorporate_finan_invest_no_of_transactions(
							BRF94[26] != null ? (BigDecimal) BRF94[26] : null);
					BRF094_SUMMARYENTITY6
							.setCorporate_finan_invest_amount(BRF94[27] != null ? (BigDecimal) BRF94[27] : null);
					BRF094_SUMMARYENTITY6.setCorporate_direct_invest_no_of_transactions(
							BRF94[28] != null ? (BigDecimal) BRF94[28] : null);
					BRF094_SUMMARYENTITY6
							.setCorporate_direct_invest_amount(BRF94[29] != null ? (BigDecimal) BRF94[29] : null);
					BRF094_SUMMARYENTITY6
							.setCorporate_service_no_of_transactions(BRF94[30] != null ? (BigDecimal) BRF94[30] : null);
					BRF094_SUMMARYENTITY6
							.setCorporate_service_invest_amount(BRF94[31] != null ? (BigDecimal) BRF94[31] : null);
					BRF094_SUMMARYENTITY6
							.setCorporate_trade_no_of_transactions(BRF94[32] != null ? (BigDecimal) BRF94[32] : null);
					BRF094_SUMMARYENTITY6
							.setCorporate_trade_invest_amount(BRF94[33] != null ? (BigDecimal) BRF94[33] : null);

					BRF094_SUMMARYENTITY6
							.setSme_finan_invest_no_of_transactions(BRF94[34] != null ? (BigDecimal) BRF94[34] : null);
					BRF094_SUMMARYENTITY6.setSme_finan_invest_amount(BRF94[35] != null ? (BigDecimal) BRF94[35] : null);
					BRF094_SUMMARYENTITY6
							.setSme_direct_invest_no_of_transactions(BRF94[36] != null ? (BigDecimal) BRF94[36] : null);
					BRF094_SUMMARYENTITY6
							.setSme_direct_invest_amount(BRF94[37] != null ? (BigDecimal) BRF94[37] : null);
					BRF094_SUMMARYENTITY6
							.setSme_service_no_of_transactions(BRF94[38] != null ? (BigDecimal) BRF94[38] : null);
					BRF094_SUMMARYENTITY6
							.setSme_service_invest_amount(BRF94[39] != null ? (BigDecimal) BRF94[39] : null);
					BRF094_SUMMARYENTITY6
							.setSme_trade_no_of_transactions(BRF94[40] != null ? (BigDecimal) BRF94[40] : null);
					BRF094_SUMMARYENTITY6.setSme_trade_invest_amount(BRF94[41] != null ? (BigDecimal) BRF94[41] : null);

					BRF094_SUMMARYENTITY6.setIndvidual_finan_invest_no_of_transactions(
							BRF94[42] != null ? (BigDecimal) BRF94[42] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_finan_invest_amount(BRF94[43] != null ? (BigDecimal) BRF94[43] : null);
					BRF094_SUMMARYENTITY6.setIndvidual_direct_invest_no_of_transactions(
							BRF94[44] != null ? (BigDecimal) BRF94[44] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_direct_invest_amount(BRF94[45] != null ? (BigDecimal) BRF94[45] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_family_no_of_transactions(BRF94[46] != null ? (BigDecimal) BRF94[46] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_family_invest_amount(BRF94[47] != null ? (BigDecimal) BRF94[47] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_educate_no_of_transactions(BRF94[48] != null ? (BigDecimal) BRF94[48] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_educate_invest_amount(BRF94[49] != null ? (BigDecimal) BRF94[49] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_medical_no_of_transactions(BRF94[50] != null ? (BigDecimal) BRF94[50] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_medical_invest_amount(BRF94[51] != null ? (BigDecimal) BRF94[51] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_tour_no_of_transactions(BRF94[52] != null ? (BigDecimal) BRF94[52] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_tour_invest_amount(BRF94[53] != null ? (BigDecimal) BRF94[53] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_debt_no_of_transactions(BRF94[54] != null ? (BigDecimal) BRF94[54] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_debt_invest_amount(BRF94[55] != null ? (BigDecimal) BRF94[55] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_other_no_of_transactions(BRF94[56] != null ? (BigDecimal) BRF94[56] : null);
					BRF094_SUMMARYENTITY6
							.setIndvidual_other_invest_amount(BRF94[57] != null ? (BigDecimal) BRF94[57] : null);

					BRF094_SUMMARYENTITY6.setTransactions(BRF94[58] != null ? (BigDecimal) BRF94[58] : null);
					BRF094_SUMMARYENTITY6.setAmount(BRF94[59] != null ? (BigDecimal) BRF94[59] : null);
					BRF094_SUMMARYENTITY6.setRow_label(BRF94[60] != null ? (String) BRF94[60] : null);

					Remaining.add(BRF094_SUMMARYENTITY6);
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("RR/BRF094ARCH");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
		mv.addObject("reportsummary3", T1Master3);
		mv.addObject("reportsummary4", T1Master4);
		mv.addObject("reportsummary5", T2rep);

		System.out.println(Remaining);
		mv.addObject("Remaining", Remaining);
		/// remain-GOVT
		mv.addObject("getgovtfintranremain", brf094entity2.getgovtfintranremain(todate));
		mv.addObject("getgovtfinamountremain", brf094entity2.getgovtfinamountremain(todate));
		mv.addObject("getgovtdirtranremain", brf094entity2.getgovtdirtranremain(todate));
		mv.addObject("getgovtdiramountremain", brf094entity2.getgovtdiramountremain(todate));
		mv.addObject("getgovtsertranremain", brf094entity2.getgovtsertranremain(todate));
		mv.addObject("getgovtseramountremain", brf094entity2.getgovtseramountremain(todate));
		mv.addObject("getgovttradetranremain", brf094entity2.getgovttradetranremain(todate));
		mv.addObject("getgovttradeamountremain", brf094entity2.getgovttradeamountremain(todate));

		/// remain-RESERVE
		mv.addObject("getresfintranremain", brf094entity2.getresfintranremain(todate));
		mv.addObject("getresfinamountremain", brf094entity2.getresfinamountremain(todate));
		mv.addObject("getresdirtranremain", brf094entity2.getresdirtranremain(todate));
		mv.addObject("getresdiramountremain", brf094entity2.getresdiramountremain(todate));
		mv.addObject("getressertranremain", brf094entity2.getressertranremain(todate));
		mv.addObject("getresseramountremain", brf094entity2.getresseramountremain(todate));
		mv.addObject("getrestradetranremain", brf094entity2.getrestradetranremain(todate));
		mv.addObject("getrestradeamountremain", brf094entity2.getrestradeamountremain(todate));

		/// remain-GRE
		mv.addObject("getgrefintranremain", brf094entity2.getgrefintranremain(todate));
		mv.addObject("getgrefinamountremain", brf094entity2.getgrefinamountremain(todate));
		mv.addObject("getgredirtranremain", brf094entity2.getgredirtranremain(todate));
		mv.addObject("getgrediramountremain", brf094entity2.getgrediramountremain(todate));
		mv.addObject("getgresertranremain", brf094entity2.getgresertranremain(todate));
		mv.addObject("getgreseramountremain", brf094entity2.getgreseramountremain(todate));
		mv.addObject("getgretradetranremain", brf094entity2.getgretradetranremain(todate));
		mv.addObject("getgretradeamountremain", brf094entity2.getgretradeamountremain(todate));

		/// remain-corporate
		mv.addObject("getcorfintranremain", brf094entity2.getcorfintranremain(todate));
		mv.addObject("getcorfinamountremain", brf094entity2.getcorfinamountremain(todate));
		mv.addObject("getcorpdirtranremain", brf094entity2.getcorpdirtranremain(todate));
		mv.addObject("getcorpdiramountremain", brf094entity2.getcorpdiramountremain(todate));
		mv.addObject("getcorsertranremain", brf094entity2.getcorsertranremain(todate));
		mv.addObject("getcorseramountremain", brf094entity2.getcorseramountremain(todate));
		mv.addObject("getcortradetranremain", brf094entity2.getcortradetranremain(todate));
		mv.addObject("getcortradeamountremain", brf094entity2.getcortradeamountremain(todate));

		/// remain-SME
		mv.addObject("getsmefintranremain", brf094entity2.getsmefintranremain(todate));
		mv.addObject("getsmefinamountremain", brf094entity2.getsmefinamountremain(todate));
		mv.addObject("getsmedirtranremain", brf094entity2.getsmedirtranremain(todate));
		mv.addObject("getsmediramountremain", brf094entity2.getsmediramountremain(todate));
		mv.addObject("getsmesertranremain", brf094entity2.getsmesertranremain(todate));
		mv.addObject("getsmeseramountremain", brf094entity2.getsmeseramountremain(todate));
		mv.addObject("getsmetradetranremain", brf094entity2.getsmetradetranremain(todate));
		mv.addObject("getsmetradeamountremain", brf094entity2.getsmetradeamountremain(todate));

		/// remain-INDIVIDUAL
		mv.addObject("getindfintranremain", brf094entity2.getindfintranremain(todate));
		mv.addObject("getindfinamountremain", brf094entity2.getindfinamountremain(todate));
		mv.addObject("getinddirtranremain", brf094entity2.getinddirtranremain(todate));
		mv.addObject("getinddiramountremain", brf094entity2.getinddiramountremain(todate));
		mv.addObject("getindfamtranremain", brf094entity2.getindfamtranremain(todate));
		mv.addObject("getindfamamountremain", brf094entity2.getindfamamountremain(todate));
		mv.addObject("getindedutranremain", brf094entity2.getindedutranremain(todate));
		mv.addObject("getindeduamountremain", brf094entity2.getindeduamountremain(todate));
		mv.addObject("getindmedtranremain", brf094entity2.getindmedtranremain(todate));
		mv.addObject("getindmedamountremain", brf094entity2.getindmedamountremain(todate));
		mv.addObject("getindtourtranremain", brf094entity2.getindtourtranremain(todate));
		mv.addObject("getindtourramountremain", brf094entity2.getindtourramountremain(todate));
		mv.addObject("getinddebttranremain", brf094entity2.getinddebttranremain(todate));
		mv.addObject("getinddebtamountremain", brf094entity2.getinddebtamountremain(todate));
		mv.addObject("getindothertranremain", brf094entity2.getindothertranremain(todate));
		mv.addObject("getindotheramountremain", brf094entity2.getindotheramountremain(todate));
		// ALL FEILDS(TRANSACTIONS) +COUNTRY
		//// TOTAL.NO.OF.TRANSACTIONS
		mv.addObject("getremaintrantotal", brf094entity2.getremaintrantotal(todate));
		/// ALL FEILD(AMOUNT)+country-amount
		mv.addObject("getremainamounttotal", brf094entity2.getremainamounttotal(todate));

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
	 ***/

	public ModelAndView ARCHgetBRF094currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF94_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF94_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF94_ARCHIVTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<BRF094_ARCHIV_ENTITY> T1Master = new ArrayList<BRF094_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs
					.createQuery("from BRF094_ARCHIV_ENTITY a where a.report_date = ?1", BRF094_ARCHIV_ENTITY.class)
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
			String purpose_of_rem = (String) a[49];
			String collection_code = (String) a[50];

			BRF094_ARCHIV_ENTITY py = new BRF094_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, purpose_of_rem, collection_code);
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

		mv.setViewName("RR" + "/" + "BRF094ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	private static int calculatePageHeight(List<JRPrintElement> elements) {
		int maxHeight = 0;

		for (JRPrintElement element : elements) {
			// Adjust this based on your element's properties
			int elementHeight = element.getY() + element.getHeight();
			maxHeight = Math.max(maxHeight, elementHeight);
		}

		return maxHeight;
	}

}
