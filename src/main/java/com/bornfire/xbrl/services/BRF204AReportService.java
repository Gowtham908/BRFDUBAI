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

import com.bornfire.xbrl.entities.BRBS.BRF204A_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF204B_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF204_ARCHIV_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF204_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF204_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF207_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY1;
import com.bornfire.xbrl.entities.BRBS.BRF51_ENTITY2;
import com.bornfire.xbrl.entities.BRBS.BRF64_Entity;
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
public class BRF204AReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF204AReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;
	
	@Autowired 
	BRF204_DetailRepo brf204_detailrepo;
	

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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF204A_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from BRF204A_ENTITY a").getSingleResult();
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

	public ModelAndView getBRF204AView(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF204A_ENTITY> T1rep = new ArrayList<BRF204A_ENTITY>();
		// Query<Object[]> qr;

		List<BRF204A_ENTITY> T1Master = new ArrayList<BRF204A_ENTITY>();
		List<BRF204B_ENTITY> T1Master1 = new ArrayList<BRF204B_ENTITY>();

		logger.info("Inside archive" + currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF204A_ENTITY a where a.report_date = ?1 ", BRF204A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF204B_ENTITY a where a.report_date = ?1 ", BRF204B_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF204");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	public ModelAndView getBRF204AcurrentDtl(String reportId, String fromdate, String todate, String currency,
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
						"select * from BRF204_DETAILTABLE   a where report_date = ?1 and report_label_1 =?2");
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF204_DETAILTABLE a where report_date = ?1");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF204_DETAILTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF204_DETAIL_ENTITY> T1Master = new ArrayList<BRF204_DETAIL_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF204_DETAIL_ENTITY a where a.report_date = ?1", BRF204_DETAIL_ENTITY.class)
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

			BRF204_DETAIL_ENTITY py = new BRF204_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF204::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}

	
		public File getFileBRF204A(String reportId, String fromdate, String todate, String currency, String dtltype,

				String filetype) throws FileNotFoundException, JRException, SQLException {

			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			String path = this.env.getProperty("output.exportpath");
			String fileName = "";
			String zipFileName = "";
			File outputFile;

			logger.info("Getting Output file :" + reportId);
			fileName = "011-BRF-204-A" ;
						if (!filetype.equals("xbrl")) {
							
							if(!filetype.equals("BRF")) {

				try {
					InputStream jasperFile;
					logger.info("Getting Jasper file :" + reportId);
					if (filetype.equals("detailexcel")) {
						if (dtltype.equals("report")) {

							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF204_DETAIL.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF204_DETAIL.jrxml");
						}
					} else {
						if (dtltype.equals("report")) {
							logger.info("Inside report");
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF204A.jrxml");
						} else {
							jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF204A.jrxml");
						}
					}


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
			}
			else {
				List<BRF204A_ENTITY> T1Master = new ArrayList<>();
				List<BRF204B_ENTITY> T1Master1 = new ArrayList<>();

				Session hs = sessionFactory.getCurrentSession();
				try {
					Date d1 = df.parse(todate);

					T1Master = hs.createQuery("from BRF204A_ENTITY a where a.report_date = ?1", BRF204A_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();
					T1Master1 = hs.createQuery("from BRF204B_ENTITY a where a.report_date = ?1", BRF204B_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					File responseCamt = new File(env.getProperty("output.exportpathtemp") + "011-BRF-204-AT.xls");
					Workbook workbook = WorkbookFactory.create(responseCamt);
					
					Sheet sheet = workbook.getSheetAt(0);
					
					if (T1Master.size() == 1) {
						for (BRF204A_ENTITY BRF204A : T1Master) {
							Row row = sheet.getRow(11);
				            
					       	 Cell cell = row.getCell(4);
					       	 if (cell != null) {
					            cell.setCellValue(BRF204A.getR2_gcc_ksa_aed() == null ? 0 :
					            	BRF204A.getR2_gcc_ksa_aed().intValue());
					       	 }	
							
					       	Cell cell1 = row.getCell(5);
					       	 if (cell1 != null) {
					            cell1.setCellValue(BRF204A.getR2_gcc_ksa_fcy() == null ? 0 :
					            	BRF204A.getR2_gcc_ksa_fcy().intValue());
					       	 }	
							
					       	Cell cell2 = row.getCell(6);
					       	 if (cell2 != null) {
					            cell2.setCellValue(BRF204A.getR2_gcc_oman_aed() == null ? 0 :
					            	BRF204A.getR2_gcc_oman_aed().intValue());
					       	 }	
							
					       	Cell cell3 = row.getCell(7);
					       	 if (cell3 != null) {
					            cell3.setCellValue(BRF204A.getR2_gcc_oman_fcy() == null ? 0 :
					            	BRF204A.getR2_gcc_oman_fcy().intValue());
					       	 }	
							
					       	Cell cell4 = row.getCell(8);
					       	 if (cell4 != null) {
					            cell4.setCellValue(BRF204A.getR2_gcc_kuwait_aed() == null ? 0 :
					            	BRF204A.getR2_gcc_kuwait_aed().intValue());
					       	 }	
							
					       	Cell cell5 = row.getCell(9);
					       	 if (cell5 != null) {
					            cell5.setCellValue(BRF204A.getR2_gcc_kuwait_fcy() == null ? 0 :
					            	BRF204A.getR2_gcc_kuwait_fcy().intValue());
					       	 }	
							
					       	Cell cell6 = row.getCell(10);
					       	 if (cell6 != null) {
					            cell6.setCellValue(BRF204A.getR2_gcc_qatar_aed() == null ? 0 :
					            	BRF204A.getR2_gcc_qatar_aed().intValue());
					       	 }	
							
					       	Cell cell7 = row.getCell(11);
					       	 if (cell7 != null) {
					            cell7.setCellValue(BRF204A.getR2_gcc_qatar_fcy() == null ? 0 :
					            	BRF204A.getR2_gcc_qatar_fcy().intValue());
					       	 }	
							
					       	Cell cell8 = row.getCell(12);
					       	 if (cell8 != null) {
					            cell8.setCellValue(BRF204A.getR2_gcc_bahrain_aed() == null ? 0 :
					            	BRF204A.getR2_gcc_bahrain_aed().intValue());
					       	 }	
							
					       	Cell cell9 = row.getCell(13);
					       	 if (cell9 != null) {
					            cell9.setCellValue(BRF204A.getR2_gcc_bahrain_fcy() == null ? 0 :
					            	BRF204A.getR2_gcc_bahrain_fcy().intValue());
					       	 }	
							
					       	Cell cell10 = row.getCell(14);
					       	 if (cell10 != null) {
					            cell10.setCellValue(BRF204A.getR2_other_aed() == null ? 0 :
					            	BRF204A.getR2_other_aed().intValue());
					       	 }	
							
					       	Cell cell11 = row.getCell(15);
					       	 if (cell11 != null) {
					            cell11.setCellValue(BRF204A.getR2_other_fcy() == null ? 0 :
					            	BRF204A.getR2_other_fcy().intValue());
					       	 }	
							
					       	 
				///////////////R4////////////////////////

					       	Row R1row = sheet.getRow(13);
					       	    
					       	 Cell R1cell = R1row.getCell(4);
					       	 if (R1cell != null) {
					       	    R1cell.setCellValue(BRF204A.getR4_gcc_ksa_aed() == null ? 0 :
					       	    	BRF204A.getR4_gcc_ksa_aed().intValue());
					       	 }	

					       	Cell R1cell1 = R1row.getCell(5);
					       	 if (R1cell1 != null) {
					       	    R1cell1.setCellValue(BRF204A.getR4_gcc_ksa_fcy() == null ? 0 :
					       	    	BRF204A.getR4_gcc_ksa_fcy().intValue());
					       	 }	

					       	Cell R1cell2 = R1row.getCell(6);
					       	 if (R1cell2 != null) {
					       	    R1cell2.setCellValue(BRF204A.getR4_gcc_oman_aed() == null ? 0 :
					       	    	BRF204A.getR4_gcc_oman_aed().intValue());
					       	 }	

					       	Cell R1cell3 = R1row.getCell(7);
					       	 if (R1cell3 != null) {
					       	    R1cell3.setCellValue(BRF204A.getR4_gcc_oman_fcy() == null ? 0 :
					       	    	BRF204A.getR4_gcc_oman_fcy().intValue());
					       	 }	

					       	Cell R1cell4 = R1row.getCell(8);
					       	 if (R1cell4 != null) {
					       	    R1cell4.setCellValue(BRF204A.getR4_gcc_kuwait_aed() == null ? 0 :
					       	    	BRF204A.getR4_gcc_kuwait_aed().intValue());
					       	 }	

					       	Cell R1cell5 = R1row.getCell(9);
					       	 if (R1cell5 != null) {
					       	    R1cell5.setCellValue(BRF204A.getR4_gcc_kuwait_fcy() == null ? 0 :
					       	    	BRF204A.getR4_gcc_kuwait_fcy().intValue());
					       	 }	

					       	Cell R1cell6 = R1row.getCell(10);
					       	 if (R1cell6 != null) {
					       	    R1cell6.setCellValue(BRF204A.getR4_gcc_qatar_aed() == null ? 0 :
					       	    	BRF204A.getR4_gcc_qatar_aed().intValue());
					       	 }	

					       	Cell R1cell7 = R1row.getCell(11);
					       	 if (R1cell7 != null) {
					       	    R1cell7.setCellValue(BRF204A.getR4_gcc_qatar_fcy() == null ? 0 :
					       	    	BRF204A.getR4_gcc_qatar_fcy().intValue());
					       	 }	

					       	Cell R1cell8 = R1row.getCell(12);
					       	 if (R1cell8 != null) {
					       	    R1cell8.setCellValue(BRF204A.getR4_gcc_bahrain_aed() == null ? 0 :
					       	    	BRF204A.getR4_gcc_bahrain_aed().intValue());
					       	 }	

					       	Cell R1cell9 = R1row.getCell(13);
					       	 if (R1cell9 != null) {
					       	    R1cell9.setCellValue(BRF204A.getR4_gcc_bahrain_fcy() == null ? 0 :
					       	    	BRF204A.getR4_gcc_bahrain_fcy().intValue());
					       	 }	

					       	Cell R1cell10 = R1row.getCell(14);
					       	 if (R1cell10 != null) {
					       	    R1cell10.setCellValue(BRF204A.getR4_other_aed() == null ? 0 :
					       	    	BRF204A.getR4_other_aed().intValue());
					       	 }	

					       	Cell R1cell11 = R1row.getCell(15);
					       	 if (R1cell11 != null) {
					       	    R1cell11.setCellValue(BRF204A.getR4_other_fcy() == null ? 0 :
					       	    	BRF204A.getR4_other_fcy().intValue());
					       	 }	

					       	 
	                           ///////////////R5////////////////////////

						       	Row R2row = sheet.getRow(14);
						       	    
						       	 Cell R2cell = R2row.getCell(4);
						       	 if (R2cell != null) {
						       	    R2cell.setCellValue(BRF204A.getR5_gcc_ksa_aed() == null ? 0 :
						       	    	BRF204A.getR5_gcc_ksa_aed().intValue());
						       	 }	

						       	Cell R2cell1 = R2row.getCell(5);
						       	 if (R2cell1 != null) {
						       	    R2cell1.setCellValue(BRF204A.getR5_gcc_ksa_fcy() == null ? 0 :
						       	    	BRF204A.getR5_gcc_ksa_fcy().intValue());
						       	 }	

						       	Cell R2cell2 = R2row.getCell(6);
						       	 if (R2cell2 != null) {
						       	    R2cell2.setCellValue(BRF204A.getR5_gcc_oman_aed() == null ? 0 :
						       	    	BRF204A.getR5_gcc_oman_aed().intValue());
						       	 }	

						       	Cell R2cell3 = R2row.getCell(7);
						       	 if (R2cell3 != null) {
						       	    R2cell3.setCellValue(BRF204A.getR5_gcc_oman_fcy() == null ? 0 :
						       	    	BRF204A.getR5_gcc_oman_fcy().intValue());
						       	 }	

						       	Cell R2cell4 = R2row.getCell(8);
						       	 if (R2cell4 != null) {
						       	    R2cell4.setCellValue(BRF204A.getR5_gcc_kuwait_aed() == null ? 0 :
						       	    	BRF204A.getR5_gcc_kuwait_aed().intValue());
						       	 }	

						       	Cell R2cell5 = R2row.getCell(9);
						       	 if (R2cell5 != null) {
						       	    R2cell5.setCellValue(BRF204A.getR5_gcc_kuwait_fcy() == null ? 0 :
						       	    	BRF204A.getR5_gcc_kuwait_fcy().intValue());
						       	 }	

						       	Cell R2cell6 = R2row.getCell(10);
						       	 if (R2cell6 != null) {
						       	    R2cell6.setCellValue(BRF204A.getR5_gcc_qatar_aed() == null ? 0 :
						       	    	BRF204A.getR5_gcc_qatar_aed().intValue());
						       	 }	

						       	Cell R2cell7 = R2row.getCell(11);
						       	 if (R2cell7 != null) {
						       	    R2cell7.setCellValue(BRF204A.getR5_gcc_qatar_fcy() == null ? 0 :
						       	    	BRF204A.getR5_gcc_qatar_fcy().intValue());
						       	 }	

						       	Cell R2cell8 = R2row.getCell(12);
						       	 if (R2cell8 != null) {
						       	    R2cell8.setCellValue(BRF204A.getR5_gcc_bahrain_aed() == null ? 0 :
						       	    	BRF204A.getR5_gcc_bahrain_aed().intValue());
						       	 }	

						       	Cell R2cell9 = R2row.getCell(13);
						       	 if (R2cell9 != null) {
						       	    R2cell9.setCellValue(BRF204A.getR5_gcc_bahrain_fcy() == null ? 0 :
						       	    	BRF204A.getR5_gcc_bahrain_fcy().intValue());
						       	 }	

						       	Cell R2cell10 = R2row.getCell(14);
						       	 if (R2cell10 != null) {
						       	    R2cell10.setCellValue(BRF204A.getR5_other_aed() == null ? 0 :
						       	    	BRF204A.getR5_other_aed().intValue());
						       	 }	

						       	Cell R2cell11 = R2row.getCell(15);
						       	 if (R2cell11 != null) {
						       	    R2cell11.setCellValue(BRF204A.getR5_other_fcy() == null ? 0 :
						       	    	BRF204A.getR5_other_fcy().intValue());
						       	 }	

		                           ///////////////R7////////////////////////

							       	Row R3row = sheet.getRow(16);
							       	    
							       	 Cell R3cell = R3row.getCell(4);
							       	 if (R3cell != null) {
							       	    R3cell.setCellValue(BRF204A.getR7_gcc_ksa_aed() == null ? 0 :
							       	    	BRF204A.getR7_gcc_ksa_aed().intValue());
							       	 }	

							       	Cell R3cell1 = R3row.getCell(5);
							       	 if (R3cell1 != null) {
							       	    R3cell1.setCellValue(BRF204A.getR7_gcc_ksa_fcy() == null ? 0 :
							       	    	BRF204A.getR7_gcc_ksa_fcy().intValue());
							       	 }	

							       	Cell R3cell2 = R3row.getCell(6);
							       	 if (R3cell2 != null) {
							       	    R3cell2.setCellValue(BRF204A.getR7_gcc_oman_aed() == null ? 0 :
							       	    	BRF204A.getR7_gcc_oman_aed().intValue());
							       	 }	

							       	Cell R3cell3 = R3row.getCell(7);
							       	 if (R3cell3 != null) {
							       	    R3cell3.setCellValue(BRF204A.getR7_gcc_oman_fcy() == null ? 0 :
							       	    	BRF204A.getR7_gcc_oman_fcy().intValue());
							       	 }	

							       	Cell R3cell4 = R3row.getCell(8);
							       	 if (R3cell4 != null) {
							       	    R3cell4.setCellValue(BRF204A.getR7_gcc_kuwait_aed() == null ? 0 :
							       	    	BRF204A.getR7_gcc_kuwait_aed().intValue());
							       	 }	

							       	Cell R3cell5 = R3row.getCell(9);
							       	 if (R3cell5 != null) {
							       	    R3cell5.setCellValue(BRF204A.getR7_gcc_kuwait_fcy() == null ? 0 :
							       	    	BRF204A.getR7_gcc_kuwait_fcy().intValue());
							       	 }	

							       	Cell R3cell6 = R3row.getCell(10);
							       	 if (R3cell6 != null) {
							       	    R3cell6.setCellValue(BRF204A.getR7_gcc_qatar_aed() == null ? 0 :
							       	    	BRF204A.getR7_gcc_qatar_aed().intValue());
							       	 }	

							       	Cell R3cell7 = R3row.getCell(11);
							       	 if (R3cell7 != null) {
							       	    R3cell7.setCellValue(BRF204A.getR7_gcc_qatar_fcy() == null ? 0 :
							       	    	BRF204A.getR7_gcc_qatar_fcy().intValue());
							       	 }	

							       	Cell R3cell8 = R3row.getCell(12);
							       	 if (R3cell8 != null) {
							       	    R3cell8.setCellValue(BRF204A.getR7_gcc_bahrain_aed() == null ? 0 :
							       	    	BRF204A.getR7_gcc_bahrain_aed().intValue());
							       	 }	

							       	Cell R3cell9 = R3row.getCell(13);
							       	 if (R3cell9 != null) {
							       	    R3cell9.setCellValue(BRF204A.getR7_gcc_bahrain_fcy() == null ? 0 :
							       	    	BRF204A.getR7_gcc_bahrain_fcy().intValue());
							       	 }	

							       	Cell R3cell10 = R3row.getCell(14);
							       	 if (R3cell10 != null) {
							       	    R3cell10.setCellValue(BRF204A.getR7_other_aed() == null ? 0 :
							       	    	BRF204A.getR7_other_aed().intValue());
							       	 }	

							       	Cell R3cell11 = R3row.getCell(15);
							       	 if (R3cell11 != null) {
							       	    R3cell11.setCellValue(BRF204A.getR7_other_fcy() == null ? 0 :
							       	    	BRF204A.getR7_other_fcy().intValue());
							       	 }	

			                           ///////////////R8////////////////////////

								       	Row R4row = sheet.getRow(17);
								       	    
								       	 Cell R4cell = R4row.getCell(4);
								       	 if (R4cell != null) {
								       	    R4cell.setCellValue(BRF204A.getR8_gcc_ksa_aed() == null ? 0 :
								       	    	BRF204A.getR8_gcc_ksa_aed().intValue());
								       	 }	

								       	Cell R4cell1 = R4row.getCell(5);
								       	 if (R4cell1 != null) {
								       	    R4cell1.setCellValue(BRF204A.getR8_gcc_ksa_fcy() == null ? 0 :
								       	    	BRF204A.getR8_gcc_ksa_fcy().intValue());
								       	 }	

								       	Cell R4cell2 = R4row.getCell(6);
								       	 if (R4cell2 != null) {
								       	    R4cell2.setCellValue(BRF204A.getR8_gcc_oman_aed() == null ? 0 :
								       	    	BRF204A.getR8_gcc_oman_aed().intValue());
								       	 }	

								       	Cell R4cell3 = R4row.getCell(7);
								       	 if (R4cell3 != null) {
								       	    R4cell3.setCellValue(BRF204A.getR8_gcc_oman_fcy() == null ? 0 :
								       	    	BRF204A.getR8_gcc_oman_fcy().intValue());
								       	 }	

								       	Cell R4cell4 = R4row.getCell(8);
								       	 if (R4cell4 != null) {
								       	    R4cell4.setCellValue(BRF204A.getR8_gcc_kuwait_aed() == null ? 0 :
								       	    	BRF204A.getR8_gcc_kuwait_aed().intValue());
								       	 }	

								       	Cell R4cell5 = R4row.getCell(9);
								       	 if (R4cell5 != null) {
								       	    R4cell5.setCellValue(BRF204A.getR8_gcc_kuwait_fcy() == null ? 0 :
								       	    	BRF204A.getR8_gcc_kuwait_fcy().intValue());
								       	 }	

								       	Cell R4cell6 = R4row.getCell(10);
								       	 if (R4cell6 != null) {
								       	    R4cell6.setCellValue(BRF204A.getR8_gcc_qatar_aed() == null ? 0 :
								       	    	BRF204A.getR8_gcc_qatar_aed().intValue());
								       	 }	

								       	Cell R4cell7 = R4row.getCell(11);
								       	 if (R4cell7 != null) {
								       	    R4cell7.setCellValue(BRF204A.getR8_gcc_qatar_fcy() == null ? 0 :
								       	    	BRF204A.getR8_gcc_qatar_fcy().intValue());
								       	 }	

								       	Cell R4cell8 = R4row.getCell(12);
								       	 if (R4cell8 != null) {
								       	    R4cell8.setCellValue(BRF204A.getR8_gcc_bahrain_aed() == null ? 0 :
								       	    	BRF204A.getR8_gcc_bahrain_aed().intValue());
								       	 }	

								       	Cell R4cell9 = R4row.getCell(13);
								       	 if (R4cell9 != null) {
								       	    R4cell9.setCellValue(BRF204A.getR8_gcc_bahrain_fcy() == null ? 0 :
								       	    	BRF204A.getR8_gcc_bahrain_fcy().intValue());
								       	 }	

								       	Cell R4cell10 = R4row.getCell(14);
								       	 if (R4cell10 != null) {
								       	    R4cell10.setCellValue(BRF204A.getR8_other_aed() == null ? 0 :
								       	    	BRF204A.getR8_other_aed().intValue());
								       	 }	

								       	Cell R4cell11 = R4row.getCell(15);
								       	 if (R4cell11 != null) {
								       	    R4cell11.setCellValue(BRF204A.getR8_other_fcy() == null ? 0 :
								       	    	BRF204A.getR8_other_fcy().intValue());
								       	 }	

				                           ///////////////R9////////////////////////

									       	Row R5row = sheet.getRow(18);
									       	    
									       	 Cell R5cell = R5row.getCell(4);
									       	 if (R5cell != null) {
									       	    R5cell.setCellValue(BRF204A.getR9_gcc_ksa_aed() == null ? 0 :
									       	    	BRF204A.getR9_gcc_ksa_aed().intValue());
									       	 }	

									       	Cell R5cell1 = R5row.getCell(5);
									       	 if (R5cell1 != null) {
									       	    R5cell1.setCellValue(BRF204A.getR9_gcc_ksa_fcy() == null ? 0 :
									       	    	BRF204A.getR9_gcc_ksa_fcy().intValue());
									       	 }	

									       	Cell R5cell2 = R5row.getCell(6);
									       	 if (R5cell2 != null) {
									       	    R5cell2.setCellValue(BRF204A.getR9_gcc_oman_aed() == null ? 0 :
									       	    	BRF204A.getR9_gcc_oman_aed().intValue());
									       	 }	

									       	Cell R5cell3 = R5row.getCell(7);
									       	 if (R5cell3 != null) {
									       	    R5cell3.setCellValue(BRF204A.getR9_gcc_oman_fcy() == null ? 0 :
									       	    	BRF204A.getR9_gcc_oman_fcy().intValue());
									       	 }	

									       	Cell R5cell4 = R5row.getCell(8);
									       	 if (R5cell4 != null) {
									       	    R5cell4.setCellValue(BRF204A.getR9_gcc_kuwait_aed() == null ? 0 :
									       	    	BRF204A.getR9_gcc_kuwait_aed().intValue());
									       	 }	

									       	Cell R5cell5 = R5row.getCell(9);
									       	 if (R5cell5 != null) {
									       	    R5cell5.setCellValue(BRF204A.getR9_gcc_kuwait_fcy() == null ? 0 :
									       	    	BRF204A.getR9_gcc_kuwait_fcy().intValue());
									       	 }	

									       	Cell R5cell6 = R5row.getCell(10);
									       	 if (R5cell6 != null) {
									       	    R5cell6.setCellValue(BRF204A.getR9_gcc_qatar_aed() == null ? 0 :
									       	    	BRF204A.getR9_gcc_qatar_aed().intValue());
									       	 }	

									       	Cell R5cell7 = R5row.getCell(11);
									       	 if (R5cell7 != null) {
									       	    R5cell7.setCellValue(BRF204A.getR9_gcc_qatar_fcy() == null ? 0 :
									       	    	BRF204A.getR9_gcc_qatar_fcy().intValue());
									       	 }	

									       	Cell R5cell8 = R5row.getCell(12);
									       	 if (R5cell8 != null) {
									       	    R5cell8.setCellValue(BRF204A.getR9_gcc_bahrain_aed() == null ? 0 :
									       	    	BRF204A.getR9_gcc_bahrain_aed().intValue());
									       	 }	

									       	Cell R5cell9 = R5row.getCell(13);
									       	 if (R5cell9 != null) {
									       	    R5cell9.setCellValue(BRF204A.getR9_gcc_bahrain_fcy() == null ? 0 :
									       	    	BRF204A.getR9_gcc_bahrain_fcy().intValue());
									       	 }	

									       	Cell R5cell10 = R5row.getCell(14);
									       	 if (R5cell10 != null) {
									       	    R5cell10.setCellValue(BRF204A.getR9_other_aed() == null ? 0 :
									       	    	BRF204A.getR9_other_aed().intValue());
									       	 }	

									       	Cell R5cell11 = R5row.getCell(15);
									       	 if (R5cell11 != null) {
									       	    R5cell11.setCellValue(BRF204A.getR9_other_fcy() == null ? 0 :
									       	    	BRF204A.getR9_other_fcy().intValue());
									       	 }	

									       	 
					                           ///////////////R11////////////////////////

										       	Row R6row = sheet.getRow(20);
										       	    
										       	 Cell R6cell = R6row.getCell(4);
										       	 if (R6cell != null) {
										       	    R6cell.setCellValue(BRF204A.getR11_gcc_ksa_aed() == null ? 0 :
										       	    	BRF204A.getR11_gcc_ksa_aed().intValue());
										       	 }	

										       	Cell R6cell1 = R6row.getCell(5);
										       	 if (R6cell1 != null) {
										       	    R6cell1.setCellValue(BRF204A.getR11_gcc_ksa_fcy() == null ? 0 :
										       	    	BRF204A.getR11_gcc_ksa_fcy().intValue());
										       	 }	

										       	Cell R6cell2 = R6row.getCell(6);
										       	 if (R6cell2 != null) {
										       	    R6cell2.setCellValue(BRF204A.getR11_gcc_oman_aed() == null ? 0 :
										       	    	BRF204A.getR11_gcc_oman_aed().intValue());
										       	 }	

										       	Cell R6cell3 = R6row.getCell(7);
										       	 if (R6cell3 != null) {
										       	    R6cell3.setCellValue(BRF204A.getR11_gcc_oman_fcy() == null ? 0 :
										       	    	BRF204A.getR11_gcc_oman_fcy().intValue());
										       	 }	

										       	Cell R6cell4 = R6row.getCell(8);
										       	 if (R6cell4 != null) {
										       	    R6cell4.setCellValue(BRF204A.getR11_gcc_kuwait_aed() == null ? 0 :
										       	    	BRF204A.getR11_gcc_kuwait_aed().intValue());
										       	 }	

										       	Cell R6cell5 = R6row.getCell(9);
										       	 if (R6cell5 != null) {
										       	    R6cell5.setCellValue(BRF204A.getR11_gcc_kuwait_fcy() == null ? 0 :
										       	    	BRF204A.getR11_gcc_kuwait_fcy().intValue());
										       	 }	

										       	Cell R6cell6 = R6row.getCell(10);
										       	 if (R6cell6 != null) {
										       	    R6cell6.setCellValue(BRF204A.getR11_gcc_qatar_aed() == null ? 0 :
										       	    	BRF204A.getR11_gcc_qatar_aed().intValue());
										       	 }	

										       	Cell R6cell7 = R6row.getCell(11);
										       	 if (R6cell7 != null) {
										       	    R6cell7.setCellValue(BRF204A.getR11_gcc_qatar_fcy() == null ? 0 :
										       	    	BRF204A.getR11_gcc_qatar_fcy().intValue());
										       	 }	

										       	Cell R6cell8 = R6row.getCell(12);
										       	 if (R6cell8 != null) {
										       	    R6cell8.setCellValue(BRF204A.getR11_gcc_bahrain_aed() == null ? 0 :
										       	    	BRF204A.getR11_gcc_bahrain_aed().intValue());
										       	 }	

										       	Cell R6cell9 = R6row.getCell(13);
										       	 if (R6cell9 != null) {
										       	    R6cell9.setCellValue(BRF204A.getR11_gcc_bahrain_fcy() == null ? 0 :
										       	    	BRF204A.getR11_gcc_bahrain_fcy().intValue());
										       	 }	

										       	Cell R6cell10 = R6row.getCell(14);
										       	 if (R6cell10 != null) {
										       	    R6cell10.setCellValue(BRF204A.getR11_other_aed() == null ? 0 :
										       	    	BRF204A.getR11_other_aed().intValue());
										       	 }	

										       	Cell R6cell11 = R6row.getCell(15);
										       	 if (R6cell11 != null) {
										       	    R6cell11.setCellValue(BRF204A.getR11_other_fcy() == null ? 0 :
										       	    	BRF204A.getR11_other_fcy().intValue());
										       	 }	

						                           ///////////////R12////////////////////////

											       	Row R7row = sheet.getRow(21);
											       	    
											       	 Cell R7cell = R7row.getCell(4);
											       	 if (R7cell != null) {
											       	    R7cell.setCellValue(BRF204A.getR12_gcc_ksa_aed() == null ? 0 :
											       	    	BRF204A.getR12_gcc_ksa_aed().intValue());
											       	 }	

											       	Cell R7cell1 = R7row.getCell(5);
											       	 if (R7cell1 != null) {
											       	    R7cell1.setCellValue(BRF204A.getR12_gcc_ksa_fcy() == null ? 0 :
											       	    	BRF204A.getR12_gcc_ksa_fcy().intValue());
											       	 }	

											       	Cell R7cell2 = R7row.getCell(6);
											       	 if (R7cell2 != null) {
											       	    R7cell2.setCellValue(BRF204A.getR12_gcc_oman_aed() == null ? 0 :
											       	    	BRF204A.getR12_gcc_oman_aed().intValue());
											       	 }	

											       	Cell R7cell3 = R7row.getCell(7);
											       	 if (R7cell3 != null) {
											       	    R7cell3.setCellValue(BRF204A.getR12_gcc_oman_fcy() == null ? 0 :
											       	    	BRF204A.getR12_gcc_oman_fcy().intValue());
											       	 }	

											       	Cell R7cell4 = R7row.getCell(8);
											       	 if (R7cell4 != null) {
											       	    R7cell4.setCellValue(BRF204A.getR12_gcc_kuwait_aed() == null ? 0 :
											       	    	BRF204A.getR12_gcc_kuwait_aed().intValue());
											       	 }	

											       	Cell R7cell5 = R7row.getCell(9);
											       	 if (R7cell5 != null) {
											       	    R7cell5.setCellValue(BRF204A.getR12_gcc_kuwait_fcy() == null ? 0 :
											       	    	BRF204A.getR12_gcc_kuwait_fcy().intValue());
											       	 }	

											       	Cell R7cell6 = R7row.getCell(10);
											       	 if (R7cell6 != null) {
											       	    R7cell6.setCellValue(BRF204A.getR12_gcc_qatar_aed() == null ? 0 :
											       	    	BRF204A.getR12_gcc_qatar_aed().intValue());
											       	 }	

											       	Cell R7cell7 = R7row.getCell(11);
											       	 if (R7cell7 != null) {
											       	    R7cell7.setCellValue(BRF204A.getR12_gcc_qatar_fcy() == null ? 0 :
											       	    	BRF204A.getR12_gcc_qatar_fcy().intValue());
											       	 }	

											       	Cell R7cell8 = R7row.getCell(12);
											       	 if (R7cell8 != null) {
											       	    R7cell8.setCellValue(BRF204A.getR12_gcc_bahrain_aed() == null ? 0 :
											       	    	BRF204A.getR12_gcc_bahrain_aed().intValue());
											       	 }	

											       	Cell R7cell9 = R7row.getCell(13);
											       	 if (R7cell9 != null) {
											       	    R7cell9.setCellValue(BRF204A.getR12_gcc_bahrain_fcy() == null ? 0 :
											       	    	BRF204A.getR12_gcc_bahrain_fcy().intValue());
											       	 }	

											       	Cell R7cell10 = R7row.getCell(14);
											       	 if (R7cell10 != null) {
											       	    R7cell10.setCellValue(BRF204A.getR12_other_aed() == null ? 0 :
											       	    	BRF204A.getR12_other_aed().intValue());
											       	 }	

											       	Cell R7cell11 = R7row.getCell(15);
											       	 if (R7cell11 != null) {
											       	    R7cell11.setCellValue(BRF204A.getR12_other_fcy() == null ? 0 :
											       	    	BRF204A.getR12_other_fcy().intValue());
											       	 }	

							                           ///////////////R13////////////////////////

												       	Row R8row = sheet.getRow(22);
												       	    
												       	 Cell R8cell = R8row.getCell(4);
												       	 if (R8cell != null) {
												       	    R8cell.setCellValue(BRF204A.getR13_gcc_ksa_aed() == null ? 0 :
												       	    	BRF204A.getR13_gcc_ksa_aed().intValue());
												       	 }	

												       	Cell R8cell1 = R8row.getCell(5);
												       	 if (R8cell1 != null) {
												       	    R8cell1.setCellValue(BRF204A.getR13_gcc_ksa_fcy() == null ? 0 :
												       	    	BRF204A.getR13_gcc_ksa_fcy().intValue());
												       	 }	

												       	Cell R8cell2 = R8row.getCell(6);
												       	 if (R8cell2 != null) {
												       	    R8cell2.setCellValue(BRF204A.getR13_gcc_oman_aed() == null ? 0 :
												       	    	BRF204A.getR13_gcc_oman_aed().intValue());
												       	 }	

												       	Cell R8cell3 = R8row.getCell(7);
												       	 if (R8cell3 != null) {
												       	    R8cell3.setCellValue(BRF204A.getR13_gcc_oman_fcy() == null ? 0 :
												       	    	BRF204A.getR13_gcc_oman_fcy().intValue());
												       	 }	

												       	Cell R8cell4 = R8row.getCell(8);
												       	 if (R8cell4 != null) {
												       	    R8cell4.setCellValue(BRF204A.getR13_gcc_kuwait_aed() == null ? 0 :
												       	    	BRF204A.getR13_gcc_kuwait_aed().intValue());
												       	 }	

												       	Cell R8cell5 = R8row.getCell(9);
												       	 if (R8cell5 != null) {
												       	    R8cell5.setCellValue(BRF204A.getR13_gcc_kuwait_fcy() == null ? 0 :
												       	    	BRF204A.getR13_gcc_kuwait_fcy().intValue());
												       	 }	

												       	Cell R8cell6 = R8row.getCell(10);
												       	 if (R8cell6 != null) {
												       	    R8cell6.setCellValue(BRF204A.getR13_gcc_qatar_aed() == null ? 0 :
												       	    	BRF204A.getR13_gcc_qatar_aed().intValue());
												       	 }	

												       	Cell R8cell7 = R8row.getCell(11);
												       	 if (R8cell7 != null) {
												       	    R8cell7.setCellValue(BRF204A.getR13_gcc_qatar_fcy() == null ? 0 :
												       	    	BRF204A.getR13_gcc_qatar_fcy().intValue());
												       	 }	

												       	Cell R8cell8 = R8row.getCell(12);
												       	 if (R8cell8 != null) {
												       	    R8cell8.setCellValue(BRF204A.getR13_gcc_bahrain_aed() == null ? 0 :
												       	    	BRF204A.getR13_gcc_bahrain_aed().intValue());
												       	 }	

												       	Cell R8cell9 = R8row.getCell(13);
												       	 if (R8cell9 != null) {
												       	    R8cell9.setCellValue(BRF204A.getR13_gcc_bahrain_fcy() == null ? 0 :
												       	    	BRF204A.getR13_gcc_bahrain_fcy().intValue());
												       	 }	

												       	Cell R8cell10 = R8row.getCell(14);
												       	 if (R8cell10 != null) {
												       	    R8cell10.setCellValue(BRF204A.getR13_other_aed() == null ? 0 :
												       	    	BRF204A.getR13_other_aed().intValue());
												       	 }	

												       	Cell R8cell11 = R8row.getCell(15);
												       	 if (R8cell11 != null) {
												       	    R8cell11.setCellValue(BRF204A.getR13_other_fcy() == null ? 0 :
												       	    	BRF204A.getR13_other_fcy().intValue());
												       	 }	

								                           ///////////////R14////////////////////////

													       	Row R9row = sheet.getRow(23);
													       	    
													       	 Cell R9cell = R9row.getCell(4);
													       	 if (R9cell != null) {
													       	    R9cell.setCellValue(BRF204A.getR14_gcc_ksa_aed() == null ? 0 :
													       	    	BRF204A.getR14_gcc_ksa_aed().intValue());
													       	 }	

													       	Cell R9cell1 = R9row.getCell(5);
													       	 if (R9cell1 != null) {
													       	    R9cell1.setCellValue(BRF204A.getR14_gcc_ksa_fcy() == null ? 0 :
													       	    	BRF204A.getR14_gcc_ksa_fcy().intValue());
													       	 }	

													       	Cell R9cell2 = R9row.getCell(6);
													       	 if (R9cell2 != null) {
													       	    R9cell2.setCellValue(BRF204A.getR14_gcc_oman_aed() == null ? 0 :
													       	    	BRF204A.getR14_gcc_oman_aed().intValue());
													       	 }	

													       	Cell R9cell3 = R9row.getCell(7);
													       	 if (R9cell3 != null) {
													       	    R9cell3.setCellValue(BRF204A.getR14_gcc_oman_fcy() == null ? 0 :
													       	    	BRF204A.getR14_gcc_oman_fcy().intValue());
													       	 }	

													       	Cell R9cell4 = R9row.getCell(8);
													       	 if (R9cell4 != null) {
													       	    R9cell4.setCellValue(BRF204A.getR14_gcc_kuwait_aed() == null ? 0 :
													       	    	BRF204A.getR14_gcc_kuwait_aed().intValue());
													       	 }	

													       	Cell R9cell5 = R9row.getCell(9);
													       	 if (R9cell5 != null) {
													       	    R9cell5.setCellValue(BRF204A.getR14_gcc_kuwait_fcy() == null ? 0 :
													       	    	BRF204A.getR14_gcc_kuwait_fcy().intValue());
													       	 }	

													       	Cell R9cell6 = R9row.getCell(10);
													       	 if (R9cell6 != null) {
													       	    R9cell6.setCellValue(BRF204A.getR14_gcc_qatar_aed() == null ? 0 :
													       	    	BRF204A.getR14_gcc_qatar_aed().intValue());
													       	 }	

													       	Cell R9cell7 = R9row.getCell(11);
													       	 if (R9cell7 != null) {
													       	    R9cell7.setCellValue(BRF204A.getR14_gcc_qatar_fcy() == null ? 0 :
													       	    	BRF204A.getR14_gcc_qatar_fcy().intValue());
													       	 }	

													       	Cell R9cell8 = R9row.getCell(12);
													       	 if (R9cell8 != null) {
													       	    R9cell8.setCellValue(BRF204A.getR14_gcc_bahrain_aed() == null ? 0 :
													       	    	BRF204A.getR14_gcc_bahrain_aed().intValue());
													       	 }	

													       	Cell R9cell9 = R9row.getCell(13);
													       	 if (R9cell9 != null) {
													       	    R9cell9.setCellValue(BRF204A.getR14_gcc_bahrain_fcy() == null ? 0 :
													       	    	BRF204A.getR14_gcc_bahrain_fcy().intValue());
													       	 }	

													       	Cell R9cell10 = R9row.getCell(14);
													       	 if (R9cell10 != null) {
													       	    R9cell10.setCellValue(BRF204A.getR14_other_aed() == null ? 0 :
													       	    	BRF204A.getR14_other_aed().intValue());
													       	 }	

													       	Cell R9cell11 = R9row.getCell(15);
													       	 if (R9cell11 != null) {
													       	    R9cell11.setCellValue(BRF204A.getR14_other_fcy() == null ? 0 :
													       	    	BRF204A.getR14_other_fcy().intValue());
													       	 }	

									                           ///////////////R15////////////////////////

														       	Row R10row = sheet.getRow(24);
														       	    
														       	 Cell R10cell = R10row.getCell(4);
														       	 if (R10cell != null) {
														       	    R10cell.setCellValue(BRF204A.getR15_gcc_ksa_aed() == null ? 0 :
														       	    	BRF204A.getR15_gcc_ksa_aed().intValue());
														       	 }	

														       	Cell R10cell1 = R10row.getCell(5);
														       	 if (R10cell1 != null) {
														       	    R10cell1.setCellValue(BRF204A.getR15_gcc_ksa_fcy() == null ? 0 :
														       	    	BRF204A.getR15_gcc_ksa_fcy().intValue());
														       	 }	

														       	Cell R10cell2 = R10row.getCell(6);
														       	 if (R10cell2 != null) {
														       	    R10cell2.setCellValue(BRF204A.getR15_gcc_oman_aed() == null ? 0 :
														       	    	BRF204A.getR15_gcc_oman_aed().intValue());
														       	 }	

														       	Cell R10cell3 = R10row.getCell(7);
														       	 if (R10cell3 != null) {
														       	    R10cell3.setCellValue(BRF204A.getR15_gcc_oman_fcy() == null ? 0 :
														       	    	BRF204A.getR15_gcc_oman_fcy().intValue());
														       	 }	

														       	Cell R10cell4 = R10row.getCell(8);
														       	 if (R10cell4 != null) {
														       	    R10cell4.setCellValue(BRF204A.getR15_gcc_kuwait_aed() == null ? 0 :
														       	    	BRF204A.getR15_gcc_kuwait_aed().intValue());
														       	 }	

														       	Cell R10cell5 = R10row.getCell(9);
														       	 if (R10cell5 != null) {
														       	    R10cell5.setCellValue(BRF204A.getR15_gcc_kuwait_fcy() == null ? 0 :
														       	    	BRF204A.getR15_gcc_kuwait_fcy().intValue());
														       	 }	

														       	Cell R10cell6 = R10row.getCell(10);
														       	 if (R10cell6 != null) {
														       	    R10cell6.setCellValue(BRF204A.getR15_gcc_qatar_aed() == null ? 0 :
														       	    	BRF204A.getR15_gcc_qatar_aed().intValue());
														       	 }	

														       	Cell R10cell7 = R10row.getCell(11);
														       	 if (R10cell7 != null) {
														       	    R10cell7.setCellValue(BRF204A.getR15_gcc_qatar_fcy() == null ? 0 :
														       	    	BRF204A.getR15_gcc_qatar_fcy().intValue());
														       	 }	

														       	Cell R10cell8 = R10row.getCell(12);
														       	 if (R10cell8 != null) {
														       	    R10cell8.setCellValue(BRF204A.getR15_gcc_bahrain_aed() == null ? 0 :
														       	    	BRF204A.getR15_gcc_bahrain_aed().intValue());
														       	 }	

														       	Cell R10cell9 = R10row.getCell(13);
														       	 if (R10cell9 != null) {
														       	    R10cell9.setCellValue(BRF204A.getR15_gcc_bahrain_fcy() == null ? 0 :
														       	    	BRF204A.getR15_gcc_bahrain_fcy().intValue());
														       	 }	

														       	Cell R10cell10 = R10row.getCell(14);
														       	 if (R10cell10 != null) {
														       	    R10cell10.setCellValue(BRF204A.getR15_other_aed() == null ? 0 :
														       	    	BRF204A.getR15_other_aed().intValue());
														       	 }	

														       	Cell R10cell11 = R10row.getCell(15);
														       	 if (R10cell11 != null) {
														       	    R10cell11.setCellValue(BRF204A.getR15_other_fcy() == null ? 0 :
														       	    	BRF204A.getR15_other_fcy().intValue());
														       	 }	

										                           ///////////////R16////////////////////////

															       	Row R11row = sheet.getRow(25);
															       	    
															       	 Cell R11cell = R11row.getCell(4);
															       	 if (R11cell != null) {
															       	    R11cell.setCellValue(BRF204A.getR16_gcc_ksa_aed() == null ? 0 :
															       	    	BRF204A.getR16_gcc_ksa_aed().intValue());
															       	 }	

															       	Cell R11cell1 = R11row.getCell(5);
															       	 if (R11cell1 != null) {
															       	    R11cell1.setCellValue(BRF204A.getR16_gcc_ksa_fcy() == null ? 0 :
															       	    	BRF204A.getR16_gcc_ksa_fcy().intValue());
															       	 }	

															       	Cell R11cell2 = R11row.getCell(6);
															       	 if (R11cell2 != null) {
															       	    R11cell2.setCellValue(BRF204A.getR16_gcc_oman_aed() == null ? 0 :
															       	    	BRF204A.getR16_gcc_oman_aed().intValue());
															       	 }	

															       	Cell R11cell3 = R11row.getCell(7);
															       	 if (R11cell3 != null) {
															       	    R11cell3.setCellValue(BRF204A.getR16_gcc_oman_fcy() == null ? 0 :
															       	    	BRF204A.getR16_gcc_oman_fcy().intValue());
															       	 }	

															       	Cell R11cell4 = R11row.getCell(8);
															       	 if (R11cell4 != null) {
															       	    R11cell4.setCellValue(BRF204A.getR16_gcc_kuwait_aed() == null ? 0 :
															       	    	BRF204A.getR16_gcc_kuwait_aed().intValue());
															       	 }	

															       	Cell R11cell5 = R11row.getCell(9);
															       	 if (R11cell5 != null) {
															       	    R11cell5.setCellValue(BRF204A.getR16_gcc_kuwait_fcy() == null ? 0 :
															       	    	BRF204A.getR16_gcc_kuwait_fcy().intValue());
															       	 }	

															       	Cell R11cell6 = R11row.getCell(10);
															       	 if (R11cell6 != null) {
															       	    R11cell6.setCellValue(BRF204A.getR16_gcc_qatar_aed() == null ? 0 :
															       	    	BRF204A.getR16_gcc_qatar_aed().intValue());
															       	 }	

															       	Cell R11cell7 = R11row.getCell(11);
															       	 if (R11cell7 != null) {
															       	    R11cell7.setCellValue(BRF204A.getR16_gcc_qatar_fcy() == null ? 0 :
															       	    	BRF204A.getR16_gcc_qatar_fcy().intValue());
															       	 }	

															       	Cell R11cell8 = R11row.getCell(12);
															       	 if (R11cell8 != null) {
															       	    R11cell8.setCellValue(BRF204A.getR16_gcc_bahrain_aed() == null ? 0 :
															       	    	BRF204A.getR16_gcc_bahrain_aed().intValue());
															       	 }	

															       	Cell R11cell9 = R11row.getCell(13);
															       	 if (R11cell9 != null) {
															       	    R11cell9.setCellValue(BRF204A.getR16_gcc_bahrain_fcy() == null ? 0 :
															       	    	BRF204A.getR16_gcc_bahrain_fcy().intValue());
															       	 }	

															       	Cell R11cell10 = R11row.getCell(14);
															       	 if (R11cell10 != null) {
															       	    R11cell10.setCellValue(BRF204A.getR16_other_aed() == null ? 0 :
															       	    	BRF204A.getR16_other_aed().intValue());
															       	 }	

															       	Cell R11cell11 = R11row.getCell(15);
															       	 if (R11cell11 != null) {
															       	    R11cell11.setCellValue(BRF204A.getR16_other_fcy() == null ? 0 :
															       	    	BRF204A.getR16_other_fcy().intValue());
															       	 }	

											                           ///////////////R18////////////////////////

																       	Row R12row = sheet.getRow(27);
																       	    
																       	 Cell R12cell = R12row.getCell(4);
																       	 if (R12cell != null) {
																       	    R12cell.setCellValue(BRF204A.getR18_gcc_ksa_aed() == null ? 0 :
																       	    	BRF204A.getR18_gcc_ksa_aed().intValue());
																       	 }	

																       	Cell R12cell1 = R12row.getCell(5);
																       	 if (R12cell1 != null) {
																       	    R12cell1.setCellValue(BRF204A.getR18_gcc_ksa_fcy() == null ? 0 :
																       	    	BRF204A.getR18_gcc_ksa_fcy().intValue());
																       	 }	

																       	Cell R12cell2 = R12row.getCell(6);
																       	 if (R12cell2 != null) {
																       	    R12cell2.setCellValue(BRF204A.getR18_gcc_oman_aed() == null ? 0 :
																       	    	BRF204A.getR18_gcc_oman_aed().intValue());
																       	 }	

																       	Cell R12cell3 = R12row.getCell(7);
																       	 if (R12cell3 != null) {
																       	    R12cell3.setCellValue(BRF204A.getR18_gcc_oman_fcy() == null ? 0 :
																       	    	BRF204A.getR18_gcc_oman_fcy().intValue());
																       	 }	

																       	Cell R12cell4 = R12row.getCell(8);
																       	 if (R12cell4 != null) {
																       	    R12cell4.setCellValue(BRF204A.getR18_gcc_kuwait_aed() == null ? 0 :
																       	    	BRF204A.getR18_gcc_kuwait_aed().intValue());
																       	 }	

																       	Cell R12cell5 = R12row.getCell(9);
																       	 if (R12cell5 != null) {
																       	    R12cell5.setCellValue(BRF204A.getR18_gcc_kuwait_fcy() == null ? 0 :
																       	    	BRF204A.getR18_gcc_kuwait_fcy().intValue());
																       	 }	

																       	Cell R12cell6 = R12row.getCell(10);
																       	 if (R12cell6 != null) {
																       	    R12cell6.setCellValue(BRF204A.getR18_gcc_qatar_aed() == null ? 0 :
																       	    	BRF204A.getR18_gcc_qatar_aed().intValue());
																       	 }	

																       	Cell R12cell7 = R12row.getCell(11);
																       	 if (R12cell7 != null) {
																       	    R12cell7.setCellValue(BRF204A.getR18_gcc_qatar_fcy() == null ? 0 :
																       	    	BRF204A.getR18_gcc_qatar_fcy().intValue());
																       	 }	

																       	Cell R12cell8 = R12row.getCell(12);
																       	 if (R12cell8 != null) {
																       	    R12cell8.setCellValue(BRF204A.getR18_gcc_bahrain_aed() == null ? 0 :
																       	    	BRF204A.getR18_gcc_bahrain_aed().intValue());
																       	 }	

																       	Cell R12cell9 = R12row.getCell(13);
																       	 if (R12cell9 != null) {
																       	    R12cell9.setCellValue(BRF204A.getR18_gcc_bahrain_fcy() == null ? 0 :
																       	    	BRF204A.getR18_gcc_bahrain_fcy().intValue());
																       	 }	

																       	Cell R12cell10 = R12row.getCell(14);
																       	 if (R12cell10 != null) {
																       	    R12cell10.setCellValue(BRF204A.getR18_other_aed() == null ? 0 :
																       	    	BRF204A.getR18_other_aed().intValue());
																       	 }	

																       	Cell R12cell11 = R12row.getCell(15);
																       	 if (R12cell11 != null) {
																       	    R12cell11.setCellValue(BRF204A.getR18_other_fcy() == null ? 0 :
																       	    	BRF204A.getR18_other_fcy().intValue());
																       	 }	
															                /////////////R19////////////////////////

																			Row R13row = sheet.getRow(28);
																			   
																			Cell R13cell = R13row.getCell(4);
																			if (R13cell != null) {
																			   R13cell.setCellValue(BRF204A.getR19_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR19_gcc_ksa_aed().intValue());
																			}	

																			Cell R13cell1 = R13row.getCell(5);
																			if (R13cell1 != null) {
																			   R13cell1.setCellValue(BRF204A.getR19_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR19_gcc_ksa_fcy().intValue());
																			}	

																			Cell R13cell2 = R13row.getCell(6);
																			if (R13cell2 != null) {
																			   R13cell2.setCellValue(BRF204A.getR19_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR19_gcc_oman_aed().intValue());
																			}	

																			Cell R13cell3 = R13row.getCell(7);
																			if (R13cell3 != null) {
																			   R13cell3.setCellValue(BRF204A.getR19_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR19_gcc_oman_fcy().intValue());
																			}	

																			Cell R13cell4 = R13row.getCell(8);
																			if (R13cell4 != null) {
																			   R13cell4.setCellValue(BRF204A.getR19_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR19_gcc_kuwait_aed().intValue());
																			}	

																			Cell R13cell5 = R13row.getCell(9);
																			if (R13cell5 != null) {
																			   R13cell5.setCellValue(BRF204A.getR19_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR19_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R13cell6 = R13row.getCell(10);
																			if (R13cell6 != null) {
																			   R13cell6.setCellValue(BRF204A.getR19_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR19_gcc_qatar_aed().intValue());
																			}	

																			Cell R13cell7 = R13row.getCell(11);
																			if (R13cell7 != null) {
																			   R13cell7.setCellValue(BRF204A.getR19_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR19_gcc_qatar_fcy().intValue());
																			}	

																			Cell R13cell8 = R13row.getCell(12);
																			if (R13cell8 != null) {
																			   R13cell8.setCellValue(BRF204A.getR19_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR19_gcc_bahrain_aed().intValue());
																			}	

																			Cell R13cell9 = R13row.getCell(13);
																			if (R13cell9 != null) {
																			   R13cell9.setCellValue(BRF204A.getR19_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR19_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R13cell10 = R13row.getCell(14);
																			if (R13cell10 != null) {
																			   R13cell10.setCellValue(BRF204A.getR19_other_aed() == null ? 0 :
																			   	BRF204A.getR19_other_aed().intValue());
																			}	

																			Cell R13cell11 = R13row.getCell(15);
																			if (R13cell11 != null) {
																			   R13cell11.setCellValue(BRF204A.getR19_other_fcy() == null ? 0 :
																			   	BRF204A.getR19_other_fcy().intValue());
																			}	

															                /////////////R20////////////////////////

																			Row R14row = sheet.getRow(29);
																			   
																			Cell R14cell = R14row.getCell(4);
																			if (R14cell != null) {
																			   R14cell.setCellValue(BRF204A.getR20_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR20_gcc_ksa_aed().intValue());
																			}	

																			Cell R14cell1 = R14row.getCell(5);
																			if (R14cell1 != null) {
																			   R14cell1.setCellValue(BRF204A.getR20_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR20_gcc_ksa_fcy().intValue());
																			}	

																			Cell R14cell2 = R14row.getCell(6);
																			if (R14cell2 != null) {
																			   R14cell2.setCellValue(BRF204A.getR20_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR20_gcc_oman_aed().intValue());
																			}	

																			Cell R14cell3 = R14row.getCell(7);
																			if (R14cell3 != null) {
																			   R14cell3.setCellValue(BRF204A.getR20_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR20_gcc_oman_fcy().intValue());
																			}	

																			Cell R14cell4 = R14row.getCell(8);
																			if (R14cell4 != null) {
																			   R14cell4.setCellValue(BRF204A.getR20_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR20_gcc_kuwait_aed().intValue());
																			}	

																			Cell R14cell5 = R14row.getCell(9);
																			if (R14cell5 != null) {
																			   R14cell5.setCellValue(BRF204A.getR20_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR20_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R14cell6 = R14row.getCell(10);
																			if (R14cell6 != null) {
																			   R14cell6.setCellValue(BRF204A.getR20_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR20_gcc_qatar_aed().intValue());
																			}	

																			Cell R14cell7 = R14row.getCell(11);
																			if (R14cell7 != null) {
																			   R14cell7.setCellValue(BRF204A.getR20_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR20_gcc_qatar_fcy().intValue());
																			}	

																			Cell R14cell8 = R14row.getCell(12);
																			if (R14cell8 != null) {
																			   R14cell8.setCellValue(BRF204A.getR20_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR20_gcc_bahrain_aed().intValue());
																			}	

																			Cell R14cell9 = R14row.getCell(13);
																			if (R14cell9 != null) {
																			   R14cell9.setCellValue(BRF204A.getR20_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR20_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R14cell10 = R14row.getCell(14);
																			if (R14cell10 != null) {
																			   R14cell10.setCellValue(BRF204A.getR20_other_aed() == null ? 0 :
																			   	BRF204A.getR20_other_aed().intValue());
																			}	

																			Cell R14cell11 = R14row.getCell(15);
																			if (R14cell11 != null) {
																			   R14cell11.setCellValue(BRF204A.getR20_other_fcy() == null ? 0 :
																			   	BRF204A.getR20_other_fcy().intValue());
																			}	

																		    /////////////R23////////////////////////

																			Row R15row = sheet.getRow(32);
																			   
																			Cell R15cell = R15row.getCell(4);
																			if (R15cell != null) {
																			   R15cell.setCellValue(BRF204A.getR23_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR23_gcc_ksa_aed().intValue());
																			}	

																			Cell R15cell1 = R15row.getCell(5);
																			if (R15cell1 != null) {
																			   R15cell1.setCellValue(BRF204A.getR23_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR23_gcc_ksa_fcy().intValue());
																			}	

																			Cell R15cell2 = R15row.getCell(6);
																			if (R15cell2 != null) {
																			   R15cell2.setCellValue(BRF204A.getR23_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR23_gcc_oman_aed().intValue());
																			}	

																			Cell R15cell3 = R15row.getCell(7);
																			if (R15cell3 != null) {
																			   R15cell3.setCellValue(BRF204A.getR23_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR23_gcc_oman_fcy().intValue());
																			}	

																			Cell R15cell4 = R15row.getCell(8);
																			if (R15cell4 != null) {
																			   R15cell4.setCellValue(BRF204A.getR23_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR23_gcc_kuwait_aed().intValue());
																			}	

																			Cell R15cell5 = R15row.getCell(9);
																			if (R15cell5 != null) {
																			   R15cell5.setCellValue(BRF204A.getR23_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR23_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R15cell6 = R15row.getCell(10);
																			if (R15cell6 != null) {
																			   R15cell6.setCellValue(BRF204A.getR23_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR23_gcc_qatar_aed().intValue());
																			}	

																			Cell R15cell7 = R15row.getCell(11);
																			if (R15cell7 != null) {
																			   R15cell7.setCellValue(BRF204A.getR23_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR23_gcc_qatar_fcy().intValue());
																			}	

																			Cell R15cell8 = R15row.getCell(12);
																			if (R15cell8 != null) {
																			   R15cell8.setCellValue(BRF204A.getR23_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR23_gcc_bahrain_aed().intValue());
																			}	

																			Cell R15cell9 = R15row.getCell(13);
																			if (R15cell9 != null) {
																			   R15cell9.setCellValue(BRF204A.getR23_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR23_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R15cell10 = R15row.getCell(14);
																			if (R15cell10 != null) {
																			   R15cell10.setCellValue(BRF204A.getR23_other_aed() == null ? 0 :
																			   	BRF204A.getR23_other_aed().intValue());
																			}	

																			Cell R15cell11 = R15row.getCell(15);
																			if (R15cell11 != null) {
																			   R15cell11.setCellValue(BRF204A.getR23_other_fcy() == null ? 0 :
																			   	BRF204A.getR23_other_fcy().intValue());
																			}	

																			   /////////////R24////////////////////////

																			Row R16row = sheet.getRow(33);
																			   
																			Cell R16cell = R16row.getCell(4);
																			if (R16cell != null) {
																			   R16cell.setCellValue(BRF204A.getR24_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR24_gcc_ksa_aed().intValue());
																			}	

																			Cell R16cell1 = R16row.getCell(5);
																			if (R16cell1 != null) {
																			   R16cell1.setCellValue(BRF204A.getR24_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR24_gcc_ksa_fcy().intValue());
																			}	

																			Cell R16cell2 = R16row.getCell(6);
																			if (R16cell2 != null) {
																			   R16cell2.setCellValue(BRF204A.getR24_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR24_gcc_oman_aed().intValue());
																			}	

																			Cell R16cell3 = R16row.getCell(7);
																			if (R16cell3 != null) {
																			   R16cell3.setCellValue(BRF204A.getR24_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR24_gcc_oman_fcy().intValue());
																			}	

																			Cell R16cell4 = R16row.getCell(8);
																			if (R16cell4 != null) {
																			   R16cell4.setCellValue(BRF204A.getR24_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR24_gcc_kuwait_aed().intValue());
																			}	

																			Cell R16cell5 = R16row.getCell(9);
																			if (R16cell5 != null) {
																			   R16cell5.setCellValue(BRF204A.getR24_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR24_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R16cell6 = R16row.getCell(10);
																			if (R16cell6 != null) {
																			   R16cell6.setCellValue(BRF204A.getR24_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR24_gcc_qatar_aed().intValue());
																			}	

																			Cell R16cell7 = R16row.getCell(11);
																			if (R16cell7 != null) {
																			   R16cell7.setCellValue(BRF204A.getR24_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR24_gcc_qatar_fcy().intValue());
																			}	

																			Cell R16cell8 = R16row.getCell(12);
																			if (R16cell8 != null) {
																			   R16cell8.setCellValue(BRF204A.getR24_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR24_gcc_bahrain_aed().intValue());
																			}	

																			Cell R16cell9 = R16row.getCell(13);
																			if (R16cell9 != null) {
																			   R16cell9.setCellValue(BRF204A.getR24_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR24_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R16cell10 = R16row.getCell(14);
																			if (R16cell10 != null) {
																			   R16cell10.setCellValue(BRF204A.getR24_other_aed() == null ? 0 :
																			   	BRF204A.getR24_other_aed().intValue());
																			}	

																			Cell R16cell11 = R16row.getCell(15);
																			if (R16cell11 != null) {
																			   R16cell11.setCellValue(BRF204A.getR24_other_fcy() == null ? 0 :
																			   	BRF204A.getR24_other_fcy().intValue());
																			}	


																			   /////////////R25////////////////////////

																			Row R17row = sheet.getRow(34);
																			   
																			Cell R17cell = R17row.getCell(4);
																			if (R17cell != null) {
																			   R17cell.setCellValue(BRF204A.getR25_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR25_gcc_ksa_aed().intValue());
																			}	

																			Cell R17cell1 = R17row.getCell(5);
																			if (R17cell1 != null) {
																			   R17cell1.setCellValue(BRF204A.getR25_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR25_gcc_ksa_fcy().intValue());
																			}	

																			Cell R17cell2 = R17row.getCell(6);
																			if (R17cell2 != null) {
																			   R17cell2.setCellValue(BRF204A.getR25_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR25_gcc_oman_aed().intValue());
																			}	

																			Cell R17cell3 = R17row.getCell(7);
																			if (R17cell3 != null) {
																			   R17cell3.setCellValue(BRF204A.getR25_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR25_gcc_oman_fcy().intValue());
																			}	

																			Cell R17cell4 = R17row.getCell(8);
																			if (R17cell4 != null) {
																			   R17cell4.setCellValue(BRF204A.getR25_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR25_gcc_kuwait_aed().intValue());
																			}	

																			Cell R17cell5 = R17row.getCell(9);
																			if (R17cell5 != null) {
																			   R17cell5.setCellValue(BRF204A.getR25_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR25_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R17cell6 = R17row.getCell(10);
																			if (R17cell6 != null) {
																			   R17cell6.setCellValue(BRF204A.getR25_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR25_gcc_qatar_aed().intValue());
																			}	

																			Cell R17cell7 = R17row.getCell(11);
																			if (R17cell7 != null) {
																			   R17cell7.setCellValue(BRF204A.getR25_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR25_gcc_qatar_fcy().intValue());
																			}	

																			Cell R17cell8 = R17row.getCell(12);
																			if (R17cell8 != null) {
																			   R17cell8.setCellValue(BRF204A.getR25_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR25_gcc_bahrain_aed().intValue());
																			}	

																			Cell R17cell9 = R17row.getCell(13);
																			if (R17cell9 != null) {
																			   R17cell9.setCellValue(BRF204A.getR25_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR25_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R17cell10 = R17row.getCell(14);
																			if (R17cell10 != null) {
																			   R17cell10.setCellValue(BRF204A.getR25_other_aed() == null ? 0 :
																			   	BRF204A.getR25_other_aed().intValue());
																			}	

																			Cell R17cell11 = R17row.getCell(15);
																			if (R17cell11 != null) {
																			   R17cell11.setCellValue(BRF204A.getR25_other_fcy() == null ? 0 :
																			   	BRF204A.getR25_other_fcy().intValue());
																			}	



																			   /////////////R28////////////////////////

																			Row R18row = sheet.getRow(37);
																			   
																			Cell R18cell = R18row.getCell(4);
																			if (R18cell != null) {
																			   R18cell.setCellValue(BRF204A.getR28_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR28_gcc_ksa_aed().intValue());
																			}	

																			Cell R18cell1 = R18row.getCell(5);
																			if (R18cell1 != null) {
																			   R18cell1.setCellValue(BRF204A.getR28_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR28_gcc_ksa_fcy().intValue());
																			}	

																			Cell R18cell2 = R18row.getCell(6);
																			if (R18cell2 != null) {
																			   R18cell2.setCellValue(BRF204A.getR28_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR28_gcc_oman_aed().intValue());
																			}	

																			Cell R18cell3 = R18row.getCell(7);
																			if (R18cell3 != null) {
																			   R18cell3.setCellValue(BRF204A.getR28_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR28_gcc_oman_fcy().intValue());
																			}	

																			Cell R18cell4 = R18row.getCell(8);
																			if (R18cell4 != null) {
																			   R18cell4.setCellValue(BRF204A.getR28_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR28_gcc_kuwait_aed().intValue());
																			}	

																			Cell R18cell5 = R18row.getCell(9);
																			if (R18cell5 != null) {
																			   R18cell5.setCellValue(BRF204A.getR28_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR28_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R18cell6 = R18row.getCell(10);
																			if (R18cell6 != null) {
																			   R18cell6.setCellValue(BRF204A.getR28_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR28_gcc_qatar_aed().intValue());
																			}	

																			Cell R18cell7 = R18row.getCell(11);
																			if (R18cell7 != null) {
																			   R18cell7.setCellValue(BRF204A.getR28_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR28_gcc_qatar_fcy().intValue());
																			}	

																			Cell R18cell8 = R18row.getCell(12);
																			if (R18cell8 != null) {
																			   R18cell8.setCellValue(BRF204A.getR28_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR28_gcc_bahrain_aed().intValue());
																			}	

																			Cell R18cell9 = R18row.getCell(13);
																			if (R18cell9 != null) {
																			   R18cell9.setCellValue(BRF204A.getR28_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR28_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R18cell10 = R18row.getCell(14);
																			if (R18cell10 != null) {
																			   R18cell10.setCellValue(BRF204A.getR28_other_aed() == null ? 0 :
																			   	BRF204A.getR28_other_aed().intValue());
																			}	

																			Cell R18cell11 = R18row.getCell(15);
																			if (R18cell11 != null) {
																			   R18cell11.setCellValue(BRF204A.getR28_other_fcy() == null ? 0 :
																			   	BRF204A.getR28_other_fcy().intValue());
																			}	



																			   /////////////R29////////////////////////

																			Row R20row = sheet.getRow(38);
																			   
																			Cell R20cell = R20row.getCell(4);
																			if (R20cell != null) {
																			   R20cell.setCellValue(BRF204A.getR29_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR29_gcc_ksa_aed().intValue());
																			}	

																			Cell R20cell1 = R20row.getCell(5);
																			if (R20cell1 != null) {
																			   R20cell1.setCellValue(BRF204A.getR29_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR29_gcc_ksa_fcy().intValue());
																			}	

																			Cell R20cell2 = R20row.getCell(6);
																			if (R20cell2 != null) {
																			   R20cell2.setCellValue(BRF204A.getR29_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR29_gcc_oman_aed().intValue());
																			}	

																			Cell R20cell3 = R20row.getCell(7);
																			if (R20cell3 != null) {
																			   R20cell3.setCellValue(BRF204A.getR29_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR29_gcc_oman_fcy().intValue());
																			}	

																			Cell R20cell4 = R20row.getCell(8);
																			if (R20cell4 != null) {
																			   R20cell4.setCellValue(BRF204A.getR29_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR29_gcc_kuwait_aed().intValue());
																			}	

																			Cell R20cell5 = R20row.getCell(9);
																			if (R20cell5 != null) {
																			   R20cell5.setCellValue(BRF204A.getR29_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR29_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R20cell6 = R20row.getCell(10);
																			if (R20cell6 != null) {
																			   R20cell6.setCellValue(BRF204A.getR29_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR29_gcc_qatar_aed().intValue());
																			}	

																			Cell R20cell7 = R20row.getCell(11);
																			if (R20cell7 != null) {
																			   R20cell7.setCellValue(BRF204A.getR29_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR29_gcc_qatar_fcy().intValue());
																			}	

																			Cell R20cell8 = R20row.getCell(12);
																			if (R20cell8 != null) {
																			   R20cell8.setCellValue(BRF204A.getR29_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR29_gcc_bahrain_aed().intValue());
																			}	

																			Cell R20cell9 = R20row.getCell(13);
																			if (R20cell9 != null) {
																			   R20cell9.setCellValue(BRF204A.getR29_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR29_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R20cell10 = R20row.getCell(14);
																			if (R20cell10 != null) {
																			   R20cell10.setCellValue(BRF204A.getR29_other_aed() == null ? 0 :
																			   	BRF204A.getR29_other_aed().intValue());
																			}	

																			Cell R20cell11 = R20row.getCell(15);
																			if (R20cell11 != null) {
																			   R20cell11.setCellValue(BRF204A.getR29_other_fcy() == null ? 0 :
																			   	BRF204A.getR29_other_fcy().intValue());
																			}	



																			   /////////////R30////////////////////////

																			Row R21row = sheet.getRow(39);
																			   
																			Cell R21cell = R21row.getCell(4);
																			if (R21cell != null) {
																			   R21cell.setCellValue(BRF204A.getR30_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR30_gcc_ksa_aed().intValue());
																			}	

																			Cell R21cell1 = R21row.getCell(5);
																			if (R21cell1 != null) {
																			   R21cell1.setCellValue(BRF204A.getR30_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR30_gcc_ksa_fcy().intValue());
																			}	

																			Cell R21cell2 = R21row.getCell(6);
																			if (R21cell2 != null) {
																			   R21cell2.setCellValue(BRF204A.getR30_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR30_gcc_oman_aed().intValue());
																			}	

																			Cell R21cell3 = R21row.getCell(7);
																			if (R21cell3 != null) {
																			   R21cell3.setCellValue(BRF204A.getR30_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR30_gcc_oman_fcy().intValue());
																			}	

																			Cell R21cell4 = R21row.getCell(8);
																			if (R21cell4 != null) {
																			   R21cell4.setCellValue(BRF204A.getR30_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR30_gcc_kuwait_aed().intValue());
																			}	

																			Cell R21cell5 = R21row.getCell(9);
																			if (R21cell5 != null) {
																			   R21cell5.setCellValue(BRF204A.getR30_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR30_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R21cell6 = R21row.getCell(10);
																			if (R21cell6 != null) {
																			   R21cell6.setCellValue(BRF204A.getR30_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR30_gcc_qatar_aed().intValue());
																			}	

																			Cell R21cell7 = R21row.getCell(11);
																			if (R21cell7 != null) {
																			   R21cell7.setCellValue(BRF204A.getR30_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR30_gcc_qatar_fcy().intValue());
																			}	

																			Cell R21cell8 = R21row.getCell(12);
																			if (R21cell8 != null) {
																			   R21cell8.setCellValue(BRF204A.getR30_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR30_gcc_bahrain_aed().intValue());
																			}	

																			Cell R21cell9 = R21row.getCell(13);
																			if (R21cell9 != null) {
																			   R21cell9.setCellValue(BRF204A.getR30_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR30_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R21cell10 = R21row.getCell(14);
																			if (R21cell10 != null) {
																			   R21cell10.setCellValue(BRF204A.getR30_other_aed() == null ? 0 :
																			   	BRF204A.getR30_other_aed().intValue());
																			}	

																			Cell R21cell11 = R21row.getCell(15);
																			if (R21cell11 != null) {
																			   R21cell11.setCellValue(BRF204A.getR30_other_fcy() == null ? 0 :
																			   	BRF204A.getR30_other_fcy().intValue());
																			}	



																			   /////////////R32////////////////////////

																			Row R22row = sheet.getRow(41);
																			   
																			Cell R22cell = R22row.getCell(4);
																			if (R22cell != null) {
																			   R22cell.setCellValue(BRF204A.getR32_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR32_gcc_ksa_aed().intValue());
																			}	

																			Cell R22cell1 = R22row.getCell(5);
																			if (R22cell1 != null) {
																			   R22cell1.setCellValue(BRF204A.getR32_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR32_gcc_ksa_fcy().intValue());
																			}	

																			Cell R22cell2 = R22row.getCell(6);
																			if (R22cell2 != null) {
																			   R22cell2.setCellValue(BRF204A.getR32_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR32_gcc_oman_aed().intValue());
																			}	

																			Cell R22cell3 = R22row.getCell(7);
																			if (R22cell3 != null) {
																			   R22cell3.setCellValue(BRF204A.getR32_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR32_gcc_oman_fcy().intValue());
																			}	

																			Cell R22cell4 = R22row.getCell(8);
																			if (R22cell4 != null) {
																			   R22cell4.setCellValue(BRF204A.getR32_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR32_gcc_kuwait_aed().intValue());
																			}	

																			Cell R22cell5 = R22row.getCell(9);
																			if (R22cell5 != null) {
																			   R22cell5.setCellValue(BRF204A.getR32_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR32_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R22cell6 = R22row.getCell(10);
																			if (R22cell6 != null) {
																			   R22cell6.setCellValue(BRF204A.getR32_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR32_gcc_qatar_aed().intValue());
																			}	

																			Cell R22cell7 = R22row.getCell(11);
																			if (R22cell7 != null) {
																			   R22cell7.setCellValue(BRF204A.getR32_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR32_gcc_qatar_fcy().intValue());
																			}	

																			Cell R22cell8 = R22row.getCell(12);
																			if (R22cell8 != null) {
																			   R22cell8.setCellValue(BRF204A.getR32_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR32_gcc_bahrain_aed().intValue());
																			}	

																			Cell R22cell9 = R22row.getCell(13);
																			if (R22cell9 != null) {
																			   R22cell9.setCellValue(BRF204A.getR32_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR32_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R22cell10 = R22row.getCell(14);
																			if (R22cell10 != null) {
																			   R22cell10.setCellValue(BRF204A.getR32_other_aed() == null ? 0 :
																			   	BRF204A.getR32_other_aed().intValue());
																			}	

																			Cell R22cell11 = R22row.getCell(15);
																			if (R22cell11 != null) {
																			   R22cell11.setCellValue(BRF204A.getR32_other_fcy() == null ? 0 :
																			   	BRF204A.getR32_other_fcy().intValue());
																			}	



																			   /////////////R33////////////////////////

																			Row R23row = sheet.getRow(42);
																			   
																			Cell R23cell = R23row.getCell(4);
																			if (R23cell != null) {
																			   R23cell.setCellValue(BRF204A.getR33_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR33_gcc_ksa_aed().intValue());
																			}	

																			Cell R23cell1 = R23row.getCell(5);
																			if (R23cell1 != null) {
																			   R23cell1.setCellValue(BRF204A.getR33_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR33_gcc_ksa_fcy().intValue());
																			}	

																			Cell R23cell2 = R23row.getCell(6);
																			if (R23cell2 != null) {
																			   R23cell2.setCellValue(BRF204A.getR33_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR33_gcc_oman_aed().intValue());
																			}	

																			Cell R23cell3 = R23row.getCell(7);
																			if (R23cell3 != null) {
																			   R23cell3.setCellValue(BRF204A.getR33_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR33_gcc_oman_fcy().intValue());
																			}	

																			Cell R23cell4 = R23row.getCell(8);
																			if (R23cell4 != null) {
																			   R23cell4.setCellValue(BRF204A.getR33_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR33_gcc_kuwait_aed().intValue());
																			}	

																			Cell R23cell5 = R23row.getCell(9);
																			if (R23cell5 != null) {
																			   R23cell5.setCellValue(BRF204A.getR33_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR33_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R23cell6 = R23row.getCell(10);
																			if (R23cell6 != null) {
																			   R23cell6.setCellValue(BRF204A.getR33_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR33_gcc_qatar_aed().intValue());
																			}	

																			Cell R23cell7 = R23row.getCell(11);
																			if (R23cell7 != null) {
																			   R23cell7.setCellValue(BRF204A.getR33_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR33_gcc_qatar_fcy().intValue());
																			}	

																			Cell R23cell8 = R23row.getCell(12);
																			if (R23cell8 != null) {
																			   R23cell8.setCellValue(BRF204A.getR33_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR33_gcc_bahrain_aed().intValue());
																			}	

																			Cell R23cell9 = R23row.getCell(13);
																			if (R23cell9 != null) {
																			   R23cell9.setCellValue(BRF204A.getR33_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR33_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R23cell10 = R23row.getCell(14);
																			if (R23cell10 != null) {
																			   R23cell10.setCellValue(BRF204A.getR33_other_aed() == null ? 0 :
																			   	BRF204A.getR33_other_aed().intValue());
																			}	

																			Cell R23cell11 = R23row.getCell(15);
																			if (R23cell11 != null) {
																			   R23cell11.setCellValue(BRF204A.getR33_other_fcy() == null ? 0 :
																			   	BRF204A.getR33_other_fcy().intValue());
																			}	



																			   /////////////R36////////////////////////

																			Row R24row = sheet.getRow(45);
																			   
																			Cell R24cell = R24row.getCell(4);
																			if (R24cell != null) {
																			   R24cell.setCellValue(BRF204A.getR36_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR36_gcc_ksa_aed().intValue());
																			}	

																			Cell R24cell1 = R24row.getCell(5);
																			if (R24cell1 != null) {
																			   R24cell1.setCellValue(BRF204A.getR36_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR36_gcc_ksa_fcy().intValue());
																			}	

																			Cell R24cell2 = R24row.getCell(6);
																			if (R24cell2 != null) {
																			   R24cell2.setCellValue(BRF204A.getR36_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR36_gcc_oman_aed().intValue());
																			}	

																			Cell R24cell3 = R24row.getCell(7);
																			if (R24cell3 != null) {
																			   R24cell3.setCellValue(BRF204A.getR36_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR36_gcc_oman_fcy().intValue());
																			}	

																			Cell R24cell4 = R24row.getCell(8);
																			if (R24cell4 != null) {
																			   R24cell4.setCellValue(BRF204A.getR36_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR36_gcc_kuwait_aed().intValue());
																			}	

																			Cell R24cell5 = R24row.getCell(9);
																			if (R24cell5 != null) {
																			   R24cell5.setCellValue(BRF204A.getR36_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR36_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R24cell6 = R24row.getCell(10);
																			if (R24cell6 != null) {
																			   R24cell6.setCellValue(BRF204A.getR36_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR36_gcc_qatar_aed().intValue());
																			}	

																			Cell R24cell7 = R24row.getCell(11);
																			if (R24cell7 != null) {
																			   R24cell7.setCellValue(BRF204A.getR36_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR36_gcc_qatar_fcy().intValue());
																			}	

																			Cell R24cell8 = R24row.getCell(12);
																			if (R24cell8 != null) {
																			   R24cell8.setCellValue(BRF204A.getR36_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR36_gcc_bahrain_aed().intValue());
																			}	

																			Cell R24cell9 = R24row.getCell(13);
																			if (R24cell9 != null) {
																			   R24cell9.setCellValue(BRF204A.getR36_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR36_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R24cell10 = R24row.getCell(14);
																			if (R24cell10 != null) {
																			   R24cell10.setCellValue(BRF204A.getR36_other_aed() == null ? 0 :
																			   	BRF204A.getR36_other_aed().intValue());
																			}	

																			Cell R24cell11 = R24row.getCell(15);
																			if (R24cell11 != null) {
																			   R24cell11.setCellValue(BRF204A.getR36_other_fcy() == null ? 0 :
																			   	BRF204A.getR36_other_fcy().intValue());
																			}	



																			   /////////////R37////////////////////////

																			Row R25row = sheet.getRow(46);
																			   
																			Cell R25cell = R25row.getCell(4);
																			if (R25cell != null) {
																			   R25cell.setCellValue(BRF204A.getR37_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR37_gcc_ksa_aed().intValue());
																			}	

																			Cell R25cell1 = R25row.getCell(5);
																			if (R25cell1 != null) {
																			   R25cell1.setCellValue(BRF204A.getR37_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR37_gcc_ksa_fcy().intValue());
																			}	

																			Cell R25cell2 = R25row.getCell(6);
																			if (R25cell2 != null) {
																			   R25cell2.setCellValue(BRF204A.getR37_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR37_gcc_oman_aed().intValue());
																			}	

																			Cell R25cell3 = R25row.getCell(7);
																			if (R25cell3 != null) {
																			   R25cell3.setCellValue(BRF204A.getR37_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR37_gcc_oman_fcy().intValue());
																			}	

																			Cell R25cell4 = R25row.getCell(8);
																			if (R25cell4 != null) {
																			   R25cell4.setCellValue(BRF204A.getR37_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR37_gcc_kuwait_aed().intValue());
																			}	

																			Cell R25cell5 = R25row.getCell(9);
																			if (R25cell5 != null) {
																			   R25cell5.setCellValue(BRF204A.getR37_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR37_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R25cell6 = R25row.getCell(10);
																			if (R25cell6 != null) {
																			   R25cell6.setCellValue(BRF204A.getR37_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR37_gcc_qatar_aed().intValue());
																			}	

																			Cell R25cell7 = R25row.getCell(11);
																			if (R25cell7 != null) {
																			   R25cell7.setCellValue(BRF204A.getR37_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR37_gcc_qatar_fcy().intValue());
																			}	

																			Cell R25cell8 = R25row.getCell(12);
																			if (R25cell8 != null) {
																			   R25cell8.setCellValue(BRF204A.getR37_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR37_gcc_bahrain_aed().intValue());
																			}	

																			Cell R25cell9 = R25row.getCell(13);
																			if (R25cell9 != null) {
																			   R25cell9.setCellValue(BRF204A.getR37_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR37_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R25cell10 = R25row.getCell(14);
																			if (R25cell10 != null) {
																			   R25cell10.setCellValue(BRF204A.getR37_other_aed() == null ? 0 :
																			   	BRF204A.getR37_other_aed().intValue());
																			}	

																			Cell R25cell11 = R25row.getCell(15);
																			if (R25cell11 != null) {
																			   R25cell11.setCellValue(BRF204A.getR37_other_fcy() == null ? 0 :
																			   	BRF204A.getR37_other_fcy().intValue());
																			}	



																			   /////////////R39////////////////////////

																			Row R26row = sheet.getRow(48);
																			   
																			Cell R26cell = R26row.getCell(4);
																			if (R26cell != null) {
																			   R26cell.setCellValue(BRF204A.getR39_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR39_gcc_ksa_aed().intValue());
																			}	

																			Cell R26cell1 = R26row.getCell(5);
																			if (R26cell1 != null) {
																			   R26cell1.setCellValue(BRF204A.getR39_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR39_gcc_ksa_fcy().intValue());
																			}	

																			Cell R26cell2 = R26row.getCell(6);
																			if (R26cell2 != null) {
																			   R26cell2.setCellValue(BRF204A.getR39_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR39_gcc_oman_aed().intValue());
																			}	

																			Cell R26cell3 = R26row.getCell(7);
																			if (R26cell3 != null) {
																			   R26cell3.setCellValue(BRF204A.getR39_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR39_gcc_oman_fcy().intValue());
																			}	

																			Cell R26cell4 = R26row.getCell(8);
																			if (R26cell4 != null) {
																			   R26cell4.setCellValue(BRF204A.getR39_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR39_gcc_kuwait_aed().intValue());
																			}	

																			Cell R26cell5 = R26row.getCell(9);
																			if (R26cell5 != null) {
																			   R26cell5.setCellValue(BRF204A.getR39_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR39_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R26cell6 = R26row.getCell(10);
																			if (R26cell6 != null) {
																			   R26cell6.setCellValue(BRF204A.getR39_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR39_gcc_qatar_aed().intValue());
																			}	

																			Cell R26cell7 = R26row.getCell(11);
																			if (R26cell7 != null) {
																			   R26cell7.setCellValue(BRF204A.getR39_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR39_gcc_qatar_fcy().intValue());
																			}	

																			Cell R26cell8 = R26row.getCell(12);
																			if (R26cell8 != null) {
																			   R26cell8.setCellValue(BRF204A.getR39_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR39_gcc_bahrain_aed().intValue());
																			}	

																			Cell R26cell9 = R26row.getCell(13);
																			if (R26cell9 != null) {
																			   R26cell9.setCellValue(BRF204A.getR39_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR39_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R26cell10 = R26row.getCell(14);
																			if (R26cell10 != null) {
																			   R26cell10.setCellValue(BRF204A.getR39_other_aed() == null ? 0 :
																			   	BRF204A.getR39_other_aed().intValue());
																			}	

																			Cell R26cell11 = R26row.getCell(15);
																			if (R26cell11 != null) {
																			   R26cell11.setCellValue(BRF204A.getR39_other_fcy() == null ? 0 :
																			   	BRF204A.getR39_other_fcy().intValue());
																			}	



																			   /////////////R40////////////////////////

																			Row R27row = sheet.getRow(49);
																			   
																			Cell R27cell = R27row.getCell(4);
																			if (R27cell != null) {
																			   R27cell.setCellValue(BRF204A.getR40_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR40_gcc_ksa_aed().intValue());
																			}	

																			Cell R27cell1 = R27row.getCell(5);
																			if (R27cell1 != null) {
																			   R27cell1.setCellValue(BRF204A.getR40_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR40_gcc_ksa_fcy().intValue());
																			}	

																			Cell R27cell2 = R27row.getCell(6);
																			if (R27cell2 != null) {
																			   R27cell2.setCellValue(BRF204A.getR40_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR40_gcc_oman_aed().intValue());
																			}	

																			Cell R27cell3 = R27row.getCell(7);
																			if (R27cell3 != null) {
																			   R27cell3.setCellValue(BRF204A.getR40_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR40_gcc_oman_fcy().intValue());
																			}	

																			Cell R27cell4 = R27row.getCell(8);
																			if (R27cell4 != null) {
																			   R27cell4.setCellValue(BRF204A.getR40_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR40_gcc_kuwait_aed().intValue());
																			}	

																			Cell R27cell5 = R27row.getCell(9);
																			if (R27cell5 != null) {
																			   R27cell5.setCellValue(BRF204A.getR40_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR40_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R27cell6 = R27row.getCell(10);
																			if (R27cell6 != null) {
																			   R27cell6.setCellValue(BRF204A.getR40_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR40_gcc_qatar_aed().intValue());
																			}	

																			Cell R27cell7 = R27row.getCell(11);
																			if (R27cell7 != null) {
																			   R27cell7.setCellValue(BRF204A.getR40_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR40_gcc_qatar_fcy().intValue());
																			}	

																			Cell R27cell8 = R27row.getCell(12);
																			if (R27cell8 != null) {
																			   R27cell8.setCellValue(BRF204A.getR40_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR40_gcc_bahrain_aed().intValue());
																			}	

																			Cell R27cell9 = R27row.getCell(13);
																			if (R27cell9 != null) {
																			   R27cell9.setCellValue(BRF204A.getR40_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR40_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R27cell10 = R27row.getCell(14);
																			if (R27cell10 != null) {
																			   R27cell10.setCellValue(BRF204A.getR40_other_aed() == null ? 0 :
																			   	BRF204A.getR40_other_aed().intValue());
																			}	

																			Cell R27cell11 = R27row.getCell(15);
																			if (R27cell11 != null) {
																			   R27cell11.setCellValue(BRF204A.getR40_other_fcy() == null ? 0 :
																			   	BRF204A.getR40_other_fcy().intValue());
																			}	



																			   /////////////R43////////////////////////

																			Row R28row = sheet.getRow(52);
																			   
																			Cell R28cell = R28row.getCell(4);
																			if (R28cell != null) {
																			   R28cell.setCellValue(BRF204A.getR43_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR43_gcc_ksa_aed().intValue());
																			}	

																			Cell R28cell1 = R28row.getCell(5);
																			if (R28cell1 != null) {
																			   R28cell1.setCellValue(BRF204A.getR43_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR43_gcc_ksa_fcy().intValue());
																			}	

																			Cell R28cell2 = R28row.getCell(6);
																			if (R28cell2 != null) {
																			   R28cell2.setCellValue(BRF204A.getR43_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR43_gcc_oman_aed().intValue());
																			}	

																			Cell R28cell3 = R28row.getCell(7);
																			if (R28cell3 != null) {
																			   R28cell3.setCellValue(BRF204A.getR43_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR43_gcc_oman_fcy().intValue());
																			}	

																			Cell R28cell4 = R28row.getCell(8);
																			if (R28cell4 != null) {
																			   R28cell4.setCellValue(BRF204A.getR43_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR43_gcc_kuwait_aed().intValue());
																			}	

																			Cell R28cell5 = R28row.getCell(9);
																			if (R28cell5 != null) {
																			   R28cell5.setCellValue(BRF204A.getR43_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR43_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R28cell6 = R28row.getCell(10);
																			if (R28cell6 != null) {
																			   R28cell6.setCellValue(BRF204A.getR43_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR43_gcc_qatar_aed().intValue());
																			}	

																			Cell R28cell7 = R28row.getCell(11);
																			if (R28cell7 != null) {
																			   R28cell7.setCellValue(BRF204A.getR43_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR43_gcc_qatar_fcy().intValue());
																			}	

																			Cell R28cell8 = R28row.getCell(12);
																			if (R28cell8 != null) {
																			   R28cell8.setCellValue(BRF204A.getR43_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR43_gcc_bahrain_aed().intValue());
																			}	

																			Cell R28cell9 = R28row.getCell(13);
																			if (R28cell9 != null) {
																			   R28cell9.setCellValue(BRF204A.getR43_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR43_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R28cell10 = R28row.getCell(14);
																			if (R28cell10 != null) {
																			   R28cell10.setCellValue(BRF204A.getR43_other_aed() == null ? 0 :
																			   	BRF204A.getR43_other_aed().intValue());
																			}	

																			Cell R28cell11 = R28row.getCell(15);
																			if (R28cell11 != null) {
																			   R28cell11.setCellValue(BRF204A.getR43_other_fcy() == null ? 0 :
																			   	BRF204A.getR43_other_fcy().intValue());
																			}	



																			   /////////////R44////////////////////////

																			Row R29row = sheet.getRow(53);
																			   
																			Cell R29cell = R29row.getCell(4);
																			if (R29cell != null) {
																			   R29cell.setCellValue(BRF204A.getR44_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR44_gcc_ksa_aed().intValue());
																			}	

																			Cell R29cell1 = R29row.getCell(5);
																			if (R29cell1 != null) {
																			   R29cell1.setCellValue(BRF204A.getR44_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR44_gcc_ksa_fcy().intValue());
																			}	

																			Cell R29cell2 = R29row.getCell(6);
																			if (R29cell2 != null) {
																			   R29cell2.setCellValue(BRF204A.getR44_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR44_gcc_oman_aed().intValue());
																			}	

																			Cell R29cell3 = R29row.getCell(7);
																			if (R29cell3 != null) {
																			   R29cell3.setCellValue(BRF204A.getR44_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR44_gcc_oman_fcy().intValue());
																			}	

																			Cell R29cell4 = R29row.getCell(8);
																			if (R29cell4 != null) {
																			   R29cell4.setCellValue(BRF204A.getR44_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR44_gcc_kuwait_aed().intValue());
																			}	

																			Cell R29cell5 = R29row.getCell(9);
																			if (R29cell5 != null) {
																			   R29cell5.setCellValue(BRF204A.getR44_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR44_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R29cell6 = R29row.getCell(10);
																			if (R29cell6 != null) {
																			   R29cell6.setCellValue(BRF204A.getR44_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR44_gcc_qatar_aed().intValue());
																			}	

																			Cell R29cell7 = R29row.getCell(11);
																			if (R29cell7 != null) {
																			   R29cell7.setCellValue(BRF204A.getR44_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR44_gcc_qatar_fcy().intValue());
																			}	

																			Cell R29cell8 = R29row.getCell(12);
																			if (R29cell8 != null) {
																			   R29cell8.setCellValue(BRF204A.getR44_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR44_gcc_bahrain_aed().intValue());
																			}	

																			Cell R29cell9 = R29row.getCell(13);
																			if (R29cell9 != null) {
																			   R29cell9.setCellValue(BRF204A.getR44_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR44_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R29cell10 = R29row.getCell(14);
																			if (R29cell10 != null) {
																			   R29cell10.setCellValue(BRF204A.getR44_other_aed() == null ? 0 :
																			   	BRF204A.getR44_other_aed().intValue());
																			}	

																			Cell R29cell11 = R29row.getCell(15);
																			if (R29cell11 != null) {
																			   R29cell11.setCellValue(BRF204A.getR44_other_fcy() == null ? 0 :
																			   	BRF204A.getR44_other_fcy().intValue());
																			}	



																			   /////////////R45////////////////////////

																			Row R30row = sheet.getRow(54);
																			   
																			Cell R30cell = R30row.getCell(4);
																			if (R30cell != null) {
																			   R30cell.setCellValue(BRF204A.getR45_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR45_gcc_ksa_aed().intValue());
																			}	

																			Cell R30cell1 = R30row.getCell(5);
																			if (R30cell1 != null) {
																			   R30cell1.setCellValue(BRF204A.getR45_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR45_gcc_ksa_fcy().intValue());
																			}	

																			Cell R30cell2 = R30row.getCell(6);
																			if (R30cell2 != null) {
																			   R30cell2.setCellValue(BRF204A.getR45_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR45_gcc_oman_aed().intValue());
																			}	

																			Cell R30cell3 = R30row.getCell(7);
																			if (R30cell3 != null) {
																			   R30cell3.setCellValue(BRF204A.getR45_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR45_gcc_oman_fcy().intValue());
																			}	

																			Cell R30cell4 = R30row.getCell(8);
																			if (R30cell4 != null) {
																			   R30cell4.setCellValue(BRF204A.getR45_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR45_gcc_kuwait_aed().intValue());
																			}	

																			Cell R30cell5 = R30row.getCell(9);
																			if (R30cell5 != null) {
																			   R30cell5.setCellValue(BRF204A.getR45_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR45_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R30cell6 = R30row.getCell(10);
																			if (R30cell6 != null) {
																			   R30cell6.setCellValue(BRF204A.getR45_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR45_gcc_qatar_aed().intValue());
																			}	

																			Cell R30cell7 = R30row.getCell(11);
																			if (R30cell7 != null) {
																			   R30cell7.setCellValue(BRF204A.getR45_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR45_gcc_qatar_fcy().intValue());
																			}	

																			Cell R30cell8 = R30row.getCell(12);
																			if (R30cell8 != null) {
																			   R30cell8.setCellValue(BRF204A.getR45_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR45_gcc_bahrain_aed().intValue());
																			}	

																			Cell R30cell9 = R30row.getCell(13);
																			if (R30cell9 != null) {
																			   R30cell9.setCellValue(BRF204A.getR45_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR45_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R30cell10 = R30row.getCell(14);
																			if (R30cell10 != null) {
																			   R30cell10.setCellValue(BRF204A.getR45_other_aed() == null ? 0 :
																			   	BRF204A.getR45_other_aed().intValue());
																			}	

																			Cell R30cell11 = R30row.getCell(15);
																			if (R30cell11 != null) {
																			   R30cell11.setCellValue(BRF204A.getR45_other_fcy() == null ? 0 :
																			   	BRF204A.getR45_other_fcy().intValue());
																			}	



																			   /////////////R46////////////////////////

																			Row R31row = sheet.getRow(55);
																			   
																			Cell R31cell = R31row.getCell(4);
																			if (R31cell != null) {
																			   R31cell.setCellValue(BRF204A.getR46_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR46_gcc_ksa_aed().intValue());
																			}	

																			Cell R31cell1 = R31row.getCell(5);
																			if (R31cell1 != null) {
																			   R31cell1.setCellValue(BRF204A.getR46_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR46_gcc_ksa_fcy().intValue());
																			}	

																			Cell R31cell2 = R31row.getCell(6);
																			if (R31cell2 != null) {
																			   R31cell2.setCellValue(BRF204A.getR46_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR46_gcc_oman_aed().intValue());
																			}	

																			Cell R31cell3 = R31row.getCell(7);
																			if (R31cell3 != null) {
																			   R31cell3.setCellValue(BRF204A.getR46_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR46_gcc_oman_fcy().intValue());
																			}	

																			Cell R31cell4 = R31row.getCell(8);
																			if (R31cell4 != null) {
																			   R31cell4.setCellValue(BRF204A.getR46_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR46_gcc_kuwait_aed().intValue());
																			}	

																			Cell R31cell5 = R31row.getCell(9);
																			if (R31cell5 != null) {
																			   R31cell5.setCellValue(BRF204A.getR46_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR46_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R31cell6 = R31row.getCell(10);
																			if (R31cell6 != null) {
																			   R31cell6.setCellValue(BRF204A.getR46_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR46_gcc_qatar_aed().intValue());
																			}	

																			Cell R31cell7 = R31row.getCell(11);
																			if (R31cell7 != null) {
																			   R31cell7.setCellValue(BRF204A.getR46_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR46_gcc_qatar_fcy().intValue());
																			}	

																			Cell R31cell8 = R31row.getCell(12);
																			if (R31cell8 != null) {
																			   R31cell8.setCellValue(BRF204A.getR46_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR46_gcc_bahrain_aed().intValue());
																			}	

																			Cell R31cell9 = R31row.getCell(13);
																			if (R31cell9 != null) {
																			   R31cell9.setCellValue(BRF204A.getR46_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR46_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R31cell10 = R31row.getCell(14);
																			if (R31cell10 != null) {
																			   R31cell10.setCellValue(BRF204A.getR46_other_aed() == null ? 0 :
																			   	BRF204A.getR46_other_aed().intValue());
																			}	

																			Cell R31cell11 = R31row.getCell(15);
																			if (R31cell11 != null) {
																			   R31cell11.setCellValue(BRF204A.getR46_other_fcy() == null ? 0 :
																			   	BRF204A.getR46_other_fcy().intValue());
																			}	



																			   /////////////R47////////////////////////

																			Row R32row = sheet.getRow(56);
																			   
																			Cell R32cell = R32row.getCell(4);
																			if (R32cell != null) {
																			   R32cell.setCellValue(BRF204A.getR47_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR47_gcc_ksa_aed().intValue());
																			}	

																			Cell R32cell1 = R32row.getCell(5);
																			if (R32cell1 != null) {
																			   R32cell1.setCellValue(BRF204A.getR47_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR47_gcc_ksa_fcy().intValue());
																			}	

																			Cell R32cell2 = R32row.getCell(6);
																			if (R32cell2 != null) {
																			   R32cell2.setCellValue(BRF204A.getR47_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR47_gcc_oman_aed().intValue());
																			}	

																			Cell R32cell3 = R32row.getCell(7);
																			if (R32cell3 != null) {
																			   R32cell3.setCellValue(BRF204A.getR47_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR47_gcc_oman_fcy().intValue());
																			}	

																			Cell R32cell4 = R32row.getCell(8);
																			if (R32cell4 != null) {
																			   R32cell4.setCellValue(BRF204A.getR47_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR47_gcc_kuwait_aed().intValue());
																			}	

																			Cell R32cell5 = R32row.getCell(9);
																			if (R32cell5 != null) {
																			   R32cell5.setCellValue(BRF204A.getR47_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR47_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R32cell6 = R32row.getCell(10);
																			if (R32cell6 != null) {
																			   R32cell6.setCellValue(BRF204A.getR47_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR47_gcc_qatar_aed().intValue());
																			}	

																			Cell R32cell7 = R32row.getCell(11);
																			if (R32cell7 != null) {
																			   R32cell7.setCellValue(BRF204A.getR47_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR47_gcc_qatar_fcy().intValue());
																			}	

																			Cell R32cell8 = R32row.getCell(12);
																			if (R32cell8 != null) {
																			   R32cell8.setCellValue(BRF204A.getR47_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR47_gcc_bahrain_aed().intValue());
																			}	

																			Cell R32cell9 = R32row.getCell(13);
																			if (R32cell9 != null) {
																			   R32cell9.setCellValue(BRF204A.getR47_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR47_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R32cell10 = R32row.getCell(14);
																			if (R32cell10 != null) {
																			   R32cell10.setCellValue(BRF204A.getR47_other_aed() == null ? 0 :
																			   	BRF204A.getR47_other_aed().intValue());
																			}	

																			Cell R32cell11 = R32row.getCell(15);
																			if (R32cell11 != null) {
																			   R32cell11.setCellValue(BRF204A.getR47_other_fcy() == null ? 0 :
																			   	BRF204A.getR47_other_fcy().intValue());
																			}	



																			   /////////////R49////////////////////////

																			Row R33row = sheet.getRow(58);
																			   
																			Cell R33cell = R33row.getCell(4);
																			if (R33cell != null) {
																			   R33cell.setCellValue(BRF204A.getR49_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR49_gcc_ksa_aed().intValue());
																			}	

																			Cell R33cell1 = R33row.getCell(5);
																			if (R33cell1 != null) {
																			   R33cell1.setCellValue(BRF204A.getR49_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR49_gcc_ksa_fcy().intValue());
																			}	

																			Cell R33cell2 = R33row.getCell(6);
																			if (R33cell2 != null) {
																			   R33cell2.setCellValue(BRF204A.getR49_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR49_gcc_oman_aed().intValue());
																			}	

																			Cell R33cell3 = R33row.getCell(7);
																			if (R33cell3 != null) {
																			   R33cell3.setCellValue(BRF204A.getR49_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR49_gcc_oman_fcy().intValue());
																			}	

																			Cell R33cell4 = R33row.getCell(8);
																			if (R33cell4 != null) {
																			   R33cell4.setCellValue(BRF204A.getR49_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR49_gcc_kuwait_aed().intValue());
																			}	

																			Cell R33cell5 = R33row.getCell(9);
																			if (R33cell5 != null) {
																			   R33cell5.setCellValue(BRF204A.getR49_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR49_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R33cell6 = R33row.getCell(10);
																			if (R33cell6 != null) {
																			   R33cell6.setCellValue(BRF204A.getR49_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR49_gcc_qatar_aed().intValue());
																			}	

																			Cell R33cell7 = R33row.getCell(11);
																			if (R33cell7 != null) {
																			   R33cell7.setCellValue(BRF204A.getR49_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR49_gcc_qatar_fcy().intValue());
																			}	

																			Cell R33cell8 = R33row.getCell(12);
																			if (R33cell8 != null) {
																			   R33cell8.setCellValue(BRF204A.getR49_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR49_gcc_bahrain_aed().intValue());
																			}	

																			Cell R33cell9 = R33row.getCell(13);
																			if (R33cell9 != null) {
																			   R33cell9.setCellValue(BRF204A.getR49_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR49_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R33cell10 = R33row.getCell(14);
																			if (R33cell10 != null) {
																			   R33cell10.setCellValue(BRF204A.getR49_other_aed() == null ? 0 :
																			   	BRF204A.getR49_other_aed().intValue());
																			}	

																			Cell R33cell11 = R33row.getCell(15);
																			if (R33cell11 != null) {
																			   R33cell11.setCellValue(BRF204A.getR49_other_fcy() == null ? 0 :
																			   	BRF204A.getR49_other_fcy().intValue());
																			}	



																			   /////////////R50////////////////////////

																			Row R34row = sheet.getRow(59);
																			   
																			Cell R34cell = R34row.getCell(4);
																			if (R34cell != null) {
																			   R34cell.setCellValue(BRF204A.getR50_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR50_gcc_ksa_aed().intValue());
																			}	

																			Cell R34cell1 = R34row.getCell(5);
																			if (R34cell1 != null) {
																			   R34cell1.setCellValue(BRF204A.getR50_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR50_gcc_ksa_fcy().intValue());
																			}	

																			Cell R34cell2 = R34row.getCell(6);
																			if (R34cell2 != null) {
																			   R34cell2.setCellValue(BRF204A.getR50_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR50_gcc_oman_aed().intValue());
																			}	

																			Cell R34cell3 = R34row.getCell(7);
																			if (R34cell3 != null) {
																			   R34cell3.setCellValue(BRF204A.getR50_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR50_gcc_oman_fcy().intValue());
																			}	

																			Cell R34cell4 = R34row.getCell(8);
																			if (R34cell4 != null) {
																			   R34cell4.setCellValue(BRF204A.getR50_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR50_gcc_kuwait_aed().intValue());
																			}	

																			Cell R34cell5 = R34row.getCell(9);
																			if (R34cell5 != null) {
																			   R34cell5.setCellValue(BRF204A.getR50_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR50_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R34cell6 = R34row.getCell(10);
																			if (R34cell6 != null) {
																			   R34cell6.setCellValue(BRF204A.getR50_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR50_gcc_qatar_aed().intValue());
																			}	

																			Cell R34cell7 = R34row.getCell(11);
																			if (R34cell7 != null) {
																			   R34cell7.setCellValue(BRF204A.getR50_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR50_gcc_qatar_fcy().intValue());
																			}	

																			Cell R34cell8 = R34row.getCell(12);
																			if (R34cell8 != null) {
																			   R34cell8.setCellValue(BRF204A.getR50_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR50_gcc_bahrain_aed().intValue());
																			}	

																			Cell R34cell9 = R34row.getCell(13);
																			if (R34cell9 != null) {
																			   R34cell9.setCellValue(BRF204A.getR50_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR50_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R34cell10 = R34row.getCell(14);
																			if (R34cell10 != null) {
																			   R34cell10.setCellValue(BRF204A.getR50_other_aed() == null ? 0 :
																			   	BRF204A.getR50_other_aed().intValue());
																			}	

																			Cell R34cell11 = R34row.getCell(15);
																			if (R34cell11 != null) {
																			   R34cell11.setCellValue(BRF204A.getR50_other_fcy() == null ? 0 :
																			   	BRF204A.getR50_other_fcy().intValue());
																			}	



																			   /////////////R51////////////////////////

																			Row R35row = sheet.getRow(60);
																			   
																			Cell R35cell = R35row.getCell(4);
																			if (R35cell != null) {
																			   R35cell.setCellValue(BRF204A.getR51_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR51_gcc_ksa_aed().intValue());
																			}	

																			Cell R35cell1 = R35row.getCell(5);
																			if (R35cell1 != null) {
																			   R35cell1.setCellValue(BRF204A.getR51_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR51_gcc_ksa_fcy().intValue());
																			}	

																			Cell R35cell2 = R35row.getCell(6);
																			if (R35cell2 != null) {
																			   R35cell2.setCellValue(BRF204A.getR51_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR51_gcc_oman_aed().intValue());
																			}	

																			Cell R35cell3 = R35row.getCell(7);
																			if (R35cell3 != null) {
																			   R35cell3.setCellValue(BRF204A.getR51_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR51_gcc_oman_fcy().intValue());
																			}	

																			Cell R35cell4 = R35row.getCell(8);
																			if (R35cell4 != null) {
																			   R35cell4.setCellValue(BRF204A.getR51_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR51_gcc_kuwait_aed().intValue());
																			}	

																			Cell R35cell5 = R35row.getCell(9);
																			if (R35cell5 != null) {
																			   R35cell5.setCellValue(BRF204A.getR51_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR51_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R35cell6 = R35row.getCell(10);
																			if (R35cell6 != null) {
																			   R35cell6.setCellValue(BRF204A.getR51_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR51_gcc_qatar_aed().intValue());
																			}	

																			Cell R35cell7 = R35row.getCell(11);
																			if (R35cell7 != null) {
																			   R35cell7.setCellValue(BRF204A.getR51_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR51_gcc_qatar_fcy().intValue());
																			}	

																			Cell R35cell8 = R35row.getCell(12);
																			if (R35cell8 != null) {
																			   R35cell8.setCellValue(BRF204A.getR51_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR51_gcc_bahrain_aed().intValue());
																			}	

																			Cell R35cell9 = R35row.getCell(13);
																			if (R35cell9 != null) {
																			   R35cell9.setCellValue(BRF204A.getR51_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR51_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R35cell10 = R35row.getCell(14);
																			if (R35cell10 != null) {
																			   R35cell10.setCellValue(BRF204A.getR51_other_aed() == null ? 0 :
																			   	BRF204A.getR51_other_aed().intValue());
																			}	

																			Cell R35cell11 = R35row.getCell(15);
																			if (R35cell11 != null) {
																			   R35cell11.setCellValue(BRF204A.getR51_other_fcy() == null ? 0 :
																			   	BRF204A.getR51_other_fcy().intValue());
																			}	



																			   /////////////R52////////////////////////

																			Row R36row = sheet.getRow(61);
																			   
																			Cell R36cell = R36row.getCell(4);
																			if (R36cell != null) {
																			   R36cell.setCellValue(BRF204A.getR52_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR52_gcc_ksa_aed().intValue());
																			}	

																			Cell R36cell1 = R36row.getCell(5);
																			if (R36cell1 != null) {
																			   R36cell1.setCellValue(BRF204A.getR52_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR52_gcc_ksa_fcy().intValue());
																			}	

																			Cell R36cell2 = R36row.getCell(6);
																			if (R36cell2 != null) {
																			   R36cell2.setCellValue(BRF204A.getR52_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR52_gcc_oman_aed().intValue());
																			}	

																			Cell R36cell3 = R36row.getCell(7);
																			if (R36cell3 != null) {
																			   R36cell3.setCellValue(BRF204A.getR52_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR52_gcc_oman_fcy().intValue());
																			}	

																			Cell R36cell4 = R36row.getCell(8);
																			if (R36cell4 != null) {
																			   R36cell4.setCellValue(BRF204A.getR52_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR52_gcc_kuwait_aed().intValue());
																			}	

																			Cell R36cell5 = R36row.getCell(9);
																			if (R36cell5 != null) {
																			   R36cell5.setCellValue(BRF204A.getR52_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR52_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R36cell6 = R36row.getCell(10);
																			if (R36cell6 != null) {
																			   R36cell6.setCellValue(BRF204A.getR52_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR52_gcc_qatar_aed().intValue());
																			}	

																			Cell R36cell7 = R36row.getCell(11);
																			if (R36cell7 != null) {
																			   R36cell7.setCellValue(BRF204A.getR52_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR52_gcc_qatar_fcy().intValue());
																			}	

																			Cell R36cell8 = R36row.getCell(12);
																			if (R36cell8 != null) {
																			   R36cell8.setCellValue(BRF204A.getR52_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR52_gcc_bahrain_aed().intValue());
																			}	

																			Cell R36cell9 = R36row.getCell(13);
																			if (R36cell9 != null) {
																			   R36cell9.setCellValue(BRF204A.getR52_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR52_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R36cell10 = R36row.getCell(14);
																			if (R36cell10 != null) {
																			   R36cell10.setCellValue(BRF204A.getR52_other_aed() == null ? 0 :
																			   	BRF204A.getR52_other_aed().intValue());
																			}	

																			Cell R36cell11 = R36row.getCell(15);
																			if (R36cell11 != null) {
																			   R36cell11.setCellValue(BRF204A.getR52_other_fcy() == null ? 0 :
																			   	BRF204A.getR52_other_fcy().intValue());
																			}	



																			   /////////////R53////////////////////////

																			Row R37row = sheet.getRow(62);
																			   
																			Cell R37cell = R37row.getCell(4);
																			if (R37cell != null) {
																			   R37cell.setCellValue(BRF204A.getR53_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR53_gcc_ksa_aed().intValue());
																			}	

																			Cell R37cell1 = R37row.getCell(5);
																			if (R37cell1 != null) {
																			   R37cell1.setCellValue(BRF204A.getR53_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR53_gcc_ksa_fcy().intValue());
																			}	

																			Cell R37cell2 = R37row.getCell(6);
																			if (R37cell2 != null) {
																			   R37cell2.setCellValue(BRF204A.getR53_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR53_gcc_oman_aed().intValue());
																			}	

																			Cell R37cell3 = R37row.getCell(7);
																			if (R37cell3 != null) {
																			   R37cell3.setCellValue(BRF204A.getR53_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR53_gcc_oman_fcy().intValue());
																			}	

																			Cell R37cell4 = R37row.getCell(8);
																			if (R37cell4 != null) {
																			   R37cell4.setCellValue(BRF204A.getR53_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR53_gcc_kuwait_aed().intValue());
																			}	

																			Cell R37cell5 = R37row.getCell(9);
																			if (R37cell5 != null) {
																			   R37cell5.setCellValue(BRF204A.getR53_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR53_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R37cell6 = R37row.getCell(10);
																			if (R37cell6 != null) {
																			   R37cell6.setCellValue(BRF204A.getR53_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR53_gcc_qatar_aed().intValue());
																			}	

																			Cell R37cell7 = R37row.getCell(11);
																			if (R37cell7 != null) {
																			   R37cell7.setCellValue(BRF204A.getR53_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR53_gcc_qatar_fcy().intValue());
																			}	

																			Cell R37cell8 = R37row.getCell(12);
																			if (R37cell8 != null) {
																			   R37cell8.setCellValue(BRF204A.getR53_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR53_gcc_bahrain_aed().intValue());
																			}	

																			Cell R37cell9 = R37row.getCell(13);
																			if (R37cell9 != null) {
																			   R37cell9.setCellValue(BRF204A.getR53_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR53_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R37cell10 = R37row.getCell(14);
																			if (R37cell10 != null) {
																			   R37cell10.setCellValue(BRF204A.getR53_other_aed() == null ? 0 :
																			   	BRF204A.getR53_other_aed().intValue());
																			}	

																			Cell R37cell11 = R37row.getCell(15);
																			if (R37cell11 != null) {
																			   R37cell11.setCellValue(BRF204A.getR53_other_fcy() == null ? 0 :
																			   	BRF204A.getR53_other_fcy().intValue());
																			}	


																			   /////////////R55////////////////////////

																			Row R38row = sheet.getRow(64);
																			   
																			Cell R38cell = R38row.getCell(4);
																			if (R38cell != null) {
																			   R38cell.setCellValue(BRF204A.getR55_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR55_gcc_ksa_aed().intValue());
																			}	

																			Cell R38cell1 = R38row.getCell(5);
																			if (R38cell1 != null) {
																			   R38cell1.setCellValue(BRF204A.getR55_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR55_gcc_ksa_fcy().intValue());
																			}	

																			Cell R38cell2 = R38row.getCell(6);
																			if (R38cell2 != null) {
																			   R38cell2.setCellValue(BRF204A.getR55_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR55_gcc_oman_aed().intValue());
																			}	

																			Cell R38cell3 = R38row.getCell(7);
																			if (R38cell3 != null) {
																			   R38cell3.setCellValue(BRF204A.getR55_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR55_gcc_oman_fcy().intValue());
																			}	

																			Cell R38cell4 = R38row.getCell(8);
																			if (R38cell4 != null) {
																			   R38cell4.setCellValue(BRF204A.getR55_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR55_gcc_kuwait_aed().intValue());
																			}	

																			Cell R38cell5 = R38row.getCell(9);
																			if (R38cell5 != null) {
																			   R38cell5.setCellValue(BRF204A.getR55_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR55_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R38cell6 = R38row.getCell(10);
																			if (R38cell6 != null) {
																			   R38cell6.setCellValue(BRF204A.getR55_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR55_gcc_qatar_aed().intValue());
																			}	

																			Cell R38cell7 = R38row.getCell(11);
																			if (R38cell7 != null) {
																			   R38cell7.setCellValue(BRF204A.getR55_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR55_gcc_qatar_fcy().intValue());
																			}	

																			Cell R38cell8 = R38row.getCell(12);
																			if (R38cell8 != null) {
																			   R38cell8.setCellValue(BRF204A.getR55_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR55_gcc_bahrain_aed().intValue());
																			}	

																			Cell R38cell9 = R38row.getCell(13);
																			if (R38cell9 != null) {
																			   R38cell9.setCellValue(BRF204A.getR55_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR55_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R38cell10 = R38row.getCell(14);
																			if (R38cell10 != null) {
																			   R38cell10.setCellValue(BRF204A.getR55_other_aed() == null ? 0 :
																			   	BRF204A.getR55_other_aed().intValue());
																			}	

																			Cell R38cell11 = R38row.getCell(15);
																			if (R38cell11 != null) {
																			   R38cell11.setCellValue(BRF204A.getR55_other_fcy() == null ? 0 :
																			   	BRF204A.getR55_other_fcy().intValue());
																			}	



																			   /////////////R56////////////////////////

																			Row R39row = sheet.getRow(65);
																			   
																			Cell R39cell = R39row.getCell(4);
																			if (R39cell != null) {
																			   R39cell.setCellValue(BRF204A.getR56_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR56_gcc_ksa_aed().intValue());
																			}	

																			Cell R39cell1 = R39row.getCell(5);
																			if (R39cell1 != null) {
																			   R39cell1.setCellValue(BRF204A.getR56_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR56_gcc_ksa_fcy().intValue());
																			}	

																			Cell R39cell2 = R39row.getCell(6);
																			if (R39cell2 != null) {
																			   R39cell2.setCellValue(BRF204A.getR56_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR56_gcc_oman_aed().intValue());
																			}	

																			Cell R39cell3 = R39row.getCell(7);
																			if (R39cell3 != null) {
																			   R39cell3.setCellValue(BRF204A.getR56_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR56_gcc_oman_fcy().intValue());
																			}	

																			Cell R39cell4 = R39row.getCell(8);
																			if (R39cell4 != null) {
																			   R39cell4.setCellValue(BRF204A.getR56_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR56_gcc_kuwait_aed().intValue());
																			}	

																			Cell R39cell5 = R39row.getCell(9);
																			if (R39cell5 != null) {
																			   R39cell5.setCellValue(BRF204A.getR56_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR56_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R39cell6 = R39row.getCell(10);
																			if (R39cell6 != null) {
																			   R39cell6.setCellValue(BRF204A.getR56_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR56_gcc_qatar_aed().intValue());
																			}	

																			Cell R39cell7 = R39row.getCell(11);
																			if (R39cell7 != null) {
																			   R39cell7.setCellValue(BRF204A.getR56_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR56_gcc_qatar_fcy().intValue());
																			}	

																			Cell R39cell8 = R39row.getCell(12);
																			if (R39cell8 != null) {
																			   R39cell8.setCellValue(BRF204A.getR56_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR56_gcc_bahrain_aed().intValue());
																			}	

																			Cell R39cell9 = R39row.getCell(13);
																			if (R39cell9 != null) {
																			   R39cell9.setCellValue(BRF204A.getR56_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR56_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R39cell10 = R39row.getCell(14);
																			if (R39cell10 != null) {
																			   R39cell10.setCellValue(BRF204A.getR56_other_aed() == null ? 0 :
																			   	BRF204A.getR56_other_aed().intValue());
																			}	

																			Cell R39cell11 = R39row.getCell(15);
																			if (R39cell11 != null) {
																			   R39cell11.setCellValue(BRF204A.getR56_other_fcy() == null ? 0 :
																			   	BRF204A.getR56_other_fcy().intValue());
																			}	



																			   /////////////R57////////////////////////

																			Row R40row = sheet.getRow(66);
																			   
																			Cell R40cell = R40row.getCell(4);
																			if (R40cell != null) {
																			   R40cell.setCellValue(BRF204A.getR57_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR57_gcc_ksa_aed().intValue());
																			}	

																			Cell R40cell1 = R40row.getCell(5);
																			if (R40cell1 != null) {
																			   R40cell1.setCellValue(BRF204A.getR57_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR57_gcc_ksa_fcy().intValue());
																			}	

																			Cell R40cell2 = R40row.getCell(6);
																			if (R40cell2 != null) {
																			   R40cell2.setCellValue(BRF204A.getR57_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR57_gcc_oman_aed().intValue());
																			}	

																			Cell R40cell3 = R40row.getCell(7);
																			if (R40cell3 != null) {
																			   R40cell3.setCellValue(BRF204A.getR57_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR57_gcc_oman_fcy().intValue());
																			}	

																			Cell R40cell4 = R40row.getCell(8);
																			if (R40cell4 != null) {
																			   R40cell4.setCellValue(BRF204A.getR57_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR57_gcc_kuwait_aed().intValue());
																			}	

																			Cell R40cell5 = R40row.getCell(9);
																			if (R40cell5 != null) {
																			   R40cell5.setCellValue(BRF204A.getR57_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR57_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R40cell6 = R40row.getCell(10);
																			if (R40cell6 != null) {
																			   R40cell6.setCellValue(BRF204A.getR57_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR57_gcc_qatar_aed().intValue());
																			}	

																			Cell R40cell7 = R40row.getCell(11);
																			if (R40cell7 != null) {
																			   R40cell7.setCellValue(BRF204A.getR57_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR57_gcc_qatar_fcy().intValue());
																			}	

																			Cell R40cell8 = R40row.getCell(12);
																			if (R40cell8 != null) {
																			   R40cell8.setCellValue(BRF204A.getR57_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR57_gcc_bahrain_aed().intValue());
																			}	

																			Cell R40cell9 = R40row.getCell(13);
																			if (R40cell9 != null) {
																			   R40cell9.setCellValue(BRF204A.getR57_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR57_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R40cell10 = R40row.getCell(14);
																			if (R40cell10 != null) {
																			   R40cell10.setCellValue(BRF204A.getR57_other_aed() == null ? 0 :
																			   	BRF204A.getR57_other_aed().intValue());
																			}	

																			Cell R40cell11 = R40row.getCell(15);
																			if (R40cell11 != null) {
																			   R40cell11.setCellValue(BRF204A.getR57_other_fcy() == null ? 0 :
																			   	BRF204A.getR57_other_fcy().intValue());
																			}	



																			   /////////////R58////////////////////////

																			Row R41row = sheet.getRow(67);
																			   
																			Cell R41cell = R41row.getCell(4);
																			if (R41cell != null) {
																			   R41cell.setCellValue(BRF204A.getR58_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR58_gcc_ksa_aed().intValue());
																			}	

																			Cell R41cell1 = R41row.getCell(5);
																			if (R41cell1 != null) {
																			   R41cell1.setCellValue(BRF204A.getR58_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR58_gcc_ksa_fcy().intValue());
																			}	

																			Cell R41cell2 = R41row.getCell(6);
																			if (R41cell2 != null) {
																			   R41cell2.setCellValue(BRF204A.getR58_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR58_gcc_oman_aed().intValue());
																			}	

																			Cell R41cell3 = R41row.getCell(7);
																			if (R41cell3 != null) {
																			   R41cell3.setCellValue(BRF204A.getR58_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR58_gcc_oman_fcy().intValue());
																			}	

																			Cell R41cell4 = R41row.getCell(8);
																			if (R41cell4 != null) {
																			   R41cell4.setCellValue(BRF204A.getR58_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR58_gcc_kuwait_aed().intValue());
																			}	

																			Cell R41cell5 = R41row.getCell(9);
																			if (R41cell5 != null) {
																			   R41cell5.setCellValue(BRF204A.getR58_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR58_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R41cell6 = R41row.getCell(10);
																			if (R41cell6 != null) {
																			   R41cell6.setCellValue(BRF204A.getR58_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR58_gcc_qatar_aed().intValue());
																			}	

																			Cell R41cell7 = R41row.getCell(11);
																			if (R41cell7 != null) {
																			   R41cell7.setCellValue(BRF204A.getR58_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR58_gcc_qatar_fcy().intValue());
																			}	

																			Cell R41cell8 = R41row.getCell(12);
																			if (R41cell8 != null) {
																			   R41cell8.setCellValue(BRF204A.getR58_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR58_gcc_bahrain_aed().intValue());
																			}	

																			Cell R41cell9 = R41row.getCell(13);
																			if (R41cell9 != null) {
																			   R41cell9.setCellValue(BRF204A.getR58_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR58_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R41cell10 = R41row.getCell(14);
																			if (R41cell10 != null) {
																			   R41cell10.setCellValue(BRF204A.getR58_other_aed() == null ? 0 :
																			   	BRF204A.getR58_other_aed().intValue());
																			}	

																			Cell R41cell11 = R41row.getCell(15);
																			if (R41cell11 != null) {
																			   R41cell11.setCellValue(BRF204A.getR58_other_fcy() == null ? 0 :
																			   	BRF204A.getR58_other_fcy().intValue());
																			}	



																			   /////////////R59////////////////////////

																			Row R42row = sheet.getRow(68);
																			   
																			Cell R42cell = R42row.getCell(4);
																			if (R42cell != null) {
																			   R42cell.setCellValue(BRF204A.getR59_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR59_gcc_ksa_aed().intValue());
																			}	

																			Cell R42cell1 = R42row.getCell(5);
																			if (R42cell1 != null) {
																			   R42cell1.setCellValue(BRF204A.getR59_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR59_gcc_ksa_fcy().intValue());
																			}	

																			Cell R42cell2 = R42row.getCell(6);
																			if (R42cell2 != null) {
																			   R42cell2.setCellValue(BRF204A.getR59_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR59_gcc_oman_aed().intValue());
																			}	

																			Cell R42cell3 = R42row.getCell(7);
																			if (R42cell3 != null) {
																			   R42cell3.setCellValue(BRF204A.getR59_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR59_gcc_oman_fcy().intValue());
																			}	

																			Cell R42cell4 = R42row.getCell(8);
																			if (R42cell4 != null) {
																			   R42cell4.setCellValue(BRF204A.getR59_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR59_gcc_kuwait_aed().intValue());
																			}	

																			Cell R42cell5 = R42row.getCell(9);
																			if (R42cell5 != null) {
																			   R42cell5.setCellValue(BRF204A.getR59_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR59_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R42cell6 = R42row.getCell(10);
																			if (R42cell6 != null) {
																			   R42cell6.setCellValue(BRF204A.getR59_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR59_gcc_qatar_aed().intValue());
																			}	

																			Cell R42cell7 = R42row.getCell(11);
																			if (R42cell7 != null) {
																			   R42cell7.setCellValue(BRF204A.getR59_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR59_gcc_qatar_fcy().intValue());
																			}	

																			Cell R42cell8 = R42row.getCell(12);
																			if (R42cell8 != null) {
																			   R42cell8.setCellValue(BRF204A.getR59_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR59_gcc_bahrain_aed().intValue());
																			}	

																			Cell R42cell9 = R42row.getCell(13);
																			if (R42cell9 != null) {
																			   R42cell9.setCellValue(BRF204A.getR59_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR59_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R42cell10 = R42row.getCell(14);
																			if (R42cell10 != null) {
																			   R42cell10.setCellValue(BRF204A.getR59_other_aed() == null ? 0 :
																			   	BRF204A.getR59_other_aed().intValue());
																			}	

																			Cell R42cell11 = R42row.getCell(15);
																			if (R42cell11 != null) {
																			   R42cell11.setCellValue(BRF204A.getR59_other_fcy() == null ? 0 :
																			   	BRF204A.getR59_other_fcy().intValue());
																			}	




																			   /////////////R61////////////////////////

																			Row R43row = sheet.getRow(70);
																			   
																			Cell R43cell = R43row.getCell(4);
																			if (R43cell != null) {
																			   R43cell.setCellValue(BRF204A.getR61_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR61_gcc_ksa_aed().intValue());
																			}	

																			Cell R43cell1 = R43row.getCell(5);
																			if (R43cell1 != null) {
																			   R43cell1.setCellValue(BRF204A.getR61_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR61_gcc_ksa_fcy().intValue());
																			}	

																			Cell R43cell2 = R43row.getCell(6);
																			if (R43cell2 != null) {
																			   R43cell2.setCellValue(BRF204A.getR61_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR61_gcc_oman_aed().intValue());
																			}	

																			Cell R43cell3 = R43row.getCell(7);
																			if (R43cell3 != null) {
																			   R43cell3.setCellValue(BRF204A.getR61_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR61_gcc_oman_fcy().intValue());
																			}	

																			Cell R43cell4 = R43row.getCell(8);
																			if (R43cell4 != null) {
																			   R43cell4.setCellValue(BRF204A.getR61_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR61_gcc_kuwait_aed().intValue());
																			}	

																			Cell R43cell5 = R43row.getCell(9);
																			if (R43cell5 != null) {
																			   R43cell5.setCellValue(BRF204A.getR61_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR61_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R43cell6 = R43row.getCell(10);
																			if (R43cell6 != null) {
																			   R43cell6.setCellValue(BRF204A.getR61_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR61_gcc_qatar_aed().intValue());
																			}	

																			Cell R43cell7 = R43row.getCell(11);
																			if (R43cell7 != null) {
																			   R43cell7.setCellValue(BRF204A.getR61_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR61_gcc_qatar_fcy().intValue());
																			}	

																			Cell R43cell8 = R43row.getCell(12);
																			if (R43cell8 != null) {
																			   R43cell8.setCellValue(BRF204A.getR61_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR61_gcc_bahrain_aed().intValue());
																			}	

																			Cell R43cell9 = R43row.getCell(13);
																			if (R43cell9 != null) {
																			   R43cell9.setCellValue(BRF204A.getR61_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR61_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R43cell10 = R43row.getCell(14);
																			if (R43cell10 != null) {
																			   R43cell10.setCellValue(BRF204A.getR61_other_aed() == null ? 0 :
																			   	BRF204A.getR61_other_aed().intValue());
																			}	

																			Cell R43cell11 = R43row.getCell(15);
																			if (R43cell11 != null) {
																			   R43cell11.setCellValue(BRF204A.getR61_other_fcy() == null ? 0 :
																			   	BRF204A.getR61_other_fcy().intValue());
																			}	



																			   /////////////R62////////////////////////

																			Row R44row = sheet.getRow(71);
																			   
																			Cell R44cell = R44row.getCell(4);
																			if (R44cell != null) {
																			   R44cell.setCellValue(BRF204A.getR62_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR62_gcc_ksa_aed().intValue());
																			}	

																			Cell R44cell1 = R44row.getCell(5);
																			if (R44cell1 != null) {
																			   R44cell1.setCellValue(BRF204A.getR62_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR62_gcc_ksa_fcy().intValue());
																			}	

																			Cell R44cell2 = R44row.getCell(6);
																			if (R44cell2 != null) {
																			   R44cell2.setCellValue(BRF204A.getR62_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR62_gcc_oman_aed().intValue());
																			}	

																			Cell R44cell3 = R44row.getCell(7);
																			if (R44cell3 != null) {
																			   R44cell3.setCellValue(BRF204A.getR62_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR62_gcc_oman_fcy().intValue());
																			}	

																			Cell R44cell4 = R44row.getCell(8);
																			if (R44cell4 != null) {
																			   R44cell4.setCellValue(BRF204A.getR62_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR62_gcc_kuwait_aed().intValue());
																			}	

																			Cell R44cell5 = R44row.getCell(9);
																			if (R44cell5 != null) {
																			   R44cell5.setCellValue(BRF204A.getR62_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR62_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R44cell6 = R44row.getCell(10);
																			if (R44cell6 != null) {
																			   R44cell6.setCellValue(BRF204A.getR62_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR62_gcc_qatar_aed().intValue());
																			}	

																			Cell R44cell7 = R44row.getCell(11);
																			if (R44cell7 != null) {
																			   R44cell7.setCellValue(BRF204A.getR62_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR62_gcc_qatar_fcy().intValue());
																			}	

																			Cell R44cell8 = R44row.getCell(12);
																			if (R44cell8 != null) {
																			   R44cell8.setCellValue(BRF204A.getR62_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR62_gcc_bahrain_aed().intValue());
																			}	

																			Cell R44cell9 = R44row.getCell(13);
																			if (R44cell9 != null) {
																			   R44cell9.setCellValue(BRF204A.getR62_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR62_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R44cell10 = R44row.getCell(14);
																			if (R44cell10 != null) {
																			   R44cell10.setCellValue(BRF204A.getR62_other_aed() == null ? 0 :
																			   	BRF204A.getR62_other_aed().intValue());
																			}	

																			Cell R44cell11 = R44row.getCell(15);
																			if (R44cell11 != null) {
																			   R44cell11.setCellValue(BRF204A.getR62_other_fcy() == null ? 0 :
																			   	BRF204A.getR62_other_fcy().intValue());
																			}	





														
																			
																			   /////////////R63////////////////////////

																			Row R45row = sheet.getRow(72);
																			   
																			Cell R45cell = R45row.getCell(4);
																			if (R45cell != null) {
																			   R45cell.setCellValue(BRF204A.getR63_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR63_gcc_ksa_aed().intValue());
																			}	

																			Cell R45cell1 = R45row.getCell(5);
																			if (R45cell1 != null) {
																			   R45cell1.setCellValue(BRF204A.getR63_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR63_gcc_ksa_fcy().intValue());
																			}	

																			Cell R45cell2 = R45row.getCell(6);
																			if (R45cell2 != null) {
																			   R45cell2.setCellValue(BRF204A.getR63_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR63_gcc_oman_aed().intValue());
																			}	

																			Cell R45cell3 = R45row.getCell(7);
																			if (R45cell3 != null) {
																			   R45cell3.setCellValue(BRF204A.getR63_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR63_gcc_oman_fcy().intValue());
																			}	

																			Cell R45cell4 = R45row.getCell(8);
																			if (R45cell4 != null) {
																			   R45cell4.setCellValue(BRF204A.getR63_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR63_gcc_kuwait_aed().intValue());
																			}	

																			Cell R45cell5 = R45row.getCell(9);
																			if (R45cell5 != null) {
																			   R45cell5.setCellValue(BRF204A.getR63_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR63_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R45cell6 = R45row.getCell(10);
																			if (R45cell6 != null) {
																			   R45cell6.setCellValue(BRF204A.getR63_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR63_gcc_qatar_aed().intValue());
																			}	

																			Cell R45cell7 = R45row.getCell(11);
																			if (R45cell7 != null) {
																			   R45cell7.setCellValue(BRF204A.getR63_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR63_gcc_qatar_fcy().intValue());
																			}	

																			Cell R45cell8 = R45row.getCell(12);
																			if (R45cell8 != null) {
																			   R45cell8.setCellValue(BRF204A.getR63_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR63_gcc_bahrain_aed().intValue());
																			}	

																			Cell R45cell9 = R45row.getCell(13);
																			if (R45cell9 != null) {
																			   R45cell9.setCellValue(BRF204A.getR63_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR63_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R45cell10 = R45row.getCell(14);
																			if (R45cell10 != null) {
																			   R45cell10.setCellValue(BRF204A.getR63_other_aed() == null ? 0 :
																			   	BRF204A.getR63_other_aed().intValue());
																			}	

																			Cell R45cell11 = R45row.getCell(15);
																			if (R45cell11 != null) {
																			   R45cell11.setCellValue(BRF204A.getR63_other_fcy() == null ? 0 :
																			   	BRF204A.getR63_other_fcy().intValue());
																			}	

																			
																			   /////////////R64////////////////////////

																			Row R46row = sheet.getRow(73);
																			   
																			Cell R46cell = R46row.getCell(4);
																			if (R46cell != null) {
																			   R46cell.setCellValue(BRF204A.getR64_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR64_gcc_ksa_aed().intValue());
																			}	

																			Cell R46cell1 = R46row.getCell(5);
																			if (R46cell1 != null) {
																			   R46cell1.setCellValue(BRF204A.getR64_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR64_gcc_ksa_fcy().intValue());
																			}	

																			Cell R46cell2 = R46row.getCell(6);
																			if (R46cell2 != null) {
																			   R46cell2.setCellValue(BRF204A.getR64_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR64_gcc_oman_aed().intValue());
																			}	

																			Cell R46cell3 = R46row.getCell(7);
																			if (R46cell3 != null) {
																			   R46cell3.setCellValue(BRF204A.getR64_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR64_gcc_oman_fcy().intValue());
																			}	

																			Cell R46cell4 = R46row.getCell(8);
																			if (R46cell4 != null) {
																			   R46cell4.setCellValue(BRF204A.getR64_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR64_gcc_kuwait_aed().intValue());
																			}	

																			Cell R46cell5 = R46row.getCell(9);
																			if (R46cell5 != null) {
																			   R46cell5.setCellValue(BRF204A.getR64_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR64_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R46cell6 = R46row.getCell(10);
																			if (R46cell6 != null) {
																			   R46cell6.setCellValue(BRF204A.getR64_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR64_gcc_qatar_aed().intValue());
																			}	

																			Cell R46cell7 = R46row.getCell(11);
																			if (R46cell7 != null) {
																			   R46cell7.setCellValue(BRF204A.getR64_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR64_gcc_qatar_fcy().intValue());
																			}	

																			Cell R46cell8 = R46row.getCell(12);
																			if (R46cell8 != null) {
																			   R46cell8.setCellValue(BRF204A.getR64_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR64_gcc_bahrain_aed().intValue());
																			}	

																			Cell R46cell9 = R46row.getCell(13);
																			if (R46cell9 != null) {
																			   R46cell9.setCellValue(BRF204A.getR64_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR64_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R46cell10 = R46row.getCell(14);
																			if (R46cell10 != null) {
																			   R46cell10.setCellValue(BRF204A.getR64_other_aed() == null ? 0 :
																			   	BRF204A.getR64_other_aed().intValue());
																			}	

																			Cell R46cell11 = R46row.getCell(15);
																			if (R46cell11 != null) {
																			   R46cell11.setCellValue(BRF204A.getR64_other_fcy() == null ? 0 :
																			   	BRF204A.getR64_other_fcy().intValue());
																			}	



																			   /////////////R65////////////////////////

																			Row R47row = sheet.getRow(74);
																			   
																			Cell R47cell = R47row.getCell(4);
																			if (R47cell != null) {
																			   R47cell.setCellValue(BRF204A.getR65_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR65_gcc_ksa_aed().intValue());
																			}	

																			Cell R47cell1 = R47row.getCell(5);
																			if (R47cell1 != null) {
																			   R47cell1.setCellValue(BRF204A.getR65_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR65_gcc_ksa_fcy().intValue());
																			}	

																			Cell R47cell2 = R47row.getCell(6);
																			if (R47cell2 != null) {
																			   R47cell2.setCellValue(BRF204A.getR65_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR65_gcc_oman_aed().intValue());
																			}	

																			Cell R47cell3 = R47row.getCell(7);
																			if (R47cell3 != null) {
																			   R47cell3.setCellValue(BRF204A.getR65_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR65_gcc_oman_fcy().intValue());
																			}	

																			Cell R47cell4 = R47row.getCell(8);
																			if (R47cell4 != null) {
																			   R47cell4.setCellValue(BRF204A.getR65_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR65_gcc_kuwait_aed().intValue());
																			}	

																			Cell R47cell5 = R47row.getCell(9);
																			if (R47cell5 != null) {
																			   R47cell5.setCellValue(BRF204A.getR65_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR65_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R47cell6 = R47row.getCell(10);
																			if (R47cell6 != null) {
																			   R47cell6.setCellValue(BRF204A.getR65_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR65_gcc_qatar_aed().intValue());
																			}	

																			Cell R47cell7 = R47row.getCell(11);
																			if (R47cell7 != null) {
																			   R47cell7.setCellValue(BRF204A.getR65_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR65_gcc_qatar_fcy().intValue());
																			}	

																			Cell R47cell8 = R47row.getCell(12);
																			if (R47cell8 != null) {
																			   R47cell8.setCellValue(BRF204A.getR65_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR65_gcc_bahrain_aed().intValue());
																			}	

																			Cell R47cell9 = R47row.getCell(13);
																			if (R47cell9 != null) {
																			   R47cell9.setCellValue(BRF204A.getR65_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR65_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R47cell10 = R47row.getCell(14);
																			if (R47cell10 != null) {
																			   R47cell10.setCellValue(BRF204A.getR65_other_aed() == null ? 0 :
																			   	BRF204A.getR65_other_aed().intValue());
																			}	

																			Cell R47cell11 = R47row.getCell(15);
																			if (R47cell11 != null) {
																			   R47cell11.setCellValue(BRF204A.getR65_other_fcy() == null ? 0 :
																			   	BRF204A.getR65_other_fcy().intValue());
																			}	



																			   /////////////R66////////////////////////

																			Row R48row = sheet.getRow(75);
																			   
																			Cell R48cell = R48row.getCell(4);
																			if (R48cell != null) {
																			   R48cell.setCellValue(BRF204A.getR66_gcc_ksa_aed() == null ? 0 :
																			   	BRF204A.getR66_gcc_ksa_aed().intValue());
																			}	

																			Cell R48cell1 = R48row.getCell(5);
																			if (R48cell1 != null) {
																			   R48cell1.setCellValue(BRF204A.getR66_gcc_ksa_fcy() == null ? 0 :
																			   	BRF204A.getR66_gcc_ksa_fcy().intValue());
																			}	

																			Cell R48cell2 = R48row.getCell(6);
																			if (R48cell2 != null) {
																			   R48cell2.setCellValue(BRF204A.getR66_gcc_oman_aed() == null ? 0 :
																			   	BRF204A.getR66_gcc_oman_aed().intValue());
																			}	

																			Cell R48cell3 = R48row.getCell(7);
																			if (R48cell3 != null) {
																			   R48cell3.setCellValue(BRF204A.getR66_gcc_oman_fcy() == null ? 0 :
																			   	BRF204A.getR66_gcc_oman_fcy().intValue());
																			}	

																			Cell R48cell4 = R48row.getCell(8);
																			if (R48cell4 != null) {
																			   R48cell4.setCellValue(BRF204A.getR66_gcc_kuwait_aed() == null ? 0 :
																			   	BRF204A.getR66_gcc_kuwait_aed().intValue());
																			}	

																			Cell R48cell5 = R48row.getCell(9);
																			if (R48cell5 != null) {
																			   R48cell5.setCellValue(BRF204A.getR66_gcc_kuwait_fcy() == null ? 0 :
																			   	BRF204A.getR66_gcc_kuwait_fcy().intValue());
																			}	

																			Cell R48cell6 = R48row.getCell(10);
																			if (R48cell6 != null) {
																			   R48cell6.setCellValue(BRF204A.getR66_gcc_qatar_aed() == null ? 0 :
																			   	BRF204A.getR66_gcc_qatar_aed().intValue());
																			}	

																			Cell R48cell7 = R48row.getCell(11);
																			if (R48cell7 != null) {
																			   R48cell7.setCellValue(BRF204A.getR66_gcc_qatar_fcy() == null ? 0 :
																			   	BRF204A.getR66_gcc_qatar_fcy().intValue());
																			}	

																			Cell R48cell8 = R48row.getCell(12);
																			if (R48cell8 != null) {
																			   R48cell8.setCellValue(BRF204A.getR66_gcc_bahrain_aed() == null ? 0 :
																			   	BRF204A.getR66_gcc_bahrain_aed().intValue());
																			}	

																			Cell R48cell9 = R48row.getCell(13);
																			if (R48cell9 != null) {
																			   R48cell9.setCellValue(BRF204A.getR66_gcc_bahrain_fcy() == null ? 0 :
																			   	BRF204A.getR66_gcc_bahrain_fcy().intValue());
																			}	

																			Cell R48cell10 = R48row.getCell(14);
																			if (R48cell10 != null) {
																			   R48cell10.setCellValue(BRF204A.getR66_other_aed() == null ? 0 :
																			   	BRF204A.getR66_other_aed().intValue());
																			}	

																			Cell R48cell11 = R48row.getCell(15);
																			if (R48cell11 != null) {
																			   R48cell11.setCellValue(BRF204A.getR66_other_fcy() == null ? 0 :
																			   	BRF204A.getR66_other_fcy().intValue());
																			}	
      	 
					       	 

						}
					}
					if (T1Master1.size() == 1) {
						for (BRF204B_ENTITY BRF204B : T1Master1) {
							  /////////////R67////////////////////////

							Row R49row = sheet.getRow(76);
							   
							Cell R49cell = R49row.getCell(4);
							if (R49cell != null) {
							   R49cell.setCellValue(BRF204B.getR67_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR67_gcc_ksa_aed().intValue());
							}	

							Cell R49cell1 = R49row.getCell(5);
							if (R49cell1 != null) {
							   R49cell1.setCellValue(BRF204B.getR67_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR67_gcc_ksa_fcy().intValue());
							}	

							Cell R49cell2 = R49row.getCell(6);
							if (R49cell2 != null) {
							   R49cell2.setCellValue(BRF204B.getR67_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR67_gcc_oman_aed().intValue());
							}	

							Cell R49cell3 = R49row.getCell(7);
							if (R49cell3 != null) {
							   R49cell3.setCellValue(BRF204B.getR67_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR67_gcc_oman_fcy().intValue());
							}	

							Cell R49cell4 = R49row.getCell(8);
							if (R49cell4 != null) {
							   R49cell4.setCellValue(BRF204B.getR67_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR67_gcc_kuwait_aed().intValue());
							}	

							Cell R49cell5 = R49row.getCell(9);
							if (R49cell5 != null) {
							   R49cell5.setCellValue(BRF204B.getR67_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR67_gcc_kuwait_fcy().intValue());
							}	

							Cell R49cell6 = R49row.getCell(10);
							if (R49cell6 != null) {
							   R49cell6.setCellValue(BRF204B.getR67_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR67_gcc_qatar_aed().intValue());
							}	

							Cell R49cell7 = R49row.getCell(11);
							if (R49cell7 != null) {
							   R49cell7.setCellValue(BRF204B.getR67_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR67_gcc_qatar_fcy().intValue());
							}	

							Cell R49cell8 = R49row.getCell(12);
							if (R49cell8 != null) {
							   R49cell8.setCellValue(BRF204B.getR67_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR67_gcc_bahrain_aed().intValue());
							}	

							Cell R49cell9 = R49row.getCell(13);
							if (R49cell9 != null) {
							   R49cell9.setCellValue(BRF204B.getR67_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR67_gcc_bahrain_fcy().intValue());
							}	

							Cell R49cell10 = R49row.getCell(14);
							if (R49cell10 != null) {
							   R49cell10.setCellValue(BRF204B.getR67_other_aed() == null ? 0 :
							   	BRF204B.getR67_other_aed().intValue());
							}	

							Cell R49cell11 = R49row.getCell(15);
							if (R49cell11 != null) {
							   R49cell11.setCellValue(BRF204B.getR67_other_fcy() == null ? 0 :
							   	BRF204B.getR67_other_fcy().intValue());
							}	


							   /////////////R68////////////////////////

							Row R50row = sheet.getRow(77);
							   
							Cell R50cell = R50row.getCell(4);
							if (R50cell != null) {
							   R50cell.setCellValue(BRF204B.getR68_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR68_gcc_ksa_aed().intValue());
							}	

							Cell R50cell1 = R50row.getCell(5);
							if (R50cell1 != null) {
							   R50cell1.setCellValue(BRF204B.getR68_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR68_gcc_ksa_fcy().intValue());
							}	

							Cell R50cell2 = R50row.getCell(6);
							if (R50cell2 != null) {
							   R50cell2.setCellValue(BRF204B.getR68_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR68_gcc_oman_aed().intValue());
							}	

							Cell R50cell3 = R50row.getCell(7);
							if (R50cell3 != null) {
							   R50cell3.setCellValue(BRF204B.getR68_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR68_gcc_oman_fcy().intValue());
							}	

							Cell R50cell4 = R50row.getCell(8);
							if (R50cell4 != null) {
							   R50cell4.setCellValue(BRF204B.getR68_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR68_gcc_kuwait_aed().intValue());
							}	

							Cell R50cell5 = R50row.getCell(9);
							if (R50cell5 != null) {
							   R50cell5.setCellValue(BRF204B.getR68_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR68_gcc_kuwait_fcy().intValue());
							}	

							Cell R50cell6 = R50row.getCell(10);
							if (R50cell6 != null) {
							   R50cell6.setCellValue(BRF204B.getR68_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR68_gcc_qatar_aed().intValue());
							}	

							Cell R50cell7 = R50row.getCell(11);
							if (R50cell7 != null) {
							   R50cell7.setCellValue(BRF204B.getR68_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR68_gcc_qatar_fcy().intValue());
							}	

							Cell R50cell8 = R50row.getCell(12);
							if (R50cell8 != null) {
							   R50cell8.setCellValue(BRF204B.getR68_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR68_gcc_bahrain_aed().intValue());
							}	

							Cell R50cell9 = R50row.getCell(13);
							if (R50cell9 != null) {
							   R50cell9.setCellValue(BRF204B.getR68_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR68_gcc_bahrain_fcy().intValue());
							}	

							Cell R50cell10 = R50row.getCell(14);
							if (R50cell10 != null) {
							   R50cell10.setCellValue(BRF204B.getR68_other_aed() == null ? 0 :
							   	BRF204B.getR68_other_aed().intValue());
							}	

							Cell R50cell11 = R50row.getCell(15);
							if (R50cell11 != null) {
							   R50cell11.setCellValue(BRF204B.getR68_other_fcy() == null ? 0 :
							   	BRF204B.getR68_other_fcy().intValue());
							}	



							   /////////////R70////////////////////////

							Row R51row = sheet.getRow(79);
							   
							Cell R51cell = R51row.getCell(4);
							if (R51cell != null) {
							   R51cell.setCellValue(BRF204B.getR70_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR70_gcc_ksa_aed().intValue());
							}	

							Cell R51cell1 = R51row.getCell(5);
							if (R51cell1 != null) {
							   R51cell1.setCellValue(BRF204B.getR70_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR70_gcc_ksa_fcy().intValue());
							}	

							Cell R51cell2 = R51row.getCell(6);
							if (R51cell2 != null) {
							   R51cell2.setCellValue(BRF204B.getR70_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR70_gcc_oman_aed().intValue());
							}	

							Cell R51cell3 = R51row.getCell(7);
							if (R51cell3 != null) {
							   R51cell3.setCellValue(BRF204B.getR70_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR70_gcc_oman_fcy().intValue());
							}	

							Cell R51cell4 = R51row.getCell(8);
							if (R51cell4 != null) {
							   R51cell4.setCellValue(BRF204B.getR70_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR70_gcc_kuwait_aed().intValue());
							}	

							Cell R51cell5 = R51row.getCell(9);
							if (R51cell5 != null) {
							   R51cell5.setCellValue(BRF204B.getR70_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR70_gcc_kuwait_fcy().intValue());
							}	

							Cell R51cell6 = R51row.getCell(10);
							if (R51cell6 != null) {
							   R51cell6.setCellValue(BRF204B.getR70_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR70_gcc_qatar_aed().intValue());
							}	

							Cell R51cell7 = R51row.getCell(11);
							if (R51cell7 != null) {
							   R51cell7.setCellValue(BRF204B.getR70_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR70_gcc_qatar_fcy().intValue());
							}	

							Cell R51cell8 = R51row.getCell(12);
							if (R51cell8 != null) {
							   R51cell8.setCellValue(BRF204B.getR70_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR70_gcc_bahrain_aed().intValue());
							}	

							Cell R51cell9 = R51row.getCell(13);
							if (R51cell9 != null) {
							   R51cell9.setCellValue(BRF204B.getR70_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR70_gcc_bahrain_fcy().intValue());
							}	

							Cell R51cell10 = R51row.getCell(14);
							if (R51cell10 != null) {
							   R51cell10.setCellValue(BRF204B.getR70_other_aed() == null ? 0 :
							   	BRF204B.getR70_other_aed().intValue());
							}	

							Cell R51cell11 = R51row.getCell(15);
							if (R51cell11 != null) {
							   R51cell11.setCellValue(BRF204B.getR70_other_fcy() == null ? 0 :
							   	BRF204B.getR70_other_fcy().intValue());
							}	



							   /////////////R71////////////////////////

							Row R52row = sheet.getRow(80);
							   
							Cell R52cell = R52row.getCell(4);
							if (R52cell != null) {
							   R52cell.setCellValue(BRF204B.getR71_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR71_gcc_ksa_aed().intValue());
							}	

							Cell R52cell1 = R52row.getCell(5);
							if (R52cell1 != null) {
							   R52cell1.setCellValue(BRF204B.getR71_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR71_gcc_ksa_fcy().intValue());
							}	

							Cell R52cell2 = R52row.getCell(6);
							if (R52cell2 != null) {
							   R52cell2.setCellValue(BRF204B.getR71_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR71_gcc_oman_aed().intValue());
							}	

							Cell R52cell3 = R52row.getCell(7);
							if (R52cell3 != null) {
							   R52cell3.setCellValue(BRF204B.getR71_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR71_gcc_oman_fcy().intValue());
							}	

							Cell R52cell4 = R52row.getCell(8);
							if (R52cell4 != null) {
							   R52cell4.setCellValue(BRF204B.getR71_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR71_gcc_kuwait_aed().intValue());
							}	

							Cell R52cell5 = R52row.getCell(9);
							if (R52cell5 != null) {
							   R52cell5.setCellValue(BRF204B.getR71_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR71_gcc_kuwait_fcy().intValue());
							}	

							Cell R52cell6 = R52row.getCell(10);
							if (R52cell6 != null) {
							   R52cell6.setCellValue(BRF204B.getR71_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR71_gcc_qatar_aed().intValue());
							}	

							Cell R52cell7 = R52row.getCell(11);
							if (R52cell7 != null) {
							   R52cell7.setCellValue(BRF204B.getR71_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR71_gcc_qatar_fcy().intValue());
							}	

							Cell R52cell8 = R52row.getCell(12);
							if (R52cell8 != null) {
							   R52cell8.setCellValue(BRF204B.getR71_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR71_gcc_bahrain_aed().intValue());
							}	

							Cell R52cell9 = R52row.getCell(13);
							if (R52cell9 != null) {
							   R52cell9.setCellValue(BRF204B.getR71_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR71_gcc_bahrain_fcy().intValue());
							}	

							Cell R52cell10 = R52row.getCell(14);
							if (R52cell10 != null) {
							   R52cell10.setCellValue(BRF204B.getR71_other_aed() == null ? 0 :
							   	BRF204B.getR71_other_aed().intValue());
							}	

							Cell R52cell11 = R52row.getCell(15);
							if (R52cell11 != null) {
							   R52cell11.setCellValue(BRF204B.getR71_other_fcy() == null ? 0 :
							   	BRF204B.getR71_other_fcy().intValue());
							}	



							   /////////////R72////////////////////////

							Row R53row = sheet.getRow(81);
							   
							Cell R53cell = R53row.getCell(4);
							if (R53cell != null) {
							   R53cell.setCellValue(BRF204B.getR72_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR72_gcc_ksa_aed().intValue());
							}	

							Cell R53cell1 = R53row.getCell(5);
							if (R53cell1 != null) {
							   R53cell1.setCellValue(BRF204B.getR72_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR72_gcc_ksa_fcy().intValue());
							}	

							Cell R53cell2 = R53row.getCell(6);
							if (R53cell2 != null) {
							   R53cell2.setCellValue(BRF204B.getR72_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR72_gcc_oman_aed().intValue());
							}	

							Cell R53cell3 = R53row.getCell(7);
							if (R53cell3 != null) {
							   R53cell3.setCellValue(BRF204B.getR72_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR72_gcc_oman_fcy().intValue());
							}	

							Cell R53cell4 = R53row.getCell(8);
							if (R53cell4 != null) {
							   R53cell4.setCellValue(BRF204B.getR72_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR72_gcc_kuwait_aed().intValue());
							}	

							Cell R53cell5 = R53row.getCell(9);
							if (R53cell5 != null) {
							   R53cell5.setCellValue(BRF204B.getR72_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR72_gcc_kuwait_fcy().intValue());
							}	

							Cell R53cell6 = R53row.getCell(10);
							if (R53cell6 != null) {
							   R53cell6.setCellValue(BRF204B.getR72_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR72_gcc_qatar_aed().intValue());
							}	

							Cell R53cell7 = R53row.getCell(11);
							if (R53cell7 != null) {
							   R53cell7.setCellValue(BRF204B.getR72_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR72_gcc_qatar_fcy().intValue());
							}	

							Cell R53cell8 = R53row.getCell(12);
							if (R53cell8 != null) {
							   R53cell8.setCellValue(BRF204B.getR72_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR72_gcc_bahrain_aed().intValue());
							}	

							Cell R53cell9 = R53row.getCell(13);
							if (R53cell9 != null) {
							   R53cell9.setCellValue(BRF204B.getR72_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR72_gcc_bahrain_fcy().intValue());
							}	

							Cell R53cell10 = R53row.getCell(14);
							if (R53cell10 != null) {
							   R53cell10.setCellValue(BRF204B.getR72_other_aed() == null ? 0 :
							   	BRF204B.getR72_other_aed().intValue());
							}	

							Cell R53cell11 = R53row.getCell(15);
							if (R53cell11 != null) {
							   R53cell11.setCellValue(BRF204B.getR72_other_fcy() == null ? 0 :
							   	BRF204B.getR72_other_fcy().intValue());
							}	



							   /////////////R73////////////////////////

							Row R54row = sheet.getRow(82);
							   
							Cell R54cell = R54row.getCell(4);
							if (R54cell != null) {
							   R54cell.setCellValue(BRF204B.getR73_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR73_gcc_ksa_aed().intValue());
							}	

							Cell R54cell1 = R54row.getCell(5);
							if (R54cell1 != null) {
							   R54cell1.setCellValue(BRF204B.getR73_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR73_gcc_ksa_fcy().intValue());
							}	

							Cell R54cell2 = R54row.getCell(6);
							if (R54cell2 != null) {
							   R54cell2.setCellValue(BRF204B.getR73_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR73_gcc_oman_aed().intValue());
							}	

							Cell R54cell3 = R54row.getCell(7);
							if (R54cell3 != null) {
							   R54cell3.setCellValue(BRF204B.getR73_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR73_gcc_oman_fcy().intValue());
							}	

							Cell R54cell4 = R54row.getCell(8);
							if (R54cell4 != null) {
							   R54cell4.setCellValue(BRF204B.getR73_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR73_gcc_kuwait_aed().intValue());
							}	

							Cell R54cell5 = R54row.getCell(9);
							if (R54cell5 != null) {
							   R54cell5.setCellValue(BRF204B.getR73_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR73_gcc_kuwait_fcy().intValue());
							}	

							Cell R54cell6 = R54row.getCell(10);
							if (R54cell6 != null) {
							   R54cell6.setCellValue(BRF204B.getR73_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR73_gcc_qatar_aed().intValue());
							}	

							Cell R54cell7 = R54row.getCell(11);
							if (R54cell7 != null) {
							   R54cell7.setCellValue(BRF204B.getR73_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR73_gcc_qatar_fcy().intValue());
							}	

							Cell R54cell8 = R54row.getCell(12);
							if (R54cell8 != null) {
							   R54cell8.setCellValue(BRF204B.getR73_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR73_gcc_bahrain_aed().intValue());
							}	

							Cell R54cell9 = R54row.getCell(13);
							if (R54cell9 != null) {
							   R54cell9.setCellValue(BRF204B.getR73_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR73_gcc_bahrain_fcy().intValue());
							}	

							Cell R54cell10 = R54row.getCell(14);
							if (R54cell10 != null) {
							   R54cell10.setCellValue(BRF204B.getR73_other_aed() == null ? 0 :
							   	BRF204B.getR73_other_aed().intValue());
							}	

							Cell R54cell11 = R54row.getCell(15);
							if (R54cell11 != null) {
							   R54cell11.setCellValue(BRF204B.getR73_other_fcy() == null ? 0 :
							   	BRF204B.getR73_other_fcy().intValue());
							}	



							   /////////////R74////////////////////////

							Row R55row = sheet.getRow(83);
							   
							Cell R55cell = R55row.getCell(4);
							if (R55cell != null) {
							   R55cell.setCellValue(BRF204B.getR74_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR74_gcc_ksa_aed().intValue());
							}	

							Cell R55cell1 = R55row.getCell(5);
							if (R55cell1 != null) {
							   R55cell1.setCellValue(BRF204B.getR74_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR74_gcc_ksa_fcy().intValue());
							}	

							Cell R55cell2 = R55row.getCell(6);
							if (R55cell2 != null) {
							   R55cell2.setCellValue(BRF204B.getR74_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR74_gcc_oman_aed().intValue());
							}	

							Cell R55cell3 = R55row.getCell(7);
							if (R55cell3 != null) {
							   R55cell3.setCellValue(BRF204B.getR74_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR74_gcc_oman_fcy().intValue());
							}	

							Cell R55cell4 = R55row.getCell(8);
							if (R55cell4 != null) {
							   R55cell4.setCellValue(BRF204B.getR74_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR74_gcc_kuwait_aed().intValue());
							}	

							Cell R55cell5 = R55row.getCell(9);
							if (R55cell5 != null) {
							   R55cell5.setCellValue(BRF204B.getR74_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR74_gcc_kuwait_fcy().intValue());
							}	

							Cell R55cell6 = R55row.getCell(10);
							if (R55cell6 != null) {
							   R55cell6.setCellValue(BRF204B.getR74_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR74_gcc_qatar_aed().intValue());
							}	

							Cell R55cell7 = R55row.getCell(11);
							if (R55cell7 != null) {
							   R55cell7.setCellValue(BRF204B.getR74_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR74_gcc_qatar_fcy().intValue());
							}	

							Cell R55cell8 = R55row.getCell(12);
							if (R55cell8 != null) {
							   R55cell8.setCellValue(BRF204B.getR74_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR74_gcc_bahrain_aed().intValue());
							}	

							Cell R55cell9 = R55row.getCell(13);
							if (R55cell9 != null) {
							   R55cell9.setCellValue(BRF204B.getR74_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR74_gcc_bahrain_fcy().intValue());
							}	

							Cell R55cell10 = R55row.getCell(14);
							if (R55cell10 != null) {
							   R55cell10.setCellValue(BRF204B.getR74_other_aed() == null ? 0 :
							   	BRF204B.getR74_other_aed().intValue());
							}	

							Cell R55cell11 = R55row.getCell(15);
							if (R55cell11 != null) {
							   R55cell11.setCellValue(BRF204B.getR74_other_fcy() == null ? 0 :
							   	BRF204B.getR74_other_fcy().intValue());
							}	



							   /////////////R75////////////////////////

							Row R56row = sheet.getRow(84);
							   
							Cell R56cell = R56row.getCell(4);
							if (R56cell != null) {
							   R56cell.setCellValue(BRF204B.getR75_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR75_gcc_ksa_aed().intValue());
							}	

							Cell R56cell1 = R56row.getCell(5);
							if (R56cell1 != null) {
							   R56cell1.setCellValue(BRF204B.getR75_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR75_gcc_ksa_fcy().intValue());
							}	

							Cell R56cell2 = R56row.getCell(6);
							if (R56cell2 != null) {
							   R56cell2.setCellValue(BRF204B.getR75_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR75_gcc_oman_aed().intValue());
							}	

							Cell R56cell3 = R56row.getCell(7);
							if (R56cell3 != null) {
							   R56cell3.setCellValue(BRF204B.getR75_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR75_gcc_oman_fcy().intValue());
							}	

							Cell R56cell4 = R56row.getCell(8);
							if (R56cell4 != null) {
							   R56cell4.setCellValue(BRF204B.getR75_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR75_gcc_kuwait_aed().intValue());
							}	

							Cell R56cell5 = R56row.getCell(9);
							if (R56cell5 != null) {
							   R56cell5.setCellValue(BRF204B.getR75_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR75_gcc_kuwait_fcy().intValue());
							}	

							Cell R56cell6 = R56row.getCell(10);
							if (R56cell6 != null) {
							   R56cell6.setCellValue(BRF204B.getR75_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR75_gcc_qatar_aed().intValue());
							}	

							Cell R56cell7 = R56row.getCell(11);
							if (R56cell7 != null) {
							   R56cell7.setCellValue(BRF204B.getR75_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR75_gcc_qatar_fcy().intValue());
							}	

							Cell R56cell8 = R56row.getCell(12);
							if (R56cell8 != null) {
							   R56cell8.setCellValue(BRF204B.getR75_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR75_gcc_bahrain_aed().intValue());
							}	

							Cell R56cell9 = R56row.getCell(13);
							if (R56cell9 != null) {
							   R56cell9.setCellValue(BRF204B.getR75_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR75_gcc_bahrain_fcy().intValue());
							}	

							Cell R56cell10 = R56row.getCell(14);
							if (R56cell10 != null) {
							   R56cell10.setCellValue(BRF204B.getR75_other_aed() == null ? 0 :
							   	BRF204B.getR75_other_aed().intValue());
							}	

							Cell R56cell11 = R56row.getCell(15);
							if (R56cell11 != null) {
							   R56cell11.setCellValue(BRF204B.getR75_other_fcy() == null ? 0 :
							   	BRF204B.getR75_other_fcy().intValue());
							}	



							   /////////////R76////////////////////////

							Row R57row = sheet.getRow(85);
							   
							Cell R57cell = R57row.getCell(4);
							if (R57cell != null) {
							   R57cell.setCellValue(BRF204B.getR76_gcc_ksa_aed() == null ? 0 :
							   	BRF204B.getR76_gcc_ksa_aed().intValue());
							}	

							Cell R57cell1 = R57row.getCell(5);
							if (R57cell1 != null) {
							   R57cell1.setCellValue(BRF204B.getR76_gcc_ksa_fcy() == null ? 0 :
							   	BRF204B.getR76_gcc_ksa_fcy().intValue());
							}	

							Cell R57cell2 = R57row.getCell(6);
							if (R57cell2 != null) {
							   R57cell2.setCellValue(BRF204B.getR76_gcc_oman_aed() == null ? 0 :
							   	BRF204B.getR76_gcc_oman_aed().intValue());
							}	

							Cell R57cell3 = R57row.getCell(7);
							if (R57cell3 != null) {
							   R57cell3.setCellValue(BRF204B.getR76_gcc_oman_fcy() == null ? 0 :
							   	BRF204B.getR76_gcc_oman_fcy().intValue());
							}	

							Cell R57cell4 = R57row.getCell(8);
							if (R57cell4 != null) {
							   R57cell4.setCellValue(BRF204B.getR76_gcc_kuwait_aed() == null ? 0 :
							   	BRF204B.getR76_gcc_kuwait_aed().intValue());
							}	

							Cell R57cell5 = R57row.getCell(9);
							if (R57cell5 != null) {
							   R57cell5.setCellValue(BRF204B.getR76_gcc_kuwait_fcy() == null ? 0 :
							   	BRF204B.getR76_gcc_kuwait_fcy().intValue());
							}	

							Cell R57cell6 = R57row.getCell(10);
							if (R57cell6 != null) {
							   R57cell6.setCellValue(BRF204B.getR76_gcc_qatar_aed() == null ? 0 :
							   	BRF204B.getR76_gcc_qatar_aed().intValue());
							}	

							Cell R57cell7 = R57row.getCell(11);
							if (R57cell7 != null) {
							   R57cell7.setCellValue(BRF204B.getR76_gcc_qatar_fcy() == null ? 0 :
							   	BRF204B.getR76_gcc_qatar_fcy().intValue());
							}	

							Cell R57cell8 = R57row.getCell(12);
							if (R57cell8 != null) {
							   R57cell8.setCellValue(BRF204B.getR76_gcc_bahrain_aed() == null ? 0 :
							   	BRF204B.getR76_gcc_bahrain_aed().intValue());
							}	

							Cell R57cell9 = R57row.getCell(13);
							if (R57cell9 != null) {
							   R57cell9.setCellValue(BRF204B.getR76_gcc_bahrain_fcy() == null ? 0 :
							   	BRF204B.getR76_gcc_bahrain_fcy().intValue());
							}	

							Cell R57cell10 = R57row.getCell(14);
							if (R57cell10 != null) {
							   R57cell10.setCellValue(BRF204B.getR76_other_aed() == null ? 0 :
							   	BRF204B.getR76_other_aed().intValue());
							}	

							Cell R57cell11 = R57row.getCell(15);
							if (R57cell11 != null) {
							   R57cell11.setCellValue(BRF204B.getR76_other_fcy() == null ? 0 :
							   	BRF204B.getR76_other_fcy().intValue());
							}	

						}
					}
					FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-204-A.xls");
		            workbook.write(fileOut);
		            fileOut.close();
		            System.out.println(fileOut);
		            path= fileOut.toString();
		            // Close the workbook
		            System.out.println("PATH : "+path);
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
					
					

					
				}////else end

			}
			outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-204-A.xls");

			return outputFile;
		
		
		
		}
	       	 
	       	 
	       	 
	       	 
//EDIT
	public String detailChanges204(BRF204_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
			BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

		String msg = "";

		try {

			Session hs = sessionFactory.getCurrentSession();
			Optional<BRF204_DETAIL_ENTITY> Brf204detail =brf204_detailrepo.findById(foracid);

			if (Brf204detail.isPresent()) {
				BRF204_DETAIL_ENTITY BRFdetail = Brf204detail.get();

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
					brf204_detailrepo.save(BRFdetail);

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

	/**** ARCH SUMMARY 
	 * @throws ParseException ****/
	public ModelAndView getArchieveBRF204View(String reportId, String fromdate, String todate, String currency,
			String dtltype, Pageable pageable) {

		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF204A_ENTITY> T1Master = new ArrayList<BRF204A_ENTITY>();


		List<BRF204B_ENTITY> T1Master1 = new ArrayList<BRF204B_ENTITY>();


		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF204A_ENTITY a where a.report_date = ?1 ", BRF204A_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

			T1Master1 = hs.createQuery("from BRF204B_ENTITY a where a.report_date = ?1 ", BRF204B_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		mv.setViewName("RR/BRF204ARCH");
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportsummary1", T1Master1);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

	/**** ARCH DETAILS 
	 * @throws ParseException ****/

	public ModelAndView ARCHgetBRF204currentDtl(String reportId, String fromdate, String todate, String currency,
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
				qr = hs.createNativeQuery(
						"select * from BRF204_ARCHIEVTABLE   a where report_date = ?1 and report_label_1 =?2");
				qr.setParameter(2, filter);

			} else {
				System.out.println("2");
				qr = hs.createNativeQuery("select * from BRF204_ARCHIEVTABLE a where report_date = ?1");

			}
		} else {
			System.out.println("3");
			qr = hs.createNativeQuery("select * from BRF204_ARCHIEVTABLE  where report_date = ?1");
		}

		try {
			qr.setParameter(1, df.parse(todate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<BRF204_ARCHIV_ENTITY> T1Master = new ArrayList<BRF204_ARCHIV_ENTITY>();

		try {
			T1Master = hs
					.createQuery("from BRF204_ARCHIV_ENTITY a where a.report_date = ?1", BRF204_ARCHIV_ENTITY.class)
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

			BRF204_ARCHIV_ENTITY py = new BRF204_ARCHIV_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR" + "/" + "BRF204ARCH::reportcontent");
		mv.addObject("reportdetails", T1Dt1Page.getContent());
		mv.addObject("reportmaster", T1Master);
		mv.addObject("reportmaster1", qr);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}
}
