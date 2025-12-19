package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
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
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.IOException;
import javax.sql.DataSource;

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
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bornfire.xbrl.entities.BRBS.BRF78_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF1_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF78_ARCHIV_ENTITY;

import com.bornfire.xbrl.entities.BRBS.BRF78_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF78_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF78_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF78_ENTITY_REP;
//import com.bornfire.xbrl.entities.BRBS.BRF80_ENTITY1;
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
public class BRF78ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF78ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF78_DetailRepo brf78_detailrepo;

	@Autowired
	BRF78_ENTITY_REP BRF78_ENTITY1REP;
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF78_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF78_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF78View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
				ModelAndView mv = new ModelAndView();
				Session hs = sessionFactory.getCurrentSession();
				int pageSize = pageable.getPageSize();
				int currentPage = pageable.getPageNumber();
				int startItem = currentPage * pageSize;
				
			     List<BRF78_ENTITY1> T1rep = new ArrayList<BRF78_ENTITY1>(); 
List<BRF78_ENTITY> T1Master = new ArrayList<BRF78_ENTITY>();
				

				logger.info("Inside archive" +currency);

				try {
					Date d1 = df.parse(todate);
				

					T1Master = hs.createQuery("from BRF78_ENTITY a where a.report_date = ?1 ", BRF78_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					List<Object[]> T1rep1 = BRF78_ENTITY1REP.findllvalues(todate);
					
					for( Object[] BRF78_ENTITY1 : T1rep1) {
						BigDecimal TOTALEXPOSURE = BigDecimal.ZERO;
						BRF78_ENTITY1 BRF78 = new BRF78_ENTITY1();
						System.out.println(BRF78_ENTITY1[0]);
						BRF78.setBorrowing_entity (String.valueOf(BRF78_ENTITY1[0]));
						
						System.out.println(BRF78_ENTITY1[1]);
						BRF78.setEmirate  (String.valueOf(BRF78_ENTITY1[1]));
						
						System.out.println(BRF78_ENTITY1[2]);
						BRF78.setCin  (String.valueOf(BRF78_ENTITY1[2]));
						
						System.out.println(BRF78_ENTITY1[3]);
						BRF78.setBorrower_type  (String.valueOf(BRF78_ENTITY1[3]));
						
						System.out.println(BRF78_ENTITY1[4]);
						BRF78.setGroup_name  (String.valueOf(BRF78_ENTITY1[4]));
						
						System.out.println(BRF78_ENTITY1[5]);
						BRF78.setCredit_rating_of_the_borrower  (String.valueOf(BRF78_ENTITY1[5]));
						
						System.out.println(BRF78_ENTITY1[6]);
						BRF78.setCredit_rating_type  (String.valueOf(BRF78_ENTITY1[6]));
						
						System.out.println(BRF78_ENTITY1[7]);
						BRF78.setCurrency  (String.valueOf(BRF78_ENTITY1[7]));
					
						BigDecimal fundos = BRF78_ENTITY1[8] != null ? (BigDecimal) BRF78_ENTITY1[8] : new BigDecimal("0");
						BRF78.setFunded_os(fundos);
						
						BigDecimal debit_securities = BRF78_ENTITY1[9] != null ? (BigDecimal) BRF78_ENTITY1[9] : new BigDecimal("0");
						BRF78.setDebt_securities(debit_securities);
						
						BigDecimal unfunded_os = BRF78_ENTITY1[10] != null ? (BigDecimal) BRF78_ENTITY1[10] : new BigDecimal("0");
						BRF78.setUnfunded_os(unfunded_os);
						
						BigDecimal ccf_equ_unfunded_os = BRF78_ENTITY1[11] != null ? (BigDecimal) BRF78_ENTITY1[11] : new BigDecimal("0");
						BRF78.setCcf_equ_unfunded_os(ccf_equ_unfunded_os);
						
						BigDecimal ccf_equ_comm_unused_unfund = BRF78_ENTITY1[12] != null ? (BigDecimal) BRF78_ENTITY1[12] : new BigDecimal("0");
						BRF78.setCcf_equ_comm_unused_unfund(ccf_equ_comm_unused_unfund);
						
						BigDecimal total_exposure = BRF78_ENTITY1[13] != null ? (BigDecimal) BRF78_ENTITY1[13] : new BigDecimal("0");
						BRF78.setTotal_exposure(total_exposure);
						
						BigDecimal tier_1_capital = BRF78_ENTITY1[14] != null ? (BigDecimal) BRF78_ENTITY1[14] : new BigDecimal("0");
						BRF78.setTier_1_capital(tier_1_capital);
						
						System.out.println(BRF78_ENTITY1[15]);
						BRF78.setCredit_risk_mitigation_type  (String.valueOf(BRF78_ENTITY1[15]));
						
						BigDecimal credit_risk_mitigation_after_haircut = BRF78_ENTITY1[16] != null ? (BigDecimal) BRF78_ENTITY1[16] : new BigDecimal("0");
						BRF78.setCredit_risk_mitigation_after_haircut(credit_risk_mitigation_after_haircut);
						
						BigDecimal collateral_value_after_haircut = BRF78_ENTITY1[17] != null ? (BigDecimal) BRF78_ENTITY1[17] : new BigDecimal("0");
						BRF78.setCollateral_value_after_haircut(collateral_value_after_haircut);
						
						System.out.println(BRF78_ENTITY1[18]);
						BRF78.setCbuae_classification  (String.valueOf(BRF78_ENTITY1[18]));
						
						BigDecimal provision = BRF78_ENTITY1[19] != null ? (BigDecimal) BRF78_ENTITY1[19] : new BigDecimal("0");
						BRF78.setProvision(provision);
						
						
						System.out.println(BRF78_ENTITY1[20]);
						BRF78.setRemarks  (String.valueOf(BRF78_ENTITY1[20]));
						
						System.out.println(BRF78_ENTITY1[21]);
						BRF78.setRow_label  (String.valueOf(BRF78_ENTITY1[21]));
						
						// Total exposure
						
						BigDecimal FUN = (BigDecimal) BRF78_ENTITY1[8] != null ? (BigDecimal) BRF78_ENTITY1[8] : BigDecimal.ZERO;
						BigDecimal DEBT = (BigDecimal) BRF78_ENTITY1[9] != null ? (BigDecimal) BRF78_ENTITY1[9] : BigDecimal.ZERO;
						BigDecimal CCFEQUUNFUNDOS = (BigDecimal) BRF78_ENTITY1[11] != null ? (BigDecimal) BRF78_ENTITY1[11] : BigDecimal.ZERO;
						BigDecimal CCFEQUCOMMUNUSEDUNFUND = (BigDecimal) BRF78_ENTITY1[12] != null ? (BigDecimal) BRF78_ENTITY1[12] : BigDecimal.ZERO;

						// Calculate the total exposure by adding values
						TOTALEXPOSURE = TOTALEXPOSURE
						    .add(FUN)
						    .add(DEBT)
						    .add(CCFEQUUNFUNDOS)
						    .add(CCFEQUCOMMUNUSEDUNFUND);
						    

						// Set the total exposure in the BRF77 object
						BRF78.setTotal_exposure(TOTALEXPOSURE);
						
						// Calculate the ratio of total exposure to Tier 1 capital
						BigDecimal tier_1_capital_1;
						if (tier_1_capital.compareTo(BigDecimal.ZERO) != 0) {
							tier_1_capital_1 = TOTALEXPOSURE.divide(tier_1_capital, MathContext.DECIMAL128); // Use appropriate MathContext
						} else {
							tier_1_capital_1 = BigDecimal.ZERO; // Handle division by zero
						}

						// Optionally, set the ratio in the BRF80 object or use it as needed
						BRF78.setTier_1_capital(tier_1_capital_1);
						 
						T1rep.add(BRF78);
						
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}

				

				mv.setViewName("RR/BRF78");
				mv.addObject("reportsummary", T1Master);
				mv.addObject("reportsummary2", T1rep);
				mv.addObject("getfunded_os", BRF78_ENTITY1REP.getfunded_os(todate));
			    mv.addObject("getdebt_securities",BRF78_ENTITY1REP.getdebt_securities(todate));
			    mv.addObject("getunfunded_os", BRF78_ENTITY1REP.getunfunded_os(todate));
			    mv.addObject("getccf_equ_unfunded_os", BRF78_ENTITY1REP.getccf_equ_unfunded_os(todate));
				mv.addObject("getccf_equ_comm_unused_unfund", BRF78_ENTITY1REP.getccf_equ_comm_unused_unfund(todate)); 
				
				mv.addObject("getcredit_risk_mitigation_after_haircut", BRF78_ENTITY1REP.getcredit_risk_mitigation_after_haircut(todate));
			    mv.addObject("getcollateral_value_after_haircut", BRF78_ENTITY1REP.getcollateral_value_after_haircut(todate));
				mv.addObject("getprovision", BRF78_ENTITY1REP.getprovision(todate));
				 mv.addObject("gettotal_exposure", BRF78_ENTITY1REP.gettotal(todate));
				 
				 
				 BigDecimal funded_os = BRF78_ENTITY1REP.getfunded_os(todate) != null ? new BigDecimal(BRF78_ENTITY1REP.getfunded_os(todate)) : BigDecimal.ZERO;
				 BigDecimal debit_securities = BRF78_ENTITY1REP.getdebt_securities(todate) != null ? new BigDecimal(BRF78_ENTITY1REP.getdebt_securities(todate)) : BigDecimal.ZERO;
				 BigDecimal CCF_EQUI_UNFUNED_OS = BRF78_ENTITY1REP.getccf_equ_unfunded_os(todate) != null ? new BigDecimal(BRF78_ENTITY1REP.getccf_equ_unfunded_os(todate)) : BigDecimal.ZERO;
				 BigDecimal ccf_equi_funded_n_unfuned_limits = BRF78_ENTITY1REP.getccf_equ_comm_unused_unfund(todate) != null ? new BigDecimal(BRF78_ENTITY1REP.getccf_equ_comm_unused_unfund(todate)) : BigDecimal.ZERO;

				 BigDecimal total_exposerd = funded_os.add(debit_securities).add(CCF_EQUI_UNFUNED_OS).add(ccf_equi_funded_n_unfuned_limits);
				 mv.addObject("total_exposerd", total_exposerd);

				 // Fetching the value of getTier1_capital
				 String getTier1_capital = BRF78_ENTITY1REP.getTier1_capital(todate);
				 BigDecimal tier1Capital = new BigDecimal(getTier1_capital);

				 // Adding total_exposer and getTier1_capital to the ModelAndView
				 mv.addObject("getTier1_capital", tier1Capital);

				 BigDecimal as_of_tier1_capitald;
				 if (tier1Capital.compareTo(BigDecimal.ZERO) == 0) {
				     as_of_tier1_capitald = BigDecimal.ZERO;
				 } else {
				     as_of_tier1_capitald = total_exposerd.divide(tier1Capital, MathContext.DECIMAL128);
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

	public ModelAndView getBRF78Details(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF78_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF78_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF78_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF78_DETAIL_ENTITY> T1Master = new ArrayList<BRF78_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF78_DETAIL_ENTITY a where a.report_date = ?1", BRF78_DETAIL_ENTITY.class)
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
			String nreflag = (String) a[49];

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

			BRF78_DETAIL_ENTITY py = new BRF78_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF78::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	public File getFile(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile = null;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-078-A";

		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF78_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF78_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF78.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF78.jrxml");
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
				List<BRF78_ENTITY> T1Master = new ArrayList<BRF78_ENTITY>();
			    List<Object[]> T1rep = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF78_ENTITY a where a.report_date = ?1 ", BRF78_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					if (T1Master.size() == 1) {

						for (BRF78_ENTITY BRF078 : T1Master) {

							File Responsecamt = new File(
									env.getProperty("output.exportpathtemp") + "011-BRF-078-AT.xls");

							// Load the Excel file
							Workbook workbook;
							try {
							    workbook = WorkbookFactory.create(Responsecamt);
							} catch (IOException | InvalidFormatException e) {
							    throw new RuntimeException("Error loading Excel file: " + Responsecamt.getPath(), e);
							}
							Sheet sheet = workbook.getSheetAt(0);
							 try {
							
							
/////srl_no -12////////

							Row row = sheet.getRow(11);
							Cell cell = row.getCell(10);
							if (cell != null) {
								cell.setCellValue(
										BRF078.getR2_funded_os() == null ? 0 : BRF078.getR2_funded_os().intValue());
							}
							Cell cell1 = row.getCell(11);
							if (cell1 != null) {
								cell1.setCellValue(BRF078.getR2_debit_securities() == null ? 0
										: BRF078.getR2_debit_securities().intValue());
							}
							Cell cell2 = row.getCell(12);
							if (cell2 != null) {
								cell2.setCellValue(
										BRF078.getR2_unfunded_os() == null ? 0 : BRF078.getR2_unfunded_os().intValue());
							}
							Cell cell3 = row.getCell(13);
							if (cell3 != null) {
								cell3.setCellValue(BRF078.getR2_ccf_equivalent_os() == null ? 0
										: BRF078.getR2_ccf_equivalent_os().intValue());
							}
							Cell cell4 = row.getCell(14);
							if (cell4 != null) {
								cell4.setCellValue(BRF078.getR2_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR2_ccf_equivalent_of_limits().intValue());
							}

							Cell cell5 = row.getCell(17);
							if (cell5 != null) {
								cell5.setCellValue(BRF078.getR2_credit_risk_type() == null ? 0
										: BRF078.getR2_credit_risk_type().intValue());
							}
							Cell cell6 = row.getCell(18);
							if (cell6 != null) {
								cell6.setCellValue(BRF078.getR2_credit_risk_cut() == null ? 0
										: BRF078.getR2_credit_risk_cut().intValue());
							}
							Cell cell7 = row.getCell(19);
							if (cell7 != null) {
								cell7.setCellValue(BRF078.getR2_collateral_cut() == null ? 0
										: BRF078.getR2_collateral_cut().intValue());
							}
							Cell cell8 = row.getCell(20);
							if (cell8 != null) {
								String classification = BRF078.getR2_cbuae_classification() == null ? ""
										: BRF078.getR2_cbuae_classification().toString();
								cell8.setCellValue(classification);
							}
							Cell cell9 = row.getCell(21);
							if (cell9 != null) {
								cell9.setCellValue(
										BRF078.getR2_provision() == null ? 0 : BRF078.getR2_provision().intValue());
							}
							Cell cell10 = row.getCell(22);
							if (cell10 != null) {
								String remarks = BRF078.getR2_remarks() == null ? "" : BRF078.getR2_remarks();
								cell10.setCellValue(remarks);
							}

							///// srl_no -13////////

							Row row2 = sheet.getRow(12);
							Cell R2cell = row2.getCell(10);
							if (R2cell != null) {
								R2cell.setCellValue(
										BRF078.getR3_funded_os() == null ? 0 : BRF078.getR3_funded_os().intValue());
							}
							Cell R2cell1 = row2.getCell(11);
							if (R2cell1 != null) {
								R2cell1.setCellValue(BRF078.getR3_debit_securities() == null ? 0
										: BRF078.getR3_debit_securities().intValue());
							}
							Cell R2cell2 = row2.getCell(12);
							if (R2cell2 != null) {
								R2cell2.setCellValue(
										BRF078.getR3_unfunded_os() == null ? 0 : BRF078.getR3_unfunded_os().intValue());
							}
							Cell R2cell3 = row2.getCell(13);
							if (R2cell3 != null) {
								R2cell3.setCellValue(BRF078.getR3_ccf_equivalent_os() == null ? 0
										: BRF078.getR3_ccf_equivalent_os().intValue());
							}
							Cell R2cell4 = row2.getCell(14);
							if (R2cell4 != null) {
								R2cell4.setCellValue(BRF078.getR3_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR3_ccf_equivalent_of_limits().intValue());
							}

							Cell R2cell5 = row2.getCell(17);
							if (R2cell5 != null) {
								R2cell5.setCellValue(BRF078.getR3_credit_risk_type() == null ? 0
										: BRF078.getR3_credit_risk_type().intValue());
							}
							Cell R2cell6 = row2.getCell(18);
							if (R2cell6 != null) {
								R2cell6.setCellValue(BRF078.getR3_credit_risk_cut() == null ? 0
										: BRF078.getR3_credit_risk_cut().intValue());
							}
							Cell R2cell7 = row2.getCell(19);
							if (R2cell7 != null) {
								R2cell7.setCellValue(BRF078.getR3_collateral_cut() == null ? 0
										: BRF078.getR3_collateral_cut().intValue());
							}
							Cell R2cell8 = row2.getCell(20);
							if (R2cell8 != null) {
								String classification = BRF078.getR3_cbuae_classification() == null ? ""
										: BRF078.getR3_cbuae_classification().toString();
								R2cell8.setCellValue(classification);
							}
							Cell R2cell9 = row2.getCell(21);
							if (R2cell9 != null) {
								R2cell9.setCellValue(
										BRF078.getR3_provision() == null ? 0 : BRF078.getR3_provision().intValue());
							}
							Cell R2cell10 = row2.getCell(22);
							if (R2cell10 != null) {
								String remarks = BRF078.getR3_remarks() == null ? "" : BRF078.getR3_remarks();
								R2cell10.setCellValue(remarks);
							}

/////srl_no -14////////

							Row row3 = sheet.getRow(13);
							Cell R3cell = row3.getCell(10);
							if (R3cell != null) {
								R3cell.setCellValue(
										BRF078.getR4_funded_os() == null ? 0 : BRF078.getR4_funded_os().intValue());
							}
							Cell R3cell1 = row3.getCell(11);
							if (R3cell1 != null) {
								R3cell1.setCellValue(BRF078.getR4_debit_securities() == null ? 0
										: BRF078.getR4_debit_securities().intValue());
							}
							Cell R3cell2 = row3.getCell(12);
							if (R3cell2 != null) {
								R3cell2.setCellValue(
										BRF078.getR4_unfunded_os() == null ? 0 : BRF078.getR4_unfunded_os().intValue());
							}
							Cell R3cell3 = row3.getCell(13);
							if (R3cell3 != null) {
								R3cell3.setCellValue(BRF078.getR4_ccf_equivalent_os() == null ? 0
										: BRF078.getR4_ccf_equivalent_os().intValue());
							}
							Cell R3cell4 = row3.getCell(14);
							if (R3cell4 != null) {
								R3cell4.setCellValue(BRF078.getR4_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR4_ccf_equivalent_of_limits().intValue());
							}

							Cell R3cell5 = row3.getCell(17);
							if (R3cell5 != null) {
								R3cell5.setCellValue(BRF078.getR4_credit_risk_type() == null ? 0
										: BRF078.getR4_credit_risk_type().intValue());
							}
							Cell R3cell6 = row3.getCell(18);
							if (R3cell6 != null) {
								R3cell6.setCellValue(BRF078.getR4_credit_risk_cut() == null ? 0
										: BRF078.getR4_credit_risk_cut().intValue());
							}
							Cell R3cell7 = row3.getCell(19);
							if (R3cell7 != null) {
								R3cell7.setCellValue(BRF078.getR4_collateral_cut() == null ? 0
										: BRF078.getR4_collateral_cut().intValue());
							}
							Cell R3cell8 = row3.getCell(20);
							if (R3cell8 != null) {
								String classification = BRF078.getR4_cbuae_classification() == null ? ""
										: BRF078.getR4_cbuae_classification().toString();
								R3cell8.setCellValue(classification);
							}
							Cell R3cell9 = row3.getCell(21);
							if (R3cell9 != null) {
								R3cell9.setCellValue(
										BRF078.getR4_provision() == null ? 0 : BRF078.getR4_provision().intValue());
							}
							Cell R3cell10 = row3.getCell(22);
							if (R3cell10 != null) {
								String remarks = BRF078.getR4_remarks() == null ? "" : BRF078.getR4_remarks();
								R3cell10.setCellValue(remarks);
							}

/////srl_no -15////////

							Row row4 = sheet.getRow(14);
							Cell R4cell = row4.getCell(10);
							if (R4cell != null) {
								R4cell.setCellValue(
										BRF078.getR5_funded_os() == null ? 0 : BRF078.getR5_funded_os().intValue());
							}
							Cell R4cell1 = row4.getCell(11);
							if (R4cell1 != null) {
								R4cell1.setCellValue(BRF078.getR5_debit_securities() == null ? 0
										: BRF078.getR5_debit_securities().intValue());
							}
							Cell R4cell2 = row4.getCell(12);
							if (R4cell2 != null) {
								R4cell2.setCellValue(
										BRF078.getR5_unfunded_os() == null ? 0 : BRF078.getR5_unfunded_os().intValue());
							}
							Cell R4cell3 = row4.getCell(13);
							if (R4cell3 != null) {
								R4cell3.setCellValue(BRF078.getR5_ccf_equivalent_os() == null ? 0
										: BRF078.getR5_ccf_equivalent_os().intValue());
							}
							Cell R4cell4 = row4.getCell(14);
							if (R4cell4 != null) {
								R4cell4.setCellValue(BRF078.getR5_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR5_ccf_equivalent_of_limits().intValue());
							}

							Cell R4cell5 = row4.getCell(17);
							if (R4cell5 != null) {
								R4cell5.setCellValue(BRF078.getR5_credit_risk_type() == null ? 0
										: BRF078.getR5_credit_risk_type().intValue());
							}
							Cell R4cell6 = row4.getCell(18);
							if (R4cell6 != null) {
								R4cell6.setCellValue(BRF078.getR5_credit_risk_cut() == null ? 0
										: BRF078.getR5_credit_risk_cut().intValue());
							}
							Cell R4cell7 = row4.getCell(19);
							if (R4cell7 != null) {
								R4cell7.setCellValue(BRF078.getR5_collateral_cut() == null ? 0
										: BRF078.getR5_collateral_cut().intValue());
							}
							Cell R4cell8 = row4.getCell(20);
							if (R4cell8 != null) {
								String classification = BRF078.getR5_cbuae_classification() == null ? ""
										: BRF078.getR5_cbuae_classification().toString();
								R4cell8.setCellValue(classification);
							}
							Cell R4cell9 = row4.getCell(21);
							if (R4cell9 != null) {
								R4cell9.setCellValue(
										BRF078.getR5_provision() == null ? 0 : BRF078.getR5_provision().intValue());
							}
							Cell R4cell10 = row4.getCell(22);
							if (R4cell10 != null) {
								String remarks = BRF078.getR5_remarks() == null ? "" : BRF078.getR5_remarks();
								R4cell10.setCellValue(remarks);
							}

/////srl_no -16////////

							Row row5 = sheet.getRow(15);
							Cell R5cell = row5.getCell(10);
							if (R5cell != null) {
								R5cell.setCellValue(
										BRF078.getR6_funded_os() == null ? 0 : BRF078.getR6_funded_os().intValue());
							}
							Cell R5cell1 = row5.getCell(11);
							if (R5cell1 != null) {
								R5cell1.setCellValue(BRF078.getR6_debit_securities() == null ? 0
										: BRF078.getR6_debit_securities().intValue());
							}
							Cell R5cell2 = row5.getCell(12);
							if (R5cell2 != null) {
								R5cell2.setCellValue(
										BRF078.getR6_unfunded_os() == null ? 0 : BRF078.getR6_unfunded_os().intValue());
							}
							Cell R5cell3 = row5.getCell(13);
							if (R5cell3 != null) {
								R5cell3.setCellValue(BRF078.getR6_ccf_equivalent_os() == null ? 0
										: BRF078.getR6_ccf_equivalent_os().intValue());
							}
							Cell R5cell4 = row5.getCell(14);
							if (R5cell4 != null) {
								R5cell4.setCellValue(BRF078.getR6_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR6_ccf_equivalent_of_limits().intValue());
							}

							Cell R5cell5 = row5.getCell(17);
							if (R5cell5 != null) {
								R5cell5.setCellValue(BRF078.getR6_credit_risk_type() == null ? 0
										: BRF078.getR6_credit_risk_type().intValue());
							}
							Cell R5cell6 = row5.getCell(18);
							if (R5cell6 != null) {
								R5cell6.setCellValue(BRF078.getR6_credit_risk_cut() == null ? 0
										: BRF078.getR6_credit_risk_cut().intValue());
							}
							Cell R5cell7 = row5.getCell(19);
							if (R5cell7 != null) {
								R5cell7.setCellValue(BRF078.getR6_collateral_cut() == null ? 0
										: BRF078.getR6_collateral_cut().intValue());
							}
							Cell R5cell8 = row5.getCell(20);
							if (R5cell8 != null) {
								String classification = BRF078.getR6_cbuae_classification() == null ? ""
										: BRF078.getR6_cbuae_classification().toString();
								R5cell8.setCellValue(classification);
							}
							Cell R5cell9 = row5.getCell(21);
							if (R5cell9 != null) {
								R5cell9.setCellValue(
										BRF078.getR6_provision() == null ? 0 : BRF078.getR6_provision().intValue());
							}
							Cell R5cell10 = row5.getCell(22);
							if (R5cell10 != null) {
								String remarks = BRF078.getR6_remarks() == null ? "" : BRF078.getR6_remarks();
								R5cell10.setCellValue(remarks);
							}

/////srl_no -17////////

							Row row6 = sheet.getRow(16);
							Cell R6cell = row6.getCell(10);
							if (R6cell != null) {
								R6cell.setCellValue(
										BRF078.getR7_funded_os() == null ? 0 : BRF078.getR7_funded_os().intValue());
							}
							Cell R6cell1 = row6.getCell(11);
							if (R6cell1 != null) {
								R6cell1.setCellValue(BRF078.getR7_debit_securities() == null ? 0
										: BRF078.getR7_debit_securities().intValue());
							}
							Cell R6cell2 = row6.getCell(12);
							if (R6cell2 != null) {
								R6cell2.setCellValue(
										BRF078.getR7_unfunded_os() == null ? 0 : BRF078.getR7_unfunded_os().intValue());
							}
							Cell R6cell3 = row6.getCell(13);
							if (R6cell3 != null) {
								R6cell3.setCellValue(BRF078.getR7_ccf_equivalent_os() == null ? 0
										: BRF078.getR7_ccf_equivalent_os().intValue());
							}
							Cell R6cell4 = row6.getCell(14);
							if (R6cell4 != null) {
								R6cell4.setCellValue(BRF078.getR7_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR7_ccf_equivalent_of_limits().intValue());
							}

							Cell R6cell5 = row6.getCell(17);
							if (R6cell5 != null) {
								R6cell5.setCellValue(BRF078.getR7_credit_risk_type() == null ? 0
										: BRF078.getR7_credit_risk_type().intValue());
							}
							Cell R6cell6 = row6.getCell(18);
							if (R6cell6 != null) {
								R6cell6.setCellValue(BRF078.getR7_credit_risk_cut() == null ? 0
										: BRF078.getR7_credit_risk_cut().intValue());
							}
							Cell R6cell7 = row6.getCell(19);
							if (R6cell7 != null) {
								R6cell7.setCellValue(BRF078.getR7_collateral_cut() == null ? 0
										: BRF078.getR7_collateral_cut().intValue());
							}
							Cell R6cell8 = row6.getCell(20);
							if (R6cell8 != null) {
								String classification = BRF078.getR7_cbuae_classification() == null ? ""
										: BRF078.getR7_cbuae_classification().toString();
								R6cell8.setCellValue(classification);
							}
							Cell R6cell9 = row6.getCell(21);
							if (R6cell9 != null) {
								R6cell9.setCellValue(
										BRF078.getR7_provision() == null ? 0 : BRF078.getR7_provision().intValue());
							}
							Cell R6cell10 = row6.getCell(22);
							if (R6cell10 != null) {
								String remarks = BRF078.getR7_remarks() == null ? "" : BRF078.getR7_remarks();
								R6cell10.setCellValue(remarks);
							}

/////srl_no -22////////

							Row row7 = sheet.getRow(21);
							Cell R7cell = row7.getCell(10);
							if (R7cell != null) {
								R7cell.setCellValue(
										BRF078.getR12_funded_os() == null ? 0 : BRF078.getR12_funded_os().intValue());
							}
							Cell R7cell1 = row7.getCell(11);
							if (R7cell1 != null) {
								R7cell1.setCellValue(BRF078.getR12_debit_securities() == null ? 0
										: BRF078.getR12_debit_securities().intValue());
							}
							Cell R7cell2 = row7.getCell(12);
							if (R7cell2 != null) {
								R7cell2.setCellValue(BRF078.getR12_unfunded_os() == null ? 0
										: BRF078.getR12_unfunded_os().intValue());
							}
							Cell R7cell3 = row7.getCell(13);
							if (R7cell3 != null) {
								R7cell3.setCellValue(BRF078.getR12_ccf_equivalent_os() == null ? 0
										: BRF078.getR12_ccf_equivalent_os().intValue());
							}
							Cell R7cell4 = row7.getCell(14);
							if (R7cell4 != null) {
								R7cell4.setCellValue(BRF078.getR12_ccf_equivalent_of_limits() == null ? 0
										: BRF078.getR12_ccf_equivalent_of_limits().intValue());
							}

							Cell R7cell5 = row7.getCell(17);
							if (R7cell5 != null) {
								R7cell5.setCellValue(BRF078.getR12_credit_risk_type() == null ? 0
										: BRF078.getR12_credit_risk_type().intValue());
							}
							Cell R7cell6 = row7.getCell(18);
							if (R7cell6 != null) {
								R7cell6.setCellValue(BRF078.getR12_credit_risk_cut() == null ? 0
										: BRF078.getR12_credit_risk_cut().intValue());
							}
							Cell R7cell7 = row7.getCell(19);
							if (R7cell7 != null) {
								R7cell7.setCellValue(BRF078.getR12_collateral_cut() == null ? 0
										: BRF078.getR12_collateral_cut().intValue());
							}
							Cell R7cell8 = row7.getCell(20);
							if (R7cell8 != null) {
								String classification = BRF078.getR12_cbuae_classification() == null ? ""
										: BRF078.getR12_cbuae_classification().toString();
								R7cell8.setCellValue(classification);
							}
							Cell R7cell9 = row7.getCell(21);
							if (R7cell9 != null) {
								R7cell9.setCellValue(
										BRF078.getR12_provision() == null ? 0 : BRF078.getR12_provision().intValue());

							}
							
							
							
							   updateTable3(sheet, T1rep);
							// Evaluate all formulas
			                     try {
			                         FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			                         evaluator.evaluateAll();
			                     } catch (RuntimeException e) {
			                         logger.error("Formula evaluation error, possibly due to ArrayPtg: " + e.getMessage(), e);
			                     }

			                     // Save the changes to the workbook
			                     try (FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal") + "011-BRF-078-A.xls")) {
			                         workbook.write(fileOut);
			                         logger.info("Excel File saved at: " + fileOut.getFD());
			                         path = fileOut.getFD().toString();
			                     } catch (IOException e) {
			                         throw new RuntimeException("Error writing Excel file: " + path, e);
			                     
			                 }
			            } catch (Exception e) {
			                 logger.error("Unexpected error occurred during Excel processing", e);
			             } finally {
			                 if (workbook != null) {
			                     try {
			                         workbook.close();
			                     } catch (IOException e) {
			                         logger.warn("Error closing workbook", e);
			                     }
			                 }
			             }

			             outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-078-A.xls");
			             return outputFile;
			         } }}catch (ParseException e) {
			             throw new RuntimeException("Error parsing date: " + todate, e);
			         }
			     }
			 }
			 return outputFile;
			}
	
	private void updateTable3(Sheet sheet, List<Object[]> T2rep) {
		 int startRow = 73;
		    for (int index = 0; index < T2rep.size(); index++) {
		        Object[] BRF78 = T2rep.get(index);
		       
		        Row row = sheet.getRow(startRow + index);
		        if (row == null) {
		            row = sheet.createRow(startRow + index);
		        }
		        Cell cell = row.getCell(2);
				if (cell == null) {
					cell = row.createCell(2);
				}

				String value = (BRF78[0] == null) ? "NA" : BRF78[0].toString();
				cell.setCellValue(value);

				Cell cell1 = row.getCell(3);
				if (cell1 == null) {
					cell1 = row.createCell(3);
				}
				String value1 = (BRF78[1] == null) ? "NA" : BRF78[1].toString();
				cell1.setCellValue(value1);

				Cell cell6 = row.getCell(4);
				if (cell6 == null) {
					cell6 = row.createCell(4);
				}

				String value2 = (BRF78[2] == null) ? "NA" : BRF78[2].toString();
				cell6.setCellValue(value2);
				
				Cell cell61 = row.getCell(5);
				if (cell61 == null) {
					cell61 = row.createCell(5);
				}

				String value3 = (BRF78[3] == null) ? "NA" : BRF78[3].toString();
				cell61.setCellValue(value3);

				Cell cell26 = row.getCell(6);
				if (cell26 == null) {
					cell26 = row.createCell(6);
				}

				String value4 = (BRF78[4] == null) ? "NA" : BRF78[4].toString();
				cell26.setCellValue(value4);
				
				
				Cell cell36 = row.getCell(7);
				if (cell36 == null) {
					cell36 = row.createCell(7);
				}

				String value5 = (BRF78[5] == null) ? "NA" : BRF78[5].toString();
				cell36.setCellValue(value5);

				Cell cell46 = row.getCell(8);
				if (cell46 == null) {
					cell46 = row.createCell(8);
				}

				String value6 = (BRF78[6] == null) ? "NA" : BRF78[6].toString();
				cell46.setCellValue(value6);

				Cell cell56 = row.getCell(9);
				if (cell56 == null) {
					cell56 = row.createCell(9);
				}

				String value7 = (BRF78[7] == null) ? "NA" : BRF78[7].toString();
				cell26.setCellValue(value7);
				

				Cell cell12 = row.getCell(10);
				if (cell12 == null) {
					cell12 = row.createCell(10);
				}

				cell12.setCellValue(BRF78[8] == null ? 0 : ((BigDecimal) BRF78[8]).intValue());

				
				Cell cell156 = row.getCell(11);
				if (cell156 == null) {
					cell156 = row.createCell(11);
				}

				cell156.setCellValue(BRF78[9] == null ? 0 : ((BigDecimal) BRF78[9]).intValue());
				
				Cell cell526 = row.getCell(12);
				if (cell526 == null) {
					cell526 = row.createCell(12);
				}

				cell526.setCellValue(BRF78[10] == null ? 0 : ((BigDecimal) BRF78[10]).intValue());
				
				
				Cell cell1112 = row.getCell(13);
				if (cell1112 == null) {
					cell1112 = row.createCell(13);
				}

				cell1112.setCellValue(BRF78[11] == null ? 0 : ((BigDecimal) BRF78[11]).intValue());

				
				Cell cell1113 = row.getCell(14);
				if (cell1113 == null) {
					cell1113 = row.createCell(14);
				}

				cell1113.setCellValue(BRF78[12] == null ? 0 : ((BigDecimal) BRF78[12]).intValue());

				
				Cell cell1114 = row.getCell(17);
				if (cell1114 == null) {
					cell1114 = row.createCell(17);
				}

				String value8 = (BRF78[15] == null) ? "NA" : BRF78[15].toString();
				cell26.setCellValue(value8);

				Cell cell1115 = row.getCell(18);
				if (cell1115 == null) {
					cell1115 = row.createCell(18);
				}

				cell1115.setCellValue(BRF78[16] == null ? 0 : ((BigDecimal) BRF78[16]).intValue());

				
				Cell cell1116 = row.getCell(19);
				if (cell1116 == null) {
					cell1116 = row.createCell(19);
				}

				cell1116.setCellValue(BRF78[17] == null ? 0 : ((BigDecimal) BRF78[17]).intValue());

				
				Cell cell1117 = row.getCell(20);
				if (cell1117 == null) {
					cell1117 = row.createCell(20);
				}

				String value1117 = (BRF78[18] == null) ? "NA" : BRF78[18].toString();
				cell1117.setCellValue(value1117);
				
				Cell cell1118 = row.getCell(21);
				if (cell1118 == null) {
					cell1118 = row.createCell(21);
				}

				cell1118.setCellValue(BRF78[19] == null ? 0 : ((BigDecimal) BRF78[19]).intValue());

				
				Cell cell1119 = row.getCell(22);
				if (cell1119 == null) {
					cell1119 = row.createCell(22);
				}

				String value1119 = (BRF78[20] == null) ? "NA" : BRF78[20].toString();
				cell1119.setCellValue(value1119);
					 
				
			}}


	public String detailChanges78(BRF78_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF78_DETAIL_ENTITY> Brf78detail = brf78_detailrepo.findById(foracid);

			if (Brf78detail.isPresent()) {
				BRF78_DETAIL_ENTITY BRFdetail = Brf78detail.get();

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
					brf78_detailrepo.save(BRFdetail);

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

	public ModelAndView getArchieveBRF078View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF78_ENTITY> T1rep = new ArrayList<BRF78_ENTITY>();
		// Query<Object[]> qr;

		List<BRF78_ENTITY> T1Master = new ArrayList<BRF78_ENTITY>();
		/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF78_ENTITY a where a.report_date = ?1 ", BRF78_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
			 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF78ARCH");
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

	/**
	 * ARCH DETAILS
	 * 
	 * @throws ParseException
	 **/

	public ModelAndView ARCHgetBRF078currentDtl(String reportId, String fromdate, String todate, String currency,
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

				qr = hs.createNativeQuery("select * from BRF78_ARCHIVTABLE a where report_date=?1 and report_lable=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF78_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF78_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF78_ARCHIV_ENTITY> T1Master = new ArrayList<BRF78_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF78_ARCHIV_ENTITY a where a.report_date = ?1", BRF78_ARCHIV_ENTITY.class)
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
			String nreflag = (String) a[49];

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

			BRF78_ARCHIV_ENTITY py = new BRF78_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF78ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

}