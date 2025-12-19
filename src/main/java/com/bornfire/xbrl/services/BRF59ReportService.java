package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.ss.usermodel.Workbook;

import javax.sql.DataSource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

import com.bornfire.xbrl.entities.BRBS.BRF059ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF59DetailRep;
import com.bornfire.xbrl.entities.BRBS.BRF59_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF59_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF59_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF59E_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF59A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF59B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF59C_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF59D_ENTITY;
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

public class BRF59ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF59ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;

	@Autowired
	Environment env;

	@Autowired
	BRF059ServiceRepo brf059ServiceRepo;

	@Autowired
	BRF59DetailRep brf59DetailRep;
	@Autowired
	BRF59_ENTITY_REP findentity2;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF059(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF59A_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF59A_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF059View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF59A_ENTITY> T1rep = new ArrayList<BRF59A_ENTITY>();
		// Query<Object[]> qr;

		List<BRF59A_ENTITY> T1Master = new ArrayList<BRF59A_ENTITY>();

		List<BRF59B_ENTITY> T1Master1 = new ArrayList<BRF59B_ENTITY>();

		List<BRF59C_ENTITY> T1Master2 = new ArrayList<BRF59C_ENTITY>();

		List<BRF59D_ENTITY> T1Master3 = new ArrayList<BRF59D_ENTITY>();

		List<Object[]> T2rep = new ArrayList<Object[]>();

		List<BRF59E_ENTITY> Remaining = new ArrayList<BRF59E_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF59A_ENTITY a where a.report_date = ?1 ", BRF59A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF59B_ENTITY a where a.report_date = ?1 ", BRF59B_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master2 = hs.createQuery("from BRF59C_ENTITY a where a.report_date = ?1 ", BRF59C_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master3 = hs.createQuery("from BRF59D_ENTITY a where a.report_date = ?1 ", BRF59D_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T2rep = findentity2.findallvalues(todate);
			for (Object[] BRF59 : T2rep) {
				System.out.println("Inside loop");
				BRF59E_ENTITY BRF59E_ENTITY = new BRF59E_ENTITY();

				if (BRF59[0] != null && BRF59[0].equals("REMAINING_COUNTRIES")) {

					BRF59E_ENTITY.setRemaining((String) BRF59[1]);
					System.out.println(BRF59E_ENTITY.getRemaining());
					BRF59E_ENTITY.setNbfi((BigDecimal) BRF59[2]);
					BRF59E_ENTITY.setInterbank((BigDecimal) BRF59[3]);
					BRF59E_ENTITY.setGov((BigDecimal) BRF59[4]);
					BRF59E_ENTITY.setCorporate((BigDecimal) BRF59[5]);
					BRF59E_ENTITY.setGre((BigDecimal) BRF59[6]);
					BRF59E_ENTITY.setTrade((BigDecimal) BRF59[7]);
					BRF59E_ENTITY.setIndividuals((BigDecimal) BRF59[8]);
					BRF59E_ENTITY.setInvestment((BigDecimal) BRF59[9]);
					BRF59E_ENTITY.setNbfi1((BigDecimal) BRF59[10]);
					BRF59E_ENTITY.setInterbank1((BigDecimal) BRF59[11]);
					BRF59E_ENTITY.setGov1((BigDecimal) BRF59[12]);
					BRF59E_ENTITY.setCorporate1((BigDecimal) BRF59[13]);
					BRF59E_ENTITY.setGre1((BigDecimal) BRF59[14]);
					BRF59E_ENTITY.setTrade1((BigDecimal) BRF59[15]);
					BRF59E_ENTITY.setIndividuals1((BigDecimal) BRF59[16]);
					BRF59E_ENTITY.setInvestment1((BigDecimal) BRF59[17]);
					BRF59E_ENTITY.setZer0((BigDecimal) BRF59[18]);
					BRF59E_ENTITY.setThree((BigDecimal) BRF59[19]);
					BRF59E_ENTITY.setSix((BigDecimal) BRF59[20]);
					BRF59E_ENTITY.setOneyear((BigDecimal) BRF59[21]);
					BRF59E_ENTITY.setForeign((BigDecimal) BRF59[22]);
					BRF59E_ENTITY.setBanks((BigDecimal) BRF59[23]);
					BRF59E_ENTITY.setGov2((BigDecimal) BRF59[24]);
					BRF59E_ENTITY.setOther((BigDecimal) BRF59[25]);
					BRF59E_ENTITY.setBanks1((BigDecimal) BRF59[26]);
					BRF59E_ENTITY.setIndividuals2((BigDecimal) BRF59[27]);
					BRF59E_ENTITY.setOther1((BigDecimal) BRF59[28]);
					BRF59E_ENTITY.setBanks2((BigDecimal) BRF59[29]);
					BRF59E_ENTITY.setGov3((BigDecimal) BRF59[30]);
					BRF59E_ENTITY.setOthers2((BigDecimal) BRF59[31]);
					BRF59E_ENTITY.setBanks3((BigDecimal) BRF59[32]);
					BRF59E_ENTITY.setGov4((BigDecimal) BRF59[33]);
					BRF59E_ENTITY.setOthers3((BigDecimal) BRF59[34]);
					BRF59E_ENTITY.setForeign1((BigDecimal) BRF59[35]);
					BRF59E_ENTITY.setGuarantees((BigDecimal) BRF59[36]);
					BRF59E_ENTITY.setNbfi2((BigDecimal) BRF59[37]);
					BRF59E_ENTITY.setInterbank2((BigDecimal) BRF59[38]);
					BRF59E_ENTITY.setGov5((BigDecimal) BRF59[39]);
					BRF59E_ENTITY.setCorporate2((BigDecimal) BRF59[40]);
					BRF59E_ENTITY.setGre2((BigDecimal) BRF59[41]);
					BRF59E_ENTITY.setIndividuals3((BigDecimal) BRF59[42]);
					BRF59E_ENTITY.setZero1((BigDecimal) BRF59[43]);
					BRF59E_ENTITY.setThree1((BigDecimal) BRF59[44]);
					BRF59E_ENTITY.setSix1((BigDecimal) BRF59[45]);
					BRF59E_ENTITY.setOneyear1((BigDecimal) BRF59[46]);
					BRF59E_ENTITY.setEmpty((String) BRF59[47]);
					BRF59E_ENTITY.setRow_label((String) BRF59[102]);

					Remaining.add(BRF59E_ENTITY);
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF59");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
		mv.addObject("reportsummary3", T1Master3);
		mv.addObject("reportsummary4", T2rep);
		System.out.println(Remaining);
		mv.addObject("Remaining", Remaining);

		mv.addObject("getnbfi", findentity2.getnbfi(todate));
		mv.addObject("getinterbank", findentity2.getinterbank(todate));
		mv.addObject("getgov", findentity2.getgov(todate));
		mv.addObject("getcorporate", findentity2.getcorporate(todate));
		mv.addObject("getgre", findentity2.getgre(todate));
		mv.addObject("gettrade", findentity2.gettrade(todate));
		mv.addObject("getindividuals", findentity2.getindividuals(todate));
		mv.addObject("getinvestment", findentity2.getinvestment(todate));

		mv.addObject("getnbfi1", findentity2.getnbfi1(todate));
		mv.addObject("getinterbank1", findentity2.getinterbank1(todate));
		mv.addObject("getgov1", findentity2.getgov1(todate));
		mv.addObject("getcorporate1", findentity2.getcorporate1(todate));
		mv.addObject("getgre1", findentity2.getgre1(todate));
		mv.addObject("gettrade1", findentity2.gettrade1(todate));
		mv.addObject("getindividuals1", findentity2.getindividuals1(todate));
		mv.addObject("getinvestment1", findentity2.getinvestment1(todate));

		/// remain-GRE
		mv.addObject("getzer0", findentity2.getzer0(todate));
		mv.addObject("getthree", findentity2.getthree(todate));
		mv.addObject("getsix", findentity2.getsix(todate));
		mv.addObject("getoneyear", findentity2.getoneyear(todate));
		mv.addObject("getforeign", findentity2.getforeign(todate));
		mv.addObject("getbanks", findentity2.getbanks(todate));
		mv.addObject("getgov2", findentity2.getgov2(todate));
		mv.addObject("getother", findentity2.getother(todate));

		mv.addObject("getbanks1", findentity2.getbanks1(todate));
		mv.addObject("getindividuals2", findentity2.getindividuals2(todate));
		mv.addObject("getother1", findentity2.getother1(todate));
		mv.addObject("getbanks2", findentity2.getbanks2(todate));
		mv.addObject("getgov3", findentity2.getgov3(todate));
		mv.addObject("getothers2", findentity2.getothers2(todate));
		mv.addObject("getbanks3", findentity2.getbanks3(todate));
		mv.addObject("getgov4", findentity2.getgov4(todate));

		/// remain-SME
		mv.addObject("getothers3", findentity2.getothers3(todate));
		mv.addObject("getforeign1", findentity2.getforeign1(todate));
		mv.addObject("getguarantees", findentity2.getguarantees(todate));
		mv.addObject("getnbfi2", findentity2.getnbfi2(todate));
		mv.addObject("getinterbank2", findentity2.getinterbank2(todate));
		mv.addObject("getgov5", findentity2.getgov5(todate));
		mv.addObject("getcorporate2", findentity2.getcorporate2(todate));
		mv.addObject("getgre2", findentity2.getgre2(todate));

		mv.addObject("getindividuals3", findentity2.getindividuals3(todate));
		mv.addObject("getzero1", findentity2.getzero1(todate));
		mv.addObject("getthree1", findentity2.getthree1(todate));
		mv.addObject("getsix1", findentity2.getsix1(todate));
		mv.addObject("getoneyear1", findentity2.getoneyear1(todate));

		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF059Details(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF59A_DETAILTABLE");
				// qr.setParameter(2, filter);
			} else {
				qr = hs.createNativeQuery("select * from BRF59A_DETAILTABLE");
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF59A_DETAILTABLE  where report_date = ?1");
		}
		List<BRF59_DETAIL_ENTITY> T1Master = new ArrayList<BRF59_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF59_DETAIL_ENTITY a where a.report_date = ?1", BRF59_DETAIL_ENTITY.class)
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
			Character del_flg = (Character) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nreflag = (Character) a[49];

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

			BRF59_DETAIL_ENTITY py = new BRF59_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nreflag);

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

		mv.setViewName("RR" + "/" + "BRF59::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public List<BRF59A_ENTITY> fetchEntity1Data(Session session, Date date) throws ParseException {
		return session.createQuery("from BRF59A_ENTITY a where a.report_date = :date", BRF59A_ENTITY.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF59B_ENTITY> fetchEntity2Data(Session session, Date date) throws ParseException {
		return session.createQuery("from BRF59B_ENTITY a where a.report_date = :date", BRF59B_ENTITY.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF59C_ENTITY> fetchEntity3Data(Session session, Date date) throws ParseException {
		return session.createQuery("from BRF59C_ENTITY a where a.report_date = :date", BRF59C_ENTITY.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF59D_ENTITY> fetchEntity4Data(Session session, Date date) throws ParseException {
		return session.createQuery("from BRF59D_ENTITY a where a.report_date = :date", BRF59D_ENTITY.class)
				.setParameter("date", date).getResultList();
	}

	public List<BRF59E_ENTITY> fetchEntity5Data(Session session, Date date) throws ParseException {
		return session.createQuery("from BRF59E_ENTITY a where a.report_date = :date", BRF59E_ENTITY.class)
				.setParameter("date", date).getResultList();
	}

	public void updateSheetWithEntity1Data(Sheet sheet, List<BRF59A_ENTITY> BRF59A_ENTITY) {
		if (BRF59A_ENTITY.size() == 1) {
			BRF59A_ENTITY brf59 = BRF59A_ENTITY.get(0);
			Row R2row = sheet.getRow(19);
			Cell R2cell1 = R2row.getCell(3);
			if (R2cell1 != null) {
				R2cell1.setCellValue(brf59.getR2_nbfi() == null ? 0 : brf59.getR2_nbfi().intValue());
			}

			Cell R2cell2 = R2row.getCell(4);
			if (R2cell2 != null) {
				R2cell2.setCellValue(brf59.getR2_interbank() == null ? 0 : brf59.getR2_interbank().intValue());
			}
			Cell R2cell3 = R2row.getCell(5);
			if (R2cell3 != null) {
				R2cell3.setCellValue(brf59.getR2_gov() == null ? 0 : brf59.getR2_gov().intValue());
			}
			Cell R2cell4 = R2row.getCell(6);
			if (R2cell4 != null) {
				R2cell4.setCellValue(brf59.getR2_corporate() == null ? 0 : brf59.getR2_corporate().intValue());
			}
			Cell R2cell5 = R2row.getCell(7);
			if (R2cell5 != null) {
				R2cell5.setCellValue(brf59.getR2_gre() == null ? 0 : brf59.getR2_gre().intValue());
			}
			Cell R2cell6 = R2row.getCell(8);
			if (R2cell6 != null) {
				R2cell6.setCellValue(brf59.getR2_trade() == null ? 0 : brf59.getR2_trade().intValue());
			}
			Cell R2cell7 = R2row.getCell(9);
			if (R2cell7 != null) {
				R2cell7.setCellValue(brf59.getR2_individuals() == null ? 0 : brf59.getR2_individuals().intValue());
			}
			Cell R2cell8 = R2row.getCell(10);
			if (R2cell8 != null) {
				R2cell8.setCellValue(brf59.getR2_investment() == null ? 0 : brf59.getR2_investment().intValue());
			}
			Cell R2cell9 = R2row.getCell(11);
			if (R2cell9 != null) {
				R2cell9.setCellValue(brf59.getR2_nbfi1() == null ? 0 : brf59.getR2_nbfi1().intValue());
			}
			Cell R2cell10 = R2row.getCell(12);
			if (R2cell10 != null) {
				R2cell10.setCellValue(brf59.getR2_interbank1() == null ? 0 : brf59.getR2_interbank1().intValue());
			}
			Cell R2cell11 = R2row.getCell(13);
			if (R2cell11 != null) {
				R2cell11.setCellValue(brf59.getR2_gov1() == null ? 0 : brf59.getR2_gov1().intValue());
			}
			Cell R2cell12 = R2row.getCell(14);
			if (R2cell12 != null) {
				R2cell12.setCellValue(brf59.getR2_corporate1() == null ? 0 : brf59.getR2_corporate1().intValue());
			}
			Cell R2cell13 = R2row.getCell(15);
			if (R2cell13 != null) {
				R2cell13.setCellValue(brf59.getR2_gre1() == null ? 0 : brf59.getR2_gre1().intValue());
			}
			Cell R2cell14 = R2row.getCell(16);
			if (R2cell14 != null) {
				R2cell14.setCellValue(brf59.getR2_trade1() == null ? 0 : brf59.getR2_trade1().intValue());
			}
			Cell R2cell15 = R2row.getCell(17);
			if (R2cell15 != null) {
				R2cell15.setCellValue(brf59.getR2_individuals1() == null ? 0 : brf59.getR2_individuals1().intValue());
			}
			Cell R2cell16 = R2row.getCell(18);
			if (R2cell16 != null) {
				R2cell16.setCellValue(brf59.getR2_investment1() == null ? 0 : brf59.getR2_investment1().intValue());
			}
			Cell R2cell17 = R2row.getCell(19);
			if (R2cell17 != null) {
				R2cell17.setCellValue(brf59.getR2_zer0() == null ? 0 : brf59.getR2_zer0().intValue());
			}
			Cell R2cell18 = R2row.getCell(20);
			if (R2cell18 != null) {
				R2cell18.setCellValue(brf59.getR2_three() == null ? 0 : brf59.getR2_three().intValue());
			}
			Cell R2cell19 = R2row.getCell(21);
			if (R2cell19 != null) {
				R2cell19.setCellValue(brf59.getR2_six() == null ? 0 : brf59.getR2_six().intValue());
			}
			Cell R2cell20 = R2row.getCell(22);
			if (R2cell20 != null) {
				R2cell20.setCellValue(brf59.getR2_oneyear() == null ? 0 : brf59.getR2_oneyear().intValue());
			}
			Cell R2cell21 = R2row.getCell(23);
			if (R2cell21 != null) {
				R2cell21.setCellValue(brf59.getR2_foreign() == null ? 0 : brf59.getR2_foreign().intValue());
			}
			Cell R2cell22 = R2row.getCell(24);
			if (R2cell22 != null) {
				R2cell22.setCellValue(brf59.getR2_banks() == null ? 0 : brf59.getR2_banks().intValue());
			}
			Cell R2cell23 = R2row.getCell(25);
			if (R2cell23 != null) {
				R2cell23.setCellValue(brf59.getR2_gov2() == null ? 0 : brf59.getR2_gov2().intValue());
			}
			Cell R2cell24 = R2row.getCell(26);
			if (R2cell24 != null) {
				R2cell24.setCellValue(brf59.getR2_other() == null ? 0 : brf59.getR2_other().intValue());
			}
			Cell R2cell25 = R2row.getCell(27);
			if (R2cell25 != null) {
				R2cell25.setCellValue(brf59.getR2_banks1() == null ? 0 : brf59.getR2_banks1().intValue());
			}
			Cell R2cell26 = R2row.getCell(28);
			if (R2cell26 != null) {
				R2cell26.setCellValue(brf59.getR2_individuals2() == null ? 0 : brf59.getR2_individuals2().intValue());
			}
			Cell R2cell27 = R2row.getCell(29);
			if (R2cell27 != null) {
				R2cell27.setCellValue(brf59.getR2_other1() == null ? 0 : brf59.getR2_other1().intValue());
			}
			Cell R2cell28 = R2row.getCell(30);
			if (R2cell28 != null) {
				R2cell28.setCellValue(brf59.getR2_banks2() == null ? 0 : brf59.getR2_banks2().intValue());
			}
			Cell R2cell29 = R2row.getCell(31);
			if (R2cell29 != null) {
				R2cell29.setCellValue(brf59.getR2_gov3() == null ? 0 : brf59.getR2_gov3().intValue());
			}
			Cell R2cell30 = R2row.getCell(32);
			if (R2cell30 != null) {
				R2cell30.setCellValue(brf59.getR2_others2() == null ? 0 : brf59.getR2_others2().intValue());
			}
			Cell R2cell31 = R2row.getCell(33);
			if (R2cell31 != null) {
				R2cell31.setCellValue(brf59.getR2_banks3() == null ? 0 : brf59.getR2_banks3().intValue());
			}
			Cell R2cell32 = R2row.getCell(34);
			if (R2cell32 != null) {
				R2cell32.setCellValue(brf59.getR2_gov4() == null ? 0 : brf59.getR2_gov4().intValue());
			}
			Cell R2cell33 = R2row.getCell(35);
			if (R2cell33 != null) {
				R2cell33.setCellValue(brf59.getR2_others3() == null ? 0 : brf59.getR2_others3().intValue());
			}
			Cell R2cell34 = R2row.getCell(36);
			if (R2cell34 != null) {
				R2cell34.setCellValue(brf59.getR2_foreign1() == null ? 0 : brf59.getR2_foreign1().intValue());
			}
			Cell R2cell35 = R2row.getCell(37);
			if (R2cell35 != null) {
				R2cell35.setCellValue(brf59.getR2_guarantees() == null ? 0 : brf59.getR2_guarantees().intValue());
			}
			Cell R2cell36 = R2row.getCell(38);
			if (R2cell36 != null) {
				R2cell36.setCellValue(brf59.getR2_nbfi2() == null ? 0 : brf59.getR2_nbfi2().intValue());
			}
			Cell R2cell37 = R2row.getCell(39);
			if (R2cell37 != null) {
				R2cell37.setCellValue(brf59.getR2_interbank2() == null ? 0 : brf59.getR2_interbank2().intValue());
			}
			Cell R2cell38 = R2row.getCell(40);
			if (R2cell38 != null) {
				R2cell38.setCellValue(brf59.getR2_gov5() == null ? 0 : brf59.getR2_gov5().intValue());
			}
			Cell R2cell39 = R2row.getCell(41);
			if (R2cell39 != null) {
				R2cell39.setCellValue(brf59.getR2_corporate2() == null ? 0 : brf59.getR2_corporate2().intValue());
			}
			Cell R2cell40 = R2row.getCell(42);
			if (R2cell40 != null) {
				R2cell40.setCellValue(brf59.getR2_gre2() == null ? 0 : brf59.getR2_gre2().intValue());
			}
			Cell R2cell41 = R2row.getCell(43);
			if (R2cell41 != null) {
				R2cell41.setCellValue(brf59.getR2_individuals3() == null ? 0 : brf59.getR2_individuals3().intValue());
			}
			Cell R2cell42 = R2row.getCell(44);
			if (R2cell42 != null) {
				R2cell42.setCellValue(brf59.getR2_zero1() == null ? 0 : brf59.getR2_zero1().intValue());
			}
			Cell R2cell43 = R2row.getCell(45);
			if (R2cell43 != null) {
				R2cell43.setCellValue(brf59.getR2_three1() == null ? 0 : brf59.getR2_three1().intValue());
			}
			Cell R2cell44 = R2row.getCell(46);
			if (R2cell44 != null) {
				R2cell44.setCellValue(brf59.getR2_six1() == null ? 0 : brf59.getR2_six1().intValue());
			}
			Cell R2cell45 = R2row.getCell(47);
			if (R2cell45 != null) {
				R2cell45.setCellValue(brf59.getR2_oneyear1() == null ? 0 : brf59.getR2_oneyear1().intValue());
			}
			Cell R2cell46 = R2row.getCell(48);
			if (R2cell46 != null) {
				R2cell46.setCellValue(brf59.getR2_empty() == null ? "" : brf59.getR2_empty().toString());
			}
			Row R3row = sheet.getRow(20);
			Cell R3cell1 = R3row.getCell(3);
			if (R3cell1 != null) {
				R3cell1.setCellValue(brf59.getR3_nbfi() == null ? 0 : brf59.getR3_nbfi().intValue());
			}

			Cell R3cell2 = R3row.getCell(4);
			if (R3cell2 != null) {
				R3cell2.setCellValue(brf59.getR3_interbank() == null ? 0 : brf59.getR3_interbank().intValue());
			}
			Cell R3cell3 = R3row.getCell(5);
			if (R3cell3 != null) {
				R3cell3.setCellValue(brf59.getR3_gov() == null ? 0 : brf59.getR3_gov().intValue());
			}
			Cell R3cell4 = R3row.getCell(6);
			if (R3cell4 != null) {
				R3cell4.setCellValue(brf59.getR3_corporate() == null ? 0 : brf59.getR3_corporate().intValue());
			}
			Cell R3cell5 = R3row.getCell(7);
			if (R3cell5 != null) {
				R3cell5.setCellValue(brf59.getR3_gre() == null ? 0 : brf59.getR3_gre().intValue());
			}
			Cell R3cell6 = R3row.getCell(8);
			if (R3cell6 != null) {
				R3cell6.setCellValue(brf59.getR3_trade() == null ? 0 : brf59.getR3_trade().intValue());
			}
			Cell R3cell7 = R3row.getCell(9);
			if (R3cell7 != null) {
				R3cell7.setCellValue(brf59.getR3_individuals() == null ? 0 : brf59.getR3_individuals().intValue());
			}
			Cell R3cell8 = R3row.getCell(10);
			if (R3cell8 != null) {
				R3cell8.setCellValue(brf59.getR3_investment() == null ? 0 : brf59.getR3_investment().intValue());
			}
			Cell R3cell9 = R3row.getCell(11);
			if (R3cell9 != null) {
				R3cell9.setCellValue(brf59.getR3_nbfi1() == null ? 0 : brf59.getR3_nbfi1().intValue());
			}
			Cell R3cell10 = R3row.getCell(12);
			if (R3cell10 != null) {
				R3cell10.setCellValue(brf59.getR3_interbank1() == null ? 0 : brf59.getR3_interbank1().intValue());
			}
			Cell R3cell11 = R3row.getCell(13);
			if (R3cell11 != null) {
				R3cell11.setCellValue(brf59.getR3_gov1() == null ? 0 : brf59.getR3_gov1().intValue());
			}
			Cell R3cell12 = R3row.getCell(14);
			if (R3cell12 != null) {
				R3cell12.setCellValue(brf59.getR3_corporate1() == null ? 0 : brf59.getR3_corporate1().intValue());
			}
			Cell R3cell13 = R3row.getCell(15);
			if (R3cell13 != null) {
				R3cell13.setCellValue(brf59.getR3_gre1() == null ? 0 : brf59.getR3_gre1().intValue());
			}
			Cell R3cell14 = R3row.getCell(16);
			if (R3cell14 != null) {
				R3cell14.setCellValue(brf59.getR3_trade1() == null ? 0 : brf59.getR3_trade1().intValue());
			}
			Cell R3cell15 = R3row.getCell(17);
			if (R3cell15 != null) {
				R3cell15.setCellValue(brf59.getR3_individuals1() == null ? 0 : brf59.getR3_individuals1().intValue());
			}
			Cell R3cell16 = R3row.getCell(18);
			if (R3cell16 != null) {
				R3cell16.setCellValue(brf59.getR3_investment1() == null ? 0 : brf59.getR3_investment1().intValue());
			}
			Cell R3cell17 = R3row.getCell(19);
			if (R3cell17 != null) {
				R3cell17.setCellValue(brf59.getR3_zer0() == null ? 0 : brf59.getR3_zer0().intValue());
			}
			Cell R3cell18 = R3row.getCell(20);
			if (R3cell18 != null) {
				R3cell18.setCellValue(brf59.getR3_three() == null ? 0 : brf59.getR3_three().intValue());
			}
			Cell R3cell19 = R3row.getCell(21);
			if (R3cell19 != null) {
				R3cell19.setCellValue(brf59.getR3_six() == null ? 0 : brf59.getR3_six().intValue());
			}
			Cell R3cell20 = R3row.getCell(22);
			if (R3cell20 != null) {
				R3cell20.setCellValue(brf59.getR3_oneyear() == null ? 0 : brf59.getR3_oneyear().intValue());
			}
			Cell R3cell21 = R3row.getCell(23);
			if (R3cell21 != null) {
				R3cell21.setCellValue(brf59.getR3_foreign() == null ? 0 : brf59.getR3_foreign().intValue());
			}
			Cell R3cell22 = R3row.getCell(24);
			if (R3cell22 != null) {
				R3cell22.setCellValue(brf59.getR3_banks() == null ? 0 : brf59.getR3_banks().intValue());
			}
			Cell R3cell23 = R3row.getCell(25);
			if (R3cell23 != null) {
				R3cell23.setCellValue(brf59.getR3_gov2() == null ? 0 : brf59.getR3_gov2().intValue());
			}
			Cell R3cell24 = R3row.getCell(26);
			if (R3cell24 != null) {
				R3cell24.setCellValue(brf59.getR3_other() == null ? 0 : brf59.getR3_other().intValue());
			}
			Cell R3cell25 = R3row.getCell(27);
			if (R3cell25 != null) {
				R3cell25.setCellValue(brf59.getR3_banks1() == null ? 0 : brf59.getR3_banks1().intValue());
			}
			Cell R3cell26 = R3row.getCell(28);
			if (R3cell26 != null) {
				R3cell26.setCellValue(brf59.getR3_individuals2() == null ? 0 : brf59.getR3_individuals2().intValue());
			}
			Cell R3cell27 = R3row.getCell(29);
			if (R3cell27 != null) {
				R3cell27.setCellValue(brf59.getR3_other1() == null ? 0 : brf59.getR3_other1().intValue());
			}
			Cell R3cell28 = R3row.getCell(30);
			if (R3cell28 != null) {
				R3cell28.setCellValue(brf59.getR3_banks2() == null ? 0 : brf59.getR3_banks2().intValue());
			}
			Cell R3cell29 = R3row.getCell(31);
			if (R3cell29 != null) {
				R3cell29.setCellValue(brf59.getR3_gov3() == null ? 0 : brf59.getR3_gov3().intValue());
			}
			Cell R3cell30 = R3row.getCell(32);
			if (R3cell30 != null) {
				R3cell30.setCellValue(brf59.getR3_others2() == null ? 0 : brf59.getR3_others2().intValue());
			}
			Cell R3cell31 = R3row.getCell(33);
			if (R3cell31 != null) {
				R3cell31.setCellValue(brf59.getR3_banks3() == null ? 0 : brf59.getR3_banks3().intValue());
			}
			Cell R3cell32 = R3row.getCell(34);
			if (R3cell32 != null) {
				R3cell32.setCellValue(brf59.getR3_gov4() == null ? 0 : brf59.getR3_gov4().intValue());
			}
			Cell R3cell33 = R3row.getCell(35);
			if (R3cell33 != null) {
				R3cell33.setCellValue(brf59.getR3_others3() == null ? 0 : brf59.getR3_others3().intValue());
			}
			Cell R3cell34 = R3row.getCell(36);
			if (R3cell34 != null) {
				R3cell34.setCellValue(brf59.getR3_foreign1() == null ? 0 : brf59.getR3_foreign1().intValue());
			}
			Cell R3cell35 = R3row.getCell(37);
			if (R3cell35 != null) {
				R3cell35.setCellValue(brf59.getR3_guarantees() == null ? 0 : brf59.getR3_guarantees().intValue());
			}
			Cell R3cell36 = R3row.getCell(38);
			if (R3cell36 != null) {
				R3cell36.setCellValue(brf59.getR3_nbfi2() == null ? 0 : brf59.getR3_nbfi2().intValue());
			}
			Cell R3cell37 = R3row.getCell(39);
			if (R3cell37 != null) {
				R3cell37.setCellValue(brf59.getR3_interbank2() == null ? 0 : brf59.getR3_interbank2().intValue());
			}
			Cell R3cell38 = R3row.getCell(40);
			if (R3cell38 != null) {
				R3cell38.setCellValue(brf59.getR3_gov5() == null ? 0 : brf59.getR3_gov5().intValue());
			}
			Cell R3cell39 = R3row.getCell(41);
			if (R3cell39 != null) {
				R3cell39.setCellValue(brf59.getR3_corporate2() == null ? 0 : brf59.getR3_corporate2().intValue());
			}
			Cell R3cell40 = R3row.getCell(42);
			if (R3cell40 != null) {
				R3cell40.setCellValue(brf59.getR3_gre2() == null ? 0 : brf59.getR3_gre2().intValue());
			}
			Cell R3cell41 = R3row.getCell(43);
			if (R3cell41 != null) {
				R3cell41.setCellValue(brf59.getR3_individuals3() == null ? 0 : brf59.getR3_individuals3().intValue());
			}
			Cell R3cell42 = R3row.getCell(44);
			if (R3cell42 != null) {
				R3cell42.setCellValue(brf59.getR3_zero1() == null ? 0 : brf59.getR3_zero1().intValue());
			}
			Cell R3cell43 = R3row.getCell(45);
			if (R3cell43 != null) {
				R3cell43.setCellValue(brf59.getR3_three1() == null ? 0 : brf59.getR3_three1().intValue());
			}
			Cell R3cell44 = R3row.getCell(46);
			if (R3cell44 != null) {
				R3cell44.setCellValue(brf59.getR3_six1() == null ? 0 : brf59.getR3_six1().intValue());
			}
			Cell R3cell45 = R3row.getCell(47);
			if (R3cell45 != null) {
				R3cell45.setCellValue(brf59.getR3_oneyear1() == null ? 0 : brf59.getR3_oneyear1().intValue());
			}
			Cell R3cell46 = R3row.getCell(48);
			if (R3cell46 != null) {
				R3cell46.setCellValue(brf59.getR3_empty() == null ? "" : brf59.getR3_empty().toString());
			}
			Row R5row = sheet.getRow(22);
			Cell R5cell1 = R5row.getCell(3);
			if (R5cell1 != null) {
				R5cell1.setCellValue(brf59.getR5_nbfi() == null ? 0 : brf59.getR5_nbfi().intValue());
			}

			Cell R5cell2 = R5row.getCell(4);
			if (R5cell2 != null) {
				R5cell2.setCellValue(brf59.getR5_interbank() == null ? 0 : brf59.getR5_interbank().intValue());
			}
			Cell R5cell3 = R5row.getCell(5);
			if (R5cell3 != null) {
				R5cell3.setCellValue(brf59.getR5_gov() == null ? 0 : brf59.getR5_gov().intValue());
			}
			Cell R5cell4 = R5row.getCell(6);
			if (R5cell4 != null) {
				R5cell4.setCellValue(brf59.getR5_corporate() == null ? 0 : brf59.getR5_corporate().intValue());
			}
			Cell R5cell5 = R5row.getCell(7);
			if (R5cell5 != null) {
				R5cell5.setCellValue(brf59.getR5_gre() == null ? 0 : brf59.getR5_gre().intValue());
			}
			Cell R5cell6 = R5row.getCell(8);
			if (R5cell6 != null) {
				R5cell6.setCellValue(brf59.getR5_trade() == null ? 0 : brf59.getR5_trade().intValue());
			}
			Cell R5cell7 = R5row.getCell(9);
			if (R5cell7 != null) {
				R5cell7.setCellValue(brf59.getR5_individuals() == null ? 0 : brf59.getR5_individuals().intValue());
			}
			Cell R5cell8 = R5row.getCell(10);
			if (R5cell8 != null) {
				R5cell8.setCellValue(brf59.getR5_investment() == null ? 0 : brf59.getR5_investment().intValue());
			}
			Cell R5cell9 = R5row.getCell(11);
			if (R5cell9 != null) {
				R5cell9.setCellValue(brf59.getR5_nbfi1() == null ? 0 : brf59.getR5_nbfi1().intValue());
			}
			Cell R5cell10 = R5row.getCell(12);
			if (R5cell10 != null) {
				R5cell10.setCellValue(brf59.getR5_interbank1() == null ? 0 : brf59.getR5_interbank1().intValue());
			}
			Cell R5cell11 = R5row.getCell(13);
			if (R5cell11 != null) {
				R5cell11.setCellValue(brf59.getR5_gov1() == null ? 0 : brf59.getR5_gov1().intValue());
			}
			Cell R5cell12 = R5row.getCell(14);
			if (R5cell12 != null) {
				R5cell12.setCellValue(brf59.getR5_corporate1() == null ? 0 : brf59.getR5_corporate1().intValue());
			}
			Cell R5cell13 = R5row.getCell(15);
			if (R5cell13 != null) {
				R5cell13.setCellValue(brf59.getR5_gre1() == null ? 0 : brf59.getR5_gre1().intValue());
			}
			Cell R5cell14 = R5row.getCell(16);
			if (R5cell14 != null) {
				R5cell14.setCellValue(brf59.getR5_trade1() == null ? 0 : brf59.getR5_trade1().intValue());
			}
			Cell R5cell15 = R5row.getCell(17);
			if (R5cell15 != null) {
				R5cell15.setCellValue(brf59.getR5_individuals1() == null ? 0 : brf59.getR5_individuals1().intValue());
			}
			Cell R5cell16 = R5row.getCell(18);
			if (R5cell16 != null) {
				R5cell16.setCellValue(brf59.getR5_investment1() == null ? 0 : brf59.getR5_investment1().intValue());
			}
			Cell R5cell17 = R5row.getCell(19);
			if (R5cell17 != null) {
				R5cell17.setCellValue(brf59.getR5_zer0() == null ? 0 : brf59.getR5_zer0().intValue());
			}
			Cell R5cell18 = R5row.getCell(20);
			if (R5cell18 != null) {
				R5cell18.setCellValue(brf59.getR5_three() == null ? 0 : brf59.getR5_three().intValue());
			}
			Cell R5cell19 = R5row.getCell(21);
			if (R5cell19 != null) {
				R5cell19.setCellValue(brf59.getR5_six() == null ? 0 : brf59.getR5_six().intValue());
			}
			Cell R5cell20 = R5row.getCell(22);
			if (R5cell20 != null) {
				R5cell20.setCellValue(brf59.getR5_oneyear() == null ? 0 : brf59.getR5_oneyear().intValue());
			}
			Cell R5cell21 = R5row.getCell(23);
			if (R5cell21 != null) {
				R5cell21.setCellValue(brf59.getR5_foreign() == null ? 0 : brf59.getR5_foreign().intValue());
			}
			Cell R5cell22 = R5row.getCell(24);
			if (R5cell22 != null) {
				R5cell22.setCellValue(brf59.getR5_banks() == null ? 0 : brf59.getR5_banks().intValue());
			}
			Cell R5cell23 = R5row.getCell(25);
			if (R5cell23 != null) {
				R5cell23.setCellValue(brf59.getR5_gov2() == null ? 0 : brf59.getR5_gov2().intValue());
			}
			Cell R5cell24 = R5row.getCell(26);
			if (R5cell24 != null) {
				R5cell24.setCellValue(brf59.getR5_other() == null ? 0 : brf59.getR5_other().intValue());
			}
			Cell R5cell25 = R5row.getCell(27);
			if (R5cell25 != null) {
				R5cell25.setCellValue(brf59.getR5_banks1() == null ? 0 : brf59.getR5_banks1().intValue());
			}
			Cell R5cell26 = R5row.getCell(28);
			if (R5cell26 != null) {
				R5cell26.setCellValue(brf59.getR5_individuals2() == null ? 0 : brf59.getR5_individuals2().intValue());
			}
			Cell R5cell27 = R5row.getCell(29);
			if (R5cell27 != null) {
				R5cell27.setCellValue(brf59.getR5_other1() == null ? 0 : brf59.getR5_other1().intValue());
			}
			Cell R5cell28 = R5row.getCell(30);
			if (R5cell28 != null) {
				R5cell28.setCellValue(brf59.getR5_banks2() == null ? 0 : brf59.getR5_banks2().intValue());
			}
			Cell R5cell29 = R5row.getCell(31);
			if (R5cell29 != null) {
				R5cell29.setCellValue(brf59.getR5_gov3() == null ? 0 : brf59.getR5_gov3().intValue());
			}
			Cell R5cell30 = R5row.getCell(32);
			if (R5cell30 != null) {
				R5cell30.setCellValue(brf59.getR5_others2() == null ? 0 : brf59.getR5_others2().intValue());
			}
			Cell R5cell31 = R5row.getCell(33);
			if (R5cell31 != null) {
				R5cell31.setCellValue(brf59.getR5_banks3() == null ? 0 : brf59.getR5_banks3().intValue());
			}
			Cell R5cell32 = R5row.getCell(34);
			if (R5cell32 != null) {
				R5cell32.setCellValue(brf59.getR5_gov4() == null ? 0 : brf59.getR5_gov4().intValue());
			}
			Cell R5cell33 = R5row.getCell(35);
			if (R5cell33 != null) {
				R5cell33.setCellValue(brf59.getR5_others3() == null ? 0 : brf59.getR5_others3().intValue());
			}
			Cell R5cell34 = R5row.getCell(36);
			if (R5cell34 != null) {
				R5cell34.setCellValue(brf59.getR5_foreign1() == null ? 0 : brf59.getR5_foreign1().intValue());
			}
			Cell R5cell35 = R5row.getCell(37);
			if (R5cell35 != null) {
				R5cell35.setCellValue(brf59.getR5_guarantees() == null ? 0 : brf59.getR5_guarantees().intValue());
			}
			Cell R5cell36 = R5row.getCell(38);
			if (R5cell36 != null) {
				R5cell36.setCellValue(brf59.getR5_nbfi2() == null ? 0 : brf59.getR5_nbfi2().intValue());
			}
			Cell R5cell37 = R5row.getCell(39);
			if (R5cell37 != null) {
				R5cell37.setCellValue(brf59.getR5_interbank2() == null ? 0 : brf59.getR5_interbank2().intValue());
			}
			Cell R5cell38 = R5row.getCell(40);
			if (R5cell38 != null) {
				R5cell38.setCellValue(brf59.getR5_gov5() == null ? 0 : brf59.getR5_gov5().intValue());
			}
			Cell R5cell39 = R5row.getCell(41);
			if (R5cell39 != null) {
				R5cell39.setCellValue(brf59.getR5_corporate2() == null ? 0 : brf59.getR5_corporate2().intValue());
			}
			Cell R5cell40 = R5row.getCell(42);
			if (R5cell40 != null) {
				R5cell40.setCellValue(brf59.getR5_gre2() == null ? 0 : brf59.getR5_gre2().intValue());
			}
			Cell R5cell41 = R5row.getCell(43);
			if (R5cell41 != null) {
				R5cell41.setCellValue(brf59.getR5_individuals3() == null ? 0 : brf59.getR5_individuals3().intValue());
			}
			Cell R5cell42 = R5row.getCell(44);
			if (R5cell42 != null) {
				R5cell42.setCellValue(brf59.getR5_zero1() == null ? 0 : brf59.getR5_zero1().intValue());
			}
			Cell R5cell43 = R5row.getCell(45);
			if (R5cell43 != null) {
				R5cell43.setCellValue(brf59.getR5_three1() == null ? 0 : brf59.getR5_three1().intValue());
			}
			Cell R5cell44 = R5row.getCell(46);
			if (R5cell44 != null) {
				R5cell44.setCellValue(brf59.getR5_six1() == null ? 0 : brf59.getR5_six1().intValue());
			}
			Cell R5cell45 = R5row.getCell(47);
			if (R5cell45 != null) {
				R5cell45.setCellValue(brf59.getR5_oneyear1() == null ? 0 : brf59.getR5_oneyear1().intValue());
			}
			Cell R5cell46 = R5row.getCell(48);
			if (R5cell46 != null) {
				R5cell46.setCellValue(brf59.getR5_empty() == null ? "" : brf59.getR5_empty().toString());
			}
			Row R6row = sheet.getRow(23);
			Cell R6cell1 = R6row.getCell(3);
			if (R6cell1 != null) {
				R6cell1.setCellValue(brf59.getR6_nbfi() == null ? 0 : brf59.getR6_nbfi().intValue());
			}

			Cell R6cell2 = R6row.getCell(4);
			if (R6cell2 != null) {
				R6cell2.setCellValue(brf59.getR6_interbank() == null ? 0 : brf59.getR6_interbank().intValue());
			}
			Cell R6cell3 = R6row.getCell(5);
			if (R6cell3 != null) {
				R6cell3.setCellValue(brf59.getR6_gov() == null ? 0 : brf59.getR6_gov().intValue());
			}
			Cell R6cell4 = R6row.getCell(6);
			if (R6cell4 != null) {
				R6cell4.setCellValue(brf59.getR6_corporate() == null ? 0 : brf59.getR6_corporate().intValue());
			}
			Cell R6cell5 = R6row.getCell(7);
			if (R6cell5 != null) {
				R6cell5.setCellValue(brf59.getR6_gre() == null ? 0 : brf59.getR6_gre().intValue());
			}
			Cell R6cell6 = R6row.getCell(8);
			if (R6cell6 != null) {
				R6cell6.setCellValue(brf59.getR6_trade() == null ? 0 : brf59.getR6_trade().intValue());
			}
			Cell R6cell7 = R6row.getCell(9);
			if (R6cell7 != null) {
				R6cell7.setCellValue(brf59.getR6_individuals() == null ? 0 : brf59.getR6_individuals().intValue());
			}
			Cell R6cell8 = R6row.getCell(10);
			if (R6cell8 != null) {
				R6cell8.setCellValue(brf59.getR6_investment() == null ? 0 : brf59.getR6_investment().intValue());
			}
			Cell R6cell9 = R6row.getCell(11);
			if (R6cell9 != null) {
				R6cell9.setCellValue(brf59.getR6_nbfi1() == null ? 0 : brf59.getR6_nbfi1().intValue());
			}
			Cell R6cell10 = R6row.getCell(12);
			if (R6cell10 != null) {
				R6cell10.setCellValue(brf59.getR6_interbank1() == null ? 0 : brf59.getR6_interbank1().intValue());
			}
			Cell R6cell11 = R6row.getCell(13);
			if (R6cell11 != null) {
				R6cell11.setCellValue(brf59.getR6_gov1() == null ? 0 : brf59.getR6_gov1().intValue());
			}
			Cell R6cell12 = R6row.getCell(14);
			if (R6cell12 != null) {
				R6cell12.setCellValue(brf59.getR6_corporate1() == null ? 0 : brf59.getR6_corporate1().intValue());
			}
			Cell R6cell13 = R6row.getCell(15);
			if (R6cell13 != null) {
				R6cell13.setCellValue(brf59.getR6_gre1() == null ? 0 : brf59.getR6_gre1().intValue());
			}
			Cell R6cell14 = R6row.getCell(16);
			if (R6cell14 != null) {
				R6cell14.setCellValue(brf59.getR6_trade1() == null ? 0 : brf59.getR6_trade1().intValue());
			}
			Cell R6cell15 = R6row.getCell(17);
			if (R6cell15 != null) {
				R6cell15.setCellValue(brf59.getR6_individuals1() == null ? 0 : brf59.getR6_individuals1().intValue());
			}
			Cell R6cell16 = R6row.getCell(18);
			if (R6cell16 != null) {
				R6cell16.setCellValue(brf59.getR6_investment1() == null ? 0 : brf59.getR6_investment1().intValue());
			}
			Cell R6cell17 = R6row.getCell(19);
			if (R6cell17 != null) {
				R6cell17.setCellValue(brf59.getR6_zer0() == null ? 0 : brf59.getR6_zer0().intValue());
			}
			Cell R6cell18 = R6row.getCell(20);
			if (R6cell18 != null) {
				R6cell18.setCellValue(brf59.getR6_three() == null ? 0 : brf59.getR6_three().intValue());
			}
			Cell R6cell19 = R6row.getCell(21);
			if (R6cell19 != null) {
				R6cell19.setCellValue(brf59.getR6_six() == null ? 0 : brf59.getR6_six().intValue());
			}
			Cell R6cell20 = R6row.getCell(22);
			if (R6cell20 != null) {
				R6cell20.setCellValue(brf59.getR6_oneyear() == null ? 0 : brf59.getR6_oneyear().intValue());
			}
			Cell R6cell21 = R6row.getCell(23);
			if (R6cell21 != null) {
				R6cell21.setCellValue(brf59.getR6_foreign() == null ? 0 : brf59.getR6_foreign().intValue());
			}
			Cell R6cell22 = R6row.getCell(24);
			if (R6cell22 != null) {
				R6cell22.setCellValue(brf59.getR6_banks() == null ? 0 : brf59.getR6_banks().intValue());
			}
			Cell R6cell23 = R6row.getCell(25);
			if (R6cell23 != null) {
				R6cell23.setCellValue(brf59.getR6_gov2() == null ? 0 : brf59.getR6_gov2().intValue());
			}
			Cell R6cell24 = R6row.getCell(26);
			if (R6cell24 != null) {
				R6cell24.setCellValue(brf59.getR6_other() == null ? 0 : brf59.getR6_other().intValue());
			}
			Cell R6cell25 = R6row.getCell(27);
			if (R6cell25 != null) {
				R6cell25.setCellValue(brf59.getR6_banks1() == null ? 0 : brf59.getR6_banks1().intValue());
			}
			Cell R6cell26 = R6row.getCell(28);
			if (R6cell26 != null) {
				R6cell26.setCellValue(brf59.getR6_individuals2() == null ? 0 : brf59.getR6_individuals2().intValue());
			}
			Cell R6cell27 = R6row.getCell(29);
			if (R6cell27 != null) {
				R6cell27.setCellValue(brf59.getR6_other1() == null ? 0 : brf59.getR6_other1().intValue());
			}
			Cell R6cell28 = R6row.getCell(30);
			if (R6cell28 != null) {
				R6cell28.setCellValue(brf59.getR6_banks2() == null ? 0 : brf59.getR6_banks2().intValue());
			}
			Cell R6cell29 = R6row.getCell(31);
			if (R6cell29 != null) {
				R6cell29.setCellValue(brf59.getR6_gov3() == null ? 0 : brf59.getR6_gov3().intValue());
			}
			Cell R6cell30 = R6row.getCell(32);
			if (R6cell30 != null) {
				R6cell30.setCellValue(brf59.getR6_others2() == null ? 0 : brf59.getR6_others2().intValue());
			}
			Cell R6cell31 = R6row.getCell(33);
			if (R6cell31 != null) {
				R6cell31.setCellValue(brf59.getR6_banks3() == null ? 0 : brf59.getR6_banks3().intValue());
			}
			Cell R6cell32 = R6row.getCell(34);
			if (R6cell32 != null) {
				R6cell32.setCellValue(brf59.getR6_gov4() == null ? 0 : brf59.getR6_gov4().intValue());
			}
			Cell R6cell33 = R6row.getCell(35);
			if (R6cell33 != null) {
				R6cell33.setCellValue(brf59.getR6_others3() == null ? 0 : brf59.getR6_others3().intValue());
			}
			Cell R6cell34 = R6row.getCell(36);
			if (R6cell34 != null) {
				R6cell34.setCellValue(brf59.getR6_foreign1() == null ? 0 : brf59.getR6_foreign1().intValue());
			}
			Cell R6cell35 = R6row.getCell(37);
			if (R6cell35 != null) {
				R6cell35.setCellValue(brf59.getR6_guarantees() == null ? 0 : brf59.getR6_guarantees().intValue());
			}
			Cell R6cell36 = R6row.getCell(38);
			if (R6cell36 != null) {
				R6cell36.setCellValue(brf59.getR6_nbfi2() == null ? 0 : brf59.getR6_nbfi2().intValue());
			}
			Cell R6cell37 = R6row.getCell(39);
			if (R6cell37 != null) {
				R6cell37.setCellValue(brf59.getR6_interbank2() == null ? 0 : brf59.getR6_interbank2().intValue());
			}
			Cell R6cell38 = R6row.getCell(40);
			if (R6cell38 != null) {
				R6cell38.setCellValue(brf59.getR6_gov5() == null ? 0 : brf59.getR6_gov5().intValue());
			}
			Cell R6cell39 = R6row.getCell(41);
			if (R6cell39 != null) {
				R6cell39.setCellValue(brf59.getR6_corporate2() == null ? 0 : brf59.getR6_corporate2().intValue());
			}
			Cell R6cell40 = R6row.getCell(42);
			if (R6cell40 != null) {
				R6cell40.setCellValue(brf59.getR6_gre2() == null ? 0 : brf59.getR6_gre2().intValue());
			}
			Cell R6cell41 = R6row.getCell(43);
			if (R6cell41 != null) {
				R6cell41.setCellValue(brf59.getR6_individuals3() == null ? 0 : brf59.getR6_individuals3().intValue());
			}
			Cell R6cell42 = R6row.getCell(44);
			if (R6cell42 != null) {
				R6cell42.setCellValue(brf59.getR6_zero1() == null ? 0 : brf59.getR6_zero1().intValue());
			}
			Cell R6cell43 = R6row.getCell(45);
			if (R6cell43 != null) {
				R6cell43.setCellValue(brf59.getR6_three1() == null ? 0 : brf59.getR6_three1().intValue());
			}
			Cell R6cell44 = R6row.getCell(46);
			if (R6cell44 != null) {
				R6cell44.setCellValue(brf59.getR6_six1() == null ? 0 : brf59.getR6_six1().intValue());
			}
			Cell R6cell45 = R6row.getCell(47);
			if (R6cell45 != null) {
				R6cell45.setCellValue(brf59.getR6_oneyear1() == null ? 0 : brf59.getR6_oneyear1().intValue());
			}
			Cell R6cell46 = R6row.getCell(48);
			if (R6cell46 != null) {
				R6cell46.setCellValue(brf59.getR6_empty() == null ? "" : brf59.getR6_empty().toString());
			}
			Row R7row = sheet.getRow(24);
			Cell R7cell1 = R7row.getCell(3);
			if (R7cell1 != null) {
				R7cell1.setCellValue(brf59.getR7_nbfi() == null ? 0 : brf59.getR7_nbfi().intValue());
			}

			Cell R7cell2 = R7row.getCell(4);
			if (R7cell2 != null) {
				R7cell2.setCellValue(brf59.getR7_interbank() == null ? 0 : brf59.getR7_interbank().intValue());
			}
			Cell R7cell3 = R7row.getCell(5);
			if (R7cell3 != null) {
				R7cell3.setCellValue(brf59.getR7_gov() == null ? 0 : brf59.getR7_gov().intValue());
			}
			Cell R7cell4 = R7row.getCell(6);
			if (R7cell4 != null) {
				R7cell4.setCellValue(brf59.getR7_corporate() == null ? 0 : brf59.getR7_corporate().intValue());
			}
			Cell R7cell5 = R7row.getCell(7);
			if (R7cell5 != null) {
				R7cell5.setCellValue(brf59.getR7_gre() == null ? 0 : brf59.getR7_gre().intValue());
			}
			Cell R7cell6 = R7row.getCell(8);
			if (R7cell6 != null) {
				R7cell6.setCellValue(brf59.getR7_trade() == null ? 0 : brf59.getR7_trade().intValue());
			}
			Cell R7cell7 = R7row.getCell(9);
			if (R7cell7 != null) {
				R7cell7.setCellValue(brf59.getR7_individuals() == null ? 0 : brf59.getR7_individuals().intValue());
			}
			Cell R7cell8 = R7row.getCell(10);
			if (R7cell8 != null) {
				R7cell8.setCellValue(brf59.getR7_investment() == null ? 0 : brf59.getR7_investment().intValue());
			}
			Cell R7cell9 = R7row.getCell(11);
			if (R7cell9 != null) {
				R7cell9.setCellValue(brf59.getR7_nbfi1() == null ? 0 : brf59.getR7_nbfi1().intValue());
			}
			Cell R7cell10 = R7row.getCell(12);
			if (R7cell10 != null) {
				R7cell10.setCellValue(brf59.getR7_interbank1() == null ? 0 : brf59.getR7_interbank1().intValue());
			}
			Cell R7cell11 = R7row.getCell(13);
			if (R7cell11 != null) {
				R7cell11.setCellValue(brf59.getR7_gov1() == null ? 0 : brf59.getR7_gov1().intValue());
			}
			Cell R7cell12 = R7row.getCell(14);
			if (R7cell12 != null) {
				R7cell12.setCellValue(brf59.getR7_corporate1() == null ? 0 : brf59.getR7_corporate1().intValue());
			}
			Cell R7cell13 = R7row.getCell(15);
			if (R7cell13 != null) {
				R7cell13.setCellValue(brf59.getR7_gre1() == null ? 0 : brf59.getR7_gre1().intValue());
			}
			Cell R7cell14 = R7row.getCell(16);
			if (R7cell14 != null) {
				R7cell14.setCellValue(brf59.getR7_trade1() == null ? 0 : brf59.getR7_trade1().intValue());
			}
			Cell R7cell15 = R7row.getCell(17);
			if (R7cell15 != null) {
				R7cell15.setCellValue(brf59.getR7_individuals1() == null ? 0 : brf59.getR7_individuals1().intValue());
			}
			Cell R7cell16 = R7row.getCell(18);
			if (R7cell16 != null) {
				R7cell16.setCellValue(brf59.getR7_investment1() == null ? 0 : brf59.getR7_investment1().intValue());
			}
			Cell R7cell17 = R7row.getCell(19);
			if (R7cell17 != null) {
				R7cell17.setCellValue(brf59.getR7_zer0() == null ? 0 : brf59.getR7_zer0().intValue());
			}
			Cell R7cell18 = R7row.getCell(20);
			if (R7cell18 != null) {
				R7cell18.setCellValue(brf59.getR7_three() == null ? 0 : brf59.getR7_three().intValue());
			}
			Cell R7cell19 = R7row.getCell(21);
			if (R7cell19 != null) {
				R7cell19.setCellValue(brf59.getR7_six() == null ? 0 : brf59.getR7_six().intValue());
			}
			Cell R7cell20 = R7row.getCell(22);
			if (R7cell20 != null) {
				R7cell20.setCellValue(brf59.getR7_oneyear() == null ? 0 : brf59.getR7_oneyear().intValue());
			}
			Cell R7cell21 = R7row.getCell(23);
			if (R7cell21 != null) {
				R7cell21.setCellValue(brf59.getR7_foreign() == null ? 0 : brf59.getR7_foreign().intValue());
			}
			Cell R7cell22 = R7row.getCell(24);
			if (R7cell22 != null) {
				R7cell22.setCellValue(brf59.getR7_banks() == null ? 0 : brf59.getR7_banks().intValue());
			}
			Cell R7cell23 = R7row.getCell(25);
			if (R7cell23 != null) {
				R7cell23.setCellValue(brf59.getR7_gov2() == null ? 0 : brf59.getR7_gov2().intValue());
			}
			Cell R7cell24 = R7row.getCell(26);
			if (R7cell24 != null) {
				R7cell24.setCellValue(brf59.getR7_other() == null ? 0 : brf59.getR7_other().intValue());
			}
			Cell R7cell25 = R7row.getCell(27);
			if (R7cell25 != null) {
				R7cell25.setCellValue(brf59.getR7_banks1() == null ? 0 : brf59.getR7_banks1().intValue());
			}
			Cell R7cell26 = R7row.getCell(28);
			if (R7cell26 != null) {
				R7cell26.setCellValue(brf59.getR7_individuals2() == null ? 0 : brf59.getR7_individuals2().intValue());
			}
			Cell R7cell27 = R7row.getCell(29);
			if (R7cell27 != null) {
				R7cell27.setCellValue(brf59.getR7_other1() == null ? 0 : brf59.getR7_other1().intValue());
			}
			Cell R7cell28 = R7row.getCell(30);
			if (R7cell28 != null) {
				R7cell28.setCellValue(brf59.getR7_banks2() == null ? 0 : brf59.getR7_banks2().intValue());
			}
			Cell R7cell29 = R7row.getCell(31);
			if (R7cell29 != null) {
				R7cell29.setCellValue(brf59.getR7_gov3() == null ? 0 : brf59.getR7_gov3().intValue());
			}
			Cell R7cell30 = R7row.getCell(32);
			if (R7cell30 != null) {
				R7cell30.setCellValue(brf59.getR7_others2() == null ? 0 : brf59.getR7_others2().intValue());
			}
			Cell R7cell31 = R7row.getCell(33);
			if (R7cell31 != null) {
				R7cell31.setCellValue(brf59.getR7_banks3() == null ? 0 : brf59.getR7_banks3().intValue());
			}
			Cell R7cell32 = R7row.getCell(34);
			if (R7cell32 != null) {
				R7cell32.setCellValue(brf59.getR7_gov4() == null ? 0 : brf59.getR7_gov4().intValue());
			}
			Cell R7cell33 = R7row.getCell(35);
			if (R7cell33 != null) {
				R7cell33.setCellValue(brf59.getR7_others3() == null ? 0 : brf59.getR7_others3().intValue());
			}
			Cell R7cell34 = R7row.getCell(36);
			if (R7cell34 != null) {
				R7cell34.setCellValue(brf59.getR7_foreign1() == null ? 0 : brf59.getR7_foreign1().intValue());
			}
			Cell R7cell35 = R7row.getCell(37);
			if (R7cell35 != null) {
				R7cell35.setCellValue(brf59.getR7_guarantees() == null ? 0 : brf59.getR7_guarantees().intValue());
			}
			Cell R7cell36 = R7row.getCell(38);
			if (R7cell36 != null) {
				R7cell36.setCellValue(brf59.getR7_nbfi2() == null ? 0 : brf59.getR7_nbfi2().intValue());
			}
			Cell R7cell37 = R7row.getCell(39);
			if (R7cell37 != null) {
				R7cell37.setCellValue(brf59.getR7_interbank2() == null ? 0 : brf59.getR7_interbank2().intValue());
			}
			Cell R7cell38 = R7row.getCell(40);
			if (R7cell38 != null) {
				R7cell38.setCellValue(brf59.getR7_gov5() == null ? 0 : brf59.getR7_gov5().intValue());
			}
			Cell R7cell39 = R7row.getCell(41);
			if (R7cell39 != null) {
				R7cell39.setCellValue(brf59.getR7_corporate2() == null ? 0 : brf59.getR7_corporate2().intValue());
			}
			Cell R7cell40 = R7row.getCell(42);
			if (R7cell40 != null) {
				R7cell40.setCellValue(brf59.getR7_gre2() == null ? 0 : brf59.getR7_gre2().intValue());
			}
			Cell R7cell41 = R7row.getCell(43);
			if (R7cell41 != null) {
				R7cell41.setCellValue(brf59.getR7_individuals3() == null ? 0 : brf59.getR7_individuals3().intValue());
			}
			Cell R7cell42 = R7row.getCell(44);
			if (R7cell42 != null) {
				R7cell42.setCellValue(brf59.getR7_zero1() == null ? 0 : brf59.getR7_zero1().intValue());
			}
			Cell R7cell43 = R7row.getCell(45);
			if (R7cell43 != null) {
				R7cell43.setCellValue(brf59.getR7_three1() == null ? 0 : brf59.getR7_three1().intValue());
			}
			Cell R7cell44 = R7row.getCell(46);
			if (R7cell44 != null) {
				R7cell44.setCellValue(brf59.getR7_six1() == null ? 0 : brf59.getR7_six1().intValue());
			}
			Cell R7cell45 = R7row.getCell(47);
			if (R7cell45 != null) {
				R7cell45.setCellValue(brf59.getR7_oneyear1() == null ? 0 : brf59.getR7_oneyear1().intValue());
			}
			Cell R7cell46 = R7row.getCell(48);
			if (R7cell46 != null) {
				R7cell46.setCellValue(brf59.getR7_empty() == null ? "" : brf59.getR7_empty().toString());
			}
			Row R8row = sheet.getRow(25);
			Cell R8cell1 = R8row.getCell(3);
			if (R8cell1 != null) {
				R8cell1.setCellValue(brf59.getR8_nbfi() == null ? 0 : brf59.getR8_nbfi().intValue());
			}

			Cell R8cell2 = R8row.getCell(4);
			if (R8cell2 != null) {
				R8cell2.setCellValue(brf59.getR8_interbank() == null ? 0 : brf59.getR8_interbank().intValue());
			}
			Cell R8cell3 = R8row.getCell(5);
			if (R8cell3 != null) {
				R8cell3.setCellValue(brf59.getR8_gov() == null ? 0 : brf59.getR8_gov().intValue());
			}
			Cell R8cell4 = R8row.getCell(6);
			if (R8cell4 != null) {
				R8cell4.setCellValue(brf59.getR8_corporate() == null ? 0 : brf59.getR8_corporate().intValue());
			}
			Cell R8cell5 = R8row.getCell(7);
			if (R8cell5 != null) {
				R8cell5.setCellValue(brf59.getR8_gre() == null ? 0 : brf59.getR8_gre().intValue());
			}
			Cell R8cell6 = R8row.getCell(8);
			if (R8cell6 != null) {
				R8cell6.setCellValue(brf59.getR8_trade() == null ? 0 : brf59.getR8_trade().intValue());
			}
			Cell R8cell7 = R8row.getCell(9);
			if (R8cell7 != null) {
				R8cell7.setCellValue(brf59.getR8_individuals() == null ? 0 : brf59.getR8_individuals().intValue());
			}
			Cell R8cell8 = R8row.getCell(10);
			if (R8cell8 != null) {
				R8cell8.setCellValue(brf59.getR8_investment() == null ? 0 : brf59.getR8_investment().intValue());
			}
			Cell R8cell9 = R8row.getCell(11);
			if (R8cell9 != null) {
				R8cell9.setCellValue(brf59.getR8_nbfi1() == null ? 0 : brf59.getR8_nbfi1().intValue());
			}
			Cell R8cell10 = R8row.getCell(12);
			if (R8cell10 != null) {
				R8cell10.setCellValue(brf59.getR8_interbank1() == null ? 0 : brf59.getR8_interbank1().intValue());
			}
			Cell R8cell11 = R8row.getCell(13);
			if (R8cell11 != null) {
				R8cell11.setCellValue(brf59.getR8_gov1() == null ? 0 : brf59.getR8_gov1().intValue());
			}
			Cell R8cell12 = R8row.getCell(14);
			if (R8cell12 != null) {
				R8cell12.setCellValue(brf59.getR8_corporate1() == null ? 0 : brf59.getR8_corporate1().intValue());
			}
			Cell R8cell13 = R8row.getCell(15);
			if (R8cell13 != null) {
				R8cell13.setCellValue(brf59.getR8_gre1() == null ? 0 : brf59.getR8_gre1().intValue());
			}
			Cell R8cell14 = R8row.getCell(16);
			if (R8cell14 != null) {
				R8cell14.setCellValue(brf59.getR8_trade1() == null ? 0 : brf59.getR8_trade1().intValue());
			}
			Cell R8cell15 = R8row.getCell(17);
			if (R8cell15 != null) {
				R8cell15.setCellValue(brf59.getR8_individuals1() == null ? 0 : brf59.getR8_individuals1().intValue());
			}
			Cell R8cell16 = R8row.getCell(18);
			if (R8cell16 != null) {
				R8cell16.setCellValue(brf59.getR8_investment1() == null ? 0 : brf59.getR8_investment1().intValue());
			}
			Cell R8cell17 = R8row.getCell(19);
			if (R8cell17 != null) {
				R8cell17.setCellValue(brf59.getR8_zer0() == null ? 0 : brf59.getR8_zer0().intValue());
			}
			Cell R8cell18 = R8row.getCell(20);
			if (R8cell18 != null) {
				R8cell18.setCellValue(brf59.getR8_three() == null ? 0 : brf59.getR8_three().intValue());
			}
			Cell R8cell19 = R8row.getCell(21);
			if (R8cell19 != null) {
				R8cell19.setCellValue(brf59.getR8_six() == null ? 0 : brf59.getR8_six().intValue());
			}
			Cell R8cell20 = R8row.getCell(22);
			if (R8cell20 != null) {
				R8cell20.setCellValue(brf59.getR8_oneyear() == null ? 0 : brf59.getR8_oneyear().intValue());
			}
			Cell R8cell21 = R8row.getCell(23);
			if (R8cell21 != null) {
				R8cell21.setCellValue(brf59.getR8_foreign() == null ? 0 : brf59.getR8_foreign().intValue());
			}
			Cell R8cell22 = R8row.getCell(24);
			if (R8cell22 != null) {
				R8cell22.setCellValue(brf59.getR8_banks() == null ? 0 : brf59.getR8_banks().intValue());
			}
			Cell R8cell23 = R8row.getCell(25);
			if (R8cell23 != null) {
				R8cell23.setCellValue(brf59.getR8_gov2() == null ? 0 : brf59.getR8_gov2().intValue());
			}
			Cell R8cell24 = R8row.getCell(26);
			if (R8cell24 != null) {
				R8cell24.setCellValue(brf59.getR8_other() == null ? 0 : brf59.getR8_other().intValue());
			}
			Cell R8cell25 = R8row.getCell(27);
			if (R8cell25 != null) {
				R8cell25.setCellValue(brf59.getR8_banks1() == null ? 0 : brf59.getR8_banks1().intValue());
			}
			Cell R8cell26 = R8row.getCell(28);
			if (R8cell26 != null) {
				R8cell26.setCellValue(brf59.getR8_individuals2() == null ? 0 : brf59.getR8_individuals2().intValue());
			}
			Cell R8cell27 = R8row.getCell(29);
			if (R8cell27 != null) {
				R8cell27.setCellValue(brf59.getR8_other1() == null ? 0 : brf59.getR8_other1().intValue());
			}
			Cell R8cell28 = R8row.getCell(30);
			if (R8cell28 != null) {
				R8cell28.setCellValue(brf59.getR8_banks2() == null ? 0 : brf59.getR8_banks2().intValue());
			}
			Cell R8cell29 = R8row.getCell(31);
			if (R8cell29 != null) {
				R8cell29.setCellValue(brf59.getR8_gov3() == null ? 0 : brf59.getR8_gov3().intValue());
			}
			Cell R8cell30 = R8row.getCell(32);
			if (R8cell30 != null) {
				R8cell30.setCellValue(brf59.getR8_others2() == null ? 0 : brf59.getR8_others2().intValue());
			}
			Cell R8cell31 = R8row.getCell(33);
			if (R8cell31 != null) {
				R8cell31.setCellValue(brf59.getR8_banks3() == null ? 0 : brf59.getR8_banks3().intValue());
			}
			Cell R8cell32 = R8row.getCell(34);
			if (R8cell32 != null) {
				R8cell32.setCellValue(brf59.getR8_gov4() == null ? 0 : brf59.getR8_gov4().intValue());
			}
			Cell R8cell33 = R8row.getCell(35);
			if (R8cell33 != null) {
				R8cell33.setCellValue(brf59.getR8_others3() == null ? 0 : brf59.getR8_others3().intValue());
			}
			Cell R8cell34 = R8row.getCell(36);
			if (R8cell34 != null) {
				R8cell34.setCellValue(brf59.getR8_foreign1() == null ? 0 : brf59.getR8_foreign1().intValue());
			}
			Cell R8cell35 = R8row.getCell(37);
			if (R8cell35 != null) {
				R8cell35.setCellValue(brf59.getR8_guarantees() == null ? 0 : brf59.getR8_guarantees().intValue());
			}
			Cell R8cell36 = R8row.getCell(38);
			if (R8cell36 != null) {
				R8cell36.setCellValue(brf59.getR8_nbfi2() == null ? 0 : brf59.getR8_nbfi2().intValue());
			}
			Cell R8cell37 = R8row.getCell(39);
			if (R8cell37 != null) {
				R8cell37.setCellValue(brf59.getR8_interbank2() == null ? 0 : brf59.getR8_interbank2().intValue());
			}
			Cell R8cell38 = R8row.getCell(40);
			if (R8cell38 != null) {
				R8cell38.setCellValue(brf59.getR8_gov5() == null ? 0 : brf59.getR8_gov5().intValue());
			}
			Cell R8cell39 = R8row.getCell(41);
			if (R8cell39 != null) {
				R8cell39.setCellValue(brf59.getR8_corporate2() == null ? 0 : brf59.getR8_corporate2().intValue());
			}
			Cell R8cell40 = R8row.getCell(42);
			if (R8cell40 != null) {
				R8cell40.setCellValue(brf59.getR8_gre2() == null ? 0 : brf59.getR8_gre2().intValue());
			}
			Cell R8cell41 = R8row.getCell(43);
			if (R8cell41 != null) {
				R8cell41.setCellValue(brf59.getR8_individuals3() == null ? 0 : brf59.getR8_individuals3().intValue());
			}
			Cell R8cell42 = R8row.getCell(44);
			if (R8cell42 != null) {
				R8cell42.setCellValue(brf59.getR8_zero1() == null ? 0 : brf59.getR8_zero1().intValue());
			}
			Cell R8cell43 = R8row.getCell(45);
			if (R8cell43 != null) {
				R8cell43.setCellValue(brf59.getR8_three1() == null ? 0 : brf59.getR8_three1().intValue());
			}
			Cell R8cell44 = R8row.getCell(46);
			if (R8cell44 != null) {
				R8cell44.setCellValue(brf59.getR8_six1() == null ? 0 : brf59.getR8_six1().intValue());
			}
			Cell R8cell45 = R8row.getCell(47);
			if (R8cell45 != null) {
				R8cell45.setCellValue(brf59.getR8_oneyear1() == null ? 0 : brf59.getR8_oneyear1().intValue());
			}
			Cell R8cell46 = R8row.getCell(48);
			if (R8cell46 != null) {
				R8cell46.setCellValue(brf59.getR8_empty() == null ? "" : brf59.getR8_empty().toString());
			}
			Row R9row = sheet.getRow(26);
			Cell R9cell1 = R9row.getCell(3);
			if (R9cell1 != null) {
				R9cell1.setCellValue(brf59.getR9_nbfi() == null ? 0 : brf59.getR9_nbfi().intValue());
			}

			Cell R9cell2 = R9row.getCell(4);
			if (R9cell2 != null) {
				R9cell2.setCellValue(brf59.getR9_interbank() == null ? 0 : brf59.getR9_interbank().intValue());
			}
			Cell R9cell3 = R9row.getCell(5);
			if (R9cell3 != null) {
				R9cell3.setCellValue(brf59.getR9_gov() == null ? 0 : brf59.getR9_gov().intValue());
			}
			Cell R9cell4 = R9row.getCell(6);
			if (R9cell4 != null) {
				R9cell4.setCellValue(brf59.getR9_corporate() == null ? 0 : brf59.getR9_corporate().intValue());
			}
			Cell R9cell5 = R9row.getCell(7);
			if (R9cell5 != null) {
				R9cell5.setCellValue(brf59.getR9_gre() == null ? 0 : brf59.getR9_gre().intValue());
			}
			Cell R9cell6 = R9row.getCell(8);
			if (R9cell6 != null) {
				R9cell6.setCellValue(brf59.getR9_trade() == null ? 0 : brf59.getR9_trade().intValue());
			}
			Cell R9cell7 = R9row.getCell(9);
			if (R9cell7 != null) {
				R9cell7.setCellValue(brf59.getR9_individuals() == null ? 0 : brf59.getR9_individuals().intValue());
			}
			Cell R9cell8 = R9row.getCell(10);
			if (R9cell8 != null) {
				R9cell8.setCellValue(brf59.getR9_investment() == null ? 0 : brf59.getR9_investment().intValue());
			}
			Cell R9cell9 = R9row.getCell(11);
			if (R9cell9 != null) {
				R9cell9.setCellValue(brf59.getR9_nbfi1() == null ? 0 : brf59.getR9_nbfi1().intValue());
			}
			Cell R9cell10 = R9row.getCell(12);
			if (R9cell10 != null) {
				R9cell10.setCellValue(brf59.getR9_interbank1() == null ? 0 : brf59.getR9_interbank1().intValue());
			}
			Cell R9cell11 = R9row.getCell(13);
			if (R9cell11 != null) {
				R9cell11.setCellValue(brf59.getR9_gov1() == null ? 0 : brf59.getR9_gov1().intValue());
			}
			Cell R9cell12 = R9row.getCell(14);
			if (R9cell12 != null) {
				R9cell12.setCellValue(brf59.getR9_corporate1() == null ? 0 : brf59.getR9_corporate1().intValue());
			}
			Cell R9cell13 = R9row.getCell(15);
			if (R9cell13 != null) {
				R9cell13.setCellValue(brf59.getR9_gre1() == null ? 0 : brf59.getR9_gre1().intValue());
			}
			Cell R9cell14 = R9row.getCell(16);
			if (R9cell14 != null) {
				R9cell14.setCellValue(brf59.getR9_trade1() == null ? 0 : brf59.getR9_trade1().intValue());
			}
			Cell R9cell15 = R9row.getCell(17);
			if (R9cell15 != null) {
				R9cell15.setCellValue(brf59.getR9_individuals1() == null ? 0 : brf59.getR9_individuals1().intValue());
			}
			Cell R9cell16 = R9row.getCell(18);
			if (R9cell16 != null) {
				R9cell16.setCellValue(brf59.getR9_investment1() == null ? 0 : brf59.getR9_investment1().intValue());
			}
			Cell R9cell17 = R9row.getCell(19);
			if (R9cell17 != null) {
				R9cell17.setCellValue(brf59.getR9_zer0() == null ? 0 : brf59.getR9_zer0().intValue());
			}
			Cell R9cell18 = R9row.getCell(20);
			if (R9cell18 != null) {
				R9cell18.setCellValue(brf59.getR9_three() == null ? 0 : brf59.getR9_three().intValue());
			}
			Cell R9cell19 = R9row.getCell(21);
			if (R9cell19 != null) {
				R9cell19.setCellValue(brf59.getR9_six() == null ? 0 : brf59.getR9_six().intValue());
			}
			Cell R9cell20 = R9row.getCell(22);
			if (R9cell20 != null) {
				R9cell20.setCellValue(brf59.getR9_oneyear() == null ? 0 : brf59.getR9_oneyear().intValue());
			}
			Cell R9cell21 = R9row.getCell(23);
			if (R9cell21 != null) {
				R9cell21.setCellValue(brf59.getR9_foreign() == null ? 0 : brf59.getR9_foreign().intValue());
			}
			Cell R9cell22 = R9row.getCell(24);
			if (R9cell22 != null) {
				R9cell22.setCellValue(brf59.getR9_banks() == null ? 0 : brf59.getR9_banks().intValue());
			}
			Cell R9cell23 = R9row.getCell(25);
			if (R9cell23 != null) {
				R9cell23.setCellValue(brf59.getR9_gov2() == null ? 0 : brf59.getR9_gov2().intValue());
			}
			Cell R9cell24 = R9row.getCell(26);
			if (R9cell24 != null) {
				R9cell24.setCellValue(brf59.getR9_other() == null ? 0 : brf59.getR9_other().intValue());
			}
			Cell R9cell25 = R9row.getCell(27);
			if (R9cell25 != null) {
				R9cell25.setCellValue(brf59.getR9_banks1() == null ? 0 : brf59.getR9_banks1().intValue());
			}
			Cell R9cell26 = R9row.getCell(28);
			if (R9cell26 != null) {
				R9cell26.setCellValue(brf59.getR9_individuals2() == null ? 0 : brf59.getR9_individuals2().intValue());
			}
			Cell R9cell27 = R9row.getCell(29);
			if (R9cell27 != null) {
				R9cell27.setCellValue(brf59.getR9_other1() == null ? 0 : brf59.getR9_other1().intValue());
			}
			Cell R9cell28 = R9row.getCell(30);
			if (R9cell28 != null) {
				R9cell28.setCellValue(brf59.getR9_banks2() == null ? 0 : brf59.getR9_banks2().intValue());
			}
			Cell R9cell29 = R9row.getCell(31);
			if (R9cell29 != null) {
				R9cell29.setCellValue(brf59.getR9_gov3() == null ? 0 : brf59.getR9_gov3().intValue());
			}
			Cell R9cell30 = R9row.getCell(32);
			if (R9cell30 != null) {
				R9cell30.setCellValue(brf59.getR9_others2() == null ? 0 : brf59.getR9_others2().intValue());
			}
			Cell R9cell31 = R9row.getCell(33);
			if (R9cell31 != null) {
				R9cell31.setCellValue(brf59.getR9_banks3() == null ? 0 : brf59.getR9_banks3().intValue());
			}
			Cell R9cell32 = R9row.getCell(34);
			if (R9cell32 != null) {
				R9cell32.setCellValue(brf59.getR9_gov4() == null ? 0 : brf59.getR9_gov4().intValue());
			}
			Cell R9cell33 = R9row.getCell(35);
			if (R9cell33 != null) {
				R9cell33.setCellValue(brf59.getR9_others3() == null ? 0 : brf59.getR9_others3().intValue());
			}
			Cell R9cell34 = R9row.getCell(36);
			if (R9cell34 != null) {
				R9cell34.setCellValue(brf59.getR9_foreign1() == null ? 0 : brf59.getR9_foreign1().intValue());
			}
			Cell R9cell35 = R9row.getCell(37);
			if (R9cell35 != null) {
				R9cell35.setCellValue(brf59.getR9_guarantees() == null ? 0 : brf59.getR9_guarantees().intValue());
			}
			Cell R9cell36 = R9row.getCell(38);
			if (R9cell36 != null) {
				R9cell36.setCellValue(brf59.getR9_nbfi2() == null ? 0 : brf59.getR9_nbfi2().intValue());
			}
			Cell R9cell37 = R9row.getCell(39);
			if (R9cell37 != null) {
				R9cell37.setCellValue(brf59.getR9_interbank2() == null ? 0 : brf59.getR9_interbank2().intValue());
			}
			Cell R9cell38 = R9row.getCell(40);
			if (R9cell38 != null) {
				R9cell38.setCellValue(brf59.getR9_gov5() == null ? 0 : brf59.getR9_gov5().intValue());
			}
			Cell R9cell39 = R9row.getCell(41);
			if (R9cell39 != null) {
				R9cell39.setCellValue(brf59.getR9_corporate2() == null ? 0 : brf59.getR9_corporate2().intValue());
			}
			Cell R9cell40 = R9row.getCell(42);
			if (R9cell40 != null) {
				R9cell40.setCellValue(brf59.getR9_gre2() == null ? 0 : brf59.getR9_gre2().intValue());
			}
			Cell R9cell41 = R9row.getCell(43);
			if (R9cell41 != null) {
				R9cell41.setCellValue(brf59.getR9_individuals3() == null ? 0 : brf59.getR9_individuals3().intValue());
			}
			Cell R9cell42 = R9row.getCell(44);
			if (R9cell42 != null) {
				R9cell42.setCellValue(brf59.getR9_zero1() == null ? 0 : brf59.getR9_zero1().intValue());
			}
			Cell R9cell43 = R9row.getCell(45);
			if (R9cell43 != null) {
				R9cell43.setCellValue(brf59.getR9_three1() == null ? 0 : brf59.getR9_three1().intValue());
			}
			Cell R9cell44 = R9row.getCell(46);
			if (R9cell44 != null) {
				R9cell44.setCellValue(brf59.getR9_six1() == null ? 0 : brf59.getR9_six1().intValue());
			}
			Cell R9cell45 = R9row.getCell(47);
			if (R9cell45 != null) {
				R9cell45.setCellValue(brf59.getR9_oneyear1() == null ? 0 : brf59.getR9_oneyear1().intValue());
			}
			Cell R9cell46 = R9row.getCell(48);
			if (R9cell46 != null) {
				R9cell46.setCellValue(brf59.getR9_empty() == null ? "" : brf59.getR9_empty().toString());
			}
			Row R10row = sheet.getRow(27);
			Cell R10cell1 = R10row.getCell(3);
			if (R10cell1 != null) {
				R10cell1.setCellValue(brf59.getR10_nbfi() == null ? 0 : brf59.getR10_nbfi().intValue());
			}

			Cell R10cell2 = R10row.getCell(4);
			if (R10cell2 != null) {
				R10cell2.setCellValue(brf59.getR10_interbank() == null ? 0 : brf59.getR10_interbank().intValue());
			}
			Cell R10cell3 = R10row.getCell(5);
			if (R10cell3 != null) {
				R10cell3.setCellValue(brf59.getR10_gov() == null ? 0 : brf59.getR10_gov().intValue());
			}
			Cell R10cell4 = R10row.getCell(6);
			if (R10cell4 != null) {
				R10cell4.setCellValue(brf59.getR10_corporate() == null ? 0 : brf59.getR10_corporate().intValue());
			}
			Cell R10cell5 = R10row.getCell(7);
			if (R10cell5 != null) {
				R10cell5.setCellValue(brf59.getR10_gre() == null ? 0 : brf59.getR10_gre().intValue());
			}
			Cell R10cell6 = R10row.getCell(8);
			if (R10cell6 != null) {
				R10cell6.setCellValue(brf59.getR10_trade() == null ? 0 : brf59.getR10_trade().intValue());
			}
			Cell R10cell7 = R10row.getCell(9);
			if (R10cell7 != null) {
				R10cell7.setCellValue(brf59.getR10_individuals() == null ? 0 : brf59.getR10_individuals().intValue());
			}
			Cell R10cell8 = R10row.getCell(10);
			if (R10cell8 != null) {
				R10cell8.setCellValue(brf59.getR10_investment() == null ? 0 : brf59.getR10_investment().intValue());
			}
			Cell R10cell9 = R10row.getCell(11);
			if (R10cell9 != null) {
				R10cell9.setCellValue(brf59.getR10_nbfi1() == null ? 0 : brf59.getR10_nbfi1().intValue());
			}
			Cell R10cell10 = R10row.getCell(12);
			if (R10cell10 != null) {
				R10cell10.setCellValue(brf59.getR10_interbank1() == null ? 0 : brf59.getR10_interbank1().intValue());
			}
			Cell R10cell11 = R10row.getCell(13);
			if (R10cell11 != null) {
				R10cell11.setCellValue(brf59.getR10_gov1() == null ? 0 : brf59.getR10_gov1().intValue());
			}
			Cell R10cell12 = R10row.getCell(14);
			if (R10cell12 != null) {
				R10cell12.setCellValue(brf59.getR10_corporate1() == null ? 0 : brf59.getR10_corporate1().intValue());
			}
			Cell R10cell13 = R10row.getCell(15);
			if (R10cell13 != null) {
				R10cell13.setCellValue(brf59.getR10_gre1() == null ? 0 : brf59.getR10_gre1().intValue());
			}
			Cell R10cell14 = R10row.getCell(16);
			if (R10cell14 != null) {
				R10cell14.setCellValue(brf59.getR10_trade1() == null ? 0 : brf59.getR10_trade1().intValue());
			}
			Cell R10cell15 = R10row.getCell(17);
			if (R10cell15 != null) {
				R10cell15
						.setCellValue(brf59.getR10_individuals1() == null ? 0 : brf59.getR10_individuals1().intValue());
			}
			Cell R10cell16 = R10row.getCell(18);
			if (R10cell16 != null) {
				R10cell16.setCellValue(brf59.getR10_investment1() == null ? 0 : brf59.getR10_investment1().intValue());
			}
			Cell R10cell17 = R10row.getCell(19);
			if (R10cell17 != null) {
				R10cell17.setCellValue(brf59.getR10_zer0() == null ? 0 : brf59.getR10_zer0().intValue());
			}
			Cell R10cell18 = R10row.getCell(20);
			if (R10cell18 != null) {
				R10cell18.setCellValue(brf59.getR10_three() == null ? 0 : brf59.getR10_three().intValue());
			}
			Cell R10cell19 = R10row.getCell(21);
			if (R10cell19 != null) {
				R10cell19.setCellValue(brf59.getR10_six() == null ? 0 : brf59.getR10_six().intValue());
			}
			Cell R10cell20 = R10row.getCell(22);
			if (R10cell20 != null) {
				R10cell20.setCellValue(brf59.getR10_oneyear() == null ? 0 : brf59.getR10_oneyear().intValue());
			}
			Cell R10cell21 = R10row.getCell(23);
			if (R10cell21 != null) {
				R10cell21.setCellValue(brf59.getR10_foreign() == null ? 0 : brf59.getR10_foreign().intValue());
			}
			Cell R10cell22 = R10row.getCell(24);
			if (R10cell22 != null) {
				R10cell22.setCellValue(brf59.getR10_banks() == null ? 0 : brf59.getR10_banks().intValue());
			}
			Cell R10cell23 = R10row.getCell(25);
			if (R10cell23 != null) {
				R10cell23.setCellValue(brf59.getR10_gov2() == null ? 0 : brf59.getR10_gov2().intValue());
			}
			Cell R10cell24 = R10row.getCell(26);
			if (R10cell24 != null) {
				R10cell24.setCellValue(brf59.getR10_other() == null ? 0 : brf59.getR10_other().intValue());
			}
			Cell R10cell25 = R10row.getCell(27);
			if (R10cell25 != null) {
				R10cell25.setCellValue(brf59.getR10_banks1() == null ? 0 : brf59.getR10_banks1().intValue());
			}
			Cell R10cell26 = R10row.getCell(28);
			if (R10cell26 != null) {
				R10cell26
						.setCellValue(brf59.getR10_individuals2() == null ? 0 : brf59.getR10_individuals2().intValue());
			}
			Cell R10cell27 = R10row.getCell(29);
			if (R10cell27 != null) {
				R10cell27.setCellValue(brf59.getR10_other1() == null ? 0 : brf59.getR10_other1().intValue());
			}
			Cell R10cell28 = R10row.getCell(30);
			if (R10cell28 != null) {
				R10cell28.setCellValue(brf59.getR10_banks2() == null ? 0 : brf59.getR10_banks2().intValue());
			}
			Cell R10cell29 = R10row.getCell(31);
			if (R10cell29 != null) {
				R10cell29.setCellValue(brf59.getR10_gov3() == null ? 0 : brf59.getR10_gov3().intValue());
			}
			Cell R10cell30 = R10row.getCell(32);
			if (R10cell30 != null) {
				R10cell30.setCellValue(brf59.getR10_others2() == null ? 0 : brf59.getR10_others2().intValue());
			}
			Cell R10cell31 = R10row.getCell(33);
			if (R10cell31 != null) {
				R10cell31.setCellValue(brf59.getR10_banks3() == null ? 0 : brf59.getR10_banks3().intValue());
			}
			Cell R10cell32 = R10row.getCell(34);
			if (R10cell32 != null) {
				R10cell32.setCellValue(brf59.getR10_gov4() == null ? 0 : brf59.getR10_gov4().intValue());
			}
			Cell R10cell33 = R10row.getCell(35);
			if (R10cell33 != null) {
				R10cell33.setCellValue(brf59.getR10_others3() == null ? 0 : brf59.getR10_others3().intValue());
			}
			Cell R10cell34 = R10row.getCell(36);
			if (R10cell34 != null) {
				R10cell34.setCellValue(brf59.getR10_foreign1() == null ? 0 : brf59.getR10_foreign1().intValue());
			}
			Cell R10cell35 = R10row.getCell(37);
			if (R10cell35 != null) {
				R10cell35.setCellValue(brf59.getR10_guarantees() == null ? 0 : brf59.getR10_guarantees().intValue());
			}
			Cell R10cell36 = R10row.getCell(38);
			if (R10cell36 != null) {
				R10cell36.setCellValue(brf59.getR10_nbfi2() == null ? 0 : brf59.getR10_nbfi2().intValue());
			}
			Cell R10cell37 = R10row.getCell(39);
			if (R10cell37 != null) {
				R10cell37.setCellValue(brf59.getR10_interbank2() == null ? 0 : brf59.getR10_interbank2().intValue());
			}
			Cell R10cell38 = R10row.getCell(40);
			if (R10cell38 != null) {
				R10cell38.setCellValue(brf59.getR10_gov5() == null ? 0 : brf59.getR10_gov5().intValue());
			}
			Cell R10cell39 = R10row.getCell(41);
			if (R10cell39 != null) {
				R10cell39.setCellValue(brf59.getR10_corporate2() == null ? 0 : brf59.getR10_corporate2().intValue());
			}
			Cell R10cell40 = R10row.getCell(42);
			if (R10cell40 != null) {
				R10cell40.setCellValue(brf59.getR10_gre2() == null ? 0 : brf59.getR10_gre2().intValue());
			}
			Cell R10cell41 = R10row.getCell(43);
			if (R10cell41 != null) {
				R10cell41
						.setCellValue(brf59.getR10_individuals3() == null ? 0 : brf59.getR10_individuals3().intValue());
			}
			Cell R10cell42 = R10row.getCell(44);
			if (R10cell42 != null) {
				R10cell42.setCellValue(brf59.getR10_zero1() == null ? 0 : brf59.getR10_zero1().intValue());
			}
			Cell R10cell43 = R10row.getCell(45);
			if (R10cell43 != null) {
				R10cell43.setCellValue(brf59.getR10_three1() == null ? 0 : brf59.getR10_three1().intValue());
			}
			Cell R10cell44 = R10row.getCell(46);
			if (R10cell44 != null) {
				R10cell44.setCellValue(brf59.getR10_six1() == null ? 0 : brf59.getR10_six1().intValue());
			}
			Cell R10cell45 = R10row.getCell(47);
			if (R10cell45 != null) {
				R10cell45.setCellValue(brf59.getR10_oneyear1() == null ? 0 : brf59.getR10_oneyear1().intValue());
			}
			Cell R10cell46 = R10row.getCell(48);
			if (R10cell46 != null) {
				R10cell46.setCellValue(brf59.getR10_empty() == null ? "" : brf59.getR10_empty().toString());
			}
			Row R11row = sheet.getRow(28);
			Cell R11cell1 = R11row.getCell(3);
			if (R11cell1 != null) {
				R11cell1.setCellValue(brf59.getR11_nbfi() == null ? 0 : brf59.getR11_nbfi().intValue());
			}

			Cell R11cell2 = R11row.getCell(4);
			if (R11cell2 != null) {
				R11cell2.setCellValue(brf59.getR11_interbank() == null ? 0 : brf59.getR11_interbank().intValue());
			}
			Cell R11cell3 = R11row.getCell(5);
			if (R11cell3 != null) {
				R11cell3.setCellValue(brf59.getR11_gov() == null ? 0 : brf59.getR11_gov().intValue());
			}
			Cell R11cell4 = R11row.getCell(6);
			if (R11cell4 != null) {
				R11cell4.setCellValue(brf59.getR11_corporate() == null ? 0 : brf59.getR11_corporate().intValue());
			}
			Cell R11cell5 = R11row.getCell(7);
			if (R11cell5 != null) {
				R11cell5.setCellValue(brf59.getR11_gre() == null ? 0 : brf59.getR11_gre().intValue());
			}
			Cell R11cell6 = R11row.getCell(8);
			if (R11cell6 != null) {
				R11cell6.setCellValue(brf59.getR11_trade() == null ? 0 : brf59.getR11_trade().intValue());
			}
			Cell R11cell7 = R11row.getCell(9);
			if (R11cell7 != null) {
				R11cell7.setCellValue(brf59.getR11_individuals() == null ? 0 : brf59.getR11_individuals().intValue());
			}
			Cell R11cell8 = R11row.getCell(10);
			if (R11cell8 != null) {
				R11cell8.setCellValue(brf59.getR11_investment() == null ? 0 : brf59.getR11_investment().intValue());
			}
			Cell R11cell9 = R11row.getCell(11);
			if (R11cell9 != null) {
				R11cell9.setCellValue(brf59.getR11_nbfi1() == null ? 0 : brf59.getR11_nbfi1().intValue());
			}
			Cell R11cell10 = R11row.getCell(12);
			if (R11cell10 != null) {
				R11cell10.setCellValue(brf59.getR11_interbank1() == null ? 0 : brf59.getR11_interbank1().intValue());
			}
			Cell R11cell11 = R11row.getCell(13);
			if (R11cell11 != null) {
				R11cell11.setCellValue(brf59.getR11_gov1() == null ? 0 : brf59.getR11_gov1().intValue());
			}
			Cell R11cell12 = R11row.getCell(14);
			if (R11cell12 != null) {
				R11cell12.setCellValue(brf59.getR11_corporate1() == null ? 0 : brf59.getR11_corporate1().intValue());
			}
			Cell R11cell13 = R11row.getCell(15);
			if (R11cell13 != null) {
				R11cell13.setCellValue(brf59.getR11_gre1() == null ? 0 : brf59.getR11_gre1().intValue());
			}
			Cell R11cell14 = R11row.getCell(16);
			if (R11cell14 != null) {
				R11cell14.setCellValue(brf59.getR11_trade1() == null ? 0 : brf59.getR11_trade1().intValue());
			}
			Cell R11cell15 = R11row.getCell(17);
			if (R11cell15 != null) {
				R11cell15
						.setCellValue(brf59.getR11_individuals1() == null ? 0 : brf59.getR11_individuals1().intValue());
			}
			Cell R11cell16 = R11row.getCell(18);
			if (R11cell16 != null) {
				R11cell16.setCellValue(brf59.getR11_investment1() == null ? 0 : brf59.getR11_investment1().intValue());
			}
			Cell R11cell17 = R11row.getCell(19);
			if (R11cell17 != null) {
				R11cell17.setCellValue(brf59.getR11_zer0() == null ? 0 : brf59.getR11_zer0().intValue());
			}
			Cell R11cell18 = R11row.getCell(20);
			if (R11cell18 != null) {
				R11cell18.setCellValue(brf59.getR11_three() == null ? 0 : brf59.getR11_three().intValue());
			}
			Cell R11cell19 = R11row.getCell(21);
			if (R11cell19 != null) {
				R11cell19.setCellValue(brf59.getR11_six() == null ? 0 : brf59.getR11_six().intValue());
			}
			Cell R11cell20 = R11row.getCell(22);
			if (R11cell20 != null) {
				R11cell20.setCellValue(brf59.getR11_oneyear() == null ? 0 : brf59.getR11_oneyear().intValue());
			}
			Cell R11cell21 = R11row.getCell(23);
			if (R11cell21 != null) {
				R11cell21.setCellValue(brf59.getR11_foreign() == null ? 0 : brf59.getR11_foreign().intValue());
			}
			Cell R11cell22 = R11row.getCell(24);
			if (R11cell22 != null) {
				R11cell22.setCellValue(brf59.getR11_banks() == null ? 0 : brf59.getR11_banks().intValue());
			}
			Cell R11cell23 = R11row.getCell(25);
			if (R11cell23 != null) {
				R11cell23.setCellValue(brf59.getR11_gov2() == null ? 0 : brf59.getR11_gov2().intValue());
			}
			Cell R11cell24 = R11row.getCell(26);
			if (R11cell24 != null) {
				R11cell24.setCellValue(brf59.getR11_other() == null ? 0 : brf59.getR11_other().intValue());
			}
			Cell R11cell25 = R11row.getCell(27);
			if (R11cell25 != null) {
				R11cell25.setCellValue(brf59.getR11_banks1() == null ? 0 : brf59.getR11_banks1().intValue());
			}
			Cell R11cell26 = R11row.getCell(28);
			if (R11cell26 != null) {
				R11cell26
						.setCellValue(brf59.getR11_individuals2() == null ? 0 : brf59.getR11_individuals2().intValue());
			}
			Cell R11cell27 = R11row.getCell(29);
			if (R11cell27 != null) {
				R11cell27.setCellValue(brf59.getR11_other1() == null ? 0 : brf59.getR11_other1().intValue());
			}
			Cell R11cell28 = R11row.getCell(30);
			if (R11cell28 != null) {
				R11cell28.setCellValue(brf59.getR11_banks2() == null ? 0 : brf59.getR11_banks2().intValue());
			}
			Cell R11cell29 = R11row.getCell(31);
			if (R11cell29 != null) {
				R11cell29.setCellValue(brf59.getR11_gov3() == null ? 0 : brf59.getR11_gov3().intValue());
			}
			Cell R11cell30 = R11row.getCell(32);
			if (R11cell30 != null) {
				R11cell30.setCellValue(brf59.getR11_others2() == null ? 0 : brf59.getR11_others2().intValue());
			}
			Cell R11cell31 = R11row.getCell(33);
			if (R11cell31 != null) {
				R11cell31.setCellValue(brf59.getR11_banks3() == null ? 0 : brf59.getR11_banks3().intValue());
			}
			Cell R11cell32 = R11row.getCell(34);
			if (R11cell32 != null) {
				R11cell32.setCellValue(brf59.getR11_gov4() == null ? 0 : brf59.getR11_gov4().intValue());
			}
			Cell R11cell33 = R11row.getCell(35);
			if (R11cell33 != null) {
				R11cell33.setCellValue(brf59.getR11_others3() == null ? 0 : brf59.getR11_others3().intValue());
			}
			Cell R11cell34 = R11row.getCell(36);
			if (R11cell34 != null) {
				R11cell34.setCellValue(brf59.getR11_foreign1() == null ? 0 : brf59.getR11_foreign1().intValue());
			}
			Cell R11cell35 = R11row.getCell(37);
			if (R11cell35 != null) {
				R11cell35.setCellValue(brf59.getR11_guarantees() == null ? 0 : brf59.getR11_guarantees().intValue());
			}
			Cell R11cell36 = R11row.getCell(38);
			if (R11cell36 != null) {
				R11cell36.setCellValue(brf59.getR11_nbfi2() == null ? 0 : brf59.getR11_nbfi2().intValue());
			}
			Cell R11cell37 = R11row.getCell(39);
			if (R11cell37 != null) {
				R11cell37.setCellValue(brf59.getR11_interbank2() == null ? 0 : brf59.getR11_interbank2().intValue());
			}
			Cell R11cell38 = R11row.getCell(40);
			if (R11cell38 != null) {
				R11cell38.setCellValue(brf59.getR11_gov5() == null ? 0 : brf59.getR11_gov5().intValue());
			}
			Cell R11cell39 = R11row.getCell(41);
			if (R11cell39 != null) {
				R11cell39.setCellValue(brf59.getR11_corporate2() == null ? 0 : brf59.getR11_corporate2().intValue());
			}
			Cell R11cell40 = R11row.getCell(42);
			if (R11cell40 != null) {
				R11cell40.setCellValue(brf59.getR11_gre2() == null ? 0 : brf59.getR11_gre2().intValue());
			}
			Cell R11cell41 = R11row.getCell(43);
			if (R11cell41 != null) {
				R11cell41
						.setCellValue(brf59.getR11_individuals3() == null ? 0 : brf59.getR11_individuals3().intValue());
			}
			Cell R11cell42 = R11row.getCell(44);
			if (R11cell42 != null) {
				R11cell42.setCellValue(brf59.getR11_zero1() == null ? 0 : brf59.getR11_zero1().intValue());
			}
			Cell R11cell43 = R11row.getCell(45);
			if (R11cell43 != null) {
				R11cell43.setCellValue(brf59.getR11_three1() == null ? 0 : brf59.getR11_three1().intValue());
			}
			Cell R11cell44 = R11row.getCell(46);
			if (R11cell44 != null) {
				R11cell44.setCellValue(brf59.getR11_six1() == null ? 0 : brf59.getR11_six1().intValue());
			}
			Cell R11cell45 = R11row.getCell(47);
			if (R11cell45 != null) {
				R11cell45.setCellValue(brf59.getR11_oneyear1() == null ? 0 : brf59.getR11_oneyear1().intValue());
			}
			Cell R11cell46 = R11row.getCell(48);
			if (R11cell46 != null) {
				R11cell46.setCellValue(brf59.getR11_empty() == null ? "" : brf59.getR11_empty().toString());
			}
			Row R12row = sheet.getRow(29);
			Cell R12cell1 = R12row.getCell(3);
			if (R12cell1 != null) {
				R12cell1.setCellValue(brf59.getR12_nbfi() == null ? 0 : brf59.getR12_nbfi().intValue());
			}

			Cell R12cell2 = R12row.getCell(4);
			if (R12cell2 != null) {
				R12cell2.setCellValue(brf59.getR12_interbank() == null ? 0 : brf59.getR12_interbank().intValue());
			}
			Cell R12cell3 = R12row.getCell(5);
			if (R12cell3 != null) {
				R12cell3.setCellValue(brf59.getR12_gov() == null ? 0 : brf59.getR12_gov().intValue());
			}
			Cell R12cell4 = R12row.getCell(6);
			if (R12cell4 != null) {
				R12cell4.setCellValue(brf59.getR12_corporate() == null ? 0 : brf59.getR12_corporate().intValue());
			}
			Cell R12cell5 = R12row.getCell(7);
			if (R12cell5 != null) {
				R12cell5.setCellValue(brf59.getR12_gre() == null ? 0 : brf59.getR12_gre().intValue());
			}
			Cell R12cell6 = R12row.getCell(8);
			if (R12cell6 != null) {
				R12cell6.setCellValue(brf59.getR12_trade() == null ? 0 : brf59.getR12_trade().intValue());
			}
			Cell R12cell7 = R12row.getCell(9);
			if (R12cell7 != null) {
				R12cell7.setCellValue(brf59.getR12_individuals() == null ? 0 : brf59.getR12_individuals().intValue());
			}
			Cell R12cell8 = R12row.getCell(10);
			if (R12cell8 != null) {
				R12cell8.setCellValue(brf59.getR12_investment() == null ? 0 : brf59.getR12_investment().intValue());
			}
			Cell R12cell9 = R12row.getCell(11);
			if (R12cell9 != null) {
				R12cell9.setCellValue(brf59.getR12_nbfi1() == null ? 0 : brf59.getR12_nbfi1().intValue());
			}
			Cell R12cell10 = R12row.getCell(12);
			if (R12cell10 != null) {
				R12cell10.setCellValue(brf59.getR12_interbank1() == null ? 0 : brf59.getR12_interbank1().intValue());
			}
			Cell R12cell11 = R12row.getCell(13);
			if (R12cell11 != null) {
				R12cell11.setCellValue(brf59.getR12_gov1() == null ? 0 : brf59.getR12_gov1().intValue());
			}
			Cell R12cell12 = R12row.getCell(14);
			if (R12cell12 != null) {
				R12cell12.setCellValue(brf59.getR12_corporate1() == null ? 0 : brf59.getR12_corporate1().intValue());
			}
			Cell R12cell13 = R12row.getCell(15);
			if (R12cell13 != null) {
				R12cell13.setCellValue(brf59.getR12_gre1() == null ? 0 : brf59.getR12_gre1().intValue());
			}
			Cell R12cell14 = R12row.getCell(16);
			if (R12cell14 != null) {
				R12cell14.setCellValue(brf59.getR12_trade1() == null ? 0 : brf59.getR12_trade1().intValue());
			}
			Cell R12cell15 = R12row.getCell(17);
			if (R12cell15 != null) {
				R12cell15
						.setCellValue(brf59.getR12_individuals1() == null ? 0 : brf59.getR12_individuals1().intValue());
			}
			Cell R12cell16 = R12row.getCell(18);
			if (R12cell16 != null) {
				R12cell16.setCellValue(brf59.getR12_investment1() == null ? 0 : brf59.getR12_investment1().intValue());
			}
			Cell R12cell17 = R12row.getCell(19);
			if (R12cell17 != null) {
				R12cell17.setCellValue(brf59.getR12_zer0() == null ? 0 : brf59.getR12_zer0().intValue());
			}
			Cell R12cell18 = R12row.getCell(20);
			if (R12cell18 != null) {
				R12cell18.setCellValue(brf59.getR12_three() == null ? 0 : brf59.getR12_three().intValue());
			}
			Cell R12cell19 = R12row.getCell(21);
			if (R12cell19 != null) {
				R12cell19.setCellValue(brf59.getR12_six() == null ? 0 : brf59.getR12_six().intValue());
			}
			Cell R12cell20 = R12row.getCell(22);
			if (R12cell20 != null) {
				R12cell20.setCellValue(brf59.getR12_oneyear() == null ? 0 : brf59.getR12_oneyear().intValue());
			}
			Cell R12cell21 = R12row.getCell(23);
			if (R12cell21 != null) {
				R12cell21.setCellValue(brf59.getR12_foreign() == null ? 0 : brf59.getR12_foreign().intValue());
			}
			Cell R12cell22 = R12row.getCell(24);
			if (R12cell22 != null) {
				R12cell22.setCellValue(brf59.getR12_banks() == null ? 0 : brf59.getR12_banks().intValue());
			}
			Cell R12cell23 = R12row.getCell(25);
			if (R12cell23 != null) {
				R12cell23.setCellValue(brf59.getR12_gov2() == null ? 0 : brf59.getR12_gov2().intValue());
			}
			Cell R12cell24 = R12row.getCell(26);
			if (R12cell24 != null) {
				R12cell24.setCellValue(brf59.getR12_other() == null ? 0 : brf59.getR12_other().intValue());
			}
			Cell R12cell25 = R12row.getCell(27);
			if (R12cell25 != null) {
				R12cell25.setCellValue(brf59.getR12_banks1() == null ? 0 : brf59.getR12_banks1().intValue());
			}
			Cell R12cell26 = R12row.getCell(28);
			if (R12cell26 != null) {
				R12cell26
						.setCellValue(brf59.getR12_individuals2() == null ? 0 : brf59.getR12_individuals2().intValue());
			}
			Cell R12cell27 = R12row.getCell(29);
			if (R12cell27 != null) {
				R12cell27.setCellValue(brf59.getR12_other1() == null ? 0 : brf59.getR12_other1().intValue());
			}
			Cell R12cell28 = R12row.getCell(30);
			if (R12cell28 != null) {
				R12cell28.setCellValue(brf59.getR12_banks2() == null ? 0 : brf59.getR12_banks2().intValue());
			}
			Cell R12cell29 = R12row.getCell(31);
			if (R12cell29 != null) {
				R12cell29.setCellValue(brf59.getR12_gov3() == null ? 0 : brf59.getR12_gov3().intValue());
			}
			Cell R12cell30 = R12row.getCell(32);
			if (R12cell30 != null) {
				R12cell30.setCellValue(brf59.getR12_others2() == null ? 0 : brf59.getR12_others2().intValue());
			}
			Cell R12cell31 = R12row.getCell(33);
			if (R12cell31 != null) {
				R12cell31.setCellValue(brf59.getR12_banks3() == null ? 0 : brf59.getR12_banks3().intValue());
			}
			Cell R12cell32 = R12row.getCell(34);
			if (R12cell32 != null) {
				R12cell32.setCellValue(brf59.getR12_gov4() == null ? 0 : brf59.getR12_gov4().intValue());
			}
			Cell R12cell33 = R12row.getCell(35);
			if (R12cell33 != null) {
				R12cell33.setCellValue(brf59.getR12_others3() == null ? 0 : brf59.getR12_others3().intValue());
			}
			Cell R12cell34 = R12row.getCell(36);
			if (R12cell34 != null) {
				R12cell34.setCellValue(brf59.getR12_foreign1() == null ? 0 : brf59.getR12_foreign1().intValue());
			}
			Cell R12cell35 = R12row.getCell(37);
			if (R12cell35 != null) {
				R12cell35.setCellValue(brf59.getR12_guarantees() == null ? 0 : brf59.getR12_guarantees().intValue());
			}
			Cell R12cell36 = R12row.getCell(38);
			if (R12cell36 != null) {
				R12cell36.setCellValue(brf59.getR12_nbfi2() == null ? 0 : brf59.getR12_nbfi2().intValue());
			}
			Cell R12cell37 = R12row.getCell(39);
			if (R12cell37 != null) {
				R12cell37.setCellValue(brf59.getR12_interbank2() == null ? 0 : brf59.getR12_interbank2().intValue());
			}
			Cell R12cell38 = R12row.getCell(40);
			if (R12cell38 != null) {
				R12cell38.setCellValue(brf59.getR12_gov5() == null ? 0 : brf59.getR12_gov5().intValue());
			}
			Cell R12cell39 = R12row.getCell(41);
			if (R12cell39 != null) {
				R12cell39.setCellValue(brf59.getR12_corporate2() == null ? 0 : brf59.getR12_corporate2().intValue());
			}
			Cell R12cell40 = R12row.getCell(42);
			if (R12cell40 != null) {
				R12cell40.setCellValue(brf59.getR12_gre2() == null ? 0 : brf59.getR12_gre2().intValue());
			}
			Cell R12cell41 = R12row.getCell(43);
			if (R12cell41 != null) {
				R12cell41
						.setCellValue(brf59.getR12_individuals3() == null ? 0 : brf59.getR12_individuals3().intValue());
			}
			Cell R12cell42 = R12row.getCell(44);
			if (R12cell42 != null) {
				R12cell42.setCellValue(brf59.getR12_zero1() == null ? 0 : brf59.getR12_zero1().intValue());
			}
			Cell R12cell43 = R12row.getCell(45);
			if (R12cell43 != null) {
				R12cell43.setCellValue(brf59.getR12_three1() == null ? 0 : brf59.getR12_three1().intValue());
			}
			Cell R12cell44 = R12row.getCell(46);
			if (R12cell44 != null) {
				R12cell44.setCellValue(brf59.getR12_six1() == null ? 0 : brf59.getR12_six1().intValue());
			}
			Cell R12cell45 = R12row.getCell(47);
			if (R12cell45 != null) {
				R12cell45.setCellValue(brf59.getR12_oneyear1() == null ? 0 : brf59.getR12_oneyear1().intValue());
			}
			Cell R12cell46 = R12row.getCell(48);
			if (R12cell46 != null) {
				R12cell46.setCellValue(brf59.getR12_empty() == null ? "" : brf59.getR12_empty().toString());
			}
			Row R13row = sheet.getRow(30);
			Cell R13cell1 = R13row.getCell(3);
			if (R13cell1 != null) {
				R13cell1.setCellValue(brf59.getR13_nbfi() == null ? 0 : brf59.getR13_nbfi().intValue());
			}

			Cell R13cell2 = R13row.getCell(4);
			if (R13cell2 != null) {
				R13cell2.setCellValue(brf59.getR13_interbank() == null ? 0 : brf59.getR13_interbank().intValue());
			}
			Cell R13cell3 = R13row.getCell(5);
			if (R13cell3 != null) {
				R13cell3.setCellValue(brf59.getR13_gov() == null ? 0 : brf59.getR13_gov().intValue());
			}
			Cell R13cell4 = R13row.getCell(6);
			if (R13cell4 != null) {
				R13cell4.setCellValue(brf59.getR13_corporate() == null ? 0 : brf59.getR13_corporate().intValue());
			}
			Cell R13cell5 = R13row.getCell(7);
			if (R13cell5 != null) {
				R13cell5.setCellValue(brf59.getR13_gre() == null ? 0 : brf59.getR13_gre().intValue());
			}
			Cell R13cell6 = R13row.getCell(8);
			if (R13cell6 != null) {
				R13cell6.setCellValue(brf59.getR13_trade() == null ? 0 : brf59.getR13_trade().intValue());
			}
			Cell R13cell7 = R13row.getCell(9);
			if (R13cell7 != null) {
				R13cell7.setCellValue(brf59.getR13_individuals() == null ? 0 : brf59.getR13_individuals().intValue());
			}
			Cell R13cell8 = R13row.getCell(10);
			if (R13cell8 != null) {
				R13cell8.setCellValue(brf59.getR13_investment() == null ? 0 : brf59.getR13_investment().intValue());
			}
			Cell R13cell9 = R13row.getCell(11);
			if (R13cell9 != null) {
				R13cell9.setCellValue(brf59.getR13_nbfi1() == null ? 0 : brf59.getR13_nbfi1().intValue());
			}
			Cell R13cell10 = R13row.getCell(12);
			if (R13cell10 != null) {
				R13cell10.setCellValue(brf59.getR13_interbank1() == null ? 0 : brf59.getR13_interbank1().intValue());
			}
			Cell R13cell11 = R13row.getCell(13);
			if (R13cell11 != null) {
				R13cell11.setCellValue(brf59.getR13_gov1() == null ? 0 : brf59.getR13_gov1().intValue());
			}
			Cell R13cell12 = R13row.getCell(14);
			if (R13cell12 != null) {
				R13cell12.setCellValue(brf59.getR13_corporate1() == null ? 0 : brf59.getR13_corporate1().intValue());
			}
			Cell R13cell13 = R13row.getCell(15);
			if (R13cell13 != null) {
				R13cell13.setCellValue(brf59.getR13_gre1() == null ? 0 : brf59.getR13_gre1().intValue());
			}
			Cell R13cell14 = R13row.getCell(16);
			if (R13cell14 != null) {
				R13cell14.setCellValue(brf59.getR13_trade1() == null ? 0 : brf59.getR13_trade1().intValue());
			}
			Cell R13cell15 = R13row.getCell(17);
			if (R13cell15 != null) {
				R13cell15
						.setCellValue(brf59.getR13_individuals1() == null ? 0 : brf59.getR13_individuals1().intValue());
			}
			Cell R13cell16 = R13row.getCell(18);
			if (R13cell16 != null) {
				R13cell16.setCellValue(brf59.getR13_investment1() == null ? 0 : brf59.getR13_investment1().intValue());
			}
			Cell R13cell17 = R13row.getCell(19);
			if (R13cell17 != null) {
				R13cell17.setCellValue(brf59.getR13_zer0() == null ? 0 : brf59.getR13_zer0().intValue());
			}
			Cell R13cell18 = R13row.getCell(20);
			if (R13cell18 != null) {
				R13cell18.setCellValue(brf59.getR13_three() == null ? 0 : brf59.getR13_three().intValue());
			}
			Cell R13cell19 = R13row.getCell(21);
			if (R13cell19 != null) {
				R13cell19.setCellValue(brf59.getR13_six() == null ? 0 : brf59.getR13_six().intValue());
			}
			Cell R13cell20 = R13row.getCell(22);
			if (R13cell20 != null) {
				R13cell20.setCellValue(brf59.getR13_oneyear() == null ? 0 : brf59.getR13_oneyear().intValue());
			}
			Cell R13cell21 = R13row.getCell(23);
			if (R13cell21 != null) {
				R13cell21.setCellValue(brf59.getR13_foreign() == null ? 0 : brf59.getR13_foreign().intValue());
			}
			Cell R13cell22 = R13row.getCell(24);
			if (R13cell22 != null) {
				R13cell22.setCellValue(brf59.getR13_banks() == null ? 0 : brf59.getR13_banks().intValue());
			}
			Cell R13cell23 = R13row.getCell(25);
			if (R13cell23 != null) {
				R13cell23.setCellValue(brf59.getR13_gov2() == null ? 0 : brf59.getR13_gov2().intValue());
			}
			Cell R13cell24 = R13row.getCell(26);
			if (R13cell24 != null) {
				R13cell24.setCellValue(brf59.getR13_other() == null ? 0 : brf59.getR13_other().intValue());
			}
			Cell R13cell25 = R13row.getCell(27);
			if (R13cell25 != null) {
				R13cell25.setCellValue(brf59.getR13_banks1() == null ? 0 : brf59.getR13_banks1().intValue());
			}
			Cell R13cell26 = R13row.getCell(28);
			if (R13cell26 != null) {
				R13cell26
						.setCellValue(brf59.getR13_individuals2() == null ? 0 : brf59.getR13_individuals2().intValue());
			}
			Cell R13cell27 = R13row.getCell(29);
			if (R13cell27 != null) {
				R13cell27.setCellValue(brf59.getR13_other1() == null ? 0 : brf59.getR13_other1().intValue());
			}
			Cell R13cell28 = R13row.getCell(30);
			if (R13cell28 != null) {
				R13cell28.setCellValue(brf59.getR13_banks2() == null ? 0 : brf59.getR13_banks2().intValue());
			}
			Cell R13cell29 = R13row.getCell(31);
			if (R13cell29 != null) {
				R13cell29.setCellValue(brf59.getR13_gov3() == null ? 0 : brf59.getR13_gov3().intValue());
			}
			Cell R13cell30 = R13row.getCell(32);
			if (R13cell30 != null) {
				R13cell30.setCellValue(brf59.getR13_others2() == null ? 0 : brf59.getR13_others2().intValue());
			}
			Cell R13cell31 = R13row.getCell(33);
			if (R13cell31 != null) {
				R13cell31.setCellValue(brf59.getR13_banks3() == null ? 0 : brf59.getR13_banks3().intValue());
			}
			Cell R13cell32 = R13row.getCell(34);
			if (R13cell32 != null) {
				R13cell32.setCellValue(brf59.getR13_gov4() == null ? 0 : brf59.getR13_gov4().intValue());
			}
			Cell R13cell33 = R13row.getCell(35);
			if (R13cell33 != null) {
				R13cell33.setCellValue(brf59.getR13_others3() == null ? 0 : brf59.getR13_others3().intValue());
			}
			Cell R13cell34 = R13row.getCell(36);
			if (R13cell34 != null) {
				R13cell34.setCellValue(brf59.getR13_foreign1() == null ? 0 : brf59.getR13_foreign1().intValue());
			}
			Cell R13cell35 = R13row.getCell(37);
			if (R13cell35 != null) {
				R13cell35.setCellValue(brf59.getR13_guarantees() == null ? 0 : brf59.getR13_guarantees().intValue());
			}
			Cell R13cell36 = R13row.getCell(38);
			if (R13cell36 != null) {
				R13cell36.setCellValue(brf59.getR13_nbfi2() == null ? 0 : brf59.getR13_nbfi2().intValue());
			}
			Cell R13cell37 = R13row.getCell(39);
			if (R13cell37 != null) {
				R13cell37.setCellValue(brf59.getR13_interbank2() == null ? 0 : brf59.getR13_interbank2().intValue());
			}
			Cell R13cell38 = R13row.getCell(40);
			if (R13cell38 != null) {
				R13cell38.setCellValue(brf59.getR13_gov5() == null ? 0 : brf59.getR13_gov5().intValue());
			}
			Cell R13cell39 = R13row.getCell(41);
			if (R13cell39 != null) {
				R13cell39.setCellValue(brf59.getR13_corporate2() == null ? 0 : brf59.getR13_corporate2().intValue());
			}
			Cell R13cell40 = R13row.getCell(42);
			if (R13cell40 != null) {
				R13cell40.setCellValue(brf59.getR13_gre2() == null ? 0 : brf59.getR13_gre2().intValue());
			}
			Cell R13cell41 = R13row.getCell(43);
			if (R13cell41 != null) {
				R13cell41
						.setCellValue(brf59.getR13_individuals3() == null ? 0 : brf59.getR13_individuals3().intValue());
			}
			Cell R13cell42 = R13row.getCell(44);
			if (R13cell42 != null) {
				R13cell42.setCellValue(brf59.getR13_zero1() == null ? 0 : brf59.getR13_zero1().intValue());
			}
			Cell R13cell43 = R13row.getCell(45);
			if (R13cell43 != null) {
				R13cell43.setCellValue(brf59.getR13_three1() == null ? 0 : brf59.getR13_three1().intValue());
			}
			Cell R13cell44 = R13row.getCell(46);
			if (R13cell44 != null) {
				R13cell44.setCellValue(brf59.getR13_six1() == null ? 0 : brf59.getR13_six1().intValue());
			}
			Cell R13cell45 = R13row.getCell(47);
			if (R13cell45 != null) {
				R13cell45.setCellValue(brf59.getR13_oneyear1() == null ? 0 : brf59.getR13_oneyear1().intValue());
			}
			Cell R13cell46 = R13row.getCell(48);
			if (R13cell46 != null) {
				R13cell46.setCellValue(brf59.getR13_empty() == null ? "" : brf59.getR13_empty().toString());
			}
			Row R14row = sheet.getRow(31);
			Cell R14cell1 = R14row.getCell(3);
			if (R14cell1 != null) {
				R14cell1.setCellValue(brf59.getR14_nbfi() == null ? 0 : brf59.getR14_nbfi().intValue());
			}

			Cell R14cell2 = R14row.getCell(4);
			if (R14cell2 != null) {
				R14cell2.setCellValue(brf59.getR14_interbank() == null ? 0 : brf59.getR14_interbank().intValue());
			}
			Cell R14cell3 = R14row.getCell(5);
			if (R14cell3 != null) {
				R14cell3.setCellValue(brf59.getR14_gov() == null ? 0 : brf59.getR14_gov().intValue());
			}
			Cell R14cell4 = R14row.getCell(6);
			if (R14cell4 != null) {
				R14cell4.setCellValue(brf59.getR14_corporate() == null ? 0 : brf59.getR14_corporate().intValue());
			}
			Cell R14cell5 = R14row.getCell(7);
			if (R14cell5 != null) {
				R14cell5.setCellValue(brf59.getR14_gre() == null ? 0 : brf59.getR14_gre().intValue());
			}
			Cell R14cell6 = R14row.getCell(8);
			if (R14cell6 != null) {
				R14cell6.setCellValue(brf59.getR14_trade() == null ? 0 : brf59.getR14_trade().intValue());
			}
			Cell R14cell7 = R14row.getCell(9);
			if (R14cell7 != null) {
				R14cell7.setCellValue(brf59.getR14_individuals() == null ? 0 : brf59.getR14_individuals().intValue());
			}
			Cell R14cell8 = R14row.getCell(10);
			if (R14cell8 != null) {
				R14cell8.setCellValue(brf59.getR14_investment() == null ? 0 : brf59.getR14_investment().intValue());
			}
			Cell R14cell9 = R14row.getCell(11);
			if (R14cell9 != null) {
				R14cell9.setCellValue(brf59.getR14_nbfi1() == null ? 0 : brf59.getR14_nbfi1().intValue());
			}
			Cell R14cell10 = R14row.getCell(12);
			if (R14cell10 != null) {
				R14cell10.setCellValue(brf59.getR14_interbank1() == null ? 0 : brf59.getR14_interbank1().intValue());
			}
			Cell R14cell11 = R14row.getCell(13);
			if (R14cell11 != null) {
				R14cell11.setCellValue(brf59.getR14_gov1() == null ? 0 : brf59.getR14_gov1().intValue());
			}
			Cell R14cell12 = R14row.getCell(14);
			if (R14cell12 != null) {
				R14cell12.setCellValue(brf59.getR14_corporate1() == null ? 0 : brf59.getR14_corporate1().intValue());
			}
			Cell R14cell13 = R14row.getCell(15);
			if (R14cell13 != null) {
				R14cell13.setCellValue(brf59.getR14_gre1() == null ? 0 : brf59.getR14_gre1().intValue());
			}
			Cell R14cell14 = R14row.getCell(16);
			if (R14cell14 != null) {
				R14cell14.setCellValue(brf59.getR14_trade1() == null ? 0 : brf59.getR14_trade1().intValue());
			}
			Cell R14cell15 = R14row.getCell(17);
			if (R14cell15 != null) {
				R14cell15
						.setCellValue(brf59.getR14_individuals1() == null ? 0 : brf59.getR14_individuals1().intValue());
			}
			Cell R14cell16 = R14row.getCell(18);
			if (R14cell16 != null) {
				R14cell16.setCellValue(brf59.getR14_investment1() == null ? 0 : brf59.getR14_investment1().intValue());
			}
			Cell R14cell17 = R14row.getCell(19);
			if (R14cell17 != null) {
				R14cell17.setCellValue(brf59.getR14_zer0() == null ? 0 : brf59.getR14_zer0().intValue());
			}
			Cell R14cell18 = R14row.getCell(20);
			if (R14cell18 != null) {
				R14cell18.setCellValue(brf59.getR14_three() == null ? 0 : brf59.getR14_three().intValue());
			}
			Cell R14cell19 = R14row.getCell(21);
			if (R14cell19 != null) {
				R14cell19.setCellValue(brf59.getR14_six() == null ? 0 : brf59.getR14_six().intValue());
			}
			Cell R14cell20 = R14row.getCell(22);
			if (R14cell20 != null) {
				R14cell20.setCellValue(brf59.getR14_oneyear() == null ? 0 : brf59.getR14_oneyear().intValue());
			}
			Cell R14cell21 = R14row.getCell(23);
			if (R14cell21 != null) {
				R14cell21.setCellValue(brf59.getR14_foreign() == null ? 0 : brf59.getR14_foreign().intValue());
			}
			Cell R14cell22 = R14row.getCell(24);
			if (R14cell22 != null) {
				R14cell22.setCellValue(brf59.getR14_banks() == null ? 0 : brf59.getR14_banks().intValue());
			}
			Cell R14cell23 = R14row.getCell(25);
			if (R14cell23 != null) {
				R14cell23.setCellValue(brf59.getR14_gov2() == null ? 0 : brf59.getR14_gov2().intValue());
			}
			Cell R14cell24 = R14row.getCell(26);
			if (R14cell24 != null) {
				R14cell24.setCellValue(brf59.getR14_other() == null ? 0 : brf59.getR14_other().intValue());
			}
			Cell R14cell25 = R14row.getCell(27);
			if (R14cell25 != null) {
				R14cell25.setCellValue(brf59.getR14_banks1() == null ? 0 : brf59.getR14_banks1().intValue());
			}
			Cell R14cell26 = R14row.getCell(28);
			if (R14cell26 != null) {
				R14cell26
						.setCellValue(brf59.getR14_individuals2() == null ? 0 : brf59.getR14_individuals2().intValue());
			}
			Cell R14cell27 = R14row.getCell(29);
			if (R14cell27 != null) {
				R14cell27.setCellValue(brf59.getR14_other1() == null ? 0 : brf59.getR14_other1().intValue());
			}
			Cell R14cell28 = R14row.getCell(30);
			if (R14cell28 != null) {
				R14cell28.setCellValue(brf59.getR14_banks2() == null ? 0 : brf59.getR14_banks2().intValue());
			}
			Cell R14cell29 = R14row.getCell(31);
			if (R14cell29 != null) {
				R14cell29.setCellValue(brf59.getR14_gov3() == null ? 0 : brf59.getR14_gov3().intValue());
			}
			Cell R14cell30 = R14row.getCell(32);
			if (R14cell30 != null) {
				R14cell30.setCellValue(brf59.getR14_others2() == null ? 0 : brf59.getR14_others2().intValue());
			}
			Cell R14cell31 = R14row.getCell(33);
			if (R14cell31 != null) {
				R14cell31.setCellValue(brf59.getR14_banks3() == null ? 0 : brf59.getR14_banks3().intValue());
			}
			Cell R14cell32 = R14row.getCell(34);
			if (R14cell32 != null) {
				R14cell32.setCellValue(brf59.getR14_gov4() == null ? 0 : brf59.getR14_gov4().intValue());
			}
			Cell R14cell33 = R14row.getCell(35);
			if (R14cell33 != null) {
				R14cell33.setCellValue(brf59.getR14_others3() == null ? 0 : brf59.getR14_others3().intValue());
			}
			Cell R14cell34 = R14row.getCell(36);
			if (R14cell34 != null) {
				R14cell34.setCellValue(brf59.getR14_foreign1() == null ? 0 : brf59.getR14_foreign1().intValue());
			}
			Cell R14cell35 = R14row.getCell(37);
			if (R14cell35 != null) {
				R14cell35.setCellValue(brf59.getR14_guarantees() == null ? 0 : brf59.getR14_guarantees().intValue());
			}
			Cell R14cell36 = R14row.getCell(38);
			if (R14cell36 != null) {
				R14cell36.setCellValue(brf59.getR14_nbfi2() == null ? 0 : brf59.getR14_nbfi2().intValue());
			}
			Cell R14cell37 = R14row.getCell(39);
			if (R14cell37 != null) {
				R14cell37.setCellValue(brf59.getR14_interbank2() == null ? 0 : brf59.getR14_interbank2().intValue());
			}
			Cell R14cell38 = R14row.getCell(40);
			if (R14cell38 != null) {
				R14cell38.setCellValue(brf59.getR14_gov5() == null ? 0 : brf59.getR14_gov5().intValue());
			}
			Cell R14cell39 = R14row.getCell(41);
			if (R14cell39 != null) {
				R14cell39.setCellValue(brf59.getR14_corporate2() == null ? 0 : brf59.getR14_corporate2().intValue());
			}
			Cell R14cell40 = R14row.getCell(42);
			if (R14cell40 != null) {
				R14cell40.setCellValue(brf59.getR14_gre2() == null ? 0 : brf59.getR14_gre2().intValue());
			}
			Cell R14cell41 = R14row.getCell(43);
			if (R14cell41 != null) {
				R14cell41
						.setCellValue(brf59.getR14_individuals3() == null ? 0 : brf59.getR14_individuals3().intValue());
			}
			Cell R14cell42 = R14row.getCell(44);
			if (R14cell42 != null) {
				R14cell42.setCellValue(brf59.getR14_zero1() == null ? 0 : brf59.getR14_zero1().intValue());
			}
			Cell R14cell43 = R14row.getCell(45);
			if (R14cell43 != null) {
				R14cell43.setCellValue(brf59.getR14_three1() == null ? 0 : brf59.getR14_three1().intValue());
			}
			Cell R14cell44 = R14row.getCell(46);
			if (R14cell44 != null) {
				R14cell44.setCellValue(brf59.getR14_six1() == null ? 0 : brf59.getR14_six1().intValue());
			}
			Cell R14cell45 = R14row.getCell(47);
			if (R14cell45 != null) {
				R14cell45.setCellValue(brf59.getR14_oneyear1() == null ? 0 : brf59.getR14_oneyear1().intValue());
			}
			Cell R14cell46 = R14row.getCell(48);
			if (R14cell46 != null) {
				R14cell46.setCellValue(brf59.getR14_empty() == null ? "" : brf59.getR14_empty().toString());
			}
			Row R15row = sheet.getRow(32);
			Cell R15cell1 = R15row.getCell(3);
			if (R15cell1 != null) {
				R15cell1.setCellValue(brf59.getR15_nbfi() == null ? 0 : brf59.getR15_nbfi().intValue());
			}

			Cell R15cell2 = R15row.getCell(4);
			if (R15cell2 != null) {
				R15cell2.setCellValue(brf59.getR15_interbank() == null ? 0 : brf59.getR15_interbank().intValue());
			}
			Cell R15cell3 = R15row.getCell(5);
			if (R15cell3 != null) {
				R15cell3.setCellValue(brf59.getR15_gov() == null ? 0 : brf59.getR15_gov().intValue());
			}
			Cell R15cell4 = R15row.getCell(6);
			if (R15cell4 != null) {
				R15cell4.setCellValue(brf59.getR15_corporate() == null ? 0 : brf59.getR15_corporate().intValue());
			}
			Cell R15cell5 = R15row.getCell(7);
			if (R15cell5 != null) {
				R15cell5.setCellValue(brf59.getR15_gre() == null ? 0 : brf59.getR15_gre().intValue());
			}
			Cell R15cell6 = R15row.getCell(8);
			if (R15cell6 != null) {
				R15cell6.setCellValue(brf59.getR15_trade() == null ? 0 : brf59.getR15_trade().intValue());
			}
			Cell R15cell7 = R15row.getCell(9);
			if (R15cell7 != null) {
				R15cell7.setCellValue(brf59.getR15_individuals() == null ? 0 : brf59.getR15_individuals().intValue());
			}
			Cell R15cell8 = R15row.getCell(10);
			if (R15cell8 != null) {
				R15cell8.setCellValue(brf59.getR15_investment() == null ? 0 : brf59.getR15_investment().intValue());
			}
			Cell R15cell9 = R15row.getCell(11);
			if (R15cell9 != null) {
				R15cell9.setCellValue(brf59.getR15_nbfi1() == null ? 0 : brf59.getR15_nbfi1().intValue());
			}
			Cell R15cell10 = R15row.getCell(12);
			if (R15cell10 != null) {
				R15cell10.setCellValue(brf59.getR15_interbank1() == null ? 0 : brf59.getR15_interbank1().intValue());
			}
			Cell R15cell11 = R15row.getCell(13);
			if (R15cell11 != null) {
				R15cell11.setCellValue(brf59.getR15_gov1() == null ? 0 : brf59.getR15_gov1().intValue());
			}
			Cell R15cell12 = R15row.getCell(14);
			if (R15cell12 != null) {
				R15cell12.setCellValue(brf59.getR15_corporate1() == null ? 0 : brf59.getR15_corporate1().intValue());
			}
			Cell R15cell13 = R15row.getCell(15);
			if (R15cell13 != null) {
				R15cell13.setCellValue(brf59.getR15_gre1() == null ? 0 : brf59.getR15_gre1().intValue());
			}
			Cell R15cell14 = R15row.getCell(16);
			if (R15cell14 != null) {
				R15cell14.setCellValue(brf59.getR15_trade1() == null ? 0 : brf59.getR15_trade1().intValue());
			}
			Cell R15cell15 = R15row.getCell(17);
			if (R15cell15 != null) {
				R15cell15
						.setCellValue(brf59.getR15_individuals1() == null ? 0 : brf59.getR15_individuals1().intValue());
			}
			Cell R15cell16 = R15row.getCell(18);
			if (R15cell16 != null) {
				R15cell16.setCellValue(brf59.getR15_investment1() == null ? 0 : brf59.getR15_investment1().intValue());
			}
			Cell R15cell17 = R15row.getCell(19);
			if (R15cell17 != null) {
				R15cell17.setCellValue(brf59.getR15_zer0() == null ? 0 : brf59.getR15_zer0().intValue());
			}
			Cell R15cell18 = R15row.getCell(20);
			if (R15cell18 != null) {
				R15cell18.setCellValue(brf59.getR15_three() == null ? 0 : brf59.getR15_three().intValue());
			}
			Cell R15cell19 = R15row.getCell(21);
			if (R15cell19 != null) {
				R15cell19.setCellValue(brf59.getR15_six() == null ? 0 : brf59.getR15_six().intValue());
			}
			Cell R15cell20 = R15row.getCell(22);
			if (R15cell20 != null) {
				R15cell20.setCellValue(brf59.getR15_oneyear() == null ? 0 : brf59.getR15_oneyear().intValue());
			}
			Cell R15cell21 = R15row.getCell(23);
			if (R15cell21 != null) {
				R15cell21.setCellValue(brf59.getR15_foreign() == null ? 0 : brf59.getR15_foreign().intValue());
			}
			Cell R15cell22 = R15row.getCell(24);
			if (R15cell22 != null) {
				R15cell22.setCellValue(brf59.getR15_banks() == null ? 0 : brf59.getR15_banks().intValue());
			}
			Cell R15cell23 = R15row.getCell(25);
			if (R15cell23 != null) {
				R15cell23.setCellValue(brf59.getR15_gov2() == null ? 0 : brf59.getR15_gov2().intValue());
			}
			Cell R15cell24 = R15row.getCell(26);
			if (R15cell24 != null) {
				R15cell24.setCellValue(brf59.getR15_other() == null ? 0 : brf59.getR15_other().intValue());
			}
			Cell R15cell25 = R15row.getCell(27);
			if (R15cell25 != null) {
				R15cell25.setCellValue(brf59.getR15_banks1() == null ? 0 : brf59.getR15_banks1().intValue());
			}
			Cell R15cell26 = R15row.getCell(28);
			if (R15cell26 != null) {
				R15cell26
						.setCellValue(brf59.getR15_individuals2() == null ? 0 : brf59.getR15_individuals2().intValue());
			}
			Cell R15cell27 = R15row.getCell(29);
			if (R15cell27 != null) {
				R15cell27.setCellValue(brf59.getR15_other1() == null ? 0 : brf59.getR15_other1().intValue());
			}
			Cell R15cell28 = R15row.getCell(30);
			if (R15cell28 != null) {
				R15cell28.setCellValue(brf59.getR15_banks2() == null ? 0 : brf59.getR15_banks2().intValue());
			}
			Cell R15cell29 = R15row.getCell(31);
			if (R15cell29 != null) {
				R15cell29.setCellValue(brf59.getR15_gov3() == null ? 0 : brf59.getR15_gov3().intValue());
			}
			Cell R15cell30 = R15row.getCell(32);
			if (R15cell30 != null) {
				R15cell30.setCellValue(brf59.getR15_others2() == null ? 0 : brf59.getR15_others2().intValue());
			}
			Cell R15cell31 = R15row.getCell(33);
			if (R15cell31 != null) {
				R15cell31.setCellValue(brf59.getR15_banks3() == null ? 0 : brf59.getR15_banks3().intValue());
			}
			Cell R15cell32 = R15row.getCell(34);
			if (R15cell32 != null) {
				R15cell32.setCellValue(brf59.getR15_gov4() == null ? 0 : brf59.getR15_gov4().intValue());
			}
			Cell R15cell33 = R15row.getCell(35);
			if (R15cell33 != null) {
				R15cell33.setCellValue(brf59.getR15_others3() == null ? 0 : brf59.getR15_others3().intValue());
			}
			Cell R15cell34 = R15row.getCell(36);
			if (R15cell34 != null) {
				R15cell34.setCellValue(brf59.getR15_foreign1() == null ? 0 : brf59.getR15_foreign1().intValue());
			}
			Cell R15cell35 = R15row.getCell(37);
			if (R15cell35 != null) {
				R15cell35.setCellValue(brf59.getR15_guarantees() == null ? 0 : brf59.getR15_guarantees().intValue());
			}
			Cell R15cell36 = R15row.getCell(38);
			if (R15cell36 != null) {
				R15cell36.setCellValue(brf59.getR15_nbfi2() == null ? 0 : brf59.getR15_nbfi2().intValue());
			}
			Cell R15cell37 = R15row.getCell(39);
			if (R15cell37 != null) {
				R15cell37.setCellValue(brf59.getR15_interbank2() == null ? 0 : brf59.getR15_interbank2().intValue());
			}
			Cell R15cell38 = R15row.getCell(40);
			if (R15cell38 != null) {
				R15cell38.setCellValue(brf59.getR15_gov5() == null ? 0 : brf59.getR15_gov5().intValue());
			}
			Cell R15cell39 = R15row.getCell(41);
			if (R15cell39 != null) {
				R15cell39.setCellValue(brf59.getR15_corporate2() == null ? 0 : brf59.getR15_corporate2().intValue());
			}
			Cell R15cell40 = R15row.getCell(42);
			if (R15cell40 != null) {
				R15cell40.setCellValue(brf59.getR15_gre2() == null ? 0 : brf59.getR15_gre2().intValue());
			}
			Cell R15cell41 = R15row.getCell(43);
			if (R15cell41 != null) {
				R15cell41
						.setCellValue(brf59.getR15_individuals3() == null ? 0 : brf59.getR15_individuals3().intValue());
			}
			Cell R15cell42 = R15row.getCell(44);
			if (R15cell42 != null) {
				R15cell42.setCellValue(brf59.getR15_zero1() == null ? 0 : brf59.getR15_zero1().intValue());
			}
			Cell R15cell43 = R15row.getCell(45);
			if (R15cell43 != null) {
				R15cell43.setCellValue(brf59.getR15_three1() == null ? 0 : brf59.getR15_three1().intValue());
			}
			Cell R15cell44 = R15row.getCell(46);
			if (R15cell44 != null) {
				R15cell44.setCellValue(brf59.getR15_six1() == null ? 0 : brf59.getR15_six1().intValue());
			}
			Cell R15cell45 = R15row.getCell(47);
			if (R15cell45 != null) {
				R15cell45.setCellValue(brf59.getR15_oneyear1() == null ? 0 : brf59.getR15_oneyear1().intValue());
			}
			Cell R15cell46 = R15row.getCell(48);
			if (R15cell46 != null) {
				R15cell46.setCellValue(brf59.getR15_empty() == null ? "" : brf59.getR15_empty().toString());
			}
			Row R16row = sheet.getRow(33);
			Cell R16cell1 = R16row.getCell(3);
			if (R16cell1 != null) {
				R16cell1.setCellValue(brf59.getR16_nbfi() == null ? 0 : brf59.getR16_nbfi().intValue());
			}

			Cell R16cell2 = R16row.getCell(4);
			if (R16cell2 != null) {
				R16cell2.setCellValue(brf59.getR16_interbank() == null ? 0 : brf59.getR16_interbank().intValue());
			}
			Cell R16cell3 = R16row.getCell(5);
			if (R16cell3 != null) {
				R16cell3.setCellValue(brf59.getR16_gov() == null ? 0 : brf59.getR16_gov().intValue());
			}
			Cell R16cell4 = R16row.getCell(6);
			if (R16cell4 != null) {
				R16cell4.setCellValue(brf59.getR16_corporate() == null ? 0 : brf59.getR16_corporate().intValue());
			}
			Cell R16cell5 = R16row.getCell(7);
			if (R16cell5 != null) {
				R16cell5.setCellValue(brf59.getR16_gre() == null ? 0 : brf59.getR16_gre().intValue());
			}
			Cell R16cell6 = R16row.getCell(8);
			if (R16cell6 != null) {
				R16cell6.setCellValue(brf59.getR16_trade() == null ? 0 : brf59.getR16_trade().intValue());
			}
			Cell R16cell7 = R16row.getCell(9);
			if (R16cell7 != null) {
				R16cell7.setCellValue(brf59.getR16_individuals() == null ? 0 : brf59.getR16_individuals().intValue());
			}
			Cell R16cell8 = R16row.getCell(10);
			if (R16cell8 != null) {
				R16cell8.setCellValue(brf59.getR16_investment() == null ? 0 : brf59.getR16_investment().intValue());
			}
			Cell R16cell9 = R16row.getCell(11);
			if (R16cell9 != null) {
				R16cell9.setCellValue(brf59.getR16_nbfi1() == null ? 0 : brf59.getR16_nbfi1().intValue());
			}
			Cell R16cell10 = R16row.getCell(12);
			if (R16cell10 != null) {
				R16cell10.setCellValue(brf59.getR16_interbank1() == null ? 0 : brf59.getR16_interbank1().intValue());
			}
			Cell R16cell11 = R16row.getCell(13);
			if (R16cell11 != null) {
				R16cell11.setCellValue(brf59.getR16_gov1() == null ? 0 : brf59.getR16_gov1().intValue());
			}
			Cell R16cell12 = R16row.getCell(14);
			if (R16cell12 != null) {
				R16cell12.setCellValue(brf59.getR16_corporate1() == null ? 0 : brf59.getR16_corporate1().intValue());
			}
			Cell R16cell13 = R16row.getCell(15);
			if (R16cell13 != null) {
				R16cell13.setCellValue(brf59.getR16_gre1() == null ? 0 : brf59.getR16_gre1().intValue());
			}
			Cell R16cell14 = R16row.getCell(16);
			if (R16cell14 != null) {
				R16cell14.setCellValue(brf59.getR16_trade1() == null ? 0 : brf59.getR16_trade1().intValue());
			}
			Cell R16cell15 = R16row.getCell(17);
			if (R16cell15 != null) {
				R16cell15
						.setCellValue(brf59.getR16_individuals1() == null ? 0 : brf59.getR16_individuals1().intValue());
			}
			Cell R16cell16 = R16row.getCell(18);
			if (R16cell16 != null) {
				R16cell16.setCellValue(brf59.getR16_investment1() == null ? 0 : brf59.getR16_investment1().intValue());
			}
			Cell R16cell17 = R16row.getCell(19);
			if (R16cell17 != null) {
				R16cell17.setCellValue(brf59.getR16_zer0() == null ? 0 : brf59.getR16_zer0().intValue());
			}
			Cell R16cell18 = R16row.getCell(20);
			if (R16cell18 != null) {
				R16cell18.setCellValue(brf59.getR16_three() == null ? 0 : brf59.getR16_three().intValue());
			}
			Cell R16cell19 = R16row.getCell(21);
			if (R16cell19 != null) {
				R16cell19.setCellValue(brf59.getR16_six() == null ? 0 : brf59.getR16_six().intValue());
			}
			Cell R16cell20 = R16row.getCell(22);
			if (R16cell20 != null) {
				R16cell20.setCellValue(brf59.getR16_oneyear() == null ? 0 : brf59.getR16_oneyear().intValue());
			}
			Cell R16cell21 = R16row.getCell(23);
			if (R16cell21 != null) {
				R16cell21.setCellValue(brf59.getR16_foreign() == null ? 0 : brf59.getR16_foreign().intValue());
			}
			Cell R16cell22 = R16row.getCell(24);
			if (R16cell22 != null) {
				R16cell22.setCellValue(brf59.getR16_banks() == null ? 0 : brf59.getR16_banks().intValue());
			}
			Cell R16cell23 = R16row.getCell(25);
			if (R16cell23 != null) {
				R16cell23.setCellValue(brf59.getR16_gov2() == null ? 0 : brf59.getR16_gov2().intValue());
			}
			Cell R16cell24 = R16row.getCell(26);
			if (R16cell24 != null) {
				R16cell24.setCellValue(brf59.getR16_other() == null ? 0 : brf59.getR16_other().intValue());
			}
			Cell R16cell25 = R16row.getCell(27);
			if (R16cell25 != null) {
				R16cell25.setCellValue(brf59.getR16_banks1() == null ? 0 : brf59.getR16_banks1().intValue());
			}
			Cell R16cell26 = R16row.getCell(28);
			if (R16cell26 != null) {
				R16cell26
						.setCellValue(brf59.getR16_individuals2() == null ? 0 : brf59.getR16_individuals2().intValue());
			}
			Cell R16cell27 = R16row.getCell(29);
			if (R16cell27 != null) {
				R16cell27.setCellValue(brf59.getR16_other1() == null ? 0 : brf59.getR16_other1().intValue());
			}
			Cell R16cell28 = R16row.getCell(30);
			if (R16cell28 != null) {
				R16cell28.setCellValue(brf59.getR16_banks2() == null ? 0 : brf59.getR16_banks2().intValue());
			}
			Cell R16cell29 = R16row.getCell(31);
			if (R16cell29 != null) {
				R16cell29.setCellValue(brf59.getR16_gov3() == null ? 0 : brf59.getR16_gov3().intValue());
			}
			Cell R16cell30 = R16row.getCell(32);
			if (R16cell30 != null) {
				R16cell30.setCellValue(brf59.getR16_others2() == null ? 0 : brf59.getR16_others2().intValue());
			}
			Cell R16cell31 = R16row.getCell(33);
			if (R16cell31 != null) {
				R16cell31.setCellValue(brf59.getR16_banks3() == null ? 0 : brf59.getR16_banks3().intValue());
			}
			Cell R16cell32 = R16row.getCell(34);
			if (R16cell32 != null) {
				R16cell32.setCellValue(brf59.getR16_gov4() == null ? 0 : brf59.getR16_gov4().intValue());
			}
			Cell R16cell33 = R16row.getCell(35);
			if (R16cell33 != null) {
				R16cell33.setCellValue(brf59.getR16_others3() == null ? 0 : brf59.getR16_others3().intValue());
			}
			Cell R16cell34 = R16row.getCell(36);
			if (R16cell34 != null) {
				R16cell34.setCellValue(brf59.getR16_foreign1() == null ? 0 : brf59.getR16_foreign1().intValue());
			}
			Cell R16cell35 = R16row.getCell(37);
			if (R16cell35 != null) {
				R16cell35.setCellValue(brf59.getR16_guarantees() == null ? 0 : brf59.getR16_guarantees().intValue());
			}
			Cell R16cell36 = R16row.getCell(38);
			if (R16cell36 != null) {
				R16cell36.setCellValue(brf59.getR16_nbfi2() == null ? 0 : brf59.getR16_nbfi2().intValue());
			}
			Cell R16cell37 = R16row.getCell(39);
			if (R16cell37 != null) {
				R16cell37.setCellValue(brf59.getR16_interbank2() == null ? 0 : brf59.getR16_interbank2().intValue());
			}
			Cell R16cell38 = R16row.getCell(40);
			if (R16cell38 != null) {
				R16cell38.setCellValue(brf59.getR16_gov5() == null ? 0 : brf59.getR16_gov5().intValue());
			}
			Cell R16cell39 = R16row.getCell(41);
			if (R16cell39 != null) {
				R16cell39.setCellValue(brf59.getR16_corporate2() == null ? 0 : brf59.getR16_corporate2().intValue());
			}
			Cell R16cell40 = R16row.getCell(42);
			if (R16cell40 != null) {
				R16cell40.setCellValue(brf59.getR16_gre2() == null ? 0 : brf59.getR16_gre2().intValue());
			}
			Cell R16cell41 = R16row.getCell(43);
			if (R16cell41 != null) {
				R16cell41
						.setCellValue(brf59.getR16_individuals3() == null ? 0 : brf59.getR16_individuals3().intValue());
			}
			Cell R16cell42 = R16row.getCell(44);
			if (R16cell42 != null) {
				R16cell42.setCellValue(brf59.getR16_zero1() == null ? 0 : brf59.getR16_zero1().intValue());
			}
			Cell R16cell43 = R16row.getCell(45);
			if (R16cell43 != null) {
				R16cell43.setCellValue(brf59.getR16_three1() == null ? 0 : brf59.getR16_three1().intValue());
			}
			Cell R16cell44 = R16row.getCell(46);
			if (R16cell44 != null) {
				R16cell44.setCellValue(brf59.getR16_six1() == null ? 0 : brf59.getR16_six1().intValue());
			}
			Cell R16cell45 = R16row.getCell(47);
			if (R16cell45 != null) {
				R16cell45.setCellValue(brf59.getR16_oneyear1() == null ? 0 : brf59.getR16_oneyear1().intValue());
			}
			Cell R16cell46 = R16row.getCell(48);
			if (R16cell46 != null) {
				R16cell46.setCellValue(brf59.getR16_empty() == null ? "" : brf59.getR16_empty().toString());
			}
			Row R17row = sheet.getRow(34);
			Cell R17cell1 = R17row.getCell(3);
			if (R17cell1 != null) {
				R17cell1.setCellValue(brf59.getR17_nbfi() == null ? 0 : brf59.getR17_nbfi().intValue());
			}

			Cell R17cell2 = R17row.getCell(4);
			if (R17cell2 != null) {
				R17cell2.setCellValue(brf59.getR17_interbank() == null ? 0 : brf59.getR17_interbank().intValue());
			}
			Cell R17cell3 = R17row.getCell(5);
			if (R17cell3 != null) {
				R17cell3.setCellValue(brf59.getR17_gov() == null ? 0 : brf59.getR17_gov().intValue());
			}
			Cell R17cell4 = R17row.getCell(6);
			if (R17cell4 != null) {
				R17cell4.setCellValue(brf59.getR17_corporate() == null ? 0 : brf59.getR17_corporate().intValue());
			}
			Cell R17cell5 = R17row.getCell(7);
			if (R17cell5 != null) {
				R17cell5.setCellValue(brf59.getR17_gre() == null ? 0 : brf59.getR17_gre().intValue());
			}
			Cell R17cell6 = R17row.getCell(8);
			if (R17cell6 != null) {
				R17cell6.setCellValue(brf59.getR17_trade() == null ? 0 : brf59.getR17_trade().intValue());
			}
			Cell R17cell7 = R17row.getCell(9);
			if (R17cell7 != null) {
				R17cell7.setCellValue(brf59.getR17_individuals() == null ? 0 : brf59.getR17_individuals().intValue());
			}
			Cell R17cell8 = R17row.getCell(10);
			if (R17cell8 != null) {
				R17cell8.setCellValue(brf59.getR17_investment() == null ? 0 : brf59.getR17_investment().intValue());
			}
			Cell R17cell9 = R17row.getCell(11);
			if (R17cell9 != null) {
				R17cell9.setCellValue(brf59.getR17_nbfi1() == null ? 0 : brf59.getR17_nbfi1().intValue());
			}
			Cell R17cell10 = R17row.getCell(12);
			if (R17cell10 != null) {
				R17cell10.setCellValue(brf59.getR17_interbank1() == null ? 0 : brf59.getR17_interbank1().intValue());
			}
			Cell R17cell11 = R17row.getCell(13);
			if (R17cell11 != null) {
				R17cell11.setCellValue(brf59.getR17_gov1() == null ? 0 : brf59.getR17_gov1().intValue());
			}
			Cell R17cell12 = R17row.getCell(14);
			if (R17cell12 != null) {
				R17cell12.setCellValue(brf59.getR17_corporate1() == null ? 0 : brf59.getR17_corporate1().intValue());
			}
			Cell R17cell13 = R17row.getCell(15);
			if (R17cell13 != null) {
				R17cell13.setCellValue(brf59.getR17_gre1() == null ? 0 : brf59.getR17_gre1().intValue());
			}
			Cell R17cell14 = R17row.getCell(16);
			if (R17cell14 != null) {
				R17cell14.setCellValue(brf59.getR17_trade1() == null ? 0 : brf59.getR17_trade1().intValue());
			}
			Cell R17cell15 = R17row.getCell(17);
			if (R17cell15 != null) {
				R17cell15
						.setCellValue(brf59.getR17_individuals1() == null ? 0 : brf59.getR17_individuals1().intValue());
			}
			Cell R17cell16 = R17row.getCell(18);
			if (R17cell16 != null) {
				R17cell16.setCellValue(brf59.getR17_investment1() == null ? 0 : brf59.getR17_investment1().intValue());
			}
			Cell R17cell17 = R17row.getCell(19);
			if (R17cell17 != null) {
				R17cell17.setCellValue(brf59.getR17_zer0() == null ? 0 : brf59.getR17_zer0().intValue());
			}
			Cell R17cell18 = R17row.getCell(20);
			if (R17cell18 != null) {
				R17cell18.setCellValue(brf59.getR17_three() == null ? 0 : brf59.getR17_three().intValue());
			}
			Cell R17cell19 = R17row.getCell(21);
			if (R17cell19 != null) {
				R17cell19.setCellValue(brf59.getR17_six() == null ? 0 : brf59.getR17_six().intValue());
			}
			Cell R17cell20 = R17row.getCell(22);
			if (R17cell20 != null) {
				R17cell20.setCellValue(brf59.getR17_oneyear() == null ? 0 : brf59.getR17_oneyear().intValue());
			}
			Cell R17cell21 = R17row.getCell(23);
			if (R17cell21 != null) {
				R17cell21.setCellValue(brf59.getR17_foreign() == null ? 0 : brf59.getR17_foreign().intValue());
			}
			Cell R17cell22 = R17row.getCell(24);
			if (R17cell22 != null) {
				R17cell22.setCellValue(brf59.getR17_banks() == null ? 0 : brf59.getR17_banks().intValue());
			}
			Cell R17cell23 = R17row.getCell(25);
			if (R17cell23 != null) {
				R17cell23.setCellValue(brf59.getR17_gov2() == null ? 0 : brf59.getR17_gov2().intValue());
			}
			Cell R17cell24 = R17row.getCell(26);
			if (R17cell24 != null) {
				R17cell24.setCellValue(brf59.getR17_other() == null ? 0 : brf59.getR17_other().intValue());
			}
			Cell R17cell25 = R17row.getCell(27);
			if (R17cell25 != null) {
				R17cell25.setCellValue(brf59.getR17_banks1() == null ? 0 : brf59.getR17_banks1().intValue());
			}
			Cell R17cell26 = R17row.getCell(28);
			if (R17cell26 != null) {
				R17cell26
						.setCellValue(brf59.getR17_individuals2() == null ? 0 : brf59.getR17_individuals2().intValue());
			}
			Cell R17cell27 = R17row.getCell(29);
			if (R17cell27 != null) {
				R17cell27.setCellValue(brf59.getR17_other1() == null ? 0 : brf59.getR17_other1().intValue());
			}
			Cell R17cell28 = R17row.getCell(30);
			if (R17cell28 != null) {
				R17cell28.setCellValue(brf59.getR17_banks2() == null ? 0 : brf59.getR17_banks2().intValue());
			}
			Cell R17cell29 = R17row.getCell(31);
			if (R17cell29 != null) {
				R17cell29.setCellValue(brf59.getR17_gov3() == null ? 0 : brf59.getR17_gov3().intValue());
			}
			Cell R17cell30 = R17row.getCell(32);
			if (R17cell30 != null) {
				R17cell30.setCellValue(brf59.getR17_others2() == null ? 0 : brf59.getR17_others2().intValue());
			}
			Cell R17cell31 = R17row.getCell(33);
			if (R17cell31 != null) {
				R17cell31.setCellValue(brf59.getR17_banks3() == null ? 0 : brf59.getR17_banks3().intValue());
			}
			Cell R17cell32 = R17row.getCell(34);
			if (R17cell32 != null) {
				R17cell32.setCellValue(brf59.getR17_gov4() == null ? 0 : brf59.getR17_gov4().intValue());
			}
			Cell R17cell33 = R17row.getCell(35);
			if (R17cell33 != null) {
				R17cell33.setCellValue(brf59.getR17_others3() == null ? 0 : brf59.getR17_others3().intValue());
			}
			Cell R17cell34 = R17row.getCell(36);
			if (R17cell34 != null) {
				R17cell34.setCellValue(brf59.getR17_foreign1() == null ? 0 : brf59.getR17_foreign1().intValue());
			}
			Cell R17cell35 = R17row.getCell(37);
			if (R17cell35 != null) {
				R17cell35.setCellValue(brf59.getR17_guarantees() == null ? 0 : brf59.getR17_guarantees().intValue());
			}
			Cell R17cell36 = R17row.getCell(38);
			if (R17cell36 != null) {
				R17cell36.setCellValue(brf59.getR17_nbfi2() == null ? 0 : brf59.getR17_nbfi2().intValue());
			}
			Cell R17cell37 = R17row.getCell(39);
			if (R17cell37 != null) {
				R17cell37.setCellValue(brf59.getR17_interbank2() == null ? 0 : brf59.getR17_interbank2().intValue());
			}
			Cell R17cell38 = R17row.getCell(40);
			if (R17cell38 != null) {
				R17cell38.setCellValue(brf59.getR17_gov5() == null ? 0 : brf59.getR17_gov5().intValue());
			}
			Cell R17cell39 = R17row.getCell(41);
			if (R17cell39 != null) {
				R17cell39.setCellValue(brf59.getR17_corporate2() == null ? 0 : brf59.getR17_corporate2().intValue());
			}
			Cell R17cell40 = R17row.getCell(42);
			if (R17cell40 != null) {
				R17cell40.setCellValue(brf59.getR17_gre2() == null ? 0 : brf59.getR17_gre2().intValue());
			}
			Cell R17cell41 = R17row.getCell(43);
			if (R17cell41 != null) {
				R17cell41
						.setCellValue(brf59.getR17_individuals3() == null ? 0 : brf59.getR17_individuals3().intValue());
			}
			Cell R17cell42 = R17row.getCell(44);
			if (R17cell42 != null) {
				R17cell42.setCellValue(brf59.getR17_zero1() == null ? 0 : brf59.getR17_zero1().intValue());
			}
			Cell R17cell43 = R17row.getCell(45);
			if (R17cell43 != null) {
				R17cell43.setCellValue(brf59.getR17_three1() == null ? 0 : brf59.getR17_three1().intValue());
			}
			Cell R17cell44 = R17row.getCell(46);
			if (R17cell44 != null) {
				R17cell44.setCellValue(brf59.getR17_six1() == null ? 0 : brf59.getR17_six1().intValue());
			}
			Cell R17cell45 = R17row.getCell(47);
			if (R17cell45 != null) {
				R17cell45.setCellValue(brf59.getR17_oneyear1() == null ? 0 : brf59.getR17_oneyear1().intValue());
			}
			Cell R17cell46 = R17row.getCell(48);
			if (R17cell46 != null) {
				R17cell46.setCellValue(brf59.getR17_empty() == null ? "" : brf59.getR17_empty().toString());
			}
			Row R18row = sheet.getRow(35);
			Cell R18cell1 = R18row.getCell(3);
			if (R18cell1 != null) {
				R18cell1.setCellValue(brf59.getR18_nbfi() == null ? 0 : brf59.getR18_nbfi().intValue());
			}

			Cell R18cell2 = R18row.getCell(4);
			if (R18cell2 != null) {
				R18cell2.setCellValue(brf59.getR18_interbank() == null ? 0 : brf59.getR18_interbank().intValue());
			}
			Cell R18cell3 = R18row.getCell(5);
			if (R18cell3 != null) {
				R18cell3.setCellValue(brf59.getR18_gov() == null ? 0 : brf59.getR18_gov().intValue());
			}
			Cell R18cell4 = R18row.getCell(6);
			if (R18cell4 != null) {
				R18cell4.setCellValue(brf59.getR18_corporate() == null ? 0 : brf59.getR18_corporate().intValue());
			}
			Cell R18cell5 = R18row.getCell(7);
			if (R18cell5 != null) {
				R18cell5.setCellValue(brf59.getR18_gre() == null ? 0 : brf59.getR18_gre().intValue());
			}
			Cell R18cell6 = R18row.getCell(8);
			if (R18cell6 != null) {
				R18cell6.setCellValue(brf59.getR18_trade() == null ? 0 : brf59.getR18_trade().intValue());
			}
			Cell R18cell7 = R18row.getCell(9);
			if (R18cell7 != null) {
				R18cell7.setCellValue(brf59.getR18_individuals() == null ? 0 : brf59.getR18_individuals().intValue());
			}
			Cell R18cell8 = R18row.getCell(10);
			if (R18cell8 != null) {
				R18cell8.setCellValue(brf59.getR18_investment() == null ? 0 : brf59.getR18_investment().intValue());
			}
			Cell R18cell9 = R18row.getCell(11);
			if (R18cell9 != null) {
				R18cell9.setCellValue(brf59.getR18_nbfi1() == null ? 0 : brf59.getR18_nbfi1().intValue());
			}
			Cell R18cell10 = R18row.getCell(12);
			if (R18cell10 != null) {
				R18cell10.setCellValue(brf59.getR18_interbank1() == null ? 0 : brf59.getR18_interbank1().intValue());
			}
			Cell R18cell11 = R18row.getCell(13);
			if (R18cell11 != null) {
				R18cell11.setCellValue(brf59.getR18_gov1() == null ? 0 : brf59.getR18_gov1().intValue());
			}
			Cell R18cell12 = R18row.getCell(14);
			if (R18cell12 != null) {
				R18cell12.setCellValue(brf59.getR18_corporate1() == null ? 0 : brf59.getR18_corporate1().intValue());
			}
			Cell R18cell13 = R18row.getCell(15);
			if (R18cell13 != null) {
				R18cell13.setCellValue(brf59.getR18_gre1() == null ? 0 : brf59.getR18_gre1().intValue());
			}
			Cell R18cell14 = R18row.getCell(16);
			if (R18cell14 != null) {
				R18cell14.setCellValue(brf59.getR18_trade1() == null ? 0 : brf59.getR18_trade1().intValue());
			}
			Cell R18cell15 = R18row.getCell(17);
			if (R18cell15 != null) {
				R18cell15
						.setCellValue(brf59.getR18_individuals1() == null ? 0 : brf59.getR18_individuals1().intValue());
			}
			Cell R18cell16 = R18row.getCell(18);
			if (R18cell16 != null) {
				R18cell16.setCellValue(brf59.getR18_investment1() == null ? 0 : brf59.getR18_investment1().intValue());
			}
			Cell R18cell17 = R18row.getCell(19);
			if (R18cell17 != null) {
				R18cell17.setCellValue(brf59.getR18_zer0() == null ? 0 : brf59.getR18_zer0().intValue());
			}
			Cell R18cell18 = R18row.getCell(20);
			if (R18cell18 != null) {
				R18cell18.setCellValue(brf59.getR18_three() == null ? 0 : brf59.getR18_three().intValue());
			}
			Cell R18cell19 = R18row.getCell(21);
			if (R18cell19 != null) {
				R18cell19.setCellValue(brf59.getR18_six() == null ? 0 : brf59.getR18_six().intValue());
			}
			Cell R18cell20 = R18row.getCell(22);
			if (R18cell20 != null) {
				R18cell20.setCellValue(brf59.getR18_oneyear() == null ? 0 : brf59.getR18_oneyear().intValue());
			}
			Cell R18cell21 = R18row.getCell(23);
			if (R18cell21 != null) {
				R18cell21.setCellValue(brf59.getR18_foreign() == null ? 0 : brf59.getR18_foreign().intValue());
			}
			Cell R18cell22 = R18row.getCell(24);
			if (R18cell22 != null) {
				R18cell22.setCellValue(brf59.getR18_banks() == null ? 0 : brf59.getR18_banks().intValue());
			}
			Cell R18cell23 = R18row.getCell(25);
			if (R18cell23 != null) {
				R18cell23.setCellValue(brf59.getR18_gov2() == null ? 0 : brf59.getR18_gov2().intValue());
			}
			Cell R18cell24 = R18row.getCell(26);
			if (R18cell24 != null) {
				R18cell24.setCellValue(brf59.getR18_other() == null ? 0 : brf59.getR18_other().intValue());
			}
			Cell R18cell25 = R18row.getCell(27);
			if (R18cell25 != null) {
				R18cell25.setCellValue(brf59.getR18_banks1() == null ? 0 : brf59.getR18_banks1().intValue());
			}
			Cell R18cell26 = R18row.getCell(28);
			if (R18cell26 != null) {
				R18cell26
						.setCellValue(brf59.getR18_individuals2() == null ? 0 : brf59.getR18_individuals2().intValue());
			}
			Cell R18cell27 = R18row.getCell(29);
			if (R18cell27 != null) {
				R18cell27.setCellValue(brf59.getR18_other1() == null ? 0 : brf59.getR18_other1().intValue());
			}
			Cell R18cell28 = R18row.getCell(30);
			if (R18cell28 != null) {
				R18cell28.setCellValue(brf59.getR18_banks2() == null ? 0 : brf59.getR18_banks2().intValue());
			}
			Cell R18cell29 = R18row.getCell(31);
			if (R18cell29 != null) {
				R18cell29.setCellValue(brf59.getR18_gov3() == null ? 0 : brf59.getR18_gov3().intValue());
			}
			Cell R18cell30 = R18row.getCell(32);
			if (R18cell30 != null) {
				R18cell30.setCellValue(brf59.getR18_others2() == null ? 0 : brf59.getR18_others2().intValue());
			}
			Cell R18cell31 = R18row.getCell(33);
			if (R18cell31 != null) {
				R18cell31.setCellValue(brf59.getR18_banks3() == null ? 0 : brf59.getR18_banks3().intValue());
			}
			Cell R18cell32 = R18row.getCell(34);
			if (R18cell32 != null) {
				R18cell32.setCellValue(brf59.getR18_gov4() == null ? 0 : brf59.getR18_gov4().intValue());
			}
			Cell R18cell33 = R18row.getCell(35);
			if (R18cell33 != null) {
				R18cell33.setCellValue(brf59.getR18_others3() == null ? 0 : brf59.getR18_others3().intValue());
			}
			Cell R18cell34 = R18row.getCell(36);
			if (R18cell34 != null) {
				R18cell34.setCellValue(brf59.getR18_foreign1() == null ? 0 : brf59.getR18_foreign1().intValue());
			}
			Cell R18cell35 = R18row.getCell(37);
			if (R18cell35 != null) {
				R18cell35.setCellValue(brf59.getR18_guarantees() == null ? 0 : brf59.getR18_guarantees().intValue());
			}
			Cell R18cell36 = R18row.getCell(38);
			if (R18cell36 != null) {
				R18cell36.setCellValue(brf59.getR18_nbfi2() == null ? 0 : brf59.getR18_nbfi2().intValue());
			}
			Cell R18cell37 = R18row.getCell(39);
			if (R18cell37 != null) {
				R18cell37.setCellValue(brf59.getR18_interbank2() == null ? 0 : brf59.getR18_interbank2().intValue());
			}
			Cell R18cell38 = R18row.getCell(40);
			if (R18cell38 != null) {
				R18cell38.setCellValue(brf59.getR18_gov5() == null ? 0 : brf59.getR18_gov5().intValue());
			}
			Cell R18cell39 = R18row.getCell(41);
			if (R18cell39 != null) {
				R18cell39.setCellValue(brf59.getR18_corporate2() == null ? 0 : brf59.getR18_corporate2().intValue());
			}
			Cell R18cell40 = R18row.getCell(42);
			if (R18cell40 != null) {
				R18cell40.setCellValue(brf59.getR18_gre2() == null ? 0 : brf59.getR18_gre2().intValue());
			}
			Cell R18cell41 = R18row.getCell(43);
			if (R18cell41 != null) {
				R18cell41
						.setCellValue(brf59.getR18_individuals3() == null ? 0 : brf59.getR18_individuals3().intValue());
			}
			Cell R18cell42 = R18row.getCell(44);
			if (R18cell42 != null) {
				R18cell42.setCellValue(brf59.getR18_zero1() == null ? 0 : brf59.getR18_zero1().intValue());
			}
			Cell R18cell43 = R18row.getCell(45);
			if (R18cell43 != null) {
				R18cell43.setCellValue(brf59.getR18_three1() == null ? 0 : brf59.getR18_three1().intValue());
			}
			Cell R18cell44 = R18row.getCell(46);
			if (R18cell44 != null) {
				R18cell44.setCellValue(brf59.getR18_six1() == null ? 0 : brf59.getR18_six1().intValue());
			}
			Cell R18cell45 = R18row.getCell(47);
			if (R18cell45 != null) {
				R18cell45.setCellValue(brf59.getR18_oneyear1() == null ? 0 : brf59.getR18_oneyear1().intValue());
			}
			Cell R18cell46 = R18row.getCell(48);
			if (R18cell46 != null) {
				R18cell46.setCellValue(brf59.getR18_empty() == null ? "" : brf59.getR18_empty().toString());
			}
			Row R19row = sheet.getRow(36);
			Cell R19cell1 = R19row.getCell(3);
			if (R19cell1 != null) {
				R19cell1.setCellValue(brf59.getR19_nbfi() == null ? 0 : brf59.getR19_nbfi().intValue());
			}

			Cell R19cell2 = R19row.getCell(4);
			if (R19cell2 != null) {
				R19cell2.setCellValue(brf59.getR19_interbank() == null ? 0 : brf59.getR19_interbank().intValue());
			}
			Cell R19cell3 = R19row.getCell(5);
			if (R19cell3 != null) {
				R19cell3.setCellValue(brf59.getR19_gov() == null ? 0 : brf59.getR19_gov().intValue());
			}
			Cell R19cell4 = R19row.getCell(6);
			if (R19cell4 != null) {
				R19cell4.setCellValue(brf59.getR19_corporate() == null ? 0 : brf59.getR19_corporate().intValue());
			}
			Cell R19cell5 = R19row.getCell(7);
			if (R19cell5 != null) {
				R19cell5.setCellValue(brf59.getR19_gre() == null ? 0 : brf59.getR19_gre().intValue());
			}
			Cell R19cell6 = R19row.getCell(8);
			if (R19cell6 != null) {
				R19cell6.setCellValue(brf59.getR19_trade() == null ? 0 : brf59.getR19_trade().intValue());
			}
			Cell R19cell7 = R19row.getCell(9);
			if (R19cell7 != null) {
				R19cell7.setCellValue(brf59.getR19_individuals() == null ? 0 : brf59.getR19_individuals().intValue());
			}
			Cell R19cell8 = R19row.getCell(10);
			if (R19cell8 != null) {
				R19cell8.setCellValue(brf59.getR19_investment() == null ? 0 : brf59.getR19_investment().intValue());
			}
			Cell R19cell9 = R19row.getCell(11);
			if (R19cell9 != null) {
				R19cell9.setCellValue(brf59.getR19_nbfi1() == null ? 0 : brf59.getR19_nbfi1().intValue());
			}
			Cell R19cell10 = R19row.getCell(12);
			if (R19cell10 != null) {
				R19cell10.setCellValue(brf59.getR19_interbank1() == null ? 0 : brf59.getR19_interbank1().intValue());
			}
			Cell R19cell11 = R19row.getCell(13);
			if (R19cell11 != null) {
				R19cell11.setCellValue(brf59.getR19_gov1() == null ? 0 : brf59.getR19_gov1().intValue());
			}
			Cell R19cell12 = R19row.getCell(14);
			if (R19cell12 != null) {
				R19cell12.setCellValue(brf59.getR19_corporate1() == null ? 0 : brf59.getR19_corporate1().intValue());
			}
			Cell R19cell13 = R19row.getCell(15);
			if (R19cell13 != null) {
				R19cell13.setCellValue(brf59.getR19_gre1() == null ? 0 : brf59.getR19_gre1().intValue());
			}
			Cell R19cell14 = R19row.getCell(16);
			if (R19cell14 != null) {
				R19cell14.setCellValue(brf59.getR19_trade1() == null ? 0 : brf59.getR19_trade1().intValue());
			}
			Cell R19cell15 = R19row.getCell(17);
			if (R19cell15 != null) {
				R19cell15
						.setCellValue(brf59.getR19_individuals1() == null ? 0 : brf59.getR19_individuals1().intValue());
			}
			Cell R19cell16 = R19row.getCell(18);
			if (R19cell16 != null) {
				R19cell16.setCellValue(brf59.getR19_investment1() == null ? 0 : brf59.getR19_investment1().intValue());
			}
			Cell R19cell17 = R19row.getCell(19);
			if (R19cell17 != null) {
				R19cell17.setCellValue(brf59.getR19_zer0() == null ? 0 : brf59.getR19_zer0().intValue());
			}
			Cell R19cell18 = R19row.getCell(20);
			if (R19cell18 != null) {
				R19cell18.setCellValue(brf59.getR19_three() == null ? 0 : brf59.getR19_three().intValue());
			}
			Cell R19cell19 = R19row.getCell(21);
			if (R19cell19 != null) {
				R19cell19.setCellValue(brf59.getR19_six() == null ? 0 : brf59.getR19_six().intValue());
			}
			Cell R19cell20 = R19row.getCell(22);
			if (R19cell20 != null) {
				R19cell20.setCellValue(brf59.getR19_oneyear() == null ? 0 : brf59.getR19_oneyear().intValue());
			}
			Cell R19cell21 = R19row.getCell(23);
			if (R19cell21 != null) {
				R19cell21.setCellValue(brf59.getR19_foreign() == null ? 0 : brf59.getR19_foreign().intValue());
			}
			Cell R19cell22 = R19row.getCell(24);
			if (R19cell22 != null) {
				R19cell22.setCellValue(brf59.getR19_banks() == null ? 0 : brf59.getR19_banks().intValue());
			}
			Cell R19cell23 = R19row.getCell(25);
			if (R19cell23 != null) {
				R19cell23.setCellValue(brf59.getR19_gov2() == null ? 0 : brf59.getR19_gov2().intValue());
			}
			Cell R19cell24 = R19row.getCell(26);
			if (R19cell24 != null) {
				R19cell24.setCellValue(brf59.getR19_other() == null ? 0 : brf59.getR19_other().intValue());
			}
			Cell R19cell25 = R19row.getCell(27);
			if (R19cell25 != null) {
				R19cell25.setCellValue(brf59.getR19_banks1() == null ? 0 : brf59.getR19_banks1().intValue());
			}
			Cell R19cell26 = R19row.getCell(28);
			if (R19cell26 != null) {
				R19cell26
						.setCellValue(brf59.getR19_individuals2() == null ? 0 : brf59.getR19_individuals2().intValue());
			}
			Cell R19cell27 = R19row.getCell(29);
			if (R19cell27 != null) {
				R19cell27.setCellValue(brf59.getR19_other1() == null ? 0 : brf59.getR19_other1().intValue());
			}
			Cell R19cell28 = R19row.getCell(30);
			if (R19cell28 != null) {
				R19cell28.setCellValue(brf59.getR19_banks2() == null ? 0 : brf59.getR19_banks2().intValue());
			}
			Cell R19cell29 = R19row.getCell(31);
			if (R19cell29 != null) {
				R19cell29.setCellValue(brf59.getR19_gov3() == null ? 0 : brf59.getR19_gov3().intValue());
			}
			Cell R19cell30 = R19row.getCell(32);
			if (R19cell30 != null) {
				R19cell30.setCellValue(brf59.getR19_others2() == null ? 0 : brf59.getR19_others2().intValue());
			}
			Cell R19cell31 = R19row.getCell(33);
			if (R19cell31 != null) {
				R19cell31.setCellValue(brf59.getR19_banks3() == null ? 0 : brf59.getR19_banks3().intValue());
			}
			Cell R19cell32 = R19row.getCell(34);
			if (R19cell32 != null) {
				R19cell32.setCellValue(brf59.getR19_gov4() == null ? 0 : brf59.getR19_gov4().intValue());
			}
			Cell R19cell33 = R19row.getCell(35);
			if (R19cell33 != null) {
				R19cell33.setCellValue(brf59.getR19_others3() == null ? 0 : brf59.getR19_others3().intValue());
			}
			Cell R19cell34 = R19row.getCell(36);
			if (R19cell34 != null) {
				R19cell34.setCellValue(brf59.getR19_foreign1() == null ? 0 : brf59.getR19_foreign1().intValue());
			}
			Cell R19cell35 = R19row.getCell(37);
			if (R19cell35 != null) {
				R19cell35.setCellValue(brf59.getR19_guarantees() == null ? 0 : brf59.getR19_guarantees().intValue());
			}
			Cell R19cell36 = R19row.getCell(38);
			if (R19cell36 != null) {
				R19cell36.setCellValue(brf59.getR19_nbfi2() == null ? 0 : brf59.getR19_nbfi2().intValue());
			}
			Cell R19cell37 = R19row.getCell(39);
			if (R19cell37 != null) {
				R19cell37.setCellValue(brf59.getR19_interbank2() == null ? 0 : brf59.getR19_interbank2().intValue());
			}
			Cell R19cell38 = R19row.getCell(40);
			if (R19cell38 != null) {
				R19cell38.setCellValue(brf59.getR19_gov5() == null ? 0 : brf59.getR19_gov5().intValue());
			}
			Cell R19cell39 = R19row.getCell(41);
			if (R19cell39 != null) {
				R19cell39.setCellValue(brf59.getR19_corporate2() == null ? 0 : brf59.getR19_corporate2().intValue());
			}
			Cell R19cell40 = R19row.getCell(42);
			if (R19cell40 != null) {
				R19cell40.setCellValue(brf59.getR19_gre2() == null ? 0 : brf59.getR19_gre2().intValue());
			}
			Cell R19cell41 = R19row.getCell(43);
			if (R19cell41 != null) {
				R19cell41
						.setCellValue(brf59.getR19_individuals3() == null ? 0 : brf59.getR19_individuals3().intValue());
			}
			Cell R19cell42 = R19row.getCell(44);
			if (R19cell42 != null) {
				R19cell42.setCellValue(brf59.getR19_zero1() == null ? 0 : brf59.getR19_zero1().intValue());
			}
			Cell R19cell43 = R19row.getCell(45);
			if (R19cell43 != null) {
				R19cell43.setCellValue(brf59.getR19_three1() == null ? 0 : brf59.getR19_three1().intValue());
			}
			Cell R19cell44 = R19row.getCell(46);
			if (R19cell44 != null) {
				R19cell44.setCellValue(brf59.getR19_six1() == null ? 0 : brf59.getR19_six1().intValue());
			}
			Cell R19cell45 = R19row.getCell(47);
			if (R19cell45 != null) {
				R19cell45.setCellValue(brf59.getR19_oneyear1() == null ? 0 : brf59.getR19_oneyear1().intValue());
			}
			Cell R19cell46 = R19row.getCell(48);
			if (R19cell46 != null) {
				R19cell46.setCellValue(brf59.getR19_empty() == null ? "" : brf59.getR19_empty().toString());
			}
			Row R20row = sheet.getRow(37);
			Cell R20cell1 = R20row.getCell(3);
			if (R20cell1 != null) {
				R20cell1.setCellValue(brf59.getR20_nbfi() == null ? 0 : brf59.getR20_nbfi().intValue());
			}

			Cell R20cell2 = R20row.getCell(4);
			if (R20cell2 != null) {
				R20cell2.setCellValue(brf59.getR20_interbank() == null ? 0 : brf59.getR20_interbank().intValue());
			}
			Cell R20cell3 = R20row.getCell(5);
			if (R20cell3 != null) {
				R20cell3.setCellValue(brf59.getR20_gov() == null ? 0 : brf59.getR20_gov().intValue());
			}
			Cell R20cell4 = R20row.getCell(6);
			if (R20cell4 != null) {
				R20cell4.setCellValue(brf59.getR20_corporate() == null ? 0 : brf59.getR20_corporate().intValue());
			}
			Cell R20cell5 = R20row.getCell(7);
			if (R20cell5 != null) {
				R20cell5.setCellValue(brf59.getR20_gre() == null ? 0 : brf59.getR20_gre().intValue());
			}
			Cell R20cell6 = R20row.getCell(8);
			if (R20cell6 != null) {
				R20cell6.setCellValue(brf59.getR20_trade() == null ? 0 : brf59.getR20_trade().intValue());
			}
			Cell R20cell7 = R20row.getCell(9);
			if (R20cell7 != null) {
				R20cell7.setCellValue(brf59.getR20_individuals() == null ? 0 : brf59.getR20_individuals().intValue());
			}
			Cell R20cell8 = R20row.getCell(10);
			if (R20cell8 != null) {
				R20cell8.setCellValue(brf59.getR20_investment() == null ? 0 : brf59.getR20_investment().intValue());
			}
			Cell R20cell9 = R20row.getCell(11);
			if (R20cell9 != null) {
				R20cell9.setCellValue(brf59.getR20_nbfi1() == null ? 0 : brf59.getR20_nbfi1().intValue());
			}
			Cell R20cell10 = R20row.getCell(12);
			if (R20cell10 != null) {
				R20cell10.setCellValue(brf59.getR20_interbank1() == null ? 0 : brf59.getR20_interbank1().intValue());
			}
			Cell R20cell11 = R20row.getCell(13);
			if (R20cell11 != null) {
				R20cell11.setCellValue(brf59.getR20_gov1() == null ? 0 : brf59.getR20_gov1().intValue());
			}
			Cell R20cell12 = R20row.getCell(14);
			if (R20cell12 != null) {
				R20cell12.setCellValue(brf59.getR20_corporate1() == null ? 0 : brf59.getR20_corporate1().intValue());
			}
			Cell R20cell13 = R20row.getCell(15);
			if (R20cell13 != null) {
				R20cell13.setCellValue(brf59.getR20_gre1() == null ? 0 : brf59.getR20_gre1().intValue());
			}
			Cell R20cell14 = R20row.getCell(16);
			if (R20cell14 != null) {
				R20cell14.setCellValue(brf59.getR20_trade1() == null ? 0 : brf59.getR20_trade1().intValue());
			}
			Cell R20cell15 = R20row.getCell(17);
			if (R20cell15 != null) {
				R20cell15
						.setCellValue(brf59.getR20_individuals1() == null ? 0 : brf59.getR20_individuals1().intValue());
			}
			Cell R20cell16 = R20row.getCell(18);
			if (R20cell16 != null) {
				R20cell16.setCellValue(brf59.getR20_investment1() == null ? 0 : brf59.getR20_investment1().intValue());
			}
			Cell R20cell17 = R20row.getCell(19);
			if (R20cell17 != null) {
				R20cell17.setCellValue(brf59.getR20_zer0() == null ? 0 : brf59.getR20_zer0().intValue());
			}
			Cell R20cell18 = R20row.getCell(20);
			if (R20cell18 != null) {
				R20cell18.setCellValue(brf59.getR20_three() == null ? 0 : brf59.getR20_three().intValue());
			}
			Cell R20cell19 = R20row.getCell(21);
			if (R20cell19 != null) {
				R20cell19.setCellValue(brf59.getR20_six() == null ? 0 : brf59.getR20_six().intValue());
			}
			Cell R20cell20 = R20row.getCell(22);
			if (R20cell20 != null) {
				R20cell20.setCellValue(brf59.getR20_oneyear() == null ? 0 : brf59.getR20_oneyear().intValue());
			}
			Cell R20cell21 = R20row.getCell(23);
			if (R20cell21 != null) {
				R20cell21.setCellValue(brf59.getR20_foreign() == null ? 0 : brf59.getR20_foreign().intValue());
			}
			Cell R20cell22 = R20row.getCell(24);
			if (R20cell22 != null) {
				R20cell22.setCellValue(brf59.getR20_banks() == null ? 0 : brf59.getR20_banks().intValue());
			}
			Cell R20cell23 = R20row.getCell(25);
			if (R20cell23 != null) {
				R20cell23.setCellValue(brf59.getR20_gov2() == null ? 0 : brf59.getR20_gov2().intValue());
			}
			Cell R20cell24 = R20row.getCell(26);
			if (R20cell24 != null) {
				R20cell24.setCellValue(brf59.getR20_other() == null ? 0 : brf59.getR20_other().intValue());
			}
			Cell R20cell25 = R20row.getCell(27);
			if (R20cell25 != null) {
				R20cell25.setCellValue(brf59.getR20_banks1() == null ? 0 : brf59.getR20_banks1().intValue());
			}
			Cell R20cell26 = R20row.getCell(28);
			if (R20cell26 != null) {
				R20cell26
						.setCellValue(brf59.getR20_individuals2() == null ? 0 : brf59.getR20_individuals2().intValue());
			}
			Cell R20cell27 = R20row.getCell(29);
			if (R20cell27 != null) {
				R20cell27.setCellValue(brf59.getR20_other1() == null ? 0 : brf59.getR20_other1().intValue());
			}
			Cell R20cell28 = R20row.getCell(30);
			if (R20cell28 != null) {
				R20cell28.setCellValue(brf59.getR20_banks2() == null ? 0 : brf59.getR20_banks2().intValue());
			}
			Cell R20cell29 = R20row.getCell(31);
			if (R20cell29 != null) {
				R20cell29.setCellValue(brf59.getR20_gov3() == null ? 0 : brf59.getR20_gov3().intValue());
			}
			Cell R20cell30 = R20row.getCell(32);
			if (R20cell30 != null) {
				R20cell30.setCellValue(brf59.getR20_others2() == null ? 0 : brf59.getR20_others2().intValue());
			}
			Cell R20cell31 = R20row.getCell(33);
			if (R20cell31 != null) {
				R20cell31.setCellValue(brf59.getR20_banks3() == null ? 0 : brf59.getR20_banks3().intValue());
			}
			Cell R20cell32 = R20row.getCell(34);
			if (R20cell32 != null) {
				R20cell32.setCellValue(brf59.getR20_gov4() == null ? 0 : brf59.getR20_gov4().intValue());
			}
			Cell R20cell33 = R20row.getCell(35);
			if (R20cell33 != null) {
				R20cell33.setCellValue(brf59.getR20_others3() == null ? 0 : brf59.getR20_others3().intValue());
			}
			Cell R20cell34 = R20row.getCell(36);
			if (R20cell34 != null) {
				R20cell34.setCellValue(brf59.getR20_foreign1() == null ? 0 : brf59.getR20_foreign1().intValue());
			}
			Cell R20cell35 = R20row.getCell(37);
			if (R20cell35 != null) {
				R20cell35.setCellValue(brf59.getR20_guarantees() == null ? 0 : brf59.getR20_guarantees().intValue());
			}
			Cell R20cell36 = R20row.getCell(38);
			if (R20cell36 != null) {
				R20cell36.setCellValue(brf59.getR20_nbfi2() == null ? 0 : brf59.getR20_nbfi2().intValue());
			}
			Cell R20cell37 = R20row.getCell(39);
			if (R20cell37 != null) {
				R20cell37.setCellValue(brf59.getR20_interbank2() == null ? 0 : brf59.getR20_interbank2().intValue());
			}
			Cell R20cell38 = R20row.getCell(40);
			if (R20cell38 != null) {
				R20cell38.setCellValue(brf59.getR20_gov5() == null ? 0 : brf59.getR20_gov5().intValue());
			}
			Cell R20cell39 = R20row.getCell(41);
			if (R20cell39 != null) {
				R20cell39.setCellValue(brf59.getR20_corporate2() == null ? 0 : brf59.getR20_corporate2().intValue());
			}
			Cell R20cell40 = R20row.getCell(42);
			if (R20cell40 != null) {
				R20cell40.setCellValue(brf59.getR20_gre2() == null ? 0 : brf59.getR20_gre2().intValue());
			}
			Cell R20cell41 = R20row.getCell(43);
			if (R20cell41 != null) {
				R20cell41
						.setCellValue(brf59.getR20_individuals3() == null ? 0 : brf59.getR20_individuals3().intValue());
			}
			Cell R20cell42 = R20row.getCell(44);
			if (R20cell42 != null) {
				R20cell42.setCellValue(brf59.getR20_zero1() == null ? 0 : brf59.getR20_zero1().intValue());
			}
			Cell R20cell43 = R20row.getCell(45);
			if (R20cell43 != null) {
				R20cell43.setCellValue(brf59.getR20_three1() == null ? 0 : brf59.getR20_three1().intValue());
			}
			Cell R20cell44 = R20row.getCell(46);
			if (R20cell44 != null) {
				R20cell44.setCellValue(brf59.getR20_six1() == null ? 0 : brf59.getR20_six1().intValue());
			}
			Cell R20cell45 = R20row.getCell(47);
			if (R20cell45 != null) {
				R20cell45.setCellValue(brf59.getR20_oneyear1() == null ? 0 : brf59.getR20_oneyear1().intValue());
			}
			Cell R20cell46 = R20row.getCell(48);
			if (R20cell46 != null) {
				R20cell46.setCellValue(brf59.getR20_empty() == null ? "" : brf59.getR20_empty().toString());
			}
			Row R21row = sheet.getRow(38);
			Cell R21cell1 = R21row.getCell(3);
			if (R21cell1 != null) {
				R21cell1.setCellValue(brf59.getR21_nbfi() == null ? 0 : brf59.getR21_nbfi().intValue());
			}

			Cell R21cell2 = R21row.getCell(4);
			if (R21cell2 != null) {
				R21cell2.setCellValue(brf59.getR21_interbank() == null ? 0 : brf59.getR21_interbank().intValue());
			}
			Cell R21cell3 = R21row.getCell(5);
			if (R21cell3 != null) {
				R21cell3.setCellValue(brf59.getR21_gov() == null ? 0 : brf59.getR21_gov().intValue());
			}
			Cell R21cell4 = R21row.getCell(6);
			if (R21cell4 != null) {
				R21cell4.setCellValue(brf59.getR21_corporate() == null ? 0 : brf59.getR21_corporate().intValue());
			}
			Cell R21cell5 = R21row.getCell(7);
			if (R21cell5 != null) {
				R21cell5.setCellValue(brf59.getR21_gre() == null ? 0 : brf59.getR21_gre().intValue());
			}
			Cell R21cell6 = R21row.getCell(8);
			if (R21cell6 != null) {
				R21cell6.setCellValue(brf59.getR21_trade() == null ? 0 : brf59.getR21_trade().intValue());
			}
			Cell R21cell7 = R21row.getCell(9);
			if (R21cell7 != null) {
				R21cell7.setCellValue(brf59.getR21_individuals() == null ? 0 : brf59.getR21_individuals().intValue());
			}
			Cell R21cell8 = R21row.getCell(10);
			if (R21cell8 != null) {
				R21cell8.setCellValue(brf59.getR21_investment() == null ? 0 : brf59.getR21_investment().intValue());
			}
			Cell R21cell9 = R21row.getCell(11);
			if (R21cell9 != null) {
				R21cell9.setCellValue(brf59.getR21_nbfi1() == null ? 0 : brf59.getR21_nbfi1().intValue());
			}
			Cell R21cell10 = R21row.getCell(12);
			if (R21cell10 != null) {
				R21cell10.setCellValue(brf59.getR21_interbank1() == null ? 0 : brf59.getR21_interbank1().intValue());
			}
			Cell R21cell11 = R21row.getCell(13);
			if (R21cell11 != null) {
				R21cell11.setCellValue(brf59.getR21_gov1() == null ? 0 : brf59.getR21_gov1().intValue());
			}
			Cell R21cell12 = R21row.getCell(14);
			if (R21cell12 != null) {
				R21cell12.setCellValue(brf59.getR21_corporate1() == null ? 0 : brf59.getR21_corporate1().intValue());
			}
			Cell R21cell13 = R21row.getCell(15);
			if (R21cell13 != null) {
				R21cell13.setCellValue(brf59.getR21_gre1() == null ? 0 : brf59.getR21_gre1().intValue());
			}
			Cell R21cell14 = R21row.getCell(16);
			if (R21cell14 != null) {
				R21cell14.setCellValue(brf59.getR21_trade1() == null ? 0 : brf59.getR21_trade1().intValue());
			}
			Cell R21cell15 = R21row.getCell(17);
			if (R21cell15 != null) {
				R21cell15
						.setCellValue(brf59.getR21_individuals1() == null ? 0 : brf59.getR21_individuals1().intValue());
			}
			Cell R21cell16 = R21row.getCell(18);
			if (R21cell16 != null) {
				R21cell16.setCellValue(brf59.getR21_investment1() == null ? 0 : brf59.getR21_investment1().intValue());
			}
			Cell R21cell17 = R21row.getCell(19);
			if (R21cell17 != null) {
				R21cell17.setCellValue(brf59.getR21_zer0() == null ? 0 : brf59.getR21_zer0().intValue());
			}
			Cell R21cell18 = R21row.getCell(20);
			if (R21cell18 != null) {
				R21cell18.setCellValue(brf59.getR21_three() == null ? 0 : brf59.getR21_three().intValue());
			}
			Cell R21cell19 = R21row.getCell(21);
			if (R21cell19 != null) {
				R21cell19.setCellValue(brf59.getR21_six() == null ? 0 : brf59.getR21_six().intValue());
			}
			Cell R21cell20 = R21row.getCell(22);
			if (R21cell20 != null) {
				R21cell20.setCellValue(brf59.getR21_oneyear() == null ? 0 : brf59.getR21_oneyear().intValue());
			}
			Cell R21cell21 = R21row.getCell(23);
			if (R21cell21 != null) {
				R21cell21.setCellValue(brf59.getR21_foreign() == null ? 0 : brf59.getR21_foreign().intValue());
			}
			Cell R21cell22 = R21row.getCell(24);
			if (R21cell22 != null) {
				R21cell22.setCellValue(brf59.getR21_banks() == null ? 0 : brf59.getR21_banks().intValue());
			}
			Cell R21cell23 = R21row.getCell(25);
			if (R21cell23 != null) {
				R21cell23.setCellValue(brf59.getR21_gov2() == null ? 0 : brf59.getR21_gov2().intValue());
			}
			Cell R21cell24 = R21row.getCell(26);
			if (R21cell24 != null) {
				R21cell24.setCellValue(brf59.getR21_other() == null ? 0 : brf59.getR21_other().intValue());
			}
			Cell R21cell25 = R21row.getCell(27);
			if (R21cell25 != null) {
				R21cell25.setCellValue(brf59.getR21_banks1() == null ? 0 : brf59.getR21_banks1().intValue());
			}
			Cell R21cell26 = R21row.getCell(28);
			if (R21cell26 != null) {
				R21cell26
						.setCellValue(brf59.getR21_individuals2() == null ? 0 : brf59.getR21_individuals2().intValue());
			}
			Cell R21cell27 = R21row.getCell(29);
			if (R21cell27 != null) {
				R21cell27.setCellValue(brf59.getR21_other1() == null ? 0 : brf59.getR21_other1().intValue());
			}
			Cell R21cell28 = R21row.getCell(30);
			if (R21cell28 != null) {
				R21cell28.setCellValue(brf59.getR21_banks2() == null ? 0 : brf59.getR21_banks2().intValue());
			}
			Cell R21cell29 = R21row.getCell(31);
			if (R21cell29 != null) {
				R21cell29.setCellValue(brf59.getR21_gov3() == null ? 0 : brf59.getR21_gov3().intValue());
			}
			Cell R21cell30 = R21row.getCell(32);
			if (R21cell30 != null) {
				R21cell30.setCellValue(brf59.getR21_others2() == null ? 0 : brf59.getR21_others2().intValue());
			}
			Cell R21cell31 = R21row.getCell(33);
			if (R21cell31 != null) {
				R21cell31.setCellValue(brf59.getR21_banks3() == null ? 0 : brf59.getR21_banks3().intValue());
			}
			Cell R21cell32 = R21row.getCell(34);
			if (R21cell32 != null) {
				R21cell32.setCellValue(brf59.getR21_gov4() == null ? 0 : brf59.getR21_gov4().intValue());
			}
			Cell R21cell33 = R21row.getCell(35);
			if (R21cell33 != null) {
				R21cell33.setCellValue(brf59.getR21_others3() == null ? 0 : brf59.getR21_others3().intValue());
			}
			Cell R21cell34 = R21row.getCell(36);
			if (R21cell34 != null) {
				R21cell34.setCellValue(brf59.getR21_foreign1() == null ? 0 : brf59.getR21_foreign1().intValue());
			}
			Cell R21cell35 = R21row.getCell(37);
			if (R21cell35 != null) {
				R21cell35.setCellValue(brf59.getR21_guarantees() == null ? 0 : brf59.getR21_guarantees().intValue());
			}
			Cell R21cell36 = R21row.getCell(38);
			if (R21cell36 != null) {
				R21cell36.setCellValue(brf59.getR21_nbfi2() == null ? 0 : brf59.getR21_nbfi2().intValue());
			}
			Cell R21cell37 = R21row.getCell(39);
			if (R21cell37 != null) {
				R21cell37.setCellValue(brf59.getR21_interbank2() == null ? 0 : brf59.getR21_interbank2().intValue());
			}
			Cell R21cell38 = R21row.getCell(40);
			if (R21cell38 != null) {
				R21cell38.setCellValue(brf59.getR21_gov5() == null ? 0 : brf59.getR21_gov5().intValue());
			}
			Cell R21cell39 = R21row.getCell(41);
			if (R21cell39 != null) {
				R21cell39.setCellValue(brf59.getR21_corporate2() == null ? 0 : brf59.getR21_corporate2().intValue());
			}
			Cell R21cell40 = R21row.getCell(42);
			if (R21cell40 != null) {
				R21cell40.setCellValue(brf59.getR21_gre2() == null ? 0 : brf59.getR21_gre2().intValue());
			}
			Cell R21cell41 = R21row.getCell(43);
			if (R21cell41 != null) {
				R21cell41
						.setCellValue(brf59.getR21_individuals3() == null ? 0 : brf59.getR21_individuals3().intValue());
			}
			Cell R21cell42 = R21row.getCell(44);
			if (R21cell42 != null) {
				R21cell42.setCellValue(brf59.getR21_zero1() == null ? 0 : brf59.getR21_zero1().intValue());
			}
			Cell R21cell43 = R21row.getCell(45);
			if (R21cell43 != null) {
				R21cell43.setCellValue(brf59.getR21_three1() == null ? 0 : brf59.getR21_three1().intValue());
			}
			Cell R21cell44 = R21row.getCell(46);
			if (R21cell44 != null) {
				R21cell44.setCellValue(brf59.getR21_six1() == null ? 0 : brf59.getR21_six1().intValue());
			}
			Cell R21cell45 = R21row.getCell(47);
			if (R21cell45 != null) {
				R21cell45.setCellValue(brf59.getR21_oneyear1() == null ? 0 : brf59.getR21_oneyear1().intValue());
			}
			Cell R21cell46 = R21row.getCell(48);
			if (R21cell46 != null) {
				R21cell46.setCellValue(brf59.getR21_empty() == null ? "" : brf59.getR21_empty().toString());
			}
		}
	}

	public void updateSheetWithEntity2Data(Sheet sheet, List<BRF59B_ENTITY> BRF59B_ENTITY) {
		if (BRF59B_ENTITY.size() == 1) {
			BRF59B_ENTITY brf59a = BRF59B_ENTITY.get(0);
			Row R22row = sheet.getRow(39);
			Cell R22cell1 = R22row.getCell(3);
			if (R22cell1 != null) {
				R22cell1.setCellValue(brf59a.getR22_nbfi() == null ? 0 : brf59a.getR22_nbfi().intValue());
			}

			Cell R22cell2 = R22row.getCell(4);
			if (R22cell2 != null) {
				R22cell2.setCellValue(brf59a.getR22_interbank() == null ? 0 : brf59a.getR22_interbank().intValue());
			}
			Cell R22cell3 = R22row.getCell(5);
			if (R22cell3 != null) {
				R22cell3.setCellValue(brf59a.getR22_gov() == null ? 0 : brf59a.getR22_gov().intValue());
			}
			Cell R22cell4 = R22row.getCell(6);
			if (R22cell4 != null) {
				R22cell4.setCellValue(brf59a.getR22_corporate() == null ? 0 : brf59a.getR22_corporate().intValue());
			}
			Cell R22cell5 = R22row.getCell(7);
			if (R22cell5 != null) {
				R22cell5.setCellValue(brf59a.getR22_gre() == null ? 0 : brf59a.getR22_gre().intValue());
			}
			Cell R22cell6 = R22row.getCell(8);
			if (R22cell6 != null) {
				R22cell6.setCellValue(brf59a.getR22_trade() == null ? 0 : brf59a.getR22_trade().intValue());
			}
			Cell R22cell7 = R22row.getCell(9);
			if (R22cell7 != null) {
				R22cell7.setCellValue(brf59a.getR22_individuals() == null ? 0 : brf59a.getR22_individuals().intValue());
			}
			Cell R22cell8 = R22row.getCell(10);
			if (R22cell8 != null) {
				R22cell8.setCellValue(brf59a.getR22_investment() == null ? 0 : brf59a.getR22_investment().intValue());
			}
			Cell R22cell9 = R22row.getCell(11);
			if (R22cell9 != null) {
				R22cell9.setCellValue(brf59a.getR22_nbfi1() == null ? 0 : brf59a.getR22_nbfi1().intValue());
			}
			Cell R22cell10 = R22row.getCell(12);
			if (R22cell10 != null) {
				R22cell10.setCellValue(brf59a.getR22_interbank1() == null ? 0 : brf59a.getR22_interbank1().intValue());
			}
			Cell R22cell11 = R22row.getCell(13);
			if (R22cell11 != null) {
				R22cell11.setCellValue(brf59a.getR22_gov1() == null ? 0 : brf59a.getR22_gov1().intValue());
			}
			Cell R22cell12 = R22row.getCell(14);
			if (R22cell12 != null) {
				R22cell12.setCellValue(brf59a.getR22_corporate1() == null ? 0 : brf59a.getR22_corporate1().intValue());
			}
			Cell R22cell13 = R22row.getCell(15);
			if (R22cell13 != null) {
				R22cell13.setCellValue(brf59a.getR22_gre1() == null ? 0 : brf59a.getR22_gre1().intValue());
			}
			Cell R22cell14 = R22row.getCell(16);
			if (R22cell14 != null) {
				R22cell14.setCellValue(brf59a.getR22_trade1() == null ? 0 : brf59a.getR22_trade1().intValue());
			}
			Cell R22cell15 = R22row.getCell(17);
			if (R22cell15 != null) {
				R22cell15.setCellValue(
						brf59a.getR22_individuals1() == null ? 0 : brf59a.getR22_individuals1().intValue());
			}
			Cell R22cell16 = R22row.getCell(18);
			if (R22cell16 != null) {
				R22cell16
						.setCellValue(brf59a.getR22_investment1() == null ? 0 : brf59a.getR22_investment1().intValue());
			}
			Cell R22cell17 = R22row.getCell(19);
			if (R22cell17 != null) {
				R22cell17.setCellValue(brf59a.getR22_zer0() == null ? 0 : brf59a.getR22_zer0().intValue());
			}
			Cell R22cell18 = R22row.getCell(20);
			if (R22cell18 != null) {
				R22cell18.setCellValue(brf59a.getR22_three() == null ? 0 : brf59a.getR22_three().intValue());
			}
			Cell R22cell19 = R22row.getCell(21);
			if (R22cell19 != null) {
				R22cell19.setCellValue(brf59a.getR22_six() == null ? 0 : brf59a.getR22_six().intValue());
			}
			Cell R22cell20 = R22row.getCell(22);
			if (R22cell20 != null) {
				R22cell20.setCellValue(brf59a.getR22_oneyear() == null ? 0 : brf59a.getR22_oneyear().intValue());
			}
			Cell R22cell21 = R22row.getCell(23);
			if (R22cell21 != null) {
				R22cell21.setCellValue(brf59a.getR22_foreign() == null ? 0 : brf59a.getR22_foreign().intValue());
			}
			Cell R22cell22 = R22row.getCell(24);
			if (R22cell22 != null) {
				R22cell22.setCellValue(brf59a.getR22_banks() == null ? 0 : brf59a.getR22_banks().intValue());
			}
			Cell R22cell23 = R22row.getCell(25);
			if (R22cell23 != null) {
				R22cell23.setCellValue(brf59a.getR22_gov2() == null ? 0 : brf59a.getR22_gov2().intValue());
			}
			Cell R22cell24 = R22row.getCell(26);
			if (R22cell24 != null) {
				R22cell24.setCellValue(brf59a.getR22_other() == null ? 0 : brf59a.getR22_other().intValue());
			}
			Cell R22cell25 = R22row.getCell(27);
			if (R22cell25 != null) {
				R22cell25.setCellValue(brf59a.getR22_banks1() == null ? 0 : brf59a.getR22_banks1().intValue());
			}
			Cell R22cell26 = R22row.getCell(28);
			if (R22cell26 != null) {
				R22cell26.setCellValue(
						brf59a.getR22_individuals2() == null ? 0 : brf59a.getR22_individuals2().intValue());
			}
			Cell R22cell27 = R22row.getCell(29);
			if (R22cell27 != null) {
				R22cell27.setCellValue(brf59a.getR22_other1() == null ? 0 : brf59a.getR22_other1().intValue());
			}
			Cell R22cell28 = R22row.getCell(30);
			if (R22cell28 != null) {
				R22cell28.setCellValue(brf59a.getR22_banks2() == null ? 0 : brf59a.getR22_banks2().intValue());
			}
			Cell R22cell29 = R22row.getCell(31);
			if (R22cell29 != null) {
				R22cell29.setCellValue(brf59a.getR22_gov3() == null ? 0 : brf59a.getR22_gov3().intValue());
			}
			Cell R22cell30 = R22row.getCell(32);
			if (R22cell30 != null) {
				R22cell30.setCellValue(brf59a.getR22_others2() == null ? 0 : brf59a.getR22_others2().intValue());
			}
			Cell R22cell31 = R22row.getCell(33);
			if (R22cell31 != null) {
				R22cell31.setCellValue(brf59a.getR22_banks3() == null ? 0 : brf59a.getR22_banks3().intValue());
			}
			Cell R22cell32 = R22row.getCell(34);
			if (R22cell32 != null) {
				R22cell32.setCellValue(brf59a.getR22_gov4() == null ? 0 : brf59a.getR22_gov4().intValue());
			}
			Cell R22cell33 = R22row.getCell(35);
			if (R22cell33 != null) {
				R22cell33.setCellValue(brf59a.getR22_others3() == null ? 0 : brf59a.getR22_others3().intValue());
			}
			Cell R22cell34 = R22row.getCell(36);
			if (R22cell34 != null) {
				R22cell34.setCellValue(brf59a.getR22_foreign1() == null ? 0 : brf59a.getR22_foreign1().intValue());
			}
			Cell R22cell35 = R22row.getCell(37);
			if (R22cell35 != null) {
				R22cell35.setCellValue(brf59a.getR22_guarantees() == null ? 0 : brf59a.getR22_guarantees().intValue());
			}
			Cell R22cell36 = R22row.getCell(38);
			if (R22cell36 != null) {
				R22cell36.setCellValue(brf59a.getR22_nbfi2() == null ? 0 : brf59a.getR22_nbfi2().intValue());
			}
			Cell R22cell37 = R22row.getCell(39);
			if (R22cell37 != null) {
				R22cell37.setCellValue(brf59a.getR22_interbank2() == null ? 0 : brf59a.getR22_interbank2().intValue());
			}
			Cell R22cell38 = R22row.getCell(40);
			if (R22cell38 != null) {
				R22cell38.setCellValue(brf59a.getR22_gov5() == null ? 0 : brf59a.getR22_gov5().intValue());
			}
			Cell R22cell39 = R22row.getCell(41);
			if (R22cell39 != null) {
				R22cell39.setCellValue(brf59a.getR22_corporate2() == null ? 0 : brf59a.getR22_corporate2().intValue());
			}
			Cell R22cell40 = R22row.getCell(42);
			if (R22cell40 != null) {
				R22cell40.setCellValue(brf59a.getR22_gre2() == null ? 0 : brf59a.getR22_gre2().intValue());
			}
			Cell R22cell41 = R22row.getCell(43);
			if (R22cell41 != null) {
				R22cell41.setCellValue(
						brf59a.getR22_individuals3() == null ? 0 : brf59a.getR22_individuals3().intValue());
			}
			Cell R22cell42 = R22row.getCell(44);
			if (R22cell42 != null) {
				R22cell42.setCellValue(brf59a.getR22_zero1() == null ? 0 : brf59a.getR22_zero1().intValue());
			}
			Cell R22cell43 = R22row.getCell(45);
			if (R22cell43 != null) {
				R22cell43.setCellValue(brf59a.getR22_three1() == null ? 0 : brf59a.getR22_three1().intValue());
			}
			Cell R22cell44 = R22row.getCell(46);
			if (R22cell44 != null) {
				R22cell44.setCellValue(brf59a.getR22_six1() == null ? 0 : brf59a.getR22_six1().intValue());
			}
			Cell R22cell45 = R22row.getCell(47);
			if (R22cell45 != null) {
				R22cell45.setCellValue(brf59a.getR22_oneyear1() == null ? 0 : brf59a.getR22_oneyear1().intValue());
			}
			Cell R22cell46 = R22row.getCell(48);
			if (R22cell46 != null) {
				R22cell46.setCellValue(brf59a.getR22_empty() == null ? "" : brf59a.getR22_empty().toString());
			}
			Row R23row = sheet.getRow(40);
			Cell R23cell1 = R23row.getCell(3);
			if (R23cell1 != null) {
				R23cell1.setCellValue(brf59a.getR23_nbfi() == null ? 0 : brf59a.getR23_nbfi().intValue());
			}

			Cell R23cell2 = R23row.getCell(4);
			if (R23cell2 != null) {
				R23cell2.setCellValue(brf59a.getR23_interbank() == null ? 0 : brf59a.getR23_interbank().intValue());
			}
			Cell R23cell3 = R23row.getCell(5);
			if (R23cell3 != null) {
				R23cell3.setCellValue(brf59a.getR23_gov() == null ? 0 : brf59a.getR23_gov().intValue());
			}
			Cell R23cell4 = R23row.getCell(6);
			if (R23cell4 != null) {
				R23cell4.setCellValue(brf59a.getR23_corporate() == null ? 0 : brf59a.getR23_corporate().intValue());
			}
			Cell R23cell5 = R23row.getCell(7);
			if (R23cell5 != null) {
				R23cell5.setCellValue(brf59a.getR23_gre() == null ? 0 : brf59a.getR23_gre().intValue());
			}
			Cell R23cell6 = R23row.getCell(8);
			if (R23cell6 != null) {
				R23cell6.setCellValue(brf59a.getR23_trade() == null ? 0 : brf59a.getR23_trade().intValue());
			}
			Cell R23cell7 = R23row.getCell(9);
			if (R23cell7 != null) {
				R23cell7.setCellValue(brf59a.getR23_individuals() == null ? 0 : brf59a.getR23_individuals().intValue());
			}
			Cell R23cell8 = R23row.getCell(10);
			if (R23cell8 != null) {
				R23cell8.setCellValue(brf59a.getR23_investment() == null ? 0 : brf59a.getR23_investment().intValue());
			}
			Cell R23cell9 = R23row.getCell(11);
			if (R23cell9 != null) {
				R23cell9.setCellValue(brf59a.getR23_nbfi1() == null ? 0 : brf59a.getR23_nbfi1().intValue());
			}
			Cell R23cell10 = R23row.getCell(12);
			if (R23cell10 != null) {
				R23cell10.setCellValue(brf59a.getR23_interbank1() == null ? 0 : brf59a.getR23_interbank1().intValue());
			}
			Cell R23cell11 = R23row.getCell(13);
			if (R23cell11 != null) {
				R23cell11.setCellValue(brf59a.getR23_gov1() == null ? 0 : brf59a.getR23_gov1().intValue());
			}
			Cell R23cell12 = R23row.getCell(14);
			if (R23cell12 != null) {
				R23cell12.setCellValue(brf59a.getR23_corporate1() == null ? 0 : brf59a.getR23_corporate1().intValue());
			}
			Cell R23cell13 = R23row.getCell(15);
			if (R23cell13 != null) {
				R23cell13.setCellValue(brf59a.getR23_gre1() == null ? 0 : brf59a.getR23_gre1().intValue());
			}
			Cell R23cell14 = R23row.getCell(16);
			if (R23cell14 != null) {
				R23cell14.setCellValue(brf59a.getR23_trade1() == null ? 0 : brf59a.getR23_trade1().intValue());
			}
			Cell R23cell15 = R23row.getCell(17);
			if (R23cell15 != null) {
				R23cell15.setCellValue(
						brf59a.getR23_individuals1() == null ? 0 : brf59a.getR23_individuals1().intValue());
			}
			Cell R23cell16 = R23row.getCell(18);
			if (R23cell16 != null) {
				R23cell16
						.setCellValue(brf59a.getR23_investment1() == null ? 0 : brf59a.getR23_investment1().intValue());
			}
			Cell R23cell17 = R23row.getCell(19);
			if (R23cell17 != null) {
				R23cell17.setCellValue(brf59a.getR23_zer0() == null ? 0 : brf59a.getR23_zer0().intValue());
			}
			Cell R23cell18 = R23row.getCell(20);
			if (R23cell18 != null) {
				R23cell18.setCellValue(brf59a.getR23_three() == null ? 0 : brf59a.getR23_three().intValue());
			}
			Cell R23cell19 = R23row.getCell(21);
			if (R23cell19 != null) {
				R23cell19.setCellValue(brf59a.getR23_six() == null ? 0 : brf59a.getR23_six().intValue());
			}
			Cell R23cell20 = R23row.getCell(22);
			if (R23cell20 != null) {
				R23cell20.setCellValue(brf59a.getR23_oneyear() == null ? 0 : brf59a.getR23_oneyear().intValue());
			}
			Cell R23cell21 = R23row.getCell(23);
			if (R23cell21 != null) {
				R23cell21.setCellValue(brf59a.getR23_foreign() == null ? 0 : brf59a.getR23_foreign().intValue());
			}
			Cell R23cell22 = R23row.getCell(24);
			if (R23cell22 != null) {
				R23cell22.setCellValue(brf59a.getR23_banks() == null ? 0 : brf59a.getR23_banks().intValue());
			}
			Cell R23cell23 = R23row.getCell(25);
			if (R23cell23 != null) {
				R23cell23.setCellValue(brf59a.getR23_gov2() == null ? 0 : brf59a.getR23_gov2().intValue());
			}
			Cell R23cell24 = R23row.getCell(26);
			if (R23cell24 != null) {
				R23cell24.setCellValue(brf59a.getR23_other() == null ? 0 : brf59a.getR23_other().intValue());
			}
			Cell R23cell25 = R23row.getCell(27);
			if (R23cell25 != null) {
				R23cell25.setCellValue(brf59a.getR23_banks1() == null ? 0 : brf59a.getR23_banks1().intValue());
			}
			Cell R23cell26 = R23row.getCell(28);
			if (R23cell26 != null) {
				R23cell26.setCellValue(
						brf59a.getR23_individuals2() == null ? 0 : brf59a.getR23_individuals2().intValue());
			}
			Cell R23cell27 = R23row.getCell(29);
			if (R23cell27 != null) {
				R23cell27.setCellValue(brf59a.getR23_other1() == null ? 0 : brf59a.getR23_other1().intValue());
			}
			Cell R23cell28 = R23row.getCell(30);
			if (R23cell28 != null) {
				R23cell28.setCellValue(brf59a.getR23_banks2() == null ? 0 : brf59a.getR23_banks2().intValue());
			}
			Cell R23cell29 = R23row.getCell(31);
			if (R23cell29 != null) {
				R23cell29.setCellValue(brf59a.getR23_gov3() == null ? 0 : brf59a.getR23_gov3().intValue());
			}
			Cell R23cell30 = R23row.getCell(32);
			if (R23cell30 != null) {
				R23cell30.setCellValue(brf59a.getR23_others2() == null ? 0 : brf59a.getR23_others2().intValue());
			}
			Cell R23cell31 = R23row.getCell(33);
			if (R23cell31 != null) {
				R23cell31.setCellValue(brf59a.getR23_banks3() == null ? 0 : brf59a.getR23_banks3().intValue());
			}
			Cell R23cell32 = R23row.getCell(34);
			if (R23cell32 != null) {
				R23cell32.setCellValue(brf59a.getR23_gov4() == null ? 0 : brf59a.getR23_gov4().intValue());
			}
			Cell R23cell33 = R23row.getCell(35);
			if (R23cell33 != null) {
				R23cell33.setCellValue(brf59a.getR23_others3() == null ? 0 : brf59a.getR23_others3().intValue());
			}
			Cell R23cell34 = R23row.getCell(36);
			if (R23cell34 != null) {
				R23cell34.setCellValue(brf59a.getR23_foreign1() == null ? 0 : brf59a.getR23_foreign1().intValue());
			}
			Cell R23cell35 = R23row.getCell(37);
			if (R23cell35 != null) {
				R23cell35.setCellValue(brf59a.getR23_guarantees() == null ? 0 : brf59a.getR23_guarantees().intValue());
			}
			Cell R23cell36 = R23row.getCell(38);
			if (R23cell36 != null) {
				R23cell36.setCellValue(brf59a.getR23_nbfi2() == null ? 0 : brf59a.getR23_nbfi2().intValue());
			}
			Cell R23cell37 = R23row.getCell(39);
			if (R23cell37 != null) {
				R23cell37.setCellValue(brf59a.getR23_interbank2() == null ? 0 : brf59a.getR23_interbank2().intValue());
			}
			Cell R23cell38 = R23row.getCell(40);
			if (R23cell38 != null) {
				R23cell38.setCellValue(brf59a.getR23_gov5() == null ? 0 : brf59a.getR23_gov5().intValue());
			}
			Cell R23cell39 = R23row.getCell(41);
			if (R23cell39 != null) {
				R23cell39.setCellValue(brf59a.getR23_corporate2() == null ? 0 : brf59a.getR23_corporate2().intValue());
			}
			Cell R23cell40 = R23row.getCell(42);
			if (R23cell40 != null) {
				R23cell40.setCellValue(brf59a.getR23_gre2() == null ? 0 : brf59a.getR23_gre2().intValue());
			}
			Cell R23cell41 = R23row.getCell(43);
			if (R23cell41 != null) {
				R23cell41.setCellValue(
						brf59a.getR23_individuals3() == null ? 0 : brf59a.getR23_individuals3().intValue());
			}
			Cell R23cell42 = R23row.getCell(44);
			if (R23cell42 != null) {
				R23cell42.setCellValue(brf59a.getR23_zero1() == null ? 0 : brf59a.getR23_zero1().intValue());
			}
			Cell R23cell43 = R23row.getCell(45);
			if (R23cell43 != null) {
				R23cell43.setCellValue(brf59a.getR23_three1() == null ? 0 : brf59a.getR23_three1().intValue());
			}
			Cell R23cell44 = R23row.getCell(46);
			if (R23cell44 != null) {
				R23cell44.setCellValue(brf59a.getR23_six1() == null ? 0 : brf59a.getR23_six1().intValue());
			}
			Cell R23cell45 = R23row.getCell(47);
			if (R23cell45 != null) {
				R23cell45.setCellValue(brf59a.getR23_oneyear1() == null ? 0 : brf59a.getR23_oneyear1().intValue());
			}
			Cell R23cell46 = R23row.getCell(48);
			if (R23cell46 != null) {
				R23cell46.setCellValue(brf59a.getR23_empty() == null ? "" : brf59a.getR23_empty().toString());
			}
			Row R24row = sheet.getRow(41);
			Cell R24cell1 = R24row.getCell(3);
			if (R24cell1 != null) {
				R24cell1.setCellValue(brf59a.getR24_nbfi() == null ? 0 : brf59a.getR24_nbfi().intValue());
			}

			Cell R24cell2 = R24row.getCell(4);
			if (R24cell2 != null) {
				R24cell2.setCellValue(brf59a.getR24_interbank() == null ? 0 : brf59a.getR24_interbank().intValue());
			}
			Cell R24cell3 = R24row.getCell(5);
			if (R24cell3 != null) {
				R24cell3.setCellValue(brf59a.getR24_gov() == null ? 0 : brf59a.getR24_gov().intValue());
			}
			Cell R24cell4 = R24row.getCell(6);
			if (R24cell4 != null) {
				R24cell4.setCellValue(brf59a.getR24_corporate() == null ? 0 : brf59a.getR24_corporate().intValue());
			}
			Cell R24cell5 = R24row.getCell(7);
			if (R24cell5 != null) {
				R24cell5.setCellValue(brf59a.getR24_gre() == null ? 0 : brf59a.getR24_gre().intValue());
			}
			Cell R24cell6 = R24row.getCell(8);
			if (R24cell6 != null) {
				R24cell6.setCellValue(brf59a.getR24_trade() == null ? 0 : brf59a.getR24_trade().intValue());
			}
			Cell R24cell7 = R24row.getCell(9);
			if (R24cell7 != null) {
				R24cell7.setCellValue(brf59a.getR24_individuals() == null ? 0 : brf59a.getR24_individuals().intValue());
			}
			Cell R24cell8 = R24row.getCell(10);
			if (R24cell8 != null) {
				R24cell8.setCellValue(brf59a.getR24_investment() == null ? 0 : brf59a.getR24_investment().intValue());
			}
			Cell R24cell9 = R24row.getCell(11);
			if (R24cell9 != null) {
				R24cell9.setCellValue(brf59a.getR24_nbfi1() == null ? 0 : brf59a.getR24_nbfi1().intValue());
			}
			Cell R24cell10 = R24row.getCell(12);
			if (R24cell10 != null) {
				R24cell10.setCellValue(brf59a.getR24_interbank1() == null ? 0 : brf59a.getR24_interbank1().intValue());
			}
			Cell R24cell11 = R24row.getCell(13);
			if (R24cell11 != null) {
				R24cell11.setCellValue(brf59a.getR24_gov1() == null ? 0 : brf59a.getR24_gov1().intValue());
			}
			Cell R24cell12 = R24row.getCell(14);
			if (R24cell12 != null) {
				R24cell12.setCellValue(brf59a.getR24_corporate1() == null ? 0 : brf59a.getR24_corporate1().intValue());
			}
			Cell R24cell13 = R24row.getCell(15);
			if (R24cell13 != null) {
				R24cell13.setCellValue(brf59a.getR24_gre1() == null ? 0 : brf59a.getR24_gre1().intValue());
			}
			Cell R24cell14 = R24row.getCell(16);
			if (R24cell14 != null) {
				R24cell14.setCellValue(brf59a.getR24_trade1() == null ? 0 : brf59a.getR24_trade1().intValue());
			}
			Cell R24cell15 = R24row.getCell(17);
			if (R24cell15 != null) {
				R24cell15.setCellValue(
						brf59a.getR24_individuals1() == null ? 0 : brf59a.getR24_individuals1().intValue());
			}
			Cell R24cell16 = R24row.getCell(18);
			if (R24cell16 != null) {
				R24cell16
						.setCellValue(brf59a.getR24_investment1() == null ? 0 : brf59a.getR24_investment1().intValue());
			}
			Cell R24cell17 = R24row.getCell(19);
			if (R24cell17 != null) {
				R24cell17.setCellValue(brf59a.getR24_zer0() == null ? 0 : brf59a.getR24_zer0().intValue());
			}
			Cell R24cell18 = R24row.getCell(20);
			if (R24cell18 != null) {
				R24cell18.setCellValue(brf59a.getR24_three() == null ? 0 : brf59a.getR24_three().intValue());
			}
			Cell R24cell19 = R24row.getCell(21);
			if (R24cell19 != null) {
				R24cell19.setCellValue(brf59a.getR24_six() == null ? 0 : brf59a.getR24_six().intValue());
			}
			Cell R24cell20 = R24row.getCell(22);
			if (R24cell20 != null) {
				R24cell20.setCellValue(brf59a.getR24_oneyear() == null ? 0 : brf59a.getR24_oneyear().intValue());
			}
			Cell R24cell21 = R24row.getCell(23);
			if (R24cell21 != null) {
				R24cell21.setCellValue(brf59a.getR24_foreign() == null ? 0 : brf59a.getR24_foreign().intValue());
			}
			Cell R24cell22 = R24row.getCell(24);
			if (R24cell22 != null) {
				R24cell22.setCellValue(brf59a.getR24_banks() == null ? 0 : brf59a.getR24_banks().intValue());
			}
			Cell R24cell23 = R24row.getCell(25);
			if (R24cell23 != null) {
				R24cell23.setCellValue(brf59a.getR24_gov2() == null ? 0 : brf59a.getR24_gov2().intValue());
			}
			Cell R24cell24 = R24row.getCell(26);
			if (R24cell24 != null) {
				R24cell24.setCellValue(brf59a.getR24_other() == null ? 0 : brf59a.getR24_other().intValue());
			}
			Cell R24cell25 = R24row.getCell(27);
			if (R24cell25 != null) {
				R24cell25.setCellValue(brf59a.getR24_banks1() == null ? 0 : brf59a.getR24_banks1().intValue());
			}
			Cell R24cell26 = R24row.getCell(28);
			if (R24cell26 != null) {
				R24cell26.setCellValue(
						brf59a.getR24_individuals2() == null ? 0 : brf59a.getR24_individuals2().intValue());
			}
			Cell R24cell27 = R24row.getCell(29);
			if (R24cell27 != null) {
				R24cell27.setCellValue(brf59a.getR24_other1() == null ? 0 : brf59a.getR24_other1().intValue());
			}
			Cell R24cell28 = R24row.getCell(30);
			if (R24cell28 != null) {
				R24cell28.setCellValue(brf59a.getR24_banks2() == null ? 0 : brf59a.getR24_banks2().intValue());
			}
			Cell R24cell29 = R24row.getCell(31);
			if (R24cell29 != null) {
				R24cell29.setCellValue(brf59a.getR24_gov3() == null ? 0 : brf59a.getR24_gov3().intValue());
			}
			Cell R24cell30 = R24row.getCell(32);
			if (R24cell30 != null) {
				R24cell30.setCellValue(brf59a.getR24_others2() == null ? 0 : brf59a.getR24_others2().intValue());
			}
			Cell R24cell31 = R24row.getCell(33);
			if (R24cell31 != null) {
				R24cell31.setCellValue(brf59a.getR24_banks3() == null ? 0 : brf59a.getR24_banks3().intValue());
			}
			Cell R24cell32 = R24row.getCell(34);
			if (R24cell32 != null) {
				R24cell32.setCellValue(brf59a.getR24_gov4() == null ? 0 : brf59a.getR24_gov4().intValue());
			}
			Cell R24cell33 = R24row.getCell(35);
			if (R24cell33 != null) {
				R24cell33.setCellValue(brf59a.getR24_others3() == null ? 0 : brf59a.getR24_others3().intValue());
			}
			Cell R24cell34 = R24row.getCell(36);
			if (R24cell34 != null) {
				R24cell34.setCellValue(brf59a.getR24_foreign1() == null ? 0 : brf59a.getR24_foreign1().intValue());
			}
			Cell R24cell35 = R24row.getCell(37);
			if (R24cell35 != null) {
				R24cell35.setCellValue(brf59a.getR24_guarantees() == null ? 0 : brf59a.getR24_guarantees().intValue());
			}
			Cell R24cell36 = R24row.getCell(38);
			if (R24cell36 != null) {
				R24cell36.setCellValue(brf59a.getR24_nbfi2() == null ? 0 : brf59a.getR24_nbfi2().intValue());
			}
			Cell R24cell37 = R24row.getCell(39);
			if (R24cell37 != null) {
				R24cell37.setCellValue(brf59a.getR24_interbank2() == null ? 0 : brf59a.getR24_interbank2().intValue());
			}
			Cell R24cell38 = R24row.getCell(40);
			if (R24cell38 != null) {
				R24cell38.setCellValue(brf59a.getR24_gov5() == null ? 0 : brf59a.getR24_gov5().intValue());
			}
			Cell R24cell39 = R24row.getCell(41);
			if (R24cell39 != null) {
				R24cell39.setCellValue(brf59a.getR24_corporate2() == null ? 0 : brf59a.getR24_corporate2().intValue());
			}
			Cell R24cell40 = R24row.getCell(42);
			if (R24cell40 != null) {
				R24cell40.setCellValue(brf59a.getR24_gre2() == null ? 0 : brf59a.getR24_gre2().intValue());
			}
			Cell R24cell41 = R24row.getCell(43);
			if (R24cell41 != null) {
				R24cell41.setCellValue(
						brf59a.getR24_individuals3() == null ? 0 : brf59a.getR24_individuals3().intValue());
			}
			Cell R24cell42 = R24row.getCell(44);
			if (R24cell42 != null) {
				R24cell42.setCellValue(brf59a.getR24_zero1() == null ? 0 : brf59a.getR24_zero1().intValue());
			}
			Cell R24cell43 = R24row.getCell(45);
			if (R24cell43 != null) {
				R24cell43.setCellValue(brf59a.getR24_three1() == null ? 0 : brf59a.getR24_three1().intValue());
			}
			Cell R24cell44 = R24row.getCell(46);
			if (R24cell44 != null) {
				R24cell44.setCellValue(brf59a.getR24_six1() == null ? 0 : brf59a.getR24_six1().intValue());
			}
			Cell R24cell45 = R24row.getCell(47);
			if (R24cell45 != null) {
				R24cell45.setCellValue(brf59a.getR24_oneyear1() == null ? 0 : brf59a.getR24_oneyear1().intValue());
			}
			Cell R24cell46 = R24row.getCell(48);
			if (R24cell46 != null) {
				R24cell46.setCellValue(brf59a.getR24_empty() == null ? "" : brf59a.getR24_empty().toString());
			}
			Row R25row = sheet.getRow(42);
			Cell R25cell1 = R25row.getCell(3);
			if (R25cell1 != null) {
				R25cell1.setCellValue(brf59a.getR25_nbfi() == null ? 0 : brf59a.getR25_nbfi().intValue());
			}

			Cell R25cell2 = R25row.getCell(4);
			if (R25cell2 != null) {
				R25cell2.setCellValue(brf59a.getR25_interbank() == null ? 0 : brf59a.getR25_interbank().intValue());
			}
			Cell R25cell3 = R25row.getCell(5);
			if (R25cell3 != null) {
				R25cell3.setCellValue(brf59a.getR25_gov() == null ? 0 : brf59a.getR25_gov().intValue());
			}
			Cell R25cell4 = R25row.getCell(6);
			if (R25cell4 != null) {
				R25cell4.setCellValue(brf59a.getR25_corporate() == null ? 0 : brf59a.getR25_corporate().intValue());
			}
			Cell R25cell5 = R25row.getCell(7);
			if (R25cell5 != null) {
				R25cell5.setCellValue(brf59a.getR25_gre() == null ? 0 : brf59a.getR25_gre().intValue());
			}
			Cell R25cell6 = R25row.getCell(8);
			if (R25cell6 != null) {
				R25cell6.setCellValue(brf59a.getR25_trade() == null ? 0 : brf59a.getR25_trade().intValue());
			}
			Cell R25cell7 = R25row.getCell(9);
			if (R25cell7 != null) {
				R25cell7.setCellValue(brf59a.getR25_individuals() == null ? 0 : brf59a.getR25_individuals().intValue());
			}
			Cell R25cell8 = R25row.getCell(10);
			if (R25cell8 != null) {
				R25cell8.setCellValue(brf59a.getR25_investment() == null ? 0 : brf59a.getR25_investment().intValue());
			}
			Cell R25cell9 = R25row.getCell(11);
			if (R25cell9 != null) {
				R25cell9.setCellValue(brf59a.getR25_nbfi1() == null ? 0 : brf59a.getR25_nbfi1().intValue());
			}
			Cell R25cell10 = R25row.getCell(12);
			if (R25cell10 != null) {
				R25cell10.setCellValue(brf59a.getR25_interbank1() == null ? 0 : brf59a.getR25_interbank1().intValue());
			}
			Cell R25cell11 = R25row.getCell(13);
			if (R25cell11 != null) {
				R25cell11.setCellValue(brf59a.getR25_gov1() == null ? 0 : brf59a.getR25_gov1().intValue());
			}
			Cell R25cell12 = R25row.getCell(14);
			if (R25cell12 != null) {
				R25cell12.setCellValue(brf59a.getR25_corporate1() == null ? 0 : brf59a.getR25_corporate1().intValue());
			}
			Cell R25cell13 = R25row.getCell(15);
			if (R25cell13 != null) {
				R25cell13.setCellValue(brf59a.getR25_gre1() == null ? 0 : brf59a.getR25_gre1().intValue());
			}
			Cell R25cell14 = R25row.getCell(16);
			if (R25cell14 != null) {
				R25cell14.setCellValue(brf59a.getR25_trade1() == null ? 0 : brf59a.getR25_trade1().intValue());
			}
			Cell R25cell15 = R25row.getCell(17);
			if (R25cell15 != null) {
				R25cell15.setCellValue(
						brf59a.getR25_individuals1() == null ? 0 : brf59a.getR25_individuals1().intValue());
			}
			Cell R25cell16 = R25row.getCell(18);
			if (R25cell16 != null) {
				R25cell16
						.setCellValue(brf59a.getR25_investment1() == null ? 0 : brf59a.getR25_investment1().intValue());
			}
			Cell R25cell17 = R25row.getCell(19);
			if (R25cell17 != null) {
				R25cell17.setCellValue(brf59a.getR25_zer0() == null ? 0 : brf59a.getR25_zer0().intValue());
			}
			Cell R25cell18 = R25row.getCell(20);
			if (R25cell18 != null) {
				R25cell18.setCellValue(brf59a.getR25_three() == null ? 0 : brf59a.getR25_three().intValue());
			}
			Cell R25cell19 = R25row.getCell(21);
			if (R25cell19 != null) {
				R25cell19.setCellValue(brf59a.getR25_six() == null ? 0 : brf59a.getR25_six().intValue());
			}
			Cell R25cell20 = R25row.getCell(22);
			if (R25cell20 != null) {
				R25cell20.setCellValue(brf59a.getR25_oneyear() == null ? 0 : brf59a.getR25_oneyear().intValue());
			}
			Cell R25cell21 = R25row.getCell(23);
			if (R25cell21 != null) {
				R25cell21.setCellValue(brf59a.getR25_foreign() == null ? 0 : brf59a.getR25_foreign().intValue());
			}
			Cell R25cell22 = R25row.getCell(24);
			if (R25cell22 != null) {
				R25cell22.setCellValue(brf59a.getR25_banks() == null ? 0 : brf59a.getR25_banks().intValue());
			}
			Cell R25cell23 = R25row.getCell(25);
			if (R25cell23 != null) {
				R25cell23.setCellValue(brf59a.getR25_gov2() == null ? 0 : brf59a.getR25_gov2().intValue());
			}
			Cell R25cell24 = R25row.getCell(26);
			if (R25cell24 != null) {
				R25cell24.setCellValue(brf59a.getR25_other() == null ? 0 : brf59a.getR25_other().intValue());
			}
			Cell R25cell25 = R25row.getCell(27);
			if (R25cell25 != null) {
				R25cell25.setCellValue(brf59a.getR25_banks1() == null ? 0 : brf59a.getR25_banks1().intValue());
			}
			Cell R25cell26 = R25row.getCell(28);
			if (R25cell26 != null) {
				R25cell26.setCellValue(
						brf59a.getR25_individuals2() == null ? 0 : brf59a.getR25_individuals2().intValue());
			}
			Cell R25cell27 = R25row.getCell(29);
			if (R25cell27 != null) {
				R25cell27.setCellValue(brf59a.getR25_other1() == null ? 0 : brf59a.getR25_other1().intValue());
			}
			Cell R25cell28 = R25row.getCell(30);
			if (R25cell28 != null) {
				R25cell28.setCellValue(brf59a.getR25_banks2() == null ? 0 : brf59a.getR25_banks2().intValue());
			}
			Cell R25cell29 = R25row.getCell(31);
			if (R25cell29 != null) {
				R25cell29.setCellValue(brf59a.getR25_gov3() == null ? 0 : brf59a.getR25_gov3().intValue());
			}
			Cell R25cell30 = R25row.getCell(32);
			if (R25cell30 != null) {
				R25cell30.setCellValue(brf59a.getR25_others2() == null ? 0 : brf59a.getR25_others2().intValue());
			}
			Cell R25cell31 = R25row.getCell(33);
			if (R25cell31 != null) {
				R25cell31.setCellValue(brf59a.getR25_banks3() == null ? 0 : brf59a.getR25_banks3().intValue());
			}
			Cell R25cell32 = R25row.getCell(34);
			if (R25cell32 != null) {
				R25cell32.setCellValue(brf59a.getR25_gov4() == null ? 0 : brf59a.getR25_gov4().intValue());
			}
			Cell R25cell33 = R25row.getCell(35);
			if (R25cell33 != null) {
				R25cell33.setCellValue(brf59a.getR25_others3() == null ? 0 : brf59a.getR25_others3().intValue());
			}
			Cell R25cell34 = R25row.getCell(36);
			if (R25cell34 != null) {
				R25cell34.setCellValue(brf59a.getR25_foreign1() == null ? 0 : brf59a.getR25_foreign1().intValue());
			}
			Cell R25cell35 = R25row.getCell(37);
			if (R25cell35 != null) {
				R25cell35.setCellValue(brf59a.getR25_guarantees() == null ? 0 : brf59a.getR25_guarantees().intValue());
			}
			Cell R25cell36 = R25row.getCell(38);
			if (R25cell36 != null) {
				R25cell36.setCellValue(brf59a.getR25_nbfi2() == null ? 0 : brf59a.getR25_nbfi2().intValue());
			}
			Cell R25cell37 = R25row.getCell(39);
			if (R25cell37 != null) {
				R25cell37.setCellValue(brf59a.getR25_interbank2() == null ? 0 : brf59a.getR25_interbank2().intValue());
			}
			Cell R25cell38 = R25row.getCell(40);
			if (R25cell38 != null) {
				R25cell38.setCellValue(brf59a.getR25_gov5() == null ? 0 : brf59a.getR25_gov5().intValue());
			}
			Cell R25cell39 = R25row.getCell(41);
			if (R25cell39 != null) {
				R25cell39.setCellValue(brf59a.getR25_corporate2() == null ? 0 : brf59a.getR25_corporate2().intValue());
			}
			Cell R25cell40 = R25row.getCell(42);
			if (R25cell40 != null) {
				R25cell40.setCellValue(brf59a.getR25_gre2() == null ? 0 : brf59a.getR25_gre2().intValue());
			}
			Cell R25cell41 = R25row.getCell(43);
			if (R25cell41 != null) {
				R25cell41.setCellValue(
						brf59a.getR25_individuals3() == null ? 0 : brf59a.getR25_individuals3().intValue());
			}
			Cell R25cell42 = R25row.getCell(44);
			if (R25cell42 != null) {
				R25cell42.setCellValue(brf59a.getR25_zero1() == null ? 0 : brf59a.getR25_zero1().intValue());
			}
			Cell R25cell43 = R25row.getCell(45);
			if (R25cell43 != null) {
				R25cell43.setCellValue(brf59a.getR25_three1() == null ? 0 : brf59a.getR25_three1().intValue());
			}
			Cell R25cell44 = R25row.getCell(46);
			if (R25cell44 != null) {
				R25cell44.setCellValue(brf59a.getR25_six1() == null ? 0 : brf59a.getR25_six1().intValue());
			}
			Cell R25cell45 = R25row.getCell(47);
			if (R25cell45 != null) {
				R25cell45.setCellValue(brf59a.getR25_oneyear1() == null ? 0 : brf59a.getR25_oneyear1().intValue());
			}
			Cell R25cell46 = R25row.getCell(48);
			if (R25cell46 != null) {
				R25cell46.setCellValue(brf59a.getR25_empty() == null ? "" : brf59a.getR25_empty().toString());
			}
			Row R27row = sheet.getRow(44);
			Cell R27cell1 = R27row.getCell(3);
			if (R27cell1 != null) {
				R27cell1.setCellValue(brf59a.getR27_nbfi() == null ? 0 : brf59a.getR27_nbfi().intValue());
			}

			Cell R27cell2 = R27row.getCell(4);
			if (R27cell2 != null) {
				R27cell2.setCellValue(brf59a.getR27_interbank() == null ? 0 : brf59a.getR27_interbank().intValue());
			}
			Cell R27cell3 = R27row.getCell(5);
			if (R27cell3 != null) {
				R27cell3.setCellValue(brf59a.getR27_gov() == null ? 0 : brf59a.getR27_gov().intValue());
			}
			Cell R27cell4 = R27row.getCell(6);
			if (R27cell4 != null) {
				R27cell4.setCellValue(brf59a.getR27_corporate() == null ? 0 : brf59a.getR27_corporate().intValue());
			}
			Cell R27cell5 = R27row.getCell(7);
			if (R27cell5 != null) {
				R27cell5.setCellValue(brf59a.getR27_gre() == null ? 0 : brf59a.getR27_gre().intValue());
			}
			Cell R27cell6 = R27row.getCell(8);
			if (R27cell6 != null) {
				R27cell6.setCellValue(brf59a.getR27_trade() == null ? 0 : brf59a.getR27_trade().intValue());
			}
			Cell R27cell7 = R27row.getCell(9);
			if (R27cell7 != null) {
				R27cell7.setCellValue(brf59a.getR27_individuals() == null ? 0 : brf59a.getR27_individuals().intValue());
			}
			Cell R27cell8 = R27row.getCell(10);
			if (R27cell8 != null) {
				R27cell8.setCellValue(brf59a.getR27_investment() == null ? 0 : brf59a.getR27_investment().intValue());
			}
			Cell R27cell9 = R27row.getCell(11);
			if (R27cell9 != null) {
				R27cell9.setCellValue(brf59a.getR27_nbfi1() == null ? 0 : brf59a.getR27_nbfi1().intValue());
			}
			Cell R27cell10 = R27row.getCell(12);
			if (R27cell10 != null) {
				R27cell10.setCellValue(brf59a.getR27_interbank1() == null ? 0 : brf59a.getR27_interbank1().intValue());
			}
			Cell R27cell11 = R27row.getCell(13);
			if (R27cell11 != null) {
				R27cell11.setCellValue(brf59a.getR27_gov1() == null ? 0 : brf59a.getR27_gov1().intValue());
			}
			Cell R27cell12 = R27row.getCell(14);
			if (R27cell12 != null) {
				R27cell12.setCellValue(brf59a.getR27_corporate1() == null ? 0 : brf59a.getR27_corporate1().intValue());
			}
			Cell R27cell13 = R27row.getCell(15);
			if (R27cell13 != null) {
				R27cell13.setCellValue(brf59a.getR27_gre1() == null ? 0 : brf59a.getR27_gre1().intValue());
			}
			Cell R27cell14 = R27row.getCell(16);
			if (R27cell14 != null) {
				R27cell14.setCellValue(brf59a.getR27_trade1() == null ? 0 : brf59a.getR27_trade1().intValue());
			}
			Cell R27cell15 = R27row.getCell(17);
			if (R27cell15 != null) {
				R27cell15.setCellValue(
						brf59a.getR27_individuals1() == null ? 0 : brf59a.getR27_individuals1().intValue());
			}
			Cell R27cell16 = R27row.getCell(18);
			if (R27cell16 != null) {
				R27cell16
						.setCellValue(brf59a.getR27_investment1() == null ? 0 : brf59a.getR27_investment1().intValue());
			}
			Cell R27cell17 = R27row.getCell(19);
			if (R27cell17 != null) {
				R27cell17.setCellValue(brf59a.getR27_zer0() == null ? 0 : brf59a.getR27_zer0().intValue());
			}
			Cell R27cell18 = R27row.getCell(20);
			if (R27cell18 != null) {
				R27cell18.setCellValue(brf59a.getR27_three() == null ? 0 : brf59a.getR27_three().intValue());
			}
			Cell R27cell19 = R27row.getCell(21);
			if (R27cell19 != null) {
				R27cell19.setCellValue(brf59a.getR27_six() == null ? 0 : brf59a.getR27_six().intValue());
			}
			Cell R27cell20 = R27row.getCell(22);
			if (R27cell20 != null) {
				R27cell20.setCellValue(brf59a.getR27_oneyear() == null ? 0 : brf59a.getR27_oneyear().intValue());
			}
			Cell R27cell21 = R27row.getCell(23);
			if (R27cell21 != null) {
				R27cell21.setCellValue(brf59a.getR27_foreign() == null ? 0 : brf59a.getR27_foreign().intValue());
			}
			Cell R27cell22 = R27row.getCell(24);
			if (R27cell22 != null) {
				R27cell22.setCellValue(brf59a.getR27_banks() == null ? 0 : brf59a.getR27_banks().intValue());
			}
			Cell R27cell23 = R27row.getCell(25);
			if (R27cell23 != null) {
				R27cell23.setCellValue(brf59a.getR27_gov2() == null ? 0 : brf59a.getR27_gov2().intValue());
			}
			Cell R27cell24 = R27row.getCell(26);
			if (R27cell24 != null) {
				R27cell24.setCellValue(brf59a.getR27_other() == null ? 0 : brf59a.getR27_other().intValue());
			}
			Cell R27cell25 = R27row.getCell(27);
			if (R27cell25 != null) {
				R27cell25.setCellValue(brf59a.getR27_banks1() == null ? 0 : brf59a.getR27_banks1().intValue());
			}
			Cell R27cell26 = R27row.getCell(28);
			if (R27cell26 != null) {
				R27cell26.setCellValue(
						brf59a.getR27_individuals2() == null ? 0 : brf59a.getR27_individuals2().intValue());
			}
			Cell R27cell27 = R27row.getCell(29);
			if (R27cell27 != null) {
				R27cell27.setCellValue(brf59a.getR27_other1() == null ? 0 : brf59a.getR27_other1().intValue());
			}
			Cell R27cell28 = R27row.getCell(30);
			if (R27cell28 != null) {
				R27cell28.setCellValue(brf59a.getR27_banks2() == null ? 0 : brf59a.getR27_banks2().intValue());
			}
			Cell R27cell29 = R27row.getCell(31);
			if (R27cell29 != null) {
				R27cell29.setCellValue(brf59a.getR27_gov3() == null ? 0 : brf59a.getR27_gov3().intValue());
			}
			Cell R27cell30 = R27row.getCell(32);
			if (R27cell30 != null) {
				R27cell30.setCellValue(brf59a.getR27_others2() == null ? 0 : brf59a.getR27_others2().intValue());
			}
			Cell R27cell31 = R27row.getCell(33);
			if (R27cell31 != null) {
				R27cell31.setCellValue(brf59a.getR27_banks3() == null ? 0 : brf59a.getR27_banks3().intValue());
			}
			Cell R27cell32 = R27row.getCell(34);
			if (R27cell32 != null) {
				R27cell32.setCellValue(brf59a.getR27_gov4() == null ? 0 : brf59a.getR27_gov4().intValue());
			}
			Cell R27cell33 = R27row.getCell(35);
			if (R27cell33 != null) {
				R27cell33.setCellValue(brf59a.getR27_others3() == null ? 0 : brf59a.getR27_others3().intValue());
			}
			Cell R27cell34 = R27row.getCell(36);
			if (R27cell34 != null) {
				R27cell34.setCellValue(brf59a.getR27_foreign1() == null ? 0 : brf59a.getR27_foreign1().intValue());
			}
			Cell R27cell35 = R27row.getCell(37);
			if (R27cell35 != null) {
				R27cell35.setCellValue(brf59a.getR27_guarantees() == null ? 0 : brf59a.getR27_guarantees().intValue());
			}
			Cell R27cell36 = R27row.getCell(38);
			if (R27cell36 != null) {
				R27cell36.setCellValue(brf59a.getR27_nbfi2() == null ? 0 : brf59a.getR27_nbfi2().intValue());
			}
			Cell R27cell37 = R27row.getCell(39);
			if (R27cell37 != null) {
				R27cell37.setCellValue(brf59a.getR27_interbank2() == null ? 0 : brf59a.getR27_interbank2().intValue());
			}
			Cell R27cell38 = R27row.getCell(40);
			if (R27cell38 != null) {
				R27cell38.setCellValue(brf59a.getR27_gov5() == null ? 0 : brf59a.getR27_gov5().intValue());
			}
			Cell R27cell39 = R27row.getCell(41);
			if (R27cell39 != null) {
				R27cell39.setCellValue(brf59a.getR27_corporate2() == null ? 0 : brf59a.getR27_corporate2().intValue());
			}
			Cell R27cell40 = R27row.getCell(42);
			if (R27cell40 != null) {
				R27cell40.setCellValue(brf59a.getR27_gre2() == null ? 0 : brf59a.getR27_gre2().intValue());
			}
			Cell R27cell41 = R27row.getCell(43);
			if (R27cell41 != null) {
				R27cell41.setCellValue(
						brf59a.getR27_individuals3() == null ? 0 : brf59a.getR27_individuals3().intValue());
			}
			Cell R27cell42 = R27row.getCell(44);
			if (R27cell42 != null) {
				R27cell42.setCellValue(brf59a.getR27_zero1() == null ? 0 : brf59a.getR27_zero1().intValue());
			}
			Cell R27cell43 = R27row.getCell(45);
			if (R27cell43 != null) {
				R27cell43.setCellValue(brf59a.getR27_three1() == null ? 0 : brf59a.getR27_three1().intValue());
			}
			Cell R27cell44 = R27row.getCell(46);
			if (R27cell44 != null) {
				R27cell44.setCellValue(brf59a.getR27_six1() == null ? 0 : brf59a.getR27_six1().intValue());
			}
			Cell R27cell45 = R27row.getCell(47);
			if (R27cell45 != null) {
				R27cell45.setCellValue(brf59a.getR27_oneyear1() == null ? 0 : brf59a.getR27_oneyear1().intValue());
			}
			Cell R27cell46 = R27row.getCell(48);
			if (R27cell46 != null) {
				R27cell46.setCellValue(brf59a.getR27_empty() == null ? "" : brf59a.getR27_empty().toString());
			}
			Row R28row = sheet.getRow(45);
			Cell R28cell1 = R28row.getCell(3);
			if (R28cell1 != null) {
				R28cell1.setCellValue(brf59a.getR28_nbfi() == null ? 0 : brf59a.getR28_nbfi().intValue());
			}

			Cell R28cell2 = R28row.getCell(4);
			if (R28cell2 != null) {
				R28cell2.setCellValue(brf59a.getR28_interbank() == null ? 0 : brf59a.getR28_interbank().intValue());
			}
			Cell R28cell3 = R28row.getCell(5);
			if (R28cell3 != null) {
				R28cell3.setCellValue(brf59a.getR28_gov() == null ? 0 : brf59a.getR28_gov().intValue());
			}
			Cell R28cell4 = R28row.getCell(6);
			if (R28cell4 != null) {
				R28cell4.setCellValue(brf59a.getR28_corporate() == null ? 0 : brf59a.getR28_corporate().intValue());
			}
			Cell R28cell5 = R28row.getCell(7);
			if (R28cell5 != null) {
				R28cell5.setCellValue(brf59a.getR28_gre() == null ? 0 : brf59a.getR28_gre().intValue());
			}
			Cell R28cell6 = R28row.getCell(8);
			if (R28cell6 != null) {
				R28cell6.setCellValue(brf59a.getR28_trade() == null ? 0 : brf59a.getR28_trade().intValue());
			}
			Cell R28cell7 = R28row.getCell(9);
			if (R28cell7 != null) {
				R28cell7.setCellValue(brf59a.getR28_individuals() == null ? 0 : brf59a.getR28_individuals().intValue());
			}
			Cell R28cell8 = R28row.getCell(10);
			if (R28cell8 != null) {
				R28cell8.setCellValue(brf59a.getR28_investment() == null ? 0 : brf59a.getR28_investment().intValue());
			}
			Cell R28cell9 = R28row.getCell(11);
			if (R28cell9 != null) {
				R28cell9.setCellValue(brf59a.getR28_nbfi1() == null ? 0 : brf59a.getR28_nbfi1().intValue());
			}
			Cell R28cell10 = R28row.getCell(12);
			if (R28cell10 != null) {
				R28cell10.setCellValue(brf59a.getR28_interbank1() == null ? 0 : brf59a.getR28_interbank1().intValue());
			}
			Cell R28cell11 = R28row.getCell(13);
			if (R28cell11 != null) {
				R28cell11.setCellValue(brf59a.getR28_gov1() == null ? 0 : brf59a.getR28_gov1().intValue());
			}
			Cell R28cell12 = R28row.getCell(14);
			if (R28cell12 != null) {
				R28cell12.setCellValue(brf59a.getR28_corporate1() == null ? 0 : brf59a.getR28_corporate1().intValue());
			}
			Cell R28cell13 = R28row.getCell(15);
			if (R28cell13 != null) {
				R28cell13.setCellValue(brf59a.getR28_gre1() == null ? 0 : brf59a.getR28_gre1().intValue());
			}
			Cell R28cell14 = R28row.getCell(16);
			if (R28cell14 != null) {
				R28cell14.setCellValue(brf59a.getR28_trade1() == null ? 0 : brf59a.getR28_trade1().intValue());
			}
			Cell R28cell15 = R28row.getCell(17);
			if (R28cell15 != null) {
				R28cell15.setCellValue(
						brf59a.getR28_individuals1() == null ? 0 : brf59a.getR28_individuals1().intValue());
			}
			Cell R28cell16 = R28row.getCell(18);
			if (R28cell16 != null) {
				R28cell16
						.setCellValue(brf59a.getR28_investment1() == null ? 0 : brf59a.getR28_investment1().intValue());
			}
			Cell R28cell17 = R28row.getCell(19);
			if (R28cell17 != null) {
				R28cell17.setCellValue(brf59a.getR28_zer0() == null ? 0 : brf59a.getR28_zer0().intValue());
			}
			Cell R28cell18 = R28row.getCell(20);
			if (R28cell18 != null) {
				R28cell18.setCellValue(brf59a.getR28_three() == null ? 0 : brf59a.getR28_three().intValue());
			}
			Cell R28cell19 = R28row.getCell(21);
			if (R28cell19 != null) {
				R28cell19.setCellValue(brf59a.getR28_six() == null ? 0 : brf59a.getR28_six().intValue());
			}
			Cell R28cell20 = R28row.getCell(22);
			if (R28cell20 != null) {
				R28cell20.setCellValue(brf59a.getR28_oneyear() == null ? 0 : brf59a.getR28_oneyear().intValue());
			}
			Cell R28cell21 = R28row.getCell(23);
			if (R28cell21 != null) {
				R28cell21.setCellValue(brf59a.getR28_foreign() == null ? 0 : brf59a.getR28_foreign().intValue());
			}
			Cell R28cell22 = R28row.getCell(24);
			if (R28cell22 != null) {
				R28cell22.setCellValue(brf59a.getR28_banks() == null ? 0 : brf59a.getR28_banks().intValue());
			}
			Cell R28cell23 = R28row.getCell(25);
			if (R28cell23 != null) {
				R28cell23.setCellValue(brf59a.getR28_gov2() == null ? 0 : brf59a.getR28_gov2().intValue());
			}
			Cell R28cell24 = R28row.getCell(26);
			if (R28cell24 != null) {
				R28cell24.setCellValue(brf59a.getR28_other() == null ? 0 : brf59a.getR28_other().intValue());
			}
			Cell R28cell25 = R28row.getCell(27);
			if (R28cell25 != null) {
				R28cell25.setCellValue(brf59a.getR28_banks1() == null ? 0 : brf59a.getR28_banks1().intValue());
			}
			Cell R28cell26 = R28row.getCell(28);
			if (R28cell26 != null) {
				R28cell26.setCellValue(
						brf59a.getR28_individuals2() == null ? 0 : brf59a.getR28_individuals2().intValue());
			}
			Cell R28cell27 = R28row.getCell(29);
			if (R28cell27 != null) {
				R28cell27.setCellValue(brf59a.getR28_other1() == null ? 0 : brf59a.getR28_other1().intValue());
			}
			Cell R28cell28 = R28row.getCell(30);
			if (R28cell28 != null) {
				R28cell28.setCellValue(brf59a.getR28_banks2() == null ? 0 : brf59a.getR28_banks2().intValue());
			}
			Cell R28cell29 = R28row.getCell(31);
			if (R28cell29 != null) {
				R28cell29.setCellValue(brf59a.getR28_gov3() == null ? 0 : brf59a.getR28_gov3().intValue());
			}
			Cell R28cell30 = R28row.getCell(32);
			if (R28cell30 != null) {
				R28cell30.setCellValue(brf59a.getR28_others2() == null ? 0 : brf59a.getR28_others2().intValue());
			}
			Cell R28cell31 = R28row.getCell(33);
			if (R28cell31 != null) {
				R28cell31.setCellValue(brf59a.getR28_banks3() == null ? 0 : brf59a.getR28_banks3().intValue());
			}
			Cell R28cell32 = R28row.getCell(34);
			if (R28cell32 != null) {
				R28cell32.setCellValue(brf59a.getR28_gov4() == null ? 0 : brf59a.getR28_gov4().intValue());
			}
			Cell R28cell33 = R28row.getCell(35);
			if (R28cell33 != null) {
				R28cell33.setCellValue(brf59a.getR28_others3() == null ? 0 : brf59a.getR28_others3().intValue());
			}
			Cell R28cell34 = R28row.getCell(36);
			if (R28cell34 != null) {
				R28cell34.setCellValue(brf59a.getR28_foreign1() == null ? 0 : brf59a.getR28_foreign1().intValue());
			}
			Cell R28cell35 = R28row.getCell(37);
			if (R28cell35 != null) {
				R28cell35.setCellValue(brf59a.getR28_guarantees() == null ? 0 : brf59a.getR28_guarantees().intValue());
			}
			Cell R28cell36 = R28row.getCell(38);
			if (R28cell36 != null) {
				R28cell36.setCellValue(brf59a.getR28_nbfi2() == null ? 0 : brf59a.getR28_nbfi2().intValue());
			}
			Cell R28cell37 = R28row.getCell(39);
			if (R28cell37 != null) {
				R28cell37.setCellValue(brf59a.getR28_interbank2() == null ? 0 : brf59a.getR28_interbank2().intValue());
			}
			Cell R28cell38 = R28row.getCell(40);
			if (R28cell38 != null) {
				R28cell38.setCellValue(brf59a.getR28_gov5() == null ? 0 : brf59a.getR28_gov5().intValue());
			}
			Cell R28cell39 = R28row.getCell(41);
			if (R28cell39 != null) {
				R28cell39.setCellValue(brf59a.getR28_corporate2() == null ? 0 : brf59a.getR28_corporate2().intValue());
			}
			Cell R28cell40 = R28row.getCell(42);
			if (R28cell40 != null) {
				R28cell40.setCellValue(brf59a.getR28_gre2() == null ? 0 : brf59a.getR28_gre2().intValue());
			}
			Cell R28cell41 = R28row.getCell(43);
			if (R28cell41 != null) {
				R28cell41.setCellValue(
						brf59a.getR28_individuals3() == null ? 0 : brf59a.getR28_individuals3().intValue());
			}
			Cell R28cell42 = R28row.getCell(44);
			if (R28cell42 != null) {
				R28cell42.setCellValue(brf59a.getR28_zero1() == null ? 0 : brf59a.getR28_zero1().intValue());
			}
			Cell R28cell43 = R28row.getCell(45);
			if (R28cell43 != null) {
				R28cell43.setCellValue(brf59a.getR28_three1() == null ? 0 : brf59a.getR28_three1().intValue());
			}
			Cell R28cell44 = R28row.getCell(46);
			if (R28cell44 != null) {
				R28cell44.setCellValue(brf59a.getR28_six1() == null ? 0 : brf59a.getR28_six1().intValue());
			}
			Cell R28cell45 = R28row.getCell(47);
			if (R28cell45 != null) {
				R28cell45.setCellValue(brf59a.getR28_oneyear1() == null ? 0 : brf59a.getR28_oneyear1().intValue());
			}
			Cell R28cell46 = R28row.getCell(48);
			if (R28cell46 != null) {
				R28cell46.setCellValue(brf59a.getR28_empty() == null ? "" : brf59a.getR28_empty().toString());
			}
			Row R29row = sheet.getRow(46);
			Cell R29cell1 = R29row.getCell(3);
			if (R29cell1 != null) {
				R29cell1.setCellValue(brf59a.getR29_nbfi() == null ? 0 : brf59a.getR29_nbfi().intValue());
			}

			Cell R29cell2 = R29row.getCell(4);
			if (R29cell2 != null) {
				R29cell2.setCellValue(brf59a.getR29_interbank() == null ? 0 : brf59a.getR29_interbank().intValue());
			}
			Cell R29cell3 = R29row.getCell(5);
			if (R29cell3 != null) {
				R29cell3.setCellValue(brf59a.getR29_gov() == null ? 0 : brf59a.getR29_gov().intValue());
			}
			Cell R29cell4 = R29row.getCell(6);
			if (R29cell4 != null) {
				R29cell4.setCellValue(brf59a.getR29_corporate() == null ? 0 : brf59a.getR29_corporate().intValue());
			}
			Cell R29cell5 = R29row.getCell(7);
			if (R29cell5 != null) {
				R29cell5.setCellValue(brf59a.getR29_gre() == null ? 0 : brf59a.getR29_gre().intValue());
			}
			Cell R29cell6 = R29row.getCell(8);
			if (R29cell6 != null) {
				R29cell6.setCellValue(brf59a.getR29_trade() == null ? 0 : brf59a.getR29_trade().intValue());
			}
			Cell R29cell7 = R29row.getCell(9);
			if (R29cell7 != null) {
				R29cell7.setCellValue(brf59a.getR29_individuals() == null ? 0 : brf59a.getR29_individuals().intValue());
			}
			Cell R29cell8 = R29row.getCell(10);
			if (R29cell8 != null) {
				R29cell8.setCellValue(brf59a.getR29_investment() == null ? 0 : brf59a.getR29_investment().intValue());
			}
			Cell R29cell9 = R29row.getCell(11);
			if (R29cell9 != null) {
				R29cell9.setCellValue(brf59a.getR29_nbfi1() == null ? 0 : brf59a.getR29_nbfi1().intValue());
			}
			Cell R29cell10 = R29row.getCell(12);
			if (R29cell10 != null) {
				R29cell10.setCellValue(brf59a.getR29_interbank1() == null ? 0 : brf59a.getR29_interbank1().intValue());
			}
			Cell R29cell11 = R29row.getCell(13);
			if (R29cell11 != null) {
				R29cell11.setCellValue(brf59a.getR29_gov1() == null ? 0 : brf59a.getR29_gov1().intValue());
			}
			Cell R29cell12 = R29row.getCell(14);
			if (R29cell12 != null) {
				R29cell12.setCellValue(brf59a.getR29_corporate1() == null ? 0 : brf59a.getR29_corporate1().intValue());
			}
			Cell R29cell13 = R29row.getCell(15);
			if (R29cell13 != null) {
				R29cell13.setCellValue(brf59a.getR29_gre1() == null ? 0 : brf59a.getR29_gre1().intValue());
			}
			Cell R29cell14 = R29row.getCell(16);
			if (R29cell14 != null) {
				R29cell14.setCellValue(brf59a.getR29_trade1() == null ? 0 : brf59a.getR29_trade1().intValue());
			}
			Cell R29cell15 = R29row.getCell(17);
			if (R29cell15 != null) {
				R29cell15.setCellValue(
						brf59a.getR29_individuals1() == null ? 0 : brf59a.getR29_individuals1().intValue());
			}
			Cell R29cell16 = R29row.getCell(18);
			if (R29cell16 != null) {
				R29cell16
						.setCellValue(brf59a.getR29_investment1() == null ? 0 : brf59a.getR29_investment1().intValue());
			}
			Cell R29cell17 = R29row.getCell(19);
			if (R29cell17 != null) {
				R29cell17.setCellValue(brf59a.getR29_zer0() == null ? 0 : brf59a.getR29_zer0().intValue());
			}
			Cell R29cell18 = R29row.getCell(20);
			if (R29cell18 != null) {
				R29cell18.setCellValue(brf59a.getR29_three() == null ? 0 : brf59a.getR29_three().intValue());
			}
			Cell R29cell19 = R29row.getCell(21);
			if (R29cell19 != null) {
				R29cell19.setCellValue(brf59a.getR29_six() == null ? 0 : brf59a.getR29_six().intValue());
			}
			Cell R29cell20 = R29row.getCell(22);
			if (R29cell20 != null) {
				R29cell20.setCellValue(brf59a.getR29_oneyear() == null ? 0 : brf59a.getR29_oneyear().intValue());
			}
			Cell R29cell21 = R29row.getCell(23);
			if (R29cell21 != null) {
				R29cell21.setCellValue(brf59a.getR29_foreign() == null ? 0 : brf59a.getR29_foreign().intValue());
			}
			Cell R29cell22 = R29row.getCell(24);
			if (R29cell22 != null) {
				R29cell22.setCellValue(brf59a.getR29_banks() == null ? 0 : brf59a.getR29_banks().intValue());
			}
			Cell R29cell23 = R29row.getCell(25);
			if (R29cell23 != null) {
				R29cell23.setCellValue(brf59a.getR29_gov2() == null ? 0 : brf59a.getR29_gov2().intValue());
			}
			Cell R29cell24 = R29row.getCell(26);
			if (R29cell24 != null) {
				R29cell24.setCellValue(brf59a.getR29_other() == null ? 0 : brf59a.getR29_other().intValue());
			}
			Cell R29cell25 = R29row.getCell(27);
			if (R29cell25 != null) {
				R29cell25.setCellValue(brf59a.getR29_banks1() == null ? 0 : brf59a.getR29_banks1().intValue());
			}
			Cell R29cell26 = R29row.getCell(28);
			if (R29cell26 != null) {
				R29cell26.setCellValue(
						brf59a.getR29_individuals2() == null ? 0 : brf59a.getR29_individuals2().intValue());
			}
			Cell R29cell27 = R29row.getCell(29);
			if (R29cell27 != null) {
				R29cell27.setCellValue(brf59a.getR29_other1() == null ? 0 : brf59a.getR29_other1().intValue());
			}
			Cell R29cell28 = R29row.getCell(30);
			if (R29cell28 != null) {
				R29cell28.setCellValue(brf59a.getR29_banks2() == null ? 0 : brf59a.getR29_banks2().intValue());
			}
			Cell R29cell29 = R29row.getCell(31);
			if (R29cell29 != null) {
				R29cell29.setCellValue(brf59a.getR29_gov3() == null ? 0 : brf59a.getR29_gov3().intValue());
			}
			Cell R29cell30 = R29row.getCell(32);
			if (R29cell30 != null) {
				R29cell30.setCellValue(brf59a.getR29_others2() == null ? 0 : brf59a.getR29_others2().intValue());
			}
			Cell R29cell31 = R29row.getCell(33);
			if (R29cell31 != null) {
				R29cell31.setCellValue(brf59a.getR29_banks3() == null ? 0 : brf59a.getR29_banks3().intValue());
			}
			Cell R29cell32 = R29row.getCell(34);
			if (R29cell32 != null) {
				R29cell32.setCellValue(brf59a.getR29_gov4() == null ? 0 : brf59a.getR29_gov4().intValue());
			}
			Cell R29cell33 = R29row.getCell(35);
			if (R29cell33 != null) {
				R29cell33.setCellValue(brf59a.getR29_others3() == null ? 0 : brf59a.getR29_others3().intValue());
			}
			Cell R29cell34 = R29row.getCell(36);
			if (R29cell34 != null) {
				R29cell34.setCellValue(brf59a.getR29_foreign1() == null ? 0 : brf59a.getR29_foreign1().intValue());
			}
			Cell R29cell35 = R29row.getCell(37);
			if (R29cell35 != null) {
				R29cell35.setCellValue(brf59a.getR29_guarantees() == null ? 0 : brf59a.getR29_guarantees().intValue());
			}
			Cell R29cell36 = R29row.getCell(38);
			if (R29cell36 != null) {
				R29cell36.setCellValue(brf59a.getR29_nbfi2() == null ? 0 : brf59a.getR29_nbfi2().intValue());
			}
			Cell R29cell37 = R29row.getCell(39);
			if (R29cell37 != null) {
				R29cell37.setCellValue(brf59a.getR29_interbank2() == null ? 0 : brf59a.getR29_interbank2().intValue());
			}
			Cell R29cell38 = R29row.getCell(40);
			if (R29cell38 != null) {
				R29cell38.setCellValue(brf59a.getR29_gov5() == null ? 0 : brf59a.getR29_gov5().intValue());
			}
			Cell R29cell39 = R29row.getCell(41);
			if (R29cell39 != null) {
				R29cell39.setCellValue(brf59a.getR29_corporate2() == null ? 0 : brf59a.getR29_corporate2().intValue());
			}
			Cell R29cell40 = R29row.getCell(42);
			if (R29cell40 != null) {
				R29cell40.setCellValue(brf59a.getR29_gre2() == null ? 0 : brf59a.getR29_gre2().intValue());
			}
			Cell R29cell41 = R29row.getCell(43);
			if (R29cell41 != null) {
				R29cell41.setCellValue(
						brf59a.getR29_individuals3() == null ? 0 : brf59a.getR29_individuals3().intValue());
			}
			Cell R29cell42 = R29row.getCell(44);
			if (R29cell42 != null) {
				R29cell42.setCellValue(brf59a.getR29_zero1() == null ? 0 : brf59a.getR29_zero1().intValue());
			}
			Cell R29cell43 = R29row.getCell(45);
			if (R29cell43 != null) {
				R29cell43.setCellValue(brf59a.getR29_three1() == null ? 0 : brf59a.getR29_three1().intValue());
			}
			Cell R29cell44 = R29row.getCell(46);
			if (R29cell44 != null) {
				R29cell44.setCellValue(brf59a.getR29_six1() == null ? 0 : brf59a.getR29_six1().intValue());
			}
			Cell R29cell45 = R29row.getCell(47);
			if (R29cell45 != null) {
				R29cell45.setCellValue(brf59a.getR29_oneyear1() == null ? 0 : brf59a.getR29_oneyear1().intValue());
			}
			Cell R29cell46 = R29row.getCell(48);
			if (R29cell46 != null) {
				R29cell46.setCellValue(brf59a.getR29_empty() == null ? "" : brf59a.getR29_empty().toString());
			}
			Row R30row = sheet.getRow(47);
			Cell R30cell1 = R30row.getCell(3);
			if (R30cell1 != null) {
				R30cell1.setCellValue(brf59a.getR30_nbfi() == null ? 0 : brf59a.getR30_nbfi().intValue());
			}

			Cell R30cell2 = R30row.getCell(4);
			if (R30cell2 != null) {
				R30cell2.setCellValue(brf59a.getR30_interbank() == null ? 0 : brf59a.getR30_interbank().intValue());
			}
			Cell R30cell3 = R30row.getCell(5);
			if (R30cell3 != null) {
				R30cell3.setCellValue(brf59a.getR30_gov() == null ? 0 : brf59a.getR30_gov().intValue());
			}
			Cell R30cell4 = R30row.getCell(6);
			if (R30cell4 != null) {
				R30cell4.setCellValue(brf59a.getR30_corporate() == null ? 0 : brf59a.getR30_corporate().intValue());
			}
			Cell R30cell5 = R30row.getCell(7);
			if (R30cell5 != null) {
				R30cell5.setCellValue(brf59a.getR30_gre() == null ? 0 : brf59a.getR30_gre().intValue());
			}
			Cell R30cell6 = R30row.getCell(8);
			if (R30cell6 != null) {
				R30cell6.setCellValue(brf59a.getR30_trade() == null ? 0 : brf59a.getR30_trade().intValue());
			}
			Cell R30cell7 = R30row.getCell(9);
			if (R30cell7 != null) {
				R30cell7.setCellValue(brf59a.getR30_individuals() == null ? 0 : brf59a.getR30_individuals().intValue());
			}
			Cell R30cell8 = R30row.getCell(10);
			if (R30cell8 != null) {
				R30cell8.setCellValue(brf59a.getR30_investment() == null ? 0 : brf59a.getR30_investment().intValue());
			}
			Cell R30cell9 = R30row.getCell(11);
			if (R30cell9 != null) {
				R30cell9.setCellValue(brf59a.getR30_nbfi1() == null ? 0 : brf59a.getR30_nbfi1().intValue());
			}
			Cell R30cell10 = R30row.getCell(12);
			if (R30cell10 != null) {
				R30cell10.setCellValue(brf59a.getR30_interbank1() == null ? 0 : brf59a.getR30_interbank1().intValue());
			}
			Cell R30cell11 = R30row.getCell(13);
			if (R30cell11 != null) {
				R30cell11.setCellValue(brf59a.getR30_gov1() == null ? 0 : brf59a.getR30_gov1().intValue());
			}
			Cell R30cell12 = R30row.getCell(14);
			if (R30cell12 != null) {
				R30cell12.setCellValue(brf59a.getR30_corporate1() == null ? 0 : brf59a.getR30_corporate1().intValue());
			}
			Cell R30cell13 = R30row.getCell(15);
			if (R30cell13 != null) {
				R30cell13.setCellValue(brf59a.getR30_gre1() == null ? 0 : brf59a.getR30_gre1().intValue());
			}
			Cell R30cell14 = R30row.getCell(16);
			if (R30cell14 != null) {
				R30cell14.setCellValue(brf59a.getR30_trade1() == null ? 0 : brf59a.getR30_trade1().intValue());
			}
			Cell R30cell15 = R30row.getCell(17);
			if (R30cell15 != null) {
				R30cell15.setCellValue(
						brf59a.getR30_individuals1() == null ? 0 : brf59a.getR30_individuals1().intValue());
			}
			Cell R30cell16 = R30row.getCell(18);
			if (R30cell16 != null) {
				R30cell16
						.setCellValue(brf59a.getR30_investment1() == null ? 0 : brf59a.getR30_investment1().intValue());
			}
			Cell R30cell17 = R30row.getCell(19);
			if (R30cell17 != null) {
				R30cell17.setCellValue(brf59a.getR30_zer0() == null ? 0 : brf59a.getR30_zer0().intValue());
			}
			Cell R30cell18 = R30row.getCell(20);
			if (R30cell18 != null) {
				R30cell18.setCellValue(brf59a.getR30_three() == null ? 0 : brf59a.getR30_three().intValue());
			}
			Cell R30cell19 = R30row.getCell(21);
			if (R30cell19 != null) {
				R30cell19.setCellValue(brf59a.getR30_six() == null ? 0 : brf59a.getR30_six().intValue());
			}
			Cell R30cell20 = R30row.getCell(22);
			if (R30cell20 != null) {
				R30cell20.setCellValue(brf59a.getR30_oneyear() == null ? 0 : brf59a.getR30_oneyear().intValue());
			}
			Cell R30cell21 = R30row.getCell(23);
			if (R30cell21 != null) {
				R30cell21.setCellValue(brf59a.getR30_foreign() == null ? 0 : brf59a.getR30_foreign().intValue());
			}
			Cell R30cell22 = R30row.getCell(24);
			if (R30cell22 != null) {
				R30cell22.setCellValue(brf59a.getR30_banks() == null ? 0 : brf59a.getR30_banks().intValue());
			}
			Cell R30cell23 = R30row.getCell(25);
			if (R30cell23 != null) {
				R30cell23.setCellValue(brf59a.getR30_gov2() == null ? 0 : brf59a.getR30_gov2().intValue());
			}
			Cell R30cell24 = R30row.getCell(26);
			if (R30cell24 != null) {
				R30cell24.setCellValue(brf59a.getR30_other() == null ? 0 : brf59a.getR30_other().intValue());
			}
			Cell R30cell25 = R30row.getCell(27);
			if (R30cell25 != null) {
				R30cell25.setCellValue(brf59a.getR30_banks1() == null ? 0 : brf59a.getR30_banks1().intValue());
			}
			Cell R30cell26 = R30row.getCell(28);
			if (R30cell26 != null) {
				R30cell26.setCellValue(
						brf59a.getR30_individuals2() == null ? 0 : brf59a.getR30_individuals2().intValue());
			}
			Cell R30cell27 = R30row.getCell(29);
			if (R30cell27 != null) {
				R30cell27.setCellValue(brf59a.getR30_other1() == null ? 0 : brf59a.getR30_other1().intValue());
			}
			Cell R30cell28 = R30row.getCell(30);
			if (R30cell28 != null) {
				R30cell28.setCellValue(brf59a.getR30_banks2() == null ? 0 : brf59a.getR30_banks2().intValue());
			}
			Cell R30cell29 = R30row.getCell(31);
			if (R30cell29 != null) {
				R30cell29.setCellValue(brf59a.getR30_gov3() == null ? 0 : brf59a.getR30_gov3().intValue());
			}
			Cell R30cell30 = R30row.getCell(32);
			if (R30cell30 != null) {
				R30cell30.setCellValue(brf59a.getR30_others2() == null ? 0 : brf59a.getR30_others2().intValue());
			}
			Cell R30cell31 = R30row.getCell(33);
			if (R30cell31 != null) {
				R30cell31.setCellValue(brf59a.getR30_banks3() == null ? 0 : brf59a.getR30_banks3().intValue());
			}
			Cell R30cell32 = R30row.getCell(34);
			if (R30cell32 != null) {
				R30cell32.setCellValue(brf59a.getR30_gov4() == null ? 0 : brf59a.getR30_gov4().intValue());
			}
			Cell R30cell33 = R30row.getCell(35);
			if (R30cell33 != null) {
				R30cell33.setCellValue(brf59a.getR30_others3() == null ? 0 : brf59a.getR30_others3().intValue());
			}
			Cell R30cell34 = R30row.getCell(36);
			if (R30cell34 != null) {
				R30cell34.setCellValue(brf59a.getR30_foreign1() == null ? 0 : brf59a.getR30_foreign1().intValue());
			}
			Cell R30cell35 = R30row.getCell(37);
			if (R30cell35 != null) {
				R30cell35.setCellValue(brf59a.getR30_guarantees() == null ? 0 : brf59a.getR30_guarantees().intValue());
			}
			Cell R30cell36 = R30row.getCell(38);
			if (R30cell36 != null) {
				R30cell36.setCellValue(brf59a.getR30_nbfi2() == null ? 0 : brf59a.getR30_nbfi2().intValue());
			}
			Cell R30cell37 = R30row.getCell(39);
			if (R30cell37 != null) {
				R30cell37.setCellValue(brf59a.getR30_interbank2() == null ? 0 : brf59a.getR30_interbank2().intValue());
			}
			Cell R30cell38 = R30row.getCell(40);
			if (R30cell38 != null) {
				R30cell38.setCellValue(brf59a.getR30_gov5() == null ? 0 : brf59a.getR30_gov5().intValue());
			}
			Cell R30cell39 = R30row.getCell(41);
			if (R30cell39 != null) {
				R30cell39.setCellValue(brf59a.getR30_corporate2() == null ? 0 : brf59a.getR30_corporate2().intValue());
			}
			Cell R30cell40 = R30row.getCell(42);
			if (R30cell40 != null) {
				R30cell40.setCellValue(brf59a.getR30_gre2() == null ? 0 : brf59a.getR30_gre2().intValue());
			}
			Cell R30cell41 = R30row.getCell(43);
			if (R30cell41 != null) {
				R30cell41.setCellValue(
						brf59a.getR30_individuals3() == null ? 0 : brf59a.getR30_individuals3().intValue());
			}
			Cell R30cell42 = R30row.getCell(44);
			if (R30cell42 != null) {
				R30cell42.setCellValue(brf59a.getR30_zero1() == null ? 0 : brf59a.getR30_zero1().intValue());
			}
			Cell R30cell43 = R30row.getCell(45);
			if (R30cell43 != null) {
				R30cell43.setCellValue(brf59a.getR30_three1() == null ? 0 : brf59a.getR30_three1().intValue());
			}
			Cell R30cell44 = R30row.getCell(46);
			if (R30cell44 != null) {
				R30cell44.setCellValue(brf59a.getR30_six1() == null ? 0 : brf59a.getR30_six1().intValue());
			}
			Cell R30cell45 = R30row.getCell(47);
			if (R30cell45 != null) {
				R30cell45.setCellValue(brf59a.getR30_oneyear1() == null ? 0 : brf59a.getR30_oneyear1().intValue());
			}
			Cell R30cell46 = R30row.getCell(48);
			if (R30cell46 != null) {
				R30cell46.setCellValue(brf59a.getR30_empty() == null ? "" : brf59a.getR30_empty().toString());
			}
			Row R31row = sheet.getRow(48);
			Cell R31cell1 = R31row.getCell(3);
			if (R31cell1 != null) {
				R31cell1.setCellValue(brf59a.getR31_nbfi() == null ? 0 : brf59a.getR31_nbfi().intValue());
			}

			Cell R31cell2 = R31row.getCell(4);
			if (R31cell2 != null) {
				R31cell2.setCellValue(brf59a.getR31_interbank() == null ? 0 : brf59a.getR31_interbank().intValue());
			}
			Cell R31cell3 = R31row.getCell(5);
			if (R31cell3 != null) {
				R31cell3.setCellValue(brf59a.getR31_gov() == null ? 0 : brf59a.getR31_gov().intValue());
			}
			Cell R31cell4 = R31row.getCell(6);
			if (R31cell4 != null) {
				R31cell4.setCellValue(brf59a.getR31_corporate() == null ? 0 : brf59a.getR31_corporate().intValue());
			}
			Cell R31cell5 = R31row.getCell(7);
			if (R31cell5 != null) {
				R31cell5.setCellValue(brf59a.getR31_gre() == null ? 0 : brf59a.getR31_gre().intValue());
			}
			Cell R31cell6 = R31row.getCell(8);
			if (R31cell6 != null) {
				R31cell6.setCellValue(brf59a.getR31_trade() == null ? 0 : brf59a.getR31_trade().intValue());
			}
			Cell R31cell7 = R31row.getCell(9);
			if (R31cell7 != null) {
				R31cell7.setCellValue(brf59a.getR31_individuals() == null ? 0 : brf59a.getR31_individuals().intValue());
			}
			Cell R31cell8 = R31row.getCell(10);
			if (R31cell8 != null) {
				R31cell8.setCellValue(brf59a.getR31_investment() == null ? 0 : brf59a.getR31_investment().intValue());
			}
			Cell R31cell9 = R31row.getCell(11);
			if (R31cell9 != null) {
				R31cell9.setCellValue(brf59a.getR31_nbfi1() == null ? 0 : brf59a.getR31_nbfi1().intValue());
			}
			Cell R31cell10 = R31row.getCell(12);
			if (R31cell10 != null) {
				R31cell10.setCellValue(brf59a.getR31_interbank1() == null ? 0 : brf59a.getR31_interbank1().intValue());
			}
			Cell R31cell11 = R31row.getCell(13);
			if (R31cell11 != null) {
				R31cell11.setCellValue(brf59a.getR31_gov1() == null ? 0 : brf59a.getR31_gov1().intValue());
			}
			Cell R31cell12 = R31row.getCell(14);
			if (R31cell12 != null) {
				R31cell12.setCellValue(brf59a.getR31_corporate1() == null ? 0 : brf59a.getR31_corporate1().intValue());
			}
			Cell R31cell13 = R31row.getCell(15);
			if (R31cell13 != null) {
				R31cell13.setCellValue(brf59a.getR31_gre1() == null ? 0 : brf59a.getR31_gre1().intValue());
			}
			Cell R31cell14 = R31row.getCell(16);
			if (R31cell14 != null) {
				R31cell14.setCellValue(brf59a.getR31_trade1() == null ? 0 : brf59a.getR31_trade1().intValue());
			}
			Cell R31cell15 = R31row.getCell(17);
			if (R31cell15 != null) {
				R31cell15.setCellValue(
						brf59a.getR31_individuals1() == null ? 0 : brf59a.getR31_individuals1().intValue());
			}
			Cell R31cell16 = R31row.getCell(18);
			if (R31cell16 != null) {
				R31cell16
						.setCellValue(brf59a.getR31_investment1() == null ? 0 : brf59a.getR31_investment1().intValue());
			}
			Cell R31cell17 = R31row.getCell(19);
			if (R31cell17 != null) {
				R31cell17.setCellValue(brf59a.getR31_zer0() == null ? 0 : brf59a.getR31_zer0().intValue());
			}
			Cell R31cell18 = R31row.getCell(20);
			if (R31cell18 != null) {
				R31cell18.setCellValue(brf59a.getR31_three() == null ? 0 : brf59a.getR31_three().intValue());
			}
			Cell R31cell19 = R31row.getCell(21);
			if (R31cell19 != null) {
				R31cell19.setCellValue(brf59a.getR31_six() == null ? 0 : brf59a.getR31_six().intValue());
			}
			Cell R31cell20 = R31row.getCell(22);
			if (R31cell20 != null) {
				R31cell20.setCellValue(brf59a.getR31_oneyear() == null ? 0 : brf59a.getR31_oneyear().intValue());
			}
			Cell R31cell21 = R31row.getCell(23);
			if (R31cell21 != null) {
				R31cell21.setCellValue(brf59a.getR31_foreign() == null ? 0 : brf59a.getR31_foreign().intValue());
			}
			Cell R31cell22 = R31row.getCell(24);
			if (R31cell22 != null) {
				R31cell22.setCellValue(brf59a.getR31_banks() == null ? 0 : brf59a.getR31_banks().intValue());
			}
			Cell R31cell23 = R31row.getCell(25);
			if (R31cell23 != null) {
				R31cell23.setCellValue(brf59a.getR31_gov2() == null ? 0 : brf59a.getR31_gov2().intValue());
			}
			Cell R31cell24 = R31row.getCell(26);
			if (R31cell24 != null) {
				R31cell24.setCellValue(brf59a.getR31_other() == null ? 0 : brf59a.getR31_other().intValue());
			}
			Cell R31cell25 = R31row.getCell(27);
			if (R31cell25 != null) {
				R31cell25.setCellValue(brf59a.getR31_banks1() == null ? 0 : brf59a.getR31_banks1().intValue());
			}
			Cell R31cell26 = R31row.getCell(28);
			if (R31cell26 != null) {
				R31cell26.setCellValue(
						brf59a.getR31_individuals2() == null ? 0 : brf59a.getR31_individuals2().intValue());
			}
			Cell R31cell27 = R31row.getCell(29);
			if (R31cell27 != null) {
				R31cell27.setCellValue(brf59a.getR31_other1() == null ? 0 : brf59a.getR31_other1().intValue());
			}
			Cell R31cell28 = R31row.getCell(30);
			if (R31cell28 != null) {
				R31cell28.setCellValue(brf59a.getR31_banks2() == null ? 0 : brf59a.getR31_banks2().intValue());
			}
			Cell R31cell29 = R31row.getCell(31);
			if (R31cell29 != null) {
				R31cell29.setCellValue(brf59a.getR31_gov3() == null ? 0 : brf59a.getR31_gov3().intValue());
			}
			Cell R31cell30 = R31row.getCell(32);
			if (R31cell30 != null) {
				R31cell30.setCellValue(brf59a.getR31_others2() == null ? 0 : brf59a.getR31_others2().intValue());
			}
			Cell R31cell31 = R31row.getCell(33);
			if (R31cell31 != null) {
				R31cell31.setCellValue(brf59a.getR31_banks3() == null ? 0 : brf59a.getR31_banks3().intValue());
			}
			Cell R31cell32 = R31row.getCell(34);
			if (R31cell32 != null) {
				R31cell32.setCellValue(brf59a.getR31_gov4() == null ? 0 : brf59a.getR31_gov4().intValue());
			}
			Cell R31cell33 = R31row.getCell(35);
			if (R31cell33 != null) {
				R31cell33.setCellValue(brf59a.getR31_others3() == null ? 0 : brf59a.getR31_others3().intValue());
			}
			Cell R31cell34 = R31row.getCell(36);
			if (R31cell34 != null) {
				R31cell34.setCellValue(brf59a.getR31_foreign1() == null ? 0 : brf59a.getR31_foreign1().intValue());
			}
			Cell R31cell35 = R31row.getCell(37);
			if (R31cell35 != null) {
				R31cell35.setCellValue(brf59a.getR31_guarantees() == null ? 0 : brf59a.getR31_guarantees().intValue());
			}
			Cell R31cell36 = R31row.getCell(38);
			if (R31cell36 != null) {
				R31cell36.setCellValue(brf59a.getR31_nbfi2() == null ? 0 : brf59a.getR31_nbfi2().intValue());
			}
			Cell R31cell37 = R31row.getCell(39);
			if (R31cell37 != null) {
				R31cell37.setCellValue(brf59a.getR31_interbank2() == null ? 0 : brf59a.getR31_interbank2().intValue());
			}
			Cell R31cell38 = R31row.getCell(40);
			if (R31cell38 != null) {
				R31cell38.setCellValue(brf59a.getR31_gov5() == null ? 0 : brf59a.getR31_gov5().intValue());
			}
			Cell R31cell39 = R31row.getCell(41);
			if (R31cell39 != null) {
				R31cell39.setCellValue(brf59a.getR31_corporate2() == null ? 0 : brf59a.getR31_corporate2().intValue());
			}
			Cell R31cell40 = R31row.getCell(42);
			if (R31cell40 != null) {
				R31cell40.setCellValue(brf59a.getR31_gre2() == null ? 0 : brf59a.getR31_gre2().intValue());
			}
			Cell R31cell41 = R31row.getCell(43);
			if (R31cell41 != null) {
				R31cell41.setCellValue(
						brf59a.getR31_individuals3() == null ? 0 : brf59a.getR31_individuals3().intValue());
			}
			Cell R31cell42 = R31row.getCell(44);
			if (R31cell42 != null) {
				R31cell42.setCellValue(brf59a.getR31_zero1() == null ? 0 : brf59a.getR31_zero1().intValue());
			}
			Cell R31cell43 = R31row.getCell(45);
			if (R31cell43 != null) {
				R31cell43.setCellValue(brf59a.getR31_three1() == null ? 0 : brf59a.getR31_three1().intValue());
			}
			Cell R31cell44 = R31row.getCell(46);
			if (R31cell44 != null) {
				R31cell44.setCellValue(brf59a.getR31_six1() == null ? 0 : brf59a.getR31_six1().intValue());
			}
			Cell R31cell45 = R31row.getCell(47);
			if (R31cell45 != null) {
				R31cell45.setCellValue(brf59a.getR31_oneyear1() == null ? 0 : brf59a.getR31_oneyear1().intValue());
			}
			Cell R31cell46 = R31row.getCell(48);
			if (R31cell46 != null) {
				R31cell46.setCellValue(brf59a.getR31_empty() == null ? "" : brf59a.getR31_empty().toString());
			}
			Row R32row = sheet.getRow(49);
			Cell R32cell1 = R32row.getCell(3);
			if (R32cell1 != null) {
				R32cell1.setCellValue(brf59a.getR32_nbfi() == null ? 0 : brf59a.getR32_nbfi().intValue());
			}

			Cell R32cell2 = R32row.getCell(4);
			if (R32cell2 != null) {
				R32cell2.setCellValue(brf59a.getR32_interbank() == null ? 0 : brf59a.getR32_interbank().intValue());
			}
			Cell R32cell3 = R32row.getCell(5);
			if (R32cell3 != null) {
				R32cell3.setCellValue(brf59a.getR32_gov() == null ? 0 : brf59a.getR32_gov().intValue());
			}
			Cell R32cell4 = R32row.getCell(6);
			if (R32cell4 != null) {
				R32cell4.setCellValue(brf59a.getR32_corporate() == null ? 0 : brf59a.getR32_corporate().intValue());
			}
			Cell R32cell5 = R32row.getCell(7);
			if (R32cell5 != null) {
				R32cell5.setCellValue(brf59a.getR32_gre() == null ? 0 : brf59a.getR32_gre().intValue());
			}
			Cell R32cell6 = R32row.getCell(8);
			if (R32cell6 != null) {
				R32cell6.setCellValue(brf59a.getR32_trade() == null ? 0 : brf59a.getR32_trade().intValue());
			}
			Cell R32cell7 = R32row.getCell(9);
			if (R32cell7 != null) {
				R32cell7.setCellValue(brf59a.getR32_individuals() == null ? 0 : brf59a.getR32_individuals().intValue());
			}
			Cell R32cell8 = R32row.getCell(10);
			if (R32cell8 != null) {
				R32cell8.setCellValue(brf59a.getR32_investment() == null ? 0 : brf59a.getR32_investment().intValue());
			}
			Cell R32cell9 = R32row.getCell(11);
			if (R32cell9 != null) {
				R32cell9.setCellValue(brf59a.getR32_nbfi1() == null ? 0 : brf59a.getR32_nbfi1().intValue());
			}
			Cell R32cell10 = R32row.getCell(12);
			if (R32cell10 != null) {
				R32cell10.setCellValue(brf59a.getR32_interbank1() == null ? 0 : brf59a.getR32_interbank1().intValue());
			}
			Cell R32cell11 = R32row.getCell(13);
			if (R32cell11 != null) {
				R32cell11.setCellValue(brf59a.getR32_gov1() == null ? 0 : brf59a.getR32_gov1().intValue());
			}
			Cell R32cell12 = R32row.getCell(14);
			if (R32cell12 != null) {
				R32cell12.setCellValue(brf59a.getR32_corporate1() == null ? 0 : brf59a.getR32_corporate1().intValue());
			}
			Cell R32cell13 = R32row.getCell(15);
			if (R32cell13 != null) {
				R32cell13.setCellValue(brf59a.getR32_gre1() == null ? 0 : brf59a.getR32_gre1().intValue());
			}
			Cell R32cell14 = R32row.getCell(16);
			if (R32cell14 != null) {
				R32cell14.setCellValue(brf59a.getR32_trade1() == null ? 0 : brf59a.getR32_trade1().intValue());
			}
			Cell R32cell15 = R32row.getCell(17);
			if (R32cell15 != null) {
				R32cell15.setCellValue(
						brf59a.getR32_individuals1() == null ? 0 : brf59a.getR32_individuals1().intValue());
			}
			Cell R32cell16 = R32row.getCell(18);
			if (R32cell16 != null) {
				R32cell16
						.setCellValue(brf59a.getR32_investment1() == null ? 0 : brf59a.getR32_investment1().intValue());
			}
			Cell R32cell17 = R32row.getCell(19);
			if (R32cell17 != null) {
				R32cell17.setCellValue(brf59a.getR32_zer0() == null ? 0 : brf59a.getR32_zer0().intValue());
			}
			Cell R32cell18 = R32row.getCell(20);
			if (R32cell18 != null) {
				R32cell18.setCellValue(brf59a.getR32_three() == null ? 0 : brf59a.getR32_three().intValue());
			}
			Cell R32cell19 = R32row.getCell(21);
			if (R32cell19 != null) {
				R32cell19.setCellValue(brf59a.getR32_six() == null ? 0 : brf59a.getR32_six().intValue());
			}
			Cell R32cell20 = R32row.getCell(22);
			if (R32cell20 != null) {
				R32cell20.setCellValue(brf59a.getR32_oneyear() == null ? 0 : brf59a.getR32_oneyear().intValue());
			}
			Cell R32cell21 = R32row.getCell(23);
			if (R32cell21 != null) {
				R32cell21.setCellValue(brf59a.getR32_foreign() == null ? 0 : brf59a.getR32_foreign().intValue());
			}
			Cell R32cell22 = R32row.getCell(24);
			if (R32cell22 != null) {
				R32cell22.setCellValue(brf59a.getR32_banks() == null ? 0 : brf59a.getR32_banks().intValue());
			}
			Cell R32cell23 = R32row.getCell(25);
			if (R32cell23 != null) {
				R32cell23.setCellValue(brf59a.getR32_gov2() == null ? 0 : brf59a.getR32_gov2().intValue());
			}
			Cell R32cell24 = R32row.getCell(26);
			if (R32cell24 != null) {
				R32cell24.setCellValue(brf59a.getR32_other() == null ? 0 : brf59a.getR32_other().intValue());
			}
			Cell R32cell25 = R32row.getCell(27);
			if (R32cell25 != null) {
				R32cell25.setCellValue(brf59a.getR32_banks1() == null ? 0 : brf59a.getR32_banks1().intValue());
			}
			Cell R32cell26 = R32row.getCell(28);
			if (R32cell26 != null) {
				R32cell26.setCellValue(
						brf59a.getR32_individuals2() == null ? 0 : brf59a.getR32_individuals2().intValue());
			}
			Cell R32cell27 = R32row.getCell(29);
			if (R32cell27 != null) {
				R32cell27.setCellValue(brf59a.getR32_other1() == null ? 0 : brf59a.getR32_other1().intValue());
			}
			Cell R32cell28 = R32row.getCell(30);
			if (R32cell28 != null) {
				R32cell28.setCellValue(brf59a.getR32_banks2() == null ? 0 : brf59a.getR32_banks2().intValue());
			}
			Cell R32cell29 = R32row.getCell(31);
			if (R32cell29 != null) {
				R32cell29.setCellValue(brf59a.getR32_gov3() == null ? 0 : brf59a.getR32_gov3().intValue());
			}
			Cell R32cell30 = R32row.getCell(32);
			if (R32cell30 != null) {
				R32cell30.setCellValue(brf59a.getR32_others2() == null ? 0 : brf59a.getR32_others2().intValue());
			}
			Cell R32cell31 = R32row.getCell(33);
			if (R32cell31 != null) {
				R32cell31.setCellValue(brf59a.getR32_banks3() == null ? 0 : brf59a.getR32_banks3().intValue());
			}
			Cell R32cell32 = R32row.getCell(34);
			if (R32cell32 != null) {
				R32cell32.setCellValue(brf59a.getR32_gov4() == null ? 0 : brf59a.getR32_gov4().intValue());
			}
			Cell R32cell33 = R32row.getCell(35);
			if (R32cell33 != null) {
				R32cell33.setCellValue(brf59a.getR32_others3() == null ? 0 : brf59a.getR32_others3().intValue());
			}
			Cell R32cell34 = R32row.getCell(36);
			if (R32cell34 != null) {
				R32cell34.setCellValue(brf59a.getR32_foreign1() == null ? 0 : brf59a.getR32_foreign1().intValue());
			}
			Cell R32cell35 = R32row.getCell(37);
			if (R32cell35 != null) {
				R32cell35.setCellValue(brf59a.getR32_guarantees() == null ? 0 : brf59a.getR32_guarantees().intValue());
			}
			Cell R32cell36 = R32row.getCell(38);
			if (R32cell36 != null) {
				R32cell36.setCellValue(brf59a.getR32_nbfi2() == null ? 0 : brf59a.getR32_nbfi2().intValue());
			}
			Cell R32cell37 = R32row.getCell(39);
			if (R32cell37 != null) {
				R32cell37.setCellValue(brf59a.getR32_interbank2() == null ? 0 : brf59a.getR32_interbank2().intValue());
			}
			Cell R32cell38 = R32row.getCell(40);
			if (R32cell38 != null) {
				R32cell38.setCellValue(brf59a.getR32_gov5() == null ? 0 : brf59a.getR32_gov5().intValue());
			}
			Cell R32cell39 = R32row.getCell(41);
			if (R32cell39 != null) {
				R32cell39.setCellValue(brf59a.getR32_corporate2() == null ? 0 : brf59a.getR32_corporate2().intValue());
			}
			Cell R32cell40 = R32row.getCell(42);
			if (R32cell40 != null) {
				R32cell40.setCellValue(brf59a.getR32_gre2() == null ? 0 : brf59a.getR32_gre2().intValue());
			}
			Cell R32cell41 = R32row.getCell(43);
			if (R32cell41 != null) {
				R32cell41.setCellValue(
						brf59a.getR32_individuals3() == null ? 0 : brf59a.getR32_individuals3().intValue());
			}
			Cell R32cell42 = R32row.getCell(44);
			if (R32cell42 != null) {
				R32cell42.setCellValue(brf59a.getR32_zero1() == null ? 0 : brf59a.getR32_zero1().intValue());
			}
			Cell R32cell43 = R32row.getCell(45);
			if (R32cell43 != null) {
				R32cell43.setCellValue(brf59a.getR32_three1() == null ? 0 : brf59a.getR32_three1().intValue());
			}
			Cell R32cell44 = R32row.getCell(46);
			if (R32cell44 != null) {
				R32cell44.setCellValue(brf59a.getR32_six1() == null ? 0 : brf59a.getR32_six1().intValue());
			}
			Cell R32cell45 = R32row.getCell(47);
			if (R32cell45 != null) {
				R32cell45.setCellValue(brf59a.getR32_oneyear1() == null ? 0 : brf59a.getR32_oneyear1().intValue());
			}
			Cell R32cell46 = R32row.getCell(48);
			if (R32cell46 != null) {
				R32cell46.setCellValue(brf59a.getR32_empty() == null ? "" : brf59a.getR32_empty().toString());
			}
			Row R34row = sheet.getRow(51);
			Cell R34cell1 = R34row.getCell(3);
			if (R34cell1 != null) {
				R34cell1.setCellValue(brf59a.getR34_nbfi() == null ? 0 : brf59a.getR34_nbfi().intValue());
			}

			Cell R34cell2 = R34row.getCell(4);
			if (R34cell2 != null) {
				R34cell2.setCellValue(brf59a.getR34_interbank() == null ? 0 : brf59a.getR34_interbank().intValue());
			}
			Cell R34cell3 = R34row.getCell(5);
			if (R34cell3 != null) {
				R34cell3.setCellValue(brf59a.getR34_gov() == null ? 0 : brf59a.getR34_gov().intValue());
			}
			Cell R34cell4 = R34row.getCell(6);
			if (R34cell4 != null) {
				R34cell4.setCellValue(brf59a.getR34_corporate() == null ? 0 : brf59a.getR34_corporate().intValue());
			}
			Cell R34cell5 = R34row.getCell(7);
			if (R34cell5 != null) {
				R34cell5.setCellValue(brf59a.getR34_gre() == null ? 0 : brf59a.getR34_gre().intValue());
			}
			Cell R34cell6 = R34row.getCell(8);
			if (R34cell6 != null) {
				R34cell6.setCellValue(brf59a.getR34_trade() == null ? 0 : brf59a.getR34_trade().intValue());
			}
			Cell R34cell7 = R34row.getCell(9);
			if (R34cell7 != null) {
				R34cell7.setCellValue(brf59a.getR34_individuals() == null ? 0 : brf59a.getR34_individuals().intValue());
			}
			Cell R34cell8 = R34row.getCell(10);
			if (R34cell8 != null) {
				R34cell8.setCellValue(brf59a.getR34_investment() == null ? 0 : brf59a.getR34_investment().intValue());
			}
			Cell R34cell9 = R34row.getCell(11);
			if (R34cell9 != null) {
				R34cell9.setCellValue(brf59a.getR34_nbfi1() == null ? 0 : brf59a.getR34_nbfi1().intValue());
			}
			Cell R34cell10 = R34row.getCell(12);
			if (R34cell10 != null) {
				R34cell10.setCellValue(brf59a.getR34_interbank1() == null ? 0 : brf59a.getR34_interbank1().intValue());
			}
			Cell R34cell11 = R34row.getCell(13);
			if (R34cell11 != null) {
				R34cell11.setCellValue(brf59a.getR34_gov1() == null ? 0 : brf59a.getR34_gov1().intValue());
			}
			Cell R34cell12 = R34row.getCell(14);
			if (R34cell12 != null) {
				R34cell12.setCellValue(brf59a.getR34_corporate1() == null ? 0 : brf59a.getR34_corporate1().intValue());
			}
			Cell R34cell13 = R34row.getCell(15);
			if (R34cell13 != null) {
				R34cell13.setCellValue(brf59a.getR34_gre1() == null ? 0 : brf59a.getR34_gre1().intValue());
			}
			Cell R34cell14 = R34row.getCell(16);
			if (R34cell14 != null) {
				R34cell14.setCellValue(brf59a.getR34_trade1() == null ? 0 : brf59a.getR34_trade1().intValue());
			}
			Cell R34cell15 = R34row.getCell(17);
			if (R34cell15 != null) {
				R34cell15.setCellValue(
						brf59a.getR34_individuals1() == null ? 0 : brf59a.getR34_individuals1().intValue());
			}
			Cell R34cell16 = R34row.getCell(18);
			if (R34cell16 != null) {
				R34cell16
						.setCellValue(brf59a.getR34_investment1() == null ? 0 : brf59a.getR34_investment1().intValue());
			}
			Cell R34cell17 = R34row.getCell(19);
			if (R34cell17 != null) {
				R34cell17.setCellValue(brf59a.getR34_zer0() == null ? 0 : brf59a.getR34_zer0().intValue());
			}
			Cell R34cell18 = R34row.getCell(20);
			if (R34cell18 != null) {
				R34cell18.setCellValue(brf59a.getR34_three() == null ? 0 : brf59a.getR34_three().intValue());
			}
			Cell R34cell19 = R34row.getCell(21);
			if (R34cell19 != null) {
				R34cell19.setCellValue(brf59a.getR34_six() == null ? 0 : brf59a.getR34_six().intValue());
			}
			Cell R34cell20 = R34row.getCell(22);
			if (R34cell20 != null) {
				R34cell20.setCellValue(brf59a.getR34_oneyear() == null ? 0 : brf59a.getR34_oneyear().intValue());
			}
			Cell R34cell21 = R34row.getCell(23);
			if (R34cell21 != null) {
				R34cell21.setCellValue(brf59a.getR34_foreign() == null ? 0 : brf59a.getR34_foreign().intValue());
			}
			Cell R34cell22 = R34row.getCell(24);
			if (R34cell22 != null) {
				R34cell22.setCellValue(brf59a.getR34_banks() == null ? 0 : brf59a.getR34_banks().intValue());
			}
			Cell R34cell23 = R34row.getCell(25);
			if (R34cell23 != null) {
				R34cell23.setCellValue(brf59a.getR34_gov2() == null ? 0 : brf59a.getR34_gov2().intValue());
			}
			Cell R34cell24 = R34row.getCell(26);
			if (R34cell24 != null) {
				R34cell24.setCellValue(brf59a.getR34_other() == null ? 0 : brf59a.getR34_other().intValue());
			}
			Cell R34cell25 = R34row.getCell(27);
			if (R34cell25 != null) {
				R34cell25.setCellValue(brf59a.getR34_banks1() == null ? 0 : brf59a.getR34_banks1().intValue());
			}
			Cell R34cell26 = R34row.getCell(28);
			if (R34cell26 != null) {
				R34cell26.setCellValue(
						brf59a.getR34_individuals2() == null ? 0 : brf59a.getR34_individuals2().intValue());
			}
			Cell R34cell27 = R34row.getCell(29);
			if (R34cell27 != null) {
				R34cell27.setCellValue(brf59a.getR34_other1() == null ? 0 : brf59a.getR34_other1().intValue());
			}
			Cell R34cell28 = R34row.getCell(30);
			if (R34cell28 != null) {
				R34cell28.setCellValue(brf59a.getR34_banks2() == null ? 0 : brf59a.getR34_banks2().intValue());
			}
			Cell R34cell29 = R34row.getCell(31);
			if (R34cell29 != null) {
				R34cell29.setCellValue(brf59a.getR34_gov3() == null ? 0 : brf59a.getR34_gov3().intValue());
			}
			Cell R34cell30 = R34row.getCell(32);
			if (R34cell30 != null) {
				R34cell30.setCellValue(brf59a.getR34_others2() == null ? 0 : brf59a.getR34_others2().intValue());
			}
			Cell R34cell31 = R34row.getCell(33);
			if (R34cell31 != null) {
				R34cell31.setCellValue(brf59a.getR34_banks3() == null ? 0 : brf59a.getR34_banks3().intValue());
			}
			Cell R34cell32 = R34row.getCell(34);
			if (R34cell32 != null) {
				R34cell32.setCellValue(brf59a.getR34_gov4() == null ? 0 : brf59a.getR34_gov4().intValue());
			}
			Cell R34cell33 = R34row.getCell(35);
			if (R34cell33 != null) {
				R34cell33.setCellValue(brf59a.getR34_others3() == null ? 0 : brf59a.getR34_others3().intValue());
			}
			Cell R34cell34 = R34row.getCell(36);
			if (R34cell34 != null) {
				R34cell34.setCellValue(brf59a.getR34_foreign1() == null ? 0 : brf59a.getR34_foreign1().intValue());
			}
			Cell R34cell35 = R34row.getCell(37);
			if (R34cell35 != null) {
				R34cell35.setCellValue(brf59a.getR34_guarantees() == null ? 0 : brf59a.getR34_guarantees().intValue());
			}
			Cell R34cell36 = R34row.getCell(38);
			if (R34cell36 != null) {
				R34cell36.setCellValue(brf59a.getR34_nbfi2() == null ? 0 : brf59a.getR34_nbfi2().intValue());
			}
			Cell R34cell37 = R34row.getCell(39);
			if (R34cell37 != null) {
				R34cell37.setCellValue(brf59a.getR34_interbank2() == null ? 0 : brf59a.getR34_interbank2().intValue());
			}
			Cell R34cell38 = R34row.getCell(40);
			if (R34cell38 != null) {
				R34cell38.setCellValue(brf59a.getR34_gov5() == null ? 0 : brf59a.getR34_gov5().intValue());
			}
			Cell R34cell39 = R34row.getCell(41);
			if (R34cell39 != null) {
				R34cell39.setCellValue(brf59a.getR34_corporate2() == null ? 0 : brf59a.getR34_corporate2().intValue());
			}
			Cell R34cell40 = R34row.getCell(42);
			if (R34cell40 != null) {
				R34cell40.setCellValue(brf59a.getR34_gre2() == null ? 0 : brf59a.getR34_gre2().intValue());
			}
			Cell R34cell41 = R34row.getCell(43);
			if (R34cell41 != null) {
				R34cell41.setCellValue(
						brf59a.getR34_individuals3() == null ? 0 : brf59a.getR34_individuals3().intValue());
			}
			Cell R34cell42 = R34row.getCell(44);
			if (R34cell42 != null) {
				R34cell42.setCellValue(brf59a.getR34_zero1() == null ? 0 : brf59a.getR34_zero1().intValue());
			}
			Cell R34cell43 = R34row.getCell(45);
			if (R34cell43 != null) {
				R34cell43.setCellValue(brf59a.getR34_three1() == null ? 0 : brf59a.getR34_three1().intValue());
			}
			Cell R34cell44 = R34row.getCell(46);
			if (R34cell44 != null) {
				R34cell44.setCellValue(brf59a.getR34_six1() == null ? 0 : brf59a.getR34_six1().intValue());
			}
			Cell R34cell45 = R34row.getCell(47);
			if (R34cell45 != null) {
				R34cell45.setCellValue(brf59a.getR34_oneyear1() == null ? 0 : brf59a.getR34_oneyear1().intValue());
			}
			Cell R34cell46 = R34row.getCell(48);
			if (R34cell46 != null) {
				R34cell46.setCellValue(brf59a.getR34_empty() == null ? "" : brf59a.getR34_empty().toString());
			}
			Row R36row = sheet.getRow(53);
			Cell R36cell1 = R36row.getCell(3);
			if (R36cell1 != null) {
				R36cell1.setCellValue(brf59a.getR36_nbfi() == null ? 0 : brf59a.getR36_nbfi().intValue());
			}

			Cell R36cell2 = R36row.getCell(4);
			if (R36cell2 != null) {
				R36cell2.setCellValue(brf59a.getR36_interbank() == null ? 0 : brf59a.getR36_interbank().intValue());
			}
			Cell R36cell3 = R36row.getCell(5);
			if (R36cell3 != null) {
				R36cell3.setCellValue(brf59a.getR36_gov() == null ? 0 : brf59a.getR36_gov().intValue());
			}
			Cell R36cell4 = R36row.getCell(6);
			if (R36cell4 != null) {
				R36cell4.setCellValue(brf59a.getR36_corporate() == null ? 0 : brf59a.getR36_corporate().intValue());
			}
			Cell R36cell5 = R36row.getCell(7);
			if (R36cell5 != null) {
				R36cell5.setCellValue(brf59a.getR36_gre() == null ? 0 : brf59a.getR36_gre().intValue());
			}
			Cell R36cell6 = R36row.getCell(8);
			if (R36cell6 != null) {
				R36cell6.setCellValue(brf59a.getR36_trade() == null ? 0 : brf59a.getR36_trade().intValue());
			}
			Cell R36cell7 = R36row.getCell(9);
			if (R36cell7 != null) {
				R36cell7.setCellValue(brf59a.getR36_individuals() == null ? 0 : brf59a.getR36_individuals().intValue());
			}
			Cell R36cell8 = R36row.getCell(10);
			if (R36cell8 != null) {
				R36cell8.setCellValue(brf59a.getR36_investment() == null ? 0 : brf59a.getR36_investment().intValue());
			}
			Cell R36cell9 = R36row.getCell(11);
			if (R36cell9 != null) {
				R36cell9.setCellValue(brf59a.getR36_nbfi1() == null ? 0 : brf59a.getR36_nbfi1().intValue());
			}
			Cell R36cell10 = R36row.getCell(12);
			if (R36cell10 != null) {
				R36cell10.setCellValue(brf59a.getR36_interbank1() == null ? 0 : brf59a.getR36_interbank1().intValue());
			}
			Cell R36cell11 = R36row.getCell(13);
			if (R36cell11 != null) {
				R36cell11.setCellValue(brf59a.getR36_gov1() == null ? 0 : brf59a.getR36_gov1().intValue());
			}
			Cell R36cell12 = R36row.getCell(14);
			if (R36cell12 != null) {
				R36cell12.setCellValue(brf59a.getR36_corporate1() == null ? 0 : brf59a.getR36_corporate1().intValue());
			}
			Cell R36cell13 = R36row.getCell(15);
			if (R36cell13 != null) {
				R36cell13.setCellValue(brf59a.getR36_gre1() == null ? 0 : brf59a.getR36_gre1().intValue());
			}
			Cell R36cell14 = R36row.getCell(16);
			if (R36cell14 != null) {
				R36cell14.setCellValue(brf59a.getR36_trade1() == null ? 0 : brf59a.getR36_trade1().intValue());
			}
			Cell R36cell15 = R36row.getCell(17);
			if (R36cell15 != null) {
				R36cell15.setCellValue(
						brf59a.getR36_individuals1() == null ? 0 : brf59a.getR36_individuals1().intValue());
			}
			Cell R36cell16 = R36row.getCell(18);
			if (R36cell16 != null) {
				R36cell16
						.setCellValue(brf59a.getR36_investment1() == null ? 0 : brf59a.getR36_investment1().intValue());
			}
			Cell R36cell17 = R36row.getCell(19);
			if (R36cell17 != null) {
				R36cell17.setCellValue(brf59a.getR36_zer0() == null ? 0 : brf59a.getR36_zer0().intValue());
			}
			Cell R36cell18 = R36row.getCell(20);
			if (R36cell18 != null) {
				R36cell18.setCellValue(brf59a.getR36_three() == null ? 0 : brf59a.getR36_three().intValue());
			}
			Cell R36cell19 = R36row.getCell(21);
			if (R36cell19 != null) {
				R36cell19.setCellValue(brf59a.getR36_six() == null ? 0 : brf59a.getR36_six().intValue());
			}
			Cell R36cell20 = R36row.getCell(22);
			if (R36cell20 != null) {
				R36cell20.setCellValue(brf59a.getR36_oneyear() == null ? 0 : brf59a.getR36_oneyear().intValue());
			}
			Cell R36cell21 = R36row.getCell(23);
			if (R36cell21 != null) {
				R36cell21.setCellValue(brf59a.getR36_foreign() == null ? 0 : brf59a.getR36_foreign().intValue());
			}
			Cell R36cell22 = R36row.getCell(24);
			if (R36cell22 != null) {
				R36cell22.setCellValue(brf59a.getR36_banks() == null ? 0 : brf59a.getR36_banks().intValue());
			}
			Cell R36cell23 = R36row.getCell(25);
			if (R36cell23 != null) {
				R36cell23.setCellValue(brf59a.getR36_gov2() == null ? 0 : brf59a.getR36_gov2().intValue());
			}
			Cell R36cell24 = R36row.getCell(26);
			if (R36cell24 != null) {
				R36cell24.setCellValue(brf59a.getR36_other() == null ? 0 : brf59a.getR36_other().intValue());
			}
			Cell R36cell25 = R36row.getCell(27);
			if (R36cell25 != null) {
				R36cell25.setCellValue(brf59a.getR36_banks1() == null ? 0 : brf59a.getR36_banks1().intValue());
			}
			Cell R36cell26 = R36row.getCell(28);
			if (R36cell26 != null) {
				R36cell26.setCellValue(
						brf59a.getR36_individuals2() == null ? 0 : brf59a.getR36_individuals2().intValue());
			}
			Cell R36cell27 = R36row.getCell(29);
			if (R36cell27 != null) {
				R36cell27.setCellValue(brf59a.getR36_other1() == null ? 0 : brf59a.getR36_other1().intValue());
			}
			Cell R36cell28 = R36row.getCell(30);
			if (R36cell28 != null) {
				R36cell28.setCellValue(brf59a.getR36_banks2() == null ? 0 : brf59a.getR36_banks2().intValue());
			}
			Cell R36cell29 = R36row.getCell(31);
			if (R36cell29 != null) {
				R36cell29.setCellValue(brf59a.getR36_gov3() == null ? 0 : brf59a.getR36_gov3().intValue());
			}
			Cell R36cell30 = R36row.getCell(32);
			if (R36cell30 != null) {
				R36cell30.setCellValue(brf59a.getR36_others2() == null ? 0 : brf59a.getR36_others2().intValue());
			}
			Cell R36cell31 = R36row.getCell(33);
			if (R36cell31 != null) {
				R36cell31.setCellValue(brf59a.getR36_banks3() == null ? 0 : brf59a.getR36_banks3().intValue());
			}
			Cell R36cell32 = R36row.getCell(34);
			if (R36cell32 != null) {
				R36cell32.setCellValue(brf59a.getR36_gov4() == null ? 0 : brf59a.getR36_gov4().intValue());
			}
			Cell R36cell33 = R36row.getCell(35);
			if (R36cell33 != null) {
				R36cell33.setCellValue(brf59a.getR36_others3() == null ? 0 : brf59a.getR36_others3().intValue());
			}
			Cell R36cell34 = R36row.getCell(36);
			if (R36cell34 != null) {
				R36cell34.setCellValue(brf59a.getR36_foreign1() == null ? 0 : brf59a.getR36_foreign1().intValue());
			}
			Cell R36cell35 = R36row.getCell(37);
			if (R36cell35 != null) {
				R36cell35.setCellValue(brf59a.getR36_guarantees() == null ? 0 : brf59a.getR36_guarantees().intValue());
			}
			Cell R36cell36 = R36row.getCell(38);
			if (R36cell36 != null) {
				R36cell36.setCellValue(brf59a.getR36_nbfi2() == null ? 0 : brf59a.getR36_nbfi2().intValue());
			}
			Cell R36cell37 = R36row.getCell(39);
			if (R36cell37 != null) {
				R36cell37.setCellValue(brf59a.getR36_interbank2() == null ? 0 : brf59a.getR36_interbank2().intValue());
			}
			Cell R36cell38 = R36row.getCell(40);
			if (R36cell38 != null) {
				R36cell38.setCellValue(brf59a.getR36_gov5() == null ? 0 : brf59a.getR36_gov5().intValue());
			}
			Cell R36cell39 = R36row.getCell(41);
			if (R36cell39 != null) {
				R36cell39.setCellValue(brf59a.getR36_corporate2() == null ? 0 : brf59a.getR36_corporate2().intValue());
			}
			Cell R36cell40 = R36row.getCell(42);
			if (R36cell40 != null) {
				R36cell40.setCellValue(brf59a.getR36_gre2() == null ? 0 : brf59a.getR36_gre2().intValue());
			}
			Cell R36cell41 = R36row.getCell(43);
			if (R36cell41 != null) {
				R36cell41.setCellValue(
						brf59a.getR36_individuals3() == null ? 0 : brf59a.getR36_individuals3().intValue());
			}
			Cell R36cell42 = R36row.getCell(44);
			if (R36cell42 != null) {
				R36cell42.setCellValue(brf59a.getR36_zero1() == null ? 0 : brf59a.getR36_zero1().intValue());
			}
			Cell R36cell43 = R36row.getCell(45);
			if (R36cell43 != null) {
				R36cell43.setCellValue(brf59a.getR36_three1() == null ? 0 : brf59a.getR36_three1().intValue());
			}
			Cell R36cell44 = R36row.getCell(46);
			if (R36cell44 != null) {
				R36cell44.setCellValue(brf59a.getR36_six1() == null ? 0 : brf59a.getR36_six1().intValue());
			}
			Cell R36cell45 = R36row.getCell(47);
			if (R36cell45 != null) {
				R36cell45.setCellValue(brf59a.getR36_oneyear1() == null ? 0 : brf59a.getR36_oneyear1().intValue());
			}
			Cell R36cell46 = R36row.getCell(48);
			if (R36cell46 != null) {
				R36cell46.setCellValue(brf59a.getR36_empty() == null ? "" : brf59a.getR36_empty().toString());
			}
			Row R37row = sheet.getRow(54);
			Cell R37cell1 = R37row.getCell(3);
			if (R37cell1 != null) {
				R37cell1.setCellValue(brf59a.getR37_nbfi() == null ? 0 : brf59a.getR37_nbfi().intValue());
			}

			Cell R37cell2 = R37row.getCell(4);
			if (R37cell2 != null) {
				R37cell2.setCellValue(brf59a.getR37_interbank() == null ? 0 : brf59a.getR37_interbank().intValue());
			}
			Cell R37cell3 = R37row.getCell(5);
			if (R37cell3 != null) {
				R37cell3.setCellValue(brf59a.getR37_gov() == null ? 0 : brf59a.getR37_gov().intValue());
			}
			Cell R37cell4 = R37row.getCell(6);
			if (R37cell4 != null) {
				R37cell4.setCellValue(brf59a.getR37_corporate() == null ? 0 : brf59a.getR37_corporate().intValue());
			}
			Cell R37cell5 = R37row.getCell(7);
			if (R37cell5 != null) {
				R37cell5.setCellValue(brf59a.getR37_gre() == null ? 0 : brf59a.getR37_gre().intValue());
			}
			Cell R37cell6 = R37row.getCell(8);
			if (R37cell6 != null) {
				R37cell6.setCellValue(brf59a.getR37_trade() == null ? 0 : brf59a.getR37_trade().intValue());
			}
			Cell R37cell7 = R37row.getCell(9);
			if (R37cell7 != null) {
				R37cell7.setCellValue(brf59a.getR37_individuals() == null ? 0 : brf59a.getR37_individuals().intValue());
			}
			Cell R37cell8 = R37row.getCell(10);
			if (R37cell8 != null) {
				R37cell8.setCellValue(brf59a.getR37_investment() == null ? 0 : brf59a.getR37_investment().intValue());
			}
			Cell R37cell9 = R37row.getCell(11);
			if (R37cell9 != null) {
				R37cell9.setCellValue(brf59a.getR37_nbfi1() == null ? 0 : brf59a.getR37_nbfi1().intValue());
			}
			Cell R37cell10 = R37row.getCell(12);
			if (R37cell10 != null) {
				R37cell10.setCellValue(brf59a.getR37_interbank1() == null ? 0 : brf59a.getR37_interbank1().intValue());
			}
			Cell R37cell11 = R37row.getCell(13);
			if (R37cell11 != null) {
				R37cell11.setCellValue(brf59a.getR37_gov1() == null ? 0 : brf59a.getR37_gov1().intValue());
			}
			Cell R37cell12 = R37row.getCell(14);
			if (R37cell12 != null) {
				R37cell12.setCellValue(brf59a.getR37_corporate1() == null ? 0 : brf59a.getR37_corporate1().intValue());
			}
			Cell R37cell13 = R37row.getCell(15);
			if (R37cell13 != null) {
				R37cell13.setCellValue(brf59a.getR37_gre1() == null ? 0 : brf59a.getR37_gre1().intValue());
			}
			Cell R37cell14 = R37row.getCell(16);
			if (R37cell14 != null) {
				R37cell14.setCellValue(brf59a.getR37_trade1() == null ? 0 : brf59a.getR37_trade1().intValue());
			}
			Cell R37cell15 = R37row.getCell(17);
			if (R37cell15 != null) {
				R37cell15.setCellValue(
						brf59a.getR37_individuals1() == null ? 0 : brf59a.getR37_individuals1().intValue());
			}
			Cell R37cell16 = R37row.getCell(18);
			if (R37cell16 != null) {
				R37cell16
						.setCellValue(brf59a.getR37_investment1() == null ? 0 : brf59a.getR37_investment1().intValue());
			}
			Cell R37cell17 = R37row.getCell(19);
			if (R37cell17 != null) {
				R37cell17.setCellValue(brf59a.getR37_zer0() == null ? 0 : brf59a.getR37_zer0().intValue());
			}
			Cell R37cell18 = R37row.getCell(20);
			if (R37cell18 != null) {
				R37cell18.setCellValue(brf59a.getR37_three() == null ? 0 : brf59a.getR37_three().intValue());
			}
			Cell R37cell19 = R37row.getCell(21);
			if (R37cell19 != null) {
				R37cell19.setCellValue(brf59a.getR37_six() == null ? 0 : brf59a.getR37_six().intValue());
			}
			Cell R37cell20 = R37row.getCell(22);
			if (R37cell20 != null) {
				R37cell20.setCellValue(brf59a.getR37_oneyear() == null ? 0 : brf59a.getR37_oneyear().intValue());
			}
			Cell R37cell21 = R37row.getCell(23);
			if (R37cell21 != null) {
				R37cell21.setCellValue(brf59a.getR37_foreign() == null ? 0 : brf59a.getR37_foreign().intValue());
			}
			Cell R37cell22 = R37row.getCell(24);
			if (R37cell22 != null) {
				R37cell22.setCellValue(brf59a.getR37_banks() == null ? 0 : brf59a.getR37_banks().intValue());
			}
			Cell R37cell23 = R37row.getCell(25);
			if (R37cell23 != null) {
				R37cell23.setCellValue(brf59a.getR37_gov2() == null ? 0 : brf59a.getR37_gov2().intValue());
			}
			Cell R37cell24 = R37row.getCell(26);
			if (R37cell24 != null) {
				R37cell24.setCellValue(brf59a.getR37_other() == null ? 0 : brf59a.getR37_other().intValue());
			}
			Cell R37cell25 = R37row.getCell(27);
			if (R37cell25 != null) {
				R37cell25.setCellValue(brf59a.getR37_banks1() == null ? 0 : brf59a.getR37_banks1().intValue());
			}
			Cell R37cell26 = R37row.getCell(28);
			if (R37cell26 != null) {
				R37cell26.setCellValue(
						brf59a.getR37_individuals2() == null ? 0 : brf59a.getR37_individuals2().intValue());
			}
			Cell R37cell27 = R37row.getCell(29);
			if (R37cell27 != null) {
				R37cell27.setCellValue(brf59a.getR37_other1() == null ? 0 : brf59a.getR37_other1().intValue());
			}
			Cell R37cell28 = R37row.getCell(30);
			if (R37cell28 != null) {
				R37cell28.setCellValue(brf59a.getR37_banks2() == null ? 0 : brf59a.getR37_banks2().intValue());
			}
			Cell R37cell29 = R37row.getCell(31);
			if (R37cell29 != null) {
				R37cell29.setCellValue(brf59a.getR37_gov3() == null ? 0 : brf59a.getR37_gov3().intValue());
			}
			Cell R37cell30 = R37row.getCell(32);
			if (R37cell30 != null) {
				R37cell30.setCellValue(brf59a.getR37_others2() == null ? 0 : brf59a.getR37_others2().intValue());
			}
			Cell R37cell31 = R37row.getCell(33);
			if (R37cell31 != null) {
				R37cell31.setCellValue(brf59a.getR37_banks3() == null ? 0 : brf59a.getR37_banks3().intValue());
			}
			Cell R37cell32 = R37row.getCell(34);
			if (R37cell32 != null) {
				R37cell32.setCellValue(brf59a.getR37_gov4() == null ? 0 : brf59a.getR37_gov4().intValue());
			}
			Cell R37cell33 = R37row.getCell(35);
			if (R37cell33 != null) {
				R37cell33.setCellValue(brf59a.getR37_others3() == null ? 0 : brf59a.getR37_others3().intValue());
			}
			Cell R37cell34 = R37row.getCell(36);
			if (R37cell34 != null) {
				R37cell34.setCellValue(brf59a.getR37_foreign1() == null ? 0 : brf59a.getR37_foreign1().intValue());
			}
			Cell R37cell35 = R37row.getCell(37);
			if (R37cell35 != null) {
				R37cell35.setCellValue(brf59a.getR37_guarantees() == null ? 0 : brf59a.getR37_guarantees().intValue());
			}
			Cell R37cell36 = R37row.getCell(38);
			if (R37cell36 != null) {
				R37cell36.setCellValue(brf59a.getR37_nbfi2() == null ? 0 : brf59a.getR37_nbfi2().intValue());
			}
			Cell R37cell37 = R37row.getCell(39);
			if (R37cell37 != null) {
				R37cell37.setCellValue(brf59a.getR37_interbank2() == null ? 0 : brf59a.getR37_interbank2().intValue());
			}
			Cell R37cell38 = R37row.getCell(40);
			if (R37cell38 != null) {
				R37cell38.setCellValue(brf59a.getR37_gov5() == null ? 0 : brf59a.getR37_gov5().intValue());
			}
			Cell R37cell39 = R37row.getCell(41);
			if (R37cell39 != null) {
				R37cell39.setCellValue(brf59a.getR37_corporate2() == null ? 0 : brf59a.getR37_corporate2().intValue());
			}
			Cell R37cell40 = R37row.getCell(42);
			if (R37cell40 != null) {
				R37cell40.setCellValue(brf59a.getR37_gre2() == null ? 0 : brf59a.getR37_gre2().intValue());
			}
			Cell R37cell41 = R37row.getCell(43);
			if (R37cell41 != null) {
				R37cell41.setCellValue(
						brf59a.getR37_individuals3() == null ? 0 : brf59a.getR37_individuals3().intValue());
			}
			Cell R37cell42 = R37row.getCell(44);
			if (R37cell42 != null) {
				R37cell42.setCellValue(brf59a.getR37_zero1() == null ? 0 : brf59a.getR37_zero1().intValue());
			}
			Cell R37cell43 = R37row.getCell(45);
			if (R37cell43 != null) {
				R37cell43.setCellValue(brf59a.getR37_three1() == null ? 0 : brf59a.getR37_three1().intValue());
			}
			Cell R37cell44 = R37row.getCell(46);
			if (R37cell44 != null) {
				R37cell44.setCellValue(brf59a.getR37_six1() == null ? 0 : brf59a.getR37_six1().intValue());
			}
			Cell R37cell45 = R37row.getCell(47);
			if (R37cell45 != null) {
				R37cell45.setCellValue(brf59a.getR37_oneyear1() == null ? 0 : brf59a.getR37_oneyear1().intValue());
			}
			Cell R37cell46 = R37row.getCell(48);
			if (R37cell46 != null) {
				R37cell46.setCellValue(brf59a.getR37_empty() == null ? "" : brf59a.getR37_empty().toString());
			}
			Row R38row = sheet.getRow(55);
			Cell R38cell1 = R38row.getCell(3);
			if (R38cell1 != null) {
				R38cell1.setCellValue(brf59a.getR38_nbfi() == null ? 0 : brf59a.getR38_nbfi().intValue());
			}

			Cell R38cell2 = R38row.getCell(4);
			if (R38cell2 != null) {
				R38cell2.setCellValue(brf59a.getR38_interbank() == null ? 0 : brf59a.getR38_interbank().intValue());
			}
			Cell R38cell3 = R38row.getCell(5);
			if (R38cell3 != null) {
				R38cell3.setCellValue(brf59a.getR38_gov() == null ? 0 : brf59a.getR38_gov().intValue());
			}
			Cell R38cell4 = R38row.getCell(6);
			if (R38cell4 != null) {
				R38cell4.setCellValue(brf59a.getR38_corporate() == null ? 0 : brf59a.getR38_corporate().intValue());
			}
			Cell R38cell5 = R38row.getCell(7);
			if (R38cell5 != null) {
				R38cell5.setCellValue(brf59a.getR38_gre() == null ? 0 : brf59a.getR38_gre().intValue());
			}
			Cell R38cell6 = R38row.getCell(8);
			if (R38cell6 != null) {
				R38cell6.setCellValue(brf59a.getR38_trade() == null ? 0 : brf59a.getR38_trade().intValue());
			}
			Cell R38cell7 = R38row.getCell(9);
			if (R38cell7 != null) {
				R38cell7.setCellValue(brf59a.getR38_individuals() == null ? 0 : brf59a.getR38_individuals().intValue());
			}
			Cell R38cell8 = R38row.getCell(10);
			if (R38cell8 != null) {
				R38cell8.setCellValue(brf59a.getR38_investment() == null ? 0 : brf59a.getR38_investment().intValue());
			}
			Cell R38cell9 = R38row.getCell(11);
			if (R38cell9 != null) {
				R38cell9.setCellValue(brf59a.getR38_nbfi1() == null ? 0 : brf59a.getR38_nbfi1().intValue());
			}
			Cell R38cell10 = R38row.getCell(12);
			if (R38cell10 != null) {
				R38cell10.setCellValue(brf59a.getR38_interbank1() == null ? 0 : brf59a.getR38_interbank1().intValue());
			}
			Cell R38cell11 = R38row.getCell(13);
			if (R38cell11 != null) {
				R38cell11.setCellValue(brf59a.getR38_gov1() == null ? 0 : brf59a.getR38_gov1().intValue());
			}
			Cell R38cell12 = R38row.getCell(14);
			if (R38cell12 != null) {
				R38cell12.setCellValue(brf59a.getR38_corporate1() == null ? 0 : brf59a.getR38_corporate1().intValue());
			}
			Cell R38cell13 = R38row.getCell(15);
			if (R38cell13 != null) {
				R38cell13.setCellValue(brf59a.getR38_gre1() == null ? 0 : brf59a.getR38_gre1().intValue());
			}
			Cell R38cell14 = R38row.getCell(16);
			if (R38cell14 != null) {
				R38cell14.setCellValue(brf59a.getR38_trade1() == null ? 0 : brf59a.getR38_trade1().intValue());
			}
			Cell R38cell15 = R38row.getCell(17);
			if (R38cell15 != null) {
				R38cell15.setCellValue(
						brf59a.getR38_individuals1() == null ? 0 : brf59a.getR38_individuals1().intValue());
			}
			Cell R38cell16 = R38row.getCell(18);
			if (R38cell16 != null) {
				R38cell16
						.setCellValue(brf59a.getR38_investment1() == null ? 0 : brf59a.getR38_investment1().intValue());
			}
			Cell R38cell17 = R38row.getCell(19);
			if (R38cell17 != null) {
				R38cell17.setCellValue(brf59a.getR38_zer0() == null ? 0 : brf59a.getR38_zer0().intValue());
			}
			Cell R38cell18 = R38row.getCell(20);
			if (R38cell18 != null) {
				R38cell18.setCellValue(brf59a.getR38_three() == null ? 0 : brf59a.getR38_three().intValue());
			}
			Cell R38cell19 = R38row.getCell(21);
			if (R38cell19 != null) {
				R38cell19.setCellValue(brf59a.getR38_six() == null ? 0 : brf59a.getR38_six().intValue());
			}
			Cell R38cell20 = R38row.getCell(22);
			if (R38cell20 != null) {
				R38cell20.setCellValue(brf59a.getR38_oneyear() == null ? 0 : brf59a.getR38_oneyear().intValue());
			}
			Cell R38cell21 = R38row.getCell(23);
			if (R38cell21 != null) {
				R38cell21.setCellValue(brf59a.getR38_foreign() == null ? 0 : brf59a.getR38_foreign().intValue());
			}
			Cell R38cell22 = R38row.getCell(24);
			if (R38cell22 != null) {
				R38cell22.setCellValue(brf59a.getR38_banks() == null ? 0 : brf59a.getR38_banks().intValue());
			}
			Cell R38cell23 = R38row.getCell(25);
			if (R38cell23 != null) {
				R38cell23.setCellValue(brf59a.getR38_gov2() == null ? 0 : brf59a.getR38_gov2().intValue());
			}
			Cell R38cell24 = R38row.getCell(26);
			if (R38cell24 != null) {
				R38cell24.setCellValue(brf59a.getR38_other() == null ? 0 : brf59a.getR38_other().intValue());
			}
			Cell R38cell25 = R38row.getCell(27);
			if (R38cell25 != null) {
				R38cell25.setCellValue(brf59a.getR38_banks1() == null ? 0 : brf59a.getR38_banks1().intValue());
			}
			Cell R38cell26 = R38row.getCell(28);
			if (R38cell26 != null) {
				R38cell26.setCellValue(
						brf59a.getR38_individuals2() == null ? 0 : brf59a.getR38_individuals2().intValue());
			}
			Cell R38cell27 = R38row.getCell(29);
			if (R38cell27 != null) {
				R38cell27.setCellValue(brf59a.getR38_other1() == null ? 0 : brf59a.getR38_other1().intValue());
			}
			Cell R38cell28 = R38row.getCell(30);
			if (R38cell28 != null) {
				R38cell28.setCellValue(brf59a.getR38_banks2() == null ? 0 : brf59a.getR38_banks2().intValue());
			}
			Cell R38cell29 = R38row.getCell(31);
			if (R38cell29 != null) {
				R38cell29.setCellValue(brf59a.getR38_gov3() == null ? 0 : brf59a.getR38_gov3().intValue());
			}
			Cell R38cell30 = R38row.getCell(32);
			if (R38cell30 != null) {
				R38cell30.setCellValue(brf59a.getR38_others2() == null ? 0 : brf59a.getR38_others2().intValue());
			}
			Cell R38cell31 = R38row.getCell(33);
			if (R38cell31 != null) {
				R38cell31.setCellValue(brf59a.getR38_banks3() == null ? 0 : brf59a.getR38_banks3().intValue());
			}
			Cell R38cell32 = R38row.getCell(34);
			if (R38cell32 != null) {
				R38cell32.setCellValue(brf59a.getR38_gov4() == null ? 0 : brf59a.getR38_gov4().intValue());
			}
			Cell R38cell33 = R38row.getCell(35);
			if (R38cell33 != null) {
				R38cell33.setCellValue(brf59a.getR38_others3() == null ? 0 : brf59a.getR38_others3().intValue());
			}
			Cell R38cell34 = R38row.getCell(36);
			if (R38cell34 != null) {
				R38cell34.setCellValue(brf59a.getR38_foreign1() == null ? 0 : brf59a.getR38_foreign1().intValue());
			}
			Cell R38cell35 = R38row.getCell(37);
			if (R38cell35 != null) {
				R38cell35.setCellValue(brf59a.getR38_guarantees() == null ? 0 : brf59a.getR38_guarantees().intValue());
			}
			Cell R38cell36 = R38row.getCell(38);
			if (R38cell36 != null) {
				R38cell36.setCellValue(brf59a.getR38_nbfi2() == null ? 0 : brf59a.getR38_nbfi2().intValue());
			}
			Cell R38cell37 = R38row.getCell(39);
			if (R38cell37 != null) {
				R38cell37.setCellValue(brf59a.getR38_interbank2() == null ? 0 : brf59a.getR38_interbank2().intValue());
			}
			Cell R38cell38 = R38row.getCell(40);
			if (R38cell38 != null) {
				R38cell38.setCellValue(brf59a.getR38_gov5() == null ? 0 : brf59a.getR38_gov5().intValue());
			}
			Cell R38cell39 = R38row.getCell(41);
			if (R38cell39 != null) {
				R38cell39.setCellValue(brf59a.getR38_corporate2() == null ? 0 : brf59a.getR38_corporate2().intValue());
			}
			Cell R38cell40 = R38row.getCell(42);
			if (R38cell40 != null) {
				R38cell40.setCellValue(brf59a.getR38_gre2() == null ? 0 : brf59a.getR38_gre2().intValue());
			}
			Cell R38cell41 = R38row.getCell(43);
			if (R38cell41 != null) {
				R38cell41.setCellValue(
						brf59a.getR38_individuals3() == null ? 0 : brf59a.getR38_individuals3().intValue());
			}
			Cell R38cell42 = R38row.getCell(44);
			if (R38cell42 != null) {
				R38cell42.setCellValue(brf59a.getR38_zero1() == null ? 0 : brf59a.getR38_zero1().intValue());
			}
			Cell R38cell43 = R38row.getCell(45);
			if (R38cell43 != null) {
				R38cell43.setCellValue(brf59a.getR38_three1() == null ? 0 : brf59a.getR38_three1().intValue());
			}
			Cell R38cell44 = R38row.getCell(46);
			if (R38cell44 != null) {
				R38cell44.setCellValue(brf59a.getR38_six1() == null ? 0 : brf59a.getR38_six1().intValue());
			}
			Cell R38cell45 = R38row.getCell(47);
			if (R38cell45 != null) {
				R38cell45.setCellValue(brf59a.getR38_oneyear1() == null ? 0 : brf59a.getR38_oneyear1().intValue());
			}
			Cell R38cell46 = R38row.getCell(48);
			if (R38cell46 != null) {
				R38cell46.setCellValue(brf59a.getR38_empty() == null ? "" : brf59a.getR38_empty().toString());
			}
			Row R39row = sheet.getRow(56);
			Cell R39cell1 = R39row.getCell(3);
			if (R39cell1 != null) {
				R39cell1.setCellValue(brf59a.getR39_nbfi() == null ? 0 : brf59a.getR39_nbfi().intValue());
			}

			Cell R39cell2 = R39row.getCell(4);
			if (R39cell2 != null) {
				R39cell2.setCellValue(brf59a.getR39_interbank() == null ? 0 : brf59a.getR39_interbank().intValue());
			}
			Cell R39cell3 = R39row.getCell(5);
			if (R39cell3 != null) {
				R39cell3.setCellValue(brf59a.getR39_gov() == null ? 0 : brf59a.getR39_gov().intValue());
			}
			Cell R39cell4 = R39row.getCell(6);
			if (R39cell4 != null) {
				R39cell4.setCellValue(brf59a.getR39_corporate() == null ? 0 : brf59a.getR39_corporate().intValue());
			}
			Cell R39cell5 = R39row.getCell(7);
			if (R39cell5 != null) {
				R39cell5.setCellValue(brf59a.getR39_gre() == null ? 0 : brf59a.getR39_gre().intValue());
			}
			Cell R39cell6 = R39row.getCell(8);
			if (R39cell6 != null) {
				R39cell6.setCellValue(brf59a.getR39_trade() == null ? 0 : brf59a.getR39_trade().intValue());
			}
			Cell R39cell7 = R39row.getCell(9);
			if (R39cell7 != null) {
				R39cell7.setCellValue(brf59a.getR39_individuals() == null ? 0 : brf59a.getR39_individuals().intValue());
			}
			Cell R39cell8 = R39row.getCell(10);
			if (R39cell8 != null) {
				R39cell8.setCellValue(brf59a.getR39_investment() == null ? 0 : brf59a.getR39_investment().intValue());
			}
			Cell R39cell9 = R39row.getCell(11);
			if (R39cell9 != null) {
				R39cell9.setCellValue(brf59a.getR39_nbfi1() == null ? 0 : brf59a.getR39_nbfi1().intValue());
			}
			Cell R39cell10 = R39row.getCell(12);
			if (R39cell10 != null) {
				R39cell10.setCellValue(brf59a.getR39_interbank1() == null ? 0 : brf59a.getR39_interbank1().intValue());
			}
			Cell R39cell11 = R39row.getCell(13);
			if (R39cell11 != null) {
				R39cell11.setCellValue(brf59a.getR39_gov1() == null ? 0 : brf59a.getR39_gov1().intValue());
			}
			Cell R39cell12 = R39row.getCell(14);
			if (R39cell12 != null) {
				R39cell12.setCellValue(brf59a.getR39_corporate1() == null ? 0 : brf59a.getR39_corporate1().intValue());
			}
			Cell R39cell13 = R39row.getCell(15);
			if (R39cell13 != null) {
				R39cell13.setCellValue(brf59a.getR39_gre1() == null ? 0 : brf59a.getR39_gre1().intValue());
			}
			Cell R39cell14 = R39row.getCell(16);
			if (R39cell14 != null) {
				R39cell14.setCellValue(brf59a.getR39_trade1() == null ? 0 : brf59a.getR39_trade1().intValue());
			}
			Cell R39cell15 = R39row.getCell(17);
			if (R39cell15 != null) {
				R39cell15.setCellValue(
						brf59a.getR39_individuals1() == null ? 0 : brf59a.getR39_individuals1().intValue());
			}
			Cell R39cell16 = R39row.getCell(18);
			if (R39cell16 != null) {
				R39cell16
						.setCellValue(brf59a.getR39_investment1() == null ? 0 : brf59a.getR39_investment1().intValue());
			}
			Cell R39cell17 = R39row.getCell(19);
			if (R39cell17 != null) {
				R39cell17.setCellValue(brf59a.getR39_zer0() == null ? 0 : brf59a.getR39_zer0().intValue());
			}
			Cell R39cell18 = R39row.getCell(20);
			if (R39cell18 != null) {
				R39cell18.setCellValue(brf59a.getR39_three() == null ? 0 : brf59a.getR39_three().intValue());
			}
			Cell R39cell19 = R39row.getCell(21);
			if (R39cell19 != null) {
				R39cell19.setCellValue(brf59a.getR39_six() == null ? 0 : brf59a.getR39_six().intValue());
			}
			Cell R39cell20 = R39row.getCell(22);
			if (R39cell20 != null) {
				R39cell20.setCellValue(brf59a.getR39_oneyear() == null ? 0 : brf59a.getR39_oneyear().intValue());
			}
			Cell R39cell21 = R39row.getCell(23);
			if (R39cell21 != null) {
				R39cell21.setCellValue(brf59a.getR39_foreign() == null ? 0 : brf59a.getR39_foreign().intValue());
			}
			Cell R39cell22 = R39row.getCell(24);
			if (R39cell22 != null) {
				R39cell22.setCellValue(brf59a.getR39_banks() == null ? 0 : brf59a.getR39_banks().intValue());
			}
			Cell R39cell23 = R39row.getCell(25);
			if (R39cell23 != null) {
				R39cell23.setCellValue(brf59a.getR39_gov2() == null ? 0 : brf59a.getR39_gov2().intValue());
			}
			Cell R39cell24 = R39row.getCell(26);
			if (R39cell24 != null) {
				R39cell24.setCellValue(brf59a.getR39_other() == null ? 0 : brf59a.getR39_other().intValue());
			}
			Cell R39cell25 = R39row.getCell(27);
			if (R39cell25 != null) {
				R39cell25.setCellValue(brf59a.getR39_banks1() == null ? 0 : brf59a.getR39_banks1().intValue());
			}
			Cell R39cell26 = R39row.getCell(28);
			if (R39cell26 != null) {
				R39cell26.setCellValue(
						brf59a.getR39_individuals2() == null ? 0 : brf59a.getR39_individuals2().intValue());
			}
			Cell R39cell27 = R39row.getCell(29);
			if (R39cell27 != null) {
				R39cell27.setCellValue(brf59a.getR39_other1() == null ? 0 : brf59a.getR39_other1().intValue());
			}
			Cell R39cell28 = R39row.getCell(30);
			if (R39cell28 != null) {
				R39cell28.setCellValue(brf59a.getR39_banks2() == null ? 0 : brf59a.getR39_banks2().intValue());
			}
			Cell R39cell29 = R39row.getCell(31);
			if (R39cell29 != null) {
				R39cell29.setCellValue(brf59a.getR39_gov3() == null ? 0 : brf59a.getR39_gov3().intValue());
			}
			Cell R39cell30 = R39row.getCell(32);
			if (R39cell30 != null) {
				R39cell30.setCellValue(brf59a.getR39_others2() == null ? 0 : brf59a.getR39_others2().intValue());
			}
			Cell R39cell31 = R39row.getCell(33);
			if (R39cell31 != null) {
				R39cell31.setCellValue(brf59a.getR39_banks3() == null ? 0 : brf59a.getR39_banks3().intValue());
			}
			Cell R39cell32 = R39row.getCell(34);
			if (R39cell32 != null) {
				R39cell32.setCellValue(brf59a.getR39_gov4() == null ? 0 : brf59a.getR39_gov4().intValue());
			}
			Cell R39cell33 = R39row.getCell(35);
			if (R39cell33 != null) {
				R39cell33.setCellValue(brf59a.getR39_others3() == null ? 0 : brf59a.getR39_others3().intValue());
			}
			Cell R39cell34 = R39row.getCell(36);
			if (R39cell34 != null) {
				R39cell34.setCellValue(brf59a.getR39_foreign1() == null ? 0 : brf59a.getR39_foreign1().intValue());
			}
			Cell R39cell35 = R39row.getCell(37);
			if (R39cell35 != null) {
				R39cell35.setCellValue(brf59a.getR39_guarantees() == null ? 0 : brf59a.getR39_guarantees().intValue());
			}
			Cell R39cell36 = R39row.getCell(38);
			if (R39cell36 != null) {
				R39cell36.setCellValue(brf59a.getR39_nbfi2() == null ? 0 : brf59a.getR39_nbfi2().intValue());
			}
			Cell R39cell37 = R39row.getCell(39);
			if (R39cell37 != null) {
				R39cell37.setCellValue(brf59a.getR39_interbank2() == null ? 0 : brf59a.getR39_interbank2().intValue());
			}
			Cell R39cell38 = R39row.getCell(40);
			if (R39cell38 != null) {
				R39cell38.setCellValue(brf59a.getR39_gov5() == null ? 0 : brf59a.getR39_gov5().intValue());
			}
			Cell R39cell39 = R39row.getCell(41);
			if (R39cell39 != null) {
				R39cell39.setCellValue(brf59a.getR39_corporate2() == null ? 0 : brf59a.getR39_corporate2().intValue());
			}
			Cell R39cell40 = R39row.getCell(42);
			if (R39cell40 != null) {
				R39cell40.setCellValue(brf59a.getR39_gre2() == null ? 0 : brf59a.getR39_gre2().intValue());
			}
			Cell R39cell41 = R39row.getCell(43);
			if (R39cell41 != null) {
				R39cell41.setCellValue(
						brf59a.getR39_individuals3() == null ? 0 : brf59a.getR39_individuals3().intValue());
			}
			Cell R39cell42 = R39row.getCell(44);
			if (R39cell42 != null) {
				R39cell42.setCellValue(brf59a.getR39_zero1() == null ? 0 : brf59a.getR39_zero1().intValue());
			}
			Cell R39cell43 = R39row.getCell(45);
			if (R39cell43 != null) {
				R39cell43.setCellValue(brf59a.getR39_three1() == null ? 0 : brf59a.getR39_three1().intValue());
			}
			Cell R39cell44 = R39row.getCell(46);
			if (R39cell44 != null) {
				R39cell44.setCellValue(brf59a.getR39_six1() == null ? 0 : brf59a.getR39_six1().intValue());
			}
			Cell R39cell45 = R39row.getCell(47);
			if (R39cell45 != null) {
				R39cell45.setCellValue(brf59a.getR39_oneyear1() == null ? 0 : brf59a.getR39_oneyear1().intValue());
			}
			Cell R39cell46 = R39row.getCell(48);
			if (R39cell46 != null) {
				R39cell46.setCellValue(brf59a.getR39_empty() == null ? "" : brf59a.getR39_empty().toString());
			}
			Row R40row = sheet.getRow(57);
			Cell R40cell1 = R40row.getCell(3);
			if (R40cell1 != null) {
				R40cell1.setCellValue(brf59a.getR40_nbfi() == null ? 0 : brf59a.getR40_nbfi().intValue());
			}

			Cell R40cell2 = R40row.getCell(4);
			if (R40cell2 != null) {
				R40cell2.setCellValue(brf59a.getR40_interbank() == null ? 0 : brf59a.getR40_interbank().intValue());
			}
			Cell R40cell3 = R40row.getCell(5);
			if (R40cell3 != null) {
				R40cell3.setCellValue(brf59a.getR40_gov() == null ? 0 : brf59a.getR40_gov().intValue());
			}
			Cell R40cell4 = R40row.getCell(6);
			if (R40cell4 != null) {
				R40cell4.setCellValue(brf59a.getR40_corporate() == null ? 0 : brf59a.getR40_corporate().intValue());
			}
			Cell R40cell5 = R40row.getCell(7);
			if (R40cell5 != null) {
				R40cell5.setCellValue(brf59a.getR40_gre() == null ? 0 : brf59a.getR40_gre().intValue());
			}
			Cell R40cell6 = R40row.getCell(8);
			if (R40cell6 != null) {
				R40cell6.setCellValue(brf59a.getR40_trade() == null ? 0 : brf59a.getR40_trade().intValue());
			}
			Cell R40cell7 = R40row.getCell(9);
			if (R40cell7 != null) {
				R40cell7.setCellValue(brf59a.getR40_individuals() == null ? 0 : brf59a.getR40_individuals().intValue());
			}
			Cell R40cell8 = R40row.getCell(10);
			if (R40cell8 != null) {
				R40cell8.setCellValue(brf59a.getR40_investment() == null ? 0 : brf59a.getR40_investment().intValue());
			}
			Cell R40cell9 = R40row.getCell(11);
			if (R40cell9 != null) {
				R40cell9.setCellValue(brf59a.getR40_nbfi1() == null ? 0 : brf59a.getR40_nbfi1().intValue());
			}
			Cell R40cell10 = R40row.getCell(12);
			if (R40cell10 != null) {
				R40cell10.setCellValue(brf59a.getR40_interbank1() == null ? 0 : brf59a.getR40_interbank1().intValue());
			}
			Cell R40cell11 = R40row.getCell(13);
			if (R40cell11 != null) {
				R40cell11.setCellValue(brf59a.getR40_gov1() == null ? 0 : brf59a.getR40_gov1().intValue());
			}
			Cell R40cell12 = R40row.getCell(14);
			if (R40cell12 != null) {
				R40cell12.setCellValue(brf59a.getR40_corporate1() == null ? 0 : brf59a.getR40_corporate1().intValue());
			}
			Cell R40cell13 = R40row.getCell(15);
			if (R40cell13 != null) {
				R40cell13.setCellValue(brf59a.getR40_gre1() == null ? 0 : brf59a.getR40_gre1().intValue());
			}
			Cell R40cell14 = R40row.getCell(16);
			if (R40cell14 != null) {
				R40cell14.setCellValue(brf59a.getR40_trade1() == null ? 0 : brf59a.getR40_trade1().intValue());
			}
			Cell R40cell15 = R40row.getCell(17);
			if (R40cell15 != null) {
				R40cell15.setCellValue(
						brf59a.getR40_individuals1() == null ? 0 : brf59a.getR40_individuals1().intValue());
			}
			Cell R40cell16 = R40row.getCell(18);
			if (R40cell16 != null) {
				R40cell16
						.setCellValue(brf59a.getR40_investment1() == null ? 0 : brf59a.getR40_investment1().intValue());
			}
			Cell R40cell17 = R40row.getCell(19);
			if (R40cell17 != null) {
				R40cell17.setCellValue(brf59a.getR40_zer0() == null ? 0 : brf59a.getR40_zer0().intValue());
			}
			Cell R40cell18 = R40row.getCell(20);
			if (R40cell18 != null) {
				R40cell18.setCellValue(brf59a.getR40_three() == null ? 0 : brf59a.getR40_three().intValue());
			}
			Cell R40cell19 = R40row.getCell(21);
			if (R40cell19 != null) {
				R40cell19.setCellValue(brf59a.getR40_six() == null ? 0 : brf59a.getR40_six().intValue());
			}
			Cell R40cell20 = R40row.getCell(22);
			if (R40cell20 != null) {
				R40cell20.setCellValue(brf59a.getR40_oneyear() == null ? 0 : brf59a.getR40_oneyear().intValue());
			}
			Cell R40cell21 = R40row.getCell(23);
			if (R40cell21 != null) {
				R40cell21.setCellValue(brf59a.getR40_foreign() == null ? 0 : brf59a.getR40_foreign().intValue());
			}
			Cell R40cell22 = R40row.getCell(24);
			if (R40cell22 != null) {
				R40cell22.setCellValue(brf59a.getR40_banks() == null ? 0 : brf59a.getR40_banks().intValue());
			}
			Cell R40cell23 = R40row.getCell(25);
			if (R40cell23 != null) {
				R40cell23.setCellValue(brf59a.getR40_gov2() == null ? 0 : brf59a.getR40_gov2().intValue());
			}
			Cell R40cell24 = R40row.getCell(26);
			if (R40cell24 != null) {
				R40cell24.setCellValue(brf59a.getR40_other() == null ? 0 : brf59a.getR40_other().intValue());
			}
			Cell R40cell25 = R40row.getCell(27);
			if (R40cell25 != null) {
				R40cell25.setCellValue(brf59a.getR40_banks1() == null ? 0 : brf59a.getR40_banks1().intValue());
			}
			Cell R40cell26 = R40row.getCell(28);
			if (R40cell26 != null) {
				R40cell26.setCellValue(
						brf59a.getR40_individuals2() == null ? 0 : brf59a.getR40_individuals2().intValue());
			}
			Cell R40cell27 = R40row.getCell(29);
			if (R40cell27 != null) {
				R40cell27.setCellValue(brf59a.getR40_other1() == null ? 0 : brf59a.getR40_other1().intValue());
			}
			Cell R40cell28 = R40row.getCell(30);
			if (R40cell28 != null) {
				R40cell28.setCellValue(brf59a.getR40_banks2() == null ? 0 : brf59a.getR40_banks2().intValue());
			}
			Cell R40cell29 = R40row.getCell(31);
			if (R40cell29 != null) {
				R40cell29.setCellValue(brf59a.getR40_gov3() == null ? 0 : brf59a.getR40_gov3().intValue());
			}
			Cell R40cell30 = R40row.getCell(32);
			if (R40cell30 != null) {
				R40cell30.setCellValue(brf59a.getR40_others2() == null ? 0 : brf59a.getR40_others2().intValue());
			}
			Cell R40cell31 = R40row.getCell(33);
			if (R40cell31 != null) {
				R40cell31.setCellValue(brf59a.getR40_banks3() == null ? 0 : brf59a.getR40_banks3().intValue());
			}
			Cell R40cell32 = R40row.getCell(34);
			if (R40cell32 != null) {
				R40cell32.setCellValue(brf59a.getR40_gov4() == null ? 0 : brf59a.getR40_gov4().intValue());
			}
			Cell R40cell33 = R40row.getCell(35);
			if (R40cell33 != null) {
				R40cell33.setCellValue(brf59a.getR40_others3() == null ? 0 : brf59a.getR40_others3().intValue());
			}
			Cell R40cell34 = R40row.getCell(36);
			if (R40cell34 != null) {
				R40cell34.setCellValue(brf59a.getR40_foreign1() == null ? 0 : brf59a.getR40_foreign1().intValue());
			}
			Cell R40cell35 = R40row.getCell(37);
			if (R40cell35 != null) {
				R40cell35.setCellValue(brf59a.getR40_guarantees() == null ? 0 : brf59a.getR40_guarantees().intValue());
			}
			Cell R40cell36 = R40row.getCell(38);
			if (R40cell36 != null) {
				R40cell36.setCellValue(brf59a.getR40_nbfi2() == null ? 0 : brf59a.getR40_nbfi2().intValue());
			}
			Cell R40cell37 = R40row.getCell(39);
			if (R40cell37 != null) {
				R40cell37.setCellValue(brf59a.getR40_interbank2() == null ? 0 : brf59a.getR40_interbank2().intValue());
			}
			Cell R40cell38 = R40row.getCell(40);
			if (R40cell38 != null) {
				R40cell38.setCellValue(brf59a.getR40_gov5() == null ? 0 : brf59a.getR40_gov5().intValue());
			}
			Cell R40cell39 = R40row.getCell(41);
			if (R40cell39 != null) {
				R40cell39.setCellValue(brf59a.getR40_corporate2() == null ? 0 : brf59a.getR40_corporate2().intValue());
			}
			Cell R40cell40 = R40row.getCell(42);
			if (R40cell40 != null) {
				R40cell40.setCellValue(brf59a.getR40_gre2() == null ? 0 : brf59a.getR40_gre2().intValue());
			}
			Cell R40cell41 = R40row.getCell(43);
			if (R40cell41 != null) {
				R40cell41.setCellValue(
						brf59a.getR40_individuals3() == null ? 0 : brf59a.getR40_individuals3().intValue());
			}
			Cell R40cell42 = R40row.getCell(44);
			if (R40cell42 != null) {
				R40cell42.setCellValue(brf59a.getR40_zero1() == null ? 0 : brf59a.getR40_zero1().intValue());
			}
			Cell R40cell43 = R40row.getCell(45);
			if (R40cell43 != null) {
				R40cell43.setCellValue(brf59a.getR40_three1() == null ? 0 : brf59a.getR40_three1().intValue());
			}
			Cell R40cell44 = R40row.getCell(46);
			if (R40cell44 != null) {
				R40cell44.setCellValue(brf59a.getR40_six1() == null ? 0 : brf59a.getR40_six1().intValue());
			}
			Cell R40cell45 = R40row.getCell(47);
			if (R40cell45 != null) {
				R40cell45.setCellValue(brf59a.getR40_oneyear1() == null ? 0 : brf59a.getR40_oneyear1().intValue());
			}
			Cell R40cell46 = R40row.getCell(48);
			if (R40cell46 != null) {
				R40cell46.setCellValue(brf59a.getR40_empty() == null ? "" : brf59a.getR40_empty().toString());
			}
			Row R41row = sheet.getRow(58);
			Cell R41cell1 = R41row.getCell(3);
			if (R41cell1 != null) {
				R41cell1.setCellValue(brf59a.getR41_nbfi() == null ? 0 : brf59a.getR41_nbfi().intValue());
			}

			Cell R41cell2 = R41row.getCell(4);
			if (R41cell2 != null) {
				R41cell2.setCellValue(brf59a.getR41_interbank() == null ? 0 : brf59a.getR41_interbank().intValue());
			}
			Cell R41cell3 = R41row.getCell(5);
			if (R41cell3 != null) {
				R41cell3.setCellValue(brf59a.getR41_gov() == null ? 0 : brf59a.getR41_gov().intValue());
			}
			Cell R41cell4 = R41row.getCell(6);
			if (R41cell4 != null) {
				R41cell4.setCellValue(brf59a.getR41_corporate() == null ? 0 : brf59a.getR41_corporate().intValue());
			}
			Cell R41cell5 = R41row.getCell(7);
			if (R41cell5 != null) {
				R41cell5.setCellValue(brf59a.getR41_gre() == null ? 0 : brf59a.getR41_gre().intValue());
			}
			Cell R41cell6 = R41row.getCell(8);
			if (R41cell6 != null) {
				R41cell6.setCellValue(brf59a.getR41_trade() == null ? 0 : brf59a.getR41_trade().intValue());
			}
			Cell R41cell7 = R41row.getCell(9);
			if (R41cell7 != null) {
				R41cell7.setCellValue(brf59a.getR41_individuals() == null ? 0 : brf59a.getR41_individuals().intValue());
			}
			Cell R41cell8 = R41row.getCell(10);
			if (R41cell8 != null) {
				R41cell8.setCellValue(brf59a.getR41_investment() == null ? 0 : brf59a.getR41_investment().intValue());
			}
			Cell R41cell9 = R41row.getCell(11);
			if (R41cell9 != null) {
				R41cell9.setCellValue(brf59a.getR41_nbfi1() == null ? 0 : brf59a.getR41_nbfi1().intValue());
			}
			Cell R41cell10 = R41row.getCell(12);
			if (R41cell10 != null) {
				R41cell10.setCellValue(brf59a.getR41_interbank1() == null ? 0 : brf59a.getR41_interbank1().intValue());
			}
			Cell R41cell11 = R41row.getCell(13);
			if (R41cell11 != null) {
				R41cell11.setCellValue(brf59a.getR41_gov1() == null ? 0 : brf59a.getR41_gov1().intValue());
			}
			Cell R41cell12 = R41row.getCell(14);
			if (R41cell12 != null) {
				R41cell12.setCellValue(brf59a.getR41_corporate1() == null ? 0 : brf59a.getR41_corporate1().intValue());
			}
			Cell R41cell13 = R41row.getCell(15);
			if (R41cell13 != null) {
				R41cell13.setCellValue(brf59a.getR41_gre1() == null ? 0 : brf59a.getR41_gre1().intValue());
			}
			Cell R41cell14 = R41row.getCell(16);
			if (R41cell14 != null) {
				R41cell14.setCellValue(brf59a.getR41_trade1() == null ? 0 : brf59a.getR41_trade1().intValue());
			}
			Cell R41cell15 = R41row.getCell(17);
			if (R41cell15 != null) {
				R41cell15.setCellValue(
						brf59a.getR41_individuals1() == null ? 0 : brf59a.getR41_individuals1().intValue());
			}
			Cell R41cell16 = R41row.getCell(18);
			if (R41cell16 != null) {
				R41cell16
						.setCellValue(brf59a.getR41_investment1() == null ? 0 : brf59a.getR41_investment1().intValue());
			}
			Cell R41cell17 = R41row.getCell(19);
			if (R41cell17 != null) {
				R41cell17.setCellValue(brf59a.getR41_zer0() == null ? 0 : brf59a.getR41_zer0().intValue());
			}
			Cell R41cell18 = R41row.getCell(20);
			if (R41cell18 != null) {
				R41cell18.setCellValue(brf59a.getR41_three() == null ? 0 : brf59a.getR41_three().intValue());
			}
			Cell R41cell19 = R41row.getCell(21);
			if (R41cell19 != null) {
				R41cell19.setCellValue(brf59a.getR41_six() == null ? 0 : brf59a.getR41_six().intValue());
			}
			Cell R41cell20 = R41row.getCell(22);
			if (R41cell20 != null) {
				R41cell20.setCellValue(brf59a.getR41_oneyear() == null ? 0 : brf59a.getR41_oneyear().intValue());
			}
			Cell R41cell21 = R41row.getCell(23);
			if (R41cell21 != null) {
				R41cell21.setCellValue(brf59a.getR41_foreign() == null ? 0 : brf59a.getR41_foreign().intValue());
			}
			Cell R41cell22 = R41row.getCell(24);
			if (R41cell22 != null) {
				R41cell22.setCellValue(brf59a.getR41_banks() == null ? 0 : brf59a.getR41_banks().intValue());
			}
			Cell R41cell23 = R41row.getCell(25);
			if (R41cell23 != null) {
				R41cell23.setCellValue(brf59a.getR41_gov2() == null ? 0 : brf59a.getR41_gov2().intValue());
			}
			Cell R41cell24 = R41row.getCell(26);
			if (R41cell24 != null) {
				R41cell24.setCellValue(brf59a.getR41_other() == null ? 0 : brf59a.getR41_other().intValue());
			}
			Cell R41cell25 = R41row.getCell(27);
			if (R41cell25 != null) {
				R41cell25.setCellValue(brf59a.getR41_banks1() == null ? 0 : brf59a.getR41_banks1().intValue());
			}
			Cell R41cell26 = R41row.getCell(28);
			if (R41cell26 != null) {
				R41cell26.setCellValue(
						brf59a.getR41_individuals2() == null ? 0 : brf59a.getR41_individuals2().intValue());
			}
			Cell R41cell27 = R41row.getCell(29);
			if (R41cell27 != null) {
				R41cell27.setCellValue(brf59a.getR41_other1() == null ? 0 : brf59a.getR41_other1().intValue());
			}
			Cell R41cell28 = R41row.getCell(30);
			if (R41cell28 != null) {
				R41cell28.setCellValue(brf59a.getR41_banks2() == null ? 0 : brf59a.getR41_banks2().intValue());
			}
			Cell R41cell29 = R41row.getCell(31);
			if (R41cell29 != null) {
				R41cell29.setCellValue(brf59a.getR41_gov3() == null ? 0 : brf59a.getR41_gov3().intValue());
			}
			Cell R41cell30 = R41row.getCell(32);
			if (R41cell30 != null) {
				R41cell30.setCellValue(brf59a.getR41_others2() == null ? 0 : brf59a.getR41_others2().intValue());
			}
			Cell R41cell31 = R41row.getCell(33);
			if (R41cell31 != null) {
				R41cell31.setCellValue(brf59a.getR41_banks3() == null ? 0 : brf59a.getR41_banks3().intValue());
			}
			Cell R41cell32 = R41row.getCell(34);
			if (R41cell32 != null) {
				R41cell32.setCellValue(brf59a.getR41_gov4() == null ? 0 : brf59a.getR41_gov4().intValue());
			}
			Cell R41cell33 = R41row.getCell(35);
			if (R41cell33 != null) {
				R41cell33.setCellValue(brf59a.getR41_others3() == null ? 0 : brf59a.getR41_others3().intValue());
			}
			Cell R41cell34 = R41row.getCell(36);
			if (R41cell34 != null) {
				R41cell34.setCellValue(brf59a.getR41_foreign1() == null ? 0 : brf59a.getR41_foreign1().intValue());
			}
			Cell R41cell35 = R41row.getCell(37);
			if (R41cell35 != null) {
				R41cell35.setCellValue(brf59a.getR41_guarantees() == null ? 0 : brf59a.getR41_guarantees().intValue());
			}
			Cell R41cell36 = R41row.getCell(38);
			if (R41cell36 != null) {
				R41cell36.setCellValue(brf59a.getR41_nbfi2() == null ? 0 : brf59a.getR41_nbfi2().intValue());
			}
			Cell R41cell37 = R41row.getCell(39);
			if (R41cell37 != null) {
				R41cell37.setCellValue(brf59a.getR41_interbank2() == null ? 0 : brf59a.getR41_interbank2().intValue());
			}
			Cell R41cell38 = R41row.getCell(40);
			if (R41cell38 != null) {
				R41cell38.setCellValue(brf59a.getR41_gov5() == null ? 0 : brf59a.getR41_gov5().intValue());
			}
			Cell R41cell39 = R41row.getCell(41);
			if (R41cell39 != null) {
				R41cell39.setCellValue(brf59a.getR41_corporate2() == null ? 0 : brf59a.getR41_corporate2().intValue());
			}
			Cell R41cell40 = R41row.getCell(42);
			if (R41cell40 != null) {
				R41cell40.setCellValue(brf59a.getR41_gre2() == null ? 0 : brf59a.getR41_gre2().intValue());
			}
			Cell R41cell41 = R41row.getCell(43);
			if (R41cell41 != null) {
				R41cell41.setCellValue(
						brf59a.getR41_individuals3() == null ? 0 : brf59a.getR41_individuals3().intValue());
			}
			Cell R41cell42 = R41row.getCell(44);
			if (R41cell42 != null) {
				R41cell42.setCellValue(brf59a.getR41_zero1() == null ? 0 : brf59a.getR41_zero1().intValue());
			}
			Cell R41cell43 = R41row.getCell(45);
			if (R41cell43 != null) {
				R41cell43.setCellValue(brf59a.getR41_three1() == null ? 0 : brf59a.getR41_three1().intValue());
			}
			Cell R41cell44 = R41row.getCell(46);
			if (R41cell44 != null) {
				R41cell44.setCellValue(brf59a.getR41_six1() == null ? 0 : brf59a.getR41_six1().intValue());
			}
			Cell R41cell45 = R41row.getCell(47);
			if (R41cell45 != null) {
				R41cell45.setCellValue(brf59a.getR41_oneyear1() == null ? 0 : brf59a.getR41_oneyear1().intValue());
			}
			Cell R41cell46 = R41row.getCell(48);
			if (R41cell46 != null) {
				R41cell46.setCellValue(brf59a.getR41_empty() == null ? "" : brf59a.getR41_empty().toString());
			}
			Row R42row = sheet.getRow(59);
			Cell R42cell1 = R42row.getCell(3);
			if (R42cell1 != null) {
				R42cell1.setCellValue(brf59a.getR42_nbfi() == null ? 0 : brf59a.getR42_nbfi().intValue());
			}

			Cell R42cell2 = R42row.getCell(4);
			if (R42cell2 != null) {
				R42cell2.setCellValue(brf59a.getR42_interbank() == null ? 0 : brf59a.getR42_interbank().intValue());
			}
			Cell R42cell3 = R42row.getCell(5);
			if (R42cell3 != null) {
				R42cell3.setCellValue(brf59a.getR42_gov() == null ? 0 : brf59a.getR42_gov().intValue());
			}
			Cell R42cell4 = R42row.getCell(6);
			if (R42cell4 != null) {
				R42cell4.setCellValue(brf59a.getR42_corporate() == null ? 0 : brf59a.getR42_corporate().intValue());
			}
			Cell R42cell5 = R42row.getCell(7);
			if (R42cell5 != null) {
				R42cell5.setCellValue(brf59a.getR42_gre() == null ? 0 : brf59a.getR42_gre().intValue());
			}
			Cell R42cell6 = R42row.getCell(8);
			if (R42cell6 != null) {
				R42cell6.setCellValue(brf59a.getR42_trade() == null ? 0 : brf59a.getR42_trade().intValue());
			}
			Cell R42cell7 = R42row.getCell(9);
			if (R42cell7 != null) {
				R42cell7.setCellValue(brf59a.getR42_individuals() == null ? 0 : brf59a.getR42_individuals().intValue());
			}
			Cell R42cell8 = R42row.getCell(10);
			if (R42cell8 != null) {
				R42cell8.setCellValue(brf59a.getR42_investment() == null ? 0 : brf59a.getR42_investment().intValue());
			}
			Cell R42cell9 = R42row.getCell(11);
			if (R42cell9 != null) {
				R42cell9.setCellValue(brf59a.getR42_nbfi1() == null ? 0 : brf59a.getR42_nbfi1().intValue());
			}
			Cell R42cell10 = R42row.getCell(12);
			if (R42cell10 != null) {
				R42cell10.setCellValue(brf59a.getR42_interbank1() == null ? 0 : brf59a.getR42_interbank1().intValue());
			}
			Cell R42cell11 = R42row.getCell(13);
			if (R42cell11 != null) {
				R42cell11.setCellValue(brf59a.getR42_gov1() == null ? 0 : brf59a.getR42_gov1().intValue());
			}
			Cell R42cell12 = R42row.getCell(14);
			if (R42cell12 != null) {
				R42cell12.setCellValue(brf59a.getR42_corporate1() == null ? 0 : brf59a.getR42_corporate1().intValue());
			}
			Cell R42cell13 = R42row.getCell(15);
			if (R42cell13 != null) {
				R42cell13.setCellValue(brf59a.getR42_gre1() == null ? 0 : brf59a.getR42_gre1().intValue());
			}
			Cell R42cell14 = R42row.getCell(16);
			if (R42cell14 != null) {
				R42cell14.setCellValue(brf59a.getR42_trade1() == null ? 0 : brf59a.getR42_trade1().intValue());
			}
			Cell R42cell15 = R42row.getCell(17);
			if (R42cell15 != null) {
				R42cell15.setCellValue(
						brf59a.getR42_individuals1() == null ? 0 : brf59a.getR42_individuals1().intValue());
			}
			Cell R42cell16 = R42row.getCell(18);
			if (R42cell16 != null) {
				R42cell16
						.setCellValue(brf59a.getR42_investment1() == null ? 0 : brf59a.getR42_investment1().intValue());
			}
			Cell R42cell17 = R42row.getCell(19);
			if (R42cell17 != null) {
				R42cell17.setCellValue(brf59a.getR42_zer0() == null ? 0 : brf59a.getR42_zer0().intValue());
			}
			Cell R42cell18 = R42row.getCell(20);
			if (R42cell18 != null) {
				R42cell18.setCellValue(brf59a.getR42_three() == null ? 0 : brf59a.getR42_three().intValue());
			}
			Cell R42cell19 = R42row.getCell(21);
			if (R42cell19 != null) {
				R42cell19.setCellValue(brf59a.getR42_six() == null ? 0 : brf59a.getR42_six().intValue());
			}
			Cell R42cell20 = R42row.getCell(22);
			if (R42cell20 != null) {
				R42cell20.setCellValue(brf59a.getR42_oneyear() == null ? 0 : brf59a.getR42_oneyear().intValue());
			}
			Cell R42cell21 = R42row.getCell(23);
			if (R42cell21 != null) {
				R42cell21.setCellValue(brf59a.getR42_foreign() == null ? 0 : brf59a.getR42_foreign().intValue());
			}
			Cell R42cell22 = R42row.getCell(24);
			if (R42cell22 != null) {
				R42cell22.setCellValue(brf59a.getR42_banks() == null ? 0 : brf59a.getR42_banks().intValue());
			}
			Cell R42cell23 = R42row.getCell(25);
			if (R42cell23 != null) {
				R42cell23.setCellValue(brf59a.getR42_gov2() == null ? 0 : brf59a.getR42_gov2().intValue());
			}
			Cell R42cell24 = R42row.getCell(26);
			if (R42cell24 != null) {
				R42cell24.setCellValue(brf59a.getR42_other() == null ? 0 : brf59a.getR42_other().intValue());
			}
			Cell R42cell25 = R42row.getCell(27);
			if (R42cell25 != null) {
				R42cell25.setCellValue(brf59a.getR42_banks1() == null ? 0 : brf59a.getR42_banks1().intValue());
			}
			Cell R42cell26 = R42row.getCell(28);
			if (R42cell26 != null) {
				R42cell26.setCellValue(
						brf59a.getR42_individuals2() == null ? 0 : brf59a.getR42_individuals2().intValue());
			}
			Cell R42cell27 = R42row.getCell(29);
			if (R42cell27 != null) {
				R42cell27.setCellValue(brf59a.getR42_other1() == null ? 0 : brf59a.getR42_other1().intValue());
			}
			Cell R42cell28 = R42row.getCell(30);
			if (R42cell28 != null) {
				R42cell28.setCellValue(brf59a.getR42_banks2() == null ? 0 : brf59a.getR42_banks2().intValue());
			}
			Cell R42cell29 = R42row.getCell(31);
			if (R42cell29 != null) {
				R42cell29.setCellValue(brf59a.getR42_gov3() == null ? 0 : brf59a.getR42_gov3().intValue());
			}
			Cell R42cell30 = R42row.getCell(32);
			if (R42cell30 != null) {
				R42cell30.setCellValue(brf59a.getR42_others2() == null ? 0 : brf59a.getR42_others2().intValue());
			}
			Cell R42cell31 = R42row.getCell(33);
			if (R42cell31 != null) {
				R42cell31.setCellValue(brf59a.getR42_banks3() == null ? 0 : brf59a.getR42_banks3().intValue());
			}
			Cell R42cell32 = R42row.getCell(34);
			if (R42cell32 != null) {
				R42cell32.setCellValue(brf59a.getR42_gov4() == null ? 0 : brf59a.getR42_gov4().intValue());
			}
			Cell R42cell33 = R42row.getCell(35);
			if (R42cell33 != null) {
				R42cell33.setCellValue(brf59a.getR42_others3() == null ? 0 : brf59a.getR42_others3().intValue());
			}
			Cell R42cell34 = R42row.getCell(36);
			if (R42cell34 != null) {
				R42cell34.setCellValue(brf59a.getR42_foreign1() == null ? 0 : brf59a.getR42_foreign1().intValue());
			}
			Cell R42cell35 = R42row.getCell(37);
			if (R42cell35 != null) {
				R42cell35.setCellValue(brf59a.getR42_guarantees() == null ? 0 : brf59a.getR42_guarantees().intValue());
			}
			Cell R42cell36 = R42row.getCell(38);
			if (R42cell36 != null) {
				R42cell36.setCellValue(brf59a.getR42_nbfi2() == null ? 0 : brf59a.getR42_nbfi2().intValue());
			}
			Cell R42cell37 = R42row.getCell(39);
			if (R42cell37 != null) {
				R42cell37.setCellValue(brf59a.getR42_interbank2() == null ? 0 : brf59a.getR42_interbank2().intValue());
			}
			Cell R42cell38 = R42row.getCell(40);
			if (R42cell38 != null) {
				R42cell38.setCellValue(brf59a.getR42_gov5() == null ? 0 : brf59a.getR42_gov5().intValue());
			}
			Cell R42cell39 = R42row.getCell(41);
			if (R42cell39 != null) {
				R42cell39.setCellValue(brf59a.getR42_corporate2() == null ? 0 : brf59a.getR42_corporate2().intValue());
			}
			Cell R42cell40 = R42row.getCell(42);
			if (R42cell40 != null) {
				R42cell40.setCellValue(brf59a.getR42_gre2() == null ? 0 : brf59a.getR42_gre2().intValue());
			}
			Cell R42cell41 = R42row.getCell(43);
			if (R42cell41 != null) {
				R42cell41.setCellValue(
						brf59a.getR42_individuals3() == null ? 0 : brf59a.getR42_individuals3().intValue());
			}
			Cell R42cell42 = R42row.getCell(44);
			if (R42cell42 != null) {
				R42cell42.setCellValue(brf59a.getR42_zero1() == null ? 0 : brf59a.getR42_zero1().intValue());
			}
			Cell R42cell43 = R42row.getCell(45);
			if (R42cell43 != null) {
				R42cell43.setCellValue(brf59a.getR42_three1() == null ? 0 : brf59a.getR42_three1().intValue());
			}
			Cell R42cell44 = R42row.getCell(46);
			if (R42cell44 != null) {
				R42cell44.setCellValue(brf59a.getR42_six1() == null ? 0 : brf59a.getR42_six1().intValue());
			}
			Cell R42cell45 = R42row.getCell(47);
			if (R42cell45 != null) {
				R42cell45.setCellValue(brf59a.getR42_oneyear1() == null ? 0 : brf59a.getR42_oneyear1().intValue());
			}
			Cell R42cell46 = R42row.getCell(48);
			if (R42cell46 != null) {
				R42cell46.setCellValue(brf59a.getR42_empty() == null ? "" : brf59a.getR42_empty().toString());
			}

		}
	}

	public void updateSheetWithEntity3Data(Sheet sheet, List<BRF59C_ENTITY> BRF59C_ENTITY) {
		if (BRF59C_ENTITY.size() == 1) {
			BRF59C_ENTITY brf59B = BRF59C_ENTITY.get(0);
			Row R43row = sheet.getRow(60);
			Cell R43cell1 = R43row.getCell(3);
			if (R43cell1 != null) {
				R43cell1.setCellValue(brf59B.getR43_nbfi() == null ? 0 : brf59B.getR43_nbfi().intValue());
			}

			Cell R43cell2 = R43row.getCell(4);
			if (R43cell2 != null) {
				R43cell2.setCellValue(brf59B.getR43_interbank() == null ? 0 : brf59B.getR43_interbank().intValue());
			}
			Cell R43cell3 = R43row.getCell(5);
			if (R43cell3 != null) {
				R43cell3.setCellValue(brf59B.getR43_gov() == null ? 0 : brf59B.getR43_gov().intValue());
			}
			Cell R43cell4 = R43row.getCell(6);
			if (R43cell4 != null) {
				R43cell4.setCellValue(brf59B.getR43_corporate() == null ? 0 : brf59B.getR43_corporate().intValue());
			}
			Cell R43cell5 = R43row.getCell(7);
			if (R43cell5 != null) {
				R43cell5.setCellValue(brf59B.getR43_gre() == null ? 0 : brf59B.getR43_gre().intValue());
			}
			Cell R43cell6 = R43row.getCell(8);
			if (R43cell6 != null) {
				R43cell6.setCellValue(brf59B.getR43_trade() == null ? 0 : brf59B.getR43_trade().intValue());
			}
			Cell R43cell7 = R43row.getCell(9);
			if (R43cell7 != null) {
				R43cell7.setCellValue(brf59B.getR43_individuals() == null ? 0 : brf59B.getR43_individuals().intValue());
			}
			Cell R43cell8 = R43row.getCell(10);
			if (R43cell8 != null) {
				R43cell8.setCellValue(brf59B.getR43_investment() == null ? 0 : brf59B.getR43_investment().intValue());
			}
			Cell R43cell9 = R43row.getCell(11);
			if (R43cell9 != null) {
				R43cell9.setCellValue(brf59B.getR43_nbfi1() == null ? 0 : brf59B.getR43_nbfi1().intValue());
			}
			Cell R43cell10 = R43row.getCell(12);
			if (R43cell10 != null) {
				R43cell10.setCellValue(brf59B.getR43_interbank1() == null ? 0 : brf59B.getR43_interbank1().intValue());
			}
			Cell R43cell11 = R43row.getCell(13);
			if (R43cell11 != null) {
				R43cell11.setCellValue(brf59B.getR43_gov1() == null ? 0 : brf59B.getR43_gov1().intValue());
			}
			Cell R43cell12 = R43row.getCell(14);
			if (R43cell12 != null) {
				R43cell12.setCellValue(brf59B.getR43_corporate1() == null ? 0 : brf59B.getR43_corporate1().intValue());
			}
			Cell R43cell13 = R43row.getCell(15);
			if (R43cell13 != null) {
				R43cell13.setCellValue(brf59B.getR43_gre1() == null ? 0 : brf59B.getR43_gre1().intValue());
			}
			Cell R43cell14 = R43row.getCell(16);
			if (R43cell14 != null) {
				R43cell14.setCellValue(brf59B.getR43_trade1() == null ? 0 : brf59B.getR43_trade1().intValue());
			}
			Cell R43cell15 = R43row.getCell(17);
			if (R43cell15 != null) {
				R43cell15.setCellValue(
						brf59B.getR43_individuals1() == null ? 0 : brf59B.getR43_individuals1().intValue());
			}
			Cell R43cell16 = R43row.getCell(18);
			if (R43cell16 != null) {
				R43cell16
						.setCellValue(brf59B.getR43_investment1() == null ? 0 : brf59B.getR43_investment1().intValue());
			}
			Cell R43cell17 = R43row.getCell(19);
			if (R43cell17 != null) {
				R43cell17.setCellValue(brf59B.getR43_zer0() == null ? 0 : brf59B.getR43_zer0().intValue());
			}
			Cell R43cell18 = R43row.getCell(20);
			if (R43cell18 != null) {
				R43cell18.setCellValue(brf59B.getR43_three() == null ? 0 : brf59B.getR43_three().intValue());
			}
			Cell R43cell19 = R43row.getCell(21);
			if (R43cell19 != null) {
				R43cell19.setCellValue(brf59B.getR43_six() == null ? 0 : brf59B.getR43_six().intValue());
			}
			Cell R43cell20 = R43row.getCell(22);
			if (R43cell20 != null) {
				R43cell20.setCellValue(brf59B.getR43_oneyear() == null ? 0 : brf59B.getR43_oneyear().intValue());
			}
			Cell R43cell21 = R43row.getCell(23);
			if (R43cell21 != null) {
				R43cell21.setCellValue(brf59B.getR43_foreign() == null ? 0 : brf59B.getR43_foreign().intValue());
			}
			Cell R43cell22 = R43row.getCell(24);
			if (R43cell22 != null) {
				R43cell22.setCellValue(brf59B.getR43_banks() == null ? 0 : brf59B.getR43_banks().intValue());
			}
			Cell R43cell23 = R43row.getCell(25);
			if (R43cell23 != null) {
				R43cell23.setCellValue(brf59B.getR43_gov2() == null ? 0 : brf59B.getR43_gov2().intValue());
			}
			Cell R43cell24 = R43row.getCell(26);
			if (R43cell24 != null) {
				R43cell24.setCellValue(brf59B.getR43_other() == null ? 0 : brf59B.getR43_other().intValue());
			}
			Cell R43cell25 = R43row.getCell(27);
			if (R43cell25 != null) {
				R43cell25.setCellValue(brf59B.getR43_banks1() == null ? 0 : brf59B.getR43_banks1().intValue());
			}
			Cell R43cell26 = R43row.getCell(28);
			if (R43cell26 != null) {
				R43cell26.setCellValue(
						brf59B.getR43_individuals2() == null ? 0 : brf59B.getR43_individuals2().intValue());
			}
			Cell R43cell27 = R43row.getCell(29);
			if (R43cell27 != null) {
				R43cell27.setCellValue(brf59B.getR43_other1() == null ? 0 : brf59B.getR43_other1().intValue());
			}
			Cell R43cell28 = R43row.getCell(30);
			if (R43cell28 != null) {
				R43cell28.setCellValue(brf59B.getR43_banks2() == null ? 0 : brf59B.getR43_banks2().intValue());
			}
			Cell R43cell29 = R43row.getCell(31);
			if (R43cell29 != null) {
				R43cell29.setCellValue(brf59B.getR43_gov3() == null ? 0 : brf59B.getR43_gov3().intValue());
			}
			Cell R43cell30 = R43row.getCell(32);
			if (R43cell30 != null) {
				R43cell30.setCellValue(brf59B.getR43_others2() == null ? 0 : brf59B.getR43_others2().intValue());
			}
			Cell R43cell31 = R43row.getCell(33);
			if (R43cell31 != null) {
				R43cell31.setCellValue(brf59B.getR43_banks3() == null ? 0 : brf59B.getR43_banks3().intValue());
			}
			Cell R43cell32 = R43row.getCell(34);
			if (R43cell32 != null) {
				R43cell32.setCellValue(brf59B.getR43_gov4() == null ? 0 : brf59B.getR43_gov4().intValue());
			}
			Cell R43cell33 = R43row.getCell(35);
			if (R43cell33 != null) {
				R43cell33.setCellValue(brf59B.getR43_others3() == null ? 0 : brf59B.getR43_others3().intValue());
			}
			Cell R43cell34 = R43row.getCell(36);
			if (R43cell34 != null) {
				R43cell34.setCellValue(brf59B.getR43_foreign1() == null ? 0 : brf59B.getR43_foreign1().intValue());
			}
			Cell R43cell35 = R43row.getCell(37);
			if (R43cell35 != null) {
				R43cell35.setCellValue(brf59B.getR43_guarantees() == null ? 0 : brf59B.getR43_guarantees().intValue());
			}
			Cell R43cell36 = R43row.getCell(38);
			if (R43cell36 != null) {
				R43cell36.setCellValue(brf59B.getR43_nbfi2() == null ? 0 : brf59B.getR43_nbfi2().intValue());
			}
			Cell R43cell37 = R43row.getCell(39);
			if (R43cell37 != null) {
				R43cell37.setCellValue(brf59B.getR43_interbank2() == null ? 0 : brf59B.getR43_interbank2().intValue());
			}
			Cell R43cell38 = R43row.getCell(40);
			if (R43cell38 != null) {
				R43cell38.setCellValue(brf59B.getR43_gov5() == null ? 0 : brf59B.getR43_gov5().intValue());
			}
			Cell R43cell39 = R43row.getCell(41);
			if (R43cell39 != null) {
				R43cell39.setCellValue(brf59B.getR43_corporate2() == null ? 0 : brf59B.getR43_corporate2().intValue());
			}
			Cell R43cell40 = R43row.getCell(42);
			if (R43cell40 != null) {
				R43cell40.setCellValue(brf59B.getR43_gre2() == null ? 0 : brf59B.getR43_gre2().intValue());
			}
			Cell R43cell41 = R43row.getCell(43);
			if (R43cell41 != null) {
				R43cell41.setCellValue(
						brf59B.getR43_individuals3() == null ? 0 : brf59B.getR43_individuals3().intValue());
			}
			Cell R43cell42 = R43row.getCell(44);
			if (R43cell42 != null) {
				R43cell42.setCellValue(brf59B.getR43_zero1() == null ? 0 : brf59B.getR43_zero1().intValue());
			}
			Cell R43cell43 = R43row.getCell(45);
			if (R43cell43 != null) {
				R43cell43.setCellValue(brf59B.getR43_three1() == null ? 0 : brf59B.getR43_three1().intValue());
			}
			Cell R43cell44 = R43row.getCell(46);
			if (R43cell44 != null) {
				R43cell44.setCellValue(brf59B.getR43_six1() == null ? 0 : brf59B.getR43_six1().intValue());
			}
			Cell R43cell45 = R43row.getCell(47);
			if (R43cell45 != null) {
				R43cell45.setCellValue(brf59B.getR43_oneyear1() == null ? 0 : brf59B.getR43_oneyear1().intValue());
			}
			Cell R43cell46 = R43row.getCell(48);
			if (R43cell46 != null) {
				R43cell46.setCellValue(brf59B.getR43_empty() == null ? "" : brf59B.getR43_empty().toString());
			}
			Row R44row = sheet.getRow(61);
			Cell R44cell1 = R44row.getCell(3);
			if (R44cell1 != null) {
				R44cell1.setCellValue(brf59B.getR44_nbfi() == null ? 0 : brf59B.getR44_nbfi().intValue());
			}

			Cell R44cell2 = R44row.getCell(4);
			if (R44cell2 != null) {
				R44cell2.setCellValue(brf59B.getR44_interbank() == null ? 0 : brf59B.getR44_interbank().intValue());
			}
			Cell R44cell3 = R44row.getCell(5);
			if (R44cell3 != null) {
				R44cell3.setCellValue(brf59B.getR44_gov() == null ? 0 : brf59B.getR44_gov().intValue());
			}
			Cell R44cell4 = R44row.getCell(6);
			if (R44cell4 != null) {
				R44cell4.setCellValue(brf59B.getR44_corporate() == null ? 0 : brf59B.getR44_corporate().intValue());
			}
			Cell R44cell5 = R44row.getCell(7);
			if (R44cell5 != null) {
				R44cell5.setCellValue(brf59B.getR44_gre() == null ? 0 : brf59B.getR44_gre().intValue());
			}
			Cell R44cell6 = R44row.getCell(8);
			if (R44cell6 != null) {
				R44cell6.setCellValue(brf59B.getR44_trade() == null ? 0 : brf59B.getR44_trade().intValue());
			}
			Cell R44cell7 = R44row.getCell(9);
			if (R44cell7 != null) {
				R44cell7.setCellValue(brf59B.getR44_individuals() == null ? 0 : brf59B.getR44_individuals().intValue());
			}
			Cell R44cell8 = R44row.getCell(10);
			if (R44cell8 != null) {
				R44cell8.setCellValue(brf59B.getR44_investment() == null ? 0 : brf59B.getR44_investment().intValue());
			}
			Cell R44cell9 = R44row.getCell(11);
			if (R44cell9 != null) {
				R44cell9.setCellValue(brf59B.getR44_nbfi1() == null ? 0 : brf59B.getR44_nbfi1().intValue());
			}
			Cell R44cell10 = R44row.getCell(12);
			if (R44cell10 != null) {
				R44cell10.setCellValue(brf59B.getR44_interbank1() == null ? 0 : brf59B.getR44_interbank1().intValue());
			}
			Cell R44cell11 = R44row.getCell(13);
			if (R44cell11 != null) {
				R44cell11.setCellValue(brf59B.getR44_gov1() == null ? 0 : brf59B.getR44_gov1().intValue());
			}
			Cell R44cell12 = R44row.getCell(14);
			if (R44cell12 != null) {
				R44cell12.setCellValue(brf59B.getR44_corporate1() == null ? 0 : brf59B.getR44_corporate1().intValue());
			}
			Cell R44cell13 = R44row.getCell(15);
			if (R44cell13 != null) {
				R44cell13.setCellValue(brf59B.getR44_gre1() == null ? 0 : brf59B.getR44_gre1().intValue());
			}
			Cell R44cell14 = R44row.getCell(16);
			if (R44cell14 != null) {
				R44cell14.setCellValue(brf59B.getR44_trade1() == null ? 0 : brf59B.getR44_trade1().intValue());
			}
			Cell R44cell15 = R44row.getCell(17);
			if (R44cell15 != null) {
				R44cell15.setCellValue(
						brf59B.getR44_individuals1() == null ? 0 : brf59B.getR44_individuals1().intValue());
			}
			Cell R44cell16 = R44row.getCell(18);
			if (R44cell16 != null) {
				R44cell16
						.setCellValue(brf59B.getR44_investment1() == null ? 0 : brf59B.getR44_investment1().intValue());
			}
			Cell R44cell17 = R44row.getCell(19);
			if (R44cell17 != null) {
				R44cell17.setCellValue(brf59B.getR44_zer0() == null ? 0 : brf59B.getR44_zer0().intValue());
			}
			Cell R44cell18 = R44row.getCell(20);
			if (R44cell18 != null) {
				R44cell18.setCellValue(brf59B.getR44_three() == null ? 0 : brf59B.getR44_three().intValue());
			}
			Cell R44cell19 = R44row.getCell(21);
			if (R44cell19 != null) {
				R44cell19.setCellValue(brf59B.getR44_six() == null ? 0 : brf59B.getR44_six().intValue());
			}
			Cell R44cell20 = R44row.getCell(22);
			if (R44cell20 != null) {
				R44cell20.setCellValue(brf59B.getR44_oneyear() == null ? 0 : brf59B.getR44_oneyear().intValue());
			}
			Cell R44cell21 = R44row.getCell(23);
			if (R44cell21 != null) {
				R44cell21.setCellValue(brf59B.getR44_foreign() == null ? 0 : brf59B.getR44_foreign().intValue());
			}
			Cell R44cell22 = R44row.getCell(24);
			if (R44cell22 != null) {
				R44cell22.setCellValue(brf59B.getR44_banks() == null ? 0 : brf59B.getR44_banks().intValue());
			}
			Cell R44cell23 = R44row.getCell(25);
			if (R44cell23 != null) {
				R44cell23.setCellValue(brf59B.getR44_gov2() == null ? 0 : brf59B.getR44_gov2().intValue());
			}
			Cell R44cell24 = R44row.getCell(26);
			if (R44cell24 != null) {
				R44cell24.setCellValue(brf59B.getR44_other() == null ? 0 : brf59B.getR44_other().intValue());
			}
			Cell R44cell25 = R44row.getCell(27);
			if (R44cell25 != null) {
				R44cell25.setCellValue(brf59B.getR44_banks1() == null ? 0 : brf59B.getR44_banks1().intValue());
			}
			Cell R44cell26 = R44row.getCell(28);
			if (R44cell26 != null) {
				R44cell26.setCellValue(
						brf59B.getR44_individuals2() == null ? 0 : brf59B.getR44_individuals2().intValue());
			}
			Cell R44cell27 = R44row.getCell(29);
			if (R44cell27 != null) {
				R44cell27.setCellValue(brf59B.getR44_other1() == null ? 0 : brf59B.getR44_other1().intValue());
			}
			Cell R44cell28 = R44row.getCell(30);
			if (R44cell28 != null) {
				R44cell28.setCellValue(brf59B.getR44_banks2() == null ? 0 : brf59B.getR44_banks2().intValue());
			}
			Cell R44cell29 = R44row.getCell(31);
			if (R44cell29 != null) {
				R44cell29.setCellValue(brf59B.getR44_gov3() == null ? 0 : brf59B.getR44_gov3().intValue());
			}
			Cell R44cell30 = R44row.getCell(32);
			if (R44cell30 != null) {
				R44cell30.setCellValue(brf59B.getR44_others2() == null ? 0 : brf59B.getR44_others2().intValue());
			}
			Cell R44cell31 = R44row.getCell(33);
			if (R44cell31 != null) {
				R44cell31.setCellValue(brf59B.getR44_banks3() == null ? 0 : brf59B.getR44_banks3().intValue());
			}
			Cell R44cell32 = R44row.getCell(34);
			if (R44cell32 != null) {
				R44cell32.setCellValue(brf59B.getR44_gov4() == null ? 0 : brf59B.getR44_gov4().intValue());
			}
			Cell R44cell33 = R44row.getCell(35);
			if (R44cell33 != null) {
				R44cell33.setCellValue(brf59B.getR44_others3() == null ? 0 : brf59B.getR44_others3().intValue());
			}
			Cell R44cell34 = R44row.getCell(36);
			if (R44cell34 != null) {
				R44cell34.setCellValue(brf59B.getR44_foreign1() == null ? 0 : brf59B.getR44_foreign1().intValue());
			}
			Cell R44cell35 = R44row.getCell(37);
			if (R44cell35 != null) {
				R44cell35.setCellValue(brf59B.getR44_guarantees() == null ? 0 : brf59B.getR44_guarantees().intValue());
			}
			Cell R44cell36 = R44row.getCell(38);
			if (R44cell36 != null) {
				R44cell36.setCellValue(brf59B.getR44_nbfi2() == null ? 0 : brf59B.getR44_nbfi2().intValue());
			}
			Cell R44cell37 = R44row.getCell(39);
			if (R44cell37 != null) {
				R44cell37.setCellValue(brf59B.getR44_interbank2() == null ? 0 : brf59B.getR44_interbank2().intValue());
			}
			Cell R44cell38 = R44row.getCell(40);
			if (R44cell38 != null) {
				R44cell38.setCellValue(brf59B.getR44_gov5() == null ? 0 : brf59B.getR44_gov5().intValue());
			}
			Cell R44cell39 = R44row.getCell(41);
			if (R44cell39 != null) {
				R44cell39.setCellValue(brf59B.getR44_corporate2() == null ? 0 : brf59B.getR44_corporate2().intValue());
			}
			Cell R44cell40 = R44row.getCell(42);
			if (R44cell40 != null) {
				R44cell40.setCellValue(brf59B.getR44_gre2() == null ? 0 : brf59B.getR44_gre2().intValue());
			}
			Cell R44cell41 = R44row.getCell(43);
			if (R44cell41 != null) {
				R44cell41.setCellValue(
						brf59B.getR44_individuals3() == null ? 0 : brf59B.getR44_individuals3().intValue());
			}
			Cell R44cell42 = R44row.getCell(44);
			if (R44cell42 != null) {
				R44cell42.setCellValue(brf59B.getR44_zero1() == null ? 0 : brf59B.getR44_zero1().intValue());
			}
			Cell R44cell43 = R44row.getCell(45);
			if (R44cell43 != null) {
				R44cell43.setCellValue(brf59B.getR44_three1() == null ? 0 : brf59B.getR44_three1().intValue());
			}
			Cell R44cell44 = R44row.getCell(46);
			if (R44cell44 != null) {
				R44cell44.setCellValue(brf59B.getR44_six1() == null ? 0 : brf59B.getR44_six1().intValue());
			}
			Cell R44cell45 = R44row.getCell(47);
			if (R44cell45 != null) {
				R44cell45.setCellValue(brf59B.getR44_oneyear1() == null ? 0 : brf59B.getR44_oneyear1().intValue());
			}
			Cell R44cell46 = R44row.getCell(48);
			if (R44cell46 != null) {
				R44cell46.setCellValue(brf59B.getR44_empty() == null ? "" : brf59B.getR44_empty().toString());
			}
			Row R45row = sheet.getRow(62);
			Cell R45cell1 = R45row.getCell(3);
			if (R45cell1 != null) {
				R45cell1.setCellValue(brf59B.getR45_nbfi() == null ? 0 : brf59B.getR45_nbfi().intValue());
			}

			Cell R45cell2 = R45row.getCell(4);
			if (R45cell2 != null) {
				R45cell2.setCellValue(brf59B.getR45_interbank() == null ? 0 : brf59B.getR45_interbank().intValue());
			}
			Cell R45cell3 = R45row.getCell(5);
			if (R45cell3 != null) {
				R45cell3.setCellValue(brf59B.getR45_gov() == null ? 0 : brf59B.getR45_gov().intValue());
			}
			Cell R45cell4 = R45row.getCell(6);
			if (R45cell4 != null) {
				R45cell4.setCellValue(brf59B.getR45_corporate() == null ? 0 : brf59B.getR45_corporate().intValue());
			}
			Cell R45cell5 = R45row.getCell(7);
			if (R45cell5 != null) {
				R45cell5.setCellValue(brf59B.getR45_gre() == null ? 0 : brf59B.getR45_gre().intValue());
			}
			Cell R45cell6 = R45row.getCell(8);
			if (R45cell6 != null) {
				R45cell6.setCellValue(brf59B.getR45_trade() == null ? 0 : brf59B.getR45_trade().intValue());
			}
			Cell R45cell7 = R45row.getCell(9);
			if (R45cell7 != null) {
				R45cell7.setCellValue(brf59B.getR45_individuals() == null ? 0 : brf59B.getR45_individuals().intValue());
			}
			Cell R45cell8 = R45row.getCell(10);
			if (R45cell8 != null) {
				R45cell8.setCellValue(brf59B.getR45_investment() == null ? 0 : brf59B.getR45_investment().intValue());
			}
			Cell R45cell9 = R45row.getCell(11);
			if (R45cell9 != null) {
				R45cell9.setCellValue(brf59B.getR45_nbfi1() == null ? 0 : brf59B.getR45_nbfi1().intValue());
			}
			Cell R45cell10 = R45row.getCell(12);
			if (R45cell10 != null) {
				R45cell10.setCellValue(brf59B.getR45_interbank1() == null ? 0 : brf59B.getR45_interbank1().intValue());
			}
			Cell R45cell11 = R45row.getCell(13);
			if (R45cell11 != null) {
				R45cell11.setCellValue(brf59B.getR45_gov1() == null ? 0 : brf59B.getR45_gov1().intValue());
			}
			Cell R45cell12 = R45row.getCell(14);
			if (R45cell12 != null) {
				R45cell12.setCellValue(brf59B.getR45_corporate1() == null ? 0 : brf59B.getR45_corporate1().intValue());
			}
			Cell R45cell13 = R45row.getCell(15);
			if (R45cell13 != null) {
				R45cell13.setCellValue(brf59B.getR45_gre1() == null ? 0 : brf59B.getR45_gre1().intValue());
			}
			Cell R45cell14 = R45row.getCell(16);
			if (R45cell14 != null) {
				R45cell14.setCellValue(brf59B.getR45_trade1() == null ? 0 : brf59B.getR45_trade1().intValue());
			}
			Cell R45cell15 = R45row.getCell(17);
			if (R45cell15 != null) {
				R45cell15.setCellValue(
						brf59B.getR45_individuals1() == null ? 0 : brf59B.getR45_individuals1().intValue());
			}
			Cell R45cell16 = R45row.getCell(18);
			if (R45cell16 != null) {
				R45cell16
						.setCellValue(brf59B.getR45_investment1() == null ? 0 : brf59B.getR45_investment1().intValue());
			}
			Cell R45cell17 = R45row.getCell(19);
			if (R45cell17 != null) {
				R45cell17.setCellValue(brf59B.getR45_zer0() == null ? 0 : brf59B.getR45_zer0().intValue());
			}
			Cell R45cell18 = R45row.getCell(20);
			if (R45cell18 != null) {
				R45cell18.setCellValue(brf59B.getR45_three() == null ? 0 : brf59B.getR45_three().intValue());
			}
			Cell R45cell19 = R45row.getCell(21);
			if (R45cell19 != null) {
				R45cell19.setCellValue(brf59B.getR45_six() == null ? 0 : brf59B.getR45_six().intValue());
			}
			Cell R45cell20 = R45row.getCell(22);
			if (R45cell20 != null) {
				R45cell20.setCellValue(brf59B.getR45_oneyear() == null ? 0 : brf59B.getR45_oneyear().intValue());
			}
			Cell R45cell21 = R45row.getCell(23);
			if (R45cell21 != null) {
				R45cell21.setCellValue(brf59B.getR45_foreign() == null ? 0 : brf59B.getR45_foreign().intValue());
			}
			Cell R45cell22 = R45row.getCell(24);
			if (R45cell22 != null) {
				R45cell22.setCellValue(brf59B.getR45_banks() == null ? 0 : brf59B.getR45_banks().intValue());
			}
			Cell R45cell23 = R45row.getCell(25);
			if (R45cell23 != null) {
				R45cell23.setCellValue(brf59B.getR45_gov2() == null ? 0 : brf59B.getR45_gov2().intValue());
			}
			Cell R45cell24 = R45row.getCell(26);
			if (R45cell24 != null) {
				R45cell24.setCellValue(brf59B.getR45_other() == null ? 0 : brf59B.getR45_other().intValue());
			}
			Cell R45cell25 = R45row.getCell(27);
			if (R45cell25 != null) {
				R45cell25.setCellValue(brf59B.getR45_banks1() == null ? 0 : brf59B.getR45_banks1().intValue());
			}
			Cell R45cell26 = R45row.getCell(28);
			if (R45cell26 != null) {
				R45cell26.setCellValue(
						brf59B.getR45_individuals2() == null ? 0 : brf59B.getR45_individuals2().intValue());
			}
			Cell R45cell27 = R45row.getCell(29);
			if (R45cell27 != null) {
				R45cell27.setCellValue(brf59B.getR45_other1() == null ? 0 : brf59B.getR45_other1().intValue());
			}
			Cell R45cell28 = R45row.getCell(30);
			if (R45cell28 != null) {
				R45cell28.setCellValue(brf59B.getR45_banks2() == null ? 0 : brf59B.getR45_banks2().intValue());
			}
			Cell R45cell29 = R45row.getCell(31);
			if (R45cell29 != null) {
				R45cell29.setCellValue(brf59B.getR45_gov3() == null ? 0 : brf59B.getR45_gov3().intValue());
			}
			Cell R45cell30 = R45row.getCell(32);
			if (R45cell30 != null) {
				R45cell30.setCellValue(brf59B.getR45_others2() == null ? 0 : brf59B.getR45_others2().intValue());
			}
			Cell R45cell31 = R45row.getCell(33);
			if (R45cell31 != null) {
				R45cell31.setCellValue(brf59B.getR45_banks3() == null ? 0 : brf59B.getR45_banks3().intValue());
			}
			Cell R45cell32 = R45row.getCell(34);
			if (R45cell32 != null) {
				R45cell32.setCellValue(brf59B.getR45_gov4() == null ? 0 : brf59B.getR45_gov4().intValue());
			}
			Cell R45cell33 = R45row.getCell(35);
			if (R45cell33 != null) {
				R45cell33.setCellValue(brf59B.getR45_others3() == null ? 0 : brf59B.getR45_others3().intValue());
			}
			Cell R45cell34 = R45row.getCell(36);
			if (R45cell34 != null) {
				R45cell34.setCellValue(brf59B.getR45_foreign1() == null ? 0 : brf59B.getR45_foreign1().intValue());
			}
			Cell R45cell35 = R45row.getCell(37);
			if (R45cell35 != null) {
				R45cell35.setCellValue(brf59B.getR45_guarantees() == null ? 0 : brf59B.getR45_guarantees().intValue());
			}
			Cell R45cell36 = R45row.getCell(38);
			if (R45cell36 != null) {
				R45cell36.setCellValue(brf59B.getR45_nbfi2() == null ? 0 : brf59B.getR45_nbfi2().intValue());
			}
			Cell R45cell37 = R45row.getCell(39);
			if (R45cell37 != null) {
				R45cell37.setCellValue(brf59B.getR45_interbank2() == null ? 0 : brf59B.getR45_interbank2().intValue());
			}
			Cell R45cell38 = R45row.getCell(40);
			if (R45cell38 != null) {
				R45cell38.setCellValue(brf59B.getR45_gov5() == null ? 0 : brf59B.getR45_gov5().intValue());
			}
			Cell R45cell39 = R45row.getCell(41);
			if (R45cell39 != null) {
				R45cell39.setCellValue(brf59B.getR45_corporate2() == null ? 0 : brf59B.getR45_corporate2().intValue());
			}
			Cell R45cell40 = R45row.getCell(42);
			if (R45cell40 != null) {
				R45cell40.setCellValue(brf59B.getR45_gre2() == null ? 0 : brf59B.getR45_gre2().intValue());
			}
			Cell R45cell41 = R45row.getCell(43);
			if (R45cell41 != null) {
				R45cell41.setCellValue(
						brf59B.getR45_individuals3() == null ? 0 : brf59B.getR45_individuals3().intValue());
			}
			Cell R45cell42 = R45row.getCell(44);
			if (R45cell42 != null) {
				R45cell42.setCellValue(brf59B.getR45_zero1() == null ? 0 : brf59B.getR45_zero1().intValue());
			}
			Cell R45cell43 = R45row.getCell(45);
			if (R45cell43 != null) {
				R45cell43.setCellValue(brf59B.getR45_three1() == null ? 0 : brf59B.getR45_three1().intValue());
			}
			Cell R45cell44 = R45row.getCell(46);
			if (R45cell44 != null) {
				R45cell44.setCellValue(brf59B.getR45_six1() == null ? 0 : brf59B.getR45_six1().intValue());
			}
			Cell R45cell45 = R45row.getCell(47);
			if (R45cell45 != null) {
				R45cell45.setCellValue(brf59B.getR45_oneyear1() == null ? 0 : brf59B.getR45_oneyear1().intValue());
			}
			Cell R45cell46 = R45row.getCell(48);
			if (R45cell46 != null) {
				R45cell46.setCellValue(brf59B.getR45_empty() == null ? "" : brf59B.getR45_empty().toString());
			}
			Row R47row = sheet.getRow(64);
			Cell R47cell1 = R47row.getCell(3);
			if (R47cell1 != null) {
				R47cell1.setCellValue(brf59B.getR47_nbfi() == null ? 0 : brf59B.getR47_nbfi().intValue());
			}

			Cell R47cell2 = R47row.getCell(4);
			if (R47cell2 != null) {
				R47cell2.setCellValue(brf59B.getR47_interbank() == null ? 0 : brf59B.getR47_interbank().intValue());
			}
			Cell R47cell3 = R47row.getCell(5);
			if (R47cell3 != null) {
				R47cell3.setCellValue(brf59B.getR47_gov() == null ? 0 : brf59B.getR47_gov().intValue());
			}
			Cell R47cell4 = R47row.getCell(6);
			if (R47cell4 != null) {
				R47cell4.setCellValue(brf59B.getR47_corporate() == null ? 0 : brf59B.getR47_corporate().intValue());
			}
			Cell R47cell5 = R47row.getCell(7);
			if (R47cell5 != null) {
				R47cell5.setCellValue(brf59B.getR47_gre() == null ? 0 : brf59B.getR47_gre().intValue());
			}
			Cell R47cell6 = R47row.getCell(8);
			if (R47cell6 != null) {
				R47cell6.setCellValue(brf59B.getR47_trade() == null ? 0 : brf59B.getR47_trade().intValue());
			}
			Cell R47cell7 = R47row.getCell(9);
			if (R47cell7 != null) {
				R47cell7.setCellValue(brf59B.getR47_individuals() == null ? 0 : brf59B.getR47_individuals().intValue());
			}
			Cell R47cell8 = R47row.getCell(10);
			if (R47cell8 != null) {
				R47cell8.setCellValue(brf59B.getR47_investment() == null ? 0 : brf59B.getR47_investment().intValue());
			}
			Cell R47cell9 = R47row.getCell(11);
			if (R47cell9 != null) {
				R47cell9.setCellValue(brf59B.getR47_nbfi1() == null ? 0 : brf59B.getR47_nbfi1().intValue());
			}
			Cell R47cell10 = R47row.getCell(12);
			if (R47cell10 != null) {
				R47cell10.setCellValue(brf59B.getR47_interbank1() == null ? 0 : brf59B.getR47_interbank1().intValue());
			}
			Cell R47cell11 = R47row.getCell(13);
			if (R47cell11 != null) {
				R47cell11.setCellValue(brf59B.getR47_gov1() == null ? 0 : brf59B.getR47_gov1().intValue());
			}
			Cell R47cell12 = R47row.getCell(14);
			if (R47cell12 != null) {
				R47cell12.setCellValue(brf59B.getR47_corporate1() == null ? 0 : brf59B.getR47_corporate1().intValue());
			}
			Cell R47cell13 = R47row.getCell(15);
			if (R47cell13 != null) {
				R47cell13.setCellValue(brf59B.getR47_gre1() == null ? 0 : brf59B.getR47_gre1().intValue());
			}
			Cell R47cell14 = R47row.getCell(16);
			if (R47cell14 != null) {
				R47cell14.setCellValue(brf59B.getR47_trade1() == null ? 0 : brf59B.getR47_trade1().intValue());
			}
			Cell R47cell15 = R47row.getCell(17);
			if (R47cell15 != null) {
				R47cell15.setCellValue(
						brf59B.getR47_individuals1() == null ? 0 : brf59B.getR47_individuals1().intValue());
			}
			Cell R47cell16 = R47row.getCell(18);
			if (R47cell16 != null) {
				R47cell16
						.setCellValue(brf59B.getR47_investment1() == null ? 0 : brf59B.getR47_investment1().intValue());
			}
			Cell R47cell17 = R47row.getCell(19);
			if (R47cell17 != null) {
				R47cell17.setCellValue(brf59B.getR47_zer0() == null ? 0 : brf59B.getR47_zer0().intValue());
			}
			Cell R47cell18 = R47row.getCell(20);
			if (R47cell18 != null) {
				R47cell18.setCellValue(brf59B.getR47_three() == null ? 0 : brf59B.getR47_three().intValue());
			}
			Cell R47cell19 = R47row.getCell(21);
			if (R47cell19 != null) {
				R47cell19.setCellValue(brf59B.getR47_six() == null ? 0 : brf59B.getR47_six().intValue());
			}
			Cell R47cell20 = R47row.getCell(22);
			if (R47cell20 != null) {
				R47cell20.setCellValue(brf59B.getR47_oneyear() == null ? 0 : brf59B.getR47_oneyear().intValue());
			}
			Cell R47cell21 = R47row.getCell(23);
			if (R47cell21 != null) {
				R47cell21.setCellValue(brf59B.getR47_foreign() == null ? 0 : brf59B.getR47_foreign().intValue());
			}
			Cell R47cell22 = R47row.getCell(24);
			if (R47cell22 != null) {
				R47cell22.setCellValue(brf59B.getR47_banks() == null ? 0 : brf59B.getR47_banks().intValue());
			}
			Cell R47cell23 = R47row.getCell(25);
			if (R47cell23 != null) {
				R47cell23.setCellValue(brf59B.getR47_gov2() == null ? 0 : brf59B.getR47_gov2().intValue());
			}
			Cell R47cell24 = R47row.getCell(26);
			if (R47cell24 != null) {
				R47cell24.setCellValue(brf59B.getR47_other() == null ? 0 : brf59B.getR47_other().intValue());
			}
			Cell R47cell25 = R47row.getCell(27);
			if (R47cell25 != null) {
				R47cell25.setCellValue(brf59B.getR47_banks1() == null ? 0 : brf59B.getR47_banks1().intValue());
			}
			Cell R47cell26 = R47row.getCell(28);
			if (R47cell26 != null) {
				R47cell26.setCellValue(
						brf59B.getR47_individuals2() == null ? 0 : brf59B.getR47_individuals2().intValue());
			}
			Cell R47cell27 = R47row.getCell(29);
			if (R47cell27 != null) {
				R47cell27.setCellValue(brf59B.getR47_other1() == null ? 0 : brf59B.getR47_other1().intValue());
			}
			Cell R47cell28 = R47row.getCell(30);
			if (R47cell28 != null) {
				R47cell28.setCellValue(brf59B.getR47_banks2() == null ? 0 : brf59B.getR47_banks2().intValue());
			}
			Cell R47cell29 = R47row.getCell(31);
			if (R47cell29 != null) {
				R47cell29.setCellValue(brf59B.getR47_gov3() == null ? 0 : brf59B.getR47_gov3().intValue());
			}
			Cell R47cell30 = R47row.getCell(32);
			if (R47cell30 != null) {
				R47cell30.setCellValue(brf59B.getR47_others2() == null ? 0 : brf59B.getR47_others2().intValue());
			}
			Cell R47cell31 = R47row.getCell(33);
			if (R47cell31 != null) {
				R47cell31.setCellValue(brf59B.getR47_banks3() == null ? 0 : brf59B.getR47_banks3().intValue());
			}
			Cell R47cell32 = R47row.getCell(34);
			if (R47cell32 != null) {
				R47cell32.setCellValue(brf59B.getR47_gov4() == null ? 0 : brf59B.getR47_gov4().intValue());
			}
			Cell R47cell33 = R47row.getCell(35);
			if (R47cell33 != null) {
				R47cell33.setCellValue(brf59B.getR47_others3() == null ? 0 : brf59B.getR47_others3().intValue());
			}
			Cell R47cell34 = R47row.getCell(36);
			if (R47cell34 != null) {
				R47cell34.setCellValue(brf59B.getR47_foreign1() == null ? 0 : brf59B.getR47_foreign1().intValue());
			}
			Cell R47cell35 = R47row.getCell(37);
			if (R47cell35 != null) {
				R47cell35.setCellValue(brf59B.getR47_guarantees() == null ? 0 : brf59B.getR47_guarantees().intValue());
			}
			Cell R47cell36 = R47row.getCell(38);
			if (R47cell36 != null) {
				R47cell36.setCellValue(brf59B.getR47_nbfi2() == null ? 0 : brf59B.getR47_nbfi2().intValue());
			}
			Cell R47cell37 = R47row.getCell(39);
			if (R47cell37 != null) {
				R47cell37.setCellValue(brf59B.getR47_interbank2() == null ? 0 : brf59B.getR47_interbank2().intValue());
			}
			Cell R47cell38 = R47row.getCell(40);
			if (R47cell38 != null) {
				R47cell38.setCellValue(brf59B.getR47_gov5() == null ? 0 : brf59B.getR47_gov5().intValue());
			}
			Cell R47cell39 = R47row.getCell(41);
			if (R47cell39 != null) {
				R47cell39.setCellValue(brf59B.getR47_corporate2() == null ? 0 : brf59B.getR47_corporate2().intValue());
			}
			Cell R47cell40 = R47row.getCell(42);
			if (R47cell40 != null) {
				R47cell40.setCellValue(brf59B.getR47_gre2() == null ? 0 : brf59B.getR47_gre2().intValue());
			}
			Cell R47cell41 = R47row.getCell(43);
			if (R47cell41 != null) {
				R47cell41.setCellValue(
						brf59B.getR47_individuals3() == null ? 0 : brf59B.getR47_individuals3().intValue());
			}
			Cell R47cell42 = R47row.getCell(44);
			if (R47cell42 != null) {
				R47cell42.setCellValue(brf59B.getR47_zero1() == null ? 0 : brf59B.getR47_zero1().intValue());
			}
			Cell R47cell43 = R47row.getCell(45);
			if (R47cell43 != null) {
				R47cell43.setCellValue(brf59B.getR47_three1() == null ? 0 : brf59B.getR47_three1().intValue());
			}
			Cell R47cell44 = R47row.getCell(46);
			if (R47cell44 != null) {
				R47cell44.setCellValue(brf59B.getR47_six1() == null ? 0 : brf59B.getR47_six1().intValue());
			}
			Cell R47cell45 = R47row.getCell(47);
			if (R47cell45 != null) {
				R47cell45.setCellValue(brf59B.getR47_oneyear1() == null ? 0 : brf59B.getR47_oneyear1().intValue());
			}
			Cell R47cell46 = R47row.getCell(48);
			if (R47cell46 != null) {
				R47cell46.setCellValue(brf59B.getR47_empty() == null ? "" : brf59B.getR47_empty().toString());
			}
			Row R48row = sheet.getRow(65);
			Cell R48cell1 = R48row.getCell(3);
			if (R48cell1 != null) {
				R48cell1.setCellValue(brf59B.getR48_nbfi() == null ? 0 : brf59B.getR48_nbfi().intValue());
			}

			Cell R48cell2 = R48row.getCell(4);
			if (R48cell2 != null) {
				R48cell2.setCellValue(brf59B.getR48_interbank() == null ? 0 : brf59B.getR48_interbank().intValue());
			}
			Cell R48cell3 = R48row.getCell(5);
			if (R48cell3 != null) {
				R48cell3.setCellValue(brf59B.getR48_gov() == null ? 0 : brf59B.getR48_gov().intValue());
			}
			Cell R48cell4 = R48row.getCell(6);
			if (R48cell4 != null) {
				R48cell4.setCellValue(brf59B.getR48_corporate() == null ? 0 : brf59B.getR48_corporate().intValue());
			}
			Cell R48cell5 = R48row.getCell(7);
			if (R48cell5 != null) {
				R48cell5.setCellValue(brf59B.getR48_gre() == null ? 0 : brf59B.getR48_gre().intValue());
			}
			Cell R48cell6 = R48row.getCell(8);
			if (R48cell6 != null) {
				R48cell6.setCellValue(brf59B.getR48_trade() == null ? 0 : brf59B.getR48_trade().intValue());
			}
			Cell R48cell7 = R48row.getCell(9);
			if (R48cell7 != null) {
				R48cell7.setCellValue(brf59B.getR48_individuals() == null ? 0 : brf59B.getR48_individuals().intValue());
			}
			Cell R48cell8 = R48row.getCell(10);
			if (R48cell8 != null) {
				R48cell8.setCellValue(brf59B.getR48_investment() == null ? 0 : brf59B.getR48_investment().intValue());
			}
			Cell R48cell9 = R48row.getCell(11);
			if (R48cell9 != null) {
				R48cell9.setCellValue(brf59B.getR48_nbfi1() == null ? 0 : brf59B.getR48_nbfi1().intValue());
			}
			Cell R48cell10 = R48row.getCell(12);
			if (R48cell10 != null) {
				R48cell10.setCellValue(brf59B.getR48_interbank1() == null ? 0 : brf59B.getR48_interbank1().intValue());
			}
			Cell R48cell11 = R48row.getCell(13);
			if (R48cell11 != null) {
				R48cell11.setCellValue(brf59B.getR48_gov1() == null ? 0 : brf59B.getR48_gov1().intValue());
			}
			Cell R48cell12 = R48row.getCell(14);
			if (R48cell12 != null) {
				R48cell12.setCellValue(brf59B.getR48_corporate1() == null ? 0 : brf59B.getR48_corporate1().intValue());
			}
			Cell R48cell13 = R48row.getCell(15);
			if (R48cell13 != null) {
				R48cell13.setCellValue(brf59B.getR48_gre1() == null ? 0 : brf59B.getR48_gre1().intValue());
			}
			Cell R48cell14 = R48row.getCell(16);
			if (R48cell14 != null) {
				R48cell14.setCellValue(brf59B.getR48_trade1() == null ? 0 : brf59B.getR48_trade1().intValue());
			}
			Cell R48cell15 = R48row.getCell(17);
			if (R48cell15 != null) {
				R48cell15.setCellValue(
						brf59B.getR48_individuals1() == null ? 0 : brf59B.getR48_individuals1().intValue());
			}
			Cell R48cell16 = R48row.getCell(18);
			if (R48cell16 != null) {
				R48cell16
						.setCellValue(brf59B.getR48_investment1() == null ? 0 : brf59B.getR48_investment1().intValue());
			}
			Cell R48cell17 = R48row.getCell(19);
			if (R48cell17 != null) {
				R48cell17.setCellValue(brf59B.getR48_zer0() == null ? 0 : brf59B.getR48_zer0().intValue());
			}
			Cell R48cell18 = R48row.getCell(20);
			if (R48cell18 != null) {
				R48cell18.setCellValue(brf59B.getR48_three() == null ? 0 : brf59B.getR48_three().intValue());
			}
			Cell R48cell19 = R48row.getCell(21);
			if (R48cell19 != null) {
				R48cell19.setCellValue(brf59B.getR48_six() == null ? 0 : brf59B.getR48_six().intValue());
			}
			Cell R48cell20 = R48row.getCell(22);
			if (R48cell20 != null) {
				R48cell20.setCellValue(brf59B.getR48_oneyear() == null ? 0 : brf59B.getR48_oneyear().intValue());
			}
			Cell R48cell21 = R48row.getCell(23);
			if (R48cell21 != null) {
				R48cell21.setCellValue(brf59B.getR48_foreign() == null ? 0 : brf59B.getR48_foreign().intValue());
			}
			Cell R48cell22 = R48row.getCell(24);
			if (R48cell22 != null) {
				R48cell22.setCellValue(brf59B.getR48_banks() == null ? 0 : brf59B.getR48_banks().intValue());
			}
			Cell R48cell23 = R48row.getCell(25);
			if (R48cell23 != null) {
				R48cell23.setCellValue(brf59B.getR48_gov2() == null ? 0 : brf59B.getR48_gov2().intValue());
			}
			Cell R48cell24 = R48row.getCell(26);
			if (R48cell24 != null) {
				R48cell24.setCellValue(brf59B.getR48_other() == null ? 0 : brf59B.getR48_other().intValue());
			}
			Cell R48cell25 = R48row.getCell(27);
			if (R48cell25 != null) {
				R48cell25.setCellValue(brf59B.getR48_banks1() == null ? 0 : brf59B.getR48_banks1().intValue());
			}
			Cell R48cell26 = R48row.getCell(28);
			if (R48cell26 != null) {
				R48cell26.setCellValue(
						brf59B.getR48_individuals2() == null ? 0 : brf59B.getR48_individuals2().intValue());
			}
			Cell R48cell27 = R48row.getCell(29);
			if (R48cell27 != null) {
				R48cell27.setCellValue(brf59B.getR48_other1() == null ? 0 : brf59B.getR48_other1().intValue());
			}
			Cell R48cell28 = R48row.getCell(30);
			if (R48cell28 != null) {
				R48cell28.setCellValue(brf59B.getR48_banks2() == null ? 0 : brf59B.getR48_banks2().intValue());
			}
			Cell R48cell29 = R48row.getCell(31);
			if (R48cell29 != null) {
				R48cell29.setCellValue(brf59B.getR48_gov3() == null ? 0 : brf59B.getR48_gov3().intValue());
			}
			Cell R48cell30 = R48row.getCell(32);
			if (R48cell30 != null) {
				R48cell30.setCellValue(brf59B.getR48_others2() == null ? 0 : brf59B.getR48_others2().intValue());
			}
			Cell R48cell31 = R48row.getCell(33);
			if (R48cell31 != null) {
				R48cell31.setCellValue(brf59B.getR48_banks3() == null ? 0 : brf59B.getR48_banks3().intValue());
			}
			Cell R48cell32 = R48row.getCell(34);
			if (R48cell32 != null) {
				R48cell32.setCellValue(brf59B.getR48_gov4() == null ? 0 : brf59B.getR48_gov4().intValue());
			}
			Cell R48cell33 = R48row.getCell(35);
			if (R48cell33 != null) {
				R48cell33.setCellValue(brf59B.getR48_others3() == null ? 0 : brf59B.getR48_others3().intValue());
			}
			Cell R48cell34 = R48row.getCell(36);
			if (R48cell34 != null) {
				R48cell34.setCellValue(brf59B.getR48_foreign1() == null ? 0 : brf59B.getR48_foreign1().intValue());
			}
			Cell R48cell35 = R48row.getCell(37);
			if (R48cell35 != null) {
				R48cell35.setCellValue(brf59B.getR48_guarantees() == null ? 0 : brf59B.getR48_guarantees().intValue());
			}
			Cell R48cell36 = R48row.getCell(38);
			if (R48cell36 != null) {
				R48cell36.setCellValue(brf59B.getR48_nbfi2() == null ? 0 : brf59B.getR48_nbfi2().intValue());
			}
			Cell R48cell37 = R48row.getCell(39);
			if (R48cell37 != null) {
				R48cell37.setCellValue(brf59B.getR48_interbank2() == null ? 0 : brf59B.getR48_interbank2().intValue());
			}
			Cell R48cell38 = R48row.getCell(40);
			if (R48cell38 != null) {
				R48cell38.setCellValue(brf59B.getR48_gov5() == null ? 0 : brf59B.getR48_gov5().intValue());
			}
			Cell R48cell39 = R48row.getCell(41);
			if (R48cell39 != null) {
				R48cell39.setCellValue(brf59B.getR48_corporate2() == null ? 0 : brf59B.getR48_corporate2().intValue());
			}
			Cell R48cell40 = R48row.getCell(42);
			if (R48cell40 != null) {
				R48cell40.setCellValue(brf59B.getR48_gre2() == null ? 0 : brf59B.getR48_gre2().intValue());
			}
			Cell R48cell41 = R48row.getCell(43);
			if (R48cell41 != null) {
				R48cell41.setCellValue(
						brf59B.getR48_individuals3() == null ? 0 : brf59B.getR48_individuals3().intValue());
			}
			Cell R48cell42 = R48row.getCell(44);
			if (R48cell42 != null) {
				R48cell42.setCellValue(brf59B.getR48_zero1() == null ? 0 : brf59B.getR48_zero1().intValue());
			}
			Cell R48cell43 = R48row.getCell(45);
			if (R48cell43 != null) {
				R48cell43.setCellValue(brf59B.getR48_three1() == null ? 0 : brf59B.getR48_three1().intValue());
			}
			Cell R48cell44 = R48row.getCell(46);
			if (R48cell44 != null) {
				R48cell44.setCellValue(brf59B.getR48_six1() == null ? 0 : brf59B.getR48_six1().intValue());
			}
			Cell R48cell45 = R48row.getCell(47);
			if (R48cell45 != null) {
				R48cell45.setCellValue(brf59B.getR48_oneyear1() == null ? 0 : brf59B.getR48_oneyear1().intValue());
			}
			Cell R48cell46 = R48row.getCell(48);
			if (R48cell46 != null) {
				R48cell46.setCellValue(brf59B.getR48_empty() == null ? "" : brf59B.getR48_empty().toString());
			}
			Row R49row = sheet.getRow(66);
			Cell R49cell1 = R49row.getCell(3);
			if (R49cell1 != null) {
				R49cell1.setCellValue(brf59B.getR49_nbfi() == null ? 0 : brf59B.getR49_nbfi().intValue());
			}

			Cell R49cell2 = R49row.getCell(4);
			if (R49cell2 != null) {
				R49cell2.setCellValue(brf59B.getR49_interbank() == null ? 0 : brf59B.getR49_interbank().intValue());
			}
			Cell R49cell3 = R49row.getCell(5);
			if (R49cell3 != null) {
				R49cell3.setCellValue(brf59B.getR49_gov() == null ? 0 : brf59B.getR49_gov().intValue());
			}
			Cell R49cell4 = R49row.getCell(6);
			if (R49cell4 != null) {
				R49cell4.setCellValue(brf59B.getR49_corporate() == null ? 0 : brf59B.getR49_corporate().intValue());
			}
			Cell R49cell5 = R49row.getCell(7);
			if (R49cell5 != null) {
				R49cell5.setCellValue(brf59B.getR49_gre() == null ? 0 : brf59B.getR49_gre().intValue());
			}
			Cell R49cell6 = R49row.getCell(8);
			if (R49cell6 != null) {
				R49cell6.setCellValue(brf59B.getR49_trade() == null ? 0 : brf59B.getR49_trade().intValue());
			}
			Cell R49cell7 = R49row.getCell(9);
			if (R49cell7 != null) {
				R49cell7.setCellValue(brf59B.getR49_individuals() == null ? 0 : brf59B.getR49_individuals().intValue());
			}
			Cell R49cell8 = R49row.getCell(10);
			if (R49cell8 != null) {
				R49cell8.setCellValue(brf59B.getR49_investment() == null ? 0 : brf59B.getR49_investment().intValue());
			}
			Cell R49cell9 = R49row.getCell(11);
			if (R49cell9 != null) {
				R49cell9.setCellValue(brf59B.getR49_nbfi1() == null ? 0 : brf59B.getR49_nbfi1().intValue());
			}
			Cell R49cell10 = R49row.getCell(12);
			if (R49cell10 != null) {
				R49cell10.setCellValue(brf59B.getR49_interbank1() == null ? 0 : brf59B.getR49_interbank1().intValue());
			}
			Cell R49cell11 = R49row.getCell(13);
			if (R49cell11 != null) {
				R49cell11.setCellValue(brf59B.getR49_gov1() == null ? 0 : brf59B.getR49_gov1().intValue());
			}
			Cell R49cell12 = R49row.getCell(14);
			if (R49cell12 != null) {
				R49cell12.setCellValue(brf59B.getR49_corporate1() == null ? 0 : brf59B.getR49_corporate1().intValue());
			}
			Cell R49cell13 = R49row.getCell(15);
			if (R49cell13 != null) {
				R49cell13.setCellValue(brf59B.getR49_gre1() == null ? 0 : brf59B.getR49_gre1().intValue());
			}
			Cell R49cell14 = R49row.getCell(16);
			if (R49cell14 != null) {
				R49cell14.setCellValue(brf59B.getR49_trade1() == null ? 0 : brf59B.getR49_trade1().intValue());
			}
			Cell R49cell15 = R49row.getCell(17);
			if (R49cell15 != null) {
				R49cell15.setCellValue(
						brf59B.getR49_individuals1() == null ? 0 : brf59B.getR49_individuals1().intValue());
			}
			Cell R49cell16 = R49row.getCell(18);
			if (R49cell16 != null) {
				R49cell16
						.setCellValue(brf59B.getR49_investment1() == null ? 0 : brf59B.getR49_investment1().intValue());
			}
			Cell R49cell17 = R49row.getCell(19);
			if (R49cell17 != null) {
				R49cell17.setCellValue(brf59B.getR49_zer0() == null ? 0 : brf59B.getR49_zer0().intValue());
			}
			Cell R49cell18 = R49row.getCell(20);
			if (R49cell18 != null) {
				R49cell18.setCellValue(brf59B.getR49_three() == null ? 0 : brf59B.getR49_three().intValue());
			}
			Cell R49cell19 = R49row.getCell(21);
			if (R49cell19 != null) {
				R49cell19.setCellValue(brf59B.getR49_six() == null ? 0 : brf59B.getR49_six().intValue());
			}
			Cell R49cell20 = R49row.getCell(22);
			if (R49cell20 != null) {
				R49cell20.setCellValue(brf59B.getR49_oneyear() == null ? 0 : brf59B.getR49_oneyear().intValue());
			}
			Cell R49cell21 = R49row.getCell(23);
			if (R49cell21 != null) {
				R49cell21.setCellValue(brf59B.getR49_foreign() == null ? 0 : brf59B.getR49_foreign().intValue());
			}
			Cell R49cell22 = R49row.getCell(24);
			if (R49cell22 != null) {
				R49cell22.setCellValue(brf59B.getR49_banks() == null ? 0 : brf59B.getR49_banks().intValue());
			}
			Cell R49cell23 = R49row.getCell(25);
			if (R49cell23 != null) {
				R49cell23.setCellValue(brf59B.getR49_gov2() == null ? 0 : brf59B.getR49_gov2().intValue());
			}
			Cell R49cell24 = R49row.getCell(26);
			if (R49cell24 != null) {
				R49cell24.setCellValue(brf59B.getR49_other() == null ? 0 : brf59B.getR49_other().intValue());
			}
			Cell R49cell25 = R49row.getCell(27);
			if (R49cell25 != null) {
				R49cell25.setCellValue(brf59B.getR49_banks1() == null ? 0 : brf59B.getR49_banks1().intValue());
			}
			Cell R49cell26 = R49row.getCell(28);
			if (R49cell26 != null) {
				R49cell26.setCellValue(
						brf59B.getR49_individuals2() == null ? 0 : brf59B.getR49_individuals2().intValue());
			}
			Cell R49cell27 = R49row.getCell(29);
			if (R49cell27 != null) {
				R49cell27.setCellValue(brf59B.getR49_other1() == null ? 0 : brf59B.getR49_other1().intValue());
			}
			Cell R49cell28 = R49row.getCell(30);
			if (R49cell28 != null) {
				R49cell28.setCellValue(brf59B.getR49_banks2() == null ? 0 : brf59B.getR49_banks2().intValue());
			}
			Cell R49cell29 = R49row.getCell(31);
			if (R49cell29 != null) {
				R49cell29.setCellValue(brf59B.getR49_gov3() == null ? 0 : brf59B.getR49_gov3().intValue());
			}
			Cell R49cell30 = R49row.getCell(32);
			if (R49cell30 != null) {
				R49cell30.setCellValue(brf59B.getR49_others2() == null ? 0 : brf59B.getR49_others2().intValue());
			}
			Cell R49cell31 = R49row.getCell(33);
			if (R49cell31 != null) {
				R49cell31.setCellValue(brf59B.getR49_banks3() == null ? 0 : brf59B.getR49_banks3().intValue());
			}
			Cell R49cell32 = R49row.getCell(34);
			if (R49cell32 != null) {
				R49cell32.setCellValue(brf59B.getR49_gov4() == null ? 0 : brf59B.getR49_gov4().intValue());
			}
			Cell R49cell33 = R49row.getCell(35);
			if (R49cell33 != null) {
				R49cell33.setCellValue(brf59B.getR49_others3() == null ? 0 : brf59B.getR49_others3().intValue());
			}
			Cell R49cell34 = R49row.getCell(36);
			if (R49cell34 != null) {
				R49cell34.setCellValue(brf59B.getR49_foreign1() == null ? 0 : brf59B.getR49_foreign1().intValue());
			}
			Cell R49cell35 = R49row.getCell(37);
			if (R49cell35 != null) {
				R49cell35.setCellValue(brf59B.getR49_guarantees() == null ? 0 : brf59B.getR49_guarantees().intValue());
			}
			Cell R49cell36 = R49row.getCell(38);
			if (R49cell36 != null) {
				R49cell36.setCellValue(brf59B.getR49_nbfi2() == null ? 0 : brf59B.getR49_nbfi2().intValue());
			}
			Cell R49cell37 = R49row.getCell(39);
			if (R49cell37 != null) {
				R49cell37.setCellValue(brf59B.getR49_interbank2() == null ? 0 : brf59B.getR49_interbank2().intValue());
			}
			Cell R49cell38 = R49row.getCell(40);
			if (R49cell38 != null) {
				R49cell38.setCellValue(brf59B.getR49_gov5() == null ? 0 : brf59B.getR49_gov5().intValue());
			}
			Cell R49cell39 = R49row.getCell(41);
			if (R49cell39 != null) {
				R49cell39.setCellValue(brf59B.getR49_corporate2() == null ? 0 : brf59B.getR49_corporate2().intValue());
			}
			Cell R49cell40 = R49row.getCell(42);
			if (R49cell40 != null) {
				R49cell40.setCellValue(brf59B.getR49_gre2() == null ? 0 : brf59B.getR49_gre2().intValue());
			}
			Cell R49cell41 = R49row.getCell(43);
			if (R49cell41 != null) {
				R49cell41.setCellValue(
						brf59B.getR49_individuals3() == null ? 0 : brf59B.getR49_individuals3().intValue());
			}
			Cell R49cell42 = R49row.getCell(44);
			if (R49cell42 != null) {
				R49cell42.setCellValue(brf59B.getR49_zero1() == null ? 0 : brf59B.getR49_zero1().intValue());
			}
			Cell R49cell43 = R49row.getCell(45);
			if (R49cell43 != null) {
				R49cell43.setCellValue(brf59B.getR49_three1() == null ? 0 : brf59B.getR49_three1().intValue());
			}
			Cell R49cell44 = R49row.getCell(46);
			if (R49cell44 != null) {
				R49cell44.setCellValue(brf59B.getR49_six1() == null ? 0 : brf59B.getR49_six1().intValue());
			}
			Cell R49cell45 = R49row.getCell(47);
			if (R49cell45 != null) {
				R49cell45.setCellValue(brf59B.getR49_oneyear1() == null ? 0 : brf59B.getR49_oneyear1().intValue());
			}
			Cell R49cell46 = R49row.getCell(48);
			if (R49cell46 != null) {
				R49cell46.setCellValue(brf59B.getR49_empty() == null ? "" : brf59B.getR49_empty().toString());
			}
			Row R50row = sheet.getRow(67);
			Cell R50cell1 = R50row.getCell(3);
			if (R50cell1 != null) {
				R50cell1.setCellValue(brf59B.getR50_nbfi() == null ? 0 : brf59B.getR50_nbfi().intValue());
			}

			Cell R50cell2 = R50row.getCell(4);
			if (R50cell2 != null) {
				R50cell2.setCellValue(brf59B.getR50_interbank() == null ? 0 : brf59B.getR50_interbank().intValue());
			}
			Cell R50cell3 = R50row.getCell(5);
			if (R50cell3 != null) {
				R50cell3.setCellValue(brf59B.getR50_gov() == null ? 0 : brf59B.getR50_gov().intValue());
			}
			Cell R50cell4 = R50row.getCell(6);
			if (R50cell4 != null) {
				R50cell4.setCellValue(brf59B.getR50_corporate() == null ? 0 : brf59B.getR50_corporate().intValue());
			}
			Cell R50cell5 = R50row.getCell(7);
			if (R50cell5 != null) {
				R50cell5.setCellValue(brf59B.getR50_gre() == null ? 0 : brf59B.getR50_gre().intValue());
			}
			Cell R50cell6 = R50row.getCell(8);
			if (R50cell6 != null) {
				R50cell6.setCellValue(brf59B.getR50_trade() == null ? 0 : brf59B.getR50_trade().intValue());
			}
			Cell R50cell7 = R50row.getCell(9);
			if (R50cell7 != null) {
				R50cell7.setCellValue(brf59B.getR50_individuals() == null ? 0 : brf59B.getR50_individuals().intValue());
			}
			Cell R50cell8 = R50row.getCell(10);
			if (R50cell8 != null) {
				R50cell8.setCellValue(brf59B.getR50_investment() == null ? 0 : brf59B.getR50_investment().intValue());
			}
			Cell R50cell9 = R50row.getCell(11);
			if (R50cell9 != null) {
				R50cell9.setCellValue(brf59B.getR50_nbfi1() == null ? 0 : brf59B.getR50_nbfi1().intValue());
			}
			Cell R50cell10 = R50row.getCell(12);
			if (R50cell10 != null) {
				R50cell10.setCellValue(brf59B.getR50_interbank1() == null ? 0 : brf59B.getR50_interbank1().intValue());
			}
			Cell R50cell11 = R50row.getCell(13);
			if (R50cell11 != null) {
				R50cell11.setCellValue(brf59B.getR50_gov1() == null ? 0 : brf59B.getR50_gov1().intValue());
			}
			Cell R50cell12 = R50row.getCell(14);
			if (R50cell12 != null) {
				R50cell12.setCellValue(brf59B.getR50_corporate1() == null ? 0 : brf59B.getR50_corporate1().intValue());
			}
			Cell R50cell13 = R50row.getCell(15);
			if (R50cell13 != null) {
				R50cell13.setCellValue(brf59B.getR50_gre1() == null ? 0 : brf59B.getR50_gre1().intValue());
			}
			Cell R50cell14 = R50row.getCell(16);
			if (R50cell14 != null) {
				R50cell14.setCellValue(brf59B.getR50_trade1() == null ? 0 : brf59B.getR50_trade1().intValue());
			}
			Cell R50cell15 = R50row.getCell(17);
			if (R50cell15 != null) {
				R50cell15.setCellValue(
						brf59B.getR50_individuals1() == null ? 0 : brf59B.getR50_individuals1().intValue());
			}
			Cell R50cell16 = R50row.getCell(18);
			if (R50cell16 != null) {
				R50cell16
						.setCellValue(brf59B.getR50_investment1() == null ? 0 : brf59B.getR50_investment1().intValue());
			}
			Cell R50cell17 = R50row.getCell(19);
			if (R50cell17 != null) {
				R50cell17.setCellValue(brf59B.getR50_zer0() == null ? 0 : brf59B.getR50_zer0().intValue());
			}
			Cell R50cell18 = R50row.getCell(20);
			if (R50cell18 != null) {
				R50cell18.setCellValue(brf59B.getR50_three() == null ? 0 : brf59B.getR50_three().intValue());
			}
			Cell R50cell19 = R50row.getCell(21);
			if (R50cell19 != null) {
				R50cell19.setCellValue(brf59B.getR50_six() == null ? 0 : brf59B.getR50_six().intValue());
			}
			Cell R50cell20 = R50row.getCell(22);
			if (R50cell20 != null) {
				R50cell20.setCellValue(brf59B.getR50_oneyear() == null ? 0 : brf59B.getR50_oneyear().intValue());
			}
			Cell R50cell21 = R50row.getCell(23);
			if (R50cell21 != null) {
				R50cell21.setCellValue(brf59B.getR50_foreign() == null ? 0 : brf59B.getR50_foreign().intValue());
			}
			Cell R50cell22 = R50row.getCell(24);
			if (R50cell22 != null) {
				R50cell22.setCellValue(brf59B.getR50_banks() == null ? 0 : brf59B.getR50_banks().intValue());
			}
			Cell R50cell23 = R50row.getCell(25);
			if (R50cell23 != null) {
				R50cell23.setCellValue(brf59B.getR50_gov2() == null ? 0 : brf59B.getR50_gov2().intValue());
			}
			Cell R50cell24 = R50row.getCell(26);
			if (R50cell24 != null) {
				R50cell24.setCellValue(brf59B.getR50_other() == null ? 0 : brf59B.getR50_other().intValue());
			}
			Cell R50cell25 = R50row.getCell(27);
			if (R50cell25 != null) {
				R50cell25.setCellValue(brf59B.getR50_banks1() == null ? 0 : brf59B.getR50_banks1().intValue());
			}
			Cell R50cell26 = R50row.getCell(28);
			if (R50cell26 != null) {
				R50cell26.setCellValue(
						brf59B.getR50_individuals2() == null ? 0 : brf59B.getR50_individuals2().intValue());
			}
			Cell R50cell27 = R50row.getCell(29);
			if (R50cell27 != null) {
				R50cell27.setCellValue(brf59B.getR50_other1() == null ? 0 : brf59B.getR50_other1().intValue());
			}
			Cell R50cell28 = R50row.getCell(30);
			if (R50cell28 != null) {
				R50cell28.setCellValue(brf59B.getR50_banks2() == null ? 0 : brf59B.getR50_banks2().intValue());
			}
			Cell R50cell29 = R50row.getCell(31);
			if (R50cell29 != null) {
				R50cell29.setCellValue(brf59B.getR50_gov3() == null ? 0 : brf59B.getR50_gov3().intValue());
			}
			Cell R50cell30 = R50row.getCell(32);
			if (R50cell30 != null) {
				R50cell30.setCellValue(brf59B.getR50_others2() == null ? 0 : brf59B.getR50_others2().intValue());
			}
			Cell R50cell31 = R50row.getCell(33);
			if (R50cell31 != null) {
				R50cell31.setCellValue(brf59B.getR50_banks3() == null ? 0 : brf59B.getR50_banks3().intValue());
			}
			Cell R50cell32 = R50row.getCell(34);
			if (R50cell32 != null) {
				R50cell32.setCellValue(brf59B.getR50_gov4() == null ? 0 : brf59B.getR50_gov4().intValue());
			}
			Cell R50cell33 = R50row.getCell(35);
			if (R50cell33 != null) {
				R50cell33.setCellValue(brf59B.getR50_others3() == null ? 0 : brf59B.getR50_others3().intValue());
			}
			Cell R50cell34 = R50row.getCell(36);
			if (R50cell34 != null) {
				R50cell34.setCellValue(brf59B.getR50_foreign1() == null ? 0 : brf59B.getR50_foreign1().intValue());
			}
			Cell R50cell35 = R50row.getCell(37);
			if (R50cell35 != null) {
				R50cell35.setCellValue(brf59B.getR50_guarantees() == null ? 0 : brf59B.getR50_guarantees().intValue());
			}
			Cell R50cell36 = R50row.getCell(38);
			if (R50cell36 != null) {
				R50cell36.setCellValue(brf59B.getR50_nbfi2() == null ? 0 : brf59B.getR50_nbfi2().intValue());
			}
			Cell R50cell37 = R50row.getCell(39);
			if (R50cell37 != null) {
				R50cell37.setCellValue(brf59B.getR50_interbank2() == null ? 0 : brf59B.getR50_interbank2().intValue());
			}
			Cell R50cell38 = R50row.getCell(40);
			if (R50cell38 != null) {
				R50cell38.setCellValue(brf59B.getR50_gov5() == null ? 0 : brf59B.getR50_gov5().intValue());
			}
			Cell R50cell39 = R50row.getCell(41);
			if (R50cell39 != null) {
				R50cell39.setCellValue(brf59B.getR50_corporate2() == null ? 0 : brf59B.getR50_corporate2().intValue());
			}
			Cell R50cell40 = R50row.getCell(42);
			if (R50cell40 != null) {
				R50cell40.setCellValue(brf59B.getR50_gre2() == null ? 0 : brf59B.getR50_gre2().intValue());
			}
			Cell R50cell41 = R50row.getCell(43);
			if (R50cell41 != null) {
				R50cell41.setCellValue(
						brf59B.getR50_individuals3() == null ? 0 : brf59B.getR50_individuals3().intValue());
			}
			Cell R50cell42 = R50row.getCell(44);
			if (R50cell42 != null) {
				R50cell42.setCellValue(brf59B.getR50_zero1() == null ? 0 : brf59B.getR50_zero1().intValue());
			}
			Cell R50cell43 = R50row.getCell(45);
			if (R50cell43 != null) {
				R50cell43.setCellValue(brf59B.getR50_three1() == null ? 0 : brf59B.getR50_three1().intValue());
			}
			Cell R50cell44 = R50row.getCell(46);
			if (R50cell44 != null) {
				R50cell44.setCellValue(brf59B.getR50_six1() == null ? 0 : brf59B.getR50_six1().intValue());
			}
			Cell R50cell45 = R50row.getCell(47);
			if (R50cell45 != null) {
				R50cell45.setCellValue(brf59B.getR50_oneyear1() == null ? 0 : brf59B.getR50_oneyear1().intValue());
			}
			Cell R50cell46 = R50row.getCell(48);
			if (R50cell46 != null) {
				R50cell46.setCellValue(brf59B.getR50_empty() == null ? "" : brf59B.getR50_empty().toString());
			}
			Row R51row = sheet.getRow(68);
			Cell R51cell1 = R51row.getCell(3);
			if (R51cell1 != null) {
				R51cell1.setCellValue(brf59B.getR51_nbfi() == null ? 0 : brf59B.getR51_nbfi().intValue());
			}

			Cell R51cell2 = R51row.getCell(4);
			if (R51cell2 != null) {
				R51cell2.setCellValue(brf59B.getR51_interbank() == null ? 0 : brf59B.getR51_interbank().intValue());
			}
			Cell R51cell3 = R51row.getCell(5);
			if (R51cell3 != null) {
				R51cell3.setCellValue(brf59B.getR51_gov() == null ? 0 : brf59B.getR51_gov().intValue());
			}
			Cell R51cell4 = R51row.getCell(6);
			if (R51cell4 != null) {
				R51cell4.setCellValue(brf59B.getR51_corporate() == null ? 0 : brf59B.getR51_corporate().intValue());
			}
			Cell R51cell5 = R51row.getCell(7);
			if (R51cell5 != null) {
				R51cell5.setCellValue(brf59B.getR51_gre() == null ? 0 : brf59B.getR51_gre().intValue());
			}
			Cell R51cell6 = R51row.getCell(8);
			if (R51cell6 != null) {
				R51cell6.setCellValue(brf59B.getR51_trade() == null ? 0 : brf59B.getR51_trade().intValue());
			}
			Cell R51cell7 = R51row.getCell(9);
			if (R51cell7 != null) {
				R51cell7.setCellValue(brf59B.getR51_individuals() == null ? 0 : brf59B.getR51_individuals().intValue());
			}
			Cell R51cell8 = R51row.getCell(10);
			if (R51cell8 != null) {
				R51cell8.setCellValue(brf59B.getR51_investment() == null ? 0 : brf59B.getR51_investment().intValue());
			}
			Cell R51cell9 = R51row.getCell(11);
			if (R51cell9 != null) {
				R51cell9.setCellValue(brf59B.getR51_nbfi1() == null ? 0 : brf59B.getR51_nbfi1().intValue());
			}
			Cell R51cell10 = R51row.getCell(12);
			if (R51cell10 != null) {
				R51cell10.setCellValue(brf59B.getR51_interbank1() == null ? 0 : brf59B.getR51_interbank1().intValue());
			}
			Cell R51cell11 = R51row.getCell(13);
			if (R51cell11 != null) {
				R51cell11.setCellValue(brf59B.getR51_gov1() == null ? 0 : brf59B.getR51_gov1().intValue());
			}
			Cell R51cell12 = R51row.getCell(14);
			if (R51cell12 != null) {
				R51cell12.setCellValue(brf59B.getR51_corporate1() == null ? 0 : brf59B.getR51_corporate1().intValue());
			}
			Cell R51cell13 = R51row.getCell(15);
			if (R51cell13 != null) {
				R51cell13.setCellValue(brf59B.getR51_gre1() == null ? 0 : brf59B.getR51_gre1().intValue());
			}
			Cell R51cell14 = R51row.getCell(16);
			if (R51cell14 != null) {
				R51cell14.setCellValue(brf59B.getR51_trade1() == null ? 0 : brf59B.getR51_trade1().intValue());
			}
			Cell R51cell15 = R51row.getCell(17);
			if (R51cell15 != null) {
				R51cell15.setCellValue(
						brf59B.getR51_individuals1() == null ? 0 : brf59B.getR51_individuals1().intValue());
			}
			Cell R51cell16 = R51row.getCell(18);
			if (R51cell16 != null) {
				R51cell16
						.setCellValue(brf59B.getR51_investment1() == null ? 0 : brf59B.getR51_investment1().intValue());
			}
			Cell R51cell17 = R51row.getCell(19);
			if (R51cell17 != null) {
				R51cell17.setCellValue(brf59B.getR51_zer0() == null ? 0 : brf59B.getR51_zer0().intValue());
			}
			Cell R51cell18 = R51row.getCell(20);
			if (R51cell18 != null) {
				R51cell18.setCellValue(brf59B.getR51_three() == null ? 0 : brf59B.getR51_three().intValue());
			}
			Cell R51cell19 = R51row.getCell(21);
			if (R51cell19 != null) {
				R51cell19.setCellValue(brf59B.getR51_six() == null ? 0 : brf59B.getR51_six().intValue());
			}
			Cell R51cell20 = R51row.getCell(22);
			if (R51cell20 != null) {
				R51cell20.setCellValue(brf59B.getR51_oneyear() == null ? 0 : brf59B.getR51_oneyear().intValue());
			}
			Cell R51cell21 = R51row.getCell(23);
			if (R51cell21 != null) {
				R51cell21.setCellValue(brf59B.getR51_foreign() == null ? 0 : brf59B.getR51_foreign().intValue());
			}
			Cell R51cell22 = R51row.getCell(24);
			if (R51cell22 != null) {
				R51cell22.setCellValue(brf59B.getR51_banks() == null ? 0 : brf59B.getR51_banks().intValue());
			}
			Cell R51cell23 = R51row.getCell(25);
			if (R51cell23 != null) {
				R51cell23.setCellValue(brf59B.getR51_gov2() == null ? 0 : brf59B.getR51_gov2().intValue());
			}
			Cell R51cell24 = R51row.getCell(26);
			if (R51cell24 != null) {
				R51cell24.setCellValue(brf59B.getR51_other() == null ? 0 : brf59B.getR51_other().intValue());
			}
			Cell R51cell25 = R51row.getCell(27);
			if (R51cell25 != null) {
				R51cell25.setCellValue(brf59B.getR51_banks1() == null ? 0 : brf59B.getR51_banks1().intValue());
			}
			Cell R51cell26 = R51row.getCell(28);
			if (R51cell26 != null) {
				R51cell26.setCellValue(
						brf59B.getR51_individuals2() == null ? 0 : brf59B.getR51_individuals2().intValue());
			}
			Cell R51cell27 = R51row.getCell(29);
			if (R51cell27 != null) {
				R51cell27.setCellValue(brf59B.getR51_other1() == null ? 0 : brf59B.getR51_other1().intValue());
			}
			Cell R51cell28 = R51row.getCell(30);
			if (R51cell28 != null) {
				R51cell28.setCellValue(brf59B.getR51_banks2() == null ? 0 : brf59B.getR51_banks2().intValue());
			}
			Cell R51cell29 = R51row.getCell(31);
			if (R51cell29 != null) {
				R51cell29.setCellValue(brf59B.getR51_gov3() == null ? 0 : brf59B.getR51_gov3().intValue());
			}
			Cell R51cell30 = R51row.getCell(32);
			if (R51cell30 != null) {
				R51cell30.setCellValue(brf59B.getR51_others2() == null ? 0 : brf59B.getR51_others2().intValue());
			}
			Cell R51cell31 = R51row.getCell(33);
			if (R51cell31 != null) {
				R51cell31.setCellValue(brf59B.getR51_banks3() == null ? 0 : brf59B.getR51_banks3().intValue());
			}
			Cell R51cell32 = R51row.getCell(34);
			if (R51cell32 != null) {
				R51cell32.setCellValue(brf59B.getR51_gov4() == null ? 0 : brf59B.getR51_gov4().intValue());
			}
			Cell R51cell33 = R51row.getCell(35);
			if (R51cell33 != null) {
				R51cell33.setCellValue(brf59B.getR51_others3() == null ? 0 : brf59B.getR51_others3().intValue());
			}
			Cell R51cell34 = R51row.getCell(36);
			if (R51cell34 != null) {
				R51cell34.setCellValue(brf59B.getR51_foreign1() == null ? 0 : brf59B.getR51_foreign1().intValue());
			}
			Cell R51cell35 = R51row.getCell(37);
			if (R51cell35 != null) {
				R51cell35.setCellValue(brf59B.getR51_guarantees() == null ? 0 : brf59B.getR51_guarantees().intValue());
			}
			Cell R51cell36 = R51row.getCell(38);
			if (R51cell36 != null) {
				R51cell36.setCellValue(brf59B.getR51_nbfi2() == null ? 0 : brf59B.getR51_nbfi2().intValue());
			}
			Cell R51cell37 = R51row.getCell(39);
			if (R51cell37 != null) {
				R51cell37.setCellValue(brf59B.getR51_interbank2() == null ? 0 : brf59B.getR51_interbank2().intValue());
			}
			Cell R51cell38 = R51row.getCell(40);
			if (R51cell38 != null) {
				R51cell38.setCellValue(brf59B.getR51_gov5() == null ? 0 : brf59B.getR51_gov5().intValue());
			}
			Cell R51cell39 = R51row.getCell(41);
			if (R51cell39 != null) {
				R51cell39.setCellValue(brf59B.getR51_corporate2() == null ? 0 : brf59B.getR51_corporate2().intValue());
			}
			Cell R51cell40 = R51row.getCell(42);
			if (R51cell40 != null) {
				R51cell40.setCellValue(brf59B.getR51_gre2() == null ? 0 : brf59B.getR51_gre2().intValue());
			}
			Cell R51cell41 = R51row.getCell(43);
			if (R51cell41 != null) {
				R51cell41.setCellValue(
						brf59B.getR51_individuals3() == null ? 0 : brf59B.getR51_individuals3().intValue());
			}
			Cell R51cell42 = R51row.getCell(44);
			if (R51cell42 != null) {
				R51cell42.setCellValue(brf59B.getR51_zero1() == null ? 0 : brf59B.getR51_zero1().intValue());
			}
			Cell R51cell43 = R51row.getCell(45);
			if (R51cell43 != null) {
				R51cell43.setCellValue(brf59B.getR51_three1() == null ? 0 : brf59B.getR51_three1().intValue());
			}
			Cell R51cell44 = R51row.getCell(46);
			if (R51cell44 != null) {
				R51cell44.setCellValue(brf59B.getR51_six1() == null ? 0 : brf59B.getR51_six1().intValue());
			}
			Cell R51cell45 = R51row.getCell(47);
			if (R51cell45 != null) {
				R51cell45.setCellValue(brf59B.getR51_oneyear1() == null ? 0 : brf59B.getR51_oneyear1().intValue());
			}
			Cell R51cell46 = R51row.getCell(48);
			if (R51cell46 != null) {
				R51cell46.setCellValue(brf59B.getR51_empty() == null ? "" : brf59B.getR51_empty().toString());
			}
			Row R53row = sheet.getRow(70);
			Cell R53cell1 = R53row.getCell(3);
			if (R53cell1 != null) {
				R53cell1.setCellValue(brf59B.getR53_nbfi() == null ? 0 : brf59B.getR53_nbfi().intValue());
			}

			Cell R53cell2 = R53row.getCell(4);
			if (R53cell2 != null) {
				R53cell2.setCellValue(brf59B.getR53_interbank() == null ? 0 : brf59B.getR53_interbank().intValue());
			}
			Cell R53cell3 = R53row.getCell(5);
			if (R53cell3 != null) {
				R53cell3.setCellValue(brf59B.getR53_gov() == null ? 0 : brf59B.getR53_gov().intValue());
			}
			Cell R53cell4 = R53row.getCell(6);
			if (R53cell4 != null) {
				R53cell4.setCellValue(brf59B.getR53_corporate() == null ? 0 : brf59B.getR53_corporate().intValue());
			}
			Cell R53cell5 = R53row.getCell(7);
			if (R53cell5 != null) {
				R53cell5.setCellValue(brf59B.getR53_gre() == null ? 0 : brf59B.getR53_gre().intValue());
			}
			Cell R53cell6 = R53row.getCell(8);
			if (R53cell6 != null) {
				R53cell6.setCellValue(brf59B.getR53_trade() == null ? 0 : brf59B.getR53_trade().intValue());
			}
			Cell R53cell7 = R53row.getCell(9);
			if (R53cell7 != null) {
				R53cell7.setCellValue(brf59B.getR53_individuals() == null ? 0 : brf59B.getR53_individuals().intValue());
			}
			Cell R53cell8 = R53row.getCell(10);
			if (R53cell8 != null) {
				R53cell8.setCellValue(brf59B.getR53_investment() == null ? 0 : brf59B.getR53_investment().intValue());
			}
			Cell R53cell9 = R53row.getCell(11);
			if (R53cell9 != null) {
				R53cell9.setCellValue(brf59B.getR53_nbfi1() == null ? 0 : brf59B.getR53_nbfi1().intValue());
			}
			Cell R53cell10 = R53row.getCell(12);
			if (R53cell10 != null) {
				R53cell10.setCellValue(brf59B.getR53_interbank1() == null ? 0 : brf59B.getR53_interbank1().intValue());
			}
			Cell R53cell11 = R53row.getCell(13);
			if (R53cell11 != null) {
				R53cell11.setCellValue(brf59B.getR53_gov1() == null ? 0 : brf59B.getR53_gov1().intValue());
			}
			Cell R53cell12 = R53row.getCell(14);
			if (R53cell12 != null) {
				R53cell12.setCellValue(brf59B.getR53_corporate1() == null ? 0 : brf59B.getR53_corporate1().intValue());
			}
			Cell R53cell13 = R53row.getCell(15);
			if (R53cell13 != null) {
				R53cell13.setCellValue(brf59B.getR53_gre1() == null ? 0 : brf59B.getR53_gre1().intValue());
			}
			Cell R53cell14 = R53row.getCell(16);
			if (R53cell14 != null) {
				R53cell14.setCellValue(brf59B.getR53_trade1() == null ? 0 : brf59B.getR53_trade1().intValue());
			}
			Cell R53cell15 = R53row.getCell(17);
			if (R53cell15 != null) {
				R53cell15.setCellValue(
						brf59B.getR53_individuals1() == null ? 0 : brf59B.getR53_individuals1().intValue());
			}
			Cell R53cell16 = R53row.getCell(18);
			if (R53cell16 != null) {
				R53cell16
						.setCellValue(brf59B.getR53_investment1() == null ? 0 : brf59B.getR53_investment1().intValue());
			}
			Cell R53cell17 = R53row.getCell(19);
			if (R53cell17 != null) {
				R53cell17.setCellValue(brf59B.getR53_zer0() == null ? 0 : brf59B.getR53_zer0().intValue());
			}
			Cell R53cell18 = R53row.getCell(20);
			if (R53cell18 != null) {
				R53cell18.setCellValue(brf59B.getR53_three() == null ? 0 : brf59B.getR53_three().intValue());
			}
			Cell R53cell19 = R53row.getCell(21);
			if (R53cell19 != null) {
				R53cell19.setCellValue(brf59B.getR53_six() == null ? 0 : brf59B.getR53_six().intValue());
			}
			Cell R53cell20 = R53row.getCell(22);
			if (R53cell20 != null) {
				R53cell20.setCellValue(brf59B.getR53_oneyear() == null ? 0 : brf59B.getR53_oneyear().intValue());
			}
			Cell R53cell21 = R53row.getCell(23);
			if (R53cell21 != null) {
				R53cell21.setCellValue(brf59B.getR53_foreign() == null ? 0 : brf59B.getR53_foreign().intValue());
			}
			Cell R53cell22 = R53row.getCell(24);
			if (R53cell22 != null) {
				R53cell22.setCellValue(brf59B.getR53_banks() == null ? 0 : brf59B.getR53_banks().intValue());
			}
			Cell R53cell23 = R53row.getCell(25);
			if (R53cell23 != null) {
				R53cell23.setCellValue(brf59B.getR53_gov2() == null ? 0 : brf59B.getR53_gov2().intValue());
			}
			Cell R53cell24 = R53row.getCell(26);
			if (R53cell24 != null) {
				R53cell24.setCellValue(brf59B.getR53_other() == null ? 0 : brf59B.getR53_other().intValue());
			}
			Cell R53cell25 = R53row.getCell(27);
			if (R53cell25 != null) {
				R53cell25.setCellValue(brf59B.getR53_banks1() == null ? 0 : brf59B.getR53_banks1().intValue());
			}
			Cell R53cell26 = R53row.getCell(28);
			if (R53cell26 != null) {
				R53cell26.setCellValue(
						brf59B.getR53_individuals2() == null ? 0 : brf59B.getR53_individuals2().intValue());
			}
			Cell R53cell27 = R53row.getCell(29);
			if (R53cell27 != null) {
				R53cell27.setCellValue(brf59B.getR53_other1() == null ? 0 : brf59B.getR53_other1().intValue());
			}
			Cell R53cell28 = R53row.getCell(30);
			if (R53cell28 != null) {
				R53cell28.setCellValue(brf59B.getR53_banks2() == null ? 0 : brf59B.getR53_banks2().intValue());
			}
			Cell R53cell29 = R53row.getCell(31);
			if (R53cell29 != null) {
				R53cell29.setCellValue(brf59B.getR53_gov3() == null ? 0 : brf59B.getR53_gov3().intValue());
			}
			Cell R53cell30 = R53row.getCell(32);
			if (R53cell30 != null) {
				R53cell30.setCellValue(brf59B.getR53_others2() == null ? 0 : brf59B.getR53_others2().intValue());
			}
			Cell R53cell31 = R53row.getCell(33);
			if (R53cell31 != null) {
				R53cell31.setCellValue(brf59B.getR53_banks3() == null ? 0 : brf59B.getR53_banks3().intValue());
			}
			Cell R53cell32 = R53row.getCell(34);
			if (R53cell32 != null) {
				R53cell32.setCellValue(brf59B.getR53_gov4() == null ? 0 : brf59B.getR53_gov4().intValue());
			}
			Cell R53cell33 = R53row.getCell(35);
			if (R53cell33 != null) {
				R53cell33.setCellValue(brf59B.getR53_others3() == null ? 0 : brf59B.getR53_others3().intValue());
			}
			Cell R53cell34 = R53row.getCell(36);
			if (R53cell34 != null) {
				R53cell34.setCellValue(brf59B.getR53_foreign1() == null ? 0 : brf59B.getR53_foreign1().intValue());
			}
			Cell R53cell35 = R53row.getCell(37);
			if (R53cell35 != null) {
				R53cell35.setCellValue(brf59B.getR53_guarantees() == null ? 0 : brf59B.getR53_guarantees().intValue());
			}
			Cell R53cell36 = R53row.getCell(38);
			if (R53cell36 != null) {
				R53cell36.setCellValue(brf59B.getR53_nbfi2() == null ? 0 : brf59B.getR53_nbfi2().intValue());
			}
			Cell R53cell37 = R53row.getCell(39);
			if (R53cell37 != null) {
				R53cell37.setCellValue(brf59B.getR53_interbank2() == null ? 0 : brf59B.getR53_interbank2().intValue());
			}
			Cell R53cell38 = R53row.getCell(40);
			if (R53cell38 != null) {
				R53cell38.setCellValue(brf59B.getR53_gov5() == null ? 0 : brf59B.getR53_gov5().intValue());
			}
			Cell R53cell39 = R53row.getCell(41);
			if (R53cell39 != null) {
				R53cell39.setCellValue(brf59B.getR53_corporate2() == null ? 0 : brf59B.getR53_corporate2().intValue());
			}
			Cell R53cell40 = R53row.getCell(42);
			if (R53cell40 != null) {
				R53cell40.setCellValue(brf59B.getR53_gre2() == null ? 0 : brf59B.getR53_gre2().intValue());
			}
			Cell R53cell41 = R53row.getCell(43);
			if (R53cell41 != null) {
				R53cell41.setCellValue(
						brf59B.getR53_individuals3() == null ? 0 : brf59B.getR53_individuals3().intValue());
			}
			Cell R53cell42 = R53row.getCell(44);
			if (R53cell42 != null) {
				R53cell42.setCellValue(brf59B.getR53_zero1() == null ? 0 : brf59B.getR53_zero1().intValue());
			}
			Cell R53cell43 = R53row.getCell(45);
			if (R53cell43 != null) {
				R53cell43.setCellValue(brf59B.getR53_three1() == null ? 0 : brf59B.getR53_three1().intValue());
			}
			Cell R53cell44 = R53row.getCell(46);
			if (R53cell44 != null) {
				R53cell44.setCellValue(brf59B.getR53_six1() == null ? 0 : brf59B.getR53_six1().intValue());
			}
			Cell R53cell45 = R53row.getCell(47);
			if (R53cell45 != null) {
				R53cell45.setCellValue(brf59B.getR53_oneyear1() == null ? 0 : brf59B.getR53_oneyear1().intValue());
			}
			Cell R53cell46 = R53row.getCell(48);
			if (R53cell46 != null) {
				R53cell46.setCellValue(brf59B.getR53_empty() == null ? "" : brf59B.getR53_empty().toString());
			}
			Row R54row = sheet.getRow(71);
			Cell R54cell1 = R54row.getCell(3);
			if (R54cell1 != null) {
				R54cell1.setCellValue(brf59B.getR54_nbfi() == null ? 0 : brf59B.getR54_nbfi().intValue());
			}

			Cell R54cell2 = R54row.getCell(4);
			if (R54cell2 != null) {
				R54cell2.setCellValue(brf59B.getR54_interbank() == null ? 0 : brf59B.getR54_interbank().intValue());
			}
			Cell R54cell3 = R54row.getCell(5);
			if (R54cell3 != null) {
				R54cell3.setCellValue(brf59B.getR54_gov() == null ? 0 : brf59B.getR54_gov().intValue());
			}
			Cell R54cell4 = R54row.getCell(6);
			if (R54cell4 != null) {
				R54cell4.setCellValue(brf59B.getR54_corporate() == null ? 0 : brf59B.getR54_corporate().intValue());
			}
			Cell R54cell5 = R54row.getCell(7);
			if (R54cell5 != null) {
				R54cell5.setCellValue(brf59B.getR54_gre() == null ? 0 : brf59B.getR54_gre().intValue());
			}
			Cell R54cell6 = R54row.getCell(8);
			if (R54cell6 != null) {
				R54cell6.setCellValue(brf59B.getR54_trade() == null ? 0 : brf59B.getR54_trade().intValue());
			}
			Cell R54cell7 = R54row.getCell(9);
			if (R54cell7 != null) {
				R54cell7.setCellValue(brf59B.getR54_individuals() == null ? 0 : brf59B.getR54_individuals().intValue());
			}
			Cell R54cell8 = R54row.getCell(10);
			if (R54cell8 != null) {
				R54cell8.setCellValue(brf59B.getR54_investment() == null ? 0 : brf59B.getR54_investment().intValue());
			}
			Cell R54cell9 = R54row.getCell(11);
			if (R54cell9 != null) {
				R54cell9.setCellValue(brf59B.getR54_nbfi1() == null ? 0 : brf59B.getR54_nbfi1().intValue());
			}
			Cell R54cell10 = R54row.getCell(12);
			if (R54cell10 != null) {
				R54cell10.setCellValue(brf59B.getR54_interbank1() == null ? 0 : brf59B.getR54_interbank1().intValue());
			}
			Cell R54cell11 = R54row.getCell(13);
			if (R54cell11 != null) {
				R54cell11.setCellValue(brf59B.getR54_gov1() == null ? 0 : brf59B.getR54_gov1().intValue());
			}
			Cell R54cell12 = R54row.getCell(14);
			if (R54cell12 != null) {
				R54cell12.setCellValue(brf59B.getR54_corporate1() == null ? 0 : brf59B.getR54_corporate1().intValue());
			}
			Cell R54cell13 = R54row.getCell(15);
			if (R54cell13 != null) {
				R54cell13.setCellValue(brf59B.getR54_gre1() == null ? 0 : brf59B.getR54_gre1().intValue());
			}
			Cell R54cell14 = R54row.getCell(16);
			if (R54cell14 != null) {
				R54cell14.setCellValue(brf59B.getR54_trade1() == null ? 0 : brf59B.getR54_trade1().intValue());
			}
			Cell R54cell15 = R54row.getCell(17);
			if (R54cell15 != null) {
				R54cell15.setCellValue(
						brf59B.getR54_individuals1() == null ? 0 : brf59B.getR54_individuals1().intValue());
			}
			Cell R54cell16 = R54row.getCell(18);
			if (R54cell16 != null) {
				R54cell16
						.setCellValue(brf59B.getR54_investment1() == null ? 0 : brf59B.getR54_investment1().intValue());
			}
			Cell R54cell17 = R54row.getCell(19);
			if (R54cell17 != null) {
				R54cell17.setCellValue(brf59B.getR54_zer0() == null ? 0 : brf59B.getR54_zer0().intValue());
			}
			Cell R54cell18 = R54row.getCell(20);
			if (R54cell18 != null) {
				R54cell18.setCellValue(brf59B.getR54_three() == null ? 0 : brf59B.getR54_three().intValue());
			}
			Cell R54cell19 = R54row.getCell(21);
			if (R54cell19 != null) {
				R54cell19.setCellValue(brf59B.getR54_six() == null ? 0 : brf59B.getR54_six().intValue());
			}
			Cell R54cell20 = R54row.getCell(22);
			if (R54cell20 != null) {
				R54cell20.setCellValue(brf59B.getR54_oneyear() == null ? 0 : brf59B.getR54_oneyear().intValue());
			}
			Cell R54cell21 = R54row.getCell(23);
			if (R54cell21 != null) {
				R54cell21.setCellValue(brf59B.getR54_foreign() == null ? 0 : brf59B.getR54_foreign().intValue());
			}
			Cell R54cell22 = R54row.getCell(24);
			if (R54cell22 != null) {
				R54cell22.setCellValue(brf59B.getR54_banks() == null ? 0 : brf59B.getR54_banks().intValue());
			}
			Cell R54cell23 = R54row.getCell(25);
			if (R54cell23 != null) {
				R54cell23.setCellValue(brf59B.getR54_gov2() == null ? 0 : brf59B.getR54_gov2().intValue());
			}
			Cell R54cell24 = R54row.getCell(26);
			if (R54cell24 != null) {
				R54cell24.setCellValue(brf59B.getR54_other() == null ? 0 : brf59B.getR54_other().intValue());
			}
			Cell R54cell25 = R54row.getCell(27);
			if (R54cell25 != null) {
				R54cell25.setCellValue(brf59B.getR54_banks1() == null ? 0 : brf59B.getR54_banks1().intValue());
			}
			Cell R54cell26 = R54row.getCell(28);
			if (R54cell26 != null) {
				R54cell26.setCellValue(
						brf59B.getR54_individuals2() == null ? 0 : brf59B.getR54_individuals2().intValue());
			}
			Cell R54cell27 = R54row.getCell(29);
			if (R54cell27 != null) {
				R54cell27.setCellValue(brf59B.getR54_other1() == null ? 0 : brf59B.getR54_other1().intValue());
			}
			Cell R54cell28 = R54row.getCell(30);
			if (R54cell28 != null) {
				R54cell28.setCellValue(brf59B.getR54_banks2() == null ? 0 : brf59B.getR54_banks2().intValue());
			}
			Cell R54cell29 = R54row.getCell(31);
			if (R54cell29 != null) {
				R54cell29.setCellValue(brf59B.getR54_gov3() == null ? 0 : brf59B.getR54_gov3().intValue());
			}
			Cell R54cell30 = R54row.getCell(32);
			if (R54cell30 != null) {
				R54cell30.setCellValue(brf59B.getR54_others2() == null ? 0 : brf59B.getR54_others2().intValue());
			}
			Cell R54cell31 = R54row.getCell(33);
			if (R54cell31 != null) {
				R54cell31.setCellValue(brf59B.getR54_banks3() == null ? 0 : brf59B.getR54_banks3().intValue());
			}
			Cell R54cell32 = R54row.getCell(34);
			if (R54cell32 != null) {
				R54cell32.setCellValue(brf59B.getR54_gov4() == null ? 0 : brf59B.getR54_gov4().intValue());
			}
			Cell R54cell33 = R54row.getCell(35);
			if (R54cell33 != null) {
				R54cell33.setCellValue(brf59B.getR54_others3() == null ? 0 : brf59B.getR54_others3().intValue());
			}
			Cell R54cell34 = R54row.getCell(36);
			if (R54cell34 != null) {
				R54cell34.setCellValue(brf59B.getR54_foreign1() == null ? 0 : brf59B.getR54_foreign1().intValue());
			}
			Cell R54cell35 = R54row.getCell(37);
			if (R54cell35 != null) {
				R54cell35.setCellValue(brf59B.getR54_guarantees() == null ? 0 : brf59B.getR54_guarantees().intValue());
			}
			Cell R54cell36 = R54row.getCell(38);
			if (R54cell36 != null) {
				R54cell36.setCellValue(brf59B.getR54_nbfi2() == null ? 0 : brf59B.getR54_nbfi2().intValue());
			}
			Cell R54cell37 = R54row.getCell(39);
			if (R54cell37 != null) {
				R54cell37.setCellValue(brf59B.getR54_interbank2() == null ? 0 : brf59B.getR54_interbank2().intValue());
			}
			Cell R54cell38 = R54row.getCell(40);
			if (R54cell38 != null) {
				R54cell38.setCellValue(brf59B.getR54_gov5() == null ? 0 : brf59B.getR54_gov5().intValue());
			}
			Cell R54cell39 = R54row.getCell(41);
			if (R54cell39 != null) {
				R54cell39.setCellValue(brf59B.getR54_corporate2() == null ? 0 : brf59B.getR54_corporate2().intValue());
			}
			Cell R54cell40 = R54row.getCell(42);
			if (R54cell40 != null) {
				R54cell40.setCellValue(brf59B.getR54_gre2() == null ? 0 : brf59B.getR54_gre2().intValue());
			}
			Cell R54cell41 = R54row.getCell(43);
			if (R54cell41 != null) {
				R54cell41.setCellValue(
						brf59B.getR54_individuals3() == null ? 0 : brf59B.getR54_individuals3().intValue());
			}
			Cell R54cell42 = R54row.getCell(44);
			if (R54cell42 != null) {
				R54cell42.setCellValue(brf59B.getR54_zero1() == null ? 0 : brf59B.getR54_zero1().intValue());
			}
			Cell R54cell43 = R54row.getCell(45);
			if (R54cell43 != null) {
				R54cell43.setCellValue(brf59B.getR54_three1() == null ? 0 : brf59B.getR54_three1().intValue());
			}
			Cell R54cell44 = R54row.getCell(46);
			if (R54cell44 != null) {
				R54cell44.setCellValue(brf59B.getR54_six1() == null ? 0 : brf59B.getR54_six1().intValue());
			}
			Cell R54cell45 = R54row.getCell(47);
			if (R54cell45 != null) {
				R54cell45.setCellValue(brf59B.getR54_oneyear1() == null ? 0 : brf59B.getR54_oneyear1().intValue());
			}
			Cell R54cell46 = R54row.getCell(48);
			if (R54cell46 != null) {
				R54cell46.setCellValue(brf59B.getR54_empty() == null ? "" : brf59B.getR54_empty().toString());
			}
			Row R55row = sheet.getRow(72);
			Cell R55cell1 = R55row.getCell(3);
			if (R55cell1 != null) {
				R55cell1.setCellValue(brf59B.getR55_nbfi() == null ? 0 : brf59B.getR55_nbfi().intValue());
			}

			Cell R55cell2 = R55row.getCell(4);
			if (R55cell2 != null) {
				R55cell2.setCellValue(brf59B.getR55_interbank() == null ? 0 : brf59B.getR55_interbank().intValue());
			}
			Cell R55cell3 = R55row.getCell(5);
			if (R55cell3 != null) {
				R55cell3.setCellValue(brf59B.getR55_gov() == null ? 0 : brf59B.getR55_gov().intValue());
			}
			Cell R55cell4 = R55row.getCell(6);
			if (R55cell4 != null) {
				R55cell4.setCellValue(brf59B.getR55_corporate() == null ? 0 : brf59B.getR55_corporate().intValue());
			}
			Cell R55cell5 = R55row.getCell(7);
			if (R55cell5 != null) {
				R55cell5.setCellValue(brf59B.getR55_gre() == null ? 0 : brf59B.getR55_gre().intValue());
			}
			Cell R55cell6 = R55row.getCell(8);
			if (R55cell6 != null) {
				R55cell6.setCellValue(brf59B.getR55_trade() == null ? 0 : brf59B.getR55_trade().intValue());
			}
			Cell R55cell7 = R55row.getCell(9);
			if (R55cell7 != null) {
				R55cell7.setCellValue(brf59B.getR55_individuals() == null ? 0 : brf59B.getR55_individuals().intValue());
			}
			Cell R55cell8 = R55row.getCell(10);
			if (R55cell8 != null) {
				R55cell8.setCellValue(brf59B.getR55_investment() == null ? 0 : brf59B.getR55_investment().intValue());
			}
			Cell R55cell9 = R55row.getCell(11);
			if (R55cell9 != null) {
				R55cell9.setCellValue(brf59B.getR55_nbfi1() == null ? 0 : brf59B.getR55_nbfi1().intValue());
			}
			Cell R55cell10 = R55row.getCell(12);
			if (R55cell10 != null) {
				R55cell10.setCellValue(brf59B.getR55_interbank1() == null ? 0 : brf59B.getR55_interbank1().intValue());
			}
			Cell R55cell11 = R55row.getCell(13);
			if (R55cell11 != null) {
				R55cell11.setCellValue(brf59B.getR55_gov1() == null ? 0 : brf59B.getR55_gov1().intValue());
			}
			Cell R55cell12 = R55row.getCell(14);
			if (R55cell12 != null) {
				R55cell12.setCellValue(brf59B.getR55_corporate1() == null ? 0 : brf59B.getR55_corporate1().intValue());
			}
			Cell R55cell13 = R55row.getCell(15);
			if (R55cell13 != null) {
				R55cell13.setCellValue(brf59B.getR55_gre1() == null ? 0 : brf59B.getR55_gre1().intValue());
			}
			Cell R55cell14 = R55row.getCell(16);
			if (R55cell14 != null) {
				R55cell14.setCellValue(brf59B.getR55_trade1() == null ? 0 : brf59B.getR55_trade1().intValue());
			}
			Cell R55cell15 = R55row.getCell(17);
			if (R55cell15 != null) {
				R55cell15.setCellValue(
						brf59B.getR55_individuals1() == null ? 0 : brf59B.getR55_individuals1().intValue());
			}
			Cell R55cell16 = R55row.getCell(18);
			if (R55cell16 != null) {
				R55cell16
						.setCellValue(brf59B.getR55_investment1() == null ? 0 : brf59B.getR55_investment1().intValue());
			}
			Cell R55cell17 = R55row.getCell(19);
			if (R55cell17 != null) {
				R55cell17.setCellValue(brf59B.getR55_zer0() == null ? 0 : brf59B.getR55_zer0().intValue());
			}
			Cell R55cell18 = R55row.getCell(20);
			if (R55cell18 != null) {
				R55cell18.setCellValue(brf59B.getR55_three() == null ? 0 : brf59B.getR55_three().intValue());
			}
			Cell R55cell19 = R55row.getCell(21);
			if (R55cell19 != null) {
				R55cell19.setCellValue(brf59B.getR55_six() == null ? 0 : brf59B.getR55_six().intValue());
			}
			Cell R55cell20 = R55row.getCell(22);
			if (R55cell20 != null) {
				R55cell20.setCellValue(brf59B.getR55_oneyear() == null ? 0 : brf59B.getR55_oneyear().intValue());
			}
			Cell R55cell21 = R55row.getCell(23);
			if (R55cell21 != null) {
				R55cell21.setCellValue(brf59B.getR55_foreign() == null ? 0 : brf59B.getR55_foreign().intValue());
			}
			Cell R55cell22 = R55row.getCell(24);
			if (R55cell22 != null) {
				R55cell22.setCellValue(brf59B.getR55_banks() == null ? 0 : brf59B.getR55_banks().intValue());
			}
			Cell R55cell23 = R55row.getCell(25);
			if (R55cell23 != null) {
				R55cell23.setCellValue(brf59B.getR55_gov2() == null ? 0 : brf59B.getR55_gov2().intValue());
			}
			Cell R55cell24 = R55row.getCell(26);
			if (R55cell24 != null) {
				R55cell24.setCellValue(brf59B.getR55_other() == null ? 0 : brf59B.getR55_other().intValue());
			}
			Cell R55cell25 = R55row.getCell(27);
			if (R55cell25 != null) {
				R55cell25.setCellValue(brf59B.getR55_banks1() == null ? 0 : brf59B.getR55_banks1().intValue());
			}
			Cell R55cell26 = R55row.getCell(28);
			if (R55cell26 != null) {
				R55cell26.setCellValue(
						brf59B.getR55_individuals2() == null ? 0 : brf59B.getR55_individuals2().intValue());
			}
			Cell R55cell27 = R55row.getCell(29);
			if (R55cell27 != null) {
				R55cell27.setCellValue(brf59B.getR55_other1() == null ? 0 : brf59B.getR55_other1().intValue());
			}
			Cell R55cell28 = R55row.getCell(30);
			if (R55cell28 != null) {
				R55cell28.setCellValue(brf59B.getR55_banks2() == null ? 0 : brf59B.getR55_banks2().intValue());
			}
			Cell R55cell29 = R55row.getCell(31);
			if (R55cell29 != null) {
				R55cell29.setCellValue(brf59B.getR55_gov3() == null ? 0 : brf59B.getR55_gov3().intValue());
			}
			Cell R55cell30 = R55row.getCell(32);
			if (R55cell30 != null) {
				R55cell30.setCellValue(brf59B.getR55_others2() == null ? 0 : brf59B.getR55_others2().intValue());
			}
			Cell R55cell31 = R55row.getCell(33);
			if (R55cell31 != null) {
				R55cell31.setCellValue(brf59B.getR55_banks3() == null ? 0 : brf59B.getR55_banks3().intValue());
			}
			Cell R55cell32 = R55row.getCell(34);
			if (R55cell32 != null) {
				R55cell32.setCellValue(brf59B.getR55_gov4() == null ? 0 : brf59B.getR55_gov4().intValue());
			}
			Cell R55cell33 = R55row.getCell(35);
			if (R55cell33 != null) {
				R55cell33.setCellValue(brf59B.getR55_others3() == null ? 0 : brf59B.getR55_others3().intValue());
			}
			Cell R55cell34 = R55row.getCell(36);
			if (R55cell34 != null) {
				R55cell34.setCellValue(brf59B.getR55_foreign1() == null ? 0 : brf59B.getR55_foreign1().intValue());
			}
			Cell R55cell35 = R55row.getCell(37);
			if (R55cell35 != null) {
				R55cell35.setCellValue(brf59B.getR55_guarantees() == null ? 0 : brf59B.getR55_guarantees().intValue());
			}
			Cell R55cell36 = R55row.getCell(38);
			if (R55cell36 != null) {
				R55cell36.setCellValue(brf59B.getR55_nbfi2() == null ? 0 : brf59B.getR55_nbfi2().intValue());
			}
			Cell R55cell37 = R55row.getCell(39);
			if (R55cell37 != null) {
				R55cell37.setCellValue(brf59B.getR55_interbank2() == null ? 0 : brf59B.getR55_interbank2().intValue());
			}
			Cell R55cell38 = R55row.getCell(40);
			if (R55cell38 != null) {
				R55cell38.setCellValue(brf59B.getR55_gov5() == null ? 0 : brf59B.getR55_gov5().intValue());
			}
			Cell R55cell39 = R55row.getCell(41);
			if (R55cell39 != null) {
				R55cell39.setCellValue(brf59B.getR55_corporate2() == null ? 0 : brf59B.getR55_corporate2().intValue());
			}
			Cell R55cell40 = R55row.getCell(42);
			if (R55cell40 != null) {
				R55cell40.setCellValue(brf59B.getR55_gre2() == null ? 0 : brf59B.getR55_gre2().intValue());
			}
			Cell R55cell41 = R55row.getCell(43);
			if (R55cell41 != null) {
				R55cell41.setCellValue(
						brf59B.getR55_individuals3() == null ? 0 : brf59B.getR55_individuals3().intValue());
			}
			Cell R55cell42 = R55row.getCell(44);
			if (R55cell42 != null) {
				R55cell42.setCellValue(brf59B.getR55_zero1() == null ? 0 : brf59B.getR55_zero1().intValue());
			}
			Cell R55cell43 = R55row.getCell(45);
			if (R55cell43 != null) {
				R55cell43.setCellValue(brf59B.getR55_three1() == null ? 0 : brf59B.getR55_three1().intValue());
			}
			Cell R55cell44 = R55row.getCell(46);
			if (R55cell44 != null) {
				R55cell44.setCellValue(brf59B.getR55_six1() == null ? 0 : brf59B.getR55_six1().intValue());
			}
			Cell R55cell45 = R55row.getCell(47);
			if (R55cell45 != null) {
				R55cell45.setCellValue(brf59B.getR55_oneyear1() == null ? 0 : brf59B.getR55_oneyear1().intValue());
			}
			Cell R55cell46 = R55row.getCell(48);
			if (R55cell46 != null) {
				R55cell46.setCellValue(brf59B.getR55_empty() == null ? "" : brf59B.getR55_empty().toString());
			}
			Row R56row = sheet.getRow(73);
			Cell R56cell1 = R56row.getCell(3);
			if (R56cell1 != null) {
				R56cell1.setCellValue(brf59B.getR56_nbfi() == null ? 0 : brf59B.getR56_nbfi().intValue());
			}

			Cell R56cell2 = R56row.getCell(4);
			if (R56cell2 != null) {
				R56cell2.setCellValue(brf59B.getR56_interbank() == null ? 0 : brf59B.getR56_interbank().intValue());
			}
			Cell R56cell3 = R56row.getCell(5);
			if (R56cell3 != null) {
				R56cell3.setCellValue(brf59B.getR56_gov() == null ? 0 : brf59B.getR56_gov().intValue());
			}
			Cell R56cell4 = R56row.getCell(6);
			if (R56cell4 != null) {
				R56cell4.setCellValue(brf59B.getR56_corporate() == null ? 0 : brf59B.getR56_corporate().intValue());
			}
			Cell R56cell5 = R56row.getCell(7);
			if (R56cell5 != null) {
				R56cell5.setCellValue(brf59B.getR56_gre() == null ? 0 : brf59B.getR56_gre().intValue());
			}
			Cell R56cell6 = R56row.getCell(8);
			if (R56cell6 != null) {
				R56cell6.setCellValue(brf59B.getR56_trade() == null ? 0 : brf59B.getR56_trade().intValue());
			}
			Cell R56cell7 = R56row.getCell(9);
			if (R56cell7 != null) {
				R56cell7.setCellValue(brf59B.getR56_individuals() == null ? 0 : brf59B.getR56_individuals().intValue());
			}
			Cell R56cell8 = R56row.getCell(10);
			if (R56cell8 != null) {
				R56cell8.setCellValue(brf59B.getR56_investment() == null ? 0 : brf59B.getR56_investment().intValue());
			}
			Cell R56cell9 = R56row.getCell(11);
			if (R56cell9 != null) {
				R56cell9.setCellValue(brf59B.getR56_nbfi1() == null ? 0 : brf59B.getR56_nbfi1().intValue());
			}
			Cell R56cell10 = R56row.getCell(12);
			if (R56cell10 != null) {
				R56cell10.setCellValue(brf59B.getR56_interbank1() == null ? 0 : brf59B.getR56_interbank1().intValue());
			}
			Cell R56cell11 = R56row.getCell(13);
			if (R56cell11 != null) {
				R56cell11.setCellValue(brf59B.getR56_gov1() == null ? 0 : brf59B.getR56_gov1().intValue());
			}
			Cell R56cell12 = R56row.getCell(14);
			if (R56cell12 != null) {
				R56cell12.setCellValue(brf59B.getR56_corporate1() == null ? 0 : brf59B.getR56_corporate1().intValue());
			}
			Cell R56cell13 = R56row.getCell(15);
			if (R56cell13 != null) {
				R56cell13.setCellValue(brf59B.getR56_gre1() == null ? 0 : brf59B.getR56_gre1().intValue());
			}
			Cell R56cell14 = R56row.getCell(16);
			if (R56cell14 != null) {
				R56cell14.setCellValue(brf59B.getR56_trade1() == null ? 0 : brf59B.getR56_trade1().intValue());
			}
			Cell R56cell15 = R56row.getCell(17);
			if (R56cell15 != null) {
				R56cell15.setCellValue(
						brf59B.getR56_individuals1() == null ? 0 : brf59B.getR56_individuals1().intValue());
			}
			Cell R56cell16 = R56row.getCell(18);
			if (R56cell16 != null) {
				R56cell16
						.setCellValue(brf59B.getR56_investment1() == null ? 0 : brf59B.getR56_investment1().intValue());
			}
			Cell R56cell17 = R56row.getCell(19);
			if (R56cell17 != null) {
				R56cell17.setCellValue(brf59B.getR56_zer0() == null ? 0 : brf59B.getR56_zer0().intValue());
			}
			Cell R56cell18 = R56row.getCell(20);
			if (R56cell18 != null) {
				R56cell18.setCellValue(brf59B.getR56_three() == null ? 0 : brf59B.getR56_three().intValue());
			}
			Cell R56cell19 = R56row.getCell(21);
			if (R56cell19 != null) {
				R56cell19.setCellValue(brf59B.getR56_six() == null ? 0 : brf59B.getR56_six().intValue());
			}
			Cell R56cell20 = R56row.getCell(22);
			if (R56cell20 != null) {
				R56cell20.setCellValue(brf59B.getR56_oneyear() == null ? 0 : brf59B.getR56_oneyear().intValue());
			}
			Cell R56cell21 = R56row.getCell(23);
			if (R56cell21 != null) {
				R56cell21.setCellValue(brf59B.getR56_foreign() == null ? 0 : brf59B.getR56_foreign().intValue());
			}
			Cell R56cell22 = R56row.getCell(24);
			if (R56cell22 != null) {
				R56cell22.setCellValue(brf59B.getR56_banks() == null ? 0 : brf59B.getR56_banks().intValue());
			}
			Cell R56cell23 = R56row.getCell(25);
			if (R56cell23 != null) {
				R56cell23.setCellValue(brf59B.getR56_gov2() == null ? 0 : brf59B.getR56_gov2().intValue());
			}
			Cell R56cell24 = R56row.getCell(26);
			if (R56cell24 != null) {
				R56cell24.setCellValue(brf59B.getR56_other() == null ? 0 : brf59B.getR56_other().intValue());
			}
			Cell R56cell25 = R56row.getCell(27);
			if (R56cell25 != null) {
				R56cell25.setCellValue(brf59B.getR56_banks1() == null ? 0 : brf59B.getR56_banks1().intValue());
			}
			Cell R56cell26 = R56row.getCell(28);
			if (R56cell26 != null) {
				R56cell26.setCellValue(
						brf59B.getR56_individuals2() == null ? 0 : brf59B.getR56_individuals2().intValue());
			}
			Cell R56cell27 = R56row.getCell(29);
			if (R56cell27 != null) {
				R56cell27.setCellValue(brf59B.getR56_other1() == null ? 0 : brf59B.getR56_other1().intValue());
			}
			Cell R56cell28 = R56row.getCell(30);
			if (R56cell28 != null) {
				R56cell28.setCellValue(brf59B.getR56_banks2() == null ? 0 : brf59B.getR56_banks2().intValue());
			}
			Cell R56cell29 = R56row.getCell(31);
			if (R56cell29 != null) {
				R56cell29.setCellValue(brf59B.getR56_gov3() == null ? 0 : brf59B.getR56_gov3().intValue());
			}
			Cell R56cell30 = R56row.getCell(32);
			if (R56cell30 != null) {
				R56cell30.setCellValue(brf59B.getR56_others2() == null ? 0 : brf59B.getR56_others2().intValue());
			}
			Cell R56cell31 = R56row.getCell(33);
			if (R56cell31 != null) {
				R56cell31.setCellValue(brf59B.getR56_banks3() == null ? 0 : brf59B.getR56_banks3().intValue());
			}
			Cell R56cell32 = R56row.getCell(34);
			if (R56cell32 != null) {
				R56cell32.setCellValue(brf59B.getR56_gov4() == null ? 0 : brf59B.getR56_gov4().intValue());
			}
			Cell R56cell33 = R56row.getCell(35);
			if (R56cell33 != null) {
				R56cell33.setCellValue(brf59B.getR56_others3() == null ? 0 : brf59B.getR56_others3().intValue());
			}
			Cell R56cell34 = R56row.getCell(36);
			if (R56cell34 != null) {
				R56cell34.setCellValue(brf59B.getR56_foreign1() == null ? 0 : brf59B.getR56_foreign1().intValue());
			}
			Cell R56cell35 = R56row.getCell(37);
			if (R56cell35 != null) {
				R56cell35.setCellValue(brf59B.getR56_guarantees() == null ? 0 : brf59B.getR56_guarantees().intValue());
			}
			Cell R56cell36 = R56row.getCell(38);
			if (R56cell36 != null) {
				R56cell36.setCellValue(brf59B.getR56_nbfi2() == null ? 0 : brf59B.getR56_nbfi2().intValue());
			}
			Cell R56cell37 = R56row.getCell(39);
			if (R56cell37 != null) {
				R56cell37.setCellValue(brf59B.getR56_interbank2() == null ? 0 : brf59B.getR56_interbank2().intValue());
			}
			Cell R56cell38 = R56row.getCell(40);
			if (R56cell38 != null) {
				R56cell38.setCellValue(brf59B.getR56_gov5() == null ? 0 : brf59B.getR56_gov5().intValue());
			}
			Cell R56cell39 = R56row.getCell(41);
			if (R56cell39 != null) {
				R56cell39.setCellValue(brf59B.getR56_corporate2() == null ? 0 : brf59B.getR56_corporate2().intValue());
			}
			Cell R56cell40 = R56row.getCell(42);
			if (R56cell40 != null) {
				R56cell40.setCellValue(brf59B.getR56_gre2() == null ? 0 : brf59B.getR56_gre2().intValue());
			}
			Cell R56cell41 = R56row.getCell(43);
			if (R56cell41 != null) {
				R56cell41.setCellValue(
						brf59B.getR56_individuals3() == null ? 0 : brf59B.getR56_individuals3().intValue());
			}
			Cell R56cell42 = R56row.getCell(44);
			if (R56cell42 != null) {
				R56cell42.setCellValue(brf59B.getR56_zero1() == null ? 0 : brf59B.getR56_zero1().intValue());
			}
			Cell R56cell43 = R56row.getCell(45);
			if (R56cell43 != null) {
				R56cell43.setCellValue(brf59B.getR56_three1() == null ? 0 : brf59B.getR56_three1().intValue());
			}
			Cell R56cell44 = R56row.getCell(46);
			if (R56cell44 != null) {
				R56cell44.setCellValue(brf59B.getR56_six1() == null ? 0 : brf59B.getR56_six1().intValue());
			}
			Cell R56cell45 = R56row.getCell(47);
			if (R56cell45 != null) {
				R56cell45.setCellValue(brf59B.getR56_oneyear1() == null ? 0 : brf59B.getR56_oneyear1().intValue());
			}
			Cell R56cell46 = R56row.getCell(48);
			if (R56cell46 != null) {
				R56cell46.setCellValue(brf59B.getR56_empty() == null ? "" : brf59B.getR56_empty().toString());
			}
			Row R57row = sheet.getRow(74);
			Cell R57cell1 = R57row.getCell(3);
			if (R57cell1 != null) {
				R57cell1.setCellValue(brf59B.getR57_nbfi() == null ? 0 : brf59B.getR57_nbfi().intValue());
			}

			Cell R57cell2 = R57row.getCell(4);
			if (R57cell2 != null) {
				R57cell2.setCellValue(brf59B.getR57_interbank() == null ? 0 : brf59B.getR57_interbank().intValue());
			}
			Cell R57cell3 = R57row.getCell(5);
			if (R57cell3 != null) {
				R57cell3.setCellValue(brf59B.getR57_gov() == null ? 0 : brf59B.getR57_gov().intValue());
			}
			Cell R57cell4 = R57row.getCell(6);
			if (R57cell4 != null) {
				R57cell4.setCellValue(brf59B.getR57_corporate() == null ? 0 : brf59B.getR57_corporate().intValue());
			}
			Cell R57cell5 = R57row.getCell(7);
			if (R57cell5 != null) {
				R57cell5.setCellValue(brf59B.getR57_gre() == null ? 0 : brf59B.getR57_gre().intValue());
			}
			Cell R57cell6 = R57row.getCell(8);
			if (R57cell6 != null) {
				R57cell6.setCellValue(brf59B.getR57_trade() == null ? 0 : brf59B.getR57_trade().intValue());
			}
			Cell R57cell7 = R57row.getCell(9);
			if (R57cell7 != null) {
				R57cell7.setCellValue(brf59B.getR57_individuals() == null ? 0 : brf59B.getR57_individuals().intValue());
			}
			Cell R57cell8 = R57row.getCell(10);
			if (R57cell8 != null) {
				R57cell8.setCellValue(brf59B.getR57_investment() == null ? 0 : brf59B.getR57_investment().intValue());
			}
			Cell R57cell9 = R57row.getCell(11);
			if (R57cell9 != null) {
				R57cell9.setCellValue(brf59B.getR57_nbfi1() == null ? 0 : brf59B.getR57_nbfi1().intValue());
			}
			Cell R57cell10 = R57row.getCell(12);
			if (R57cell10 != null) {
				R57cell10.setCellValue(brf59B.getR57_interbank1() == null ? 0 : brf59B.getR57_interbank1().intValue());
			}
			Cell R57cell11 = R57row.getCell(13);
			if (R57cell11 != null) {
				R57cell11.setCellValue(brf59B.getR57_gov1() == null ? 0 : brf59B.getR57_gov1().intValue());
			}
			Cell R57cell12 = R57row.getCell(14);
			if (R57cell12 != null) {
				R57cell12.setCellValue(brf59B.getR57_corporate1() == null ? 0 : brf59B.getR57_corporate1().intValue());
			}
			Cell R57cell13 = R57row.getCell(15);
			if (R57cell13 != null) {
				R57cell13.setCellValue(brf59B.getR57_gre1() == null ? 0 : brf59B.getR57_gre1().intValue());
			}
			Cell R57cell14 = R57row.getCell(16);
			if (R57cell14 != null) {
				R57cell14.setCellValue(brf59B.getR57_trade1() == null ? 0 : brf59B.getR57_trade1().intValue());
			}
			Cell R57cell15 = R57row.getCell(17);
			if (R57cell15 != null) {
				R57cell15.setCellValue(
						brf59B.getR57_individuals1() == null ? 0 : brf59B.getR57_individuals1().intValue());
			}
			Cell R57cell16 = R57row.getCell(18);
			if (R57cell16 != null) {
				R57cell16
						.setCellValue(brf59B.getR57_investment1() == null ? 0 : brf59B.getR57_investment1().intValue());
			}
			Cell R57cell17 = R57row.getCell(19);
			if (R57cell17 != null) {
				R57cell17.setCellValue(brf59B.getR57_zer0() == null ? 0 : brf59B.getR57_zer0().intValue());
			}
			Cell R57cell18 = R57row.getCell(20);
			if (R57cell18 != null) {
				R57cell18.setCellValue(brf59B.getR57_three() == null ? 0 : brf59B.getR57_three().intValue());
			}
			Cell R57cell19 = R57row.getCell(21);
			if (R57cell19 != null) {
				R57cell19.setCellValue(brf59B.getR57_six() == null ? 0 : brf59B.getR57_six().intValue());
			}
			Cell R57cell20 = R57row.getCell(22);
			if (R57cell20 != null) {
				R57cell20.setCellValue(brf59B.getR57_oneyear() == null ? 0 : brf59B.getR57_oneyear().intValue());
			}
			Cell R57cell21 = R57row.getCell(23);
			if (R57cell21 != null) {
				R57cell21.setCellValue(brf59B.getR57_foreign() == null ? 0 : brf59B.getR57_foreign().intValue());
			}
			Cell R57cell22 = R57row.getCell(24);
			if (R57cell22 != null) {
				R57cell22.setCellValue(brf59B.getR57_banks() == null ? 0 : brf59B.getR57_banks().intValue());
			}
			Cell R57cell23 = R57row.getCell(25);
			if (R57cell23 != null) {
				R57cell23.setCellValue(brf59B.getR57_gov2() == null ? 0 : brf59B.getR57_gov2().intValue());
			}
			Cell R57cell24 = R57row.getCell(26);
			if (R57cell24 != null) {
				R57cell24.setCellValue(brf59B.getR57_other() == null ? 0 : brf59B.getR57_other().intValue());
			}
			Cell R57cell25 = R57row.getCell(27);
			if (R57cell25 != null) {
				R57cell25.setCellValue(brf59B.getR57_banks1() == null ? 0 : brf59B.getR57_banks1().intValue());
			}
			Cell R57cell26 = R57row.getCell(28);
			if (R57cell26 != null) {
				R57cell26.setCellValue(
						brf59B.getR57_individuals2() == null ? 0 : brf59B.getR57_individuals2().intValue());
			}
			Cell R57cell27 = R57row.getCell(29);
			if (R57cell27 != null) {
				R57cell27.setCellValue(brf59B.getR57_other1() == null ? 0 : brf59B.getR57_other1().intValue());
			}
			Cell R57cell28 = R57row.getCell(30);
			if (R57cell28 != null) {
				R57cell28.setCellValue(brf59B.getR57_banks2() == null ? 0 : brf59B.getR57_banks2().intValue());
			}
			Cell R57cell29 = R57row.getCell(31);
			if (R57cell29 != null) {
				R57cell29.setCellValue(brf59B.getR57_gov3() == null ? 0 : brf59B.getR57_gov3().intValue());
			}
			Cell R57cell30 = R57row.getCell(32);
			if (R57cell30 != null) {
				R57cell30.setCellValue(brf59B.getR57_others2() == null ? 0 : brf59B.getR57_others2().intValue());
			}
			Cell R57cell31 = R57row.getCell(33);
			if (R57cell31 != null) {
				R57cell31.setCellValue(brf59B.getR57_banks3() == null ? 0 : brf59B.getR57_banks3().intValue());
			}
			Cell R57cell32 = R57row.getCell(34);
			if (R57cell32 != null) {
				R57cell32.setCellValue(brf59B.getR57_gov4() == null ? 0 : brf59B.getR57_gov4().intValue());
			}
			Cell R57cell33 = R57row.getCell(35);
			if (R57cell33 != null) {
				R57cell33.setCellValue(brf59B.getR57_others3() == null ? 0 : brf59B.getR57_others3().intValue());
			}
			Cell R57cell34 = R57row.getCell(36);
			if (R57cell34 != null) {
				R57cell34.setCellValue(brf59B.getR57_foreign1() == null ? 0 : brf59B.getR57_foreign1().intValue());
			}
			Cell R57cell35 = R57row.getCell(37);
			if (R57cell35 != null) {
				R57cell35.setCellValue(brf59B.getR57_guarantees() == null ? 0 : brf59B.getR57_guarantees().intValue());
			}
			Cell R57cell36 = R57row.getCell(38);
			if (R57cell36 != null) {
				R57cell36.setCellValue(brf59B.getR57_nbfi2() == null ? 0 : brf59B.getR57_nbfi2().intValue());
			}
			Cell R57cell37 = R57row.getCell(39);
			if (R57cell37 != null) {
				R57cell37.setCellValue(brf59B.getR57_interbank2() == null ? 0 : brf59B.getR57_interbank2().intValue());
			}
			Cell R57cell38 = R57row.getCell(40);
			if (R57cell38 != null) {
				R57cell38.setCellValue(brf59B.getR57_gov5() == null ? 0 : brf59B.getR57_gov5().intValue());
			}
			Cell R57cell39 = R57row.getCell(41);
			if (R57cell39 != null) {
				R57cell39.setCellValue(brf59B.getR57_corporate2() == null ? 0 : brf59B.getR57_corporate2().intValue());
			}
			Cell R57cell40 = R57row.getCell(42);
			if (R57cell40 != null) {
				R57cell40.setCellValue(brf59B.getR57_gre2() == null ? 0 : brf59B.getR57_gre2().intValue());
			}
			Cell R57cell41 = R57row.getCell(43);
			if (R57cell41 != null) {
				R57cell41.setCellValue(
						brf59B.getR57_individuals3() == null ? 0 : brf59B.getR57_individuals3().intValue());
			}
			Cell R57cell42 = R57row.getCell(44);
			if (R57cell42 != null) {
				R57cell42.setCellValue(brf59B.getR57_zero1() == null ? 0 : brf59B.getR57_zero1().intValue());
			}
			Cell R57cell43 = R57row.getCell(45);
			if (R57cell43 != null) {
				R57cell43.setCellValue(brf59B.getR57_three1() == null ? 0 : brf59B.getR57_three1().intValue());
			}
			Cell R57cell44 = R57row.getCell(46);
			if (R57cell44 != null) {
				R57cell44.setCellValue(brf59B.getR57_six1() == null ? 0 : brf59B.getR57_six1().intValue());
			}
			Cell R57cell45 = R57row.getCell(47);
			if (R57cell45 != null) {
				R57cell45.setCellValue(brf59B.getR57_oneyear1() == null ? 0 : brf59B.getR57_oneyear1().intValue());
			}
			Cell R57cell46 = R57row.getCell(48);
			if (R57cell46 != null) {
				R57cell46.setCellValue(brf59B.getR57_empty() == null ? "" : brf59B.getR57_empty().toString());
			}
			Row R58row = sheet.getRow(75);
			Cell R58cell1 = R58row.getCell(3);
			if (R58cell1 != null) {
				R58cell1.setCellValue(brf59B.getR58_nbfi() == null ? 0 : brf59B.getR58_nbfi().intValue());
			}

			Cell R58cell2 = R58row.getCell(4);
			if (R58cell2 != null) {
				R58cell2.setCellValue(brf59B.getR58_interbank() == null ? 0 : brf59B.getR58_interbank().intValue());
			}
			Cell R58cell3 = R58row.getCell(5);
			if (R58cell3 != null) {
				R58cell3.setCellValue(brf59B.getR58_gov() == null ? 0 : brf59B.getR58_gov().intValue());
			}
			Cell R58cell4 = R58row.getCell(6);
			if (R58cell4 != null) {
				R58cell4.setCellValue(brf59B.getR58_corporate() == null ? 0 : brf59B.getR58_corporate().intValue());
			}
			Cell R58cell5 = R58row.getCell(7);
			if (R58cell5 != null) {
				R58cell5.setCellValue(brf59B.getR58_gre() == null ? 0 : brf59B.getR58_gre().intValue());
			}
			Cell R58cell6 = R58row.getCell(8);
			if (R58cell6 != null) {
				R58cell6.setCellValue(brf59B.getR58_trade() == null ? 0 : brf59B.getR58_trade().intValue());
			}
			Cell R58cell7 = R58row.getCell(9);
			if (R58cell7 != null) {
				R58cell7.setCellValue(brf59B.getR58_individuals() == null ? 0 : brf59B.getR58_individuals().intValue());
			}
			Cell R58cell8 = R58row.getCell(10);
			if (R58cell8 != null) {
				R58cell8.setCellValue(brf59B.getR58_investment() == null ? 0 : brf59B.getR58_investment().intValue());
			}
			Cell R58cell9 = R58row.getCell(11);
			if (R58cell9 != null) {
				R58cell9.setCellValue(brf59B.getR58_nbfi1() == null ? 0 : brf59B.getR58_nbfi1().intValue());
			}
			Cell R58cell10 = R58row.getCell(12);
			if (R58cell10 != null) {
				R58cell10.setCellValue(brf59B.getR58_interbank1() == null ? 0 : brf59B.getR58_interbank1().intValue());
			}
			Cell R58cell11 = R58row.getCell(13);
			if (R58cell11 != null) {
				R58cell11.setCellValue(brf59B.getR58_gov1() == null ? 0 : brf59B.getR58_gov1().intValue());
			}
			Cell R58cell12 = R58row.getCell(14);
			if (R58cell12 != null) {
				R58cell12.setCellValue(brf59B.getR58_corporate1() == null ? 0 : brf59B.getR58_corporate1().intValue());
			}
			Cell R58cell13 = R58row.getCell(15);
			if (R58cell13 != null) {
				R58cell13.setCellValue(brf59B.getR58_gre1() == null ? 0 : brf59B.getR58_gre1().intValue());
			}
			Cell R58cell14 = R58row.getCell(16);
			if (R58cell14 != null) {
				R58cell14.setCellValue(brf59B.getR58_trade1() == null ? 0 : brf59B.getR58_trade1().intValue());
			}
			Cell R58cell15 = R58row.getCell(17);
			if (R58cell15 != null) {
				R58cell15.setCellValue(
						brf59B.getR58_individuals1() == null ? 0 : brf59B.getR58_individuals1().intValue());
			}
			Cell R58cell16 = R58row.getCell(18);
			if (R58cell16 != null) {
				R58cell16
						.setCellValue(brf59B.getR58_investment1() == null ? 0 : brf59B.getR58_investment1().intValue());
			}
			Cell R58cell17 = R58row.getCell(19);
			if (R58cell17 != null) {
				R58cell17.setCellValue(brf59B.getR58_zer0() == null ? 0 : brf59B.getR58_zer0().intValue());
			}
			Cell R58cell18 = R58row.getCell(20);
			if (R58cell18 != null) {
				R58cell18.setCellValue(brf59B.getR58_three() == null ? 0 : brf59B.getR58_three().intValue());
			}
			Cell R58cell19 = R58row.getCell(21);
			if (R58cell19 != null) {
				R58cell19.setCellValue(brf59B.getR58_six() == null ? 0 : brf59B.getR58_six().intValue());
			}
			Cell R58cell20 = R58row.getCell(22);
			if (R58cell20 != null) {
				R58cell20.setCellValue(brf59B.getR58_oneyear() == null ? 0 : brf59B.getR58_oneyear().intValue());
			}
			Cell R58cell21 = R58row.getCell(23);
			if (R58cell21 != null) {
				R58cell21.setCellValue(brf59B.getR58_foreign() == null ? 0 : brf59B.getR58_foreign().intValue());
			}
			Cell R58cell22 = R58row.getCell(24);
			if (R58cell22 != null) {
				R58cell22.setCellValue(brf59B.getR58_banks() == null ? 0 : brf59B.getR58_banks().intValue());
			}
			Cell R58cell23 = R58row.getCell(25);
			if (R58cell23 != null) {
				R58cell23.setCellValue(brf59B.getR58_gov2() == null ? 0 : brf59B.getR58_gov2().intValue());
			}
			Cell R58cell24 = R58row.getCell(26);
			if (R58cell24 != null) {
				R58cell24.setCellValue(brf59B.getR58_other() == null ? 0 : brf59B.getR58_other().intValue());
			}
			Cell R58cell25 = R58row.getCell(27);
			if (R58cell25 != null) {
				R58cell25.setCellValue(brf59B.getR58_banks1() == null ? 0 : brf59B.getR58_banks1().intValue());
			}
			Cell R58cell26 = R58row.getCell(28);
			if (R58cell26 != null) {
				R58cell26.setCellValue(
						brf59B.getR58_individuals2() == null ? 0 : brf59B.getR58_individuals2().intValue());
			}
			Cell R58cell27 = R58row.getCell(29);
			if (R58cell27 != null) {
				R58cell27.setCellValue(brf59B.getR58_other1() == null ? 0 : brf59B.getR58_other1().intValue());
			}
			Cell R58cell28 = R58row.getCell(30);
			if (R58cell28 != null) {
				R58cell28.setCellValue(brf59B.getR58_banks2() == null ? 0 : brf59B.getR58_banks2().intValue());
			}
			Cell R58cell29 = R58row.getCell(31);
			if (R58cell29 != null) {
				R58cell29.setCellValue(brf59B.getR58_gov3() == null ? 0 : brf59B.getR58_gov3().intValue());
			}
			Cell R58cell30 = R58row.getCell(32);
			if (R58cell30 != null) {
				R58cell30.setCellValue(brf59B.getR58_others2() == null ? 0 : brf59B.getR58_others2().intValue());
			}
			Cell R58cell31 = R58row.getCell(33);
			if (R58cell31 != null) {
				R58cell31.setCellValue(brf59B.getR58_banks3() == null ? 0 : brf59B.getR58_banks3().intValue());
			}
			Cell R58cell32 = R58row.getCell(34);
			if (R58cell32 != null) {
				R58cell32.setCellValue(brf59B.getR58_gov4() == null ? 0 : brf59B.getR58_gov4().intValue());
			}
			Cell R58cell33 = R58row.getCell(35);
			if (R58cell33 != null) {
				R58cell33.setCellValue(brf59B.getR58_others3() == null ? 0 : brf59B.getR58_others3().intValue());
			}
			Cell R58cell34 = R58row.getCell(36);
			if (R58cell34 != null) {
				R58cell34.setCellValue(brf59B.getR58_foreign1() == null ? 0 : brf59B.getR58_foreign1().intValue());
			}
			Cell R58cell35 = R58row.getCell(37);
			if (R58cell35 != null) {
				R58cell35.setCellValue(brf59B.getR58_guarantees() == null ? 0 : brf59B.getR58_guarantees().intValue());
			}
			Cell R58cell36 = R58row.getCell(38);
			if (R58cell36 != null) {
				R58cell36.setCellValue(brf59B.getR58_nbfi2() == null ? 0 : brf59B.getR58_nbfi2().intValue());
			}
			Cell R58cell37 = R58row.getCell(39);
			if (R58cell37 != null) {
				R58cell37.setCellValue(brf59B.getR58_interbank2() == null ? 0 : brf59B.getR58_interbank2().intValue());
			}
			Cell R58cell38 = R58row.getCell(40);
			if (R58cell38 != null) {
				R58cell38.setCellValue(brf59B.getR58_gov5() == null ? 0 : brf59B.getR58_gov5().intValue());
			}
			Cell R58cell39 = R58row.getCell(41);
			if (R58cell39 != null) {
				R58cell39.setCellValue(brf59B.getR58_corporate2() == null ? 0 : brf59B.getR58_corporate2().intValue());
			}
			Cell R58cell40 = R58row.getCell(42);
			if (R58cell40 != null) {
				R58cell40.setCellValue(brf59B.getR58_gre2() == null ? 0 : brf59B.getR58_gre2().intValue());
			}
			Cell R58cell41 = R58row.getCell(43);
			if (R58cell41 != null) {
				R58cell41.setCellValue(
						brf59B.getR58_individuals3() == null ? 0 : brf59B.getR58_individuals3().intValue());
			}
			Cell R58cell42 = R58row.getCell(44);
			if (R58cell42 != null) {
				R58cell42.setCellValue(brf59B.getR58_zero1() == null ? 0 : brf59B.getR58_zero1().intValue());
			}
			Cell R58cell43 = R58row.getCell(45);
			if (R58cell43 != null) {
				R58cell43.setCellValue(brf59B.getR58_three1() == null ? 0 : brf59B.getR58_three1().intValue());
			}
			Cell R58cell44 = R58row.getCell(46);
			if (R58cell44 != null) {
				R58cell44.setCellValue(brf59B.getR58_six1() == null ? 0 : brf59B.getR58_six1().intValue());
			}
			Cell R58cell45 = R58row.getCell(47);
			if (R58cell45 != null) {
				R58cell45.setCellValue(brf59B.getR58_oneyear1() == null ? 0 : brf59B.getR58_oneyear1().intValue());
			}
			Cell R58cell46 = R58row.getCell(48);
			if (R58cell46 != null) {
				R58cell46.setCellValue(brf59B.getR58_empty() == null ? "" : brf59B.getR58_empty().toString());
			}
			Row R59row = sheet.getRow(76);
			Cell R59cell1 = R59row.getCell(3);
			if (R59cell1 != null) {
				R59cell1.setCellValue(brf59B.getR59_nbfi() == null ? 0 : brf59B.getR59_nbfi().intValue());
			}

			Cell R59cell2 = R59row.getCell(4);
			if (R59cell2 != null) {
				R59cell2.setCellValue(brf59B.getR59_interbank() == null ? 0 : brf59B.getR59_interbank().intValue());
			}
			Cell R59cell3 = R59row.getCell(5);
			if (R59cell3 != null) {
				R59cell3.setCellValue(brf59B.getR59_gov() == null ? 0 : brf59B.getR59_gov().intValue());
			}
			Cell R59cell4 = R59row.getCell(6);
			if (R59cell4 != null) {
				R59cell4.setCellValue(brf59B.getR59_corporate() == null ? 0 : brf59B.getR59_corporate().intValue());
			}
			Cell R59cell5 = R59row.getCell(7);
			if (R59cell5 != null) {
				R59cell5.setCellValue(brf59B.getR59_gre() == null ? 0 : brf59B.getR59_gre().intValue());
			}
			Cell R59cell6 = R59row.getCell(8);
			if (R59cell6 != null) {
				R59cell6.setCellValue(brf59B.getR59_trade() == null ? 0 : brf59B.getR59_trade().intValue());
			}
			Cell R59cell7 = R59row.getCell(9);
			if (R59cell7 != null) {
				R59cell7.setCellValue(brf59B.getR59_individuals() == null ? 0 : brf59B.getR59_individuals().intValue());
			}
			Cell R59cell8 = R59row.getCell(10);
			if (R59cell8 != null) {
				R59cell8.setCellValue(brf59B.getR59_investment() == null ? 0 : brf59B.getR59_investment().intValue());
			}
			Cell R59cell9 = R59row.getCell(11);
			if (R59cell9 != null) {
				R59cell9.setCellValue(brf59B.getR59_nbfi1() == null ? 0 : brf59B.getR59_nbfi1().intValue());
			}
			Cell R59cell10 = R59row.getCell(12);
			if (R59cell10 != null) {
				R59cell10.setCellValue(brf59B.getR59_interbank1() == null ? 0 : brf59B.getR59_interbank1().intValue());
			}
			Cell R59cell11 = R59row.getCell(13);
			if (R59cell11 != null) {
				R59cell11.setCellValue(brf59B.getR59_gov1() == null ? 0 : brf59B.getR59_gov1().intValue());
			}
			Cell R59cell12 = R59row.getCell(14);
			if (R59cell12 != null) {
				R59cell12.setCellValue(brf59B.getR59_corporate1() == null ? 0 : brf59B.getR59_corporate1().intValue());
			}
			Cell R59cell13 = R59row.getCell(15);
			if (R59cell13 != null) {
				R59cell13.setCellValue(brf59B.getR59_gre1() == null ? 0 : brf59B.getR59_gre1().intValue());
			}
			Cell R59cell14 = R59row.getCell(16);
			if (R59cell14 != null) {
				R59cell14.setCellValue(brf59B.getR59_trade1() == null ? 0 : brf59B.getR59_trade1().intValue());
			}
			Cell R59cell15 = R59row.getCell(17);
			if (R59cell15 != null) {
				R59cell15.setCellValue(
						brf59B.getR59_individuals1() == null ? 0 : brf59B.getR59_individuals1().intValue());
			}
			Cell R59cell16 = R59row.getCell(18);
			if (R59cell16 != null) {
				R59cell16
						.setCellValue(brf59B.getR59_investment1() == null ? 0 : brf59B.getR59_investment1().intValue());
			}
			Cell R59cell17 = R59row.getCell(19);
			if (R59cell17 != null) {
				R59cell17.setCellValue(brf59B.getR59_zer0() == null ? 0 : brf59B.getR59_zer0().intValue());
			}
			Cell R59cell18 = R59row.getCell(20);
			if (R59cell18 != null) {
				R59cell18.setCellValue(brf59B.getR59_three() == null ? 0 : brf59B.getR59_three().intValue());
			}
			Cell R59cell19 = R59row.getCell(21);
			if (R59cell19 != null) {
				R59cell19.setCellValue(brf59B.getR59_six() == null ? 0 : brf59B.getR59_six().intValue());
			}
			Cell R59cell20 = R59row.getCell(22);
			if (R59cell20 != null) {
				R59cell20.setCellValue(brf59B.getR59_oneyear() == null ? 0 : brf59B.getR59_oneyear().intValue());
			}
			Cell R59cell21 = R59row.getCell(23);
			if (R59cell21 != null) {
				R59cell21.setCellValue(brf59B.getR59_foreign() == null ? 0 : brf59B.getR59_foreign().intValue());
			}
			Cell R59cell22 = R59row.getCell(24);
			if (R59cell22 != null) {
				R59cell22.setCellValue(brf59B.getR59_banks() == null ? 0 : brf59B.getR59_banks().intValue());
			}
			Cell R59cell23 = R59row.getCell(25);
			if (R59cell23 != null) {
				R59cell23.setCellValue(brf59B.getR59_gov2() == null ? 0 : brf59B.getR59_gov2().intValue());
			}
			Cell R59cell24 = R59row.getCell(26);
			if (R59cell24 != null) {
				R59cell24.setCellValue(brf59B.getR59_other() == null ? 0 : brf59B.getR59_other().intValue());
			}
			Cell R59cell25 = R59row.getCell(27);
			if (R59cell25 != null) {
				R59cell25.setCellValue(brf59B.getR59_banks1() == null ? 0 : brf59B.getR59_banks1().intValue());
			}
			Cell R59cell26 = R59row.getCell(28);
			if (R59cell26 != null) {
				R59cell26.setCellValue(
						brf59B.getR59_individuals2() == null ? 0 : brf59B.getR59_individuals2().intValue());
			}
			Cell R59cell27 = R59row.getCell(29);
			if (R59cell27 != null) {
				R59cell27.setCellValue(brf59B.getR59_other1() == null ? 0 : brf59B.getR59_other1().intValue());
			}
			Cell R59cell28 = R59row.getCell(30);
			if (R59cell28 != null) {
				R59cell28.setCellValue(brf59B.getR59_banks2() == null ? 0 : brf59B.getR59_banks2().intValue());
			}
			Cell R59cell29 = R59row.getCell(31);
			if (R59cell29 != null) {
				R59cell29.setCellValue(brf59B.getR59_gov3() == null ? 0 : brf59B.getR59_gov3().intValue());
			}
			Cell R59cell30 = R59row.getCell(32);
			if (R59cell30 != null) {
				R59cell30.setCellValue(brf59B.getR59_others2() == null ? 0 : brf59B.getR59_others2().intValue());
			}
			Cell R59cell31 = R59row.getCell(33);
			if (R59cell31 != null) {
				R59cell31.setCellValue(brf59B.getR59_banks3() == null ? 0 : brf59B.getR59_banks3().intValue());
			}
			Cell R59cell32 = R59row.getCell(34);
			if (R59cell32 != null) {
				R59cell32.setCellValue(brf59B.getR59_gov4() == null ? 0 : brf59B.getR59_gov4().intValue());
			}
			Cell R59cell33 = R59row.getCell(35);
			if (R59cell33 != null) {
				R59cell33.setCellValue(brf59B.getR59_others3() == null ? 0 : brf59B.getR59_others3().intValue());
			}
			Cell R59cell34 = R59row.getCell(36);
			if (R59cell34 != null) {
				R59cell34.setCellValue(brf59B.getR59_foreign1() == null ? 0 : brf59B.getR59_foreign1().intValue());
			}
			Cell R59cell35 = R59row.getCell(37);
			if (R59cell35 != null) {
				R59cell35.setCellValue(brf59B.getR59_guarantees() == null ? 0 : brf59B.getR59_guarantees().intValue());
			}
			Cell R59cell36 = R59row.getCell(38);
			if (R59cell36 != null) {
				R59cell36.setCellValue(brf59B.getR59_nbfi2() == null ? 0 : brf59B.getR59_nbfi2().intValue());
			}
			Cell R59cell37 = R59row.getCell(39);
			if (R59cell37 != null) {
				R59cell37.setCellValue(brf59B.getR59_interbank2() == null ? 0 : brf59B.getR59_interbank2().intValue());
			}
			Cell R59cell38 = R59row.getCell(40);
			if (R59cell38 != null) {
				R59cell38.setCellValue(brf59B.getR59_gov5() == null ? 0 : brf59B.getR59_gov5().intValue());
			}
			Cell R59cell39 = R59row.getCell(41);
			if (R59cell39 != null) {
				R59cell39.setCellValue(brf59B.getR59_corporate2() == null ? 0 : brf59B.getR59_corporate2().intValue());
			}
			Cell R59cell40 = R59row.getCell(42);
			if (R59cell40 != null) {
				R59cell40.setCellValue(brf59B.getR59_gre2() == null ? 0 : brf59B.getR59_gre2().intValue());
			}
			Cell R59cell41 = R59row.getCell(43);
			if (R59cell41 != null) {
				R59cell41.setCellValue(
						brf59B.getR59_individuals3() == null ? 0 : brf59B.getR59_individuals3().intValue());
			}
			Cell R59cell42 = R59row.getCell(44);
			if (R59cell42 != null) {
				R59cell42.setCellValue(brf59B.getR59_zero1() == null ? 0 : brf59B.getR59_zero1().intValue());
			}
			Cell R59cell43 = R59row.getCell(45);
			if (R59cell43 != null) {
				R59cell43.setCellValue(brf59B.getR59_three1() == null ? 0 : brf59B.getR59_three1().intValue());
			}
			Cell R59cell44 = R59row.getCell(46);
			if (R59cell44 != null) {
				R59cell44.setCellValue(brf59B.getR59_six1() == null ? 0 : brf59B.getR59_six1().intValue());
			}
			Cell R59cell45 = R59row.getCell(47);
			if (R59cell45 != null) {
				R59cell45.setCellValue(brf59B.getR59_oneyear1() == null ? 0 : brf59B.getR59_oneyear1().intValue());
			}
			Cell R59cell46 = R59row.getCell(48);
			if (R59cell46 != null) {
				R59cell46.setCellValue(brf59B.getR59_empty() == null ? "" : brf59B.getR59_empty().toString());
			}
			Row R60row = sheet.getRow(77);
			Cell R60cell1 = R60row.getCell(3);
			if (R60cell1 != null) {
				R60cell1.setCellValue(brf59B.getR60_nbfi() == null ? 0 : brf59B.getR60_nbfi().intValue());
			}

			Cell R60cell2 = R60row.getCell(4);
			if (R60cell2 != null) {
				R60cell2.setCellValue(brf59B.getR60_interbank() == null ? 0 : brf59B.getR60_interbank().intValue());
			}
			Cell R60cell3 = R60row.getCell(5);
			if (R60cell3 != null) {
				R60cell3.setCellValue(brf59B.getR60_gov() == null ? 0 : brf59B.getR60_gov().intValue());
			}
			Cell R60cell4 = R60row.getCell(6);
			if (R60cell4 != null) {
				R60cell4.setCellValue(brf59B.getR60_corporate() == null ? 0 : brf59B.getR60_corporate().intValue());
			}
			Cell R60cell5 = R60row.getCell(7);
			if (R60cell5 != null) {
				R60cell5.setCellValue(brf59B.getR60_gre() == null ? 0 : brf59B.getR60_gre().intValue());
			}
			Cell R60cell6 = R60row.getCell(8);
			if (R60cell6 != null) {
				R60cell6.setCellValue(brf59B.getR60_trade() == null ? 0 : brf59B.getR60_trade().intValue());
			}
			Cell R60cell7 = R60row.getCell(9);
			if (R60cell7 != null) {
				R60cell7.setCellValue(brf59B.getR60_individuals() == null ? 0 : brf59B.getR60_individuals().intValue());
			}
			Cell R60cell8 = R60row.getCell(10);
			if (R60cell8 != null) {
				R60cell8.setCellValue(brf59B.getR60_investment() == null ? 0 : brf59B.getR60_investment().intValue());
			}
			Cell R60cell9 = R60row.getCell(11);
			if (R60cell9 != null) {
				R60cell9.setCellValue(brf59B.getR60_nbfi1() == null ? 0 : brf59B.getR60_nbfi1().intValue());
			}
			Cell R60cell10 = R60row.getCell(12);
			if (R60cell10 != null) {
				R60cell10.setCellValue(brf59B.getR60_interbank1() == null ? 0 : brf59B.getR60_interbank1().intValue());
			}
			Cell R60cell11 = R60row.getCell(13);
			if (R60cell11 != null) {
				R60cell11.setCellValue(brf59B.getR60_gov1() == null ? 0 : brf59B.getR60_gov1().intValue());
			}
			Cell R60cell12 = R60row.getCell(14);
			if (R60cell12 != null) {
				R60cell12.setCellValue(brf59B.getR60_corporate1() == null ? 0 : brf59B.getR60_corporate1().intValue());
			}
			Cell R60cell13 = R60row.getCell(15);
			if (R60cell13 != null) {
				R60cell13.setCellValue(brf59B.getR60_gre1() == null ? 0 : brf59B.getR60_gre1().intValue());
			}
			Cell R60cell14 = R60row.getCell(16);
			if (R60cell14 != null) {
				R60cell14.setCellValue(brf59B.getR60_trade1() == null ? 0 : brf59B.getR60_trade1().intValue());
			}
			Cell R60cell15 = R60row.getCell(17);
			if (R60cell15 != null) {
				R60cell15.setCellValue(
						brf59B.getR60_individuals1() == null ? 0 : brf59B.getR60_individuals1().intValue());
			}
			Cell R60cell16 = R60row.getCell(18);
			if (R60cell16 != null) {
				R60cell16
						.setCellValue(brf59B.getR60_investment1() == null ? 0 : brf59B.getR60_investment1().intValue());
			}
			Cell R60cell17 = R60row.getCell(19);
			if (R60cell17 != null) {
				R60cell17.setCellValue(brf59B.getR60_zer0() == null ? 0 : brf59B.getR60_zer0().intValue());
			}
			Cell R60cell18 = R60row.getCell(20);
			if (R60cell18 != null) {
				R60cell18.setCellValue(brf59B.getR60_three() == null ? 0 : brf59B.getR60_three().intValue());
			}
			Cell R60cell19 = R60row.getCell(21);
			if (R60cell19 != null) {
				R60cell19.setCellValue(brf59B.getR60_six() == null ? 0 : brf59B.getR60_six().intValue());
			}
			Cell R60cell20 = R60row.getCell(22);
			if (R60cell20 != null) {
				R60cell20.setCellValue(brf59B.getR60_oneyear() == null ? 0 : brf59B.getR60_oneyear().intValue());
			}
			Cell R60cell21 = R60row.getCell(23);
			if (R60cell21 != null) {
				R60cell21.setCellValue(brf59B.getR60_foreign() == null ? 0 : brf59B.getR60_foreign().intValue());
			}
			Cell R60cell22 = R60row.getCell(24);
			if (R60cell22 != null) {
				R60cell22.setCellValue(brf59B.getR60_banks() == null ? 0 : brf59B.getR60_banks().intValue());
			}
			Cell R60cell23 = R60row.getCell(25);
			if (R60cell23 != null) {
				R60cell23.setCellValue(brf59B.getR60_gov2() == null ? 0 : brf59B.getR60_gov2().intValue());
			}
			Cell R60cell24 = R60row.getCell(26);
			if (R60cell24 != null) {
				R60cell24.setCellValue(brf59B.getR60_other() == null ? 0 : brf59B.getR60_other().intValue());
			}
			Cell R60cell25 = R60row.getCell(27);
			if (R60cell25 != null) {
				R60cell25.setCellValue(brf59B.getR60_banks1() == null ? 0 : brf59B.getR60_banks1().intValue());
			}
			Cell R60cell26 = R60row.getCell(28);
			if (R60cell26 != null) {
				R60cell26.setCellValue(
						brf59B.getR60_individuals2() == null ? 0 : brf59B.getR60_individuals2().intValue());
			}
			Cell R60cell27 = R60row.getCell(29);
			if (R60cell27 != null) {
				R60cell27.setCellValue(brf59B.getR60_other1() == null ? 0 : brf59B.getR60_other1().intValue());
			}
			Cell R60cell28 = R60row.getCell(30);
			if (R60cell28 != null) {
				R60cell28.setCellValue(brf59B.getR60_banks2() == null ? 0 : brf59B.getR60_banks2().intValue());
			}
			Cell R60cell29 = R60row.getCell(31);
			if (R60cell29 != null) {
				R60cell29.setCellValue(brf59B.getR60_gov3() == null ? 0 : brf59B.getR60_gov3().intValue());
			}
			Cell R60cell30 = R60row.getCell(32);
			if (R60cell30 != null) {
				R60cell30.setCellValue(brf59B.getR60_others2() == null ? 0 : brf59B.getR60_others2().intValue());
			}
			Cell R60cell31 = R60row.getCell(33);
			if (R60cell31 != null) {
				R60cell31.setCellValue(brf59B.getR60_banks3() == null ? 0 : brf59B.getR60_banks3().intValue());
			}
			Cell R60cell32 = R60row.getCell(34);
			if (R60cell32 != null) {
				R60cell32.setCellValue(brf59B.getR60_gov4() == null ? 0 : brf59B.getR60_gov4().intValue());
			}
			Cell R60cell33 = R60row.getCell(35);
			if (R60cell33 != null) {
				R60cell33.setCellValue(brf59B.getR60_others3() == null ? 0 : brf59B.getR60_others3().intValue());
			}
			Cell R60cell34 = R60row.getCell(36);
			if (R60cell34 != null) {
				R60cell34.setCellValue(brf59B.getR60_foreign1() == null ? 0 : brf59B.getR60_foreign1().intValue());
			}
			Cell R60cell35 = R60row.getCell(37);
			if (R60cell35 != null) {
				R60cell35.setCellValue(brf59B.getR60_guarantees() == null ? 0 : brf59B.getR60_guarantees().intValue());
			}
			Cell R60cell36 = R60row.getCell(38);
			if (R60cell36 != null) {
				R60cell36.setCellValue(brf59B.getR60_nbfi2() == null ? 0 : brf59B.getR60_nbfi2().intValue());
			}
			Cell R60cell37 = R60row.getCell(39);
			if (R60cell37 != null) {
				R60cell37.setCellValue(brf59B.getR60_interbank2() == null ? 0 : brf59B.getR60_interbank2().intValue());
			}
			Cell R60cell38 = R60row.getCell(40);
			if (R60cell38 != null) {
				R60cell38.setCellValue(brf59B.getR60_gov5() == null ? 0 : brf59B.getR60_gov5().intValue());
			}
			Cell R60cell39 = R60row.getCell(41);
			if (R60cell39 != null) {
				R60cell39.setCellValue(brf59B.getR60_corporate2() == null ? 0 : brf59B.getR60_corporate2().intValue());
			}
			Cell R60cell40 = R60row.getCell(42);
			if (R60cell40 != null) {
				R60cell40.setCellValue(brf59B.getR60_gre2() == null ? 0 : brf59B.getR60_gre2().intValue());
			}
			Cell R60cell41 = R60row.getCell(43);
			if (R60cell41 != null) {
				R60cell41.setCellValue(
						brf59B.getR60_individuals3() == null ? 0 : brf59B.getR60_individuals3().intValue());
			}
			Cell R60cell42 = R60row.getCell(44);
			if (R60cell42 != null) {
				R60cell42.setCellValue(brf59B.getR60_zero1() == null ? 0 : brf59B.getR60_zero1().intValue());
			}
			Cell R60cell43 = R60row.getCell(45);
			if (R60cell43 != null) {
				R60cell43.setCellValue(brf59B.getR60_three1() == null ? 0 : brf59B.getR60_three1().intValue());
			}
			Cell R60cell44 = R60row.getCell(46);
			if (R60cell44 != null) {
				R60cell44.setCellValue(brf59B.getR60_six1() == null ? 0 : brf59B.getR60_six1().intValue());
			}
			Cell R60cell45 = R60row.getCell(47);
			if (R60cell45 != null) {
				R60cell45.setCellValue(brf59B.getR60_oneyear1() == null ? 0 : brf59B.getR60_oneyear1().intValue());
			}
			Cell R60cell46 = R60row.getCell(48);
			if (R60cell46 != null) {
				R60cell46.setCellValue(brf59B.getR60_empty() == null ? "" : brf59B.getR60_empty().toString());
			}
			Row R61row = sheet.getRow(78);
			Cell R61cell1 = R61row.getCell(3);
			if (R61cell1 != null) {
				R61cell1.setCellValue(brf59B.getR61_nbfi() == null ? 0 : brf59B.getR61_nbfi().intValue());
			}

			Cell R61cell2 = R61row.getCell(4);
			if (R61cell2 != null) {
				R61cell2.setCellValue(brf59B.getR61_interbank() == null ? 0 : brf59B.getR61_interbank().intValue());
			}
			Cell R61cell3 = R61row.getCell(5);
			if (R61cell3 != null) {
				R61cell3.setCellValue(brf59B.getR61_gov() == null ? 0 : brf59B.getR61_gov().intValue());
			}
			Cell R61cell4 = R61row.getCell(6);
			if (R61cell4 != null) {
				R61cell4.setCellValue(brf59B.getR61_corporate() == null ? 0 : brf59B.getR61_corporate().intValue());
			}
			Cell R61cell5 = R61row.getCell(7);
			if (R61cell5 != null) {
				R61cell5.setCellValue(brf59B.getR61_gre() == null ? 0 : brf59B.getR61_gre().intValue());
			}
			Cell R61cell6 = R61row.getCell(8);
			if (R61cell6 != null) {
				R61cell6.setCellValue(brf59B.getR61_trade() == null ? 0 : brf59B.getR61_trade().intValue());
			}
			Cell R61cell7 = R61row.getCell(9);
			if (R61cell7 != null) {
				R61cell7.setCellValue(brf59B.getR61_individuals() == null ? 0 : brf59B.getR61_individuals().intValue());
			}
			Cell R61cell8 = R61row.getCell(10);
			if (R61cell8 != null) {
				R61cell8.setCellValue(brf59B.getR61_investment() == null ? 0 : brf59B.getR61_investment().intValue());
			}
			Cell R61cell9 = R61row.getCell(11);
			if (R61cell9 != null) {
				R61cell9.setCellValue(brf59B.getR61_nbfi1() == null ? 0 : brf59B.getR61_nbfi1().intValue());
			}
			Cell R61cell10 = R61row.getCell(12);
			if (R61cell10 != null) {
				R61cell10.setCellValue(brf59B.getR61_interbank1() == null ? 0 : brf59B.getR61_interbank1().intValue());
			}
			Cell R61cell11 = R61row.getCell(13);
			if (R61cell11 != null) {
				R61cell11.setCellValue(brf59B.getR61_gov1() == null ? 0 : brf59B.getR61_gov1().intValue());
			}
			Cell R61cell12 = R61row.getCell(14);
			if (R61cell12 != null) {
				R61cell12.setCellValue(brf59B.getR61_corporate1() == null ? 0 : brf59B.getR61_corporate1().intValue());
			}
			Cell R61cell13 = R61row.getCell(15);
			if (R61cell13 != null) {
				R61cell13.setCellValue(brf59B.getR61_gre1() == null ? 0 : brf59B.getR61_gre1().intValue());
			}
			Cell R61cell14 = R61row.getCell(16);
			if (R61cell14 != null) {
				R61cell14.setCellValue(brf59B.getR61_trade1() == null ? 0 : brf59B.getR61_trade1().intValue());
			}
			Cell R61cell15 = R61row.getCell(17);
			if (R61cell15 != null) {
				R61cell15.setCellValue(
						brf59B.getR61_individuals1() == null ? 0 : brf59B.getR61_individuals1().intValue());
			}
			Cell R61cell16 = R61row.getCell(18);
			if (R61cell16 != null) {
				R61cell16
						.setCellValue(brf59B.getR61_investment1() == null ? 0 : brf59B.getR61_investment1().intValue());
			}
			Cell R61cell17 = R61row.getCell(19);
			if (R61cell17 != null) {
				R61cell17.setCellValue(brf59B.getR61_zer0() == null ? 0 : brf59B.getR61_zer0().intValue());
			}
			Cell R61cell18 = R61row.getCell(20);
			if (R61cell18 != null) {
				R61cell18.setCellValue(brf59B.getR61_three() == null ? 0 : brf59B.getR61_three().intValue());
			}
			Cell R61cell19 = R61row.getCell(21);
			if (R61cell19 != null) {
				R61cell19.setCellValue(brf59B.getR61_six() == null ? 0 : brf59B.getR61_six().intValue());
			}
			Cell R61cell20 = R61row.getCell(22);
			if (R61cell20 != null) {
				R61cell20.setCellValue(brf59B.getR61_oneyear() == null ? 0 : brf59B.getR61_oneyear().intValue());
			}
			Cell R61cell21 = R61row.getCell(23);
			if (R61cell21 != null) {
				R61cell21.setCellValue(brf59B.getR61_foreign() == null ? 0 : brf59B.getR61_foreign().intValue());
			}
			Cell R61cell22 = R61row.getCell(24);
			if (R61cell22 != null) {
				R61cell22.setCellValue(brf59B.getR61_banks() == null ? 0 : brf59B.getR61_banks().intValue());
			}
			Cell R61cell23 = R61row.getCell(25);
			if (R61cell23 != null) {
				R61cell23.setCellValue(brf59B.getR61_gov2() == null ? 0 : brf59B.getR61_gov2().intValue());
			}
			Cell R61cell24 = R61row.getCell(26);
			if (R61cell24 != null) {
				R61cell24.setCellValue(brf59B.getR61_other() == null ? 0 : brf59B.getR61_other().intValue());
			}
			Cell R61cell25 = R61row.getCell(27);
			if (R61cell25 != null) {
				R61cell25.setCellValue(brf59B.getR61_banks1() == null ? 0 : brf59B.getR61_banks1().intValue());
			}
			Cell R61cell26 = R61row.getCell(28);
			if (R61cell26 != null) {
				R61cell26.setCellValue(
						brf59B.getR61_individuals2() == null ? 0 : brf59B.getR61_individuals2().intValue());
			}
			Cell R61cell27 = R61row.getCell(29);
			if (R61cell27 != null) {
				R61cell27.setCellValue(brf59B.getR61_other1() == null ? 0 : brf59B.getR61_other1().intValue());
			}
			Cell R61cell28 = R61row.getCell(30);
			if (R61cell28 != null) {
				R61cell28.setCellValue(brf59B.getR61_banks2() == null ? 0 : brf59B.getR61_banks2().intValue());
			}
			Cell R61cell29 = R61row.getCell(31);
			if (R61cell29 != null) {
				R61cell29.setCellValue(brf59B.getR61_gov3() == null ? 0 : brf59B.getR61_gov3().intValue());
			}
			Cell R61cell30 = R61row.getCell(32);
			if (R61cell30 != null) {
				R61cell30.setCellValue(brf59B.getR61_others2() == null ? 0 : brf59B.getR61_others2().intValue());
			}
			Cell R61cell31 = R61row.getCell(33);
			if (R61cell31 != null) {
				R61cell31.setCellValue(brf59B.getR61_banks3() == null ? 0 : brf59B.getR61_banks3().intValue());
			}
			Cell R61cell32 = R61row.getCell(34);
			if (R61cell32 != null) {
				R61cell32.setCellValue(brf59B.getR61_gov4() == null ? 0 : brf59B.getR61_gov4().intValue());
			}
			Cell R61cell33 = R61row.getCell(35);
			if (R61cell33 != null) {
				R61cell33.setCellValue(brf59B.getR61_others3() == null ? 0 : brf59B.getR61_others3().intValue());
			}
			Cell R61cell34 = R61row.getCell(36);
			if (R61cell34 != null) {
				R61cell34.setCellValue(brf59B.getR61_foreign1() == null ? 0 : brf59B.getR61_foreign1().intValue());
			}
			Cell R61cell35 = R61row.getCell(37);
			if (R61cell35 != null) {
				R61cell35.setCellValue(brf59B.getR61_guarantees() == null ? 0 : brf59B.getR61_guarantees().intValue());
			}
			Cell R61cell36 = R61row.getCell(38);
			if (R61cell36 != null) {
				R61cell36.setCellValue(brf59B.getR61_nbfi2() == null ? 0 : brf59B.getR61_nbfi2().intValue());
			}
			Cell R61cell37 = R61row.getCell(39);
			if (R61cell37 != null) {
				R61cell37.setCellValue(brf59B.getR61_interbank2() == null ? 0 : brf59B.getR61_interbank2().intValue());
			}
			Cell R61cell38 = R61row.getCell(40);
			if (R61cell38 != null) {
				R61cell38.setCellValue(brf59B.getR61_gov5() == null ? 0 : brf59B.getR61_gov5().intValue());
			}
			Cell R61cell39 = R61row.getCell(41);
			if (R61cell39 != null) {
				R61cell39.setCellValue(brf59B.getR61_corporate2() == null ? 0 : brf59B.getR61_corporate2().intValue());
			}
			Cell R61cell40 = R61row.getCell(42);
			if (R61cell40 != null) {
				R61cell40.setCellValue(brf59B.getR61_gre2() == null ? 0 : brf59B.getR61_gre2().intValue());
			}
			Cell R61cell41 = R61row.getCell(43);
			if (R61cell41 != null) {
				R61cell41.setCellValue(
						brf59B.getR61_individuals3() == null ? 0 : brf59B.getR61_individuals3().intValue());
			}
			Cell R61cell42 = R61row.getCell(44);
			if (R61cell42 != null) {
				R61cell42.setCellValue(brf59B.getR61_zero1() == null ? 0 : brf59B.getR61_zero1().intValue());
			}
			Cell R61cell43 = R61row.getCell(45);
			if (R61cell43 != null) {
				R61cell43.setCellValue(brf59B.getR61_three1() == null ? 0 : brf59B.getR61_three1().intValue());
			}
			Cell R61cell44 = R61row.getCell(46);
			if (R61cell44 != null) {
				R61cell44.setCellValue(brf59B.getR61_six1() == null ? 0 : brf59B.getR61_six1().intValue());
			}
			Cell R61cell45 = R61row.getCell(47);
			if (R61cell45 != null) {
				R61cell45.setCellValue(brf59B.getR61_oneyear1() == null ? 0 : brf59B.getR61_oneyear1().intValue());
			}
			Cell R61cell46 = R61row.getCell(48);
			if (R61cell46 != null) {
				R61cell46.setCellValue(brf59B.getR61_empty() == null ? "" : brf59B.getR61_empty().toString());
			}
			Row R62row = sheet.getRow(79);
			Cell R62cell1 = R62row.getCell(3);
			if (R62cell1 != null) {
				R62cell1.setCellValue(brf59B.getR62_nbfi() == null ? 0 : brf59B.getR62_nbfi().intValue());
			}

			Cell R62cell2 = R62row.getCell(4);
			if (R62cell2 != null) {
				R62cell2.setCellValue(brf59B.getR62_interbank() == null ? 0 : brf59B.getR62_interbank().intValue());
			}
			Cell R62cell3 = R62row.getCell(5);
			if (R62cell3 != null) {
				R62cell3.setCellValue(brf59B.getR62_gov() == null ? 0 : brf59B.getR62_gov().intValue());
			}
			Cell R62cell4 = R62row.getCell(6);
			if (R62cell4 != null) {
				R62cell4.setCellValue(brf59B.getR62_corporate() == null ? 0 : brf59B.getR62_corporate().intValue());
			}
			Cell R62cell5 = R62row.getCell(7);
			if (R62cell5 != null) {
				R62cell5.setCellValue(brf59B.getR62_gre() == null ? 0 : brf59B.getR62_gre().intValue());
			}
			Cell R62cell6 = R62row.getCell(8);
			if (R62cell6 != null) {
				R62cell6.setCellValue(brf59B.getR62_trade() == null ? 0 : brf59B.getR62_trade().intValue());
			}
			Cell R62cell7 = R62row.getCell(9);
			if (R62cell7 != null) {
				R62cell7.setCellValue(brf59B.getR62_individuals() == null ? 0 : brf59B.getR62_individuals().intValue());
			}
			Cell R62cell8 = R62row.getCell(10);
			if (R62cell8 != null) {
				R62cell8.setCellValue(brf59B.getR62_investment() == null ? 0 : brf59B.getR62_investment().intValue());
			}
			Cell R62cell9 = R62row.getCell(11);
			if (R62cell9 != null) {
				R62cell9.setCellValue(brf59B.getR62_nbfi1() == null ? 0 : brf59B.getR62_nbfi1().intValue());
			}
			Cell R62cell10 = R62row.getCell(12);
			if (R62cell10 != null) {
				R62cell10.setCellValue(brf59B.getR62_interbank1() == null ? 0 : brf59B.getR62_interbank1().intValue());
			}
			Cell R62cell11 = R62row.getCell(13);
			if (R62cell11 != null) {
				R62cell11.setCellValue(brf59B.getR62_gov1() == null ? 0 : brf59B.getR62_gov1().intValue());
			}
			Cell R62cell12 = R62row.getCell(14);
			if (R62cell12 != null) {
				R62cell12.setCellValue(brf59B.getR62_corporate1() == null ? 0 : brf59B.getR62_corporate1().intValue());
			}
			Cell R62cell13 = R62row.getCell(15);
			if (R62cell13 != null) {
				R62cell13.setCellValue(brf59B.getR62_gre1() == null ? 0 : brf59B.getR62_gre1().intValue());
			}
			Cell R62cell14 = R62row.getCell(16);
			if (R62cell14 != null) {
				R62cell14.setCellValue(brf59B.getR62_trade1() == null ? 0 : brf59B.getR62_trade1().intValue());
			}
			Cell R62cell15 = R62row.getCell(17);
			if (R62cell15 != null) {
				R62cell15.setCellValue(
						brf59B.getR62_individuals1() == null ? 0 : brf59B.getR62_individuals1().intValue());
			}
			Cell R62cell16 = R62row.getCell(18);
			if (R62cell16 != null) {
				R62cell16
						.setCellValue(brf59B.getR62_investment1() == null ? 0 : brf59B.getR62_investment1().intValue());
			}
			Cell R62cell17 = R62row.getCell(19);
			if (R62cell17 != null) {
				R62cell17.setCellValue(brf59B.getR62_zer0() == null ? 0 : brf59B.getR62_zer0().intValue());
			}
			Cell R62cell18 = R62row.getCell(20);
			if (R62cell18 != null) {
				R62cell18.setCellValue(brf59B.getR62_three() == null ? 0 : brf59B.getR62_three().intValue());
			}
			Cell R62cell19 = R62row.getCell(21);
			if (R62cell19 != null) {
				R62cell19.setCellValue(brf59B.getR62_six() == null ? 0 : brf59B.getR62_six().intValue());
			}
			Cell R62cell20 = R62row.getCell(22);
			if (R62cell20 != null) {
				R62cell20.setCellValue(brf59B.getR62_oneyear() == null ? 0 : brf59B.getR62_oneyear().intValue());
			}
			Cell R62cell21 = R62row.getCell(23);
			if (R62cell21 != null) {
				R62cell21.setCellValue(brf59B.getR62_foreign() == null ? 0 : brf59B.getR62_foreign().intValue());
			}
			Cell R62cell22 = R62row.getCell(24);
			if (R62cell22 != null) {
				R62cell22.setCellValue(brf59B.getR62_banks() == null ? 0 : brf59B.getR62_banks().intValue());
			}
			Cell R62cell23 = R62row.getCell(25);
			if (R62cell23 != null) {
				R62cell23.setCellValue(brf59B.getR62_gov2() == null ? 0 : brf59B.getR62_gov2().intValue());
			}
			Cell R62cell24 = R62row.getCell(26);
			if (R62cell24 != null) {
				R62cell24.setCellValue(brf59B.getR62_other() == null ? 0 : brf59B.getR62_other().intValue());
			}
			Cell R62cell25 = R62row.getCell(27);
			if (R62cell25 != null) {
				R62cell25.setCellValue(brf59B.getR62_banks1() == null ? 0 : brf59B.getR62_banks1().intValue());
			}
			Cell R62cell26 = R62row.getCell(28);
			if (R62cell26 != null) {
				R62cell26.setCellValue(
						brf59B.getR62_individuals2() == null ? 0 : brf59B.getR62_individuals2().intValue());
			}
			Cell R62cell27 = R62row.getCell(29);
			if (R62cell27 != null) {
				R62cell27.setCellValue(brf59B.getR62_other1() == null ? 0 : brf59B.getR62_other1().intValue());
			}
			Cell R62cell28 = R62row.getCell(30);
			if (R62cell28 != null) {
				R62cell28.setCellValue(brf59B.getR62_banks2() == null ? 0 : brf59B.getR62_banks2().intValue());
			}
			Cell R62cell29 = R62row.getCell(31);
			if (R62cell29 != null) {
				R62cell29.setCellValue(brf59B.getR62_gov3() == null ? 0 : brf59B.getR62_gov3().intValue());
			}
			Cell R62cell30 = R62row.getCell(32);
			if (R62cell30 != null) {
				R62cell30.setCellValue(brf59B.getR62_others2() == null ? 0 : brf59B.getR62_others2().intValue());
			}
			Cell R62cell31 = R62row.getCell(33);
			if (R62cell31 != null) {
				R62cell31.setCellValue(brf59B.getR62_banks3() == null ? 0 : brf59B.getR62_banks3().intValue());
			}
			Cell R62cell32 = R62row.getCell(34);
			if (R62cell32 != null) {
				R62cell32.setCellValue(brf59B.getR62_gov4() == null ? 0 : brf59B.getR62_gov4().intValue());
			}
			Cell R62cell33 = R62row.getCell(35);
			if (R62cell33 != null) {
				R62cell33.setCellValue(brf59B.getR62_others3() == null ? 0 : brf59B.getR62_others3().intValue());
			}
			Cell R62cell34 = R62row.getCell(36);
			if (R62cell34 != null) {
				R62cell34.setCellValue(brf59B.getR62_foreign1() == null ? 0 : brf59B.getR62_foreign1().intValue());
			}
			Cell R62cell35 = R62row.getCell(37);
			if (R62cell35 != null) {
				R62cell35.setCellValue(brf59B.getR62_guarantees() == null ? 0 : brf59B.getR62_guarantees().intValue());
			}
			Cell R62cell36 = R62row.getCell(38);
			if (R62cell36 != null) {
				R62cell36.setCellValue(brf59B.getR62_nbfi2() == null ? 0 : brf59B.getR62_nbfi2().intValue());
			}
			Cell R62cell37 = R62row.getCell(39);
			if (R62cell37 != null) {
				R62cell37.setCellValue(brf59B.getR62_interbank2() == null ? 0 : brf59B.getR62_interbank2().intValue());
			}
			Cell R62cell38 = R62row.getCell(40);
			if (R62cell38 != null) {
				R62cell38.setCellValue(brf59B.getR62_gov5() == null ? 0 : brf59B.getR62_gov5().intValue());
			}
			Cell R62cell39 = R62row.getCell(41);
			if (R62cell39 != null) {
				R62cell39.setCellValue(brf59B.getR62_corporate2() == null ? 0 : brf59B.getR62_corporate2().intValue());
			}
			Cell R62cell40 = R62row.getCell(42);
			if (R62cell40 != null) {
				R62cell40.setCellValue(brf59B.getR62_gre2() == null ? 0 : brf59B.getR62_gre2().intValue());
			}
			Cell R62cell41 = R62row.getCell(43);
			if (R62cell41 != null) {
				R62cell41.setCellValue(
						brf59B.getR62_individuals3() == null ? 0 : brf59B.getR62_individuals3().intValue());
			}
			Cell R62cell42 = R62row.getCell(44);
			if (R62cell42 != null) {
				R62cell42.setCellValue(brf59B.getR62_zero1() == null ? 0 : brf59B.getR62_zero1().intValue());
			}
			Cell R62cell43 = R62row.getCell(45);
			if (R62cell43 != null) {
				R62cell43.setCellValue(brf59B.getR62_three1() == null ? 0 : brf59B.getR62_three1().intValue());
			}
			Cell R62cell44 = R62row.getCell(46);
			if (R62cell44 != null) {
				R62cell44.setCellValue(brf59B.getR62_six1() == null ? 0 : brf59B.getR62_six1().intValue());
			}
			Cell R62cell45 = R62row.getCell(47);
			if (R62cell45 != null) {
				R62cell45.setCellValue(brf59B.getR62_oneyear1() == null ? 0 : brf59B.getR62_oneyear1().intValue());
			}
			Cell R62cell46 = R62row.getCell(48);
			if (R62cell46 != null) {
				R62cell46.setCellValue(brf59B.getR62_empty() == null ? "" : brf59B.getR62_empty().toString());
			}
			Row R63row = sheet.getRow(80);
			Cell R63cell1 = R63row.getCell(3);
			if (R63cell1 != null) {
				R63cell1.setCellValue(brf59B.getR63_nbfi() == null ? 0 : brf59B.getR63_nbfi().intValue());
			}

			Cell R63cell2 = R63row.getCell(4);
			if (R63cell2 != null) {
				R63cell2.setCellValue(brf59B.getR63_interbank() == null ? 0 : brf59B.getR63_interbank().intValue());
			}
			Cell R63cell3 = R63row.getCell(5);
			if (R63cell3 != null) {
				R63cell3.setCellValue(brf59B.getR63_gov() == null ? 0 : brf59B.getR63_gov().intValue());
			}
			Cell R63cell4 = R63row.getCell(6);
			if (R63cell4 != null) {
				R63cell4.setCellValue(brf59B.getR63_corporate() == null ? 0 : brf59B.getR63_corporate().intValue());
			}
			Cell R63cell5 = R63row.getCell(7);
			if (R63cell5 != null) {
				R63cell5.setCellValue(brf59B.getR63_gre() == null ? 0 : brf59B.getR63_gre().intValue());
			}
			Cell R63cell6 = R63row.getCell(8);
			if (R63cell6 != null) {
				R63cell6.setCellValue(brf59B.getR63_trade() == null ? 0 : brf59B.getR63_trade().intValue());
			}
			Cell R63cell7 = R63row.getCell(9);
			if (R63cell7 != null) {
				R63cell7.setCellValue(brf59B.getR63_individuals() == null ? 0 : brf59B.getR63_individuals().intValue());
			}
			Cell R63cell8 = R63row.getCell(10);
			if (R63cell8 != null) {
				R63cell8.setCellValue(brf59B.getR63_investment() == null ? 0 : brf59B.getR63_investment().intValue());
			}
			Cell R63cell9 = R63row.getCell(11);
			if (R63cell9 != null) {
				R63cell9.setCellValue(brf59B.getR63_nbfi1() == null ? 0 : brf59B.getR63_nbfi1().intValue());
			}
			Cell R63cell10 = R63row.getCell(12);
			if (R63cell10 != null) {
				R63cell10.setCellValue(brf59B.getR63_interbank1() == null ? 0 : brf59B.getR63_interbank1().intValue());
			}
			Cell R63cell11 = R63row.getCell(13);
			if (R63cell11 != null) {
				R63cell11.setCellValue(brf59B.getR63_gov1() == null ? 0 : brf59B.getR63_gov1().intValue());
			}
			Cell R63cell12 = R63row.getCell(14);
			if (R63cell12 != null) {
				R63cell12.setCellValue(brf59B.getR63_corporate1() == null ? 0 : brf59B.getR63_corporate1().intValue());
			}
			Cell R63cell13 = R63row.getCell(15);
			if (R63cell13 != null) {
				R63cell13.setCellValue(brf59B.getR63_gre1() == null ? 0 : brf59B.getR63_gre1().intValue());
			}
			Cell R63cell14 = R63row.getCell(16);
			if (R63cell14 != null) {
				R63cell14.setCellValue(brf59B.getR63_trade1() == null ? 0 : brf59B.getR63_trade1().intValue());
			}
			Cell R63cell15 = R63row.getCell(17);
			if (R63cell15 != null) {
				R63cell15.setCellValue(
						brf59B.getR63_individuals1() == null ? 0 : brf59B.getR63_individuals1().intValue());
			}
			Cell R63cell16 = R63row.getCell(18);
			if (R63cell16 != null) {
				R63cell16
						.setCellValue(brf59B.getR63_investment1() == null ? 0 : brf59B.getR63_investment1().intValue());
			}
			Cell R63cell17 = R63row.getCell(19);
			if (R63cell17 != null) {
				R63cell17.setCellValue(brf59B.getR63_zer0() == null ? 0 : brf59B.getR63_zer0().intValue());
			}
			Cell R63cell18 = R63row.getCell(20);
			if (R63cell18 != null) {
				R63cell18.setCellValue(brf59B.getR63_three() == null ? 0 : brf59B.getR63_three().intValue());
			}
			Cell R63cell19 = R63row.getCell(21);
			if (R63cell19 != null) {
				R63cell19.setCellValue(brf59B.getR63_six() == null ? 0 : brf59B.getR63_six().intValue());
			}
			Cell R63cell20 = R63row.getCell(22);
			if (R63cell20 != null) {
				R63cell20.setCellValue(brf59B.getR63_oneyear() == null ? 0 : brf59B.getR63_oneyear().intValue());
			}
			Cell R63cell21 = R63row.getCell(23);
			if (R63cell21 != null) {
				R63cell21.setCellValue(brf59B.getR63_foreign() == null ? 0 : brf59B.getR63_foreign().intValue());
			}
			Cell R63cell22 = R63row.getCell(24);
			if (R63cell22 != null) {
				R63cell22.setCellValue(brf59B.getR63_banks() == null ? 0 : brf59B.getR63_banks().intValue());
			}
			Cell R63cell23 = R63row.getCell(25);
			if (R63cell23 != null) {
				R63cell23.setCellValue(brf59B.getR63_gov2() == null ? 0 : brf59B.getR63_gov2().intValue());
			}
			Cell R63cell24 = R63row.getCell(26);
			if (R63cell24 != null) {
				R63cell24.setCellValue(brf59B.getR63_other() == null ? 0 : brf59B.getR63_other().intValue());
			}
			Cell R63cell25 = R63row.getCell(27);
			if (R63cell25 != null) {
				R63cell25.setCellValue(brf59B.getR63_banks1() == null ? 0 : brf59B.getR63_banks1().intValue());
			}
			Cell R63cell26 = R63row.getCell(28);
			if (R63cell26 != null) {
				R63cell26.setCellValue(
						brf59B.getR63_individuals2() == null ? 0 : brf59B.getR63_individuals2().intValue());
			}
			Cell R63cell27 = R63row.getCell(29);
			if (R63cell27 != null) {
				R63cell27.setCellValue(brf59B.getR63_other1() == null ? 0 : brf59B.getR63_other1().intValue());
			}
			Cell R63cell28 = R63row.getCell(30);
			if (R63cell28 != null) {
				R63cell28.setCellValue(brf59B.getR63_banks2() == null ? 0 : brf59B.getR63_banks2().intValue());
			}
			Cell R63cell29 = R63row.getCell(31);
			if (R63cell29 != null) {
				R63cell29.setCellValue(brf59B.getR63_gov3() == null ? 0 : brf59B.getR63_gov3().intValue());
			}
			Cell R63cell30 = R63row.getCell(32);
			if (R63cell30 != null) {
				R63cell30.setCellValue(brf59B.getR63_others2() == null ? 0 : brf59B.getR63_others2().intValue());
			}
			Cell R63cell31 = R63row.getCell(33);
			if (R63cell31 != null) {
				R63cell31.setCellValue(brf59B.getR63_banks3() == null ? 0 : brf59B.getR63_banks3().intValue());
			}
			Cell R63cell32 = R63row.getCell(34);
			if (R63cell32 != null) {
				R63cell32.setCellValue(brf59B.getR63_gov4() == null ? 0 : brf59B.getR63_gov4().intValue());
			}
			Cell R63cell33 = R63row.getCell(35);
			if (R63cell33 != null) {
				R63cell33.setCellValue(brf59B.getR63_others3() == null ? 0 : brf59B.getR63_others3().intValue());
			}
			Cell R63cell34 = R63row.getCell(36);
			if (R63cell34 != null) {
				R63cell34.setCellValue(brf59B.getR63_foreign1() == null ? 0 : brf59B.getR63_foreign1().intValue());
			}
			Cell R63cell35 = R63row.getCell(37);
			if (R63cell35 != null) {
				R63cell35.setCellValue(brf59B.getR63_guarantees() == null ? 0 : brf59B.getR63_guarantees().intValue());
			}
			Cell R63cell36 = R63row.getCell(38);
			if (R63cell36 != null) {
				R63cell36.setCellValue(brf59B.getR63_nbfi2() == null ? 0 : brf59B.getR63_nbfi2().intValue());
			}
			Cell R63cell37 = R63row.getCell(39);
			if (R63cell37 != null) {
				R63cell37.setCellValue(brf59B.getR63_interbank2() == null ? 0 : brf59B.getR63_interbank2().intValue());
			}
			Cell R63cell38 = R63row.getCell(40);
			if (R63cell38 != null) {
				R63cell38.setCellValue(brf59B.getR63_gov5() == null ? 0 : brf59B.getR63_gov5().intValue());
			}
			Cell R63cell39 = R63row.getCell(41);
			if (R63cell39 != null) {
				R63cell39.setCellValue(brf59B.getR63_corporate2() == null ? 0 : brf59B.getR63_corporate2().intValue());
			}
			Cell R63cell40 = R63row.getCell(42);
			if (R63cell40 != null) {
				R63cell40.setCellValue(brf59B.getR63_gre2() == null ? 0 : brf59B.getR63_gre2().intValue());
			}
			Cell R63cell41 = R63row.getCell(43);
			if (R63cell41 != null) {
				R63cell41.setCellValue(
						brf59B.getR63_individuals3() == null ? 0 : brf59B.getR63_individuals3().intValue());
			}
			Cell R63cell42 = R63row.getCell(44);
			if (R63cell42 != null) {
				R63cell42.setCellValue(brf59B.getR63_zero1() == null ? 0 : brf59B.getR63_zero1().intValue());
			}
			Cell R63cell43 = R63row.getCell(45);
			if (R63cell43 != null) {
				R63cell43.setCellValue(brf59B.getR63_three1() == null ? 0 : brf59B.getR63_three1().intValue());
			}
			Cell R63cell44 = R63row.getCell(46);
			if (R63cell44 != null) {
				R63cell44.setCellValue(brf59B.getR63_six1() == null ? 0 : brf59B.getR63_six1().intValue());
			}
			Cell R63cell45 = R63row.getCell(47);
			if (R63cell45 != null) {
				R63cell45.setCellValue(brf59B.getR63_oneyear1() == null ? 0 : brf59B.getR63_oneyear1().intValue());
			}
			Cell R63cell46 = R63row.getCell(48);
			if (R63cell46 != null) {
				R63cell46.setCellValue(brf59B.getR63_empty() == null ? "" : brf59B.getR63_empty().toString());
			}

		}
	}

	public void updateSheetWithEntity4Data(Sheet sheet, List<BRF59D_ENTITY> BRF59D_ENTITY) {
		if (BRF59D_ENTITY.size() == 1) {
			BRF59D_ENTITY brf59C = BRF59D_ENTITY.get(0);
			Row R64row = sheet.getRow(81);
			Cell R64cell1 = R64row.getCell(3);
			if (R64cell1 != null) {
				R64cell1.setCellValue(brf59C.getR64_nbfi() == null ? 0 : brf59C.getR64_nbfi().intValue());
			}

			Cell R64cell2 = R64row.getCell(4);
			if (R64cell2 != null) {
				R64cell2.setCellValue(brf59C.getR64_interbank() == null ? 0 : brf59C.getR64_interbank().intValue());
			}
			Cell R64cell3 = R64row.getCell(5);
			if (R64cell3 != null) {
				R64cell3.setCellValue(brf59C.getR64_gov() == null ? 0 : brf59C.getR64_gov().intValue());
			}
			Cell R64cell4 = R64row.getCell(6);
			if (R64cell4 != null) {
				R64cell4.setCellValue(brf59C.getR64_corporate() == null ? 0 : brf59C.getR64_corporate().intValue());
			}
			Cell R64cell5 = R64row.getCell(7);
			if (R64cell5 != null) {
				R64cell5.setCellValue(brf59C.getR64_gre() == null ? 0 : brf59C.getR64_gre().intValue());
			}
			Cell R64cell6 = R64row.getCell(8);
			if (R64cell6 != null) {
				R64cell6.setCellValue(brf59C.getR64_trade() == null ? 0 : brf59C.getR64_trade().intValue());
			}
			Cell R64cell7 = R64row.getCell(9);
			if (R64cell7 != null) {
				R64cell7.setCellValue(brf59C.getR64_individuals() == null ? 0 : brf59C.getR64_individuals().intValue());
			}
			Cell R64cell8 = R64row.getCell(10);
			if (R64cell8 != null) {
				R64cell8.setCellValue(brf59C.getR64_investment() == null ? 0 : brf59C.getR64_investment().intValue());
			}
			Cell R64cell9 = R64row.getCell(11);
			if (R64cell9 != null) {
				R64cell9.setCellValue(brf59C.getR64_nbfi1() == null ? 0 : brf59C.getR64_nbfi1().intValue());
			}
			Cell R64cell10 = R64row.getCell(12);
			if (R64cell10 != null) {
				R64cell10.setCellValue(brf59C.getR64_interbank1() == null ? 0 : brf59C.getR64_interbank1().intValue());
			}
			Cell R64cell11 = R64row.getCell(13);
			if (R64cell11 != null) {
				R64cell11.setCellValue(brf59C.getR64_gov1() == null ? 0 : brf59C.getR64_gov1().intValue());
			}
			Cell R64cell12 = R64row.getCell(14);
			if (R64cell12 != null) {
				R64cell12.setCellValue(brf59C.getR64_corporate1() == null ? 0 : brf59C.getR64_corporate1().intValue());
			}
			Cell R64cell13 = R64row.getCell(15);
			if (R64cell13 != null) {
				R64cell13.setCellValue(brf59C.getR64_gre1() == null ? 0 : brf59C.getR64_gre1().intValue());
			}
			Cell R64cell14 = R64row.getCell(16);
			if (R64cell14 != null) {
				R64cell14.setCellValue(brf59C.getR64_trade1() == null ? 0 : brf59C.getR64_trade1().intValue());
			}
			Cell R64cell15 = R64row.getCell(17);
			if (R64cell15 != null) {
				R64cell15.setCellValue(
						brf59C.getR64_individuals1() == null ? 0 : brf59C.getR64_individuals1().intValue());
			}
			Cell R64cell16 = R64row.getCell(18);
			if (R64cell16 != null) {
				R64cell16
						.setCellValue(brf59C.getR64_investment1() == null ? 0 : brf59C.getR64_investment1().intValue());
			}
			Cell R64cell17 = R64row.getCell(19);
			if (R64cell17 != null) {
				R64cell17.setCellValue(brf59C.getR64_zer0() == null ? 0 : brf59C.getR64_zer0().intValue());
			}
			Cell R64cell18 = R64row.getCell(20);
			if (R64cell18 != null) {
				R64cell18.setCellValue(brf59C.getR64_three() == null ? 0 : brf59C.getR64_three().intValue());
			}
			Cell R64cell19 = R64row.getCell(21);
			if (R64cell19 != null) {
				R64cell19.setCellValue(brf59C.getR64_six() == null ? 0 : brf59C.getR64_six().intValue());
			}
			Cell R64cell20 = R64row.getCell(22);
			if (R64cell20 != null) {
				R64cell20.setCellValue(brf59C.getR64_oneyear() == null ? 0 : brf59C.getR64_oneyear().intValue());
			}
			Cell R64cell21 = R64row.getCell(23);
			if (R64cell21 != null) {
				R64cell21.setCellValue(brf59C.getR64_foreign() == null ? 0 : brf59C.getR64_foreign().intValue());
			}
			Cell R64cell22 = R64row.getCell(24);
			if (R64cell22 != null) {
				R64cell22.setCellValue(brf59C.getR64_banks() == null ? 0 : brf59C.getR64_banks().intValue());
			}
			Cell R64cell23 = R64row.getCell(25);
			if (R64cell23 != null) {
				R64cell23.setCellValue(brf59C.getR64_gov2() == null ? 0 : brf59C.getR64_gov2().intValue());
			}
			Cell R64cell24 = R64row.getCell(26);
			if (R64cell24 != null) {
				R64cell24.setCellValue(brf59C.getR64_other() == null ? 0 : brf59C.getR64_other().intValue());
			}
			Cell R64cell25 = R64row.getCell(27);
			if (R64cell25 != null) {
				R64cell25.setCellValue(brf59C.getR64_banks1() == null ? 0 : brf59C.getR64_banks1().intValue());
			}
			Cell R64cell26 = R64row.getCell(28);
			if (R64cell26 != null) {
				R64cell26.setCellValue(
						brf59C.getR64_individuals2() == null ? 0 : brf59C.getR64_individuals2().intValue());
			}
			Cell R64cell27 = R64row.getCell(29);
			if (R64cell27 != null) {
				R64cell27.setCellValue(brf59C.getR64_other1() == null ? 0 : brf59C.getR64_other1().intValue());
			}
			Cell R64cell28 = R64row.getCell(30);
			if (R64cell28 != null) {
				R64cell28.setCellValue(brf59C.getR64_banks2() == null ? 0 : brf59C.getR64_banks2().intValue());
			}
			Cell R64cell29 = R64row.getCell(31);
			if (R64cell29 != null) {
				R64cell29.setCellValue(brf59C.getR64_gov3() == null ? 0 : brf59C.getR64_gov3().intValue());
			}
			Cell R64cell30 = R64row.getCell(32);
			if (R64cell30 != null) {
				R64cell30.setCellValue(brf59C.getR64_others2() == null ? 0 : brf59C.getR64_others2().intValue());
			}
			Cell R64cell31 = R64row.getCell(33);
			if (R64cell31 != null) {
				R64cell31.setCellValue(brf59C.getR64_banks3() == null ? 0 : brf59C.getR64_banks3().intValue());
			}
			Cell R64cell32 = R64row.getCell(34);
			if (R64cell32 != null) {
				R64cell32.setCellValue(brf59C.getR64_gov4() == null ? 0 : brf59C.getR64_gov4().intValue());
			}
			Cell R64cell33 = R64row.getCell(35);
			if (R64cell33 != null) {
				R64cell33.setCellValue(brf59C.getR64_others3() == null ? 0 : brf59C.getR64_others3().intValue());
			}
			Cell R64cell34 = R64row.getCell(36);
			if (R64cell34 != null) {
				R64cell34.setCellValue(brf59C.getR64_foreign1() == null ? 0 : brf59C.getR64_foreign1().intValue());
			}
			Cell R64cell35 = R64row.getCell(37);
			if (R64cell35 != null) {
				R64cell35.setCellValue(brf59C.getR64_guarantees() == null ? 0 : brf59C.getR64_guarantees().intValue());
			}
			Cell R64cell36 = R64row.getCell(38);
			if (R64cell36 != null) {
				R64cell36.setCellValue(brf59C.getR64_nbfi2() == null ? 0 : brf59C.getR64_nbfi2().intValue());
			}
			Cell R64cell37 = R64row.getCell(39);
			if (R64cell37 != null) {
				R64cell37.setCellValue(brf59C.getR64_interbank2() == null ? 0 : brf59C.getR64_interbank2().intValue());
			}
			Cell R64cell38 = R64row.getCell(40);
			if (R64cell38 != null) {
				R64cell38.setCellValue(brf59C.getR64_gov5() == null ? 0 : brf59C.getR64_gov5().intValue());
			}
			Cell R64cell39 = R64row.getCell(41);
			if (R64cell39 != null) {
				R64cell39.setCellValue(brf59C.getR64_corporate2() == null ? 0 : brf59C.getR64_corporate2().intValue());
			}
			Cell R64cell40 = R64row.getCell(42);
			if (R64cell40 != null) {
				R64cell40.setCellValue(brf59C.getR64_gre2() == null ? 0 : brf59C.getR64_gre2().intValue());
			}
			Cell R64cell41 = R64row.getCell(43);
			if (R64cell41 != null) {
				R64cell41.setCellValue(
						brf59C.getR64_individuals3() == null ? 0 : brf59C.getR64_individuals3().intValue());
			}
			Cell R64cell42 = R64row.getCell(44);
			if (R64cell42 != null) {
				R64cell42.setCellValue(brf59C.getR64_zero1() == null ? 0 : brf59C.getR64_zero1().intValue());
			}
			Cell R64cell43 = R64row.getCell(45);
			if (R64cell43 != null) {
				R64cell43.setCellValue(brf59C.getR64_three1() == null ? 0 : brf59C.getR64_three1().intValue());
			}
			Cell R64cell44 = R64row.getCell(46);
			if (R64cell44 != null) {
				R64cell44.setCellValue(brf59C.getR64_six1() == null ? 0 : brf59C.getR64_six1().intValue());
			}
			Cell R64cell45 = R64row.getCell(47);
			if (R64cell45 != null) {
				R64cell45.setCellValue(brf59C.getR64_oneyear1() == null ? 0 : brf59C.getR64_oneyear1().intValue());
			}
			Cell R64cell46 = R64row.getCell(48);
			if (R64cell46 != null) {
				R64cell46.setCellValue(brf59C.getR64_empty() == null ? "" : brf59C.getR64_empty().toString());
			}
			Row R65row = sheet.getRow(82);
			Cell R65cell1 = R65row.getCell(3);
			if (R65cell1 != null) {
				R65cell1.setCellValue(brf59C.getR65_nbfi() == null ? 0 : brf59C.getR65_nbfi().intValue());
			}

			Cell R65cell2 = R65row.getCell(4);
			if (R65cell2 != null) {
				R65cell2.setCellValue(brf59C.getR65_interbank() == null ? 0 : brf59C.getR65_interbank().intValue());
			}
			Cell R65cell3 = R65row.getCell(5);
			if (R65cell3 != null) {
				R65cell3.setCellValue(brf59C.getR65_gov() == null ? 0 : brf59C.getR65_gov().intValue());
			}
			Cell R65cell4 = R65row.getCell(6);
			if (R65cell4 != null) {
				R65cell4.setCellValue(brf59C.getR65_corporate() == null ? 0 : brf59C.getR65_corporate().intValue());
			}
			Cell R65cell5 = R65row.getCell(7);
			if (R65cell5 != null) {
				R65cell5.setCellValue(brf59C.getR65_gre() == null ? 0 : brf59C.getR65_gre().intValue());
			}
			Cell R65cell6 = R65row.getCell(8);
			if (R65cell6 != null) {
				R65cell6.setCellValue(brf59C.getR65_trade() == null ? 0 : brf59C.getR65_trade().intValue());
			}
			Cell R65cell7 = R65row.getCell(9);
			if (R65cell7 != null) {
				R65cell7.setCellValue(brf59C.getR65_individuals() == null ? 0 : brf59C.getR65_individuals().intValue());
			}
			Cell R65cell8 = R65row.getCell(10);
			if (R65cell8 != null) {
				R65cell8.setCellValue(brf59C.getR65_investment() == null ? 0 : brf59C.getR65_investment().intValue());
			}
			Cell R65cell9 = R65row.getCell(11);
			if (R65cell9 != null) {
				R65cell9.setCellValue(brf59C.getR65_nbfi1() == null ? 0 : brf59C.getR65_nbfi1().intValue());
			}
			Cell R65cell10 = R65row.getCell(12);
			if (R65cell10 != null) {
				R65cell10.setCellValue(brf59C.getR65_interbank1() == null ? 0 : brf59C.getR65_interbank1().intValue());
			}
			Cell R65cell11 = R65row.getCell(13);
			if (R65cell11 != null) {
				R65cell11.setCellValue(brf59C.getR65_gov1() == null ? 0 : brf59C.getR65_gov1().intValue());
			}
			Cell R65cell12 = R65row.getCell(14);
			if (R65cell12 != null) {
				R65cell12.setCellValue(brf59C.getR65_corporate1() == null ? 0 : brf59C.getR65_corporate1().intValue());
			}
			Cell R65cell13 = R65row.getCell(15);
			if (R65cell13 != null) {
				R65cell13.setCellValue(brf59C.getR65_gre1() == null ? 0 : brf59C.getR65_gre1().intValue());
			}
			Cell R65cell14 = R65row.getCell(16);
			if (R65cell14 != null) {
				R65cell14.setCellValue(brf59C.getR65_trade1() == null ? 0 : brf59C.getR65_trade1().intValue());
			}
			Cell R65cell15 = R65row.getCell(17);
			if (R65cell15 != null) {
				R65cell15.setCellValue(
						brf59C.getR65_individuals1() == null ? 0 : brf59C.getR65_individuals1().intValue());
			}
			Cell R65cell16 = R65row.getCell(18);
			if (R65cell16 != null) {
				R65cell16
						.setCellValue(brf59C.getR65_investment1() == null ? 0 : brf59C.getR65_investment1().intValue());
			}
			Cell R65cell17 = R65row.getCell(19);
			if (R65cell17 != null) {
				R65cell17.setCellValue(brf59C.getR65_zer0() == null ? 0 : brf59C.getR65_zer0().intValue());
			}
			Cell R65cell18 = R65row.getCell(20);
			if (R65cell18 != null) {
				R65cell18.setCellValue(brf59C.getR65_three() == null ? 0 : brf59C.getR65_three().intValue());
			}
			Cell R65cell19 = R65row.getCell(21);
			if (R65cell19 != null) {
				R65cell19.setCellValue(brf59C.getR65_six() == null ? 0 : brf59C.getR65_six().intValue());
			}
			Cell R65cell20 = R65row.getCell(22);
			if (R65cell20 != null) {
				R65cell20.setCellValue(brf59C.getR65_oneyear() == null ? 0 : brf59C.getR65_oneyear().intValue());
			}
			Cell R65cell21 = R65row.getCell(23);
			if (R65cell21 != null) {
				R65cell21.setCellValue(brf59C.getR65_foreign() == null ? 0 : brf59C.getR65_foreign().intValue());
			}
			Cell R65cell22 = R65row.getCell(24);
			if (R65cell22 != null) {
				R65cell22.setCellValue(brf59C.getR65_banks() == null ? 0 : brf59C.getR65_banks().intValue());
			}
			Cell R65cell23 = R65row.getCell(25);
			if (R65cell23 != null) {
				R65cell23.setCellValue(brf59C.getR65_gov2() == null ? 0 : brf59C.getR65_gov2().intValue());
			}
			Cell R65cell24 = R65row.getCell(26);
			if (R65cell24 != null) {
				R65cell24.setCellValue(brf59C.getR65_other() == null ? 0 : brf59C.getR65_other().intValue());
			}
			Cell R65cell25 = R65row.getCell(27);
			if (R65cell25 != null) {
				R65cell25.setCellValue(brf59C.getR65_banks1() == null ? 0 : brf59C.getR65_banks1().intValue());
			}
			Cell R65cell26 = R65row.getCell(28);
			if (R65cell26 != null) {
				R65cell26.setCellValue(
						brf59C.getR65_individuals2() == null ? 0 : brf59C.getR65_individuals2().intValue());
			}
			Cell R65cell27 = R65row.getCell(29);
			if (R65cell27 != null) {
				R65cell27.setCellValue(brf59C.getR65_other1() == null ? 0 : brf59C.getR65_other1().intValue());
			}
			Cell R65cell28 = R65row.getCell(30);
			if (R65cell28 != null) {
				R65cell28.setCellValue(brf59C.getR65_banks2() == null ? 0 : brf59C.getR65_banks2().intValue());
			}
			Cell R65cell29 = R65row.getCell(31);
			if (R65cell29 != null) {
				R65cell29.setCellValue(brf59C.getR65_gov3() == null ? 0 : brf59C.getR65_gov3().intValue());
			}
			Cell R65cell30 = R65row.getCell(32);
			if (R65cell30 != null) {
				R65cell30.setCellValue(brf59C.getR65_others2() == null ? 0 : brf59C.getR65_others2().intValue());
			}
			Cell R65cell31 = R65row.getCell(33);
			if (R65cell31 != null) {
				R65cell31.setCellValue(brf59C.getR65_banks3() == null ? 0 : brf59C.getR65_banks3().intValue());
			}
			Cell R65cell32 = R65row.getCell(34);
			if (R65cell32 != null) {
				R65cell32.setCellValue(brf59C.getR65_gov4() == null ? 0 : brf59C.getR65_gov4().intValue());
			}
			Cell R65cell33 = R65row.getCell(35);
			if (R65cell33 != null) {
				R65cell33.setCellValue(brf59C.getR65_others3() == null ? 0 : brf59C.getR65_others3().intValue());
			}
			Cell R65cell34 = R65row.getCell(36);
			if (R65cell34 != null) {
				R65cell34.setCellValue(brf59C.getR65_foreign1() == null ? 0 : brf59C.getR65_foreign1().intValue());
			}
			Cell R65cell35 = R65row.getCell(37);
			if (R65cell35 != null) {
				R65cell35.setCellValue(brf59C.getR65_guarantees() == null ? 0 : brf59C.getR65_guarantees().intValue());
			}
			Cell R65cell36 = R65row.getCell(38);
			if (R65cell36 != null) {
				R65cell36.setCellValue(brf59C.getR65_nbfi2() == null ? 0 : brf59C.getR65_nbfi2().intValue());
			}
			Cell R65cell37 = R65row.getCell(39);
			if (R65cell37 != null) {
				R65cell37.setCellValue(brf59C.getR65_interbank2() == null ? 0 : brf59C.getR65_interbank2().intValue());
			}
			Cell R65cell38 = R65row.getCell(40);
			if (R65cell38 != null) {
				R65cell38.setCellValue(brf59C.getR65_gov5() == null ? 0 : brf59C.getR65_gov5().intValue());
			}
			Cell R65cell39 = R65row.getCell(41);
			if (R65cell39 != null) {
				R65cell39.setCellValue(brf59C.getR65_corporate2() == null ? 0 : brf59C.getR65_corporate2().intValue());
			}
			Cell R65cell40 = R65row.getCell(42);
			if (R65cell40 != null) {
				R65cell40.setCellValue(brf59C.getR65_gre2() == null ? 0 : brf59C.getR65_gre2().intValue());
			}
			Cell R65cell41 = R65row.getCell(43);
			if (R65cell41 != null) {
				R65cell41.setCellValue(
						brf59C.getR65_individuals3() == null ? 0 : brf59C.getR65_individuals3().intValue());
			}
			Cell R65cell42 = R65row.getCell(44);
			if (R65cell42 != null) {
				R65cell42.setCellValue(brf59C.getR65_zero1() == null ? 0 : brf59C.getR65_zero1().intValue());
			}
			Cell R65cell43 = R65row.getCell(45);
			if (R65cell43 != null) {
				R65cell43.setCellValue(brf59C.getR65_three1() == null ? 0 : brf59C.getR65_three1().intValue());
			}
			Cell R65cell44 = R65row.getCell(46);
			if (R65cell44 != null) {
				R65cell44.setCellValue(brf59C.getR65_six1() == null ? 0 : brf59C.getR65_six1().intValue());
			}
			Cell R65cell45 = R65row.getCell(47);
			if (R65cell45 != null) {
				R65cell45.setCellValue(brf59C.getR65_oneyear1() == null ? 0 : brf59C.getR65_oneyear1().intValue());
			}
			Cell R65cell46 = R65row.getCell(48);
			if (R65cell46 != null) {
				R65cell46.setCellValue(brf59C.getR65_empty() == null ? "" : brf59C.getR65_empty().toString());
			}
			Row R66row = sheet.getRow(83);
			Cell R66cell1 = R66row.getCell(3);
			if (R66cell1 != null) {
				R66cell1.setCellValue(brf59C.getR66_nbfi() == null ? 0 : brf59C.getR66_nbfi().intValue());
			}

			Cell R66cell2 = R66row.getCell(4);
			if (R66cell2 != null) {
				R66cell2.setCellValue(brf59C.getR66_interbank() == null ? 0 : brf59C.getR66_interbank().intValue());
			}
			Cell R66cell3 = R66row.getCell(5);
			if (R66cell3 != null) {
				R66cell3.setCellValue(brf59C.getR66_gov() == null ? 0 : brf59C.getR66_gov().intValue());
			}
			Cell R66cell4 = R66row.getCell(6);
			if (R66cell4 != null) {
				R66cell4.setCellValue(brf59C.getR66_corporate() == null ? 0 : brf59C.getR66_corporate().intValue());
			}
			Cell R66cell5 = R66row.getCell(7);
			if (R66cell5 != null) {
				R66cell5.setCellValue(brf59C.getR66_gre() == null ? 0 : brf59C.getR66_gre().intValue());
			}
			Cell R66cell6 = R66row.getCell(8);
			if (R66cell6 != null) {
				R66cell6.setCellValue(brf59C.getR66_trade() == null ? 0 : brf59C.getR66_trade().intValue());
			}
			Cell R66cell7 = R66row.getCell(9);
			if (R66cell7 != null) {
				R66cell7.setCellValue(brf59C.getR66_individuals() == null ? 0 : brf59C.getR66_individuals().intValue());
			}
			Cell R66cell8 = R66row.getCell(10);
			if (R66cell8 != null) {
				R66cell8.setCellValue(brf59C.getR66_investment() == null ? 0 : brf59C.getR66_investment().intValue());
			}
			Cell R66cell9 = R66row.getCell(11);
			if (R66cell9 != null) {
				R66cell9.setCellValue(brf59C.getR66_nbfi1() == null ? 0 : brf59C.getR66_nbfi1().intValue());
			}
			Cell R66cell10 = R66row.getCell(12);
			if (R66cell10 != null) {
				R66cell10.setCellValue(brf59C.getR66_interbank1() == null ? 0 : brf59C.getR66_interbank1().intValue());
			}
			Cell R66cell11 = R66row.getCell(13);
			if (R66cell11 != null) {
				R66cell11.setCellValue(brf59C.getR66_gov1() == null ? 0 : brf59C.getR66_gov1().intValue());
			}
			Cell R66cell12 = R66row.getCell(14);
			if (R66cell12 != null) {
				R66cell12.setCellValue(brf59C.getR66_corporate1() == null ? 0 : brf59C.getR66_corporate1().intValue());
			}
			Cell R66cell13 = R66row.getCell(15);
			if (R66cell13 != null) {
				R66cell13.setCellValue(brf59C.getR66_gre1() == null ? 0 : brf59C.getR66_gre1().intValue());
			}
			Cell R66cell14 = R66row.getCell(16);
			if (R66cell14 != null) {
				R66cell14.setCellValue(brf59C.getR66_trade1() == null ? 0 : brf59C.getR66_trade1().intValue());
			}
			Cell R66cell15 = R66row.getCell(17);
			if (R66cell15 != null) {
				R66cell15.setCellValue(
						brf59C.getR66_individuals1() == null ? 0 : brf59C.getR66_individuals1().intValue());
			}
			Cell R66cell16 = R66row.getCell(18);
			if (R66cell16 != null) {
				R66cell16
						.setCellValue(brf59C.getR66_investment1() == null ? 0 : brf59C.getR66_investment1().intValue());
			}
			Cell R66cell17 = R66row.getCell(19);
			if (R66cell17 != null) {
				R66cell17.setCellValue(brf59C.getR66_zer0() == null ? 0 : brf59C.getR66_zer0().intValue());
			}
			Cell R66cell18 = R66row.getCell(20);
			if (R66cell18 != null) {
				R66cell18.setCellValue(brf59C.getR66_three() == null ? 0 : brf59C.getR66_three().intValue());
			}
			Cell R66cell19 = R66row.getCell(21);
			if (R66cell19 != null) {
				R66cell19.setCellValue(brf59C.getR66_six() == null ? 0 : brf59C.getR66_six().intValue());
			}
			Cell R66cell20 = R66row.getCell(22);
			if (R66cell20 != null) {
				R66cell20.setCellValue(brf59C.getR66_oneyear() == null ? 0 : brf59C.getR66_oneyear().intValue());
			}
			Cell R66cell21 = R66row.getCell(23);
			if (R66cell21 != null) {
				R66cell21.setCellValue(brf59C.getR66_foreign() == null ? 0 : brf59C.getR66_foreign().intValue());
			}
			Cell R66cell22 = R66row.getCell(24);
			if (R66cell22 != null) {
				R66cell22.setCellValue(brf59C.getR66_banks() == null ? 0 : brf59C.getR66_banks().intValue());
			}
			Cell R66cell23 = R66row.getCell(25);
			if (R66cell23 != null) {
				R66cell23.setCellValue(brf59C.getR66_gov2() == null ? 0 : brf59C.getR66_gov2().intValue());
			}
			Cell R66cell24 = R66row.getCell(26);
			if (R66cell24 != null) {
				R66cell24.setCellValue(brf59C.getR66_other() == null ? 0 : brf59C.getR66_other().intValue());
			}
			Cell R66cell25 = R66row.getCell(27);
			if (R66cell25 != null) {
				R66cell25.setCellValue(brf59C.getR66_banks1() == null ? 0 : brf59C.getR66_banks1().intValue());
			}
			Cell R66cell26 = R66row.getCell(28);
			if (R66cell26 != null) {
				R66cell26.setCellValue(
						brf59C.getR66_individuals2() == null ? 0 : brf59C.getR66_individuals2().intValue());
			}
			Cell R66cell27 = R66row.getCell(29);
			if (R66cell27 != null) {
				R66cell27.setCellValue(brf59C.getR66_other1() == null ? 0 : brf59C.getR66_other1().intValue());
			}
			Cell R66cell28 = R66row.getCell(30);
			if (R66cell28 != null) {
				R66cell28.setCellValue(brf59C.getR66_banks2() == null ? 0 : brf59C.getR66_banks2().intValue());
			}
			Cell R66cell29 = R66row.getCell(31);
			if (R66cell29 != null) {
				R66cell29.setCellValue(brf59C.getR66_gov3() == null ? 0 : brf59C.getR66_gov3().intValue());
			}
			Cell R66cell30 = R66row.getCell(32);
			if (R66cell30 != null) {
				R66cell30.setCellValue(brf59C.getR66_others2() == null ? 0 : brf59C.getR66_others2().intValue());
			}
			Cell R66cell31 = R66row.getCell(33);
			if (R66cell31 != null) {
				R66cell31.setCellValue(brf59C.getR66_banks3() == null ? 0 : brf59C.getR66_banks3().intValue());
			}
			Cell R66cell32 = R66row.getCell(34);
			if (R66cell32 != null) {
				R66cell32.setCellValue(brf59C.getR66_gov4() == null ? 0 : brf59C.getR66_gov4().intValue());
			}
			Cell R66cell33 = R66row.getCell(35);
			if (R66cell33 != null) {
				R66cell33.setCellValue(brf59C.getR66_others3() == null ? 0 : brf59C.getR66_others3().intValue());
			}
			Cell R66cell34 = R66row.getCell(36);
			if (R66cell34 != null) {
				R66cell34.setCellValue(brf59C.getR66_foreign1() == null ? 0 : brf59C.getR66_foreign1().intValue());
			}
			Cell R66cell35 = R66row.getCell(37);
			if (R66cell35 != null) {
				R66cell35.setCellValue(brf59C.getR66_guarantees() == null ? 0 : brf59C.getR66_guarantees().intValue());
			}
			Cell R66cell36 = R66row.getCell(38);
			if (R66cell36 != null) {
				R66cell36.setCellValue(brf59C.getR66_nbfi2() == null ? 0 : brf59C.getR66_nbfi2().intValue());
			}
			Cell R66cell37 = R66row.getCell(39);
			if (R66cell37 != null) {
				R66cell37.setCellValue(brf59C.getR66_interbank2() == null ? 0 : brf59C.getR66_interbank2().intValue());
			}
			Cell R66cell38 = R66row.getCell(40);
			if (R66cell38 != null) {
				R66cell38.setCellValue(brf59C.getR66_gov5() == null ? 0 : brf59C.getR66_gov5().intValue());
			}
			Cell R66cell39 = R66row.getCell(41);
			if (R66cell39 != null) {
				R66cell39.setCellValue(brf59C.getR66_corporate2() == null ? 0 : brf59C.getR66_corporate2().intValue());
			}
			Cell R66cell40 = R66row.getCell(42);
			if (R66cell40 != null) {
				R66cell40.setCellValue(brf59C.getR66_gre2() == null ? 0 : brf59C.getR66_gre2().intValue());
			}
			Cell R66cell41 = R66row.getCell(43);
			if (R66cell41 != null) {
				R66cell41.setCellValue(
						brf59C.getR66_individuals3() == null ? 0 : brf59C.getR66_individuals3().intValue());
			}
			Cell R66cell42 = R66row.getCell(44);
			if (R66cell42 != null) {
				R66cell42.setCellValue(brf59C.getR66_zero1() == null ? 0 : brf59C.getR66_zero1().intValue());
			}
			Cell R66cell43 = R66row.getCell(45);
			if (R66cell43 != null) {
				R66cell43.setCellValue(brf59C.getR66_three1() == null ? 0 : brf59C.getR66_three1().intValue());
			}
			Cell R66cell44 = R66row.getCell(46);
			if (R66cell44 != null) {
				R66cell44.setCellValue(brf59C.getR66_six1() == null ? 0 : brf59C.getR66_six1().intValue());
			}
			Cell R66cell45 = R66row.getCell(47);
			if (R66cell45 != null) {
				R66cell45.setCellValue(brf59C.getR66_oneyear1() == null ? 0 : brf59C.getR66_oneyear1().intValue());
			}
			Cell R66cell46 = R66row.getCell(48);
			if (R66cell46 != null) {
				R66cell46.setCellValue(brf59C.getR66_empty() == null ? "" : brf59C.getR66_empty().toString());
			}
			Row R67row = sheet.getRow(84);
			Cell R67cell1 = R67row.getCell(3);
			if (R67cell1 != null) {
				R67cell1.setCellValue(brf59C.getR67_nbfi() == null ? 0 : brf59C.getR67_nbfi().intValue());
			}

			Cell R67cell2 = R67row.getCell(4);
			if (R67cell2 != null) {
				R67cell2.setCellValue(brf59C.getR67_interbank() == null ? 0 : brf59C.getR67_interbank().intValue());
			}
			Cell R67cell3 = R67row.getCell(5);
			if (R67cell3 != null) {
				R67cell3.setCellValue(brf59C.getR67_gov() == null ? 0 : brf59C.getR67_gov().intValue());
			}
			Cell R67cell4 = R67row.getCell(6);
			if (R67cell4 != null) {
				R67cell4.setCellValue(brf59C.getR67_corporate() == null ? 0 : brf59C.getR67_corporate().intValue());
			}
			Cell R67cell5 = R67row.getCell(7);
			if (R67cell5 != null) {
				R67cell5.setCellValue(brf59C.getR67_gre() == null ? 0 : brf59C.getR67_gre().intValue());
			}
			Cell R67cell6 = R67row.getCell(8);
			if (R67cell6 != null) {
				R67cell6.setCellValue(brf59C.getR67_trade() == null ? 0 : brf59C.getR67_trade().intValue());
			}
			Cell R67cell7 = R67row.getCell(9);
			if (R67cell7 != null) {
				R67cell7.setCellValue(brf59C.getR67_individuals() == null ? 0 : brf59C.getR67_individuals().intValue());
			}
			Cell R67cell8 = R67row.getCell(10);
			if (R67cell8 != null) {
				R67cell8.setCellValue(brf59C.getR67_investment() == null ? 0 : brf59C.getR67_investment().intValue());
			}
			Cell R67cell9 = R67row.getCell(11);
			if (R67cell9 != null) {
				R67cell9.setCellValue(brf59C.getR67_nbfi1() == null ? 0 : brf59C.getR67_nbfi1().intValue());
			}
			Cell R67cell10 = R67row.getCell(12);
			if (R67cell10 != null) {
				R67cell10.setCellValue(brf59C.getR67_interbank1() == null ? 0 : brf59C.getR67_interbank1().intValue());
			}
			Cell R67cell11 = R67row.getCell(13);
			if (R67cell11 != null) {
				R67cell11.setCellValue(brf59C.getR67_gov1() == null ? 0 : brf59C.getR67_gov1().intValue());
			}
			Cell R67cell12 = R67row.getCell(14);
			if (R67cell12 != null) {
				R67cell12.setCellValue(brf59C.getR67_corporate1() == null ? 0 : brf59C.getR67_corporate1().intValue());
			}
			Cell R67cell13 = R67row.getCell(15);
			if (R67cell13 != null) {
				R67cell13.setCellValue(brf59C.getR67_gre1() == null ? 0 : brf59C.getR67_gre1().intValue());
			}
			Cell R67cell14 = R67row.getCell(16);
			if (R67cell14 != null) {
				R67cell14.setCellValue(brf59C.getR67_trade1() == null ? 0 : brf59C.getR67_trade1().intValue());
			}
			Cell R67cell15 = R67row.getCell(17);
			if (R67cell15 != null) {
				R67cell15.setCellValue(
						brf59C.getR67_individuals1() == null ? 0 : brf59C.getR67_individuals1().intValue());
			}
			Cell R67cell16 = R67row.getCell(18);
			if (R67cell16 != null) {
				R67cell16
						.setCellValue(brf59C.getR67_investment1() == null ? 0 : brf59C.getR67_investment1().intValue());
			}
			Cell R67cell17 = R67row.getCell(19);
			if (R67cell17 != null) {
				R67cell17.setCellValue(brf59C.getR67_zer0() == null ? 0 : brf59C.getR67_zer0().intValue());
			}
			Cell R67cell18 = R67row.getCell(20);
			if (R67cell18 != null) {
				R67cell18.setCellValue(brf59C.getR67_three() == null ? 0 : brf59C.getR67_three().intValue());
			}
			Cell R67cell19 = R67row.getCell(21);
			if (R67cell19 != null) {
				R67cell19.setCellValue(brf59C.getR67_six() == null ? 0 : brf59C.getR67_six().intValue());
			}
			Cell R67cell20 = R67row.getCell(22);
			if (R67cell20 != null) {
				R67cell20.setCellValue(brf59C.getR67_oneyear() == null ? 0 : brf59C.getR67_oneyear().intValue());
			}
			Cell R67cell21 = R67row.getCell(23);
			if (R67cell21 != null) {
				R67cell21.setCellValue(brf59C.getR67_foreign() == null ? 0 : brf59C.getR67_foreign().intValue());
			}
			Cell R67cell22 = R67row.getCell(24);
			if (R67cell22 != null) {
				R67cell22.setCellValue(brf59C.getR67_banks() == null ? 0 : brf59C.getR67_banks().intValue());
			}
			Cell R67cell23 = R67row.getCell(25);
			if (R67cell23 != null) {
				R67cell23.setCellValue(brf59C.getR67_gov2() == null ? 0 : brf59C.getR67_gov2().intValue());
			}
			Cell R67cell24 = R67row.getCell(26);
			if (R67cell24 != null) {
				R67cell24.setCellValue(brf59C.getR67_other() == null ? 0 : brf59C.getR67_other().intValue());
			}
			Cell R67cell25 = R67row.getCell(27);
			if (R67cell25 != null) {
				R67cell25.setCellValue(brf59C.getR67_banks1() == null ? 0 : brf59C.getR67_banks1().intValue());
			}
			Cell R67cell26 = R67row.getCell(28);
			if (R67cell26 != null) {
				R67cell26.setCellValue(
						brf59C.getR67_individuals2() == null ? 0 : brf59C.getR67_individuals2().intValue());
			}
			Cell R67cell27 = R67row.getCell(29);
			if (R67cell27 != null) {
				R67cell27.setCellValue(brf59C.getR67_other1() == null ? 0 : brf59C.getR67_other1().intValue());
			}
			Cell R67cell28 = R67row.getCell(30);
			if (R67cell28 != null) {
				R67cell28.setCellValue(brf59C.getR67_banks2() == null ? 0 : brf59C.getR67_banks2().intValue());
			}
			Cell R67cell29 = R67row.getCell(31);
			if (R67cell29 != null) {
				R67cell29.setCellValue(brf59C.getR67_gov3() == null ? 0 : brf59C.getR67_gov3().intValue());
			}
			Cell R67cell30 = R67row.getCell(32);
			if (R67cell30 != null) {
				R67cell30.setCellValue(brf59C.getR67_others2() == null ? 0 : brf59C.getR67_others2().intValue());
			}
			Cell R67cell31 = R67row.getCell(33);
			if (R67cell31 != null) {
				R67cell31.setCellValue(brf59C.getR67_banks3() == null ? 0 : brf59C.getR67_banks3().intValue());
			}
			Cell R67cell32 = R67row.getCell(34);
			if (R67cell32 != null) {
				R67cell32.setCellValue(brf59C.getR67_gov4() == null ? 0 : brf59C.getR67_gov4().intValue());
			}
			Cell R67cell33 = R67row.getCell(35);
			if (R67cell33 != null) {
				R67cell33.setCellValue(brf59C.getR67_others3() == null ? 0 : brf59C.getR67_others3().intValue());
			}
			Cell R67cell34 = R67row.getCell(36);
			if (R67cell34 != null) {
				R67cell34.setCellValue(brf59C.getR67_foreign1() == null ? 0 : brf59C.getR67_foreign1().intValue());
			}
			Cell R67cell35 = R67row.getCell(37);
			if (R67cell35 != null) {
				R67cell35.setCellValue(brf59C.getR67_guarantees() == null ? 0 : brf59C.getR67_guarantees().intValue());
			}
			Cell R67cell36 = R67row.getCell(38);
			if (R67cell36 != null) {
				R67cell36.setCellValue(brf59C.getR67_nbfi2() == null ? 0 : brf59C.getR67_nbfi2().intValue());
			}
			Cell R67cell37 = R67row.getCell(39);
			if (R67cell37 != null) {
				R67cell37.setCellValue(brf59C.getR67_interbank2() == null ? 0 : brf59C.getR67_interbank2().intValue());
			}
			Cell R67cell38 = R67row.getCell(40);
			if (R67cell38 != null) {
				R67cell38.setCellValue(brf59C.getR67_gov5() == null ? 0 : brf59C.getR67_gov5().intValue());
			}
			Cell R67cell39 = R67row.getCell(41);
			if (R67cell39 != null) {
				R67cell39.setCellValue(brf59C.getR67_corporate2() == null ? 0 : brf59C.getR67_corporate2().intValue());
			}
			Cell R67cell40 = R67row.getCell(42);
			if (R67cell40 != null) {
				R67cell40.setCellValue(brf59C.getR67_gre2() == null ? 0 : brf59C.getR67_gre2().intValue());
			}
			Cell R67cell41 = R67row.getCell(43);
			if (R67cell41 != null) {
				R67cell41.setCellValue(
						brf59C.getR67_individuals3() == null ? 0 : brf59C.getR67_individuals3().intValue());
			}
			Cell R67cell42 = R67row.getCell(44);
			if (R67cell42 != null) {
				R67cell42.setCellValue(brf59C.getR67_zero1() == null ? 0 : brf59C.getR67_zero1().intValue());
			}
			Cell R67cell43 = R67row.getCell(45);
			if (R67cell43 != null) {
				R67cell43.setCellValue(brf59C.getR67_three1() == null ? 0 : brf59C.getR67_three1().intValue());
			}
			Cell R67cell44 = R67row.getCell(46);
			if (R67cell44 != null) {
				R67cell44.setCellValue(brf59C.getR67_six1() == null ? 0 : brf59C.getR67_six1().intValue());
			}
			Cell R67cell45 = R67row.getCell(47);
			if (R67cell45 != null) {
				R67cell45.setCellValue(brf59C.getR67_oneyear1() == null ? 0 : brf59C.getR67_oneyear1().intValue());
			}
			Cell R67cell46 = R67row.getCell(48);
			if (R67cell46 != null) {
				R67cell46.setCellValue(brf59C.getR67_empty() == null ? "" : brf59C.getR67_empty().toString());
			}
			Row R68row = sheet.getRow(85);
			Cell R68cell1 = R68row.getCell(3);
			if (R68cell1 != null) {
				R68cell1.setCellValue(brf59C.getR68_nbfi() == null ? 0 : brf59C.getR68_nbfi().intValue());
			}

			Cell R68cell2 = R68row.getCell(4);
			if (R68cell2 != null) {
				R68cell2.setCellValue(brf59C.getR68_interbank() == null ? 0 : brf59C.getR68_interbank().intValue());
			}
			Cell R68cell3 = R68row.getCell(5);
			if (R68cell3 != null) {
				R68cell3.setCellValue(brf59C.getR68_gov() == null ? 0 : brf59C.getR68_gov().intValue());
			}
			Cell R68cell4 = R68row.getCell(6);
			if (R68cell4 != null) {
				R68cell4.setCellValue(brf59C.getR68_corporate() == null ? 0 : brf59C.getR68_corporate().intValue());
			}
			Cell R68cell5 = R68row.getCell(7);
			if (R68cell5 != null) {
				R68cell5.setCellValue(brf59C.getR68_gre() == null ? 0 : brf59C.getR68_gre().intValue());
			}
			Cell R68cell6 = R68row.getCell(8);
			if (R68cell6 != null) {
				R68cell6.setCellValue(brf59C.getR68_trade() == null ? 0 : brf59C.getR68_trade().intValue());
			}
			Cell R68cell7 = R68row.getCell(9);
			if (R68cell7 != null) {
				R68cell7.setCellValue(brf59C.getR68_individuals() == null ? 0 : brf59C.getR68_individuals().intValue());
			}
			Cell R68cell8 = R68row.getCell(10);
			if (R68cell8 != null) {
				R68cell8.setCellValue(brf59C.getR68_investment() == null ? 0 : brf59C.getR68_investment().intValue());
			}
			Cell R68cell9 = R68row.getCell(11);
			if (R68cell9 != null) {
				R68cell9.setCellValue(brf59C.getR68_nbfi1() == null ? 0 : brf59C.getR68_nbfi1().intValue());
			}
			Cell R68cell10 = R68row.getCell(12);
			if (R68cell10 != null) {
				R68cell10.setCellValue(brf59C.getR68_interbank1() == null ? 0 : brf59C.getR68_interbank1().intValue());
			}
			Cell R68cell11 = R68row.getCell(13);
			if (R68cell11 != null) {
				R68cell11.setCellValue(brf59C.getR68_gov1() == null ? 0 : brf59C.getR68_gov1().intValue());
			}
			Cell R68cell12 = R68row.getCell(14);
			if (R68cell12 != null) {
				R68cell12.setCellValue(brf59C.getR68_corporate1() == null ? 0 : brf59C.getR68_corporate1().intValue());
			}
			Cell R68cell13 = R68row.getCell(15);
			if (R68cell13 != null) {
				R68cell13.setCellValue(brf59C.getR68_gre1() == null ? 0 : brf59C.getR68_gre1().intValue());
			}
			Cell R68cell14 = R68row.getCell(16);
			if (R68cell14 != null) {
				R68cell14.setCellValue(brf59C.getR68_trade1() == null ? 0 : brf59C.getR68_trade1().intValue());
			}
			Cell R68cell15 = R68row.getCell(17);
			if (R68cell15 != null) {
				R68cell15.setCellValue(
						brf59C.getR68_individuals1() == null ? 0 : brf59C.getR68_individuals1().intValue());
			}
			Cell R68cell16 = R68row.getCell(18);
			if (R68cell16 != null) {
				R68cell16
						.setCellValue(brf59C.getR68_investment1() == null ? 0 : brf59C.getR68_investment1().intValue());
			}
			Cell R68cell17 = R68row.getCell(19);
			if (R68cell17 != null) {
				R68cell17.setCellValue(brf59C.getR68_zer0() == null ? 0 : brf59C.getR68_zer0().intValue());
			}
			Cell R68cell18 = R68row.getCell(20);
			if (R68cell18 != null) {
				R68cell18.setCellValue(brf59C.getR68_three() == null ? 0 : brf59C.getR68_three().intValue());
			}
			Cell R68cell19 = R68row.getCell(21);
			if (R68cell19 != null) {
				R68cell19.setCellValue(brf59C.getR68_six() == null ? 0 : brf59C.getR68_six().intValue());
			}
			Cell R68cell20 = R68row.getCell(22);
			if (R68cell20 != null) {
				R68cell20.setCellValue(brf59C.getR68_oneyear() == null ? 0 : brf59C.getR68_oneyear().intValue());
			}
			Cell R68cell21 = R68row.getCell(23);
			if (R68cell21 != null) {
				R68cell21.setCellValue(brf59C.getR68_foreign() == null ? 0 : brf59C.getR68_foreign().intValue());
			}
			Cell R68cell22 = R68row.getCell(24);
			if (R68cell22 != null) {
				R68cell22.setCellValue(brf59C.getR68_banks() == null ? 0 : brf59C.getR68_banks().intValue());
			}
			Cell R68cell23 = R68row.getCell(25);
			if (R68cell23 != null) {
				R68cell23.setCellValue(brf59C.getR68_gov2() == null ? 0 : brf59C.getR68_gov2().intValue());
			}
			Cell R68cell24 = R68row.getCell(26);
			if (R68cell24 != null) {
				R68cell24.setCellValue(brf59C.getR68_other() == null ? 0 : brf59C.getR68_other().intValue());
			}
			Cell R68cell25 = R68row.getCell(27);
			if (R68cell25 != null) {
				R68cell25.setCellValue(brf59C.getR68_banks1() == null ? 0 : brf59C.getR68_banks1().intValue());
			}
			Cell R68cell26 = R68row.getCell(28);
			if (R68cell26 != null) {
				R68cell26.setCellValue(
						brf59C.getR68_individuals2() == null ? 0 : brf59C.getR68_individuals2().intValue());
			}
			Cell R68cell27 = R68row.getCell(29);
			if (R68cell27 != null) {
				R68cell27.setCellValue(brf59C.getR68_other1() == null ? 0 : brf59C.getR68_other1().intValue());
			}
			Cell R68cell28 = R68row.getCell(30);
			if (R68cell28 != null) {
				R68cell28.setCellValue(brf59C.getR68_banks2() == null ? 0 : brf59C.getR68_banks2().intValue());
			}
			Cell R68cell29 = R68row.getCell(31);
			if (R68cell29 != null) {
				R68cell29.setCellValue(brf59C.getR68_gov3() == null ? 0 : brf59C.getR68_gov3().intValue());
			}
			Cell R68cell30 = R68row.getCell(32);
			if (R68cell30 != null) {
				R68cell30.setCellValue(brf59C.getR68_others2() == null ? 0 : brf59C.getR68_others2().intValue());
			}
			Cell R68cell31 = R68row.getCell(33);
			if (R68cell31 != null) {
				R68cell31.setCellValue(brf59C.getR68_banks3() == null ? 0 : brf59C.getR68_banks3().intValue());
			}
			Cell R68cell32 = R68row.getCell(34);
			if (R68cell32 != null) {
				R68cell32.setCellValue(brf59C.getR68_gov4() == null ? 0 : brf59C.getR68_gov4().intValue());
			}
			Cell R68cell33 = R68row.getCell(35);
			if (R68cell33 != null) {
				R68cell33.setCellValue(brf59C.getR68_others3() == null ? 0 : brf59C.getR68_others3().intValue());
			}
			Cell R68cell34 = R68row.getCell(36);
			if (R68cell34 != null) {
				R68cell34.setCellValue(brf59C.getR68_foreign1() == null ? 0 : brf59C.getR68_foreign1().intValue());
			}
			Cell R68cell35 = R68row.getCell(37);
			if (R68cell35 != null) {
				R68cell35.setCellValue(brf59C.getR68_guarantees() == null ? 0 : brf59C.getR68_guarantees().intValue());
			}
			Cell R68cell36 = R68row.getCell(38);
			if (R68cell36 != null) {
				R68cell36.setCellValue(brf59C.getR68_nbfi2() == null ? 0 : brf59C.getR68_nbfi2().intValue());
			}
			Cell R68cell37 = R68row.getCell(39);
			if (R68cell37 != null) {
				R68cell37.setCellValue(brf59C.getR68_interbank2() == null ? 0 : brf59C.getR68_interbank2().intValue());
			}
			Cell R68cell38 = R68row.getCell(40);
			if (R68cell38 != null) {
				R68cell38.setCellValue(brf59C.getR68_gov5() == null ? 0 : brf59C.getR68_gov5().intValue());
			}
			Cell R68cell39 = R68row.getCell(41);
			if (R68cell39 != null) {
				R68cell39.setCellValue(brf59C.getR68_corporate2() == null ? 0 : brf59C.getR68_corporate2().intValue());
			}
			Cell R68cell40 = R68row.getCell(42);
			if (R68cell40 != null) {
				R68cell40.setCellValue(brf59C.getR68_gre2() == null ? 0 : brf59C.getR68_gre2().intValue());
			}
			Cell R68cell41 = R68row.getCell(43);
			if (R68cell41 != null) {
				R68cell41.setCellValue(
						brf59C.getR68_individuals3() == null ? 0 : brf59C.getR68_individuals3().intValue());
			}
			Cell R68cell42 = R68row.getCell(44);
			if (R68cell42 != null) {
				R68cell42.setCellValue(brf59C.getR68_zero1() == null ? 0 : brf59C.getR68_zero1().intValue());
			}
			Cell R68cell43 = R68row.getCell(45);
			if (R68cell43 != null) {
				R68cell43.setCellValue(brf59C.getR68_three1() == null ? 0 : brf59C.getR68_three1().intValue());
			}
			Cell R68cell44 = R68row.getCell(46);
			if (R68cell44 != null) {
				R68cell44.setCellValue(brf59C.getR68_six1() == null ? 0 : brf59C.getR68_six1().intValue());
			}
			Cell R68cell45 = R68row.getCell(47);
			if (R68cell45 != null) {
				R68cell45.setCellValue(brf59C.getR68_oneyear1() == null ? 0 : brf59C.getR68_oneyear1().intValue());
			}
			Cell R68cell46 = R68row.getCell(48);
			if (R68cell46 != null) {
				R68cell46.setCellValue(brf59C.getR68_empty() == null ? "" : brf59C.getR68_empty().toString());
			}
			Row R69row = sheet.getRow(86);
			Cell R69cell1 = R69row.getCell(3);
			if (R69cell1 != null) {
				R69cell1.setCellValue(brf59C.getR69_nbfi() == null ? 0 : brf59C.getR69_nbfi().intValue());
			}

			Cell R69cell2 = R69row.getCell(4);
			if (R69cell2 != null) {
				R69cell2.setCellValue(brf59C.getR69_interbank() == null ? 0 : brf59C.getR69_interbank().intValue());
			}
			Cell R69cell3 = R69row.getCell(5);
			if (R69cell3 != null) {
				R69cell3.setCellValue(brf59C.getR69_gov() == null ? 0 : brf59C.getR69_gov().intValue());
			}
			Cell R69cell4 = R69row.getCell(6);
			if (R69cell4 != null) {
				R69cell4.setCellValue(brf59C.getR69_corporate() == null ? 0 : brf59C.getR69_corporate().intValue());
			}
			Cell R69cell5 = R69row.getCell(7);
			if (R69cell5 != null) {
				R69cell5.setCellValue(brf59C.getR69_gre() == null ? 0 : brf59C.getR69_gre().intValue());
			}
			Cell R69cell6 = R69row.getCell(8);
			if (R69cell6 != null) {
				R69cell6.setCellValue(brf59C.getR69_trade() == null ? 0 : brf59C.getR69_trade().intValue());
			}
			Cell R69cell7 = R69row.getCell(9);
			if (R69cell7 != null) {
				R69cell7.setCellValue(brf59C.getR69_individuals() == null ? 0 : brf59C.getR69_individuals().intValue());
			}
			Cell R69cell8 = R69row.getCell(10);
			if (R69cell8 != null) {
				R69cell8.setCellValue(brf59C.getR69_investment() == null ? 0 : brf59C.getR69_investment().intValue());
			}
			Cell R69cell9 = R69row.getCell(11);
			if (R69cell9 != null) {
				R69cell9.setCellValue(brf59C.getR69_nbfi1() == null ? 0 : brf59C.getR69_nbfi1().intValue());
			}
			Cell R69cell10 = R69row.getCell(12);
			if (R69cell10 != null) {
				R69cell10.setCellValue(brf59C.getR69_interbank1() == null ? 0 : brf59C.getR69_interbank1().intValue());
			}
			Cell R69cell11 = R69row.getCell(13);
			if (R69cell11 != null) {
				R69cell11.setCellValue(brf59C.getR69_gov1() == null ? 0 : brf59C.getR69_gov1().intValue());
			}
			Cell R69cell12 = R69row.getCell(14);
			if (R69cell12 != null) {
				R69cell12.setCellValue(brf59C.getR69_corporate1() == null ? 0 : brf59C.getR69_corporate1().intValue());
			}
			Cell R69cell13 = R69row.getCell(15);
			if (R69cell13 != null) {
				R69cell13.setCellValue(brf59C.getR69_gre1() == null ? 0 : brf59C.getR69_gre1().intValue());
			}
			Cell R69cell14 = R69row.getCell(16);
			if (R69cell14 != null) {
				R69cell14.setCellValue(brf59C.getR69_trade1() == null ? 0 : brf59C.getR69_trade1().intValue());
			}
			Cell R69cell15 = R69row.getCell(17);
			if (R69cell15 != null) {
				R69cell15.setCellValue(
						brf59C.getR69_individuals1() == null ? 0 : brf59C.getR69_individuals1().intValue());
			}
			Cell R69cell16 = R69row.getCell(18);
			if (R69cell16 != null) {
				R69cell16
						.setCellValue(brf59C.getR69_investment1() == null ? 0 : brf59C.getR69_investment1().intValue());
			}
			Cell R69cell17 = R69row.getCell(19);
			if (R69cell17 != null) {
				R69cell17.setCellValue(brf59C.getR69_zer0() == null ? 0 : brf59C.getR69_zer0().intValue());
			}
			Cell R69cell18 = R69row.getCell(20);
			if (R69cell18 != null) {
				R69cell18.setCellValue(brf59C.getR69_three() == null ? 0 : brf59C.getR69_three().intValue());
			}
			Cell R69cell19 = R69row.getCell(21);
			if (R69cell19 != null) {
				R69cell19.setCellValue(brf59C.getR69_six() == null ? 0 : brf59C.getR69_six().intValue());
			}
			Cell R69cell20 = R69row.getCell(22);
			if (R69cell20 != null) {
				R69cell20.setCellValue(brf59C.getR69_oneyear() == null ? 0 : brf59C.getR69_oneyear().intValue());
			}
			Cell R69cell21 = R69row.getCell(23);
			if (R69cell21 != null) {
				R69cell21.setCellValue(brf59C.getR69_foreign() == null ? 0 : brf59C.getR69_foreign().intValue());
			}
			Cell R69cell22 = R69row.getCell(24);
			if (R69cell22 != null) {
				R69cell22.setCellValue(brf59C.getR69_banks() == null ? 0 : brf59C.getR69_banks().intValue());
			}
			Cell R69cell23 = R69row.getCell(25);
			if (R69cell23 != null) {
				R69cell23.setCellValue(brf59C.getR69_gov2() == null ? 0 : brf59C.getR69_gov2().intValue());
			}
			Cell R69cell24 = R69row.getCell(26);
			if (R69cell24 != null) {
				R69cell24.setCellValue(brf59C.getR69_other() == null ? 0 : brf59C.getR69_other().intValue());
			}
			Cell R69cell25 = R69row.getCell(27);
			if (R69cell25 != null) {
				R69cell25.setCellValue(brf59C.getR69_banks1() == null ? 0 : brf59C.getR69_banks1().intValue());
			}
			Cell R69cell26 = R69row.getCell(28);
			if (R69cell26 != null) {
				R69cell26.setCellValue(
						brf59C.getR69_individuals2() == null ? 0 : brf59C.getR69_individuals2().intValue());
			}
			Cell R69cell27 = R69row.getCell(29);
			if (R69cell27 != null) {
				R69cell27.setCellValue(brf59C.getR69_other1() == null ? 0 : brf59C.getR69_other1().intValue());
			}
			Cell R69cell28 = R69row.getCell(30);
			if (R69cell28 != null) {
				R69cell28.setCellValue(brf59C.getR69_banks2() == null ? 0 : brf59C.getR69_banks2().intValue());
			}
			Cell R69cell29 = R69row.getCell(31);
			if (R69cell29 != null) {
				R69cell29.setCellValue(brf59C.getR69_gov3() == null ? 0 : brf59C.getR69_gov3().intValue());
			}
			Cell R69cell30 = R69row.getCell(32);
			if (R69cell30 != null) {
				R69cell30.setCellValue(brf59C.getR69_others2() == null ? 0 : brf59C.getR69_others2().intValue());
			}
			Cell R69cell31 = R69row.getCell(33);
			if (R69cell31 != null) {
				R69cell31.setCellValue(brf59C.getR69_banks3() == null ? 0 : brf59C.getR69_banks3().intValue());
			}
			Cell R69cell32 = R69row.getCell(34);
			if (R69cell32 != null) {
				R69cell32.setCellValue(brf59C.getR69_gov4() == null ? 0 : brf59C.getR69_gov4().intValue());
			}
			Cell R69cell33 = R69row.getCell(35);
			if (R69cell33 != null) {
				R69cell33.setCellValue(brf59C.getR69_others3() == null ? 0 : brf59C.getR69_others3().intValue());
			}
			Cell R69cell34 = R69row.getCell(36);
			if (R69cell34 != null) {
				R69cell34.setCellValue(brf59C.getR69_foreign1() == null ? 0 : brf59C.getR69_foreign1().intValue());
			}
			Cell R69cell35 = R69row.getCell(37);
			if (R69cell35 != null) {
				R69cell35.setCellValue(brf59C.getR69_guarantees() == null ? 0 : brf59C.getR69_guarantees().intValue());
			}
			Cell R69cell36 = R69row.getCell(38);
			if (R69cell36 != null) {
				R69cell36.setCellValue(brf59C.getR69_nbfi2() == null ? 0 : brf59C.getR69_nbfi2().intValue());
			}
			Cell R69cell37 = R69row.getCell(39);
			if (R69cell37 != null) {
				R69cell37.setCellValue(brf59C.getR69_interbank2() == null ? 0 : brf59C.getR69_interbank2().intValue());
			}
			Cell R69cell38 = R69row.getCell(40);
			if (R69cell38 != null) {
				R69cell38.setCellValue(brf59C.getR69_gov5() == null ? 0 : brf59C.getR69_gov5().intValue());
			}
			Cell R69cell39 = R69row.getCell(41);
			if (R69cell39 != null) {
				R69cell39.setCellValue(brf59C.getR69_corporate2() == null ? 0 : brf59C.getR69_corporate2().intValue());
			}
			Cell R69cell40 = R69row.getCell(42);
			if (R69cell40 != null) {
				R69cell40.setCellValue(brf59C.getR69_gre2() == null ? 0 : brf59C.getR69_gre2().intValue());
			}
			Cell R69cell41 = R69row.getCell(43);
			if (R69cell41 != null) {
				R69cell41.setCellValue(
						brf59C.getR69_individuals3() == null ? 0 : brf59C.getR69_individuals3().intValue());
			}
			Cell R69cell42 = R69row.getCell(44);
			if (R69cell42 != null) {
				R69cell42.setCellValue(brf59C.getR69_zero1() == null ? 0 : brf59C.getR69_zero1().intValue());
			}
			Cell R69cell43 = R69row.getCell(45);
			if (R69cell43 != null) {
				R69cell43.setCellValue(brf59C.getR69_three1() == null ? 0 : brf59C.getR69_three1().intValue());
			}
			Cell R69cell44 = R69row.getCell(46);
			if (R69cell44 != null) {
				R69cell44.setCellValue(brf59C.getR69_six1() == null ? 0 : brf59C.getR69_six1().intValue());
			}
			Cell R69cell45 = R69row.getCell(47);
			if (R69cell45 != null) {
				R69cell45.setCellValue(brf59C.getR69_oneyear1() == null ? 0 : brf59C.getR69_oneyear1().intValue());
			}
			Cell R69cell46 = R69row.getCell(48);
			if (R69cell46 != null) {
				R69cell46.setCellValue(brf59C.getR69_empty() == null ? "" : brf59C.getR69_empty().toString());
			}
			Row R70row = sheet.getRow(87);
			Cell R70cell1 = R70row.getCell(3);
			if (R70cell1 != null) {
				R70cell1.setCellValue(brf59C.getR70_nbfi() == null ? 0 : brf59C.getR70_nbfi().intValue());
			}

			Cell R70cell2 = R70row.getCell(4);
			if (R70cell2 != null) {
				R70cell2.setCellValue(brf59C.getR70_interbank() == null ? 0 : brf59C.getR70_interbank().intValue());
			}
			Cell R70cell3 = R70row.getCell(5);
			if (R70cell3 != null) {
				R70cell3.setCellValue(brf59C.getR70_gov() == null ? 0 : brf59C.getR70_gov().intValue());
			}
			Cell R70cell4 = R70row.getCell(6);
			if (R70cell4 != null) {
				R70cell4.setCellValue(brf59C.getR70_corporate() == null ? 0 : brf59C.getR70_corporate().intValue());
			}
			Cell R70cell5 = R70row.getCell(7);
			if (R70cell5 != null) {
				R70cell5.setCellValue(brf59C.getR70_gre() == null ? 0 : brf59C.getR70_gre().intValue());
			}
			Cell R70cell6 = R70row.getCell(8);
			if (R70cell6 != null) {
				R70cell6.setCellValue(brf59C.getR70_trade() == null ? 0 : brf59C.getR70_trade().intValue());
			}
			Cell R70cell7 = R70row.getCell(9);
			if (R70cell7 != null) {
				R70cell7.setCellValue(brf59C.getR70_individuals() == null ? 0 : brf59C.getR70_individuals().intValue());
			}
			Cell R70cell8 = R70row.getCell(10);
			if (R70cell8 != null) {
				R70cell8.setCellValue(brf59C.getR70_investment() == null ? 0 : brf59C.getR70_investment().intValue());
			}
			Cell R70cell9 = R70row.getCell(11);
			if (R70cell9 != null) {
				R70cell9.setCellValue(brf59C.getR70_nbfi1() == null ? 0 : brf59C.getR70_nbfi1().intValue());
			}
			Cell R70cell10 = R70row.getCell(12);
			if (R70cell10 != null) {
				R70cell10.setCellValue(brf59C.getR70_interbank1() == null ? 0 : brf59C.getR70_interbank1().intValue());
			}
			Cell R70cell11 = R70row.getCell(13);
			if (R70cell11 != null) {
				R70cell11.setCellValue(brf59C.getR70_gov1() == null ? 0 : brf59C.getR70_gov1().intValue());
			}
			Cell R70cell12 = R70row.getCell(14);
			if (R70cell12 != null) {
				R70cell12.setCellValue(brf59C.getR70_corporate1() == null ? 0 : brf59C.getR70_corporate1().intValue());
			}
			Cell R70cell13 = R70row.getCell(15);
			if (R70cell13 != null) {
				R70cell13.setCellValue(brf59C.getR70_gre1() == null ? 0 : brf59C.getR70_gre1().intValue());
			}
			Cell R70cell14 = R70row.getCell(16);
			if (R70cell14 != null) {
				R70cell14.setCellValue(brf59C.getR70_trade1() == null ? 0 : brf59C.getR70_trade1().intValue());
			}
			Cell R70cell15 = R70row.getCell(17);
			if (R70cell15 != null) {
				R70cell15.setCellValue(
						brf59C.getR70_individuals1() == null ? 0 : brf59C.getR70_individuals1().intValue());
			}
			Cell R70cell16 = R70row.getCell(18);
			if (R70cell16 != null) {
				R70cell16
						.setCellValue(brf59C.getR70_investment1() == null ? 0 : brf59C.getR70_investment1().intValue());
			}
			Cell R70cell17 = R70row.getCell(19);
			if (R70cell17 != null) {
				R70cell17.setCellValue(brf59C.getR70_zer0() == null ? 0 : brf59C.getR70_zer0().intValue());
			}
			Cell R70cell18 = R70row.getCell(20);
			if (R70cell18 != null) {
				R70cell18.setCellValue(brf59C.getR70_three() == null ? 0 : brf59C.getR70_three().intValue());
			}
			Cell R70cell19 = R70row.getCell(21);
			if (R70cell19 != null) {
				R70cell19.setCellValue(brf59C.getR70_six() == null ? 0 : brf59C.getR70_six().intValue());
			}
			Cell R70cell20 = R70row.getCell(22);
			if (R70cell20 != null) {
				R70cell20.setCellValue(brf59C.getR70_oneyear() == null ? 0 : brf59C.getR70_oneyear().intValue());
			}
			Cell R70cell21 = R70row.getCell(23);
			if (R70cell21 != null) {
				R70cell21.setCellValue(brf59C.getR70_foreign() == null ? 0 : brf59C.getR70_foreign().intValue());
			}
			Cell R70cell22 = R70row.getCell(24);
			if (R70cell22 != null) {
				R70cell22.setCellValue(brf59C.getR70_banks() == null ? 0 : brf59C.getR70_banks().intValue());
			}
			Cell R70cell23 = R70row.getCell(25);
			if (R70cell23 != null) {
				R70cell23.setCellValue(brf59C.getR70_gov2() == null ? 0 : brf59C.getR70_gov2().intValue());
			}
			Cell R70cell24 = R70row.getCell(26);
			if (R70cell24 != null) {
				R70cell24.setCellValue(brf59C.getR70_other() == null ? 0 : brf59C.getR70_other().intValue());
			}
			Cell R70cell25 = R70row.getCell(27);
			if (R70cell25 != null) {
				R70cell25.setCellValue(brf59C.getR70_banks1() == null ? 0 : brf59C.getR70_banks1().intValue());
			}
			Cell R70cell26 = R70row.getCell(28);
			if (R70cell26 != null) {
				R70cell26.setCellValue(
						brf59C.getR70_individuals2() == null ? 0 : brf59C.getR70_individuals2().intValue());
			}
			Cell R70cell27 = R70row.getCell(29);
			if (R70cell27 != null) {
				R70cell27.setCellValue(brf59C.getR70_other1() == null ? 0 : brf59C.getR70_other1().intValue());
			}
			Cell R70cell28 = R70row.getCell(30);
			if (R70cell28 != null) {
				R70cell28.setCellValue(brf59C.getR70_banks2() == null ? 0 : brf59C.getR70_banks2().intValue());
			}
			Cell R70cell29 = R70row.getCell(31);
			if (R70cell29 != null) {
				R70cell29.setCellValue(brf59C.getR70_gov3() == null ? 0 : brf59C.getR70_gov3().intValue());
			}
			Cell R70cell30 = R70row.getCell(32);
			if (R70cell30 != null) {
				R70cell30.setCellValue(brf59C.getR70_others2() == null ? 0 : brf59C.getR70_others2().intValue());
			}
			Cell R70cell31 = R70row.getCell(33);
			if (R70cell31 != null) {
				R70cell31.setCellValue(brf59C.getR70_banks3() == null ? 0 : brf59C.getR70_banks3().intValue());
			}
			Cell R70cell32 = R70row.getCell(34);
			if (R70cell32 != null) {
				R70cell32.setCellValue(brf59C.getR70_gov4() == null ? 0 : brf59C.getR70_gov4().intValue());
			}
			Cell R70cell33 = R70row.getCell(35);
			if (R70cell33 != null) {
				R70cell33.setCellValue(brf59C.getR70_others3() == null ? 0 : brf59C.getR70_others3().intValue());
			}
			Cell R70cell34 = R70row.getCell(36);
			if (R70cell34 != null) {
				R70cell34.setCellValue(brf59C.getR70_foreign1() == null ? 0 : brf59C.getR70_foreign1().intValue());
			}
			Cell R70cell35 = R70row.getCell(37);
			if (R70cell35 != null) {
				R70cell35.setCellValue(brf59C.getR70_guarantees() == null ? 0 : brf59C.getR70_guarantees().intValue());
			}
			Cell R70cell36 = R70row.getCell(38);
			if (R70cell36 != null) {
				R70cell36.setCellValue(brf59C.getR70_nbfi2() == null ? 0 : brf59C.getR70_nbfi2().intValue());
			}
			Cell R70cell37 = R70row.getCell(39);
			if (R70cell37 != null) {
				R70cell37.setCellValue(brf59C.getR70_interbank2() == null ? 0 : brf59C.getR70_interbank2().intValue());
			}
			Cell R70cell38 = R70row.getCell(40);
			if (R70cell38 != null) {
				R70cell38.setCellValue(brf59C.getR70_gov5() == null ? 0 : brf59C.getR70_gov5().intValue());
			}
			Cell R70cell39 = R70row.getCell(41);
			if (R70cell39 != null) {
				R70cell39.setCellValue(brf59C.getR70_corporate2() == null ? 0 : brf59C.getR70_corporate2().intValue());
			}
			Cell R70cell40 = R70row.getCell(42);
			if (R70cell40 != null) {
				R70cell40.setCellValue(brf59C.getR70_gre2() == null ? 0 : brf59C.getR70_gre2().intValue());
			}
			Cell R70cell41 = R70row.getCell(43);
			if (R70cell41 != null) {
				R70cell41.setCellValue(
						brf59C.getR70_individuals3() == null ? 0 : brf59C.getR70_individuals3().intValue());
			}
			Cell R70cell42 = R70row.getCell(44);
			if (R70cell42 != null) {
				R70cell42.setCellValue(brf59C.getR70_zero1() == null ? 0 : brf59C.getR70_zero1().intValue());
			}
			Cell R70cell43 = R70row.getCell(45);
			if (R70cell43 != null) {
				R70cell43.setCellValue(brf59C.getR70_three1() == null ? 0 : brf59C.getR70_three1().intValue());
			}
			Cell R70cell44 = R70row.getCell(46);
			if (R70cell44 != null) {
				R70cell44.setCellValue(brf59C.getR70_six1() == null ? 0 : brf59C.getR70_six1().intValue());
			}
			Cell R70cell45 = R70row.getCell(47);
			if (R70cell45 != null) {
				R70cell45.setCellValue(brf59C.getR70_oneyear1() == null ? 0 : brf59C.getR70_oneyear1().intValue());
			}
			Cell R70cell46 = R70row.getCell(48);
			if (R70cell46 != null) {
				R70cell46.setCellValue(brf59C.getR70_empty() == null ? "" : brf59C.getR70_empty().toString());
			}
			Row R72row = sheet.getRow(89);
			Cell R72cell1 = R72row.getCell(3);
			if (R72cell1 != null) {
				R72cell1.setCellValue(brf59C.getR72_nbfi() == null ? 0 : brf59C.getR72_nbfi().intValue());
			}

			Cell R72cell2 = R72row.getCell(4);
			if (R72cell2 != null) {
				R72cell2.setCellValue(brf59C.getR72_interbank() == null ? 0 : brf59C.getR72_interbank().intValue());
			}
			Cell R72cell3 = R72row.getCell(5);
			if (R72cell3 != null) {
				R72cell3.setCellValue(brf59C.getR72_gov() == null ? 0 : brf59C.getR72_gov().intValue());
			}
			Cell R72cell4 = R72row.getCell(6);
			if (R72cell4 != null) {
				R72cell4.setCellValue(brf59C.getR72_corporate() == null ? 0 : brf59C.getR72_corporate().intValue());
			}
			Cell R72cell5 = R72row.getCell(7);
			if (R72cell5 != null) {
				R72cell5.setCellValue(brf59C.getR72_gre() == null ? 0 : brf59C.getR72_gre().intValue());
			}
			Cell R72cell6 = R72row.getCell(8);
			if (R72cell6 != null) {
				R72cell6.setCellValue(brf59C.getR72_trade() == null ? 0 : brf59C.getR72_trade().intValue());
			}
			Cell R72cell7 = R72row.getCell(9);
			if (R72cell7 != null) {
				R72cell7.setCellValue(brf59C.getR72_individuals() == null ? 0 : brf59C.getR72_individuals().intValue());
			}
			Cell R72cell8 = R72row.getCell(10);
			if (R72cell8 != null) {
				R72cell8.setCellValue(brf59C.getR72_investment() == null ? 0 : brf59C.getR72_investment().intValue());
			}
			Cell R72cell9 = R72row.getCell(11);
			if (R72cell9 != null) {
				R72cell9.setCellValue(brf59C.getR72_nbfi1() == null ? 0 : brf59C.getR72_nbfi1().intValue());
			}
			Cell R72cell10 = R72row.getCell(12);
			if (R72cell10 != null) {
				R72cell10.setCellValue(brf59C.getR72_interbank1() == null ? 0 : brf59C.getR72_interbank1().intValue());
			}
			Cell R72cell11 = R72row.getCell(13);
			if (R72cell11 != null) {
				R72cell11.setCellValue(brf59C.getR72_gov1() == null ? 0 : brf59C.getR72_gov1().intValue());
			}
			Cell R72cell12 = R72row.getCell(14);
			if (R72cell12 != null) {
				R72cell12.setCellValue(brf59C.getR72_corporate1() == null ? 0 : brf59C.getR72_corporate1().intValue());
			}
			Cell R72cell13 = R72row.getCell(15);
			if (R72cell13 != null) {
				R72cell13.setCellValue(brf59C.getR72_gre1() == null ? 0 : brf59C.getR72_gre1().intValue());
			}
			Cell R72cell14 = R72row.getCell(16);
			if (R72cell14 != null) {
				R72cell14.setCellValue(brf59C.getR72_trade1() == null ? 0 : brf59C.getR72_trade1().intValue());
			}
			Cell R72cell15 = R72row.getCell(17);
			if (R72cell15 != null) {
				R72cell15.setCellValue(
						brf59C.getR72_individuals1() == null ? 0 : brf59C.getR72_individuals1().intValue());
			}
			Cell R72cell16 = R72row.getCell(18);
			if (R72cell16 != null) {
				R72cell16
						.setCellValue(brf59C.getR72_investment1() == null ? 0 : brf59C.getR72_investment1().intValue());
			}
			Cell R72cell17 = R72row.getCell(19);
			if (R72cell17 != null) {
				R72cell17.setCellValue(brf59C.getR72_zer0() == null ? 0 : brf59C.getR72_zer0().intValue());
			}
			Cell R72cell18 = R72row.getCell(20);
			if (R72cell18 != null) {
				R72cell18.setCellValue(brf59C.getR72_three() == null ? 0 : brf59C.getR72_three().intValue());
			}
			Cell R72cell19 = R72row.getCell(21);
			if (R72cell19 != null) {
				R72cell19.setCellValue(brf59C.getR72_six() == null ? 0 : brf59C.getR72_six().intValue());
			}
			Cell R72cell20 = R72row.getCell(22);
			if (R72cell20 != null) {
				R72cell20.setCellValue(brf59C.getR72_oneyear() == null ? 0 : brf59C.getR72_oneyear().intValue());
			}
			Cell R72cell21 = R72row.getCell(23);
			if (R72cell21 != null) {
				R72cell21.setCellValue(brf59C.getR72_foreign() == null ? 0 : brf59C.getR72_foreign().intValue());
			}
			Cell R72cell22 = R72row.getCell(24);
			if (R72cell22 != null) {
				R72cell22.setCellValue(brf59C.getR72_banks() == null ? 0 : brf59C.getR72_banks().intValue());
			}
			Cell R72cell23 = R72row.getCell(25);
			if (R72cell23 != null) {
				R72cell23.setCellValue(brf59C.getR72_gov2() == null ? 0 : brf59C.getR72_gov2().intValue());
			}
			Cell R72cell24 = R72row.getCell(26);
			if (R72cell24 != null) {
				R72cell24.setCellValue(brf59C.getR72_other() == null ? 0 : brf59C.getR72_other().intValue());
			}
			Cell R72cell25 = R72row.getCell(27);
			if (R72cell25 != null) {
				R72cell25.setCellValue(brf59C.getR72_banks1() == null ? 0 : brf59C.getR72_banks1().intValue());
			}
			Cell R72cell26 = R72row.getCell(28);
			if (R72cell26 != null) {
				R72cell26.setCellValue(
						brf59C.getR72_individuals2() == null ? 0 : brf59C.getR72_individuals2().intValue());
			}
			Cell R72cell27 = R72row.getCell(29);
			if (R72cell27 != null) {
				R72cell27.setCellValue(brf59C.getR72_other1() == null ? 0 : brf59C.getR72_other1().intValue());
			}
			Cell R72cell28 = R72row.getCell(30);
			if (R72cell28 != null) {
				R72cell28.setCellValue(brf59C.getR72_banks2() == null ? 0 : brf59C.getR72_banks2().intValue());
			}
			Cell R72cell29 = R72row.getCell(31);
			if (R72cell29 != null) {
				R72cell29.setCellValue(brf59C.getR72_gov3() == null ? 0 : brf59C.getR72_gov3().intValue());
			}
			Cell R72cell30 = R72row.getCell(32);
			if (R72cell30 != null) {
				R72cell30.setCellValue(brf59C.getR72_others2() == null ? 0 : brf59C.getR72_others2().intValue());
			}
			Cell R72cell31 = R72row.getCell(33);
			if (R72cell31 != null) {
				R72cell31.setCellValue(brf59C.getR72_banks3() == null ? 0 : brf59C.getR72_banks3().intValue());
			}
			Cell R72cell32 = R72row.getCell(34);
			if (R72cell32 != null) {
				R72cell32.setCellValue(brf59C.getR72_gov4() == null ? 0 : brf59C.getR72_gov4().intValue());
			}
			Cell R72cell33 = R72row.getCell(35);
			if (R72cell33 != null) {
				R72cell33.setCellValue(brf59C.getR72_others3() == null ? 0 : brf59C.getR72_others3().intValue());
			}
			Cell R72cell34 = R72row.getCell(36);
			if (R72cell34 != null) {
				R72cell34.setCellValue(brf59C.getR72_foreign1() == null ? 0 : brf59C.getR72_foreign1().intValue());
			}
			Cell R72cell35 = R72row.getCell(37);
			if (R72cell35 != null) {
				R72cell35.setCellValue(brf59C.getR72_guarantees() == null ? 0 : brf59C.getR72_guarantees().intValue());
			}
			Cell R72cell36 = R72row.getCell(38);
			if (R72cell36 != null) {
				R72cell36.setCellValue(brf59C.getR72_nbfi2() == null ? 0 : brf59C.getR72_nbfi2().intValue());
			}
			Cell R72cell37 = R72row.getCell(39);
			if (R72cell37 != null) {
				R72cell37.setCellValue(brf59C.getR72_interbank2() == null ? 0 : brf59C.getR72_interbank2().intValue());
			}
			Cell R72cell38 = R72row.getCell(40);
			if (R72cell38 != null) {
				R72cell38.setCellValue(brf59C.getR72_gov5() == null ? 0 : brf59C.getR72_gov5().intValue());
			}
			Cell R72cell39 = R72row.getCell(41);
			if (R72cell39 != null) {
				R72cell39.setCellValue(brf59C.getR72_corporate2() == null ? 0 : brf59C.getR72_corporate2().intValue());
			}
			Cell R72cell40 = R72row.getCell(42);
			if (R72cell40 != null) {
				R72cell40.setCellValue(brf59C.getR72_gre2() == null ? 0 : brf59C.getR72_gre2().intValue());
			}
			Cell R72cell41 = R72row.getCell(43);
			if (R72cell41 != null) {
				R72cell41.setCellValue(
						brf59C.getR72_individuals3() == null ? 0 : brf59C.getR72_individuals3().intValue());
			}
			Cell R72cell42 = R72row.getCell(44);
			if (R72cell42 != null) {
				R72cell42.setCellValue(brf59C.getR72_zero1() == null ? 0 : brf59C.getR72_zero1().intValue());
			}
			Cell R72cell43 = R72row.getCell(45);
			if (R72cell43 != null) {
				R72cell43.setCellValue(brf59C.getR72_three1() == null ? 0 : brf59C.getR72_three1().intValue());
			}
			Cell R72cell44 = R72row.getCell(46);
			if (R72cell44 != null) {
				R72cell44.setCellValue(brf59C.getR72_six1() == null ? 0 : brf59C.getR72_six1().intValue());
			}
			Cell R72cell45 = R72row.getCell(47);
			if (R72cell45 != null) {
				R72cell45.setCellValue(brf59C.getR72_oneyear1() == null ? 0 : brf59C.getR72_oneyear1().intValue());
			}
			Cell R72cell46 = R72row.getCell(48);
			if (R72cell46 != null) {
				R72cell46.setCellValue(brf59C.getR72_empty() == null ? "" : brf59C.getR72_empty().toString());
			}
			Row R73row = sheet.getRow(90);
			Cell R73cell1 = R73row.getCell(3);
			if (R73cell1 != null) {
				R73cell1.setCellValue(brf59C.getR73_nbfi() == null ? 0 : brf59C.getR73_nbfi().intValue());
			}

			Cell R73cell2 = R73row.getCell(4);
			if (R73cell2 != null) {
				R73cell2.setCellValue(brf59C.getR73_interbank() == null ? 0 : brf59C.getR73_interbank().intValue());
			}
			Cell R73cell3 = R73row.getCell(5);
			if (R73cell3 != null) {
				R73cell3.setCellValue(brf59C.getR73_gov() == null ? 0 : brf59C.getR73_gov().intValue());
			}
			Cell R73cell4 = R73row.getCell(6);
			if (R73cell4 != null) {
				R73cell4.setCellValue(brf59C.getR73_corporate() == null ? 0 : brf59C.getR73_corporate().intValue());
			}
			Cell R73cell5 = R73row.getCell(7);
			if (R73cell5 != null) {
				R73cell5.setCellValue(brf59C.getR73_gre() == null ? 0 : brf59C.getR73_gre().intValue());
			}
			Cell R73cell6 = R73row.getCell(8);
			if (R73cell6 != null) {
				R73cell6.setCellValue(brf59C.getR73_trade() == null ? 0 : brf59C.getR73_trade().intValue());
			}
			Cell R73cell7 = R73row.getCell(9);
			if (R73cell7 != null) {
				R73cell7.setCellValue(brf59C.getR73_individuals() == null ? 0 : brf59C.getR73_individuals().intValue());
			}
			Cell R73cell8 = R73row.getCell(10);
			if (R73cell8 != null) {
				R73cell8.setCellValue(brf59C.getR73_investment() == null ? 0 : brf59C.getR73_investment().intValue());
			}
			Cell R73cell9 = R73row.getCell(11);
			if (R73cell9 != null) {
				R73cell9.setCellValue(brf59C.getR73_nbfi1() == null ? 0 : brf59C.getR73_nbfi1().intValue());
			}
			Cell R73cell10 = R73row.getCell(12);
			if (R73cell10 != null) {
				R73cell10.setCellValue(brf59C.getR73_interbank1() == null ? 0 : brf59C.getR73_interbank1().intValue());
			}
			Cell R73cell11 = R73row.getCell(13);
			if (R73cell11 != null) {
				R73cell11.setCellValue(brf59C.getR73_gov1() == null ? 0 : brf59C.getR73_gov1().intValue());
			}
			Cell R73cell12 = R73row.getCell(14);
			if (R73cell12 != null) {
				R73cell12.setCellValue(brf59C.getR73_corporate1() == null ? 0 : brf59C.getR73_corporate1().intValue());
			}
			Cell R73cell13 = R73row.getCell(15);
			if (R73cell13 != null) {
				R73cell13.setCellValue(brf59C.getR73_gre1() == null ? 0 : brf59C.getR73_gre1().intValue());
			}
			Cell R73cell14 = R73row.getCell(16);
			if (R73cell14 != null) {
				R73cell14.setCellValue(brf59C.getR73_trade1() == null ? 0 : brf59C.getR73_trade1().intValue());
			}
			Cell R73cell15 = R73row.getCell(17);
			if (R73cell15 != null) {
				R73cell15.setCellValue(
						brf59C.getR73_individuals1() == null ? 0 : brf59C.getR73_individuals1().intValue());
			}
			Cell R73cell16 = R73row.getCell(18);
			if (R73cell16 != null) {
				R73cell16
						.setCellValue(brf59C.getR73_investment1() == null ? 0 : brf59C.getR73_investment1().intValue());
			}
			Cell R73cell17 = R73row.getCell(19);
			if (R73cell17 != null) {
				R73cell17.setCellValue(brf59C.getR73_zer0() == null ? 0 : brf59C.getR73_zer0().intValue());
			}
			Cell R73cell18 = R73row.getCell(20);
			if (R73cell18 != null) {
				R73cell18.setCellValue(brf59C.getR73_three() == null ? 0 : brf59C.getR73_three().intValue());
			}
			Cell R73cell19 = R73row.getCell(21);
			if (R73cell19 != null) {
				R73cell19.setCellValue(brf59C.getR73_six() == null ? 0 : brf59C.getR73_six().intValue());
			}
			Cell R73cell20 = R73row.getCell(22);
			if (R73cell20 != null) {
				R73cell20.setCellValue(brf59C.getR73_oneyear() == null ? 0 : brf59C.getR73_oneyear().intValue());
			}
			Cell R73cell21 = R73row.getCell(23);
			if (R73cell21 != null) {
				R73cell21.setCellValue(brf59C.getR73_foreign() == null ? 0 : brf59C.getR73_foreign().intValue());
			}
			Cell R73cell22 = R73row.getCell(24);
			if (R73cell22 != null) {
				R73cell22.setCellValue(brf59C.getR73_banks() == null ? 0 : brf59C.getR73_banks().intValue());
			}
			Cell R73cell23 = R73row.getCell(25);
			if (R73cell23 != null) {
				R73cell23.setCellValue(brf59C.getR73_gov2() == null ? 0 : brf59C.getR73_gov2().intValue());
			}
			Cell R73cell24 = R73row.getCell(26);
			if (R73cell24 != null) {
				R73cell24.setCellValue(brf59C.getR73_other() == null ? 0 : brf59C.getR73_other().intValue());
			}
			Cell R73cell25 = R73row.getCell(27);
			if (R73cell25 != null) {
				R73cell25.setCellValue(brf59C.getR73_banks1() == null ? 0 : brf59C.getR73_banks1().intValue());
			}
			Cell R73cell26 = R73row.getCell(28);
			if (R73cell26 != null) {
				R73cell26.setCellValue(
						brf59C.getR73_individuals2() == null ? 0 : brf59C.getR73_individuals2().intValue());
			}
			Cell R73cell27 = R73row.getCell(29);
			if (R73cell27 != null) {
				R73cell27.setCellValue(brf59C.getR73_other1() == null ? 0 : brf59C.getR73_other1().intValue());
			}
			Cell R73cell28 = R73row.getCell(30);
			if (R73cell28 != null) {
				R73cell28.setCellValue(brf59C.getR73_banks2() == null ? 0 : brf59C.getR73_banks2().intValue());
			}
			Cell R73cell29 = R73row.getCell(31);
			if (R73cell29 != null) {
				R73cell29.setCellValue(brf59C.getR73_gov3() == null ? 0 : brf59C.getR73_gov3().intValue());
			}
			Cell R73cell30 = R73row.getCell(32);
			if (R73cell30 != null) {
				R73cell30.setCellValue(brf59C.getR73_others2() == null ? 0 : brf59C.getR73_others2().intValue());
			}
			Cell R73cell31 = R73row.getCell(33);
			if (R73cell31 != null) {
				R73cell31.setCellValue(brf59C.getR73_banks3() == null ? 0 : brf59C.getR73_banks3().intValue());
			}
			Cell R73cell32 = R73row.getCell(34);
			if (R73cell32 != null) {
				R73cell32.setCellValue(brf59C.getR73_gov4() == null ? 0 : brf59C.getR73_gov4().intValue());
			}
			Cell R73cell33 = R73row.getCell(35);
			if (R73cell33 != null) {
				R73cell33.setCellValue(brf59C.getR73_others3() == null ? 0 : brf59C.getR73_others3().intValue());
			}
			Cell R73cell34 = R73row.getCell(36);
			if (R73cell34 != null) {
				R73cell34.setCellValue(brf59C.getR73_foreign1() == null ? 0 : brf59C.getR73_foreign1().intValue());
			}
			Cell R73cell35 = R73row.getCell(37);
			if (R73cell35 != null) {
				R73cell35.setCellValue(brf59C.getR73_guarantees() == null ? 0 : brf59C.getR73_guarantees().intValue());
			}
			Cell R73cell36 = R73row.getCell(38);
			if (R73cell36 != null) {
				R73cell36.setCellValue(brf59C.getR73_nbfi2() == null ? 0 : brf59C.getR73_nbfi2().intValue());
			}
			Cell R73cell37 = R73row.getCell(39);
			if (R73cell37 != null) {
				R73cell37.setCellValue(brf59C.getR73_interbank2() == null ? 0 : brf59C.getR73_interbank2().intValue());
			}
			Cell R73cell38 = R73row.getCell(40);
			if (R73cell38 != null) {
				R73cell38.setCellValue(brf59C.getR73_gov5() == null ? 0 : brf59C.getR73_gov5().intValue());
			}
			Cell R73cell39 = R73row.getCell(41);
			if (R73cell39 != null) {
				R73cell39.setCellValue(brf59C.getR73_corporate2() == null ? 0 : brf59C.getR73_corporate2().intValue());
			}
			Cell R73cell40 = R73row.getCell(42);
			if (R73cell40 != null) {
				R73cell40.setCellValue(brf59C.getR73_gre2() == null ? 0 : brf59C.getR73_gre2().intValue());
			}
			Cell R73cell41 = R73row.getCell(43);
			if (R73cell41 != null) {
				R73cell41.setCellValue(
						brf59C.getR73_individuals3() == null ? 0 : brf59C.getR73_individuals3().intValue());
			}
			Cell R73cell42 = R73row.getCell(44);
			if (R73cell42 != null) {
				R73cell42.setCellValue(brf59C.getR73_zero1() == null ? 0 : brf59C.getR73_zero1().intValue());
			}
			Cell R73cell43 = R73row.getCell(45);
			if (R73cell43 != null) {
				R73cell43.setCellValue(brf59C.getR73_three1() == null ? 0 : brf59C.getR73_three1().intValue());
			}
			Cell R73cell44 = R73row.getCell(46);
			if (R73cell44 != null) {
				R73cell44.setCellValue(brf59C.getR73_six1() == null ? 0 : brf59C.getR73_six1().intValue());
			}
			Cell R73cell45 = R73row.getCell(47);
			if (R73cell45 != null) {
				R73cell45.setCellValue(brf59C.getR73_oneyear1() == null ? 0 : brf59C.getR73_oneyear1().intValue());
			}
			Cell R73cell46 = R73row.getCell(48);
			if (R73cell46 != null) {
				R73cell46.setCellValue(brf59C.getR73_empty() == null ? "" : brf59C.getR73_empty().toString());
			}
			Row R74row = sheet.getRow(91);
			Cell R74cell1 = R74row.getCell(3);
			if (R74cell1 != null) {
				R74cell1.setCellValue(brf59C.getR74_nbfi() == null ? 0 : brf59C.getR74_nbfi().intValue());
			}

			Cell R74cell2 = R74row.getCell(4);
			if (R74cell2 != null) {
				R74cell2.setCellValue(brf59C.getR74_interbank() == null ? 0 : brf59C.getR74_interbank().intValue());
			}
			Cell R74cell3 = R74row.getCell(5);
			if (R74cell3 != null) {
				R74cell3.setCellValue(brf59C.getR74_gov() == null ? 0 : brf59C.getR74_gov().intValue());
			}
			Cell R74cell4 = R74row.getCell(6);
			if (R74cell4 != null) {
				R74cell4.setCellValue(brf59C.getR74_corporate() == null ? 0 : brf59C.getR74_corporate().intValue());
			}
			Cell R74cell5 = R74row.getCell(7);
			if (R74cell5 != null) {
				R74cell5.setCellValue(brf59C.getR74_gre() == null ? 0 : brf59C.getR74_gre().intValue());
			}
			Cell R74cell6 = R74row.getCell(8);
			if (R74cell6 != null) {
				R74cell6.setCellValue(brf59C.getR74_trade() == null ? 0 : brf59C.getR74_trade().intValue());
			}
			Cell R74cell7 = R74row.getCell(9);
			if (R74cell7 != null) {
				R74cell7.setCellValue(brf59C.getR74_individuals() == null ? 0 : brf59C.getR74_individuals().intValue());
			}
			Cell R74cell8 = R74row.getCell(10);
			if (R74cell8 != null) {
				R74cell8.setCellValue(brf59C.getR74_investment() == null ? 0 : brf59C.getR74_investment().intValue());
			}
			Cell R74cell9 = R74row.getCell(11);
			if (R74cell9 != null) {
				R74cell9.setCellValue(brf59C.getR74_nbfi1() == null ? 0 : brf59C.getR74_nbfi1().intValue());
			}
			Cell R74cell10 = R74row.getCell(12);
			if (R74cell10 != null) {
				R74cell10.setCellValue(brf59C.getR74_interbank1() == null ? 0 : brf59C.getR74_interbank1().intValue());
			}
			Cell R74cell11 = R74row.getCell(13);
			if (R74cell11 != null) {
				R74cell11.setCellValue(brf59C.getR74_gov1() == null ? 0 : brf59C.getR74_gov1().intValue());
			}
			Cell R74cell12 = R74row.getCell(14);
			if (R74cell12 != null) {
				R74cell12.setCellValue(brf59C.getR74_corporate1() == null ? 0 : brf59C.getR74_corporate1().intValue());
			}
			Cell R74cell13 = R74row.getCell(15);
			if (R74cell13 != null) {
				R74cell13.setCellValue(brf59C.getR74_gre1() == null ? 0 : brf59C.getR74_gre1().intValue());
			}
			Cell R74cell14 = R74row.getCell(16);
			if (R74cell14 != null) {
				R74cell14.setCellValue(brf59C.getR74_trade1() == null ? 0 : brf59C.getR74_trade1().intValue());
			}
			Cell R74cell15 = R74row.getCell(17);
			if (R74cell15 != null) {
				R74cell15.setCellValue(
						brf59C.getR74_individuals1() == null ? 0 : brf59C.getR74_individuals1().intValue());
			}
			Cell R74cell16 = R74row.getCell(18);
			if (R74cell16 != null) {
				R74cell16
						.setCellValue(brf59C.getR74_investment1() == null ? 0 : brf59C.getR74_investment1().intValue());
			}
			Cell R74cell17 = R74row.getCell(19);
			if (R74cell17 != null) {
				R74cell17.setCellValue(brf59C.getR74_zer0() == null ? 0 : brf59C.getR74_zer0().intValue());
			}
			Cell R74cell18 = R74row.getCell(20);
			if (R74cell18 != null) {
				R74cell18.setCellValue(brf59C.getR74_three() == null ? 0 : brf59C.getR74_three().intValue());
			}
			Cell R74cell19 = R74row.getCell(21);
			if (R74cell19 != null) {
				R74cell19.setCellValue(brf59C.getR74_six() == null ? 0 : brf59C.getR74_six().intValue());
			}
			Cell R74cell20 = R74row.getCell(22);
			if (R74cell20 != null) {
				R74cell20.setCellValue(brf59C.getR74_oneyear() == null ? 0 : brf59C.getR74_oneyear().intValue());
			}
			Cell R74cell21 = R74row.getCell(23);
			if (R74cell21 != null) {
				R74cell21.setCellValue(brf59C.getR74_foreign() == null ? 0 : brf59C.getR74_foreign().intValue());
			}
			Cell R74cell22 = R74row.getCell(24);
			if (R74cell22 != null) {
				R74cell22.setCellValue(brf59C.getR74_banks() == null ? 0 : brf59C.getR74_banks().intValue());
			}
			Cell R74cell23 = R74row.getCell(25);
			if (R74cell23 != null) {
				R74cell23.setCellValue(brf59C.getR74_gov2() == null ? 0 : brf59C.getR74_gov2().intValue());
			}
			Cell R74cell24 = R74row.getCell(26);
			if (R74cell24 != null) {
				R74cell24.setCellValue(brf59C.getR74_other() == null ? 0 : brf59C.getR74_other().intValue());
			}
			Cell R74cell25 = R74row.getCell(27);
			if (R74cell25 != null) {
				R74cell25.setCellValue(brf59C.getR74_banks1() == null ? 0 : brf59C.getR74_banks1().intValue());
			}
			Cell R74cell26 = R74row.getCell(28);
			if (R74cell26 != null) {
				R74cell26.setCellValue(
						brf59C.getR74_individuals2() == null ? 0 : brf59C.getR74_individuals2().intValue());
			}
			Cell R74cell27 = R74row.getCell(29);
			if (R74cell27 != null) {
				R74cell27.setCellValue(brf59C.getR74_other1() == null ? 0 : brf59C.getR74_other1().intValue());
			}
			Cell R74cell28 = R74row.getCell(30);
			if (R74cell28 != null) {
				R74cell28.setCellValue(brf59C.getR74_banks2() == null ? 0 : brf59C.getR74_banks2().intValue());
			}
			Cell R74cell29 = R74row.getCell(31);
			if (R74cell29 != null) {
				R74cell29.setCellValue(brf59C.getR74_gov3() == null ? 0 : brf59C.getR74_gov3().intValue());
			}
			Cell R74cell30 = R74row.getCell(32);
			if (R74cell30 != null) {
				R74cell30.setCellValue(brf59C.getR74_others2() == null ? 0 : brf59C.getR74_others2().intValue());
			}
			Cell R74cell31 = R74row.getCell(33);
			if (R74cell31 != null) {
				R74cell31.setCellValue(brf59C.getR74_banks3() == null ? 0 : brf59C.getR74_banks3().intValue());
			}
			Cell R74cell32 = R74row.getCell(34);
			if (R74cell32 != null) {
				R74cell32.setCellValue(brf59C.getR74_gov4() == null ? 0 : brf59C.getR74_gov4().intValue());
			}
			Cell R74cell33 = R74row.getCell(35);
			if (R74cell33 != null) {
				R74cell33.setCellValue(brf59C.getR74_others3() == null ? 0 : brf59C.getR74_others3().intValue());
			}
			Cell R74cell34 = R74row.getCell(36);
			if (R74cell34 != null) {
				R74cell34.setCellValue(brf59C.getR74_foreign1() == null ? 0 : brf59C.getR74_foreign1().intValue());
			}
			Cell R74cell35 = R74row.getCell(37);
			if (R74cell35 != null) {
				R74cell35.setCellValue(brf59C.getR74_guarantees() == null ? 0 : brf59C.getR74_guarantees().intValue());
			}
			Cell R74cell36 = R74row.getCell(38);
			if (R74cell36 != null) {
				R74cell36.setCellValue(brf59C.getR74_nbfi2() == null ? 0 : brf59C.getR74_nbfi2().intValue());
			}
			Cell R74cell37 = R74row.getCell(39);
			if (R74cell37 != null) {
				R74cell37.setCellValue(brf59C.getR74_interbank2() == null ? 0 : brf59C.getR74_interbank2().intValue());
			}
			Cell R74cell38 = R74row.getCell(40);
			if (R74cell38 != null) {
				R74cell38.setCellValue(brf59C.getR74_gov5() == null ? 0 : brf59C.getR74_gov5().intValue());
			}
			Cell R74cell39 = R74row.getCell(41);
			if (R74cell39 != null) {
				R74cell39.setCellValue(brf59C.getR74_corporate2() == null ? 0 : brf59C.getR74_corporate2().intValue());
			}
			Cell R74cell40 = R74row.getCell(42);
			if (R74cell40 != null) {
				R74cell40.setCellValue(brf59C.getR74_gre2() == null ? 0 : brf59C.getR74_gre2().intValue());
			}
			Cell R74cell41 = R74row.getCell(43);
			if (R74cell41 != null) {
				R74cell41.setCellValue(
						brf59C.getR74_individuals3() == null ? 0 : brf59C.getR74_individuals3().intValue());
			}
			Cell R74cell42 = R74row.getCell(44);
			if (R74cell42 != null) {
				R74cell42.setCellValue(brf59C.getR74_zero1() == null ? 0 : brf59C.getR74_zero1().intValue());
			}
			Cell R74cell43 = R74row.getCell(45);
			if (R74cell43 != null) {
				R74cell43.setCellValue(brf59C.getR74_three1() == null ? 0 : brf59C.getR74_three1().intValue());
			}
			Cell R74cell44 = R74row.getCell(46);
			if (R74cell44 != null) {
				R74cell44.setCellValue(brf59C.getR74_six1() == null ? 0 : brf59C.getR74_six1().intValue());
			}
			Cell R74cell45 = R74row.getCell(47);
			if (R74cell45 != null) {
				R74cell45.setCellValue(brf59C.getR74_oneyear1() == null ? 0 : brf59C.getR74_oneyear1().intValue());
			}
			Cell R74cell46 = R74row.getCell(48);
			if (R74cell46 != null) {
				R74cell46.setCellValue(brf59C.getR74_empty() == null ? "" : brf59C.getR74_empty().toString());
			}
			Row R75row = sheet.getRow(92);
			Cell R75cell1 = R75row.getCell(3);
			if (R75cell1 != null) {
				R75cell1.setCellValue(brf59C.getR75_nbfi() == null ? 0 : brf59C.getR75_nbfi().intValue());
			}

			Cell R75cell2 = R75row.getCell(4);
			if (R75cell2 != null) {
				R75cell2.setCellValue(brf59C.getR75_interbank() == null ? 0 : brf59C.getR75_interbank().intValue());
			}
			Cell R75cell3 = R75row.getCell(5);
			if (R75cell3 != null) {
				R75cell3.setCellValue(brf59C.getR75_gov() == null ? 0 : brf59C.getR75_gov().intValue());
			}
			Cell R75cell4 = R75row.getCell(6);
			if (R75cell4 != null) {
				R75cell4.setCellValue(brf59C.getR75_corporate() == null ? 0 : brf59C.getR75_corporate().intValue());
			}
			Cell R75cell5 = R75row.getCell(7);
			if (R75cell5 != null) {
				R75cell5.setCellValue(brf59C.getR75_gre() == null ? 0 : brf59C.getR75_gre().intValue());
			}
			Cell R75cell6 = R75row.getCell(8);
			if (R75cell6 != null) {
				R75cell6.setCellValue(brf59C.getR75_trade() == null ? 0 : brf59C.getR75_trade().intValue());
			}
			Cell R75cell7 = R75row.getCell(9);
			if (R75cell7 != null) {
				R75cell7.setCellValue(brf59C.getR75_individuals() == null ? 0 : brf59C.getR75_individuals().intValue());
			}
			Cell R75cell8 = R75row.getCell(10);
			if (R75cell8 != null) {
				R75cell8.setCellValue(brf59C.getR75_investment() == null ? 0 : brf59C.getR75_investment().intValue());
			}
			Cell R75cell9 = R75row.getCell(11);
			if (R75cell9 != null) {
				R75cell9.setCellValue(brf59C.getR75_nbfi1() == null ? 0 : brf59C.getR75_nbfi1().intValue());
			}
			Cell R75cell10 = R75row.getCell(12);
			if (R75cell10 != null) {
				R75cell10.setCellValue(brf59C.getR75_interbank1() == null ? 0 : brf59C.getR75_interbank1().intValue());
			}
			Cell R75cell11 = R75row.getCell(13);
			if (R75cell11 != null) {
				R75cell11.setCellValue(brf59C.getR75_gov1() == null ? 0 : brf59C.getR75_gov1().intValue());
			}
			Cell R75cell12 = R75row.getCell(14);
			if (R75cell12 != null) {
				R75cell12.setCellValue(brf59C.getR75_corporate1() == null ? 0 : brf59C.getR75_corporate1().intValue());
			}
			Cell R75cell13 = R75row.getCell(15);
			if (R75cell13 != null) {
				R75cell13.setCellValue(brf59C.getR75_gre1() == null ? 0 : brf59C.getR75_gre1().intValue());
			}
			Cell R75cell14 = R75row.getCell(16);
			if (R75cell14 != null) {
				R75cell14.setCellValue(brf59C.getR75_trade1() == null ? 0 : brf59C.getR75_trade1().intValue());
			}
			Cell R75cell15 = R75row.getCell(17);
			if (R75cell15 != null) {
				R75cell15.setCellValue(
						brf59C.getR75_individuals1() == null ? 0 : brf59C.getR75_individuals1().intValue());
			}
			Cell R75cell16 = R75row.getCell(18);
			if (R75cell16 != null) {
				R75cell16
						.setCellValue(brf59C.getR75_investment1() == null ? 0 : brf59C.getR75_investment1().intValue());
			}
			Cell R75cell17 = R75row.getCell(19);
			if (R75cell17 != null) {
				R75cell17.setCellValue(brf59C.getR75_zer0() == null ? 0 : brf59C.getR75_zer0().intValue());
			}
			Cell R75cell18 = R75row.getCell(20);
			if (R75cell18 != null) {
				R75cell18.setCellValue(brf59C.getR75_three() == null ? 0 : brf59C.getR75_three().intValue());
			}
			Cell R75cell19 = R75row.getCell(21);
			if (R75cell19 != null) {
				R75cell19.setCellValue(brf59C.getR75_six() == null ? 0 : brf59C.getR75_six().intValue());
			}
			Cell R75cell20 = R75row.getCell(22);
			if (R75cell20 != null) {
				R75cell20.setCellValue(brf59C.getR75_oneyear() == null ? 0 : brf59C.getR75_oneyear().intValue());
			}
			Cell R75cell21 = R75row.getCell(23);
			if (R75cell21 != null) {
				R75cell21.setCellValue(brf59C.getR75_foreign() == null ? 0 : brf59C.getR75_foreign().intValue());
			}
			Cell R75cell22 = R75row.getCell(24);
			if (R75cell22 != null) {
				R75cell22.setCellValue(brf59C.getR75_banks() == null ? 0 : brf59C.getR75_banks().intValue());
			}
			Cell R75cell23 = R75row.getCell(25);
			if (R75cell23 != null) {
				R75cell23.setCellValue(brf59C.getR75_gov2() == null ? 0 : brf59C.getR75_gov2().intValue());
			}
			Cell R75cell24 = R75row.getCell(26);
			if (R75cell24 != null) {
				R75cell24.setCellValue(brf59C.getR75_other() == null ? 0 : brf59C.getR75_other().intValue());
			}
			Cell R75cell25 = R75row.getCell(27);
			if (R75cell25 != null) {
				R75cell25.setCellValue(brf59C.getR75_banks1() == null ? 0 : brf59C.getR75_banks1().intValue());
			}
			Cell R75cell26 = R75row.getCell(28);
			if (R75cell26 != null) {
				R75cell26.setCellValue(
						brf59C.getR75_individuals2() == null ? 0 : brf59C.getR75_individuals2().intValue());
			}
			Cell R75cell27 = R75row.getCell(29);
			if (R75cell27 != null) {
				R75cell27.setCellValue(brf59C.getR75_other1() == null ? 0 : brf59C.getR75_other1().intValue());
			}
			Cell R75cell28 = R75row.getCell(30);
			if (R75cell28 != null) {
				R75cell28.setCellValue(brf59C.getR75_banks2() == null ? 0 : brf59C.getR75_banks2().intValue());
			}
			Cell R75cell29 = R75row.getCell(31);
			if (R75cell29 != null) {
				R75cell29.setCellValue(brf59C.getR75_gov3() == null ? 0 : brf59C.getR75_gov3().intValue());
			}
			Cell R75cell30 = R75row.getCell(32);
			if (R75cell30 != null) {
				R75cell30.setCellValue(brf59C.getR75_others2() == null ? 0 : brf59C.getR75_others2().intValue());
			}
			Cell R75cell31 = R75row.getCell(33);
			if (R75cell31 != null) {
				R75cell31.setCellValue(brf59C.getR75_banks3() == null ? 0 : brf59C.getR75_banks3().intValue());
			}
			Cell R75cell32 = R75row.getCell(34);
			if (R75cell32 != null) {
				R75cell32.setCellValue(brf59C.getR75_gov4() == null ? 0 : brf59C.getR75_gov4().intValue());
			}
			Cell R75cell33 = R75row.getCell(35);
			if (R75cell33 != null) {
				R75cell33.setCellValue(brf59C.getR75_others3() == null ? 0 : brf59C.getR75_others3().intValue());
			}
			Cell R75cell34 = R75row.getCell(36);
			if (R75cell34 != null) {
				R75cell34.setCellValue(brf59C.getR75_foreign1() == null ? 0 : brf59C.getR75_foreign1().intValue());
			}
			Cell R75cell35 = R75row.getCell(37);
			if (R75cell35 != null) {
				R75cell35.setCellValue(brf59C.getR75_guarantees() == null ? 0 : brf59C.getR75_guarantees().intValue());
			}
			Cell R75cell36 = R75row.getCell(38);
			if (R75cell36 != null) {
				R75cell36.setCellValue(brf59C.getR75_nbfi2() == null ? 0 : brf59C.getR75_nbfi2().intValue());
			}
			Cell R75cell37 = R75row.getCell(39);
			if (R75cell37 != null) {
				R75cell37.setCellValue(brf59C.getR75_interbank2() == null ? 0 : brf59C.getR75_interbank2().intValue());
			}
			Cell R75cell38 = R75row.getCell(40);
			if (R75cell38 != null) {
				R75cell38.setCellValue(brf59C.getR75_gov5() == null ? 0 : brf59C.getR75_gov5().intValue());
			}
			Cell R75cell39 = R75row.getCell(41);
			if (R75cell39 != null) {
				R75cell39.setCellValue(brf59C.getR75_corporate2() == null ? 0 : brf59C.getR75_corporate2().intValue());
			}
			Cell R75cell40 = R75row.getCell(42);
			if (R75cell40 != null) {
				R75cell40.setCellValue(brf59C.getR75_gre2() == null ? 0 : brf59C.getR75_gre2().intValue());
			}
			Cell R75cell41 = R75row.getCell(43);
			if (R75cell41 != null) {
				R75cell41.setCellValue(
						brf59C.getR75_individuals3() == null ? 0 : brf59C.getR75_individuals3().intValue());
			}
			Cell R75cell42 = R75row.getCell(44);
			if (R75cell42 != null) {
				R75cell42.setCellValue(brf59C.getR75_zero1() == null ? 0 : brf59C.getR75_zero1().intValue());
			}
			Cell R75cell43 = R75row.getCell(45);
			if (R75cell43 != null) {
				R75cell43.setCellValue(brf59C.getR75_three1() == null ? 0 : brf59C.getR75_three1().intValue());
			}
			Cell R75cell44 = R75row.getCell(46);
			if (R75cell44 != null) {
				R75cell44.setCellValue(brf59C.getR75_six1() == null ? 0 : brf59C.getR75_six1().intValue());
			}
			Cell R75cell45 = R75row.getCell(47);
			if (R75cell45 != null) {
				R75cell45.setCellValue(brf59C.getR75_oneyear1() == null ? 0 : brf59C.getR75_oneyear1().intValue());
			}
			Cell R75cell46 = R75row.getCell(48);
			if (R75cell46 != null) {
				R75cell46.setCellValue(brf59C.getR75_empty() == null ? "" : brf59C.getR75_empty().toString());
			}
			Row R76row = sheet.getRow(93);
			Cell R76cell1 = R76row.getCell(3);
			if (R76cell1 != null) {
				R76cell1.setCellValue(brf59C.getR76_nbfi() == null ? 0 : brf59C.getR76_nbfi().intValue());
			}

			Cell R76cell2 = R76row.getCell(4);
			if (R76cell2 != null) {
				R76cell2.setCellValue(brf59C.getR76_interbank() == null ? 0 : brf59C.getR76_interbank().intValue());
			}
			Cell R76cell3 = R76row.getCell(5);
			if (R76cell3 != null) {
				R76cell3.setCellValue(brf59C.getR76_gov() == null ? 0 : brf59C.getR76_gov().intValue());
			}
			Cell R76cell4 = R76row.getCell(6);
			if (R76cell4 != null) {
				R76cell4.setCellValue(brf59C.getR76_corporate() == null ? 0 : brf59C.getR76_corporate().intValue());
			}
			Cell R76cell5 = R76row.getCell(7);
			if (R76cell5 != null) {
				R76cell5.setCellValue(brf59C.getR76_gre() == null ? 0 : brf59C.getR76_gre().intValue());
			}
			Cell R76cell6 = R76row.getCell(8);
			if (R76cell6 != null) {
				R76cell6.setCellValue(brf59C.getR76_trade() == null ? 0 : brf59C.getR76_trade().intValue());
			}
			Cell R76cell7 = R76row.getCell(9);
			if (R76cell7 != null) {
				R76cell7.setCellValue(brf59C.getR76_individuals() == null ? 0 : brf59C.getR76_individuals().intValue());
			}
			Cell R76cell8 = R76row.getCell(10);
			if (R76cell8 != null) {
				R76cell8.setCellValue(brf59C.getR76_investment() == null ? 0 : brf59C.getR76_investment().intValue());
			}
			Cell R76cell9 = R76row.getCell(11);
			if (R76cell9 != null) {
				R76cell9.setCellValue(brf59C.getR76_nbfi1() == null ? 0 : brf59C.getR76_nbfi1().intValue());
			}
			Cell R76cell10 = R76row.getCell(12);
			if (R76cell10 != null) {
				R76cell10.setCellValue(brf59C.getR76_interbank1() == null ? 0 : brf59C.getR76_interbank1().intValue());
			}
			Cell R76cell11 = R76row.getCell(13);
			if (R76cell11 != null) {
				R76cell11.setCellValue(brf59C.getR76_gov1() == null ? 0 : brf59C.getR76_gov1().intValue());
			}
			Cell R76cell12 = R76row.getCell(14);
			if (R76cell12 != null) {
				R76cell12.setCellValue(brf59C.getR76_corporate1() == null ? 0 : brf59C.getR76_corporate1().intValue());
			}
			Cell R76cell13 = R76row.getCell(15);
			if (R76cell13 != null) {
				R76cell13.setCellValue(brf59C.getR76_gre1() == null ? 0 : brf59C.getR76_gre1().intValue());
			}
			Cell R76cell14 = R76row.getCell(16);
			if (R76cell14 != null) {
				R76cell14.setCellValue(brf59C.getR76_trade1() == null ? 0 : brf59C.getR76_trade1().intValue());
			}
			Cell R76cell15 = R76row.getCell(17);
			if (R76cell15 != null) {
				R76cell15.setCellValue(
						brf59C.getR76_individuals1() == null ? 0 : brf59C.getR76_individuals1().intValue());
			}
			Cell R76cell16 = R76row.getCell(18);
			if (R76cell16 != null) {
				R76cell16
						.setCellValue(brf59C.getR76_investment1() == null ? 0 : brf59C.getR76_investment1().intValue());
			}
			Cell R76cell17 = R76row.getCell(19);
			if (R76cell17 != null) {
				R76cell17.setCellValue(brf59C.getR76_zer0() == null ? 0 : brf59C.getR76_zer0().intValue());
			}
			Cell R76cell18 = R76row.getCell(20);
			if (R76cell18 != null) {
				R76cell18.setCellValue(brf59C.getR76_three() == null ? 0 : brf59C.getR76_three().intValue());
			}
			Cell R76cell19 = R76row.getCell(21);
			if (R76cell19 != null) {
				R76cell19.setCellValue(brf59C.getR76_six() == null ? 0 : brf59C.getR76_six().intValue());
			}
			Cell R76cell20 = R76row.getCell(22);
			if (R76cell20 != null) {
				R76cell20.setCellValue(brf59C.getR76_oneyear() == null ? 0 : brf59C.getR76_oneyear().intValue());
			}
			Cell R76cell21 = R76row.getCell(23);
			if (R76cell21 != null) {
				R76cell21.setCellValue(brf59C.getR76_foreign() == null ? 0 : brf59C.getR76_foreign().intValue());
			}
			Cell R76cell22 = R76row.getCell(24);
			if (R76cell22 != null) {
				R76cell22.setCellValue(brf59C.getR76_banks() == null ? 0 : brf59C.getR76_banks().intValue());
			}
			Cell R76cell23 = R76row.getCell(25);
			if (R76cell23 != null) {
				R76cell23.setCellValue(brf59C.getR76_gov2() == null ? 0 : brf59C.getR76_gov2().intValue());
			}
			Cell R76cell24 = R76row.getCell(26);
			if (R76cell24 != null) {
				R76cell24.setCellValue(brf59C.getR76_other() == null ? 0 : brf59C.getR76_other().intValue());
			}
			Cell R76cell25 = R76row.getCell(27);
			if (R76cell25 != null) {
				R76cell25.setCellValue(brf59C.getR76_banks1() == null ? 0 : brf59C.getR76_banks1().intValue());
			}
			Cell R76cell26 = R76row.getCell(28);
			if (R76cell26 != null) {
				R76cell26.setCellValue(
						brf59C.getR76_individuals2() == null ? 0 : brf59C.getR76_individuals2().intValue());
			}
			Cell R76cell27 = R76row.getCell(29);
			if (R76cell27 != null) {
				R76cell27.setCellValue(brf59C.getR76_other1() == null ? 0 : brf59C.getR76_other1().intValue());
			}
			Cell R76cell28 = R76row.getCell(30);
			if (R76cell28 != null) {
				R76cell28.setCellValue(brf59C.getR76_banks2() == null ? 0 : brf59C.getR76_banks2().intValue());
			}
			Cell R76cell29 = R76row.getCell(31);
			if (R76cell29 != null) {
				R76cell29.setCellValue(brf59C.getR76_gov3() == null ? 0 : brf59C.getR76_gov3().intValue());
			}
			Cell R76cell30 = R76row.getCell(32);
			if (R76cell30 != null) {
				R76cell30.setCellValue(brf59C.getR76_others2() == null ? 0 : brf59C.getR76_others2().intValue());
			}
			Cell R76cell31 = R76row.getCell(33);
			if (R76cell31 != null) {
				R76cell31.setCellValue(brf59C.getR76_banks3() == null ? 0 : brf59C.getR76_banks3().intValue());
			}
			Cell R76cell32 = R76row.getCell(34);
			if (R76cell32 != null) {
				R76cell32.setCellValue(brf59C.getR76_gov4() == null ? 0 : brf59C.getR76_gov4().intValue());
			}
			Cell R76cell33 = R76row.getCell(35);
			if (R76cell33 != null) {
				R76cell33.setCellValue(brf59C.getR76_others3() == null ? 0 : brf59C.getR76_others3().intValue());
			}
			Cell R76cell34 = R76row.getCell(36);
			if (R76cell34 != null) {
				R76cell34.setCellValue(brf59C.getR76_foreign1() == null ? 0 : brf59C.getR76_foreign1().intValue());
			}
			Cell R76cell35 = R76row.getCell(37);
			if (R76cell35 != null) {
				R76cell35.setCellValue(brf59C.getR76_guarantees() == null ? 0 : brf59C.getR76_guarantees().intValue());
			}
			Cell R76cell36 = R76row.getCell(38);
			if (R76cell36 != null) {
				R76cell36.setCellValue(brf59C.getR76_nbfi2() == null ? 0 : brf59C.getR76_nbfi2().intValue());
			}
			Cell R76cell37 = R76row.getCell(39);
			if (R76cell37 != null) {
				R76cell37.setCellValue(brf59C.getR76_interbank2() == null ? 0 : brf59C.getR76_interbank2().intValue());
			}
			Cell R76cell38 = R76row.getCell(40);
			if (R76cell38 != null) {
				R76cell38.setCellValue(brf59C.getR76_gov5() == null ? 0 : brf59C.getR76_gov5().intValue());
			}
			Cell R76cell39 = R76row.getCell(41);
			if (R76cell39 != null) {
				R76cell39.setCellValue(brf59C.getR76_corporate2() == null ? 0 : brf59C.getR76_corporate2().intValue());
			}
			Cell R76cell40 = R76row.getCell(42);
			if (R76cell40 != null) {
				R76cell40.setCellValue(brf59C.getR76_gre2() == null ? 0 : brf59C.getR76_gre2().intValue());
			}
			Cell R76cell41 = R76row.getCell(43);
			if (R76cell41 != null) {
				R76cell41.setCellValue(
						brf59C.getR76_individuals3() == null ? 0 : brf59C.getR76_individuals3().intValue());
			}
			Cell R76cell42 = R76row.getCell(44);
			if (R76cell42 != null) {
				R76cell42.setCellValue(brf59C.getR76_zero1() == null ? 0 : brf59C.getR76_zero1().intValue());
			}
			Cell R76cell43 = R76row.getCell(45);
			if (R76cell43 != null) {
				R76cell43.setCellValue(brf59C.getR76_three1() == null ? 0 : brf59C.getR76_three1().intValue());
			}
			Cell R76cell44 = R76row.getCell(46);
			if (R76cell44 != null) {
				R76cell44.setCellValue(brf59C.getR76_six1() == null ? 0 : brf59C.getR76_six1().intValue());
			}
			Cell R76cell45 = R76row.getCell(47);
			if (R76cell45 != null) {
				R76cell45.setCellValue(brf59C.getR76_oneyear1() == null ? 0 : brf59C.getR76_oneyear1().intValue());
			}
			Cell R76cell46 = R76row.getCell(48);
			if (R76cell46 != null) {
				R76cell46.setCellValue(brf59C.getR76_empty() == null ? "" : brf59C.getR76_empty().toString());
			}
			Row R77row = sheet.getRow(94);
			Cell R77cell1 = R77row.getCell(3);
			if (R77cell1 != null) {
				R77cell1.setCellValue(brf59C.getR77_nbfi() == null ? 0 : brf59C.getR77_nbfi().intValue());
			}

			Cell R77cell2 = R77row.getCell(4);
			if (R77cell2 != null) {
				R77cell2.setCellValue(brf59C.getR77_interbank() == null ? 0 : brf59C.getR77_interbank().intValue());
			}
			Cell R77cell3 = R77row.getCell(5);
			if (R77cell3 != null) {
				R77cell3.setCellValue(brf59C.getR77_gov() == null ? 0 : brf59C.getR77_gov().intValue());
			}
			Cell R77cell4 = R77row.getCell(6);
			if (R77cell4 != null) {
				R77cell4.setCellValue(brf59C.getR77_corporate() == null ? 0 : brf59C.getR77_corporate().intValue());
			}
			Cell R77cell5 = R77row.getCell(7);
			if (R77cell5 != null) {
				R77cell5.setCellValue(brf59C.getR77_gre() == null ? 0 : brf59C.getR77_gre().intValue());
			}
			Cell R77cell6 = R77row.getCell(8);
			if (R77cell6 != null) {
				R77cell6.setCellValue(brf59C.getR77_trade() == null ? 0 : brf59C.getR77_trade().intValue());
			}
			Cell R77cell7 = R77row.getCell(9);
			if (R77cell7 != null) {
				R77cell7.setCellValue(brf59C.getR77_individuals() == null ? 0 : brf59C.getR77_individuals().intValue());
			}
			Cell R77cell8 = R77row.getCell(10);
			if (R77cell8 != null) {
				R77cell8.setCellValue(brf59C.getR77_investment() == null ? 0 : brf59C.getR77_investment().intValue());
			}
			Cell R77cell9 = R77row.getCell(11);
			if (R77cell9 != null) {
				R77cell9.setCellValue(brf59C.getR77_nbfi1() == null ? 0 : brf59C.getR77_nbfi1().intValue());
			}
			Cell R77cell10 = R77row.getCell(12);
			if (R77cell10 != null) {
				R77cell10.setCellValue(brf59C.getR77_interbank1() == null ? 0 : brf59C.getR77_interbank1().intValue());
			}
			Cell R77cell11 = R77row.getCell(13);
			if (R77cell11 != null) {
				R77cell11.setCellValue(brf59C.getR77_gov1() == null ? 0 : brf59C.getR77_gov1().intValue());
			}
			Cell R77cell12 = R77row.getCell(14);
			if (R77cell12 != null) {
				R77cell12.setCellValue(brf59C.getR77_corporate1() == null ? 0 : brf59C.getR77_corporate1().intValue());
			}
			Cell R77cell13 = R77row.getCell(15);
			if (R77cell13 != null) {
				R77cell13.setCellValue(brf59C.getR77_gre1() == null ? 0 : brf59C.getR77_gre1().intValue());
			}
			Cell R77cell14 = R77row.getCell(16);
			if (R77cell14 != null) {
				R77cell14.setCellValue(brf59C.getR77_trade1() == null ? 0 : brf59C.getR77_trade1().intValue());
			}
			Cell R77cell15 = R77row.getCell(17);
			if (R77cell15 != null) {
				R77cell15.setCellValue(
						brf59C.getR77_individuals1() == null ? 0 : brf59C.getR77_individuals1().intValue());
			}
			Cell R77cell16 = R77row.getCell(18);
			if (R77cell16 != null) {
				R77cell16
						.setCellValue(brf59C.getR77_investment1() == null ? 0 : brf59C.getR77_investment1().intValue());
			}
			Cell R77cell17 = R77row.getCell(19);
			if (R77cell17 != null) {
				R77cell17.setCellValue(brf59C.getR77_zer0() == null ? 0 : brf59C.getR77_zer0().intValue());
			}
			Cell R77cell18 = R77row.getCell(20);
			if (R77cell18 != null) {
				R77cell18.setCellValue(brf59C.getR77_three() == null ? 0 : brf59C.getR77_three().intValue());
			}
			Cell R77cell19 = R77row.getCell(21);
			if (R77cell19 != null) {
				R77cell19.setCellValue(brf59C.getR77_six() == null ? 0 : brf59C.getR77_six().intValue());
			}
			Cell R77cell20 = R77row.getCell(22);
			if (R77cell20 != null) {
				R77cell20.setCellValue(brf59C.getR77_oneyear() == null ? 0 : brf59C.getR77_oneyear().intValue());
			}
			Cell R77cell21 = R77row.getCell(23);
			if (R77cell21 != null) {
				R77cell21.setCellValue(brf59C.getR77_foreign() == null ? 0 : brf59C.getR77_foreign().intValue());
			}
			Cell R77cell22 = R77row.getCell(24);
			if (R77cell22 != null) {
				R77cell22.setCellValue(brf59C.getR77_banks() == null ? 0 : brf59C.getR77_banks().intValue());
			}
			Cell R77cell23 = R77row.getCell(25);
			if (R77cell23 != null) {
				R77cell23.setCellValue(brf59C.getR77_gov2() == null ? 0 : brf59C.getR77_gov2().intValue());
			}
			Cell R77cell24 = R77row.getCell(26);
			if (R77cell24 != null) {
				R77cell24.setCellValue(brf59C.getR77_other() == null ? 0 : brf59C.getR77_other().intValue());
			}
			Cell R77cell25 = R77row.getCell(27);
			if (R77cell25 != null) {
				R77cell25.setCellValue(brf59C.getR77_banks1() == null ? 0 : brf59C.getR77_banks1().intValue());
			}
			Cell R77cell26 = R77row.getCell(28);
			if (R77cell26 != null) {
				R77cell26.setCellValue(
						brf59C.getR77_individuals2() == null ? 0 : brf59C.getR77_individuals2().intValue());
			}
			Cell R77cell27 = R77row.getCell(29);
			if (R77cell27 != null) {
				R77cell27.setCellValue(brf59C.getR77_other1() == null ? 0 : brf59C.getR77_other1().intValue());
			}
			Cell R77cell28 = R77row.getCell(30);
			if (R77cell28 != null) {
				R77cell28.setCellValue(brf59C.getR77_banks2() == null ? 0 : brf59C.getR77_banks2().intValue());
			}
			Cell R77cell29 = R77row.getCell(31);
			if (R77cell29 != null) {
				R77cell29.setCellValue(brf59C.getR77_gov3() == null ? 0 : brf59C.getR77_gov3().intValue());
			}
			Cell R77cell30 = R77row.getCell(32);
			if (R77cell30 != null) {
				R77cell30.setCellValue(brf59C.getR77_others2() == null ? 0 : brf59C.getR77_others2().intValue());
			}
			Cell R77cell31 = R77row.getCell(33);
			if (R77cell31 != null) {
				R77cell31.setCellValue(brf59C.getR77_banks3() == null ? 0 : brf59C.getR77_banks3().intValue());
			}
			Cell R77cell32 = R77row.getCell(34);
			if (R77cell32 != null) {
				R77cell32.setCellValue(brf59C.getR77_gov4() == null ? 0 : brf59C.getR77_gov4().intValue());
			}
			Cell R77cell33 = R77row.getCell(35);
			if (R77cell33 != null) {
				R77cell33.setCellValue(brf59C.getR77_others3() == null ? 0 : brf59C.getR77_others3().intValue());
			}
			Cell R77cell34 = R77row.getCell(36);
			if (R77cell34 != null) {
				R77cell34.setCellValue(brf59C.getR77_foreign1() == null ? 0 : brf59C.getR77_foreign1().intValue());
			}
			Cell R77cell35 = R77row.getCell(37);
			if (R77cell35 != null) {
				R77cell35.setCellValue(brf59C.getR77_guarantees() == null ? 0 : brf59C.getR77_guarantees().intValue());
			}
			Cell R77cell36 = R77row.getCell(38);
			if (R77cell36 != null) {
				R77cell36.setCellValue(brf59C.getR77_nbfi2() == null ? 0 : brf59C.getR77_nbfi2().intValue());
			}
			Cell R77cell37 = R77row.getCell(39);
			if (R77cell37 != null) {
				R77cell37.setCellValue(brf59C.getR77_interbank2() == null ? 0 : brf59C.getR77_interbank2().intValue());
			}
			Cell R77cell38 = R77row.getCell(40);
			if (R77cell38 != null) {
				R77cell38.setCellValue(brf59C.getR77_gov5() == null ? 0 : brf59C.getR77_gov5().intValue());
			}
			Cell R77cell39 = R77row.getCell(41);
			if (R77cell39 != null) {
				R77cell39.setCellValue(brf59C.getR77_corporate2() == null ? 0 : brf59C.getR77_corporate2().intValue());
			}
			Cell R77cell40 = R77row.getCell(42);
			if (R77cell40 != null) {
				R77cell40.setCellValue(brf59C.getR77_gre2() == null ? 0 : brf59C.getR77_gre2().intValue());
			}
			Cell R77cell41 = R77row.getCell(43);
			if (R77cell41 != null) {
				R77cell41.setCellValue(
						brf59C.getR77_individuals3() == null ? 0 : brf59C.getR77_individuals3().intValue());
			}
			Cell R77cell42 = R77row.getCell(44);
			if (R77cell42 != null) {
				R77cell42.setCellValue(brf59C.getR77_zero1() == null ? 0 : brf59C.getR77_zero1().intValue());
			}
			Cell R77cell43 = R77row.getCell(45);
			if (R77cell43 != null) {
				R77cell43.setCellValue(brf59C.getR77_three1() == null ? 0 : brf59C.getR77_three1().intValue());
			}
			Cell R77cell44 = R77row.getCell(46);
			if (R77cell44 != null) {
				R77cell44.setCellValue(brf59C.getR77_six1() == null ? 0 : brf59C.getR77_six1().intValue());
			}
			Cell R77cell45 = R77row.getCell(47);
			if (R77cell45 != null) {
				R77cell45.setCellValue(brf59C.getR77_oneyear1() == null ? 0 : brf59C.getR77_oneyear1().intValue());
			}
			Cell R77cell46 = R77row.getCell(48);
			if (R77cell46 != null) {
				R77cell46.setCellValue(brf59C.getR77_empty() == null ? "" : brf59C.getR77_empty().toString());
			}
			Row R79row = sheet.getRow(96);
			Cell R79cell1 = R79row.getCell(3);
			if (R79cell1 != null) {
				R79cell1.setCellValue(brf59C.getR79_nbfi() == null ? 0 : brf59C.getR79_nbfi().intValue());
			}

			Cell R79cell2 = R79row.getCell(4);
			if (R79cell2 != null) {
				R79cell2.setCellValue(brf59C.getR79_interbank() == null ? 0 : brf59C.getR79_interbank().intValue());
			}
			Cell R79cell3 = R79row.getCell(5);
			if (R79cell3 != null) {
				R79cell3.setCellValue(brf59C.getR79_gov() == null ? 0 : brf59C.getR79_gov().intValue());
			}
			Cell R79cell4 = R79row.getCell(6);
			if (R79cell4 != null) {
				R79cell4.setCellValue(brf59C.getR79_corporate() == null ? 0 : brf59C.getR79_corporate().intValue());
			}
			Cell R79cell5 = R79row.getCell(7);
			if (R79cell5 != null) {
				R79cell5.setCellValue(brf59C.getR79_gre() == null ? 0 : brf59C.getR79_gre().intValue());
			}
			Cell R79cell6 = R79row.getCell(8);
			if (R79cell6 != null) {
				R79cell6.setCellValue(brf59C.getR79_trade() == null ? 0 : brf59C.getR79_trade().intValue());
			}
			Cell R79cell7 = R79row.getCell(9);
			if (R79cell7 != null) {
				R79cell7.setCellValue(brf59C.getR79_individuals() == null ? 0 : brf59C.getR79_individuals().intValue());
			}
			Cell R79cell8 = R79row.getCell(10);
			if (R79cell8 != null) {
				R79cell8.setCellValue(brf59C.getR79_investment() == null ? 0 : brf59C.getR79_investment().intValue());
			}
			Cell R79cell9 = R79row.getCell(11);
			if (R79cell9 != null) {
				R79cell9.setCellValue(brf59C.getR79_nbfi1() == null ? 0 : brf59C.getR79_nbfi1().intValue());
			}
			Cell R79cell10 = R79row.getCell(12);
			if (R79cell10 != null) {
				R79cell10.setCellValue(brf59C.getR79_interbank1() == null ? 0 : brf59C.getR79_interbank1().intValue());
			}
			Cell R79cell11 = R79row.getCell(13);
			if (R79cell11 != null) {
				R79cell11.setCellValue(brf59C.getR79_gov1() == null ? 0 : brf59C.getR79_gov1().intValue());
			}
			Cell R79cell12 = R79row.getCell(14);
			if (R79cell12 != null) {
				R79cell12.setCellValue(brf59C.getR79_corporate1() == null ? 0 : brf59C.getR79_corporate1().intValue());
			}
			Cell R79cell13 = R79row.getCell(15);
			if (R79cell13 != null) {
				R79cell13.setCellValue(brf59C.getR79_gre1() == null ? 0 : brf59C.getR79_gre1().intValue());
			}
			Cell R79cell14 = R79row.getCell(16);
			if (R79cell14 != null) {
				R79cell14.setCellValue(brf59C.getR79_trade1() == null ? 0 : brf59C.getR79_trade1().intValue());
			}
			Cell R79cell15 = R79row.getCell(17);
			if (R79cell15 != null) {
				R79cell15.setCellValue(
						brf59C.getR79_individuals1() == null ? 0 : brf59C.getR79_individuals1().intValue());
			}
			Cell R79cell16 = R79row.getCell(18);
			if (R79cell16 != null) {
				R79cell16
						.setCellValue(brf59C.getR79_investment1() == null ? 0 : brf59C.getR79_investment1().intValue());
			}
			Cell R79cell17 = R79row.getCell(19);
			if (R79cell17 != null) {
				R79cell17.setCellValue(brf59C.getR79_zer0() == null ? 0 : brf59C.getR79_zer0().intValue());
			}
			Cell R79cell18 = R79row.getCell(20);
			if (R79cell18 != null) {
				R79cell18.setCellValue(brf59C.getR79_three() == null ? 0 : brf59C.getR79_three().intValue());
			}
			Cell R79cell19 = R79row.getCell(21);
			if (R79cell19 != null) {
				R79cell19.setCellValue(brf59C.getR79_six() == null ? 0 : brf59C.getR79_six().intValue());
			}
			Cell R79cell20 = R79row.getCell(22);
			if (R79cell20 != null) {
				R79cell20.setCellValue(brf59C.getR79_oneyear() == null ? 0 : brf59C.getR79_oneyear().intValue());
			}
			Cell R79cell21 = R79row.getCell(23);
			if (R79cell21 != null) {
				R79cell21.setCellValue(brf59C.getR79_foreign() == null ? 0 : brf59C.getR79_foreign().intValue());
			}
			Cell R79cell22 = R79row.getCell(24);
			if (R79cell22 != null) {
				R79cell22.setCellValue(brf59C.getR79_banks() == null ? 0 : brf59C.getR79_banks().intValue());
			}
			Cell R79cell23 = R79row.getCell(25);
			if (R79cell23 != null) {
				R79cell23.setCellValue(brf59C.getR79_gov2() == null ? 0 : brf59C.getR79_gov2().intValue());
			}
			Cell R79cell24 = R79row.getCell(26);
			if (R79cell24 != null) {
				R79cell24.setCellValue(brf59C.getR79_other() == null ? 0 : brf59C.getR79_other().intValue());
			}
			Cell R79cell25 = R79row.getCell(27);
			if (R79cell25 != null) {
				R79cell25.setCellValue(brf59C.getR79_banks1() == null ? 0 : brf59C.getR79_banks1().intValue());
			}
			Cell R79cell26 = R79row.getCell(28);
			if (R79cell26 != null) {
				R79cell26.setCellValue(
						brf59C.getR79_individuals2() == null ? 0 : brf59C.getR79_individuals2().intValue());
			}
			Cell R79cell27 = R79row.getCell(29);
			if (R79cell27 != null) {
				R79cell27.setCellValue(brf59C.getR79_other1() == null ? 0 : brf59C.getR79_other1().intValue());
			}
			Cell R79cell28 = R79row.getCell(30);
			if (R79cell28 != null) {
				R79cell28.setCellValue(brf59C.getR79_banks2() == null ? 0 : brf59C.getR79_banks2().intValue());
			}
			Cell R79cell29 = R79row.getCell(31);
			if (R79cell29 != null) {
				R79cell29.setCellValue(brf59C.getR79_gov3() == null ? 0 : brf59C.getR79_gov3().intValue());
			}
			Cell R79cell30 = R79row.getCell(32);
			if (R79cell30 != null) {
				R79cell30.setCellValue(brf59C.getR79_others2() == null ? 0 : brf59C.getR79_others2().intValue());
			}
			Cell R79cell31 = R79row.getCell(33);
			if (R79cell31 != null) {
				R79cell31.setCellValue(brf59C.getR79_banks3() == null ? 0 : brf59C.getR79_banks3().intValue());
			}
			Cell R79cell32 = R79row.getCell(34);
			if (R79cell32 != null) {
				R79cell32.setCellValue(brf59C.getR79_gov4() == null ? 0 : brf59C.getR79_gov4().intValue());
			}
			Cell R79cell33 = R79row.getCell(35);
			if (R79cell33 != null) {
				R79cell33.setCellValue(brf59C.getR79_others3() == null ? 0 : brf59C.getR79_others3().intValue());
			}
			Cell R79cell34 = R79row.getCell(36);
			if (R79cell34 != null) {
				R79cell34.setCellValue(brf59C.getR79_foreign1() == null ? 0 : brf59C.getR79_foreign1().intValue());
			}
			Cell R79cell35 = R79row.getCell(37);
			if (R79cell35 != null) {
				R79cell35.setCellValue(brf59C.getR79_guarantees() == null ? 0 : brf59C.getR79_guarantees().intValue());
			}
			Cell R79cell36 = R79row.getCell(38);
			if (R79cell36 != null) {
				R79cell36.setCellValue(brf59C.getR79_nbfi2() == null ? 0 : brf59C.getR79_nbfi2().intValue());
			}
			Cell R79cell37 = R79row.getCell(39);
			if (R79cell37 != null) {
				R79cell37.setCellValue(brf59C.getR79_interbank2() == null ? 0 : brf59C.getR79_interbank2().intValue());
			}
			Cell R79cell38 = R79row.getCell(40);
			if (R79cell38 != null) {
				R79cell38.setCellValue(brf59C.getR79_gov5() == null ? 0 : brf59C.getR79_gov5().intValue());
			}
			Cell R79cell39 = R79row.getCell(41);
			if (R79cell39 != null) {
				R79cell39.setCellValue(brf59C.getR79_corporate2() == null ? 0 : brf59C.getR79_corporate2().intValue());
			}
			Cell R79cell40 = R79row.getCell(42);
			if (R79cell40 != null) {
				R79cell40.setCellValue(brf59C.getR79_gre2() == null ? 0 : brf59C.getR79_gre2().intValue());
			}
			Cell R79cell41 = R79row.getCell(43);
			if (R79cell41 != null) {
				R79cell41.setCellValue(
						brf59C.getR79_individuals3() == null ? 0 : brf59C.getR79_individuals3().intValue());
			}
			Cell R79cell42 = R79row.getCell(44);
			if (R79cell42 != null) {
				R79cell42.setCellValue(brf59C.getR79_zero1() == null ? 0 : brf59C.getR79_zero1().intValue());
			}
			Cell R79cell43 = R79row.getCell(45);
			if (R79cell43 != null) {
				R79cell43.setCellValue(brf59C.getR79_three1() == null ? 0 : brf59C.getR79_three1().intValue());
			}
			Cell R79cell44 = R79row.getCell(46);
			if (R79cell44 != null) {
				R79cell44.setCellValue(brf59C.getR79_six1() == null ? 0 : brf59C.getR79_six1().intValue());
			}
			Cell R79cell45 = R79row.getCell(47);
			if (R79cell45 != null) {
				R79cell45.setCellValue(brf59C.getR79_oneyear1() == null ? 0 : brf59C.getR79_oneyear1().intValue());
			}
			Cell R79cell46 = R79row.getCell(48);
			if (R79cell46 != null) {
				R79cell46.setCellValue(brf59C.getR79_empty() == null ? "" : brf59C.getR79_empty().toString());
			}
			Row R80row = sheet.getRow(97);
			Cell R80cell1 = R80row.getCell(3);
			if (R80cell1 != null) {
				R80cell1.setCellValue(brf59C.getR80_nbfi() == null ? 0 : brf59C.getR80_nbfi().intValue());
			}

			Cell R80cell2 = R80row.getCell(4);
			if (R80cell2 != null) {
				R80cell2.setCellValue(brf59C.getR80_interbank() == null ? 0 : brf59C.getR80_interbank().intValue());
			}
			Cell R80cell3 = R80row.getCell(5);
			if (R80cell3 != null) {
				R80cell3.setCellValue(brf59C.getR80_gov() == null ? 0 : brf59C.getR80_gov().intValue());
			}
			Cell R80cell4 = R80row.getCell(6);
			if (R80cell4 != null) {
				R80cell4.setCellValue(brf59C.getR80_corporate() == null ? 0 : brf59C.getR80_corporate().intValue());
			}
			Cell R80cell5 = R80row.getCell(7);
			if (R80cell5 != null) {
				R80cell5.setCellValue(brf59C.getR80_gre() == null ? 0 : brf59C.getR80_gre().intValue());
			}
			Cell R80cell6 = R80row.getCell(8);
			if (R80cell6 != null) {
				R80cell6.setCellValue(brf59C.getR80_trade() == null ? 0 : brf59C.getR80_trade().intValue());
			}
			Cell R80cell7 = R80row.getCell(9);
			if (R80cell7 != null) {
				R80cell7.setCellValue(brf59C.getR80_individuals() == null ? 0 : brf59C.getR80_individuals().intValue());
			}
			Cell R80cell8 = R80row.getCell(10);
			if (R80cell8 != null) {
				R80cell8.setCellValue(brf59C.getR80_investment() == null ? 0 : brf59C.getR80_investment().intValue());
			}
			Cell R80cell9 = R80row.getCell(11);
			if (R80cell9 != null) {
				R80cell9.setCellValue(brf59C.getR80_nbfi1() == null ? 0 : brf59C.getR80_nbfi1().intValue());
			}
			Cell R80cell10 = R80row.getCell(12);
			if (R80cell10 != null) {
				R80cell10.setCellValue(brf59C.getR80_interbank1() == null ? 0 : brf59C.getR80_interbank1().intValue());
			}
			Cell R80cell11 = R80row.getCell(13);
			if (R80cell11 != null) {
				R80cell11.setCellValue(brf59C.getR80_gov1() == null ? 0 : brf59C.getR80_gov1().intValue());
			}
			Cell R80cell12 = R80row.getCell(14);
			if (R80cell12 != null) {
				R80cell12.setCellValue(brf59C.getR80_corporate1() == null ? 0 : brf59C.getR80_corporate1().intValue());
			}
			Cell R80cell13 = R80row.getCell(15);
			if (R80cell13 != null) {
				R80cell13.setCellValue(brf59C.getR80_gre1() == null ? 0 : brf59C.getR80_gre1().intValue());
			}
			Cell R80cell14 = R80row.getCell(16);
			if (R80cell14 != null) {
				R80cell14.setCellValue(brf59C.getR80_trade1() == null ? 0 : brf59C.getR80_trade1().intValue());
			}
			Cell R80cell15 = R80row.getCell(17);
			if (R80cell15 != null) {
				R80cell15.setCellValue(
						brf59C.getR80_individuals1() == null ? 0 : brf59C.getR80_individuals1().intValue());
			}
			Cell R80cell16 = R80row.getCell(18);
			if (R80cell16 != null) {
				R80cell16
						.setCellValue(brf59C.getR80_investment1() == null ? 0 : brf59C.getR80_investment1().intValue());
			}
			Cell R80cell17 = R80row.getCell(19);
			if (R80cell17 != null) {
				R80cell17.setCellValue(brf59C.getR80_zer0() == null ? 0 : brf59C.getR80_zer0().intValue());
			}
			Cell R80cell18 = R80row.getCell(20);
			if (R80cell18 != null) {
				R80cell18.setCellValue(brf59C.getR80_three() == null ? 0 : brf59C.getR80_three().intValue());
			}
			Cell R80cell19 = R80row.getCell(21);
			if (R80cell19 != null) {
				R80cell19.setCellValue(brf59C.getR80_six() == null ? 0 : brf59C.getR80_six().intValue());
			}
			Cell R80cell20 = R80row.getCell(22);
			if (R80cell20 != null) {
				R80cell20.setCellValue(brf59C.getR80_oneyear() == null ? 0 : brf59C.getR80_oneyear().intValue());
			}
			Cell R80cell21 = R80row.getCell(23);
			if (R80cell21 != null) {
				R80cell21.setCellValue(brf59C.getR80_foreign() == null ? 0 : brf59C.getR80_foreign().intValue());
			}
			Cell R80cell22 = R80row.getCell(24);
			if (R80cell22 != null) {
				R80cell22.setCellValue(brf59C.getR80_banks() == null ? 0 : brf59C.getR80_banks().intValue());
			}
			Cell R80cell23 = R80row.getCell(25);
			if (R80cell23 != null) {
				R80cell23.setCellValue(brf59C.getR80_gov2() == null ? 0 : brf59C.getR80_gov2().intValue());
			}
			Cell R80cell24 = R80row.getCell(26);
			if (R80cell24 != null) {
				R80cell24.setCellValue(brf59C.getR80_other() == null ? 0 : brf59C.getR80_other().intValue());
			}
			Cell R80cell25 = R80row.getCell(27);
			if (R80cell25 != null) {
				R80cell25.setCellValue(brf59C.getR80_banks1() == null ? 0 : brf59C.getR80_banks1().intValue());
			}
			Cell R80cell26 = R80row.getCell(28);
			if (R80cell26 != null) {
				R80cell26.setCellValue(
						brf59C.getR80_individuals2() == null ? 0 : brf59C.getR80_individuals2().intValue());
			}
			Cell R80cell27 = R80row.getCell(29);
			if (R80cell27 != null) {
				R80cell27.setCellValue(brf59C.getR80_other1() == null ? 0 : brf59C.getR80_other1().intValue());
			}
			Cell R80cell28 = R80row.getCell(30);
			if (R80cell28 != null) {
				R80cell28.setCellValue(brf59C.getR80_banks2() == null ? 0 : brf59C.getR80_banks2().intValue());
			}
			Cell R80cell29 = R80row.getCell(31);
			if (R80cell29 != null) {
				R80cell29.setCellValue(brf59C.getR80_gov3() == null ? 0 : brf59C.getR80_gov3().intValue());
			}
			Cell R80cell30 = R80row.getCell(32);
			if (R80cell30 != null) {
				R80cell30.setCellValue(brf59C.getR80_others2() == null ? 0 : brf59C.getR80_others2().intValue());
			}
			Cell R80cell31 = R80row.getCell(33);
			if (R80cell31 != null) {
				R80cell31.setCellValue(brf59C.getR80_banks3() == null ? 0 : brf59C.getR80_banks3().intValue());
			}
			Cell R80cell32 = R80row.getCell(34);
			if (R80cell32 != null) {
				R80cell32.setCellValue(brf59C.getR80_gov4() == null ? 0 : brf59C.getR80_gov4().intValue());
			}
			Cell R80cell33 = R80row.getCell(35);
			if (R80cell33 != null) {
				R80cell33.setCellValue(brf59C.getR80_others3() == null ? 0 : brf59C.getR80_others3().intValue());
			}
			Cell R80cell34 = R80row.getCell(36);
			if (R80cell34 != null) {
				R80cell34.setCellValue(brf59C.getR80_foreign1() == null ? 0 : brf59C.getR80_foreign1().intValue());
			}
			Cell R80cell35 = R80row.getCell(37);
			if (R80cell35 != null) {
				R80cell35.setCellValue(brf59C.getR80_guarantees() == null ? 0 : brf59C.getR80_guarantees().intValue());
			}
			Cell R80cell36 = R80row.getCell(38);
			if (R80cell36 != null) {
				R80cell36.setCellValue(brf59C.getR80_nbfi2() == null ? 0 : brf59C.getR80_nbfi2().intValue());
			}
			Cell R80cell37 = R80row.getCell(39);
			if (R80cell37 != null) {
				R80cell37.setCellValue(brf59C.getR80_interbank2() == null ? 0 : brf59C.getR80_interbank2().intValue());
			}
			Cell R80cell38 = R80row.getCell(40);
			if (R80cell38 != null) {
				R80cell38.setCellValue(brf59C.getR80_gov5() == null ? 0 : brf59C.getR80_gov5().intValue());
			}
			Cell R80cell39 = R80row.getCell(41);
			if (R80cell39 != null) {
				R80cell39.setCellValue(brf59C.getR80_corporate2() == null ? 0 : brf59C.getR80_corporate2().intValue());
			}
			Cell R80cell40 = R80row.getCell(42);
			if (R80cell40 != null) {
				R80cell40.setCellValue(brf59C.getR80_gre2() == null ? 0 : brf59C.getR80_gre2().intValue());
			}
			Cell R80cell41 = R80row.getCell(43);
			if (R80cell41 != null) {
				R80cell41.setCellValue(
						brf59C.getR80_individuals3() == null ? 0 : brf59C.getR80_individuals3().intValue());
			}
			Cell R80cell42 = R80row.getCell(44);
			if (R80cell42 != null) {
				R80cell42.setCellValue(brf59C.getR80_zero1() == null ? 0 : brf59C.getR80_zero1().intValue());
			}
			Cell R80cell43 = R80row.getCell(45);
			if (R80cell43 != null) {
				R80cell43.setCellValue(brf59C.getR80_three1() == null ? 0 : brf59C.getR80_three1().intValue());
			}
			Cell R80cell44 = R80row.getCell(46);
			if (R80cell44 != null) {
				R80cell44.setCellValue(brf59C.getR80_six1() == null ? 0 : brf59C.getR80_six1().intValue());
			}
			Cell R80cell45 = R80row.getCell(47);
			if (R80cell45 != null) {
				R80cell45.setCellValue(brf59C.getR80_oneyear1() == null ? 0 : brf59C.getR80_oneyear1().intValue());
			}
			Cell R80cell46 = R80row.getCell(48);
			if (R80cell46 != null) {
				R80cell46.setCellValue(brf59C.getR80_empty() == null ? "" : brf59C.getR80_empty().toString());
			}
		}
	}

	public File getFileBRF059(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile = null;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-59-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF59_DETAIL.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF59_DETAIL.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF59A.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF59A.jrxml");
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
				List<BRF59A_ENTITY> T1Master = new ArrayList<>();
				List<BRF59B_ENTITY> T1Master1 = new ArrayList<>();
				List<BRF59C_ENTITY> T1Master2 = new ArrayList<>();
				List<BRF59D_ENTITY> T1Master3 = new ArrayList<>();
				List<Object[]> T2rep = new ArrayList<>();
				List<BRF59E_ENTITY> Remaining = new ArrayList<>();
				Session hs = sessionFactory.getCurrentSession();

				try {
					Date d1 = df.parse(todate);

					T1Master = fetchEntity1Data(hs, d1);
					T1Master1 = fetchEntity2Data(hs, d1);
					T1Master2 = fetchEntity3Data(hs, d1);
					T1Master3 = fetchEntity4Data(hs, d1);
					T2rep = findentity2.findallvalues(todate);

					try (FileInputStream fis = new FileInputStream(
							env.getProperty("output.exportpathtemp") + "011-BRF-059-AT.xls");
							Workbook workbook = WorkbookFactory.create(fis)) {

						Sheet sheet = workbook.getSheetAt(0);

						// Update sheet with entity data
						updateSheetWithEntity1Data(sheet, T1Master);
						updateSheetWithEntity2Data(sheet, T1Master1);
						updateSheetWithEntity3Data(sheet, T1Master2);
						updateSheetWithEntity4Data(sheet, T1Master3);

						if (!T2rep.isEmpty()) {
							int startRow = 99;
							for (int index = 0; index < T2rep.size(); index++) {
								Object[] BRF59 = T2rep.get(index);
								Row row = sheet.getRow(startRow + index);
								if (row == null) {
									row = sheet.createRow(startRow + index);
								}

								// COUNTRY
								Cell cell = row.getCell(2);
								if (cell == null) {
									cell = row.createCell(2);
								}
								cell.setCellValue(BRF59[1] == null ? "" : BRF59[1].toString());
								// nbfi
								Cell cell1 = row.getCell(3);
								if (cell1 == null) {
									cell1 = row.createCell(3);
								}
								cell1.setCellValue(BRF59[2] == null ? 0 : ((BigDecimal) BRF59[2]).intValue());

								// interbank
								Cell cell2 = row.getCell(4);
								if (cell2 == null) {
									cell2 = row.createCell(4);
								}
								cell2.setCellValue(BRF59[3] == null ? 0 : ((BigDecimal) BRF59[3]).intValue());

								// gov
								Cell cell3 = row.getCell(5);
								if (cell3 == null) {
									cell3 = row.createCell(5);
								}
								cell3.setCellValue(BRF59[4] == null ? 0 : ((BigDecimal) BRF59[4]).intValue());

								// corporate
								Cell cell4 = row.getCell(6);
								if (cell4 == null) {
									cell4 = row.createCell(6);
								}
								cell4.setCellValue(BRF59[5] == null ? 0 : ((BigDecimal) BRF59[5]).intValue());

								// gre
								Cell cell5 = row.getCell(7);
								if (cell5 == null) {
									cell5 = row.createCell(7);
								}
								cell5.setCellValue(BRF59[6] == null ? 0 : ((BigDecimal) BRF59[6]).intValue());
								// trade
								Cell cell6 = row.getCell(8);
								if (cell6 == null) {
									cell6 = row.createCell(8);
								}
								cell6.setCellValue(BRF59[7] == null ? 0 : ((BigDecimal) BRF59[7]).intValue());
								///
								// individuals
								Cell cell7 = row.getCell(9);
								if (cell7 == null) {
									cell7 = row.createCell(9);
								}
								cell7.setCellValue(BRF59[8] == null ? 0 : ((BigDecimal) BRF59[8]).intValue());
								// investment
								Cell cell8 = row.getCell(10);
								if (cell8 == null) {
									cell8 = row.createCell(10);
								}
								cell8.setCellValue(BRF59[9] == null ? 0 : ((BigDecimal) BRF59[9]).intValue());
								// nbfi1
								Cell cell9 = row.getCell(11);
								if (cell9 == null) {
									cell9 = row.createCell(11);
								}
								cell9.setCellValue(BRF59[10] == null ? 0 : ((BigDecimal) BRF59[10]).intValue());
								// interbank1
								Cell cell10 = row.getCell(12);
								if (cell10 == null) {
									cell10 = row.createCell(12);
								}
								cell10.setCellValue(BRF59[11] == null ? 0 : ((BigDecimal) BRF59[11]).intValue());
								// gov1
								Cell cell11 = row.getCell(13);
								if (cell11 == null) {
									cell11 = row.createCell(13);
								}
								cell11.setCellValue(BRF59[12] == null ? 0 : ((BigDecimal) BRF59[12]).intValue());
								// trade
								Cell cell12 = row.getCell(14);
								if (cell12 == null) {
									cell12 = row.createCell(14);
								}
								cell12.setCellValue(BRF59[13] == null ? 0 : ((BigDecimal) BRF59[13]).intValue());
								// corporate1
								Cell cell13 = row.getCell(15);
								if (cell13 == null) {
									cell13 = row.createCell(15);
								}
								cell13.setCellValue(BRF59[14] == null ? 0 : ((BigDecimal) BRF59[14]).intValue());
								// gre1
								Cell cell14 = row.getCell(16);
								if (cell14 == null) {
									cell14 = row.createCell(16);
								}
								cell14.setCellValue(BRF59[15] == null ? 0 : ((BigDecimal) BRF59[15]).intValue());
								// trade1
								Cell cell15 = row.getCell(17);
								if (cell15 == null) {
									cell15 = row.createCell(17);
								}
								cell15.setCellValue(BRF59[16] == null ? 0 : ((BigDecimal) BRF59[16]).intValue());
								// individuals1
								Cell cell16 = row.getCell(18);
								if (cell16 == null) {
									cell16 = row.createCell(18);
								}
								cell16.setCellValue(BRF59[17] == null ? 0 : ((BigDecimal) BRF59[17]).intValue());
								// investment1
								Cell cell17 = row.getCell(19);
								if (cell17 == null) {
									cell17 = row.createCell(19);
								}
								cell17.setCellValue(BRF59[18] == null ? 0 : ((BigDecimal) BRF59[18]).intValue());
								// zer0
								Cell cell18 = row.getCell(20);
								if (cell18 == null) {
									cell18 = row.createCell(20);
								}
								cell18.setCellValue(BRF59[19] == null ? 0 : ((BigDecimal) BRF59[19]).intValue());
								// three
								Cell cell19 = row.getCell(21);
								if (cell19 == null) {
									cell19 = row.createCell(21);
								}
								cell19.setCellValue(BRF59[20] == null ? 0 : ((BigDecimal) BRF59[20]).intValue());
								// six
								Cell cell20 = row.getCell(22);
								if (cell20 == null) {
									cell20 = row.createCell(22);
								}
								cell20.setCellValue(BRF59[21] == null ? 0 : ((BigDecimal) BRF59[21]).intValue());
								// foreign
								Cell cell21 = row.getCell(23);
								if (cell21 == null) {
									cell21 = row.createCell(23);
								}
								cell21.setCellValue(BRF59[22] == null ? 0 : ((BigDecimal) BRF59[22]).intValue());
								// banks
								Cell cell22 = row.getCell(24);
								if (cell22 == null) {
									cell22 = row.createCell(24);
								}
								cell22.setCellValue(BRF59[23] == null ? 0 : ((BigDecimal) BRF59[23]).intValue());
								// gov2
								Cell cell23 = row.getCell(25);
								if (cell23 == null) {
									cell23 = row.createCell(25);
								}
								cell23.setCellValue(BRF59[24] == null ? 0 : ((BigDecimal) BRF59[24]).intValue());
								// other
								Cell cell24 = row.getCell(26);
								if (cell24 == null) {
									cell24 = row.createCell(26);
								}
								cell24.setCellValue(BRF59[25] == null ? 0 : ((BigDecimal) BRF59[25]).intValue());
								// banks1
								Cell cell25 = row.getCell(27);
								if (cell25 == null) {
									cell25 = row.createCell(27);
								}
								cell25.setCellValue(BRF59[26] == null ? 0 : ((BigDecimal) BRF59[26]).intValue());
								// individuals2
								Cell cell26 = row.getCell(28);
								if (cell26 == null) {
									cell26 = row.createCell(28);
								}
								cell26.setCellValue(BRF59[27] == null ? 0 : ((BigDecimal) BRF59[27]).intValue());
								// other1
								Cell cell27 = row.getCell(29);
								if (cell27 == null) {
									cell27 = row.createCell(29);
								}
								cell27.setCellValue(BRF59[28] == null ? 0 : ((BigDecimal) BRF59[28]).intValue());
								// banks2
								Cell cell28 = row.getCell(30);
								if (cell28 == null) {
									cell28 = row.createCell(30);
								}
								cell28.setCellValue(BRF59[29] == null ? 0 : ((BigDecimal) BRF59[29]).intValue());
								// gov3
								Cell cell29 = row.getCell(31);
								if (cell29 == null) {
									cell29 = row.createCell(31);
								}
								cell29.setCellValue(BRF59[30] == null ? 0 : ((BigDecimal) BRF59[30]).intValue());
								// others2
								Cell cell30 = row.getCell(32);
								if (cell30 == null) {
									cell30 = row.createCell(32);
								}
								cell30.setCellValue(BRF59[31] == null ? 0 : ((BigDecimal) BRF59[31]).intValue());
								// banks3
								Cell cell31 = row.getCell(33);
								if (cell31 == null) {
									cell31 = row.createCell(33);
								}
								cell31.setCellValue(BRF59[32] == null ? 0 : ((BigDecimal) BRF59[32]).intValue());
								// gov4
								Cell cell32 = row.getCell(34);
								if (cell32 == null) {
									cell32 = row.createCell(34);
								}
								cell32.setCellValue(BRF59[33] == null ? 0 : ((BigDecimal) BRF59[33]).intValue());
								// others3
								Cell cell33 = row.getCell(35);
								if (cell33 == null) {
									cell33 = row.createCell(35);
								}
								cell33.setCellValue(BRF59[34] == null ? 0 : ((BigDecimal) BRF59[34]).intValue());
								// foreign1
								Cell cell34 = row.getCell(36);
								if (cell34 == null) {
									cell34 = row.createCell(36);
								}
								cell34.setCellValue(BRF59[35] == null ? 0 : ((BigDecimal) BRF59[35]).intValue());
								// guarantees
								Cell cell35 = row.getCell(37);
								if (cell35 == null) {
									cell35 = row.createCell(37);
								}
								cell35.setCellValue(BRF59[36] == null ? 0 : ((BigDecimal) BRF59[36]).intValue());
								// nbfi2
								Cell cell36 = row.getCell(38);
								if (cell36 == null) {
									cell36 = row.createCell(38);
								}
								cell36.setCellValue(BRF59[37] == null ? 0 : ((BigDecimal) BRF59[37]).intValue());
								// interbank2
								Cell cell37 = row.getCell(39);
								if (cell37 == null) {
									cell37 = row.createCell(39);
								}
								cell37.setCellValue(BRF59[38] == null ? 0 : ((BigDecimal) BRF59[38]).intValue());
								// gov5
								Cell cell38 = row.getCell(40);
								if (cell38 == null) {
									cell38 = row.createCell(40);
								}
								cell38.setCellValue(BRF59[39] == null ? 0 : ((BigDecimal) BRF59[39]).intValue());
								// corporate2
								Cell cell39 = row.getCell(41);
								if (cell39 == null) {
									cell39 = row.createCell(41);
								}
								cell39.setCellValue(BRF59[40] == null ? 0 : ((BigDecimal) BRF59[40]).intValue());
								// gre2
								Cell cell40 = row.getCell(42);
								if (cell40 == null) {
									cell40 = row.createCell(42);
								}
								cell40.setCellValue(BRF59[41] == null ? 0 : ((BigDecimal) BRF59[41]).intValue());
								// individuals3
								Cell cell41 = row.getCell(43);
								if (cell41 == null) {
									cell41 = row.createCell(43);
								}
								cell41.setCellValue(BRF59[42] == null ? 0 : ((BigDecimal) BRF59[42]).intValue());
								// zero1
								Cell cell42 = row.getCell(44);
								if (cell42 == null) {
									cell42 = row.createCell(44);
								}
								cell42.setCellValue(BRF59[43] == null ? 0 : ((BigDecimal) BRF59[43]).intValue());
								// three1
								Cell cell43 = row.getCell(45);
								if (cell43 == null) {
									cell43 = row.createCell(45);
								}
								cell43.setCellValue(BRF59[44] == null ? 0 : ((BigDecimal) BRF59[44]).intValue());
								// six1
								Cell cell44 = row.getCell(46);
								if (cell44 == null) {
									cell44 = row.createCell(46);
								}
								cell44.setCellValue(BRF59[45] == null ? 0 : ((BigDecimal) BRF59[45]).intValue());
								// oneyear1
								Cell cell45 = row.getCell(47);
								if (cell45 == null) {
									cell45 = row.createCell(47);
								}
								cell45.setCellValue(BRF59[46] == null ? 0 : ((BigDecimal) BRF59[46]).intValue());
								// empty
								Cell cell46 = row.getCell(48);
								if (cell46 == null) {
									cell46 = row.createCell(48);
								}
								cell46.setCellValue(BRF59[47] == null ? "" : BRF59[47].toString());
							}

						}

						// Evaluate all formulas
						workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

						// Save the changes to the workbook
						try (FileOutputStream fileOut = new FileOutputStream(
								env.getProperty("output.exportpathfinal") + "011-BRF-059-A.xls")) {
							workbook.write(fileOut);
							path = fileOut.toString();
							logger.info("PATH : " + path);
						}
					}

				} catch (ParseException | EncryptedDocumentException | InvalidFormatException | IOException e) {
					e.printStackTrace();
				}

				// Final output file
				outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-059-A.xls");
				return outputFile;
			}
		}
		return outputFile;
	}

	public String detailChanges59(BRF59_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			String country, BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			System.out.println(foracid + "| |" + report_addl_criteria_1 + "| |" + country);
			BRF59_DETAIL_ENTITY Brf59detail = brf59DetailRep.findByCustomCriteria(foracid, country,
					report_addl_criteria_1);
			System.out.println(foracid + "| |" + report_addl_criteria_1 + "| |" + country);
			System.out.println(Brf59detail);

			System.out.println(act_balance_amt_lc + report_label_1 + report_name_1 + report_addl_criteria_1);
			if (Brf59detail != null) {

				Brf59detail.setAct_balance_amt_lc(act_balance_amt_lc);
				Brf59detail.setReport_label_1(report_label_1);
				Brf59detail.setReport_name_1(report_name_1);
				Brf59detail.setReport_addl_criteria_1(report_addl_criteria_1);
				brf59DetailRep.save(Brf59detail);

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
	/*
	 * public ModelAndView getArchieveBRF059View(String reportId, String fromdate,
	 * String todate, String currency, String dtltype, Pageable pageable) {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * Session hs = sessionFactory.getCurrentSession(); int pageSize =
	 * pageable.getPageSize(); int currentPage = pageable.getPageNumber(); int
	 * startItem = currentPage * pageSize; List<BRF59A_ENTITY> T1rep = new
	 * ArrayList<BRF59A_ENTITY>(); // Query<Object[]> qr;
	 * 
	 * List<BRF59A_ENTITY> T1Master = new ArrayList<BRF59A_ENTITY>();
	 * 
	 * List<BRF59B_ENTITY> T1Master1 = new ArrayList<BRF59B_ENTITY>();
	 * 
	 * List<BRF59C_ENTITY> T1Master2 = new ArrayList<BRF59C_ENTITY>();
	 * 
	 * List<BRF59D_ENTITY> T1Master3 = new ArrayList<BRF59D_ENTITY>();
	 * 
	 * List<BRF59E_ENTITY> T1Master4 = new ArrayList<BRF59E_ENTITY>();
	 * 
	 * logger.info("Inside archive" + currency);
	 * 
	 * try {
	 * 
	 * Date d1 = df.parse(todate);
	 * 
	 * T1Master = hs.createQuery("from BRF59A_ENTITY a where a.report_date = ?1 ",
	 * BRF59A_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * T1Master1 = hs.createQuery("from BRF59B_ENTITY a where a.report_date = ?1 ",
	 * BRF59B_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * T1Master2 = hs.createQuery("from BRF59C_ENTITY a where a.report_date = ?1 ",
	 * BRF59C_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * T1Master3 = hs.createQuery("from BRF59D_ENTITY a where a.report_date = ?1 ",
	 * BRF59D_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * T1Master4 = hs.createQuery("from BRF59E_ENTITY a where a.report_date = ?1 ",
	 * BRF59E_ENTITY.class) .setParameter(1, df.parse(todate)).getResultList();
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); }
	 * 
	 * // T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);
	 * 
	 * mv.setViewName("RR/BRF59ARCH"); // mv.addObject("currlist",
	 * refCodeConfig.currList()); mv.addObject("reportsummary", T1Master);
	 * mv.addObject("reportsummary1", T1Master1); mv.addObject("reportsummary2",
	 * T1Master2); mv.addObject("reportsummary3", T1Master3);
	 * mv.addObject("reportsummary4", T1Master4); mv.addObject("reportmaster",
	 * T1Master); mv.addObject("displaymode", "summary");
	 * mv.addObject("reportsflag", "reportsflag"); mv.addObject("menu", reportId);
	 * System.out.println("scv" + mv.getViewName());
	 * 
	 * return mv;
	 * 
	 * }
	 */

	public ModelAndView getArchieveBRF059View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF59A_ENTITY> T1rep = new ArrayList<BRF59A_ENTITY>();
		// Query<Object[]> qr;

		List<BRF59A_ENTITY> T1Master = new ArrayList<BRF59A_ENTITY>();

		List<BRF59B_ENTITY> T1Master1 = new ArrayList<BRF59B_ENTITY>();

		List<BRF59C_ENTITY> T1Master2 = new ArrayList<BRF59C_ENTITY>();

		List<BRF59D_ENTITY> T1Master3 = new ArrayList<BRF59D_ENTITY>();

		List<Object[]> T2rep = new ArrayList<Object[]>();

		List<BRF59E_ENTITY> Remaining = new ArrayList<BRF59E_ENTITY>();

		logger.info("Inside archive" + currency);

		try {

			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF59A_ENTITY a where a.report_date = ?1 ", BRF59A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF59B_ENTITY a where a.report_date = ?1 ", BRF59B_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master2 = hs.createQuery("from BRF59C_ENTITY a where a.report_date = ?1 ", BRF59C_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master3 = hs.createQuery("from BRF59D_ENTITY a where a.report_date = ?1 ", BRF59D_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			System.out.println(T2rep.toString());

			for (Object[] BRF59 : T2rep) {
				System.out.println("Inside loop");
				BRF59E_ENTITY BRF59E_ENTITY = new BRF59E_ENTITY();

				if (BRF59[0].equals("Remaining Countries")) {

					BRF59E_ENTITY.setRemaining((String) BRF59[1]);
					System.out.println(BRF59E_ENTITY.getRemaining());
					BRF59E_ENTITY.setNbfi((BigDecimal) BRF59[2]);
					BRF59E_ENTITY.setInterbank((BigDecimal) BRF59[3]);
					BRF59E_ENTITY.setGov((BigDecimal) BRF59[4]);
					BRF59E_ENTITY.setCorporate((BigDecimal) BRF59[5]);
					BRF59E_ENTITY.setGre((BigDecimal) BRF59[6]);
					BRF59E_ENTITY.setTrade((BigDecimal) BRF59[7]);
					BRF59E_ENTITY.setIndividuals((BigDecimal) BRF59[8]);
					BRF59E_ENTITY.setInvestment((BigDecimal) BRF59[9]);
					BRF59E_ENTITY.setNbfi1((BigDecimal) BRF59[10]);
					BRF59E_ENTITY.setInterbank1((BigDecimal) BRF59[11]);
					BRF59E_ENTITY.setGov1((BigDecimal) BRF59[12]);
					BRF59E_ENTITY.setCorporate1((BigDecimal) BRF59[13]);
					BRF59E_ENTITY.setGre1((BigDecimal) BRF59[14]);
					BRF59E_ENTITY.setTrade1((BigDecimal) BRF59[15]);
					BRF59E_ENTITY.setIndividuals1((BigDecimal) BRF59[16]);
					BRF59E_ENTITY.setInvestment1((BigDecimal) BRF59[17]);
					BRF59E_ENTITY.setZer0((BigDecimal) BRF59[18]);
					BRF59E_ENTITY.setThree((BigDecimal) BRF59[19]);
					BRF59E_ENTITY.setSix((BigDecimal) BRF59[20]);
					BRF59E_ENTITY.setOneyear((BigDecimal) BRF59[21]);
					BRF59E_ENTITY.setForeign((BigDecimal) BRF59[22]);
					BRF59E_ENTITY.setBanks((BigDecimal) BRF59[23]);
					BRF59E_ENTITY.setGov2((BigDecimal) BRF59[24]);
					BRF59E_ENTITY.setOther((BigDecimal) BRF59[25]);
					BRF59E_ENTITY.setBanks1((BigDecimal) BRF59[26]);
					BRF59E_ENTITY.setIndividuals2((BigDecimal) BRF59[27]);
					BRF59E_ENTITY.setOther1((BigDecimal) BRF59[28]);
					BRF59E_ENTITY.setBanks2((BigDecimal) BRF59[29]);
					BRF59E_ENTITY.setGov3((BigDecimal) BRF59[30]);
					BRF59E_ENTITY.setOthers2((BigDecimal) BRF59[31]);
					BRF59E_ENTITY.setBanks3((BigDecimal) BRF59[32]);
					BRF59E_ENTITY.setGov4((BigDecimal) BRF59[33]);
					BRF59E_ENTITY.setOthers3((BigDecimal) BRF59[34]);
					BRF59E_ENTITY.setForeign1((BigDecimal) BRF59[35]);
					BRF59E_ENTITY.setGuarantees((BigDecimal) BRF59[36]);
					BRF59E_ENTITY.setNbfi2((BigDecimal) BRF59[37]);
					BRF59E_ENTITY.setInterbank2((BigDecimal) BRF59[38]);
					BRF59E_ENTITY.setGov5((BigDecimal) BRF59[39]);
					BRF59E_ENTITY.setCorporate2((BigDecimal) BRF59[40]);
					BRF59E_ENTITY.setGre2((BigDecimal) BRF59[41]);
					BRF59E_ENTITY.setIndividuals3((BigDecimal) BRF59[42]);
					BRF59E_ENTITY.setZero1((BigDecimal) BRF59[43]);
					BRF59E_ENTITY.setThree1((BigDecimal) BRF59[44]);
					BRF59E_ENTITY.setSix1((BigDecimal) BRF59[45]);
					BRF59E_ENTITY.setOneyear1((BigDecimal) BRF59[46]);
					BRF59E_ENTITY.setEmpty((String) BRF59[47]);
					BRF59E_ENTITY.setRow_label((String) BRF59[48]);

					Remaining.add(BRF59E_ENTITY);
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF59ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportsummary2", T1Master2);
		mv.addObject("reportsummary3", T1Master3);
		mv.addObject("reportsummary4", T2rep);
		System.out.println(Remaining);
		mv.addObject("Remaining", Remaining);

		mv.addObject("getnbfi", findentity2.getnbfi(todate));
		mv.addObject("getinterbank", findentity2.getinterbank(todate));
		mv.addObject("getgov", findentity2.getgov(todate));
		mv.addObject("getcorporate", findentity2.getcorporate(todate));
		mv.addObject("getgre", findentity2.getgre(todate));
		mv.addObject("gettrade", findentity2.gettrade(todate));
		mv.addObject("getindividuals", findentity2.getindividuals(todate));
		mv.addObject("getinvestment", findentity2.getinvestment(todate));

		mv.addObject("getnbfi1", findentity2.getnbfi1(todate));
		mv.addObject("getinterbank1", findentity2.getinterbank1(todate));
		mv.addObject("getgov1", findentity2.getgov1(todate));
		mv.addObject("getcorporate1", findentity2.getcorporate1(todate));
		mv.addObject("getgre1", findentity2.getgre1(todate));
		mv.addObject("gettrade1", findentity2.gettrade1(todate));
		mv.addObject("getindividuals1", findentity2.getindividuals1(todate));
		mv.addObject("getinvestment1", findentity2.getinvestment1(todate));

		/// remain-GRE
		mv.addObject("getzer0", findentity2.getzer0(todate));
		mv.addObject("getthree", findentity2.getthree(todate));
		mv.addObject("getsix", findentity2.getsix(todate));
		mv.addObject("getoneyear", findentity2.getoneyear(todate));
		mv.addObject("getforeign", findentity2.getforeign(todate));
		mv.addObject("getbanks", findentity2.getbanks(todate));
		mv.addObject("getgov2", findentity2.getgov2(todate));
		mv.addObject("getother", findentity2.getother(todate));

		mv.addObject("getbanks1", findentity2.getbanks1(todate));
		mv.addObject("getindividuals2", findentity2.getindividuals2(todate));
		mv.addObject("getother1", findentity2.getother1(todate));
		mv.addObject("getbanks2", findentity2.getbanks2(todate));
		mv.addObject("getgov3", findentity2.getgov3(todate));
		mv.addObject("getothers2", findentity2.getothers2(todate));
		mv.addObject("getbanks3", findentity2.getbanks3(todate));
		mv.addObject("getgov4", findentity2.getgov4(todate));

		/// remain-SME
		mv.addObject("getothers3", findentity2.getothers3(todate));
		mv.addObject("getforeign1", findentity2.getforeign1(todate));
		mv.addObject("getguarantees", findentity2.getguarantees(todate));
		mv.addObject("getnbfi2", findentity2.getnbfi2(todate));
		mv.addObject("getinterbank2", findentity2.getinterbank2(todate));
		mv.addObject("getgov5", findentity2.getgov5(todate));
		mv.addObject("getcorporate2", findentity2.getcorporate2(todate));
		mv.addObject("getgre2", findentity2.getgre2(todate));

		mv.addObject("getindividuals3", findentity2.getindividuals3(todate));
		mv.addObject("getzero1", findentity2.getzero1(todate));
		mv.addObject("getthree1", findentity2.getthree1(todate));
		mv.addObject("getsix1", findentity2.getsix1(todate));
		mv.addObject("getoneyear1", findentity2.getoneyear1(todate));

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

	public ModelAndView ARCHgetBRF059currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF59_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF59_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF59_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF59_ARCHIV_ENTITY> T1Master = new ArrayList<BRF59_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF59_ARCHIV_ENTITY a where a.report_date = ?1", BRF59_ARCHIV_ENTITY.class)
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
			Character del_flg = (Character) a[42];
			String nre_status = (String) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nreflag = (Character) a[49];

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

			BRF59_ARCHIV_ENTITY py = new BRF59_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nreflag);
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

		mv.setViewName("RR" + "/" + "BRF59ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
