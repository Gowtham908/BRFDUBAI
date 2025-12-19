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

import com.bornfire.xbrl.entities.BRBS.BRF101_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF101ServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRF101_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF101_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF101_DetaiRep;
import com.bornfire.xbrl.entities.BRBS.BRF101_ENTITY;
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
public class BRF101ReportService {
	private static final Logger logger = LoggerFactory.getLogger(BRF101ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;

	
	@Autowired
	BRF101ServiceRepo BRF101ServiceRepo;
	
	@Autowired
	BRF101_DetaiRep BRF101_DetaiRep1;
	
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");


	public String preCheckBRF101(String reportid, String fromdate, String todate) {
		
			String msg = "";
			Session hs = sessionFactory.getCurrentSession();
			Date dt1;
			Date dt9;
			logger.info("Report precheck : " + reportid);

			try {
				dt1 = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
				dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
				logger.info("Getting No of records in Master table :" + reportid);
				Long dtlcnt = (Long) hs.createQuery("select count(*) from BRF101_ENTITY a where a.report_date=?1")
						.setParameter(1, dt9).getSingleResult();

				if (dtlcnt > 0) {
					logger.info("Getting No of records in Mod table :" + reportid);
					Long modcnt = (Long) hs.createQuery("select count(*) from BRF101_ENTITY a ").getSingleResult();
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


	public ModelAndView getBRF101View(String reportId, String fromdate, String todate, String currency, String dtltype,
			Pageable pageable) {

		ModelAndView mv = new ModelAndView();

		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<BRF101_ENTITY> T1rep = new ArrayList<BRF101_ENTITY>();
		// Query<Object[]> qr;

		List<BRF101_ENTITY> T1Master = new ArrayList<BRF101_ENTITY>();

		logger.info("Inside archive" +currency);

		try {
			
			
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from BRF101_ENTITY a where a.report_date = ?1 ", BRF101_ENTITY.class)
					.setParameter(1, df.parse(todate)).getResultList();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF101A");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}
	

public ModelAndView getBRF101currentDtl(String reportId, String fromdate, String todate, String currency,
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
					"select * from BRF101_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

			qr.setParameter(2, filter);

		} else {
			qr = hs.createNativeQuery("select * from BRF101_DETAILTABLE a where report_date = ?1");

		}
	} else {
		qr = hs.createNativeQuery("select * from BRF101_DETAILTABLE  where report_date = ?1");
	}

	try {
		qr.setParameter(1, df.parse(todate));

	} catch (ParseException e) {
		e.printStackTrace();
	}
	List<BRF101_DETAIL_ENTITY> T1Master = new ArrayList<BRF101_DETAIL_ENTITY>();

	try {
		T1Master = hs.createQuery("from BRF101_DETAIL_ENTITY a where a.report_date = ?1", BRF101_DETAIL_ENTITY.class)
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

		BRF101_DETAIL_ENTITY py = new BRF101_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

		mv.setViewName("RR"+"/"+"BRF101A::reportcontent");
		// mv.setViewName("ReportT1");
		mv.addObject("reportdetails", T1Dt1Page);
		mv.addObject("reportmaster", T1Master);
		mv.addObject("singledetail", new T1CurProdDetail());
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		return mv;
	}


	
	public File getFileBRF101(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file :" + reportId);
		fileName = "011-BRF-0101-A";
		

		if (!filetype.equals("xbrl")) {
			if(!filetype.equals("BRF")) {
			try {
				InputStream jasperFile;
				logger.info("Getting Jasper file :" + reportId);
				if (filetype.equals("detailexcel")) {
					if (dtltype.equals("report")) {

						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF101_Details.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF101_Details.jrxml");
					}

				} else {
					if (dtltype.equals("report")) {
						logger.info("Inside report");
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF101.jrxml");
					} else {
						jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF101.jrxml");
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
			}else {	
		
		
		List<BRF101_ENTITY> T1Master = new ArrayList<BRF101_ENTITY>();
		Session hs = sessionFactory.getCurrentSession();
		try {
			Date d1 = df.parse(todate);
		
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF101_ENTITY a where a.report_date = ?1 ", BRF101_ENTITY.class)
				.setParameter(1, df.parse(todate)).getResultList();
		
		if(T1Master.size() == 1) {
			
			for(BRF101_ENTITY BRF101 : T1Master ) {
		
		File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-101-AT.xls");
		
		  // Load the Excel file
    	Workbook workbook = WorkbookFactory.create(Responsecamt);

        // Get the first sheet
    	Sheet sheet = workbook.getSheetAt(0);
    	
   
		Row row2 = sheet.getRow(10);
		 Cell R2cell1 = row2.getCell(4); 
			if (R2cell1 != null) {
				R2cell1.setCellValue(BRF101.getR2_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR2_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R2cell2 = row2.getCell(5); 
			if (R2cell2 != null) {
				R2cell2.setCellValue(BRF101.getR2_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR2_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R2cell3 = row2.getCell(7); 
			if (R2cell3 != null) {
				R2cell3.setCellValue(BRF101.getR2_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR2_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R2cell4 = row2.getCell(8); 
			if (R2cell4 != null) {
				R2cell4.setCellValue(BRF101.getR2_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR2_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row3 = sheet.getRow(11);
			 Cell R3cell1 = row3.getCell(4); 
				if (R3cell1 != null) {
					R3cell1.setCellValue(BRF101.getR3_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR3_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R3cell2 = row3.getCell(5); 
				if (R3cell2 != null) {
					R3cell2.setCellValue(BRF101.getR3_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR3_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R3cell3 = row3.getCell(7); 
				if (R3cell3 != null) {
					R3cell3.setCellValue(BRF101.getR3_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR3_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R3cell4 = row3.getCell(8); 
				if (R3cell4 != null) {
					R3cell4.setCellValue(BRF101.getR3_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR3_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row5 = sheet.getRow(14);
			 Cell R5cell1 = row5.getCell(4); 
				if (R5cell1 != null) {
					R5cell1.setCellValue(BRF101.getR5_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR5_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R5cell2 = row5.getCell(5); 
				if (R5cell2 != null) {
					R5cell2.setCellValue(BRF101.getR5_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR5_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R5cell3 = row5.getCell(7); 
				if (R5cell3 != null) {
					R5cell3.setCellValue(BRF101.getR5_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR5_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R5cell4 = row5.getCell(8); 
				if (R5cell4 != null) {
					R5cell4.setCellValue(BRF101.getR5_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR5_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row6 = sheet.getRow(15);
			 Cell R6cell1 = row6.getCell(4); 
				if (R6cell1 != null) {
					R6cell1.setCellValue(BRF101.getR6_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR6_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R6cell2 = row6.getCell(5); 
				if (R6cell2 != null) {
					R6cell2.setCellValue(BRF101.getR6_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR6_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R6cell3 = row6.getCell(7); 
				if (R6cell3 != null) {
					R6cell3.setCellValue(BRF101.getR6_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR6_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R6cell4 = row6.getCell(8); 
				if (R6cell4 != null) {
					R6cell4.setCellValue(BRF101.getR6_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR6_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row7 = sheet.getRow(16);
			 Cell R7cell1 = row7.getCell(4); 
				if (R7cell1 != null) {
					R7cell1.setCellValue(BRF101.getR7_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR7_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R7cell2 = row7.getCell(5); 
				if (R7cell2 != null) {
					R7cell2.setCellValue(BRF101.getR7_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR7_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R7cell3 = row7.getCell(7); 
				if (R7cell3 != null) {
					R7cell3.setCellValue(BRF101.getR7_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR7_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R7cell4 = row7.getCell(8); 
				if (R7cell4 != null) {
					R7cell4.setCellValue(BRF101.getR7_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR7_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row8 = sheet.getRow(17);
			 Cell R8cell1 = row8.getCell(4); 
				if (R8cell1 != null) {
					R8cell1.setCellValue(BRF101.getR8_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR8_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R8cell2 = row8.getCell(5); 
				if (R8cell2 != null) {
					R8cell2.setCellValue(BRF101.getR8_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR8_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R8cell3 = row8.getCell(7); 
				if (R8cell3 != null) {
					R8cell3.setCellValue(BRF101.getR8_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR8_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R8cell4 = row8.getCell(8); 
				if (R8cell4 != null) {
					R8cell4.setCellValue(BRF101.getR8_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR8_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row10 = sheet.getRow(20);
            Cell R10cell1 = row10.getCell(4); 
			if (R10cell1 != null) {
				R10cell1.setCellValue(BRF101.getR10_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR10_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R10cell2 = row10.getCell(5); 
			if (R10cell2 != null) {
				R10cell2.setCellValue(BRF101.getR10_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR10_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R10cell3 = row10.getCell(7); 
			if (R10cell3 != null) {
				R10cell3.setCellValue(BRF101.getR10_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR10_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R10cell4 = row10.getCell(8); 
			if (R10cell4 != null) {
				R10cell4.setCellValue(BRF101.getR10_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR10_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row11 = sheet.getRow(21);
			 Cell R11cell1 = row11.getCell(4); 
				if (R11cell1 != null) {
					R11cell1.setCellValue(BRF101.getR11_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR11_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R11cell2 = row11.getCell(5); 
				if (R11cell2 != null) {
					R11cell2.setCellValue(BRF101.getR11_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR11_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R11cell3 = row11.getCell(7); 
				if (R11cell3 != null) {
					R11cell3.setCellValue(BRF101.getR11_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR11_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R11cell4 = row11.getCell(8); 
				if (R11cell4 != null) {
					R11cell4.setCellValue(BRF101.getR11_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR11_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row12 = sheet.getRow(22);
			 Cell R12cell1 = row12.getCell(4); 
				if (R12cell1 != null) {
					R12cell1.setCellValue(BRF101.getR12_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR12_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R12cell2 = row12.getCell(5); 
				if (R12cell2 != null) {
					R12cell2.setCellValue(BRF101.getR12_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR12_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R12cell3 = row12.getCell(7); 
				if (R12cell3 != null) {
					R12cell3.setCellValue(BRF101.getR12_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR12_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R12cell4 = row12.getCell(8); 
				if (R12cell4 != null) {
					R12cell4.setCellValue(BRF101.getR12_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR12_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row13 = sheet.getRow(23);
			 Cell R13cell1 = row13.getCell(4); 
				if (R13cell1 != null) {
					R13cell1.setCellValue(BRF101.getR13_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR13_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R13cell2 = row13.getCell(5); 
				if (R13cell2 != null) {
					R13cell2.setCellValue(BRF101.getR13_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR13_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R13cell3 = row13.getCell(7); 
				if (R13cell3 != null) {
					R13cell3.setCellValue(BRF101.getR13_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR13_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R13cell4 = row13.getCell(8); 
				if (R13cell4 != null) {
					R13cell4.setCellValue(BRF101.getR13_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR13_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row14 = sheet.getRow(24);
			 Cell R14cell1 = row14.getCell(4); 
				if (R14cell1 != null) {
					R14cell1.setCellValue(BRF101.getR14_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR14_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R14cell2 = row14.getCell(5); 
				if (R14cell2 != null) {
					R14cell2.setCellValue(BRF101.getR14_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR14_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R14cell3 = row14.getCell(7); 
				if (R14cell3 != null) {
					R14cell3.setCellValue(BRF101.getR14_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR14_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R14cell4 = row14.getCell(8); 
				if (R14cell4 != null) {
					R14cell4.setCellValue(BRF101.getR14_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR14_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row15 = sheet.getRow(25);
            Cell R15cell1 = row15.getCell(4); 
			if (R15cell1 != null) {
				R15cell1.setCellValue(BRF101.getR15_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR15_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R15cell2 = row15.getCell(5); 
			if (R15cell2 != null) {
				R15cell2.setCellValue(BRF101.getR15_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR15_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R15cell3 = row15.getCell(7); 
			if (R15cell3 != null) {
				R15cell3.setCellValue(BRF101.getR15_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR15_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R15cell4 = row15.getCell(8); 
			if (R15cell4 != null) {
				R15cell4.setCellValue(BRF101.getR15_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR15_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row16 = sheet.getRow(26);
			 Cell R16cell1 = row16.getCell(4); 
				if (R16cell1 != null) {
					R16cell1.setCellValue(BRF101.getR16_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR16_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R16cell2 = row16.getCell(5); 
				if (R16cell2 != null) {
					R16cell2.setCellValue(BRF101.getR16_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR16_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R16cell3 = row16.getCell(7); 
				if (R16cell3 != null) {
					R16cell3.setCellValue(BRF101.getR16_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR16_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R16cell4 = row16.getCell(8); 
				if (R16cell4 != null) {
					R16cell4.setCellValue(BRF101.getR16_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR16_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row17 = sheet.getRow(27);
			 Cell R17cell1 = row17.getCell(4); 
				if (R17cell1 != null) {
					R17cell1.setCellValue(BRF101.getR17_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR17_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R17cell2 = row17.getCell(5); 
				if (R17cell2 != null) {
					R17cell2.setCellValue(BRF101.getR17_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR17_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R17cell3 = row17.getCell(7); 
				if (R17cell3 != null) {
					R17cell3.setCellValue(BRF101.getR17_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR17_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R17cell4 = row17.getCell(8); 
				if (R17cell4 != null) {
					R17cell4.setCellValue(BRF101.getR17_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR17_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row18 = sheet.getRow(28);
			 Cell R18cell1 = row18.getCell(4); 
				if (R18cell1 != null) {
					R18cell1.setCellValue(BRF101.getR18_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR18_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R18cell2 = row18.getCell(5); 
				if (R18cell2 != null) {
					R18cell2.setCellValue(BRF101.getR18_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR18_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R18cell3 = row18.getCell(7); 
				if (R18cell3 != null) {
					R18cell3.setCellValue(BRF101.getR18_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR18_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R18cell4 = row18.getCell(8); 
				if (R18cell4 != null) {
					R18cell4.setCellValue(BRF101.getR18_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR18_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row19 = sheet.getRow(29);
            Cell R19cell1 = row19.getCell(4); 
			if (R19cell1 != null) {
				R19cell1.setCellValue(BRF101.getR19_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR19_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R19cell2 = row19.getCell(5); 
			if (R19cell2 != null) {
				R19cell2.setCellValue(BRF101.getR19_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR19_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R19cell3 = row19.getCell(7); 
			if (R19cell3 != null) {
				R19cell3.setCellValue(BRF101.getR19_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR19_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R19cell4 = row19.getCell(8); 
			if (R19cell4 != null) {
				R19cell4.setCellValue(BRF101.getR19_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR19_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row20 = sheet.getRow(30);
			 Cell R20cell1 = row20.getCell(4); 
				if (R20cell1 != null) {
					R20cell1.setCellValue(BRF101.getR20_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR20_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R20cell2 = row20.getCell(5); 
				if (R20cell2 != null) {
					R20cell2.setCellValue(BRF101.getR20_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR20_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R20cell3 = row20.getCell(7); 
				if (R20cell3 != null) {
					R20cell3.setCellValue(BRF101.getR20_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR20_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R20cell4 = row20.getCell(8); 
				if (R20cell4 != null) {
					R20cell4.setCellValue(BRF101.getR20_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR20_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row21 = sheet.getRow(31);
			 Cell R21cell1 = row21.getCell(4); 
				if (R21cell1 != null) {
					R21cell1.setCellValue(BRF101.getR21_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR21_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R21cell2 = row21.getCell(5); 
				if (R21cell2 != null) {
					R21cell2.setCellValue(BRF101.getR21_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR21_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R21cell3 = row21.getCell(7); 
				if (R21cell3 != null) {
					R21cell3.setCellValue(BRF101.getR21_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR21_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R21cell4 = row21.getCell(8); 
				if (R21cell4 != null) {
					R21cell4.setCellValue(BRF101.getR21_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR21_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row23 = sheet.getRow(34);
			 Cell R23cell1 = row23.getCell(4); 
				if (R23cell1 != null) {
					R23cell1.setCellValue(BRF101.getR23_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR23_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R23cell2 = row23.getCell(5); 
				if (R23cell2 != null) {
					R23cell2.setCellValue(BRF101.getR23_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR23_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R23cell3 = row23.getCell(7); 
				if (R23cell3 != null) {
					R23cell3.setCellValue(BRF101.getR23_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR23_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R23cell4 = row23.getCell(8); 
				if (R23cell4 != null) {
					R23cell4.setCellValue(BRF101.getR23_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR23_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row24 = sheet.getRow(35);
            Cell R24cell1 = row24.getCell(4); 
			if (R24cell1 != null) {
				R24cell1.setCellValue(BRF101.getR24_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR24_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R24cell2 = row24.getCell(5); 
			if (R24cell2 != null) {
				R24cell2.setCellValue(BRF101.getR24_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR24_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R24cell3 = row24.getCell(7); 
			if (R24cell3 != null) {
				R24cell3.setCellValue(BRF101.getR24_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR24_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R24cell4 = row24.getCell(8); 
			if (R24cell4 != null) {
				R24cell4.setCellValue(BRF101.getR24_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR24_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row25 = sheet.getRow(36);
			 Cell R25cell1 = row25.getCell(4); 
				if (R25cell1 != null) {
					R25cell1.setCellValue(BRF101.getR25_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR25_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R25cell2 = row25.getCell(5); 
				if (R25cell2 != null) {
					R25cell2.setCellValue(BRF101.getR25_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR25_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R25cell3 = row25.getCell(7); 
				if (R25cell3 != null) {
					R25cell3.setCellValue(BRF101.getR25_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR25_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R25cell4 = row25.getCell(8); 
				if (R25cell4 != null) {
					R25cell4.setCellValue(BRF101.getR25_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR25_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row26 = sheet.getRow(37);
			 Cell R26cell1 = row26.getCell(4); 
				if (R26cell1 != null) {
					R26cell1.setCellValue(BRF101.getR26_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR26_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R26cell2 = row26.getCell(5); 
				if (R26cell2 != null) {
					R26cell2.setCellValue(BRF101.getR26_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR26_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R26cell3 = row26.getCell(7); 
				if (R26cell3 != null) {
					R26cell3.setCellValue(BRF101.getR26_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR26_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R26cell4 = row26.getCell(8); 
				if (R26cell4 != null) {
					R26cell4.setCellValue(BRF101.getR26_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR26_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row27 = sheet.getRow(38);
			 Cell R27cell1 = row27.getCell(4); 
				if (R27cell1 != null) {
					R27cell1.setCellValue(BRF101.getR27_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR27_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R27cell2 = row27.getCell(5); 
				if (R27cell2 != null) {
					R27cell2.setCellValue(BRF101.getR27_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR27_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R27cell3 = row27.getCell(7); 
				if (R27cell3 != null) {
					R27cell3.setCellValue(BRF101.getR27_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR27_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R27cell4 = row27.getCell(8); 
				if (R27cell4 != null) {
					R27cell4.setCellValue(BRF101.getR27_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR27_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row28 = sheet.getRow(39);
            Cell R28cell1 = row28.getCell(4); 
			if (R28cell1 != null) {
				R28cell1.setCellValue(BRF101.getR28_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR28_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R28cell2 = row28.getCell(5); 
			if (R28cell2 != null) {
				R28cell2.setCellValue(BRF101.getR28_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR28_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R28cell3 = row28.getCell(7); 
			if (R28cell3 != null) {
				R28cell3.setCellValue(BRF101.getR28_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR28_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R28cell4 = row28.getCell(8); 
			if (R28cell4 != null) {
				R28cell4.setCellValue(BRF101.getR28_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR28_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row29 = sheet.getRow(40);
			 Cell R29cell1 = row29.getCell(4); 
				if (R29cell1 != null) {
					R29cell1.setCellValue(BRF101.getR29_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR29_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R29cell2 = row29.getCell(5); 
				if (R29cell2 != null) {
					R29cell2.setCellValue(BRF101.getR29_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR29_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R29cell3 = row29.getCell(7); 
				if (R29cell3 != null) {
					R29cell3.setCellValue(BRF101.getR29_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR29_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R29cell4 = row29.getCell(8); 
				if (R29cell4 != null) {
					R29cell4.setCellValue(BRF101.getR29_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR29_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row30 = sheet.getRow(41);
			 Cell R30cell1 = row30.getCell(4); 
				if (R30cell1 != null) {
					R30cell1.setCellValue(BRF101.getR30_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR30_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R30cell2 = row30.getCell(5); 
				if (R30cell2 != null) {
					R30cell2.setCellValue(BRF101.getR30_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR30_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R30cell3 = row30.getCell(7); 
				if (R30cell3 != null) {
					R30cell3.setCellValue(BRF101.getR30_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR30_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R30cell4 = row30.getCell(8); 
				if (R30cell4 != null) {
					R30cell4.setCellValue(BRF101.getR30_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR30_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row31 = sheet.getRow(42);
			 Cell R31cell1 = row31.getCell(4); 
				if (R31cell1 != null) {
					R31cell1.setCellValue(BRF101.getR31_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR31_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R31cell2 = row31.getCell(5); 
				if (R31cell2 != null) {
					R31cell2.setCellValue(BRF101.getR31_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR31_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R31cell3 = row31.getCell(7); 
				if (R31cell3 != null) {
					R31cell3.setCellValue(BRF101.getR31_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR31_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R31cell4 = row31.getCell(8); 
				if (R31cell4 != null) {
					R31cell4.setCellValue(BRF101.getR31_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR31_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row32 = sheet.getRow(43);
            Cell R32cell1 = row32.getCell(4); 
			if (R32cell1 != null) {
				R32cell1.setCellValue(BRF101.getR32_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR32_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R32cell2 = row32.getCell(5); 
			if (R32cell2 != null) {
				R32cell2.setCellValue(BRF101.getR32_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR32_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R32cell3 = row32.getCell(7); 
			if (R32cell3 != null) {
				R32cell3.setCellValue(BRF101.getR32_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR32_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R32cell4 = row32.getCell(8); 
			if (R32cell4 != null) {
				R32cell4.setCellValue(BRF101.getR32_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR32_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row34 = sheet.getRow(46);
			 Cell R34cell1 = row34.getCell(4); 
				if (R34cell1 != null) {
					R34cell1.setCellValue(BRF101.getR34_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR34_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R34cell2 = row34.getCell(5); 
				if (R34cell2 != null) {
					R34cell2.setCellValue(BRF101.getR34_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR34_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R34cell3 = row34.getCell(7); 
				if (R34cell3 != null) {
					R34cell3.setCellValue(BRF101.getR34_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR34_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R34cell4 = row34.getCell(8); 
				if (R34cell4 != null) {
					R34cell4.setCellValue(BRF101.getR34_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR34_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row35 = sheet.getRow(47);
			 Cell R35cell1 = row35.getCell(4); 
				if (R35cell1 != null) {
					R35cell1.setCellValue(BRF101.getR35_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR35_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R35cell2 = row35.getCell(5); 
				if (R35cell2 != null) {
					R35cell2.setCellValue(BRF101.getR35_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR35_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R35cell3 = row35.getCell(7); 
				if (R35cell3 != null) {
					R35cell3.setCellValue(BRF101.getR35_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR35_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R35cell4 = row35.getCell(8); 
				if (R35cell4 != null) {
					R35cell4.setCellValue(BRF101.getR35_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR35_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row37 = sheet.getRow(50);
			 Cell R37cell1 = row37.getCell(4); 
				if (R37cell1 != null) {
					R37cell1.setCellValue(BRF101.getR37_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR37_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R37cell2 = row37.getCell(5); 
				if (R37cell2 != null) {
					R37cell2.setCellValue(BRF101.getR37_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR37_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R37cell3 = row37.getCell(7); 
				if (R37cell3 != null) {
					R37cell3.setCellValue(BRF101.getR37_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR37_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R37cell4 = row37.getCell(8); 
				if (R37cell4 != null) {
					R37cell4.setCellValue(BRF101.getR37_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR37_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
            Row row38 = sheet.getRow(51);
            Cell R38cell1 = row38.getCell(4); 
			if (R38cell1 != null) {
				R38cell1.setCellValue(BRF101.getR38_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR38_All_TRANSACTIONS_INFLOWS().intValue());
			}
			Cell R38cell2 = row38.getCell(5); 
			if (R38cell2 != null) {
				R38cell2.setCellValue(BRF101.getR38_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR38_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
			}
			Cell R38cell3 = row38.getCell(7); 
			if (R38cell3 != null) {
				R38cell3.setCellValue(BRF101.getR38_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR38_All_TRANSACTIONS_OUTFLOWS().intValue());
			}
			Cell R38cell4 = row38.getCell(8); 
			if (R38cell4 != null) {
				R38cell4.setCellValue(BRF101.getR38_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR38_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
			}
			Row row39 = sheet.getRow(52);
			 Cell R39cell1 = row39.getCell(4); 
				if (R39cell1 != null) {
					R39cell1.setCellValue(BRF101.getR39_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR39_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R39cell2 = row39.getCell(5); 
				if (R39cell2 != null) {
					R39cell2.setCellValue(BRF101.getR39_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR39_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R39cell3 = row39.getCell(7); 
				if (R39cell3 != null) {
					R39cell3.setCellValue(BRF101.getR39_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR39_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R39cell4 = row39.getCell(8); 
				if (R39cell4 != null) {
					R39cell4.setCellValue(BRF101.getR39_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR39_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row40 = sheet.getRow(53);
			 Cell R40cell1 = row40.getCell(4); 
				if (R40cell1 != null) {
					R40cell1.setCellValue(BRF101.getR40_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR40_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R40cell2 = row40.getCell(5); 
				if (R40cell2 != null) {
					R40cell2.setCellValue(BRF101.getR40_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR40_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R40cell3 = row40.getCell(7); 
				if (R40cell3 != null) {
					R40cell3.setCellValue(BRF101.getR40_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR40_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R40cell4 = row40.getCell(8); 
				if (R40cell4 != null) {
					R40cell4.setCellValue(BRF101.getR40_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR40_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
			Row row41 = sheet.getRow(54);
			 Cell R41cell1 = row41.getCell(4); 
				if (R41cell1 != null) {
					R41cell1.setCellValue(BRF101.getR41_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR41_All_TRANSACTIONS_INFLOWS().intValue());
				}
				Cell R41cell2 = row41.getCell(5); 
				if (R41cell2 != null) {
					R41cell2.setCellValue(BRF101.getR41_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR41_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
				}
				Cell R41cell3 = row41.getCell(7); 
				if (R41cell3 != null) {
					R41cell3.setCellValue(BRF101.getR41_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR41_All_TRANSACTIONS_OUTFLOWS().intValue());
				}
				Cell R41cell4 = row41.getCell(8); 
				if (R41cell4 != null) {
					R41cell4.setCellValue(BRF101.getR41_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR41_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
				}
				Row row43 = sheet.getRow(58);
				 Cell R43cell1 = row43.getCell(4); 
					if (R43cell1 != null) {
						R43cell1.setCellValue(BRF101.getR43_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR43_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R43cell2 = row43.getCell(5); 
					if (R43cell2 != null) {
						R43cell2.setCellValue(BRF101.getR43_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR43_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R43cell3 = row43.getCell(7); 
					if (R43cell3 != null) {
						R43cell3.setCellValue(BRF101.getR43_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR43_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R43cell4 = row43.getCell(8); 
					if (R43cell4 != null) {
						R43cell4.setCellValue(BRF101.getR43_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR43_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row44 = sheet.getRow(59);
				 Cell R44cell1 = row44.getCell(4); 
					if (R44cell1 != null) {
						R44cell1.setCellValue(BRF101.getR44_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR44_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R44cell2 = row44.getCell(5); 
					if (R44cell2 != null) {
						R44cell2.setCellValue(BRF101.getR44_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR44_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R44cell3 = row44.getCell(7); 
					if (R44cell3 != null) {
						R44cell3.setCellValue(BRF101.getR44_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR44_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R44cell4 = row44.getCell(8); 
					if (R44cell4 != null) {
						R44cell4.setCellValue(BRF101.getR44_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR44_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row45 = sheet.getRow(60);
				 Cell R45cell1 = row45.getCell(4); 
					if (R45cell1 != null) {
						R45cell1.setCellValue(BRF101.getR45_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR45_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R45cell2 = row45.getCell(5); 
					if (R45cell2 != null) {
						R45cell2.setCellValue(BRF101.getR45_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR45_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R45cell3 = row45.getCell(7); 
					if (R45cell3 != null) {
						R45cell3.setCellValue(BRF101.getR45_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR45_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R45cell4 = row45.getCell(8); 
					if (R45cell4 != null) {
						R45cell4.setCellValue(BRF101.getR45_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR45_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row46 = sheet.getRow(61);
				 Cell R46cell1 = row46.getCell(4); 
					if (R46cell1 != null) {
						R46cell1.setCellValue(BRF101.getR46_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR46_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R46cell2 = row46.getCell(5); 
					if (R46cell2 != null) {
						R46cell2.setCellValue(BRF101.getR46_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR46_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R46cell3 = row46.getCell(7); 
					if (R46cell3 != null) {
						R46cell3.setCellValue(BRF101.getR46_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR46_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R46cell4 = row46.getCell(8); 
					if (R46cell4 != null) {
						R46cell4.setCellValue(BRF101.getR46_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR46_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row48 = sheet.getRow(64);
				 Cell R48cell1 = row48.getCell(4); 
					if (R48cell1 != null) {
						R48cell1.setCellValue(BRF101.getR48_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR48_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R48cell2 = row48.getCell(5); 
					if (R48cell2 != null) {
						R48cell2.setCellValue(BRF101.getR48_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR48_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R48cell3 = row48.getCell(7); 
					if (R48cell3 != null) {
						R48cell3.setCellValue(BRF101.getR48_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR48_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R48cell4 = row48.getCell(8); 
					if (R48cell4 != null) {
						R48cell4.setCellValue(BRF101.getR48_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR48_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row49 = sheet.getRow(65);
				 Cell R49cell1 = row49.getCell(4); 
					if (R49cell1 != null) {
						R49cell1.setCellValue(BRF101.getR49_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR49_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R49cell2 = row49.getCell(5); 
					if (R49cell2 != null) {
						R49cell2.setCellValue(BRF101.getR49_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR49_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R49cell3 = row49.getCell(7); 
					if (R49cell3 != null) {
						R49cell3.setCellValue(BRF101.getR49_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR49_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R49cell4 = row49.getCell(8); 
					if (R49cell4 != null) {
						R49cell4.setCellValue(BRF101.getR49_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR49_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row50 = sheet.getRow(66);
				 Cell R50cell1 = row50.getCell(4); 
					if (R50cell1 != null) {
						R50cell1.setCellValue(BRF101.getR50_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR50_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R50cell2 = row50.getCell(5); 
					if (R50cell2 != null) {
						R50cell2.setCellValue(BRF101.getR50_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR50_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R50cell3 = row50.getCell(7); 
					if (R50cell3 != null) {
						R50cell3.setCellValue(BRF101.getR50_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR50_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R50cell4 = row50.getCell(8); 
					if (R50cell4 != null) {
						R50cell4.setCellValue(BRF101.getR50_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR50_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row51 = sheet.getRow(67);
				 Cell R51cell1 = row51.getCell(4); 
					if (R51cell1 != null) {
						R51cell1.setCellValue(BRF101.getR51_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR51_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R51cell2 = row51.getCell(5); 
					if (R51cell2 != null) {
						R51cell2.setCellValue(BRF101.getR51_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR51_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R51cell3 = row51.getCell(7); 
					if (R51cell3 != null) {
						R51cell3.setCellValue(BRF101.getR51_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR51_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R51cell4 = row51.getCell(8); 
					if (R51cell4 != null) {
						R51cell4.setCellValue(BRF101.getR51_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR51_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row52 = sheet.getRow(68);
				 Cell R52cell1 = row52.getCell(4); 
					if (R52cell1 != null) {
						R52cell1.setCellValue(BRF101.getR52_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR52_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R52cell2 = row52.getCell(5); 
					if (R52cell2 != null) {
						R52cell2.setCellValue(BRF101.getR52_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR52_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R52cell3 = row52.getCell(7); 
					if (R52cell3 != null) {
						R52cell3.setCellValue(BRF101.getR52_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR52_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R52cell4 = row52.getCell(8); 
					if (R52cell4 != null) {
						R52cell4.setCellValue(BRF101.getR52_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR52_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
				Row row54 = sheet.getRow(71);
				 Cell R54cell1 = row54.getCell(4); 
					if (R54cell1 != null) {
						R54cell1.setCellValue(BRF101.getR54_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR54_All_TRANSACTIONS_INFLOWS().intValue());
					}
					Cell R54cell2 = row54.getCell(5); 
					if (R54cell2 != null) {
						R54cell2.setCellValue(BRF101.getR54_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR54_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
					}
					Cell R54cell3 = row54.getCell(7); 
					if (R54cell3 != null) {
						R54cell3.setCellValue(BRF101.getR54_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR54_All_TRANSACTIONS_OUTFLOWS().intValue());
					}
					Cell R54cell4 = row54.getCell(8); 
					if (R54cell4 != null) {
						R54cell4.setCellValue(BRF101.getR54_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR54_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
					}
					Row row55 = sheet.getRow(72);
					 Cell R55cell1 = row55.getCell(4); 
						if (R55cell1 != null) {
							R55cell1.setCellValue(BRF101.getR55_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR55_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R55cell2 = row55.getCell(5); 
						if (R55cell2 != null) {
							R55cell2.setCellValue(BRF101.getR55_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR55_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R55cell3 = row55.getCell(7); 
						if (R55cell3 != null) {
							R55cell3.setCellValue(BRF101.getR55_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR55_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R55cell4 = row55.getCell(8); 
						if (R55cell4 != null) {
							R55cell4.setCellValue(BRF101.getR55_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR55_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row56 = sheet.getRow(73);
					 Cell R56cell1 = row56.getCell(4); 
						if (R56cell1 != null) {
							R56cell1.setCellValue(BRF101.getR56_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR56_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R56cell2 = row56.getCell(5); 
						if (R56cell2 != null) {
							R56cell2.setCellValue(BRF101.getR56_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR56_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R56cell3 = row56.getCell(7); 
						if (R56cell3 != null) {
							R56cell3.setCellValue(BRF101.getR56_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR56_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R56cell4 = row56.getCell(8); 
						if (R56cell4 != null) {
							R56cell4.setCellValue(BRF101.getR56_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR56_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row57 = sheet.getRow(74);
					 Cell R57cell1 = row57.getCell(4); 
						if (R57cell1 != null) {
							R57cell1.setCellValue(BRF101.getR57_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR57_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R57cell2 = row57.getCell(5); 
						if (R57cell2 != null) {
							R57cell2.setCellValue(BRF101.getR57_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR57_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R57cell3 = row57.getCell(7); 
						if (R57cell3 != null) {
							R57cell3.setCellValue(BRF101.getR57_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR57_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R57cell4 = row57.getCell(8); 
						if (R57cell4 != null) {
							R57cell4.setCellValue(BRF101.getR57_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR57_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row58 = sheet.getRow(75);
					 Cell R58cell1 = row58.getCell(4); 
						if (R58cell1 != null) {
							R58cell1.setCellValue(BRF101.getR58_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR58_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R58cell2 = row58.getCell(5); 
						if (R58cell2 != null) {
							R58cell2.setCellValue(BRF101.getR58_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR58_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R58cell3 = row58.getCell(7); 
						if (R58cell3 != null) {
							R58cell3.setCellValue(BRF101.getR58_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR58_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R58cell4 = row58.getCell(8); 
						if (R58cell4 != null) {
							R58cell4.setCellValue(BRF101.getR58_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR58_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row59 = sheet.getRow(76);
					 Cell R59cell1 = row59.getCell(4); 
						if (R59cell1 != null) {
							R59cell1.setCellValue(BRF101.getR59_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR59_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R59cell2 = row59.getCell(5); 
						if (R59cell2 != null) {
							R59cell2.setCellValue(BRF101.getR59_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR59_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R59cell3 = row59.getCell(7); 
						if (R59cell3 != null) {
							R59cell3.setCellValue(BRF101.getR59_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR59_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R59cell4 = row59.getCell(8); 
						if (R59cell4 != null) {
							R59cell4.setCellValue(BRF101.getR59_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR59_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row60 = sheet.getRow(77);
					 Cell R60cell1 = row60.getCell(4); 
						if (R60cell1 != null) {
							R60cell1.setCellValue(BRF101.getR60_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR60_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R60cell2 = row60.getCell(5); 
						if (R60cell2 != null) {
							R60cell2.setCellValue(BRF101.getR60_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR60_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R60cell3 = row60.getCell(7); 
						if (R60cell3 != null) {
							R60cell3.setCellValue(BRF101.getR60_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR60_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R60cell4 = row60.getCell(8); 
						if (R60cell4 != null) {
							R60cell4.setCellValue(BRF101.getR60_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR60_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row62 = sheet.getRow(81);
					 Cell R62cell1 = row62.getCell(4); 
						if (R62cell1 != null) {
							R62cell1.setCellValue(BRF101.getR62_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR62_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R62cell2 = row62.getCell(5); 
						if (R62cell2 != null) {
							R62cell2.setCellValue(BRF101.getR62_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR62_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R62cell3 = row62.getCell(7); 
						if (R62cell3 != null) {
							R62cell3.setCellValue(BRF101.getR62_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR62_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R62cell4 = row62.getCell(8); 
						if (R62cell4 != null) {
							R62cell4.setCellValue(BRF101.getR62_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR62_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row63 = sheet.getRow(82);
					 Cell R63cell1 = row63.getCell(4); 
						if (R63cell1 != null) {
							R63cell1.setCellValue(BRF101.getR63_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR63_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R63cell2 = row63.getCell(5); 
						if (R63cell2 != null) {
							R63cell2.setCellValue(BRF101.getR63_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR63_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R63cell3 = row63.getCell(7); 
						if (R63cell3 != null) {
							R63cell3.setCellValue(BRF101.getR63_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR63_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R63cell4 = row63.getCell(8); 
						if (R63cell4 != null) {
							R63cell4.setCellValue(BRF101.getR63_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR63_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row64 = sheet.getRow(83);
					 Cell R64cell1 = row64.getCell(4); 
						if (R64cell1 != null) {
							R64cell1.setCellValue(BRF101.getR64_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR64_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R64cell2 = row64.getCell(5); 
						if (R64cell2 != null) {
							R64cell2.setCellValue(BRF101.getR64_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR64_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R64cell3 = row64.getCell(7); 
						if (R64cell3 != null) {
							R64cell3.setCellValue(BRF101.getR64_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR64_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R64cell4 = row64.getCell(8); 
						if (R64cell4 != null) {
							R64cell4.setCellValue(BRF101.getR64_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR64_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row65 = sheet.getRow(84);
					 Cell R65cell1 = row65.getCell(4); 
						if (R65cell1 != null) {
							R65cell1.setCellValue(BRF101.getR65_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR65_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R65cell2 = row65.getCell(5); 
						if (R65cell2 != null) {
							R65cell2.setCellValue(BRF101.getR65_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR65_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R65cell3 = row65.getCell(7); 
						if (R65cell3 != null) {
							R65cell3.setCellValue(BRF101.getR65_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR65_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R65cell4 = row65.getCell(8); 
						if (R65cell4 != null) {
							R65cell4.setCellValue(BRF101.getR65_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR65_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
					Row row67 = sheet.getRow(87);
					 Cell R67cell1 = row67.getCell(4); 
						if (R67cell1 != null) {
							R67cell1.setCellValue(BRF101.getR67_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR67_All_TRANSACTIONS_INFLOWS().intValue());
						}
						Cell R67cell2 = row67.getCell(5); 
						if (R67cell2 != null) {
							R67cell2.setCellValue(BRF101.getR67_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR67_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
						}
						Cell R67cell3 = row67.getCell(7); 
						if (R67cell3 != null) {
							R67cell3.setCellValue(BRF101.getR67_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR67_All_TRANSACTIONS_OUTFLOWS().intValue());
						}
						Cell R67cell4 = row67.getCell(8); 
						if (R67cell4 != null) {
							R67cell4.setCellValue(BRF101.getR67_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR67_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
						}
						Row row68 = sheet.getRow(88);
						 Cell R68cell1 = row68.getCell(4); 
							if (R68cell1 != null) {
								R68cell1.setCellValue(BRF101.getR68_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR68_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R68cell2 = row68.getCell(5); 
							if (R68cell2 != null) {
								R68cell2.setCellValue(BRF101.getR68_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR68_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R68cell3 = row68.getCell(7); 
							if (R68cell3 != null) {
								R68cell3.setCellValue(BRF101.getR68_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR68_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R68cell4 = row68.getCell(8); 
							if (R68cell4 != null) {
								R68cell4.setCellValue(BRF101.getR68_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR68_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row69 = sheet.getRow(89);
						 Cell R69cell1 = row69.getCell(4); 
							if (R69cell1 != null) {
								R69cell1.setCellValue(BRF101.getR69_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR69_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R69cell2 = row69.getCell(5); 
							if (R69cell2 != null) {
								R69cell2.setCellValue(BRF101.getR69_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR69_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R69cell3 = row69.getCell(7); 
							if (R69cell3 != null) {
								R69cell3.setCellValue(BRF101.getR69_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR69_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R69cell4 = row69.getCell(8); 
							if (R69cell4 != null) {
								R69cell4.setCellValue(BRF101.getR69_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR69_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row70 = sheet.getRow(90);
						 Cell R70cell1 = row70.getCell(4); 
							if (R70cell1 != null) {
								R70cell1.setCellValue(BRF101.getR70_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR70_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R70cell2 = row70.getCell(5); 
							if (R70cell2 != null) {
								R70cell2.setCellValue(BRF101.getR70_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR70_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R70cell3 = row70.getCell(7); 
							if (R70cell3 != null) {
								R70cell3.setCellValue(BRF101.getR70_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR70_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R70cell4 = row70.getCell(8); 
							if (R70cell4 != null) {
								R70cell4.setCellValue(BRF101.getR70_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR70_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row71 = sheet.getRow(91);
						 Cell R71cell1 = row71.getCell(4); 
							if (R71cell1 != null) {
								R71cell1.setCellValue(BRF101.getR71_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR71_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R71cell2 = row71.getCell(5); 
							if (R71cell2 != null) {
								R71cell2.setCellValue(BRF101.getR71_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR71_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R71cell3 = row71.getCell(7); 
							if (R71cell3 != null) {
								R71cell3.setCellValue(BRF101.getR71_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR71_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R71cell4 = row71.getCell(8); 
							if (R71cell4 != null) {
								R71cell4.setCellValue(BRF101.getR71_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR71_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row73 = sheet.getRow(94);
						 Cell R73cell1 = row73.getCell(4); 
							if (R73cell1 != null) {
								R73cell1.setCellValue(BRF101.getR73_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR73_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R73cell2 = row73.getCell(5); 
							if (R73cell2 != null) {
								R73cell2.setCellValue(BRF101.getR73_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR73_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R73cell3 = row73.getCell(7); 
							if (R73cell3 != null) {
								R73cell3.setCellValue(BRF101.getR73_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR73_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R73cell4 = row73.getCell(8); 
							if (R73cell4 != null) {
								R73cell4.setCellValue(BRF101.getR73_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR73_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row74 = sheet.getRow(95);
						 Cell R74cell1 = row74.getCell(4); 
							if (R74cell1 != null) {
								R74cell1.setCellValue(BRF101.getR74_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR74_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R74cell2 = row74.getCell(5); 
							if (R74cell2 != null) {
								R74cell2.setCellValue(BRF101.getR74_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR74_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R74cell3 = row74.getCell(7); 
							if (R74cell3 != null) {
								R74cell3.setCellValue(BRF101.getR74_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR74_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R74cell4 = row74.getCell(8); 
							if (R74cell4 != null) {
								R74cell4.setCellValue(BRF101.getR74_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR74_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row75 = sheet.getRow(96);
						 Cell R75cell1 = row75.getCell(4); 
							if (R75cell1 != null) {
								R75cell1.setCellValue(BRF101.getR75_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR75_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R75cell2 = row75.getCell(5); 
							if (R75cell2 != null) {
								R75cell2.setCellValue(BRF101.getR75_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR75_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R75cell3 = row75.getCell(7); 
							if (R75cell3 != null) {
								R75cell3.setCellValue(BRF101.getR75_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR75_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R75cell4 = row75.getCell(8); 
							if (R75cell4 != null) {
								R75cell4.setCellValue(BRF101.getR75_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR75_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row76 = sheet.getRow(97);
						 Cell R76cell1 = row76.getCell(4); 
							if (R76cell1 != null) {
								R76cell1.setCellValue(BRF101.getR76_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR76_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R76cell2 = row76.getCell(5); 
							if (R76cell2 != null) {
								R76cell2.setCellValue(BRF101.getR76_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR76_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R76cell3 = row76.getCell(7); 
							if (R76cell3 != null) {
								R76cell3.setCellValue(BRF101.getR76_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR76_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R76cell4 = row76.getCell(8); 
							if (R76cell4 != null) {
								R76cell4.setCellValue(BRF101.getR76_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR76_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row77 = sheet.getRow(98);
						 Cell R77cell1 = row77.getCell(4); 
							if (R77cell1 != null) {
								R77cell1.setCellValue(BRF101.getR77_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR77_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R77cell2 = row77.getCell(5); 
							if (R77cell2 != null) {
								R77cell2.setCellValue(BRF101.getR77_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR77_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R77cell3 = row77.getCell(7); 
							if (R77cell3 != null) {
								R77cell3.setCellValue(BRF101.getR77_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR77_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R77cell4 = row77.getCell(8); 
							if (R77cell4 != null) {
								R77cell4.setCellValue(BRF101.getR77_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR77_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row78 = sheet.getRow(99);
						 Cell R78cell1 = row78.getCell(4); 
							if (R78cell1 != null) {
								R78cell1.setCellValue(BRF101.getR78_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR78_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R78cell2 = row78.getCell(5); 
							if (R78cell2 != null) {
								R78cell2.setCellValue(BRF101.getR78_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR78_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R78cell3 = row78.getCell(7); 
							if (R78cell3 != null) {
								R78cell3.setCellValue(BRF101.getR78_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR78_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R78cell4 = row78.getCell(8); 
							if (R78cell4 != null) {
								R78cell4.setCellValue(BRF101.getR78_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR78_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
						Row row79 = sheet.getRow(100);
						 Cell R79cell1 = row79.getCell(4); 
							if (R79cell1 != null) {
								R79cell1.setCellValue(BRF101.getR79_All_TRANSACTIONS_INFLOWS() == null ? 0 : BRF101.getR79_All_TRANSACTIONS_INFLOWS().intValue());
							}
							Cell R79cell2 = row79.getCell(5); 
							if (R79cell2 != null) {
								R79cell2.setCellValue(BRF101.getR79_FINANCIAL_FREE_ZONE_INFLOWS() == null ? 0 : BRF101.getR79_FINANCIAL_FREE_ZONE_INFLOWS().intValue());
							}
							Cell R79cell3 = row79.getCell(7); 
							if (R79cell3 != null) {
								R79cell3.setCellValue(BRF101.getR79_All_TRANSACTIONS_OUTFLOWS() == null ? 0 : BRF101.getR79_All_TRANSACTIONS_OUTFLOWS().intValue());
							}
							Cell R79cell4 = row79.getCell(8); 
							if (R79cell4 != null) {
								R79cell4.setCellValue(BRF101.getR79_FINANCIAL_FREE_ZONE_OUTFLOWS() == null ? 0 : BRF101.getR79_FINANCIAL_FREE_ZONE_OUTFLOWS().intValue());
							}
							
							Row row82 = sheet.getRow(100);
							 Cell R82cell1 = row82.getCell(4); 
								if (R82cell1 != null) {
									R82cell1.setCellValue(BRF101.getR82_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR82_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row83 = sheet.getRow(100);
							 Cell R83cell1 = row83.getCell(4); 
								if (R83cell1 != null) {
									R83cell1.setCellValue(BRF101.getR83_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR83_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row85 = sheet.getRow(100);
							 Cell R85cell1 = row85.getCell(4); 
								if (R85cell1 != null) {
									R85cell1.setCellValue(BRF101.getR85_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR85_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row86 = sheet.getRow(100);
							 Cell R86cell1 = row86.getCell(4); 
								if (R86cell1 != null) {
									R86cell1.setCellValue(BRF101.getR86_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR86_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row87 = sheet.getRow(100);
							 Cell R87cell1 = row87.getCell(4); 
								if (R87cell1 != null) {
									R87cell1.setCellValue(BRF101.getR87_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR87_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row90 = sheet.getRow(100);
							 Cell R90cell1 = row90.getCell(4); 
								if (R90cell1 != null) {
									R90cell1.setCellValue(BRF101.getR90_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR90_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row91 = sheet.getRow(100);
							 Cell R91cell1 = row91.getCell(4); 
								if (R91cell1 != null) {
									R91cell1.setCellValue(BRF101.getR91_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR91_TOTAL_OUTFLOWS().intValue());
								}
								
							Row row92 = sheet.getRow(100);
							 Cell R92cell1 = row92.getCell(4); 
								if (R92cell1 != null) {
									R92cell1.setCellValue(BRF101.getR92_TOTAL_OUTFLOWS() == null ? 0 : BRF101.getR92_TOTAL_OUTFLOWS().intValue());
								}
								
					// Save the changes
					workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
					            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-101-A.xls");
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
						outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-101-A.xls");

						return outputFile;



					}
				
	
	public File getFileGENERATION(String reportId, String fromdate, String todate, String currency, String dtltype,
			String filetype) throws FileNotFoundException, JRException, SQLException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
		logger.info("GET GENERATION");
		System.out.println("generation"+todate);
		String path = this.env.getProperty("output.exportpath");
		String fileName = "";
		String zipFileName = "";
		File outputFile;
		Date master;
		String NAME;
		try {
			master = dateFormat.parse(todate);
			NAME = dateFormat1.format(master);
			fileName = "T" + reportId + "_" + NAME;
			} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		zipFileName = fileName + ".zip";

		// String filetype="detailexcel";
		// dtltype="report";
		try {
			InputStream jasperFile;
			HashMap<String, Object> map = new HashMap<String, Object>();

			jasperFile = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/Report_main.jasper");
			//jasperFile = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T1/T1Previous.jasper");
			InputStream subrep01 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/INDEX/RBSINDEX.jasper");
			InputStream subrep02 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/INSTRUCTION/RBSINST.jasper");
			InputStream subrep03 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/INDEX/Contact.jasper");
				InputStream subrep1 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T1/T1Previous.jasper");
				InputStream subrep2 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T1/T1Curr.jasper");
			InputStream subrep3 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T2/T2P.jasper");
			InputStream subrep4 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T2/T2C.jasper");
			InputStream subrep5 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T3/T3P.jasper");
			InputStream subrep6 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T3/T3C.jasper");
			InputStream subrep7 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T4/T4A_PREVIOUS.jasper");
			InputStream subrep8 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T4/T4A_CURRENT.jasper");
			InputStream subrep9 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T4/T4B_PREVIOUS.jasper");
			InputStream subrep10 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T4/T4B_CURRENT.jasper");
			InputStream subrep11 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T5A/T5A.jasper");
			InputStream subrep12 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T5A/T5B.jasper");
			InputStream subrep13 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T6/T6.jasper");
			InputStream subrep14 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T7/T7.jasper");
			InputStream subrep15 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T8/T8A.jasper");
			InputStream subrep16 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T8/T8B.jasper");
			InputStream subrep17 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T9/T9.jasper");
			InputStream subrep18 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T10/T10.jasper");
			InputStream subrep19 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T11/T11.jasper");
			InputStream subrep20 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12A.jasper");
			InputStream subrep21 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12B.jasper");
			InputStream subrep22 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12C.jasper");
			InputStream subrep23 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12D.jasper");
			InputStream subrep24 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12E.jasper");
			InputStream subrep25 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12F.jasper");
			InputStream subrep26 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12G.jasper");
			InputStream subrep27 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T12/T12H.jasper");
			InputStream subrep28 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T13/T13A.jasper");
			InputStream subrep29 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T13/T13B.jasper");
			InputStream subrep30 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T14/T14A.jasper");
			InputStream subrep31 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T14/T14B.jasper");
			InputStream subrep32 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T15/T15A.jasper");
			InputStream subrep33 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T15/T15B.jasper");
			InputStream subrep34 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T16/T16A.jasper");
			InputStream subrep35 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T16/T16B.jasper");
			InputStream subrep36 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T16/T16C.jasper");
			InputStream subrep37 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T16/T16D.jasper");
			InputStream subrep38 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T16/T16E.jasper");
			InputStream subrep39 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T17/T17.jasper");
			InputStream subrep40 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T18/T18.jasper");
			InputStream subrep41 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T19/T19.jasper");
			InputStream subrep42 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T20/T20.jasper");
			InputStream subrep43 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T21/T21.jasper");
			InputStream subrep44 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T22/T22.jasper");
			InputStream subrep45 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T23/T23.jasper");
			InputStream subrep46 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T24/T24.jasper");
			InputStream subrep47 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T25/T25.jasper");
			InputStream subrep48 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T26/T26.jasper");
			InputStream subrep49 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T27/T27.jasper");
			InputStream subrep50 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T28/T28.jasper");
			InputStream subrep51 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T29/T29.jasper");
			InputStream subrep52 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T30/T30.jasper");
			InputStream subrep53 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T31/T31.jasper");
			InputStream subrep54 = this.getClass().getResourceAsStream("/static/jasper/BOB_RBS_AML_CONS/T32/T32.jasper");

		    map.put("INST", subrep02);
			map.put("INDEX",subrep01);
			map.put("CONTACT",subrep03);
			map.put("T1P", subrep1);
			map.put("T1C", subrep2);
			map.put("T2P", subrep3);
			map.put("T2C", subrep4);
			map.put("T3P", subrep5);
			map.put("T3C", subrep6);
			map.put("T4AP", subrep7);
			map.put("T4AC", subrep8);
			map.put("T4BP", subrep9);
			map.put("T4BC", subrep10);
			map.put("T5A", subrep11);
			map.put("T5B", subrep12);
			map.put("T6", subrep13);
			map.put("T7", subrep14);
			map.put("T8A", subrep15);
			map.put("T8B", subrep16);
			map.put("T9", subrep17);
			map.put("T10", subrep18);
			map.put("T11", subrep19);
			map.put("T12A", subrep20);
			map.put("T12B", subrep21);
			map.put("T12C", subrep22);
			map.put("T12D", subrep23);
			map.put("T12E", subrep24);
			map.put("T12F", subrep25);
			map.put("T12G", subrep26);
			map.put("T12H", subrep27);
			map.put("T13A", subrep28);
			map.put("T13B", subrep29);
			map.put("T14A", subrep30);
			map.put("T14B", subrep31);
			map.put("T15A", subrep32);
			map.put("T15B", subrep33);
			map.put("T16A", subrep34);
			map.put("T16B", subrep35);
			map.put("T16C", subrep36);
			map.put("T16D", subrep37);
			map.put("T16E", subrep38);
			map.put("T17", subrep39);
			map.put("T18", subrep40);
			map.put("T19", subrep41);
			map.put("T20", subrep42);
			map.put("T21", subrep43);
			map.put("T22", subrep44);
			map.put("T23", subrep45);
			map.put("T24", subrep46);
			map.put("T25", subrep47);
			map.put("T26", subrep48);
			map.put("T27", subrep49);
			map.put("T28", subrep50);
			map.put("T29", subrep51);
			map.put("T30", subrep52);
			map.put("T31", subrep53);
			map.put("T32", subrep54);	
			try {
				master = dateFormat.parse(todate);
				NAME = dateFormat1.format(master);
				fileName = "T" + reportId + "_" + NAME;
				map.put("REPORT_DATE", NAME);
				} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			logger.info("GET GENERATION ASSIGNING PARAMETER");
			JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
			fileName = fileName + ".xlsx";
			path +=  fileName;
			logger.info("PATH :" +path);
			JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jp));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
			exporter.exportReport();

		} catch (Exception e) {
			e.printStackTrace();
		}

		outputFile = new File(path);

		return outputFile;

	}
		

	

public String detailChanges101(BRF101_DETAIL_ENTITY detail, String report_label_1, BigDecimal act_balance_amt_lc,
		String foracid, String report_name_1, String report_addl_criteria_1) {


	String msg = "";

	try {

		Session hs = sessionFactory.getCurrentSession();
		Optional<BRF101_DETAIL_ENTITY> BRF101detail = BRF101_DetaiRep1.findById(foracid);

		if (BRF101detail.isPresent()) {
			BRF101_DETAIL_ENTITY BRFdetail = BRF101detail.get();

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
				BRF101_DetaiRep1.save(BRFdetail);

//					hs.saveOrUpdate(detail);
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


// TO show thw Archieve values
			public ModelAndView getArchieveBRF101View(String reportId, String fromdate, String todate, String currency,
					String dtltype, Pageable pageable) {

				ModelAndView mv = new ModelAndView();
				Session hs = sessionFactory.getCurrentSession();
				int pageSize = pageable.getPageSize();
				int currentPage = pageable.getPageNumber();
				int startItem = currentPage * pageSize;
				List<BRF101_ENTITY> T1rep = new ArrayList<BRF101_ENTITY>();
				// Query<Object[]> qr;

				List<BRF101_ENTITY> T1Master = new ArrayList<BRF101_ENTITY>();
				/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

				logger.info("Inside archive" + currency);

				try {
					Date d1 = df.parse(todate);
					// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

					T1Master = hs.createQuery("from  BRF101_ENTITY a where a.report_date = ?1 ", BRF101_ENTITY.class)
							.setParameter(1, df.parse(todate)).getResultList();

					/*
					 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
					 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
					 */

				} catch (ParseException e) {
					e.printStackTrace();
				}

				// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

				mv.setViewName("RR/BRF101ARCH");
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

			public ModelAndView ARCHgetBRF101currentDtl(String reportId, String fromdate, String todate, String currency,
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
						
						
							qr = hs.createNativeQuery("select * from BRF101_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
							qr.setParameter(1,  df.parse(todate));
							qr.setParameter(2,filter);
								

					} else {
						System.out.println("2");
						qr = hs.createNativeQuery("select * from BRF101_ARCHIVTABLE");

					}
				} else {
					System.out.println("3");
					qr = hs.createNativeQuery("select * from BRF101_ARCHIVTABLE  where report_date = ?1");
				}

				/*
				 * try { qr.setParameter(1, df.parse(todate));
				 * 
				 * } catch (ParseException e) { e.printStackTrace(); }
				 */
				List<BRF101_ARCHIVENTITY> T1Master = new ArrayList<BRF101_ARCHIVENTITY>();

				try {
					System.out.println("Values entered");
					T1Master = hs.createQuery("from BRF101_ARCHIVENTITY a where a.report_date = ?1", BRF101_ARCHIVENTITY.class)
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

					BRF101_ARCHIVENTITY py = new BRF101_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name,
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

				mv.setViewName("RR" + "/" + "BRF101ARCH::reportcontent");
				mv.addObject("reportdetails", T1Dt1Page.getContent());
				mv.addObject("reportmaster", T1Master);
				mv.addObject("reportmaster1", qr);
				mv.addObject("singledetail", new T1CurProdDetail());
				mv.addObject("reportsflag", "reportsflag");
				mv.addObject("menu", reportId);
				return mv;
			}
			
			

}
		
		

	
	
	


