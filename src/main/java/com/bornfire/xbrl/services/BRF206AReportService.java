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

import com.bornfire.xbrl.entities.BRBS.BRF106_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF106_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF200A_A1_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF200A_A2_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF200A_A3_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF200A_A4_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF206A_RPT;
import com.bornfire.xbrl.entities.BRBS.BRF206DETAIL_Repo;
import com.bornfire.xbrl.entities.BRBS.BRF206_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF206_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF_106_A_REPORT_ENTITY;
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
public class BRF206AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF206AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF206DETAIL_Repo bRF206DETAIL_Repo;

	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheck(String reportid, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF206A_RPT a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF206A_RPT a").getSingleResult();
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

	public ModelAndView getBRF206AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF206A_RPT> T1rep = new ArrayList<BRF206A_RPT>();
		// Query<Object[]> qr;

		List<BRF206A_RPT> T1Master = new ArrayList<BRF206A_RPT>();
		// List<BRF206A_A2_RPT> T1Master1 = new ArrayList<BRF206A_A2_RPT>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF206A_RPT a where a.report_date = ?1 ", BRF206A_RPT.class)
					.setParameter(1, df.parse(todate)).getResultList();
			/*
			 * T1Master1 = hs.createQuery("from BRF206A_A2_RPT a where a.report_date = ?1 ",
			 * BRF206A_A2_RPT.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF206");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		// mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF206ADetails(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF206_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF206_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF206_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF206_DETAIL_ENTITY> T1Master = new ArrayList<BRF206_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF206_DETAIL_ENTITY a where a.report_date = ?1", BRF206_DETAIL_ENTITY.class)
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

			BRF206_DETAIL_ENTITY py = new BRF206_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF206::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFileBRF206A(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-206-A";
		/*
		 * try { SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); Date
		 * ConDate = dateFormat1.parse(todate); System.out.println(ConDate);
		 * SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy"); String
		 * strDate1 = formatter1.format(ConDate); fileName = "t" + reportId + "_" +
		 * strDate1;
		 * 
		 * 
		 * } catch (ParseException e1) {
		 * 
		 * logger.info(e1.getMessage()); e1.printStackTrace(); }
		 */

		if (!filetype.equals("xbrl")) {

			if (!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF206_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF206_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF206.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF206.jrxml");
						}
					}

					// JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
					JasperReport jr = JasperCompileManager.compileReport(jasperFile);
					HashMap<String, Object> map = new HashMap<String, Object>();

					logger.info("Assigning Parameters for Jasper");
					map.put("REPORT_DATE", todate);
					/*
					 * try { SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy"); Date
					 * ConDate = dateFormat1.parse(todate); SimpleDateFormat formatter1 = new
					 * SimpleDateFormat("dd-MMM-yyyy"); String strDate1 =
					 * formatter1.format(ConDate);
					 * 
					 * String today = dateFormat.format(new
					 * SimpleDateFormat("dd-MMM-yyyy").parse(strDate1));
					 * 
					 * } catch (ParseException e1) {
					 * 
					 * logger.info(e1.getMessage()); e1.printStackTrace(); }
					 */
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

				List<BRF206A_RPT> T1MasterRow1T071 = new ArrayList<BRF206A_RPT>();

				Session hs = sessionFactory.getCurrentSession();

				try {
					Date d1 = df.parse(todate);

					T1MasterRow1T071 = hs.createQuery("from BRF206A_RPT a where a.report_date = ?1", BRF206A_RPT.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-206-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);

					Sheet sheet = workbook.getSheetAt(0);

					if (T1MasterRow1T071.size() == 1) {
						for (BRF206A_RPT brf206Row1TO71 : T1MasterRow1T071) {

							updateSheetRow1To71(sheet, brf206Row1TO71);

						}
					}

					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-206-A.xls");
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

			} //// else end

		}
		outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-206-A.xls");

		return outputFile;

	}

	public ModelAndView getArchieveBRF206View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF206A_RPT> T1rep = new ArrayList<BRF206A_RPT>();
// Query<Object[]> qr;

		List<BRF206A_RPT> T1Master = new ArrayList<BRF206A_RPT>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF206A_RPT a where a.report_date = ?1 ", BRF206A_RPT.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF206ARCH");
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

	public ModelAndView ARCHgetBRF206currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery(
						"select * from BRF206_ARCHIVTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF206_ARCHIVTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF206_ARCHIVTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF206_ARCHIVENTITY> T1Master = new ArrayList<BRF206_ARCHIVENTITY>();

		try {
			T1Master = hs.createQuery("from BRF206_ARCHIVENTITY a where a.report_date = ?1", BRF206_ARCHIVENTITY.class)
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

			BRF206_ARCHIVENTITY py = new BRF206_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF206ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public String detailChanges206(BRF206_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF206_DETAIL_ENTITY> Brf206detail = bRF206DETAIL_Repo.findById(foracid);

			if (Brf206detail.isPresent()) {
				BRF206_DETAIL_ENTITY BRFdetail = Brf206detail.get();

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
					bRF206DETAIL_Repo.save(BRFdetail);

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

	public void updateSheetRow1To71(Sheet sheet, BRF206A_RPT brf206Row1TO71) {

		/* EXCEL ROW 11 - ENTITY ROW 3 */
		Row row11 = sheet.getRow(11);

		/* LESS THAN 30 */
		Cell row11cell4 = row11.getCell(4);

		if (row11cell4 != null) {
			row11cell4.setCellValue(brf206Row1TO71.getR3_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR3_non_res_fed_gov().intValue());
		}

		Cell row11cell5 = row11.getCell(5);

		if (row11cell5 != null) {
			row11cell5.setCellValue(brf206Row1TO71.getR3_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR3_non_res_non_com_ent_fed().intValue());
		}
		Cell row11cell6 = row11.getCell(6);

		if (row11cell6 != null) {
			row11cell6.setCellValue(brf206Row1TO71.getR3_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR3_non_res_loc_gov().intValue());
		}
		Cell row11cell7 = row11.getCell(7);

		if (row11cell7 != null) {
			row11cell7.setCellValue(brf206Row1TO71.getR3_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR3_non_res_non_com_ent_emi().intValue());
		}
		Cell row11cell8 = row11.getCell(8);

		if (row11cell8 != null) {
			row11cell8.setCellValue(brf206Row1TO71.getR3_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR3_non_res_gre_gov().intValue());
		}
		Cell row11cell9 = row11.getCell(9);

		if (row11cell9 != null) {
			row11cell9.setCellValue(brf206Row1TO71.getR3_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR3_non_res_pri_gre_gov().intValue());
		}
		Cell row11cell10 = row11.getCell(10);

		if (row11cell10 != null) {
			row11cell10.setCellValue(brf206Row1TO71.getR3_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR3_non_res_pri_banks().intValue());
		}
		Cell row11cell11 = row11.getCell(11);

		if (row11cell11 != null) {
			row11cell11.setCellValue(brf206Row1TO71.getR3_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR3_non_res_pri_fin_ins().intValue());
		}
		Cell row11cell12 = row11.getCell(12);

		if (row11cell12 != null) {
			row11cell12.setCellValue(brf206Row1TO71.getR3_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR3_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 12 - ENTITY ROW 4 */
		Row row12 = sheet.getRow(12);

		/* LESS THAN 30 */
		Cell row12cell4 = row12.getCell(4);

		if (row12cell4 != null) {
			row12cell4.setCellValue(brf206Row1TO71.getR4_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR4_non_res_fed_gov().intValue());
		}

		Cell row12cell5 = row12.getCell(5);

		if (row12cell5 != null) {
			row12cell5.setCellValue(brf206Row1TO71.getR4_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR4_non_res_non_com_ent_fed().intValue());
		}
		Cell row12cell6 = row12.getCell(6);

		if (row12cell6 != null) {
			row12cell6.setCellValue(brf206Row1TO71.getR4_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR4_non_res_loc_gov().intValue());
		}
		Cell row12cell7 = row12.getCell(7);

		if (row12cell7 != null) {
			row12cell7.setCellValue(brf206Row1TO71.getR4_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR4_non_res_non_com_ent_emi().intValue());
		}
		Cell row12cell8 = row12.getCell(8);

		if (row12cell8 != null) {
			row12cell8.setCellValue(brf206Row1TO71.getR4_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR4_non_res_gre_gov().intValue());
		}
		Cell row12cell9 = row12.getCell(9);

		if (row12cell9 != null) {
			row12cell9.setCellValue(brf206Row1TO71.getR4_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR4_non_res_pri_gre_gov().intValue());
		}
		Cell row12cell10 = row12.getCell(10);

		if (row12cell10 != null) {
			row12cell10.setCellValue(brf206Row1TO71.getR4_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR4_non_res_pri_banks().intValue());
		}
		Cell row12cell11 = row12.getCell(11);

		if (row12cell11 != null) {
			row12cell11.setCellValue(brf206Row1TO71.getR4_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR4_non_res_pri_fin_ins().intValue());
		}
		Cell row12cell12 = row12.getCell(12);

		if (row12cell12 != null) {
			row12cell12.setCellValue(brf206Row1TO71.getR4_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR4_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 13 - ENTITY ROW 5 */
		Row row13 = sheet.getRow(13);

		/* LESS THAN 30 */
		Cell row13cell4 = row13.getCell(4);

		if (row13cell4 != null) {
			row13cell4.setCellValue(brf206Row1TO71.getR5_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR5_non_res_fed_gov().intValue());
		}

		Cell row13cell5 = row13.getCell(5);

		if (row13cell5 != null) {
			row13cell5.setCellValue(brf206Row1TO71.getR5_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR5_non_res_non_com_ent_fed().intValue());
		}
		Cell row13cell6 = row13.getCell(6);

		if (row13cell6 != null) {
			row13cell6.setCellValue(brf206Row1TO71.getR5_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR5_non_res_loc_gov().intValue());
		}
		Cell row13cell7 = row13.getCell(7);

		if (row13cell7 != null) {
			row13cell7.setCellValue(brf206Row1TO71.getR5_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR5_non_res_non_com_ent_emi().intValue());
		}
		Cell row13cell8 = row13.getCell(8);

		if (row13cell8 != null) {
			row13cell8.setCellValue(brf206Row1TO71.getR5_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR5_non_res_gre_gov().intValue());
		}
		Cell row13cell9 = row13.getCell(9);

		if (row13cell9 != null) {
			row13cell9.setCellValue(brf206Row1TO71.getR5_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR5_non_res_pri_gre_gov().intValue());
		}
		Cell row13cell10 = row13.getCell(10);

		if (row13cell10 != null) {
			row13cell10.setCellValue(brf206Row1TO71.getR5_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR5_non_res_pri_banks().intValue());
		}
		Cell row13cell11 = row13.getCell(11);

		if (row13cell11 != null) {
			row13cell11.setCellValue(brf206Row1TO71.getR5_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR5_non_res_pri_fin_ins().intValue());
		}
		Cell row13cell12 = row13.getCell(12);

		if (row13cell12 != null) {
			row13cell12.setCellValue(brf206Row1TO71.getR5_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR5_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 14 - ENTITY ROW 6 */
		Row row14 = sheet.getRow(14);

		/* LESS THAN 30 */
		Cell row14cell4 = row14.getCell(4);

		if (row14cell4 != null) {
			row14cell4.setCellValue(brf206Row1TO71.getR6_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR6_non_res_fed_gov().intValue());
		}

		Cell row14cell5 = row14.getCell(5);

		if (row14cell5 != null) {
			row14cell5.setCellValue(brf206Row1TO71.getR6_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR6_non_res_non_com_ent_fed().intValue());
		}
		Cell row14cell6 = row14.getCell(6);

		if (row14cell6 != null) {
			row14cell6.setCellValue(brf206Row1TO71.getR6_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR6_non_res_loc_gov().intValue());
		}
		Cell row14cell7 = row14.getCell(7);

		if (row14cell7 != null) {
			row14cell7.setCellValue(brf206Row1TO71.getR6_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR6_non_res_non_com_ent_emi().intValue());
		}
		Cell row14cell8 = row14.getCell(8);

		if (row14cell8 != null) {
			row14cell8.setCellValue(brf206Row1TO71.getR6_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR6_non_res_gre_gov().intValue());
		}
		Cell row14cell9 = row14.getCell(9);

		if (row14cell9 != null) {
			row14cell9.setCellValue(brf206Row1TO71.getR6_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR6_non_res_pri_gre_gov().intValue());
		}
		Cell row14cell10 = row14.getCell(10);

		if (row14cell10 != null) {
			row14cell10.setCellValue(brf206Row1TO71.getR6_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR6_non_res_pri_banks().intValue());
		}
		Cell row14cell11 = row14.getCell(11);

		if (row14cell11 != null) {
			row14cell11.setCellValue(brf206Row1TO71.getR6_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR6_non_res_pri_fin_ins().intValue());
		}
		Cell row14cell12 = row14.getCell(12);

		if (row14cell12 != null) {
			row14cell12.setCellValue(brf206Row1TO71.getR6_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR6_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 15 - ENTITY ROW 7 */
		Row row15 = sheet.getRow(15);

		/* LESS THAN 30 */
		Cell row15cell4 = row15.getCell(4);

		if (row15cell4 != null) {
			row15cell4.setCellValue(brf206Row1TO71.getR7_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR7_non_res_fed_gov().intValue());
		}

		Cell row15cell5 = row15.getCell(5);

		if (row15cell5 != null) {
			row15cell5.setCellValue(brf206Row1TO71.getR7_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR7_non_res_non_com_ent_fed().intValue());
		}
		Cell row15cell6 = row15.getCell(6);

		if (row15cell6 != null) {
			row15cell6.setCellValue(brf206Row1TO71.getR7_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR7_non_res_loc_gov().intValue());
		}
		Cell row15cell7 = row15.getCell(7);

		if (row15cell7 != null) {
			row15cell7.setCellValue(brf206Row1TO71.getR7_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR7_non_res_non_com_ent_emi().intValue());
		}
		Cell row15cell8 = row15.getCell(8);

		if (row15cell8 != null) {
			row15cell8.setCellValue(brf206Row1TO71.getR7_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR7_non_res_gre_gov().intValue());
		}
		Cell row15cell9 = row15.getCell(9);

		if (row15cell9 != null) {
			row15cell9.setCellValue(brf206Row1TO71.getR7_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR7_non_res_pri_gre_gov().intValue());
		}
		Cell row15cell10 = row15.getCell(10);

		if (row15cell10 != null) {
			row15cell10.setCellValue(brf206Row1TO71.getR7_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR7_non_res_pri_banks().intValue());
		}
		Cell row15cell11 = row15.getCell(11);

		if (row15cell11 != null) {
			row15cell11.setCellValue(brf206Row1TO71.getR7_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR7_non_res_pri_fin_ins().intValue());
		}
		Cell row15cell12 = row15.getCell(12);

		if (row15cell12 != null) {
			row15cell12.setCellValue(brf206Row1TO71.getR7_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR7_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 16 - ENTITY ROW 8 */
		Row row16 = sheet.getRow(16);

		/* LESS THAN 30 */
		Cell row16cell4 = row16.getCell(4);

		if (row16cell4 != null) {
			row16cell4.setCellValue(brf206Row1TO71.getR8_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR8_non_res_fed_gov().intValue());
		}

		Cell row16cell5 = row16.getCell(5);

		if (row16cell5 != null) {
			row16cell5.setCellValue(brf206Row1TO71.getR8_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR8_non_res_non_com_ent_fed().intValue());
		}
		Cell row16cell6 = row16.getCell(6);

		if (row16cell6 != null) {
			row16cell6.setCellValue(brf206Row1TO71.getR8_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR8_non_res_loc_gov().intValue());
		}
		Cell row16cell7 = row16.getCell(7);

		if (row16cell7 != null) {
			row16cell7.setCellValue(brf206Row1TO71.getR8_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR8_non_res_non_com_ent_emi().intValue());
		}
		Cell row16cell8 = row16.getCell(8);

		if (row16cell8 != null) {
			row16cell8.setCellValue(brf206Row1TO71.getR8_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR8_non_res_gre_gov().intValue());
		}
		Cell row16cell9 = row16.getCell(9);

		if (row16cell9 != null) {
			row16cell9.setCellValue(brf206Row1TO71.getR8_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR8_non_res_pri_gre_gov().intValue());
		}
		Cell row16cell10 = row16.getCell(10);

		if (row16cell10 != null) {
			row16cell10.setCellValue(brf206Row1TO71.getR8_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR8_non_res_pri_banks().intValue());
		}
		Cell row16cell11 = row16.getCell(11);

		if (row16cell11 != null) {
			row16cell11.setCellValue(brf206Row1TO71.getR8_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR8_non_res_pri_fin_ins().intValue());
		}
		Cell row16cell12 = row16.getCell(12);

		if (row16cell12 != null) {
			row16cell12.setCellValue(brf206Row1TO71.getR8_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR8_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 18 - ENTITY ROW 10 */
		Row row18 = sheet.getRow(18);

		/* LESS THAN 30 */
		Cell row18cell4 = row18.getCell(4);

		if (row18cell4 != null) {
			row18cell4.setCellValue(brf206Row1TO71.getR10_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR10_non_res_fed_gov().intValue());
		}

		Cell row18cell5 = row18.getCell(5);

		if (row18cell5 != null) {
			row18cell5.setCellValue(brf206Row1TO71.getR10_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR10_non_res_non_com_ent_fed().intValue());
		}
		Cell row18cell6 = row18.getCell(6);

		if (row18cell6 != null) {
			row18cell6.setCellValue(brf206Row1TO71.getR10_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR10_non_res_loc_gov().intValue());
		}
		Cell row18cell7 = row18.getCell(7);

		if (row18cell7 != null) {
			row18cell7.setCellValue(brf206Row1TO71.getR10_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR10_non_res_non_com_ent_emi().intValue());
		}
		Cell row18cell8 = row18.getCell(8);

		if (row18cell8 != null) {
			row18cell8.setCellValue(brf206Row1TO71.getR10_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR10_non_res_gre_gov().intValue());
		}
		Cell row18cell9 = row18.getCell(9);

		if (row18cell9 != null) {
			row18cell9.setCellValue(brf206Row1TO71.getR10_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR10_non_res_pri_gre_gov().intValue());
		}
		Cell row18cell10 = row18.getCell(10);

		if (row18cell10 != null) {
			row18cell10.setCellValue(brf206Row1TO71.getR10_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR10_non_res_pri_banks().intValue());
		}
		Cell row18cell11 = row18.getCell(11);

		if (row18cell11 != null) {
			row18cell11.setCellValue(brf206Row1TO71.getR10_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR10_non_res_pri_fin_ins().intValue());
		}
		Cell row18cell12 = row18.getCell(12);

		if (row18cell12 != null) {
			row18cell12.setCellValue(brf206Row1TO71.getR10_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR10_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 19 - ENTITY ROW 11 */
		Row row19 = sheet.getRow(19);

		/* LESS THAN 30 */
		Cell row19cell4 = row19.getCell(4);

		if (row19cell4 != null) {
			row19cell4.setCellValue(brf206Row1TO71.getR11_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR11_non_res_fed_gov().intValue());
		}

		Cell row19cell5 = row19.getCell(5);

		if (row19cell5 != null) {
			row19cell5.setCellValue(brf206Row1TO71.getR11_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR11_non_res_non_com_ent_fed().intValue());
		}
		Cell row19cell6 = row19.getCell(6);

		if (row19cell6 != null) {
			row19cell6.setCellValue(brf206Row1TO71.getR11_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR11_non_res_loc_gov().intValue());
		}
		Cell row19cell7 = row19.getCell(7);

		if (row19cell7 != null) {
			row19cell7.setCellValue(brf206Row1TO71.getR11_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR11_non_res_non_com_ent_emi().intValue());
		}
		Cell row19cell8 = row19.getCell(8);

		if (row19cell8 != null) {
			row19cell8.setCellValue(brf206Row1TO71.getR11_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR11_non_res_gre_gov().intValue());
		}
		Cell row19cell9 = row19.getCell(9);

		if (row19cell9 != null) {
			row19cell9.setCellValue(brf206Row1TO71.getR11_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR11_non_res_pri_gre_gov().intValue());
		}
		Cell row19cell10 = row19.getCell(10);

		if (row19cell10 != null) {
			row19cell10.setCellValue(brf206Row1TO71.getR11_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR11_non_res_pri_banks().intValue());
		}
		Cell row19cell11 = row19.getCell(11);

		if (row19cell11 != null) {
			row19cell11.setCellValue(brf206Row1TO71.getR11_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR11_non_res_pri_fin_ins().intValue());
		}
		Cell row19cell12 = row19.getCell(12);

		if (row19cell12 != null) {
			row19cell12.setCellValue(brf206Row1TO71.getR11_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR11_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 20 - ENTITY ROW 12 */
		Row row20 = sheet.getRow(20);

		/* LESS THAN 30 */
		Cell row20cell4 = row20.getCell(4);

		if (row20cell4 != null) {
			row20cell4.setCellValue(brf206Row1TO71.getR12_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR12_non_res_fed_gov().intValue());
		}

		Cell row20cell5 = row20.getCell(5);

		if (row20cell5 != null) {
			row20cell5.setCellValue(brf206Row1TO71.getR12_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR12_non_res_non_com_ent_fed().intValue());
		}
		Cell row20cell6 = row20.getCell(6);

		if (row20cell6 != null) {
			row20cell6.setCellValue(brf206Row1TO71.getR12_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR12_non_res_loc_gov().intValue());
		}
		Cell row20cell7 = row20.getCell(7);

		if (row20cell7 != null) {
			row20cell7.setCellValue(brf206Row1TO71.getR12_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR12_non_res_non_com_ent_emi().intValue());
		}
		Cell row20cell8 = row20.getCell(8);

		if (row20cell8 != null) {
			row20cell8.setCellValue(brf206Row1TO71.getR12_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR12_non_res_gre_gov().intValue());
		}
		Cell row20cell9 = row20.getCell(9);

		if (row20cell9 != null) {
			row20cell9.setCellValue(brf206Row1TO71.getR12_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR12_non_res_pri_gre_gov().intValue());
		}
		Cell row20cell10 = row20.getCell(10);

		if (row20cell10 != null) {
			row20cell10.setCellValue(brf206Row1TO71.getR12_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR12_non_res_pri_banks().intValue());
		}
		Cell row20cell11 = row20.getCell(11);

		if (row20cell11 != null) {
			row20cell11.setCellValue(brf206Row1TO71.getR12_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR12_non_res_pri_fin_ins().intValue());
		}
		Cell row20cell12 = row20.getCell(12);

		if (row20cell12 != null) {
			row20cell12.setCellValue(brf206Row1TO71.getR12_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR12_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 21 - ENTITY ROW 13 */
		Row row21 = sheet.getRow(21);

		/* LESS THAN 30 */
		Cell row21cell4 = row21.getCell(4);

		if (row21cell4 != null) {
			row21cell4.setCellValue(brf206Row1TO71.getR13_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR13_non_res_fed_gov().intValue());
		}

		Cell row21cell5 = row21.getCell(5);

		if (row21cell5 != null) {
			row21cell5.setCellValue(brf206Row1TO71.getR13_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR13_non_res_non_com_ent_fed().intValue());
		}
		Cell row21cell6 = row21.getCell(6);

		if (row21cell6 != null) {
			row21cell6.setCellValue(brf206Row1TO71.getR13_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR13_non_res_loc_gov().intValue());
		}
		Cell row21cell7 = row21.getCell(7);

		if (row21cell7 != null) {
			row21cell7.setCellValue(brf206Row1TO71.getR13_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR13_non_res_non_com_ent_emi().intValue());
		}
		Cell row21cell8 = row21.getCell(8);

		if (row21cell8 != null) {
			row21cell8.setCellValue(brf206Row1TO71.getR13_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR13_non_res_gre_gov().intValue());
		}
		Cell row21cell9 = row21.getCell(9);

		if (row21cell9 != null) {
			row21cell9.setCellValue(brf206Row1TO71.getR13_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR13_non_res_pri_gre_gov().intValue());
		}
		Cell row21cell10 = row21.getCell(10);

		if (row21cell10 != null) {
			row21cell10.setCellValue(brf206Row1TO71.getR13_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR13_non_res_pri_banks().intValue());
		}
		Cell row21cell11 = row21.getCell(11);

		if (row21cell11 != null) {
			row21cell11.setCellValue(brf206Row1TO71.getR13_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR13_non_res_pri_fin_ins().intValue());
		}
		Cell row21cell12 = row21.getCell(12);

		if (row21cell12 != null) {
			row21cell12.setCellValue(brf206Row1TO71.getR13_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR13_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 22 - ENTITY ROW 14 */
		Row row22 = sheet.getRow(22);

		/* LESS THAN 30 */
		Cell row22cell4 = row22.getCell(4);

		if (row22cell4 != null) {
			row22cell4.setCellValue(brf206Row1TO71.getR14_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR14_non_res_fed_gov().intValue());
		}

		Cell row22cell5 = row22.getCell(5);

		if (row22cell5 != null) {
			row22cell5.setCellValue(brf206Row1TO71.getR14_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR14_non_res_non_com_ent_fed().intValue());
		}
		Cell row22cell6 = row22.getCell(6);

		if (row22cell6 != null) {
			row22cell6.setCellValue(brf206Row1TO71.getR14_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR14_non_res_loc_gov().intValue());
		}
		Cell row22cell7 = row22.getCell(7);

		if (row22cell7 != null) {
			row22cell7.setCellValue(brf206Row1TO71.getR14_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR14_non_res_non_com_ent_emi().intValue());
		}
		Cell row22cell8 = row22.getCell(8);

		if (row22cell8 != null) {
			row22cell8.setCellValue(brf206Row1TO71.getR14_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR14_non_res_gre_gov().intValue());
		}
		Cell row22cell9 = row22.getCell(9);

		if (row22cell9 != null) {
			row22cell9.setCellValue(brf206Row1TO71.getR14_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR14_non_res_pri_gre_gov().intValue());
		}
		Cell row22cell10 = row22.getCell(10);

		if (row22cell10 != null) {
			row22cell10.setCellValue(brf206Row1TO71.getR14_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR14_non_res_pri_banks().intValue());
		}
		Cell row22cell11 = row22.getCell(11);

		if (row22cell11 != null) {
			row22cell11.setCellValue(brf206Row1TO71.getR14_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR14_non_res_pri_fin_ins().intValue());
		}
		Cell row22cell12 = row22.getCell(12);

		if (row22cell12 != null) {
			row22cell12.setCellValue(brf206Row1TO71.getR14_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR14_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 23 - ENTITY ROW 15 */
		Row row23 = sheet.getRow(23);

		/* LESS THAN 30 */
		Cell row23cell4 = row23.getCell(4);

		if (row23cell4 != null) {
			row23cell4.setCellValue(brf206Row1TO71.getR15_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR15_non_res_fed_gov().intValue());
		}

		Cell row23cell5 = row23.getCell(5);

		if (row23cell5 != null) {
			row23cell5.setCellValue(brf206Row1TO71.getR15_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR15_non_res_non_com_ent_fed().intValue());
		}
		Cell row23cell6 = row23.getCell(6);

		if (row23cell6 != null) {
			row23cell6.setCellValue(brf206Row1TO71.getR15_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR15_non_res_loc_gov().intValue());
		}
		Cell row23cell7 = row23.getCell(7);

		if (row23cell7 != null) {
			row23cell7.setCellValue(brf206Row1TO71.getR15_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR15_non_res_non_com_ent_emi().intValue());
		}
		Cell row23cell8 = row23.getCell(8);

		if (row23cell8 != null) {
			row23cell8.setCellValue(brf206Row1TO71.getR15_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR15_non_res_gre_gov().intValue());
		}
		Cell row23cell9 = row23.getCell(9);

		if (row23cell9 != null) {
			row23cell9.setCellValue(brf206Row1TO71.getR15_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR15_non_res_pri_gre_gov().intValue());
		}
		Cell row23cell10 = row23.getCell(10);

		if (row23cell10 != null) {
			row23cell10.setCellValue(brf206Row1TO71.getR15_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR15_non_res_pri_banks().intValue());
		}
		Cell row23cell11 = row23.getCell(11);

		if (row23cell11 != null) {
			row23cell11.setCellValue(brf206Row1TO71.getR15_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR15_non_res_pri_fin_ins().intValue());
		}
		Cell row23cell12 = row23.getCell(12);

		if (row23cell12 != null) {
			row23cell12.setCellValue(brf206Row1TO71.getR15_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR15_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 25 - ENTITY ROW 17 */
		Row row25 = sheet.getRow(25);

		/* LESS THAN 30 */
		Cell row25cell4 = row25.getCell(4);

		if (row25cell4 != null) {
			row25cell4.setCellValue(brf206Row1TO71.getR17_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR17_non_res_fed_gov().intValue());
		}

		Cell row25cell5 = row25.getCell(5);

		if (row25cell5 != null) {
			row25cell5.setCellValue(brf206Row1TO71.getR17_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR17_non_res_non_com_ent_fed().intValue());
		}
		Cell row25cell6 = row25.getCell(6);

		if (row25cell6 != null) {
			row25cell6.setCellValue(brf206Row1TO71.getR17_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR17_non_res_loc_gov().intValue());
		}
		Cell row25cell7 = row25.getCell(7);

		if (row25cell7 != null) {
			row25cell7.setCellValue(brf206Row1TO71.getR17_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR17_non_res_non_com_ent_emi().intValue());
		}
		Cell row25cell8 = row25.getCell(8);

		if (row25cell8 != null) {
			row25cell8.setCellValue(brf206Row1TO71.getR17_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR17_non_res_gre_gov().intValue());
		}
		Cell row25cell9 = row25.getCell(9);

		if (row25cell9 != null) {
			row25cell9.setCellValue(brf206Row1TO71.getR17_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR17_non_res_pri_gre_gov().intValue());
		}
		Cell row25cell10 = row25.getCell(10);

		if (row25cell10 != null) {
			row25cell10.setCellValue(brf206Row1TO71.getR17_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR17_non_res_pri_banks().intValue());
		}
		Cell row25cell11 = row25.getCell(11);

		if (row25cell11 != null) {
			row25cell11.setCellValue(brf206Row1TO71.getR17_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR17_non_res_pri_fin_ins().intValue());
		}
		Cell row25cell12 = row25.getCell(12);

		if (row25cell12 != null) {
			row25cell12.setCellValue(brf206Row1TO71.getR17_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR17_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 26 - ENTITY ROW 18 */
		Row row26 = sheet.getRow(26);

		/* LESS THAN 30 */
		Cell row26cell4 = row26.getCell(4);

		if (row26cell4 != null) {
			row26cell4.setCellValue(brf206Row1TO71.getR18_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR18_non_res_fed_gov().intValue());
		}

		Cell row26cell5 = row26.getCell(5);

		if (row26cell5 != null) {
			row26cell5.setCellValue(brf206Row1TO71.getR18_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR18_non_res_non_com_ent_fed().intValue());
		}
		Cell row26cell6 = row26.getCell(6);

		if (row26cell6 != null) {
			row26cell6.setCellValue(brf206Row1TO71.getR18_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR18_non_res_loc_gov().intValue());
		}
		Cell row26cell7 = row26.getCell(7);

		if (row26cell7 != null) {
			row26cell7.setCellValue(brf206Row1TO71.getR18_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR18_non_res_non_com_ent_emi().intValue());
		}
		Cell row26cell8 = row26.getCell(8);

		if (row26cell8 != null) {
			row26cell8.setCellValue(brf206Row1TO71.getR18_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR18_non_res_gre_gov().intValue());
		}
		Cell row26cell9 = row26.getCell(9);

		if (row26cell9 != null) {
			row26cell9.setCellValue(brf206Row1TO71.getR18_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR18_non_res_pri_gre_gov().intValue());
		}
		Cell row26cell10 = row26.getCell(10);

		if (row26cell10 != null) {
			row26cell10.setCellValue(brf206Row1TO71.getR18_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR18_non_res_pri_banks().intValue());
		}
		Cell row26cell11 = row26.getCell(11);

		if (row26cell11 != null) {
			row26cell11.setCellValue(brf206Row1TO71.getR18_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR18_non_res_pri_fin_ins().intValue());
		}
		Cell row26cell12 = row26.getCell(12);

		if (row26cell12 != null) {
			row26cell12.setCellValue(brf206Row1TO71.getR18_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR18_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 27 - ENTITY ROW 19 */
		Row row27 = sheet.getRow(27);

		/* LESS THAN 30 */
		Cell row27cell4 = row27.getCell(4);

		if (row27cell4 != null) {
			row27cell4.setCellValue(brf206Row1TO71.getR19_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR19_non_res_fed_gov().intValue());
		}

		Cell row27cell5 = row27.getCell(5);

		if (row27cell5 != null) {
			row27cell5.setCellValue(brf206Row1TO71.getR19_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR19_non_res_non_com_ent_fed().intValue());
		}
		Cell row27cell6 = row27.getCell(6);

		if (row27cell6 != null) {
			row27cell6.setCellValue(brf206Row1TO71.getR19_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR19_non_res_loc_gov().intValue());
		}
		Cell row27cell7 = row27.getCell(7);

		if (row27cell7 != null) {
			row27cell7.setCellValue(brf206Row1TO71.getR19_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR19_non_res_non_com_ent_emi().intValue());
		}
		Cell row27cell8 = row27.getCell(8);

		if (row27cell8 != null) {
			row27cell8.setCellValue(brf206Row1TO71.getR19_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR19_non_res_gre_gov().intValue());
		}
		Cell row27cell9 = row27.getCell(9);

		if (row27cell9 != null) {
			row27cell9.setCellValue(brf206Row1TO71.getR19_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR19_non_res_pri_gre_gov().intValue());
		}
		Cell row27cell10 = row27.getCell(10);

		if (row27cell10 != null) {
			row27cell10.setCellValue(brf206Row1TO71.getR19_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR19_non_res_pri_banks().intValue());
		}
		Cell row27cell11 = row27.getCell(11);

		if (row27cell11 != null) {
			row27cell11.setCellValue(brf206Row1TO71.getR19_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR19_non_res_pri_fin_ins().intValue());
		}
		Cell row27cell12 = row27.getCell(12);

		if (row27cell12 != null) {
			row27cell12.setCellValue(brf206Row1TO71.getR19_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR19_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 28 - ENTITY ROW 20 */
		Row row28 = sheet.getRow(28);

		/* LESS THAN 30 */
		Cell row28cell4 = row28.getCell(4);

		if (row28cell4 != null) {
			row28cell4.setCellValue(brf206Row1TO71.getR20_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR20_non_res_fed_gov().intValue());
		}

		Cell row28cell5 = row28.getCell(5);

		if (row28cell5 != null) {
			row28cell5.setCellValue(brf206Row1TO71.getR20_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR20_non_res_non_com_ent_fed().intValue());
		}
		Cell row28cell6 = row28.getCell(6);

		if (row28cell6 != null) {
			row28cell6.setCellValue(brf206Row1TO71.getR20_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR20_non_res_loc_gov().intValue());
		}
		Cell row28cell7 = row28.getCell(7);

		if (row28cell7 != null) {
			row28cell7.setCellValue(brf206Row1TO71.getR20_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR20_non_res_non_com_ent_emi().intValue());
		}
		Cell row28cell8 = row28.getCell(8);

		if (row28cell8 != null) {
			row28cell8.setCellValue(brf206Row1TO71.getR20_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR20_non_res_gre_gov().intValue());
		}
		Cell row28cell9 = row28.getCell(9);

		if (row28cell9 != null) {
			row28cell9.setCellValue(brf206Row1TO71.getR20_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR20_non_res_pri_gre_gov().intValue());
		}
		Cell row28cell10 = row28.getCell(10);

		if (row28cell10 != null) {
			row28cell10.setCellValue(brf206Row1TO71.getR20_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR20_non_res_pri_banks().intValue());
		}
		Cell row28cell11 = row28.getCell(11);

		if (row28cell11 != null) {
			row28cell11.setCellValue(brf206Row1TO71.getR20_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR20_non_res_pri_fin_ins().intValue());
		}
		Cell row28cell12 = row28.getCell(12);

		if (row28cell12 != null) {
			row28cell12.setCellValue(brf206Row1TO71.getR20_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR20_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 29 - ENTITY ROW 21 */
		Row row29 = sheet.getRow(29);

		/* LESS THAN 30 */
		Cell row29cell4 = row29.getCell(4);

		if (row29cell4 != null) {
			row29cell4.setCellValue(brf206Row1TO71.getR21_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR21_non_res_fed_gov().intValue());
		}

		Cell row29cell5 = row29.getCell(5);

		if (row29cell5 != null) {
			row29cell5.setCellValue(brf206Row1TO71.getR21_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR21_non_res_non_com_ent_fed().intValue());
		}
		Cell row29cell6 = row29.getCell(6);

		if (row29cell6 != null) {
			row29cell6.setCellValue(brf206Row1TO71.getR21_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR21_non_res_loc_gov().intValue());
		}
		Cell row29cell7 = row29.getCell(7);

		if (row29cell7 != null) {
			row29cell7.setCellValue(brf206Row1TO71.getR21_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR21_non_res_non_com_ent_emi().intValue());
		}
		Cell row29cell8 = row29.getCell(8);

		if (row29cell8 != null) {
			row29cell8.setCellValue(brf206Row1TO71.getR21_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR21_non_res_gre_gov().intValue());
		}
		Cell row29cell9 = row29.getCell(9);

		if (row29cell9 != null) {
			row29cell9.setCellValue(brf206Row1TO71.getR21_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR21_non_res_pri_gre_gov().intValue());
		}
		Cell row29cell10 = row29.getCell(10);

		if (row29cell10 != null) {
			row29cell10.setCellValue(brf206Row1TO71.getR21_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR21_non_res_pri_banks().intValue());
		}
		Cell row29cell11 = row29.getCell(11);

		if (row29cell11 != null) {
			row29cell11.setCellValue(brf206Row1TO71.getR21_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR21_non_res_pri_fin_ins().intValue());
		}
		Cell row29cell12 = row29.getCell(12);

		if (row29cell12 != null) {
			row29cell12.setCellValue(brf206Row1TO71.getR21_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR21_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 30 - ENTITY ROW 22 */
		Row row30 = sheet.getRow(30);

		/* LESS THAN 30 */
		Cell row30cell4 = row30.getCell(4);

		if (row30cell4 != null) {
			row30cell4.setCellValue(brf206Row1TO71.getR22_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR22_non_res_fed_gov().intValue());
		}

		Cell row30cell5 = row30.getCell(5);

		if (row30cell5 != null) {
			row30cell5.setCellValue(brf206Row1TO71.getR22_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR22_non_res_non_com_ent_fed().intValue());
		}
		Cell row30cell6 = row30.getCell(6);

		if (row30cell6 != null) {
			row30cell6.setCellValue(brf206Row1TO71.getR22_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR22_non_res_loc_gov().intValue());
		}
		Cell row30cell7 = row30.getCell(7);

		if (row30cell7 != null) {
			row30cell7.setCellValue(brf206Row1TO71.getR22_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR22_non_res_non_com_ent_emi().intValue());
		}
		Cell row30cell8 = row30.getCell(8);

		if (row30cell8 != null) {
			row30cell8.setCellValue(brf206Row1TO71.getR22_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR22_non_res_gre_gov().intValue());
		}
		Cell row30cell9 = row30.getCell(9);

		if (row30cell9 != null) {
			row30cell9.setCellValue(brf206Row1TO71.getR22_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR22_non_res_pri_gre_gov().intValue());
		}
		Cell row30cell10 = row30.getCell(10);

		if (row30cell10 != null) {
			row30cell10.setCellValue(brf206Row1TO71.getR22_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR22_non_res_pri_banks().intValue());
		}
		Cell row30cell11 = row30.getCell(11);

		if (row30cell11 != null) {
			row30cell11.setCellValue(brf206Row1TO71.getR22_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR22_non_res_pri_fin_ins().intValue());
		}
		Cell row30cell12 = row30.getCell(12);

		if (row30cell12 != null) {
			row30cell12.setCellValue(brf206Row1TO71.getR22_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR22_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 34 - ENTITY ROW 26 */
		Row row34 = sheet.getRow(34);

		/* LESS THAN 30 */
		Cell row34cell4 = row34.getCell(4);

		if (row34cell4 != null) {
			row34cell4.setCellValue(brf206Row1TO71.getR26_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR26_non_res_fed_gov().intValue());
		}

		Cell row34cell5 = row34.getCell(5);

		if (row34cell5 != null) {
			row34cell5.setCellValue(brf206Row1TO71.getR26_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR26_non_res_non_com_ent_fed().intValue());
		}
		Cell row34cell6 = row34.getCell(6);

		if (row34cell6 != null) {
			row34cell6.setCellValue(brf206Row1TO71.getR26_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR26_non_res_loc_gov().intValue());
		}
		Cell row34cell7 = row34.getCell(7);

		if (row34cell7 != null) {
			row34cell7.setCellValue(brf206Row1TO71.getR26_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR26_non_res_non_com_ent_emi().intValue());
		}
		Cell row34cell8 = row34.getCell(8);

		if (row34cell8 != null) {
			row34cell8.setCellValue(brf206Row1TO71.getR26_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR26_non_res_gre_gov().intValue());
		}
		Cell row34cell9 = row34.getCell(9);

		if (row34cell9 != null) {
			row34cell9.setCellValue(brf206Row1TO71.getR26_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR26_non_res_pri_gre_gov().intValue());
		}
		Cell row34cell10 = row34.getCell(10);

		if (row34cell10 != null) {
			row34cell10.setCellValue(brf206Row1TO71.getR26_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR26_non_res_pri_banks().intValue());
		}
		Cell row34cell11 = row34.getCell(11);

		if (row34cell11 != null) {
			row34cell11.setCellValue(brf206Row1TO71.getR26_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR26_non_res_pri_fin_ins().intValue());
		}
		Cell row34cell12 = row34.getCell(12);

		if (row34cell12 != null) {
			row34cell12.setCellValue(brf206Row1TO71.getR26_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR26_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 35 - ENTITY ROW 27 */
		Row row35 = sheet.getRow(35);

		/* LESS THAN 30 */
		Cell row35cell4 = row35.getCell(4);

		if (row35cell4 != null) {
			row35cell4.setCellValue(brf206Row1TO71.getR27_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR27_non_res_fed_gov().intValue());
		}

		Cell row35cell5 = row35.getCell(5);

		if (row35cell5 != null) {
			row35cell5.setCellValue(brf206Row1TO71.getR27_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR27_non_res_non_com_ent_fed().intValue());
		}
		Cell row35cell6 = row35.getCell(6);

		if (row35cell6 != null) {
			row35cell6.setCellValue(brf206Row1TO71.getR27_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR27_non_res_loc_gov().intValue());
		}
		Cell row35cell7 = row35.getCell(7);

		if (row35cell7 != null) {
			row35cell7.setCellValue(brf206Row1TO71.getR27_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR27_non_res_non_com_ent_emi().intValue());
		}
		Cell row35cell8 = row35.getCell(8);

		if (row35cell8 != null) {
			row35cell8.setCellValue(brf206Row1TO71.getR27_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR27_non_res_gre_gov().intValue());
		}
		Cell row35cell9 = row35.getCell(9);

		if (row35cell9 != null) {
			row35cell9.setCellValue(brf206Row1TO71.getR27_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR27_non_res_pri_gre_gov().intValue());
		}
		Cell row35cell10 = row35.getCell(10);

		if (row35cell10 != null) {
			row35cell10.setCellValue(brf206Row1TO71.getR27_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR27_non_res_pri_banks().intValue());
		}
		Cell row35cell11 = row35.getCell(11);

		if (row35cell11 != null) {
			row35cell11.setCellValue(brf206Row1TO71.getR27_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR27_non_res_pri_fin_ins().intValue());
		}
		Cell row35cell12 = row35.getCell(12);

		if (row35cell12 != null) {
			row35cell12.setCellValue(brf206Row1TO71.getR27_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR27_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 36 - ENTITY ROW 28 */
		Row row36 = sheet.getRow(36);

		/* LESS THAN 30 */
		Cell row36cell4 = row36.getCell(4);

		if (row36cell4 != null) {
			row36cell4.setCellValue(brf206Row1TO71.getR28_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR28_non_res_fed_gov().intValue());
		}

		Cell row36cell5 = row36.getCell(5);

		if (row36cell5 != null) {
			row36cell5.setCellValue(brf206Row1TO71.getR28_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR28_non_res_non_com_ent_fed().intValue());
		}
		Cell row36cell6 = row36.getCell(6);

		if (row36cell6 != null) {
			row36cell6.setCellValue(brf206Row1TO71.getR28_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR28_non_res_loc_gov().intValue());
		}
		Cell row36cell7 = row36.getCell(7);

		if (row36cell7 != null) {
			row36cell7.setCellValue(brf206Row1TO71.getR28_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR28_non_res_non_com_ent_emi().intValue());
		}
		Cell row36cell8 = row36.getCell(8);

		if (row36cell8 != null) {
			row36cell8.setCellValue(brf206Row1TO71.getR28_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR28_non_res_gre_gov().intValue());
		}
		Cell row36cell9 = row36.getCell(9);

		if (row36cell9 != null) {
			row36cell9.setCellValue(brf206Row1TO71.getR28_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR28_non_res_pri_gre_gov().intValue());
		}
		Cell row36cell10 = row36.getCell(10);

		if (row36cell10 != null) {
			row36cell10.setCellValue(brf206Row1TO71.getR28_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR28_non_res_pri_banks().intValue());
		}
		Cell row36cell11 = row36.getCell(11);

		if (row36cell11 != null) {
			row36cell11.setCellValue(brf206Row1TO71.getR28_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR28_non_res_pri_fin_ins().intValue());
		}
		Cell row36cell12 = row36.getCell(12);

		if (row36cell12 != null) {
			row36cell12.setCellValue(brf206Row1TO71.getR28_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR28_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 37 - ENTITY ROW 29 */
		Row row37 = sheet.getRow(37);

		/* LESS THAN 30 */
		Cell row37cell4 = row37.getCell(4);

		if (row37cell4 != null) {
			row37cell4.setCellValue(brf206Row1TO71.getR29_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR29_non_res_fed_gov().intValue());
		}

		Cell row37cell5 = row37.getCell(5);

		if (row37cell5 != null) {
			row37cell5.setCellValue(brf206Row1TO71.getR29_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR29_non_res_non_com_ent_fed().intValue());
		}
		Cell row37cell6 = row37.getCell(6);

		if (row37cell6 != null) {
			row37cell6.setCellValue(brf206Row1TO71.getR29_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR29_non_res_loc_gov().intValue());
		}
		Cell row37cell7 = row37.getCell(7);

		if (row37cell7 != null) {
			row37cell7.setCellValue(brf206Row1TO71.getR29_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR29_non_res_non_com_ent_emi().intValue());
		}
		Cell row37cell8 = row37.getCell(8);

		if (row37cell8 != null) {
			row37cell8.setCellValue(brf206Row1TO71.getR29_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR29_non_res_gre_gov().intValue());
		}
		Cell row37cell9 = row37.getCell(9);

		if (row37cell9 != null) {
			row37cell9.setCellValue(brf206Row1TO71.getR29_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR29_non_res_pri_gre_gov().intValue());
		}
		Cell row37cell10 = row37.getCell(10);

		if (row37cell10 != null) {
			row37cell10.setCellValue(brf206Row1TO71.getR29_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR29_non_res_pri_banks().intValue());
		}
		Cell row37cell11 = row37.getCell(11);

		if (row37cell11 != null) {
			row37cell11.setCellValue(brf206Row1TO71.getR29_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR29_non_res_pri_fin_ins().intValue());
		}
		Cell row37cell12 = row37.getCell(12);

		if (row37cell12 != null) {
			row37cell12.setCellValue(brf206Row1TO71.getR29_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR29_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 38 - ENTITY ROW 30 */
		Row row38 = sheet.getRow(38);

		/* LESS THAN 30 */
		Cell row38cell4 = row38.getCell(4);

		if (row38cell4 != null) {
			row38cell4.setCellValue(brf206Row1TO71.getR30_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR30_non_res_fed_gov().intValue());
		}

		Cell row38cell5 = row38.getCell(5);

		if (row38cell5 != null) {
			row38cell5.setCellValue(brf206Row1TO71.getR30_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR30_non_res_non_com_ent_fed().intValue());
		}
		Cell row38cell6 = row38.getCell(6);

		if (row38cell6 != null) {
			row38cell6.setCellValue(brf206Row1TO71.getR30_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR30_non_res_loc_gov().intValue());
		}
		Cell row38cell7 = row38.getCell(7);

		if (row38cell7 != null) {
			row38cell7.setCellValue(brf206Row1TO71.getR30_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR30_non_res_non_com_ent_emi().intValue());
		}
		Cell row38cell8 = row38.getCell(8);

		if (row38cell8 != null) {
			row38cell8.setCellValue(brf206Row1TO71.getR30_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR30_non_res_gre_gov().intValue());
		}
		Cell row38cell9 = row38.getCell(9);

		if (row38cell9 != null) {
			row38cell9.setCellValue(brf206Row1TO71.getR30_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR30_non_res_pri_gre_gov().intValue());
		}
		Cell row38cell10 = row38.getCell(10);

		if (row38cell10 != null) {
			row38cell10.setCellValue(brf206Row1TO71.getR30_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR30_non_res_pri_banks().intValue());
		}
		Cell row38cell11 = row38.getCell(11);

		if (row38cell11 != null) {
			row38cell11.setCellValue(brf206Row1TO71.getR30_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR30_non_res_pri_fin_ins().intValue());
		}
		Cell row38cell12 = row38.getCell(12);

		if (row38cell12 != null) {
			row38cell12.setCellValue(brf206Row1TO71.getR30_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR30_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 39 - ENTITY ROW 31 */
		Row row39 = sheet.getRow(39);

		/* LESS THAN 30 */
		Cell row39cell4 = row39.getCell(4);

		if (row39cell4 != null) {
			row39cell4.setCellValue(brf206Row1TO71.getR31_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR31_non_res_fed_gov().intValue());
		}

		Cell row39cell5 = row39.getCell(5);

		if (row39cell5 != null) {
			row39cell5.setCellValue(brf206Row1TO71.getR31_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR31_non_res_non_com_ent_fed().intValue());
		}
		Cell row39cell6 = row39.getCell(6);

		if (row39cell6 != null) {
			row39cell6.setCellValue(brf206Row1TO71.getR31_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR31_non_res_loc_gov().intValue());
		}
		Cell row39cell7 = row39.getCell(7);

		if (row39cell7 != null) {
			row39cell7.setCellValue(brf206Row1TO71.getR31_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR31_non_res_non_com_ent_emi().intValue());
		}
		Cell row39cell8 = row39.getCell(8);

		if (row39cell8 != null) {
			row39cell8.setCellValue(brf206Row1TO71.getR31_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR31_non_res_gre_gov().intValue());
		}
		Cell row39cell9 = row39.getCell(9);

		if (row39cell9 != null) {
			row39cell9.setCellValue(brf206Row1TO71.getR31_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR31_non_res_pri_gre_gov().intValue());
		}
		Cell row39cell10 = row39.getCell(10);

		if (row39cell10 != null) {
			row39cell10.setCellValue(brf206Row1TO71.getR31_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR31_non_res_pri_banks().intValue());
		}
		Cell row39cell11 = row39.getCell(11);

		if (row39cell11 != null) {
			row39cell11.setCellValue(brf206Row1TO71.getR31_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR31_non_res_pri_fin_ins().intValue());
		}
		Cell row39cell12 = row39.getCell(12);

		if (row39cell12 != null) {
			row39cell12.setCellValue(brf206Row1TO71.getR31_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR31_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 41 - ENTITY ROW 33 */
		Row row41 = sheet.getRow(41);

		/* LESS THAN 30 */
		Cell row41cell4 = row41.getCell(4);

		if (row41cell4 != null) {
			row41cell4.setCellValue(brf206Row1TO71.getR33_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR33_non_res_fed_gov().intValue());
		}

		Cell row41cell5 = row41.getCell(5);

		if (row41cell5 != null) {
			row41cell5.setCellValue(brf206Row1TO71.getR33_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR33_non_res_non_com_ent_fed().intValue());
		}
		Cell row41cell6 = row41.getCell(6);

		if (row41cell6 != null) {
			row41cell6.setCellValue(brf206Row1TO71.getR33_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR33_non_res_loc_gov().intValue());
		}
		Cell row41cell7 = row41.getCell(7);

		if (row41cell7 != null) {
			row41cell7.setCellValue(brf206Row1TO71.getR33_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR33_non_res_non_com_ent_emi().intValue());
		}
		Cell row41cell8 = row41.getCell(8);

		if (row41cell8 != null) {
			row41cell8.setCellValue(brf206Row1TO71.getR33_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR33_non_res_gre_gov().intValue());
		}
		Cell row41cell9 = row41.getCell(9);

		if (row41cell9 != null) {
			row41cell9.setCellValue(brf206Row1TO71.getR33_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR33_non_res_pri_gre_gov().intValue());
		}
		Cell row41cell10 = row41.getCell(10);

		if (row41cell10 != null) {
			row41cell10.setCellValue(brf206Row1TO71.getR33_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR33_non_res_pri_banks().intValue());
		}
		Cell row41cell11 = row41.getCell(11);

		if (row41cell11 != null) {
			row41cell11.setCellValue(brf206Row1TO71.getR33_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR33_non_res_pri_fin_ins().intValue());
		}
		Cell row41cell12 = row41.getCell(12);

		if (row41cell12 != null) {
			row41cell12.setCellValue(brf206Row1TO71.getR33_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR33_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 42 - ENTITY ROW 34 */
		Row row42 = sheet.getRow(42);

		/* LESS THAN 30 */
		Cell row42cell4 = row42.getCell(4);

		if (row42cell4 != null) {
			row42cell4.setCellValue(brf206Row1TO71.getR34_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR34_non_res_fed_gov().intValue());
		}

		Cell row42cell5 = row42.getCell(5);

		if (row42cell5 != null) {
			row42cell5.setCellValue(brf206Row1TO71.getR34_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR34_non_res_non_com_ent_fed().intValue());
		}
		Cell row42cell6 = row42.getCell(6);

		if (row42cell6 != null) {
			row42cell6.setCellValue(brf206Row1TO71.getR34_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR34_non_res_loc_gov().intValue());
		}
		Cell row42cell7 = row42.getCell(7);

		if (row42cell7 != null) {
			row42cell7.setCellValue(brf206Row1TO71.getR34_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR34_non_res_non_com_ent_emi().intValue());
		}
		Cell row42cell8 = row42.getCell(8);

		if (row42cell8 != null) {
			row42cell8.setCellValue(brf206Row1TO71.getR34_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR34_non_res_gre_gov().intValue());
		}
		Cell row42cell9 = row42.getCell(9);

		if (row42cell9 != null) {
			row42cell9.setCellValue(brf206Row1TO71.getR34_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR34_non_res_pri_gre_gov().intValue());
		}
		Cell row42cell10 = row42.getCell(10);

		if (row42cell10 != null) {
			row42cell10.setCellValue(brf206Row1TO71.getR34_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR34_non_res_pri_banks().intValue());
		}
		Cell row42cell11 = row42.getCell(11);

		if (row42cell11 != null) {
			row42cell11.setCellValue(brf206Row1TO71.getR34_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR34_non_res_pri_fin_ins().intValue());
		}
		Cell row42cell12 = row42.getCell(12);

		if (row42cell12 != null) {
			row42cell12.setCellValue(brf206Row1TO71.getR34_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR34_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 43 - ENTITY ROW 35 */
		Row row43 = sheet.getRow(43);

		/* LESS THAN 30 */
		Cell row43cell4 = row43.getCell(4);

		if (row43cell4 != null) {
			row43cell4.setCellValue(brf206Row1TO71.getR35_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR35_non_res_fed_gov().intValue());
		}

		Cell row43cell5 = row43.getCell(5);

		if (row43cell5 != null) {
			row43cell5.setCellValue(brf206Row1TO71.getR35_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR35_non_res_non_com_ent_fed().intValue());
		}
		Cell row43cell6 = row43.getCell(6);

		if (row43cell6 != null) {
			row43cell6.setCellValue(brf206Row1TO71.getR35_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR35_non_res_loc_gov().intValue());
		}
		Cell row43cell7 = row43.getCell(7);

		if (row43cell7 != null) {
			row43cell7.setCellValue(brf206Row1TO71.getR35_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR35_non_res_non_com_ent_emi().intValue());
		}
		Cell row43cell8 = row43.getCell(8);

		if (row43cell8 != null) {
			row43cell8.setCellValue(brf206Row1TO71.getR35_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR35_non_res_gre_gov().intValue());
		}
		Cell row43cell9 = row43.getCell(9);

		if (row43cell9 != null) {
			row43cell9.setCellValue(brf206Row1TO71.getR35_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR35_non_res_pri_gre_gov().intValue());
		}
		Cell row43cell10 = row43.getCell(10);

		if (row43cell10 != null) {
			row43cell10.setCellValue(brf206Row1TO71.getR35_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR35_non_res_pri_banks().intValue());
		}
		Cell row43cell11 = row43.getCell(11);

		if (row43cell11 != null) {
			row43cell11.setCellValue(brf206Row1TO71.getR35_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR35_non_res_pri_fin_ins().intValue());
		}
		Cell row43cell12 = row43.getCell(12);

		if (row43cell12 != null) {
			row43cell12.setCellValue(brf206Row1TO71.getR35_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR35_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 44 - ENTITY ROW 36 */
		Row row44 = sheet.getRow(44);

		/* LESS THAN 30 */
		Cell row44cell4 = row44.getCell(4);

		if (row44cell4 != null) {
			row44cell4.setCellValue(brf206Row1TO71.getR36_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR36_non_res_fed_gov().intValue());
		}

		Cell row44cell5 = row44.getCell(5);

		if (row44cell5 != null) {
			row44cell5.setCellValue(brf206Row1TO71.getR36_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR36_non_res_non_com_ent_fed().intValue());
		}
		Cell row44cell6 = row44.getCell(6);

		if (row44cell6 != null) {
			row44cell6.setCellValue(brf206Row1TO71.getR36_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR36_non_res_loc_gov().intValue());
		}
		Cell row44cell7 = row44.getCell(7);

		if (row44cell7 != null) {
			row44cell7.setCellValue(brf206Row1TO71.getR36_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR36_non_res_non_com_ent_emi().intValue());
		}
		Cell row44cell8 = row44.getCell(8);

		if (row44cell8 != null) {
			row44cell8.setCellValue(brf206Row1TO71.getR36_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR36_non_res_gre_gov().intValue());
		}
		Cell row44cell9 = row44.getCell(9);

		if (row44cell9 != null) {
			row44cell9.setCellValue(brf206Row1TO71.getR36_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR36_non_res_pri_gre_gov().intValue());
		}
		Cell row44cell10 = row44.getCell(10);

		if (row44cell10 != null) {
			row44cell10.setCellValue(brf206Row1TO71.getR36_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR36_non_res_pri_banks().intValue());
		}
		Cell row44cell11 = row44.getCell(11);

		if (row44cell11 != null) {
			row44cell11.setCellValue(brf206Row1TO71.getR36_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR36_non_res_pri_fin_ins().intValue());
		}
		Cell row44cell12 = row44.getCell(12);

		if (row44cell12 != null) {
			row44cell12.setCellValue(brf206Row1TO71.getR36_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR36_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 45 - ENTITY ROW 37 */
		Row row45 = sheet.getRow(45);

		/* LESS THAN 30 */
		Cell row45cell4 = row45.getCell(4);

		if (row45cell4 != null) {
			row45cell4.setCellValue(brf206Row1TO71.getR37_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR37_non_res_fed_gov().intValue());
		}

		Cell row45cell5 = row45.getCell(5);

		if (row45cell5 != null) {
			row45cell5.setCellValue(brf206Row1TO71.getR37_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR37_non_res_non_com_ent_fed().intValue());
		}
		Cell row45cell6 = row45.getCell(6);

		if (row45cell6 != null) {
			row45cell6.setCellValue(brf206Row1TO71.getR37_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR37_non_res_loc_gov().intValue());
		}
		Cell row45cell7 = row45.getCell(7);

		if (row45cell7 != null) {
			row45cell7.setCellValue(brf206Row1TO71.getR37_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR37_non_res_non_com_ent_emi().intValue());
		}
		Cell row45cell8 = row45.getCell(8);

		if (row45cell8 != null) {
			row45cell8.setCellValue(brf206Row1TO71.getR37_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR37_non_res_gre_gov().intValue());
		}
		Cell row45cell9 = row45.getCell(9);

		if (row45cell9 != null) {
			row45cell9.setCellValue(brf206Row1TO71.getR37_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR37_non_res_pri_gre_gov().intValue());
		}
		Cell row45cell10 = row45.getCell(10);

		if (row45cell10 != null) {
			row45cell10.setCellValue(brf206Row1TO71.getR37_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR37_non_res_pri_banks().intValue());
		}
		Cell row45cell11 = row45.getCell(11);

		if (row45cell11 != null) {
			row45cell11.setCellValue(brf206Row1TO71.getR37_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR37_non_res_pri_fin_ins().intValue());
		}
		Cell row45cell12 = row45.getCell(12);

		if (row45cell12 != null) {
			row45cell12.setCellValue(brf206Row1TO71.getR37_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR37_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 46 - ENTITY ROW 38 */
		Row row46 = sheet.getRow(46);

		/* LESS THAN 30 */
		Cell row46cell4 = row46.getCell(4);

		if (row46cell4 != null) {
			row46cell4.setCellValue(brf206Row1TO71.getR38_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR38_non_res_fed_gov().intValue());
		}

		Cell row46cell5 = row46.getCell(5);

		if (row46cell5 != null) {
			row46cell5.setCellValue(brf206Row1TO71.getR38_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR38_non_res_non_com_ent_fed().intValue());
		}
		Cell row46cell6 = row46.getCell(6);

		if (row46cell6 != null) {
			row46cell6.setCellValue(brf206Row1TO71.getR38_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR38_non_res_loc_gov().intValue());
		}
		Cell row46cell7 = row46.getCell(7);

		if (row46cell7 != null) {
			row46cell7.setCellValue(brf206Row1TO71.getR38_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR38_non_res_non_com_ent_emi().intValue());
		}
		Cell row46cell8 = row46.getCell(8);

		if (row46cell8 != null) {
			row46cell8.setCellValue(brf206Row1TO71.getR38_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR38_non_res_gre_gov().intValue());
		}
		Cell row46cell9 = row46.getCell(9);

		if (row46cell9 != null) {
			row46cell9.setCellValue(brf206Row1TO71.getR38_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR38_non_res_pri_gre_gov().intValue());
		}
		Cell row46cell10 = row46.getCell(10);

		if (row46cell10 != null) {
			row46cell10.setCellValue(brf206Row1TO71.getR38_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR38_non_res_pri_banks().intValue());
		}
		Cell row46cell11 = row46.getCell(11);

		if (row46cell11 != null) {
			row46cell11.setCellValue(brf206Row1TO71.getR38_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR38_non_res_pri_fin_ins().intValue());
		}
		Cell row46cell12 = row46.getCell(12);

		if (row46cell12 != null) {
			row46cell12.setCellValue(brf206Row1TO71.getR38_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR38_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 48 - ENTITY ROW 40 */
		Row row48 = sheet.getRow(48);

		/* LESS THAN 30 */
		Cell row48cell4 = row48.getCell(4);

		if (row48cell4 != null) {
			row48cell4.setCellValue(brf206Row1TO71.getR40_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR40_non_res_fed_gov().intValue());
		}

		Cell row48cell5 = row48.getCell(5);

		if (row48cell5 != null) {
			row48cell5.setCellValue(brf206Row1TO71.getR40_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR40_non_res_non_com_ent_fed().intValue());
		}
		Cell row48cell6 = row48.getCell(6);

		if (row48cell6 != null) {
			row48cell6.setCellValue(brf206Row1TO71.getR40_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR40_non_res_loc_gov().intValue());
		}
		Cell row48cell7 = row48.getCell(7);

		if (row48cell7 != null) {
			row48cell7.setCellValue(brf206Row1TO71.getR40_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR40_non_res_non_com_ent_emi().intValue());
		}
		Cell row48cell8 = row48.getCell(8);

		if (row48cell8 != null) {
			row48cell8.setCellValue(brf206Row1TO71.getR40_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR40_non_res_gre_gov().intValue());
		}
		Cell row48cell9 = row48.getCell(9);

		if (row48cell9 != null) {
			row48cell9.setCellValue(brf206Row1TO71.getR40_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR40_non_res_pri_gre_gov().intValue());
		}
		Cell row48cell10 = row48.getCell(10);

		if (row48cell10 != null) {
			row48cell10.setCellValue(brf206Row1TO71.getR40_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR40_non_res_pri_banks().intValue());
		}
		Cell row48cell11 = row48.getCell(11);

		if (row48cell11 != null) {
			row48cell11.setCellValue(brf206Row1TO71.getR40_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR40_non_res_pri_fin_ins().intValue());
		}
		Cell row48cell12 = row48.getCell(12);

		if (row48cell12 != null) {
			row48cell12.setCellValue(brf206Row1TO71.getR40_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR40_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 49 - ENTITY ROW 41 */
		Row row49 = sheet.getRow(49);

		Cell row49cell4 = row49.getCell(4);

		if (row49cell4 != null) {
			row49cell4.setCellValue(brf206Row1TO71.getR41_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR41_non_res_fed_gov().intValue());
		}

		Cell row49cell5 = row49.getCell(5);

		if (row49cell5 != null) {
			row49cell5.setCellValue(brf206Row1TO71.getR41_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR41_non_res_non_com_ent_fed().intValue());
		}
		Cell row49cell6 = row49.getCell(6);

		if (row49cell6 != null) {
			row49cell6.setCellValue(brf206Row1TO71.getR41_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR41_non_res_loc_gov().intValue());
		}
		Cell row49cell7 = row49.getCell(7);

		if (row49cell7 != null) {
			row49cell7.setCellValue(brf206Row1TO71.getR41_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR41_non_res_non_com_ent_emi().intValue());
		}
		Cell row49cell8 = row49.getCell(8);

		if (row49cell8 != null) {
			row49cell8.setCellValue(brf206Row1TO71.getR41_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR41_non_res_gre_gov().intValue());
		}
		Cell row49cell9 = row49.getCell(9);

		if (row49cell9 != null) {
			row49cell9.setCellValue(brf206Row1TO71.getR41_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR41_non_res_pri_gre_gov().intValue());
		}
		Cell row49cell10 = row49.getCell(10);

		if (row49cell10 != null) {
			row49cell10.setCellValue(brf206Row1TO71.getR41_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR41_non_res_pri_banks().intValue());
		}
		Cell row49cell11 = row49.getCell(11);

		if (row49cell11 != null) {
			row49cell11.setCellValue(brf206Row1TO71.getR41_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR41_non_res_pri_fin_ins().intValue());
		}
		Cell row49cell12 = row49.getCell(12);

		if (row49cell12 != null) {
			row49cell12.setCellValue(brf206Row1TO71.getR41_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR41_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 50 - ENTITY ROW 42 */
		Row row50 = sheet.getRow(50);

		Cell row50cell4 = row50.getCell(4);

		if (row50cell4 != null) {
			row50cell4.setCellValue(brf206Row1TO71.getR42_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR42_non_res_fed_gov().intValue());
		}

		Cell row50cell5 = row50.getCell(5);

		if (row50cell5 != null) {
			row50cell5.setCellValue(brf206Row1TO71.getR42_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR42_non_res_non_com_ent_fed().intValue());
		}
		Cell row50cell6 = row50.getCell(6);

		if (row50cell6 != null) {
			row50cell6.setCellValue(brf206Row1TO71.getR42_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR42_non_res_loc_gov().intValue());
		}
		Cell row50cell7 = row50.getCell(7);

		if (row50cell7 != null) {
			row50cell7.setCellValue(brf206Row1TO71.getR42_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR42_non_res_non_com_ent_emi().intValue());
		}
		Cell row50cell8 = row50.getCell(8);

		if (row50cell8 != null) {
			row50cell8.setCellValue(brf206Row1TO71.getR42_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR42_non_res_gre_gov().intValue());
		}
		Cell row50cell9 = row50.getCell(9);

		if (row50cell9 != null) {
			row50cell9.setCellValue(brf206Row1TO71.getR42_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR42_non_res_pri_gre_gov().intValue());
		}
		Cell row50cell10 = row50.getCell(10);

		if (row50cell10 != null) {
			row50cell10.setCellValue(brf206Row1TO71.getR42_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR42_non_res_pri_banks().intValue());
		}
		Cell row50cell11 = row50.getCell(11);

		if (row50cell11 != null) {
			row50cell11.setCellValue(brf206Row1TO71.getR42_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR42_non_res_pri_fin_ins().intValue());
		}
		Cell row50cell12 = row50.getCell(12);

		if (row50cell12 != null) {
			row50cell12.setCellValue(brf206Row1TO71.getR42_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR42_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 51 - ENTITY ROW 43 */
		Row row51 = sheet.getRow(51);

		Cell row51cell4 = row51.getCell(4);

		if (row51cell4 != null) {
			row51cell4.setCellValue(brf206Row1TO71.getR43_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR43_non_res_fed_gov().intValue());
		}

		Cell row51cell5 = row51.getCell(5);

		if (row51cell5 != null) {
			row51cell5.setCellValue(brf206Row1TO71.getR43_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR43_non_res_non_com_ent_fed().intValue());
		}
		Cell row51cell6 = row51.getCell(6);

		if (row51cell6 != null) {
			row51cell6.setCellValue(brf206Row1TO71.getR43_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR43_non_res_loc_gov().intValue());
		}
		Cell row51cell7 = row51.getCell(7);

		if (row51cell7 != null) {
			row51cell7.setCellValue(brf206Row1TO71.getR43_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR43_non_res_non_com_ent_emi().intValue());
		}
		Cell row51cell8 = row51.getCell(8);

		if (row51cell8 != null) {
			row51cell8.setCellValue(brf206Row1TO71.getR43_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR43_non_res_gre_gov().intValue());
		}
		Cell row51cell9 = row51.getCell(9);

		if (row51cell9 != null) {
			row51cell9.setCellValue(brf206Row1TO71.getR43_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR43_non_res_pri_gre_gov().intValue());
		}
		Cell row51cell10 = row51.getCell(10);

		if (row51cell10 != null) {
			row51cell10.setCellValue(brf206Row1TO71.getR43_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR43_non_res_pri_banks().intValue());
		}
		Cell row51cell11 = row51.getCell(11);

		if (row51cell11 != null) {
			row51cell11.setCellValue(brf206Row1TO71.getR43_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR43_non_res_pri_fin_ins().intValue());
		}
		Cell row51cell12 = row51.getCell(12);

		if (row51cell12 != null) {
			row51cell12.setCellValue(brf206Row1TO71.getR43_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR43_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 52 - ENTITY ROW 44 */
		Row row52 = sheet.getRow(52);

		Cell row52cell4 = row52.getCell(4);

		if (row52cell4 != null) {
			row52cell4.setCellValue(brf206Row1TO71.getR44_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR44_non_res_fed_gov().intValue());
		}

		Cell row52cell5 = row52.getCell(5);

		if (row52cell5 != null) {
			row52cell5.setCellValue(brf206Row1TO71.getR44_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR44_non_res_non_com_ent_fed().intValue());
		}
		Cell row52cell6 = row52.getCell(6);

		if (row52cell6 != null) {
			row52cell6.setCellValue(brf206Row1TO71.getR44_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR44_non_res_loc_gov().intValue());
		}
		Cell row52cell7 = row52.getCell(7);

		if (row52cell7 != null) {
			row52cell7.setCellValue(brf206Row1TO71.getR44_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR44_non_res_non_com_ent_emi().intValue());
		}
		Cell row52cell8 = row52.getCell(8);

		if (row52cell8 != null) {
			row52cell8.setCellValue(brf206Row1TO71.getR44_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR44_non_res_gre_gov().intValue());
		}
		Cell row52cell9 = row52.getCell(9);

		if (row52cell9 != null) {
			row52cell9.setCellValue(brf206Row1TO71.getR44_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR44_non_res_pri_gre_gov().intValue());
		}
		Cell row52cell10 = row52.getCell(10);

		if (row52cell10 != null) {
			row52cell10.setCellValue(brf206Row1TO71.getR44_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR44_non_res_pri_banks().intValue());
		}
		Cell row52cell11 = row52.getCell(11);

		if (row52cell11 != null) {
			row52cell11.setCellValue(brf206Row1TO71.getR44_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR44_non_res_pri_fin_ins().intValue());
		}
		Cell row52cell12 = row52.getCell(12);

		if (row52cell12 != null) {
			row52cell12.setCellValue(brf206Row1TO71.getR44_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR44_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 53 - ENTITY ROW 45 */
		Row row53 = sheet.getRow(53);

		Cell row53cell4 = row53.getCell(4);

		if (row53cell4 != null) {
			row53cell4.setCellValue(brf206Row1TO71.getR45_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR45_non_res_fed_gov().intValue());
		}

		Cell row53cell5 = row53.getCell(5);

		if (row53cell5 != null) {
			row53cell5.setCellValue(brf206Row1TO71.getR45_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR45_non_res_non_com_ent_fed().intValue());
		}
		Cell row53cell6 = row53.getCell(6);

		if (row53cell6 != null) {
			row53cell6.setCellValue(brf206Row1TO71.getR45_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR45_non_res_loc_gov().intValue());
		}
		Cell row53cell7 = row53.getCell(7);

		if (row53cell7 != null) {
			row53cell7.setCellValue(brf206Row1TO71.getR45_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR45_non_res_non_com_ent_emi().intValue());
		}
		Cell row53cell8 = row53.getCell(8);

		if (row53cell8 != null) {
			row53cell8.setCellValue(brf206Row1TO71.getR45_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR45_non_res_gre_gov().intValue());
		}
		Cell row53cell9 = row53.getCell(9);

		if (row53cell9 != null) {
			row53cell9.setCellValue(brf206Row1TO71.getR45_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR45_non_res_pri_gre_gov().intValue());
		}
		Cell row53cell10 = row53.getCell(10);

		if (row53cell10 != null) {
			row53cell10.setCellValue(brf206Row1TO71.getR45_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR45_non_res_pri_banks().intValue());
		}
		Cell row53cell11 = row53.getCell(11);

		if (row53cell11 != null) {
			row53cell11.setCellValue(brf206Row1TO71.getR45_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR45_non_res_pri_fin_ins().intValue());
		}
		Cell row53cell12 = row53.getCell(12);

		if (row53cell12 != null) {
			row53cell12.setCellValue(brf206Row1TO71.getR45_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR45_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 56 - ENTITY ROW 48 */
		Row row56 = sheet.getRow(56);

		Cell row56cell4 = row56.getCell(4);

		if (row56cell4 != null) {
			row56cell4.setCellValue(brf206Row1TO71.getR48_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR48_non_res_fed_gov().intValue());
		}

		Cell row56cell5 = row56.getCell(5);

		if (row56cell5 != null) {
			row56cell5.setCellValue(brf206Row1TO71.getR48_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR48_non_res_non_com_ent_fed().intValue());
		}
		Cell row56cell6 = row56.getCell(6);

		if (row56cell6 != null) {
			row56cell6.setCellValue(brf206Row1TO71.getR48_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR48_non_res_loc_gov().intValue());
		}
		Cell row56cell7 = row56.getCell(7);

		if (row56cell7 != null) {
			row56cell7.setCellValue(brf206Row1TO71.getR48_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR48_non_res_non_com_ent_emi().intValue());
		}
		Cell row56cell8 = row56.getCell(8);

		if (row56cell8 != null) {
			row56cell8.setCellValue(brf206Row1TO71.getR48_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR48_non_res_gre_gov().intValue());
		}
		Cell row56cell9 = row56.getCell(9);

		if (row56cell9 != null) {
			row56cell9.setCellValue(brf206Row1TO71.getR48_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR48_non_res_pri_gre_gov().intValue());
		}
		Cell row56cell10 = row56.getCell(10);

		if (row56cell10 != null) {
			row56cell10.setCellValue(brf206Row1TO71.getR48_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR48_non_res_pri_banks().intValue());
		}
		Cell row56cell11 = row56.getCell(11);

		if (row56cell11 != null) {
			row56cell11.setCellValue(brf206Row1TO71.getR48_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR48_non_res_pri_fin_ins().intValue());
		}
		Cell row56cell12 = row56.getCell(12);

		if (row56cell12 != null) {
			row56cell12.setCellValue(brf206Row1TO71.getR48_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR48_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 57 - ENTITY ROW 49 */
		Row row57 = sheet.getRow(57);

		Cell row57cell4 = row57.getCell(4);

		if (row57cell4 != null) {
			row57cell4.setCellValue(brf206Row1TO71.getR49_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR49_non_res_fed_gov().intValue());
		}

		Cell row57cell5 = row57.getCell(5);

		if (row57cell5 != null) {
			row57cell5.setCellValue(brf206Row1TO71.getR49_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR49_non_res_non_com_ent_fed().intValue());
		}
		Cell row57cell6 = row57.getCell(6);

		if (row57cell6 != null) {
			row57cell6.setCellValue(brf206Row1TO71.getR49_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR49_non_res_loc_gov().intValue());
		}
		Cell row57cell7 = row57.getCell(7);

		if (row57cell7 != null) {
			row57cell7.setCellValue(brf206Row1TO71.getR49_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR49_non_res_non_com_ent_emi().intValue());
		}
		Cell row57cell8 = row57.getCell(8);

		if (row57cell8 != null) {
			row57cell8.setCellValue(brf206Row1TO71.getR49_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR49_non_res_gre_gov().intValue());
		}
		Cell row57cell9 = row57.getCell(9);

		if (row57cell9 != null) {
			row57cell9.setCellValue(brf206Row1TO71.getR49_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR49_non_res_pri_gre_gov().intValue());
		}
		Cell row57cell10 = row57.getCell(10);

		if (row57cell10 != null) {
			row57cell10.setCellValue(brf206Row1TO71.getR49_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR49_non_res_pri_banks().intValue());
		}
		Cell row57cell11 = row57.getCell(11);

		if (row57cell11 != null) {
			row57cell11.setCellValue(brf206Row1TO71.getR49_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR49_non_res_pri_fin_ins().intValue());
		}
		Cell row57cell12 = row57.getCell(12);

		if (row57cell12 != null) {
			row57cell12.setCellValue(brf206Row1TO71.getR49_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR49_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 58 - ENTITY ROW 50 */
		Row row58 = sheet.getRow(58);

		Cell row58cell4 = row58.getCell(4);

		if (row58cell4 != null) {
			row58cell4.setCellValue(brf206Row1TO71.getR50_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR50_non_res_fed_gov().intValue());
		}

		Cell row58cell5 = row58.getCell(5);

		if (row58cell5 != null) {
			row58cell5.setCellValue(brf206Row1TO71.getR50_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR50_non_res_non_com_ent_fed().intValue());
		}
		Cell row58cell6 = row58.getCell(6);

		if (row58cell6 != null) {
			row58cell6.setCellValue(brf206Row1TO71.getR50_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR50_non_res_loc_gov().intValue());
		}
		Cell row58cell7 = row58.getCell(7);

		if (row58cell7 != null) {
			row58cell7.setCellValue(brf206Row1TO71.getR50_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR50_non_res_non_com_ent_emi().intValue());
		}
		Cell row58cell8 = row58.getCell(8);

		if (row58cell8 != null) {
			row58cell8.setCellValue(brf206Row1TO71.getR50_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR50_non_res_gre_gov().intValue());
		}
		Cell row58cell9 = row58.getCell(9);

		if (row58cell9 != null) {
			row58cell9.setCellValue(brf206Row1TO71.getR50_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR50_non_res_pri_gre_gov().intValue());
		}
		Cell row58cell10 = row58.getCell(10);

		if (row58cell10 != null) {
			row58cell10.setCellValue(brf206Row1TO71.getR50_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR50_non_res_pri_banks().intValue());
		}
		Cell row58cell11 = row58.getCell(11);

		if (row58cell11 != null) {
			row58cell11.setCellValue(brf206Row1TO71.getR50_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR50_non_res_pri_fin_ins().intValue());
		}
		Cell row58cell12 = row58.getCell(12);

		if (row58cell12 != null) {
			row58cell12.setCellValue(brf206Row1TO71.getR50_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR50_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 59 - ENTITY ROW 51 */
		Row row59 = sheet.getRow(59);

		Cell row59cell4 = row59.getCell(4);

		if (row59cell4 != null) {
			row59cell4.setCellValue(brf206Row1TO71.getR51_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR51_non_res_fed_gov().intValue());
		}

		Cell row59cell5 = row59.getCell(5);

		if (row59cell5 != null) {
			row59cell5.setCellValue(brf206Row1TO71.getR51_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR51_non_res_non_com_ent_fed().intValue());
		}
		Cell row59cell6 = row59.getCell(6);

		if (row59cell6 != null) {
			row59cell6.setCellValue(brf206Row1TO71.getR51_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR51_non_res_loc_gov().intValue());
		}
		Cell row59cell7 = row59.getCell(7);

		if (row59cell7 != null) {
			row59cell7.setCellValue(brf206Row1TO71.getR51_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR51_non_res_non_com_ent_emi().intValue());
		}
		Cell row59cell8 = row59.getCell(8);

		if (row59cell8 != null) {
			row59cell8.setCellValue(brf206Row1TO71.getR51_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR51_non_res_gre_gov().intValue());
		}
		Cell row59cell9 = row59.getCell(9);

		if (row59cell9 != null) {
			row59cell9.setCellValue(brf206Row1TO71.getR51_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR51_non_res_pri_gre_gov().intValue());
		}
		Cell row59cell10 = row59.getCell(10);

		if (row59cell10 != null) {
			row59cell10.setCellValue(brf206Row1TO71.getR51_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR51_non_res_pri_banks().intValue());
		}
		Cell row59cell11 = row59.getCell(11);

		if (row59cell11 != null) {
			row59cell11.setCellValue(brf206Row1TO71.getR51_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR51_non_res_pri_fin_ins().intValue());
		}
		Cell row59cell12 = row59.getCell(12);

		if (row59cell12 != null) {
			row59cell12.setCellValue(brf206Row1TO71.getR51_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR51_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 60 - ENTITY ROW 52 */
		Row row60 = sheet.getRow(60);

		Cell row60cell4 = row60.getCell(4);

		if (row60cell4 != null) {
			row60cell4.setCellValue(brf206Row1TO71.getR52_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR52_non_res_fed_gov().intValue());
		}

		Cell row60cell5 = row60.getCell(5);

		if (row60cell5 != null) {
			row60cell5.setCellValue(brf206Row1TO71.getR52_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR52_non_res_non_com_ent_fed().intValue());
		}
		Cell row60cell6 = row60.getCell(6);

		if (row60cell6 != null) {
			row60cell6.setCellValue(brf206Row1TO71.getR52_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR52_non_res_loc_gov().intValue());
		}
		Cell row60cell7 = row60.getCell(7);

		if (row60cell7 != null) {
			row60cell7.setCellValue(brf206Row1TO71.getR52_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR52_non_res_non_com_ent_emi().intValue());
		}
		Cell row60cell8 = row60.getCell(8);

		if (row60cell8 != null) {
			row60cell8.setCellValue(brf206Row1TO71.getR52_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR52_non_res_gre_gov().intValue());
		}
		Cell row60cell9 = row60.getCell(9);

		if (row60cell9 != null) {
			row60cell9.setCellValue(brf206Row1TO71.getR52_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR52_non_res_pri_gre_gov().intValue());
		}
		Cell row60cell10 = row60.getCell(10);

		if (row60cell10 != null) {
			row60cell10.setCellValue(brf206Row1TO71.getR52_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR52_non_res_pri_banks().intValue());
		}
		Cell row60cell11 = row60.getCell(11);

		if (row60cell11 != null) {
			row60cell11.setCellValue(brf206Row1TO71.getR52_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR52_non_res_pri_fin_ins().intValue());
		}
		Cell row60cell12 = row60.getCell(12);

		if (row60cell12 != null) {
			row60cell12.setCellValue(brf206Row1TO71.getR52_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR52_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 61 - ENTITY ROW 53 */
		Row row61 = sheet.getRow(61);

		Cell row61cell4 = row61.getCell(4);

		if (row61cell4 != null) {
			row61cell4.setCellValue(brf206Row1TO71.getR53_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR53_non_res_fed_gov().intValue());
		}

		Cell row61cell5 = row61.getCell(5);

		if (row61cell5 != null) {
			row61cell5.setCellValue(brf206Row1TO71.getR53_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR53_non_res_non_com_ent_fed().intValue());
		}
		Cell row61cell6 = row61.getCell(6);

		if (row61cell6 != null) {
			row61cell6.setCellValue(brf206Row1TO71.getR53_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR53_non_res_loc_gov().intValue());
		}
		Cell row61cell7 = row61.getCell(7);

		if (row61cell7 != null) {
			row61cell7.setCellValue(brf206Row1TO71.getR53_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR53_non_res_non_com_ent_emi().intValue());
		}
		Cell row61cell8 = row61.getCell(8);

		if (row61cell8 != null) {
			row61cell8.setCellValue(brf206Row1TO71.getR53_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR53_non_res_gre_gov().intValue());
		}
		Cell row61cell9 = row61.getCell(9);

		if (row61cell9 != null) {
			row61cell9.setCellValue(brf206Row1TO71.getR53_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR53_non_res_pri_gre_gov().intValue());
		}
		Cell row61cell10 = row61.getCell(10);

		if (row61cell10 != null) {
			row61cell10.setCellValue(brf206Row1TO71.getR53_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR53_non_res_pri_banks().intValue());
		}
		Cell row61cell11 = row61.getCell(11);

		if (row61cell11 != null) {
			row61cell11.setCellValue(brf206Row1TO71.getR53_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR53_non_res_pri_fin_ins().intValue());
		}
		Cell row61cell12 = row61.getCell(12);

		if (row61cell12 != null) {
			row61cell12.setCellValue(brf206Row1TO71.getR53_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR53_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 63 - ENTITY ROW 55 */
		Row row63 = sheet.getRow(63);

		Cell row63cell4 = row63.getCell(4);

		if (row63cell4 != null) {
			row63cell4.setCellValue(brf206Row1TO71.getR55_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR55_non_res_fed_gov().intValue());
		}

		Cell row63cell5 = row63.getCell(5);

		if (row63cell5 != null) {
			row63cell5.setCellValue(brf206Row1TO71.getR55_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR55_non_res_non_com_ent_fed().intValue());
		}
		Cell row63cell6 = row63.getCell(6);

		if (row63cell6 != null) {
			row63cell6.setCellValue(brf206Row1TO71.getR55_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR55_non_res_loc_gov().intValue());
		}
		Cell row63cell7 = row63.getCell(7);

		if (row63cell7 != null) {
			row63cell7.setCellValue(brf206Row1TO71.getR55_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR55_non_res_non_com_ent_emi().intValue());
		}
		Cell row63cell8 = row63.getCell(8);

		if (row63cell8 != null) {
			row63cell8.setCellValue(brf206Row1TO71.getR55_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR55_non_res_gre_gov().intValue());
		}
		Cell row63cell9 = row63.getCell(9);

		if (row63cell9 != null) {
			row63cell9.setCellValue(brf206Row1TO71.getR55_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR55_non_res_pri_gre_gov().intValue());
		}
		Cell row63cell10 = row63.getCell(10);

		if (row63cell10 != null) {
			row63cell10.setCellValue(brf206Row1TO71.getR55_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR55_non_res_pri_banks().intValue());
		}
		Cell row63cell11 = row63.getCell(11);

		if (row63cell11 != null) {
			row63cell11.setCellValue(brf206Row1TO71.getR55_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR55_non_res_pri_fin_ins().intValue());
		}
		Cell row63cell12 = row63.getCell(12);

		if (row63cell12 != null) {
			row63cell12.setCellValue(brf206Row1TO71.getR55_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR55_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 64 - ENTITY ROW 56 */
		Row row64 = sheet.getRow(64);

		Cell row64cell4 = row64.getCell(4);

		if (row64cell4 != null) {
			row64cell4.setCellValue(brf206Row1TO71.getR56_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR56_non_res_fed_gov().intValue());
		}

		Cell row64cell5 = row64.getCell(5);

		if (row64cell5 != null) {
			row64cell5.setCellValue(brf206Row1TO71.getR56_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR56_non_res_non_com_ent_fed().intValue());
		}
		Cell row64cell6 = row64.getCell(6);

		if (row64cell6 != null) {
			row64cell6.setCellValue(brf206Row1TO71.getR56_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR56_non_res_loc_gov().intValue());
		}
		Cell row64cell7 = row64.getCell(7);

		if (row64cell7 != null) {
			row64cell7.setCellValue(brf206Row1TO71.getR56_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR56_non_res_non_com_ent_emi().intValue());
		}
		Cell row64cell8 = row64.getCell(8);

		if (row64cell8 != null) {
			row64cell8.setCellValue(brf206Row1TO71.getR56_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR56_non_res_gre_gov().intValue());
		}
		Cell row64cell9 = row64.getCell(9);

		if (row64cell9 != null) {
			row64cell9.setCellValue(brf206Row1TO71.getR56_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR56_non_res_pri_gre_gov().intValue());
		}
		Cell row64cell10 = row64.getCell(10);

		if (row64cell10 != null) {
			row64cell10.setCellValue(brf206Row1TO71.getR56_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR56_non_res_pri_banks().intValue());
		}
		Cell row64cell11 = row64.getCell(11);

		if (row64cell11 != null) {
			row64cell11.setCellValue(brf206Row1TO71.getR56_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR56_non_res_pri_fin_ins().intValue());
		}
		Cell row64cell12 = row64.getCell(12);

		if (row64cell12 != null) {
			row64cell12.setCellValue(brf206Row1TO71.getR56_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR56_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 65 - ENTITY ROW 57 */
		Row row65 = sheet.getRow(65);

		Cell row65cell4 = row65.getCell(4);

		if (row65cell4 != null) {
			row65cell4.setCellValue(brf206Row1TO71.getR57_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR57_non_res_fed_gov().intValue());
		}

		Cell row65cell5 = row65.getCell(5);

		if (row65cell5 != null) {
			row65cell5.setCellValue(brf206Row1TO71.getR57_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR57_non_res_non_com_ent_fed().intValue());
		}
		Cell row65cell6 = row65.getCell(6);

		if (row65cell6 != null) {
			row65cell6.setCellValue(brf206Row1TO71.getR57_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR57_non_res_loc_gov().intValue());
		}
		Cell row65cell7 = row65.getCell(7);

		if (row65cell7 != null) {
			row65cell7.setCellValue(brf206Row1TO71.getR57_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR57_non_res_non_com_ent_emi().intValue());
		}
		Cell row65cell8 = row65.getCell(8);

		if (row65cell8 != null) {
			row65cell8.setCellValue(brf206Row1TO71.getR57_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR57_non_res_gre_gov().intValue());
		}
		Cell row65cell9 = row65.getCell(9);

		if (row65cell9 != null) {
			row65cell9.setCellValue(brf206Row1TO71.getR57_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR57_non_res_pri_gre_gov().intValue());
		}
		Cell row65cell10 = row65.getCell(10);

		if (row65cell10 != null) {
			row65cell10.setCellValue(brf206Row1TO71.getR57_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR57_non_res_pri_banks().intValue());
		}
		Cell row65cell11 = row65.getCell(11);

		if (row65cell11 != null) {
			row65cell11.setCellValue(brf206Row1TO71.getR57_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR57_non_res_pri_fin_ins().intValue());
		}
		Cell row65cell12 = row65.getCell(12);

		if (row65cell12 != null) {
			row65cell12.setCellValue(brf206Row1TO71.getR57_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR57_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 66 - ENTITY ROW 58 */
		Row row66 = sheet.getRow(66);

		Cell row66cell4 = row66.getCell(4);

		if (row66cell4 != null) {
			row66cell4.setCellValue(brf206Row1TO71.getR58_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR58_non_res_fed_gov().intValue());
		}

		Cell row66cell5 = row66.getCell(5);

		if (row66cell5 != null) {
			row66cell5.setCellValue(brf206Row1TO71.getR58_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR58_non_res_non_com_ent_fed().intValue());
		}
		Cell row66cell6 = row66.getCell(6);

		if (row66cell6 != null) {
			row66cell6.setCellValue(brf206Row1TO71.getR58_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR58_non_res_loc_gov().intValue());
		}
		Cell row66cell7 = row66.getCell(7);

		if (row66cell7 != null) {
			row66cell7.setCellValue(brf206Row1TO71.getR58_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR58_non_res_non_com_ent_emi().intValue());
		}
		Cell row66cell8 = row66.getCell(8);

		if (row66cell8 != null) {
			row66cell8.setCellValue(brf206Row1TO71.getR58_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR58_non_res_gre_gov().intValue());
		}
		Cell row66cell9 = row66.getCell(9);

		if (row66cell9 != null) {
			row66cell9.setCellValue(brf206Row1TO71.getR58_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR58_non_res_pri_gre_gov().intValue());
		}
		Cell row66cell10 = row66.getCell(10);

		if (row66cell10 != null) {
			row66cell10.setCellValue(brf206Row1TO71.getR58_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR58_non_res_pri_banks().intValue());
		}
		Cell row66cell11 = row66.getCell(11);

		if (row66cell11 != null) {
			row66cell11.setCellValue(brf206Row1TO71.getR58_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR58_non_res_pri_fin_ins().intValue());
		}
		Cell row66cell12 = row66.getCell(12);

		if (row66cell12 != null) {
			row66cell12.setCellValue(brf206Row1TO71.getR58_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR58_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 67 - ENTITY ROW 59 */
		Row row67 = sheet.getRow(67);

		Cell row67cell4 = row67.getCell(4);

		if (row67cell4 != null) {
			row67cell4.setCellValue(brf206Row1TO71.getR59_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR59_non_res_fed_gov().intValue());
		}

		Cell row67cell5 = row67.getCell(5);

		if (row67cell5 != null) {
			row67cell5.setCellValue(brf206Row1TO71.getR59_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR59_non_res_non_com_ent_fed().intValue());
		}
		Cell row67cell6 = row67.getCell(6);

		if (row67cell6 != null) {
			row67cell6.setCellValue(brf206Row1TO71.getR59_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR59_non_res_loc_gov().intValue());
		}
		Cell row67cell7 = row67.getCell(7);

		if (row67cell7 != null) {
			row67cell7.setCellValue(brf206Row1TO71.getR59_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR59_non_res_non_com_ent_emi().intValue());
		}
		Cell row67cell8 = row67.getCell(8);

		if (row67cell8 != null) {
			row67cell8.setCellValue(brf206Row1TO71.getR59_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR59_non_res_gre_gov().intValue());
		}
		Cell row67cell9 = row67.getCell(9);

		if (row67cell9 != null) {
			row67cell9.setCellValue(brf206Row1TO71.getR59_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR59_non_res_pri_gre_gov().intValue());
		}
		Cell row67cell10 = row67.getCell(10);

		if (row67cell10 != null) {
			row67cell10.setCellValue(brf206Row1TO71.getR59_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR59_non_res_pri_banks().intValue());
		}
		Cell row67cell11 = row67.getCell(11);

		if (row67cell11 != null) {
			row67cell11.setCellValue(brf206Row1TO71.getR59_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR59_non_res_pri_fin_ins().intValue());
		}
		Cell row67cell12 = row67.getCell(12);

		if (row67cell12 != null) {
			row67cell12.setCellValue(brf206Row1TO71.getR59_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR59_non_res_pri_other_pri_ent().intValue());
		}

		/* EXCEL ROW 68 - ENTITY ROW 60 */
		Row row68 = sheet.getRow(68);

		Cell row68cell4 = row68.getCell(4);

		if (row68cell4 != null) {
			row68cell4.setCellValue(brf206Row1TO71.getR60_non_res_fed_gov() == null ? 0
					: brf206Row1TO71.getR60_non_res_fed_gov().intValue());
		}

		Cell row68cell5 = row68.getCell(5);

		if (row68cell5 != null) {
			row68cell5.setCellValue(brf206Row1TO71.getR60_non_res_non_com_ent_fed() == null ? 0
					: brf206Row1TO71.getR60_non_res_non_com_ent_fed().intValue());
		}
		Cell row68cell6 = row68.getCell(6);

		if (row68cell6 != null) {
			row68cell6.setCellValue(brf206Row1TO71.getR60_non_res_loc_gov() == null ? 0
					: brf206Row1TO71.getR60_non_res_loc_gov().intValue());
		}
		Cell row68cell7 = row68.getCell(7);

		if (row68cell7 != null) {
			row68cell7.setCellValue(brf206Row1TO71.getR60_non_res_non_com_ent_emi() == null ? 0
					: brf206Row1TO71.getR60_non_res_non_com_ent_emi().intValue());
		}
		Cell row68cell8 = row68.getCell(8);

		if (row68cell8 != null) {
			row68cell8.setCellValue(brf206Row1TO71.getR60_non_res_gre_gov() == null ? 0
					: brf206Row1TO71.getR60_non_res_gre_gov().intValue());
		}
		Cell row68cell9 = row68.getCell(9);

		if (row68cell9 != null) {
			row68cell9.setCellValue(brf206Row1TO71.getR60_non_res_pri_gre_gov() == null ? 0
					: brf206Row1TO71.getR60_non_res_pri_gre_gov().intValue());
		}
		Cell row68cell10 = row68.getCell(10);

		if (row68cell10 != null) {
			row68cell10.setCellValue(brf206Row1TO71.getR60_non_res_pri_banks() == null ? 0
					: brf206Row1TO71.getR60_non_res_pri_banks().intValue());
		}
		Cell row68cell11 = row68.getCell(11);

		if (row68cell11 != null) {
			row68cell11.setCellValue(brf206Row1TO71.getR60_non_res_pri_fin_ins() == null ? 0
					: brf206Row1TO71.getR60_non_res_pri_fin_ins().intValue());
		}
		Cell row68cell12 = row68.getCell(12);

		if (row68cell12 != null) {
			row68cell12.setCellValue(brf206Row1TO71.getR60_non_res_pri_other_pri_ent() == null ? 0
					: brf206Row1TO71.getR60_non_res_pri_other_pri_ent().intValue());
		}
	}

}
