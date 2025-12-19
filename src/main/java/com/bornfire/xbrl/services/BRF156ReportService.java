
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

import com.bornfire.xbrl.entities.BRF156_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF156ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF156_DETAILENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF156_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF156_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF156_ENTITY1REP;
import com.bornfire.xbrl.entities.BRBS.BRF35_ENTITY;
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

public class BRF156ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF156ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	T1CurProdServicesRepo t1CurProdServiceRepo;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF156_DetailRepo brf156_Detailrep;
	
	@Autowired
	BRF156ServiceRepo brf156ServiceRepo;
	
	@Autowired
	BRF156_ENTITY1REP BRF156_ENTITY1REP;
	
	
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public String preCheckBRF156(String reportId, String fromdate, String todate) {

		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportId);

		try {
			
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportId);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF156_ENTITY1 a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportId);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF156_ENTITY1 a").getSingleResult();
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
	
	public ModelAndView getBRF156View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF156_ENTITY1> T1rep = new ArrayList<BRF156_ENTITY1>();
		// Query<Object[]> qr;

		List<BRF156_ENTITY1> T1Master = new ArrayList<BRF156_ENTITY1>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
			
			List<Object[]> T1Master1 = BRF156_ENTITY1REP.findllvalues(todate);
			
			for( Object[] BRF156_ENTITY1 : T1Master1) {
				
				BRF156_ENTITY1 BRF156 = new BRF156_ENTITY1();
				System.out.println(BRF156_ENTITY1[0]);
				Date deal_date = BRF156_ENTITY1[0] != null ? (Date) BRF156_ENTITY1[0] : null;
				BRF156.setDeal_date(deal_date); 
				BigDecimal usdamount = BRF156_ENTITY1[1] != null ? (BigDecimal) BRF156_ENTITY1[1] : new BigDecimal("0");
				BRF156.setUsd_amount(usdamount);
				BigDecimal aedamount = BRF156_ENTITY1[2] != null ? (BigDecimal) BRF156_ENTITY1[2] : new BigDecimal("0");
				BRF156.setAed_amount(aedamount);
				Date dealmaturitydate = BRF156_ENTITY1[3] != null ? (Date) BRF156_ENTITY1[3] : null;
				BRF156.setDeal_maturity_date(dealmaturitydate);
				BRF156.setCounterparty_type(String.valueOf(BRF156_ENTITY1[4]));
				BRF156.setRow_label(String.valueOf(BRF156_ENTITY1[13]));

	

			/*
			 * T1Master =
			 * hs.createQuery("from BRF156reportentity a where a.report_date = ?1 ",
			 * BRF156reportentity.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
				
				T1Master.add(BRF156);

		}
		}catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF156");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView getBRF156Details(String reportId, String fromdate, String todate, String currency,
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

				System.out.println("1");
				qr = hs.createNativeQuery(
						"select * from BRF156_DETAILTABLE   a where report_date = ?1 and report_label_1 =?2");
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF156_DETAILTABLE a where report_date = ?1");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF156_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF156_DETAILENTITY> T1Master = new ArrayList<BRF156_DETAILENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF156_DETAILENTITY a where a.report_date = ?1", BRF156_DETAILENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		System.out.println("filter" + filter);
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

			BRF156_DETAILENTITY py = new BRF156_DETAILENTITY( cust_id,  foracid,  act_balance_amt_lc,  eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,  sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,  create_time,  modify_user,  modify_time,
					 verify_user,  verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,  report_date,  maturity_date,  gender,  version,  remarks);

			T1Dt1.add(py);

		}
		;
		System.out.println("filter" + filter);

		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("RR" + "/" + "BRF156::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	

	public File getFileBRF156(String reportId, String fromdate, String todate, String currency, String dtltype,

			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-156-A";
		
		if (!filetype.equals("xbrl")) {
			if (!filetype.equals("BRF")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF156_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF156_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF156.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF156.jrxml");
					}
				}

				//JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

				JasperReport jr 
				= JasperCompileManager.compileReport(jasperFile);

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

			}catch (Exception e) {
				e.printStackTrace();
			}

			outputFile = new File(path);

			return outputFile;

		} else {
			List<BRF35_ENTITY> T1Master = new ArrayList<>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);

				// Retrieve data
				List<Object[]> T1Master1 = BRF156_ENTITY1REP.findllvalues(todate);

				File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-156-AT.xls");

				// Load the Excel file
				Workbook workbook = WorkbookFactory.create(responseFile);
				Sheet sheet = workbook.getSheetAt(0);
				
				int rowCount = sheet.getPhysicalNumberOfRows();
				
				System.out.println("Rows in Excel Sheet : "+rowCount);

				if (!T1Master1.isEmpty()) {
					int startRow = 7; // Starting row index
					System.out.println("T1Master size: " + T1Master1.size());

					for (int index = 0; index < T1Master1.size(); index++) {
						Object[] brf156 = T1Master1.get(index);
						Row row = sheet.getRow(startRow + index);
						if (row == null) {
							row = sheet.createRow(startRow + index);
						}

						// Deal Date
						Cell cell = row.getCell(2);
						if (cell == null) {
							cell = row.createCell(2);
						}
						Date deal_date = (Date) brf156[0];
						SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
						String formattedDate = (deal_date == null) ? "N/A" : dateFormat1.format(deal_date);
						cell.setCellValue(formattedDate);

						// USD_AMOUNT
						Cell cell1 = row.getCell(3);
						if (cell1 == null) {
							cell1 = row.createCell(3);
						}
						cell1.setCellValue(brf156[1] == null ? 0 : ((BigDecimal) brf156[1]).intValue());

						// AED_AMOUNT
						Cell cell2 = row.getCell(4);
						if (cell2 == null) {
							cell2 = row.createCell(4);
						}
						cell2.setCellValue(brf156[2] == null ? 0 : ((BigDecimal) brf156[2]).intValue());

						// DEAL_MATURITY_DATE
						Cell cell3 = row.getCell(5);
						if (cell3 == null) {
							cell3 = row.createCell(5);
						}
						Date deal_maturity_date = (Date) brf156[3];
						String formattedDate1 = (deal_maturity_date == null) ? "N/A" : dateFormat1.format(deal_maturity_date);
						cell.setCellValue(formattedDate1);
						// Sell USD
						Cell cell4 = row.getCell(6);
						if (cell4 == null) {
							cell4 = row.createCell(6);
						}
						String value = (brf156[4] == null) ? "0" : brf156[4].toString();
						cell4.setCellValue(value);
					}

					// Save the changes
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

					try (FileOutputStream fileOut = new FileOutputStream(
							env.getProperty("output.exportpathfinal") + "011-BRF-156-A.xls")) {
						workbook.write(fileOut);
						System.out.println("File saved successfully at: "
								+ env.getProperty("output.exportpathfinal") + "011-BRF-156-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-156-A.xls");

	return outputFile;
}

	public String detailChanges156(BRF156_DETAILENTITY detail, String foracid, String report_addl_criteria_1,
	        BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	    String msg = "";

	    try {
	        // Specific operations that might throw exceptions
	        Session hs = sessionFactory.getCurrentSession();
	        Optional<BRF156_DETAILENTITY> Brf156detail = brf156_Detailrep.findById(foracid);

	        if (Brf156detail.isPresent()) {
	            BRF156_DETAILENTITY BRFdetail = Brf156detail.get();

	            if (BRFdetail != null && report_label_1 != null && report_name_1 != null && report_addl_criteria_1 != null) {
	                if (act_balance_amt_lc.equals(BRFdetail.getAct_balance_amt_lc()) &&
	                        report_label_1.equals(BRFdetail.getReport_label_1()) &&
	                        report_name_1.equals(BRFdetail.getReport_name_1()) &&
	                        report_addl_criteria_1.equals(BRFdetail.getReport_addl_criteria_1())) {
	                    msg = "No modification done";
	                } else {
	                    BRFdetail.setAct_balance_amt_lc(act_balance_amt_lc);
	                    BRFdetail.setReport_label_1(report_label_1);
	                    BRFdetail.setReport_name_1(report_name_1);
	                    BRFdetail.setReport_addl_criteria_1(report_addl_criteria_1);
	                    brf156_Detailrep.save(BRFdetail);

	                    logger.info("Edited Record");
	                    msg = "Edited Successfully";
	                }
	            } else {
	                msg = "Some input parameters are null";
	            }
	        } else {
	            msg = "No data Found";
	        }
	    } catch (Exception e) {
	        // Catching specific exceptions related to the operations above
	        msg = "Error occurred. Please contact Administrator";
	        e.printStackTrace();
	    }

	    return msg;
	}

	
	public ModelAndView getArchieveBRF156AView(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF156_ENTITY1> T1rep = new ArrayList<BRF156_ENTITY1>();
		// Query<Object[]> qr;

		List<BRF156_ENTITY1> T1Master = new ArrayList<BRF156_ENTITY1>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
			
			List<Object[]> T1Master1 = BRF156_ENTITY1REP.findllvalues(todate);
			
			for( Object[] BRF156_ENTITY1 : T1Master1) {
				
				BRF156_ENTITY1 BRF156 = new BRF156_ENTITY1();
				System.out.println(BRF156_ENTITY1[0]);
				Date deal_date = BRF156_ENTITY1[0] != null ? (Date) BRF156_ENTITY1[0] : null;
				BRF156.setDeal_date(deal_date); 
				BigDecimal usdamount = BRF156_ENTITY1[1] != null ? (BigDecimal) BRF156_ENTITY1[1] : new BigDecimal("0");
				BRF156.setUsd_amount(usdamount);
				BigDecimal aedamount = BRF156_ENTITY1[2] != null ? (BigDecimal) BRF156_ENTITY1[2] : new BigDecimal("0");
				BRF156.setAed_amount(aedamount);
				Date dealmaturitydate = BRF156_ENTITY1[3] != null ? (Date) BRF156_ENTITY1[3] : null;
				BRF156.setDeal_maturity_date(dealmaturitydate);
				BRF156.setCounterparty_type(String.valueOf(BRF156_ENTITY1[4]));
				BRF156.setRow_label(String.valueOf(BRF156_ENTITY1[13]));

	

			/*
			 * T1Master =
			 * hs.createQuery("from BRF156reportentity a where a.report_date = ?1 ",
			 * BRF156reportentity.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
				
				T1Master.add(BRF156);

		}
		}catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF156ARCH");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	public ModelAndView ARCHgetBRF156currentDtl(String reportId, String fromdate, String todate, String currency,
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

				System.out.println("1");
				qr = hs.createNativeQuery(
						"select * from BRF156_ARCHIVTABLE   a where report_date = ?1 and report_label_1 =?2");
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF156_ARCHIVTABLE a where report_date = ?1");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF156_ARCHIVTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF156_ARCHIVENTITY> T1Master = new ArrayList<BRF156_ARCHIVENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF156_ARCHIVENTITY a where a.report_date = ?1", BRF156_ARCHIVENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		logger.info("Getting Report Detail for : " + reportId + "," + fromdate + "," + todate + "," + currency);
		List<Object[]> result = qr.getResultList();
		System.out.println("filter" + filter);
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

			BRF156_ARCHIVENTITY py = new BRF156_ARCHIVENTITY( cust_id,  foracid,  act_balance_amt_lc,  eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,  sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,  create_time,  modify_user,  modify_time,
					 verify_user,  verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,  report_date,  maturity_date,  gender,  version,  remarks);

			T1Dt1.add(py);

		}
		;
		System.out.println("filter" + filter);

		List<Object> pagedlist;

		if (T1Dt1.size() < startItem) {
			pagedlist = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, T1Dt1.size());
			pagedlist = T1Dt1.subList(startItem, toIndex);
		}

		logger.info("Converting to Page");
		Page<Object> T1Dt1Page = new PageImpl<Object>(pagedlist, PageRequest.of(currentPage, pageSize), T1Dt1.size());

		mv.setViewName("RR" + "/" + "BRF156ARCH::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	

}



