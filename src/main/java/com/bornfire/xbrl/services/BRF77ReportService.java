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

import com.bornfire.xbrl.entities.BRBS.BRF77_ENTITY_REP  ;
import com.bornfire.xbrl.entities.BRBS.BRF2_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF43B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF77A_ENTITY;
 import com.bornfire.xbrl.entities.BRBS.BRF77_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF77_ENTITY;
 import com.bornfire.xbrl.entities.BRBS.BRF77_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF77_DetailRepo;
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
public class BRF77ReportService {

	private static final Logger logger = LoggerFactory.getLogger(BRF77ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	 @Autowired 
	 BRF77_DetailRepo brf77_detailrepo;
	 
	 @Autowired
		BRF77_ENTITY_REP BRF77_ENTITY1REP;
	

	
    
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheck(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				//dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF77A_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF77A_ENTITY a").getSingleResult();
					if (modcnt > 0) {
						msg = "success";
					}
				} else {
				//	msg = "Data Not available for the Report. Please Contact Administrator";
					msg = "success";

				}

			} catch (Exception e) {
				logger.info(e.getMessage());
				msg = "success";
				e.printStackTrace();

			}

			return msg;

		}	
	public ModelAndView getBRF77View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF77A_ENTITY> T1rep = new ArrayList<BRF77A_ENTITY>();
			// Query<Object[]> qr;

			List<BRF77A_ENTITY> T1Master = new ArrayList<BRF77A_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				/*
				 * T1Master = hs.createQuery("from  BRF77A_ENTITY a where a.report_date = ?1 ",
				 * BRF77A_ENTITY .class) .setParameter(1, df.parse(todate)).getResultList();
				 */

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */
				List<Object[]> T1Master1 = BRF77_ENTITY1REP.findllvalues(todate);
				
				for( Object[] BRF77A_ENTITY : T1Master1) {
					BigDecimal TOTALEXPOSURE = BigDecimal.ZERO;
					BRF77A_ENTITY BRF77 = new BRF77A_ENTITY();
					System.out.println(BRF77A_ENTITY[0]);
					 
					BRF77.setName_of_borrow_entity (String.valueOf(BRF77A_ENTITY[0]));
					BRF77.setCin_figi_gleiid (String.valueOf(BRF77A_ENTITY[1]));
					
					BRF77.setResi_non_resi (String.valueOf(BRF77A_ENTITY[2]));
					BRF77.setCountry_incorp (String.valueOf(BRF77A_ENTITY[3]));
					BRF77.setCredit_rating_borrower  (String.valueOf(BRF77A_ENTITY[4]));
					BRF77.setCredit_rating_type (String.valueOf(BRF77A_ENTITY[5]));
					BRF77.setCurrency (String.valueOf(BRF77A_ENTITY[6]));
					
					BigDecimal funded_os = BRF77A_ENTITY[7] != null ? (BigDecimal) BRF77A_ENTITY[7] : new BigDecimal("0");
					BRF77.setFunded_os(funded_os); 
					BigDecimal debit_securities = BRF77A_ENTITY[8] != null ? (BigDecimal) BRF77A_ENTITY[8] :new BigDecimal("0");
					BRF77.setDebit_securities(debit_securities); 
					BigDecimal unfunded_os = BRF77A_ENTITY[9] != null ? (BigDecimal) BRF77A_ENTITY[9] : new BigDecimal("0");
					BRF77.setUnfunded_os(unfunded_os); 
					BigDecimal ccf_equi_unfuned_os = BRF77A_ENTITY[10] != null ?  (BigDecimal) BRF77A_ENTITY[10] : new BigDecimal("0");
					BRF77.setCcf_equi_unfuned_os(ccf_equi_unfuned_os); 
					BigDecimal ccf_equi_funded_n_unfuned_limits = BRF77A_ENTITY[11] != null ?  (BigDecimal) BRF77A_ENTITY[11] : new BigDecimal("0");
					BRF77.setCcf_equi_funded_n_unfuned_limits(ccf_equi_funded_n_unfuned_limits); 
					
					BigDecimal total_exposer = BRF77A_ENTITY[12] != null ?  (BigDecimal) BRF77A_ENTITY[12] : new BigDecimal("0");
					BRF77.setTotal_exposer(total_exposer);  
					BigDecimal as_of_tier1_capital = BRF77A_ENTITY[13] != null ?  (BigDecimal) BRF77A_ENTITY[13] : new BigDecimal("0");
					BRF77.setAs_of_tier1_capital(as_of_tier1_capital); 
					BRF77.setCredit_risk_miti_type (String.valueOf(BRF77A_ENTITY[14]));
					
					BigDecimal credit_risk_miti_hair_cut = BRF77A_ENTITY[15] != null ?  (BigDecimal) BRF77A_ENTITY[15] : new BigDecimal("0");
					BRF77.setCredit_risk_miti_hair_cut(credit_risk_miti_hair_cut); 
					BigDecimal collateral_hair_cut = BRF77A_ENTITY[16] != null ?  (BigDecimal) BRF77A_ENTITY[16] : new BigDecimal("0");
					BRF77.setCollateral_hair_cut(collateral_hair_cut);  
					
					BRF77.setCbuae_class  (String.valueOf(BRF77A_ENTITY[17]));
					BigDecimal provision = BRF77A_ENTITY[18] != null ?  (BigDecimal) BRF77A_ENTITY[18] : new BigDecimal("0");
					BRF77.setProvision(provision); 
					BRF77.setRemarks (String.valueOf(BRF77A_ENTITY[19]));
					BRF77.setRow_label  (String.valueOf(BRF77A_ENTITY[20]));
					
					BigDecimal FUN = (BigDecimal) BRF77A_ENTITY[7] != null ? (BigDecimal) BRF77A_ENTITY[7] : BigDecimal.ZERO;
					BigDecimal DEBT = (BigDecimal) BRF77A_ENTITY[8] != null ? (BigDecimal) BRF77A_ENTITY[8] : BigDecimal.ZERO;
					BigDecimal CCFUNFUND = (BigDecimal) BRF77A_ENTITY[10] != null ? (BigDecimal) BRF77A_ENTITY[10] : BigDecimal.ZERO;
					BigDecimal CCFLIMIT = (BigDecimal) BRF77A_ENTITY[11] != null ? (BigDecimal) BRF77A_ENTITY[11] : BigDecimal.ZERO;

					// Calculate the total exposure by adding values
					TOTALEXPOSURE = TOTALEXPOSURE
					    .add(FUN)
					    .add(DEBT)
					    .add(CCFUNFUND)
					    .add(CCFLIMIT);

					// Set the total exposure in the BRF77 object
					BRF77.setTotal_exposer(TOTALEXPOSURE);
					   
					 
					T1Master.add(BRF77);
			} }catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF77");
			// mv.addObject("currlist", refCodeConfig.currList());
			mv.addObject("reportsummary", T1Master);
			 
			mv.addObject("getfundos", BRF77_ENTITY1REP.getfundos(todate));
			
			 mv.addObject("getdebtsecurities",BRF77_ENTITY1REP.getdebtsecurities(todate));
				
				  mv.addObject("getunfundos", BRF77_ENTITY1REP.getunfundos(todate));
				  mv.addObject("getunfundccf", BRF77_ENTITY1REP.getunfundccf(todate));
				  mv.addObject("getunusedunfundccf", BRF77_ENTITY1REP.getunusedunfundccf(todate)); 
				  mv.addObject("gettotal", BRF77_ENTITY1REP.gettotal(todate));
				  mv.addObject("gettotal", BRF77_ENTITY1REP.gettotal(todate));
				  mv.addObject("gettier1", BRF77_ENTITY1REP.gettier1(todate));
				  mv.addObject("getcrmafterhaircut", BRF77_ENTITY1REP.getcrmafterhaircut(todate));
				  mv.addObject("getcollateralafterhaircut", BRF77_ENTITY1REP.getcollateralafterhaircut(todate));
				  mv.addObject("getprovision", BRF77_ENTITY1REP.getprovision(todate));
				  mv.addObject("getcapitalcase", BRF77_ENTITY1REP.getcapitalcase(todate));
				  
			
			
			/* mv.addObject("reportsummary1", T1Master1); */
			mv.addObject("reportmaster", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			System.out.println("scv" + mv.getViewName());

			return mv;

		}
	public ModelAndView getBRF77Details(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery("select * from BRF77_DETAILTABLE   a where report_date = ?1 and report_label_1 =?2");
				qr.setParameter(2, filter);

			} else {System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF77_DETAILTABLE a where report_date = ?1");

			}
		} else {System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF77_DETAILTABLE  where report_date = ?1");
		}
		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF77_DETAIL_ENTITY> T1Master = new ArrayList<BRF77_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF77_DETAIL_ENTITY a where a.report_date = ?1", BRF77_DETAIL_ENTITY.class)
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
			Character entity_flg = (Character) a[40];
			Character modify_flg = (Character) a[41];
			Character del_flg = (Character) a[42];
			Character nre_status = (Character) a[43];
			Date report_date = (Date) a[44];
			Date maturity_date = (Date) a[45];
			String gender = (String) a[46];
			String version = (String) a[47];
			String remarks = (String) a[48];
			Character nre_flag = (Character) a[49];

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

			BRF2_DETAIL_ENTITY py = new BRF2_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
					acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
					schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
					constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
					turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
					report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
					verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
					version, remarks, nre_flag);

			T1Dt1.add(py);

		};

		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("RR" + "/" + "BRF77::reportcontent");
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

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			String path = this.env.getProperty("output.exportpath");
			String fileName = "";
			String zipFileName = "";
			File outputFile;

			logger.info("Getting Output file :" + reportId);
			fileName = "011-BRF-077-A";

			if (!filetype.equals("xbrl")) {
				if (!filetype.equals("BRF")) {
				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF77_Detail.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF77_Detail.jrxml");
						}

					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF77.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF77.jrxml");
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
					List<BRF77A_ENTITY> T1Master = new ArrayList<>();
					Session hs = sessionFactory.getCurrentSession();
					try {
						Date d1 = df.parse(todate);

						// Retrieve data
						
						List<Object[]> T1Master1 = BRF77_ENTITY1REP.findllvalues(todate);

						File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-077-AT.xls");

						// Load the Excel file
						Workbook workbook = WorkbookFactory.create(responseFile);
						Sheet sheet = workbook.getSheetAt(0);

						if (!T1Master1.isEmpty()) {
							int startRow = 9;
							System.out.println("T1Master size: " + T1Master.size());

							for (int index = 0; index < T1Master1.size(); index++) {
								Object[] BRF077 = T1Master1.get(index);
								Row row = sheet.getRow(startRow + index);
								if (row == null) {
									row = sheet.createRow(startRow + index);
								}


								Cell cell1 = row.getCell(2);
								if (cell1 == null) {
									cell1 = row.createCell(2);
								}
								cell1.setCellValue(BRF077[0] == null ? "0" : (String) BRF077[0]);

								// ISSUE_NAME
								Cell cell2 = row.getCell(3);
								if (cell2 == null) {
									cell2 = row.createCell(3);
								}
								cell2.setCellValue(BRF077[1] == null ? "0" : (String) BRF077[1]);

								// ISSUE_TRACKER
								Cell cell3 = row.getCell(4);
								if (cell3 == null) {
									cell3 = row.createCell(4);
								}
								cell3.setCellValue(BRF077[2] == null ? "0" : (String) BRF077[2]);

								// COUNTRY
								Cell cell4 = row.getCell(5);
								if (cell4 == null) {
									cell4 = row.createCell(5);
								}
								cell4.setCellValue(BRF077[3] == null ? "0" : (String) BRF077[3]);

								// COUNTRY_PARTY

								Cell cell5 = row.getCell(6);  // Assuming column 5 is where you want to place totalExposure
								if (cell5 == null) {
								    cell5 = row.createCell(6);
								}
								cell5.setCellValue(BRF077[4] == null ? "0" : (String) BRF077[4]);

								// AMOUNT
								Cell cell6 = row.getCell(7);
								if (cell6 == null) {
									cell6 = row.createCell(7);
								}
								cell6.setCellValue(BRF077[5] == null ? "0" : (String) BRF077[5]);
								
								// INDENTIFCATION_NUMBER
								Cell cell7 = row.getCell(8);
								if (cell7 == null) {
									cell7 = row.createCell(8);
								}
								cell7.setCellValue(BRF077[6] == null ? "0" : (String) BRF077[6]);

								// ISSUE_NAME
								Cell cell8 = row.getCell(9);
								if (cell8 == null) {
									cell8 = row.createCell(9);
								}
								cell8.setCellValue(BRF077[7] == null ? 0 : ((BigDecimal) BRF077[7]).intValue());

								// ISSUE_TRACKER
								Cell cell9 = row.getCell(10);
								if (cell9 == null) {
									cell9 = row.createCell(10);
								}
								cell9.setCellValue(BRF077[8] == null ? 0 : ((BigDecimal) BRF077[8]).intValue());

								// COUNTRY
								Cell cell10 = row.getCell(11);
								if (cell10 == null) {
									cell10 = row.createCell(11);
								}
								cell10.setCellValue(BRF077[9] == null ? 0 : ((BigDecimal) BRF077[9]).intValue());

								// COUNTRY_PARTY

								Cell cell11 = row.getCell(12);  // Assuming column 5 is where you want to place totalExposure
								if (cell11 == null) {
								    cell11 = row.createCell(12);
								}
								cell11.setCellValue(BRF077[10] == null ? 0 : ((BigDecimal) BRF077[10]).intValue());
								
								Cell cell12 = row.getCell(13);  // Assuming column 5 is where you want to place totalExposure
								if (cell12 == null) {
								    cell12 = row.createCell(13);
								}
								cell12.setCellValue(BRF077[11] == null ? 0 : ((BigDecimal) BRF077[11]).intValue());
								
								
								Cell cell13 = row.getCell(14);  // Assuming column 5 is where you want to place totalExposure
								if (cell13 == null) {
								    cell13 = row.createCell(14);
								}
								cell13.setCellValue(BRF077[12] == null ? 0 : ((BigDecimal) BRF077[12]).intValue());
								

								Cell cell14 = row.getCell(15);  // Assuming column 5 is where you want to place totalExposure
								if (cell14 == null) {
								    cell14 = row.createCell(15);
								}
								cell14.setCellValue(BRF077[13] == null ? 0 : ((BigDecimal) BRF077[13]).intValue());
								
								Cell cell15 = row.getCell(16);
								if (cell15 == null) {
									cell15 = row.createCell(16);
								}
								cell15.setCellValue(BRF077[14] == null ? "0" : (String) BRF077[14]);
								
								Cell cell16 = row.getCell(17);  // Assuming column 5 is where you want to place totalExposure
								if (cell16 == null) {
								    cell16 = row.createCell(17);
								}
								cell16.setCellValue(BRF077[15] == null ? 0 : ((BigDecimal) BRF077[15]).intValue());
								
								Cell cell17 = row.getCell(18);  // Assuming column 5 is where you want to place totalExposure
								if (cell17 == null) {
								    cell17 = row.createCell(18);
								}
								cell17.setCellValue(BRF077[16] == null ? 0 : ((BigDecimal) BRF077[16]).intValue());
								
								Cell cell18 = row.getCell(19);
								if (cell18 == null) {
									cell18 = row.createCell(19);
								}
								cell18.setCellValue(BRF077[17] == null ? "0" : (String) BRF077[17]);
								
								Cell cell19 = row.getCell(20);
								if (cell19 == null) {
									cell19 = row.createCell(20);
								}
								cell19.setCellValue(BRF077[18] == null ? 0 : ((BigDecimal) BRF077[18]).intValue());
								
								Cell cell20 = row.getCell(21);
								if (cell20 == null) {
									cell20 = row.createCell(21);
								}
								cell20.setCellValue(BRF077[19] == null ? "0" : (String) BRF077[19]);
								
							}

							// Save the changes
							workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

							try (FileOutputStream fileOut = new FileOutputStream(
									env.getProperty("output.exportpathfinal") + "011-BRF-077-A.xls")) {
								workbook.write(fileOut);
								System.out.println("File saved successfully at: "
										+ env.getProperty("output.exportpathfinal") + "011-BRF-077-A.xls");
							}

							// Close the workbook
							workbook.close();
						} else {
							System.out.println("No data found for the specified date.");
						}

					} catch (ParseException e) {
						e.printStackTrace();
					} catch (EncryptedDocumentException e) {
						e.printStackTrace();
					} catch (InvalidFormatException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-077-A.xls");

			return outputFile;

		}

	
		public String detailChanges77(BRF77_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
				BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

			String msg = "";

			try {

				Session hs = sessionFactory.getCurrentSession();
				Optional<BRF77_DETAIL_ENTITY> Brf77detail =brf77_detailrepo.findById(foracid);

				if (Brf77detail.isPresent()) {
					BRF77_DETAIL_ENTITY BRFdetail = Brf77detail.get();

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
						brf77_detailrepo.save(BRFdetail);

//							hs.saveOrUpdate(detail);
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
		public ModelAndView getArchieveBRF077View(String reportId, String fromdate, String todate, String currency,
				String dtltype, Pageable pageable) {

			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF77A_ENTITY> T1rep = new ArrayList<BRF77A_ENTITY>();
			// Query<Object[]> qr;

			List<BRF77A_ENTITY> T1Master = new ArrayList<BRF77A_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				/*
				 * T1Master = hs.createQuery("from  BRF77A_ENTITY a where a.report_date = ?1 ",
				 * BRF77A_ENTITY .class) .setParameter(1, df.parse(todate)).getResultList();
				 */

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */
				List<Object[]> T1Master1 = BRF77_ENTITY1REP.findllvalues(todate);
				
				for( Object[] BRF77A_ENTITY : T1Master1) {
					BigDecimal TOTALEXPOSURE = BigDecimal.ZERO;
					BRF77A_ENTITY BRF77 = new BRF77A_ENTITY();
					System.out.println(BRF77A_ENTITY[0]);
					 
					BRF77.setName_of_borrow_entity (String.valueOf(BRF77A_ENTITY[0]));
					BRF77.setCin_figi_gleiid (String.valueOf(BRF77A_ENTITY[1]));
					
					BRF77.setResi_non_resi (String.valueOf(BRF77A_ENTITY[2]));
					BRF77.setCountry_incorp (String.valueOf(BRF77A_ENTITY[3]));
					BRF77.setCredit_rating_borrower  (String.valueOf(BRF77A_ENTITY[4]));
					BRF77.setCredit_rating_type (String.valueOf(BRF77A_ENTITY[5]));
					BRF77.setCurrency (String.valueOf(BRF77A_ENTITY[6]));
					
					BigDecimal funded_os = BRF77A_ENTITY[7] != null ? (BigDecimal) BRF77A_ENTITY[7] : new BigDecimal("0");
					BRF77.setFunded_os(funded_os); 
					BigDecimal debit_securities = BRF77A_ENTITY[8] != null ? (BigDecimal) BRF77A_ENTITY[8] :new BigDecimal("0");
					BRF77.setDebit_securities(debit_securities); 
					BigDecimal unfunded_os = BRF77A_ENTITY[9] != null ? (BigDecimal) BRF77A_ENTITY[9] : new BigDecimal("0");
					BRF77.setUnfunded_os(unfunded_os); 
					BigDecimal ccf_equi_unfuned_os = BRF77A_ENTITY[10] != null ?  (BigDecimal) BRF77A_ENTITY[10] : new BigDecimal("0");
					BRF77.setCcf_equi_unfuned_os(ccf_equi_unfuned_os); 
					BigDecimal ccf_equi_funded_n_unfuned_limits = BRF77A_ENTITY[11] != null ?  (BigDecimal) BRF77A_ENTITY[11] : new BigDecimal("0");
					BRF77.setCcf_equi_funded_n_unfuned_limits(ccf_equi_funded_n_unfuned_limits); 
					
					BigDecimal total_exposer = BRF77A_ENTITY[12] != null ?  (BigDecimal) BRF77A_ENTITY[12] : new BigDecimal("0");
					BRF77.setTotal_exposer(total_exposer);  
					BigDecimal as_of_tier1_capital = BRF77A_ENTITY[13] != null ?  (BigDecimal) BRF77A_ENTITY[13] : new BigDecimal("0");
					BRF77.setAs_of_tier1_capital(as_of_tier1_capital); 
					BRF77.setCredit_risk_miti_type (String.valueOf(BRF77A_ENTITY[14]));
					
					BigDecimal credit_risk_miti_hair_cut = BRF77A_ENTITY[15] != null ?  (BigDecimal) BRF77A_ENTITY[15] : new BigDecimal("0");
					BRF77.setCredit_risk_miti_hair_cut(credit_risk_miti_hair_cut); 
					BigDecimal collateral_hair_cut = BRF77A_ENTITY[16] != null ?  (BigDecimal) BRF77A_ENTITY[16] : new BigDecimal("0");
					BRF77.setCollateral_hair_cut(collateral_hair_cut);  
					
					BRF77.setCbuae_class  (String.valueOf(BRF77A_ENTITY[17]));
					BigDecimal provision = BRF77A_ENTITY[18] != null ?  (BigDecimal) BRF77A_ENTITY[18] : new BigDecimal("0");
					BRF77.setProvision(provision); 
					BRF77.setRemarks (String.valueOf(BRF77A_ENTITY[19]));
					BRF77.setRow_label  (String.valueOf(BRF77A_ENTITY[20]));
					
					BigDecimal FUN = (BigDecimal) BRF77A_ENTITY[7] != null ? (BigDecimal) BRF77A_ENTITY[7] : BigDecimal.ZERO;
					BigDecimal DEBT = (BigDecimal) BRF77A_ENTITY[8] != null ? (BigDecimal) BRF77A_ENTITY[8] : BigDecimal.ZERO;
					BigDecimal CCFUNFUND = (BigDecimal) BRF77A_ENTITY[10] != null ? (BigDecimal) BRF77A_ENTITY[10] : BigDecimal.ZERO;
					BigDecimal CCFLIMIT = (BigDecimal) BRF77A_ENTITY[11] != null ? (BigDecimal) BRF77A_ENTITY[11] : BigDecimal.ZERO;

					// Calculate the total exposure by adding values
					TOTALEXPOSURE = TOTALEXPOSURE
					    .add(FUN)
					    .add(DEBT)
					    .add(CCFUNFUND)
					    .add(CCFLIMIT);

					// Set the total exposure in the BRF77 object
					BRF77.setTotal_exposer(TOTALEXPOSURE);
					   
					 
					T1Master.add(BRF77);
			} }catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF77ARCH");
			// mv.addObject("currlist", refCodeConfig.currList());
			mv.addObject("reportsummary", T1Master);
			 
			mv.addObject("getfundos", BRF77_ENTITY1REP.getfundos(todate));
			
			 mv.addObject("getdebtsecurities",BRF77_ENTITY1REP.getdebtsecurities(todate));
				
				  mv.addObject("getunfundos", BRF77_ENTITY1REP.getunfundos(todate));
				  mv.addObject("getunfundccf", BRF77_ENTITY1REP.getunfundccf(todate));
				  mv.addObject("getunusedunfundccf", BRF77_ENTITY1REP.getunusedunfundccf(todate)); 
				  mv.addObject("gettotal", BRF77_ENTITY1REP.gettotal(todate));
				  mv.addObject("gettotal", BRF77_ENTITY1REP.gettotal(todate));
				  mv.addObject("gettier1", BRF77_ENTITY1REP.gettier1(todate));
				  mv.addObject("getcrmafterhaircut", BRF77_ENTITY1REP.getcrmafterhaircut(todate));
				  mv.addObject("getcollateralafterhaircut", BRF77_ENTITY1REP.getcollateralafterhaircut(todate));
				  mv.addObject("getprovision", BRF77_ENTITY1REP.getprovision(todate));
				  mv.addObject("getcapitalcase", BRF77_ENTITY1REP.getcapitalcase(todate));
				  
			
			
			/* mv.addObject("reportsummary1", T1Master1); */
			mv.addObject("reportmaster", T1Master);
			mv.addObject("displaymode", "summary");
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			System.out.println("scv" + mv.getViewName());

			return mv;

		}

		/**** ARCH DETAILS 
		 * @throws ParseException ****/

		public ModelAndView ARCHgetBRF077currentDtl(String reportId, String fromdate, String todate, String currency,
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

					qr = hs.createNativeQuery("select * from BRF77_ARCHIVTABLE a where report_date=?1 and report_lable_1=?2");
					qr.setParameter(1, df.parse(todate));
					qr.setParameter(2, filter);

				} else {
					System.out.println("2");
					qr = hs.createNativeQuery("select * from BRF77_ARCHIVTABLE");

				}
			} else {
				System.out.println("3");
				qr = hs.createNativeQuery("select * from BRF77_ARCHIVTABLE  where report_date = ?1");
			}

			/*
			 * try { qr.setParameter(1, df.parse(todate));
			 * 
			 * } catch (ParseException e) { e.printStackTrace(); }
			 */
			List<BRF77_ARCHIVENTITY> T1Master = new ArrayList<BRF77_ARCHIVENTITY>();

			try {
				System.out.println("Values entered");
				T1Master = hs.createQuery("from BRF77_ARCHIVENTITY a where a.report_date = ?1", BRF77_ARCHIVENTITY.class)
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
				Character entity_flg = (Character) a[40];
				Character modify_flg = (Character) a[41];
				Character del_flg = (Character) a[42];
				Character nre_status = (Character) a[43];
				Date report_date = (Date) a[44];
				Date maturity_date = (Date) a[45];
				String gender = (String) a[46];
				String version = (String) a[47];
				String remarks = (String) a[48];
				Character nre_flag = (Character) a[49];

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

				BRF77_ARCHIVENTITY py = new BRF77_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
						acct_crncy_code, gl_code, gl_sub_head_code, gl_sub_head_desc, country_of_incorp, cust_type,
						schm_code, schm_type, sol_id, acid, segment, sub_segment, sector, sub_sector, sector_code, group_id,
						constitution_code, country, legal_entity_type, constitution_desc, purpose_of_advn, hni_networth,
						turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1, report_addl_criteria_2,
						report_addl_criteria_3, create_user, create_time, modify_user, modify_time, verify_user,
						verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date, gender,
						version, remarks, nre_flag);
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

			mv.setViewName("RR" + "/" + "BRF77ARCH::reportcontent");
			mv.addObject("reportdetails", T1Dt1Page.getContent());
			mv.addObject("reportmaster", T1Master);
			mv.addObject("reportmaster1", qr);
			mv.addObject("singledetail", new T1CurProdDetail());
			mv.addObject("reportsflag", "reportsflag");
			mv.addObject("menu", reportId);
			return mv;
		}
}