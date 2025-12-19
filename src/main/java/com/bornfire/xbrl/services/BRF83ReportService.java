 package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
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
import java.io.FileOutputStream;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bornfire.xbrl.entities.BRBS.BRF83_ENTITYREP;
import com.bornfire.xbrl.entities.BRBS.BRF155_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF83_ARCHIVENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF83_DETAIL_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRF83_DetailRepo;
import com.bornfire.xbrl.entities.BRBS.BRF83_ENTITY;
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
public class BRF83ReportService {

	
	private static final Logger logger = LoggerFactory.getLogger(BRF83ReportService.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DataSource srcdataSource;
	
	@Autowired
	Environment env;
	
	@Autowired
	BRF83_ENTITYREP BRF83_ENTITY1REP;
	
	
	@Autowired 
	BRF83_DetailRepo brf83_detailrepo;
	
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
			Long dtlcnt = (Long) hs.createQuery("select count(*) from  BRF83_ENTITY a where a.report_date=?1")
					.setParameter(1, dt9).getSingleResult();

			if (dtlcnt > 0) {
				logger.info("Getting No of records in Mod table :" + reportid);
				Long modcnt = (Long) hs.createQuery("select count(*) from  BRF83_ENTITY a").getSingleResult();
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
public ModelAndView getBRF83View(String reportId, String fromdate, String todate, String currency, String dtltype,
		Pageable pageable) {
	
		ModelAndView mv = new ModelAndView();
		Session hs = sessionFactory.getCurrentSession();
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
		// Query<Object[]> qr;

		List<BRF83_ENTITY> T1Master = new ArrayList<BRF83_ENTITY>();
	     List<BRF83_ENTITY> T1rep = new ArrayList<BRF83_ENTITY>(); 

		logger.info("Inside archive" +currency);

		try {
			Date d1 = df.parse(todate);
		//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		/*
		 * T1Master = hs.createQuery("from  BRF83_ENTITY a where a.report_date = ?1 ",
		 * BRF83_ENTITY .class) .setParameter(1, df.parse(todate)).getResultList();
		 */

			
			List<Object[]> T1Master1 = BRF83_ENTITY1REP.findllvalues(todate);
			
			for( Object[] BRF83_ENTITY1 : T1Master1) {
				
				BRF83_ENTITY BRF83 = new BRF83_ENTITY();
				System.out.println(BRF83_ENTITY1[0]);
				BRF83.setExposure(String.valueOf(BRF83_ENTITY1[0]));
				Date from_date = BRF83_ENTITY1[1] != null ? (Date) BRF83_ENTITY1[1] : null;
				BRF83.setFrom_date(from_date );
				Date to_date = BRF83_ENTITY1[2] != null ? (Date) BRF83_ENTITY1[2] : null;
				BRF83.setTo_date(to_date );
				BigDecimal fundos = BRF83_ENTITY1[3] != null ? (BigDecimal) BRF83_ENTITY1[3] : new BigDecimal("0");
				BRF83.setFund_os(fundos);
				BigDecimal debsec = BRF83_ENTITY1[4] != null ? (BigDecimal) BRF83_ENTITY1[4] : new BigDecimal("0");
				BRF83.setDebt_securities(debsec);
				BigDecimal unfundos = BRF83_ENTITY1[5] != null ? (BigDecimal) BRF83_ENTITY1[5] : new BigDecimal("0");
				BRF83.setUnfund_os(unfundos);
				BigDecimal unfundccf = BRF83_ENTITY1[6] != null ? (BigDecimal) BRF83_ENTITY1[6] : new BigDecimal("0");
				BRF83.setUnfund_ccf(unfundccf);
				BigDecimal unusedunfundccf = BRF83_ENTITY1[7] != null ? (BigDecimal) BRF83_ENTITY1[7] : new BigDecimal("0");
				BRF83.setUnused_unfund_ccf(unusedunfundccf);
				BigDecimal totalexposureccf = BRF83_ENTITY1[8] != null ? (BigDecimal) BRF83_ENTITY1[8] : new BigDecimal("0");
				BRF83.setTotal_exposure_ccf(totalexposureccf );
				BigDecimal tier1 = BRF83_ENTITY1[9] != null ? (BigDecimal) BRF83_ENTITY1[9] : new BigDecimal("0");
				BRF83.setTier1_capital(tier1);
				BRF83.setRisk_type(String.valueOf(BRF83_ENTITY1[10]));
				BigDecimal riskhaircut = BRF83_ENTITY1[11] != null ? (BigDecimal) BRF83_ENTITY1[11] : new BigDecimal("0");
				BRF83.setRisk_haircut(riskhaircut);
				BigDecimal collateral = BRF83_ENTITY1[12] != null ? (BigDecimal) BRF83_ENTITY1[12] : new BigDecimal("0");
				BRF83.setCollateral(collateral);
				BRF83.setCbuae(String.valueOf(BRF83_ENTITY1[13]));
				BigDecimal provision = BRF83_ENTITY1[14] != null ? (BigDecimal) BRF83_ENTITY1[14] : new BigDecimal("0");
				BRF83.setProvision(provision);
				BigDecimal totalexporeport = BRF83_ENTITY1[15] != null ? (BigDecimal) BRF83_ENTITY1[15] : new BigDecimal("0");
				BRF83.setTotal_exposure_reporting(totalexporeport);
				BRF83.setRemarks(String.valueOf(BRF83_ENTITY1[16]));
				BigDecimal capitalcase = BRF83_ENTITY1[25] != null ? (BigDecimal) BRF83_ENTITY1[25] : new BigDecimal("0");
				BRF83.setCapital_case(capitalcase);
				BigDecimal entitylevel = BRF83_ENTITY1[26] != null ? (BigDecimal) BRF83_ENTITY1[26] : new BigDecimal("0");
				BRF83.setEntity_level(entitylevel);
				BRF83.setRow_label(String.valueOf(BRF83_ENTITY1[27]));
				System.out.println(BRF83.getRow_label());
				
				
				T1Master.add(BRF83);

		} 
		}catch (ParseException e) {
			e.printStackTrace();
		}

		// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

		mv.setViewName("RR/BRF83");
		// mv.addObject("currlist", refCodeConfig.currList());
		mv.addObject("reportsummary", T1Master);
		
		
		  mv.addObject("getfundos", BRF83_ENTITY1REP.getfundos(todate));
			
			 mv.addObject("getdebtsecurities",BRF83_ENTITY1REP.getdebtsecurities(todate));
				
				  mv.addObject("getunfundos", BRF83_ENTITY1REP.getunfundos(todate));
				  mv.addObject("getunfundccf", BRF83_ENTITY1REP.getunfundccf(todate));
				  mv.addObject("getunusedunfundccf", BRF83_ENTITY1REP.getunusedunfundccf(todate)); 
				  mv.addObject("gettotal", BRF83_ENTITY1REP.gettotal(todate));
				  mv.addObject("gettotal", BRF83_ENTITY1REP.gettotal(todate));
				  mv.addObject("gettier1", BRF83_ENTITY1REP.gettier1(todate));
				  mv.addObject("getcrmafterhaircut", BRF83_ENTITY1REP.getcrmafterhaircut(todate));
				  mv.addObject("getcollateralafterhaircut", BRF83_ENTITY1REP.getcollateralafterhaircut(todate));
				  mv.addObject("getprovision", BRF83_ENTITY1REP.getprovision(todate));
				  mv.addObject("gettotalexposureafterhaircut", BRF83_ENTITY1REP.gettotalexposureafterhaircut(todate));
				  mv.addObject("getcapitalcase", BRF83_ENTITY1REP.getcapitalcase(todate));
				  mv.addObject("getetity", BRF83_ENTITY1REP.getetity(todate));
			 
		 
			/*
			 * Date todate1 = new Date(); String total =
			 * BRF83_ENTITY1REP.gettotalexposure(todate1); mv.addObject("gettotalexposure",
			 * total);
			 */
		/* mv.addObject("reportsummary1", T1Master1); */
		mv.addObject("reportmaster", T1Master);
		mv.addObject("displaymode", "summary");
		mv.addObject("reportsflag", "reportsflag");
		mv.addObject("menu", reportId);
		System.out.println("scv" + mv.getViewName());

		return mv;

	}

public ModelAndView getBRF83Details(String reportId, String fromdate, String todate, String currency,
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
					"select * from BRF83_DETAILTABLE  a where report_date = ?1 and report_label_1=?2");

			qr.setParameter(2, filter);

		} else {
			qr = hs.createNativeQuery("select * from BRF83_DETAILTABLE a where report_date = ?1");

		}
	} else {
		qr = hs.createNativeQuery("select * from BRF83_DETAILTABLE  where report_date = ?1");
	}

	try {
		qr.setParameter(1, df.parse(todate));

	} catch (ParseException e) {
		e.printStackTrace();
	}
	List<BRF83_DETAIL_ENTITY> T1Master = new ArrayList<BRF83_DETAIL_ENTITY>();

	try {
		T1Master = hs.createQuery("from BRF83_DETAIL_ENTITY a where a.report_date = ?1", BRF83_DETAIL_ENTITY.class)
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
		BRF83_DETAIL_ENTITY py = new BRF83_DETAIL_ENTITY(cust_id, foracid, acct_name, acct_crncy_code, gl_code,
				gl_sub_head_code, schm_code, schm_type, sol_id, acid, bacid, report_name_1, report_label_1,
				report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
				modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, report_date,
				version, remarks, legal_entity_type, constitution_desc, segment, sub_segment, sector, sub_sector,
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


	mv.setViewName("RR"+"/"+"BRF83::reportcontent");
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
    String fileName = "011-BRF-083-A";
    File outputFile = null;

    logger.info("Getting Output file: " + reportId);

    fileName = "011-BRF-083-A";
	 

	if (!filetype.equals("xbrl")) {
		if (!filetype.equals("BRF")) {


            try {
                InputStream jasperFile;
                logger.info("Getting Jasper file: " + reportId);

                if (filetype.equals("detailexcel")) {
                    if (dtltype.equals("report")) {
                        jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF83_DETAIL.jrxml");
                    } else {
                        jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF83_DETAIL.jrxml");
                    }

                } else {
                    if (dtltype.equals("report")) {
                        logger.info("Inside report");
                        jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF83.jrxml");
                    } else {
                        jasperFile = this.getClass().getResourceAsStream("/static/jasper/BRF83.jrxml");
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
	} else {
		List<BRF83_ENTITY> T1Master = new ArrayList<>();
		Session hs = sessionFactory.getCurrentSession();
		try {
			Date d1 = df.parse(todate);

			// Retrieve data
            List<Object[]> T1Master1 = BRF83_ENTITY1REP.findllvalues(todate);
			File responseFile = new File(env.getProperty("output.exportpathtemp") + "011-BRF-083-AT.xls");

			// Load the Excel file
			Workbook workbook = WorkbookFactory.create(responseFile);
			Sheet sheet = workbook.getSheetAt(0);

			 if (!T1Master1.isEmpty()) {
	                int startRow = 9;

	                for (int index = 0; index < T1Master1.size(); index++) {
	                    Object[] brf83 = T1Master1.get(index);
	                    Row row = sheet.getRow(startRow + index);
	                    if (row == null) {
	                        row = sheet.createRow(startRow + index);
	                    }

	                    // Populating cells with data
	                    Cell cell = row.getCell(2);
	                    if (cell == null) {
	                        cell = row.createCell(2);
	                    }
	                    String value = (brf83[0] == null) ? "0" : brf83[0].toString();
	                    cell.setCellValue(value);

	                    cell = row.getCell(3);
	                    if (cell == null) {
	                        cell = row.createCell(3);
	                    }
	                    Date dateValue = (Date) brf83[1];
	                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
	                    String formattedDate = (dateValue == null) ? "N/A" : dateFormat1.format(dateValue);
	                    cell.setCellValue(formattedDate);

	                    cell = row.getCell(4);
	                    if (cell == null) {
	                        cell = row.createCell(4);
	                    }
	                    dateValue = (Date) brf83[2];
	                    formattedDate = (dateValue == null) ? "N/A" : dateFormat1.format(dateValue);
	                    cell.setCellValue(formattedDate);

	                    cell = row.getCell(5);
	                    if (cell == null) {
	                        cell = row.createCell(5);
	                    }
	                    cell.setCellValue(brf83[3] == null ? 0 : ((BigDecimal) brf83[3]).intValue());

	                    cell = row.getCell(6);
	                    if (cell == null) {
	                        cell = row.createCell(6);
	                    }
	                    cell.setCellValue(brf83[4] == null ? 0 : ((BigDecimal) brf83[4]).intValue());

	                    cell = row.getCell(7);
	                    if (cell == null) {
	                        cell = row.createCell(7);
	                    }
	                    cell.setCellValue(brf83[5] == null ? 0 : ((BigDecimal) brf83[5]).intValue());

	                    cell = row.getCell(8);
	                    if (cell == null) {
	                        cell = row.createCell(8);
	                    }
	                    cell.setCellValue(brf83[6] == null ? 0 : ((BigDecimal) brf83[6]).intValue());

	                    cell = row.getCell(9);
	                    if (cell == null) {
	                        cell = row.createCell(9);
	                    }
	                    cell.setCellValue(brf83[7] == null ? 0 : ((BigDecimal) brf83[7]).intValue());

	                    cell = row.getCell(10);
	                    if (cell == null) {
	                        cell = row.createCell(10);
	                    }
	                    cell.setCellValue(brf83[8] == null ? 0 : ((BigDecimal) brf83[8]).intValue());

	                    cell = row.getCell(11);
	                    if (cell == null) {
	                        cell = row.createCell(11);
	                    }
	                    cell.setCellValue(brf83[9] == null ? 0 : ((BigDecimal) brf83[9]).intValue());

	                    cell = row.getCell(12);
	                    if (cell == null) {
	                        cell = row.createCell(12);
	                    }
	                    value = (brf83[10] == null) ? "" : brf83[10].toString();
	                    cell.setCellValue(value);

	                    cell = row.getCell(13);
	                    if (cell == null) {
	                        cell = row.createCell(13);
	                    }
	                    cell.setCellValue(brf83[11] == null ? 0 : ((BigDecimal) brf83[11]).intValue());

	                    cell = row.getCell(14);
	                    if (cell == null) {
	                        cell = row.createCell(14);
	                    }
	                    cell.setCellValue(brf83[12] == null ? 0 : ((BigDecimal) brf83[12]).intValue());

	                    cell = row.getCell(15);
	                    if (cell == null) {
	                        cell = row.createCell(15);
	                    }
	                    value = (brf83[13] == null) ? "" : brf83[13].toString();
	                    cell.setCellValue(value);

	                    cell = row.getCell(16);
	                    if (cell == null) {
	                        cell = row.createCell(16);
	                    }
	                    cell.setCellValue(brf83[14] == null ? 0 : ((BigDecimal) brf83[14]).intValue());

	                    cell = row.getCell(17);
	                    if (cell == null) {
	                        cell = row.createCell(17);
	                    }
	                    cell.setCellValue(brf83[15] == null ? 0 : ((BigDecimal) brf83[15]).intValue());

	                    cell = row.getCell(18);
	                    if (cell == null) {
	                        cell = row.createCell(18);
	                    }
	                    value = (brf83[16] == null) ? "" : brf83[16].toString();
	                    cell.setCellValue(value);

	                 
	                }
	                
	                if (!T1Master1.isEmpty()) {
	                    int startRow1 = 7;  // Assuming startRow1 should be used here

	                    for (int index = 0; index < T1Master1.size(); index++) {
	                        Object[] brf83 = T1Master1.get(index);
	                        Row row = sheet.getRow(startRow1 + index);  // Use startRow1 instead of startRow

	                        if (row == null) {
	                            row = sheet.createRow(startRow1 + index);  // Use startRow1 here as well
	                        }

	                        Cell cell1 = row.getCell(3);
	                        if (cell1 == null) {
	                            cell1 = row.createCell(3);
	                        }
	                        cell1.setCellValue(brf83[25] == null ? 0 : ((BigDecimal) brf83[25]).intValue());

	                        Cell cell2 = row.getCell(6);
	                        if (cell2 == null) {
	                            cell2 = row.createCell(6);
	                        }
	                        cell2.setCellValue(brf83[26] == null ? 0 : ((BigDecimal) brf83[26]).intValue());
	                    }
	                }

	                workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
				// Save the changes
				try (FileOutputStream fileOut = new FileOutputStream(
						env.getProperty("output.exportpathfinal") + "011-BRF-083-A.xls")) {
					workbook.write(fileOut);
					System.out.println("File saved successfully at: "
							+ env.getProperty("output.exportpathfinal") + "011-BRF-083-A.xls");
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
outputFile = new File(env.getProperty("output.exportpathfinal") + "011-BRF-083-A.xls");

return outputFile;

}

					
					
			
public String detailChanges83(BRF83_DETAIL_ENTITY detail, String foracid, String report_addl_criteria_1,
		BigDecimal act_balance_amt_lc, String report_label_1, String report_name_1) {

	String msg = "";

	try {

		Session hs = sessionFactory.getCurrentSession();
		Optional<BRF83_DETAIL_ENTITY> Brf83detail =brf83_detailrepo.findById(foracid);

		if (Brf83detail.isPresent()) {
			BRF83_DETAIL_ENTITY BRFdetail = Brf83detail.get();

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
				brf83_detailrepo.save(BRFdetail);

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
public ModelAndView getArchieveBRF083View(String reportId, String fromdate, String todate, String currency,
		String dtltype, Pageable pageable) {

	ModelAndView mv = new ModelAndView();
	Session hs = sessionFactory.getCurrentSession();
	int pageSize = pageable.getPageSize();
	int currentPage = pageable.getPageNumber();
	int startItem = currentPage * pageSize;
	/* List<BRF036_ENTITY> T1rep = new ArrayList<BRF036_ENTITY>(); */
	// Query<Object[]> qr;

	List<BRF83_ENTITY> T1Master = new ArrayList<BRF83_ENTITY>();
     List<BRF83_ENTITY> T1rep = new ArrayList<BRF83_ENTITY>(); 

	logger.info("Inside archive" +currency);

	try {
		Date d1 = df.parse(todate);
	//	T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	/*
	 * T1Master = hs.createQuery("from  BRF83_ENTITY a where a.report_date = ?1 ",
	 * BRF83_ENTITY .class) .setParameter(1, df.parse(todate)).getResultList();
	 */

		
		List<Object[]> T1Master1 = BRF83_ENTITY1REP.findllvalues(todate);
		
		for( Object[] BRF83_ENTITY1 : T1Master1) {
			
			BRF83_ENTITY BRF83 = new BRF83_ENTITY();
			System.out.println(BRF83_ENTITY1[0]);
			BRF83.setExposure(String.valueOf(BRF83_ENTITY1[0]));
			Date from_date = BRF83_ENTITY1[1] != null ? (Date) BRF83_ENTITY1[1] : null;
			BRF83.setFrom_date(from_date );
			Date to_date = BRF83_ENTITY1[2] != null ? (Date) BRF83_ENTITY1[2] : null;
			BRF83.setTo_date(to_date );
			BigDecimal fundos = BRF83_ENTITY1[3] != null ? (BigDecimal) BRF83_ENTITY1[3] : new BigDecimal("0");
			BRF83.setFund_os(fundos);
			BigDecimal debsec = BRF83_ENTITY1[4] != null ? (BigDecimal) BRF83_ENTITY1[4] : new BigDecimal("0");
			BRF83.setDebt_securities(debsec);
			BigDecimal unfundos = BRF83_ENTITY1[5] != null ? (BigDecimal) BRF83_ENTITY1[5] : new BigDecimal("0");
			BRF83.setUnfund_os(unfundos);
			BigDecimal unfundccf = BRF83_ENTITY1[6] != null ? (BigDecimal) BRF83_ENTITY1[6] : new BigDecimal("0");
			BRF83.setUnfund_ccf(unfundccf);
			BigDecimal unusedunfundccf = BRF83_ENTITY1[7] != null ? (BigDecimal) BRF83_ENTITY1[7] : new BigDecimal("0");
			BRF83.setUnused_unfund_ccf(unusedunfundccf);
			BigDecimal totalexposureccf = BRF83_ENTITY1[8] != null ? (BigDecimal) BRF83_ENTITY1[8] : new BigDecimal("0");
			BRF83.setTotal_exposure_ccf(totalexposureccf );
			BigDecimal tier1 = BRF83_ENTITY1[9] != null ? (BigDecimal) BRF83_ENTITY1[9] : new BigDecimal("0");
			BRF83.setTier1_capital(tier1);
			BRF83.setRisk_type(String.valueOf(BRF83_ENTITY1[10]));
			BigDecimal riskhaircut = BRF83_ENTITY1[11] != null ? (BigDecimal) BRF83_ENTITY1[11] : new BigDecimal("0");
			BRF83.setRisk_haircut(riskhaircut);
			BigDecimal collateral = BRF83_ENTITY1[12] != null ? (BigDecimal) BRF83_ENTITY1[12] : new BigDecimal("0");
			BRF83.setCollateral(collateral);
			BRF83.setCbuae(String.valueOf(BRF83_ENTITY1[13]));
			BigDecimal provision = BRF83_ENTITY1[14] != null ? (BigDecimal) BRF83_ENTITY1[14] : new BigDecimal("0");
			BRF83.setProvision(provision);
			BigDecimal totalexporeport = BRF83_ENTITY1[15] != null ? (BigDecimal) BRF83_ENTITY1[15] : new BigDecimal("0");
			BRF83.setTotal_exposure_reporting(totalexporeport);
			BRF83.setRemarks(String.valueOf(BRF83_ENTITY1[16]));
			BRF83.setRow_label(String.valueOf(BRF83_ENTITY1[27]));
			System.out.println(BRF83.getRow_label());

	
			T1Master.add(BRF83);

	} 
	}catch (ParseException e) {
		e.printStackTrace();
	}

	// T1rep = t1CurProdServiceRepo.getT1CurProdServices(d1);

	mv.setViewName("RR/BRF83ARCH");
	// mv.addObject("currlist", refCodeConfig.currList());
	mv.addObject("reportsummary", T1Master);
	
	
	  mv.addObject("getfundos", BRF83_ENTITY1REP.getfundos(todate));
		
		 mv.addObject("getdebtsecurities",BRF83_ENTITY1REP.getdebtsecurities(todate));
			
			  mv.addObject("getunfundos", BRF83_ENTITY1REP.getunfundos(todate));
			  mv.addObject("getunfundccf", BRF83_ENTITY1REP.getunfundccf(todate));
			  mv.addObject("getunusedunfundccf", BRF83_ENTITY1REP.getunusedunfundccf(todate)); 
			  mv.addObject("gettotal", BRF83_ENTITY1REP.gettotal(todate));
			  mv.addObject("gettotal", BRF83_ENTITY1REP.gettotal(todate));
			  mv.addObject("gettier1", BRF83_ENTITY1REP.gettier1(todate));
			  mv.addObject("getcrmafterhaircut", BRF83_ENTITY1REP.getcrmafterhaircut(todate));
			  mv.addObject("getcollateralafterhaircut", BRF83_ENTITY1REP.getcollateralafterhaircut(todate));
			  mv.addObject("getprovision", BRF83_ENTITY1REP.getprovision(todate));
			  mv.addObject("gettotalexposureafterhaircut", BRF83_ENTITY1REP.gettotalexposureafterhaircut(todate));
			 
		 
	 
		/*
		 * Date todate1 = new Date(); String total =
		 * BRF83_ENTITY1REP.gettotalexposure(todate1); mv.addObject("gettotalexposure",
		 * total);
		 */
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

public ModelAndView ARCHgetBRF083currentDtl(String reportId, String fromdate, String todate, String currency,
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

			qr = hs.createNativeQuery("select * from BRF83_ARCHIVTABLE a where report_date=?1 and report_label_1=?2");
			qr.setParameter(1, df.parse(todate));
			qr.setParameter(2, filter);

		} else {
			System.out.println("2");
			qr = hs.createNativeQuery("select * from BRF83_ARCHIVTABLE");

		}
	} else {
		System.out.println("3");
		qr = hs.createNativeQuery("select * from BRF83_ARCHIVTABLE  where report_date = ?1");
	}

	/*
	 * try { qr.setParameter(1, df.parse(todate));
	 * 
	 * } catch (ParseException e) { e.printStackTrace(); }
	 */
	List<BRF83_ARCHIVENTITY> T1Master = new ArrayList<BRF83_ARCHIVENTITY>();

	try {
		System.out.println("Values entered");
		T1Master = hs.createQuery("from BRF83_ARCHIVENTITY a where a.report_date = ?1", BRF83_ARCHIVENTITY.class)
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
		 System.out.println("Cns Code: " + constitution_code);
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
		BRF83_ARCHIVENTITY py = new BRF83_ARCHIVENTITY(cust_id, foracid, acct_name, acct_crncy_code, gl_code,
				gl_sub_head_code, schm_code, schm_type, sol_id, acid, bacid, report_name_1, report_label_1,
				report_addl_criteria_1, report_addl_criteria_2, report_addl_criteria_3, create_user, create_time,
				modify_user, modify_time, verify_user, verify_time, entity_flg, modify_flg, del_flg, report_date,
				version, remarks, legal_entity_type, constitution_desc, segment, sub_segment, sector, sub_sector,
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

	mv.setViewName("RR" + "/" + "BRF83ARCH::reportcontent");
	mv.addObject("reportdetails", T1Dt1Page.getContent());
	mv.addObject("reportmaster", T1Master);
	mv.addObject("reportmaster1", qr);
	mv.addObject("singledetail", new T1CurProdDetail());
	mv.addObject("reportsflag", "reportsflag");
	mv.addObject("menu", reportId);
	return mv;
}

}