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

import com.bornfire.xbrl.entities.BRF13_ARCH_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRF2_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BASEL_OPRISK_OR1;
import com.bornfire.xbrl.entities.BRBS.BRF7_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF10_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF11_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF13_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF13_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF13_DetaiRep1;
import com.bornfire.xbrl.entities.BRBS.BRF13_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF2_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF2_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF3_DETAILTABLE;
import com.bornfire.xbrl.entities.BRBS.RBSTransactionMasterEntity;
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
public class BRF013ReportService {

	
	private static final Logger logger = LoggerFactory.getLogger(BRF013ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	/*
	 * @Autowired BRF73ServiceRepo brf73ServiceRepo;
	 */
	@Autowired
	BRF13_DetaiRep1 BRF13_DetaiRep1;
	
	
	
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
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF13_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF13_ENTITY a").getSingleResult();
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
	public ModelAndView getBRF013View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF13_ENTITY> T1rep = new ArrayList<BRF13_ENTITY>();
			// Query<Object[]> qr;

			List<BRF13_ENTITY> T1Master = new ArrayList<BRF13_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF13_ENTITY a where a.report_date = ?1 ", BRF13_ENTITY .class)
						.setParameter(1, df.parse(todate)).getResultList();

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF013A");
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
	
	public ModelAndView getOR1View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BASEL_OPRISK_OR1> T1rep = new ArrayList<BASEL_OPRISK_OR1>();
			// Query<Object[]> qr;

			List<BASEL_OPRISK_OR1> T1Master = new ArrayList<BASEL_OPRISK_OR1>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BASEL_OPRISK_OR1 a where a.report_date = ?1 ", BASEL_OPRISK_OR1 .class)
						.setParameter(1, df.parse(todate)).getResultList();

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/ReportOR1");
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
	
	public ModelAndView getBRF013currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF13_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");
 
				qr.setParameter(2, filter);
 
			} else {
				qr = hs.createNativeQuery("select * from BRF13_DETAILTABLE a where report_date = ?1");
 
			}
		} else {
			qr = hs.createNativeQuery("select * from BRF13_DETAILTABLE  where report_date = ?1");
		}
 
		try {
			qr.setParameter(1, df.parse(todate));
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF13_DETAIL_ENTITY> T1Master = new ArrayList<BRF13_DETAIL_ENTITY>();
 
		try {
			T1Master = hs.createQuery("from BRF13_DETAIL_ENTITY a where a.report_date = ?1", BRF13_DETAIL_ENTITY.class)
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
			String gender = (String)a[46];
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

			BRF13_DETAIL_ENTITY py = new BRF13_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nreflag);
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


		
		mv.setViewName("RR" + "/" + "BRF013A::reportcontent");
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
		fileName = "011-BRF-013-A";
		/*try {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
			Date ConDate = dateFormat1.parse(todate);
			System.out.println(ConDate);
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			String strDate1 = formatter1.format(ConDate);
			fileName = "t" + reportId + "_" + strDate1;
			

		} catch (ParseException e1) {

			logger.info(e1.getMessage());
			e1.printStackTrace();
		}*/

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF13_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF13_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF013.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF013.jrxml");
					}
				}

				/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
				JasperReport jr = JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_DATE", todate);
			/*	try {
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
					Date ConDate = dateFormat1.parse(todate);
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					String strDate1 = formatter1.format(ConDate);

					String today = dateFormat.format(new SimpleDateFormat("dd-MMM-yyyy").parse(strDate1));
					
				} catch (ParseException e1) {

					logger.info(e1.getMessage());
					e1.printStackTrace();
				}
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
			}else {
				
				List<BRF13_ENTITY> T1Master = new ArrayList<BRF13_ENTITY>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF13_ENTITY a where a.report_date = ?1 ", BRF13_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF13_ENTITY BRF13 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-013-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            ///Row1
	            Row r1row = sheet.getRow(8);
	            Cell r1cell0 =  r1row.getCell(3);
	            if (r1cell0 != null) {
	            	r1cell0.setCellValue(
	            			BRF13.getR1_overdue() == null ? 0 : BRF13.getR1_overdue().intValue());
	            } 
	  Cell r1cell1 =  r1row.getCell(4);
	            if (r1cell1 != null) {
	            	r1cell1.setCellValue(
	            			BRF13.getR1_overdraft() == null ? 0 : BRF13.getR1_overdraft().intValue());
	            }
	Cell r1cell2 = r1row.getCell(5);
	            if (r1cell2 != null) {
	            	r1cell2.setCellValue(
	            			BRF13.getR1_0_7_days() == null ? 0 : BRF13.getR1_0_7_days().intValue());
	            }
	Cell r1cell3 = r1row.getCell(6);
	            if (r1cell3 != null) {
	            	r1cell3.setCellValue(
	            			BRF13.getR1_8_14_days() == null ? 0 : BRF13.getR1_8_14_days().intValue());
	            }
	Cell r1cell4 = r1row.getCell(7);
	            if (r1cell4 != null) {
	            	r1cell4.setCellValue(
	            			BRF13.getR1_15_days_1_month() == null ? 0 : BRF13.getR1_15_days_1_month().intValue());
	            }
	Cell r1cell5 = r1row.getCell(8);
	            if (r1cell5 != null) {
	            	r1cell5.setCellValue(
	            			BRF13.getR1_1_3_months() == null ? 0 : BRF13.getR1_1_3_months().intValue());
	            }
	Cell r1cell6 = r1row.getCell(9);
	            if (r1cell6 != null) {
	            	r1cell6.setCellValue(
	            			BRF13.getR1_3_6_months() == null ? 0 : BRF13.getR1_3_6_months().intValue());
	            }
	Cell r1cell7 = r1row.getCell(10);
	            if (r1cell7 != null) {
	            	r1cell7.setCellValue(
	            			BRF13.getR1_6_12_months() == null ? 0 : BRF13.getR1_6_12_months().intValue());
	            }
	Cell r1cell8 = r1row.getCell(11);
	            if (r1cell8 != null) {
	            	r1cell8.setCellValue(
	            			BRF13.getR1_1_3_years() == null ? 0 : BRF13.getR1_1_3_years().intValue());
	            }
	Cell r1cell9 = r1row.getCell(12);
	            if (r1cell9 != null) {
	            	r1cell9.setCellValue(
	            			BRF13.getR1_3_years() == null ? 0 : BRF13.getR1_3_years().intValue());
	            }
	          ///Row2
	            Row r2row = sheet.getRow(9);
	            Cell r2cell0 =  r2row.getCell(3);
	            if (r2cell0 != null) {
	            	r2cell0.setCellValue(
	            			BRF13.getR2_overdue() == null ? 0 : BRF13.getR2_overdue().intValue());
	            } 
	  Cell r2cell1 =  r2row.getCell(4);
	            if (r2cell1 != null) {
	            	r2cell1.setCellValue(
	            			BRF13.getR2_overdraft() == null ? 0 : BRF13.getR2_overdraft().intValue());
	            }
	Cell r2cell2 = r2row.getCell(5);
	            if (r2cell2 != null) {
	            	r2cell2.setCellValue(
	            			BRF13.getR2_0_7_days() == null ? 0 : BRF13.getR2_0_7_days().intValue());
	            }
	Cell r2cell3 = r2row.getCell(6);
	            if (r2cell3 != null) {
	            	r2cell3.setCellValue(
	            			BRF13.getR2_8_14_days() == null ? 0 : BRF13.getR2_8_14_days().intValue());
	            }
	Cell r2cell4 = r2row.getCell(7);
	            if (r2cell4 != null) {
	            	r2cell4.setCellValue(
	            			BRF13.getR2_15_days_1_month() == null ? 0 : BRF13.getR2_15_days_1_month().intValue());
	            }
	Cell r2cell5 = r2row.getCell(8);
	            if (r2cell5 != null) {
	            	r2cell5.setCellValue(
	            			BRF13.getR2_1_3_months() == null ? 0 : BRF13.getR2_1_3_months().intValue());
	            }
	Cell r2cell6 = r2row.getCell(9);
	            if (r2cell6 != null) {
	            	r2cell6.setCellValue(
	            			BRF13.getR2_3_6_months() == null ? 0 : BRF13.getR2_3_6_months().intValue());
	            }
	Cell r2cell7 = r2row.getCell(10);
	            if (r2cell7 != null) {
	            	r2cell7.setCellValue(
	            			BRF13.getR2_6_12_months() == null ? 0 : BRF13.getR2_6_12_months().intValue());
	            }
	Cell r2cell8 = r2row.getCell(11);
	            if (r2cell8 != null) {
	            	r2cell8.setCellValue(
	            			BRF13.getR2_1_3_years() == null ? 0 : BRF13.getR2_1_3_years().intValue());
	            }
	Cell r2cell9 = r2row.getCell(12);
	            if (r2cell9 != null) {
	            	r2cell9.setCellValue(
	            			BRF13.getR2_3_years() == null ? 0 : BRF13.getR2_3_years().intValue());
	            }

	          ///Row3
	            Row r3row = sheet.getRow(10);
	            Cell r3cell0 =  r3row.getCell(3);
	            if (r3cell0 != null) {
	            	r3cell0.setCellValue(
	            			BRF13.getR3_overdue() == null ? 0 : BRF13.getR3_overdue().intValue());
	            } 
	  Cell r3cell1 =  r3row.getCell(4);
	            if (r3cell1 != null) {
	            	r3cell1.setCellValue(
	            			BRF13.getR3_overdraft() == null ? 0 : BRF13.getR3_overdraft().intValue());
	            }
	Cell r3cell2 = r3row.getCell(5);
	            if (r3cell2 != null) {
	            	r3cell2.setCellValue(
	            			BRF13.getR3_0_7_days() == null ? 0 : BRF13.getR3_0_7_days().intValue());
	            }
	Cell r3cell3 = r3row.getCell(6);
	            if (r3cell3 != null) {
	            	r3cell3.setCellValue(
	            			BRF13.getR3_8_14_days() == null ? 0 : BRF13.getR3_8_14_days().intValue());
	            }
	Cell r3cell4 = r3row.getCell(7);
	            if (r3cell4 != null) {
	            	r3cell4.setCellValue(
	            			BRF13.getR3_15_days_1_month() == null ? 0 : BRF13.getR3_15_days_1_month().intValue());
	            }
	Cell r3cell5 = r3row.getCell(8);
	            if (r3cell5 != null) {
	            	r3cell5.setCellValue(
	            			BRF13.getR3_1_3_months() == null ? 0 : BRF13.getR3_1_3_months().intValue());
	            }
	Cell r3cell6 = r3row.getCell(9);
	            if (r3cell6 != null) {
	            	r3cell6.setCellValue(
	            			BRF13.getR3_3_6_months() == null ? 0 : BRF13.getR3_3_6_months().intValue());
	            }
	Cell r3cell7 = r3row.getCell(10);
	            if (r3cell7 != null) {
	            	r3cell7.setCellValue(
	            			BRF13.getR3_6_12_months() == null ? 0 : BRF13.getR3_6_12_months().intValue());
	            }
	Cell r3cell8 = r3row.getCell(11);
	            if (r3cell8 != null) {
	            	r3cell8.setCellValue(
	            			BRF13.getR3_1_3_years() == null ? 0 : BRF13.getR3_1_3_years().intValue());
	            }
	Cell r3cell9 = r3row.getCell(12);
	            if (r3cell9 != null) {
	            	r3cell9.setCellValue(
	            			BRF13.getR3_3_years() == null ? 0 : BRF13.getR3_3_years().intValue());
	            }

	          ///Row4
	            Row r4row = sheet.getRow(12);
	            Cell r4cell0 =  r4row.getCell(3);
	            if (r4cell0 != null) {
	            	r4cell0.setCellValue(
	            			BRF13.getR4_overdue() == null ? 0 : BRF13.getR4_overdue().intValue());
	            } 
	  Cell r4cell1 =  r4row.getCell(4);
	            if (r4cell1 != null) {
	            	r4cell1.setCellValue(
	            			BRF13.getR4_overdraft() == null ? 0 : BRF13.getR4_overdraft().intValue());
	            }
	Cell r4cell2 = r4row.getCell(5);
	            if (r4cell2 != null) {
	            	r4cell2.setCellValue(
	            			BRF13.getR4_0_7_days() == null ? 0 : BRF13.getR4_0_7_days().intValue());
	            }
	Cell r4cell3 = r4row.getCell(6);
	            if (r4cell3 != null) {
	            	r4cell3.setCellValue(
	            			BRF13.getR4_8_14_days() == null ? 0 : BRF13.getR4_8_14_days().intValue());
	            }
	Cell r4cell4 = r4row.getCell(7);
	            if (r4cell4 != null) {
	            	r4cell4.setCellValue(
	            			BRF13.getR4_15_days_1_month() == null ? 0 : BRF13.getR4_15_days_1_month().intValue());
	            }
	Cell r4cell5 = r4row.getCell(8);
	            if (r4cell5 != null) {
	            	r4cell5.setCellValue(
	            			BRF13.getR4_1_3_months() == null ? 0 : BRF13.getR4_1_3_months().intValue());
	            }
	Cell r4cell6 = r4row.getCell(9);
	            if (r4cell6 != null) {
	            	r4cell6.setCellValue(
	            			BRF13.getR4_3_6_months() == null ? 0 : BRF13.getR4_3_6_months().intValue());
	            }
	Cell r4cell7 = r4row.getCell(10);
	            if (r4cell7 != null) {
	            	r4cell7.setCellValue(
	            			BRF13.getR4_6_12_months() == null ? 0 : BRF13.getR4_6_12_months().intValue());
	            }
	Cell r4cell8 = r4row.getCell(11);
	            if (r4cell8 != null) {
	            	r4cell8.setCellValue(
	            			BRF13.getR4_1_3_years() == null ? 0 : BRF13.getR4_1_3_years().intValue());
	            }
	Cell r4cell9 = r4row.getCell(12);
	            if (r4cell9 != null) {
	            	r4cell9.setCellValue(
	            			BRF13.getR4_3_years() == null ? 0 : BRF13.getR4_3_years().intValue());
	            }

	          ///Row5
	            Row r5row = sheet.getRow(13);
	            Cell r5cell0 =  r5row.getCell(3);
	            if (r5cell0 != null) {
	            	r5cell0.setCellValue(
	            			BRF13.getR5_overdue() == null ? 0 : BRF13.getR5_overdue().intValue());
	            } 
	  Cell r5cell1 =  r5row.getCell(4);
	            if (r5cell1 != null) {
	            	r5cell1.setCellValue(
	            			BRF13.getR5_overdraft() == null ? 0 : BRF13.getR5_overdraft().intValue());
	            }
	Cell r5cell2 = r5row.getCell(5);
	            if (r5cell2 != null) {
	            	r5cell2.setCellValue(
	            			BRF13.getR5_0_7_days() == null ? 0 : BRF13.getR5_0_7_days().intValue());
	            }
	Cell r5cell3 = r5row.getCell(6);
	            if (r5cell3 != null) {
	            	r5cell3.setCellValue(
	            			BRF13.getR5_8_14_days() == null ? 0 : BRF13.getR5_8_14_days().intValue());
	            }
	Cell r5cell4 = r5row.getCell(7);
	            if (r5cell4 != null) {
	            	r5cell4.setCellValue(
	            			BRF13.getR5_15_days_1_month() == null ? 0 : BRF13.getR5_15_days_1_month().intValue());
	            }
	Cell r5cell5 = r5row.getCell(8);
	            if (r5cell5 != null) {
	            	r5cell5.setCellValue(
	            			BRF13.getR5_1_3_months() == null ? 0 : BRF13.getR5_1_3_months().intValue());
	            }
	Cell r5cell6 = r5row.getCell(9);
	            if (r5cell6 != null) {
	            	r5cell6.setCellValue(
	            			BRF13.getR5_3_6_months() == null ? 0 : BRF13.getR5_3_6_months().intValue());
	            }
	Cell r5cell7 = r5row.getCell(10);
	            if (r5cell7 != null) {
	            	r5cell7.setCellValue(
	            			BRF13.getR5_6_12_months() == null ? 0 : BRF13.getR5_6_12_months().intValue());
	            }
	Cell r5cell8 = r5row.getCell(11);
	            if (r5cell8 != null) {
	            	r5cell8.setCellValue(
	            			BRF13.getR5_1_3_years() == null ? 0 : BRF13.getR5_1_3_years().intValue());
	            }
	Cell r5cell9 = r5row.getCell(12);
	            if (r5cell9 != null) {
	            	r5cell9.setCellValue(
	            			BRF13.getR5_3_years() == null ? 0 : BRF13.getR5_3_years().intValue());
	            }

	          ///Row6
	            Row r6row = sheet.getRow(15);
	            Cell r6cell0 =  r6row.getCell(3);
	            if (r6cell0 != null) {
	            	r6cell0.setCellValue(
	            			BRF13.getR6_overdue() == null ? 0 : BRF13.getR6_overdue().intValue());
	            } 
	  Cell r6cell1 =  r6row.getCell(4);
	            if (r6cell1 != null) {
	            	r6cell1.setCellValue(
	            			BRF13.getR6_overdraft() == null ? 0 : BRF13.getR6_overdraft().intValue());
	            }
	Cell r6cell2 = r6row.getCell(5);
	            if (r6cell2 != null) {
	            	r6cell2.setCellValue(
	            			BRF13.getR6_0_7_days() == null ? 0 : BRF13.getR6_0_7_days().intValue());
	            }
	Cell r6cell3 = r6row.getCell(6);
	            if (r6cell3 != null) {
	            	r6cell3.setCellValue(
	            			BRF13.getR6_8_14_days() == null ? 0 : BRF13.getR6_8_14_days().intValue());
	            }
	Cell r6cell4 = r6row.getCell(7);
	            if (r6cell4 != null) {
	            	r6cell4.setCellValue(
	            			BRF13.getR6_15_days_1_month() == null ? 0 : BRF13.getR6_15_days_1_month().intValue());
	            }
	Cell r6cell5 = r6row.getCell(8);
	            if (r6cell5 != null) {
	            	r6cell5.setCellValue(
	            			BRF13.getR6_1_3_months() == null ? 0 : BRF13.getR6_1_3_months().intValue());
	            }
	Cell r6cell6 = r6row.getCell(9);
	            if (r6cell6 != null) {
	            	r6cell6.setCellValue(
	            			BRF13.getR6_3_6_months() == null ? 0 : BRF13.getR6_3_6_months().intValue());
	            }
	Cell r6cell7 = r6row.getCell(10);
	            if (r6cell7 != null) {
	            	r6cell7.setCellValue(
	            			BRF13.getR6_6_12_months() == null ? 0 : BRF13.getR6_6_12_months().intValue());
	            }
	Cell r6cell8 = r6row.getCell(11);
	            if (r6cell8 != null) {
	            	r6cell8.setCellValue(
	            			BRF13.getR6_1_3_years() == null ? 0 : BRF13.getR6_1_3_years().intValue());
	            }
	Cell r6cell9 = r6row.getCell(12);
	            if (r6cell9 != null) {
	            	r6cell9.setCellValue(
	            			BRF13.getR6_3_years() == null ? 0 : BRF13.getR6_3_years().intValue());
	            }

	          ///Row7
	            Row r7row = sheet.getRow(16);
	            Cell r7cell0 =  r7row.getCell(3);
	            if (r7cell0 != null) {
	            	r7cell0.setCellValue(
	            			BRF13.getR7_overdue() == null ? 0 : BRF13.getR7_overdue().intValue());
	            } 
	  Cell r7cell1 =  r7row.getCell(4);
	            if (r7cell1 != null) {
	            	r7cell1.setCellValue(
	            			BRF13.getR7_overdraft() == null ? 0 : BRF13.getR7_overdraft().intValue());
	            }
	Cell r7cell2 = r7row.getCell(5);
	            if (r7cell2 != null) {
	            	r7cell2.setCellValue(
	            			BRF13.getR7_0_7_days() == null ? 0 : BRF13.getR7_0_7_days().intValue());
	            }
	Cell r7cell3 = r7row.getCell(6);
	            if (r7cell3 != null) {
	            	r7cell3.setCellValue(
	            			BRF13.getR7_8_14_days() == null ? 0 : BRF13.getR7_8_14_days().intValue());
	            }
	Cell r7cell4 = r7row.getCell(7);
	            if (r7cell4 != null) {
	            	r7cell4.setCellValue(
	            			BRF13.getR7_15_days_1_month() == null ? 0 : BRF13.getR7_15_days_1_month().intValue());
	            }
	Cell r7cell5 = r7row.getCell(8);
	            if (r7cell5 != null) {
	            	r7cell5.setCellValue(
	            			BRF13.getR7_1_3_months() == null ? 0 : BRF13.getR7_1_3_months().intValue());
	            }
	Cell r7cell6 = r7row.getCell(9);
	            if (r7cell6 != null) {
	            	r7cell6.setCellValue(
	            			BRF13.getR7_3_6_months() == null ? 0 : BRF13.getR7_3_6_months().intValue());
	            }
	Cell r7cell7 = r7row.getCell(10);
	            if (r7cell7 != null) {
	            	r7cell7.setCellValue(
	            			BRF13.getR7_6_12_months() == null ? 0 : BRF13.getR7_6_12_months().intValue());
	            }
	Cell r7cell8 = r7row.getCell(11);
	            if (r7cell8 != null) {
	            	r7cell8.setCellValue(
	            			BRF13.getR7_1_3_years() == null ? 0 : BRF13.getR7_1_3_years().intValue());
	            }
	Cell r7cell9 = r7row.getCell(12);
	            if (r7cell9 != null) {
	            	r7cell9.setCellValue(
	            			BRF13.getR7_3_years() == null ? 0 : BRF13.getR7_3_years().intValue());
	            }

	          ///Row8
	            Row r8row = sheet.getRow(17);
	            Cell r8cell0 =  r8row.getCell(3);
	            if (r8cell0 != null) {
	            	r8cell0.setCellValue(
	            			BRF13.getR8_overdue() == null ? 0 : BRF13.getR8_overdue().intValue());
	            } 
	  Cell r8cell1 =  r8row.getCell(4);
	            if (r8cell1 != null) {
	            	r8cell1.setCellValue(
	            			BRF13.getR8_overdraft() == null ? 0 : BRF13.getR8_overdraft().intValue());
	            }
	Cell r8cell2 = r8row.getCell(5);
	            if (r8cell2 != null) {
	            	r8cell2.setCellValue(
	            			BRF13.getR8_0_7_days() == null ? 0 : BRF13.getR8_0_7_days().intValue());
	            }
	Cell r8cell3 = r8row.getCell(6);
	            if (r8cell3 != null) {
	            	r8cell3.setCellValue(
	            			BRF13.getR8_8_14_days() == null ? 0 : BRF13.getR8_8_14_days().intValue());
	            }
	Cell r8cell4 = r8row.getCell(7);
	            if (r8cell4 != null) {
	            	r8cell4.setCellValue(
	            			BRF13.getR8_15_days_1_month() == null ? 0 : BRF13.getR8_15_days_1_month().intValue());
	            }
	Cell r8cell5 = r8row.getCell(8);
	            if (r8cell5 != null) {
	            	r8cell5.setCellValue(
	            			BRF13.getR8_1_3_months() == null ? 0 : BRF13.getR8_1_3_months().intValue());
	            }
	Cell r8cell6 = r8row.getCell(9);
	            if (r8cell6 != null) {
	            	r8cell6.setCellValue(
	            			BRF13.getR8_3_6_months() == null ? 0 : BRF13.getR8_3_6_months().intValue());
	            }
	Cell r8cell7 = r8row.getCell(10);
	            if (r8cell7 != null) {
	            	r8cell7.setCellValue(
	            			BRF13.getR8_6_12_months() == null ? 0 : BRF13.getR8_6_12_months().intValue());
	            }
	Cell r8cell8 = r8row.getCell(11);
	            if (r8cell8 != null) {
	            	r8cell8.setCellValue(
	            			BRF13.getR8_1_3_years() == null ? 0 : BRF13.getR8_1_3_years().intValue());
	            }
	Cell r8cell9 = r8row.getCell(12);
	            if (r8cell9 != null) {
	            	r8cell9.setCellValue(
	            			BRF13.getR8_3_years() == null ? 0 : BRF13.getR8_3_years().intValue());
	            }

	          ///Row9
	            Row r9row = sheet.getRow(18);
	            Cell r9cell0 =  r9row.getCell(3);
	            if (r9cell0 != null) {
	            	r9cell0.setCellValue(
	            			BRF13.getR9_overdue() == null ? 0 : BRF13.getR9_overdue().intValue());
	            } 
	  Cell r9cell1 =  r9row.getCell(4);
	            if (r9cell1 != null) {
	            	r9cell1.setCellValue(
	            			BRF13.getR9_overdraft() == null ? 0 : BRF13.getR9_overdraft().intValue());
	            }
	Cell r9cell2 = r9row.getCell(5);
	            if (r9cell2 != null) {
	            	r9cell2.setCellValue(
	            			BRF13.getR9_0_7_days() == null ? 0 : BRF13.getR9_0_7_days().intValue());
	            }
	Cell r9cell3 = r9row.getCell(6);
	            if (r9cell3 != null) {
	            	r9cell3.setCellValue(
	            			BRF13.getR9_8_14_days() == null ? 0 : BRF13.getR9_8_14_days().intValue());
	            }
	Cell r9cell4 = r9row.getCell(7);
	            if (r9cell4 != null) {
	            	r9cell4.setCellValue(
	            			BRF13.getR9_15_days_1_month() == null ? 0 : BRF13.getR9_15_days_1_month().intValue());
	            }
	Cell r9cell5 = r9row.getCell(8);
	            if (r9cell5 != null) {
	            	r9cell5.setCellValue(
	            			BRF13.getR9_1_3_months() == null ? 0 : BRF13.getR9_1_3_months().intValue());
	            }
	Cell r9cell6 = r9row.getCell(9);
	            if (r9cell6 != null) {
	            	r9cell6.setCellValue(
	            			BRF13.getR9_3_6_months() == null ? 0 : BRF13.getR9_3_6_months().intValue());
	            }
	Cell r9cell7 = r9row.getCell(10);
	            if (r9cell7 != null) {
	            	r9cell7.setCellValue(
	            			BRF13.getR9_6_12_months() == null ? 0 : BRF13.getR9_6_12_months().intValue());
	            }
	Cell r9cell8 = r9row.getCell(11);
	            if (r9cell8 != null) {
	            	r9cell8.setCellValue(
	            			BRF13.getR9_1_3_years() == null ? 0 : BRF13.getR9_1_3_years().intValue());
	            }
	Cell r9cell9 = r9row.getCell(12);
	            if (r9cell9 != null) {
	            	r9cell9.setCellValue(
	            			BRF13.getR9_3_years() == null ? 0 : BRF13.getR9_3_years().intValue());
	            }

	          ///Row10
	            Row r10row = sheet.getRow(19);
	            Cell r10cell0 =  r10row.getCell(3);
	            if (r10cell0 != null) {
	            	r10cell0.setCellValue(
	            			BRF13.getR10_overdue() == null ? 0 : BRF13.getR10_overdue().intValue());
	            } 
	  Cell r10cell1 =  r10row.getCell(4);
	            if (r10cell1 != null) {
	            	r10cell1.setCellValue(
	            			BRF13.getR10_overdraft() == null ? 0 : BRF13.getR10_overdraft().intValue());
	            }
	Cell r10cell2 = r10row.getCell(5);
	            if (r10cell2 != null) {
	            	r10cell2.setCellValue(
	            			BRF13.getR10_0_7_days() == null ? 0 : BRF13.getR10_0_7_days().intValue());
	            }
	Cell r10cell3 = r10row.getCell(6);
	            if (r10cell3 != null) {
	            	r10cell3.setCellValue(
	            			BRF13.getR10_8_14_days() == null ? 0 : BRF13.getR10_8_14_days().intValue());
	            }
	Cell r10cell4 = r10row.getCell(7);
	            if (r10cell4 != null) {
	            	r10cell4.setCellValue(
	            			BRF13.getR10_15_days_1_month() == null ? 0 : BRF13.getR10_15_days_1_month().intValue());
	            }
	Cell r10cell5 = r10row.getCell(8);
	            if (r10cell5 != null) {
	            	r10cell5.setCellValue(
	            			BRF13.getR10_1_3_months() == null ? 0 : BRF13.getR10_1_3_months().intValue());
	            }
	Cell r10cell6 = r10row.getCell(9);
	            if (r10cell6 != null) {
	            	r10cell6.setCellValue(
	            			BRF13.getR10_3_6_months() == null ? 0 : BRF13.getR10_3_6_months().intValue());
	            }
	Cell r10cell7 = r10row.getCell(10);
	            if (r10cell7 != null) {
	            	r10cell7.setCellValue(
	            			BRF13.getR10_6_12_months() == null ? 0 : BRF13.getR10_6_12_months().intValue());
	            }
	Cell r10cell8 = r10row.getCell(11);
	            if (r10cell8 != null) {
	            	r10cell8.setCellValue(
	            			BRF13.getR10_1_3_years() == null ? 0 : BRF13.getR10_1_3_years().intValue());
	            }
	Cell r10cell9 = r10row.getCell(12);
	            if (r10cell9 != null) {
	            	r10cell9.setCellValue(
	            			BRF13.getR10_3_years() == null ? 0 : BRF13.getR10_3_years().intValue());
	            }

	          ///Row11
	            Row r11row = sheet.getRow(20);
	            Cell r11cell0 =  r11row.getCell(3);
	            if (r11cell0 != null) {
	            	r11cell0.setCellValue(
	            			BRF13.getR11_overdue() == null ? 0 : BRF13.getR11_overdue().intValue());
	            } 
	  Cell r11cell1 =  r11row.getCell(4);
	            if (r11cell1 != null) {
	            	r11cell1.setCellValue(
	            			BRF13.getR11_overdraft() == null ? 0 : BRF13.getR11_overdraft().intValue());
	            }
	Cell r11cell2 = r11row.getCell(5);
	            if (r11cell2 != null) {
	            	r11cell2.setCellValue(
	            			BRF13.getR11_0_7_days() == null ? 0 : BRF13.getR11_0_7_days().intValue());
	            }
	Cell r11cell3 = r11row.getCell(6);
	            if (r11cell3 != null) {
	            	r11cell3.setCellValue(
	            			BRF13.getR11_8_14_days() == null ? 0 : BRF13.getR11_8_14_days().intValue());
	            }
	Cell r11cell4 = r11row.getCell(7);
	            if (r11cell4 != null) {
	            	r11cell4.setCellValue(
	            			BRF13.getR11_15_days_1_month() == null ? 0 : BRF13.getR11_15_days_1_month().intValue());
	            }
	Cell r11cell5 = r11row.getCell(8);
	            if (r11cell5 != null) {
	            	r11cell5.setCellValue(
	            			BRF13.getR11_1_3_months() == null ? 0 : BRF13.getR11_1_3_months().intValue());
	            }
	Cell r11cell6 = r11row.getCell(9);
	            if (r11cell6 != null) {
	            	r11cell6.setCellValue(
	            			BRF13.getR11_3_6_months() == null ? 0 : BRF13.getR11_3_6_months().intValue());
	            }
	Cell r11cell7 = r11row.getCell(10);
	            if (r11cell7 != null) {
	            	r11cell7.setCellValue(
	            			BRF13.getR11_6_12_months() == null ? 0 : BRF13.getR11_6_12_months().intValue());
	            }
	Cell r11cell8 = r11row.getCell(11);
	            if (r11cell8 != null) {
	            	r11cell8.setCellValue(
	            			BRF13.getR11_1_3_years() == null ? 0 : BRF13.getR11_1_3_years().intValue());
	            }
	Cell r11cell9 = r11row.getCell(12);
	            if (r11cell9 != null) {
	            	r11cell9.setCellValue(
	            			BRF13.getR11_3_years() == null ? 0 : BRF13.getR11_3_years().intValue());
	            }

	          ///Row12
	            Row r12row = sheet.getRow(21);
	            Cell r12cell0 =  r12row.getCell(3);
	            if (r12cell0 != null) {
	            	r12cell0.setCellValue(
	            			BRF13.getR12_overdue() == null ? 0 : BRF13.getR12_overdue().intValue());
	            } 
	  Cell r12cell1 =  r12row.getCell(4);
	            if (r12cell1 != null) {
	            	r12cell1.setCellValue(
	            			BRF13.getR12_overdraft() == null ? 0 : BRF13.getR12_overdraft().intValue());
	            }
	Cell r12cell2 = r12row.getCell(5);
	            if (r12cell2 != null) {
	            	r12cell2.setCellValue(
	            			BRF13.getR12_0_7_days() == null ? 0 : BRF13.getR12_0_7_days().intValue());
	            }
	Cell r12cell3 = r12row.getCell(6);
	            if (r12cell3 != null) {
	            	r12cell3.setCellValue(
	            			BRF13.getR12_8_14_days() == null ? 0 : BRF13.getR12_8_14_days().intValue());
	            }
	Cell r12cell4 = r12row.getCell(7);
	            if (r12cell4 != null) {
	            	r12cell4.setCellValue(
	            			BRF13.getR12_15_days_1_month() == null ? 0 : BRF13.getR12_15_days_1_month().intValue());
	            }
	Cell r12cell5 = r12row.getCell(8);
	            if (r12cell5 != null) {
	            	r12cell5.setCellValue(
	            			BRF13.getR12_1_3_months() == null ? 0 : BRF13.getR12_1_3_months().intValue());
	            }
	Cell r12cell6 = r12row.getCell(9);
	            if (r12cell6 != null) {
	            	r12cell6.setCellValue(
	            			BRF13.getR12_3_6_months() == null ? 0 : BRF13.getR12_3_6_months().intValue());
	            }
	Cell r12cell7 = r12row.getCell(10);
	            if (r12cell7 != null) {
	            	r12cell7.setCellValue(
	            			BRF13.getR12_6_12_months() == null ? 0 : BRF13.getR12_6_12_months().intValue());
	            }
	Cell r12cell8 = r12row.getCell(11);
	            if (r12cell8 != null) {
	            	r12cell8.setCellValue(
	            			BRF13.getR12_1_3_years() == null ? 0 : BRF13.getR12_1_3_years().intValue());
	            }
	Cell r12cell9 = r12row.getCell(12);
	            if (r12cell9 != null) {
	            	r12cell9.setCellValue(
	            			BRF13.getR12_3_years() == null ? 0 : BRF13.getR12_3_years().intValue());
	            }

	          ///Row13
	            Row r13row = sheet.getRow(22);
	            Cell r13cell0 =  r13row.getCell(3);
	            if (r13cell0 != null) {
	            	r13cell0.setCellValue(
	            			BRF13.getR13_overdue() == null ? 0 : BRF13.getR13_overdue().intValue());
	            } 
	  Cell r13cell1 =  r13row.getCell(4);
	            if (r13cell1 != null) {
	            	r13cell1.setCellValue(
	            			BRF13.getR13_overdraft() == null ? 0 : BRF13.getR13_overdraft().intValue());
	            }
	Cell r13cell2 = r13row.getCell(5);
	            if (r13cell2 != null) {
	            	r13cell2.setCellValue(
	            			BRF13.getR13_0_7_days() == null ? 0 : BRF13.getR13_0_7_days().intValue());
	            }
	Cell r13cell3 = r13row.getCell(6);
	            if (r13cell3 != null) {
	            	r13cell3.setCellValue(
	            			BRF13.getR13_8_14_days() == null ? 0 : BRF13.getR13_8_14_days().intValue());
	            }
	Cell r13cell4 = r13row.getCell(7);
	            if (r13cell4 != null) {
	            	r13cell4.setCellValue(
	            			BRF13.getR13_15_days_1_month() == null ? 0 : BRF13.getR13_15_days_1_month().intValue());
	            }
	Cell r13cell5 = r13row.getCell(8);
	            if (r13cell5 != null) {
	            	r13cell5.setCellValue(
	            			BRF13.getR13_1_3_months() == null ? 0 : BRF13.getR13_1_3_months().intValue());
	            }
	Cell r13cell6 = r13row.getCell(9);
	            if (r13cell6 != null) {
	            	r13cell6.setCellValue(
	            			BRF13.getR13_3_6_months() == null ? 0 : BRF13.getR13_3_6_months().intValue());
	            }
	Cell r13cell7 = r13row.getCell(10);
	            if (r13cell7 != null) {
	            	r13cell7.setCellValue(
	            			BRF13.getR13_6_12_months() == null ? 0 : BRF13.getR13_6_12_months().intValue());
	            }
	Cell r13cell8 = r13row.getCell(11);
	            if (r13cell8 != null) {
	            	r13cell8.setCellValue(
	            			BRF13.getR13_1_3_years() == null ? 0 : BRF13.getR13_1_3_years().intValue());
	            }
	Cell r13cell9 = r13row.getCell(12);
	            if (r13cell9 != null) {
	            	r13cell9.setCellValue(
	            			BRF13.getR13_3_years() == null ? 0 : BRF13.getR13_3_years().intValue());
	            }

	          ///Row14
	            Row r14row = sheet.getRow(23);
	            Cell r14cell0 =  r14row.getCell(3);
	            if (r14cell0 != null) {
	            	r14cell0.setCellValue(
	            			BRF13.getR14_overdue() == null ? 0 : BRF13.getR14_overdue().intValue());
	            } 
	  Cell r14cell1 =  r14row.getCell(4);
	            if (r14cell1 != null) {
	            	r14cell1.setCellValue(
	            			BRF13.getR14_overdraft() == null ? 0 : BRF13.getR14_overdraft().intValue());
	            }
	Cell r14cell2 = r14row.getCell(5);
	            if (r14cell2 != null) {
	            	r14cell2.setCellValue(
	            			BRF13.getR14_0_7_days() == null ? 0 : BRF13.getR14_0_7_days().intValue());
	            }
	Cell r14cell3 = r14row.getCell(6);
	            if (r14cell3 != null) {
	            	r14cell3.setCellValue(
	            			BRF13.getR14_8_14_days() == null ? 0 : BRF13.getR14_8_14_days().intValue());
	            }
	Cell r14cell4 = r14row.getCell(7);
	            if (r14cell4 != null) {
	            	r14cell4.setCellValue(
	            			BRF13.getR14_15_days_1_month() == null ? 0 : BRF13.getR14_15_days_1_month().intValue());
	            }
	Cell r14cell5 = r14row.getCell(8);
	            if (r14cell5 != null) {
	            	r14cell5.setCellValue(
	            			BRF13.getR14_1_3_months() == null ? 0 : BRF13.getR14_1_3_months().intValue());
	            }
	Cell r14cell6 = r14row.getCell(9);
	            if (r14cell6 != null) {
	            	r14cell6.setCellValue(
	            			BRF13.getR14_3_6_months() == null ? 0 : BRF13.getR14_3_6_months().intValue());
	            }
	Cell r14cell7 = r14row.getCell(10);
	            if (r14cell7 != null) {
	            	r14cell7.setCellValue(
	            			BRF13.getR14_6_12_months() == null ? 0 : BRF13.getR14_6_12_months().intValue());
	            }
	Cell r14cell8 = r14row.getCell(11);
	            if (r14cell8 != null) {
	            	r14cell8.setCellValue(
	            			BRF13.getR14_1_3_years() == null ? 0 : BRF13.getR14_1_3_years().intValue());
	            }
	Cell r14cell9 = r14row.getCell(12);
	            if (r14cell9 != null) {
	            	r14cell9.setCellValue(
	            			BRF13.getR14_3_years() == null ? 0 : BRF13.getR14_3_years().intValue());
	            }

	          ///Row15
	            Row r15row = sheet.getRow(24);
	            Cell r15cell0 =  r15row.getCell(3);
	            if (r15cell0 != null) {
	            	r15cell0.setCellValue(
	            			BRF13.getR15_overdue() == null ? 0 : BRF13.getR15_overdue().intValue());
	            } 
	  Cell r15cell1 =  r15row.getCell(4);
	            if (r15cell1 != null) {
	            	r15cell1.setCellValue(
	            			BRF13.getR15_overdraft() == null ? 0 : BRF13.getR15_overdraft().intValue());
	            }
	Cell r15cell2 = r15row.getCell(5);
	            if (r15cell2 != null) {
	            	r15cell2.setCellValue(
	            			BRF13.getR15_0_7_days() == null ? 0 : BRF13.getR15_0_7_days().intValue());
	            }
	Cell r15cell3 = r15row.getCell(6);
	            if (r15cell3 != null) {
	            	r15cell3.setCellValue(
	            			BRF13.getR15_8_14_days() == null ? 0 : BRF13.getR15_8_14_days().intValue());
	            }
	Cell r15cell4 = r15row.getCell(7);
	            if (r15cell4 != null) {
	            	r15cell4.setCellValue(
	            			BRF13.getR15_15_days_1_month() == null ? 0 : BRF13.getR15_15_days_1_month().intValue());
	            }
	Cell r15cell5 = r15row.getCell(8);
	            if (r15cell5 != null) {
	            	r15cell5.setCellValue(
	            			BRF13.getR15_1_3_months() == null ? 0 : BRF13.getR15_1_3_months().intValue());
	            }
	Cell r15cell6 = r15row.getCell(9);
	            if (r15cell6 != null) {
	            	r15cell6.setCellValue(
	            			BRF13.getR15_3_6_months() == null ? 0 : BRF13.getR15_3_6_months().intValue());
	            }
	Cell r15cell7 = r15row.getCell(10);
	            if (r15cell7 != null) {
	            	r15cell7.setCellValue(
	            			BRF13.getR15_6_12_months() == null ? 0 : BRF13.getR15_6_12_months().intValue());
	            }
	Cell r15cell8 = r15row.getCell(11);
	            if (r15cell8 != null) {
	            	r15cell8.setCellValue(
	            			BRF13.getR15_1_3_years() == null ? 0 : BRF13.getR15_1_3_years().intValue());
	            }
	Cell r15cell9 = r15row.getCell(12);
	            if (r15cell9 != null) {
	            	r15cell9.setCellValue(
	            			BRF13.getR15_3_years() == null ? 0 : BRF13.getR15_3_years().intValue());
	            }

	          ///Row16
	            Row r16row = sheet.getRow(26);
	            Cell r16cell0 =  r16row.getCell(3);
	            if (r16cell0 != null) {
	            	r16cell0.setCellValue(
	            			BRF13.getR16_overdue() == null ? 0 : BRF13.getR16_overdue().intValue());
	            } 
	  Cell r16cell1 =  r16row.getCell(4);
	            if (r16cell1 != null) {
	            	r16cell1.setCellValue(
	            			BRF13.getR16_overdraft() == null ? 0 : BRF13.getR16_overdraft().intValue());
	            }
	Cell r16cell2 = r16row.getCell(5);
	            if (r16cell2 != null) {
	            	r16cell2.setCellValue(
	            			BRF13.getR16_0_7_days() == null ? 0 : BRF13.getR16_0_7_days().intValue());
	            }
	Cell r16cell3 = r16row.getCell(6);
	            if (r16cell3 != null) {
	            	r16cell3.setCellValue(
	            			BRF13.getR16_8_14_days() == null ? 0 : BRF13.getR16_8_14_days().intValue());
	            }
	Cell r16cell4 = r16row.getCell(7);
	            if (r16cell4 != null) {
	            	r16cell4.setCellValue(
	            			BRF13.getR16_15_days_1_month() == null ? 0 : BRF13.getR16_15_days_1_month().intValue());
	            }
	Cell r16cell5 = r16row.getCell(8);
	            if (r16cell5 != null) {
	            	r16cell5.setCellValue(
	            			BRF13.getR16_1_3_months() == null ? 0 : BRF13.getR16_1_3_months().intValue());
	            }
	Cell r16cell6 = r16row.getCell(9);
	            if (r16cell6 != null) {
	            	r16cell6.setCellValue(
	            			BRF13.getR16_3_6_months() == null ? 0 : BRF13.getR16_3_6_months().intValue());
	            }
	Cell r16cell7 = r16row.getCell(10);
	            if (r16cell7 != null) {
	            	r16cell7.setCellValue(
	            			BRF13.getR16_6_12_months() == null ? 0 : BRF13.getR16_6_12_months().intValue());
	            }
	Cell r16cell8 = r16row.getCell(11);
	            if (r16cell8 != null) {
	            	r16cell8.setCellValue(
	            			BRF13.getR16_1_3_years() == null ? 0 : BRF13.getR16_1_3_years().intValue());
	            }
	Cell r16cell9 = r16row.getCell(12);
	            if (r16cell9 != null) {
	            	r16cell9.setCellValue(
	            			BRF13.getR16_3_years() == null ? 0 : BRF13.getR16_3_years().intValue());
	            }

	          ///Row17
	            Row r17row = sheet.getRow(27);
	            Cell r17cell0 =  r17row.getCell(3);
	            if (r17cell0 != null) {
	            	r17cell0.setCellValue(
	            			BRF13.getR17_overdue() == null ? 0 : BRF13.getR17_overdue().intValue());
	            } 
	  Cell r17cell1 =  r17row.getCell(4);
	            if (r17cell1 != null) {
	            	r17cell1.setCellValue(
	            			BRF13.getR17_overdraft() == null ? 0 : BRF13.getR17_overdraft().intValue());
	            }
	Cell r17cell2 = r17row.getCell(5);
	            if (r17cell2 != null) {
	            	r17cell2.setCellValue(
	            			BRF13.getR17_0_7_days() == null ? 0 : BRF13.getR17_0_7_days().intValue());
	            }
	Cell r17cell3 = r17row.getCell(6);
	            if (r17cell3 != null) {
	            	r17cell3.setCellValue(
	            			BRF13.getR17_8_14_days() == null ? 0 : BRF13.getR17_8_14_days().intValue());
	            }
	Cell r17cell4 = r17row.getCell(7);
	            if (r17cell4 != null) {
	            	r17cell4.setCellValue(
	            			BRF13.getR17_15_days_1_month() == null ? 0 : BRF13.getR17_15_days_1_month().intValue());
	            }
	Cell r17cell5 = r17row.getCell(8);
	            if (r17cell5 != null) {
	            	r17cell5.setCellValue(
	            			BRF13.getR17_1_3_months() == null ? 0 : BRF13.getR17_1_3_months().intValue());
	            }
	Cell r17cell6 = r17row.getCell(9);
	            if (r17cell6 != null) {
	            	r17cell6.setCellValue(
	            			BRF13.getR17_3_6_months() == null ? 0 : BRF13.getR17_3_6_months().intValue());
	            }
	Cell r17cell7 = r17row.getCell(10);
	            if (r17cell7 != null) {
	            	r17cell7.setCellValue(
	            			BRF13.getR17_6_12_months() == null ? 0 : BRF13.getR17_6_12_months().intValue());
	            }
	Cell r17cell8 = r17row.getCell(11);
	            if (r17cell8 != null) {
	            	r17cell8.setCellValue(
	            			BRF13.getR17_1_3_years() == null ? 0 : BRF13.getR17_1_3_years().intValue());
	            }
	Cell r17cell9 = r17row.getCell(12);
	            if (r17cell9 != null) {
	            	r17cell9.setCellValue(
	            			BRF13.getR17_3_years() == null ? 0 : BRF13.getR17_3_years().intValue());
	            }

	          ///Row18
	            Row r18row = sheet.getRow(28);
	            Cell r18cell0 =  r18row.getCell(3);
	            if (r18cell0 != null) {
	            	r18cell0.setCellValue(
	            			BRF13.getR18_overdue() == null ? 0 : BRF13.getR18_overdue().intValue());
	            } 
	  Cell r18cell1 =  r18row.getCell(4);
	            if (r18cell1 != null) {
	            	r18cell1.setCellValue(
	            			BRF13.getR18_overdraft() == null ? 0 : BRF13.getR18_overdraft().intValue());
	            }
	Cell r18cell2 = r18row.getCell(5);
	            if (r18cell2 != null) {
	            	r18cell2.setCellValue(
	            			BRF13.getR18_0_7_days() == null ? 0 : BRF13.getR18_0_7_days().intValue());
	            }
	Cell r18cell3 = r18row.getCell(6);
	            if (r18cell3 != null) {
	            	r18cell3.setCellValue(
	            			BRF13.getR18_8_14_days() == null ? 0 : BRF13.getR18_8_14_days().intValue());
	            }
	Cell r18cell4 = r18row.getCell(7);
	            if (r18cell4 != null) {
	            	r18cell4.setCellValue(
	            			BRF13.getR18_15_days_1_month() == null ? 0 : BRF13.getR18_15_days_1_month().intValue());
	            }
	Cell r18cell5 = r18row.getCell(8);
	            if (r18cell5 != null) {
	            	r18cell5.setCellValue(
	            			BRF13.getR18_1_3_months() == null ? 0 : BRF13.getR18_1_3_months().intValue());
	            }
	Cell r18cell6 = r18row.getCell(9);
	            if (r18cell6 != null) {
	            	r18cell6.setCellValue(
	            			BRF13.getR18_3_6_months() == null ? 0 : BRF13.getR18_3_6_months().intValue());
	            }
	Cell r18cell7 = r18row.getCell(10);
	            if (r18cell7 != null) {
	            	r18cell7.setCellValue(
	            			BRF13.getR18_6_12_months() == null ? 0 : BRF13.getR18_6_12_months().intValue());
	            }
	Cell r18cell8 = r18row.getCell(11);
	            if (r18cell8 != null) {
	            	r18cell8.setCellValue(
	            			BRF13.getR18_1_3_years() == null ? 0 : BRF13.getR18_1_3_years().intValue());
	            }
	Cell r18cell9 = r18row.getCell(12);
	            if (r18cell9 != null) {
	            	r18cell9.setCellValue(
	            			BRF13.getR18_3_years() == null ? 0 : BRF13.getR18_3_years().intValue());
	            }

	          ///Row19
	            Row r19row = sheet.getRow(29);
	            Cell r19cell0 =  r19row.getCell(3);
	            if (r19cell0 != null) {
	            	r19cell0.setCellValue(
	            			BRF13.getR19_overdue() == null ? 0 : BRF13.getR19_overdue().intValue());
	            } 
	  Cell r19cell1 =  r19row.getCell(4);
	            if (r19cell1 != null) {
	            	r19cell1.setCellValue(
	            			BRF13.getR19_overdraft() == null ? 0 : BRF13.getR19_overdraft().intValue());
	            }
	Cell r19cell2 = r19row.getCell(5);
	            if (r19cell2 != null) {
	            	r19cell2.setCellValue(
	            			BRF13.getR19_0_7_days() == null ? 0 : BRF13.getR19_0_7_days().intValue());
	            }
	Cell r19cell3 = r19row.getCell(6);
	            if (r19cell3 != null) {
	            	r19cell3.setCellValue(
	            			BRF13.getR19_8_14_days() == null ? 0 : BRF13.getR19_8_14_days().intValue());
	            }
	Cell r19cell4 = r19row.getCell(7);
	            if (r19cell4 != null) {
	            	r19cell4.setCellValue(
	            			BRF13.getR19_15_days_1_month() == null ? 0 : BRF13.getR19_15_days_1_month().intValue());
	            }
	Cell r19cell5 = r19row.getCell(8);
	            if (r19cell5 != null) {
	            	r19cell5.setCellValue(
	            			BRF13.getR19_1_3_months() == null ? 0 : BRF13.getR19_1_3_months().intValue());
	            }
	Cell r19cell6 = r19row.getCell(9);
	            if (r19cell6 != null) {
	            	r19cell6.setCellValue(
	            			BRF13.getR19_3_6_months() == null ? 0 : BRF13.getR19_3_6_months().intValue());
	            }
	Cell r19cell7 = r19row.getCell(10);
	            if (r19cell7 != null) {
	            	r19cell7.setCellValue(
	            			BRF13.getR19_6_12_months() == null ? 0 : BRF13.getR19_6_12_months().intValue());
	            }
	Cell r19cell8 = r19row.getCell(11);
	            if (r19cell8 != null) {
	            	r19cell8.setCellValue(
	            			BRF13.getR19_1_3_years() == null ? 0 : BRF13.getR19_1_3_years().intValue());
	            }
	Cell r19cell9 = r19row.getCell(12);
	            if (r19cell9 != null) {
	            	r19cell9.setCellValue(
	            			BRF13.getR19_3_years() == null ? 0 : BRF13.getR19_3_years().intValue());
	            }

	          ///Row20
	            Row r20row = sheet.getRow(30);
	            Cell r20cell0 =  r20row.getCell(3);
	            if (r20cell0 != null) {
	            	r20cell0.setCellValue(
	            			BRF13.getR20_overdue() == null ? 0 : BRF13.getR20_overdue().intValue());
	            } 
	  Cell r20cell1 =  r20row.getCell(4);
	            if (r20cell1 != null) {
	            	r20cell1.setCellValue(
	            			BRF13.getR20_overdraft() == null ? 0 : BRF13.getR20_overdraft().intValue());
	            }
	Cell r20cell2 = r20row.getCell(5);
	            if (r20cell2 != null) {
	            	r20cell2.setCellValue(
	            			BRF13.getR20_0_7_days() == null ? 0 : BRF13.getR20_0_7_days().intValue());
	            }
	Cell r20cell3 = r20row.getCell(6);
	            if (r20cell3 != null) {
	            	r20cell3.setCellValue(
	            			BRF13.getR20_8_14_days() == null ? 0 : BRF13.getR20_8_14_days().intValue());
	            }
	Cell r20cell4 = r20row.getCell(7);
	            if (r20cell4 != null) {
	            	r20cell4.setCellValue(
	            			BRF13.getR20_15_days_1_month() == null ? 0 : BRF13.getR20_15_days_1_month().intValue());
	            }
	Cell r20cell5 = r20row.getCell(8);
	            if (r20cell5 != null) {
	            	r20cell5.setCellValue(
	            			BRF13.getR20_1_3_months() == null ? 0 : BRF13.getR20_1_3_months().intValue());
	            }
	Cell r20cell6 = r20row.getCell(9);
	            if (r20cell6 != null) {
	            	r20cell6.setCellValue(
	            			BRF13.getR20_3_6_months() == null ? 0 : BRF13.getR20_3_6_months().intValue());
	            }
	Cell r20cell7 = r20row.getCell(10);
	            if (r20cell7 != null) {
	            	r20cell7.setCellValue(
	            			BRF13.getR20_6_12_months() == null ? 0 : BRF13.getR20_6_12_months().intValue());
	            }
	Cell r20cell8 = r20row.getCell(11);
	            if (r20cell8 != null) {
	            	r20cell8.setCellValue(
	            			BRF13.getR20_1_3_years() == null ? 0 : BRF13.getR20_1_3_years().intValue());
	            }
	Cell r20cell9 = r20row.getCell(12);
	            if (r20cell9 != null) {
	            	r20cell9.setCellValue(
	            			BRF13.getR20_3_years() == null ? 0 : BRF13.getR20_3_years().intValue());
	            }

	          ///Row21
	            Row r21row = sheet.getRow(32);
	            Cell r21cell0 =  r21row.getCell(3);
	            if (r21cell0 != null) {
	            	r21cell0.setCellValue(
	            			BRF13.getR21_overdue() == null ? 0 : BRF13.getR21_overdue().intValue());
	            } 
	  Cell r21cell1 =  r21row.getCell(4);
	            if (r21cell1 != null) {
	            	r21cell1.setCellValue(
	            			BRF13.getR21_overdraft() == null ? 0 : BRF13.getR21_overdraft().intValue());
	            }
	Cell r21cell2 = r21row.getCell(5);
	            if (r21cell2 != null) {
	            	r21cell2.setCellValue(
	            			BRF13.getR21_0_7_days() == null ? 0 : BRF13.getR21_0_7_days().intValue());
	            }
	Cell r21cell3 = r21row.getCell(6);
	            if (r21cell3 != null) {
	            	r21cell3.setCellValue(
	            			BRF13.getR21_8_14_days() == null ? 0 : BRF13.getR21_8_14_days().intValue());
	            }
	Cell r21cell4 = r21row.getCell(7);
	            if (r21cell4 != null) {
	            	r21cell4.setCellValue(
	            			BRF13.getR21_15_days_1_month() == null ? 0 : BRF13.getR21_15_days_1_month().intValue());
	            }
	Cell r21cell5 = r21row.getCell(8);
	            if (r21cell5 != null) {
	            	r21cell5.setCellValue(
	            			BRF13.getR21_1_3_months() == null ? 0 : BRF13.getR21_1_3_months().intValue());
	            }
	Cell r21cell6 = r21row.getCell(9);
	            if (r21cell6 != null) {
	            	r21cell6.setCellValue(
	            			BRF13.getR21_3_6_months() == null ? 0 : BRF13.getR21_3_6_months().intValue());
	            }
	Cell r21cell7 = r21row.getCell(10);
	            if (r21cell7 != null) {
	            	r21cell7.setCellValue(
	            			BRF13.getR21_6_12_months() == null ? 0 : BRF13.getR21_6_12_months().intValue());
	            }
	Cell r21cell8 = r21row.getCell(11);
	            if (r21cell8 != null) {
	            	r21cell8.setCellValue(
	            			BRF13.getR21_1_3_years() == null ? 0 : BRF13.getR21_1_3_years().intValue());
	            }
	Cell r21cell9 = r21row.getCell(12);
	            if (r21cell9 != null) {
	            	r21cell9.setCellValue(
	            			BRF13.getR21_3_years() == null ? 0 : BRF13.getR21_3_years().intValue());
	            }

	          ///Row22
	            Row r22row = sheet.getRow(33);
	            Cell r22cell0 =  r22row.getCell(3);
	            if (r22cell0 != null) {
	            	r22cell0.setCellValue(
	            			BRF13.getR22_overdue() == null ? 0 : BRF13.getR22_overdue().intValue());
	            } 
	  Cell r22cell1 =  r22row.getCell(4);
	            if (r22cell1 != null) {
	            	r22cell1.setCellValue(
	            			BRF13.getR22_overdraft() == null ? 0 : BRF13.getR22_overdraft().intValue());
	            }
	Cell r22cell2 = r22row.getCell(5);
	            if (r22cell2 != null) {
	            	r22cell2.setCellValue(
	            			BRF13.getR22_0_7_days() == null ? 0 : BRF13.getR22_0_7_days().intValue());
	            }
	Cell r22cell3 = r22row.getCell(6);
	            if (r22cell3 != null) {
	            	r22cell3.setCellValue(
	            			BRF13.getR22_8_14_days() == null ? 0 : BRF13.getR22_8_14_days().intValue());
	            }
	Cell r22cell4 = r22row.getCell(7);
	            if (r22cell4 != null) {
	            	r22cell4.setCellValue(
	            			BRF13.getR22_15_days_1_month() == null ? 0 : BRF13.getR22_15_days_1_month().intValue());
	            }
	Cell r22cell5 = r22row.getCell(8);
	            if (r22cell5 != null) {
	            	r22cell5.setCellValue(
	            			BRF13.getR22_1_3_months() == null ? 0 : BRF13.getR22_1_3_months().intValue());
	            }
	Cell r22cell6 = r22row.getCell(9);
	            if (r22cell6 != null) {
	            	r22cell6.setCellValue(
	            			BRF13.getR22_3_6_months() == null ? 0 : BRF13.getR22_3_6_months().intValue());
	            }
	Cell r22cell7 = r22row.getCell(10);
	            if (r22cell7 != null) {
	            	r22cell7.setCellValue(
	            			BRF13.getR22_6_12_months() == null ? 0 : BRF13.getR22_6_12_months().intValue());
	            }
	Cell r22cell8 = r22row.getCell(11);
	            if (r22cell8 != null) {
	            	r22cell8.setCellValue(
	            			BRF13.getR22_1_3_years() == null ? 0 : BRF13.getR22_1_3_years().intValue());
	            }
	Cell r22cell9 = r22row.getCell(12);
	            if (r22cell9 != null) {
	            	r22cell9.setCellValue(
	            			BRF13.getR22_3_years() == null ? 0 : BRF13.getR22_3_years().intValue());
	            }

	          ///Row23
	            Row r23row = sheet.getRow(34);
	            Cell r23cell0 =  r23row.getCell(3);
	            if (r23cell0 != null) {
	            	r23cell0.setCellValue(
	            			BRF13.getR23_overdue() == null ? 0 : BRF13.getR23_overdue().intValue());
	            } 
	  Cell r23cell1 =  r23row.getCell(4);
	            if (r23cell1 != null) {
	            	r23cell1.setCellValue(
	            			BRF13.getR23_overdraft() == null ? 0 : BRF13.getR23_overdraft().intValue());
	            }
	Cell r23cell2 = r23row.getCell(5);
	            if (r23cell2 != null) {
	            	r23cell2.setCellValue(
	            			BRF13.getR23_0_7_days() == null ? 0 : BRF13.getR23_0_7_days().intValue());
	            }
	Cell r23cell3 = r23row.getCell(6);
	            if (r23cell3 != null) {
	            	r23cell3.setCellValue(
	            			BRF13.getR23_8_14_days() == null ? 0 : BRF13.getR23_8_14_days().intValue());
	            }
	Cell r23cell4 = r23row.getCell(7);
	            if (r23cell4 != null) {
	            	r23cell4.setCellValue(
	            			BRF13.getR23_15_days_1_month() == null ? 0 : BRF13.getR23_15_days_1_month().intValue());
	            }
	Cell r23cell5 = r23row.getCell(8);
	            if (r23cell5 != null) {
	            	r23cell5.setCellValue(
	            			BRF13.getR23_1_3_months() == null ? 0 : BRF13.getR23_1_3_months().intValue());
	            }
	Cell r23cell6 = r23row.getCell(9);
	            if (r23cell6 != null) {
	            	r23cell6.setCellValue(
	            			BRF13.getR23_3_6_months() == null ? 0 : BRF13.getR23_3_6_months().intValue());
	            }
	Cell r23cell7 = r23row.getCell(10);
	            if (r23cell7 != null) {
	            	r23cell7.setCellValue(
	            			BRF13.getR23_6_12_months() == null ? 0 : BRF13.getR23_6_12_months().intValue());
	            }
	Cell r23cell8 = r23row.getCell(11);
	            if (r23cell8 != null) {
	            	r23cell8.setCellValue(
	            			BRF13.getR23_1_3_years() == null ? 0 : BRF13.getR23_1_3_years().intValue());
	            }
	Cell r23cell9 = r23row.getCell(12);
	            if (r23cell9 != null) {
	            	r23cell9.setCellValue(
	            			BRF13.getR23_3_years() == null ? 0 : BRF13.getR23_3_years().intValue());
	            }

	          ///Row24
	            Row r24row = sheet.getRow(35);
	            Cell r24cell0 =  r24row.getCell(3);
	            if (r24cell0 != null) {
	            	r24cell0.setCellValue(
	            			BRF13.getR24_overdue() == null ? 0 : BRF13.getR24_overdue().intValue());
	            } 
	  Cell r24cell1 =  r24row.getCell(4);
	            if (r24cell1 != null) {
	            	r24cell1.setCellValue(
	            			BRF13.getR24_overdraft() == null ? 0 : BRF13.getR24_overdraft().intValue());
	            }
	Cell r24cell2 = r24row.getCell(5);
	            if (r24cell2 != null) {
	            	r24cell2.setCellValue(
	            			BRF13.getR24_0_7_days() == null ? 0 : BRF13.getR24_0_7_days().intValue());
	            }
	Cell r24cell3 = r24row.getCell(6);
	            if (r24cell3 != null) {
	            	r24cell3.setCellValue(
	            			BRF13.getR24_8_14_days() == null ? 0 : BRF13.getR24_8_14_days().intValue());
	            }
	Cell r24cell4 = r24row.getCell(7);
	            if (r24cell4 != null) {
	            	r24cell4.setCellValue(
	            			BRF13.getR24_15_days_1_month() == null ? 0 : BRF13.getR24_15_days_1_month().intValue());
	            }
	Cell r24cell5 = r24row.getCell(8);
	            if (r24cell5 != null) {
	            	r24cell5.setCellValue(
	            			BRF13.getR24_1_3_months() == null ? 0 : BRF13.getR24_1_3_months().intValue());
	            }
	Cell r24cell6 = r24row.getCell(9);
	            if (r24cell6 != null) {
	            	r24cell6.setCellValue(
	            			BRF13.getR24_3_6_months() == null ? 0 : BRF13.getR24_3_6_months().intValue());
	            }
	Cell r24cell7 = r24row.getCell(10);
	            if (r24cell7 != null) {
	            	r24cell7.setCellValue(
	            			BRF13.getR24_6_12_months() == null ? 0 : BRF13.getR24_6_12_months().intValue());
	            }
	Cell r24cell8 = r24row.getCell(11);
	            if (r24cell8 != null) {
	            	r24cell8.setCellValue(
	            			BRF13.getR24_1_3_years() == null ? 0 : BRF13.getR24_1_3_years().intValue());
	            }
	Cell r24cell9 = r24row.getCell(12);
	            if (r24cell9 != null) {
	            	r24cell9.setCellValue(
	            			BRF13.getR24_3_years() == null ? 0 : BRF13.getR24_3_years().intValue());
	            }

	          ///Row25
	            Row r25row = sheet.getRow(36);
	            Cell r25cell0 =  r25row.getCell(3);
	            if (r25cell0 != null) {
	            	r25cell0.setCellValue(
	            			BRF13.getR25_overdue() == null ? 0 : BRF13.getR25_overdue().intValue());
	            } 
	  Cell r25cell1 =  r25row.getCell(4);
	            if (r25cell1 != null) {
	            	r25cell1.setCellValue(
	            			BRF13.getR25_overdraft() == null ? 0 : BRF13.getR25_overdraft().intValue());
	            }
	Cell r25cell2 = r25row.getCell(5);
	            if (r25cell2 != null) {
	            	r25cell2.setCellValue(
	            			BRF13.getR25_0_7_days() == null ? 0 : BRF13.getR25_0_7_days().intValue());
	            }
	Cell r25cell3 = r25row.getCell(6);
	            if (r25cell3 != null) {
	            	r25cell3.setCellValue(
	            			BRF13.getR25_8_14_days() == null ? 0 : BRF13.getR25_8_14_days().intValue());
	            }
	Cell r25cell4 = r25row.getCell(7);
	            if (r25cell4 != null) {
	            	r25cell4.setCellValue(
	            			BRF13.getR25_15_days_1_month() == null ? 0 : BRF13.getR25_15_days_1_month().intValue());
	            }
	Cell r25cell5 = r25row.getCell(8);
	            if (r25cell5 != null) {
	            	r25cell5.setCellValue(
	            			BRF13.getR25_1_3_months() == null ? 0 : BRF13.getR25_1_3_months().intValue());
	            }
	Cell r25cell6 = r25row.getCell(9);
	            if (r25cell6 != null) {
	            	r25cell6.setCellValue(
	            			BRF13.getR25_3_6_months() == null ? 0 : BRF13.getR25_3_6_months().intValue());
	            }
	Cell r25cell7 = r25row.getCell(10);
	            if (r25cell7 != null) {
	            	r25cell7.setCellValue(
	            			BRF13.getR25_6_12_months() == null ? 0 : BRF13.getR25_6_12_months().intValue());
	            }
	Cell r25cell8 = r25row.getCell(11);
	            if (r25cell8 != null) {
	            	r25cell8.setCellValue(
	            			BRF13.getR25_1_3_years() == null ? 0 : BRF13.getR25_1_3_years().intValue());
	            }
	Cell r25cell9 = r25row.getCell(12);
	            if (r25cell9 != null) {
	            	r25cell9.setCellValue(
	            			BRF13.getR25_3_years() == null ? 0 : BRF13.getR25_3_years().intValue());
	            }

	          ///Row26
	            Row r26row = sheet.getRow(37);
	            Cell r26cell0 =  r26row.getCell(3);
	            if (r26cell0 != null) {
	            	r26cell0.setCellValue(
	            			BRF13.getR26_overdue() == null ? 0 : BRF13.getR26_overdue().intValue());
	            } 
	  Cell r26cell1 =  r26row.getCell(4);
	            if (r26cell1 != null) {
	            	r26cell1.setCellValue(
	            			BRF13.getR26_overdraft() == null ? 0 : BRF13.getR26_overdraft().intValue());
	            }
	Cell r26cell2 = r26row.getCell(5);
	            if (r26cell2 != null) {
	            	r26cell2.setCellValue(
	            			BRF13.getR26_0_7_days() == null ? 0 : BRF13.getR26_0_7_days().intValue());
	            }
	Cell r26cell3 = r26row.getCell(6);
	            if (r26cell3 != null) {
	            	r26cell3.setCellValue(
	            			BRF13.getR26_8_14_days() == null ? 0 : BRF13.getR26_8_14_days().intValue());
	            }
	Cell r26cell4 = r26row.getCell(7);
	            if (r26cell4 != null) {
	            	r26cell4.setCellValue(
	            			BRF13.getR26_15_days_1_month() == null ? 0 : BRF13.getR26_15_days_1_month().intValue());
	            }
	Cell r26cell5 = r26row.getCell(8);
	            if (r26cell5 != null) {
	            	r26cell5.setCellValue(
	            			BRF13.getR26_1_3_months() == null ? 0 : BRF13.getR26_1_3_months().intValue());
	            }
	Cell r26cell6 = r26row.getCell(9);
	            if (r26cell6 != null) {
	            	r26cell6.setCellValue(
	            			BRF13.getR26_3_6_months() == null ? 0 : BRF13.getR26_3_6_months().intValue());
	            }
	Cell r26cell7 = r26row.getCell(10);
	            if (r26cell7 != null) {
	            	r26cell7.setCellValue(
	            			BRF13.getR26_6_12_months() == null ? 0 : BRF13.getR26_6_12_months().intValue());
	            }
	Cell r26cell8 = r26row.getCell(11);
	            if (r26cell8 != null) {
	            	r26cell8.setCellValue(
	            			BRF13.getR26_1_3_years() == null ? 0 : BRF13.getR26_1_3_years().intValue());
	            }
	Cell r26cell9 = r26row.getCell(12);
	            if (r26cell9 != null) {
	            	r26cell9.setCellValue(
	            			BRF13.getR26_3_years() == null ? 0 : BRF13.getR26_3_years().intValue());
	            }

	          ///Row27
	            Row r27row = sheet.getRow(38);
	            Cell r27cell0 =  r27row.getCell(3);
	            if (r27cell0 != null) {
	            	r27cell0.setCellValue(
	            			BRF13.getR27_overdue() == null ? 0 : BRF13.getR27_overdue().intValue());
	            } 
	  Cell r27cell1 =  r27row.getCell(4);
	            if (r27cell1 != null) {
	            	r27cell1.setCellValue(
	            			BRF13.getR27_overdraft() == null ? 0 : BRF13.getR27_overdraft().intValue());
	            }
	Cell r27cell2 = r27row.getCell(5);
	            if (r27cell2 != null) {
	            	r27cell2.setCellValue(
	            			BRF13.getR27_0_7_days() == null ? 0 : BRF13.getR27_0_7_days().intValue());
	            }
	Cell r27cell3 = r27row.getCell(6);
	            if (r27cell3 != null) {
	            	r27cell3.setCellValue(
	            			BRF13.getR27_8_14_days() == null ? 0 : BRF13.getR27_8_14_days().intValue());
	            }
	Cell r27cell4 = r27row.getCell(7);
	            if (r27cell4 != null) {
	            	r27cell4.setCellValue(
	            			BRF13.getR27_15_days_1_month() == null ? 0 : BRF13.getR27_15_days_1_month().intValue());
	            }
	Cell r27cell5 = r27row.getCell(8);
	            if (r27cell5 != null) {
	            	r27cell5.setCellValue(
	            			BRF13.getR27_1_3_months() == null ? 0 : BRF13.getR27_1_3_months().intValue());
	            }
	Cell r27cell6 = r27row.getCell(9);
	            if (r27cell6 != null) {
	            	r27cell6.setCellValue(
	            			BRF13.getR27_3_6_months() == null ? 0 : BRF13.getR27_3_6_months().intValue());
	            }
	Cell r27cell7 = r27row.getCell(10);
	            if (r27cell7 != null) {
	            	r27cell7.setCellValue(
	            			BRF13.getR27_6_12_months() == null ? 0 : BRF13.getR27_6_12_months().intValue());
	            }
	Cell r27cell8 = r27row.getCell(11);
	            if (r27cell8 != null) {
	            	r27cell8.setCellValue(
	            			BRF13.getR27_1_3_years() == null ? 0 : BRF13.getR27_1_3_years().intValue());
	            }
	Cell r27cell9 = r27row.getCell(12);
	            if (r27cell9 != null) {
	            	r27cell9.setCellValue(
	            			BRF13.getR27_3_years() == null ? 0 : BRF13.getR27_3_years().intValue());
	            }

	          ///Row28
	            Row r28row = sheet.getRow(39);
	            Cell r28cell0 =  r28row.getCell(3);
	            if (r28cell0 != null) {
	            	r28cell0.setCellValue(
	            			BRF13.getR28_overdue() == null ? 0 : BRF13.getR28_overdue().intValue());
	            } 
	  Cell r28cell1 =  r28row.getCell(4);
	            if (r28cell1 != null) {
	            	r28cell1.setCellValue(
	            			BRF13.getR28_overdraft() == null ? 0 : BRF13.getR28_overdraft().intValue());
	            }
	Cell r28cell2 = r28row.getCell(5);
	            if (r28cell2 != null) {
	            	r28cell2.setCellValue(
	            			BRF13.getR28_0_7_days() == null ? 0 : BRF13.getR28_0_7_days().intValue());
	            }
	Cell r28cell3 = r28row.getCell(6);
	            if (r28cell3 != null) {
	            	r28cell3.setCellValue(
	            			BRF13.getR28_8_14_days() == null ? 0 : BRF13.getR28_8_14_days().intValue());
	            }
	Cell r28cell4 = r28row.getCell(7);
	            if (r28cell4 != null) {
	            	r28cell4.setCellValue(
	            			BRF13.getR28_15_days_1_month() == null ? 0 : BRF13.getR28_15_days_1_month().intValue());
	            }
	Cell r28cell5 = r28row.getCell(8);
	            if (r28cell5 != null) {
	            	r28cell5.setCellValue(
	            			BRF13.getR28_1_3_months() == null ? 0 : BRF13.getR28_1_3_months().intValue());
	            }
	Cell r28cell6 = r28row.getCell(9);
	            if (r28cell6 != null) {
	            	r28cell6.setCellValue(
	            			BRF13.getR28_3_6_months() == null ? 0 : BRF13.getR28_3_6_months().intValue());
	            }
	Cell r28cell7 = r28row.getCell(10);
	            if (r28cell7 != null) {
	            	r28cell7.setCellValue(
	            			BRF13.getR28_6_12_months() == null ? 0 : BRF13.getR28_6_12_months().intValue());
	            }
	Cell r28cell8 = r28row.getCell(11);
	            if (r28cell8 != null) {
	            	r28cell8.setCellValue(
	            			BRF13.getR28_1_3_years() == null ? 0 : BRF13.getR28_1_3_years().intValue());
	            }
	Cell r28cell9 = r28row.getCell(12);
	            if (r28cell9 != null) {
	            	r28cell9.setCellValue(
	            			BRF13.getR28_3_years() == null ? 0 : BRF13.getR28_3_years().intValue());
	            }

	          ///Row29
	            Row r29row = sheet.getRow(40);
	            Cell r29cell0 =  r29row.getCell(3);
	            if (r29cell0 != null) {
	            	r29cell0.setCellValue(
	            			BRF13.getR29_overdue() == null ? 0 : BRF13.getR29_overdue().intValue());
	            } 
	  Cell r29cell1 =  r29row.getCell(4);
	            if (r29cell1 != null) {
	            	r29cell1.setCellValue(
	            			BRF13.getR29_overdraft() == null ? 0 : BRF13.getR29_overdraft().intValue());
	            }
	Cell r29cell2 = r29row.getCell(5);
	            if (r29cell2 != null) {
	            	r29cell2.setCellValue(
	            			BRF13.getR29_0_7_days() == null ? 0 : BRF13.getR29_0_7_days().intValue());
	            }
	Cell r29cell3 = r29row.getCell(6);
	            if (r29cell3 != null) {
	            	r29cell3.setCellValue(
	            			BRF13.getR29_8_14_days() == null ? 0 : BRF13.getR29_8_14_days().intValue());
	            }
	Cell r29cell4 = r29row.getCell(7);
	            if (r29cell4 != null) {
	            	r29cell4.setCellValue(
	            			BRF13.getR29_15_days_1_month() == null ? 0 : BRF13.getR29_15_days_1_month().intValue());
	            }
	Cell r29cell5 = r29row.getCell(8);
	            if (r29cell5 != null) {
	            	r29cell5.setCellValue(
	            			BRF13.getR29_1_3_months() == null ? 0 : BRF13.getR29_1_3_months().intValue());
	            }
	Cell r29cell6 = r29row.getCell(9);
	            if (r29cell6 != null) {
	            	r29cell6.setCellValue(
	            			BRF13.getR29_3_6_months() == null ? 0 : BRF13.getR29_3_6_months().intValue());
	            }
	Cell r29cell7 = r29row.getCell(10);
	            if (r29cell7 != null) {
	            	r29cell7.setCellValue(
	            			BRF13.getR29_6_12_months() == null ? 0 : BRF13.getR29_6_12_months().intValue());
	            }
	Cell r29cell8 = r29row.getCell(11);
	            if (r29cell8 != null) {
	            	r29cell8.setCellValue(
	            			BRF13.getR29_1_3_years() == null ? 0 : BRF13.getR29_1_3_years().intValue());
	            }
	Cell r29cell9 = r29row.getCell(12);
	            if (r29cell9 != null) {
	            	r29cell9.setCellValue(
	            			BRF13.getR29_3_years() == null ? 0 : BRF13.getR29_3_years().intValue());
	            }

	          ///Row30
	            Row r30row = sheet.getRow(41);
	            Cell r30cell0 =  r30row.getCell(3);
	            if (r30cell0 != null) {
	            	r30cell0.setCellValue(
	            			BRF13.getR30_overdue() == null ? 0 : BRF13.getR30_overdue().intValue());
	            } 
	  Cell r30cell1 =  r30row.getCell(4);
	            if (r30cell1 != null) {
	            	r30cell1.setCellValue(
	            			BRF13.getR30_overdraft() == null ? 0 : BRF13.getR30_overdraft().intValue());
	            }
	Cell r30cell2 = r30row.getCell(5);
	            if (r30cell2 != null) {
	            	r30cell2.setCellValue(
	            			BRF13.getR30_0_7_days() == null ? 0 : BRF13.getR30_0_7_days().intValue());
	            }
	Cell r30cell3 = r30row.getCell(6);
	            if (r30cell3 != null) {
	            	r30cell3.setCellValue(
	            			BRF13.getR30_8_14_days() == null ? 0 : BRF13.getR30_8_14_days().intValue());
	            }
	Cell r30cell4 = r30row.getCell(7);
	            if (r30cell4 != null) {
	            	r30cell4.setCellValue(
	            			BRF13.getR30_15_days_1_month() == null ? 0 : BRF13.getR30_15_days_1_month().intValue());
	            }
	Cell r30cell5 = r30row.getCell(8);
	            if (r30cell5 != null) {
	            	r30cell5.setCellValue(
	            			BRF13.getR30_1_3_months() == null ? 0 : BRF13.getR30_1_3_months().intValue());
	            }
	Cell r30cell6 = r30row.getCell(9);
	            if (r30cell6 != null) {
	            	r30cell6.setCellValue(
	            			BRF13.getR30_3_6_months() == null ? 0 : BRF13.getR30_3_6_months().intValue());
	            }
	Cell r30cell7 = r30row.getCell(10);
	            if (r30cell7 != null) {
	            	r30cell7.setCellValue(
	            			BRF13.getR30_6_12_months() == null ? 0 : BRF13.getR30_6_12_months().intValue());
	            }
	Cell r30cell8 = r30row.getCell(11);
	            if (r30cell8 != null) {
	            	r30cell8.setCellValue(
	            			BRF13.getR30_1_3_years() == null ? 0 : BRF13.getR30_1_3_years().intValue());
	            }
	Cell r30cell9 = r30row.getCell(12);
	            if (r30cell9 != null) {
	            	r30cell9.setCellValue(
	            			BRF13.getR30_3_years() == null ? 0 : BRF13.getR30_3_years().intValue());
	            }

	          ///Row31
	            Row r31row = sheet.getRow(45);
	            Cell r31cell0 =  r31row.getCell(3);
	            if (r31cell0 != null) {
	            	r31cell0.setCellValue(
	            			BRF13.getR31_overdue() == null ? 0 : BRF13.getR31_overdue().intValue());
	            } 
	  Cell r31cell1 =  r31row.getCell(4);
	            if (r31cell1 != null) {
	            	r31cell1.setCellValue(
	            			BRF13.getR31_overdraft() == null ? 0 : BRF13.getR31_overdraft().intValue());
	            }
	Cell r31cell2 = r31row.getCell(5);
	            if (r31cell2 != null) {
	            	r31cell2.setCellValue(
	            			BRF13.getR31_0_7_days() == null ? 0 : BRF13.getR31_0_7_days().intValue());
	            }
	Cell r31cell3 = r31row.getCell(6);
	            if (r31cell3 != null) {
	            	r31cell3.setCellValue(
	            			BRF13.getR31_8_14_days() == null ? 0 : BRF13.getR31_8_14_days().intValue());
	            }
	Cell r31cell4 = r31row.getCell(7);
	            if (r31cell4 != null) {
	            	r31cell4.setCellValue(
	            			BRF13.getR31_15_days_1_month() == null ? 0 : BRF13.getR31_15_days_1_month().intValue());
	            }
	Cell r31cell5 = r31row.getCell(8);
	            if (r31cell5 != null) {
	            	r31cell5.setCellValue(
	            			BRF13.getR31_1_3_months() == null ? 0 : BRF13.getR31_1_3_months().intValue());
	            }
	Cell r31cell6 = r31row.getCell(9);
	            if (r31cell6 != null) {
	            	r31cell6.setCellValue(
	            			BRF13.getR31_3_6_months() == null ? 0 : BRF13.getR31_3_6_months().intValue());
	            }
	Cell r31cell7 = r31row.getCell(10);
	            if (r31cell7 != null) {
	            	r31cell7.setCellValue(
	            			BRF13.getR31_6_12_months() == null ? 0 : BRF13.getR31_6_12_months().intValue());
	            }
	Cell r31cell8 = r31row.getCell(11);
	            if (r31cell8 != null) {
	            	r31cell8.setCellValue(
	            			BRF13.getR31_1_3_years() == null ? 0 : BRF13.getR31_1_3_years().intValue());
	            }
	Cell r31cell9 = r31row.getCell(12);
	            if (r31cell9 != null) {
	            	r31cell9.setCellValue(
	            			BRF13.getR31_3_years() == null ? 0 : BRF13.getR31_3_years().intValue());
	            }

	          ///Row32
	            Row r32row = sheet.getRow(46);
	            Cell r32cell0 =  r32row.getCell(3);
	            if (r32cell0 != null) {
	            	r32cell0.setCellValue(
	            			BRF13.getR32_overdue() == null ? 0 : BRF13.getR32_overdue().intValue());
	            } 
	  Cell r32cell1 =  r32row.getCell(4);
	            if (r32cell1 != null) {
	            	r32cell1.setCellValue(
	            			BRF13.getR32_overdraft() == null ? 0 : BRF13.getR32_overdraft().intValue());
	            }
	Cell r32cell2 = r32row.getCell(5);
	            if (r32cell2 != null) {
	            	r32cell2.setCellValue(
	            			BRF13.getR32_0_7_days() == null ? 0 : BRF13.getR32_0_7_days().intValue());
	            }
	Cell r32cell3 = r32row.getCell(6);
	            if (r32cell3 != null) {
	            	r32cell3.setCellValue(
	            			BRF13.getR32_8_14_days() == null ? 0 : BRF13.getR32_8_14_days().intValue());
	            }
	Cell r32cell4 = r32row.getCell(7);
	            if (r32cell4 != null) {
	            	r32cell4.setCellValue(
	            			BRF13.getR32_15_days_1_month() == null ? 0 : BRF13.getR32_15_days_1_month().intValue());
	            }
	Cell r32cell5 = r32row.getCell(8);
	            if (r32cell5 != null) {
	            	r32cell5.setCellValue(
	            			BRF13.getR32_1_3_months() == null ? 0 : BRF13.getR32_1_3_months().intValue());
	            }
	Cell r32cell6 = r32row.getCell(9);
	            if (r32cell6 != null) {
	            	r32cell6.setCellValue(
	            			BRF13.getR32_3_6_months() == null ? 0 : BRF13.getR32_3_6_months().intValue());
	            }
	Cell r32cell7 = r32row.getCell(10);
	            if (r32cell7 != null) {
	            	r32cell7.setCellValue(
	            			BRF13.getR32_6_12_months() == null ? 0 : BRF13.getR32_6_12_months().intValue());
	            }
	Cell r32cell8 = r32row.getCell(11);
	            if (r32cell8 != null) {
	            	r32cell8.setCellValue(
	            			BRF13.getR32_1_3_years() == null ? 0 : BRF13.getR32_1_3_years().intValue());
	            }
	Cell r32cell9 = r32row.getCell(12);
	            if (r32cell9 != null) {
	            	r32cell9.setCellValue(
	            			BRF13.getR32_3_years() == null ? 0 : BRF13.getR32_3_years().intValue());
	            }

	          ///Row33
	            Row r33row = sheet.getRow(47);
	            Cell r33cell0 =  r33row.getCell(3);
	            if (r33cell0 != null) {
	            	r33cell0.setCellValue(
	            			BRF13.getR33_overdue() == null ? 0 : BRF13.getR33_overdue().intValue());
	            } 
	  Cell r33cell1 =  r33row.getCell(4);
	            if (r33cell1 != null) {
	            	r33cell1.setCellValue(
	            			BRF13.getR33_overdraft() == null ? 0 : BRF13.getR33_overdraft().intValue());
	            }
	Cell r33cell2 = r33row.getCell(5);
	            if (r33cell2 != null) {
	            	r33cell2.setCellValue(
	            			BRF13.getR33_0_7_days() == null ? 0 : BRF13.getR33_0_7_days().intValue());
	            }
	Cell r33cell3 = r33row.getCell(6);
	            if (r33cell3 != null) {
	            	r33cell3.setCellValue(
	            			BRF13.getR33_8_14_days() == null ? 0 : BRF13.getR33_8_14_days().intValue());
	            }
	Cell r33cell4 = r33row.getCell(7);
	            if (r33cell4 != null) {
	            	r33cell4.setCellValue(
	            			BRF13.getR33_15_days_1_month() == null ? 0 : BRF13.getR33_15_days_1_month().intValue());
	            }
	Cell r33cell5 = r33row.getCell(8);
	            if (r33cell5 != null) {
	            	r33cell5.setCellValue(
	            			BRF13.getR33_1_3_months() == null ? 0 : BRF13.getR33_1_3_months().intValue());
	            }
	Cell r33cell6 = r33row.getCell(9);
	            if (r33cell6 != null) {
	            	r33cell6.setCellValue(
	            			BRF13.getR33_3_6_months() == null ? 0 : BRF13.getR33_3_6_months().intValue());
	            }
	Cell r33cell7 = r33row.getCell(10);
	            if (r33cell7 != null) {
	            	r33cell7.setCellValue(
	            			BRF13.getR33_6_12_months() == null ? 0 : BRF13.getR33_6_12_months().intValue());
	            }
	Cell r33cell8 = r33row.getCell(11);
	            if (r33cell8 != null) {
	            	r33cell8.setCellValue(
	            			BRF13.getR33_1_3_years() == null ? 0 : BRF13.getR33_1_3_years().intValue());
	            }
	Cell r33cell9 = r33row.getCell(12);
	            if (r33cell9 != null) {
	            	r33cell9.setCellValue(
	            			BRF13.getR33_3_years() == null ? 0 : BRF13.getR33_3_years().intValue());
	            }

	          ///Row34
	            Row r34row = sheet.getRow(48);
	            Cell r34cell0 =  r34row.getCell(3);
	            if (r34cell0 != null) {
	            	r34cell0.setCellValue(
	            			BRF13.getR34_overdue() == null ? 0 : BRF13.getR34_overdue().intValue());
	            } 
	  Cell r34cell1 =  r34row.getCell(4);
	            if (r34cell1 != null) {
	            	r34cell1.setCellValue(
	            			BRF13.getR34_overdraft() == null ? 0 : BRF13.getR34_overdraft().intValue());
	            }
	Cell r34cell2 = r34row.getCell(5);
	            if (r34cell2 != null) {
	            	r34cell2.setCellValue(
	            			BRF13.getR34_0_7_days() == null ? 0 : BRF13.getR34_0_7_days().intValue());
	            }
	Cell r34cell3 = r34row.getCell(6);
	            if (r34cell3 != null) {
	            	r34cell3.setCellValue(
	            			BRF13.getR34_8_14_days() == null ? 0 : BRF13.getR34_8_14_days().intValue());
	            }
	Cell r34cell4 = r34row.getCell(7);
	            if (r34cell4 != null) {
	            	r34cell4.setCellValue(
	            			BRF13.getR34_15_days_1_month() == null ? 0 : BRF13.getR34_15_days_1_month().intValue());
	            }
	Cell r34cell5 = r34row.getCell(8);
	            if (r34cell5 != null) {
	            	r34cell5.setCellValue(
	            			BRF13.getR34_1_3_months() == null ? 0 : BRF13.getR34_1_3_months().intValue());
	            }
	Cell r34cell6 = r34row.getCell(9);
	            if (r34cell6 != null) {
	            	r34cell6.setCellValue(
	            			BRF13.getR34_3_6_months() == null ? 0 : BRF13.getR34_3_6_months().intValue());
	            }
	Cell r34cell7 = r34row.getCell(10);
	            if (r34cell7 != null) {
	            	r34cell7.setCellValue(
	            			BRF13.getR34_6_12_months() == null ? 0 : BRF13.getR34_6_12_months().intValue());
	            }
	Cell r34cell8 = r34row.getCell(11);
	            if (r34cell8 != null) {
	            	r34cell8.setCellValue(
	            			BRF13.getR34_1_3_years() == null ? 0 : BRF13.getR34_1_3_years().intValue());
	            }
	Cell r34cell9 = r34row.getCell(12);
	            if (r34cell9 != null) {
	            	r34cell9.setCellValue(
	            			BRF13.getR34_3_years() == null ? 0 : BRF13.getR34_3_years().intValue());
	            }

	          ///Row35
	            Row r35row = sheet.getRow(50);
	            Cell r35cell0 =  r35row.getCell(3);
	            if (r35cell0 != null) {
	            	r35cell0.setCellValue(
	            			BRF13.getR35_overdue() == null ? 0 : BRF13.getR35_overdue().intValue());
	            } 
	  Cell r35cell1 =  r35row.getCell(4);
	            if (r35cell1 != null) {
	            	r35cell1.setCellValue(
	            			BRF13.getR35_overdraft() == null ? 0 : BRF13.getR35_overdraft().intValue());
	            }
	Cell r35cell2 = r35row.getCell(5);
	            if (r35cell2 != null) {
	            	r35cell2.setCellValue(
	            			BRF13.getR35_0_7_days() == null ? 0 : BRF13.getR35_0_7_days().intValue());
	            }
	Cell r35cell3 = r35row.getCell(6);
	            if (r35cell3 != null) {
	            	r35cell3.setCellValue(
	            			BRF13.getR35_8_14_days() == null ? 0 : BRF13.getR35_8_14_days().intValue());
	            }
	Cell r35cell4 = r35row.getCell(7);
	            if (r35cell4 != null) {
	            	r35cell4.setCellValue(
	            			BRF13.getR35_15_days_1_month() == null ? 0 : BRF13.getR35_15_days_1_month().intValue());
	            }
	Cell r35cell5 = r35row.getCell(8);
	            if (r35cell5 != null) {
	            	r35cell5.setCellValue(
	            			BRF13.getR35_1_3_months() == null ? 0 : BRF13.getR35_1_3_months().intValue());
	            }
	Cell r35cell6 = r35row.getCell(9);
	            if (r35cell6 != null) {
	            	r35cell6.setCellValue(
	            			BRF13.getR35_3_6_months() == null ? 0 : BRF13.getR35_3_6_months().intValue());
	            }
	Cell r35cell7 = r35row.getCell(10);
	            if (r35cell7 != null) {
	            	r35cell7.setCellValue(
	            			BRF13.getR35_6_12_months() == null ? 0 : BRF13.getR35_6_12_months().intValue());
	            }
	Cell r35cell8 = r35row.getCell(11);
	            if (r35cell8 != null) {
	            	r35cell8.setCellValue(
	            			BRF13.getR35_1_3_years() == null ? 0 : BRF13.getR35_1_3_years().intValue());
	            }
	Cell r35cell9 = r35row.getCell(12);
	            if (r35cell9 != null) {
	            	r35cell9.setCellValue(
	            			BRF13.getR35_3_years() == null ? 0 : BRF13.getR35_3_years().intValue());
	            }

	          ///Row36
	            Row r36row = sheet.getRow(51);
	            Cell r36cell0 =  r36row.getCell(3);
	            if (r36cell0 != null) {
	            	r36cell0.setCellValue(
	            			BRF13.getR36_overdue() == null ? 0 : BRF13.getR36_overdue().intValue());
	            } 
	  Cell r36cell1 =  r36row.getCell(4);
	            if (r36cell1 != null) {
	            	r36cell1.setCellValue(
	            			BRF13.getR36_overdraft() == null ? 0 : BRF13.getR36_overdraft().intValue());
	            }
	Cell r36cell2 = r36row.getCell(5);
	            if (r36cell2 != null) {
	            	r36cell2.setCellValue(
	            			BRF13.getR36_0_7_days() == null ? 0 : BRF13.getR36_0_7_days().intValue());
	            }
	Cell r36cell3 = r36row.getCell(6);
	            if (r36cell3 != null) {
	            	r36cell3.setCellValue(
	            			BRF13.getR36_8_14_days() == null ? 0 : BRF13.getR36_8_14_days().intValue());
	            }
	Cell r36cell4 = r36row.getCell(7);
	            if (r36cell4 != null) {
	            	r36cell4.setCellValue(
	            			BRF13.getR36_15_days_1_month() == null ? 0 : BRF13.getR36_15_days_1_month().intValue());
	            }
	Cell r36cell5 = r36row.getCell(8);
	            if (r36cell5 != null) {
	            	r36cell5.setCellValue(
	            			BRF13.getR36_1_3_months() == null ? 0 : BRF13.getR36_1_3_months().intValue());
	            }
	Cell r36cell6 = r36row.getCell(9);
	            if (r36cell6 != null) {
	            	r36cell6.setCellValue(
	            			BRF13.getR36_3_6_months() == null ? 0 : BRF13.getR36_3_6_months().intValue());
	            }
	Cell r36cell7 = r36row.getCell(10);
	            if (r36cell7 != null) {
	            	r36cell7.setCellValue(
	            			BRF13.getR36_6_12_months() == null ? 0 : BRF13.getR36_6_12_months().intValue());
	            }
	Cell r36cell8 = r36row.getCell(11);
	            if (r36cell8 != null) {
	            	r36cell8.setCellValue(
	            			BRF13.getR36_1_3_years() == null ? 0 : BRF13.getR36_1_3_years().intValue());
	            }
	Cell r36cell9 = r36row.getCell(12);
	            if (r36cell9 != null) {
	            	r36cell9.setCellValue(
	            			BRF13.getR36_3_years() == null ? 0 : BRF13.getR36_3_years().intValue());
	            }

	          ///Row37
	            Row r37row = sheet.getRow(52);
	            Cell r37cell0 =  r37row.getCell(3);
	            if (r37cell0 != null) {
	            	r37cell0.setCellValue(
	            			BRF13.getR37_overdue() == null ? 0 : BRF13.getR37_overdue().intValue());
	            } 
	  Cell r37cell1 =  r37row.getCell(4);
	            if (r37cell1 != null) {
	            	r37cell1.setCellValue(
	            			BRF13.getR37_overdraft() == null ? 0 : BRF13.getR37_overdraft().intValue());
	            }
	Cell r37cell2 = r37row.getCell(5);
	            if (r37cell2 != null) {
	            	r37cell2.setCellValue(
	            			BRF13.getR37_0_7_days() == null ? 0 : BRF13.getR37_0_7_days().intValue());
	            }
	Cell r37cell3 = r37row.getCell(6);
	            if (r37cell3 != null) {
	            	r37cell3.setCellValue(
	            			BRF13.getR37_8_14_days() == null ? 0 : BRF13.getR37_8_14_days().intValue());
	            }
	Cell r37cell4 = r37row.getCell(7);
	            if (r37cell4 != null) {
	            	r37cell4.setCellValue(
	            			BRF13.getR37_15_days_1_month() == null ? 0 : BRF13.getR37_15_days_1_month().intValue());
	            }
	Cell r37cell5 = r37row.getCell(8);
	            if (r37cell5 != null) {
	            	r37cell5.setCellValue(
	            			BRF13.getR37_1_3_months() == null ? 0 : BRF13.getR37_1_3_months().intValue());
	            }
	Cell r37cell6 = r37row.getCell(9);
	            if (r37cell6 != null) {
	            	r37cell6.setCellValue(
	            			BRF13.getR37_3_6_months() == null ? 0 : BRF13.getR37_3_6_months().intValue());
	            }
	Cell r37cell7 = r37row.getCell(10);
	            if (r37cell7 != null) {
	            	r37cell7.setCellValue(
	            			BRF13.getR37_6_12_months() == null ? 0 : BRF13.getR37_6_12_months().intValue());
	            }
	Cell r37cell8 = r37row.getCell(11);
	            if (r37cell8 != null) {
	            	r37cell8.setCellValue(
	            			BRF13.getR37_1_3_years() == null ? 0 : BRF13.getR37_1_3_years().intValue());
	            }
	Cell r37cell9 = r37row.getCell(12);
	            if (r37cell9 != null) {
	            	r37cell9.setCellValue(
	            			BRF13.getR37_3_years() == null ? 0 : BRF13.getR37_3_years().intValue());
	            }

	          ///Row38
	            Row r38row = sheet.getRow(53);
	            Cell r38cell0 =  r38row.getCell(3);
	            if (r38cell0 != null) {
	            	r38cell0.setCellValue(
	            			BRF13.getR38_overdue() == null ? 0 : BRF13.getR38_overdue().intValue());
	            } 
	  Cell r38cell1 =  r38row.getCell(4);
	            if (r38cell1 != null) {
	            	r38cell1.setCellValue(
	            			BRF13.getR38_overdraft() == null ? 0 : BRF13.getR38_overdraft().intValue());
	            }
	Cell r38cell2 = r38row.getCell(5);
	            if (r38cell2 != null) {
	            	r38cell2.setCellValue(
	            			BRF13.getR38_0_7_days() == null ? 0 : BRF13.getR38_0_7_days().intValue());
	            }
	Cell r38cell3 = r38row.getCell(6);
	            if (r38cell3 != null) {
	            	r38cell3.setCellValue(
	            			BRF13.getR38_8_14_days() == null ? 0 : BRF13.getR38_8_14_days().intValue());
	            }
	Cell r38cell4 = r38row.getCell(7);
	            if (r38cell4 != null) {
	            	r38cell4.setCellValue(
	            			BRF13.getR38_15_days_1_month() == null ? 0 : BRF13.getR38_15_days_1_month().intValue());
	            }
	Cell r38cell5 = r38row.getCell(8);
	            if (r38cell5 != null) {
	            	r38cell5.setCellValue(
	            			BRF13.getR38_1_3_months() == null ? 0 : BRF13.getR38_1_3_months().intValue());
	            }
	Cell r38cell6 = r38row.getCell(9);
	            if (r38cell6 != null) {
	            	r38cell6.setCellValue(
	            			BRF13.getR38_3_6_months() == null ? 0 : BRF13.getR38_3_6_months().intValue());
	            }
	Cell r38cell7 = r38row.getCell(10);
	            if (r38cell7 != null) {
	            	r38cell7.setCellValue(
	            			BRF13.getR38_6_12_months() == null ? 0 : BRF13.getR38_6_12_months().intValue());
	            }
	Cell r38cell8 = r38row.getCell(11);
	            if (r38cell8 != null) {
	            	r38cell8.setCellValue(
	            			BRF13.getR38_1_3_years() == null ? 0 : BRF13.getR38_1_3_years().intValue());
	            }
	Cell r38cell9 = r38row.getCell(12);
	            if (r38cell9 != null) {
	            	r38cell9.setCellValue(
	            			BRF13.getR38_3_years() == null ? 0 : BRF13.getR38_3_years().intValue());
	            }

	          ///Row39
	            Row r39row = sheet.getRow(54);
	            Cell r39cell0 =  r39row.getCell(3);
	            if (r39cell0 != null) {
	            	r39cell0.setCellValue(
	            			BRF13.getR39_overdue() == null ? 0 : BRF13.getR39_overdue().intValue());
	            } 
	  Cell r39cell1 =  r39row.getCell(4);
	            if (r39cell1 != null) {
	            	r39cell1.setCellValue(
	            			BRF13.getR39_overdraft() == null ? 0 : BRF13.getR39_overdraft().intValue());
	            }
	Cell r39cell2 = r39row.getCell(5);
	            if (r39cell2 != null) {
	            	r39cell2.setCellValue(
	            			BRF13.getR39_0_7_days() == null ? 0 : BRF13.getR39_0_7_days().intValue());
	            }
	Cell r39cell3 = r39row.getCell(6);
	            if (r39cell3 != null) {
	            	r39cell3.setCellValue(
	            			BRF13.getR39_8_14_days() == null ? 0 : BRF13.getR39_8_14_days().intValue());
	            }
	Cell r39cell4 = r39row.getCell(7);
	            if (r39cell4 != null) {
	            	r39cell4.setCellValue(
	            			BRF13.getR39_15_days_1_month() == null ? 0 : BRF13.getR39_15_days_1_month().intValue());
	            }
	Cell r39cell5 = r39row.getCell(8);
	            if (r39cell5 != null) {
	            	r39cell5.setCellValue(
	            			BRF13.getR39_1_3_months() == null ? 0 : BRF13.getR39_1_3_months().intValue());
	            }
	Cell r39cell6 = r39row.getCell(9);
	            if (r39cell6 != null) {
	            	r39cell6.setCellValue(
	            			BRF13.getR39_3_6_months() == null ? 0 : BRF13.getR39_3_6_months().intValue());
	            }
	Cell r39cell7 = r39row.getCell(10);
	            if (r39cell7 != null) {
	            	r39cell7.setCellValue(
	            			BRF13.getR39_6_12_months() == null ? 0 : BRF13.getR39_6_12_months().intValue());
	            }
	Cell r39cell8 = r39row.getCell(11);
	            if (r39cell8 != null) {
	            	r39cell8.setCellValue(
	            			BRF13.getR39_1_3_years() == null ? 0 : BRF13.getR39_1_3_years().intValue());
	            }
	Cell r39cell9 = r39row.getCell(12);
	            if (r39cell9 != null) {
	            	r39cell9.setCellValue(
	            			BRF13.getR39_3_years() == null ? 0 : BRF13.getR39_3_years().intValue());
	            }

	          ///Row40
	            Row r40row = sheet.getRow(55);
	            Cell r40cell0 =  r40row.getCell(3);
	            if (r40cell0 != null) {
	            	r40cell0.setCellValue(
	            			BRF13.getR40_overdue() == null ? 0 : BRF13.getR40_overdue().intValue());
	            } 
	  Cell r40cell1 =  r40row.getCell(4);
	            if (r40cell1 != null) {
	            	r40cell1.setCellValue(
	            			BRF13.getR40_overdraft() == null ? 0 : BRF13.getR40_overdraft().intValue());
	            }
	Cell r40cell2 = r40row.getCell(5);
	            if (r40cell2 != null) {
	            	r40cell2.setCellValue(
	            			BRF13.getR40_0_7_days() == null ? 0 : BRF13.getR40_0_7_days().intValue());
	            }
	Cell r40cell3 = r40row.getCell(6);
	            if (r40cell3 != null) {
	            	r40cell3.setCellValue(
	            			BRF13.getR40_8_14_days() == null ? 0 : BRF13.getR40_8_14_days().intValue());
	            }
	Cell r40cell4 = r40row.getCell(7);
	            if (r40cell4 != null) {
	            	r40cell4.setCellValue(
	            			BRF13.getR40_15_days_1_month() == null ? 0 : BRF13.getR40_15_days_1_month().intValue());
	            }
	Cell r40cell5 = r40row.getCell(8);
	            if (r40cell5 != null) {
	            	r40cell5.setCellValue(
	            			BRF13.getR40_1_3_months() == null ? 0 : BRF13.getR40_1_3_months().intValue());
	            }
	Cell r40cell6 = r40row.getCell(9);
	            if (r40cell6 != null) {
	            	r40cell6.setCellValue(
	            			BRF13.getR40_3_6_months() == null ? 0 : BRF13.getR40_3_6_months().intValue());
	            }
	Cell r40cell7 = r40row.getCell(10);
	            if (r40cell7 != null) {
	            	r40cell7.setCellValue(
	            			BRF13.getR40_6_12_months() == null ? 0 : BRF13.getR40_6_12_months().intValue());
	            }
	Cell r40cell8 = r40row.getCell(11);
	            if (r40cell8 != null) {
	            	r40cell8.setCellValue(
	            			BRF13.getR40_1_3_years() == null ? 0 : BRF13.getR40_1_3_years().intValue());
	            }
	Cell r40cell9 = r40row.getCell(12);
	            if (r40cell9 != null) {
	            	r40cell9.setCellValue(
	            			BRF13.getR40_3_years() == null ? 0 : BRF13.getR40_3_years().intValue());
	            }

	          ///Row41
	            Row r41row = sheet.getRow(57);
	            Cell r41cell0 =  r41row.getCell(3);
	            if (r41cell0 != null) {
	            	r41cell0.setCellValue(
	            			BRF13.getR41_overdue() == null ? 0 : BRF13.getR41_overdue().intValue());
	            } 
	  Cell r41cell1 =  r41row.getCell(4);
	            if (r41cell1 != null) {
	            	r41cell1.setCellValue(
	            			BRF13.getR41_overdraft() == null ? 0 : BRF13.getR41_overdraft().intValue());
	            }
	Cell r41cell2 = r41row.getCell(5);
	            if (r41cell2 != null) {
	            	r41cell2.setCellValue(
	            			BRF13.getR41_0_7_days() == null ? 0 : BRF13.getR41_0_7_days().intValue());
	            }
	Cell r41cell3 = r41row.getCell(6);
	            if (r41cell3 != null) {
	            	r41cell3.setCellValue(
	            			BRF13.getR41_8_14_days() == null ? 0 : BRF13.getR41_8_14_days().intValue());
	            }
	Cell r41cell4 = r41row.getCell(7);
	            if (r41cell4 != null) {
	            	r41cell4.setCellValue(
	            			BRF13.getR41_15_days_1_month() == null ? 0 : BRF13.getR41_15_days_1_month().intValue());
	            }
	Cell r41cell5 = r41row.getCell(8);
	            if (r41cell5 != null) {
	            	r41cell5.setCellValue(
	            			BRF13.getR41_1_3_months() == null ? 0 : BRF13.getR41_1_3_months().intValue());
	            }
	Cell r41cell6 = r41row.getCell(9);
	            if (r41cell6 != null) {
	            	r41cell6.setCellValue(
	            			BRF13.getR41_3_6_months() == null ? 0 : BRF13.getR41_3_6_months().intValue());
	            }
	Cell r41cell7 = r41row.getCell(10);
	            if (r41cell7 != null) {
	            	r41cell7.setCellValue(
	            			BRF13.getR41_6_12_months() == null ? 0 : BRF13.getR41_6_12_months().intValue());
	            }
	Cell r41cell8 = r41row.getCell(11);
	            if (r41cell8 != null) {
	            	r41cell8.setCellValue(
	            			BRF13.getR41_1_3_years() == null ? 0 : BRF13.getR41_1_3_years().intValue());
	            }
	Cell r41cell9 = r41row.getCell(12);
	            if (r41cell9 != null) {
	            	r41cell9.setCellValue(
	            			BRF13.getR41_3_years() == null ? 0 : BRF13.getR41_3_years().intValue());
	            }

	          ///Row42
	            Row r42row = sheet.getRow(58);
	            Cell r42cell0 =  r42row.getCell(3);
	            if (r42cell0 != null) {
	            	r42cell0.setCellValue(
	            			BRF13.getR42_overdue() == null ? 0 : BRF13.getR42_overdue().intValue());
	            } 
	  Cell r42cell1 =  r42row.getCell(4);
	            if (r42cell1 != null) {
	            	r42cell1.setCellValue(
	            			BRF13.getR42_overdraft() == null ? 0 : BRF13.getR42_overdraft().intValue());
	            }
	Cell r42cell2 = r42row.getCell(5);
	            if (r42cell2 != null) {
	            	r42cell2.setCellValue(
	            			BRF13.getR42_0_7_days() == null ? 0 : BRF13.getR42_0_7_days().intValue());
	            }
	Cell r42cell3 = r42row.getCell(6);
	            if (r42cell3 != null) {
	            	r42cell3.setCellValue(
	            			BRF13.getR42_8_14_days() == null ? 0 : BRF13.getR42_8_14_days().intValue());
	            }
	Cell r42cell4 = r42row.getCell(7);
	            if (r42cell4 != null) {
	            	r42cell4.setCellValue(
	            			BRF13.getR42_15_days_1_month() == null ? 0 : BRF13.getR42_15_days_1_month().intValue());
	            }
	Cell r42cell5 = r42row.getCell(8);
	            if (r42cell5 != null) {
	            	r42cell5.setCellValue(
	            			BRF13.getR42_1_3_months() == null ? 0 : BRF13.getR42_1_3_months().intValue());
	            }
	Cell r42cell6 = r42row.getCell(9);
	            if (r42cell6 != null) {
	            	r42cell6.setCellValue(
	            			BRF13.getR42_3_6_months() == null ? 0 : BRF13.getR42_3_6_months().intValue());
	            }
	Cell r42cell7 = r42row.getCell(10);
	            if (r42cell7 != null) {
	            	r42cell7.setCellValue(
	            			BRF13.getR42_6_12_months() == null ? 0 : BRF13.getR42_6_12_months().intValue());
	            }
	Cell r42cell8 = r42row.getCell(11);
	            if (r42cell8 != null) {
	            	r42cell8.setCellValue(
	            			BRF13.getR42_1_3_years() == null ? 0 : BRF13.getR42_1_3_years().intValue());
	            }
	Cell r42cell9 = r42row.getCell(12);
	            if (r42cell9 != null) {
	            	r42cell9.setCellValue(
	            			BRF13.getR42_3_years() == null ? 0 : BRF13.getR42_3_years().intValue());
	            }

	          ///Row43
	            Row r43row = sheet.getRow(59);
	            Cell r43cell0 =  r43row.getCell(3);
	            if (r43cell0 != null) {
	            	r43cell0.setCellValue(
	            			BRF13.getR43_overdue() == null ? 0 : BRF13.getR43_overdue().intValue());
	            } 
	  Cell r43cell1 =  r43row.getCell(4);
	            if (r43cell1 != null) {
	            	r43cell1.setCellValue(
	            			BRF13.getR43_overdraft() == null ? 0 : BRF13.getR43_overdraft().intValue());
	            }
	Cell r43cell2 = r43row.getCell(5);
	            if (r43cell2 != null) {
	            	r43cell2.setCellValue(
	            			BRF13.getR43_0_7_days() == null ? 0 : BRF13.getR43_0_7_days().intValue());
	            }
	Cell r43cell3 = r43row.getCell(6);
	            if (r43cell3 != null) {
	            	r43cell3.setCellValue(
	            			BRF13.getR43_8_14_days() == null ? 0 : BRF13.getR43_8_14_days().intValue());
	            }
	Cell r43cell4 = r43row.getCell(7);
	            if (r43cell4 != null) {
	            	r43cell4.setCellValue(
	            			BRF13.getR43_15_days_1_month() == null ? 0 : BRF13.getR43_15_days_1_month().intValue());
	            }
	Cell r43cell5 = r43row.getCell(8);
	            if (r43cell5 != null) {
	            	r43cell5.setCellValue(
	            			BRF13.getR43_1_3_months() == null ? 0 : BRF13.getR43_1_3_months().intValue());
	            }
	Cell r43cell6 = r43row.getCell(9);
	            if (r43cell6 != null) {
	            	r43cell6.setCellValue(
	            			BRF13.getR43_3_6_months() == null ? 0 : BRF13.getR43_3_6_months().intValue());
	            }
	Cell r43cell7 = r43row.getCell(10);
	            if (r43cell7 != null) {
	            	r43cell7.setCellValue(
	            			BRF13.getR43_6_12_months() == null ? 0 : BRF13.getR43_6_12_months().intValue());
	            }
	Cell r43cell8 = r43row.getCell(11);
	            if (r43cell8 != null) {
	            	r43cell8.setCellValue(
	            			BRF13.getR43_1_3_years() == null ? 0 : BRF13.getR43_1_3_years().intValue());
	            }
	Cell r43cell9 = r43row.getCell(12);
	            if (r43cell9 != null) {
	            	r43cell9.setCellValue(
	            			BRF13.getR43_3_years() == null ? 0 : BRF13.getR43_3_years().intValue());
	            }

	          ///Row44
	            Row r44row = sheet.getRow(60);
	            Cell r44cell0 =  r44row.getCell(3);
	            if (r44cell0 != null) {
	            	r44cell0.setCellValue(
	            			BRF13.getR44_overdue() == null ? 0 : BRF13.getR44_overdue().intValue());
	            } 
	  Cell r44cell1 =  r44row.getCell(4);
	            if (r44cell1 != null) {
	            	r44cell1.setCellValue(
	            			BRF13.getR44_overdraft() == null ? 0 : BRF13.getR44_overdraft().intValue());
	            }
	Cell r44cell2 = r44row.getCell(5);
	            if (r44cell2 != null) {
	            	r44cell2.setCellValue(
	            			BRF13.getR44_0_7_days() == null ? 0 : BRF13.getR44_0_7_days().intValue());
	            }
	Cell r44cell3 = r44row.getCell(6);
	            if (r44cell3 != null) {
	            	r44cell3.setCellValue(
	            			BRF13.getR44_8_14_days() == null ? 0 : BRF13.getR44_8_14_days().intValue());
	            }
	Cell r44cell4 = r44row.getCell(7);
	            if (r44cell4 != null) {
	            	r44cell4.setCellValue(
	            			BRF13.getR44_15_days_1_month() == null ? 0 : BRF13.getR44_15_days_1_month().intValue());
	            }
	Cell r44cell5 = r44row.getCell(8);
	            if (r44cell5 != null) {
	            	r44cell5.setCellValue(
	            			BRF13.getR44_1_3_months() == null ? 0 : BRF13.getR44_1_3_months().intValue());
	            }
	Cell r44cell6 = r44row.getCell(9);
	            if (r44cell6 != null) {
	            	r44cell6.setCellValue(
	            			BRF13.getR44_3_6_months() == null ? 0 : BRF13.getR44_3_6_months().intValue());
	            }
	Cell r44cell7 = r44row.getCell(10);
	            if (r44cell7 != null) {
	            	r44cell7.setCellValue(
	            			BRF13.getR44_6_12_months() == null ? 0 : BRF13.getR44_6_12_months().intValue());
	            }
	Cell r44cell8 = r44row.getCell(11);
	            if (r44cell8 != null) {
	            	r44cell8.setCellValue(
	            			BRF13.getR44_1_3_years() == null ? 0 : BRF13.getR44_1_3_years().intValue());
	            }
	Cell r44cell9 = r44row.getCell(12);
	            if (r44cell9 != null) {
	            	r44cell9.setCellValue(
	            			BRF13.getR44_3_years() == null ? 0 : BRF13.getR44_3_years().intValue());
	            }

	            // Save the changes
	        	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	        	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-013-A.xls");
	        	            workbook.write(fileOut);
	        	            fileOut.close();
	        	            System.out.println(fileOut);
	        	            path= fileOut.toString();
	        	            // Close the workbook
	        	            System.out.println("PATH : "+path);
	        	            workbook.close();
	        					}
	        				
	        				}
	        				
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
	        				
	        				

	        				
	        			}////else end

	        		}
	        		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-013-A.xls");

	        		return outputFile;



	        	}
	
	public String detailChanges13(BRF13_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {
			
			Session hs = sessionFactory.getCurrentSession();
				Optional<BRF13_DETAIL_ENTITY> Brf13detail = BRF13_DetaiRep1.findById(foracid);
				
				if (Brf13detail.isPresent()) {
					BRF13_DETAIL_ENTITY BRFdetail = Brf13detail.get();

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
						BRF13_DetaiRep1.save(BRFdetail);

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

/****** ARCHEVE VIEW ******/
	
	public ModelAndView getArchieveBRF013View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {
		
			ModelAndView mv = new ModelAndView();
			Session hs = sessionFactory.getCurrentSession();
			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<BRF13_ENTITY> T1rep = new ArrayList<BRF13_ENTITY>();
			// Query<Object[]> qr;

			List<BRF13_ENTITY> T1Master = new ArrayList<BRF13_ENTITY>();
			/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

			logger.info("Inside archive" +currency);

			try {
				Date d1 = df.parse(todate);
			//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF13_ENTITY a where a.report_date = ?1 ", BRF13_ENTITY.class)
						.setParameter(1, df.parse(todate)).getResultList();

				/*
				 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
				 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
				 */

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			mv.setViewName("RR/BRF013ARCH");
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

/**** ARCH DETAILS 
	 * @throws ParseException ****/

	public ModelAndView ARCHgetBRF013currentDtl(String reportId, String fromdate, String todate, String currency,
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
				System.out.println("Filter - "+filter);
				
				
					qr = hs.createNativeQuery("select * from BRF13_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
					qr.setParameter(1,  df.parse(todate));
					qr.setParameter(2,filter);
						

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF13_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF13_ARCHIVTABLE  where report_date = ?1");
		}

		/*
		 * try { qr.setParameter(1, df.parse(todate));
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		List<BRF13_ARCHIV_ENTITY> T1Master = new ArrayList<BRF13_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF13_ARCHIV_ENTITY a where a.report_date = ?1", BRF13_ARCHIV_ENTITY.class)
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
			String gender = (String)a[46];
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

			BRF13_ARCHIV_ENTITY py =  new BRF13_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
				    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
				    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
				    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
				    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
				    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
				    gender, version, remarks,nreflag);
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

		mv.setViewName("RR" + "/" + "BRF013ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	

}
