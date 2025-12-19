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

import com.bornfire.xbrl.entities.BRF84_ARCHIV_ENTITY;

import com.bornfire.xbrl.entities.BRBS.BRF84_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF84_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF84_ENTITY_REP;
import com.bornfire.xbrl.entities.BRBS.BRF84A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF84B_ENTITY;
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
@ConfigurationProperties("output")
public class BRF84ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF84ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;
	@Autowired
	BRF84_ENTITY_REP findentity2;

	@Autowired
	BRF84_DetailRepo brf84_detailrepo;
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF84A_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF84A_ENTITY a").getSingleResult();
				if (modcnt > 0) {
					msg = "success";
				}
			} else {

				msg = "success";

			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			msg = "success";
			e.printStackTrace();

		}

		return msg;

	}

	public ModelAndView getBRF84View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF84A_ENTITY> T1rep = new ArrayList<BRF84A_ENTITY>();

		List<BRF84A_ENTITY> T1Master = new ArrayList<BRF84A_ENTITY>();
		List<Object[]> T2rep = new ArrayList<Object[]>();

		List<BRF84B_ENTITY> sectionc = new ArrayList<BRF84B_ENTITY>();
		List<BRF84B_ENTITY> sectiond = new ArrayList<BRF84B_ENTITY>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF84A_ENTITY a where a.report_date = ?1 ", BRF84A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
			T2rep = findentity2.findallvalues(todate);
			System.out.println(T2rep.toString());
			for (Object[] BRF84 : T2rep) {
				// Check if the current record is PART C or PART D
				if (BRF84[0] != null && BRF84[0].equals("PART C")) {
					// Create a new instance for each loop iteration
					BRF84B_ENTITY BRF84B_ENTITY = new BRF84B_ENTITY();

					BRF84B_ENTITY.setPart((String) BRF84[0]);

					BRF84B_ENTITY.setDescription((String) BRF84[1]);
					System.out.println(BRF84B_ENTITY.getDescription());

					BRF84B_ENTITY.setCountry((String) BRF84[2]);
					BRF84B_ENTITY.setNo_of_officies((BigDecimal) BRF84[3]);
					BRF84B_ENTITY.setFunded_os((BigDecimal) BRF84[4]);
					BRF84B_ENTITY.setDebit_securities((BigDecimal) BRF84[5]);
					BRF84B_ENTITY.setUnfunded_os((BigDecimal) BRF84[6]);
					BRF84B_ENTITY.setCcf_equi_unfuned_os((BigDecimal) BRF84[7]);
					BRF84B_ENTITY.setCcf_equi_funded_n_unfuned_limits((BigDecimal) BRF84[8]);
					BRF84B_ENTITY.setTotal_exposer((BigDecimal) BRF84[9]);
					BRF84B_ENTITY.setAs_of_tier1_capital((BigDecimal) BRF84[10]);
					BRF84B_ENTITY.setCredit_risk_miti_type((String) BRF84[11]);
					BRF84B_ENTITY.setCredit_risk_miti_hair_cut((BigDecimal) BRF84[12]);
					BRF84B_ENTITY.setCollateral_hair_cut((BigDecimal) BRF84[13]);
					BRF84B_ENTITY.setCbuae_class((String) BRF84[14]);
					BRF84B_ENTITY.setProvision((BigDecimal) BRF84[15]);
					BRF84B_ENTITY.setRemarks((String) BRF84[16]);
					/* BRF84B_ENTITY.setFundedos_total ((BigDecimal) BRF84[17]); */
					/*
					 * BRF84B_ENTITY.setDebtsecurity_total ((BigDecimal) BRF84[18]);
					 * BRF84B_ENTITY.setUnfunded_total ((BigDecimal) BRF84[19]);
					 * BRF84B_ENTITY.setCcfeqi_unfund_total ((BigDecimal) BRF84[20]);
					 * BRF84B_ENTITY.setCcf_eqi_limit_total ((BigDecimal) BRF84[21]);
					 * BRF84B_ENTITY.setTotal_exposure_total ((BigDecimal) BRF84[22]);
					 * BRF84B_ENTITY.setColumn4 ((BigDecimal) BRF84[23]);
					 * BRF84B_ENTITY.setCredit_risk_haircut_total ((BigDecimal) BRF84[24]);
					 * BRF84B_ENTITY.setCollateralvalue_total ((BigDecimal) BRF84[25]);
					 * BRF84B_ENTITY.setProvision_total ((BigDecimal) BRF84[26]);
					 * BRF84B_ENTITY.setRow_label((String)BRF84[27]);
					 */
					sectionc.add(BRF84B_ENTITY);
				} else if (BRF84[0] != null && BRF84[0].equals("PART D")) {
					BRF84B_ENTITY BRF84B_ENTITY = new BRF84B_ENTITY();
					BRF84B_ENTITY.setPart((String) BRF84[0]);

					BRF84B_ENTITY.setDescription((String) BRF84[1]);
					BRF84B_ENTITY.setCountry((String) BRF84[2]);
					BRF84B_ENTITY.setNo_of_officies((BigDecimal) BRF84[3]);
					BRF84B_ENTITY.setFunded_os((BigDecimal) BRF84[4]);
					BRF84B_ENTITY.setDebit_securities((BigDecimal) BRF84[5]);
					BRF84B_ENTITY.setUnfunded_os((BigDecimal) BRF84[6]);
					BRF84B_ENTITY.setCcf_equi_unfuned_os((BigDecimal) BRF84[7]);
					BRF84B_ENTITY.setCcf_equi_funded_n_unfuned_limits((BigDecimal) BRF84[8]);
					BRF84B_ENTITY.setTotal_exposer((BigDecimal) BRF84[9]);
					BRF84B_ENTITY.setAs_of_tier1_capital((BigDecimal) BRF84[10]);
					BRF84B_ENTITY.setCredit_risk_miti_type((String) BRF84[11]);
					BRF84B_ENTITY.setCredit_risk_miti_hair_cut((BigDecimal) BRF84[12]);
					BRF84B_ENTITY.setCollateral_hair_cut((BigDecimal) BRF84[13]);
					BRF84B_ENTITY.setCbuae_class((String) BRF84[14]);
					BRF84B_ENTITY.setProvision((BigDecimal) BRF84[15]);
					BRF84B_ENTITY.setRemarks((String) BRF84[16]);
					/*
					 * BRF84B_ENTITY.setFundedos_total ((BigDecimal) BRF84[17]);
					 * BRF84B_ENTITY.setDebtsecurity_total ((BigDecimal) BRF84[18]);
					 * BRF84B_ENTITY.setUnfunded_total ((BigDecimal) BRF84[19]);
					 * BRF84B_ENTITY.setCcfeqi_unfund_total ((BigDecimal) BRF84[20]);
					 * BRF84B_ENTITY.setCcf_eqi_limit_total ((BigDecimal) BRF84[21]);
					 * BRF84B_ENTITY.setTotal_exposure_total ((BigDecimal) BRF84[22]);
					 * BRF84B_ENTITY.setColumn4 ((BigDecimal) BRF84[23]);
					 * BRF84B_ENTITY.setCredit_risk_haircut_total ((BigDecimal) BRF84[24]);
					 * BRF84B_ENTITY.setCollateralvalue_total ((BigDecimal) BRF84[25]);
					 * BRF84B_ENTITY.setProvision_total ((BigDecimal) BRF84[26]);
					 * BRF84B_ENTITY.setRow_label((String)BRF84[27]);
					 */
					sectiond.add(BRF84B_ENTITY);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("RR/BRF84");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T2rep);
		System.out.println(sectionc);
		mv.addObject("sectionc", sectionc);

		mv.addObject("sectiond", sectiond);
		mv.addObject("getfundc", findentity2.getfundc(todate));
		mv.addObject("getfundd", findentity2.getfundd(todate));
		mv.addObject("getdebtc", findentity2.getdebtc(todate));
		mv.addObject("getdebtd", findentity2.getdebtd(todate));

		mv.addObject("getunfundc", findentity2.getunfundc(todate));
		mv.addObject("getunfundd", findentity2.getunfundd(todate));
		mv.addObject("getccfundc", findentity2.getccfundc(todate));
		mv.addObject("getccfundd", findentity2.getccfundd(todate));

		mv.addObject("getccfundlimitc", findentity2.getccfundlimitc(todate));
		mv.addObject("getccfundlimitd", findentity2.getccfundlimitd(todate));

		mv.addObject("getcredithaircutc", findentity2.getcredithaircutc(todate));
		mv.addObject("getcredithaircutd", findentity2.getcredithaircutd(todate));
		mv.addObject("getcollatralc", findentity2.getcollatralc(todate));
		mv.addObject("getcollaterald", findentity2.getcollaterald(todate));
		mv.addObject("getprovisionc", findentity2.getprovisionc(todate));
		mv.addObject("getprovisiond", findentity2.getprovisiond(todate));
		/*
		 * part c BigDecimal funded_os = findentity2.getfundc(todate) != null ? new
		 * BigDecimal(findentity2.getfundc(todate)) : BigDecimal.ZERO; BigDecimal
		 * debit_securities = findentity2.getdebtc(todate) != null ? new
		 * BigDecimal(findentity2.getdebtc(todate)) : BigDecimal.ZERO; BigDecimal
		 * CCF_EQUI_UNFUNED_OS = findentity2.getccfundc(todate) != null ? new
		 * BigDecimal(findentity2.getccfundc(todate)) : BigDecimal.ZERO; BigDecimal
		 * ccf_equi_funded_n_unfuned_limits = findentity2.getccfundlimitc(todate) !=
		 * null ? new BigDecimal(findentity2.getccfundlimitc(todate)) : BigDecimal.ZERO;
		 * 
		 * BigDecimal total_exposerc =
		 * funded_os.add(debit_securities).add(CCF_EQUI_UNFUNED_OS).add(
		 * ccf_equi_funded_n_unfuned_limits); mv.addObject("total_exposerc",
		 * total_exposerc);
		 * 
		 * // Fetching the value of getTier1_capital String getTier1_capital =
		 * findentity2.getTier1_capital(todate); String getEntity_level =
		 * findentity2.getEntity_level(todate);
		 * 
		 * // Adding total_exposer and getTier1_capital to the ModelAndView
		 * mv.addObject("getTier1_capital", getTier1_capital);
		 * mv.addObject("getEntity_level", getEntity_level);
		 * 
		 * BigDecimal as_of_tier1_capitalc; if
		 * (getTier1_capital.equals(BigDecimal.ZERO)) { as_of_tier1_capitalc =
		 * BigDecimal.ZERO; } else { as_of_tier1_capitalc = total_exposerc.divide(new
		 * BigDecimal(getTier1_capital), MathContext.DECIMAL128); }
		 * 
		 * // Adding expressionResult to the ModelAndView
		 * mv.addObject("as_of_tier1_capitalc", as_of_tier1_capitalc);
		 */

		BigDecimal funded_os = findentity2.getfundd(todate) != null ? new BigDecimal(findentity2.getfundd(todate))
				: BigDecimal.ZERO;
		BigDecimal debit_securities = findentity2.getdebtc(todate) != null
				? new BigDecimal(findentity2.getdebtd(todate))
				: BigDecimal.ZERO;
		BigDecimal CCF_EQUI_UNFUNED_OS = findentity2.getccfundd(todate) != null
				? new BigDecimal(findentity2.getccfundd(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equi_funded_n_unfuned_limits = findentity2.getccfundlimitd(todate) != null
				? new BigDecimal(findentity2.getccfundlimitd(todate))
				: BigDecimal.ZERO;

		BigDecimal total_exposerd = funded_os.add(debit_securities).add(CCF_EQUI_UNFUNED_OS)
				.add(ccf_equi_funded_n_unfuned_limits);
		mv.addObject("total_exposerd", total_exposerd);

		// Fetching the value of getTier1_capital
		String getTier1_capital = findentity2.getTier1_capital(todate);
		String getEntity_level = findentity2.getEntity_level(todate);

		// Adding total_exposer and getTier1_capital to the ModelAndView
		mv.addObject("getTier1_capital", getTier1_capital);
		mv.addObject("getEntity_level", getEntity_level);

		BigDecimal as_of_tier1_capitald;
		if (getTier1_capital.equals(BigDecimal.ZERO)) {
			as_of_tier1_capitald = BigDecimal.ZERO;
		} else {
			as_of_tier1_capitald = total_exposerd.divide(new BigDecimal(getTier1_capital), MathContext.DECIMAL128);
		}

		// Adding expressionResult to the ModelAndView
		mv.addObject("as_of_tier1_capitald", as_of_tier1_capitald);

		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF84Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF84_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF84_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF84_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF84_DETAIL_ENTITY> T1Master = new ArrayList<BRF84_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF84_DETAIL_ENTITY a where a.report_date = ?1", BRF84_DETAIL_ENTITY.class)
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
			String acct_crncy_code = (String) a[3];
			String gl_code = (String) a[4];
			String gl_sub_head_code = (String) a[5];
			String schm_code = (String) a[6];
			String schm_type = (String) a[7];
			String sol_id = (String) a[8];
			String acid = (String) a[9];
			String bacid = (String) a[10];
			String report_name_1 = (String) a[11];
			String report_label_1 = (String) a[12];
			String report_addl_criteria_1 = (String) a[13];
			String report_addl_criteria_2 = (String) a[14];
			String report_addl_criteria_3 = (String) a[15];
			String create_user = (String) a[16];
			Date create_time = (Date) a[17];
			String modify_user = (String) a[18];
			Date modify_time = (Date) a[19];
			String verify_user = (String) a[20];
			Date verify_time = (Date) a[21];
			String entity_flg = (String) a[22];
			String modify_flg = (String) a[23];
			String del_flg = (String) a[24];
			Date report_date = (Date) a[25];
			String version = (String) a[26];
			String remarks = (String) a[27];
			String legal_entity_type = (String) a[28];
			String constitution_desc = (String) a[29];
			String segment = (String) a[30];
			String sub_segment = (String) a[31];
			BigDecimal sector = (BigDecimal) a[32];
			String sub_sector = (String) a[33];
			String group_id = (String) a[34];
			String purpose_of_advn = (String) a[35];
			String gl_sub_head_desc = (String) a[36];
			String sector_code = (String) a[37];
			BigDecimal hni_networth = (BigDecimal) a[38];
			String turnover = (String) a[39];
			String maturity_date = (String) a[40];
			String country_of_incorp = (String) a[41];
			String nre_status = (String) a[42];
			String constitution_code = (String) a[43];
			String cust_type = (String) a[44];
			String country = (String) a[45];
			String gender = (String) a[46];
			BigDecimal eab_lc = (BigDecimal) a[47];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[48];

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
			BRF84_DETAIL_ENTITY py = new BRF84_DETAIL_ENTITY(cust_id, foracid, acct_name, acct_crncy_code, gl_code,
					gl_sub_head_code, schm_code, schm_type, sol_id, acid, bacid, report_name_1, report_label_1,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
					modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, report_date,
					version, Remarks1, legal_entity_type, constitution_desc, segment, sub_segment, sector, sub_sector,
					group_id, purpose_of_advn, gl_sub_head_desc, sector_code, hni_networth, turnover, maturity_date,
					country_of_incorp, nre_status, constitution_code, cust_type, country, gender, eab_lc,
					act_balance_amt_lc);

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

		mv.setViewName("RR" + "/" + "BRF84::reportcontent");
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
		File outputFile = null;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-084-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF84_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF84_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF84.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF84.jrxml");
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
				List<BRF84A_ENTITY> T1Master = new ArrayList<>();
				List<Object[]> T2rep = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs
							.createQuery("from BRF84A_ENTITY a where a.report_date = :reportDate", BRF84A_ENTITY.class)
							.setParameter("reportDate", d1).getResultList();

					T2rep = findentity2.findallvalues(todate);

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-084-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					Sheet sheet = workbook.getSheetAt(0);

					if (T1Master.size() == 1) {
						for (BRF84A_ENTITY brf84A : T1Master) {

							Row row = sheet.getRow(7);
							Cell cell = row.getCell(3);
							if (cell != null) {
								cell.setCellValue(
										brf84A.getTier_1_capital() == null ? 0 : brf84A.getTier_1_capital().intValue());
							}
							Cell cell1 = row.getCell(6);
							if (cell1 != null) {
								cell1.setCellValue(
										brf84A.getEntity_level() == null ? 0 : brf84A.getEntity_level().intValue());
							}

						}
					}
					if (T1Master.size() == 1) {
						for (BRF84A_ENTITY brf84 : T1Master) {

							Row row = sheet.getRow(10);
							Cell cell = row.getCell(4);
							if (cell != null) {
								cell.setCellValue(brf84.getR1_no_of_offices() == null ? 0
										: brf84.getR1_no_of_offices().intValue());
							}
							Cell cell1 = row.getCell(5);
							if (cell1 != null) {
								cell1.setCellValue(
										brf84.getR1_funded_os() == null ? 0 : brf84.getR1_funded_os().intValue());
							}

							Cell cell2 = row.getCell(6);
							if (cell2 != null) {
								cell2.setCellValue(brf84.getR1_debit_securities() == null ? 0
										: brf84.getR1_debit_securities().intValue());
							}

							Cell cell3 = row.getCell(13);
							if (cell3 != null) {
								cell3.setCellValue(brf84.getR1_credit_risk_cut() == null ? 0
										: brf84.getR1_credit_risk_cut().intValue());
							}
							Cell cell4 = row.getCell(14);
							if (cell4 != null) {
								cell4.setCellValue(brf84.getR1_collateral_cut() == null ? 0
										: brf84.getR1_collateral_cut().intValue());
							}

							Cell cell5 = row.getCell(16);
							if (cell5 != null) {
								cell5.setCellValue(
										brf84.getR1_provision() == null ? 0 : brf84.getR1_provision().intValue());
							}
							Row R2row = sheet.getRow(11);

							Cell R2R2cell = R2row.getCell(4);
							if (R2R2cell != null) {
								R2R2cell.setCellValue(brf84.getR2_no_of_offices() == null ? 0
										: brf84.getR2_no_of_offices().intValue());
							}
							Cell R2cell1 = R2row.getCell(5);
							if (R2cell1 != null) {
								R2cell1.setCellValue(
										brf84.getR2_funded_os() == null ? 0 : brf84.getR2_funded_os().intValue());
							}

							Cell R2cell2 = R2row.getCell(6);
							if (R2cell2 != null) {
								R2cell2.setCellValue(brf84.getR2_debit_securities() == null ? 0
										: brf84.getR2_debit_securities().intValue());
							}

							Cell R2cell3 = R2row.getCell(13);
							if (R2cell3 != null) {
								R2cell3.setCellValue(brf84.getR2_credit_risk_cut() == null ? 0
										: brf84.getR2_credit_risk_cut().intValue());
							}
							Cell R2cell4 = R2row.getCell(14);
							if (R2cell4 != null) {
								R2cell4.setCellValue(brf84.getR2_collateral_cut() == null ? 0
										: brf84.getR2_collateral_cut().intValue());
							}

							Cell R2cell5 = R2row.getCell(16);
							if (R2cell5 != null) {
								R2cell5.setCellValue(
										brf84.getR2_provision() == null ? 0 : brf84.getR2_provision().intValue());
							}
							Row R3row = sheet.getRow(12);
							Cell R3cell = R3row.getCell(4);
							if (R3cell != null) {
								R3cell.setCellValue(brf84.getR3_no_of_offices() == null ? 0
										: brf84.getR3_no_of_offices().intValue());
							}
							Cell R3cell1 = R3row.getCell(5);
							if (R3cell1 != null) {
								R3cell1.setCellValue(
										brf84.getR3_funded_os() == null ? 0 : brf84.getR3_funded_os().intValue());
							}

							Cell R3cell2 = R3row.getCell(6);
							if (R3cell2 != null) {
								R3cell2.setCellValue(brf84.getR3_debit_securities() == null ? 0
										: brf84.getR3_debit_securities().intValue());
							}

							Cell R3cell3 = R3row.getCell(13);
							if (R3cell3 != null) {
								R3cell3.setCellValue(brf84.getR3_credit_risk_cut() == null ? 0
										: brf84.getR3_credit_risk_cut().intValue());
							}
							Cell R3cell4 = R3row.getCell(14);
							if (R3cell4 != null) {
								R3cell4.setCellValue(brf84.getR3_collateral_cut() == null ? 0
										: brf84.getR3_collateral_cut().intValue());
							}

							Cell R3cell5 = R3row.getCell(16);
							if (R3cell5 != null) {
								R3cell5.setCellValue(
										brf84.getR3_provision() == null ? 0 : brf84.getR3_provision().intValue());
							}
							Row R4row = sheet.getRow(13);
							Cell R4cell = R4row.getCell(4);
							if (R4cell != null) {
								R4cell.setCellValue(brf84.getR4_no_of_offices() == null ? 0
										: brf84.getR4_no_of_offices().intValue());
							}
							Cell R4cell1 = R4row.getCell(5);
							if (R4cell1 != null) {
								R4cell1.setCellValue(
										brf84.getR4_funded_os() == null ? 0 : brf84.getR4_funded_os().intValue());
							}

							Cell R4cell2 = R4row.getCell(6);
							if (R4cell2 != null) {
								R4cell2.setCellValue(brf84.getR4_debit_securities() == null ? 0
										: brf84.getR4_debit_securities().intValue());
							}

							Cell R4cell3 = R4row.getCell(13);
							if (R4cell3 != null) {
								R4cell3.setCellValue(brf84.getR4_credit_risk_cut() == null ? 0
										: brf84.getR4_credit_risk_cut().intValue());
							}
							Cell R4cell4 = R4row.getCell(14);
							if (R4cell4 != null) {
								R4cell4.setCellValue(brf84.getR4_collateral_cut() == null ? 0
										: brf84.getR4_collateral_cut().intValue());
							}

							Cell R4cell5 = R4row.getCell(16);
							if (R4cell5 != null) {
								R4cell5.setCellValue(
										brf84.getR4_provision() == null ? 0 : brf84.getR4_provision().intValue());
							}
							/// TABLE 2
							Row R6row = sheet.getRow(16);
							Cell R6cell = R6row.getCell(4);
							if (R6cell != null) {
								R6cell.setCellValue(brf84.getR6_no_of_offices() == null ? 0
										: brf84.getR6_no_of_offices().intValue());
							}
							Cell R6cell1 = R6row.getCell(7);
							if (R6cell1 != null) {
								R6cell1.setCellValue(
										brf84.getR6_unfunded_os() == null ? 0 : brf84.getR6_unfunded_os().intValue());
							}

							Cell R6cell2 = R6row.getCell(8);
							if (R6cell2 != null) {
								R6cell2.setCellValue(brf84.getR6_ccf_equivalent_of_unfunded_os() == null ? 0
										: brf84.getR6_ccf_equivalent_of_unfunded_os().intValue());
							}
							Cell R6cell5 = R6row.getCell(9);
							if (R6cell5 != null) {
								R6cell5.setCellValue(brf84.getR6_ccf_equivalent_limits() == null ? 0
										: brf84.getR6_ccf_equivalent_limits().intValue());
							}
							Cell R6cell3 = R6row.getCell(13);
							if (R6cell3 != null) {
								R6cell3.setCellValue(brf84.getR6_credit_risk_cut() == null ? 0
										: brf84.getR6_credit_risk_cut().intValue());
							}
							Cell R6cell4 = R6row.getCell(14);
							if (R6cell4 != null) {
								R6cell4.setCellValue(brf84.getR6_collateral_cut() == null ? 0
										: brf84.getR6_collateral_cut().intValue());
							}

							Cell R6cell15 = R6row.getCell(16);
							if (R6cell15 != null) {
								R6cell15.setCellValue(
										brf84.getR6_provision() == null ? 0 : brf84.getR6_provision().intValue());
							}
							Row R7row = sheet.getRow(17);
							Cell R7cell = R7row.getCell(4);
							if (R7cell != null) {
								R7cell.setCellValue(brf84.getR7_no_of_offices() == null ? 0
										: brf84.getR7_no_of_offices().intValue());
							}
							Cell R7cell1 = R7row.getCell(7);
							if (R7cell1 != null) {
								R7cell1.setCellValue(
										brf84.getR7_unfunded_os() == null ? 0 : brf84.getR7_unfunded_os().intValue());
							}

							Cell R7cell2 = R7row.getCell(8);
							if (R7cell2 != null) {
								R7cell2.setCellValue(brf84.getR7_ccf_equivalent_of_unfunded_os() == null ? 0
										: brf84.getR7_ccf_equivalent_of_unfunded_os().intValue());
							}
							Cell R7cell5 = R7row.getCell(9);
							if (R7cell5 != null) {
								R7cell5.setCellValue(brf84.getR7_ccf_equivalent_limits() == null ? 0
										: brf84.getR7_ccf_equivalent_limits().intValue());
							}
							Cell R7cell3 = R7row.getCell(13);
							if (R7cell3 != null) {
								R7cell3.setCellValue(brf84.getR7_credit_risk_cut() == null ? 0
										: brf84.getR7_credit_risk_cut().intValue());
							}
							Cell R7cell4 = R7row.getCell(14);
							if (R7cell4 != null) {
								R7cell4.setCellValue(brf84.getR7_collateral_cut() == null ? 0
										: brf84.getR7_collateral_cut().intValue());
							}

							Cell R7cell15 = R7row.getCell(16);
							if (R7cell15 != null) {
								R7cell15.setCellValue(
										brf84.getR7_provision() == null ? 0 : brf84.getR7_provision().intValue());
							}
							Row R8row = sheet.getRow(18);
							Cell R8cell = R8row.getCell(4);
							if (R8cell != null) {
								R8cell.setCellValue(brf84.getR8_no_of_offices() == null ? 0
										: brf84.getR8_no_of_offices().intValue());
							}
							Cell R8cell1 = R8row.getCell(7);
							if (R8cell1 != null) {
								R8cell1.setCellValue(
										brf84.getR8_unfunded_os() == null ? 0 : brf84.getR8_unfunded_os().intValue());
							}

							Cell R8cell2 = R8row.getCell(8);
							if (R8cell2 != null) {
								R8cell2.setCellValue(brf84.getR8_ccf_equivalent_of_unfunded_os() == null ? 0
										: brf84.getR8_ccf_equivalent_of_unfunded_os().intValue());
							}
							Cell R8cell5 = R8row.getCell(9);
							if (R8cell5 != null) {
								R8cell5.setCellValue(brf84.getR8_ccf_equivalent_limits() == null ? 0
										: brf84.getR8_ccf_equivalent_limits().intValue());
							}
							Cell R8cell3 = R8row.getCell(13);
							if (R8cell3 != null) {
								R8cell3.setCellValue(brf84.getR8_credit_risk_cut() == null ? 0
										: brf84.getR8_credit_risk_cut().intValue());
							}
							Cell R8cell4 = R8row.getCell(14);
							if (R8cell4 != null) {
								R8cell4.setCellValue(brf84.getR8_collateral_cut() == null ? 0
										: brf84.getR8_collateral_cut().intValue());
							}

							Cell R8cell15 = R8row.getCell(16);
							if (R8cell15 != null) {
								R8cell15.setCellValue(
										brf84.getR8_provision() == null ? 0 : brf84.getR8_provision().intValue());
							}
							Row R9row = sheet.getRow(19);
							Cell R9cell = R9row.getCell(4);
							if (R9cell != null) {
								R9cell.setCellValue(brf84.getR9_no_of_offices() == null ? 0
										: brf84.getR9_no_of_offices().intValue());
							}
							Cell R9cell1 = R9row.getCell(7);
							if (R9cell1 != null) {
								R9cell1.setCellValue(
										brf84.getR9_unfunded_os() == null ? 0 : brf84.getR9_unfunded_os().intValue());
							}

							Cell R9cell2 = R9row.getCell(8);
							if (R9cell2 != null) {
								R9cell2.setCellValue(brf84.getR9_ccf_equivalent_of_unfunded_os() == null ? 0
										: brf84.getR9_ccf_equivalent_of_unfunded_os().intValue());
							}
							Cell R9cell5 = R9row.getCell(9);
							if (R9cell5 != null) {
								R9cell5.setCellValue(brf84.getR9_ccf_equivalent_limits() == null ? 0
										: brf84.getR9_ccf_equivalent_limits().intValue());
							}
							Cell R9cell3 = R9row.getCell(13);
							if (R9cell3 != null) {
								R9cell3.setCellValue(brf84.getR9_credit_risk_cut() == null ? 0
										: brf84.getR9_credit_risk_cut().intValue());
							}
							Cell R9cell4 = R9row.getCell(14);
							if (R9cell4 != null) {
								R9cell4.setCellValue(brf84.getR9_collateral_cut() == null ? 0
										: brf84.getR9_collateral_cut().intValue());
							}

							Cell R9cell15 = R9row.getCell(16);
							if (R9cell15 != null) {
								R9cell15.setCellValue(
										brf84.getR9_provision() == null ? 0 : brf84.getR9_provision().intValue());
							}
						}
					}

					/*
					 * if (!T2rep.isEmpty()) { int startRow = 22; // Starting row index
					 * System.out.println("T2rep size: " + T2rep.size());
					 * 
					 * for (int index = 0; index < T2rep.size(); index++) { Object[] BRF84 =
					 * T2rep.get(index); Row row = sheet.getRow(startRow + index); if (row == null)
					 * { row = sheet.createRow(startRow + index);
					 * 
					 * Cell cell = row.getCell(2); if (cell == null) { cell = row.createCell(2); }
					 * 
					 * String value = (BRF84[1] == null) ? "NA" : BRF84[1].toString();
					 * cell.setCellValue(value);
					 * 
					 * Cell cell1 = row.getCell(3); if (cell1 == null) { cell1 = row.createCell(3);
					 * } String value1 = (BRF84[2] == null) ? "NA" : BRF84[2].toString();
					 * cell1.setCellValue(value1);
					 * 
					 * Cell cell6 = row.getCell(4); if (cell6 == null) { cell6 = row.createCell(4);
					 * }
					 * 
					 * cell6.setCellValue(BRF84[3] == null ? 0 : ((BigDecimal)
					 * BRF84[3]).intValue());
					 * 
					 * Cell cell61 = row.getCell(5); if (cell61 == null) { cell61 =
					 * row.createCell(5); }
					 * 
					 * cell61.setCellValue(BRF84[4] == null ? 0 : ((BigDecimal)
					 * BRF84[4]).intValue());
					 * 
					 * Cell cell26 = row.getCell(6); if (cell26 == null) { cell26 =
					 * row.createCell(6); }
					 * 
					 * cell26.setCellValue(BRF84[5] == null ? 0 : ((BigDecimal)
					 * BRF84[5]).intValue()); Cell cell36 = row.getCell(7); if (cell36 == null) {
					 * cell36 = row.createCell(7); }
					 * 
					 * cell36.setCellValue(BRF84[6] == null ? 0 : ((BigDecimal)
					 * BRF84[6]).intValue());
					 * 
					 * Cell cell46 = row.getCell(8); if (cell46 == null) { cell46 =
					 * row.createCell(8); }
					 * 
					 * cell46.setCellValue(BRF84[7] == null ? 0 : ((BigDecimal)
					 * BRF84[7]).intValue());
					 * 
					 * Cell cell56 = row.getCell(9); if (cell56 == null) { cell56 =
					 * row.createCell(9); }
					 * 
					 * cell56.setCellValue(BRF84[8] == null ? 0 : ((BigDecimal)
					 * BRF84[8]).intValue());
					 * 
					 * Cell cell12 = row.getCell(12); if (cell12 == null) { cell12 =
					 * row.createCell(12); }
					 * 
					 * String value12 = (BRF84[11] == null) ? "NA" : BRF84[11].toString();
					 * cell12.setCellValue(value12);
					 * 
					 * Cell cell156 = row.getCell(13); if (cell156 == null) { cell156 =
					 * row.createCell(13); }
					 * 
					 * cell156.setCellValue(BRF84[12] == null ? 0 : ((BigDecimal)
					 * BRF84[12]).intValue());
					 * 
					 * Cell cell526 = row.getCell(14); if (cell526 == null) { cell526 =
					 * row.createCell(14); }
					 * 
					 * cell526.setCellValue(BRF84[13] == null ? 0 : ((BigDecimal)
					 * BRF84[13]).intValue());
					 * 
					 * Cell cell112 = row.getCell(15); if (cell112 == null) { cell112 =
					 * row.createCell(15); }
					 * 
					 * String value112 = (BRF84[14] == null) ? "NA" : BRF84[14].toString();
					 * cell112.setCellValue(value112);
					 * 
					 * Cell cell226 = row.getCell(16); if (cell226 == null) { cell226 =
					 * row.createCell(16); }
					 * 
					 * cell226.setCellValue(BRF84[15] == null ? 0 : ((BigDecimal)
					 * BRF84[15]).intValue());
					 * 
					 * Cell cell1112 = row.getCell(17); if (cell1112 == null) { cell1112 =
					 * row.createCell(17); }
					 * 
					 * String value1112 = (BRF84[16] == null) ? "NA" : BRF84[16].toString();
					 * cell1112.setCellValue(value1112);
					 * 
					 * 
					 * }}
					 */

					// Update Table 2
					updateTable2(sheet, T2rep);
					updateTable3(sheet, T2rep);
					// Write to final output file
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					try (FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-084-A.xls")) {
						workbook.write(fileOut);
					}
					workbook.close();

					path = env.getProperty("output.exportpathfinal") + "011-BRF-084-A.xls";
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

	private void updateTable3(Sheet sheet, List<Object[]> T2rep) {
		int startRow = 73;
		for (int index = 0; index < T2rep.size(); index++) {
			Object[] BRF84 = T2rep.get(index);
			if ("PART D".equals(BRF84[0])) {
				Row row = sheet.getRow(startRow + index);
				if (row == null) {
					row = sheet.createRow(startRow + index);
				}
				Cell cell = row.getCell(2);
				if (cell == null) {
					cell = row.createCell(2);
				}

				String value = (BRF84[1] == null) ? "NA" : BRF84[1].toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 == null) {
					cell1 = row.createCell(3);
				}
				String value1 = (BRF84[2] == null) ? "NA" : BRF84[2].toString();
				cell1.setCellValue(value1);

				Cell cell6 = row.getCell(4);
				if (cell6 == null) {
					cell6 = row.createCell(4);
				}

				cell6.setCellValue(BRF84[3] == null ? 0 : ((BigDecimal) BRF84[3]).intValue());

				Cell cell61 = row.getCell(5);
				if (cell61 == null) {
					cell61 = row.createCell(5);
				}

				cell61.setCellValue(BRF84[4] == null ? 0 : ((BigDecimal) BRF84[4]).intValue());

				Cell cell26 = row.getCell(6);
				if (cell26 == null) {
					cell26 = row.createCell(6);
				}

				cell26.setCellValue(BRF84[5] == null ? 0 : ((BigDecimal) BRF84[5]).intValue());
				Cell cell36 = row.getCell(7);
				if (cell36 == null) {
					cell36 = row.createCell(7);
				}

				cell36.setCellValue(BRF84[6] == null ? 0 : ((BigDecimal) BRF84[6]).intValue());

				Cell cell46 = row.getCell(8);
				if (cell46 == null) {
					cell46 = row.createCell(8);
				}

				cell46.setCellValue(BRF84[7] == null ? 0 : ((BigDecimal) BRF84[7]).intValue());

				Cell cell56 = row.getCell(9);
				if (cell56 == null) {
					cell56 = row.createCell(9);
				}

				cell56.setCellValue(BRF84[8] == null ? 0 : ((BigDecimal) BRF84[8]).intValue());

				Cell cell12 = row.getCell(12);
				if (cell12 == null) {
					cell12 = row.createCell(12);
				}

				String value12 = (BRF84[11] == null) ? "NA" : BRF84[11].toString();
				cell12.setCellValue(value12);

				Cell cell156 = row.getCell(13);
				if (cell156 == null) {
					cell156 = row.createCell(13);
				}

				cell156.setCellValue(BRF84[12] == null ? 0 : ((BigDecimal) BRF84[12]).intValue());

				Cell cell526 = row.getCell(14);
				if (cell526 == null) {
					cell526 = row.createCell(14);
				}

				cell526.setCellValue(BRF84[13] == null ? 0 : ((BigDecimal) BRF84[13]).intValue());

				Cell cell112 = row.getCell(15);
				if (cell112 == null) {
					cell112 = row.createCell(15);
				}

				String value112 = (BRF84[14] == null) ? "NA" : BRF84[14].toString();
				cell112.setCellValue(value112);

				Cell cell226 = row.getCell(16);
				if (cell226 == null) {
					cell226 = row.createCell(16);
				}

				cell226.setCellValue(BRF84[15] == null ? 0 : ((BigDecimal) BRF84[15]).intValue());

				Cell cell1112 = row.getCell(17);
				if (cell1112 == null) {
					cell1112 = row.createCell(17);
				}

				String value1112 = (BRF84[16] == null) ? "NA" : BRF84[16].toString();
				cell1112.setCellValue(value1112);

			}
		}
	}

	private void updateTable2(Sheet sheet, List<Object[]> T2rep) {
		int startRow = 22;
		for (int index = 0; index < T2rep.size(); index++) {
			Object[] BRF84 = T2rep.get(index);
			if ("PART C".equals(BRF84[0])) {
				Row row = sheet.getRow(startRow + index);
				if (row == null) {
					row = sheet.createRow(startRow + index);
				}
				Cell cell = row.getCell(2);
				if (cell == null) {
					cell = row.createCell(2);
				}

				String value = (BRF84[1] == null) ? "NA" : BRF84[1].toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 == null) {
					cell1 = row.createCell(3);
				}
				String value1 = (BRF84[2] == null) ? "NA" : BRF84[2].toString();
				cell1.setCellValue(value1);

				Cell cell6 = row.getCell(4);
				if (cell6 == null) {
					cell6 = row.createCell(4);
				}

				cell6.setCellValue(BRF84[3] == null ? 0 : ((BigDecimal) BRF84[3]).intValue());

				Cell cell61 = row.getCell(5);
				if (cell61 == null) {
					cell61 = row.createCell(5);
				}

				cell61.setCellValue(BRF84[4] == null ? 0 : ((BigDecimal) BRF84[4]).intValue());

				Cell cell26 = row.getCell(6);
				if (cell26 == null) {
					cell26 = row.createCell(6);
				}

				cell26.setCellValue(BRF84[5] == null ? 0 : ((BigDecimal) BRF84[5]).intValue());
				Cell cell36 = row.getCell(7);
				if (cell36 == null) {
					cell36 = row.createCell(7);
				}

				cell36.setCellValue(BRF84[6] == null ? 0 : ((BigDecimal) BRF84[6]).intValue());

				Cell cell46 = row.getCell(8);
				if (cell46 == null) {
					cell46 = row.createCell(8);
				}

				cell46.setCellValue(BRF84[7] == null ? 0 : ((BigDecimal) BRF84[7]).intValue());

				Cell cell56 = row.getCell(9);
				if (cell56 == null) {
					cell56 = row.createCell(9);
				}

				cell56.setCellValue(BRF84[8] == null ? 0 : ((BigDecimal) BRF84[8]).intValue());

				Cell cell12 = row.getCell(12);
				if (cell12 == null) {
					cell12 = row.createCell(12);
				}

				String value12 = (BRF84[11] == null) ? "NA" : BRF84[11].toString();
				cell12.setCellValue(value12);

				Cell cell156 = row.getCell(13);
				if (cell156 == null) {
					cell156 = row.createCell(13);
				}

				cell156.setCellValue(BRF84[12] == null ? 0 : ((BigDecimal) BRF84[12]).intValue());

				Cell cell526 = row.getCell(14);
				if (cell526 == null) {
					cell526 = row.createCell(14);
				}

				cell526.setCellValue(BRF84[13] == null ? 0 : ((BigDecimal) BRF84[13]).intValue());

				Cell cell112 = row.getCell(15);
				if (cell112 == null) {
					cell112 = row.createCell(15);
				}

				String value112 = (BRF84[14] == null) ? "NA" : BRF84[14].toString();
				cell112.setCellValue(value112);

				Cell cell226 = row.getCell(16);
				if (cell226 == null) {
					cell226 = row.createCell(16);
				}

				cell226.setCellValue(BRF84[15] == null ? 0 : ((BigDecimal) BRF84[15]).intValue());

				Cell cell1112 = row.getCell(17);
				if (cell1112 == null) {
					cell1112 = row.createCell(17);
				}

				String value1112 = (BRF84[16] == null) ? "NA" : BRF84[16].toString();
				cell1112.setCellValue(value1112);

			}
		}
	}

	public String detailChanges84(BRF84_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {
			// Get the current Hibernate session
			Session hs = sessionFactory.getCurrentSession();

			// Find the BRF84_DETAIL_ENTITY object by its foracid
			Optional<BRF84_DETAIL_ENTITY> brf84DetailOptional = brf84_detailrepo.findById(foracid);

			if (brf84DetailOptional.isPresent()) {
				BRF84_DETAIL_ENTITY brfDetail = brf84DetailOptional.get();
				if (brfDetail != null && report_label_1 != null && report_name_1 != null
						&& report_addl_criteria_1 != null) {
					if (act_balance_amt_lc.equals(brfDetail.getAct_balance_amt_lc())
							&& report_label_1.equals(brfDetail.getReport_label_1())
							&& report_name_1.equals(brfDetail.getReport_name_1())
							&& report_addl_criteria_1.equals(brfDetail.getReport_addl_criteria_1())) {
						msg = "No modification done";
					} else {
						// Update the BRF84_DETAIL_ENTITY object with the provided parameters
						brfDetail.setAct_balance_amt_lc(act_balance_amt_lc);
						brfDetail.setReport_label_1(report_label_1);
						brfDetail.setReport_name_1(report_name_1);
						brfDetail.setReport_addl_criteria_1(report_addl_criteria_1);

						// Save the updated object
						brf84_detailrepo.save(brfDetail);

						// Log the action
						logger.info("Edited Record");
						msg = "Edited Successfully";
					}
				} else {
					msg = "Some parameters are null";
				}
			} else {
				msg = "No data Found";
			}

		} catch (Exception e) {
			// Handle any exceptions
			msg = "An error occurred. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;
	}

	public ModelAndView getArchieveBRF084View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF84A_ENTITY> T1rep = new ArrayList<BRF84A_ENTITY>();

		List<BRF84A_ENTITY> T1Master = new ArrayList<BRF84A_ENTITY>();
		List<Object[]> T2rep = new ArrayList<Object[]>();

		List<BRF84B_ENTITY> sectionc = new ArrayList<BRF84B_ENTITY>();
		List<BRF84B_ENTITY> sectiond = new ArrayList<BRF84B_ENTITY>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);

			T1Master = hs.createQuery("from BRF84A_ENTITY a where a.report_date = ?1 ", BRF84A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
			T2rep = findentity2.findallvalues(todate);
			System.out.println(T2rep.toString());
			for (Object[] BRF84 : T2rep) {
				// Check if the current record is PART C or PART D
				if (BRF84[0] != null && BRF84[0].equals("PART C")) {
					// Create a new instance for each loop iteration
					BRF84B_ENTITY BRF84B_ENTITY = new BRF84B_ENTITY();

					BRF84B_ENTITY.setPart((String) BRF84[0]);

					BRF84B_ENTITY.setDescription((String) BRF84[1]);
					System.out.println(BRF84B_ENTITY.getDescription());

					BRF84B_ENTITY.setCountry((String) BRF84[2]);
					BRF84B_ENTITY.setNo_of_officies((BigDecimal) BRF84[3]);
					BRF84B_ENTITY.setFunded_os((BigDecimal) BRF84[4]);
					BRF84B_ENTITY.setDebit_securities((BigDecimal) BRF84[5]);
					BRF84B_ENTITY.setUnfunded_os((BigDecimal) BRF84[6]);
					BRF84B_ENTITY.setCcf_equi_unfuned_os((BigDecimal) BRF84[7]);
					BRF84B_ENTITY.setCcf_equi_funded_n_unfuned_limits((BigDecimal) BRF84[8]);
					BRF84B_ENTITY.setTotal_exposer((BigDecimal) BRF84[9]);
					BRF84B_ENTITY.setAs_of_tier1_capital((BigDecimal) BRF84[10]);
					BRF84B_ENTITY.setCredit_risk_miti_type((String) BRF84[11]);
					BRF84B_ENTITY.setCredit_risk_miti_hair_cut((BigDecimal) BRF84[12]);
					BRF84B_ENTITY.setCollateral_hair_cut((BigDecimal) BRF84[13]);
					BRF84B_ENTITY.setCbuae_class((String) BRF84[14]);
					BRF84B_ENTITY.setProvision((BigDecimal) BRF84[15]);
					BRF84B_ENTITY.setRemarks((String) BRF84[16]);
					/* BRF84B_ENTITY.setFundedos_total ((BigDecimal) BRF84[17]); */
					/*
					 * BRF84B_ENTITY.setDebtsecurity_total ((BigDecimal) BRF84[18]);
					 * BRF84B_ENTITY.setUnfunded_total ((BigDecimal) BRF84[19]);
					 * BRF84B_ENTITY.setCcfeqi_unfund_total ((BigDecimal) BRF84[20]);
					 * BRF84B_ENTITY.setCcf_eqi_limit_total ((BigDecimal) BRF84[21]);
					 * BRF84B_ENTITY.setTotal_exposure_total ((BigDecimal) BRF84[22]);
					 * BRF84B_ENTITY.setColumn4 ((BigDecimal) BRF84[23]);
					 * BRF84B_ENTITY.setCredit_risk_haircut_total ((BigDecimal) BRF84[24]);
					 * BRF84B_ENTITY.setCollateralvalue_total ((BigDecimal) BRF84[25]);
					 * BRF84B_ENTITY.setProvision_total ((BigDecimal) BRF84[26]);
					 * BRF84B_ENTITY.setRow_label((String)BRF84[27]);
					 */
					sectionc.add(BRF84B_ENTITY);
				} else if (BRF84[0] != null && BRF84[0].equals("PART D")) {
					BRF84B_ENTITY BRF84B_ENTITY = new BRF84B_ENTITY();
					BRF84B_ENTITY.setPart((String) BRF84[0]);

					BRF84B_ENTITY.setDescription((String) BRF84[1]);
					BRF84B_ENTITY.setCountry((String) BRF84[2]);
					BRF84B_ENTITY.setNo_of_officies((BigDecimal) BRF84[3]);
					BRF84B_ENTITY.setFunded_os((BigDecimal) BRF84[4]);
					BRF84B_ENTITY.setDebit_securities((BigDecimal) BRF84[5]);
					BRF84B_ENTITY.setUnfunded_os((BigDecimal) BRF84[6]);
					BRF84B_ENTITY.setCcf_equi_unfuned_os((BigDecimal) BRF84[7]);
					BRF84B_ENTITY.setCcf_equi_funded_n_unfuned_limits((BigDecimal) BRF84[8]);
					BRF84B_ENTITY.setTotal_exposer((BigDecimal) BRF84[9]);
					BRF84B_ENTITY.setAs_of_tier1_capital((BigDecimal) BRF84[10]);
					BRF84B_ENTITY.setCredit_risk_miti_type((String) BRF84[11]);
					BRF84B_ENTITY.setCredit_risk_miti_hair_cut((BigDecimal) BRF84[12]);
					BRF84B_ENTITY.setCollateral_hair_cut((BigDecimal) BRF84[13]);
					BRF84B_ENTITY.setCbuae_class((String) BRF84[14]);
					BRF84B_ENTITY.setProvision((BigDecimal) BRF84[15]);
					BRF84B_ENTITY.setRemarks((String) BRF84[16]);
					/*
					 * BRF84B_ENTITY.setFundedos_total ((BigDecimal) BRF84[17]);
					 * BRF84B_ENTITY.setDebtsecurity_total ((BigDecimal) BRF84[18]);
					 * BRF84B_ENTITY.setUnfunded_total ((BigDecimal) BRF84[19]);
					 * BRF84B_ENTITY.setCcfeqi_unfund_total ((BigDecimal) BRF84[20]);
					 * BRF84B_ENTITY.setCcf_eqi_limit_total ((BigDecimal) BRF84[21]);
					 * BRF84B_ENTITY.setTotal_exposure_total ((BigDecimal) BRF84[22]);
					 * BRF84B_ENTITY.setColumn4 ((BigDecimal) BRF84[23]);
					 * BRF84B_ENTITY.setCredit_risk_haircut_total ((BigDecimal) BRF84[24]);
					 * BRF84B_ENTITY.setCollateralvalue_total ((BigDecimal) BRF84[25]);
					 * BRF84B_ENTITY.setProvision_total ((BigDecimal) BRF84[26]);
					 * BRF84B_ENTITY.setRow_label((String)BRF84[27]);
					 */
					sectiond.add(BRF84B_ENTITY);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.setViewName("RR/BRF84ARCH");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T2rep);
		System.out.println(sectionc);
		mv.addObject("sectionc", sectionc);

		mv.addObject("sectiond", sectiond);
		mv.addObject("getfundc", findentity2.getfundc(todate));
		mv.addObject("getfundd", findentity2.getfundd(todate));
		mv.addObject("getdebtc", findentity2.getdebtc(todate));
		mv.addObject("getdebtd", findentity2.getdebtd(todate));

		mv.addObject("getunfundc", findentity2.getunfundc(todate));
		mv.addObject("getunfundd", findentity2.getunfundd(todate));
		mv.addObject("getccfundc", findentity2.getccfundc(todate));
		mv.addObject("getccfundd", findentity2.getccfundd(todate));

		mv.addObject("getccfundlimitc", findentity2.getccfundlimitc(todate));
		mv.addObject("getccfundlimitd", findentity2.getccfundlimitd(todate));

		mv.addObject("getcredithaircutc", findentity2.getcredithaircutc(todate));
		mv.addObject("getcredithaircutd", findentity2.getcredithaircutd(todate));
		mv.addObject("getcollatralc", findentity2.getcollatralc(todate));
		mv.addObject("getcollaterald", findentity2.getcollaterald(todate));
		mv.addObject("getprovisionc", findentity2.getprovisionc(todate));
		mv.addObject("getprovisiond", findentity2.getprovisiond(todate));
		/*
		 * part c BigDecimal funded_os = findentity2.getfundc(todate) != null ? new
		 * BigDecimal(findentity2.getfundc(todate)) : BigDecimal.ZERO; BigDecimal
		 * debit_securities = findentity2.getdebtc(todate) != null ? new
		 * BigDecimal(findentity2.getdebtc(todate)) : BigDecimal.ZERO; BigDecimal
		 * CCF_EQUI_UNFUNED_OS = findentity2.getccfundc(todate) != null ? new
		 * BigDecimal(findentity2.getccfundc(todate)) : BigDecimal.ZERO; BigDecimal
		 * ccf_equi_funded_n_unfuned_limits = findentity2.getccfundlimitc(todate) !=
		 * null ? new BigDecimal(findentity2.getccfundlimitc(todate)) : BigDecimal.ZERO;
		 * 
		 * BigDecimal total_exposerc =
		 * funded_os.add(debit_securities).add(CCF_EQUI_UNFUNED_OS).add(
		 * ccf_equi_funded_n_unfuned_limits); mv.addObject("total_exposerc",
		 * total_exposerc);
		 * 
		 * // Fetching the value of getTier1_capital String getTier1_capital =
		 * findentity2.getTier1_capital(todate); String getEntity_level =
		 * findentity2.getEntity_level(todate);
		 * 
		 * // Adding total_exposer and getTier1_capital to the ModelAndView
		 * mv.addObject("getTier1_capital", getTier1_capital);
		 * mv.addObject("getEntity_level", getEntity_level);
		 * 
		 * BigDecimal as_of_tier1_capitalc; if
		 * (getTier1_capital.equals(BigDecimal.ZERO)) { as_of_tier1_capitalc =
		 * BigDecimal.ZERO; } else { as_of_tier1_capitalc = total_exposerc.divide(new
		 * BigDecimal(getTier1_capital), MathContext.DECIMAL128); }
		 * 
		 * // Adding expressionResult to the ModelAndView
		 * mv.addObject("as_of_tier1_capitald", as_of_tier1_capitalc);
		 */

		BigDecimal funded_os = findentity2.getfundd(todate) != null ? new BigDecimal(findentity2.getfundd(todate))
				: BigDecimal.ZERO;
		BigDecimal debit_securities = findentity2.getdebtc(todate) != null
				? new BigDecimal(findentity2.getdebtd(todate))
				: BigDecimal.ZERO;
		BigDecimal CCF_EQUI_UNFUNED_OS = findentity2.getccfundd(todate) != null
				? new BigDecimal(findentity2.getccfundd(todate))
				: BigDecimal.ZERO;
		BigDecimal ccf_equi_funded_n_unfuned_limits = findentity2.getccfundlimitd(todate) != null
				? new BigDecimal(findentity2.getccfundlimitd(todate))
				: BigDecimal.ZERO;

		BigDecimal total_exposerd = funded_os.add(debit_securities).add(CCF_EQUI_UNFUNED_OS)
				.add(ccf_equi_funded_n_unfuned_limits);
		mv.addObject("total_exposerd", total_exposerd);

		// Fetching the value of getTier1_capital
		String getTier1_capital = findentity2.getTier1_capital(todate);
		String getEntity_level = findentity2.getEntity_level(todate);

		// Adding total_exposer and getTier1_capital to the ModelAndView
		mv.addObject("getTier1_capital", getTier1_capital);
		mv.addObject("getEntity_level", getEntity_level);

		BigDecimal as_of_tier1_capitald;
		if (getTier1_capital.equals(BigDecimal.ZERO)) {
			as_of_tier1_capitald = BigDecimal.ZERO;
		} else {
			as_of_tier1_capitald = total_exposerd.divide(new BigDecimal(getTier1_capital), MathContext.DECIMAL128);
		}

		// Adding expressionResult to the ModelAndView
		mv.addObject("as_of_tier1_capitald", as_of_tier1_capitald);

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
	public ModelAndView ARCHgetBRF084currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF84_ARCHIVTABLE a where report_date=?1 and report_label=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF84_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF84_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF84_ARCHIV_ENTITY> T1Master = new ArrayList<BRF84_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF84_ARCHIV_ENTITY a where a.report_date = ?1", BRF84_ARCHIV_ENTITY.class)
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
			String acct_crncy_code = (String) a[3];
			String gl_code = (String) a[4];
			String gl_sub_head_code = (String) a[5];
			String schm_code = (String) a[6];
			String schm_type = (String) a[7];
			String sol_id = (String) a[8];
			String acid = (String) a[9];
			String bacid = (String) a[10];
			String report_name_1 = (String) a[11];
			String report_label_1 = (String) a[12];
			String report_addl_criteria_1 = (String) a[13];
			String report_addl_criteria_2 = (String) a[14];
			String report_addl_criteria_3 = (String) a[15];
			String create_user = (String) a[16];
			Date create_time = (Date) a[17];
			String modify_user = (String) a[18];
			Date modify_time = (Date) a[19];
			String verify_user = (String) a[20];
			Date verify_time = (Date) a[21];
			String entity_flg = (String) a[22];
			String modify_flg = (String) a[23];
			String del_flg = (String) a[24];
			Date report_date = (Date) a[25];
			String version = (String) a[26];
			String remarks = (String) a[27];
			String legal_entity_type = (String) a[28];
			String constitution_desc = (String) a[29];
			String segment = (String) a[30];
			String sub_segment = (String) a[31];
			BigDecimal sector = (BigDecimal) a[32];
			String sub_sector = (String) a[33];
			String group_id = (String) a[34];
			String purpose_of_advn = (String) a[35];
			String gl_sub_head_desc = (String) a[36];
			String sector_code = (String) a[37];
			BigDecimal hni_networth = (BigDecimal) a[38];
			String turnover = (String) a[39];
			String maturity_date = (String) a[40];
			String country_of_incorp = (String) a[41];
			String nre_status = (String) a[42];
			String constitution_code = (String) a[43];
			String cust_type = (String) a[44];
			String country = (String) a[45];
			String gender = (String) a[46];
			BigDecimal eab_lc = (BigDecimal) a[47];
			BigDecimal act_balance_amt_lc = (BigDecimal) a[48];

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
			BRF84_ARCHIV_ENTITY py = new BRF84_ARCHIV_ENTITY(cust_id, foracid, acct_name, acct_crncy_code, gl_code,
					gl_sub_head_code, schm_code, schm_type, sol_id, acid, bacid, report_name_1, report_label_1,
					report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
					modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, report_date,
					version, Remarks1, legal_entity_type, constitution_desc, segment, sub_segment, sector, sub_sector,
					group_id, purpose_of_advn, gl_sub_head_desc, sector_code, hni_networth, turnover, maturity_date,
					country_of_incorp, nre_status, constitution_code, cust_type, country, gender, eab_lc,
					act_balance_amt_lc);

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

		mv.setViewName("RR" + "/" + "BRF84ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}
