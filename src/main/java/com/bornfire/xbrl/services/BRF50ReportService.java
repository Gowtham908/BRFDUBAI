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
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.BRBS.BRF34_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF44_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF50_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF50_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF50_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF50_Entity;
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
public class BRF50ReportService {

	
	private static final Logger logger = LoggerFactory.getLogger(BRF50ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired 
	BRF50_DetailRepo brf50_detailrepo;
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	public String preCheck(String reportid, String fromdate, String todate) {
		
		String msg = "";
		Session hs = sessionFactory.getCurrentSession();
		Date dt1;
		Date dt9;
		logger.info("Report precheck : " + reportid);

		try {
			
			dt9 = new SimpleDateFormat("dd/MM/yyyy").parse(todate);
			logger.info("Getting No of records in Master table :" + reportid);
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF50_Entity a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF50_Entity a").getSingleResult();
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
public ModelAndView getBRF50View(String reportId, String fromdate, String todate, String currency, String dtltype,
		Pageable pageable) {
	
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF50_Entity> T1Master = new ArrayList<BRF50_Entity>();
	     List<BRF50_Entity> T1Master1 = new ArrayList<BRF50_Entity>(); 

		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF50_Entity a where a.report_date = ?1 ", BRF50_Entity .class)
					.setParameter(1, df.parse(todate)).getResultList();

			
			/*
			 * T1Master1 = hs.createQuery("from BRF47_Entity a where a.report_date = ?1 ",
			 * BRF40_Entity2.class) .setParameter(1, df.parse(todate)).getResultList();
			 */
			 

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF50");
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

public ModelAndView getBRF50currentDtl(String reportId, String fromdate, String todate, String currency,
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
					"select * from BRF50_DETAILTABLE  a where report_date = ?1 and report_label_1 =?2");

			qr.setParameter(2, filter);

		} else {
			qr = hs.createNativeQuery("select * from BRF50_DETAILTABLE a where report_date = ?1");

		}
	} else {
		qr = hs.createNativeQuery("select * from BRF50_DETAILTABLE  where report_date = ?1");
	}

	try {
		qr.setParameter(1, df.parse(todate));

	} catch (ParseException e) {
		e.printStackTrace();
	}
	List<BRF50_DETAIL_ENTITY> T1Master = new ArrayList<BRF50_DETAIL_ENTITY>();

	try {
		T1Master = hs.createQuery("from BRF50_DETAIL_ENTITY a where a.report_date = ?1", BRF50_DETAIL_ENTITY.class)
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
		String gender = (String)a[46];
		String version = (String) a[47];
		String remarks = (String) a[48];
		String nre_flg = (String) a[49];
		BigDecimal interest_expenses = (BigDecimal) a[50];
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

		BRF50_DETAIL_ENTITY py = new BRF50_DETAIL_ENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
			    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
			    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
			    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
			    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
			    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
			    gender, version, remarks,nre_flg,interest_expenses);
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

	mv.setViewName("RR"+"/"+"BRF50::reportcontent");
	// mv.setViewName("ReportT1");
	mv.addObject("reportdetails", T1Dt1Page);
	mv.addObject("reportmaster", T1Master);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}
public File getFileBRF50(String reportId, String fromdate, String todate, String currency, String dtltype,
		String filetype) throws FileNotFoundException, JRException, SQLException {


	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	String path = this.env.getProperty("output.exportpath");
	String fileName = "";
	String zipFileName = "";
	File outputFile;

	logger.info("Getting Output file :" + reportId);
	fileName = "011-BRF-050-A";

	if (!filetype.equals("xbrl")) {
		if (!filetype.equals("BRF")) {
		try {
			InputStream jasperFile;
			logger.info("Getting Jasper file :" + reportId);
			if (filetype.equals("detailexcel")) {
				if (dtltype.equals("report")) {

					jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF50_Detail.jrxml");
				} else {
					jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF50_Detail.jrxml");
				}
			
			} else {
				if (dtltype.equals("report")) {
					logger.info("Inside report");
				
					jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF50.jrxml");
				} else {
					jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF50.jrxml");
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
			
			List<BRF50_Entity> T1Master = new ArrayList<BRF50_Entity>();
			Session hs = sessionFactory.getCurrentSession();
			try {
				Date d1 = df.parse(todate);
			
			// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

			T1Master = hs.createQuery("from  BRF50_Entity a where a.report_date = ?1 ", BRF50_Entity.class)
					.setParameter(1, df.parse(todate)).getResultList();
			
			if(T1Master.size() == 1) {
				
				for(BRF50_Entity BRF50 : T1Master ) {
			
			File Responsecamt = new File(env.getProperty("output.exportpathtemp")+"011-BRF-050-AT.xls");
			
			  // Load the Excel file
        	Workbook workbook = WorkbookFactory.create(Responsecamt);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(10);
       	 Cell cell = row.getCell(4);
       	 if (cell != null) {
            cell.setCellValue(BRF50.getR11_amount_outstainding() == null ? 0 :
       	     	BRF50.getR11_amount_outstainding().intValue());
       	 }

       	 Cell cell1 = row.getCell(5);
       	 if (cell1 != null) {
            cell1.setCellValue(BRF50.getR11_interest_expense() == null ? 0 :
       	     	BRF50.getR11_interest_expense().intValue());
       	 }
     	 
//////////////////////R12/////////////////////////

Row R1row = sheet.getRow(11);
Cell R1cell = R1row.getCell(4);
if (R1cell != null) {
R1cell.setCellValue(BRF50.getR12_amount_outstainding() == null ? 0 :
   	BRF50.getR12_amount_outstainding().intValue());
}

Cell R1cell1 = R1row.getCell(5);
if (R1cell1 != null) {
R1cell1.setCellValue(BRF50.getR12_interest_expense() == null ? 0 :
   	BRF50.getR12_interest_expense().intValue());
}

//////////////////////R14/////////////////////////

Row R2row = sheet.getRow(13);
Cell R2cell = R2row.getCell(4);
if (R2cell != null) {
R2cell.setCellValue(BRF50.getR14_amount_outstainding() == null ? 0 :
BRF50.getR14_amount_outstainding().intValue());
}

Cell R2cell1 = R2row.getCell(5);
if (R2cell1 != null) {
R2cell1.setCellValue(BRF50.getR14_interest_expense() == null ? 0 :
BRF50.getR14_interest_expense().intValue());
}

//////////////////////R15/////////////////////////

Row R3row = sheet.getRow(14);
Cell R3cell = R3row.getCell(4);
if (R3cell != null) {
R3cell.setCellValue(BRF50.getR15_amount_outstainding() == null ? 0 :
BRF50.getR15_amount_outstainding().intValue());
}

Cell R3cell1 = R3row.getCell(5);
if (R3cell1 != null) {
R3cell1.setCellValue(BRF50.getR15_interest_expense() == null ? 0 :
BRF50.getR15_interest_expense().intValue());
}

//////////////////////R18/////////////////////////

Row R4row = sheet.getRow(17);
Cell R4cell = R4row.getCell(4);
if (R4cell != null) {
R4cell.setCellValue(BRF50.getR18_amount_outstainding() == null ? 0 :
BRF50.getR18_amount_outstainding().intValue());
}

Cell R4cell1 = R4row.getCell(5);
if (R4cell1 != null) {
R4cell1.setCellValue(BRF50.getR18_interest_expense() == null ? 0 :
BRF50.getR18_interest_expense().intValue());
}

//////////////////////R19/////////////////////////

Row R5row = sheet.getRow(18);
Cell R5cell = R5row.getCell(4);
if (R5cell != null) {
R5cell.setCellValue(BRF50.getR19_amount_outstainding() == null ? 0 :
BRF50.getR19_amount_outstainding().intValue());
}

Cell R5cell1 = R5row.getCell(5);
if (R5cell1 != null) {
R5cell1.setCellValue(BRF50.getR19_interest_expense() == null ? 0 :
BRF50.getR19_interest_expense().intValue());
}

//////////////////////R21/////////////////////////

Row R6row = sheet.getRow(20);
Cell R6cell = R6row.getCell(4);
if (R6cell != null) {
R6cell.setCellValue(BRF50.getR21_amount_outstainding() == null ? 0 :
BRF50.getR21_amount_outstainding().intValue());
}

Cell R6cell1 = R6row.getCell(5);
if (R6cell1 != null) {
R6cell1.setCellValue(BRF50.getR21_interest_expense() == null ? 0 :
BRF50.getR21_interest_expense().intValue());
}

//////////////////////R22/////////////////////////

Row R7row = sheet.getRow(21);
Cell R7cell = R7row.getCell(4);
if (R7cell != null) {
R7cell.setCellValue(BRF50.getR22_amount_outstainding() == null ? 0 :
BRF50.getR22_amount_outstainding().intValue());
}

Cell R7cell1 = R7row.getCell(5);
if (R7cell1 != null) {
R7cell1.setCellValue(BRF50.getR22_interest_expense() == null ? 0 :
BRF50.getR22_interest_expense().intValue());
}

//////////////////////R24/////////////////////////

Row R8row = sheet.getRow(21);
Cell R8cell = R8row.getCell(4);
if (R8cell != null) {
R8cell.setCellValue(BRF50.getR24_amount_outstainding() == null ? 0 :
BRF50.getR24_amount_outstainding().intValue());
}

Cell R8cell1 = R8row.getCell(5);
if (R8cell1 != null) {
R8cell1.setCellValue(BRF50.getR24_interest_expense() == null ? 0 :
BRF50.getR24_interest_expense().intValue());
}

//////////////////////R24/////////////////////////

Row R9row = sheet.getRow(23);
Cell R9cell = R9row.getCell(4);
if (R9cell != null) {
R9cell.setCellValue(BRF50.getR24_amount_outstainding() == null ? 0 :
BRF50.getR24_amount_outstainding().intValue());
}

Cell R9cell1 = R9row.getCell(5);
if (R9cell1 != null) {
R9cell1.setCellValue(BRF50.getR24_interest_expense() == null ? 0 :
BRF50.getR24_interest_expense().intValue());
}

//////////////////////R27/////////////////////////

Row R10row = sheet.getRow(26);
Cell R10cell = R10row.getCell(4);
if (R10cell != null) {
R10cell.setCellValue(BRF50.getR27_amount_outstainding() == null ? 0 :
BRF50.getR27_amount_outstainding().intValue());
}

Cell R10cell1 = R10row.getCell(5);
if (R10cell1 != null) {
R10cell1.setCellValue(BRF50.getR27_interest_expense() == null ? 0 :
BRF50.getR27_interest_expense().intValue());
}

//////////////////////R28/////////////////////////

Row R11row = sheet.getRow(27);
Cell R11cell = R11row.getCell(4);
if (R11cell != null) {
R11cell.setCellValue(BRF50.getR28_amount_outstainding() == null ? 0 :
BRF50.getR28_amount_outstainding().intValue());
}

Cell R11cell1 = R11row.getCell(5);
if (R11cell1 != null) {
R11cell1.setCellValue(BRF50.getR28_interest_expense() == null ? 0 :
BRF50.getR28_interest_expense().intValue());
}

//////////////////////R30/////////////////////////

Row R12row = sheet.getRow(29);
Cell R12cell = R12row.getCell(4);
if (R12cell != null) {
R12cell.setCellValue(BRF50.getR30_amount_outstainding() == null ? 0 :
BRF50.getR30_amount_outstainding().intValue());
}

Cell R12cell1 = R12row.getCell(5);
if (R12cell1 != null) {
R12cell1.setCellValue(BRF50.getR30_interest_expense() == null ? 0 :
BRF50.getR30_interest_expense().intValue());
}

//////////////////////R31/////////////////////////

Row R13row = sheet.getRow(30);
Cell R13cell = R13row.getCell(4);
if (R13cell != null) {
R13cell.setCellValue(BRF50.getR31_amount_outstainding() == null ? 0 :
BRF50.getR31_amount_outstainding().intValue());
}

Cell R13cell1 = R13row.getCell(5);
if (R13cell1 != null) {
R13cell1.setCellValue(BRF50.getR31_interest_expense() == null ? 0 :
BRF50.getR31_interest_expense().intValue());
}

//////////////////////R34/////////////////////////

Row R14row = sheet.getRow(33);
Cell R14cell = R14row.getCell(4);
if (R14cell != null) {
R14cell.setCellValue(BRF50.getR34_amount_outstainding() == null ? 0 :
BRF50.getR34_amount_outstainding().intValue());
}

Cell R14cell1 = R14row.getCell(5);
if (R14cell1 != null) {
R14cell1.setCellValue(BRF50.getR34_interest_expense() == null ? 0 :
BRF50.getR34_interest_expense().intValue());
}

//////////////////////R35/////////////////////////

Row R15row = sheet.getRow(34);
Cell R15cell = R15row.getCell(4);
if (R15cell != null) {
R15cell.setCellValue(BRF50.getR35_amount_outstainding() == null ? 0 :
BRF50.getR35_amount_outstainding().intValue());
}

Cell R15cell1 = R15row.getCell(5);
if (R15cell1 != null) {
R15cell1.setCellValue(BRF50.getR35_interest_expense() == null ? 0 :
BRF50.getR35_interest_expense().intValue());
}

//////////////////////R37/////////////////////////

Row R16row = sheet.getRow(36);
Cell R16cell = R16row.getCell(4);
if (R16cell != null) {
R16cell.setCellValue(BRF50.getR37_amount_outstainding() == null ? 0 :
BRF50.getR37_amount_outstainding().intValue());
}

Cell R16cell1 = R16row.getCell(5);
if (R16cell1 != null) {
R16cell1.setCellValue(BRF50.getR37_interest_expense() == null ? 0 :
BRF50.getR37_interest_expense().intValue());
}

//////////////////////R38/////////////////////////

Row R17row = sheet.getRow(37);
Cell R17cell = R17row.getCell(4);
if (R17cell != null) {
R17cell.setCellValue(BRF50.getR38_amount_outstainding() == null ? 0 :
BRF50.getR38_amount_outstainding().intValue());
}

Cell R17cell1 = R17row.getCell(5);
if (R17cell1 != null) {
R17cell1.setCellValue(BRF50.getR38_interest_expense() == null ? 0 :
BRF50.getR38_interest_expense().intValue());
}

//////////////////////R40/////////////////////////

Row R18row = sheet.getRow(39);
Cell R18cell = R18row.getCell(4);
if (R18cell != null) {
R18cell.setCellValue(BRF50.getR40_amount_outstainding() == null ? 0 :
BRF50.getR40_amount_outstainding().intValue());
}

Cell R18cell1 = R18row.getCell(5);
if (R18cell1 != null) {
R18cell1.setCellValue(BRF50.getR40_interest_expense() == null ? 0 :
BRF50.getR40_interest_expense().intValue());
}

//////////////////////R43/////////////////////////

Row R19row = sheet.getRow(42);
Cell R19cell = R19row.getCell(4);
if (R19cell != null) {
R19cell.setCellValue(BRF50.getR43_amount_outstainding() == null ? 0 :
BRF50.getR43_amount_outstainding().intValue());
}

Cell R19cell1 = R19row.getCell(5);
if (R19cell1 != null) {
R19cell1.setCellValue(BRF50.getR43_interest_expense() == null ? 0 :
BRF50.getR43_interest_expense().intValue());
}

//////////////////////R44/////////////////////////

Row R20row = sheet.getRow(43);
Cell R20cell = R20row.getCell(4);
if (R20cell != null) {
R20cell.setCellValue(BRF50.getR44_amount_outstainding() == null ? 0 :
BRF50.getR44_amount_outstainding().intValue());
}

Cell R20cell1 = R20row.getCell(5);
if (R20cell1 != null) {
R20cell1.setCellValue(BRF50.getR44_interest_expense() == null ? 0 :
BRF50.getR44_interest_expense().intValue());
}

//////////////////////R45/////////////////////////

Row R21row = sheet.getRow(44);
Cell R21cell = R21row.getCell(4);
if (R21cell != null) {
R21cell.setCellValue(BRF50.getR45_amount_outstainding() == null ? 0 :
BRF50.getR45_amount_outstainding().intValue());
}

Cell R21cell1 = R21row.getCell(5);
if (R21cell1 != null) {
R21cell1.setCellValue(BRF50.getR45_interest_expense() == null ? 0 :
BRF50.getR45_interest_expense().intValue());
}

//////////////////////R46/////////////////////////

Row R22row = sheet.getRow(45);
Cell R22cell = R22row.getCell(4);
if (R22cell != null) {
R22cell.setCellValue(BRF50.getR46_amount_outstainding() == null ? 0 :
BRF50.getR46_amount_outstainding().intValue());
}

Cell R22cell1 = R22row.getCell(5);
if (R22cell1 != null) {
R22cell1.setCellValue(BRF50.getR46_interest_expense() == null ? 0 :
BRF50.getR46_interest_expense().intValue());
}

//////////////////////R49/////////////////////////

Row R23row = sheet.getRow(48);
Cell R23cell = R23row.getCell(4);
if (R23cell != null) {
R23cell.setCellValue(BRF50.getR49_amount_outstainding() == null ? 0 :
BRF50.getR49_amount_outstainding().intValue());
}

Cell R23cell1 = R23row.getCell(5);
if (R23cell1 != null) {
R23cell1.setCellValue(BRF50.getR49_interest_expense() == null ? 0 :
BRF50.getR49_interest_expense().intValue());
}


//////////////////////R50/////////////////////////

Row R24row = sheet.getRow(49);
Cell R24cell = R24row.getCell(4);
if (R24cell != null) {
R24cell.setCellValue(BRF50.getR50_amount_outstainding() == null ? 0 :
BRF50.getR50_amount_outstainding().intValue());
}

Cell R24cell1 = R24row.getCell(5);
if (R24cell1 != null) {
R24cell1.setCellValue(BRF50.getR50_interest_expense() == null ? 0 :
BRF50.getR50_interest_expense().intValue());
}

//////////////////////R52/////////////////////////

Row R25row = sheet.getRow(51);
Cell R25cell = R25row.getCell(4);
if (R25cell != null) {
R25cell.setCellValue(BRF50.getR52_amount_outstainding() == null ? 0 :
BRF50.getR52_amount_outstainding().intValue());
}

Cell R25cell1 = R25row.getCell(5);
if (R25cell1 != null) {
R25cell1.setCellValue(BRF50.getR52_interest_expense() == null ? 0 :
BRF50.getR52_interest_expense().intValue());
}



       	 
       	 // Save the changes
       	workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
            FileOutputStream fileOut = new FileOutputStream(env.getProperty("output.exportpathfinal")+"011-BRF-050-A.xls");
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
	outputFile = new File(env.getProperty("output.exportpathfinal")+"011-BRF-050-A.xls");

	return outputFile;



}

public String detailChanges50(BRF50_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
		BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	String msg = "";

	try {

		Session hs = sessionFactory.getCurrentSession();
		Optional<BRF50_DETAIL_ENTITY> Brf50detail =brf50_detailrepo.findById(foracid);

		if (Brf50detail.isPresent()) {
			BRF50_DETAIL_ENTITY BRFdetail = Brf50detail.get();

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
				brf50_detailrepo.save(BRFdetail);

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
public ModelAndView getArchieveBRF050View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	List<BRF50_Entity> T1rep = new ArrayList<>();
	// Query<Object[]> qr;

	List<BRF50_Entity> T1Master = new ArrayList<BRF50_Entity>();
	/* List<BRF73_TABLE2> T1Master1 = new ArrayList<BRF73_TABLE2>(); */

	logger.info("Inside archive" + currency);

	try {
		Date d1 = df.parse(todate);
		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		T1Master = hs.createQuery("from  BRF50_Entity a where a.report_date = ?1 ", BRF50_Entity.class)
				.setParameter(1, df.parse(todate)).getResultList();

		/*
		 * T1Master1 = hs.createQuery("from BRF73_TABLE2 a where a.report_date = ?1 ",
		 * BRF73_TABLE2.class) .setParameter(1, df.parse(todate)).getResultList();
		 */

	} catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF50ARCH");
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

public ModelAndView ARCHgetBRF050currentDtl(String reportId, String fromdate, String todate, String currency,
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
					"select * from BRF50_ARCHIVTABLE  a where report_date = ?1 and report_label_1 =?2");

			qr.setParameter(2, filter);

		} else {
			qr = hs.createNativeQuery("select * from BRF50_ARCHIVTABLE a where report_date = ?1");

		}
	} else {
		qr = hs.createNativeQuery("select * from BRF50_ARCHIVTABLE  where report_date = ?1");
	}

	try {
		qr.setParameter(1, df.parse(todate));

	} catch (ParseException e) {
		e.printStackTrace();
	}
	List<BRF50_ARCHIVENTITY> T1Master = new ArrayList<BRF50_ARCHIVENTITY>();

	try {
		T1Master = hs.createQuery("from BRF50_ARCHIVENTITY a where a.report_date = ?1", BRF50_ARCHIVENTITY.class)
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
		String gender = (String)a[46];
		String version = (String) a[47];
		String remarks = (String) a[48];
		String nre_flg = (String) a[49];
		BigDecimal interest_expenses = (BigDecimal) a[50];
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

		BRF50_ARCHIVENTITY py = new BRF50_ARCHIVENTITY(cust_id, foracid, act_balance_amt_lc, eab_lc, acct_name, acct_crncy_code, gl_code, gl_sub_head_code,
			    gl_sub_head_desc, country_of_incorp, cust_type, schm_code, schm_type, sol_id, acid, segment, sub_segment,
			    sector, sub_sector, sector_code, group_id, constitution_code, country, legal_entity_type, constitution_desc,
			    purpose_of_advn, hni_networth, turnover, bacid, report_name_1, report_label_1, report_addl_criteria_1,
			    report_addl_criteria_2, report_addl_criteria_3, create_user, create_time, modify_user, modify_time,
			    verify_user, verify_time, entity_flg, modify_flg, del_flg, nre_status, report_date, maturity_date,
			    gender, version, remarks,nre_flg,interest_expenses);
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


	

	mv.setViewName("RR" + "/" + "BRF50ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}


}
