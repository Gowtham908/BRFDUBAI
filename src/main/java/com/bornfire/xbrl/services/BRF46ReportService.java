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
import javax.transaction.Transactional;

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
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRF46_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF46_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF46_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF46_Entity;
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
public class BRF46ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF46ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired
	BRF46_DetailRepo brf46_detailrepo;
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF46_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF46_Entity a").getSingleResult();
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

	public ModelAndView getBRF46View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF46_Entity> T1Master = new ArrayList<BRF46_Entity>();
		List<BRF46_Entity> T1Master1 = new ArrayList<BRF46_Entity>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF46_Entity a where a.report_date = ?1 ", BRF46_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
			 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF46");
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

	public ModelAndView getBRF46currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF46_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

				qr.setParameter(2, filter);

			} else {
				qr = hs.createNativeQuery("select * from BRF46_DETAILTABLE a where report_date = ?1");

			}
		} else {
			qr = hs.createNativeQuery("select * from BRF46_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF46_DETAIL_ENTITY> T1Master = new ArrayList<BRF46_DETAIL_ENTITY>();

		try {
			T1Master = hs.createQuery("from BRF46_DETAIL_ENTITY a where a.report_date = ?1", BRF46_DETAIL_ENTITY.class)
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

			BRF46_DETAIL_ENTITY py = new BRF46_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
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

		mv.setViewName("RR" + "/" + "BRF46::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster12", T1Dt1);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	
	public File getFileBRF46(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-46-A ";
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

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46.jrxml");
					}
				}

				/* JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); */
				JasperReport jr= JasperCompileManager.compileReport(jasperFile);
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
			}outputFile = new File(path);
			return outputFile;
			}else {
				
				List<BRF46_Entity> T1Master = new ArrayList<BRF46_Entity>();
				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);
				
				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				T1Master = hs.createQuery("from  BRF46_Entity a where a.report_date = ?1 ", BRF46_Entity.class)
						.setParameter(1, df.parse(todate)).getResultList();
				
				if(T1Master.size() == 1) {
					
					for(BRF46_Entity BRF46 : T1Master ) {
				
				File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-046-AT.xls");
				
				  // Load the Excel file
	        	Workbook workbook = WorkbookFactory.create(Responsecamt);

	            // Get the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            Row row = sheet.getRow(13);
	            Cell cell = row.getCell(5);
	            if (cell != null) {
	                cell.setCellValue(BRF46.getR2_central_bank_uae_resident() == null ? 0 :
	                	BRF46.getR2_central_bank_uae_resident().intValue());
	            }
	            Cell cell1 = row.getCell(6);
	            if (cell1 != null) {
	                cell1.setCellValue(BRF46.getR2_federal_govt_resident() == null ? 0 :
	                	BRF46.getR2_federal_govt_resident().intValue());
	            }
	            Cell cell2 = row.getCell(7);
	            if (cell2 != null) {
	                cell2.setCellValue(BRF46.getR2_non_comm_resident() == null ? 0 :
	                	BRF46.getR2_non_comm_resident().intValue());
	            }
	            Cell cell3 = row.getCell(8);
	            if (cell3 != null) {
	                cell3.setCellValue(BRF46.getR2_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR2_emirates_govt_resident().intValue());
	            }
	            Cell cell4 = row.getCell(9);
	            if (cell4 != null) {
	                cell4.setCellValue(BRF46.getR2_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR2_non_comm_entity_resident().intValue());
	            }
	            Cell cell5 = row.getCell(10);
	            if (cell5 != null) {
	                cell5.setCellValue(BRF46.getR2_gre_resident() == null ? 0 :
	                	BRF46.getR2_gre_resident().intValue());
	            }
	            Cell cell6 = row.getCell(11);
	            if (cell6 != null) {
	                cell6.setCellValue(BRF46.getR2_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR2_gre_private_sector_resident().intValue());
	            }	
	            Cell cell7 = row.getCell(12);
	            if (cell7 != null) {
	                cell7.setCellValue(BRF46.getR2_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR2_banks_private_sector_resident().intValue());
	            }
	            Cell cell8 = row.getCell(13);
	            if (cell8 != null) {
	                cell8.setCellValue(BRF46.getR2_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR2_financial_private_sector_resident().intValue());
	            }
	            Cell cell9 = row.getCell(14);
	            if (cell9 != null) {
	                cell9.setCellValue(BRF46.getR2_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR2_otherprivate_private_sector_resident().intValue());
	            }
	            //////////////////////////////ROW 3 ///////////////////////
	            
				Row row1 = sheet.getRow(14);
	           
	            Cell R3cell1 = row1.getCell(6);
	            if (R3cell1 != null) {
	                R3cell1.setCellValue(BRF46.getR3_federal_govt_resident() == null ? 0 :
	                	BRF46.getR3_federal_govt_resident().intValue());
	            }
	            Cell R3cell2 = row1.getCell(7);
	            if (R3cell2 != null) {
	                R3cell2.setCellValue(BRF46.getR3_non_comm_resident() == null ? 0 :
	                	BRF46.getR3_non_comm_resident().intValue());
	            }
	            Cell R3cell3 = row1.getCell(8);
	            if (R3cell3 != null) {
	                R3cell3.setCellValue(BRF46.getR3_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR3_emirates_govt_resident().intValue());
	            }
	            Cell R3cell4 = row1.getCell(9);
	            if (R3cell4 != null) {
	                R3cell4.setCellValue(BRF46.getR3_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR3_non_comm_entity_resident().intValue());
	            }
	            Cell R3cell5 = row1.getCell(10);
	            if (R3cell5 != null) {
	                R3cell5.setCellValue(BRF46.getR3_gre_resident() == null ? 0 :
	                	BRF46.getR3_gre_resident().intValue());
	            }
	            Cell R3cell6 = row1.getCell(11);
	            if (R3cell6 != null) {
	                R3cell6.setCellValue(BRF46.getR3_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR3_gre_private_sector_resident().intValue());
	            }	
	            Cell R3cell7 = row1.getCell(12);
	            if (R3cell7 != null) {
	                R3cell7.setCellValue(BRF46.getR3_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR3_banks_private_sector_resident().intValue());
	            }
	            Cell R3cell8 = row1.getCell(13);
	            if (R3cell8 != null) {
	                R3cell8.setCellValue(BRF46.getR3_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR3_financial_private_sector_resident().intValue());
	            }
	            Cell R3cell9 = row1.getCell(14);
	            if (R3cell9 != null) {
	                R3cell9.setCellValue(BRF46.getR3_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR3_otherprivate_private_sector_resident().intValue());
	            }
	            ////////////////ROW 4//////////////
				Row row2 = sheet.getRow(15);
	            
	            Cell R4cell1 = row2.getCell(6);
	            if (R4cell1 != null) {
	                R4cell1.setCellValue(BRF46.getR4_federal_govt_resident() == null ? 0 :
	                	BRF46.getR4_federal_govt_resident().intValue());
	            }
	            Cell R4cell2 = row2.getCell(7);
	            if (R4cell2 != null) {
	                R4cell2.setCellValue(BRF46.getR4_non_comm_resident() == null ? 0 :
	                	BRF46.getR4_non_comm_resident().intValue());
	            }
	            Cell R4cell3 = row2.getCell(8);
	            if (R4cell3 != null) {
	                R4cell3.setCellValue(BRF46.getR4_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR4_emirates_govt_resident().intValue());
	            }
	            Cell R4cell4 = row2.getCell(9);
	            if (R4cell4 != null) {
	                R4cell4.setCellValue(BRF46.getR4_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR4_non_comm_entity_resident().intValue());
	            }
	            Cell R4cell5 = row2.getCell(10);
	            if (R4cell5 != null) {
	                R4cell5.setCellValue(BRF46.getR4_gre_resident() == null ? 0 :
	                	BRF46.getR4_gre_resident().intValue());
	            }
	            Cell R4cell6 = row2.getCell(11);
	            if (R4cell6 != null) {
	                R4cell6.setCellValue(BRF46.getR4_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR4_gre_private_sector_resident().intValue());
	            }	
	            Cell R4cell7 = row2.getCell(12);
	            if (R4cell7 != null) {
	                R4cell7.setCellValue(BRF46.getR4_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR4_banks_private_sector_resident().intValue());
	            }
	            Cell R4cell8 = row2.getCell(13);
	            if (R4cell8 != null) {
	                R4cell8.setCellValue(BRF46.getR4_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR4_financial_private_sector_resident().intValue());
	            }
	            Cell R4cell9 = row2.getCell(14);
	            if (R4cell9 != null) {
	                R4cell9.setCellValue(BRF46.getR4_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR4_otherprivate_private_sector_resident().intValue());
	            }
	            
	            
	            ///////////////ROW 7 //////////
				Row row3 = sheet.getRow(18);
	            Cell R5cell = row3.getCell(5);
	            if (R5cell != null) {
	                R5cell.setCellValue(BRF46.getR7_central_bank_uae_resident() == null ? 0 :
	                	BRF46.getR7_central_bank_uae_resident().intValue());
	            }
	            Cell R5cell1 = row3.getCell(6);
	            if (R5cell1 != null) {
	                R5cell1.setCellValue(BRF46.getR7_federal_govt_resident() == null ? 0 :
	                	BRF46.getR7_federal_govt_resident().intValue());
	            }
	            Cell R5cell2 = row3.getCell(7);
	            if (R5cell2 != null) {
	                R5cell2.setCellValue(BRF46.getR7_non_comm_resident() == null ? 0 :
	                	BRF46.getR7_non_comm_resident().intValue());
	            }
	            Cell R5cell3 = row3.getCell(8);
	            if (R5cell3 != null) {
	                R5cell3.setCellValue(BRF46.getR7_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR7_emirates_govt_resident().intValue());
	            }
	            Cell R5cell4 = row3.getCell(9);
	            if (R5cell4 != null) {
	                R5cell4.setCellValue(BRF46.getR7_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR7_non_comm_entity_resident().intValue());
	            }
	            Cell R5cell5 = row3.getCell(10);
	            if (R5cell5 != null) {
	                R5cell5.setCellValue(BRF46.getR7_gre_resident() == null ? 0 :
	                	BRF46.getR7_gre_resident().intValue());
	            }
	            Cell R5cell6 = row3.getCell(11);
	            if (R5cell6 != null) {
	                R5cell6.setCellValue(BRF46.getR7_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR7_gre_private_sector_resident().intValue());
	            }	
	            Cell R5cell7 = row3.getCell(12);
	            if (R5cell7 != null) {
	                R5cell7.setCellValue(BRF46.getR7_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR7_banks_private_sector_resident().intValue());
	            }
	            Cell R5cell8 = row3.getCell(13);
	            if (R5cell8 != null) {
	                R5cell8.setCellValue(BRF46.getR7_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR7_financial_private_sector_resident().intValue());
	            }
	            Cell R5cell9 = row3.getCell(14);
	            if (R5cell9 != null) {
	                R5cell9.setCellValue(BRF46.getR7_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR7_otherprivate_private_sector_resident().intValue());
	            }
	            
	            //////ROW8/////
				Row row4 = sheet.getRow(19);
	            Cell R6cell1 = row4.getCell(6);
	            if (R6cell1 != null) {
	                R6cell1.setCellValue(BRF46.getR8_federal_govt_resident() == null ? 0 :
	                	BRF46.getR8_federal_govt_resident().intValue());
	            }
	            Cell R6cell2 = row4.getCell(7);
	            if (R6cell2 != null) {
	                R6cell2.setCellValue(BRF46.getR8_non_comm_resident() == null ? 0 :
	                	BRF46.getR8_non_comm_resident().intValue());
	            }
	            Cell R6cell3 = row4.getCell(8);
	            if (R6cell3 != null) {
	                R6cell3.setCellValue(BRF46.getR8_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR8_emirates_govt_resident().intValue());
	            }
	            Cell R6cell4 = row4.getCell(9);
	            if (R6cell4 != null) {
	                R6cell4.setCellValue(BRF46.getR8_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR8_non_comm_entity_resident().intValue());
	            }
	            Cell R6cell5 = row4.getCell(10);
	            if (R6cell5 != null) {
	                R6cell5.setCellValue(BRF46.getR8_gre_resident() == null ? 0 :
	                	BRF46.getR8_gre_resident().intValue());
	            }
	            Cell R6cell6 = row4.getCell(11);
	            if (R6cell6 != null) {
	                R6cell6.setCellValue(BRF46.getR8_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR8_gre_private_sector_resident().intValue());
	            }	
	            Cell R6cell7 = row4.getCell(12);
	            if (R6cell7 != null) {
	                R6cell7.setCellValue(BRF46.getR8_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR8_banks_private_sector_resident().intValue());
	            }
	            Cell R6cell8 = row4.getCell(13);
	            if (R6cell8 != null) {
	                R6cell8.setCellValue(BRF46.getR8_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR8_financial_private_sector_resident().intValue());
	            }
	            Cell R6cell9 = row4.getCell(14);
	            if (R6cell9 != null) {
	                R6cell9.setCellValue(BRF46.getR8_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR8_otherprivate_private_sector_resident().intValue());
	            }
	            
	            //////////ROW9///////////
				Row row5 = sheet.getRow(20);
	            Cell R7cell = row5.getCell(5);
	            if (R7cell != null) {
	                R7cell.setCellValue(BRF46.getR9_central_bank_uae_resident() == null ? 0 :
	                	BRF46.getR9_central_bank_uae_resident().intValue());
	            }
	            Cell R7cell1 = row5.getCell(6);
	            if (R7cell1 != null) {
	                R7cell1.setCellValue(BRF46.getR9_federal_govt_resident() == null ? 0 :
	                	BRF46.getR9_federal_govt_resident().intValue());
	            }
	            Cell R7cell2 = row5.getCell(7);
	            if (R7cell2 != null) {
	                R7cell2.setCellValue(BRF46.getR9_non_comm_resident() == null ? 0 :
	                	BRF46.getR9_non_comm_resident().intValue());
	            }
	            Cell R7cell3 = row5.getCell(8);
	            if (R7cell3 != null) {
	                R7cell3.setCellValue(BRF46.getR9_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR9_emirates_govt_resident().intValue());
	            }
	            Cell R7cell4 = row5.getCell(9);
	            if (R7cell4 != null) {
	                R7cell4.setCellValue(BRF46.getR9_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR9_non_comm_entity_resident().intValue());
	            }
	            Cell R7cell5 = row5.getCell(10);
	            if (R7cell5 != null) {
	                R7cell5.setCellValue(BRF46.getR9_gre_resident() == null ? 0 :
	                	BRF46.getR9_gre_resident().intValue());
	            }
	            Cell R7cell6 = row5.getCell(11);
	            if (R7cell6 != null) {
	                R7cell6.setCellValue(BRF46.getR9_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR9_gre_private_sector_resident().intValue());
	            }	
	            Cell R7cell7 = row5.getCell(12);
	            if (R7cell7 != null) {
	                R7cell7.setCellValue(BRF46.getR9_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR9_banks_private_sector_resident().intValue());
	            }
	            Cell R7cell8 = row5.getCell(13);
	            if (R7cell8 != null) {
	                R7cell8.setCellValue(BRF46.getR9_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR9_financial_private_sector_resident().intValue());
	            }
	            Cell R7cell9 = row5.getCell(14);
	            if (R7cell9 != null) {
	                R7cell9.setCellValue(BRF46.getR9_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR9_otherprivate_private_sector_resident().intValue());
	            }
	            ///////////ROW10///////////
				Row row6 = sheet.getRow(22);
		          
	            Cell R8cell1 = row6.getCell(6);
	            if (R8cell1 != null) {
	                R8cell1.setCellValue(BRF46.getR11_federal_govt_resident() == null ? 0 :
	                	BRF46.getR11_federal_govt_resident().intValue());
	            }
	            Cell R8cell2 = row6.getCell(7);
	            if (R8cell2 != null) {
	                R8cell2.setCellValue(BRF46.getR11_non_comm_resident() == null ? 0 :
	                	BRF46.getR11_non_comm_resident().intValue());
	            }
	            Cell R8cell3 = row6.getCell(8);
	            if (R8cell3 != null) {
	                R8cell3.setCellValue(BRF46.getR11_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR11_emirates_govt_resident().intValue());
	            }
	            Cell R8cell4 = row6.getCell(9);
	            if (R8cell4 != null) {
	                R8cell4.setCellValue(BRF46.getR11_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR11_non_comm_entity_resident().intValue());
	            }
	            Cell R8cell5 = row6.getCell(10);
	            if (R8cell5 != null) {
	                R8cell5.setCellValue(BRF46.getR11_gre_resident() == null ? 0 :
	                	BRF46.getR11_gre_resident().intValue());
	            }
	            Cell R8cell6 = row6.getCell(11);
	            if (R8cell6 != null) {
	                R8cell6.setCellValue(BRF46.getR11_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR11_gre_private_sector_resident().intValue());
	            }	
	            Cell R8cell7 = row6.getCell(12);
	            if (R8cell7 != null) {
	                R8cell7.setCellValue(BRF46.getR11_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR11_banks_private_sector_resident().intValue());
	            }
	            Cell R8cell8 = row6.getCell(13);
	            if (R8cell8 != null) {
	                R8cell8.setCellValue(BRF46.getR11_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR11_financial_private_sector_resident().intValue());
	            }
	            Cell R8cell9 = row6.getCell(14);
	            if (R8cell9 != null) {
	                R8cell9.setCellValue(BRF46.getR11_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR11_otherprivate_private_sector_resident().intValue());
	            }
	            
	            /////////////////////ROW11//////////////
				Row row7 = sheet.getRow(23);
		          
	            Cell R9cell1 = row7.getCell(6);
	            if (R9cell1 != null) {
	                R9cell1.setCellValue(BRF46.getR12_federal_govt_resident() == null ? 0 :
	                	BRF46.getR12_federal_govt_resident().intValue());
	            }
	            Cell R9cell2 = row7.getCell(7);
	            if (R9cell2 != null) {
	                R9cell2.setCellValue(BRF46.getR12_non_comm_resident() == null ? 0 :
	                	BRF46.getR12_non_comm_resident().intValue());
	            }
	            Cell R9cell3 = row7.getCell(8);
	            if (R9cell3 != null) {
	                R9cell3.setCellValue(BRF46.getR12_emirates_govt_resident() == null ? 0 :
	                	BRF46.getR12_emirates_govt_resident().intValue());
	            }
	            Cell R9cell4 = row7.getCell(9);
	            if (R9cell4 != null) {
	                R9cell4.setCellValue(BRF46.getR12_non_comm_entity_resident() == null ? 0 :
	                	BRF46.getR12_non_comm_entity_resident().intValue());
	            }
	            Cell R9cell5 = row7.getCell(10);
	            if (R9cell5 != null) {
	                R9cell5.setCellValue(BRF46.getR12_gre_resident() == null ? 0 :
	                	BRF46.getR12_gre_resident().intValue());
	            }
	            Cell R9cell6 = row7.getCell(11);
	            if (R9cell6 != null) {
	                R9cell6.setCellValue(BRF46.getR12_gre_private_sector_resident() == null ? 0 :
	                	BRF46.getR12_gre_private_sector_resident().intValue());
	            }	
	            Cell R9cell7 = row7.getCell(12);
	            if (R9cell7 != null) {
	                R9cell7.setCellValue(BRF46.getR12_banks_private_sector_resident() == null ? 0 :
	                	BRF46.getR12_banks_private_sector_resident().intValue());
	            }
	            Cell R9cell8 = row7.getCell(13);
	            if (R9cell8 != null) {
	                R9cell8.setCellValue(BRF46.getR12_financial_private_sector_resident() == null ? 0 :
	                	BRF46.getR12_financial_private_sector_resident().intValue());
	            }
	            Cell R9cell9 = row7.getCell(14);
	            if (R9cell9 != null) {
	                R9cell9.setCellValue(BRF46.getR12_otherprivate_private_sector_resident() == null ? 0 :
	                	BRF46.getR12_otherprivate_private_sector_resident().intValue());
	            }
	            
	            
	            
	            ////////////////NON RESIDENT//////////////////////// R1
	            Row row8 = sheet.getRow(29);
	            Cell R10cell = row8.getCell(5);
	            if (R10cell != null) {
	                R10cell.setCellValue(BRF46.getR15_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR15_other_centralbank_non_resident().intValue());
	            }
	            Cell R10cell1 = row8.getCell(6);
	            if (R10cell1 != null) {
	                R10cell1.setCellValue(BRF46.getR15_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR15_federal_govt_non_resident().intValue());
	            }
	            Cell R10cell2 = row8.getCell(7);
	            if (R10cell2 != null) {
	                R10cell2.setCellValue(BRF46.getR15_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR15_non_comm_entity_non_resident().intValue());
	            }
	            Cell R10cell3 = row8.getCell(8);
	            if (R10cell3 != null) {
	                R10cell3.setCellValue(BRF46.getR15_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR15_emirates_govt_non_resident().intValue());
	            }
	            Cell R10cell4 = row8.getCell(9);
	            if (R10cell4 != null) {
	                R10cell4.setCellValue(BRF46.getR15_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR15_non_comm_entity_non_resident().intValue());
	            }
	            Cell R10cell5 = row8.getCell(10);
	            if (R10cell5 != null) {
	                R10cell5.setCellValue(BRF46.getR15_gre_non_resident() == null ? 0 :
	                	BRF46.getR15_gre_non_resident().intValue());
	            }
	            Cell R10cell6 = row8.getCell(11);
	            if (R10cell6 != null) {
	                R10cell6.setCellValue(BRF46.getR15_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR15_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R10cell7 = row8.getCell(12);
	            if (R10cell7 != null) {
	                R10cell7.setCellValue(BRF46.getR15_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR15_banks_private_sector_non_resident().intValue());
	            }
	            Cell R10cell8 = row8.getCell(13);
	            if (R10cell8 != null) {
	                R10cell8.setCellValue(BRF46.getR15_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR15_financial_private_sector_non_resident().intValue());
	            }
	            Cell R10cell9 = row8.getCell(14);
	            if (R10cell9 != null) {
	                R10cell9.setCellValue(BRF46.getR15_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR15_otherprivate_private_sector_non_resident().intValue());
	            }
	            ////////R2
	            
				Row row9 = sheet.getRow(30);
	            Cell R11cell = row9.getCell(5);
	            if (R11cell != null) {
	                R11cell.setCellValue(BRF46.getR16_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR16_other_centralbank_non_resident().intValue());
	            }
	            Cell R11cell1 = row9.getCell(6);
	            if (R11cell1 != null) {
	                R11cell1.setCellValue(BRF46.getR16_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR16_federal_govt_non_resident().intValue());
	            }
	            Cell R11cell2 = row9.getCell(7);
	            if (R11cell2 != null) {
	                R11cell2.setCellValue(BRF46.getR16_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR16_non_comm_entity_non_resident().intValue());
	            }
	            Cell R11cell3 = row9.getCell(8);
	            if (R11cell3 != null) {
	                R11cell3.setCellValue(BRF46.getR16_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR16_emirates_govt_non_resident().intValue());
	            }
	            Cell R11cell4 = row9.getCell(9);
	            if (R11cell4 != null) {
	                R11cell4.setCellValue(BRF46.getR16_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR16_non_comm_entity_non_resident().intValue());
	            }
	            Cell R11cell5 = row9.getCell(10);
	            if (R11cell5 != null) {
	                R11cell5.setCellValue(BRF46.getR16_gre_non_resident() == null ? 0 :
	                	BRF46.getR16_gre_non_resident().intValue());
	            }
	            Cell R11cell6 = row9.getCell(11);
	            if (R11cell6 != null) {
	                R11cell6.setCellValue(BRF46.getR16_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR16_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R11cell7 = row9.getCell(12);
	            if (R11cell7 != null) {
	                R11cell7.setCellValue(BRF46.getR16_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR16_banks_private_sector_non_resident().intValue());
	            }
	            Cell R11cell8 = row9.getCell(13);
	            if (R11cell8 != null) {
	                R11cell8.setCellValue(BRF46.getR16_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR16_financial_private_sector_non_resident().intValue());
	            }
	            Cell R11cell9 = row9.getCell(14);
	            if (R11cell9 != null) {
	                R11cell9.setCellValue(BRF46.getR16_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR16_otherprivate_private_sector_non_resident().intValue());
	            }
	            /////R3
				Row row10 = sheet.getRow(31);
	            Cell R12cell = row10.getCell(5);
	            if (R12cell != null) {
	                R12cell.setCellValue(BRF46.getR17_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR17_other_centralbank_non_resident().intValue());
	            }
	            Cell R12cell1 = row10.getCell(6);
	            if (R12cell1 != null) {
	                R12cell1.setCellValue(BRF46.getR17_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR17_federal_govt_non_resident().intValue());
	            }
	            Cell R12cell2 = row10.getCell(7);
	            if (R12cell2 != null) {
	                R12cell2.setCellValue(BRF46.getR17_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR17_non_comm_entity_non_resident().intValue());
	            }
	            Cell R12cell3 = row10.getCell(8);
	            if (R12cell3 != null) {
	                R12cell3.setCellValue(BRF46.getR17_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR17_emirates_govt_non_resident().intValue());
	            }
	            Cell R12cell4 = row10.getCell(9);
	            if (R12cell4 != null) {
	                R12cell4.setCellValue(BRF46.getR17_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR17_non_comm_entity_non_resident().intValue());
	            }
	            Cell R12cell5 = row10.getCell(10);
	            if (R12cell5 != null) {
	                R12cell5.setCellValue(BRF46.getR17_gre_non_resident() == null ? 0 :
	                	BRF46.getR17_gre_non_resident().intValue());
	            }
	            Cell R12cell6 = row10.getCell(11);
	            if (R12cell6 != null) {
	                R12cell6.setCellValue(BRF46.getR17_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR17_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R12cell7 = row10.getCell(12);
	            if (R12cell7 != null) {
	                R12cell7.setCellValue(BRF46.getR17_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR17_banks_private_sector_non_resident().intValue());
	            }
	            Cell R12cell8 = row10.getCell(13);
	            if (R12cell8 != null) {
	                R12cell8.setCellValue(BRF46.getR17_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR17_financial_private_sector_non_resident().intValue());
	            }
	            Cell R12cell9 = row10.getCell(14);
	            if (R12cell9 != null) {
	                R12cell9.setCellValue(BRF46.getR17_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR17_otherprivate_private_sector_non_resident().intValue());
	            }
	            //////////R4
				Row row11 = sheet.getRow(34);
	            Cell R13cell = row11.getCell(5);
	            if (R13cell != null) {
	                R13cell.setCellValue(BRF46.getR20_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR20_other_centralbank_non_resident().intValue());
	            }
	            Cell R13cell1 = row11.getCell(6);
	            if (R13cell1 != null) {
	                R13cell1.setCellValue(BRF46.getR20_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR20_federal_govt_non_resident().intValue());
	            }
	            Cell R13cell2 = row11.getCell(7);
	            if (R13cell2 != null) {
	                R13cell2.setCellValue(BRF46.getR20_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR20_non_comm_entity_non_resident().intValue());
	            }
	            Cell R13cell3 = row11.getCell(8);
	            if (R13cell3 != null) {
	                R13cell3.setCellValue(BRF46.getR20_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR20_emirates_govt_non_resident().intValue());
	            }
	            Cell R13cell4 = row11.getCell(9);
	            if (R13cell4 != null) {
	                R13cell4.setCellValue(BRF46.getR20_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR20_non_comm_entity_non_resident().intValue());
	            }
	            Cell R13cell5 = row11.getCell(10);
	            if (R13cell5 != null) {
	                R13cell5.setCellValue(BRF46.getR20_gre_non_resident() == null ? 0 :
	                	BRF46.getR20_gre_non_resident().intValue());
	            }
	            Cell R13cell6 = row11.getCell(11);
	            if (R13cell6 != null) {
	                R13cell6.setCellValue(BRF46.getR20_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR20_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R13cell7 = row11.getCell(12);
	            if (R13cell7 != null) {
	                R13cell7.setCellValue(BRF46.getR20_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR20_banks_private_sector_non_resident().intValue());
	            }
	            Cell R13cell8 = row11.getCell(13);
	            if (R13cell8 != null) {
	                R13cell8.setCellValue(BRF46.getR20_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR20_financial_private_sector_non_resident().intValue());
	            }
	            Cell R13cell9 = row11.getCell(14);
	            if (R13cell9 != null) {
	                R13cell9.setCellValue(BRF46.getR20_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR20_otherprivate_private_sector_non_resident().intValue());
	            }
	            /////R5
				Row row12 = sheet.getRow(35);
	            Cell R14cell = row12.getCell(5);
	            if (R14cell != null) {
	                R14cell.setCellValue(BRF46.getR21_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR21_other_centralbank_non_resident().intValue());
	            }
	            Cell R14cell1 = row12.getCell(6);
	            if (R14cell1 != null) {
	                R14cell1.setCellValue(BRF46.getR21_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR21_federal_govt_non_resident().intValue());
	            }
	            Cell R14cell2 = row12.getCell(7);
	            if (R14cell2 != null) {
	                R14cell2.setCellValue(BRF46.getR21_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR21_non_comm_entity_non_resident().intValue());
	            }
	            Cell R14cell3 = row12.getCell(8);
	            if (R14cell3 != null) {
	                R14cell3.setCellValue(BRF46.getR21_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR21_emirates_govt_non_resident().intValue());
	            }
	            Cell R14cell4 = row12.getCell(9);
	            if (R14cell4 != null) {
	                R14cell4.setCellValue(BRF46.getR21_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR21_non_comm_entity_non_resident().intValue());
	            }
	            Cell R14cell5 = row12.getCell(10);
	            if (R14cell5 != null) {
	                R14cell5.setCellValue(BRF46.getR21_gre_non_resident() == null ? 0 :
	                	BRF46.getR21_gre_non_resident().intValue());
	            }
	            Cell R14cell6 = row12.getCell(11);
	            if (R14cell6 != null) {
	                R14cell6.setCellValue(BRF46.getR21_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR21_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R14cell7 = row12.getCell(12);
	            if (R14cell7 != null) {
	                R14cell7.setCellValue(BRF46.getR21_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR21_banks_private_sector_non_resident().intValue());
	            }
	            Cell R14cell8 = row12.getCell(13);
	            if (R14cell8 != null) {
	                R14cell8.setCellValue(BRF46.getR21_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR21_financial_private_sector_non_resident().intValue());
	            }
	            Cell R14cell9 = row12.getCell(14);
	            if (R14cell9 != null) {
	                R14cell9.setCellValue(BRF46.getR21_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR21_otherprivate_private_sector_non_resident().intValue());
	            }
	            ///////////R6
				Row row13 = sheet.getRow(36);
	            Cell R15cell = row13.getCell(5);
	            if (R15cell != null) {
	                R15cell.setCellValue(BRF46.getR22_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR22_other_centralbank_non_resident().intValue());
	            }
	            Cell R15cell1 = row13.getCell(6);
	            if (R15cell1 != null) {
	                R15cell1.setCellValue(BRF46.getR22_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR22_federal_govt_non_resident().intValue());
	            }
	            Cell R15cell2 = row13.getCell(7);
	            if (R15cell2 != null) {
	                R15cell2.setCellValue(BRF46.getR22_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR22_non_comm_entity_non_resident().intValue());
	            }
	            Cell R15cell3 = row13.getCell(8);
	            if (R15cell3 != null) {
	                R15cell3.setCellValue(BRF46.getR22_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR22_emirates_govt_non_resident().intValue());
	            }
	            Cell R15cell4 = row13.getCell(9);
	            if (R15cell4 != null) {
	                R15cell4.setCellValue(BRF46.getR22_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR22_non_comm_entity_non_resident().intValue());
	            }
	            Cell R15cell5 = row13.getCell(10);
	            if (R15cell5 != null) {
	                R15cell5.setCellValue(BRF46.getR22_gre_non_resident() == null ? 0 :
	                	BRF46.getR22_gre_non_resident().intValue());
	            }
	            Cell R15cell6 = row13.getCell(11);
	            if (R15cell6 != null) {
	                R15cell6.setCellValue(BRF46.getR22_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR22_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R15cell7 = row13.getCell(12);
	            if (R15cell7 != null) {
	                R15cell7.setCellValue(BRF46.getR22_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR22_banks_private_sector_non_resident().intValue());
	            }
	            Cell R15cell8 = row13.getCell(13);
	            if (R15cell8 != null) {
	                R15cell8.setCellValue(BRF46.getR22_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR22_financial_private_sector_non_resident().intValue());
	            }
	            Cell R15cell9 = row13.getCell(14);
	            if (R15cell9 != null) {
	                R15cell9.setCellValue(BRF46.getR22_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR22_otherprivate_private_sector_non_resident().intValue());
	            }
	            //////R7
				Row row14 = sheet.getRow(38);
	            Cell R16cell = row14.getCell(5);
	            if (R16cell != null) {
	                R16cell.setCellValue(BRF46.getR24_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR24_other_centralbank_non_resident().intValue());
	            }
	            Cell R16cell1 = row14.getCell(6);
	            if (R16cell1 != null) {
	                R16cell1.setCellValue(BRF46.getR24_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR24_federal_govt_non_resident().intValue());
	            }
	            Cell R16cell2 = row14.getCell(7);
	            if (R16cell2 != null) {
	                R16cell2.setCellValue(BRF46.getR24_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR24_non_comm_entity_non_resident().intValue());
	            }
	            Cell R16cell3 = row14.getCell(8);
	            if (R16cell3 != null) {
	                R16cell3.setCellValue(BRF46.getR24_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR24_emirates_govt_non_resident().intValue());
	            }
	            Cell R16cell4 = row14.getCell(9);
	            if (R16cell4 != null) {
	                R16cell4.setCellValue(BRF46.getR24_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR24_non_comm_entity_non_resident().intValue());
	            }
	            Cell R16cell5 = row14.getCell(10);
	            if (R16cell5 != null) {
	                R16cell5.setCellValue(BRF46.getR24_gre_non_resident() == null ? 0 :
	                	BRF46.getR24_gre_non_resident().intValue());
	            }
	            Cell R16cell6 = row14.getCell(11);
	            if (R16cell6 != null) {
	                R16cell6.setCellValue(BRF46.getR24_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR24_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R16cell7 = row14.getCell(12);
	            if (R16cell7 != null) {
	                R16cell7.setCellValue(BRF46.getR24_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR24_banks_private_sector_non_resident().intValue());
	            }
	            Cell R16cell8 = row14.getCell(13);
	            if (R16cell8 != null) {
	                R16cell8.setCellValue(BRF46.getR24_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR24_financial_private_sector_non_resident().intValue());
	            }
	            Cell R16cell9 = row14.getCell(14);
	            if (R16cell9 != null) {
	                R16cell9.setCellValue(BRF46.getR24_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR24_otherprivate_private_sector_non_resident().intValue());
	            }
	            ////R8
				Row row15 = sheet.getRow(39);
	            Cell R17cell = row15.getCell(5);
	            if (R17cell != null) {
	                R17cell.setCellValue(BRF46.getR25_other_centralbank_non_resident() == null ? 0 :
	                	BRF46.getR25_other_centralbank_non_resident().intValue());
	            }
	            Cell R17cell1 = row15.getCell(6);
	            if (R17cell1 != null) {
	                R17cell1.setCellValue(BRF46.getR25_federal_govt_non_resident() == null ? 0 :
	                	BRF46.getR25_federal_govt_non_resident().intValue());
	            }
	            Cell R17cell2 = row15.getCell(7);
	            if (R17cell2 != null) {
	                R17cell2.setCellValue(BRF46.getR25_non_comm_non_resident()== null ? 0 :
	                	BRF46.getR25_non_comm_entity_non_resident().intValue());
	            }
	            Cell R17cell3 = row15.getCell(8);
	            if (R17cell3 != null) {
	                R17cell3.setCellValue(BRF46.getR25_emirates_govt_non_resident() == null ? 0 :
	                	BRF46.getR25_emirates_govt_non_resident().intValue());
	            }
	            Cell R17cell4 = row15.getCell(9);
	            if (R17cell4 != null) {
	                R17cell4.setCellValue(BRF46.getR25_non_comm_entity_non_resident() == null ? 0 :
	                	BRF46.getR25_non_comm_entity_non_resident().intValue());
	            }
	            Cell R17cell5 = row15.getCell(10);
	            if (R17cell5 != null) {
	                R17cell5.setCellValue(BRF46.getR25_gre_non_resident() == null ? 0 :
	                	BRF46.getR25_gre_non_resident().intValue());
	            }
	            Cell R17cell6 = row15.getCell(11);
	            if (R17cell6 != null) {
	                R17cell6.setCellValue(BRF46.getR25_gre_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR25_gre_private_sector_non_resident().intValue());
	            }	
	            Cell R17cell7 = row15.getCell(12);
	            if (R17cell7 != null) {
	                R17cell7.setCellValue(BRF46.getR25_banks_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR25_banks_private_sector_non_resident().intValue());
	            }
	            Cell R17cell8 = row15.getCell(13);
	            if (R17cell8 != null) {
	                R17cell8.setCellValue(BRF46.getR25_financial_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR25_financial_private_sector_non_resident().intValue());
	            }
	            Cell R17cell9 = row15.getCell(14);
	            if (R17cell9 != null) {
	                R17cell9.setCellValue(BRF46.getR25_otherprivate_private_sector_non_resident() == null ? 0 :
	                	BRF46.getR25_otherprivate_private_sector_non_resident().intValue());
	            }
	            
	            
	            
	            // Save the changes
	            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-046-A.xls");
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
		outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-046-A.xls");

		return outputFile;
	
	
	
	}

	/*public File getFileBRF46(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-46-A ";
		try {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
			Date ConDate = dateFormat1.parse(todate);
			System.out.println(ConDate);
			SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
			String strDate1 = formatter1.format(ConDate);
			fileName = "t" + reportId + "_" + strDate1;
			

		} catch (ParseException e1) {

			logger.info(e1.getMessage());
			e1.printStackTrace();
		}

		if (!filetype.equals("xbrl")) {

			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46_Detail.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46_Detail.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF46.jrxml");
					}
				}

				 JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile); 
				JasperReport jr= JasperCompileManager.compileReport(jasperFile);
				HashMap<String, Object> map = new HashMap<String, Object>();

				logger.info("Assigning Parameters for Jasper");
				map.put("REPORT_DATE", todate);
				try {
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
					Date ConDate = dateFormat1.parse(todate);
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
					String strDate1 = formatter1.format(ConDate);

					String today = dateFormat.format(new SimpleDateFormat("dd-MMM-yyyy").parse(strDate1));
					
				} catch (ParseException e1) {

					logger.info(e1.getMessage());
					e1.printStackTrace();
				}
	
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

		}
		outputFile = new File(path);

		return outputFile;
	}
	*/

	public ModelAndView getArchieveBRF046View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF46_Entity> T1Master = new ArrayList<BRF46_Entity>();
		List<BRF46_Entity> T1Master1 = new ArrayList<BRF46_Entity>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF46_Entity a where a.report_date = ?1 ", BRF46_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();

			/*
			 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
			 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF46ARCH");
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

	public ModelAndView ARCHgetBRF046currentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF46_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
				qr.setParameter(1, df.parse(todate));
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF46_ARCHIVTABLE");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF46_ARCHIVTABLE  where report_date = ?1");
		}

		List<BRF46_ARCHIV_ENTITY> T1Master = new ArrayList<BRF46_ARCHIV_ENTITY>();

		try {
			System.out.println("Values entered");
			T1Master = hs.createQuery("from BRF46_ARCHIV_ENTITY a where a.report_date = ?1", BRF46_ARCHIV_ENTITY.class)
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
			String nre_flag = (String) a[49];
			
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

			BRF46_ARCHIV_ENTITY py = new BRF46_ARCHIV_ENTITY( cust_id,  foracid,  act_balance_amt_lc,  eab_lc,
					 acct_name,  acct_crncy_code,  gl_code,  gl_sub_head_code,  gl_sub_head_desc,
					 country_of_incorp,  cust_type,  schm_code,  schm_type,  sol_id,  acid,
					 segment,  sub_segment,  sector,  sub_sector,  sector_code,
					 group_id,  constitution_code,  country,  legal_entity_type,
					 constitution_desc,  purpose_of_advn,  hni_networth,  turnover,  bacid,
					 report_name_1,  report_label_1,  report_addl_criteria_1,  report_addl_criteria_2,
					 report_addl_criteria_3,  create_user,  create_time,  modify_user,  modify_time,
					 verify_user,  verify_time,  entity_flg,  modify_flg,  del_flg,
					 nre_status,  report_date,  maturity_date,  gender,  version,  remarks,nre_flag);
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
		mv.setViewName("RR" + "/" + "BRF46ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
	public String detailChanges46(BRF46_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF46_DETAIL_ENTITY> Brf46detail = brf46_detailrepo.findById(foracid);

			if (Brf46detail.isPresent()) {
				BRF46_DETAIL_ENTITY BRFdetail = Brf46detail.get();

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
					brf46_detailrepo.save(BRFdetail);

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
}